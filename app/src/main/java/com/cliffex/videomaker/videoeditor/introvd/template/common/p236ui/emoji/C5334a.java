package com.introvd.template.common.p236ui.emoji;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.support.p021v4.content.res.ResourcesCompat;
import android.text.style.DynamicDrawableSpan;
import java.lang.ref.WeakReference;

/* renamed from: com.introvd.template.common.ui.emoji.a */
class C5334a extends DynamicDrawableSpan {

    /* renamed from: BS */
    private int f3454BS;
    private WeakReference<Drawable> chN;
    private final Context mContext;
    private Drawable mDrawable;
    private int mHeight;
    private final int mResourceId;
    private final int mSize;
    private final int mTextSize;
    private int mWidth;

    public C5334a(Context context, int i, int i2, int i3) {
        super(1);
        this.mContext = context;
        this.mResourceId = i;
        this.mSize = i2;
        this.mHeight = i2;
        this.mWidth = i2;
        this.mTextSize = i3;
        m14522Zx();
    }

    /* renamed from: Zx */
    private void m14522Zx() {
        try {
            this.mDrawable = ResourcesCompat.getDrawable(this.mContext.getResources(), this.mResourceId, null);
            this.mHeight = this.mSize;
            this.mWidth = (this.mHeight * this.mDrawable.getIntrinsicWidth()) / this.mDrawable.getIntrinsicHeight();
            this.f3454BS = (this.mTextSize - this.mHeight) / 2;
            this.mDrawable.setBounds(0, this.f3454BS, this.mWidth, this.f3454BS + this.mHeight);
        } catch (Exception unused) {
        }
    }

    /* renamed from: Zy */
    private Drawable m14523Zy() {
        if (this.chN == null || this.chN.get() == null) {
            this.chN = new WeakReference<>(this.mDrawable);
        }
        return (Drawable) this.chN.get();
    }

    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        Drawable Zy = m14523Zy();
        canvas.save();
        if (Zy != null) {
            int i6 = i5 - Zy.getBounds().bottom;
            if (this.mVerticalAlignment == 1) {
                i6 = ((i3 + ((i5 - i3) / 2)) - ((Zy.getBounds().bottom - Zy.getBounds().top) / 2)) - this.f3454BS;
            }
            canvas.translate(f, (float) i6);
            Zy.draw(canvas);
        }
        canvas.restore();
    }

    public Drawable getDrawable() {
        if (this.mDrawable == null) {
            m14522Zx();
        }
        return this.mDrawable;
    }
}
