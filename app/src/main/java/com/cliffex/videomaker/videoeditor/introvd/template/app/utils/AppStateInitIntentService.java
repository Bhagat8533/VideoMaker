package com.introvd.template.app.utils;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.text.TextUtils;
import com.introvd.template.app.p177b.C3742b;
import com.introvd.template.common.AppPreferencesSetting;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.datacenter.SocialServiceDef;
import com.introvd.template.p173a.C3582b;
import com.introvd.template.p374q.C8346e;
import com.introvd.template.p374q.C8347f;
import com.introvd.template.p374q.C8350g.C8354a;
import com.p131c.p132a.p135c.C2575a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;

public class AppStateInitIntentService extends IntentService {
    public AppStateInitIntentService() {
        super("AppStateInitIntentService");
    }

    /* renamed from: I */
    private boolean m11064I(long j) {
        return System.currentTimeMillis() - j > 604800000;
    }

    /* renamed from: cY */
    public static void m11065cY(Context context) {
        Intent intent = new Intent(context, AppStateInitIntentService.class);
        intent.setAction("com.introvd.template.app.utils.action.reportAppInfoList");
        C3582b.m8808k(context, intent);
    }

    /* renamed from: da */
    private String m11066da(Context context) {
        ArrayList arrayList = new ArrayList();
        List installedPackages = context.getPackageManager().getInstalledPackages(0);
        for (int i = 0; i < installedPackages.size(); i++) {
            PackageInfo packageInfo = (PackageInfo) installedPackages.get(i);
            if ((packageInfo.applicationInfo.flags & 1) == 0) {
                HashMap hashMap = new HashMap();
                hashMap.put("n", packageInfo.applicationInfo.loadLabel(context.getPackageManager()).toString());
                hashMap.put("pn", packageInfo.packageName);
                hashMap.put("vn", packageInfo.versionName);
                hashMap.put("t", String.valueOf(packageInfo.applicationInfo.targetSdkVersion));
                hashMap.put("vc", String.valueOf(packageInfo.versionCode));
                hashMap.put("f", String.valueOf(packageInfo.applicationInfo.flags));
                arrayList.add(hashMap);
            }
        }
        return new JSONArray(arrayList).toString();
    }

    /* renamed from: cZ */
    public void mo24454cZ(Context context) {
        if (C3742b.m9111II().mo23185cd(context) && m11064I(C2575a.parseLong(AppPreferencesSetting.getInstance().getAppSettingStr("key_report_app_list_info_date", "0")))) {
            C8347f.aKf().mo33601a(SocialServiceDef.SOCIAL_MISC_METHOD_REPORT_APP_LIST_INFO, (C8354a) new C8354a() {
                /* renamed from: a */
                public void mo23009a(Context context, String str, int i, Bundle bundle) {
                    if (i == 131072) {
                        AppPreferencesSetting.getInstance().setAppSettingStr("key_report_app_list_info_date", String.valueOf(System.currentTimeMillis()));
                        LogUtilsV2.m14228e("report appInfo successful");
                    } else if (i == 65536) {
                        LogUtilsV2.m14228e("report appInfo fail");
                    }
                }
            });
            String da = m11066da(context);
            if (!TextUtils.isEmpty(da)) {
                LogUtilsV2.m14227d(da);
                C8346e.m24076cr(context, da);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onHandleIntent(Intent intent) {
        if (intent != null) {
            if ("com.introvd.template.app.utils.action.reportAppInfoList".equals(intent.getAction())) {
                mo24454cZ(getApplicationContext());
            }
        }
    }
}
