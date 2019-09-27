package com.introvd.template.picker;

import android.arch.lifecycle.C0061e.C0062a;
import android.arch.lifecycle.C0068f;
import android.arch.lifecycle.C0078n;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.introvd.template.common.LogUtilsV2;

public abstract class AbstractPickerView extends RelativeLayout implements C0068f {
    public AbstractPickerView(Context context) {
        this(context, null);
    }

    public AbstractPickerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AbstractPickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    @C0078n(mo161n = C0062a.ON_ANY)
    public void onActivityAny() {
        LogUtilsV2.m14230i(">>> onActivityAny...");
    }

    /* access modifiers changed from: protected */
    @C0078n(mo161n = C0062a.ON_CREATE)
    public void onActivityCreate() {
        LogUtilsV2.m14230i(">>> onActivityCreate...");
    }

    /* access modifiers changed from: protected */
    @C0078n(mo161n = C0062a.ON_DESTROY)
    public void onActivityDestory() {
        LogUtilsV2.m14230i(">>> onActivityDestory...");
    }

    /* access modifiers changed from: protected */
    @C0078n(mo161n = C0062a.ON_PAUSE)
    public void onActivityPause() {
        LogUtilsV2.m14230i(">>> onActivityPause...");
    }

    /* access modifiers changed from: protected */
    @C0078n(mo161n = C0062a.ON_RESUME)
    public void onActivityResume() {
        LogUtilsV2.m14230i(">>> onActivityResume...");
    }

    /* access modifiers changed from: protected */
    @C0078n(mo161n = C0062a.ON_START)
    public void onActivityStart() {
        LogUtilsV2.m14230i(">>> onActivityStart...");
    }

    /* access modifiers changed from: protected */
    @C0078n(mo161n = C0062a.ON_STOP)
    public void onActivityStop() {
        LogUtilsV2.m14230i(">>> onActivityStop...");
    }
}
