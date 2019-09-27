package com.introvd.template.xyui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

public class BadgeHelper extends View {
    private int bottomMargin;
    private Paint dJY;
    private float density;
    private Paint dnF;
    private boolean eBR;
    private int eBS = -53746;
    private int eBT;
    private boolean eBU;
    private boolean eBV;
    private boolean eBW;
    private boolean eBX = false;
    private int leftMargin;
    private int number;
    private final RectF rect = new RectF();
    private int rightMargin;
    private String text = "0";
    private int textColor = -1;
    private float textSize;
    private int topMargin;
    private int type = 0;

    /* renamed from: w */
    private int f3674w;

    public BadgeHelper(Context context) {
        super(context);
    }

    /* renamed from: ar */
    private void m26587ar(int i, boolean z) {
        this.type = i;
        this.eBR = z;
        this.density = getResources().getDisplayMetrics().density;
        switch (i) {
            case 0:
                this.dJY = new Paint();
                this.dJY.setStyle(Style.FILL);
                this.dJY.setFlags(1);
                this.dJY.setColor(this.eBS);
                int round = Math.round(this.density * 7.0f);
                this.eBT = round;
                this.f3674w = round;
                return;
            case 1:
                this.dJY = new Paint();
                this.dJY.setStyle(Style.FILL);
                this.dJY.setFlags(1);
                this.dJY.setColor(this.eBS);
                this.dnF = new Paint();
                this.dnF.setStyle(Style.FILL);
                this.dnF.setFlags(1);
                this.dnF.setColor(this.textColor);
                if (this.textSize == 0.0f) {
                    this.dnF.setTextSize(this.density * 10.0f);
                } else {
                    this.dnF.setTextSize(this.textSize);
                }
                int round2 = Math.round(m26588b("99", this.dnF) * 1.4f);
                this.eBT = round2;
                this.f3674w = round2;
                return;
            default:
                return;
        }
    }

    /* renamed from: b */
    private float m26588b(String str, Paint paint) {
        return paint.measureText(str, 0, str.length());
    }

    /* renamed from: c */
    private float m26589c(String str, Paint paint) {
        Rect rect2 = new Rect();
        paint.getTextBounds(str, 0, str.length(), rect2);
        return (float) rect2.height();
    }

    /* renamed from: G */
    public BadgeHelper mo36027G(boolean z, boolean z2) {
        this.eBR = z;
        this.eBV = z2;
        return this;
    }

    public BadgeHelper aNQ() {
        this.eBW = true;
        return this;
    }

    /* renamed from: do */
    public void mo36029do(View view) {
        m26587ar(this.type, this.eBR);
        if (getParent() != null) {
            ((ViewGroup) getParent()).removeView(this);
        }
        if (view != null) {
            if (view.getParent() instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view.getParent();
                int indexOfChild = viewGroup.indexOfChild(view);
                viewGroup.removeView(view);
                if (this.eBR) {
                    FrameLayout frameLayout = new FrameLayout(getContext());
                    LayoutParams layoutParams = view.getLayoutParams();
                    frameLayout.setLayoutParams(layoutParams);
                    if (this.eBX) {
                        view.setLayoutParams(new LayoutParams(-2, -2));
                    }
                    viewGroup.addView(frameLayout, indexOfChild, layoutParams);
                    frameLayout.addView(view);
                    frameLayout.addView(this);
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) getLayoutParams();
                    if (this.eBW) {
                        layoutParams2.gravity = 16;
                    } else {
                        layoutParams2.gravity = 8388661;
                    }
                    if (this.eBV) {
                        layoutParams2.rightMargin = view.getPaddingRight() - this.f3674w;
                        layoutParams2.topMargin = view.getPaddingTop() - (this.eBT / 2);
                    }
                    setLayoutParams(layoutParams2);
                } else {
                    LinearLayout linearLayout = new LinearLayout(getContext());
                    linearLayout.setOrientation(0);
                    viewGroup.addView(linearLayout, indexOfChild, view.getLayoutParams());
                    if (this.eBX) {
                        view.setLayoutParams(new LayoutParams(-2, -2));
                    }
                    linearLayout.addView(view);
                    linearLayout.addView(this);
                    if (this.eBW) {
                        linearLayout.setGravity(16);
                    }
                }
                if ((this.leftMargin > 0 || this.topMargin > 0 || this.rightMargin > 0 || this.bottomMargin > 0) && (getLayoutParams() instanceof MarginLayoutParams)) {
                    MarginLayoutParams marginLayoutParams = (MarginLayoutParams) getLayoutParams();
                    marginLayoutParams.setMargins(this.leftMargin, this.topMargin, this.rightMargin, this.bottomMargin);
                    setLayoutParams(marginLayoutParams);
                }
                this.eBU = true;
            } else if (view.getParent() == null) {
                throw new IllegalStateException("parent view can't be null !");
            }
            if (this.type == 1) {
                if (this.number == 0) {
                    setVisibility(4);
                } else {
                    setVisibility(0);
                }
            }
            invalidate();
        }
    }

    /* renamed from: jO */
    public BadgeHelper mo36030jO(boolean z) {
        return mo36027G(z, false);
    }

    /* renamed from: jP */
    public BadgeHelper mo36031jP(boolean z) {
        this.eBX = z;
        return this;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.rect.left = 0.0f;
        this.rect.top = 0.0f;
        this.rect.right = (float) getWidth();
        this.rect.bottom = (float) getHeight();
        canvas.drawRoundRect(this.rect, (float) (getWidth() / 2), (float) (getWidth() / 2), this.dJY);
        if (this.type == 1) {
            canvas.drawText(this.text, ((float) (getWidth() / 2)) - (m26588b(this.text, this.dnF) / 2.0f), ((float) (getHeight() / 2)) + (m26589c(this.text, this.dnF) / 2.0f), this.dnF);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        if (this.f3674w <= 0 || this.eBT <= 0) {
            throw new IllegalStateException("width and height unavailable!");
        }
        setMeasuredDimension(this.f3674w, this.eBT);
    }

    public void setBadgeEnable(boolean z) {
        setVisibility(z ? 0 : 4);
    }

    public void setBadgeNumber(int i) {
        this.number = i;
        this.text = String.valueOf(i);
        if (this.eBU) {
            if (i == 0) {
                setVisibility(4);
            } else {
                setVisibility(0);
            }
            invalidate();
        }
    }

    /* renamed from: v */
    public BadgeHelper mo36036v(int i, int i2, int i3, int i4) {
        this.leftMargin = i;
        this.topMargin = i2;
        this.rightMargin = i3;
        this.bottomMargin = i4;
        return this;
    }

    /* renamed from: vM */
    public BadgeHelper mo36037vM(int i) {
        this.type = i;
        return this;
    }
}
