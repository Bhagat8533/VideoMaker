package com.introvd.template.module.p326ad;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager.BadTokenException;
import android.widget.TextView;
import com.introvd.template.ads.AdParamMgr;
import com.introvd.template.common.ToastUtils;
import com.introvd.template.module.p326ad.p328b.C7592b;
import com.introvd.template.module.p326ad.p334h.C7662c;

/* renamed from: com.introvd.template.module.ad.n */
public class C7684n extends Dialog implements OnClickListener {
    private Context context;
    private TextView dMw;
    private View dMx;
    private View dMy;

    public C7684n(Context context2) {
        super(context2, R.style.vivavideo_iap_dialog_com_style);
        this.context = context2;
        initUI();
    }

    private void initUI() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.iap_ad_dialog_remove_ad_layout, null);
        this.dMy = inflate.findViewById(R.id.dialog_remove_ad_close);
        this.dMy.setOnClickListener(this);
        Integer V = C7588a.m22357V(AdParamMgr.getExtraInfoByKey(42, "availabletime"));
        if (V == null || V.intValue() <= 0) {
            V = Integer.valueOf(1);
        }
        this.dMw = (TextView) inflate.findViewById(R.id.dialog_remove_ad_video_reward);
        this.dMw.setText(getContext().getString(R.string.xiaoying_str_remove_day_for_free, new Object[]{V.toString()}));
        this.dMw.setOnClickListener(this);
        this.dMx = inflate.findViewById(R.id.dialog_remove_ad_purchase);
        if (C7678j.aAd().mo23619Mk() || C7678j.aAd().isInChina()) {
            this.dMx.setVisibility(0);
            this.dMx.setOnClickListener(this);
        } else {
            this.dMx.setVisibility(8);
        }
        setContentView(inflate);
    }

    /* renamed from: iv */
    private void m22542iv(boolean z) {
        if (!z) {
            this.dMw.setVisibility(8);
        } else {
            this.dMw.setVisibility(0);
        }
    }

    public void onClick(View view) {
        if (view.equals(this.dMy) || C7678j.aAd().mo23644bB(true)) {
            String str = "close";
            if (view.equals(this.dMw)) {
                str = "video";
                C7590b.m22365gh(getContext());
            } else if (view.equals(this.dMx)) {
                str = "vip";
                C7590b.m22366gi(getContext());
            }
            C7592b.m22382kj(str);
            dismiss();
            return;
        }
        ToastUtils.show(getContext(), R.string.xiaoying_str_com_msg_network_inactive, 1);
    }

    public void show() {
        C7592b.m22381ki(C7662c.aAA().getString("key_pref_remove_ad_from", "unknown"));
        m22542iv(C7680l.aAe().isAdAvailable(this.context, 42));
        try {
            super.show();
        } catch (BadTokenException e) {
            C7678j.aAd().logException(e);
        }
    }
}
