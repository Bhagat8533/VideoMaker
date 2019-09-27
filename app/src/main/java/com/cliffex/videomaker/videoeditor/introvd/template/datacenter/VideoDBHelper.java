package com.introvd.template.datacenter;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.introvd.template.router.editor.EditorRouter;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public class VideoDBHelper extends SqliteOpenHelperWithDaemon {
    private static final String APP_VIDEO_DB_NAME_EXTERNAL = "xy_video.db";
    private static final int VIDEO_DB_VERSION = 3;

    public VideoDBHelper(Context context) {
        super(context, APP_VIDEO_DB_NAME_EXTERNAL, null, 3);
    }

    private void onCreateRefTblOnVideoCard(SQLiteDatabase sQLiteDatabase, String str, Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE IF NOT EXISTS ");
        sb.append(str);
        sb.append("( ");
        sb.append("_id");
        sb.append(" INTEGER PRIMARY KEY AUTOINCREMENT, ");
        sb.append(SocialConstDef.VIDEO_REQUEST_CALLER);
        sb.append(" TEXT not null, ");
        sb.append(SocialConstDef.VIDEO_REQUEST_TIME);
        sb.append(" long default 0, ");
        sb.append("puid");
        sb.append(" TEXT not null, ");
        sb.append("pver");
        sb.append(" TEXT not null, ");
        if (map != null && map.size() > 0) {
            for (String str2 : map.keySet()) {
                sb.append(str2);
                sb.append(" ");
                sb.append((String) map.get(str2));
                sb.append(" ");
            }
        }
        sb.append(" UNIQUE(");
        sb.append(SocialConstDef.VIDEO_REQUEST_CALLER);
        sb.append(EditorRouter.KEY_TOOL_LIST_ORDER_SPLIT_OP);
        sb.append("puid");
        sb.append(EditorRouter.KEY_TOOL_LIST_ORDER_SPLIT_OP);
        sb.append("pver");
        sb.append(")");
        sb.append(" );");
        ExecSQL(sQLiteDatabase, sb.toString());
    }

    private void onCreateUserVideosTable(SQLiteDatabase sQLiteDatabase) {
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE IF NOT EXISTS ");
        sb.append(SocialConstDef.TBL_NAME_USERVIDEOS);
        sb.append("( ");
        sb.append("unionPrimary");
        sb.append(" TEXT PRIMARY KEY, ");
        sb.append("owner");
        sb.append(" TEXT, ");
        sb.append("puid");
        sb.append(" TEXT, ");
        sb.append("pver");
        sb.append(" TEXT, ");
        sb.append(SocialConstDef.USERVIDEOS_VIEW_PERMS);
        sb.append(" INTEGER DEFAULT 0, ");
        sb.append("title");
        sb.append(" TEXT, ");
        sb.append("vdesc");
        sb.append(" TEXT, ");
        sb.append("duration");
        sb.append(" TEXT, ");
        sb.append("width");
        sb.append(" INTEGER DEFAULT 0, ");
        sb.append("height");
        sb.append(" INTEGER DEFAULT 0, ");
        sb.append("coverURL");
        sb.append(" TEXT, ");
        sb.append("mp4URL");
        sb.append(" TEXT, ");
        sb.append("viewURL");
        sb.append(" TEXT, ");
        sb.append("publishTime");
        sb.append(" TEXT, ");
        sb.append("createTime");
        sb.append(" TEXT, ");
        sb.append("plays");
        sb.append(" INTEGER DEFAULT 0, ");
        sb.append("likes");
        sb.append(" INTEGER DEFAULT 0, ");
        sb.append("forwards");
        sb.append(" INTEGER DEFAULT 0, ");
        sb.append("addrbrief");
        sb.append(" TEXT, ");
        sb.append("addrdetail");
        sb.append(" TEXT, ");
        sb.append("longtitude");
        sb.append(" TEXT, ");
        sb.append("latitude");
        sb.append(" TEXT, ");
        sb.append(SocialConstDef.USERVIDEOS_MAP_PERMS);
        sb.append(" INTEGER DEFAULT 0, ");
        sb.append("activityUID");
        sb.append(" TEXT, ");
        sb.append("recommend");
        sb.append(" INTEGER DEFAULT 0, ");
        sb.append("comments");
        sb.append(" INTEGER DEFAULT 0, ");
        sb.append("comments_json");
        sb.append(" TEXT, ");
        sb.append("downFlag");
        sb.append(" INTEGER DEFAULT 0, ");
        sb.append("s_coverURL");
        sb.append(" TEXT, ");
        sb.append("videotag");
        sb.append(" TEXT, ");
        sb.append("referredUsers");
        sb.append(" TEXT, ");
        sb.append("videoDownloadInfoList");
        sb.append(" TEXT ");
        sb.append(" );");
        ExecSQL(sQLiteDatabase, sb.toString());
    }

    private void onCreateUsersVideosNew(SQLiteDatabase sQLiteDatabase) {
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE IF NOT EXISTS ");
        sb.append(SocialConstDef.TBL_NAME_USERS_VIDEOS);
        sb.append("( ");
        sb.append("_id");
        sb.append(" INTEGER PRIMARY KEY AUTOINCREMENT, ");
        sb.append(SocialConstDef.VIDEO_REQUEST_CALLER);
        sb.append(" TEXT not null, ");
        sb.append(SocialConstDef.VIDEO_REQUEST_TIME);
        sb.append(" long default 0, ");
        sb.append("puid");
        sb.append(" TEXT not null, ");
        sb.append("pver");
        sb.append(" TEXT not null, ");
        sb.append("recommend");
        sb.append(" INTEGER, ");
        sb.append(SocialConstDef.USERS_VIDEOS_FOLLOWED);
        sb.append(" INTEGER DEFAULT 0, ");
        sb.append("privacy");
        sb.append(" INTEGER, ");
        sb.append(SocialConstDef.USERS_VIDEOS_ISHOT);
        sb.append(" INTEGER, ");
        sb.append(" UNIQUE(");
        sb.append(SocialConstDef.VIDEO_REQUEST_CALLER);
        sb.append(EditorRouter.KEY_TOOL_LIST_ORDER_SPLIT_OP);
        sb.append("puid");
        sb.append(EditorRouter.KEY_TOOL_LIST_ORDER_SPLIT_OP);
        sb.append("pver");
        sb.append(EditorRouter.KEY_TOOL_LIST_ORDER_SPLIT_OP);
        sb.append(SocialConstDef.USERS_VIDEOS_ISHOT);
        sb.append(")");
        sb.append(" );");
        ExecSQL(sQLiteDatabase, sb.toString());
    }

    private void onCreateVideoCardTable(SQLiteDatabase sQLiteDatabase) {
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE IF NOT EXISTS ");
        sb.append(SocialConstDef.TBL_NAME_VIDEO_CARD);
        sb.append("( ");
        sb.append("auid");
        sb.append(" TEXT NOT NULL, ");
        sb.append("puid");
        sb.append(" TEXT NOT NULL, ");
        sb.append("pver");
        sb.append(" TEXT NOT NULL, ");
        sb.append(SocialConstDef.VIDEO_CARD_PERMS);
        sb.append(" INTEGER DEFAULT 0, ");
        sb.append("title");
        sb.append(" TEXT, ");
        sb.append("vdesc");
        sb.append(" TEXT, ");
        sb.append("duration");
        sb.append(" TEXT, ");
        sb.append("width");
        sb.append(" INTEGER DEFAULT 0, ");
        sb.append("height");
        sb.append(" INTEGER DEFAULT 0, ");
        sb.append("coverURL");
        sb.append(" TEXT, ");
        sb.append("mp4URL");
        sb.append(" TEXT, ");
        sb.append("viewURL");
        sb.append(" TEXT, ");
        sb.append("publishTime");
        sb.append(" TEXT, ");
        sb.append("createTime");
        sb.append(" TEXT, ");
        sb.append("plays");
        sb.append(" INTEGER DEFAULT 0, ");
        sb.append("likes");
        sb.append(" INTEGER DEFAULT 0, ");
        sb.append("forwards");
        sb.append(" INTEGER DEFAULT 0, ");
        sb.append("comments");
        sb.append(" INTEGER DEFAULT 0, ");
        sb.append(SocialConstDef.VIDEO_CARD_MAP_TYPE);
        sb.append(" INTEGER DEFAULT 0, ");
        sb.append(SocialConstDef.VIDEO_CARD_GPS_ACCURACY);
        sb.append(" INTEGER DEFAULT 0, ");
        sb.append("addrbrief");
        sb.append(" TEXT, ");
        sb.append("addrdetail");
        sb.append(" TEXT, ");
        sb.append("longtitude");
        sb.append(" TEXT, ");
        sb.append("latitude");
        sb.append(" TEXT, ");
        sb.append("activityUID");
        sb.append(" TEXT, ");
        sb.append("nickname");
        sb.append(" TEXT, ");
        sb.append("avatar");
        sb.append(" TEXT, ");
        sb.append("level");
        sb.append(" INTEGER DEFAULT 0, ");
        sb.append("s_coverURL");
        sb.append(" TEXT, ");
        sb.append("comments_json");
        sb.append(" TEXT, ");
        sb.append("videotag");
        sb.append(" TEXT, ");
        sb.append(SocialConstDef.VIDEO_CARD_FOLLOWSTATE);
        sb.append(" INTEGER, ");
        sb.append("updatetime");
        sb.append(" LONG DEFAULT 0, ");
        sb.append(SocialConstDef.VIDEO_CARD_AUTHENTICATION);
        sb.append(" TEXT, ");
        sb.append(SocialConstDef.VIDEO_CARD_EXCELLENTCREATOR);
        sb.append(" TEXT, ");
        sb.append(SocialConstDef.VIDEO_CARD_LIVEROOMID);
        sb.append(" TEXT, ");
        sb.append(SocialConstDef.VIDEO_CARD_LIVEWATCHCOUNT);
        sb.append(" INTEGER DEFAULT 0, ");
        sb.append("referredUsers");
        sb.append(" TEXT, ");
        sb.append("videoDownloadInfoList");
        sb.append(" TEXT, ");
        sb.append(SocialConstDef.VIDEO_CARD_VIDEOSTATISTICSINFO);
        sb.append(" TEXT, ");
        sb.append(" UNIQUE(");
        sb.append("auid");
        sb.append(EditorRouter.KEY_TOOL_LIST_ORDER_SPLIT_OP);
        sb.append("puid");
        sb.append(EditorRouter.KEY_TOOL_LIST_ORDER_SPLIT_OP);
        sb.append("pver");
        sb.append(")");
        sb.append(" );");
        ExecSQL(sQLiteDatabase, sb.toString());
    }

    private void onCreateVideoCardsNewAndRef(SQLiteDatabase sQLiteDatabase) {
        HashMap hashMap = new HashMap();
        hashMap.clear();
        hashMap.put("orderType", " INTEGER, ");
        hashMap.put("activityType", " INTEGER, ");
        hashMap.put("activityID", " TEXT, ");
        hashMap.put(SocialConstDef.ACTIVITY_VIDEOLIST_ORDERNO, " INTEGER, ");
        hashMap.put("flag", " INTEGER, ");
        hashMap.put(SocialConstDef.ACTIVITY_VIDEOLIST_TOP_FLAG, " INTEGER DEFAULT 0, ");
        hashMap.put(SocialConstDef.ACTIVITY_VIDEOLIST_LABEL, " TEXT, ");
        hashMap.put("traceId", " TEXT, ");
        onCreateRefTblOnVideoCard(sQLiteDatabase, SocialConstDef.TBL_NAME_ACTIVITY_VIDEOLIST, hashMap);
        onCreateViewOnVideoCard(sQLiteDatabase, SocialConstDef.TBL_NAME_ACTIVITY_VIDEOLIST, SocialConstDef.VIEW_NAME_ACTIVITY_VIDEOLIST);
        hashMap.clear();
        hashMap.put("recommend", " INTEGER, ");
        hashMap.put("fans", " INTEGER DEFAULT 0, ");
        hashMap.put("follows", " INTEGER DEFAULT 0, ");
        hashMap.put("followFlag", " INTEGER DEFAULT 0, ");
        onCreateRefTblOnVideoCard(sQLiteDatabase, SocialConstDef.TBL_NAME_VIDEO_DETAIL, hashMap);
        onCreateViewOnVideoCard(sQLiteDatabase, SocialConstDef.TBL_NAME_VIDEO_DETAIL, SocialConstDef.VIEW_NAME_VIDEO_DETAIL);
        onCreateViewOnVideoCard(sQLiteDatabase, SocialConstDef.TBL_NAME_USERS_VIDEOS, SocialConstDef.VIEW_NAME_USERS_VIDEOS);
        onCreateViewOnVideoCard(sQLiteDatabase, SocialConstDef.TBL_NAME_VIDEO_SHOW, SocialConstDef.VIEW_NAME_VIDEO_SHOW);
        hashMap.clear();
        hashMap.put("orderno", " INTEGER, ");
        hashMap.put(SocialConstDef.FOLLOWED_VIDEO_RECOMMENDFLAG, " INTEGER, ");
        hashMap.put(SocialConstDef.FOLLOWED_VIDEO_RECOMMENDREASON, " TEXT, ");
        hashMap.put(SocialConstDef.VIDEO_TRACEID, " TEXT, ");
        onCreateRefTblOnVideoCard(sQLiteDatabase, SocialConstDef.TBL_NAME_FOLLOWED_VIDEO, hashMap);
        onCreateViewOnVideoCard(sQLiteDatabase, SocialConstDef.TBL_NAME_FOLLOWED_VIDEO, SocialConstDef.VIEW_NAME_FOLLOWED_VIDEO);
        hashMap.clear();
        hashMap.put(SocialConstDef.SEARCH_VIDEO_KEY_WORDS, " TEXT, ");
        hashMap.put(SocialConstDef.VIDEO_TRACEID, " TEXT, ");
        onCreateRefTblOnVideoCard(sQLiteDatabase, SocialConstDef.TBL_NAME_SEARCHED_VIDEOS, hashMap);
        onCreateViewOnVideoCard(sQLiteDatabase, SocialConstDef.TBL_NAME_SEARCHED_VIDEOS, SocialConstDef.VIEW_NAME_SEARCHED_VIDEOS);
        hashMap.clear();
        hashMap.put(SocialConstDef.VIDEO_LBS_VDISTANCE, " TEXT, ");
        onCreateRefTblOnVideoCard(sQLiteDatabase, SocialConstDef.TBL_NAME_LBS_VIDEOS, hashMap);
        onCreateViewOnVideoCard(sQLiteDatabase, SocialConstDef.TBL_NAME_LBS_VIDEOS, SocialConstDef.VIEW_NAME_LBS_VIDEOS);
    }

    private void onCreateVideoShowNew(SQLiteDatabase sQLiteDatabase) {
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE IF NOT EXISTS ");
        sb.append(SocialConstDef.TBL_NAME_VIDEO_SHOW);
        sb.append("( ");
        sb.append("_id");
        sb.append(" INTEGER PRIMARY KEY AUTOINCREMENT, ");
        sb.append(SocialConstDef.VIDEO_REQUEST_CALLER);
        sb.append(" TEXT not null, ");
        sb.append(SocialConstDef.VIDEO_REQUEST_TIME);
        sb.append(" long default 0, ");
        sb.append("puid");
        sb.append(" TEXT not null, ");
        sb.append("pver");
        sb.append(" TEXT not null, ");
        sb.append("ordertype");
        sb.append(" INTEGER, ");
        sb.append(SocialConstDef.VIDEO_TRACEID);
        sb.append(" TEXT, ");
        sb.append("orderno");
        sb.append(" INTEGER DEFAULT 0 ");
        sb.append(" );");
        ExecSQL(sQLiteDatabase, sb.toString());
    }

    private void onCreateViewOnVideoCard(SQLiteDatabase sQLiteDatabase, String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append("create view IF NOT EXISTS ");
        sb.append(str2);
        sb.append(" as select ");
        sb.append(SocialConstDef.TBL_NAME_VIDEO_CARD);
        sb.append(".*, ");
        sb.append(str);
        sb.append(".* from ");
        sb.append(str);
        sb.append(" left join ");
        sb.append(SocialConstDef.TBL_NAME_VIDEO_CARD);
        sb.append(" where ");
        sb.append(SocialConstDef.TBL_NAME_VIDEO_CARD);
        sb.append(".puid = ");
        sb.append(str);
        sb.append(".puid and ");
        sb.append(SocialConstDef.TBL_NAME_VIDEO_CARD);
        sb.append(".pver = ");
        sb.append(str);
        sb.append(".pver");
        sb.append(" order by ");
        sb.append(str);
        sb.append(".");
        sb.append("_id");
        ExecSQL(sQLiteDatabase, sb.toString());
    }

    public /* bridge */ /* synthetic */ void add(WeakReference weakReference) {
        super.add(weakReference);
    }

    public /* bridge */ /* synthetic */ void close() {
        super.close();
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        onCreateUserVideosTable(sQLiteDatabase);
        onCreateVideoShowNew(sQLiteDatabase);
        onCreateVideoCardTable(sQLiteDatabase);
        onCreateUsersVideosNew(sQLiteDatabase);
        onCreateVideoCardsNewAndRef(sQLiteDatabase);
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i < 2) {
            ExecSQL(sQLiteDatabase, "ALTER TABLE ActivityVideo ADD lable TEXT;");
        }
        if (i < 3) {
            ExecSQL(sQLiteDatabase, "ALTER TABLE ActivityVideo ADD traceId TEXT;");
        }
    }

    public /* bridge */ /* synthetic */ void remove(WeakReference weakReference) {
        super.remove(weakReference);
    }
}
