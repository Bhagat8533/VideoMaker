package com.introvd.template.router.community;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.aiii.android.arouter.facade.template.C1949c;
import com.introvd.template.router.user.model.UserInfoResponse;
import java.util.List;
import p037b.p050b.C1848s;

public interface ICommunityAPI extends C1949c {
    public static final String URL = "/VivaCommunity/ICommunityAPI";

    public interface OnStatusUpdateCallback {
        void onSuccess(List<WhatsAppStatus> list);
    }

    View checkNeedMissionPopupView(ViewGroup viewGroup);

    void checkNewFollowVideo();

    void clearMyVideoListCache();

    void enableHideLocation(boolean z);

    C1848s<String> getActivityJoinInfo(String str);

    boolean getChinaPhoneLogin();

    String getHotVideoData(Context context);

    boolean getShowPurseEntrance();

    int getTaskVideoPlayCount();

    int getTaskVideoShareCount();

    int getTotalUnreadMessageCount();

    C1848s<UserInfoResponse> getUserInfo(String str);

    void getWhatsAppVideoList(Context context, OnStatusUpdateCallback onStatusUpdateCallback);

    boolean isHideLocation();

    boolean isSvip(String str);

    void onTabMessageTipsApply();

    void refreshFollowApplyStatisticalInfo(Context context);

    void refreshMessageStatisticalInfo(Context context);

    void replaceWhatsAppDataCache(Context context, List<WhatsAppStatus> list);

    void requestVideoPlay(String str, String str2, int i, long j, int i2, String str3);

    void saveUserBusinessInfo(String str, String str2);

    void saveUserSvipInfo(String str, int i);

    void saveUserVideoCreatorInfo(String str, String str2);

    void setUserSetting(String str, String str2);

    void setVideoHotHintEnabled();
}
