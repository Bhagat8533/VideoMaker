package com.introvd.template.component.videofetcher.p238b;

import android.support.p024v7.widget.GridLayoutManager;
import android.support.p024v7.widget.GridLayoutManager.C0986b;
import android.support.p024v7.widget.RecyclerView;
import android.support.p024v7.widget.RecyclerView.C1008a;
import android.support.p024v7.widget.RecyclerView.C1034u;
import android.support.p024v7.widget.RecyclerView.LayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.introvd.template.component.videofetcher.R;
import com.introvd.template.component.videofetcher.p239c.C5396f;
import com.introvd.template.component.videofetcher.p240d.C5405c;
import com.introvd.template.component.videofetcher.utils.C5485c;
import java.util.ArrayList;

/* renamed from: com.introvd.template.component.videofetcher.b.d */
public class C5376d extends C1008a<C1034u> {
    private ArrayList<C5396f> cjD;
    /* access modifiers changed from: private */
    public C5405c cjE;

    /* renamed from: com.introvd.template.component.videofetcher.b.d$a */
    private class C5378a extends C1034u implements OnClickListener {
        /* access modifiers changed from: private */
        public final ImageView cjG;
        /* access modifiers changed from: private */
        public final TextView cjH;

        public C5378a(View view) {
            super(view);
            this.cjG = (ImageView) view.findViewById(R.id.status_iv_more);
            this.cjH = (TextView) view.findViewById(R.id.status_tv_more);
            view.setOnClickListener(this);
        }

        public void onClick(View view) {
            if (!C5485c.m14890Sf() && C5376d.this.cjE != null) {
                C5376d.this.cjE.mo27033e(getAdapterPosition(), view);
            }
        }
    }

    /* renamed from: com.introvd.template.component.videofetcher.b.d$b */
    private class C5379b extends C1034u implements OnClickListener {
        /* access modifiers changed from: private */
        public final ImageView cjI;
        /* access modifiers changed from: private */
        public final TextView cjJ;

        public C5379b(View view) {
            super(view);
            this.cjI = (ImageView) view.findViewById(R.id.status_iv_normal);
            this.cjJ = (TextView) view.findViewById(R.id.status_tv_normal);
            view.setOnClickListener(this);
        }

        public void onClick(View view) {
            if (!C5485c.m14890Sf() && C5376d.this.cjE != null) {
                C5376d.this.cjE.mo27033e(getAdapterPosition(), view);
            }
        }
    }

    /* renamed from: com.introvd.template.component.videofetcher.b.d$c */
    private class C5380c extends C1034u {
        public C5380c(View view) {
            super(view);
        }
    }

    /* renamed from: ZK */
    public ArrayList<C5396f> mo26955ZK() {
        return this.cjD;
    }

    /* renamed from: a */
    public void mo26956a(C5405c cVar) {
        this.cjE = cVar;
    }

    /* renamed from: d */
    public void mo26957d(ArrayList<C5396f> arrayList) {
        this.cjD = arrayList;
        notifyDataSetChanged();
    }

    public int getItemCount() {
        if (this.cjD == null) {
            return 0;
        }
        return this.cjD.size();
    }

    public int getItemViewType(int i) {
        return this.cjD != null ? ((C5396f) this.cjD.get(i)).mo27004ZV() : super.getItemViewType(i);
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            ((GridLayoutManager) layoutManager).mo7544a(new C0986b() {
                /* renamed from: bU */
                public int mo7575bU(int i) {
                    return C5376d.this.getItemViewType(i) == 16 ? 2 : 1;
                }
            });
        }
    }

    public void onBindViewHolder(C1034u uVar, int i) {
        C5396f fVar = (C5396f) this.cjD.get(i);
        if (uVar instanceof C5379b) {
            C5379b bVar = (C5379b) uVar;
            bVar.cjI.setImageResource(fVar.mo27003ZU());
            bVar.cjJ.setText(fVar.getTitle());
        } else if (uVar instanceof C5378a) {
            C5378a aVar = (C5378a) uVar;
            aVar.cjG.setImageResource(fVar.mo27003ZU());
            aVar.cjH.setText(fVar.getTitle());
        }
    }

    public C1034u onCreateViewHolder(ViewGroup viewGroup, int i) {
        return i == 16 ? new C5380c(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fetcher_view_status_item_tips, viewGroup, false)) : i == 17 ? new C5379b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fetcher_view_status_item_normal, viewGroup, false)) : new C5378a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fetcher_view_status_item_more, viewGroup, false));
    }
}
