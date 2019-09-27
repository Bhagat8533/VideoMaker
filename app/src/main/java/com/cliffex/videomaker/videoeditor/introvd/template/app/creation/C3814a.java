package com.introvd.template.app.creation;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.introvd.template.R;
import com.introvd.template.VivaBaseApplication;
import com.introvd.template.app.homepage.AppModelConfigInfo;
import com.introvd.template.app.homepage.C3935b;
import com.introvd.template.app.youngermode.C4560d;
import com.introvd.template.common.AppPreferencesSetting;
import com.introvd.template.common.UserBehaviorLog;
import com.introvd.template.common.behavior.UserBehaviorABTestUtils;
import com.introvd.template.common.behavior.UserBehaviorUtils;
import com.introvd.template.common.filecache.FileCache;
import com.introvd.template.common.filecache.FileCache.Builder;
import com.introvd.template.common.imageloader.ImageLoader;
import com.introvd.template.common.model.AppStateModel;
import com.introvd.template.common.p236ui.modechooser.ModeItemInfo;
import com.introvd.template.module.iap.business.p352b.C7835b;
import com.introvd.template.module.iap.business.p356e.C7899c;
import com.introvd.template.module.iap.utils.C8082f;
import com.introvd.template.router.todoCode.BizAppTodoActionManager;
import com.introvd.template.router.todoCode.TODOParamModel;
import com.introvd.template.router.todoCode.TodoConstants;
import com.p131c.p132a.C2561a;
import com.quvideo.mobile.component.imageview.DynamicLoadingImageView;
import java.util.HashMap;
import p037b.p050b.C1834l;
import p037b.p050b.C1842q;
import p037b.p050b.p051a.p053b.C1487a;
import p037b.p050b.p054b.C1495b;

/* renamed from: com.introvd.template.app.creation.a */
public class C3814a {
    /* renamed from: Kd */
    private static ModeItemInfo m9341Kd() {
        ModeItemInfo modeItemInfo;
        AppModelConfigInfo Lj = C3935b.m9679Lb().mo23480Lj();
        if (AppStateModel.getInstance().isInChina() && Lj == null) {
            return null;
        }
        if (Lj == null) {
            modeItemInfo = new ModeItemInfo();
            modeItemInfo.itemName = "shuffle";
            modeItemInfo.rawId = 0;
            modeItemInfo.todoCode = TodoConstants.TODO_TYPE_SHOW_SHUFFLE_ADS;
            modeItemInfo.itemImgBackupRes = Integer.valueOf(R.drawable.vivavideo_tool_shuffle);
            modeItemInfo.itemNameBackupRes = R.string.xiaoying_str_com_ads_shuffle;
        } else {
            modeItemInfo = C3821d.m9371b(Lj);
        }
        return modeItemInfo;
    }

    /* renamed from: Ke */
    private static C1834l<AppModelConfigInfo> m9342Ke() {
        AppModelConfigInfo Lg = C3935b.m9679Lb().mo23477Lg();
        Builder builder = new Builder(VivaBaseApplication.m8749FZ(), AppModelConfigInfo.class);
        StringBuilder sb = new StringBuilder();
        sb.append(TodoConstants.TODO_TYPE_VIP_UPGRADE);
        sb.append(AppModelConfigInfo.class.getName());
        FileCache build = builder.setCacheKey(sb.toString()).build();
        if (Lg != null) {
            build.saveCache(Lg);
        }
        return build.getCache();
    }

    /* access modifiers changed from: private */
    /* renamed from: Kf */
    public static AppModelConfigInfo m9343Kf() {
        AppModelConfigInfo appModelConfigInfo = new AppModelConfigInfo();
        appModelConfigInfo.eventType = TodoConstants.TODO_TYPE_VIP_UPGRADE;
        return appModelConfigInfo;
    }

    /* renamed from: a */
    public static void m9345a(final DynamicLoadingImageView dynamicLoadingImageView) {
        m9342Ke().mo10152c(C1487a.aUa()).mo10149b((C1842q<? super T>) new C1842q<AppModelConfigInfo>() {
            /* renamed from: a */
            public void mo9877a(C1495b bVar) {
            }

            /* renamed from: a */
            public void mo9886K(AppModelConfigInfo appModelConfigInfo) {
                C3814a.m9347a(dynamicLoadingImageView, appModelConfigInfo);
            }

            public void onComplete() {
            }

            public void onError(Throwable th) {
                C3814a.m9347a(dynamicLoadingImageView, C3814a.m9343Kf());
            }
        });
    }

