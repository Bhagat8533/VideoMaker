package com.introvd.template.common.filecache;

import android.content.Context;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.router.setting.VivaSettingRouter.SettingLocalLocaleParams;
import java.io.File;
import java.io.IOException;
import p037b.p050b.C1834l;
import p037b.p050b.C1838m;
import p037b.p050b.C1839n;
import p037b.p050b.C1842q;
import p037b.p050b.p054b.C1495b;
import p037b.p050b.p055c.C1505b;
import p037b.p050b.p057e.C1517e;
import p037b.p050b.p057e.C1518f;
import p037b.p050b.p076j.C1820a;

public class FileCache<T> {
    private File aBX;
    private final String cacheKey;
    private final Class<T> ceG;
    private final String ceH;
    private final boolean ceI;
    private final Context context;
    private boolean encrypt = true;
    private volatile T mData;

    public static class Builder<T> {
        private String cacheKey;
        private Class<T> ceG;
        private String ceH = SettingLocalLocaleParams.LOCALE_DEFAULT_VALUE;
        private boolean ceI = true;
        private boolean ceK;
        private Context context;

        public Builder(Context context2, Class<T> cls) {
            this.context = context2;
            this.ceG = cls;
        }

        public FileCache<T> build() {
            FileCache fileCache = new FileCache(this.context, this.ceG, this.ceI, this.ceH, this.cacheKey);
            if (this.ceK) {
                fileCache.m14340Zi();
            }
            return fileCache;
        }

        public Builder<T> setCacheKey(String str) {
            this.cacheKey = str;
            return this;
        }

        public Builder<T> setFileSaveInternal(boolean z) {
            this.ceI = z;
            return this;
        }

        public Builder<T> setRelativeDir(String str) {
            this.ceH = str;
            return this;
        }
    }

