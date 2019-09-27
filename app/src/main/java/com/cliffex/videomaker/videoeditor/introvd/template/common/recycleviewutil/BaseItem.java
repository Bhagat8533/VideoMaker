package com.introvd.template.common.recycleviewutil;

import android.app.Activity;
import android.content.Context;
import android.view.View;

public abstract class BaseItem<Data> {
    private View itemView;
    private Context mContext;
    private Data mData;

    public BaseItem(Context context) {
        this.mContext = context;
    }

    public BaseItem(Context context, Data data) {
        this.mContext = context;
        this.mData = data;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo26649a(BaseHolder baseHolder, int i) {
        if (!(baseHolder == null || baseHolder.itemView == null)) {
            this.itemView = baseHolder.itemView;
            this.itemView.setTag(this);
        }
        onBindView(baseHolder, i);
    }

    /* access modifiers changed from: protected */
    public final Activity getActivity() {
        if (this.mContext instanceof Activity) {
            return (Activity) this.mContext;
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public final Context getContext() {
        return this.mContext;
    }

    public Data getItemData() {
        return this.mData;
    }

    /* access modifiers changed from: protected */
    public abstract int getLayoutId();

    /* access modifiers changed from: protected */
    public int getSpanSize() {
        return 1;
    }

    public boolean isBindingView() {
        return this.itemView != null && this.itemView.getTag().equals(this);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
    }

    /* access modifiers changed from: protected */
    public abstract void onBindView(BaseHolder baseHolder, int i);
}
