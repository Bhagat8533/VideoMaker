package com.introvd.template.camera.p230c;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import com.introvd.template.camera.p229b.C5008i;
import com.introvd.template.common.LogUtils;
import com.introvd.template.sdk.p386e.C8411a;
import com.introvd.template.sdk.p386e.C8411a.C8415b;
import com.introvd.template.sdk.p386e.C8417b;
import com.introvd.template.sdk.utils.VeMSize;
import com.mediarecorder.engine.QPIPFrameParam;
import com.mediarecorder.engine.QPIPSource;

/* renamed from: com.introvd.template.camera.c.a */
public class C5023a extends C8411a {
    private boolean bPL = true;

    public C5023a(View view, boolean z) {
        super(view);
        this.bPL = z;
        this.cBr = true;
    }

    /* renamed from: p */
    private boolean m13168p(MotionEvent motionEvent) {
        QPIPFrameParam Wk = C5008i.m12937VU().mo25624Wk();
        boolean z = false;
        if (Wk == null) {
            return false;
        }
        int[] iArr = new int[2];
        this.cBo.getLocationOnScreen(iArr);
        int width = this.cBo.getWidth();
        int height = this.cBo.getHeight();
        Rect rect = new Rect();
        rect.left = iArr[0];
        rect.top = iArr[1];
        rect.right = rect.left + width;
        rect.bottom = rect.top + height;
        if (rect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
            int elementIndexByPoint = Wk.getElementIndexByPoint(((((int) motionEvent.getX()) - rect.left) * 10000) / width, ((((int) motionEvent.getY()) - rect.top) * 10000) / height);
            QPIPSource elementSource = Wk.getElementSource(elementIndexByPoint);
            if (elementSource == null || elementSource.getType() != 3) {
                this.efb = -1;
            } else {
                this.efb = elementIndexByPoint;
                z = true;
            }
        }
        return z;
    }

    /* access modifiers changed from: protected */
    /* renamed from: WM */
    public boolean mo25869WM() {
        return false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: WN */
    public void mo25870WN() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: o */
    public boolean mo25871o(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        StringBuilder sb = new StringBuilder();
        sb.append("MyOnGestureListener onTouch action=");
        sb.append(action);
        LogUtils.m14223i("CamPipVideoRegionController", sb.toString());
        switch (action & 255) {
            case 0:
                if (m13168p(motionEvent)) {
                    this.cBr = true;
                    break;
                } else {
                    return false;
                }
            case 1:
            case 3:
                this.efb = -1;
                this.cBr = false;
                if (this.bUr != null) {
                    this.bUr.anK();
                    break;
                }
                break;
            case 2:
                boolean z = this.cBr;
                break;
            case 5:
                if (this.bUr != null && !this.cBr) {
                    mo34108a(motionEvent, this.efa);
                    if (this.efb >= 0) {
                        this.cBq = true;
                        break;
                    }
                }
                break;
            case 6:
                if (this.cBq) {
                    this.cBq = false;
                    break;
                }
                break;
        }
        this.aML.onTouchEvent(motionEvent);
        this.cBp.onTouchEvent(motionEvent);
        return true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: q */
    public boolean mo25872q(float f, float f2) {
        StringBuilder sb = new StringBuilder();
        sb.append("MyOnGestureListener onScroll distanceX=");
        sb.append(f);
        sb.append(";distanceY=");
        sb.append(f2);
        LogUtils.m14223i("CamPipVideoRegionController", sb.toString());
        if (aIH() && this.efb >= 0 && this.eeZ != null && !this.cBq) {
            Rect aIJ = ((C8417b) this.eeZ.get(this.efb)).aIJ();
            VeMSize aIK = ((C8417b) this.eeZ.get(this.efb)).aIK();
            int a = m24277a(f, false, aIK, aIJ);
            int a2 = m24277a(f2, true, aIK, aIJ);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("MyOnGestureListener onScroll distanceX=");
            sb2.append(f);
            sb2.append(";distanceY=");
            sb2.append(f2);
            sb2.append(";videoRegion:");
            sb2.append(aIJ);
            LogUtils.m14223i("CamPipVideoRegionController", sb2.toString());
            boolean a3 = this.bPL ? m24279a(aIJ, a, a2) : m24279a(aIJ, a2, a);
            StringBuilder sb3 = new StringBuilder();
            sb3.append("MyOnGestureListener onScroll2 deltaXValue=");
            sb3.append(a);
            sb3.append(";deltaYValue=");
            sb3.append(a2);
            sb3.append(";videoRegion:");
            sb3.append(aIJ);
            LogUtils.m14223i("CamPipVideoRegionController", sb3.toString());
            if (a3 && this.bUr != null) {
                this.bUr.mo25989a(this.efb, aIJ);
            }
        }
        return true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: r */
    public boolean mo25873r(MotionEvent motionEvent) {
        LogUtils.m14223i("CamPipVideoRegionController", "MyOnGestureListener onDown");
        C8415b bVar = this.bUr;
        return true;
    }
}
