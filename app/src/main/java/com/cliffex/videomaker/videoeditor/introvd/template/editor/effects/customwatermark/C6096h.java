package com.introvd.template.editor.effects.customwatermark;

import com.introvd.template.common.MSize;
import com.introvd.template.sdk.model.editor.ScaleRotateViewState;
import java.io.Serializable;

/* renamed from: com.introvd.template.editor.effects.customwatermark.h */
public class C6096h implements Serializable {
    private static final long serialVersionUID = -6946947671616542157L;
    public int cKA;
    public int cKB;
    public int cKC;
    public ScaleRotateViewState cKy;
    public int cKz;

    public C6096h(ScaleRotateViewState scaleRotateViewState, MSize mSize, MSize mSize2) {
        this.cKy = scaleRotateViewState;
        this.cKz = mSize.width;
        this.cKA = mSize.height;
        this.cKB = mSize2.width;
        this.cKC = mSize2.height;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C6096h)) {
            return false;
        }
        C6096h hVar = (C6096h) obj;
        if (!this.cKy.equals(hVar.cKy) || this.cKC != hVar.cKC || this.cKB != hVar.cKB || this.cKz != hVar.cKz) {
            return false;
        }
        if (this.cKA != hVar.cKA) {
            z = false;
        }
        return z;
    }
}
