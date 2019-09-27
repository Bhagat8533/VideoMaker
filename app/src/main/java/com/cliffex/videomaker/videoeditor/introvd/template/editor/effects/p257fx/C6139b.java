package com.introvd.template.editor.effects.p257fx;

import android.content.Context;
import android.support.p024v7.widget.RecyclerView.C1008a;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.introvd.template.common.imageloader.ImageLoader;
import com.introvd.template.editor.R;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.introvd.template.editor.effects.fx.b */
public class C6139b extends C1008a<C6150h> {
    private static final int cLj = R.layout.editor_effect_fx_recycler_item_category_group;
    private List<C6146d> cLk = new ArrayList();
    /* access modifiers changed from: private */
    public C6138a<C6146d> cLl;
    /* access modifiers changed from: private */
    public C6146d cLm;
    private Context context;

    C6139b(Context context2) {
        this.context = context2;
    }

    /* renamed from: ht */
    private int m17504ht(String str) {
        if (this.cLk == null || this.cLk.isEmpty() || TextUtils.isEmpty(str)) {
            return 0;
        }
        for (int i = 0; i < this.cLk.size(); i++) {
            if (str.equals(((C6146d) this.cLk.get(i)).akw())) {
                return i;
            }
        }
        return 0;
    }

    /* renamed from: G */
    public C6150h onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new C6150h(LayoutInflater.from(this.context).inflate(cLj, viewGroup, false));
    }

    /* renamed from: a */
    public void mo28898a(C6138a<C6146d> aVar) {
        this.cLl = aVar;
    }

    /* renamed from: a */
    public void mo28899a(C6146d dVar) {
        this.cLm = dVar;
        notifyDataSetChanged();
    }

    /* renamed from: a */
    public void mo28900a(C6146d dVar, List<C6146d> list) {
        if (list != null && !list.isEmpty()) {
            if (this.cLk == null) {
                this.cLk = new ArrayList(list);
            } else {
                this.cLk.clear();
                this.cLk.addAll(list);
            }
            if (dVar == null) {
                this.cLm = (C6146d) list.get(0);
            } else {
                this.cLm = dVar;
            }
            notifyDataSetChanged();
        }
    }

    /* renamed from: a */
    public void onBindViewHolder(C6150h hVar, int i) {
        final C6146d dVar = (C6146d) this.cLk.get(i);
        if (dVar != null) {
            ImageView imageView = (ImageView) hVar.mo28942n(R.id.iv_thumb);
            if (this.cLm != null && !TextUtils.isEmpty(this.cLm.akw())) {
                if (this.cLm.akw().equals(dVar.akw())) {
                    imageView.setBackgroundResource(R.color.white_p10);
                } else {
                    imageView.setBackgroundResource(R.color.transparent);
                }
            }
            if (!TextUtils.isEmpty(dVar.aky())) {
                ImageLoader.loadImage(this.context, dVar.aky(), imageView);
            } else {
                ImageLoader.loadImage(this.context, R.drawable.editor_icon_effect_bubble_loading, imageView);
                if ("20160224184733".equals(dVar.akw())) {
                    ImageLoader.loadImage(this.context, R.drawable.editor_effect_bubble_dft_sticker_icon, imageView);
                } else if ("20160224184948".equals(dVar.akw())) {
                    ImageLoader.loadImage(this.context, R.drawable.editor_effect_bubble_dft_subtitle_icon, imageView);
                }
            }
            ((TextView) hVar.mo28942n(R.id.tv_title)).setText(dVar.akx());
            hVar.akM().setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    C6139b.this.cLm = dVar;
                    C6139b.this.notifyDataSetChanged();
                    if (C6139b.this.cLl != null) {
                        C6139b.this.cLl.mo28880S(dVar);
                    }
                }
            });
        }
    }

    public void aku() {
        if (this.cLk != null && !this.cLk.isEmpty()) {
            this.cLm = (C6146d) this.cLk.get(0);
            notifyDataSetChanged();
        }
    }

    public C6146d akv() {
        if (this.cLk == null || this.cLk.isEmpty()) {
            return null;
        }
        return (C6146d) this.cLk.get(0);
    }

    /* renamed from: b */
    public int mo28904b(C6146d dVar) {
        int i = -1;
        if (dVar == null || TextUtils.isEmpty(dVar.akw()) || getItemCount() <= 0) {
            return -1;
        }
        int i2 = 0;
        while (true) {
            if (i2 >= getItemCount()) {
                break;
            }
            C6146d dVar2 = (C6146d) this.cLk.get(i2);
            if (dVar2 != null && dVar.akw().equals(dVar2.akw())) {
                i = i2;
                break;
            }
            i2++;
        }
        return i;
    }

    public int getItemCount() {
        if (this.cLk == null) {
            return 0;
        }
        return this.cLk.size();
    }

    /* renamed from: hs */
    public void mo28905hs(String str) {
        int ht = m17504ht(str);
        if (ht >= 0 && ht < this.cLk.size()) {
            this.cLm = (C6146d) this.cLk.get(ht);
            notifyDataSetChanged();
            if (this.cLl != null) {
                this.cLl.mo28880S(this.cLm);
            }
        }
    }

    public void setDataList(List<C6146d> list) {
        mo28900a((C6146d) null, list);
    }
}
