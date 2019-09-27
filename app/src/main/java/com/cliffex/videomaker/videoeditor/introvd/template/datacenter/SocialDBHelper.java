package com.introvd.template.datacenter;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.introvd.template.datacenter.social.PublishTaskTable;
import com.introvd.template.router.editor.EditorRouter;
import com.introvd.template.sdk.database.model.DBClipDao;
import com.introvd.template.sdk.database.model.DBClipRefDao;
import java.util.UUID;

class SocialDBHelper extends SqliteOpenHelperWithDaemon {
    private static final int APP_DB_VERSION = 97;
    private static final String UNION_KEY_USER_GUID = "UserGUID";
    private final String TBL_NAME_ACTIVITY_PAGE = "ActivityPage";
    private final String TBL_NAME_ACTIVITY_VIDEOLIST = SocialConstDef.TBL_NAME_ACTIVITY_VIDEOLIST;
    private final String TBL_NAME_ACTIVITY_VIDEOLIST_NEW = "ActivityVideoNew";
    private final String TBL_NAME_CLIP = DBClipDao.TABLENAME;
    private final String TBL_NAME_CLIPREF = DBClipRefDao.TABLENAME;
    private final String TBL_NAME_COMMENT = "Comment";
    private final String TBL_NAME_FOLLOWED_VIDEO = SocialConstDef.TBL_NAME_FOLLOWED_VIDEO;
    private final String TBL_NAME_FOLLOWED_VIDEO_NEW = "FollowedVideoNew";
    private final String TBL_NAME_LBS_VIDEOS_NEW = "LBSVideosNew";
    private final String TBL_NAME_LIKED_VIDEO = "LikedVideo";
    private final String TBL_NAME_LIKED_VIDEO_NEW = "LikedVideoNew";
    private final String TBL_NAME_MAIN_PAGE = "MainPage";
    private final String TBL_NAME_MUSIC_ADDED_HISTORY = "MusicAddedHistory";
    private final String TBL_NAME_ONLINE_TASK = "OnlineTask";
    private final String TBL_NAME_PEOPLE = "People";
    private final String TBL_NAME_PROJECT = "Project";
    private final String TBL_NAME_SEARCHED_VIDEOS_NEW = "SearchedVideosNew";
    private final String TBL_NAME_TEMPLATE_DOWNLOAD = "TemplateDownload";
    private final String TBL_NAME_TEMPLATE_FAVORITE = "TemplateFavorite";
    private final String TBL_NAME_TEMPLATE_LOCK_INFO = "TemplateLockInfo";
    private final String TBL_NAME_TEMPLATE_SCENE_DEMO = "TemplateSceneDemo";
    private final String TBL_NAME_THUMBNAIL = "Thumbnail";
    private final String TBL_NAME_UPLOAD = "Upload";
    private final String TBL_NAME_USER = "User";
    private final String TBL_NAME_USERS_VIDEOS = SocialConstDef.TBL_NAME_USERS_VIDEOS;
    private final String TBL_NAME_USERS_VIDEOS_NEW = "UsersVideosNew";
    private final String TBL_NAME_VIDEO = "Video";
    private final String TBL_NAME_VIDEO_DETAIL = SocialConstDef.TBL_NAME_VIDEO_DETAIL;
    private final String TBL_NAME_VIDEO_DETAIL_NEW = "VideoDetailNew";
    private final String TBL_NAME_VIDEO_REVIEWS = "VideoReviews";
    private final String TBL_NAME_VIDEO_SHOW_NEW = "VideoShowNew";
    private final String VIEW_NAME_LIKED_VIDEO = "LikedVideoView";
    private String mUserUUID = "";

    public SocialDBHelper(Context context, String str) {
        super(context, str, null, 97);
        makeUserUUID(context);
    }

    private void makeUserUUID(Context context) {
        ContentResolver contentResolver = context.getContentResolver();
        ContentResolver contentResolver2 = contentResolver;
        Cursor query = contentResolver2.query(SocialConstDef.getTableUri(SocialConstDef.TBL_NAME_GENERAL_APP), new String[]{"value"}, "key = ?", new String[]{UNION_KEY_USER_GUID}, null);
        if (query != null) {
            if (query.moveToFirst()) {
                this.mUserUUID = query.getString(0);
            }
            query.close();
        }
        if (TextUtils.isEmpty(this.mUserUUID)) {
            this.mUserUUID = UUID.randomUUID().toString();
            ContentValues contentValues = new ContentValues();
            contentValues.put("value", this.mUserUUID);
            contentValues.put("key", UNION_KEY_USER_GUID);
            contentResolver.insert(SocialConstDef.getTableUri(SocialConstDef.TBL_NAME_GENERAL_APP), contentValues);
        }
    }

    private void onCreateBlackList(SQLiteDatabase sQLiteDatabase) {
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE IF NOT EXISTS ");
        sb.append(SocialConstDef.TBL_NAME_BLACK_LIST);
        sb.append("( ");
        sb.append("auid");
        sb.append(" TEXT PRIMARY KEY, ");
        sb.append("nikename");
        sb.append(" TEXT, ");
        sb.append("logo");
        sb.append(" TEXT, ");
        sb.append("gender");
        sb.append(" INTEGER DEFAULT 2, ");
        sb.append("level");
        sb.append(" INTEGER, ");
        sb.append("desc");
        sb.append(" TEXT, ");
        sb.append("updateflag");
        sb.append(" INTEGER ");
        sb.append(" );");
        ExecSQL(sQLiteDatabase, sb.toString());
    }

    private void onCreateChatContact(SQLiteDatabase sQLiteDatabase) {
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE IF NOT EXISTS ");
        sb.append(SocialConstDef.TBL_NAME_CHAT_CONTACT);
        sb.append("( ");
        sb.append(SocialConstDef.CHAT_CONTACT_USERID);
        sb.append(" TEXT PRIMARY KEY, ");
        sb.append("nickname");
        sb.append(" TEXT, ");
        sb.append("avatar");
        sb.append(" TEXT, ");
        sb.append("level");
        sb.append(" INTEGER, ");
        sb.append("updatetime");
        sb.append(" LONG, ");
        sb.append("updateflag");
        sb.append(" INTEGER, ");
        sb.append(SocialConstDef.CHAT_CONTACT_FOLLOW_FLAG);
        sb.append(" INTEGER, ");
        sb.append("extras");
        sb.append(" TEXT, ");
        sb.append("flag");
        sb.append(" INTEGER DEFAULT 0 ");
        sb.append(" );");
        ExecSQL(sQLiteDatabase, sb.toString());
    }

    private void onCreateCustomizedUserTable(SQLiteDatabase sQLiteDatabase) {
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE IF NOT EXISTS ");
        sb.append(SocialConstDef.TBL_NAME_CUSTOMIZED_USER);
        sb.append("( ");
        sb.append("auid");
        sb.append(" TEXT PRIMARY KEY, ");
        sb.append("nickName");
        sb.append(" TEXT, ");
        sb.append("avatarUrl");
        sb.append(" TEXT, ");
        sb.append("followCount");
        sb.append(" INTEGER, ");
        sb.append("moduleId");
        sb.append(" TEXT, ");
        sb.append("videosJson");
        sb.append(" TEXT ");
        sb.append(" );");
        ExecSQL(sQLiteDatabase, sb.toString());
    }

    private void onCreateDownloadTable(SQLiteDatabase sQLiteDatabase) {
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE IF NOT EXISTS ");
        sb.append(SocialConstDef.TBL_NAME_DOWNLOAD);
        sb.append("( ");
        sb.append("_id");
        sb.append(" INTEGER PRIMARY KEY AUTOINCREMENT, ");
        sb.append("remote");
        sb.append(" TEXT, ");
        sb.append("local");
        sb.append(" TEXT, ");
        sb.append("maintype");
        sb.append(" INTEGER, ");
        sb.append("subtype");
        sb.append(" INTEGER, ");
        sb.append(SocialConstDef.DOWNLOAD_CURRENT_SIZE);
        sb.append(" INTEGER, ");
        sb.append(SocialConstDef.DOWNLOAD_TOTAL);
        sb.append(" INTEGER, ");
        sb.append("priority");
        sb.append(" INTEGER, ");
        sb.append("speed");
        sb.append(" INTEGER, ");
        sb.append("time");
        sb.append(" DATETIME, ");
        sb.append("state");
        sb.append(" INTEGER, ");
        sb.append("reason");
        sb.append(" TEXT, ");
        sb.append("userdata");
        sb.append(" TEXT ");
        sb.append(")");
        ExecSQL(sQLiteDatabase, sb.toString());
    }

    private void onCreateFollow(SQLiteDatabase sQLiteDatabase) {
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE IF NOT EXISTS ");
        sb.append(SocialConstDef.TBL_NAME_FOLLOW);
        sb.append("( ");
        sb.append("unionPrimary");
        sb.append(" TEXT PRIMARY KEY, ");
        sb.append("owner");
        sb.append(" TEXT, ");
        sb.append("flag");
        sb.append(" INTEGER, ");
        sb.append("auid");
        sb.append(" TEXT, ");
        sb.append("nickname");
        sb.append(" TEXT, ");
        sb.append("avatar");
        sb.append(" TEXT, ");
        sb.append("gender");
        sb.append(" INTEGER DEFAULT 2, ");
        sb.append("level");
        sb.append(" TEXT, ");
        sb.append("desc");
        sb.append(" TEXT, ");
        sb.append(SocialConstDef.FOLLOW_ISFOLLOWED);
        sb.append(" INTEGER DEFAULT 0, ");
        sb.append(SocialConstDef.FOLLOW_USERSTATE);
        sb.append(" INTEGER DEFAULT 1, ");
        sb.append("updatetime");
        sb.append(" LONG DEFAULT 0 ");
        sb.append(" );");
        ExecSQL(sQLiteDatabase, sb.toString());
    }

