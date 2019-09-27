package com.introvd.template.component.videofetcher.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.introvd.template.component.videofetcher.R;

public class RoundedTextView extends TextView {
    int bYZ;
    int cnd;
    ColorStateList cne;
    ColorStateList cnf;
    Orientation cng;
    int[] cnh;
    C5507e cni;

    public RoundedTextView(Context context) {
        super(context);
    }

    public RoundedTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m14929b(attributeSet, 0);
    }

    public RoundedTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m14929b(attributeSet, i);
    }

    private void aaI() {
        GradientDrawable gradientDrawable = (this.cng == null || this.cnh == null) ? new GradientDrawable() : new GradientDrawable(this.cng, this.cnh);
        if (this.cne != null) {
            gradientDrawable.setStroke(this.bYZ, isEnabled() ? this.cne.getColorForState(View.PRESSED_ENABLED_STATE_SET, this.cne.getDefaultColor()) : this.cne.getDefaultColor());
        }
        gradientDrawable.setCornerRadius((float) this.cnd);
        if (this.cng == null) {
            if (this.cnf == null) {
                gradientDrawable.setColor(0);
            } else if (isPressed()) {
                gradientDrawable.setColor(this.cnf.getColorForState(View.PRESSED_ENABLED_STATE_SET, this.cnf.getDefaultColor()));
            } else if (isSelected()) {
                gradientDrawable.setColor(this.cnf.getColorForState(View.ENABLED_SELECTED_STATE_SET, this.cnf.getDefaultColor()));
            } else if (isEnabled()) {
                gradientDrawable.setColor(this.cnf.getColorForState(View.ENABLED_STATE_SET, this.cnf.getDefaultColor()));
            } else {
                gradientDrawable.setColor(this.cnf.getDefaultColor());
            }
        }
        setBackgroundDrawable(gradientDrawable);
    }

    /* renamed from: b */
    private void m14929b(AttributeSet attributeSet, int i) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.VS_RoundedAppearance, i, 0);
            this.cnd = obtainStyledAttributes.getDimensionPixelSize(R.styleable.VS_RoundedAppearance_VS_CornerRadius, 0);
            this.cne = obtainStyledAttributes.getColorStateList(R.styleable.VS_RoundedAppearance_VS_StrokeColor);
            this.bYZ = obtainStyledAttributes.getDimensionPixelSize(R.styleable.VS_RoundedAppearance_VS_StrokeWidth, 0);
            this.cnf = obtainStyledAttributes.getColorStateList(R.styleable.VS_RoundedAppearance_VS_SolidColor);
            obtainStyledAttributes.recycle();
            GradientDrawable gradientDrawable = new GradientDrawable();
            if (this.cne != null) {
                gradientDrawable.setStroke(this.bYZ, this.cne.getDefaultColor());
            }
            gradientDrawable.setCornerRadius((float) this.cnd);
            if (this.cnf != null) {
                gradientDrawable.setColor(this.cnf.getDefaultColor());
            }
            setBackgroundDrawable(gradientDrawable);
        }
    }

    public void draw(Canvas canvas) {
        if (this.cni != null) {
            this.cni.draw(canvas);
        }
        super.draw(canvas);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        aaI();
        super.onDraw(canvas);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.cni != null) {
            this.cni.onSizeChanged(i, i2, i3, i4);
        }
    }

    public void setCornerRadius(int i) {
        this.cnd = i;
    }

    public void setGradientBg(Orientation orientation, int[] iArr) {
        this.cng = orientation;
        this.cnh = iArr;
        aaI();
    }

    public void setRippleColor(int i) {
        if (this.cni != null) {
            this.cni.setRippleColor(i);
        }
    }

    public void setRippleRoundedCorner(int i) {
        if (this.cni != null) {
            this.cni.setRippleRoundedCorners(i);
        }
    }

    public void setSolidColor(int i) {
        this.cnf = ColorStateList.valueOf(i);
    }

    public void setSolidColor(ColorStateList colorStateList) {
        this.cnf = colorStateList;
        aaI();
    }

    public void setStrokeColor(int i) {
        this.cne = ColorStateList.valueOf(i);
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        this.cne = colorStateList;
        aaI();
    }
}
