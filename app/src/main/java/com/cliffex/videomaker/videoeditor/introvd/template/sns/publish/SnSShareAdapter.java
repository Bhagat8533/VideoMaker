package com.introvd.template.sns.publish;

import android.support.p024v7.widget.RecyclerView.C1008a;
import android.support.p024v7.widget.RecyclerView.C1034u;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.introvd.template.sns.SnsResItem;
import com.introvd.template.sns.SnsShareTypeUtil;
import java.util.ArrayList;
import java.util.List;
import xiaoying.quvideo.com.vivabase.C10122R;

public class SnSShareAdapter extends C1008a<ShareItemViewHolder> {
    private boolean bChinaArea = false;
    private List<SnsResItem> mShareIconList = new ArrayList();
    private List<Integer> mShareItem;

    class ShareItemViewHolder extends C1034u {
        public ImageView mShareIcon;

        public ShareItemViewHolder(View view) {
            super(view);
            this.mShareIcon = (ImageView) view;
        }
    }

    public SnSShareAdapter(List<Integer> list, boolean z) {
        this.mShareItem = list;
        this.bChinaArea = z;
        init();
    }

    private void init() {
        this.mShareIconList.clear();
        for (int i = 0; i < this.mShareItem.size(); i++) {
            this.mShareIconList.add(SnsShareTypeUtil.getAppSnsResItemBySnstype(((Integer) this.mShareItem.get(i)).intValue()));
        }
    }

    public int getItemCount() {
        if (this.mShareItem != null) {
            return this.mShareItem.size();
        }
        return 0;
    }

    public void onBindViewHolder(ShareItemViewHolder shareItemViewHolder, int i) {
        SnsResItem snsResItem = (SnsResItem) this.mShareIconList.get(i);
        if (this.bChinaArea) {
            shareItemViewHolder.mShareIcon.setImageResource(snsResItem.mIconResId);
        }
        shareItemViewHolder.mShareIcon.setTag(Integer.valueOf(i));
    }

    public ShareItemViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ShareItemViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(C10122R.C10126layout.v6_intl_publish_item, null));
    }
}
