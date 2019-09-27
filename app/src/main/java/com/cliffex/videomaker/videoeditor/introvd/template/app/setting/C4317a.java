package com.introvd.template.app.setting;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.afollestad.materialdialogs.C1885b;
import com.afollestad.materialdialogs.C1890f;
import com.afollestad.materialdialogs.C1890f.C1895a;
import com.afollestad.materialdialogs.C1890f.C1904j;
import com.introvd.template.R;
import com.introvd.template.app.p177b.C3742b;
import com.introvd.template.app.p190j.C4023a;
import com.introvd.template.app.utils.C4395c;
import com.introvd.template.common.AppPreferencesSetting;
import com.introvd.template.common.LogUtils;
import com.introvd.template.common.ToastUtils;
import com.introvd.template.common.UserBehaviorLog;
import com.introvd.template.common.model.AppStateModel;
import com.introvd.template.common.p236ui.custom.RatingBarDialog;
import com.introvd.template.common.p236ui.custom.RatingBarDialog.OnAlertDialogClickListener;
import com.introvd.template.crash.C5523b;
import java.util.HashMap;

/* renamed from: com.introvd.template.app.setting.a */
public class C4317a {
    /* renamed from: a */
    public static boolean m10838a(Activity activity, OnDismissListener onDismissListener) {
        String str;
        if (activity == null || activity.isFinishing() || !C3742b.m9111II().mo23116IJ()) {
            return false;
        }
        AppPreferencesSetting.getInstance().setAppSettingInt("key_show_rate_dialog_flag", 103);
        if (AppStateModel.getInstance().isInIndia() || C4023a.m9973MK().mo23674MM()) {
            m10839b(activity, onDismissListener);
            str = "fivestartstyle";
        } else {
            m10841c(activity, onDismissListener);
            str = "oldstyle";
        }
        HashMap hashMap = new HashMap();
        hashMap.put("country", AppStateModel.getInstance().getCountryCode());
        hashMap.put("style", str);
        UserBehaviorLog.onKVEvent(activity, "Home_Rate_Us_Show", hashMap);
        return true;
    }

    /* renamed from: b */
    public static void m10839b(final Activity activity, OnDismissListener onDismissListener) {
        RatingBarDialog ratingBarDialog = new RatingBarDialog(activity, new OnAlertDialogClickListener() {
            public void buttonClick(int i, float f) {
                if (i == 1) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("rating--");
                    sb.append(f);
                    LogUtils.m14221d("ruomiz", sb.toString());
                    HashMap hashMap = new HashMap();
                    hashMap.put("star", String.valueOf(f));
                    UserBehaviorLog.onKVEvent(activity, "GP_Comment_Popup_Click", hashMap);
                    if (f <= 4.0f) {
                        C4395c.m11083S(activity);
                        return;
                    }
                    Intent intent = new Intent("android.intent.action.VIEW");
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("market://details?id=");
                    sb2.append(activity.getApplicationContext().getPackageName());
                    intent.setData(Uri.parse(sb2.toString()));
                    intent.addFlags(268435456);
                    try {
                        activity.startActivity(intent);
                    } catch (Exception e) {
                        e.printStackTrace();
                        ToastUtils.show(activity.getApplicationContext(), R.string.xiaoying_str_studio_msg_app_not_found, 0);
                    }
                }
            }
        });
        if (!TextUtils.isEmpty(C4023a.m9973MK().mo23675MN())) {
            ratingBarDialog.setDialogTitle(C4023a.m9973MK().mo23675MN());
        }
        if (!TextUtils.isEmpty(C4023a.m9973MK().mo23676MO())) {
            ratingBarDialog.setDialogContent(C4023a.m9973MK().mo23676MO());
        }
        ratingBarDialog.setOnDismissListener(onDismissListener);
        ratingBarDialog.setCanceledOnTouchOutside(false);
        ratingBarDialog.setCancelable(false);
        ratingBarDialog.show();
        UserBehaviorLog.onKVEvent(activity, "GP_Comment_Popup_Show", new HashMap());
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m10840b(Activity activity, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("choice", str);
        UserBehaviorLog.onKVEvent(activity, "Home_Rate_Us", hashMap);
    }

    /* renamed from: c */
    private static void m10841c(final Activity activity, OnDismissListener onDismissListener) {
        try {
            new C1895a(activity).mo10293dl(R.string.xiaoying_str_studio_rate_dialog_title).mo10296do(R.string.xiaoying_str_com_feedback_content).mo10303dv(R.string.xiaoying_str_com_feedback_opinion_high).mo10299dr(R.string.xiaoying_str_com_feedback_opinion_problem).mo10302du(activity.getResources().getColor(R.color.color_ff8e00)).mo10300ds(activity.getResources().getColor(R.color.color_585858)).mo10288aA(false).mo10276a(onDismissListener).mo10291b(new C1904j() {
                public void onClick(C1890f fVar, C1885b bVar) {
                    Intent intent = new Intent("android.intent.action.VIEW");
                    StringBuilder sb = new StringBuilder();
                    sb.append("market://details?id=");
                    sb.append(activity.getPackageName());
                    intent.setData(Uri.parse(sb.toString()));
                    try {
                        activity.startActivity(intent);
                    } catch (Exception unused) {
                        ToastUtils.show((Context) activity, R.string.xiaoying_str_studio_msg_app_not_found, 0);
                    }
                    C4317a.m10840b(activity, "rate");
                }
            }).mo10281a((C1904j) new C1904j() {
                public void onClick(C1890f fVar, C1885b bVar) {
                    C4317a.m10840b(activity, "feedback");
                    C4395c.m11088a(activity, -1);
                }
            }).mo10275a((OnCancelListener) new OnCancelListener() {
                public void onCancel(DialogInterface dialogInterface) {
                    C4317a.m10840b(activity, "cancel");
                }
            }).mo10313qu().show();
        } catch (Exception e) {
            C5523b.logException(e);
        }
    }

    public static void showRateDialog(Activity activity) {
        m10838a(activity, null);
    }

    public static void showRatingBarDialog(Activity activity) {
        m10839b(activity, (OnDismissListener) null);
    }
}
