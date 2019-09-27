package com.introvd.template.common.glide;

import android.content.Context;
import android.graphics.Bitmap;
import com.bumptech.glide.load.p118b.p119a.C2308e;
import com.bumptech.glide.load.p123c.p124a.C2448v;
import java.security.MessageDigest;
import p081c.p082a.p083a.p084a.C1862a;

public class CustomCropSquareTransformation extends C1862a {
    private boolean ceM = true;
    private int size;

    public boolean equals(Object obj) {
        return (obj instanceof CustomCropSquareTransformation) && ((CustomCropSquareTransformation) obj).size == this.size;
    }

    public int hashCode() {
        return "jp.wasabeef.glide.transformations.CropSquareTransformation.1".hashCode() + (this.size * 10);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CropSquareTransformation(size=");
        sb.append(this.size);
        sb.append(")");
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    public Bitmap transform(Context context, C2308e eVar, Bitmap bitmap, int i, int i2) {
        this.size = this.ceM ? Math.min(i, i2) : Math.max(i, i2);
        return C2448v.m7049b(eVar, bitmap, this.size, this.size);
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        StringBuilder sb = new StringBuilder();
        sb.append("jp.wasabeef.glide.transformations.CropSquareTransformation.1");
        sb.append(this.size);
        messageDigest.update(sb.toString().getBytes(aBi));
    }
}
