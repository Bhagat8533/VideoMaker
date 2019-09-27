package com.introvd.template.gallery.view;

import android.content.Context;
import android.support.p024v7.widget.GridLayoutManager;
import android.support.p024v7.widget.RecyclerView.C1025n;
import android.support.p024v7.widget.RecyclerView.C1031r;
import android.support.p024v7.widget.RecyclerView.LayoutManager.C1006a;
import android.util.AttributeSet;

public class WrapGridLayoutManager extends GridLayoutManager {
    public WrapGridLayoutManager(Context context, int i) {
        super(context, i);
    }

    public WrapGridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    public void collectAdjacentPrefetchPositions(int i, int i2, C1031r rVar, C1006a aVar) {
        try {
            super.collectAdjacentPrefetchPositions(i, i2, rVar, aVar);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    public void onLayoutChildren(C1025n nVar, C1031r rVar) {
        try {
            super.onLayoutChildren(nVar, rVar);
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }
}
