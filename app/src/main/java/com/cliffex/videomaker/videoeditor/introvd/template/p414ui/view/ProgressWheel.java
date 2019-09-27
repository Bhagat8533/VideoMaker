package com.introvd.template.p414ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import xiaoying.quvideo.com.vivabase.C10122R;

/* renamed from: com.introvd.template.ui.view.ProgressWheel */
public class ProgressWheel extends View {
    private float aoZ = 0.0f;
    private Paint bXC = new Paint();
    private int barLength = 60;
    private int cbg = 0;
    private Paint cna = new Paint();

    /* renamed from: eM */
    private int f3626eM = 80;
    private int eyF = 100;
    private int eyG = 20;
    private float eyH = 0.0f;
    private int eyI = -1442840576;
    private int eyJ = -1442840576;
    private int eyK = -1428300323;
    private Paint eyL = new Paint();
    private Paint eyM = new Paint();
    private Paint eyN = new Paint();
    private RectF eyO = new RectF();
    private RectF eyP = new RectF();
    private RectF eyQ = new RectF();
    private RectF eyR = new RectF();
    private RectF eyS = new RectF();
    private float eyT = 2.0f;
    private int eyU = 10;
    boolean eyV = false;
    private String[] eyW = new String[0];
    private int eyo = 20;
    private int layoutHeight = 0;
    private int layoutWidth = 0;
    private int paddingBottom = 5;
    private int paddingLeft = 5;
    private int paddingRight = 5;
    private int paddingTop = 5;
    private String text = "";
    private int textColor = -16777216;
    private int textSize = 20;

