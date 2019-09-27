package com.introvd.template.module.iap.business.vip.p360a;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.introvd.template.module.iap.C8045d;
import com.introvd.template.module.iap.C8048e;
import com.introvd.template.module.iap.C8049f;
import com.introvd.template.module.iap.C8061k;
import com.introvd.template.module.iap.R;
import com.introvd.template.module.iap.business.p349a.C7825a;
import com.introvd.template.module.iap.business.p349a.C7832c;
import com.introvd.template.module.iap.business.p352b.C7835b;
import com.introvd.template.module.p339c.C7689a;
import com.introvd.template.vivaiap.payment.C9054a;
import com.introvd.template.vivaiap.payment.PayResult;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.introvd.template.module.iap.business.vip.a.c */
class C8016c implements C8022e {
    private boolean dUy;
    private String goodsId;

    C8016c(String str) {
        this.goodsId = str;
        this.dUy = m23213lE(str);
    }

    /* renamed from: lE */
    private boolean m23213lE(String str) {
        C7832c kw = C8045d.aAZ().mo33074kw(str);
        if (kw != null) {
            return kw.aCy();
        }
        return false;
    }

    public int aDW() {
        return R.drawable.iap_vip_bg_pay_dialog_head;
    }

    public float aDX() {
        return 2.0f;
    }

    public List<String> aDY() {
        return null;
    }

    public int aDZ() {
        return 1;
    }

    public boolean aEa() {
        List aBs = C8061k.aBs();
        if (aBs == null || aBs.isEmpty()) {
            return true;
        }
        Iterator it = aBs.iterator();
        boolean z = true;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            String str = (String) it.next();
            if (!TextUtils.isEmpty(str)) {
                String kC = C8061k.m23408kC(str);
                z = C7825a.PLATINUM_MONTHLY.getId().equals(kC) || C7825a.PLATINUM_YEARLY.getId().equals(kC);
                if (z) {
                    z = false;
                    break;
                }
            }
        }
        return z;
    }

    public void aEb() {
    }

    /* renamed from: aN */
    public void mo33022aN(Activity activity) {
        C8049f.aBf().mo33081a(activity, this.goodsId, null, new C9054a() {
            /* renamed from: a */
            public void mo32328a(PayResult payResult) {
            }
        });
        C7835b.m22848aB("Free_Trial_Cancel_Dialog_Click", "continue");
    }

    /* renamed from: aO */
    public void mo33023aO(Activity activity) {
    }

    /* renamed from: d */
    public void mo33024d(TextView textView) {
        textView.setTextSize(16.0f);
        textView.setTextColor(C8048e.aBe().getContext().getResources().getColor(R.color.color_333333));
    }

    /* renamed from: e */
    public void mo33025e(TextView textView) {
        textView.setTextSize(12.0f);
        textView.setTextColor(C8048e.aBe().getContext().getResources().getColor(R.color.color_666666));
    }

    /* renamed from: f */
    public boolean mo33026f(TextView textView) {
        textView.setVisibility(0);
        textView.setText(this.dUy ? R.string.xiaoying_str_vip_subscribe : R.string.xiaoying_str_continue_to_buy);
        textView.setGravity(17);
        textView.setTextSize(16.0f);
        textView.setTextColor(-1);
        textView.setPadding(0, 0, 0, 0);
        textView.setBackgroundResource(R.drawable.iap_ad_selector_btn_bg);
        LayoutParams layoutParams = (LayoutParams) textView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = -1;
            layoutParams.height = C7689a.m22599ii(48);
            layoutParams.leftMargin = C7689a.m22599ii(25);
            layoutParams.rightMargin = C7689a.m22599ii(25);
            textView.setLayoutParams(layoutParams);
        }
        return true;
    }

    /* renamed from: g */
    public boolean mo33027g(TextView textView) {
        textView.setVisibility(0);
        textView.setText(this.dUy ? R.string.xiaoying_str_com_cancel : R.string.xiaoying_str_iap_vip_pay_dialog_quit);
        Context context = C8048e.aBe().getContext();
        textView.setGravity(17);
        textView.setTextSize(14.0f);
        textView.setTextColor(context.getResources().getColor(R.color.color_999999));
        textView.setPadding(0, 0, 0, 0);
        textView.setBackgroundResource(R.color.transparent);
        LayoutParams layoutParams = (LayoutParams) textView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = -1;
            layoutParams.height = -2;
            layoutParams.topMargin = C7689a.m22599ii(12);
            layoutParams.leftMargin = C7689a.m22599ii(25);
            layoutParams.rightMargin = C7689a.m22599ii(25);
            textView.setLayoutParams(layoutParams);
        }
        return true;
    }

    public String getDescription() {
        Context context = C8048e.aBe().getContext();
        if (!this.dUy) {
            return context.getResources().getString(R.string.xiaoying_str_iap_vip_pay_dialog_description);
        }
        C7832c kw = C8045d.aAZ().mo33074kw(this.goodsId);
        int aCz = kw != null ? kw.aCz() : 0;
        return context.getResources().getQuantityString(R.plurals.xiaoying_str_vip_popup_free_trial_desc_pluals, aCz, new Object[]{String.valueOf(aCz)});
    }

    public String getTitle() {
        Context context = C8048e.aBe().getContext();
        return this.dUy ? context.getString(R.string.xiaoying_str_vip_popup_free_trial_title) : context.getString(R.string.xiaoying_str_iap_vip_pay_dialog_title);
    }
}
