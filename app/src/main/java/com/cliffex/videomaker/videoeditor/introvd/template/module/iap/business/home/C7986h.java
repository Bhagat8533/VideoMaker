package com.introvd.template.module.iap.business.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.p021v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import com.introvd.template.module.iap.C8048e;
import com.introvd.template.module.iap.C8049f;
import com.introvd.template.module.iap.C8061k;
import com.introvd.template.module.iap.C8072q;
import com.introvd.template.module.iap.R;
import com.introvd.template.module.iap.business.p349a.C7825a;
import com.introvd.template.module.iap.business.p349a.C7832c;
import com.introvd.template.module.iap.business.p352b.C7835b;
import com.introvd.template.module.iap.business.p356e.C7897a;
import com.introvd.template.module.iap.p341b.C7738c;
import com.introvd.template.module.iap.p341b.p343b.C7733a;
import com.introvd.template.module.iap.p341b.p343b.C7734b;
import com.introvd.template.module.iap.p341b.p343b.C7735c;
import com.introvd.template.module.iap.p341b.p343b.C7736d;
import com.introvd.template.router.AdRouter.VipHomeParams;
import com.introvd.template.router.kiwi.LDPProtect;
import com.introvd.template.router.user.UserServiceProxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.greenrobot.eventbus.C10021c;
import org.greenrobot.eventbus.C10031j;
import org.greenrobot.eventbus.ThreadMode;

@LDPProtect
/* renamed from: com.introvd.template.module.iap.business.home.h */
class C7986h {
    private boolean bBv;
    /* access modifiers changed from: private */
    public C7988a dTI;
    private boolean dTJ;
    private boolean dTK = false;

    /* renamed from: com.introvd.template.module.iap.business.home.h$a */
    interface C7988a {
        /* renamed from: E */
        void mo32913E(boolean z, boolean z2);

        void aDC();

        Bundle getArguments();

        Context getContext();

        String getString(int i, Object... objArr);

        View getView();

        boolean isDetached();

        /* renamed from: sD */
        void mo32915sD(int i);
    }

