package com.introvd.template.component.videofetcher.utils;

import android.content.Context;
import android.widget.Toast;
import java.lang.ref.WeakReference;

/* renamed from: com.introvd.template.component.videofetcher.utils.l */
public class C5498l {
    static Toast bql = null;
    static String ccP = "";
    static WeakReference<Thread> ccQ;

    public static void show(Context context, int i, int i2) {
        if (context != null) {
            try {
                show(context, context.getString(i), i2, 17);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x002e A[Catch:{ Exception -> 0x003a }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void show(android.content.Context r2, java.lang.String r3, int r4, int r5) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r3)
            if (r0 == 0) goto L_0x0007
            return
        L_0x0007:
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            ccP = r3     // Catch:{ Exception -> 0x003a }
            android.widget.Toast r1 = bql     // Catch:{ Exception -> 0x003a }
            if (r1 == 0) goto L_0x0024
            java.lang.ref.WeakReference<java.lang.Thread> r1 = ccQ     // Catch:{ Exception -> 0x003a }
            if (r1 == 0) goto L_0x0024
            java.lang.ref.WeakReference<java.lang.Thread> r1 = ccQ     // Catch:{ Exception -> 0x003a }
            java.lang.Object r1 = r1.get()     // Catch:{ Exception -> 0x003a }
            if (r1 == r0) goto L_0x001e
            goto L_0x0024
        L_0x001e:
            android.widget.Toast r2 = bql     // Catch:{ Exception -> 0x003a }
            r2.setText(r3)     // Catch:{ Exception -> 0x003a }
            goto L_0x002a
        L_0x0024:
            android.widget.Toast r2 = android.widget.Toast.makeText(r2, r3, r4)     // Catch:{ Exception -> 0x003a }
            bql = r2     // Catch:{ Exception -> 0x003a }
        L_0x002a:
            android.widget.Toast r2 = bql     // Catch:{ Exception -> 0x003a }
            if (r2 == 0) goto L_0x003e
            android.widget.Toast r2 = bql     // Catch:{ Exception -> 0x003a }
            r3 = 0
            r2.setGravity(r5, r3, r3)     // Catch:{ Exception -> 0x003a }
            android.widget.Toast r2 = bql     // Catch:{ Exception -> 0x003a }
            r2.show()     // Catch:{ Exception -> 0x003a }
            goto L_0x003e
        L_0x003a:
            r2 = move-exception
            r2.printStackTrace()
        L_0x003e:
            java.lang.ref.WeakReference r2 = new java.lang.ref.WeakReference
            r2.<init>(r0)
            ccQ = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.component.videofetcher.utils.C5498l.show(android.content.Context, java.lang.String, int, int):void");
    }
}
