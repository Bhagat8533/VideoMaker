package com.introvd.template.common.p236ui.custom;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.p024v7.widget.LinearLayoutManager;
import android.support.p024v7.widget.RecyclerView;
import android.support.p024v7.widget.RecyclerView.C1034u;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.afollestad.materialdialogs.C1885b;
import com.afollestad.materialdialogs.C1890f;
import com.afollestad.materialdialogs.C1890f.C1904j;
import com.introvd.template.R;
import com.introvd.template.app.p177b.C3742b;
import com.introvd.template.app.p199v5.videoexplore.C4453b;
import com.introvd.template.app.p199v5.videoexplore.VideoExploreCardView;
import com.introvd.template.app.videoplayer.C4469b;
import com.introvd.template.common.AppPreferencesSetting;
import com.introvd.template.common.Constants;
import com.introvd.template.common.DeviceInfo;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.common.MSize;
import com.introvd.template.common.ToastUtils;
import com.introvd.template.datacenter.BaseSocialNotify;
import com.introvd.template.p203b.C4583d;
import com.introvd.template.p203b.C4600l;
import com.introvd.template.p414ui.dialog.C8978m;
import com.quvideo.xyvideoplayer.library.C9196b;
import com.quvideo.xyvideoplayer.library.C9213h;
import org.json.JSONException;
import org.json.JSONObject;
import p503cz.msebera.android.httpclient.HttpStatus;

/* renamed from: com.introvd.template.common.ui.custom.VideoAutoPlayHelper */
public class VideoAutoPlayHelper {
    /* access modifiers changed from: private */
    public static volatile boolean chi = false;
    private static boolean chj = true;
    private static boolean chk = true;

    public static void autoPlayFirstVideo(RecyclerView recyclerView, int i) {
        int findFirstVisibleItemPosition = i - ((LinearLayoutManager) recyclerView.getLayoutManager()).findFirstVisibleItemPosition();
        autoPlayVideoV2(recyclerView, findFirstVisibleItemPosition, findFirstVisibleItemPosition);
    }

    public static int autoPlayVideoV2(RecyclerView recyclerView, int i, int i2) {
        View view;
        C4453b bVar;
        Rect rect = new Rect();
        MSize screenSize = DeviceInfo.getScreenSize(recyclerView.getContext());
        rect.left = 0;
        rect.right = screenSize.width;
        rect.top = C4583d.dpFloatToPixel(recyclerView.getContext(), 42.0f);
        rect.bottom = screenSize.height;
        C4453b bVar2 = null;
        C4453b bVar3 = null;
        int i3 = -1;
        float f = 0.0f;
        for (int i4 = 0; i4 <= i2 - i; i4++) {
            if (recyclerView.getChildAt(i4) != null) {
                C1034u av = recyclerView.mo7766av(recyclerView.getChildAt(i4));
                if (av != null) {
                    if (av.itemView instanceof VideoExploreCardView) {
                        VideoExploreCardView videoExploreCardView = (VideoExploreCardView) av.itemView;
                        view = videoExploreCardView.getVideoView();
                        bVar = (videoExploreCardView.getTag() == null || !(videoExploreCardView.getTag() instanceof C4453b)) ? null : (C4453b) videoExploreCardView.getTag();
                    } else {
                        bVar = null;
                        view = null;
                    }
                    if (bVar != null) {
                        float g = C4469b.m11340g(view, rect);
                        StringBuilder sb = new StringBuilder();
                        sb.append("getViewDisplayPoint ");
                        sb.append(i4);
                        sb.append(" : ");
                        sb.append(g);
                        LogUtilsV2.m14230i(sb.toString());
                        if (g > f) {
                            int i5 = (g > 0.6f ? 1 : (g == 0.6f ? 0 : -1));
                            if (i5 > 0 && !bVar.isPlaying() && canAutoPlay(recyclerView.getContext())) {
                                bVar2 = bVar;
                            }
                            if (i5 > 0) {
                                i3 = i + i4;
                            }
                            f = g;
                        }
                        if (g < 0.6f && bVar.isPlaying()) {
                            bVar3 = bVar;
                        }
                    }
                }
            }
        }
        if (bVar2 != null) {
            bVar2.mo24619i(recyclerView.getContext(), true);
        } else if (bVar3 != null) {
            bVar3.resetPlayer();
        }
        return i3;
    }

