package com.introvd.template.template.info.item;

import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.introvd.template.common.Constants;
import com.introvd.template.common.imageloader.ImageLoader;
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
import com.introvd.template.template.p407e.C8739i;
import com.p131c.p132a.p133a.C2564c;
import com.p131c.p132a.p135c.p136a.C2579b;
import com.p131c.p132a.p135c.p136a.C2579b.C2582a;

public class AnimateFrameItemView extends RelativeLayout {
    private static final int eru = ((Constants.getScreenSize().width - (C4583d.m11671P(10.0f) * 3)) / 2);
    TextView dIf;
    RelativeLayout eoC;
    TextView eoD;
    View eoE;
    ProgressWheel eoG;
    Button epI;
    TextView eqi;
    ImageButton erA;
    LayoutParams erB;
    ImageView ero;
    ImageView erv;
    RelativeLayout erw;
    RelativeLayout erx;
    TextView ery;
    TextView erz;
    private Context mContext;
    private String ttid;

    public AnimateFrameItemView(Context context) {
        this(context, null);
    }

    public AnimateFrameItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AnimateFrameItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        init();
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

    private void init() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.template_animate_frame_item_view_layout, this, true);
        this.erv = (ImageView) inflate.findViewById(R.id.item_cover);
        this.erx = (RelativeLayout) inflate.findViewById(R.id.item_caption_layout);
        this.erw = (RelativeLayout) inflate.findViewById(R.id.content_layout);
        this.dIf = (TextView) inflate.findViewById(R.id.info_list_item_txt_title);
        this.eqi = (TextView) inflate.findViewById(R.id.info_list_item_txt_intro);
        this.epI = (Button) inflate.findViewById(R.id.template_caption_grid_btn_update);
        this.ero = (ImageView) inflate.findViewById(R.id.template_imgview_apply);
        this.erA = (ImageButton) inflate.findViewById(R.id.imgbtn_download);
        this.eoG = (ProgressWheel) inflate.findViewById(R.id.download_progress);
        this.ery = (TextView) inflate.findViewById(R.id.item_billing_state);
        this.erz = (TextView) inflate.findViewById(R.id.item_txt_scene);
        this.eoC = (RelativeLayout) inflate.findViewById(R.id.template_iap_button_layout);
        this.eoD = (TextView) inflate.findViewById(R.id.template_iap_present_price);
        this.eoE = inflate.findViewById(R.id.template_iap_icon);
        ViewGroup.LayoutParams layoutParams = this.erv.getLayoutParams();
        layoutParams.width = eru;
        layoutParams.height = eru;
        this.erv.setLayoutParams(layoutParams);
    }

    /* renamed from: pQ */
    private static boolean m26103pQ(String str) {
        return C8399c.ecX.equals(str);
    }

    /* renamed from: a */
    public void mo35415a(final C8909j jVar, final C8908i iVar) {
        if (jVar.esn == 1) {
            this.erv.setImageResource(R.color.transparent);
            this.erw.setVisibility(4);
            this.erx.setVisibility(8);
            return;
        }
        this.ttid = jVar.ttid;
        this.erw.setVisibility(0);
        C2579b.m7399a(new C2582a<View>() {
            public void onClick(View view) {
                C2564c.m7327dA(view);
                if (iVar != null) {
                    iVar.mo35391pO(jVar.ttid);
                }
            }
        }, this.erA, this.epI, this.ero);
        C2579b.m7399a(new C2582a<View>() {
            public void onClick(View view) {
                if (iVar != null) {
                    iVar.mo35390pN(jVar.ttid);
                }
            }
        }, this.erv);
        aLK();
        this.eoC.setVisibility(8);
        if (!TextUtils.isEmpty(jVar.strIcon)) {
            int P = (Constants.getScreenSize().width - (C4583d.m11671P(10.0f) * 3)) / 2;
            ImageLoader.loadImage(this.mContext, jVar.strIcon, this.erv, P, P);
        }
        this.dIf.setText(jVar.strTitle);
        if (!TextUtils.isEmpty(jVar.strIntro)) {
            this.eqi.setVisibility(0);
            this.eqi.setText(jVar.strIntro);
        } else {
            this.eqi.setVisibility(8);
        }
        boolean isNeedToPurchase = C8739i.isNeedToPurchase(this.ttid);
        if (this.ery != null) {
            this.ery.setVisibility(isNeedToPurchase ? 8 : 0);
        }
        if (!TextUtils.isEmpty(jVar.strScene)) {
            this.erz.setVisibility(0);
            this.erz.setText(jVar.strScene);
        } else {
            this.erz.setVisibility(8);
        }
        if (this.mContext instanceof Activity) {
            C8038a aVar = new C8038a();
            aVar.mo33056rY(m26103pQ(jVar.tcid) ? 36 : 37).mo33054cY(this.eoC).mo33053a(this.epI).mo33055cZ(this.eoE).mo33062se(R.drawable.v5_xiaoying_template_encourage_btn).mo33058sa(this.mContext.getResources().getColor(R.color.color_f0f0f0)).mo33057rZ(R.drawable.v5_xiaoying_iap_template_purchase_diable_bg);
            C8035c.m23245a((Activity) this.mContext, this.ttid, this.eoD, aVar);
        }
    }

    public void aLK() {
        TemplateInfo pz = C8733e.aMa().mo35132pz(this.ttid);
        if (pz != null) {
            this.epI.setGravity(17);
            this.epI.setLayoutParams(getDownloadParam());
            this.ero.setVisibility(4);
            this.erA.setVisibility(4);
            this.eoC.setVisibility(8);
            int i = pz.nState;
            if (i != 1) {
                if (i != 6) {
                    if (i != 8) {
                        switch (i) {
                            case 3:
                                break;
                            case 4:
                                this.epI.setBackgroundResource(R.drawable.v4_xiaoying_com_template_btn_download_selector);
                                break;
                        }
                    } else {
                        this.epI.setVisibility(8);
                        this.eoG.setVisibility(0);
                    }
                }
                this.eoG.setText("");
                this.eoG.setProgress(0);
                this.eoG.setVisibility(8);
                setBtnStatusOffApply();
            } else if (C8399c.ecX.equals(pz.tcid) && C8739i.m25526qq(pz.ttid)) {
                this.epI.setVisibility(0);
                this.epI.setBackgroundResource(R.drawable.xiaoying_theme_material_lock);
                this.epI.setLayoutParams(getLockParam());
                this.eoG.setVisibility(0);
            } else if (C8739i.m25527qr(pz.ttid)) {
                this.epI.setVisibility(0);
                this.epI.setBackgroundResource(R.drawable.vivavideo_rate_lock1);
                C8069n.m23425da(this.epI);
                this.eoG.setVisibility(8);
            } else {
                this.epI.setVisibility(4);
                this.epI.setBackgroundResource(R.drawable.v5_xiaoying_ve_preview_music_download);
                this.erA.setVisibility(0);
                this.eoG.setVisibility(0);
            }
        }
    }

    public void setBtnStatusOffApply() {
        if (C4580b.m11633Sg() || C4580b.m11660eF("en") || this.ero == null) {
            LayoutParams layoutParams = (LayoutParams) this.epI.getLayoutParams();
            layoutParams.width = C4583d.dpFloatToPixel(this.mContext, 40.0f);
            layoutParams.height = C4583d.dpFloatToPixel(this.mContext, 22.0f);
            if (VERSION.SDK_INT >= 17) {
                layoutParams.setMarginEnd(0);
            } else {
                layoutParams.rightMargin = 0;
            }
            this.epI.setLayoutParams(layoutParams);
            this.epI.setVisibility(0);
            if (this.ero != null) {
                this.ero.setVisibility(4);
            }
            this.epI.setText(this.mContext.getResources().getString(R.string.xiaoying_str_template_state_apply));
            this.epI.setTextColor(-1);
            this.epI.setTextSize(2, 12.0f);
            this.epI.setGravity(17);
            this.epI.setBackgroundResource(R.drawable.template_item_btn_bg);
            return;
        }
        this.epI.setVisibility(4);
        if (this.ero != null) {
            this.ero.setVisibility(0);
        }
    }

    /* renamed from: uY */
    public void mo35418uY(int i) {
        if (C8733e.aMa().mo35132pz(this.ttid) != null) {
            this.epI.setVisibility(8);
            this.eoC.setVisibility(8);
            this.ero.setVisibility(4);
            this.erA.setVisibility(4);
            this.eoG.setText("");
            this.eoG.setProgress(i);
            this.eoG.setVisibility(0);
        }
    }
}