    private void onCreateFollowRequestList(SQLiteDatabase sQLiteDatabase) {
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE IF NOT EXISTS ");
        sb.append(SocialConstDef.TBL_NAME_FOLLOW_REQUEST_LIST);
        sb.append("( ");
        sb.append("_id");
        sb.append(" TEXT PRIMARY KEY, ");
        sb.append(SocialConstDef.FOLLOW_REQUEST_LIST_AUID);
        sb.append(" TEXT, ");
        sb.append(SocialConstDef.FOLLOW_REQUEST_LIST_FOLLOWER_AUID);
        sb.append(" TEXT, ");
        sb.append(SocialConstDef.FOLLOW_REQUEST_LIST_FOLLOWER_NICKNAME);
        sb.append(" TEXT, ");
        sb.append(SocialConstDef.FOLLOW_REQUEST_LIST_FOLLOWER_PROFILE);
        sb.append(" TEXT, ");
        sb.append("createTime");
        sb.append(" INTEGER, ");
        sb.append(SocialConstDef.FOLLOW_REQUEST_LIST_APPLYSTATE);
        sb.append(" INTEGER ");
        sb.append(" );");
        ExecSQL(sQLiteDatabase, sb.toString());
    }

    private void onCreateFollowedUserList(SQLiteDatabase sQLiteDatabase) {
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE IF NOT EXISTS ");
        sb.append(SocialConstDef.TBL_NAME_FOLLOWED_USER_LIST);
        sb.append("( ");
        sb.append("auidDigest");
        sb.append(" TEXT PRIMARY KEY, ");
        sb.append("nickName");
        sb.append(" TEXT, ");
        sb.append("profileImage");
        sb.append(" TEXT, ");
        sb.append(SocialConstDef.FOLLOWED_USER_LIST_FOLLOWSTATE);
        sb.append(" INTEGER ");
        sb.append(" );");
        ExecSQL(sQLiteDatabase, sb.toString());
    }

    private void onCreateKeyValueMapTable(SQLiteDatabase sQLiteDatabase) {
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE IF NOT EXISTS ");
        sb.append(SocialConstDef.TBL_NAME_KEYVALUEMAP);
        sb.append("( ");
        sb.append("key");
        sb.append(" TEXT PRIMARY KEY,");
        sb.append("value");
        sb.append(" TEXT ");
        sb.append(" );");
        ExecSQL(sQLiteDatabase, sb.toString());
    }

    private void onCreateMessageListNewTable(SQLiteDatabase sQLiteDatabase) {
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE IF NOT EXISTS ");
        sb.append(SocialConstDef.TBL_NAME_MESSAGE_LIST_NEW);
        sb.append("( ");
        sb.append(SocialConstDef.MESSAGE_LIST_NEW_ID);
        sb.append(" TEXT,");
        sb.append(SocialConstDef.MESSAGE_LIST_NEW_FROM_USER);
        sb.append(" TEXT, ");
        sb.append(SocialConstDef.MESSAGE_LIST_NEW_TARGET_USER);
        sb.append(" TEXT, ");
        sb.append("type");
        sb.append(" INTEGER, ");
        sb.append("category");
        sb.append(" INTEGER, ");
        sb.append(SocialConstDef.MESSAGE_LIST_NEW_EVENT_TYPE);
        sb.append(" INTEGER, ");
        sb.append(SocialConstDef.MESSAGE_LIST_NEW_EVENT_CONTENT);
        sb.append(" TEXT, ");
        sb.append("source");
        sb.append(" TEXT, ");
        sb.append("title");
        sb.append(" TEXT, ");
        sb.append("content");
        sb.append(" TEXT, ");
        sb.append("format");
        sb.append(" INTEGER, ");
        sb.append(SocialConstDef.MESSAGE_LIST_NEW_READED);
        sb.append(" INTEGER, ");
        sb.append(SocialConstDef.MESSAGE_LIST_NEW_RELATION);
        sb.append(" INTEGER, ");
        sb.append(SocialConstDef.MESSAGE_LIST_NEW_CREATEAT);
        sb.append(" INTEGER, ");
        sb.append(SocialConstDef.MESSAGE_LIST_NEW_TOGETHER_TYPE);
        sb.append(" INTEGER, ");
        sb.append(SocialConstDef.MESSAGE_LIST_NEW_TOGETHER);
        sb.append(" TEXT, ");
        sb.append(SocialConstDef.MESSAGE_LIST_NEW_TOGETHER_TOTAL_COUNT);
        sb.append(" INTEGER, ");
        sb.append(" UNIQUE(");
        sb.append(SocialConstDef.MESSAGE_LIST_NEW_ID);
        sb.append(EditorRouter.KEY_TOOL_LIST_ORDER_SPLIT_OP);
        sb.append("type");
        sb.append(")");
        sb.append(" );");
        ExecSQL(sQLiteDatabase, sb.toString());
    }

    private void onCreateMessageTable(SQLiteDatabase sQLiteDatabase) {
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE IF NOT EXISTS ");
        sb.append(SocialConstDef.TBL_NAME_MESSAGE);
        sb.append("( ");
        sb.append("_id");
        sb.append(" LONG, ");
        sb.append("category");
        sb.append(" INTEGER, ");
        sb.append(SocialConstDef.MESSAGE_REQUEST_FLAG);
        sb.append(" TEXT, ");
        sb.append(SocialConstDef.MESSAGE_WRITER);
        sb.append(" TEXT, ");
        sb.append(SocialConstDef.MESSAGE_READER);
        sb.append(" TEXT, ");
        sb.append("icon");
        sb.append(" TEXT, ");
        sb.append("type");
        sb.append(" INTEGER, ");
        sb.append(SocialConstDef.MESSAGE_LABEL);
        sb.append(" TEXT, ");
        sb.append("title");
        sb.append(" TEXT, ");
        sb.append("content");
        sb.append(" TEXT, ");
        sb.append(SocialConstDef.MESSAGE_DETAIL_FLAG);
        sb.append(" INTEGER, ");
        sb.append("detail");
        sb.append(" TEXT, ");
        sb.append("format");
        sb.append(" INTEGER, ");
        sb.append("lang");
        sb.append(" TEXT, ");
        sb.append("state");
        sb.append(" INTEGER, ");
        sb.append(SocialConstDef.MESSAGE_VIEWFLAG);
        sb.append(" INTEGER, ");
        sb.append("publishtime");
        sb.append(" TEXT, ");
        sb.append("expiretime");
        sb.append(" TEXT, ");
        sb.append("updatetime");
        sb.append(" TEXT, ");
        sb.append(SocialConstDef.MESSAGE_TODO_CODE);
        sb.append(" TEXT, ");
        sb.append("todo_content");
        sb.append(" TEXT, ");
        sb.append(SocialConstDef.MESSAGE_DISPLAY_STYLE);
        sb.append(" INTEGER, ");
        sb.append("misc");
        sb.append(" TEXT, ");
        sb.append(SocialConstDef.MESSAGE_SENDER_AUID);
        sb.append(" TEXT, ");
        sb.append(SocialConstDef.MESSAGE_SENDER_NICKNAME);
        sb.append(" TEXT, ");
        sb.append(SocialConstDef.MESSAGE_SENDER_AVATAR);
        sb.append(" TEXT, ");
        sb.append(SocialConstDef.MESSAGE_SENDER_GENDER);
        sb.append(" TEXT, ");
        sb.append(SocialConstDef.MESSAGE_SENDER_LEVEL);
        sb.append(" TEXT ");
        sb.append(")");
        ExecSQL(sQLiteDatabase, sb.toString());
    }

    private void onCreateMixedPageTable(SQLiteDatabase sQLiteDatabase) {
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE IF NOT EXISTS ");
        sb.append(SocialConstDef.TBL_NAME_MIXED_PAGE);
        sb.append("( ");
        sb.append("_id");
        sb.append(" TEXT PRIMARY KEY, ");
        sb.append(SocialConstDef.MIXED_PAGE_PAGETYPE);
        sb.append(" INTEGER, ");
        sb.append("title");
        sb.append(" TEXT, ");
        sb.append("desc");
        sb.append(" TEXT, ");
        sb.append("type");
        sb.append(" INTEGER, ");
        sb.append("orderNo");
        sb.append(" INTEGER, ");
        sb.append("moduleId");
        sb.append(" TEXT, ");
        sb.append("flag");
        sb.append(" INTEGER, ");
        sb.append("duration");
        sb.append(" LONG, ");
        sb.append(SocialConstDef.MIXED_PAGE_ICONURL);
        sb.append(" TEXT, ");
        sb.append(SocialConstDef.MIXED_PAGE_BACKGROUND_URL);
        sb.append(" TEXT, ");
        sb.append(SocialConstDef.MIXED_PAGE_MODULEJSON);
        sb.append(" TEXT, ");
        sb.append("traceId");
        sb.append(" TEXT ");
        sb.append(" );");
        ExecSQL(sQLiteDatabase, sb.toString());
    }

    private void onCreateMyCreation(SQLiteDatabase sQLiteDatabase) {
        ExecSQL(sQLiteDatabase, "drop trigger if exists project_INSERT;");
        ExecSQL(sQLiteDatabase, "drop trigger if exists project_DELETE;");
        ExecSQL(sQLiteDatabase, "drop trigger if exists project_UPDATE;");
        ExecSQL(sQLiteDatabase, "drop trigger if exists publish_INSERT;");
        ExecSQL(sQLiteDatabase, "drop trigger if exists publish_DELETE;");
        ExecSQL(sQLiteDatabase, "drop trigger if exists publish_UPDATE;");
        ExecSQL(sQLiteDatabase, "drop table if exists MyCreation;");
        ExecSQL(sQLiteDatabase, "drop view if exists MyCreation;");
    }

    private void onCreateOperationItems(SQLiteDatabase sQLiteDatabase) {
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE IF NOT EXISTS ");
        sb.append(SocialConstDef.TBL_NAME_OPERATION_ITEMS);
        sb.append("( ");
        sb.append(SocialConstDef.OPERATION_ITEMS_MODULETYPE);
        sb.append(" INTEGER DEFAULT 0, ");
        sb.append(SocialConstDef.OPERATION_ITEMS_DATATYPE);
        sb.append(" INTEGER, ");
        sb.append(SocialConstDef.OPERATION_ITEMS_DATAJSON);
        sb.append(" TEXT ");
        sb.append(" );");
        ExecSQL(sQLiteDatabase, sb.toString());
    }

