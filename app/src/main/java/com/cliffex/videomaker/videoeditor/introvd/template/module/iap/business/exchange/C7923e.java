package com.introvd.template.module.iap.business.exchange;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.introvd.template.module.iap.C8048e;
import com.introvd.template.module.iap.R;
import com.introvd.template.module.iap.business.exchange.C7916c.C7920a;

/* renamed from: com.introvd.template.module.iap.business.exchange.e */
public class C7923e {
    /* access modifiers changed from: private */
    public static C7927a dSG;

    /* renamed from: com.introvd.template.module.iap.business.exchange.e$a */
    public interface C7927a {
        /* renamed from: c */
        void mo23257c(boolean z, String str);
    }

    /* renamed from: a */
    public static void m23057a(C7927a aVar) {
        dSG = aVar;
    }

    /* renamed from: s */
    public static View m23058s(final ViewGroup viewGroup) {
        if (viewGroup == null) {
            return null;
        }
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.iap_vip_include_exchange_only_vivacoin, viewGroup, false);
        inflate.findViewById(R.id.iv_answer).setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                C8048e.aBe().mo23608K((Activity) viewGroup.getContext());
            }
        });
        ((TextView) inflate.findViewById(R.id.tv_available_days)).setText(viewGroup.getContext().getString(R.string.iap_vip_privilege_vivacoin_desc_days, new Object[]{String.valueOf(C7916c.aCW().mo32880sz(2))}));
        inflate.findViewById(R.id.tv_exchange).setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                C7916c.aCW().mo32875a(2, (C7920a) new C7920a() {
                    /* renamed from: a */
                    public void mo32574a(C7922d dVar) {
                        if (C7923e.dSG != null) {
                            C7923e.dSG.mo23257c(dVar.aDa(), dVar.message);
                        }
                    }
                });
            }
        });
        return inflate;
    }

    public static void unregister() {
        dSG = null;
    }
}
