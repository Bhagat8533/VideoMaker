package com.introvd.template.app.utils;

import android.graphics.Color;
import android.widget.TextView;

/* renamed from: com.introvd.template.app.utils.f */
public class C4407f {
    /* renamed from: a */
    public static void m11131a(TextView textView, String str) {
        try {
            textView.setTextColor(Color.parseColor(str));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
