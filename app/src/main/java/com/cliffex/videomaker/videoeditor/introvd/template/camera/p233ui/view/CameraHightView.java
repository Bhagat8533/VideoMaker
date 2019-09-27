package com.introvd.template.camera.p233ui.view;

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

/* renamed from: com.introvd.template.camera.ui.view.CameraHightView */
public class CameraHightView extends RelativeLayout {
    private Matrix bWZ;
    private List<C5162a> bXa;
    private Path bXb;
    private Paint bXc;

    /* renamed from: com.introvd.template.camera.ui.view.CameraHightView$a */
    public static class C5162a {
        public Point bXd = new Point();
        public RectF bXe = new RectF();
        public float mDegree = 0.0f;
    }

    public CameraHightView(Context context) {
        this(context, null);
    }

    public CameraHightView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CameraHightView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bWZ = new Matrix();
        this.bXa = new ArrayList();
        this.bXb = new Path();
    }

    /* renamed from: Yh */
    private void m14018Yh() {
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
    private RectF m14019a(float f, float f2, int i, int i2) {
        float f3 = (float) i;
        float f4 = f / 2.0f;
        float f5 = (float) i2;
        float f6 = f2 / 2.0f;
        return new RectF(f3 - f4, f5 - f6, f3 + f4, f5 + f6);
    }

    /* renamed from: a */
    private C5162a m14020a(ScaleRotateViewState scaleRotateViewState) {
        StylePositionModel stylePositionModel = scaleRotateViewState.mPosInfo;
        if (stylePositionModel == null) {
            return null;
        }
        C5162a aVar = new C5162a();
        aVar.bXd.x = (int) stylePositionModel.getmCenterPosX();
        aVar.bXd.y = (int) stylePositionModel.getmCenterPosY();
        aVar.mDegree = scaleRotateViewState.mDegree;
        aVar.bXe = m14019a(stylePositionModel.getmWidth(), stylePositionModel.getmHeight(), aVar.bXd.x, aVar.bXd.y);
        return aVar;
    }

    /* renamed from: a */
    private void m14021a(C5162a aVar) {
        if (aVar != null) {
            this.bWZ.reset();
            this.bWZ.postTranslate((float) (-aVar.bXd.x), (float) (-aVar.bXd.y));
            this.bWZ.postRotate(aVar.mDegree);
            this.bWZ.postTranslate((float) aVar.bXd.x, (float) aVar.bXd.y);
        }
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        if (this.bXa != null && this.bXa.size() > 0) {
            for (C5162a aVar : this.bXa) {
                if (aVar != null) {
                    int save = canvas.save();
                    if (this.bWZ != null) {
                        m14021a(aVar);
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
            for (ScaleRotateViewState a : list) {
                C5162a a2 = m14020a(a);
                if (a2 != null) {
                    this.bXa.add(a2);
                }
            }
        }
        m14018Yh();
    }
}
