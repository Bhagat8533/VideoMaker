package com.introvd.template.app;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import com.google.android.exoplayer2.DefaultLoadControl;
import com.introvd.template.C4676f;
import com.introvd.template.C4677g;
import com.introvd.template.C4681i;
import com.introvd.template.VivaBaseApplication;
import com.introvd.template.channel.C5206b;
import com.introvd.template.common.AppPreferencesSetting;
import com.introvd.template.common.CommonConfigure;
import com.introvd.template.common.FileUtils;
import com.introvd.template.common.LogUtils;
import com.introvd.template.common.ResourceUtils;
import com.introvd.template.common.UserBehaviorLog;
import com.introvd.template.datacenter.BaseSocialNotify;
import com.introvd.template.datacenter.SimpleSocialSecurity;
import com.introvd.template.datacenter.SocialConstDef;
import com.introvd.template.datacenter.SocialProvider;
import com.introvd.template.datacenter.SocialService;
import com.introvd.template.p374q.C8347f;
import com.introvd.template.p374q.C8356h;
import com.introvd.template.router.editor.gallery.GalleryRouter;
import com.introvd.template.router.lbs.LbsManagerProxy;
import com.xiaoying.p448a.C9537b;
import java.util.Locale;
import lib.C12177i;

/* renamed from: com.introvd.template.app.u */
public class C4388u {
    private static volatile C4388u biI;
    private static boolean biJ;
    private Application biH = VivaBaseApplication.m8749FZ();
    private boolean biK = false;

    private C4388u() {
    }

    /* renamed from: HD */
    public static C4388u m11055HD() {
        if (biI == null) {
            synchronized (C4388u.class) {
                if (biI == null) {
                    biI = new C4388u();
                }
            }
        }
        return biI;
    }

    /* renamed from: HE */
    public static void m11056HE() {
        C8356h.aKg().uninit();
        LbsManagerProxy.unInit();
    }

    /* renamed from: HF */
    public static void m11057HF() {
        C8347f.aKf().uninit();
        biJ = false;
    }

    /* renamed from: HH */
    private void m11058HH() {
        LogUtils.mlogLevel = 0;
        LogUtils.PERFORMANCE_LOG_OPEN = false;
        CommonConfigure.IS_CRASH_LOG_UPLOAD = false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x002a, code lost:
        return;
     */
    /* renamed from: bL */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void m11059bL(android.content.Context r2) {
        /*
            java.lang.Class<com.introvd.template.app.u> r0 = com.introvd.template.app.C4388u.class
            monitor-enter(r0)
            boolean r1 = biJ     // Catch:{ all -> 0x002b }
            if (r1 == 0) goto L_0x0009
            monitor-exit(r0)
            return
        L_0x0009:
            boolean r1 = com.introvd.template.common.SDCardManager.hasSDCard()     // Catch:{ all -> 0x002b }
            if (r1 != 0) goto L_0x0011
            monitor-exit(r0)
            return
        L_0x0011:
            r1 = 1
            biJ = r1     // Catch:{ all -> 0x002b }
            com.introvd.template.app.C4113q.m10217bE(r2)     // Catch:{ all -> 0x002b }
            r2 = 7
            r1 = 0
            com.introvd.template.p173a.C3570a.m8781x(r2, r1)     // Catch:{ all -> 0x002b }
            java.lang.Class<com.introvd.template.router.editor.IEditorService> r2 = com.introvd.template.router.editor.IEditorService.class
            com.aiii.android.arouter.facade.template.c r2 = com.introvd.template.router.BizServiceManager.getService(r2)     // Catch:{ all -> 0x002b }
            com.introvd.template.router.editor.IEditorService r2 = (com.introvd.template.router.editor.IEditorService) r2     // Catch:{ all -> 0x002b }
            if (r2 == 0) goto L_0x0029
            r2.startAllInitService()     // Catch:{ all -> 0x002b }
        L_0x0029:
            monitor-exit(r0)
            return
        L_0x002b:
            r2 = move-exception
            monitor-exit(r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.app.C4388u.m11059bL(android.content.Context):void");
    }

    /* renamed from: bM */
    private void m11060bM(Context context) {
        AppPreferencesSetting.getInstance().init(this.biH.getApplicationContext());
        CommonConfigure.EN_APP_KILL_PROCESS = true;
        m11058HH();
        UserBehaviorLog.setCrashLogReport(VivaBaseApplication.m8749FZ(), false);
        if (CommonConfigure.IS_CRASH_LOG_UPLOAD) {
            FileUtils.createMultilevelDirectory(CommonConfigure.APP_CRASH_PATH);
        }
        GalleryRouter.getInstance().init(AppPreferencesSetting.getInstance().getAppSettingBoolean("key_pref_gallery_new_version", false));
    }

    /* renamed from: bN */
    public static void m11061bN(Context context) {
        String activeNetworkName = BaseSocialNotify.getActiveNetworkName(context);
        String locale = Locale.getDefault().toString();
        int i = !TextUtils.isEmpty(activeNetworkName) && !BaseSocialNotify.CONNECTIVITY_NAME_MOBILE.equalsIgnoreCase(activeNetworkName) ? 10000 : DefaultLoadControl.DEFAULT_MIN_BUFFER_MS;
        int i2 = C12177i.f6157m;
        if (!Locale.CHINA.toString().equals(locale)) {
            i += 5000;
            i2 = 35000;
            C9537b.setParameter("AppZoneType", Long.valueOf(1000));
        } else {
            C9537b.setParameter("AppZoneType", Long.valueOf(0));
        }
        SocialService.NETWORK_RESPONSE_TIMEOUT = i2;
        SocialService.NETWORK_CONNECT_TIMEOUT = i;
        C9537b.setSocketTimeout(i2);
        C9537b.setConnectionTimeout(i);
        C9537b.m27464wF(3);
        C9537b.setParameter("SetSSL", Boolean.valueOf(true));
        C9537b.setParameter("SetMethodName", Boolean.valueOf(true));
        C9537b.setParameter("Referer", "http://xiaoying.tv");
    }

    public static void closeDatabase(Context context, boolean z) {
        context.getContentResolver().delete(SocialConstDef.getTableUri(z ? SocialConstDef.TBL_NAME_INSIDE_DB_BACKUP : SocialConstDef.TBL_NAME_INSIDE_DB_CLOSE), null, null);
    }

    /* renamed from: dl */
    private void m11062dl(String str) throws Exception {
        String bq = C4676f.m12173bq(VivaBaseApplication.m8749FZ());
        if (bq == null || bq.startsWith(str)) {
            String dV = C5206b.m14212dV(this.biH);
            String dU = C5206b.m14211dU(this.biH);
            if (TextUtils.isEmpty(dV) || TextUtils.isEmpty(dU)) {
                throw new Exception("Invalid XiaoYing app key or channel name");
            }
            return;
        }
        throw new Exception("Unmatched package name");
    }

    @SuppressLint({"NewApi"})
    /* renamed from: HG */
    public boolean mo24453HG() throws Exception {
        if (this.biK) {
            return false;
        }
        Context applicationContext = this.biH.getApplicationContext();
        SocialProvider.init(applicationContext);
        SocialProvider.setSocialSecurity(SimpleSocialSecurity.getInstance(this.biH));
        ResourceUtils.setContext(C4681i.m12184Gp().mo25015Gq());
        m11062dl(this.biH.getPackageName());
        m11060bM(applicationContext);
        C4677g.m12175br(this.biH);
        m11061bN(applicationContext);
        m11059bL(VivaBaseApplication.m8749FZ());
        this.biK = true;
        return true;
    }
}
