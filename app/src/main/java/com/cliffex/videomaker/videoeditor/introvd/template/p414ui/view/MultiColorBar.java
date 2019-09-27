package com.introvd.template.p414ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.introvd.template.p203b.C4583d;
import xiaoying.quvideo.com.vivabase.C10122R;

/* renamed from: com.introvd.template.ui.view.MultiColorBar */
public class MultiColorBar extends View {
    private static int[] COLORS = {-16777216, -16777215, -1, -2, -12829636, -6710887, -1491155, -37313, -26305, -18119, -262884, -460677, -65597, -3866832, -8920808, -16731392, -16722817, -16714796, -16731404, -16221459, -11776257, -9286401, -6923521, -3046913, -24833, -37737, -1622185, -4587520};
    private static int STATUS;
    private int aeD;
    Paint borderPaint = new Paint();
    private int cNi;
    Paint cna = new Paint();

    /* renamed from: eM */
    private int f3625eM = 30;
    private int erY;
    private int eyA;
    C8981a eyB;
    private int eyn = 20;
    private int eyo;
    private int eyp;
    private int eyq;
    private int eyr;
    private int eys;
    private int eyt = this.f3625eM;
    private int eyu;
    private int eyv;
    private int eyw;
    private boolean eyx = false;
    private boolean eyy = false;
    Paint eyz = new Paint();
    private int padding;

    /* renamed from: com.introvd.template.ui.view.MultiColorBar$a */
    public interface C8981a {
        /* renamed from: g */
        void mo27671g(int i, float f);

        /* renamed from: kW */
        void mo27672kW(int i);
    }

