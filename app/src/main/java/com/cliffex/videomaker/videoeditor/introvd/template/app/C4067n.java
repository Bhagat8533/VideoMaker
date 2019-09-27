package com.introvd.template.app;

import android.text.TextUtils;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.datacenter.IUserOp;
import com.introvd.template.datacenter.TempUserProxy;
import com.introvd.template.router.user.UserServiceProxy;
import com.introvd.template.router.user.model.LoginUserInfo;

/* renamed from: com.introvd.template.app.n */
public class C4067n {
    public static void init() {
        TempUserProxy.userOp = new IUserOp() {
            public void clearExpireTime() {
                LoginUserInfo userInfo = UserServiceProxy.getUserInfo();
                if (userInfo != null) {
                    userInfo.tokenExpireTime = 0;
                    UserServiceProxy.saveLoginUserInfo(userInfo);
                }
            }

            public void clearUserInfo() {
                UserServiceProxy.clearUserInfo();
            }

            public long getExpiredTime() {
                LoginUserInfo userInfo = UserServiceProxy.getUserInfo();
                if (userInfo == null) {
                    return 0;
                }
                return userInfo.tokenExpireTime;
            }

            public String getSNSId() {
                LoginUserInfo userInfo = UserServiceProxy.getUserInfo();
                if (userInfo == null) {
                    return null;
                }
                return userInfo.snsInfo.snsUID;
            }

            public String getSNSToken() {
                LoginUserInfo userInfo = UserServiceProxy.getUserInfo();
                if (userInfo == null) {
                    return null;
                }
                return userInfo.snsInfo.snsAccessToken;
            }

            public int getSNSType() {
                LoginUserInfo userInfo = UserServiceProxy.getUserInfo();
                if (userInfo == null) {
                    return 0;
                }
                return userInfo.snsInfo.snsType;
            }

            public String getUserId() {
                StringBuilder sb = new StringBuilder();
                sb.append("getUserId = ");
                sb.append(UserServiceProxy.getUserId());
                LogUtilsV2.m14227d(sb.toString());
                return UserServiceProxy.getUserId();
            }

            public String getUserToken() {
                LoginUserInfo userInfo = UserServiceProxy.getUserInfo();
                if (userInfo == null) {
                    return null;
                }
                return userInfo.token;
            }

            public void save(long j, String str, int i) {
                LoginUserInfo userInfo = UserServiceProxy.getUserInfo();
                if (userInfo != null) {
                    userInfo.tokenExpireTime = j;
                    userInfo.token = str;
                    userInfo.level = i;
                    UserServiceProxy.saveLoginUserInfo(userInfo);
                }
            }

            public void saveAvatar(String str) {
                LoginUserInfo userInfo = UserServiceProxy.getUserInfo();
                if (userInfo != null) {
                    userInfo.avatarUrl = str;
                    UserServiceProxy.saveLoginUserInfo(userInfo);
                }
            }

            public void saveBackground(String str) {
                LoginUserInfo userInfo = UserServiceProxy.getUserInfo();
                if (userInfo != null) {
                    userInfo.background = str;
                    UserServiceProxy.saveLoginUserInfo(userInfo);
                }
            }

            public void saveToken(String str, long j) {
                if (!TextUtils.isEmpty(str) && j > 0) {
                    LoginUserInfo userInfo = UserServiceProxy.getUserInfo();
                    userInfo.token = str;
                    userInfo.tokenExpireTime = j;
                    UserServiceProxy.saveLoginUserInfo(userInfo);
                }
            }
        };
    }
}
