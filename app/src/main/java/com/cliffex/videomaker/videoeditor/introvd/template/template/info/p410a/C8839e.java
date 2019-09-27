package com.introvd.template.template.info.p410a;

import android.graphics.Rect;
import android.support.p024v7.widget.GridLayoutManager;
import android.support.p024v7.widget.RecyclerView;
import android.support.p024v7.widget.RecyclerView.C1018h;
import android.support.p024v7.widget.RecyclerView.C1031r;
import android.view.View;

/* renamed from: com.introvd.template.template.info.a.e */
public class C8839e extends C1018h {
    private boolean dHs;
    private boolean epW;
    private int spacing;
    private int spanCount;

    public C8839e(int i, int i2, boolean z, boolean z2) {
        this.spanCount = i;
        this.spacing = i2;
        this.dHs = z;
        this.epW = z2;
    }

    /* renamed from: a */
    private int m25942a(GridLayoutManager gridLayoutManager, int i) {
        int i2 = 0;
        for (int i3 = i - 1; i3 >= 0; i3--) {
            if (!(gridLayoutManager == null || gridLayoutManager.mo7556ko() == null || gridLayoutManager.mo7556ko().mo7575bU(i3) != 1)) {
                i2++;
            }
        }
        return i2;
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, C1031r rVar) {
        int aN = recyclerView.mo7746aN(view);
        GridLayoutManager gridLayoutManager = (GridLayoutManager) recyclerView.getLayoutManager();
        if (((gridLayoutManager == null || gridLayoutManager.mo7556ko() == null) ? 1 : gridLayoutManager.mo7556ko().mo7575bU(aN)) == this.spanCount) {
            rect.left = 0;
            rect.right = 0;
            rect.top = this.spacing / 2;
            rect.bottom = 0;
            return;
        }
        int a = (aN <= 0 || !this.epW) ? aN % this.spanCount : m25942a(gridLayoutManager, aN) % this.spanCount;
        if (this.dHs) {
            rect.left = this.spacing - ((this.spacing * a) / this.spanCount);
            rect.right = ((a + 1) * this.spacing) / this.spanCount;
            rect.top = this.spacing;
            rect.bottom = 0;
            return;
        }
        rect.left = (this.spacing * a) / this.spanCount;
        rect.right = this.spacing - (((a + 1) * this.spacing) / this.spanCount);
        rect.top = this.spacing;
        rect.bottom = 0;
    }
}
