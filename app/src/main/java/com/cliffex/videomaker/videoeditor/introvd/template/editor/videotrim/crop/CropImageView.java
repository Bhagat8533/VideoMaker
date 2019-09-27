package com.introvd.template.editor.videotrim.crop;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.p024v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.introvd.template.common.LogUtils;
import com.introvd.template.editor.R;
import com.introvd.template.editor.videotrim.crop.p289a.C6969a;
import com.introvd.template.editor.videotrim.crop.p290b.C6974c;
import com.introvd.template.editor.videotrim.crop.p291c.C6978a;
import com.introvd.template.editor.videotrim.crop.p291c.C6979b;
import com.introvd.template.editor.videotrim.crop.p291c.C6982d;

public class CropImageView extends AppCompatImageView {
    private static final String TAG = "com.introvd.template.editor.videotrim.crop.CropImageView";
    private Paint bbT;
    private Paint dlZ;
    private Paint dma;
    private Paint dmb;
    private float dmc;
    private float dmd;
    private float dme;
    private float dmf;
    private float dmg;
    private boolean dmh = false;
    private RectF dmi = new RectF();
    private PointF dmj = new PointF();
    private C6974c dmk;
    private boolean dml;
    private int dmm = 1;
    private int dmn = 1;
    private int dmo = 1;
    private C6968a dmp;

    /* renamed from: com.introvd.template.editor.videotrim.crop.CropImageView$a */
    public interface C6968a {
        void aty();
    }

    public CropImageView(Context context) {
        super(context);
        init(context, null);
    }

