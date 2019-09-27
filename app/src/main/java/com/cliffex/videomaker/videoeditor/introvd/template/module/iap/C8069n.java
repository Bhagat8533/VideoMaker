package com.introvd.template.module.iap;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.introvd.template.module.p339c.C7689a;

/* renamed from: com.introvd.template.module.iap.n */
public class C8069n {
    /* renamed from: a */
    public static void m23424a(TextView textView, View view) {
        view.setVisibility(8);
        textView.setVisibility(0);
        textView.setText(R.string.xiaoying_str_iap_unlock_template_list);
    }

    /* renamed from: da */
    public static void m23425da(View view) {
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            int aR = C7689a.m22597aR(30.0f);
            new RelativeLayout.LayoutParams(aR, aR).addRule(13, -1);
            return;
        }
        layoutParams.width = C7689a.m22597aR(30.0f);
        layoutParams.height = C7689a.m22597aR(30.0f);
    }
}
