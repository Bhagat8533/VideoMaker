package com.introvd.template.xyui;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.introvd.template.ui.widget.R;

public class RoundedRelativeLayout extends RelativeLayout {
    int bYZ;
    int cnd;
    ColorStateList cne;
    ColorStateList cnf;

    public RoundedRelativeLayout(Context context) {
        super(context);
    }

    public RoundedRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m26599b(attributeSet, 0);
    }

    public RoundedRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m26599b(attributeSet, i);
    }

    private void aaI() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        if (this.cne != null) {
            gradientDrawable.setStroke(this.bYZ, isPressed() ? this.cne.getColorForState(View.PRESSED_ENABLED_STATE_SET, this.cne.getDefaultColor()) : this.cne.getDefaultColor());
        }
        gradientDrawable.setCornerRadius((float) this.cnd);
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
        setBackgroundDrawable(gradientDrawable);
    }

    /* renamed from: b */
    private void m26599b(AttributeSet attributeSet, int i) {
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

    public void setSolidColor(int i) {
        this.cnf = ColorStateList.valueOf(i);
        aaI();
    }

    public void setStrokeColor(int i) {
        this.cne = ColorStateList.valueOf(i);
        aaI();
    }
}
