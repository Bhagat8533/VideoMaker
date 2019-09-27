package com.introvd.template.common.p236ui.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.p021v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.introvd.template.R;
import com.introvd.template.p203b.C4583d;
import com.p131c.p132a.p135c.C2575a;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* renamed from: com.introvd.template.common.ui.custom.RatingBarView */
public class RatingBarView extends LinearLayout {
    private float cgY;
    private int cgZ;
    private int cha;
    private float chb;
    private Drawable chc;
    private Drawable chd;
    private List<ImageView> che;
    private float chf;
    private DecimalFormat chg;
    private OnStarChangedListener chh;
    private float mStepSize;

    /* renamed from: com.introvd.template.common.ui.custom.RatingBarView$OnStarChangedListener */
    public interface OnStarChangedListener {
        void onStarChanged(float f);
    }

    public RatingBarView(Context context) {
        this(context, null);
    }

    public RatingBarView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RatingBarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cha = C4583d.m11673ii(10);
        this.chf = 0.0f;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RatingBarView);
        this.cgZ = obtainStyledAttributes.getInt(R.styleable.RatingBarView_starNums, 0);
        this.chb = obtainStyledAttributes.getFloat(R.styleable.RatingBarView_starRating, 0.0f);
        this.mStepSize = obtainStyledAttributes.getFloat(R.styleable.RatingBarView_stepSize, 0.0f);
        this.cgY = obtainStyledAttributes.getFloat(R.styleable.RatingBarView_minStar, 0.0f);
        this.chd = obtainStyledAttributes.getDrawable(R.styleable.RatingBarView_emptyDrawable);
        this.chc = obtainStyledAttributes.getDrawable(R.styleable.RatingBarView_fillDrawable);
        obtainStyledAttributes.recycle();
        m14487Zv();
        m14486Zu();
        setRating(this.chb);
    }

    /* renamed from: Zu */
    private void m14486Zu() {
        this.che = new ArrayList(this.cgZ);
        if (this.cgZ > 0) {
            for (int i = 1; i <= this.cgZ; i++) {
                LayoutParams layoutParams = new LayoutParams(-2, -2);
                ImageView imageView = new ImageView(getContext());
                imageView.setTag(Integer.valueOf(i));
                imageView.setImageResource(R.drawable.app_dialog_rating_unstar_bg);
                if (i > 1) {
                    layoutParams.leftMargin = this.cha;
                }
                addView(imageView, layoutParams);
                this.che.add(imageView);
            }
        }
    }

    /* renamed from: Zv */
    private void m14487Zv() {
        if (this.cgZ <= 0) {
            this.cgZ = 5;
        }
        if (this.chd == null || this.chc == null) {
            this.chd = ContextCompat.getDrawable(getContext(), R.drawable.app_dialog_rating_unstar_bg);
        }
        if (this.mStepSize > 1.0f) {
            this.mStepSize = 1.0f;
        } else if (this.mStepSize < 0.1f) {
            this.mStepSize = 0.1f;
        }
    }

    /* renamed from: Zw */
    private boolean m14488Zw() {
        return false;
    }

    /* renamed from: a */
    private boolean m14489a(ImageView imageView, float f) {
        return f > ((float) imageView.getLeft()) && f < ((float) imageView.getRight());
    }

    /* renamed from: aa */
    private void m14490aa(float f) {
        for (ImageView imageView : this.che) {
            if (((Integer) imageView.getTag()).intValue() > ((int) Math.ceil((double) f))) {
                imageView.setImageResource(R.drawable.app_dialog_rating_unstar_bg);
            } else {
                imageView.setImageResource(R.drawable.app_dialog_rating_star_bg);
            }
        }
    }

    /* renamed from: ab */
    private void m14491ab(float f) {
        for (ImageView imageView : this.che) {
            if (m14489a(imageView, f)) {
                float intValue = this.mStepSize == 1.0f ? (float) ((Integer) imageView.getTag()).intValue() : m14493b(imageView, this.mStepSize, f);
                if (this.chf == intValue && m14488Zw()) {
                    setRating(this.cgY);
                    return;
                } else if (this.chf == intValue) {
                    setRating(intValue - 1.0f);
                    return;
                } else {
                    setRating(intValue);
                    return;
                }
            }
        }
    }

    /* renamed from: ac */
    private void m14492ac(float f) {
        for (ImageView imageView : this.che) {
            if (f < (((float) imageView.getWidth()) / 10.0f) + (this.cgY * ((float) imageView.getWidth()))) {
                setRating(this.cgY);
                return;
            } else if (m14489a(imageView, f)) {
                float b = m14493b(imageView, this.mStepSize, f);
                if (this.chb != b) {
                    setRating(b);
                }
            }
        }
    }

    /* renamed from: b */
    private float m14493b(ImageView imageView, float f, float f2) {
        DecimalFormat decimalFormat = getDecimalFormat();
        return C2575a.parseFloat(decimalFormat.format((double) (((float) ((Integer) imageView.getTag()).intValue()) - (1.0f - (((float) Math.round(C2575a.parseFloat(decimalFormat.format((double) ((f2 - ((float) imageView.getLeft())) / ((float) imageView.getWidth())))) / f)) * f)))));
    }

    public DecimalFormat getDecimalFormat() {
        if (this.chg == null) {
            DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols(Locale.ENGLISH);
            decimalFormatSymbols.setDecimalSeparator('.');
            this.chg = new DecimalFormat("#.##", decimalFormatSymbols);
        }
        return this.chg;
    }

    public float getRating() {
        return this.chb;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        switch (motionEvent.getAction()) {
            case 0:
                this.chf = this.chb;
                break;
            case 1:
                m14491ab(x);
                break;
            case 2:
                m14492ac(x);
                break;
        }
        getParent().requestDisallowInterceptTouchEvent(true);
        return true;
    }

    public void setOnStarChangedListener(OnStarChangedListener onStarChangedListener) {
        this.chh = onStarChangedListener;
    }

    public void setRating(float f) {
        if (f > ((float) this.cgZ)) {
            f = (float) this.cgZ;
        }
        this.chb = f;
        m14490aa(f);
        if (this.chh != null) {
            this.chh.onStarChanged(this.chb);
        }
    }

    public void setmNumStar(int i) {
        if (i >= 0) {
            this.cgZ = i;
            this.che.clear();
            removeAllViews();
            m14486Zu();
        }
    }
}
