package com.introvd.template.router.app.device;

import com.introvd.template.router.BizServiceManager;

public class DeviceUserProxy {
    public static void deviceLogin(DeviceLoginCallback deviceLoginCallback) {
        IDeviceUserService iDeviceUserService = (IDeviceUserService) BizServiceManager.getService(IDeviceUserService.class);
        if (iDeviceUserService == null) {
            if (deviceLoginCallback != null) {
                deviceLoginCallback.onResult();
            }
            return;
        }
        iDeviceUserService.deviceLogin(deviceLoginCallback);
    }

    public static String getDeviceToken() {
        IDeviceUserService iDeviceUserService = (IDeviceUserService) BizServiceManager.getService(IDeviceUserService.class);
        if (iDeviceUserService == null || iDeviceUserService.getDeviceUserInfo() == null) {
            return null;
        }
        return iDeviceUserService.getDeviceUserInfo().token;
    }

    public static String getDuid() {
        IDeviceUserService iDeviceUserService = (IDeviceUserService) BizServiceManager.getService(IDeviceUserService.class);
        if (iDeviceUserService == null || iDeviceUserService.getDeviceUserInfo() == null) {
            return null;
        }
        return iDeviceUserService.getDeviceUserInfo().deviceId;
    }

    public static long getDuidLong() {
        IDeviceUserService iDeviceUserService = (IDeviceUserService) BizServiceManager.getService(IDeviceUserService.class);
        if (iDeviceUserService == null || iDeviceUserService.getDeviceUserInfo() == null) {
            return -1;
        }
        return iDeviceUserService.getDeviceUserInfo().duid;
    }

    public static String getOpenDUID() {
        IDeviceUserService iDeviceUserService = (IDeviceUserService) BizServiceManager.getService(IDeviceUserService.class);
        if (iDeviceUserService == null) {
            return null;
        }
        return iDeviceUserService.getOpenDUID();
    }

    public static DeviceUserInfo getUserInfo() {
        IDeviceUserService iDeviceUserService = (IDeviceUserService) BizServiceManager.getService(IDeviceUserService.class);
        if (iDeviceUserService == null) {
            return null;
        }
        return iDeviceUserService.getDeviceUserInfo();
    }
}
