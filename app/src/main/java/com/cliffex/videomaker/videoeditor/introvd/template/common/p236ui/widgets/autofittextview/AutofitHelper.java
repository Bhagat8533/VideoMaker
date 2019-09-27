package com.introvd.template.common.p236ui.widgets.autofittextview;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.text.Editable;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextWatcher;
import android.text.method.SingleLineTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Iterator;
import xiaoying.quvideo.com.vivabase.C10122R;

/* renamed from: com.introvd.template.common.ui.widgets.autofittextview.AutofitHelper */
public class AutofitHelper {

    /* renamed from: DW */
    private ArrayList<OnTextSizeChangeListener> f3456DW;
    private TextWatcher acH = new C5342b();
    private float caH;
    private int cin;
    private float cio;
    private float cip;
    private float ciq;
    private boolean cir;
    private OnLayoutChangeListener cis = new C5341a();
    private boolean mEnabled;
    private TextPaint mPaint;
    private TextView mTextView;

    /* renamed from: com.introvd.template.common.ui.widgets.autofittextview.AutofitHelper$OnTextSizeChangeListener */
    public interface OnTextSizeChangeListener {
        void onTextSizeChange(float f, float f2);
    }

    /* renamed from: com.introvd.template.common.ui.widgets.autofittextview.AutofitHelper$a */
    private class C5341a implements OnLayoutChangeListener {
        private C5341a() {
        }

        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            AutofitHelper.this.m14539ZA();
        }
    }

    /* renamed from: com.introvd.template.common.ui.widgets.autofittextview.AutofitHelper$b */
    private class C5342b implements TextWatcher {
        private C5342b() {
        }

        public void afterTextChanged(Editable editable) {
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            AutofitHelper.this.m14539ZA();
        }
    }

    private AutofitHelper(TextView textView) {
        float f = textView.getContext().getResources().getDisplayMetrics().scaledDensity;
        this.mTextView = textView;
        this.mPaint = new TextPaint();
        m14538B(textView.getTextSize());
        this.cin = getMaxLines(textView);
        this.cio = f * 8.0f;
        this.cip = this.caH;
        this.ciq = 0.5f;
    }

    /* renamed from: B */
    private void m14538B(float f) {
        if (this.caH != f) {
            this.caH = f;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: ZA */
    public void m14539ZA() {
        float textSize = this.mTextView.getTextSize();
        this.cir = true;
        m14542a(this.mTextView, this.mPaint, this.cio, this.cip, this.cin, this.ciq);
        this.cir = false;
        float textSize2 = this.mTextView.getTextSize();
        if (textSize2 != textSize) {
            m14546s(textSize2, textSize);
        }
    }

    /* renamed from: a */
    private static float m14540a(CharSequence charSequence, TextPaint textPaint, float f, int i, float f2, float f3, float f4, DisplayMetrics displayMetrics) {
        int i2;
        int i3;
        StaticLayout staticLayout;
        TextPaint textPaint2 = textPaint;
        float f5 = f;
        int i4 = i;
        float f6 = (f2 + f3) / 2.0f;
        textPaint2.setTextSize(TypedValue.applyDimension(0, f6, displayMetrics));
        if (i4 != 1) {
            i2 = 1;
            staticLayout = new StaticLayout(charSequence, textPaint, (int) f5, Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
            i3 = staticLayout.getLineCount();
        } else {
            i2 = 1;
            staticLayout = null;
            i3 = 1;
        }
        if (i3 > i4) {
            return f3 - f2 < f4 ? f2 : m14540a(charSequence, textPaint, f, i, f2, f6, f4, displayMetrics);
        }
        if (i3 < i4) {
            return m14540a(charSequence, textPaint, f, i, f6, f3, f4, displayMetrics);
        }
        float f7 = 0.0f;
        if (i4 == i2) {
            f7 = textPaint2.measureText(charSequence, 0, charSequence.length());
        } else {
            CharSequence charSequence2 = charSequence;
            if (staticLayout != null) {
                for (int i5 = 0; i5 < i3; i5++) {
                    if (staticLayout.getLineWidth(i5) > f7) {
                        f7 = staticLayout.getLineWidth(i5);
                    }
                }
            }
        }
        return f3 - f2 < f4 ? f2 : f7 > f5 ? m14540a(charSequence, textPaint, f, i, f2, f6, f4, displayMetrics) : f7 < f5 ? m14540a(charSequence, textPaint, f, i, f6, f3, f4, displayMetrics) : f6;
    }

    /* renamed from: a */
    private static int m14541a(CharSequence charSequence, TextPaint textPaint, float f, float f2, DisplayMetrics displayMetrics) {
        textPaint.setTextSize(TypedValue.applyDimension(0, f, displayMetrics));
        StaticLayout staticLayout = new StaticLayout(charSequence, textPaint, (int) f2, Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
        return staticLayout.getLineCount();
    }

    /* renamed from: a */
    private static void m14542a(TextView textView, TextPaint textPaint, float f, float f2, int i, float f3) {
        TextView textView2 = textView;
        TextPaint textPaint2 = textPaint;
        float f4 = f2;
        int i2 = i;
        if (i2 > 0 && i2 != Integer.MAX_VALUE) {
            int width = (textView.getWidth() - textView.getPaddingLeft()) - textView.getPaddingRight();
            if (width > 0) {
                CharSequence text = textView.getText();
                TransformationMethod transformationMethod = textView.getTransformationMethod();
                if (transformationMethod != null) {
                    text = transformationMethod.getTransformation(text, textView);
                }
                Context context = textView.getContext();
                Resources system = Resources.getSystem();
                if (context != null) {
                    system = context.getResources();
                }
                DisplayMetrics displayMetrics = system.getDisplayMetrics();
                textPaint.set(textView.getPaint());
                textPaint.setTextSize(f2);
                if ((i2 == 1 && textPaint.measureText(text, 0, text.length()) > ((float) width)) || m14541a(text, textPaint, f2, (float) width, displayMetrics) > i2) {
                    f4 = m14540a(text, textPaint, (float) width, i, 0.0f, f2, f3, displayMetrics);
                }
                textView.setTextSize(0, f4 < f ? f : f4);
            }
        }
    }

    /* renamed from: ad */
    private void m14544ad(float f) {
        if (((double) Math.abs(f - this.cio)) < 1.0E-7d) {
            this.cio = f;
            m14539ZA();
        }
    }

    /* renamed from: ae */
    private void m14545ae(float f) {
        if (f != this.cip) {
            this.cip = f;
            m14539ZA();
        }
    }

    public static AutofitHelper create(TextView textView) {
        return create(textView, null, 0);
    }

    public static AutofitHelper create(TextView textView, AttributeSet attributeSet, int i) {
        AutofitHelper autofitHelper = new AutofitHelper(textView);
        boolean z = true;
        if (attributeSet != null) {
            Context context = textView.getContext();
            int minTextSize = (int) autofitHelper.getMinTextSize();
            float precision = autofitHelper.getPrecision();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C10122R.styleable.AutofitTextView, i, 0);
            z = obtainStyledAttributes.getBoolean(C10122R.styleable.AutofitTextView_sizeToFit, true);
            int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(C10122R.styleable.AutofitTextView_minTextSize, minTextSize);
            float f = obtainStyledAttributes.getFloat(C10122R.styleable.AutofitTextView_precision, precision);
            obtainStyledAttributes.recycle();
            autofitHelper.setMinTextSize(0, (float) dimensionPixelSize).setPrecision(f);
        }
        autofitHelper.setEnabled(z);
        return autofitHelper;
    }

    private static int getMaxLines(TextView textView) {
        if (textView.getTransformationMethod() instanceof SingleLineTransformationMethod) {
            return 1;
        }
        if (VERSION.SDK_INT >= 16) {
            return textView.getMaxLines();
        }
        return -1;
    }

    /* renamed from: s */
    private void m14546s(float f, float f2) {
        if (this.f3456DW != null) {
            Iterator it = this.f3456DW.iterator();
            while (it.hasNext()) {
                ((OnTextSizeChangeListener) it.next()).onTextSizeChange(f, f2);
            }
        }
    }

    public AutofitHelper addOnTextSizeChangeListener(OnTextSizeChangeListener onTextSizeChangeListener) {
        if (this.f3456DW == null) {
            this.f3456DW = new ArrayList<>();
        }
        this.f3456DW.add(onTextSizeChangeListener);
        return this;
    }

    public float getMaxTextSize() {
        return this.cip;
    }

    public float getMinTextSize() {
        return this.cio;
    }

    public float getPrecision() {
        return this.ciq;
    }

    public AutofitHelper setEnabled(boolean z) {
        if (this.mEnabled != z) {
            this.mEnabled = z;
            if (z) {
                this.mTextView.addTextChangedListener(this.acH);
                this.mTextView.addOnLayoutChangeListener(this.cis);
                m14539ZA();
            } else {
                this.mTextView.removeTextChangedListener(this.acH);
                this.mTextView.removeOnLayoutChangeListener(this.cis);
                this.mTextView.setTextSize(0, this.caH);
            }
        }
        return this;
    }

    public AutofitHelper setMaxLines(int i) {
        if (this.cin != i) {
            this.cin = i;
            m14539ZA();
        }
        return this;
    }

    public AutofitHelper setMaxTextSize(float f) {
        return setMaxTextSize(2, f);
    }

    public AutofitHelper setMaxTextSize(int i, float f) {
        Context context = this.mTextView.getContext();
        Resources system = Resources.getSystem();
        if (context != null) {
            system = context.getResources();
        }
        m14545ae(TypedValue.applyDimension(i, f, system.getDisplayMetrics()));
        return this;
    }

    public AutofitHelper setMinTextSize(int i, float f) {
        Context context = this.mTextView.getContext();
        Resources system = Resources.getSystem();
        if (context != null) {
            system = context.getResources();
        }
        m14544ad(TypedValue.applyDimension(i, f, system.getDisplayMetrics()));
        return this;
    }

    public AutofitHelper setPrecision(float f) {
        if (this.ciq != f) {
            this.ciq = f;
            m14539ZA();
        }
        return this;
    }

    public void setTextSize(int i, float f) {
        if (!this.cir) {
            Context context = this.mTextView.getContext();
            Resources system = Resources.getSystem();
            if (context != null) {
                system = context.getResources();
            }
            m14538B(TypedValue.applyDimension(i, f, system.getDisplayMetrics()));
        }
    }
}
