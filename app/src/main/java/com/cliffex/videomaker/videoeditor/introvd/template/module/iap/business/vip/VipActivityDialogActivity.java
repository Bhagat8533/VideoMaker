package com.introvd.template.module.iap.business.vip;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.p021v4.content.ContextCompat;
import android.support.p021v4.view.ViewCompat;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.introvd.template.module.iap.C8048e;
import com.introvd.template.module.iap.C8061k;
import com.introvd.template.module.iap.C8072q;
import com.introvd.template.module.iap.R;
import com.introvd.template.module.iap.business.home.VipHomeNewActivity;
import com.introvd.template.module.iap.business.p349a.C7825a;
import com.introvd.template.module.iap.business.p349a.C7832c;
import com.introvd.template.module.iap.business.p352b.C7835b;
import com.introvd.template.module.iap.business.p356e.C7899c;
import com.introvd.template.module.iap.p341b.C7738c;
import com.introvd.template.router.AdRouter.VipHomeParams;
import com.introvd.template.vivaiap.payment.C9054a;
import com.introvd.template.vivaiap.payment.PayResult;
import com.p131c.p132a.C2570b;
import com.p131c.p132a.p135c.C2575a;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import p037b.p050b.C1834l;
import p037b.p050b.C1838m;
import p037b.p050b.C1839n;
import p037b.p050b.p051a.p053b.C1487a;
import p037b.p050b.p057e.C1517e;
import p037b.p050b.p076j.C1820a;

public class VipActivityDialogActivity extends Activity {
    private static boolean dUr;

    /* renamed from: com.introvd.template.module.iap.business.vip.VipActivityDialogActivity$a */
    private static class C8008a {
        C7832c dUv;
        String desc;
        String imgUrl;
        String label;
        String title;

        private C8008a() {
        }
    }

    /* renamed from: L */
    public static boolean m23184L(Context context, String str, String str2) {
        if (C8048e.aBe().isInChina()) {
            return false;
        }
        Intent putExtra = new Intent(context, VipActivityDialogActivity.class).putExtra(VipHomeParams.VIP_HOME_INIT_GOODS_ID, str).putExtra(VipHomeParams.VIP_HOME_PACKAGE_TYPE, str2);
        if (!(context instanceof Activity)) {
            putExtra.addFlags(268435456);
        }
        if (dUr) {
            context.startActivity(putExtra);
            return true;
        } else if (aDT() || aDS() == null) {
            return false;
        } else {
            context.startActivity(putExtra);
            return true;
        }
    }

