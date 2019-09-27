package com.introvd.template.sdk.database.model;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import com.introvd.template.datacenter.SocialConstDef;
import org.greenrobot.p490a.C10016g;
import org.greenrobot.p490a.C9964a;
import org.greenrobot.p490a.p492b.C9972a;
import org.greenrobot.p490a.p492b.C9975c;
import org.greenrobot.p490a.p494d.C9986a;

public class DBProjectDao extends C9964a<DBProject, Long> {
    public static final String TABLENAME = "Project";

    public static class Properties {
        public static final C10016g ActivityData;
        public static final C10016g CameraCode;
        public static final C10016g Clip_count;
        public static final C10016g CoverURL;
        public static final C10016g Create_time;
        public static final C10016g Duration;
        public static final C10016g Duration_limit;
        public static final C10016g EditCode;
        public static final C10016g EffectID;
        public static final C10016g Entrance;
        public static final C10016g Export_url;
        public static final C10016g Extras;
        public static final C10016g Is_deleted;
        public static final C10016g Is_modified;
        public static final C10016g Modify_time;
        public static final C10016g StreamHeight;
        public static final C10016g StreamWidth;
        public static final C10016g Theme_type;
        public static final C10016g Thumbnail;
        public static final C10016g Title;
        public static final C10016g TodoCode;
        public static final C10016g Url;
        public static final C10016g Version;
        public static final C10016g Video_desc;
        public static final C10016g Video_template_info;
        public static final C10016g _id;

        static {
            C10016g gVar = new C10016g(0, Long.class, "_id", true, "_id");
            _id = gVar;
            C10016g gVar2 = new C10016g(1, String.class, "url", false, "url");
            Url = gVar2;
            C10016g gVar3 = new C10016g(2, String.class, SocialConstDef.PROJECT_EXPORT_URL, false, SocialConstDef.PROJECT_EXPORT_URL);
            Export_url = gVar3;
            C10016g gVar4 = new C10016g(3, String.class, SocialConstDef.PROJECT_THUMBNAIL, false, SocialConstDef.PROJECT_THUMBNAIL);
            Thumbnail = gVar4;
            C10016g gVar5 = new C10016g(4, String.class, "coverURL", false, "coverURL");
            CoverURL = gVar5;
            C10016g gVar6 = new C10016g(5, String.class, "version", false, "version");
            Version = gVar6;
            C10016g gVar7 = new C10016g(6, String.class, "create_time", false, "create_time");
            Create_time = gVar7;
            C10016g gVar8 = new C10016g(7, String.class, "modify_time", false, "modify_time");
            Modify_time = gVar8;
            C10016g gVar9 = new C10016g(8, Integer.TYPE, SocialConstDef.PROJECT_CLIP_COUNT, false, SocialConstDef.PROJECT_CLIP_COUNT);
            Clip_count = gVar9;
            C10016g gVar10 = new C10016g(9, Long.TYPE, "duration", false, "duration");
            Duration = gVar10;
            C10016g gVar11 = new C10016g(10, Integer.TYPE, SocialConstDef.PROJECT_DURATION_LIMIT, false, SocialConstDef.PROJECT_DURATION_LIMIT);
            Duration_limit = gVar11;
            C10016g gVar12 = new C10016g(11, Integer.TYPE, "streamWidth", false, "streamWidth");
            StreamWidth = gVar12;
            C10016g gVar13 = new C10016g(12, Integer.TYPE, SocialConstDef.PROJECT_HEIGHT, false, SocialConstDef.PROJECT_HEIGHT);
            StreamHeight = gVar13;
            C10016g gVar14 = new C10016g(13, Integer.TYPE, SocialConstDef.PROJECT_ISDELETED, false, SocialConstDef.PROJECT_ISDELETED);
            Is_deleted = gVar14;
            C10016g gVar15 = new C10016g(14, Integer.TYPE, SocialConstDef.PROJECT_ISMODIFIED, false, SocialConstDef.PROJECT_ISMODIFIED);
            Is_modified = gVar15;
            C10016g gVar16 = new C10016g(15, String.class, SocialConstDef.PROJECT_ENTRANCE, false, SocialConstDef.PROJECT_ENTRANCE);
            Entrance = gVar16;
            C10016g gVar17 = new C10016g(16, Integer.TYPE, "todoCode", false, "todoCode");
            TodoCode = gVar17;
            C10016g gVar18 = new C10016g(17, Integer.TYPE, SocialConstDef.PROJECT_EDIT_CODE, false, SocialConstDef.PROJECT_EDIT_CODE);
            EditCode = gVar18;
            C10016g gVar19 = new C10016g(18, Integer.TYPE, SocialConstDef.PROJECT_CAMERA_CODE, false, SocialConstDef.PROJECT_CAMERA_CODE);
            CameraCode = gVar19;
            C10016g gVar20 = new C10016g(19, Long.TYPE, SocialConstDef.PROJECT_EFFECT_ID, false, SocialConstDef.PROJECT_EFFECT_ID);
            EffectID = gVar20;
            C10016g gVar21 = new C10016g(20, Integer.TYPE, SocialConstDef.PROJECT_THEME_TYPE, false, SocialConstDef.PROJECT_THEME_TYPE);
            Theme_type = gVar21;
            C10016g gVar22 = new C10016g(21, String.class, SocialConstDef.PROJECT_VIDEO_TEMPLATE_INFO, false, SocialConstDef.PROJECT_VIDEO_TEMPLATE_INFO);
            Video_template_info = gVar22;
            C10016g gVar23 = new C10016g(22, String.class, "title", false, "title");
            Title = gVar23;
            C10016g gVar24 = new C10016g(23, String.class, "video_desc", false, "video_desc");
            Video_desc = gVar24;
            C10016g gVar25 = new C10016g(24, String.class, SocialConstDef.PROJECT_ACTVITY_DATA, false, SocialConstDef.PROJECT_ACTVITY_DATA);
            ActivityData = gVar25;
            C10016g gVar26 = new C10016g(25, String.class, "extras", false, "extras");
            Extras = gVar26;
        }
    }

