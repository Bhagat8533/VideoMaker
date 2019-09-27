package com.introvd.template.app.welcomepage.snsview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.GridView;

public class ExpandHeightGridView extends GridView {
    public ExpandHeightGridView(Context context) {
        super(context);
    }

    public ExpandHeightGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ExpandHeightGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void onMeasure(int i, int i2) {
        super.onMeasure(i, MeasureSpec.makeMeasureSpec(16777215, Integer.MIN_VALUE));
        getLayoutParams().height = getMeasuredHeight();
    }
}
