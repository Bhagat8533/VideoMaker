package com.introvd.template.template.widget.p412a.p413a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bignerdranch.expandablerecyclerview.C2133b;
import com.introvd.template.template.R;
import com.introvd.template.template.widget.p412a.C8917a;
import java.util.List;

/* renamed from: com.introvd.template.template.widget.a.a.a */
public class C8918a extends C2133b<C8927g, C8924d, C8921c, C8919b> {
    private C8917a evj;
    private boolean evk = true;
    private LayoutInflater mInflater;

    public C8918a(Context context, List<C8927g> list) {
        super(list);
        this.mInflater = LayoutInflater.from(context);
    }

    /* renamed from: a */
    public void mo11777a(C8919b bVar, int i, int i2, C8924d dVar) {
        bVar.mo35504a(dVar, this.evj, this.evk);
    }

    /* renamed from: a */
    public void mo11779a(C8921c cVar, int i, C8927g gVar) {
        cVar.mo35508a(gVar, this.evj, this.evk);
    }

    /* renamed from: a */
    public void mo35501a(C8917a aVar) {
        this.evj = aVar;
    }

    /* renamed from: aa */
    public C8921c mo11794f(ViewGroup viewGroup, int i) {
        View inflate = this.mInflater.inflate(R.layout.xiaoying_cam_item_filter_parent, viewGroup, false);
        C8921c cVar = new C8921c(inflate);
        inflate.setTag(cVar);
        return cVar;
    }

    /* renamed from: ab */
    public C8919b mo11795g(ViewGroup viewGroup, int i) {
        return new C8919b(this.mInflater.inflate(R.layout.xiaoying_cam_item_filter_child, viewGroup, false));
    }
}
