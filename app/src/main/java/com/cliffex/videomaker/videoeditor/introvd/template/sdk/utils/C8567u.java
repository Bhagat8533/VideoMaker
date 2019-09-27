package com.introvd.template.sdk.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.introvd.template.sdk.utils.p393a.C8492c;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* renamed from: com.introvd.template.sdk.utils.u */
public class C8567u {
    private static String TAG = "u";
    private static C8492c cee = null;
    private static Object egV = new Object();
    private static boolean egW = false;
    public static String egX = "";
    public static String egY = "";
    public static String egZ = "";
    public static String eha = "";
    private static String ehb = "preload";
    private static boolean[] ehc = new boolean[32];
    public static Boolean ehd = Boolean.valueOf(true);
    private static String ehe = "XY_Library_Ver";
    private static String ehf = "";
    private static Context mContext = null;

    /* renamed from: com.introvd.template.sdk.utils.u$a */
    public static class C8568a {
        public static final String[] ehg = {"libcesplatform.so", "libpostprocess.so", "libcescommon.so", "libcesplatformutils.so", "libx264.so", "libffmpeg.so", "libasp.so", "libcesmediabase.so", "libcesliveeditor.so", "libcescamengine.so", "libcesrenderengine.so", "libArcSoftSpotlight.so", "libdtdetector.so", "", "", "", "libhwvideowriter.so", "libhwvideoreader.so", "", "", "", "", "", "", "", "", "", "", "", "", "", ""};
        public static int ehh = 16;
        public static int ehi = 17;

