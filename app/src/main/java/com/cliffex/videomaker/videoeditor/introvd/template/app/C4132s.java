package com.introvd.template.app;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import com.introvd.template.common.UserBehaviorLog;
import com.introvd.template.p203b.C4582c;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import xcrash.C10109c;
import xcrash.C10116h;
import xcrash.C10116h.C10117a;

/* renamed from: com.introvd.template.app.s */
public class C4132s {
    /* access modifiers changed from: private */
    /* renamed from: HB */
    public static void m10267HB() {
        List Hh = C3740b.m9101He().mo23112Hh();
        for (int i = 0; i < Hh.size(); i++) {
            WeakReference weakReference = (WeakReference) Hh.get(i);
            if (weakReference != null) {
                Activity activity = (Activity) weakReference.get();
                if (activity != null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("activity=");
                    sb.append(activity.getClass().getSimpleName());
                    Log.d("XCrashProxy", sb.toString());
                    activity.finish();
                }
            }
        }
    }

    public static void init(Context context) {
        C10116h.m28660a(context, new C10117a().mo39085uf(C4582c.m11667dD(context)).bbf().bbg().mo39083kD(false).mo39089yb(10).mo39084u(new String[]{"^xcrash\\.sample$", "^Signal Catcher$", "^Jit thread pool$", ".*(R|r)ender.*", ".*Chrome.*"}).mo39090yc(10).mo39080a(new C10109c() {
            public void onCrash(String str, String str2) {
                StringBuilder sb = new StringBuilder();
                sb.append("onCrash logPath = ");
                sb.append(str);
                sb.append(",emergency=");
                sb.append(str2);
                Log.d("XCrashProxy", sb.toString());
                UserBehaviorLog.onAliEvent("dev_xCrash", new HashMap());
                C4132s.m10267HB();
            }
        }).mo39087xZ(3).mo39088ya(512).mo39086xY(1000));
    }
}
