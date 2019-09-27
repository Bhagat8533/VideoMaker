package com.introvd.template.module.iap.business;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.p024v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.introvd.template.common.LogUtils;
import com.introvd.template.module.iap.C8045d;
import com.introvd.template.module.iap.C8048e;
import com.introvd.template.module.iap.C8049f;
import com.introvd.template.module.iap.R;
import com.introvd.template.module.iap.business.coupon.C7858e;
import com.introvd.template.module.iap.business.p349a.C7827b;
import com.introvd.template.module.iap.business.p352b.C7834a;
import com.introvd.template.module.iap.p341b.p343b.C7735c;
import com.introvd.template.module.iap.utils.animation.C8076a;
import com.introvd.template.module.p338b.C7686a;
import com.introvd.template.router.user.UserServiceProxy;
import com.quvideo.plugin.payclient.common.C4852b;
import com.quvideo.plugin.payclient.common.model.SignStatusParam;
import com.quvideo.plugin.payclient.common.model.SignStatusResult;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import org.greenrobot.eventbus.C10021c;
import org.greenrobot.eventbus.C10031j;
import org.greenrobot.eventbus.ThreadMode;
import p037b.p050b.C1850u;
import p037b.p050b.p051a.p053b.C1487a;
import p037b.p050b.p054b.C1495b;
import p037b.p050b.p073g.C1810c;

public class VipSignQueryActivity extends AppCompatActivity {
    private C1495b cTc;
    /* access modifiers changed from: private */
    public View dQj;
    /* access modifiers changed from: private */
    public View dQk;
    /* access modifiers changed from: private */
    public View dQl;
    private ImageView dQm;
    private TextView dQn;
    private TextView dQo;
    private C8076a dQp;
    private long dQq = -1;
    private Queue<Long> dQr;
    private boolean dQs = false;
    private String goodsId;

    /* renamed from: po */
    private OnClickListener f3557po;

    public VipSignQueryActivity() {
        aBW();
        this.f3557po = new OnClickListener() {
            public void onClick(View view) {
                if (view.equals(VipSignQueryActivity.this.dQj) || view.equals(VipSignQueryActivity.this.dQk)) {
                    VipSignQueryActivity.this.finish();
                } else if (view.equals(VipSignQueryActivity.this.dQl)) {
                    VipSignQueryActivity.this.aBW();
                    VipSignQueryActivity.this.aBX();
                }
            }
        };
    }

    /* access modifiers changed from: private */
    public void aBW() {
        if (this.dQr != null) {
            this.dQr.clear();
        } else {
            this.dQr = new LinkedList();
        }
        this.dQr.addAll(Arrays.asList(new Long[]{Long.valueOf(0), Long.valueOf(2), Long.valueOf(3)}));
    }

    /* access modifiers changed from: private */
    public void aBX() {
        updateState(0);
        dispose();
        if (!this.dQr.isEmpty()) {
            Long l = (Long) this.dQr.poll();
            if (l != null) {
                this.cTc = C1487a.aUa().mo9777a(new Runnable() {
                    public void run() {
                        C8049f.aBf().aBh();
                    }
                }, l.longValue(), TimeUnit.SECONDS);
            }
        }
    }

    private long aBY() {
        C7827b aBa = C8045d.aAZ().aBa();
        if (aBa != null) {
            return aBa.aCw();
        }
        return -1;
    }

    private void aBZ() {
        if (this.dQp != null) {
            this.dQp.aEQ();
        }
    }

