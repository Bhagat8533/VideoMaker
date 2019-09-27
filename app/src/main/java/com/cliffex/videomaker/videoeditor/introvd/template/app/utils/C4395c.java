package com.introvd.template.app.utils;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import android.text.format.Formatter;
import com.aiii.android.arouter.p091c.C1919a;
import com.introvd.template.R;
import com.introvd.template.app.ApplicationBase;
import com.introvd.template.app.p177b.C3742b;
import com.introvd.template.app.p190j.C4023a;
import com.introvd.template.common.CommonConfigure;
import com.introvd.template.common.DeviceInfo;
import com.introvd.template.common.FileUtils;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.common.MSize;
import com.introvd.template.common.UserBehaviorLog;
import com.introvd.template.common.Utils;
import com.introvd.template.common.model.AppStateModel;
import com.introvd.template.component.feedback.C5348a;
import com.introvd.template.component.feedback.C5349b;
import com.introvd.template.component.feedback.model.FBExtraDataInfo;
import com.introvd.template.component.videofetcher.C5365b;
import com.introvd.template.component.videofetcher.C5390c;
import com.introvd.template.component.videofetcher.C5402d;
import com.introvd.template.component.videofetcher.p239c.C5399i;
import com.introvd.template.component.videofetcher.p239c.C5399i.C5401a;
import com.introvd.template.crash.C5523b;
import com.introvd.template.editor.p252e.C5878a;
import com.introvd.template.explorer.extract.C7234b;
import com.introvd.template.p203b.C4580b;
import com.introvd.template.p203b.C4598j;
import com.introvd.template.p203b.C4600l;
import com.introvd.template.router.BizServiceManager;
import com.introvd.template.router.community.ICommunityAPI;
import com.introvd.template.router.community.ICommunityAPI.OnStatusUpdateCallback;
import com.introvd.template.router.community.WhatsAppStatus;
import com.introvd.template.router.editor.IEditorService;
import com.introvd.template.router.setting.ISettingRouter;
import com.introvd.template.router.user.UserServiceProxy;
import com.introvd.template.router.user.model.LoginUserInfo;
import com.introvd.template.sns.SnsShareManager;
import com.p131c.p132a.C2561a;
import com.quvideo.sns.base.p228b.C4979b.C4981a;
import java.lang.ref.WeakReference;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
import p037b.p050b.C1834l;
import p037b.p050b.p057e.C1517e;

/* renamed from: com.introvd.template.app.utils.c */
public class C4395c {
    /* renamed from: O */
    public static void m11078O(Activity activity) {
        m11079P(activity);
        C5402d.m14716ZG().mo27030ai(activity);
    }

    /* renamed from: P */
    private static void m11079P(Activity activity) {
        final WeakReference weakReference = new WeakReference(activity);
        C5402d.m14716ZG().mo27028a(activity.getApplicationContext(), new C5390c() {
            /* renamed from: QM */
            public void mo24460QM() {
                if (weakReference.get() != null) {
                    C4395c.m11089a((Activity) weakReference.get(), 0, false);
                }
            }

            /* renamed from: S */
            public void mo24461S(String str, String str2) {
                int i = "WhatsApp".equals(str) ? 32 : "Facebook".equals(str) ? 28 : "Instagram".equals(str) ? 31 : "Youtube".equals(str) ? 26 : "FBMessenger".equals(str) ? 33 : 100;
                if (weakReference.get() != null) {
                    C4395c.m11087a((Activity) weakReference.get(), i, str2);
                }
            }

            /* renamed from: a */
            public void mo24462a(Context context, String str, HashMap<String, String> hashMap) {
                UserBehaviorLog.onKVEvent(context, str, hashMap);
            }

            /* renamed from: a */
            public void mo24463a(final C5365b bVar) {
                if (bVar != null) {
                    ICommunityAPI iCommunityAPI = (ICommunityAPI) C1919a.m5529sc().mo10356i(ICommunityAPI.class);
                    if (iCommunityAPI == null || weakReference.get() == null) {
                        bVar.mo26935aB(null);
                    } else {
                        iCommunityAPI.getWhatsAppVideoList((Context) weakReference.get(), new OnStatusUpdateCallback() {
                            public void onSuccess(List<WhatsAppStatus> list) {
                                bVar.mo26935aB(C4395c.m11091aq(list));
                            }
                        });
                    }
                }
            }

            /* renamed from: d */
            public void mo24464d(Activity activity, String str) {
                IEditorService iEditorService = (IEditorService) C1919a.m5529sc().mo10356i(IEditorService.class);
                if (iEditorService != null) {
                    iEditorService.createProjectAndPreview(activity, str, true);
                    C1834l.m5257ah(Boolean.valueOf(true)).mo10164f(300, TimeUnit.MILLISECONDS).mo10168g((C1517e<? super T>) new C1517e<Boolean>() {
                        /* renamed from: d */
                        public void accept(Boolean bool) throws Exception {
                            C5402d.m14716ZG().mo27027ZI();
                        }
                    });
                }
            }
        });
    }

