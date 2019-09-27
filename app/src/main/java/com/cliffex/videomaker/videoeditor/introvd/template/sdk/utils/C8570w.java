package com.introvd.template.sdk.utils;

/* renamed from: com.introvd.template.sdk.utils.w */
public class C8570w {
    private static String appVersion = "";

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0022, code lost:
        if (r3.length() <= 0) goto L_0x0024;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getAppVersion(android.content.Context r3) {
        /*
            java.lang.String r0 = appVersion
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x000b
            java.lang.String r3 = appVersion
            return r3
        L_0x000b:
            java.lang.String r0 = "0"
            android.content.pm.PackageManager r1 = r3.getPackageManager()     // Catch:{ Exception -> 0x0027 }
            java.lang.String r3 = r3.getPackageName()     // Catch:{ Exception -> 0x0027 }
            r2 = 0
            android.content.pm.PackageInfo r3 = r1.getPackageInfo(r3, r2)     // Catch:{ Exception -> 0x0027 }
            java.lang.String r3 = r3.versionName     // Catch:{ Exception -> 0x0027 }
            if (r3 == 0) goto L_0x0024
            int r0 = r3.length()     // Catch:{ Exception -> 0x0028 }
            if (r0 > 0) goto L_0x0028
        L_0x0024:
            java.lang.String r0 = "0"
            return r0
        L_0x0027:
            r3 = r0
        L_0x0028:
            appVersion = r3
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.sdk.utils.C8570w.getAppVersion(android.content.Context):java.lang.String");
    }
}
