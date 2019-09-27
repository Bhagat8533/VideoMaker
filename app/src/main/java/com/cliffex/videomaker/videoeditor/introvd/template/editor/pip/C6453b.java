package com.introvd.template.editor.pip;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import com.introvd.template.common.LogUtils;
import com.introvd.template.editor.R;
import com.introvd.template.editor.pip.C6454c.C6458a;
import com.introvd.template.sdk.p386e.C8411a;
import com.introvd.template.sdk.p386e.C8417b;
import com.introvd.template.sdk.utils.VeMSize;

/* renamed from: com.introvd.template.editor.pip.b */
public class C6453b extends C8411a {
    private C6458a cWJ;
    private int cXk = -1;
    private HighLightView cXl;

    public C6453b(View view) {
        super(view);
        this.cXl = (HighLightView) view.findViewById(R.id.xiaoying_pip_highlightview_videoarea);
    }

    /* renamed from: C */
    private void m18648C(View view, int i) {
        C6454c cVar = new C6454c(this.mContext, this.bUr != null ? this.bUr.mo29542nR(i) : false);
        cVar.mo29626oc(i);
        cVar.mo29622a(this.cWJ);
        VeMSize aIK = ((C8417b) this.eeZ.get(i)).aIK();
        Rect aII = ((C8417b) this.eeZ.get(i)).aII();
        int top = this.cBo.getTop();
        Rect rect = new Rect();
        rect.left = (aII.left * aIK.width) / aII.width();
        rect.right = rect.left + aIK.width;
        rect.top = top + ((aII.top * aIK.height) / aII.height());
        rect.bottom = rect.top + aIK.height;
        cVar.mo29625n(rect);
    }

    /* renamed from: T */
    private void m18649T(int i, boolean z) {
        if (this.cXl != null) {
            this.cXl.mo29555a(m18650oa(i), z);
            this.cXl.setVisibility(0);
            this.cXl.invalidate();
        }
    }

    /* renamed from: oa */
    private Rect m18650oa(int i) {
        if (i >= 0 && this.eeZ.size() > 0) {
            Rect aII = ((C8417b) this.eeZ.get(i)).aII();
            if (aII != null) {
                Rect rect = new Rect();
                rect.left = (aII.left * this.efa.width) / 10000;
                rect.top = (aII.top * this.efa.height) / 10000;
                rect.right = (aII.right * this.efa.width) / 10000;
                rect.bottom = (aII.bottom * this.efa.height) / 10000;
                return rect;
            }
        }
        return null;
    }

    /* renamed from: ob */
    private boolean m18651ob(int i) {
        int size = this.eeZ.size();
        if (i >= 0 && i < size) {
            C8417b bVar = (C8417b) this.eeZ.get(i);
            if (bVar != null) {
                return bVar.aIN();
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: WM */
    public boolean mo25869WM() {
        if (this.efb < 0) {
            return false;
        }
        if (m18651ob(this.efb)) {
            m18648C(null, this.efb);
        } else if (this.cWJ != null) {
            this.cWJ.mo29546nT(this.efb);
        }
        return true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: WN */
    public void mo25870WN() {
        LogUtils.m14223i("PIPVideoRegionController", "MyOnGestureListener onLongPress");
        if (this.efb >= 0 && aIH()) {
            this.cBr = true;
            if (this.bUr != null) {
                this.bUr.mo29539d(null);
            }
        }
    }

    /* renamed from: a */
    public void mo29620a(C6458a aVar) {
        this.cWJ = aVar;
    }

    public void aob() {
        this.eeZ = null;
        this.cBo = null;
        this.cXl = null;
        this.aML = null;
        this.cBp = null;
        this.mContext = null;
        this.bUr = null;
        this.cWJ = null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: o */
    public boolean mo25871o(MotionEvent motionEvent) {
        if (this.aML != null) {
            this.aML.onTouchEvent(motionEvent);
        }
        if (this.cBp != null) {
            this.cBp.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        StringBuilder sb = new StringBuilder();
        sb.append("MyOnGestureListener onTouch action=");
        sb.append(action);
        LogUtils.m14223i("PIPVideoRegionController", sb.toString());
        boolean z = true;
        switch (action & 255) {
            case 1:
            case 3:
                if (this.cBr && this.cXk >= 0 && this.cXk != this.efb && this.bUr != null) {
                    this.bUr.mo29538cF(this.efb, this.cXk);
                }
                this.efb = -1;
                this.cXk = -1;
                this.cBr = false;
                if (this.bUr != null) {
                    this.bUr.anK();
                    this.cXl.setVisibility(8);
                    break;
                }
                break;
            case 2:
                if (this.cBr && this.bUr != null) {
                    this.cXk = this.bUr.mo29540e(mo34108a(motionEvent, this.efa));
                    if (this.cXk < 0) {
                        m18649T(this.efb, false);
                        break;
                    } else {
                        int i = this.cXk;
                        if (this.cXk == this.efb) {
                            z = false;
                        }
                        m18649T(i, z);
                        break;
                    }
                }
            case 5:
                if (this.bUr != null && !this.cBr) {
                    int f = this.bUr.mo29541f(mo34108a(motionEvent, this.efa));
                    if (this.efb >= 0 && this.efb == f) {
                        this.cBq = true;
                        break;
                    }
                }
            case 6:
                if (this.cBq) {
                    this.cBq = false;
                    break;
                }
                break;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: q */
    public boolean mo25872q(float f, float f2) {
        StringBuilder sb = new StringBuilder();
        sb.append("MyOnGestureListener onScroll distanceX=");
        sb.append(f);
        sb.append(";distanceY=");
        sb.append(f2);
        LogUtils.m14223i("PIPVideoRegionController", sb.toString());
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
            LogUtils.m14223i("PIPVideoRegionController", sb2.toString());
            boolean a3 = m24279a(aIJ, a, a2);
            StringBuilder sb3 = new StringBuilder();
            sb3.append("MyOnGestureListener onScroll2 deltaXValue=");
            sb3.append(a);
            sb3.append(";deltaYValue=");
            sb3.append(a2);
            sb3.append(";videoRegion:");
            sb3.append(aIJ);
            LogUtils.m14223i("PIPVideoRegionController", sb3.toString());
            if (a3 && this.bUr != null) {
                this.bUr.mo25989a(this.efb, aIJ);
            }
        }
        return true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: r */
    public boolean mo25873r(MotionEvent motionEvent) {
        LogUtils.m14223i("PIPVideoRegionController", "MyOnGestureListener onDown");
        if (this.bUr != null) {
            this.efb = this.bUr.mo29541f(mo34108a(motionEvent, this.efa));
            if (!aIG() || this.efb < 0) {
                this.cXl.setVisibility(8);
            } else {
                m18649T(this.efb, false);
            }
        }
        return true;
    }
}
