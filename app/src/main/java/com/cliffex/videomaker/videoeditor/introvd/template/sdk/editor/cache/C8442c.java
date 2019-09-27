package com.introvd.template.sdk.editor.cache;

import com.introvd.template.sdk.model.VeRange;
import com.introvd.template.sdk.utils.VeMSize;

/* renamed from: com.introvd.template.sdk.editor.cache.c */
public class C8442c {
    private int edS = 0;
    private VeMSize eej = null;
    private boolean eek = false;
    public VeRange mVeRange = new VeRange();

    /* renamed from: a */
    public void mo34283a(VeMSize veMSize) {
        this.eej = veMSize;
    }

    public int aHX() {
        return this.edS;
    }

    public int aIh() {
        int i = (this.edS + 90) % 360;
        this.edS = i;
        return i;
    }

    public boolean aIi() {
        int i = this.edS / 90;
        return i == 1 || i == 3;
    }

    public boolean aIj() {
        return this.eek;
    }

    public int getHeight() {
        if (this.eej != null) {
            return this.eej.height;
        }
        return 0;
    }

    public int getWidth() {
        if (this.eej != null) {
            return this.eej.width;
        }
        return 0;
    }

    /* renamed from: jk */
    public void mo34290jk(boolean z) {
        this.eek = z;
    }

    public String toString() {
        if (this.eej == null) {
            return super.toString();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("width=");
        sb.append(this.eej.width);
        sb.append(";height=");
        sb.append(this.eej.height);
        return sb.toString();
    }
}