    public DBProjectDao(C9986a aVar) {
        super(aVar);
    }

    public DBProjectDao(C9986a aVar, DaoSession daoSession) {
        super(aVar, daoSession);
    }

    public static void createTable(C9972a aVar, boolean z) {
        String str = z ? "IF NOT EXISTS " : "";
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE ");
        sb.append(str);
        sb.append("\"Project\" (\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ,\"url\" TEXT UNIQUE ,\"export_url\" TEXT,\"thumbnail\" TEXT,\"coverURL\" TEXT,\"version\" TEXT,\"create_time\" TEXT,\"modify_time\" TEXT,\"clip_count\" INTEGER NOT NULL ,\"duration\" INTEGER NOT NULL ,\"duration_limit\" INTEGER NOT NULL ,\"streamWidth\" INTEGER NOT NULL ,\"streamHeight\" INTEGER NOT NULL ,\"is_deleted\" INTEGER NOT NULL ,\"is_modified\" INTEGER NOT NULL ,\"entrance\" TEXT,\"todoCode\" INTEGER NOT NULL ,\"editCode\" INTEGER NOT NULL ,\"cameraCode\" INTEGER NOT NULL ,\"effectID\" INTEGER NOT NULL ,\"theme_type\" INTEGER NOT NULL ,\"video_template_info\" TEXT,\"title\" TEXT,\"video_desc\" TEXT,\"activityData\" TEXT,\"extras\" TEXT);");
        aVar.execSQL(sb.toString());
    }

    public static void dropTable(C9972a aVar, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("DROP TABLE ");
        sb.append(z ? "IF EXISTS " : "");
        sb.append("\"Project\"");
        aVar.execSQL(sb.toString());
    }