    public ProgressWheel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m26365g(context.obtainStyledAttributes(attributeSet, C10122R.styleable.ProgressWheel));
    }

    private void aNb() {
        this.eyL.setColor(this.eyI);
        this.eyL.setAntiAlias(true);
        this.eyL.setStyle(Style.STROKE);
        this.eyL.setStrokeWidth((float) this.eyo);
        this.eyM.setColor(this.eyK);
        this.eyM.setAntiAlias(true);
        this.eyM.setStyle(Style.STROKE);
        this.eyM.setStrokeWidth((float) this.eyG);
        this.cna.setColor(this.cbg);
        this.cna.setAntiAlias(true);
        this.cna.setStyle(Style.FILL);
        this.bXC.setColor(this.textColor);
        this.bXC.setStyle(Style.FILL);
        this.bXC.setAntiAlias(true);
        this.bXC.setTextSize((float) this.textSize);
        this.eyN.setColor(this.eyJ);
        this.eyN.setAntiAlias(true);
        this.eyN.setStyle(Style.STROKE);
        this.eyN.setStrokeWidth(this.eyH);
    }

    private void aNc() {
        int min = Math.min(this.layoutWidth, this.layoutHeight);
        int i = this.layoutWidth - min;
        int i2 = (this.layoutHeight - min) / 2;
        this.paddingTop = getPaddingTop() + i2;
        this.paddingBottom = getPaddingBottom() + i2;
        int i3 = i / 2;
        this.paddingLeft = getPaddingLeft() + i3;
        this.paddingRight = getPaddingRight() + i3;
        int width = getWidth();
        int height = getHeight();
        this.eyO = new RectF(((float) this.paddingLeft) + (((float) this.eyo) * 1.5f), ((float) this.paddingTop) + (((float) this.eyo) * 1.5f), ((float) (width - this.paddingRight)) - (((float) this.eyo) * 1.5f), ((float) (height - this.paddingBottom)) - (((float) this.eyo) * 1.5f));
        this.eyP = new RectF((float) (this.paddingLeft + this.eyo), (float) (this.paddingTop + this.eyo), (float) ((width - this.paddingRight) - this.eyo), (float) ((height - this.paddingBottom) - this.eyo));
        this.eyR = new RectF(this.eyP.left + (((float) this.eyG) / 2.0f) + (this.eyH / 2.0f), this.eyP.top + (((float) this.eyG) / 2.0f) + (this.eyH / 2.0f), (this.eyP.right - (((float) this.eyG) / 2.0f)) - (this.eyH / 2.0f), (this.eyP.bottom - (((float) this.eyG) / 2.0f)) - (this.eyH / 2.0f));
        this.eyQ = new RectF((this.eyP.left - (((float) this.eyG) / 2.0f)) - (this.eyH / 2.0f), (this.eyP.top - (((float) this.eyG) / 2.0f)) - (this.eyH / 2.0f), this.eyP.right + (((float) this.eyG) / 2.0f) + (this.eyH / 2.0f), this.eyP.bottom + (((float) this.eyG) / 2.0f) + (this.eyH / 2.0f));
        this.eyS = new RectF(this.eyP.left + (((float) this.eyo) / 2.0f), this.eyP.top + (((float) this.eyo) / 2.0f), this.eyP.right - (((float) this.eyo) / 2.0f), this.eyP.bottom - (((float) this.eyo) / 2.0f));
        this.eyF = ((width - this.paddingRight) - this.eyo) / 2;
        this.f3626eM = (this.eyF - this.eyo) + 1;
    }

    private void aNd() {
        this.aoZ += this.eyT;
        if (this.aoZ > 360.0f) {
            this.aoZ = 0.0f;
        }
        postInvalidateDelayed((long) this.eyU);
    }

    /* renamed from: g */
    private void m26365g(TypedArray typedArray) {
        this.eyo = (int) typedArray.getDimension(C10122R.styleable.ProgressWheel_pwBarWidth, (float) this.eyo);
        this.eyG = (int) typedArray.getDimension(C10122R.styleable.ProgressWheel_pwRimWidth, (float) this.eyG);
        this.eyT = (float) ((int) typedArray.getDimension(C10122R.styleable.ProgressWheel_pwSpinSpeed, this.eyT));
        this.barLength = (int) typedArray.getDimension(C10122R.styleable.ProgressWheel_pwBarLength, (float) this.barLength);
        setProgress(typedArray.getInt(C10122R.styleable.ProgressWheel_pwProgress, 0));
        this.eyU = typedArray.getInteger(C10122R.styleable.ProgressWheel_pwDelayMillis, this.eyU);
        if (this.eyU < 0) {
            this.eyU = 10;
        }
        if (typedArray.hasValue(C10122R.styleable.ProgressWheel_pwText)) {
            setText(typedArray.getString(C10122R.styleable.ProgressWheel_pwText));
        }
        this.eyI = typedArray.getColor(C10122R.styleable.ProgressWheel_pwBarColor, this.eyI);
        this.textColor = typedArray.getColor(C10122R.styleable.ProgressWheel_pwTextColor, this.textColor);
        this.eyK = typedArray.getColor(C10122R.styleable.ProgressWheel_pwRimColor, this.eyK);
        this.cbg = typedArray.getColor(C10122R.styleable.ProgressWheel_pwCircleColor, this.cbg);
        this.eyJ = typedArray.getColor(C10122R.styleable.ProgressWheel_pwContourColor, this.eyJ);
        this.textSize = (int) typedArray.getDimension(C10122R.styleable.ProgressWheel_pwTextSize, (float) this.textSize);
        this.eyH = typedArray.getDimension(C10122R.styleable.ProgressWheel_pwContourSize, this.eyH);
        typedArray.recycle();
    }

    /* renamed from: vF */
    public static int m26366vF(int i) {
        return (i * 18) / 5;
    }

    public int getBarColor() {
        return this.eyI;
    }

    public int getBarLength() {
        return this.barLength;
    }

    public int getBarWidth() {
        return this.eyo;
    }

    public int getCircleColor() {
        return this.cbg;
    }

    public int getCircleRadius() {
        return this.f3626eM;
    }

    public int getContourColor() {
        return this.eyJ;
    }

    public float getContourSize() {
        return this.eyH;
    }

    public int getDelayMillis() {
        return this.eyU;
    }

    public int getPaddingBottom() {
        return this.paddingBottom;
    }

    public int getPaddingLeft() {
        return this.paddingLeft;
    }

    public int getPaddingRight() {
        return this.paddingRight;
    }

    public int getPaddingTop() {
        return this.paddingTop;
    }

    public int getProgress() {
        return (int) this.aoZ;
    }

    public int getRimColor() {
        return this.eyK;
    }

    public Shader getRimShader() {
        return this.eyM.getShader();
    }

    public int getRimWidth() {
        return this.eyG;
    }

    public float getSpinSpeed() {
        return this.eyT;
    }

    public int getTextColor() {
        return this.textColor;
    }

    public int getTextSize() {
        return this.textSize;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        String[] strArr;
        super.onDraw(canvas);
        Canvas canvas2 = canvas;
        canvas2.drawArc(this.eyO, 360.0f, 360.0f, false, this.cna);
        canvas.drawArc(this.eyP, 360.0f, 360.0f, false, this.eyM);
        canvas2.drawArc(this.eyQ, 360.0f, 360.0f, false, this.eyN);
        if (this.eyV) {
            canvas.drawArc(this.eyP, this.aoZ - 90.0f, (float) this.barLength, false, this.eyL);
        } else {
            canvas.drawArc(this.eyS, -90.0f, this.aoZ, false, this.eyL);
        }
        float descent = ((this.bXC.descent() - this.bXC.ascent()) / 2.0f) - this.bXC.descent();
        for (String str : this.eyW) {
            canvas.drawText(str, ((float) (getWidth() / 2)) - (this.bXC.measureText(str) / 2.0f), ((float) (getHeight() / 2)) + descent, this.bXC);
        }
        if (this.eyV) {
            aNd();
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int measuredWidth = getMeasuredWidth();
        int paddingLeft2 = (measuredWidth - getPaddingLeft()) - getPaddingRight();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int mode = MeasureSpec.getMode(i2);
        int mode2 = MeasureSpec.getMode(i);
        if (mode == 0 || mode2 == 0) {
            paddingLeft2 = Math.max(measuredHeight, paddingLeft2);
        } else if (paddingLeft2 > measuredHeight) {
            paddingLeft2 = measuredHeight;
        }
        setMeasuredDimension(getPaddingLeft() + paddingLeft2 + getPaddingRight(), paddingLeft2 + getPaddingTop() + getPaddingBottom());
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.layoutWidth = i;
        this.layoutHeight = i2;
        aNc();
        aNb();
        invalidate();
    }

    public void setBarColor(int i) {
        this.eyI = i;
        if (this.eyL != null) {
            this.eyL.setColor(this.eyI);
        }
    }

    public void setBarLength(int i) {
        this.barLength = i;
    }

    public void setBarWidth(int i) {
        this.eyo = i;
        if (this.eyL != null) {
            this.eyL.setStrokeWidth((float) this.eyo);
        }
    }

    public void setCircleColor(int i) {
        this.cbg = i;
        if (this.cna != null) {
            this.cna.setColor(this.cbg);
        }
    }

    public void setCircleRadius(int i) {
        this.f3626eM = i;
    }

    public void setContourColor(int i) {
        this.eyJ = i;
        if (this.eyN != null) {
            this.eyN.setColor(this.eyJ);
        }
    }

    public void setContourSize(float f) {
        this.eyH = f;
        if (this.eyN != null) {
            this.eyN.setStrokeWidth(this.eyH);
        }
    }

    public void setDelayMillis(int i) {
        this.eyU = i;
    }

    public void setPaddingBottom(int i) {
        this.paddingBottom = i;
    }

    public void setPaddingLeft(int i) {
        this.paddingLeft = i;
    }

    public void setPaddingRight(int i) {
        this.paddingRight = i;
    }

    public void setPaddingTop(int i) {
        this.paddingTop = i;
    }

    public void setProgress(int i) {
        this.eyV = false;
        this.aoZ = (float) m26366vF(i);
        postInvalidate();
    }

    public void setRimColor(int i) {
        this.eyK = i;
        if (this.eyM != null) {
            this.eyM.setColor(this.eyK);
        }
    }

    public void setRimShader(Shader shader) {
        this.eyM.setShader(shader);
    }

    public void setRimWidth(int i) {
        this.eyG = i;
        if (this.eyM != null) {
            this.eyM.setStrokeWidth((float) this.eyG);
        }
    }

    public void setSpinSpeed(float f) {
        this.eyT = f;
    }

    public void setText(String str) {
        this.text = str;
        this.eyW = this.text.split("\n");
    }

    public void setTextColor(int i) {
        this.textColor = i;
        if (this.bXC != null) {
            this.bXC.setColor(this.textColor);
        }
    }

    public void setTextSize(int i) {
        this.textSize = i;
        if (this.bXC != null) {
            this.bXC.setTextSize((float) this.textSize);
        }
    }
}
