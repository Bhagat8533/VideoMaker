package com.introvd.template.module.iap.p341b;

import android.text.TextUtils;
import com.introvd.template.module.iap.C8048e;
import com.introvd.template.module.iap.C8061k;
import com.introvd.template.module.iap.business.p349a.C7825a;
import com.introvd.template.module.iap.business.p349a.C7827b;
import com.introvd.template.router.kiwi.LDPProtect;
import com.introvd.template.vivaiap.warehouse.C9067a;
import com.introvd.template.vivaiap.warehouse.C9070d;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@LDPProtect
/* renamed from: com.introvd.template.module.iap.b.b */
public class C7732b implements C9067a<C7827b> {
    private static Map<String, List<String>> dVb = new HashMap();
    private static Map<String, List<String>> dVc = new HashMap();

    static {
        aEt();
        aEu();
    }

    /* renamed from: a */
    private static List<String> m22643a(String str, Map<String, List<String>> map) {
        ArrayList arrayList;
        if (map.containsKey(str)) {
            List list = (List) map.get(str);
            if (list == null) {
                return Collections.emptyList();
            }
            arrayList = new ArrayList(list);
        } else {
            arrayList = null;
        }
        return arrayList;
    }

    private static void aEt() {
        List singletonList = Collections.singletonList(C7825a.ALL.getId());
        dVb.put(C7825a.AD.getId(), singletonList);
        dVb.put(C7825a.DURATION_LIMIT.getId(), singletonList);
        dVb.put(C7825a.WATER_MARK.getId(), singletonList);
        List singletonList2 = Collections.singletonList(C7825a.PREMIUM_PACK.getId());
        dVb.put(C7825a.ALL.getId(), singletonList2);
        dVb.put(C7825a.HD.getId(), singletonList2);
        List singletonList3 = Collections.singletonList(C7825a.PLATINUM_PREMIUM_PACK.getId());
        dVb.put(C7825a.PREMIUM_PACK.getId(), singletonList3);
        dVb.put(C7825a.ALL_TEMPLATE.getId(), singletonList3);
        dVb.put(C7825a.ANIM_TITLE.getId(), singletonList3);
        dVb.put(C7825a.MOSAIC.getId(), singletonList3);
        dVb.put(C7825a.USER_WATER_MARK.getId(), singletonList3);
        dVb.put(C7825a.MAGIC_SOUND.getId(), singletonList3);
        dVb.put(C7825a.KEY_FRAME.getId(), singletonList3);
        dVb.put(C7825a.AUDIO_EXTRA.getId(), singletonList3);
        dVb.put(C7825a.VIDEO_PARAM_ADJUST.getId(), singletonList3);
        dVb.put(C7825a.CUSTOMIZED_BACKGROUND.getId(), singletonList3);
        dVb.put(C7825a.PREMIUM_PACK.getId(), Arrays.asList(new String[]{C7825a.GOLD_MONTHLY.getId(), C7825a.GOLD_YEARLY.getId(), C7825a.PLATINUM_PREMIUM_PACK.getId()}));
        dVb.put(C7825a.PLATINUM_PREMIUM_PACK.getId(), Arrays.asList(new String[]{C7825a.PLATINUM_YEARLY.getId(), C7825a.PLATINUM_MONTHLY.getId(), C7825a.PLATINUM_WEEKLY.getId()}));
    }

    private static void aEu() {
        dVc.put(C7825a.PLATINUM_PREMIUM_PACK.getId(), Arrays.asList(new String[]{C7825a.PREMIUM_PACK.getId(), C7825a.ALL_TEMPLATE.getId(), C7825a.ANIM_TITLE.getId(), C7825a.VIDEO_PARAM_ADJUST.getId(), C7825a.CUSTOMIZED_BACKGROUND.getId(), C7825a.MOSAIC.getId(), C7825a.USER_WATER_MARK.getId(), C7825a.MAGIC_SOUND.getId(), C7825a.KEY_FRAME.getId(), C7825a.AUDIO_EXTRA.getId()}));
        dVc.put(C7825a.PREMIUM_PACK.getId(), Arrays.asList(new String[]{C7825a.ALL.getId(), C7825a.HD.getId()}));
        dVc.put(C7825a.ALL.getId(), Arrays.asList(new String[]{C7825a.AD.getId(), C7825a.DURATION_LIMIT.getId(), C7825a.WATER_MARK.getId()}));
    }

    /* renamed from: b */
    private boolean m22644b(C9070d<C7827b> dVar, String str) {
        boolean z = false;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.add(str);
        while (!arrayDeque.isEmpty()) {
            String str2 = (String) arrayDeque.poll();
            z = m22646d(dVar, str2);
            if (z) {
                break;
            }
            List lH = m22649lH(str2);
            if (lH != null && !lH.isEmpty()) {
                arrayDeque.addAll(lH);
            }
        }
        return z;
    }

    /* renamed from: c */
    private boolean m22645c(C9070d<C7827b> dVar, String str) {
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.add(str);
        boolean z = true;
        while (!arrayDeque.isEmpty()) {
            String str2 = (String) arrayDeque.poll();
            boolean d = m22646d(dVar, str2);
            if (!d) {
                return d;
            }
            List lG = m22648lG(str2);
            if (lG != null && !lG.isEmpty()) {
                arrayDeque.addAll(lG);
            }
            z = d;
        }
        return z;
    }

    /* renamed from: d */
    private boolean m22646d(C9070d<C7827b> dVar, String str) {
        C7827b bVar = (C7827b) dVar.mo35913ri(str);
        if (bVar != null && bVar.isValid()) {
            return true;
        }
        boolean kD = C8061k.m23409kD(str);
        if (!kD) {
            str = C8061k.m23408kC(str);
            kD = C8061k.m23409kD(str);
        }
        boolean z = false;
        if (kD) {
            z = C8061k.m23410kE(str);
        }
        return z;
    }

    /* renamed from: kx */
    private boolean m22647kx(String str) {
        return !TextUtils.isEmpty(str) && str.contains("iap.template.");
    }

    /* renamed from: lG */
    private List<String> m22648lG(String str) {
        return m22643a(str, dVc);
    }

    /* renamed from: lH */
    private List<String> m22649lH(String str) {
        return m22643a(str, dVb);
    }

    /* renamed from: a */
    public boolean mo32604a(C9070d<C7827b> dVar, String str) {
        boolean z = false;
        if (dVar == null) {
            C8048e.aBe().logException(new IllegalStateException("ProviderRes had been null when appraise."));
            return false;
        }
        if (m22647kx(str)) {
            str = C7825a.ALL_TEMPLATE.getId();
        }
        boolean b = m22644b(dVar, str);
        boolean c = m22645c(dVar, str);
        if (b || c) {
            z = true;
        }
        return z;
    }
}
