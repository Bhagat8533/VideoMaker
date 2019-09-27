package com.introvd.template.common.filecache;

import android.content.Context;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.router.setting.VivaSettingRouter.SettingLocalLocaleParams;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import p037b.p050b.C1834l;
import p037b.p050b.C1842q;
import p037b.p050b.p054b.C1495b;
import p037b.p050b.p055c.C1505b;
import p037b.p050b.p057e.C1517e;
import p037b.p050b.p057e.C1518f;
import p037b.p050b.p076j.C1820a;

public class FileCacheV2<T> {
    private File aBX;
    /* access modifiers changed from: private */
    public Class<T> ceG;
    /* access modifiers changed from: private */
    public String ceH;
    /* access modifiers changed from: private */
    public boolean ceI;
    /* access modifiers changed from: private */
    public Context context;
    private boolean encrypt = true;
    /* access modifiers changed from: private */
    public String fileName;
    private volatile T mData;
    /* access modifiers changed from: private */
    public Type type;

    public static class Builder {
        private Class ceG;
        private String ceH = SettingLocalLocaleParams.LOCALE_DEFAULT_VALUE;
        private boolean ceI = true;
        private boolean ceK;
        private Context context;
        private String fileName;
        private Type type;

        public Builder(Context context2, String str, Class cls) {
            this.fileName = str;
            this.context = context2;
            this.ceG = cls;
        }

        public Builder(Context context2, String str, Type type2) {
            this.context = context2;
            this.fileName = str;
            this.type = type2;
        }

        public <T> FileCacheV2<T> build() {
            if (!TextUtils.isEmpty(this.fileName)) {
                FileCacheV2<T> fileCacheV2 = new FileCacheV2<>();
                fileCacheV2.context = this.context.getApplicationContext();
                fileCacheV2.ceG = this.ceG;
                fileCacheV2.type = this.type;
                fileCacheV2.ceI = this.ceI;
                fileCacheV2.fileName = this.fileName;
                fileCacheV2.ceH = this.ceH;
                if (this.ceK) {
                    fileCacheV2.m14353Zi();
                }
                return fileCacheV2;
            }
            throw new NullPointerException("fileName is Null");
        }

        public Builder unEncrypted() {
            this.ceK = true;
            return this;
        }
    }

