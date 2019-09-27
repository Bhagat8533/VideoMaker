package com.introvd.template.editor.effects.customwatermark;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.introvd.template.editor.R;
import com.introvd.template.editor.widget.scalerotate.p295a.C7065a;
import com.introvd.template.editor.widget.scalerotate.p295a.C7068c;
import com.introvd.template.sdk.model.StylePositionModel;
import com.introvd.template.sdk.model.editor.ScaleRotateViewState;
import java.io.IOException;

public class CustomWaterMarkView extends RelativeLayout {
    private RectF cKr;
    private C7068c cKs;
    private Drawable cKt;
    private Drawable cKu;
    private int cKv;
    private int cKw;
    private C6087a cKx;

    /* renamed from: com.introvd.template.editor.effects.customwatermark.CustomWaterMarkView$a */
    public interface C6087a {
        void ake();
    }

    public CustomWaterMarkView(Context context) {
        this(context, null);
    }

    public CustomWaterMarkView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CustomWaterMarkView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    /* renamed from: b */
    private void m17346b(Canvas canvas, RectF rectF) {
        int i = (int) rectF.right;
        int i2 = (int) rectF.top;
        if (this.cKu != null) {
            this.cKu.setBounds(i - this.cKv, i2 - this.cKw, i + this.cKv, i2 + this.cKw);
            this.cKu.draw(canvas);
        }
    }

    private void init() {
        this.cKs = new C7065a();
        this.cKr = new RectF();
        this.cKu = getResources().getDrawable(R.drawable.editor_btn_watermark_delete);
        this.cKv = this.cKu.getIntrinsicWidth() / 2;
        this.cKw = this.cKu.getIntrinsicHeight() / 2;
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        if (this.cKt != null) {
            canvas.save();
            this.cKt.setBounds((int) this.cKr.left, (int) this.cKr.top, (int) this.cKr.right, (int) this.cKr.bottom);
            this.cKt.draw(canvas);
            m17346b(canvas, this.cKr);
            canvas.restore();
        }
        super.dispatchDraw(canvas);
    }

    /* renamed from: l */
    public void mo28825l(ScaleRotateViewState scaleRotateViewState) {
        if (scaleRotateViewState != null && scaleRotateViewState.mPosInfo != null) {
            try {
                this.cKt = new BitmapDrawable(getResources(), this.cKs.mo31043q(scaleRotateViewState));
                this.cKt.setAlpha((int) (scaleRotateViewState.mAlpha * 255.0f));
                StylePositionModel stylePositionModel = scaleRotateViewState.mPosInfo;
                float f = stylePositionModel.getmCenterPosY() - (stylePositionModel.getmHeight() / 2.0f);
                this.cKr.set(stylePositionModel.getmCenterPosX() - (stylePositionModel.getmWidth() / 2.0f), f, stylePositionModel.getmCenterPosX() + (stylePositionModel.getmWidth() / 2.0f), stylePositionModel.getmCenterPosY() + (stylePositionModel.getmHeight() / 2.0f));
                invalidate();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.cKr.contains(motionEvent.getX(), motionEvent.getY()) || this.cKx == null) {
            return super.onTouchEvent(motionEvent);
        }
        if (motionEvent.getAction() == 1) {
            this.cKx.ake();
        }
        return true;
    }

    public void setCustomWaterMarkViewListener(C6087a aVar) {
        this.cKx = aVar;
    }
}
