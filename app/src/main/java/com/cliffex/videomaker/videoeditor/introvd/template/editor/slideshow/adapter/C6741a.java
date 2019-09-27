package com.introvd.template.editor.slideshow.adapter;

import android.graphics.Rect;
import android.support.p024v7.widget.RecyclerView;
import android.support.p024v7.widget.RecyclerView.C1018h;
import android.support.p024v7.widget.RecyclerView.C1031r;
import android.view.View;
import com.introvd.template.p203b.C4580b;

/* renamed from: com.introvd.template.editor.slideshow.adapter.a */
public class C6741a extends C1018h {
    private int cZQ;

    public C6741a(int i) {
        this.cZQ = i;
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, C1031r rVar) {
        if (C4580b.m11666qi()) {
            if (recyclerView.mo7746aN(view) == 0) {
                rect.right = (int) (((double) this.cZQ) * 1.5d);
            } else if (recyclerView.mo7746aN(view) == recyclerView.getAdapter().getItemCount() - 1) {
                rect.right = this.cZQ;
            }
        } else if (recyclerView.mo7746aN(view) == 0) {
            rect.left = (int) (((double) this.cZQ) * 1.5d);
        } else {
            rect.left = this.cZQ;
        }
    }
}
