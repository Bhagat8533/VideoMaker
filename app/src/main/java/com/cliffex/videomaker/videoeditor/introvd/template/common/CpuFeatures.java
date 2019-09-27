package com.introvd.template.common;

import android.text.TextUtils;
import java.io.File;
import java.io.FileFilter;
import java.util.HashMap;
import java.util.regex.Pattern;

public class CpuFeatures {
    public static int ANDROID_CPU_ARM_FEATURE_ARMv7 = 1;
    public static int ANDROID_CPU_ARM_FEATURE_NEON = 4;
    public static int ANDROID_CPU_ARM_FEATURE_VFPv3 = 2;
    public static final int[][][] CPU_STRINGS = {new int[][]{new int[]{65, 7, 0, 3077, 1}, new int[]{2}}, new int[][]{new int[]{65, 6, 1, 2870, 5}, new int[]{1}}, new int[][]{new int[]{81, 7, 0, 15, 2}, new int[]{3}}, new int[][]{new int[]{81, 7, 1, 15, 2}, new int[]{4}}, new int[][]{new int[]{81, 7, 1, 15, 1}, new int[]{3}}, new int[][]{new int[]{81, 7, 0, 45, 2}, new int[]{5}}, new int[][]{new int[]{81, 7, 0, 45, 4}, new int[]{5}}, new int[][]{new int[]{65, 7, 1, 3081, 2}, new int[]{7}}, new int[][]{new int[]{65, 7, 1, 3081, 3}, new int[]{7}}, new int[][]{new int[]{65, 7, 2, 3081, 10}, new int[]{7}}, new int[][]{new int[]{65, 7, 1, 3081, 0}, new int[]{6}}, new int[][]{new int[]{65, 7, 2, 3081, 9}, new int[]{10}}, new int[][]{new int[]{65, 7, 2, 3081, 1}, new int[]{9}}, new int[][]{new int[]{81, 7, 1, 77, 0}, new int[]{11}}, new int[][]{new int[]{65, 7, 3, 3081, 0}, new int[]{12}}, new int[][]{new int[]{65, 7, 2, 3080, 2}, new int[]{13}}};
    private static HashMap<String, String> ccj = null;

    /* renamed from: com.introvd.template.common.CpuFeatures$a */
    class C5207a implements FileFilter {
        C5207a() {
        }

