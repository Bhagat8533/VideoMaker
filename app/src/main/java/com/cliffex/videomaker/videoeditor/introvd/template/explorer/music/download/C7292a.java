package com.introvd.template.explorer.music.download;

import android.support.p024v7.widget.RecyclerView.C1008a;
import android.support.p024v7.widget.RecyclerView.C1034u;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import com.introvd.template.common.recycleviewutil.BaseHolder;
import com.introvd.template.common.recycleviewutil.BaseItem;
import com.introvd.template.common.recycleviewutil.CustomRecyclerViewAdapter;
import com.introvd.template.p414ui.view.p415a.C8986a.C8987a;
import com.introvd.template.template.data.p406db.model.DBTemplateAudioInfo;
import com.introvd.template.vivaexplorermodule.R;
import com.p131c.p132a.p135c.C2575a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: com.introvd.template.explorer.music.download.a */
class C7292a extends C1008a<C7295b> implements C8987a {
    private List<BaseItem> bvs = new ArrayList();
    private CustomRecyclerViewAdapter dAY = new CustomRecyclerViewAdapter();
    /* access modifiers changed from: private */
    public C7294a dAZ;

    /* renamed from: com.introvd.template.explorer.music.download.a$a */
    public interface C7294a {
        /* renamed from: X */
        void mo31882X(C1034u uVar);
    }

    /* renamed from: com.introvd.template.explorer.music.download.a$b */
    class C7295b extends C1034u {
        /* access modifiers changed from: private */
        public BaseHolder dBc;
        View dBd;

        C7295b(BaseHolder baseHolder) {
            super(baseHolder.itemView);
            this.dBc = baseHolder;
            this.dBd = baseHolder.itemView.findViewById(R.id.music_item_move);
        }
    }

    C7292a(List<BaseItem> list) {
        this.bvs = list;
        this.dAY.setDataSameRef(list);
        setHasStableIds(true);
    }

    /* renamed from: S */
    public C7295b onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new C7295b(this.dAY.onCreateViewHolder(viewGroup, i));
    }

    /* renamed from: a */
    public void mo31894a(C7294a aVar) {
        this.dAZ = aVar;
    }

    /* renamed from: a */
    public void onBindViewHolder(final C7295b bVar, int i) {
        this.dAY.onBindViewHolder(bVar.dBc, i);
        if (bVar != null && bVar.dBd != null) {
            bVar.dBd.setOnTouchListener(new OnTouchListener() {
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (C7292a.this.dAZ != null) {
                        C7292a.this.dAZ.mo31882X(bVar);
                    }
                    return true;
                }
            });
        }
    }

    /* renamed from: cp */
    public void mo28031cp(int i, int i2) {
        if (i < i2) {
            int i3 = i;
            while (i3 < i2) {
                int i4 = i3 + 1;
                Collections.swap(this.bvs, i3, i4);
                i3 = i4;
            }
        } else {
            for (int i5 = i; i5 > i2; i5--) {
                Collections.swap(this.bvs, i5, i5 - 1);
            }
        }
        notifyItemMoved(i, i2);
    }

    public int getItemCount() {
        return this.dAY.getItemCount();
    }

    public long getItemId(int i) {
        return (this.bvs == null || this.bvs.get(i) == null || ((BaseItem) this.bvs.get(i)).getItemData() == null || !(((BaseItem) this.bvs.get(i)).getItemData() instanceof DBTemplateAudioInfo)) ? (long) i : (long) C2575a.parseInt(((DBTemplateAudioInfo) ((BaseItem) this.bvs.get(i)).getItemData()).index);
    }

    public int getItemViewType(int i) {
        return this.dAY.getItemViewType(i);
    }

    /* renamed from: lo */
    public void mo28032lo(int i) {
        this.bvs.remove(i);
        notifyItemRemoved(i);
    }
}
