package com.introvd.template.template.info.item;

import android.content.Context;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.introvd.template.common.Constants;
import com.introvd.template.p203b.C4583d;
import com.introvd.template.sdk.model.template.TemplateInfo;
import com.introvd.template.template.R;
import com.quvideo.mobile.component.imageview.DynamicLoadingImageView;
import java.util.HashMap;

/* renamed from: com.introvd.template.template.info.item.f */
public class C8896f extends C8898g {
    private int epE = 14;
    private C8897a esd;

    /* renamed from: com.introvd.template.template.info.item.f$a */
    class C8897a extends C8903a {
        RelativeLayout epJ;
        ProgressBar ese;

        C8897a() {
            super();
        }
    }

    public C8896f(Context context, RelativeLayout relativeLayout) {
        super(context);
        this.mContext = context;
        this.esd = new C8897a();
        this.esd.cJe = (RelativeLayout) relativeLayout.findViewById(R.id.item_layout);
        this.esd.cpn = (DynamicLoadingImageView) relativeLayout.findViewById(R.id.template_caption_grid_img_icon);
        this.esd.epI = (Button) relativeLayout.findViewById(R.id.template_caption_grid_btn_update);
        this.esd.epF = (ImageView) relativeLayout.findViewById(R.id.info_list_item_img_mask);
        this.esd.epJ = (RelativeLayout) relativeLayout.findViewById(R.id.template_caption_grid_layout_icon);
        this.esd.ese = (ProgressBar) relativeLayout.findViewById(R.id.progressbar_loading);
        LayoutParams layoutParams = this.esd.epJ.getLayoutParams();
        int O = (Constants.getScreenSize().width / 3) - C4583d.m11670O(this.mContext, this.epE);
        layoutParams.width = O;
        layoutParams.height = O;
        this.esd.epJ.setLayoutParams(layoutParams);
        this.esd.cpn.setCornerRadius(C4583d.dpToPixel(context, 4.0f));
    }

    /* renamed from: a */
    public void mo35445a(int i, HashMap<String, Integer> hashMap) {
        super.mo35448a((C8903a) this.esd, i, hashMap);
    }

    /* renamed from: a */
    public void mo35446a(TemplateInfo templateInfo, HashMap<String, Integer> hashMap) {
        super.mo35449a((C8903a) this.esd, templateInfo, hashMap);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo35425a(C8903a aVar, int i) {
        ((C8897a) aVar).ese.setProgress(i);
        Button button = aVar.epI;
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        sb.append("%");
        button.setText(sb.toString());
    }

    /* renamed from: a */
    public void mo35426a(C8903a aVar, TemplateInfo templateInfo) {
        int i = templateInfo.nState;
        if (i != 1) {
            if (i != 3) {
                switch (i) {
                    case 6:
                        break;
                    case 8:
                        aVar.epI.setVisibility(0);
                        aVar.epI.setBackgroundResource(R.drawable.drawable_color_transparent);
                        return;
                    default:
                        return;
                }
            }
            aVar.epI.setVisibility(0);
            aVar.epI.setBackgroundResource(R.drawable.editor_selector_giphy_btn_blue_bg);
            aVar.epI.setText(R.string.xiaoying_str_template_state_apply);
            ((C8897a) aVar).ese.setProgress(0);
            return;
        }
        aVar.epI.setVisibility(0);
        aVar.epI.setBackgroundResource(R.drawable.v5_xiaoying_template_btn_yellow_selector);
        aVar.epI.setText(R.string.xiaoying_str_template_state_download);
        ((C8897a) aVar).ese.setProgress(0);
    }
}
