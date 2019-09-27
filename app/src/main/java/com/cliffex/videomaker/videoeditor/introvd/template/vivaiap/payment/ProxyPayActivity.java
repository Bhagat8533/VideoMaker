package com.introvd.template.vivaiap.payment;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.p021v4.content.LocalBroadcastManager;
import android.view.MotionEvent;

public class ProxyPayActivity extends Activity {
    private C9055b eBo;
    private PayParam eBp;
    private BroadcastReceiver receiver;

    /* renamed from: com.introvd.template.vivaiap.payment.ProxyPayActivity$a */
    private class C9049a extends BroadcastReceiver {
        private C9049a() {
        }

        public void onReceive(Context context, Intent intent) {
            ProxyPayActivity.this.finish();
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        finish();
        return true;
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.eBo == null) {
            C9059e.m26485a(getApplicationContext(), false, -1, "PayClient has been released or be null.", this.eBp);
        } else {
            this.eBo.mo35890a((Context) this, i, i2, intent);
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        getWindow().addFlags(262160);
        super.onCreate(bundle);
        this.receiver = new C9049a();
        LocalBroadcastManager.getInstance(this).registerReceiver(this.receiver, new IntentFilter("com.introvd.template.vivaiap.payment.finish.filter"));
        this.eBp = (PayParam) getIntent().getParcelableExtra("payment_buy_intent");
        if (this.eBp == null) {
            C9059e.m26485a(getApplicationContext(), false, -1, "PayParam is null.", null);
            return;
        }
        this.eBo = C9059e.m26487rg(this.eBp.aEO());
        if (this.eBo == null) {
            C9059e.m26485a(getApplicationContext(), false, -1, "PayClient is null.", this.eBp);
        } else {
            this.eBo.mo35893b(this, this.eBp);
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        LocalBroadcastManager.getInstance(this).unregisterReceiver(this.receiver);
    }
}
