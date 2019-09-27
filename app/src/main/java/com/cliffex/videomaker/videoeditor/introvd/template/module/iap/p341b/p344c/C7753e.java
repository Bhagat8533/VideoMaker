package com.introvd.template.module.iap.p341b.p344c;

import com.diii.p142a.p143a.C2653a;
import com.diii.p142a.p143a.C2654b;
import com.introvd.template.module.iap.C8048e;
import com.introvd.template.module.iap.business.C7838c;
import com.introvd.template.module.iap.business.p349a.C7827b;
import com.introvd.template.module.iap.business.p349a.C7832c;
import com.introvd.template.module.iap.business.p352b.C7835b;
import com.introvd.template.module.iap.p341b.C7738c;
import com.introvd.template.module.iap.p361c.C8041b;
import com.introvd.template.module.iap.p361c.C8044c;
import com.introvd.template.module.iap.utils.C8080d;
import com.introvd.template.router.BizServiceManager;
import com.introvd.template.router.editor.IEditorService;
import com.introvd.template.vivaiap.coffer.C9036d;
import com.introvd.template.vivaiap.coffer.C9037e;
import com.introvd.template.vivaiap.coffer.C9038f;
import com.quvideo.plugin.payclient.google.C4867c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import p037b.p050b.C1834l;
import p037b.p050b.C1850u;
import p037b.p050b.p051a.p053b.C1487a;
import p037b.p050b.p054b.C1495b;
import p037b.p050b.p057e.C1517e;
import p037b.p050b.p057e.C1518f;
import p037b.p050b.p073g.C1810c;
import p037b.p050b.p076j.C1820a;

/* renamed from: com.introvd.template.module.iap.b.c.e */
public class C7753e implements C9037e<C7827b> {
    private C1495b cTc;

