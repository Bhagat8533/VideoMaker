package com.introvd.template.app.ads.encourage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.introvd.template.R;
import com.introvd.template.ads.AdParamMgr;
import com.introvd.template.common.ToastUtils;
import com.introvd.template.common.UserBehaviorLog;
import com.introvd.template.module.iap.business.p349a.C7825a;
import com.introvd.template.module.p326ad.C7588a;
import com.introvd.template.module.p326ad.C7590b;
import com.introvd.template.module.p326ad.p327a.C7589a;
import com.introvd.template.module.p326ad.p328b.C7596f;
import com.introvd.template.module.p326ad.p337i.C7675d;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.HashMap;
import java.util.Locale;
import org.greenrobot.eventbus.C10021c;

public class XYBAIBroadcastReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        if ("com.test.ad.ACTION_INSTALL".equals(intent.getAction())) {
            String aAL = C7675d.aAL();
            int kp = C7675d.m22506kp(aAL);
            String str = "unknown";
            if (2 == kp) {
                C7590b.m22369t(32, 3, 2);
                str = "移除广告";
            } else if (1 == kp) {
                Integer V = C7588a.m22357V(AdParamMgr.getExtraInfoByKey(36, "availabletime"));
                C7675d.m22502D(aAL, (V == null || V.intValue() == 0) ? 7 : V.intValue());
                str = C7825a.ALL_TEMPLATE.getId().equals(aAL) ? "素材中心顶部" : "付费主题";
            }
            if (kp != 0) {
                HashMap hashMap = new HashMap();
                hashMap.put("platform", "baidu");
                hashMap.put("language", Locale.getDefault().getLanguage());
                hashMap.put(IronSourceConstants.EVENTS_PLACEMENT_NAME, str);
                UserBehaviorLog.onKVEvent(context, "Ad_user_install_success", hashMap);
                ToastUtils.show(context, context.getString(R.string.xiaoying_str_reward_video_ad_to_congrats_get), 0);
                C10021c.aZH().mo38492aA(new C7596f());
            }
            C7589a.m22360aj(context.getApplicationContext(), 34);
            C7589a.m22360aj(context.getApplicationContext(), 37);
            C7589a.m22360aj(context.getApplicationContext(), 36);
            C7589a.m22360aj(context.getApplicationContext(), 42);
        }
    }
}
