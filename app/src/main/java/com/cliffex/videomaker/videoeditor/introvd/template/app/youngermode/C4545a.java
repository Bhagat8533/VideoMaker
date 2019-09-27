package com.introvd.template.app.youngermode;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.text.TextUtils;
import com.afollestad.materialdialogs.C1885b;
import com.afollestad.materialdialogs.C1888e;
import com.afollestad.materialdialogs.C1890f;
import com.afollestad.materialdialogs.C1890f.C1895a;
import com.afollestad.materialdialogs.C1890f.C1904j;
import com.google.gson.JsonObject;
import com.introvd.template.R;
import com.introvd.template.app.youngermode.p201a.C4549b;
import com.introvd.template.router.AppRouter;
import com.p131c.p132a.p135c.C2575a;
import java.util.Calendar;
import p037b.p050b.C1850u;
import p037b.p050b.p054b.C1495b;
import p037b.p050b.p076j.C1820a;

/* renamed from: com.introvd.template.app.youngermode.a */
public class C4545a {
    /* renamed from: RF */
    public static boolean m11475RF() {
        int i = Calendar.getInstance().get(11);
        return i > 21 || i < 6;
    }

    /* renamed from: RG */
    public static void m11476RG() {
        C4549b.m11486RT().mo10196g(C1820a.aVi()).mo10194f(C1820a.aVi()).mo10188a((C1850u<? super T>) new C1850u<JsonObject>() {
            /* renamed from: a */
            public void mo9883a(C1495b bVar) {
            }

            /* renamed from: a */
            public void onSuccess(JsonObject jsonObject) {
                if (jsonObject != null && jsonObject.get("TeenagerModel") != null) {
                    String asString = jsonObject.get("TeenagerModel").getAsString();
                    if (!TextUtils.isEmpty(asString) && !"null".equals(asString)) {
                        int parseInt = C2575a.parseInt(asString);
                        C4560d RN = C4560d.m11516RN();
                        boolean z = true;
                        if (parseInt != 1) {
                            z = false;
                        }
                        RN.mo24811ca(z);
                    }
                }
            }

            public void onError(Throwable th) {
            }
        });
    }

    /* renamed from: V */
    public static void m11477V(Activity activity) {
        AppRouter.startYoungerModeSetting(activity, 1);
    }

    /* renamed from: dq */
    public static void m11478dq(Context context) {
        new C4557c(context, 2).show();
    }

    /* renamed from: dr */
    public static void m11479dr(Context context) {
        new C1895a(context).mo10306dy(context.getResources().getColor(R.color.white)).mo10312q("忘记密码").mo10295dn(R.color.black).mo10279a(C1888e.CENTER).mo10296do(R.string.viva_younger_forget_content).mo10298dq(R.color.color_8E8E93).mo10299dr(R.string.xiaoying_str_com_msg_got_it).mo10301dt(R.color.color_ff5e13).mo10281a((C1904j) new C1904j() {
            public void onClick(C1890f fVar, C1885b bVar) {
                fVar.dismiss();
            }
        }).mo10313qu().show();
    }

    /* renamed from: e */
    public static void m11480e(Activity activity, OnDismissListener onDismissListener) {
        C4557c cVar = new C4557c(activity, 1);
        cVar.setOnDismissListener(onDismissListener);
        cVar.show();
    }
}
