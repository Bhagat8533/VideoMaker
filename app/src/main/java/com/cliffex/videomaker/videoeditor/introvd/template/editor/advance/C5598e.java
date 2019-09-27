package com.introvd.template.editor.advance;

import android.content.Context;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import com.introvd.template.common.imageloader.ImageLoader;
import com.introvd.template.editor.R;
import com.introvd.template.p375r.p376a.C8360a;
import com.introvd.template.p375r.p376a.C8360a.C8363b;
import com.introvd.template.template.model.StyleCatItemModel;
import com.quvideo.mobile.component.imageview.DynamicLoadingImageView;
import java.util.List;

/* renamed from: com.introvd.template.editor.advance.e */
public class C5598e extends C8360a<StyleCatItemModel> {
    private Context bbr;
    private int brU = 0;
    private int cvc = 0;

    public C5598e(Context context, List<StyleCatItemModel> list) {
        super(context, list);
        mo33622uD(R.layout.v4_xiaoying_ve_subtitle_pick_cover_style_categ_item_layout);
        this.bbr = context;
        this.brU = this.bbr.getResources().getColor(R.color.white_p10);
        this.cvc = this.bbr.getResources().getColor(R.color.transparent);
    }

    /* renamed from: a */
    public void mo27530a(C8363b bVar, int i) {
        StyleCatItemModel styleCatItemModel = (StyleCatItemModel) this.mItemInfoList.get(i);
        if (styleCatItemModel != null) {
            RelativeLayout relativeLayout = (RelativeLayout) bVar.mo33625n(R.id.item_layout);
            DynamicLoadingImageView dynamicLoadingImageView = (DynamicLoadingImageView) bVar.mo33625n(R.id.item_icon);
            String str = styleCatItemModel.strPath;
            if ("Giphy".equals(styleCatItemModel.ttid)) {
                dynamicLoadingImageView.setImage(R.drawable.xiaoying_ve_edit_cover_gif);
            } else if (!TextUtils.isEmpty(str)) {
                ImageLoader.loadImage(str, dynamicLoadingImageView);
            } else {
                dynamicLoadingImageView.setImage(R.drawable.xiaoying_com_loading_icon);
            }
            if (ajC() == i) {
                relativeLayout.setBackgroundColor(this.brU);
            } else {
                relativeLayout.setBackgroundColor(this.cvc);
            }
        }
    }
}
