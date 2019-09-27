package com.introvd.template.editor.p266h;

import android.support.design.widget.TabLayout;
import android.view.View;
import android.view.ViewGroup;

/* renamed from: com.introvd.template.editor.h.n */
public class C6409n {
    /* renamed from: a */
    public static void m18455a(TabLayout tabLayout, Boolean bool) {
        ViewGroup b = m18456b(tabLayout);
        if (b != null) {
            for (int i = 0; i < b.getChildCount(); i++) {
                View childAt = b.getChildAt(i);
                if (childAt != null) {
                    childAt.setEnabled(bool.booleanValue());
                }
            }
        }
    }

    /* renamed from: b */
    private static ViewGroup m18456b(TabLayout tabLayout) {
        if (tabLayout != null && tabLayout.getChildCount() > 0) {
            View childAt = tabLayout.getChildAt(0);
            if (childAt != null && (childAt instanceof ViewGroup)) {
                return (ViewGroup) childAt;
            }
        }
        return null;
    }
}
