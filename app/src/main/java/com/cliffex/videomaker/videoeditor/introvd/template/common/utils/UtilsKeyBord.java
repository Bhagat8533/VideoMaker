package com.introvd.template.common.utils;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

public class UtilsKeyBord {
    public static void hideKeyBoard(Context context, View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}
