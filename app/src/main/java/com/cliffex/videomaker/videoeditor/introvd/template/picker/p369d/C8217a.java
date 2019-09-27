package com.introvd.template.picker.p369d;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.view.View;

/* renamed from: com.introvd.template.picker.d.a */
public class C8217a {
    /* renamed from: dm */
    public static ObjectAnimator m23731dm(View view) {
        return ObjectAnimator.ofPropertyValuesHolder(view, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat("scaleX", new float[]{1.2f, 0.8f, 1.0f}), PropertyValuesHolder.ofFloat("scaleY", new float[]{1.2f, 0.8f, 1.0f}), PropertyValuesHolder.ofFloat("alpha", new float[]{1.0f, 0.0f, 1.0f})}).setDuration(400);
    }
}
