package com.introvd.template.module.iap.p341b.p345d;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.introvd.template.module.iap.C8048e;
import com.introvd.template.module.iap.C8072q;
import com.introvd.template.module.iap.business.p349a.C7827b;
import com.introvd.template.module.iap.business.p349a.p351b.C7829b;
import com.introvd.template.module.iap.business.p352b.C7835b;
import com.introvd.template.module.iap.p340a.C7712d;
import com.introvd.template.module.iap.p341b.C7738c;
import com.introvd.template.router.iap.IapServiceProxy;
import com.introvd.template.router.user.UserServiceProxy;
import com.introvd.template.router.user.model.LoginUserInfo;
import com.introvd.template.vivaiap.coffer.C9036d;
import com.introvd.template.vivaiap.coffer.C9037e;
import com.introvd.template.vivaiap.coffer.C9038f;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import p037b.p050b.C1848s;
import p037b.p050b.C1850u;
import p037b.p050b.C1852w;
import p037b.p050b.p057e.C1518f;
import p037b.p050b.p073g.C1810c;
import p469f.C9768m;

/* renamed from: com.introvd.template.module.iap.b.d.h */
public class C7786h implements C9037e<C7827b> {
    /* access modifiers changed from: private */
    public long dVG = System.currentTimeMillis();

    public static void aEP() {
        C7829b bVar;
        if (C8048e.aBe().isInChina()) {
            LoginUserInfo userInfo = UserServiceProxy.getUserInfo();
            if (userInfo != null && !TextUtils.isEmpty(userInfo.androidVipInfo)) {
                try {
                    bVar = (C7829b) new Gson().fromJson(userInfo.androidVipInfo, C7829b.class);
                } catch (JsonSyntaxException unused) {
                    bVar = null;
                }
                if (bVar != null && !TextUtils.isEmpty(bVar.aCH()) && !C7738c.aEv().aNy().mo35906rh(bVar.aCH())) {
                    C7827b bVar2 = new C7827b(bVar.aCH(), true);
                    bVar2.mo32703ld(bVar.aCK());
                    bVar2.mo32700aL(System.currentTimeMillis());
                    C7738c.aEv().aNx().clear();
                    C7738c.aEv().aNx().mo35908a(bVar2);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: cw */
    public void m22744cw(List<C7827b> list) {
        String str = "result is empty.";
        if (list != null) {
            str = list.toString();
        }
        m22746lO(str);
    }

    /* access modifiers changed from: private */
    /* renamed from: cx */
    public void m22745cx(List<C7829b> list) {
        if (C8048e.aBe().isInChina()) {
            LoginUserInfo userInfo = UserServiceProxy.getUserInfo();
            if (userInfo != null && list != null && !list.isEmpty()) {
                C7829b bVar = null;
                Iterator it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    C7829b bVar2 = (C7829b) it.next();
                    if (bVar2 != null && bVar2.isValid()) {
                        bVar = bVar2;
                        break;
                    }
                }
                if (bVar != null) {
                    userInfo.androidVipInfo = new Gson().toJson((Object) bVar);
                    UserServiceProxy.saveLoginUserInfo(userInfo);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: lO */
    public void m22746lO(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("purchaseList", str);
        hashMap.put("country", C8048e.aBe().getCountryCode());
        hashMap.put("canPurchase", String.valueOf(!C7738c.aEv().aNw().isEmpty()));
        StringBuilder sb = new StringBuilder();
        sb.append(UserServiceProxy.getUserId());
        sb.append("");
        hashMap.put("auid", sb.toString());
        hashMap.put(IapServiceProxy.isVip, String.valueOf(C8072q.aBx().isVip()));
        C8048e.aBe().mo23653g("Dev_Event_Iap_User_Purchase_List_Domestic", hashMap);
    }

    /* renamed from: a */
    public void mo32603a(final C9036d<C7827b> dVar) {
        if (!C8048e.aBe().mo23626Mr()) {
            C7835b.aCP();
            return;
        }
        if (C7835b.aCO()) {
            String str = UserServiceProxy.isLogin() ? "isLogin" : "not login";
            String str2 = TextUtils.isEmpty(UserServiceProxy.getUserId()) ? "null" : "not null";
            HashMap hashMap = new HashMap();
            hashMap.put("loginStatus", str);
            hashMap.put("userInfoIdStatus", str2);
            C8048e.aBe().mo23653g("dev_event_iap_user_login_status", hashMap);
            C7835b.m22858iI(false);
        }
        C1848s.m5326ai(Boolean.valueOf(true)).mo10200k(500, TimeUnit.MILLISECONDS).mo10199i(new C1518f<Boolean, String>() {
            /* renamed from: w */
            public String apply(Boolean bool) throws Exception {
                String userId = UserServiceProxy.getUserId();
                if (!TextUtils.isEmpty(userId)) {
                    return userId;
                }
                throw new IllegalStateException("User id is null.");
            }
        }).mo10192bU(4).mo10198h(new C1518f<String, C1852w<C9768m<List<C7829b>>>>() {
            /* renamed from: lP */
            public C1852w<C9768m<List<C7829b>>> apply(String str) throws Exception {
                return C7712d.m22622kG(str);
            }
        }).mo10199i(new C1518f<C9768m<List<C7829b>>, List<C7829b>>() {
            /* renamed from: a */
            public List<C7829b> apply(C9768m<List<C7829b>> mVar) throws Exception {
                Date ta = mVar.aWY().mo38144ta("Date");
                if (ta == null) {
                    C7786h.this.dVG = System.currentTimeMillis();
                } else {
                    C7786h.this.dVG = ta.getTime();
                }
                return (List) mVar.baI();
            }
        }).mo10188a((C1850u<? super T>) new C1810c<List<C7829b>>() {
            public void onError(Throwable th) {
                C7835b.aCR();
                List i = C7776e.m22723i(UserServiceProxy.getUserId(), C7786h.this.dVG);
                if (i == null || i.isEmpty()) {
                    dVar.mo35842c(new C9038f(false, th.getMessage()), null);
                    C7786h.this.m22746lO(th.getMessage());
                    return;
                }
                C9036d dVar = dVar;
                StringBuilder sb = new StringBuilder();
                sb.append("local cache success.Error is ");
                sb.append(th.getMessage());
                dVar.mo35842c(new C9038f(true, sb.toString()), i);
                C7786h.this.m22744cw(i);
            }

            public void onSuccess(List<C7829b> list) {
                C7786h.this.m22745cx(list);
                List a = C7761a.m22691a(C7786h.this.dVG, list);
                if (a == null || a.isEmpty()) {
                    List i = C7776e.m22723i(UserServiceProxy.getUserId(), C7786h.this.dVG);
                    a = i != null ? new ArrayList(i) : new ArrayList();
                } else {
                    C7776e.m22721a(UserServiceProxy.getUserId(), C7786h.this.dVG, a);
                }
                dVar.mo35842c(new C9038f(true, "success"), a);
                C7786h.this.m22744cw(a);
                C7835b.aCR();
            }
        });
    }
}
