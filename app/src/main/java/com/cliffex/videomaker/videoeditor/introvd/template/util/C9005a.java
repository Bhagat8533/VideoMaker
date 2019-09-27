package com.introvd.template.util;

import android.content.Context;
import com.introvd.template.common.FileUtils;
import com.introvd.template.common.LogUtils;
import com.xiaoying.p448a.C9537b.C9538a;
import java.lang.ref.WeakReference;

/* renamed from: com.introvd.template.util.a */
public class C9005a implements C9538a {
    WeakReference<Context> ezP = null;
    private final boolean ezQ;
    private final String ezR;

    public C9005a(Context context, String str) {
        this.ezP = new WeakReference<>(context);
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("netlog.txt");
        this.ezR = sb.toString();
        this.ezQ = FileUtils.isFileExisted(this.ezR);
        FileUtils.deleteFile(this.ezR);
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0026 A[SYNTHETIC, Splitter:B:16:0x0026] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0031 A[SYNTHETIC, Splitter:B:21:0x0031] */
    /* JADX WARNING: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /* renamed from: bi */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m26421bi(java.lang.String r6, java.lang.String r7) {
        /*
            r5 = this;
            r0 = 0
            java.io.BufferedWriter r1 = new java.io.BufferedWriter     // Catch:{ Exception -> 0x0020 }
            java.io.OutputStreamWriter r2 = new java.io.OutputStreamWriter     // Catch:{ Exception -> 0x0020 }
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0020 }
            r4 = 1
            r3.<init>(r6, r4)     // Catch:{ Exception -> 0x0020 }
            r2.<init>(r3)     // Catch:{ Exception -> 0x0020 }
            r1.<init>(r2)     // Catch:{ Exception -> 0x0020 }
            r1.write(r7)     // Catch:{ Exception -> 0x001b, all -> 0x0018 }
            r1.close()     // Catch:{ Exception -> 0x002a }
            goto L_0x002e
        L_0x0018:
            r6 = move-exception
            r0 = r1
            goto L_0x002f
        L_0x001b:
            r6 = move-exception
            r0 = r1
            goto L_0x0021
        L_0x001e:
            r6 = move-exception
            goto L_0x002f
        L_0x0020:
            r6 = move-exception
        L_0x0021:
            r6.printStackTrace()     // Catch:{ all -> 0x001e }
            if (r0 == 0) goto L_0x002e
            r0.close()     // Catch:{ Exception -> 0x002a }
            goto L_0x002e
        L_0x002a:
            r6 = move-exception
            r6.printStackTrace()
        L_0x002e:
            return
        L_0x002f:
            if (r0 == 0) goto L_0x0039
            r0.close()     // Catch:{ Exception -> 0x0035 }
            goto L_0x0039
        L_0x0035:
            r7 = move-exception
            r7.printStackTrace()
        L_0x0039:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.util.C9005a.m26421bi(java.lang.String, java.lang.String):void");
    }

    /* renamed from: bh */
    public final synchronized void mo35786bh(String str, String str2) {
        if (((Context) this.ezP.get()) != null) {
            LogUtils.m14222e(str, str2);
            try {
                if (this.ezQ) {
                    m26421bi(this.ezR, str2);
                    m26421bi(this.ezR, "\r\n");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            return;
        }
        return;
    }
}
