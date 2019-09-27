package com.introvd.template.module.iap.business.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.introvd.template.module.iap.R;
import com.introvd.template.module.iap.business.home.p359b.C7970a;
import com.introvd.template.module.p339c.C7689a;
import com.quvideo.mobile.component.imageview.DynamicLoadingImageView;
import java.util.List;

/* renamed from: com.introvd.template.module.iap.business.home.d */
class C7978d extends BaseAdapter {
    private List<C7970a> bvs;
    private Context context;
    private int dTx;
    private int dTy;

    /* renamed from: com.introvd.template.module.iap.business.home.d$a */
    class C7979a {
        DynamicLoadingImageView bkv;
        ImageView dTA;
        ImageView dTz;
        TextView titleView;

        public C7979a(View view) {
            this.dTz = (ImageView) view.findViewById(R.id.vip_home_help_dialog_flag);
            this.titleView = (TextView) view.findViewById(R.id.vip_home_help_dialog_item_title);
            this.dTA = (ImageView) view.findViewById(R.id.iv_flag_new);
            this.bkv = (DynamicLoadingImageView) view.findViewById(R.id.vip_home_help_dialog_item_icon);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: iL */
        public void mo32961iL(boolean z) {
            this.titleView.setCompoundDrawablePadding(C7689a.m22599ii(5));
            this.dTA.setVisibility(z ? 0 : 8);
        }
    }

    C7978d(Context context2, List<C7970a> list, int i, int i2) {
        this.context = context2;
        this.bvs = list;
        this.dTx = i;
        this.dTy = i2;
    }

    public int getCount() {
        if (this.bvs == null) {
            return 0;
        }
        return this.bvs.size();
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        C7979a aVar;
        C7970a sC = getItem(i);
        if (view == null) {
            view = LayoutInflater.from(this.context).inflate(this.dTx, viewGroup, false);
            aVar = new C7979a(view);
            view.setTag(aVar);
        } else {
            aVar = (C7979a) view.getTag();
        }
        if (sC != null) {
            if (aVar.bkv != null) {
                aVar.bkv.setImage(sC.aDN());
            }
            if (aVar.titleView != null) {
                aVar.titleView.setText(sC.aDO());
            }
            aVar.mo32961iL(sC.aDP());
        }
        if (aVar.dTz != null) {
            aVar.dTz.setImageResource(this.dTy);
        }
        return view;
    }

    /* renamed from: sC */
    public C7970a getItem(int i) {
        if (this.bvs == null) {
            return null;
        }
        return (C7970a) this.bvs.get(i);
    }
}
