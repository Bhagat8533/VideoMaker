package com.introvd.template.datacenter;

import android.annotation.TargetApi;
import android.content.ContentProvider;
import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.OperationApplicationException;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.CursorWrapper;
import android.database.DatabaseUtils;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.SparseIntArray;
import com.aiii.sdk.android.oss.common.RequestParameters;
import com.introvd.template.datacenter.social.PublishTaskTable;
import java.lang.reflect.Field;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class SocialProvider extends ContentProvider {
    private static final int ACTIVITY_HOTEVENTS = 28003;
    private static final int ACTIVITY_JOINDETAILS = 28007;
    private static final int ACTIVITY_LISTS = 28005;
    private static final int ACTIVITY_VIDEOS = 31201;
    private static final int ACTIVITY_VIDEOS_VIEW = 31301;
    private static final int APP_ACCOUNT = 20007;
    private static final int APP_GENERAL = 20005;
    private static final int BANNER_PAGES = 28001;
    private static final int BLACK_LIST = 5409;
    private static final int CHAT_CONTACT = 5407;
    private static final int CUSTOMIZED_USER = 5417;
    private static final int DOWNLOADS = 1101;
    private static final int DOWNLOADS_KEY = 1102;
    private static final int DYNAMIC_FEATURE = 28017;
    private static final int FOLLOW = 5403;
    private static final int FOLLOWED_USER_LIST = 5429;
    private static final int FOLLOWED_VIDEO = 31207;
    private static final int FOLLOWED_VIDEO_VIEW = 31307;
    private static final int FOLLOW_REQUEST_LIST = 5425;
    private static final int GLOBAL_TBL_END = 30000;
    private static final int GLOBAL_TBL_START = 20000;
    private static final int INSIDE_BACKUP = 40002;
    private static final int INSIDE_CLOSE = 40003;
    private static final int INSIDE_END = 41001;
    private static final int INSIDE_START = 40001;
    private static final int KEYVALUES = 1701;
    private static final String KEY_SQL_GROUPBY = "group by";
    private static final int LBS_VIDEOS = 31215;
    private static final int LBS_VIDEOS_VIEW = 31315;
    private static final int MEDIA_ITEMS = 25003;
    private static final int MEM_SHARES = 20001;
    private static final int MESSAGES = 1501;
    private static final int MESSAGES_KEY = 1502;
    private static final int MESSAGE_LIST_NEW = 5423;
    private static final int MIXED_PAGE = 5415;
    private static final int MYCREATION = 11;
    private static final int OPERATION_ITEMS = 5421;
    private static final int POPUP_WINDOW = 28027;
    private static final int PRIVATE_USER_TBL_END = 10000;
    private static final int PRIVATE_USER_TBL_START = 0;
    private static final int PUBLISHS = 301;
    private static final int PUBLISHS_KEY = 302;
    private static final int PUBLISHS_TASK = 401;
    private static final int PUBLISHS_TASK_KEY = 402;
    private static final int PUSH_TAG = 28023;
    private static final int RAW_JOIN = 2301;
    private static final int RECOMMED_TAGUSERS = 5419;
    private static final int RECOMMED_USERS = 5405;
    private static final int RECOMMEND_USER_LIST = 5427;
    private static final int SEARCHED_USERS = 28009;
    private static final int SEARCHED_VIDEOS = 31203;
    private static final int SEARCHED_VIDEOS_VIEW = 31303;
    private static final int SEARCH_HISTORY = 28013;
    private static final int SHARES = 1601;
    private static final int SHARES_KEY = 1602;
    private static final int SNSS = 1401;
    private static final int SNSS_KEY = 1402;
    private static final int SNS_CONFIG = 28025;
    private static final int SPLASH_ITEMS = 25001;
    private static final int SQLLITE_SEQUENCES = 29997;
    private static final int SQLLITE_SEQUENCES_KEY = 29998;
    private static final String TAG = "SocialProvider";
    private static final int TASKS = 1301;
    private static final int TASKS_JOIN_PROJECT = 2201;
    private static final int TASKS_JOIN_PUBLISH = 2101;
    private static final int TASKS_KEY = 1302;
    private static final int TEMPLATEROLLMAP_ITEMS = 37909;
    private static final int TEMPLATES = 37701;
    private static final int TEMPLATES_KEY = 73702;
    private static final int TEMPLATE_CARDS = 37803;
    private static final int TEMPLATE_FONT_INFO_ITEMS = 37913;
    private static final int TEMPLATE_INFOS = 37851;
    private static final int TEMPLATE_INFOS_VIEW = 37853;
    private static final int TEMPLATE_INFO_RECOMMEND = 37815;
    private static final int TEMPLATE_LOCK_INFO_ITEMS = 37911;
    private static final int TEMPLATE_PACKAGES = 37809;
    private static final int TEMPLATE_PACKAGE_DETAILS = 37857;
    private static final int TEMPLATE_PACKAGE_DETAILS_VIEW = 37859;
    private static final int TEMPLATE_RECOMMEND_ROLL = 37813;
    private static final int TEMPLATE_ROLL = 37811;
    private static final int TEMPLATE_SCENES = 37807;
    private static final int TEMPLATE_TBL_END = 39000;
    private static final int TEMPLATE_TBL_START = 36000;
    private static final int TOP_USER = 28035;
    private static final int URLCACHES = 26201;
    private static final int URLCACHES_KEY = 46202;
    private static final int USERS_VIDEOS_PAGES = 31209;
    private static final int USERS_VIDEOS_PAGES_VIEW = 31309;
    private static final int USER_INFO_PAGES = 5413;
    private static final int USER_VIDEOS = 31001;
    private static final int VIDEO_CARDS = 31199;
    private static final int VIDEO_DETAIL = 31205;
    private static final int VIDEO_DETAIL_VIEW = 31305;
    private static final int VIDEO_SHOW_PAGES = 31213;
    private static final int VIDEO_SHOW_PAGES_VIEW = 31313;
    private static final int VIDEO_TBL_END = 35000;
    private static final int VIDEO_TBL_START = 30000;
    private static final int VIEW_BASE_DIFF = 100;
    private static final int XY_GOODS_ITEM_INFO = 28033;
    private static final Object mDBTransactionSync = new Object();
    private static SocialSecurity mSocialSecurity;
    private static final HashMap<Integer, String> mTableMap = new LinkedHashMap();
    private static final UriMatcher sURLMatcher = new UriMatcher(-1);
    private volatile boolean closeDBFake = false;
    private AppGlobalDBHelper mAppGlobalDB = null;
    private final Executor mServiceExecutor = Executors.newCachedThreadPool();
    private SocialDBHelper mSocialDB = null;
    private String mStrAuthority = null;
    private TemplateDBHelper mTemplageDB = null;
    private VideoDBHelper mVideoDB = null;
    private final SparseIntArray s_TransactingUri = new SparseIntArray();

    static {
        mTableMap.put(Integer.valueOf(301), SocialConstDef.TBL_NAME_PUBLISH);
        mTableMap.put(Integer.valueOf(302), "Publish/#");
        mTableMap.put(Integer.valueOf(401), PublishTaskTable.TBL_NAME_PUBLISH_TASK);
        mTableMap.put(Integer.valueOf(402), "Publish_Task/#");
        mTableMap.put(Integer.valueOf(1101), SocialConstDef.TBL_NAME_DOWNLOAD);
        mTableMap.put(Integer.valueOf(1102), "Download/*");
        mTableMap.put(Integer.valueOf(1301), SocialConstDef.TBL_NAME_TASK);
        mTableMap.put(Integer.valueOf(1302), "Task/*");
        mTableMap.put(Integer.valueOf(1401), SocialConstDef.TBL_NAME_SNS);
        mTableMap.put(Integer.valueOf(SNSS_KEY), "SNS/*");
        mTableMap.put(Integer.valueOf(MESSAGES), SocialConstDef.TBL_NAME_MESSAGE);
        mTableMap.put(Integer.valueOf(MESSAGES_KEY), "Message/*");
        mTableMap.put(Integer.valueOf(SHARES), SocialConstDef.TBL_NAME_SHARE);
        mTableMap.put(Integer.valueOf(SHARES_KEY), "Share/*");
        mTableMap.put(Integer.valueOf(SQLLITE_SEQUENCES), SocialConstDef.TBL_NAME_SQLITE_SEQUENCE);
        mTableMap.put(Integer.valueOf(SQLLITE_SEQUENCES_KEY), "sqlite_sequence/*");
        mTableMap.put(Integer.valueOf(2201), SocialConstDef.TBL_NAME_TASK_JOIN_PROJECT);
        mTableMap.put(Integer.valueOf(2101), SocialConstDef.TBL_NAME_TASK_JOIN_PUBLISH);
        mTableMap.put(Integer.valueOf(2301), "RawJoin/*");
        mTableMap.put(Integer.valueOf(KEYVALUES), SocialConstDef.TBL_NAME_KEYVALUEMAP);
        mTableMap.put(Integer.valueOf(11), SocialConstDef.TBL_NAME_MYCREATION);
        mTableMap.put(Integer.valueOf(USER_INFO_PAGES), SocialConstDef.TBL_NAME_USER_INFO);
        mTableMap.put(Integer.valueOf(FOLLOW), SocialConstDef.TBL_NAME_FOLLOW);
        mTableMap.put(Integer.valueOf(RECOMMED_USERS), SocialConstDef.TBL_NAME_RECOMMED_USERS);
        mTableMap.put(Integer.valueOf(RECOMMED_TAGUSERS), SocialConstDef.TBL_NAME_RECOMMED_TAGUSERS);
        mTableMap.put(Integer.valueOf(OPERATION_ITEMS), SocialConstDef.TBL_NAME_OPERATION_ITEMS);
        mTableMap.put(Integer.valueOf(MESSAGE_LIST_NEW), SocialConstDef.TBL_NAME_MESSAGE_LIST_NEW);
        mTableMap.put(Integer.valueOf(FOLLOW_REQUEST_LIST), SocialConstDef.TBL_NAME_FOLLOW_REQUEST_LIST);
        mTableMap.put(Integer.valueOf(RECOMMEND_USER_LIST), SocialConstDef.TBL_NAME_RECOMMEND_USER_LIST);
        mTableMap.put(Integer.valueOf(FOLLOWED_USER_LIST), SocialConstDef.TBL_NAME_FOLLOWED_USER_LIST);
        mTableMap.put(Integer.valueOf(CHAT_CONTACT), SocialConstDef.TBL_NAME_CHAT_CONTACT);
        mTableMap.put(Integer.valueOf(BLACK_LIST), SocialConstDef.TBL_NAME_BLACK_LIST);
        mTableMap.put(Integer.valueOf(MIXED_PAGE), SocialConstDef.TBL_NAME_MIXED_PAGE);
        mTableMap.put(Integer.valueOf(CUSTOMIZED_USER), SocialConstDef.TBL_NAME_CUSTOMIZED_USER);
        mTableMap.put(Integer.valueOf(APP_GENERAL), SocialConstDef.TBL_NAME_GENERAL_APP);
        mTableMap.put(Integer.valueOf(MEM_SHARES), SocialConstDef.TBL_NAME_MEMORY_SHARES);
        mTableMap.put(Integer.valueOf(APP_ACCOUNT), SocialConstDef.TBL_NAME_SOCIAL_ACCOUNT);
        mTableMap.put(Integer.valueOf(BANNER_PAGES), SocialConstDef.TBL_NAME_BANNER_PAGE);
        mTableMap.put(Integer.valueOf(SEARCHED_USERS), SocialConstDef.TBL_NAME_SEARCHED_USERS);
        mTableMap.put(Integer.valueOf(SEARCH_HISTORY), SocialConstDef.TBL_NAME_SEARCH_HISTORY);
        mTableMap.put(Integer.valueOf(DYNAMIC_FEATURE), SocialConstDef.TBL_NAME_DYNAMIC_FEATURE);
        mTableMap.put(Integer.valueOf(PUSH_TAG), SocialConstDef.TBL_NAME_PUSH_TAG);
        mTableMap.put(Integer.valueOf(SNS_CONFIG), SocialConstDef.TBL_NAME_SNS_CONFIG);
        mTableMap.put(Integer.valueOf(POPUP_WINDOW), SocialConstDef.TBL_NAME_POPUP_WINDOW_INFO);
        mTableMap.put(Integer.valueOf(XY_GOODS_ITEM_INFO), SocialConstDef.TBL_NAME_XY_GOODS_ITEM_INFO);
        mTableMap.put(Integer.valueOf(TOP_USER), SocialConstDef.TBL_NAME_TOP_USER);
        mTableMap.put(Integer.valueOf(SPLASH_ITEMS), SocialConstDef.TBL_NAME_SPLASH);
        mTableMap.put(Integer.valueOf(MEDIA_ITEMS), SocialConstDef.TBL_NAME_MEDIA_ITEM);
        mTableMap.put(Integer.valueOf(URLCACHES), SocialConstDef.TBL_NAME_URLCACHE);
        mTableMap.put(Integer.valueOf(URLCACHES_KEY), "URLCache/*");
        mTableMap.put(Integer.valueOf(ACTIVITY_LISTS), SocialConstDef.TBL_NAME_ACTIVITY_LIST);
        mTableMap.put(Integer.valueOf(ACTIVITY_HOTEVENTS), SocialConstDef.TBL_NAME_ACTIVITY_HOTEVENT);
        mTableMap.put(Integer.valueOf(ACTIVITY_JOINDETAILS), SocialConstDef.TBL_NAME_ACTIVITY_JOIN_DETAIL);
        mTableMap.put(Integer.valueOf(USER_VIDEOS), SocialConstDef.TBL_NAME_USERVIDEOS);
        mTableMap.put(Integer.valueOf(VIDEO_CARDS), SocialConstDef.TBL_NAME_VIDEO_CARD);
        mTableMap.put(Integer.valueOf(SEARCHED_VIDEOS), SocialConstDef.TBL_NAME_SEARCHED_VIDEOS);
        mTableMap.put(Integer.valueOf(VIDEO_SHOW_PAGES), SocialConstDef.TBL_NAME_VIDEO_SHOW);
        mTableMap.put(Integer.valueOf(ACTIVITY_VIDEOS), SocialConstDef.TBL_NAME_ACTIVITY_VIDEOLIST);
        mTableMap.put(Integer.valueOf(USERS_VIDEOS_PAGES), SocialConstDef.TBL_NAME_USERS_VIDEOS);
        mTableMap.put(Integer.valueOf(VIDEO_DETAIL), SocialConstDef.TBL_NAME_VIDEO_DETAIL);
        mTableMap.put(Integer.valueOf(FOLLOWED_VIDEO), SocialConstDef.TBL_NAME_FOLLOWED_VIDEO);
        mTableMap.put(Integer.valueOf(LBS_VIDEOS), SocialConstDef.TBL_NAME_LBS_VIDEOS);
        mTableMap.put(Integer.valueOf(SEARCHED_VIDEOS_VIEW), SocialConstDef.VIEW_NAME_SEARCHED_VIDEOS);
        mTableMap.put(Integer.valueOf(VIDEO_SHOW_PAGES_VIEW), SocialConstDef.VIEW_NAME_VIDEO_SHOW);
        mTableMap.put(Integer.valueOf(ACTIVITY_VIDEOS_VIEW), SocialConstDef.VIEW_NAME_ACTIVITY_VIDEOLIST);
        mTableMap.put(Integer.valueOf(USERS_VIDEOS_PAGES_VIEW), SocialConstDef.VIEW_NAME_USERS_VIDEOS);
        mTableMap.put(Integer.valueOf(VIDEO_DETAIL_VIEW), SocialConstDef.VIEW_NAME_VIDEO_DETAIL);
        mTableMap.put(Integer.valueOf(FOLLOWED_VIDEO_VIEW), SocialConstDef.VIEW_NAME_FOLLOWED_VIDEO);
        mTableMap.put(Integer.valueOf(LBS_VIDEOS_VIEW), SocialConstDef.VIEW_NAME_LBS_VIDEOS);
        mTableMap.put(Integer.valueOf(TEMPLATE_ROLL), SocialConstDef.TBL_NAME_TEMPLATE_ROLL);
        mTableMap.put(Integer.valueOf(TEMPLATE_RECOMMEND_ROLL), SocialConstDef.TBL_NAME_TEMPLATE_RECOMMEND_ROLL);
        mTableMap.put(Integer.valueOf(TEMPLATE_SCENES), SocialConstDef.TBL_NAME_TEMPLATE_SCENE);
        mTableMap.put(Integer.valueOf(TEMPLATE_PACKAGES), SocialConstDef.TBL_NAME_TEMPLATE_PACKAGE);
        mTableMap.put(Integer.valueOf(TEMPLATES), SocialConstDef.TBL_NAME_TEMPLATE);
        mTableMap.put(Integer.valueOf(TEMPLATES_KEY), "Template/#");
        mTableMap.put(Integer.valueOf(TEMPLATEROLLMAP_ITEMS), SocialConstDef.TBL_NAME_TEMPLATE_ROLL_MAP);
        mTableMap.put(Integer.valueOf(TEMPLATE_LOCK_INFO_ITEMS), SocialConstDef.TBL_NAME_TEMPLATE_MONETIZATION);
        mTableMap.put(Integer.valueOf(TEMPLATE_FONT_INFO_ITEMS), SocialConstDef.TBL_NAME_TEMPLATE_FONT_INFO);
        mTableMap.put(Integer.valueOf(TEMPLATE_CARDS), SocialConstDef.TBL_NAME_TEMPLATE_CARD);
        mTableMap.put(Integer.valueOf(TEMPLATE_INFOS), SocialConstDef.TBL_NAME_TEMPLATE_INFO);
        mTableMap.put(Integer.valueOf(TEMPLATE_INFO_RECOMMEND), SocialConstDef.TBL_NAME_TEMPLATE_INFO_RECOMMEND);
        mTableMap.put(Integer.valueOf(TEMPLATE_INFOS_VIEW), SocialConstDef.VIEW_NAME_TEMPLATE_INFO);
        mTableMap.put(Integer.valueOf(TEMPLATE_PACKAGE_DETAILS), SocialConstDef.TBL_NAME_TEMPLATE_PACKAGE_DETAIL);
        mTableMap.put(Integer.valueOf(TEMPLATE_PACKAGE_DETAILS_VIEW), SocialConstDef.VIEW_NAME_TEMPLATE_PACKAGE_DETAIL);
        mTableMap.put(Integer.valueOf(INSIDE_BACKUP), SocialConstDef.TBL_NAME_INSIDE_DB_BACKUP);
        mTableMap.put(Integer.valueOf(INSIDE_CLOSE), SocialConstDef.TBL_NAME_INSIDE_DB_CLOSE);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0089 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00a9 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.content.ContentProviderResult[] applyBatchSync(java.util.ArrayList<android.content.ContentProviderOperation> r10) throws android.content.OperationApplicationException {
        /*
            r9 = this;
            r0 = 0
            if (r10 == 0) goto L_0x00dc
            boolean r1 = r10.isEmpty()
            if (r1 == 0) goto L_0x000b
            goto L_0x00dc
        L_0x000b:
            r1 = 0
            java.lang.Object r2 = r10.get(r1)
            android.content.ContentProviderOperation r2 = (android.content.ContentProviderOperation) r2
            android.net.Uri r2 = r2.getUri()
            android.content.UriMatcher r3 = sURLMatcher
            int r3 = r3.match(r2)
            if (r3 > 0) goto L_0x001f
            return r0
        L_0x001f:
            android.content.Context r4 = r9.getContext()
            com.introvd.template.datacenter.SqliteOpenHelperWithDaemon r4 = r9.getDatabaseHelper(r4, r3)
            if (r4 == 0) goto L_0x00db
            android.database.sqlite.SQLiteDatabase r4 = r4.getWritableDatabase()     // Catch:{ Throwable -> 0x00d3 }
            if (r4 != 0) goto L_0x0030
            return r0
        L_0x0030:
            java.lang.Object r5 = mDBTransactionSync     // Catch:{ Throwable -> 0x00d3 }
            monitor-enter(r5)     // Catch:{ Throwable -> 0x00d3 }
            android.util.SparseIntArray r6 = r9.s_TransactingUri     // Catch:{ all -> 0x00d0 }
            int r6 = r6.get(r3, r1)     // Catch:{ all -> 0x00d0 }
            int r6 = r6 + 1
            android.util.SparseIntArray r7 = r9.s_TransactingUri     // Catch:{ all -> 0x00d0 }
            r7.put(r3, r6)     // Catch:{ all -> 0x00d0 }
            monitor-exit(r5)     // Catch:{ all -> 0x00d0 }
            r4.beginTransaction()     // Catch:{ Throwable -> 0x00d3 }
            android.content.ContentProviderResult[] r10 = super.applyBatch(r10)     // Catch:{ Throwable -> 0x007e, all -> 0x007b }
            r4.setTransactionSuccessful()     // Catch:{ Throwable -> 0x0079 }
            r4.endTransaction()     // Catch:{ Throwable -> 0x00ce }
            java.lang.Object r4 = mDBTransactionSync     // Catch:{ Throwable -> 0x00ce }
            monitor-enter(r4)     // Catch:{ Throwable -> 0x00ce }
            android.util.SparseIntArray r5 = r9.s_TransactingUri     // Catch:{ all -> 0x0074 }
            int r1 = r5.get(r3, r1)     // Catch:{ all -> 0x0074 }
            int r1 = r1 + -1
            if (r1 > 0) goto L_0x0061
            android.util.SparseIntArray r1 = r9.s_TransactingUri     // Catch:{ all -> 0x0074 }
            r1.delete(r3)     // Catch:{ all -> 0x0074 }
            goto L_0x0066
        L_0x0061:
            android.util.SparseIntArray r5 = r9.s_TransactingUri     // Catch:{ all -> 0x0074 }
            r5.put(r3, r1)     // Catch:{ all -> 0x0074 }
        L_0x0066:
            monitor-exit(r4)     // Catch:{ all -> 0x0074 }
            android.content.Context r1 = r9.getContext()     // Catch:{ Throwable -> 0x00ce }
            android.content.ContentResolver r1 = r1.getContentResolver()     // Catch:{ Throwable -> 0x00ce }
            r1.notifyChange(r2, r0)     // Catch:{ Throwable -> 0x00ce }
            goto L_0x00da
        L_0x0074:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0074 }
            throw r0     // Catch:{ Throwable -> 0x00ce }
        L_0x0077:
            r5 = move-exception
            goto L_0x00a3
        L_0x0079:
            r5 = move-exception
            goto L_0x0080
        L_0x007b:
            r5 = move-exception
            r10 = r0
            goto L_0x00a3
        L_0x007e:
            r5 = move-exception
            r10 = r0
        L_0x0080:
            r5.printStackTrace()     // Catch:{ all -> 0x0077 }
            r4.endTransaction()     // Catch:{ Throwable -> 0x00ce }
            java.lang.Object r0 = mDBTransactionSync     // Catch:{ Throwable -> 0x00ce }
            monitor-enter(r0)     // Catch:{ Throwable -> 0x00ce }
            android.util.SparseIntArray r2 = r9.s_TransactingUri     // Catch:{ all -> 0x00a0 }
            int r1 = r2.get(r3, r1)     // Catch:{ all -> 0x00a0 }
            int r1 = r1 + -1
            if (r1 > 0) goto L_0x0099
            android.util.SparseIntArray r1 = r9.s_TransactingUri     // Catch:{ all -> 0x00a0 }
            r1.delete(r3)     // Catch:{ all -> 0x00a0 }
            goto L_0x009e
        L_0x0099:
            android.util.SparseIntArray r2 = r9.s_TransactingUri     // Catch:{ all -> 0x00a0 }
            r2.put(r3, r1)     // Catch:{ all -> 0x00a0 }
        L_0x009e:
            monitor-exit(r0)     // Catch:{ all -> 0x00a0 }
            goto L_0x00da
        L_0x00a0:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00a0 }
            throw r1     // Catch:{ Throwable -> 0x00ce }
        L_0x00a3:
            r4.endTransaction()     // Catch:{ Throwable -> 0x00ce }
            java.lang.Object r4 = mDBTransactionSync     // Catch:{ Throwable -> 0x00ce }
            monitor-enter(r4)     // Catch:{ Throwable -> 0x00ce }
            android.util.SparseIntArray r6 = r9.s_TransactingUri     // Catch:{ all -> 0x00cb }
            int r1 = r6.get(r3, r1)     // Catch:{ all -> 0x00cb }
            int r1 = r1 + -1
            if (r1 > 0) goto L_0x00b9
            android.util.SparseIntArray r1 = r9.s_TransactingUri     // Catch:{ all -> 0x00cb }
            r1.delete(r3)     // Catch:{ all -> 0x00cb }
            goto L_0x00be
        L_0x00b9:
            android.util.SparseIntArray r6 = r9.s_TransactingUri     // Catch:{ all -> 0x00cb }
            r6.put(r3, r1)     // Catch:{ all -> 0x00cb }
        L_0x00be:
            monitor-exit(r4)     // Catch:{ all -> 0x00cb }
            android.content.Context r1 = r9.getContext()     // Catch:{ Throwable -> 0x00ce }
            android.content.ContentResolver r1 = r1.getContentResolver()     // Catch:{ Throwable -> 0x00ce }
            r1.notifyChange(r2, r0)     // Catch:{ Throwable -> 0x00ce }
            throw r5     // Catch:{ Throwable -> 0x00ce }
        L_0x00cb:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x00cb }
            throw r0     // Catch:{ Throwable -> 0x00ce }
        L_0x00ce:
            r0 = move-exception
            goto L_0x00d7
        L_0x00d0:
            r10 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x00d0 }
            throw r10     // Catch:{ Throwable -> 0x00d3 }
        L_0x00d3:
            r10 = move-exception
            r8 = r0
            r0 = r10
            r10 = r8
        L_0x00d7:
            r0.printStackTrace()
        L_0x00da:
            r0 = r10
        L_0x00db:
            return r0
        L_0x00dc:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.datacenter.SocialProvider.applyBatchSync(java.util.ArrayList):android.content.ContentProviderResult[]");
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x000d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void backupDatabase() {
        /*
            r2 = this;
            java.lang.Object r0 = mDBTransactionSync
            monitor-enter(r0)
            com.introvd.template.datacenter.SocialDBHelper r1 = r2.mSocialDB     // Catch:{ Exception -> 0x000d }
            if (r1 == 0) goto L_0x000d
            r1 = 1
            r2.closeDBFake = r1     // Catch:{ Exception -> 0x000d }
            goto L_0x000d
        L_0x000b:
            r1 = move-exception
            goto L_0x000f
        L_0x000d:
            monitor-exit(r0)     // Catch:{ all -> 0x000b }
            return
        L_0x000f:
            monitor-exit(r0)     // Catch:{ all -> 0x000b }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.datacenter.SocialProvider.backupDatabase():void");
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x000d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void closeDatabase() {
        /*
            r2 = this;
            java.lang.Object r0 = mDBTransactionSync
            monitor-enter(r0)
            com.introvd.template.datacenter.SocialDBHelper r1 = r2.mSocialDB     // Catch:{ Exception -> 0x000d }
            if (r1 == 0) goto L_0x000d
            r1 = 1
            r2.closeDBFake = r1     // Catch:{ Exception -> 0x000d }
            goto L_0x000d
        L_0x000b:
            r1 = move-exception
            goto L_0x000f
        L_0x000d:
            monitor-exit(r0)     // Catch:{ all -> 0x000b }
            return
        L_0x000f:
            monitor-exit(r0)     // Catch:{ all -> 0x000b }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.datacenter.SocialProvider.closeDatabase():void");
    }

    @TargetApi(11)
    private void encrypt(SocialSecurity socialSecurity, String str, ContentValues contentValues) {
        if (socialSecurity != null && contentValues != null && contentValues.size() != 0 && VERSION.SDK_INT >= 11) {
            for (String str2 : contentValues.keySet()) {
                try {
                    Object obj = contentValues.get(str2);
                    if (obj instanceof String) {
                        contentValues.put(str2, socialSecurity.onEncrypt(str, str2, (String) obj));
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    private void enforcePermission() {
    }

    private void fillTimestamp(String str, ContentValues contentValues) {
        if (str.equals(SocialConstDef.TBL_NAME_URLCACHE)) {
            String currentSQLTimestamp = getCurrentSQLTimestamp();
            if (!contentValues.containsKey("time")) {
                contentValues.put("time", currentSQLTimestamp);
            }
        } else if (str.equals(SocialConstDef.TBL_NAME_DOWNLOAD)) {
            String currentSQLTimestamp2 = getCurrentSQLTimestamp();
            if (!contentValues.containsKey("time")) {
                contentValues.put("time", currentSQLTimestamp2);
            }
        } else if (str.equals(SocialConstDef.TBL_NAME_TASK)) {
            String currentSQLTimestamp3 = getCurrentSQLTimestamp();
            if (!contentValues.containsKey(SocialConstDef.TASK_STARTTIME)) {
                contentValues.put(SocialConstDef.TASK_STARTTIME, currentSQLTimestamp3);
            }
        } else {
            str.equals(SocialConstDef.TBL_NAME_SHARE);
        }
    }

    private String getCondition(String str, int i) {
        int i2;
        int i3;
        String str2 = null;
        if (str == null || TextUtils.isEmpty(str)) {
            return null;
        }
        if (i == 302) {
            try {
                i2 = Integer.parseInt(str);
            } catch (Exception unused) {
                i2 = 0;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("_id=");
            sb.append(i2);
            str2 = sb.toString();
        } else if (i == 1102) {
            String sqlEscapeString = DatabaseUtils.sqlEscapeString(str);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("_id=");
            sb2.append(sqlEscapeString);
            str2 = sb2.toString();
        } else if (i == 1302) {
            String sqlEscapeString2 = DatabaseUtils.sqlEscapeString(str);
            StringBuilder sb3 = new StringBuilder();
            sb3.append("_id=");
            sb3.append(sqlEscapeString2);
            str2 = sb3.toString();
        } else if (i == SNSS_KEY) {
            String sqlEscapeString3 = DatabaseUtils.sqlEscapeString(str);
            StringBuilder sb4 = new StringBuilder();
            sb4.append("_id=");
            sb4.append(sqlEscapeString3);
            str2 = sb4.toString();
        } else if (i == MESSAGES_KEY) {
            String sqlEscapeString4 = DatabaseUtils.sqlEscapeString(str);
            StringBuilder sb5 = new StringBuilder();
            sb5.append("_id=");
            sb5.append(sqlEscapeString4);
            str2 = sb5.toString();
        } else if (i == SHARES_KEY) {
            String sqlEscapeString5 = DatabaseUtils.sqlEscapeString(str);
            StringBuilder sb6 = new StringBuilder();
            sb6.append("_id=");
            sb6.append(sqlEscapeString5);
            str2 = sb6.toString();
        } else if (i == SQLLITE_SEQUENCES_KEY) {
            String sqlEscapeString6 = DatabaseUtils.sqlEscapeString(str);
            StringBuilder sb7 = new StringBuilder();
            sb7.append("name=");
            sb7.append(sqlEscapeString6);
            str2 = sb7.toString();
        } else if (i == URLCACHES_KEY) {
            String sqlEscapeString7 = DatabaseUtils.sqlEscapeString(str);
            StringBuilder sb8 = new StringBuilder();
            sb8.append("remote=");
            sb8.append(sqlEscapeString7);
            str2 = sb8.toString();
        } else if (i == TEMPLATES_KEY) {
            try {
                i3 = Integer.parseInt(str);
            } catch (Exception unused2) {
                i3 = 0;
            }
            StringBuilder sb9 = new StringBuilder();
            sb9.append("template_id=");
            sb9.append(i3);
            str2 = sb9.toString();
        }
        return str2;
    }

    private String getCurrentSQLTimestamp() {
        return new Timestamp(System.currentTimeMillis()).toString();
    }

    private SqliteOpenHelperWithDaemon getDatabaseHelper(Context context, int i) {
        SqliteOpenHelperWithDaemon sqliteOpenHelperWithDaemon;
        if (i < 20000 || i >= 30000) {
            if (i < 30000 || i >= VIDEO_TBL_END) {
                if (i < TEMPLATE_TBL_START || i >= TEMPLATE_TBL_END) {
                    if (!newDataBaseOnlyNeccessary(context)) {
                        return null;
                    }
                    sqliteOpenHelperWithDaemon = this.mSocialDB;
                } else if (!newTemplateDBOnlyNeccessary(context)) {
                    return null;
                } else {
                    sqliteOpenHelperWithDaemon = this.mTemplageDB;
                }
            } else if (!newVideoDBOnlyNeccessary(context)) {
                return null;
            } else {
                sqliteOpenHelperWithDaemon = this.mVideoDB;
            }
        } else if (!newGlobalDBOnlyNeccessary(context)) {
            return null;
        } else {
            sqliteOpenHelperWithDaemon = this.mAppGlobalDB;
        }
        return sqliteOpenHelperWithDaemon;
    }

    private static String getMyAccountDatabaseBame(Context context) {
        String str;
        String str2;
        ContentResolver contentResolver = context.getContentResolver();
        Cursor query = contentResolver.query(SocialConstDef.getTableUri(SocialConstDef.TBL_NAME_GENERAL_APP), new String[]{"value"}, "key = ?", new String[]{SocialServiceDef.XIAOYING_CURRENT_ACCOUNT}, null);
        if (query != null) {
            str = query.moveToFirst() ? query.getString(0) : null;
            query.close();
        } else {
            str = null;
        }
        if (str == null) {
            return null;
        }
        Cursor query2 = contentResolver.query(SocialConstDef.getTableUri(SocialConstDef.TBL_NAME_SOCIAL_ACCOUNT), new String[]{"path"}, "uid = ?", new String[]{str}, null);
        if (query2 != null) {
            str2 = query2.moveToFirst() ? query2.getString(0) : null;
            query2.close();
        } else {
            str2 = null;
        }
        if (str2 == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str2);
        sb.append("_");
        sb.append(SocialConstDef.getUserDatabaseName(context));
        return sb.toString();
    }

    public static String getRawString(Cursor cursor, int i) {
        Cursor wrapperCursor = getWrapperCursor(cursor);
        if (wrapperCursor instanceof SocialCursor) {
            return getWrapperCursor(wrapperCursor).getString(i);
        }
        return null;
    }

    private String getTableName(int i) {
        if (i == 2101) {
            return "Task left outer join Publish";
        }
        String str = (String) mTableMap.get(Integer.valueOf(i));
        return (str == null || !str.startsWith("PRIVATE_")) ? str : str.substring("PRIVATE_".length());
    }

    private static Cursor getWrapperCursor(Cursor cursor) {
        Field field;
        if (cursor instanceof CursorWrapper) {
            try {
                Field[] declaredFields = CursorWrapper.class.getDeclaredFields();
                int length = declaredFields.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        field = null;
                        break;
                    }
                    field = declaredFields[i];
                    if (field.getName().equals("mCursor")) {
                        break;
                    }
                    i++;
                }
                if (field != null) {
                    field.setAccessible(true);
                    Cursor cursor2 = (Cursor) field.get(cursor);
                    if (cursor2 != null) {
                        return cursor2;
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public static void init(Context context) {
        SocialConstDef.init(context);
    }

    private void initTableMap() {
        if (this.mStrAuthority == null) {
            this.mStrAuthority = SocialConstDef.getSocialProviderUri().getAuthority();
            for (Entry entry : mTableMap.entrySet()) {
                sURLMatcher.addURI(this.mStrAuthority, (String) entry.getValue(), ((Integer) entry.getKey()).intValue());
            }
        }
    }

    private List<String> makeUpdateCondition(Uri uri, ContentValues contentValues) {
        int match = sURLMatcher.match(uri);
        if (match <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (match == VIDEO_CARDS) {
            arrayList.add("auid");
            arrayList.add("puid");
            arrayList.add("pver");
        } else if (match != VIDEO_SHOW_PAGES) {
            if (match == LBS_VIDEOS) {
                arrayList.add("puid");
                arrayList.add("pver");
            } else if (match == TEMPLATE_CARDS) {
                arrayList.add("ttid");
            }
        }
        return arrayList;
    }

    private boolean newDataBaseOnlyNeccessary(Context context) {
        try {
            if (this.mSocialDB == null || this.closeDBFake) {
                String myAccountDatabaseBame = getMyAccountDatabaseBame(context);
                if (myAccountDatabaseBame == null) {
                    return false;
                }
                String databasePath = SocialConstDef.getDatabasePath();
                synchronized (mDBTransactionSync) {
                    if (this.mSocialDB == null || this.closeDBFake) {
                        this.closeDBFake = false;
                        StringBuilder sb = new StringBuilder();
                        sb.append(databasePath);
                        sb.append(myAccountDatabaseBame);
                        this.mSocialDB = new SocialDBHelper(context, sb.toString());
                    }
                }
            }
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    private boolean newGlobalDBOnlyNeccessary(Context context) {
        try {
            if (this.mAppGlobalDB == null) {
                synchronized (mDBTransactionSync) {
                    this.mAppGlobalDB = new AppGlobalDBHelper(context);
                }
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private boolean newTemplateDBOnlyNeccessary(Context context) {
        try {
            if (this.mTemplageDB == null) {
                synchronized (mDBTransactionSync) {
                    this.mTemplageDB = new TemplateDBHelper(context);
                }
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private boolean newVideoDBOnlyNeccessary(Context context) {
        try {
            if (this.mVideoDB == null) {
                synchronized (mDBTransactionSync) {
                    this.mVideoDB = new VideoDBHelper(context);
                }
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private void reportAccessDBEvent(String str, String str2) {
    }

    private void reportError(String str, String str2) {
    }

    public static void setSocialSecurity(SocialSecurity socialSecurity) {
        mSocialSecurity = socialSecurity;
    }

    public ContentProviderResult[] applyBatch(final ArrayList<ContentProviderOperation> arrayList) throws OperationApplicationException {
        ContentProviderResult[] contentProviderResultArr;
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        if (arrayList.size() >= 5) {
            this.mServiceExecutor.execute(new Runnable() {
                public void run() {
                    try {
                        SocialProvider.this.applyBatchSync(arrayList);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
            contentProviderResultArr = new ContentProviderResult[]{new ContentProviderResult(((ContentProviderOperation) arrayList.get(0)).getUri())};
        } else {
            contentProviderResultArr = applyBatchSync(arrayList);
        }
        return contentProviderResultArr;
    }

    /* JADX WARNING: Removed duplicated region for block: B:53:0x0083 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00a5 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int bulkInsert(android.net.Uri r8, android.content.ContentValues[] r9) {
        /*
            r7 = this;
            android.content.UriMatcher r0 = sURLMatcher
            int r0 = r0.match(r8)
            r1 = 0
            if (r0 <= 0) goto L_0x00d5
            if (r9 == 0) goto L_0x00d5
            int r2 = r9.length
            if (r2 != 0) goto L_0x0010
            goto L_0x00d5
        L_0x0010:
            java.lang.System.currentTimeMillis()
            android.content.Context r2 = r7.getContext()
            com.introvd.template.datacenter.SqliteOpenHelperWithDaemon r2 = r7.getDatabaseHelper(r2, r0)
            if (r2 == 0) goto L_0x00d4
            android.database.sqlite.SQLiteDatabase r2 = r2.getWritableDatabase()     // Catch:{ Throwable -> 0x00d0 }
            if (r2 != 0) goto L_0x0024
            return r1
        L_0x0024:
            java.lang.Object r3 = mDBTransactionSync     // Catch:{ Throwable -> 0x00d0 }
            monitor-enter(r3)     // Catch:{ Throwable -> 0x00d0 }
            android.util.SparseIntArray r4 = r7.s_TransactingUri     // Catch:{ all -> 0x00cd }
            int r4 = r4.get(r0, r1)     // Catch:{ all -> 0x00cd }
            int r4 = r4 + 1
            android.util.SparseIntArray r5 = r7.s_TransactingUri     // Catch:{ all -> 0x00cd }
            r5.put(r0, r4)     // Catch:{ all -> 0x00cd }
            monitor-exit(r3)     // Catch:{ all -> 0x00cd }
            r2.beginTransaction()     // Catch:{ Throwable -> 0x00d0 }
            r3 = 0
            int r4 = r9.length     // Catch:{ Throwable -> 0x0078, all -> 0x0075 }
            r5 = 0
        L_0x003b:
            if (r5 >= r4) goto L_0x0047
            r6 = r9[r5]     // Catch:{ Throwable -> 0x0045 }
            r7.insert(r8, r6)     // Catch:{ Throwable -> 0x0045 }
            int r5 = r5 + 1
            goto L_0x003b
        L_0x0045:
            r9 = move-exception
            goto L_0x007a
        L_0x0047:
            r2.setTransactionSuccessful()     // Catch:{ Throwable -> 0x0045 }
            r2.endTransaction()     // Catch:{ Throwable -> 0x00ca }
            java.lang.Object r9 = mDBTransactionSync     // Catch:{ Throwable -> 0x00ca }
            monitor-enter(r9)     // Catch:{ Throwable -> 0x00ca }
            android.util.SparseIntArray r2 = r7.s_TransactingUri     // Catch:{ all -> 0x0072 }
            int r1 = r2.get(r0, r1)     // Catch:{ all -> 0x0072 }
            int r1 = r1 + -1
            if (r1 > 0) goto L_0x0060
            android.util.SparseIntArray r1 = r7.s_TransactingUri     // Catch:{ all -> 0x0072 }
            r1.delete(r0)     // Catch:{ all -> 0x0072 }
            goto L_0x0065
        L_0x0060:
            android.util.SparseIntArray r2 = r7.s_TransactingUri     // Catch:{ all -> 0x0072 }
            r2.put(r0, r1)     // Catch:{ all -> 0x0072 }
        L_0x0065:
            monitor-exit(r9)     // Catch:{ all -> 0x0072 }
            android.content.Context r9 = r7.getContext()     // Catch:{ Throwable -> 0x00ca }
            android.content.ContentResolver r9 = r9.getContentResolver()     // Catch:{ Throwable -> 0x00ca }
            r9.notifyChange(r8, r3)     // Catch:{ Throwable -> 0x00ca }
            goto L_0x0099
        L_0x0072:
            r8 = move-exception
            monitor-exit(r9)     // Catch:{ all -> 0x0072 }
            throw r8     // Catch:{ Throwable -> 0x00ca }
        L_0x0075:
            r9 = move-exception
            r4 = 0
            goto L_0x009f
        L_0x0078:
            r9 = move-exception
            r4 = 0
        L_0x007a:
            r9.printStackTrace()     // Catch:{ all -> 0x009e }
            r2.endTransaction()     // Catch:{ Throwable -> 0x00ca }
            java.lang.Object r8 = mDBTransactionSync     // Catch:{ Throwable -> 0x00ca }
            monitor-enter(r8)     // Catch:{ Throwable -> 0x00ca }
            android.util.SparseIntArray r9 = r7.s_TransactingUri     // Catch:{ all -> 0x009b }
            int r9 = r9.get(r0, r1)     // Catch:{ all -> 0x009b }
            int r9 = r9 + -1
            if (r9 > 0) goto L_0x0093
            android.util.SparseIntArray r9 = r7.s_TransactingUri     // Catch:{ all -> 0x009b }
            r9.delete(r0)     // Catch:{ all -> 0x009b }
            goto L_0x0098
        L_0x0093:
            android.util.SparseIntArray r1 = r7.s_TransactingUri     // Catch:{ all -> 0x009b }
            r1.put(r0, r9)     // Catch:{ all -> 0x009b }
        L_0x0098:
            monitor-exit(r8)     // Catch:{ all -> 0x009b }
        L_0x0099:
            r1 = r4
            goto L_0x00d4
        L_0x009b:
            r9 = move-exception
            monitor-exit(r8)     // Catch:{ all -> 0x009b }
            throw r9     // Catch:{ Throwable -> 0x00ca }
        L_0x009e:
            r9 = move-exception
        L_0x009f:
            r2.endTransaction()     // Catch:{ Throwable -> 0x00ca }
            java.lang.Object r2 = mDBTransactionSync     // Catch:{ Throwable -> 0x00ca }
            monitor-enter(r2)     // Catch:{ Throwable -> 0x00ca }
            android.util.SparseIntArray r5 = r7.s_TransactingUri     // Catch:{ all -> 0x00c7 }
            int r1 = r5.get(r0, r1)     // Catch:{ all -> 0x00c7 }
            int r1 = r1 + -1
            if (r1 > 0) goto L_0x00b5
            android.util.SparseIntArray r1 = r7.s_TransactingUri     // Catch:{ all -> 0x00c7 }
            r1.delete(r0)     // Catch:{ all -> 0x00c7 }
            goto L_0x00ba
        L_0x00b5:
            android.util.SparseIntArray r5 = r7.s_TransactingUri     // Catch:{ all -> 0x00c7 }
            r5.put(r0, r1)     // Catch:{ all -> 0x00c7 }
        L_0x00ba:
            monitor-exit(r2)     // Catch:{ all -> 0x00c7 }
            android.content.Context r0 = r7.getContext()     // Catch:{ Throwable -> 0x00ca }
            android.content.ContentResolver r0 = r0.getContentResolver()     // Catch:{ Throwable -> 0x00ca }
            r0.notifyChange(r8, r3)     // Catch:{ Throwable -> 0x00ca }
            throw r9     // Catch:{ Throwable -> 0x00ca }
        L_0x00c7:
            r8 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x00c7 }
            throw r8     // Catch:{ Throwable -> 0x00ca }
        L_0x00ca:
            r8 = move-exception
            r1 = r4
            goto L_0x00d1
        L_0x00cd:
            r8 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x00cd }
            throw r8     // Catch:{ Throwable -> 0x00d0 }
        L_0x00d0:
            r8 = move-exception
        L_0x00d1:
            r8.printStackTrace()
        L_0x00d4:
            return r1
        L_0x00d5:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.datacenter.SocialProvider.bulkInsert(android.net.Uri, android.content.ContentValues[]):int");
    }

    public int delete(Uri uri, String str, String[] strArr) {
        String str2;
        enforcePermission();
        int match = sURLMatcher.match(uri);
        int i = 0;
        if (match <= 0) {
            return 0;
        }
        if (match == INSIDE_BACKUP) {
            backupDatabase();
            return 0;
        } else if (match == INSIDE_CLOSE) {
            closeDatabase();
            return 0;
        } else {
            String tableName = getTableName(match);
            String condition = match % 2 == 0 ? getCondition((String) uri.getPathSegments().get(1), match) : null;
            if (condition == null) {
                str2 = str;
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(condition);
                sb.append(" AND (");
                sb.append(str);
                sb.append(")");
                str2 = sb.toString();
            }
            System.currentTimeMillis();
            SqliteOpenHelperWithDaemon databaseHelper = getDatabaseHelper(getContext(), match);
            if (databaseHelper != null) {
                try {
                    int delete = databaseHelper.getWritableDatabase().delete(tableName, str2, strArr);
                    if (delete > 0) {
                        try {
                            if (this.s_TransactingUri.get(match, 0) <= 0) {
                                getContext().getContentResolver().notifyChange(uri, null);
                            }
                        } catch (Exception e) {
                            e = e;
                            i = delete;
                            String str3 = RequestParameters.SUBRESOURCE_DELETE;
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("");
                            sb2.append(e.getMessage());
                            sb2.append(",uri:");
                            sb2.append(uri);
                            sb2.append(",where:");
                            sb2.append(str);
                            reportError(str3, sb2.toString());
                            reportAccessDBEvent(RequestParameters.SUBRESOURCE_DELETE, "Fail");
                            return i;
                        }
                    }
                    reportAccessDBEvent(RequestParameters.SUBRESOURCE_DELETE, "Success");
                    i = delete;
                } catch (Exception e2) {
                    e = e2;
                    String str32 = RequestParameters.SUBRESOURCE_DELETE;
                    StringBuilder sb22 = new StringBuilder();
                    sb22.append("");
                    sb22.append(e.getMessage());
                    sb22.append(",uri:");
                    sb22.append(uri);
                    sb22.append(",where:");
                    sb22.append(str);
                    reportError(str32, sb22.toString());
                    reportAccessDBEvent(RequestParameters.SUBRESOURCE_DELETE, "Fail");
                    return i;
                }
            }
            return i;
        }
    }

    public String getType(Uri uri) {
        SocialConstDef.init(getContext());
        if (sURLMatcher.match(uri) <= 0) {
            return null;
        }
        return String.format(Locale.US, "vnd.android.cursor.dir/%s.socialprovider", new Object[]{this.mStrAuthority});
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        enforcePermission();
        List<String> makeUpdateCondition = makeUpdateCondition(uri, contentValues);
        if (makeUpdateCondition != null && makeUpdateCondition.size() > 0) {
            StringBuilder sb = new StringBuilder();
            String[] strArr = new String[makeUpdateCondition.size()];
            int i = 0;
            for (String str : makeUpdateCondition) {
                if (sb.length() > 0) {
                    sb.append(" AND ");
                }
                sb.append(str);
                sb.append(" = ? ");
                int i2 = i + 1;
                strArr[i] = contentValues.getAsString(str);
                i = i2;
            }
            if (update(uri, contentValues, sb.toString(), strArr) > 0) {
                return ContentUris.withAppendedId(uri, 9999);
            }
        }
        int match = sURLMatcher.match(uri);
        Uri uri2 = null;
        if (match <= 0) {
            return null;
        }
        String tableName = getTableName(match);
        if (tableName == null) {
            return null;
        }
        ContentValues contentValues2 = contentValues != null ? new ContentValues(contentValues) : new ContentValues();
        fillTimestamp(tableName, contentValues2);
        encrypt(mSocialSecurity, tableName, contentValues2);
        System.currentTimeMillis();
        SqliteOpenHelperWithDaemon databaseHelper = getDatabaseHelper(getContext(), match);
        if (databaseHelper != null) {
            try {
                long insertWithOnConflict = databaseHelper.getWritableDatabase().insertWithOnConflict(tableName, null, contentValues2, 5);
                if (insertWithOnConflict >= 0) {
                    Uri withAppendedId = ContentUris.withAppendedId(uri, insertWithOnConflict);
                    try {
                        if (this.s_TransactingUri.get(match, 0) <= 0) {
                            getContext().getContentResolver().notifyChange(withAppendedId, null);
                        }
                        uri2 = withAppendedId;
                    } catch (Throwable th) {
                        th = th;
                        uri2 = withAppendedId;
                        String str2 = "insert";
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("");
                        sb2.append(th.getMessage());
                        sb2.append(",uri:");
                        sb2.append(uri);
                        reportError(str2, sb2.toString());
                        reportAccessDBEvent("insert", "Fail");
                        return uri2;
                    }
                }
                reportAccessDBEvent("insert", "Success");
            } catch (Throwable th2) {
                th = th2;
            }
        }
        return uri2;
    }

    public boolean onCreate() {
        init(getContext());
        initTableMap();
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0098 A[SYNTHETIC, Splitter:B:27:0x0098] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00e8  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00f0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.database.Cursor query(android.net.Uri r17, java.lang.String[] r18, java.lang.String r19, java.lang.String[] r20, java.lang.String r21) {
        /*
            r16 = this;
            r1 = r16
            r2 = r17
            r3 = r19
            r16.enforcePermission()
            android.content.UriMatcher r0 = sURLMatcher
            int r0 = r0.match(r2)
            r4 = 0
            if (r0 > 0) goto L_0x0013
            return r4
        L_0x0013:
            java.lang.String r5 = r1.getTableName(r0)
            r6 = 2301(0x8fd, float:3.224E-42)
            r7 = 1
            if (r6 != r0) goto L_0x0026
            java.util.List r5 = r17.getPathSegments()
            java.lang.Object r5 = r5.get(r7)
            java.lang.String r5 = (java.lang.String) r5
        L_0x0026:
            int r6 = r0 % 2
            if (r6 != 0) goto L_0x0039
            java.util.List r6 = r17.getPathSegments()
            java.lang.Object r6 = r6.get(r7)
            java.lang.String r6 = (java.lang.String) r6
            java.lang.String r6 = r1.getCondition(r6, r0)
            goto L_0x003a
        L_0x0039:
            r6 = r4
        L_0x003a:
            android.database.sqlite.SQLiteQueryBuilder r8 = new android.database.sqlite.SQLiteQueryBuilder
            r8.<init>()
            r8.setTables(r5)
            if (r6 == 0) goto L_0x0047
            r8.appendWhere(r6)
        L_0x0047:
            java.lang.System.currentTimeMillis()
            android.content.Context r6 = r16.getContext()
            com.introvd.template.datacenter.SqliteOpenHelperWithDaemon r6 = r1.getDatabaseHelper(r6, r0)
            if (r6 == 0) goto L_0x00e6
            android.database.sqlite.SQLiteDatabase r9 = r6.getReadableDatabase()     // Catch:{ Throwable -> 0x00b2 }
            boolean r0 = android.text.TextUtils.isEmpty(r19)     // Catch:{ Throwable -> 0x00b2 }
            if (r0 != 0) goto L_0x0080
            java.util.Locale r0 = java.util.Locale.US     // Catch:{ Throwable -> 0x00b2 }
            java.lang.String r0 = r3.toLowerCase(r0)     // Catch:{ Throwable -> 0x00b2 }
            java.lang.String r10 = "group by"
            int r0 = r0.indexOf(r10)     // Catch:{ Throwable -> 0x00b2 }
            if (r0 <= 0) goto L_0x0080
            java.lang.String r10 = "group by"
            int r10 = r10.length()     // Catch:{ Throwable -> 0x00b2 }
            int r10 = r10 + r0
            int r10 = r10 + r7
            java.lang.String r7 = r3.substring(r10)     // Catch:{ Throwable -> 0x00b2 }
            r10 = 0
            java.lang.String r0 = r3.substring(r10, r0)     // Catch:{ Throwable -> 0x00b2 }
            r3 = r0
            r13 = r7
            goto L_0x0081
        L_0x0080:
            r13 = r4
        L_0x0081:
            if (r9 == 0) goto L_0x00a8
            boolean r0 = r9.isOpen()     // Catch:{ Throwable -> 0x00b2 }
            if (r0 == 0) goto L_0x00a8
            r14 = 0
            r10 = r18
            r11 = r3
            r12 = r20
            r15 = r21
            android.database.Cursor r7 = r8.query(r9, r10, r11, r12, r13, r14, r15)     // Catch:{ Throwable -> 0x00b2 }
            if (r7 != 0) goto L_0x0098
            goto L_0x00a3
        L_0x0098:
            android.content.Context r0 = r16.getContext()     // Catch:{ Throwable -> 0x00a5 }
            android.content.ContentResolver r0 = r0.getContentResolver()     // Catch:{ Throwable -> 0x00a5 }
            r7.setNotificationUri(r0, r2)     // Catch:{ Throwable -> 0x00a5 }
        L_0x00a3:
            r4 = r7
            goto L_0x00a8
        L_0x00a5:
            r0 = move-exception
            r4 = r7
            goto L_0x00b3
        L_0x00a8:
            java.lang.String r0 = "query"
            java.lang.String r7 = "Success"
            r1.reportAccessDBEvent(r0, r7)     // Catch:{ Throwable -> 0x00b2 }
            goto L_0x00e6
        L_0x00b0:
            r0 = move-exception
            goto L_0x00e5
        L_0x00b2:
            r0 = move-exception
        L_0x00b3:
            java.lang.String r7 = "query"
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b0 }
            r8.<init>()     // Catch:{ all -> 0x00b0 }
            java.lang.String r9 = ""
            r8.append(r9)     // Catch:{ all -> 0x00b0 }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x00b0 }
            r8.append(r0)     // Catch:{ all -> 0x00b0 }
            java.lang.String r0 = ",uri:"
            r8.append(r0)     // Catch:{ all -> 0x00b0 }
            r8.append(r2)     // Catch:{ all -> 0x00b0 }
            java.lang.String r0 = ",where:"
            r8.append(r0)     // Catch:{ all -> 0x00b0 }
            r8.append(r3)     // Catch:{ all -> 0x00b0 }
            java.lang.String r0 = r8.toString()     // Catch:{ all -> 0x00b0 }
            r1.reportError(r7, r0)     // Catch:{ all -> 0x00b0 }
            java.lang.String r0 = "query"
            java.lang.String r2 = "Fail"
            r1.reportAccessDBEvent(r0, r2)     // Catch:{ all -> 0x00b0 }
            goto L_0x00e6
        L_0x00e5:
            throw r0
        L_0x00e6:
            if (r4 == 0) goto L_0x00f0
            com.introvd.template.datacenter.SocialCursor r0 = new com.introvd.template.datacenter.SocialCursor
            com.introvd.template.datacenter.SocialSecurity r2 = mSocialSecurity
            r0.<init>(r4, r5, r2, r6)
            goto L_0x00f1
        L_0x00f0:
            r0 = r4
        L_0x00f1:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.datacenter.SocialProvider.query(android.net.Uri, java.lang.String[], java.lang.String, java.lang.String[], java.lang.String):android.database.Cursor");
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        String str2;
        enforcePermission();
        int match = sURLMatcher.match(uri);
        int i = 0;
        if (match <= 0) {
            return 0;
        }
        String tableName = getTableName(match);
        if (tableName == null) {
            return 0;
        }
        String condition = match % 2 == 0 ? getCondition((String) uri.getPathSegments().get(1), match) : null;
        if (condition == null) {
            str2 = str;
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(condition);
            sb.append(" AND (");
            sb.append(str);
            sb.append(")");
            str2 = sb.toString();
        }
        ContentValues contentValues2 = new ContentValues(contentValues);
        fillTimestamp(tableName, contentValues2);
        encrypt(mSocialSecurity, tableName, contentValues2);
        System.currentTimeMillis();
        SqliteOpenHelperWithDaemon databaseHelper = getDatabaseHelper(getContext(), match);
        if (databaseHelper != null) {
            try {
                int update = databaseHelper.getWritableDatabase().update(tableName, contentValues2, str2, strArr);
                if (update > 0) {
                    try {
                        if (this.s_TransactingUri.get(match, 0) <= 0) {
                            getContext().getContentResolver().notifyChange(uri, null);
                        }
                    } catch (Throwable th) {
                        th = th;
                        i = update;
                        String str3 = "update";
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("");
                        sb2.append(th.getMessage());
                        sb2.append(",uri:");
                        sb2.append(uri);
                        sb2.append(",where:");
                        sb2.append(str);
                        reportError(str3, sb2.toString());
                        reportAccessDBEvent("update", "Fail");
                        return i;
                    }
                }
                reportAccessDBEvent("update", "Success");
                i = update;
            } catch (Throwable th2) {
                th = th2;
                String str32 = "update";
                StringBuilder sb22 = new StringBuilder();
                sb22.append("");
                sb22.append(th.getMessage());
                sb22.append(",uri:");
                sb22.append(uri);
                sb22.append(",where:");
                sb22.append(str);
                reportError(str32, sb22.toString());
                reportAccessDBEvent("update", "Fail");
                return i;
            }
        }
        return i;
    }
}
