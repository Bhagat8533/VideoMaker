package com.introvd.template.editor.p266h;

import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;

/* renamed from: com.introvd.template.editor.h.r */
public class C6414r {
    /* renamed from: f */
    public static void m18458f(View view, int i, int i2, int i3, int i4) {
        View view2 = (View) view.getParent();
        final View view3 = view;
        final int i5 = i;
        final int i6 = i2;
        final int i7 = i3;
        final int i8 = i4;
        C64151 r1 = new Runnable() {
            public void run() {
                Rect rect = new Rect();
                view3.setEnabled(true);
                view3.getHitRect(rect);
                rect.top -= i5;
                rect.bottom += i6;
                rect.left -= i7;
                rect.right += i8;
                TouchDelegate touchDelegate = new TouchDelegate(rect, view3);
                if (View.class.isInstance(view3.getParent())) {
                    ((View) view3.getParent()).setTouchDelegate(touchDelegate);
                }
            }
        };
        view2.post(r1);
    }
}
