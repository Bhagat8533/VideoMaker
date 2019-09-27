package com.introvd.template.datacenter.project;

import android.database.Cursor;
import android.text.TextUtils;
import com.introvd.template.datacenter.SocialConstDef;
import java.io.File;
import java.util.ArrayList;

public class PrjTableUpgradeUtil {
    public static final String TBL_NAME_PROJECT = "Project";
    private static int activityDataPos;
    private static int addressDetailPos;
    private static int addressPos;
    private static int cameraCodePos;
    private static int clipCountPos;
    private static int coverURLPos;
    private static int createTimePos;
    private static int durationLimitPos;
    private static int durationPos;
    private static int editCodePos;
    private static int effectIDPos;
    private static int entrancePos;
    private static int exportUrlPos;
    private static int extrasPos;
    private static int gpsAccuracyPos;
    private static int idPos;
    private static int isDeletedPos;
    private static int isModifiedPos;
    private static int latitudePos;
    private static int longitudePos;
    private static int modifyTimePos;
    private static volatile IProjectUpdateListener projectUpdateListener;
    private static int streamHeightPos;
    private static int streamWidthPos;
    private static int themeTypePos;
    private static int thumbnailPos;
    private static int titlePos;
    private static int todoCodePos;
    private static int urlPos;
    private static int versionPos;
    private static int videoDescPos;
    private static int videoTemplateInfoPos;

    public interface IProjectUpdateListener {
        void handleProjectUpdate(ArrayList<OldProjectItem> arrayList);
    }

