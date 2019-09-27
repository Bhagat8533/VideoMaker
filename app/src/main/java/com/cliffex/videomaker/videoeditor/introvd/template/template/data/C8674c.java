package com.introvd.template.template.data;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.introvd.template.VivaBaseApplication;
import com.introvd.template.common.AppPreferencesSetting;
import com.introvd.template.common.LogUtils;
import com.introvd.template.datacenter.BaseSocialNotify;
import com.introvd.template.datacenter.SocialServiceDef;
import com.introvd.template.p374q.C8346e;
import com.introvd.template.p374q.C8347f;
import com.introvd.template.p374q.C8350g.C8354a;
import com.introvd.template.sdk.p383c.C8399c;
import com.introvd.template.template.data.api.model.TemplateResponseInfo;
import com.introvd.template.template.data.api.model.TemplateResponseRoll;
import com.introvd.template.template.model.TemplatePackageInfo;
import com.introvd.template.template.p407e.C8739i;
import com.introvd.template.template.p407e.C8742k;
import com.introvd.template.template.p407e.C8743l;
import com.p131c.p132a.p135c.C2575a;
import java.util.List;
import p037b.p050b.C1850u;
import p037b.p050b.p054b.C1495b;
import p037b.p050b.p076j.C1820a;

/* renamed from: com.introvd.template.template.data.c */
public class C8674c {
    public static void aKn() {
        C1820a.aVi().mo10058o(new Runnable() {
            public void run() {
                C8674c.aKo();
            }
        });
    }

    /* access modifiers changed from: private */
    public static void aKo() {
        VivaBaseApplication FZ = VivaBaseApplication.m8749FZ();
        if (BaseSocialNotify.isNetworkAvaliable(FZ)) {
            C8739i.m25524ho(FZ);
            m25252f(C8399c.edb, FZ);
            m25252f(C8399c.ede, FZ);
            m25252f(C8399c.ecY, FZ);
            C8346e.m24071T(FZ, "", "camera_facedetectsticker");
            m25251e(C8399c.ecX, FZ);
            m25251e(C8399c.ecZ, FZ);
            m25251e(C8399c.edd, FZ);
            m25249c("cover_sticker", FZ);
            m25249c("cover_text", FZ);
        }
    }

