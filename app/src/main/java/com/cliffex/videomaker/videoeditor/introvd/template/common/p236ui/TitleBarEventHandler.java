package com.introvd.template.common.p236ui;

import android.app.Activity;
import android.view.View;

/* renamed from: com.introvd.template.common.ui.TitleBarEventHandler */
public class TitleBarEventHandler {
    public void onBtnBackClick(View view) {
        if (view.getContext() instanceof Activity) {
            ((Activity) view.getContext()).finish();
        }
    }
}