        public boolean accept(File file) {
            return Pattern.matches("cpu[0-9]", file.getName());
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:24|(2:33|34)|(2:37|38)|39|40) */
    /* JADX WARNING: Can't wrap try/catch for region: R(9:5|6|(8:7|8|9|10|(3:11|12|(3:14|(2:18|62)|58)(1:59))|19|20|21)|22|23|48|49|(2:52|50)|63) */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0072, code lost:
        if (r1 == null) goto L_0x0075;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:22:0x0049 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x0068 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:48:0x0075 */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x005e A[SYNTHETIC, Splitter:B:33:0x005e] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0065 A[SYNTHETIC, Splitter:B:37:0x0065] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x006d A[SYNTHETIC, Splitter:B:44:0x006d] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0085 A[LOOP:1: B:50:0x007f->B:52:0x0085, LOOP_END] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:48:0x0075=Splitter:B:48:0x0075, B:39:0x0068=Splitter:B:39:0x0068} */
    /* renamed from: YW */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static synchronized void m14217YW() {
        /*
            java.lang.Class<com.introvd.template.common.CpuFeatures> r0 = com.introvd.template.common.CpuFeatures.class
            monitor-enter(r0)
            java.util.HashMap<java.lang.String, java.lang.String> r1 = ccj     // Catch:{ all -> 0x00b2 }
            if (r1 != 0) goto L_0x00b0
            java.util.HashMap r1 = new java.util.HashMap     // Catch:{ all -> 0x00b2 }
            r1.<init>()     // Catch:{ all -> 0x00b2 }
            ccj = r1     // Catch:{ all -> 0x00b2 }
            java.lang.String r1 = "/proc/cpuinfo"
            r2 = 0
            java.io.FileReader r3 = new java.io.FileReader     // Catch:{ IOException -> 0x0069, all -> 0x0058 }
            r3.<init>(r1)     // Catch:{ IOException -> 0x0069, all -> 0x0058 }
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ IOException -> 0x0056, all -> 0x0051 }
            r4 = 8192(0x2000, float:1.14794E-41)
            r1.<init>(r3, r4)     // Catch:{ IOException -> 0x0056, all -> 0x0051 }
        L_0x001d:
            java.lang.String r2 = r1.readLine()     // Catch:{ IOException -> 0x004f, all -> 0x004d }
            if (r2 == 0) goto L_0x0043
            java.lang.String r4 = ":"
            java.lang.String[] r2 = r2.split(r4)     // Catch:{ IOException -> 0x004f, all -> 0x004d }
            if (r2 == 0) goto L_0x001d
            int r4 = r2.length     // Catch:{ IOException -> 0x004f, all -> 0x004d }
            r5 = 2
            if (r4 != r5) goto L_0x001d
            java.util.HashMap<java.lang.String, java.lang.String> r4 = ccj     // Catch:{ IOException -> 0x004f, all -> 0x004d }
            r5 = 0
            r5 = r2[r5]     // Catch:{ IOException -> 0x004f, all -> 0x004d }
            java.lang.String r5 = r5.trim()     // Catch:{ IOException -> 0x004f, all -> 0x004d }
            r6 = 1
            r2 = r2[r6]     // Catch:{ IOException -> 0x004f, all -> 0x004d }
            java.lang.String r2 = r2.trim()     // Catch:{ IOException -> 0x004f, all -> 0x004d }
            r4.put(r5, r2)     // Catch:{ IOException -> 0x004f, all -> 0x004d }
            goto L_0x001d
        L_0x0043:
            r1.close()     // Catch:{ IOException -> 0x004f, all -> 0x004d }
            r3.close()     // Catch:{ IOException -> 0x0049 }
        L_0x0049:
            r1.close()     // Catch:{ IOException -> 0x0075 }
            goto L_0x0075
        L_0x004d:
            r2 = move-exception
            goto L_0x005c
        L_0x004f:
            goto L_0x006b
        L_0x0051:
            r1 = move-exception
            r7 = r2
            r2 = r1
            r1 = r7
            goto L_0x005c
        L_0x0056:
            r1 = r2
            goto L_0x006b
        L_0x0058:
            r1 = move-exception
            r3 = r2
            r2 = r1
            r1 = r3
        L_0x005c:
            if (r3 == 0) goto L_0x0063
            r3.close()     // Catch:{ IOException -> 0x0062 }
            goto L_0x0063
        L_0x0062:
        L_0x0063:
            if (r1 == 0) goto L_0x0068
            r1.close()     // Catch:{ IOException -> 0x0068 }
        L_0x0068:
            throw r2     // Catch:{ all -> 0x00b2 }
        L_0x0069:
            r1 = r2
            r3 = r1
        L_0x006b:
            if (r3 == 0) goto L_0x0072
            r3.close()     // Catch:{ IOException -> 0x0071 }
            goto L_0x0072
        L_0x0071:
        L_0x0072:
            if (r1 == 0) goto L_0x0075
            goto L_0x0049
        L_0x0075:
            java.util.HashMap<java.lang.String, java.lang.String> r1 = ccj     // Catch:{ all -> 0x00b2 }
            java.util.Set r1 = r1.keySet()     // Catch:{ all -> 0x00b2 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x00b2 }
        L_0x007f:
            boolean r2 = r1.hasNext()     // Catch:{ all -> 0x00b2 }
            if (r2 == 0) goto L_0x00b0
            java.lang.Object r2 = r1.next()     // Catch:{ all -> 0x00b2 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x00b2 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b2 }
            r3.<init>()     // Catch:{ all -> 0x00b2 }
            java.lang.String r4 = "cpu info: "
            r3.append(r4)     // Catch:{ all -> 0x00b2 }
            r3.append(r2)     // Catch:{ all -> 0x00b2 }
            java.lang.String r4 = "="
            r3.append(r4)     // Catch:{ all -> 0x00b2 }
            java.util.HashMap<java.lang.String, java.lang.String> r4 = ccj     // Catch:{ all -> 0x00b2 }
            java.lang.Object r2 = r4.get(r2)     // Catch:{ all -> 0x00b2 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x00b2 }
            r3.append(r2)     // Catch:{ all -> 0x00b2 }
            java.lang.String r2 = r3.toString()     // Catch:{ all -> 0x00b2 }
            com.introvd.template.common.LogUtilsV2.m14230i(r2)     // Catch:{ all -> 0x00b2 }
            goto L_0x007f
        L_0x00b0:
            monitor-exit(r0)
            return
        L_0x00b2:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.common.CpuFeatures.m14217YW():void");
    }

    public static String getCpuArch() {
        m14217YW();
        String str = (String) ccj.get("CPU architecture");
        StringBuilder sb = new StringBuilder();
        sb.append("getCpuArch strOriginal: ");
        sb.append(str);
        LogUtilsV2.m14230i(sb.toString());
        String str2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String replaceAll = str.replaceAll("[^0-9]", "");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("getCpuArch strFilter: ");
        sb2.append(replaceAll);
        LogUtilsV2.m14230i(sb2.toString());
        try {
            long longValue = Long.decode(replaceAll).longValue();
            StringBuilder sb3 = new StringBuilder();
            sb3.append("getCpuArch lcpuarch: ");
            sb3.append(longValue);
            LogUtilsV2.m14230i(sb3.toString());
            String valueOf = String.valueOf(longValue);
            try {
                StringBuilder sb4 = new StringBuilder();
                sb4.append("getCpuArch: ");
                sb4.append(valueOf);
                LogUtilsV2.m14230i(sb4.toString());
                return valueOf;
            } catch (Exception e) {
                e = e;
                str2 = valueOf;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("getCpuArch: error");
                sb5.append(e.getMessage());
                LogUtilsV2.m14228e(sb5.toString());
                return str2;
            }
        } catch (Exception e2) {
            e = e2;
            StringBuilder sb52 = new StringBuilder();
            sb52.append("getCpuArch: error");
            sb52.append(e.getMessage());
            LogUtilsV2.m14228e(sb52.toString());
            return str2;
        }
    }

    public static String getCpuFeatures() {
        m14217YW();
        String str = (String) ccj.get("Features");
        int i = 0;
        try {
            if (Integer.valueOf(getCpuArch()).intValue() >= 7) {
                i = 0 | ANDROID_CPU_ARM_FEATURE_ARMv7;
            }
            if (str != null && str.contains("vfpv3")) {
                i |= ANDROID_CPU_ARM_FEATURE_VFPv3;
            }
            if (str != null && str.contains("neon")) {
                i |= ANDROID_CPU_ARM_FEATURE_NEON;
            }
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("getCpuFeatures error:");
            sb.append(e.getMessage());
            LogUtilsV2.m14228e(sb.toString());
        }
        return String.valueOf(i);
    }

    public static String getCpuHardWare() {
        m14217YW();
        return (String) ccj.get("Hardware");
    }

    public static String getCpuImplementer() {
        m14217YW();
        return (String) ccj.get("CPU implementer");
    }

    public static int getCpuNumber() {
        try {
            File[] listFiles = new File("/sys/devices/system/cpu/").listFiles(new C5207a());
            if (listFiles != null) {
                return listFiles.length;
            }
            return 1;
        } catch (Exception e) {
            LogUtilsV2.m14228e("CPU Count: Failed.");
            e.printStackTrace();
            return 1;
        }
    }

    public static String getCpuPart() {
        m14217YW();
        return (String) ccj.get("CPU part");
    }

    public static String getCpuProcessorInfo() {
        m14217YW();
        return (String) ccj.get("Processor");
    }

    public static String getCpuRevision() {
        m14217YW();
        return (String) ccj.get("CPU revision");
    }

    public static String getCpuVariant() {
        m14217YW();
        return (String) ccj.get("CPU variant");
    }

    public static boolean isIntelCpu() {
        m14217YW();
        String str = (String) ccj.get("vendor_id");
        String str2 = (String) ccj.get("model name");
        return (!TextUtils.isEmpty(str) && str.contains("Intel")) || (!TextUtils.isEmpty(str2) && str2.contains("Intel"));
    }

    public static boolean isSingleCpu() {
        return getCpuNumber() <= 1;
    }
}
