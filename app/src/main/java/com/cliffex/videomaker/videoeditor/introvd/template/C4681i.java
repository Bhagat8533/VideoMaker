package com.introvd.template;

import android.content.res.AssetManager;
import com.aiii.android.arouter.facade.template.C1949c;
import com.aiii.android.arouter.p091c.C1919a;
import com.introvd.template.apicore.C3629g;
import com.introvd.template.app.p177b.C3744d;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.common.StorageInfo;
import com.introvd.template.crash.ICrashFlavour;
import com.introvd.template.p173a.p174a.C3571a;
import com.introvd.template.p203b.C4580b;
import com.introvd.template.p374q.C8343b;
import com.introvd.template.p374q.C8356h;
import com.introvd.template.router.BizServiceManager;
import com.introvd.template.router.community.ICommunityService;
import com.p131c.p132a.C2561a;

/* renamed from: com.introvd.template.i */
public class C4681i {
    public static volatile String bgr = "NONE";
    private VivaBaseApplication bgp;
    private C3744d bgq;
    public ICrashFlavour bgs;
    private AppMiscListener bgt;
    public boolean bgu;

    /* renamed from: com.introvd.template.i$a */
    private static class C4683a {
        /* access modifiers changed from: private */
        public static C4681i bgv = new C4681i();
    }

    private C4681i() {
    }

    /* renamed from: Gp */
    public static C4681i m12184Gp() {
        return C4683a.bgv;
    }

    /* renamed from: Gq */
    public AssetManager mo25015Gq() {
        return this.bgp.getAssets();
    }

    /* renamed from: Gr */
    public AppMiscListener mo25016Gr() {
        return this.bgt;
    }

    /* renamed from: Gs */
    public VivaBaseApplication mo25017Gs() {
        return this.bgp;
    }

    /* renamed from: Gt */
    public void mo25018Gt() {
        C8343b.m24053gO(this.bgp);
        C8356h.m24101gO(this.bgp);
        ICommunityService iCommunityService = (ICommunityService) BizServiceManager.getService(ICommunityService.class);
        if (iCommunityService != null) {
            iCommunityService.stopAllPublish(this.bgp);
        }
    }

    /* renamed from: a */
    public void mo25019a(AppMiscListener appMiscListener) {
        this.bgt = appMiscListener;
    }

    /* renamed from: a */
    public void mo25020a(VivaBaseApplication vivaBaseApplication) {
        C3571a.m8785ex("beforeXYBaseInit");
        if (vivaBaseApplication != null) {
            this.bgp = vivaBaseApplication;
            boolean z = false;
            LogUtilsV2.init(false, null);
            String dx = C4580b.m11651dx(vivaBaseApplication);
            C3571a.m8785ex("getAppkey");
            if (dx != null && dx.toLowerCase().contains("ts")) {
                z = true;
            }
            this.bgu = z;
            if (this.bgu) {
                LogUtilsV2.init(true, "QQQVVV");
            }
            C3571a.m8785ex("LogUtilsV2");
            C2561a.init(vivaBaseApplication);
            C3571a.m8785ex("ApkInfoProvider");
            StorageInfo.setApplicationContext(vivaBaseApplication);
            C3571a.m8785ex("StorageInfo");
            C4677g.m12180j(vivaBaseApplication);
            C3571a.m8785ex("XYFileManager");
            if (dx != null && dx.toLowerCase().contains("pt")) {
                C1919a.m5532sf();
                C1919a.m5530sd();
            }
            C1919a.m5528a(vivaBaseApplication);
            C3571a.m8785ex("ARouter");
            this.bgs = (ICrashFlavour) C1919a.m5529sc().mo10356i(ICrashFlavour.class);
            this.bgq = new C3744d(mo25017Gs());
            this.bgq.mo23187JV();
            C3629g.m8896GS().mo22970a(this.bgq);
            C3571a.m8785ex("XYBaseEnd");
        }
    }

    public <T extends C1949c> T getService(Class<T> cls) {
        return BizServiceManager.getService(cls);
    }
}
