package com.introvd.template.explorer;

import com.aiii.android.arouter.facade.p094a.C1942a;
import com.introvd.template.explorer.p296a.C7137b;
import com.introvd.template.router.BizServiceManager;
import com.introvd.template.router.app.IAppService;
import com.introvd.template.router.lifecycle.BaseApplicationLifeCycle;

@C1942a(mo10417rZ = "/ExplorerSelf/AppLifeCycle")
public class ExplorerAppLiftCycleImpl extends BaseApplicationLifeCycle {
    public void onCreate() {
        super.onCreate();
        IAppService iAppService = (IAppService) BizServiceManager.getService(IAppService.class);
        if (iAppService != null) {
            iAppService.registerAppConfigObserver(new C7137b());
        }
    }
}
