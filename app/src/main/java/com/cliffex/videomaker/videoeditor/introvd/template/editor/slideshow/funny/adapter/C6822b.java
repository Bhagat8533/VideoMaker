package com.introvd.template.editor.slideshow.funny.adapter;

import android.content.Context;
import android.support.p024v7.widget.RecyclerView.C1008a;
import android.support.p024v7.widget.RecyclerView.C1034u;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.introvd.template.editor.R;
import com.introvd.template.editor.slideshow.model.SlideSceneModel;
import com.introvd.template.editor.slideshow.p279b.C6754b;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.introvd.template.editor.slideshow.funny.adapter.b */
public class C6822b extends C1008a<C6824a> {
    private Context context;
    private List<SlideSceneModel> dha = new ArrayList();
    /* access modifiers changed from: private */
    public C6754b dhb;
    private int dhc = -1;

    /* renamed from: com.introvd.template.editor.slideshow.funny.adapter.b$a */
    static class C6824a extends C1034u {
        ImageView dhg;
        View dhh;
        TextView dhi;

        C6824a(View view) {
            super(view);
            this.dhg = (ImageView) view.findViewById(R.id.scene_thumb);
            this.dhh = view.findViewById(R.id.scene_focus_bg);
            this.dhi = (TextView) view.findViewById(R.id.scene_item_order);
        }
    }

    public C6822b(Context context2) {
        this.context = context2;
    }

    /* renamed from: P */
    public C6824a onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new C6824a(LayoutInflater.from(this.context).inflate(R.layout.funny_scene_item_layout, viewGroup, false));
    }

    /* renamed from: a */
    public void mo30396a(int i, SlideSceneModel slideSceneModel) {
        if (i >= 0 && i < this.dha.size()) {
            ((SlideSceneModel) this.dha.get(i)).setThumbnail(slideSceneModel.getThumbnail());
            notifyItemChanged(i);
        }
    }

    /* renamed from: a */
    public void onBindViewHolder(final C6824a aVar, int i) {
        final SlideSceneModel slideSceneModel = (SlideSceneModel) this.dha.get(i);
        if (slideSceneModel != null) {
            if (slideSceneModel.getThumbnail() != null) {
                aVar.dhg.setImageBitmap(slideSceneModel.getThumbnail());
            }
            aVar.dhi.setText(String.valueOf(slideSceneModel.getIndex()));
            aVar.dhh.setVisibility(slideSceneModel.isFocus() ? 0 : 8);
            aVar.itemView.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    C6822b.this.mo30400pa(aVar.getAdapterPosition());
                    if (C6822b.this.dhb != null) {
                        C6822b.this.dhb.mo30215a(aVar.getAdapterPosition(), slideSceneModel);
                    }
                }
            });
        }
    }

    /* renamed from: b */
    public void mo30398b(C6754b bVar) {
        this.dhb = bVar;
    }

    /* renamed from: bH */
    public void mo30399bH(List<SlideSceneModel> list) {
        this.dha.clear();
        this.dha.addAll(list);
        notifyDataSetChanged();
    }

    public int getItemCount() {
        return this.dha.size();
    }

    /* renamed from: pa */
    public void mo30400pa(int i) {
        if (i != this.dhc) {
            if (this.dhc >= 0 && this.dhc < this.dha.size()) {
                ((SlideSceneModel) this.dha.get(this.dhc)).setFocus(false);
                notifyItemChanged(this.dhc);
            }
            if (i >= 0 && i < this.dha.size()) {
                ((SlideSceneModel) this.dha.get(i)).setFocus(true);
                notifyItemChanged(i);
            }
            this.dhc = i;
        }
    }
}
