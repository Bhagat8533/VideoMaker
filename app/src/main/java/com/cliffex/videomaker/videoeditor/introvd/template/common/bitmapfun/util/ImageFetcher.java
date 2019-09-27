package com.introvd.template.common.bitmapfun.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.google.android.exoplayer2.DefaultRenderersFactory;
import com.introvd.template.datacenter.SocialService;
import com.introvd.template.router.editor.EditorRouter;
import com.introvd.template.sdk.utils.p393a.C8492c;
import java.io.File;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import p503cz.msebera.android.httpclient.HttpHost;

public class ImageFetcher extends ImageResizer {
    private static Random cdI = new Random(System.currentTimeMillis());
    private static ImageFetcherHttpListener ced;
    private static C8492c cee;
    private static DiskLruCache cef = null;

    public interface ImageFetcherHttpListener {
        void onFetchFile(String str, String str2, C8492c cVar);
    }

    public ImageFetcher(Context context, int i, int i2) {
        super(context, i, i2);
    }

    /* renamed from: Z */
    private static File m14303Z(final String str, String str2) {
        if (ced == null) {
            return m14305aa(str, str2);
        }
        final LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        int nextInt = cdI.nextInt();
        if (nextInt < 0) {
            nextInt = -nextInt;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str2);
        sb.append("_");
        sb.append(nextInt);
        sb.append(".tmp");
        String sb2 = sb.toString();
        ced.onFetchFile(str, sb2, new C8492c() {
            public void onError(Throwable th) {
                StringBuilder sb = new StringBuilder();
                sb.append("fetct url fail:");
                sb.append(str);
                sb.append(EditorRouter.KEY_TOOL_LIST_ORDER_SPLIT_OP);
                sb.append(th.getMessage());
                ImageFetcher.m14309q(new Exception(sb.toString()));
                try {
                    linkedBlockingQueue.put(Integer.valueOf(0));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Integer valueOf = Integer.valueOf(0);
        try {
            valueOf = (Integer) linkedBlockingQueue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (valueOf.intValue() != 1) {
            return null;
        }
        File file = new File(sb2);
        if (!file.isFile() || !file.exists() || file.length() <= 0) {
            return null;
        }
        file.renameTo(new File(str2));
        File file2 = new File(str2);
        if (!file2.isFile() || !file2.exists()) {
            file2 = null;
        }
        return file2;
    }

    /* renamed from: a */
    private static void m14304a(String str, long j, boolean z) {
        if (j >= DefaultRenderersFactory.DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS || z) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(", cost:");
            sb.append(j);
            m14309q(new Exception(sb.toString()));
        }
    }

    /* JADX WARNING: type inference failed for: r6v0 */
    /* JADX WARNING: type inference failed for: r15v0, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r13v0, types: [java.io.File] */
    /* JADX WARNING: type inference failed for: r6v1, types: [java.io.BufferedOutputStream] */
    /* JADX WARNING: type inference failed for: r15v1, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r13v1, types: [java.io.File] */
    /* JADX WARNING: type inference failed for: r6v7, types: [java.io.BufferedOutputStream] */
    /* JADX WARNING: type inference failed for: r15v2 */
    /* JADX WARNING: type inference failed for: r13v2 */
    /* JADX WARNING: type inference failed for: r13v3 */
    /* JADX WARNING: type inference failed for: r15v3 */
    /* JADX WARNING: type inference failed for: r15v4 */
    /* JADX WARNING: type inference failed for: r13v4 */
    /* JADX WARNING: type inference failed for: r6v17 */
    /* JADX WARNING: type inference failed for: r15v5 */
    /* JADX WARNING: type inference failed for: r13v5 */
    /* JADX WARNING: type inference failed for: r13v6 */
    /* JADX WARNING: type inference failed for: r15v6 */
    /* JADX WARNING: type inference failed for: r13v7 */
    /* JADX WARNING: type inference failed for: r15v7 */
    /* JADX WARNING: type inference failed for: r13v8 */
    /* JADX WARNING: type inference failed for: r15v8 */
    /* JADX WARNING: type inference failed for: r15v9 */
    /* JADX WARNING: type inference failed for: r13v9 */
    /* JADX WARNING: type inference failed for: r6v18 */
    /* JADX WARNING: type inference failed for: r13v10 */
    /* JADX WARNING: type inference failed for: r6v19 */
    /* JADX WARNING: type inference failed for: r15v10 */
    /* JADX WARNING: type inference failed for: r6v20 */
    /* JADX WARNING: type inference failed for: r13v11 */
    /* JADX WARNING: type inference failed for: r6v21 */
    /* JADX WARNING: type inference failed for: r13v12 */
    /* JADX WARNING: type inference failed for: r15v11 */
    /* JADX WARNING: type inference failed for: r6v22 */
    /* JADX WARNING: type inference failed for: r6v23 */
    /* JADX WARNING: type inference failed for: r6v27 */
    /* JADX WARNING: type inference failed for: r13v13 */
    /* JADX WARNING: type inference failed for: r15v12 */
    /* JADX WARNING: type inference failed for: r6v28 */
    /* JADX WARNING: type inference failed for: r13v14 */
    /* JADX WARNING: type inference failed for: r15v13 */
    /* JADX WARNING: type inference failed for: r15v14, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r6v29 */
    /* JADX WARNING: type inference failed for: r13v16 */
    /* JADX WARNING: type inference failed for: r6v30 */
    /* JADX WARNING: type inference failed for: r13v17 */
    /* JADX WARNING: type inference failed for: r13v19, types: [java.io.File] */
    /* JADX WARNING: type inference failed for: r6v31 */
    /* JADX WARNING: type inference failed for: r6v32 */
    /* JADX WARNING: type inference failed for: r14v4, types: [java.io.BufferedOutputStream] */
    /* JADX WARNING: type inference failed for: r6v35 */
    /* JADX WARNING: type inference failed for: r6v36 */
    /* JADX WARNING: type inference failed for: r6v49 */
    /* JADX WARNING: type inference failed for: r6v50 */
    /* JADX WARNING: type inference failed for: r13v20 */
    /* JADX WARNING: type inference failed for: r15v15 */
    /* JADX WARNING: type inference failed for: r13v21 */
    /* JADX WARNING: type inference failed for: r6v51 */
    /* JADX WARNING: type inference failed for: r15v16 */
    /* JADX WARNING: type inference failed for: r13v22 */
    /* JADX WARNING: type inference failed for: r6v52 */
    /* JADX WARNING: type inference failed for: r13v23 */
    /* JADX WARNING: type inference failed for: r15v17 */
    /* JADX WARNING: type inference failed for: r6v53 */
    /* JADX WARNING: type inference failed for: r6v54 */
    /* JADX WARNING: type inference failed for: r6v55 */
    /* JADX WARNING: type inference failed for: r6v56 */
    /* JADX WARNING: type inference failed for: r6v57 */
    /* JADX WARNING: type inference failed for: r6v58 */
    /* JADX WARNING: type inference failed for: r15v18 */
    /* JADX WARNING: type inference failed for: r13v24 */
    /* JADX WARNING: type inference failed for: r6v59 */
    /* JADX WARNING: type inference failed for: r15v19 */
    /* JADX WARNING: type inference failed for: r13v25 */
    /* JADX WARNING: type inference failed for: r15v20 */
    /* JADX WARNING: type inference failed for: r13v26 */
    /* JADX WARNING: type inference failed for: r6v60 */
    /* JADX WARNING: type inference failed for: r15v21 */
    /* JADX WARNING: type inference failed for: r13v27 */
    /* JADX WARNING: type inference failed for: r15v22 */
    /* JADX WARNING: type inference failed for: r13v28 */
    /* JADX WARNING: type inference failed for: r6v61 */
    /* JADX WARNING: type inference failed for: r13v29 */
    /* JADX WARNING: type inference failed for: r6v62 */
    /* JADX WARNING: type inference failed for: r6v63 */
    /* JADX WARNING: type inference failed for: r6v64 */
    /* JADX WARNING: type inference failed for: r13v30 */
    /* JADX WARNING: type inference failed for: r6v65 */
    /* JADX WARNING: type inference failed for: r13v31 */
    /* JADX WARNING: type inference failed for: r15v23 */
    /* JADX WARNING: type inference failed for: r6v66 */
    /* JADX WARNING: type inference failed for: r13v32 */
    /* JADX WARNING: type inference failed for: r15v24 */
    /* JADX WARNING: type inference failed for: r15v25 */
    /* JADX WARNING: type inference failed for: r15v26 */
    /* JADX WARNING: type inference failed for: r15v27 */
    /* JADX WARNING: type inference failed for: r15v28 */
    /* JADX WARNING: type inference failed for: r15v29 */
    /* JADX WARNING: type inference failed for: r15v30 */
    /* JADX WARNING: type inference failed for: r15v31 */
    /* JADX WARNING: type inference failed for: r15v32 */
    /* JADX WARNING: type inference failed for: r6v67 */
    /* JADX WARNING: type inference failed for: r13v33 */
    /* JADX WARNING: type inference failed for: r6v68 */
    /* JADX WARNING: type inference failed for: r13v34 */
    /* JADX WARNING: type inference failed for: r13v35 */
    /* JADX WARNING: type inference failed for: r13v36 */
    /* JADX WARNING: type inference failed for: r13v37 */
    /* JADX WARNING: type inference failed for: r13v38 */
    /* JADX WARNING: type inference failed for: r13v39 */
    /* JADX WARNING: type inference failed for: r13v40 */
    /* JADX WARNING: type inference failed for: r6v69 */
    /* JADX WARNING: type inference failed for: r6v70 */
    /* JADX WARNING: type inference failed for: r15v33 */
    /* JADX WARNING: type inference failed for: r13v41 */
    /* JADX WARNING: type inference failed for: r6v71 */
    /* JADX WARNING: type inference failed for: r15v34 */
    /* JADX WARNING: type inference failed for: r13v42 */
    /* JADX WARNING: type inference failed for: r6v72 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r15v2
      assigns: []
      uses: []
      mth insns count: 556
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:99)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:92)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
    	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
    	at jadx.core.ProcessClass.process(ProcessClass.java:30)
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
     */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x03a0 A[SYNTHETIC, Splitter:B:152:0x03a0] */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x03cd  */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x0407 A[SYNTHETIC, Splitter:B:168:0x0407] */
    /* JADX WARNING: Removed duplicated region for block: B:182:0x045a A[SYNTHETIC, Splitter:B:182:0x045a] */
    /* JADX WARNING: Removed duplicated region for block: B:187:0x0487  */
    /* JADX WARNING: Removed duplicated region for block: B:195:0x04ba A[SYNTHETIC, Splitter:B:195:0x04ba] */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x025f A[SYNTHETIC, Splitter:B:93:0x025f] */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0267 A[Catch:{ Exception -> 0x0263 }] */
    /* JADX WARNING: Unknown variable types count: 44 */
    /* renamed from: aa */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.io.File m14305aa(java.lang.String r23, java.lang.String r24) {
        /*
            r1 = r23
            java.io.File r2 = new java.io.File
            r0 = r24
            r2.<init>(r0)
            long r3 = java.lang.System.currentTimeMillis()
            r5 = 1
            r6 = 0
            r7 = 0
            java.net.URL r0 = new java.net.URL     // Catch:{ Exception -> 0x0370, all -> 0x0365 }
            r0.<init>(r1)     // Catch:{ Exception -> 0x0370, all -> 0x0365 }
            java.net.URLConnection r0 = r0.openConnection()     // Catch:{ Exception -> 0x0370, all -> 0x0365 }
            r8 = r0
            java.net.HttpURLConnection r8 = (java.net.HttpURLConnection) r8     // Catch:{ Exception -> 0x0370, all -> 0x0365 }
            r0 = 20000(0x4e20, float:2.8026E-41)
            r8.setConnectTimeout(r0)     // Catch:{ Exception -> 0x035f, all -> 0x0359 }
            r8.setReadTimeout(r0)     // Catch:{ Exception -> 0x035f, all -> 0x0359 }
            java.lang.String r0 = "User-Agent"
            java.lang.String r9 = "Android"
            r8.setRequestProperty(r0, r9)     // Catch:{ Exception -> 0x035f, all -> 0x0359 }
            java.lang.String r0 = "Connection"
            java.lang.String r9 = "Keep-Alive"
            r8.setRequestProperty(r0, r9)     // Catch:{ Exception -> 0x035f, all -> 0x0359 }
            r8.connect()     // Catch:{ Exception -> 0x035f, all -> 0x0359 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0351, all -> 0x0348 }
            r0.<init>()     // Catch:{ Exception -> 0x0351, all -> 0x0348 }
            java.lang.String r9 = "[ImageFetch]connect:"
            r0.append(r9)     // Catch:{ Exception -> 0x0351, all -> 0x0348 }
            r0.append(r1)     // Catch:{ Exception -> 0x0351, all -> 0x0348 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0351, all -> 0x0348 }
            long r9 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0351, all -> 0x0348 }
            r11 = 0
            long r9 = r9 - r3
            m14304a(r0, r9, r7)     // Catch:{ Exception -> 0x0351, all -> 0x0348 }
            long r9 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0351, all -> 0x0348 }
            int r0 = r8.getResponseCode()     // Catch:{ Exception -> 0x0351, all -> 0x0348 }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0351, all -> 0x0348 }
            r11.<init>()     // Catch:{ Exception -> 0x0351, all -> 0x0348 }
            java.lang.String r12 = "[ImageFetch]getResponseCode:"
            r11.append(r12)     // Catch:{ Exception -> 0x0351, all -> 0x0348 }
            r11.append(r1)     // Catch:{ Exception -> 0x0351, all -> 0x0348 }
            java.lang.String r11 = r11.toString()     // Catch:{ Exception -> 0x0351, all -> 0x0348 }
            long r12 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0351, all -> 0x0348 }
            r14 = 0
            long r12 = r12 - r9
            m14304a(r11, r12, r7)     // Catch:{ Exception -> 0x0351, all -> 0x0348 }
            r9 = 200(0xc8, float:2.8E-43)
            if (r0 == r9) goto L_0x00f0
            r9 = 206(0xce, float:2.89E-43)
            if (r0 == r9) goto L_0x00f0
            java.lang.Exception r9 = new java.lang.Exception     // Catch:{ Exception -> 0x00eb, all -> 0x00e1 }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00eb, all -> 0x00e1 }
            r10.<init>()     // Catch:{ Exception -> 0x00eb, all -> 0x00e1 }
            java.lang.String r11 = "[ImageFetch]Bad http response code:"
            r10.append(r11)     // Catch:{ Exception -> 0x00eb, all -> 0x00e1 }
            r10.append(r0)     // Catch:{ Exception -> 0x00eb, all -> 0x00e1 }
            java.lang.String r0 = ",url:"
            r10.append(r0)     // Catch:{ Exception -> 0x00eb, all -> 0x00e1 }
            r10.append(r1)     // Catch:{ Exception -> 0x00eb, all -> 0x00e1 }
            java.lang.String r0 = r10.toString()     // Catch:{ Exception -> 0x00eb, all -> 0x00e1 }
            r9.<init>(r0)     // Catch:{ Exception -> 0x00eb, all -> 0x00e1 }
            m14309q(r9)     // Catch:{ Exception -> 0x00eb, all -> 0x00e1 }
            if (r8 == 0) goto L_0x00c7
            r8.disconnect()     // Catch:{ Exception -> 0x00a0 }
            goto L_0x00c7
        L_0x00a0:
            r0 = move-exception
            r2 = r0
            java.lang.Exception r0 = new java.lang.Exception
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r8 = "[ImageFetch]url:"
            r5.append(r8)
            r5.append(r1)
            java.lang.String r8 = ",msg"
            r5.append(r8)
            java.lang.String r2 = r2.getMessage()
            r5.append(r2)
            java.lang.String r2 = r5.toString()
            r0.<init>(r2)
            m14309q(r0)
        L_0x00c7:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "[ImageFetch]finish:"
            r0.append(r2)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            long r1 = java.lang.System.currentTimeMillis()
            long r1 = r1 - r3
            m14304a(r0, r1, r7)
            return r6
        L_0x00e1:
            r0 = move-exception
            r5 = r0
            r13 = r6
            r15 = r13
            r9 = r8
        L_0x00e6:
            r8 = 0
        L_0x00e7:
            r19 = 1
            goto L_0x0458
        L_0x00eb:
            r0 = move-exception
            r5 = r6
            r13 = r5
            goto L_0x0354
        L_0x00f0:
            long r9 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0351, all -> 0x0348 }
            java.lang.String r0 = r8.getContentType()     // Catch:{ Exception -> 0x0351, all -> 0x0348 }
            boolean r11 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x0351, all -> 0x0348 }
            if (r11 != 0) goto L_0x02d7
            java.util.Locale r11 = java.util.Locale.US     // Catch:{ Exception -> 0x02cd, all -> 0x02c4 }
            java.lang.String r11 = r0.toLowerCase(r11)     // Catch:{ Exception -> 0x02cd, all -> 0x02c4 }
            java.lang.String r12 = "text"
            boolean r11 = r11.startsWith(r12)     // Catch:{ Exception -> 0x02cd, all -> 0x02c4 }
            if (r11 == 0) goto L_0x010e
            goto L_0x02d7
        L_0x010e:
            int r0 = r8.getContentLength()     // Catch:{ Exception -> 0x02cd, all -> 0x02c4 }
            long r11 = (long) r0
            r13 = 0
            int r0 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r0 > 0) goto L_0x0181
            java.lang.Exception r0 = new java.lang.Exception     // Catch:{ Exception -> 0x00eb, all -> 0x00e1 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00eb, all -> 0x00e1 }
            r9.<init>()     // Catch:{ Exception -> 0x00eb, all -> 0x00e1 }
            java.lang.String r10 = "[ImageFetch]Bad http content length:"
            r9.append(r10)     // Catch:{ Exception -> 0x00eb, all -> 0x00e1 }
            r9.append(r11)     // Catch:{ Exception -> 0x00eb, all -> 0x00e1 }
            java.lang.String r10 = ",url:"
            r9.append(r10)     // Catch:{ Exception -> 0x00eb, all -> 0x00e1 }
            r9.append(r1)     // Catch:{ Exception -> 0x00eb, all -> 0x00e1 }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x00eb, all -> 0x00e1 }
            r0.<init>(r9)     // Catch:{ Exception -> 0x00eb, all -> 0x00e1 }
            m14309q(r0)     // Catch:{ Exception -> 0x00eb, all -> 0x00e1 }
            if (r8 == 0) goto L_0x0167
            r8.disconnect()     // Catch:{ Exception -> 0x0140 }
            goto L_0x0167
        L_0x0140:
            r0 = move-exception
            r2 = r0
            java.lang.Exception r0 = new java.lang.Exception
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r8 = "[ImageFetch]url:"
            r5.append(r8)
            r5.append(r1)
            java.lang.String r8 = ",msg"
            r5.append(r8)
            java.lang.String r2 = r2.getMessage()
            r5.append(r2)
            java.lang.String r2 = r5.toString()
            r0.<init>(r2)
            m14309q(r0)
        L_0x0167:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "[ImageFetch]finish:"
            r0.append(r2)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            long r1 = java.lang.System.currentTimeMillis()
            long r1 = r1 - r3
            m14304a(r0, r1, r7)
            return r6
        L_0x0181:
            java.io.InputStream r15 = r8.getInputStream()     // Catch:{ Exception -> 0x02cd, all -> 0x02c4 }
            r0 = 4096(0x1000, float:5.74E-42)
            byte[] r0 = new byte[r0]     // Catch:{ Exception -> 0x02bb, all -> 0x02b3 }
            java.lang.String r13 = "tmp_"
            java.io.File r14 = r2.getParentFile()     // Catch:{ Exception -> 0x02bb, all -> 0x02b3 }
            java.io.File r13 = java.io.File.createTempFile(r13, r6, r14)     // Catch:{ Exception -> 0x02bb, all -> 0x02b3 }
            java.io.BufferedOutputStream r14 = new java.io.BufferedOutputStream     // Catch:{ Exception -> 0x02ad, all -> 0x02a7 }
            java.io.FileOutputStream r6 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x02ad, all -> 0x02a7 }
            r6.<init>(r13, r5)     // Catch:{ Exception -> 0x02ad, all -> 0x02a7 }
            r14.<init>(r6)     // Catch:{ Exception -> 0x02ad, all -> 0x02a7 }
            r17 = 0
        L_0x019f:
            int r6 = (r17 > r11 ? 1 : (r17 == r11 ? 0 : -1))
            if (r6 >= 0) goto L_0x01d1
            r20 = r6
            long r5 = r11 - r17
            r21 = 4096(0x1000, double:2.0237E-320)
            int r21 = (r5 > r21 ? 1 : (r5 == r21 ? 0 : -1))
            if (r21 < 0) goto L_0x01be
            int r5 = r15.read(r0)     // Catch:{ Exception -> 0x01b8, all -> 0x01b2 }
            goto L_0x01c3
        L_0x01b2:
            r0 = move-exception
            r5 = r0
            r9 = r8
            r6 = r14
            goto L_0x00e6
        L_0x01b8:
            r0 = move-exception
            r9 = r8
            r6 = r14
            r5 = 0
            goto L_0x0356
        L_0x01be:
            int r5 = (int) r5     // Catch:{ Exception -> 0x01b8, all -> 0x01b2 }
            int r5 = r15.read(r0, r7, r5)     // Catch:{ Exception -> 0x01b8, all -> 0x01b2 }
        L_0x01c3:
            if (r5 > 0) goto L_0x01c6
            goto L_0x01d3
        L_0x01c6:
            r14.write(r0, r7, r5)     // Catch:{ Exception -> 0x01b8, all -> 0x01b2 }
            r14.flush()     // Catch:{ Exception -> 0x01b8, all -> 0x01b2 }
            long r5 = (long) r5
            long r17 = r17 + r5
            r5 = 1
            goto L_0x019f
        L_0x01d1:
            r20 = r6
        L_0x01d3:
            r5 = 0
            int r0 = (r17 > r5 ? 1 : (r17 == r5 ? 0 : -1))
            if (r0 <= 0) goto L_0x01dd
            if (r20 != 0) goto L_0x01dd
            r5 = 1
            goto L_0x01de
        L_0x01dd:
            r5 = 0
        L_0x01de:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x029f, all -> 0x0297 }
            r0.<init>()     // Catch:{ Exception -> 0x029f, all -> 0x0297 }
            java.lang.String r6 = "[ImageFetch]read:"
            r0.append(r6)     // Catch:{ Exception -> 0x029f, all -> 0x0297 }
            r0.append(r1)     // Catch:{ Exception -> 0x029f, all -> 0x0297 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x029f, all -> 0x0297 }
            long r11 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x029f, all -> 0x0297 }
            r6 = 0
            long r11 = r11 - r9
            m14304a(r0, r11, r7)     // Catch:{ Exception -> 0x029f, all -> 0x0297 }
            r14.close()     // Catch:{ Throwable -> 0x01fc }
            goto L_0x0223
        L_0x01fc:
            r0 = move-exception
            r6 = r0
            java.lang.Exception r0 = new java.lang.Exception
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "[ImageFetch]url:"
            r9.append(r10)
            r9.append(r1)
            java.lang.String r10 = ",msg"
            r9.append(r10)
            java.lang.String r6 = r6.getMessage()
            r9.append(r6)
            java.lang.String r6 = r9.toString()
            r0.<init>(r6)
            m14309q(r0)
        L_0x0223:
            if (r13 == 0) goto L_0x025a
            if (r5 != 0) goto L_0x022d
            r13.delete()     // Catch:{ Throwable -> 0x022b }
            goto L_0x025a
        L_0x022b:
            r0 = move-exception
            goto L_0x0232
        L_0x022d:
            r13.renameTo(r2)     // Catch:{ Throwable -> 0x022b }
            r6 = r2
            goto L_0x025b
        L_0x0232:
            java.lang.Exception r2 = new java.lang.Exception
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "[ImageFetch]url:"
            r5.append(r6)
            r5.append(r1)
            java.lang.String r6 = ",msg"
            r5.append(r6)
            java.lang.String r0 = r0.getMessage()
            r5.append(r0)
            java.lang.String r0 = r5.toString()
            r2.<init>(r0)
            m14309q(r2)
            r16 = 0
            goto L_0x025d
        L_0x025a:
            r6 = 0
        L_0x025b:
            r16 = r6
        L_0x025d:
            if (r15 == 0) goto L_0x0265
            r15.close()     // Catch:{ Exception -> 0x0263 }
            goto L_0x0265
        L_0x0263:
            r0 = move-exception
            goto L_0x026b
        L_0x0265:
            if (r8 == 0) goto L_0x0290
            r8.disconnect()     // Catch:{ Exception -> 0x0263 }
            goto L_0x0290
        L_0x026b:
            java.lang.Exception r2 = new java.lang.Exception
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "[ImageFetch]url:"
            r5.append(r6)
            r5.append(r1)
            java.lang.String r6 = ",msg"
            r5.append(r6)
            java.lang.String r0 = r0.getMessage()
            r5.append(r0)
            java.lang.String r0 = r5.toString()
            r2.<init>(r0)
            m14309q(r2)
        L_0x0290:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            goto L_0x043f
        L_0x0297:
            r0 = move-exception
            r9 = r8
            r6 = r14
            r19 = 1
            r8 = r5
            goto L_0x036d
        L_0x029f:
            r0 = move-exception
            r9 = r8
            r6 = r14
            r10 = 1
            r8 = r5
            r5 = 0
            goto L_0x0377
        L_0x02a7:
            r0 = move-exception
            r5 = r0
            r9 = r8
            r6 = 0
            goto L_0x00e6
        L_0x02ad:
            r0 = move-exception
            r9 = r8
            r5 = 0
            r6 = 0
            goto L_0x0356
        L_0x02b3:
            r0 = move-exception
            r5 = r0
            r9 = r8
            r6 = 0
            r8 = 0
            r13 = 0
            goto L_0x00e7
        L_0x02bb:
            r0 = move-exception
            r9 = r8
            r5 = 0
            r6 = 0
            r8 = 0
            r10 = 1
            r13 = 0
            goto L_0x0377
        L_0x02c4:
            r0 = move-exception
            r5 = r0
            r9 = r8
            r6 = 0
            r8 = 0
            r13 = 0
            r15 = 0
            goto L_0x00e7
        L_0x02cd:
            r0 = move-exception
            r9 = r8
            r5 = 0
            r6 = 0
            r8 = 0
            r10 = 1
            r13 = 0
            r15 = 0
            goto L_0x0377
        L_0x02d7:
            java.lang.Exception r5 = new java.lang.Exception     // Catch:{ Exception -> 0x0344, all -> 0x0340 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0344, all -> 0x0340 }
            r6.<init>()     // Catch:{ Exception -> 0x0344, all -> 0x0340 }
            java.lang.String r9 = "[ImageFetch]Bad http content type:"
            r6.append(r9)     // Catch:{ Exception -> 0x0344, all -> 0x0340 }
            r6.append(r0)     // Catch:{ Exception -> 0x0344, all -> 0x0340 }
            java.lang.String r0 = ",url:"
            r6.append(r0)     // Catch:{ Exception -> 0x0344, all -> 0x0340 }
            r6.append(r1)     // Catch:{ Exception -> 0x0344, all -> 0x0340 }
            java.lang.String r0 = r6.toString()     // Catch:{ Exception -> 0x0344, all -> 0x0340 }
            r5.<init>(r0)     // Catch:{ Exception -> 0x0344, all -> 0x0340 }
            m14309q(r5)     // Catch:{ Exception -> 0x0344, all -> 0x0340 }
            if (r8 == 0) goto L_0x0325
            r8.disconnect()     // Catch:{ Exception -> 0x02fe }
            goto L_0x0325
        L_0x02fe:
            r0 = move-exception
            r2 = r0
            java.lang.Exception r0 = new java.lang.Exception
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "[ImageFetch]url:"
            r5.append(r6)
            r5.append(r1)
            java.lang.String r6 = ",msg"
            r5.append(r6)
            java.lang.String r2 = r2.getMessage()
            r5.append(r2)
            java.lang.String r2 = r5.toString()
            r0.<init>(r2)
            m14309q(r0)
        L_0x0325:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "[ImageFetch]finish:"
            r0.append(r2)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            long r1 = java.lang.System.currentTimeMillis()
            long r1 = r1 - r3
            m14304a(r0, r1, r7)
            r5 = 0
            return r5
        L_0x0340:
            r0 = move-exception
            r5 = 0
            r6 = r5
            goto L_0x034a
        L_0x0344:
            r0 = move-exception
            r5 = 0
            r6 = r5
            goto L_0x0353
        L_0x0348:
            r0 = move-exception
            r5 = r6
        L_0x034a:
            r13 = r6
            r15 = r13
            r9 = r8
            r8 = 0
            r19 = 1
            goto L_0x036d
        L_0x0351:
            r0 = move-exception
            r5 = r6
        L_0x0353:
            r13 = r6
        L_0x0354:
            r15 = r13
            r9 = r8
        L_0x0356:
            r8 = 0
            r10 = 1
            goto L_0x0377
        L_0x0359:
            r0 = move-exception
            r5 = r6
            r13 = r6
            r15 = r13
            r9 = r8
            goto L_0x036a
        L_0x035f:
            r0 = move-exception
            r5 = r6
            r13 = r6
            r15 = r13
            r9 = r8
            goto L_0x0375
        L_0x0365:
            r0 = move-exception
            r5 = r6
            r9 = r6
            r13 = r9
            r15 = r13
        L_0x036a:
            r8 = 0
            r19 = 0
        L_0x036d:
            r5 = r0
            goto L_0x0458
        L_0x0370:
            r0 = move-exception
            r5 = r6
            r9 = r6
            r13 = r9
            r15 = r13
        L_0x0375:
            r8 = 0
            r10 = 0
        L_0x0377:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x0454 }
            r11.<init>()     // Catch:{ all -> 0x0454 }
            java.lang.String r12 = "[ImageFetch]url:"
            r11.append(r12)     // Catch:{ all -> 0x0454 }
            r11.append(r1)     // Catch:{ all -> 0x0454 }
            java.lang.String r12 = ",msg"
            r11.append(r12)     // Catch:{ all -> 0x0454 }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x0454 }
            r11.append(r0)     // Catch:{ all -> 0x0454 }
            java.lang.String r0 = r11.toString()     // Catch:{ all -> 0x0454 }
            long r11 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0454 }
            r14 = 0
            long r11 = r11 - r3
            r14 = 1
            m14304a(r0, r11, r14)     // Catch:{ all -> 0x0454 }
            if (r6 == 0) goto L_0x03cb
            r6.close()     // Catch:{ Throwable -> 0x03a4 }
            goto L_0x03cb
        L_0x03a4:
            r0 = move-exception
            r6 = r0
            java.lang.Exception r0 = new java.lang.Exception
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = "[ImageFetch]url:"
            r11.append(r12)
            r11.append(r1)
            java.lang.String r12 = ",msg"
            r11.append(r12)
            java.lang.String r6 = r6.getMessage()
            r11.append(r6)
            java.lang.String r6 = r11.toString()
            r0.<init>(r6)
            m14309q(r0)
        L_0x03cb:
            if (r13 == 0) goto L_0x0402
            if (r8 != 0) goto L_0x03d5
            r13.delete()     // Catch:{ Throwable -> 0x03d3 }
            goto L_0x0402
        L_0x03d3:
            r0 = move-exception
            goto L_0x03da
        L_0x03d5:
            r13.renameTo(r2)     // Catch:{ Throwable -> 0x03d3 }
            r6 = r2
            goto L_0x0403
        L_0x03da:
            java.lang.Exception r2 = new java.lang.Exception
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r8 = "[ImageFetch]url:"
            r6.append(r8)
            r6.append(r1)
            java.lang.String r8 = ",msg"
            r6.append(r8)
            java.lang.String r0 = r0.getMessage()
            r6.append(r0)
            java.lang.String r0 = r6.toString()
            r2.<init>(r0)
            m14309q(r2)
            r16 = r5
            goto L_0x0405
        L_0x0402:
            r6 = r5
        L_0x0403:
            r16 = r6
        L_0x0405:
            if (r15 == 0) goto L_0x040d
            r15.close()     // Catch:{ Exception -> 0x040b }
            goto L_0x040d
        L_0x040b:
            r0 = move-exception
            goto L_0x0415
        L_0x040d:
            if (r9 == 0) goto L_0x043a
            if (r10 == 0) goto L_0x043a
            r9.disconnect()     // Catch:{ Exception -> 0x040b }
            goto L_0x043a
        L_0x0415:
            java.lang.Exception r2 = new java.lang.Exception
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "[ImageFetch]url:"
            r5.append(r6)
            r5.append(r1)
            java.lang.String r6 = ",msg"
            r5.append(r6)
            java.lang.String r0 = r0.getMessage()
            r5.append(r0)
            java.lang.String r0 = r5.toString()
            r2.<init>(r0)
            m14309q(r2)
        L_0x043a:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
        L_0x043f:
            java.lang.String r2 = "[ImageFetch]finish:"
            r0.append(r2)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            long r1 = java.lang.System.currentTimeMillis()
            long r1 = r1 - r3
            m14304a(r0, r1, r7)
            return r16
        L_0x0454:
            r0 = move-exception
            r5 = r0
            r19 = r10
        L_0x0458:
            if (r6 == 0) goto L_0x0485
            r6.close()     // Catch:{ Throwable -> 0x045e }
            goto L_0x0485
        L_0x045e:
            r0 = move-exception
            r6 = r0
            java.lang.Exception r0 = new java.lang.Exception
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "[ImageFetch]url:"
            r10.append(r11)
            r10.append(r1)
            java.lang.String r11 = ",msg"
            r10.append(r11)
            java.lang.String r6 = r6.getMessage()
            r10.append(r6)
            java.lang.String r6 = r10.toString()
            r0.<init>(r6)
            m14309q(r0)
        L_0x0485:
            if (r13 == 0) goto L_0x04b8
            if (r8 != 0) goto L_0x048f
            r13.delete()     // Catch:{ Throwable -> 0x048d }
            goto L_0x04b8
        L_0x048d:
            r0 = move-exception
            goto L_0x0493
        L_0x048f:
            r13.renameTo(r2)     // Catch:{ Throwable -> 0x048d }
            goto L_0x04b8
        L_0x0493:
            java.lang.Exception r2 = new java.lang.Exception
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r8 = "[ImageFetch]url:"
            r6.append(r8)
            r6.append(r1)
            java.lang.String r8 = ",msg"
            r6.append(r8)
            java.lang.String r0 = r0.getMessage()
            r6.append(r0)
            java.lang.String r0 = r6.toString()
            r2.<init>(r0)
            m14309q(r2)
        L_0x04b8:
            if (r15 == 0) goto L_0x04c0
            r15.close()     // Catch:{ Exception -> 0x04be }
            goto L_0x04c0
        L_0x04be:
            r0 = move-exception
            goto L_0x04c8
        L_0x04c0:
            if (r9 == 0) goto L_0x04ed
            if (r19 == 0) goto L_0x04ed
            r9.disconnect()     // Catch:{ Exception -> 0x04be }
            goto L_0x04ed
        L_0x04c8:
            java.lang.Exception r2 = new java.lang.Exception
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r8 = "[ImageFetch]url:"
            r6.append(r8)
            r6.append(r1)
            java.lang.String r8 = ",msg"
            r6.append(r8)
            java.lang.String r0 = r0.getMessage()
            r6.append(r0)
            java.lang.String r0 = r6.toString()
            r2.<init>(r0)
            m14309q(r2)
        L_0x04ed:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "[ImageFetch]finish:"
            r0.append(r2)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            long r1 = java.lang.System.currentTimeMillis()
            long r1 = r1 - r3
            m14304a(r0, r1, r7)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.common.bitmapfun.util.ImageFetcher.m14305aa(java.lang.String, java.lang.String):java.io.File");
    }

    /* renamed from: ar */
    private static String m14306ar(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            m14309q(new Exception("[ImageFetch]Empty URL"));
            return null;
        }
        File diskCacheDir = DiskLruCache.getDiskCacheDir(context, HttpHost.DEFAULT_SCHEME_NAME);
        if (cef == null) {
            cef = DiskLruCache.openCache(context, diskCacheDir, 10485760);
        }
        if (cef == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("[ImageFetch]Failed to openCache:");
            sb.append(diskCacheDir.getAbsolutePath());
            m14309q(new Exception(sb.toString()));
            return null;
        }
        String createFilePath = DiskLruCache.createFilePath(diskCacheDir, str);
        if (createFilePath != null) {
            return createFilePath;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("[ImageFetch]Failed to create cache:");
        sb2.append(str);
        m14309q(new Exception(sb2.toString()));
        return null;
    }

    public static File downloadBitmap(Context context, String str) {
        String ar = m14306ar(context, str);
        File file = new File(ar);
        return (!file.isFile() || !file.exists()) ? m14303Z(str, ar) : file;
    }

    /* renamed from: f */
    private Bitmap m14307f(Integer num) {
        if (num == null) {
            return null;
        }
        try {
            Bitmap processBitmapWithResId = processBitmapWithResId(num.intValue());
            if (processBitmapWithResId != null) {
                Bitmap convertToReqSize = Utils.convertToReqSize(processBitmapWithResId, this.mImageWidth, this.mImageHeight, this.mThumbFitMode);
                if (convertToReqSize != processBitmapWithResId) {
                    processBitmapWithResId.recycle();
                    processBitmapWithResId = convertToReqSize;
                }
            }
            return processBitmapWithResId;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* renamed from: fn */
    private Bitmap m14308fn(String str) {
        File file;
        if (str == null) {
            return null;
        }
        boolean z = false;
        try {
            if (str.startsWith("/")) {
                file = new File(str);
            } else {
                if (!str.startsWith(SocialService.CONST_URL_HTTP_PREFIX)) {
                    if (!str.startsWith("https://")) {
                        file = null;
                    }
                }
                file = downloadBitmap(this.mContext, str);
                z = true;
            }
            if (file != null) {
                Bitmap decodeSampledBitmapFromFile = decodeSampledBitmapFromFile(this.mContext, file.getAbsolutePath(), this.mImageWidth, this.mImageHeight);
                if (decodeSampledBitmapFromFile != null && !z) {
                    Bitmap convertToReqSize = Utils.convertToReqSize(decodeSampledBitmapFromFile, this.mImageWidth, this.mImageHeight, this.mThumbFitMode);
                    if (convertToReqSize != decodeSampledBitmapFromFile) {
                        decodeSampledBitmapFromFile.recycle();
                        decodeSampledBitmapFromFile = convertToReqSize;
                    }
                }
                return decodeSampledBitmapFromFile;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* renamed from: q */
    public static void m14309q(Throwable th) {
        if (cee != null) {
            cee.onError(th);
        }
    }

    /* access modifiers changed from: protected */
    public Bitmap processBitmap(Object obj) {
        return obj instanceof Integer ? m14307f(Integer.valueOf(String.valueOf(obj))) : m14308fn(String.valueOf(obj));
    }
}
