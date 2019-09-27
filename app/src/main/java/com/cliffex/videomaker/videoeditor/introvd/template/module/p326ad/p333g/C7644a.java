package com.introvd.template.module.p326ad.p333g;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager.LayoutParams;
import com.introvd.template.ads.entity.AdPositionInfoParam;
import com.introvd.template.ads.listener.VideoAdsListener;
import com.introvd.template.ads.listener.VideoRewardListener;
import com.introvd.template.ads.utils.VivaAdLog;
import com.introvd.template.datacenter.SocialConstDef;
import com.introvd.template.datacenter.SocialServiceDef;
import com.introvd.template.module.ad.R;
import com.introvd.template.module.p326ad.C7678j;
import com.introvd.template.module.p326ad.C7680l;
import java.util.HashMap;

/* renamed from: com.introvd.template.module.ad.g.a */
public class C7644a extends Dialog {
    int bgQ;
    /* access modifiers changed from: private */
    public Context context;
    private boolean dNj;
    private String templateId;

    C7644a(Context context2, int i, String str, boolean z) {
        super(context2, R.style.vivavideo_iap_dialog_com_style);
        setContentView(R.layout.iap_ad_dialog_unclock_template);
        this.bgQ = i;
        this.templateId = str;
        this.context = context2;
        this.dNj = z;
    }

    /* renamed from: iA */
    private void m22454iA(boolean z) {
        HashMap hashMap = new HashMap(4);
        hashMap.put(SocialServiceDef.EXTRAS_UPGRADE_FROM, this.dNj ? "edit_theme" : "material_center");
        hashMap.put(SocialConstDef.TEMPLATE_ID, this.templateId);
        hashMap.put("result", String.valueOf(z));
        hashMap.put("unlockType", "reward");
        C7678j.aAd().mo23653g("Ad_Video_Unlock_Success", hashMap);
        VivaAdLog.m8846d("reportUnlockResult", hashMap.toString());
    }

    /* access modifiers changed from: private */
    /* renamed from: iB */
    public void m22455iB(boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put(SocialServiceDef.EXTRAS_UPGRADE_FROM, this.dNj ? "edit_theme" : "material_center");
        hashMap.put(SocialConstDef.TEMPLATE_ID, this.templateId);
        hashMap.put("type", z ? "Lock" : "colse");
        hashMap.put("unlockType", "reward");
        C7678j.aAd().mo23653g(" Ad_IAP_Unlock_Click", hashMap);
        VivaAdLog.m8846d("reportClick", hashMap.toString());
    }

    /* access modifiers changed from: protected */
    /* renamed from: iz */
    public void mo32537iz(boolean z) {
        C7680l.aAf().releasePosition(this.bgQ, false);
        m22454iA(z);
    }

    public void onBackPressed() {
        super.onBackPressed();
        mo32537iz(false);
        m22455iB(false);
    }

    public void show() {
        LayoutParams attributes = getWindow().getAttributes();
        attributes.gravity = 17;
        attributes.horizontalWeight = 0.0f;
        attributes.verticalWeight = 0.0f;
        attributes.width = this.context.getResources().getDisplayMetrics().widthPixels;
        attributes.height = this.context.getResources().getDisplayMetrics().heightPixels;
        getWindow().setAttributes(attributes);
        C76451 r0 = new OnClickListener() {
            public void onClick(View view) {
                C7644a.this.cancel();
                C7644a.this.mo32537iz(false);
                C7644a.this.m22455iB(false);
            }
        };
        findViewById(R.id.tv_btn_cancel).setOnClickListener(r0);
        findViewById(R.id.fl_container).setOnClickListener(r0);
        final boolean[] zArr = new boolean[1];
        findViewById(R.id.tv_btn_unlock).setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                C7644a.this.m22455iB(true);
                C7680l.aAf().mo32531h(C7644a.this.bgQ, new VideoAdsListener() {
                    public void onAdLoaded(AdPositionInfoParam adPositionInfoParam, boolean z, String str) {
                    }

                    public void onShowVideoAd(AdPositionInfoParam adPositionInfoParam, boolean z) {
                    }
                });
                C7680l.aAf().mo32521a((Activity) C7644a.this.context, C7644a.this.bgQ, new VideoRewardListener() {
                });
                C7644a.this.cancel();
            }
        });
        super.show();
    }
}
