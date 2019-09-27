package com.introvd.template.module.iap.business.vip;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.p021v4.content.ContextCompat;
import android.support.p021v4.view.ViewCompat;
import android.support.p024v7.widget.LinearLayoutManager;
import android.support.p024v7.widget.RecyclerView;
import android.support.p024v7.widget.RecyclerView.C1008a;
import android.support.p024v7.widget.RecyclerView.C1022l;
import android.support.p024v7.widget.RecyclerView.C1034u;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.TextView;
import com.introvd.template.common.LogUtils;
import com.introvd.template.module.iap.C8048e;
import com.introvd.template.module.iap.R;
import com.introvd.template.module.iap.business.p349a.C7825a;
import com.introvd.template.module.iap.business.p352b.C7835b;
import com.introvd.template.module.iap.p341b.C7738c;
import com.introvd.template.module.p339c.C7689a;
import com.introvd.template.vivaiap.payment.C9054a;
import com.introvd.template.vivaiap.payment.PayResult;
import com.ironsource.sdk.constants.Constants.ParametersKeys;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GoldUpDialogStyleActivity extends Activity implements OnClickListener {
    /* access modifiers changed from: private */
    public String dUe;
    private String dUf;
    private View dUg;
    private View dUh;
    private RecyclerView dUi;
    /* access modifiers changed from: private */
    public ViewGroup dUj;
    private int dUk;
    private final C1022l dUl = new C1022l() {
        int dUm = -1;

        /* renamed from: a */
        public void mo8095a(RecyclerView recyclerView, int i, int i2) {
            View l = recyclerView.mo7818l((float) (recyclerView.getWidth() / 2), 1.0f);
            if (l != null && (l.getTag() instanceof Integer)) {
                int intValue = ((Integer) l.getTag()).intValue();
                if (this.dUm != intValue) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(intValue);
                    sb.append("    ----");
                    LogUtils.m14222e("onScrolled", sb.toString());
                    int i3 = 0;
                    while (i3 < GoldUpDialogStyleActivity.this.dUj.getChildCount()) {
                        GoldUpDialogStyleActivity.this.dUj.getChildAt(i3).setSelected(i3 == intValue);
                        i3++;
                    }
                    this.dUm = intValue;
                }
            }
        }
    };

    /* renamed from: I */
    static void m23177I(Context context, String str, String str2) {
        if (context != null && str != null) {
            context.startActivity(new Intent(context.getApplicationContext(), GoldUpDialogStyleActivity.class).addFlags(268435456).putExtra("goodsType", str).putExtra("oldGoodsId", str2));
        }
    }

    private String aDQ() {
        if (this.dUf == null) {
            return null;
        }
        if (C7825a.VIDEO_PARAM_ADJUST.getId().equals(this.dUf)) {
            this.dUk = 0;
            return "参数调节";
        } else if (C7825a.ALL_TEMPLATE.getId().equals(this.dUf)) {
            this.dUk = 1;
            return "素材";
        } else if (C7825a.ANIM_TITLE.getId().equals(this.dUf)) {
            this.dUk = 2;
            return "动态字幕";
        } else if (!C7825a.CUSTOMIZED_BACKGROUND.getId().equals(this.dUf)) {
            return null;
        } else {
            this.dUk = 3;
            return "自定义背景";
        }
    }

    private void aod() {
        this.dUg = findViewById(R.id.vip_close);
        this.dUh = findViewById(R.id.tv_btn_gold_up);
        this.dUj = (ViewGroup) findViewById(R.id.ll_indicators);
        this.dUi = (RecyclerView) findViewById(R.id.rv_function_provider);
        this.dUg.setOnClickListener(this);
        this.dUh.setOnClickListener(this);
        this.dUi.setLayoutManager(new LinearLayoutManager(this, 0, false));
        C1008a adapter = getAdapter();
        this.dUi.setAdapter(adapter);
        this.dUi.mo7737a(this.dUl);
        for (int i = 0; i < adapter.getItemCount(); i++) {
            View view = new View(this);
            view.setBackground(ContextCompat.getDrawable(this, R.drawable.iap_vip_selector_dialog_gold_up_indicator));
            this.dUj.addView(view, new LayoutParams(C7689a.m22599ii(15), C7689a.m22599ii(2)));
            LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof MarginLayoutParams) {
                MarginLayoutParams marginLayoutParams = (MarginLayoutParams) layoutParams;
                marginLayoutParams.leftMargin = C7689a.m22599ii(1);
                marginLayoutParams.rightMargin = C7689a.m22599ii(1);
            }
            view.setLayoutParams(layoutParams);
        }
        ViewCompat.setBackground(this.dUh, C8048e.aBe().mo23605C(ContextCompat.getDrawable(this, R.drawable.iap_vip_shape_bg_vip_home_month)));
    }

    private C1008a getAdapter() {
        return new C1008a() {
            public int getItemCount() {
                return 5;
            }

            public void onBindViewHolder(C1034u uVar, int i) {
                uVar.itemView.setTag(Integer.valueOf(i));
                View findViewById = uVar.itemView.findViewById(R.id.ll_bg_function);
                TextView textView = (TextView) uVar.itemView.findViewById(R.id.tv_description);
                switch (i) {
                    case 0:
                        findViewById.setBackgroundResource(R.drawable.iap_vip_gold_up_adjust);
                        textView.setText(GoldUpDialogStyleActivity.this.getString(R.string.xiaoying_str_vip_item_adjust_title));
                        return;
                    case 1:
                        findViewById.setBackgroundResource(R.drawable.iap_vip_gold_up_more_metial);
                        textView.setText(GoldUpDialogStyleActivity.this.getString(R.string.xiaoying_str_vip_item_template_title));
                        return;
                    case 2:
                        findViewById.setBackgroundResource(R.drawable.iap_vip_gold_up_wrd);
                        textView.setText(GoldUpDialogStyleActivity.this.getString(R.string.xiaoying_str_vip_item_animated_text_title));
                        return;
                    case 3:
                        findViewById.setBackgroundResource(R.drawable.iap_vip_gold_up_customized_bg);
                        textView.setText(GoldUpDialogStyleActivity.this.getString(R.string.xiaoying_str_vip_item_custom_bg_title));
                        return;
                    case 4:
                        findViewById.setBackgroundResource(R.drawable.iap_vip_gold_up_export_4k);
                        textView.setText(GoldUpDialogStyleActivity.this.getString(R.string.viva_publish_4k_item_title));
                        return;
                    default:
                        return;
                }
            }

            public C1034u onCreateViewHolder(ViewGroup viewGroup, int i) {
                return new C1034u(GoldUpDialogStyleActivity.this.getLayoutInflater().inflate(R.layout.iap_vip_dialog_recycle_item_function, viewGroup, false)) {
                };
            }
        };
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public void m23181h(String str, String... strArr) {
        if (strArr.length % 2 == 0) {
            HashMap hashMap = new HashMap((strArr.length / 2) + 2);
            if (aDQ() != null) {
                hashMap.put("feature", aDQ());
            } else {
                hashMap.put("isPop", "true");
            }
            List aNG = C7738c.aEv().aNx().aNG();
            hashMap.put("subscription", Arrays.toString(aNG.toArray(new String[aNG.size()])));
            for (int i = 0; i < strArr.length; i += 2) {
                int i2 = i + 1;
                if (i2 >= strArr.length) {
                    break;
                }
                hashMap.put(strArr[i], strArr[i2]);
            }
            LogUtils.m14222e(getClass().getSimpleName(), hashMap.toString());
            C8048e.aBe().mo23653g(str, hashMap);
        }
    }

    public void finish() {
        super.finish();
        overridePendingTransition(0, R.anim.dialog_exit);
    }

    public void onBackPressed() {
        super.onBackPressed();
        m23181h("Subscription_Upgrade_Click", "button", "close");
    }

    public void onClick(View view) {
        String str = "Subscription_Upgrade_Click";
        String[] strArr = new String[2];
        strArr[0] = "button";
        strArr[1] = view == this.dUg ? "close" : "upgrade";
        m23181h(str, strArr);
        if (view == this.dUg) {
            finish();
        } else if (view == this.dUh) {
            C7835b.m22861lq("gold up");
            C7738c.aEv().mo32612a(C8048e.aBe().getContext(), this.dUe, null, new C9054a() {
                /* renamed from: a */
                public void mo32328a(PayResult payResult) {
                    boolean isSuccess = payResult.isSuccess();
                    boolean z = payResult.getCode() == 1;
                    GoldUpDialogStyleActivity goldUpDialogStyleActivity = GoldUpDialogStyleActivity.this;
                    String str = "Subscription_Upgrade_Result";
                    String[] strArr = new String[2];
                    String str2 = isSuccess ? "success" : z ? "cancel" : ParametersKeys.FAILED;
                    strArr[0] = str2;
                    strArr[1] = GoldUpDialogStyleActivity.this.dUe;
                    goldUpDialogStyleActivity.m23181h(str, strArr);
                    if (isSuccess) {
                        GoldUpDialogStyleActivity.this.finish();
                    }
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        overridePendingTransition(R.anim.dialog_enter, R.anim.dialog_exit);
        super.onCreate(bundle);
        setContentView(R.layout.iap_vip_dialog_gold_up);
        this.dUe = getIntent().getStringExtra("goodsType");
        this.dUf = getIntent().getStringExtra("oldGoodsId");
        aod();
        aDQ();
        this.dUi.scrollToPosition(this.dUk);
        m23181h("Subscription_Upgrade_Enter", new String[0]);
    }
}
