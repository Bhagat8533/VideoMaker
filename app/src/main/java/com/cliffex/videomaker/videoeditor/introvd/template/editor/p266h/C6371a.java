package com.introvd.template.editor.p266h;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.p021v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import com.introvd.template.common.AppPreferencesSetting;
import com.introvd.template.common.ToastUtils;
import com.introvd.template.editor.R;
import com.introvd.template.editor.service.ProjectScanService;
import com.introvd.template.p203b.C4586g;
import com.introvd.template.sdk.model.editor.ProjectItem;
import com.introvd.template.sdk.utils.p394b.C8522g;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.introvd.template.editor.h.a */
public class C6371a {
    private static void asE() {
        AppPreferencesSetting.getInstance().removeAppKey("pref_key_show_publish_page_after_restart");
    }

    /* renamed from: at */
    public static void m18320at(Activity activity) {
        String appSettingStr = AppPreferencesSetting.getInstance().getAppSettingStr("pref_key_show_publish_page_after_restart", null);
        if (!TextUtils.isEmpty(appSettingStr)) {
            try {
                String optString = new JSONObject(appSettingStr).optString("projectUrl");
                if (!TextUtils.isEmpty(optString)) {
                    m18321f(activity, optString);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            asE();
        }
    }

    /* renamed from: f */
    private static void m18321f(final Activity activity, final String str) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("prj_load_callback_action");
        LocalBroadcastManager.getInstance(activity.getApplicationContext()).registerReceiver(new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {
                LocalBroadcastManager.getInstance(context).unregisterReceiver(this);
                if (!"prj_load_callback_action".equals(intent.getAction())) {
                    return;
                }
                if (intent.getBooleanExtra("prj_load_cb_intent_data_flag", true)) {
                    ProjectItem oC = C8522g.aJA().mo34770oC(str);
                    if (oC != null) {
                        C6386d.m18364a(activity, (String) null, oC.mProjectDataItem.isMiniPrj());
                        return;
                    }
                    return;
                }
                C4586g.m11695Sl();
                ToastUtils.show(context, R.string.xiaoying_str_ve_project_load_fail, 0);
            }
        }, intentFilter);
        ProjectScanService.m19501bH(activity.getApplicationContext(), str);
    }
}
