package com.introvd.template.app.p189i;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

/* renamed from: com.introvd.template.app.i.e */
public class C4021e {
    /* renamed from: a */
    public static boolean m9972a(Activity activity, Bundle bundle) {
        Context applicationContext = activity.getApplicationContext();
        boolean z = false;
        if (bundle == null) {
            return false;
        }
        boolean equals = "from=weixin_papay".equals(bundle.getString("_wxappextendobject_extInfo"));
        if (equals) {
            Intent addFlags = new Intent("android.intent.action.VIEW", Uri.parse("xiaoyingvip://")).addFlags(268435456);
            if (applicationContext.getPackageManager().resolveActivity(addFlags, 65536) != null) {
                z = true;
            }
            if (z) {
                activity.finish();
                applicationContext.startActivity(addFlags);
            }
            equals = z;
        }
        return equals;
    }
}