    /* renamed from: Q */
    public static void m11080Q(Activity activity) {
        if (m11082R(activity)) {
            C5349b.m14574a(new C5348a() {
            });
            C5349b.m14576ah(activity);
        }
    }

    /* renamed from: QL */
    private static String m11081QL() {
        return C2561a.aOS() ? "asfasf@gmail.com" : "support@starvlogsteam.com";
    }

    /* renamed from: R */
    private static boolean m11082R(Activity activity) {
        if (!C4600l.m11739k(activity, true)) {
            return false;
        }
        LoginUserInfo userInfo = UserServiceProxy.getUserInfo();
        String str = userInfo != null ? userInfo.nickname : null;
        String dz = C4580b.m11653dz(activity);
        if (TextUtils.isEmpty(dz)) {
            StringBuilder sb = new StringBuilder();
            sb.append("device is null when init feedback client, app is first launch : ");
            sb.append(ApplicationBase.biq);
            C5523b.logException(new Throwable(sb.toString()));
        }
        C5349b.m14583k(AppStateModel.getInstance().getCountryCode(), str, CommonConfigure.APP_CACHE_PATH, dz);
        C5349b.m14574a(null);
        return true;
    }

    /* renamed from: S */
    public static void m11083S(Activity activity) {
        StringBuilder sb = new StringBuilder();
        sb.append(activity.getResources().getString(R.string.xiaoying_str_com_app_name));
        sb.append(" Android ");
        sb.append(activity.getResources().getString(R.string.xiaoying_str_com_pref_setting_feed_back));
        String sb2 = sb.toString();
        String str = "";
        String str2 = "0.0.0.0";
        MSize screenSize = DeviceInfo.getScreenSize(activity);
        try {
            str2 = activity.getPackageManager().getPackageInfo(activity.getPackageName(), 0).versionName;
        } catch (Exception unused) {
        }
        IEditorService iEditorService = (IEditorService) BizServiceManager.getService(IEditorService.class);
        String str3 = null;
        if (iEditorService != null) {
            str3 = iEditorService.getGpuType();
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append(str);
        sb3.append(activity.getResources().getString(R.string.xiaoying_str_com_feedback_hint));
        sb3.append("\n");
        String sb4 = sb3.toString();
        StringBuilder sb5 = new StringBuilder();
        sb5.append(sb4);
        sb5.append("------------------------------------------------------------------------\n");
        String sb6 = sb5.toString();
        StringBuilder sb7 = new StringBuilder();
        sb7.append(sb6);
        sb7.append("\n\n\n\n\n\n\n");
        String sb8 = sb7.toString();
        StringBuilder sb9 = new StringBuilder();
        sb9.append(sb8);
        sb9.append("------------------------------------------------------------------------\n");
        String sb10 = sb9.toString();
        StringBuilder sb11 = new StringBuilder();
        sb11.append(sb10);
        sb11.append("App Version:      ");
        sb11.append(str2);
        sb11.append("\n");
        String sb12 = sb11.toString();
        StringBuilder sb13 = new StringBuilder();
        sb13.append(sb12);
        sb13.append("Android Version:  ");
        sb13.append(DeviceInfo.getSDKVersion());
        sb13.append("\n");
        String sb14 = sb13.toString();
        StringBuilder sb15 = new StringBuilder();
        sb15.append(sb14);
        sb15.append("Device Model:     ");
        sb15.append(DeviceInfo.getModule());
        sb15.append("\n");
        String sb16 = sb15.toString();
        StringBuilder sb17 = new StringBuilder();
        sb17.append(sb16);
        sb17.append("Device Width:     ");
        sb17.append(screenSize.width);
        sb17.append("\n");
        String sb18 = sb17.toString();
        StringBuilder sb19 = new StringBuilder();
        sb19.append(sb18);
        sb19.append("Device Height:    ");
        sb19.append(screenSize.height);
        sb19.append("\n");
        String sb20 = sb19.toString();
        StringBuilder sb21 = new StringBuilder();
        sb21.append(sb20);
        sb21.append("Device GPU:       ");
        sb21.append(str3);
        sb21.append("\n");
        String sb22 = sb21.toString();
        StringBuilder sb23 = new StringBuilder();
        sb23.append(sb22);
        sb23.append("Device Capacity:  ");
        sb23.append(m11084T(activity));
        sb23.append("\n");
        String sb24 = sb23.toString();
        StringBuilder sb25 = new StringBuilder();
        sb25.append(sb24);
        sb25.append("Device Avaliable: ");
        sb25.append(m11085U(activity));
        sb25.append("\n");
        String sb26 = sb25.toString();
        Intent intent = new Intent("android.intent.action.SENDTO");
        StringBuilder sb27 = new StringBuilder();
        sb27.append("mailto:");
        sb27.append(m11081QL());
        intent.setData(Uri.parse(sb27.toString()));
        intent.putExtra("android.intent.extra.SUBJECT", sb2);
        intent.putExtra("android.intent.extra.TEXT", sb26);
        try {
            activity.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: T */
    private static String m11084T(Activity activity) {
        StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().toString());
        return Formatter.formatFileSize(activity, ((long) statFs.getBlockSize()) * ((long) statFs.getBlockCount()));
    }

    /* renamed from: U */
    private static String m11085U(Activity activity) {
        StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().toString());
        return Formatter.formatFileSize(activity, ((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks()));
    }

    /* renamed from: Y */
    public static boolean m11086Y(Context context, String str) {
        try {
            if ((context.getPackageManager().getApplicationInfo(str, 0).flags & 262144) != 0) {
                return true;
            }
        } catch (NameNotFoundException unused) {
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static void m11087a(Activity activity, int i, String str) {
        SnsShareManager.shareVideo(activity, i, new C4981a().mo25446cQ(str).mo25441FJ(), null);
    }

    /* renamed from: a */
    public static void m11088a(Activity activity, long j) {
        m11089a(activity, j, false);
    }

    /* renamed from: a */
    public static void m11089a(Activity activity, long j, boolean z) {
        if (!C5349b.enable()) {
            m11083S(activity);
        } else if (m11082R(activity)) {
            boolean z2 = AppStateModel.getInstance().isInChina() || !m11097dd(activity.getApplicationContext());
            if (z || !m11095db(activity.getApplicationContext())) {
                if (j > 0) {
                    C5349b.m14577b(activity, j);
                } else {
                    C5349b.m14575ag(activity);
                }
                return;
            }
            FBExtraDataInfo fBExtraDataInfo = new FBExtraDataInfo(C3742b.m9111II().mo23157Jd(), C3742b.m9111II().mo23158Je(), z2, j, m11098de(activity.getApplicationContext()));
            C5349b.m14573a(activity, fBExtraDataInfo);
        }
    }

    /* renamed from: a */
    public static void m11090a(Activity activity, String str, int i, String str2) {
        if (m11082R(activity)) {
            C5349b.m14579b(activity, str, i, str2);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: aq */
    public static List<C5399i> m11091aq(List<WhatsAppStatus> list) {
        ArrayList arrayList = new ArrayList();
        if (list == null || list.isEmpty()) {
            return arrayList;
        }
        for (WhatsAppStatus whatsAppStatus : list) {
            C5399i ZX = new C5401a().mo27018ar(whatsAppStatus.duration).mo27021fE(whatsAppStatus.fileName).mo27025kc(whatsAppStatus.hasSave).mo27024kb(whatsAppStatus.height).mo27023ka(whatsAppStatus.width).mo27022jZ(whatsAppStatus.f3573id).mo27019fC(whatsAppStatus.path).mo27020fD(whatsAppStatus.thumbnailPath).mo27017ZX();
            if (!arrayList.contains(ZX) && FileUtils.isFileExisted(whatsAppStatus.thumbnailPath)) {
                arrayList.add(ZX);
            }
        }
        return arrayList;
    }

    /* renamed from: b */
    public static void m11093b(Activity activity, int i, String str) {
        FBExtraDataInfo fBExtraDataInfo = new FBExtraDataInfo(i, str, C4023a.m9973MK().mo23679MR(), C4023a.m9973MK().mo23680MS(), true);
        C5349b.m14578b(activity, fBExtraDataInfo);
    }

    /* renamed from: db */
    public static boolean m11095db(Context context) {
        boolean z = false;
        if (context == null) {
            return false;
        }
        if (AppStateModel.getInstance().isInChina() || (!AppStateModel.getInstance().isInChina() && m11097dd(context.getApplicationContext()))) {
            z = true;
        }
        return z;
    }

    /* renamed from: dc */
    public static boolean m11096dc(Context context) {
        return m11097dd(context) && !AppStateModel.getInstance().isInChina();
    }

    /* renamed from: dd */
    public static boolean m11097dd(Context context) {
        String de = m11098de(context);
        return !TextUtils.isEmpty(de) && ("en_US".equalsIgnoreCase(de) || "en".equalsIgnoreCase(de));
    }

    /* renamed from: de */
    public static String m11098de(Context context) {
        String df = m11099df(context);
        StringBuilder sb = new StringBuilder();
        sb.append("setLocale lang code=");
        sb.append(df);
        LogUtilsV2.m14230i(sb.toString());
        return C4580b.m11644b(C4598j.m11732eK(df));
    }

    /* renamed from: df */
    public static String m11099df(Context context) {
        ISettingRouter iSettingRouter = (ISettingRouter) BizServiceManager.getService(ISettingRouter.class);
        if (iSettingRouter == null) {
            return null;
        }
        String str = iSettingRouter.getAppSettedLocaleModel(context).value;
        StringBuilder sb = new StringBuilder();
        sb.append("setLocale lang code=");
        sb.append(str);
        LogUtilsV2.m14230i(sb.toString());
        return str;
    }

    /* renamed from: dg */
    public static boolean m11100dg(Context context) {
        return "EA:5A:D4:3B:0C:36:BD:F3:FD:0A:55:B8:D5:45:A3:F5:5A:01:37:52".equals(Utils.getSignatureInfo(context, context.getPackageName(), "SHA1"));
    }

    /* renamed from: ei */
    public static long m11101ei(String str) {
        try {
            Date parse = new SimpleDateFormat("yyyyMMddHHmmss", Locale.US).parse(C4580b.m11657eC(str));
            if (parse != null) {
                return parse.getTime();
            }
            return 0;
        } catch (ParseException unused) {
            return 0;
        }
    }

    public static String getFAQUrl() {
        return C4580b.m11666qi() ? "https://hybrid.xiaoying.tv/web/active/arFAQ0118/index.html#/" : "https://hybrid.xiaoying.tv/web/vivaVideo/faq/index.html?__webview_options__=st=NO*sbi=NO";
    }

    /* renamed from: h */
    public static String m11102h(int i, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(C5878a.TAG, i);
            jSONObject.put(C7234b.TAG, str);
        } catch (JSONException unused) {
        }
        return jSONObject.toString();
    }
}
