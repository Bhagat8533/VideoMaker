package com.introvd.template.template.info.item;

import android.content.Context;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.introvd.template.template.R;
import com.quvideo.mobile.component.imageview.DynamicLoadingImageView;

/* renamed from: com.introvd.template.template.info.item.e */
public class C8894e extends C8891d {
    private C8895a esb = new C8895a();

    /* renamed from: com.introvd.template.template.info.item.e$a */
    class C8895a extends C8893a {
        RelativeLayout cJe;

        C8895a() {
            super();
        }
    }

    public C8894e(Context context, RelativeLayout relativeLayout) {
        super(context, relativeLayout);
        this.mContext = context;
        this.esb.cJe = (RelativeLayout) relativeLayout.findViewById(R.id.item_layout);
        this.esb.dIf = (TextView) relativeLayout.findViewById(R.id.info_list_item_txt_title);
        this.esb.dJk = (ImageView) relativeLayout.findViewById(R.id.img_delete);
        this.esb.cpn = (DynamicLoadingImageView) relativeLayout.findViewById(R.id.info_list_item_img_icon);
        this.esb.eqh = (TextView) relativeLayout.findViewById(R.id.info_list_item_txt_sence);
        this.esb.eqi = (TextView) relativeLayout.findViewById(R.id.info_list_item_txt_intro);
        this.esb.cpn.setOval(false);
    }

    public void update(int i) {
        super.mo35438a((C8893a) this.esb, i);
    }
}
