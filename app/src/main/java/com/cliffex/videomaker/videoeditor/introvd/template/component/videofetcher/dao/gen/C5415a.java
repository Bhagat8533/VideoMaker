package com.introvd.template.component.videofetcher.dao.gen;

import android.content.Context;
import android.util.Log;
import org.greenrobot.p490a.C9971b;
import org.greenrobot.p490a.p492b.C9972a;
import org.greenrobot.p490a.p492b.C9973b;
import org.greenrobot.p490a.p493c.C9984d;

/* renamed from: com.introvd.template.component.videofetcher.dao.gen.a */
public class C5415a extends C9971b {

    /* renamed from: com.introvd.template.component.videofetcher.dao.gen.a$a */
    public static abstract class C5416a extends C9973b {
        public C5416a(Context context, String str) {
            super(context, str, 2);
        }

        public void onCreate(C9972a aVar) {
            Log.i("greenDAO", "Creating tables for schema version 2");
            C5415a.createAllTables(aVar, false);
        }
    }

    public C5415a(C9972a aVar) {
        super(aVar, 2);
        registerDaoClass(DownloadInfoBeanDao.class);
    }

    public static void createAllTables(C9972a aVar, boolean z) {
        DownloadInfoBeanDao.createTable(aVar, z);
    }

    public static void dropAllTables(C9972a aVar, boolean z) {
        DownloadInfoBeanDao.dropTable(aVar, z);
    }

    /* renamed from: aab */
    public C5417b newSession() {
        return new C5417b(this.f3705db, C9984d.Session, this.daoConfigMap);
    }

    /* renamed from: b */
    public C5417b newSession(C9984d dVar) {
        return new C5417b(this.f3705db, dVar, this.daoConfigMap);
    }
}
