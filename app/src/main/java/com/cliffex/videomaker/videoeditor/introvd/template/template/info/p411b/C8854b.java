package com.introvd.template.template.info.p411b;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.p021v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import com.aiii.android.arouter.facade.C1941a;
import com.google.android.exoplayer2.DefaultRenderersFactory;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.introvd.template.VivaBaseApplication;
import com.introvd.template.ads.entity.AdPositionInfoParam;
import com.introvd.template.ads.listener.VideoAdsListener;
import com.introvd.template.ads.listener.VideoRewardListener;
import com.introvd.template.app.api.C3727b;
import com.introvd.template.app.api.model.AppVersionInfo;
import com.introvd.template.common.AppPreferencesSetting;
import com.introvd.template.common.DeviceInfo;
import com.introvd.template.common.LogUtils;
import com.introvd.template.common.ToastUtils;
import com.introvd.template.common.UserBehaviorLog;
import com.introvd.template.common.behavior.UserBehaviorUtilsV5;
import com.introvd.template.common.behavior.UserEventDurationRelaUtils;
import com.introvd.template.common.controller.BaseController;
import com.introvd.template.common.model.AppStateModel;
import com.introvd.template.datacenter.SocialServiceDef;
import com.introvd.template.module.iap.C8035c;
import com.introvd.template.module.iap.business.C7870d;
import com.introvd.template.module.p326ad.C7680l;
import com.introvd.template.module.p326ad.p328b.C7591a;
import com.introvd.template.p203b.C4580b;
import com.introvd.template.p203b.C4600l;
import com.introvd.template.p203b.C4605o;
import com.introvd.template.router.BizServiceManager;
import com.introvd.template.router.app.IAppService;
import com.introvd.template.router.iap.IapRTConstants;
import com.introvd.template.router.template.TemplateRouter;
import com.introvd.template.sdk.model.template.RollInfo;
import com.introvd.template.sdk.model.template.TemplateInfo;
import com.introvd.template.sdk.p383c.C8399c;
import com.introvd.template.sdk.p391g.C8451b;
import com.introvd.template.template.C8622a;
import com.introvd.template.template.R;
import com.introvd.template.template.data.C8670b;
import com.introvd.template.template.data.api.model.TemplateResponseInfo;
import com.introvd.template.template.data.api.model.TemplateResponseRoll;
import com.introvd.template.template.download.C8705e;
import com.introvd.template.template.download.C8705e.C8707b;
import com.introvd.template.template.info.TemplateMgrActivity;
import com.introvd.template.template.info.item.C8908i;
import com.introvd.template.template.p402c.C8628a;
import com.introvd.template.template.p404d.C8645a;
import com.introvd.template.template.p407e.C8728c;
import com.introvd.template.template.p407e.C8733e;
import com.introvd.template.template.p407e.C8735f;
import com.introvd.template.template.p407e.C8739i;
import com.introvd.template.template.p407e.C8745n;
import com.introvd.template.template.p409g.C8762d;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.sdk.constants.Constants.ParametersKeys;
import com.p131c.p132a.p135c.C2575a;
import com.p131c.p132a.p135c.p136a.C2576a;
import com.p131c.p132a.p135c.p136a.C2576a.C2578a;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import org.greenrobot.eventbus.C10021c;
import org.greenrobot.eventbus.C10031j;
import org.greenrobot.eventbus.ThreadMode;
import p037b.p050b.C1834l;
import p037b.p050b.C1838m;
import p037b.p050b.C1839n;
import p037b.p050b.C1842q;
import p037b.p050b.C1850u;
import p037b.p050b.p051a.p053b.C1487a;
import p037b.p050b.p054b.C1494a;
import p037b.p050b.p054b.C1495b;
import p037b.p050b.p076j.C1820a;
import p469f.C9740h;

/* renamed from: com.introvd.template.template.info.b.b */
public class C8854b extends BaseController<C8853a> implements VideoAdsListener, VideoRewardListener, C8707b {
    private static final String TAG = "b";
    private C7870d bNG;
    /* access modifiers changed from: private */
    public boolean byU = false;
    /* access modifiers changed from: private */
    public C1494a compositeDisposable;
    /* access modifiers changed from: private */
    public Context context;
    /* access modifiers changed from: private */
    public String ekf;
    private long emV;
    private int enc = 3;
    private String enj = "unknown";
    /* access modifiers changed from: private */
    public int eqo = 0;
    private C8908i eqp;
    /* access modifiers changed from: private */
    public String eqq;
    private String eqr;
    /* access modifiers changed from: private */
    public C1495b eqs;

    private void aKP() {
        int parseInt = C2575a.parseInt(this.ekf);
        if (parseInt == 1) {
            this.enj = "theme";
        } else if (parseInt != 9) {
            switch (parseInt) {
                case 4:
                    this.enj = "filter";
                    return;
                case 5:
                    this.enj = "sticker";
                    return;
                default:
                    return;
            }
        } else {
            this.enj = "title";
        }
    }

