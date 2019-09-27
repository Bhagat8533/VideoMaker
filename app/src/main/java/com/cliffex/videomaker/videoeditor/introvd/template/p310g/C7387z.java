package com.introvd.template.p310g;

import android.view.View;
import android.widget.TextView;
import com.introvd.template.common.ViewClickEffectMgr;
import com.quvideo.mobile.component.imageview.DynamicLoadingImageView;

/* renamed from: com.introvd.template.g.z */
public class C7387z {
    /* renamed from: a */
    public static void m21768a(DynamicLoadingImageView dynamicLoadingImageView, String str, int i) {
        dynamicLoadingImageView.setPlaceholderImage(i);
        dynamicLoadingImageView.setFailureImage(i);
        dynamicLoadingImageView.setImageURI(str);
    }

    /* renamed from: b */
    public static void m21769b(TextView textView, String str) {
        if (TtmlNode.BOLD.equals(str)) {
            textView.setTypeface(null, 1);
        } else {
            textView.setTypeface(null, 0);
        }
    }

    /* renamed from: b */
    public static void m21770b(DynamicLoadingImageView dynamicLoadingImageView, String str) {
        dynamicLoadingImageView.setImageURI(str);
    }

    /* renamed from: k */
    public static void m21771k(View view, boolean z) {
        view.setSelected(z);
    }

    /* renamed from: l */
    public static void m21772l(View view, boolean z) {
        if (z) {
            ViewClickEffectMgr.addEffectForViews(C7387z.class.getSimpleName(), view);
        }
    }
}
