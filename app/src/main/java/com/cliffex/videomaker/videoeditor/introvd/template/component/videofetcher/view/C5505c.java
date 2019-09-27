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

/* renamed from: com.introvd.template.component.videofetcher.view.c */
public class C5505c extends C1018h {
    /* renamed from: b */
    private boolean m14940b(RecyclerView recyclerView, int i, int i2, int i3) {
        LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            int i4 = i3 % i2;
            if ((i4 == 0 ? i3 / i2 : (i3 / i2) + 1) == (i / i2) + 1 && i4 == 1 && i == i3 - 1) {
                return true;
            }
        } else if ((layoutManager instanceof StaggeredGridLayoutManager) && ((StaggeredGridLayoutManager) layoutManager).getOrientation() == 1 && (i + 1) % i2 == 1 && i == i3 - 1) {
            return true;
        }
        return false;
    }

    /* renamed from: c */
    private boolean m14941c(RecyclerView recyclerView, int i, int i2, int i3) {
        LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            if ((i + 1) % i2 == 0) {
                return true;
            }
        } else if (layoutManager instanceof StaggeredGridLayoutManager) {
            if (((StaggeredGridLayoutManager) layoutManager).getOrientation() == 1) {
                if ((i + 1) % i2 == 0) {
                    return true;
                }
            } else if (i >= i3 - (i3 % i2)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: l */
    private int m14942l(RecyclerView recyclerView) {
        LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            return ((GridLayoutManager) layoutManager).mo7557kr();
        }
        if (layoutManager instanceof StaggeredGridLayoutManager) {
            return ((StaggeredGridLayoutManager) layoutManager).mo8357kr();
        }
        return -1;
    }

    /* renamed from: d */
    public boolean mo27220d(RecyclerView recyclerView, int i, int i2, int i3) {
        int i4 = i + 1;
        boolean z = false;
        if (i4 < i3) {
            return false;
        }
        LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            if ((i3 % i2 == 0 ? i3 / i2 : (i3 / i2) + 1) == (i / i2) + 1) {
                z = true;
            }
            return z;
        }
        if (layoutManager instanceof StaggeredGridLayoutManager) {
            if (((StaggeredGridLayoutManager) layoutManager).getOrientation() == 1) {
                if (i >= i3 - (i3 % i2)) {
                    return true;
                }
            } else if (i4 % i2 == 0) {
                return true;
            }
        }
        return false;
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, C1031r rVar) {
        super.getItemOffsets(rect, view, recyclerView, rVar);
        int viewLayoutPosition = ((LayoutParams) view.getLayoutParams()).getViewLayoutPosition();
        int l = m14942l(recyclerView);
        int itemCount = recyclerView.getAdapter().getItemCount();
        int O = C5486d.m14894O(view.getContext(), 10);
        if (viewLayoutPosition != 0) {
            int i = viewLayoutPosition - 1;
            if (mo27220d(recyclerView, i, l, itemCount) && !m14940b(recyclerView, i, l, itemCount)) {
                rect.set(O, O, 0, O);
                return;
            }
        }
        if (viewLayoutPosition != 0 && m14941c(recyclerView, viewLayoutPosition - 1, l, itemCount)) {
            rect.set(O / 2, O, O, 0);
        } else if (m14940b(recyclerView, viewLayoutPosition - 1, l, itemCount - 1)) {
            rect.set(O, O, O / 2, O);
        } else {
            rect.set(O, O, O / 2, 0);
        }
    }
}
