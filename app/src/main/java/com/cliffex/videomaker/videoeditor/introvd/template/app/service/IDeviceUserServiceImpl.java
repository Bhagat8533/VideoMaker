package com.introvd.template.app.service;

import android.content.Context;
import com.aiii.android.arouter.facade.p094a.C1942a;
import com.introvd.template.VivaBaseApplication;
import com.introvd.template.origin.device.C8119a;
import com.introvd.template.p203b.C4585f;
import com.introvd.template.router.app.device.DeviceLoginCallback;
import com.introvd.template.router.app.device.DeviceLoginObserver;
import com.introvd.template.router.app.device.DeviceUserInfo;
import com.introvd.template.router.app.device.IDeviceUserService;

@C1942a(mo10417rZ = "/IAppServiceRouter/IDeviceUserService")
public class IDeviceUserServiceImpl implements IDeviceUserService {
    public void deviceLogin(DeviceLoginCallback deviceLoginCallback) {
        C8119a.deviceLogin(deviceLoginCallback);
    }

    public DeviceUserInfo getDeviceUserInfo() {
        return C8119a.getDeviceUserInfo();
    }

    public String getOpenDUID() {
        return C4585f.m11688dG(VivaBaseApplication.m8749FZ());
    }

    public void init(Context context) {
    }

    public void registerObserver(DeviceLoginObserver deviceLoginObserver) {
        C8119a.registerObserver(deviceLoginObserver);
    }
}
