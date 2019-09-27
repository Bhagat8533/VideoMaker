package com.introvd.template.module.iap.business.home.p359b;

/* renamed from: com.introvd.template.module.iap.business.home.b.a */
public class C7970a {
    int dTZ;
    int dUa;
    int dUb;
    String dUc;
    String dUd;
    String goodsId;
    boolean isNew;

    public C7970a(int i, int i2, String str, String str2) {
        this.dUa = 0;
        this.dTZ = i;
        this.goodsId = str;
        this.dUb = i2;
        this.dUc = str2;
    }

    public C7970a(int i, String str, String str2) {
        this(0, i, str, str2);
    }

    public C7970a(int i, String str, String str2, String str3) {
        this.dUa = 0;
        this.goodsId = str;
        this.dTZ = i;
        this.dUc = str2;
        this.dUd = str3;
    }

    public String aCH() {
        return this.goodsId;
    }

    public int aDM() {
        return this.dUa;
    }

    public int aDN() {
        return this.dTZ;
    }

    public String aDO() {
        return this.dUc;
    }

    public boolean aDP() {
        return this.isNew;
    }

    /* renamed from: iM */
    public void mo32945iM(boolean z) {
        this.isNew = z;
    }

    /* renamed from: sG */
    public void mo32946sG(int i) {
        this.dUa = i;
    }

    /* renamed from: sH */
    public void mo32947sH(int i) {
        this.dUb = i;
    }

    /* renamed from: sI */
    public void mo32948sI(int i) {
        this.dTZ = i;
    }
}
