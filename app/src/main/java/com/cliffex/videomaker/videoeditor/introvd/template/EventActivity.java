package com.introvd.template;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Environment;
import android.support.p021v4.app.FragmentActivity;
import android.support.p021v4.content.LocalBroadcastManager;
import android.view.KeyEvent;
import com.google.android.exoplayer2.util.MimeTypes;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.common.ToastUtils;
import com.introvd.template.common.Toaster;
import com.introvd.template.common.Utils;
import com.introvd.template.common.api.XYUserBehaviorService;
import com.introvd.template.common.impl.XYUserBehaviorServiceImpl;
import com.introvd.template.common.utils.NotchUtil;
import com.introvd.template.crash.C5523b;
import com.introvd.template.p203b.C4580b;
import com.introvd.template.p203b.C4597i;
import com.introvd.template.p203b.C4598j;
import com.introvd.template.router.BizServiceManager;
import com.introvd.template.router.setting.ISettingRouter;
import com.xiaoying.p448a.C9537b;
import java.util.Locale;
import xiaoying.quvideo.com.vivabase.C10122R;

public abstract class EventActivity extends FragmentActivity {
    /* access modifiers changed from: protected */
    public static final String TAG = "EventActivity";
    protected static long bfu;
    protected static long bfv;
    private BroadcastReceiver akb = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if ("com.introvd.template.nosdcard".equals(action)) {
                String string = context.getString(C10122R.string.xiaoying_str_com_msg_sdcard_mounted);
                StringBuilder sb = new StringBuilder();
                sb.append(">>>>>>>>>>>>>>>> eventactivity onReceive toastCt=");
                sb.append(string);
                LogUtilsV2.m14230i(sb.toString());
                new Toaster(null, context, string, 1).run();
            } else if ("com.introvd.template.diskspace".equals(action)) {
                ToastUtils.show(context, context.getResources().getString(C10122R.string.xiaoying_str_com_msg_low_diskspace_warning), 2000);
            } else if ("android.intent.action.BATTERY_CHANGED".equals(action)) {
                int intExtra = intent.getIntExtra("level", 0);
                int intExtra2 = intent.getIntExtra("scale", 100);
                if (intExtra2 == 0) {
                    intExtra2 = 100;
                }
                int intExtra3 = intent.getIntExtra("status", 0);
                long j = (long) ((intExtra * 100) / intExtra2);
                if (j >= 50) {
                    EventActivity.bfu &= -2;
                }
                if ((intExtra3 == 4 || intExtra3 == 3) && j < 15 && (EventActivity.bfu & 1) == 0) {
                    EventActivity.bfu |= 1;
                    ToastUtils.show(context, context.getResources().getString(C10122R.string.xiaoying_str_com_msg_low_battery_warning), 2000);
                }
            } else if ("android.intent.action.SCREEN_OFF".equals(action)) {
                EventActivity.this.mo22818gb(18);
            } else if ("android.intent.action.SCREEN_ON".equals(action)) {
                EventActivity.this.mo22818gb(19);
            } else if ("android.intent.action.MEDIA_SCANNER_FINISHED".equals(action)) {
                EventActivity.this.mo22818gb(22);
            }
        }
    };
    private XYUserBehaviorService bfA = new XYUserBehaviorServiceImpl();
    protected long bfB = 0;
    private boolean bfw = false;
    protected volatile boolean bfx = false;
    private BroadcastReceiver bfy;
    private LocalBroadcastManager bfz;

    /* renamed from: FQ */
    public static long m8731FQ() {
        return bfv;
    }

    /* renamed from: FR */
    private static void m8732FR() {
        try {
            if ("mounted".equals(Environment.getExternalStorageState())) {
                bfv = Utils.getUsableSpace(Environment.getExternalStorageDirectory());
                if (bfv >= 52428800) {
                    bfu &= -3;
                } else {
                    bfu |= 2;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: FS */
    private void m8733FS() {
        if (!this.bfw) {
            IntentFilter e = m8737e(new String[]{"com.introvd.template.nosdcard"});
            e.addAction("com.introvd.template.diskspace");
            e.addAction("android.intent.action.BATTERY_CHANGED");
            e.addAction("android.intent.action.SCREEN_OFF");
            e.addAction("android.intent.action.SCREEN_ON");
            e.addAction("android.intent.action.MEDIA_SCANNER_FINISHED");
            e.addAction("android.intent.action.MEDIA_REMOVED");
            LocalBroadcastManager.getInstance(this).registerReceiver(this.akb, e);
            this.bfw = true;
        }
    }

    /* renamed from: a */
    private void m8734a(IntentFilter intentFilter) {
        if (this.bfy == null) {
            this.bfy = new BroadcastReceiver() {
                public void onReceive(Context context, Intent intent) {
                    EventActivity.this.mo22820q(intent);
                }
            };
            this.bfz = LocalBroadcastManager.getInstance(getApplicationContext());
            this.bfz.registerReceiver(this.bfy, intentFilter);
            return;
        }
        throw new ExceptionInInitializerError("the receiver have registerd");
    }

    /* renamed from: a */
    private void m8735a(Locale locale) {
        if (!getApplicationContext().getResources().getConfiguration().locale.equals(locale)) {
            C4598j.m11731a(getApplicationContext(), locale);
        }
    }

    /* renamed from: bo */
    public static boolean m8736bo(Context context) {
        if (context != null) {
            m8732FR();
        }
        return (bfu & 2) != 0;
    }

    /* renamed from: e */
    private IntentFilter m8737e(String[] strArr) {
        IntentFilter intentFilter = new IntentFilter();
        for (String addAction : strArr) {
            intentFilter.addAction(addAction);
        }
        return intentFilter;
    }

    /* access modifiers changed from: protected */
    /* renamed from: FT */
    public boolean mo22811FT() {
        return false;
    }

    /* renamed from: FU */
    public void mo22812FU() {
        m8734a(m8737e(mo22813FV()));
    }

    /* access modifiers changed from: protected */
    /* renamed from: FV */
    public String[] mo22813FV() {
        return new String[]{"com.introvd.template.finishactivity"};
    }

    /* renamed from: FW */
    public void mo22814FW() {
        if (this.bfy != null && this.bfz != null) {
            this.bfz.unregisterReceiver(this.bfy);
            this.bfy = null;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: FX */
    public void mo22815FX() {
        if (NotchUtil.isNotchDevice()) {
            setTheme(C10122R.style.Theme_XiaoYingNoSplash);
        }
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context context) {
        super.attachBaseContext(C4611c.m11758bn(context));
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 84) {
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    /* renamed from: ga */
    public boolean mo22817ga(int i) {
        AudioManager audioManager = (AudioManager) getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        int streamVolume = audioManager.getStreamVolume(3);
        switch (i) {
            case 24:
                try {
                    audioManager.setStreamVolume(3, streamVolume + 1, 1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return true;
            case 25:
                try {
                    audioManager.setStreamVolume(3, streamVolume - 1, 1);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                return true;
            default:
                return false;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: gb */
    public void mo22818gb(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("onSysEventProcess eventKey=");
        sb.append(i);
        LogUtilsV2.m14230i(sb.toString());
        if (19 == i) {
            this.bfx = true;
        } else if (18 == i) {
            this.bfx = false;
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        this.bfB = System.currentTimeMillis();
        ISettingRouter iSettingRouter = (ISettingRouter) BizServiceManager.getService(ISettingRouter.class);
        if (iSettingRouter != null) {
            String str = iSettingRouter.getAppSettedLocaleModel(getApplicationContext()).value;
            StringBuilder sb = new StringBuilder();
            sb.append("setLocale lang code=");
            sb.append(str);
            LogUtilsV2.m14230i(sb.toString());
            Locale eK = C4598j.m11732eK(str);
            C4598j.m11731a(this, eK);
            m8735a(eK);
            C9537b.setParameter("LanguageCode", C4580b.m11644b(eK));
        }
        super.onCreate(bundle);
        setVolumeControlStream(3);
        m8733FS();
        if (m8736bo(getApplicationContext())) {
            LocalBroadcastManager.getInstance(this).sendBroadcast(new Intent("com.introvd.template.diskspace"));
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        mo22814FW();
        if (this.akb != null) {
            LocalBroadcastManager.getInstance(this).unregisterReceiver(this.akb);
            this.akb = null;
        }
        LogUtilsV2.m14228e("onDestroy");
        C4597i.m11727Y(this);
        try {
            super.onDestroy();
        } catch (Throwable unused) {
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        boolean ga = mo22817ga(i);
        return ga ? ga : super.onKeyDown(i, keyEvent);
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        if (this.bfw) {
            LocalBroadcastManager.getInstance(this).unregisterReceiver(this.akb);
            this.bfw = false;
        }
        this.bfA.onPause(this);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        try {
            super.onResume();
        } catch (Exception e) {
            C5523b.logException(e);
            finish();
        }
        m8733FS();
        this.bfA.onResume(this);
    }

    /* access modifiers changed from: protected */
    /* renamed from: q */
    public void mo22820q(Intent intent) {
        if ("com.introvd.template.finishactivity".equals(intent.getAction())) {
            mo22811FT();
            finish();
        }
    }
}
