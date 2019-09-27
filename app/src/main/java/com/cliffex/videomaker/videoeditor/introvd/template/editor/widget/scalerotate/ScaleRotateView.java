package com.introvd.template.editor.widget.scalerotate;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.introvd.template.common.ApiHelper;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.editor.R;
import com.introvd.template.editor.widget.scalerotate.C7070b.C7072b;
import com.introvd.template.editor.widget.scalerotate.C7070b.C7073c;
import com.introvd.template.editor.widget.scalerotate.C7070b.C7074d;
import com.introvd.template.editor.widget.scalerotate.p295a.C7065a;
import com.introvd.template.editor.widget.scalerotate.p295a.C7066b;
import com.introvd.template.editor.widget.scalerotate.p295a.C7068c;
import com.introvd.template.router.editor.EditorRouter;
import com.introvd.template.sdk.model.StylePositionModel;
import com.introvd.template.sdk.model.editor.ScaleRotateViewState;
import java.io.IOException;

public class ScaleRotateView extends RelativeLayout {
    GestureDetector aML;
    private Drawable cvA = null;
    private Drawable cvB = null;
    private boolean cvC = false;
    int cwg;
    private ScaleRotateViewState cwh = null;
    /* access modifiers changed from: private */
    public boolean cwi = true;
    private Drawable cwj = null;
    private Drawable cwk = null;
    private Drawable cwl = null;
    private Drawable cwm = null;
    /* access modifiers changed from: private */
    public boolean cwn;
    private RectF cwq = new RectF();
    private RectF cwr = new RectF();
    private PointF cws = new PointF();
    private float cwt;
    private OnDoubleTapListener cwu = new OnDoubleTapListener() {
        public boolean onDoubleTap(MotionEvent motionEvent) {
            StringBuilder sb = new StringBuilder();
            sb.append("TouchEvent GestureDetector onDoubleTap:");
            sb.append(motionEvent);
            sb.append(";isInOpState=");
            sb.append(ScaleRotateView.this.cwn);
            LogUtilsV2.m14227d(sb.toString());
            if (!ScaleRotateView.this.cwn || ScaleRotateView.this.dss == null) {
                return false;
            }
            ScaleRotateView.this.dss.mo28670B(motionEvent);
            return true;
        }

        public boolean onDoubleTapEvent(MotionEvent motionEvent) {
            return false;
        }

        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            StringBuilder sb = new StringBuilder();
            sb.append("TouchEvent GestureDetector onSingleTapConfirmed2:");
            sb.append(motionEvent);
            sb.append(";isInOpState=");
            sb.append(ScaleRotateView.this.cwn);
            LogUtilsV2.m14227d(sb.toString());
            if (!ScaleRotateView.this.cwn) {
                if (ScaleRotateView.this.dss != null) {
                    ScaleRotateView.this.dss.mo28669A(motionEvent);
                    return true;
                }
            } else if (ScaleRotateView.this.dsl != null) {
                if ((ScaleRotateView.this.dsl.mo31128t(motionEvent.getX(), motionEvent.getY()) & 64) == 64) {
                    if (ScaleRotateView.this.dss != null) {
                        ScaleRotateView.this.dss.mo28671G(motionEvent);
                    }
                    return true;
                }
                ScaleRotateView.this.dsl.mo31129u(motionEvent.getX(), motionEvent.getY());
                ScaleRotateView.this.dsl.mo31065a(C7072b.None);
            }
            return true;
        }
    };
    private C7073c drG = null;
    private Drawable drM = null;
    private boolean drR;
    /* access modifiers changed from: private */
    public C7070b dsl;
    private boolean dsm = false;
    private Drawable dsn = null;
    private Drawable dso = null;
    private boolean dsp = false;
    private C7063c dsq;
    private C7074d dsr = null;
    /* access modifiers changed from: private */
    public C7061a dss;
    private C7068c dsu;

    /* renamed from: com.introvd.template.editor.widget.scalerotate.ScaleRotateView$a */
    public interface C7061a {
        /* renamed from: A */
        void mo28669A(MotionEvent motionEvent);

        /* renamed from: B */
        void mo28670B(MotionEvent motionEvent);

        /* renamed from: G */
        void mo28671G(MotionEvent motionEvent);

        void ada();

        /* renamed from: ei */
        void mo28673ei(boolean z);

        /* renamed from: ej */
        void mo28674ej(boolean z);
    }

    /* renamed from: com.introvd.template.editor.widget.scalerotate.ScaleRotateView$b */
    public class C7062b extends SimpleOnGestureListener {
        public C7062b() {
        }

        public boolean onDown(MotionEvent motionEvent) {
            StringBuilder sb = new StringBuilder();
            sb.append("TouchEvent GestureDetector onDown:");
            sb.append(motionEvent);
            LogUtilsV2.m14227d(sb.toString());
            if (ScaleRotateView.this.dsl == null) {
                return false;
            }
            int t = ScaleRotateView.this.dsl.mo31128t(motionEvent.getX(), motionEvent.getY());
            if (t != 1) {
                ScaleRotateView.this.cwg = t;
                C7072b bVar = t != 32 ? t != 64 ? t != 128 ? t != 256 ? t != 512 ? t != 1024 ? C7072b.Grow : C7072b.TopStretch : C7072b.RightStretch : C7072b.BottomStretch : C7072b.LeftStretch : C7072b.Move : C7072b.Rotate;
                ScaleRotateView.this.dsl.mo31065a(bVar);
            }
            return super.onDown(motionEvent);
        }

        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            StringBuilder sb = new StringBuilder();
            sb.append("TouchEvent GestureDetector onScroll:");
            sb.append(motionEvent);
            LogUtilsV2.m14227d(sb.toString());
            if (!ScaleRotateView.this.cwi || motionEvent == null || motionEvent2 == null || ScaleRotateView.this.dsl == null || motionEvent.getPointerCount() > 1 || motionEvent2.getPointerCount() > 1) {
                return false;
            }
            if (ScaleRotateView.this.cwg == 1) {
                return super.onScroll(motionEvent, motionEvent2, f, f2);
            }
            ScaleRotateView.this.dsl.mo31063a(ScaleRotateView.this.cwg, motionEvent2, -f, -f2);
            return true;
        }

        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            StringBuilder sb = new StringBuilder();
            sb.append("TouchEvent GestureDetector onSingleTapConfirmed:");
            sb.append(motionEvent);
            LogUtilsV2.m14227d(sb.toString());
            if (ScaleRotateView.this.dsl == null) {
                return false;
            }
            return super.onSingleTapConfirmed(motionEvent);
        }

        public boolean onSingleTapUp(MotionEvent motionEvent) {
            StringBuilder sb = new StringBuilder();
            sb.append("TouchEvent GestureDetector onSingleTapUp:");
            sb.append(motionEvent);
            LogUtilsV2.m14227d(sb.toString());
            return super.onSingleTapUp(motionEvent);
        }
    }

    /* renamed from: com.introvd.template.editor.widget.scalerotate.ScaleRotateView$c */
    public interface C7063c {
        /* renamed from: E */
        void mo28582E(MotionEvent motionEvent);

        /* renamed from: F */
        void mo28583F(MotionEvent motionEvent);
    }

    public ScaleRotateView(Context context) {
        super(context);
        init();
    }

    public ScaleRotateView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ScaleRotateView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    /* renamed from: a */
    private RectF m20650a(Matrix matrix, float f, float f2, StylePositionModel stylePositionModel) {
        float f3 = stylePositionModel.getmCenterPosX() - (f / 2.0f);
        float f4 = stylePositionModel.getmCenterPosY() - (f2 / 2.0f);
        Matrix matrix2 = new Matrix(matrix);
        matrix2.invert(matrix2);
        float[] fArr = {f3, f4, f3 + f, f4 + f2};
        matrix2.mapPoints(fArr);
        return new RectF(fArr[0], fArr[1], fArr[2], fArr[3]);
    }

    /* renamed from: a */
    private RectF m20651a(ScaleRotateViewState scaleRotateViewState, Matrix matrix, int i, int i2, float f, float f2) {
        if (scaleRotateViewState.mPosInfo.getmCenterPosX() < 30.0f) {
            scaleRotateViewState.mPosInfo.setmCenterPosX(30.0f);
        } else {
            float f3 = (float) (i - 30);
            if (scaleRotateViewState.mPosInfo.getmCenterPosX() > f3) {
                scaleRotateViewState.mPosInfo.setmCenterPosX(f3);
            }
        }
        if (scaleRotateViewState.mPosInfo.getmCenterPosY() < 30.0f) {
            scaleRotateViewState.mPosInfo.setmCenterPosY(30.0f);
        } else {
            float f4 = (float) (i2 - 30);
            if (scaleRotateViewState.mPosInfo.getmCenterPosY() > f4) {
                scaleRotateViewState.mPosInfo.setmCenterPosY(f4);
            }
        }
        return m20650a(matrix, f, f2, scaleRotateViewState.mPosInfo);
    }

    /* renamed from: a */
    private void m20652a(RectF rectF, float f) {
        rectF.left -= f;
        rectF.right += f;
        rectF.top -= f;
        rectF.bottom += f;
    }

    /* renamed from: a */
    private void m20653a(C7072b bVar, int i) {
        if (bVar != C7072b.None && this.drG != null) {
            this.drG.mo28377mj(i);
        }
    }

    /* renamed from: a */
    private void m20654a(float[] fArr, RectF rectF, float f) {
        Matrix matrix = new Matrix();
        matrix.postTranslate(-rectF.centerX(), -rectF.centerY());
        matrix.postRotate(-f);
        matrix.postTranslate(rectF.centerX(), rectF.centerY());
        matrix.mapPoints(fArr);
    }

    /* renamed from: a */
    private boolean m20655a(RectF rectF, RectF rectF2, float f) {
        return rectF != null && rectF2 != null && rectF.width() > 0.0f && rectF.height() > 0.0f && rectF2.width() > 0.0f && rectF2.height() > 0.0f && (rectF.width() * rectF.height() < (rectF2.width() * rectF2.height()) / f || rectF.width() * rectF.height() > (rectF2.width() * rectF2.height()) * f);
    }

    /* renamed from: b */
    private float m20657b(PointF pointF, PointF pointF2) {
        return (float) Math.toDegrees((double) (((float) Math.atan2((double) pointF2.y, (double) pointF2.x)) - ((float) Math.atan2((double) pointF.y, (double) pointF.x))));
    }

    @SuppressLint({"NewApi"})
    private void init() {
        this.aML = new GestureDetector(getContext(), new C7062b());
        this.aML.setOnDoubleTapListener(this.cwu);
        this.aML.setIsLongpressEnabled(false);
        this.cwg = 1;
        boolean z = ApiHelper.HONEYCOMB_AND_HIGHER;
    }

    /* renamed from: z */
    private float m20661z(MotionEvent motionEvent) {
        float x = motionEvent.getX(0) - motionEvent.getX(1);
        float y = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((double) ((x * x) + (y * y)));
    }

    /* renamed from: E */
    public void mo31001E(int i, int i2, int i3) {
        if (this.dsl != null) {
            this.dsl.mo31054E(i, i2, i3);
        }
    }

    /* renamed from: L */
    public void mo31002L(float f, float f2) {
        if (this.dsl != null) {
            this.dsl.mo31061K(f, f2);
        }
    }

    public void clear() {
        this.cwh = null;
        if (this.dsl != null) {
            this.dsl.setBitmap(null);
        }
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        canvas.saveLayerAlpha(0.0f, 0.0f, (float) canvas.getWidth(), (float) canvas.getHeight(), 255, 31);
        if (this.dsl != null) {
            this.dsl.draw(canvas);
        }
        super.dispatchDraw(canvas);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.dsl == null) {
            return false;
        }
        int action = motionEvent.getAction();
        float[] fArr = {motionEvent.getX(), motionEvent.getY()};
        if (action == 0) {
            RectF strokeRectF = getStrokeRectF();
            m20652a(strokeRectF, 40.0f);
            m20654a(fArr, strokeRectF, this.dsl.acP());
            this.cwn = strokeRectF.contains(fArr[0], fArr[1]);
        }
        if (!this.cwn) {
            return false;
        }
        if (action == 0 || action == 5) {
            if (!(this.dsl == null || this.dsl.acY() == null)) {
                this.cwq.set(this.dsl.acY());
            }
            if (this.dss != null) {
                this.dss.ada();
            }
        } else if (action == 1 || action == 3) {
            if (!(this.dsl == null || this.dsl.acY() == null)) {
                this.cwr.set(this.dsl.acY());
            }
            if (this.dss != null) {
                boolean a = m20655a(this.cwq, this.cwr, 4.0f);
                if (a) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("mRectUp=");
                    sb.append(this.cwr.width());
                    sb.append(EditorRouter.KEY_TOOL_LIST_ORDER_SPLIT_OP);
                    sb.append(this.cwr.height());
                    sb.append(";mRectDown=");
                    sb.append(this.cwq.width());
                    sb.append(EditorRouter.KEY_TOOL_LIST_ORDER_SPLIT_OP);
                    sb.append(this.cwq.height());
                    LogUtilsV2.m14227d(sb.toString());
                    this.cwq.set(0.0f, 0.0f, 0.0f, 0.0f);
                }
                this.dss.mo28673ei(a);
            }
        } else if (action == 2 && this.dsl != null && this.dsl.acY() != null && !this.dsl.mo31091ck((int) fArr[0], (int) fArr[1])) {
            this.cwr.set(this.dsl.acY());
            if (this.dss != null) {
                boolean a2 = m20655a(this.cwq, this.cwr, 2.0f);
                if (a2) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("mRectUp=");
                    sb2.append(this.cwr.width());
                    sb2.append(EditorRouter.KEY_TOOL_LIST_ORDER_SPLIT_OP);
                    sb2.append(this.cwr.height());
                    sb2.append(";mRectDown=");
                    sb2.append(this.cwq.width());
                    sb2.append(EditorRouter.KEY_TOOL_LIST_ORDER_SPLIT_OP);
                    sb2.append(this.cwq.height());
                    LogUtilsV2.m14227d(sb2.toString());
                    this.cwq.set(this.cwr);
                }
                this.dss.mo28674ej(a2);
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    /* renamed from: eh */
    public void mo31006eh(boolean z) {
        if (this.dsl != null) {
            this.dsl.mo31096ec(z);
            invalidate();
        }
    }

    public C7074d getDelListener() {
        return this.dsr;
    }

    public RectF getDisplayRec() {
        if (this.dsl == null) {
            return null;
        }
        return this.dsl.getDisplayRec();
    }

    public ScaleRotateViewState getScaleViewState() {
        ScaleRotateViewState scaleRotateViewState = this.cwh == null ? new ScaleRotateViewState() : new ScaleRotateViewState(this.cwh);
        if (this.dsl == null) {
            return scaleRotateViewState;
        }
        scaleRotateViewState.mDegree = this.dsl.acP();
        scaleRotateViewState.mOutlineEllipse = this.dsl.acQ();
        scaleRotateViewState.mOutlineStrokeColor = this.dsl.acR();
        scaleRotateViewState.mPadding = this.dsl.getPadding();
        scaleRotateViewState.mAlpha = this.dsl.auR();
        RectF acY = this.dsl.acY();
        scaleRotateViewState.mPosInfo.setmCenterPosX(acY.centerX());
        scaleRotateViewState.mPosInfo.setmCenterPosY(acY.centerY());
        scaleRotateViewState.mViewRect = new RectF(acY);
        scaleRotateViewState.mPosInfo.setmWidth(acY.width());
        scaleRotateViewState.mPosInfo.setmHeight(acY.height());
        scaleRotateViewState.mStrokeWidth = this.dsl.acS().getStrokeWidth();
        scaleRotateViewState.setAnimOn(this.dsl.isAnimOn());
        scaleRotateViewState.setSupportAnim(this.dsl.acO());
        return scaleRotateViewState;
    }

    public RectF getStrokeRectF() {
        if (this.dsl != null) {
            return this.dsl.acI();
        }
        return null;
    }

    public C7061a getmOnGestureListener() {
        return this.dss;
    }

    /* renamed from: hM */
    public void mo31012hM(boolean z) {
        if (this.dsl != null) {
            this.dsl.mo31102hH(z);
            invalidate();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.aML == null || this.dsl == null) {
            return false;
        }
        int action = motionEvent.getAction() & 255;
        StringBuilder sb = new StringBuilder();
        sb.append("onTouchEvent action=");
        sb.append(action);
        sb.append(";isInOpState=");
        sb.append(this.cwn);
        LogUtilsV2.m14227d(sb.toString());
        if (this.cwn) {
            switch (action) {
                case 0:
                    if (this.dsq != null) {
                        this.dsq.mo28583F(motionEvent);
                        break;
                    }
                    break;
                case 1:
                case 3:
                    m20653a(this.dsl.auM(), 1);
                    this.dsl.mo31065a(C7072b.None);
                    this.cwg = 1;
                    if (this.dsq != null) {
                        this.dsq.mo28582E(motionEvent);
                    }
                    this.dsl.auQ();
                    break;
                case 2:
                    if (this.dsl.auM() == C7072b.Pointer_Grow && motionEvent.getPointerCount() == 2 && !this.dsp) {
                        float z = m20661z(motionEvent);
                        float f = z - this.cwt;
                        if (Math.abs(f) > 5.0f) {
                            PointF pointF = new PointF(motionEvent.getX(0) - motionEvent.getX(1), motionEvent.getY(0) - motionEvent.getY(1));
                            this.dsl.mo31083ah(m20657b(this.cws, pointF));
                            this.dsl.invalidate();
                            this.cws.set(pointF.x, pointF.y);
                            this.dsl.mo31082ag(f);
                            this.cwt = z;
                        }
                        invalidate();
                    }
                    m20653a(this.dsl.auM(), 2);
                    break;
                case 5:
                    if (motionEvent.getPointerCount() == 2) {
                        this.dsl.mo31065a(C7072b.Pointer_Grow);
                        this.cwt = m20661z(motionEvent);
                        this.cws.set(motionEvent.getX(0) - motionEvent.getX(1), motionEvent.getY(0) - motionEvent.getY(1));
                        break;
                    }
                    break;
            }
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (this.dsl.auM() == C7072b.Rotate && (x <= 20.0f || y <= 20.0f || x >= ((float) getWidth()) - 20.0f || y >= ((float) getHeight()) - 20.0f)) {
                return true;
            }
            if (this.dsl.auM() == C7072b.Move && (x <= 10.0f || y <= 10.0f || x >= ((float) getWidth()) - 10.0f || y >= ((float) getHeight()) - 10.0f)) {
                return true;
            }
        }
        this.aML.onTouchEvent(motionEvent);
        return true;
    }

    /* renamed from: qi */
    public void mo31014qi(int i) {
        if (this.dsl != null) {
            this.dsl.mo31115qh(i);
        }
    }

    public void setAnchorAnimDrawable(Drawable drawable, Drawable drawable2) {
        this.cwl = drawable;
        this.cwm = drawable2;
        if (this.dsl != null) {
            this.dsl.setAnchorAnimDrawable(drawable, drawable2);
        }
    }

    public void setAnchorDrawable(Drawable drawable, Drawable drawable2) {
        this.cwj = drawable;
        this.cwk = drawable2;
        if (this.dsl != null) {
            this.dsl.setAnchorDrawable(drawable, drawable2);
        }
    }

    public void setDelAnchorDrawable(Drawable drawable) {
        this.cwk = drawable;
        if (this.dsl != null) {
            this.dsl.mo31058H(drawable);
        }
    }

    public void setDelListener(C7074d dVar) {
        this.dsr = dVar;
    }

    public void setDrawRectChangeListener(C7073c cVar) {
        this.drG = cVar;
    }

    public void setEnableFlip(boolean z) {
        this.cvC = z;
    }

    public void setEnableScale(boolean z) {
        this.cwi = z;
    }

    public void setFlipDrawable(Drawable drawable, Drawable drawable2) {
        if (!(this.dsl == null || this.cwh == null || this.cwh.isDftTemplate)) {
            this.dsl.mo31056F(drawable2);
            this.dsl.mo31055E(drawable);
        }
        this.cvA = drawable;
        this.cvB = drawable2;
    }

    public void setHorFlip(boolean z) {
        if (this.dsl != null) {
            this.dsl.setHorFlip(z);
        }
    }

    public void setReplaceAnchorDrawable(Drawable drawable) {
        this.dsn = drawable;
        if (this.dsl != null) {
            this.dsl.mo31060I(drawable);
        }
    }

    public void setScaleRotateBitmap(Bitmap bitmap) {
        if (this.dsl != null && bitmap != null) {
            this.dsl.setBitmap(bitmap);
        }
    }

    public void setScaleRotateViewDecoder(C7068c cVar) {
        this.dsu = cVar;
    }

    public void setScaleViewState(ScaleRotateViewState scaleRotateViewState) {
        Boolean bool;
        Boolean bool2;
        Bitmap bitmap;
        if (scaleRotateViewState != null) {
            this.cwh = new ScaleRotateViewState(scaleRotateViewState);
            Boolean bool3 = null;
            if (this.dsl != null) {
                this.dsl.dispose();
                bool2 = Boolean.valueOf(this.dsl.auO());
                Boolean valueOf = Boolean.valueOf(this.dsl.auN());
                bool = Boolean.valueOf(this.dsl.auP());
                this.dsl = null;
                bool3 = valueOf;
            } else {
                bool2 = null;
                bool = null;
            }
            this.dsl = new C7070b(this);
            if (bool3 != null) {
                this.dsl.mo31103hI(bool3.booleanValue());
            }
            if (bool != null) {
                this.dsl.mo31105hK(bool.booleanValue());
            }
            if (bool2 != null) {
                this.dsl.mo31104hJ(bool2.booleanValue());
            }
            this.dsl.setAnchorDrawable(this.cwj, this.cwk);
            this.dsl.mo31060I(this.dsn);
            this.dsl.setAnchorAnimDrawable(this.cwl, this.cwm);
            this.dsl.setEnableFlip(this.cvC);
            this.dsl.setStretchDrawable(this.drM);
            this.dsl.mo31057G(this.dso);
            this.dsl.mo31106hL(this.dsp);
            if (!scaleRotateViewState.isDftTemplate && !this.drR) {
                setFlipDrawable(this.cvA, this.cvB);
            }
            this.dsl.mo31094ea(scaleRotateViewState.isSupportAnim());
            this.dsl.setAnimOn(scaleRotateViewState.isAnimOn());
            Matrix matrix = new Matrix();
            int width = getWidth();
            int height = getHeight();
            float f = scaleRotateViewState.mPosInfo.getmWidth();
            float f2 = scaleRotateViewState.mPosInfo.getmHeight();
            if (f2 > 0.0f) {
                this.dsl.mo31084ai(f / f2);
            }
            if (f2 < this.dsl.acU() || f < this.dsl.acV()) {
                float acV = this.dsl.acV() / f;
                float acU = this.dsl.acU() / f2;
                if (acV < acU) {
                    acV = acU;
                }
                f = (float) ((int) (f * acV));
                f2 = (float) ((int) (f2 * acV));
            }
            if (f > this.dsl.acW() || f2 > this.dsl.acX()) {
                float acW = this.dsl.acW() / f;
                float acX = this.dsl.acX() / f2;
                if (acW >= acX) {
                    acW = acX;
                }
                f = (float) ((int) (f * acW));
                f2 = (float) ((int) (f2 * acW));
            }
            float f3 = f;
            float f4 = f2;
            RectF a = m20650a(matrix, f3, f4, scaleRotateViewState.mPosInfo);
            if (!new Rect(0, 0, width, height).intersect(new Rect((int) a.left, (int) a.top, (int) a.right, (int) a.bottom))) {
                a = m20651a(scaleRotateViewState, matrix, width, height, f3, f4);
            }
            this.dsl.setmSelected(true);
            this.dsl.mo31095eb(true);
            this.dsl.mo31097ed(true);
            this.dsl.mo31064a(matrix, a, false);
            this.dsl.setRotate(scaleRotateViewState.mDegree);
            this.dsl.mo31099ef(false);
            this.dsl.mo31098ee(true);
            this.dsl.setPadding(scaleRotateViewState.mPadding);
            this.dsl.mo31112kS(getResources().getColor(R.color.white));
            this.dsl.mo31114qg(getResources().getColor(R.color.color_ff5e13));
            this.dsl.mo31111kR(scaleRotateViewState.mOutlineEllipse);
            this.dsl.mo31067a(this.dsr);
            this.dsl.mo31066a(this.drG);
            setHorFlip(scaleRotateViewState.isHorFlip);
            setVerFlip(scaleRotateViewState.isVerFlip);
            this.dsl.invalidate();
            if (!this.cwi) {
                this.dsl.mo31097ed(false);
            }
            this.dsl.acS().setStrokeWidth(scaleRotateViewState.mStrokeWidth);
            if (this.dsl.acN() == null && this.dsu != null) {
                try {
                    if (this.dsu instanceof C7065a) {
                        bitmap = C7066b.auS().getBitmap(getScaleViewState().mStylePath);
                        if (bitmap == null) {
                            bitmap = this.dsu.mo31043q(getScaleViewState());
                            C7066b.auS().mo31045d(getScaleViewState().mStylePath, bitmap);
                        }
                    } else {
                        bitmap = this.dsu.mo31043q(getScaleViewState());
                    }
                    this.dsl.setBitmap(bitmap);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void setSimpleMode(boolean z) {
        this.dsp = z;
    }

    public void setStretchDrawable(Drawable drawable) {
        this.drM = drawable;
        this.drR = true;
    }

    public void setTextAnimOn(boolean z) {
        if (this.dsl != null) {
            this.dsl.setAnimOn(z);
        }
        invalidate();
    }

    public void setTouchUpEvent(C7063c cVar) {
        this.dsq = cVar;
    }

    public void setVerFlip(boolean z) {
        if (this.dsl != null) {
            this.dsl.setVerFlip(z);
        }
    }

    public void setViewPosition(Rect rect, float f) {
        if (this.dsl != null) {
            this.dsl.setViewPosition(rect, f);
        }
    }

    public void setWatermarkDeleteDrawable(Drawable drawable) {
        this.dso = drawable;
    }

    public void setmOnGestureListener(C7061a aVar) {
        this.dss = aVar;
    }
}
