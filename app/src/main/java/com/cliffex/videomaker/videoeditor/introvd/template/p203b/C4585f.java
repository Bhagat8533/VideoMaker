package com.introvd.template.p203b;

import android.content.Context;
import android.text.TextUtils;
import com.introvd.template.crash.C5523b;
import com.introvd.template.crash.C5526d;
import com.introvd.template.p363o.C8092b;
import com.vivavideo.component.permission.C9295b;
import java.util.UUID;

/* renamed from: com.introvd.template.b.f */
public class C4585f {
    private static String bKO;
    private static String bKP;

    /* JADX WARNING: Removed duplicated region for block: B:37:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00d2  */
    /* renamed from: P */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String m11687P(android.content.Context r7, int r8) {
        /*
            java.lang.String r0 = ""
            java.lang.String r1 = "/sdcard/.system_xy/"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = ".xyinstall"
            r2.append(r3)
            r2.append(r8)
            java.lang.String r2 = r2.toString()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "pref_devinfo_openduid_"
            r3.append(r4)
            r3.append(r8)
            java.lang.String r3 = r3.toString()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r1)
            r4.append(r2)
            java.lang.String r4 = r4.toString()
            com.introvd.template.common.AppPreferencesSetting r5 = com.introvd.template.common.AppPreferencesSetting.getInstance()     // Catch:{ all -> 0x00cb }
            java.lang.String r6 = ""
            java.lang.String r5 = r5.getAppSettingStr(r3, r6)     // Catch:{ all -> 0x00cb }
            boolean r0 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x00c8 }
            if (r0 != 0) goto L_0x004f
            boolean r7 = com.introvd.template.common.FileUtils.isFileExisted(r4)
            if (r7 != 0) goto L_0x004e
            m11692j(r1, r2, r5)
        L_0x004e:
            return r5
        L_0x004f:
            java.lang.String r0 = m11691eI(r4)     // Catch:{ all -> 0x00c8 }
            boolean r5 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x00cb }
            if (r5 != 0) goto L_0x006a
            com.introvd.template.common.AppPreferencesSetting r7 = com.introvd.template.common.AppPreferencesSetting.getInstance()     // Catch:{ all -> 0x00cb }
            r7.setAppSettingStr(r3, r0)     // Catch:{ all -> 0x00cb }
            boolean r7 = com.introvd.template.common.FileUtils.isFileExisted(r4)
            if (r7 != 0) goto L_0x0069
            m11692j(r1, r2, r0)
        L_0x0069:
            return r0
        L_0x006a:
            boolean r5 = com.introvd.template.common.FileUtils.isFileExisted(r4)     // Catch:{ all -> 0x00cb }
            if (r5 == 0) goto L_0x0073
            com.introvd.template.common.FileUtils.deleteFile(r4)     // Catch:{ all -> 0x00cb }
        L_0x0073:
            boolean r5 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x00cb }
            if (r5 == 0) goto L_0x00b6
            r5 = 1
            if (r8 != r5) goto L_0x00a0
            int r8 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x00cb }
            r5 = 23
            if (r8 < r5) goto L_0x008a
            java.lang.String r8 = "android.permission.READ_PHONE_STATE"
            int r8 = android.support.p021v4.app.ActivityCompat.checkSelfPermission(r7, r8)     // Catch:{ all -> 0x00cb }
            if (r8 != 0) goto L_0x00b6
        L_0x008a:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x00cb }
            r8.<init>()     // Catch:{ all -> 0x00cb }
            java.lang.String r5 = "[A]"
            r8.append(r5)     // Catch:{ all -> 0x00cb }
            java.lang.String r7 = com.introvd.template.common.DeviceInfo.getOpenUDID(r7)     // Catch:{ all -> 0x00cb }
            r8.append(r7)     // Catch:{ all -> 0x00cb }
            java.lang.String r7 = r8.toString()     // Catch:{ all -> 0x00cb }
            goto L_0x00b7
        L_0x00a0:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x00cb }
            r8.<init>()     // Catch:{ all -> 0x00cb }
            java.lang.String r5 = "[A2]"
            r8.append(r5)     // Catch:{ all -> 0x00cb }
            java.lang.String r7 = m11689dH(r7)     // Catch:{ all -> 0x00cb }
            r8.append(r7)     // Catch:{ all -> 0x00cb }
            java.lang.String r7 = r8.toString()     // Catch:{ all -> 0x00cb }
            goto L_0x00b7
        L_0x00b6:
            r7 = r0
        L_0x00b7:
            boolean r8 = com.introvd.template.common.FileUtils.isFileExisted(r4)
            if (r8 != 0) goto L_0x00c0
            m11692j(r1, r2, r7)
        L_0x00c0:
            com.introvd.template.common.AppPreferencesSetting r8 = com.introvd.template.common.AppPreferencesSetting.getInstance()
            r8.setAppSettingStr(r3, r7)
            return r7
        L_0x00c8:
            r7 = move-exception
            r0 = r5
            goto L_0x00cc
        L_0x00cb:
            r7 = move-exception
        L_0x00cc:
            boolean r8 = com.introvd.template.common.FileUtils.isFileExisted(r4)
            if (r8 != 0) goto L_0x00d5
            m11692j(r1, r2, r0)
        L_0x00d5:
            com.introvd.template.common.AppPreferencesSetting r8 = com.introvd.template.common.AppPreferencesSetting.getInstance()
            r8.setAppSettingStr(r3, r0)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.p203b.C4585f.m11687P(android.content.Context, int):java.lang.String");
    }

    /* renamed from: dG */
    public static String m11688dG(Context context) {
        if (!TextUtils.isEmpty(bKP)) {
            return bKP;
        }
        if (!C9295b.m26985b(context, C8092b.dXu)) {
            C5523b.logException(new C5526d("No Sdcard Permission"));
        }
        bKP = m11687P(context, 2);
        return bKP;
    }

    /* renamed from: dH */
    private static String m11689dH(Context context) {
        return UUID.randomUUID().toString();
    }

    /* renamed from: dI */
    public static String m11690dI(Context context) {
        if (!TextUtils.isEmpty(bKO)) {
            return bKO;
        }
        bKO = m11687P(context, 1);
        return bKO;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:5|6|7|8|9|10|11) */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x004f, code lost:
        if (r1 == null) goto L_0x0068;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0065, code lost:
        if (r1 == null) goto L_0x0068;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002d */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x004a A[SYNTHETIC, Splitter:B:26:0x004a] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0060 A[SYNTHETIC, Splitter:B:38:0x0060] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x006e A[SYNTHETIC, Splitter:B:47:0x006e] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0075 A[SYNTHETIC, Splitter:B:51:0x0075] */
    /* renamed from: eI */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String m11691eI(java.lang.String r5) {
        /*
            r0 = 0
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ IOException -> 0x0055, ClassNotFoundException -> 0x0046, all -> 0x0041 }
            java.io.File r2 = new java.io.File     // Catch:{ IOException -> 0x0055, ClassNotFoundException -> 0x0046, all -> 0x0041 }
            r2.<init>(r5)     // Catch:{ IOException -> 0x0055, ClassNotFoundException -> 0x0046, all -> 0x0041 }
            r1.<init>(r2)     // Catch:{ IOException -> 0x0055, ClassNotFoundException -> 0x0046, all -> 0x0041 }
            java.io.ObjectInputStream r5 = new java.io.ObjectInputStream     // Catch:{ IOException -> 0x003c, ClassNotFoundException -> 0x003a, all -> 0x0035 }
            r5.<init>(r1)     // Catch:{ IOException -> 0x003c, ClassNotFoundException -> 0x003a, all -> 0x0035 }
            java.lang.Object r0 = r5.readObject()     // Catch:{ IOException -> 0x0033, ClassNotFoundException -> 0x0031 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ IOException -> 0x0033, ClassNotFoundException -> 0x0031 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0033, ClassNotFoundException -> 0x0031 }
            r2.<init>()     // Catch:{ IOException -> 0x0033, ClassNotFoundException -> 0x0031 }
            java.lang.String r3 = "deserializeTextState state="
            r2.append(r3)     // Catch:{ IOException -> 0x0033, ClassNotFoundException -> 0x0031 }
            r2.append(r0)     // Catch:{ IOException -> 0x0033, ClassNotFoundException -> 0x0031 }
            java.lang.String r2 = r2.toString()     // Catch:{ IOException -> 0x0033, ClassNotFoundException -> 0x0031 }
            com.introvd.template.common.LogUtilsV2.m14227d(r2)     // Catch:{ IOException -> 0x0033, ClassNotFoundException -> 0x0031 }
            r5.close()     // Catch:{ IOException -> 0x002d }
        L_0x002d:
            r1.close()     // Catch:{ IOException -> 0x0030 }
        L_0x0030:
            return r0
        L_0x0031:
            goto L_0x0048
        L_0x0033:
            r0 = move-exception
            goto L_0x0059
        L_0x0035:
            r5 = move-exception
            r4 = r0
            r0 = r5
            r5 = r4
            goto L_0x006c
        L_0x003a:
            r5 = r0
            goto L_0x0048
        L_0x003c:
            r5 = move-exception
            r4 = r0
            r0 = r5
            r5 = r4
            goto L_0x0059
        L_0x0041:
            r5 = move-exception
            r1 = r0
            r0 = r5
            r5 = r1
            goto L_0x006c
        L_0x0046:
            r5 = r0
            r1 = r5
        L_0x0048:
            if (r5 == 0) goto L_0x004f
            r5.close()     // Catch:{ IOException -> 0x004e }
            goto L_0x004f
        L_0x004e:
        L_0x004f:
            if (r1 == 0) goto L_0x0068
        L_0x0051:
            r1.close()     // Catch:{ IOException -> 0x0068 }
            goto L_0x0068
        L_0x0055:
            r5 = move-exception
            r1 = r0
            r0 = r5
            r5 = r1
        L_0x0059:
            java.lang.String r2 = ""
            com.introvd.template.common.LogUtilsV2.m14229e(r2, r0)     // Catch:{ all -> 0x006b }
            if (r5 == 0) goto L_0x0065
            r5.close()     // Catch:{ IOException -> 0x0064 }
            goto L_0x0065
        L_0x0064:
        L_0x0065:
            if (r1 == 0) goto L_0x0068
            goto L_0x0051
        L_0x0068:
            java.lang.String r5 = ""
            return r5
        L_0x006b:
            r0 = move-exception
        L_0x006c:
            if (r5 == 0) goto L_0x0073
            r5.close()     // Catch:{ IOException -> 0x0072 }
            goto L_0x0073
        L_0x0072:
        L_0x0073:
            if (r1 == 0) goto L_0x0078
            r1.close()     // Catch:{ IOException -> 0x0078 }
        L_0x0078:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.p203b.C4585f.m11691eI(java.lang.String):java.lang.String");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|(1:4)|5|6|7|8|9|10|11|12|13|41) */
    /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0024 */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0036 A[SYNTHETIC, Splitter:B:23:0x0036] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x003d A[SYNTHETIC, Splitter:B:27:0x003d] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0044 A[SYNTHETIC, Splitter:B:34:0x0044] */
    /* JADX WARNING: Removed duplicated region for block: B:40:? A[RETURN, SYNTHETIC] */
    /* renamed from: j */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void m11692j(java.lang.String r3, java.lang.String r4, java.lang.String r5) {
        /*
            java.io.File r0 = new java.io.File
            r0.<init>(r3)
            r1 = 0
            boolean r2 = r0.exists()     // Catch:{ IOException -> 0x0041, all -> 0x0032 }
            if (r2 != 0) goto L_0x000f
            r0.mkdir()     // Catch:{ IOException -> 0x0041, all -> 0x0032 }
        L_0x000f:
            java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0041, all -> 0x0032 }
            java.io.File r2 = new java.io.File     // Catch:{ IOException -> 0x0041, all -> 0x0032 }
            r2.<init>(r3, r4)     // Catch:{ IOException -> 0x0041, all -> 0x0032 }
            r0.<init>(r2)     // Catch:{ IOException -> 0x0041, all -> 0x0032 }
            java.io.ObjectOutputStream r3 = new java.io.ObjectOutputStream     // Catch:{ IOException -> 0x0030, all -> 0x002e }
            r3.<init>(r0)     // Catch:{ IOException -> 0x0030, all -> 0x002e }
            r3.writeObject(r5)     // Catch:{ IOException -> 0x002c, all -> 0x0028 }
            r3.close()     // Catch:{ IOException -> 0x0024 }
        L_0x0024:
            r0.close()     // Catch:{ IOException -> 0x004c }
            goto L_0x004c
        L_0x0028:
            r4 = move-exception
            r1 = r3
            r3 = r4
            goto L_0x0034
        L_0x002c:
            r1 = r3
            goto L_0x0042
        L_0x002e:
            r3 = move-exception
            goto L_0x0034
        L_0x0030:
            goto L_0x0042
        L_0x0032:
            r3 = move-exception
            r0 = r1
        L_0x0034:
            if (r1 == 0) goto L_0x003b
            r1.close()     // Catch:{ IOException -> 0x003a }
            goto L_0x003b
        L_0x003a:
        L_0x003b:
            if (r0 == 0) goto L_0x0040
            r0.close()     // Catch:{ IOException -> 0x0040 }
        L_0x0040:
            throw r3
        L_0x0041:
            r0 = r1
        L_0x0042:
            if (r1 == 0) goto L_0x0049
            r1.close()     // Catch:{ IOException -> 0x0048 }
            goto L_0x0049
        L_0x0048:
        L_0x0049:
            if (r0 == 0) goto L_0x004c
            goto L_0x0024
        L_0x004c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.p203b.C4585f.m11692j(java.lang.String, java.lang.String, java.lang.String):void");
    }
}
