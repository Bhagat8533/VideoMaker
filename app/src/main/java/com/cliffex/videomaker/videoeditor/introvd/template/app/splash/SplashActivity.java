package com.introvd.template.app.splash;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.aiii.android.arouter.p091c.C1919a;
import com.introvd.template.C3569a;
import com.introvd.template.EventActivity;
import com.introvd.template.R;
import com.introvd.template.ads.entity.AdPositionInfoParam;
import com.introvd.template.ads.listener.ViewAdsListener;
import com.introvd.template.app.AppListener;
import com.introvd.template.app.ApplicationBase;
import com.introvd.template.app.C4037m;
import com.introvd.template.app.ads.C3722f;
import com.introvd.template.app.model.SplashItemInfo;
import com.introvd.template.app.p177b.C3741a;
import com.introvd.template.app.push.C4103b;
import com.introvd.template.app.splash.C4370e.C4377a;
import com.introvd.template.app.utils.C4395c;
import com.introvd.template.app.welcomepage.WelcomeV6Activity;
import com.introvd.template.common.AppPreferencesSetting;
import com.introvd.template.common.LogUtils;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.common.UserBehaviorLog;
import com.introvd.template.common.behavior.UserBehaviorABTestUtils;
import com.introvd.template.datacenter.SocialConstDef;
import com.introvd.template.module.p325a.C7572a;
import com.introvd.template.module.p326ad.C7680l;
import com.introvd.template.p173a.p174a.C3571a;
import com.introvd.template.p173a.p174a.C3574d;
import com.introvd.template.p203b.C4596h;
import com.introvd.template.p242d.C5527a;
import com.introvd.template.p363o.C8099d;
import com.introvd.template.router.app.IAppService;
import com.introvd.template.router.user.UserServiceProxy;
import com.introvd.template.starvlogs.logfirebase.ActionFirebaseStarVlogs;
import com.introvd.template.wxapi.C9083a;
import com.p131c.p132a.C2561a;
import com.p131c.p132a.C2570b;
import com.p131c.p132a.p135c.C2575a;
import com.quvideo.mobile.component.push.C4780a;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import p037b.p050b.C1834l;
import p037b.p050b.C1842q;
import p037b.p050b.C1850u;
import p037b.p050b.p051a.p053b.C1487a;
import p037b.p050b.p057e.C1517e;
import p037b.p050b.p073g.C1808a;
import p037b.p050b.p073g.C1810c;

public class SplashActivity extends EventActivity {
    /* access modifiers changed from: private */
    public static boolean bDX = true;
    /* access modifiers changed from: private */
    public C4379f bDS = null;
    private boolean bDT = false;
    /* access modifiers changed from: private */
    public volatile boolean bDU = false;
    /* access modifiers changed from: private */
    public volatile boolean bDV = false;
    private ImageView bDY;
    /* access modifiers changed from: private */
    public ImageView bDZ;
    /* access modifiers changed from: private */
    public TextView bEa;
    private ImageView bEb;
    private ImageView bEc;
    /* access modifiers changed from: private */
    public SplashItemInfo bEd = null;
    private CountDownTimer bEe = null;
    private long bEf = 0;
    private int bEg = 0;
    /* access modifiers changed from: private */
    public boolean bEh = false;
    /* access modifiers changed from: private */
    public volatile int bEi = 800;
    /* access modifiers changed from: private */
    public boolean bEj = true;
    public boolean bEk = false;
    public int bEl;
    private final int bEm = 2000;
    /* access modifiers changed from: private */
    public boolean bEn = false;
    private boolean bEo = false;
    private C4370e bEp;
    private C1808a bEq;
    private ViewAdsListener bEr = new ViewAdsListener() {
        public void onAdLoaded(AdPositionInfoParam adPositionInfoParam, boolean z, String str) {
            if (z && !SplashActivity.this.isFinishing() && !SplashActivity.this.bEj) {
                C4359a.m10939Qc().mo24418a(SplashActivity.this.getApplicationContext(), SplashActivity.this.m10905PZ());
                C1834l.m5257ah(Boolean.valueOf(true)).mo10157d(C1487a.aUa()).mo10152c(C1487a.aUa()).mo10161e((C1517e<? super T>) new C1517e<Boolean>() {
                    /* renamed from: d */
                    public void accept(Boolean bool) {
                        if (!SplashActivity.this.isFinishing()) {
                            SplashActivity.this.m10898PS();
                            SplashActivity.this.m10903PX();
                        }
                    }
                }).aTR();
            }
        }
    };

