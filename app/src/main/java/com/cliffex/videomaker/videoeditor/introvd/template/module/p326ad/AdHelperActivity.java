package com.introvd.template.module.p326ad;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.p021v4.content.ContextCompat;
import com.afollestad.materialdialogs.C1885b;
import com.afollestad.materialdialogs.C1890f;
import com.afollestad.materialdialogs.C1890f.C1895a;
import com.afollestad.materialdialogs.C1890f.C1904j;
import com.afollestad.materialdialogs.C1906h;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.introvd.template.ads.entity.AdPositionInfoParam;
import com.introvd.template.ads.listener.VideoAdsListener;
import com.introvd.template.ads.listener.VideoRewardListener;
import com.introvd.template.router.iap.IapServiceProxy;
import java.util.HashMap;

/* renamed from: com.introvd.template.module.ad.AdHelperActivity */
public class AdHelperActivity extends Activity {
    /* renamed from: ai */
    public static void m22355ai(Context context, int i) {
        Intent intent = new Intent(context, AdHelperActivity.class);
        intent.putExtra("key_param_type_code", i);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    private void azW() {
        final String[] strArr = {"cancel"};
        new C1895a(this).mo10282a(C1906h.LIGHT).mo10276a((OnDismissListener) new OnDismissListener() {
            public void onDismiss(DialogInterface dialogInterface) {
                if (!AdHelperActivity.this.isFinishing()) {
                    AdHelperActivity.this.finish();
                }
            }
        }).mo10296do(R.string.xiaoying_str_vip_remove_ad).mo10297dp(ContextCompat.getColor(this, R.color.color_333333)).mo10299dr(R.string.xiaoying_str_vip_new_setting_title).mo10300ds(ContextCompat.getColor(this, R.color.color_ff4e18)).mo10281a((C1904j) new C1904j() {
            public void onClick(C1890f fVar, C1885b bVar) {
                IapServiceProxy.launchVipHome(AdHelperActivity.this, 3, "Ad_remove", -1);
                strArr[0] = ProductAction.ACTION_PURCHASE;
            }
        }).mo10303dv(R.string.xiaoying_str_com_cancel).mo10302du(ContextCompat.getColor(this, R.color.color_666666)).mo10276a((OnDismissListener) new OnDismissListener() {
            public void onDismiss(DialogInterface dialogInterface) {
                HashMap hashMap = new HashMap();
                hashMap.put("button", strArr[0]);
                C7678j.aAd().mo23653g("Guide_AdRemove_Popup", hashMap);
                if (!AdHelperActivity.this.isFinishing()) {
                    AdHelperActivity.this.finish();
                }
            }
        }).mo10314qv();
    }

    private void azX() {
        C7680l.aAe().mo32521a(this, 42, new VideoRewardListener() {
        });
        C7680l.aAe().mo32531h(42, new VideoAdsListener() {
            public void onAdLoaded(AdPositionInfoParam adPositionInfoParam, boolean z, String str) {
            }

            public void onShowVideoAd(AdPositionInfoParam adPositionInfoParam, boolean z) {
            }
        });
    }

    /* renamed from: rP */
    private void m22356rP(int i) {
        switch (i) {
            case 101:
                azX();
                return;
            case 102:
                azW();
                return;
            default:
                finish();
                return;
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.iap_ad_act_helper);
        m22356rP(getIntent().getIntExtra("key_param_type_code", 99));
    }
}
