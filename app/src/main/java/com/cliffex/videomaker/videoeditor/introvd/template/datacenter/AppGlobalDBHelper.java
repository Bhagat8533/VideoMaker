package com.introvd.template.datacenter;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.introvd.template.datacenter.project.PrjTableUpgradeUtil;
import com.introvd.template.sdk.database.model.DBClipDao;
import com.introvd.template.sdk.database.model.DBClipRefDao;

class AppGlobalDBHelper extends SqliteOpenHelperWithDaemon {
    private static final int APP_DB_VERSION = 44;
    private static final String APP_GLOBAL_DB_NAME_EXTERNAL = "global.db";
    private final String TBL_NAME_CLIP = DBClipDao.TABLENAME;
    private final String TBL_NAME_CLIPREF = DBClipRefDao.TABLENAME;
    private final String TBL_NAME_COMMENT_SENSITIVE = "CommentSensitive";
    private final String TBL_NAME_LOCATION_INFO = "LocationInfo";
    private final String TBL_NAME_PROJECT = "Project";
    private final String TBL_NAME_RECOMMEND_APP = "AppRecommend";
    private final String TBL_NAME_RECOMMEND_USER_VIDEO = "RecommendUserVideo";
    private final String TBL_NAME_SEARCHED_VIDEOS = SocialConstDef.TBL_NAME_SEARCHED_VIDEOS;
    private final String TBL_NAME_VIDEO_SHOW = SocialConstDef.TBL_NAME_VIDEO_SHOW;
    private final String TBL_NAME_XY_IAP_INFO = "XY_IAP_Infos";
    private final String TBL_NAME_XY_REWARD_INFO = "XY_Reward_Infos";

    public AppGlobalDBHelper(Context context) {
        StringBuilder sb = new StringBuilder();
        sb.append("/data/data/");
        sb.append(context.getPackageName());
        sb.append("/database/");
        sb.append(APP_GLOBAL_DB_NAME_EXTERNAL);
        super(context, sb.toString(), null, 44);
    }

    private void onCreateAccountTable(SQLiteDatabase sQLiteDatabase) {
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE IF NOT EXISTS ");
        sb.append(SocialConstDef.TBL_NAME_SOCIAL_ACCOUNT);
        sb.append("( ");
        sb.append("uid");
        sb.append(" TEXT PRIMARY KEY,");
        sb.append("name");
        sb.append(" TEXT,");
        sb.append("type");
        sb.append(" INTEGER,");
        sb.append("path");
        sb.append(" TEXT ");
        sb.append(" );");
        ExecSQL(sQLiteDatabase, sb.toString());
    }

    private void onCreateActivityHotEventTable(SQLiteDatabase sQLiteDatabase) {
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE IF NOT EXISTS ");
        sb.append(SocialConstDef.TBL_NAME_ACTIVITY_HOTEVENT);
        sb.append("( ");
        sb.append("_id");
        sb.append(" INTEGER PRIMARY KEY AUTOINCREMENT, ");
        sb.append("orderNo");
        sb.append(" INTEGER, ");
        sb.append("eventTitle");
        sb.append(" TEXT, ");
        sb.append("videoCount");
        sb.append(" INTEGER, ");
        sb.append("activityID");
        sb.append(" TEXT ");
        sb.append(" );");
        ExecSQL(sQLiteDatabase, sb.toString());
    }

    private void onCreateActivityJoinDetailTable(SQLiteDatabase sQLiteDatabase) {
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE IF NOT EXISTS ");
        sb.append(SocialConstDef.TBL_NAME_ACTIVITY_JOIN_DETAIL);
        sb.append("( ");
        sb.append("_id");
        sb.append(" INTEGER PRIMARY KEY AUTOINCREMENT, ");
        sb.append("activityID");
        sb.append(" TEXT, ");
        sb.append("eventTitle");
        sb.append(" TEXT, ");
        sb.append(SocialConstDef.ACTIVITY_JOIN_SNSINFO);
        sb.append(" TEXT, ");
        sb.append(SocialConstDef.ACTIVITY_JOIN_TEMPLATES);
        sb.append(" TEXT, ");
        sb.append("todo_type");
        sb.append(" INTEGER, ");
        sb.append("todo_content");
        sb.append(" TEXT ");
        sb.append(" );");
        ExecSQL(sQLiteDatabase, sb.toString());
    }

