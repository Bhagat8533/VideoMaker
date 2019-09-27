package com.introvd.template.editor.pip;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.introvd.template.common.LogUtils;
import com.introvd.template.editor.R;
import com.introvd.template.p203b.C4583d;

public class TrimMaskView extends View {

    /* renamed from: CY */
    private Rect f3508CY;
    private volatile boolean cGk;
    private int cWV;
    private int cWW;
    private StateListDrawable cXK;
    private Drawable cXL;
    private StateListDrawable cXM;
    private Drawable cXN;
    private NinePatchDrawable cXO;
    private int cXP;
    private int cXQ;
    private int cXR;
    private boolean cXS;
    private float cXT;
    private float cXU;
    private float cXV;
    private int cXW;
    private int cXX;
    private int cXY;
    private int cXZ;
    private C6446a cXf;
    private volatile boolean cYa;
    private volatile boolean cYb;
    private volatile boolean cYc;
    private volatile boolean cYd;
    private int mDragState;
    private volatile int mOffset;
    private Paint mPaint;

    /* renamed from: com.introvd.template.editor.pip.TrimMaskView$a */
    public interface C6446a {
        void aoa();

        /* renamed from: eH */
        void mo29591eH(boolean z);

        /* renamed from: ky */
        void mo29592ky(int i);

        /* renamed from: lJ */
        void mo29593lJ(int i);

        /* renamed from: ls */
        void mo29594ls(int i);

        /* renamed from: nZ */
        void mo29595nZ(int i);
    }

    public TrimMaskView(Context context) {
        this(context, null);
    }

