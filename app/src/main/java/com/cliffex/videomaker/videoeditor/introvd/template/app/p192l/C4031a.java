package com.introvd.template.app.p192l;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.introvd.template.R;
import com.introvd.template.app.api.C3727b;
import com.introvd.template.common.Constants;
import com.introvd.template.common.ToastUtils;
import com.introvd.template.common.UserBehaviorLog;
import com.introvd.template.common.model.AppStateModel;
import com.introvd.template.datacenter.SocialConstDef;
import com.introvd.template.datacenter.SocialServiceDef;
import com.introvd.template.p203b.C4583d;
import com.introvd.template.router.sns.MyResolveInfo;
import com.introvd.template.sns.ShareApiUtil;
import com.introvd.template.sns.ShareApiUtil.ActivityShareInfo;
import com.introvd.template.sns.SnsShareInfo.Builder;
import com.introvd.template.sns.SnsShareManager;
import com.introvd.template.sns.SnsShareTypeUtil;
import com.introvd.template.sns.VideoShareInfo;
import com.p131c.p132a.C2561a;
import com.quvideo.sns.base.p228b.C4979b.C4981a;
import com.quvideo.sns.base.p228b.C4982c;
import java.util.HashMap;
import p037b.p050b.C1850u;
import p037b.p050b.p051a.p053b.C1487a;
import p037b.p050b.p054b.C1495b;
import p037b.p050b.p076j.C1820a;

/* renamed from: com.introvd.template.app.l.a */
public class C4031a extends Dialog implements OnCancelListener, OnClickListener {

    /* renamed from: Jn */
    private View f3385Jn = LayoutInflater.from(this.mContext).inflate(R.layout.v4_xiaoying_share_dialog_layout, null);
    private ImageView bDI;
    private TextView bDJ;
    private TextView bDK;
    private TextView bDL;
    private LinearLayout bDM;
    private int btW = Constants.getScreenSize().width;
    /* access modifiers changed from: private */
    public Context mContext;
    private String mCountry;

    public C4031a(Context context) {
        super(context, R.style.xiaoying_style_com_dialog);
        this.mContext = context;
        if (this.f3385Jn != null) {
            this.bDJ = (TextView) this.f3385Jn.findViewById(R.id.btn_more_share);
            this.bDJ.setTag(Integer.valueOf(100));
            this.bDM = (LinearLayout) this.f3385Jn.findViewById(R.id.share_btn_list);
            this.bDI = (ImageView) this.f3385Jn.findViewById(R.id.img_dialog_flag);
            this.bDK = (TextView) this.f3385Jn.findViewById(R.id.share_title);
            this.bDL = (TextView) this.f3385Jn.findViewById(R.id.share_text);
            if (!AppStateModel.getInstance().isInChina()) {
                this.bDJ.setVisibility(0);
            } else {
                this.bDJ.setVisibility(8);
            }
            double P = (((double) (this.btW - (C4583d.m11671P(40.0f) * 2))) * 106.0d) / 305.0d;
            LayoutParams layoutParams = this.bDK.getLayoutParams();
            layoutParams.height = (int) P;
            this.bDK.setLayoutParams(layoutParams);
            this.bDJ.setOnClickListener(this);
            m10004PJ();
            this.f3385Jn.setOnClickListener(new C4034b(this));
            this.f3385Jn.findViewById(R.id.layoutContent).setOnClickListener(C4035c.bDO);
        }
    }

