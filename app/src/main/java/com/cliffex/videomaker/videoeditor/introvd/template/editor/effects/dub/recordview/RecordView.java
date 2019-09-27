package com.introvd.template.editor.effects.dub.recordview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.introvd.template.editor.R;
import com.introvd.template.module.p339c.C7689a;

public class RecordView extends View {
    private boolean cKT = true;
    private int cKU = 0;
    private int cKV;
    private int cKW;
    private int cKX;
    private int cKY;
    private int cKZ;
    private int cLa;
    private RectF cLb;
    private int cLc;
    private RectF cLd;
    private int cLe;
    private int cLf;
    private int centerX;
    private int centerY;
    private Paint paint;

    public RecordView(Context context) {
        super(context);
        m17410Oj();
    }

    public RecordView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m17410Oj();
    }

    public RecordView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m17410Oj();
    }

    /* renamed from: A */
    private void m17406A(Canvas canvas) {
        this.paint = new Paint();
        this.paint.setAntiAlias(true);
        this.paint.setColor(getResources().getColor(R.color.white));
        this.paint.setStyle(Style.STROKE);
        this.paint.setStrokeWidth((float) this.cKV);
        canvas.drawCircle((float) this.centerX, (float) this.centerY, (float) this.cKZ, this.paint);
    }

    /* renamed from: B */
    private void m17407B(Canvas canvas) {
        this.paint = new Paint();
        this.paint.setAntiAlias(true);
        this.paint.setColor(getResources().getColor(R.color.color_ff5e13));
        canvas.drawCircle((float) this.centerX, (float) this.centerY, (float) this.cLa, this.paint);
    }

    /* renamed from: C */
    private void m17408C(Canvas canvas) {
        this.paint = new Paint();
        this.paint.setAntiAlias(true);
        this.paint.setColor(getResources().getColor(R.color.color_ff5e13));
        canvas.drawRoundRect(this.cLb, (float) this.cKW, (float) this.cKW, this.paint);
    }

    /* renamed from: D */
    private void m17409D(Canvas canvas) {
        this.paint = new Paint();
        this.paint.setAntiAlias(true);
        this.paint.setColor(getResources().getColor(R.color.color_ff5e13));
        canvas.drawRoundRect(this.cLd, (float) this.cLf, (float) this.cLf, this.paint);
    }

    /* renamed from: Oj */
    private void m17410Oj() {
        this.paint = new Paint();
        this.cKV = C7689a.m22599ii(4);
        this.cKW = C7689a.m22599ii(2);
        this.cKX = C7689a.m22599ii(50);
        this.cKY = C7689a.m22599ii(50);
        this.centerX = this.cKX / 2;
        this.centerY = this.cKY / 2;
        this.cKZ = (this.cKX - this.cKV) / 2;
        this.cLa = (this.cKX * 2) / 5;
        this.cLc = this.cKX / 5;
        this.cLb = new RectF((float) (this.centerX - this.cLc), (float) (this.centerY - this.cLc), (float) (this.centerX + this.cLc), (float) (this.centerY + this.cLc));
        this.cLe = this.cLa;
        this.cLf = this.cLa;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.cKU == 0) {
            if (this.cKT) {
                m17406A(canvas);
                m17407B(canvas);
                this.cLe = this.cLa;
                this.cLf = this.cLa;
            } else {
                m17406A(canvas);
                m17408C(canvas);
                this.cLe = this.cLc;
                this.cLf = this.cKW;
            }
            this.cLd = new RectF((float) (this.centerX - this.cLe), (float) (this.centerY - this.cLe), (float) (this.centerX + this.cLe), (float) (this.centerY + this.cLe));
            return;
        }
        if (this.cKU == 1) {
            if (this.cLe > this.cLc) {
                this.cLe -= 2;
                this.cLf -= 4;
                if (this.cLe < this.cLc) {
                    this.cLe = this.cLc;
                    this.cLf = this.cKW;
                    this.cKU = 0;
                }
                if (this.cLf < this.cKW) {
                    this.cLf = this.cKW;
                }
            }
            this.cLd = new RectF((float) (this.centerX - this.cLe), (float) (this.centerY - this.cLe), (float) (this.centerX + this.cLe), (float) (this.centerY + this.cLe));
        } else if (this.cLe < this.cLa) {
            this.cLe += 2;
            this.cLf += 4;
            if (this.cLe > this.cLa) {
                this.cLe = this.cLa;
                this.cLf = this.cLa;
                this.cKU = 0;
            }
            if (this.cLf > this.cLe) {
                this.cLf = this.cLe;
            }
            this.cLd = new RectF((float) (this.centerX - this.cLe), (float) (this.centerY - this.cLe), (float) (this.centerX + this.cLe), (float) (this.centerY + this.cLe));
        }
        m17406A(canvas);
        if (this.cLd != null) {
            m17409D(canvas);
        }
        postInvalidateDelayed(20);
    }

    public void setAnimMode(int i) {
        if (this.cKU != i) {
            this.cKU = i;
            invalidate();
        }
    }

    public void setBegin(boolean z) {
        this.cKT = z;
    }
}
