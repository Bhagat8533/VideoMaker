package com.introvd.template.template.info.p410a;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.introvd.template.common.LogUtils;
import com.introvd.template.common.imageloader.ImageLoader;
import com.introvd.template.sdk.model.template.RollInfo;
import com.introvd.template.template.R;
import com.introvd.template.template.widget.GroupHeader;
import com.quvideo.mobile.component.imageview.DynamicLoadingImageView;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.introvd.template.template.info.a.g */
public class C8845g extends BaseAdapter {
    private List<RollInfo> eqe = new ArrayList();
    private Context mContext;
    /* access modifiers changed from: private */
    public Handler mHandler;

    /* renamed from: pX */
    private LayoutInflater f3612pX;

    /* renamed from: com.introvd.template.template.info.a.g$a */
    class C8847a {
        RelativeLayout cJe;
        DynamicLoadingImageView cpn;
        TextView dIf;
        ImageView dJk;
        RelativeLayout epp;
        RelativeLayout epq;
        LinearLayout epr;
        RelativeLayout eps;
        ImageView epw;
        ImageView epx;
        GroupHeader eqg;
        TextView eqh;
        TextView eqi;

        C8847a() {
        }
    }

    public C8845g(Context context) {
        this.mContext = context;
        this.f3612pX = LayoutInflater.from(context);
    }

    /* renamed from: a */
    private void m25957a(C8847a aVar, final int i) {
        RollInfo rollInfo = (RollInfo) getItem(i);
        if (rollInfo != null) {
            if (!TextUtils.isEmpty(rollInfo.strIcon)) {
                ImageLoader.loadImage(rollInfo.strIcon, aVar.cpn);
            }
            aVar.dIf.setText(rollInfo.strTitle);
            if (!TextUtils.isEmpty(rollInfo.strIntro)) {
                aVar.eqi.setVisibility(0);
                aVar.eqi.setText(rollInfo.strIntro);
            } else {
                aVar.eqi.setVisibility(8);
            }
        }
        aVar.dJk.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                C8845g.this.mHandler.sendMessage(C8845g.this.mHandler.obtainMessage(36872, i, 0, null));
            }
        });
    }

    /* renamed from: cV */
    public void mo35361cV(List<RollInfo> list) {
        LogUtils.m14223i("GroupGridAdapter", "doNotifyDataSetChanged <--");
        this.eqe = list;
        super.notifyDataSetChanged();
        LogUtils.m14223i("GroupGridAdapter", "doNotifyDataSetChanged -->");
    }

    public int getCount() {
        if (this.eqe != null) {
            return this.eqe.size();
        }
        return 0;
    }

    public Object getItem(int i) {
        return this.eqe.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        C8847a aVar;
        if (view == null) {
            view = this.f3612pX.inflate(R.layout.template_mgr_item_layout, null);
            aVar = new C8847a();
            aVar.eqg = (GroupHeader) view.findViewById(R.id.clip_title);
            aVar.eqg.setHandler(this.mHandler);
            aVar.epr = (LinearLayout) view.findViewById(R.id.gridview);
            aVar.epp = (RelativeLayout) view.findViewById(R.id.clip_layout01);
            aVar.epq = (RelativeLayout) view.findViewById(R.id.clip_layout02);
            aVar.epw = (ImageView) view.findViewById(R.id.top_layout);
            aVar.epx = (ImageView) view.findViewById(R.id.bottom_layout);
            aVar.eps = (RelativeLayout) view.findViewById(R.id.listiew);
            aVar.cJe = (RelativeLayout) aVar.eps.findViewById(R.id.item_layout);
            aVar.dIf = (TextView) aVar.eps.findViewById(R.id.info_list_item_txt_title);
            aVar.dJk = (ImageView) aVar.eps.findViewById(R.id.img_delete);
            aVar.cpn = (DynamicLoadingImageView) aVar.eps.findViewById(R.id.info_list_item_img_icon);
            aVar.eqh = (TextView) aVar.eps.findViewById(R.id.info_list_item_txt_sence);
            aVar.eqi = (TextView) aVar.eps.findViewById(R.id.info_list_item_txt_intro);
            view.setTag(aVar);
        } else {
            aVar = (C8847a) view.getTag();
        }
        aVar.epr.setVisibility(8);
        aVar.eps.setVisibility(0);
        m25957a(aVar, i);
        return view;
    }

    public void setHandler(Handler handler) {
        this.mHandler = handler;
    }
}