    /* renamed from: bY */
    public static void m22797bY(Context context, String str) {
        Intent intent = new Intent(context, VipSignQueryActivity.class);
        intent.putExtra("goodsId", str);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    private void dispose() {
        if (this.cTc != null && !this.cTc.aAy()) {
            this.cTc.dispose();
        }
    }

    private void initUI() {
        this.dQj = findViewById(R.id.iv_back);
        this.dQk = findViewById(R.id.tv_finish);
        this.dQm = (ImageView) findViewById(R.id.iv_result_icon);
        this.dQn = (TextView) findViewById(R.id.tv_result_txt);
        this.dQl = findViewById(R.id.tv_query_again);
        this.dQo = (TextView) findViewById(R.id.tv_query_help);
        this.dQj.setOnClickListener(this.f3557po);
        this.dQk.setOnClickListener(this.f3557po);
        this.dQl.setOnClickListener(this.f3557po);
        String string = getString(R.string.xiaoying_str_iap_vip_query_extra_connect_service);
        String string2 = getString(R.string.xiaoying_str_iap_vip_query_extra_help);
        StringBuilder sb = new StringBuilder();
        sb.append(string2);
        sb.append(string);
        String sb2 = sb.toString();
        SpannableString spannableString = new SpannableString(sb2);
        spannableString.setSpan(new ClickableSpan() {
            public void onClick(View view) {
                C8048e.aBe().mo23645d(VipSignQueryActivity.this, -1);
            }
        }, string2.length(), sb2.length(), 33);
        this.dQo.setMovementMethod(LinkMovementMethod.getInstance());
        this.dQo.setText(spannableString);
    }

    private void updateState(int i) {
        switch (i) {
            case 0:
                this.dQm.setImageResource(R.drawable.iap_vip_icon_query_processing);
                StringBuilder sb = new StringBuilder();
                sb.append(getString(R.string.xiaoying_str_iap_vip_query_result_processing));
                sb.append("...");
                String sb2 = sb.toString();
                SpannableString spannableString = new SpannableString(sb2);
                spannableString.setSpan(new AbsoluteSizeSpan(20, true), sb2.length() - 3, sb2.length(), 33);
                this.dQn.setText(spannableString);
                this.dQo.setVisibility(8);
                this.dQk.setVisibility(8);
                this.dQl.setVisibility(8);
                this.dQp = C8076a.m23436i(this.dQn).mo33130sO(sb2.length() - 3).mo33131sP(sb2.length()).aER();
                return;
            case 1:
                aBZ();
                this.dQm.setImageResource(R.drawable.iap_vip_icon_query_successful);
                this.dQn.setText(R.string.xiaoying_str_iap_vip_query_result_successful);
                this.dQo.setVisibility(8);
                this.dQk.setVisibility(8);
                this.dQl.setVisibility(8);
                this.dQs = true;
                return;
            case 2:
                aBZ();
                this.dQm.setImageResource(R.drawable.iap_vip_icon_query_failed);
                this.dQn.setText(R.string.xiaoying_str_iap_vip_query_result_failed);
                this.dQo.setVisibility(0);
                this.dQk.setVisibility(0);
                this.dQl.setVisibility(0);
                this.dQs = false;
                return;
            default:
                return;
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.iap_vip_act_sign_query_layout);
        Intent intent = getIntent();
        if (intent != null) {
            this.goodsId = intent.getStringExtra("goodsId");
        }
        C10021c.aZH().mo38494ax(this);
        this.dQq = aBY();
        initUI();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        dispose();
        aBZ();
        C10021c.aZH().mo38492aA(new C7995j());
        C10021c.aZH().mo38496az(this);
        C7834a.m22835j(this.dQs, this.goodsId);
        C4852b.m12463a(UserServiceProxy.getUserId(), new SignStatusParam(this.goodsId, C8048e.aBe().getCountryCode())).mo10188a((C1850u<? super T>) new C1810c<SignStatusResult>() {
            /* renamed from: b */
            public void onSuccess(SignStatusResult signStatusResult) {
                if (!signStatusResult.isSuccessful() && C7686a.aAS()) {
                    C7858e.m22924la("11");
                }
            }

            public void onError(Throwable th) {
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        LogUtils.m14222e("onNewIntent", "-----onNewIntent");
    }

    @C10031j(aZK = ThreadMode.MAIN)
    public void onPurchaseUpdate(C7735c cVar) {
        switch (cVar.getResponseCode()) {
            case 0:
            case 2:
                if (this.dQr.isEmpty()) {
                    updateState(2);
                    return;
                } else {
                    aBX();
                    return;
                }
            case 1:
                long aBY = aBY();
                if (C7833b.m22830sj(C7833b.aBC()) && aBY > this.dQq) {
                    updateState(1);
                    return;
                } else if (!this.dQr.isEmpty()) {
                    aBX();
                    return;
                } else {
                    updateState(2);
                    return;
                }
            default:
                return;
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        dispose();
        aBW();
        aBX();
    }
}
