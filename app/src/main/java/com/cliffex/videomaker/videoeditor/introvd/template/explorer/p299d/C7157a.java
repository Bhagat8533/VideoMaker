package com.introvd.template.explorer.p299d;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.os.AsyncTask;
import android.os.Environment;
import android.os.Handler;
import android.text.TextUtils;
import com.flurry.android.Constants;
import com.introvd.template.common.CommonConfigure;
import com.introvd.template.common.ExAsyncTask;
import com.introvd.template.common.LogUtils;
import com.introvd.template.datacenter.DownloadService;
import com.introvd.template.datacenter.SocialConstDef;
import com.introvd.template.videoeditor.model.ExtMediaItem;
import com.introvd.template.videoeditor.model.MediaGroupItem;
import java.io.File;
import java.net.URI;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import p503cz.msebera.android.httpclient.HttpHost;

/* renamed from: com.introvd.template.explorer.d.a */
public final class C7157a {
    private static final String dCA = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).toString();
    private static volatile C7157a dCB;
    public static String dCE;
    public static String dCF;
    /* access modifiers changed from: private */
    public Handler dCC;
    /* access modifiers changed from: private */
    public HashMap<String, Long> dCD = new HashMap<>();
    /* access modifiers changed from: private */
    public long dCG;
    /* access modifiers changed from: private */
    public HashMap<String, C7162c> dCH;
    /* access modifiers changed from: private */
    public Context mContext;

    /* renamed from: com.introvd.template.explorer.d.a$a */
    private class C7159a extends ExAsyncTask<C7161b, Integer, String> {
        LinkedBlockingQueue<Integer> dCI;

        private C7159a() {
            this.dCI = new LinkedBlockingQueue<>();
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public String doInBackground(C7161b... bVarArr) {
            final C7161b bVar = bVarArr[0];
            String str = bVar.dCM;
            String a = C7157a.this.m21178b(bVar);
            LogUtils.m14223i("fileName", a);
            C7157a.this.dCG = DownloadService.enqueue(C7157a.this.mContext.getApplicationContext(), str, a, 0, 6);
            C7157a.this.dCD.put(bVar.dCM, Long.valueOf(C7157a.this.dCG));
            bVar.filePath = a;
            bVar.dCN = C7157a.this.dCG;
            C71601 r0 = new ContentObserver(C7157a.this.dCC) {
                public void onChange(boolean z) {
                    int downloadState = DownloadService.getDownloadState(C7157a.this.mContext, bVar.dCN);
                    if (downloadState == 196608) {
                        int downloadProgress = DownloadService.getDownloadProgress(C7157a.this.mContext, bVar.dCN);
                        if (C7157a.this.dCH.containsKey(bVar.dCM)) {
                            ((C7162c) C7157a.this.dCH.get(bVar.dCM)).mo31641i(bVar.dCN, downloadProgress);
                        }
                    } else if (downloadState != 0) {
                        int downloadProgress2 = DownloadService.getDownloadProgress(C7157a.this.mContext, bVar.dCN);
                        C7157a.this.dCD.remove(bVar.dCM);
                        C7159a.this.dCI.add(Integer.valueOf(downloadProgress2 == 100 ? 131072 : 65536));
                    }
                }
            };
            ContentResolver contentResolver = C7157a.this.mContext.getContentResolver();
            contentResolver.registerContentObserver(SocialConstDef.getTableUri(SocialConstDef.TBL_NAME_DOWNLOAD), true, r0);
            if (bVar.dCN > 0) {
                DownloadService.startDownload(C7157a.this.mContext, bVar.dCN);
                if (C7157a.this.dCH.containsKey(bVar.dCM)) {
                    ((C7162c) C7157a.this.dCH.get(bVar.dCM)).mo31639aI(bVar.dCN);
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append(this.dCI.size());
            sb.append("");
            LogUtils.m14223i("linkblockqueue", sb.toString());
            try {
                this.dCI.take();
                LogUtils.m14223i("likblockqueue", "unlock");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (Throwable th) {
                contentResolver.unregisterContentObserver(r0);
                throw th;
            }
            contentResolver.unregisterContentObserver(r0);
            int downloadState = DownloadService.getDownloadState(C7157a.this.mContext, bVar.dCN);
            if (downloadState == 131072) {
                if (C7157a.this.dCH.containsKey(bVar.dCM)) {
                    ((C7162c) C7157a.this.dCH.get(bVar.dCM)).mo31642i(bVar.dCN, bVar.filePath);
                }
                return bVar.filePath;
            }
            if (downloadState == 65536 && C7157a.this.dCH.containsKey(bVar.dCM)) {
                ((C7162c) C7157a.this.dCH.get(bVar.dCM)).axQ();
            }
            C7157a.this.dCH.remove(bVar.dCM);
            return null;
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            this.dCI.clear();
        }
    }

    /* renamed from: com.introvd.template.explorer.d.a$b */
    private class C7161b {
        public int cTx;
        public String dCM;
        public long dCN;
        public int dCO;
        public String filePath;

        public C7161b(String str, int i, int i2) {
            this.dCM = str;
            this.cTx = i;
            this.dCO = i2;
        }
    }

    /* renamed from: com.introvd.template.explorer.d.a$c */
    public interface C7162c {
        /* renamed from: aI */
        void mo31639aI(long j);

        void axQ();

        /* renamed from: i */
        void mo31641i(long j, int i);

        /* renamed from: i */
        void mo31642i(long j, String str);
    }

    private C7157a(Context context) {
        this.mContext = context;
        if (this.dCH == null) {
            this.dCH = new HashMap<>();
        }
    }

    /* renamed from: a */
    private void m21176a(C7161b bVar) {
        if (!this.dCD.containsKey(bVar.dCM)) {
            new C7159a().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, bVar);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public String m21178b(C7161b bVar) {
        String str;
        String str2;
        String str3 = bVar.dCM;
        String jk = m21188jk(str3);
        String jl = m21189jl(str3);
        StringBuilder sb = new StringBuilder();
        sb.append(dCA);
        sb.append(File.separator);
        sb.append("XYONLINE/");
        StringBuilder sb2 = new StringBuilder(sb.toString());
        String str4 = "";
        switch (bVar.cTx) {
            case 0:
                str2 = "images/";
                str = ".jpg";
                break;
            case 1:
                str2 = "videos/";
                str = ".mp4";
                break;
            default:
                str = str4;
                str2 = null;
                break;
        }
        int i = bVar.dCO;
        if (i == 28) {
            sb2.append("facebook/");
            if (!TextUtils.isEmpty(dCE)) {
                sb2.append(dCE);
                sb2.append("/");
            }
        } else if (i != 31) {
            sb2.append("others/");
        } else {
            sb2.append("instagram/");
            if (!TextUtils.isEmpty(dCF)) {
                sb2.append(dCF);
                sb2.append("/");
            }
        }
        if (!TextUtils.isEmpty(str2)) {
            sb2.append(str2);
        }
        sb2.append(jl);
        if (TextUtils.isEmpty(jk)) {
            sb2.append(str);
        } else {
            sb2.append(jk);
        }
        return sb2.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0038 A[SYNTHETIC, Splitter:B:24:0x0038] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0040 A[Catch:{ IOException -> 0x003c }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x004b A[SYNTHETIC, Splitter:B:33:0x004b] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0053 A[Catch:{ IOException -> 0x004f }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void m21181d(java.lang.Object r2, java.lang.String r3) {
        /*
            java.io.File r0 = new java.io.File
            r0.<init>(r3)
            boolean r3 = r0.exists()
            if (r3 == 0) goto L_0x000e
            r0.delete()
        L_0x000e:
            r3 = 0
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0031, all -> 0x002e }
            r1.<init>(r0)     // Catch:{ Exception -> 0x0031, all -> 0x002e }
            java.io.ObjectOutputStream r0 = new java.io.ObjectOutputStream     // Catch:{ Exception -> 0x002c }
            r0.<init>(r1)     // Catch:{ Exception -> 0x002c }
            r0.writeObject(r2)     // Catch:{ Exception -> 0x0029, all -> 0x0026 }
            r0.flush()     // Catch:{ Exception -> 0x0029, all -> 0x0026 }
            r0.close()     // Catch:{ IOException -> 0x003c }
            r1.close()     // Catch:{ IOException -> 0x003c }
            goto L_0x0047
        L_0x0026:
            r2 = move-exception
            r3 = r0
            goto L_0x0049
        L_0x0029:
            r2 = move-exception
            r3 = r0
            goto L_0x0033
        L_0x002c:
            r2 = move-exception
            goto L_0x0033
        L_0x002e:
            r2 = move-exception
            r1 = r3
            goto L_0x0049
        L_0x0031:
            r2 = move-exception
            r1 = r3
        L_0x0033:
            r2.printStackTrace()     // Catch:{ all -> 0x0048 }
            if (r3 == 0) goto L_0x003e
            r3.close()     // Catch:{ IOException -> 0x003c }
            goto L_0x003e
        L_0x003c:
            r2 = move-exception
            goto L_0x0044
        L_0x003e:
            if (r1 == 0) goto L_0x0047
            r1.close()     // Catch:{ IOException -> 0x003c }
            goto L_0x0047
        L_0x0044:
            r2.printStackTrace()
        L_0x0047:
            return
        L_0x0048:
            r2 = move-exception
        L_0x0049:
            if (r3 == 0) goto L_0x0051
            r3.close()     // Catch:{ IOException -> 0x004f }
            goto L_0x0051
        L_0x004f:
            r3 = move-exception
            goto L_0x0057
        L_0x0051:
            if (r1 == 0) goto L_0x005a
            r1.close()     // Catch:{ IOException -> 0x004f }
            goto L_0x005a
        L_0x0057:
            r3.printStackTrace()
        L_0x005a:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.explorer.p299d.C7157a.m21181d(java.lang.Object, java.lang.String):void");
    }

    /* renamed from: dI */
    private static String m21182dI(String str) {
        try {
            return new URI(str).getPath();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /* renamed from: fY */
    public static C7157a m21184fY(Context context) {
        if (context != null) {
            if (dCB == null) {
                synchronized (C7157a.class) {
                    if (dCB == null) {
                        dCB = new C7157a(context);
                    }
                }
            }
            return dCB;
        }
        throw new NullPointerException("context can't be null");
    }

    /* renamed from: fl */
    private byte[] m21185fl(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            if (instance == null) {
                return str.getBytes();
            }
            instance.update(str.getBytes());
            return instance.digest();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return str.getBytes();
        }
    }

    /* renamed from: fm */
    private String m21186fm(String str) {
        return toHexString(m21185fl(str), "");
    }

    /* renamed from: g */
    public static void m21187g(int i, Object obj) {
        String str = obj instanceof List ? ".list" : obj instanceof Map ? ".map" : null;
        m21181d(obj, m21193s(i, str));
    }

    /* renamed from: jk */
    private synchronized String m21188jk(String str) {
        String str2;
        str2 = "";
        String dI = m21182dI(str);
        int lastIndexOf = dI.lastIndexOf(".");
        if (lastIndexOf >= 0) {
            str2 = dI.substring(lastIndexOf, dI.length());
        }
        return str2;
    }

    /* renamed from: jl */
    private synchronized String m21189jl(String str) {
        return m21186fm(str);
    }

    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v1, types: [java.io.ObjectInputStream] */
    /* JADX WARNING: type inference failed for: r0v3, types: [java.io.ObjectInputStream] */
    /* JADX WARNING: type inference failed for: r3v0 */
    /* JADX WARNING: type inference failed for: r1v4 */
    /* JADX WARNING: type inference failed for: r0v5 */
    /* JADX WARNING: type inference failed for: r0v7 */
    /* JADX WARNING: type inference failed for: r1v5 */
    /* JADX WARNING: type inference failed for: r0v11 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x003d A[SYNTHETIC, Splitter:B:26:0x003d] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0045 A[Catch:{ IOException -> 0x0041 }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0054 A[SYNTHETIC, Splitter:B:37:0x0054] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x005c A[Catch:{ IOException -> 0x0058 }] */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* renamed from: jn */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.Object m21190jn(java.lang.String r4) {
        /*
            java.io.File r0 = new java.io.File
            r0.<init>(r4)
            boolean r4 = r0.exists()
            r1 = 0
            if (r4 != 0) goto L_0x000d
            return r1
        L_0x000d:
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0035, all -> 0x0032 }
            r4.<init>(r0)     // Catch:{ Exception -> 0x0035, all -> 0x0032 }
            java.io.ObjectInputStream r0 = new java.io.ObjectInputStream     // Catch:{ Exception -> 0x002f, all -> 0x002a }
            r0.<init>(r4)     // Catch:{ Exception -> 0x002f, all -> 0x002a }
            java.lang.Object r2 = r0.readObject()     // Catch:{ Exception -> 0x0028 }
            r0.close()     // Catch:{ IOException -> 0x0022 }
            r4.close()     // Catch:{ IOException -> 0x0022 }
            goto L_0x0026
        L_0x0022:
            r4 = move-exception
            r4.printStackTrace()
        L_0x0026:
            r1 = r2
            goto L_0x004c
        L_0x0028:
            r2 = move-exception
            goto L_0x0038
        L_0x002a:
            r0 = move-exception
            r3 = r0
            r0 = r4
            r4 = r3
            goto L_0x0052
        L_0x002f:
            r2 = move-exception
            r0 = r1
            goto L_0x0038
        L_0x0032:
            r4 = move-exception
            r0 = r1
            goto L_0x0052
        L_0x0035:
            r2 = move-exception
            r4 = r1
            r0 = r4
        L_0x0038:
            r2.printStackTrace()     // Catch:{ all -> 0x004d }
            if (r0 == 0) goto L_0x0043
            r0.close()     // Catch:{ IOException -> 0x0041 }
            goto L_0x0043
        L_0x0041:
            r4 = move-exception
            goto L_0x0049
        L_0x0043:
            if (r4 == 0) goto L_0x004c
            r4.close()     // Catch:{ IOException -> 0x0041 }
            goto L_0x004c
        L_0x0049:
            r4.printStackTrace()
        L_0x004c:
            return r1
        L_0x004d:
            r1 = move-exception
            r3 = r0
            r0 = r4
            r4 = r1
            r1 = r3
        L_0x0052:
            if (r1 == 0) goto L_0x005a
            r1.close()     // Catch:{ IOException -> 0x0058 }
            goto L_0x005a
        L_0x0058:
            r0 = move-exception
            goto L_0x0060
        L_0x005a:
            if (r0 == 0) goto L_0x0063
            r0.close()     // Catch:{ IOException -> 0x0058 }
            goto L_0x0063
        L_0x0060:
            r0.printStackTrace()
        L_0x0063:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.explorer.p299d.C7157a.m21190jn(java.lang.String):java.lang.Object");
    }

    /* renamed from: qW */
    public static List<MediaGroupItem> m21191qW(int i) {
        return (List) m21190jn(m21193s(i, ".list"));
    }

    /* renamed from: qX */
    public static Map<String, List<ExtMediaItem>> m21192qX(int i) {
        return (Map) m21190jn(m21193s(i, ".map"));
    }

    /* renamed from: s */
    private static String m21193s(int i, String str) {
        StringBuilder sb = new StringBuilder(CommonConfigure.APP_PRIVATE_ROOT_PATH);
        if (i == 28) {
            sb.append("/facebook");
            sb.append(dCE);
        } else if (i == 31) {
            sb.append("/instagram");
            sb.append(dCF);
        }
        sb.append(str);
        return sb.toString();
    }

    private String toHexString(byte[] bArr, String str) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            sb.append(Integer.toHexString(b & Constants.UNKNOWN));
            sb.append(str);
        }
        return sb.toString();
    }

    /* renamed from: a */
    public String mo31632a(String str, int i, int i2, C7162c cVar) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        C7161b bVar = new C7161b(str, i, i2);
        String b = bVar.dCM.startsWith(HttpHost.DEFAULT_SCHEME_NAME) ? m21178b(bVar) : bVar.dCM;
        if (new File(b).exists()) {
            return b;
        }
        if (cVar != null) {
            this.dCH.put(str, cVar);
            m21176a(bVar);
        }
        return null;
    }

    /* renamed from: a */
    public void mo31633a(Handler handler) {
        this.dCC = handler;
    }

    /* renamed from: jm */
    public void mo31634jm(String str) {
        DownloadService.stopDownload(this.mContext, this.dCG);
        this.dCD.remove(str);
    }

    /* renamed from: z */
    public boolean mo31635z(String str, int i) {
        if (!str.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
            return new File(str).exists();
        }
        C7161b bVar = new C7161b(str, i, 31);
        C7161b bVar2 = new C7161b(str, i, 28);
        return new File(m21178b(bVar)).exists() || new File(m21178b(bVar2)).exists();
    }
}
