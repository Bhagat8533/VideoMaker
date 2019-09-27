package com.introvd.template.editor.effects.nav;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bumptech.glide.load.p118b.C2375i;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.common.imageloader.ImageLoader;
import com.introvd.template.common.recycleviewutil.BaseHolder;
import com.introvd.template.common.recycleviewutil.BaseItem;
import com.introvd.template.editor.R;
import com.introvd.template.sdk.editor.cache.C8441b;
import com.introvd.template.sdk.model.editor.ScaleRotateViewState;
import com.introvd.template.sdk.model.editor.TextBubbleInfo.TextBubble;
import com.introvd.template.sdk.p391g.C8450a;
import com.introvd.template.template.p409g.C8762d;
import com.p131c.p132a.C2570b;
import org.greenrobot.eventbus.C10021c;

/* renamed from: com.introvd.template.editor.effects.nav.c */
public class C6186c extends BaseItem<C8441b> {
    private boolean bRU = false;
    private int cNi;
    private ImageView cNj;
    /* access modifiers changed from: private */
    public int hasCode;

    public C6186c(Context context, C8441b bVar, int i) {
        super(context, bVar);
        this.cNi = (int) context.getResources().getDimension(R.dimen.video_editor_terminator_height);
        this.hasCode = i;
    }

    /* renamed from: fG */
    public void mo29006fG(boolean z) {
        this.bRU = z;
        if (isBindingView()) {
            this.cNj.setVisibility(z ? 0 : 8);
        }
    }

    /* access modifiers changed from: protected */
    public int getLayoutId() {
        return R.layout.editor_effect_item_nav_title;
    }

    /* access modifiers changed from: protected */
    public void onBindView(BaseHolder baseHolder, final int i) {
        C8441b bVar = (C8441b) getItemData();
        if (bVar != null) {
            RelativeLayout relativeLayout = (RelativeLayout) baseHolder.findViewById(R.id.nav_effect_item_layout);
            this.cNj = (ImageView) baseHolder.findViewById(R.id.nav_effect_item_iv_selected);
            ImageView imageView = (ImageView) baseHolder.findViewById(R.id.nav_effect_item_iv);
            TextView textView = (TextView) baseHolder.findViewById(R.id.nav_effect_item_tv);
            if (this.bRU) {
                this.cNj.setVisibility(0);
            } else {
                this.cNj.setVisibility(8);
            }
            textView.setVisibility(8);
            imageView.setVisibility(8);
            if (bVar.aIf().contains("xiaoying/sticker/0x0500000000300001.xyt")) {
                imageView.setVisibility(0);
                imageView.setImageResource(R.drawable.editor_btn_effect_mosaic_pixel);
            } else if (bVar.aIf().contains("xiaoying/sticker/0x0500000000300002.xyt")) {
                imageView.setVisibility(0);
                imageView.setImageResource(R.drawable.editor_btn_effect_mosaic_gaussian);
            } else if (bVar.aIf().contains(".xyt")) {
                if (C8450a.m24466bk(C8762d.aMt().getTemplateID(bVar.aIf()))) {
                    textView.setVisibility(0);
                    ScaleRotateViewState aIg = bVar.aIg();
                    if (!(aIg == null || aIg.mTextBubbleInfo == null)) {
                        TextBubble dftTextBubble = aIg.mTextBubbleInfo.getDftTextBubble();
                        if (dftTextBubble != null) {
                            String str = dftTextBubble.mText;
                            if (!TextUtils.isEmpty(str) && str.length() >= 1) {
                                textView.setText(str.substring(0, 1));
                            }
                        }
                    }
                } else {
                    imageView.setVisibility(0);
                    String aIf = bVar.aIf();
                    int dimension = (int) getContext().getResources().getDimension(R.dimen.video_editor_select_image_item);
                    C2570b.m7336hy(getContext()).mo12209w(new C6184a(aIf, dimension, dimension)).mo12869dX(this.cNi, this.cNi).mo12186g(imageView);
                }
            } else if (bVar.aIf().endsWith("gif")) {
                imageView.setVisibility(0);
                C2570b.m7336hy(getContext()).mo12195aO(bVar.aIf()).mo12868d(C2375i.aDh).aPd().mo12869dX(this.cNi, this.cNi).mo12186g(imageView);
            } else {
                imageView.setVisibility(0);
                ImageLoader.loadImage(getContext(), bVar.aIf(), imageView, this.cNi, this.cNi);
            }
            relativeLayout.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    C10021c.aZH().mo38492aA(new C6185b(C6186c.this.hasCode, i));
                    StringBuilder sb = new StringBuilder();
                    sb.append("hashCode = ");
                    sb.append(C6186c.this.hasCode);
                    sb.append(", Position = ");
                    sb.append(i);
                    LogUtilsV2.m14227d(sb.toString());
                }
            });
        }
    }
}