    private static OldProjectItem cursorToItem(Cursor cursor) {
        OldProjectItem oldProjectItem = new OldProjectItem();
        if (addressDetailPos == 0) {
            idPos = cursor.getColumnIndex("_id");
            urlPos = cursor.getColumnIndex("url");
            exportUrlPos = cursor.getColumnIndex(SocialConstDef.PROJECT_EXPORT_URL);
            clipCountPos = cursor.getColumnIndex(SocialConstDef.PROJECT_CLIP_COUNT);
            durationPos = cursor.getColumnIndex("duration");
            thumbnailPos = cursor.getColumnIndex(SocialConstDef.PROJECT_THUMBNAIL);
            versionPos = cursor.getColumnIndex("version");
            createTimePos = cursor.getColumnIndex("create_time");
            modifyTimePos = cursor.getColumnIndex("modify_time");
            isDeletedPos = cursor.getColumnIndex(SocialConstDef.PROJECT_ISDELETED);
            isModifiedPos = cursor.getColumnIndex(SocialConstDef.PROJECT_ISMODIFIED);
            streamWidthPos = cursor.getColumnIndex(SocialConstDef.PROJECT_WIDTH);
            streamHeightPos = cursor.getColumnIndex(SocialConstDef.PROJECT_HEIGHT);
            effectIDPos = cursor.getColumnIndex(SocialConstDef.PROJECT_EFFECT_ID);
            todoCodePos = cursor.getColumnIndex("todoCode");
            editCodePos = cursor.getColumnIndex(SocialConstDef.PROJECT_EDIT_CODE);
            cameraCodePos = cursor.getColumnIndex(SocialConstDef.PROJECT_CAMERA_CODE);
            extrasPos = cursor.getColumnIndex("extras");
            coverURLPos = cursor.getColumnIndex("coverURL");
            durationLimitPos = cursor.getColumnIndex(SocialConstDef.PROJECT_DURATION_LIMIT);
            entrancePos = cursor.getColumnIndex(SocialConstDef.PROJECT_ENTRANCE);
            videoTemplateInfoPos = cursor.getColumnIndex(SocialConstDef.PROJECT_VIDEO_TEMPLATE_INFO);
            themeTypePos = cursor.getColumnIndex(SocialConstDef.PROJECT_THEME_TYPE);
            titlePos = cursor.getColumnIndex("title");
            videoDescPos = cursor.getColumnIndex(SocialConstDef.PROJECT_VIDEO_TEMPLATE_INFO);
            activityDataPos = cursor.getColumnIndex(SocialConstDef.PROJECT_ACTVITY_DATA);
            gpsAccuracyPos = cursor.getColumnIndex(SocialConstDef.PROJECT_GPS_ACCURACY);
            latitudePos = cursor.getColumnIndex("latitude");
            longitudePos = cursor.getColumnIndex("longitude");
            addressPos = cursor.getColumnIndex("address");
            addressDetailPos = cursor.getColumnIndex(SocialConstDef.PROJECT_ADDRESS_DETAIL);
        }
        oldProjectItem._id = cursor.getInt(idPos);
        oldProjectItem.strPrjURL = cursor.getString(urlPos);
        oldProjectItem.strPrjExportURL = cursor.getString(exportUrlPos);
        oldProjectItem.iPrjClipCount = cursor.getInt(clipCountPos);
        oldProjectItem.iPrjDuration = cursor.getInt(durationPos);
        oldProjectItem.strPrjThumbnail = cursor.getString(thumbnailPos);
        oldProjectItem.entrance = cursor.getString(entrancePos);
        oldProjectItem.videoTemplateInfo = cursor.getString(videoTemplateInfoPos);
        oldProjectItem.strCoverURL = cursor.getString(coverURLPos);
        oldProjectItem.strPrjVersion = cursor.getString(versionPos);
        oldProjectItem.strCreateTime = cursor.getString(createTimePos);
        oldProjectItem.strModifyTime = cursor.getString(modifyTimePos);
        oldProjectItem.iIsDeleted = cursor.getInt(isDeletedPos);
        oldProjectItem.iIsModified = cursor.getInt(isModifiedPos);
        oldProjectItem.streamWidth = cursor.getInt(streamWidthPos);
        oldProjectItem.streamHeight = cursor.getInt(streamHeightPos);
        oldProjectItem.usedEffectTempId = cursor.getLong(effectIDPos);
        oldProjectItem.todoCode = cursor.getInt(todoCodePos);
        oldProjectItem.editStatus = cursor.getInt(editCodePos);
        oldProjectItem.iCameraCode = cursor.getInt(cameraCodePos);
        oldProjectItem.strExtra = cursor.getString(extrasPos);
        oldProjectItem.nDurationLimit = cursor.getInt(durationLimitPos);
        oldProjectItem.prjThemeType = cursor.getInt(themeTypePos);
        oldProjectItem.strPrjTitle = cursor.getString(titlePos);
        oldProjectItem.strVideoDesc = cursor.getString(videoDescPos);
        oldProjectItem.strActivityData = cursor.getString(activityDataPos);
        oldProjectItem.iPrjGpsAccuracy = cursor.getInt(gpsAccuracyPos);
        oldProjectItem.dPrjLatitude = cursor.getDouble(latitudePos);
        oldProjectItem.dPrjLongitude = cursor.getDouble(longitudePos);
        oldProjectItem.strPrjAddress = cursor.getString(addressPos);
        oldProjectItem.strPrjAddressDetail = cursor.getString(addressDetailPos);
        return oldProjectItem;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002c, code lost:
        if (r2 != null) goto L_0x003b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0039, code lost:
        if (r2 != null) goto L_0x003b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x003b, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x003e, code lost:
        r5.endTransaction();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0045, code lost:
        if (r0.size() <= 0) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0049, code lost:
        if (projectUpdateListener == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x004b, code lost:
        projectUpdateListener.handleProjectUpdate(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:?, code lost:
        return;
     */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0054  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void handleProjectMove(android.database.sqlite.SQLiteDatabase r5) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            r5.beginTransaction()     // Catch:{ Exception -> 0x0032, all -> 0x002f }
            java.lang.String r2 = "select * from Project"
            android.database.Cursor r2 = r5.rawQuery(r2, r1)     // Catch:{ Exception -> 0x0032, all -> 0x002f }
            if (r2 == 0) goto L_0x0029
        L_0x0011:
            boolean r1 = r2.moveToNext()     // Catch:{ Exception -> 0x0027 }
            if (r1 == 0) goto L_0x0029
            com.introvd.template.datacenter.project.OldProjectItem r1 = cursorToItem(r2)     // Catch:{ Exception -> 0x0027 }
            java.lang.String r3 = r1.strPrjURL     // Catch:{ Exception -> 0x0027 }
            boolean r3 = isFileExisted(r3)     // Catch:{ Exception -> 0x0027 }
            if (r3 == 0) goto L_0x0011
            r0.add(r1)     // Catch:{ Exception -> 0x0027 }
            goto L_0x0011
        L_0x0027:
            r1 = move-exception
            goto L_0x0036
        L_0x0029:
            r5.setTransactionSuccessful()     // Catch:{ Exception -> 0x0027 }
            if (r2 == 0) goto L_0x003e
            goto L_0x003b
        L_0x002f:
            r0 = move-exception
            r2 = r1
            goto L_0x0052
        L_0x0032:
            r2 = move-exception
            r4 = r2
            r2 = r1
            r1 = r4
        L_0x0036:
            r1.printStackTrace()     // Catch:{ all -> 0x0051 }
            if (r2 == 0) goto L_0x003e
        L_0x003b:
            r2.close()
        L_0x003e:
            r5.endTransaction()
            int r5 = r0.size()
            if (r5 <= 0) goto L_0x0050
            com.introvd.template.datacenter.project.PrjTableUpgradeUtil$IProjectUpdateListener r5 = projectUpdateListener
            if (r5 == 0) goto L_0x0050
            com.introvd.template.datacenter.project.PrjTableUpgradeUtil$IProjectUpdateListener r5 = projectUpdateListener
            r5.handleProjectUpdate(r0)
        L_0x0050:
            return
        L_0x0051:
            r0 = move-exception
        L_0x0052:
            if (r2 == 0) goto L_0x0057
            r2.close()
        L_0x0057:
            r5.endTransaction()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.datacenter.project.PrjTableUpgradeUtil.handleProjectMove(android.database.sqlite.SQLiteDatabase):void");
    }

    private static boolean isFileExisted(String str) {
        boolean z = false;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File file = new File(str);
        if (file.isFile() && file.exists()) {
            z = true;
        }
        return z;
    }

    public static void setProjectUpdateListener(IProjectUpdateListener iProjectUpdateListener) {
        projectUpdateListener = iProjectUpdateListener;
    }
}
