package com.introvd.base.utlisads;

import android.app.Activity;
import android.os.Bundle;
import funtion.one.App;
import videoeditor.videomaker.slowmotions.starsleap.R;

public class Main2Activity extends Activity {
    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.dimen.abc_action_bar_content_inset_with_nav);
        CrashAll.loadAndshow(this, "las_param");
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
