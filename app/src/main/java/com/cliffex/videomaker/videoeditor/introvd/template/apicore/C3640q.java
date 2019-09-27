package com.introvd.template.apicore;

import java.io.EOFException;
import java.io.IOException;
import java.nio.charset.Charset;
import okhttp3.C9802ac;
import okhttp3.C9804ad;
import okhttp3.C9945u;
import okhttp3.C9947v;
import p468e.C9655c;
import p468e.C9659e;

/* renamed from: com.introvd.template.apicore.q */
public class C3640q implements C9945u {
    private static final Charset UTF8 = Charset.forName("UTF-8");

    /* renamed from: a */
    private String m8920a(C9802ac acVar) {
        C9804ad aXh = acVar.aXh();
        if (!(aXh == null || acVar.aTm() == 200)) {
            C9659e source = aXh.source();
            try {
                source.mo37316co(Long.MAX_VALUE);
            } catch (IOException e) {
                e.printStackTrace();
            }
            C9655c aYT = source.aYT();
            Charset charset = UTF8;
            C9947v contentType = aXh.contentType();
            if (contentType != null) {
                charset = contentType.mo38188b(UTF8);
            }
            if (m8921a(aYT) && charset != null) {
                return new String(aYT.clone().mo37335nW(), charset);
            }
        }
        return null;
    }

