package com.introvd.template.router.performance;

import android.app.Application;
import com.introvd.template.router.BizServiceManager;

public class PerformanceServiceProxy {
    public static void checkFirebasePerfDisable(boolean z) {
        IReleasePerfService iReleasePerfService = (IReleasePerfService) BizServiceManager.getService(IReleasePerfService.class);
        if (iReleasePerfService != null) {
            iReleasePerfService.checkFirebasePerfDisable(z);
        }
    }

    public static boolean getFakeGoogle() {
        ITestFuncService iTestFuncService = (ITestFuncService) BizServiceManager.getService(ITestFuncService.class);
        if (iTestFuncService != null) {
            return iTestFuncService.getFakeGoogle();
        }
        return false;
    }

    public static void initAopPerfManager() {
        IAopPerfService iAopPerfService = (IAopPerfService) BizServiceManager.getService(IAopPerfService.class);
        if (iAopPerfService != null) {
            iAopPerfService.initAopPerfManager();
        }
    }

    public static void initLeakCanary(Application application, boolean z) {
        ISmokeTPerfService iSmokeTPerfService = (ISmokeTPerfService) BizServiceManager.getService(ISmokeTPerfService.class);
        if (iSmokeTPerfService != null) {
            iSmokeTPerfService.initLeakCanary(application, z);
        }
    }

    public static void initTXMatrixManager(Application application) {
        ITestFuncService iTestFuncService = (ITestFuncService) BizServiceManager.getService(ITestFuncService.class);
        if (iTestFuncService != null) {
            iTestFuncService.initTXMatrixManager(application);
        }
    }

    public static boolean setFakeGoogle(boolean z) {
        ITestFuncService iTestFuncService = (ITestFuncService) BizServiceManager.getService(ITestFuncService.class);
        if (iTestFuncService == null) {
            return false;
        }
        iTestFuncService.setFakeGoogle(z);
        return true;
    }
}
