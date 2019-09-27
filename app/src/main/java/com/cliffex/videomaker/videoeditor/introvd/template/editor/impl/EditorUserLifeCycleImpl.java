package com.introvd.template.editor.impl;

import com.aiii.android.arouter.facade.p094a.C1942a;
import com.introvd.template.VivaBaseApplication;
import com.introvd.template.common.model.AppStateModel;
import com.introvd.template.editor.p252e.C5879b;
import com.introvd.template.router.user.BaseUserLifeCycle;
import com.introvd.template.template.p409g.C8762d;
import p037b.p050b.p076j.C1820a;

@C1942a(mo10417rZ = "/XYVideoEditor/EditorUserLifeCycle")
public class EditorUserLifeCycleImpl extends BaseUserLifeCycle {
    /* access modifiers changed from: private */
    public void asyncTask() {
        C8762d.aMt().uninit();
        C8762d.aMt().mo35219Q(VivaBaseApplication.m8749FZ(), AppStateModel.getInstance().isInChina());
        C5879b.m16422fe(VivaBaseApplication.m8749FZ());
    }

    public void onLogoutSuccess() {
        super.onLogoutSuccess();
        C1820a.aVi().mo10058o(new Runnable() {
            public void run() {
                EditorUserLifeCycleImpl.this.asyncTask();
            }
        });
    }
}
