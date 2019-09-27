package com.introvd.template.editor.slideshow.adapter;

import android.content.Context;
import android.support.p024v7.widget.RecyclerView.C1008a;
import android.support.p024v7.widget.RecyclerView.C1034u;
import android.view.View;
import android.view.ViewGroup;
import com.introvd.template.editor.slideshow.adapter.C6746c.C6748a;
import com.introvd.template.editor.slideshow.model.SlideNodeModel;
import com.introvd.template.editor.slideshow.p279b.C6754b;
import com.introvd.template.p414ui.view.p415a.C8986a.C8987a;
import com.introvd.template.sdk.editor.cache.TrimedClipItemDataModel;
import com.p131c.p132a.p135c.p136a.C2579b;
import com.p131c.p132a.p135c.p136a.C2579b.C2582a;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.introvd.template.editor.slideshow.adapter.b */
public class C6742b extends C1008a<C6745a> implements C8987a {
    private List<SlideNodeModel> bDn = new ArrayList();
    private Context context;
    private int dfB = -1;
    /* access modifiers changed from: private */
    public C6754b dfC;

    /* renamed from: com.introvd.template.editor.slideshow.adapter.b$a */
    static class C6745a extends C1034u {
        SlideNodeItemView dfG;

        C6745a(SlideNodeItemView slideNodeItemView) {
            super(slideNodeItemView);
            this.dfG = slideNodeItemView;
        }
    }

    public C6742b(Context context2) {
        this.context = context2;
    }

    /* renamed from: a */
    private void m19592a(C6745a aVar, List<C6746c> list) {
        Boolean bool = null;
        Boolean bool2 = null;
        for (C6746c cVar : list) {
            if (cVar.aoW() != null) {
                bool = cVar.aoW();
            }
            if (cVar.aqY() != null) {
                bool2 = cVar.aqY();
            }
        }
        int adapterPosition = aVar.getAdapterPosition();
        if (adapterPosition >= 0 && adapterPosition < this.bDn.size()) {
            SlideNodeModel slideNodeModel = (SlideNodeModel) this.bDn.get(adapterPosition);
            if (bool != null) {
                aVar.dfG.mo30238gZ(slideNodeModel.isFocus());
            }
            if (bool2 != null) {
                aVar.dfG.mo30237g(slideNodeModel.getDataModel());
            }
        }
    }

    /* renamed from: N */
    public C6745a onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new C6745a(new SlideNodeItemView(this.context));
    }

    /* renamed from: a */
    public void onBindViewHolder(final C6745a aVar, int i) {
        final SlideNodeModel slideNodeModel = (SlideNodeModel) this.bDn.get(i);
        aVar.dfG.mo30236b(slideNodeModel);
        C2579b.m7398a(new C2582a<View>() {
            public void onClick(View view) {
                int adapterPosition = aVar.getAdapterPosition();
                if (adapterPosition != -1) {
                    if (C6742b.this.dfC != null) {
                        C6742b.this.dfC.mo30215a(adapterPosition, slideNodeModel);
                    }
                    C6742b.this.mo30249pa(adapterPosition);
                }
            }
        }, 300, aVar.dfG.getContentLayout());
        C2579b.m7398a(new C2582a<View>() {
            public void onClick(View view) {
                int adapterPosition = aVar.getAdapterPosition();
                if (adapterPosition != -1) {
                    if (C6742b.this.dfC != null) {
                        C6742b.this.dfC.mo30216b(adapterPosition, slideNodeModel);
                    }
                    C6742b.this.mo30249pa(adapterPosition);
                }
            }
        }, 500, aVar.dfG.getTextEditBtn());
    }

    /* renamed from: a */
    public void onBindViewHolder(C6745a aVar, int i, List<Object> list) {
        if (list.isEmpty()) {
            onBindViewHolder(aVar, i);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Object next : list) {
            if (next instanceof C6746c) {
                arrayList.add((C6746c) next);
            }
        }
        m19592a(aVar, (List<C6746c>) arrayList);
    }

    /* renamed from: a */
    public void mo30244a(C6754b bVar) {
        this.dfC = bVar;
    }

    public List<SlideNodeModel> aqW() {
        return this.bDn;
    }

    public int aqX() {
        return this.dfB;
    }

    /* renamed from: b */
    public void mo30247b(int i, TrimedClipItemDataModel trimedClipItemDataModel) {
        if (i >= 0 && i < this.bDn.size()) {
            ((SlideNodeModel) this.bDn.get(i)).setDataModel(trimedClipItemDataModel);
            notifyItemChanged(i, new C6748a().mo30256y(Boolean.valueOf(true)).aqZ());
        }
    }

    /* renamed from: bA */
    public void mo30248bA(List<SlideNodeModel> list) {
        this.bDn.clear();
        this.bDn.addAll(list);
        notifyDataSetChanged();
    }

    /* renamed from: cp */
    public void mo28031cp(int i, int i2) {
        if (i < this.bDn.size() && i2 < this.bDn.size()) {
            if (i < i2) {
                int i3 = i;
                while (i3 < i2) {
                    SlideNodeModel slideNodeModel = (SlideNodeModel) this.bDn.get(i3);
                    i3++;
                    SlideNodeModel slideNodeModel2 = (SlideNodeModel) this.bDn.get(i3);
                    TrimedClipItemDataModel dataModel = slideNodeModel.getDataModel();
                    slideNodeModel.setDataModel(slideNodeModel2.getDataModel());
                    slideNodeModel2.setDataModel(dataModel);
                }
            } else {
                for (int i4 = i; i4 > i2; i4--) {
                    SlideNodeModel slideNodeModel3 = (SlideNodeModel) this.bDn.get(i4);
                    SlideNodeModel slideNodeModel4 = (SlideNodeModel) this.bDn.get(i4 - 1);
                    TrimedClipItemDataModel dataModel2 = slideNodeModel3.getDataModel();
                    slideNodeModel3.setDataModel(slideNodeModel4.getDataModel());
                    slideNodeModel4.setDataModel(dataModel2);
                }
            }
            if (i == this.dfB) {
                this.dfB = i2;
            } else if (i2 == this.dfB) {
                this.dfB = i;
            }
            notifyItemMoved(i, i2);
        }
    }

    public int getItemCount() {
        return this.bDn.size();
    }

    /* renamed from: lo */
    public void mo28032lo(int i) {
        this.bDn.remove(i);
        notifyItemRemoved(i);
    }

    /* renamed from: pa */
    public void mo30249pa(int i) {
        if (this.dfB != i && this.dfB >= 0 && this.dfB < this.bDn.size()) {
            ((SlideNodeModel) this.bDn.get(this.dfB)).setFocus(false);
            notifyItemChanged(this.dfB, new C6748a().mo30255x(Boolean.valueOf(false)).aqZ());
        }
        if (i >= 0 && i < this.bDn.size()) {
            ((SlideNodeModel) this.bDn.get(i)).setFocus(true);
            notifyItemChanged(i, new C6748a().mo30255x(Boolean.valueOf(true)).aqZ());
        }
        this.dfB = i;
    }
}