    FileCacheV2() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0021, code lost:
        return;
     */
    /* renamed from: Zg */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void m14352Zg() {
        /*
            r3 = this;
            monitor-enter(r3)
            java.io.File r0 = r3.aBX     // Catch:{ all -> 0x0022 }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r3)
            return
        L_0x0007:
            boolean r0 = r3.ceI     // Catch:{ all -> 0x0022 }
            if (r0 != 0) goto L_0x0017
            android.content.Context r0 = r3.context     // Catch:{ all -> 0x0022 }
            java.lang.String r1 = r3.ceH     // Catch:{ all -> 0x0022 }
            java.lang.String r2 = r3.fileName     // Catch:{ all -> 0x0022 }
            boolean r0 = r3.m14362l(r0, r1, r2)     // Catch:{ all -> 0x0022 }
            if (r0 != 0) goto L_0x0020
        L_0x0017:
            android.content.Context r0 = r3.context     // Catch:{ all -> 0x0022 }
            java.lang.String r1 = r3.ceH     // Catch:{ all -> 0x0022 }
            java.lang.String r2 = r3.fileName     // Catch:{ all -> 0x0022 }
            r3.m14361k(r0, r1, r2)     // Catch:{ all -> 0x0022 }
        L_0x0020:
            monitor-exit(r3)
            return
        L_0x0022:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.common.filecache.FileCacheV2.m14352Zg():void");
    }

    /* access modifiers changed from: private */
    /* renamed from: Zi */
    public void m14353Zi() {
        this.encrypt = false;
    }

    /* renamed from: k */
    private void m14361k(Context context2, String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(context2.getFilesDir().getPath());
        sb.append("/file_cache/");
        sb.append(str);
        sb.append("/");
        sb.append(str2);
        this.aBX = new File(sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append(context2.getFilesDir().getPath());
        sb2.append("/file_cache/");
        sb2.append(str);
        sb2.append("/");
        File file = new File(sb2.toString());
        if (!file.exists()) {
            file.mkdirs();
        }
        if (!this.aBX.exists()) {
            try {
                this.aBX.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: l */
    private boolean m14362l(Context context2, String str, String str2) {
        File externalFilesDir = context2.getExternalFilesDir(null);
        if (externalFilesDir == null) {
            return false;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(externalFilesDir.getPath());
        sb.append("/.file_cache/");
        String sb2 = sb.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append(sb2);
        sb3.append(str);
        sb3.append("/");
        sb3.append(str2);
        this.aBX = new File(sb3.toString());
        StringBuilder sb4 = new StringBuilder();
        sb4.append(sb2);
        sb4.append(str);
        sb4.append("/");
        File file = new File(sb4.toString());
        if (!file.exists()) {
            file.mkdirs();
        }
        if (!this.aBX.exists()) {
            try {
                this.aBX.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    public C1834l<T> getCache() {
        LogUtilsV2.m14227d("getCache");
        return C1834l.m5257ah(Boolean.valueOf(true)).mo10157d(C1820a.aVi()).mo10152c(C1820a.aVi()).mo10167f((C1518f<? super T, ? extends R>) new C1518f<Boolean, T>() {
            /* renamed from: q */
            public T apply(Boolean bool) throws Exception {
                T cacheSync = FileCacheV2.this.getCacheSync();
                if (cacheSync != null) {
                    return cacheSync;
                }
                throw C1505b.m4703z(new Throwable("No Cache"));
            }
        });
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:18|19|(1:21)(1:22)|23|24|25|26) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x006b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public T getCacheSync() {
        /*
            r4 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "readCacheSync Thread ID = "
            r0.append(r1)
            java.lang.Thread r1 = java.lang.Thread.currentThread()
            long r1 = r1.getId()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.introvd.template.common.LogUtilsV2.m14227d(r0)
            r4.m14352Zg()
            T r0 = r4.mData
            if (r0 == 0) goto L_0x0026
            T r0 = r4.mData
            return r0
        L_0x0026:
            java.io.File r0 = r4.aBX
            r1 = 0
            if (r0 != 0) goto L_0x002c
            return r1
        L_0x002c:
            java.lang.Class<com.introvd.template.common.filecache.FileCacheV2> r0 = com.introvd.template.common.filecache.FileCacheV2.class
            monitor-enter(r0)
            boolean r2 = r4.encrypt     // Catch:{ all -> 0x006f }
            if (r2 == 0) goto L_0x003c
            java.io.File r2 = r4.aBX     // Catch:{ all -> 0x006f }
            java.lang.String r3 = "UTF-8"
            java.lang.String r2 = com.introvd.template.common.filecache.C5276a.m14371c(r2, r3)     // Catch:{ all -> 0x006f }
            goto L_0x0044
        L_0x003c:
            java.io.File r2 = r4.aBX     // Catch:{ all -> 0x006f }
            java.lang.String r3 = "UTF-8"
            java.lang.String r2 = com.introvd.template.common.filecache.C5277b.m14373c(r2, r3)     // Catch:{ all -> 0x006f }
        L_0x0044:
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x006f }
            if (r3 == 0) goto L_0x004c
            monitor-exit(r0)     // Catch:{ all -> 0x006f }
            return r1
        L_0x004c:
            java.lang.reflect.Type r1 = r4.type     // Catch:{ Exception -> 0x006b }
            if (r1 == 0) goto L_0x005e
            com.google.gson.Gson r1 = new com.google.gson.Gson     // Catch:{ Exception -> 0x006b }
            r1.<init>()     // Catch:{ Exception -> 0x006b }
            java.lang.reflect.Type r3 = r4.type     // Catch:{ Exception -> 0x006b }
            java.lang.Object r1 = r1.fromJson(r2, r3)     // Catch:{ Exception -> 0x006b }
            r4.mData = r1     // Catch:{ Exception -> 0x006b }
            goto L_0x006b
        L_0x005e:
            com.google.gson.Gson r1 = new com.google.gson.Gson     // Catch:{ Exception -> 0x006b }
            r1.<init>()     // Catch:{ Exception -> 0x006b }
            java.lang.Class<T> r3 = r4.ceG     // Catch:{ Exception -> 0x006b }
            java.lang.Object r1 = r1.fromJson(r2, r3)     // Catch:{ Exception -> 0x006b }
            r4.mData = r1     // Catch:{ Exception -> 0x006b }
        L_0x006b:
            T r1 = r4.mData     // Catch:{ all -> 0x006f }
            monitor-exit(r0)     // Catch:{ all -> 0x006f }
            return r1
        L_0x006f:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x006f }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.common.filecache.FileCacheV2.getCacheSync():java.lang.Object");
    }

    public void saveCache(T t) {
        if (t != null) {
            C1834l.m5257ah(t).mo10157d(C1820a.aVi()).mo10152c(C1820a.aVi()).mo10161e((C1517e<? super T>) new C1517e<T>() {
                public void accept(T t) throws Exception {
                }
            }).mo10167f((C1518f<? super T, ? extends R>) new C1518f<T, Boolean>() {
                /* renamed from: P */
                public Boolean apply(T t) throws Exception {
                    return FileCacheV2.this.saveCacheSync(t);
                }
            }).mo10149b((C1842q<? super T>) new C1842q<Boolean>() {
                /* renamed from: a */
                public void mo9877a(C1495b bVar) {
                }

                /* renamed from: b */
                public void mo9886K(Boolean bool) {
                }

                public void onComplete() {
                }

                public void onError(Throwable th) {
                }
            });
        }
    }

    public Boolean saveCacheSync(T t) {
        StringBuilder sb = new StringBuilder();
        sb.append("saveCacheSync Thread ID = ");
        sb.append(Thread.currentThread().getId());
        LogUtilsV2.m14227d(sb.toString());
        m14352Zg();
        if (this.aBX == null || t == null) {
            return Boolean.valueOf(false);
        }
        String path = this.aBX.getPath();
        try {
            this.mData = t;
            synchronized (FileCacheV2.class) {
                String json = new Gson().toJson((Object) t);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("HttpFileCache save Cache - ");
                sb2.append(json);
                sb2.append("");
                LogUtilsV2.m14227d(sb2.toString());
                if (this.encrypt) {
                    C5276a.m14368a(json, this.aBX, "UTF-8");
                } else {
                    C5277b.m14372a(json, this.aBX, "UTF-8");
                }
            }
            return Boolean.valueOf(true);
        } catch (Exception e) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("CacheFilePath = ");
            sb3.append(path);
            throw new RuntimeException(sb3.toString(), e);
        }
    }
}
