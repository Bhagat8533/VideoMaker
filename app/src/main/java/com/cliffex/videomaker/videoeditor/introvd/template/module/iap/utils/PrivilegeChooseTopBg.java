package com.introvd.template.module.iap.utils;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.p024v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import com.introvd.template.module.p339c.C7689a;

public class PrivilegeChooseTopBg extends AppCompatImageView {
    private int dVY = C7689a.m22595P(2.0f);
    private int dVZ = C7689a.m22595P(5.0f);
    private RectF dWa = new RectF();
    private RectF dWb = new RectF();
    private RectF dWc = new RectF();
    private RectF dWd = new RectF();
    private Path dWe = new Path();

    public PrivilegeChooseTopBg(Context context) {
        super(context);
    }

    public PrivilegeChooseTopBg(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PrivilegeChooseTopBg(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (isInEditMode()) {
            super.onDraw(canvas);
            return;
        }
        int width = getWidth();
        int height = getHeight();
        this.dWb.set((float) (width - (this.dVY * 2)), 0.0f, (float) width, (float) (this.dVY * 2));
        this.dWe.arcTo(this.dWb, -90.0f, 90.0f, false);
        this.dWd.set((float) (width - this.dVZ), (float) (height - this.dVZ), (float) (width + this.dVZ), (float) (this.dVZ + height));
        this.dWe.arcTo(this.dWd, -90.0f, -90.0f, false);
        this.dWc.set((float) (-this.dVZ), (float) (height - this.dVZ), (float) this.dVZ, (float) (height + this.dVZ));
        this.dWe.arcTo(this.dWc, 0.0f, -90.0f, false);
        this.dWa.set(0.0f, 0.0f, (float) (this.dVY * 2), (float) (this.dVY * 2));
        this.dWe.arcTo(this.dWa, -180.0f, 90.0f, false);
        this.dWe.close();
        canvas.clipPath(this.dWe);
        super.onDraw(canvas);
    }
}