    private void onCreateActivityListTable(SQLiteDatabase sQLiteDatabase) {
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE IF NOT EXISTS ");
        sb.append(SocialConstDef.TBL_NAME_ACTIVITY_LIST);
        sb.append("( ");
        sb.append("_id");
        sb.append(" INTEGER PRIMARY KEY AUTOINCREMENT, ");
        sb.append("activityType");
        sb.append(" INTEGER, ");
        sb.append("orderType");
        sb.append(" INTEGER, ");
        sb.append("activityID");
        sb.append(" TEXT, ");
        sb.append("title");
        sb.append(" TEXT, ");
        sb.append(SocialConstDef.ACTIVITY_LIST_THUMBNAILURL);
        sb.append(" TEXT, ");
        sb.append(SocialConstDef.ACTIVITY_LIST_BANNERURL);
        sb.append(" TEXT, ");
        sb.append(SocialConstDef.ACTIVITY_LIST_DESCTEXT);
        sb.append(" TEXT, ");
        sb.append(SocialConstDef.ACTIVITY_LIST_DESCURL);
        sb.append(" TEXT, ");
        sb.append(SocialConstDef.ACTIVITY_LIST_STARTTIME);
        sb.append(" TEXT, ");
        sb.append(SocialConstDef.ACTIVITY_LIST_ENDTIME);
        sb.append(" TEXT, ");
        sb.append(SocialConstDef.ACTIVITY_LIST_JOINCOUNT);
        sb.append(" INTEGER, ");
        sb.append("videoCount");
        sb.append(" INTEGER, ");
        sb.append(SocialConstDef.ACTIVITY_LIST_AWARDURL);
        sb.append(" TEXT, ");
        sb.append("flag");
        sb.append(" INTEGER, ");
        sb.append("todo_type");
        sb.append(" INTEGER DEFAULT 0, ");
        sb.append("todo_content");
        sb.append(" TEXT, ");
        sb.append(SocialConstDef.ACTIVITY_LIST_BANNER_TODO_TYPE);
        sb.append(" INTEGER DEFAULT 0, ");
        sb.append(SocialConstDef.ACTIVITY_LIST_BANNER_TODO_CONTENT);
        sb.append(" TEXT, ");
        sb.append(SocialConstDef.ACTIVITY_LIST_PRIZE_STATE);
        sb.append(" INTEGER DEFAULT 0, ");
        sb.append(SocialConstDef.ACTIVITY_LIST_TEMPLATE_GROUPCODE);
        sb.append(" TEXT, ");
        sb.append(SocialConstDef.ACTIVITY_LIST_EXTRA_JSON);
        sb.append(" TEXT, ");
        sb.append(SocialConstDef.ACTIVITY_LIST_INVISIABLE_FLAG);
        sb.append(" INTEGER DEFAULT 0 ");
        sb.append(" );");
        ExecSQL(sQLiteDatabase, sb.toString());
    }

    private void onCreateAppGeneralTable(SQLiteDatabase sQLiteDatabase) {
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE IF NOT EXISTS ");
        sb.append(SocialConstDef.TBL_NAME_GENERAL_APP);
        sb.append("( ");
        sb.append("key");
        sb.append(" TEXT PRIMARY KEY,");
        sb.append("value");
        sb.append(" TEXT ");
        sb.append(" );");
        ExecSQL(sQLiteDatabase, sb.toString());
    }

    private void onCreateBannerPageTable(SQLiteDatabase sQLiteDatabase) {
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE IF NOT EXISTS ");
        sb.append(SocialConstDef.TBL_NAME_BANNER_PAGE);
        sb.append("( ");
        sb.append("_id");
        sb.append(" TEXT PRIMARY KEY, ");
        sb.append("page_type");
        sb.append(" INTEGER, ");
        sb.append("orderNo");
        sb.append(" INTEGER, ");
        sb.append("content_type");
        sb.append(" INTEGER, ");
        sb.append("content_title");
        sb.append(" TEXT, ");
        sb.append(SocialConstDef.BANNER_PAGE_CONTENT_DESC);
        sb.append(" TEXT, ");
        sb.append("content_url");
        sb.append(" TEXT, ");
        sb.append("todo_type");
        sb.append(" INTEGER, ");
        sb.append("todo_content");
        sb.append(" TEXT, ");
        sb.append(SocialConstDef.BANNER_PAGE_DETAIL_MODULE);
        sb.append(" TEXT ");
        sb.append(" );");
        ExecSQL(sQLiteDatabase, sb.toString());
    }

    private void onCreateDynamicFeatureTable(SQLiteDatabase sQLiteDatabase) {
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE IF NOT EXISTS ");
        sb.append(SocialConstDef.TBL_NAME_DYNAMIC_FEATURE);
        sb.append("( ");
        sb.append("_id");
        sb.append(" INTEGER PRIMARY KEY AUTOINCREMENT, ");
        sb.append(SocialConstDef.DYNAMIC_FEATURE_RAW_ID);
        sb.append(" INTEGER, ");
        sb.append("type");
        sb.append(" INTEGER, ");
        sb.append("orderno");
        sb.append(" INTEGER, ");
        sb.append(SocialConstDef.DYNAMIC_FEATURE_OBJ);
        sb.append(" TEXT, ");
        sb.append("title");
        sb.append(" TEXT, ");
        sb.append(SocialConstDef.DYNAMIC_FEATURE_VIEWTYPE);
        sb.append(" INTEGER DEFAULT 1, ");
        sb.append("modelcode");
        sb.append(" INTEGER DEFAULT 0 ");
        sb.append(" );");
        ExecSQL(sQLiteDatabase, sb.toString());
    }

