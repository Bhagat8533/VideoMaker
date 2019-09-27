package com.introvd.template.template.p408f;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import com.introvd.template.module.iap.C8048e;
import com.introvd.template.module.iap.C8049f;
import com.introvd.template.module.iap.C8072q;
import com.introvd.template.module.iap.business.p349a.C7825a;
import com.introvd.template.module.p326ad.C7680l;
import com.introvd.template.module.p326ad.p337i.C7675d;
import com.introvd.template.p203b.C4583d;
import com.introvd.template.template.R;

/* renamed from: com.introvd.template.template.f.b */
public final class C8747b {
    /* renamed from: H */
    private static void m25571H(View view, int i) {
        int i2;
        int i3;
        int i4;
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.encourage_template_root_layout);
        if (relativeLayout != null) {
            if (i != 1) {
                if (i != 9) {
                    switch (i) {
                        case 3:
                        case 6:
                            break;
                        case 5:
                            break;
                        default:
                            i2 = 0;
                            i4 = 0;
                            i3 = 0;
                            break;
                    }
                }
                i3 = C4583d.m11671P(8.0f);
                i2 = 0;
                i4 = 0;
                relativeLayout.setPadding(i2, i3, i4, 0);
            }
            i2 = C4583d.m11671P(8.0f);
            i4 = C4583d.m11671P(8.0f);
            i3 = C4583d.m11671P(8.0f);
            relativeLayout.setPadding(i2, i3, i4, 0);
        }
    }

    /* renamed from: a */
    public static View m25572a(final Activity activity, final int i, int i2) {
        if (!aMk() || C7680l.aAe().getAdView(activity, i) == null) {
            return null;
        }
        View inflate = LayoutInflater.from(activity).inflate(R.layout.v5_xiaoying_encourage_template_top_layout, null);
        inflate.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (!activity.isFinishing()) {
                    C8049f.aBf().mo33100g(activity, i, C7825a.ALL_TEMPLATE.getId());
                }
            }
        });
        m25571H(inflate, i2);
        return inflate;
    }

    public static boolean aMk() {
        if ((C8048e.aBe().mo23619Mk() && !C8048e.aBe().isInChina()) && C7675d.m22507kq(C7825a.ALL_TEMPLATE.getId())) {
            return true;
        }
        return C8072q.aBx().mo33070i(C7825a.AD.getId(), C7825a.ALL_TEMPLATE.getId());
    }
}
