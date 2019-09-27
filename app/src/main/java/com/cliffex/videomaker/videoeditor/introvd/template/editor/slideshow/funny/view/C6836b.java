package com.introvd.template.editor.slideshow.funny.view;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.introvd.template.common.recycleviewutil.BaseHolder;
import com.introvd.template.common.recycleviewutil.BaseItem;
import com.introvd.template.editor.R;
import com.introvd.template.editor.slideshow.p278a.C6738a;
import com.introvd.template.router.slide.FunnySlideRouter;
import com.introvd.template.sdk.model.template.TemplateInfo;
import com.p131c.p132a.p135c.p136a.C2579b;
import com.p131c.p132a.p135c.p136a.C2579b.C2582a;
import com.quvideo.mobile.component.imageview.DynamicLoadingImageView;

/* renamed from: com.introvd.template.editor.slideshow.funny.view.b */
public class C6836b extends BaseItem {
    /* access modifiers changed from: private */
    public String dhL;

    public C6836b(Context context, String str, TemplateInfo templateInfo) {
        super(context, templateInfo);
        this.dhL = str;
    }

    /* access modifiers changed from: protected */
    public int getLayoutId() {
        return R.layout.editor_funny_template_info_rec_item;
    }

    /* access modifiers changed from: protected */
    public int getSpanSize() {
        return 1;
    }

    /* access modifiers changed from: protected */
    public void onBindView(BaseHolder baseHolder, int i) {
        TextView textView = (TextView) baseHolder.findViewById(R.id.funny_template_tag_tv);
        TextView textView2 = (TextView) baseHolder.findViewById(R.id.funny_template_name_tv);
        DynamicLoadingImageView dynamicLoadingImageView = (DynamicLoadingImageView) baseHolder.findViewById(R.id.funny_template_img);
        final TemplateInfo templateInfo = (TemplateInfo) getItemData();
        textView.setText(templateInfo.strScene);
        textView2.setText(templateInfo.strTitle);
        dynamicLoadingImageView.setImageURI(templateInfo.strIcon);
        C2579b.m7399a(new C2582a<View>() {
            public void onClick(View view) {
                C6738a.m19558bK(C6836b.this.getActivity(), templateInfo.ttid);
                if (C6836b.this.getActivity() != null) {
                    FunnySlideRouter.launchTemplateDetail(C6836b.this.getActivity(), C6836b.this.dhL, templateInfo.ttid);
                }
            }
        }, dynamicLoadingImageView);
    }
}
