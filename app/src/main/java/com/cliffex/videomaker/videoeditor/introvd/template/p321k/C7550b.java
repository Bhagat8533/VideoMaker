package com.introvd.template.p321k;

/* renamed from: com.introvd.template.k.b */
public final class C7550b extends Thread {
    private final int crA;
    private final String crr;
    private final String crs;
    private final long crx;
    private final long cry;
    private final C7551a crz;

    /* renamed from: com.introvd.template.k.b$a */
    public interface C7551a {
        long onEvent(int i, int i2, long j, long j2, Object obj);
    }

    public C7550b(int i, String str, String str2, long j, long j2, C7551a aVar) {
        this.crr = str;
        this.crs = str2;
        this.crx = j;
        this.cry = j2;
        this.crz = aVar;
        this.crA = i;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:107:0x029f, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x02a0, code lost:
        r17 = r7;
        r9 = 131076;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x02f6, code lost:
        r10 = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:?, code lost:
        r6 = new java.lang.StringBuilder();
        r6.append("[DownloadThread]Thread interrupted,url:");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x0304, code lost:
        r12 = r29;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:137:?, code lost:
        r6.append(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x0310, code lost:
        r39 = new java.lang.Exception(r6.toString());
        r24 = r15;
        r6 = 5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x0316, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x0318, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x0319, code lost:
        r17 = r7;
        r9 = 2;
        r19 = true;
        r30 = true;
        r31 = false;
        r39 = null;
        r40 = 5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x0328, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x0329, code lost:
        r12 = r29;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x032b, code lost:
        r17 = r4;
        r24 = 2;
        r8 = r13;
        r19 = true;
        r39 = null;
        r40 = 5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x033f, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:147:0x0340, code lost:
        r17 = r7;
        r9 = 196610;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:148:0x0346, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:0x0347, code lost:
        r12 = r29;
        r17 = r4;
        r8 = r13;
        r24 = 196610;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:0x0350, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:0x0351, code lost:
        r12 = r29;
        r17 = r4;
        r8 = r13;
        r24 = 131076;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:239:0x0492, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:240:0x0493, code lost:
        r2 = null;
        r3 = false;
        r5 = null;
        r6 = 0;
        r8 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:241:0x049b, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:242:0x049c, code lost:
        r2 = 0;
        r4 = null;
        r5 = null;
        r9 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:253:0x04cb, code lost:
        r4 = 5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:254:0x04cd, code lost:
        r4 = 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:259:?, code lost:
        r5.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:263:0x04fa, code lost:
        r17.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:268:0x0509, code lost:
        if (isInterrupted() != false) goto L_0x050b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:269:0x050b, code lost:
        r4 = 5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:270:0x050d, code lost:
        r4 = 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:272:0x0510, code lost:
        r2 = new java.lang.StringBuilder();
        r2.append("final result:");
        r2.append(r4);
        com.introvd.template.common.LogUtils.m14222e("DownloadThread", r2.toString());
        r1.crz.onEvent(r1.crA, r4, r24, 0, r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:281:?, code lost:
        r17.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:285:0x055d, code lost:
        r4.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:290:0x056c, code lost:
        if (isInterrupted() != false) goto L_0x056e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:291:0x056e, code lost:
        r18 = 5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:292:0x0571, code lost:
        r18 = 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:295:0x0578, code lost:
        if (r31 != false) goto L_0x058c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:299:0x0582, code lost:
        if (r13 <= 0) goto L_0x058a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:302:0x0588, code lost:
        r8 = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:303:0x058a, code lost:
        r8 = 5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:304:0x058c, code lost:
        r8 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:305:0x058e, code lost:
        r2 = new java.lang.StringBuilder();
        r2.append("final result:");
        r2.append(r8);
        com.introvd.template.common.LogUtils.m14222e("DownloadThread", r2.toString());
        r1.crz.onEvent(r1.crA, r8, r9, 0, r39);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x029f A[ExcHandler: all (th java.lang.Throwable), Splitter:B:104:0x0299] */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x0318 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:133:0x02f8] */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x033f A[ExcHandler: all (th java.lang.Throwable), PHI: r13 
      PHI: (r13v18 long) = (r13v15 long), (r13v15 long), (r13v19 long), (r13v19 long), (r13v19 long) binds: [B:119:0x02c5, B:120:?, B:129:0x02f0, B:123:0x02d3, B:124:?] A[DONT_GENERATE, DONT_INLINE], Splitter:B:119:0x02c5] */
    /* JADX WARNING: Removed duplicated region for block: B:241:0x049b A[ExcHandler: all (th java.lang.Throwable), Splitter:B:5:0x0009] */
    /* JADX WARNING: Removed duplicated region for block: B:253:0x04cb  */
    /* JADX WARNING: Removed duplicated region for block: B:254:0x04cd  */
    /* JADX WARNING: Removed duplicated region for block: B:258:0x04f2 A[SYNTHETIC, Splitter:B:258:0x04f2] */
    /* JADX WARNING: Removed duplicated region for block: B:263:0x04fa A[Catch:{ Exception -> 0x04f6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:272:0x0510  */
    /* JADX WARNING: Removed duplicated region for block: B:280:0x0555 A[SYNTHETIC, Splitter:B:280:0x0555] */
    /* JADX WARNING: Removed duplicated region for block: B:285:0x055d A[Catch:{ Exception -> 0x0559 }] */
    /* JADX WARNING: Removed duplicated region for block: B:295:0x0578  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r43 = this;
            r1 = r43
            r0 = 10
            android.os.Process.setThreadPriority(r0)     // Catch:{ Exception -> 0x0007 }
        L_0x0007:
            r8 = 0
            long r10 = r1.crx     // Catch:{ Exception -> 0x04b2, all -> 0x049b }
            java.lang.String r12 = r1.crr     // Catch:{ Exception -> 0x04b2, all -> 0x049b }
            java.net.URL r0 = new java.net.URL     // Catch:{ Exception -> 0x0492, all -> 0x049b }
            r0.<init>(r12)     // Catch:{ Exception -> 0x0492, all -> 0x049b }
            long r13 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0492, all -> 0x049b }
            r15 = 65537(0x10001, double:3.23796E-319)
            java.lang.String r2 = "DownloadThread"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0483, all -> 0x047c }
            r5.<init>()     // Catch:{ Exception -> 0x0483, all -> 0x047c }
            java.lang.String r6 = "opening Connection "
            r5.append(r6)     // Catch:{ Exception -> 0x0483, all -> 0x047c }
            r5.append(r12)     // Catch:{ Exception -> 0x0483, all -> 0x047c }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x0483, all -> 0x047c }
            com.introvd.template.common.LogUtils.m14223i(r2, r5)     // Catch:{ Exception -> 0x0483, all -> 0x047c }
            java.net.URLConnection r0 = r0.openConnection()     // Catch:{ Exception -> 0x0483, all -> 0x047c }
            r5 = r0
            java.net.HttpURLConnection r5 = (java.net.HttpURLConnection) r5     // Catch:{ Exception -> 0x0483, all -> 0x047c }
            int r0 = com.xiaoying.p448a.C9537b.getConnectionTimeout()     // Catch:{ Exception -> 0x0477, all -> 0x0471 }
            r5.setConnectTimeout(r0)     // Catch:{ Exception -> 0x0477, all -> 0x0471 }
            long r3 = com.xiaoying.p448a.C9537b.aRg()     // Catch:{ Exception -> 0x0477, all -> 0x0471 }
            int r0 = (int) r3     // Catch:{ Exception -> 0x0477, all -> 0x0471 }
            r5.setReadTimeout(r0)     // Catch:{ Exception -> 0x0477, all -> 0x0471 }
            java.lang.String r0 = "User-Agent"
            java.lang.String r2 = "Android"
            r5.setRequestProperty(r0, r2)     // Catch:{ Exception -> 0x0477, all -> 0x0471 }
            java.lang.String r0 = "Connection"
            java.lang.String r2 = "Keep-Alive"
            r5.setRequestProperty(r0, r2)     // Catch:{ Exception -> 0x0477, all -> 0x0471 }
            java.lang.String r0 = "Referer"
            java.lang.String r0 = com.xiaoying.p448a.C9537b.getParameter(r0)     // Catch:{ Exception -> 0x0477, all -> 0x0471 }
            boolean r2 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x0477, all -> 0x0471 }
            if (r2 != 0) goto L_0x0075
            java.lang.String r2 = "Referer"
            r5.setRequestProperty(r2, r0)     // Catch:{ Exception -> 0x006c, all -> 0x0065 }
            goto L_0x0075
        L_0x0065:
            r0 = move-exception
            r2 = r8
            r13 = r2
            r9 = r15
            r4 = 0
            goto L_0x04a4
        L_0x006c:
            r0 = move-exception
            r2 = r5
            r6 = r8
            r24 = r15
            r3 = 0
            r5 = 0
            goto L_0x048d
        L_0x0075:
            r2 = -1
            int r0 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1))
            if (r0 != 0) goto L_0x0081
            long r10 = r1.cry     // Catch:{ Exception -> 0x006c, all -> 0x0065 }
            int r0 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r0 == 0) goto L_0x00bc
        L_0x0081:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0477, all -> 0x0471 }
            r0.<init>()     // Catch:{ Exception -> 0x0477, all -> 0x0471 }
            java.lang.String r4 = "bytes="
            r0.append(r4)     // Catch:{ Exception -> 0x0477, all -> 0x0471 }
            long r10 = r1.crx     // Catch:{ Exception -> 0x0477, all -> 0x0471 }
            r0.append(r10)     // Catch:{ Exception -> 0x0477, all -> 0x0471 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0477, all -> 0x0471 }
            long r10 = r1.cry     // Catch:{ Exception -> 0x0477, all -> 0x0471 }
            int r4 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r4 == 0) goto L_0x00b7
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0477, all -> 0x0471 }
            r4.<init>()     // Catch:{ Exception -> 0x0477, all -> 0x0471 }
            r4.append(r0)     // Catch:{ Exception -> 0x0477, all -> 0x0471 }
            java.lang.String r0 = "-"
            r4.append(r0)     // Catch:{ Exception -> 0x0477, all -> 0x0471 }
            long r10 = r1.crx     // Catch:{ Exception -> 0x0477, all -> 0x0471 }
            long r7 = r1.cry     // Catch:{ Exception -> 0x0477, all -> 0x0471 }
            r0 = 0
            long r10 = r10 + r7
            r6 = 1
            long r10 = r10 - r6
            r4.append(r10)     // Catch:{ Exception -> 0x0477, all -> 0x0471 }
            java.lang.String r0 = r4.toString()     // Catch:{ Exception -> 0x0477, all -> 0x0471 }
        L_0x00b7:
            java.lang.String r4 = "RANGE"
            r5.setRequestProperty(r4, r0)     // Catch:{ Exception -> 0x0477, all -> 0x0471 }
        L_0x00bc:
            r8 = 65538(0x10002, double:3.238E-319)
            r5.connect()     // Catch:{ Exception -> 0x046c, all -> 0x0469 }
            java.lang.String r0 = "DownloadThread"
            java.lang.String r4 = "connected"
            com.introvd.template.common.LogUtils.m14223i(r0, r4)     // Catch:{ Exception -> 0x046c, all -> 0x0469 }
            r8 = 131073(0x20001, double:6.47587E-319)
            int r0 = r5.getResponseCode()     // Catch:{ Exception -> 0x0463, all -> 0x0455 }
            java.lang.String r4 = "DownloadThread"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0463, all -> 0x0455 }
            r6.<init>()     // Catch:{ Exception -> 0x0463, all -> 0x0455 }
            java.lang.String r7 = "getResponseCode: "
            r6.append(r7)     // Catch:{ Exception -> 0x0463, all -> 0x0455 }
            r6.append(r0)     // Catch:{ Exception -> 0x0463, all -> 0x0455 }
            java.lang.String r7 = ", cost:"
            r6.append(r7)     // Catch:{ Exception -> 0x0463, all -> 0x0455 }
            long r10 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0463, all -> 0x0455 }
            r7 = 0
            long r10 = r10 - r13
            r6.append(r10)     // Catch:{ Exception -> 0x0463, all -> 0x0455 }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x0463, all -> 0x0455 }
            com.introvd.template.common.LogUtils.m14223i(r4, r6)     // Catch:{ Exception -> 0x0463, all -> 0x0455 }
            r4 = 200(0xc8, float:2.8E-43)
            if (r0 == r4) goto L_0x0157
            r4 = 206(0xce, float:2.89E-43)
            if (r0 == r4) goto L_0x0157
            r8 = 131074(0x20002, double:6.4759E-319)
            java.lang.Exception r2 = new java.lang.Exception     // Catch:{ Exception -> 0x0463, all -> 0x0455 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0463, all -> 0x0455 }
            r3.<init>()     // Catch:{ Exception -> 0x0463, all -> 0x0455 }
            java.lang.String r4 = "[DownloadThread]Bad http response code:"
            r3.append(r4)     // Catch:{ Exception -> 0x0463, all -> 0x0455 }
            r3.append(r0)     // Catch:{ Exception -> 0x0463, all -> 0x0455 }
            java.lang.String r0 = ",url:"
            r3.append(r0)     // Catch:{ Exception -> 0x0463, all -> 0x0455 }
            r3.append(r12)     // Catch:{ Exception -> 0x0463, all -> 0x0455 }
            java.lang.String r0 = r3.toString()     // Catch:{ Exception -> 0x0463, all -> 0x0455 }
            r2.<init>(r0)     // Catch:{ Exception -> 0x0463, all -> 0x0455 }
            if (r5 == 0) goto L_0x012b
            r5.disconnect()     // Catch:{ Exception -> 0x0123 }
            goto L_0x012b
        L_0x0123:
            boolean r0 = r43.isInterrupted()
            if (r0 == 0) goto L_0x012b
            r0 = 5
            goto L_0x012c
        L_0x012b:
            r0 = 3
        L_0x012c:
            java.lang.String r3 = "DownloadThread"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "final result:"
            r4.append(r5)
            r4.append(r0)
            java.lang.String r4 = r4.toString()
            com.introvd.template.common.LogUtils.m14222e(r3, r4)
            com.introvd.template.k.b$a r3 = r1.crz
            int r4 = r1.crA
            r26 = 0
            r24 = 131074(0x20002, double:6.4759E-319)
            r21 = r3
            r22 = r4
            r23 = r0
            r28 = r2
            r21.onEvent(r22, r23, r24, r26, r28)
            return
        L_0x0157:
            java.lang.String r0 = r5.getContentType()     // Catch:{ Exception -> 0x0463, all -> 0x0455 }
            boolean r4 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x0463, all -> 0x0455 }
            if (r4 == 0) goto L_0x01b9
            java.lang.Exception r2 = new java.lang.Exception     // Catch:{ Exception -> 0x0463, all -> 0x0455 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0463, all -> 0x0455 }
            r3.<init>()     // Catch:{ Exception -> 0x0463, all -> 0x0455 }
            java.lang.String r4 = "[DownloadThread]Bad http content type:"
            r3.append(r4)     // Catch:{ Exception -> 0x0463, all -> 0x0455 }
            r3.append(r0)     // Catch:{ Exception -> 0x0463, all -> 0x0455 }
            java.lang.String r0 = ",url:"
            r3.append(r0)     // Catch:{ Exception -> 0x0463, all -> 0x0455 }
            r3.append(r12)     // Catch:{ Exception -> 0x0463, all -> 0x0455 }
            java.lang.String r0 = r3.toString()     // Catch:{ Exception -> 0x0463, all -> 0x0455 }
            r2.<init>(r0)     // Catch:{ Exception -> 0x0463, all -> 0x0455 }
            if (r5 == 0) goto L_0x018d
            r5.disconnect()     // Catch:{ Exception -> 0x0185 }
            goto L_0x018d
        L_0x0185:
            boolean r0 = r43.isInterrupted()
            if (r0 == 0) goto L_0x018d
            r0 = 5
            goto L_0x018e
        L_0x018d:
            r0 = 3
        L_0x018e:
            java.lang.String r3 = "DownloadThread"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "final result:"
            r4.append(r5)
            r4.append(r0)
            java.lang.String r4 = r4.toString()
            com.introvd.template.common.LogUtils.m14222e(r3, r4)
            com.introvd.template.k.b$a r3 = r1.crz
            int r4 = r1.crA
            r26 = 0
            r24 = 131073(0x20001, double:6.47587E-319)
            r21 = r3
            r22 = r4
            r23 = r0
            r28 = r2
            r21.onEvent(r22, r23, r24, r26, r28)
            return
        L_0x01b9:
            int r0 = r5.getContentLength()     // Catch:{ Exception -> 0x0463, all -> 0x0455 }
            long r6 = (long) r0
            java.lang.String r0 = "DownloadThread"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x044e, all -> 0x044a }
            r4.<init>()     // Catch:{ Exception -> 0x044e, all -> 0x044a }
            java.lang.String r10 = "getContentLength: "
            r4.append(r10)     // Catch:{ Exception -> 0x044e, all -> 0x044a }
            r4.append(r6)     // Catch:{ Exception -> 0x044e, all -> 0x044a }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x044e, all -> 0x044a }
            com.introvd.template.common.LogUtils.m14223i(r0, r4)     // Catch:{ Exception -> 0x044e, all -> 0x044a }
            long r10 = r1.cry     // Catch:{ Exception -> 0x044e, all -> 0x044a }
            int r0 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r0 != 0) goto L_0x01ef
            com.introvd.template.k.b$a r0 = r1.crz     // Catch:{ Exception -> 0x044e, all -> 0x044a }
            int r2 = r1.crA     // Catch:{ Exception -> 0x044e, all -> 0x044a }
            r23 = 4
            r26 = 0
            r28 = 0
            r21 = r0
            r22 = r2
            r24 = r6
            long r2 = r21.onEvent(r22, r23, r24, r26, r28)     // Catch:{ Exception -> 0x044e, all -> 0x044a }
            goto L_0x01f9
        L_0x01ef:
            long r2 = r1.cry     // Catch:{ Exception -> 0x044e, all -> 0x044a }
            int r0 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r0 <= 0) goto L_0x01f8
            long r2 = r1.cry     // Catch:{ Exception -> 0x044e, all -> 0x044a }
            goto L_0x01f9
        L_0x01f8:
            r2 = r6
        L_0x01f9:
            r6 = 0
            int r0 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r0 > 0) goto L_0x0242
            java.lang.Exception r0 = new java.lang.Exception     // Catch:{ Exception -> 0x0233, all -> 0x0228 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0233, all -> 0x0228 }
            r4.<init>()     // Catch:{ Exception -> 0x0233, all -> 0x0228 }
            java.lang.String r6 = "[DownloadThread]Bad http read length:"
            r4.append(r6)     // Catch:{ Exception -> 0x0233, all -> 0x0228 }
            r4.append(r2)     // Catch:{ Exception -> 0x0233, all -> 0x0228 }
            java.lang.String r6 = ",url:"
            r4.append(r6)     // Catch:{ Exception -> 0x0233, all -> 0x0228 }
            r4.append(r12)     // Catch:{ Exception -> 0x0233, all -> 0x0228 }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x0233, all -> 0x0228 }
            r0.<init>(r4)     // Catch:{ Exception -> 0x0233, all -> 0x0228 }
            if (r5 == 0) goto L_0x0227
            r5.disconnect()     // Catch:{ Exception -> 0x0223 }
            goto L_0x0227
        L_0x0223:
            boolean r0 = r43.isInterrupted()
        L_0x0227:
            return
        L_0x0228:
            r0 = move-exception
            r9 = r8
            r4 = 0
            r13 = 0
            r17 = 0
            r19 = 0
            goto L_0x0460
        L_0x0233:
            r0 = move-exception
            r6 = r2
            r2 = r5
            r24 = r8
            r3 = 1
            r5 = 0
            r8 = 0
            r17 = 0
            r19 = 0
            goto L_0x04c1
        L_0x0242:
            r8 = 131075(0x20003, double:6.47597E-319)
            java.io.InputStream r4 = r5.getInputStream()     // Catch:{ Exception -> 0x0447, all -> 0x0445 }
            r0 = 32768(0x8000, float:4.5918E-41)
            byte[] r0 = new byte[r0]     // Catch:{ Exception -> 0x0439, all -> 0x0436 }
            r8 = 196609(0x30001, double:9.71378E-319)
            java.io.File r6 = new java.io.File     // Catch:{ Exception -> 0x0439, all -> 0x0436 }
            java.lang.String r7 = r1.crs     // Catch:{ Exception -> 0x0439, all -> 0x0436 }
            r6.<init>(r7)     // Catch:{ Exception -> 0x0439, all -> 0x0436 }
            java.io.BufferedOutputStream r7 = new java.io.BufferedOutputStream     // Catch:{ Exception -> 0x0439, all -> 0x0436 }
            java.io.FileOutputStream r10 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0439, all -> 0x0436 }
            r11 = 1
            r10.<init>(r6, r11)     // Catch:{ Exception -> 0x0439, all -> 0x0436 }
            r7.<init>(r10)     // Catch:{ Exception -> 0x0439, all -> 0x0436 }
            com.introvd.template.k.b$a r6 = r1.crz     // Catch:{ Exception -> 0x0420, all -> 0x0418 }
            int r8 = r1.crA     // Catch:{ Exception -> 0x0420, all -> 0x0418 }
            r23 = 1
            r24 = 0
            r28 = 0
            r21 = r6
            r22 = r8
            r26 = r2
            r21.onEvent(r22, r23, r24, r26, r28)     // Catch:{ Exception -> 0x0420, all -> 0x0418 }
            long r8 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0420, all -> 0x0418 }
            java.lang.String r6 = "DownloadThread"
            java.lang.String r10 = "starting reading"
            com.introvd.template.common.LogUtils.m14223i(r6, r10)     // Catch:{ Exception -> 0x0420, all -> 0x0418 }
            r13 = 0
            r15 = 0
            r21 = 0
        L_0x0287:
            int r6 = (r13 > r2 ? 1 : (r13 == r2 ? 0 : -1))
            if (r6 >= 0) goto L_0x035a
            r21 = 131076(0x20004, double:6.476E-319)
            r29 = r12
            long r11 = r2 - r13
            r23 = 32768(0x8000, double:1.61895E-319)
            int r6 = (r11 > r23 ? 1 : (r11 == r23 ? 0 : -1))
            if (r6 < 0) goto L_0x02b2
            int r6 = r4.read(r0)     // Catch:{ Exception -> 0x02a6, all -> 0x029f }
            r11 = 0
            goto L_0x02b8
        L_0x029f:
            r0 = move-exception
            r17 = r7
            r9 = r21
            goto L_0x045e
        L_0x02a6:
            r0 = move-exception
            r17 = r4
            r8 = r13
            r24 = r21
        L_0x02ac:
            r12 = r29
        L_0x02ae:
            r19 = 1
            goto L_0x0429
        L_0x02b2:
            int r6 = (int) r11
            r11 = 0
            int r6 = r4.read(r0, r11, r6)     // Catch:{ Exception -> 0x0350, all -> 0x029f }
        L_0x02b8:
            if (r6 > 0) goto L_0x02c2
            r24 = r15
            r10 = r21
            r12 = r29
            goto L_0x035e
        L_0x02c2:
            r19 = 196610(0x30002, double:9.7138E-319)
            r7.write(r0, r11, r6)     // Catch:{ Exception -> 0x0346, all -> 0x033f }
            long r11 = (long) r6
            long r13 = r13 + r11
            long r24 = r15 + r11
            r10 = 65536(0x10000, double:3.2379E-319)
            int r6 = (r24 > r10 ? 1 : (r24 == r10 ? 0 : -1))
            if (r6 < 0) goto L_0x02ee
            com.introvd.template.k.b$a r6 = r1.crz     // Catch:{ Exception -> 0x02e7, all -> 0x033f }
            int r10 = r1.crA     // Catch:{ Exception -> 0x02e7, all -> 0x033f }
            r23 = 1
            r28 = 0
            r21 = r6
            r22 = r10
            r26 = r2
            r21.onEvent(r22, r23, r24, r26, r28)     // Catch:{ Exception -> 0x02e7, all -> 0x033f }
            r15 = 0
            goto L_0x02f0
        L_0x02e7:
            r0 = move-exception
            r17 = r4
            r8 = r13
            r24 = r19
            goto L_0x02ac
        L_0x02ee:
            r15 = r24
        L_0x02f0:
            boolean r6 = r43.isInterrupted()     // Catch:{ Exception -> 0x0346, all -> 0x033f }
            if (r6 == 0) goto L_0x0338
            r10 = 2
            java.lang.Exception r0 = new java.lang.Exception     // Catch:{ Exception -> 0x0328, all -> 0x0318 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0328, all -> 0x0318 }
            r6.<init>()     // Catch:{ Exception -> 0x0328, all -> 0x0318 }
            java.lang.String r12 = "[DownloadThread]Thread interrupted,url:"
            r6.append(r12)     // Catch:{ Exception -> 0x0328, all -> 0x0318 }
            r12 = r29
            r6.append(r12)     // Catch:{ Exception -> 0x0316, all -> 0x0318 }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x0316, all -> 0x0318 }
            r0.<init>(r6)     // Catch:{ Exception -> 0x0316, all -> 0x0318 }
            r39 = r0
            r24 = r15
            r6 = 5
            goto L_0x0361
        L_0x0316:
            r0 = move-exception
            goto L_0x032b
        L_0x0318:
            r0 = move-exception
            r17 = r7
            r9 = r10
            r19 = 1
            r30 = 1
            r31 = 0
            r39 = 0
            r40 = 5
            goto L_0x0553
        L_0x0328:
            r0 = move-exception
            r12 = r29
        L_0x032b:
            r17 = r4
            r24 = r10
            r8 = r13
            r19 = 1
            r39 = 0
            r40 = 5
            goto L_0x042d
        L_0x0338:
            r21 = r19
            r12 = r29
            r11 = 1
            goto L_0x0287
        L_0x033f:
            r0 = move-exception
            r17 = r7
            r9 = r19
            goto L_0x045e
        L_0x0346:
            r0 = move-exception
            r12 = r29
            r17 = r4
            r8 = r13
            r24 = r19
            goto L_0x02ae
        L_0x0350:
            r0 = move-exception
            r12 = r29
            r17 = r4
            r8 = r13
            r24 = r21
            goto L_0x02ae
        L_0x035a:
            r24 = r15
            r10 = r21
        L_0x035e:
            r6 = 3
            r39 = 0
        L_0x0361:
            java.lang.String r0 = "DownloadThread"
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x040d, all -> 0x03ff }
            r15.<init>()     // Catch:{ Exception -> 0x040d, all -> 0x03ff }
            r40 = r6
            java.lang.String r6 = "end reading, cost:"
            r15.append(r6)     // Catch:{ Exception -> 0x03fd, all -> 0x03fb }
            long r19 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x03fd, all -> 0x03fb }
            r6 = 0
            long r8 = r19 - r8
            r15.append(r8)     // Catch:{ Exception -> 0x03fd, all -> 0x03fb }
            java.lang.String r6 = r15.toString()     // Catch:{ Exception -> 0x03fd, all -> 0x03fb }
            com.introvd.template.common.LogUtils.m14223i(r0, r6)     // Catch:{ Exception -> 0x03fd, all -> 0x03fb }
            boolean r0 = r43.isInterrupted()     // Catch:{ Exception -> 0x03fd, all -> 0x03fb }
            if (r0 != 0) goto L_0x03a2
            r8 = 0
            int r0 = (r24 > r8 ? 1 : (r24 == r8 ? 0 : -1))
            if (r0 == 0) goto L_0x039d
            com.introvd.template.k.b$a r0 = r1.crz     // Catch:{ Exception -> 0x03fd, all -> 0x03fb }
            int r6 = r1.crA     // Catch:{ Exception -> 0x03fd, all -> 0x03fb }
            r23 = 1
            r28 = 0
            r21 = r0
            r22 = r6
            r26 = r2
            r21.onEvent(r22, r23, r24, r26, r28)     // Catch:{ Exception -> 0x03fd, all -> 0x03fb }
        L_0x039d:
            r30 = 1
            r35 = 0
            goto L_0x03a6
        L_0x03a2:
            r35 = r10
            r30 = r40
        L_0x03a6:
            r7.close()     // Catch:{ Exception -> 0x03b4 }
            if (r4 == 0) goto L_0x03ae
            r4.close()     // Catch:{ Exception -> 0x03b4 }
        L_0x03ae:
            if (r5 == 0) goto L_0x03c0
            r5.disconnect()     // Catch:{ Exception -> 0x03b4 }
            goto L_0x03c0
        L_0x03b4:
            boolean r0 = r43.isInterrupted()
            if (r0 == 0) goto L_0x03be
            r30 = 5
            goto L_0x03c0
        L_0x03be:
            r30 = 3
        L_0x03c0:
            r4 = 0
            int r0 = (r35 > r4 ? 1 : (r35 == r4 ? 0 : -1))
            if (r0 != 0) goto L_0x03d2
            int r0 = (r13 > r4 ? 1 : (r13 == r4 ? 0 : -1))
            if (r0 <= 0) goto L_0x03d0
            int r0 = (r2 > r13 ? 1 : (r2 == r13 ? 0 : -1))
            if (r0 != 0) goto L_0x03d0
            r0 = 2
            goto L_0x03d4
        L_0x03d0:
            r0 = 5
            goto L_0x03d4
        L_0x03d2:
            r0 = r30
        L_0x03d4:
            java.lang.String r2 = "DownloadThread"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "final result:"
            r3.append(r4)
            r3.append(r0)
            java.lang.String r3 = r3.toString()
            com.introvd.template.common.LogUtils.m14222e(r2, r3)
            com.introvd.template.k.b$a r2 = r1.crz
            int r3 = r1.crA
            r37 = 0
            r32 = r2
            r33 = r3
            r34 = r0
            r32.onEvent(r33, r34, r35, r37, r39)
            goto L_0x0537
        L_0x03fb:
            r0 = move-exception
            goto L_0x0402
        L_0x03fd:
            r0 = move-exception
            goto L_0x0410
        L_0x03ff:
            r0 = move-exception
            r40 = r6
        L_0x0402:
            r17 = r7
            r9 = r10
            r19 = 1
            r30 = 1
            r31 = 0
            goto L_0x0553
        L_0x040d:
            r0 = move-exception
            r40 = r6
        L_0x0410:
            r17 = r4
            r24 = r10
            r8 = r13
            r19 = 1
            goto L_0x042d
        L_0x0418:
            r0 = move-exception
            r17 = r7
            r9 = 0
            r13 = 0
            goto L_0x045e
        L_0x0420:
            r0 = move-exception
            r17 = r4
            r8 = 0
            r19 = 1
            r24 = 0
        L_0x0429:
            r39 = 0
            r40 = 3
        L_0x042d:
            r41 = r2
            r2 = r5
            r5 = r7
            r3 = 1
            r6 = r41
            goto L_0x04c5
        L_0x0436:
            r0 = move-exception
            r9 = r8
            goto L_0x045a
        L_0x0439:
            r0 = move-exception
            r6 = r2
            r17 = r4
            r2 = r5
            r24 = r8
            r3 = 1
            r5 = 0
            r8 = 0
            goto L_0x048f
        L_0x0445:
            r0 = move-exception
            goto L_0x044c
        L_0x0447:
            r0 = move-exception
            r6 = r2
            goto L_0x044f
        L_0x044a:
            r0 = move-exception
            r2 = r6
        L_0x044c:
            r9 = r8
            goto L_0x0459
        L_0x044e:
            r0 = move-exception
        L_0x044f:
            r2 = r5
            r24 = r8
            r3 = 1
            r5 = 0
            goto L_0x048b
        L_0x0455:
            r0 = move-exception
            r9 = r8
            r2 = 0
        L_0x0459:
            r4 = 0
        L_0x045a:
            r13 = 0
            r17 = 0
        L_0x045e:
            r19 = 1
        L_0x0460:
            r30 = 1
            goto L_0x04aa
        L_0x0463:
            r0 = move-exception
            r2 = r5
            r24 = r8
            r3 = 1
            goto L_0x0488
        L_0x0469:
            r0 = move-exception
            r9 = r8
            goto L_0x0473
        L_0x046c:
            r0 = move-exception
            r2 = r5
            r24 = r8
            goto L_0x0487
        L_0x0471:
            r0 = move-exception
            r9 = r15
        L_0x0473:
            r2 = 0
            r4 = 0
            goto L_0x04a2
        L_0x0477:
            r0 = move-exception
            r2 = r5
            r24 = r15
            goto L_0x0487
        L_0x047c:
            r0 = move-exception
            r9 = r15
            r2 = 0
            r4 = 0
            r5 = 0
            goto L_0x04a2
        L_0x0483:
            r0 = move-exception
            r24 = r15
            r2 = 0
        L_0x0487:
            r3 = 0
        L_0x0488:
            r5 = 0
            r6 = 0
        L_0x048b:
            r8 = 0
        L_0x048d:
            r17 = 0
        L_0x048f:
            r19 = 1
            goto L_0x04c1
        L_0x0492:
            r0 = move-exception
            r2 = 0
            r3 = 0
            r5 = 0
            r6 = 0
            r8 = 0
            goto L_0x04bb
        L_0x049b:
            r0 = move-exception
            r2 = 0
            r4 = 0
            r5 = 0
            r9 = 0
        L_0x04a2:
            r13 = 0
        L_0x04a4:
            r17 = 0
            r19 = 1
            r30 = 0
        L_0x04aa:
            r31 = 0
            r39 = 0
            r40 = 3
            goto L_0x0553
        L_0x04b2:
            r0 = move-exception
            r2 = 0
            r3 = 0
            r5 = 0
            r6 = 0
            r8 = 0
            r12 = 0
        L_0x04bb:
            r17 = 0
            r19 = 1
            r24 = 0
        L_0x04c1:
            r39 = 0
            r40 = 3
        L_0x04c5:
            boolean r4 = r43.isInterrupted()     // Catch:{ all -> 0x0545 }
            if (r4 == 0) goto L_0x04cd
            r4 = 5
            goto L_0x04ce
        L_0x04cd:
            r4 = 3
        L_0x04ce:
            java.lang.Exception r10 = new java.lang.Exception     // Catch:{ all -> 0x0538 }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x0538 }
            r11.<init>()     // Catch:{ all -> 0x0538 }
            java.lang.String r13 = "[DownloadThread]url:"
            r11.append(r13)     // Catch:{ all -> 0x0538 }
            r11.append(r12)     // Catch:{ all -> 0x0538 }
            java.lang.String r12 = ",msg:"
            r11.append(r12)     // Catch:{ all -> 0x0538 }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x0538 }
            r11.append(r0)     // Catch:{ all -> 0x0538 }
            java.lang.String r0 = r11.toString()     // Catch:{ all -> 0x0538 }
            r10.<init>(r0)     // Catch:{ all -> 0x0538 }
            if (r5 == 0) goto L_0x04f8
            r5.close()     // Catch:{ Exception -> 0x04f6 }
            goto L_0x04f8
        L_0x04f6:
            goto L_0x0505
        L_0x04f8:
            if (r17 == 0) goto L_0x04fd
            r17.close()     // Catch:{ Exception -> 0x04f6 }
        L_0x04fd:
            if (r2 == 0) goto L_0x050e
            if (r3 == 0) goto L_0x050e
            r2.disconnect()     // Catch:{ Exception -> 0x04f6 }
            goto L_0x050e
        L_0x0505:
            boolean r0 = r43.isInterrupted()
            if (r0 == 0) goto L_0x050d
            r4 = 5
            goto L_0x050e
        L_0x050d:
            r4 = 3
        L_0x050e:
            if (r19 == 0) goto L_0x0537
            java.lang.String r0 = "DownloadThread"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "final result:"
            r2.append(r3)
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            com.introvd.template.common.LogUtils.m14222e(r0, r2)
            com.introvd.template.k.b$a r0 = r1.crz
            int r2 = r1.crA
            r26 = 0
            r21 = r0
            r22 = r2
            r23 = r4
            r28 = r10
            r21.onEvent(r22, r23, r24, r26, r28)
        L_0x0537:
            return
        L_0x0538:
            r0 = move-exception
            r30 = r3
            r40 = r4
            r13 = r8
            r4 = r17
            r9 = r24
            r31 = 1
            goto L_0x054f
        L_0x0545:
            r0 = move-exception
            r30 = r3
            r13 = r8
            r4 = r17
            r9 = r24
            r31 = 0
        L_0x054f:
            r17 = r5
            r5 = r2
            r2 = r6
        L_0x0553:
            if (r17 == 0) goto L_0x055b
            r17.close()     // Catch:{ Exception -> 0x0559 }
            goto L_0x055b
        L_0x0559:
            goto L_0x0568
        L_0x055b:
            if (r4 == 0) goto L_0x0560
            r4.close()     // Catch:{ Exception -> 0x0559 }
        L_0x0560:
            if (r5 == 0) goto L_0x0574
            if (r30 == 0) goto L_0x0574
            r5.disconnect()     // Catch:{ Exception -> 0x0559 }
            goto L_0x0574
        L_0x0568:
            boolean r4 = r43.isInterrupted()
            if (r4 == 0) goto L_0x0571
            r18 = 5
            goto L_0x0576
        L_0x0571:
            r18 = 3
            goto L_0x0576
        L_0x0574:
            r18 = r40
        L_0x0576:
            if (r19 == 0) goto L_0x05af
            if (r31 != 0) goto L_0x058c
            r4 = 0
            int r6 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r6 != 0) goto L_0x058c
            int r4 = (r13 > r4 ? 1 : (r13 == r4 ? 0 : -1))
            if (r4 <= 0) goto L_0x058a
            int r2 = (r2 > r13 ? 1 : (r2 == r13 ? 0 : -1))
            if (r2 != 0) goto L_0x058a
            r8 = 2
            goto L_0x058e
        L_0x058a:
            r8 = 5
            goto L_0x058e
        L_0x058c:
            r8 = r18
        L_0x058e:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "final result:"
            r2.append(r3)
            r2.append(r8)
            java.lang.String r2 = r2.toString()
            java.lang.String r3 = "DownloadThread"
            com.introvd.template.common.LogUtils.m14222e(r3, r2)
            com.introvd.template.k.b$a r6 = r1.crz
            int r7 = r1.crA
            r11 = 0
            r13 = r39
            r6.onEvent(r7, r8, r9, r11, r13)
        L_0x05af:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.p321k.C7550b.run():void");
    }
}
