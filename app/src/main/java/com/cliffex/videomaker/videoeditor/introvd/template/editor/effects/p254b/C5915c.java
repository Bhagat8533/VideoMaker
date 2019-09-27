package com.introvd.template.editor.effects.p254b;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.introvd.template.common.imageloader.ImageLoader;
import com.introvd.template.common.recycleviewutil.BaseHolder;
import com.introvd.template.common.recycleviewutil.BaseItem;
import com.introvd.template.editor.R;
import com.introvd.template.editor.effects.nav.C6184a;
import com.introvd.template.router.editor.EditorModes;
import com.introvd.template.sdk.editor.cache.C8441b;
import com.introvd.template.sdk.model.editor.ScaleRotateViewState;
import com.introvd.template.template.p409g.C8762d;
import com.p131c.p132a.C2570b;
import com.quvideo.mobile.component.imageview.DynamicLoadingImageView;

/* renamed from: com.introvd.template.editor.effects.b.c */
public class C5915c extends BaseItem<C8441b> {
    /* access modifiers changed from: private */
    public C5911a cNS;
    private int cNi;
    private int mExampleThumbPos;
    private String mStylePath;

    public C5915c(Context context, C8441b bVar) {
        super(context, bVar);
        this.cNi = (int) context.getResources().getDimension(R.dimen.video_editor_select_image_item);
    }

    /* renamed from: a */
    public void mo28522a(C5911a aVar) {
        this.cNS = aVar;
    }

    /* access modifiers changed from: protected */
    public int getLayoutId() {
        return R.layout.editor_effect_select_recycle_image_item;
    }

    /* access modifiers changed from: protected */
    public int getSpanSize() {
        return 1;
    }

    /* access modifiers changed from: protected */
    public void onBindView(BaseHolder baseHolder, int i) {
        final C8441b bVar = (C8441b) getItemData();
        if (bVar != null && (bVar.aIg() != null || bVar.groupId == 6)) {
            DynamicLoadingImageView dynamicLoadingImageView = (DynamicLoadingImageView) baseHolder.findViewById(R.id.select_item);
            if (bVar.aIf().contains("xiaoying/sticker/0x0500000000300001.xyt")) {
                dynamicLoadingImageView.setVisibility(0);
                dynamicLoadingImageView.setImageResource(R.drawable.editor_btn_effect_mosaic_pixel_big);
            } else if (bVar.aIf().contains("xiaoying/sticker/0x0500000000300002.xyt")) {
                dynamicLoadingImageView.setVisibility(0);
                dynamicLoadingImageView.setImageResource(R.drawable.editor_btn_effect_mosaic_gaussian_big);
            } else if (bVar.aIf().contains(".xyt")) {
                ScaleRotateViewState aIg = bVar.aIg();
                if (aIg != null) {
                    this.mStylePath = aIg.mStylePath;
                    this.mExampleThumbPos = aIg.mExampleThumbPos;
                } else {
                    this.mStylePath = bVar.aIf();
                    this.mExampleThumbPos = 0;
                }
                String templateExternalFile = C8762d.aMt().getTemplateExternalFile(C8762d.aMt().getTemplateID(this.mStylePath), 0, 3);
                if (!TextUtils.isEmpty(templateExternalFile)) {
                    dynamicLoadingImageView.setFailureImage(R.mipmap.ic_launcher);
                    ImageLoader.loadImage(templateExternalFile, dynamicLoadingImageView);
                } else {
                    C2570b.m7336hy(getContext()).mo12209w(new C6184a(this.mStylePath, this.cNi, this.cNi)).mo12869dX(this.cNi, this.cNi).mo12186g(dynamicLoadingImageView);
                }
            } else {
                ImageLoader.loadImage(getContext(), bVar.aIg().mStylePath, (ImageView) dynamicLoadingImageView, this.cNi, this.cNi);
            }
            dynamicLoadingImageView.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    if (C5915c.this.cNS != null) {
                        int i = 0;
                        int i2 = bVar.groupId;
                        if (i2 == 20) {
                            i = 2001;
                        } else if (i2 == 8) {
                            i = 2003;
                        } else if (i2 == 6) {
                            i = 2004;
                        } else if (i2 == 40) {
                            i = EditorModes.EFFECT_MOSAIC_MODE;
                        }
                        C5915c.this.cNS.mo28516cB(i, bVar.aId());
                    }
                }
            });
        }
    }
}
