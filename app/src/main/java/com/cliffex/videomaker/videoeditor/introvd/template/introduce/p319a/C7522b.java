package com.introvd.template.introduce.p319a;

import android.view.View;
import android.view.View.OnClickListener;
import com.introvd.template.router.todoCode.TODOParamModel;

/* renamed from: com.introvd.template.introduce.a.b */
class C7522b implements OnClickListener {
    private final C7521b dLM;
    private final TODOParamModel dLN;

    public C7522b(C7521b bVar, TODOParamModel tODOParamModel) {
        this.dLM = bVar;
        this.dLN = tODOParamModel;
    }

    public void onClick(View view) {
        this.dLM.m22239a(this.dLN, view);
    }
}