    private void onCreateGoodsInfoTable(SQLiteDatabase sQLiteDatabase) {
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE IF NOT EXISTS ");
        sb.append(SocialConstDef.TBL_NAME_XY_GOODS_ITEM_INFO);
        sb.append("( ");
        sb.append(SocialConstDef.XY_GOODS_ITEM_INFO_ID);
        sb.append(" TEXT PRIMARY KEY, ");
        sb.append("price");
        sb.append(" TEXT, ");
        sb.append("title");
        sb.append(" TEXT, ");
        sb.append("desc");
        sb.append(" TEXT, ");
        sb.append("type");
        sb.append(" TEXT, ");
        sb.append(SocialConstDef.XY_GOODS_ITEM_INFO_EXTRAINFO);
        sb.append(" TEXT ");
        sb.append(" );");
        ExecSQL(sQLiteDatabase, sb.toString());
    }

    private void onCreateMediaItem(SQLiteDatabase sQLiteDatabase) {
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE IF NOT EXISTS ");
        sb.append(SocialConstDef.TBL_NAME_MEDIA_ITEM);
        sb.append("( ");
        sb.append(SocialConstDef.MEDIA_ITEM_DATA);
        sb.append(" TEXT PRIMARY KEY,  ");
        sb.append("_id");
        sb.append(" LONG, ");
        sb.append(SocialConstDef.MEDIA_ITEM_MIME_TYPE);
        sb.append(" TEXT, ");
        sb.append("title");
        sb.append(" TEXT, ");
        sb.append(SocialConstDef.MEDIA_ITEM_ARTIST);
        sb.append(" TEXT, ");
        sb.append("duration");
        sb.append(" LONG, ");
        sb.append("width");
        sb.append(" INTEGER, ");
        sb.append("height");
        sb.append(" INTEGER, ");
        sb.append(SocialConstDef.MEDIA_ITEM_DATE_ADDED);
        sb.append(" LONG, ");
        sb.append(SocialConstDef.MEDIA_ITEM_DATE_MODIFIED);
        sb.append(" LONG, ");
        sb.append("flag");
        sb.append(" INTEGER DEFAULT 0, ");
        sb.append("from_type");
        sb.append(" INTEGER DEFAULT 0, ");
        sb.append("misc");
        sb.append(" TEXT ");
        sb.append(" );");
        ExecSQL(sQLiteDatabase, sb.toString());
    }

    private void onCreateMemorySharesTable(SQLiteDatabase sQLiteDatabase) {
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE IF NOT EXISTS ");
        sb.append(SocialConstDef.TBL_NAME_MEMORY_SHARES);
        sb.append("( ");
        sb.append("key");
        sb.append(" TEXT PRIMARY KEY,");
        sb.append("value");
        sb.append(" TEXT ");
        sb.append(" );");
        ExecSQL(sQLiteDatabase, sb.toString());
    }

    private void onCreatePopupWindow(SQLiteDatabase sQLiteDatabase) {
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE IF NOT EXISTS ");
        sb.append(SocialConstDef.TBL_NAME_POPUP_WINDOW_INFO);
        sb.append("( ");
        sb.append(SocialConstDef.POPUPWINDOW_ITEM_WINDOWID);
        sb.append(" INTEGER PRIMARY KEY, ");
        sb.append("starttime");
        sb.append(" TEXT, ");
        sb.append("expiretime");
        sb.append(" TEXT, ");
        sb.append("orderno");
        sb.append(" INTEGER, ");
        sb.append("modelcode");
        sb.append(" INTEGER, ");
        sb.append("type");
        sb.append(" INTEGER, ");
        sb.append(SocialConstDef.POPUPWINDOW_ITEM_EVENTTYPE);
        sb.append(" INTEGER, ");
        sb.append(SocialConstDef.POPUPWINDOW_ITEM_EVENTCNT);
        sb.append(" TEXT, ");
        sb.append("iconurl");
        sb.append(" TEXT, ");
        sb.append("title");
        sb.append(" TEXT, ");
        sb.append("description");
        sb.append(" TEXT, ");
        sb.append(SocialConstDef.POPUPWINDOW_ITEM_VIDEOURL);
        sb.append(" TEXT, ");
        sb.append(SocialConstDef.POPUPWINDOW_ITEM_DISPLAYSTATE);
        sb.append(" INTEGER, ");
        sb.append(SocialConstDef.POPUPWINDOW_ITEM_DISPLAY_COUNT);
        sb.append(" INTEGER, ");
        sb.append(SocialConstDef.POPUPWINDOW_ITEM_POP_DAY_TIME);
        sb.append(" TEXT, ");
        sb.append(SocialConstDef.POPUPWINDOW_ITEM_EXTENDINFO);
        sb.append(" TEXT ");
        sb.append(" );");
        ExecSQL(sQLiteDatabase, sb.toString());
    }

