package com.introvd.template.sdk.database.model;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import com.introvd.template.datacenter.SocialServiceDef;
import org.greenrobot.p490a.C10016g;
import org.greenrobot.p490a.C9964a;
import org.greenrobot.p490a.p492b.C9972a;
import org.greenrobot.p490a.p492b.C9975c;
import org.greenrobot.p490a.p494d.C9986a;

public class DBClipRefDao extends C9964a<DBClipRef, Long> {
    public static final String TABLENAME = "ClipRef";

    public static class Properties {
        public static final C10016g Clip_id;
        public static final C10016g Prj_id;
        public static final C10016g _id;

        static {
            C10016g gVar = new C10016g(0, Long.class, "_id", true, "_id");
            _id = gVar;
            C10016g gVar2 = new C10016g(1, Long.TYPE, SocialServiceDef.EXTRAS_PROJECT_ID, false, SocialServiceDef.EXTRAS_PROJECT_ID);
            Prj_id = gVar2;
            C10016g gVar3 = new C10016g(2, Long.TYPE, "clip_id", false, "clip_id");
            Clip_id = gVar3;
        }
    }

    public DBClipRefDao(C9986a aVar) {
        super(aVar);
    }

    public DBClipRefDao(C9986a aVar, DaoSession daoSession) {
        super(aVar, daoSession);
    }

    public static void createTable(C9972a aVar, boolean z) {
        String str = z ? "IF NOT EXISTS " : "";
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE ");
        sb.append(str);
        sb.append("\"ClipRef\" (\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ,\"prj_id\" INTEGER NOT NULL ,\"clip_id\" INTEGER NOT NULL );");
        aVar.execSQL(sb.toString());
    }

    public static void dropTable(C9972a aVar, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("DROP TABLE ");
        sb.append(z ? "IF EXISTS " : "");
        sb.append("\"ClipRef\"");
        aVar.execSQL(sb.toString());
    }

    /* access modifiers changed from: protected */
    public final void bindValues(SQLiteStatement sQLiteStatement, DBClipRef dBClipRef) {
        sQLiteStatement.clearBindings();
        Long l = dBClipRef.get_id();
        if (l != null) {
            sQLiteStatement.bindLong(1, l.longValue());
        }
        sQLiteStatement.bindLong(2, dBClipRef.getPrj_id());
        sQLiteStatement.bindLong(3, dBClipRef.getClip_id());
    }

    /* access modifiers changed from: protected */
    public final void bindValues(C9975c cVar, DBClipRef dBClipRef) {
        cVar.clearBindings();
        Long l = dBClipRef.get_id();
        if (l != null) {
            cVar.bindLong(1, l.longValue());
        }
        cVar.bindLong(2, dBClipRef.getPrj_id());
        cVar.bindLong(3, dBClipRef.getClip_id());
    }

    public Long getKey(DBClipRef dBClipRef) {
        if (dBClipRef != null) {
            return dBClipRef.get_id();
        }
        return null;
    }

    public boolean hasKey(DBClipRef dBClipRef) {
        return dBClipRef.get_id() != null;
    }

    /* access modifiers changed from: protected */
    public final boolean isEntityUpdateable() {
        return true;
    }

    public DBClipRef readEntity(Cursor cursor, int i) {
        int i2 = i + 0;
        DBClipRef dBClipRef = new DBClipRef(cursor.isNull(i2) ? null : Long.valueOf(cursor.getLong(i2)), cursor.getLong(i + 1), cursor.getLong(i + 2));
        return dBClipRef;
    }

    public void readEntity(Cursor cursor, DBClipRef dBClipRef, int i) {
        int i2 = i + 0;
        dBClipRef.set_id(cursor.isNull(i2) ? null : Long.valueOf(cursor.getLong(i2)));
        dBClipRef.setPrj_id(cursor.getLong(i + 1));
        dBClipRef.setClip_id(cursor.getLong(i + 2));
    }

    public Long readKey(Cursor cursor, int i) {
        int i2 = i + 0;
        if (cursor.isNull(i2)) {
            return null;
        }
        return Long.valueOf(cursor.getLong(i2));
    }

    /* access modifiers changed from: protected */
    public final Long updateKeyAfterInsert(DBClipRef dBClipRef, long j) {
        dBClipRef.set_id(Long.valueOf(j));
        return Long.valueOf(j);
    }
}
