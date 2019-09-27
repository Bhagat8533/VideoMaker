package com.introvd.template.router.lifecycle;

import com.aiii.android.arouter.p091c.C1919a;
import com.introvd.template.router.AppRouter;
import com.introvd.template.router.community.VivaCommunityRouter;
import com.introvd.template.router.editor.EditorRouter;
import com.introvd.template.router.editor.gallery.GalleryRouter;
import com.introvd.template.router.explorer.ExplorerRouter;
import com.introvd.template.router.iap.IapRouter;
import com.introvd.template.router.user.BaseUserLifeCycle;
import com.introvd.template.router.user.UserRouter;
import java.util.ArrayList;
import java.util.List;

public class LifeCycleConstant {
    private static String[] appOBs = {AppRouter.PROXY_APPLICATION, UserRouter.PROXY_APPLICATION, EditorRouter.PROXY_MAIN_APP, GalleryRouter.PROXY_MAIN_APP, VivaCommunityRouter.PROXY_APPLICATION, ExplorerRouter.PROXY_APPLICATION};
    private static String[] mainActivityOBs = {UserRouter.PROXY_MAIN_ACTIVITY, EditorRouter.PROXY_MAIN_ACTIVITY, VivaCommunityRouter.PROXY_MAIN_ACTIVITY, AppRouter.PROXY_MAIN_ACTIVITY};
    private static String[] mainUserLifeCycles = {VivaCommunityRouter.PROXY_USER_LIFECYCLE, AppRouter.PROXY_USER_LIFECYCLE, EditorRouter.PROXY_USER, IapRouter.PROXY_USER_LIFECYCLE};

    static List<BaseApplicationLifeCycle> getApplicationObserveList() {
        ArrayList arrayList = new ArrayList();
        for (String al : appOBs) {
            BaseApplicationLifeCycle baseApplicationLifeCycle = (BaseApplicationLifeCycle) C1919a.m5529sc().mo10355al(al).mo10412rX();
            if (baseApplicationLifeCycle != null) {
                arrayList.add(baseApplicationLifeCycle);
            }
        }
        return arrayList;
    }

    static List<BaseMainActivityLifeCycle> getMainActivityObserveList() {
        ArrayList arrayList = new ArrayList();
        for (String al : mainActivityOBs) {
            BaseMainActivityLifeCycle baseMainActivityLifeCycle = (BaseMainActivityLifeCycle) C1919a.m5529sc().mo10355al(al).mo10412rX();
            if (baseMainActivityLifeCycle != null) {
                arrayList.add(baseMainActivityLifeCycle);
            }
        }
        return arrayList;
    }

    public static List<BaseUserLifeCycle> getUserLifeCycleObList() {
        ArrayList arrayList = new ArrayList();
        for (String al : mainUserLifeCycles) {
            BaseUserLifeCycle baseUserLifeCycle = (BaseUserLifeCycle) C1919a.m5529sc().mo10355al(al).mo10412rX();
            if (baseUserLifeCycle != null) {
                arrayList.add(baseUserLifeCycle);
            }
        }
        return arrayList;
    }
}
