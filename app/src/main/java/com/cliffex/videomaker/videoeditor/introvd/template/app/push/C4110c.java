package com.introvd.template.app.push;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.support.p021v4.app.NotificationCompat.BigTextStyle;
import android.support.p021v4.app.NotificationCompat.Builder;
import android.text.TextUtils;
import com.introvd.template.R;
import com.introvd.template.app.notification.C4071a;
import com.introvd.template.app.splash.SplashActivity;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.common.behavior.UserBehaviorUtilsV5;
import com.introvd.template.editor.p252e.C5878a;
import com.p131c.p132a.p135c.C2575a;
import com.quvideo.mobile.component.push.C4793c;
import org.json.JSONObject;

/* renamed from: com.introvd.template.app.push.c */
class C4110c implements C4793c {
    C4110c() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x012c  */
    /* JADX WARNING: Removed duplicated region for block: B:59:? A[RETURN, SYNTHETIC] */
    /* renamed from: Q */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m10204Q(android.content.Context r18, java.lang.String r19) {
        /*
            r17 = this;
            r1 = r18
            r2 = r19
            java.lang.String r3 = ""
            r4 = -1
            r5 = 1
            r6 = 0
            r7 = 0
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0059 }
            r0.<init>(r2)     // Catch:{ JSONException -> 0x0059 }
            java.lang.String r9 = "cancelReason"
            int r9 = r0.optInt(r9)     // Catch:{ JSONException -> 0x0059 }
            java.lang.String r10 = "cancelSurveyResult"
            org.json.JSONObject r10 = r0.optJSONObject(r10)     // Catch:{ JSONException -> 0x0056 }
            if (r10 == 0) goto L_0x0025
            java.lang.String r11 = "cancelSurveyReason"
            int r10 = r10.optInt(r11)     // Catch:{ JSONException -> 0x0056 }
            r4 = r10
        L_0x0025:
            java.lang.String r10 = "notificationType"
            int r10 = r0.optInt(r10)     // Catch:{ JSONException -> 0x0056 }
            java.lang.String r11 = "expiryTimeMillis"
            long r11 = r0.optLong(r11)     // Catch:{ JSONException -> 0x0053 }
            java.lang.String r7 = "developerPayload"
            java.lang.String r7 = r0.optString(r7)     // Catch:{ JSONException -> 0x0051 }
            boolean r8 = android.text.TextUtils.isEmpty(r7)     // Catch:{ JSONException -> 0x0051 }
            if (r8 != 0) goto L_0x0048
            java.lang.String r8 = "QUVIDEO"
            int r8 = r7.indexOf(r8)     // Catch:{ JSONException -> 0x0051 }
            java.lang.String r7 = r7.substring(r6, r8)     // Catch:{ JSONException -> 0x0051 }
            r3 = r7
        L_0x0048:
            java.lang.String r7 = "paymentState"
            int r0 = r0.optInt(r7)     // Catch:{ JSONException -> 0x0051 }
            r7 = r4
            r4 = r0
            goto L_0x0062
        L_0x0051:
            r0 = move-exception
            goto L_0x005d
        L_0x0053:
            r0 = move-exception
            r11 = r7
            goto L_0x005d
        L_0x0056:
            r0 = move-exception
            r11 = r7
            goto L_0x005c
        L_0x0059:
            r0 = move-exception
            r11 = r7
            r9 = -1
        L_0x005c:
            r10 = 0
        L_0x005d:
            r0.printStackTrace()
            r7 = r4
            r4 = 1
        L_0x0062:
            r8 = 5
            if (r10 == r8) goto L_0x0067
            if (r10 != r5) goto L_0x0090
        L_0x0067:
            com.introvd.template.common.AppPreferencesSetting r0 = com.introvd.template.common.AppPreferencesSetting.getInstance()
            java.lang.String r13 = "pref_iap_risk_tip_id"
            r0.setAppSettingStr(r13, r3)
            com.introvd.template.common.AppPreferencesSetting r0 = com.introvd.template.common.AppPreferencesSetting.getInstance()
            java.lang.String r3 = "pref_iap_risk_tip_state"
            r0.setAppSettingInt(r3, r4)
            com.introvd.template.common.AppPreferencesSetting r0 = com.introvd.template.common.AppPreferencesSetting.getInstance()
            java.lang.String r3 = "pref_iap_risk_tip_time"
            long r13 = java.lang.System.currentTimeMillis()
            r15 = 2592000000(0x9a7ec800, double:1.280618154E-314)
            long r13 = r13 + r15
            java.lang.String r13 = java.lang.String.valueOf(r13)
            r0.setAppSettingStr(r3, r13)
        L_0x0090:
            com.introvd.template.app.notification.c$a r3 = new com.introvd.template.app.notification.c$a
            r3.<init>()
            int r0 = com.introvd.template.R.string.xiaoying_str_community_notification_video_title
            java.lang.String r0 = r1.getString(r0)
            r3.title = r0
            r13 = 7
            r14 = 6
            r15 = 3
            if (r10 != r8) goto L_0x00ab
            int r5 = com.introvd.template.R.string.xiaoying_str_subscribe_message_hold
            java.lang.String r5 = r1.getString(r5)
            r3.content = r5
            goto L_0x00fc
        L_0x00ab:
            if (r10 != r15) goto L_0x00be
            int r15 = com.introvd.template.R.string.xiaoying_str_subscribe_message_cancel
            java.lang.Object[] r5 = new java.lang.Object[r5]
            java.lang.String r11 = com.introvd.template.p203b.C4584e.m11674X(r11)
            r5[r6] = r11
            java.lang.String r5 = r1.getString(r15, r5)
            r3.content = r5
            goto L_0x00fc
        L_0x00be:
            if (r10 != r14) goto L_0x00f2
            int r15 = com.introvd.template.R.string.xiaoying_str_subscribe_message_grace_period
            java.lang.Object[] r5 = new java.lang.Object[r5]
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            java.util.Date r8 = new java.util.Date
            r8.<init>(r11)
            java.util.Date r11 = new java.util.Date
            long r0 = java.lang.System.currentTimeMillis()
            r11.<init>(r0)
            int r0 = com.introvd.template.p203b.C4584e.m11683e(r8, r11)
            r14.append(r0)
            java.lang.String r0 = ""
            r14.append(r0)
            java.lang.String r0 = r14.toString()
            r5[r6] = r0
            r1 = r18
            java.lang.String r0 = r1.getString(r15, r5)
            r3.content = r0
            goto L_0x00fc
        L_0x00f2:
            if (r10 != r13) goto L_0x00fc
            int r0 = com.introvd.template.R.string.xiaoying_str_subscribe_message_restarted
            java.lang.String r0 = r1.getString(r0)
            r3.content = r0
        L_0x00fc:
            org.json.JSONObject r5 = new org.json.JSONObject
            r5.<init>()
            java.lang.String r0 = "a"
            r8 = 17001(0x4269, float:2.3823E-41)
            r5.put(r0, r8)     // Catch:{ Throwable -> 0x010e }
            java.lang.String r0 = "b"
            r5.put(r0, r2)     // Catch:{ Throwable -> 0x010e }
            goto L_0x0112
        L_0x010e:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0112:
            r2 = 5
            if (r10 == r2) goto L_0x011f
            r2 = 6
            if (r10 == r2) goto L_0x011f
            if (r10 == r13) goto L_0x011f
            r2 = 3
            if (r10 != r2) goto L_0x0126
            if (r9 != 0) goto L_0x0126
        L_0x011f:
            java.lang.String r0 = r5.toString()
            com.introvd.template.app.notification.C4074c.m10125a(r1, r0, r6, r3)
        L_0x0126:
            com.introvd.template.module.iap.business.p352b.C7835b.m22854ds(r10, r4)
            r1 = 3
            if (r10 != r1) goto L_0x012f
            com.introvd.template.module.iap.business.p352b.C7835b.m22855dt(r9, r7)
        L_0x012f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.app.push.C4110c.m10204Q(android.content.Context, java.lang.String):void");
    }

    /* renamed from: a */
    private void m10205a(Context context, String str, int i, String str2) {
        m10206a(context, str, i, "", "", str2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00f9  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m10206a(android.content.Context r17, java.lang.String r18, int r19, java.lang.String r20, java.lang.String r21, java.lang.String r22) {
        /*
            r16 = this;
            r7 = r16
            r0 = r17
            r1 = r18
            r2 = r19
            r3 = r20
            r4 = r21
            r5 = r22
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r8 = "handleExtrasCommand strExtras="
            r6.append(r8)
            r6.append(r1)
            java.lang.String r8 = ";nEventType="
            r6.append(r8)
            r6.append(r2)
            java.lang.String r6 = r6.toString()
            com.introvd.template.common.LogUtilsV2.m14230i(r6)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r8 = "handleExtrasCommand strTitle="
            r6.append(r8)
            r6.append(r3)
            java.lang.String r8 = ";strMsg="
            r6.append(r8)
            r6.append(r4)
            java.lang.String r6 = r6.toString()
            com.introvd.template.common.LogUtilsV2.m14230i(r6)
            java.lang.String r6 = ""
            java.lang.String r8 = ""
            com.introvd.template.app.notification.c$a r15 = new com.introvd.template.app.notification.c$a
            r15.<init>()
            r15.title = r3
            r15.content = r4
            r15.bvh = r5
            org.json.JSONObject r9 = new org.json.JSONObject     // Catch:{ Exception -> 0x00a6 }
            r9.<init>(r1)     // Catch:{ Exception -> 0x00a6 }
            java.lang.String r10 = "event"
            java.lang.String r10 = r9.optString(r10)     // Catch:{ Exception -> 0x00a6 }
            boolean r6 = android.text.TextUtils.isEmpty(r10)     // Catch:{ Exception -> 0x00a7 }
            if (r6 == 0) goto L_0x0067
            return
        L_0x0067:
            java.lang.String r6 = "message_type"
            java.lang.String r6 = r9.optString(r6)     // Catch:{ Exception -> 0x00a7 }
            java.lang.String r8 = "unique_messageid"
            java.lang.String r8 = r9.optString(r8)     // Catch:{ Exception -> 0x00a8 }
            r15.bvg = r8     // Catch:{ Exception -> 0x00a8 }
            java.lang.String r8 = r15.bvg     // Catch:{ Exception -> 0x00a8 }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ Exception -> 0x00a8 }
            if (r8 == 0) goto L_0x0085
            java.lang.String r8 = "messageId"
            java.lang.String r8 = r9.optString(r8)     // Catch:{ Exception -> 0x00a8 }
            r15.bvg = r8     // Catch:{ Exception -> 0x00a8 }
        L_0x0085:
            java.lang.String r8 = "pushMsgID"
            java.lang.String r8 = r9.optString(r8)     // Catch:{ Exception -> 0x00a8 }
            r15.bvi = r8     // Catch:{ Exception -> 0x00a8 }
            java.lang.String r8 = "PUSH_TYPE"
            java.lang.String r8 = r9.optString(r8)     // Catch:{ Exception -> 0x00a8 }
            r15.bvf = r8     // Catch:{ Exception -> 0x00a8 }
            java.lang.String r8 = r15.bvc     // Catch:{ Exception -> 0x00a8 }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ Exception -> 0x00a8 }
            if (r8 == 0) goto L_0x00ad
            java.lang.String r8 = "img_url"
            java.lang.String r8 = r9.optString(r8)     // Catch:{ Exception -> 0x00a8 }
            r15.bvc = r8     // Catch:{ Exception -> 0x00a8 }
            goto L_0x00ad
        L_0x00a6:
            r10 = r6
        L_0x00a7:
            r6 = r8
        L_0x00a8:
            java.lang.String r8 = "Unexpected: extras is not a valid json"
            com.introvd.template.common.LogUtilsV2.m14228e(r8)
        L_0x00ad:
            r8 = r6
            r6 = r10
            java.lang.String r9 = "XiaoYingActivityWeakRef"
            r10 = 0
            r12 = 0
            java.lang.Object r9 = com.introvd.template.common.MagicCode.getMagicParam(r10, r9, r12)
            java.lang.ref.WeakReference r9 = (java.lang.ref.WeakReference) r9
            if (r9 == 0) goto L_0x00c3
            java.lang.Object r9 = r9.get()
            android.app.Activity r9 = (android.app.Activity) r9
            goto L_0x00c4
        L_0x00c3:
            r9 = r12
        L_0x00c4:
            r13 = 4
            if (r2 != r13) goto L_0x00f9
            if (r9 == 0) goto L_0x00d2
            com.introvd.template.router.todoCode.TODOParamModel r0 = com.introvd.template.app.C4027k.m9995dj(r6)
            com.introvd.template.app.C4027k.m9994a(r9, r12, r0)
            goto L_0x0391
        L_0x00d2:
            android.content.Intent r1 = new android.content.Intent
            java.lang.Class<com.introvd.template.app.splash.SplashActivity> r2 = com.introvd.template.app.splash.SplashActivity.class
            r1.<init>(r0, r2)
            r2 = 805306368(0x30000000, float:4.656613E-10)
            r1.setFlags(r2)
            java.lang.String r2 = "android.intent.action.MAIN"
            r1.setAction(r2)
            java.lang.String r2 = "android.intent.category.LAUNCHER"
            r1.addCategory(r2)
            java.lang.String r2 = "event"
            r1.putExtra(r2, r6)
            java.lang.String r2 = "PushService"
            java.lang.String r3 = "PushService"
            r1.putExtra(r2, r3)
            r0.startActivity(r1)
            goto L_0x0391
        L_0x00f9:
            r13 = 2
            r14 = 1
            if (r2 != r13) goto L_0x014b
            r1 = 300(0x12c, float:4.2E-43)
            boolean r2 = com.introvd.template.app.splash.C4370e.m10999QA()
            if (r2 != 0) goto L_0x0108
            r10 = 1000(0x3e8, float:1.401E-42)
            goto L_0x010a
        L_0x0108:
            r10 = 300(0x12c, float:4.2E-43)
        L_0x010a:
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r14)
            b.b.l r1 = p037b.p050b.C1834l.m5257ah(r1)
            b.b.r r2 = p037b.p050b.p076j.C1820a.aVi()
            b.b.l r1 = r1.mo10157d(r2)
            b.b.r r2 = p037b.p050b.p076j.C1820a.aVi()
            b.b.l r1 = r1.mo10152c(r2)
            long r2 = (long) r10
            java.util.concurrent.TimeUnit r4 = java.util.concurrent.TimeUnit.MILLISECONDS
            b.b.l r1 = r1.mo10164f(r2, r4)
            b.b.r r2 = p037b.p050b.p051a.p053b.C1487a.aUa()
            b.b.l r1 = r1.mo10157d(r2)
            b.b.r r2 = p037b.p050b.p051a.p053b.C1487a.aUa()
            b.b.l r8 = r1.mo10152c(r2)
            com.introvd.template.app.push.c$1 r9 = new com.introvd.template.app.push.c$1
            r1 = r9
            r2 = r16
            r3 = r22
            r4 = r15
            r5 = r17
            r1.<init>(r3, r4, r5, r6)
            r8.mo10149b(r9)
            goto L_0x0391
        L_0x014b:
            org.json.JSONObject r11 = new org.json.JSONObject     // Catch:{ Throwable -> 0x0392 }
            r11.<init>(r6)     // Catch:{ Throwable -> 0x0392 }
            int r13 = r7.m10208e(r11)     // Catch:{ Throwable -> 0x0392 }
            java.lang.String r10 = "b"
            java.lang.String r10 = r11.optString(r10)     // Catch:{ Throwable -> 0x0392 }
            boolean r11 = android.text.TextUtils.isEmpty(r10)     // Catch:{ Throwable -> 0x0392 }
            if (r11 != 0) goto L_0x01e4
            org.json.JSONObject r11 = new org.json.JSONObject     // Catch:{ Throwable -> 0x0392 }
            r11.<init>(r10)     // Catch:{ Throwable -> 0x0392 }
            java.lang.String r12 = "thumbUrl"
            java.lang.String r12 = r11.optString(r12)     // Catch:{ Throwable -> 0x0392 }
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0392 }
            r14.<init>()     // Catch:{ Throwable -> 0x0392 }
            java.lang.String r2 = "thumbUrl is "
            r14.append(r2)     // Catch:{ Throwable -> 0x0392 }
            r14.append(r12)     // Catch:{ Throwable -> 0x0392 }
            java.lang.String r2 = r14.toString()     // Catch:{ Throwable -> 0x0392 }
            com.introvd.template.common.LogUtilsV2.m14230i(r2)     // Catch:{ Throwable -> 0x0392 }
            boolean r2 = android.text.TextUtils.isEmpty(r12)     // Catch:{ Throwable -> 0x0392 }
            if (r2 != 0) goto L_0x0187
            r15.bvc = r12     // Catch:{ Throwable -> 0x0392 }
        L_0x0187:
            java.lang.String r2 = "imageUrl"
            java.lang.String r2 = r11.optString(r2)     // Catch:{ Throwable -> 0x0392 }
            r15.bvd = r2     // Catch:{ Throwable -> 0x0392 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0392 }
            r2.<init>()     // Catch:{ Throwable -> 0x0392 }
            java.lang.String r12 = "imageUrl is "
            r2.append(r12)     // Catch:{ Throwable -> 0x0392 }
            java.lang.String r12 = r15.bvd     // Catch:{ Throwable -> 0x0392 }
            r2.append(r12)     // Catch:{ Throwable -> 0x0392 }
            java.lang.String r2 = r2.toString()     // Catch:{ Throwable -> 0x0392 }
            com.introvd.template.common.LogUtilsV2.m14230i(r2)     // Catch:{ Throwable -> 0x0392 }
            java.lang.String r2 = "videoUrl"
            java.lang.String r2 = r11.optString(r2)     // Catch:{ Throwable -> 0x0392 }
            r15.videoUrl = r2     // Catch:{ Throwable -> 0x0392 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0392 }
            r2.<init>()     // Catch:{ Throwable -> 0x0392 }
            java.lang.String r12 = "videoUrl is "
            r2.append(r12)     // Catch:{ Throwable -> 0x0392 }
            java.lang.String r12 = r15.videoUrl     // Catch:{ Throwable -> 0x0392 }
            r2.append(r12)     // Catch:{ Throwable -> 0x0392 }
            java.lang.String r2 = r2.toString()     // Catch:{ Throwable -> 0x0392 }
            com.introvd.template.common.LogUtilsV2.m14230i(r2)     // Catch:{ Throwable -> 0x0392 }
            java.lang.String r2 = "customBody"
            java.lang.String r2 = r11.optString(r2)     // Catch:{ Throwable -> 0x0392 }
            boolean r11 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Throwable -> 0x0392 }
            if (r11 != 0) goto L_0x020c
            com.introvd.template.router.user.model.LoginUserInfo r11 = com.introvd.template.router.user.UserServiceProxy.getUserInfo()     // Catch:{ Throwable -> 0x0392 }
            if (r11 == 0) goto L_0x020c
            java.lang.String r11 = "[nickname]"
            com.introvd.template.router.user.model.LoginUserInfo r12 = com.introvd.template.router.user.UserServiceProxy.getUserInfo()     // Catch:{ Throwable -> 0x0392 }
            java.lang.String r12 = r12.nickname     // Catch:{ Throwable -> 0x0392 }
            java.lang.String r2 = r2.replace(r11, r12)     // Catch:{ Throwable -> 0x0392 }
            r15.content = r2     // Catch:{ Throwable -> 0x0392 }
            goto L_0x020c
        L_0x01e4:
            java.lang.String r2 = r15.content     // Catch:{ Throwable -> 0x0392 }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Throwable -> 0x0392 }
            if (r2 != 0) goto L_0x020c
            java.lang.String r2 = r15.content     // Catch:{ Throwable -> 0x0392 }
            java.lang.String r11 = "[nickname]"
            boolean r2 = r2.contains(r11)     // Catch:{ Throwable -> 0x0392 }
            if (r2 == 0) goto L_0x020c
            com.introvd.template.router.user.model.LoginUserInfo r2 = com.introvd.template.router.user.UserServiceProxy.getUserInfo()     // Catch:{ Throwable -> 0x0392 }
            if (r2 == 0) goto L_0x020c
            java.lang.String r2 = r15.content     // Catch:{ Throwable -> 0x0392 }
            java.lang.String r11 = "[nickname]"
            com.introvd.template.router.user.model.LoginUserInfo r12 = com.introvd.template.router.user.UserServiceProxy.getUserInfo()     // Catch:{ Throwable -> 0x0392 }
            java.lang.String r12 = r12.nickname     // Catch:{ Throwable -> 0x0392 }
            java.lang.String r2 = r2.replace(r11, r12)     // Catch:{ Throwable -> 0x0392 }
            r15.content = r2     // Catch:{ Throwable -> 0x0392 }
        L_0x020c:
            java.lang.String r2 = "GROUP"
            java.lang.String r11 = r15.bvf
            boolean r2 = r2.equals(r11)
            if (r2 == 0) goto L_0x022b
            android.support.v4.app.NotificationManagerCompat r2 = android.support.p021v4.app.NotificationManagerCompat.from(r17)
            boolean r2 = r2.areNotificationsEnabled()
            if (r2 != 0) goto L_0x0225
            java.lang.String r2 = r15.bvg
            com.introvd.template.common.behavior.UserBehaviorUtilsV5.recordNotificationDisable(r2)
        L_0x0225:
            java.lang.String r2 = r15.bvg
            com.introvd.template.common.behavior.UserBehaviorUtilsV5.recordPushReceived(r0, r2, r5)
            goto L_0x023f
        L_0x022b:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r13)
            java.lang.String r11 = ""
            r2.append(r11)
            java.lang.String r2 = r2.toString()
            com.introvd.template.common.behavior.UserBehaviorUtilsV5.recordPushReceived(r0, r2, r5)
        L_0x023f:
            if (r13 != 0) goto L_0x0242
            return
        L_0x0242:
            r2 = 17001(0x4269, float:2.3823E-41)
            if (r13 != r2) goto L_0x024a
            r7.m10204Q(r0, r10)
            return
        L_0x024a:
            r2 = 10001(0x2711, float:1.4014E-41)
            if (r13 != r2) goto L_0x025b
            com.introvd.template.router.todoCode.TODOParamModel r0 = new com.introvd.template.router.todoCode.TODOParamModel
            r0.<init>()
            r0.mTODOCode = r2
            r0.mJsonParam = r10
            com.introvd.template.app.push.AppQATestWorker.m10165b(r0)
            return
        L_0x025b:
            r2 = 10004(0x2714, float:1.4019E-41)
            if (r13 != r2) goto L_0x02a3
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "Jamin loadJS Push TODO 10004 strExtras = "
            r0.append(r2)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.introvd.template.common.LogUtilsV2.m14227d(r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Jamin loadJS Push TODO 10004 strTODOContent = "
            r0.append(r1)
            r0.append(r10)
            java.lang.String r0 = r0.toString()
            com.introvd.template.common.LogUtilsV2.m14227d(r0)
            if (r10 == 0) goto L_0x02a2
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ Exception -> 0x029e }
            r0.<init>(r10)     // Catch:{ Exception -> 0x029e }
            java.lang.String r1 = "url"
            java.lang.String r0 = r0.optString(r1)     // Catch:{ Exception -> 0x029e }
            com.introvd.template.common.AppPreferencesSetting r1 = com.introvd.template.common.AppPreferencesSetting.getInstance()     // Catch:{ Exception -> 0x029e }
            java.lang.String r2 = "pref_key_pass_through_web_url"
            r1.setAppSettingStr(r2, r0)     // Catch:{ Exception -> 0x029e }
            goto L_0x02a2
        L_0x029e:
            r0 = move-exception
            r0.printStackTrace()
        L_0x02a2:
            return
        L_0x02a3:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r13)
            java.lang.String r2 = ""
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            com.introvd.template.common.behavior.UserBehaviorUtilsV5.onEventPushReceiveForeground(r0, r1)
            com.introvd.template.app.p177b.C3741a.m9110IH()
            r1 = 908(0x38c, float:1.272E-42)
            if (r13 != r1) goto L_0x02c5
            if (r9 != 0) goto L_0x0391
            r7.m10207b(r0, r6, r3, r4)
            goto L_0x0391
        L_0x02c5:
            r1 = 21001(0x5209, float:2.9429E-41)
            if (r13 != r1) goto L_0x02f1
            r7.m10207b(r0, r6, r3, r4)
            if (r10 == 0) goto L_0x02de
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ Throwable -> 0x02da }
            r0.<init>(r10)     // Catch:{ Throwable -> 0x02da }
            java.lang.String r1 = "id"
            long r10 = r0.getLong(r1)     // Catch:{ Throwable -> 0x02da }
            goto L_0x02e0
        L_0x02da:
            r0 = move-exception
            r0.printStackTrace()
        L_0x02de:
            r10 = 0
        L_0x02e0:
            com.introvd.template.component.feedback.C5349b.m14580e(r9, r10)
            org.greenrobot.eventbus.c r0 = org.greenrobot.eventbus.C10021c.aZH()
            com.introvd.template.common.FeedbackRefreshEvent r1 = new com.introvd.template.common.FeedbackRefreshEvent
            r1.<init>()
            r0.mo38492aA(r1)
            goto L_0x0391
        L_0x02f1:
            java.lang.String r1 = "1"
            boolean r1 = r1.equals(r8)
            if (r1 == 0) goto L_0x037d
            r1 = 2001(0x7d1, float:2.804E-42)
            if (r13 == r1) goto L_0x0354
            r1 = 2002(0x7d2, float:2.805E-42)
            if (r13 == r1) goto L_0x0354
            r1 = 2003(0x7d3, float:2.807E-42)
            if (r13 == r1) goto L_0x0354
            r1 = 2004(0x7d4, float:2.808E-42)
            if (r13 == r1) goto L_0x0354
            r1 = 2005(0x7d5, float:2.81E-42)
            if (r13 != r1) goto L_0x030e
            goto L_0x0354
        L_0x030e:
            r1 = 1201(0x4b1, float:1.683E-42)
            if (r13 != r1) goto L_0x0321
            r1 = 1011(0x3f3, float:1.417E-42)
            r15.bve = r1
            r1 = 1
            com.introvd.template.app.notification.C4074c.m10125a(r0, r6, r1, r15)
            java.lang.String r1 = r15.bvg
            com.introvd.template.common.behavior.UserBehaviorUtilsV5.recordPushReceiveShow(r0, r1, r5)
            goto L_0x0391
        L_0x0321:
            r1 = 10002(0x2712, float:1.4016E-41)
            if (r13 != r1) goto L_0x0337
            com.introvd.template.router.todoCode.TODOParamModel r1 = new com.introvd.template.router.todoCode.TODOParamModel
            r1.<init>()
            r1.mTODOCode = r13
            r1.mJsonParam = r10
            com.introvd.template.router.todoCode.BizAppTodoActionManager r2 = com.introvd.template.router.todoCode.BizAppTodoActionManager.getInstance()
            r3 = 0
            r2.executeQATestTodo(r0, r1, r3)
            goto L_0x0391
        L_0x0337:
            r1 = 941(0x3ad, float:1.319E-42)
            if (r13 != r1) goto L_0x0343
            boolean r1 = com.introvd.template.app.notification.C4071a.m10116Nh()
            com.introvd.template.app.push.C4095a.m10167b(r0, r6, r1, r15)
            goto L_0x0391
        L_0x0343:
            r1 = 1000(0x3e8, float:1.401E-42)
            r15.bve = r1
            boolean r1 = com.introvd.template.app.notification.C4071a.m10116Nh()
            com.introvd.template.app.notification.C4074c.m10125a(r0, r6, r1, r15)
            java.lang.String r1 = r15.bvg
            com.introvd.template.common.behavior.UserBehaviorUtilsV5.recordPushReceiveShow(r0, r1, r5)
            goto L_0x0391
        L_0x0354:
            java.lang.String r1 = "GROUP"
            java.lang.String r2 = r15.bvf
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0368
            com.introvd.template.app.b.b r1 = com.introvd.template.app.p177b.C3742b.m9111II()
            boolean r1 = r1.mo23156Jc()
            if (r1 == 0) goto L_0x0391
        L_0x0368:
            java.lang.String r11 = r15.bvc
            java.lang.String r12 = r15.bvf
            java.lang.String r1 = r15.bvg
            java.lang.String r14 = r15.bvh
            r8 = r17
            r9 = r13
            r13 = r1
            com.introvd.template.app.push.C4103b.m10185a(r8, r9, r10, r11, r12, r13, r14)
            java.lang.String r1 = r15.bvg
            com.introvd.template.common.behavior.UserBehaviorUtilsV5.recordPushReceiveShow(r0, r1, r5)
            goto L_0x0391
        L_0x037d:
            r1 = 3
            r2 = r19
            if (r2 != r1) goto L_0x0391
            java.lang.String r1 = "MIPUSH"
            boolean r1 = r5.equals(r1)
            if (r1 != 0) goto L_0x0391
            boolean r1 = com.introvd.template.app.notification.C4071a.m10116Nh()
            com.introvd.template.app.notification.C4074c.m10125a(r0, r6, r1, r15)
        L_0x0391:
            return
        L_0x0392:
            r0 = move-exception
            r0.printStackTrace()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.app.push.C4110c.m10206a(android.content.Context, java.lang.String, int, java.lang.String, java.lang.String, java.lang.String):void");
    }

    /* renamed from: b */
    private void m10207b(Context context, String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        sb.append("showNotification strTitle=");
        sb.append(str2);
        sb.append(";strContent=");
        sb.append(str3);
        sb.append(";extraData=");
        sb.append(str);
        LogUtilsV2.m14230i(sb.toString());
        Intent intent = new Intent(context, SplashActivity.class);
        intent.setFlags(805306368);
        intent.setAction("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.putExtra("PushService", "PushService");
        intent.putExtra("event", str);
        PendingIntent activity = PendingIntent.getActivity(context, 0, intent, 134217728);
        int i = R.mipmap.ic_launcher;
        if (VERSION.SDK_INT >= 21) {
            i = R.drawable.push_icon_notice_logo;
        }
        Builder contentIntent = new Builder(context, "com.introvd.template.notification.default").setSmallIcon(i).setContentIntent(activity);
        if (TextUtils.isEmpty(str2)) {
            str2 = context.getResources().getString(R.string.xiaoying_str_com_app_name);
        }
        Builder style = contentIntent.setContentTitle(str2).setContentText(str3 == null ? "" : str3).setStyle(new BigTextStyle().bigText(str3 == null ? "" : str3));
        if (str3 == null) {
            str3 = "";
        }
        C4071a.m10118a(context, 1000, style.setTicker(str3).setAutoCancel(true).setDefaults(-1).setPriority(2).build());
    }

    /* renamed from: e */
    private int m10208e(JSONObject jSONObject) {
        int i;
        try {
            i = jSONObject.getInt(C5878a.TAG);
        } catch (Throwable th) {
            th.printStackTrace();
            i = 0;
        }
        if (i == 0) {
            try {
                return C2575a.parseInt(jSONObject.getString(C5878a.TAG));
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
        return i;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:38:0x010a, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:?, code lost:
        r0.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0145, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x014c, code lost:
        r1 = (java.lang.ref.WeakReference) com.introvd.template.common.MagicCode.getMagicParam(0, "XiaoYingActivityWeakRef", null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x015c, code lost:
        r2 = (com.introvd.template.router.community.ICommunityAPI) com.aiii.android.arouter.p091c.C1919a.m5529sc().mo10356i(com.introvd.template.router.community.ICommunityAPI.class);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0168, code lost:
        if (r2 != null) goto L_0x016a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x016a, code lost:
        r2.refreshFollowApplyStatisticalInfo((android.content.Context) r1.get());
        r2.refreshMessageStatisticalInfo((android.content.Context) r1.get());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x017c, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001d, code lost:
        if (r1.contains("event") == false) goto L_0x0022;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:21:0x0082, B:36:0x00d6] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0082 A[SYNTHETIC, Splitter:B:21:0x0082] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0087 A[Catch:{ JSONException -> 0x010a, all -> 0x0145 }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x008c A[Catch:{ JSONException -> 0x010a, all -> 0x0145 }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00c3 A[Catch:{ JSONException -> 0x010a, all -> 0x0145 }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0110 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:64:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo23790a(android.content.Context r17, int r18, java.lang.String r19, java.lang.String r20, java.lang.String r21, java.lang.String r22) {
        /*
            r16 = this;
            r8 = r16
            r2 = r17
            r9 = r18
            r7 = r22
            r10 = 3
            r11 = 4
            if (r9 == r10) goto L_0x004d
            if (r9 != r11) goto L_0x000f
            goto L_0x004d
        L_0x000f:
            boolean r0 = android.text.TextUtils.isEmpty(r21)
            if (r0 != 0) goto L_0x0020
            java.lang.String r0 = "event"
            r1 = r21
            boolean r0 = r1.contains(r0)
            if (r0 != 0) goto L_0x007a
            goto L_0x0022
        L_0x0020:
            r1 = r21
        L_0x0022:
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ Exception -> 0x0048 }
            r0.<init>()     // Catch:{ Exception -> 0x0048 }
            java.lang.String r3 = "a"
            r4 = 1002(0x3ea, float:1.404E-42)
            r0.put(r3, r4)     // Catch:{ Exception -> 0x0048 }
            java.lang.String r3 = "b"
            java.lang.String r4 = ""
            r0.put(r3, r4)     // Catch:{ Exception -> 0x0048 }
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ Exception -> 0x0048 }
            r3.<init>()     // Catch:{ Exception -> 0x0048 }
            java.lang.String r4 = "event"
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0048 }
            r3.put(r4, r0)     // Catch:{ Exception -> 0x0048 }
            java.lang.String r0 = r3.toString()     // Catch:{ Exception -> 0x0048 }
            goto L_0x0074
        L_0x0048:
            r0 = move-exception
            r0.printStackTrace()
            goto L_0x007a
        L_0x004d:
            r1 = r21
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ Exception -> 0x0076 }
            r0.<init>()     // Catch:{ Exception -> 0x0076 }
            java.lang.String r3 = "a"
            r4 = 1001(0x3e9, float:1.403E-42)
            r0.put(r3, r4)     // Catch:{ Exception -> 0x0076 }
            java.lang.String r3 = "b"
            java.lang.String r4 = ""
            r0.put(r3, r4)     // Catch:{ Exception -> 0x0076 }
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ Exception -> 0x0076 }
            r3.<init>()     // Catch:{ Exception -> 0x0076 }
            java.lang.String r4 = "event"
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0076 }
            r3.put(r4, r0)     // Catch:{ Exception -> 0x0076 }
            java.lang.String r0 = r3.toString()     // Catch:{ Exception -> 0x0076 }
        L_0x0074:
            r3 = r0
            goto L_0x007b
        L_0x0076:
            r0 = move-exception
            r0.printStackTrace()
        L_0x007a:
            r3 = r1
        L_0x007b:
            r12 = 0
            r13 = 0
            r15 = 2
            switch(r9) {
                case 0: goto L_0x00c3;
                case 1: goto L_0x00b4;
                case 2: goto L_0x0082;
                case 3: goto L_0x008c;
                case 4: goto L_0x0087;
                default: goto L_0x0082;
            }
        L_0x0082:
            r8.m10205a(r2, r3, r15, r7)     // Catch:{ all -> 0x0145 }
            goto L_0x010e
        L_0x0087:
            r8.m10205a(r2, r3, r11, r7)     // Catch:{ all -> 0x0145 }
            goto L_0x010e
        L_0x008c:
            java.lang.String r0 = "MIPUSH"
            boolean r0 = r7.equals(r0)     // Catch:{ all -> 0x0145 }
            if (r0 != 0) goto L_0x010e
            int r0 = com.introvd.template.R.string.xiaoying_str_community_notification_video_title     // Catch:{ Exception -> 0x00b2 }
            java.lang.String r5 = r2.getString(r0)     // Catch:{ Exception -> 0x00b2 }
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ Exception -> 0x00b2 }
            r6 = r20
            r0.<init>(r6)     // Catch:{ Exception -> 0x00b2 }
            java.lang.String r1 = "content"
            java.lang.String r6 = r0.getString(r1)     // Catch:{ Exception -> 0x00b2 }
            r4 = 3
            r1 = r16
            r2 = r17
            r7 = r22
            r1.m10206a(r2, r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x00b2 }
            goto L_0x010e
        L_0x00b2:
            goto L_0x010e
        L_0x00b4:
            r6 = r20
            r4 = 1
            r1 = r16
            r2 = r17
            r5 = r19
            r7 = r22
            r1.m10206a(r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0145 }
            goto L_0x010e
        L_0x00c3:
            java.lang.String r0 = "PUSH_RECEIVE_NOTIFICATION"
            com.introvd.template.common.LogUtilsV2.m14227d(r0)     // Catch:{ all -> 0x0145 }
            boolean r0 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x0145 }
            if (r0 != 0) goto L_0x010e
            java.lang.String r0 = "message_type"
            boolean r0 = r3.contains(r0)     // Catch:{ all -> 0x0145 }
            if (r0 == 0) goto L_0x010e
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ JSONException -> 0x010a }
            r0.<init>(r3)     // Catch:{ JSONException -> 0x010a }
            java.lang.String r1 = "unique_messageid"
            java.lang.String r0 = r0.optString(r1)     // Catch:{ JSONException -> 0x010a }
            java.util.HashMap r1 = new java.util.HashMap     // Catch:{ JSONException -> 0x010a }
            r1.<init>()     // Catch:{ JSONException -> 0x010a }
            java.lang.String r3 = "carrier"
            r1.put(r3, r7)     // Catch:{ JSONException -> 0x010a }
            java.lang.String r3 = "type"
            r1.put(r3, r0)     // Catch:{ JSONException -> 0x010a }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x010a }
            r0.<init>()     // Catch:{ JSONException -> 0x010a }
            java.lang.String r3 = "PUSH_RECEIVE_NOTIFICATION : "
            r0.append(r3)     // Catch:{ JSONException -> 0x010a }
            r0.append(r7)     // Catch:{ JSONException -> 0x010a }
            java.lang.String r0 = r0.toString()     // Catch:{ JSONException -> 0x010a }
            com.introvd.template.common.LogUtilsV2.m14227d(r0)     // Catch:{ JSONException -> 0x010a }
            java.lang.String r0 = "Push_Receive_New"
            com.introvd.template.common.UserBehaviorLog.onKVEvent(r2, r0, r1)     // Catch:{ JSONException -> 0x010a }
            goto L_0x010e
        L_0x010a:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ all -> 0x0145 }
        L_0x010e:
            if (r9 == r15) goto L_0x0144
            if (r9 == r10) goto L_0x0144
            if (r9 == r11) goto L_0x0144
            java.lang.String r0 = "XiaoYingActivityWeakRef"
            java.lang.Object r0 = com.introvd.template.common.MagicCode.getMagicParam(r13, r0, r12)
            java.lang.ref.WeakReference r0 = (java.lang.ref.WeakReference) r0
            if (r0 == 0) goto L_0x0144
            java.lang.Object r1 = r0.get()
            if (r1 == 0) goto L_0x0144
            com.aiii.android.arouter.c.a r1 = com.aiii.android.arouter.p091c.C1919a.m5529sc()
            java.lang.Class<com.introvd.template.router.community.ICommunityAPI> r2 = com.introvd.template.router.community.ICommunityAPI.class
            java.lang.Object r1 = r1.mo10356i(r2)
            com.introvd.template.router.community.ICommunityAPI r1 = (com.introvd.template.router.community.ICommunityAPI) r1
            if (r1 == 0) goto L_0x0144
            java.lang.Object r2 = r0.get()
            android.content.Context r2 = (android.content.Context) r2
            r1.refreshFollowApplyStatisticalInfo(r2)
            java.lang.Object r0 = r0.get()
            android.content.Context r0 = (android.content.Context) r0
            r1.refreshMessageStatisticalInfo(r0)
        L_0x0144:
            return
        L_0x0145:
            r0 = move-exception
            if (r9 == r15) goto L_0x017c
            if (r9 == r10) goto L_0x017c
            if (r9 == r11) goto L_0x017c
            java.lang.String r1 = "XiaoYingActivityWeakRef"
            java.lang.Object r1 = com.introvd.template.common.MagicCode.getMagicParam(r13, r1, r12)
            java.lang.ref.WeakReference r1 = (java.lang.ref.WeakReference) r1
            if (r1 == 0) goto L_0x017c
            java.lang.Object r2 = r1.get()
            if (r2 == 0) goto L_0x017c
            com.aiii.android.arouter.c.a r2 = com.aiii.android.arouter.p091c.C1919a.m5529sc()
            java.lang.Class<com.introvd.template.router.community.ICommunityAPI> r3 = com.introvd.template.router.community.ICommunityAPI.class
            java.lang.Object r2 = r2.mo10356i(r3)
            com.introvd.template.router.community.ICommunityAPI r2 = (com.introvd.template.router.community.ICommunityAPI) r2
            if (r2 == 0) goto L_0x017c
            java.lang.Object r3 = r1.get()
            android.content.Context r3 = (android.content.Context) r3
            r2.refreshFollowApplyStatisticalInfo(r3)
            java.lang.Object r1 = r1.get()
            android.content.Context r1 = (android.content.Context) r1
            r2.refreshMessageStatisticalInfo(r1)
        L_0x017c:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.app.push.C4110c.mo23790a(android.content.Context, int, java.lang.String, java.lang.String, java.lang.String, java.lang.String):void");
    }

    /* renamed from: a */
    public void mo23791a(Context context, String str, String str2, String str3, String str4) {
        if ("GROUP".equals(str4)) {
            UserBehaviorUtilsV5.recordPushArrive(context, str, str3);
        }
    }
}
