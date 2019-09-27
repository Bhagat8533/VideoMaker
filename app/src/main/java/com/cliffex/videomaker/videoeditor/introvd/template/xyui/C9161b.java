package com.introvd.template.xyui;

import android.content.Context;
import android.support.p024v7.widget.GridLayoutManager;
import android.support.p024v7.widget.RecyclerView.C1025n;
import android.support.p024v7.widget.RecyclerView.C1031r;
import android.support.p024v7.widget.RecyclerView.LayoutParams;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;

/* renamed from: com.introvd.template.xyui.b */
class C9161b extends GridLayoutManager {
    private boolean eCx = false;
    private int[] eCy = new int[2];

    public C9161b(Context context, int i, int i2, boolean z) {
        super(context, i, i2, z);
    }

    /* renamed from: a */
    private void m26661a(C1025n nVar, int i, int i2, int i3, int[] iArr) {
        int itemCount = getItemCount();
        if (i < itemCount && itemCount > 0) {
            try {
                View cl = nVar.mo8121cl(0);
                if (cl != null) {
                    LayoutParams layoutParams = (LayoutParams) cl.getLayoutParams();
                    cl.measure(ViewGroup.getChildMeasureSpec(i2, getPaddingLeft() + getPaddingRight(), layoutParams.width), ViewGroup.getChildMeasureSpec(i3, getPaddingTop() + getPaddingBottom(), layoutParams.height));
                    iArr[0] = cl.getMeasuredWidth() + layoutParams.leftMargin + layoutParams.rightMargin;
                    iArr[1] = cl.getMeasuredHeight() + layoutParams.bottomMargin + layoutParams.topMargin;
                    nVar.mo8113aZ(cl);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void onMeasure(C1025n nVar, C1031r rVar, int i, int i2) {
        if (this.eCx) {
            int mode = MeasureSpec.getMode(i);
            int mode2 = MeasureSpec.getMode(i2);
            int size = MeasureSpec.getSize(i);
            int size2 = MeasureSpec.getSize(i2);
            int itemCount = getItemCount();
            int kr = mo7557kr();
            int i3 = 0;
            int i4 = 0;
            for (int i5 = 0; i5 < itemCount; i5++) {
                m26661a(nVar, i5, MeasureSpec.makeMeasureSpec(i5, 0), MeasureSpec.makeMeasureSpec(i5, 0), this.eCy);
                if (getOrientation() == 0) {
                    if (i5 % kr == 0) {
                        i3 += this.eCy[0];
                    }
                    if (i5 == 0) {
                        i4 = this.eCy[1];
                    }
                } else {
                    if (i5 % kr == 0) {
                        i4 += this.eCy[1];
                    }
                    if (i5 == 0) {
                        i3 = this.eCy[0];
                    }
                }
            }
            if (mode == 1073741824) {
                i3 = size;
            }
            if (mode2 != 1073741824) {
                size2 = i4;
            }
            setMeasuredDimension(i3, size2);
            return;
        }
        super.onMeasure(nVar, rVar, i, i2);
    }

    public void setIsFullView(boolean z) {
        this.eCx = z;
    }
}
