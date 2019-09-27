package com.introvd.template.picker.p367c;

import java.io.Serializable;
import java.util.List;

/* renamed from: com.introvd.template.picker.c.a */
public class C8192a implements Serializable {
    private String albumId;
    private int childCount;
    private List<C8215c> dYp;
    private int dYq;
    private int dYr = 0;
    private boolean isVideo;
    private String thumbPath;
    private String title;

    /* renamed from: com.introvd.template.picker.c.a$a */
    public static class C8193a {
        /* access modifiers changed from: private */
        public String albumId;
        /* access modifiers changed from: private */
        public int childCount;
        /* access modifiers changed from: private */
        public List<C8215c> dYp;
        /* access modifiers changed from: private */
        public int dYq;
        /* access modifiers changed from: private */
        public int dYr = 0;
        /* access modifiers changed from: private */
        public boolean isVideo;
        /* access modifiers changed from: private */
        public String thumbPath;
        /* access modifiers changed from: private */
        public String title;

        public C8192a aFI() {
            return new C8192a(this);
        }

        /* renamed from: cE */
        public C8193a mo33317cE(List<C8215c> list) {
            this.dYp = list;
            return this;
        }

        /* renamed from: iT */
        public C8193a mo33318iT(boolean z) {
            this.isVideo = z;
            return this;
        }

        /* renamed from: mv */
        public C8193a mo33319mv(String str) {
            this.thumbPath = str;
            return this;
        }

        /* renamed from: mw */
        public C8193a mo33320mw(String str) {
            this.title = str;
            return this;
        }

        /* renamed from: mx */
        public C8193a mo33321mx(String str) {
            this.albumId = str;
            return this;
        }

        /* renamed from: tc */
        public C8193a mo33322tc(int i) {
            this.childCount = i;
            return this;
        }

        /* renamed from: td */
        public C8193a mo33323td(int i) {
            this.dYq = i;
            return this;
        }

        /* renamed from: te */
        public C8193a mo33324te(int i) {
            this.dYr = i;
            return this;
        }
    }

    public C8192a(C8193a aVar) {
        this.thumbPath = aVar.thumbPath;
        this.title = aVar.title;
        this.childCount = aVar.childCount;
        this.dYp = aVar.dYp;
        this.dYq = aVar.dYq;
        this.isVideo = aVar.isVideo;
        this.albumId = aVar.albumId;
        this.dYr = aVar.dYr;
    }

    public String aFD() {
        return this.thumbPath;
    }

    public List<C8215c> aFE() {
        return this.dYp;
    }

    public int aFF() {
        return this.dYq;
    }

    public boolean aFG() {
        return this.isVideo;
    }

    public int aFH() {
        return this.dYr;
    }

    public String getAlbumId() {
        return this.albumId;
    }

    public int getChildCount() {
        return this.childCount;
    }

    public String getTitle() {
        return this.title;
    }

    /* renamed from: tb */
    public void mo33315tb(int i) {
        this.dYq = i;
    }
}
