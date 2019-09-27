package com.introvd.template.datacenter;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import com.introvd.template.datacenter.model.ProjectSocialParameter;
import com.introvd.template.p243e.C5542a;
import com.introvd.template.p309f.C7349c;
import com.introvd.template.p309f.C7352f;
import com.xiaoying.p448a.C9561c;
import java.util.Calendar;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

public class SocialServiceVideoNotify extends BaseSocialNotify {
    private static SocialServiceVideoNotify INSTANCE = null;
    public static final String TAG = "SocialServiceVideoNotify";
    private static Object mObjUpdateProgress = new Object();
    private static Map<String, ProjectSocialParameter> mProjectCancelingMap = Collections.synchronizedMap(new LinkedHashMap());
    private static Map<String, ProjectSocialParameter> mProjectSocialParamMap = Collections.synchronizedMap(new LinkedHashMap());
    private static C5542a mServiceCB = null;
    private static boolean mbUpdateProgress = true;

    public static String formatToServerDateTime(long j) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j);
        return String.format(Locale.US, "%04d%02d%02d%02d%02d%02d", new Object[]{Integer.valueOf(instance.get(1)), Integer.valueOf(instance.get(2) + 1), Integer.valueOf(instance.get(5)), Integer.valueOf(instance.get(11)), Integer.valueOf(instance.get(12)), Integer.valueOf(instance.get(13))});
    }

    public static synchronized SocialServiceVideoNotify getInstance() {
        SocialServiceVideoNotify socialServiceVideoNotify;
        synchronized (SocialServiceVideoNotify.class) {
            if (INSTANCE == null) {
                INSTANCE = new SocialServiceVideoNotify();
            }
            socialServiceVideoNotify = INSTANCE;
        }
        return socialServiceVideoNotify;
    }

    public static synchronized void setServiceCB(C5542a aVar) {
        synchronized (SocialServiceVideoNotify.class) {
            mServiceCB = aVar;
        }
    }

    public static void showPublishNotification(Context context, Bundle bundle) {
        if (mServiceCB != null) {
            try {
                mServiceCB.onExecuteServiceNotify("key_notification", 0, bundle);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void startNextPendingTask(Context context, long j) {
        Intent intent = new Intent(SocialServiceDef.ACTION_SOCIAL_TASK);
        intent.putExtra(SocialServiceDef.EXTRAS_SERVICE_TASK_DELAY, j);
        intent.setPackage(context.getPackageName());
        C9561c.m27511k(context, intent);
    }

    private void storeMethodResult(Context context, String str, ProjectSocialParameter projectSocialParameter) {
        if (projectSocialParameter != null) {
        }
    }

    private static int updateDBSubTaskTypeAndState(Context context, String str, int i, int i2, int i3) {
        return C7352f.m21693a(context.getContentResolver(), str, i, i2, i3);
    }

    public static boolean updateExportFileResult(Context context, String str) {
        ProjectSocialParameter projectSocialParameter = (ProjectSocialParameter) mProjectSocialParamMap.get(str);
        boolean z = false;
        if (projectSocialParameter == null) {
            return false;
        }
        Cursor f = C7349c.m21687f(context.getContentResolver(), str);
        if (f == null) {
            return false;
        }
        if (f.moveToFirst()) {
            projectSocialParameter.strThumbLocalBig = f.getString(0);
            projectSocialParameter.strPosterLocal = "";
            projectSocialParameter.strVideoLocal = f.getString(2);
            z = true;
        }
        f.close();
        updateSubTaskTypeAndState(context, projectSocialParameter, 1, 196608);
        return z;
    }

    private static void updateSubTaskTypeAndState(Context context, ProjectSocialParameter projectSocialParameter, int i, int i2) {
        updateSubTaskTypeAndState(context, projectSocialParameter, i, i2, -1);
    }

    private static void updateSubTaskTypeAndState(Context context, ProjectSocialParameter projectSocialParameter, int i, int i2, int i3) {
        if (projectSocialParameter != null) {
            updateDBSubTaskTypeAndState(context, projectSocialParameter.strTaskID, i, i2, i3);
            Bundle bundle = new Bundle();
            bundle.putInt("state", i2);
            bundle.putInt(SocialConstDef.TASK_SUB_TYPE, i);
            bundle.putInt("_id", Integer.valueOf(projectSocialParameter.strPublishID).intValue());
            bundle.putString(SocialConstDef.PUBLISH_PROJECT_TITLE, projectSocialParameter.strProjectShortName);
            bundle.putInt(SocialConstDef.SHARE_SNS_TYPE, -1);
            synchronized (mObjUpdateProgress) {
                if (i2 == 65536 || i2 == 262144 || i2 == 327680) {
                    mbUpdateProgress = false;
                } else {
                    try {
                        mbUpdateProgress = true;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                showPublishNotification(context, bundle);
            }
        }
    }

    private void updateTaskProgress(Context context, String str, long j, long j2) {
        C7352f.m21695a(context.getContentResolver(), str, j, j2);
    }

    public ProjectSocialParameter getPublishParam(String str) {
        ProjectSocialParameter projectSocialParameter;
        synchronized (mProjectSocialParamMap) {
            projectSocialParameter = (ProjectSocialParameter) mProjectSocialParamMap.get(str);
        }
        return projectSocialParameter;
    }

    public synchronized void onHandleIntentFailed(Context context, Intent intent) {
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x005f A[Catch:{ all -> 0x0058 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onNotify(android.content.Context r20, java.lang.String r21, java.lang.Object r22, int r23, int r24, android.content.Intent r25, com.introvd.template.p243e.C5542a r26) {
        /*
            r19 = this;
            r7 = r19
            r2 = r20
            r3 = r21
            r0 = r22
            r4 = r23
            r1 = r24
            r5 = r25
            if (r4 != 0) goto L_0x0011
            return
        L_0x0011:
            r6 = 0
            if (r5 == 0) goto L_0x0019
            android.os.Bundle r8 = r25.getExtras()
            goto L_0x001a
        L_0x0019:
            r8 = r6
        L_0x001a:
            if (r8 != 0) goto L_0x0021
            android.os.Bundle r8 = new android.os.Bundle
            r8.<init>()
        L_0x0021:
            r15 = r8
            java.lang.String r8 = "social_method"
            r15.putString(r8, r3)
            r11 = 0
            r13 = 0
            r8 = r15
            r9 = r21
            r10 = r24
            fillFeedbackParam(r8, r9, r10, r11, r13)
            r16 = 0
            r13 = 131072(0x20000, float:1.83671E-40)
            if (r4 == r13) goto L_0x005b
            if (r1 == 0) goto L_0x005b
            java.lang.String r8 = "socialservice.action.VIDEO"
            boolean r6 = com.introvd.template.datacenter.SocialExceptionHandler.handleErrCode(r2, r8, r3, r1, r6)     // Catch:{ all -> 0x0058 }
            if (r6 == 0) goto L_0x005b
            r11 = 0
            r17 = 0
            r8 = r20
            r9 = r21
            r10 = r24
            r6 = 131072(0x20000, float:1.83671E-40)
            r13 = r17
            reportNetworkError(r8, r9, r10, r11, r13)     // Catch:{ all -> 0x0058 }
            r7.onHandleIntentFailed(r2, r5)     // Catch:{ all -> 0x0058 }
            goto L_0x005d
        L_0x0058:
            r0 = move-exception
            goto L_0x0129
        L_0x005b:
            r6 = 131072(0x20000, float:1.83671E-40)
        L_0x005d:
            if (r0 == 0) goto L_0x013f
            boolean r5 = r0 instanceof com.introvd.template.datacenter.model.ProjectSocialParameter     // Catch:{ all -> 0x0058 }
            if (r5 != 0) goto L_0x0065
            goto L_0x013f
        L_0x0065:
            com.introvd.template.datacenter.model.ProjectSocialParameter r0 = (com.introvd.template.datacenter.model.ProjectSocialParameter) r0     // Catch:{ all -> 0x0058 }
            java.lang.String r5 = r0.strPublishID     // Catch:{ all -> 0x0058 }
            java.util.Map<java.lang.String, com.introvd.template.datacenter.model.ProjectSocialParameter> r8 = mProjectCancelingMap     // Catch:{ all -> 0x0058 }
            boolean r8 = r8.containsKey(r5)     // Catch:{ all -> 0x0058 }
            r13 = 1
            if (r8 != 0) goto L_0x007a
            java.util.Map<java.lang.String, com.introvd.template.datacenter.model.ProjectSocialParameter> r8 = mProjectSocialParamMap     // Catch:{ all -> 0x0058 }
            boolean r8 = r8.containsKey(r5)     // Catch:{ all -> 0x0058 }
            if (r8 != 0) goto L_0x007c
        L_0x007a:
            r16 = 1
        L_0x007c:
            java.lang.String r8 = TAG     // Catch:{ all -> 0x0058 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x0058 }
            r9.<init>()     // Catch:{ all -> 0x0058 }
            java.lang.String r10 = "onNotify, method:"
            r9.append(r10)     // Catch:{ all -> 0x0058 }
            r9.append(r3)     // Catch:{ all -> 0x0058 }
            java.lang.String r10 = ", result:"
            r9.append(r10)     // Catch:{ all -> 0x0058 }
            r9.append(r4)     // Catch:{ all -> 0x0058 }
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x0058 }
            com.introvd.template.common.LogUtils.m14222e(r8, r9)     // Catch:{ all -> 0x0058 }
            if (r4 != r6) goto L_0x00b5
            java.lang.String r8 = TAG     // Catch:{ all -> 0x0058 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x0058 }
            r9.<init>()     // Catch:{ all -> 0x0058 }
            java.lang.String r10 = " === storeMethodResult strMethod "
            r9.append(r10)     // Catch:{ all -> 0x0058 }
            r9.append(r3)     // Catch:{ all -> 0x0058 }
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x0058 }
            com.introvd.template.common.LogUtils.m14223i(r8, r9)     // Catch:{ all -> 0x0058 }
            r7.storeMethodResult(r2, r3, r0)     // Catch:{ all -> 0x0058 }
        L_0x00b5:
            if (r16 != 0) goto L_0x00d0
            if (r4 == r6) goto L_0x00ba
            goto L_0x00d0
        L_0x00ba:
            if (r16 == 0) goto L_0x00c1
            java.util.Map<java.lang.String, com.introvd.template.datacenter.model.ProjectSocialParameter> r0 = mProjectCancelingMap
            r0.remove(r3)
        L_0x00c1:
            r1 = r19
            r2 = r20
            r3 = r21
            r4 = r23
            r5 = r15
            r6 = r26
            r1.notifyAllListener(r2, r3, r4, r5, r6)
            return
        L_0x00d0:
            java.util.Map<java.lang.String, com.introvd.template.datacenter.model.ProjectSocialParameter> r6 = mProjectSocialParamMap     // Catch:{ all -> 0x0058 }
            monitor-enter(r6)     // Catch:{ all -> 0x0058 }
            java.util.Map<java.lang.String, com.introvd.template.datacenter.model.ProjectSocialParameter> r0 = mProjectSocialParamMap     // Catch:{ all -> 0x0126 }
            r0.remove(r5)     // Catch:{ all -> 0x0126 }
            monitor-exit(r6)     // Catch:{ all -> 0x0126 }
            r0 = 65536(0x10000, float:9.18355E-41)
            if (r4 != r0) goto L_0x0101
            if (r1 == 0) goto L_0x0101
            java.lang.String r0 = "socialservice.action.VIDEO"
            boolean r0 = com.introvd.template.datacenter.SocialExceptionHandler.handleErrCode(r2, r0, r3, r1, r5)     // Catch:{ all -> 0x0058 }
            if (r0 == 0) goto L_0x00f7
            r11 = 0
            r5 = 0
            r8 = r20
            r9 = r21
            r10 = r24
            r0 = 1
            r13 = r5
            reportNetworkError(r8, r9, r10, r11, r13)     // Catch:{ all -> 0x0058 }
            goto L_0x00f8
        L_0x00f7:
            r0 = 1
        L_0x00f8:
            com.introvd.template.common.AppPreferencesSetting r1 = com.introvd.template.common.AppPreferencesSetting.getInstance()     // Catch:{ all -> 0x0058 }
            java.lang.String r5 = "pref_video_upload_err_key"
            r1.setAppSettingBoolean(r5, r0)     // Catch:{ all -> 0x0058 }
        L_0x0101:
            r0 = 60000(0xea60, float:8.4078E-41)
            if (r16 != 0) goto L_0x010a
            r1 = 458752(0x70000, float:6.42848E-40)
            if (r4 != r1) goto L_0x010c
        L_0x010a:
            r0 = 3000(0xbb8, float:4.204E-42)
        L_0x010c:
            long r0 = (long) r0     // Catch:{ all -> 0x0058 }
            r7.startNextPendingTask(r2, r0)     // Catch:{ all -> 0x0058 }
            if (r16 == 0) goto L_0x0117
            java.util.Map<java.lang.String, com.introvd.template.datacenter.model.ProjectSocialParameter> r0 = mProjectCancelingMap
            r0.remove(r3)
        L_0x0117:
            r1 = r19
            r2 = r20
            r3 = r21
            r4 = r23
            r5 = r15
            r6 = r26
            r1.notifyAllListener(r2, r3, r4, r5, r6)
            return
        L_0x0126:
            r0 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x0126 }
            throw r0     // Catch:{ all -> 0x0058 }
        L_0x0129:
            if (r16 == 0) goto L_0x0130
            java.util.Map<java.lang.String, com.introvd.template.datacenter.model.ProjectSocialParameter> r1 = mProjectCancelingMap
            r1.remove(r3)
        L_0x0130:
            r1 = r19
            r2 = r20
            r3 = r21
            r4 = r23
            r5 = r15
            r6 = r26
            r1.notifyAllListener(r2, r3, r4, r5, r6)
            throw r0
        L_0x013f:
            r1 = r19
            r2 = r20
            r3 = r21
            r4 = r23
            r5 = r15
            r6 = r26
            r1.notifyAllListener(r2, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.datacenter.SocialServiceVideoNotify.onNotify(android.content.Context, java.lang.String, java.lang.Object, int, int, android.content.Intent, com.introvd.template.e.a):void");
    }

    public void updateUploadingProgress(Context context, String str, long j, long j2) {
        ProjectSocialParameter projectSocialParameter = (ProjectSocialParameter) mProjectSocialParamMap.get(str);
        if (projectSocialParameter != null) {
            updateTaskProgress(context, projectSocialParameter.strTaskID, j, j2);
            Bundle bundle = new Bundle();
            bundle.putInt("state", 196608);
            bundle.putInt(SocialConstDef.TASK_SUB_TYPE, projectSocialParameter.nCurrentStep);
            bundle.putInt("_id", Integer.valueOf(projectSocialParameter.strPublishID).intValue());
            bundle.putString(SocialConstDef.PUBLISH_PROJECT_TITLE, projectSocialParameter.strProjectShortName);
            bundle.putInt(SocialConstDef.SHARE_SNS_TYPE, -1);
            synchronized (mObjUpdateProgress) {
                if (mbUpdateProgress) {
                    showPublishNotification(context, bundle);
                }
            }
        }
    }
}
