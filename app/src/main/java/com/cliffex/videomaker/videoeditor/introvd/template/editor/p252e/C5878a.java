package com.introvd.template.editor.p252e;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.AssetManager;
import android.text.TextUtils;
import com.introvd.template.VivaBaseApplication;
import com.introvd.template.common.CommonConfigure;
import com.introvd.template.common.LogUtils;
import com.introvd.template.common.ResourceUtils;
import com.introvd.template.p374q.C8345d;
import com.introvd.template.sdk.p383c.C8397a;
import com.introvd.template.template.p409g.C8762d;
import java.util.ArrayList;

/* renamed from: com.introvd.template.editor.e.a */
public class C5878a extends Thread {
    public static final String TAG = "a";
    private static final String[] cUK = {"imageeffect/0x0400000000000000.xyt", "bubbleframe/0x0900000000000001.xyt", "theme/0x0100000000000000.xyt", "transition/0300000000000000.xyt"};
    private int cUL = 0;
    private long cUM = 0;
    private Context cUN;

    public C5878a(Context context) {
        C8345d.m24060R(context, "AppDataLoadingProgress", "0");
        this.cUN = context;
    }

    /* renamed from: a */
    private void m16416a(AssetManager assetManager, int i, int i2) {
        int i3 = i2 - i;
        ContentValues contentValues = C8397a.ecT;
        ContentValues contentValues2 = new ContentValues();
        for (String str : contentValues.keySet()) {
            String asString = contentValues.getAsString(str);
            if (!asString.contains("serverurl")) {
                StringBuilder sb = new StringBuilder();
                sb.append(CommonConfigure.APP_DATA_PATH);
                sb.append(asString);
                contentValues2.put(str, sb.toString());
            }
        }
        if (contentValues2.size() > 0) {
            int i4 = 0;
            int size = contentValues2.size();
            for (String str2 : contentValues2.keySet()) {
                String asString2 = contentValues2.getAsString(str2);
                String str3 = TAG;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("had copy ");
                sb2.append(str2);
                sb2.append(" to ");
                sb2.append(asString2);
                LogUtils.m14223i(str3, sb2.toString());
                ResourceUtils.copyFileFromAssets(str2, asString2, assetManager);
                i4++;
                if (i4 % 10 == 0) {
                    updateProgress(((i4 * i3) / size) + i);
                }
            }
        }
    }

    /* renamed from: b */
    private void m16417b(boolean z, int i, int i2) {
        boolean z2;
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList(C8397a.ecS);
        int i3 = i + (i2 / 4);
        if (i2 != 0) {
            updateProgress(i3);
        }
        C8762d aMt = C8762d.aMt();
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        int i4 = (i2 * 3) / 4;
        while (!arrayList.isEmpty()) {
            boolean z3 = false;
            while (true) {
                z2 = true;
                if (arrayList2.size() < 10 && !arrayList.isEmpty()) {
                    String str = (String) arrayList.remove(0);
                    z3 = z3 || m16418ih(str);
                    arrayList2.add(str);
                } else if (!z && !z3) {
                    z2 = false;
                }
            }
            z2 = false;
            aMt.mo35223a(arrayList2, z2, 0, (String) null);
            if (i2 != 0) {
                i3 += (arrayList2.size() * i4) / size;
                updateProgress(i3);
            }
            arrayList2.clear();
        }
        if (i2 != 0) {
            updateProgress(i + i2);
        }
        long currentTimeMillis2 = 0 + (System.currentTimeMillis() - currentTimeMillis);
        String str2 = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("Install total cost:");
        sb.append(currentTimeMillis2);
        LogUtils.m14222e(str2, sb.toString());
    }

    /* renamed from: ih */
    private boolean m16418ih(String str) {
        return TextUtils.indexOf(str, "0400000000") >= 0;
    }

