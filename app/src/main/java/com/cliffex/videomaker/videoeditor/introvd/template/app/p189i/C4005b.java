package com.introvd.template.app.p189i;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager.BadTokenException;
import android.widget.ImageView;
import com.afollestad.materialdialogs.C1885b;
import com.afollestad.materialdialogs.C1890f;
import com.afollestad.materialdialogs.C1890f.C1895a;
import com.afollestad.materialdialogs.C1890f.C1904j;
import com.aiii.android.arouter.p091c.C1919a;
import com.bumptech.glide.C2516m;
import com.bumptech.glide.load.p123c.p126c.C2465c;
import com.bumptech.glide.p111e.p112a.C2183f;
import com.bumptech.glide.p111e.p113b.C2195d;
import com.eiii.appevents.AppEventsLogger;
import com.introvd.template.C3569a;
import com.introvd.template.C4681i;
import com.introvd.template.R;
import com.introvd.template.VivaBaseApplication;
import com.introvd.template.XiaoYingActivity;
import com.introvd.template.ads.versionhelper.AdsVersionHelper;
import com.introvd.template.apicore.C3635l;
import com.introvd.template.app.AppTodoInterceptorImpl;
import com.introvd.template.app.homepage.C3935b;
import com.introvd.template.app.manager.C4041a;
import com.introvd.template.app.manager.C4059d;
import com.introvd.template.app.manager.C4059d.C4064b;
import com.introvd.template.app.p177b.C3742b;
import com.introvd.template.app.utils.C4395c;
import com.introvd.template.app.youngermode.C4545a;
import com.introvd.template.app.youngermode.C4553b;
import com.introvd.template.app.youngermode.C4560d;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.common.ResultListener;
import com.introvd.template.common.UserBehaviorLog;
import com.introvd.template.common.model.AppStateModel;
import com.introvd.template.crash.C5523b;
import com.introvd.template.datacenter.SocialConstDef;
import com.introvd.template.datacenter.SocialServiceDef;
import com.introvd.template.module.C7691e;
import com.introvd.template.module.iap.business.p349a.p351b.C7830c;
import com.introvd.template.module.iap.business.p349a.p351b.C7831d;
import com.introvd.template.module.iap.business.p352b.C7834a;
import com.introvd.template.module.iap.business.p356e.C7900d;
import com.introvd.template.module.p326ad.C7679k;
import com.introvd.template.p203b.C4580b;
import com.introvd.template.p203b.C4585f;
import com.introvd.template.p203b.C4586g;
import com.introvd.template.p203b.C4598j;
import com.introvd.template.p203b.C4600l;
import com.introvd.template.p374q.C8346e;
import com.introvd.template.p374q.C8347f;
import com.introvd.template.p374q.C8350g.C8354a;
import com.introvd.template.p414ui.dialog.C8978m;
import com.introvd.template.router.AppRouter;
import com.introvd.template.router.BizServiceManager;
import com.introvd.template.router.LoginRouter;
import com.introvd.template.router.LoginRouter.OnLoginListener;
import com.introvd.template.router.banner.BannerInfo;
import com.introvd.template.router.banner.IBannerService;
import com.introvd.template.router.common.ICommonFuncRouter;
import com.introvd.template.router.editor.IEditorService;
import com.introvd.template.router.setting.ISettingRouter;
import com.introvd.template.router.template.ITemplateService;
import com.introvd.template.router.todoCode.TODOParamModel;
import com.introvd.template.router.user.UserServiceProxy;
import com.introvd.template.sns.SnsShareManager;
import com.introvd.template.xyui.ripple.C9175b;
import com.p131c.p132a.C2561a;
import com.p131c.p132a.C2570b;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;
import p037b.p050b.C1848s;
import p037b.p050b.C1849t;
import p037b.p050b.C1851v;
import p037b.p050b.p051a.p053b.C1487a;
import p037b.p050b.p057e.C1517e;
import p037b.p050b.p076j.C1820a;

/* renamed from: com.introvd.template.app.i.b */
public class C4005b implements C7679k, C7691e {
    /* renamed from: Mj */
    private String m9899Mj() {
        String lw = new C7900d().mo32861lw("Export_Ads_Range");
        return TextUtils.isEmpty(lw) ? "2" : lw;
    }

