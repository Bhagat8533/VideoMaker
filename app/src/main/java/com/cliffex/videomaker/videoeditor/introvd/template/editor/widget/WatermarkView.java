package com.introvd.template.editor.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.introvd.template.editor.R;

public class WatermarkView extends FrameLayout {
    public WatermarkView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBackgroundResource(R.drawable.xiaoying_purchase_watermark);
    }
}
