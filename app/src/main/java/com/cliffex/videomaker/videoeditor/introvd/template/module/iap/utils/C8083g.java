package com.introvd.template.module.iap.utils;

import android.text.TextUtils;
import android.util.SparseArray;
import com.introvd.template.apicore.C3635l;
import com.introvd.template.module.iap.C8048e;
import com.introvd.template.module.iap.business.p349a.p351b.C7831d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.introvd.template.module.iap.utils.g */
public class C8083g {
    /* access modifiers changed from: private */
    public static SparseArray<List<C7831d>> dWf;
    /* access modifiers changed from: private */
    public static Map<String, List<String>> dWg = new HashMap();

    static {
        init();
    }

    public static void init() {
        if (dWf == null) {
            C8048e.aBe().mo23639a(new C3635l<SparseArray<List<C7831d>>>() {
                /* renamed from: a */
                public void onSuccess(SparseArray<List<C7831d>> sparseArray) {
                    C8083g.dWg.clear();
                    C8083g.dWf = sparseArray;
                }
            });
        }
    }

    /* renamed from: mb */
    public static List<String> m23457mb(String str) {
        List<String> list = (List) dWg.get(str);
        if (list != null && !list.isEmpty()) {
            return list;
        }
        if (dWf == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i = -1;
        if ("alipay".equals(str)) {
            i = 1;
        } else if ("wx".equals(str)) {
            i = 2;
        }
        List<C7831d> list2 = (List) dWf.get(i);
        if (list2 == null || list2.isEmpty()) {
            return null;
        }
        for (C7831d dVar : list2) {
            if (dVar != null && !TextUtils.isEmpty(dVar.tag)) {
                arrayList.add(dVar.tag);
            }
        }
        dWg.put(str, arrayList);
        return arrayList;
    }
}
