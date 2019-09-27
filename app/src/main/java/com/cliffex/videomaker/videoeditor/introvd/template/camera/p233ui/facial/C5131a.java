package com.introvd.template.camera.p233ui.facial;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.introvd.template.common.AppPreferencesSetting;
import com.introvd.template.datacenter.SocialServiceDef;
import com.introvd.template.p374q.C8346e;
import com.introvd.template.p374q.C8347f;
import com.introvd.template.p374q.C8350g.C8354a;
import com.introvd.template.template.p407e.C8739i;
import com.p131c.p132a.p135c.C2575a;

/* renamed from: com.introvd.template.camera.ui.facial.a */
public class C5131a {
    private static C5131a bUY;

    private C5131a() {
    }

    /* renamed from: Xx */
    public static C5131a m13872Xx() {
        if (bUY == null) {
            bUY = new C5131a();
        }
        return bUY;
    }

    /* renamed from: ag */
    public void mo26029ag(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            C8347f.aKf().mo33601a(SocialServiceDef.SOCIAL_MISC_METHOD_TEMPLATE_PACKAGE_DETAIL, (C8354a) new C8354a() {
                /* renamed from: a */
                public void mo23009a(Context context, String str, int i, Bundle bundle) {
                    C8347f.aKf().mo33603oT(SocialServiceDef.SOCIAL_MISC_METHOD_TEMPLATE_PACKAGE_DETAIL);
                    if (i == 131072) {
                        C8739i.m25524ho(context);
                    }
                }
            });
            C8346e.m24075cq(context, str);
        }
    }

    /* renamed from: dP */
    public void mo26030dP(Context context) {
        String appSettingStr = AppPreferencesSetting.getInstance().getAppSettingStr("key_paster_facial_refresh_last_time", "");
        if (TextUtils.isEmpty(appSettingStr) || Math.abs(System.currentTimeMillis() - C2575a.parseLong(appSettingStr)) > 3600000) {
            C8347f.aKf().mo33601a(SocialServiceDef.SOCIAL_MISC_METHOD_TEMPLATE_PACKAGES, (C8354a) new C8354a() {
                /* renamed from: a */
                public void mo23009a(Context context, String str, int i, Bundle bundle) {
                    C8347f.aKf().mo33603oT(SocialServiceDef.SOCIAL_MISC_METHOD_TEMPLATE_PACKAGES);
                    if (i == 131072) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("");
                        sb.append(System.currentTimeMillis());
                        AppPreferencesSetting.getInstance().setAppSettingStr("key_paster_facial_refresh_last_time", sb.toString());
                    }
                }
            });
            C8346e.m24071T(context, "", "camera_facedetectsticker");
        }
    }
}
