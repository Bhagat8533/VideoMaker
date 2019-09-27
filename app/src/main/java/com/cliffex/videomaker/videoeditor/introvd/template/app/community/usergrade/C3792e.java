package com.introvd.template.app.community.usergrade;

import android.support.p024v7.widget.RecyclerView.C1034u;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.introvd.template.R;
import com.introvd.template.app.p199v5.common.C4417b;
import com.introvd.template.module.iap.C8072q;
import com.quvideo.mobile.component.imageview.DynamicLoadingImageView;

/* renamed from: com.introvd.template.app.community.usergrade.e */
public class C3792e extends C4417b<C3791d> {
    private View bkQ;

    /* renamed from: com.introvd.template.app.community.usergrade.e$a */
    private class C3793a extends C4419b {
        DynamicLoadingImageView bkv;
        TextView bkw;
        TextView titleView;

        public C3793a(View view) {
            super(view);
            this.bkv = (DynamicLoadingImageView) view.findViewById(R.id.img_icon);
            this.bkv.setOval(true);
            this.titleView = (TextView) view.findViewById(R.id.textview_title);
            this.bkw = (TextView) view.findViewById(R.id.textview_content);
        }
    }

    /* renamed from: bG */
    public void mo23273bG(View view) {
        this.bkQ = view;
    }

    public View getHeaderView() {
        return this.bkQ;
    }

    public boolean isSupportFooterItem() {
        return false;
    }

    public boolean isSupportHeaderItem() {
        return this.bkQ != null;
    }

    public void onBindFooterViewHolder(C1034u uVar, int i) {
    }

    public void onBindHeaderViewHolder(C1034u uVar, int i) {
    }

    public void onBindItemViewHolder(C1034u uVar, int i) {
        C3791d dVar = (C3791d) getListItem(i);
        if (dVar != null) {
            C3793a aVar = (C3793a) uVar;
            aVar.titleView.setText(dVar.title);
            aVar.bkw.setText(dVar.content);
            if (C8072q.aBx().isVip()) {
                aVar.bkv.setImageURI(dVar.iconUrl);
            } else {
                aVar.bkv.setImageURI(dVar.bkL);
            }
        }
    }

    public C1034u onCreateFooterViewHolder(ViewGroup viewGroup, int i) {
        return null;
    }

    public C1034u onCreateHeaderViewHolder(ViewGroup viewGroup, int i) {
        return new C4419b(this.bkQ);
    }

    public C1034u onCreateItemViewHolder(ViewGroup viewGroup, int i) {
        return new C3793a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.user_grade_info_list_item, null));
    }
}
