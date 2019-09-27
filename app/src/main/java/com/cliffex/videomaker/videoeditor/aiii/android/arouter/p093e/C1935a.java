package com.aiii.android.arouter.p093e;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.util.Log;
import com.aiii.android.arouter.p091c.C1919a;
import com.aiii.android.arouter.p092d.C1931b;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

/* renamed from: com.aiii.android.arouter.e.a */
public class C1935a {
    private static final String atS;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append("code_cache");
        sb.append(File.separator);
        sb.append("secondary-dexes");
        atS = sb.toString();
    }

    /* renamed from: I */
    public static List<String> m5559I(Context context) throws NameNotFoundException, IOException {
        ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 0);
        File file = new File(applicationInfo.sourceDir);
        ArrayList arrayList = new ArrayList();
        arrayList.add(applicationInfo.sourceDir);
        StringBuilder sb = new StringBuilder();
        sb.append(file.getName());
        sb.append(".classes");
        String sb2 = sb.toString();
        if (!m5563sj()) {
            int i = m5561l(context).getInt("dex.number", 1);
            File file2 = new File(applicationInfo.dataDir, atS);
            int i2 = 2;
            while (i2 <= i) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(sb2);
                sb3.append(i2);
                sb3.append(".zip");
                File file3 = new File(file2, sb3.toString());
                if (file3.isFile()) {
                    arrayList.add(file3.getAbsolutePath());
                    i2++;
                } else {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("Missing extracted secondary dex file '");
                    sb4.append(file3.getPath());
                    sb4.append("'");
                    throw new IOException(sb4.toString());
                }
            }
        }
        if (C1919a.m5531se()) {
            arrayList.addAll(m5560a(applicationInfo));
        }
        return arrayList;
    }

    /* renamed from: a */
    private static List<String> m5560a(ApplicationInfo applicationInfo) {
        File[] listFiles;
        ArrayList arrayList = new ArrayList();
        if (VERSION.SDK_INT < 21 || applicationInfo.splitSourceDirs == null) {
            try {
                File file = new File((String) Class.forName("com.diii.tools.fd.runtime.Paths").getMethod("getDexFileDirectory", new Class[]{String.class}).invoke(null, new Object[]{applicationInfo.packageName}));
                if (file.exists() && file.isDirectory()) {
                    for (File file2 : file.listFiles()) {
                        if (file2 != null && file2.exists() && file2.isFile() && file2.getName().endsWith(".dex")) {
                            arrayList.add(file2.getAbsolutePath());
                        }
                    }
                    Log.d("ARouter::", "Found InstantRun support");
                }
            } catch (Exception e) {
                StringBuilder sb = new StringBuilder();
                sb.append("InstantRun support error, ");
                sb.append(e.getMessage());
                Log.e("ARouter::", sb.toString());
            }
        } else {
            arrayList.addAll(Arrays.asList(applicationInfo.splitSourceDirs));
            Log.d("ARouter::", "Found InstantRun support");
        }
        return arrayList;
    }

    /* renamed from: l */
    private static SharedPreferences m5561l(Context context) {
        return context.getSharedPreferences("multidex.version", VERSION.SDK_INT < 11 ? 0 : 4);
    }

    /* renamed from: m */
    public static Set<String> m5562m(Context context, final String str) throws NameNotFoundException, IOException, InterruptedException {
        final HashSet hashSet = new HashSet();
        List<String> I = m5559I(context);
        final CountDownLatch countDownLatch = new CountDownLatch(I.size());
        for (final String str2 : I) {
            C1931b.m5558si().execute(new Runnable() {
                /* JADX WARNING: Code restructure failed: missing block: B:12:0x004c, code lost:
                    if (r0 != null) goto L_0x005b;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:18:0x0059, code lost:
                    if (r0 == null) goto L_0x005e;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
                    r0.close();
                 */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void run() {
                    /*
                        r4 = this;
                        r0 = 0
                        java.lang.String r1 = r2     // Catch:{ Throwable -> 0x0051 }
                        java.lang.String r2 = ".zip"
                        boolean r1 = r1.endsWith(r2)     // Catch:{ Throwable -> 0x0051 }
                        if (r1 == 0) goto L_0x0026
                        java.lang.String r1 = r2     // Catch:{ Throwable -> 0x0051 }
                        java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0051 }
                        r2.<init>()     // Catch:{ Throwable -> 0x0051 }
                        java.lang.String r3 = r2     // Catch:{ Throwable -> 0x0051 }
                        r2.append(r3)     // Catch:{ Throwable -> 0x0051 }
                        java.lang.String r3 = ".tmp"
                        r2.append(r3)     // Catch:{ Throwable -> 0x0051 }
                        java.lang.String r2 = r2.toString()     // Catch:{ Throwable -> 0x0051 }
                        r3 = 0
                        dalvik.system.DexFile r1 = dalvik.system.DexFile.loadDex(r1, r2, r3)     // Catch:{ Throwable -> 0x0051 }
                        goto L_0x002d
                    L_0x0026:
                        dalvik.system.DexFile r1 = new dalvik.system.DexFile     // Catch:{ Throwable -> 0x0051 }
                        java.lang.String r2 = r2     // Catch:{ Throwable -> 0x0051 }
                        r1.<init>(r2)     // Catch:{ Throwable -> 0x0051 }
                    L_0x002d:
                        r0 = r1
                        java.util.Enumeration r1 = r0.entries()     // Catch:{ Throwable -> 0x0051 }
                    L_0x0032:
                        boolean r2 = r1.hasMoreElements()     // Catch:{ Throwable -> 0x0051 }
                        if (r2 == 0) goto L_0x004c
                        java.lang.Object r2 = r1.nextElement()     // Catch:{ Throwable -> 0x0051 }
                        java.lang.String r2 = (java.lang.String) r2     // Catch:{ Throwable -> 0x0051 }
                        java.lang.String r3 = r6     // Catch:{ Throwable -> 0x0051 }
                        boolean r3 = r2.startsWith(r3)     // Catch:{ Throwable -> 0x0051 }
                        if (r3 == 0) goto L_0x0032
                        java.util.Set r3 = r0     // Catch:{ Throwable -> 0x0051 }
                        r3.add(r2)     // Catch:{ Throwable -> 0x0051 }
                        goto L_0x0032
                    L_0x004c:
                        if (r0 == 0) goto L_0x005e
                        goto L_0x005b
                    L_0x004f:
                        r1 = move-exception
                        goto L_0x0064
                    L_0x0051:
                        r1 = move-exception
                        java.lang.String r2 = "ARouter"
                        java.lang.String r3 = "Scan map file in dex files made error."
                        android.util.Log.e(r2, r3, r1)     // Catch:{ all -> 0x004f }
                        if (r0 == 0) goto L_0x005e
                    L_0x005b:
                        r0.close()     // Catch:{ Throwable -> 0x005e }
                    L_0x005e:
                        java.util.concurrent.CountDownLatch r0 = r1
                        r0.countDown()
                        return
                    L_0x0064:
                        if (r0 == 0) goto L_0x0069
                        r0.close()     // Catch:{ Throwable -> 0x0069 }
                    L_0x0069:
                        java.util.concurrent.CountDownLatch r0 = r1
                        r0.countDown()
                        throw r1
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.aiii.android.arouter.p093e.C1935a.C19361.run():void");
                }
            });
        }
        countDownLatch.await();
        StringBuilder sb = new StringBuilder();
        sb.append("Filter ");
        sb.append(hashSet.size());
        sb.append(" classes by packageName <");
        sb.append(str);
        sb.append(">");
        Log.d("ARouter::", sb.toString());
        return hashSet;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x004e, code lost:
        if (r1 < 1) goto L_0x0052;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001b, code lost:
        if (java.lang.Integer.valueOf(java.lang.System.getProperty("ro.build.version.sdk")).intValue() >= 21) goto L_0x001d;
     */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0066  */
    /* renamed from: sj */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean m5563sj() {
        /*
            r0 = 0
            r1 = 0
            boolean r2 = m5564sk()     // Catch:{ Exception -> 0x0051 }
            r3 = 1
            if (r2 == 0) goto L_0x001f
            java.lang.String r2 = "'YunOS'"
            java.lang.String r1 = "ro.build.version.sdk"
            java.lang.String r1 = java.lang.System.getProperty(r1)     // Catch:{  }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{  }
            int r1 = r1.intValue()     // Catch:{  }
            r4 = 21
            if (r1 < r4) goto L_0x0052
        L_0x001d:
            r0 = 1
            goto L_0x0052
        L_0x001f:
            java.lang.String r2 = "'Android'"
            java.lang.String r1 = "java.vm.version"
            java.lang.String r1 = java.lang.System.getProperty(r1)     // Catch:{  }
            if (r1 == 0) goto L_0x0052
            java.lang.String r4 = "(\\d+)\\.(\\d+)(\\.\\d+)?"
            java.util.regex.Pattern r4 = java.util.regex.Pattern.compile(r4)     // Catch:{  }
            java.util.regex.Matcher r1 = r4.matcher(r1)     // Catch:{  }
            boolean r4 = r1.matches()     // Catch:{  }
            if (r4 == 0) goto L_0x0052
            java.lang.String r4 = r1.group(r3)     // Catch:{ Exception -> 0x0052 }
            int r4 = java.lang.Integer.parseInt(r4)     // Catch:{ Exception -> 0x0052 }
            r5 = 2
            java.lang.String r1 = r1.group(r5)     // Catch:{ Exception -> 0x0052 }
            int r1 = java.lang.Integer.parseInt(r1)     // Catch:{ Exception -> 0x0052 }
            if (r4 > r5) goto L_0x001d
            if (r4 != r5) goto L_0x0052
            if (r1 < r3) goto L_0x0052
            goto L_0x001d
        L_0x0051:
            r2 = r1
        L_0x0052:
            java.lang.String r1 = "ARouter::"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "VM with name "
            r3.append(r4)
            r3.append(r2)
            if (r0 == 0) goto L_0x0066
            java.lang.String r2 = " has multidex support"
            goto L_0x0068
        L_0x0066:
            java.lang.String r2 = " does not have multidex support"
        L_0x0068:
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            android.util.Log.i(r1, r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.aiii.android.arouter.p093e.C1935a.m5563sj():boolean");
    }

    /* renamed from: sk */
    private static boolean m5564sk() {
        boolean z = false;
        try {
            String property = System.getProperty("ro.yunos.version");
            String property2 = System.getProperty("java.vm.name");
            if ((property2 != null && property2.toLowerCase().contains("lemur")) || (property != null && property.trim().length() > 0)) {
                z = true;
            }
            return z;
        } catch (Exception unused) {
            return false;
        }
    }
}
