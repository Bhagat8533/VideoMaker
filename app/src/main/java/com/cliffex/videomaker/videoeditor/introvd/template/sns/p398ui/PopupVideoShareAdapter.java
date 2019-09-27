package com.introvd.template.sns.p398ui;

import android.support.p024v7.widget.RecyclerView.C1034u;
import android.support.p024v7.widget.RecyclerView.LayoutParams;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.introvd.template.app.p199v5.common.C4417b;
import com.introvd.template.common.Constants;
import com.introvd.template.router.sns.MyResolveInfo;
import com.introvd.template.sns.biz.C8582R;

/* renamed from: com.introvd.template.sns.ui.PopupVideoShareAdapter */
class PopupVideoShareAdapter extends C4417b<MyResolveInfo> {
    private int padding = 0;

    /* renamed from: com.introvd.template.sns.ui.PopupVideoShareAdapter$ItemViewHolder */
    private class ItemViewHolder extends C1034u {
        /* access modifiers changed from: private */
        public ImageView mIcon;
        /* access modifiers changed from: private */
        public TextView mTxt;
        /* access modifiers changed from: private */
        public RelativeLayout rootView;

        public ItemViewHolder(View view) {
            super(view);
            this.rootView = (RelativeLayout) view.findViewById(C8582R.C8584id.root_layout);
            this.mIcon = (ImageView) view.findViewById(C8582R.C8584id.img_icon);
            this.mTxt = (TextView) view.findViewById(C8582R.C8584id.tv_text);
        }
    }

    public PopupVideoShareAdapter(int i) {
        this.padding = i;
    }

    public boolean isSupportFooterItem() {
        return false;
    }

    public boolean isSupportHeaderItem() {
        return false;
    }

    public void onBindFooterViewHolder(C1034u uVar, int i) {
    }

    public void onBindHeaderViewHolder(C1034u uVar, int i) {
    }

    public void onBindItemViewHolder(C1034u uVar, int i) {
        ItemViewHolder itemViewHolder = (ItemViewHolder) uVar;
        final int realItemPosition = getRealItemPosition(i);
        MyResolveInfo myResolveInfo = (MyResolveInfo) getListItem(realItemPosition);
        if (myResolveInfo != null) {
            itemViewHolder.mIcon.setImageResource(myResolveInfo.iconResId);
            itemViewHolder.mTxt.setText(myResolveInfo.label);
            itemViewHolder.rootView.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    PopupVideoShareAdapter.this.mListener.onItemClicked(realItemPosition);
                }
            });
        }
    }

    public C1034u onCreateFooterViewHolder(ViewGroup viewGroup, int i) {
        return null;
    }

    public C1034u onCreateHeaderViewHolder(ViewGroup viewGroup, int i) {
        return null;
    }

    public C1034u onCreateItemViewHolder(ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(C8582R.C8586layout.sns_popup_item_video_share, viewGroup, false);
        inflate.setLayoutParams(new LayoutParams((Constants.getScreenSize().width - (this.padding * 2)) / 4, -2));
        return new ItemViewHolder(inflate);
    }
}
