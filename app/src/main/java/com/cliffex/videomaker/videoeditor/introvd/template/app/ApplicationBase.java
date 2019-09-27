package com.introvd.template.app;

import android.app.Application;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextUtils;
import androidx.work.C1210b.C1211a;
import androidx.work.C1322k;
import com.aiii.android.arouter.p091c.C1919a;
import com.ciii.android.job.C2629h;
import com.eiii.FacebookSdk;
import com.eiii.LoggingBehavior;
import com.fiii.aiii.FirebaseApp;
import com.introvd.template.AppMiscListener;
import com.introvd.template.C3569a;
import com.introvd.template.C4676f;
import com.introvd.template.C4681i;
import com.introvd.template.R;
import com.introvd.template.VivaBaseApplication;
import com.introvd.template.apicore.C3624b;
import com.introvd.template.app.alarm.C3724a;
import com.introvd.template.app.manager.C4041a;
import com.introvd.template.app.manager.C4065e;
import com.introvd.template.app.p177b.C3742b;
import com.introvd.template.app.p183g.C3880a;
import com.introvd.template.app.p189i.C4005b;
import com.introvd.template.app.receiver.NetworkRuntimeBroadcastReceiver;
import com.introvd.template.app.utils.C4391b;
import com.introvd.template.channel.C5206b;
import com.introvd.template.common.ABTestListener;
import com.introvd.template.common.AppPreferencesSetting;
import com.introvd.template.common.LogUtils;
import com.introvd.template.common.UserBehaviorLog;
import com.introvd.template.common.model.AppStateModel;
import com.introvd.template.consent.gdpr.C5521b;
import com.introvd.template.module.C7690d;
import com.introvd.template.module.p326ad.C7664i;
import com.introvd.template.p173a.p174a.C3571a;
import com.introvd.template.p173a.p174a.C3574d;
import com.introvd.template.p203b.C4580b;
import com.introvd.template.p203b.C4598j;
import com.introvd.template.perf.C8159a;
import com.introvd.template.router.BizServiceManager;
import com.introvd.template.router.IMRouter;
import com.introvd.template.router.app.device.DeviceUserProxy;
import com.introvd.template.router.editor.IEditorService;
import com.introvd.template.router.iaphuawei.HuaweiIAPServiceProxy;
import com.introvd.template.router.lifecycle.BizAppLifeCycleManager;
import com.introvd.template.router.performance.PerformanceServiceProxy;
import com.introvd.template.router.setting.ISettingRouter;
import com.introvd.template.router.user.UserServiceProxy;
import com.introvd.template.xyui.p421b.C9162a;
import com.vivalab.p427a.C9268a;
import com.xiaoying.p448a.C9537b;
import java.util.HashMap;

public class ApplicationBase extends VivaBaseApplication {
    private static final Uri URI = Uri.parse("content://com.introvd.template.vivasetting/config");
    public static volatile boolean bin;
    public static volatile boolean bio;
    public static volatile boolean bip;
    public static volatile boolean biq;
    public static volatile boolean bir;
    public static volatile boolean bis;
    public static volatile boolean bit;
    public static String biu;

    /* renamed from: Hl */
    private void m8951Hl() {
        C3874f.m9537bA(getApplicationContext());
    }

    /* renamed from: Hm */
    private void m8952Hm() {
        m8953Hn();
        registerActivityLifecycleCallbacks(new C3751c());
        if (AppStateModel.getInstance().isGDPRAgree()) {
            C4041a.m10049m(this);
            C4041a.m10047cp(this);
        }
        C3874f.m9538bB(getApplicationContext());
        C3874f.m9539bC(getApplicationContext());
    }

    /* renamed from: Hn */
    private void m8953Hn() {
        FacebookSdk.setIsDebugEnabled(false);
        FacebookSdk.addLoggingBehavior(LoggingBehavior.APP_EVENTS);
    }

    /* renamed from: Ho */
    public static boolean m8954Ho() {
        return bio;
    }

