package com.introvd.template.app.school.p198db.dao.gen;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import com.introvd.template.app.school.p198db.template.TemplateItemInfo;
import com.introvd.template.common.model.AppStateModel;
import com.introvd.template.datacenter.SocialConstDef;
import com.introvd.template.router.iap.IapServiceProxy;
import org.greenrobot.p490a.C10016g;
import org.greenrobot.p490a.C9964a;
import org.greenrobot.p490a.p492b.C9972a;
import org.greenrobot.p490a.p492b.C9975c;
import org.greenrobot.p490a.p494d.C9986a;

/* renamed from: com.introvd.template.app.school.db.dao.gen.TemplateItemInfoDao */
public class TemplateItemInfoDao extends C9964a<TemplateItemInfo, Long> {
    public static final String TABLENAME = "Template_Item_Info";

    /* renamed from: com.introvd.template.app.school.db.dao.gen.TemplateItemInfoDao$Properties */
    public static class Properties {
        public static final C10016g Title;
        public static final C10016g bxR;
        public static final C10016g bxS;
        public static final C10016g bxU;
        public static final C10016g bxZ;
        public static final C10016g byA;
        public static final C10016g byB;
        public static final C10016g bya;
        public static final C10016g byd;
        public static final C10016g bye;
        public static final C10016g bym;
        public static final C10016g byn;
        public static final C10016g byo;
        public static final C10016g byp;
        public static final C10016g byq;
        public static final C10016g byr;
        public static final C10016g bys;
        public static final C10016g byt;
        public static final C10016g byu;
        public static final C10016g byv;
        public static final C10016g byw;
        public static final C10016g byx;
        public static final C10016g byy;
        public static final C10016g byz;

        static {
            C10016g gVar = new C10016g(0, Long.TYPE, "labelId", false, "label_id");
            bxS = gVar;
            C10016g gVar2 = new C10016g(1, Long.TYPE, "indexid", true, "_id");
            bym = gVar2;
            C10016g gVar3 = new C10016g(2, Long.TYPE, "id", false, AppStateModel.COUNTRY_CODE_Indonesia);
            bxR = gVar3;
            C10016g gVar4 = new C10016g(3, String.class, "ttid", false, "TTID");
            byn = gVar4;
            C10016g gVar5 = new C10016g(4, Long.TYPE, "ver", false, "VER");
            bxU = gVar5;
            C10016g gVar6 = new C10016g(5, Long.TYPE, "useCount", false, "USE_COUNT");
            bxZ = gVar6;
            C10016g gVar7 = new C10016g(6, String.class, "title", false, "TITLE");
            Title = gVar7;
            C10016g gVar8 = new C10016g(7, String.class, "description", false, "DESCRIPTION");
            bya = gVar8;
            C10016g gVar9 = new C10016g(8, String.class, "coverUrl", false, "COVER_URL");
            byd = gVar9;
            C10016g gVar10 = new C10016g(9, String.class, "videoUrl", false, "VIDEO_URL");
            bye = gVar10;
            C10016g gVar11 = new C10016g(10, Integer.TYPE, "width", false, "WIDTH");
            byo = gVar11;
            C10016g gVar12 = new C10016g(11, Integer.TYPE, "height", false, "HEIGHT");
            byp = gVar12;
            C10016g gVar13 = new C10016g(12, Integer.TYPE, "state", false, "STATE");
            byq = gVar13;
            C10016g gVar14 = new C10016g(13, String.class, "templateUrl", false, "TEMPLATE_URL");
            byr = gVar14;
            C10016g gVar15 = new C10016g(14, Integer.TYPE, "eventCode", false, "EVENT_CODE");
            bys = gVar15;
            C10016g gVar16 = new C10016g(15, String.class, SocialConstDef.MESSAGE_LIST_NEW_EVENT_CONTENT, false, "EVENT_CONTENT");
            byt = gVar16;
            C10016g gVar17 = new C10016g(16, String.class, SocialConstDef.FOLLOW_REQUEST_LIST_AUID, false, "AUIDDIGEST");
            byu = gVar17;
            C10016g gVar18 = new C10016g(17, Boolean.TYPE, IapServiceProxy.isVip, false, "IS_VIP");
            byv = gVar18;
            C10016g gVar19 = new C10016g(18, String.class, "country", false, "COUNTRY");
            byw = gVar19;
            C10016g gVar20 = new C10016g(19, Integer.TYPE, "platform", false, "PLATFORM");
            byx = gVar20;
            C10016g gVar21 = new C10016g(20, String.class, "channel", false, "CHANNEL");
            byy = gVar21;
            C10016g gVar22 = new C10016g(21, Integer.TYPE, "flag", false, "FLAG");
            byz = gVar22;
            C10016g gVar23 = new C10016g(22, String.class, "commodityInfo", false, "COMMODITY_INFO");
            byA = gVar23;
            C10016g gVar24 = new C10016g(23, String.class, "userInfo", false, "USER_INFO");
            byB = gVar24;
        }
    }

