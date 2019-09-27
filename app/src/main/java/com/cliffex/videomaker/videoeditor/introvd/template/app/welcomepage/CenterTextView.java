package com.introvd.template.app.welcomepage;

import android.content.Context;
import android.graphics.Canvas;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.TextView;

public class CenterTextView extends TextView {
    private StaticLayout bIs;
    private TextPaint bIt;

    public CenterTextView(Context context) {
        super(context);
    }

    public CenterTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CenterTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* renamed from: Oj */
    private void m11381Oj() {
        this.bIt = new TextPaint(1);
        this.bIt.setTextSize(getTextSize());
        this.bIt.setColor(getCurrentTextColor());
        StaticLayout staticLayout = new StaticLayout(getText(), this.bIt, getWidth(), Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);
        this.bIs = staticLayout;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        this.bIs.draw(canvas);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        m11381Oj();
    }
}
