package com.introvd.template.app;

import com.aiii.android.arouter.facade.p094a.C1942a;
import com.introvd.template.app.p190j.C4025b;
import com.introvd.template.app.p190j.C4026c;
import com.introvd.template.app.school.p198db.C4175a;
import com.introvd.template.common.AppPreferencesSetting;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.common.UserBehaviorLog;
import com.introvd.template.common.model.AppStateModel;
import com.introvd.template.crash.C5523b;
import com.introvd.template.origin.device.C8119a;
import com.introvd.template.origin.p364a.C8113b;
import com.introvd.template.p203b.C4580b;
import com.introvd.template.router.lifecycle.BaseApplicationLifeCycle;
import com.p131c.p132a.C2561a;
import com.p131c.p132a.p135c.C2586c;
import com.p131c.p132a.p135c.C2586c.C2587a;
import p037b.p050b.p076j.C1820a;

@C1942a(mo10417rZ = "/app/application")
public class AppApplicationLifeCycleImpl extends BaseApplicationLifeCycle {
    public void onCreate() {
        super.onCreate();
        C3999i.init(getApplication());
        C4029l.init(getApplication());
        C2586c.m7415a(new C2587a() {
            /* renamed from: e */
            public void mo12859e(Exception exc) {
                LogUtilsV2.m14229e("VivaError", exc);
                C5523b.logException(exc);
            }
        });
        C3885h.m9561Hs();
        C1820a.aVi().mo10058o(new Runnable() {
            public void run() {
                if (C2561a.aOR() == 4) {
                    AppPreferencesSetting.getInstance().setAppSettingBoolean("home_help_show_flag", false);
                }
            }
        });
        C8113b.m23501a(new C4025b());
        C8119a.registerObserver(new C4026c());
        C1820a.aVi().mo10058o(new Runnable() {
            public void run() {
                C4175a.m10395NW().mo24018cG(BaseApplicationLifeCycle.getApplication());
            }
        });
        UserBehaviorLog.setUserProperty(AppStateModel.getInstance().getCountryCode(), C4580b.m11635Si());
    }
}