    /* access modifiers changed from: private */
    public void aKX() {
        IAppService iAppService = (IAppService) BizServiceManager.getService(IAppService.class);
        if (iAppService != null) {
            iAppService.setUpgradeReceiveMain(((C8853a) getMvpView()).getHostActivity());
        }
        if (this.emV + DefaultRenderersFactory.DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS <= System.currentTimeMillis()) {
            boolean dA = C4580b.m11646dA(VivaBaseApplication.m8749FZ());
            String Si = C4580b.m11635Si();
            String countryCode = AppStateModel.getInstance().getCountryCode();
            C3727b.m9082a(dA ? 1 : 0, DeviceInfo.getSDK(), DeviceInfo.getModule(), Si, countryCode).mo10196g(C1820a.aVi()).mo10194f(C1487a.aUa()).mo10188a((C1850u<? super T>) new C1850u<AppVersionInfo>() {
                /* renamed from: a */
                public void mo9883a(C1495b bVar) {
                }

                /* renamed from: a */
                public void onSuccess(AppVersionInfo appVersionInfo) {
                    Intent intent = new Intent(SocialServiceDef.ACTION_APK_VERSION_UPGRADE);
                    intent.putExtra(SocialServiceDef.EXTRAS_UPGRADE_URL, appVersionInfo.apkUrl);
                    LocalBroadcastManager.getInstance(VivaBaseApplication.m8749FZ()).sendBroadcast(intent);
                    ToastUtils.show((Context) VivaBaseApplication.m8749FZ(), R.string.xiaoying_str_com_msg_download, 0);
                }

                public void onError(Throwable th) {
                    th.printStackTrace();
                    ToastUtils.show((Context) VivaBaseApplication.m8749FZ(), R.string.xiaoying_str_com_new_version_checking_failed, 0);
                }
            });
            this.emV = System.currentTimeMillis();
        }
    }

    private boolean aKY() {
        AppPreferencesSetting instance = AppPreferencesSetting.getInstance();
        StringBuilder sb = new StringBuilder();
        sb.append("key_last_template_info_refresh_time_");
        sb.append(this.ekf);
        return C4580b.m11663f(instance.getAppSettingStr(sb.toString(), ""), 28800);
    }

