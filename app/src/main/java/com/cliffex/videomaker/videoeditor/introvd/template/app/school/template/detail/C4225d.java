package com.introvd.template.app.school.template.detail;

import android.view.View;
import android.view.View.OnClickListener;
import com.introvd.template.app.school.api.model.TemplateInfo;

/* renamed from: com.introvd.template.app.school.template.detail.d */
class C4225d implements OnClickListener {
    private final C4224a bzn;
    private final TemplateInfo bzo;

    public C4225d(C4224a aVar, TemplateInfo templateInfo) {
        this.bzn = aVar;
        this.bzo = templateInfo;
    }

    public void onClick(View view) {
        this.bzn.m10579a(this.bzo, view);
    }
}
