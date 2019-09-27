package com.introvd.template.sdk.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.introvd.template.sdk.database.model.DaoMaster;
import com.introvd.template.sdk.database.model.DaoMaster.OpenHelper;
import com.introvd.template.sdk.database.model.DaoSession;
import com.introvd.template.sdk.database.p385a.C8407a;
import com.introvd.template.sdk.database.p385a.C8408b;
import com.introvd.template.sdk.database.p385a.C8409c;
import com.introvd.template.sdk.utils.C8554j;
import org.greenrobot.p490a.p492b.C9972a;

/* renamed from: com.introvd.template.sdk.database.a */
public class C8405a {
    private static volatile C8405a edk;
    private Context applicationContext;
    private boolean bxM;
    private DaoSession edl;
    private C8406a edm;
    private C8409c edn;
    private C8407a edo;
    private C8408b edp;

    /* renamed from: com.introvd.template.sdk.database.a$a */
    class C8406a extends OpenHelper {
        public C8406a(Context context, String str) {
            super(context, str);
        }

        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            C8554j.m25006d("ProjectDaoImpl", "onDowngrade Database SQLiteDatabase");
            DaoMaster.dropAllTables(wrap(sQLiteDatabase), true);
            onCreate(sQLiteDatabase);
        }

        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            super.onUpgrade(sQLiteDatabase, i, i2);
            C8554j.m25006d("ProjectDaoImpl", "onUpgrade SQLiteDatabase SQLiteDatabase");
        }

        public void onUpgrade(C9972a aVar, int i, int i2) {
            super.onUpgrade(aVar, i, i2);
            C8554j.m25006d("ProjectDaoImpl", "onUpgrade Database SQLiteDatabase");
        }
    }

    /* renamed from: a */
    private void m24246a(DaoSession daoSession) {
        this.edn = new C8409c(daoSession);
        this.edo = new C8407a(daoSession);
        this.edp = new C8408b(daoSession);
    }

    public static synchronized C8405a aHD() {
        C8405a aVar;
        synchronized (C8405a.class) {
            if (edk == null) {
                synchronized (C8405a.class) {
                    if (edk == null) {
                        edk = new C8405a();
                    }
                }
            }
            aVar = edk;
        }
        return aVar;
    }

    public C8409c aHE() {
        return this.edn;
    }

    public C8407a aHF() {
        return this.edo;
    }

    public C8408b aHG() {
        return this.edp;
    }

    /* renamed from: cG */
    public void mo33982cG(Context context) {
        if (!this.bxM) {
            synchronized (this) {
                this.bxM = true;
                this.applicationContext = context;
                this.edm = new C8406a(context, "ve_sdk.db");
                this.edl = new DaoMaster(this.edm.getWritableDb()).newSession();
                m24246a(this.edl);
            }
        }
    }
}