    private void onCreatePublishTable(SQLiteDatabase sQLiteDatabase) {
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE IF NOT EXISTS ");
        sb.append(SocialConstDef.TBL_NAME_PUBLISH);
        sb.append("( ");
        sb.append("_id");
        sb.append(" INTEGER PRIMARY KEY AUTOINCREMENT, ");
        sb.append(SocialConstDef.PUBLISH_PROJECT_PUID);
        sb.append(" TEXT, ");
        sb.append(SocialConstDef.PUBLISH_PROJECT_URL);
        sb.append(" TEXT, ");
        sb.append(SocialConstDef.PUBLISH_PROJECT_TITLE);
        sb.append(" TEXT, ");
        sb.append(SocialConstDef.PUBLISH_PROJECT_VERSION);
        sb.append(" INTEGER, ");
        sb.append(SocialConstDef.PUBLISH_VIDEO_VUID);
        sb.append(" TEXT, ");
        sb.append("video_desc");
        sb.append(" TEXT, ");
        sb.append(SocialConstDef.PUBLISH_VIDEO_GPS_ACCURACY);
        sb.append(" INTEGER, ");
        sb.append(SocialConstDef.PUBLISH_VIDEO_LATITUDE);
        sb.append(" DOUBLE, ");
        sb.append(SocialConstDef.PUBLISH_VIDEO_LONGITUDE);
        sb.append(" DOUBLE, ");
        sb.append(SocialConstDef.PUBLISH_VIDEO_ADDRESS);
        sb.append(" TEXT, ");
        sb.append(SocialConstDef.PUBLISH_VIDEO_ADDRESS_DETAIL);
        sb.append(" TEXT, ");
        sb.append(SocialConstDef.PUBLISH_VIDEO_THUMB_LOCAL_URL);
        sb.append(" TEXT, ");
        sb.append(SocialConstDef.PUBLISH_VIDEO_THUMB_LOCAL_BIG);
        sb.append(" TEXT, ");
        sb.append(SocialConstDef.PUBLISH_VIDEO_THUMB_REMOTE_URL);
        sb.append(" TEXT, ");
        sb.append(SocialConstDef.PUBLISH_VIDEO_POSTER_LOCAL_URL);
        sb.append(" TEXT, ");
        sb.append(SocialConstDef.PUBLISH_VIDEO_POSTER_REMOTE_URL);
        sb.append(" TEXT, ");
        sb.append(SocialConstDef.PUBLISH_VIDEO_LOCAL_URL);
        sb.append(" TEXT, ");
        sb.append("video_remote_url");
        sb.append(" TEXT, ");
        sb.append(SocialConstDef.PUBLISH_VIDEO_XY_PAGE_URL);
        sb.append(" TEXT, ");
        sb.append(SocialConstDef.PUBLISH_VIDEO_SINA_PAGE_URL);
        sb.append(" TEXT, ");
        sb.append(SocialConstDef.PUBLISH_VIDEO_SINA_WEIBO_ID);
        sb.append(" TEXT, ");
        sb.append("friends");
        sb.append(" TEXT, ");
        sb.append("permission");
        sb.append(" INTEGER, ");
        sb.append(SocialConstDef.PUBLISH_SHAREFLAG);
        sb.append(" INTEGER, ");
        sb.append(SocialConstDef.PUBLISH_SHAREFLAG_MASK);
        sb.append(" LONG, ");
        sb.append(SocialConstDef.PUBLISH_SHOOTTIME);
        sb.append(" DATETIME, ");
        sb.append("modify_time");
        sb.append(" DATETIME, ");
        sb.append(SocialConstDef.PUBLISH_PUBLISHDELAY);
        sb.append(" LONG, ");
        sb.append("studio_name");
        sb.append(" TEXT, ");
        sb.append("category");
        sb.append(" TEXT, ");
        sb.append(SocialConstDef.PUBLISH_TAG);
        sb.append(" TEXT, ");
        sb.append(SocialConstDef.PUBLISH_FLAG_INTERNAL);
        sb.append(" INTEGER, ");
        sb.append(SocialConstDef.PUBLISH_VIDEO_FILE_UPLOAD_TOKEN);
        sb.append(" TEXT, ");
        sb.append("video_file_upload_url");
        sb.append(" TEXT, ");
        sb.append(SocialConstDef.PUBLISH_STARTTIME);
        sb.append(" LONG, ");
        sb.append(SocialConstDef.PUBLISH_VIDEO_DURATION);
        sb.append(" LONG, ");
        sb.append(SocialConstDef.PUBLISH_RELEASE_FLAG);
        sb.append(" INTEGER DEFAULT 0, ");
        sb.append(SocialConstDef.PUBLISH_UPLOAD_PERSISTANCE);
        sb.append(" TEXT, ");
        sb.append("activityUID");
        sb.append(" TEXT, ");
        sb.append(SocialConstDef.PUBLISH_ACTIVITY_EVENT);
        sb.append(" TEXT, ");
        sb.append(SocialConstDef.PUBLISH_COVER_TEXT);
        sb.append(" TEXT, ");
        sb.append(SocialConstDef.PUBLISH_VIDEO_TEXT);
        sb.append(" TEXT, ");
        sb.append(SocialConstDef.PUBLISH_VIDEO_THUMB_TUID);
        sb.append(" TEXT, ");
        sb.append("referredUsers");
        sb.append(" TEXT, ");
        sb.append(SocialConstDef.PUBLISH_VIDEO_LANGUAGE);
        sb.append(" TEXT ");
        sb.append(")");
        ExecSQL(sQLiteDatabase, sb.toString());
    }

    private void onCreateRecommendTagUsers(SQLiteDatabase sQLiteDatabase) {
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE IF NOT EXISTS ");
        sb.append(SocialConstDef.TBL_NAME_RECOMMED_TAGUSERS);
        sb.append("( ");
        sb.append("auid");
        sb.append(" TEXT, ");
        sb.append("name");
        sb.append(" TEXT, ");
        sb.append("profile");
        sb.append(" TEXT, ");
        sb.append("desc");
        sb.append(" TEXT, ");
        sb.append(SocialConstDef.RECOMMEND_TAGUSER_FOLLOWSCOUNT);
        sb.append(" INTEGER DEFAULT 0, ");
        sb.append("fansCount");
        sb.append(" INTEGER DEFAULT 0, ");
        sb.append(SocialConstDef.RECOMMEND_TAGUSER_VIDEOLIST);
        sb.append(" TEXT, ");
        sb.append(SocialConstDef.RECOMMEND_TAGUSER_USERTAGLIST);
        sb.append(" TEXT ");
        sb.append(" );");
        ExecSQL(sQLiteDatabase, sb.toString());
    }

    private void onCreateRecommendUsers(SQLiteDatabase sQLiteDatabase) {
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE IF NOT EXISTS ");
        sb.append(SocialConstDef.TBL_NAME_RECOMMED_USERS);
        sb.append("( ");
        sb.append("owner");
        sb.append(" TEXT, ");
        sb.append("nikename");
        sb.append(" TEXT, ");
        sb.append("profile");
        sb.append(" TEXT, ");
        sb.append("gender");
        sb.append(" INTEGER DEFAULT 2, ");
        sb.append("level");
        sb.append(" TEXT, ");
        sb.append("description");
        sb.append(" TEXT, ");
        sb.append("isfllowed");
        sb.append(" INTEGER DEFAULT 0, ");
        sb.append(SocialConstDef.RECOMMEND_USER_VIDEOLIST);
        sb.append(" TEXT ");
        sb.append(" );");
        ExecSQL(sQLiteDatabase, sb.toString());
    }

    private void onCreateRecserList(SQLiteDatabase sQLiteDatabase) {
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE IF NOT EXISTS ");
        sb.append(SocialConstDef.TBL_NAME_RECOMMEND_USER_LIST);
        sb.append("( ");
        sb.append("auidDigest");
        sb.append(" TEXT, ");
        sb.append("nickName");
        sb.append(" TEXT, ");
        sb.append("profileImage");
        sb.append(" TEXT, ");
        sb.append(SocialConstDef.RECOMMEND_USER_LIST_RECREASON);
        sb.append(" TEXT, ");
        sb.append("traceId");
        sb.append(" TEXT, ");
        sb.append("scene");
        sb.append(" TEXT, ");
        sb.append(SocialConstDef.RECOMMEND_USER_LIST_ABVERSION);
        sb.append(" TEXT, ");
        sb.append(SocialConstDef.RECOMMEND_USER_LIST_ALGUNIT);
        sb.append(" TEXT, ");
        sb.append(SocialConstDef.RECOMMEND_USER_LIST_FANSTOTAL);
        sb.append(" INTEGER, ");
        sb.append(SocialConstDef.RECOMMEND_USER_LIST_TAGS);
        sb.append(" TEXT, ");
        sb.append(" UNIQUE(");
        sb.append("auidDigest");
        sb.append(EditorRouter.KEY_TOOL_LIST_ORDER_SPLIT_OP);
        sb.append("scene");
        sb.append(")");
        sb.append(" );");
        ExecSQL(sQLiteDatabase, sb.toString());
    }

    private void onCreateSNSTable(SQLiteDatabase sQLiteDatabase) {
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE IF NOT EXISTS ");
        sb.append(SocialConstDef.TBL_NAME_SNS);
        sb.append("( ");
        sb.append("type");
        sb.append(" INTEGER PRIMARY KEY, ");
        sb.append("uid");
        sb.append(" TEXT, ");
        sb.append(SocialConstDef.SNS_ACCESSTOKEN);
        sb.append(" TEXT, ");
        sb.append("name");
        sb.append(" TEXT, ");
        sb.append("nickname");
        sb.append(" TEXT, ");
        sb.append(SocialConstDef.SNS_PASSWORD);
        sb.append(" TEXT, ");
        sb.append("expiredtime");
        sb.append(" LONG, ");
        sb.append("avatar");
        sb.append(" TEXT, ");
        sb.append("updatetime");
        sb.append(" LONG DEFAULT 0, ");
        sb.append(SocialConstDef.SNS_BIND_FLAG);
        sb.append(" INTEGER ");
        sb.append(")");
        ExecSQL(sQLiteDatabase, sb.toString());
    }

