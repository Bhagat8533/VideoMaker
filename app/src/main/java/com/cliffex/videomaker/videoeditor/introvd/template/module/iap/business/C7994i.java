package com.introvd.template.module.iap.business;

import android.support.p024v7.widget.RecyclerView.C1034u;
import android.util.SparseArray;
import android.view.View;

/* renamed from: com.introvd.template.module.iap.business.i */
public class C7994i extends C1034u {
    private SparseArray<View> cMd = new SparseArray<>();
    View cMe;

    public C7994i(View view) {
        super(view);
        this.cMe = view;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: n */
    public View mo32994n(int i) {
        View view = (View) this.cMd.get(i);
        if (view != null) {
            return view;
        }
        View findViewById = this.cMe.findViewById(i);
        this.cMd.put(i, findViewById);
        return findViewById;
    }
}
