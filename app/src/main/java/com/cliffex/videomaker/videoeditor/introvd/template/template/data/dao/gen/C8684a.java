package com.introvd.template.template.data.dao.gen;

import android.content.Context;
import android.util.Log;
import org.greenrobot.p490a.C9971b;
import org.greenrobot.p490a.p492b.C9972a;
import org.greenrobot.p490a.p492b.C9973b;
import org.greenrobot.p490a.p493c.C9984d;

/* renamed from: com.introvd.template.template.data.dao.gen.a */
public class C8684a extends C9971b {

    /* renamed from: com.introvd.template.template.data.dao.gen.a$a */
    public static abstract class C8685a extends C9973b {
        public C8685a(Context context, String str) {
            super(context, str, 2);
        }

        public void onCreate(C9972a aVar) {
            Log.i("greenDAO", "Creating tables for schema version 2");
            C8684a.createAllTables(aVar, false);
        }
    }

    public C8684a(C9972a aVar) {
        super(aVar, 2);
        registerDaoClass(DBTemplateAudioInfoDao.class);
    }

    public static void createAllTables(C9972a aVar, boolean z) {
        DBTemplateAudioInfoDao.createTable(aVar, z);
    }

    public static void dropAllTables(C9972a aVar, boolean z) {
        DBTemplateAudioInfoDao.dropTable(aVar, z);
    }

    /* renamed from: aKq */
    public C8686b newSession() {
        return new C8686b(this.f3705db, C9984d.Session, this.daoConfigMap);
    }

    /* renamed from: c */
    public C8686b newSession(C9984d dVar) {
        return new C8686b(this.f3705db, dVar, this.daoConfigMap);
    }
}