    /* renamed from: po */
    private OnClickListener f3400po = new OnClickListener() {
        public void onClick(View view) {
            if (view.equals(SplashActivity.this.bEa)) {
                SplashActivity.this.m10904PY();
                C4359a.m10939Qc().mo24414Qe();
                String str = "spslmeoaih_pkhs_";
                C4386g.m11044a(SplashActivity.this.bEd, "home_splash_skip");
                SplashActivity.this.bEa.setVisibility(0);
                SplashActivity.this.bEd = null;
                SplashActivity.this.bEi = 100;
                SplashActivity.this.m10916bQ(true);
                SplashActivity.this.bEa.setOnClickListener(null);
            } else if (view.equals(SplashActivity.this.bDZ)) {
                SplashActivity.this.m10904PY();
                C4386g.m11044a(SplashActivity.this.bEd, "Home_splash_click");
                if (SplashActivity.this.bEd != null) {
                    UserBehaviorABTestUtils.onEventShowSplash(SplashActivity.this.getApplicationContext(), SplashActivity.this.bEd.mTitle, SplashActivity.this.bEd.lId, false);
                }
                SplashActivity.this.bEi = 100;
                SplashActivity.this.m10916bQ(true);
                SplashActivity.this.bEh = true;
                SplashActivity.this.bDZ.setOnClickListener(null);
            }
        }
    };

