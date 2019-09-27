package com.introvd.template.sdk.utils;

import java.util.Properties;

/* renamed from: com.introvd.template.sdk.utils.h */
public class C8552h {
    private Properties egP;

    public C8552h() {
        this.egP = null;
        this.egP = new Properties();
    }

    public String get(String str) {
        return this.egP.getProperty(str, "");
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x002f A[SYNTHETIC, Splitter:B:19:0x002f] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x003c A[SYNTHETIC, Splitter:B:27:0x003c] */
    /* renamed from: oe */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo34799oe(java.lang.String r3) {
        /*
            r2 = this;
            java.io.File r0 = new java.io.File
            r0.<init>(r3)
            boolean r3 = r0.exists()
            if (r3 == 0) goto L_0x0045
            boolean r3 = r0.isFile()
            if (r3 != 0) goto L_0x0012
            goto L_0x0045
        L_0x0012:
            r3 = 0
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ IOException -> 0x0027, all -> 0x0023 }
            r1.<init>(r0)     // Catch:{ IOException -> 0x0027, all -> 0x0023 }
            java.util.Properties r3 = r2.egP     // Catch:{ IOException -> 0x0021 }
            r3.load(r1)     // Catch:{ IOException -> 0x0021 }
            r1.close()     // Catch:{ IOException -> 0x0033 }
            goto L_0x0037
        L_0x0021:
            r3 = move-exception
            goto L_0x002a
        L_0x0023:
            r0 = move-exception
            r1 = r3
            r3 = r0
            goto L_0x003a
        L_0x0027:
            r0 = move-exception
            r1 = r3
            r3 = r0
        L_0x002a:
            r3.printStackTrace()     // Catch:{ all -> 0x0039 }
            if (r1 == 0) goto L_0x0037
            r1.close()     // Catch:{ IOException -> 0x0033 }
            goto L_0x0037
        L_0x0033:
            r3 = move-exception
            r3.printStackTrace()
        L_0x0037:
            r3 = 1
            return r3
        L_0x0039:
            r3 = move-exception
        L_0x003a:
            if (r1 == 0) goto L_0x0044
            r1.close()     // Catch:{ IOException -> 0x0040 }
            goto L_0x0044
        L_0x0040:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0044:
            throw r3
        L_0x0045:
            r3 = 0
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.sdk.utils.C8552h.mo34799oe(java.lang.String):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0027 A[SYNTHETIC, Splitter:B:16:0x0027] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0033 A[SYNTHETIC, Splitter:B:23:0x0033] */
    /* renamed from: of */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo34800of(java.lang.String r3) {
        /*
            r2 = this;
            java.io.File r0 = new java.io.File
            r0.<init>(r3)
            r3 = 0
            r0.createNewFile()     // Catch:{ IOException -> 0x0021 }
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0021 }
            r1.<init>(r0)     // Catch:{ IOException -> 0x0021 }
            java.util.Properties r0 = r2.egP     // Catch:{ IOException -> 0x001b, all -> 0x0017 }
            r0.save(r1, r3)     // Catch:{ IOException -> 0x001b, all -> 0x0017 }
            r1.close()     // Catch:{ IOException -> 0x002b }
            goto L_0x002f
        L_0x0017:
            r3 = move-exception
            r0 = r3
            r3 = r1
            goto L_0x0031
        L_0x001b:
            r3 = move-exception
            r0 = r3
            r3 = r1
            goto L_0x0022
        L_0x001f:
            r0 = move-exception
            goto L_0x0031
        L_0x0021:
            r0 = move-exception
        L_0x0022:
            r0.printStackTrace()     // Catch:{ all -> 0x001f }
            if (r3 == 0) goto L_0x002f
            r3.close()     // Catch:{ IOException -> 0x002b }
            goto L_0x002f
        L_0x002b:
            r3 = move-exception
            r3.printStackTrace()
        L_0x002f:
            r3 = 1
            return r3
        L_0x0031:
            if (r3 == 0) goto L_0x003b
            r3.close()     // Catch:{ IOException -> 0x0037 }
            goto L_0x003b
        L_0x0037:
            r3 = move-exception
            r3.printStackTrace()
        L_0x003b:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.sdk.utils.C8552h.mo34800of(java.lang.String):boolean");
    }

    public void set(String str, String str2) {
        if (str2 == null) {
            this.egP.remove(str);
        } else {
            this.egP.setProperty(str, str2);
        }
    }
}
