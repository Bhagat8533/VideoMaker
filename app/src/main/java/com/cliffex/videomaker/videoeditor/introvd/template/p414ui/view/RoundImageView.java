package com.introvd.template.p414ui.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView.ScaleType;
import xiaoying.quvideo.com.vivabase.C10122R;

/* renamed from: com.introvd.template.ui.view.RoundImageView */
public class RoundImageView extends RotateImageView {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final TileMode DEFAULT_TILE_MODE = TileMode.CLAMP;
    private static final ScaleType[] ezo = {ScaleType.MATRIX, ScaleType.FIT_XY, ScaleType.FIT_START, ScaleType.FIT_CENTER, ScaleType.FIT_END, ScaleType.CENTER, ScaleType.CENTER_CROP, ScaleType.CENTER_INSIDE};
    private ScaleType aNd;
    private ColorStateList ezp;
    private boolean ezq;
    private boolean ezr;
    private TileMode ezs;
    private TileMode ezt;
    private int ezu;
    private Drawable ezv;
    private Drawable mDrawable;
    protected Drawable mOriDrawable;

    /* renamed from: ty */
    private float f3628ty;

    /* renamed from: xw */
    private float f3629xw;

    /* renamed from: com.introvd.template.ui.view.RoundImageView$1 */
    static /* synthetic */ class C89821 {

        /* renamed from: Cb */
        static final /* synthetic */ int[] f3630Cb = new int[ScaleType.values().length];

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
                f3630Cb = r0
                int[] r0 = f3630Cb     // Catch:{ NoSuchFieldError -> 0x0014 }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.CENTER     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f3630Cb     // Catch:{ NoSuchFieldError -> 0x001f }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.CENTER_CROP     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = f3630Cb     // Catch:{ NoSuchFieldError -> 0x002a }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.CENTER_INSIDE     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r0 = f3630Cb     // Catch:{ NoSuchFieldError -> 0x0035 }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_CENTER     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                int[] r0 = f3630Cb     // Catch:{ NoSuchFieldError -> 0x0040 }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_START     // Catch:{ NoSuchFieldError -> 0x0040 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0040 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0040 }
            L_0x0040:
                int[] r0 = f3630Cb     // Catch:{ NoSuchFieldError -> 0x004b }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_END     // Catch:{ NoSuchFieldError -> 0x004b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x004b }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x004b }
            L_0x004b:
                int[] r0 = f3630Cb     // Catch:{ NoSuchFieldError -> 0x0056 }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_XY     // Catch:{ NoSuchFieldError -> 0x0056 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0056 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0056 }
            L_0x0056:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.p414ui.view.RoundImageView.C89821.<clinit>():void");
        }
    }

    public RoundImageView(Context context) {
        super(context);
        this.f3629xw = 0.0f;
        this.f3628ty = 0.0f;
        this.ezp = ColorStateList.valueOf(-16777216);
        this.ezq = false;
        this.ezr = false;
        this.ezs = DEFAULT_TILE_MODE;
        this.ezt = DEFAULT_TILE_MODE;
        this.mOriDrawable = null;
    }

    public RoundImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3629xw = 0.0f;
        this.f3628ty = 0.0f;
        this.ezp = ColorStateList.valueOf(-16777216);
        this.ezq = false;
        this.ezr = false;
        this.ezs = DEFAULT_TILE_MODE;
        this.ezt = DEFAULT_TILE_MODE;
        this.mOriDrawable = null;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C10122R.styleable.RoundedImageView, i, 0);
        int i2 = obtainStyledAttributes.getInt(C10122R.styleable.RoundedImageView_android_scaleType, -1);
        if (i2 >= 0) {
            setScaleType(ezo[i2]);
        } else {
            setScaleType(ScaleType.FIT_CENTER);
        }
        this.f3629xw = (float) obtainStyledAttributes.getDimensionPixelSize(C10122R.styleable.RoundedImageView_riv_corner_radius, -1);
        this.f3628ty = (float) obtainStyledAttributes.getDimensionPixelSize(C10122R.styleable.RoundedImageView_riv_border_width, -1);
        if (this.f3629xw < 0.0f) {
            this.f3629xw = 0.0f;
        }
        if (this.f3628ty < 0.0f) {
            this.f3628ty = 0.0f;
        }
        this.ezp = obtainStyledAttributes.getColorStateList(C10122R.styleable.RoundedImageView_riv_border_color);
        if (this.ezp == null) {
            this.ezp = ColorStateList.valueOf(-16777216);
        }
        this.ezr = obtainStyledAttributes.getBoolean(C10122R.styleable.RoundedImageView_riv_mutate_background, false);
        this.ezq = obtainStyledAttributes.getBoolean(C10122R.styleable.RoundedImageView_riv_oval, false);
        int i3 = obtainStyledAttributes.getInt(C10122R.styleable.RoundedImageView_riv_tile_mode, -2);
        if (i3 != -2) {
            setTileModeX(parseTileMode(i3));
            setTileModeY(parseTileMode(i3));
        }
        int i4 = obtainStyledAttributes.getInt(C10122R.styleable.RoundedImageView_riv_tile_mode_x, -2);
        if (i4 != -2) {
            setTileModeX(parseTileMode(i4));
        }
        int i5 = obtainStyledAttributes.getInt(C10122R.styleable.RoundedImageView_riv_tile_mode_y, -2);
        if (i5 != -2) {
            setTileModeY(parseTileMode(i5));
        }
        aNg();
        m26369jJ(true);
        obtainStyledAttributes.recycle();
    }

    /* renamed from: J */
    private void m26368J(Drawable drawable) {
        if (drawable != null) {
            if (drawable instanceof C8984a) {
                ((C8984a) drawable).mo35744b(this.aNd).mo35741aT(this.f3629xw).mo35742aU(this.f3628ty).mo35751l(this.ezp).mo35750jK(this.ezq).mo35740a(this.ezs).mo35743b(this.ezt);
            } else if (drawable instanceof LayerDrawable) {
                LayerDrawable layerDrawable = (LayerDrawable) drawable;
                int numberOfLayers = layerDrawable.getNumberOfLayers();
                for (int i = 0; i < numberOfLayers; i++) {
                    m26368J(layerDrawable.getDrawable(i));
                }
            }
        }
    }

    private Drawable aNf() {
        Drawable drawable;
        Resources resources = getResources();
        if (resources == null) {
            return null;
        }
        if (this.ezu != 0) {
            try {
                drawable = resources.getDrawable(this.ezu);
            } catch (Exception e) {
                StringBuilder sb = new StringBuilder();
                sb.append("Unable to find resource: ");
                sb.append(this.ezu);
                Log.w("RoundedImageView", sb.toString(), e);
                this.ezu = 0;
            }
            return C8984a.m26383K(drawable);
        }
        drawable = null;
        return C8984a.m26383K(drawable);
    }

    private void aNg() {
        m26368J(this.mDrawable);
    }

    /* renamed from: jJ */
    private void m26369jJ(boolean z) {
        if (this.ezr) {
            if (z) {
                this.ezv = C8984a.m26383K(this.ezv);
            }
            if (this.ezv != null) {
                m26368J(this.ezv);
            }
        }
    }

    private static final TileMode parseTileMode(int i) {
        switch (i) {
            case 0:
                return TileMode.CLAMP;
            case 1:
                return TileMode.REPEAT;
            case 2:
                return TileMode.MIRROR;
            default:
                return null;
        }
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        invalidate();
    }

    public int getBorderColor() {
        return this.ezp.getDefaultColor();
    }

    public ColorStateList getBorderColors() {
        return this.ezp;
    }

    public float getBorderWidth() {
        return this.f3628ty;
    }

    public float getCornerRadius() {
        return this.f3629xw;
    }

    public ScaleType getScaleType() {
        return this.aNd;
    }

    public TileMode getTileModeX() {
        return this.ezs;
    }

    public TileMode getTileModeY() {
        return this.ezt;
    }

    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Deprecated
    public void setBackgroundDrawable(Drawable drawable) {
        this.ezv = drawable;
        m26369jJ(true);
        super.setBackgroundDrawable(this.ezv);
    }

    public void setBorderColor(int i) {
        setBorderColor(ColorStateList.valueOf(i));
    }

    public void setBorderColor(ColorStateList colorStateList) {
        if (!this.ezp.equals(colorStateList)) {
            if (colorStateList == null) {
                colorStateList = ColorStateList.valueOf(-16777216);
            }
            this.ezp = colorStateList;
            aNg();
            m26369jJ(false);
            if (this.f3628ty > 0.0f) {
                invalidate();
            }
        }
    }

    public void setBorderWidth(float f) {
        if (this.f3628ty != f) {
            this.f3628ty = f;
            aNg();
            m26369jJ(false);
            invalidate();
        }
    }

    public void setBorderWidth(int i) {
        setBorderWidth(getResources().getDimension(i));
    }

    public void setCornerRadius(float f) {
        if (this.f3629xw != f) {
            this.f3629xw = f;
            aNg();
            m26369jJ(false);
        }
    }

    public void setCornerRadius(int i) {
        setCornerRadius(getResources().getDimension(i));
    }

    public void setImageBitmap(Bitmap bitmap) {
        this.ezu = 0;
        this.mDrawable = C8984a.m26385w(bitmap);
        if (this.mDrawable != null) {
            aNg();
        }
        super.setImageDrawable(this.mDrawable);
    }

    public void setImageDrawable(Drawable drawable) {
        this.mOriDrawable = drawable;
        this.ezu = 0;
        this.mDrawable = C8984a.m26383K(drawable);
        if (this.mDrawable != null) {
            aNg();
        }
        super.setImageDrawable(this.mDrawable);
    }

    public void setImageResource(int i) {
        if (this.ezu != i) {
            this.ezu = i;
            this.mDrawable = aNf();
            if (this.mDrawable != null) {
                aNg();
            }
            super.setImageDrawable(this.mDrawable);
        }
    }

    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        setImageDrawable(getDrawable());
    }

    public void setOval(boolean z) {
        this.ezq = z;
        aNg();
        m26369jJ(false);
        invalidate();
    }

    public final void setScaleType(ScaleType scaleType) {
        if (this.aNd != scaleType) {
            this.aNd = scaleType;
            switch (C89821.f3630Cb[scaleType.ordinal()]) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                    super.setScaleType(ScaleType.FIT_XY);
                    break;
                default:
                    super.setScaleType(scaleType);
                    break;
            }
            aNg();
            m26369jJ(false);
            invalidate();
        }
    }

    public final void setTileModeX(TileMode tileMode) {
        if (this.ezs != tileMode) {
            this.ezs = tileMode;
            aNg();
            m26369jJ(false);
            invalidate();
        }
    }

    public final void setTileModeY(TileMode tileMode) {
        if (this.ezt != tileMode) {
            this.ezt = tileMode;
            aNg();
            m26369jJ(false);
            invalidate();
        }
    }
}
