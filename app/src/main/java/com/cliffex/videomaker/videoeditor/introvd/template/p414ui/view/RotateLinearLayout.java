package com.introvd.template.p414ui.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.introvd.template.common.DeviceInfo;
import xiaoying.quvideo.com.vivabase.C10122R;

/* renamed from: com.introvd.template.ui.view.RotateLinearLayout */
public class RotateLinearLayout extends LinearLayout {
    private int cbA = 0;
    private int cbv = 0;
    private int cbw = 0;
    private int cbx = 0;
    private Context mContext;

    public RotateLinearLayout(Context context) {
        super(context);
        this.mContext = context;
    }

    public RotateLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        this.cbv = this.mContext.getResources().getDimensionPixelSize(C10122R.dimen.panel_top_height);
        this.cbw = this.mContext.getResources().getDimensionPixelSize(C10122R.dimen.panel_bottom_height);
        this.cbx = this.mContext.getResources().getDimensionPixelSize(C10122R.dimen.toast_offset);
    }

    public void draw(Canvas canvas) {
        int i;
        canvas.save();
        if (canvas.getClipBounds().top == 0) {
            int i2 = canvas.getClipBounds().left;
        }
        Rect rect = new Rect();
        getHitRect(rect);
        int i3 = DeviceInfo.getScreenSize(this.mContext).width / 2;
        int i4 = DeviceInfo.getScreenSize(this.mContext).height / 2;
        int centerX = rect.centerX();
        int centerY = rect.centerY();
        int i5 = this.cbA;
        int i6 = 0;
        if (i5 != -2) {
            if (i5 == 0) {
                i = (-i4) + this.cbv + this.cbx;
            } else if (i5 == 90) {
                i6 = (-i3) + this.cbx;
                i = (-(this.cbw - this.cbv)) / 2;
            } else if (i5 != 180) {
                if (i5 != 270) {
                    i = 0;
                } else {
                    i6 = i3 - this.cbx;
                    i = (-(this.cbw - this.cbv)) / 2;
                }
            }
            canvas.translate((float) ((i3 - centerX) + i6), (float) ((i4 - centerY) + i));
            if (this.cbA == 0 || this.cbA == 90 || this.cbA == 180 || this.cbA == 270) {
                canvas.rotate((float) (-this.cbA), (float) centerX, (float) centerY);
            }
            super.draw(canvas);
            canvas.restore();
        }
        i = (i4 - this.cbw) - this.cbx;
        canvas.translate((float) ((i3 - centerX) + i6), (float) ((i4 - centerY) + i));
        canvas.rotate((float) (-this.cbA), (float) centerX, (float) centerY);
        super.draw(canvas);
        canvas.restore();
    }

    public int getDegree() {
        return this.cbA;
    }

    public void setDegree(int i) {
        this.cbA = i;
    }
}
