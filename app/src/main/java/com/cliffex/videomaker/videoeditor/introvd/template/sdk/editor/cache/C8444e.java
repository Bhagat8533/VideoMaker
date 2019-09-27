package com.introvd.template.sdk.editor.cache;

import xiaoying.utils.QBitmap;
import xiaoying.utils.QBitmapFactory;
import xiaoying.utils.QColorSpace;

/* renamed from: com.introvd.template.sdk.editor.cache.e */
public class C8444e {
    private QBitmap een = null;
    private int mHeight = 0;
    private int mWidth = 0;

    public C8444e(int i, int i2) {
        this.mWidth = i;
        this.mHeight = i2;
        this.een = QBitmapFactory.createQBitmapBlank(i, i2, QColorSpace.QPAF_RGB32_A8R8G8B8);
    }

    public QBitmap aIn() {
        return this.een;
    }

    /* renamed from: dD */
    public boolean mo34313dD(int i, int i2) {
        if (i == this.mWidth && i2 == this.mHeight) {
            return false;
        }
        if (this.een != null) {
            this.een = null;
        }
        this.mWidth = i;
        this.mHeight = i2;
        this.een = QBitmapFactory.createQBitmapBlank(i, i2, QColorSpace.QPAF_RGB32_A8R8G8B8);
        return true;
    }

    public void release() {
        if (this.een != null) {
            this.een = null;
        }
    }
}