    /* renamed from: a */
    private static boolean m8921a(C9655c cVar) {
        try {
            C9655c cVar2 = new C9655c();
            cVar.mo37288a(cVar2, 0, cVar.size() < 64 ? cVar.size() : 64);
            int i = 0;
            while (true) {
                if (i >= 16) {
                    break;
                } else if (cVar2.aYW()) {
                    break;
                } else {
                    int aZe = cVar2.aZe();
                    if (Character.isISOControl(aZe) && !Character.isWhitespace(aZe)) {
                        return false;
                    }
                    i++;
                }
            }
            return true;
        } catch (EOFException unused) {
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x00e9  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0134  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public okhttp3.C9802ac intercept(okhttp3.C9945u.C9946a r14) throws java.io.IOException {
        /*
            r13 = this;
            com.introvd.template.apicore.t r0 = com.introvd.template.apicore.C3642t.m8923GZ()
            com.introvd.template.apicore.s r0 = r0.mo22986Ha()
            okhttp3.aa r1 = r14.aVO()
            r2 = 0
            if (r0 != 0) goto L_0x0033
            okhttp3.ac r14 = r14.mo37939c(r1)
            com.introvd.template.apicore.g r0 = com.introvd.template.apicore.C3629g.m8896GS()
            com.introvd.template.apicore.f r0 = r0.mo22969GT()
            if (r0 == 0) goto L_0x0032
            java.lang.String r0 = r13.m8920a(r14)
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 != 0) goto L_0x0032
            com.introvd.template.apicore.g r1 = com.introvd.template.apicore.C3629g.m8896GS()
            com.introvd.template.apicore.f r1 = r1.mo22969GT()
            r1.mo22968a(r2, r0)
        L_0x0032:
            return r14
        L_0x0033:
            com.introvd.template.apicore.p r3 = new com.introvd.template.apicore.p
            r3.<init>()
            long r4 = java.lang.System.nanoTime()
            java.lang.String r6 = r1.aTz()     // Catch:{ Throwable -> 0x00dd }
            r3.method = r6     // Catch:{ Throwable -> 0x00dd }
            okhttp3.t r6 = r1.aVr()     // Catch:{ Throwable -> 0x00dd }
            java.lang.String r6 = r6.toString()     // Catch:{ Throwable -> 0x00dd }
            r3.url = r6     // Catch:{ Throwable -> 0x00dd }
            okhttp3.ab r6 = r1.aWZ()     // Catch:{ Throwable -> 0x00dd }
            if (r6 == 0) goto L_0x0054
            r7 = 1
            goto L_0x0055
        L_0x0054:
            r7 = 0
        L_0x0055:
            if (r7 == 0) goto L_0x0084
            e.c r7 = new e.c     // Catch:{ Throwable -> 0x00dd }
            r7.<init>()     // Catch:{ Throwable -> 0x00dd }
            r6.writeTo(r7)     // Catch:{ Throwable -> 0x00dd }
            java.nio.charset.Charset r8 = UTF8     // Catch:{ Throwable -> 0x00dd }
            okhttp3.v r6 = r6.contentType()     // Catch:{ Throwable -> 0x00dd }
            if (r6 == 0) goto L_0x006d
            java.nio.charset.Charset r8 = UTF8     // Catch:{ Throwable -> 0x00dd }
            java.nio.charset.Charset r8 = r6.mo38188b(r8)     // Catch:{ Throwable -> 0x00dd }
        L_0x006d:
            boolean r6 = m8921a(r7)     // Catch:{ Throwable -> 0x00dd }
            if (r6 == 0) goto L_0x0084
            if (r8 == 0) goto L_0x0084
            java.lang.String r6 = new java.lang.String     // Catch:{ Throwable -> 0x00dd }
            byte[] r7 = r7.mo37335nW()     // Catch:{ Throwable -> 0x00dd }
            r6.<init>(r7, r8)     // Catch:{ Throwable -> 0x00dd }
            java.lang.String r6 = java.net.URLDecoder.decode(r6)     // Catch:{ Throwable -> 0x00dd }
            r3.bhD = r6     // Catch:{ Throwable -> 0x00dd }
        L_0x0084:
            long r6 = java.lang.System.nanoTime()     // Catch:{ Throwable -> 0x00dd }
            okhttp3.ac r4 = r14.mo37939c(r1)     // Catch:{ Throwable -> 0x00d9 }
            java.util.concurrent.TimeUnit r5 = java.util.concurrent.TimeUnit.NANOSECONDS     // Catch:{ Throwable -> 0x00d7 }
            long r8 = java.lang.System.nanoTime()     // Catch:{ Throwable -> 0x00d7 }
            r10 = 0
            long r8 = r8 - r6
            long r8 = r5.toMillis(r8)     // Catch:{ Throwable -> 0x00d7 }
            r3.bhE = r8     // Catch:{ Throwable -> 0x00d7 }
            int r5 = r4.aTm()     // Catch:{ Throwable -> 0x00d7 }
            r3.statusCode = r5     // Catch:{ Throwable -> 0x00d7 }
            java.lang.String r5 = r13.m8920a(r4)     // Catch:{ JSONException -> 0x00cf }
            boolean r8 = android.text.TextUtils.isEmpty(r5)     // Catch:{ JSONException -> 0x00cf }
            if (r8 != 0) goto L_0x00d3
            org.json.JSONObject r8 = new org.json.JSONObject     // Catch:{ JSONException -> 0x00cf }
            r8.<init>(r5)     // Catch:{ JSONException -> 0x00cf }
            java.lang.String r9 = "errorCode"
            int r8 = r8.optInt(r9)     // Catch:{ JSONException -> 0x00cf }
            r3.errorCode = r8     // Catch:{ JSONException -> 0x00cf }
            r3.errorMsg = r5     // Catch:{ JSONException -> 0x00cf }
            com.introvd.template.apicore.g r8 = com.introvd.template.apicore.C3629g.m8896GS()     // Catch:{ JSONException -> 0x00cf }
            com.introvd.template.apicore.f r8 = r8.mo22969GT()     // Catch:{ JSONException -> 0x00cf }
            if (r8 == 0) goto L_0x00d3
            com.introvd.template.apicore.g r8 = com.introvd.template.apicore.C3629g.m8896GS()     // Catch:{ JSONException -> 0x00cf }
            com.introvd.template.apicore.f r8 = r8.mo22969GT()     // Catch:{ JSONException -> 0x00cf }
            r8.mo22968a(r2, r5)     // Catch:{ JSONException -> 0x00cf }
            goto L_0x00d3
        L_0x00cf:
            r5 = move-exception
            r5.printStackTrace()     // Catch:{ Throwable -> 0x00d7 }
        L_0x00d3:
            r0.mo22985a(r3)     // Catch:{ Throwable -> 0x00d7 }
            goto L_0x0132
        L_0x00d7:
            r5 = move-exception
            goto L_0x00e2
        L_0x00d9:
            r4 = move-exception
            r5 = r4
            r4 = r2
            goto L_0x00e2
        L_0x00dd:
            r6 = move-exception
            r11 = r4
            r4 = r2
            r5 = r6
            r6 = r11
        L_0x00e2:
            r5.printStackTrace()
            boolean r5 = r5 instanceof java.net.SocketTimeoutException
            if (r5 == 0) goto L_0x0132
            java.util.concurrent.TimeUnit r5 = java.util.concurrent.TimeUnit.NANOSECONDS
            long r8 = java.lang.System.nanoTime()
            long r8 = r8 - r6
            long r5 = r5.toMillis(r8)
            r3.bhE = r5
            r5 = 9926(0x26c6, float:1.3909E-41)
            r3.statusCode = r5
            r3.errorCode = r5
            java.lang.String r6 = "SocketTimeoutException"
            r3.errorMsg = r6
            com.introvd.template.apicore.g r6 = com.introvd.template.apicore.C3629g.m8896GS()
            com.introvd.template.apicore.f r6 = r6.mo22969GT()
            if (r6 == 0) goto L_0x012f
            org.json.JSONObject r6 = new org.json.JSONObject
            r6.<init>()
            java.lang.String r7 = "errorCode"
            r6.put(r7, r5)     // Catch:{ JSONException -> 0x012b }
            java.lang.String r5 = "errorMsg"
            java.lang.String r7 = r3.errorMsg     // Catch:{ JSONException -> 0x012b }
            r6.put(r5, r7)     // Catch:{ JSONException -> 0x012b }
            com.introvd.template.apicore.g r5 = com.introvd.template.apicore.C3629g.m8896GS()     // Catch:{ JSONException -> 0x012b }
            com.introvd.template.apicore.f r5 = r5.mo22969GT()     // Catch:{ JSONException -> 0x012b }
            java.lang.String r6 = r6.toString()     // Catch:{ JSONException -> 0x012b }
            r5.mo22968a(r2, r6)     // Catch:{ JSONException -> 0x012b }
            goto L_0x012f
        L_0x012b:
            r2 = move-exception
            r2.printStackTrace()
        L_0x012f:
            r0.mo22985a(r3)
        L_0x0132:
            if (r4 != 0) goto L_0x0138
            okhttp3.ac r4 = r14.mo37939c(r1)
        L_0x0138:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.apicore.C3640q.intercept(okhttp3.u$a):okhttp3.ac");
    }
}
