package com.introvd.template.app.login;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.text.TextUtils;
import com.aiii.android.arouter.facade.p094a.C1942a;
import com.aiii.android.arouter.p091c.C1919a;
import com.google.gson.Gson;
import com.introvd.template.VivaBaseApplication;
import com.introvd.template.apicore.C3624b;
import com.introvd.template.app.C4113q;
import com.introvd.template.app.community.usergrade.C3797h;
import com.introvd.template.app.manager.C4041a;
import com.introvd.template.app.push.C4103b;
import com.introvd.template.common.AppPreferencesSetting;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.common.UserBehaviorLog;
import com.introvd.template.community.ICommunityFuncRouter;
import com.introvd.template.crash.C5523b;
import com.introvd.template.datacenter.SocialConstDef;
import com.introvd.template.datacenter.SocialServiceDef;
import com.introvd.template.origin.p364a.C8113b;
import com.introvd.template.origin.route.C8145c;
import com.introvd.template.origin.route.C8145c.C8149b;
import com.introvd.template.p173a.C3570a;
import com.introvd.template.p317h.C7513a;
import com.introvd.template.p317h.C7514b;
import com.introvd.template.p374q.C8343b;
import com.introvd.template.p374q.C8344c;
import com.introvd.template.p374q.C8356h;
import com.introvd.template.p374q.C8358i;
import com.introvd.template.router.app.device.DeviceUserProxy;
import com.introvd.template.router.user.BaseUserLifeCycle;
import com.introvd.template.router.user.UserServiceProxy;
import com.introvd.template.router.user.model.LoginErrorResponse;
import com.introvd.template.router.user.model.LoginUserInfo;
import java.util.HashMap;
import p037b.p050b.p076j.C1820a;

@C1942a(mo10417rZ = "/app/user_lifecycle")
public class AppUserLifeCycleImpl extends BaseUserLifeCycle {
    private void closeDatabase(Context context, boolean z) {
        context.getContentResolver().delete(SocialConstDef.getTableUri(z ? SocialConstDef.TBL_NAME_INSIDE_DB_BACKUP : SocialConstDef.TBL_NAME_INSIDE_DB_CLOSE), null, null);
    }

