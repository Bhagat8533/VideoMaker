package com.introvd.template.picker.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.introvd.template.picker.p366b.C8188a;

public class CoordinatorRelativeLayout extends RelativeLayout {
    private int dZD;
    private boolean dZE;
    private float dZF;
    private C8188a dZG;
    private C8247a dZH;

    /* renamed from: com.introvd.template.picker.view.CoordinatorRelativeLayout$a */
    public interface C8247a {
        boolean aFY();
    }

    public CoordinatorRelativeLayout(Context context) {
        super(context);
    }

    public CoordinatorRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CoordinatorRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* renamed from: T */
    private boolean m23808T(MotionEvent motionEvent) {
        if (this.dZH == null || !this.dZH.aFY()) {
            return false;
        }
        if (!this.dZE) {
            this.dZD = (int) (this.dZF - motionEvent.getRawY());
            this.dZE = true;
        }
        return true;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.dZG == null) {
            return super.onTouchEvent(motionEvent);
        }
        int rawY = (int) motionEvent.getRawY();
        int rawX = (int) motionEvent.getRawX();
        switch (motionEvent.getAction()) {
            case 0:
                this.dZF = motionEvent.getRawY();
                break;
            case 1:
            case 3:
                this.dZE = false;
                if (this.dZG.aFA()) {
                    this.dZG.aFB();
                    return true;
                }
                break;
            case 2:
                int i = (int) (this.dZF - ((float) rawY));
                if (m23808T(motionEvent) ? this.dZG.mo33302a(rawX, rawY, 0, i + Math.abs(this.dZD), true) : this.dZG.mo33302a(rawX, rawY, 0, i, m23808T(motionEvent))) {
                    return true;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setCoordinatorCallback(C8247a aVar) {
        this.dZH = aVar;
    }

    public void setCoordinatorListener(C8188a aVar) {
        this.dZG = aVar;
    }
}
