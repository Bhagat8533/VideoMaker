package com.introvd.template.p310g;

import android.databinding.C0170e;
import android.databinding.C0171f;
import android.databinding.ViewDataBinding;
import android.support.p024v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.introvd.template.R;

/* renamed from: com.introvd.template.g.m */
public abstract class C7374m extends ViewDataBinding {
    public final TextView bAk;
    public final RecyclerView coP;
    public final TextView cpx;
    public final View cpy;

    protected C7374m(C0170e eVar, View view, int i, TextView textView, RecyclerView recyclerView, TextView textView2, View view2) {
        super(eVar, view, i);
        this.cpx = textView;
        this.coP = recyclerView;
        this.bAk = textView2;
        this.cpy = view2;
    }

    /* renamed from: b */
    public static C7374m m21735b(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return m21736b(layoutInflater, viewGroup, z, C0171f.m360T());
    }

    /* renamed from: b */
    public static C7374m m21736b(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, C0170e eVar) {
        return (C7374m) C0171f.m366a(layoutInflater, R.layout.app_view_school_course_list_item, viewGroup, z, eVar);
    }
}