    /* access modifiers changed from: private */
    public static void saveSNSData2DB(Context context, LoginUserInfo loginUserInfo) {
        if (loginUserInfo != null) {
            String str = loginUserInfo.snsInfo.snsUID;
            String str2 = loginUserInfo.snsInfo.snsAccessToken;
            long j = loginUserInfo.snsInfo.expiredtime;
            String str3 = loginUserInfo.snsInfo.name;
            String str4 = loginUserInfo.snsInfo.snsNickName;
            String str5 = loginUserInfo.snsInfo.avatar;
            long j2 = loginUserInfo.snsInfo.updateTime;
            int i = loginUserInfo.snsInfo.snsType;
            if (!str.equals(C7513a.m22228eo(context))) {
                C4113q.m10220h(i, str, str4);
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put(SocialConstDef.SNS_ACCESSTOKEN, str2);
            contentValues.put("expiredtime", Long.valueOf(j));
            contentValues.put("uid", str);
            contentValues.put("name", str3);
            contentValues.put("nickname", str4);
            contentValues.put("avatar", str5);
            contentValues.put("type", Integer.valueOf(i));
            contentValues.put("updatetime", Long.valueOf(j2));
            contentValues.put(SocialConstDef.SNS_BIND_FLAG, Integer.valueOf(0));
            ContentResolver contentResolver = context.getContentResolver();
            StringBuilder sb = new StringBuilder();
            sb.append("type= ");
            sb.append(i);
            if (contentResolver.update(SocialConstDef.getTableUri(SocialConstDef.TBL_NAME_SNS), contentValues, sb.toString(), null) == 0) {
                contentResolver.insert(SocialConstDef.getTableUri(SocialConstDef.TBL_NAME_SNS), contentValues);
            }
        }
    }

    public void onLoginSuccess(boolean z) {
        super.onLoginSuccess(z);
        final VivaBaseApplication FZ = VivaBaseApplication.m8749FZ();
        final LoginUserInfo userInfo = UserServiceProxy.getUserInfo();
        if (userInfo != null) {
            try {
                long duidLong = DeviceUserProxy.getDuidLong();
                String userId = UserServiceProxy.getUserId();
                if (duidLong > 0) {
                    UserBehaviorLog.updateAccount(userId, duidLong);
                    C4041a.m10039MV();
                    StringBuilder sb = new StringBuilder();
                    sb.append("updateAccount userId=");
                    sb.append(userId);
                    sb.append(",duidLong=");
                    sb.append(duidLong);
                    LogUtilsV2.m14227d(sb.toString());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            C1820a.aVi().mo10058o(new Runnable() {
                public void run() {
                    AppUserLifeCycleImpl.saveSNSData2DB(FZ, userInfo);
                    C4103b.setPushTag(VivaBaseApplication.m8749FZ(), true);
                }
            });
            String str = userInfo.zone;
            String str2 = userInfo.country;
            if (!TextUtils.isEmpty(str)) {
                ((ICommunityFuncRouter) C1919a.m5529sc().mo10356i(ICommunityFuncRouter.class)).onRouterClientConfigure(FZ, str, str2);
                if (str2 == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("reason", "user login");
                    UserBehaviorLog.onKVEvent(VivaBaseApplication.m8749FZ(), " Dev_Event_Country_Null_Event_result", hashMap);
                }
                ((ICommunityFuncRouter) C1919a.m5529sc().mo10356i(ICommunityFuncRouter.class)).setUserZoneInfo(FZ, str, str2);
                C8113b.m23502iN(false);
            }
            C3797h.m9288Ix().mo23278Iy();
        }
    }

    public void onLogoutSuccess() {
        super.onLogoutSuccess();
        VivaBaseApplication FZ = VivaBaseApplication.m8749FZ();
        LogUtilsV2.m14227d("jamin logoutCallback");
        C8343b.m24053gO(FZ);
        C8356h.m24101gO(FZ);
        C8358i.m24111gX(FZ);
        ContentResolver contentResolver = FZ.getContentResolver();
        String m = C7514b.m22232m(contentResolver, "-1");
        String str = SocialServiceDef.XIAOYING_CURRENT_ACCOUNT;
        if (m == null) {
            m = "";
        }
        C7513a.m22227a(contentResolver, str, m);
        C8145c.setUserZoneInfo(FZ, "", "");
        C8344c.m24054P(FZ, SocialServiceDef.UNION_KEY_FOLLOWED_VIDEO_NEW_FLAG, String.valueOf(0));
        AppPreferencesSetting.getInstance().setAppSettingBoolean("key_pref_refresh_creation_ui", true);
        C3624b.m8865GC().mo22943GE();
        C8113b.m23502iN(false);
        C3797h.m9288Ix().mo23277IC();
        C3797h.m9288Ix().mo23278Iy();
        closeDatabase(FZ, true);
        C4113q.m10217bE(FZ);
        C3570a.m8781x(7, true);
        C4103b.setPushTag(FZ, true);
        long duidLong = DeviceUserProxy.getDuidLong();
        if (duidLong > 0) {
            UserBehaviorLog.updateAccount("", duidLong);
        }
    }

    public void onTokenRefreshSuccess() {
        UserServiceProxy.refreshAccountInfo();
    }

    public void onUserZoneFailed(LoginErrorResponse loginErrorResponse) {
        String str;
        super.onUserZoneFailed(loginErrorResponse);
        if (loginErrorResponse.errorCode == -2017) {
            String duid = DeviceUserProxy.getDuid();
            StringBuilder sb = new StringBuilder();
            sb.append("catch no base url exception : duid : ");
            sb.append(duid);
            sb.append(", auid : ");
            sb.append(UserServiceProxy.getUserId());
            String sb2 = sb.toString();
            C8149b aFe = C8145c.aFd().aFe();
            if (aFe == null) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(sb2);
                sb3.append(", ZoneInfo is null ");
                str = sb3.toString();
            } else {
                StringBuilder sb4 = new StringBuilder();
                sb4.append(sb2);
                sb4.append(", ZoneInfo is : ");
                sb4.append(new Gson().toJson((Object) aFe));
                str = sb4.toString();
            }
            C5523b.logException(new Throwable(str));
        }
    }
}
