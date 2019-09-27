package com.introvd.template.app.p199v5.common;

import android.support.p024v7.widget.RecyclerView.C1008a;
import android.support.p024v7.widget.RecyclerView.C1034u;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;

/* renamed from: com.introvd.template.app.v5.common.b */
public abstract class C4417b<T> extends C1008a<C1034u> {
    protected static final int VIEW_TYPE_FOOTER = 3;
    protected static final int VIEW_TYPE_HEADER = 1;
    protected static final int VIEW_TYPE_ITEM = 2;
    protected List<T> mList;
    /* access modifiers changed from: protected */
    public C4418a mListener;

    /* renamed from: com.introvd.template.app.v5.common.b$a */
    public interface C4418a {
        void onItemClicked(int i);
    }

    /* renamed from: com.introvd.template.app.v5.common.b$b */
    protected class C4419b extends C1034u {
        public C4419b(View view) {
            super(view);
        }
    }

    public void addDataList(List<T> list) {
        if (this.mList == null) {
            this.mList = list;
        } else {
            this.mList.addAll(list);
        }
    }

    public int getDataItemCount() {
        if (this.mList == null) {
            return 0;
        }
        return this.mList.size();
    }

    public List<T> getDataList() {
        return this.mList;
    }

    public int getItemCount() {
        int i = (isSupportHeaderItem() ? 1 : 0) + (isSupportFooterItem() ? 1 : 0);
        return this.mList == null ? i : i + this.mList.size();
    }

    public int getItemViewType(int i) {
        if (isHeaderItem(i)) {
            return 1;
        }
        return isFooterItem(i) ? 3 : 2;
    }

    @Deprecated
    public T getListItem(int i) {
        int realItemPosition = getRealItemPosition(i);
        if (this.mList == null || realItemPosition < 0 || realItemPosition >= this.mList.size()) {
            return null;
        }
        return this.mList.get(realItemPosition);
    }

    public T getListItem(int i, boolean z) {
        if (!z) {
            i = getRealItemPosition(i);
        }
        if (this.mList == null || i < 0 || i >= this.mList.size()) {
            return null;
        }
        return this.mList.get(i);
    }

    public int getRealItemPosition(int i) {
        return i - (isSupportHeaderItem() ? 1 : 0);
    }

    /* access modifiers changed from: protected */
    public boolean isFooterItem(int i) {
        boolean z = false;
        if (!isSupportFooterItem()) {
            return false;
        }
        if (i == getItemCount() - 1) {
            z = true;
        }
        return z;
    }

    /* access modifiers changed from: protected */
    public boolean isHeaderItem(int i) {
        boolean z = false;
        if (!isSupportHeaderItem()) {
            return false;
        }
        if (i == 0) {
            z = true;
        }
        return z;
    }

    public abstract boolean isSupportFooterItem();

    public abstract boolean isSupportHeaderItem();

    public abstract void onBindFooterViewHolder(C1034u uVar, int i);

    public abstract void onBindHeaderViewHolder(C1034u uVar, int i);

    public abstract void onBindItemViewHolder(C1034u uVar, int i);

    public void onBindViewHolder(C1034u uVar, int i) {
        if (isSupportHeaderItem() && i == 0) {
            onBindHeaderViewHolder(uVar, i);
        } else if (!isSupportFooterItem() || i != getItemCount() - 1) {
            onBindItemViewHolder(uVar, i);
        } else {
            onBindFooterViewHolder(uVar, i);
        }
    }

    public abstract C1034u onCreateFooterViewHolder(ViewGroup viewGroup, int i);

    public abstract C1034u onCreateHeaderViewHolder(ViewGroup viewGroup, int i);

    public abstract C1034u onCreateItemViewHolder(ViewGroup viewGroup, int i);

    public C1034u onCreateViewHolder(ViewGroup viewGroup, int i) {
        return (!isSupportHeaderItem() || i != 1) ? (!isSupportFooterItem() || i != 3) ? onCreateItemViewHolder(viewGroup, i) : onCreateFooterViewHolder(viewGroup, i) : onCreateHeaderViewHolder(viewGroup, i);
    }

    public void removeItem(int i) {
        this.mList.remove(getRealItemPosition(i));
        notifyItemRemoved(i);
        if (i != this.mList.size()) {
            notifyItemRangeChanged(i, this.mList.size() - i);
        }
    }

    public void setDataList(List<T> list) {
        this.mList = list;
    }

    public void setItemListener(C4418a aVar) {
        this.mListener = aVar;
    }
}
