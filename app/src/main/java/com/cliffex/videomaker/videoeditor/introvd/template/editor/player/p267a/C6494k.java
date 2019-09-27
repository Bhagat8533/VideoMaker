package com.introvd.template.editor.player.p267a;

import com.introvd.template.editor.player.p267a.p268a.C6484a;

/* renamed from: com.introvd.template.editor.player.a.k */
public class C6494k extends C6484a {
    private int cDc;
    private boolean cZi;
    private int eventType;
    private float speed;

    public C6494k(int i, int i2, int i3, float f) {
        super(i);
        this.cDc = i2;
        this.eventType = i3;
        this.speed = f;
    }

    public C6494k(int i, int i2, int i3, float f, boolean z) {
        super(i);
        this.cDc = i2;
        this.eventType = i3;
        this.speed = f;
        this.cZi = z;
    }

    public C6494k(int i, int i2, int i3, boolean z) {
        super(i);
        this.cDc = i2;
        this.eventType = i3;
        this.cZi = z;
    }

    public boolean aoD() {
        return this.cZi;
    }

    public int getEventType() {
        return this.eventType;
    }

    public int getFocusIndex() {
        return this.cDc;
    }

    public float getSpeed() {
        return this.speed;
    }
}