        /* renamed from: ot */
        public static int m25056ot(String str) {
            int i = -1;
            if (TextUtils.isEmpty(str)) {
                return -1;
            }
            int length = ehg.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                } else if (ehg[i2].equals(str)) {
                    i = i2;
                    break;
                } else {
                    i2++;
                }
            }
            return i;
        }
    }

    /* renamed from: a */
    public static void m25052a(C8492c cVar) {
        cee = cVar;
    }

    public static String aJj() {
        PackageInfo packageInfo;
        String packageName = mContext.getPackageName();
        try {
            packageInfo = mContext.getPackageManager().getPackageInfo(packageName, 0);
        } catch (Exception unused) {
            List installedPackages = mContext.getPackageManager().getInstalledPackages(0);
            if (installedPackages != null && installedPackages.size() > 0) {
                Iterator it = installedPackages.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    packageInfo = (PackageInfo) it.next();
                    if (packageInfo.packageName.equals(packageName)) {
                        break;
                    }
                }
            }
            packageInfo = null;
        }
        return packageInfo.applicationInfo.nativeLibraryDir;
    }

    public static void aJk() {
    }

    /* renamed from: os */
    public static synchronized boolean m25053os(String str) {
        synchronized (C8567u.class) {
            int ot = C8568a.m25056ot(str);
            if (ot == -1) {
                return false;
            }
            boolean ut = m25054ut(ot);
            return ut;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x010a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void setContext(android.content.Context r3) {
        /*
            if (r3 != 0) goto L_0x0003
            return
        L_0x0003:
            android.content.Context r0 = r3.getApplicationContext()
            android.content.Context r1 = mContext
            if (r1 == r0) goto L_0x0163
            mContext = r0
            r0 = 0
            android.content.Context r1 = mContext     // Catch:{ Throwable -> 0x001b }
            java.io.File r1 = r1.getCacheDir()     // Catch:{ Throwable -> 0x001b }
            if (r1 == 0) goto L_0x001b
            java.lang.String r1 = r1.getParent()     // Catch:{ Throwable -> 0x001b }
            r0 = r1
        L_0x001b:
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 == 0) goto L_0x0038
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "/data/data/"
            r0.append(r1)
            android.content.Context r1 = mContext
            java.lang.String r1 = r1.getPackageName()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
        L_0x0038:
            java.lang.String r1 = aJj()
            ehf = r1
            java.lang.String r1 = ehf
            java.lang.String r2 = "/"
            boolean r1 = r1.endsWith(r2)
            if (r1 != 0) goto L_0x005d
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = ehf
            r1.append(r2)
            java.lang.String r2 = "/"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            ehf = r1
        L_0x005d:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = "/so/"
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            egX = r0
            com.introvd.template.sdk.e r0 = com.introvd.template.sdk.C8410e.aGX()
            com.introvd.template.sdk.a r0 = r0.aGZ()
            java.lang.String r1 = ehe
            java.lang.String r2 = ""
            java.lang.String r0 = r0.getString(r1, r2)
            java.lang.String r3 = com.introvd.template.sdk.utils.C8570w.getAppVersion(r3)
            if (r3 == 0) goto L_0x008d
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x008d
            goto L_0x0094
        L_0x008d:
            java.lang.String r3 = egX     // Catch:{ Throwable -> 0x0093 }
            com.introvd.template.sdk.utils.C8548e.deleteDirectory(r3)     // Catch:{ Throwable -> 0x0093 }
            goto L_0x0094
        L_0x0093:
        L_0x0094:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r0 = ehf
            r3.append(r0)
            java.lang.String r0 = "libhwvideowriter.so"
            r3.append(r0)
            java.lang.String r3 = r3.toString()
            boolean r3 = com.introvd.template.sdk.utils.C8548e.isFileExisted(r3)
            if (r3 == 0) goto L_0x00dc
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r0 = egX
            r3.append(r0)
            java.lang.String r0 = "libhwvideowriter.so"
            r3.append(r0)
            java.lang.String r3 = r3.toString()
            boolean r3 = com.introvd.template.sdk.utils.C8548e.isFileExisted(r3)
            if (r3 != 0) goto L_0x00dc
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r0 = ehf
            r3.append(r0)
            java.lang.String r0 = "libhwvideowriter.so"
            r3.append(r0)
            java.lang.String r3 = r3.toString()
            egY = r3
            goto L_0x00f1
        L_0x00dc:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r0 = egX
            r3.append(r0)
            java.lang.String r0 = "libhwvideowriter.so"
            r3.append(r0)
            java.lang.String r3 = r3.toString()
            egY = r3
        L_0x00f1:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r0 = ehf
            r3.append(r0)
            java.lang.String r0 = "libhwvideoreader.so"
            r3.append(r0)
            java.lang.String r3 = r3.toString()
            boolean r3 = com.introvd.template.sdk.utils.C8548e.isFileExisted(r3)
            if (r3 == 0) goto L_0x0139
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r0 = egX
            r3.append(r0)
            java.lang.String r0 = "libhwvideoreader.so"
            r3.append(r0)
            java.lang.String r3 = r3.toString()
            boolean r3 = com.introvd.template.sdk.utils.C8548e.isFileExisted(r3)
            if (r3 != 0) goto L_0x0139
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r0 = ehf
            r3.append(r0)
            java.lang.String r0 = "libhwvideoreader.so"
            r3.append(r0)
            java.lang.String r3 = r3.toString()
            egZ = r3
            goto L_0x014e
        L_0x0139:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r0 = egX
            r3.append(r0)
            java.lang.String r0 = "libhwvideoreader.so"
            r3.append(r0)
            java.lang.String r3 = r3.toString()
            egZ = r3
        L_0x014e:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r0 = egX
            r3.append(r0)
            java.lang.String r0 = "pretask.ini"
            r3.append(r0)
            java.lang.String r3 = r3.toString()
            eha = r3
        L_0x0163:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.sdk.utils.C8567u.setContext(android.content.Context):void");
    }

    public static void setDebugMode(boolean z) {
        egW = z;
    }

    /* renamed from: ut */
    private static synchronized boolean m25054ut(int i) {
        synchronized (C8567u.class) {
            if (i == -1) {
                return false;
            }
            if (ehc[i]) {
                return true;
            }
            String str = C8568a.ehg[i];
            if (str.equals("")) {
                return false;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(egX);
            sb.append(str);
            String sb2 = sb.toString();
            if (!C8548e.isFileExisted(sb2)) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(ehf);
                sb3.append(str);
                sb2 = sb3.toString();
            }
            try {
                if (sb2.startsWith(ehf)) {
                    System.loadLibrary(str.replace("lib", "").replace(".so", ""));
                } else {
                    System.load(sb2);
                }
                ehc[i] = true;
            } catch (Throwable th) {
                C8554j.m25007e(TAG, th.getMessage());
                if (cee != null) {
                    cee.onError(th);
                }
                ehc[i] = false;
            }
            boolean z = ehc[i];
            return z;
        }
    }

    /* renamed from: uu */
    public static synchronized boolean m25055uu(int i) {
        synchronized (C8567u.class) {
            C8548e.createMultilevelDirectory(egX);
            if (!ehd.booleanValue()) {
                return true;
            }
            C8552h hVar = new C8552h();
            if (!hVar.mo34799oe(eha)) {
                return true;
            }
            for (int i2 = 0; i2 <= 31; i2++) {
                String format = String.format(Locale.US, "%s%02d", new Object[]{ehb, Integer.valueOf(i2)});
                String str = hVar.get(format);
                if (!str.equals("") && C8548e.isFileExisted(str)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(egX);
                    sb.append(C8568a.ehg[i2]);
                    String sb2 = sb.toString();
                    C8548e.deleteFile(sb2);
                    C8548e.copyFile(str, sb2);
                    C8548e.deleteFile(str);
                    hVar.set(format, null);
                }
            }
            hVar.mo34800of(eha);
            synchronized (egV) {
                ehd = Boolean.valueOf(false);
            }
            return true;
        }
    }
}
