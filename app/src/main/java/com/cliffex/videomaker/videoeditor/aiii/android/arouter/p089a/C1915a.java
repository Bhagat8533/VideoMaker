package com.aiii.android.arouter.p089a;

import java.util.TreeMap;

/* renamed from: com.aiii.android.arouter.a.a */
public class C1915a<K, V> extends TreeMap<K, V> {
    private String asN;

    public C1915a(String str) {
        this.asN = str;
    }

    public V put(K k, V v) {
        if (!containsKey(k)) {
            return super.put(k, v);
        }
        throw new RuntimeException(String.format(this.asN, new Object[]{k}));
    }
}
