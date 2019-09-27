package com.introvd.template.editor.advance;

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
import com.introvd.template.common.LogUtils;
import com.introvd.template.editor.advance.C5605j.C5607b;
import com.introvd.template.editor.advance.C5605j.C5608c;
import com.introvd.template.router.editor.EditorRouter;
import com.introvd.template.sdk.model.StylePositionModel;
import com.introvd.template.sdk.model.editor.ScaleRotateViewState;

public class ScaleRotateViewV4 extends RelativeLayout {
    /* access modifiers changed from: private */
    public static final String TAG = "ScaleRotateViewV4";
    GestureDetector aML;
    private Drawable cvA = null;
    private Drawable cvB = null;
    private boolean cvC = false;
    /* access modifiers changed from: private */
    public C5605j cwf;
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
    private C5608c cwo = null;
    /* access modifiers changed from: private */
    public C5579a cwp;
    private RectF cwq = new RectF();
    private RectF cwr = new RectF();
    private PointF cws = new PointF();
    private float cwt;
    private OnDoubleTapListener cwu = new OnDoubleTapListener() {
        public boolean onDoubleTap(MotionEvent motionEvent) {
            String access$000 = ScaleRotateViewV4.TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("TouchEvent GestureDetector onDoubleTap:");
            sb.append(motionEvent);
            sb.append(";isInOpState=");
            sb.append(ScaleRotateViewV4.this.cwn);
            LogUtils.m14223i(access$000, sb.toString());
            if (!ScaleRotateViewV4.this.cwn || ScaleRotateViewV4.this.cwp == null) {
                return false;
            }
            ScaleRotateViewV4.this.cwp.mo27463B(motionEvent);
            return true;
        }

        public boolean onDoubleTapEvent(MotionEvent motionEvent) {
            return false;
        }

        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            String access$000 = ScaleRotateViewV4.TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("TouchEvent GestureDetector onSingleTapConfirmed2:");
            sb.append(motionEvent);
            sb.append(";isInOpState=");
            sb.append(ScaleRotateViewV4.this.cwn);
            LogUtils.m14223i(access$000, sb.toString());
            if (!ScaleRotateViewV4.this.cwn) {
                if (ScaleRotateViewV4.this.cwp != null) {
                    ScaleRotateViewV4.this.cwp.mo27462A(motionEvent);
                    return true;
                }
            } else if (ScaleRotateViewV4.this.cwf != null) {
                if ((ScaleRotateViewV4.this.cwf.mo27595t(motionEvent.getX(), motionEvent.getY()) & 64) == 64) {
                    if (ScaleRotateViewV4.this.cwp != null) {
                        ScaleRotateViewV4.this.cwp.adb();
                    }
                    return true;
                }
                ScaleRotateViewV4.this.cwf.mo27596u(motionEvent.getX(), motionEvent.getY());
                ScaleRotateViewV4.this.cwf.mo27549a(C5607b.None);
            }
            return true;
        }
    };

    /* renamed from: com.introvd.template.editor.advance.ScaleRotateViewV4$a */
    public interface C5579a {
        /* renamed from: A */
        void mo27462A(MotionEvent motionEvent);

        /* renamed from: B */
        void mo27463B(MotionEvent motionEvent);

        void ada();

        void adb();

        /* renamed from: ei */
        void mo27466ei(boolean z);

        /* renamed from: ej */
        void mo27467ej(boolean z);
    }

    /* renamed from: com.introvd.template.editor.advance.ScaleRotateViewV4$b */
    public class C5580b extends SimpleOnGestureListener {
        public C5580b() {
        }

        public boolean onDown(MotionEvent motionEvent) {
            String access$000 = ScaleRotateViewV4.TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("TouchEvent GestureDetector onDown:");
            sb.append(motionEvent);
            LogUtils.m14223i(access$000, sb.toString());
            if (ScaleRotateViewV4.this.cwf == null) {
                return false;
            }
            int t = ScaleRotateViewV4.this.cwf.mo27595t(motionEvent.getX(), motionEvent.getY());
            if (t != 1) {
                ScaleRotateViewV4.this.cwg = t;
                C5607b bVar = t == 64 ? C5607b.Move : t == 32 ? C5607b.Rotate : C5607b.Grow;
                ScaleRotateViewV4.this.cwf.mo27549a(bVar);
            }
            return super.onDown(motionEvent);
        }

        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            String access$000 = ScaleRotateViewV4.TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("TouchEvent GestureDetector onScroll:");
            sb.append(motionEvent);
            LogUtils.m14223i(access$000, sb.toString());
            if (!ScaleRotateViewV4.this.cwi || motionEvent == null || motionEvent2 == null || ScaleRotateViewV4.this.cwf == null || motionEvent.getPointerCount() > 1 || motionEvent2.getPointerCount() > 1) {
                return false;
            }
            if (ScaleRotateViewV4.this.cwg == 1) {
                return super.onScroll(motionEvent, motionEvent2, f, f2);
            }
            ScaleRotateViewV4.this.cwf.mo27547a(ScaleRotateViewV4.this.cwg, motionEvent2, -f, -f2);
            return true;
        }

        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            String access$000 = ScaleRotateViewV4.TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("TouchEvent GestureDetector onSingleTapConfirmed:");
            sb.append(motionEvent);
            LogUtils.m14223i(access$000, sb.toString());
            if (ScaleRotateViewV4.this.cwf == null) {
                return false;
            }
            return super.onSingleTapConfirmed(motionEvent);
        }

        public boolean onSingleTapUp(MotionEvent motionEvent) {
            String access$000 = ScaleRotateViewV4.TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("TouchEvent GestureDetector onSingleTapUp:");
            sb.append(motionEvent);
            LogUtils.m14223i(access$000, sb.toString());
            return super.onSingleTapUp(motionEvent);
        }
    }

    public ScaleRotateViewV4(Context context) {
        super(context);
        init();
    }

    public ScaleRotateViewV4(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ScaleRotateViewV4(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    /* renamed from: a */
    private RectF m15203a(Matrix matrix, float f, float f2, StylePositionModel stylePositionModel) {
        float f3 = stylePositionModel.getmCenterPosX() - (f / 2.0f);
        float f4 = stylePositionModel.getmCenterPosY() - (f2 / 2.0f);
        Matrix matrix2 = new Matrix(matrix);
        matrix2.invert(matrix2);
        float[] fArr = {f3, f4, f3 + f, f4 + f2};
        matrix2.mapPoints(fArr);
        return new RectF(fArr[0], fArr[1], fArr[2], fArr[3]);
    }

    /* renamed from: a */
    private RectF m15204a(ScaleRotateViewState scaleRotateViewState, Matrix matrix, float f, float f2, float f3, float f4) {
        if (scaleRotateViewState.mPosInfo.getmCenterPosX() < 30.0f) {
            scaleRotateViewState.mPosInfo.setmCenterPosX(30.0f);
        } else {
            float f5 = f - 30.0f;
            if (scaleRotateViewState.mPosInfo.getmCenterPosX() > f5) {
                scaleRotateViewState.mPosInfo.setmCenterPosX(f5);
            }
        }
        if (scaleRotateViewState.mPosInfo.getmCenterPosY() < 30.0f) {
            scaleRotateViewState.mPosInfo.setmCenterPosY(30.0f);
        } else {
            float f6 = f2 - 30.0f;
            if (scaleRotateViewState.mPosInfo.getmCenterPosY() > f6) {
                scaleRotateViewState.mPosInfo.setmCenterPosY(f6);
            }
        }
        return m15203a(matrix, f3, f4, scaleRotateViewState.mPosInfo);
    }

    /* renamed from: a */
    private void m15205a(RectF rectF, float f) {
        rectF.left -= f;
        rectF.right += f;
        rectF.top -= f;
        rectF.bottom += f;
    }

    /* renamed from: a */
    private void m15206a(float[] fArr, RectF rectF, float f) {
        Matrix matrix = new Matrix();
        matrix.postTranslate(-rectF.centerX(), -rectF.centerY());
        matrix.postRotate(-f);
        matrix.postTranslate(rectF.centerX(), rectF.centerY());
        matrix.mapPoints(fArr);
    }

    /* renamed from: a */
    private boolean m15207a(RectF rectF, RectF rectF2, float f) {
        return rectF != null && rectF2 != null && rectF.width() > 0.0f && rectF.height() > 0.0f && rectF2.width() > 0.0f && rectF2.height() > 0.0f && (rectF.width() * rectF.height() < (rectF2.width() * rectF2.height()) / f || rectF.width() * rectF.height() > (rectF2.width() * rectF2.height()) * f);
    }

    /* renamed from: b */
    private float m15209b(PointF pointF, PointF pointF2) {
        return (float) Math.toDegrees((double) (((float) Math.atan2((double) pointF2.y, (double) pointF2.x)) - ((float) Math.atan2((double) pointF.y, (double) pointF.x))));
    }

    @SuppressLint({"NewApi"})
    private void init() {
        this.aML = new GestureDetector(getContext(), new C5580b());
        this.aML.setOnDoubleTapListener(this.cwu);
        this.aML.setIsLongpressEnabled(false);
        this.cwg = 1;
        boolean z = ApiHelper.HONEYCOMB_AND_HIGHER;
    }

    /* renamed from: z */
    private float m15213z(MotionEvent motionEvent) {
        float x = motionEvent.getX(0) - motionEvent.getX(1);
        float y = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((double) ((x * x) + (y * y)));
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        canvas.saveLayerAlpha(0.0f, 0.0f, (float) canvas.getWidth(), (float) canvas.getHeight(), 255, 31);
        if (this.cwf != null) {
            this.cwf.draw(canvas);
        }
        super.dispatchDraw(canvas);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.cwf == null) {
            return false;
        }
        int action = motionEvent.getAction();
        float[] fArr = {motionEvent.getX(), motionEvent.getY()};
        if (action == 0) {
            RectF strokeRectF = getStrokeRectF();
            m15205a(strokeRectF, 40.0f);
            m15206a(fArr, strokeRectF, this.cwf.acP());
            this.cwn = strokeRectF.contains(fArr[0], fArr[1]);
        }
        if (!this.cwn) {
            return false;
        }
        if (action == 0 || action == 5) {
            if (!(this.cwf == null || this.cwf.acY() == null)) {
                this.cwq.set(this.cwf.acY());
            }
            if (this.cwp != null) {
                this.cwp.ada();
            }
        } else if (action == 1 || action == 3) {
            if (!(this.cwf == null || this.cwf.acY() == null)) {
                this.cwr.set(this.cwf.acY());
            }
            if (this.cwp != null) {
                boolean a = m15207a(this.cwq, this.cwr, 4.0f);
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
                    LogUtils.m14223i("View", sb.toString());
                    this.cwq.set(0.0f, 0.0f, 0.0f, 0.0f);
                }
                this.cwp.mo27466ei(a);
            }
        } else if (action == 2 && this.cwf != null && this.cwf.acY() != null && !this.cwf.mo27569ck((int) fArr[0], (int) fArr[1])) {
            this.cwr.set(this.cwf.acY());
            if (this.cwp != null) {
                boolean a2 = m15207a(this.cwq, this.cwr, 2.0f);
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
                    LogUtils.m14223i("View", sb2.toString());
                    this.cwq.set(this.cwr);
                }
                this.cwp.mo27467ej(a2);
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    /* renamed from: eh */
    public void mo27439eh(boolean z) {
        if (this.cwf != null) {
            this.cwf.mo27574ec(z);
        }
    }

    public C5608c getDelListener() {
        return this.cwo;
    }

    public Drawable getScaleRotateDrawable() {
        if (this.cwf == null) {
            return null;
        }
        return this.cwf.acN();
    }

    public ScaleRotateViewState getScaleViewState() {
        ScaleRotateViewState scaleRotateViewState = this.cwh == null ? new ScaleRotateViewState() : new ScaleRotateViewState(this.cwh);
        if (this.cwf == null) {
            return scaleRotateViewState;
        }
        scaleRotateViewState.mDegree = this.cwf.acP();
        scaleRotateViewState.mOutlineEllipse = this.cwf.acQ();
        scaleRotateViewState.mOutlineStrokeColor = this.cwf.acR();
        scaleRotateViewState.mPadding = this.cwf.getPadding();
        RectF acY = this.cwf.acY();
        scaleRotateViewState.mPosInfo.setmCenterPosX(acY.centerX());
        scaleRotateViewState.mPosInfo.setmCenterPosY(acY.centerY());
        scaleRotateViewState.mViewRect = new RectF(acY);
        scaleRotateViewState.mPosInfo.setmWidth((float) ((int) acY.width()));
        scaleRotateViewState.mPosInfo.setmHeight((float) ((int) acY.height()));
        scaleRotateViewState.mStrokeWidth = this.cwf.acS().getStrokeWidth();
        scaleRotateViewState.setAnimOn(this.cwf.isAnimOn());
        scaleRotateViewState.setSupportAnim(this.cwf.acO());
        return scaleRotateViewState;
    }

    public RectF getStrokeRectF() {
        if (this.cwf != null) {
            return this.cwf.acI();
        }
        return null;
    }

    public C5579a getmOnGestureListener() {
        return this.cwp;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.aML == null || this.cwf == null) {
            return false;
        }
        int action = motionEvent.getAction() & 255;
        String str = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("onTouchEvent action=");
        sb.append(action);
        sb.append(";isInOpState=");
        sb.append(this.cwn);
        LogUtils.m14223i(str, sb.toString());
        if (this.cwn) {
            switch (action) {
                case 1:
                case 3:
                    this.cwf.mo27549a(C5607b.None);
                    this.cwg = 1;
                    break;
                case 2:
                    if (this.cwf.acT() == C5607b.Pointer_Grow && motionEvent.getPointerCount() == 2) {
                        float z = m15213z(motionEvent);
                        float f = z - this.cwt;
                        if (Math.abs(f) > 5.0f) {
                            PointF pointF = new PointF(motionEvent.getX(0) - motionEvent.getX(1), motionEvent.getY(0) - motionEvent.getY(1));
                            this.cwf.mo27567ah(m15209b(this.cws, pointF));
                            this.cwf.invalidate();
                            this.cws.set(pointF.x, pointF.y);
                            this.cwf.mo27566ag(f);
                            this.cwt = z;
                        }
                        invalidate();
                        break;
                    }
                case 5:
                    if (motionEvent.getPointerCount() == 2) {
                        this.cwf.mo27549a(C5607b.Pointer_Grow);
                        this.cwt = m15213z(motionEvent);
                        this.cws.set(motionEvent.getX(0) - motionEvent.getX(1), motionEvent.getY(0) - motionEvent.getY(1));
                        break;
                    }
                    break;
            }
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (this.cwf.acT() == C5607b.Rotate && (x <= 20.0f || y <= 20.0f || x >= ((float) getWidth()) - 20.0f || y >= ((float) getHeight()) - 20.0f)) {
                return true;
            }
            if (this.cwf.acT() == C5607b.Move && (x <= 10.0f || y <= 10.0f || x >= ((float) getWidth()) - 10.0f || y >= ((float) getHeight()) - 10.0f)) {
                return true;
            }
        }
        this.aML.onTouchEvent(motionEvent);
        return true;
    }

    public void setAnchorAnimDrawable(Drawable drawable, Drawable drawable2) {
        this.cwl = drawable;
        this.cwm = drawable2;
        if (this.cwf != null) {
            this.cwf.setAnchorAnimDrawable(drawable, drawable2);
        }
    }

    public void setAnchorDrawable(Drawable drawable, Drawable drawable2) {
        this.cwj = drawable;
        this.cwk = drawable2;
        if (this.cwf != null) {
            this.cwf.setAnchorDrawable(drawable, drawable2);
        }
    }

    public void setDelAnchorDrawable(Drawable drawable) {
        this.cwk = drawable;
        if (this.cwf != null) {
            this.cwf.mo27543D(drawable);
        }
    }

    public void setDelListener(C5608c cVar) {
        this.cwo = cVar;
    }

    public void setEnableFlip(boolean z) {
        this.cvC = z;
    }

    public void setEnableScale(boolean z) {
        this.cwi = z;
    }

    public void setFlipDrawable(Drawable drawable, Drawable drawable2) {
        if (!(this.cwf == null || this.cwh == null || this.cwh.isDftTemplate)) {
            this.cwf.mo27545F(drawable2);
            this.cwf.mo27544E(drawable);
        }
        this.cvA = drawable;
        this.cvB = drawable2;
    }

    public void setHorFlip(boolean z) {
        if (this.cwf != null) {
            this.cwf.setHorFlip(z);
        }
    }

    public void setScaleRotateBitmap(Bitmap bitmap) {
        if (this.cwf != null && bitmap != null) {
            this.cwf.setBitmap(bitmap);
        }
    }

    public void setScaleViewState(ScaleRotateViewState scaleRotateViewState) {
        if (scaleRotateViewState != null) {
            this.cwh = new ScaleRotateViewState(scaleRotateViewState);
            if (this.cwf != null) {
                this.cwf.dispose();
                this.cwf = null;
            }
            this.cwf = new C5605j(this);
            this.cwf.setAnchorDrawable(this.cwj, this.cwk);
            this.cwf.setAnchorAnimDrawable(this.cwl, this.cwm);
            this.cwf.setEnableFlip(this.cvC);
            if (!scaleRotateViewState.isDftTemplate) {
                setFlipDrawable(this.cvA, this.cvB);
            }
            this.cwf.mo27572ea(scaleRotateViewState.isSupportAnim());
            if (scaleRotateViewState.mBitmap != null) {
                this.cwf.setBitmap(scaleRotateViewState.mBitmap);
            }
            this.cwf.setAnimOn(scaleRotateViewState.isAnimOn());
            Matrix matrix = new Matrix();
            int width = getWidth();
            int height = getHeight();
            float f = scaleRotateViewState.mPosInfo.getmWidth();
            float f2 = scaleRotateViewState.mPosInfo.getmHeight();
            if (f2 > 0.0f) {
                this.cwf.mo27568ai(f / f2);
            }
            if (f2 < this.cwf.acU() || f < this.cwf.acV()) {
                float acV = this.cwf.acV() / f;
                float acU = this.cwf.acU() / f2;
                if (acV < acU) {
                    acV = acU;
                }
                f = (float) ((int) (f * acV));
                f2 = (float) ((int) (f2 * acV));
            }
            if (f > this.cwf.acW() || f2 > this.cwf.acX()) {
                float acW = this.cwf.acW() / f;
                float acX = this.cwf.acX() / f2;
                if (acW >= acX) {
                    acW = acX;
                }
                f = (float) ((int) (f * acW));
                f2 = (float) ((int) (f2 * acW));
            }
            float f3 = f;
            float f4 = f2;
            RectF a = m15203a(matrix, f3, f4, scaleRotateViewState.mPosInfo);
            if (!new Rect(0, 0, width, height).intersect(new Rect((int) a.left, (int) a.top, (int) a.right, (int) a.bottom))) {
                float f5 = (float) height;
                a = m15204a(scaleRotateViewState, matrix, (float) width, f5, f3, f4);
            }
            this.cwf.setmSelected(true);
            this.cwf.mo27573eb(true);
            this.cwf.mo27575ed(true);
            this.cwf.mo27548a(matrix, a, false);
            this.cwf.setRotate(scaleRotateViewState.mDegree);
            this.cwf.mo27577ef(false);
            this.cwf.mo27576ee(true);
            this.cwf.setPadding(scaleRotateViewState.mPadding);
            this.cwf.mo27584kS(scaleRotateViewState.mOutlineStrokeColor);
            this.cwf.mo27583kR(scaleRotateViewState.mOutlineEllipse);
            this.cwf.mo27550a(this.cwo);
            setHorFlip(scaleRotateViewState.isHorFlip);
            setVerFlip(scaleRotateViewState.isVerFlip);
            this.cwf.invalidate();
            if (!this.cwi) {
                this.cwf.mo27575ed(false);
            }
            this.cwf.acS().setStrokeWidth(scaleRotateViewState.mStrokeWidth);
        }
    }

    public void setTextAnimOn(boolean z) {
        if (this.cwf != null) {
            this.cwf.setAnimOn(z);
        }
        invalidate();
    }

    public void setVerFlip(boolean z) {
        if (this.cwf != null) {
            this.cwf.setVerFlip(z);
        }
    }

    public void setmOnGestureListener(C5579a aVar) {
        this.cwp = aVar;
    }
}
