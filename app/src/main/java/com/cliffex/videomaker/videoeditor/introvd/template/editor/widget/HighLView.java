package com.introvd.template.editor.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Point;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.introvd.template.sdk.model.StylePositionModel;
import com.introvd.template.sdk.model.editor.ScaleRotateViewState;
import java.util.ArrayList;
import java.util.List;

public class HighLView extends RelativeLayout {
    private Matrix bWZ;
    private List<C7018a> bXa;
    private Path bXb;
    private Paint bXc;

    /* renamed from: com.introvd.template.editor.widget.HighLView$a */
    public static class C7018a {
        public Point bXd = new Point();
        public RectF bXe = new RectF();
        public float mDegree = 0.0f;
    }

    public HighLView(Context context) {
        this(context, null);
    }

    public HighLView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public HighLView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bWZ = new Matrix();
        this.bXa = new ArrayList();
        this.bXb = new Path();
    }

    /* renamed from: Yh */
    private void m20569Yh() {
        DashPathEffect dashPathEffect = new DashPathEffect(new float[]{6.0f, 6.0f}, 1.0f);
        if (this.bXc == null) {
            this.bXc = new Paint(1);
        } else {
            this.bXc.reset();
        }
        this.bXc.setStrokeWidth(2.0f);
        this.bXc.setStyle(Style.STROKE);
        this.bXc.setColor(-1);
        this.bXc.setPathEffect(dashPathEffect);
    }

    /* renamed from: a */
    private RectF m20570a(float f, float f2, int i, int i2) {
        float f3 = (float) i;
        float f4 = f / 2.0f;
        float f5 = (float) i2;
        float f6 = f2 / 2.0f;
        return new RectF(f3 - f4, f5 - f6, f3 + f4, f5 + f6);
    }

    /* renamed from: a */
    private void m20571a(C7018a aVar) {
        if (aVar != null) {
            this.bWZ.reset();
            this.bWZ.postTranslate((float) (-aVar.bXd.x), (float) (-aVar.bXd.y));
            this.bWZ.postRotate(aVar.mDegree);
            this.bWZ.postTranslate((float) aVar.bXd.x, (float) aVar.bXd.y);
        }
    }

    /* renamed from: p */
    private C7018a m20572p(ScaleRotateViewState scaleRotateViewState) {
        StylePositionModel stylePositionModel = scaleRotateViewState.mPosInfo;
        if (stylePositionModel == null) {
            return null;
        }
        C7018a aVar = new C7018a();
        aVar.bXd.x = (int) stylePositionModel.getmCenterPosX();
        aVar.bXd.y = (int) stylePositionModel.getmCenterPosY();
        aVar.mDegree = scaleRotateViewState.mDegree;
        aVar.bXe = m20570a(stylePositionModel.getmWidth(), stylePositionModel.getmHeight(), aVar.bXd.x, aVar.bXd.y);
        return aVar;
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        if (this.bXa != null && this.bXa.size() > 0) {
            for (C7018a aVar : this.bXa) {
                if (aVar != null) {
                    int save = canvas.save();
                    if (this.bWZ != null) {
                        m20571a(aVar);
                        canvas.concat(this.bWZ);
                    }
                    this.bXb.reset();
                    this.bXb.addRect(aVar.bXe, Direction.CW);
                    canvas.drawPath(this.bXb, this.bXc);
                    canvas.restoreToCount(save);
                }
            }
        }
        super.dispatchDraw(canvas);
    }

    public void setDataList(List<ScaleRotateViewState> list) {
        this.bXa.clear();
        if (list.size() > 0) {
            for (ScaleRotateViewState p : list) {
                C7018a p2 = m20572p(p);
                if (p2 != null) {
                    this.bXa.add(p2);
                }
            }
        }
        m20569Yh();
    }
}
