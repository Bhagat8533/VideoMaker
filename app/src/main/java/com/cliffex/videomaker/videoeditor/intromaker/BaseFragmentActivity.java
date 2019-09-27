package com.cliffex.videomaker.videoeditor.intromaker;

import android.view.View;
import androidx.fragment.app.FragmentActivity;

public class BaseFragmentActivity extends FragmentActivity {
    public <T extends View> T findViewById(String id) {
        return findViewById(getResources().getIdentifier(id, "id", getPackageName()));
    }

    public void setContentView(String layout) {
        setContentView(getResources().getIdentifier(layout, "layout", getPackageName()));
    }
}
