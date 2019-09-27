package com.introvd.template.module.p326ad.p337i;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.introvd.template.ads.entity.AdPositionInfoParam;
import com.introvd.template.ads.listener.ViewAdsListener;
import com.introvd.template.module.ad.R;
import com.introvd.template.module.p326ad.C7678j;
import com.introvd.template.module.p326ad.p327a.C7589a;
import com.introvd.template.module.p326ad.p328b.C7591a;
import com.introvd.template.module.p326ad.p328b.C7592b;
import java.util.HashMap;

/* renamed from: com.introvd.template.module.ad.i.a */
public class C7665a extends AlertDialog {
    private ViewAdsListener bFF = new ViewAdsListener() {
        public void onAdLoaded(AdPositionInfoParam adPositionInfoParam, boolean z, String str) {
            C7665a.this.aAI();
        }
    };
    private int bgQ;
    private View bwy;
    /* access modifiers changed from: private */
    public View cOt;
    /* access modifiers changed from: private */
    public Context context;
    private View dNF;
    private ViewGroup dNG;
    /* access modifiers changed from: private */
    public OnClickListener dNH;
    /* access modifiers changed from: private */
    public String dNI;
    private String dNJ;
    private View dNK;

    public C7665a(Context context2, int i) {
        super(context2, R.style.vivavideo_iap_dialog_com_style);
        this.context = context2;
        this.bgQ = i;
        initUI();
        C7589a.m22363h(i, this.bFF);
    }

    /* access modifiers changed from: private */
    public void aAI() {
        if (this.dNK != null) {
            if (this.cOt != this.dNK) {
                this.cOt = this.dNK;
                HashMap hashMap = new HashMap();
                String W = C7591a.m22370W(this.cOt.getTag());
                hashMap.put("platform", W);
                C7678j.aAd().mo23653g(this.dNJ, hashMap);
                C7592b.m22379F(this.cOt.getContext(), this.dNJ, W);
            }
            ViewGroup viewGroup = (ViewGroup) this.dNK.getParent();
            if (viewGroup != null) {
                viewGroup.removeAllViews();
            }
            if (this.dNG != null) {
                this.dNG.removeAllViews();
                this.dNG.addView(this.dNK);
            }
        }
    }

    private void initUI() {
        int i;
        if (this.bgQ == 16) {
            i = R.layout.iap_ad_dialog_exit_layout;
            this.dNI = "Ad_Exit_Click";
            this.dNJ = "Ad_Exit_Show";
        } else if (this.bgQ == 17) {
            i = R.layout.iap_vip_dialog_draft_layout;
            this.dNI = "Ad_Savedraft_Click";
        } else {
            i = 0;
        }
        this.bwy = LayoutInflater.from(this.context).inflate(i, null);
        this.dNF = this.bwy.findViewById(R.id.exit_dialog_exit_button);
        this.dNG = (ViewGroup) this.bwy.findViewById(R.id.exit_dialog_content_layout);
        this.dNF.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (C7665a.this.cOt != null) {
                    String W = C7591a.m22370W(C7665a.this.cOt.getTag());
                    HashMap hashMap = new HashMap();
                    hashMap.put("platform", W);
                    String str = "unknown";
                    if ("Ad_Savedraft_Click".equals(C7665a.this.dNI)) {
                        str = "close";
                    } else if ("Ad_Exit_Click".equals(C7665a.this.dNI)) {
                        str = "exit";
                    }
                    hashMap.put("type", str);
                    C7678j.aAd().mo23653g(C7665a.this.dNI, hashMap);
                }
                if ((C7665a.this.context instanceof Activity) && !((Activity) C7665a.this.context).isFinishing()) {
                    C7665a.this.dismiss();
                }
                if (C7665a.this.dNH != null) {
                    C7665a.this.dNH.onClick(view);
                }
            }
        });
    }

    /* renamed from: d */
    public void mo32558d(OnClickListener onClickListener) {
        this.dNH = onClickListener;
    }

    public void show() {
        if ((this.context instanceof Activity) && !((Activity) this.context).isFinishing()) {
            this.dNK = C7589a.getAdView(getContext(), this.bgQ);
            if (this.dNK != null) {
                super.show();
                aAI();
                setContentView(this.bwy);
            }
        }
    }
}
