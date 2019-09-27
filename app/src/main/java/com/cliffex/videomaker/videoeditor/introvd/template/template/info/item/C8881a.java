package com.introvd.template.template.info.item;

import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.introvd.template.common.Constants;
import com.introvd.template.module.iap.C8035c;
import com.introvd.template.module.iap.C8035c.C8038a;
import com.introvd.template.module.iap.C8069n;
import com.introvd.template.p203b.C4580b;
import com.introvd.template.p203b.C4583d;
import com.introvd.template.p414ui.view.ProgressWheel;
import com.introvd.template.sdk.model.template.TemplateInfo;
import com.introvd.template.sdk.p383c.C8399c;
import com.introvd.template.template.R;
import com.introvd.template.template.p407e.C8733e;
import com.introvd.template.template.p407e.C8735f;
import com.introvd.template.template.p407e.C8739i;
import com.quvideo.mobile.component.imageview.DynamicLoadingImageView;
import java.util.HashMap;
import java.util.List;

/* renamed from: com.introvd.template.template.info.item.a */
public class C8881a extends C8898g {
    public boolean cUr = true;
    private int epE = 4;
    LayoutParams erB;
    private C8884a erF;
    private int erG = 8;
    private int erH = 4;
    private RelativeLayout erI;

    /* renamed from: com.introvd.template.template.info.item.a$a */
    class C8884a extends C8903a {
        TextView dIf;
        RelativeLayout eoC;
        TextView eoD;
        View eoE;
        ProgressWheel eoG;
        RelativeLayout epJ;
        TextView eqi;
        ImageButton erA;
        RelativeLayout erK;
        RelativeLayout erL;
        TextView ery;
        TextView erz;

        C8884a() {
            super();
        }
    }

    public C8881a(Context context, RelativeLayout relativeLayout, boolean z, String str) {
        super(context);
        this.cFb = str;
        this.cUr = z;
        m26108a(context, relativeLayout);
        this.erI = new RelativeLayout(context);
    }

