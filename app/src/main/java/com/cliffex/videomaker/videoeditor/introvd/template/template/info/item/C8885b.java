package com.introvd.template.template.info.item;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.introvd.template.module.iap.C8035c;
import com.introvd.template.module.iap.C8035c.C8038a;
import com.introvd.template.module.iap.C8069n;
import com.introvd.template.p203b.C4583d;
import com.introvd.template.p414ui.view.ProgressWheel;
import com.introvd.template.sdk.model.template.TemplateInfo;
import com.introvd.template.template.R;
import com.introvd.template.template.p407e.C8733e;
import com.introvd.template.template.p407e.C8735f;
import com.introvd.template.template.p407e.C8739i;
import com.quvideo.mobile.component.imageview.DynamicLoadingImageView;
import java.util.HashMap;
import java.util.List;

/* renamed from: com.introvd.template.template.info.item.b */
public class C8885b extends C8898g {
    private C8888a erM = new C8888a();

    /* renamed from: com.introvd.template.template.info.item.b$a */
    class C8888a extends C8903a {
        TextView dIf;
        RelativeLayout eoC;
        TextView eoD;
        View eoE;
        ProgressWheel eoG;
        TextView eqh;
        TextView eqi;
        ImageButton erA;
        TextView erO;
        View erP;
        ImageView erQ;

        C8888a() {
            super();
        }
    }

    public C8885b(Context context, RelativeLayout relativeLayout, String str) {
        super(context);
        this.cFb = str;
        this.mContext = context;
        this.erM.cJe = (RelativeLayout) relativeLayout.findViewById(R.id.item_layout);
        this.erM.dIf = (TextView) relativeLayout.findViewById(R.id.info_list_item_txt_title);
        this.erM.eqi = (TextView) relativeLayout.findViewById(R.id.info_list_item_txt_intro);
        this.erM.erO = (TextView) relativeLayout.findViewById(R.id.info_list_item_txt_total);
        this.erM.cpn = (DynamicLoadingImageView) relativeLayout.findViewById(R.id.info_list_item_img_icon);
        this.erM.epI = (Button) relativeLayout.findViewById(R.id.info_list_item_btn_update);
        this.erM.eoC = (RelativeLayout) relativeLayout.findViewById(R.id.template_iap_button_layout);
        this.erM.eoD = (TextView) relativeLayout.findViewById(R.id.template_iap_present_price);
        this.erM.eoE = relativeLayout.findViewById(R.id.template_iap_icon);
        this.erM.ero = (ImageView) relativeLayout.findViewById(R.id.template_imgview_apply);
        this.erM.epF = (ImageView) relativeLayout.findViewById(R.id.info_list_item_img_mask);
        this.erM.eoG = (ProgressWheel) relativeLayout.findViewById(R.id.template_pack_download_progress);
        this.erM.erA = (ImageButton) relativeLayout.findViewById(R.id.imgbtn_download);
        this.erM.erP = relativeLayout.findViewById(R.id.view_divide);
        this.erM.erQ = (ImageView) relativeLayout.findViewById(R.id.imgview_template_item_sep);
        this.erM.eqh = (TextView) relativeLayout.findViewById(R.id.info_list_item_txt_scene);
        this.erM.cpn.setCornerRadius(C4583d.dpToPixel(context, 2.0f));
    }

