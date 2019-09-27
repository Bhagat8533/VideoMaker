package com.introvd.template.sdk.utils;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Environment;
import android.text.TextUtils;
import com.introvd.template.sdk.C8410e;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.Locale;
import xiaoying.utils.QStreamAssets;

/* renamed from: com.introvd.template.sdk.utils.e */
public class C8548e {
    public static final BigInteger ONE_EB_BI = ONE_KB_BI.multiply(ONE_PB_BI);
    public static final BigInteger ONE_GB_BI = ONE_KB_BI.multiply(ONE_MB_BI);
    public static final BigInteger ONE_KB_BI = BigInteger.valueOf(1024);
    public static final BigInteger ONE_MB_BI = ONE_KB_BI.multiply(ONE_KB_BI);
    public static final BigInteger ONE_PB_BI = ONE_KB_BI.multiply(ONE_TB_BI);
    public static final BigInteger ONE_TB_BI = ONE_KB_BI.multiply(ONE_GB_BI);

    /* renamed from: a */
    public static String m24994a(BigInteger bigInteger) {
        if (bigInteger.divide(ONE_EB_BI).compareTo(BigInteger.ZERO) > 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(String.valueOf(bigInteger.divide(ONE_EB_BI)));
            sb.append(" EB");
            return sb.toString();
        } else if (bigInteger.divide(ONE_PB_BI).compareTo(BigInteger.ZERO) > 0) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(String.valueOf(bigInteger.divide(ONE_PB_BI)));
            sb2.append(" PB");
            return sb2.toString();
        } else if (bigInteger.divide(ONE_TB_BI).compareTo(BigInteger.ZERO) > 0) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(String.valueOf(bigInteger.divide(ONE_TB_BI)));
            sb3.append(" TB");
            return sb3.toString();
        } else if (bigInteger.divide(ONE_GB_BI).compareTo(BigInteger.ZERO) > 0) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append(String.valueOf(bigInteger.divide(ONE_GB_BI)));
            sb4.append(" GB");
            return sb4.toString();
        } else if (bigInteger.divide(ONE_MB_BI).compareTo(BigInteger.ZERO) > 0) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(String.valueOf(bigInteger.divide(ONE_MB_BI)));
            sb5.append(" MB");
            return sb5.toString();
        } else if (bigInteger.divide(ONE_KB_BI).compareTo(BigInteger.ZERO) > 0) {
            StringBuilder sb6 = new StringBuilder();
            sb6.append(String.valueOf(bigInteger.divide(ONE_KB_BI)));
            sb6.append(" KB");
            return sb6.toString();
        } else {
            StringBuilder sb7 = new StringBuilder();
            sb7.append(String.valueOf(bigInteger));
            sb7.append(" bytes");
            return sb7.toString();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x005f A[SYNTHETIC, Splitter:B:43:0x005f] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0069 A[SYNTHETIC, Splitter:B:49:0x0069] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0075 A[SYNTHETIC, Splitter:B:56:0x0075] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:46:0x0064=Splitter:B:46:0x0064, B:40:0x005a=Splitter:B:40:0x005a} */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean m24995a(java.io.InputStream r7, java.io.File r8) {
        /*
            r0 = 0
            int r1 = r7.available()     // Catch:{ IOException -> 0x007e }
            long r1 = (long) r1     // Catch:{ IOException -> 0x007e }
            long r3 = r8.length()     // Catch:{ IOException -> 0x007e }
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 == 0) goto L_0x000f
            return r0
        L_0x000f:
            r1 = 128(0x80, float:1.794E-43)
            byte[] r2 = new byte[r1]
            byte[] r1 = new byte[r1]
            r3 = 0
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x0063, IOException -> 0x0059 }
            r4.<init>(r8)     // Catch:{ FileNotFoundException -> 0x0063, IOException -> 0x0059 }
            int r8 = r4.read(r1)     // Catch:{ FileNotFoundException -> 0x0054, IOException -> 0x0051, all -> 0x004e }
            long r5 = (long) r8     // Catch:{ FileNotFoundException -> 0x0054, IOException -> 0x0051, all -> 0x004e }
            int r7 = r7.read(r2)     // Catch:{ FileNotFoundException -> 0x0054, IOException -> 0x0051, all -> 0x004e }
            long r7 = (long) r7
            int r3 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r3 == 0) goto L_0x0032
            r4.close()     // Catch:{ IOException -> 0x002d }
            goto L_0x0031
        L_0x002d:
            r7 = move-exception
            r7.printStackTrace()
        L_0x0031:
            return r0
        L_0x0032:
            r3 = 0
        L_0x0033:
            long r5 = (long) r3
            int r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r5 >= 0) goto L_0x004a
            byte r5 = r1[r3]     // Catch:{ FileNotFoundException -> 0x0054, IOException -> 0x0051, all -> 0x004e }
            byte r6 = r2[r3]     // Catch:{ FileNotFoundException -> 0x0054, IOException -> 0x0051, all -> 0x004e }
            if (r5 == r6) goto L_0x0047
            r4.close()     // Catch:{ IOException -> 0x0042 }
            goto L_0x0046
        L_0x0042:
            r7 = move-exception
            r7.printStackTrace()
        L_0x0046:
            return r0
        L_0x0047:
            int r3 = r3 + 1
            goto L_0x0033
        L_0x004a:
            r4.close()     // Catch:{ IOException -> 0x006d }
            goto L_0x0071
        L_0x004e:
            r7 = move-exception
            r3 = r4
            goto L_0x0073
        L_0x0051:
            r7 = move-exception
            r3 = r4
            goto L_0x005a
        L_0x0054:
            r7 = move-exception
            r3 = r4
            goto L_0x0064
        L_0x0057:
            r7 = move-exception
            goto L_0x0073
        L_0x0059:
            r7 = move-exception
        L_0x005a:
            r7.printStackTrace()     // Catch:{ all -> 0x0057 }
            if (r3 == 0) goto L_0x0071
            r3.close()     // Catch:{ IOException -> 0x006d }
            goto L_0x0071
        L_0x0063:
            r7 = move-exception
        L_0x0064:
            r7.printStackTrace()     // Catch:{ all -> 0x0057 }
            if (r3 == 0) goto L_0x0071
            r3.close()     // Catch:{ IOException -> 0x006d }
            goto L_0x0071
        L_0x006d:
            r7 = move-exception
            r7.printStackTrace()
        L_0x0071:
            r7 = 1
            return r7
        L_0x0073:
            if (r3 == 0) goto L_0x007d
            r3.close()     // Catch:{ IOException -> 0x0079 }
            goto L_0x007d
        L_0x0079:
            r8 = move-exception
            r8.printStackTrace()
        L_0x007d:
            throw r7
        L_0x007e:
            r7 = move-exception
            r7.printStackTrace()
            java.lang.String r8 = "FileUtils"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = ">>>>>>>>>>>>>>>> "
            r1.append(r2)
            java.lang.String r7 = r7.getMessage()
            r1.append(r7)
            java.lang.String r7 = r1.toString()
            com.introvd.template.sdk.utils.C8554j.m25007e(r8, r7)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.sdk.utils.C8548e.m24995a(java.io.InputStream, java.io.File):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:67:0x00a3 A[SYNTHETIC, Splitter:B:67:0x00a3] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x00ad A[SYNTHETIC, Splitter:B:72:0x00ad] */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00ba A[SYNTHETIC, Splitter:B:79:0x00ba] */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x00c4 A[SYNTHETIC, Splitter:B:84:0x00c4] */
    /* renamed from: aT */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean m24996aT(java.lang.String r9, java.lang.String r10) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r9)
            r1 = 0
            if (r0 != 0) goto L_0x00cd
            boolean r0 = android.text.TextUtils.isEmpty(r10)
            if (r0 != 0) goto L_0x00cd
            java.io.File r0 = new java.io.File
            r0.<init>(r9)
            java.io.File r9 = new java.io.File
            r9.<init>(r10)
            boolean r10 = r0.exists()
            r2 = 1
            if (r10 == 0) goto L_0x0025
            boolean r10 = r9.exists()
            if (r10 != 0) goto L_0x0025
            return r2
        L_0x0025:
            boolean r10 = r0.exists()
            if (r10 != 0) goto L_0x002c
            return r1
        L_0x002c:
            r10 = 0
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ Exception -> 0x009c, all -> 0x0098 }
            r3.<init>(r0)     // Catch:{ Exception -> 0x009c, all -> 0x0098 }
            java.io.FileInputStream r0 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0094, all -> 0x0091 }
            r0.<init>(r9)     // Catch:{ Exception -> 0x0094, all -> 0x0091 }
            int r9 = r3.available()     // Catch:{ Exception -> 0x008f, all -> 0x008d }
            int r10 = r0.available()     // Catch:{ Exception -> 0x008f, all -> 0x008d }
            if (r9 <= 0) goto L_0x0081
            if (r9 != r10) goto L_0x0081
            r9 = 128(0x80, float:1.794E-43)
            byte[] r10 = new byte[r9]     // Catch:{ Exception -> 0x008f, all -> 0x008d }
            byte[] r4 = new byte[r9]     // Catch:{ Exception -> 0x008f, all -> 0x008d }
        L_0x0049:
            int r5 = r3.read(r10)     // Catch:{ Exception -> 0x008f, all -> 0x008d }
            r0.read(r4)     // Catch:{ Exception -> 0x008f, all -> 0x008d }
            r6 = 0
        L_0x0051:
            if (r6 >= r9) goto L_0x006d
            byte r7 = r10[r6]     // Catch:{ Exception -> 0x008f, all -> 0x008d }
            byte r8 = r4[r6]     // Catch:{ Exception -> 0x008f, all -> 0x008d }
            if (r7 == r8) goto L_0x006a
            r3.close()     // Catch:{ IOException -> 0x005d }
            goto L_0x0061
        L_0x005d:
            r9 = move-exception
            r9.printStackTrace()
        L_0x0061:
            r0.close()     // Catch:{ IOException -> 0x0065 }
            goto L_0x0069
        L_0x0065:
            r9 = move-exception
            r9.printStackTrace()
        L_0x0069:
            return r1
        L_0x006a:
            int r6 = r6 + 1
            goto L_0x0051
        L_0x006d:
            r6 = -1
            if (r5 != r6) goto L_0x0049
            r3.close()     // Catch:{ IOException -> 0x0074 }
            goto L_0x0078
        L_0x0074:
            r9 = move-exception
            r9.printStackTrace()
        L_0x0078:
            r0.close()     // Catch:{ IOException -> 0x007c }
            goto L_0x0080
        L_0x007c:
            r9 = move-exception
            r9.printStackTrace()
        L_0x0080:
            return r2
        L_0x0081:
            r3.close()     // Catch:{ IOException -> 0x0085 }
            goto L_0x0089
        L_0x0085:
            r9 = move-exception
            r9.printStackTrace()
        L_0x0089:
            r0.close()     // Catch:{ IOException -> 0x00b1 }
            goto L_0x00cd
        L_0x008d:
            r9 = move-exception
            goto L_0x00b8
        L_0x008f:
            r9 = move-exception
            goto L_0x0096
        L_0x0091:
            r9 = move-exception
            r0 = r10
            goto L_0x00b8
        L_0x0094:
            r9 = move-exception
            r0 = r10
        L_0x0096:
            r10 = r3
            goto L_0x009e
        L_0x0098:
            r9 = move-exception
            r0 = r10
            r3 = r0
            goto L_0x00b8
        L_0x009c:
            r9 = move-exception
            r0 = r10
        L_0x009e:
            r9.printStackTrace()     // Catch:{ all -> 0x00b6 }
            if (r10 == 0) goto L_0x00ab
            r10.close()     // Catch:{ IOException -> 0x00a7 }
            goto L_0x00ab
        L_0x00a7:
            r9 = move-exception
            r9.printStackTrace()
        L_0x00ab:
            if (r0 == 0) goto L_0x00cd
            r0.close()     // Catch:{ IOException -> 0x00b1 }
            goto L_0x00cd
        L_0x00b1:
            r9 = move-exception
            r9.printStackTrace()
            goto L_0x00cd
        L_0x00b6:
            r9 = move-exception
            r3 = r10
        L_0x00b8:
            if (r3 == 0) goto L_0x00c2
            r3.close()     // Catch:{ IOException -> 0x00be }
            goto L_0x00c2
        L_0x00be:
            r10 = move-exception
            r10.printStackTrace()
        L_0x00c2:
            if (r0 == 0) goto L_0x00cc
            r0.close()     // Catch:{ IOException -> 0x00c8 }
            goto L_0x00cc
        L_0x00c8:
            r10 = move-exception
            r10.printStackTrace()
        L_0x00cc:
            throw r9
        L_0x00cd:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.sdk.utils.C8548e.m24996aT(java.lang.String, java.lang.String):boolean");
    }

    /* renamed from: bo */
    public static String m24997bo(long j) {
        return m24994a(BigInteger.valueOf(j));
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x0066 A[SYNTHETIC, Splitter:B:43:0x0066] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0070 A[SYNTHETIC, Splitter:B:48:0x0070] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x007c A[SYNTHETIC, Splitter:B:55:0x007c] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0086 A[SYNTHETIC, Splitter:B:60:0x0086] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean copyFile(java.lang.String r4, java.lang.String r5) {
        /*
            r0 = 0
            if (r4 == 0) goto L_0x008f
            if (r5 == 0) goto L_0x008f
            boolean r1 = r4.equals(r5)
            if (r1 == 0) goto L_0x000d
            goto L_0x008f
        L_0x000d:
            java.io.File r1 = new java.io.File
            r1.<init>(r4)
            boolean r4 = r1.exists()
            if (r4 != 0) goto L_0x0019
            return r0
        L_0x0019:
            boolean r4 = r1.isFile()
            if (r4 != 0) goto L_0x0020
            return r0
        L_0x0020:
            java.io.File r4 = new java.io.File
            r4.<init>(r5)
            r5 = 4096(0x1000, float:5.74E-42)
            byte[] r5 = new byte[r5]
            r2 = 0
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ Exception -> 0x005f, all -> 0x005c }
            r3.<init>(r1)     // Catch:{ Exception -> 0x005f, all -> 0x005c }
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x005a }
            r1.<init>(r4)     // Catch:{ Exception -> 0x005a }
        L_0x0034:
            int r4 = r3.read(r5)     // Catch:{ Exception -> 0x0057, all -> 0x0054 }
            r2 = -1
            if (r4 == r2) goto L_0x003f
            r1.write(r5, r0, r4)     // Catch:{ Exception -> 0x0057, all -> 0x0054 }
            goto L_0x0034
        L_0x003f:
            r1.flush()     // Catch:{ Exception -> 0x0057, all -> 0x0054 }
            r4 = 1
            r1.close()     // Catch:{ IOException -> 0x0047 }
            goto L_0x004b
        L_0x0047:
            r5 = move-exception
            r5.printStackTrace()
        L_0x004b:
            r3.close()     // Catch:{ IOException -> 0x004f }
            goto L_0x0053
        L_0x004f:
            r5 = move-exception
            r5.printStackTrace()
        L_0x0053:
            return r4
        L_0x0054:
            r4 = move-exception
            r2 = r1
            goto L_0x007a
        L_0x0057:
            r4 = move-exception
            r2 = r1
            goto L_0x0061
        L_0x005a:
            r4 = move-exception
            goto L_0x0061
        L_0x005c:
            r4 = move-exception
            r3 = r2
            goto L_0x007a
        L_0x005f:
            r4 = move-exception
            r3 = r2
        L_0x0061:
            r4.printStackTrace()     // Catch:{ all -> 0x0079 }
            if (r2 == 0) goto L_0x006e
            r2.close()     // Catch:{ IOException -> 0x006a }
            goto L_0x006e
        L_0x006a:
            r4 = move-exception
            r4.printStackTrace()
        L_0x006e:
            if (r3 == 0) goto L_0x0078
            r3.close()     // Catch:{ IOException -> 0x0074 }
            goto L_0x0078
        L_0x0074:
            r4 = move-exception
            r4.printStackTrace()
        L_0x0078:
            return r0
        L_0x0079:
            r4 = move-exception
        L_0x007a:
            if (r2 == 0) goto L_0x0084
            r2.close()     // Catch:{ IOException -> 0x0080 }
            goto L_0x0084
        L_0x0080:
            r5 = move-exception
            r5.printStackTrace()
        L_0x0084:
            if (r3 == 0) goto L_0x008e
            r3.close()     // Catch:{ IOException -> 0x008a }
            goto L_0x008e
        L_0x008a:
            r5 = move-exception
            r5.printStackTrace()
        L_0x008e:
            throw r4
        L_0x008f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.sdk.utils.C8548e.copyFile(java.lang.String, java.lang.String):boolean");
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:47:0x0083 */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x00d5 A[SYNTHETIC, Splitter:B:102:0x00d5] */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x00e4 A[SYNTHETIC, Splitter:B:111:0x00e4] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0092 A[SYNTHETIC, Splitter:B:56:0x0092] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00ad A[SYNTHETIC, Splitter:B:77:0x00ad] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x00b5 A[SYNTHETIC, Splitter:B:81:0x00b5] */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x00c4 A[SYNTHETIC, Splitter:B:90:0x00c4] */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x00cd A[SYNTHETIC, Splitter:B:98:0x00cd] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean copyFileFromAssets(java.lang.String r5, java.lang.String r6, android.content.res.AssetManager r7) {
        /*
            r0 = 0
            if (r7 == 0) goto L_0x00e8
            boolean r1 = android.text.TextUtils.isEmpty(r5)
            if (r1 != 0) goto L_0x00e8
            boolean r1 = android.text.TextUtils.isEmpty(r6)
            if (r1 == 0) goto L_0x0011
            goto L_0x00e8
        L_0x0011:
            java.lang.String r1 = getFileParentPath(r6)
            java.io.File r2 = new java.io.File
            r2.<init>(r1)
            boolean r3 = r2.exists()
            if (r3 == 0) goto L_0x0026
            boolean r2 = r2.isDirectory()
            if (r2 != 0) goto L_0x0029
        L_0x0026:
            createMultilevelDirectory(r1)
        L_0x0029:
            r1 = 0
            java.io.InputStream r5 = r7.open(r5)     // Catch:{ Exception -> 0x00c8, all -> 0x00a7 }
            boolean r7 = r5.markSupported()     // Catch:{ Exception -> 0x00a4, all -> 0x00a0 }
            if (r7 != 0) goto L_0x0041
            java.io.BufferedInputStream r7 = new java.io.BufferedInputStream     // Catch:{ Exception -> 0x00a4, all -> 0x00a0 }
            r2 = 16384(0x4000, float:2.2959E-41)
            r7.<init>(r5, r2)     // Catch:{ Exception -> 0x00a4, all -> 0x00a0 }
            r2 = 1024(0x400, float:1.435E-42)
            r7.mark(r2)     // Catch:{ Exception -> 0x00a5, all -> 0x009e }
            goto L_0x0042
        L_0x0041:
            r7 = r5
        L_0x0042:
            java.io.File r2 = new java.io.File     // Catch:{ Exception -> 0x00a5, all -> 0x009e }
            r2.<init>(r6)     // Catch:{ Exception -> 0x00a5, all -> 0x009e }
            boolean r3 = r2.exists()     // Catch:{ Exception -> 0x00a5, all -> 0x009e }
            if (r3 == 0) goto L_0x0060
            boolean r2 = m24995a(r7, r2)     // Catch:{ Exception -> 0x00a5, all -> 0x009e }
            if (r2 == 0) goto L_0x0060
            if (r7 == 0) goto L_0x005a
            if (r7 == r5) goto L_0x005a
            r7.close()     // Catch:{ Throwable -> 0x005a }
        L_0x005a:
            if (r5 == 0) goto L_0x005f
            r5.close()     // Catch:{ Throwable -> 0x005f }
        L_0x005f:
            return r0
        L_0x0060:
            r7.reset()     // Catch:{ Exception -> 0x00a5, all -> 0x009e }
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x00a5, all -> 0x009e }
            r2.<init>(r6)     // Catch:{ Exception -> 0x00a5, all -> 0x009e }
            r6 = 2048(0x800, float:2.87E-42)
            byte[] r6 = new byte[r6]     // Catch:{ Exception -> 0x00cb, all -> 0x009c }
            java.io.BufferedOutputStream r3 = new java.io.BufferedOutputStream     // Catch:{ Exception -> 0x00cb, all -> 0x009c }
            int r4 = r6.length     // Catch:{ Exception -> 0x00cb, all -> 0x009c }
            r3.<init>(r2, r4)     // Catch:{ Exception -> 0x00cb, all -> 0x009c }
        L_0x0072:
            int r1 = r7.read(r6)     // Catch:{ Exception -> 0x009a, all -> 0x0097 }
            r4 = -1
            if (r1 == r4) goto L_0x007d
            r3.write(r6, r0, r1)     // Catch:{ Exception -> 0x009a, all -> 0x0097 }
            goto L_0x0072
        L_0x007d:
            r3.flush()     // Catch:{ Throwable -> 0x0083 }
            r3.close()     // Catch:{ Throwable -> 0x0083 }
        L_0x0083:
            r2.flush()     // Catch:{ Throwable -> 0x0089 }
            r2.close()     // Catch:{ Throwable -> 0x0089 }
        L_0x0089:
            if (r7 == 0) goto L_0x0090
            if (r7 == r5) goto L_0x0090
            r7.close()     // Catch:{ Throwable -> 0x0090 }
        L_0x0090:
            if (r5 == 0) goto L_0x0095
            r5.close()     // Catch:{ Throwable -> 0x0095 }
        L_0x0095:
            r5 = 1
            return r5
        L_0x0097:
            r6 = move-exception
            r1 = r3
            goto L_0x00ab
        L_0x009a:
            r1 = r3
            goto L_0x00cb
        L_0x009c:
            r6 = move-exception
            goto L_0x00ab
        L_0x009e:
            r6 = move-exception
            goto L_0x00a2
        L_0x00a0:
            r6 = move-exception
            r7 = r5
        L_0x00a2:
            r2 = r1
            goto L_0x00ab
        L_0x00a4:
            r7 = r5
        L_0x00a5:
            r2 = r1
            goto L_0x00cb
        L_0x00a7:
            r6 = move-exception
            r5 = r1
            r7 = r5
            r2 = r7
        L_0x00ab:
            if (r1 == 0) goto L_0x00b3
            r1.flush()     // Catch:{ Throwable -> 0x00b3 }
            r1.close()     // Catch:{ Throwable -> 0x00b3 }
        L_0x00b3:
            if (r2 == 0) goto L_0x00bb
            r2.flush()     // Catch:{ Throwable -> 0x00bb }
            r2.close()     // Catch:{ Throwable -> 0x00bb }
        L_0x00bb:
            if (r7 == 0) goto L_0x00c2
            if (r7 == r5) goto L_0x00c2
            r7.close()     // Catch:{ Throwable -> 0x00c2 }
        L_0x00c2:
            if (r5 == 0) goto L_0x00c7
            r5.close()     // Catch:{ Throwable -> 0x00c7 }
        L_0x00c7:
            throw r6
        L_0x00c8:
            r5 = r1
            r7 = r5
            r2 = r7
        L_0x00cb:
            if (r1 == 0) goto L_0x00d3
            r1.flush()     // Catch:{ Throwable -> 0x00d3 }
            r1.close()     // Catch:{ Throwable -> 0x00d3 }
        L_0x00d3:
            if (r2 == 0) goto L_0x00db
            r2.flush()     // Catch:{ Throwable -> 0x00db }
            r2.close()     // Catch:{ Throwable -> 0x00db }
        L_0x00db:
            if (r7 == 0) goto L_0x00e2
            if (r7 == r5) goto L_0x00e2
            r7.close()     // Catch:{ Throwable -> 0x00e2 }
        L_0x00e2:
            if (r5 == 0) goto L_0x00e7
            r5.close()     // Catch:{ Throwable -> 0x00e7 }
        L_0x00e7:
            return r0
        L_0x00e8:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.sdk.utils.C8548e.copyFileFromAssets(java.lang.String, java.lang.String, android.content.res.AssetManager):boolean");
    }

    public static boolean createMultilevelDirectory(String str) {
        boolean z = false;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            return true;
        }
        file.mkdirs();
        File file2 = new File(str);
        if (file2.exists() && file2.isDirectory()) {
            z = true;
        }
        return z;
    }

    public static boolean deleteDirectory(String str) {
        if (!str.endsWith(File.separator)) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(File.separator);
            str = sb.toString();
        }
        File file = new File(str);
        if (!file.exists() || !file.isDirectory()) {
            return false;
        }
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return true;
        }
        boolean z = true;
        for (int i = 0; i < listFiles.length; i++) {
            if (listFiles[i].isFile()) {
                z = deleteFile(listFiles[i].getAbsolutePath());
                if (!z) {
                    break;
                }
            } else {
                z = deleteDirectory(listFiles[i].getAbsolutePath());
                if (!z) {
                    break;
                }
            }
        }
        return z && file.delete();
    }

    public static boolean deleteFile(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File file = new File(str);
        if (!file.isFile()) {
            return false;
        }
        try {
            file.delete();
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static long fileSize(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        return sizeOf(new File(str));
    }

    public static String formatFileSize(long j) {
        if (j < 1024) {
            return String.format(Locale.US, "%d B", new Object[]{Integer.valueOf((int) j)});
        } else if (j < 1048576) {
            return String.format(Locale.US, "%.2f KB", new Object[]{Float.valueOf(((float) j) / ((float) 1024))});
        } else if (j < 1073741824) {
            return String.format(Locale.US, "%.2f MB", new Object[]{Float.valueOf(((float) j) / ((float) 1048576))});
        } else {
            return String.format(Locale.US, "%.2f GB", new Object[]{Float.valueOf(((float) j) / ((float) 1073741824))});
        }
    }

    public static long getFileDate(String str) {
        File file = new File(str);
        if (file.exists()) {
            return file.lastModified();
        }
        return 0;
    }

    public static String getFileExtFromAbPath(String str) {
        String str2 = "";
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        try {
            int lastIndexOf = str.lastIndexOf(46);
            return lastIndexOf > 0 ? str.substring(lastIndexOf) : str2;
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("exception ex=");
            sb.append(e.getMessage());
            C8554j.m25007e("FileUtils", sb.toString());
            return str2;
        }
    }

    public static String getFileName(String str) {
        String name = new File(str).getName();
        if (TextUtils.isEmpty(name)) {
            return name;
        }
        int lastIndexOf = name.lastIndexOf(".");
        return lastIndexOf > 0 ? name.substring(0, lastIndexOf) : name;
    }

    public static String getFileParentPath(String str) {
        String str2 = "";
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        try {
            int lastIndexOf = str.lastIndexOf(File.separator);
            if (lastIndexOf <= 0) {
                return str2;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(str.substring(0, lastIndexOf));
            sb.append("/");
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return str2;
        }
    }

    public static String getFileType(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf < 0) {
            return null;
        }
        return str.substring(lastIndexOf + 1).toUpperCase();
    }

    public static String getFreeFileName(String str, String str2, String str3, int i) {
        if (str == null || str2 == null || str3 == null) {
            return null;
        }
        if (!str.endsWith(File.separator)) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(File.separator);
            str = sb.toString();
        }
        if (!str2.endsWith("_")) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append(str2);
            sb2.append(str3);
            String sb3 = sb2.toString();
            if (!isFileExisted(sb3)) {
                return sb3;
            }
            StringBuilder sb4 = new StringBuilder();
            sb4.append(str2);
            sb4.append("_");
            str2 = sb4.toString();
            if (i == 0) {
                i = 1;
            }
        }
        while (true) {
            String format = String.format(Locale.US, "%s%s%d%s", new Object[]{str, str2, Integer.valueOf(i), str3});
            if (!isFileExisted(format)) {
                return format;
            }
            i++;
        }
    }

    public static long getFreeSpace(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
        if (str.startsWith(absolutePath)) {
            return new File(absolutePath).getUsableSpace();
        }
        File file = new File(str);
        while (true) {
            if (file.exists()) {
                break;
            }
            file = file.getParentFile();
            if (file != null) {
                if (file.getAbsolutePath().equals(File.separator)) {
                    break;
                }
            } else {
                file = new File(File.separator);
                break;
            }
        }
        return file.getUsableSpace();
    }

    public static boolean isAssetsFileExisted(AssetManager assetManager, String str) {
        boolean z = false;
        if (assetManager == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            InputStream open = assetManager.open(str);
            if (open != null) {
                z = true;
            }
            if (open != null) {
                try {
                    open.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception unused) {
        }
        return z;
    }

    public static boolean isDirectoryExisted(String str) {
        boolean z = false;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            z = true;
        }
        return z;
    }

    public static boolean isFileExisted(String str) {
        boolean z = false;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.startsWith(QStreamAssets.ASSETS_THEME)) {
            String substring = str.substring(QStreamAssets.ASSETS_THEME.length());
            if (TextUtils.isEmpty(substring)) {
                return false;
            }
            Context context = C8410e.aGX().getContext();
            if (context == null) {
                return false;
            }
            return isAssetsFileExisted(context.getAssets(), substring);
        }
        File file = new File(str);
        if (file.isFile() && file.exists()) {
            z = true;
        }
        return z;
    }

    public static boolean isSymlink(File file) throws IOException {
        if (file != null) {
            if (file.getParent() != null) {
                file = new File(file.getParentFile().getCanonicalFile(), file.getName());
            }
            return !file.getCanonicalFile().equals(file.getAbsoluteFile());
        }
        throw new NullPointerException("File must not be null");
    }

    /* renamed from: oc */
    public static int m24998oc(String str) {
        if (!createMultilevelDirectory(str)) {
            return 2;
        }
        long freeSpace = getFreeSpace(str);
        return (freeSpace <= 0 || freeSpace > 512000) ? 0 : 11;
    }

    /* renamed from: od */
    public static String m24999od(String str) {
        String str2 = "";
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        try {
            int lastIndexOf = str.lastIndexOf(File.separator) + 1;
            int lastIndexOf2 = str.lastIndexOf(46);
            return (lastIndexOf <= 0 || lastIndexOf2 <= 0 || lastIndexOf >= lastIndexOf2) ? str2 : str.substring(lastIndexOf, lastIndexOf2);
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("exception ex=");
            sb.append(e.getMessage());
            C8554j.m25007e("FileUtils", sb.toString());
            return str2;
        }
    }

    public static boolean renameFile(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        File file = new File(str);
        return file.isFile() && file.renameTo(new File(str2));
    }

    public static long sizeOf(File file) {
        if (!file.exists()) {
            return 0;
        }
        return file.isDirectory() ? sizeOfDirectory(file) : file.length();
    }

    public static long sizeOfDirectory(File file) {
        try {
            m25000u(file);
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                return 0;
            }
            long j = 0;
            for (File file2 : listFiles) {
                try {
                    if (!isSymlink(file2)) {
                        j += sizeOf(file2);
                        if (j < 0) {
                            break;
                        }
                    } else {
                        continue;
                    }
                } catch (IOException unused) {
                }
            }
            return j;
        } catch (Exception unused2) {
            return 0;
        }
    }

    /* renamed from: u */
    private static void m25000u(File file) {
        if (!file.exists()) {
            StringBuilder sb = new StringBuilder();
            sb.append(file);
            sb.append(" does not exist");
            throw new IllegalArgumentException(sb.toString());
        } else if (!file.isDirectory()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(file);
            sb2.append(" is not a directory");
            throw new IllegalArgumentException(sb2.toString());
        }
    }
}
