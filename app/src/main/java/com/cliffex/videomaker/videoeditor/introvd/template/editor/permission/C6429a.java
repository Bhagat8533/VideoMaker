package com.introvd.template.editor.permission;

import android.content.Context;
import com.introvd.template.datacenter.SocialServiceDef;
import com.introvd.template.module.iap.C8072q;
import com.introvd.template.module.iap.business.p349a.C7825a;

/* renamed from: com.introvd.template.editor.permission.a */
public class C6429a {
    /* renamed from: a */
    public static boolean m18467a(Context context, AccessParam accessParam) {
        if (SocialServiceDef.USER_PRIVILEGE_TYPE_EXPORT_DURATION.equals(accessParam.cVW)) {
            return C8072q.aBx().mo33070i(C7825a.ALL.getId(), C7825a.PREMIUM_PACK.getId(), C7825a.DURATION_LIMIT.getId());
        } else if (!SocialServiceDef.USER_PRIVILEGE_TYPE_REMOVE_WATERMARK.equals(accessParam.cVW)) {
            return false;
        } else {
            return C8072q.aBx().mo33070i(C7825a.WATER_MARK.getId(), C7825a.ALL.getId(), C7825a.PREMIUM_PACK.getId());
        }
    }
}
