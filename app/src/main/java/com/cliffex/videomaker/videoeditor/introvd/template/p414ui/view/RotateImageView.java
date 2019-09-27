package com.introvd.template.p414ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.media.ThumbnailUtils;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import p503cz.msebera.android.httpclient.HttpStatus;
import xiaoying.engine.base.QDisplayContext;
import xiaoying.quvideo.com.vivabase.C10122R;

/* renamed from: com.introvd.template.ui.view.RotateImageView */
public class RotateImageView extends ImageView {

    /* renamed from: AA */
    private Path f3627AA = new Path();
    private float aaW = 3.0f;
    private int eyX = 0;
    private int eyY = 0;
    private int eyZ = 0;
    private boolean eza = false;
    private boolean ezb = true;
    private long ezc = 0;
    private long ezd = 0;
    private boolean eze = false;
    private RectF ezf = new RectF();
    private Drawable[] ezg;
    private TransitionDrawable ezh;
    private int mDuration = 0;
    private Bitmap mThumb;

    public RotateImageView(Context context) {
        super(context);
    }

    public RotateImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C10122R.styleable.RotateView);
        int i = obtainStyledAttributes.getInt(C10122R.styleable.RotateView_rotation, 0);
        obtainStyledAttributes.recycle();
        setDegree(i);
    }

    public RotateImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C10122R.styleable.RotateView);
        int i2 = obtainStyledAttributes.getInt(C10122R.styleable.RotateView_rotation, 0);
        obtainStyledAttributes.recycle();
        setDegree(i2);
    }

    /* access modifiers changed from: protected */
    public int getDegree() {
        return this.eyZ;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        try {
            Drawable drawable = getDrawable();
            if (drawable != null) {
                Rect bounds = drawable.getBounds();
                int i = bounds.right - bounds.left;
                int i2 = bounds.bottom - bounds.top;
                if (i != 0) {
                    if (i2 != 0) {
                        if (this.eyX != this.eyZ) {
                            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                            if (currentAnimationTimeMillis < this.ezd) {
                                int i3 = (int) (currentAnimationTimeMillis - this.ezc);
                                int i4 = this.eyY;
                                if (!this.eza) {
                                    i3 = -i3;
                                }
                                int i5 = i4 + ((i3 * QDisplayContext.DISPLAY_ROTATION_180) / this.mDuration);
                                this.eyX = i5 >= 0 ? i5 % 360 : (i5 % 360) + 360;
                                invalidate();
                            } else {
                                this.eyX = this.eyZ;
                            }
                        }
                        int paddingLeft = getPaddingLeft();
                        int paddingTop = getPaddingTop();
                        int width = (getWidth() - paddingLeft) - getPaddingRight();
                        int height = (getHeight() - paddingTop) - getPaddingBottom();
                        int saveCount = canvas.getSaveCount();
                        if (getScaleType() == ScaleType.FIT_CENTER && (width < i || height < i2)) {
                            float f = (float) width;
                            float f2 = (float) height;
                            float min = Math.min(f / ((float) i), f2 / ((float) i2));
                            canvas.scale(min, min, f / 2.0f, f2 / 2.0f);
                        }
                        canvas.translate((float) (paddingLeft + (width / 2)), (float) (paddingTop + (height / 2)));
                        canvas.rotate((float) (-this.eyX));
                        canvas.translate((float) ((-i) / 2), (float) ((-i2) / 2));
                        drawable.draw(canvas);
                        canvas.restoreToCount(saveCount);
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    public void setBitmap(Bitmap bitmap) {
        if (bitmap == null) {
            this.mThumb = null;
            this.ezg = null;
            setImageDrawable(null);
            setVisibility(8);
            return;
        }
        LayoutParams layoutParams = getLayoutParams();
        try {
            this.mThumb = ThumbnailUtils.extractThumbnail(bitmap, (layoutParams.width - getPaddingLeft()) - getPaddingRight(), (layoutParams.height - getPaddingTop()) - getPaddingBottom());
        } catch (Throwable unused) {
        }
        if (this.ezg == null || !this.ezb) {
            this.ezg = new Drawable[2];
            this.ezg[1] = new BitmapDrawable(getContext().getResources(), this.mThumb);
            setImageDrawable(this.ezg[1]);
        } else {
            this.ezg[0] = this.ezg[1];
            this.ezg[1] = new BitmapDrawable(getContext().getResources(), this.mThumb);
            this.ezh = new TransitionDrawable(this.ezg);
            setImageDrawable(this.ezh);
            this.ezh.startTransition(HttpStatus.SC_INTERNAL_SERVER_ERROR);
        }
        setVisibility(0);
    }

    public final void setDegree(int i) {
        int i2 = i >= 0 ? i % 360 : (i % 360) + 360;
        if (i2 != this.eyZ) {
            this.eyZ = i2;
            this.eyY = this.eyX;
            this.ezc = AnimationUtils.currentAnimationTimeMillis();
            int i3 = this.eyZ - this.eyX;
            if (i3 < 0) {
                i3 += 360;
            }
            if (i3 > 180) {
                i3 -= 360;
            }
            this.eza = i3 >= 0;
            this.ezd = this.ezc + ((long) ((Math.abs(i3) * this.mDuration) / QDisplayContext.DISPLAY_ROTATION_180));
            invalidate();
        }
    }

    public void setDegree(int i, int i2) {
        this.mDuration = i2;
        setDegree(i);
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        setAlpha(z ? 255 : 100);
    }

    public void setRoundCorner(boolean z, float f) {
        this.eze = z;
        this.aaW = f;
    }
}
