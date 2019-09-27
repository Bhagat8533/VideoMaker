package com.introvd.template.router.user;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.p021v4.app.FragmentActivity;
import com.aiii.android.arouter.facade.template.C1949c;
import com.google.gson.JsonObject;
import com.introvd.template.router.user.model.LastLoginModel;
import com.introvd.template.router.user.model.LoginUserInfo;
import com.introvd.template.router.user.model.PrivilegeGoods;
import com.introvd.template.router.user.model.UserGradeInfoResult;
import com.introvd.template.router.user.model.UserGradeUpInfo;
import com.introvd.template.router.user.model.UserInfoResponse;
import java.util.List;
import p037b.p050b.C1834l;
import p037b.p050b.C1848s;

public interface IUserService extends C1949c {
    C1834l<Boolean> checkUserBindPhone(boolean z);

    void clearUserInfo();

    LastLoginModel getLastLoginUserModel();

    C1848s<List<PrivilegeGoods>> getPrivilegeGoodsInfo(String str, String str2, String str3);

    C1848s<UserGradeInfoResult> getUserGradeInfo(String str, String str2);

    C1848s<List<UserGradeUpInfo>> getUserGradeUpInfo(String str, int i);

    LoginUserInfo getUserInfo();

    void handleSnsLoginActivityResult(FragmentActivity fragmentActivity, int i, int i2, Intent intent);

    boolean isLogin();

    boolean isSnsSDKAndApkInstalled(Context context, int i);

    void logout(Context context, long j);

    boolean needMove2VerifyPage(Activity activity, int i, boolean z);

    void refreshAccountInfo();

    void registerSnsLoginListener(FragmentActivity fragmentActivity);

    void saveLoginState(LastLoginModel lastLoginModel);

    void saveUserInfo(LoginUserInfo loginUserInfo);

    void saveUserInfo(UserInfoResponse userInfoResponse);

    C1848s<JsonObject> setPrivilegeAward(String str);

    boolean startSnsLogin(FragmentActivity fragmentActivity, long j, long j2, int i, boolean z, String str, String str2);

    @Deprecated
    void updateUserSnsInfo(int i, String str, String str2, IUserInfoModifyListener iUserInfoModifyListener);
}
