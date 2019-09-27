package com.introvd.template.module.iap.business;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.support.p024v7.widget.RecyclerView;
import android.support.p024v7.widget.RecyclerView.C1008a;
import android.support.p024v7.widget.RecyclerView.C1034u;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.StrikethroughSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.introvd.template.module.iap.R;
import com.introvd.template.module.iap.business.coupon.C7846a;
import com.introvd.template.module.iap.business.coupon.C7858e;

/* renamed from: com.introvd.template.module.iap.business.h */
class C7944h extends C1008a<C7994i> {
    private static final int dQg = R.layout.iap_vip_recycle_item_renew_purchase_info;
    private Activity activity;
    private RecyclerView ama;
    private C7894e dPD;
    /* access modifiers changed from: private */
    public C7946a dPI;
    /* access modifiers changed from: private */
    public int dQh;

    /* renamed from: com.introvd.template.module.iap.business.h$a */
    interface C7946a {
        /* renamed from: q */
        void mo32683q(String str, boolean z);
    }

    C7944h(Activity activity2, C7894e eVar, C7946a aVar) {
        this.activity = activity2;
        this.dPI = aVar;
        this.dPD = eVar;
    }

    @SuppressLint({"SetTextI18n"})
    /* renamed from: a */
    private void m23088a(C7994i iVar, C7896b bVar, int i) {
        boolean z = false;
        if (bVar == null) {
            iVar.itemView.findViewById(R.id.fl_cover).setVisibility(0);
            iVar.itemView.findViewById(R.id.ll_vip_item_container).setVisibility(8);
            iVar.itemView.findViewById(R.id.tv_label).setVisibility(8);
            return;
        }
        iVar.itemView.findViewById(R.id.fl_cover).setVisibility(8);
        iVar.itemView.findViewById(R.id.ll_vip_item_container).setVisibility(0);
        ((TextView) iVar.mo32994n(R.id.tv_title)).setText(bVar.title);
        TextView textView = (TextView) iVar.mo32994n(R.id.tv_current_price);
        if (bVar.dQa != null) {
            bVar.dQa = bVar.dQa.replace("￥", "");
        }
        textView.setText(bVar.dQa);
        TextView textView2 = (TextView) iVar.mo32994n(R.id.tv_previous_price);
        if (TextUtils.isEmpty(bVar.dQb)) {
            textView2.setVisibility(4);
        } else {
            SpannableString spannableString = new SpannableString(bVar.dQb);
            spannableString.setSpan(new StrikethroughSpan(), 0, spannableString.length(), 33);
            textView2.setText(spannableString);
            textView2.setVisibility(0);
        }
        TextView textView3 = (TextView) iVar.mo32994n(R.id.tv_label);
        if (TextUtils.isEmpty(bVar.label)) {
            textView3.setVisibility(8);
        } else {
            textView3.setVisibility(0);
            textView3.setText(bVar.label);
        }
        TextView textView4 = (TextView) iVar.mo32994n(R.id.tv_coupon_content);
        C7846a kW = C7858e.m22920kW(bVar.f3560id);
        if (kW == null) {
            textView4.setVisibility(8);
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(kW.aCc());
            sb.append(this.activity.getString(R.string.xiaoying_str_iap_coupon_item_tag_suffix));
            textView4.setText(sb.toString());
            textView4.setVisibility(0);
        }
        View n = iVar.mo32994n(R.id.ll_vip_item_container);
        n.setTag(Integer.valueOf(i));
        n.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (view.getTag() instanceof Integer) {
                    C7944h.this.dQh = ((Integer) view.getTag()).intValue();
                    if (C7944h.this.dPI != null) {
                        C7944h.this.dPI.mo32683q(C7944h.this.aBU(), true);
                        C7944h.this.m23091so(C7944h.this.dQh);
                    }
                }
            }
        });
        if (this.dQh == i) {
            z = true;
        }
        n.setSelected(z);
    }

    /* access modifiers changed from: private */
    /* renamed from: so */
    public void m23091so(int i) {
        if (this.ama != null) {
            int i2 = 0;
            while (i2 < getItemCount()) {
                C1034u cg = this.ama.mo7776cg(i);
                if (cg != null) {
                    cg.itemView.setSelected(i == i2);
                }
                i2++;
            }
        }
    }

    /* renamed from: V */
    public C7994i onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new C7994i(LayoutInflater.from(this.activity).inflate(dQg, viewGroup, false));
    }

    /* renamed from: a */
    public void onBindViewHolder(C7994i iVar, int i) {
        C7896b sl = this.dPD.mo32846sl(i);
        C7896b kN = this.dPD.mo32836kN(sl != null ? sl.f3560id : null);
        if (kN != null) {
            sl = kN;
        }
        m23088a(iVar, sl, i);
    }

    /* access modifiers changed from: 0000 */
    public String aBU() {
        return this.dPD.mo32847sm(this.dQh);
    }

    /* access modifiers changed from: 0000 */
    public String aBV() {
        return this.dPD.mo32837kO(aBU());
    }

    public int getItemCount() {
        return Math.min(this.dPD.getSize(), 3);
    }

    public int getItemViewType(int i) {
        return 0;
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.ama = recyclerView;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: t */
    public void mo32907t(String str, boolean z) {
        this.dPD.mo32844r(str, z);
        notifyDataSetChanged();
    }

    public void update(String str) {
        this.dQh = this.dPD.mo32841kT(str);
        C7896b sl = this.dPD.mo32846sl(this.dQh);
        if (!(sl == null || sl.f3560id == null)) {
            this.dPI.mo32683q(sl.f3560id, false);
        }
        notifyDataSetChanged();
    }
}
