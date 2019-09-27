package com.introvd.template.camera.p233ui.facial;

/* renamed from: com.introvd.template.camera.ui.facial.d */
public class C5139d {
    private Boolean bVG;
    private Boolean bVH;

    /* renamed from: com.introvd.template.camera.ui.facial.d$a */
    public static class C5140a {
        /* access modifiers changed from: private */
        public Boolean bVG;
        /* access modifiers changed from: private */
        public Boolean bVH;

        /* renamed from: XG */
        public C5139d mo26043XG() {
            return new C5139d(this);
        }

        /* renamed from: o */
        public C5140a mo26044o(Boolean bool) {
            this.bVH = bool;
            return this;
        }

        /* renamed from: p */
        public C5140a mo26045p(Boolean bool) {
            this.bVG = bool;
            return this;
        }
    }

    public C5139d(C5140a aVar) {
        this.bVG = aVar.bVG;
        this.bVH = aVar.bVH;
    }

    /* renamed from: XE */
    public Boolean mo26041XE() {
        return this.bVH;
    }

    /* renamed from: XF */
    public Boolean mo26042XF() {
        return this.bVG;
    }
}
