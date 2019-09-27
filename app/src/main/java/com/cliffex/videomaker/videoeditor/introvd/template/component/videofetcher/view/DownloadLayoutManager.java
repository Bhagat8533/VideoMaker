package com.introvd.template.component.videofetcher.view;

import android.content.Context;
import android.support.p024v7.widget.LinearLayoutManager;
import android.support.p024v7.widget.RecyclerView.C1025n;
import android.support.p024v7.widget.RecyclerView.C1031r;
import android.util.AttributeSet;

public class DownloadLayoutManager extends LinearLayoutManager {
    public DownloadLayoutManager(Context context) {
        super(context);
    }

    public DownloadLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    public void onLayoutChildren(C1025n nVar, C1031r rVar) {
        try {
            super.onLayoutChildren(nVar, rVar);
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        } catch (RuntimeException e2) {
            e2.printStackTrace();
        }
    }

    public boolean supportsPredictiveItemAnimations() {
        return false;
    }
}
