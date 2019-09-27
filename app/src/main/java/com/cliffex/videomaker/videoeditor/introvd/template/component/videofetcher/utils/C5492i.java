package com.introvd.template.component.videofetcher.utils;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.media.MediaMetadataRetriever;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import com.introvd.template.component.videofetcher.p240d.C5408e;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import p037b.p050b.C1834l;
import p037b.p050b.p054b.C1495b;
import p037b.p050b.p057e.C1517e;
import p037b.p050b.p076j.C1820a;

/* renamed from: com.introvd.template.component.videofetcher.utils.i */
public class C5492i {
    private static C5492i cmA;
    public static final String cmE;
    /* access modifiers changed from: private */
    public static String cmF = "video_fetcher_thumb.jpg";
    private List<C1495b> cmB = new ArrayList();
    /* access modifiers changed from: private */
    public HashMap<String, String> cmC = new HashMap<>();
    /* access modifiers changed from: private */
    public final C5490h cmD = new C5490h();

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(Environment.getExternalStorageDirectory().getAbsolutePath());
        sb.append("/DCIM/.thumbnailIamge/");
        cmE = sb.toString();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m14909a(Bitmap bitmap, String str, String str2) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("bitmapsaveBitmap: path--");
        sb.append(str);
        sb.append("--fileName--");
        sb.append(str2);
        Log.i("ruomiz", sb.toString());
        FileOutputStream fileOutputStream = new FileOutputStream(new File(str, str2));
        bitmap.compress(CompressFormat.JPEG, 100, fileOutputStream);
        fileOutputStream.flush();
        fileOutputStream.close();
    }

    public static C5492i aaE() {
        if (cmA == null) {
            synchronized (C5492i.class) {
                if (cmA == null) {
                    cmA = new C5492i();
                }
            }
        }
        return cmA;
    }

    /* renamed from: a */
    public void mo27177a(final String str, final C5408e eVar) {
        if (!TextUtils.isEmpty(str) && C5488f.m14899fN(str)) {
            if (this.cmC == null || !this.cmC.containsKey(str)) {
                C1495b a = C1834l.m5257ah(Boolean.valueOf(true)).mo10171h(500, TimeUnit.MILLISECONDS).mo10157d(C1820a.aVi()).mo10152c(C1820a.aVi()).mo10128a((C1517e<? super T>) new C1517e<Boolean>() {
                    /* renamed from: d */
                    public void accept(Boolean bool) {
                        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                        try {
                            FileInputStream fileInputStream = new FileInputStream(new File(str).getAbsolutePath());
                            mediaMetadataRetriever.setDataSource(fileInputStream.getFD());
                            fileInputStream.close();
                            if ("yes".equals(mediaMetadataRetriever.extractMetadata(17))) {
                                String extractMetadata = mediaMetadataRetriever.extractMetadata(9);
                                if (!TextUtils.isEmpty(extractMetadata)) {
                                    String kf = C5487e.m14896kf(Integer.parseInt(extractMetadata));
                                    eVar.mo26946dV(kf);
                                    C5492i.this.cmC.put(str, kf);
                                }
                            }
                            try {
                            } catch (RuntimeException e) {
                                e.printStackTrace();
                            }
                        } catch (NumberFormatException e2) {
                            eVar.mo26946dV("00:00");
                            e2.printStackTrace();
                        } catch (RuntimeException e3) {
                            e3.printStackTrace();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        } finally {
                            try {
                                mediaMetadataRetriever.release();
                            } catch (RuntimeException e5) {
                                e5.printStackTrace();
                            }
                        }
                    }
                }, (C1517e<? super Throwable>) new C1517e<Throwable>() {
                    /* renamed from: m */
                    public void accept(Throwable th) throws Exception {
                        C5489g.m14902d("ruomiz", th.toString());
                    }
                });
                if (this.cmB != null) {
                    this.cmB.add(a);
                }
            } else {
                eVar.mo26946dV((String) this.cmC.get(str));
            }
        }
    }

    public void aaF() {
        if (this.cmB != null && !this.cmB.isEmpty()) {
            for (C1495b bVar : this.cmB) {
                if (bVar != null && !bVar.aAy()) {
                    bVar.dispose();
                }
            }
        }
    }

    /* renamed from: aj */
    public void mo27179aj(final String str, final String str2) {
        C1820a.aVi().mo10058o(new Runnable() {
            /* JADX WARNING: Removed duplicated region for block: B:31:0x00c8  */
            /* JADX WARNING: Removed duplicated region for block: B:36:0x0103  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                    r6 = this;
                    java.lang.String r0 = "ruomiz"
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder
                    r1.<init>()
                    java.lang.String r2 = "bitmap--getNetWorkThumImage: --"
                    r1.append(r2)
                    java.lang.String r2 = r3
                    r1.append(r2)
                    java.lang.String r1 = r1.toString()
                    android.util.Log.i(r0, r1)
                    java.lang.String r0 = r4
                    boolean r0 = android.text.TextUtils.isEmpty(r0)
                    if (r0 != 0) goto L_0x012b
                    java.lang.String r0 = r3
                    boolean r0 = android.text.TextUtils.isEmpty(r0)
                    if (r0 == 0) goto L_0x002a
                    goto L_0x012b
                L_0x002a:
                    java.lang.String r0 = r4
                    java.lang.String r1 = "http://"
                    boolean r0 = r0.startsWith(r1)
                    if (r0 != 0) goto L_0x003f
                    java.lang.String r0 = r4
                    java.lang.String r1 = "https://"
                    boolean r0 = r0.startsWith(r1)
                    if (r0 != 0) goto L_0x003f
                    return
                L_0x003f:
                    r0 = 0
                    com.introvd.template.component.videofetcher.utils.i r1 = com.introvd.template.component.videofetcher.utils.C5492i.this
                    com.introvd.template.component.videofetcher.utils.h r1 = r1.cmD
                    if (r1 == 0) goto L_0x007b
                    com.introvd.template.component.videofetcher.utils.i r1 = com.introvd.template.component.videofetcher.utils.C5492i.this
                    com.introvd.template.component.videofetcher.utils.h r1 = r1.cmD
                    java.lang.String r2 = r3
                    android.graphics.Bitmap r1 = r1.getBitmapFromMemCache(r2)
                    if (r1 == 0) goto L_0x007b
                    java.lang.String r0 = "ruomiz"
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder
                    r1.<init>()
                    java.lang.String r2 = "bitmap==getNetWorkThumImage: --mLruCacheHelper-222-"
                    r1.append(r2)
                    java.lang.String r2 = r3
                    r1.append(r2)
                    java.lang.String r1 = r1.toString()
                    android.util.Log.d(r0, r1)
                    com.introvd.template.component.videofetcher.utils.i r0 = com.introvd.template.component.videofetcher.utils.C5492i.this
                    com.introvd.template.component.videofetcher.utils.h r0 = r0.cmD
                    java.lang.String r1 = r3
                    android.graphics.Bitmap r0 = r0.getBitmapFromMemCache(r1)
                    goto L_0x00c0
                L_0x007b:
                    android.media.MediaMetadataRetriever r1 = new android.media.MediaMetadataRetriever
                    r1.<init>()
                    java.lang.String r2 = r4     // Catch:{ Exception -> 0x00b9 }
                    java.util.Hashtable r3 = new java.util.Hashtable     // Catch:{ Exception -> 0x00b9 }
                    r3.<init>()     // Catch:{ Exception -> 0x00b9 }
                    r1.setDataSource(r2, r3)     // Catch:{ Exception -> 0x00b9 }
                    r2 = 17
                    java.lang.String r2 = r1.extractMetadata(r2)     // Catch:{ Exception -> 0x00b9 }
                    java.lang.String r3 = "ruomiz"
                    java.lang.String r4 = "bitmap--getNetWorkThumImage: --mLruCacheHelper-hasVideo-"
                    android.util.Log.d(r3, r4)     // Catch:{ Exception -> 0x00b9 }
                    java.lang.String r3 = "yes"
                    boolean r2 = r3.equals(r2)     // Catch:{ Exception -> 0x00b9 }
                    if (r2 == 0) goto L_0x00bd
                    r2 = -1
                    android.graphics.Bitmap r2 = r1.getFrameAtTime(r2)     // Catch:{ Exception -> 0x00b9 }
                    com.introvd.template.component.videofetcher.utils.i r0 = com.introvd.template.component.videofetcher.utils.C5492i.this     // Catch:{ Exception -> 0x00b2 }
                    com.introvd.template.component.videofetcher.utils.h r0 = r0.cmD     // Catch:{ Exception -> 0x00b2 }
                    java.lang.String r3 = r3     // Catch:{ Exception -> 0x00b2 }
                    r0.mo27173b(r3, r2)     // Catch:{ Exception -> 0x00b2 }
                    r0 = r2
                    goto L_0x00bd
                L_0x00b2:
                    r0 = move-exception
                    r5 = r2
                    r2 = r0
                    r0 = r5
                    goto L_0x00ba
                L_0x00b7:
                    r0 = move-exception
                    goto L_0x0127
                L_0x00b9:
                    r2 = move-exception
                L_0x00ba:
                    r2.printStackTrace()     // Catch:{ all -> 0x00b7 }
                L_0x00bd:
                    r1.release()
                L_0x00c0:
                    java.lang.String r1 = r3
                    boolean r1 = android.text.TextUtils.isEmpty(r1)
                    if (r1 != 0) goto L_0x00ec
                    java.lang.String r1 = r3
                    java.lang.String r2 = "."
                    boolean r1 = r1.contains(r2)
                    if (r1 == 0) goto L_0x00ec
                    java.lang.String r1 = r3
                    java.lang.String r1 = com.introvd.template.component.videofetcher.utils.C5485c.m14892fM(r1)
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder
                    r2.<init>()
                    r2.append(r1)
                    java.lang.String r1 = com.introvd.template.component.videofetcher.utils.C5492i.cmF
                    r2.append(r1)
                    java.lang.String r1 = r2.toString()
                    goto L_0x0101
                L_0x00ec:
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder
                    r1.<init>()
                    java.lang.String r2 = r3
                    r1.append(r2)
                    java.lang.String r2 = com.introvd.template.component.videofetcher.utils.C5492i.cmF
                    r1.append(r2)
                    java.lang.String r1 = r1.toString()
                L_0x0101:
                    if (r0 == 0) goto L_0x0126
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder
                    r2.<init>()
                    java.lang.String r3 = com.introvd.template.component.videofetcher.utils.C5492i.cmE
                    r2.append(r3)
                    r2.append(r1)
                    java.lang.String r2 = r2.toString()
                    boolean r2 = com.introvd.template.component.videofetcher.utils.C5488f.m14899fN(r2)
                    if (r2 != 0) goto L_0x0126
                    com.introvd.template.component.videofetcher.utils.i r2 = com.introvd.template.component.videofetcher.utils.C5492i.this     // Catch:{ IOException -> 0x0122 }
                    java.lang.String r3 = com.introvd.template.component.videofetcher.utils.C5492i.cmE     // Catch:{ IOException -> 0x0122 }
                    r2.m14909a(r0, r3, r1)     // Catch:{ IOException -> 0x0122 }
                    goto L_0x0126
                L_0x0122:
                    r0 = move-exception
                    r0.printStackTrace()
                L_0x0126:
                    return
                L_0x0127:
                    r1.release()
                    throw r0
                L_0x012b:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.component.videofetcher.utils.C5492i.C54953.run():void");
            }
        });
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x006e A[Catch:{ RuntimeException -> 0x0169 }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x007b A[Catch:{ RuntimeException -> 0x0169 }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x008e  */
    /* renamed from: f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.introvd.template.component.videofetcher.p239c.C5391a mo27180f(com.introvd.template.component.videofetcher.p239c.C5391a r9) {
        /*
            r8 = this;
            android.media.MediaMetadataRetriever r0 = new android.media.MediaMetadataRetriever
            r0.<init>()
            java.lang.String r1 = r9.getFilePath()
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x016e
            java.lang.String r1 = r9.getFilePath()
            boolean r1 = com.introvd.template.component.videofetcher.utils.C5488f.m14899fN(r1)
            if (r1 != 0) goto L_0x001b
            goto L_0x016e
        L_0x001b:
            java.lang.String r1 = r9.getFilePath()     // Catch:{ RuntimeException -> 0x0169 }
            r0.setDataSource(r1)     // Catch:{ RuntimeException -> 0x0169 }
            r1 = 17
            java.lang.String r2 = r0.extractMetadata(r1)     // Catch:{ RuntimeException -> 0x0169 }
            java.lang.String r3 = "yes"
            boolean r2 = r3.equals(r2)     // Catch:{ RuntimeException -> 0x0169 }
            if (r2 != 0) goto L_0x0031
            return r9
        L_0x0031:
            int r2 = android.os.Build.VERSION.SDK_INT     // Catch:{ RuntimeException -> 0x0169 }
            r3 = 0
            if (r2 < r1) goto L_0x0043
            r1 = 24
            java.lang.String r1 = r0.extractMetadata(r1)     // Catch:{ RuntimeException -> 0x0169 }
            if (r1 == 0) goto L_0x0043
            int r1 = java.lang.Integer.parseInt(r1)     // Catch:{ RuntimeException -> 0x0169 }
            r3 = r1
        L_0x0043:
            r1 = 18
            java.lang.String r1 = r0.extractMetadata(r1)     // Catch:{ RuntimeException -> 0x0169 }
            int r1 = java.lang.Integer.parseInt(r1)     // Catch:{ RuntimeException -> 0x0169 }
            r2 = 19
            java.lang.String r2 = r0.extractMetadata(r2)     // Catch:{ RuntimeException -> 0x0169 }
            int r2 = java.lang.Integer.parseInt(r2)     // Catch:{ RuntimeException -> 0x0169 }
            r4 = 9
            java.lang.String r4 = r0.extractMetadata(r4)     // Catch:{ RuntimeException -> 0x0169 }
            r5 = 270(0x10e, float:3.78E-43)
            r6 = 90
            if (r3 == r6) goto L_0x0068
            if (r3 != r5) goto L_0x0066
            goto L_0x0068
        L_0x0066:
            r7 = r1
            goto L_0x0069
        L_0x0068:
            r7 = r2
        L_0x0069:
            r9.mo26989jX(r7)     // Catch:{ RuntimeException -> 0x0169 }
            if (r3 == r6) goto L_0x0072
            if (r3 != r5) goto L_0x0071
            goto L_0x0072
        L_0x0071:
            r1 = r2
        L_0x0072:
            r9.mo26990jY(r1)     // Catch:{ RuntimeException -> 0x0169 }
            boolean r1 = android.text.TextUtils.isEmpty(r4)     // Catch:{ RuntimeException -> 0x0169 }
            if (r1 != 0) goto L_0x0086
            int r1 = java.lang.Integer.parseInt(r4)     // Catch:{ RuntimeException -> 0x0169 }
            java.lang.String r1 = com.introvd.template.component.videofetcher.utils.C5487e.m14896kf(r1)     // Catch:{ RuntimeException -> 0x0169 }
            r9.mo26982fA(r1)     // Catch:{ RuntimeException -> 0x0169 }
        L_0x0086:
            java.lang.String r1 = r9.thumbnailPath
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 == 0) goto L_0x0160
            com.introvd.template.component.videofetcher.utils.h r1 = r8.cmD
            if (r1 == 0) goto L_0x00a7
            com.introvd.template.component.videofetcher.utils.h r1 = r8.cmD
            java.lang.String r2 = r9.filePath
            android.graphics.Bitmap r1 = r1.getBitmapFromMemCache(r2)
            if (r1 == 0) goto L_0x00a7
            com.introvd.template.component.videofetcher.utils.h r1 = r8.cmD
            java.lang.String r2 = r9.getName()
            android.graphics.Bitmap r1 = r1.getBitmapFromMemCache(r2)
            goto L_0x00bf
        L_0x00a7:
            r1 = -1
            android.graphics.Bitmap r1 = r0.getFrameAtTime(r1)
            if (r1 != 0) goto L_0x00b0
            return r9
        L_0x00b0:
            com.introvd.template.component.videofetcher.utils.h r2 = r8.cmD
            if (r2 == 0) goto L_0x00bf
            if (r1 == 0) goto L_0x00bf
            com.introvd.template.component.videofetcher.utils.h r2 = r8.cmD
            java.lang.String r3 = r9.getName()
            r2.mo27173b(r3, r1)
        L_0x00bf:
            java.io.File r2 = new java.io.File
            java.lang.String r3 = cmE
            r2.<init>(r3)
            boolean r3 = r2.exists()
            if (r3 != 0) goto L_0x00cf
            r2.mkdirs()
        L_0x00cf:
            java.lang.String r3 = r9.getName()     // Catch:{ IOException -> 0x0155 }
            java.lang.String r3 = r3.trim()     // Catch:{ IOException -> 0x0155 }
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch:{ IOException -> 0x0155 }
            if (r4 != 0) goto L_0x00fb
            java.lang.String r4 = "."
            boolean r4 = r3.contains(r4)     // Catch:{ IOException -> 0x0155 }
            if (r4 == 0) goto L_0x00fb
            java.lang.String r3 = com.introvd.template.component.videofetcher.utils.C5485c.m14892fM(r3)     // Catch:{ IOException -> 0x0155 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0155 }
            r4.<init>()     // Catch:{ IOException -> 0x0155 }
            r4.append(r3)     // Catch:{ IOException -> 0x0155 }
            java.lang.String r3 = cmF     // Catch:{ IOException -> 0x0155 }
            r4.append(r3)     // Catch:{ IOException -> 0x0155 }
            java.lang.String r3 = r4.toString()     // Catch:{ IOException -> 0x0155 }
            goto L_0x010c
        L_0x00fb:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0155 }
            r4.<init>()     // Catch:{ IOException -> 0x0155 }
            r4.append(r3)     // Catch:{ IOException -> 0x0155 }
            java.lang.String r3 = cmF     // Catch:{ IOException -> 0x0155 }
            r4.append(r3)     // Catch:{ IOException -> 0x0155 }
            java.lang.String r3 = r4.toString()     // Catch:{ IOException -> 0x0155 }
        L_0x010c:
            java.lang.String r4 = "bitmap"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0155 }
            r5.<init>()     // Catch:{ IOException -> 0x0155 }
            java.lang.String r6 = "getThumImageInfo: "
            r5.append(r6)     // Catch:{ IOException -> 0x0155 }
            r5.append(r3)     // Catch:{ IOException -> 0x0155 }
            java.lang.String r5 = r5.toString()     // Catch:{ IOException -> 0x0155 }
            android.util.Log.d(r4, r5)     // Catch:{ IOException -> 0x0155 }
            if (r1 == 0) goto L_0x0140
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0155 }
            r4.<init>()     // Catch:{ IOException -> 0x0155 }
            java.lang.String r5 = cmE     // Catch:{ IOException -> 0x0155 }
            r4.append(r5)     // Catch:{ IOException -> 0x0155 }
            r4.append(r3)     // Catch:{ IOException -> 0x0155 }
            java.lang.String r4 = r4.toString()     // Catch:{ IOException -> 0x0155 }
            boolean r4 = com.introvd.template.component.videofetcher.utils.C5488f.m14899fN(r4)     // Catch:{ IOException -> 0x0155 }
            if (r4 != 0) goto L_0x0140
            java.lang.String r4 = cmE     // Catch:{ IOException -> 0x0155 }
            r8.m14909a(r1, r4, r3)     // Catch:{ IOException -> 0x0155 }
        L_0x0140:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0155 }
            r1.<init>()     // Catch:{ IOException -> 0x0155 }
            java.lang.String r4 = cmE     // Catch:{ IOException -> 0x0155 }
            r1.append(r4)     // Catch:{ IOException -> 0x0155 }
            r1.append(r3)     // Catch:{ IOException -> 0x0155 }
            java.lang.String r1 = r1.toString()     // Catch:{ IOException -> 0x0155 }
            r9.mo26983fB(r1)     // Catch:{ IOException -> 0x0155 }
            goto L_0x0160
        L_0x0155:
            r1 = move-exception
            java.lang.String r2 = r2.getAbsolutePath()
            r9.mo26983fB(r2)
            r1.printStackTrace()
        L_0x0160:
            r0.release()     // Catch:{ RuntimeException -> 0x0164 }
            goto L_0x0168
        L_0x0164:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0168:
            return r9
        L_0x0169:
            r0 = move-exception
            r0.printStackTrace()
            return r9
        L_0x016e:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.component.videofetcher.utils.C5492i.mo27180f(com.introvd.template.component.videofetcher.c.a):com.introvd.template.component.videofetcher.c.a");
    }

    /* renamed from: fQ */
    public Bitmap mo27181fQ(String str) {
        if (this.cmD != null && this.cmD.getBitmapFromMemCache(str) != null) {
            return this.cmD.getBitmapFromMemCache(str);
        }
        C5489g.m14904i("ruomiz", "bitmap--mLruCacheHelper-");
        return null;
    }

    /* renamed from: fR */
    public String mo27182fR(String str) {
        String str2;
        if (TextUtils.isEmpty(str) || !str.contains(".")) {
            StringBuilder sb = new StringBuilder();
            sb.append(cmE);
            sb.append(str);
            sb.append(cmF);
            str2 = sb.toString();
        } else {
            String fM = C5485c.m14892fM(str);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(cmE);
            sb2.append(fM);
            sb2.append(cmF);
            str2 = sb2.toString();
        }
        if (TextUtils.isEmpty(str2) || !C5488f.m14899fN(str2)) {
            return null;
        }
        return str2;
    }
}
