package com.introvd.template.template.info.item;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.introvd.template.p203b.C4580b;
import com.introvd.template.p203b.C4583d;
import com.introvd.template.p414ui.view.ProgressWheel;
import com.introvd.template.sdk.model.template.TemplateInfo;
import com.introvd.template.template.R;
import com.introvd.template.template.p407e.C8733e;
import com.introvd.template.template.p408f.C8757g;
import com.quvideo.mobile.component.imageview.DynamicLoadingImageView;
import java.util.HashMap;
import java.util.List;

/* renamed from: com.introvd.template.template.info.item.h */
public class C8904h extends C8898g {
    private C8907a esj = new C8907a();

    /* renamed from: com.introvd.template.template.info.item.h$a */
    class C8907a extends C8903a {
        TextView dIf;
        Button eqV;
        TextView eqi;
        TextView erO;
        TextView erz;
        ProgressWheel esl;

        C8907a() {
            super();
        }
    }

    public C8904h(Context context, RelativeLayout relativeLayout) {
        super(context);
        this.mContext = context;
        this.esj.cJe = (RelativeLayout) relativeLayout.findViewById(R.id.item_layout);
        this.esj.dIf = (TextView) relativeLayout.findViewById(R.id.info_list_item_txt_title);
        this.esj.eqi = (TextView) relativeLayout.findViewById(R.id.info_list_item_txt_intro);
        this.esj.erO = (TextView) relativeLayout.findViewById(R.id.info_list_item_txt_total);
        this.esj.cpn = (DynamicLoadingImageView) relativeLayout.findViewById(R.id.info_list_item_img_icon);
        this.esj.epI = (Button) relativeLayout.findViewById(R.id.info_list_item_btn_update);
        this.esj.ero = (ImageView) relativeLayout.findViewById(R.id.template_imgview_apply);
        this.esj.epF = (ImageView) relativeLayout.findViewById(R.id.info_list_item_img_mask);
        this.esj.erz = (TextView) relativeLayout.findViewById(R.id.info_list_item_txt_scene);
        this.esj.esl = (ProgressWheel) relativeLayout.findViewById(R.id.template_pack_download_progress);
        this.esj.eqV = (Button) relativeLayout.findViewById(R.id.info_list_item_btn_apply);
        this.esj.cpn.setCornerRadius(C4583d.dpToPixel(context, 4.0f));
    }

    /* renamed from: a */
    public void mo35457a(int i, HashMap<String, Integer> hashMap) {
        super.mo35448a((C8903a) this.esj, i, hashMap);
        List aMe = C8733e.aMa().aMe();
        if (aMe != null && i >= 0 && i < aMe.size()) {
            TemplateInfo templateInfo = (TemplateInfo) aMe.get(i);
            this.esj.dIf.setText(templateInfo.strTitle);
            if (templateInfo.strIntro == null || templateInfo.strIntro.isEmpty()) {
                this.esj.eqi.setVisibility(8);
            } else {
                this.esj.eqi.setText(templateInfo.strIntro);
                this.esj.eqi.setVisibility(0);
            }
            if (templateInfo.strScene == null || templateInfo.strScene.isEmpty()) {
                this.esj.erz.setVisibility(4);
            } else {
                this.esj.erz.setVisibility(4);
                this.esj.erz.setText(templateInfo.strScene);
            }
            this.esj.epI.setTag(Integer.valueOf(i));
            this.esj.eqV.setTag(Integer.valueOf(i));
            this.esj.eqV.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    C8904h.this.mHandler.sendMessage(C8904h.this.mHandler.obtainMessage(4098, ((Integer) view.getTag()).intValue(), 0, null));
                }
            });
            if (this.esj.ero != null) {
                this.esj.ero.setTag(Integer.valueOf(i));
                this.esj.ero.setOnClickListener(new OnClickListener() {
                    public void onClick(View view) {
                        C8904h.this.mHandler.sendMessage(C8904h.this.mHandler.obtainMessage(4098, ((Integer) view.getTag()).intValue(), 0, null));
                    }
                });
            }
        }
    }

    /* renamed from: a */
    public void mo35458a(TemplateInfo templateInfo, HashMap<String, Integer> hashMap) {
        super.mo35449a((C8903a) this.esj, templateInfo, hashMap);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo35425a(C8903a aVar, int i) {
        C8907a aVar2 = (C8907a) aVar;
        aVar2.esl.setVisibility(0);
        aVar2.esl.setProgress(i);
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
                        aVar.epI.setVisibility(4);
                        C8907a aVar2 = (C8907a) aVar;
                        aVar2.eqV.setVisibility(4);
                        aVar.ero.setVisibility(4);
                        aVar2.esl.setVisibility(0);
                        return;
                    default:
                        return;
                }
            }
            aVar.epI.setVisibility(4);
            if (C4580b.m11633Sg() || C8757g.aMp()) {
                ((C8907a) aVar).eqV.setVisibility(0);
                aVar.ero.setVisibility(4);
            } else {
                aVar.ero.setVisibility(0);
                ((C8907a) aVar).eqV.setVisibility(4);
            }
            C8907a aVar3 = (C8907a) aVar;
            aVar3.esl.setVisibility(4);
            aVar3.esl.setProgress(0);
            aVar3.esl.setText("");
            return;
        }
        aVar.epI.setVisibility(0);
        aVar.epI.setBackgroundResource(aLL());
        C8907a aVar4 = (C8907a) aVar;
        aVar4.eqV.setVisibility(4);
        aVar.ero.setVisibility(4);
        aVar4.esl.setVisibility(0);
        aVar4.esl.setProgress(0);
    }

    /* access modifiers changed from: protected */
    public int aLL() {
        return R.drawable.v5_xiaoying_ve_preview_music_download;
    }
}
