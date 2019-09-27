package com.introvd.template.app.receiver;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.p021v4.content.ContextCompat;
import android.support.p021v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.afollestad.materialdialogs.C1885b;
import com.afollestad.materialdialogs.C1890f;
import com.afollestad.materialdialogs.C1890f.C1895a;
import com.afollestad.materialdialogs.C1890f.C1904j;
import com.giii.aiii.biii.common.GoogleApiAvailability;
import com.introvd.base.utlisads.BuildConfig;
import com.introvd.template.C4681i;
import com.introvd.template.R;
import com.introvd.template.VivaBaseApplication;
import com.introvd.template.common.AppPreferencesSetting;
import com.introvd.template.common.CommonConfigure;
import com.introvd.template.common.FileUtils;
import com.introvd.template.common.LogUtils;
import com.introvd.template.common.ToastUtils;
import com.introvd.template.common.UserBehaviorLog;
import com.introvd.template.datacenter.DownloadService;
import com.introvd.template.datacenter.SocialConstDef;
import com.introvd.template.datacenter.SocialServiceDef;
import com.introvd.template.p203b.C4580b;
import com.introvd.template.p203b.C4582c;
import com.introvd.template.p207c.C4612a;
import com.introvd.template.p318i.C7515a;
import com.p131c.p132a.C2561a;
import com.p131c.p132a.p135c.C2575a;
import com.quvideo.priority.p217a.C4892c;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Locale;

public class UpgradeBroadcastReceiver extends BroadcastReceiver {
    private static UpgradeBroadcastReceiver bwh;
    private String apkUrl = null;
    public boolean bwa = false;
    /* access modifiers changed from: private */
    public C4127b bwb;
    private long bwc = 0;
    /* access modifiers changed from: private */
    public C7515a bwd;
    private String bwe = null;
    private boolean bwf = false;
    /* access modifiers changed from: private */
    public WeakReference<Activity> bwg = new WeakReference<>(null);
    private String description = null;
    /* access modifiers changed from: private */
    public final Context mContext;

    /* renamed from: com.introvd.template.app.receiver.UpgradeBroadcastReceiver$a */
    private static class C4126a extends Handler {
        private final C4127b bwb;
        private final C7515a bwr;
        private final long bws;
        private final long bwt;
        private final Context mContext;

        public C4126a(Context context, C7515a aVar, C4127b bVar, long j, long j2) {
            super(Looper.getMainLooper());
            this.mContext = context;
            this.bwr = aVar;
            this.bwb = bVar;
            this.bws = j;
            this.bwt = j2;
        }

        public void handleMessage(Message message) {
            StringBuilder sb = new StringBuilder();
            sb.append("msg:");
            sb.append(message.what);
            LogUtils.m14223i("DownloadHandler", sb.toString());
            boolean z = true;
            if (message.what == 1) {
                if (this.bwr != null) {
                    this.bwr.dismiss();
                }
                if (this.bwb != null) {
                    C4127b bVar = this.bwb;
                    if (message.arg1 != 131072) {
                        z = false;
                    }
                    bVar.mo23810j(z, false);
                }
            } else if (message.what == 0) {
                this.mContext.getContentResolver();
                new String[]{SocialConstDef.DOWNLOAD_CURRENT_SIZE, SocialConstDef.DOWNLOAD_TOTAL, "state", "local"};
            }
        }
    }

    /* renamed from: com.introvd.template.app.receiver.UpgradeBroadcastReceiver$b */
    public interface C4127b {
        /* renamed from: j */
        void mo23810j(boolean z, boolean z2);
    }

    /* renamed from: com.introvd.template.app.receiver.UpgradeBroadcastReceiver$c */
    public class C4128c extends C4892c {
        public C4128c() {
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public /* synthetic */ void m10257a(DialogInterface dialogInterface) {
            mo25344EW();
        }

        /* access modifiers changed from: protected */
        /* renamed from: p */
        public boolean mo23396p(Activity activity) {
            return UpgradeBroadcastReceiver.this.m10243c((OnDismissListener) new C4131b(this));
        }

        /* renamed from: sb */
        public int mo23397sb() {
            return 96;
        }
    }

    private UpgradeBroadcastReceiver(Context context) {
        this.mContext = context.getApplicationContext();
    }

