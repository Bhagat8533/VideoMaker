package com.introvd.template.app.splash;

import android.content.Context;
import android.text.TextUtils;
import com.introvd.template.AppMiscListener;
import com.introvd.template.C3569a;
import com.introvd.template.C4681i;
import com.introvd.template.VivaBaseApplication;
import com.introvd.template.app.ApplicationBase;
import com.introvd.template.app.C3869e;
import com.introvd.template.app.C4037m;
import com.introvd.template.app.C4388u;
import com.introvd.template.app.alarm.C3724a;
import com.introvd.template.app.homepage.C3935b;
import com.introvd.template.app.manager.C4041a;
import com.introvd.template.app.manager.C4059d;
import com.introvd.template.app.p177b.C3742b;
import com.introvd.template.common.AppPreferencesSetting;
import com.introvd.template.common.SDCardManager;
import com.introvd.template.common.bitmapfun.DiskLruCache;
import com.introvd.template.common.model.AppStateModel;
import com.introvd.template.common.utils.DataRefreshValidateUtil;
import com.introvd.template.crash.C5523b;
import com.introvd.template.crash.C5526d;
import com.introvd.template.datacenter.BaseSocialNotify;
import com.introvd.template.module.iap.C8048e;
import com.introvd.template.module.iap.C8049f;
import com.introvd.template.module.iap.business.p352b.C7835b;
import com.introvd.template.module.p326ad.p337i.C7675d;
import com.introvd.template.origin.device.C8119a;
import com.introvd.template.origin.p364a.C8113b;
import com.introvd.template.origin.route.C8150d;
import com.introvd.template.p203b.C4580b;
import com.introvd.template.p363o.C8092b;
import com.introvd.template.p363o.C8106f;
import com.introvd.template.router.BizServiceManager;
import com.introvd.template.router.editor.IEditorService;
import com.introvd.template.router.lbs.LbsManagerProxy;
import com.introvd.template.router.template.ITemplateService;
import com.introvd.template.router.user.UserServiceProxy;
import com.vivavideo.component.permission.C9295b;
import com.vivavideo.mobile.component.sharedpref.C9324b;
import com.vivavideo.mobile.component.sharedpref.C9327e;
import java.util.concurrent.TimeUnit;
import p037b.p050b.C1848s;
import p037b.p050b.C1850u;
import p037b.p050b.p051a.p053b.C1487a;
import p037b.p050b.p073g.C1810c;

/* renamed from: com.introvd.template.app.splash.d */
class C4368d {
    private static volatile C4368d bEE;
    private static C9324b bEy = C9327e.m27035cS(VivaBaseApplication.m8749FZ(), "Splash_skip_config");
    public volatile boolean bEA = false;
    public volatile boolean bEB = false;
    public volatile boolean bEC = false;
    public volatile boolean bED = false;

    private C4368d() {
    }

