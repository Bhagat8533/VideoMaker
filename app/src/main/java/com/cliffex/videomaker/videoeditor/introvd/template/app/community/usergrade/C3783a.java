package com.introvd.template.app.community.usergrade;

import android.graphics.Color;
import android.support.p024v7.widget.RecyclerView.C1034u;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.introvd.template.R;
import com.introvd.template.app.p199v5.common.C4417b;
import com.quvideo.mobile.component.imageview.DynamicLoadingImageView;

/* renamed from: com.introvd.template.app.community.usergrade.a */
public class C3783a extends C4417b<C3791d> {

    /* renamed from: com.introvd.template.app.community.usergrade.a$a */
    private class C3784a extends C4419b {
        DynamicLoadingImageView bkv;
        TextView bkw;
        TextView bkx;
        TextView titleView;

        public C3784a(View view) {
            super(view);
            this.bkv = (DynamicLoadingImageView) view.findViewById(R.id.img_icon);
            this.bkv.setOval(true);
            this.titleView = (TextView) view.findViewById(R.id.textview_title);
            this.bkw = (TextView) view.findViewById(R.id.textview_content);
            this.bkx = (TextView) view.findViewById(R.id.btn_apply);
            this.titleView.setTextColor(-1);
            this.bkw.setTextColor(Color.parseColor("#ccffffff"));
        }
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
        C3791d dVar = (C3791d) getListItem(i);
        if (dVar != null) {
            C3784a aVar = (C3784a) uVar;
            aVar.bkv.setImageURI(dVar.iconUrl);
            aVar.titleView.setText(dVar.title);
            aVar.bkw.setText(dVar.content);
        }
    }

    public C1034u onCreateFooterViewHolder(ViewGroup viewGroup, int i) {
        return null;
    }

    public C1034u onCreateHeaderViewHolder(ViewGroup viewGroup, int i) {
        return null;
    }

    public C1034u onCreateItemViewHolder(ViewGroup viewGroup, int i) {
        return new C3784a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.user_grade_info_list_item, null));
    }
}