    public CropImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public CropImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context, attributeSet);
    }

    /* renamed from: D */
    private void m20367D(float f, float f2) {
        float atF = C6969a.LEFT.atF();
        float atF2 = C6969a.TOP.atF();
        float atF3 = C6969a.RIGHT.atF();
        float atF4 = C6969a.BOTTOM.atF();
        String str = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("--->onActionDown left:");
        sb.append(atF);
        sb.append(",top:");
        sb.append(atF2);
        sb.append(",right:");
        sb.append(atF3);
        sb.append(",bottom:");
        sb.append(atF4);
        LogUtils.m14222e(str, sb.toString());
        this.dmk = C6979b.m20410a(f, f2, atF, atF2, atF3, atF4, this.dmc);
        if (this.dmk != null) {
            C6979b.m20411a(this.dmk, f, f2, atF, atF2, atF3, atF4, this.dmj);
            invalidate();
        }
    }

    /* renamed from: E */
    private void m20368E(float f, float f2) {
        if (this.dmk != null) {
            float f3 = f + this.dmj.x;
            float f4 = f2 + this.dmj.y;
            if (this.dml) {
                this.dmk.mo30668a(f3, f4, getTargetAspectRatio(), this.dmi, this.dmd);
            } else {
                this.dmk.mo30669a(f3, f4, this.dmi, this.dmd);
            }
            invalidate();
        }
    }

    /* renamed from: K */
    private void m20369K(Canvas canvas) {
        RectF rectF = this.dmi;
        float atF = C6969a.LEFT.atF();
        float atF2 = C6969a.TOP.atF();
        float atF3 = C6969a.RIGHT.atF();
        float atF4 = C6969a.BOTTOM.atF();
        Canvas canvas2 = canvas;
        canvas2.drawRect(rectF.left, rectF.top, rectF.right, atF2, this.dmb);
        canvas2.drawRect(rectF.left, atF4, rectF.right, rectF.bottom, this.dmb);
        canvas.drawRect(rectF.left, atF2, atF, atF4, this.dmb);
        canvas.drawRect(atF3, atF2, rectF.right, atF4, this.dmb);
    }

    /* renamed from: L */
    private void m20370L(Canvas canvas) {
        if (atD()) {
            float atF = C6969a.LEFT.atF();
            float atF2 = C6969a.TOP.atF();
            float atF3 = C6969a.RIGHT.atF();
            float atF4 = C6969a.BOTTOM.atF();
            float width = C6969a.getWidth() / 3.0f;
            float f = atF + width;
            Canvas canvas2 = canvas;
            float f2 = atF2;
            float f3 = atF4;
            canvas2.drawLine(f, f2, f, f3, this.dma);
            float f4 = atF3 - width;
            canvas2.drawLine(f4, f2, f4, f3, this.dma);
            float height = C6969a.getHeight() / 3.0f;
            float f5 = atF2 + height;
            Canvas canvas3 = canvas;
            float f6 = atF;
            float f7 = atF3;
            canvas3.drawLine(f6, f5, f7, f5, this.dma);
            float f8 = atF4 - height;
            canvas3.drawLine(f6, f8, f7, f8, this.dma);
        }
    }

    /* renamed from: M */
    private void m20371M(Canvas canvas) {
        canvas.drawRect(C6969a.LEFT.atF(), C6969a.TOP.atF(), C6969a.RIGHT.atF(), C6969a.BOTTOM.atF(), this.dlZ);
    }

    /* renamed from: N */
    private void m20372N(Canvas canvas) {
        float atF = C6969a.LEFT.atF();
        float atF2 = C6969a.TOP.atF();
        float atF3 = C6969a.RIGHT.atF();
        float atF4 = C6969a.BOTTOM.atF();
        float f = (this.dmf - this.dme) / 2.0f;
        float f2 = this.dmf / 2.0f;
        float f3 = atF - f;
        float f4 = atF2 - f2;
        canvas.drawLine(f3, f4, f3, atF2 + this.dmg, this.bbT);
        float f5 = atF2 - f;
        Canvas canvas2 = canvas;
        float f6 = atF - f2;
        canvas2.drawLine(f6, f5, atF + this.dmg, f5, this.bbT);
        float f7 = atF3 + f;
        canvas.drawLine(f7, f4, f7, atF2 + this.dmg, this.bbT);
        float f8 = atF3 + f2;
        Canvas canvas3 = canvas;
        canvas3.drawLine(f8, f5, atF3 - this.dmg, f5, this.bbT);
        float f9 = atF4 + f2;
        canvas3.drawLine(f3, f9, f3, atF4 - this.dmg, this.bbT);
        float f10 = f + atF4;
        float f11 = f10;
        float f12 = f10;
        canvas2.drawLine(f6, f11, atF + this.dmg, f12, this.bbT);
        canvas.drawLine(f7, f9, f7, atF4 - this.dmg, this.bbT);
        canvas2.drawLine(f8, f11, atF3 - this.dmg, f12, this.bbT);
    }

    private boolean atD() {
        if (this.dmo != 2) {
            return this.dmo == 1 && this.dmk != null;
        }
        return true;
    }

    private void atE() {
        if (this.dmp != null) {
            this.dmp.aty();
        }
        if (this.dmk != null) {
            this.dmk = null;
            invalidate();
        }
    }

    /* renamed from: g */
    private void m20373g(RectF rectF) {
        if (!this.dmh) {
            if (!(rectF.width() == 0.0f || rectF.height() == 0.0f)) {
                this.dmh = true;
            }
            if (this.dml) {
                m20374h(rectF);
            } else {
                float width = rectF.width() * 0.0f;
                float height = rectF.height() * 0.0f;
                C6969a.LEFT.mo30658aw(rectF.left + width);
                C6969a.TOP.mo30658aw(rectF.top + height);
                C6969a.RIGHT.mo30658aw(rectF.right - width);
                C6969a.BOTTOM.mo30658aw(rectF.bottom - height);
            }
        }
    }

    private RectF getBitmapRect() {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return new RectF();
        }
        float[] fArr = new float[9];
        getImageMatrix().getValues(fArr);
        float f = fArr[0];
        float f2 = fArr[4];
        float f3 = fArr[2];
        float f4 = fArr[5];
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        int round = Math.round(((float) intrinsicWidth) * f);
        int round2 = Math.round(((float) intrinsicHeight) * f2);
        float max = Math.max(f3, 0.0f);
        float max2 = Math.max(f4, 0.0f);
        return new RectF(max, max2, Math.min(((float) round) + max, (float) getWidth()), Math.min(((float) round2) + max2, (float) getHeight()));
    }

    private float getTargetAspectRatio() {
        return ((float) this.dmm) / ((float) this.dmn);
    }

    /* renamed from: h */
    private void m20374h(RectF rectF) {
        if (C6978a.m20405k(rectF) > getTargetAspectRatio()) {
            float G = C6978a.m20402G(rectF.height(), getTargetAspectRatio()) / 2.0f;
            C6969a.LEFT.mo30658aw(rectF.centerX() - G);
            C6969a.TOP.mo30658aw(rectF.top);
            C6969a.RIGHT.mo30658aw(rectF.centerX() + G);
            C6969a.BOTTOM.mo30658aw(rectF.bottom);
            return;
        }
        float H = C6978a.m20403H(rectF.width(), getTargetAspectRatio());
        C6969a.LEFT.mo30658aw(rectF.left);
        float f = H / 2.0f;
        C6969a.TOP.mo30658aw(rectF.centerY() - f);
        C6969a.RIGHT.mo30658aw(rectF.right);
        C6969a.BOTTOM.mo30658aw(rectF.centerY() + f);
    }

    private void init(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CropImageView, 0, 0);
        this.dmo = obtainStyledAttributes.getInteger(R.styleable.CropImageView_guidelines, 1);
        this.dml = obtainStyledAttributes.getBoolean(R.styleable.CropImageView_fixAspectRatio, false);
        this.dmm = obtainStyledAttributes.getInteger(R.styleable.CropImageView_aspectRatioX, 1);
        this.dmn = obtainStyledAttributes.getInteger(R.styleable.CropImageView_aspectRatioY, 1);
        obtainStyledAttributes.recycle();
        Resources resources = context.getResources();
        this.dlZ = C6982d.m20416f(resources);
        this.dma = C6982d.m20417g(resources);
        this.dmb = C6982d.m20418h(resources);
        this.bbT = C6982d.m20419i(resources);
        this.dmc = resources.getDimension(R.dimen.target_radius);
        this.dmd = resources.getDimension(R.dimen.snap_radius);
        this.dmf = resources.getDimension(R.dimen.border_thickness);
        this.dme = resources.getDimension(R.dimen.corner_thickness);
        this.dmg = resources.getDimension(R.dimen.corner_length);
    }

    /* renamed from: cZ */
    public void mo30644cZ(int i, int i2) {
        this.dmh = false;
        setMinCropLengthPx(i, i2);
    }

    public Bitmap getCroppedImage() {
        Drawable drawable = getDrawable();
        if (drawable == null || !(drawable instanceof BitmapDrawable)) {
            return null;
        }
        float[] fArr = new float[9];
        getImageMatrix().getValues(fArr);
        float f = fArr[0];
        float f2 = fArr[4];
        float f3 = fArr[2];
        float f4 = fArr[5];
        float f5 = 0.0f;
        float abs = f3 < 0.0f ? Math.abs(f3) : 0.0f;
        if (f4 < 0.0f) {
            f5 = Math.abs(f4);
        }
        Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
        float atF = (abs + C6969a.LEFT.atF()) / f;
        float atF2 = (f5 + C6969a.TOP.atF()) / f2;
        return Bitmap.createBitmap(bitmap, (int) atF, (int) atF2, (int) Math.min(C6969a.getWidth() / f, ((float) bitmap.getWidth()) - atF), (int) Math.min(C6969a.getHeight() / f2, ((float) bitmap.getHeight()) - atF2));
    }

    public RectF getCroppedRect() {
        RectF rectF = new RectF();
        rectF.left = (float) ((int) ((C6969a.LEFT.atF() * 10000.0f) / this.dmi.width()));
        rectF.top = (float) ((int) ((C6969a.TOP.atF() * 10000.0f) / this.dmi.height()));
        rectF.right = (float) ((int) ((C6969a.RIGHT.atF() * 10000.0f) / this.dmi.width()));
        rectF.bottom = (float) ((int) ((C6969a.BOTTOM.atF() * 10000.0f) / this.dmi.height()));
        return rectF;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        m20369K(canvas);
        m20370L(canvas);
        m20371M(canvas);
        m20372N(canvas);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.dmi = new RectF(0.0f, 0.0f, (float) (i3 - i), (float) (i4 - i2));
        m20373g(this.dmi);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled()) {
            return false;
        }
        switch (motionEvent.getAction()) {
            case 0:
                m20367D(motionEvent.getX(), motionEvent.getY());
                return true;
            case 1:
            case 3:
                getParent().requestDisallowInterceptTouchEvent(false);
                atE();
                return true;
            case 2:
                m20368E(motionEvent.getX(), motionEvent.getY());
                getParent().requestDisallowInterceptTouchEvent(true);
                return true;
            default:
                return false;
        }
    }

    public void setAspectRatio(int i, int i2) {
        this.dmh = false;
        if (i <= 0 || i2 <= 0) {
            throw new IllegalArgumentException("Cannot set aspect ratio value to a number less than or equal to 0.");
        }
        this.dmm = i;
        this.dmn = i2;
        if (this.dml) {
            requestLayout();
        }
    }

    public void setCropActionCallback(C6968a aVar) {
        this.dmp = aVar;
    }

    public void setFixedAspectRatio(boolean z) {
        this.dml = z;
        requestLayout();
    }

    public void setGuidelines(int i) {
        this.dmo = i;
        invalidate();
    }

    public void setMinCropLengthPx(int i, int i2) {
        C6969a.LEFT.mo30665pG(i);
        C6969a.TOP.mo30665pG(i);
        C6969a.RIGHT.mo30665pG(i);
        C6969a.BOTTOM.mo30665pG(i);
        C6969a.LEFT.mo30664pF(i2);
        C6969a.TOP.mo30664pF(i2);
        C6969a.RIGHT.mo30664pF(i2);
        C6969a.BOTTOM.mo30664pF(i2);
    }
}
