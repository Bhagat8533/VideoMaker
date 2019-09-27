package com.introvd.template.p374q;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import com.introvd.template.common.LogUtils;
import com.introvd.template.datacenter.SocialConstDef;
import com.introvd.template.datacenter.SocialServiceDef;
import com.introvd.template.p309f.C7351e;
import com.xiaoying.p448a.C9561c;
import java.util.HashMap;

/* renamed from: com.introvd.template.q.i */
public class C8358i {
    /* renamed from: a */
    public static void m24107a(Context context, String str, Bundle bundle, boolean z) {
        Bundle bundle2 = bundle;
        String string = bundle2.getString(SocialConstDef.SNS_ACCESSTOKEN);
        String string2 = bundle2.getString("expiredtime");
        String string3 = bundle2.getString("uid");
        String string4 = bundle2.getString("name");
        String string5 = bundle2.getString("nickname");
        bundle2.getString("gender");
        String string6 = bundle2.getString("avatar");
        String string7 = bundle2.getString("updatetime");
        if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string3)) {
            int intValue = Integer.valueOf(str == null ? "0" : str).intValue();
            if (z) {
                if (TextUtils.isEmpty(string2)) {
                    string2 = "0";
                }
                if (TextUtils.isEmpty(string7)) {
                    string7 = "0";
                }
                C7351e.m21690a(context.getContentResolver(), intValue, string, Long.valueOf(string2).longValue(), string3, string4, string5, string6, 0, Long.valueOf(string7).longValue());
            }
            HashMap hashMap = new HashMap();
            StringBuilder sb = new StringBuilder();
            sb.append("snsID:");
            sb.append(intValue);
            String sb2 = sb.toString();
            StringBuilder sb3 = new StringBuilder();
            sb3.append(sb2);
            sb3.append("_bind");
            hashMap.put("type", sb3.toString());
            Context context2 = context;
            C9561c.aRh().onKVEvent(context, "DEV_EVENT_Setting_BindSNS", hashMap);
        }
    }

    /* renamed from: cs */
    public static void m24108cs(Context context, String str) {
        String str2;
        ContentResolver contentResolver = context.getContentResolver();
        Cursor h = C7351e.m21692h(contentResolver, str);
        if (h != null) {
            String str3 = null;
            if (h.getCount() != 0) {
                h.moveToFirst();
                str3 = h.getString(0);
                str2 = h.getString(1);
            } else {
                str2 = null;
            }
            h.close();
            if (str2 != null && str3 != null) {
                int intValue = Integer.valueOf(str).intValue();
                try {
                    int b = C7351e.m21691b(contentResolver, intValue);
                    if (b > 0) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("onUnAuthComplete  delete ");
                        sb.append(b);
                        sb.append(" row");
                        LogUtils.m14222e("UserSocialMgr", sb.toString());
                    }
                } catch (Exception e) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("onUnAuthComplete  Exception=");
                    sb2.append(e.getMessage());
                    LogUtils.m14222e("UserSocialMgr", sb2.toString());
                }
                HashMap hashMap = new HashMap();
                StringBuilder sb3 = new StringBuilder();
                sb3.append("snsID:");
                sb3.append(intValue);
                String sb4 = sb3.toString();
                StringBuilder sb5 = new StringBuilder();
                sb5.append(sb4);
                sb5.append("_unbind");
                hashMap.put("type", sb5.toString());
                C9561c.aRh().onKVEvent(context, "DEV_EVENT_Setting_BindSNS", hashMap);
            }
        }
    }

    @Deprecated
    /* renamed from: gV */
    public static void m24109gV(Context context) {
        LogUtils.m14221d("UserSocialMgr", "userLogin");
        Intent intent = new Intent();
        intent.setAction(SocialServiceDef.ACTION_SOCIAL_SERVICE_USER);
        intent.setPackage(context.getPackageName());
        intent.putExtra("social_method", SocialServiceDef.SOCIAL_USER_METHOD_LOGIN);
        intent.setPackage(context.getPackageName());
        C9561c.m27511k(context, intent);
    }

    /* renamed from: gW */
    public static void m24110gW(Context context) {
        Intent intent = new Intent();
        intent.setAction(SocialServiceDef.ACTION_SOCIAL_SERVICE_USER);
        intent.putExtra("social_method", SocialServiceDef.SOCIAL_USER_METHOD_LOGOUT);
        intent.setPackage(context.getPackageName());
        C9561c.m27511k(context, intent);
    }

    /* renamed from: gX */
    public static void m24111gX(Context context) {
        Intent intent = new Intent();
        intent.setAction(SocialServiceDef.ACTION_SOCIAL_SERVICE_USER);
        intent.putExtra("social_method", SocialServiceDef.SOCIAL_USER_METHOD_UNBIND);
        intent.setPackage(context.getPackageName());
        C9561c.m27511k(context, intent);
    }
}
