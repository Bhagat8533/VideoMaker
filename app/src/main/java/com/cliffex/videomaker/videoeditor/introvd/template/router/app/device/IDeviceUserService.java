package com.introvd.template.router.app.device;

import com.aiii.android.arouter.facade.template.C1949c;

public interface IDeviceUserService extends C1949c {
    public static final String SERVICE_NAME = "/IAppServiceRouter/IDeviceUserService";

    void deviceLogin(DeviceLoginCallback deviceLoginCallback);

    DeviceUserInfo getDeviceUserInfo();

    String getOpenDUID();

    void registerObserver(DeviceLoginObserver deviceLoginObserver);
}