    /* renamed from: b */
    private static boolean m14494b(View view, Rect rect, Rect rect2) {
        Rect rect3 = new Rect();
        Rect rect4 = new Rect();
        rect3.left = rect.left;
        rect3.top = rect2.centerY() - (view.getMeasuredHeight() / 6);
        rect3.right = rect.right;
        rect3.bottom = rect2.centerY();
        rect4.left = rect.left;
        rect4.top = rect2.centerY();
        rect4.right = rect.right;
        rect4.bottom = rect2.centerY() + (view.getMeasuredHeight() / 6);
        return rect.contains(rect3) || rect.contains(rect4);
    }

    public static boolean canAutoPlay(Context context) {
        String activeNetworkName = BaseSocialNotify.getActiveNetworkName(context);
        return C3742b.m9111II().mo23123IQ() || (!TextUtils.isEmpty(activeNetworkName) && activeNetworkName.equals(BaseSocialNotify.CONNECTIVITY_NAME_WIFI));
    }

    /* renamed from: ct */
    private static Rect m14495ct(View view) {
        Rect rect = new Rect();
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        rect.left = iArr[0];
        rect.right = rect.left + view.getMeasuredWidth();
        int measuredHeight = iArr[1] + (view.getMeasuredHeight() / 2);
        rect.top = measuredHeight - (view.getMeasuredWidth() / 2);
        rect.bottom = measuredHeight + (view.getMeasuredWidth() / 2);
        return rect;
    }

    /* renamed from: h */
    private static boolean m14496h(View view, Rect rect) {
        if (view == null || rect == null) {
            return false;
        }
        Rect ct = m14495ct(view);
        if (ct == null) {
            return false;
        }
        return m14494b(view, ct, rect);
    }

    public static void handleCreationVideoAutoPlayConfig(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            boolean z = true;
            chj = jSONObject.optInt("creationVideoAutoPlayEnable", 1) == 1;
            if (jSONObject.optInt("exportedVideoAutoPlayEnable", 1) != 1) {
                z = false;
            }
            chk = z;
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static boolean isCreationVideoAutoPlayEnable() {
        return chj;
    }

    public static boolean isExportedVideoAutoPlayEnable() {
        return chk;
    }

    public static boolean isInAutoPlayArea(View view) {
        Rect rect = new Rect();
        rect.left = 0;
        rect.right = Constants.getScreenSize().width;
        rect.top = 0;
        rect.bottom = Constants.getScreenSize().height;
        return m14496h(view, rect);
    }

    public static C9196b newPlayerInstance(Context context) {
        return VERSION.SDK_INT >= 21 ? C9213h.m26793a(2, context, HttpStatus.SC_INTERNAL_SERVER_ERROR, 5000) : C9213h.m26793a(1, context, HttpStatus.SC_INTERNAL_SERVER_ERROR, 5000);
    }

    public static void show4GPlayToast(Context context) {
        String activeNetworkName = BaseSocialNotify.getActiveNetworkName(context);
        boolean z = C3742b.m9111II().mo23123IQ() && (!TextUtils.isEmpty(activeNetworkName) && activeNetworkName.equals(BaseSocialNotify.CONNECTIVITY_NAME_MOBILE));
        if (AppPreferencesSetting.getInstance().getAppSettingBoolean("key_first_toast_play_4g", true) && z) {
            AppPreferencesSetting.getInstance().setAppSettingBoolean("key_first_toast_play_4g", false);
            ToastUtils.longShow(context, R.string.viva_comm_setting_4g_toast);
        }
    }

    public static void showAutoPlayDialog(Context context, final OnClickListener onClickListener) {
        if (C4600l.m11739k(context, true) && !chi) {
            C8978m.m26348af(context, context.getString(R.string.xiaoying_str_auto_play_dialog_negative_btn), context.getString(R.string.xiaoying_str_auto_play_dialog_positive_btn)).mo10296do(R.string.xiaoying_str_auto_play_dialog_content).mo10291b(new C1904j() {
                public void onClick(C1890f fVar, C1885b bVar) {
                    VideoAutoPlayHelper.chi = false;
                }
            }).mo10281a((C1904j) new C1904j() {
                public void onClick(C1890f fVar, C1885b bVar) {
                    VideoAutoPlayHelper.chi = false;
                    C3742b.m9111II().mo23124IR();
                    if (onClickListener != null) {
                        onClickListener.onClick(fVar.mo10252a(bVar));
                    }
                }
            }).mo10275a((OnCancelListener) new OnCancelListener() {
                public void onCancel(DialogInterface dialogInterface) {
                    VideoAutoPlayHelper.chi = false;
                }
            }).mo10313qu().show();
            chi = true;
        }
    }
}
