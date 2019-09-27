package com.introvd.template.p321k;

import android.text.TextUtils;
import com.aiii.sdk.android.oss.common.OSSConstants;
import com.introvd.template.common.FileUtils;
import com.introvd.template.common.LogUtils;
import com.xiaoying.p448a.C9537b;
import com.xiaoying.p448a.p450b.p451a.p455b.C9549a;
import com.xiaoying.p448a.p450b.p451a.p455b.C9551b;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import okhttp3.C9796aa.C9797a;
import okhttp3.C9814e;
import okhttp3.C9816f;
import okhttp3.C9951x;

/* renamed from: com.introvd.template.k.d */
public class C7554d extends C7549a {
    /* access modifiers changed from: private */
    public static final String TAG = "d";
    private static final C9951x crO = new C9951x();
    private C9814e crP;
    private C9951x crQ;
    /* access modifiers changed from: private */
    public boolean crR;

    public C7554d(String str, String str2, long j) {
        this(str, str2, j, crO);
    }

    public C7554d(String str, String str2, long j, C9951x xVar) {
        super(str, str2, j);
        this.crP = null;
        this.crQ = null;
        this.crR = false;
        this.crQ = (xVar != null ? xVar.aWQ() : crO.aWQ()).aWR();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m22311b(int i, int i2, int i3, Object obj) {
        if (this.crw != null) {
            this.crw.onEvent(0, i, (long) i2, (long) i3, obj);
        }
    }

    private void reset() {
        if (crO != null) {
            this.crQ = crO.aWQ().mo38236l((long) C9537b.getConnectionTimeout(), TimeUnit.MILLISECONDS).mo38237m(C9537b.aRg(), TimeUnit.MILLISECONDS).mo38238n(C9537b.aRg(), TimeUnit.MILLISECONDS).mo38234ky(true).mo38235kz(true).aWR();
        }
    }

    public synchronized boolean start() {
        stop();
        this.crR = false;
        String abc = abc();
        File file = new File(abc);
        if (file.exists()) {
            long length = file.length();
            this.crp = length;
            this.cro = length;
            m22311b(1, (int) this.cro, (int) this.crp, this);
            m22311b(2, (int) this.cro, (int) this.crp, this);
            return true;
        }
        FileUtils.createMultilevelDirectory(file.getParent());
        StringBuilder sb = new StringBuilder();
        sb.append(abc);
        sb.append(".part");
        final String sb2 = sb.toString();
        File file2 = new File(sb2);
        reset();
        C9797a bR = new C9797a().mo37760tu(abb()).mo37759bR("Content-Type", "application/octet-stream").mo37759bR("User-Agent", "XiaoYing Android");
        String parameter = C9537b.getParameter("Referer");
        if (!TextUtils.isEmpty(parameter)) {
            bR.mo37759bR("Referer", parameter);
        }
        final long length2 = file2.length();
        if (length2 > 0) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("bytes=");
            sb3.append(length2);
            sb3.append("-");
            bR.mo37759bR("RANGE", sb3.toString());
        }
        this.crP = C9549a.m27488a(this.crQ, new C9551b() {
            private boolean crS = true;
            private long crT = 0;
            private int crU = 0;
            private int crV = 0;

            /* renamed from: a */
            public void mo32438a(long j, long j2, boolean z) {
                long j3 = j + length2;
                long j4 = j2 + length2;
                int i = (j4 > 0 ? 1 : (j4 == 0 ? 0 : -1));
                int i2 = i != 0 ? (int) ((100 * j3) / j4) : 0;
                String access$000 = C7554d.TAG;
                StringBuilder sb = new StringBuilder();
                sb.append("download progress:");
                sb.append(i2);
                LogUtils.m14223i(access$000, sb.toString());
                long currentTimeMillis = System.currentTimeMillis();
                boolean z2 = j3 == j4;
                if (this.crS) {
                    C7554d.this.crp = i > 0 ? j4 : 2147483647L;
                    C7554d.this.m22311b(4, (int) j4, 0, C7554d.this);
                    this.crS = false;
                    this.crV = i2;
                    z2 = true;
                }
                if (!z2) {
                    if (this.crV != i2 && Math.abs(currentTimeMillis - this.crT) > 50) {
                        this.crV = i2;
                        z2 = true;
                    }
                    if (((long) this.crU) + OSSConstants.MIN_PART_SIZE_LIMIT < j3) {
                        z2 = true;
                    }
                }
                C7554d.this.cro = j3;
                if (z2) {
                    this.crT = currentTimeMillis;
                    int i3 = (int) j3;
                    this.crU = i3;
                    C7554d.this.m22311b(1, i3, (int) j4, C7554d.this);
                }
            }
        }).mo37831b(bR.aXf());
        this.crP.mo37826a(new C9816f() {
            /* renamed from: a */
            public void mo12046a(C9814e eVar, IOException iOException) {
                String access$000 = C7554d.TAG;
                StringBuilder sb = new StringBuilder();
                sb.append("error ");
                sb.append(iOException.getMessage());
                LogUtils.m14222e(access$000, sb.toString());
                C7554d.this.m22311b(3, (int) C7554d.this.cro, (int) C7554d.this.crp, C7554d.this);
                C7554d.this.crv = iOException;
            }

            /* JADX WARNING: type inference failed for: r5v1 */
            /* JADX WARNING: type inference failed for: r5v2, types: [java.io.FileOutputStream] */
            /* JADX WARNING: type inference failed for: r5v3, types: [java.io.FileOutputStream] */
            /* JADX WARNING: type inference failed for: r5v4 */
            /* JADX WARNING: type inference failed for: r5v5 */
            /* JADX WARNING: type inference failed for: r5v6, types: [java.io.IOException] */
            /* JADX WARNING: type inference failed for: r5v8, types: [java.io.IOException] */
            /* JADX WARNING: type inference failed for: r5v18 */
            /* JADX WARNING: type inference failed for: r5v19 */
            /* JADX WARNING: type inference failed for: r5v20 */
            /* JADX WARNING: type inference failed for: r5v21 */
            /* JADX WARNING: type inference failed for: r5v22 */
            /* JADX WARNING: type inference failed for: r5v23 */
            /* JADX WARNING: type inference failed for: r5v24 */
            /* JADX WARNING: type inference failed for: r5v25 */
            /* JADX WARNING: Can't wrap try/catch for region: R(4:101|102|103|104) */
            /* JADX WARNING: Failed to process nested try/catch */
            /* JADX WARNING: Missing exception handler attribute for start block: B:103:0x0198 */
            /* JADX WARNING: Missing exception handler attribute for start block: B:123:0x01c1 */
            /* JADX WARNING: Missing exception handler attribute for start block: B:47:0x0101 */
            /* JADX WARNING: Missing exception handler attribute for start block: B:64:0x0122 */
            /* JADX WARNING: Multi-variable type inference failed */
            /* JADX WARNING: Removed duplicated region for block: B:101:0x0195 A[SYNTHETIC, Splitter:B:101:0x0195] */
            /* JADX WARNING: Removed duplicated region for block: B:107:0x019f A[SYNTHETIC, Splitter:B:107:0x019f] */
            /* JADX WARNING: Removed duplicated region for block: B:111:0x01a4 A[SYNTHETIC, Splitter:B:111:0x01a4] */
            /* JADX WARNING: Removed duplicated region for block: B:116:0x01b1  */
            /* JADX WARNING: Removed duplicated region for block: B:121:0x01be A[SYNTHETIC, Splitter:B:121:0x01be] */
            /* JADX WARNING: Removed duplicated region for block: B:127:0x01c8 A[SYNTHETIC, Splitter:B:127:0x01c8] */
            /* JADX WARNING: Removed duplicated region for block: B:131:0x01cd A[SYNTHETIC, Splitter:B:131:0x01cd] */
            /* JADX WARNING: Removed duplicated region for block: B:136:0x01da  */
            /* JADX WARNING: Removed duplicated region for block: B:51:0x0106 A[SYNTHETIC, Splitter:B:51:0x0106] */
            /* JADX WARNING: Removed duplicated region for block: B:55:0x010b A[SYNTHETIC, Splitter:B:55:0x010b] */
            /* JADX WARNING: Removed duplicated region for block: B:60:0x0117  */
            /* JADX WARNING: Removed duplicated region for block: B:68:0x0127 A[SYNTHETIC, Splitter:B:68:0x0127] */
            /* JADX WARNING: Removed duplicated region for block: B:72:0x012c A[SYNTHETIC, Splitter:B:72:0x012c] */
            /* JADX WARNING: Removed duplicated region for block: B:77:0x0138  */
            /* JADX WARNING: Unknown variable types count: 5 */
            /* renamed from: a */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void mo12047a(okhttp3.C9814e r18, okhttp3.C9802ac r19) {
                /*
                    r17 = this;
                    r1 = r17
                    r2 = r18
                    int r0 = r19.aTm()
                    r3 = 2
                    r4 = 1
                    r5 = 416(0x1a0, float:5.83E-43)
                    if (r0 != r5) goto L_0x0058
                    long r5 = r4
                    r7 = 0
                    int r0 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
                    if (r0 <= 0) goto L_0x0058
                    java.io.File r0 = new java.io.File
                    java.lang.String r2 = r0
                    r0.<init>(r2)
                    java.io.File r2 = new java.io.File
                    com.introvd.template.k.d r5 = com.introvd.template.p321k.C7554d.this
                    java.lang.String r5 = r5.abc()
                    r2.<init>(r5)
                    r0.renameTo(r2)
                    com.introvd.template.k.d r0 = com.introvd.template.p321k.C7554d.this
                    com.introvd.template.k.d r2 = com.introvd.template.p321k.C7554d.this
                    long r5 = r4
                    r2.crp = r5
                    r0.cro = r5
                    com.introvd.template.k.d r0 = com.introvd.template.p321k.C7554d.this
                    com.introvd.template.k.d r2 = com.introvd.template.p321k.C7554d.this
                    long r5 = r2.cro
                    int r2 = (int) r5
                    com.introvd.template.k.d r5 = com.introvd.template.p321k.C7554d.this
                    long r5 = r5.crp
                    int r5 = (int) r5
                    com.introvd.template.k.d r6 = com.introvd.template.p321k.C7554d.this
                    r0.m22311b(r4, r2, r5, r6)
                    com.introvd.template.k.d r0 = com.introvd.template.p321k.C7554d.this
                    com.introvd.template.k.d r2 = com.introvd.template.p321k.C7554d.this
                    long r4 = r2.cro
                    int r2 = (int) r4
                    com.introvd.template.k.d r4 = com.introvd.template.p321k.C7554d.this
                    long r4 = r4.crp
                    int r4 = (int) r4
                    com.introvd.template.k.d r5 = com.introvd.template.p321k.C7554d.this
                    r0.m22311b(r3, r2, r4, r5)
                    return
                L_0x0058:
                    boolean r0 = r19.isSuccessful()
                    if (r0 != 0) goto L_0x007c
                    java.io.IOException r0 = new java.io.IOException
                    java.lang.StringBuilder r3 = new java.lang.StringBuilder
                    r3.<init>()
                    java.lang.String r4 = "bad response status code "
                    r3.append(r4)
                    int r4 = r19.aTm()
                    r3.append(r4)
                    java.lang.String r3 = r3.toString()
                    r0.<init>(r3)
                    r1.mo12046a(r2, r0)
                    return
                L_0x007c:
                    r0 = 4096(0x1000, float:5.74E-42)
                    byte[] r0 = new byte[r0]
                    r5 = 0
                    r6 = 5
                    okhttp3.ad r7 = r19.aXh()     // Catch:{ IOException -> 0x01b9, all -> 0x0190 }
                    java.lang.String r8 = "Content-Length"
                    r9 = r19
                    java.util.List r8 = r9.mo37780tw(r8)     // Catch:{ IOException -> 0x018d, all -> 0x018a }
                    r9 = -1
                    r11 = 0
                    if (r8 == 0) goto L_0x00a8
                    boolean r12 = r8.isEmpty()     // Catch:{ IOException -> 0x018d, all -> 0x018a }
                    if (r12 != 0) goto L_0x00a8
                    java.lang.Object r8 = r8.get(r11)     // Catch:{ IOException -> 0x018d, all -> 0x018a }
                    java.lang.String r8 = (java.lang.String) r8     // Catch:{ IOException -> 0x018d, all -> 0x018a }
                    long r12 = java.lang.Long.parseLong(r8)     // Catch:{ IOException -> 0x018d, all -> 0x018a }
                    long r14 = r4     // Catch:{ IOException -> 0x018d, all -> 0x018a }
                    r8 = 0
                    long r12 = r12 + r14
                    goto L_0x00a9
                L_0x00a8:
                    r12 = r9
                L_0x00a9:
                    if (r7 != 0) goto L_0x00d2
                    if (r7 == 0) goto L_0x00b0
                    r7.close()     // Catch:{ Throwable -> 0x00b0 }
                L_0x00b0:
                    com.introvd.template.k.d r0 = com.introvd.template.p321k.C7554d.this
                    boolean r0 = r0.crR
                    if (r0 == 0) goto L_0x00ca
                L_0x00b8:
                    com.introvd.template.k.d r0 = com.introvd.template.p321k.C7554d.this
                    com.introvd.template.k.d r2 = com.introvd.template.p321k.C7554d.this
                    long r2 = r2.cro
                    int r2 = (int) r2
                    com.introvd.template.k.d r3 = com.introvd.template.p321k.C7554d.this
                    long r3 = r3.crp
                    int r3 = (int) r3
                    com.introvd.template.k.d r4 = com.introvd.template.p321k.C7554d.this
                    r0.m22311b(r6, r2, r3, r4)
                    return
                L_0x00ca:
                    java.io.File r0 = new java.io.File
                    java.lang.String r2 = r0
                    r0.<init>(r2)
                    return
                L_0x00d2:
                    java.io.InputStream r8 = r7.byteStream()     // Catch:{ IOException -> 0x018d, all -> 0x018a }
                    java.io.File r14 = new java.io.File     // Catch:{ IOException -> 0x0188, all -> 0x0186 }
                    java.lang.String r15 = r0     // Catch:{ IOException -> 0x0188, all -> 0x0186 }
                    r14.<init>(r15)     // Catch:{ IOException -> 0x0188, all -> 0x0186 }
                    java.io.FileOutputStream r15 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0188, all -> 0x0186 }
                    r15.<init>(r14, r4)     // Catch:{ IOException -> 0x0188, all -> 0x0186 }
                L_0x00e2:
                    com.introvd.template.k.d r14 = com.introvd.template.p321k.C7554d.this     // Catch:{ IOException -> 0x0183, all -> 0x0180 }
                    boolean r14 = r14.crR     // Catch:{ IOException -> 0x0183, all -> 0x0180 }
                    if (r14 != 0) goto L_0x00f6
                    int r14 = r8.read(r0)     // Catch:{ IOException -> 0x0183, all -> 0x0180 }
                    r4 = -1
                    if (r14 == r4) goto L_0x00f6
                    r15.write(r0, r11, r14)     // Catch:{ IOException -> 0x0183, all -> 0x0180 }
                    r4 = 1
                    goto L_0x00e2
                L_0x00f6:
                    com.introvd.template.k.d r0 = com.introvd.template.p321k.C7554d.this     // Catch:{ IOException -> 0x0183, all -> 0x0180 }
                    boolean r0 = r0.crR     // Catch:{ IOException -> 0x0183, all -> 0x0180 }
                    if (r0 == 0) goto L_0x011f
                    r15.flush()     // Catch:{ Throwable -> 0x0101 }
                L_0x0101:
                    r15.close()     // Catch:{ Exception -> 0x0104 }
                L_0x0104:
                    if (r8 == 0) goto L_0x0109
                    r8.close()     // Catch:{ Throwable -> 0x0109 }
                L_0x0109:
                    if (r7 == 0) goto L_0x010e
                    r7.close()     // Catch:{ Throwable -> 0x010e }
                L_0x010e:
                    com.introvd.template.k.d r0 = com.introvd.template.p321k.C7554d.this
                    boolean r0 = r0.crR
                    if (r0 == 0) goto L_0x0117
                    goto L_0x00b8
                L_0x0117:
                    java.io.File r0 = new java.io.File
                    java.lang.String r2 = r0
                    r0.<init>(r2)
                    return
                L_0x011f:
                    r15.flush()     // Catch:{ Throwable -> 0x0122 }
                L_0x0122:
                    r15.close()     // Catch:{ Exception -> 0x0125 }
                L_0x0125:
                    if (r8 == 0) goto L_0x012a
                    r8.close()     // Catch:{ Throwable -> 0x012a }
                L_0x012a:
                    if (r7 == 0) goto L_0x012f
                    r7.close()     // Catch:{ Throwable -> 0x012f }
                L_0x012f:
                    com.introvd.template.k.d r0 = com.introvd.template.p321k.C7554d.this
                    boolean r0 = r0.crR
                    if (r0 == 0) goto L_0x0138
                    goto L_0x00b8
                L_0x0138:
                    java.io.File r0 = new java.io.File
                    java.lang.String r4 = r0
                    r0.<init>(r4)
                    int r4 = (r12 > r9 ? 1 : (r12 == r9 ? 0 : -1))
                    if (r4 == 0) goto L_0x0155
                    long r6 = r0.length()
                    int r4 = (r12 > r6 ? 1 : (r12 == r6 ? 0 : -1))
                    if (r4 == 0) goto L_0x0155
                    java.io.IOException r5 = new java.io.IOException
                    java.lang.String r4 = "Unmatched content length"
                    r5.<init>(r4)
                    r16 = 0
                    goto L_0x0157
                L_0x0155:
                    r16 = 1
                L_0x0157:
                    if (r5 == 0) goto L_0x015d
                    r1.mo12046a(r2, r5)
                    return
                L_0x015d:
                    if (r16 == 0) goto L_0x01e7
                    java.io.File r2 = new java.io.File
                    com.introvd.template.k.d r4 = com.introvd.template.p321k.C7554d.this
                    java.lang.String r4 = r4.abc()
                    r2.<init>(r4)
                    r0.renameTo(r2)
                    com.introvd.template.k.d r0 = com.introvd.template.p321k.C7554d.this
                    com.introvd.template.k.d r2 = com.introvd.template.p321k.C7554d.this
                    long r4 = r2.cro
                    int r2 = (int) r4
                    com.introvd.template.k.d r4 = com.introvd.template.p321k.C7554d.this
                    long r4 = r4.crp
                    int r4 = (int) r4
                    com.introvd.template.k.d r5 = com.introvd.template.p321k.C7554d.this
                    r0.m22311b(r3, r2, r4, r5)
                    goto L_0x01e7
                L_0x0180:
                    r0 = move-exception
                    r5 = r15
                    goto L_0x0193
                L_0x0183:
                    r0 = move-exception
                    r5 = r15
                    goto L_0x01bc
                L_0x0186:
                    r0 = move-exception
                    goto L_0x0193
                L_0x0188:
                    r0 = move-exception
                    goto L_0x01bc
                L_0x018a:
                    r0 = move-exception
                    r8 = r5
                    goto L_0x0193
                L_0x018d:
                    r0 = move-exception
                    r8 = r5
                    goto L_0x01bc
                L_0x0190:
                    r0 = move-exception
                    r7 = r5
                    r8 = r7
                L_0x0193:
                    if (r5 == 0) goto L_0x019d
                    r5.flush()     // Catch:{ Throwable -> 0x0198 }
                L_0x0198:
                    r5.close()     // Catch:{ Exception -> 0x019c }
                    goto L_0x019d
                L_0x019c:
                L_0x019d:
                    if (r8 == 0) goto L_0x01a2
                    r8.close()     // Catch:{ Throwable -> 0x01a2 }
                L_0x01a2:
                    if (r7 == 0) goto L_0x01a7
                    r7.close()     // Catch:{ Throwable -> 0x01a7 }
                L_0x01a7:
                    com.introvd.template.k.d r2 = com.introvd.template.p321k.C7554d.this
                    boolean r2 = r2.crR
                    if (r2 == 0) goto L_0x01b1
                    goto L_0x00b8
                L_0x01b1:
                    java.io.File r2 = new java.io.File
                    java.lang.String r3 = r0
                    r2.<init>(r3)
                    throw r0
                L_0x01b9:
                    r0 = move-exception
                    r7 = r5
                    r8 = r7
                L_0x01bc:
                    if (r5 == 0) goto L_0x01c6
                    r5.flush()     // Catch:{ Throwable -> 0x01c1 }
                L_0x01c1:
                    r5.close()     // Catch:{ Exception -> 0x01c5 }
                    goto L_0x01c6
                L_0x01c5:
                L_0x01c6:
                    if (r8 == 0) goto L_0x01cb
                    r8.close()     // Catch:{ Throwable -> 0x01cb }
                L_0x01cb:
                    if (r7 == 0) goto L_0x01d0
                    r7.close()     // Catch:{ Throwable -> 0x01d0 }
                L_0x01d0:
                    com.introvd.template.k.d r3 = com.introvd.template.p321k.C7554d.this
                    boolean r3 = r3.crR
                    if (r3 == 0) goto L_0x01da
                    goto L_0x00b8
                L_0x01da:
                    java.io.File r3 = new java.io.File
                    java.lang.String r4 = r0
                    r3.<init>(r4)
                    if (r0 == 0) goto L_0x01e7
                    r1.mo12046a(r2, r0)
                    return
                L_0x01e7:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.p321k.C7554d.C75562.mo12047a(okhttp3.e, okhttp3.ac):void");
            }
        });
        return true;
    }

    public synchronized boolean stop() {
        this.crR = true;
        if (this.crP != null) {
            this.crP.cancel();
            this.crP = null;
        }
        return true;
    }
}