    public MultiColorBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setLayerType(1, null);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C10122R.styleable.VS_ColorBarAppearance, 0, 0);
            this.f3625eM = obtainStyledAttributes.getDimensionPixelSize(C10122R.styleable.VS_ColorBarAppearance_color_bar_CircleRadius, this.f3625eM);
            this.eyp = obtainStyledAttributes.getDimensionPixelSize(C10122R.styleable.VS_ColorBarAppearance_color_bar_ThumbRadius, 0);
            this.eyq = obtainStyledAttributes.getColor(C10122R.styleable.VS_ColorBarAppearance_color_bar_StrokeColor, 0);
            this.eyr = obtainStyledAttributes.getDimensionPixelSize(C10122R.styleable.VS_ColorBarAppearance_color_bar_StrokeWidth, 0);
            this.aeD = obtainStyledAttributes.getDimensionPixelSize(C10122R.styleable.VS_ColorBarAppearance_color_bar_ThumbWidth, 0);
            this.erY = obtainStyledAttributes.getDimensionPixelSize(C10122R.styleable.VS_ColorBarAppearance_color_bar_ThumbHeight, 0);
            this.eys = obtainStyledAttributes.getDimensionPixelSize(C10122R.styleable.VS_ColorBarAppearance_color_bar_ThumbMarginBottom, 0);
            this.eyn = obtainStyledAttributes.getDimensionPixelSize(C10122R.styleable.VS_ColorBarAppearance_color_bar_height, 0);
            this.eyy = obtainStyledAttributes.getBoolean(C10122R.styleable.VS_ColorBarAppearance_color_bar_Thumb_visible, false);
            obtainStyledAttributes.recycle();
        }
        this.padding = C4583d.m11671P(15.0f);
        this.eyw = C4583d.m11671P(5.0f);
        init();
    }

    /* renamed from: U */
    private void m26354U(Canvas canvas) {
        this.cNi = (this.eyo - (this.padding * 2)) / COLORS.length;
        this.padding = (this.eyo - (this.cNi * COLORS.length)) / 2;
        this.eyu = this.padding;
        Drawable drawable = getResources().getDrawable(C10122R.C10123drawable.editor_edit_multi_color_bar);
        Rect rect = new Rect();
        rect.left = this.eyu;
        rect.top = this.eyv + this.aeD + this.eys;
        rect.right = this.eyo - this.padding;
        rect.bottom = this.eyv + this.eyn + this.aeD + this.eys;
        drawable.setBounds(rect);
        drawable.draw(canvas);
    }

    /* renamed from: V */
    private void m26355V(Canvas canvas) {
        this.cna.setColor(this.eyA);
        canvas.drawOval(getCircleRect(), this.cna);
        canvas.drawOval(m26358m(getCircleRect()), this.borderPaint);
    }

    /* renamed from: f */
    private void m26356f(Canvas canvas, int i) {
        this.cna.setColor(this.eyA);
        canvas.drawOval(m26359vD(i), this.cna);
        if (i == 0 || i == 1) {
            canvas.drawOval(m26358m(m26359vD(i)), this.borderPaint);
        }
    }

    /* renamed from: g */
    private void m26357g(Canvas canvas, int i) {
        this.eyz.setColor(this.eyA);
        canvas.drawRoundRect(m26360vE(i), 5.0f, 5.0f, this.eyz);
        canvas.drawRoundRect(m26358m(m26360vE(i)), 5.0f, 5.0f, this.borderPaint);
    }

    private RectF getCircleRect() {
        return new RectF((float) (this.eyt - this.f3625eM), (float) (((this.eyv + (this.eyn / 2)) - this.f3625eM) + this.aeD + this.eys), (float) (this.eyt + this.f3625eM), (float) (this.eyv + (this.eyn / 2) + this.f3625eM + this.aeD + this.eys));
    }

    private int getCurrentColorIndex() {
        int length = (this.eyt - this.f3625eM) / (this.eyo / COLORS.length);
        return length > COLORS.length + -1 ? COLORS.length - 1 : length;
    }

    private void init() {
        this.eyz.setAntiAlias(true);
        this.cna.setAntiAlias(true);
        this.borderPaint.setStyle(Style.STROKE);
        this.borderPaint.setStrokeWidth((float) C4583d.m11671P(1.5f));
        this.borderPaint.setAntiAlias(true);
        this.borderPaint.setColor(-2130706433);
        this.eyA = COLORS[0];
        STATUS = 0;
        invalidate();
    }

    /* renamed from: m */
    private RectF m26358m(RectF rectF) {
        int P = C4583d.m11671P(1.5f) / 2;
        RectF rectF2 = new RectF(rectF);
        float f = (float) P;
        rectF2.inset(f, f);
        return rectF2;
    }

    /* renamed from: vD */
    private RectF m26359vD(int i) {
        int i2 = i + 1;
        return new RectF((float) (((this.eyu + (this.cNi * i2)) - (this.cNi / 2)) - this.f3625eM), (float) (((this.eyv + (this.eyn / 2)) - this.f3625eM) + this.aeD + this.eys), (float) (((this.eyu + (this.cNi * i2)) - (this.cNi / 2)) + this.f3625eM), (float) (this.eyv + (this.eyn / 2) + this.f3625eM + this.aeD + this.eys));
    }

    /* renamed from: vE */
    private RectF m26360vE(int i) {
        int i2 = i + 1;
        return new RectF((float) (((this.eyu + (this.cNi * i2)) - (this.cNi / 2)) - (this.aeD / 2)), (float) this.eyw, (float) (((this.eyu + (this.cNi * i2)) - (this.cNi / 2)) + (this.aeD / 2)), (float) (this.eyw + this.aeD));
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        switch (STATUS) {
            case 0:
                m26354U(canvas);
                if (this.eyA == 0) {
                    m26355V(canvas);
                    break;
                } else {
                    boolean z = false;
                    int i = 0;
                    while (true) {
                        if (i < COLORS.length - 1) {
                            if (this.eyA == COLORS[i]) {
                                m26356f(canvas, i);
                                z = true;
                            } else {
                                i++;
                            }
                        }
                    }
                    if (!z) {
                        this.eyA = -1;
                        m26356f(canvas, 2);
                        break;
                    }
                }
                break;
            case 1:
                m26354U(canvas);
                int currentColorIndex = getCurrentColorIndex();
                this.eyA = COLORS[currentColorIndex];
                if (this.eyx) {
                    if (this.eyB != null) {
                        this.eyB.mo27672kW(this.eyA);
                    }
                } else if (this.eyy) {
                    m26357g(canvas, currentColorIndex);
                }
                m26356f(canvas, currentColorIndex);
                int i2 = (this.cNi * (currentColorIndex + 1)) - (this.cNi / 2);
                if (this.eyB != null) {
                    this.eyB.mo27671g(this.eyA, (float) i2);
                    break;
                }
                break;
        }
        super.onDraw(canvas);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        this.eyo = i;
        this.eyu = this.padding;
        this.eyv = 0;
        super.onSizeChanged(i, i2, i3, i4);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.eyt = (int) motionEvent.getX();
                if (this.eyt <= this.f3625eM) {
                    this.eyt = this.f3625eM;
                }
                if (this.eyt >= this.eyo + this.f3625eM) {
                    this.eyt = this.eyo + this.f3625eM;
                }
                STATUS = 1;
                this.eyx = false;
                break;
            case 1:
                this.eyx = true;
                break;
            case 2:
                this.eyt = (int) motionEvent.getX();
                if (this.eyt <= this.f3625eM) {
                    this.eyt = this.f3625eM;
                }
                if (this.eyt >= this.eyo + this.f3625eM) {
                    this.eyt = this.eyo + this.f3625eM;
                }
                this.eyx = false;
                break;
        }
        invalidate();
        return true;
    }

    public void setCurColor(int i) {
        STATUS = 0;
        if (i == 0 || i == -1) {
            this.eyA = -1;
        } else {
            this.eyA = i;
        }
        invalidate();
    }

    public void setHeight(int i) {
        int i2 = i / 2;
        this.eyn = i2;
        this.f3625eM = i2;
    }

    public void setOnColorChangerListener(C8981a aVar) {
        this.eyB = aVar;
    }
}
