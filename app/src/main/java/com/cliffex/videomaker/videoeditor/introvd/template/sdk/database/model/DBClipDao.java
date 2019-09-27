package com.introvd.template.sdk.database.model;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import org.greenrobot.p490a.C10016g;
import org.greenrobot.p490a.C9964a;
import org.greenrobot.p490a.p492b.C9972a;
import org.greenrobot.p490a.p492b.C9975c;
import org.greenrobot.p490a.p494d.C9986a;

public class DBClipDao extends C9964a<DBClip, Long> {
    public static final String TABLENAME = "Clip";

    public static class Properties {
        public static final C10016g Url;
        public static final C10016g _id;

        static {
            C10016g gVar = new C10016g(0, Long.class, "_id", true, "_id");
            _id = gVar;
            C10016g gVar2 = new C10016g(1, String.class, "url", false, "url");
            Url = gVar2;
        }
    }

    public DBClipDao(C9986a aVar) {
        super(aVar);
    }

    public DBClipDao(C9986a aVar, DaoSession daoSession) {
        super(aVar, daoSession);
    }

    public static void createTable(C9972a aVar, boolean z) {
        String str = z ? "IF NOT EXISTS " : "";
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE ");
        sb.append(str);
        sb.append("\"Clip\" (\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ,\"url\" TEXT);");
        aVar.execSQL(sb.toString());
    }

    public static void dropTable(C9972a aVar, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("DROP TABLE ");
        sb.append(z ? "IF EXISTS " : "");
        sb.append("\"Clip\"");
        aVar.execSQL(sb.toString());
    }

    /* access modifiers changed from: protected */
    public final void bindValues(SQLiteStatement sQLiteStatement, DBClip dBClip) {
        sQLiteStatement.clearBindings();
        Long l = dBClip.get_id();
        if (l != null) {
            sQLiteStatement.bindLong(1, l.longValue());
        }
        String url = dBClip.getUrl();
        if (url != null) {
            sQLiteStatement.bindString(2, url);
        }
    }

    /* access modifiers changed from: protected */
    public final void bindValues(C9975c cVar, DBClip dBClip) {
        cVar.clearBindings();
        Long l = dBClip.get_id();
        if (l != null) {
            cVar.bindLong(1, l.longValue());
        }
        String url = dBClip.getUrl();
        if (url != null) {
            cVar.bindString(2, url);
        }
    }

    public Long getKey(DBClip dBClip) {
        if (dBClip != null) {
            return dBClip.get_id();
        }
        return null;
    }

    public boolean hasKey(DBClip dBClip) {
        return dBClip.get_id() != null;
    }

    /* access modifiers changed from: protected */
    public final boolean isEntityUpdateable() {
        return true;
    }

    public DBClip readEntity(Cursor cursor, int i) {
        int i2 = i + 0;
        String str = null;
        Long valueOf = cursor.isNull(i2) ? null : Long.valueOf(cursor.getLong(i2));
        int i3 = i + 1;
        if (!cursor.isNull(i3)) {
            str = cursor.getString(i3);
        }
        return new DBClip(valueOf, str);
    }

    public void readEntity(Cursor cursor, DBClip dBClip, int i) {
        int i2 = i + 0;
        String str = null;
        dBClip.set_id(cursor.isNull(i2) ? null : Long.valueOf(cursor.getLong(i2)));
        int i3 = i + 1;
        if (!cursor.isNull(i3)) {
            str = cursor.getString(i3);
        }
        dBClip.setUrl(str);
    }

    public Long readKey(Cursor cursor, int i) {
        int i2 = i + 0;
        if (cursor.isNull(i2)) {
            return null;
        }
        return Long.valueOf(cursor.getLong(i2));
    }

    /* access modifiers changed from: protected */
    public final Long updateKeyAfterInsert(DBClip dBClip, long j) {
        dBClip.set_id(Long.valueOf(j));
        return Long.valueOf(j);
    }
}
