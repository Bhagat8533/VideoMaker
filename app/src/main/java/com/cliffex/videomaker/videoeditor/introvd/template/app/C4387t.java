package com.introvd.template.app;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.multidex.C0513a;
import android.text.TextUtils;
import android.util.Log;
import com.introvd.template.C4676f;
import com.introvd.template.app.activity.LoadResActivity;
import com.introvd.template.p203b.C4582c;

/* renamed from: com.introvd.template.app.t */
public class C4387t {
    private String flag;

    /* renamed from: bG */
    static boolean m11046bG(Context context) {
        String bq = C4676f.m12173bq(context);
        StringBuilder sb = new StringBuilder();
        sb.append(":isMiniProcess curProcessName=");
        sb.append(bq);
        Log.d("loadDex", sb.toString());
        if (TextUtils.isEmpty(bq) || !bq.contains(":mini")) {
            Log.d("loadDex", ":isMiniProcess false!");
            return false;
        }
        Log.d("loadDex", ":mini start!  true");
        return true;
    }

    /* renamed from: bH */
    private boolean m11047bH(Context context) {
        if (this.flag == null) {
            this.flag = m11048bI(context);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("dex2-sha1 ");
        sb.append(this.flag);
        Log.d("loadDex", sb.toString());
        String string = context.getSharedPreferences(C4582c.m11667dD(context), 4).getString("KEY_DEX2_SHA1", "");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("saveValue= ");
        sb2.append(string);
        Log.d("loadDex", sb2.toString());
        return !TextUtils.equals(this.flag, string);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0037 A[SYNTHETIC, Splitter:B:18:0x0037] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0043 A[SYNTHETIC, Splitter:B:25:0x0043] */
    /* renamed from: bI */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String m11048bI(android.content.Context r3) {
        /*
            android.content.pm.ApplicationInfo r3 = r3.getApplicationInfo()
            java.lang.String r3 = r3.sourceDir
            r0 = 0
            java.util.jar.JarFile r1 = new java.util.jar.JarFile     // Catch:{ Exception -> 0x0030, all -> 0x002d }
            r1.<init>(r3)     // Catch:{ Exception -> 0x0030, all -> 0x002d }
            java.util.jar.Manifest r3 = r1.getManifest()     // Catch:{ Exception -> 0x002b }
            java.util.Map r3 = r3.getEntries()     // Catch:{ Exception -> 0x002b }
            java.lang.String r2 = "classes2.dex"
            java.lang.Object r3 = r3.get(r2)     // Catch:{ Exception -> 0x002b }
            java.util.jar.Attributes r3 = (java.util.jar.Attributes) r3     // Catch:{ Exception -> 0x002b }
            java.lang.String r2 = "SHA1-Digest"
            java.lang.String r3 = r3.getValue(r2)     // Catch:{ Exception -> 0x002b }
            r1.close()     // Catch:{ IOException -> 0x0026 }
            goto L_0x002a
        L_0x0026:
            r0 = move-exception
            r0.printStackTrace()
        L_0x002a:
            return r3
        L_0x002b:
            r3 = move-exception
            goto L_0x0032
        L_0x002d:
            r3 = move-exception
            r1 = r0
            goto L_0x0041
        L_0x0030:
            r3 = move-exception
            r1 = r0
        L_0x0032:
            r3.printStackTrace()     // Catch:{ all -> 0x0040 }
            if (r1 == 0) goto L_0x003f
            r1.close()     // Catch:{ IOException -> 0x003b }
            goto L_0x003f
        L_0x003b:
            r3 = move-exception
            r3.printStackTrace()
        L_0x003f:
            return r0
        L_0x0040:
            r3 = move-exception
        L_0x0041:
            if (r1 == 0) goto L_0x004b
            r1.close()     // Catch:{ IOException -> 0x0047 }
            goto L_0x004b
        L_0x0047:
            r0 = move-exception
            r0.printStackTrace()
        L_0x004b:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.app.C4387t.m11048bI(android.content.Context):java.lang.String");
    }

    /* renamed from: bJ */
    public static void m11049bJ(Context context) {
        context.getSharedPreferences(C4582c.m11667dD(context), 4).edit().putString("KEY_DEX2_SHA1", m11048bI(context)).commit();
    }

    /* renamed from: bK */
    private void m11050bK(Context context) {
        if (context != null) {
            String bq = C4676f.m12173bq(context);
            String packageName = context.getPackageName();
            if (TextUtils.equals(packageName, bq)) {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName(packageName, LoadResActivity.class.getName()));
                intent.addFlags(268435456);
                context.startActivity(intent);
            }
            long currentTimeMillis = System.currentTimeMillis();
            while (m11047bH(context)) {
                try {
                    long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                    StringBuilder sb = new StringBuilder();
                    sb.append("wait ms :");
                    sb.append(currentTimeMillis2);
                    Log.d("loadDex", sb.toString());
                    if (currentTimeMillis2 < 20000) {
                        Thread.sleep(200);
                    } else {
                        return;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void attachBaseContext(Context context) {
        Log.d("loadDex", "App attachBaseContext ");
        if (m11047bH(context)) {
            m11050bK(context);
        }
        Log.d("loadDex", "App install ");
        C0513a.m1814i(context);
    }
}
