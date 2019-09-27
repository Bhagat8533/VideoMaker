package com.introvd.template.common.p236ui;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.p024v7.widget.AppCompatCheckBox;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import com.introvd.template.p203b.C4580b;
import xiaoying.quvideo.com.vivabase.C10122R;

/* renamed from: com.introvd.template.common.ui.Switch */
public class Switch extends AppCompatCheckBox {

    /* renamed from: oW */
    private static final int[] f3451oW = {16842912};

    /* renamed from: Zc */
    private int f3452Zc;
    private float aeA;
    private int aeB;
    private int aeC;
    private int aeD;
    private int aeE;
    private int aeF;
    private int aeG;
    private int aeH;
    private TextPaint aeI;
    private ColorStateList aeJ;
    private Layout aeK;
    private Layout aeL;
    private Drawable aeg;
    private Drawable ael;
    private int aeq;
    private int aer;
    private int aes;
    private CharSequence aeu;
    private CharSequence aev;
    private int aex;
    private float aey;
    private float aez;
    private int mAlpha;
    private final Rect mTempRect;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;

    public Switch(Context context) {
        this(context, null);
    }

    public Switch(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C10122R.style.xiaoying_str_com_setting_switcher);
    }

    public Switch(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mVelocityTracker = VelocityTracker.obtain();
        this.mTempRect = new Rect();
        this.mAlpha = 255;
        this.aeI = new TextPaint(1);
        Resources resources = getResources();
        this.aeI.density = resources.getDisplayMetrics().density;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C10122R.styleable.XY_Switch, i, 0);
        this.aeg = obtainStyledAttributes.getDrawable(C10122R.styleable.XY_Switch_XY_SwitchThumb);
        this.ael = obtainStyledAttributes.getDrawable(C10122R.styleable.XY_Switch_XY_Track);
        this.aeu = obtainStyledAttributes.getText(C10122R.styleable.XY_Switch_XY_TextOn);
        this.aev = obtainStyledAttributes.getText(C10122R.styleable.XY_Switch_XY_TextOff);
        this.aeq = obtainStyledAttributes.getDimensionPixelSize(C10122R.styleable.XY_Switch_XY_ThumbTextPadding, 0);
        this.aer = obtainStyledAttributes.getDimensionPixelSize(C10122R.styleable.XY_Switch_XY_SwitchMinWidth, 0);
        this.aes = obtainStyledAttributes.getDimensionPixelSize(C10122R.styleable.XY_Switch_XY_SwitchPadding, 0);
        int resourceId = obtainStyledAttributes.getResourceId(C10122R.styleable.XY_Switch_XY_SwitchTextAppearance, 0);
        obtainStyledAttributes.recycle();
        if (resourceId != 0) {
            setSwitchTextAppearance(context, resourceId);
        }
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.f3452Zc = viewConfiguration.getScaledMinimumFlingVelocity();
        refreshDrawableState();
        setChecked(isChecked());
    }

    /* renamed from: aO */
    private void m14440aO(int i, int i2) {
        Typeface typeface;
        switch (i) {
            case 1:
                typeface = Typeface.SANS_SERIF;
                break;
            case 2:
                typeface = Typeface.SERIF;
                break;
            case 3:
                typeface = Typeface.MONOSPACE;
                break;
            default:
                typeface = null;
                break;
        }
        setSwitchTypeface(typeface, i2);
    }

    /* renamed from: aq */
    private void m14441aq(boolean z) {
        setChecked(z);
    }

    /* renamed from: g */
    private void m14442g(MotionEvent motionEvent) {
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.setAction(3);
        super.onTouchEvent(obtain);
        obtain.recycle();
    }

    private boolean getTargetCheckedState() {
        return this.aeA >= ((float) (getThumbScrollRange() / 2));
    }

    private int getThumbScrollRange() {
        if (this.ael == null) {
            return 0;
        }
        this.ael.getPadding(this.mTempRect);
        return ((this.aeB - this.aeD) - this.mTempRect.left) - this.mTempRect.right;
    }

    /* renamed from: h */
    private void m14443h(MotionEvent motionEvent) {
        boolean z = false;
        this.aex = 0;
        boolean z2 = motionEvent.getAction() == 1 && isEnabled();
        m14442g(motionEvent);
        if (z2) {
            this.mVelocityTracker.computeCurrentVelocity(1000);
            float xVelocity = this.mVelocityTracker.getXVelocity();
            if (Math.abs(xVelocity) <= ((float) this.f3452Zc)) {
                z = getTargetCheckedState();
            } else if (xVelocity > 0.0f) {
                z = true;
            }
            m14441aq(z);
            return;
        }
        m14441aq(isChecked());
    }

    /* renamed from: m */
    private boolean m14444m(float f, float f2) {
        this.aeg.getPadding(this.mTempRect);
        int i = (this.aeE + ((int) (this.aeA + 0.5f))) - this.mTouchSlop;
        return f > ((float) i) && f < ((float) ((((this.aeD + i) + this.mTempRect.left) + this.mTempRect.right) + this.mTouchSlop)) && f2 > ((float) (this.aeF - this.mTouchSlop)) && f2 < ((float) (this.aeH + this.mTouchSlop));
    }

    /* renamed from: o */
    private Layout m14445o(CharSequence charSequence) {
        StaticLayout staticLayout = new StaticLayout(charSequence, this.aeI, (int) Math.ceil((double) Layout.getDesiredWidth(charSequence, this.aeI)), Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
        return staticLayout;
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        if (this.aeg != null) {
            this.aeg.setState(drawableState);
        }
        if (this.ael != null) {
            this.ael.setState(drawableState);
        }
        invalidate();
    }

    public int getCompoundPaddingRight() {
        int compoundPaddingRight = super.getCompoundPaddingRight() + this.aeB;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingRight + this.aes : compoundPaddingRight;
    }

    public CharSequence getTextOff() {
        return this.aev;
    }

    public CharSequence getTextOn() {
        return this.aeu;
    }

    /* access modifiers changed from: protected */
    public int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (isChecked()) {
            mergeDrawableStates(onCreateDrawableState, f3451oW);
        }
        return onCreateDrawableState;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        int i;
        int i2;
        super.onDraw(canvas);
        int i3 = this.aeE;
        int i4 = this.aeF;
        int i5 = this.aeG;
        int i6 = this.aeH;
        this.ael.setBounds(i3, i4, i5, i6);
        this.ael.setAlpha(this.mAlpha);
        this.ael.draw(canvas);
        canvas.save();
        this.ael.getPadding(this.mTempRect);
        int i7 = this.mTempRect.left + i3;
        int i8 = this.mTempRect.top + i4;
        int i9 = i5 - this.mTempRect.right;
        int i10 = i6 - this.mTempRect.bottom;
        canvas.clipRect(i7, i4, i9, i6);
        this.aeg.getPadding(this.mTempRect);
        int i11 = (int) (this.aeA + 0.5f);
        if (C4580b.m11666qi()) {
            i = ((i9 - i11) - this.aeD) - this.mTempRect.left;
            i2 = i5 - i11;
        } else {
            i = i3 + i11;
            i2 = i7 + i11 + this.aeD + this.mTempRect.right;
        }
        this.aeg.setBounds(i, i4, i2, i6);
        this.aeg.setAlpha(this.mAlpha);
        this.aeg.draw(canvas);
        if (this.aeJ != null) {
            this.aeI.setColor(this.aeJ.getColorForState(getDrawableState(), this.aeJ.getDefaultColor()));
        }
        this.aeI.drawableState = getDrawableState();
        Layout layout = getTargetCheckedState() ? this.aeK : this.aeL;
        canvas.translate((float) (((i + i2) / 2) - (layout.getWidth() / 2)), (float) (((i8 + i10) / 2) - (layout.getHeight() / 2)));
        layout.draw(canvas);
        canvas.restore();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        super.onLayout(z, i, i2, i3, i4);
        this.aeA = isChecked() ? (float) getThumbScrollRange() : 0.0f;
        int width = getWidth() - getPaddingRight();
        int i7 = width - this.aeB;
        int gravity = getGravity() & 112;
        if (gravity == 16) {
            i6 = (((getPaddingTop() + getHeight()) - getPaddingBottom()) / 2) - (this.aeC / 2);
            i5 = this.aeC + i6;
        } else if (gravity != 80) {
            i6 = getPaddingTop();
            i5 = this.aeC + i6;
        } else {
            i5 = getHeight() - getPaddingBottom();
            i6 = i5 - this.aeC;
        }
        this.aeE = i7;
        this.aeF = i6;
        this.aeH = i5;
        this.aeG = width;
    }

    public void onMeasure(int i, int i2) {
        int mode = MeasureSpec.getMode(i);
        int mode2 = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        if (this.aeK == null) {
            this.aeK = m14445o(this.aeu);
        }
        if (this.aeL == null) {
            this.aeL = m14445o(this.aev);
        }
        this.ael.getPadding(this.mTempRect);
        int max = Math.max(this.aeK.getWidth(), this.aeL.getWidth());
        int max2 = Math.max(this.aer, (max * 2) + (this.aeq * 4) + this.mTempRect.left + this.mTempRect.right);
        int intrinsicHeight = this.ael.getIntrinsicHeight();
        this.aeD = max + (this.aeq * 2);
        if (mode == Integer.MIN_VALUE) {
            Math.min(size, max2);
        }
        if (mode2 == Integer.MIN_VALUE) {
            Math.min(size2, intrinsicHeight);
        }
        this.aeB = max2;
        this.aeC = intrinsicHeight;
        super.onMeasure(i, i2);
        if (getMeasuredHeight() < intrinsicHeight) {
            setMeasuredDimension(getMeasuredWidth(), intrinsicHeight);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.mVelocityTracker.addMovement(motionEvent);
        switch (motionEvent.getActionMasked()) {
            case 0:
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                if (isEnabled() && m14444m(x, y)) {
                    this.aex = 1;
                    this.aey = x;
                    this.aez = y;
                    break;
                }
            case 1:
            case 3:
                if (this.aex != 2) {
                    this.aex = 0;
                    this.mVelocityTracker.clear();
                    break;
                } else {
                    m14443h(motionEvent);
                    return true;
                }
            case 2:
                switch (this.aex) {
                    case 1:
                        float x2 = motionEvent.getX();
                        float y2 = motionEvent.getY();
                        if (Math.abs(x2 - this.aey) > ((float) this.mTouchSlop) || Math.abs(y2 - this.aez) > ((float) this.mTouchSlop)) {
                            this.aex = 2;
                            getParent().requestDisallowInterceptTouchEvent(true);
                            this.aey = x2;
                            this.aez = y2;
                            return true;
                        }
                    case 2:
                        float x3 = motionEvent.getX();
                        float max = Math.max(0.0f, Math.min(this.aeA + (x3 - this.aey), (float) getThumbScrollRange()));
                        if (max != this.aeA) {
                            this.aeA = max;
                            this.aey = x3;
                            invalidate();
                        }
                        return true;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setAlpha(int i) {
        this.mAlpha = i;
        invalidate();
    }

    public void setChecked(boolean z) {
        super.setChecked(z);
        this.aeA = z ? (float) getThumbScrollRange() : 0.0f;
        invalidate();
    }

    public final void setSwitchTextAppearance(Context context, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i, C10122R.styleable.XY_TextAppearance);
        ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(C10122R.styleable.XY_TextAppearance_XY_TextColor);
        if (colorStateList != null) {
            this.aeJ = colorStateList;
        } else {
            this.aeJ = getTextColors();
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(C10122R.styleable.XY_TextAppearance_XY_TextSize, 0);
        if (dimensionPixelSize != 0) {
            float f = (float) dimensionPixelSize;
            if (f != this.aeI.getTextSize()) {
                this.aeI.setTextSize(f);
                requestLayout();
            }
        }
        m14440aO(obtainStyledAttributes.getInt(C10122R.styleable.XY_TextAppearance_XY_Typeface, -1), obtainStyledAttributes.getInt(C10122R.styleable.XY_TextAppearance_XY_TextStyle, -1));
        obtainStyledAttributes.recycle();
    }

    public void setSwitchTypeface(Typeface typeface) {
        if (this.aeI.getTypeface() != typeface) {
            this.aeI.setTypeface(typeface);
            requestLayout();
            invalidate();
        }
    }

    public void setSwitchTypeface(Typeface typeface, int i) {
        float f = 0.0f;
        boolean z = false;
        if (i > 0) {
            Typeface defaultFromStyle = typeface == null ? Typeface.defaultFromStyle(i) : Typeface.create(typeface, i);
            setSwitchTypeface(defaultFromStyle);
            int i2 = (~(defaultFromStyle != null ? defaultFromStyle.getStyle() : 0)) & i;
            TextPaint textPaint = this.aeI;
            if ((i2 & 1) != 0) {
                z = true;
            }
            textPaint.setFakeBoldText(z);
            TextPaint textPaint2 = this.aeI;
            if ((i2 & 2) != 0) {
                f = -0.25f;
            }
            textPaint2.setTextSkewX(f);
            return;
        }
        this.aeI.setFakeBoldText(false);
        this.aeI.setTextSkewX(0.0f);
        setSwitchTypeface(typeface);
    }

    public void setTextOff(CharSequence charSequence) {
        this.aev = charSequence;
        requestLayout();
    }

    public void setTextOn(CharSequence charSequence) {
        this.aeu = charSequence;
        requestLayout();
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.aeg || drawable == this.ael;
    }
}
