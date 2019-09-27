package com.introvd.template.editor.player.p267a;

import com.introvd.template.common.MSize;
import com.introvd.template.editor.player.p267a.p268a.C6484a;
import xiaoying.engine.base.QStyle.QEffectPropertyData;

/* renamed from: com.introvd.template.editor.player.a.j */
public class C6493j extends C6484a {
    private int cDc;
    private QEffectPropertyData[] cZd;
    private boolean cZf;
    private MSize cZg;
    private boolean cZh;
    private long effectID;
    private int eventType;
    private String path;

    public C6493j(int i, int i2, int i3, long j) {
        super(i);
        this.cDc = i2;
        this.eventType = i3;
        this.effectID = j;
    }

    public C6493j(int i, int i2, int i3, MSize mSize, boolean z) {
        super(i);
        this.cDc = i2;
        this.eventType = i3;
        this.cZg = mSize;
        this.cZh = z;
    }

    public C6493j(int i, int i2, int i3, String str) {
        super(i);
        this.cDc = i2;
        this.eventType = i3;
        this.path = str;
    }

    public C6493j(int i, int i2, int i3, QEffectPropertyData[] qEffectPropertyDataArr, boolean z) {
        super(i);
        this.cZf = z;
        this.cDc = i2;
        this.eventType = i3;
        this.cZd = qEffectPropertyDataArr;
    }

    public MSize aoA() {
        return this.cZg;
    }

    public boolean aoB() {
        return this.cZh;
    }

    public boolean aoC() {
        return this.cZf;
    }

    public QEffectPropertyData[] aoy() {
        return this.cZd;
    }

    public long getEffectID() {
        return this.effectID;
    }

    public int getEventType() {
        return this.eventType;
    }

    public String getPath() {
        return this.path;
    }
}
