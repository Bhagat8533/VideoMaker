package com.introvd.template.module.iap;

import android.text.TextUtils;
import com.introvd.template.common.MD5;
import com.introvd.template.module.iap.business.p349a.C7825a;
import com.introvd.template.module.iap.business.p349a.C7827b;
import com.introvd.template.module.iap.business.p349a.C7832c;
import com.introvd.template.module.iap.p341b.C7738c;
import com.introvd.template.router.kiwi.LDPProtect;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@LDPProtect
/* renamed from: com.introvd.template.module.iap.d */
public class C8045d implements C8071p {
    private static Map<String, C7827b> dOq = new HashMap();

    /* renamed from: com.introvd.template.module.iap.d$a */
    private static class C8047a {
        static final C8045d dOr = new C8045d();
    }

    private C8045d() {
    }

    public static C8045d aAZ() {
        return C8047a.dOr;
    }

    /* renamed from: kx */
    private boolean m23266kx(String str) {
        return !TextUtils.isEmpty(str) && str.contains("iap.template.");
    }

    public C7827b aBa() {
        List aNG = C7738c.aEv().aNx().aNG();
        C7827b bVar = null;
        if (aNG == null || aNG.isEmpty()) {
            return null;
        }
        Iterator it = aNG.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            C7827b bVar2 = (C7827b) C7738c.aEv().aNx().mo35913ri((String) it.next());
            if (bVar2 != null && bVar2.isValid()) {
                bVar = bVar2;
                break;
            }
        }
        return bVar;
    }

    public List<String> aBb() {
        List<String> aNG = C7738c.aEv().aNx().aNG();
        if (aNG == null || aNG.isEmpty()) {
            return null;
        }
        boolean z = false;
        ArrayList arrayList = new ArrayList();
        for (String str : aNG) {
            if (!str.contains("gold") && !str.contains("platinium")) {
                if (m23266kx(str)) {
                    if (!z) {
                        z = true;
                        arrayList.add(C7825a.ALL_TEMPLATE.getId());
                    }
                } else if (C7825a.ALL.getId().equals(str) || C7825a.PREMIUM_PACK.getId().equals(str)) {
                    arrayList.add(C7825a.WATER_MARK.getId());
                    arrayList.add(C7825a.DURATION_LIMIT.getId());
                    arrayList.add(C7825a.AD.getId());
                    arrayList.add(C7825a.WATER_MARK.getId());
                    if (C7825a.PREMIUM_PACK.getId().equals(str)) {
                        arrayList.add(C7825a.HD.getId());
                    }
                } else if (C7825a.PLATINUM_PREMIUM_PACK.getId().equals(str)) {
                    arrayList.add(C7825a.WATER_MARK.getId());
                    arrayList.add(C7825a.HD.getId());
                    arrayList.add(C7825a.DURATION_LIMIT.getId());
                    arrayList.add(C7825a.HD_2k.getId());
                    arrayList.add(C7825a.HD_4k.getId());
                    arrayList.add(C7825a.AD.getId());
                    arrayList.add(C7825a.MOSAIC.getId());
                    arrayList.add(C7825a.KEY_FRAME.getId());
                    arrayList.add(C7825a.AUDIO_EXTRA.getId());
                    arrayList.add(C7825a.USER_WATER_MARK.getId());
                    arrayList.add(C7825a.VIDEO_PARAM_ADJUST.getId());
                    arrayList.add(C7825a.CUSTOMIZED_BACKGROUND.getId());
                    arrayList.add(C7825a.ALL_TEMPLATE.getId());
                    arrayList.add(C7825a.MAGIC_SOUND.getId());
                    arrayList.add(C7825a.ANIM_TITLE.getId());
                } else {
                    arrayList.add(str);
                }
            }
        }
        return arrayList;
    }

    public List<String> aBc() {
        ArrayList arrayList = new ArrayList();
        List<C7827b> aBd = aBd();
        if (aBd == null || aBd.isEmpty()) {
            return arrayList;
        }
        for (C7827b bVar : aBd) {
            if (bVar != null) {
                arrayList.add(MD5.md5(bVar.getToken()));
            }
        }
        return arrayList;
    }

    public List<C7827b> aBd() {
        return C7738c.aEv().aNx().mo35914wS();
    }

    /* renamed from: i */
    public boolean mo33070i(String... strArr) {
        if (strArr == null || strArr.length == 0) {
            return false;
        }
        boolean z = false;
        for (String ku : strArr) {
            z = mo33072ku(ku);
            if (z) {
                break;
            }
        }
        return z;
    }

    public boolean isVip() {
        return mo33070i(C7825a.PLATINUM_WEEKLY.getId(), C7825a.PLATINUM_MONTHLY.getId(), C7825a.PLATINUM_YEARLY.getId(), C7825a.PLATINUM_WEEKLY.getId());
    }

    /* renamed from: ku */
    public boolean mo33072ku(String str) {
        return C7738c.aEv().aNy().mo35906rh(str) || dOq.containsKey(str);
    }

    /* renamed from: kv */
    public boolean mo33073kv(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.contains("vip_subscription");
    }

    /* renamed from: kw */
    public C7832c mo33074kw(String str) {
        return (C7832c) C7738c.aEv().aNw().mo35913ri(str);
    }

    /* renamed from: ky */
    public void mo33075ky(String str) {
        if (!C7738c.aEv().aNy().mo35906rh(str)) {
            C7827b bVar = new C7827b(str);
            bVar.mo32704le("reward");
            C7738c.aEv().aNx().mo35908a(bVar);
            dOq.put(str, bVar);
        }
    }
}
