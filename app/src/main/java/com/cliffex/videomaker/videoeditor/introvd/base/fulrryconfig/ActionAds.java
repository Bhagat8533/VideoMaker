package com.introvd.base.fulrryconfig;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import com.introvd.base.utlisads.CrashAll;

public class ActionAds {
    public static void ActionAds(final Activity activity) {
        ((ImageButton) activity.findViewById(ToolsAll.findViewId(activity, "btnAds"))).setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                CrashAll.loadAndshow(activity, "las_gift");
            }
        });
    }

    public static void ActionMoreApps(final Activity activity) {
        ((ImageButton) activity.findViewById(ToolsAll.findViewId(activity, "btnMoreApp"))).setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                RemotesMoreApp.showMoreApp(activity);
            }
        });
    }
}
