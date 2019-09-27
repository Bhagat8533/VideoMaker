package com.introvd.template.app.setting.sns;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.introvd.template.R;
import com.introvd.template.router.user.SnsAuthServiceProxy;
import com.introvd.template.sns.SnsResItem;
import java.util.ArrayList;

/* renamed from: com.introvd.template.app.setting.sns.a */
public class C4344a extends ArrayAdapter<SnsResItem> {
    /* access modifiers changed from: private */
    public OnClickListener bDF;
    private OnClickListener bDG = new OnClickListener() {
        public void onClick(View view) {
            C4344a.this.bDF.onClick(view);
        }
    };
    private Context bbr;
    private LayoutInflater mInflater;
    private ArrayList<SnsResItem> mItems;

    /* renamed from: com.introvd.template.app.setting.sns.a$a */
    class C4346a {
        public TextView alJ;
        public RelativeLayout bDs;
        public TextView bDt;
        public ImageView bDu;
        public ImageView bDv;

        /* renamed from: pc */
        public ImageView f3399pc;

        C4346a() {
        }
    }

    public C4344a(Context context, ArrayList<SnsResItem> arrayList, OnClickListener onClickListener) {
        super(context, R.layout.v4_setting_bind_sns_list_item, arrayList);
        this.mItems = arrayList;
        this.bbr = context;
        this.mInflater = LayoutInflater.from(context);
        this.bDF = onClickListener;
    }

    public int getCount() {
        if (this.mItems != null) {
            return this.mItems.size();
        }
        return 0;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.mInflater.inflate(R.layout.v4_setting_bind_sns_list_item, null);
            C4346a aVar = new C4346a();
            aVar.bDs = (RelativeLayout) view.findViewById(R.id.setting_bind_sns_list_item_layout_bg);
            aVar.alJ = (TextView) view.findViewById(R.id.setting_bind_sns_list_item_txt_title);
            aVar.f3399pc = (ImageView) view.findViewById(R.id.setting_bind_sns_list_item_icon);
            aVar.bDt = (TextView) view.findViewById(R.id.setting_bind_sns_list_item_btn_txt);
            aVar.bDu = (ImageView) view.findViewById(R.id.item_divider_top);
            aVar.bDv = (ImageView) view.findViewById(R.id.item_divider_bottom);
            view.setTag(aVar);
        }
        SnsResItem snsResItem = (SnsResItem) this.mItems.get(i);
        boolean isAuthed = SnsAuthServiceProxy.isAuthed(snsResItem.mSnsType);
        C4346a aVar2 = (C4346a) view.getTag();
        int i2 = 0;
        boolean z = i == getCount() - 1;
        aVar2.bDv.setVisibility(z ? 0 : 8);
        ImageView imageView = aVar2.bDu;
        if (!z) {
            i2 = 8;
        }
        imageView.setVisibility(i2);
        if (isAuthed) {
            aVar2.alJ.setText(SnsAuthServiceProxy.getScreenNameBySnsType(snsResItem.mSnsType));
        } else {
            aVar2.alJ.setText(snsResItem.mTitleResId);
        }
        if (snsResItem.mSnsType == 1) {
            aVar2.f3399pc.setImageResource(R.drawable.v4_xiaoying_com_sns_icon_sina_weibo_small_s);
        } else {
            aVar2.f3399pc.setImageResource(snsResItem.mIconResId);
        }
        aVar2.f3399pc.setEnabled(isAuthed);
        aVar2.bDt.setBackgroundResource(!isAuthed ? R.drawable.xiaoying_app_setting_sns_bind_btn_bg : R.drawable.drawable_color_transparent);
        int color = this.bbr.getResources().getColor(R.color.color_ff774e);
        int color2 = this.bbr.getResources().getColor(R.color.color_b7b7b7);
        TextView textView = aVar2.bDt;
        if (isAuthed) {
            color = color2;
        }
        textView.setTextColor(color);
        aVar2.bDt.setTag(Integer.valueOf(snsResItem.mSnsType));
        aVar2.bDt.setText(!isAuthed ? R.string.xiaoying_str_community_sns_bind : R.string.xiaoying_str_community_sns_unbind);
        aVar2.bDs.setTag(Integer.valueOf(snsResItem.mSnsType));
        aVar2.bDs.setOnClickListener(this.bDG);
        aVar2.bDt.setOnClickListener(this.bDG);
        return view;
    }
}
