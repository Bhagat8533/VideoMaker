package com.introvd.template.sdk.model.editor;

import java.io.Serializable;

public class StrokeInfo implements Serializable {
    private static final long serialVersionUID = 787425019132700380L;
    public int strokeColor = -1;
    public float strokeWPersent = 0.0f;

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StrokeInfo)) {
            return false;
        }
        StrokeInfo strokeInfo = (StrokeInfo) obj;
        if (!(this.strokeColor == strokeInfo.strokeColor && Float.compare(strokeInfo.strokeWPersent, this.strokeWPersent) == 0)) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return (this.strokeColor * 31) + (this.strokeWPersent != 0.0f ? Float.floatToIntBits(this.strokeWPersent) : 0);
    }
}
