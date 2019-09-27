package com.introvd.template.editor.preview.adapter;

import android.graphics.Bitmap;

/* renamed from: com.introvd.template.editor.preview.adapter.b */
public class C6530b {
    private Integer cZR;
    private Bitmap cZS;
    private Boolean cZT;
    private Boolean cZU;
    private Boolean cZV;
    private Boolean cZW;

    /* renamed from: com.introvd.template.editor.preview.adapter.b$a */
    public static class C6531a {
        /* access modifiers changed from: private */
        public Integer cZR;
        /* access modifiers changed from: private */
        public Bitmap cZS;
        /* access modifiers changed from: private */
        public Boolean cZT;
        /* access modifiers changed from: private */
        public Boolean cZU;
        /* access modifiers changed from: private */
        public Boolean cZV;
        /* access modifiers changed from: private */
        public Boolean cZW;

        public C6530b aoZ() {
            return new C6530b(this);
        }

        /* renamed from: k */
        public C6531a mo29807k(Integer num) {
            this.cZR = num;
            return this;
        }

        /* renamed from: s */
        public C6531a mo29808s(Boolean bool) {
            this.cZW = bool;
            return this;
        }

        /* renamed from: t */
        public C6531a mo29809t(Boolean bool) {
            this.cZT = bool;
            return this;
        }

        /* renamed from: u */
        public C6531a mo29810u(Boolean bool) {
            this.cZU = bool;
            return this;
        }

        /* renamed from: v */
        public C6531a mo29811v(Boolean bool) {
            this.cZV = bool;
            return this;
        }
    }

    public C6530b() {
    }

    public C6530b(C6531a aVar) {
        this.cZR = aVar.cZR;
        this.cZS = aVar.cZS;
        this.cZT = aVar.cZT;
        this.cZU = aVar.cZU;
        this.cZV = aVar.cZV;
        this.cZW = aVar.cZW;
    }

    public Boolean aoT() {
        return this.cZW;
    }

    public Integer aoU() {
        return this.cZR;
    }

    public Bitmap aoV() {
        return this.cZS;
    }

    public Boolean aoW() {
        return this.cZT;
    }

    public Boolean aoX() {
        return this.cZU;
    }

    public Boolean aoY() {
        return this.cZV;
    }
}