    /* access modifiers changed from: protected */
    public final void bindValues(SQLiteStatement sQLiteStatement, DBProject dBProject) {
        sQLiteStatement.clearBindings();
        Long l = dBProject.get_id();
        if (l != null) {
            sQLiteStatement.bindLong(1, l.longValue());
        }
        String url = dBProject.getUrl();
        if (url != null) {
            sQLiteStatement.bindString(2, url);
        }
        String export_url = dBProject.getExport_url();
        if (export_url != null) {
            sQLiteStatement.bindString(3, export_url);
        }
        String thumbnail = dBProject.getThumbnail();
        if (thumbnail != null) {
            sQLiteStatement.bindString(4, thumbnail);
        }
        String coverURL = dBProject.getCoverURL();
        if (coverURL != null) {
            sQLiteStatement.bindString(5, coverURL);
        }
        String version = dBProject.getVersion();
        if (version != null) {
            sQLiteStatement.bindString(6, version);
        }
        String create_time = dBProject.getCreate_time();
        if (create_time != null) {
            sQLiteStatement.bindString(7, create_time);
        }
        String modify_time = dBProject.getModify_time();
        if (modify_time != null) {
            sQLiteStatement.bindString(8, modify_time);
        }
        sQLiteStatement.bindLong(9, (long) dBProject.getClip_count());
        sQLiteStatement.bindLong(10, dBProject.getDuration());
        sQLiteStatement.bindLong(11, (long) dBProject.getDuration_limit());
        sQLiteStatement.bindLong(12, (long) dBProject.getStreamWidth());
        sQLiteStatement.bindLong(13, (long) dBProject.getStreamHeight());
        sQLiteStatement.bindLong(14, (long) dBProject.getIs_deleted());
        sQLiteStatement.bindLong(15, (long) dBProject.getIs_modified());
        String entrance = dBProject.getEntrance();
        if (entrance != null) {
            sQLiteStatement.bindString(16, entrance);
        }
        sQLiteStatement.bindLong(17, (long) dBProject.getTodoCode());
        sQLiteStatement.bindLong(18, (long) dBProject.getEditCode());
        sQLiteStatement.bindLong(19, (long) dBProject.getCameraCode());
        sQLiteStatement.bindLong(20, dBProject.getEffectID());
        sQLiteStatement.bindLong(21, (long) dBProject.getTheme_type());
        String video_template_info = dBProject.getVideo_template_info();
        if (video_template_info != null) {
            sQLiteStatement.bindString(22, video_template_info);
        }
        String title = dBProject.getTitle();
        if (title != null) {
            sQLiteStatement.bindString(23, title);
        }
        String video_desc = dBProject.getVideo_desc();
        if (video_desc != null) {
            sQLiteStatement.bindString(24, video_desc);
        }
        String activityData = dBProject.getActivityData();
        if (activityData != null) {
            sQLiteStatement.bindString(25, activityData);
        }
        String extras = dBProject.getExtras();
        if (extras != null) {
            sQLiteStatement.bindString(26, extras);
        }
    }