    /* renamed from: a */
    public static void m9346a(DynamicLoadingImageView dynamicLoadingImageView, final View view) {
        if (C4560d.m11516RN().isYoungerMode()) {
            view.setVisibility(8);
            dynamicLoadingImageView.setVisibility(8);
            return;
        }
        final Context context = dynamicLoadingImageView.getContext();
        final ModeItemInfo Kd = m9341Kd();
        if (Kd == null) {
            dynamicLoadingImageView.setVisibility(8);
        } else if (C2561a.aOR() != 1) {
            dynamicLoadingImageView.setVisibility(8);
        } else {
            dynamicLoadingImageView.setVisibility(0);
            if (!TextUtils.isEmpty(Kd.itemImgUrl)) {
                dynamicLoadingImageView.setImageURI(Kd.itemImgUrl);
            } else if (((Integer) Kd.itemImgBackupRes).intValue() > 0) {
                dynamicLoadingImageView.setImage(((Integer) Kd.itemImgBackupRes).intValue());
            }
            String str = Kd.itemName;
            StringBuilder sb = new StringBuilder();
            sb.append(Kd.rawId);
            sb.append("");
            UserBehaviorABTestUtils.onEventHomeNavigationRight(context, str, sb.toString(), true);
            dynamicLoadingImageView.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    if (context instanceof Activity) {
                        C3814a.m9349d(view, Kd.todoCode, false);
                        TODOParamModel tODOParamModel = new TODOParamModel();
                        tODOParamModel.mTODOCode = Kd.todoCode;
                        tODOParamModel.mJsonParam = Kd.todoParameter;
                        BizAppTodoActionManager.getInstance().executeTodo((Activity) context, tODOParamModel);
                        C7899c.aDg().setBoolean("is_from_gif_box", true);
                        HashMap hashMap = new HashMap();
                        hashMap.put("type", String.valueOf(Kd.todoCode));
                        hashMap.put("title", Kd.itemName);
                        UserBehaviorLog.onKVEvent(context, "Ad_Box_Icon_Click", hashMap);
                        Context context = context;
                        String str = Kd.title;
                        StringBuilder sb = new StringBuilder();
                        sb.append(Kd.itemId);
                        sb.append("");
                        UserBehaviorABTestUtils.onEventHomeNavigationRight(context, str, sb.toString(), false);
                    }
                }
            });
            m9349d(view, Kd.todoCode, true);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static void m9347a(DynamicLoadingImageView dynamicLoadingImageView, final AppModelConfigInfo appModelConfigInfo) {
        final Context context = dynamicLoadingImageView.getContext();
        if (C2561a.aOR() == 4) {
            dynamicLoadingImageView.setVisibility(8);
            return;
        }
        if (TextUtils.isEmpty(appModelConfigInfo.content)) {
            ImageLoader.loadImage(R.drawable.vivavideo_navi_vip_n_old, dynamicLoadingImageView);
        } else {
            ImageLoader.loadImage(appModelConfigInfo.content, dynamicLoadingImageView);
            String str = appModelConfigInfo.title;
            StringBuilder sb = new StringBuilder();
            sb.append(appModelConfigInfo.f3378id);
            sb.append("");
            UserBehaviorABTestUtils.onEventVIPPage(context, str, sb.toString(), true);
        }
        dynamicLoadingImageView.setVisibility(0);
        dynamicLoadingImageView.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if ((context instanceof Activity) && appModelConfigInfo.eventType > 0) {
                    C7835b.m22861lq("home vip");
                    TODOParamModel tODOParamModel = new TODOParamModel();
                    tODOParamModel.mTODOCode = appModelConfigInfo.eventType;
                    tODOParamModel.mJsonParam = C8082f.m23455b(appModelConfigInfo.eventContent, "accurateFrom", "home vip");
                    BizAppTodoActionManager.getInstance().executeTodo((Activity) context, tODOParamModel);
                    HashMap hashMap = new HashMap();
                    hashMap.put("type", appModelConfigInfo.title);
                    UserBehaviorLog.onKVEvent(context, "IAP_Vip_Click", hashMap);
                    UserBehaviorUtils.recordHomeClick("vip icon");
                    Context context = context;
                    String str = appModelConfigInfo.title;
                    StringBuilder sb = new StringBuilder();
                    sb.append(appModelConfigInfo.f3378id);
                    sb.append("");
                    UserBehaviorABTestUtils.onEventVIPPage(context, str, sb.toString(), false);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public static void m9349d(View view, int i, boolean z) {
        if (view != null) {
            if (!z) {
                AppPreferencesSetting.getInstance().setAppSettingInt("key_shuffle_position_todo_code", i);
                view.setVisibility(8);
                return;
            }
            if (AppPreferencesSetting.getInstance().getAppSettingInt("key_shuffle_position_todo_code", -1) != i) {
                view.setVisibility(0);
            }
        }
    }
}