    /* renamed from: No */
    private void m10231No() {
        m10239a((Activity) this.bwg.get(), this.description, this.apkUrl, this.bwe, (OnDismissListener) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public long m10233a(String str, int i, boolean z) {
        long j;
        long j2;
        int i2;
        long j3;
        String str2 = str;
        int i3 = i;
        try {
            Uri.parse(str);
            String dM = m10248dM(str);
            ContentResolver contentResolver = this.mContext.getContentResolver();
            StringBuilder sb = new StringBuilder();
            sb.append("remote = ? AND type = ");
            sb.append(i3);
            String str3 = null;
            Cursor query = contentResolver.query(SocialConstDef.getTableUri(SocialConstDef.TBL_NAME_URLCACHE), new String[]{"local", "userdata"}, sb.toString(), new String[]{str2}, null);
            if (query != null) {
                if (query.moveToFirst()) {
                    String eA = C4580b.m11655eA(query.getString(0));
                    String string = query.getString(1);
                    j3 = !TextUtils.isEmpty(string) ? Long.valueOf(string).longValue() : 0;
                    str3 = eA;
                } else {
                    j3 = 0;
                }
                query.close();
                j2 = j3;
            } else {
                j2 = 0;
            }
            if (!TextUtils.isEmpty(str3)) {
                Cursor query2 = contentResolver.query(SocialConstDef.getTableUri(SocialConstDef.TBL_NAME_DOWNLOAD), new String[]{"state"}, "_id = ?", new String[]{String.valueOf(j2)}, null);
                if (query2 != null) {
                    i2 = query2.moveToFirst() ? query2.getInt(0) : 0;
                    query2.close();
                } else {
                    i2 = 0;
                }
                if (196608 == i2) {
                    ToastUtils.show(this.mContext, R.string.xiaoying_str_com_msg_downloading_list, 0);
                    return j2;
                } else if (131072 == i2) {
                    if (str3.startsWith("file://")) {
                        str3 = str3.replace("file://", "");
                    }
                    if (FileUtils.isFileExisted(str3)) {
                        Intent intent = new Intent("android.intent.action.VIEW");
                        intent.addFlags(268435456);
                        C4612a.m11759a(intent, "application/vnd.android.package-archive", new File(str3), true);
                        try {
                            this.mContext.startActivity(intent);
                        } catch (Exception unused) {
                        }
                        return j2;
                    }
                }
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(CommonConfigure.APP_DATA_PATH);
            sb2.append(dM);
            String sb3 = sb2.toString();
            j = DownloadService.enqueue(this.mContext, str2, sb3, 1, i3);
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put("local", sb3);
                contentValues.put("remote", str2);
                contentValues.put("type", Integer.valueOf(i));
                contentValues.put("userdata", String.valueOf(j));
                contentResolver.insert(SocialConstDef.getTableUri(SocialConstDef.TBL_NAME_URLCACHE), contentValues);
                DownloadService.startDownload(this.mContext, j);
            } catch (Exception e) {
                e = e;
            }
        } catch (Exception e2) {
            e = e2;
            j = 0;
            e.printStackTrace();
            return j;
        }
        return j;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m10238a(boolean z, String str, Activity activity, int i) {
        if (z) {
            AppPreferencesSetting.getInstance().setAppSettingStr("pref_apk_disable_version", str);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("choose", i == 1 ? "updateEffect" : "cancel");
        hashMap.put("no_reminding_again", z ? "yes" : "no");
        UserBehaviorLog.onKVEvent(activity, "Update_Dialog", hashMap);
    }

    /* renamed from: a */
    private boolean m10239a(final Activity activity, String str, final String str2, final String str3, OnDismissListener onDismissListener) {
        if (activity == null || activity.isFinishing() || !this.bwf) {
            return false;
        }
        this.bwf = false;
        String string = activity.getResources().getString(R.string.xiaoying_str_com_update_info_tip);
        String appSettingStr = AppPreferencesSetting.getInstance().getAppSettingStr("pref_apk_disable_version", "");
        if (!TextUtils.isEmpty(appSettingStr) && TextUtils.equals(appSettingStr, str3)) {
            return false;
        }
        C1895a ds = new C1895a(activity).mo10312q(string).mo10315r(str).mo10303dv(R.string.xiaoying_str_com_new_version_update_later).mo10299dr(R.string.xiaoying_str_com_new_version_update_immediate).mo10288aA(true).mo10302du(ContextCompat.getColor(this.mContext, R.color.color_585858)).mo10300ds(ContextCompat.getColor(this.mContext, R.color.color_ff5e13));
        if (!C4681i.m12184Gp().mo25016Gr().isSettingAboutActivityInstance(this.mContext)) {
            ds.mo10273a(R.string.xiaoying_str_com_do_not_prompt_for_this_version, false, (OnCheckedChangeListener) null).mo10305dx(R.color.color_ff5e13);
        }
        ds.mo10291b(new C1904j() {
            public void onClick(C1890f fVar, C1885b bVar) {
                UpgradeBroadcastReceiver.this.bwa = false;
                UpgradeBroadcastReceiver.this.m10238a(fVar.mo10262qp(), str3, activity, 0);
            }
        }).mo10281a((C1904j) new C1904j() {
            public void onClick(C1890f fVar, C1885b bVar) {
                UpgradeBroadcastReceiver.this.m10238a(fVar.mo10262qp(), str3, activity, 1);
                if (!C4580b.m11646dA(activity) || !C4580b.m11631B(activity, "com.diii.vending") || !UpgradeBroadcastReceiver.this.mo23798Np()) {
                    UpgradeBroadcastReceiver.this.m10233a(str2, 0, true);
                } else {
                    C4580b.m11654e(activity, UpgradeBroadcastReceiver.m10249dN(activity.getPackageName()));
                }
            }
        }).mo10275a((OnCancelListener) new OnCancelListener() {
            public void onCancel(DialogInterface dialogInterface) {
                UpgradeBroadcastReceiver.this.bwa = false;
            }
        }).mo10276a(onDismissListener).mo10313qu().show();
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public boolean m10243c(OnDismissListener onDismissListener) {
        return m10239a((Activity) this.bwg.get(), this.description, this.apkUrl, this.bwe, onDismissListener);
    }

    /* renamed from: cA */
    public static synchronized UpgradeBroadcastReceiver m10244cA(Context context) {
        UpgradeBroadcastReceiver upgradeBroadcastReceiver;
        synchronized (UpgradeBroadcastReceiver.class) {
            if (bwh == null) {
                bwh = new UpgradeBroadcastReceiver(context);
            }
            upgradeBroadcastReceiver = bwh;
        }
        return upgradeBroadcastReceiver;
    }

    /* renamed from: cB */
    public static boolean m10245cB(Context context) {
        String dD = C4582c.m11667dD(context);
        return isNewVersion(AppPreferencesSetting.getInstance().getAppSettingStr("pref_apk_version", dD), dD);
    }

    /* renamed from: cC */
    private boolean m10246cC(Context context) {
        String packageName = context.getPackageName();
        return packageName.equals("com.quvideo.xiaoying") || packageName.equals(BuildConfig.APPLICATION_ID);
    }

    /* access modifiers changed from: private */
    /* renamed from: dM */
    public String m10248dM(String str) {
        int lastIndexOf = str.lastIndexOf(47);
        return lastIndexOf != -1 ? str.substring(lastIndexOf + 1) : str;
    }

    /* access modifiers changed from: private */
    /* renamed from: dN */
    public static String m10249dN(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("market://details?id=");
        sb.append(str);
        return sb.toString();
    }

    public static String getAppVersion(Context context) {
        String str;
        String str2 = "0";
        try {
            str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            if (str != null) {
                try {
                    if (str.length() <= 0) {
                    }
                } catch (Exception e) {
                    Exception exc = e;
                    str2 = str;
                    e = exc;
                    e.printStackTrace();
                    str = str2;
                    return str;
                }
                return str;
            }
            return "0";
        } catch (Exception e2) {
            e = e2;
            e.printStackTrace();
            str = str2;
            return str;
        }
    }

    /* renamed from: h */
    private void m10251h(String str, final String str2, String str3) {
        final Activity activity = (Activity) this.bwg.get();
        if (activity != null) {
            C1895a aVar = new C1895a(activity);
            aVar.mo10293dl(R.string.xiaoying_str_com_important_tip);
            if (!TextUtils.isEmpty(str)) {
                aVar.mo10315r(str);
            } else {
                aVar.mo10296do(R.string.xiaoying_str_com_app_force_upgrade_desc);
            }
            aVar.mo10288aA(false).mo10290az(false).mo10303dv(R.string.xiaoying_str_com_upgrade_btn).mo10302du(activity.getResources().getColor(R.color.color_fc4f21)).mo10291b(new C1904j() {
                public void onClick(C1890f fVar, C1885b bVar) {
                    if (!C4580b.m11646dA(activity) || !C4580b.m11631B(activity, "com.diii.vending") || !UpgradeBroadcastReceiver.this.mo23798Np()) {
                        UpgradeBroadcastReceiver.this.m10233a(str2, 0, true);
                    } else {
                        C4580b.m11654e(activity, UpgradeBroadcastReceiver.m10249dN(activity.getPackageName()));
                    }
                }
            }).mo10313qu().show();
        }
    }

    /* renamed from: hj */
    private String m10252hj(int i) {
        return String.format(Locale.US, "%d.%d.%d", new Object[]{Integer.valueOf((i >> 24) & 255), Integer.valueOf((i >> 16) & 255), Integer.valueOf(i & 65535)});
    }

    public static boolean isNewVersion(String str, String str2) {
        String str3;
        String str4;
        boolean z = false;
        if (str == null || str2 == null) {
            return false;
        }
        try {
            if (str2.equals(str)) {
                return false;
            }
            String valueOf = String.valueOf(str.replace("@", ""));
            String valueOf2 = String.valueOf(str2);
            int i = 0;
            int i2 = 0;
            while (true) {
                i = valueOf.indexOf(46, i);
                i2 = valueOf2.indexOf(46, i2);
                if (i != -1) {
                    String substring = valueOf.substring(0, i);
                    str3 = valueOf.substring(i + 1);
                    valueOf = substring;
                } else {
                    str3 = "";
                }
                if (i2 != -1) {
                    String substring2 = valueOf2.substring(0, i2);
                    str4 = valueOf2.substring(i2 + 1);
                    valueOf2 = substring2;
                } else {
                    str4 = "";
                }
                try {
                    int parseInt = C2575a.parseInt(valueOf2);
                    int parseInt2 = C2575a.parseInt(valueOf);
                    if (parseInt == parseInt2) {
                        if (TextUtils.isEmpty(str3) && TextUtils.isEmpty(str4)) {
                            break;
                        }
                        valueOf2 = str4;
                        valueOf = str3;
                    } else {
                        if (parseInt2 > parseInt) {
                            z = true;
                        }
                        return z;
                    }
                } catch (Exception unused) {
                    return true;
                }
            }
            return false;
        } catch (Exception unused2) {
        }
    }

    /* renamed from: M */
    public synchronized void mo23797M(Activity activity) {
        this.bwg = new WeakReference<>(activity);
    }

    /* renamed from: Np */
    public boolean mo23798Np() {
        return GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(VivaBaseApplication.m8749FZ()) == 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:120:0x0312, code lost:
        if (r4 == false) goto L_0x033d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x0314, code lost:
        r15 = new android.content.Intent(com.introvd.template.datacenter.SocialServiceDef.ACTION_SOCIAL_SERVICE_FEEDBACK);
        r15.putExtra("social_method", com.introvd.template.datacenter.SocialServiceDef.SOCIAL_MISC_METHOD_PATCH_REQ);
        r15.putExtra("errCode", 12289);
        r15.putExtra("wParam", 0);
        r15.putExtra("lParam", 0);
        android.support.p021v4.content.LocalBroadcastManager.getInstance(r14).sendBroadcast(r15);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onReceive(final android.content.Context r14, android.content.Intent r15) {
        /*
            r13 = this;
            java.lang.String r0 = r15.getAction()
            if (r0 == 0) goto L_0x033e
            if (r14 != 0) goto L_0x000a
            goto L_0x033e
        L_0x000a:
            boolean r1 = r13.m10246cC(r14)
            if (r1 != 0) goto L_0x0011
            return
        L_0x0011:
            java.lang.String r1 = "localbroadcast.action.ADK.NewAvaliable"
            boolean r1 = r1.equals(r0)
            r2 = 0
            if (r1 == 0) goto L_0x0051
            android.content.Context r0 = r13.mContext
            if (r0 != 0) goto L_0x001f
            return
        L_0x001f:
            java.lang.String r0 = "Version"
            java.lang.String r15 = r15.getStringExtra(r0)
            com.introvd.template.common.AppPreferencesSetting r0 = com.introvd.template.common.AppPreferencesSetting.getInstance()
            java.lang.String r1 = "pref_apk_version"
            r0.setAppSettingStr(r1, r15)
            com.introvd.template.common.AppPreferencesSetting r0 = com.introvd.template.common.AppPreferencesSetting.getInstance()
            java.lang.String r1 = "pref_apk_disable_version"
            java.lang.String r3 = "0"
            java.lang.String r0 = r0.getAppSettingStr(r1, r3)
            boolean r0 = isNewVersion(r15, r0)
            if (r0 != 0) goto L_0x0041
            return
        L_0x0041:
            java.lang.String r14 = getAppVersion(r14)
            boolean r14 = isNewVersion(r15, r14)
            if (r14 != 0) goto L_0x004c
            return
        L_0x004c:
            com.introvd.template.app.setting.C4322b.m10843hz(r2)
            goto L_0x033d
        L_0x0051:
            java.lang.String r1 = "localbroadcast.action.ADK.upgradeDesc"
            boolean r1 = r1.equals(r0)
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L_0x0147
            java.lang.String r0 = "1"
            java.lang.String r1 = "Flag"
            java.lang.String r1 = r15.getStringExtra(r1)
            boolean r0 = r0.equals(r1)
            java.lang.String r1 = "Version"
            java.lang.String r1 = r15.getStringExtra(r1)
            java.lang.String r5 = "URL"
            java.lang.String r5 = r15.getStringExtra(r5)
            java.lang.String r6 = "1"
            java.lang.String r7 = "IsShow"
            java.lang.String r7 = r15.getStringExtra(r7)
            boolean r6 = r6.equals(r7)
            android.content.Context r7 = r13.mContext
            java.lang.String r7 = getAppVersion(r7)
            java.lang.String r8 = "from"
            int r8 = r15.getIntExtra(r8, r2)
            boolean r7 = isNewVersion(r1, r7)
            if (r7 == 0) goto L_0x0097
            if (r6 != 0) goto L_0x0095
            if (r0 == 0) goto L_0x0097
        L_0x0095:
            r6 = 1
            goto L_0x0098
        L_0x0097:
            r6 = 0
        L_0x0098:
            if (r6 != 0) goto L_0x00b4
            long r14 = r13.bwc
            r0 = 1
            long r14 = r14 & r0
            r0 = 0
            int r14 = (r14 > r0 ? 1 : (r14 == r0 ? 0 : -1))
            if (r14 == 0) goto L_0x00b3
            if (r4 != r8) goto L_0x00b3
            com.introvd.template.p203b.C4586g.m11695Sl()
            android.content.Context r14 = r13.mContext
            int r15 = com.introvd.template.R.string.xiaoying_str_com_new_version_checking_islast
            r0 = 2000(0x7d0, float:2.803E-42)
            com.introvd.template.common.ToastUtils.show(r14, r15, r0)
        L_0x00b3:
            return
        L_0x00b4:
            java.lang.String r6 = "Desc"
            java.lang.String r6 = r15.getStringExtra(r6)
            java.lang.String r7 = "Size"
            java.lang.String r15 = r15.getStringExtra(r7)
            java.lang.Long r15 = java.lang.Long.valueOf(r15)     // Catch:{ Exception -> 0x0128 }
            long r7 = r15.longValue()     // Catch:{ Exception -> 0x0128 }
            com.introvd.template.common.FileUtils.formatFileSize(r7)     // Catch:{ Exception -> 0x0128 }
            r13.bwa = r4
            com.introvd.template.p203b.C4586g.m11695Sl()
            android.content.res.Resources r14 = r14.getResources()
            int r15 = com.introvd.template.R.string.xiaoying_str_com_msg_new_version_recomment_upgrade
            java.lang.Object[] r3 = new java.lang.Object[r3]
            r3[r2] = r1
            r3[r4] = r6
            java.lang.String r14 = r14.getString(r15, r3)
            boolean r15 = android.text.TextUtils.isEmpty(r6)
            if (r15 == 0) goto L_0x00e8
            java.lang.String r14 = ""
        L_0x00e8:
            java.lang.ref.WeakReference<android.app.Activity> r15 = r13.bwg
            java.lang.Object r15 = r15.get()
            android.app.Activity r15 = (android.app.Activity) r15
            if (r15 != 0) goto L_0x00f3
            return
        L_0x00f3:
            if (r0 == 0) goto L_0x00fa
            r13.m10251h(r14, r5, r1)
            goto L_0x033d
        L_0x00fa:
            java.lang.ref.WeakReference<android.app.Activity> r15 = r13.bwg
            java.lang.Object r15 = r15.get()
            android.app.Activity r15 = (android.app.Activity) r15
            boolean r0 = android.text.TextUtils.isEmpty(r6)
            if (r0 != 0) goto L_0x0109
            r14 = r6
        L_0x0109:
            r13.description = r14
            r13.apkUrl = r5
            r13.bwe = r1
            r13.bwf = r4
            boolean r14 = r15 instanceof com.introvd.template.XiaoYingActivity
            if (r14 == 0) goto L_0x0123
            com.introvd.template.app.homepage.g r14 = com.introvd.template.app.homepage.C3961g.m9772Lz()
            com.introvd.template.app.receiver.UpgradeBroadcastReceiver$c r15 = new com.introvd.template.app.receiver.UpgradeBroadcastReceiver$c
            r15.<init>()
            r14.mo23525c(r15)
            goto L_0x033d
        L_0x0123:
            r13.m10231No()
            goto L_0x033d
        L_0x0128:
            r14 = move-exception
            java.lang.String r15 = "error"
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "ex:"
            r0.append(r1)
            java.lang.String r14 = r14.getMessage()
            r0.append(r14)
            java.lang.String r14 = r0.toString()
            com.introvd.template.common.LogUtils.m14222e(r15, r14)
            com.introvd.template.p203b.C4586g.m11695Sl()
            return
        L_0x0147:
            java.lang.String r1 = "localbroadcast.action.ADK.upgrade"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x015d
            java.lang.String r14 = "URL"
            java.lang.String r14 = r15.getStringExtra(r14)
            if (r14 != 0) goto L_0x0158
            return
        L_0x0158:
            r13.m10233a(r14, r2, r4)
            goto L_0x033d
        L_0x015d:
            java.lang.String r15 = "localbroadcast.action.PATCH.NewAvaliable"
            boolean r15 = r15.equals(r0)
            if (r15 == 0) goto L_0x0185
            boolean r14 = com.introvd.template.common.ApiHelper.JELLY_BEAN_AND_HIGHER     // Catch:{ Throwable -> 0x017f }
            if (r14 == 0) goto L_0x0174
            com.introvd.template.common.AppPreferencesSetting r14 = com.introvd.template.common.AppPreferencesSetting.getInstance()     // Catch:{ Throwable -> 0x017f }
            java.lang.String r15 = "pref_encode"
            r14.setAppSettingBoolean(r15, r4)     // Catch:{ Throwable -> 0x017f }
            goto L_0x033d
        L_0x0174:
            com.introvd.template.common.AppPreferencesSetting r14 = com.introvd.template.common.AppPreferencesSetting.getInstance()     // Catch:{ Throwable -> 0x017f }
            java.lang.String r15 = "pref_encode"
            r14.setAppSettingBoolean(r15, r2)     // Catch:{ Throwable -> 0x017f }
            goto L_0x033d
        L_0x017f:
            r14 = move-exception
            r14.printStackTrace()
            goto L_0x033d
        L_0x0185:
            java.lang.String r15 = "localbroadcast.action.PATCH.upgrade"
            boolean r15 = r15.equals(r0)
            if (r15 == 0) goto L_0x033d
            java.lang.String r15 = "UpgradeBroadCastReceiver"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r5 = "PATCH action:"
            r1.append(r5)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            com.introvd.template.common.LogUtils.m14223i(r15, r0)
            boolean r15 = r13.bwa
            if (r15 == 0) goto L_0x01a8
            return
        L_0x01a8:
            java.lang.Class<com.introvd.template.router.editor.IEditorService> r15 = com.introvd.template.router.editor.IEditorService.class
            com.aiii.android.arouter.facade.template.c r15 = com.introvd.template.router.BizServiceManager.getService(r15)
            com.introvd.template.router.editor.IEditorService r15 = (com.introvd.template.router.editor.IEditorService) r15
            if (r15 == 0) goto L_0x01b8
            r15.libraryMgrSetContext(r14)
            r15.loadLibraryBaseMode()
        L_0x01b8:
            if (r15 == 0) goto L_0x01c4
            int r0 = r15.GetHWDecoderVersion()     // Catch:{ Throwable -> 0x01c3 }
            int r15 = r15.GetHWEncoderVersion()     // Catch:{ Throwable -> 0x01c3 }
            goto L_0x01c6
        L_0x01c3:
            return
        L_0x01c4:
            r15 = 0
            r0 = 0
        L_0x01c6:
            java.lang.String r1 = ""
            java.lang.String r5 = ""
            int r1 = com.p131c.p132a.p135c.C2575a.parseInt(r1)
            int r5 = com.p131c.p132a.p135c.C2575a.parseInt(r5)
            monitor-enter(r13)
            int r6 = r0 + r15
            if (r6 > 0) goto L_0x0251
            java.lang.String r1 = r13.m10252hj(r1)     // Catch:{ all -> 0x024e }
            java.lang.String r0 = r13.m10252hj(r0)     // Catch:{ all -> 0x024e }
            boolean r0 = isNewVersion(r1, r0)     // Catch:{ all -> 0x024e }
            java.lang.String r1 = r13.m10252hj(r5)     // Catch:{ all -> 0x024e }
            java.lang.String r15 = r13.m10252hj(r15)     // Catch:{ all -> 0x024e }
            boolean r15 = isNewVersion(r1, r15)     // Catch:{ all -> 0x024e }
            if (r0 != 0) goto L_0x01f3
            if (r15 == 0) goto L_0x0311
        L_0x01f3:
            boolean r1 = com.introvd.template.p203b.C4586g.m11694Sk()     // Catch:{ all -> 0x024e }
            if (r1 == 0) goto L_0x0310
            com.introvd.template.p203b.C4586g.m11696Sm()     // Catch:{ all -> 0x024e }
            android.content.res.Resources r1 = r14.getResources()     // Catch:{ all -> 0x024e }
            int r3 = com.introvd.template.R.string.xiaoying_str_com_info_title     // Catch:{ all -> 0x024e }
            java.lang.String r1 = r1.getString(r3)     // Catch:{ all -> 0x024e }
            android.content.res.Resources r3 = r14.getResources()     // Catch:{ all -> 0x024e }
            int r4 = com.introvd.template.R.string.xiaoying_str_ve_msg_download_engine_patch_ask     // Catch:{ all -> 0x024e }
            java.lang.String r3 = r3.getString(r4)     // Catch:{ all -> 0x024e }
            java.lang.ref.WeakReference<android.app.Activity> r4 = r13.bwg     // Catch:{ all -> 0x024e }
            java.lang.Object r4 = r4.get()     // Catch:{ all -> 0x024e }
            android.app.Activity r4 = (android.app.Activity) r4     // Catch:{ all -> 0x024e }
            if (r4 != 0) goto L_0x021c
            monitor-exit(r13)     // Catch:{ all -> 0x024e }
            return
        L_0x021c:
            android.content.Context r4 = r13.mContext     // Catch:{ all -> 0x024e }
            com.afollestad.materialdialogs.f$a r4 = com.introvd.template.p414ui.dialog.C8978m.m26350ht(r4)     // Catch:{ all -> 0x024e }
            com.afollestad.materialdialogs.f$a r1 = r4.mo10312q(r1)     // Catch:{ all -> 0x024e }
            com.afollestad.materialdialogs.f$a r1 = r1.mo10315r(r3)     // Catch:{ all -> 0x024e }
            com.introvd.template.app.receiver.UpgradeBroadcastReceiver$3 r3 = new com.introvd.template.app.receiver.UpgradeBroadcastReceiver$3     // Catch:{ all -> 0x024e }
            r3.<init>()     // Catch:{ all -> 0x024e }
            com.afollestad.materialdialogs.f$a r1 = r1.mo10291b(r3)     // Catch:{ all -> 0x024e }
            com.introvd.template.app.receiver.UpgradeBroadcastReceiver$2 r3 = new com.introvd.template.app.receiver.UpgradeBroadcastReceiver$2     // Catch:{ all -> 0x024e }
            r3.<init>(r0, r14, r15)     // Catch:{ all -> 0x024e }
            com.afollestad.materialdialogs.f$a r15 = r1.mo10281a(r3)     // Catch:{ all -> 0x024e }
            com.introvd.template.app.receiver.UpgradeBroadcastReceiver$1 r0 = new com.introvd.template.app.receiver.UpgradeBroadcastReceiver$1     // Catch:{ all -> 0x024e }
            r0.<init>()     // Catch:{ all -> 0x024e }
            com.afollestad.materialdialogs.f$a r15 = r15.mo10275a(r0)     // Catch:{ all -> 0x024e }
            com.afollestad.materialdialogs.f r15 = r15.mo10313qu()     // Catch:{ all -> 0x024e }
            r15.show()     // Catch:{ all -> 0x024e }
            goto L_0x0310
        L_0x024e:
            r14 = move-exception
            goto L_0x033b
        L_0x0251:
            java.lang.String r1 = r13.m10252hj(r1)     // Catch:{ all -> 0x024e }
            java.lang.String r0 = r13.m10252hj(r0)     // Catch:{ all -> 0x024e }
            boolean r0 = isNewVersion(r1, r0)     // Catch:{ all -> 0x024e }
            java.lang.String r1 = r13.m10252hj(r5)     // Catch:{ all -> 0x024e }
            java.lang.String r15 = r13.m10252hj(r15)     // Catch:{ all -> 0x024e }
            boolean r15 = isNewVersion(r1, r15)     // Catch:{ all -> 0x024e }
            if (r0 != 0) goto L_0x026d
            if (r15 == 0) goto L_0x0311
        L_0x026d:
            boolean r1 = com.introvd.template.p203b.C4586g.m11694Sk()     // Catch:{ all -> 0x024e }
            if (r1 == 0) goto L_0x0276
            com.introvd.template.p203b.C4586g.m11696Sm()     // Catch:{ all -> 0x024e }
        L_0x0276:
            r5 = -1
            if (r0 == 0) goto L_0x02af
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x024e }
            r0.<init>()     // Catch:{ all -> 0x024e }
            java.lang.String r1 = com.introvd.template.datacenter.SocialServiceDef.SOCIAL_DOWNLOAD_PATH     // Catch:{ all -> 0x024e }
            r0.append(r1)     // Catch:{ all -> 0x024e }
            java.lang.String r1 = ""
            java.lang.String r1 = r13.m10248dM(r1)     // Catch:{ all -> 0x024e }
            r0.append(r1)     // Catch:{ all -> 0x024e }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x024e }
            java.lang.String r1 = "local = ?"
            android.content.ContentResolver r7 = r14.getContentResolver()     // Catch:{ all -> 0x024e }
            java.lang.String r8 = "Download"
            android.net.Uri r8 = com.introvd.template.datacenter.SocialConstDef.getTableUri(r8)     // Catch:{ all -> 0x024e }
            java.lang.String[] r9 = new java.lang.String[r4]     // Catch:{ all -> 0x024e }
            r9[r2] = r0     // Catch:{ all -> 0x024e }
            r7.delete(r8, r1, r9)     // Catch:{ all -> 0x024e }
            java.lang.String r1 = ""
            long r0 = com.introvd.template.datacenter.DownloadService.enqueue(r14, r1, r0, r2, r4)     // Catch:{ all -> 0x024e }
            com.introvd.template.datacenter.DownloadService.startDownload(r14, r0)     // Catch:{ all -> 0x024e }
            r9 = r0
            goto L_0x02b0
        L_0x02af:
            r9 = r5
        L_0x02b0:
            if (r15 == 0) goto L_0x02e7
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ all -> 0x024e }
            r15.<init>()     // Catch:{ all -> 0x024e }
            java.lang.String r0 = com.introvd.template.datacenter.SocialServiceDef.SOCIAL_DOWNLOAD_PATH     // Catch:{ all -> 0x024e }
            r15.append(r0)     // Catch:{ all -> 0x024e }
            java.lang.String r0 = ""
            java.lang.String r0 = r13.m10248dM(r0)     // Catch:{ all -> 0x024e }
            r15.append(r0)     // Catch:{ all -> 0x024e }
            java.lang.String r15 = r15.toString()     // Catch:{ all -> 0x024e }
            java.lang.String r0 = "local = ?"
            android.content.ContentResolver r1 = r14.getContentResolver()     // Catch:{ all -> 0x024e }
            java.lang.String r7 = "Download"
            android.net.Uri r7 = com.introvd.template.datacenter.SocialConstDef.getTableUri(r7)     // Catch:{ all -> 0x024e }
            java.lang.String[] r8 = new java.lang.String[r4]     // Catch:{ all -> 0x024e }
            r8[r2] = r15     // Catch:{ all -> 0x024e }
            r1.delete(r7, r0, r8)     // Catch:{ all -> 0x024e }
            java.lang.String r0 = ""
            long r0 = com.introvd.template.datacenter.DownloadService.enqueue(r14, r0, r15, r2, r3)     // Catch:{ all -> 0x024e }
            com.introvd.template.datacenter.DownloadService.startDownload(r14, r0)     // Catch:{ all -> 0x024e }
            r11 = r0
            goto L_0x02e8
        L_0x02e7:
            r11 = r5
        L_0x02e8:
            int r15 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1))
            if (r15 != 0) goto L_0x02f1
            int r15 = (r11 > r5 ? 1 : (r11 == r5 ? 0 : -1))
            if (r15 != 0) goto L_0x02f1
            goto L_0x0310
        L_0x02f1:
            com.introvd.template.app.receiver.UpgradeBroadcastReceiver$a r15 = new com.introvd.template.app.receiver.UpgradeBroadcastReceiver$a     // Catch:{ all -> 0x024e }
            android.content.Context r6 = r13.mContext     // Catch:{ all -> 0x024e }
            r7 = 0
            com.introvd.template.app.receiver.UpgradeBroadcastReceiver$b r8 = r13.bwb     // Catch:{ all -> 0x024e }
            r5 = r15
            r5.<init>(r6, r7, r8, r9, r11)     // Catch:{ all -> 0x024e }
            android.content.Context r0 = r13.mContext     // Catch:{ all -> 0x024e }
            android.content.ContentResolver r0 = r0.getContentResolver()     // Catch:{ all -> 0x024e }
            java.lang.String r1 = "Download"
            android.net.Uri r1 = com.introvd.template.datacenter.SocialConstDef.getTableUri(r1)     // Catch:{ all -> 0x024e }
            com.introvd.template.app.receiver.UpgradeBroadcastReceiver$4 r3 = new com.introvd.template.app.receiver.UpgradeBroadcastReceiver$4     // Catch:{ all -> 0x024e }
            r3.<init>(r15, r15)     // Catch:{ all -> 0x024e }
            r0.registerContentObserver(r1, r4, r3)     // Catch:{ all -> 0x024e }
        L_0x0310:
            r4 = 0
        L_0x0311:
            monitor-exit(r13)     // Catch:{ all -> 0x024e }
            if (r4 == 0) goto L_0x033d
            android.content.Intent r15 = new android.content.Intent
            java.lang.String r0 = "socialservice.feedback"
            r15.<init>(r0)
            java.lang.String r0 = "social_method"
            java.lang.String r1 = "support.patch"
            r15.putExtra(r0, r1)
            java.lang.String r0 = "errCode"
            r1 = 12289(0x3001, float:1.722E-41)
            r15.putExtra(r0, r1)
            java.lang.String r0 = "wParam"
            r15.putExtra(r0, r2)
            java.lang.String r0 = "lParam"
            r15.putExtra(r0, r2)
            android.support.v4.content.LocalBroadcastManager r14 = android.support.p021v4.content.LocalBroadcastManager.getInstance(r14)
            r14.sendBroadcast(r15)
            goto L_0x033d
        L_0x033b:
            monitor-exit(r13)     // Catch:{ all -> 0x024e }
            throw r14
        L_0x033d:
            return
        L_0x033e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.app.receiver.UpgradeBroadcastReceiver.onReceive(android.content.Context, android.content.Intent):void");
    }

    public void register() {
        if (this.mContext != null && C2561a.aOR() == 1) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(SocialServiceDef.ACTION_APK_VERSION_NEW_AVALIABLE);
            intentFilter.addAction(SocialServiceDef.ACTION_APK_VERSION_UPGRADE);
            intentFilter.addAction("localbroadcast.action.ADK.upgradeDesc");
            intentFilter.addAction(SocialServiceDef.ACTION_PATCH_VERSION_NEW_AVALIABLE);
            intentFilter.addAction(SocialServiceDef.ACTION_PATCH_VERSION_UPGRADE);
            LocalBroadcastManager.getInstance(this.mContext).registerReceiver(this, intentFilter);
        }
    }

    public void unregister() {
        if (this.mContext != null) {
            LocalBroadcastManager.getInstance(this.mContext).unregisterReceiver(this);
        }
    }

    /* renamed from: z */
    public void mo23802z(long j) {
        this.bwc = j;
    }
}