    /* access modifiers changed from: protected */
    public final void bindValues(C9975c cVar, DBProject dBProject) {
        cVar.clearBindings();
        Long l = dBProject.get_id();
        if (l != null) {
            cVar.bindLong(1, l.longValue());
        }
        String url = dBProject.getUrl();
        if (url != null) {
            cVar.bindString(2, url);
        }
        String export_url = dBProject.getExport_url();
        if (export_url != null) {
            cVar.bindString(3, export_url);
        }
        String thumbnail = dBProject.getThumbnail();
        if (thumbnail != null) {
            cVar.bindString(4, thumbnail);
        }
        String coverURL = dBProject.getCoverURL();
        if (coverURL != null) {
            cVar.bindString(5, coverURL);
        }
        String version = dBProject.getVersion();
        if (version != null) {
            cVar.bindString(6, version);
        }
        String create_time = dBProject.getCreate_time();
        if (create_time != null) {
            cVar.bindString(7, create_time);
        }
        String modify_time = dBProject.getModify_time();
        if (modify_time != null) {
            cVar.bindString(8, modify_time);
        }
        cVar.bindLong(9, (long) dBProject.getClip_count());
        cVar.bindLong(10, dBProject.getDuration());
        cVar.bindLong(11, (long) dBProject.getDuration_limit());
        cVar.bindLong(12, (long) dBProject.getStreamWidth());
        cVar.bindLong(13, (long) dBProject.getStreamHeight());
        cVar.bindLong(14, (long) dBProject.getIs_deleted());
        cVar.bindLong(15, (long) dBProject.getIs_modified());
        String entrance = dBProject.getEntrance();
        if (entrance != null) {
            cVar.bindString(16, entrance);
        }
        cVar.bindLong(17, (long) dBProject.getTodoCode());
        cVar.bindLong(18, (long) dBProject.getEditCode());
        cVar.bindLong(19, (long) dBProject.getCameraCode());
        cVar.bindLong(20, dBProject.getEffectID());
        cVar.bindLong(21, (long) dBProject.getTheme_type());
        String video_template_info = dBProject.getVideo_template_info();
        if (video_template_info != null) {
            cVar.bindString(22, video_template_info);
        }
        String title = dBProject.getTitle();
        if (title != null) {
            cVar.bindString(23, title);
        }
        String video_desc = dBProject.getVideo_desc();
        if (video_desc != null) {
            cVar.bindString(24, video_desc);
        }
        String activityData = dBProject.getActivityData();
        if (activityData != null) {
            cVar.bindString(25, activityData);
        }
        String extras = dBProject.getExtras();
        if (extras != null) {
            cVar.bindString(26, extras);
        }
    }

    public Long getKey(DBProject dBProject) {
        if (dBProject != null) {
            return dBProject.get_id();
        }
        return null;
    }

    public boolean hasKey(DBProject dBProject) {
        return dBProject.get_id() != null;
    }

    /* access modifiers changed from: protected */
    public final boolean isEntityUpdateable() {
        return true;
    }

    public DBProject readEntity(Cursor cursor, int i) {
        Cursor cursor2 = cursor;
        int i2 = i + 0;
        Long valueOf = cursor2.isNull(i2) ? null : Long.valueOf(cursor2.getLong(i2));
        int i3 = i + 1;
        String string = cursor2.isNull(i3) ? null : cursor2.getString(i3);
        int i4 = i + 2;
        String string2 = cursor2.isNull(i4) ? null : cursor2.getString(i4);
        int i5 = i + 3;
        String string3 = cursor2.isNull(i5) ? null : cursor2.getString(i5);
        int i6 = i + 4;
        String string4 = cursor2.isNull(i6) ? null : cursor2.getString(i6);
        int i7 = i + 5;
        String string5 = cursor2.isNull(i7) ? null : cursor2.getString(i7);
        int i8 = i + 6;
        String string6 = cursor2.isNull(i8) ? null : cursor2.getString(i8);
        int i9 = i + 7;
        String string7 = cursor2.isNull(i9) ? null : cursor2.getString(i9);
        int i10 = cursor2.getInt(i + 8);
        long j = cursor2.getLong(i + 9);
        int i11 = cursor2.getInt(i + 10);
        int i12 = cursor2.getInt(i + 11);
        int i13 = cursor2.getInt(i + 12);
        int i14 = cursor2.getInt(i + 13);
        int i15 = cursor2.getInt(i + 14);
        int i16 = i + 15;
        String string8 = cursor2.isNull(i16) ? null : cursor2.getString(i16);
        int i17 = cursor2.getInt(i + 16);
        int i18 = cursor2.getInt(i + 17);
        int i19 = cursor2.getInt(i + 18);
        long j2 = cursor2.getLong(i + 19);
        int i20 = cursor2.getInt(i + 20);
        int i21 = i + 21;
        String string9 = cursor2.isNull(i21) ? null : cursor2.getString(i21);
        int i22 = i + 22;
        String string10 = cursor2.isNull(i22) ? null : cursor2.getString(i22);
        int i23 = i + 23;
        String string11 = cursor2.isNull(i23) ? null : cursor2.getString(i23);
        int i24 = i + 24;
        int i25 = i + 25;
        DBProject dBProject = new DBProject(valueOf, string, string2, string3, string4, string5, string6, string7, i10, j, i11, i12, i13, i14, i15, string8, i17, i18, i19, j2, i20, string9, string10, string11, cursor2.isNull(i24) ? null : cursor2.getString(i24), cursor2.isNull(i25) ? null : cursor2.getString(i25));
        return dBProject;
    }

