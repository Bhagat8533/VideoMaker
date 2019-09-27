package com.introvd.template.p414ui.view;

import android.content.Context;
import android.support.p024v7.widget.RecyclerView;
import android.util.AttributeSet;

/* renamed from: com.introvd.template.ui.view.HotFixRecyclerView */
public class HotFixRecyclerView extends RecyclerView {
    public HotFixRecyclerView(Context context) {
        super(context);
    }

    public HotFixRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public HotFixRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        try {
            super.onDetachedFromWindow();
        } catch (NullPointerException unused) {
        }
    }
}
