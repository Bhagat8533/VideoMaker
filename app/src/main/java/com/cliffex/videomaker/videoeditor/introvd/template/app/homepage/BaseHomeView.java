package com.introvd.template.app.homepage;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

public abstract class BaseHomeView extends RelativeLayout {
    public BaseHomeView(Context context) {
        super(context);
    }

    public BaseHomeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public BaseHomeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public abstract void init(int i);

    public abstract void onActivityResult(int i, int i2, Intent intent);

    public abstract void onDestroy();

    public abstract void onPause();

    public abstract void onResume();
}
