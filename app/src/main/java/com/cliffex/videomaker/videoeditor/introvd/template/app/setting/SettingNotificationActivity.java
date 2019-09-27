package com.introvd.template.app.setting;

import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.Bundle;
import android.text.TextUtils;
import com.aiii.android.arouter.p091c.C1919a;
import com.introvd.template.R;
import com.introvd.template.common.AppPreferencesSetting;
import com.introvd.template.common.LogUtils;
import com.introvd.template.common.UserBehaviorLog;
import com.introvd.template.p374q.C8344c;
import com.introvd.template.router.IMRouter;
import com.introvd.template.router.community.ICommunityAPI;
import com.introvd.template.router.user.UserServiceProxy;

public class SettingNotificationActivity extends SettingBaseActivity implements OnSharedPreferenceChangeListener {
    private static final String TAG = "SettingNotificationActivity";
    private String bDa = null;

    /* renamed from: dW */
    private void m10833dW(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("UserSetting_");
        sb.append(this.bDa);
        sb.append("_");
        sb.append(str);
        String sb2 = sb.toString();
        boolean appSettingBoolean = AppPreferencesSetting.getInstance().getAppSettingBoolean(m10835dY(str), true);
        String cl = C8344c.m24055cl(getApplicationContext(), sb2);
        String str2 = TAG;
        StringBuilder sb3 = new StringBuilder();
        sb3.append("syncSetting ");
        sb3.append(str);
        sb3.append(" serviceValue : ");
        sb3.append(cl);
        LogUtils.m14223i(str2, sb3.toString());
        String str3 = TAG;
        StringBuilder sb4 = new StringBuilder();
        sb4.append("syncSetting ");
        sb4.append(str);
        sb4.append(" preferValue : ");
        sb4.append(appSettingBoolean);
        LogUtils.m14223i(str3, sb4.toString());
        if (TextUtils.isEmpty(cl) || m10834dX(cl) != appSettingBoolean) {
            ICommunityAPI iCommunityAPI = (ICommunityAPI) C1919a.m5529sc().mo10356i(ICommunityAPI.class);
            if (iCommunityAPI != null) {
                iCommunityAPI.setUserSetting(str, appSettingBoolean ? "1" : "0");
            }
        }
    }

    /* renamed from: dX */
    private boolean m10834dX(String str) {
        return !TextUtils.equals(str, "0");
    }

    /* renamed from: dY */
    private String m10835dY(String str) {
        if (TextUtils.equals(str, "11")) {
            return "pref_notification_comment";
        }
        if (TextUtils.equals(str, "10")) {
            return "pref_notification_like";
        }
        if (TextUtils.equals(str, "12")) {
            return "pref_notification_follow";
        }
        return null;
    }

    /* renamed from: dZ */
    public static boolean m10836dZ(String str) {
        try {
            return AppPreferencesSetting.getInstance().getAppSettingBoolean(str, true);
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        mo24354bI(R.xml.settings_notification_pref, R.string.xiaoying_str_com_notification_setting);
        this.bDa = UserServiceProxy.getUserId();
        m10833dW("11");
        m10833dW("10");
        m10833dW("12");
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        getPreferenceScreen().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this);
        super.onPause();
        UserBehaviorLog.onPause(this);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        getPreferenceScreen().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
        super.onResume();
        UserBehaviorLog.onResume(this);
    }

    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        String str2 = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("onSharedPreferenceChanged: key=");
        sb.append(str);
        LogUtils.m14221d(str2, sb.toString());
        boolean dZ = m10836dZ(str);
        String str3 = TAG;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("receiveNotification : ");
        sb2.append(dZ);
        LogUtils.m14223i(str3, sb2.toString());
        if (TextUtils.equals(str, "pref_notification_comment")) {
            ICommunityAPI iCommunityAPI = (ICommunityAPI) C1919a.m5529sc().mo10356i(ICommunityAPI.class);
            if (iCommunityAPI != null) {
                iCommunityAPI.setUserSetting("11", dZ ? "1" : "0");
            }
        } else if (TextUtils.equals(str, "pref_notification_like")) {
            ICommunityAPI iCommunityAPI2 = (ICommunityAPI) C1919a.m5529sc().mo10356i(ICommunityAPI.class);
            if (iCommunityAPI2 != null) {
                iCommunityAPI2.setUserSetting("10", dZ ? "1" : "0");
            }
        } else if (TextUtils.equals(str, "pref_notification_follow")) {
            ICommunityAPI iCommunityAPI3 = (ICommunityAPI) C1919a.m5529sc().mo10356i(ICommunityAPI.class);
            if (iCommunityAPI3 != null) {
                iCommunityAPI3.setUserSetting("12", dZ ? "1" : "0");
            }
        } else if (TextUtils.equals(str, "pref_notification_im")) {
            IMRouter.enableReceiveNotification(dZ);
        }
    }
}
