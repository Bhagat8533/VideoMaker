package com.introvd.template;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.support.p021v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.afollestad.materialdialogs.C1885b;
import com.afollestad.materialdialogs.C1890f;
import com.afollestad.materialdialogs.C1890f.C1904j;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.introvd.template.app.ApplicationBase;
import com.introvd.template.app.C3855d;
import com.introvd.template.app.C3879g;
import com.introvd.template.app.C4027k;
import com.introvd.template.app.dispatch.MainDispatcher;
import com.introvd.template.app.homepage.BaseHomeView;
import com.introvd.template.app.homepage.HomeView;
import com.introvd.template.app.p193m.C4040a;
import com.introvd.template.app.receiver.UpgradeBroadcastReceiver;
import com.introvd.template.app.setting.C4322b;
import com.introvd.template.app.splash.C4361c;
import com.introvd.template.app.splash.SplashActivity;
import com.introvd.template.app.utils.C4395c;
import com.introvd.template.app.youngermode.C4553b;
import com.introvd.template.common.AppPreferencesSetting;
import com.introvd.template.common.ExAsyncTask;
import com.introvd.template.common.LogUtils;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.common.MagicCode;
import com.introvd.template.common.SDCardManager;
import com.introvd.template.common.ToastUtils;
import com.introvd.template.common.Toaster;
import com.introvd.template.common.UserBehaviorLog;
import com.introvd.template.common.behavior.UserBehaviorUtils;
import com.introvd.template.common.model.AppStateModel;
import com.introvd.template.common.prefs.UtilsPrefs;
import com.introvd.template.common.utils.DataRefreshValidateUtil;
import com.introvd.template.common.utils.PeriodDetectUtil;
import com.introvd.template.common.utils.PreferUtils;
import com.introvd.template.crash.C5523b;
import com.introvd.template.crash.C5524c;
import com.introvd.template.datacenter.SocialConstDef;
import com.introvd.template.datacenter.SocialServiceDef;
import com.introvd.template.module.iap.C8049f;
import com.introvd.template.module.p326ad.C7680l;
import com.introvd.template.module.p326ad.p327a.C7589a;
import com.introvd.template.p173a.p174a.C3574d;
import com.introvd.template.p203b.C4580b;
import com.introvd.template.p203b.C4582c;
import com.introvd.template.p203b.C4586g;
import com.introvd.template.p242d.C5527a;
import com.introvd.template.p242d.C5530d;
import com.introvd.template.p363o.C8092b;
import com.introvd.template.p374q.C8345d;
import com.introvd.template.p374q.C8356h;
import com.introvd.template.p414ui.dialog.C8978m;
import com.introvd.template.router.AppRouter;
import com.introvd.template.router.BizServiceManager;
import com.introvd.template.router.IMRouter;
import com.introvd.template.router.LoginRouter;
import com.introvd.template.router.editor.IEditorService;
import com.introvd.template.router.lbs.LbsManagerProxy;
import com.introvd.template.router.lifecycle.BizMainActivityLifeCycleManager;
import com.introvd.template.router.lvl.GoogleLicenseErrorListener;
import com.introvd.template.router.lvl.GoogleLvLRouter;
import com.introvd.template.router.todoCode.BizAppTodoActionManager;
import com.introvd.template.router.todoCode.TODOParamModel;
import com.introvd.template.router.todoCode.TodoConstants;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.videoeditor.intromaker.MainIntroActivity;
import com.videoeditor.intromaker.ThemeConfig;
import com.vivavideo.component.permission.C9295b;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import org.greenrobot.eventbus.C10021c;
import org.greenrobot.eventbus.C10031j;
import org.greenrobot.eventbus.ThreadMode;
import p037b.p050b.p076j.C1820a;

public class XiaoYingActivity extends EventActivity {
    public static volatile boolean bfV;
    private boolean bfE = true;
    private boolean bfT = false;
    private boolean bfU = false;
    private long bfW = 0;
    private C4673e bfX;
    private MainDispatcher bfY;
    private BaseHomeView bfZ;
    private LocalBroadcastManager bfz;
    private C3568b bga;
    private UpgradeBroadcastReceiver bgb = null;
    private String bgc = "";
    private String bgd = "";
    private boolean bge = false;
    private BroadcastReceiver bgf = null;
    private boolean bgg = false;
    private SocialServiceBroadcastReceiver bgh = null;
    private C3567a bgi = null;
    private BroadcastReceiver bgj = null;
    private Runnable bgk = new Runnable() {
        public void run() {
            C4680h.m12183bx(XiaoYingActivity.this.getApplicationContext());
            XiaoYingActivity.super.finish();
        }
    };

