package com.introvd.template.component.videofetcher.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.introvd.template.component.videofetcher.R;
import com.introvd.template.component.videofetcher.utils.C5486d;

public class RoundTransparencyProgressView extends View {
    private int bYV = 0;
    private int bYW = 0;
    private Bitmap bitmap;
    private int cmU;
    private int cmV;
    private int cmW;
    private int cmX;
    private int cmY = 100;
    Paint cmZ = new Paint();
    Paint cna = new Paint();
    Paint cnb = new Paint();
    private C5500a cnc;
    private Paint mPaint;
    private int mProgress;
    private volatile int state = 0;

    /* renamed from: com.introvd.template.component.videofetcher.view.RoundTransparencyProgressView$a */
    public interface C5500a {
        /* renamed from: ZL */
        boolean mo26966ZL();

        /* renamed from: ZM */
        void mo26967ZM();
    }

    public RoundTransparencyProgressView(Context context) {
        super(context);
        setLayerType(1, null);
    }

    public RoundTransparencyProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setLayerType(1, null);
        this.cmU = -1442840576;
        this.cmV = -1442840576;
        this.cmW = (int) C5486d.dpToPixel(context, 12.5f);
        this.mPaint = new Paint();
        this.mProgress = 0;
        this.cmX = (int) C5486d.dpToPixel(context, 12.5f);
        this.bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.fetcher_icon_progressbar_pause);
        this.state = 0;
        this.cmZ.setAntiAlias(true);
        this.cmZ.setColor(this.cmU);
        this.cna.setAntiAlias(true);
        this.cna.setColor(this.cmU);
        this.cnb.setAntiAlias(true);
        this.cnb.setColor(this.cmV);
    }

    public RoundTransparencyProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* renamed from: t */
    private void m14923t(Canvas canvas) {
        int width = getWidth();
        int height = getHeight();
        this.bYV = width / 2;
        this.bYW = height / 2;
        canvas.save();
        canvas.drawRoundRect(new RectF(0.0f, 0.0f, (float) width, (float) height), 6.0f, 6.0f, this.cmZ);
        canvas.restore();
        m14924u(canvas);
        if (this.state == 0) {
            canvas.drawArc(new RectF((float) (this.bYV - this.cmX), (float) (this.bYW - this.cmX), (float) (this.bYV + this.cmX), (float) (this.bYW + this.cmX)), -90.0f, (-(1.0f - (((float) this.mProgress) / ((float) this.cmY)))) * 360.0f, true, this.cnb);
        }
    }

    /* renamed from: u */
    private void m14924u(Canvas canvas) {
        this.cna.setAlpha(0);
        this.cna.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
        this.cna.setAntiAlias(true);
        this.cna.setDither(true);
        canvas.save();
        canvas.drawCircle((float) this.bYV, (float) this.bYW, (float) (this.cmX + this.cmW), this.cna);
        canvas.restore();
    }

    /* renamed from: v */
    private void m14925v(Canvas canvas) {
        if (this.bitmap != null) {
            canvas.save();
            canvas.drawBitmap(this.bitmap, (float) (this.bYV - (this.bitmap.getWidth() / 2)), (float) (this.bYW - (this.bitmap.getHeight() / 2)), this.mPaint);
            canvas.restore();
        }
    }

    /* renamed from: dF */
    public void mo27189dF(boolean z) {
        if (this.cnc == null || !z || this.cnc.mo26966ZL()) {
            this.state = 0;
            invalidate();
        }
    }

    public int getmProgress() {
        return this.mProgress;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        m14923t(canvas);
        if (this.state == 1) {
            m14925v(canvas);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            if (this.state == 0) {
                stop(true);
            } else if (this.state == 1) {
                mo27189dF(true);
            }
        }
        return true;
    }

    public void setPauseResource(int i) {
        if (this.bitmap != null && !this.bitmap.isRecycled()) {
            this.bitmap.recycle();
        }
        this.bitmap = BitmapFactory.decodeResource(getResources(), i);
    }

    public void setRadium(int i) {
        this.cmX = i;
    }

    public void setStateProgressListner(C5500a aVar) {
        this.cnc = aVar;
    }

    public void setmCircleWidth(int i) {
        this.cmW = i;
    }

    public void setmFirstColor(int i) {
        this.cmU = i;
    }

    public void setmProgress(int i) {
        if (i > this.cmY) {
            i = this.cmY;
        }
        this.mProgress = i;
        invalidate();
    }

    public void setmSecondColor(int i) {
        this.cmV = i;
    }

    public void stop(boolean z) {
        this.state = 1;
        if (this.cnc != null && z) {
            this.cnc.mo26967ZM();
        }
        invalidate();
    }
}
