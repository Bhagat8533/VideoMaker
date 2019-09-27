package com.introvd.template.editor.videotrim.p292ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.introvd.template.common.LogUtils;
import com.introvd.template.editor.R;
import com.introvd.template.p203b.C4583d;

/* renamed from: com.introvd.template.editor.videotrim.ui.TrimMaskView4Import */
public class TrimMaskView4Import extends View {
    private static int dnt = 8;
    private static int dnu = 32;

    /* renamed from: CY */
    private Rect f3519CY;
    private volatile boolean cGk;
    private int cWV;
    private int cWW;
    private StateListDrawable cXK;
    private StateListDrawable cXM;
    private int cXP;
    private int cXQ;
    private int cXR;
    private boolean cXS;
    private float cXT;
    private int cXY;
    private int cXZ;
    private volatile boolean cYa;
    private volatile boolean cYb;
    private volatile boolean cYc;
    private volatile boolean cYd;
    private int dnA;
    private volatile boolean dnB;
    private volatile boolean dnC;
    private volatile boolean dnD;
    private boolean dnE;
    private Paint dnF;
    private String dnG;
    private String dnH;
    private C6983a dng;
    private Drawable dnv;
    private Drawable dnw;
    private Drawable dnx;
    private boolean dny;
    private int dnz;
    private int mDragState;
    private volatile int mOffset;
    private Paint mPaint;

    /* renamed from: com.introvd.template.editor.videotrim.ui.TrimMaskView4Import$a */
    public interface C6983a {
        void aoa();

        /* renamed from: eH */
        void mo30707eH(boolean z);

        /* renamed from: ky */
        void mo30708ky(int i);

        /* renamed from: lJ */
        void mo30709lJ(int i);

        /* renamed from: ls */
        void mo30710ls(int i);

        /* renamed from: nZ */
        void mo30711nZ(int i);
    }

    public TrimMaskView4Import(Context context) {
        this(context, null);
    }

