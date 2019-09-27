package com.introvd.base.utlisads;

import android.app.Activity;
import android.os.Bundle;
import android.supportin.annotation.Nullable;
import funtion.one.App;

public class SplashActivity extends Activity {
    /* access modifiers changed from: protected */
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(ToolsUtils.getIdLayout(this, "activity_splash"));
        App.onResume();
        CrashAll.init(this);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        App.onResume();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        App.onPause();
    }
}