    /* JADX WARNING: Removed duplicated region for block: B:11:0x001f  */
    /* JADX WARNING: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String aEL() {
        /*
            r2 = this;
            r0 = 0
            com.introvd.template.module.iap.g r1 = com.introvd.template.module.iap.C8048e.aBe()     // Catch:{ IOException -> 0x0018, GooglePlayServicesNotAvailableException -> 0x0013, GooglePlayServicesRepairableException -> 0x000e }
            android.content.Context r1 = r1.getContext()     // Catch:{ IOException -> 0x0018, GooglePlayServicesNotAvailableException -> 0x0013, GooglePlayServicesRepairableException -> 0x000e }
            com.giii.aiii.biii.ads.identifier.AdvertisingIdClient$Info r1 = com.giii.aiii.biii.ads.identifier.AdvertisingIdClient.getAdvertisingIdInfo(r1)     // Catch:{ IOException -> 0x0018, GooglePlayServicesNotAvailableException -> 0x0013, GooglePlayServicesRepairableException -> 0x000e }
            goto L_0x001d
        L_0x000e:
            r1 = move-exception
            r1.printStackTrace()
            goto L_0x001c
        L_0x0013:
            r1 = move-exception
            r1.printStackTrace()
            goto L_0x001c
        L_0x0018:
            r1 = move-exception
            r1.printStackTrace()
        L_0x001c:
            r1 = r0
        L_0x001d:
            if (r1 == 0) goto L_0x0023
            java.lang.String r0 = r1.getId()
        L_0x0023:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.module.iap.p341b.p344c.C7753e.aEL():java.lang.String");
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m22678c(String str, Object obj) {
        HashMap hashMap = new HashMap();
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(";\n");
        sb.append(obj);
        hashMap.put("purchaseList", sb.toString());
        hashMap.put("country", C8048e.aBe().getCountryCode());
        hashMap.put("canPurchase", String.valueOf(C7738c.aEv().mo35851qZ("google")));
        C8048e.aBe().mo23653g("Dev_Event_Iap_User_Purchase_List_Abroad", hashMap);
    }

    /* access modifiers changed from: private */
    /* renamed from: cs */
    public List<C2653a> m22679cs(List<C2653a> list) {
        if (!C8048e.aBe().mo23626Mr()) {
            return new ArrayList();
        }
        if (list == null || list.isEmpty()) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        for (C2653a aVar : list) {
            if (aVar != null) {
                IEditorService iEditorService = (IEditorService) BizServiceManager.getService(IEditorService.class);
                String str = null;
                if (iEditorService != null) {
                    str = iEditorService.getGoogleKey();
                }
                if (C7759f.m22689r(str, aVar.mo13108sn(), aVar.mo13109so())) {
                    arrayList.add(aVar);
                }
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    /* renamed from: ct */
    public void m22680ct(List<C2653a> list) {
        if (list != null && !list.isEmpty()) {
            if (this.cTc != null && !this.cTc.aAy()) {
                this.cTc.dispose();
            }
            this.cTc = C1834l.m5257ah(list).mo10152c(C1820a.aVi()).mo10167f((C1518f<? super T, ? extends R>) new C1518f<List<C2653a>, List<C8044c>>() {
                public List<C8044c> apply(List<C2653a> list) throws Exception {
                    return C7753e.this.m22681cu(list);
                }
            }).mo10152c(C1487a.aUa()).mo10128a((C1517e<? super T>) new C1517e<List<C8044c>>() {
                /* renamed from: V */
                public void accept(List<C8044c> list) throws Exception {
                    if (!list.isEmpty()) {
                        C7753e.this.m22682d("updatePurchase", list);
                    }
                }
            }, (C1517e<? super Throwable>) new C1517e<Throwable>() {
                /* renamed from: m */
                public void accept(Throwable th) throws Exception {
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: cu */
    public List<C8044c> m22681cu(List<C2653a> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        String aEL = aEL();
        String Mz = C8048e.aBe().mo23634Mz();
        ArrayList arrayList = new ArrayList();
        for (C2653a aVar : list) {
            if (aVar != null) {
                C7832c cVar = (C7832c) C7738c.aEv().aNw().mo35913ri(aVar.mo13107sm());
                if (cVar != null) {
                    String valueOf = String.valueOf(cVar.aCE());
                    String currencyCode = cVar.getCurrencyCode();
                    C8044c cVar2 = new C8044c(aVar.mo13109so(), aVar.mo13108sn());
                    cVar2.dWr = valueOf;
                    cVar2.dRW = currencyCode;
                    cVar2.dWt = Mz;
                    cVar2.dWs = aEL;
                    arrayList.add(cVar2);
                }
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m22682d(final String str, List<C8044c> list) {
        if (list != null && !list.isEmpty()) {
            C8041b.m23263cy(list).mo10188a((C1850u<? super T>) new C1810c<List<String>>() {
                public void onError(Throwable th) {
                    C7835b.m22843a(th.getMessage(), (List<String>) new ArrayList<String>(), str);
                }

                public void onSuccess(List<String> list) {
                    C7835b.m22843a("success", list, str);
                }
            });
        }
    }

    /* renamed from: a */
    public void mo32603a(final C9036d<C7827b> dVar) {
        C4867c.m12480EP().mo25337a((C2654b) new C2654b() {
            /* renamed from: c */
            public void mo13111c(int i, List<C2653a> list) {
                Object lV = C8080d.m23449lV(C7838c.dPi);
                List a = C7753e.this.m22679cs(list);
                List cq = C7746b.m22663cq(a);
                dVar.mo35842c(new C9038f(i == 0, i, String.valueOf(i)), cq);
                C7753e.this.m22678c((a == null || a.isEmpty()) ? String.valueOf(i) : a.toString(), lV);
                if (!cq.isEmpty()) {
                    C8080d.m23448e(cq, C7838c.dPi);
                } else {
                    C8080d.deleteFile(C7838c.dPi);
                }
                C7753e.this.m22680ct(list);
                C8048e.aBe().mo23633My();
                C7835b.aCR();
            }
        });
    }
}
