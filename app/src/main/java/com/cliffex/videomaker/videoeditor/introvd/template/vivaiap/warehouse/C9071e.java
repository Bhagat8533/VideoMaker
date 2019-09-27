package com.introvd.template.vivaiap.warehouse;

import com.introvd.template.vivaiap.base.p417a.C9023a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.introvd.template.vivaiap.warehouse.e */
class C9071e<T extends C9023a> implements C9070d<T> {
    private final Map<String, T> eBr = new HashMap();
    private final C9069c<T> eBs;

    C9071e(C9069c<T> cVar) {
        this.eBs = cVar;
    }

    /* renamed from: a */
    public void mo35908a(T t) {
        if (t != null) {
            this.eBr.put(t.getId(), t);
            this.eBs.mo35907b(1, t);
        }
    }

    public List<String> aNG() {
        return new ArrayList(this.eBr.keySet());
    }

    public void clear() {
        this.eBr.clear();
    }

    /* renamed from: dg */
    public void mo35911dg(List<T> list) {
        if (list != null && !list.isEmpty()) {
            for (T a : list) {
                mo35908a(a);
            }
        }
    }

    public boolean isEmpty() {
        return this.eBr.isEmpty();
    }

    /* renamed from: ri */
    public T mo35913ri(String str) {
        return (C9023a) this.eBr.get(str);
    }

    /* renamed from: wS */
    public List<T> mo35914wS() {
        return new ArrayList(this.eBr.values());
    }
}
