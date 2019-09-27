package com.introvd.template.editor.widget.picker;

import android.graphics.Rect;
import android.support.p024v7.widget.RecyclerView;
import android.support.p024v7.widget.RecyclerView.C1018h;
import android.support.p024v7.widget.RecyclerView.C1031r;
import android.view.View;

/* renamed from: com.introvd.template.editor.widget.picker.b */
public class C7058b extends C1018h {
    private int cZQ;

    public C7058b(int i) {
        this.cZQ = i;
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, C1031r rVar) {
        rect.left = this.cZQ;
        rect.right = this.cZQ;
        rect.bottom = this.cZQ;
        rect.top = this.cZQ;
    }
}
