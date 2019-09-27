package com.introvd.template.p321k;

import com.introvd.template.common.LogUtils;
import com.introvd.template.p321k.C7550b.C7551a;

/* renamed from: com.introvd.template.k.c */
public class C7552c extends C7549a implements C7551a {
    C7550b crB = null;
    C7550b[] crC = null;
    C7553a crD = null;

    /* renamed from: com.introvd.template.k.c$a */
    private class C7553a {
        private int crE = 0;
        public Thread[] crF;
        private final long[] crG;
        private final long[] crH;
        private final long[] crI;
        private final long[] crJ;
        private final long[] crK;
        private final int[] crL;
        private boolean crM = false;
        public int mCount = 0;

        public C7553a(int i) {
            if (i <= 0) {
                i = 1;
            }
            this.mCount = i;
            this.crF = new Thread[i];
            this.crG = new long[i];
            this.crH = new long[i];
            this.crI = new long[i];
            this.crJ = new long[i];
            this.crL = new int[i];
            this.crK = new long[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.crF[i2] = null;
                this.crG[i2] = 0;
                this.crI[i2] = System.currentTimeMillis();
                this.crJ[i2] = System.currentTimeMillis();
                this.crH[i2] = 134217727;
                this.crL[i2] = 0;
                this.crK[i2] = 0;
            }
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(3:(2:17|18)|19|20) */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x003e, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0040, code lost:
            return;
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0027 */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void mo32426a(int r3, java.lang.Thread r4, boolean r5) {
            /*
                r2 = this;
                monitor-enter(r2)
                boolean r0 = r2.crM     // Catch:{ all -> 0x0041 }
                if (r0 == 0) goto L_0x0007
                monitor-exit(r2)     // Catch:{ all -> 0x0041 }
                return
            L_0x0007:
                java.lang.Thread[] r0 = r2.crF     // Catch:{ all -> 0x0041 }
                if (r0 == 0) goto L_0x003f
                if (r3 < 0) goto L_0x003f
                int r0 = r2.mCount     // Catch:{ all -> 0x0041 }
                if (r3 < r0) goto L_0x0012
                goto L_0x003f
            L_0x0012:
                java.lang.Thread[] r0 = r2.crF     // Catch:{ all -> 0x0041 }
                r0 = r0[r3]     // Catch:{ all -> 0x0041 }
                java.lang.Thread[] r1 = r2.crF     // Catch:{ all -> 0x0041 }
                r1[r3] = r4     // Catch:{ all -> 0x0041 }
                if (r0 == 0) goto L_0x002d
                if (r5 == 0) goto L_0x0027
                boolean r5 = r0.isInterrupted()     // Catch:{ all -> 0x0041 }
                if (r5 != 0) goto L_0x0027
                r0.interrupt()     // Catch:{ Exception -> 0x0027 }
            L_0x0027:
                int r5 = r2.crE     // Catch:{ all -> 0x0041 }
                int r5 = r5 + -1
                r2.crE = r5     // Catch:{ all -> 0x0041 }
            L_0x002d:
                long[] r5 = r2.crJ     // Catch:{ all -> 0x0041 }
                long r0 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0041 }
                r5[r3] = r0     // Catch:{ all -> 0x0041 }
                if (r4 == 0) goto L_0x003d
                int r3 = r2.crE     // Catch:{ all -> 0x0041 }
                int r3 = r3 + 1
                r2.crE = r3     // Catch:{ all -> 0x0041 }
            L_0x003d:
                monitor-exit(r2)     // Catch:{ all -> 0x0041 }
                return
            L_0x003f:
                monitor-exit(r2)     // Catch:{ all -> 0x0041 }
                return
            L_0x0041:
                r3 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x0041 }
                throw r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.p321k.C7552c.C7553a.mo32426a(int, java.lang.Thread, boolean):void");
        }

        public long aaY() {
            synchronized (this) {
                long j = 0;
                if (this.crG == null) {
                    return 0;
                }
                for (int i = 0; i < this.mCount; i++) {
                    j += mo32436kp(i);
                }
                return j;
            }
        }

        public synchronized int abg() {
            return this.crE;
        }

        public long abh() {
            long j;
            synchronized (this) {
                j = 0;
                for (int i = 0; i < this.mCount; i++) {
                    j += mo32435ko(i);
                }
            }
            if (this.mCount == 0) {
                return 0;
            }
            return j;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0019, code lost:
            return;
         */
        /* renamed from: ci */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void mo32430ci(int r2, int r3) {
            /*
                r1 = this;
                monitor-enter(r1)
                boolean r0 = r1.crM     // Catch:{ all -> 0x001a }
                if (r0 == 0) goto L_0x0007
                monitor-exit(r1)     // Catch:{ all -> 0x001a }
                return
            L_0x0007:
                int[] r0 = r1.crL     // Catch:{ all -> 0x001a }
                if (r0 == 0) goto L_0x0018
                if (r2 < 0) goto L_0x0018
                int r0 = r1.mCount     // Catch:{ all -> 0x001a }
                if (r2 < r0) goto L_0x0012
                goto L_0x0018
            L_0x0012:
                int[] r0 = r1.crL     // Catch:{ all -> 0x001a }
                r0[r2] = r3     // Catch:{ all -> 0x001a }
                monitor-exit(r1)     // Catch:{ all -> 0x001a }
                return
            L_0x0018:
                monitor-exit(r1)     // Catch:{ all -> 0x001a }
                return
            L_0x001a:
                r2 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x001a }
                throw r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.p321k.C7552c.C7553a.mo32430ci(int, int):void");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0025, code lost:
            return;
         */
        /* renamed from: e */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void mo32431e(int r5, long r6) {
            /*
                r4 = this;
                monitor-enter(r4)
                boolean r0 = r4.crM     // Catch:{ all -> 0x0026 }
                if (r0 == 0) goto L_0x0007
                monitor-exit(r4)     // Catch:{ all -> 0x0026 }
                return
            L_0x0007:
                long[] r0 = r4.crK     // Catch:{ all -> 0x0026 }
                if (r0 == 0) goto L_0x0024
                if (r5 < 0) goto L_0x0024
                int r0 = r4.mCount     // Catch:{ all -> 0x0026 }
                if (r5 < r0) goto L_0x0012
                goto L_0x0024
            L_0x0012:
                long[] r0 = r4.crK     // Catch:{ all -> 0x0026 }
                r1 = r0[r5]     // Catch:{ all -> 0x0026 }
                r3 = 0
                long r1 = r1 + r6
                r0[r5] = r1     // Catch:{ all -> 0x0026 }
                long[] r6 = r4.crJ     // Catch:{ all -> 0x0026 }
                long r0 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0026 }
                r6[r5] = r0     // Catch:{ all -> 0x0026 }
                monitor-exit(r4)     // Catch:{ all -> 0x0026 }
                return
            L_0x0024:
                monitor-exit(r4)     // Catch:{ all -> 0x0026 }
                return
            L_0x0026:
                r5 = move-exception
                monitor-exit(r4)     // Catch:{ all -> 0x0026 }
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.p321k.C7552c.C7553a.mo32431e(int, long):void");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:16:0x001b, code lost:
            return 0;
         */
        /* renamed from: f */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public long mo32432f(int r4, long r5) {
            /*
                r3 = this;
                monitor-enter(r3)
                boolean r0 = r3.crM     // Catch:{ all -> 0x001c }
                r1 = 0
                if (r0 == 0) goto L_0x0009
                monitor-exit(r3)     // Catch:{ all -> 0x001c }
                return r1
            L_0x0009:
                long[] r0 = r3.crG     // Catch:{ all -> 0x001c }
                if (r0 == 0) goto L_0x001a
                if (r4 < 0) goto L_0x001a
                int r0 = r3.mCount     // Catch:{ all -> 0x001c }
                if (r4 < r0) goto L_0x0014
                goto L_0x001a
            L_0x0014:
                long[] r0 = r3.crH     // Catch:{ all -> 0x001c }
                r0[r4] = r5     // Catch:{ all -> 0x001c }
                monitor-exit(r3)     // Catch:{ all -> 0x001c }
                return r5
            L_0x001a:
                monitor-exit(r3)     // Catch:{ all -> 0x001c }
                return r1
            L_0x001c:
                r4 = move-exception
                monitor-exit(r3)     // Catch:{ all -> 0x001c }
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.p321k.C7552c.C7553a.mo32432f(int, long):long");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0019, code lost:
            return;
         */
        /* renamed from: g */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void mo32433g(int r2, long r3) {
            /*
                r1 = this;
                monitor-enter(r1)
                boolean r0 = r1.crM     // Catch:{ all -> 0x001a }
                if (r0 == 0) goto L_0x0007
                monitor-exit(r1)     // Catch:{ all -> 0x001a }
                return
            L_0x0007:
                long[] r0 = r1.crG     // Catch:{ all -> 0x001a }
                if (r0 == 0) goto L_0x0018
                if (r2 < 0) goto L_0x0018
                int r0 = r1.mCount     // Catch:{ all -> 0x001a }
                if (r2 < r0) goto L_0x0012
                goto L_0x0018
            L_0x0012:
                long[] r0 = r1.crG     // Catch:{ all -> 0x001a }
                r0[r2] = r3     // Catch:{ all -> 0x001a }
                monitor-exit(r1)     // Catch:{ all -> 0x001a }
                return
            L_0x0018:
                monitor-exit(r1)     // Catch:{ all -> 0x001a }
                return
            L_0x001a:
                r2 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x001a }
                throw r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.p321k.C7552c.C7553a.mo32433g(int, long):void");
        }

        public int getBlockCount() {
            return this.mCount;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:15:0x002a, code lost:
            return 0;
         */
        /* renamed from: ko */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public long mo32435ko(int r8) {
            /*
                r7 = this;
                monitor-enter(r7)
                long[] r0 = r7.crK     // Catch:{ all -> 0x002b }
                r1 = 0
                if (r0 == 0) goto L_0x0029
                if (r8 < 0) goto L_0x0029
                int r0 = r7.mCount     // Catch:{ all -> 0x002b }
                if (r8 < r0) goto L_0x000e
                goto L_0x0029
            L_0x000e:
                long[] r0 = r7.crJ     // Catch:{ all -> 0x002b }
                r3 = r0[r8]     // Catch:{ all -> 0x002b }
                long[] r0 = r7.crI     // Catch:{ all -> 0x002b }
                r5 = r0[r8]     // Catch:{ all -> 0x002b }
                r0 = 0
                long r3 = r3 - r5
                int r0 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
                if (r0 > 0) goto L_0x001e
                r3 = 1
            L_0x001e:
                long[] r0 = r7.crK     // Catch:{ all -> 0x002b }
                r1 = r0[r8]     // Catch:{ all -> 0x002b }
                r5 = 1000(0x3e8, double:4.94E-321)
                long r1 = r1 * r5
                long r1 = r1 / r3
                monitor-exit(r7)     // Catch:{ all -> 0x002b }
                return r1
            L_0x0029:
                monitor-exit(r7)     // Catch:{ all -> 0x002b }
                return r1
            L_0x002b:
                r8 = move-exception
                monitor-exit(r7)     // Catch:{ all -> 0x002b }
                throw r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.p321k.C7552c.C7553a.mo32435ko(int):long");
        }

        /* renamed from: kp */
        public long mo32436kp(int i) {
            synchronized (this) {
                if (this.crG != null && i >= 0) {
                    if (i < this.mCount) {
                        long j = this.crG[i] + this.crK[i];
                        return j;
                    }
                }
                return 0;
            }
        }

        public synchronized void release() {
            for (int i = 0; i < this.mCount; i++) {
                if (i < this.crF.length && this.crF[i] != null) {
                    this.crF[i].interrupt();
                }
                mo32426a(i, null, true);
            }
            this.crF = null;
            this.crM = true;
        }
    }

    public C7552c(String str, String str2, long j) {
        super(str, str2, j);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:23|24|25|26|27|28) */
    /* JADX WARNING: Can't wrap try/catch for region: R(7:31|32|(0)|(0)|52|53|54) */
    /* JADX WARNING: Can't wrap try/catch for region: R(9:34|33|(0)|(0)|63|64|65|66|67) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0084 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:52:0x00d4 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:63:0x00e3 */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00cc A[SYNTHETIC, Splitter:B:48:0x00cc] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00d1 A[Catch:{ IOException -> 0x00d4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00db A[SYNTHETIC, Splitter:B:59:0x00db] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00e0 A[Catch:{ IOException -> 0x00e3 }] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:63:0x00e3=Splitter:B:63:0x00e3, B:25:0x0084=Splitter:B:25:0x0084, B:52:0x00d4=Splitter:B:52:0x00d4, B:39:0x009d=Splitter:B:39:0x009d} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized boolean abf() {
        /*
            r15 = this;
            monitor-enter(r15)
            com.introvd.template.k.c$a r0 = r15.crD     // Catch:{ all -> 0x00e9 }
            int r0 = r0.getBlockCount()     // Catch:{ all -> 0x00e9 }
            r1 = 1
            r2 = 0
            if (r0 != r1) goto L_0x0029
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x00e9 }
            r0.<init>()     // Catch:{ all -> 0x00e9 }
            java.lang.String r1 = r15.crs     // Catch:{ all -> 0x00e9 }
            r0.append(r1)     // Catch:{ all -> 0x00e9 }
            java.lang.String r1 = ".part"
            r0.append(r1)     // Catch:{ all -> 0x00e9 }
            r0.append(r2)     // Catch:{ all -> 0x00e9 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x00e9 }
            java.lang.String r1 = r15.crs     // Catch:{ all -> 0x00e9 }
            boolean r0 = com.introvd.template.common.FileUtils.renameFile(r0, r1)     // Catch:{ all -> 0x00e9 }
            monitor-exit(r15)
            return r0
        L_0x0029:
            java.io.File r0 = new java.io.File     // Catch:{ all -> 0x00e9 }
            java.lang.String r3 = r15.crs     // Catch:{ all -> 0x00e9 }
            r0.<init>(r3)     // Catch:{ all -> 0x00e9 }
            r3 = 0
            java.io.BufferedOutputStream r4 = new java.io.BufferedOutputStream     // Catch:{ IOException -> 0x00d8, all -> 0x00c8 }
            java.io.FileOutputStream r5 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x00d8, all -> 0x00c8 }
            r5.<init>(r0, r2)     // Catch:{ IOException -> 0x00d8, all -> 0x00c8 }
            r4.<init>(r5)     // Catch:{ IOException -> 0x00d8, all -> 0x00c8 }
            r5 = 32768(0x8000, float:4.5918E-41)
            byte[] r5 = new byte[r5]     // Catch:{ IOException -> 0x00d9, all -> 0x00c6 }
            r6 = 0
        L_0x0041:
            com.introvd.template.k.c$a r7 = r15.crD     // Catch:{ IOException -> 0x00d9, all -> 0x00c6 }
            int r7 = r7.getBlockCount()     // Catch:{ IOException -> 0x00d9, all -> 0x00c6 }
            if (r6 >= r7) goto L_0x009a
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00d9, all -> 0x00c6 }
            r7.<init>()     // Catch:{ IOException -> 0x00d9, all -> 0x00c6 }
            java.lang.String r8 = r15.crs     // Catch:{ IOException -> 0x00d9, all -> 0x00c6 }
            r7.append(r8)     // Catch:{ IOException -> 0x00d9, all -> 0x00c6 }
            java.lang.String r8 = ".part"
            r7.append(r8)     // Catch:{ IOException -> 0x00d9, all -> 0x00c6 }
            r7.append(r6)     // Catch:{ IOException -> 0x00d9, all -> 0x00c6 }
            java.lang.String r7 = r7.toString()     // Catch:{ IOException -> 0x00d9, all -> 0x00c6 }
            java.io.File r8 = new java.io.File     // Catch:{ IOException -> 0x00d9, all -> 0x00c6 }
            r8.<init>(r7)     // Catch:{ IOException -> 0x00d9, all -> 0x00c6 }
            long r9 = r8.length()     // Catch:{ IOException -> 0x00d9, all -> 0x00c6 }
            r11 = 0
            java.io.BufferedInputStream r7 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x00d9, all -> 0x00c6 }
            java.io.FileInputStream r13 = new java.io.FileInputStream     // Catch:{ IOException -> 0x00d9, all -> 0x00c6 }
            r13.<init>(r8)     // Catch:{ IOException -> 0x00d9, all -> 0x00c6 }
            r7.<init>(r13)     // Catch:{ IOException -> 0x00d9, all -> 0x00c6 }
        L_0x0074:
            int r8 = (r11 > r9 ? 1 : (r11 == r9 ? 0 : -1))
            if (r8 >= 0) goto L_0x0094
            int r8 = r7.read(r5)     // Catch:{ IOException -> 0x0092, all -> 0x008f }
            if (r8 > 0) goto L_0x0089
            r4.close()     // Catch:{ IOException -> 0x0084 }
            r7.close()     // Catch:{ IOException -> 0x0084 }
        L_0x0084:
            r0.delete()     // Catch:{ all -> 0x00e9 }
            monitor-exit(r15)
            return r2
        L_0x0089:
            r4.write(r5, r2, r8)     // Catch:{ IOException -> 0x0092, all -> 0x008f }
            long r13 = (long) r8     // Catch:{ IOException -> 0x0092, all -> 0x008f }
            long r11 = r11 + r13
            goto L_0x0074
        L_0x008f:
            r1 = move-exception
            r3 = r7
            goto L_0x00ca
        L_0x0092:
            r3 = r7
            goto L_0x00d9
        L_0x0094:
            r7.close()     // Catch:{ IOException -> 0x0092, all -> 0x008f }
            int r6 = r6 + 1
            goto L_0x0041
        L_0x009a:
            r4.close()     // Catch:{ IOException -> 0x00d9, all -> 0x00c6 }
        L_0x009d:
            com.introvd.template.k.c$a r0 = r15.crD     // Catch:{ all -> 0x00e9 }
            int r0 = r0.getBlockCount()     // Catch:{ all -> 0x00e9 }
            if (r2 >= r0) goto L_0x00e7
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x00e9 }
            r0.<init>()     // Catch:{ all -> 0x00e9 }
            java.lang.String r3 = r15.crs     // Catch:{ all -> 0x00e9 }
            r0.append(r3)     // Catch:{ all -> 0x00e9 }
            java.lang.String r3 = ".part"
            r0.append(r3)     // Catch:{ all -> 0x00e9 }
            r0.append(r2)     // Catch:{ all -> 0x00e9 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x00e9 }
            java.io.File r3 = new java.io.File     // Catch:{ all -> 0x00e9 }
            r3.<init>(r0)     // Catch:{ all -> 0x00e9 }
            r3.delete()     // Catch:{ all -> 0x00e9 }
            int r2 = r2 + 1
            goto L_0x009d
        L_0x00c6:
            r1 = move-exception
            goto L_0x00ca
        L_0x00c8:
            r1 = move-exception
            r4 = r3
        L_0x00ca:
            if (r4 == 0) goto L_0x00cf
            r4.close()     // Catch:{ IOException -> 0x00d4 }
        L_0x00cf:
            if (r3 == 0) goto L_0x00d4
            r3.close()     // Catch:{ IOException -> 0x00d4 }
        L_0x00d4:
            r0.delete()     // Catch:{ all -> 0x00e9 }
            throw r1     // Catch:{ all -> 0x00e9 }
        L_0x00d8:
            r4 = r3
        L_0x00d9:
            if (r4 == 0) goto L_0x00de
            r4.close()     // Catch:{ IOException -> 0x00e3 }
        L_0x00de:
            if (r3 == 0) goto L_0x00e3
            r3.close()     // Catch:{ IOException -> 0x00e3 }
        L_0x00e3:
            r0.delete()     // Catch:{ all -> 0x00e9 }
            r1 = 0
        L_0x00e7:
            monitor-exit(r15)
            return r1
        L_0x00e9:
            r0 = move-exception
            monitor-exit(r15)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.p321k.C7552c.abf():boolean");
    }

    /* renamed from: b */
    private synchronized void m22301b(int i, int i2, int i3, Object obj) {
        if (this.crw != null) {
            this.crw.onEvent(0, i, (long) i2, (long) i3, obj);
        }
        String simpleName = C7552c.class.getSimpleName();
        StringBuilder sb = new StringBuilder();
        sb.append("notifyUp event:");
        sb.append(i);
        LogUtils.m14222e(simpleName, sb.toString());
    }

    private boolean connect() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.crs);
        sb.append(".part");
        sb.append(0);
        C7550b bVar = new C7550b(0, this.crr, sb.toString(), 0, -1, this);
        this.crB = bVar;
        this.crB.start();
        return true;
    }

    public long aaY() {
        this.cro = this.crD == null ? 0 : this.crD.aaY();
        return super.aaY();
    }

    public long aba() {
        this.crq = this.crD == null ? 0 : this.crD.abh();
        return super.aba();
    }

    /* JADX WARNING: Removed duplicated region for block: B:56:0x0140  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long onEvent(int r30, int r31, long r32, long r34, java.lang.Object r36) {
        /*
            r29 = this;
            r10 = r29
            r0 = r30
            r1 = r31
            r2 = r32
            r4 = r36
            r13 = 0
            r9 = 0
            switch(r1) {
                case 1: goto L_0x017d;
                case 2: goto L_0x0151;
                case 3: goto L_0x0121;
                case 4: goto L_0x0013;
                case 5: goto L_0x0121;
                default: goto L_0x0010;
            }
        L_0x0010:
            r0 = r13
            goto L_0x0196
        L_0x0013:
            r10.crp = r2
            r0 = 4
            long r1 = r10.crp
            int r1 = (int) r1
            r10.m22301b(r0, r1, r9, r10)
            long r7 = r10.crp
            r0 = 1
            r2 = 4194304(0x400000, double:2.0722615E-317)
            int r4 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r4 <= 0) goto L_0x002d
            long r0 = r7 / r0
            r16 = r0
            r0 = 1
            goto L_0x0035
        L_0x002d:
            r4 = 0
            long r4 = r7 + r2
            long r4 = r4 - r0
            long r4 = r4 / r2
            int r0 = (int) r4
            r16 = r2
        L_0x0035:
            int r5 = r0 + -1
            long r1 = (long) r5
            long r1 = r1 * r16
            long r18 = r7 - r1
            monitor-enter(r29)
            com.introvd.template.k.c$a r1 = new com.introvd.template.k.c$a     // Catch:{ all -> 0x011e }
            r1.<init>(r0)     // Catch:{ all -> 0x011e }
            r10.crD = r1     // Catch:{ all -> 0x011e }
            r1 = r13
            r6 = 0
            r20 = 0
        L_0x0048:
            if (r6 >= r0) goto L_0x00e1
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x011e }
            r3.<init>()     // Catch:{ all -> 0x011e }
            java.lang.String r4 = r10.crs     // Catch:{ all -> 0x011e }
            r3.append(r4)     // Catch:{ all -> 0x011e }
            java.lang.String r4 = ".part"
            r3.append(r4)     // Catch:{ all -> 0x011e }
            r3.append(r6)     // Catch:{ all -> 0x011e }
            java.lang.String r4 = r3.toString()     // Catch:{ all -> 0x011e }
            java.io.File r3 = new java.io.File     // Catch:{ all -> 0x011e }
            r3.<init>(r4)     // Catch:{ all -> 0x011e }
            long r21 = r3.length()     // Catch:{ all -> 0x011e }
            if (r6 != r5) goto L_0x006e
            r23 = r18
            goto L_0x0070
        L_0x006e:
            r23 = r16
        L_0x0070:
            int r25 = (r21 > r23 ? 1 : (r21 == r23 ? 0 : -1))
            if (r25 <= 0) goto L_0x0079
            r3.delete()     // Catch:{ all -> 0x011e }
            r11 = r13
            goto L_0x007b
        L_0x0079:
            r11 = r21
        L_0x007b:
            r3 = 0
            long r21 = r1 + r11
            if (r6 != 0) goto L_0x008d
            int r1 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r1 != 0) goto L_0x008d
            r25 = r5
            r15 = r6
            r26 = r7
            r13 = 0
            r20 = 1
            goto L_0x00d4
        L_0x008d:
            long r1 = (long) r6     // Catch:{ all -> 0x011e }
            long r1 = r1 * r16
            long r26 = r1 + r11
            long r2 = r23 - r11
            com.introvd.template.k.c$a r1 = r10.crD     // Catch:{ all -> 0x011e }
            r1.mo32432f(r6, r2)     // Catch:{ all -> 0x011e }
            int r1 = (r2 > r13 ? 1 : (r2 == r13 ? 0 : -1))
            if (r1 == 0) goto L_0x00c9
            com.introvd.template.k.b r1 = new com.introvd.template.k.b     // Catch:{ all -> 0x011e }
            java.lang.String r9 = r10.crr     // Catch:{ all -> 0x011e }
            r28 = r1
            r1 = r28
            r23 = r2
            r2 = r6
            r3 = r9
            r25 = r5
            r9 = r6
            r5 = r26
            r26 = r7
            r7 = r23
            r15 = r9
            r13 = 0
            r9 = r29
            r1.<init>(r2, r3, r4, r5, r7, r9)     // Catch:{ all -> 0x011e }
            com.introvd.template.k.c$a r1 = r10.crD     // Catch:{ all -> 0x011e }
            r2 = r28
            r1.mo32426a(r15, r2, r13)     // Catch:{ all -> 0x011e }
            com.introvd.template.k.c$a r1 = r10.crD     // Catch:{ all -> 0x011e }
            r1.mo32433g(r15, r11)     // Catch:{ all -> 0x011e }
            r2.start()     // Catch:{ all -> 0x011e }
            goto L_0x00d4
        L_0x00c9:
            r25 = r5
            r15 = r6
            r26 = r7
            r13 = 0
            com.introvd.template.k.c$a r1 = r10.crD     // Catch:{ all -> 0x011e }
            r1.mo32433g(r15, r11)     // Catch:{ all -> 0x011e }
        L_0x00d4:
            int r6 = r15 + 1
            r1 = r21
            r5 = r25
            r7 = r26
            r9 = 0
            r13 = 0
            goto L_0x0048
        L_0x00e1:
            r26 = r7
            r13 = 0
            if (r20 == 0) goto L_0x0104
            int r0 = (r26 > r16 ? 1 : (r26 == r16 ? 0 : -1))
            if (r0 > 0) goto L_0x00ed
            r0 = r26
            goto L_0x00ef
        L_0x00ed:
            r0 = r16
        L_0x00ef:
            com.introvd.template.k.c$a r2 = r10.crD     // Catch:{ all -> 0x011e }
            r2.mo32432f(r13, r0)     // Catch:{ all -> 0x011e }
            com.introvd.template.k.c$a r2 = r10.crD     // Catch:{ all -> 0x011e }
            r3 = 0
            r2.mo32433g(r13, r3)     // Catch:{ all -> 0x011e }
            com.introvd.template.k.c$a r2 = r10.crD     // Catch:{ all -> 0x011e }
            com.introvd.template.k.b r3 = r10.crB     // Catch:{ all -> 0x011e }
            r2.mo32426a(r13, r3, r13)     // Catch:{ all -> 0x011e }
            monitor-exit(r29)     // Catch:{ all -> 0x011e }
            return r0
        L_0x0104:
            r0 = 0
            r10.crB = r0     // Catch:{ all -> 0x011e }
            long r3 = r10.crp     // Catch:{ all -> 0x011e }
            r5 = 0
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 <= 0) goto L_0x011c
            long r3 = r10.crp     // Catch:{ all -> 0x011e }
            int r0 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r0 != 0) goto L_0x011c
            r29.abf()     // Catch:{ all -> 0x011e }
            r0 = 2
            r10.m22301b(r0, r13, r13, r10)     // Catch:{ all -> 0x011e }
        L_0x011c:
            monitor-exit(r29)     // Catch:{ all -> 0x011e }
            goto L_0x0182
        L_0x011e:
            r0 = move-exception
            monitor-exit(r29)     // Catch:{ all -> 0x011e }
            throw r0
        L_0x0121:
            r13 = 0
            com.introvd.template.k.c$a r5 = r10.crD
            if (r5 == 0) goto L_0x013d
            com.introvd.template.k.c$a r5 = r10.crD
            r6 = 0
            r5.mo32426a(r0, r6, r13)
            com.introvd.template.k.c$a r5 = r10.crD
            int r6 = (int) r2
            r5.mo32430ci(r0, r6)
            com.introvd.template.k.c$a r0 = r10.crD
            int r0 = r0.abg()
            if (r0 != 0) goto L_0x013b
            goto L_0x013d
        L_0x013b:
            r15 = 0
            goto L_0x013e
        L_0x013d:
            r15 = 1
        L_0x013e:
            if (r15 == 0) goto L_0x0182
            boolean r0 = r4 instanceof java.lang.Throwable
            if (r0 == 0) goto L_0x0149
            r0 = r4
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            r10.crv = r0
        L_0x0149:
            int r0 = (int) r2
            r2 = r34
            int r2 = (int) r2
            r10.m22301b(r1, r0, r2, r10)
            goto L_0x0182
        L_0x0151:
            r13 = 0
            com.introvd.template.k.c$a r1 = r10.crD
            if (r1 != 0) goto L_0x0157
            goto L_0x0182
        L_0x0157:
            com.introvd.template.k.c$a r1 = r10.crD
            r2 = 0
            r1.mo32426a(r0, r2, r13)
            com.introvd.template.k.c$a r0 = r10.crD
            int r0 = r0.abg()
            if (r0 != 0) goto L_0x0182
            long r0 = r29.aaY()
            long r2 = r10.crp
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 != 0) goto L_0x0177
            r29.abf()
            r0 = 2
            r10.m22301b(r0, r13, r13, r10)
            goto L_0x0182
        L_0x0177:
            r0 = 3
            r1 = 1
            r10.m22301b(r0, r1, r13, r10)
            goto L_0x0182
        L_0x017d:
            r13 = 0
            com.introvd.template.k.c$a r1 = r10.crD
            if (r1 != 0) goto L_0x0185
        L_0x0182:
            r0 = 0
            goto L_0x0196
        L_0x0185:
            com.introvd.template.k.c$a r1 = r10.crD
            monitor-enter(r1)
            com.introvd.template.k.c$a r4 = r10.crD     // Catch:{ all -> 0x0193 }
            r4.mo32431e(r0, r2)     // Catch:{ all -> 0x0193 }
            r0 = 1
            r10.m22301b(r0, r13, r13, r10)     // Catch:{ all -> 0x0193 }
            monitor-exit(r1)     // Catch:{ all -> 0x0193 }
            goto L_0x0182
        L_0x0193:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0193 }
            throw r0
        L_0x0196:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.p321k.C7552c.onEvent(int, int, long, long, java.lang.Object):long");
    }

    public boolean start() {
        return connect();
    }

    public boolean stop() {
        try {
            if (this.crD != null) {
                this.crD.release();
            }
            if (this.crB != null) {
                this.crB.interrupt();
            }
        } catch (Exception unused) {
        }
        return true;
    }
}
