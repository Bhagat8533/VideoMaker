package com.introvd.template.app.community.usergrade;

import android.content.Context;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.introvd.template.common.AppPreferencesSetting;
import com.introvd.template.p203b.C4580b;
import com.introvd.template.router.user.UserServiceProxy;
import com.introvd.template.router.user.model.UserGradeUpInfo;
import java.util.ArrayList;
import java.util.List;
import p037b.p050b.C1848s;
import p037b.p050b.C1850u;
import p037b.p050b.p054b.C1495b;
import p037b.p050b.p076j.C1820a;

/* renamed from: com.introvd.template.app.community.usergrade.j */
class C3801j {
    /* renamed from: g */
    static void m9302g(Context context, final String str, final int i) {
        if (!TextUtils.isEmpty(str)) {
            C1848s userGradeUpInfo = UserServiceProxy.getUserGradeUpInfo(C4580b.m11635Si(), i);
            if (userGradeUpInfo != null) {
                userGradeUpInfo.mo10196g(C1820a.aVi()).mo10194f(C1820a.aVi()).mo10188a((C1850u<? super T>) new C1850u<List<UserGradeUpInfo>>() {
                    /* renamed from: a */
                    public void mo9883a(C1495b bVar) {
                    }

                    public void onError(Throwable th) {
                        th.printStackTrace();
                    }

                    public void onSuccess(List<UserGradeUpInfo> list) {
                        AppPreferencesSetting instance = AppPreferencesSetting.getInstance();
                        StringBuilder sb = new StringBuilder();
                        sb.append("pref_key_user_gradeup_info_");
                        sb.append(str);
                        sb.append(i);
                        instance.setAppSettingStr(sb.toString(), new Gson().toJson((Object) list));
                    }
                });
            }
        }
    }

    /* renamed from: h */
    static void m9303h(Context context, String str, int i) {
        AppPreferencesSetting.getInstance().setAppSettingBoolean("pref_key_need_show_gradeup_view", true);
        m9302g(context, str, i);
        m9305p(str, i);
    }

    /* renamed from: o */
    static List<C3791d> m9304o(String str, int i) {
        AppPreferencesSetting instance = AppPreferencesSetting.getInstance();
        StringBuilder sb = new StringBuilder();
        sb.append("pref_key_user_gradeup_info_");
        sb.append(str);
        sb.append(i);
        String appSettingStr = instance.getAppSettingStr(sb.toString(), null);
        if (TextUtils.isEmpty(appSettingStr)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        List list = (List) new Gson().fromJson(appSettingStr, new TypeToken<List<UserGradeUpInfo>>() {
        }.getType());
        for (int i2 = 0; i2 < list.size(); i2++) {
            UserGradeUpInfo userGradeUpInfo = (UserGradeUpInfo) list.get(i2);
            C3791d dVar = new C3791d();
            dVar.type = userGradeUpInfo.gift;
            dVar.content = userGradeUpInfo.content;
            dVar.iconUrl = userGradeUpInfo.iconUrl;
            dVar.bkN = userGradeUpInfo.rewardNumber;
            dVar.title = userGradeUpInfo.title;
            arrayList.add(dVar);
        }
        return arrayList;
    }

    /* renamed from: p */
    private static void m9305p(String str, int i) {
        AppPreferencesSetting instance = AppPreferencesSetting.getInstance();
        StringBuilder sb = new StringBuilder();
        sb.append("pref_key_user_saved_grade_");
        sb.append(str);
        instance.setAppSettingInt(sb.toString(), i);
    }

    /* renamed from: q */
    static boolean m9306q(String str, int i) {
        AppPreferencesSetting instance = AppPreferencesSetting.getInstance();
        StringBuilder sb = new StringBuilder();
        sb.append("pref_key_user_saved_grade_");
        sb.append(str);
        int appSettingInt = instance.getAppSettingInt(sb.toString(), 0);
        return appSettingInt >= 0 && appSettingInt < i;
    }
}
