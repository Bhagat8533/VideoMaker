package com.introvd.template.p414ui.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import java.util.ArrayList;
import java.util.List;
import xiaoying.quvideo.com.vivabase.C10122R;

/* renamed from: com.introvd.template.ui.view.LoadingView */
public class LoadingView extends RelativeLayout {
    private int cNi = 0;
    private int eyi = 0;
    private int eyj = 0;
    private int eyk = 0;
    private List<ValueAnimator> eyl;
    private List<View> eym;
    private boolean isLoading = false;

    /* renamed from: pn */
    private int f3624pn = 0;

    public LoadingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m26353e(context.obtainStyledAttributes(attributeSet, C10122R.styleable.LoadingView));
        onCreate();
    }

    /* renamed from: e */
    private void m26353e(TypedArray typedArray) {
        this.eyi = typedArray.getDimensionPixelSize(C10122R.styleable.LoadingView_vertical_space, this.eyi);
        this.eyj = typedArray.getDimensionPixelSize(C10122R.styleable.LoadingView_horizontal_space, this.eyj);
        this.cNi = typedArray.getDimensionPixelSize(C10122R.styleable.LoadingView_item_width, this.cNi);
        this.f3624pn = typedArray.getDimensionPixelSize(C10122R.styleable.LoadingView_item_height, this.f3624pn);
        this.eyk = typedArray.getResourceId(C10122R.styleable.LoadingView_item_src, 0);
        typedArray.recycle();
    }

    private void onCreate() {
        this.eyl = new ArrayList(4);
        this.eym = new ArrayList(4);
        View view = new View(getContext());
        view.setBackgroundColor(0);
        view.setAlpha(0.0f);
        view.setId(C10122R.C10124id.loading_view_center_point);
        LayoutParams layoutParams = new LayoutParams(this.eyj, this.eyi);
        layoutParams.addRule(13, -1);
        view.setLayoutParams(layoutParams);
        addView(view);
        for (int i = 0; i < 4; i++) {
            View view2 = new View(getContext());
            view2.setBackgroundResource(this.eyk);
            view2.setAlpha(1.0f);
            LayoutParams layoutParams2 = new LayoutParams(this.cNi, this.f3624pn);
            int i2 = 1;
            int i3 = 2;
            if (i / 2 != 0) {
                i3 = 3;
                if (i % 2 == 0) {
                    layoutParams2.addRule(i3, C10122R.C10124id.loading_view_center_point);
                    layoutParams2.addRule(i2, C10122R.C10124id.loading_view_center_point);
                    view2.setLayoutParams(layoutParams2);
                    addView(view2);
                    this.eym.add(view2);
                }
            } else if (i % 2 != 0) {
                layoutParams2.addRule(i3, C10122R.C10124id.loading_view_center_point);
                layoutParams2.addRule(i2, C10122R.C10124id.loading_view_center_point);
                view2.setLayoutParams(layoutParams2);
                addView(view2);
                this.eym.add(view2);
            }
            i2 = 0;
            layoutParams2.addRule(i3, C10122R.C10124id.loading_view_center_point);
            layoutParams2.addRule(i2, C10122R.C10124id.loading_view_center_point);
            view2.setLayoutParams(layoutParams2);
            addView(view2);
            this.eym.add(view2);
        }
    }
}