    /* renamed from: c */
    public static void m25249c(String str, final Context context) {
        StringBuilder sb = new StringBuilder();
        sb.append("key_pref_pkg_bubble_refresh_last_time_");
        sb.append(str);
        final String sb2 = sb.toString();
        String appSettingStr = AppPreferencesSetting.getInstance().getAppSettingStr(sb2, "");
        if (TextUtils.isEmpty(appSettingStr) || Math.abs(System.currentTimeMillis() - C2575a.parseLong(appSettingStr)) > 43200000) {
            C8347f.aKf().mo33601a(SocialServiceDef.SOCIAL_MISC_METHOD_TEMPLATE_PACKAGES, (C8354a) new C8354a() {
                /* renamed from: a */
                public void mo23009a(Context context, String str, int i, Bundle bundle) {
                    C8347f.aKf().mo33603oT(SocialServiceDef.SOCIAL_MISC_METHOD_TEMPLATE_PACKAGES);
                    if (i == 131072) {
                        AppPreferencesSetting instance = AppPreferencesSetting.getInstance();
                        String str2 = sb2;
                        StringBuilder sb = new StringBuilder();
                        sb.append("");
                        sb.append(System.currentTimeMillis());
                        instance.setAppSettingStr(str2, sb.toString());
                        List<TemplatePackageInfo> cG = C8742k.aMi().mo35177cG(context, "cover_sticker");
                        if (cG != null && cG.size() > 0) {
                            for (TemplatePackageInfo templatePackageInfo : cG) {
                                if (templatePackageInfo != null && !TextUtils.isEmpty(templatePackageInfo.strGroupCode)) {
                                    C8674c.m25250d(templatePackageInfo.strGroupCode, context);
                                }
                            }
                        }
                    }
                }
            });
            C8346e.m24071T(context, "", str);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public static void m25250d(String str, Context context) {
        StringBuilder sb = new StringBuilder();
        sb.append("key_pref_pkg_bubble_refresh_last_time_");
        sb.append(str);
        final String sb2 = sb.toString();
        String appSettingStr = AppPreferencesSetting.getInstance().getAppSettingStr(sb2, "");
        if (TextUtils.isEmpty(appSettingStr) || Math.abs(System.currentTimeMillis() - C2575a.parseLong(appSettingStr)) > 43200000) {
            C8347f.aKf().mo33601a(SocialServiceDef.SOCIAL_MISC_METHOD_TEMPLATE_PACKAGE_DETAIL, (C8354a) new C8354a() {
                /* renamed from: a */
                public void mo23009a(Context context, String str, int i, Bundle bundle) {
                    C8347f.aKf().mo33603oT(SocialServiceDef.SOCIAL_MISC_METHOD_TEMPLATE_PACKAGE_DETAIL);
                    if (i == 131072) {
                        C8739i.m25524ho(context);
                        AppPreferencesSetting instance = AppPreferencesSetting.getInstance();
                        String str2 = sb2;
                        StringBuilder sb = new StringBuilder();
                        sb.append("");
                        sb.append(System.currentTimeMillis());
                        instance.setAppSettingStr(str2, sb.toString());
                    }
                }
            });
            C8346e.m24075cq(context, str);
        }
    }

    /* renamed from: e */
    public static void m25251e(String str, Context context) {
        List cH = C8743l.m25551cH(context, str);
        Long valueOf = Long.valueOf(System.currentTimeMillis());
        StringBuilder sb = new StringBuilder();
        sb.append("template_refresh_recommend_time_key_");
        sb.append(str);
        String sb2 = sb.toString();
        if (cH == null || cH.size() <= 0) {
            C8670b.m25245a(str, 100, 1, 3, 2, "").mo10196g(C1820a.aVi()).mo10194f(C1820a.aVi()).mo10188a((C1850u<? super T>) new C1850u<List<TemplateResponseInfo>>() {
                /* renamed from: a */
                public void mo9883a(C1495b bVar) {
                }

                public void onError(Throwable th) {
                }

                public void onSuccess(List<TemplateResponseInfo> list) {
                }
            });
            AppPreferencesSetting.getInstance().setAppSettingLong(sb2, valueOf.longValue());
            return;
        }
        if (valueOf.longValue() - Long.valueOf(AppPreferencesSetting.getInstance().getAppSettingLong(sb2, 0)).longValue() > 43200000) {
            C8670b.m25245a(str, 100, 1, 3, 2, "").mo10196g(C1820a.aVi()).mo10194f(C1820a.aVi()).mo10188a((C1850u<? super T>) new C1850u<List<TemplateResponseInfo>>() {
                /* renamed from: a */
                public void mo9883a(C1495b bVar) {
                }

                public void onError(Throwable th) {
                }

                public void onSuccess(List<TemplateResponseInfo> list) {
                }
            });
            AppPreferencesSetting.getInstance().setAppSettingLong(sb2, valueOf.longValue());
        }
    }

    /* renamed from: f */
    public static void m25252f(final String str, Context context) {
        List cI = C8743l.m25552cI(context, str);
        Long valueOf = Long.valueOf(System.currentTimeMillis());
        StringBuilder sb = new StringBuilder();
        sb.append("template_refresh_recommend_time_key_");
        sb.append(str);
        String sb2 = sb.toString();
        if (cI == null || cI.size() <= 0) {
            C8670b.m25247d(str, 100, 1, 2).mo10196g(C1820a.aVi()).mo10194f(C1820a.aVi()).mo10188a((C1850u<? super T>) new C1850u<List<TemplateResponseRoll>>() {
                /* renamed from: a */
                public void mo9883a(C1495b bVar) {
                }

                public void onError(Throwable th) {
                }

                public void onSuccess(List<TemplateResponseRoll> list) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("refreshRecommendRollData:tcid:");
                    sb.append(str);
                    LogUtils.m14223i("TemplateInit", sb.toString());
                }
            });
            AppPreferencesSetting.getInstance().setAppSettingLong(sb2, valueOf.longValue());
            return;
        }
        if (valueOf.longValue() - Long.valueOf(AppPreferencesSetting.getInstance().getAppSettingLong(sb2, 0)).longValue() > 43200000) {
            C8670b.m25247d(str, 100, 1, 2).mo10196g(C1820a.aVi()).mo10194f(C1820a.aVi()).mo10188a((C1850u<? super T>) new C1850u<List<TemplateResponseRoll>>() {
                /* renamed from: a */
                public void mo9883a(C1495b bVar) {
                }

                public void onError(Throwable th) {
                }

                public void onSuccess(List<TemplateResponseRoll> list) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("refreshRecommendRollData:tcid:");
                    sb.append(str);
                    LogUtils.m14223i("TemplateInit", sb.toString());
                }
            });
            AppPreferencesSetting.getInstance().setAppSettingLong(sb2, valueOf.longValue());
        }
    }
}