    public TrimMaskView4Import(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TrimMaskView4Import(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public TrimMaskView4Import(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i);
        this.cXK = null;
        this.cXM = null;
        this.dnv = null;
        this.dnw = null;
        this.dnx = null;
        this.cXP = 100;
        this.cXQ = 200;
        this.cXR = 1;
        this.cXS = false;
        this.dny = false;
        this.cXT = 0.0f;
        this.dnz = 0;
        this.cWV = 100;
        this.cWW = 1000;
        this.mDragState = 0;
        this.cXY = -1;
        this.cXZ = 0;
        this.dnA = 0;
        this.f3519CY = new Rect();
        this.mPaint = new Paint();
        this.cYa = true;
        this.cGk = false;
        this.cYb = false;
        this.dnB = false;
        this.cYc = false;
        this.dnC = false;
        this.dnD = false;
        this.dnE = false;
        this.mOffset = 0;
        this.cYd = false;
        this.dnG = "";
        this.dnH = "";
        if (!isInEditMode()) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.trimmaskview, i, 0);
            this.cXK = (StateListDrawable) obtainStyledAttributes.getDrawable(R.styleable.trimmaskview_lefthandle);
            this.cXM = (StateListDrawable) obtainStyledAttributes.getDrawable(R.styleable.trimmaskview_righthandle);
            this.dnx = obtainStyledAttributes.getDrawable(R.styleable.trimmaskview_curneedle);
            this.dnv = obtainStyledAttributes.getDrawable(R.styleable.trimmaskview_indicatorhandle);
            obtainStyledAttributes.recycle();
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(R.style.Theme_Common, new int[]{R.attr.trimcntDrawable, R.attr.trimcntdisDrawable});
            this.dnw = obtainStyledAttributes2.getDrawable(0);
            obtainStyledAttributes2.recycle();
            this.dnF = new Paint();
            this.dnF.setAntiAlias(true);
            this.dnF.setTextSize((float) C4583d.dpFloatToPixel(getContext(), (float) dnt));
        }
    }

    /* renamed from: F */
    private void m20420F(Canvas canvas) {
        if (this.cGk && this.dnx != null) {
            int intrinsicWidth = this.dnx.getIntrinsicWidth();
            int intrinsicHeight = this.dnx.getIntrinsicHeight();
            this.f3519CY.left = (this.cXP + this.mOffset) - (intrinsicWidth / 2);
            this.f3519CY.right = this.f3519CY.left + intrinsicWidth;
            this.f3519CY.top = (getHeight() - intrinsicHeight) / 2;
            this.f3519CY.bottom = this.f3519CY.top + intrinsicHeight;
            this.dnx.setBounds(this.f3519CY);
            canvas.save();
            this.dnx.draw(canvas);
            canvas.restore();
        }
    }

    /* renamed from: G */
    private void m20421G(Canvas canvas) {
        Drawable drawable;
        if (this.cXM != null) {
            if (!this.cYa) {
                this.cXM.setState(new int[]{16842908});
            } else {
                this.cXM.setState(new int[0]);
            }
            int intrinsicWidth = this.cXM.getIntrinsicWidth();
            int intrinsicHeight = this.cXM.getIntrinsicHeight();
            if (this.dnD) {
                intrinsicHeight = this.dnA <= 0 ? this.cXM.getIntrinsicHeight() : this.dnA;
            }
            int measuredHeight = (getMeasuredHeight() - intrinsicHeight) / 2;
            int i = measuredHeight + intrinsicHeight;
            if (intrinsicHeight > getMeasuredHeight()) {
                i = getMeasuredHeight();
                measuredHeight = 0;
            }
            int i2 = this.cXQ - (intrinsicWidth / 8);
            int i3 = this.cXQ + ((intrinsicWidth * 7) / 8);
            if (!atV()) {
                i2 = this.cXQ;
                i3 = this.cXQ + intrinsicWidth;
            }
            m20430a(canvas, this.cXM, new Rect(i2, measuredHeight, i3, i));
            if (this.cYa || !this.dnE) {
                drawable = getResources().getDrawable(R.color.transparent);
                this.dnF.setColor(getResources().getColor(R.color.transparent));
            } else {
                drawable = this.dnv;
                this.dnF.setColor(getResources().getColor(R.color.white));
            }
            if (drawable != null) {
                int intrinsicWidth2 = drawable.getIntrinsicWidth();
                m20431iQ(this.dnH);
                canvas.save();
                int i4 = i2 - (intrinsicWidth2 / 4);
                drawable.setBounds(i4, 0, i2 + ((intrinsicWidth2 * 3) / 4), drawable.getIntrinsicHeight());
                drawable.draw(canvas);
                canvas.restore();
                canvas.save();
                canvas.drawText(this.dnH, ((float) i4) + ((((float) intrinsicWidth2) - this.dnF.measureText(this.dnH)) / 2.0f), (float) (((drawable.getIntrinsicHeight() * 10) / 13) - (C4583d.dpFloatToPixel(getContext(), (float) dnt) / 2)), this.dnF);
                canvas.restore();
            }
        }
    }

    /* renamed from: H */
    private int m20422H(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        return x < this.cXP ? this.cXP : x > this.cXQ ? this.cXQ : x;
    }

    /* renamed from: H */
    private void m20423H(Canvas canvas) {
        Drawable drawable;
        if (this.cXK != null) {
            if (this.cYa) {
                this.cXK.setState(new int[]{16842908});
            } else {
                this.cXK.setState(new int[0]);
            }
            int intrinsicWidth = this.cXK.getIntrinsicWidth();
            int intrinsicHeight = this.cXK.getIntrinsicHeight();
            if (this.dnD) {
                intrinsicHeight = this.dnA <= 0 ? this.cXK.getIntrinsicHeight() : this.dnA;
            }
            int measuredHeight = (getMeasuredHeight() - intrinsicHeight) / 2;
            int i = measuredHeight + intrinsicHeight;
            if (intrinsicHeight > getMeasuredHeight()) {
                i = getMeasuredHeight();
                measuredHeight = 0;
            }
            int i2 = this.cXP - ((intrinsicWidth * 7) / 8);
            int i3 = this.cXP + (intrinsicWidth / 8);
            if (!atV()) {
                i2 = this.cXP - intrinsicWidth;
                i3 = this.cXP;
            }
            m20430a(canvas, this.cXK, new Rect(i2, measuredHeight, i3, i));
            if (!this.cYa || !this.dnE) {
                this.dnF.setColor(getResources().getColor(R.color.transparent));
                drawable = getResources().getDrawable(R.color.transparent);
            } else {
                drawable = this.dnv;
                this.dnF.setColor(getResources().getColor(R.color.white));
            }
            if (drawable != null) {
                int intrinsicWidth2 = drawable.getIntrinsicWidth();
                m20431iQ(this.dnG);
                canvas.save();
                int i4 = i2 - (intrinsicWidth2 / 4);
                drawable.setBounds(i4, 0, i2 + ((intrinsicWidth2 * 3) / 4), drawable.getIntrinsicHeight());
                drawable.draw(canvas);
                canvas.restore();
                canvas.save();
                canvas.drawText(this.dnG, ((float) i4) + ((((float) intrinsicWidth2) - this.dnF.measureText(this.dnG)) / 2.0f), (float) (((drawable.getIntrinsicHeight() * 10) / 13) - (C4583d.dpFloatToPixel(getContext(), (float) dnt) / 2)), this.dnF);
                canvas.restore();
            }
        }
    }

    /* renamed from: I */
    private void m20424I(Canvas canvas) {
        int height = getHeight();
        int intrinsicHeight = this.dnz > 0 ? this.dnz : this.dnw.getIntrinsicHeight();
        this.f3519CY.left = this.cXQ + (this.cXM.getIntrinsicWidth() / 4);
        this.f3519CY.right = getWidth();
        if (this.dny) {
            this.f3519CY.top = 0;
            this.f3519CY.bottom = height;
        } else {
            this.f3519CY.top = (height - intrinsicHeight) / 2;
            this.f3519CY.bottom = this.f3519CY.top + intrinsicHeight;
        }
        canvas.save();
        canvas.drawRect(this.f3519CY, this.mPaint);
        canvas.restore();
    }

    /* renamed from: I */
    private void m20425I(MotionEvent motionEvent) {
        int x = (int) (motionEvent.getX() - ((float) this.cXY));
        if (this.mDragState == 1) {
            this.cXP = this.cXZ + x;
            if (this.cXP < this.cWV) {
                this.cXP = this.cWV;
                this.cXS = false;
            } else if (this.cXP > this.cXQ - this.cXR) {
                this.cXP = this.cXQ - this.cXR;
                if (!this.cXS) {
                    if (this.dng != null) {
                        this.dng.aoa();
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
                    if (this.dng != null) {
                        this.dng.aoa();
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
    private int m20426J(MotionEvent motionEvent) {
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
    private void m20427J(Canvas canvas) {
        int height = getHeight();
        if (this.dnw != null) {
            int intrinsicHeight = this.dnz > 0 ? this.dnz : this.dnw.getIntrinsicHeight();
            this.f3519CY.left = 0;
            this.f3519CY.right = this.cXP - (this.cXK.getIntrinsicWidth() / 4);
            if (this.dny) {
                this.f3519CY.top = 0;
                this.f3519CY.bottom = height;
            } else {
                this.f3519CY.top = (height - intrinsicHeight) / 2;
                this.f3519CY.bottom = this.f3519CY.top + intrinsicHeight;
            }
            canvas.save();
            canvas.drawRect(this.f3519CY, this.mPaint);
            canvas.restore();
        }
    }

    /* renamed from: K */
    private boolean m20428K(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        motionEvent.getY();
        return this.cXP <= x && this.cXQ >= x;
    }

    /* renamed from: O */
    private void m20429O(Canvas canvas) {
        if (!isInEditMode()) {
            int intrinsicHeight = this.dnA <= 0 ? this.dnw.getIntrinsicHeight() : this.dnA;
            this.f3519CY.left = this.cXP;
            this.f3519CY.right = this.cXQ;
            this.f3519CY.top = (getHeight() - intrinsicHeight) / 2;
            this.f3519CY.bottom = this.f3519CY.top + intrinsicHeight;
            canvas.save();
            this.dnw.setBounds(this.f3519CY);
            this.dnw.draw(canvas);
            canvas.restore();
        }
    }

    /* renamed from: a */
    private void m20430a(Canvas canvas, Drawable drawable, Rect rect) {
        drawable.setBounds(rect);
        canvas.save();
        drawable.draw(canvas);
        canvas.restore();
    }

    /* renamed from: iQ */
    private void m20431iQ(String str) {
        if (this.mPaint != null) {
            if (((int) this.mPaint.measureText(str)) > C4583d.m11670O(getContext(), dnu)) {
                dnt = 8;
            } else {
                dnt = 10;
            }
            this.mPaint.setTextSize((float) C4583d.m11670O(getContext(), dnt));
        }
    }

    public boolean atT() {
        return this.cYa;
    }

    public boolean atU() {
        return this.cXP == this.cXQ - this.cXR;
    }

    public boolean atV() {
        return this.cYc;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    public float getmGalleryContentHeight() {
        return this.cXT;
    }

    public int getmGalleryItemHeight() {
        return this.dnz;
    }

    public int getmLeftPos() {
        return this.cXP;
    }

    public int getmMaxRightPos() {
        return this.cWW;
    }

    public int getmMinDistance() {
        return this.cXR;
    }

    public int getmMinLeftPos() {
        return this.cWV;
    }

    public int getmOffset() {
        return this.mOffset;
    }

    public C6983a getmOnOperationListener() {
        return this.dng;
    }

    public int getmRightPos() {
        return this.cXQ;
    }

    public boolean isPlaying() {
        return this.cGk;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.mPaint.setColor(-16777216);
        this.mPaint.setAlpha(178);
        if (isInEditMode()) {
            return;
        }
        if (this.cGk) {
            m20427J(canvas);
            m20424I(canvas);
            m20420F(canvas);
            return;
        }
        m20427J(canvas);
        m20424I(canvas);
        if (this.dnC) {
            m20429O(canvas);
        }
        m20423H(canvas);
        m20421G(canvas);
        m20420F(canvas);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        setMeasuredDimension(resolveSize(0, i), resolveSize(0, i2));
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.cYb) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.mDragState = m20426J(motionEvent);
                    if (this.mDragState > 0) {
                        this.cXY = (int) motionEvent.getX();
                        if (this.mDragState == 1) {
                            this.cXZ = this.cXP;
                            this.cYa = true;
                        } else {
                            this.cXZ = this.cXQ;
                            this.cYa = false;
                        }
                        if (this.dng != null) {
                            C6983a aVar = this.dng;
                            if (this.mDragState == 1) {
                                z = true;
                            }
                            aVar.mo30707eH(z);
                        }
                        return true;
                    } else if (this.cGk) {
                        int H = m20422H(motionEvent);
                        this.mOffset = H - this.cXP;
                        if (this.dng != null) {
                            this.dng.mo30709lJ(H);
                        }
                        return true;
                    }
                    break;
                case 1:
                case 3:
                    if (this.mDragState > 0) {
                        m20425I(motionEvent);
                        if (this.dng != null) {
                            this.dng.mo30708ky(this.mDragState == 1 ? this.cXP : this.cXQ);
                        }
                        this.mDragState = 0;
                        return true;
                    } else if (this.cGk) {
                        int H2 = m20422H(motionEvent);
                        this.mOffset = H2 - this.cXP;
                        if (this.dng != null) {
                            this.dng.mo30710ls(H2);
                        }
                        return true;
                    }
                    break;
                case 2:
                    if (this.mDragState > 0) {
                        m20425I(motionEvent);
                        if (this.dng != null) {
                            this.dng.mo30711nZ(this.mDragState == 1 ? this.cXP : this.cXQ);
                        }
                        postInvalidate();
                        return true;
                    } else if (this.cGk) {
                        int H3 = m20422H(motionEvent);
                        this.mOffset = H3 - this.cXP;
                        if (this.dng != null) {
                            this.dng.mo30711nZ(H3);
                        }
                        return true;
                    }
                    break;
            }
        } else {
            switch (motionEvent.getAction()) {
                case 0:
                    if (!this.cGk) {
                        this.mDragState = m20426J(motionEvent);
                        if (this.mDragState != 0) {
                            this.dnE = true;
                            this.cXY = (int) motionEvent.getX();
                            if (this.mDragState == 1) {
                                this.cXZ = this.cXP;
                                this.cYa = true;
                            } else {
                                this.cXZ = this.cXQ;
                                this.cYa = false;
                            }
                            if (this.dng != null) {
                                if (this.mDragState == 1) {
                                    z = true;
                                }
                                postInvalidate();
                                this.dng.mo30707eH(z);
                            }
                            return true;
                        }
                    } else {
                        if (m20428K(motionEvent)) {
                            this.dnB = true;
                            int H4 = m20422H(motionEvent);
                            this.mOffset = H4 - this.cXP;
                            if (this.dng != null) {
                                this.dng.mo30709lJ(H4);
                            }
                        } else {
                            this.dnB = false;
                        }
                        return true;
                    }
                    break;
                case 1:
                case 3:
                    if (!this.cGk) {
                        this.dnE = false;
                        if (this.mDragState > 0) {
                            m20425I(motionEvent);
                            if (this.dng != null) {
                                this.dng.mo30708ky(this.mDragState == 1 ? this.cXP : this.cXQ);
                            }
                            this.mDragState = 0;
                            return true;
                        }
                    } else {
                        if (this.dnB) {
                            int H5 = m20422H(motionEvent);
                            this.mOffset = H5 - this.cXP;
                            if (this.dng != null) {
                                this.dng.mo30710ls(H5);
                            }
                        }
                        this.dnB = false;
                        return true;
                    }
                    break;
                case 2:
                    if (this.cGk) {
                        if (this.dnB) {
                            int H6 = m20422H(motionEvent);
                            this.mOffset = H6 - this.cXP;
                            if (this.dng != null) {
                                this.dng.mo30711nZ(H6);
                            }
                            postInvalidate();
                        }
                        return true;
                    } else if (this.mDragState > 0) {
                        m20425I(motionEvent);
                        if (this.dng != null) {
                            this.dng.mo30711nZ(this.mDragState == 1 ? this.cXP : this.cXQ);
                        }
                        postInvalidate();
                        return true;
                    }
                    break;
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setLeftMessage(String str) {
        this.dnG = str;
    }

    public void setPlaying(boolean z) {
        if (this.cGk ^ z) {
            this.cGk = z;
            this.mOffset = 0;
            invalidate();
        }
    }

    public void setRightMessage(String str) {
        this.dnH = str;
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

    public void setmChildHeight(int i) {
        this.dnA = i;
    }

    public void setmGalleryItemHeight(int i) {
        this.dnz = i;
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

    public void setmMinDistance(int i) {
        if (i > this.cXR && i <= this.cWW - this.cWV) {
            this.cXR = i;
        } else if (i > this.cWW - this.cWV) {
            this.cXR = this.cWW - this.cWV;
        }
    }

    public void setmMinLeftPos(int i) {
        this.cWV = i;
    }

    public void setmOffset(int i) {
        this.mOffset = i;
        StringBuilder sb = new StringBuilder();
        sb.append("mOffset =");
        sb.append(i);
        LogUtils.m14223i("View", sb.toString());
    }

    public void setmOnOperationListener(C6983a aVar) {
        this.dng = aVar;
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
