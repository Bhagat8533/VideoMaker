package com.introvd.template.component.videofetcher.view;

import android.graphics.Rect;
import android.support.p024v7.widget.RecyclerView;
import android.support.p024v7.widget.RecyclerView.C1018h;
import android.support.p024v7.widget.RecyclerView.C1031r;
import android.support.p024v7.widget.RecyclerView.LayoutParams;
import android.view.View;
import com.introvd.template.component.videofetcher.utils.C5486d;

/* renamed from: com.introvd.template.component.videofetcher.view.g */
public class C5512g extends C1018h {
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, C1031r rVar) {
        super.getItemOffsets(rect, view, recyclerView, rVar);
        int viewLayoutPosition = ((LayoutParams) view.getLayoutParams()).getViewLayoutPosition();
        if (viewLayoutPosition == 0) {
            rect.left = C5486d.m14894O(view.getContext(), 12);
        } else if (viewLayoutPosition == recyclerView.getChildCount() - 1) {
            rect.left = C5486d.m14894O(view.getContext(), 18);
            rect.right = C5486d.m14894O(view.getContext(), 12);
        } else {
            rect.left = C5486d.m14894O(view.getContext(), 18);
        }
    }
}
