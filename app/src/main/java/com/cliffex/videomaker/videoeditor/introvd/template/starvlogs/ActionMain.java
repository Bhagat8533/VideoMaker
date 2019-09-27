package com.introvd.template.starvlogs;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.introvd.base.utlisads.CrashAll;

public class ActionMain {
    public static void actionButtonAds(final Activity activity) {
        ((LinearLayout) activity.findViewById(ToolsUtils.findViewId(activity, "btn_ads"))).setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                CrashAll.loadAndshow(activity, "las_btn_ads_tab_editor");
            }
        });
    }
}
