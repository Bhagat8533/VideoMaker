package com.introvd.template.gallery.adapter;

import android.graphics.Rect;
import android.support.p024v7.widget.RecyclerView;
import android.support.p024v7.widget.RecyclerView.C1018h;
import android.support.p024v7.widget.RecyclerView.C1031r;
import android.view.View;
import com.introvd.template.p203b.C4580b;

/* renamed from: com.introvd.template.gallery.adapter.d */
public class C7430d extends C1018h {
    private boolean dHs;
    private int spacing;
    private int spanCount;

    public C7430d(int i, int i2, boolean z) {
        this.spanCount = i;
        this.spacing = i2;
        this.dHs = z;
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, C1031r rVar) {
        int aN = recyclerView.mo7746aN(view);
        int i = aN % this.spanCount;
        if (this.dHs) {
            if (C4580b.m11666qi()) {
                rect.right = this.spacing - ((this.spacing * i) / this.spanCount);
                rect.left = ((i + 1) * this.spacing) / this.spanCount;
            } else {
                rect.left = this.spacing - ((this.spacing * i) / this.spanCount);
                rect.right = ((i + 1) * this.spacing) / this.spanCount;
            }
            if (aN < this.spanCount) {
                rect.top = this.spacing;
            }
            rect.bottom = this.spacing;
            return;
        }
        if (C4580b.m11666qi()) {
            rect.right = (this.spacing * i) / this.spanCount;
            rect.left = this.spacing - (((i + 1) * this.spacing) / this.spanCount);
        } else {
            rect.left = (this.spacing * i) / this.spanCount;
            rect.right = this.spacing - (((i + 1) * this.spacing) / this.spanCount);
        }
        if (aN >= this.spanCount) {
            rect.top = this.spacing;
        }
    }
}