    public TrimMaskView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TrimMaskView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public TrimMaskView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i);
        this.cXK = null;
        this.cXL = null;
        this.cXM = null;
        this.cXN = null;
        this.cXO = null;
        this.cXP = 100;
        this.cXQ = 200;
        this.cXR = 1;
        this.cXS = false;
        this.cXT = 88.0f;
        this.cXU = 88.0f;
        this.cXV = 5.0f;
        this.cWV = 100;
        this.cWW = 1000;
        this.cXW = 100;
        this.cXX = 1000;
        this.mDragState = 0;
        this.cXY = -1;
        this.cXZ = 0;
        this.f3508CY = new Rect();
        this.mPaint = new Paint();
        this.cYa = true;
        this.cGk = false;
        this.cYb = false;
        this.cYc = false;
        this.mOffset = 0;
        this.cYd = false;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.trimmaskview, i, 0);
        this.cXK = (StateListDrawable) obtainStyledAttributes.getDrawable(R.styleable.trimmaskview_lefthandle);
        this.cXM = (StateListDrawable) obtainStyledAttributes.getDrawable(R.styleable.trimmaskview_righthandle);
        this.cXO = (NinePatchDrawable) obtainStyledAttributes.getDrawable(R.styleable.trimmaskview_curneedle);
        this.cXL = obtainStyledAttributes.getDrawable(R.styleable.trimmaskview_leftfakehandle);
        this.cXN = obtainStyledAttributes.getDrawable(R.styleable.trimmaskview_rightfakehandle);
        obtainStyledAttributes.recycle();
    }

    /* renamed from: F */
    private void m18590F(Canvas canvas) {
        if (this.cGk && this.cXO != null) {
            int intrinsicWidth = this.cXO.getIntrinsicWidth();
            int P = C4583d.m11671P(this.cXU);
            if (this.cYd) {
                P = this.cXM.getIntrinsicHeight();
            }
            this.f3508CY.left = (this.cXP + this.mOffset) - (intrinsicWidth / 2);
            this.f3508CY.right = this.f3508CY.left + intrinsicWidth;
            this.f3508CY.top = 0;
            if (!this.cYd) {
                this.f3508CY.top += C4583d.m11671P(this.cXV);
            }
            this.f3508CY.bottom = this.f3508CY.top + P;
            this.cXO.setBounds(this.f3508CY);
            canvas.save();
            this.cXO.draw(canvas);
            canvas.restore();
        }
    }

    /* renamed from: G */
    private void m18591G(Canvas canvas) {
        if (!isInEditMode() && this.cXM != null) {
            if (this.mDragState <= 0 || this.cYa) {
                this.cXM.setState(new int[0]);
            } else {
                this.cXM.setState(new int[]{16842919});
            }
            int intrinsicWidth = this.cXM.getIntrinsicWidth();
            int intrinsicHeight = this.cXM.getIntrinsicHeight();
            if (this.cXN != null && this.mDragState > 0 && !this.cYa && this.cXX <= this.cXQ) {
                int intrinsicWidth2 = this.cXN.getIntrinsicWidth();
                if (this.cYc) {
                    int i = intrinsicWidth2 / 2;
                    this.cXN.setBounds(this.cXX - i, 0, this.cXX + i, intrinsicHeight);
                } else {
                    this.cXN.setBounds(this.cXX, 0, this.cXX + intrinsicWidth2, intrinsicHeight);
                }
                canvas.save();
                this.cXN.draw(canvas);
                canvas.restore();
            }
            if (this.cYc) {
                int i2 = intrinsicWidth / 2;
                this.cXM.setBounds(this.cXQ - i2, 0, this.cXQ + i2, intrinsicHeight);
            } else {
                this.cXM.setBounds(this.cXQ, 0, this.cXQ + intrinsicWidth, intrinsicHeight);
            }
            canvas.save();
            this.cXM.draw(canvas);
            canvas.restore();
        }
    }

    /* renamed from: H */
    private int m18592H(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        return x < this.cXP ? this.cXP : x > this.cXQ ? this.cXQ : x;
    }

    /* renamed from: H */
    private void m18593H(Canvas canvas) {
        if (!isInEditMode() && this.cXK != null) {
            if (this.mDragState <= 0 || !this.cYa) {
                this.cXK.setState(new int[0]);
            } else {
                this.cXK.setState(new int[]{16842919});
            }
            int intrinsicWidth = this.cXK.getIntrinsicWidth();
            int intrinsicHeight = this.cXK.getIntrinsicHeight();
            if (this.cXL != null && this.mDragState > 0 && this.cYa && this.cXW >= this.cXP) {
                int intrinsicWidth2 = this.cXL.getIntrinsicWidth();
                if (this.cYc) {
                    int i = intrinsicWidth2 / 2;
                    this.cXL.setBounds(this.cXW - i, 0, this.cXW + i, intrinsicHeight);
                } else {
                    this.cXL.setBounds(this.cXW - intrinsicWidth2, 0, this.cXW, intrinsicHeight);
                }
                canvas.save();
                this.cXL.draw(canvas);
                canvas.restore();
            }
            if (this.cYc) {
                int i2 = intrinsicWidth / 2;
                this.cXK.setBounds(this.cXP - i2, 0, this.cXP + i2, intrinsicHeight);
            } else {
                this.cXK.setBounds(this.cXP - intrinsicWidth, 0, this.cXP, intrinsicHeight);
            }
            canvas.save();
            this.cXK.draw(canvas);
            canvas.restore();
        }
    }

    /* renamed from: I */
    private void m18594I(Canvas canvas) {
        if (!isInEditMode()) {
            int P = C4583d.m11671P(this.cXU);
            if (this.cYd) {
                P = this.cXK.getIntrinsicHeight();
            }
            this.f3508CY.left = this.cXQ;
            this.f3508CY.right = getWidth();
            this.f3508CY.top = 0;
            if (!this.cYd) {
                this.f3508CY.top += C4583d.m11671P(this.cXV);
            }
            this.f3508CY.bottom = this.f3508CY.top + P;
            canvas.save();
            canvas.drawRect(this.f3508CY, this.mPaint);
            canvas.restore();
        }
    }

    /* renamed from: I */
    private void m18595I(MotionEvent motionEvent) {
        int x = (int) (motionEvent.getX() - ((float) this.cXY));
        if (this.mDragState == 1) {
            this.cXP = this.cXZ + x;
            if (this.cXP < this.cWV) {
                this.cXP = this.cWV;
                this.cXS = false;
            } else if (this.cXP > this.cXQ - this.cXR) {
                this.cXP = this.cXQ - this.cXR;
                if (!this.cXS) {
                    if (this.cXf != null) {
                        this.cXf.aoa();
                    }
                    this.cXS = true;
                }
            } else {
                this.cXS = false;
            }
        } else if (this.mDragState == 2) {
            this.cXQ = this.cXZ + x;
            if (this.cXQ < this.cXP + this.cXR) {
                this.cXQ = this.cXP + this.cXR;
                if (!this.cXS) {
                    if (this.cXf != null) {
                        this.cXf.aoa();
                    }
                    this.cXS = true;
                }
            } else if (this.cXQ > this.cWW) {
                this.cXQ = this.cWW;
                this.cXS = false;
            } else {
                this.cXS = false;
            }
        }
    }

    /* renamed from: J */
    private int m18596J(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        if (((int) motionEvent.getY()) > C4583d.m11671P(this.cXT)) {
            int intrinsicWidth = this.cXK.getIntrinsicWidth();
            if (this.cXP > x) {
                if (this.cXP + intrinsicWidth + 10 > x && (this.cXP - intrinsicWidth) - 10 < x) {
                    return 1;
                }
                if ((this.cXQ - intrinsicWidth) - 10 < x && this.cXQ + intrinsicWidth + 10 > x) {
                    return 2;
                }
            } else if (this.cXQ < x) {
                if ((this.cXQ - intrinsicWidth) - 10 < x && this.cXQ + intrinsicWidth + 10 > x) {
                    return 2;
                }
                if (this.cXP + intrinsicWidth + 10 > x && (this.cXP - intrinsicWidth) - 10 < x) {
                    return 1;
                }
            } else if ((this.cXQ - intrinsicWidth) - 10 < x && this.cXQ + intrinsicWidth + 10 > x) {
                return 2;
            } else {
                if (this.cXP + intrinsicWidth + 10 > x && (this.cXP - intrinsicWidth) - 10 < x) {
                    return 1;
                }
            }
        }
        return 0;
    }

    /* renamed from: J */
    private void m18597J(Canvas canvas) {
        if (!isInEditMode()) {
            int P = C4583d.m11671P(this.cXU);
            if (this.cYd) {
                P = this.cXK.getIntrinsicHeight();
            }
            this.f3508CY.left = 0;
            this.f3508CY.right = this.cXP;
            this.f3508CY.top = 0;
            if (!this.cYd) {
                this.f3508CY.top += C4583d.m11671P(this.cXV);
            }
            this.f3508CY.bottom = this.f3508CY.top + P;
            canvas.save();
            canvas.drawRect(this.f3508CY, this.mPaint);
            canvas.restore();
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    public float getmGalleryContentHeight() {
        return this.cXT;
    }

    public float getmGalleryMaskHeight() {
        return this.cXU;
    }

    public int getmLeftPos() {
        return this.cXP;
    }

    public int getmMaxRightPos() {
        return this.cWW;
    }

    public int getmMaxRightPos4Fake() {
        return this.cXX;
    }

    public int getmMinDistance() {
        return this.cXR;
    }

    public int getmMinLeftPos() {
        return this.cWV;
    }

    public int getmMinLeftPos4Fake() {
        return this.cXW;
    }

    public int getmOffset() {
        return this.mOffset;
    }

    public C6446a getmOnOperationListener() {
        return this.cXf;
    }

    public int getmRightPos() {
        return this.cXQ;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.mPaint.setColor(-16777216);
        this.mPaint.setAlpha(178);
        if (!isInEditMode()) {
            m18597J(canvas);
            m18594I(canvas);
            m18593H(canvas);
            m18591G(canvas);
            m18590F(canvas);
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int i3 = 0;
        int resolveSize = resolveSize(0, i);
        if (!isInEditMode() && this.cXK != null) {
            i3 = this.cXK.getIntrinsicHeight();
        }
        setMeasuredDimension(resolveSize, resolveSize(i3, i2));
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.cYb) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.mDragState = m18596J(motionEvent);
                    if (this.mDragState > 0) {
                        this.cXY = (int) motionEvent.getX();
                        if (this.mDragState == 1) {
                            this.cXZ = this.cXP;
                            this.cYa = true;
                        } else {
                            this.cXZ = this.cXQ;
                            this.cYa = false;
                        }
                        if (this.cXf != null) {
                            C6446a aVar = this.cXf;
                            if (this.mDragState == 1) {
                                z = true;
                            }
                            aVar.mo29591eH(z);
                        }
                        return true;
                    } else if (this.cGk) {
                        int H = m18592H(motionEvent);
                        this.mOffset = H - this.cXP;
                        if (this.cXf != null) {
                            this.cXf.mo29593lJ(H);
                        }
                        return true;
                    }
                    break;
                case 1:
                case 3:
                    if (this.mDragState > 0) {
                        m18595I(motionEvent);
                        if (this.cXf != null) {
                            this.cXf.mo29592ky(this.mDragState == 1 ? this.cXP : this.cXQ);
                        }
                        this.mDragState = 0;
                        return true;
                    } else if (this.cGk) {
                        int H2 = m18592H(motionEvent);
                        this.mOffset = H2 - this.cXP;
                        if (this.cXf != null) {
                            this.cXf.mo29594ls(H2);
                        }
                        return true;
                    }
                    break;
                case 2:
                    if (this.mDragState > 0) {
                        m18595I(motionEvent);
                        if (this.cXf != null) {
                            this.cXf.mo29595nZ(this.mDragState == 1 ? this.cXP : this.cXQ);
                        }
                        invalidate();
                        return true;
                    } else if (this.cGk) {
                        int H3 = m18592H(motionEvent);
                        this.mOffset = H3 - this.cXP;
                        if (this.cXf != null) {
                            this.cXf.mo29595nZ(H3);
                        }
                        return true;
                    }
                    break;
            }
        } else {
            switch (motionEvent.getAction()) {
                case 0:
                    if (!this.cGk) {
                        this.mDragState = m18596J(motionEvent);
                        if (this.mDragState != 0) {
                            this.cXY = (int) motionEvent.getX();
                            if (this.mDragState == 1) {
                                this.cXZ = this.cXP;
                                this.cYa = true;
                            } else {
                                this.cXZ = this.cXQ;
                                this.cYa = false;
                            }
                            if (this.cXf != null) {
                                C6446a aVar2 = this.cXf;
                                if (this.mDragState == 1) {
                                    z = true;
                                }
                                aVar2.mo29591eH(z);
                            }
                            return true;
                        }
                    } else {
                        int H4 = m18592H(motionEvent);
                        this.mOffset = H4 - this.cXP;
                        if (this.cXf != null) {
                            this.cXf.mo29593lJ(H4);
                        }
                        return true;
                    }
                    break;
                case 1:
                case 3:
                    if (this.cGk) {
                        int H5 = m18592H(motionEvent);
                        this.mOffset = H5 - this.cXP;
                        if (this.cXf != null) {
                            this.cXf.mo29594ls(H5);
                        }
                        return true;
                    } else if (this.mDragState > 0) {
                        m18595I(motionEvent);
                        if (this.cXf != null) {
                            this.cXf.mo29592ky(this.mDragState == 1 ? this.cXP : this.cXQ);
                        }
                        invalidate();
                        this.mDragState = 0;
                        return true;
                    }
                    break;
                case 2:
                    if (this.cGk) {
                        int H6 = m18592H(motionEvent);
                        this.mOffset = H6 - this.cXP;
                        if (this.cXf != null) {
                            this.cXf.mo29595nZ(H6);
                        }
                        return true;
                    } else if (this.mDragState > 0) {
                        m18595I(motionEvent);
                        if (this.cXf != null) {
                            this.cXf.mo29595nZ(this.mDragState == 1 ? this.cXP : this.cXQ);
                        }
                        invalidate();
                        return true;
                    }
                    break;
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setPlaying(boolean z) {
        this.cGk = z;
        invalidate();
    }

    public void setbCanSeekWhenPlaying(boolean z) {
        this.cYb = z;
    }

    public void setbCenterAlign(boolean z) {
        this.cYc = z;
    }

    public void setbLeftbarFocused(boolean z) {
        this.cYa = z;
    }

    public void setbMaskFullScreenMode(boolean z) {
        this.cYd = z;
    }

    public void setmGalleryContentHeight(float f) {
        this.cXT = f;
    }

    public void setmGalleryMaskHeight(float f) {
        this.cXU = f;
    }

    public void setmLeftPos(int i) {
        this.cXP = i;
        if (this.cXP < this.cWV) {
            this.cXP = this.cWV;
        } else if (this.cXP + this.cXR > this.cXQ) {
            this.cXP = this.cXQ - this.cXR;
        }
        invalidate();
    }

    public void setmMaxRightPos(int i) {
        this.cWW = i;
    }

    public void setmMaxRightPos4Fake(int i) {
        this.cXX = i;
    }

    public void setmMinDistance(int i) {
        if (i > this.cXR && i < this.cWW - this.cWV) {
            this.cXR = i;
        } else if (i > this.cWW - this.cWV) {
            this.cXR = this.cWW - this.cWV;
        }
    }

    public void setmMinLeftPos(int i) {
        this.cWV = i;
    }

    public void setmMinLeftPos4Fake(int i) {
        this.cXW = i;
    }

    public void setmOffset(int i) {
        this.mOffset = i;
        StringBuilder sb = new StringBuilder();
        sb.append("mOffset =");
        sb.append(i);
        LogUtils.m14223i("View", sb.toString());
    }

    public void setmOnOperationListener(C6446a aVar) {
        this.cXf = aVar;
    }

    public void setmRightPos(int i) {
        if (i > this.cWW) {
            i = this.cWW;
        } else if (i - this.cXR < this.cXP) {
            i = this.cXP + this.cXR;
        }
        this.cXQ = i;
        invalidate();
    }
}
