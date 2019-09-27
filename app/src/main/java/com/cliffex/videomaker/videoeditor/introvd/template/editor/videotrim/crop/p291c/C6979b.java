package com.introvd.template.editor.videotrim.crop.p291c;

import com.introvd.template.editor.videotrim.crop.p290b.C6974c;

/* renamed from: com.introvd.template.editor.videotrim.crop.c.b */
public class C6979b {
    /* renamed from: a */
    public static C6974c m20410a(float f, float f2, float f3, float f4, float f5, float f6, float f7) {
        C6974c cVar;
        float p = C6981c.m20415p(f, f2, f3, f4);
        if (p < Float.POSITIVE_INFINITY) {
            cVar = C6974c.TOP_LEFT;
        } else {
            cVar = null;
            p = Float.POSITIVE_INFINITY;
        }
        float p2 = C6981c.m20415p(f, f2, f5, f4);
        if (p2 < p) {
            cVar = C6974c.TOP_RIGHT;
            p = p2;
        }
        float p3 = C6981c.m20415p(f, f2, f3, f6);
        if (p3 < p) {
            cVar = C6974c.BOTTOM_LEFT;
            p = p3;
        }
        float p4 = C6981c.m20415p(f, f2, f5, f6);
        if (p4 < p) {
            cVar = C6974c.BOTTOM_RIGHT;
            p = p4;
        }
        if (p <= f7) {
            return cVar;
        }
        if (m20412b(f, f2, f3, f5, f4, f7)) {
            return C6974c.TOP;
        }
        if (m20412b(f, f2, f3, f5, f6, f7)) {
            return C6974c.BOTTOM;
        }
        if (m20413c(f, f2, f3, f4, f6, f7)) {
            return C6974c.LEFT;
        }
        if (m20413c(f, f2, f5, f4, f6, f7)) {
            return C6974c.RIGHT;
        }
        if (m20414d(f, f2, f3, f4, f5, f6)) {
            return C6974c.CENTER;
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0039, code lost:
        r8.x = r0;
        r8.y = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003d, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0024, code lost:
        r0 = r1;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void m20411a(com.introvd.template.editor.videotrim.crop.p290b.C6974c r1, float r2, float r3, float r4, float r5, float r6, float r7, android.graphics.PointF r8) {
        /*
            int[] r0 = com.introvd.template.editor.videotrim.crop.p291c.C6979b.C69801.dmR
            int r1 = r1.ordinal()
            r1 = r0[r1]
            r0 = 0
            switch(r1) {
                case 1: goto L_0x0035;
                case 2: goto L_0x0030;
                case 3: goto L_0x002b;
                case 4: goto L_0x0026;
                case 5: goto L_0x0022;
                case 6: goto L_0x001f;
                case 7: goto L_0x001c;
                case 8: goto L_0x0019;
                case 9: goto L_0x000e;
                default: goto L_0x000c;
            }
        L_0x000c:
            r1 = 0
            goto L_0x0039
        L_0x000e:
            float r6 = r6 + r4
            r1 = 1073741824(0x40000000, float:2.0)
            float r6 = r6 / r1
            float r5 = r5 + r7
            float r5 = r5 / r1
            float r0 = r6 - r2
            float r1 = r5 - r3
            goto L_0x0039
        L_0x0019:
            float r1 = r7 - r3
            goto L_0x0039
        L_0x001c:
            float r1 = r6 - r2
            goto L_0x0024
        L_0x001f:
            float r1 = r5 - r3
            goto L_0x0039
        L_0x0022:
            float r1 = r4 - r2
        L_0x0024:
            r0 = r1
            goto L_0x000c
        L_0x0026:
            float r0 = r6 - r2
            float r1 = r7 - r3
            goto L_0x0039
        L_0x002b:
            float r0 = r4 - r2
            float r1 = r7 - r3
            goto L_0x0039
        L_0x0030:
            float r0 = r6 - r2
            float r1 = r5 - r3
            goto L_0x0039
        L_0x0035:
            float r0 = r4 - r2
            float r1 = r5 - r3
        L_0x0039:
            r8.x = r0
            r8.y = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.editor.videotrim.crop.p291c.C6979b.m20411a(com.introvd.template.editor.videotrim.crop.b.c, float, float, float, float, float, float, android.graphics.PointF):void");
    }

    /* renamed from: b */
    private static boolean m20412b(float f, float f2, float f3, float f4, float f5, float f6) {
        return f > f3 && f < f4 && Math.abs(f2 - f5) <= f6;
    }

    /* renamed from: c */
    private static boolean m20413c(float f, float f2, float f3, float f4, float f5, float f6) {
        return Math.abs(f - f3) <= f6 && f2 > f4 && f2 < f5;
    }

    /* renamed from: d */
    private static boolean m20414d(float f, float f2, float f3, float f4, float f5, float f6) {
        return f >= f3 && f <= f5 && f2 >= f4 && f2 <= f6;
    }
}
