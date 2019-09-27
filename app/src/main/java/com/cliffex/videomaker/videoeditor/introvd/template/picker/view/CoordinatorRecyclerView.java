package com.introvd.template.picker.view;

import android.content.Context;
import android.support.p024v7.widget.GridLayoutManager;
import android.support.p024v7.widget.RecyclerView;
import android.support.p024v7.widget.RecyclerView.LayoutManager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.introvd.template.picker.p366b.C8188a;

public class CoordinatorRecyclerView extends RecyclerView {
    private int dZD;
    private boolean dZE;
    private float dZF;
    private C8188a dZG;

    public CoordinatorRecyclerView(Context context) {
        super(context);
    }

    public CoordinatorRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CoordinatorRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* renamed from: T */
    private boolean m23807T(MotionEvent motionEvent) {
        LayoutManager layoutManager = getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
            boolean z = gridLayoutManager.findFirstVisibleItemPosition() == 0 && gridLayoutManager.findViewByPosition(0).getTop() == gridLayoutManager.getTopDecorationHeight(gridLayoutManager.findViewByPosition(0));
            int childCount = gridLayoutManager.getChildCount();
            if (z || childCount == 0) {
                if (!this.dZE) {
                    this.dZD = (int) (this.dZF - motionEvent.getRawY());
                    this.dZE = true;
                }
                return true;
            }
        }
        return false;
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
                if (m23807T(motionEvent) ? this.dZG.mo33302a(rawX, rawY, 0, i + Math.abs(this.dZD), true) : this.dZG.mo33302a(rawX, rawY, 0, i, m23807T(motionEvent))) {
                    return true;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setCoordinatorListener(C8188a aVar) {
        this.dZG = aVar;
    }
}
