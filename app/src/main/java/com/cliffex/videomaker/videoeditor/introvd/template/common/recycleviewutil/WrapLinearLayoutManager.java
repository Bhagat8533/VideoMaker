package com.introvd.template.common.recycleviewutil;

import android.content.Context;
import android.support.p024v7.widget.LinearLayoutManager;
import android.support.p024v7.widget.RecyclerView.C1025n;
import android.support.p024v7.widget.RecyclerView.C1031r;
import android.util.AttributeSet;

public class WrapLinearLayoutManager extends LinearLayoutManager {
    private LayoutManagerListener cfz;

    public interface LayoutManagerListener {
        void onLayoutError(IndexOutOfBoundsException indexOutOfBoundsException);
    }

    public WrapLinearLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    public void onLayoutChildren(C1025n nVar, C1031r rVar) {
        try {
            super.onLayoutChildren(nVar, rVar);
        } catch (IndexOutOfBoundsException e) {
            if (this.cfz != null) {
                this.cfz.onLayoutError(e);
            }
        }
    }
}