    public void readEntity(Cursor cursor, DBProject dBProject, int i) {
        int i2 = i + 0;
        String str = null;
        dBProject.set_id(cursor.isNull(i2) ? null : Long.valueOf(cursor.getLong(i2)));
        int i3 = i + 1;
        dBProject.setUrl(cursor.isNull(i3) ? null : cursor.getString(i3));
        int i4 = i + 2;
        dBProject.setExport_url(cursor.isNull(i4) ? null : cursor.getString(i4));
        int i5 = i + 3;
        dBProject.setThumbnail(cursor.isNull(i5) ? null : cursor.getString(i5));
        int i6 = i + 4;
        dBProject.setCoverURL(cursor.isNull(i6) ? null : cursor.getString(i6));
        int i7 = i + 5;
        dBProject.setVersion(cursor.isNull(i7) ? null : cursor.getString(i7));
        int i8 = i + 6;
        dBProject.setCreate_time(cursor.isNull(i8) ? null : cursor.getString(i8));
        int i9 = i + 7;
        dBProject.setModify_time(cursor.isNull(i9) ? null : cursor.getString(i9));
        dBProject.setClip_count(cursor.getInt(i + 8));
        dBProject.setDuration(cursor.getLong(i + 9));
        dBProject.setDuration_limit(cursor.getInt(i + 10));
        dBProject.setStreamWidth(cursor.getInt(i + 11));
        dBProject.setStreamHeight(cursor.getInt(i + 12));
        dBProject.setIs_deleted(cursor.getInt(i + 13));
        dBProject.setIs_modified(cursor.getInt(i + 14));
        int i10 = i + 15;
        dBProject.setEntrance(cursor.isNull(i10) ? null : cursor.getString(i10));
        dBProject.setTodoCode(cursor.getInt(i + 16));
        dBProject.setEditCode(cursor.getInt(i + 17));
        dBProject.setCameraCode(cursor.getInt(i + 18));
        dBProject.setEffectID(cursor.getLong(i + 19));
        dBProject.setTheme_type(cursor.getInt(i + 20));
        int i11 = i + 21;
        dBProject.setVideo_template_info(cursor.isNull(i11) ? null : cursor.getString(i11));
        int i12 = i + 22;
        dBProject.setTitle(cursor.isNull(i12) ? null : cursor.getString(i12));
        int i13 = i + 23;
        dBProject.setVideo_desc(cursor.isNull(i13) ? null : cursor.getString(i13));
        int i14 = i + 24;
        dBProject.setActivityData(cursor.isNull(i14) ? null : cursor.getString(i14));
        int i15 = i + 25;
        if (!cursor.isNull(i15)) {
            str = cursor.getString(i15);
        }
        dBProject.setExtras(str);
    }

    public Long readKey(Cursor cursor, int i) {
        int i2 = i + 0;
        if (cursor.isNull(i2)) {
            return null;
        }
        return Long.valueOf(cursor.getLong(i2));
    }

    /* access modifiers changed from: protected */
    public final Long updateKeyAfterInsert(DBProject dBProject, long j) {
        dBProject.set_id(Long.valueOf(j));
        return Long.valueOf(j);
    }
}
