package com.introvd.template.gallery;

import com.aiii.android.arouter.facade.p094a.C1942a;
import com.introvd.template.gallery.p311a.C7390a;
import com.introvd.template.router.BizServiceManager;
import com.introvd.template.router.app.IAppService;
import com.introvd.template.router.lifecycle.BaseApplicationLifeCycle;

@C1942a(mo10417rZ = "/gallerySelf/GalleryAppLifeCycle")
public class GalleryAppLifeCycleImpl extends BaseApplicationLifeCycle {
    public void onCreate() {
        super.onCreate();
        IAppService iAppService = (IAppService) BizServiceManager.getService(IAppService.class);
        if (iAppService != null) {
            iAppService.registerAppConfigObserver(new C7390a());
        }
    }
}
