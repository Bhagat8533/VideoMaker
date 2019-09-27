package com.introvd.template.app.splash;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.google.gson.reflect.TypeToken;
import com.introvd.template.VivaBaseApplication;
import com.introvd.template.app.api.C3727b;
import com.introvd.template.app.api.model.AppPopupInfoResult;
import com.introvd.template.app.api.model.SplashRequestResult;
import com.introvd.template.app.manager.C4059d;
import com.introvd.template.app.manager.C4059d.C4064b;
import com.introvd.template.app.model.SplashItemInfo;
import com.introvd.template.common.AppPreferencesSetting;
import com.introvd.template.common.CommonConfigure;
import com.introvd.template.common.LogUtils;
import com.introvd.template.common.filecache.FileCacheV2;
import com.introvd.template.common.filecache.FileCacheV2.Builder;
import com.introvd.template.common.model.AppStateModel;
import com.introvd.template.datacenter.SocialConstDef;
import com.introvd.template.p203b.C4580b;
import com.introvd.template.p203b.C4584e;
import com.introvd.template.p203b.C4600l;
import com.introvd.template.router.user.UserServiceProxy;
import com.p131c.p132a.C2570b;
import com.p131c.p132a.p135c.C2575a;
import com.vivavideo.mobile.component.sharedpref.C9324b;
import com.vivavideo.mobile.component.sharedpref.C9327e;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import p037b.p050b.C1834l;
import p037b.p050b.C1848s;
import p037b.p050b.C1850u;
import p037b.p050b.p054b.C1495b;
import p037b.p050b.p057e.C1518f;
import p037b.p050b.p073g.C1810c;
import p037b.p050b.p076j.C1820a;

/* renamed from: com.introvd.template.app.splash.c */
public class C4361c {
    private static C9324b bEy = C9327e.m27035cS(VivaBaseApplication.m8749FZ(), "splash_single_info");
    @SuppressLint({"StaticFieldLeak"})
    private static FileCacheV2<List<SplashRequestResult>> bEz;

    /* renamed from: Qj */
    public static String m10953Qj() {
        StringBuilder sb = new StringBuilder();
        sb.append(CommonConfigure.APP_DATA_PATH);
        String str = "/lsspsha";
        sb.append(".splash/");
        return sb.toString();
    }

    /* renamed from: Qk */
    private static boolean m10954Qk() {
        String str = "ty_mmrafee_upek_ptid";
        return m10980ef(AppPreferencesSetting.getInstance().getAppSettingStr("pref_update_time_key", "")).booleanValue();
    }

