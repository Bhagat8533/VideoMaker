package com.introvd.template.common.recycleviewutil;

import android.support.p024v7.widget.RecyclerView.C1034u;
import android.util.SparseArray;
import android.view.View;

public class BaseHolder extends C1034u {
    private final SparseArray<View> bvE = new SparseArray<>();

    BaseHolder(View view) {
        super(view);
    }

    public <T extends View> T findViewById(int i) {
        T t = (View) this.bvE.get(i);
        if (t != null) {
            return t;
        }
        T findViewById = this.itemView.findViewById(i);
        this.bvE.put(i, findViewById);
        return findViewById;
    }
}