    private void aKZ() {
        TemplateInfo pz = C8733e.aMa().mo35132pz(this.eqr);
        if (pz != null) {
            m25999z(pz);
            C8739i.m25523cC(this.context, pz.ttid);
            ((C8853a) getMvpView()).notifyDataSetChanged();
            ToastUtils.longShow(this.context, this.context.getString(R.string.xiaoying_str_reward_video_ad_to_congrats_get));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: ap */
    public void m25979ap(int i, final boolean z) {
        if (z) {
            C8739i.m25524ho(this.context);
            if (1 == i) {
                this.byU = false;
                String format = new SimpleDateFormat("yyyyMMddHHmmss", Locale.US).format(new Date());
                AppPreferencesSetting instance = AppPreferencesSetting.getInstance();
                StringBuilder sb = new StringBuilder();
                sb.append("key_last_template_info_refresh_time_");
                sb.append(this.ekf);
                instance.setAppSettingStr(sb.toString(), format);
            }
            m25997v(false, i);
        }
        C1487a.aUa().mo10058o(new Runnable() {
            public void run() {
                ((C8853a) C8854b.this.getMvpView()).mo35256jD(z);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: cW */
    public List<TemplateInfo> m25983cW(List<TemplateInfo> list) {
        if (list == null || list.size() <= 0) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        for (TemplateInfo templateInfo : list) {
            try {
                if ((templateInfo instanceof RollInfo) && ((RollInfo) templateInfo).rollModel.isShowInMC == 0) {
                    arrayList.add(templateInfo);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return arrayList;
    }

    /* renamed from: dN */
    private void m25985dN(final int i, int i2) {
        C8670b.m25247d(this.ekf, i2, i, 0).mo10196g(C1820a.aVi()).mo10194f(C1820a.aVi()).mo10188a((C1850u<? super T>) new C1850u<List<TemplateResponseRoll>>() {
            /* renamed from: a */
            public void mo9883a(C1495b bVar) {
            }

            public void onError(Throwable th) {
                th.printStackTrace();
                C8854b.this.m25979ap(i, false);
                try {
                    if (th instanceof C9740h) {
                        UserBehaviorUtilsV5.onEventTemplateListServerResult(VivaBaseApplication.m8749FZ(), C8854b.this.ekf, ((JsonObject) new Gson().fromJson(((C9740h) th).baz().baJ().charStream(), JsonObject.class)).get(IronSourceConstants.EVENTS_ERROR_CODE).getAsInt(), -1, ParametersKeys.FAILED, "tz");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            public void onSuccess(List<TemplateResponseRoll> list) {
                C8854b.this.m25979ap(i, true);
                if (list.size() == 0) {
                    UserBehaviorUtilsV5.onEventTemplateListServerResult(C8854b.this.context, C8854b.this.ekf, -1, -1, "success", "tz");
                }
            }
        });
    }

    /* renamed from: dO */
    private void m25986dO(final int i, int i2) {
        final int i3 = C8399c.ecX.equals(this.ekf) ? this.enc : 3;
        C88647 r1 = new C1850u<List<TemplateResponseInfo>>() {
            /* renamed from: a */
            public void mo9883a(C1495b bVar) {
            }

            public void onError(Throwable th) {
                C8854b.this.m25979ap(i, false);
                try {
                    if (th instanceof C9740h) {
                        UserBehaviorUtilsV5.onEventTemplateListServerResult(VivaBaseApplication.m8749FZ(), C8854b.this.ekf, ((JsonObject) new Gson().fromJson(((C9740h) th).baz().baJ().charStream(), JsonObject.class)).get(IronSourceConstants.EVENTS_ERROR_CODE).getAsInt(), i3, ParametersKeys.FAILED, "tb");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            public void onSuccess(List<TemplateResponseInfo> list) {
                C8854b.this.m25979ap(i, true);
                if (list.size() == 0) {
                    UserBehaviorUtilsV5.onEventTemplateListServerResult(VivaBaseApplication.m8749FZ(), C8854b.this.ekf, -1, i3, "success", "tb");
                }
            }
        };
        if (C8399c.ecX.equals(this.ekf)) {
            AppPreferencesSetting.getInstance().setAppSettingInt("key_last_template_theme_type", this.enc);
            C8670b.m25245a(this.ekf, i2, i, this.enc, 0, String.valueOf(C8451b.THEME.code)).mo10196g(C1820a.aVi()).mo10194f(C1820a.aVi()).mo10188a((C1850u<? super T>) r1);
            return;
        }
        C8670b.m25245a(this.ekf, i2, i, 3, 0, "").mo10196g(C1820a.aVi()).mo10194f(C1820a.aVi()).mo10188a((C1850u<? super T>) r1);
    }

    /* renamed from: gc */
    public static boolean m25988gc(String str) {
        return C8399c.ede.equals(str);
    }

    /* renamed from: pB */
    private void m25989pB(String str) {
        TemplateInfo pz = C8733e.aMa().mo35132pz(str);
        String str2 = null;
        if (C8399c.edb.equals(this.ekf) || C8399c.ede.equals(this.ekf)) {
            String str3 = m25988gc(this.ekf) ? "Template_Download_All_Sticker" : "Template_Download_All_Title";
            Context context2 = this.context;
            String str4 = "list";
            if (pz != null) {
                str2 = pz.strTitle;
            }
            UserEventDurationRelaUtils.finishDuraEventSuc(context2, str, str3, str4, str2);
        } else if (C8399c.ecX.equals(this.ekf)) {
            String str5 = "Template_Download_Theme";
            Context context3 = this.context;
            String str6 = "list";
            if (pz != null) {
                str2 = pz.strTitle;
            }
            UserEventDurationRelaUtils.finishDuraEventSuc(context3, str, str5, str6, str2);
        } else if (C8399c.edd.equals(this.ekf)) {
            String str7 = "Template_Download_FX";
            Context context4 = this.context;
            String str8 = "list";
            if (pz != null) {
                str2 = pz.strTitle;
            }
            UserEventDurationRelaUtils.finishDuraEventSuc(context4, str, str7, str8, str2);
        } else if (C8399c.ecZ.equals(this.ekf)) {
            String str9 = "Template_Download_Transion";
            Context context5 = this.context;
            String str10 = "list";
            if (pz != null) {
                str2 = pz.strTitle;
            }
            UserEventDurationRelaUtils.finishDuraEventSuc(context5, str, str9, str10, str2);
        }
    }

    /* renamed from: pC */
    private void m25990pC(String str) {
        TemplateInfo pz = C8733e.aMa().mo35132pz(str);
        String str2 = null;
        if (C8399c.edb.equals(this.ekf) || C8399c.ede.equals(this.ekf)) {
            String str3 = m25988gc(this.ekf) ? "Template_Download_All_Sticker" : "Template_Download_All_Title";
            Context context2 = this.context;
            String str4 = "list";
            if (pz != null) {
                str2 = pz.strTitle;
            }
            UserEventDurationRelaUtils.finishDuraEventFail(context2, str, str3, str4, str2);
        } else if (C8399c.ecX.equals(this.ekf)) {
            String str5 = "Template_Download_Theme";
            Context context3 = this.context;
            String str6 = "list";
            if (pz != null) {
                str2 = pz.strTitle;
            }
            UserEventDurationRelaUtils.finishDuraEventFail(context3, str, str5, str6, str2);
        } else if (C8399c.edd.equals(this.ekf)) {
            String str7 = "Template_Download_FX";
            Context context4 = this.context;
            String str8 = "list";
            if (pz != null) {
                str2 = pz.strTitle;
            }
            UserEventDurationRelaUtils.finishDuraEventFail(context4, str, str7, str8, str2);
        } else if (C8399c.ecZ.equals(this.ekf)) {
            String str9 = "Template_Download_Transion";
            Context context5 = this.context;
            String str10 = "list";
            if (pz != null) {
                str2 = pz.strTitle;
            }
            UserEventDurationRelaUtils.finishDuraEventFail(context5, str, str9, str10, str2);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0123, code lost:
        return;
     */
    /* renamed from: pL */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void m25991pL(java.lang.String r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            com.introvd.template.template.e.e r0 = com.introvd.template.template.p407e.C8733e.aMa()     // Catch:{ all -> 0x0124 }
            com.introvd.template.sdk.model.template.TemplateInfo r0 = r0.mo35132pz(r5)     // Catch:{ all -> 0x0124 }
            if (r0 != 0) goto L_0x000d
            monitor-exit(r4)
            return
        L_0x000d:
            int r1 = r0.nState     // Catch:{ all -> 0x0124 }
            r2 = 8
            r3 = 1
            if (r1 == r3) goto L_0x007a
            r5 = 6
            if (r1 == r5) goto L_0x0075
            if (r1 == r2) goto L_0x0066
            switch(r1) {
                case 3: goto L_0x0075;
                case 4: goto L_0x001e;
                default: goto L_0x001c;
            }     // Catch:{ all -> 0x0124 }
        L_0x001c:
            goto L_0x0122
        L_0x001e:
            com.introvd.template.common.controller.MvpView r5 = r4.getMvpView()     // Catch:{ all -> 0x0124 }
            com.introvd.template.template.info.b.a r5 = (com.introvd.template.template.info.p411b.C8853a) r5     // Catch:{ all -> 0x0124 }
            android.app.Activity r5 = r5.getHostActivity()     // Catch:{ all -> 0x0124 }
            boolean r5 = r5.isFinishing()     // Catch:{ all -> 0x0124 }
            if (r5 != 0) goto L_0x0122
            com.introvd.template.common.controller.MvpView r5 = r4.getMvpView()     // Catch:{ all -> 0x0124 }
            com.introvd.template.template.info.b.a r5 = (com.introvd.template.template.info.p411b.C8853a) r5     // Catch:{ all -> 0x0124 }
            android.app.Activity r5 = r5.getHostActivity()     // Catch:{ all -> 0x0124 }
            com.afollestad.materialdialogs.f$a r5 = com.introvd.template.p414ui.dialog.C8978m.m26349hs(r5)     // Catch:{ all -> 0x0124 }
            int r0 = com.introvd.template.template.R.string.xiaoying_str_com_info_title     // Catch:{ all -> 0x0124 }
            com.afollestad.materialdialogs.f$a r5 = r5.mo10293dl(r0)     // Catch:{ all -> 0x0124 }
            int r0 = com.introvd.template.template.R.string.xiaoying_str_template_msg_update_app_for_support_template     // Catch:{ all -> 0x0124 }
            com.afollestad.materialdialogs.f$a r5 = r5.mo10296do(r0)     // Catch:{ all -> 0x0124 }
            int r0 = com.introvd.template.template.R.string.xiaoying_str_com_cancel     // Catch:{ all -> 0x0124 }
            com.afollestad.materialdialogs.f$a r5 = r5.mo10303dv(r0)     // Catch:{ all -> 0x0124 }
            int r0 = com.introvd.template.template.R.string.xiaoying_str_template_state_update_app     // Catch:{ all -> 0x0124 }
            com.afollestad.materialdialogs.f$a r5 = r5.mo10299dr(r0)     // Catch:{ all -> 0x0124 }
            com.introvd.template.template.info.b.b$3 r0 = new com.introvd.template.template.info.b.b$3     // Catch:{ all -> 0x0124 }
            r0.<init>()     // Catch:{ all -> 0x0124 }
            com.afollestad.materialdialogs.f$a r5 = r5.mo10281a(r0)     // Catch:{ all -> 0x0124 }
            com.afollestad.materialdialogs.f r5 = r5.mo10313qu()     // Catch:{ all -> 0x0124 }
            r5.show()     // Catch:{ all -> 0x0124 }
            goto L_0x0122
        L_0x0066:
            android.content.Context r5 = r4.context     // Catch:{ all -> 0x0124 }
            com.introvd.template.template.download.e r5 = com.introvd.template.template.download.C8705e.m25369gZ(r5)     // Catch:{ all -> 0x0124 }
            java.lang.String r1 = r0.ttid     // Catch:{ all -> 0x0124 }
            r5.mo35083pi(r1)     // Catch:{ all -> 0x0124 }
            r0.nState = r3     // Catch:{ all -> 0x0124 }
            goto L_0x0122
        L_0x0075:
            r4.m25995u(r0)     // Catch:{ all -> 0x0124 }
            goto L_0x0122
        L_0x007a:
            android.content.Context r1 = r4.context     // Catch:{ all -> 0x0124 }
            boolean r1 = com.introvd.template.p203b.C4600l.m11739k(r1, r3)     // Catch:{ all -> 0x0124 }
            if (r1 != 0) goto L_0x0084
            monitor-exit(r4)
            return
        L_0x0084:
            java.lang.String r1 = r0.ttid     // Catch:{ all -> 0x0124 }
            boolean r1 = com.introvd.template.template.p407e.C8739i.m25526qq(r1)     // Catch:{ all -> 0x0124 }
            r3 = 3
            if (r1 == 0) goto L_0x00fa
            int r1 = r0.nState     // Catch:{ all -> 0x0124 }
            if (r1 == r3) goto L_0x00fa
            java.lang.String r1 = com.introvd.template.sdk.p383c.C8399c.ecX     // Catch:{ all -> 0x0124 }
            java.lang.String r2 = r4.ekf     // Catch:{ all -> 0x0124 }
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0124 }
            if (r1 == 0) goto L_0x00a0
            r4.m25992pM(r5)     // Catch:{ all -> 0x0124 }
            goto L_0x0122
        L_0x00a0:
            java.lang.String r1 = com.introvd.template.sdk.p383c.C8399c.edb     // Catch:{ all -> 0x0124 }
            java.lang.String r2 = r4.ekf     // Catch:{ all -> 0x0124 }
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0124 }
            if (r1 != 0) goto L_0x00b4
            java.lang.String r1 = com.introvd.template.sdk.p383c.C8399c.ede     // Catch:{ all -> 0x0124 }
            java.lang.String r2 = r4.ekf     // Catch:{ all -> 0x0124 }
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0124 }
            if (r1 == 0) goto L_0x0122
        L_0x00b4:
            r4.eqr = r5     // Catch:{ all -> 0x0124 }
            com.introvd.template.module.iap.business.d r5 = r4.bNG     // Catch:{ all -> 0x0124 }
            if (r5 != 0) goto L_0x00cb
            com.introvd.template.module.iap.business.d r5 = new com.introvd.template.module.iap.business.d     // Catch:{ all -> 0x0124 }
            com.introvd.template.common.controller.MvpView r1 = r4.getMvpView()     // Catch:{ all -> 0x0124 }
            com.introvd.template.template.info.b.a r1 = (com.introvd.template.template.info.p411b.C8853a) r1     // Catch:{ all -> 0x0124 }
            android.app.Activity r1 = r1.getHostActivity()     // Catch:{ all -> 0x0124 }
            r5.<init>(r1)     // Catch:{ all -> 0x0124 }
            r4.bNG = r5     // Catch:{ all -> 0x0124 }
        L_0x00cb:
            com.introvd.template.module.iap.business.d r5 = r4.bNG     // Catch:{ all -> 0x0124 }
            java.lang.String r1 = r0.ttid     // Catch:{ all -> 0x0124 }
            r5.templateId = r1     // Catch:{ all -> 0x0124 }
            com.introvd.template.module.iap.business.d r5 = r4.bNG     // Catch:{ all -> 0x0124 }
            com.introvd.template.module.ad.f r1 = com.introvd.template.module.p326ad.C7680l.aAe()     // Catch:{ all -> 0x0124 }
            com.introvd.template.common.controller.MvpView r2 = r4.getMvpView()     // Catch:{ all -> 0x0124 }
            com.introvd.template.template.info.b.a r2 = (com.introvd.template.template.info.p411b.C8853a) r2     // Catch:{ all -> 0x0124 }
            android.app.Activity r2 = r2.getHostActivity()     // Catch:{ all -> 0x0124 }
            r3 = 19
            boolean r1 = r1.isAdAvailable(r2, r3)     // Catch:{ all -> 0x0124 }
            r5.mo32790iE(r1)     // Catch:{ all -> 0x0124 }
            com.introvd.template.module.iap.business.d r5 = r4.bNG     // Catch:{ all -> 0x0124 }
            com.introvd.template.template.info.b.b$2 r1 = new com.introvd.template.template.info.b.b$2     // Catch:{ all -> 0x0124 }
            r1.<init>(r0)     // Catch:{ all -> 0x0124 }
            r5.mo32789a(r1)     // Catch:{ all -> 0x0124 }
            com.introvd.template.module.iap.business.d r5 = r4.bNG     // Catch:{ all -> 0x0124 }
            r5.show()     // Catch:{ all -> 0x0124 }
            goto L_0x0122
        L_0x00fa:
            java.lang.String r1 = r0.ttid     // Catch:{ all -> 0x0124 }
            boolean r1 = com.introvd.template.template.p407e.C8739i.m25527qr(r1)     // Catch:{ all -> 0x0124 }
            if (r1 == 0) goto L_0x011a
            int r1 = r0.nState     // Catch:{ all -> 0x0124 }
            if (r1 == r3) goto L_0x011a
            r4.eqr = r5     // Catch:{ all -> 0x0124 }
            com.introvd.template.common.controller.MvpView r5 = r4.getMvpView()     // Catch:{ all -> 0x0124 }
            com.introvd.template.template.info.b.a r5 = (com.introvd.template.template.info.p411b.C8853a) r5     // Catch:{ all -> 0x0124 }
            android.app.Activity r5 = r5.getHostActivity()     // Catch:{ all -> 0x0124 }
            r1 = 4369(0x1111, float:6.122E-42)
            java.lang.String r0 = r0.strTitle     // Catch:{ all -> 0x0124 }
            com.introvd.template.p203b.C4586g.m11710d(r5, r1, r0)     // Catch:{ all -> 0x0124 }
            goto L_0x0122
        L_0x011a:
            boolean r5 = r4.m25999z(r0)     // Catch:{ all -> 0x0124 }
            if (r5 == 0) goto L_0x0122
            r0.nState = r2     // Catch:{ all -> 0x0124 }
        L_0x0122:
            monitor-exit(r4)
            return
        L_0x0124:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.template.info.p411b.C8854b.m25991pL(java.lang.String):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: pM */
    public void m25992pM(String str) {
        TemplateInfo pz = C8733e.aMa().mo35132pz(str);
        if (pz != null) {
            if (C8735f.m25479qm(this.ekf)) {
                this.eqq = str;
                m25996v(pz);
            } else if (!TextUtils.isEmpty(pz.strPreviewurl)) {
                this.eqq = str;
                m25998y(pz);
            }
        }
    }

    /* renamed from: s */
    private void m25993s(TemplateInfo templateInfo) {
        if (templateInfo != null) {
            if (C8762d.aMt().mo35228bE(C2575a.m7391rq(templateInfo.ttid))) {
                C8705e.m25369gZ(this.context).mo35081b(templateInfo.ttid, templateInfo.strVer, templateInfo.strUrl, templateInfo.nSize);
                C8735f.aMf().mo35136D(templateInfo);
            } else if (!C8735f.aMf().mo35154qo(templateInfo.ttid)) {
                mo30336iA(templateInfo.ttid);
            }
        }
    }

    /* renamed from: t */
    private void m25994t(TemplateInfo templateInfo) {
        if (templateInfo != null) {
            String str = ((RollInfo) templateInfo).rollModel.rollDownUrl;
            if (C8399c.ede.equals(this.ekf)) {
                HashMap hashMap = new HashMap();
                hashMap.put("stickerid", templateInfo.ttid);
                UserBehaviorLog.onKVEvent(this.context, "Dev_Event_App_Error_analysis", hashMap);
            }
            UserEventDurationRelaUtils.startDurationEvent(templateInfo.ttid, templateInfo.nSize, C4605o.getHost(str));
            if (C8745n.m25561qv(templateInfo.ttid)) {
                mo30336iA(templateInfo.ttid);
            } else if (!C8735f.aMf().mo35154qo(templateInfo.ttid)) {
                C8705e.m25369gZ(this.context).mo35084y(templateInfo.ttid, templateInfo.strVer, str);
                C8735f.aMf().mo35136D(templateInfo);
            }
        }
    }

    /* renamed from: u */
    private void m25995u(TemplateInfo templateInfo) {
        if (((C8853a) getMvpView()).aKK()) {
            if (templateInfo != null) {
                long rq = C2575a.m7391rq(templateInfo.ttid);
                if (C8735f.m25479qm(this.ekf)) {
                    rq = C8745n.m25563qx(templateInfo.ttid).longValue();
                }
                String bB = C8762d.aMt().mo35225bB(rq);
                Intent intent = new Intent();
                intent.putExtra("template_path", bB);
                ((C8853a) getMvpView()).getHostActivity().setResult(-1, intent);
            }
            ((C8853a) getMvpView()).getHostActivity().finish();
        } else if (templateInfo != null) {
            long rq2 = C2575a.m7391rq(templateInfo.ttid);
            if (C8735f.m25479qm(this.ekf)) {
                rq2 = C8745n.m25563qx(templateInfo.ttid).longValue();
            }
            C8728c.m25457a(((C8853a) getMvpView()).getHostActivity(), templateInfo.tcid, Long.valueOf(rq2), "");
        }
    }

    /* renamed from: v */
    private void m25996v(TemplateInfo templateInfo) {
        if (templateInfo != null) {
            C8622a.ekc = templateInfo;
            TemplateRouter.getRouterBuilder(((C8853a) getMvpView()).getHostActivity().getApplication(), TemplateRouter.URL_TEMPLATE_ROLL_DETAIL).mo10399f(TemplateRouter.EXTRA_KEY_TEMPLATE_CATEGORY_ID, this.ekf).mo10399f(TemplateRouter.KEY_TEMPLATE_CARD_PREVIEW_TTID, templateInfo.ttid).mo10396b(((C8853a) getMvpView()).getHostActivity(), 4368);
        }
    }

    /* renamed from: v */
    private void m25997v(final boolean z, final int i) {
        if (this.eqs != null) {
            this.eqs.dispose();
            this.eqs = null;
        }
        C1834l.m5254a((C1839n<T>) new C1839n<List<TemplateInfo>>() {
            /* renamed from: a */
            public void mo10177a(C1838m<List<TemplateInfo>> mVar) throws Exception {
                C8735f.aMf().mo35147cz(C8854b.this.context, C8854b.this.ekf);
                List qk = C8735f.aMf().mo35151qk(C8854b.this.ekf);
                if (C8399c.edd.equals(C8854b.this.ekf)) {
                    C8733e.aMa().mo35131j(C8854b.this.context, qk);
                }
                mVar.mo9791K(qk);
            }
        }).mo10157d(C1820a.aVi()).mo10152c(C1487a.aUa()).mo10149b((C1842q<? super T>) new C1842q<List<TemplateInfo>>() {
            /* renamed from: R */
            public void mo9886K(List<TemplateInfo> list) {
                int aKJ = ((C8853a) C8854b.this.getMvpView()).aKJ();
                int size = list == null ? 0 : list.size();
                if (size == 0) {
                    ((C8853a) C8854b.this.getMvpView()).mo35260uI(0);
                } else if (aKJ == size) {
                    C8854b.this.byU = true;
                    ((C8853a) C8854b.this.getMvpView()).mo35260uI(6);
                } else {
                    C8854b.this.byU = false;
                    ((C8853a) C8854b.this.getMvpView()).mo35260uI(2);
                }
                if (z && list != null && list.size() > 0) {
                    for (TemplateInfo templateInfo : list) {
                        if (templateInfo.nState == 8) {
                            templateInfo.nState = 1;
                        }
                    }
                }
                if (C8735f.m25479qm(C8854b.this.ekf)) {
                    list = C8854b.this.m25983cW(list);
                }
                C8854b.this.eqo = i;
                if (list != null && list.size() > 0) {
                    int i = i * 20;
                    if (i > list.size()) {
                        i = list.size();
                    }
                    try {
                        list = list.subList(0, i);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                ((C8853a) C8854b.this.getMvpView()).mo35257n(list, i);
            }

            /* renamed from: a */
            public void mo9877a(C1495b bVar) {
                C8854b.this.eqs = bVar;
                C8854b.this.compositeDisposable.mo9785e(bVar);
            }

            public void onComplete() {
            }

            public void onError(Throwable th) {
            }
        });
    }

    /* renamed from: y */
    private void m25998y(TemplateInfo templateInfo) {
        if (templateInfo == null || C8399c.ecZ.equals(this.ekf)) {
            LogUtils.m14222e(TAG, "TemplateInfo is null !");
            return;
        }
        C1941a f = TemplateRouter.getRouterBuilder(((C8853a) getMvpView()).getHostActivity().getApplication(), TemplateRouter.URL_TEMPLATE_PREVIEW).mo10406h(TemplateRouter.KEY_TEMPLATE_CARD_PREVIEW_TYPE, templateInfo.nPreviewtype).mo10391a(TemplateRouter.EXTRA_KEY_NEED_ACTIVITY_RESULT, ((C8853a) getMvpView()).aKK()).mo10399f(TemplateRouter.KEY_TEMPLATE_CARD_PREVIEW_TITLE, templateInfo.strTitle).mo10399f(TemplateRouter.KEY_TEMPLATE_CARD_PREVIEW_INTRO, templateInfo.strIntro).mo10399f(TemplateRouter.BUNDLE_TEMPLATE_DOWNLOAD_KEY, templateInfo.strUrl).mo10399f(TemplateRouter.KEY_TEMPLATE_CARD_PREVIEW_URL, templateInfo.strPreviewurl).mo10406h(TemplateRouter.KEY_TEMPLATE_CARD_PREVIEW_STATE, templateInfo.nState).mo10399f(TemplateRouter.KEY_TEMPLATE_CARD_PREVIEW_TTID, templateInfo.ttid).mo10399f(TemplateRouter.KEY_TEMPLATE_CARD_PREVIEW_VER, templateInfo.strVer);
        if (((C8853a) getMvpView()).aKK()) {
            f.mo10396b(((C8853a) getMvpView()).getHostActivity(), 9098);
        } else if (C8739i.isNeedToPurchase(templateInfo.ttid)) {
            f.mo10396b(((C8853a) getMvpView()).getHostActivity(), (int) IapRTConstants.REQUEST_CODE_FOR_VIP);
        } else {
            f.mo10382H(((C8853a) getMvpView()).getHostActivity());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: z */
    public boolean m25999z(TemplateInfo templateInfo) {
        if (!C4600l.m11739k(this.context, true) || templateInfo == null) {
            return false;
        }
        String str = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append(">>>>do Template Download ----,template id:");
        sb.append(templateInfo.ttid);
        LogUtils.m14223i(str, sb.toString());
        if (templateInfo instanceof RollInfo) {
            m25994t(templateInfo);
        } else {
            HashMap hashMap = new HashMap();
            hashMap.put("type", templateInfo.tcid);
            hashMap.put("name", templateInfo.strTitle);
            UserBehaviorLog.onKVEvent(this.context, "Template_Download_New", hashMap);
            m25993s(templateInfo);
        }
        return true;
    }

    /* renamed from: a */
    public void attachView(C8853a aVar) {
        super.attachView(aVar);
    }

    public int aLA() {
        if (!C8735f.m25479qm(this.ekf)) {
            return C8735f.aMf().mo35152ql(this.ekf);
        }
        int i = 0;
        List<TemplateInfo> qk = C8735f.aMf().mo35151qk(this.ekf);
        if (qk != null) {
            for (TemplateInfo templateInfo : qk) {
                try {
                    if ((templateInfo instanceof RollInfo) && ((RollInfo) templateInfo).rollModel.isShowInMC == 1) {
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                i++;
            }
        }
        return i;
    }

    public void aLB() {
        Intent intent = new Intent(((C8853a) getMvpView()).getHostActivity(), TemplateMgrActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString(TemplateRouter.EXTRA_KEY_TEMPLATE_CATEGORY_ID, this.ekf);
        bundle.putString(TemplateRouter.EXTRA_KEY_TEMPLATE_CATEGORY_TITLE, aLD());
        intent.putExtras(bundle);
        ((C8853a) getMvpView()).getHostActivity().startActivity(intent);
    }

    public C8908i aLC() {
        if (this.eqp == null) {
            this.eqp = new C8908i() {
                /* renamed from: cX */
                public void mo35389cX(final List<String> list) {
                    C2576a.m7392a(500, new C2578a() {
                        /* renamed from: bt */
                        public void mo12852bt(long j) {
                            if (list.size() > 0) {
                                C8854b.this.m25999z(C8733e.aMa().mo35132pz((String) list.get(0)));
                                list.remove(0);
                                return;
                            }
                            C2576a.cancel();
                        }
                    });
                }

                /* renamed from: pN */
                public void mo35390pN(String str) {
                    C8854b.this.m25992pM(str);
                }

                /* renamed from: pO */
                public void mo35391pO(String str) {
                    C8854b.this.m25991pL(str);
                }
            };
        }
        return this.eqp;
    }

    public String aLD() {
        String str = this.ekf.equals(C8399c.ecX) ? this.context.getString(R.string.xiaoying_str_ve_theme_title_common) : this.ekf.equals(C8399c.ecY) ? this.context.getString(R.string.xiaoying_str_ve_effect_title) : this.ekf.equals(C8399c.ecZ) ? this.context.getString(R.string.xiaoying_str_ve_transition_title) : this.ekf.equals(C8399c.eda) ? this.context.getString(R.string.xiaoying_str_ve_poster_title) : this.ekf.equals(C8399c.edb) ? this.context.getString(R.string.xiaoying_str_ve_subtitle_title) : this.ekf.equals(C8399c.edc) ? this.context.getString(R.string.xiaoying_str_ve_bgm_title) : this.ekf.equals(C8399c.edd) ? this.context.getString(R.string.xiaoying_str_ve_animate_frame_title) : this.ekf.equals(C8399c.ede) ? this.context.getString(R.string.xiaoying_str_ve_sticker) : C8645a.m25200pt(this.ekf) ? "Giphy" : "";
        C7591a.m22374kd("top");
        C7591a.m22375ke(str);
        return str;
    }

    public void aLz() {
        int aLA = aLA();
        if (!C4600l.m11739k(this.context, true)) {
            ((C8853a) getMvpView()).aKH();
            return;
        }
        if (aLA == 0 || aKY() || (C8399c.ecX.equals(this.ekf) && AppPreferencesSetting.getInstance().getAppSettingInt("key_last_template_theme_type", 3) != this.enc)) {
            ((C8853a) getMvpView()).aKI();
            if (C8399c.edd.equals(this.ekf)) {
                mo35384dM(1, 2000);
            } else {
                mo35384dM(1, 20);
            }
        } else {
            m25997v(true, 1);
        }
    }

    public void arB() {
    }

    public void arC() {
    }

    /* renamed from: bR */
    public void mo35383bR(final Context context2, String str) {
        this.context = context2;
        this.ekf = str;
        this.compositeDisposable = new C1494a();
        C10021c.aZH().mo38494ax(this);
        C8735f.aMf().mo35147cz(context2, this.ekf);
        C8735f.aMf().mo35148l(context2, this.ekf, 1);
        C8705e.m25369gZ(context2).mo35079a((C8707b) this);
        this.compositeDisposable.mo9785e(C1487a.aUa().mo9777a(new Runnable() {
            public void run() {
                if (C8735f.aMf().mo35143aq(context2, C8854b.this.ekf)) {
                    AppPreferencesSetting instance = AppPreferencesSetting.getInstance();
                    StringBuilder sb = new StringBuilder();
                    sb.append("key_last_template_info_refresh_time_");
                    sb.append(C8854b.this.ekf);
                    instance.setAppSettingStr(sb.toString(), "");
                }
                C8735f.aMf().mo35149m(context2, C8854b.this.ekf, true);
            }
        }, 800, TimeUnit.MILLISECONDS));
        aKP();
    }

    /* renamed from: dM */
    public void mo35384dM(int i, int i2) {
        if (C8735f.m25479qm(this.ekf)) {
            m25985dN(i, i2);
        } else {
            m25986dO(i, i2);
        }
    }

    public void detachView() {
        super.detachView();
    }

    /* renamed from: iA */
    public void mo30336iA(String str) {
        LogUtils.m14222e(TAG, "-----onDownLoadSuccess:");
        C8735f.aMf().mo35153qn(str);
        C8733e.aMa().mo35125Y(str, 3);
        C8735f.aMf().mo35135C(C8733e.aMa().mo35132pz(str));
        ((C8853a) getMvpView()).mo35261z(str, true);
        m25989pB(str);
    }

    /* renamed from: iB */
    public void mo30337iB(String str) {
        LogUtils.m14222e(TAG, "-----onDownLoadFail:");
        C8733e.aMa().mo35125Y(str, 1);
        C8735f.aMf().mo35135C(C8733e.aMa().mo35132pz(str));
        ((C8853a) getMvpView()).mo35261z(str, true);
        m25990pC(str);
        if (!TextUtils.isEmpty(this.eqr)) {
            this.eqr = "";
        }
    }

    /* renamed from: iC */
    public void mo30338iC(String str) {
        ((C8853a) getMvpView()).mo35250S(str, 0);
        C8733e.aMa().mo35125Y(str, 1);
        C8735f.aMf().mo35135C(C8733e.aMa().mo35132pz(str));
    }

    /* renamed from: ix */
    public void mo30340ix(String str) {
    }

    /* renamed from: iy */
    public void mo30341iy(String str) {
    }

    /* renamed from: iz */
    public void mo30342iz(String str) {
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 9098) {
            if (i2 == 1) {
                C1487a.aUa().mo9777a(new Runnable() {
                    public void run() {
                        C8854b.this.m25991pL(C8854b.this.eqq);
                    }
                }, 500, TimeUnit.MILLISECONDS);
            }
        } else if (i == 4368) {
            if (i2 == -1) {
                m25995u(C8622a.ekc);
            }
        } else if (i == 9527) {
            if (i2 == -1 && C8399c.ecX.equals(this.ekf)) {
                ((C8853a) getMvpView()).notifyDataSetChanged();
            }
        } else if (i == 4369) {
            aKZ();
        }
    }

    public void onAdLoaded(AdPositionInfoParam adPositionInfoParam, boolean z, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("load:");
        sb.append(z);
        sb.append("/");
        sb.append(str);
        LogUtils.m14222e("Unlock_theme", sb.toString());
    }

    @C10031j(aZK = ThreadMode.MAIN)
    public void onEventMainThread(C8628a aVar) {
        if (this.ekf != null && this.ekf.equals(aVar.mo34931WR())) {
            C8733e.aMa().mo35125Y(aVar.getTtid(), 1);
            ((C8853a) getMvpView()).mo35259pu(aVar.getTtid());
        }
    }

    public void onShowVideoAd(AdPositionInfoParam adPositionInfoParam, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("available:");
        sb.append(z);
        LogUtils.m14222e("Unlock_theme", sb.toString());
    }

    public void release() {
        if (this.compositeDisposable != null) {
            this.compositeDisposable.clear();
        }
        if (this.bNG != null && this.bNG.isShowing()) {
            this.bNG.dismiss();
        }
        C10021c.aZH().mo38496az(this);
        C2576a.cancel();
        C8705e.m25369gZ(this.context).mo35080b((C8707b) this);
        C8035c.release();
        C7680l.aAe().releasePosition(19, false);
    }

    /* renamed from: w */
    public void mo30344w(String str, int i) {
        String str2 = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("-----onDownLoadProgressChanged progress:");
        sb.append(i);
        LogUtils.m14222e(str2, sb.toString());
        if (i == 100) {
            C8733e.aMa().mo35125Y(str, 3);
        } else {
            C8733e.aMa().mo35125Y(str, 8);
        }
        C8735f.aMf().mo35135C(C8733e.aMa().mo35132pz(str));
        ((C8853a) getMvpView()).mo35250S(str, i);
    }
}
