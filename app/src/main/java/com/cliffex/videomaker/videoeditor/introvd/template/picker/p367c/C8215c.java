package com.introvd.template.picker.p367c;

import java.io.Serializable;

/* renamed from: com.introvd.template.picker.c.c */
public class C8215c implements Serializable {
    private String dCM;
    private int dXV;
    private boolean dYE;
    private int duration;
    private String thumbPath;

    /* renamed from: com.introvd.template.picker.c.c$a */
    static class C8216a {
        String dCM;
        int dXV;
        boolean dYE;
        int duration;
        String thumbPath;

        C8216a() {
        }

        public C8215c aFL() {
            return new C8215c(this);
        }

        /* renamed from: my */
        public C8216a mo33356my(String str) {
            this.thumbPath = str;
            return this;
        }

        /* renamed from: mz */
        public C8216a mo33357mz(String str) {
            this.dCM = str;
            return this;
        }

        /* renamed from: tf */
        public C8216a mo33358tf(int i) {
            this.duration = i;
            return this;
        }

        /* renamed from: tg */
        public C8216a mo33359tg(int i) {
            this.dXV = i;
            return this;
        }
    }

    public C8215c(C8216a aVar) {
        this.thumbPath = aVar.thumbPath;
        this.duration = aVar.duration;
        this.dXV = aVar.dXV;
        this.dCM = aVar.dCM;
        this.dYE = aVar.dYE;
    }

    public String aFD() {
        return this.thumbPath;
    }

    public boolean aFJ() {
        return this.dYE;
    }

    public String aFK() {
        return this.dCM;
    }

    public int getDuration() {
        return this.duration;
    }

    public int getSourceType() {
        return this.dXV;
    }

    /* renamed from: iU */
    public void mo33354iU(boolean z) {
        this.dYE = z;
    }
}
