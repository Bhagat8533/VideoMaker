package com.introvd.template.app;

import com.aiii.android.arouter.facade.p094a.C1942a;
import com.introvd.template.VivaBaseApplication;
import com.introvd.template.app.p176a.C3677b;
import com.introvd.template.app.p176a.C3678c;
import com.introvd.template.app.p177b.C3742b;
import com.introvd.template.app.p177b.C3748e;
import com.introvd.template.app.utils.C4395c;
import com.introvd.template.app.youngermode.C4545a;
import com.introvd.template.common.model.AppStateModel;
import com.introvd.template.p363o.C8092b;
import com.introvd.template.router.lbs.LbsManagerProxy;
import com.introvd.template.router.lifecycle.BaseMainActivityLifeCycle;
import com.vivavideo.component.permission.C9295b;
import p037b.p050b.p076j.C1820a;

@C1942a(mo10417rZ = "/app/main_activity")
public class AppMainActivityLifeCycleImpl extends BaseMainActivityLifeCycle {
    public void onCreate() {
        super.onCreate();
        final VivaBaseApplication FZ = VivaBaseApplication.m8749FZ();
        C3748e.m9193JX().mo23192JY();
        if (C9295b.m26985b(FZ, C8092b.dXw)) {
            LbsManagerProxy.init(FZ, AppStateModel.getInstance().isInChina());
        }
        C1820a.aVi().mo10058o(new Runnable() {
            public void run() {
                C3678c.m8974bW(FZ);
                C3677b.m8970bV(FZ);
            }
        });
        C1820a.aVi().mo10058o(new Runnable() {
            public void run() {
                C4395c.m11080Q(AppMainActivityLifeCycleImpl.this.getActivity());
            }
        });
        if (AppStateModel.getInstance().isInChina() && C3742b.m9111II().mo23151JS()) {
            C4545a.m11476RG();
        }
    }

    public void onResume() {
        super.onResume();
    }
}
