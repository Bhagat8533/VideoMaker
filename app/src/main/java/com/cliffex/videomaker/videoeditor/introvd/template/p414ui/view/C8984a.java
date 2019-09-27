package com.introvd.template.p414ui.view;

import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.TransitionDrawable;
import android.util.Log;
import android.widget.ImageView.ScaleType;

/* renamed from: com.introvd.template.ui.view.a */
public class C8984a extends Drawable {
    private ScaleType aNd = ScaleType.FIT_CENTER;
    private final Paint dlZ;
    private final RectF dmi = new RectF();
    private TileMode ezA = TileMode.CLAMP;
    private TileMode ezB = TileMode.CLAMP;
    private boolean ezC = true;
    private boolean ezD = false;
    private float ezE = 0.0f;
    private ColorStateList ezF = ColorStateList.valueOf(-16777216);
    private final RectF ezw = new RectF();
    private final RectF ezx = new RectF();
    private final Paint ezy;
    private final RectF ezz = new RectF();
    private final Bitmap mBitmap;
    private final int mBitmapHeight;
    private BitmapShader mBitmapShader;
    private final int mBitmapWidth;
    private float mCornerRadius = 0.0f;
    private final Matrix mShaderMatrix = new Matrix();

    /* renamed from: com.introvd.template.ui.view.a$1 */
    static /* synthetic */ class C89851 {

        /* renamed from: Cb */
        static final /* synthetic */ int[] f3632Cb = new int[ScaleType.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|(3:13|14|16)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|16) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0040 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x004b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            /*
                android.widget.ImageView$ScaleType[] r0 = android.widget.ImageView.ScaleType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f3632Cb = r0
                int[] r0 = f3632Cb     // Catch:{ NoSuchFieldError -> 0x0014 }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.CENTER     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f3632Cb     // Catch:{ NoSuchFieldError -> 0x001f }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.CENTER_CROP     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = f3632Cb     // Catch:{ NoSuchFieldError -> 0x002a }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.CENTER_INSIDE     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r0 = f3632Cb     // Catch:{ NoSuchFieldError -> 0x0035 }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_CENTER     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                int[] r0 = f3632Cb     // Catch:{ NoSuchFieldError -> 0x0040 }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_END     // Catch:{ NoSuchFieldError -> 0x0040 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0040 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0040 }
            L_0x0040:
                int[] r0 = f3632Cb     // Catch:{ NoSuchFieldError -> 0x004b }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_START     // Catch:{ NoSuchFieldError -> 0x004b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x004b }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x004b }
            L_0x004b:
                int[] r0 = f3632Cb     // Catch:{ NoSuchFieldError -> 0x0056 }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_XY     // Catch:{ NoSuchFieldError -> 0x0056 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0056 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0056 }
            L_0x0056:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.p414ui.view.C8984a.C89851.<clinit>():void");
        }
    }

    public C8984a(Bitmap bitmap) {
        this.mBitmap = bitmap;
        this.mBitmapWidth = bitmap.getWidth();
        this.mBitmapHeight = bitmap.getHeight();
        this.dmi.set(0.0f, 0.0f, (float) this.mBitmapWidth, (float) this.mBitmapHeight);
        this.ezy = new Paint();
        this.ezy.setStyle(Style.FILL);
        this.ezy.setAntiAlias(true);
        this.dlZ = new Paint();
        this.dlZ.setStyle(Style.STROKE);
        this.dlZ.setAntiAlias(true);
        this.dlZ.setColor(this.ezF.getColorForState(getState(), -16777216));
        this.dlZ.setStrokeWidth(this.ezE);
    }

    /* renamed from: K */
    public static Drawable m26383K(Drawable drawable) {
        if (drawable == null || (drawable instanceof C8984a)) {
            return drawable;
        }
        if (!(drawable instanceof TransitionDrawable) && (drawable instanceof LayerDrawable)) {
            LayerDrawable layerDrawable = (LayerDrawable) drawable;
            int numberOfLayers = layerDrawable.getNumberOfLayers();
            for (int i = 0; i < numberOfLayers; i++) {
                layerDrawable.setDrawableByLayerId(layerDrawable.getId(i), m26383K(layerDrawable.getDrawable(i)));
            }
            return layerDrawable;
        }
        Bitmap L = m26384L(drawable);
        if (L != null) {
            return new C8984a(L);
        }
        Log.w("RoundedDrawable", "Failed to create bitmap from drawable!");
        return drawable;
    }

    /* renamed from: L */
    public static Bitmap m26384L(Drawable drawable) {
        Bitmap bitmap;
        if (drawable instanceof TransitionDrawable) {
            TransitionDrawable transitionDrawable = (TransitionDrawable) drawable;
            if (transitionDrawable.getNumberOfLayers() >= 2) {
                Drawable drawable2 = transitionDrawable.getDrawable(1);
                if (drawable2 instanceof BitmapDrawable) {
                    drawable = drawable2;
                }
            }
        }
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        try {
            bitmap = Bitmap.createBitmap(Math.max(drawable.getIntrinsicWidth(), 2), Math.max(drawable.getIntrinsicHeight(), 2), Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
        } catch (Exception unused) {
            bitmap = null;
        }
        return bitmap;
    }

    private void aNh() {
        float f;
        float f2;
        switch (C89851.f3632Cb[this.aNd.ordinal()]) {
            case 1:
                this.ezz.set(this.ezw);
                this.ezz.inset(this.ezE / 2.0f, this.ezE / 2.0f);
                this.mShaderMatrix.reset();
                this.mShaderMatrix.setTranslate((float) ((int) (((this.ezz.width() - ((float) this.mBitmapWidth)) * 0.5f) + 0.5f)), (float) ((int) (((this.ezz.height() - ((float) this.mBitmapHeight)) * 0.5f) + 0.5f)));
                break;
            case 2:
                this.ezz.set(this.ezw);
                this.ezz.inset(this.ezE / 2.0f, this.ezE / 2.0f);
                this.mShaderMatrix.reset();
                float f3 = 0.0f;
                if (((float) this.mBitmapWidth) * this.ezz.height() > this.ezz.width() * ((float) this.mBitmapHeight)) {
                    f2 = this.ezz.height() / ((float) this.mBitmapHeight);
                    f = (this.ezz.width() - (((float) this.mBitmapWidth) * f2)) * 0.5f;
                } else {
                    f2 = this.ezz.width() / ((float) this.mBitmapWidth);
                    f3 = (this.ezz.height() - (((float) this.mBitmapHeight) * f2)) * 0.5f;
                    f = 0.0f;
                }
                this.mShaderMatrix.setScale(f2, f2);
                this.mShaderMatrix.postTranslate(((float) ((int) (f + 0.5f))) + this.ezE, ((float) ((int) (f3 + 0.5f))) + this.ezE);
                break;
            case 3:
                this.mShaderMatrix.reset();
                float min = (((float) this.mBitmapWidth) > this.ezw.width() || ((float) this.mBitmapHeight) > this.ezw.height()) ? Math.min(this.ezw.width() / ((float) this.mBitmapWidth), this.ezw.height() / ((float) this.mBitmapHeight)) : 1.0f;
                float width = (float) ((int) (((this.ezw.width() - (((float) this.mBitmapWidth) * min)) * 0.5f) + 0.5f));
                float height = (float) ((int) (((this.ezw.height() - (((float) this.mBitmapHeight) * min)) * 0.5f) + 0.5f));
                this.mShaderMatrix.setScale(min, min);
                this.mShaderMatrix.postTranslate(width, height);
                this.ezz.set(this.dmi);
                this.mShaderMatrix.mapRect(this.ezz);
                this.ezz.inset(this.ezE / 2.0f, this.ezE / 2.0f);
                this.mShaderMatrix.setRectToRect(this.dmi, this.ezz, ScaleToFit.FILL);
                break;
            case 5:
                this.ezz.set(this.dmi);
                this.mShaderMatrix.setRectToRect(this.dmi, this.ezw, ScaleToFit.END);
                this.mShaderMatrix.mapRect(this.ezz);
                this.ezz.inset(this.ezE / 2.0f, this.ezE / 2.0f);
                this.mShaderMatrix.setRectToRect(this.dmi, this.ezz, ScaleToFit.FILL);
                break;
            case 6:
                this.ezz.set(this.dmi);
                this.mShaderMatrix.setRectToRect(this.dmi, this.ezw, ScaleToFit.START);
                this.mShaderMatrix.mapRect(this.ezz);
                this.ezz.inset(this.ezE / 2.0f, this.ezE / 2.0f);
                this.mShaderMatrix.setRectToRect(this.dmi, this.ezz, ScaleToFit.FILL);
                break;
            case 7:
                this.ezz.set(this.ezw);
                this.ezz.inset(this.ezE / 2.0f, this.ezE / 2.0f);
                this.mShaderMatrix.reset();
                this.mShaderMatrix.setRectToRect(this.dmi, this.ezz, ScaleToFit.FILL);
                break;
            default:
                this.ezz.set(this.dmi);
                this.mShaderMatrix.setRectToRect(this.dmi, this.ezw, ScaleToFit.CENTER);
                this.mShaderMatrix.mapRect(this.ezz);
                this.ezz.inset(this.ezE / 2.0f, this.ezE / 2.0f);
                this.mShaderMatrix.setRectToRect(this.dmi, this.ezz, ScaleToFit.FILL);
                break;
        }
        this.ezx.set(this.ezz);
    }

    /* renamed from: w */
    public static C8984a m26385w(Bitmap bitmap) {
        if (bitmap != null) {
            return new C8984a(bitmap);
        }
        return null;
    }

    /* renamed from: a */
    public C8984a mo35740a(TileMode tileMode) {
        if (this.ezA != tileMode) {
            this.ezA = tileMode;
            this.ezC = true;
            invalidateSelf();
        }
        return this;
    }

    /* renamed from: aT */
    public C8984a mo35741aT(float f) {
        this.mCornerRadius = f;
        return this;
    }

    /* renamed from: aU */
    public C8984a mo35742aU(float f) {
        this.ezE = f;
        this.dlZ.setStrokeWidth(this.ezE);
        return this;
    }

    /* renamed from: b */
    public C8984a mo35743b(TileMode tileMode) {
        if (this.ezB != tileMode) {
            this.ezB = tileMode;
            this.ezC = true;
            invalidateSelf();
        }
        return this;
    }

    /* renamed from: b */
    public C8984a mo35744b(ScaleType scaleType) {
        if (scaleType == null) {
            scaleType = ScaleType.FIT_CENTER;
        }
        if (this.aNd != scaleType) {
            this.aNd = scaleType;
            aNh();
        }
        return this;
    }

    public void draw(Canvas canvas) {
        if (this.ezC) {
            this.mBitmapShader = new BitmapShader(this.mBitmap, this.ezA, this.ezB);
            if (this.ezA == TileMode.CLAMP && this.ezB == TileMode.CLAMP) {
                this.mBitmapShader.setLocalMatrix(this.mShaderMatrix);
            }
            this.ezy.setShader(this.mBitmapShader);
            this.ezC = false;
        }
        if (this.ezD) {
            if (this.ezE > 0.0f) {
                canvas.drawOval(this.ezx, this.ezy);
                canvas.drawOval(this.ezz, this.dlZ);
                return;
            }
            canvas.drawOval(this.ezx, this.ezy);
        } else if (this.ezE > 0.0f) {
            canvas.drawRoundRect(this.ezx, Math.max(this.mCornerRadius, 0.0f), Math.max(this.mCornerRadius, 0.0f), this.ezy);
            canvas.drawRoundRect(this.ezz, this.mCornerRadius, this.mCornerRadius, this.dlZ);
        } else {
            canvas.drawRoundRect(this.ezx, this.mCornerRadius, this.mCornerRadius, this.ezy);
        }
    }

    public int getIntrinsicHeight() {
        return this.mBitmapHeight;
    }

    public int getIntrinsicWidth() {
        return this.mBitmapWidth;
    }

    public int getOpacity() {
        return -3;
    }

    public boolean isStateful() {
        return this.ezF.isStateful();
    }

    /* renamed from: jK */
    public C8984a mo35750jK(boolean z) {
        this.ezD = z;
        return this;
    }

    /* renamed from: l */
    public C8984a mo35751l(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.ezF = colorStateList;
        this.dlZ.setColor(this.ezF.getColorForState(getState(), -16777216));
        return this;
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.ezw.set(rect);
        aNh();
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        int colorForState = this.ezF.getColorForState(iArr, 0);
        if (this.dlZ.getColor() == colorForState) {
            return super.onStateChange(iArr);
        }
        this.dlZ.setColor(colorForState);
        return true;
    }

    public void setAlpha(int i) {
        this.ezy.setAlpha(i);
        invalidateSelf();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.ezy.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public void setDither(boolean z) {
        this.ezy.setDither(z);
        invalidateSelf();
    }

    public void setFilterBitmap(boolean z) {
        this.ezy.setFilterBitmap(z);
        invalidateSelf();
    }
}
