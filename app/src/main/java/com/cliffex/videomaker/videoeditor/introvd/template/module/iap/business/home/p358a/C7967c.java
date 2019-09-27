package com.introvd.template.module.iap.business.home.p358a;

/* renamed from: com.introvd.template.module.iap.business.home.a.c */
public class C7967c implements Comparable<C7967c> {
    public String dQa;
    public String dQb;
    public boolean dRZ;
    public String description;
    public String goodsId;
    public String label;
    public int order;
    public String title;

    /* renamed from: a */
    public int compareTo(C7967c cVar) {
        if (cVar == null) {
            return -1;
        }
        return this.order - cVar.order;
    }
}
