package com.introvd.template.sdk.model;

import android.graphics.RectF;
import java.io.Serializable;

public class StylePositionModel implements Serializable {
    private static final long serialVersionUID = -963026009066300819L;
    private float mCenterPosX = 0.0f;
    private float mCenterPosY = 0.0f;
    private float mHeight = 0.0f;
    private float mWidth = 0.0f;

    public StylePositionModel() {
    }

    public StylePositionModel(float f, float f2, float f3, float f4) {
        this.mCenterPosX = f;
        this.mCenterPosY = f2;
        this.mWidth = f3;
        this.mHeight = f4;
    }

    public StylePositionModel(StylePositionModel stylePositionModel) {
        if (stylePositionModel != null) {
            this.mCenterPosX = stylePositionModel.mCenterPosX;
            this.mCenterPosY = stylePositionModel.mCenterPosY;
            this.mWidth = stylePositionModel.mWidth;
            this.mHeight = stylePositionModel.mHeight;
        }
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StylePositionModel)) {
            return false;
        }
        StylePositionModel stylePositionModel = (StylePositionModel) obj;
        if (Float.compare(stylePositionModel.mCenterPosX, this.mCenterPosX) != 0 || Float.compare(stylePositionModel.mCenterPosY, this.mCenterPosY) != 0 || Float.compare(stylePositionModel.mWidth, this.mWidth) != 0) {
            return false;
        }
        if (Float.compare(stylePositionModel.mHeight, this.mHeight) != 0) {
            z = false;
        }
        return z;
    }

    public RectF getRectArea() {
        RectF rectF = new RectF();
        rectF.set(this.mCenterPosX - (this.mWidth / 2.0f), this.mCenterPosY - (this.mHeight / 2.0f), this.mCenterPosX + (this.mWidth / 2.0f), this.mCenterPosY + (this.mHeight / 2.0f));
        return rectF;
    }

    public float getmCenterPosX() {
        return this.mCenterPosX;
    }

    public float getmCenterPosY() {
        return this.mCenterPosY;
    }

    public float getmHeight() {
        return this.mHeight;
    }

    public float getmWidth() {
        return this.mWidth;
    }

    public int hashCode() {
        int i = 0;
        int floatToIntBits = (((((this.mCenterPosX != 0.0f ? Float.floatToIntBits(this.mCenterPosX) : 0) * 31) + (this.mCenterPosY != 0.0f ? Float.floatToIntBits(this.mCenterPosY) : 0)) * 31) + (this.mWidth != 0.0f ? Float.floatToIntBits(this.mWidth) : 0)) * 31;
        if (this.mHeight != 0.0f) {
            i = Float.floatToIntBits(this.mHeight);
        }
        return floatToIntBits + i;
    }

    public void setmCenterPosX(float f) {
        this.mCenterPosX = f;
    }

    public void setmCenterPosY(float f) {
        this.mCenterPosY = f;
    }

    public void setmHeight(float f) {
        this.mHeight = f;
    }

    public void setmWidth(float f) {
        this.mWidth = f;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("mCenterPosX=");
        sb.append(this.mCenterPosX);
        sb.append(";mCenterPosY=");
        sb.append(this.mCenterPosY);
        sb.append(";mWidth=");
        sb.append(this.mWidth);
        sb.append(";mHeight=");
        sb.append(this.mHeight);
        return sb.toString();
    }
}
