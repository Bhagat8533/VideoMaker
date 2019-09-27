package com.introvd.template.common.p236ui.widgets.autofittextview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.TextView;
import java.util.WeakHashMap;
import xiaoying.quvideo.com.vivabase.C10122R;

/* renamed from: com.introvd.template.common.ui.widgets.autofittextview.AutofitLayout */
public class AutofitLayout extends FrameLayout {
    private float cio;
    private float ciq;
    private WeakHashMap<View, AutofitHelper> ciu = new WeakHashMap<>();
    private boolean mEnabled;

    public AutofitLayout(Context context) {
        super(context);
        m14547a(context, null, 0);
    }

    public AutofitLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m14547a(context, attributeSet, 0);
    }

    public AutofitLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m14547a(context, attributeSet, i);
    }

    /* renamed from: a */
    private void m14547a(Context context, AttributeSet attributeSet, int i) {
        boolean z = true;
        int i2 = -1;
        float f = -1.0f;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C10122R.styleable.AutofitTextView, i, 0);
            z = obtainStyledAttributes.getBoolean(C10122R.styleable.AutofitTextView_sizeToFit, true);
            i2 = obtainStyledAttributes.getDimensionPixelSize(C10122R.styleable.AutofitTextView_minTextSize, -1);
            f = obtainStyledAttributes.getFloat(C10122R.styleable.AutofitTextView_precision, -1.0f);
            obtainStyledAttributes.recycle();
        }
        this.mEnabled = z;
        this.cio = (float) i2;
        this.ciq = f;
    }

    public void addView(View view, int i, LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        TextView textView = (TextView) view;
        AutofitHelper enabled = AutofitHelper.create(textView).setEnabled(this.mEnabled);
        if (this.ciq > 0.0f) {
            enabled.setPrecision(this.ciq);
        }
        if (this.cio > 0.0f) {
            enabled.setMinTextSize(0, this.cio);
        }
        this.ciu.put(textView, enabled);
    }
}
