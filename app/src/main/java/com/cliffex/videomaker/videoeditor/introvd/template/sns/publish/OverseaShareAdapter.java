package com.introvd.template.sns.publish;

import android.support.p024v7.widget.RecyclerView.C1008a;
import android.support.p024v7.widget.RecyclerView.C1034u;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.introvd.template.sns.OnIconClickListener;
import com.introvd.template.sns.SnsResItem;
import com.introvd.template.sns.SnsShareTypeUtil;
import java.util.ArrayList;
import java.util.List;
import xiaoying.quvideo.com.vivabase.C10122R;

public class OverseaShareAdapter extends C1008a<ShareItemHolder> {
    private List<SnsResItem> mItemInfoList;
    /* access modifiers changed from: private */
    public OnIconClickListener mListener;
    private List<Integer> mShareItem;

    public final class ShareItemHolder extends C1034u {
        /* access modifiers changed from: private */
        public ImageView mImgIcon;
        /* access modifiers changed from: private */
        public TextView mTxtName;

        public ShareItemHolder(View view) {
            super(view);
            this.mImgIcon = (ImageView) view.findViewById(C10122R.C10124id.publish_share_icon_img);
            this.mTxtName = (TextView) view.findViewById(C10122R.C10124id.publish_share_icon_txt);
        }
    }

    public OverseaShareAdapter(List<Integer> list, OnIconClickListener onIconClickListener) {
        this.mShareItem = list;
        this.mListener = onIconClickListener;
        init();
    }

    private void init() {
        if (this.mShareItem != null && !this.mShareItem.isEmpty()) {
            if (this.mItemInfoList == null) {
                this.mItemInfoList = new ArrayList();
            }
            this.mItemInfoList.clear();
            for (int i = 0; i < this.mShareItem.size(); i++) {
                SnsResItem appSnsResItemBySnstype = SnsShareTypeUtil.getAppSnsResItemBySnstype(((Integer) this.mShareItem.get(i)).intValue());
                if (appSnsResItemBySnstype.mSnsType == 1001) {
                    appSnsResItemBySnstype.mTitleResId = C10122R.string.xiaoying_str_studio_save_to_local;
                }
                this.mItemInfoList.add(appSnsResItemBySnstype);
            }
        }
    }

    public int getItemCount() {
        if (this.mItemInfoList != null) {
            return this.mItemInfoList.size();
        }
        return 0;
    }

    public void onBindViewHolder(ShareItemHolder shareItemHolder, int i) {
        final SnsResItem snsResItem = (SnsResItem) this.mItemInfoList.get(i);
        if (snsResItem != null) {
            if (snsResItem.mSnsType == 7) {
                shareItemHolder.mImgIcon.setImageResource(snsResItem.mIconSmallResId);
            } else {
                shareItemHolder.mImgIcon.setImageResource(snsResItem.mIconResId);
            }
            shareItemHolder.mTxtName.setText(snsResItem.mTitleResId);
            shareItemHolder.mImgIcon.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    if (OverseaShareAdapter.this.mListener != null) {
                        OverseaShareAdapter.this.mListener.onIconClick(snsResItem);
                    }
                }
            });
        }
    }

    public ShareItemHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ShareItemHolder(LayoutInflater.from(viewGroup.getContext()).inflate(C10122R.C10126layout.v6_oversea_publish_item, null));
    }
}
