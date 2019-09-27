package com.introvd.template.xyui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import com.introvd.template.ui.widget.R;
import java.util.ArrayList;
import xiaoying.engine.base.QDisplayContext;

public class XYUiRotateTextView extends TextView {
    private TextPaint aeI = new TextPaint();
    private int cbA = 0;
    private int eyX = 0;
    private int eyY = 0;
    private int eyZ = 0;
    private boolean eza = false;
    private long ezc = 0;
    private long ezd = 0;
    private int ezk = 0;
    private long ezl = 0;
    private ArrayList<String> ezm;
    private boolean ezn = true;
    private Context mContext;
    private Paint mPaint = new Paint();
    private TextView mTextView = null;

    public XYUiRotateTextView(Context context) {
        super(context);
        this.mContext = context;
        aNe();
    }

    public XYUiRotateTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.XYUiRotateTextView);
        this.ezn = obtainStyledAttributes.getBoolean(R.styleable.XYUiRotateTextView_isShadowOn, false);
        aNe();
        this.cbA = obtainStyledAttributes.getInt(R.styleable.XYUiRotateTextView_rotation, 0);
        obtainStyledAttributes.recycle();
        update();
    }

    public XYUiRotateTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.XYUiRotateTextView);
        this.ezn = obtainStyledAttributes.getBoolean(R.styleable.XYUiRotateTextView_isShadowOn, true);
        aNe();
        this.cbA = obtainStyledAttributes.getInt(R.styleable.XYUiRotateTextView_rotation, 0);
        obtainStyledAttributes.recycle();
        update();
    }

    private void aNe() {
        this.ezm = new ArrayList<>();
        this.ezm.add("uk");
        this.ezm.add("kk");
        this.ezm.add("mk");
        this.ezm.add("fa");
        this.ezm.add("el");
    }

    private void update() {
        this.cbA = this.cbA >= 0 ? this.cbA % 360 : (this.cbA % 360) + 360;
        if (this.cbA != this.eyZ) {
            this.eyZ = this.cbA;
            this.eyY = this.eyX;
            this.ezc = AnimationUtils.currentAnimationTimeMillis();
            int i = this.eyZ - this.eyX;
            if (i < 0) {
                i += 360;
            }
            if (i > 180) {
                i -= 360;
            }
            this.eza = i >= 0;
            this.ezd = this.ezc + ((((long) Math.abs(i)) * this.ezl) / 180);
            invalidate();
        }
    }

    /* renamed from: dS */
    public int mo36070dS(int i, int i2) {
        if (1 == i) {
            return i2 != 1 ? 0 : 0;
        }
        if (2 == i) {
            switch (i2) {
                case 1:
                    return -1;
                case 2:
                    return 1;
            }
        } else if (3 == i) {
            switch (i2) {
                case 1:
                    return -2;
                case 2:
                    return 0;
                case 3:
                    return 2;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        boolean z;
        Canvas canvas2 = canvas;
        if (this.eyX != this.eyZ) {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            if (currentAnimationTimeMillis < this.ezd) {
                int i = (int) (currentAnimationTimeMillis - this.ezc);
                long j = (long) this.eyY;
                if (!this.eza) {
                    i = -i;
                }
                int i2 = (int) (j + (((long) (i * QDisplayContext.DISPLAY_ROTATION_180)) / this.ezl));
                this.eyX = i2 >= 0 ? i2 % 360 : (i2 % 360) + 360;
                invalidate();
            } else {
                this.eyX = this.eyZ;
            }
        }
        int currentTextColor = getCurrentTextColor();
        float textSize = getTextSize();
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(getText());
        String sb2 = sb.toString();
        String[] strArr = new String[5];
        int indexOf = sb2.indexOf("\n");
        String str = sb2;
        int i3 = 0;
        while (-1 != indexOf) {
            strArr[i3] = str.substring(0, indexOf);
            i3++;
            str = (String) str.subSequence(indexOf + 1, str.length());
            indexOf = str.indexOf("\n");
        }
        strArr[i3] = str.substring(0, str.length());
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int width = (getWidth() - paddingLeft) - getPaddingRight();
        int height = (getHeight() - paddingTop) - getPaddingBottom();
        int i4 = 1;
        this.aeI.setFlags(1);
        this.aeI.setColor(currentTextColor);
        this.aeI.setTextSize(textSize);
        this.aeI.ascent();
        this.mPaint.setFlags(1);
        this.mPaint.setColor(currentTextColor);
        this.mPaint.setTextSize(textSize);
        this.mPaint.ascent();
        this.mPaint.measureText(sb2);
        float f = (float) (height / 2);
        this.mPaint.descent();
        this.mPaint.ascent();
        this.mPaint.descent();
        float descent = this.mPaint.descent() - this.mPaint.ascent();
        canvas.save();
        String language = this.mContext.getResources().getConfiguration().locale.getLanguage();
        switch (this.ezk) {
            case 0:
                int i5 = 0;
                while (true) {
                    if (i5 >= this.ezm.size()) {
                        z = false;
                    } else if (language.equals(this.ezm.get(i5))) {
                        z = true;
                    } else {
                        i5++;
                    }
                }
                if (!z) {
                    this.mPaint.setTextAlign(Align.CENTER);
                    if (this.ezn) {
                        this.mPaint.setShadowLayer(1.0f, 1.0f, 1.0f, -16777216);
                    }
                    canvas2.rotate((float) (-this.eyX), (float) (getMeasuredWidth() / 2), (float) (getMeasuredHeight() / 2));
                    int i6 = 0;
                    while (i6 <= i3) {
                        i6++;
                        canvas2.drawText(strArr[i6], (float) ((width / 2) + paddingLeft), ((((((float) mo36070dS(i3 + 1, i6)) * descent) / 2.0f) + f) + (descent / 2.0f)) - this.mPaint.descent(), this.mPaint);
                    }
                    break;
                } else {
                    this.mPaint.setTextAlign(Align.LEFT);
                    if (this.ezn) {
                        this.mPaint.setShadowLayer(1.0f, 1.0f, 1.0f, -16777216);
                    }
                    canvas2.rotate((float) (-this.eyX), (float) (getMeasuredWidth() / 2), (float) (getMeasuredHeight() / 2));
                    int i7 = 0;
                    while (i7 <= i3) {
                        int i8 = i7 + 1;
                        canvas2.drawText(strArr[i7].trim(), (float) (strArr[i7].contains(" ") ? 50.0d - (((double) (strArr[i7].length() - i4)) * 6.5d) : 50.0d - (((double) strArr[i7].length()) * 6.5d)), ((((((float) mo36070dS(i3 + 1, i8)) * descent) / 2.0f) + f) + (descent / 2.0f)) - this.mPaint.descent(), this.mPaint);
                        i7 = i8;
                        i4 = 1;
                    }
                    break;
                }
            case 2:
                this.mPaint.setTextAlign(Align.RIGHT);
                if (this.ezn) {
                    this.mPaint.setShadowLayer(1.0f, 1.0f, 1.0f, -16777216);
                }
                float f2 = (float) (paddingLeft + width);
                float f3 = descent / 2.0f;
                canvas2.rotate((float) (-this.eyX), f2 - f3, ((float) paddingTop) + f3);
                canvas2.drawText(sb2, f2, -this.mPaint.ascent(), this.mPaint);
                break;
        }
        canvas.restore();
    }

    public void setDegree(int i) {
        this.ezl = 1;
        this.cbA = i;
        update();
    }

    public void setDegree(int i, long j) {
        this.ezl = j;
        this.cbA = i;
        update();
    }

    public void setRotateLocation(int i) {
        this.ezk = i;
        switch (this.ezk) {
            case 0:
                this.mPaint.setTextAlign(Align.CENTER);
                return;
            case 1:
                this.mPaint.setTextAlign(Align.LEFT);
                return;
            case 2:
                this.mPaint.setTextAlign(Align.RIGHT);
                return;
            default:
                return;
        }
    }

    public void setShadow(boolean z) {
        this.ezn = z;
    }
}