    /* renamed from: com.introvd.template.XiaoYingActivity$a */
    private static class C3567a extends Handler {
        private WeakReference<XiaoYingActivity> mContextRef;

        public C3567a(XiaoYingActivity xiaoYingActivity) {
            this.mContextRef = new WeakReference<>(xiaoYingActivity);
        }

        public void handleMessage(Message message) {
            super.handleMessage(message);
            XiaoYingActivity xiaoYingActivity = (XiaoYingActivity) this.mContextRef.get();
            StringBuilder sb = new StringBuilder();
            sb.append("handleMessage : ");
            sb.append(message.what);
            LogUtils.m14223i("XiaoYingActivity", sb.toString());
            if (message.what == 10002) {
                C4027k.m9994a(xiaoYingActivity, null, C4027k.m9995dj((String) message.obj));
            }
        }
    }

    /* renamed from: com.introvd.template.XiaoYingActivity$b */
    private class C3568b extends ContentObserver {
        public C3568b(Handler handler) {
            super(handler);
        }

        public void onChange(boolean z) {
            C8356h.aKg().mo33613gR(XiaoYingActivity.this.getApplicationContext());
        }
    }

    /* renamed from: Gf */
    private void m8753Gf() {
        LogUtils.m14223i("XiaoYingActivity", "runOnce<---");
        this.bgc = C4582c.m11667dD(getApplicationContext());
        this.bgd = C3569a.m8776FO();
        final boolean z = !this.bgc.equals(this.bgd) && !TextUtils.isEmpty(this.bgd);
        final boolean equals = TextUtils.equals(this.bgd, "");
        this.bgf = new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {
                if ("com.introvd.template.event_action".equals(intent.getAction())) {
                    C4681i.m12184Gp().mo25016Gr().recordEvtOnAppflyer(context.getApplicationContext(), intent.getStringExtra("event_name"));
                    return;
                }
                try {
                    C4681i.m12184Gp().mo25016Gr().initPushClient(context);
                    C4681i.m12184Gp().mo25016Gr().setPushTag(context, true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(SocialServiceDef.SOCIAL_USER_METHOD_LOGIN);
        intentFilter.addAction(SocialServiceDef.SOCIAL_USER_METHOD_DEVLOGIN);
        intentFilter.addAction("com.introvd.template.event_action");
        this.bfz.registerReceiver(this.bgf, intentFilter);
        new ExAsyncTask<Context, Void, Void>() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public Void doInBackground(Context... contextArr) {
                Context context = contextArr[0];
                if (equals) {
                    AppPreferencesSetting.getInstance().setAppSettingBoolean("pref_help_project", true);
                    AppPreferencesSetting.getInstance().setAppSettingBoolean("pref_help_camera", true);
                    AppPreferencesSetting.getInstance().setAppSettingBoolean("pref_help_edit", true);
                    AppPreferencesSetting.getInstance().setAppSettingBoolean("pref_help_edit_trim_pic", true);
                    AppPreferencesSetting.getInstance().setAppSettingBoolean("pref_help_edit_trim_video", true);
                    AppPreferencesSetting.getInstance().setAppSettingBoolean("pref_help_edit_subtitle", true);
                    AppPreferencesSetting.getInstance().setAppSettingBoolean("pref_guide_mode_onoff", true);
                }
                if (z) {
                    AppPreferencesSetting.getInstance().setAppSettingBoolean("pref_help_edit", true);
                    AppPreferencesSetting.getInstance().setAppSettingBoolean("pref_help_edit_subtitle", true);
                }
                Context applicationContext = context.getApplicationContext();
                UserBehaviorLog.setDebugMode(applicationContext, false);
                UserBehaviorLog.updateOnlineConfig(applicationContext);
                UserBehaviorLog.setReportPolicy(applicationContext, 2);
                C4681i.m12184Gp().mo25016Gr().initPushClient(applicationContext);
                return null;
            }
        }.execute((Params[]) new Context[]{this});
        LogUtils.m14223i("XiaoYingActivity", "runOnce--->");
    }

    /* renamed from: Gg */
    private void m8754Gg() {
        if (this.bgf != null) {
            this.bfz.unregisterReceiver(this.bgf);
            this.bgf = null;
        }
    }

    /* renamed from: Gh */
    private void m8755Gh() {
        if (C4580b.m11648dC(this)) {
            try {
                C8978m.m26349hs(this).mo10293dl(R.string.xiaoying_str_com_info_title).mo10296do(R.string.xiaoying_str_close_dont_keep_activities).mo10303dv(R.string.xiaoying_str_close_dont_keep_activities_btn).mo10291b(new C1904j() {
                    public void onClick(C1890f fVar, C1885b bVar) {
                        UserBehaviorLog.onKVEvent(XiaoYingActivity.this.getApplicationContext(), "Dev_Activity_Dialog_Done", new HashMap());
                        Intent intent = new Intent("android.settings.APPLICATION_DEVELOPMENT_SETTINGS");
                        intent.setFlags(1073741824);
                        try {
                            XiaoYingActivity.this.startActivity(intent);
                        } catch (ActivityNotFoundException e) {
                            C5523b.logException(e);
                        } catch (SecurityException e2) {
                            C5523b.logException(e2);
                        }
                    }
                }).mo10313qu().show();
                UserBehaviorLog.onKVEvent(getApplicationContext(), "Dev_Activity_Dialog_Show", new HashMap());
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: Gi */
    private void m8756Gi() {
        if (C4395c.m11086Y(this, getPackageName()) && VERSION.SDK_INT >= 21) {
            try {
                C8978m.m26349hs(this).mo10293dl(R.string.xiaoying_str_com_info_title).mo10296do(R.string.xiaoying_com_str_install_sdcard_hint).mo10303dv(R.string.xiaoying_str_com_cancel).mo10299dr(R.string.xiaoying_str_close_dont_keep_activities_btn).mo10291b(new C1904j() {
                    public void onClick(C1890f fVar, C1885b bVar) {
                        C4680h.m12181F(XiaoYingActivity.this.getApplicationContext(), "cancel");
                    }
                }).mo10281a((C1904j) new C1904j() {
                    public void onClick(C1890f fVar, C1885b bVar) {
                        C4680h.m12181F(XiaoYingActivity.this.getApplicationContext(), "change");
                        try {
                            StringBuilder sb = new StringBuilder();
                            sb.append("package:");
                            sb.append(XiaoYingActivity.this.getPackageName());
                            XiaoYingActivity.this.startActivity(new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse(sb.toString())));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }).mo10275a((OnCancelListener) new OnCancelListener() {
                    public void onCancel(DialogInterface dialogInterface) {
                        C4680h.m12181F(XiaoYingActivity.this.getApplicationContext(), "cancel");
                    }
                }).mo10313qu().show();
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: Gj */
    private void m8757Gj() {
        if (this.bfZ != null) {
            this.bfZ.onResume();
        }
    }

    /* renamed from: Gk */
    private void m8758Gk() {
        if (this.bgj != null) {
            unregisterReceiver(this.bgj);
            this.bgj = null;
        }
        this.bgj = new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {
                if ("android.intent.action.LOCALE_CHANGED".equals(intent.getAction())) {
                    LogUtilsV2.m14230i("Language---->SystemLocaleLanguageChanged happen!!!!");
                    Process.killProcess(Process.myPid());
                    System.exit(0);
                }
            }
        };
        registerReceiver(this.bgj, new IntentFilter("android.intent.action.LOCALE_CHANGED"));
    }

    /* renamed from: Gl */
    private void m8759Gl() {
        if (!this.bgg) {
            this.bgg = true;
            this.bfZ = mo22840u(this);
            if (this.bfZ != null) {
                C5530d dVar = (C5530d) MagicCode.getMagicParam((long) hashCode(), "AppRunningMode", null);
                if (dVar != null) {
                    this.bfZ.init(dVar.cnU);
                    setContentView(this.bfZ);
                } else {
                    return;
                }
            }
            m8753Gf();
        }
    }

    /* renamed from: Gn */
    private void m8760Gn() {
        ContentResolver contentResolver = getContentResolver();
        if (this.bga != null) {
            contentResolver.unregisterContentObserver(this.bga);
        }
    }

    /* renamed from: bv */
    private static void m8762bv(Context context) {
        PendingIntent activity = PendingIntent.getActivity(context, 0, context.getPackageManager().getLaunchIntentForPackage(context.getPackageName()), 1073741824);
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        if (alarmManager == null) {
            return;
        }
        if (VERSION.SDK_INT >= 23) {
            alarmManager.setExactAndAllowWhileIdle(1, System.currentTimeMillis() + 50, activity);
        } else if (VERSION.SDK_INT >= 19) {
            alarmManager.setExact(1, System.currentTimeMillis() + 50, activity);
        } else {
            alarmManager.set(1, System.currentTimeMillis() + 50, activity);
        }
    }

    /* renamed from: bw */
    private void m8763bw(final Context context) {
        C1820a.aVi().mo10058o(new Runnable() {
            public void run() {
                if (C3569a.m8772FK()) {
                    UtilsPrefs.with(context, AppRouter.VIVA_APP_PREF_FILENAME, true).write("VIVA_CHANNEL_CODE", C4580b.m11652dy(context));
                } else if (!PeriodDetectUtil.isInPeriod("PREF_KEY_VIVA_CHANNEL_CODE", 28800000)) {
                    String read = UtilsPrefs.with(context, AppRouter.VIVA_APP_PREF_FILENAME, true).read("VIVA_CHANNEL_CODE");
                    String dy = C4580b.m11652dy(context);
                    if ("01".equals(read) && !"01".equals(dy)) {
                        HashMap hashMap = new HashMap();
                        StringBuilder sb = new StringBuilder();
                        sb.append(read);
                        sb.append("_");
                        sb.append(dy);
                        hashMap.put("from_to", sb.toString());
                        UserBehaviorLog.onKVEvent(XiaoYingActivity.this.getApplicationContext(), "Dev_Event_Channel_Replace", hashMap);
                    } else if (!TextUtils.equals(read, dy)) {
                        HashMap hashMap2 = new HashMap();
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(read);
                        sb2.append("_");
                        sb2.append(dy);
                        hashMap2.put("from_to", sb2.toString());
                        UserBehaviorLog.onKVEvent(XiaoYingActivity.this.getApplicationContext(), "Dev_Event_Domestic_Channel_Replace", hashMap2);
                    }
                }
            }
        });
    }

    private void registerObserver() {
        getContentResolver().registerContentObserver(SocialConstDef.getTableUri(SocialConstDef.TBL_NAME_TASK), true, this.bga);
    }

    /* access modifiers changed from: protected */
    /* renamed from: FV */
    public String[] mo22813FV() {
        return new String[]{"com.introvd.template.restart"};
    }

    /* renamed from: Ge */
    public BaseHomeView mo22832Ge() {
        return this.bfZ;
    }

    /* renamed from: Gm */
    public void mo22833Gm() {
        if (this.bfZ != null) {
            this.bfZ.onResume();
        }
    }

    /* renamed from: Go */
    public void mo22834Go() {
        super.finish();
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 84) {
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    public void finish() {
        if (!C8049f.aBf().mo33098d(this, this.bgk) && !C7680l.aAf().mo32489a(this, this.bgk)) {
            if (System.currentTimeMillis() - this.bfW <= AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS) {
                C4680h.m12183bx(getApplicationContext());
            }
            super.finish();
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.bfZ != null) {
            this.bfZ.onActivityResult(i, i2, intent);
        }
        if (i == 1100 && i2 == -1) {
            String stringExtra = intent.getStringExtra("event");
            if (!TextUtils.isEmpty(stringExtra) && this.bgi != null) {
                Message obtainMessage = this.bgi.obtainMessage(TodoConstants.TODO_TYPE_APK_TEST);
                obtainMessage.obj = stringExtra;
                this.bgi.sendMessage(obtainMessage);
            }
        }
    }

    public void onAttachedToWindow() {
        LogUtils.m14223i("XiaoYingActivity", "onAttachedToWindow ");
        super.onAttachedToWindow();
    }

    public void onCreate(Bundle bundle) {
        LogUtils.m14223i("XiaoYingActivity", "onCreate<---");
        super.onCreate(bundle);
        BizMainActivityLifeCycleManager.init(this);
        C5524c.aaS();
        ThemeConfig.startActivityMainIntro(this);
        if (!C9295b.m26985b(this, C8092b.dXu) || !SDCardManager.hasSDCard()) {
            new Toaster(this, this, getString(R.string.xiaoying_str_com_msg_sdcard_mounted), 0).run();
            finish();
            return;
        }
        UserBehaviorLog.skipPage(this);
        C4040a.m10035cU(this);
        if (!ApplicationBase.m8954Ho()) {
            C4681i.m12184Gp().mo25016Gr().onRouterClientConfigure(getApplicationContext(), false, "", "", null);
        }
        this.bfX = new C4673e();
        this.bfX.mo25008c(this, hashCode());
        ApplicationBase.bin = true;
        C3879g.m9553bD(getApplicationContext());
        if (ApplicationBase.biq) {
            UserBehaviorUtils.recordIpConfig(this, ApplicationBase.bip, AppStateModel.getInstance().getCountryCode());
        }
        m8763bw(getApplicationContext());
        C5530d dVar = (C5530d) MagicCode.getMagicParam((long) hashCode(), "AppRunningMode", null);
        if (dVar == null) {
            finish();
            return;
        }
        if (this.bgi == null) {
            this.bgi = new C3567a(this);
        }
        this.bga = new C3568b(this.bgi);
        this.bfz = LocalBroadcastManager.getInstance(this);
        if (this.bgb == null) {
            this.bgb = UpgradeBroadcastReceiver.m10244cA(getApplicationContext());
            this.bgb.mo23797M(this);
            this.bgb.register();
            C4322b.m10843hz(0);
        }
        mo22812FU();
        m8758Gk();
        C10021c.aZH().mo38494ax(this);
        if (!C5530d.m14977kn(dVar.cnU)) {
            AppPreferencesSetting.getInstance().setAppSettingBoolean("pref_guide_mode_onoff", false);
        }
        this.bge = true;
        if (C4681i.m12184Gp().mo25016Gr() != null) {
            IMRouter.initIMClientInside(null, 0, true);
        }
        LogUtils.m14223i("XiaoYingActivity", "onCreate--->");
        if (getIntent().getBooleanExtra(C5527a.cnJ, false)) {
            LoginRouter.startSettingBindAccountActivity(this);
        }
        if (this.bgh == null) {
            this.bgh = new SocialServiceBroadcastReceiver(this);
            this.bgh.register();
        }
        m8755Gh();
        if (!isFinishing()) {
            m8756Gi();
            C4681i.m12184Gp().mo25017Gs().mo22828Ga();
            C4680h.m12182G(getApplicationContext(), AppStateModel.getInstance().getCountryCode());
            UserBehaviorUtils.onEventDevDeviceX86(getApplicationContext());
            IEditorService iEditorService = (IEditorService) BizServiceManager.getService(IEditorService.class);
            if (iEditorService != null && (iEditorService.isPureHD2KSupport() || iEditorService.isPureHD4KSupport())) {
                UserBehaviorUtils.onEventShareExport2k4kSupport(getApplicationContext(), iEditorService.isPureHD2KSupport() ? "2k" : "4k");
            }
            C8049f.aBf().aBi();
            this.bfY = new MainDispatcher(this);
            getLifecycle().mo152a(this.bfY);
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        C3574d.m8800ey("Home");
        C3574d.m8791RZ();
        IMRouter.uninitIMClient();
        C10021c.aZH().mo38496az(this);
        if (this.bgb != null) {
            this.bgb.unregister();
            this.bgb = null;
        }
        if (this.bgj != null) {
            unregisterReceiver(this.bgj);
            this.bgj = null;
        }
        if (this.bfZ != null) {
            this.bfZ.onDestroy();
        }
        if (!TextUtils.isEmpty(Build.MODEL) && !Build.MODEL.contains("TCL")) {
            LbsManagerProxy.recordLocation(false, false);
        }
        if (!this.bge) {
            super.onDestroy();
            return;
        }
        LogUtils.m14223i("XiaoYingActivity", "onDestroy");
        UserBehaviorLog.onEvent(this, "App_Exit");
        UserBehaviorLog.onEventEnd(this, "App_Enter");
        UserBehaviorLog.clearStack(this);
        if (this.bgh != null) {
            this.bgh.unregister();
            this.bgh = null;
        }
        C5530d dVar = (C5530d) MagicCode.getMagicParam((long) hashCode(), "AppRunningMode", null);
        if (dVar != null && C5530d.m14977kn(dVar.cnU)) {
            m8754Gg();
        }
        if (this.bfX != null) {
            this.bfX.mo25010t(this);
            this.bfX = null;
        }
        GoogleLvLRouter.doRelease();
        super.onDestroy();
    }

    @C10031j(aZK = ThreadMode.MAIN)
    public void onEventMainThread(C3855d dVar) {
        TODOParamModel todoParamModel = dVar.getTodoParamModel();
        if (todoParamModel != null) {
            BizAppTodoActionManager.getInstance().executeTodo(this, todoParamModel);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return super.onKeyDown(i, keyEvent);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4) {
            if (i != 82) {
                switch (i) {
                }
            } else if (this.bfZ != null && this.bfZ.onKeyUp(i, keyEvent)) {
                return true;
            }
        } else if (this.bfZ != null && this.bfZ.onKeyUp(i, keyEvent)) {
            return true;
        } else {
            if (C8049f.aBf().mo33096aH(this) || C7680l.aAf().mo32491ax(this)) {
                try {
                    return super.onKeyUp(i, keyEvent);
                } catch (Exception e) {
                    e.printStackTrace();
                    return true;
                }
            } else if (!this.bfT) {
                this.bfT = true;
                this.bfW = System.currentTimeMillis();
                ToastUtils.show((Context) this, R.string.xiaoying_str_com_press_back_key_again_to_exit, 0);
                return true;
            } else if (System.currentTimeMillis() - this.bfW > AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS) {
                this.bfW = System.currentTimeMillis();
                C4553b.m11491RJ().mo24785RK();
                ToastUtils.show((Context) this, R.string.xiaoying_str_com_press_back_key_again_to_exit, 0);
                return true;
            }
        }
        return super.onKeyUp(i, keyEvent);
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        if (this.bfX != null && "com.introvd.template.Gallery_MV_Laucher".equals(intent.getAction())) {
            setIntent(intent);
            onResume();
        }
        if (this.bfY != null) {
            this.bfY.mo23391KV();
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        if (this.bfZ != null) {
            this.bfZ.onPause();
        }
        if (!this.bge) {
            super.onPause();
            return;
        }
        LogUtils.m14223i("XiaoYingActivity", "onPause");
        this.bgd = this.bgc;
        m8760Gn();
        UserBehaviorLog.pageDisappear(this);
        UserBehaviorLog.onPause(this);
        if (!isFinishing()) {
            this.bfU = true;
        }
        super.onPause();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        ThemeConfig.startActivityMainIntro(this);
        GoogleLvLRouter.doCheck(this, new GoogleLicenseErrorListener() {
            public void onError(int i) {
            }
        }, new GoogleLicenseErrorListener() {
            public void onError(int i) {
            }
        });
        if (this.bfX != null) {
            this.bfX.onResume(this);
        }
        C3574d.m8790RY();
        C3569a.m8778bl(this);
        if (!C8345d.m24065co(this, "AppAutoShutDown") && this.bge) {
            C5530d dVar = (C5530d) MagicCode.getMagicParam((long) hashCode(), "AppRunningMode", null);
            if (dVar != null) {
                if (C5530d.m14977kn(dVar.cnU)) {
                    m8759Gl();
                    m8757Gj();
                }
                registerObserver();
                UserBehaviorLog.onResume(this);
                if (this.bfE) {
                    this.bfE = false;
                } else {
                    UtilsPrefs with = UtilsPrefs.with(this, AppRouter.VIVA_APP_PREF_FILENAME, true);
                    if (!PreferUtils.isPhotoMvShortCutDialogShow() && with.readBoolean("key_show_main_tool_mv_tip", false)) {
                        PreferUtils.setPhotoMvShortcutDialogShow();
                        C4586g.m11699W(this);
                    }
                }
                if (this.bgb != null) {
                    this.bgb.mo23802z(0);
                    this.bgb.mo23797M(this);
                }
                if (this.bfU && !bfV) {
                    this.bfU = false;
                    mo22841v(this);
                }
                bfV = false;
                C3574d.m8799e("Home", this.bfB);
                this.bfB = 0;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    /* access modifiers changed from: protected */
    /* renamed from: q */
    public void mo22820q(Intent intent) {
        StringBuilder sb = new StringBuilder();
        sb.append("Language---->LocaleLanguageChanged happen!!!! action=");
        sb.append(intent.getAction());
        LogUtilsV2.m14230i(sb.toString());
        if ("com.introvd.template.restart".equals(intent.getAction())) {
            m8762bv(getApplicationContext());
            mo22834Go();
        }
    }

    public void startMainIntro() {
        startActivity(new Intent(this, MainIntroActivity.class));
    }

    /* renamed from: u */
    public BaseHomeView mo22840u(Activity activity) {
        return new HomeView(activity);
    }

    /* renamed from: v */
    public boolean mo22841v(Activity activity) {
        if (DataRefreshValidateUtil.isRefreshTimeout("splash_show_mode", 300)) {
            boolean z = C7589a.m22362gm(activity) != null;
            if (C4361c.m10957Qn() || z) {
                Intent intent = new Intent(activity.getApplicationContext(), SplashActivity.class);
                intent.putExtra("splash_show_mode", true);
                activity.startActivityForResult(intent, IronSourceConstants.RV_API_SHOW_CALLED);
            }
        }
        return true;
    }
}