    /* renamed from: L */
    private boolean m10002L(final Context context, final int i) {
        switch (i) {
            case 6:
            case 7:
            case 10:
            case 11:
                C3727b.m9081a(3, null, m10014hI(i)).mo10196g(C1820a.aVi()).mo10194f(C1487a.aUa()).mo10188a((C1850u<? super T>) new C1850u<JsonObject>() {
                    /* renamed from: a */
                    public void mo9883a(C1495b bVar) {
                    }

                    /* renamed from: a */
                    public void onSuccess(JsonObject jsonObject) {
                        ActivityShareInfo paserJsonString = ShareApiUtil.paserJsonString(new Gson().toJson((JsonElement) jsonObject));
                        if (paserJsonString == null) {
                            String string = context.getString(R.string.xiaoying_str_studio_share_title);
                            String string2 = context.getString(R.string.xiaoying_str_com_task_state_fail);
                            Context a = C4031a.this.mContext;
                            StringBuilder sb = new StringBuilder();
                            sb.append(string);
                            sb.append(string2);
                            ToastUtils.show(a, sb.toString(), 1);
                            return;
                        }
                        C4031a.this.m10006a(context, paserJsonString, i);
                    }

                    public void onError(Throwable th) {
                        String string = context.getString(R.string.xiaoying_str_studio_share_title);
                        String string2 = context.getString(R.string.xiaoying_str_com_task_state_fail);
                        Context context = context;
                        StringBuilder sb = new StringBuilder();
                        sb.append(string);
                        sb.append(string2);
                        ToastUtils.show(context, sb.toString(), 1);
                    }
                });
                break;
            default:
                if (i > 0) {
                    if (i == 100) {
                        HashMap hashMap = new HashMap();
                        hashMap.put(SocialServiceDef.EXTRAS_UPGRADE_FROM, "foreign");
                        UserBehaviorLog.onKVEvent(context, "Setting_App_Recommend", hashMap);
                    }
                    String string = context.getString(R.string.xiaoying_str_com_share_app);
                    StringBuilder sb = new StringBuilder();
                    sb.append(context.getString(R.string.xiaoying_str_community_setting_share_vivavideo_note));
                    sb.append("https://j8ef.app.link/oblilMrBIB");
                    String sb2 = sb.toString();
                    if (3 == C2561a.aOR() || C2561a.aOS()) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(context.getString(R.string.xiaoying_str_community_setting_share_vivavideo_note));
                        sb3.append("https://vivalite.page.link/Tbeh");
                        sb2 = sb3.toString();
                    } else if (4 == C2561a.aOR()) {
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append(context.getString(R.string.xiaoying_str_community_setting_share_vivavideo_note));
                        sb4.append("https://vivalite.page.link/Tbeh");
                        sb2 = sb4.toString();
                    }
                    if (!SnsShareManager.shareText(context, i, new C4981a().mo25443cN(sb2).mo25448cS(string).mo25441FJ(), null)) {
                        return false;
                    }
                }
                break;
        }
        return true;
    }

    /* renamed from: N */
    public static void m10003N(Activity activity) {
        m10013d(activity, null);
    }

    /* renamed from: PJ */
    private void m10004PJ() {
        int[] iArr;
        int[] iArr2;
        this.mCountry = AppStateModel.getInstance().getCountryCode();
        if (AppStateModel.COUNTRY_CODE_China.equals(this.mCountry) && !C2561a.aON()) {
            iArr2 = new int[]{R.drawable.v4_btn_intl_share_moment_selector, R.drawable.v4_btn_intl_share_wechat_selector, R.drawable.v4_btn_intl_share_qq_selector, R.drawable.v4_btn_intl_share_qzone_selector};
            iArr = new int[]{6, 7, 11, 10};
        } else if (AppStateModel.COUNTRY_CODE_BRAZIL.equals(this.mCountry)) {
            iArr2 = new int[]{R.drawable.v4_btn_intl_share_whatsapp_selector, R.drawable.v4_btn_intl_share_facebook_selector, R.drawable.v4_btn_intl_share_fbmessenger_selector, R.drawable.v4_btn_intl_share_line_selector};
            iArr = new int[]{32, 28, 33, 38};
        } else if (AppStateModel.COUNTRY_CODE_AMERICAN.equals(this.mCountry)) {
            iArr2 = new int[]{R.drawable.v4_btn_intl_share_facebook_selector, R.drawable.v4_btn_intl_share_fbmessenger_selector, R.drawable.v4_btn_intl_share_email_selector, R.drawable.v4_btn_intl_share_line_selector};
            iArr = new int[]{28, 33, 4, 38};
        } else if (AppStateModel.COUNTRY_CODE_Korea.equals(this.mCountry)) {
            iArr2 = new int[]{R.drawable.v4_btn_intl_share_kakaotalk_selector, R.drawable.v4_btn_intl_share_facebook_selector, R.drawable.v4_btn_intl_share_line_selector, R.drawable.v4_btn_intl_share_whatsapp_selector};
            iArr = new int[]{43, 28, 38, 32};
        } else if (AppStateModel.COUNTRY_CODE_Japan.equals(this.mCountry) || AppStateModel.COUNTRY_CODE_Taiwan.equals(this.mCountry)) {
            iArr2 = new int[]{R.drawable.v4_btn_intl_share_line_selector, R.drawable.v4_btn_intl_share_facebook_selector, R.drawable.v4_btn_intl_share_fbmessenger_selector, R.drawable.v4_btn_intl_share_whatsapp_selector};
            iArr = new int[]{38, 28, 33, 32};
        } else if (AppStateModel.COUNTRY_CODE_Indonesia.equals(this.mCountry) || AppStateModel.COUNTRY_CODE_Thailand.equals(this.mCountry) || AppStateModel.COUNTRY_CODE_VietNam.equals(this.mCountry) || AppStateModel.COUNTRY_CODE_Malaysia.equals(this.mCountry)) {
            iArr2 = new int[]{R.drawable.v4_btn_intl_share_line_selector, R.drawable.v4_btn_intl_share_whatsapp_selector, R.drawable.v4_btn_intl_share_facebook_selector, R.drawable.v4_btn_intl_share_fbmessenger_selector};
            iArr = new int[]{38, 32, 28, 33};
        } else {
            iArr2 = new int[]{R.drawable.v4_btn_intl_share_whatsapp_selector, R.drawable.v4_btn_intl_share_facebook_selector, R.drawable.v4_btn_intl_share_fbmessenger_selector, R.drawable.v4_btn_intl_share_email_selector};
            iArr = new int[]{32, 28, 33, 4};
        }
        m10009b(iArr2, iArr);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m10006a(final Context context, ActivityShareInfo activityShareInfo, int i) {
        if (context instanceof Activity) {
            final MyResolveInfo myResolveInfoBySnsType = SnsShareTypeUtil.getMyResolveInfoBySnsType(context, i);
            VideoShareInfo videoShareInfo = new VideoShareInfo();
            videoShareInfo.strTitle = context.getResources().getString(R.string.xiaoying_str_com_share_activity_title_notrans);
            videoShareInfo.strThumbPath = activityShareInfo.strImgUrl;
            videoShareInfo.strThumbUrl = activityShareInfo.strImgUrl;
            videoShareInfo.strDesc = activityShareInfo.strDesc;
            videoShareInfo.strPageUrl = activityShareInfo.strPageUrl;
            SnsShareManager.shareLink((Activity) context, i, new Builder().strTitle(videoShareInfo.strTitle).strDesc(videoShareInfo.strDesc).strImgUrl(videoShareInfo.strThumbUrl).strLinkUrl(videoShareInfo.strPageUrl).snsShareListener(new C4982c() {
                public void onHandleIntentShare(int i) {
                }

                public void onShareCanceled(int i) {
                }

                public void onShareFailed(int i, int i2, String str) {
                }

                public void onShareSuccess(int i) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("recommend_app", myResolveInfoBySnsType.label.toString());
                    hashMap.put(SocialServiceDef.EXTRAS_UPGRADE_FROM, "CHN");
                    UserBehaviorLog.onKVEvent(context, "Setting_App_Recommend", hashMap);
                }
            }).build(), "share_app");
        }
    }

    /* renamed from: b */
    private void m10009b(int[] iArr, int[] iArr2) {
        if (iArr.length >= 4 || iArr2.length >= 4) {
            int P = ((this.btW - (C4583d.m11671P(19.0f) * 5)) - (C4583d.m11671P(40.0f) * 2)) / 4;
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(P, P);
            if (VERSION.SDK_INT >= 17) {
                layoutParams.setMarginStart(C4583d.m11671P(19.0f));
            } else {
                layoutParams.setMargins(C4583d.m11671P(19.0f), 0, 0, 0);
            }
            for (int i = 0; i < 4; i++) {
                ImageButton imageButton = new ImageButton(this.mContext);
                imageButton.setLayoutParams(layoutParams);
                imageButton.setBackgroundResource(iArr[i]);
                imageButton.setTag(Integer.valueOf(iArr2[i]));
                imageButton.setOnClickListener(this);
                this.bDM.addView(imageButton);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: bR */
    public /* synthetic */ void m10010bR(View view) {
        dismiss();
    }

    /* access modifiers changed from: private */
    /* renamed from: bT */
    public static /* synthetic */ void m10011bT(View view) {
    }

    /* renamed from: d */
    public static void m10013d(Activity activity, OnDismissListener onDismissListener) {
        C4031a aVar = new C4031a(activity);
        aVar.mo23688hF(R.drawable.v4_xiaoying_com_recommend);
        aVar.mo23689hG(R.string.xiaoying_str_setting_share_title);
        aVar.mo23690hH(R.string.xiaoying_str_setting_share_text);
        aVar.setOnDismissListener(onDismissListener);
        aVar.show();
    }

    /* renamed from: hI */
    private int m10014hI(int i) {
        if (i == 6 || i == 7) {
            return 6;
        }
        if (i == 1) {
            return 1;
        }
        return (i == 10 || i == 11) ? 10 : 0;
    }

    /* renamed from: hF */
    public void mo23688hF(int i) {
        this.bDI.setBackgroundResource(i);
    }

    /* renamed from: hG */
    public void mo23689hG(int i) {
        this.bDK.setText(i);
    }

    /* renamed from: hH */
    public void mo23690hH(int i) {
        this.bDL.setText(i);
    }

    public void onCancel(DialogInterface dialogInterface) {
    }

    public void onClick(View view) {
        int intValue = ((Integer) view.getTag()).intValue();
        if (intValue > 0) {
            HashMap hashMap = new HashMap();
            MyResolveInfo myResolveInfoBySnsType = SnsShareTypeUtil.getMyResolveInfoBySnsType(this.mContext, intValue);
            if (myResolveInfoBySnsType != null) {
                hashMap.put(SocialConstDef.TBL_NAME_SNS, myResolveInfoBySnsType.label);
                UserBehaviorLog.onKVEvent(this.mContext, "App_Recommend_Click", hashMap);
            }
        }
        boolean L = m10002L(this.mContext, intValue);
        if (isShowing() && L) {
            dismiss();
        }
    }

    public void show() {
        if (this.f3385Jn != null) {
            setContentView(this.f3385Jn);
        }
        super.show();
    }
}
