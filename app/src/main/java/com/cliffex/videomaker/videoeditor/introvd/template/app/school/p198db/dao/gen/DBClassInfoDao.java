package com.introvd.template.app.school.p198db.dao.gen;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import com.introvd.template.app.school.p198db.classes.DBClassInfo;
import com.introvd.template.datacenter.SocialServiceDef;
import org.greenrobot.p490a.C10016g;
import org.greenrobot.p490a.C9964a;
import org.greenrobot.p490a.p492b.C9972a;
import org.greenrobot.p490a.p492b.C9975c;
import org.greenrobot.p490a.p494d.C9986a;

/* renamed from: com.introvd.template.app.school.db.dao.gen.DBClassInfoDao */
public class DBClassInfoDao extends C9964a<DBClassInfo, Long> {
    public static final String TABLENAME = "class_info";

    /* renamed from: com.introvd.template.app.school.db.dao.gen.DBClassInfoDao$Properties */
    public static class Properties {
        public static final C10016g Title;
        public static final C10016g bxR;
        public static final C10016g bxS;
        public static final C10016g bxT;
        public static final C10016g bxU;
        public static final C10016g bxV;
        public static final C10016g bxW;
        public static final C10016g bxX;
        public static final C10016g bxY;
        public static final C10016g bxZ;
        public static final C10016g bya;
        public static final C10016g byb;
        public static final C10016g byc;
        public static final C10016g byd;
        public static final C10016g bye;
        public static final C10016g byf;
        public static final C10016g byg;
        public static final C10016g byh;

        static {
            C10016g gVar = new C10016g(0, Long.class, "id", true, "_id");
            bxR = gVar;
            C10016g gVar2 = new C10016g(1, Long.TYPE, "labelId", false, "label_id");
            bxS = gVar2;
            C10016g gVar3 = new C10016g(2, Long.TYPE, "puid", false, "puid");
            bxT = gVar3;
            C10016g gVar4 = new C10016g(3, Integer.TYPE, "ver", false, "ver");
            bxU = gVar4;
            C10016g gVar5 = new C10016g(4, Long.TYPE, "auid", false, "auid");
            bxV = gVar5;
            C10016g gVar6 = new C10016g(5, String.class, "extend", false, "extend");
            bxW = gVar6;
            C10016g gVar7 = new C10016g(6, String.class, "desc", false, "desc");
            bxX = gVar7;
            C10016g gVar8 = new C10016g(7, Integer.TYPE, "ayid", false, "ayid");
            bxY = gVar8;
            C10016g gVar9 = new C10016g(8, Integer.TYPE, "useCount", false, "use_count");
            bxZ = gVar9;
            C10016g gVar10 = new C10016g(9, String.class, "title", false, "title");
            Title = gVar10;
            C10016g gVar11 = new C10016g(10, String.class, "description", false, "description");
            bya = gVar11;
            C10016g gVar12 = new C10016g(11, String.class, "userName", false, SocialServiceDef.EXTRAS_USER_NAME);
            byb = gVar12;
            C10016g gVar13 = new C10016g(12, Integer.TYPE, "studioGrade", false, "studio_grade");
            byc = gVar13;
            C10016g gVar14 = new C10016g(13, String.class, "coverUrl", false, "cover_url");
            byd = gVar14;
            C10016g gVar15 = new C10016g(14, String.class, "videoUrl", false, "video_url");
            bye = gVar15;
            C10016g gVar16 = new C10016g(15, String.class, "logoUrl", false, "logo_url");
            byf = gVar16;
            C10016g gVar17 = new C10016g(16, String.class, "keywordsJson", false, "keywords_json");
            byg = gVar17;
            C10016g gVar18 = new C10016g(17, String.class, "webUrl", false, "web_url");
            byh = gVar18;
        }
    }

    public DBClassInfoDao(C9986a aVar, C4183b bVar) {
        super(aVar, bVar);
    }

