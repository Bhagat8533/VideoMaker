package com.introvd.template.app.welcomepage.snsview;

import android.support.p024v7.widget.RecyclerView.C1034u;
import android.support.p024v7.widget.RecyclerView.LayoutParams;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.introvd.template.R;
import com.introvd.template.app.p199v5.common.C4417b;
import com.introvd.template.common.SnsConfigMgr.SnsItemInfo;
import com.introvd.template.p203b.C4583d;

/* renamed from: com.introvd.template.app.welcomepage.snsview.a */
public class C4527a extends C4417b<SnsItemInfo> {
    /* renamed from: ie */
    private int m11440ie(int i) {
        if (i == 28) {
            return R.drawable.vivavideo_personalupload_facebook_n;
        }
        if (i == 25) {
            return R.drawable.vivavideo_result_google_n;
        }
        if (i == 31) {
            return R.drawable.vivavideo_result_instagram_n;
        }
        if (i == 38) {
            return R.drawable.vivavideo_personalupload_line_n;
        }
        if (i == 3) {
            return R.drawable.vivavideo_login_phone_n;
        }
        if (i == 29) {
            return R.drawable.vivavideo_personalupload_twitter_n;
        }
        if (i == 7) {
            return R.drawable.vivavideo_personalupload_wechat;
        }
        if (i == 11) {
            return R.drawable.vivavideo_personalupload_qq;
        }
        if (i == 1) {
            return R.drawable.vivavideo_personalupload_sina;
        }
        return -1;
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

    public void onBindItemViewHolder(C1034u uVar, final int i) {
        ImageView imageView = (ImageView) uVar.itemView;
        SnsItemInfo snsItemInfo = (SnsItemInfo) getListItem(i);
        if (snsItemInfo != null) {
            if (m11440ie(snsItemInfo.mSnsCode) > 0) {
                imageView.setImageResource(m11440ie(snsItemInfo.mSnsCode));
            }
            imageView.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    if (C4527a.this.mListener != null) {
                        C4527a.this.mListener.onItemClicked(i);
                    }
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
        ImageView imageView = new ImageView(viewGroup.getContext());
        int O = C4583d.m11670O(viewGroup.getContext(), 42);
        imageView.setLayoutParams(new LayoutParams(O, O));
        return new C4419b(imageView);
    }
}
