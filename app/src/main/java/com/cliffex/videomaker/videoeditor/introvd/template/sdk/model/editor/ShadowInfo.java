package com.introvd.template.sdk.model.editor;

import java.io.Serializable;

public class ShadowInfo implements Serializable {
    private static final long serialVersionUID = -2052704248964566815L;
    private boolean bEnableShadow = false;
    private float mShadowBlurRadius = 0.1f;
    private int mShadowColor = -1442840576;
    private float mShadowXShift = 0.1f;
    private float mShadowYShift = 0.1f;

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShadowInfo)) {
            return false;
        }
        ShadowInfo shadowInfo = (ShadowInfo) obj;
        if (this.bEnableShadow != shadowInfo.bEnableShadow || Float.compare(shadowInfo.mShadowXShift, this.mShadowXShift) != 0 || Float.compare(shadowInfo.mShadowYShift, this.mShadowYShift) != 0 || this.mShadowColor != shadowInfo.mShadowColor) {
            return false;
        }
        if (Float.compare(shadowInfo.mShadowBlurRadius, this.mShadowBlurRadius) != 0) {
            z = false;
        }
        return z;
    }

    public float getmShadowBlurRadius() {
        return this.mShadowBlurRadius;
    }

    public int getmShadowColor() {
        return this.mShadowColor;
    }

    public float getmShadowXShift() {
        return this.mShadowXShift;
    }

    public float getmShadowYShift() {
        return this.mShadowYShift;
    }

    public int hashCode() {
        int i = 0;
        int floatToIntBits = (((((((this.bEnableShadow ? 1 : 0) * true) + (this.mShadowXShift != 0.0f ? Float.floatToIntBits(this.mShadowXShift) : 0)) * 31) + (this.mShadowYShift != 0.0f ? Float.floatToIntBits(this.mShadowYShift) : 0)) * 31) + this.mShadowColor) * 31;
        if (this.mShadowBlurRadius != 0.0f) {
            i = Float.floatToIntBits(this.mShadowBlurRadius);
        }
        return floatToIntBits + i;
    }

    public boolean isbEnableShadow() {
        return this.bEnableShadow;
    }

    public void setbEnableShadow(boolean z) {
        this.bEnableShadow = z;
    }

    public void setmShadowBlurRadius(float f) {
        this.mShadowBlurRadius = f;
    }

    public void setmShadowColor(int i) {
        this.mShadowColor = i;
    }

    public void setmShadowXShift(float f) {
        this.mShadowXShift = f;
    }

    public void setmShadowYShift(float f) {
        this.mShadowYShift = f;
    }
}
