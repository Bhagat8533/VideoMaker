package com.introvd.template.app.p199v5.common.p200ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.HorizontalScrollView;
import com.introvd.template.common.behavior.UserBehaviorUtils;
import com.ironsource.sdk.constants.Constants.ParametersKeys;

/* renamed from: com.introvd.template.app.v5.common.ui.EventHorizontalScrollView */
public class EventHorizontalScrollView extends HorizontalScrollView {
    private String bFs;
    private String bFt;
    private int bFu = -1;

    public EventHorizontalScrollView(Context context) {
        super(context);
    }

    public EventHorizontalScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public EventHorizontalScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        this.bFu = -1;
        if (!z) {
            this.bFt = ParametersKeys.ORIENTATION_NONE;
        } else if (i == 0) {
            this.bFt = TtmlNode.LEFT;
        } else {
            this.bFt = TtmlNode.RIGHT;
        }
        super.onOverScrolled(i, i2, z, z2);
    }

    /* access modifiers changed from: protected */
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.bFu == i3) {
            UserBehaviorUtils.recordMonContentScroll(getContext(), this.bFs, this.bFt);
        } else {
            this.bFs = i3 > i ? TtmlNode.RIGHT : TtmlNode.LEFT;
        }
        this.bFu = i3;
    }
}
