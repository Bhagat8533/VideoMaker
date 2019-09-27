package com.introvd.template.sdk.editor;

/* renamed from: com.introvd.template.sdk.editor.a */
public class C8418a {
    public int centerX;
    public int centerY;
    public int edu;
    public int edv;
    public int edw;
    public float heightRatio;
    public int rotation;
    public float widthRatio;

    public C8418a(int i, int i2, float f, float f2, int i3, int i4) {
        this.centerX = i;
        this.centerY = i2;
        this.widthRatio = f;
        this.heightRatio = f2;
        this.rotation = i3;
        this.edw = i4;
    }

    public C8418a(int i, int i2, int i3, int i4, int i5, float f, float f2, int i6) {
        this.edw = i;
        this.edv = i2;
        this.edu = i3;
        this.centerX = i4;
        this.centerY = i5;
        this.widthRatio = f;
        this.heightRatio = f2;
        this.rotation = i6;
    }

    /* renamed from: dx */
    public boolean mo34138dx(int i, int i2) {
        int i3 = i2 / 2;
        return i >= this.edu - i3 && i <= this.edu + i3;
    }

    /* renamed from: dy */
    public boolean mo34139dy(int i, int i2) {
        int i3 = i2 / 2;
        return i >= this.edu - i3 && i <= this.edu + i3;
    }
}
