package com.introvd.template.module.p326ad.p334h.p335a;

/* renamed from: com.introvd.template.module.ad.h.a.a */
public class C7655a {
    private final String dNw;
    private final long dNx;
    private final int dNy;
    private final int dNz;

    public C7655a(String str, int i, int i2) {
        this(str, System.currentTimeMillis(), i, i2);
    }

    public C7655a(String str, long j, int i, int i2) {
        this.dNw = str;
        this.dNx = j;
        this.dNy = i;
        this.dNz = i2;
    }

    public String aAB() {
        return this.dNw;
    }

    public long aAC() {
        return this.dNx;
    }

    public int aAD() {
        return this.dNy;
    }

    public int aAE() {
        return this.dNz;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("EncourageResourceRecord{resId='");
        sb.append(this.dNw);
        sb.append('\'');
        sb.append(", unlockTime=");
        sb.append(this.dNx);
        sb.append(", validDuration=");
        sb.append(this.dNy);
        sb.append(", encourageType=");
        sb.append(this.dNz);
        sb.append('}');
        return sb.toString();
    }
}