    /* renamed from: Ql */
    private static boolean m10955Ql() {
        String str = "kpefotsiyaer_l_d_mey_resah";
        return m10980ef(AppPreferencesSetting.getInstance().getAppSettingStr("pref_splash_ready_time_key", "")).booleanValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: Qm */
    public static String m10956Qm() {
        return new SimpleDateFormat(SplashItemInfo.TIME_FORMAT, Locale.US).format(new Date());
    }

    /* renamed from: Qn */
    public static boolean m10957Qn() {
        List ag = m10965ag((List) m10963Qt().getCacheSync());
        return ag != null && !ag.isEmpty();
    }

    /* renamed from: Qo */
    private static int m10958Qo() {
        if (m10960Qq() != Calendar.getInstance().get(6)) {
            return -1;
        }
        return m10959Qp();
    }

    /* renamed from: Qp */
    private static int m10959Qp() {
        return m10961Qr() & 1048575;
    }

    /* renamed from: Qq */
    private static int m10960Qq() {
        return (m10961Qr() & 535822336) >> 20;
    }

    /* renamed from: Qr */
    private static int m10961Qr() {
        String str = "_ianabdspltos_li_hgstaraa";
        return bEy.getInt("last_splash_original_data", 0);
    }

    /* renamed from: Qs */
    private static C1834l<List<SplashRequestResult>> m10962Qs() {
        return m10963Qt().getCache();
    }

    /* renamed from: Qt */
    private static FileCacheV2<List<SplashRequestResult>> m10963Qt() {
        if (bEz == null) {
            String str = "_hfcnlboes_schaai";
            bEz = new Builder(VivaBaseApplication.m8749FZ().getApplicationContext(), "splash_info_cache", new TypeToken<List<SplashRequestResult>>() {
            }.getType()).unEncrypted().build();
        }
        return bEz;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static SplashItemInfo m10964a(SplashRequestResult splashRequestResult) {
        if (splashRequestResult == null) {
            return null;
        }
        SplashItemInfo splashItemInfo = new SplashItemInfo();
        splashItemInfo.lId = C2575a.m7391rq(splashRequestResult.f3374id);
        splashItemInfo.mLang = splashRequestResult.lang;
        splashItemInfo.mEventCode = splashRequestResult.eventcode;
        splashItemInfo.mEventParam = splashRequestResult.eventparameter;
        splashItemInfo.mStayTime = splashRequestResult.staytime;
        splashItemInfo.mExpireTime = splashRequestResult.expiretime;
        splashItemInfo.mPublishTime = splashRequestResult.publistime;
        splashItemInfo.mUrl = splashRequestResult.imgurl;
        splashItemInfo.mTitle = splashRequestResult.title;
        return splashItemInfo;
    }

    /* access modifiers changed from: private */
    /* renamed from: ag */
    public static List<SplashRequestResult> m10965ag(List<SplashRequestResult> list) {
        if (list != null) {
            if (!list.isEmpty()) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    SplashRequestResult splashRequestResult = (SplashRequestResult) it.next();
                    if (splashRequestResult == null || TextUtils.isEmpty(splashRequestResult.imgurl) || !C4360b.m10950ec(splashRequestResult.expiretime) || !C4360b.m10951ed(splashRequestResult.publistime)) {
                        it.remove();
                    }
                }
                return list;
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* renamed from: ah */
    public static List<SplashRequestResult> m10966ah(List<SplashRequestResult> list) {
        if (list != null) {
            if (!list.isEmpty()) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    SplashRequestResult splashRequestResult = (SplashRequestResult) it.next();
                    if (splashRequestResult != null && !TextUtils.isEmpty(splashRequestResult.imgurl)) {
                        if (C4360b.m10950ec(splashRequestResult.expiretime)) {
                            C2570b.m7336hy(VivaBaseApplication.m8749FZ()).mo12210y(splashRequestResult.imgurl).mo12189tM();
                        }
                    }
                    it.remove();
                }
                return list;
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* renamed from: ai */
    public static void m10967ai(List<SplashRequestResult> list) {
        m10963Qt().saveCache(list);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static SplashRequestResult m10972c(Context context, List<SplashRequestResult> list) {
        if (list != null) {
            if (!list.isEmpty()) {
                int Qo = (m10958Qo() + 1) % list.size();
                SplashRequestResult splashRequestResult = (SplashRequestResult) list.get(Qo);
                C2570b.m7336hy(context).mo12210y(splashRequestResult.imgurl).mo12189tM();
                m10981hK(Qo);
                return splashRequestResult;
            }
        }
        return null;
    }

    /* renamed from: cK */
    public static boolean m10973cK(Context context) {
        if (m10955Ql()) {
            return true;
        }
        String str = "slIfMrothgaennapS";
        StringBuilder sb = new StringBuilder();
        sb.append("splashCachePath=");
        sb.append(m10953Qj());
        LogUtils.m14223i("SplashInfoManager", sb.toString());
        if (!m10954Qk()) {
            m10974cL(context);
            return false;
        }
        boolean h = C4059d.m10109h(context, true);
        if (h) {
            String str2 = "dt__ys_hprpelak_eryiesepmf";
            AppPreferencesSetting.getInstance().setAppSettingStr("pref_splash_ready_time_key", m10956Qm());
        }
        return h;
    }

    /* renamed from: cL */
    public static void m10974cL(final Context context) {
        if (C4600l.m11739k(context, true)) {
            C3727b.m9086i(C4580b.m11635Si(), AppStateModel.getInstance().getCountryCode(), C4580b.m11653dz(context), UserServiceProxy.getUserId()).mo10196g(C1820a.aVi()).mo10194f(C1820a.aVi()).mo10199i(new C1518f<List<AppPopupInfoResult>, Integer>() {
                /* renamed from: am */
                public Integer apply(List<AppPopupInfoResult> list) {
                    if (list == null) {
                        return Integer.valueOf(0);
                    }
                    String str = "oPsppWwiuon";
                    Uri tableUri = SocialConstDef.getTableUri(SocialConstDef.TBL_NAME_POPUP_WINDOW_INFO);
                    List<C4064b> cs = C4059d.m10106cs(context);
                    if (cs != null && cs.size() > 0) {
                        for (int i = 0; i < list.size(); i++) {
                            AppPopupInfoResult appPopupInfoResult = (AppPopupInfoResult) list.get(i);
                            for (C4064b bVar : cs) {
                                if (bVar.buF == appPopupInfoResult.dialogid && !TextUtils.isEmpty(bVar.buN)) {
                                    appPopupInfoResult.popdaytime = bVar.buN;
                                }
                            }
                        }
                    }
                    ContentResolver contentResolver = context.getContentResolver();
                    contentResolver.delete(tableUri, null, null);
                    ContentValues contentValues = new ContentValues();
                    int size = list.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        AppPopupInfoResult appPopupInfoResult2 = (AppPopupInfoResult) list.get(i2);
                        contentValues.clear();
                        contentValues.put(SocialConstDef.POPUPWINDOW_ITEM_WINDOWID, Integer.valueOf(appPopupInfoResult2.dialogid));
                        if (!TextUtils.isEmpty(appPopupInfoResult2.expiretime)) {
                            contentValues.put("expiretime", appPopupInfoResult2.expiretime);
                        }
                        contentValues.put("orderno", Integer.valueOf(appPopupInfoResult2.orderno));
                        contentValues.put("modelcode", Integer.valueOf(appPopupInfoResult2.modelcode));
                        contentValues.put("type", Integer.valueOf(appPopupInfoResult2.type));
                        String str2 = "vynmpetee";
                        contentValues.put(SocialConstDef.POPUPWINDOW_ITEM_EVENTTYPE, Integer.valueOf(appPopupInfoResult2.eventtype));
                        if (!TextUtils.isEmpty(appPopupInfoResult2.eventcontent)) {
                            contentValues.put(SocialConstDef.POPUPWINDOW_ITEM_EVENTCNT, appPopupInfoResult2.eventcontent);
                        }
                        if (!TextUtils.isEmpty(appPopupInfoResult2.iconurl)) {
                            String str3 = "onruolc";
                            contentValues.put("iconurl", appPopupInfoResult2.iconurl);
                        }
                        if (!TextUtils.isEmpty(appPopupInfoResult2.title)) {
                            contentValues.put("title", appPopupInfoResult2.title);
                        }
                        if (!TextUtils.isEmpty(appPopupInfoResult2.desc)) {
                            String str4 = "srctebiiond";
                            contentValues.put("description", appPopupInfoResult2.desc);
                        }
                        if (!TextUtils.isEmpty(appPopupInfoResult2.extend)) {
                            String str5 = "dnoefebnxi";
                            contentValues.put(SocialConstDef.POPUPWINDOW_ITEM_EXTENDINFO, appPopupInfoResult2.extend);
                        }
                        if (!TextUtils.isEmpty(appPopupInfoResult2.videourl)) {
                            contentValues.put(SocialConstDef.POPUPWINDOW_ITEM_VIDEOURL, appPopupInfoResult2.videourl);
                        }
                        if (!TextUtils.isEmpty(appPopupInfoResult2.popdaytime)) {
                            contentValues.put(SocialConstDef.POPUPWINDOW_ITEM_POP_DAY_TIME, appPopupInfoResult2.popdaytime);
                        }
                        contentValues.put(SocialConstDef.POPUPWINDOW_ITEM_DISPLAYSTATE, Integer.valueOf(appPopupInfoResult2.displayState));
                        String str6 = "yioCpautsntl";
                        contentValues.put(SocialConstDef.POPUPWINDOW_ITEM_DISPLAY_COUNT, Integer.valueOf(appPopupInfoResult2.displayCount));
                        contentResolver.insert(tableUri, contentValues);
                    }
                    return Integer.valueOf(size);
                }
            }).mo10188a((C1850u<? super T>) new C1850u<Integer>() {
                /* renamed from: a */
                public void mo9883a(C1495b bVar) {
                }

                /* renamed from: e */
                public void onSuccess(Integer num) {
                    String str = "k_stereyap_etiu_dfep";
                    AppPreferencesSetting.getInstance().setAppSettingStr("pref_update_time_key", C4361c.m10956Qm());
                    try {
                        C4059d.m10105cr(context);
                        if (num != null && num.intValue() > 0 && C4059d.m10109h(context, false)) {
                            String str2 = "__tmpyrr_esp_ykdflhseieama";
                            AppPreferencesSetting.getInstance().setAppSettingStr("pref_splash_ready_time_key", C4361c.m10956Qm());
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                public void onError(Throwable th) {
                    th.printStackTrace();
                }
            });
        }
    }

    /* renamed from: cM */
    public static void m10975cM(Context context) {
        try {
            m10976cN(context).mo10188a((C1850u<? super T>) new C1810c<List<SplashRequestResult>>() {
                public void onError(Throwable th) {
                }

                public void onSuccess(List<SplashRequestResult> list) {
                    List aj = C4361c.m10966ah(list);
                    if (aj != null && !aj.isEmpty()) {
                        C4361c.m10967ai(aj);
                    }
                }
            });
        } catch (Exception unused) {
        }
    }

    /* renamed from: cN */
    static C1848s<List<SplashRequestResult>> m10976cN(Context context) {
        if (C4600l.m11739k(context, true)) {
            return C3727b.m9085h(C4580b.m11635Si(), AppStateModel.getInstance().getCountryCode(), C4580b.m11653dz(context), UserServiceProxy.getUserId()).mo10196g(C1820a.aVi());
        }
        String str = "t/ndcNwo.torc k ine/seten";
        return C1848s.m5331x(new Exception("Network isn't connected."));
    }

    /* renamed from: cO */
    static C1848s<SplashItemInfo> m10977cO(final Context context) {
        return m10976cN(context).mo10194f(C1820a.aVi()).mo10185a(500, TimeUnit.MILLISECONDS, m10962Qs().aTW()).mo10199i(new C1518f<List<SplashRequestResult>, SplashRequestResult>() {
            /* renamed from: an */
            public SplashRequestResult apply(List<SplashRequestResult> list) throws Exception {
                List al = C4361c.m10965ag(list);
                C4361c.m10967ai(al);
                return C4361c.m10972c(context, al);
            }
        }).mo10199i(new C1518f<SplashRequestResult, SplashItemInfo>() {
            /* renamed from: c */
            public SplashItemInfo apply(SplashRequestResult splashRequestResult) throws Exception {
                return C4361c.m10964a(splashRequestResult);
            }
        });
    }

    /* renamed from: cP */
    public static SplashItemInfo m10978cP(Context context) {
        return m10964a(m10972c(context, m10965ag((List) m10963Qt().getCacheSync())));
    }

    /* renamed from: ef */
    private static Boolean m10980ef(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return Boolean.valueOf(C4584e.m11678b(new SimpleDateFormat(SplashItemInfo.TIME_FORMAT, Locale.US).parse(str)));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return Boolean.valueOf(false);
    }

    /* renamed from: hK */
    private static void m10981hK(int i) {
        m10982hL((Calendar.getInstance().get(6) << 20) + i);
    }

    /* renamed from: hL */
    private static void m10982hL(int i) {
        String str = "ossi_asnlaliaprhtadalgt__";
        bEy.setInt("last_splash_original_data", i);
    }
}
