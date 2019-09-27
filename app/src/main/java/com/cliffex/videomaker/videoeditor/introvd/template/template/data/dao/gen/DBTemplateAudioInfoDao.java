package com.introvd.template.template.data.dao.gen;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import com.google.firebase.analytics.FirebaseAnalytics.Param;
import com.introvd.template.template.data.p406db.model.DBTemplateAudioInfo;
import org.greenrobot.p490a.C10016g;
import org.greenrobot.p490a.C9964a;
import org.greenrobot.p490a.p492b.C9972a;
import org.greenrobot.p490a.p492b.C9975c;
import org.greenrobot.p490a.p494d.C9986a;

public class DBTemplateAudioInfoDao extends C9964a<DBTemplateAudioInfo, String> {
    public static final String TABLENAME = "template_audio";

    public static class Properties {
        public static final C10016g Duration;
        public static final C10016g byd;
        public static final C10016g cks;
        public static final C10016g ekO;
        public static final C10016g ekP;
        public static final C10016g ekQ;
        public static final C10016g ekR;
        public static final C10016g ekS;
        public static final C10016g ekT;
        public static final C10016g ekU;
        public static final C10016g ekV;
        public static final C10016g ekW;
        public static final C10016g ekX;
        public static final C10016g ekY;
        public static final C10016g ekZ;

        static {
            C10016g gVar = new C10016g(0, String.class, Param.INDEX, true, "id");
            ekO = gVar;
            C10016g gVar2 = new C10016g(1, String.class, "coverUrl", false, "cover_url");
            byd = gVar2;
            C10016g gVar3 = new C10016g(2, String.class, "audioUrl", false, "audio_url");
            ekP = gVar3;
            C10016g gVar4 = new C10016g(3, String.class, "name", false, "name");
            cks = gVar4;
            C10016g gVar5 = new C10016g(4, Integer.TYPE, "duration", false, "duration");
            Duration = gVar5;
            C10016g gVar6 = new C10016g(5, String.class, "author", false, "author");
            ekQ = gVar6;
            C10016g gVar7 = new C10016g(6, String.class, "album", false, "album");
            ekR = gVar7;
            C10016g gVar8 = new C10016g(7, String.class, "newFlag", false, "new_flag");
            ekS = gVar8;
            C10016g gVar9 = new C10016g(8, Long.TYPE, "order", false, "order");
            ekT = gVar9;
            C10016g gVar10 = new C10016g(9, Long.TYPE, "createTime", false, "createTime");
            ekU = gVar10;
            C10016g gVar11 = new C10016g(10, String.class, "categoryId", false, "categoryId");
            ekV = gVar11;
            C10016g gVar12 = new C10016g(11, String.class, "categoryName", false, "categoryName");
            ekW = gVar12;
            C10016g gVar13 = new C10016g(12, Integer.TYPE, "categoryOrder", false, "categoryOrder");
            ekX = gVar13;
            C10016g gVar14 = new C10016g(13, String.class, "musicFilePath", false, "musicFilePath");
            ekY = gVar14;
            C10016g gVar15 = new C10016g(14, Integer.TYPE, "musicType", false, "type");
            ekZ = gVar15;
        }
    }

    public DBTemplateAudioInfoDao(C9986a aVar, C8686b bVar) {
        super(aVar, bVar);
    }

    public static void createTable(C9972a aVar, boolean z) {
        String str = z ? "IF NOT EXISTS " : "";
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE ");
        sb.append(str);
        sb.append("\"template_audio\" (\"id\" TEXT PRIMARY KEY NOT NULL ,\"cover_url\" TEXT,\"audio_url\" TEXT,\"name\" TEXT,\"duration\" INTEGER NOT NULL ,\"author\" TEXT,\"album\" TEXT,\"new_flag\" TEXT,\"order\" INTEGER NOT NULL ,\"createTime\" INTEGER NOT NULL ,\"categoryId\" TEXT,\"categoryName\" TEXT,\"categoryOrder\" INTEGER NOT NULL ,\"musicFilePath\" TEXT,\"type\" INTEGER NOT NULL );");
        aVar.execSQL(sb.toString());
    }

