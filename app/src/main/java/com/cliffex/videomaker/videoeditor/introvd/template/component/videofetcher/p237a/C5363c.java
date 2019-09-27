package com.introvd.template.component.videofetcher.p237a;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import java.util.HashMap;

/* renamed from: com.introvd.template.component.videofetcher.a.c */
public final class C5363c {
    private static final HashMap<String, OnTouchListener> cdA = new HashMap<>();

    public static void addEffectForViews(String str, View... viewArr) {
        OnTouchListener onTouchListener = (OnTouchListener) cdA.get(str);
        if (onTouchListener == null) {
            onTouchListener = new OnTouchListener() {
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    switch (motionEvent.getAction()) {
                        case 0:
                        case 2:
                            view.setAlpha(0.4f);
                            break;
                        case 1:
                        case 3:
                            view.setAlpha(1.0f);
                            break;
                    }
                    return false;
                }
            };
            cdA.put(str, onTouchListener);
        }
        if (viewArr != null) {
            for (View view : viewArr) {
                if (view != null) {
                    view.setOnTouchListener(onTouchListener);
                }
            }
        }
    }
}
