package com.introvd.template.module.p326ad.p332f;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import com.introvd.template.module.ad.R;
import com.introvd.template.module.p326ad.p327a.C7589a;

/* renamed from: com.introvd.template.module.ad.f.a */
public final class C7641a {
    /* renamed from: go */
    public static View m22445go(Context context) {
        final View adView = C7589a.getAdView(context, 47);
        if (adView == null) {
            return null;
        }
        View inflate = LayoutInflater.from(context).inflate(R.layout.iap_ad_view_splash_for_c, null);
        ((RelativeLayout) inflate.findViewById(R.id.rl_ad_container)).addView(adView);
        inflate.findViewById(R.id.tv_ad_cta).setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (!adView.performClick()) {
                    adView.dispatchTouchEvent(MotionEvent.obtain(0, 0, 0, 0.0f, 0.0f, 0));
                }
            }
        });
        return inflate;
    }
}
