package com.introvd.template.explorer.music.p304b;

/* renamed from: com.introvd.template.explorer.music.b.f */
public class C7267f {
    private C7262a dBr;
    private C7262a dBs;
    private int duration;
    private int eventType;
    private int progress;

    public C7267f(C7262a aVar, int i) {
        this.dBr = aVar;
        this.eventType = i;
    }

    public C7262a axn() {
        return this.dBr;
    }

    public C7262a axo() {
        return this.dBs;
    }

    public int axp() {
        return this.eventType;
    }

    /* renamed from: c */
    public void mo31871c(C7262a aVar) {
        this.dBs = aVar;
    }

    public int getDuration() {
        return this.duration;
    }

    public int getProgress() {
        return this.progress;
    }

    public void setDuration(int i) {
        this.duration = i;
    }

    public void setProgress(int i) {
        this.progress = i;
    }
}