    public static void createTable(C9972a aVar, boolean z) {
        String str = z ? "IF NOT EXISTS " : "";
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE ");
        sb.append(str);
        sb.append("\"class_info\" (\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ,\"label_id\" INTEGER NOT NULL ,\"puid\" INTEGER NOT NULL ,\"ver\" INTEGER NOT NULL ,\"auid\" INTEGER NOT NULL ,\"extend\" TEXT,\"desc\" TEXT,\"ayid\" INTEGER NOT NULL ,\"use_count\" INTEGER NOT NULL ,\"title\" TEXT,\"description\" TEXT,\"user_name\" TEXT,\"studio_grade\" INTEGER NOT NULL ,\"cover_url\" TEXT,\"video_url\" TEXT,\"logo_url\" TEXT,\"keywords_json\" TEXT,\"web_url\" TEXT);");
        aVar.execSQL(sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append("CREATE UNIQUE INDEX ");
        sb2.append(str);
        sb2.append("IDX_class_info_puid_label_id ON \"class_info\" (\"puid\" ASC,\"label_id\" ASC);");
        aVar.execSQL(sb2.toString());
    }

    public static void dropTable(C9972a aVar, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("DROP TABLE ");
        sb.append(z ? "IF EXISTS " : "");
        sb.append("\"class_info\"");
        aVar.execSQL(sb.toString());
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final Long updateKeyAfterInsert(DBClassInfo dBClassInfo, long j) {
        dBClassInfo.setId(Long.valueOf(j));
        return Long.valueOf(j);
    }

    /* renamed from: a */
    public void readEntity(Cursor cursor, DBClassInfo dBClassInfo, int i) {
        int i2 = i + 0;
        String str = null;
        dBClassInfo.setId(cursor.isNull(i2) ? null : Long.valueOf(cursor.getLong(i2)));
        dBClassInfo.setLabelId(cursor.getLong(i + 1));
        dBClassInfo.setPuid(cursor.getLong(i + 2));
        dBClassInfo.setVer(cursor.getInt(i + 3));
        dBClassInfo.setAuid(cursor.getLong(i + 4));
        int i3 = i + 5;
        dBClassInfo.setExtend(cursor.isNull(i3) ? null : cursor.getString(i3));
        int i4 = i + 6;
        dBClassInfo.setDesc(cursor.isNull(i4) ? null : cursor.getString(i4));
        dBClassInfo.setAyid(cursor.getInt(i + 7));
        dBClassInfo.setUseCount(cursor.getInt(i + 8));
        int i5 = i + 9;
        dBClassInfo.setTitle(cursor.isNull(i5) ? null : cursor.getString(i5));
        int i6 = i + 10;
        dBClassInfo.setDescription(cursor.isNull(i6) ? null : cursor.getString(i6));
        int i7 = i + 11;
        dBClassInfo.setUserName(cursor.isNull(i7) ? null : cursor.getString(i7));
        dBClassInfo.setStudioGrade(cursor.getInt(i + 12));
        int i8 = i + 13;
        dBClassInfo.setCoverUrl(cursor.isNull(i8) ? null : cursor.getString(i8));
        int i9 = i + 14;
        dBClassInfo.setVideoUrl(cursor.isNull(i9) ? null : cursor.getString(i9));
        int i10 = i + 15;
        dBClassInfo.setLogoUrl(cursor.isNull(i10) ? null : cursor.getString(i10));
        int i11 = i + 16;
        dBClassInfo.setKeywordsJson(cursor.isNull(i11) ? null : cursor.getString(i11));
        int i12 = i + 17;
        if (!cursor.isNull(i12)) {
            str = cursor.getString(i12);
        }
        dBClassInfo.setWebUrl(str);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void bindValues(SQLiteStatement sQLiteStatement, DBClassInfo dBClassInfo) {
        sQLiteStatement.clearBindings();
        Long id = dBClassInfo.getId();
        if (id != null) {
            sQLiteStatement.bindLong(1, id.longValue());
        }
        sQLiteStatement.bindLong(2, dBClassInfo.getLabelId());
        sQLiteStatement.bindLong(3, dBClassInfo.getPuid());
        sQLiteStatement.bindLong(4, (long) dBClassInfo.getVer());
        sQLiteStatement.bindLong(5, dBClassInfo.getAuid());
        String extend = dBClassInfo.getExtend();
        if (extend != null) {
            sQLiteStatement.bindString(6, extend);
        }
        String desc = dBClassInfo.getDesc();
        if (desc != null) {
            sQLiteStatement.bindString(7, desc);
        }
        sQLiteStatement.bindLong(8, (long) dBClassInfo.getAyid());
        sQLiteStatement.bindLong(9, (long) dBClassInfo.getUseCount());
        String title = dBClassInfo.getTitle();
        if (title != null) {
            sQLiteStatement.bindString(10, title);
        }
        String description = dBClassInfo.getDescription();
        if (description != null) {
            sQLiteStatement.bindString(11, description);
        }
        String userName = dBClassInfo.getUserName();
        if (userName != null) {
            sQLiteStatement.bindString(12, userName);
        }
        sQLiteStatement.bindLong(13, (long) dBClassInfo.getStudioGrade());
        String coverUrl = dBClassInfo.getCoverUrl();
        if (coverUrl != null) {
            sQLiteStatement.bindString(14, coverUrl);
        }
        String videoUrl = dBClassInfo.getVideoUrl();
        if (videoUrl != null) {
            sQLiteStatement.bindString(15, videoUrl);
        }
        String logoUrl = dBClassInfo.getLogoUrl();
        if (logoUrl != null) {
            sQLiteStatement.bindString(16, logoUrl);
        }
        String keywordsJson = dBClassInfo.getKeywordsJson();
        if (keywordsJson != null) {
            sQLiteStatement.bindString(17, keywordsJson);
        }
        String webUrl = dBClassInfo.getWebUrl();
        if (webUrl != null) {
            sQLiteStatement.bindString(18, webUrl);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void bindValues(C9975c cVar, DBClassInfo dBClassInfo) {
        cVar.clearBindings();
        Long id = dBClassInfo.getId();
        if (id != null) {
            cVar.bindLong(1, id.longValue());
        }
        cVar.bindLong(2, dBClassInfo.getLabelId());
        cVar.bindLong(3, dBClassInfo.getPuid());
        cVar.bindLong(4, (long) dBClassInfo.getVer());
        cVar.bindLong(5, dBClassInfo.getAuid());
        String extend = dBClassInfo.getExtend();
        if (extend != null) {
            cVar.bindString(6, extend);
        }
        String desc = dBClassInfo.getDesc();
        if (desc != null) {
            cVar.bindString(7, desc);
        }
        cVar.bindLong(8, (long) dBClassInfo.getAyid());
        cVar.bindLong(9, (long) dBClassInfo.getUseCount());
        String title = dBClassInfo.getTitle();
        if (title != null) {
            cVar.bindString(10, title);
        }
        String description = dBClassInfo.getDescription();
        if (description != null) {
            cVar.bindString(11, description);
        }
        String userName = dBClassInfo.getUserName();
        if (userName != null) {
            cVar.bindString(12, userName);
        }
        cVar.bindLong(13, (long) dBClassInfo.getStudioGrade());
        String coverUrl = dBClassInfo.getCoverUrl();
        if (coverUrl != null) {
            cVar.bindString(14, coverUrl);
        }
        String videoUrl = dBClassInfo.getVideoUrl();
        if (videoUrl != null) {
            cVar.bindString(15, videoUrl);
        }
        String logoUrl = dBClassInfo.getLogoUrl();
        if (logoUrl != null) {
            cVar.bindString(16, logoUrl);
        }
        String keywordsJson = dBClassInfo.getKeywordsJson();
        if (keywordsJson != null) {
            cVar.bindString(17, keywordsJson);
        }
        String webUrl = dBClassInfo.getWebUrl();
        if (webUrl != null) {
            cVar.bindString(18, webUrl);
        }
    }

    /* renamed from: b */
    public DBClassInfo readEntity(Cursor cursor, int i) {
        Cursor cursor2 = cursor;
        int i2 = i + 0;
        Long valueOf = cursor2.isNull(i2) ? null : Long.valueOf(cursor2.getLong(i2));
        long j = cursor2.getLong(i + 1);
        long j2 = cursor2.getLong(i + 2);
        int i3 = cursor2.getInt(i + 3);
        long j3 = cursor2.getLong(i + 4);
        int i4 = i + 5;
        String string = cursor2.isNull(i4) ? null : cursor2.getString(i4);
        int i5 = i + 6;
        String string2 = cursor2.isNull(i5) ? null : cursor2.getString(i5);
        int i6 = cursor2.getInt(i + 7);
        int i7 = cursor2.getInt(i + 8);
        int i8 = i + 9;
        String string3 = cursor2.isNull(i8) ? null : cursor2.getString(i8);
        int i9 = i + 10;
        String string4 = cursor2.isNull(i9) ? null : cursor2.getString(i9);
        int i10 = i + 11;
        String string5 = cursor2.isNull(i10) ? null : cursor2.getString(i10);
        int i11 = cursor2.getInt(i + 12);
        int i12 = i + 13;
        String string6 = cursor2.isNull(i12) ? null : cursor2.getString(i12);
        int i13 = i + 14;
        String string7 = cursor2.isNull(i13) ? null : cursor2.getString(i13);
        int i14 = i + 15;
        String string8 = cursor2.isNull(i14) ? null : cursor2.getString(i14);
        int i15 = i + 16;
        int i16 = i + 17;
        DBClassInfo dBClassInfo = new DBClassInfo(valueOf, j, j2, i3, j3, string, string2, i6, i7, string3, string4, string5, i11, string6, string7, string8, cursor2.isNull(i15) ? null : cursor2.getString(i15), cursor2.isNull(i16) ? null : cursor2.getString(i16));
        return dBClassInfo;
    }

    /* renamed from: c */
    public Long getKey(DBClassInfo dBClassInfo) {
        if (dBClassInfo != null) {
            return dBClassInfo.getId();
        }
        return null;
    }

    /* renamed from: d */
    public boolean hasKey(DBClassInfo dBClassInfo) {
        return dBClassInfo.getId() != null;
    }

    /* access modifiers changed from: protected */
    public final boolean isEntityUpdateable() {
        return true;
    }

    public Long readKey(Cursor cursor, int i) {
        int i2 = i + 0;
        if (cursor.isNull(i2)) {
            return null;
        }
        return Long.valueOf(cursor.getLong(i2));
    }
}