    private void onCreateProjectTable(SQLiteDatabase sQLiteDatabase) {
        ExecSQL(sQLiteDatabase, "CREATE TABLE Project( _id INTEGER PRIMARY KEY AUTOINCREMENT, title TEXT, url TEXT, export_url TEXT, clip_count INTEGER, duration LONG, gps_accuracy INTEGER, latitude DOUBLE, longitude DOUBLE, address TEXT, addressDetail TEXT, thumbnail TEXT, coverURL TEXT, version TEXT, create_time DATETIME, modify_time DATETIME, is_deleted INTEGER, streamWitth INTEGER,streamHeight INTEGER,effectID INTEGER,todoCode INTEGER,editCode INTEGER,cameraCode INTEGER,activityData TEXT,video_desc TEXT,extras TEXT,is_modified INTEGER, duration_limit INTEGER DEFAULT 0, entrance TEXT, video_template_info TEXT, theme_type INTEGER DEFAULT 0)");
    }

    private void onCreatePushTagTable(SQLiteDatabase sQLiteDatabase) {
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE IF NOT EXISTS ");
        sb.append(SocialConstDef.TBL_NAME_PUSH_TAG);
        sb.append("( ");
        sb.append("_id");
        sb.append(" INTEGER PRIMARY KEY AUTOINCREMENT, ");
        sb.append(SocialConstDef.PUSH_TAG_STATIC);
        sb.append(" TEXT, ");
        sb.append(SocialConstDef.PUSH_TAG_DYNAMIC);
        sb.append(" TEXT ");
        sb.append(" );");
        ExecSQL(sQLiteDatabase, sb.toString());
    }

    private void onCreateSearchHistoryTable(SQLiteDatabase sQLiteDatabase) {
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE IF NOT EXISTS ");
        sb.append(SocialConstDef.TBL_NAME_SEARCH_HISTORY);
        sb.append("( ");
        sb.append("type");
        sb.append(" INTEGER DEFAULT 0, ");
        sb.append(SocialConstDef.SEARCH_HISTORY_WORDS);
        sb.append(" TEXT, ");
        sb.append(SocialConstDef.SEARCH_HISTORY_UPDATETIME);
        sb.append(" LONG DEFAULT 0, ");
        sb.append(SocialConstDef.SEARCH_HISTORY_COUNT);
        sb.append(" INTEGER DEFAULT 0 ");
        sb.append(" );");
        ExecSQL(sQLiteDatabase, sb.toString());
    }

    private void onCreateSearchedUserTable(SQLiteDatabase sQLiteDatabase) {
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE IF NOT EXISTS ");
        sb.append(SocialConstDef.TBL_NAME_SEARCHED_USERS);
        sb.append("( ");
        sb.append("auid");
        sb.append(" TEXT PRIMARY KEY, ");
        sb.append("nickName");
        sb.append(" TEXT, ");
        sb.append(SocialConstDef.SEARCH_USER_AVATAR);
        sb.append(" TEXT, ");
        sb.append("gender");
        sb.append(" INTEGER, ");
        sb.append(SocialConstDef.SEARCH_USER_LEVEL);
        sb.append(" TEXT, ");
        sb.append("desc");
        sb.append(" TEXT, ");
        sb.append(SocialConstDef.SEARCH_USER_IS_FOLLOWED);
        sb.append(" INTEGER, ");
        sb.append("fansCount");
        sb.append(" INTEGER, ");
        sb.append("followCount");
        sb.append(" INTEGER ");
        sb.append(" );");
        ExecSQL(sQLiteDatabase, sb.toString());
    }

