package com.introvd.template.explorer.p308ui;

import android.content.Context;
import android.util.AttributeSet;
import com.introvd.template.xyui.audiowave.RangeSeekBarV4;

/* renamed from: com.introvd.template.explorer.ui.RangeLogicSeekBar */
public class RangeLogicSeekBar extends RangeSeekBarV4<Integer> {
    public RangeLogicSeekBar(Context context) {
        super(context);
        mo36123a(Integer.valueOf(0), Integer.valueOf(100));
    }

    public RangeLogicSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        mo36123a(Integer.valueOf(0), Integer.valueOf(100));
    }

    public RangeLogicSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        mo36123a(Integer.valueOf(0), Integer.valueOf(100));
    }

    public RangeLogicSeekBar(Integer num, Integer num2, Context context) throws IllegalArgumentException {
        super(num, num2, context);
    }
}