    /* JADX INFO: finally extract failed */
    /* renamed from: Qu */
    public static C4368d m10988Qu() {
        if (bEE == null) {
            Class<C4368d> cls = C4368d.class;
            synchronized (C4368d.class) {
                try {
                    if (bEE == null) {
                        bEE = new C4368d();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return bEE;
    }

    /* renamed from: Qx */
    private void m10989Qx() {
        LbsManagerProxy.init(VivaBaseApplication.m8749FZ().getApplicationContext(), AppStateModel.getInstance().isInChina());
        LbsManagerProxy.setAutoStop(true);
        LbsManagerProxy.recordLocation(false, false);
        LbsManagerProxy.resetLocation();
        LbsManagerProxy.recordLocation(true, false);
    }

    /* renamed from: a */
    private void m10990a(Context context, AppMiscListener appMiscListener) {
        String str = "e3sod_leapllrcky_rk_p_r_uf";
        String str2 = "";
        String appSettingStr = AppPreferencesSetting.getInstance().getAppSettingStr("pref_key_3rd_apk_local_url", "");
        String str3 = "r3kmp_aro_ad_opdfleauykt_e";
        boolean z = true | false;
        boolean appSettingBoolean = AppPreferencesSetting.getInstance().getAppSettingBoolean("pref_key_3rd_apk_auto_load", false);
        if (!TextUtils.isEmpty(appSettingStr) && appSettingBoolean && appMiscListener != null) {
            appMiscListener.handle3rdApkTest(context, appSettingStr);
        }
    }

    /* renamed from: bR */
    private void m10991bR(boolean z) {
        String str = "p_siops_iposhnkiykat_slo";
        bEy.setBoolean("key_splash_skip_position", z);
    }

    /* renamed from: cQ */
    private void m10992cQ(Context context) {
        try {
            String userId = UserServiceProxy.getUserId();
            String dz = C4580b.m11653dz(context);
            if (!TextUtils.isEmpty(dz)) {
                C4041a.m10039MV();
                C4041a.m10041N(dz, userId);
                String countryCode = AppStateModel.getInstance().getCountryCode();
                IEditorService iEditorService = (IEditorService) BizServiceManager.getService(IEditorService.class);
                String str = null;
                if (iEditorService != null) {
                    str = iEditorService.getGpuType();
                }
                C4037m.m10029g(countryCode, dz, userId, str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: cR */
    private void m10993cR(Context context) {
        if (context != null) {
            Class<ITemplateService> cls = ITemplateService.class;
            ITemplateService iTemplateService = (ITemplateService) BizServiceManager.getService(ITemplateService.class);
            if (iTemplateService != null) {
                iTemplateService.updateRollTemplateMapInfo(context);
            }
            C7675d.aAK();
            long j = !C8048e.aBe().isInChina() ? 2 : 0;
            C7835b.m22858iI(true);
            if (!C8048e.aBe().mo23629Mu() && !C8048e.aBe().mo23630Mv() && !C8048e.aBe().mo23631Mw()) {
                C1848s.m5326ai(Boolean.valueOf(true)).mo10194f(C1487a.aUa()).mo10200k(j, TimeUnit.SECONDS).mo10188a((C1850u<? super T>) new C1810c<Boolean>() {
                    /* renamed from: e */
                    public void onSuccess(Boolean bool) {
                        C8049f.aBf().restoreGoodsAndPurchaseInfo();
                    }

                    public void onError(Throwable th) {
                    }
                });
            }
            C4037m.m10020Hw();
            C3935b.m9679Lb().mo23481Lk();
        }
    }

    /* renamed from: cS */
    private void m10994cS(Context context) {
        C3724a bR = C3724a.m9052bR(context);
        if (AppPreferencesSetting.getInstance().getAppSettingBoolean("pref_receive_notification", true)) {
            bR.mo23085gp(4097);
            bR.mo23085gp(4098);
            bR.mo23081a(bR.mo23086gq(4097), 4097);
            bR.mo23081a(bR.mo23086gq(4098), 4098);
        }
        bR.mo23084dj(4100);
        bR.mo23084dj(4101);
        if (C3724a.m9047Ih()) {
            bR.mo23084dj(4102);
            return;
        }
        bR.mo23085gp(4102);
        bR.mo23085gp(4103);
    }

    /* renamed from: Qv */
    public synchronized void mo24424Qv() {
        char c;
        try {
            Context applicationContext = VivaBaseApplication.m8749FZ().getApplicationContext();
            int i = 3 >> 1;
            if (applicationContext == null) {
                String str = "ort_ebionof_kfcyepr_";
                if (!AppPreferencesSetting.getInstance().getAppSettingBoolean("pref_root_config_key", false)) {
                    C5523b.logException(new C5526d(" rootconfig firstrun state not work aa！"));
                }
                this.bEA = true;
                return;
            }
            C4059d.m10105cr(applicationContext);
            if (!ApplicationBase.biq) {
                new C8150d().mo33232R(applicationContext, false);
            }
            String str2 = "_mhdshbaswesop_o";
            DataRefreshValidateUtil.recordDataRefreshTime("splash_show_mode");
            if (!this.bEC) {
                C4386g.m11041QJ();
                C4386g.m11042QK();
                if (!TextUtils.isEmpty(BaseSocialNotify.getActiveNetworkName(applicationContext))) {
                    DiskLruCache.clearCache(applicationContext, null, 43200000);
                }
                m10993cR(applicationContext);
                m10990a(applicationContext, C4681i.m12184Gp().mo25016Gr());
                if (C3569a.m8772FK()) {
                    m10992cQ(applicationContext);
                }
                m10994cS(applicationContext);
                if (C3869e.m9526Hj()) {
                    C3869e.m9528by(applicationContext);
                }
                C3742b.m9111II().mo23180K(applicationContext, C8113b.aES());
                m10991bR(C3742b.m9111II().mo23153JU());
                if (C3569a.m8773FL()) {
                    String str3 = "fptli_gtt_ayurponpaye_te_ytkes";
                    if (AppPreferencesSetting.getInstance().getAppSettingInt("pref_key_setting_autoplay_type", -1) == -1) {
                        AppPreferencesSetting.getInstance().setAppSettingInt("pref_key_setting_autoplay_type", AppPreferencesSetting.getInstance().getAppSettingBoolean("pref_auto_play", true) ? 1 : 0);
                    }
                }
                C8049f.aBf().mo33076A(Boolean.valueOf(C3742b.m9111II().mo23167Jn()));
            }
            this.bEC = true;
            this.bEA = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
    }

    /* renamed from: Qw */
    public synchronized void mo24425Qw() {
        try {
            if (!this.bED) {
                Context applicationContext = VivaBaseApplication.m8749FZ().getApplicationContext();
                if (applicationContext == null) {
                    this.bEB = true;
                    return;
                }
                if (C9295b.m26985b(applicationContext, C8092b.dXw)) {
                    m10989Qx();
                    C8106f.m23493iP(true);
                } else {
                    C8106f.m23493iP(false);
                }
                if (C9295b.m26985b(applicationContext, C8092b.dXu) && SDCardManager.hasSDCard()) {
                    C4388u.m11055HD().mo24453HG();
                    C8119a.init(VivaBaseApplication.m8749FZ());
                }
                this.bED = true;
                this.bEB = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable th) {
            throw th;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: Qy */
    public boolean mo24426Qy() {
        String str = "skepplpsp_oiisyn_iksat_h";
        return bEy.getBoolean("key_splash_skip_position", false);
    }
}