    private void onCreateSnsConfig(SQLiteDatabase sQLiteDatabase) {
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE IF NOT EXISTS ");
        sb.append(SocialConstDef.TBL_NAME_SNS_CONFIG);
        sb.append("( ");
        sb.append("orderno");
        sb.append(" INTEGER  DEFAULT 0, ");
        sb.append(SocialConstDef.SNSCONFIG_ITEM_COUNTRYCODE);
        sb.append(" TEXT, ");
        sb.append(SocialConstDef.SNSCONFIG_ITEM_SNSCODE);
        sb.append(" TEXT, ");
        sb.append(SocialConstDef.SNSCONFIG_ITEM_SNSNAME);
        sb.append(" TEXT, ");
        sb.append(SocialConstDef.SNSCONFIG_ITEM_SNSLOGO);
        sb.append(" TEXT, ");
        sb.append(SocialConstDef.SNSCONFIG_ITEM_ISINTENT);
        sb.append(" INTEGER DEFAULT 1, ");
        sb.append(SocialConstDef.SNSCONFIG_ITEM_INTENTPARAM);
        sb.append(" TEXT, ");
        sb.append("title");
        sb.append(" TEXT, ");
        sb.append("desc");
        sb.append(" TEXT, ");
        sb.append(SocialConstDef.SNSCONFIG_ITEM_ISMAIN);
        sb.append(" INTEGER DEFAULT 1, ");
        sb.append(SocialConstDef.SNSCONFIG_ITEM_PAGETYPE);
        sb.append(" INTEGER DEFAULT 1 ");
        sb.append(" );");
        ExecSQL(sQLiteDatabase, sb.toString());
    }

    private void onCreateSplash(SQLiteDatabase sQLiteDatabase) {
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE IF NOT EXISTS ");
        sb.append(SocialConstDef.TBL_NAME_SPLASH);
        sb.append("( ");
        sb.append("_id");
        sb.append(" TEXT PRIMARY KEY,  ");
        sb.append("lang");
        sb.append(" TEXT, ");
        sb.append("title");
        sb.append(" TEXT, ");
        sb.append("imgurl");
        sb.append(" TEXT, ");
        sb.append("expiretime");
        sb.append(" TEXT, ");
        sb.append(SocialConstDef.SPLASH_ITEM_PUBLISH_TIME);
        sb.append(" TEXT, ");
        sb.append(SocialConstDef.SPLASH_ITEM_STAY_TIME);
        sb.append(" TEXT, ");
        sb.append(SocialConstDef.SPLASH_ITEM_EVENTCODE);
        sb.append(" TEXT, ");
        sb.append(SocialConstDef.SPLASH_ITEM_EVENTPARAM);
        sb.append(" TEXT ");
        sb.append(" );");
        ExecSQL(sQLiteDatabase, sb.toString());
    }

    private void onCreateTopUserTable(SQLiteDatabase sQLiteDatabase) {
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE IF NOT EXISTS ");
        sb.append(SocialConstDef.TBL_NAME_TOP_USER);
        sb.append("( ");
        sb.append("auid");
        sb.append(" TEXT PRIMARY KEY, ");
        sb.append("nickName");
        sb.append(" TEXT, ");
        sb.append("followCount");
        sb.append(" INTEGER, ");
        sb.append("followFlag");
        sb.append(" INTEGER, ");
        sb.append("orderno");
        sb.append(" INTEGER, ");
        sb.append(SocialConstDef.TOP_USER_LIKECOUNT);
        sb.append(" INTEGER, ");
        sb.append("avatarUrl");
        sb.append(" TEXT, ");
        sb.append("videosJson");
        sb.append(" TEXT ");
        sb.append(" );");
        ExecSQL(sQLiteDatabase, sb.toString());
    }

    private void onCreateURLCacheTable(SQLiteDatabase sQLiteDatabase) {
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE IF NOT EXISTS ");
        sb.append(SocialConstDef.TBL_NAME_URLCACHE);
        sb.append("( ");
        sb.append("remote");
        sb.append(" TEXT PRIMARY KEY, ");
        sb.append("local");
        sb.append(" TEXT, ");
        sb.append("type");
        sb.append(" INTEGER, ");
        sb.append("userdata");
        sb.append(" TEXT, ");
        sb.append("time");
        sb.append(" DATETIME ");
        sb.append(")");
        ExecSQL(sQLiteDatabase, sb.toString());
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        onCreateAppGeneralTable(sQLiteDatabase);
        onCreateAccountTable(sQLiteDatabase);
        onCreateMemorySharesTable(sQLiteDatabase);
        onCreateBannerPageTable(sQLiteDatabase);
        onCreateSearchedUserTable(sQLiteDatabase);
        onCreateSearchHistoryTable(sQLiteDatabase);
        onCreateDynamicFeatureTable(sQLiteDatabase);
        onCreatePushTagTable(sQLiteDatabase);
        onCreateSnsConfig(sQLiteDatabase);
        onCreatePopupWindow(sQLiteDatabase);
        onCreateGoodsInfoTable(sQLiteDatabase);
        onCreateTopUserTable(sQLiteDatabase);
        onCreateSplash(sQLiteDatabase);
        onCreateURLCacheTable(sQLiteDatabase);
        onCreateMediaItem(sQLiteDatabase);
        onCreateActivityListTable(sQLiteDatabase);
        onCreateActivityHotEventTable(sQLiteDatabase);
        onCreateActivityJoinDetailTable(sQLiteDatabase);
    }