    /* renamed from: Hp */
    private void m8955Hp() {
        String a = m8956a(getContentResolver(), "viva_ip");
        if (!TextUtils.isEmpty(a)) {
            AppPreferencesSetting.getInstance().setAppSettingStr("app_ip_key", a);
            StringBuilder sb = new StringBuilder();
            sb.append(">>>>>>>>>>>>>>>> X-Forwarded-For = ");
            sb.append(a);
            LogUtils.m14222e("viva", sb.toString());
        }
        this.bfP = m8956a(getContentResolver(), "viva_servermode");
    }

    /* renamed from: a */
    public static String m8956a(ContentResolver contentResolver, String str) {
        String[] strArr;
        String str2;
        String str3 = "cfgname =?";
        String[] strArr2 = {str};
        if (TextUtils.isEmpty(str)) {
            str2 = null;
            strArr = null;
        } else {
            str2 = str3;
            strArr = strArr2;
        }
        Cursor query = contentResolver.query(URI, null, str2, strArr, null);
        if (query == null) {
            return null;
        }
        if (query.moveToFirst()) {
            String string = query.getString(query.getColumnIndex("cfgcontent"));
            query.close();
            return string;
        }
        query.close();
        return null;
    }

    /* renamed from: a */
    private static void m8957a(Application application, Context context) {
        String userId = UserServiceProxy.getUserId();
        HashMap hashMap = new HashMap();
        hashMap.put("GAScreenID", Integer.valueOf(R.xml.ga_screen_tracker));
        hashMap.put("Flurry_API_key", "SS7ZQ5JFFGVKKNTK8X67");
        hashMap.put("ali_appkey", "24794025");
        hashMap.put("ali_secret", "c3ac4bad9119e397994198c05ca60ba2");
        hashMap.put("appkey_channel", C5206b.m14212dV(context));
        if (!TextUtils.isEmpty(userId)) {
            hashMap.put("Flurry_User_ID", userId);
        }
        UserBehaviorLog.setInitParam(application, context, hashMap);
        try {
            long duidLong = DeviceUserProxy.getDuidLong();
            if (duidLong > 0) {
                UserBehaviorLog.updateAccount(userId, duidLong);
                C4041a.m10039MV();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        UserBehaviorLog.setAbTestListener(new ABTestListener() {
            public String getABTestKey() {
                return "abTagList";
            }

            public String getABTestValue() {
                String appSettingStr = AppPreferencesSetting.getInstance().getAppSettingStr("pref_ab_test_value", null);
                return !TextUtils.isEmpty(appSettingStr) ? appSettingStr : C3742b.m9111II().mo23159Jf();
            }
        });
    }

    /* renamed from: bz */
    private void m8958bz(Context context) {
        C3724a bR = C3724a.m9052bR(context);
        bR.mo23085gp(4099);
        if (AppPreferencesSetting.getInstance().getAppSettingBoolean("pref_receive_notification", true)) {
            bR.mo23081a(bR.mo23086gq(4099), 4099);
        }
        bR.mo23084dj(4100);
    }

    /* renamed from: l */
    private void m8959l(Application application) {
        C9537b.setParameter("ProductId", AppStateModel.getInstance().getAppProductId());
        C4067n.init();
        C3880a.m9555a(application);
        C3624b.m8865GC().mo22949cD(C5206b.m14212dV(application));
        C3624b.m8865GC().mo22948cC(AppStateModel.getInstance().getAppProductId());
        C4681i.m12184Gp().mo25019a((AppMiscListener) new AppListener(application));
        IMRouter.initIMClientInside(application, 0, false);
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        if (C4676f.m12172FY()) {
            C3571a.m8783ev("cold_start");
        }
        if (!C4387t.m11046bG(context) && VERSION.SDK_INT < 21) {
            new C4387t().attachBaseContext(context);
        }
        if (C4676f.m12172FY()) {
            C3571a.m8785ex("XYMultiDex");
        }
    }

    /* access modifiers changed from: protected */
    public void checkFirebasePerfDisable(boolean z) {
    }

    /* access modifiers changed from: protected */
    /* renamed from: di */
    public void mo23017di(String str) {
    }

    public void onCreate() {
        super.onCreate();
        if (!C4387t.m11046bG(this)) {
            C3571a.m8785ex("BeforeAppCreateInit");
            C3569a.m8777bk(getApplicationContext());
            biu = C5206b.m14213dW(this);
            mo23017di(biu);
            FirebaseApp.m8116aK(this);
            C4083o.m10142Hy().mo23761Hz();
            boolean FY = C4676f.m12172FY();
            C1919a.m5528a(this);
            checkFirebasePerfDisable(FY);
            PerformanceServiceProxy.initLeakCanary(this, FY);
            if (FY) {
                C3571a.m8785ex("BeforeAppMain");
                C3879g.m9551Hq();
                C8159a.m23593p(this);
                C3571a.m8785ex("initVivaMonitor");
                C9268a.aPk();
                UserBehaviorLog.setLoggerDebug(C9268a.m26954Fp());
                C9268a.m26956r(this);
                if (AppPreferencesSetting.getInstance().getAppSettingBoolean("key_logger_event_to_web", false)) {
                    C9268a.m26955q(this);
                }
                C3571a.m8785ex("Logger");
                IEditorService iEditorService = (IEditorService) BizServiceManager.getService(IEditorService.class);
                if (iEditorService != null) {
                    iEditorService.initVeSdkDB();
                    iEditorService.initProjectUpdateHandle();
                }
                C3571a.m8785ex("initVeSdkDB");
                C7690d.m22600a(new C4005b());
                C7664i.m22487a(new C4005b());
                C3571a.m8785ex("AD_IAP");
                C1322k.m4388a(this, new C1211a().mo9169od());
                C3571a.m8785ex("WorkManager");
                BizAppLifeCycleManager bizAppLifeCycleManager = new BizAppLifeCycleManager(this);
                bizAppLifeCycleManager.performOnCreate();
                C3571a.m8785ex("LifeCycle");
                C2629h.m7598aB(this).mo13006a(new C4084p());
                C3571a.m8785ex("JobManager");
                m8955Hp();
                C3571a.m8785ex("initVivaConfig");
                C9162a.init(getApplicationContext(), C4580b.m11666qi());
                C3571a.m8785ex("UIHelper");
                mo22830Gc();
                C5521b.m14956a(this);
                C3571a.m8785ex("UserConsentMgr");
                C4132s.init(this);
                m8957a((Application) this, getApplicationContext());
                C3571a.m8785ex("UB");
                new C4391b().mo24456cV(getApplicationContext());
                m8959l(this);
                C3571a.m8785ex("initXiaoYingModules");
                m8952Hm();
                C3571a.m8785ex("init3rdSDK");
                m8958bz(getApplicationContext());
                C3571a.m8785ex("initAlarm");
                m8951Hl();
                C3571a.m8785ex("initAdsSDK");
                C4065e.m10112Ng();
                C3571a.m8785ex("RouteConfig");
                NetworkRuntimeBroadcastReceiver.m10224cw(this);
                HuaweiIAPServiceProxy.initHuaWeiSdk(this);
                bizAppLifeCycleManager.performOnCreateFinished();
                C3571a.m8785ex("HuaWei");
                ISettingRouter iSettingRouter = (ISettingRouter) C1919a.m5529sc().mo10356i(ISettingRouter.class);
                if (iSettingRouter != null) {
                    C4598j.m11731a(this, C4598j.m11732eK(iSettingRouter.getAppSettedLocaleModel(getApplicationContext()).value));
                }
                C3571a.m8785ex("setLocale");
            }
        }
    }

    public void onLowMemory() {
        super.onLowMemory();
        C3574d.m8792Sa();
    }
}
