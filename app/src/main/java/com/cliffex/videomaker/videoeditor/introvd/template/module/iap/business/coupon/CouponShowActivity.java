package com.introvd.template.module.iap.business.coupon;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.introvd.template.module.iap.R;
import com.introvd.template.module.iap.business.p352b.C7834a;
import com.introvd.template.module.iap.business.p356e.C7897a;
import com.introvd.template.module.iap.business.p356e.C7898b;
import com.introvd.template.router.AdRouter;
import java.util.List;

public class CouponShowActivity extends Activity {
    /* access modifiers changed from: private */
    public String activityId;
    private C7846a dQE;
    /* access modifiers changed from: private */
    public String dQN = "cancel";
    /* access modifiers changed from: private */
    public String dQO = null;

    /* renamed from: a */
    private void m22879a(C7852b bVar) {
        ((TextView) findViewById(R.id.tv_coupon_content)).setText(bVar.aCe());
        ((TextView) findViewById(R.id.tv_coupon_title)).setText(bVar.aCf());
        ((TextView) findViewById(R.id.tv_coupon_time)).setText(bVar.aCg());
        ((TextView) findViewById(R.id.tv_coupon_desc)).setText(bVar.getDesc());
        final TextView textView = (TextView) findViewById(R.id.tv_coupon_to_renew);
        textView.setText(bVar.aCh());
        textView.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                CouponShowActivity.this.dQN = textView.getText().toString();
                C7897a.m23022b(CouponShowActivity.this.activityId, C7898b.dSW, new String[0]);
                AdRouter.launchVipRenew(CouponShowActivity.this, CouponShowActivity.this.dQO);
                CouponShowActivity.this.finish();
            }
        });
        findViewById(R.id.iv_coupon_close).setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (!CouponShowActivity.this.isFinishing()) {
                    CouponShowActivity.this.finish();
                }
            }
        });
    }

    /* renamed from: a */
    public static boolean m22880a(Context context, String str, C7846a aVar) {
        boolean z = false;
        if (context == null || aVar == null) {
            return false;
        }
        C7858e.m22917b(aVar);
        Intent intent = new Intent(context, CouponShowActivity.class);
        intent.putExtra("key_achieve_coupon", aVar);
        intent.putExtra("key_achieve_coupon_activity_id", str);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        try {
            context.startActivity(intent);
            z = true;
        } catch (Exception unused) {
        }
        return z;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.iap_vip_activity_coupon_achieve);
        this.dQE = (C7846a) getIntent().getSerializableExtra("key_achieve_coupon");
        this.activityId = getIntent().getStringExtra("key_achieve_coupon_activity_id");
        if (this.dQE == null) {
            finish();
            return;
        }
        List aCa = this.dQE.aCa();
        if (aCa != null && !aCa.isEmpty()) {
            this.dQO = (String) aCa.get(0);
        }
        C7852b bVar = null;
        if ("10".equals(String.valueOf(this.activityId)) || "7".equals(this.activityId) || "4".equals(this.activityId) || "5".equals(this.activityId) || "6".equals(this.activityId) || "11".equals(this.activityId)) {
            bVar = new C7866g(this.dQE);
        } else if ("3".equals(this.activityId) || "8".equals(this.activityId)) {
            bVar = new C7865f(this.dQE);
        }
        if (bVar == null) {
            finish();
        } else {
            m22879a(bVar);
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        C7834a.m22839o(this.activityId, this.dQE.code, this.dQN);
    }
}
