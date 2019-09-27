package com.introvd.template.app.p199v5.videoexplore;

import android.content.Context;
import android.content.Intent;
import android.support.p024v7.widget.RecyclerView.C1034u;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.introvd.template.R;
import com.introvd.template.ads.entity.AdPositionInfoParam;
import com.introvd.template.ads.listener.ViewAdsListener;
import com.introvd.template.app.p199v5.common.C4417b;
import com.introvd.template.common.AppPreferencesSetting;
import com.introvd.template.common.UserBehaviorLog;
import com.introvd.template.common.p236ui.modechooser.ModeItemInfo;
import com.introvd.template.module.p326ad.p327a.C7589a;
import com.introvd.template.module.p326ad.p328b.C7591a;
import com.introvd.template.module.p326ad.p328b.C7592b;
import java.util.HashMap;

/* renamed from: com.introvd.template.app.v5.videoexplore.c */
class C4460c extends C4417b<ModeItemInfo> {
    private View bHE;
    /* access modifiers changed from: private */
    public int bHF = -1;
    private Context context;

    /* renamed from: com.introvd.template.app.v5.videoexplore.c$a */
    private class C4462a extends C1034u {
        public C4462a(View view) {
            super(view);
        }
    }

    C4460c(Context context2) {
        this.context = context2;
        C7589a.m22363h(15, new ViewAdsListener() {
            public void onAdLoaded(AdPositionInfoParam adPositionInfoParam, boolean z, String str) {
                if (z && C4460c.this.bHF >= 0) {
                    C4460c.this.notifyItemChanged(C4460c.this.bHF);
                }
            }
        });
    }

    /* renamed from: ia */
    private View m11303ia(int i) {
        this.bHF = i;
        View adView = C7589a.getAdView(this.context, 15);
        if (!(adView == null || adView == this.bHE)) {
            if (this.bHE != null) {
                AppPreferencesSetting.getInstance().setAppSettingStr("key_ad_show_time_stamp", String.valueOf(System.currentTimeMillis()));
            }
            this.bHE = adView;
            HashMap hashMap = new HashMap();
            String W = C7591a.m22370W(this.bHE.getTag());
            hashMap.put("platform", W);
            UserBehaviorLog.onKVEvent(this.bHE.getContext(), "Ad_Explore_Show", hashMap);
            C7592b.m22379F(this.bHE.getContext(), "Ad_Explore_Show", W);
        }
        return adView;
    }

    /* renamed from: do */
    public void mo24634do(Context context2) {
    }

    public int getItemViewType(int i) {
        int itemViewType = super.getItemViewType(i);
        if (itemViewType == 2) {
            ModeItemInfo modeItemInfo = (ModeItemInfo) getListItem(i);
            if (modeItemInfo != null) {
                return modeItemInfo.isAdvItem() ? 1002 : 1001;
            }
        }
        return itemViewType;
    }

    public boolean isSupportFooterItem() {
        return false;
    }

    public boolean isSupportHeaderItem() {
        return false;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
    }

    public void onBindFooterViewHolder(C1034u uVar, int i) {
    }

    public void onBindHeaderViewHolder(C1034u uVar, int i) {
    }

    public void onBindItemViewHolder(C1034u uVar, int i) {
        ModeItemInfo modeItemInfo = (ModeItemInfo) getListItem(i);
        if (modeItemInfo != null) {
            if (!modeItemInfo.isAdvItem()) {
                VideoExploreCardView videoExploreCardView = (VideoExploreCardView) uVar.itemView;
                if (getRealItemPosition(i) == this.mList.size() - 1) {
                    videoExploreCardView.setDividerViewVisible(false);
                } else {
                    videoExploreCardView.setDividerViewVisible(true);
                }
                C4453b bVar = (C4453b) videoExploreCardView.getTag();
                bVar.mo24617bW(true);
                bVar.mo24616b(videoExploreCardView);
                bVar.mo24615a(modeItemInfo.mVideoInfo);
            } else {
                View ia = m11303ia(i);
                RelativeLayout relativeLayout = (RelativeLayout) uVar.itemView.findViewById(R.id.content_layout);
                if (ia != null) {
                    ((ImageView) uVar.itemView.findViewById(R.id.item_divider)).setVisibility(0);
                    LayoutParams layoutParams = new LayoutParams(-1, -2);
                    ViewGroup viewGroup = (ViewGroup) ia.getParent();
                    if (viewGroup != null) {
                        viewGroup.removeAllViews();
                    }
                    relativeLayout.removeAllViews();
                    relativeLayout.addView(ia, layoutParams);
                } else {
                    ((ImageView) uVar.itemView.findViewById(R.id.item_divider)).setVisibility(8);
                }
            }
        }
    }

    public C1034u onCreateFooterViewHolder(ViewGroup viewGroup, int i) {
        return null;
    }

    public C1034u onCreateHeaderViewHolder(ViewGroup viewGroup, int i) {
        return null;
    }

    public C1034u onCreateItemViewHolder(ViewGroup viewGroup, int i) {
        Context context2 = viewGroup.getContext();
        if (i != 1001) {
            return new C4462a(LayoutInflater.from(context2).inflate(R.layout.v5_video_explore_ad_card_item_layout, null));
        }
        VideoExploreCardView videoExploreCardView = new VideoExploreCardView(context2);
        videoExploreCardView.setTag(new C4453b());
        return new C4462a(videoExploreCardView);
    }
}
