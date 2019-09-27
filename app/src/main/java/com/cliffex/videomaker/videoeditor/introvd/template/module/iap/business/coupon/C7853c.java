package com.introvd.template.module.iap.business.coupon;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.p021v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.introvd.template.module.iap.C8048e;
import com.introvd.template.module.iap.R;
import com.introvd.template.module.iap.business.dialog.C7893c;
import com.introvd.template.module.iap.business.home.C7958a;
import com.introvd.template.module.iap.utils.C8073a;
import java.util.Collections;
import java.util.List;

/* renamed from: com.introvd.template.module.iap.business.coupon.c */
public class C7853c extends C7893c {
    private View bkQ;
    /* access modifiers changed from: private */
    public View dQA;
    /* access modifiers changed from: private */
    public View dQB;
    private List<View> dQC;
    /* access modifiers changed from: private */
    public View dQD;
    /* access modifiers changed from: private */
    public C7846a dQE;
    /* access modifiers changed from: private */
    public C7856a dQF;

    /* renamed from: po */
    private OnClickListener f3558po = new OnClickListener() {
        public void onClick(View view) {
            if (C7853c.this.dQA.equals(view)) {
                C7853c.this.aCt().dismiss();
            } else if (C7853c.this.dQB.equals(view)) {
                if (C7853c.this.dQE == null || C7853c.this.dQE.isValid()) {
                    if (C7853c.this.dQF != null) {
                        C7853c.this.dQF.mo32672a(C7853c.this.dQD.isSelected() ? C7853c.this.dQE : null);
                    }
                    C7853c.this.aCt().dismiss();
                } else {
                    C7853c.this.aCt().dismiss();
                }
            } else if (C7853c.this.dQD.equals(view)) {
                C7853c.this.dQD.setSelected(!C7853c.this.dQD.isSelected());
            }
        }
    };

    /* renamed from: com.introvd.template.module.iap.business.coupon.c$a */
    public interface C7856a {
        /* renamed from: a */
        void mo32672a(C7846a aVar);
    }

    public C7853c(C7846a aVar, C7856a aVar2) {
        this.dQE = aVar;
        this.dQF = aVar2;
    }

    private void aCi() {
        if (this.bkQ != null) {
            this.dQA = this.bkQ.findViewById(R.id.iv_coupon_cancel);
            this.dQA.setOnClickListener(this.f3558po);
            this.dQB = this.bkQ.findViewById(R.id.tv_coupon_ok);
            this.dQB.setOnClickListener(this.f3558po);
        }
    }

    /* renamed from: d */
    private List<View> m22904d(Context context, ViewGroup viewGroup) {
        return Collections.singletonList(LayoutInflater.from(context).inflate(R.layout.iap_vip_view_dialog_coupon_chosen_item, viewGroup, false));
    }

    /* renamed from: db */
    private void m22905db(View view) {
        boolean z;
        TextView textView = (TextView) view.findViewById(R.id.tv_coupon_notice);
        List aCa = this.dQE.aCa();
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i2 >= aCa.size()) {
                z = false;
                break;
            } else if (C7958a.m23119ly((String) aCa.get(i2))) {
                z = true;
                break;
            } else {
                i2++;
            }
        }
        if (!z) {
            i = 8;
        }
        textView.setVisibility(i);
    }

    @SuppressLint({"SetTextI18n"})
    /* renamed from: iF */
    private void m22910iF(boolean z) {
        if (this.dQC != null && !this.dQC.isEmpty()) {
            int i = 0;
            View view = (View) this.dQC.get(0);
            if (view != null) {
                TextView textView = (TextView) view.findViewById(R.id.tv_coupon_title);
                TextView textView2 = (TextView) view.findViewById(R.id.tv_coupon_time);
                this.dQD = view.findViewById(R.id.tv_coupon_select);
                this.dQD.setSelected(z);
                this.dQD.setOnClickListener(this.f3558po);
                final TextView textView3 = (TextView) view.findViewById(R.id.tv_coupon_content);
                if (this.dQE != null) {
                    textView.setText(this.dQE.name);
                    Context context = C8048e.aBe().getContext();
                    StringBuilder sb = new StringBuilder();
                    sb.append(context.getString(R.string.xiaoying_str_iap_coupon_chosen_time_prefix));
                    sb.append(this.dQE.aCb());
                    textView2.setText(sb.toString());
                    textView3.setText(this.dQE.mo32774sp(14));
                    textView3.post(new Runnable() {
                        public void run() {
                            textView3.setTextSize((float) C8073a.m23430h(textView3));
                        }
                    });
                    m22905db(view);
                    View findViewById = view.findViewById(R.id.tv_coupon_unavailable_tip);
                    if (this.dQE.isValid()) {
                        this.dQD.setVisibility(0);
                        textView3.setBackgroundResource(R.drawable.iap_vip_icon_coupon_bg);
                        textView.setTextColor(ContextCompat.getColor(context, R.color.black));
                        textView2.setTextColor(ContextCompat.getColor(context, R.color.color_999999));
                    } else {
                        this.dQD.setVisibility(8);
                        this.dQD.setSelected(false);
                        textView3.setBackgroundResource(R.drawable.iap_vip_icon_unavailable_coupon_bg);
                        textView.setTextColor(ContextCompat.getColor(context, R.color.color_999999));
                        textView2.setTextColor(ContextCompat.getColor(context, R.color.color_c9c9c9));
                    }
                    if (this.dQE.aCd()) {
                        i = 8;
                    }
                    findViewById.setVisibility(i);
                }
            }
        }
    }

    /* renamed from: a */
    public void mo32782a(C7846a aVar, boolean z) {
        this.dQE = aVar;
        m22910iF(z);
    }

    /* renamed from: b */
    public View mo32634b(Context context, ViewGroup viewGroup) {
        if (this.bkQ == null) {
            this.bkQ = LayoutInflater.from(context).inflate(R.layout.iap_vip_view_dialog_coupon_header, viewGroup, false);
            aCi();
        }
        return this.bkQ;
    }

    /* renamed from: c */
    public List<View> mo32635c(Context context, ViewGroup viewGroup) {
        if (this.dQC == null) {
            this.dQC = m22904d(context, viewGroup);
            m22910iF(true);
        }
        return this.dQC;
    }
}