    FileCache(Context context2, Class<T> cls, boolean z, String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            str2 = cls.getSimpleName();
        }
        this.context = context2.getApplicationContext();
        this.ceG = cls;
        this.ceI = z;
        this.cacheKey = str2;
        this.ceH = str;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0042, code lost:
        return;
     */
    /* renamed from: Zg */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void m14338Zg() {
        /*
            r3 = this;
            monitor-enter(r3)
            java.io.File r0 = r3.aBX     // Catch:{ all -> 0x0043 }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r3)
            return
        L_0x0007:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0043 }
            r0.<init>()     // Catch:{ all -> 0x0043 }
            java.lang.String r1 = "CACHE_"
            r0.append(r1)     // Catch:{ all -> 0x0043 }
            java.lang.Class<T> r1 = r3.ceG     // Catch:{ all -> 0x0043 }
            java.lang.String r1 = r1.getSimpleName()     // Catch:{ all -> 0x0043 }
            r0.append(r1)     // Catch:{ all -> 0x0043 }
            java.lang.String r1 = "_"
            r0.append(r1)     // Catch:{ all -> 0x0043 }
            java.lang.String r1 = r3.cacheKey     // Catch:{ all -> 0x0043 }
            java.lang.String r1 = com.introvd.template.common.MD5.md5(r1)     // Catch:{ all -> 0x0043 }
            r0.append(r1)     // Catch:{ all -> 0x0043 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0043 }
            boolean r1 = r3.ceI     // Catch:{ all -> 0x0043 }
            if (r1 != 0) goto L_0x003a
            android.content.Context r1 = r3.context     // Catch:{ all -> 0x0043 }
            java.lang.String r2 = r3.ceH     // Catch:{ all -> 0x0043 }
            boolean r1 = r3.m14344l(r1, r2, r0)     // Catch:{ all -> 0x0043 }
            if (r1 != 0) goto L_0x0041
        L_0x003a:
            android.content.Context r1 = r3.context     // Catch:{ all -> 0x0043 }
            java.lang.String r2 = r3.ceH     // Catch:{ all -> 0x0043 }
            r3.m14343k(r1, r2, r0)     // Catch:{ all -> 0x0043 }
        L_0x0041:
            monitor-exit(r3)
            return
        L_0x0043:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.common.filecache.FileCache.m14338Zg():void");
    }

    /* access modifiers changed from: private */
    /* renamed from: Zh */
    public boolean m14339Zh() {
        LogUtilsV2.m14227d("deleteCacheSync");
        this.mData = null;
        if (this.aBX == null || !this.aBX.exists()) {
            return false;
        }
        return this.aBX.delete();
    }

    /* access modifiers changed from: private */
    /* renamed from: Zi */
    public void m14340Zi() {
        this.encrypt = false;
    }

    /* renamed from: k */
    private void m14343k(Context context2, String str, String str2) {
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
    private boolean m14344l(Context context2, String str, String str2) {
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

    public void clearCache() {
        C1834l.m5254a((C1839n<T>) new C1839n<Integer>() {
            /* renamed from: a */
            public void mo10177a(C1838m<Integer> mVar) throws Exception {
                mVar.mo9791K(Integer.valueOf(1));
            }
        }).mo10157d(C1820a.aVi()).mo10152c(C1820a.aVi()).mo10167f((C1518f<? super T, ? extends R>) new C1518f<Integer, Boolean>() {
            /* renamed from: g */
            public Boolean apply(Integer num) throws Exception {
                return Boolean.valueOf(FileCache.this.m14339Zh());
            }
        }).aTR();
    }

    public C1834l<T> getCache() {
        LogUtilsV2.m14227d("getCache");
        return C1834l.m5257ah(Boolean.valueOf(true)).mo10157d(C1820a.aVi()).mo10152c(C1820a.aVi()).mo10167f((C1518f<? super T, ? extends R>) new C1518f<Boolean, T>() {
            /* renamed from: q */
            public T apply(Boolean bool) throws Exception {
                T cacheSync = FileCache.this.getCacheSync();
                if (cacheSync != null) {
                    return cacheSync;
                }
                throw C1505b.m4703z(new Throwable("No Cache"));
            }
        });
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:18|19|20|21|22|23) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x0059 */
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
            r4.m14338Zg()
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
            java.lang.Class<com.introvd.template.common.filecache.FileCache> r0 = com.introvd.template.common.filecache.FileCache.class
            monitor-enter(r0)
            boolean r2 = r4.encrypt     // Catch:{ all -> 0x005d }
            if (r2 == 0) goto L_0x003c
            java.io.File r2 = r4.aBX     // Catch:{ all -> 0x005d }
            java.lang.String r3 = "UTF-8"
            java.lang.String r2 = com.introvd.template.common.filecache.C5276a.m14371c(r2, r3)     // Catch:{ all -> 0x005d }
            goto L_0x0044
        L_0x003c:
            java.io.File r2 = r4.aBX     // Catch:{ all -> 0x005d }
            java.lang.String r3 = "UTF-8"
            java.lang.String r2 = com.introvd.template.common.filecache.C5277b.m14373c(r2, r3)     // Catch:{ all -> 0x005d }
        L_0x0044:
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x005d }
            if (r3 == 0) goto L_0x004c
            monitor-exit(r0)     // Catch:{ all -> 0x005d }
            return r1
        L_0x004c:
            com.google.gson.Gson r1 = new com.google.gson.Gson     // Catch:{ Exception -> 0x0059 }
            r1.<init>()     // Catch:{ Exception -> 0x0059 }
            java.lang.Class<T> r3 = r4.ceG     // Catch:{ Exception -> 0x0059 }
            java.lang.Object r1 = r1.fromJson(r2, r3)     // Catch:{ Exception -> 0x0059 }
            r4.mData = r1     // Catch:{ Exception -> 0x0059 }
        L_0x0059:
            T r1 = r4.mData     // Catch:{ all -> 0x005d }
            monitor-exit(r0)     // Catch:{ all -> 0x005d }
            return r1
        L_0x005d:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x005d }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.common.filecache.FileCache.getCacheSync():java.lang.Object");
    }

    public void saveCache(T t) {
        if (t != null) {
            C1834l.m5257ah(t).mo10157d(C1820a.aVi()).mo10152c(C1820a.aVi()).mo10161e((C1517e<? super T>) new C1517e<T>() {
                public void accept(T t) throws Exception {
                }
            }).mo10167f((C1518f<? super T, ? extends R>) new C1518f<T, Boolean>() {
                /* renamed from: P */
                public Boolean apply(T t) throws Exception {
                    return FileCache.this.saveCacheSync(t);
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
        m14338Zg();
        if (this.aBX == null || t == null) {
            return Boolean.valueOf(false);
        }
        String path = this.aBX.getPath();
        try {
            this.mData = t;
            synchronized (FileCache.class) {
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
