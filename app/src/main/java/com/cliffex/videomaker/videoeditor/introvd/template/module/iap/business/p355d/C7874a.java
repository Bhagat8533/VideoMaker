package com.introvd.template.module.iap.business.p355d;

import android.app.Activity;
import android.content.Context;
import android.util.SparseIntArray;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.datacenter.SocialConstDef;
import com.introvd.template.module.iap.C8048e;
import com.introvd.template.module.iap.C8052g;
import com.introvd.template.module.iap.C8071p;
import com.introvd.template.module.iap.C8072q;
import com.introvd.template.module.iap.business.p356e.C7899c;
import org.json.JSONObject;
import p037b.p050b.C1850u;
import p037b.p050b.p051a.p053b.C1487a;
import p037b.p050b.p054b.C1495b;
import p464d.p466b.p467a.C9649c;

/* renamed from: com.introvd.template.module.iap.business.d.a */
public final class C7874a {
    public static boolean dSQ;
    public static final C7875a dSR = new C7875a(null);
    /* access modifiers changed from: private */
    public C1495b dSN;
    private SparseIntArray dSO;
    private int dSP;
    /* access modifiers changed from: private */
    public JSONObject jsonObject;

    /* renamed from: com.introvd.template.module.iap.business.d.a$a */
    public static final class C7875a {
        private C7875a() {
        }

        public /* synthetic */ C7875a(C9648b bVar) {
            this();
        }
    }

    /* renamed from: com.introvd.template.module.iap.business.d.a$b */
    public static final class C7876b implements C1850u<JSONObject> {
        final /* synthetic */ C7874a dSS;

        C7876b(C7874a aVar) {
            this.dSS = aVar;
        }

        /* renamed from: a */
        public void mo9883a(C1495b bVar) {
            C9649c.m27672j(bVar, "d");
            this.dSS.dSN = bVar;
        }

        public void onError(Throwable th) {
            C9649c.m27672j(th, "e");
        }

        public void onSuccess(JSONObject jSONObject) {
            C9649c.m27672j(jSONObject, "jsonObject");
            this.dSS.jsonObject = jSONObject;
        }
    }

    /* renamed from: com.introvd.template.module.iap.business.d.a$c */
    public static final class C7877c extends TypeToken<SparseIntArray> {
        C7877c() {
        }
    }

    /* renamed from: iJ */
    private final int m22947iJ(boolean z) {
        try {
            this.dSO = (SparseIntArray) new Gson().fromJson(C7899c.aDg().getString("exitVipOperate", "{}"), new C7877c().getType());
        } catch (Throwable unused) {
        }
        if (this.dSO == null) {
            this.dSO = new SparseIntArray(4);
        }
        SparseIntArray sparseIntArray = this.dSO;
        if (sparseIntArray == null) {
            C9649c.aVp();
        }
        JSONObject jSONObject = this.jsonObject;
        if (jSONObject == null) {
            C9649c.aVp();
        }
        LogUtilsV2.m14228e(String.valueOf(this.dSO));
        int optInt = jSONObject.optInt("id");
        if (z) {
            return sparseIntArray.get(optInt);
        }
        this.dSP = sparseIntArray.get(optInt) + 1;
        sparseIntArray.put(optInt, this.dSP);
        if (sparseIntArray.size() > 3) {
            sparseIntArray.removeAt(0);
        }
        C7899c.aDg().setString("exitVipOperate", new Gson().toJson((Object) sparseIntArray));
        return sparseIntArray.get(optInt);
    }

    public final void aDe() {
        C8071p aBx = C8072q.aBx();
        C9649c.m27671i(aBx, "WarehouseServiceMgr.getAssetsService()");
        if (!aBx.isVip() && !dSQ) {
            C8052g aBe = C8048e.aBe();
            C9649c.m27671i(aBe, "ModuleIapInputHelper.getInstance()");
            aBe.mo23609MA().mo10194f(C1487a.aUa()).mo10188a((C1850u<? super T>) new C7876b<Object>(this));
        }
    }

    /* renamed from: aM */
    public final boolean mo32794aM(Activity activity) {
        C9649c.m27672j(activity, "activity");
        C8052g aBe = C8048e.aBe();
        C9649c.m27671i(aBe, "ModuleIapInputHelper.getInstance()");
        if (aBe.isYoungerMode() || dSQ || this.jsonObject == null) {
            return false;
        }
        dSQ = true;
        C8071p aBx = C8072q.aBx();
        C9649c.m27671i(aBx, "WarehouseServiceMgr.getAssetsService()");
        if (aBx.isVip()) {
            return false;
        }
        int iJ = m22947iJ(true);
        JSONObject jSONObject = this.jsonObject;
        if (jSONObject == null) {
            C9649c.aVp();
        }
        if (iJ >= jSONObject.optInt(SocialConstDef.POPUPWINDOW_ITEM_DISPLAY_COUNT)) {
            return false;
        }
        m22947iJ(false);
        Context context = activity;
        JSONObject jSONObject2 = this.jsonObject;
        if (jSONObject2 == null) {
            C9649c.aVp();
        }
        new C7878b(context, jSONObject2, this.dSP).show();
        return true;
    }

    public final void destroy() {
        if (this.dSN != null) {
            C1495b bVar = this.dSN;
            if (bVar == null) {
                C9649c.aVp();
            }
            bVar.dispose();
        }
    }
}