    public static void dropTable(C9972a aVar, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("DROP TABLE ");
        sb.append(z ? "IF EXISTS " : "");
        sb.append("\"template_audio\"");
        aVar.execSQL(sb.toString());
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final String updateKeyAfterInsert(DBTemplateAudioInfo dBTemplateAudioInfo, long j) {
        return dBTemplateAudioInfo.getIndex();
    }

    /* renamed from: a */
    public void readEntity(Cursor cursor, DBTemplateAudioInfo dBTemplateAudioInfo, int i) {
        int i2 = i + 0;
        String str = null;
        dBTemplateAudioInfo.setIndex(cursor.isNull(i2) ? null : cursor.getString(i2));
        int i3 = i + 1;
        dBTemplateAudioInfo.setCoverUrl(cursor.isNull(i3) ? null : cursor.getString(i3));
        int i4 = i + 2;
        dBTemplateAudioInfo.setAudioUrl(cursor.isNull(i4) ? null : cursor.getString(i4));
        int i5 = i + 3;
        dBTemplateAudioInfo.setName(cursor.isNull(i5) ? null : cursor.getString(i5));
        dBTemplateAudioInfo.setDuration(cursor.getInt(i + 4));
        int i6 = i + 5;
        dBTemplateAudioInfo.setAuthor(cursor.isNull(i6) ? null : cursor.getString(i6));
        int i7 = i + 6;
        dBTemplateAudioInfo.setAlbum(cursor.isNull(i7) ? null : cursor.getString(i7));
        int i8 = i + 7;
        dBTemplateAudioInfo.setNewFlag(cursor.isNull(i8) ? null : cursor.getString(i8));
        dBTemplateAudioInfo.setOrder(cursor.getLong(i + 8));
        dBTemplateAudioInfo.setCreateTime(cursor.getLong(i + 9));
        int i9 = i + 10;
        dBTemplateAudioInfo.setCategoryId(cursor.isNull(i9) ? null : cursor.getString(i9));
        int i10 = i + 11;
        dBTemplateAudioInfo.setCategoryName(cursor.isNull(i10) ? null : cursor.getString(i10));
        dBTemplateAudioInfo.setCategoryOrder(cursor.getInt(i + 12));
        int i11 = i + 13;
        if (!cursor.isNull(i11)) {
            str = cursor.getString(i11);
        }
        dBTemplateAudioInfo.setMusicFilePath(str);
        dBTemplateAudioInfo.setMusicType(cursor.getInt(i + 14));
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void bindValues(SQLiteStatement sQLiteStatement, DBTemplateAudioInfo dBTemplateAudioInfo) {
        sQLiteStatement.clearBindings();
        String index = dBTemplateAudioInfo.getIndex();
        if (index != null) {
            sQLiteStatement.bindString(1, index);
        }
        String coverUrl = dBTemplateAudioInfo.getCoverUrl();
        if (coverUrl != null) {
            sQLiteStatement.bindString(2, coverUrl);
        }
        String audioUrl = dBTemplateAudioInfo.getAudioUrl();
        if (audioUrl != null) {
            sQLiteStatement.bindString(3, audioUrl);
        }
        String name = dBTemplateAudioInfo.getName();
        if (name != null) {
            sQLiteStatement.bindString(4, name);
        }
        sQLiteStatement.bindLong(5, (long) dBTemplateAudioInfo.getDuration());
        String author = dBTemplateAudioInfo.getAuthor();
        if (author != null) {
            sQLiteStatement.bindString(6, author);
        }
        String album = dBTemplateAudioInfo.getAlbum();
        if (album != null) {
            sQLiteStatement.bindString(7, album);
        }
        String newFlag = dBTemplateAudioInfo.getNewFlag();
        if (newFlag != null) {
            sQLiteStatement.bindString(8, newFlag);
        }
        sQLiteStatement.bindLong(9, dBTemplateAudioInfo.getOrder());
        sQLiteStatement.bindLong(10, dBTemplateAudioInfo.getCreateTime());
        String categoryId = dBTemplateAudioInfo.getCategoryId();
        if (categoryId != null) {
            sQLiteStatement.bindString(11, categoryId);
        }
        String categoryName = dBTemplateAudioInfo.getCategoryName();
        if (categoryName != null) {
            sQLiteStatement.bindString(12, categoryName);
        }
        sQLiteStatement.bindLong(13, (long) dBTemplateAudioInfo.getCategoryOrder());
        String musicFilePath = dBTemplateAudioInfo.getMusicFilePath();
        if (musicFilePath != null) {
            sQLiteStatement.bindString(14, musicFilePath);
        }
        sQLiteStatement.bindLong(15, (long) dBTemplateAudioInfo.getMusicType());
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void bindValues(C9975c cVar, DBTemplateAudioInfo dBTemplateAudioInfo) {
        cVar.clearBindings();
        String index = dBTemplateAudioInfo.getIndex();
        if (index != null) {
            cVar.bindString(1, index);
        }
        String coverUrl = dBTemplateAudioInfo.getCoverUrl();
        if (coverUrl != null) {
            cVar.bindString(2, coverUrl);
        }
        String audioUrl = dBTemplateAudioInfo.getAudioUrl();
        if (audioUrl != null) {
            cVar.bindString(3, audioUrl);
        }
        String name = dBTemplateAudioInfo.getName();
        if (name != null) {
            cVar.bindString(4, name);
        }
        cVar.bindLong(5, (long) dBTemplateAudioInfo.getDuration());
        String author = dBTemplateAudioInfo.getAuthor();
        if (author != null) {
            cVar.bindString(6, author);
        }
        String album = dBTemplateAudioInfo.getAlbum();
        if (album != null) {
            cVar.bindString(7, album);
        }
        String newFlag = dBTemplateAudioInfo.getNewFlag();
        if (newFlag != null) {
            cVar.bindString(8, newFlag);
        }
        cVar.bindLong(9, dBTemplateAudioInfo.getOrder());
        cVar.bindLong(10, dBTemplateAudioInfo.getCreateTime());
        String categoryId = dBTemplateAudioInfo.getCategoryId();
        if (categoryId != null) {
            cVar.bindString(11, categoryId);
        }
        String categoryName = dBTemplateAudioInfo.getCategoryName();
        if (categoryName != null) {
            cVar.bindString(12, categoryName);
        }
        cVar.bindLong(13, (long) dBTemplateAudioInfo.getCategoryOrder());
        String musicFilePath = dBTemplateAudioInfo.getMusicFilePath();
        if (musicFilePath != null) {
            cVar.bindString(14, musicFilePath);
        }
        cVar.bindLong(15, (long) dBTemplateAudioInfo.getMusicType());
    }

    /* renamed from: b */
    public String getKey(DBTemplateAudioInfo dBTemplateAudioInfo) {
        if (dBTemplateAudioInfo != null) {
            return dBTemplateAudioInfo.getIndex();
        }
        return null;
    }

    /* renamed from: c */
    public boolean hasKey(DBTemplateAudioInfo dBTemplateAudioInfo) {
        return dBTemplateAudioInfo.getIndex() != null;
    }

    /* renamed from: d */
    public String readKey(Cursor cursor, int i) {
        int i2 = i + 0;
        if (cursor.isNull(i2)) {
            return null;
        }
        return cursor.getString(i2);
    }

    /* renamed from: f */
    public DBTemplateAudioInfo readEntity(Cursor cursor, int i) {
        Cursor cursor2 = cursor;
        int i2 = i + 0;
        String string = cursor2.isNull(i2) ? null : cursor2.getString(i2);
        int i3 = i + 1;
        String string2 = cursor2.isNull(i3) ? null : cursor2.getString(i3);
        int i4 = i + 2;
        String string3 = cursor2.isNull(i4) ? null : cursor2.getString(i4);
        int i5 = i + 3;
        String string4 = cursor2.isNull(i5) ? null : cursor2.getString(i5);
        int i6 = cursor2.getInt(i + 4);
        int i7 = i + 5;
        String string5 = cursor2.isNull(i7) ? null : cursor2.getString(i7);
        int i8 = i + 6;
        String string6 = cursor2.isNull(i8) ? null : cursor2.getString(i8);
        int i9 = i + 7;
        String string7 = cursor2.isNull(i9) ? null : cursor2.getString(i9);
        long j = cursor2.getLong(i + 8);
        long j2 = cursor2.getLong(i + 9);
        int i10 = i + 10;
        String string8 = cursor2.isNull(i10) ? null : cursor2.getString(i10);
        int i11 = i + 11;
        String string9 = cursor2.isNull(i11) ? null : cursor2.getString(i11);
        int i12 = i + 13;
        DBTemplateAudioInfo dBTemplateAudioInfo = new DBTemplateAudioInfo(string, string2, string3, string4, i6, string5, string6, string7, j, j2, string8, string9, cursor2.getInt(i + 12), cursor2.isNull(i12) ? null : cursor2.getString(i12), cursor2.getInt(i + 14));
        return dBTemplateAudioInfo;
    }

    /* access modifiers changed from: protected */
    public final boolean isEntityUpdateable() {
        return true;
    }
}
