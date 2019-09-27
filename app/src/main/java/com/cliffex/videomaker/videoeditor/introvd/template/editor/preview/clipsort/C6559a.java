package com.introvd.template.editor.preview.clipsort;

import android.content.Context;
import android.os.Handler;
import android.support.p024v7.widget.RecyclerView.C1008a;
import android.support.p024v7.widget.RecyclerView.C1034u;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.introvd.template.common.Constants;
import com.introvd.template.editor.common.C5843c;
import com.introvd.template.editor.preview.adapter.C6530b;
import com.introvd.template.editor.preview.adapter.C6530b.C6531a;
import com.introvd.template.editor.preview.adapter.C6548e;
import com.introvd.template.editor.preview.model.ClipItemInfo;
import com.introvd.template.p203b.C4583d;
import com.introvd.template.p414ui.view.p415a.C8986a.C8987a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: com.introvd.template.editor.preview.clipsort.a */
public class C6559a extends C1008a<C6561a> implements C8987a {
    public static int daA = 0;
    public static int daB = 4;
    private int cUw;
    private boolean cZX;
    private Context context;
    private List<ClipItemInfo> daC = new ArrayList();
    private C6548e daD;

    /* renamed from: com.introvd.template.editor.preview.clipsort.a$a */
    static class C6561a extends C1034u {
        ClipSortItemView daG;

        C6561a(ClipSortItemView clipSortItemView) {
            super(clipSortItemView);
            this.daG = clipSortItemView;
        }
    }

    public C6559a(Context context2, C6548e eVar) {
        this.context = context2;
        this.daD = eVar;
        daA = C4583d.m11670O(context2, 10);
        this.cUw = ((Constants.getScreenSize().width - (daA * 5)) - (C4583d.m11670O(context2, 5) * 2)) / daB;
    }

    /* renamed from: K */
    public C6561a onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new C6561a(new ClipSortItemView(this.context));
    }

    /* renamed from: a */
    public void onBindViewHolder(C6561a aVar, int i) {
        LayoutParams layoutParams = new LayoutParams(-2, -2);
        layoutParams.width = this.cUw;
        layoutParams.height = this.cUw;
        aVar.daG.setLayoutParams(layoutParams);
        aVar.daG.mo29872a(i, (ClipItemInfo) this.daC.get(i), this.daD);
        aVar.daG.mo29873o(this.cZX, i + 1);
    }

    /* renamed from: a */
    public void onBindViewHolder(C6561a aVar, int i, List<Object> list) {
        if (list.isEmpty()) {
            onBindViewHolder(aVar, i);
            return;
        }
        Object obj = list.get(0);
        if ((obj instanceof C6530b) && ((C6530b) obj).aoY() != null) {
            aVar.daG.mo29873o(this.cZX, aVar.getAdapterPosition() + 1);
        }
    }

    /* renamed from: bf */
    public void mo29877bf(List<ClipItemInfo> list) {
        this.daC.clear();
        this.daC.addAll(list);
        notifyDataSetChanged();
    }

    /* renamed from: cp */
    public void mo28031cp(int i, int i2) {
        if (i < i2) {
            int i3 = i;
            while (i3 < i2) {
                int i4 = i3 + 1;
                Collections.swap(this.daC, i3, i4);
                i3 = i4;
            }
        } else {
            for (int i5 = i; i5 > i2; i5--) {
                Collections.swap(this.daC, i5, i5 - 1);
            }
        }
        int agQ = C5843c.agO().agQ();
        if (i == agQ) {
            C5843c.agO().mo28234lS(i2);
        } else if (i2 == agQ) {
            C5843c.agO().mo28234lS(i);
        }
        notifyItemMoved(i, i2);
    }

    public int getItemCount() {
        return this.daC.size();
    }

    /* renamed from: gz */
    public void mo29878gz(boolean z) {
        if (this.cZX != z) {
            this.cZX = z;
            final C6531a v = new C6531a().mo29811v(Boolean.valueOf(z));
            new Handler().post(new Runnable() {
                public void run() {
                    C6559a.this.notifyItemRangeChanged(0, C6559a.this.getItemCount(), v.aoZ());
                }
            });
        }
    }

    /* renamed from: lo */
    public void mo28032lo(int i) {
        this.daC.remove(i);
        notifyItemRemoved(i);
    }
}