    private void updateProgress(int i) {
        if (this.cUL <= i) {
            long currentTimeMillis = System.currentTimeMillis();
            C8345d.m24060R(VivaBaseApplication.m8749FZ(), "AppDataLoadingProgress", String.valueOf(i));
            String str = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("updateProgress:");
            sb.append(i);
            sb.append(", cost:");
            long j = 0;
            if (this.cUM != 0) {
                j = currentTimeMillis - this.cUM;
            }
            sb.append(j);
            LogUtils.m14222e(str, sb.toString());
            this.cUM = currentTimeMillis;
        }
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:85:0x02b3 */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00f4 A[Catch:{ Exception -> 0x018b, Throwable -> 0x02b3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00f7 A[Catch:{ Exception -> 0x018b, Throwable -> 0x02b3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0127 A[Catch:{ Exception -> 0x018b, Throwable -> 0x02b3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x017b A[Catch:{ Exception -> 0x018b, Throwable -> 0x02b3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0190 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r15 = this;
            r0 = 1
            com.introvd.template.common.AppPreferencesSetting r1 = com.introvd.template.common.AppPreferencesSetting.getInstance()     // Catch:{ Throwable -> 0x02b3 }
            java.lang.String r2 = "AppSafeExit"
            r3 = 0
            boolean r2 = r1.getAppSettingBoolean(r2, r3)     // Catch:{ Throwable -> 0x02b3 }
            com.introvd.template.common.AppPreferencesSetting r4 = com.introvd.template.common.AppPreferencesSetting.getInstance()     // Catch:{ Throwable -> 0x02b3 }
            java.lang.String r5 = "AppSafeExit"
            r4.setAppSettingBoolean(r5, r3)     // Catch:{ Throwable -> 0x02b3 }
            r4 = -1
            android.os.Process.setThreadPriority(r4)     // Catch:{ Throwable -> 0x02b3 }
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ Throwable -> 0x02b3 }
            java.lang.String r6 = com.introvd.template.common.CommonConfigure.APP_PATH_INTERNAL_TEMPLATES     // Catch:{ Throwable -> 0x02b3 }
            boolean r6 = com.introvd.template.common.FileUtils.isDirectoryExisted(r6)     // Catch:{ Throwable -> 0x02b3 }
            com.introvd.template.common.AppPreferencesSetting r7 = com.introvd.template.common.AppPreferencesSetting.getInstance()     // Catch:{ Throwable -> 0x02b3 }
            java.lang.String r8 = "assets_copy_done"
            r7.setAppSettingBoolean(r8, r3)     // Catch:{ Throwable -> 0x02b3 }
            r15.updateProgress(r3)     // Catch:{ Throwable -> 0x02b3 }
            com.introvd.template.C4677g.m12174Gd()     // Catch:{ Throwable -> 0x02b3 }
            r7 = 20
            r15.updateProgress(r7)     // Catch:{ Throwable -> 0x02b3 }
            android.content.Context r7 = r15.cUN     // Catch:{ Throwable -> 0x02b3 }
            android.content.Context r7 = r7.getApplicationContext()     // Catch:{ Throwable -> 0x02b3 }
            java.lang.String r7 = com.introvd.template.p203b.C4582c.m11667dD(r7)     // Catch:{ Throwable -> 0x02b3 }
            java.lang.String r8 = com.introvd.template.C3569a.m8776FO()     // Catch:{ Throwable -> 0x02b3 }
            boolean r9 = com.introvd.template.common.Utils.isNewVersion(r7, r8)     // Catch:{ Throwable -> 0x02b3 }
            boolean r7 = r7.equals(r8)     // Catch:{ Throwable -> 0x02b3 }
            r7 = r7 ^ r0
            r7 = r7 | r9
            boolean r9 = android.text.TextUtils.isEmpty(r8)     // Catch:{ Throwable -> 0x02b3 }
            if (r9 == 0) goto L_0x006c
            boolean r9 = com.introvd.template.common.ApiHelper.JELLY_BEAN_AND_HIGHER     // Catch:{ Throwable -> 0x02b3 }
            if (r9 == 0) goto L_0x0063
            com.introvd.template.common.AppPreferencesSetting r9 = com.introvd.template.common.AppPreferencesSetting.getInstance()     // Catch:{ Throwable -> 0x02b3 }
            java.lang.String r10 = "pref_encode"
            r9.setAppSettingBoolean(r10, r0)     // Catch:{ Throwable -> 0x02b3 }
            goto L_0x006c
        L_0x0063:
            com.introvd.template.common.AppPreferencesSetting r9 = com.introvd.template.common.AppPreferencesSetting.getInstance()     // Catch:{ Throwable -> 0x02b3 }
            java.lang.String r10 = "pref_encode"
            r9.setAppSettingBoolean(r10, r3)     // Catch:{ Throwable -> 0x02b3 }
        L_0x006c:
            java.lang.String r9 = "AppChannelLangPref"
            java.lang.String r10 = ""
            java.lang.String r9 = r1.getAppSettingStr(r9, r10)     // Catch:{ Throwable -> 0x02b3 }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x02b3 }
            r10.<init>()     // Catch:{ Throwable -> 0x02b3 }
            android.content.Context r11 = r15.cUN     // Catch:{ Throwable -> 0x02b3 }
            java.lang.String r11 = com.introvd.template.p203b.C4580b.m11651dx(r11)     // Catch:{ Throwable -> 0x02b3 }
            r10.append(r11)     // Catch:{ Throwable -> 0x02b3 }
            java.lang.String r11 = "_"
            r10.append(r11)     // Catch:{ Throwable -> 0x02b3 }
            java.util.Locale r11 = java.util.Locale.getDefault()     // Catch:{ Throwable -> 0x02b3 }
            r10.append(r11)     // Catch:{ Throwable -> 0x02b3 }
            java.lang.String r10 = r10.toString()     // Catch:{ Throwable -> 0x02b3 }
            boolean r11 = android.text.TextUtils.isEmpty(r9)     // Catch:{ Throwable -> 0x02b3 }
            if (r11 != 0) goto L_0x00a4
            boolean r11 = android.text.TextUtils.isEmpty(r10)     // Catch:{ Throwable -> 0x02b3 }
            if (r11 != 0) goto L_0x00a4
            boolean r9 = r10.equals(r9)     // Catch:{ Throwable -> 0x02b3 }
            if (r9 != 0) goto L_0x00b3
        L_0x00a4:
            java.lang.String r7 = "AppChannelLangPref"
            r1.setAppSettingStr(r7, r10)     // Catch:{ Throwable -> 0x02b3 }
            com.introvd.template.common.AppPreferencesSetting r1 = com.introvd.template.common.AppPreferencesSetting.getInstance()     // Catch:{ Throwable -> 0x02b3 }
            java.lang.String r7 = "pref_encode"
            r1.setAppSettingBoolean(r7, r0)     // Catch:{ Throwable -> 0x02b3 }
            r7 = 1
        L_0x00b3:
            java.lang.String r1 = TAG     // Catch:{ Throwable -> 0x02b3 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x02b3 }
            r9.<init>()     // Catch:{ Throwable -> 0x02b3 }
            java.lang.String r10 = "create app work folder, cost:"
            r9.append(r10)     // Catch:{ Throwable -> 0x02b3 }
            long r10 = java.lang.System.currentTimeMillis()     // Catch:{ Throwable -> 0x02b3 }
            r12 = 0
            long r10 = r10 - r4
            r9.append(r10)     // Catch:{ Throwable -> 0x02b3 }
            java.lang.String r4 = r9.toString()     // Catch:{ Throwable -> 0x02b3 }
            com.introvd.template.common.LogUtils.m14222e(r1, r4)     // Catch:{ Throwable -> 0x02b3 }
            java.lang.System.currentTimeMillis()     // Catch:{ Throwable -> 0x02b3 }
            com.introvd.template.common.AppPreferencesSetting r1 = com.introvd.template.common.AppPreferencesSetting.getInstance()     // Catch:{ Throwable -> 0x02b3 }
            java.lang.String r4 = "assets_copy_done"
            boolean r1 = r1.getAppSettingBoolean(r4, r3)     // Catch:{ Throwable -> 0x02b3 }
            com.introvd.template.common.AppPreferencesSetting r4 = com.introvd.template.common.AppPreferencesSetting.getInstance()     // Catch:{ Throwable -> 0x02b3 }
            java.lang.String r5 = "template_info_miss_in_db_flag"
            boolean r4 = r4.getAppSettingBoolean(r5, r3)     // Catch:{ Throwable -> 0x02b3 }
            if (r4 != 0) goto L_0x00f1
            if (r1 == 0) goto L_0x00f1
            if (r7 != 0) goto L_0x00f1
            if (r6 != 0) goto L_0x00ef
            goto L_0x00f1
        L_0x00ef:
            r5 = 0
            goto L_0x00f2
        L_0x00f1:
            r5 = 1
        L_0x00f2:
            if (r2 != 0) goto L_0x00f5
            r5 = 1
        L_0x00f5:
            if (r5 != 0) goto L_0x0124
            android.content.Context r2 = r15.cUN     // Catch:{ Throwable -> 0x02b3 }
            android.content.ContentResolver r9 = r2.getContentResolver()     // Catch:{ Throwable -> 0x02b3 }
            java.lang.String r12 = "url like ?"
            java.lang.String r2 = "template_id"
            java.lang.String[] r11 = new java.lang.String[]{r2}     // Catch:{ Throwable -> 0x02b3 }
            java.lang.String r2 = "assets_android://%"
            java.lang.String[] r13 = new java.lang.String[]{r2}     // Catch:{ Throwable -> 0x02b3 }
            java.lang.String r2 = "Template"
            android.net.Uri r10 = com.introvd.template.datacenter.SocialConstDef.getTableUri(r2)     // Catch:{ Throwable -> 0x02b3 }
            r14 = 0
            android.database.Cursor r2 = r9.query(r10, r11, r12, r13, r14)     // Catch:{ Throwable -> 0x02b3 }
            if (r2 == 0) goto L_0x0124
            int r5 = r2.getCount()     // Catch:{ Throwable -> 0x02b3 }
            r2.close()     // Catch:{ Throwable -> 0x02b3 }
            if (r5 != 0) goto L_0x0123
            r5 = 1
            goto L_0x0124
        L_0x0123:
            r5 = 0
        L_0x0124:
            r2 = 0
            if (r5 == 0) goto L_0x016f
            java.lang.String r6 = "2.0.0"
            boolean r6 = com.introvd.template.common.Utils.isNewVersion(r6, r8)     // Catch:{ Throwable -> 0x02b3 }
            if (r6 == 0) goto L_0x013f
            android.content.Context r6 = r15.cUN     // Catch:{ Throwable -> 0x02b3 }
            android.content.ContentResolver r6 = r6.getContentResolver()     // Catch:{ Throwable -> 0x02b3 }
            java.lang.String r7 = "Template"
            android.net.Uri r7 = com.introvd.template.datacenter.SocialConstDef.getTableUri(r7)     // Catch:{ Throwable -> 0x02b3 }
            r6.delete(r7, r2, r2)     // Catch:{ Throwable -> 0x02b3 }
            goto L_0x016f
        L_0x013f:
            java.lang.String r6 = "3.1.6"
            boolean r6 = com.introvd.template.common.Utils.isNewVersion(r6, r8)     // Catch:{ Throwable -> 0x02b3 }
            if (r6 == 0) goto L_0x016f
            android.content.Context r6 = r15.cUN     // Catch:{ Throwable -> 0x02b3 }
            android.content.ContentResolver r6 = r6.getContentResolver()     // Catch:{ Throwable -> 0x02b3 }
            java.lang.String r7 = "url like ?"
            java.lang.String[] r8 = new java.lang.String[r0]     // Catch:{ Throwable -> 0x02b3 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x02b3 }
            r9.<init>()     // Catch:{ Throwable -> 0x02b3 }
            java.lang.String r10 = com.introvd.template.common.CommonConfigure.APP_PATH_INTERNAL_TEMPLATES     // Catch:{ Throwable -> 0x02b3 }
            r9.append(r10)     // Catch:{ Throwable -> 0x02b3 }
            java.lang.String r10 = "%"
            r9.append(r10)     // Catch:{ Throwable -> 0x02b3 }
            java.lang.String r9 = r9.toString()     // Catch:{ Throwable -> 0x02b3 }
            r8[r3] = r9     // Catch:{ Throwable -> 0x02b3 }
            java.lang.String r9 = "Template"
            android.net.Uri r9 = com.introvd.template.datacenter.SocialConstDef.getTableUri(r9)     // Catch:{ Throwable -> 0x02b3 }
            r6.delete(r9, r7, r8)     // Catch:{ Throwable -> 0x02b3 }
        L_0x016f:
            long r6 = java.lang.System.currentTimeMillis()     // Catch:{ Throwable -> 0x02b3 }
        L_0x0173:
            int r8 = com.introvd.template.p173a.C3570a.m8780RV()     // Catch:{ Throwable -> 0x02b3 }
            r9 = 4
            r8 = r8 & r9
            if (r8 == r9) goto L_0x0190
            boolean r8 = r15.isInterrupted()     // Catch:{ Throwable -> 0x02b3 }
            if (r8 == 0) goto L_0x0185
            com.introvd.template.p173a.C3570a.m8781x(r0, r0)
            return
        L_0x0185:
            r8 = 50
            java.lang.Thread.sleep(r8)     // Catch:{ Exception -> 0x018b }
            goto L_0x0173
        L_0x018b:
            r8 = move-exception
            r8.printStackTrace()     // Catch:{ Throwable -> 0x02b3 }
            goto L_0x0173
        L_0x0190:
            java.lang.String r8 = TAG     // Catch:{ Throwable -> 0x02b3 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x02b3 }
            r9.<init>()     // Catch:{ Throwable -> 0x02b3 }
            java.lang.String r10 = "Wait load lib done, cost:"
            r9.append(r10)     // Catch:{ Throwable -> 0x02b3 }
            long r10 = java.lang.System.currentTimeMillis()     // Catch:{ Throwable -> 0x02b3 }
            r12 = 0
            long r10 = r10 - r6
            r9.append(r10)     // Catch:{ Throwable -> 0x02b3 }
            java.lang.String r6 = r9.toString()     // Catch:{ Throwable -> 0x02b3 }
            com.introvd.template.common.LogUtils.m14222e(r8, r6)     // Catch:{ Throwable -> 0x02b3 }
            r6 = 30
            r15.updateProgress(r6)     // Catch:{ Throwable -> 0x02b3 }
            com.introvd.template.template.g.d r6 = com.introvd.template.template.p409g.C8762d.aMt()     // Catch:{ Throwable -> 0x02b3 }
            android.content.Context r7 = r15.cUN     // Catch:{ Throwable -> 0x02b3 }
            android.content.Context r7 = r7.getApplicationContext()     // Catch:{ Throwable -> 0x02b3 }
            com.introvd.template.common.model.AppStateModel r8 = com.introvd.template.common.model.AppStateModel.getInstance()     // Catch:{ Throwable -> 0x02b3 }
            boolean r8 = r8.isInChina()     // Catch:{ Throwable -> 0x02b3 }
            r6.mo35219Q(r7, r8)     // Catch:{ Throwable -> 0x02b3 }
            android.content.Context r7 = r15.cUN     // Catch:{ Throwable -> 0x02b3 }
            if (r7 == 0) goto L_0x01d4
            android.content.Context r7 = r15.cUN     // Catch:{ Throwable -> 0x02b3 }
            com.introvd.template.sdk.utils.C8567u.setContext(r7)     // Catch:{ Throwable -> 0x02b3 }
            android.content.Context r7 = r15.cUN     // Catch:{ Throwable -> 0x02b3 }
            com.introvd.template.sdk.utils.C8553i.setContext(r7)     // Catch:{ Throwable -> 0x02b3 }
        L_0x01d4:
            com.introvd.template.sdk.utils.b.a r7 = com.introvd.template.sdk.utils.p394b.C8501a.aJs()     // Catch:{ Throwable -> 0x02b3 }
            r7.aJv()     // Catch:{ Throwable -> 0x02b3 }
            r7 = 40
            r15.updateProgress(r7)     // Catch:{ Throwable -> 0x02b3 }
            com.introvd.template.i r7 = com.introvd.template.C4681i.m12184Gp()     // Catch:{ Throwable -> 0x02b3 }
            android.content.res.AssetManager r7 = r7.mo25015Gq()     // Catch:{ Throwable -> 0x02b3 }
            if (r5 == 0) goto L_0x0211
            java.util.ArrayList r8 = new java.util.ArrayList     // Catch:{ Throwable -> 0x02b3 }
            r8.<init>()     // Catch:{ Throwable -> 0x02b3 }
            java.lang.String[] r9 = cUK     // Catch:{ Throwable -> 0x02b3 }
            int r10 = r9.length     // Catch:{ Throwable -> 0x02b3 }
            r11 = 0
        L_0x01f3:
            if (r11 >= r10) goto L_0x020e
            r12 = r9[r11]     // Catch:{ Throwable -> 0x02b3 }
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x02b3 }
            r13.<init>()     // Catch:{ Throwable -> 0x02b3 }
            java.lang.String r14 = "assets_android://xiaoying/"
            r13.append(r14)     // Catch:{ Throwable -> 0x02b3 }
            r13.append(r12)     // Catch:{ Throwable -> 0x02b3 }
            java.lang.String r12 = r13.toString()     // Catch:{ Throwable -> 0x02b3 }
            r8.add(r12)     // Catch:{ Throwable -> 0x02b3 }
            int r11 = r11 + 1
            goto L_0x01f3
        L_0x020e:
            r6.mo35223a(r8, r0, r3, r2)     // Catch:{ Throwable -> 0x02b3 }
        L_0x0211:
            r2 = 60
            r15.updateProgress(r2)     // Catch:{ Throwable -> 0x02b3 }
            com.introvd.template.p173a.C3570a.m8781x(r0, r0)     // Catch:{ Throwable -> 0x02b3 }
            r2 = 70
            r15.updateProgress(r2)     // Catch:{ Throwable -> 0x02b3 }
            if (r5 == 0) goto L_0x022f
            java.lang.String r5 = "执行copy咯"
            com.introvd.template.common.LogUtilsV2.m14232v(r5)     // Catch:{ Throwable -> 0x02b3 }
            r5 = 95
            r15.m16416a(r7, r2, r5)     // Catch:{ Throwable -> 0x02b3 }
            r1 = r1 ^ r0
            r15.m16417b(r1, r3, r3)     // Catch:{ Throwable -> 0x02b3 }
        L_0x022f:
            r1 = 100
            r15.updateProgress(r1)     // Catch:{ Throwable -> 0x02b3 }
            r1 = 10
            android.os.Process.setThreadPriority(r1)     // Catch:{ Throwable -> 0x02b3 }
            com.introvd.template.common.AppPreferencesSetting r1 = com.introvd.template.common.AppPreferencesSetting.getInstance()     // Catch:{ Throwable -> 0x02b3 }
            java.lang.String r2 = "assets_copy_done"
            r1.setAppSettingBoolean(r2, r0)     // Catch:{ Throwable -> 0x02b3 }
            android.content.Context r1 = r15.cUN     // Catch:{ Throwable -> 0x02b3 }
            boolean r1 = com.introvd.template.p374q.C8345d.m24069gQ(r1)     // Catch:{ Throwable -> 0x02b3 }
            if (r1 != 0) goto L_0x025f
            boolean r1 = com.introvd.template.C3569a.m8772FK()     // Catch:{ Throwable -> 0x02b3 }
            if (r1 != 0) goto L_0x025f
            android.content.Context r1 = r15.cUN     // Catch:{ Throwable -> 0x02b3 }
            com.introvd.template.p374q.C8345d.m24061V(r1, r0)     // Catch:{ Throwable -> 0x02b3 }
            android.content.Context r1 = r15.cUN     // Catch:{ Throwable -> 0x02b3 }
            com.introvd.template.p374q.C8343b.m24053gO(r1)     // Catch:{ Throwable -> 0x02b3 }
            android.content.Context r1 = r15.cUN     // Catch:{ Throwable -> 0x02b3 }
            com.introvd.template.p374q.C8356h.m24101gO(r1)     // Catch:{ Throwable -> 0x02b3 }
        L_0x025f:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x02b3 }
            r1.<init>()     // Catch:{ Throwable -> 0x02b3 }
            java.lang.String r2 = com.introvd.template.common.CommonConfigure.APP_DATA_PATH     // Catch:{ Throwable -> 0x02b3 }
            r1.append(r2)     // Catch:{ Throwable -> 0x02b3 }
            java.lang.String r2 = "Templates/"
            r1.append(r2)     // Catch:{ Throwable -> 0x02b3 }
            java.lang.String r1 = r1.toString()     // Catch:{ Throwable -> 0x02b3 }
            com.introvd.template.C4677g.m12179cT(r1)     // Catch:{ Throwable -> 0x02b3 }
            com.introvd.template.template.g.d r2 = com.introvd.template.template.p409g.C8762d.aMt()     // Catch:{ Throwable -> 0x02b3 }
            android.content.Context r5 = r15.cUN     // Catch:{ Throwable -> 0x02b3 }
            r2.mo35236c(r5, r1, r0, r3)     // Catch:{ Throwable -> 0x02b3 }
            boolean r2 = r15.isInterrupted()     // Catch:{ Throwable -> 0x02b3 }
            if (r2 == 0) goto L_0x0288
            com.introvd.template.p173a.C3570a.m8781x(r0, r0)
            return
        L_0x0288:
            java.lang.String r2 = com.introvd.template.common.CommonConfigure.APP_DOWNLOAD_TEMPLATES_PATH     // Catch:{ Throwable -> 0x02b3 }
            boolean r1 = android.text.TextUtils.equals(r1, r2)     // Catch:{ Throwable -> 0x02b3 }
            if (r1 != 0) goto L_0x02a5
            com.introvd.template.template.g.d r1 = com.introvd.template.template.p409g.C8762d.aMt()     // Catch:{ Throwable -> 0x02b3 }
            android.content.Context r2 = r15.cUN     // Catch:{ Throwable -> 0x02b3 }
            java.lang.String r5 = com.introvd.template.common.CommonConfigure.APP_DOWNLOAD_TEMPLATES_PATH     // Catch:{ Throwable -> 0x02b3 }
            r1.mo35236c(r2, r5, r0, r3)     // Catch:{ Throwable -> 0x02b3 }
            boolean r1 = r15.isInterrupted()     // Catch:{ Throwable -> 0x02b3 }
            if (r1 == 0) goto L_0x02a5
            com.introvd.template.p173a.C3570a.m8781x(r0, r0)
            return
        L_0x02a5:
            if (r4 == 0) goto L_0x02b6
            com.introvd.template.common.AppPreferencesSetting r1 = com.introvd.template.common.AppPreferencesSetting.getInstance()     // Catch:{ Throwable -> 0x02b3 }
            java.lang.String r2 = "template_info_miss_in_db_flag"
            r1.setAppSettingBoolean(r2, r3)     // Catch:{ Throwable -> 0x02b3 }
            goto L_0x02b6
        L_0x02b1:
            r1 = move-exception
            goto L_0x02ba
        L_0x02b3:
            com.introvd.template.p173a.C3570a.m8781x(r0, r0)     // Catch:{ all -> 0x02b1 }
        L_0x02b6:
            com.introvd.template.p173a.C3570a.m8781x(r0, r0)
            return
        L_0x02ba:
            com.introvd.template.p173a.C3570a.m8781x(r0, r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.editor.p252e.C5878a.run():void");
    }
}
