package com.introvd.template.module.iap.business.exchange;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.afollestad.materialdialogs.C1890f.C1895a;
import com.aiii.android.arouter.facade.p094a.C1942a;
import com.introvd.template.common.ToastUtils;
import com.introvd.template.module.iap.C8048e;
import com.introvd.template.module.iap.R;
import com.introvd.template.module.iap.business.exchange.C7909a.C7913b;
import com.introvd.template.module.iap.business.exchange.C7916c.C7920a;
import com.introvd.template.module.p339c.C7689a;
import com.introvd.template.router.user.UserServiceProxy;

@C1942a(mo10417rZ = "/XYVIP/VipExchange/entry")
public class VipExchangeActivity extends Activity implements C7913b {
    /* access modifiers changed from: private */
    public EditText dSs;
    private TextView dSt;
    private ViewGroup dSu;
    private ViewGroup dSv;
    private C7909a dSw;
    private boolean dSx;
    private ImageButton dif;

    /* renamed from: Kl */
    private void m23031Kl() {
        this.dif = (ImageButton) findViewById(R.id.btn_back);
        this.dSv = (ViewGroup) findViewById(R.id.root_layout);
        this.dSu = (ViewGroup) findViewById(R.id.content_layout);
        this.dSs = (EditText) findViewById(R.id.et_exchange_key);
        this.dSt = (TextView) findViewById(R.id.btn_exchange);
        this.dSs.setOnEditorActionListener(new OnEditorActionListener() {
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 6 && VipExchangeActivity.this.dSs != null) {
                    VipExchangeActivity.this.m23035lv(VipExchangeActivity.this.dSs.getText().toString());
                }
                return false;
            }
        });
        ams();
    }

    /* access modifiers changed from: private */
    public void aCV() {
        this.dSs.clearFocus();
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(this.dSs.getWindowToken(), 0);
        }
    }

    private void ams() {
        this.dSw = new C7909a(this);
        this.dSw.mo32871a((C7913b) this);
        this.dSt.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                String obj = VipExchangeActivity.this.dSs.getText().toString();
                VipExchangeActivity.this.m23035lv(obj);
                if (!TextUtils.isEmpty(obj)) {
                    VipExchangeActivity.this.aCV();
                }
            }
        });
        this.dif.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                VipExchangeActivity.this.finish();
            }
        });
        this.dSu.setOnTouchListener(new OnTouchListener() {
            @SuppressLint({"ClickableViewAccessibility"})
            public boolean onTouch(View view, MotionEvent motionEvent) {
                VipExchangeActivity.this.aCV();
                return false;
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: lv */
    public void m23035lv(String str) {
        if (!UserServiceProxy.isLogin()) {
            C8048e.aBe().mo23621Mm();
        } else if (!TextUtils.isEmpty(str)) {
            C8048e.aBe().mo23642b(this, true);
            C7916c.aCW().mo32877a(str, (C7920a) new C7920a() {
                /* renamed from: a */
                public void mo32574a(C7922d dVar) {
                    C8048e.aBe().mo23623Mo();
                    if ("0".equals(dVar.code)) {
                        ToastUtils.show((Context) VipExchangeActivity.this, VipExchangeActivity.this.getString(R.string.iap_vip_exchange_result_success), 0);
                    } else if ("10005001".equals(dVar.code)) {
                        ToastUtils.show((Context) VipExchangeActivity.this, VipExchangeActivity.this.getString(R.string.iap_vip_exchange_result_had_used), 0);
                    } else if ("10005004".equals(dVar.code)) {
                        try {
                            new C1895a(VipExchangeActivity.this).mo10293dl(R.string.iap_vip_exchange_result_invalid).mo10296do(R.string.iap_vip_exchange_result_usage_exceeds_limit).mo10316s("ok").mo10313qu().show();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else {
                        ToastUtils.show((Context) VipExchangeActivity.this, VipExchangeActivity.this.getString(R.string.iap_vip_exchange_result_invalid), 0);
                    }
                }
            });
        }
    }

    public void aCU() {
        if (this.dSx) {
            this.dSx = false;
            this.dSv.scrollBy(0, -C7689a.m22599ii(38));
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.iap_vip_act_exchange_layout);
        m23031Kl();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        this.dSw.destroy();
        super.onDestroy();
    }

    /* renamed from: sy */
    public void mo32866sy(int i) {
        if (!this.dSx) {
            this.dSx = true;
            this.dSv.scrollBy(0, C7689a.m22599ii(38));
        }
    }
}
