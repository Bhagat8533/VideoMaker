package com.introvd.template.app.creation.testb;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

public abstract class AbstractCreationToolView extends LinearLayout {
    protected Context context;

    public AbstractCreationToolView(Context context2) {
        this(context2, null);
    }

    public AbstractCreationToolView(Context context2, AttributeSet attributeSet) {
        this(context2, attributeSet, 0);
    }

    public AbstractCreationToolView(Context context2, AttributeSet attributeSet, int i) {
        super(context2, attributeSet, i);
        this.context = context2;
        init();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo23319a(C3843b bVar, C3847d dVar) {
    }

    /* access modifiers changed from: protected */
    public abstract void init();
}