    /* renamed from: a */
    public static void m26107a(Context context, View view, String str) {
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.info_list_item_layout_txt);
        ViewGroup.LayoutParams layoutParams = relativeLayout.getLayoutParams();
        int O = C4583d.m11670O(context, 52);
        if (!C8399c.ecX.equals(str)) {
            O = C4583d.m11670O(context, 32);
        }
        layoutParams.height = O;
        relativeLayout.setLayoutParams(layoutParams);
    }

    /* renamed from: a */
    private void m26108a(Context context, RelativeLayout relativeLayout) {
        this.mContext = context;
        this.erF = new C8884a();
        this.erF.erL = (RelativeLayout) relativeLayout.findViewById(R.id.relative_layout);
        this.erF.cJe = (RelativeLayout) relativeLayout.findViewById(R.id.item_layout);
        this.erF.erK = (RelativeLayout) relativeLayout.findViewById(R.id.item_layout_bg);
        this.erF.dIf = (TextView) relativeLayout.findViewById(R.id.info_list_item_txt_title);
        this.erF.eqi = (TextView) relativeLayout.findViewById(R.id.info_list_item_txt_intro);
        this.erF.ery = (TextView) relativeLayout.findViewById(R.id.info_list_item_billing_state);
        this.erF.cpn = (DynamicLoadingImageView) relativeLayout.findViewById(R.id.template_caption_grid_img_icon);
        this.erF.erz = (TextView) relativeLayout.findViewById(R.id.info_list_item_txt_scene);
        this.erF.epI = (Button) relativeLayout.findViewById(R.id.template_caption_grid_btn_update);
        this.erF.ero = (ImageView) relativeLayout.findViewById(R.id.template_imgview_apply);
        this.erF.epF = (ImageView) relativeLayout.findViewById(R.id.info_list_item_img_mask);
        this.erF.erA = (ImageButton) relativeLayout.findViewById(R.id.imgbtn_download);
        this.erF.eoC = (RelativeLayout) relativeLayout.findViewById(R.id.template_iap_button_layout);
        this.erF.eoD = (TextView) relativeLayout.findViewById(R.id.template_iap_present_price);
        this.erF.eoE = relativeLayout.findViewById(R.id.template_iap_icon);
        this.erF.eoG = (ProgressWheel) relativeLayout.findViewById(R.id.template_pack_download_progress);
        this.erF.epJ = (RelativeLayout) relativeLayout.findViewById(R.id.template_caption_grid_layout_icon);
        this.erF.esi = relativeLayout.findViewById(R.id.info_list_time_limit_flag);
        ViewGroup.LayoutParams layoutParams = this.erF.epJ.getLayoutParams();
        int O = (Constants.getScreenSize().width / 2) - C4583d.m11670O(this.mContext, this.erG + this.erH);
        layoutParams.width = O;
        layoutParams.height = C4583d.m11670O(this.mContext, 4) + O;
        this.erF.epJ.setLayoutParams(layoutParams);
        RelativeLayout relativeLayout2 = (RelativeLayout) this.erF.erK.findViewById(R.id.template_caption_grid_layout_icon2);
        ViewGroup.LayoutParams layoutParams2 = relativeLayout2.getLayoutParams();
        layoutParams2.width = O;
        layoutParams2.height = O + C4583d.m11670O(this.mContext, 4);
        relativeLayout2.setLayoutParams(layoutParams2);
        m26107a(this.mContext, this.erF.erK, this.cFb);
        m26110b(this.mContext, this.erF.cJe, this.cFb);
        int O2 = C4583d.m11670O(this.mContext, 4);
        int O3 = C4583d.m11670O(this.mContext, 2);
        LayoutParams layoutParams3 = (LayoutParams) this.erF.erK.getLayoutParams();
        layoutParams3.width = (Constants.getScreenSize().width / 2) - C4583d.m11670O(this.mContext, this.erH);
        this.erF.erK.setLayoutParams(layoutParams3);
        RelativeLayout relativeLayout3 = (RelativeLayout) this.erF.erK.getParent();
        if (C4580b.m11666qi()) {
            if (this.cUr) {
                relativeLayout3.setPadding(0, O3, O2, 0);
            } else {
                relativeLayout3.setPadding(O2, O3, 0, 0);
            }
        } else if (this.cUr) {
            relativeLayout3.setPadding(O2, O3, 0, 0);
        } else {
            relativeLayout3.setPadding(0, O3, O2, 0);
        }
        this.erF.cJe.setPadding(O2, 0, O2, 0);
        this.erF.cpn.setCornerRadius(C4583d.dpToPixel(context, 2.0f));
    }

    /* renamed from: a */
    private void m26109a(C8884a aVar, String str) {
        if (aVar != null) {
            if (this.erI != null) {
                aVar.erL.removeView(this.erI);
            }
            boolean isNeedToPurchase = C8739i.isNeedToPurchase(str);
            if (aVar.ery != null) {
                aVar.ery.setVisibility(isNeedToPurchase ? 8 : 0);
            }
            if (aVar.erz != null) {
                LayoutParams layoutParams = (LayoutParams) aVar.erz.getLayoutParams();
                if (layoutParams != null) {
                    if (isNeedToPurchase) {
                        layoutParams.addRule(11);
                    } else {
                        layoutParams.addRule(11, 0);
                        layoutParams.addRule(0, R.id.info_list_item_billing_state);
                    }
                }
                aVar.erz.setVisibility(0);
            }
            if (aVar.dIf != null) {
                aVar.dIf.setVisibility(0);
            }
            if (aVar.eqi != null) {
                aVar.eqi.setVisibility(0);
            }
        }
    }

    /* renamed from: b */
    public static void m26110b(Context context, View view, String str) {
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.info_list_item_layout_txts);
        relativeLayout.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
            }
        });
        ViewGroup.LayoutParams layoutParams = relativeLayout.getLayoutParams();
        int O = C4583d.m11670O(context, 60);
        if (!C8399c.ecX.equals(str)) {
            O = C4583d.m11670O(context, 42);
        }
        layoutParams.height = O;
        relativeLayout.setLayoutParams(layoutParams);
    }

    private ViewGroup.LayoutParams getDownloadParam() {
        int dpFloatToPixel = C4583d.dpFloatToPixel(this.mContext, 35.0f);
        LayoutParams layoutParams = new LayoutParams(dpFloatToPixel, dpFloatToPixel);
        if (VERSION.SDK_INT >= 17) {
            layoutParams.setMarginEnd(C4583d.dpFloatToPixel(this.mContext, 0.0f));
        } else {
            layoutParams.rightMargin = C4583d.dpFloatToPixel(this.mContext, 0.0f);
        }
        layoutParams.addRule(15, -1);
        return layoutParams;
    }

    private ViewGroup.LayoutParams getLockParam() {
        if (this.erB == null) {
            int dpFloatToPixel = C4583d.dpFloatToPixel(this.mContext, 35.0f);
            this.erB = new LayoutParams(dpFloatToPixel, dpFloatToPixel);
            this.erB.addRule(15, -1);
        }
        return this.erB;
    }

    /* renamed from: a */
    public void mo35423a(int i, HashMap<String, Integer> hashMap) {
        super.mo35448a((C8903a) this.erF, i, hashMap);
        List aMe = C8733e.aMa().aMe();
        if (aMe != null && i >= 0 && i < aMe.size()) {
            this.erF.erA.setTag(Integer.valueOf(i));
            this.erF.erA.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    C8881a.this.mHandler.sendMessage(C8881a.this.mHandler.obtainMessage(4098, ((Integer) view.getTag()).intValue(), 0, null));
                }
            });
            TemplateInfo templateInfo = (TemplateInfo) aMe.get(i);
            m26109a(this.erF, templateInfo.ttid);
            this.erF.dIf.setText(templateInfo.strTitle);
            if (templateInfo.strIntro == null || templateInfo.strIntro.isEmpty()) {
                this.erF.eqi.setVisibility(8);
            } else {
                this.erF.eqi.setVisibility(0);
                this.erF.eqi.setText(templateInfo.strIntro);
            }
            if (templateInfo.strScene == null || templateInfo.strScene.isEmpty()) {
                this.erF.erz.setVisibility(4);
            } else {
                this.erF.erz.setVisibility(0);
                this.erF.erz.setText(templateInfo.strScene);
            }
        }
    }

    /* renamed from: a */
    public void mo35424a(TemplateInfo templateInfo, HashMap<String, Integer> hashMap) {
        super.mo35449a((C8903a) this.erF, templateInfo, hashMap);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo35425a(C8903a aVar, int i) {
        C8884a aVar2 = (C8884a) aVar;
        aVar2.eoG.setVisibility(0);
        aVar2.eoG.setText("");
        aVar2.eoG.setProgress(i);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo35426a(C8903a aVar, TemplateInfo templateInfo) {
        aVar.epI.setGravity(17);
        aVar.epI.setLayoutParams(getDownloadParam());
        C8884a aVar2 = (C8884a) aVar;
        aVar2.eoG.setVisibility(0);
        aVar2.eoG.setProgress(0);
        aVar.epI.setVisibility(0);
        aVar.ero.setVisibility(4);
        aVar2.erA.setVisibility(4);
        if (8 != templateInfo.nState || !C8735f.aMf().mo35138F(templateInfo)) {
            aVar2.eoC.setVisibility(8);
            int i = templateInfo.nState;
            if (i != 1) {
                if (i == 6) {
                    aVar.epI.setVisibility(0);
                    super.mo35447a(aVar);
                    aVar2.eoG.setVisibility(8);
                } else if (i != 8) {
                    switch (i) {
                        case 3:
                            super.mo35447a(aVar);
                            aVar2.eoG.setVisibility(8);
                            aVar2.eoG.setProgress(0);
                            aVar2.eoG.setText("");
                            break;
                        case 4:
                            aVar.epI.setBackgroundResource(R.drawable.v4_xiaoying_com_template_btn_download_selector);
                            break;
                    }
                } else {
                    aVar.epI.setVisibility(8);
                    aVar2.eoG.setVisibility(0);
                }
            } else if (aLQ() && C8739i.m25526qq(templateInfo.ttid)) {
                aVar.epI.setVisibility(0);
                aVar.epI.setBackgroundResource(R.drawable.xiaoying_theme_material_lock);
                aVar.epI.setLayoutParams(getLockParam());
                aVar2.eoG.setVisibility(0);
            } else if (C8739i.m25527qr(templateInfo.ttid)) {
                aVar.epI.setVisibility(0);
                aVar.epI.setBackgroundResource(R.drawable.vivavideo_rate_lock1);
                C8069n.m23425da(aVar.epI);
                aVar2.eoG.setVisibility(8);
            } else {
                aVar.epI.setVisibility(4);
                aVar.epI.setBackgroundResource(aLL());
                aVar2.erA.setVisibility(0);
                aVar2.eoG.setVisibility(0);
            }
            if (this.mContext instanceof Activity) {
                C8038a aVar3 = new C8038a();
                aVar3.mo33056rY(aLQ() ? 36 : 37).mo33054cY(aVar2.eoC).mo33053a(aVar.epI).mo33055cZ(aVar2.eoE).mo33062se(R.drawable.v5_xiaoying_template_encourage_btn).mo33058sa(this.mContext.getResources().getColor(R.color.color_f0f0f0)).mo33057rZ(R.drawable.v5_xiaoying_iap_template_purchase_diable_bg);
                C8035c.m23245a((Activity) this.mContext, templateInfo.ttid, aVar2.eoD, aVar3);
            }
            return;
        }
        aVar.epI.setVisibility(4);
        aVar2.eoG.setProgress(10);
        aVar2.eoG.setText("");
        aVar2.eoG.setVisibility(0);
        aVar2.erA.setVisibility(4);
    }

    /* access modifiers changed from: protected */
    public int aLL() {
        return R.drawable.v5_xiaoying_ve_preview_music_download;
    }

    /* access modifiers changed from: protected */
    public int aLM() {
        return R.drawable.v5_xiaoying_template_label_new;
    }

    /* access modifiers changed from: protected */
    public int aLN() {
        return R.drawable.template_item_btn_bg;
    }
}
