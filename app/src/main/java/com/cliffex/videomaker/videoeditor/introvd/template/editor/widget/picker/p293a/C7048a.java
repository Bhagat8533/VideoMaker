package com.introvd.template.editor.widget.picker.p293a;

import android.content.Context;
import android.support.p024v7.widget.RecyclerView.C1008a;
import android.support.p024v7.widget.RecyclerView.C1034u;
import android.support.p024v7.widget.StaggeredGridLayoutManager.LayoutParams;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.introvd.template.common.DeviceInfo;
import com.introvd.template.common.imageloader.ImageLoader;
import com.introvd.template.editor.R;
import com.introvd.template.p203b.C4580b;
import com.introvd.template.p203b.C4600l;
import com.introvd.template.template.p404d.C8653d;
import com.introvd.template.template.p408f.C8750d;
import com.quvideo.mobile.component.imageview.DynamicLoadingImageView;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.introvd.template.editor.widget.picker.a.a */
public class C7048a extends C1008a<C7050a> {
    private int cUw;
    private int drg = 1001;
    private List<C8653d> drh = new ArrayList();
    private List<C8653d> dri = new ArrayList();
    /* access modifiers changed from: private */
    public C7051b drj;
    /* access modifiers changed from: private */
    public Context mContext;

    /* renamed from: com.introvd.template.editor.widget.picker.a.a$a */
    static class C7050a extends C1034u {
        RelativeLayout ckV;
        ImageView dro;
        DynamicLoadingImageView drp;
        ImageView drq;

        C7050a(View view) {
            super(view);
            this.dro = (ImageView) view.findViewById(R.id.collage_gif_item_cover);
            this.ckV = (RelativeLayout) view.findViewById(R.id.collage_gif_download_layout);
            this.drp = (DynamicLoadingImageView) view.findViewById(R.id.collage_gif_download_loading);
            this.drq = (ImageView) view.findViewById(R.id.collage_gif_download_flag);
        }
    }

    public C7048a(Context context) {
        this.mContext = context;
        this.cUw = DeviceInfo.getScreenSize(this.mContext).width / 2;
    }

    /* renamed from: Q */
    public C7050a onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new C7050a(LayoutInflater.from(this.mContext).inflate(R.layout.editor_collage_gif_item_layout, viewGroup, false));
    }

    /* renamed from: a */
    public void onBindViewHolder(C7050a aVar, int i) {
        LayoutParams layoutParams = (LayoutParams) aVar.itemView.getLayoutParams();
        C8653d dVar = this.drg == 1001 ? (C8653d) this.drh.get(i) : this.drg == 1002 ? (C8653d) this.dri.get(i) : null;
        final C8653d dVar2 = dVar;
        if (!(dVar2 == null || dVar2.emo == null)) {
            float f = (((float) this.cUw) * 1.0f) / (((float) dVar2.width) * 1.0f);
            layoutParams.width = this.cUw;
            layoutParams.height = (int) (((float) dVar2.height) * f);
            aVar.itemView.setLayoutParams(layoutParams);
            aVar.itemView.invalidate();
            ImageLoader.loadImage(this.mContext, dVar2.emo, aVar.dro);
            final File file = new File(C8750d.m25575qz(dVar2.emo));
            final boolean exists = file.exists();
            aVar.ckV.setVisibility(8);
            aVar.drp.clearAnimation();
            if (exists) {
                aVar.drq.setVisibility(8);
            } else {
                aVar.drq.setVisibility(0);
            }
            View view = aVar.itemView;
            final C7050a aVar2 = aVar;
            C70491 r1 = new OnClickListener() {
                public void onClick(View view) {
                    if (!C4580b.m11632Sf()) {
                        if (exists) {
                            if (C7048a.this.drj != null) {
                                C7048a.this.drj.mo30965iU(file.getAbsolutePath());
                            }
                        } else if (C4600l.m11739k(C7048a.this.mContext, true) && C7048a.this.drj != null) {
                            aVar2.drq.setVisibility(8);
                            aVar2.ckV.setVisibility(0);
                            ImageLoader.loadImage(R.drawable.xiaoying_cam_filter_download_loading, aVar2.drp);
                            C7048a.this.drj.mo30964a(aVar2.getAdapterPosition(), dVar2);
                        }
                    }
                }
            };
            view.setOnClickListener(r1);
        }
    }

    /* renamed from: a */
    public void mo30986a(C7051b bVar) {
        this.drj = bVar;
    }

    /* renamed from: bL */
    public void mo30987bL(List<C8653d> list) {
        if (list != null) {
            switch (this.drg) {
                case 1001:
                    if (list.size() > 0) {
                        this.drh.addAll(list);
                        notifyItemRangeInserted(this.drh.size() - list.size(), list.size());
                        break;
                    }
                    break;
                case 1002:
                    this.dri.addAll(list);
                    notifyItemRangeInserted(this.dri.size() - list.size(), list.size());
                    break;
            }
        }
    }

    /* renamed from: bM */
    public void mo30988bM(List<C8653d> list) {
        if (list != null) {
            this.dri = list;
            notifyDataSetChanged();
        }
    }

    public int getItemCount() {
        return this.drg == 1001 ? this.drh.size() : this.dri.size();
    }

    /* renamed from: qd */
    public void mo30989qd(int i) {
        switch (i) {
            case 1001:
                if (this.drg != i) {
                    this.drg = 1001;
                    notifyDataSetChanged();
                    break;
                } else {
                    return;
                }
            case 1002:
                this.drg = 1002;
                break;
        }
    }
}
