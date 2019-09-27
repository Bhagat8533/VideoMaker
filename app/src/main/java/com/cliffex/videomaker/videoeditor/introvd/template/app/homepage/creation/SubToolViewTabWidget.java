package com.introvd.template.app.homepage.creation;

import android.content.Context;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.introvd.template.p203b.C4583d;
import com.quvideo.mobile.component.imageview.XYImageView;

public class SubToolViewTabWidget extends RelativeLayout {
    private int brT = Color.parseColor("#DDDDDD");
    private int brU = Color.parseColor("#ff7044");
    private int brV = 0;
    private XYImageView brW;
    private int brX;
    private int brY;

    public SubToolViewTabWidget(Context context) {
        super(context);
    }

    public SubToolViewTabWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SubToolViewTabWidget(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    private int getFocusColor() {
        return this.brU;
    }

    private int getUnFocusColor() {
        return this.brT;
    }

    /* renamed from: gN */
    public void mo23501gN(int i) {
        this.brY = i;
        int O = C4583d.m11670O(getContext(), 40);
        int O2 = C4583d.m11670O(getContext(), 2);
        removeAllViews();
        View view = new View(getContext());
        addView(view, new LayoutParams(O, O2));
        view.setBackgroundColor(getUnFocusColor());
        this.brW = new XYImageView(getContext());
        if (this.brV > 0) {
            this.brW.setCornerRadius((float) this.brV);
        }
        int i2 = (O * 4) / this.brY;
        addView(this.brW, new LayoutParams(i2, O2));
        this.brW.setBackgroundColor(getFocusColor());
        this.brX = O - i2;
    }

    public float getStepProgress() {
        return (float) (100 / (this.brY - 4));
    }

    public void setFocusColor(int i) {
        this.brU = i;
    }

    public void setProgress(float f) {
        if (this.brW != null) {
            LayoutParams layoutParams = (LayoutParams) this.brW.getLayoutParams();
            if (VERSION.SDK_INT >= 17) {
                layoutParams.setMarginStart((int) ((((float) this.brX) * Math.min(f + 0.5f, 100.0f)) / 100.0f));
            } else {
                layoutParams.leftMargin = (int) ((((float) this.brX) * Math.min(f + 0.5f, 100.0f)) / 100.0f);
            }
            requestLayout();
        }
    }

    public void setThumbCornerRadius(int i) {
        this.brV = i;
    }

    public void setUnFocusColor(int i) {
        this.brT = i;
    }
}