    public TemplateItemInfoDao(C9986a aVar, C4183b bVar) {
        super(aVar, bVar);
    }

    public static void createTable(C9972a aVar, boolean z) {
        String str = z ? "IF NOT EXISTS " : "";
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE ");
        sb.append(str);
        sb.append("\"Template_Item_Info\" (\"label_id\" INTEGER NOT NULL ,\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL ,\"ID\" INTEGER NOT NULL ,\"TTID\" TEXT,\"VER\" INTEGER NOT NULL ,\"USE_COUNT\" INTEGER NOT NULL ,\"TITLE\" TEXT,\"DESCRIPTION\" TEXT,\"COVER_URL\" TEXT,\"VIDEO_URL\" TEXT,\"WIDTH\" INTEGER NOT NULL ,\"HEIGHT\" INTEGER NOT NULL ,\"STATE\" INTEGER NOT NULL ,\"TEMPLATE_URL\" TEXT,\"EVENT_CODE\" INTEGER NOT NULL ,\"EVENT_CONTENT\" TEXT,\"AUIDDIGEST\" TEXT,\"IS_VIP\" INTEGER NOT NULL ,\"COUNTRY\" TEXT,\"PLATFORM\" INTEGER NOT NULL ,\"CHANNEL\" TEXT,\"FLAG\" INTEGER NOT NULL ,\"COMMODITY_INFO\" TEXT,\"USER_INFO\" TEXT);");
        aVar.execSQL(sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append("CREATE UNIQUE INDEX ");
        sb2.append(str);
        sb2.append("IDX_Template_Item_Info_TTID_ID ON \"Template_Item_Info\" (\"TTID\" ASC,\"ID\" ASC);");
        aVar.execSQL(sb2.toString());
    }

    public static void dropTable(C9972a aVar, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("DROP TABLE ");
        sb.append(z ? "IF EXISTS " : "");
        sb.append("\"Template_Item_Info\"");
        aVar.execSQL(sb.toString());
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final Long updateKeyAfterInsert(TemplateItemInfo templateItemInfo, long j) {
        templateItemInfo.setIndexid(j);
        return Long.valueOf(j);
    }

    /* renamed from: a */
    public void readEntity(Cursor cursor, TemplateItemInfo templateItemInfo, int i) {
        templateItemInfo.setLabelId(cursor.getLong(i + 0));
        templateItemInfo.setIndexid(cursor.getLong(i + 1));
        templateItemInfo.setId(cursor.getLong(i + 2));
        int i2 = i + 3;
        String str = null;
        templateItemInfo.setTtid(cursor.isNull(i2) ? null : cursor.getString(i2));
        templateItemInfo.setVer(cursor.getLong(i + 4));
        templateItemInfo.setUseCount(cursor.getLong(i + 5));
        int i3 = i + 6;
        templateItemInfo.setTitle(cursor.isNull(i3) ? null : cursor.getString(i3));
        int i4 = i + 7;
        templateItemInfo.setDescription(cursor.isNull(i4) ? null : cursor.getString(i4));
        int i5 = i + 8;
        templateItemInfo.setCoverUrl(cursor.isNull(i5) ? null : cursor.getString(i5));
        int i6 = i + 9;
        templateItemInfo.setVideoUrl(cursor.isNull(i6) ? null : cursor.getString(i6));
        templateItemInfo.setWidth(cursor.getInt(i + 10));
        templateItemInfo.setHeight(cursor.getInt(i + 11));
        templateItemInfo.setState(cursor.getInt(i + 12));
        int i7 = i + 13;
        templateItemInfo.setTemplateUrl(cursor.isNull(i7) ? null : cursor.getString(i7));
        templateItemInfo.setEventCode(cursor.getInt(i + 14));
        int i8 = i + 15;
        templateItemInfo.setEventContent(cursor.isNull(i8) ? null : cursor.getString(i8));
        int i9 = i + 16;
        templateItemInfo.setAuiddigest(cursor.isNull(i9) ? null : cursor.getString(i9));
        templateItemInfo.setIsVip(cursor.getShort(i + 17) != 0);
        int i10 = i + 18;
        templateItemInfo.setCountry(cursor.isNull(i10) ? null : cursor.getString(i10));
        templateItemInfo.setPlatform(cursor.getInt(i + 19));
        int i11 = i + 20;
        templateItemInfo.setChannel(cursor.isNull(i11) ? null : cursor.getString(i11));
        templateItemInfo.setFlag(cursor.getInt(i + 21));
        int i12 = i + 22;
        templateItemInfo.setCommodityInfo(cursor.isNull(i12) ? null : cursor.getString(i12));
        int i13 = i + 23;
        if (!cursor.isNull(i13)) {
            str = cursor.getString(i13);
        }
        templateItemInfo.setUserInfo(str);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void bindValues(SQLiteStatement sQLiteStatement, TemplateItemInfo templateItemInfo) {
        sQLiteStatement.clearBindings();
        sQLiteStatement.bindLong(1, templateItemInfo.getLabelId());
        sQLiteStatement.bindLong(2, templateItemInfo.getIndexid());
        sQLiteStatement.bindLong(3, templateItemInfo.getId());
        String ttid = templateItemInfo.getTtid();
        if (ttid != null) {
            sQLiteStatement.bindString(4, ttid);
        }
        sQLiteStatement.bindLong(5, templateItemInfo.getVer());
        sQLiteStatement.bindLong(6, templateItemInfo.getUseCount());
        String title = templateItemInfo.getTitle();
        if (title != null) {
            sQLiteStatement.bindString(7, title);
        }
        String description = templateItemInfo.getDescription();
        if (description != null) {
            sQLiteStatement.bindString(8, description);
        }
        String coverUrl = templateItemInfo.getCoverUrl();
        if (coverUrl != null) {
            sQLiteStatement.bindString(9, coverUrl);
        }
        String videoUrl = templateItemInfo.getVideoUrl();
        if (videoUrl != null) {
            sQLiteStatement.bindString(10, videoUrl);
        }
        sQLiteStatement.bindLong(11, (long) templateItemInfo.getWidth());
        sQLiteStatement.bindLong(12, (long) templateItemInfo.getHeight());
        sQLiteStatement.bindLong(13, (long) templateItemInfo.getState());
        String templateUrl = templateItemInfo.getTemplateUrl();
        if (templateUrl != null) {
            sQLiteStatement.bindString(14, templateUrl);
        }
        sQLiteStatement.bindLong(15, (long) templateItemInfo.getEventCode());
        String eventContent = templateItemInfo.getEventContent();
        if (eventContent != null) {
            sQLiteStatement.bindString(16, eventContent);
        }
        String auiddigest = templateItemInfo.getAuiddigest();
        if (auiddigest != null) {
            sQLiteStatement.bindString(17, auiddigest);
        }
        sQLiteStatement.bindLong(18, templateItemInfo.getIsVip() ? 1 : 0);
        String country = templateItemInfo.getCountry();
        if (country != null) {
            sQLiteStatement.bindString(19, country);
        }
        sQLiteStatement.bindLong(20, (long) templateItemInfo.getPlatform());
        String channel = templateItemInfo.getChannel();
        if (channel != null) {
            sQLiteStatement.bindString(21, channel);
        }
        sQLiteStatement.bindLong(22, (long) templateItemInfo.getFlag());
        String commodityInfo = templateItemInfo.getCommodityInfo();
        if (commodityInfo != null) {
            sQLiteStatement.bindString(23, commodityInfo);
        }
        String userInfo = templateItemInfo.getUserInfo();
        if (userInfo != null) {
            sQLiteStatement.bindString(24, userInfo);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void bindValues(C9975c cVar, TemplateItemInfo templateItemInfo) {
        cVar.clearBindings();
        cVar.bindLong(1, templateItemInfo.getLabelId());
        cVar.bindLong(2, templateItemInfo.getIndexid());
        cVar.bindLong(3, templateItemInfo.getId());
        String ttid = templateItemInfo.getTtid();
        if (ttid != null) {
            cVar.bindString(4, ttid);
        }
        cVar.bindLong(5, templateItemInfo.getVer());
        cVar.bindLong(6, templateItemInfo.getUseCount());
        String title = templateItemInfo.getTitle();
        if (title != null) {
            cVar.bindString(7, title);
        }
        String description = templateItemInfo.getDescription();
        if (description != null) {
            cVar.bindString(8, description);
        }
        String coverUrl = templateItemInfo.getCoverUrl();
        if (coverUrl != null) {
            cVar.bindString(9, coverUrl);
        }
        String videoUrl = templateItemInfo.getVideoUrl();
        if (videoUrl != null) {
            cVar.bindString(10, videoUrl);
        }
        cVar.bindLong(11, (long) templateItemInfo.getWidth());
        cVar.bindLong(12, (long) templateItemInfo.getHeight());
        cVar.bindLong(13, (long) templateItemInfo.getState());
        String templateUrl = templateItemInfo.getTemplateUrl();
        if (templateUrl != null) {
            cVar.bindString(14, templateUrl);
        }
        cVar.bindLong(15, (long) templateItemInfo.getEventCode());
        String eventContent = templateItemInfo.getEventContent();
        if (eventContent != null) {
            cVar.bindString(16, eventContent);
        }
        String auiddigest = templateItemInfo.getAuiddigest();
        if (auiddigest != null) {
            cVar.bindString(17, auiddigest);
        }
        cVar.bindLong(18, templateItemInfo.getIsVip() ? 1 : 0);
        String country = templateItemInfo.getCountry();
        if (country != null) {
            cVar.bindString(19, country);
        }
        cVar.bindLong(20, (long) templateItemInfo.getPlatform());
        String channel = templateItemInfo.getChannel();
        if (channel != null) {
            cVar.bindString(21, channel);
        }
        cVar.bindLong(22, (long) templateItemInfo.getFlag());
        String commodityInfo = templateItemInfo.getCommodityInfo();
        if (commodityInfo != null) {
            cVar.bindString(23, commodityInfo);
        }
        String userInfo = templateItemInfo.getUserInfo();
        if (userInfo != null) {
            cVar.bindString(24, userInfo);
        }
    }

    /* renamed from: b */
    public Long getKey(TemplateItemInfo templateItemInfo) {
        if (templateItemInfo != null) {
            return Long.valueOf(templateItemInfo.getIndexid());
        }
        return null;
    }

    /* renamed from: c */
    public TemplateItemInfo readEntity(Cursor cursor, int i) {
        Cursor cursor2 = cursor;
        long j = cursor2.getLong(i + 0);
        long j2 = cursor2.getLong(i + 1);
        long j3 = cursor2.getLong(i + 2);
        int i2 = i + 3;
        String string = cursor2.isNull(i2) ? null : cursor2.getString(i2);
        long j4 = cursor2.getLong(i + 4);
        long j5 = cursor2.getLong(i + 5);
        int i3 = i + 6;
        String string2 = cursor2.isNull(i3) ? null : cursor2.getString(i3);
        int i4 = i + 7;
        String string3 = cursor2.isNull(i4) ? null : cursor2.getString(i4);
        int i5 = i + 8;
        String string4 = cursor2.isNull(i5) ? null : cursor2.getString(i5);
        int i6 = i + 9;
        String string5 = cursor2.isNull(i6) ? null : cursor2.getString(i6);
        int i7 = cursor2.getInt(i + 10);
        int i8 = cursor2.getInt(i + 11);
        int i9 = cursor2.getInt(i + 12);
        int i10 = i + 13;
        String string6 = cursor2.isNull(i10) ? null : cursor2.getString(i10);
        int i11 = cursor2.getInt(i + 14);
        int i12 = i + 15;
        String string7 = cursor2.isNull(i12) ? null : cursor2.getString(i12);
        int i13 = i + 16;
        String string8 = cursor2.isNull(i13) ? null : cursor2.getString(i13);
        boolean z = cursor2.getShort(i + 17) != 0;
        int i14 = i + 18;
        String string9 = cursor2.isNull(i14) ? null : cursor2.getString(i14);
        int i15 = cursor2.getInt(i + 19);
        int i16 = i + 20;
        String string10 = cursor2.isNull(i16) ? null : cursor2.getString(i16);
        int i17 = i + 22;
        int i18 = i + 23;
        TemplateItemInfo templateItemInfo = new TemplateItemInfo(j, j2, j3, string, j4, j5, string2, string3, string4, string5, i7, i8, i9, string6, i11, string7, string8, z, string9, i15, string10, cursor2.getInt(i + 21), cursor2.isNull(i17) ? null : cursor2.getString(i17), cursor2.isNull(i18) ? null : cursor2.getString(i18));
        return templateItemInfo;
    }

    /* renamed from: c */
    public boolean hasKey(TemplateItemInfo templateItemInfo) {
        throw new UnsupportedOperationException("Unsupported for entities with a non-null key");
    }

    /* access modifiers changed from: protected */
    public final boolean isEntityUpdateable() {
        return true;
    }

    public Long readKey(Cursor cursor, int i) {
        return Long.valueOf(cursor.getLong(i + 1));
    }
}
