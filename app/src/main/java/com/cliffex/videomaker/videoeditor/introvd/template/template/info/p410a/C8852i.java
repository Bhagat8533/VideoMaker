package com.introvd.template.template.info.p410a;

import android.content.Context;
import android.view.ViewGroup.LayoutParams;
import com.introvd.template.common.Constants;
import com.introvd.template.common.imageloader.ImageLoader;
import com.introvd.template.p203b.C4583d;
import com.introvd.template.p375r.p376a.C8360a;
import com.introvd.template.p375r.p376a.C8360a.C8363b;
import com.introvd.template.sdk.model.template.RollXytInfo;
import com.introvd.template.template.R;
import com.quvideo.mobile.component.imageview.DynamicLoadingImageView;
import java.util.List;

/* renamed from: com.introvd.template.template.info.a.i */
public class C8852i extends C8360a<RollXytInfo> {
    private int bvC = 0;

    public C8852i(Context context, List<RollXytInfo> list) {
        super(context, list);
        mo33622uD(R.layout.v4_xiaoying_template_pack_detail_layout);
        this.bvC = m25963ha(context);
    }

    /* renamed from: ha */
    private static int m25963ha(Context context) {
        return (Constants.getScreenSize().width - C4583d.m11670O(context, 45)) / 4;
    }

    /* renamed from: a */
    public void mo27530a(C8363b bVar, int i) {
        RollXytInfo rollXytInfo = (RollXytInfo) this.mItemInfoList.get(i);
        DynamicLoadingImageView dynamicLoadingImageView = (DynamicLoadingImageView) bVar.mo33625n(R.id.template_pack_item_view);
        LayoutParams layoutParams = bVar.itemView.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LayoutParams(this.bvC, this.bvC);
        } else {
            layoutParams.width = this.bvC;
            layoutParams.height = this.bvC;
        }
        bVar.itemView.setLayoutParams(layoutParams);
        ImageLoader.loadImage(rollXytInfo.mXytIconUrl, dynamicLoadingImageView);
    }
}
