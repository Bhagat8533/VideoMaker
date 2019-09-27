package com.introvd.template.common.recycleviewutil;

import android.support.p024v7.widget.GridLayoutManager;
import android.support.p024v7.widget.GridLayoutManager.C0986b;
import android.support.p024v7.widget.RecyclerView;
import android.support.p024v7.widget.RecyclerView.C1008a;
import android.support.p024v7.widget.RecyclerView.LayoutManager;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

public class CustomRecyclerViewAdapter extends C1008a<BaseHolder> {
    private VisibleListener cfx;
    /* access modifiers changed from: private */
    public List<BaseItem> mList = new ArrayList();

    public interface VisibleListener {
        void onItemVisible(int i, BaseItem baseItem);
    }

    public CustomRecyclerViewAdapter() {
    }

    public CustomRecyclerViewAdapter(List<BaseItem> list) {
        if (list != null) {
            this.mList.addAll(list);
        }
    }

    public BaseItem get(int i) {
        if (this.mList == null || this.mList.size() <= i) {
            return null;
        }
        return (BaseItem) this.mList.get(i);
    }

    public int getItemCount() {
        if (this.mList == null) {
            return 0;
        }
        return this.mList.size();
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public int getItemViewType(int i) {
        return (this.mList == null || this.mList.size() <= i) ? super.getItemViewType(i) : ((BaseItem) this.mList.get(i)).getLayoutId();
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
            if (gridLayoutManager.mo7557kr() > 0) {
                gridLayoutManager.mo7544a(new C0986b() {
                    /* renamed from: bU */
                    public int mo7575bU(int i) {
                        if (CustomRecyclerViewAdapter.this.mList == null || CustomRecyclerViewAdapter.this.mList.size() <= i) {
                            return 1;
                        }
                        return ((BaseItem) CustomRecyclerViewAdapter.this.mList.get(i)).getSpanSize();
                    }
                });
            }
        }
    }

    public void onBindViewHolder(BaseHolder baseHolder, int i) {
        if (this.mList != null && this.mList.size() > i) {
            BaseItem baseItem = (BaseItem) this.mList.get(i);
            if (baseItem != null) {
                baseItem.mo26649a(baseHolder, i);
            }
        }
    }

    public BaseHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (this.mList == null) {
            return null;
        }
        return new BaseHolder(LayoutInflater.from(viewGroup.getContext()).inflate(i, viewGroup, false));
    }

    public void onViewAttachedToWindow(BaseHolder baseHolder) {
        super.onViewAttachedToWindow(baseHolder);
        int adapterPosition = baseHolder.getAdapterPosition();
        if (adapterPosition >= 0 && adapterPosition < getItemCount()) {
            BaseItem baseItem = get(baseHolder.getAdapterPosition());
            if (baseItem != null) {
                baseItem.onAttachedToWindow();
                if (this.cfx != null) {
                    this.cfx.onItemVisible(adapterPosition, baseItem);
                }
            }
        }
    }

    public void setData(List<BaseItem> list) {
        this.mList.clear();
        this.mList.addAll(list);
        notifyDataSetChanged();
    }

    @Deprecated
    public void setDataSameRef(List<BaseItem> list) {
        this.mList = list;
        notifyDataSetChanged();
    }

    public void setOnVisibleListener(VisibleListener visibleListener) {
        this.cfx = visibleListener;
    }
}
