package com.cliffex.videomaker.videoeditor.intromaker;

import android.app.Activity;
import android.view.View;

public class BaseActivity extends Activity {
    public <T extends View> T findViewById(String id) {
        return findViewById(getResources().getIdentifier(id, "id", getPackageName()));
    }

    public void setContentView(String layout) {
        setContentView(getResources().getIdentifier(layout, "layout", getPackageName()));
    }
}
