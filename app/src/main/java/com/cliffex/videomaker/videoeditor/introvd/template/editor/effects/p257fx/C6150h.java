package com.introvd.template.editor.effects.p257fx;

import android.support.p024v7.widget.RecyclerView.C1034u;
import android.util.SparseArray;
import android.view.View;

/* renamed from: com.introvd.template.editor.effects.fx.h */
class C6150h extends C1034u {
    private SparseArray<View> cMd = new SparseArray<>();
    private View cMe;

    C6150h(View view) {
        super(view);
        this.cMe = view;
    }

    public View akM() {
        return this.cMe;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: n */
    public View mo28942n(int i) {
        View view = (View) this.cMd.get(i);
        if (view != null) {
            return view;
        }
        View findViewById = this.cMe.findViewById(i);
        this.cMd.put(i, findViewById);
        return findViewById;
    }
}
