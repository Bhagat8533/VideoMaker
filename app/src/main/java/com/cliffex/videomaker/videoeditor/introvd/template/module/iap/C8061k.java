package com.introvd.template.module.iap;

import android.text.TextUtils;
import com.introvd.template.module.iap.business.p349a.C7825a;
import com.introvd.template.module.iap.business.p349a.C7827b;
import com.introvd.template.module.iap.p341b.C7738c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.introvd.template.module.iap.k */
public final class C8061k {
    private static final C8062a dOQ = new C8062a(C7825a.GOLD_MONTHLY.getId(), C8060j.m23407kB(C7825a.GOLD_MONTHLY.getId()));
    private static final C8062a dOR = new C8062a(C7825a.GOLD_YEARLY.getId(), C8060j.m23407kB(C7825a.GOLD_YEARLY.getId()));
    private static final C8062a dOS = new C8062a(C7825a.PLATINUM_WEEKLY.getId(), C8060j.m23407kB(C7825a.PLATINUM_WEEKLY.getId()));
    private static final C8062a dOT = new C8062a(C7825a.PLATINUM_MONTHLY.getId(), C8060j.m23407kB(C7825a.PLATINUM_MONTHLY.getId()));
    private static final C8062a dOU = new C8062a(C7825a.PLATINUM_YEARLY.getId(), C8060j.m23407kB(C7825a.PLATINUM_YEARLY.getId()));
    private static final Map<String, C8062a> dOV = new HashMap();

    /* renamed from: com.introvd.template.module.iap.k$a */
    private static class C8062a {
        final List<String> dOW;
        final String groupId;

        C8062a(String str, List<String> list) {
            this.groupId = str;
            this.dOW = list;
        }

        /* access modifiers changed from: 0000 */
        public boolean aBt() {
            List<C7827b> wS = C7738c.aEv().aNx().mo35914wS();
            boolean z = false;
            if (wS == null || wS.isEmpty()) {
                return false;
            }
            for (C7827b bVar : wS) {
                if (bVar != null && bVar.isValid() && this.dOW.contains(bVar.getId())) {
                    z = bVar.aCv();
                    if (z) {
                        break;
                    }
                }
            }
            return z;
        }

        /* access modifiers changed from: 0000 */
        public boolean aBu() {
            List<C7827b> wS = C7738c.aEv().aNx().mo35914wS();
            boolean z = false;
            if (wS == null || wS.isEmpty()) {
                return false;
            }
            for (C7827b bVar : wS) {
                if (bVar != null && bVar.isValid()) {
                    z = this.dOW.contains(bVar.getId());
                    if (z) {
                        break;
                    }
                }
            }
            return z;
        }
    }

    static {
        dOV.put(dOQ.groupId, dOQ);
        dOV.put(dOR.groupId, dOR);
        dOV.put(dOS.groupId, dOS);
        dOV.put(dOT.groupId, dOT);
        dOV.put(dOU.groupId, dOU);
    }

    public static List<String> aBs() {
        List<String> aNG = C7738c.aEv().aNx().aNG();
        if (aNG == null || aNG.isEmpty()) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        for (String str : aNG) {
            if (!TextUtils.isEmpty(str)) {
                for (C8062a aVar : dOV.values()) {
                    if (aVar.dOW.contains(str)) {
                        arrayList.add(str);
                    }
                }
            }
        }
        return arrayList;
    }

    /* renamed from: kC */
    public static String m23408kC(String str) {
        String str2 = "";
        for (String str3 : dOV.keySet()) {
            C8062a aVar = (C8062a) dOV.get(str3);
            if (aVar != null && aVar.dOW.contains(str)) {
                return str3;
            }
        }
        return str2;
    }

    /* renamed from: kD */
    public static boolean m23409kD(String str) {
        return dOV.containsKey(str);
    }

    /* renamed from: kE */
    public static boolean m23410kE(String str) {
        C8062a aVar = (C8062a) dOV.get(str);
        return aVar != null && aVar.aBu();
    }

    /* renamed from: kF */
    public static boolean m23411kF(String str) {
        C8062a aVar = (C8062a) dOV.get(str);
        return aVar != null && aVar.aBt();
    }
}