    C7986h(C7988a aVar) {
        this.dTI = aVar;
        C10021c.aZH().mo38494ax(this);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: PA */
    public void mo32975PA() {
        this.dTJ = true;
        this.bBv = true ^ TextUtils.isEmpty(UserServiceProxy.getUserId());
        C7897a.aDf();
        C8049f.aBf().restoreGoodsAndPurchaseInfo();
    }

    /* access modifiers changed from: 0000 */
    public boolean aDA() {
        return this.dTJ;
    }

    /* access modifiers changed from: 0000 */
    public String aDB() {
        boolean z = true;
        if (C8072q.aBx().mo33070i(C7825a.PLATINUM_MONTHLY.getId(), C7825a.PLATINUM_YEARLY.getId())) {
            return this.dTI.getString(R.string.xiaoying_str_vip_member_subscription, new Object[0]);
        }
        Iterator it = C7738c.aEv().aNx().aNG().iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            String kC = C8061k.m23408kC((String) it.next());
            if (!kC.equals(C7825a.GOLD_YEARLY.getId())) {
                if (kC.equals(C7825a.GOLD_MONTHLY.getId())) {
                    break;
                }
            } else {
                break;
            }
        }
        if (z) {
            return this.dTI.getString(R.string.xiaoying_str_vip_gold_member_subscription, new Object[0]);
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    public void aDz() {
        C79871 r0 = new AccessibilityDelegate() {
            public void sendAccessibilityEvent(View view, int i) {
                super.sendAccessibilityEvent(view, i);
                if (view != null && 1 == i) {
                    if (view.getId() == R.id.vip_home_service_text) {
                        boolean isVip = C8072q.aBx().isVip();
                        HashMap hashMap = new HashMap();
                        hashMap.put("isVIP", String.valueOf(isVip ? 1 : 0));
                        C8048e.aBe().mo23653g("Subscription_terms_icon_click_Android", hashMap);
                    } else if (view.getId() == R.id.vip_home_close) {
                        C7835b.m22868u(C7986h.this.dTI.getArguments().getString(VipHomeParams.VIP_HOME_PACKAGE_TYPE), C8049f.aBf().mo33077EO());
                    }
                }
            }
        };
        this.dTI.getView().findViewById(R.id.vip_home_service_text).setAccessibilityDelegate(r0);
        this.dTI.getView().findViewById(R.id.vip_home_close).setAccessibilityDelegate(r0);
    }

    /* access modifiers changed from: 0000 */
    public List<C7832c> getItems() {
        C7832c cVar;
        C7985g gVar = new C7985g(this.dTI.getArguments().getString(VipHomeParams.VIP_HOME_INIT_GOODS_ID));
        ArrayList arrayList = new ArrayList();
        C7832c cVar2 = (C7832c) C7738c.aEv().aNw().mo35913ri(gVar.aDx());
        C7832c cVar3 = (C7832c) C7738c.aEv().aNw().mo35913ri(gVar.aDy());
        if (cVar2 != null) {
            if (cVar2.aCy()) {
                cVar2.setName(this.dTI.getString(R.string.xiaoying_str_vip_subscribe, new Object[0]));
                cVar2.mo32748li(null);
                cVar2.mo32752lm(null);
                cVar = cVar2;
            } else {
                cVar2.setName(this.dTI.getString(R.string.iap_vip_month, new Object[0]));
                cVar2.mo32749lj(this.dTI.getString(R.string.xiaoying_str_vip_home_purchase_month, gVar.aDt()));
                cVar2.mo32748li(gVar.aDv());
                cVar = null;
            }
            arrayList.add(cVar2);
        } else {
            cVar = null;
        }
        if (cVar3 != null) {
            if (cVar3.aCy()) {
                cVar3.setName(this.dTI.getString(R.string.xiaoying_str_vip_subscribe, new Object[0]));
                cVar3.mo32748li(null);
                cVar3.mo32752lm(null);
                cVar = cVar3;
            } else {
                cVar3.setName(this.dTI.getString(R.string.xiaoying_str_vip_home_twelve_months, new Object[0]));
                cVar3.mo32749lj(this.dTI.getString(R.string.xiaoying_str_vip_home_purchase_month, gVar.aDu()));
                cVar3.mo32748li(gVar.aDw());
            }
            arrayList.add(cVar3);
        }
        arrayList.remove(cVar);
        arrayList.add(0, cVar);
        arrayList.remove(null);
        return arrayList;
    }

    /* access modifiers changed from: 0000 */
    public void onDestroy() {
        C10021c.aZH().mo38496az(this);
    }

    @C10031j(aZK = ThreadMode.MAIN)
    public void onGoodsReload(C7733a aVar) {
        if (!this.dTI.isDetached()) {
            this.dTI.aDC();
        }
    }

    @C10031j(aZK = ThreadMode.MAIN)
    public void onGoogleConnection(C7734b bVar) {
        if (bVar != null) {
            if (!this.dTI.isDetached()) {
                this.dTI.mo32913E(bVar.isConnecting(), bVar.isSuccess());
            }
            if (bVar.isSuccess() && this.dTK) {
                this.dTK = false;
                C7738c.aEv().aNu().aNs();
            }
        }
    }

    @C10031j(aZK = ThreadMode.MAIN)
    public void onPurchaseReload(C7735c cVar) {
        if (cVar != null && !this.dTI.isDetached() && C8049f.aBf().mo33077EO()) {
            int responseCode = cVar.getResponseCode();
            this.dTI.mo32915sD(responseCode);
            if (this.dTJ) {
                boolean isVip = C8072q.aBx().isVip();
                C7835b.m22844a("purchase page", isVip, responseCode);
                if (this.bBv) {
                    C7835b.m22852b("purchase page", isVip, responseCode);
                }
                this.dTJ = false;
                Intent intent = new Intent();
                intent.setAction(C8048e.aBe().mo23625Mq());
                LocalBroadcastManager.getInstance(this.dTI.getContext().getApplicationContext()).sendBroadcast(intent);
            }
        }
    }

    @C10031j(aZK = ThreadMode.MAIN)
    public void onPurchaseRequesterFail(C7736d dVar) {
        if (dVar != null && !dVar.success) {
            this.dTK = dVar.code == -101;
        }
    }
}