    /* access modifiers changed from: private */
    /* renamed from: H */
    public String m10892H(long j) {
        long j2 = (j + 500) / 1000;
        int i = R.string.xiaoying_str_app_splash_skip_template;
        StringBuilder sb = new StringBuilder();
        String str = "";
        sb.append("");
        sb.append(j2);
        return getString(i, new Object[]{sb.toString()});
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0048  */
    /* renamed from: Oj */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m10893Oj() {
        /*
            r3 = this;
            r2 = 4
            int r0 = com.introvd.template.R.layout.splash_layout
            r2 = 4
            r3.setContentView(r0)
            int r0 = com.introvd.template.p242d.C5530d.m14976aj(r3)
            r2 = 5
            r3.bEg = r0
            int r0 = com.introvd.template.R.id.img_splash_logo
            r2 = 2
            android.view.View r0 = r3.findViewById(r0)
            r2 = 3
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            r3.bDY = r0
            r2 = 4
            int r0 = com.introvd.template.R.id.img_splash_dynaimg
            android.view.View r0 = r3.findViewById(r0)
            r2 = 1
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            r2 = 6
            r3.bDZ = r0
            r2 = 0
            boolean r0 = com.introvd.template.C3569a.m8772FK()
            r2 = 0
            if (r0 != 0) goto L_0x0040
            r2 = 2
            com.introvd.template.app.splash.d r0 = com.introvd.template.app.splash.C4368d.m10988Qu()
            boolean r0 = r0.mo24426Qy()
            r2 = 2
            if (r0 == 0) goto L_0x003d
            r2 = 5
            goto L_0x0040
        L_0x003d:
            r2 = 6
            r0 = 0
            goto L_0x0042
        L_0x0040:
            r2 = 5
            r0 = 1
        L_0x0042:
            if (r0 == 0) goto L_0x0048
            r2 = 3
            int r0 = com.introvd.template.R.id.txtview_count_first
            goto L_0x004b
        L_0x0048:
            r2 = 0
            int r0 = com.introvd.template.R.id.txtview_count
        L_0x004b:
            android.view.View r0 = r3.findViewById(r0)
            r2 = 5
            android.widget.TextView r0 = (android.widget.TextView) r0
            r3.bEa = r0
            int r0 = com.introvd.template.R.id.img_middle_logo
            android.view.View r0 = r3.findViewById(r0)
            r2 = 4
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            r2 = 1
            r3.bEb = r0
            r2 = 1
            int r0 = com.introvd.template.R.id.img_middle_slogan
            r2 = 6
            android.view.View r0 = r3.findViewById(r0)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            r2 = 0
            r3.bEc = r0
            r2 = 4
            android.widget.ImageView r0 = r3.bEb
            r2 = 3
            int r1 = com.introvd.template.R.drawable.vivavideo_splash_logo_n
            r2 = 7
            r0.setImageResource(r1)
            r2 = 6
            boolean r0 = com.introvd.template.p203b.C4580b.m11633Sg()
            if (r0 != 0) goto L_0x0094
            r2 = 7
            android.widget.ImageView r0 = r3.bDY
            r2 = 4
            int r1 = com.introvd.template.R.drawable.splash_intl_logo
            r2 = 6
            r0.setImageResource(r1)
            r2 = 7
            android.widget.ImageView r0 = r3.bEc
            r2 = 3
            int r1 = com.introvd.template.R.drawable.vivavideo_splash_text_en_n
            r2 = 7
            r0.setImageResource(r1)
            r2 = 2
            goto L_0x00b7
        L_0x0094:
            boolean r0 = com.introvd.template.p203b.C4580b.m11634Sh()
            r2 = 3
            if (r0 == 0) goto L_0x00a5
            android.widget.ImageView r0 = r3.bEc
            r2 = 1
            int r1 = com.introvd.template.R.drawable.vivavideo_splash_text_cn_tw_n
            r2 = 0
            r0.setImageResource(r1)
            goto L_0x00ae
        L_0x00a5:
            android.widget.ImageView r0 = r3.bEc
            r2 = 2
            int r1 = com.introvd.template.R.drawable.vivavideo_splash_text_cn_n
            r2 = 3
            r0.setImageResource(r1)
        L_0x00ae:
            android.widget.ImageView r0 = r3.bDY
            r2 = 5
            int r1 = com.introvd.template.R.drawable.splash_logo
            r2 = 4
            r0.setImageResource(r1)
        L_0x00b7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.app.splash.SplashActivity.m10893Oj():void");
    }

    /* access modifiers changed from: private */
    /* renamed from: PK */
    public void m10894PK() {
        if (this.bEp.mo24428b(this, getIntent())) {
            finish();
            return;
        }
        this.bEf = System.currentTimeMillis();
        m10893Oj();
        C3741a.m9109IG();
        C4037m.m10026a(this, getIntent(), false);
        if (C3569a.m8773FL()) {
            C4596h.m11723Sw();
        }
        C4370e.m11002Qz();
        requestPermission();
    }

    /* renamed from: PL */
    private void m10895PL() {
        C4370e.m11003a(this, new C4378b() {
            /* renamed from: PO */
            public void mo24401PO() {
                SplashActivity.this.finish();
            }

            public void onAuthSuceed() {
                String str = "e shASeucoCYtkAY he dcBnuht";
                LogUtilsV2.m14227d("YYB Auth Check onAuthSuceed");
                SplashActivity.this.m10894PK();
                SplashActivity.this.bDU = true;
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: PM */
    public void m10896PM() {
        C4370e.m11004a((C4377a) new C4377a() {
            /* renamed from: bP */
            public void mo24405bP(boolean z) {
                if (C3569a.m8772FK()) {
                    SplashActivity.this.initUI();
                } else if (!SplashActivity.bDX) {
                    SplashActivity.this.bEd = C4361c.m10978cP(SplashActivity.this);
                    SplashActivity.this.initUI();
                } else {
                    C4361c.m10977cO(SplashActivity.this).mo10194f(C1487a.aUa()).mo10188a((C1850u<? super T>) new C1810c<SplashItemInfo>() {
                        /* renamed from: a */
                        public void onSuccess(SplashItemInfo splashItemInfo) {
                            SplashActivity.this.bEd = splashItemInfo;
                            SplashActivity.this.initUI();
                        }

                        public void onError(Throwable th) {
                            SplashActivity.this.bEd = C4361c.m10978cP(SplashActivity.this);
                            SplashActivity.this.initUI();
                        }
                    });
                }
            }
        });
    }

    /* renamed from: PR */
    private void m10897PR() {
        String str = "ctssl_ardo";
        long ew = C3571a.m8784ew("cold_start");
        if (ew <= 0) {
            ew = 0;
        }
        C3571a.bKq = ew;
        String str2 = "tr_mhstta";
        C3571a.m8783ev("hot_start");
    }

    /* access modifiers changed from: private */
    /* renamed from: PS */
    public void m10898PS() {
        if (this.bEq != null && !this.bEq.aAy()) {
            this.bEq.dispose();
        }
        this.bEq = null;
    }

    /* access modifiers changed from: private */
    /* renamed from: PT */
    public void m10899PT() {
        if (!this.bEk || this.bEl >= 5) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                extras = new Bundle();
            }
            if (TextUtils.isEmpty(extras.getString("event"))) {
                StringBuilder sb = new StringBuilder();
                sb.append("has link : ");
                sb.append(C4037m.biD);
                LogUtilsV2.m14230i(sb.toString());
                if (!TextUtils.isEmpty(C4037m.biD)) {
                    String str = "bntev";
                    extras.putString("event", C4037m.biD);
                    String str2 = "erPuicbhsve";
                    extras.putString("PushService", "PushService");
                } else if (this.bEh && this.bEd != null) {
                    int parseInt = C2575a.parseInt(this.bEd.mEventCode);
                    StringBuilder sb2 = new StringBuilder();
                    String str3 = "doTJOeOtoooknsSt rDmedaC=";
                    sb2.append("makeTODOJsonStr todoCode=");
                    sb2.append(parseInt);
                    String str4 = ";n=ervampatmP";
                    sb2.append(";mEventParam=");
                    sb2.append(this.bEd.mEventParam);
                    LogUtilsV2.m14228e(sb2.toString());
                    String str5 = "etnvt";
                    extras.putString("event", C4395c.m11102h(parseInt, this.bEd.mEventParam));
                    extras.putString("PushService", "PushService");
                }
            }
            String str6 = "ersw_istnr__eesmapxqiasutare";
            Bundle bundle = extras.getBundle("extras_weixin_request_params");
            if (bundle != null) {
                C9083a.m26520a(this, bundle);
            }
            String str7 = "nytmr";
            extras.putInt("entry", this.bEg);
            getIntent().putExtras(extras);
            StringBuilder sb3 = new StringBuilder();
            sb3.append("is upgrade : ");
            sb3.append(C3569a.m8773FL());
            LogUtilsV2.m14230i(sb3.toString());
            StringBuilder sb4 = new StringBuilder();
            String str8 = "iu Ro rst :isf";
            sb4.append("is firstRun : ");
            sb4.append(C3569a.m8772FK());
            LogUtilsV2.m14230i(sb4.toString());
            if (!C3569a.m8774FM()) {
                AppPreferencesSetting.getInstance().setAppSettingBoolean("pref_home_creation_help_show_flag", true);
            }
            boolean b = m10914b(getApplicationContext(), "xiaoying_need_welcome", true);
            if (!C3569a.m8772FK() || !b) {
                String str9 = "toaogvbmgPAHoeeiycit";
                LogUtilsV2.m14228e("gotoHomePageActivity");
                if (!this.bEp.bEG) {
                    AppListener.gotoHomePageActivity(this, m10900PU());
                } else {
                    setResult(-1, getIntent());
                }
            } else {
                UserBehaviorLog.onKVEvent(getApplicationContext(), "New_Install", new HashMap());
                initData();
                String str10 = "gWotebmegpocloa";
                LogUtilsV2.m14228e("gotoWelcomepage");
                m10911a(this, C3569a.m8772FK(), C3569a.m8773FL());
            }
            String str11 = ")iacftitS.ysh(iptsvnAlh";
            LogUtilsV2.m14228e("SplashActivity.finish()");
            finish();
            return;
        }
        String str12 = "ilcno.l ibiawtnadl akge epfo rk";
        LogUtilsV2.m14230i("waiting for deeplink callback. ");
        m10916bQ(false);
        this.bEl++;
    }

    /* renamed from: PU */
    private HashMap<String, Object> m10900PU() {
        HashMap<String, Object> hashMap = new HashMap<>();
        String dataString = getIntent().getDataString();
        if (dataString != null) {
            hashMap.put(C5527a.cnK, dataString);
        }
        return hashMap;
    }

    /* renamed from: PV */
    private boolean m10901PV() {
        String str = "cknaolfypl_otcici_";
        String str2 = "SvePhcisutr";
        return "local_notify_click".equalsIgnoreCase(getIntent().getStringExtra("PushService"));
    }

    /* renamed from: PW */
    private void m10902PW() {
        this.bEa.setVisibility(4);
        if (C3569a.m8774FM() && !C2561a.aON()) {
            if (!m10901PV()) {
                Class<IAppService> cls = IAppService.class;
                IAppService iAppService = (IAppService) C1919a.m5529sc().mo10356i(IAppService.class);
                boolean z = false;
                boolean z2 = true | false;
                if (!(iAppService != null ? iAppService.isYoungerMode() : false)) {
                    if (this.bEd != null && !TextUtils.isEmpty(this.bEd.mUrl)) {
                        z = true;
                    }
                    this.bEj = z;
                    StringBuilder sb = new StringBuilder();
                    String str = "FusShisalprsps=ta pltSeesh";
                    sb.append("setupSplash strSplashFile=");
                    sb.append(this.bEd);
                    LogUtilsV2.m14228e(sb.toString());
                    if (this.bEj) {
                        m10906Qa();
                        try {
                            C4386g.m11045b(this.bEd);
                            if (this.bEd != null) {
                                UserBehaviorABTestUtils.onEventShowSplash(getApplicationContext(), this.bEd.mTitle, this.bEd.lId, true);
                            }
                            C2570b.m7337i(this).mo12195aO(this.bEd.mUrl).aPe().mo12186g(this.bDZ);
                            C7572a.m22333a(this.bDZ, this.bEd, this.bEd.mEventParam);
                            this.bDZ.setOnClickListener(this.f3400po);
                        } catch (Throwable th) {
                            LogUtilsV2.m14228e(th.getMessage());
                        }
                    } else {
                        this.bEd = C4359a.m10939Qc().mo24413Qd();
                        if (!C4359a.m10939Qc().mo24418a(getApplicationContext(), m10905PZ())) {
                            this.bEi += 2000;
                            return;
                        }
                    }
                    m10903PX();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: PX */
    public void m10903PX() {
        int stayTime = this.bEd == null ? 0 : this.bEd.getStayTime();
        if (stayTime > 0) {
            this.bEi = stayTime;
        }
        if (this.bEa != null) {
            this.bEa.setVisibility(0);
            this.bEa.setOnClickListener(this.f3400po);
            this.bEa.setText(m10892H((long) stayTime));
        }
        m10926hJ(stayTime);
    }

    /* access modifiers changed from: private */
    /* renamed from: PY */
    public void m10904PY() {
        if (this.bEe != null) {
            this.bEe.cancel();
            this.bEe = null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: PZ */
    public ViewGroup m10905PZ() {
        int i = R.id.splash_group_root;
        if (C4359a.m10939Qc().mo24416Qg()) {
            i = R.id.china_ad_container;
        }
        return (ViewGroup) findViewById(i);
    }

    /* renamed from: Qa */
    private void m10906Qa() {
        ViewGroup PZ = m10905PZ();
        if (PZ != null) {
            PZ.removeAllViews();
        }
    }

    /* renamed from: a */
    private void m10911a(Activity activity, boolean z, boolean z2) {
        try {
            if (UserServiceProxy.isLogin()) {
                AppListener.gotoHomePageActivity(activity, m10900PU());
            } else {
                Class<WelcomeV6Activity> cls = WelcomeV6Activity.class;
                Intent intent = new Intent(activity, WelcomeV6Activity.class);
                intent.putExtra("isFirstTime", z);
                intent.putExtra("isUpgrade", z2);
                Bundle extras = activity.getIntent().getExtras();
                if (extras != null) {
                    intent.putExtras(extras);
                }
                activity.startActivity(intent);
                activity.overridePendingTransition(R.anim.activity_enter, R.anim.activity_exit);
            }
        } catch (Exception e) {
            String str = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("Can not find WelcomeActivity:");
            sb.append(e.toString());
            LogUtils.m14222e(str, sb.toString());
        }
    }

    /* renamed from: b */
    private boolean m10914b(Context context, String str, boolean z) {
        Object obj = null;
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (!(applicationInfo == null || applicationInfo.metaData == null)) {
                Object obj2 = applicationInfo.metaData.get(str);
                Object obj3 = obj2;
                obj = obj2;
            }
        } catch (Exception unused) {
        }
        if (obj != null) {
            z = ((Boolean) obj).booleanValue();
        }
        return z;
    }

    /* access modifiers changed from: private */
    /* renamed from: bQ */
    public void m10916bQ(boolean z) {
        long j = 500;
        if (!z) {
            long currentTimeMillis = System.currentTimeMillis() - this.bEf;
            long j2 = currentTimeMillis >= ((long) this.bEi) ? 1 : ((long) this.bEi) - currentTimeMillis;
            if (j2 >= 500) {
                j = j2;
            }
        } else {
            j = 0;
        }
        this.bEq = new C1808a() {
            /* renamed from: K */
            public void mo9886K(Object obj) {
                if (!SplashActivity.this.isFinishing()) {
                    SplashActivity.this.m10899PT();
                }
            }

            public void onComplete() {
            }

            public void onError(Throwable th) {
            }
        };
        boolean z2 = true | true;
        C1834l.m5257ah(Boolean.valueOf(true)).mo10164f(j, TimeUnit.MILLISECONDS).mo10157d(C1487a.aUa()).mo10152c(C1487a.aUa()).mo10149b((C1842q<? super T>) this.bEq);
    }

    /* renamed from: hJ */
    private void m10926hJ(int i) {
        m10904PY();
        C43555 r0 = new CountDownTimer((long) i, 300) {
            public void onFinish() {
                SplashActivity.this.bEa.setText(SplashActivity.this.m10892H(0));
                SplashActivity.this.bEd = null;
                if (!SplashActivity.this.bEn) {
                    SplashActivity.this.m10916bQ(true);
                }
            }

            public void onTick(long j) {
                StringBuilder sb = new StringBuilder();
                String str = "c=sTion";
                sb.append("onTick=");
                sb.append(j);
                LogUtilsV2.m14230i(sb.toString());
                SplashActivity.this.bEa.setText(SplashActivity.this.m10892H(j));
            }
        };
        this.bEe = r0;
        this.bEe.start();
    }

    private void initData() {
        String str = "ykimldar_tgseha_w_af_eolg";
        AppPreferencesSetting.getInstance().setAppSettingInt("key_show_rate_dialog_flag", 101);
        String str2 = "i_o_ohaskgr_legaohwadfsy_l";
        if (TextUtils.isEmpty(AppPreferencesSetting.getInstance().getAppSettingStr("key_show_share_dialog_flag", ""))) {
            String str3 = "sewsabgklaeoayol_d_rh_gfh_";
            StringBuilder sb = new StringBuilder(String.valueOf(System.currentTimeMillis()));
            String str4 = "/";
            sb.append("/");
            sb.append(201);
            AppPreferencesSetting.getInstance().setAppSettingStr("key_show_share_dialog_flag", sb.toString());
        }
    }

    private void requestPermission() {
        if (this.bDS == null) {
            this.bDS = new C4379f(this, new C8099d() {
                /* renamed from: PP */
                public void mo24403PP() {
                    SplashActivity.this.bDV = true;
                    C4368d.m10988Qu().mo24425Qw();
                    SplashActivity.this.m10896PM();
                }

                /* renamed from: PQ */
                public void mo24404PQ() {
                    if (!SplashActivity.this.isFinishing()) {
                        C4370e.m11005a(SplashActivity.this.bDS);
                    }
                }
            });
        }
        C4370e.m11005a(this.bDS);
    }

    public void initUI() {
        bDX = false;
        m10902PW();
        C3722f.m9042bQ(this);
        C4103b.m10181L(this);
        if (ApplicationBase.bir && !this.bEo && !this.bEj) {
            this.bEo = true;
            String str = "hsrapebdpeArSpa";
            LogUtilsV2.m14227d("prepareSplashAd");
            C4359a.m10939Qc().mo24417a(getApplicationContext(), this.bEr);
        }
        m10916bQ(false);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.bDS != null) {
            this.bDS.onActivityResult(i, i2, intent);
        }
    }

    public void onCreate(Bundle bundle) {
        C3571a.m8785ex("BeforeSplashCreate");
        super.onCreate(bundle);
        ActionFirebaseStarVlogs.actionSplashActivity(this);
        m10897PR();
        this.bEp = new C4370e();
        m10895PL();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        String str = "htaplS";
        C3574d.m8800ey(SocialConstDef.TBL_NAME_SPLASH);
        getWindow().setBackgroundDrawable(null);
        m10898PS();
        if (this.bDY != null) {
            this.bDY.setImageBitmap(null);
        }
        if (this.bEb != null) {
            this.bEb.setImageBitmap(null);
        }
        if (this.bEc != null) {
            this.bEc.setImageBitmap(null);
        }
        if (this.bDZ != null) {
            this.bDZ.setImageBitmap(null);
        }
        C7680l.aAe().releasePosition(44);
        C7680l.aAe().aAb();
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyUp(i, keyEvent);
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        overridePendingTransition(R.anim.activity_enter, R.anim.activity_exit);
        super.onPause();
        C4780a.m12334m(this);
        sendBroadcast(new Intent("com.introvd.template.finish.Loading"));
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        C4780a.m12333l(this);
        if (this.bEn) {
            this.bEn = false;
            m10916bQ(true);
        } else if (this.bDT) {
            if (!this.bDU) {
                m10895PL();
            } else if (!this.bDV && (this.bDS == null || !this.bDS.isShowing())) {
                requestPermission();
            }
        }
        this.bDT = false;
        if (!C3574d.bKy) {
            C3574d.bKy = true;
            String str = "otthsa_tp";
            long ew = C3571a.m8784ew("hot_start");
            if (C3571a.bKq > 0 && ew > 0) {
                long j = C3571a.bKq + ew;
                if (j < 50000) {
                    C3574d.m8795U(j);
                    C3571a.m8785ex("SplashLoaded");
                    C3574d.m8796a(j, C3571a.m8782RW());
                    StringBuilder sb = new StringBuilder();
                    String str2 = "dhcrtTSlito_P iu_ ea =racetLneTm";
                    sb.append("Per_Launch_Time coldStartTime = ");
                    sb.append(j);
                    Log.d("Per_Launch_Time", sb.toString());
                }
            }
        }
        String str3 = "hasSls";
        C3574d.m8799e(SocialConstDef.TBL_NAME_SPLASH, this.bfB);
        this.bfB = 0;
    }

    public void onStart() {
        super.onStart();
        C4037m.m10027a(this, false);
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        this.bDT = true;
    }
}