    public void onOpen(SQLiteDatabase sQLiteDatabase) {
        super.onOpen(sQLiteDatabase);
        if (!sQLiteDatabase.isReadOnly()) {
            ExecSQL(sQLiteDatabase, "DELETE FROM MemShares");
        }
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i < 2) {
            StringBuilder sb = new StringBuilder();
            sb.append("DROP TEMPORARY TABLE IF EXISTS ");
            sb.append(SocialConstDef.TBL_NAME_MEMORY_SHARES);
            ExecSQL(sQLiteDatabase, sb.toString());
            onCreateMemorySharesTable(sQLiteDatabase);
        }
        if (i < 3) {
            onCreateProjectTable(sQLiteDatabase);
        }
        if (i < 4) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("ALTER TABLE ");
            sb2.append("Project");
            sb2.append(" ADD ");
            sb2.append("coverURL");
            sb2.append(" TEXT;");
            ExecSQL(sQLiteDatabase, sb2.toString());
        }
        if (i < 5) {
            onCreateBannerPageTable(sQLiteDatabase);
            onCreateActivityListTable(sQLiteDatabase);
        }
        if (i < 6) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("ALTER TABLE ");
            sb3.append(SocialConstDef.TBL_NAME_ACTIVITY_LIST);
            sb3.append(" ADD ");
            sb3.append(SocialConstDef.ACTIVITY_LIST_PRIZE_STATE);
            sb3.append(" INTEGER DEFAULT 0;");
            ExecSQL(sQLiteDatabase, sb3.toString());
        }
        if (i < 7) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append("ALTER TABLE ");
            sb4.append("Project");
            sb4.append(" ADD ");
            sb4.append(SocialConstDef.PROJECT_DURATION_LIMIT);
            sb4.append(" INTEGER DEFAULT 0;");
            ExecSQL(sQLiteDatabase, sb4.toString());
        }
        if (i < 8) {
            onCreateSearchedUserTable(sQLiteDatabase);
        }
        if (i < 10) {
            onCreateSearchHistoryTable(sQLiteDatabase);
        }
        if (i < 12) {
            ExecSQL(sQLiteDatabase, "Drop Table SearchedUsers");
            onCreateSearchedUserTable(sQLiteDatabase);
        }
        if (i < 13) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("ALTER TABLE ");
            sb5.append(SocialConstDef.TBL_NAME_ACTIVITY_LIST);
            sb5.append(" ADD ");
            sb5.append(SocialConstDef.ACTIVITY_LIST_TEMPLATE_GROUPCODE);
            sb5.append(" TEXT;");
            ExecSQL(sQLiteDatabase, sb5.toString());
            StringBuilder sb6 = new StringBuilder();
            sb6.append("ALTER TABLE ");
            sb6.append(SocialConstDef.TBL_NAME_ACTIVITY_LIST);
            sb6.append(" ADD ");
            sb6.append(SocialConstDef.ACTIVITY_LIST_INVISIABLE_FLAG);
            sb6.append(" INTEGER DEFAULT 0;");
            ExecSQL(sQLiteDatabase, sb6.toString());
        }
        if (i < 14) {
            ExecSQL(sQLiteDatabase, "Drop Table BannerPage");
            onCreateBannerPageTable(sQLiteDatabase);
        }
        if (i < 15) {
            onCreateDynamicFeatureTable(sQLiteDatabase);
        }
        if (i < 16) {
            ExecSQL(sQLiteDatabase, "Drop Table DynamicFeature");
            onCreateDynamicFeatureTable(sQLiteDatabase);
        }
        if (i < 18) {
            StringBuilder sb7 = new StringBuilder();
            sb7.append("ALTER TABLE ");
            sb7.append("Project");
            sb7.append(" ADD ");
            sb7.append(SocialConstDef.PROJECT_ENTRANCE);
            sb7.append(" TEXT;");
            ExecSQL(sQLiteDatabase, sb7.toString());
        }
        if (i < 20) {
            StringBuilder sb8 = new StringBuilder();
            sb8.append("ALTER TABLE ");
            sb8.append(SocialConstDef.TBL_NAME_BANNER_PAGE);
            sb8.append(" ADD ");
            sb8.append(SocialConstDef.BANNER_PAGE_DETAIL_MODULE);
            sb8.append(" TEXT;");
            ExecSQL(sQLiteDatabase, sb8.toString());
        }
        if (i < 22) {
            StringBuilder sb9 = new StringBuilder();
            sb9.append("ALTER TABLE ");
            sb9.append(SocialConstDef.TBL_NAME_DYNAMIC_FEATURE);
            sb9.append(" ADD ");
            sb9.append("title");
            sb9.append(" TEXT;");
            ExecSQL(sQLiteDatabase, sb9.toString());
        }
        if (i < 23) {
            onCreatePushTagTable(sQLiteDatabase);
        }
        if (i < 24) {
            onCreateSnsConfig(sQLiteDatabase);
            onCreatePopupWindow(sQLiteDatabase);
        }
        if (i < 25) {
            StringBuilder sb10 = new StringBuilder();
            sb10.append("ALTER TABLE ");
            sb10.append(SocialConstDef.TBL_NAME_DYNAMIC_FEATURE);
            sb10.append(" ADD ");
            sb10.append("modelcode");
            sb10.append(" INTEGER DEFAULT 0;");
            ExecSQL(sQLiteDatabase, sb10.toString());
            StringBuilder sb11 = new StringBuilder();
            sb11.append("ALTER TABLE ");
            sb11.append(SocialConstDef.TBL_NAME_DYNAMIC_FEATURE);
            sb11.append(" ADD ");
            sb11.append(SocialConstDef.DYNAMIC_FEATURE_VIEWTYPE);
            sb11.append(" INTEGER DEFAULT 1;");
            ExecSQL(sQLiteDatabase, sb11.toString());
        }
        if (i < 26) {
            StringBuilder sb12 = new StringBuilder();
            sb12.append("ALTER TABLE ");
            sb12.append(SocialConstDef.TBL_NAME_ACTIVITY_LIST);
            sb12.append(" ADD ");
            sb12.append(SocialConstDef.ACTIVITY_LIST_EXTRA_JSON);
            sb12.append(" TEXT;");
            ExecSQL(sQLiteDatabase, sb12.toString());
        }
        if (i < 28) {
            StringBuilder sb13 = new StringBuilder();
            sb13.append("ALTER TABLE ");
            sb13.append(SocialConstDef.TBL_NAME_POPUP_WINDOW_INFO);
            sb13.append(" ADD ");
            sb13.append(SocialConstDef.POPUPWINDOW_ITEM_VIDEOURL);
            sb13.append(" TEXT;");
            ExecSQL(sQLiteDatabase, sb13.toString());
            StringBuilder sb14 = new StringBuilder();
            sb14.append("ALTER TABLE ");
            sb14.append(SocialConstDef.TBL_NAME_POPUP_WINDOW_INFO);
            sb14.append(" ADD ");
            sb14.append(SocialConstDef.POPUPWINDOW_ITEM_EXTENDINFO);
            sb14.append(" TEXT;");
            ExecSQL(sQLiteDatabase, sb14.toString());
            onCreateGoodsInfoTable(sQLiteDatabase);
        }
        if (i < 29) {
            onCreateTopUserTable(sQLiteDatabase);
        }
        if (i < 32) {
            StringBuilder sb15 = new StringBuilder();
            sb15.append("ALTER TABLE ");
            sb15.append(SocialConstDef.TBL_NAME_SNS_CONFIG);
            sb15.append(" ADD ");
            sb15.append(SocialConstDef.SNSCONFIG_ITEM_ISMAIN);
            sb15.append(" INTEGER DEFAULT 1;");
            ExecSQL(sQLiteDatabase, sb15.toString());
        }
        if (i < 33) {
            StringBuilder sb16 = new StringBuilder();
            sb16.append("ALTER TABLE ");
            sb16.append(SocialConstDef.TBL_NAME_BANNER_PAGE);
            sb16.append(" ADD ");
            sb16.append(SocialConstDef.BANNER_PAGE_CONTENT_DESC);
            sb16.append(" TEXT;");
            ExecSQL(sQLiteDatabase, sb16.toString());
        }
        if (i < 34) {
            StringBuilder sb17 = new StringBuilder();
            sb17.append("ALTER TABLE ");
            sb17.append(SocialConstDef.TBL_NAME_XY_GOODS_ITEM_INFO);
            sb17.append(" ADD ");
            sb17.append("type");
            sb17.append(" TEXT;");
            ExecSQL(sQLiteDatabase, sb17.toString());
            StringBuilder sb18 = new StringBuilder();
            sb18.append("ALTER TABLE ");
            sb18.append(SocialConstDef.TBL_NAME_XY_GOODS_ITEM_INFO);
            sb18.append(" ADD ");
            sb18.append(SocialConstDef.XY_GOODS_ITEM_INFO_EXTRAINFO);
            sb18.append(" TEXT;");
            ExecSQL(sQLiteDatabase, sb18.toString());
        }
        if (i < 35) {
            StringBuilder sb19 = new StringBuilder();
            sb19.append("ALTER TABLE ");
            sb19.append("Project");
            sb19.append(" ADD ");
            sb19.append(SocialConstDef.PROJECT_VIDEO_TEMPLATE_INFO);
            sb19.append(" TEXT;");
            ExecSQL(sQLiteDatabase, sb19.toString());
        }
        if (i < 36) {
            ExecSQL(sQLiteDatabase, "DROP TABLE IF EXISTS VideoShow");
            ExecSQL(sQLiteDatabase, "DROP TABLE IF EXISTS CommentSensitive");
            ExecSQL(sQLiteDatabase, "DROP TABLE IF EXISTS AppRecommend");
            ExecSQL(sQLiteDatabase, "DROP TABLE IF EXISTS XY_IAP_Infos");
            ExecSQL(sQLiteDatabase, "DROP TABLE IF EXISTS LocationInfo");
            ExecSQL(sQLiteDatabase, "DROP TABLE IF EXISTS XY_Reward_Infos");
            ExecSQL(sQLiteDatabase, "DROP TABLE IF EXISTS RecommendUserVideo");
            ExecSQL(sQLiteDatabase, "DROP TABLE IF EXISTS SearchedVideos");
            onCreateActivityHotEventTable(sQLiteDatabase);
            onCreateActivityJoinDetailTable(sQLiteDatabase);
            onCreateURLCacheTable(sQLiteDatabase);
            onCreateSplash(sQLiteDatabase);
            onCreateMediaItem(sQLiteDatabase);
        }
        if (i < 38) {
            StringBuilder sb20 = new StringBuilder();
            sb20.append("ALTER TABLE ");
            sb20.append(SocialConstDef.TBL_NAME_DYNAMIC_FEATURE);
            sb20.append(" ADD ");
            sb20.append(SocialConstDef.DYNAMIC_FEATURE_RAW_ID);
            sb20.append(" INTEGER DEFAULT 0;");
            ExecSQL(sQLiteDatabase, sb20.toString());
        }
        if (i < 39) {
            StringBuilder sb21 = new StringBuilder();
            sb21.append("ALTER TABLE ");
            sb21.append("Project");
            sb21.append(" ADD ");
            sb21.append(SocialConstDef.PROJECT_THEME_TYPE);
            sb21.append(" INTEGER DEFAULT 0;");
            ExecSQL(sQLiteDatabase, sb21.toString());
        }
        if (i < 40) {
            StringBuilder sb22 = new StringBuilder();
            sb22.append("UPDATE ");
            sb22.append("Project");
            sb22.append(" SET  ");
            sb22.append(SocialConstDef.PROJECT_THEME_TYPE);
            sb22.append(" = 2 ");
            sb22.append(" WHERE ");
            sb22.append(SocialConstDef.PROJECT_THEME_TYPE);
            sb22.append(" = 1;");
            ExecSQL(sQLiteDatabase, sb22.toString());
        }
        if (i < 41) {
            StringBuilder sb23 = new StringBuilder();
            sb23.append("ALTER TABLE ");
            sb23.append(SocialConstDef.TBL_NAME_POPUP_WINDOW_INFO);
            sb23.append(" ADD ");
            sb23.append(SocialConstDef.POPUPWINDOW_ITEM_DISPLAYSTATE);
            sb23.append(" INTEGER DEFAULT 0;");
            ExecSQL(sQLiteDatabase, sb23.toString());
        }
        if (i < 42) {
            StringBuilder sb24 = new StringBuilder();
            sb24.append("ALTER TABLE ");
            sb24.append(SocialConstDef.TBL_NAME_POPUP_WINDOW_INFO);
            sb24.append(" ADD ");
            sb24.append(SocialConstDef.POPUPWINDOW_ITEM_POP_DAY_TIME);
            sb24.append(" TEXT ;");
            ExecSQL(sQLiteDatabase, sb24.toString());
        }
        if (i < 43) {
            ExecSQL(sQLiteDatabase, "DROP TABLE IF EXISTS Clip");
            ExecSQL(sQLiteDatabase, "DROP TABLE IF EXISTS ClipRef");
            PrjTableUpgradeUtil.handleProjectMove(sQLiteDatabase);
            ExecSQL(sQLiteDatabase, "DROP TABLE IF EXISTS Project");
        }
        if (i < 44) {
            StringBuilder sb25 = new StringBuilder();
            sb25.append("ALTER TABLE ");
            sb25.append(SocialConstDef.TBL_NAME_POPUP_WINDOW_INFO);
            sb25.append(" ADD ");
            sb25.append(SocialConstDef.POPUPWINDOW_ITEM_DISPLAY_COUNT);
            sb25.append(" TEXT ;");
            ExecSQL(sQLiteDatabase, sb25.toString());
        }
    }
}
