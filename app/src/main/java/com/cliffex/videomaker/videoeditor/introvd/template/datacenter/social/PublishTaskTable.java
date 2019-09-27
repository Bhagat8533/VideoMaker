package com.introvd.template.datacenter.social;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.text.TextUtils;
import com.introvd.template.datacenter.SocialConstDef;
import com.introvd.template.datacenter.social.publish.PublishTaskInfo;
import java.util.ArrayList;

public class PublishTaskTable extends AbsTable {
    public static final String PARAM_PUBLISH_TASK_FILE_UPLOAD = "files_upload";
    public static final String PARAM_PUBLISH_TASK_ID = "_id";
    public static final String PARAM_PUBLISH_TASK_OLD_DATA = "oldData";
    public static final String PARAM_PUBLISH_TASK_PROGRESS = "progress";
    public static final String PARAM_PUBLISH_TASK_PROJECT_DESC = "desc";
    public static final String PARAM_PUBLISH_TASK_PROJECT_THUMB = "thumb";
    public static final String PARAM_PUBLISH_TASK_PROJECT_THUMB_REMOTE = "thumb_remote_url";
    public static final String PARAM_PUBLISH_TASK_PROJECT_TITLE = "title";
    public static final String PARAM_PUBLISH_TASK_PROJECT_URL = "prjurl";
    public static final String PARAM_PUBLISH_TASK_PROJECT_VIDEO = "video";
    public static final String PARAM_PUBLISH_TASK_PROJECT_VIDEO_REMOTE = "video_remote_url";
    public static final String PARAM_PUBLISH_TASK_PUID_DIGEST = "puiddigest";
    public static final String PARAM_PUBLISH_TASK_STARTTIME = "starttime";
    public static final String PARAM_PUBLISH_TASK_STATE = "state";
    public static final String PARAM_PUBLISH_TASK_STEP = "step";
    public static final String PARAM_PUBLISH_TASK_VIDEO_DURATION = "videoDuration";
    public static final String PARAM_PUBLISH_TASK_VIDEO_HEIGHT = "videoHeight";
    public static final String PARAM_PUBLISH_TASK_VIDEO_TYPE = "videoType";
    public static final String PARAM_PUBLISH_TASK_VIDEO_WIDTH = "videoWidth";
    private static Uri TABLE_PUBLISH = null;
    private static final int TASK_MAIN_TYPE_PUBLISH = 2;
    public static final String TBL_NAME_PUBLISH_TASK = "Publish_Task";
    protected static volatile int descPos;
    protected static volatile int filesUploadPos;
    protected static volatile int idPos;
    protected static volatile int oldDataPos;
    protected static volatile int prjUrlPos;
    protected static volatile int progressPos;
    protected static volatile int puiddigestPos;
    protected static volatile int starttimePos;
    protected static volatile int statePos;
    protected static volatile int stepPos;
    protected static volatile int thumbPos;
    protected static volatile int thumbRemotePos;
    protected static volatile int titlePos;
    protected static volatile int videoDurationPos;
    protected static volatile int videoHeightPos;
    protected static volatile int videoPos;
    protected static volatile int videoRemotePos;
    protected static volatile int videoTypePos;
    protected static volatile int videoWidthPos;

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x01ba, code lost:
        if (r3 != null) goto L_0x01cd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x01cb, code lost:
        if (r3 != null) goto L_0x01cd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x01cd, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x01d0, code lost:
        r18.endTransaction();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x01d3, code lost:
        return;
     */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x01d7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void changeOldPublishToNew(android.database.sqlite.SQLiteDatabase r18) {
        /*
            r1 = r18
            r2 = 0
            r18.beginTransaction()     // Catch:{ Exception -> 0x01c4, all -> 0x01bf }
            java.lang.String r0 = "Publish._id _id,Publish.project_puid project_puid,Publish.project_url project_url,Publish.project_title project_title,Publish.video_desc video_desc,Publish.video_gps_accuracy video_gps_accuracy,Publish.video_latitude video_latitude,Publish.video_longitude video_longitude,Publish.video_address video_address,Publish.video_address_detail video_address_detail,Publish.video_thumbnail_big video_thumbnail_big,Publish.video_local_url video_local_url,Publish.permission permission,Publish.shoot_time shoot_time,Publish.tag tag,Publish.internal_flag internal_flag,Publish.video_duration video_duration,Publish.upload_persistance upload_persistance,Publish.activityUID activityUID,Publish.activityEvent activityEvent,Publish.video_cover_text video_cover_text,Publish.video_video_text video_video_text,Publish.referredUsers referredUsers,Publish.video_publish_language video_publish_language"
            java.lang.String r3 = "Task.user_data = Publish._id and Task.main_type = 2 and Task.sub_type < 100"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01c4, all -> 0x01bf }
            r4.<init>()     // Catch:{ Exception -> 0x01c4, all -> 0x01bf }
            java.lang.String r5 = "select distinct "
            r4.append(r5)     // Catch:{ Exception -> 0x01c4, all -> 0x01bf }
            r4.append(r0)     // Catch:{ Exception -> 0x01c4, all -> 0x01bf }
            java.lang.String r0 = " from "
            r4.append(r0)     // Catch:{ Exception -> 0x01c4, all -> 0x01bf }
            java.lang.String r0 = "Task"
            r4.append(r0)     // Catch:{ Exception -> 0x01c4, all -> 0x01bf }
            java.lang.String r0 = ", "
            r4.append(r0)     // Catch:{ Exception -> 0x01c4, all -> 0x01bf }
            java.lang.String r0 = "Publish"
            r4.append(r0)     // Catch:{ Exception -> 0x01c4, all -> 0x01bf }
            java.lang.String r0 = " where "
            r4.append(r0)     // Catch:{ Exception -> 0x01c4, all -> 0x01bf }
            r4.append(r3)     // Catch:{ Exception -> 0x01c4, all -> 0x01bf }
            java.lang.String r0 = r4.toString()     // Catch:{ Exception -> 0x01c4, all -> 0x01bf }
            android.database.Cursor r3 = r1.rawQuery(r0, r2)     // Catch:{ Exception -> 0x01c4, all -> 0x01bf }
            if (r3 == 0) goto L_0x01ae
        L_0x003d:
            boolean r0 = r3.moveToNext()     // Catch:{ Exception -> 0x01ab, all -> 0x01a8 }
            if (r0 == 0) goto L_0x01ae
            com.introvd.template.datacenter.social.publish.PublishTaskInfo r0 = new com.introvd.template.datacenter.social.publish.PublishTaskInfo     // Catch:{ Exception -> 0x01ab, all -> 0x01a8 }
            r0.<init>()     // Catch:{ Exception -> 0x01ab, all -> 0x01a8 }
            java.lang.String r4 = "project_puid"
            int r4 = r3.getColumnIndex(r4)     // Catch:{ Exception -> 0x01ab, all -> 0x01a8 }
            java.lang.String r4 = r3.getString(r4)     // Catch:{ Exception -> 0x01ab, all -> 0x01a8 }
            java.lang.String r5 = "_id"
            int r5 = r3.getColumnIndex(r5)     // Catch:{ Exception -> 0x01ab, all -> 0x01a8 }
            long r5 = r3.getLong(r5)     // Catch:{ Exception -> 0x01ab, all -> 0x01a8 }
            boolean r7 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x01ab, all -> 0x01a8 }
            if (r7 == 0) goto L_0x0073
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01ab, all -> 0x01a8 }
            r4.<init>()     // Catch:{ Exception -> 0x01ab, all -> 0x01a8 }
            java.lang.String r7 = "old_"
            r4.append(r7)     // Catch:{ Exception -> 0x01ab, all -> 0x01a8 }
            r4.append(r5)     // Catch:{ Exception -> 0x01ab, all -> 0x01a8 }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x01ab, all -> 0x01a8 }
        L_0x0073:
            r0.puiddigest = r4     // Catch:{ Exception -> 0x01ab, all -> 0x01a8 }
            java.lang.String r4 = "project_url"
            int r4 = r3.getColumnIndex(r4)     // Catch:{ Exception -> 0x01ab, all -> 0x01a8 }
            java.lang.String r4 = r3.getString(r4)     // Catch:{ Exception -> 0x01ab, all -> 0x01a8 }
            r0.prjUrl = r4     // Catch:{ Exception -> 0x01ab, all -> 0x01a8 }
            java.lang.String r4 = "project_title"
            int r4 = r3.getColumnIndex(r4)     // Catch:{ Exception -> 0x01ab, all -> 0x01a8 }
            java.lang.String r4 = r3.getString(r4)     // Catch:{ Exception -> 0x01ab, all -> 0x01a8 }
            r0.title = r4     // Catch:{ Exception -> 0x01ab, all -> 0x01a8 }
            java.lang.String r4 = "video_desc"
            int r4 = r3.getColumnIndex(r4)     // Catch:{ Exception -> 0x01ab, all -> 0x01a8 }
            java.lang.String r4 = r3.getString(r4)     // Catch:{ Exception -> 0x01ab, all -> 0x01a8 }
            r0.desc = r4     // Catch:{ Exception -> 0x01ab, all -> 0x01a8 }
            java.lang.String r4 = "video_thumbnail_big"
            int r4 = r3.getColumnIndex(r4)     // Catch:{ Exception -> 0x01ab, all -> 0x01a8 }
            java.lang.String r4 = r3.getString(r4)     // Catch:{ Exception -> 0x01ab, all -> 0x01a8 }
            r0.thumbUrl = r4     // Catch:{ Exception -> 0x01ab, all -> 0x01a8 }
            java.lang.String r4 = "video_local_url"
            int r4 = r3.getColumnIndex(r4)     // Catch:{ Exception -> 0x01ab, all -> 0x01a8 }
            java.lang.String r4 = r3.getString(r4)     // Catch:{ Exception -> 0x01ab, all -> 0x01a8 }
            r0.videoLocal = r4     // Catch:{ Exception -> 0x01ab, all -> 0x01a8 }
            r4 = 0
            r0.videoType = r4     // Catch:{ Exception -> 0x01ab, all -> 0x01a8 }
            r4 = -1
            r0.step = r4     // Catch:{ Exception -> 0x01ab, all -> 0x01a8 }
            r4 = 15
            r0.progress = r4     // Catch:{ Exception -> 0x01ab, all -> 0x01a8 }
            r4 = 1
            r0.state = r4     // Catch:{ Exception -> 0x01ab, all -> 0x01a8 }
            java.lang.String r4 = "video_duration"
            int r4 = r3.getColumnIndex(r4)     // Catch:{ Exception -> 0x01ab, all -> 0x01a8 }
            int r4 = r3.getInt(r4)     // Catch:{ Exception -> 0x01ab, all -> 0x01a8 }
            int r4 = r4 / 1000
            r0.videoDuration = r4     // Catch:{ Exception -> 0x01ab, all -> 0x01a8 }
            java.lang.String r4 = "video_publish_language"
            int r4 = r3.getColumnIndex(r4)     // Catch:{ Exception -> 0x01ab, all -> 0x01a8 }
            java.lang.String r5 = r3.getString(r4)     // Catch:{ Exception -> 0x01ab, all -> 0x01a8 }
            java.lang.String r4 = "tag"
            int r4 = r3.getColumnIndex(r4)     // Catch:{ Exception -> 0x01ab, all -> 0x01a8 }
            java.lang.String r6 = r3.getString(r4)     // Catch:{ Exception -> 0x01ab, all -> 0x01a8 }
            java.lang.String r4 = "shoot_time"
            int r4 = r3.getColumnIndex(r4)     // Catch:{ Exception -> 0x01ab, all -> 0x01a8 }
            java.lang.String r7 = r3.getString(r4)     // Catch:{ Exception -> 0x01ab, all -> 0x01a8 }
            java.lang.String r4 = "video_cover_text"
            int r4 = r3.getColumnIndex(r4)     // Catch:{ Exception -> 0x01ab, all -> 0x01a8 }
            java.lang.String r8 = r3.getString(r4)     // Catch:{ Exception -> 0x01ab, all -> 0x01a8 }
            java.lang.String r4 = "video_video_text"
            int r4 = r3.getColumnIndex(r4)     // Catch:{ Exception -> 0x01ab, all -> 0x01a8 }
            java.lang.String r9 = r3.getString(r4)     // Catch:{ Exception -> 0x01ab, all -> 0x01a8 }
            java.lang.String r4 = "permission"
            int r4 = r3.getColumnIndex(r4)     // Catch:{ Exception -> 0x01ab, all -> 0x01a8 }
            int r10 = r3.getInt(r4)     // Catch:{ Exception -> 0x01ab, all -> 0x01a8 }
            java.lang.String r4 = "video_address"
            int r4 = r3.getColumnIndex(r4)     // Catch:{ Exception -> 0x01ab, all -> 0x01a8 }
            java.lang.String r11 = r3.getString(r4)     // Catch:{ Exception -> 0x01ab, all -> 0x01a8 }
            java.lang.String r4 = "video_address_detail"
            int r4 = r3.getColumnIndex(r4)     // Catch:{ Exception -> 0x01ab, all -> 0x01a8 }
            java.lang.String r12 = r3.getString(r4)     // Catch:{ Exception -> 0x01ab, all -> 0x01a8 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01ab, all -> 0x01a8 }
            r4.<init>()     // Catch:{ Exception -> 0x01ab, all -> 0x01a8 }
            java.lang.String r13 = "video_gps_accuracy"
            int r13 = r3.getColumnIndex(r13)     // Catch:{ Exception -> 0x01ab, all -> 0x01a8 }
            int r13 = r3.getInt(r13)     // Catch:{ Exception -> 0x01ab, all -> 0x01a8 }
            r4.append(r13)     // Catch:{ Exception -> 0x01ab, all -> 0x01a8 }
            java.lang.String r13 = ""
            r4.append(r13)     // Catch:{ Exception -> 0x01ab, all -> 0x01a8 }
            java.lang.String r13 = r4.toString()     // Catch:{ Exception -> 0x01ab, all -> 0x01a8 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01ab, all -> 0x01a8 }
            r4.<init>()     // Catch:{ Exception -> 0x01ab, all -> 0x01a8 }
            java.lang.String r14 = "video_longitude"
            int r14 = r3.getColumnIndex(r14)     // Catch:{ Exception -> 0x01ab, all -> 0x01a8 }
            double r14 = r3.getDouble(r14)     // Catch:{ Exception -> 0x01ab, all -> 0x01a8 }
            r4.append(r14)     // Catch:{ Exception -> 0x01ab, all -> 0x01a8 }
            java.lang.String r14 = ""
            r4.append(r14)     // Catch:{ Exception -> 0x01ab, all -> 0x01a8 }
            java.lang.String r14 = r4.toString()     // Catch:{ Exception -> 0x01ab, all -> 0x01a8 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01ab, all -> 0x01a8 }
            r4.<init>()     // Catch:{ Exception -> 0x01ab, all -> 0x01a8 }
            java.lang.String r15 = "video_latitude"
            int r15 = r3.getColumnIndex(r15)     // Catch:{ Exception -> 0x01ab, all -> 0x01a8 }
            double r1 = r3.getDouble(r15)     // Catch:{ Exception -> 0x01a4, all -> 0x01a0 }
            r4.append(r1)     // Catch:{ Exception -> 0x01a4, all -> 0x01a0 }
            java.lang.String r1 = ""
            r4.append(r1)     // Catch:{ Exception -> 0x01a4, all -> 0x01a0 }
            java.lang.String r15 = r4.toString()     // Catch:{ Exception -> 0x01a4, all -> 0x01a0 }
            java.lang.String r1 = "activityUID"
            int r1 = r3.getColumnIndex(r1)     // Catch:{ Exception -> 0x01a4, all -> 0x01a0 }
            java.lang.String r16 = r3.getString(r1)     // Catch:{ Exception -> 0x01a4, all -> 0x01a0 }
            java.lang.String r1 = "activityEvent"
            int r1 = r3.getColumnIndex(r1)     // Catch:{ Exception -> 0x01a4, all -> 0x01a0 }
            java.lang.String r17 = r3.getString(r1)     // Catch:{ Exception -> 0x01a4, all -> 0x01a0 }
            r4 = r0
            r4.initOldData(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)     // Catch:{ Exception -> 0x01a4, all -> 0x01a0 }
            java.lang.String r1 = r0.oldData     // Catch:{ Exception -> 0x01a4, all -> 0x01a0 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x01a4, all -> 0x01a0 }
            if (r1 != 0) goto L_0x019a
            java.lang.String r1 = "Publish_Task"
            android.content.ContentValues r0 = itemToContentValues(r0)     // Catch:{ Exception -> 0x01a4, all -> 0x01a0 }
            r2 = r18
            r4 = 0
            r2.insert(r1, r4, r0)     // Catch:{ Exception -> 0x01bd }
            goto L_0x019c
        L_0x019a:
            r2 = r18
        L_0x019c:
            r1 = r2
            r2 = 0
            goto L_0x003d
        L_0x01a0:
            r0 = move-exception
            r2 = r18
            goto L_0x01d5
        L_0x01a4:
            r0 = move-exception
            r2 = r18
            goto L_0x01c8
        L_0x01a8:
            r0 = move-exception
            r2 = r1
            goto L_0x01d5
        L_0x01ab:
            r0 = move-exception
            r2 = r1
            goto L_0x01c8
        L_0x01ae:
            r2 = r1
            java.lang.String r0 = "Task"
            java.lang.String r1 = "main_type = 2"
            r4 = 0
            r2.delete(r0, r1, r4)     // Catch:{ Exception -> 0x01bd }
            r18.setTransactionSuccessful()     // Catch:{ Exception -> 0x01bd }
            if (r3 == 0) goto L_0x01d0
            goto L_0x01cd
        L_0x01bd:
            r0 = move-exception
            goto L_0x01c8
        L_0x01bf:
            r0 = move-exception
            r4 = r2
            r2 = r1
            r3 = r4
            goto L_0x01d5
        L_0x01c4:
            r0 = move-exception
            r4 = r2
            r2 = r1
            r3 = r4
        L_0x01c8:
            r0.printStackTrace()     // Catch:{ all -> 0x01d4 }
            if (r3 == 0) goto L_0x01d0
        L_0x01cd:
            r3.close()
        L_0x01d0:
            r18.endTransaction()
            return
        L_0x01d4:
            r0 = move-exception
        L_0x01d5:
            if (r3 == 0) goto L_0x01da
            r3.close()
        L_0x01da:
            r18.endTransaction()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.datacenter.social.PublishTaskTable.changeOldPublishToNew(android.database.sqlite.SQLiteDatabase):void");
    }

    public static PublishTaskInfo cursorToItem(Cursor cursor) {
        PublishTaskInfo publishTaskInfo = new PublishTaskInfo();
        if (starttimePos == 0) {
            idPos = cursor.getColumnIndex("_id");
            puiddigestPos = cursor.getColumnIndex(PARAM_PUBLISH_TASK_PUID_DIGEST);
            prjUrlPos = cursor.getColumnIndex(PARAM_PUBLISH_TASK_PROJECT_URL);
            titlePos = cursor.getColumnIndex("title");
            descPos = cursor.getColumnIndex("desc");
            thumbPos = cursor.getColumnIndex("thumb");
            videoPos = cursor.getColumnIndex("video");
            thumbRemotePos = cursor.getColumnIndex(PARAM_PUBLISH_TASK_PROJECT_THUMB_REMOTE);
            videoRemotePos = cursor.getColumnIndex("video_remote_url");
            videoTypePos = cursor.getColumnIndex(PARAM_PUBLISH_TASK_VIDEO_TYPE);
            filesUploadPos = cursor.getColumnIndex(PARAM_PUBLISH_TASK_FILE_UPLOAD);
            progressPos = cursor.getColumnIndex("progress");
            stepPos = cursor.getColumnIndex("step");
            statePos = cursor.getColumnIndex("state");
            videoDurationPos = cursor.getColumnIndex(PARAM_PUBLISH_TASK_VIDEO_DURATION);
            videoWidthPos = cursor.getColumnIndex(PARAM_PUBLISH_TASK_VIDEO_WIDTH);
            videoHeightPos = cursor.getColumnIndex(PARAM_PUBLISH_TASK_VIDEO_HEIGHT);
            starttimePos = cursor.getColumnIndex("starttime");
            oldDataPos = cursor.getColumnIndex(PARAM_PUBLISH_TASK_OLD_DATA);
        }
        publishTaskInfo._id = (long) cursor.getInt(idPos);
        publishTaskInfo.puiddigest = cursor.getString(puiddigestPos);
        publishTaskInfo.prjUrl = cursor.getString(prjUrlPos);
        publishTaskInfo.title = cursor.getString(titlePos);
        publishTaskInfo.desc = cursor.getString(descPos);
        publishTaskInfo.thumbUrl = cursor.getString(thumbPos);
        publishTaskInfo.videoLocal = cursor.getString(videoPos);
        publishTaskInfo.strCoverUrl = cursor.getString(thumbRemotePos);
        publishTaskInfo.strVideoUrl = cursor.getString(videoRemotePos);
        publishTaskInfo.videoType = cursor.getInt(videoTypePos);
        publishTaskInfo.files_upload = cursor.getString(filesUploadPos);
        publishTaskInfo.progress = cursor.getInt(progressPos);
        publishTaskInfo.step = cursor.getInt(stepPos);
        publishTaskInfo.state = cursor.getInt(statePos);
        publishTaskInfo.videoDuration = cursor.getInt(videoDurationPos);
        publishTaskInfo.videoWidth = cursor.getInt(videoWidthPos);
        publishTaskInfo.videoHeight = cursor.getInt(videoHeightPos);
        publishTaskInfo.startTime = (long) cursor.getInt(starttimePos);
        String string = cursor.getString(oldDataPos);
        if (TextUtils.isEmpty(string)) {
            string = "";
        }
        publishTaskInfo.oldData = string;
        return publishTaskInfo;
    }

    public static void deleteAll(Context context) {
        if (context != null) {
            context.getApplicationContext().getContentResolver().delete(getTableUri(), null, null);
        }
    }

    public static void deleteByPUID(Context context, String str) {
        if (context != null) {
            context.getApplicationContext().getContentResolver().delete(getTableUri(), "puiddigest = ? ", new String[]{str});
        }
    }

    public static void deleteByStep(Context context, int i) {
        if (context != null) {
            ContentResolver contentResolver = context.getApplicationContext().getContentResolver();
            Uri tableUri = getTableUri();
            StringBuilder sb = new StringBuilder();
            sb.append(i);
            sb.append("");
            contentResolver.delete(tableUri, "step = ? ", new String[]{sb.toString()});
        }
    }

    public static PublishTaskInfo getPublishTaskInfoByPrjUrl(Context context, String str) {
        PublishTaskInfo publishTaskInfo = null;
        if (context == null) {
            return null;
        }
        Cursor query = context.getContentResolver().query(getTableUri(), null, "prjurl = ? ", new String[]{str}, "starttime");
        if (query == null) {
            return null;
        }
        if (query.moveToNext()) {
            publishTaskInfo = cursorToItem(query);
        }
        query.close();
        return publishTaskInfo;
    }

    public static PublishTaskInfo getPublishTaskInfoByPuid(Context context, String str) {
        PublishTaskInfo publishTaskInfo = null;
        if (context == null) {
            return null;
        }
        Cursor query = context.getContentResolver().query(getTableUri(), null, "puiddigest = ? ", new String[]{str}, "starttime");
        if (query == null) {
            return null;
        }
        if (query.moveToNext()) {
            publishTaskInfo = cursorToItem(query);
        }
        query.close();
        return publishTaskInfo;
    }

    public static ArrayList<PublishTaskInfo> getPublishTaskInfos(Context context) {
        ArrayList<PublishTaskInfo> arrayList = new ArrayList<>();
        Cursor query = context.getContentResolver().query(getTableUri(), null, "step != 0", null, "starttime");
        if (query == null) {
            return arrayList;
        }
        while (query.moveToNext()) {
            arrayList.add(cursorToItem(query));
        }
        query.close();
        return arrayList;
    }

    public static ArrayList<PublishTaskInfo> getPublishTaskInfosWait(Context context) {
        ArrayList<PublishTaskInfo> arrayList = new ArrayList<>();
        Cursor query = context.getContentResolver().query(getTableUri(), null, "step != 0 and state != 3 and state != 2", null, "starttime");
        if (query == null) {
            return arrayList;
        }
        while (query.moveToNext()) {
            arrayList.add(cursorToItem(query));
        }
        query.close();
        return arrayList;
    }

    private static Uri getTableUri() {
        if (TABLE_PUBLISH == null) {
            synchronized (PublishTaskTable.class) {
                if (TABLE_PUBLISH == null) {
                    TABLE_PUBLISH = SocialConstDef.getTableUri(TBL_NAME_PUBLISH_TASK);
                }
            }
        }
        return TABLE_PUBLISH;
    }

    public static long insertPublishTask(Context context, PublishTaskInfo publishTaskInfo) {
        if (TextUtils.isEmpty(publishTaskInfo.puiddigest) || TextUtils.isEmpty(publishTaskInfo.files_upload)) {
            return -1;
        }
        ContentResolver contentResolver = context.getContentResolver();
        ContentValues itemToContentValues = itemToContentValues(publishTaskInfo);
        Uri tableUri = getTableUri();
        if (contentResolver.update(tableUri, itemToContentValues, "puiddigest = ? ", new String[]{publishTaskInfo.puiddigest}) != 0) {
            return -1;
        }
        Uri insert = contentResolver.insert(tableUri, itemToContentValues);
        if (insert == null) {
            return -1;
        }
        return ContentUris.parseId(insert);
    }

    public static ContentValues itemToContentValues(PublishTaskInfo publishTaskInfo) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(PARAM_PUBLISH_TASK_PUID_DIGEST, publishTaskInfo.puiddigest);
        contentValues.put(PARAM_PUBLISH_TASK_PROJECT_URL, publishTaskInfo.prjUrl);
        contentValues.put("title", publishTaskInfo.title);
        contentValues.put("desc", publishTaskInfo.desc);
        contentValues.put("thumb", publishTaskInfo.thumbUrl);
        contentValues.put("video", publishTaskInfo.videoLocal);
        contentValues.put(PARAM_PUBLISH_TASK_PROJECT_THUMB_REMOTE, publishTaskInfo.strCoverUrl);
        contentValues.put("video_remote_url", publishTaskInfo.strVideoUrl);
        contentValues.put(PARAM_PUBLISH_TASK_VIDEO_TYPE, Integer.valueOf(publishTaskInfo.videoType));
        contentValues.put(PARAM_PUBLISH_TASK_FILE_UPLOAD, publishTaskInfo.files_upload);
        contentValues.put("progress", Integer.valueOf(publishTaskInfo.progress));
        contentValues.put("step", Integer.valueOf(publishTaskInfo.step));
        contentValues.put("state", Integer.valueOf(publishTaskInfo.state));
        contentValues.put(PARAM_PUBLISH_TASK_VIDEO_DURATION, Integer.valueOf(publishTaskInfo.videoDuration));
        contentValues.put(PARAM_PUBLISH_TASK_VIDEO_WIDTH, Integer.valueOf(publishTaskInfo.videoWidth));
        contentValues.put(PARAM_PUBLISH_TASK_VIDEO_HEIGHT, Integer.valueOf(publishTaskInfo.videoHeight));
        contentValues.put("starttime", Long.valueOf(publishTaskInfo.startTime));
        contentValues.put(PARAM_PUBLISH_TASK_OLD_DATA, TextUtils.isEmpty(publishTaskInfo.oldData) ? "" : publishTaskInfo.oldData);
        return contentValues;
    }

    public static void onCreatePublishTaskTable(SQLiteDatabase sQLiteDatabase) {
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE IF NOT EXISTS ");
        sb.append(TBL_NAME_PUBLISH_TASK);
        sb.append("( ");
        sb.append("_id");
        sb.append(" INTEGER PRIMARY KEY AUTOINCREMENT, ");
        sb.append(PARAM_PUBLISH_TASK_PUID_DIGEST);
        sb.append(" TEXT, ");
        sb.append(PARAM_PUBLISH_TASK_PROJECT_URL);
        sb.append(" TEXT, ");
        sb.append("title");
        sb.append(" TEXT, ");
        sb.append("desc");
        sb.append(" TEXT, ");
        sb.append("thumb");
        sb.append(" TEXT, ");
        sb.append("video");
        sb.append(" TEXT, ");
        sb.append(PARAM_PUBLISH_TASK_PROJECT_THUMB_REMOTE);
        sb.append(" TEXT, ");
        sb.append("video_remote_url");
        sb.append(" TEXT, ");
        sb.append(PARAM_PUBLISH_TASK_VIDEO_TYPE);
        sb.append(" INTEGER, ");
        sb.append(PARAM_PUBLISH_TASK_FILE_UPLOAD);
        sb.append(" TEXT, ");
        sb.append("progress");
        sb.append(" INTEGER, ");
        sb.append("step");
        sb.append(" INTEGER, ");
        sb.append("state");
        sb.append(" INTEGER, ");
        sb.append(PARAM_PUBLISH_TASK_VIDEO_DURATION);
        sb.append(" INTEGER, ");
        sb.append(PARAM_PUBLISH_TASK_VIDEO_WIDTH);
        sb.append(" INTEGER DEFAULT 0, ");
        sb.append(PARAM_PUBLISH_TASK_VIDEO_HEIGHT);
        sb.append(" INTEGER DEFAULT 0, ");
        sb.append("starttime");
        sb.append(" LONG, ");
        sb.append(PARAM_PUBLISH_TASK_OLD_DATA);
        sb.append(" TEXT, ");
        sb.append(" UNIQUE(");
        sb.append(PARAM_PUBLISH_TASK_PUID_DIGEST);
        sb.append(")");
        sb.append(")");
        ExecSQL(sQLiteDatabase, sb.toString());
    }

    public static boolean updateAllPublishStateToStop(Context context) {
        if (context == null) {
            return false;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("state", Integer.valueOf(1));
        return context.getContentResolver().update(getTableUri(), contentValues, "state = 0", null) == 0;
    }

    public static boolean updateOldTaskByPuid(Context context, String str, PublishTaskInfo publishTaskInfo) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put(PARAM_PUBLISH_TASK_PUID_DIGEST, publishTaskInfo.puiddigest);
        contentValues.put("progress", Integer.valueOf(publishTaskInfo.progress));
        contentValues.put(PARAM_PUBLISH_TASK_PROJECT_THUMB_REMOTE, publishTaskInfo.strCoverUrl);
        contentValues.put("video_remote_url", publishTaskInfo.strVideoUrl);
        contentValues.put(PARAM_PUBLISH_TASK_FILE_UPLOAD, publishTaskInfo.files_upload);
        contentValues.put("step", Integer.valueOf(publishTaskInfo.step));
        contentValues.put("starttime", Long.valueOf(publishTaskInfo.startTime));
        return context.getContentResolver().update(getTableUri(), contentValues, "puiddigest = ? ", new String[]{str}) == 0;
    }

    public static boolean updatePublishProgressByPuid(Context context, String str, int i) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("progress", Integer.valueOf(i));
        return context.getContentResolver().update(getTableUri(), contentValues, "puiddigest = ? ", new String[]{str}) == 0;
    }

    public static boolean updatePublishStateByPuid(Context context, String str, int i) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("state", Integer.valueOf(i));
        return context.getContentResolver().update(getTableUri(), contentValues, "puiddigest = ? ", new String[]{str}) == 0;
    }

    public static boolean updatePublishStepByPuid(Context context, String str, int i, int i2) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("progress", Integer.valueOf(i));
        contentValues.put("step", Integer.valueOf(i2));
        return context.getContentResolver().update(getTableUri(), contentValues, "puiddigest = ? ", new String[]{str}) == 0;
    }
}
