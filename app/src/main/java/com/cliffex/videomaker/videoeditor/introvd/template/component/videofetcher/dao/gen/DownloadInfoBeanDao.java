package com.introvd.template.component.videofetcher.dao.gen;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import com.introvd.template.component.videofetcher.p239c.C5391a;
import org.greenrobot.p490a.C10016g;
import org.greenrobot.p490a.C9964a;
import org.greenrobot.p490a.p492b.C9972a;
import org.greenrobot.p490a.p492b.C9975c;
import org.greenrobot.p490a.p494d.C9986a;

public class DownloadInfoBeanDao extends C9964a<C5391a, String> {
    public static final String TABLENAME = "video_fetcher_download_info";

    public static class Properties {
        public static final C10016g Duration;
        public static final C10016g ckq;
        public static final C10016g ckr;
        public static final C10016g cks;
        public static final C10016g ckt;
        public static final C10016g cku;
        public static final C10016g ckv;
        public static final C10016g ckw;

        static {
            C10016g gVar = new C10016g(0, String.class, "address", false, "address");
            ckq = gVar;
            C10016g gVar2 = new C10016g(1, String.class, "size", false, "size");
            ckr = gVar2;
            C10016g gVar3 = new C10016g(2, String.class, "name", true, "name");
            cks = gVar3;
            C10016g gVar4 = new C10016g(3, String.class, "filePath", false, "filepath");
            ckt = gVar4;
            C10016g gVar5 = new C10016g(4, String.class, "duration", false, "duration");
            Duration = gVar5;
            C10016g gVar6 = new C10016g(5, String.class, "thumbnailPath", false, "thumbnailPath");
            cku = gVar6;
            C10016g gVar7 = new C10016g(6, Integer.TYPE, "thumbnailWidth", false, "thumbnailWidth");
            ckv = gVar7;
            C10016g gVar8 = new C10016g(7, Integer.TYPE, "thumbnailHeight", false, "thumbnailHeight");
            ckw = gVar8;
        }
    }

    public DownloadInfoBeanDao(C9986a aVar, C5417b bVar) {
        super(aVar, bVar);
    }

    public static void createTable(C9972a aVar, boolean z) {
        String str = z ? "IF NOT EXISTS " : "";
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE ");
        sb.append(str);
        sb.append("\"video_fetcher_download_info\" (\"address\" TEXT,\"size\" TEXT,\"name\" TEXT PRIMARY KEY NOT NULL ,\"filepath\" TEXT,\"duration\" TEXT,\"thumbnailPath\" TEXT,\"thumbnailWidth\" INTEGER NOT NULL ,\"thumbnailHeight\" INTEGER NOT NULL );");
        aVar.execSQL(sb.toString());
    }

    public static void dropTable(C9972a aVar, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("DROP TABLE ");
        sb.append(z ? "IF EXISTS " : "");
        sb.append("\"video_fetcher_download_info\"");
        aVar.execSQL(sb.toString());
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final String updateKeyAfterInsert(C5391a aVar, long j) {
        return aVar.getName();
    }

    /* renamed from: a */
    public void readEntity(Cursor cursor, C5391a aVar, int i) {
        int i2 = i + 0;
        String str = null;
        aVar.setAddress(cursor.isNull(i2) ? null : cursor.getString(i2));
        int i3 = i + 1;
        aVar.mo26984fz(cursor.isNull(i3) ? null : cursor.getString(i3));
        int i4 = i + 2;
        aVar.setName(cursor.isNull(i4) ? null : cursor.getString(i4));
        int i5 = i + 3;
        aVar.setFilePath(cursor.isNull(i5) ? null : cursor.getString(i5));
        int i6 = i + 4;
        aVar.mo26982fA(cursor.isNull(i6) ? null : cursor.getString(i6));
        int i7 = i + 5;
        if (!cursor.isNull(i7)) {
            str = cursor.getString(i7);
        }
        aVar.mo26983fB(str);
        aVar.mo26989jX(cursor.getInt(i + 6));
        aVar.mo26990jY(cursor.getInt(i + 7));
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void bindValues(SQLiteStatement sQLiteStatement, C5391a aVar) {
        sQLiteStatement.clearBindings();
        String address = aVar.getAddress();
        if (address != null) {
            sQLiteStatement.bindString(1, address);
        }
        String ZN = aVar.mo26976ZN();
        if (ZN != null) {
            sQLiteStatement.bindString(2, ZN);
        }
        String name = aVar.getName();
        if (name != null) {
            sQLiteStatement.bindString(3, name);
        }
        String filePath = aVar.getFilePath();
        if (filePath != null) {
            sQLiteStatement.bindString(4, filePath);
        }
        String ZO = aVar.mo26977ZO();
        if (ZO != null) {
            sQLiteStatement.bindString(5, ZO);
        }
        String ZP = aVar.mo26978ZP();
        if (ZP != null) {
            sQLiteStatement.bindString(6, ZP);
        }
        sQLiteStatement.bindLong(7, (long) aVar.mo26979ZQ());
        sQLiteStatement.bindLong(8, (long) aVar.mo26980ZR());
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void bindValues(C9975c cVar, C5391a aVar) {
        cVar.clearBindings();
        String address = aVar.getAddress();
        if (address != null) {
            cVar.bindString(1, address);
        }
        String ZN = aVar.mo26976ZN();
        if (ZN != null) {
            cVar.bindString(2, ZN);
        }
        String name = aVar.getName();
        if (name != null) {
            cVar.bindString(3, name);
        }
        String filePath = aVar.getFilePath();
        if (filePath != null) {
            cVar.bindString(4, filePath);
        }
        String ZO = aVar.mo26977ZO();
        if (ZO != null) {
            cVar.bindString(5, ZO);
        }
        String ZP = aVar.mo26978ZP();
        if (ZP != null) {
            cVar.bindString(6, ZP);
        }
        cVar.bindLong(7, (long) aVar.mo26979ZQ());
        cVar.bindLong(8, (long) aVar.mo26980ZR());
    }

    /* renamed from: d */
    public String readKey(Cursor cursor, int i) {
        int i2 = i + 2;
        if (cursor.isNull(i2)) {
            return null;
        }
        return cursor.getString(i2);
    }

    /* renamed from: d */
    public String getKey(C5391a aVar) {
        if (aVar != null) {
            return aVar.getName();
        }
        return null;
    }

    /* renamed from: e */
    public C5391a readEntity(Cursor cursor, int i) {
        int i2 = i + 0;
        String string = cursor.isNull(i2) ? null : cursor.getString(i2);
        int i3 = i + 1;
        String string2 = cursor.isNull(i3) ? null : cursor.getString(i3);
        int i4 = i + 2;
        String string3 = cursor.isNull(i4) ? null : cursor.getString(i4);
        int i5 = i + 3;
        String string4 = cursor.isNull(i5) ? null : cursor.getString(i5);
        int i6 = i + 4;
        String string5 = cursor.isNull(i6) ? null : cursor.getString(i6);
        int i7 = i + 5;
        C5391a aVar = new C5391a(string, string2, string3, string4, string5, cursor.isNull(i7) ? null : cursor.getString(i7), cursor.getInt(i + 6), cursor.getInt(i + 7));
        return aVar;
    }

    /* renamed from: e */
    public boolean hasKey(C5391a aVar) {
        return aVar.getName() != null;
    }

    /* access modifiers changed from: protected */
    public final boolean isEntityUpdateable() {
        return true;
    }
}
