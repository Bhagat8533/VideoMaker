package com.introvd.template.editor.common;

import android.content.Context;
import android.support.p024v7.widget.C1092ac;
import android.support.p024v7.widget.LinearLayoutManager;
import android.support.p024v7.widget.RecyclerView;
import android.support.p024v7.widget.RecyclerView.C1031r;
import android.util.DisplayMetrics;

public class SmoothLayoutManager extends LinearLayoutManager {
    public SmoothLayoutManager(Context context, int i, boolean z) {
        super(context, i, z);
    }

    public void smoothScrollToPosition(RecyclerView recyclerView, C1031r rVar, int i) {
        C58361 r2 = new C1092ac(recyclerView.getContext()) {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public float mo8664a(DisplayMetrics displayMetrics) {
                return 150.0f / ((float) displayMetrics.densityDpi);
            }
        };
        r2.mo8152cq(i);
        startSmoothScroll(r2);
    }
}