    /* renamed from: X */
    public static void m23185X(Object obj) {
        if (obj instanceof JsonObject) {
            m23191lD(obj.toString());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m23186a(final C8008a aVar) {
        if (aVar != null) {
            TextView textView = (TextView) findViewById(R.id.tv_title);
            TextView textView2 = (TextView) findViewById(R.id.tv_content);
            TextView textView3 = (TextView) findViewById(R.id.tv_btn_buy);
            C2570b.m7332aZ(this).mo12195aO(aVar.imgUrl).mo12186g((ImageView) findViewById(R.id.iv_image));
            textView.setText(aVar.title);
            textView2.setText(aVar.desc);
            textView3.setText(aVar.label);
            textView3.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    C7835b.m22861lq("gp activity");
                    C7738c.aEv().mo32612a(VipActivityDialogActivity.this, aVar.dUv.getId(), null, new C9054a() {
                        /* renamed from: a */
                        public void mo32328a(PayResult payResult) {
                            HashMap hashMap = new HashMap();
                            hashMap.put("Promo", aVar.title);
                            if (payResult.isSuccess()) {
                                C80045.super.finish();
                                hashMap.put("success", aVar.dUv.getId());
                                hashMap.put("failed or cancel", null);
                            } else {
                                hashMap.put("success", null);
                                hashMap.put("failed or cancel", payResult.getMessage());
                                if (payResult.getCode() != 1) {
                                    VipActivityDialogActivity.this.aDR();
                                    VipActivityDialogActivity.this.finish();
                                }
                            }
                            C8048e.aBe().mo23653g("Subscription_Promo_Popups_Purchased", hashMap);
                        }
                    });
                    HashMap hashMap = new HashMap();
                    hashMap.put("result", "click");
                    C8048e.aBe().mo23653g("Subscription_Promo_Popups_Click", hashMap);
                }
            });
            HashMap hashMap = new HashMap();
            hashMap.put("Promo", aVar.title);
            C8048e.aBe().mo23653g("Subscription_Promo_Popups_Show", hashMap);
        }
    }

    /* access modifiers changed from: private */
    public void aDR() {
        startActivity(new Intent(this, VipHomeNewActivity.class).putExtra(VipHomeParams.VIP_HOME_INIT_GOODS_ID, getIntent().getStringExtra(VipHomeParams.VIP_HOME_INIT_GOODS_ID)).putExtra(VipHomeParams.VIP_HOME_PACKAGE_TYPE, getIntent().getStringExtra(VipHomeParams.VIP_HOME_PACKAGE_TYPE)));
    }

    /* access modifiers changed from: private */
    public static C8008a aDS() {
        JsonElement jsonElement;
        JsonElement jsonElement2;
        String str;
        if (C8072q.aBx().isVip() && !dUr) {
            return null;
        }
        try {
            jsonElement = new JsonParser().parse(C7899c.aDg().getString("vip_activity_string", null));
        } catch (Exception e) {
            e.printStackTrace();
            jsonElement = null;
        }
        if (jsonElement == null || !jsonElement.isJsonObject()) {
            return null;
        }
        JsonArray asJsonArray = jsonElement.getAsJsonObject().getAsJsonArray("350");
        if (asJsonArray == null) {
            return null;
        }
        JsonElement jsonElement3 = asJsonArray.size() > 0 ? asJsonArray.get(0) : null;
        if (jsonElement3 == null) {
            return null;
        }
        JsonObject asJsonObject = jsonElement3.getAsJsonObject();
        if (!(asJsonObject.has("title") && asJsonObject.has("desc") && asJsonObject.has("content") && asJsonObject.has("extend"))) {
            return null;
        }
        try {
            jsonElement2 = new JsonParser().parse(asJsonObject.get("extend").getAsString());
        } catch (Exception e2) {
            e2.printStackTrace();
            jsonElement2 = null;
        }
        if (jsonElement2 == null || !jsonElement2.isJsonObject() || !jsonElement2.getAsJsonObject().has("skuId")) {
            return null;
        }
        C7832c cVar = (C7832c) C7738c.aEv().aNw().mo35913ri(jsonElement2.getAsJsonObject().get("skuId").getAsString());
        if (cVar == null) {
            return null;
        }
        String kC = C8061k.m23408kC(cVar.getId());
        Context context = C8048e.aBe().getContext();
        if (kC.equals(C7825a.PLATINUM_MONTHLY.getId())) {
            if (TextUtils.isEmpty(cVar.aCD())) {
                str = context.getString(R.string.xiaoying_str_vip_home_purchase_month, new Object[]{cVar.mo32756sp()});
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(context.getString(R.string.xiaoying_str_vip_home_purchase_month, new Object[]{cVar.aCD()}));
                sb.append("\n");
                sb.append(context.getString(R.string.xiaoying_str_vip_for_first_month));
                str = sb.toString();
            }
        } else if (!kC.equals(C7825a.PLATINUM_YEARLY.getId())) {
            str = null;
        } else if (TextUtils.isEmpty(cVar.aCD())) {
            str = context.getString(R.string.xiaoying_str_vip_price_per_year, new Object[]{cVar.mo32756sp()});
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(context.getString(R.string.xiaoying_str_vip_price_per_year, new Object[]{cVar.aCD()}));
            sb2.append("\n");
            sb2.append(context.getString(R.string.xiaoying_str_vip_for_first_year));
            str = sb2.toString();
        }
        if (cVar.aCy()) {
            str = context.getString(R.string.xiaoying_str_vip_subscribe);
        }
        if (str == null) {
            return null;
        }
        C8008a aVar = new C8008a();
        aVar.title = asJsonObject.get("title").getAsString();
        aVar.desc = asJsonObject.get("desc").getAsString();
        aVar.imgUrl = asJsonObject.get("content").getAsString();
        aVar.dUv = cVar;
        aVar.label = str;
        return aVar;
    }

    private static boolean aDT() {
        Long l;
        String string = C7899c.aDg().getString("showed_today", "0");
        Calendar instance = Calendar.getInstance();
        Long valueOf = Long.valueOf(0);
        try {
            l = Long.valueOf(C2575a.parseLong(string.replaceAll("\\D", "0")));
        } catch (Exception e) {
            e.printStackTrace();
            l = valueOf;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        String format = simpleDateFormat.format(instance.getTime());
        instance.setTimeInMillis(l.longValue());
        return format.equals(simpleDateFormat.format(instance.getTime()));
    }

    /* renamed from: lD */
    private static void m23191lD(String str) {
        C7899c.aDg().setString("vip_activity_string", str);
    }

    @SuppressLint({"CheckResult"})
    public void finish() {
        C1834l.m5261d(500, TimeUnit.MILLISECONDS).mo10128a((C1517e<? super T>) new C1517e<Long>() {
            /* renamed from: i */
            public void accept(Long l) throws Exception {
                VipActivityDialogActivity.super.finish();
                VipActivityDialogActivity.this.overridePendingTransition(0, R.anim.dialog_exit);
            }
        }, (C1517e<? super Throwable>) new C1517e<Throwable>() {
            /* renamed from: m */
            public void accept(Throwable th) throws Exception {
                th.printStackTrace();
            }
        });
    }

    public void onBackPressed() {
        super.onBackPressed();
        aDR();
        HashMap hashMap = new HashMap();
        hashMap.put("result", "close");
        C8048e.aBe().mo23653g("Subscription_Promo_Popups_Click", hashMap);
    }

    /* access modifiers changed from: protected */
    @SuppressLint({"CheckResult"})
    public void onCreate(Bundle bundle) {
        overridePendingTransition(R.anim.dialog_enter, R.anim.dialog_exit);
        super.onCreate(bundle);
        C7899c.aDg().setString("showed_today", String.valueOf(System.currentTimeMillis()));
        setContentView(R.layout.iap_vip_dialog_vip_activity);
        findViewById(R.id.fl_container).getLayoutParams().width = (int) (((double) getResources().getDisplayMetrics().widthPixels) * 0.82d);
        findViewById(R.id.iv_btn_close).setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                VipActivityDialogActivity.this.onBackPressed();
            }
        });
        ViewCompat.setBackground(findViewById(R.id.tv_btn_buy), C8048e.aBe().mo23605C(ContextCompat.getDrawable(this, R.drawable.iap_vip_shape_bg_vip_home_month)));
        C1834l.m5254a((C1839n<T>) new C1839n<C8008a>() {
            /* renamed from: a */
            public void mo10177a(C1838m<C8008a> mVar) throws Exception {
                mVar.mo9791K(VipActivityDialogActivity.aDS());
            }
        }).mo10157d(C1820a.aVi()).mo10152c(C1487a.aUa()).mo10128a((C1517e<? super T>) new C1517e<C8008a>() {
            /* renamed from: b */
            public void accept(C8008a aVar) throws Exception {
                VipActivityDialogActivity.this.m23186a(aVar);
            }
        }, (C1517e<? super Throwable>) new C1517e<Throwable>() {
            /* renamed from: m */
            public void accept(Throwable th) throws Exception {
                th.printStackTrace();
            }
        });
    }
}
