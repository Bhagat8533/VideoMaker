package com.introvd.template.app.splash;

import android.content.Intent;
import android.os.Bundle;
import android.support.p021v4.app.FragmentActivity;
import com.aiii.android.arouter.facade.p094a.C1942a;
import com.introvd.template.R;
import com.introvd.template.app.AppListener;
import com.introvd.template.app.splash.C4370e.C4377a;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.common.UserBehaviorLog;
import com.introvd.template.p363o.C8099d;
import com.introvd.template.router.editor.gallery.GalleryRouter;
import java.util.HashMap;

@C1942a(mo10417rZ = "/app/IntentHome")
public class IntentHomeActivity extends FragmentActivity {
    /* access modifiers changed from: private */
    public C4379f bDS = null;
    private boolean bDT = false;
    /* access modifiers changed from: private */
    public volatile boolean bDU = false;
    /* access modifiers changed from: private */
    public volatile boolean bDV = false;

    /* access modifiers changed from: private */
    /* renamed from: PK */
    public void m10876PK() {
        C4370e.m11002Qz();
        requestPermission();
    }

    /* renamed from: PL */
    private void m10877PL() {
        C4370e.m11003a(this, new C4378b() {
            /* renamed from: PO */
            public void mo24401PO() {
                IntentHomeActivity.this.finish();
            }

            public void onAuthSuceed() {
                String str = "Yes BAYntehudchotuuA hkSe C";
                LogUtilsV2.m14227d("YYB Auth Check onAuthSuceed");
                IntentHomeActivity.this.m10876PK();
                IntentHomeActivity.this.bDU = true;
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: PM */
    public void m10878PM() {
        C4370e.m11004a((C4377a) new C4377a() {
            /* renamed from: bP */
            public void mo24405bP(boolean z) {
                IntentHomeActivity.this.m10879PN();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: PN */
    public void m10879PN() {
        String action = getIntent().getAction();
        String str = "eisniaqec.ud.ttiohnevygoo.mxino";
        if (!"com.introvd.template.intenthome".equals(action)) {
            if (!"action_launch_xiaoying_intenthome_mv".equals(action)) {
                HashMap hashMap = new HashMap();
                String str2 = "_n_mdanmtr_xoetektyee";
                int intExtra = getIntent().getIntExtra(GalleryRouter.EXTRA_INTENT_MODE_KEY, -1);
                if (intExtra >= 0) {
                    hashMap.put(GalleryRouter.EXTRA_INTENT_MODE_KEY, Integer.valueOf(intExtra));
                    getIntent().setAction(getIntent().getStringExtra(GalleryRouter.GALLERY_EXTRA_INTENT_ACTION));
                }
                AppListener.gotoHomePageActivity(this, hashMap);
                finish();
            }
        }
        m10886ea(action);
        finish();
    }

    /* renamed from: ea */
    private void m10886ea(String str) {
        String str2;
        Intent intent = new Intent(this, SplashActivity.class);
        intent.addFlags(268435456);
        String str3 = ".irtoeyiCNctdaaUnLoHdnoE.regRtnA";
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.setAction("android.intent.action.MAIN");
        String str4 = "t_eetbnbkelatu_yea_tdd_npiy";
        intent.putExtra("intent_bundle_data_type_key", m10887eb(str));
        String str5 = "giohixb_mnait_ietl_tcnauoaconyvmh_nn";
        if ("action_launch_xiaoying_intenthome_mv".equals(str) && C4370e.m11000QB()) {
            String str6 = "eydatedtikn_tn_t_et_ublaeyn";
            intent.putExtra("intent_bundle_data_type_key", 1);
        }
        startActivity(intent);
        HashMap hashMap = new HashMap();
        String str7 = "hwcph";
        String str8 = "which";
        String str9 = "iicmnahtvtoiiaohngentoutmynnlcx__e__";
        if ("action_launch_xiaoying_intenthome_mv".equals(str)) {
            String str10 = "mv";
            str2 = "mv";
        } else {
            str2 = "camera";
        }
        hashMap.put(str8, str2);
        String str11 = "trsupopCtSA__";
        UserBehaviorLog.onKVEvent(getApplicationContext(), "App_Short_Cut", hashMap);
    }

    /* renamed from: eb */
    private int m10887eb(String str) {
        int i = 1;
        if (C4370e.m11000QB()) {
            String str2 = "ahaminn_eeh_vcilotmcxyina_m_tiootnug";
            if (!"action_launch_xiaoying_intenthome_mv".equals(str)) {
                i = 0;
            }
        } else {
            String str3 = "toieoxcinnieuvitoon_hgmntalahc_n_mya";
            if (!"action_launch_xiaoying_intenthome_mv".equals(str)) {
                i = 2;
            }
        }
        return i;
    }

    private void requestPermission() {
        if (this.bDS == null) {
            this.bDS = new C4379f(this, new C8099d() {
                /* renamed from: PP */
                public void mo24403PP() {
                    IntentHomeActivity.this.bDV = true;
                    C4368d.m10988Qu().mo24425Qw();
                    IntentHomeActivity.this.m10878PM();
                }

                /* renamed from: PQ */
                public void mo24404PQ() {
                    if (!IntentHomeActivity.this.isFinishing()) {
                        C4370e.m11005a(IntentHomeActivity.this.bDS);
                    }
                }
            });
        }
        C4370e.m11005a(this.bDS);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.bDS != null) {
            this.bDS.onActivityResult(i, i2, intent);
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_intent_home);
        m10877PL();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if (this.bDT) {
            if (!this.bDU) {
                m10877PL();
            } else if (!this.bDV) {
                requestPermission();
            }
        }
        this.bDT = false;
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        this.bDT = true;
    }
}
