package com.introvd.template.explorer.music.p306d;

import android.app.Activity;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

/* renamed from: com.introvd.template.explorer.music.d.a */
public class C7273a {
    public static String dCz = "";

    /* renamed from: a */
    public static void m21456a(EditText editText) {
        if (editText != null && editText.getContext() != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) editText.getContext().getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.showSoftInput(editText, 0);
            }
        }
    }

    /* renamed from: av */
    public static void m21457av(Activity activity) {
        if (activity != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) activity.getApplicationContext().getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.hideSoftInputFromWindow(activity.getWindow().getDecorView().getWindowToken(), 0);
            }
        }
    }

    /* renamed from: b */
    public static boolean m21458b(EditText editText) {
        if (editText == null || editText.getContext() == null) {
            return false;
        }
        InputMethodManager inputMethodManager = (InputMethodManager) editText.getContext().getSystemService("input_method");
        if (inputMethodManager == null) {
            return false;
        }
        return inputMethodManager.isActive(editText);
    }
}
