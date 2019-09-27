package com.introvd.template.editor.p266h;

import com.introvd.template.C4681i;
import com.introvd.template.common.CommonConfigure;
import com.introvd.template.common.ExAsyncTask;
import com.introvd.template.common.FileUtils;
import com.introvd.template.common.LogUtils;
import com.introvd.template.p203b.C4582c;
import com.introvd.template.p203b.C4596h;
import com.introvd.template.sdk.utils.p394b.C8520e;
import java.io.File;

/* renamed from: com.introvd.template.editor.h.e */
public class C6388e extends ExAsyncTask<Void, Void, Boolean> {
    private String dkE = "";
    private String dkF = "";

    public C6388e(String str, String str2) {
        this.dkE = str2;
        this.dkF = str;
    }

    /* renamed from: z */
    private void m18380z(Boolean bool) {
        if (bool.booleanValue()) {
            StringBuilder sb = new StringBuilder();
            sb.append(CommonConfigure.APP_DATA_PATH);
            sb.append("ini/hw_codec_cap.xml");
            String sb2 = sb.toString();
            String freeFileName = FileUtils.getFreeFileName(new File(sb2).getParent(), FileUtils.getFileName(sb2), ".xml", 0);
            if (FileUtils.renameFile(sb2, freeFileName)) {
                boolean renameFile = FileUtils.renameFile(this.dkF, sb2);
                StringBuilder sb3 = new StringBuilder();
                sb3.append("bUpgradeResult=");
                sb3.append(renameFile);
                LogUtils.m14222e("yqg", sb3.toString());
                if (renameFile) {
                    C4596h.m11722Sv();
                    C8520e.m24660x(C4582c.m11667dD(C4681i.m12184Gp().mo25017Gs()), true);
                    return;
                }
                FileUtils.renameFile(freeFileName, sb2);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0093 A[SYNTHETIC, Splitter:B:61:0x0093] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0098 A[Catch:{ IOException -> 0x009b }] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x00a4 A[SYNTHETIC, Splitter:B:71:0x00a4] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x00a9 A[Catch:{ IOException -> 0x00ac }] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00ae  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Boolean doInBackground(java.lang.Void... r9) {
        /*
            r8 = this;
            java.lang.String r9 = r8.dkF
            boolean r9 = com.introvd.template.common.FileUtils.isFileExisted(r9)
            r0 = 1
            if (r9 == 0) goto L_0x000e
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r0)
            return r9
        L_0x000e:
            r9 = 0
            r1 = 0
            java.net.URL r2 = new java.net.URL     // Catch:{ Exception -> 0x0087, all -> 0x0083 }
            java.lang.String r3 = r8.dkE     // Catch:{ Exception -> 0x0087, all -> 0x0083 }
            r2.<init>(r3)     // Catch:{ Exception -> 0x0087, all -> 0x0083 }
            java.net.URLConnection r2 = r2.openConnection()     // Catch:{ Exception -> 0x0087, all -> 0x0083 }
            java.net.HttpURLConnection r2 = (java.net.HttpURLConnection) r2     // Catch:{ Exception -> 0x0087, all -> 0x0083 }
            r2.connect()     // Catch:{ Exception -> 0x0080, all -> 0x007d }
            int r3 = r2.getResponseCode()     // Catch:{ Exception -> 0x0080, all -> 0x007d }
            r4 = 200(0xc8, float:2.8E-43)
            if (r3 == r4) goto L_0x0032
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r9)     // Catch:{ Exception -> 0x0080, all -> 0x007d }
            if (r2 == 0) goto L_0x0031
            r2.disconnect()
        L_0x0031:
            return r0
        L_0x0032:
            java.io.InputStream r3 = r2.getInputStream()     // Catch:{ Exception -> 0x0080, all -> 0x007d }
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x007b }
            java.lang.String r5 = r8.dkF     // Catch:{ Exception -> 0x007b }
            r4.<init>(r5)     // Catch:{ Exception -> 0x007b }
            r5 = 4096(0x1000, float:5.74E-42)
            byte[] r5 = new byte[r5]     // Catch:{ Exception -> 0x0078, all -> 0x0075 }
        L_0x0041:
            int r6 = r3.read(r5)     // Catch:{ Exception -> 0x0078, all -> 0x0075 }
            r7 = -1
            if (r6 == r7) goto L_0x0063
            boolean r7 = r8.isCancelled()     // Catch:{ Exception -> 0x0078, all -> 0x0075 }
            if (r7 == 0) goto L_0x005f
            r3.close()     // Catch:{ Exception -> 0x0078, all -> 0x0075 }
            r4.close()     // Catch:{ IOException -> 0x0059 }
            if (r3 == 0) goto L_0x0059
            r3.close()     // Catch:{ IOException -> 0x0059 }
        L_0x0059:
            if (r2 == 0) goto L_0x005e
            r2.disconnect()
        L_0x005e:
            return r1
        L_0x005f:
            r4.write(r5, r9, r6)     // Catch:{ Exception -> 0x0078, all -> 0x0075 }
            goto L_0x0041
        L_0x0063:
            r4.close()     // Catch:{ IOException -> 0x006b }
            if (r3 == 0) goto L_0x006b
            r3.close()     // Catch:{ IOException -> 0x006b }
        L_0x006b:
            if (r2 == 0) goto L_0x0070
            r2.disconnect()
        L_0x0070:
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r0)
            return r9
        L_0x0075:
            r9 = move-exception
            r1 = r4
            goto L_0x00a2
        L_0x0078:
            r0 = move-exception
            r1 = r4
            goto L_0x008a
        L_0x007b:
            r0 = move-exception
            goto L_0x008a
        L_0x007d:
            r9 = move-exception
            r3 = r1
            goto L_0x00a2
        L_0x0080:
            r0 = move-exception
            r3 = r1
            goto L_0x008a
        L_0x0083:
            r9 = move-exception
            r2 = r1
            r3 = r2
            goto L_0x00a2
        L_0x0087:
            r0 = move-exception
            r2 = r1
            r3 = r2
        L_0x008a:
            r0.printStackTrace()     // Catch:{ all -> 0x00a1 }
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r9)     // Catch:{ all -> 0x00a1 }
            if (r1 == 0) goto L_0x0096
            r1.close()     // Catch:{ IOException -> 0x009b }
        L_0x0096:
            if (r3 == 0) goto L_0x009b
            r3.close()     // Catch:{ IOException -> 0x009b }
        L_0x009b:
            if (r2 == 0) goto L_0x00a0
            r2.disconnect()
        L_0x00a0:
            return r9
        L_0x00a1:
            r9 = move-exception
        L_0x00a2:
            if (r1 == 0) goto L_0x00a7
            r1.close()     // Catch:{ IOException -> 0x00ac }
        L_0x00a7:
            if (r3 == 0) goto L_0x00ac
            r3.close()     // Catch:{ IOException -> 0x00ac }
        L_0x00ac:
            if (r2 == 0) goto L_0x00b1
            r2.disconnect()
        L_0x00b1:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.editor.p266h.C6388e.doInBackground(java.lang.Void[]):java.lang.Boolean");
    }

    /* access modifiers changed from: protected */
    /* renamed from: r */
    public void onPostExecute(Boolean bool) {
        super.onPostExecute(bool);
        m18380z(bool);
    }
}
