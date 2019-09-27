package com.introvd.template.router.user;

import com.google.gson.JsonObject;
import com.introvd.template.router.BizServiceManager;
import com.introvd.template.router.user.model.LoginUserInfo;
import com.introvd.template.router.user.model.PrivilegeGoods;
import com.introvd.template.router.user.model.UserGradeInfoResult;
import com.introvd.template.router.user.model.UserGradeUpInfo;
import com.introvd.template.router.user.model.UserInfoResponse;
import java.util.List;
import p037b.p050b.C1834l;
import p037b.p050b.C1848s;

public class UserServiceProxy {
    public static C1834l<Boolean> checkUserBindPhone(boolean z) {
        IUserService iUserService = (IUserService) BizServiceManager.getService(IUserService.class);
        if (iUserService == null) {
            return null;
        }
        return iUserService.checkUserBindPhone(z);
    }

    public static void clearUserInfo() {
        IUserService iUserService = (IUserService) BizServiceManager.getService(IUserService.class);
        if (iUserService != null) {
            iUserService.clearUserInfo();
        }
    }

    public static C1848s<List<PrivilegeGoods>> getPrivilegeGoodsInfo(String str, String str2, String str3) {
        IUserService iUserService = (IUserService) BizServiceManager.getService(IUserService.class);
        if (iUserService == null) {
            return null;
        }
        return iUserService.getPrivilegeGoodsInfo(str, str2, str3);
    }

    public static C1848s<UserGradeInfoResult> getUserGradeInfo(String str, String str2) {
        IUserService iUserService = (IUserService) BizServiceManager.getService(IUserService.class);
        if (iUserService == null) {
            return null;
        }
        return iUserService.getUserGradeInfo(str, str2);
    }

    public static C1848s<List<UserGradeUpInfo>> getUserGradeUpInfo(String str, int i) {
        IUserService iUserService = (IUserService) BizServiceManager.getService(IUserService.class);
        if (iUserService == null) {
            return null;
        }
        return iUserService.getUserGradeUpInfo(str, i);
    }

    public static String getUserId() {
        IUserService iUserService = (IUserService) BizServiceManager.getService(IUserService.class);
        if (iUserService == null) {
            return null;
        }
        LoginUserInfo userInfo = iUserService.getUserInfo();
        if (userInfo == null) {
            return null;
        }
        return userInfo.auid;
    }

    public static LoginUserInfo getUserInfo() {
        IUserService iUserService = (IUserService) BizServiceManager.getService(IUserService.class);
        if (iUserService == null) {
            return null;
        }
        return iUserService.getUserInfo();
    }

    public static String getUserToken() {
        IUserService iUserService = (IUserService) BizServiceManager.getService(IUserService.class);
        if (iUserService == null) {
            return null;
        }
        LoginUserInfo userInfo = iUserService.getUserInfo();
        if (userInfo == null) {
            return null;
        }
        return userInfo.token;
    }

    public static boolean isLogin() {
        IUserService iUserService = (IUserService) BizServiceManager.getService(IUserService.class);
        if (iUserService == null) {
            return false;
        }
        return iUserService.isLogin();
    }

    public static void refreshAccountInfo() {
        IUserService iUserService = (IUserService) BizServiceManager.getService(IUserService.class);
        if (iUserService != null) {
            iUserService.refreshAccountInfo();
        }
    }

    public static void saveLoginUserInfo(LoginUserInfo loginUserInfo) {
        if (loginUserInfo != null) {
            IUserService iUserService = (IUserService) BizServiceManager.getService(IUserService.class);
            if (iUserService != null) {
                iUserService.saveUserInfo(loginUserInfo);
            }
        }
    }

    public static void saveLoginUserInfo(UserInfoResponse userInfoResponse) {
        if (userInfoResponse != null) {
            IUserService iUserService = (IUserService) BizServiceManager.getService(IUserService.class);
            if (iUserService != null) {
                iUserService.saveUserInfo(userInfoResponse);
            }
        }
    }

    public static C1848s<JsonObject> setPrivilegeAward(String str) {
        IUserService iUserService = (IUserService) BizServiceManager.getService(IUserService.class);
        if (iUserService == null) {
            return null;
        }
        return iUserService.setPrivilegeAward(str);
    }
}
