package com.introvd.template.picker.adapter;

import android.content.Context;
import android.support.p024v7.widget.RecyclerView.C1008a;
import android.support.p024v7.widget.RecyclerView.C1034u;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.introvd.template.picker.item.PickerFolderFooterView;
import com.introvd.template.picker.item.PickerFolderItemView;
import com.introvd.template.picker.p366b.C8190c;
import com.introvd.template.picker.p367c.C8192a;
import com.introvd.template.picker.p369d.C8218b;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.introvd.template.picker.adapter.a */
public class C8173a extends C1008a<C1034u> {
    public static int dXS = 0;
    public static int dXT = 3;
    private List<C8192a> dXU = new ArrayList();
    private int dXV = 1;
    /* access modifiers changed from: private */
    public C8190c dXW;
    private Context mContext;

    /* renamed from: com.introvd.template.picker.adapter.a$a */
    static class C8176a extends C1034u {
        PickerFolderFooterView dYa;

        C8176a(PickerFolderFooterView pickerFolderFooterView) {
            super(pickerFolderFooterView);
            this.dYa = pickerFolderFooterView;
        }
    }

    /* renamed from: com.introvd.template.picker.adapter.a$b */
    static class C8177b extends C1034u {
        PickerFolderItemView dYb;

        C8177b(PickerFolderItemView pickerFolderItemView) {
            super(pickerFolderItemView);
            this.dYb = pickerFolderItemView;
        }
    }

    public C8173a(Context context) {
        this.mContext = context;
        dXS = C8218b.m23732O(context, 15);
    }

    /* renamed from: a */
    public void mo33264a(C8190c cVar) {
        this.dXW = cVar;
    }

    /* renamed from: cB */
    public void mo33265cB(List<C8192a> list) {
        if (list != null) {
            this.dXU.clear();
            this.dXU.addAll(list);
            notifyDataSetChanged();
        }
    }

    public int getItemCount() {
        return this.dXU.size();
    }

    public int getItemViewType(int i) {
        return ((C8192a) this.dXU.get(i)).aFH();
    }

    /* renamed from: m */
    public void mo33266m(List<C8192a> list, int i) {
        if (list != null) {
            this.dXV = i;
            this.dXU.clear();
            this.dXU.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void onBindViewHolder(C1034u uVar, int i) {
        if (getItemViewType(i) == 1) {
            uVar.itemView.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    if (C8173a.this.dXW != null) {
                        C8173a.this.dXW.aFC();
                    }
                }
            });
            return;
        }
        final C8177b bVar = (C8177b) uVar;
        final C8192a aVar = (C8192a) this.dXU.get(i);
        bVar.dYb.mo33379c(aVar);
        bVar.dYb.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (C8173a.this.dXW != null) {
                    aVar.mo33315tb(0);
                    bVar.dYb.setNewFlag(false);
                    C8173a.this.dXW.mo33305a(aVar);
                }
            }
        });
    }

    public C1034u onCreateViewHolder(ViewGroup viewGroup, int i) {
        return i == 1 ? new C8176a(new PickerFolderFooterView(this.mContext, this.dXV)) : new C8177b(new PickerFolderItemView(this.mContext));
    }
}
