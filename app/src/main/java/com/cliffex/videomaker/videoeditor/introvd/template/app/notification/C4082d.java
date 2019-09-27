package com.introvd.template.app.notification;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.introvd.template.XiaoYingActivity;
import com.introvd.template.app.C3740b;
import com.introvd.template.app.C4027k;
import com.introvd.template.app.splash.SplashActivity;
import com.introvd.template.common.ActivityStateCheckListener;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.common.MagicCode;
import com.introvd.template.common.behavior.UserBehaviorUtilsV5;
import com.introvd.template.router.todoCode.TODOParamModel;
import com.quvideo.mobile.component.push.C4780a;
import java.lang.ref.WeakReference;
import java.util.List;

/* renamed from: com.introvd.template.app.notification.d */
public class C4082d {
    /* renamed from: h */
    public static void m10137h(Context context, Intent intent) {
        String stringExtra = intent.getStringExtra("pushType");
        String stringExtra2 = intent.getStringExtra("pushMessageId");
        String stringExtra3 = intent.getStringExtra("pushName");
        String stringExtra4 = intent.getStringExtra("pushMsgID");
        String stringExtra5 = intent.getStringExtra("event");
        if ("GROUP".equals(stringExtra)) {
            UserBehaviorUtilsV5.recordPushClicked(context, stringExtra2, stringExtra3);
            UserBehaviorUtilsV5.recordPushOperationEvent("click", stringExtra2);
            if ("JPUSH".equals(stringExtra3) && !TextUtils.isEmpty(stringExtra4)) {
                C4780a.m12324E(context, stringExtra4);
            }
        } else {
            TODOParamModel dj = C4027k.m9995dj(stringExtra5);
            StringBuilder sb = new StringBuilder();
            sb.append(dj.mTODOCode);
            sb.append("");
            UserBehaviorUtilsV5.recordPushClicked(context, sb.toString(), stringExtra3);
            C4074c.m10121J(context, dj.mTODOCode);
        }
        Object magicParam = MagicCode.getMagicParam(0, "XiaoYingActivityWeakRef", null);
        if (magicParam != null) {
            try {
                if (C3740b.m9101He().mo23113Hi()) {
                    context.startActivity(context.getPackageManager().getLaunchIntentForPackage(context.getPackageName()));
                }
                Activity activity = (Activity) ((WeakReference) magicParam).get();
                if (activity != null) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("execute notification : ");
                    sb2.append(activity);
                    LogUtilsV2.m14230i(sb2.toString());
                    WeakReference Hf = C3740b.m9101He().mo23111Hf();
                    if (Hf != null) {
                        Activity activity2 = (Activity) Hf.get();
                        if (activity2 != null && ((!(activity2 instanceof ActivityStateCheckListener) || ((ActivityStateCheckListener) activity2).isResponseTodoProcess()) && !activity2.getClass().getName().contains("com.vivavideo.mobile.liveplayer"))) {
                            m10139r(intent);
                        }
                    }
                } else {
                    m10138i(context, intent);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        } else {
            m10138i(context, intent);
        }
    }

    /* renamed from: i */
    private static void m10138i(Context context, Intent intent) {
        Intent intent2 = new Intent(context, SplashActivity.class);
        intent2.setFlags(805306368);
        intent2.setAction("android.intent.action.MAIN");
        intent2.addCategory("android.intent.category.LAUNCHER");
        intent2.putExtra("event", intent.getStringExtra("event"));
        intent2.putExtra("PushService", intent.getStringExtra("PushService"));
        intent2.putExtra("pushMessageId", intent.getStringExtra("pushMessageId"));
        context.startActivity(intent2);
    }

    /* renamed from: r */
    private static void m10139r(Intent intent) {
        List Hh = C3740b.m9101He().mo23112Hh();
        Activity activity = null;
        for (int i = 0; i < Hh.size(); i++) {
            WeakReference weakReference = (WeakReference) Hh.get(i);
            if (weakReference != null) {
                Activity activity2 = (Activity) weakReference.get();
                if (activity2 != null) {
                    if (activity2 instanceof XiaoYingActivity) {
                        activity = activity2;
                    } else {
                        activity2.finish();
                    }
                }
            }
        }
        if (activity != null) {
            String stringExtra = intent.getStringExtra("event");
            String stringExtra2 = intent.getStringExtra("pushMessageId");
            Bundle extras = intent.getExtras();
            if (extras == null) {
                extras = new Bundle();
            }
            extras.putString("pushMessageId", stringExtra2);
            C4027k.m9994a(activity, extras, C4027k.m9995dj(stringExtra));
        }
    }
}
