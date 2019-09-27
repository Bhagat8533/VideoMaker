package com.introvd.template.template.info.item;

import java.io.Serializable;

/* renamed from: com.introvd.template.template.info.item.j */
public class C8909j implements Serializable {
    private static final long serialVersionUID = -4681590007832778410L;
    public String esm;
    public int esn;
    public int groupIndex;
    public int nState;
    public String strIcon;
    public String strIntro;
    public String strScene;
    public String strTitle;
    public String strUrl;
    public String tcid;
    public String ttid;

    /* renamed from: com.introvd.template.template.info.item.j$a */
    public static final class C8911a {
        /* access modifiers changed from: private */
        public String esm;
        /* access modifiers changed from: private */
        public int esn = -1;
        /* access modifiers changed from: private */
        public int groupIndex;
        /* access modifiers changed from: private */
        public int nState = 1;
        /* access modifiers changed from: private */
        public String strIcon;
        /* access modifiers changed from: private */
        public String strIntro;
        /* access modifiers changed from: private */
        public String strScene;
        /* access modifiers changed from: private */
        public String strTitle;
        /* access modifiers changed from: private */
        public String strUrl;
        /* access modifiers changed from: private */
        public String tcid;
        /* access modifiers changed from: private */
        public String ttid;

        public C8909j aLR() {
            return new C8909j(this);
        }

        /* renamed from: pS */
        public C8911a mo35462pS(String str) {
            this.tcid = str;
            return this;
        }

        /* renamed from: pT */
        public C8911a mo35463pT(String str) {
            this.ttid = str;
            return this;
        }

        /* renamed from: pU */
        public C8911a mo35464pU(String str) {
            this.strTitle = str;
            return this;
        }

        /* renamed from: pV */
        public C8911a mo35465pV(String str) {
            this.strIntro = str;
            return this;
        }

        /* renamed from: pW */
        public C8911a mo35466pW(String str) {
            this.strIcon = str;
            return this;
        }

        /* renamed from: pX */
        public C8911a mo35467pX(String str) {
            this.esm = str;
            return this;
        }

        /* renamed from: pY */
        public C8911a mo35468pY(String str) {
            this.strScene = str;
            return this;
        }

        /* renamed from: uZ */
        public C8911a mo35469uZ(int i) {
            this.esn = i;
            return this;
        }

        /* renamed from: va */
        public C8911a mo35470va(int i) {
            this.nState = i;
            return this;
        }

        /* renamed from: vb */
        public C8911a mo35471vb(int i) {
            this.groupIndex = i;
            return this;
        }
    }

    private C8909j(C8911a aVar) {
        this.nState = 1;
        this.tcid = aVar.tcid;
        this.ttid = aVar.ttid;
        this.strTitle = aVar.strTitle;
        this.strIntro = aVar.strIntro;
        this.strIcon = aVar.strIcon;
        this.esm = aVar.esm;
        this.strScene = aVar.strScene;
        this.strUrl = aVar.strUrl;
        this.nState = aVar.nState;
        this.esn = aVar.esn;
        this.groupIndex = aVar.groupIndex;
    }
}
