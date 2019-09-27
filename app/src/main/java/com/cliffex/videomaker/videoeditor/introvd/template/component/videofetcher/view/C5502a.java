package com.introvd.template.component.videofetcher.view;

import android.graphics.Rect;
import android.support.p024v7.widget.GridLayoutManager;
import android.support.p024v7.widget.RecyclerView;
import android.support.p024v7.widget.RecyclerView.C1018h;
import android.support.p024v7.widget.RecyclerView.C1031r;
import android.support.p024v7.widget.RecyclerView.LayoutManager;
import android.support.p024v7.widget.RecyclerView.LayoutParams;
import android.support.p024v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import com.introvd.template.component.videofetcher.utils.C5486d;

/* renamed from: com.introvd.template.component.videofetcher.view.a */
public class C5502a extends C1018h {
    /* renamed from: a */
    private boolean m14933a(RecyclerView recyclerView, int i, int i2, int i3) {
        LayoutManager layoutManager = recyclerView.getLayoutManager();
        boolean z = false;
        if (layoutManager instanceof GridLayoutManager) {
            if ((i3 % i2 == 0 ? i3 / i2 : (i3 / i2) + 1) == (i / i2) + 1) {
                z = true;
            }
            return z;
        }
        if (layoutManager instanceof StaggeredGridLayoutManager) {
            if (((StaggeredGridLayoutManager) layoutManager).getOrientation() == 1) {
                int i4 = i3 % i2;
                if (i < i2) {
                    return true;
                }
            } else if ((i + 1) % i2 == 0) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: l */
    private int m14934l(RecyclerView recyclerView) {
        LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            return ((GridLayoutManager) layoutManager).mo7557kr();
        }
        if (layoutManager instanceof StaggeredGridLayoutManager) {
            return ((StaggeredGridLayoutManager) layoutManager).mo8357kr();
        }
        return -1;
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, C1031r rVar) {
        super.getItemOffsets(rect, view, recyclerView, rVar);
        int viewLayoutPosition = ((LayoutParams) view.getLayoutParams()).getViewLayoutPosition();
        int l = m14934l(recyclerView);
        int itemCount = recyclerView.getAdapter().getItemCount();
        int O = C5486d.m14894O(view.getContext(), 10);
        if (m14933a(recyclerView, viewLayoutPosition, l, itemCount)) {
            rect.set(0, O, 0, O);
        } else {
            rect.set(0, 0, 0, O);
        }
    }
}
