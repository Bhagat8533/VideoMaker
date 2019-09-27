package com.introvd.template.module.iap.business.p349a;

import android.text.TextUtils;
import com.introvd.template.module.iap.utils.C8081e;
import com.introvd.template.vivaiap.base.p417a.C9023a;

/* renamed from: com.introvd.template.module.iap.business.a.c */
public class C7832c extends C9023a {
    private String dQb;
    private String dRK;
    private String dRQ;
    private String dRR;
    private long dRS;
    private String dRT;
    private long dRU;
    private int dRV;
    protected String dRW;
    protected long dRX;
    protected String dRY;
    protected String description;
    private String label;
    private int order;
    protected String price;

    public C7832c(String str) {
        super(str);
    }

    public long aCA() {
        return this.dRU;
    }

    public String aCB() {
        return this.dQb;
    }

    public long aCC() {
        return this.dRS;
    }

    public String aCD() {
        return this.dRT;
    }

    public long aCE() {
        return this.dRX;
    }

    public String aCF() {
        return this.dRY;
    }

    public boolean aCy() {
        return !TextUtils.isEmpty(this.dRQ);
    }

    public int aCz() {
        return C8081e.m23450lW(this.dRQ);
    }

    /* renamed from: aM */
    public void mo32738aM(long j) {
        this.dRU = j;
    }

    /* renamed from: aN */
    public void mo32739aN(long j) {
        this.dRS = j;
    }

    /* renamed from: aO */
    public void mo32740aO(long j) {
        this.dRX = j;
    }

    public String getCurrencyCode() {
        return this.dRW;
    }

    public String getDescription() {
        return this.description;
    }

    public String getLabel() {
        return this.label;
    }

    public int getOrder() {
        return this.order;
    }

    /* renamed from: lf */
    public void mo32745lf(String str) {
        this.dRK = str;
    }

    /* renamed from: lg */
    public void mo32746lg(String str) {
        this.dRQ = str;
    }

    /* renamed from: lh */
    public void mo32747lh(String str) {
        this.dRR = str;
    }

    /* renamed from: li */
    public void mo32748li(String str) {
        this.dQb = str;
    }

    /* renamed from: lj */
    public void mo32749lj(String str) {
        this.label = str;
    }

    /* renamed from: lk */
    public void mo32750lk(String str) {
        this.dRT = str;
    }

    /* renamed from: ll */
    public void mo32751ll(String str) {
        this.dRW = str;
    }

    /* renamed from: lm */
    public void mo32752lm(String str) {
        this.price = str;
    }

    /* renamed from: ln */
    public void mo32753ln(String str) {
        this.dRY = str;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setOrder(int i) {
        this.order = i;
    }

    /* renamed from: sp */
    public String mo32756sp() {
        return this.price;
    }

    /* renamed from: ss */
    public String mo32757ss() {
        return this.dRR;
    }

    /* renamed from: su */
    public void mo32758su(int i) {
        this.dRV = i;
    }
}
