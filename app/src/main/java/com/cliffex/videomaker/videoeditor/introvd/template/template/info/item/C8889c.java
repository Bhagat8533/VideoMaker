package com.introvd.template.template.info.item;

import android.content.Context;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.introvd.template.common.Constants;
import com.introvd.template.p203b.C4583d;
import com.introvd.template.sdk.p383c.C8399c;
import com.introvd.template.template.R;
import com.quvideo.mobile.component.imageview.DynamicLoadingImageView;

/* renamed from: com.introvd.template.template.info.item.c */
public class C8889c extends C8891d {
    private boolean cUr = true;
    private int epE = 4;
    private int erG = 8;
    private int erH = 4;
    private C8890a erR;

    /* renamed from: com.introvd.template.template.info.item.c$a */
    class C8890a extends C8893a {
        RelativeLayout epJ;
        RelativeLayout erK;

        C8890a() {
            super();
        }
    }

    public C8889c(Context context, RelativeLayout relativeLayout, boolean z, String str) {
        super(context, relativeLayout);
        this.mContext = context;
        this.cUr = z;
        mo35441pK(str);
        this.erR = new C8890a();
        this.erR.cJe = (RelativeLayout) relativeLayout.findViewById(R.id.item_layout);
        this.erR.erK = (RelativeLayout) relativeLayout.findViewById(R.id.item_layout_bg);
        this.erR.dIf = (TextView) relativeLayout.findViewById(R.id.info_list_item_txt_title);
        this.erR.eqi = (TextView) relativeLayout.findViewById(R.id.info_list_item_txt_intro);
        this.erR.cpn = (DynamicLoadingImageView) relativeLayout.findViewById(R.id.template_caption_grid_img_icon);
        this.erR.eqh = (TextView) relativeLayout.findViewById(R.id.info_list_item_txt_scene);
        this.erR.dJk = (ImageView) relativeLayout.findViewById(R.id.template_caption_grid_btn_update);
        this.erR.epJ = (RelativeLayout) relativeLayout.findViewById(R.id.template_caption_grid_layout_icon);
        LayoutParams layoutParams = this.erR.epJ.getLayoutParams();
        int O = (Constants.getScreenSize().width / 2) - C4583d.m11670O(this.mContext, this.erG + this.erH);
        layoutParams.width = O;
        layoutParams.height = C4583d.m11670O(this.mContext, 4) + O;
        this.erR.epJ.setLayoutParams(layoutParams);
        RelativeLayout relativeLayout2 = (RelativeLayout) this.erR.erK.findViewById(R.id.template_caption_grid_layout_icon2);
        LayoutParams layoutParams2 = relativeLayout2.getLayoutParams();
        layoutParams2.width = O;
        layoutParams2.height = O + C4583d.m11670O(this.mContext, 4);
        relativeLayout2.setLayoutParams(layoutParams2);
        C8881a.m26107a(this.mContext, this.erR.erK, aLP());
        C8881a.m26110b(this.mContext, this.erR.cJe, aLP());
        int O2 = C4583d.m11670O(this.mContext, 4);
        int O3 = C4583d.m11670O(this.mContext, 0);
        int O4 = C4583d.m11670O(this.mContext, 2);
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.erR.erK.getLayoutParams();
        layoutParams3.width = (Constants.getScreenSize().width / 2) - C4583d.m11670O(this.mContext, this.erH);
        this.erR.erK.setLayoutParams(layoutParams3);
        RelativeLayout relativeLayout3 = (RelativeLayout) this.erR.erK.getParent();
        if (this.cUr) {
            relativeLayout3.setPadding(O2, O4, O3, 0);
        } else {
            relativeLayout3.setPadding(O3, O4, O2, 0);
        }
        this.erR.cJe.setPadding(O2, 0, O2, 0);
        this.erR.cpn.setCornerRadius(C4583d.dpToPixel(context, 2.0f));
    }

    public void update(int i) {
        super.mo35438a((C8893a) this.erR, i);
        if (C8399c.ecX.equals(aLP())) {
            this.erR.eqi.setVisibility(0);
        } else {
            this.erR.eqi.setVisibility(8);
        }
    }
}