    private void onCreateShareTable(SQLiteDatabase sQLiteDatabase) {
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE IF NOT EXISTS ");
        sb.append(SocialConstDef.TBL_NAME_SHARE);
        sb.append("( ");
        sb.append("_id");
        sb.append(" INTEGER PRIMARY KEY AUTOINCREMENT, ");
        sb.append(SocialConstDef.SHARE_TASKTYPE);
        sb.append(" INTEGER, ");
        sb.append(SocialConstDef.SHARE_TASKSTEP);
        sb.append(" INTEGER, ");
        sb.append(SocialConstDef.SHARE_SNS_TYPE);
        sb.append(" INTEGER, ");
        sb.append(SocialConstDef.SHARE_PUBLISH_ID);
        sb.append(" TEXT, ");
        sb.append("uid");
        sb.append(" TEXT, ");
        sb.append(SocialConstDef.SHARE_SNS_SHAREID);
        sb.append(" TEXT, ");
        sb.append("state");
        sb.append(" INTEGER, ");
        sb.append("url");
        sb.append(" TEXT, ");
        sb.append("reason");
        sb.append(" TEXT, ");
        sb.append("retry");
        sb.append(" LONG, ");
        sb.append("timestamp");
        sb.append(" DATETIME, ");
        sb.append("misc");
        sb.append(" TEXT ");
        sb.append(")");
        ExecSQL(sQLiteDatabase, sb.toString());
    }

    private void onCreateTaskTable(SQLiteDatabase sQLiteDatabase) {
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE IF NOT EXISTS ");
        sb.append(SocialConstDef.TBL_NAME_TASK);
        sb.append("( ");
        sb.append("_id");
        sb.append(" INTEGER PRIMARY KEY AUTOINCREMENT, ");
        sb.append(SocialConstDef.TASK_MAIN_TYPE);
        sb.append(" INTEGER, ");
        sb.append(SocialConstDef.TASK_SUB_TYPE);
        sb.append(" INTEGER, ");
        sb.append("state");
        sb.append(" INTEGER, ");
        sb.append(SocialConstDef.TASK_SUB_STATE);
        sb.append(" INTEGER, ");
        sb.append(SocialConstDef.TASK_PROGRESS_1);
        sb.append(" LONG, ");
        sb.append(SocialConstDef.TASK_PROGRESS_2);
        sb.append(" LONG, ");
        sb.append(SocialConstDef.TASK_USER_DATA);
        sb.append(" TEXT, ");
        sb.append(SocialConstDef.TASK_STARTTIME);
        sb.append(" DATETIME ");
        sb.append(")");
        ExecSQL(sQLiteDatabase, sb.toString());
    }

    private void onCreateUserInfo(SQLiteDatabase sQLiteDatabase) {
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE IF NOT EXISTS ");
        sb.append(SocialConstDef.TBL_NAME_USER_INFO);
        sb.append("( ");
        sb.append("owner");
        sb.append(" TEXT, ");
        sb.append("nikename");
        sb.append(" TEXT, ");
        sb.append("profile");
        sb.append(" TEXT, ");
        sb.append("level");
        sb.append(" INTEGER DEFAULT 0, ");
        sb.append(SocialConstDef.USER_INFO_VIDEO_COUNT);
        sb.append(" INTEGER DEFAULT 0, ");
        sb.append("forwards");
        sb.append(" INTEGER DEFAULT 0, ");
        sb.append("likes");
        sb.append(" INTEGER DEFAULT 0, ");
        sb.append("comments");
        sb.append(" INTEGER DEFAULT 0, ");
        sb.append("fans");
        sb.append(" INTEGER DEFAULT 0, ");
        sb.append("follows");
        sb.append(" INTEGER DEFAULT 0, ");
        sb.append("device");
        sb.append(" TEXT, ");
        sb.append("location");
        sb.append(" TEXT, ");
        sb.append("description");
        sb.append(" TEXT, ");
        sb.append(SocialConstDef.USER_INFO_BACKGROUND);
        sb.append(" TEXT, ");
        sb.append("gender");
        sb.append(" INTEGER DEFAULT 2, ");
        sb.append("isfllowed");
        sb.append(" INTEGER DEFAULT 0, ");
        sb.append(SocialConstDef.USER_INFO_COUNTRY_ID);
        sb.append(" TEXT, ");
        sb.append(SocialConstDef.USER_INFO_PROVINCE_ID);
        sb.append(" TEXT, ");
        sb.append(SocialConstDef.USER_INFO_CITY_ID);
        sb.append(" TEXT, ");
        sb.append(SocialConstDef.USER_INFO_PUB_VIDEOS);
        sb.append(" TEXT, ");
        sb.append(SocialConstDef.USER_INFO_ACCOUNT_FLAG);
        sb.append(" TEXT, ");
        sb.append(SocialConstDef.USER_INFO_UNIQUE_FLAG);
        sb.append(" TEXT, ");
        sb.append(SocialConstDef.USER_INFO_IN_BLACK_LIST);
        sb.append(" INTEGER DEFAULT 0, ");
        sb.append("state");
        sb.append(" TEXT, ");
        sb.append(SocialConstDef.USER_VERIFIED_INFO);
        sb.append(" TEXT, ");
        sb.append(SocialConstDef.USER_HOSTLEVEL);
        sb.append(" INTEGER DEFAULT 0, ");
        sb.append(SocialConstDef.USER_GRADE);
        sb.append(" INTEGER DEFAULT 0, ");
        sb.append(SocialConstDef.USER_GRADEICON);
        sb.append(" TEXT, ");
        sb.append(SocialConstDef.USER_SNS_INFO);
        sb.append(" TEXT, ");
        sb.append("numberId");
        sb.append(" LONG, ");
        sb.append("privacy");
        sb.append(" INTEGER, ");
        sb.append(SocialConstDef.USER_ISFOLLOWAPPLY);
        sb.append(" INTEGER ");
        sb.append(" );");
        ExecSQL(sQLiteDatabase, sb.toString());
    }

    private void upgrade4V71(SQLiteDatabase sQLiteDatabase) {
        StringBuilder sb = new StringBuilder();
        sb.append("ALTER TABLE ");
        sb.append(SocialConstDef.TBL_NAME_USER_INFO);
        sb.append(" ADD ");
        sb.append(SocialConstDef.USER_HOSTLEVEL);
        sb.append(" INTEGER DEFAULT 0;");
        ExecSQL(sQLiteDatabase, sb.toString());
    }

