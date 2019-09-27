package com.introvd.template.common.bitmapfun.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.introvd.template.common.bitmapfun.util.ImageWorker.RecyclingImageViewListener;

public class RecyclingImageView extends ImageView implements RecyclingImageViewListener {
    private Object cdQ = null;

    public RecyclingImageView(Context context) {
        super(context);
    }

    public RecyclingImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RecyclingImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* renamed from: c */
    private static void m14335c(Drawable drawable, boolean z) {
        if (drawable != null) {
            if (drawable instanceof RecyclingBitmapDrawable) {
                ((RecyclingBitmapDrawable) drawable).setIsDisplayed(z);
            } else if (drawable instanceof LayerDrawable) {
                LayerDrawable layerDrawable = (LayerDrawable) drawable;
                int numberOfLayers = layerDrawable.getNumberOfLayers();
                for (int i = 0; i < numberOfLayers; i++) {
                    m14335c(layerDrawable.getDrawable(i), z);
                }
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public Object getLoadTag() {
        return this.cdQ;
    }

    public Drawable getOriDrawable() {
        return getDrawable();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        if (getDrawable() instanceof RecyclingBitmapDrawable) {
            setImageDrawable(null);
        }
        this.cdQ = null;
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        try {
            super.onDraw(canvas);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    public void setImageBitmap(Bitmap bitmap) {
        this.cdQ = null;
        super.setImageBitmap(bitmap);
    }

    public void setImageDrawable(Drawable drawable) {
        this.cdQ = null;
        Drawable drawable2 = getDrawable();
        super.setImageDrawable(drawable);
        m14335c(drawable, true);
        m14335c(drawable2, false);
    }

    public void setImageDrawable(Drawable drawable, Object obj) {
        setImageDrawable(drawable);
        this.cdQ = obj;
    }

    public void setImageResource(int i) {
        this.cdQ = null;
        super.setImageResource(i);
    }

    public void setImageURI(Uri uri) {
        this.cdQ = null;
        super.setImageURI(uri);
    }
}
