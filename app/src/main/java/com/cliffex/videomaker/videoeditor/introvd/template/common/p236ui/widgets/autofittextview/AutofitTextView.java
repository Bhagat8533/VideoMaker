package com.introvd.template.common.p236ui.widgets.autofittextview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import com.introvd.template.common.p236ui.widgets.autofittextview.AutofitHelper.OnTextSizeChangeListener;

@Deprecated
/* renamed from: com.introvd.template.common.ui.widgets.autofittextview.AutofitTextView */
public class AutofitTextView extends TextView implements OnTextSizeChangeListener {
    private AutofitHelper civ;

    public AutofitTextView(Context context) {
        super(context);
        m14548a(context, null, 0);
    }

    public AutofitTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m14548a(context, attributeSet, 0);
    }

    public AutofitTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m14548a(context, attributeSet, i);
    }

    /* renamed from: a */
    private void m14548a(Context context, AttributeSet attributeSet, int i) {
        this.civ = AutofitHelper.create(this, attributeSet, i).addOnTextSizeChangeListener(this);
    }

    public AutofitHelper getAutofitHelper() {
        return this.civ;
    }

    public float getMaxTextSize() {
        return this.civ.getMaxTextSize();
    }

    public float getMinTextSize() {
        return this.civ.getMinTextSize();
    }

    public float getPrecision() {
        return this.civ.getPrecision();
    }

    public void onTextSizeChange(float f, float f2) {
    }

    public void setLines(int i) {
        super.setLines(i);
        if (this.civ != null) {
            this.civ.setMaxLines(i);
        }
    }

    public void setMaxLines(int i) {
        super.setMaxLines(i);
        if (this.civ != null) {
            this.civ.setMaxLines(i);
        }
    }

    public void setMaxTextSize(float f) {
        this.civ.setMaxTextSize(f);
    }

    public void setMaxTextSize(int i, float f) {
        this.civ.setMaxTextSize(i, f);
    }

    public void setMinTextSize(int i) {
        this.civ.setMinTextSize(2, (float) i);
    }

    public void setMinTextSize(int i, float f) {
        this.civ.setMinTextSize(i, f);
    }

    public void setPrecision(float f) {
        this.civ.setPrecision(f);
    }

    public void setSizeToFit() {
        setSizeToFit(true);
    }

    public void setSizeToFit(boolean z) {
        this.civ.setEnabled(z);
    }

    public void setTextSize(int i, float f) {
        super.setTextSize(i, f);
        if (this.civ != null) {
            this.civ.setTextSize(i, f);
        }
    }
}
