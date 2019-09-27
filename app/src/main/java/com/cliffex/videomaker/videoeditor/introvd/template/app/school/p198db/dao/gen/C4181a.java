package com.introvd.template.app.school.p198db.dao.gen;

import android.content.Context;
import android.util.Log;
import org.greenrobot.p490a.C9971b;
import org.greenrobot.p490a.p492b.C9972a;
import org.greenrobot.p490a.p492b.C9973b;
import org.greenrobot.p490a.p493c.C9984d;

/* renamed from: com.introvd.template.app.school.db.dao.gen.a */
public class C4181a extends C9971b {

    /* renamed from: com.introvd.template.app.school.db.dao.gen.a$a */
    public static abstract class C4182a extends C9973b {
        public C4182a(Context context, String str) {
            super(context, str, 4);
        }

        public void onCreate(C9972a aVar) {
            Log.i("greenDAO", "Creating tables for schema version 4");
            C4181a.createAllTables(aVar, false);
        }
    }

    public C4181a(C9972a aVar) {
        super(aVar, 4);
        registerDaoClass(DBClassInfoDao.class);
        registerDaoClass(TemplateItemInfoDao.class);
    }

    public static void createAllTables(C9972a aVar, boolean z) {
        DBClassInfoDao.createTable(aVar, z);
        TemplateItemInfoDao.createTable(aVar, z);
    }

    public static void dropAllTables(C9972a aVar, boolean z) {
        DBClassInfoDao.dropTable(aVar, z);
        TemplateItemInfoDao.dropTable(aVar, z);
    }

    /* renamed from: Ob */
    public C4183b newSession() {
        return new C4183b(this.f3705db, C9984d.Session, this.daoConfigMap);
    }

    /* renamed from: a */
    public C4183b newSession(C9984d dVar) {
        return new C4183b(this.f3705db, dVar, this.daoConfigMap);
    }
}
