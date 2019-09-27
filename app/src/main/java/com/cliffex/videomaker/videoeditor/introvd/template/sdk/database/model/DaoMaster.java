package com.introvd.template.sdk.database.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.util.Log;
import org.greenrobot.p490a.C9971b;
import org.greenrobot.p490a.p492b.C9972a;
import org.greenrobot.p490a.p492b.C9973b;
import org.greenrobot.p490a.p492b.C9978f;
import org.greenrobot.p490a.p493c.C9984d;

public class DaoMaster extends C9971b {
    public static final int SCHEMA_VERSION = 1;

    public static class DevOpenHelper extends OpenHelper {
        public DevOpenHelper(Context context, String str) {
            super(context, str);
        }

        public DevOpenHelper(Context context, String str, CursorFactory cursorFactory) {
            super(context, str, cursorFactory);
        }

        public void onUpgrade(C9972a aVar, int i, int i2) {
            StringBuilder sb = new StringBuilder();
            sb.append("Upgrading schema from version ");
            sb.append(i);
            sb.append(" to ");
            sb.append(i2);
            sb.append(" by dropping all tables");
            Log.i("greenDAO", sb.toString());
            DaoMaster.dropAllTables(aVar, true);
            onCreate(aVar);
        }
    }

    public static abstract class OpenHelper extends C9973b {
        public OpenHelper(Context context, String str) {
            super(context, str, 1);
        }

        public OpenHelper(Context context, String str, CursorFactory cursorFactory) {
            super(context, str, cursorFactory, 1);
        }

        public void onCreate(C9972a aVar) {
            Log.i("greenDAO", "Creating tables for schema version 1");
            DaoMaster.createAllTables(aVar, false);
        }
    }

    public DaoMaster(SQLiteDatabase sQLiteDatabase) {
        this((C9972a) new C9978f(sQLiteDatabase));
    }

    public DaoMaster(C9972a aVar) {
        super(aVar, 1);
        registerDaoClass(DBClipDao.class);
        registerDaoClass(DBClipRefDao.class);
        registerDaoClass(DBProjectDao.class);
    }

    public static void createAllTables(C9972a aVar, boolean z) {
        DBClipDao.createTable(aVar, z);
        DBClipRefDao.createTable(aVar, z);
        DBProjectDao.createTable(aVar, z);
    }

    public static void dropAllTables(C9972a aVar, boolean z) {
        DBClipDao.dropTable(aVar, z);
        DBClipRefDao.dropTable(aVar, z);
        DBProjectDao.dropTable(aVar, z);
    }

    public static DaoSession newDevSession(Context context, String str) {
        return new DaoMaster(new DevOpenHelper(context, str).getWritableDb()).newSession();
    }

    public DaoSession newSession() {
        return new DaoSession(this.f3705db, C9984d.Session, this.daoConfigMap);
    }

    public DaoSession newSession(C9984d dVar) {
        return new DaoSession(this.f3705db, dVar, this.daoConfigMap);
    }
}