    /* access modifiers changed from: private */
    @SuppressLint({"CheckResult"})
    /* renamed from: a */
    public void m9900a(final ViewGroup viewGroup, final ImageView imageView, int i) {
        if (!m9907bJ(viewGroup)) {
            Context context = viewGroup.getContext();
            IBannerService iBannerService = (IBannerService) C1919a.m5529sc().mo10356i(IBannerService.class);
            if (iBannerService != null) {
                iBannerService.queryBannerInfo(context.getApplicationContext(), i).mo10157d(C1820a.aVi()).mo10152c(C1487a.aUa()).mo10128a((C1517e<? super T>) new C1517e<List<BannerInfo>>() {
                    /* renamed from: V */
                    public void accept(List<BannerInfo> list) throws Exception {
                        if (!C4005b.this.m9907bJ(viewGroup)) {
                            final BannerInfo bannerInfo = (BannerInfo) list.get(0);
                            C2570b.m7334dw(viewGroup).mo12205tP().mo12179aO(bannerInfo.strContentUrl).mo12180b(new C2183f<Bitmap>() {
                                /* renamed from: a */
                                public void mo11939a(Bitmap bitmap, C2195d<? super Bitmap> dVar) {
                                    if (!C4005b.this.m9907bJ(viewGroup)) {
                                        C4005b.this.m9901a(viewGroup, imageView, bitmap, bannerInfo);
                                    }
                                }
                            });
                            new C4016d(imageView, String.valueOf(bannerInfo.f3572id), bannerInfo.strContentTitle);
                        }
                    }
                }, (C1517e<? super Throwable>) new C1517e<Throwable>() {
                    /* renamed from: m */
                    public void accept(Throwable th) throws Exception {
                        StringBuilder sb = new StringBuilder();
                        sb.append("--moduleIap--queryBannerInfo--");
                        sb.append(th.toString());
                        LogUtilsV2.m14227d(sb.toString());
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m9901a(ViewGroup viewGroup, ImageView imageView, Bitmap bitmap, final BannerInfo bannerInfo) {
        viewGroup.setVisibility(0);
        final Context context = viewGroup.getContext();
        LayoutParams layoutParams = imageView.getLayoutParams();
        layoutParams.width = (viewGroup.getMeasuredWidth() - viewGroup.getPaddingLeft()) - viewGroup.getPaddingRight();
        layoutParams.height = (layoutParams.width * bitmap.getHeight()) / bitmap.getWidth();
        imageView.setLayoutParams(layoutParams);
        C2570b.m7334dw(viewGroup).mo12192a(bitmap).mo12177a((C2516m<?, ? super TranscodeType>) C2465c.m7094wF()).mo12186g(imageView);
        imageView.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                ICommonFuncRouter iCommonFuncRouter = (ICommonFuncRouter) C1919a.m5529sc().mo10356i(ICommonFuncRouter.class);
                TODOParamModel tODOParamModel = new TODOParamModel();
                tODOParamModel.mTODOCode = bannerInfo.todoType;
                tODOParamModel.mJsonParam = bannerInfo.strTodoContent;
                if (context instanceof Activity) {
                    iCommonFuncRouter.executeTodo((Activity) context, tODOParamModel, null);
                }
                C7834a.m22833ax(String.valueOf(bannerInfo.f3572id), bannerInfo.strContentTitle);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m9904a(C4064b bVar, C1849t tVar) throws Exception {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("title", bVar.mTitle);
        jSONObject.put("desc", bVar.mDesc);
        jSONObject.put("content", bVar.mIconUrl);
        jSONObject.put("id", bVar.buF);
        jSONObject.put(SocialConstDef.MESSAGE_LIST_NEW_EVENT_TYPE, bVar.buJ);
        jSONObject.put(SocialConstDef.MESSAGE_LIST_NEW_EVENT_CONTENT, bVar.buK);
        jSONObject.put(SocialConstDef.POPUPWINDOW_ITEM_DISPLAY_COUNT, bVar.displayCount == 0 ? 9999 : bVar.displayCount);
        tVar.onSuccess(jSONObject);
    }

    /* access modifiers changed from: private */
    /* renamed from: bJ */
    public boolean m9907bJ(View view) {
        if (view == null) {
            return true;
        }
        Context context = view.getContext();
        if (context == null) {
            return true;
        }
        if (context instanceof Activity) {
            return ((Activity) context).isFinishing();
        }
        return false;
    }

    private boolean isHDExportBetaTest() {
        IEditorService iEditorService = (IEditorService) BizServiceManager.getService(IEditorService.class);
        if (iEditorService == null) {
            return false;
        }
        return iEditorService.isHDExportBetaTest();
    }

    private boolean isHigherHDExport() {
        IEditorService iEditorService = (IEditorService) BizServiceManager.getService(IEditorService.class);
        if (iEditorService == null) {
            return false;
        }
        return iEditorService.isHigherHDExport();
    }

    /* renamed from: C */
    public Drawable mo23605C(Drawable drawable) {
        return C9175b.m26701N(drawable);
    }

    /* renamed from: IX */
    public int mo23606IX() {
        return C3742b.m9111II().mo23130IX();
    }

    /* renamed from: J */
    public boolean mo23607J(Activity activity) {
        return activity instanceof XiaoYingActivity;
    }

    /* renamed from: K */
    public void mo23608K(Activity activity) {
        C1890f qu = C8978m.m26348af(activity, null, activity.getString(R.string.xiaoying_str_com_ok)).mo10293dl(R.string.iap_vip_privilege_dialog_title).mo10296do(R.string.iap_vip_privilege_dialog_desc).mo10313qu();
        if (!activity.isFinishing()) {
            try {
                qu.show();
            } catch (BadTokenException e) {
                C5523b.logException(e);
            }
        }
    }

    /* renamed from: MA */
    public C1848s<JSONObject> mo23609MA() {
        C4064b hf = C4059d.m10110hf(935);
        return hf == null ? C1848s.m5331x(new IllegalArgumentException("data is empty")) : C1848s.m5324a((C1851v<T>) new C4015c<T>(hf));
    }

    /* renamed from: MB */
    public boolean mo23610MB() {
        AppStateModel instance = AppStateModel.getInstance();
        boolean z = false;
        if (instance == null) {
            return false;
        }
        if ((instance.isMiddleEast() || instance.isInChina() || instance.isInIndia()) && instance.isCommunitySupport()) {
            z = true;
        }
        return z;
    }

    /* renamed from: MC */
    public boolean mo23611MC() {
        return C3569a.m8772FK();
    }

    /* renamed from: MD */
    public boolean mo23612MD() {
        return C3742b.m9111II().mo23176Jw();
    }

    /* renamed from: ME */
    public String mo23613ME() {
        ISettingRouter iSettingRouter = (ISettingRouter) C1919a.m5529sc().mo10356i(ISettingRouter.class);
        return iSettingRouter == null ? C4580b.m11644b(Locale.getDefault()) : C4580b.m11644b(C4598j.m11732eK(iSettingRouter.getAppSettedLocaleModel(getContext()).value));
    }

    /* renamed from: MF */
    public void mo23614MF() {
        C4553b.m11491RJ().mo24787a((ResultListener) null);
    }

    /* renamed from: MG */
    public boolean mo23615MG() {
        return C2561a.aOQ() || C2561a.aOR() == 3;
    }

    /* renamed from: MH */
    public boolean mo23616MH() {
        String countryCode = AppStateModel.getInstance().getCountryCode();
        return AppStateModel.COUNTRY_CODE_Korea.equalsIgnoreCase(countryCode) || AppStateModel.COUNTRY_CODE_AMERICAN.equalsIgnoreCase(countryCode) || AppStateModel.COUNTRY_CODE_Taiwan.equalsIgnoreCase(countryCode) || AppStateModel.COUNTRY_CODE_Thailand.equalsIgnoreCase(countryCode) || AppStateModel.COUNTRY_CODE_RUSSIA.equalsIgnoreCase(countryCode) || AppStateModel.COUNTRY_CODE_Japan.equalsIgnoreCase(countryCode) || AppStateModel.COUNTRY_CODE_BRAZIL.equalsIgnoreCase(countryCode);
    }

    /* renamed from: Mh */
    public View mo23617Mh() {
        return LayoutInflater.from(getContext()).inflate(R.layout.xiaoying_com_simple_dialogue_content, null);
    }

    /* renamed from: Mi */
    public boolean mo23618Mi() {
        if (isInChina()) {
            return false;
        }
        String Mj = m9899Mj();
        if ("0".equals(Mj)) {
            return false;
        }
        if ("1".equals(Mj)) {
            return true;
        }
        if (!"2".equals(Mj) || !isHDExportBetaTest()) {
            return "3".equals(Mj) && isHigherHDExport();
        }
        return true;
    }

    /* renamed from: Mk */
    public boolean mo23619Mk() {
        return C4580b.m11649dv(VivaBaseApplication.m8749FZ());
    }

    /* renamed from: Ml */
    public String mo23620Ml() {
        return C4585f.m11688dG(VivaBaseApplication.m8749FZ());
    }

    /* renamed from: Mm */
    public void mo23621Mm() {
        LoginRouter.startSettingBindAccountActivity(9527, (OnLoginListener) new OnLoginListener() {
            public void onLoginCancel() {
                LoginRouter.releaseResource(9527);
            }

            public void onLoginFail() {
                LoginRouter.releaseResource(9527);
            }

            public void onLoginSuccess() {
                LoginRouter.releaseResource(9527);
            }
        });
    }

    /* renamed from: Mn */
    public boolean mo23622Mn() {
        return C3569a.m8772FK();
    }

    /* renamed from: Mo */
    public void mo23623Mo() {
        C4586g.m11696Sm();
    }

    /* renamed from: Mp */
    public String mo23624Mp() {
        return null;
    }

    /* renamed from: Mq */
    public String mo23625Mq() {
        return null;
    }

    /* renamed from: Mr */
    public boolean mo23626Mr() {
        return C4395c.m11100dg(VivaBaseApplication.m8749FZ());
    }

    /* renamed from: Ms */
    public boolean mo23627Ms() {
        return SnsShareManager.isSnsSDKAndApkInstalled(VivaBaseApplication.m8749FZ(), 7, false);
    }

    /* renamed from: Mt */
    public boolean mo23628Mt() {
        return C4580b.m11650dw(VivaBaseApplication.m8749FZ());
    }

    /* renamed from: Mu */
    public boolean mo23629Mu() {
        return C2561a.aOR() == 2;
    }

    /* renamed from: Mv */
    public boolean mo23630Mv() {
        return C2561a.aOR() == 3 || C2561a.aOS();
    }

    /* renamed from: Mw */
    public boolean mo23631Mw() {
        return C2561a.aOS();
    }

    /* renamed from: Mx */
    public boolean mo23632Mx() {
        return C2561a.aOR() == 4;
    }

    /* renamed from: My */
    public void mo23633My() {
        C4681i.m12184Gp().mo25016Gr().setPushTag(VivaBaseApplication.m8749FZ(), false);
    }

    /* renamed from: Mz */
    public String mo23634Mz() {
        return C4041a.m10048cq(VivaBaseApplication.m8749FZ());
    }

    /* renamed from: a */
    public void mo23635a(Activity activity, int i, boolean z) {
        C4395c.m11089a(activity, (long) i, z);
    }

    /* renamed from: a */
    public void mo23636a(Activity activity, final OnClickListener onClickListener) {
        C1895a hs = C8978m.m26349hs(activity);
        if (mo23629Mu()) {
            hs.mo10296do(R.string.xiaoying_str_iap_restore_desc_android_huawei);
        } else {
            hs.mo10296do(R.string.xiaoying_str_iap_restore_desc_android);
        }
        hs.mo10303dv(R.string.xiaoying_str_com_cancel).mo10299dr(R.string.xiaoying_str_iap_restore).mo10281a((C1904j) new C1904j() {
            public void onClick(C1890f fVar, C1885b bVar) {
                onClickListener.onClick(null);
            }
        }).mo10313qu().show();
    }

    /* renamed from: a */
    public void mo23637a(Activity activity, String str, String str2) {
        AppRouter.startWebPage(activity, str, str2);
    }

    /* renamed from: a */
    public void mo23638a(Context context, ResultListener resultListener) {
        C4553b.m11491RJ().mo24787a(resultListener);
        C4545a.m11478dq(context);
    }

    /* renamed from: a */
    public void mo23639a(final C3635l<SparseArray<List<C7831d>>> lVar) {
        C3935b.m9679Lb().mo23483a((C3635l<SparseArray<List<C7831d>>>) new C3635l<SparseArray<List<C7831d>>>() {
            /* renamed from: a */
            public void onSuccess(SparseArray<List<C7831d>> sparseArray) {
                if (lVar != null) {
                    lVar.onSuccess(sparseArray);
                }
            }

            public void onError(String str) {
                if (lVar != null) {
                    lVar.onError(str);
                }
            }
        });
    }

    /* renamed from: a */
    public void mo23640a(String str, double d, String str2) {
        C4041a.m10044a(VivaBaseApplication.m8749FZ(), d, str2);
    }

    /* renamed from: a */
    public void mo23641a(String str, String str2, BigDecimal bigDecimal, Currency currency) {
        AppEventsLogger newLogger = AppEventsLogger.newLogger(VivaBaseApplication.m8749FZ());
        Bundle bundle = new Bundle();
        bundle.putString("fb_content_id", str);
        newLogger.logPurchase(bigDecimal, currency, bundle);
        Bundle bundle2 = new Bundle();
        bundle2.putString("type", str);
        bundle2.putString("price", str2);
        newLogger.logEvent("IAP_Success_Callback", bundle2);
    }

    /* renamed from: b */
    public void mo23642b(Activity activity, boolean z) {
        C4586g.m11704a((Context) activity, R.string.xiaoying_str_com_wait_tip, (OnCancelListener) null, z);
    }

    /* renamed from: b */
    public void mo23643b(final C3635l<List<C7830c>> lVar) {
        C3935b.m9679Lb().mo23484b((C3635l<List<C7830c>>) new C3635l<List<C7830c>>() {
            public void onError(String str) {
                if (lVar != null) {
                    lVar.onError(str);
                }
            }

            public void onSuccess(List<C7830c> list) {
                if (lVar != null) {
                    lVar.onSuccess(list);
                }
            }
        });
    }

    /* renamed from: bB */
    public boolean mo23644bB(boolean z) {
        return C4600l.m11739k(VivaBaseApplication.m8749FZ(), z);
    }

    /* renamed from: d */
    public void mo23645d(Activity activity, int i) {
        C4395c.m11088a(activity, (long) i);
    }

    /* renamed from: dC */
    public void mo23646dC(String str) {
        C4681i.m12184Gp().mo25016Gr().recordEvtOnAppflyer(VivaBaseApplication.m8749FZ(), str);
    }

    /* renamed from: dD */
    public String mo23647dD(String str) {
        return AppTodoInterceptorImpl.formatVivaUrl(VivaBaseApplication.m8749FZ(), str);
    }

    /* renamed from: dE */
    public boolean mo23648dE(String str) {
        return AdsVersionHelper.canLoadNextAd(str);
    }

    /* renamed from: dF */
    public void mo23649dF(String str) {
        if (!TextUtils.isEmpty(str) && mo23618Mi()) {
            AdsVersionHelper.prepareLoad(VivaBaseApplication.m8749FZ(), str);
        }
    }

    /* renamed from: dG */
    public boolean mo23650dG(String str) {
        ITemplateService iTemplateService = (ITemplateService) BizServiceManager.getService(ITemplateService.class);
        if (iTemplateService == null) {
            return false;
        }
        return iTemplateService.isAnimSubtitleRollcode(str);
    }

    /* renamed from: e */
    public void mo23651e(Activity activity, int i) {
        if (i == 101) {
            C4395c.m11088a(activity, -1);
        }
    }

    /* renamed from: f */
    public void mo23652f(String str, Bundle bundle) {
        AppEventsLogger.newLogger(VivaBaseApplication.m8749FZ()).logEvent(str, bundle);
    }

    /* renamed from: g */
    public void mo23653g(String str, HashMap<String, String> hashMap) {
        UserBehaviorLog.onKVEvent(VivaBaseApplication.m8749FZ(), str, hashMap);
    }

    public Application getApplication() {
        return VivaBaseApplication.m8749FZ();
    }

    public Context getContext() {
        return VivaBaseApplication.m8749FZ();
    }

    public String getCountryCode() {
        return AppStateModel.getInstance().getCountryCode();
    }

    /* renamed from: h */
    public View mo23657h(final ViewGroup viewGroup, final int i) {
        if (m9907bJ(viewGroup)) {
            return null;
        }
        final ImageView imageView = new ImageView(viewGroup.getContext());
        C8346e.m24077d(viewGroup.getContext(), 0, AppStateModel.getInstance().getCountryCode(), String.valueOf(i));
        C8347f.aKf().mo33601a(SocialServiceDef.SOCIAL_MISC_METHOD_BANNER_PAGE, (C8354a) new C8354a() {
            /* renamed from: a */
            public void mo23009a(Context context, String str, int i, Bundle bundle) {
                C8347f.aKf().mo33603oT(SocialServiceDef.SOCIAL_MISC_METHOD_BANNER_PAGE);
                C4005b.this.m9900a(viewGroup, imageView, i);
            }
        });
        return imageView;
    }

    /* renamed from: hc */
    public Map<String, String> mo23658hc(int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("type", "0");
        hashMap.put("lang", C4580b.m11635Si());
        hashMap.put("countryCode", AppStateModel.getInstance().getCountryCode());
        hashMap.put("modelcode", String.valueOf(i));
        hashMap.put("mobileType", Build.MODEL);
        String dz = C4580b.m11653dz(getContext());
        if (!TextUtils.isEmpty(dz)) {
            hashMap.put("duid", dz);
        }
        String userId = UserServiceProxy.getUserId();
        if (!TextUtils.isEmpty(userId)) {
            hashMap.put("auid", userId);
        }
        return hashMap;
    }

    public boolean isInChina() {
        return AppStateModel.getInstance().isInChina() && !mo23629Mu();
    }

    public boolean isYoungerMode() {
        return C4560d.m11516RN().isYoungerMode();
    }

    public void logException(Throwable th) {
        C5523b.logException(th);
    }
}