    private void upgrade4V72(SQLiteDatabase sQLiteDatabase) {
        onCreateRecommendTagUsers(sQLiteDatabase);
        StringBuilder sb = new StringBuilder();
        sb.append("ALTER TABLE ");
        sb.append(SocialConstDef.TBL_NAME_USER_INFO);
        sb.append(" ADD ");
        sb.append(SocialConstDef.USER_GRADE);
        sb.append(" INTEGER DEFAULT 0;");
        ExecSQL(sQLiteDatabase, sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append("ALTER TABLE ");
        sb2.append(SocialConstDef.TBL_NAME_USER_INFO);
        sb2.append(" ADD ");
        sb2.append(SocialConstDef.USER_GRADEICON);
        sb2.append(" TEXT;");
        ExecSQL(sQLiteDatabase, sb2.toString());
    }

    private void upgrade4V74(SQLiteDatabase sQLiteDatabase) {
        StringBuilder sb = new StringBuilder();
        sb.append("ALTER TABLE ");
        sb.append(SocialConstDef.TBL_NAME_MIXED_PAGE);
        sb.append(" ADD ");
        sb.append(SocialConstDef.MIXED_PAGE_BACKGROUND_URL);
        sb.append(" TEXT;");
        ExecSQL(sQLiteDatabase, sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append("ALTER TABLE ");
        sb2.append(SocialConstDef.TBL_NAME_USER_INFO);
        sb2.append(" ADD ");
        sb2.append("numberId");
        sb2.append(" LONG;");
        ExecSQL(sQLiteDatabase, sb2.toString());
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        onCreateKeyValueMapTable(sQLiteDatabase);
        onCreatePublishTable(sQLiteDatabase);
        onCreateDownloadTable(sQLiteDatabase);
        onCreateTaskTable(sQLiteDatabase);
        onCreateMyCreation(sQLiteDatabase);
        onCreateSNSTable(sQLiteDatabase);
        onCreateMessageTable(sQLiteDatabase);
        onCreateMessageListNewTable(sQLiteDatabase);
        onCreateShareTable(sQLiteDatabase);
        onCreateUserInfo(sQLiteDatabase);
        onCreateFollow(sQLiteDatabase);
        onCreateRecommendUsers(sQLiteDatabase);
        onCreateChatContact(sQLiteDatabase);
        onCreateBlackList(sQLiteDatabase);
        onCreateMixedPageTable(sQLiteDatabase);
        onCreateCustomizedUserTable(sQLiteDatabase);
        onCreateRecommendTagUsers(sQLiteDatabase);
        onCreateOperationItems(sQLiteDatabase);
        onCreateFollowRequestList(sQLiteDatabase);
        onCreateRecserList(sQLiteDatabase);
        onCreateFollowedUserList(sQLiteDatabase);
        PublishTaskTable.onCreatePublishTaskTable(sQLiteDatabase);
    }

    public synchronized void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i < 2) {
            try {
                StringBuilder sb = new StringBuilder();
                sb.append("drop trigger if exists publish_UPDATE;");
                ExecSQL(sQLiteDatabase, sb.toString());
                StringBuilder sb2 = new StringBuilder();
                sb2.append("CREATE TRIGGER publish_UPDATE AFTER update ON publish \n");
                sb2.append(" when NEW.release_flag = 0 \n");
                sb2.append(" begin \n");
                sb2.append(" update MyCreation set publishid = NEW._id, video_desc = NEW.video_desc, address = NEW.video_address where (publishid = 0 OR publishid = NEW._id) and export_url = NEW.video_local_url;\n");
                sb2.append(" end;\n");
                ExecSQL(sQLiteDatabase, sb2.toString());
            } catch (Exception e) {
                e.printStackTrace();
            } catch (Throwable th) {
                throw th;
            }
        }
        if (i < 5) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("DROP TABLE IF EXISTS ");
            sb3.append(SocialConstDef.TBL_NAME_DOWNLOAD);
            sb3.append(" ;");
            ExecSQL(sQLiteDatabase, sb3.toString());
            onCreateDownloadTable(sQLiteDatabase);
        }
        if (i < 6) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append("ALTER TABLE ");
            sb4.append(SocialConstDef.TBL_NAME_TASK);
            sb4.append(" ADD ");
            sb4.append(SocialConstDef.TASK_SUB_STATE);
            sb4.append(" INTEGER;");
            ExecSQL(sQLiteDatabase, sb4.toString());
            StringBuilder sb5 = new StringBuilder();
            sb5.append("UPDATE ");
            sb5.append(SocialConstDef.TBL_NAME_TASK);
            sb5.append(" SET ");
            sb5.append(SocialConstDef.TASK_SUB_STATE);
            sb5.append(" = 0;");
            ExecSQL(sQLiteDatabase, sb5.toString());
        }
        if (i < 8) {
            StringBuilder sb6 = new StringBuilder();
            sb6.append("ALTER TABLE ");
            sb6.append(SocialConstDef.TBL_NAME_PUBLISH);
            sb6.append(" ADD ");
            sb6.append(SocialConstDef.PUBLISH_STARTTIME);
            sb6.append(" LONG;");
            ExecSQL(sQLiteDatabase, sb6.toString());
            StringBuilder sb7 = new StringBuilder();
            sb7.append("UPDATE ");
            sb7.append(SocialConstDef.TBL_NAME_PUBLISH);
            sb7.append(" SET ");
            sb7.append(SocialConstDef.PUBLISH_STARTTIME);
            sb7.append(" = ");
            sb7.append(System.currentTimeMillis());
            sb7.append(";");
            ExecSQL(sQLiteDatabase, sb7.toString());
        }
        if (i < 9) {
            onCreateSNSTable(sQLiteDatabase);
            onCreateMessageTable(sQLiteDatabase);
        }
        if (i < 12) {
            StringBuilder sb8 = new StringBuilder();
            sb8.append("DROP TABLE IF EXISTS ");
            sb8.append(SocialConstDef.TBL_NAME_MESSAGE);
            sb8.append(" ;");
            ExecSQL(sQLiteDatabase, sb8.toString());
            StringBuilder sb9 = new StringBuilder();
            sb9.append("DROP TABLE IF EXISTS ");
            sb9.append(SocialConstDef.TBL_NAME_SNS);
            sb9.append(" ;");
            ExecSQL(sQLiteDatabase, sb9.toString());
            StringBuilder sb10 = new StringBuilder();
            sb10.append("DROP TABLE IF EXISTS ");
            sb10.append(SocialConstDef.TBL_NAME_SHARE);
            sb10.append(" ;");
            ExecSQL(sQLiteDatabase, sb10.toString());
            onCreateMessageTable(sQLiteDatabase);
            onCreateSNSTable(sQLiteDatabase);
            onCreateShareTable(sQLiteDatabase);
            StringBuilder sb11 = new StringBuilder();
            sb11.append("UPDATE ");
            sb11.append(SocialConstDef.TBL_NAME_PUBLISH);
            sb11.append(" SET ");
            sb11.append(SocialConstDef.PUBLISH_SHAREFLAG);
            sb11.append(" = ");
            sb11.append(2);
            sb11.append(";");
            ExecSQL(sQLiteDatabase, sb11.toString());
            StringBuilder sb12 = new StringBuilder();
            sb12.append("UPDATE ");
            sb12.append(SocialConstDef.TBL_NAME_PUBLISH);
            sb12.append(" SET ");
            sb12.append("permission");
            sb12.append(" = ");
            sb12.append(32);
            sb12.append(";");
            ExecSQL(sQLiteDatabase, sb12.toString());
            StringBuilder sb13 = new StringBuilder();
            sb13.append("ALTER TABLE ");
            sb13.append(SocialConstDef.TBL_NAME_PUBLISH);
            sb13.append(" ADD ");
            sb13.append(SocialConstDef.PUBLISH_SHAREFLAG_MASK);
            sb13.append(" LONG;");
            if (ExecSQL(sQLiteDatabase, sb13.toString())) {
                StringBuilder sb14 = new StringBuilder();
                sb14.append("UPDATE ");
                sb14.append(SocialConstDef.TBL_NAME_PUBLISH);
                sb14.append(" SET ");
                sb14.append(SocialConstDef.PUBLISH_SHAREFLAG_MASK);
                sb14.append(" = ");
                sb14.append("0");
                sb14.append(";");
                ExecSQL(sQLiteDatabase, sb14.toString());
            }
            StringBuilder sb15 = new StringBuilder();
            sb15.append("ALTER TABLE ");
            sb15.append(SocialConstDef.TBL_NAME_PUBLISH);
            sb15.append(" ADD ");
            sb15.append(SocialConstDef.PUBLISH_VIDEO_THUMB_LOCAL_BIG);
            sb15.append(" TEXT;");
            if (ExecSQL(sQLiteDatabase, sb15.toString())) {
                StringBuilder sb16 = new StringBuilder();
                sb16.append("UPDATE ");
                sb16.append(SocialConstDef.TBL_NAME_PUBLISH);
                sb16.append(" SET ");
                sb16.append(SocialConstDef.PUBLISH_VIDEO_THUMB_LOCAL_BIG);
                sb16.append(" = ");
                sb16.append(SocialConstDef.PUBLISH_VIDEO_THUMB_REMOTE_URL);
                sb16.append(";");
                ExecSQL(sQLiteDatabase, sb16.toString());
                StringBuilder sb17 = new StringBuilder();
                sb17.append("UPDATE ");
                sb17.append(SocialConstDef.TBL_NAME_PUBLISH);
                sb17.append(" SET ");
                sb17.append(SocialConstDef.PUBLISH_VIDEO_THUMB_REMOTE_URL);
                sb17.append(" = ");
                sb17.append("''");
                sb17.append(";");
                ExecSQL(sQLiteDatabase, sb17.toString());
            }
        }
        if (i < 13) {
            StringBuilder sb18 = new StringBuilder();
            sb18.append("ALTER TABLE ");
            sb18.append(SocialConstDef.TBL_NAME_MESSAGE);
            sb18.append(" ADD ");
            sb18.append(SocialConstDef.MESSAGE_VIEWFLAG);
            sb18.append(" INTEGER;");
            if (ExecSQL(sQLiteDatabase, sb18.toString())) {
                StringBuilder sb19 = new StringBuilder();
                sb19.append("UPDATE ");
                sb19.append(SocialConstDef.TBL_NAME_MESSAGE);
                sb19.append(" SET ");
                sb19.append(SocialConstDef.MESSAGE_VIEWFLAG);
                sb19.append(" = ");
                sb19.append(0);
                sb19.append(";");
                ExecSQL(sQLiteDatabase, sb19.toString());
            }
            StringBuilder sb20 = new StringBuilder();
            sb20.append("ALTER TABLE ");
            sb20.append(SocialConstDef.TBL_NAME_MESSAGE);
            sb20.append(" ADD ");
            sb20.append("updatetime");
            sb20.append(" TEXT;");
            ExecSQL(sQLiteDatabase, sb20.toString());
            StringBuilder sb21 = new StringBuilder();
            sb21.append("UPDATE ");
            sb21.append(SocialConstDef.TBL_NAME_MESSAGE);
            sb21.append(" SET ");
            sb21.append("updatetime");
            sb21.append(" = ");
            sb21.append("publishtime");
            sb21.append(";");
            ExecSQL(sQLiteDatabase, sb21.toString());
            onCreateKeyValueMapTable(sQLiteDatabase);
        }
        if (i < 18) {
            StringBuilder sb22 = new StringBuilder();
            sb22.append("ALTER TABLE ");
            sb22.append(SocialConstDef.TBL_NAME_PUBLISH);
            sb22.append(" ADD ");
            sb22.append(SocialConstDef.PUBLISH_RELEASE_FLAG);
            sb22.append(" INTEGER DEFAULT 0;");
            ExecSQL(sQLiteDatabase, sb22.toString());
            StringBuilder sb23 = new StringBuilder();
            sb23.append("ALTER TABLE ");
            sb23.append(SocialConstDef.TBL_NAME_PUBLISH);
            sb23.append(" ADD ");
            sb23.append(SocialConstDef.PUBLISH_UPLOAD_PERSISTANCE);
            sb23.append(" TEXT;");
            ExecSQL(sQLiteDatabase, sb23.toString());
            StringBuilder sb24 = new StringBuilder();
            sb24.append("ALTER TABLE ");
            sb24.append(SocialConstDef.TBL_NAME_PUBLISH);
            sb24.append(" ADD ");
            sb24.append("activityUID");
            sb24.append(" TEXT;");
            ExecSQL(sQLiteDatabase, sb24.toString());
            StringBuilder sb25 = new StringBuilder();
            sb25.append("ALTER TABLE ");
            sb25.append(SocialConstDef.TBL_NAME_PUBLISH);
            sb25.append(" ADD ");
            sb25.append(SocialConstDef.PUBLISH_ACTIVITY_EVENT);
            sb25.append(" TEXT;");
            ExecSQL(sQLiteDatabase, sb25.toString());
            StringBuilder sb26 = new StringBuilder();
            sb26.append("ALTER TABLE ");
            sb26.append(SocialConstDef.TBL_NAME_PUBLISH);
            sb26.append(" ADD ");
            sb26.append(SocialConstDef.PUBLISH_VIDEO_DURATION);
            sb26.append(" LONG;");
            if (ExecSQL(sQLiteDatabase, sb26.toString())) {
                StringBuilder sb27 = new StringBuilder();
                sb27.append("update publish set video_duration =(select duration from project where video_local_url = project.export_url) ");
                sb27.append(" where publish.video_local_url = (select export_url from project where video_local_url = project.export_url) ;");
                ExecSQL(sQLiteDatabase, sb27.toString());
            }
        }
        if (i < 19) {
            onCreateMyCreation(sQLiteDatabase);
        }
        if (i < 21) {
            StringBuilder sb28 = new StringBuilder();
            sb28.append("drop trigger if exists project_UPDATE;");
            ExecSQL(sQLiteDatabase, sb28.toString());
            StringBuilder sb29 = new StringBuilder();
            sb29.append(" CREATE TRIGGER project_UPDATE AFTER update ON project \n");
            sb29.append(" begin \n");
            sb29.append(" update MyCreation set projectid = 0 where projectid = NEW._id AND (NEW.export_url is null OR (NEW.export_url is not null AND length(NEW.export_url) = 0) OR (NEW.is_deleted is not null AND NEW.is_deleted <> 0));\n");
            sb29.append(" delete from MyCreation where projectid = 0 and publishid = 0;\n");
            sb29.append(" insert or replace into MyCreation (export_url, title, time, address, duration, projectid, thumbnail, video_desc) select NEW.export_url, NEW.title, NEW.modify_time, NEW.address, NEW.duration, NEW._id, NEW.thumbnail, NEW.video_desc from project where (NEW.is_deleted = 0 OR NEW.is_deleted is null ) AND (NEW.export_url is not null AND length(NEW.export_url) > 0) AND ((select export_url from MyCreation where export_url = NEW.export_url) is null);\n");
            sb29.append(" update MyCreation set export_url=NEW.export_url, title=NEW.title, address=NEW.address, duration=NEW.duration , thumbnail=NEW.thumbnail, video_desc=NEW.video_desc where projectid=NEW._id AND (NEW.is_deleted = 0 OR NEW.is_deleted is null) AND ((select export_url from MyCreation where export_url = NEW.export_url) is not null);\n");
            sb29.append(" end; \n");
            ExecSQL(sQLiteDatabase, sb29.toString());
            StringBuilder sb30 = new StringBuilder();
            sb30.append("drop trigger if exists publish_UPDATE;");
            ExecSQL(sQLiteDatabase, sb30.toString());
            StringBuilder sb31 = new StringBuilder();
            sb31.append("CREATE TRIGGER publish_UPDATE AFTER update ON publish \n");
            sb31.append(" when NEW.release_flag = 0 \n");
            sb31.append(" begin \n");
            sb31.append(" update MyCreation set publishid = NEW._id, video_desc = NEW.video_desc, address = NEW.video_address where (publishid = 0 OR publishid = NEW._id) and export_url = NEW.video_local_url;\n");
            sb31.append(" end;\n");
            ExecSQL(sQLiteDatabase, sb31.toString());
        }
        if (i < 22) {
            onCreateMyCreation(sQLiteDatabase);
        }
        if (i < 23) {
            StringBuilder sb32 = new StringBuilder();
            sb32.append("ALTER TABLE ");
            sb32.append(SocialConstDef.TBL_NAME_MESSAGE);
            sb32.append(" ADD ");
            sb32.append("todo_content");
            sb32.append(" TEXT;");
            ExecSQL(sQLiteDatabase, sb32.toString());
        }
        if (i < 24) {
            StringBuilder sb33 = new StringBuilder();
            sb33.append("ALTER TABLE ");
            sb33.append(SocialConstDef.TBL_NAME_PUBLISH);
            sb33.append(" ADD ");
            sb33.append("modify_time");
            sb33.append(" DATETIME;");
            ExecSQL(sQLiteDatabase, sb33.toString());
            onCreateMyCreation(sQLiteDatabase);
        }
        if (i < 25) {
            onCreateMyCreation(sQLiteDatabase);
        }
        if (i < 30) {
            StringBuilder sb34 = new StringBuilder();
            sb34.append("ALTER TABLE ");
            sb34.append(SocialConstDef.TBL_NAME_DOWNLOAD);
            sb34.append(" ADD ");
            sb34.append("userdata");
            sb34.append(" TEXT;");
            ExecSQL(sQLiteDatabase, sb34.toString());
            StringBuilder sb35 = new StringBuilder();
            sb35.append("ALTER TABLE ");
            sb35.append(SocialConstDef.TBL_NAME_SNS);
            sb35.append(" ADD ");
            sb35.append("updatetime");
            sb35.append(" LONG DEFAULT 0;");
            ExecSQL(sQLiteDatabase, sb35.toString());
        }
        if (i < 31) {
            onCreateUserInfo(sQLiteDatabase);
        }
        if (i < 34) {
            StringBuilder sb36 = new StringBuilder();
            sb36.append("ALTER TABLE ");
            sb36.append(SocialConstDef.TBL_NAME_USER_INFO);
            sb36.append(" ADD ");
            sb36.append("follows");
            sb36.append(" INTEGER DEFAULT 0;");
            ExecSQL(sQLiteDatabase, sb36.toString());
            StringBuilder sb37 = new StringBuilder();
            sb37.append("ALTER TABLE ");
            sb37.append(SocialConstDef.TBL_NAME_USER_INFO);
            sb37.append(" ADD ");
            sb37.append("device");
            sb37.append(" TEXT;");
            ExecSQL(sQLiteDatabase, sb37.toString());
            StringBuilder sb38 = new StringBuilder();
            sb38.append("ALTER TABLE ");
            sb38.append(SocialConstDef.TBL_NAME_USER_INFO);
            sb38.append(" ADD ");
            sb38.append("location");
            sb38.append(" TEXT;");
            ExecSQL(sQLiteDatabase, sb38.toString());
            StringBuilder sb39 = new StringBuilder();
            sb39.append("ALTER TABLE ");
            sb39.append(SocialConstDef.TBL_NAME_USER_INFO);
            sb39.append(" ADD ");
            sb39.append("description");
            sb39.append(" TEXT;");
            ExecSQL(sQLiteDatabase, sb39.toString());
            StringBuilder sb40 = new StringBuilder();
            sb40.append("ALTER TABLE ");
            sb40.append(SocialConstDef.TBL_NAME_USER_INFO);
            sb40.append(" ADD ");
            sb40.append(SocialConstDef.USER_INFO_BACKGROUND);
            sb40.append(" TEXT;");
            ExecSQL(sQLiteDatabase, sb40.toString());
            StringBuilder sb41 = new StringBuilder();
            sb41.append("ALTER TABLE ");
            sb41.append(SocialConstDef.TBL_NAME_USER_INFO);
            sb41.append(" ADD ");
            sb41.append("gender");
            sb41.append(" INTEGER DEFAULT 2;");
            ExecSQL(sQLiteDatabase, sb41.toString());
            StringBuilder sb42 = new StringBuilder();
            sb42.append("ALTER TABLE ");
            sb42.append(SocialConstDef.TBL_NAME_USER_INFO);
            sb42.append(" ADD ");
            sb42.append("isfllowed");
            sb42.append(" INTEGER DEFAULT 0;");
            ExecSQL(sQLiteDatabase, sb42.toString());
            StringBuilder sb43 = new StringBuilder();
            sb43.append("ALTER TABLE ");
            sb43.append(SocialConstDef.TBL_NAME_USER_INFO);
            sb43.append(" ADD ");
            sb43.append(SocialConstDef.USER_INFO_COUNTRY_ID);
            sb43.append(" TEXT;");
            ExecSQL(sQLiteDatabase, sb43.toString());
            StringBuilder sb44 = new StringBuilder();
            sb44.append("ALTER TABLE ");
            sb44.append(SocialConstDef.TBL_NAME_USER_INFO);
            sb44.append(" ADD ");
            sb44.append(SocialConstDef.USER_INFO_PROVINCE_ID);
            sb44.append(" TEXT;");
            ExecSQL(sQLiteDatabase, sb44.toString());
            StringBuilder sb45 = new StringBuilder();
            sb45.append("ALTER TABLE ");
            sb45.append(SocialConstDef.TBL_NAME_USER_INFO);
            sb45.append(" ADD ");
            sb45.append(SocialConstDef.USER_INFO_CITY_ID);
            sb45.append(" TEXT;");
            ExecSQL(sQLiteDatabase, sb45.toString());
            StringBuilder sb46 = new StringBuilder();
            sb46.append("ALTER TABLE ");
            sb46.append(SocialConstDef.TBL_NAME_USER_INFO);
            sb46.append(" ADD ");
            sb46.append(SocialConstDef.USER_INFO_PUB_VIDEOS);
            sb46.append(" TEXT;");
            ExecSQL(sQLiteDatabase, sb46.toString());
            onCreateFollow(sQLiteDatabase);
        }
        if (i < 35) {
            StringBuilder sb47 = new StringBuilder();
            sb47.append("ALTER TABLE ");
            sb47.append(SocialConstDef.TBL_NAME_USER_INFO);
            sb47.append(" ADD ");
            sb47.append(SocialConstDef.USER_INFO_ACCOUNT_FLAG);
            sb47.append(" TEXT;");
            ExecSQL(sQLiteDatabase, sb47.toString());
        }
        if (i < 36) {
            StringBuilder sb48 = new StringBuilder();
            sb48.append("ALTER TABLE ");
            sb48.append(SocialConstDef.TBL_NAME_USER_INFO);
            sb48.append(" ADD ");
            sb48.append(SocialConstDef.USER_INFO_UNIQUE_FLAG);
            sb48.append(" TEXT;");
            ExecSQL(sQLiteDatabase, sb48.toString());
        }
        if (i < 37) {
            onCreateRecommendUsers(sQLiteDatabase);
            StringBuilder sb49 = new StringBuilder();
            sb49.append("ALTER TABLE ");
            sb49.append(SocialConstDef.TBL_NAME_MESSAGE);
            sb49.append(" ADD ");
            sb49.append(SocialConstDef.MESSAGE_SENDER_AUID);
            sb49.append(" TEXT;");
            ExecSQL(sQLiteDatabase, sb49.toString());
            StringBuilder sb50 = new StringBuilder();
            sb50.append("ALTER TABLE ");
            sb50.append(SocialConstDef.TBL_NAME_MESSAGE);
            sb50.append(" ADD ");
            sb50.append(SocialConstDef.MESSAGE_SENDER_NICKNAME);
            sb50.append(" TEXT;");
            ExecSQL(sQLiteDatabase, sb50.toString());
            StringBuilder sb51 = new StringBuilder();
            sb51.append("ALTER TABLE ");
            sb51.append(SocialConstDef.TBL_NAME_MESSAGE);
            sb51.append(" ADD ");
            sb51.append(SocialConstDef.MESSAGE_SENDER_AVATAR);
            sb51.append(" TEXT;");
            ExecSQL(sQLiteDatabase, sb51.toString());
            StringBuilder sb52 = new StringBuilder();
            sb52.append("ALTER TABLE ");
            sb52.append(SocialConstDef.TBL_NAME_MESSAGE);
            sb52.append(" ADD ");
            sb52.append(SocialConstDef.MESSAGE_SENDER_GENDER);
            sb52.append(" TEXT;");
            ExecSQL(sQLiteDatabase, sb52.toString());
            StringBuilder sb53 = new StringBuilder();
            sb53.append("ALTER TABLE ");
            sb53.append(SocialConstDef.TBL_NAME_MESSAGE);
            sb53.append(" ADD ");
            sb53.append(SocialConstDef.MESSAGE_SENDER_LEVEL);
            sb53.append(" TEXT;");
            ExecSQL(sQLiteDatabase, sb53.toString());
            StringBuilder sb54 = new StringBuilder();
            sb54.append("ALTER TABLE ");
            sb54.append(SocialConstDef.TBL_NAME_MESSAGE);
            sb54.append(" ADD ");
            sb54.append(SocialConstDef.MESSAGE_REQUEST_FLAG);
            sb54.append(" TEXT;");
            ExecSQL(sQLiteDatabase, sb54.toString());
        }
        if (i < 38) {
            StringBuilder sb55 = new StringBuilder();
            sb55.append("ALTER TABLE ");
            sb55.append(SocialConstDef.TBL_NAME_FOLLOW);
            sb55.append(" ADD ");
            sb55.append("owner");
            sb55.append(" TEXT;");
            ExecSQL(sQLiteDatabase, sb55.toString());
            StringBuilder sb56 = new StringBuilder();
            sb56.append("ALTER TABLE ");
            sb56.append(SocialConstDef.TBL_NAME_FOLLOW);
            sb56.append(" ADD ");
            sb56.append("updatetime");
            sb56.append(" LONG DEFAULT 0;");
            ExecSQL(sQLiteDatabase, sb56.toString());
        }
        if (i < 39) {
            StringBuilder sb57 = new StringBuilder();
            sb57.append("ALTER TABLE ");
            sb57.append(SocialConstDef.TBL_NAME_FOLLOW);
            sb57.append(" ADD ");
            sb57.append("desc");
            sb57.append(" TEXT;");
            ExecSQL(sQLiteDatabase, sb57.toString());
        }
        if (i < 40) {
            StringBuilder sb58 = new StringBuilder();
            sb58.append("ALTER TABLE ");
            sb58.append(SocialConstDef.TBL_NAME_USER_INFO);
            sb58.append(" ADD ");
            sb58.append(SocialConstDef.USER_INFO_ACCOUNT_FLAG);
            sb58.append(" TEXT;");
            ExecSQL(sQLiteDatabase, sb58.toString());
        }
        if (i < 44) {
            StringBuilder sb59 = new StringBuilder();
            sb59.append("ALTER TABLE ");
            sb59.append(SocialConstDef.TBL_NAME_MESSAGE);
            sb59.append(" ADD ");
            sb59.append("category");
            sb59.append(" INTEGER;");
            ExecSQL(sQLiteDatabase, sb59.toString());
        }
        if (i < 45) {
            onCreateChatContact(sQLiteDatabase);
            onCreateBlackList(sQLiteDatabase);
        }
        if (i < 50) {
            ExecSQL(sQLiteDatabase, "Drop Table Follow");
            onCreateFollow(sQLiteDatabase);
        }
        if (i < 52) {
            onCreateMyCreation(sQLiteDatabase);
        }
        if (i < 56) {
            StringBuilder sb60 = new StringBuilder();
            sb60.append("ALTER TABLE ");
            sb60.append(SocialConstDef.TBL_NAME_USER_INFO);
            sb60.append(" ADD ");
            sb60.append(SocialConstDef.USER_INFO_IN_BLACK_LIST);
            sb60.append(" INTEGER DEFAULT 0;");
            ExecSQL(sQLiteDatabase, sb60.toString());
            StringBuilder sb61 = new StringBuilder();
            sb61.append("ALTER TABLE ");
            sb61.append(SocialConstDef.TBL_NAME_USER_INFO);
            sb61.append(" ADD ");
            sb61.append("state");
            sb61.append(" TEXT;");
            ExecSQL(sQLiteDatabase, sb61.toString());
        }
        if (i < 61) {
            StringBuilder sb62 = new StringBuilder();
            sb62.append("ALTER TABLE ");
            sb62.append(SocialConstDef.TBL_NAME_USER_INFO);
            sb62.append(" ADD ");
            sb62.append(SocialConstDef.USER_SNS_INFO);
            sb62.append(" TEXT;");
            ExecSQL(sQLiteDatabase, sb62.toString());
        }
        if (i < 62) {
            StringBuilder sb63 = new StringBuilder();
            sb63.append("ALTER TABLE ");
            sb63.append(SocialConstDef.TBL_NAME_RECOMMED_USERS);
            sb63.append(" ADD ");
            sb63.append(SocialConstDef.RECOMMEND_USER_VIDEOLIST);
            sb63.append(" TEXT;");
            ExecSQL(sQLiteDatabase, sb63.toString());
        }
        if (i < 63) {
            StringBuilder sb64 = new StringBuilder();
            sb64.append("ALTER TABLE ");
            sb64.append(SocialConstDef.TBL_NAME_FOLLOW);
            sb64.append(" ADD ");
            sb64.append(SocialConstDef.FOLLOW_USERSTATE);
            sb64.append(" INTEGER DEFAULT 1;");
            ExecSQL(sQLiteDatabase, sb64.toString());
        }
        if (i < 68) {
            onCreateMixedPageTable(sQLiteDatabase);
            onCreateCustomizedUserTable(sQLiteDatabase);
        }
        if (i < 69) {
            StringBuilder sb65 = new StringBuilder();
            sb65.append("ALTER TABLE ");
            sb65.append(SocialConstDef.TBL_NAME_CUSTOMIZED_USER);
            sb65.append(" ADD ");
            sb65.append("moduleId");
            sb65.append(" TEXT;");
            ExecSQL(sQLiteDatabase, sb65.toString());
        }
        if (i < 70) {
            ExecSQL(sQLiteDatabase, "Drop Table MixedPage");
            onCreateMixedPageTable(sQLiteDatabase);
            StringBuilder sb66 = new StringBuilder();
            sb66.append("ALTER TABLE ");
            sb66.append(SocialConstDef.TBL_NAME_USER_INFO);
            sb66.append(" ADD ");
            sb66.append(SocialConstDef.USER_VERIFIED_INFO);
            sb66.append(" TEXT;");
            ExecSQL(sQLiteDatabase, sb66.toString());
        }
        if (i < 72) {
            upgrade4V71(sQLiteDatabase);
        }
        if (i < 73) {
            upgrade4V72(sQLiteDatabase);
        }
        if (i < 74) {
            onCreateOperationItems(sQLiteDatabase);
        }
        if (i < 75) {
            upgrade4V74(sQLiteDatabase);
        }
        if (i < 77) {
            StringBuilder sb67 = new StringBuilder();
            sb67.append("ALTER TABLE ");
            sb67.append(SocialConstDef.TBL_NAME_PUBLISH);
            sb67.append(" ADD ");
            sb67.append(SocialConstDef.PUBLISH_COVER_TEXT);
            sb67.append(" TEXT;");
            ExecSQL(sQLiteDatabase, sb67.toString());
            StringBuilder sb68 = new StringBuilder();
            sb68.append("ALTER TABLE ");
            sb68.append(SocialConstDef.TBL_NAME_PUBLISH);
            sb68.append(" ADD ");
            sb68.append(SocialConstDef.PUBLISH_VIDEO_TEXT);
            sb68.append(" TEXT;");
            ExecSQL(sQLiteDatabase, sb68.toString());
        }
        if (i < 79) {
            StringBuilder sb69 = new StringBuilder();
            sb69.append("ALTER TABLE ");
            sb69.append(SocialConstDef.TBL_NAME_USER_INFO);
            sb69.append(" ADD ");
            sb69.append("privacy");
            sb69.append(" INTEGER;");
            ExecSQL(sQLiteDatabase, sb69.toString());
            StringBuilder sb70 = new StringBuilder();
            sb70.append("ALTER TABLE ");
            sb70.append(SocialConstDef.TBL_NAME_USER_INFO);
            sb70.append(" ADD ");
            sb70.append(SocialConstDef.USER_ISFOLLOWAPPLY);
            sb70.append(" INTEGER;");
            ExecSQL(sQLiteDatabase, sb70.toString());
            onCreateFollowRequestList(sQLiteDatabase);
            onCreateMessageListNewTable(sQLiteDatabase);
        }
        if (i < 82) {
            StringBuilder sb71 = new StringBuilder();
            sb71.append("ALTER TABLE ");
            sb71.append(SocialConstDef.TBL_NAME_MESSAGE_LIST_NEW);
            sb71.append(" ADD ");
            sb71.append("source");
            sb71.append(" TEXT;");
            ExecSQL(sQLiteDatabase, sb71.toString());
            StringBuilder sb72 = new StringBuilder();
            sb72.append("ALTER TABLE ");
            sb72.append(SocialConstDef.TBL_NAME_MESSAGE_LIST_NEW);
            sb72.append(" ADD ");
            sb72.append("format");
            sb72.append(" INTEGER;");
            ExecSQL(sQLiteDatabase, sb72.toString());
            StringBuilder sb73 = new StringBuilder();
            sb73.append("ALTER TABLE ");
            sb73.append(SocialConstDef.TBL_NAME_MESSAGE_LIST_NEW);
            sb73.append(" ADD ");
            sb73.append(SocialConstDef.MESSAGE_LIST_NEW_RELATION);
            sb73.append(" INTEGER;");
            ExecSQL(sQLiteDatabase, sb73.toString());
            StringBuilder sb74 = new StringBuilder();
            sb74.append("ALTER TABLE ");
            sb74.append(SocialConstDef.TBL_NAME_MESSAGE_LIST_NEW);
            sb74.append(" ADD ");
            sb74.append(SocialConstDef.MESSAGE_LIST_NEW_TOGETHER_TYPE);
            sb74.append(" INTEGER;");
            ExecSQL(sQLiteDatabase, sb74.toString());
            StringBuilder sb75 = new StringBuilder();
            sb75.append("ALTER TABLE ");
            sb75.append(SocialConstDef.TBL_NAME_MESSAGE_LIST_NEW);
            sb75.append(" ADD ");
            sb75.append(SocialConstDef.MESSAGE_LIST_NEW_TOGETHER_TOTAL_COUNT);
            sb75.append(" INTEGER;");
            ExecSQL(sQLiteDatabase, sb75.toString());
        }
        if (i < 83) {
            onCreateRecserList(sQLiteDatabase);
        }
        if (i < 85) {
            StringBuilder sb76 = new StringBuilder();
            sb76.append("ALTER TABLE ");
            sb76.append(SocialConstDef.TBL_NAME_RECOMMEND_USER_LIST);
            sb76.append(" ADD ");
            sb76.append(SocialConstDef.RECOMMEND_USER_LIST_ABVERSION);
            sb76.append(" TEXT;");
            ExecSQL(sQLiteDatabase, sb76.toString());
            StringBuilder sb77 = new StringBuilder();
            sb77.append("ALTER TABLE ");
            sb77.append(SocialConstDef.TBL_NAME_RECOMMEND_USER_LIST);
            sb77.append(" ADD ");
            sb77.append(SocialConstDef.RECOMMEND_USER_LIST_ALGUNIT);
            sb77.append(" TEXT;");
            ExecSQL(sQLiteDatabase, sb77.toString());
            StringBuilder sb78 = new StringBuilder();
            sb78.append("ALTER TABLE ");
            sb78.append(SocialConstDef.TBL_NAME_RECOMMEND_USER_LIST);
            sb78.append(" ADD ");
            sb78.append(SocialConstDef.RECOMMEND_USER_LIST_FANSTOTAL);
            sb78.append(" INTEGER;");
            ExecSQL(sQLiteDatabase, sb78.toString());
            StringBuilder sb79 = new StringBuilder();
            sb79.append("ALTER TABLE ");
            sb79.append(SocialConstDef.TBL_NAME_RECOMMEND_USER_LIST);
            sb79.append(" ADD ");
            sb79.append(SocialConstDef.RECOMMEND_USER_LIST_TAGS);
            sb79.append(" TEXT;");
            ExecSQL(sQLiteDatabase, sb79.toString());
            onCreateFollowedUserList(sQLiteDatabase);
        }
        if (i < 86) {
            StringBuilder sb80 = new StringBuilder();
            sb80.append("ALTER TABLE ");
            sb80.append(SocialConstDef.TBL_NAME_FOLLOWED_USER_LIST);
            sb80.append(" ADD ");
            sb80.append(SocialConstDef.FOLLOWED_USER_LIST_FOLLOWSTATE);
            sb80.append(" INTEGER;");
            ExecSQL(sQLiteDatabase, sb80.toString());
        }
        if (i < 87) {
            StringBuilder sb81 = new StringBuilder();
            sb81.append("ALTER TABLE ");
            sb81.append(SocialConstDef.TBL_NAME_PUBLISH);
            sb81.append(" ADD ");
            sb81.append("referredUsers");
            sb81.append(" TEXT;");
            ExecSQL(sQLiteDatabase, sb81.toString());
        }
        if (i < 88) {
            StringBuilder sb82 = new StringBuilder();
            sb82.append("ALTER TABLE ");
            sb82.append(SocialConstDef.TBL_NAME_MIXED_PAGE);
            sb82.append(" ADD ");
            sb82.append("desc");
            sb82.append(" TEXT;");
            ExecSQL(sQLiteDatabase, sb82.toString());
        }
        if (i < 89) {
            ExecSQL(sQLiteDatabase, "Drop Table MessageListNew");
            onCreateMessageListNewTable(sQLiteDatabase);
        }
        if (i < 92) {
            ExecSQL(sQLiteDatabase, "DROP VIEW IF EXISTS VideoShowView");
            ExecSQL(sQLiteDatabase, "DROP VIEW IF EXISTS UsersVideosView");
            ExecSQL(sQLiteDatabase, "DROP VIEW IF EXISTS VideoDetailView");
            ExecSQL(sQLiteDatabase, "DROP VIEW IF EXISTS FollowedVideoView");
            ExecSQL(sQLiteDatabase, "DROP VIEW IF EXISTS SearchedVideosView");
            ExecSQL(sQLiteDatabase, "DROP VIEW IF EXISTS LBSVideosView");
            ExecSQL(sQLiteDatabase, "DROP VIEW IF EXISTS ActivityVideoView");
            ExecSQL(sQLiteDatabase, "DROP VIEW IF EXISTS LikedVideoView");
            ExecSQL(sQLiteDatabase, "DROP TABLE IF EXISTS Upload");
            ExecSQL(sQLiteDatabase, "DROP TABLE IF EXISTS People");
            ExecSQL(sQLiteDatabase, "DROP TABLE IF EXISTS MusicAddedHistory");
            ExecSQL(sQLiteDatabase, "DROP TABLE IF EXISTS MainPage");
            ExecSQL(sQLiteDatabase, "DROP TABLE IF EXISTS FollowedVideo");
            ExecSQL(sQLiteDatabase, "DROP TABLE IF EXISTS Thumbnail");
            ExecSQL(sQLiteDatabase, "DROP TABLE IF EXISTS Video");
            ExecSQL(sQLiteDatabase, "DROP TABLE IF EXISTS VideoReviews");
            ExecSQL(sQLiteDatabase, "DROP TABLE IF EXISTS VideoDetail");
            ExecSQL(sQLiteDatabase, "DROP TABLE IF EXISTS UsersVideos");
            ExecSQL(sQLiteDatabase, "DROP TABLE IF EXISTS LikedVideo");
            ExecSQL(sQLiteDatabase, "DROP TABLE IF EXISTS TemplateFavorite");
            ExecSQL(sQLiteDatabase, "DROP TABLE IF EXISTS TemplateSceneDemo");
            ExecSQL(sQLiteDatabase, "DROP TABLE IF EXISTS ActivityPage");
            ExecSQL(sQLiteDatabase, "DROP TABLE IF EXISTS ActivityVideo");
            ExecSQL(sQLiteDatabase, "DROP TABLE IF EXISTS User");
            ExecSQL(sQLiteDatabase, "DROP TABLE IF EXISTS TemplateDownload");
            ExecSQL(sQLiteDatabase, "DROP TABLE IF EXISTS OnlineTask");
            ExecSQL(sQLiteDatabase, "DROP TABLE IF EXISTS Comment");
            ExecSQL(sQLiteDatabase, "DROP TABLE IF EXISTS LikedVideoNew");
            ExecSQL(sQLiteDatabase, "DROP TABLE IF EXISTS Project");
            ExecSQL(sQLiteDatabase, "DROP TABLE IF EXISTS Clip");
            ExecSQL(sQLiteDatabase, "DROP TABLE IF EXISTS ClipRef");
            ExecSQL(sQLiteDatabase, "DROP TABLE IF EXISTS TemplateLockInfo");
            ExecSQL(sQLiteDatabase, "DROP TABLE IF EXISTS ActivityHotEvent");
            ExecSQL(sQLiteDatabase, "DROP TABLE IF EXISTS ActivityJoinDetail");
            ExecSQL(sQLiteDatabase, "DROP TABLE IF EXISTS URLCache");
            ExecSQL(sQLiteDatabase, "DROP TABLE IF EXISTS Splash");
            ExecSQL(sQLiteDatabase, "DROP TABLE IF EXISTS MediaItem");
            ExecSQL(sQLiteDatabase, "DROP TABLE IF EXISTS UserVideos");
            ExecSQL(sQLiteDatabase, "DROP TABLE IF EXISTS VideoCard");
            ExecSQL(sQLiteDatabase, "DROP TABLE IF EXISTS VideoShowNew");
            ExecSQL(sQLiteDatabase, "DROP TABLE IF EXISTS UsersVideosNew");
            ExecSQL(sQLiteDatabase, "DROP TABLE IF EXISTS VideoDetailNew");
            ExecSQL(sQLiteDatabase, "DROP TABLE IF EXISTS FollowedVideoNew");
            ExecSQL(sQLiteDatabase, "DROP TABLE IF EXISTS SearchedVideosNew");
            ExecSQL(sQLiteDatabase, "DROP TABLE IF EXISTS LBSVideosNew");
            ExecSQL(sQLiteDatabase, "DROP TABLE IF EXISTS ActivityVideoNew");
        }
        if (i < 93) {
            StringBuilder sb83 = new StringBuilder();
            sb83.append("ALTER TABLE ");
            sb83.append(SocialConstDef.TBL_NAME_PUBLISH);
            sb83.append(" ADD ");
            sb83.append(SocialConstDef.PUBLISH_VIDEO_LANGUAGE);
            sb83.append(" TEXT;");
            ExecSQL(sQLiteDatabase, sb83.toString());
        }
        if (i < 94) {
            PublishTaskTable.onCreatePublishTaskTable(sQLiteDatabase);
        }
        if (i < 95) {
            StringBuilder sb84 = new StringBuilder();
            sb84.append("ALTER TABLE ");
            sb84.append(PublishTaskTable.TBL_NAME_PUBLISH_TASK);
            sb84.append(" ADD ");
            sb84.append(PublishTaskTable.PARAM_PUBLISH_TASK_OLD_DATA);
            sb84.append(" TEXT;");
            ExecSQL(sQLiteDatabase, sb84.toString());
            PublishTaskTable.changeOldPublishToNew(sQLiteDatabase);
        }
        if (i < 96) {
            try {
                StringBuilder sb85 = new StringBuilder();
                sb85.append("ALTER TABLE ");
                sb85.append(PublishTaskTable.TBL_NAME_PUBLISH_TASK);
                sb85.append(" ADD ");
                sb85.append(PublishTaskTable.PARAM_PUBLISH_TASK_VIDEO_WIDTH);
                sb85.append(" INTEGER DEFAULT 0;");
                ExecSQL(sQLiteDatabase, sb85.toString());
                StringBuilder sb86 = new StringBuilder();
                sb86.append("ALTER TABLE ");
                sb86.append(PublishTaskTable.TBL_NAME_PUBLISH_TASK);
                sb86.append(" ADD ");
                sb86.append(PublishTaskTable.PARAM_PUBLISH_TASK_VIDEO_HEIGHT);
                sb86.append(" INTEGER DEFAULT 0;");
                ExecSQL(sQLiteDatabase, sb86.toString());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        if (i < 97) {
            StringBuilder sb87 = new StringBuilder();
            sb87.append("ALTER TABLE ");
            sb87.append(SocialConstDef.TBL_NAME_MIXED_PAGE);
            sb87.append(" ADD ");
            sb87.append("traceId");
            sb87.append(" TEXT;");
            ExecSQL(sQLiteDatabase, sb87.toString());
        }
    }
}