    /* renamed from: a */
    public void mo35432a(int i, HashMap<String, Integer> hashMap) {
        super.mo35448a((C8903a) this.erM, i, hashMap);
        List aMe = C8733e.aMa().aMe();
        if (aMe != null && i >= 0 && i < aMe.size()) {
            this.erM.erA.setTag(Integer.valueOf(i));
            this.erM.erA.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    C8885b.this.mHandler.sendMessage(C8885b.this.mHandler.obtainMessage(4098, ((Integer) view.getTag()).intValue(), 0, null));
                }
            });
            TemplateInfo templateInfo = (TemplateInfo) aMe.get(i);
            if (C8739i.m25526qq(templateInfo.ttid)) {
                this.erM.eoC.setTag(Integer.valueOf(i));
                this.erM.eoC.setOnClickListener(new OnClickListener() {
                    public void onClick(View view) {
                        C8885b.this.mHandler.sendMessage(C8885b.this.mHandler.obtainMessage(4098, ((Integer) view.getTag()).intValue(), 0, null));
                    }
                });
            }
            this.erM.dIf.setText(templateInfo.strTitle);
            if (templateInfo.strIntro == null || templateInfo.strIntro.isEmpty()) {
                this.erM.eqi.setVisibility(8);
            } else {
                this.erM.eqi.setVisibility(0);
                this.erM.eqi.setText(templateInfo.strIntro);
            }
            if (templateInfo.strScene != null && !templateInfo.strScene.isEmpty()) {
                this.erM.eqh.setVisibility(0);
                this.erM.eqh.setText(templateInfo.strScene);
            }
            this.erM.erP.setVisibility(0);
            if (i > 0) {
                this.erM.erQ.setVisibility(8);
            } else {
                this.erM.erQ.setVisibility(0);
            }
        }
    }

    /* renamed from: a */
    public void mo35433a(TemplateInfo templateInfo, HashMap<String, Integer> hashMap) {
        super.mo35449a((C8903a) this.erM, templateInfo, hashMap);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo35425a(C8903a aVar, int i) {
        C8888a aVar2 = (C8888a) aVar;
        aVar2.eoG.setVisibility(0);
        aVar2.eoG.setText("");
        aVar2.eoG.setProgress(i);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo35426a(C8903a aVar, TemplateInfo templateInfo) {
        LayoutParams layoutParams = (LayoutParams) aVar.epI.getLayoutParams();
        layoutParams.width = C4583d.dpFloatToPixel(this.mContext, 35.0f);
        layoutParams.height = C4583d.dpFloatToPixel(this.mContext, 35.0f);
        aVar.epI.setLayoutParams(layoutParams);
        aVar.epI.setVisibility(0);
        aVar.ero.setVisibility(4);
        C8888a aVar2 = (C8888a) aVar;
        aVar2.erA.setVisibility(4);
        aVar2.eoG.setVisibility(8);
        if (8 != templateInfo.nState || !C8735f.aMf().mo35137E(templateInfo)) {
            aVar2.eoC.setVisibility(8);
            switch (templateInfo.nState) {
                case 1:
                    if (!C8739i.m25526qq(templateInfo.ttid)) {
                        if (!C8739i.m25527qr(templateInfo.ttid)) {
                            aVar.epI.setVisibility(4);
                            aVar.epI.setBackgroundResource(aLL());
                            aVar2.erA.setVisibility(0);
                            aVar2.eoG.setVisibility(0);
                            aVar2.eoG.setProgress(0);
                            break;
                        } else {
                            aVar.epI.setVisibility(0);
                            aVar.epI.setBackgroundResource(R.drawable.vivavideo_rate_lock1);
                            C8069n.m23425da(aVar.epI);
                            break;
                        }
                    } else {
                        aVar2.eoC.setVisibility(0);
                        C8069n.m23424a(aVar2.eoD, aVar.epI);
                        break;
                    }
                case 2:
                    aVar.epI.setBackgroundResource(R.drawable.xiaoying_com_template_btn_delete);
                    break;
                case 3:
                    mo35447a(aVar);
                    aVar2.eoG.setVisibility(8);
                    aVar2.eoG.setProgress(0);
                    aVar2.eoG.setText("");
                    break;
                case 4:
                    aVar.epI.setBackgroundResource(R.drawable.v4_xiaoying_com_template_btn_download_selector);
                    break;
                case 5:
                    aVar.epI.setBackgroundResource(R.drawable.xiaoying_com_template_btn_delete);
                    aVar.epI.setEnabled(false);
                    break;
                case 6:
                    aVar.epI.setVisibility(0);
                    aVar2.eoG.setVisibility(4);
                    super.mo35447a(aVar);
                    aVar2.eoG.setVisibility(8);
                    break;
                case 8:
                    aVar.epI.setVisibility(4);
                    aVar2.eoG.setVisibility(0);
                    break;
            }
            if (this.mContext instanceof Activity) {
                C8038a aVar3 = new C8038a();
                aVar3.mo33056rY(37).mo33054cY(aVar2.eoC).mo33053a(aVar.epI).mo33055cZ(aVar2.eoE).mo33062se(R.drawable.v5_xiaoying_template_encourage_btn).mo33058sa(this.mContext.getResources().getColor(R.color.color_f0f0f0)).mo33057rZ(R.drawable.v5_xiaoying_iap_template_purchase_diable_bg);
                C8035c.m23245a((Activity) this.mContext, templateInfo.ttid, aVar2.eoD, aVar3);
            }
            return;
        }
        aVar2.eoG.setProgress(10);
        aVar2.eoG.setText("");
        aVar2.eoG.setVisibility(0);
        aVar.epI.setVisibility(8);
    }

    /* access modifiers changed from: protected */
    public int aLL() {
        return R.drawable.v5_xiaoying_ve_preview_music_download;
    }

    /* access modifiers changed from: protected */
    public int aLN() {
        return R.drawable.template_item_btn_bg;
    }

    /* access modifiers changed from: protected */
    public int aLO() {
        return R.drawable.v5_xiaoying_com_template_btn_done;
    }
}
