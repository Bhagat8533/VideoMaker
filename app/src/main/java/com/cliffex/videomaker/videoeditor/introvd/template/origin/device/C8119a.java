package com.introvd.template.origin.device;

import android.content.Context;
import com.introvd.template.router.app.device.DeviceLoginCallback;
import com.introvd.template.router.app.device.DeviceLoginObserver;
import com.introvd.template.router.app.device.DeviceUserInfo;

/* renamed from: com.introvd.template.origin.device.a */
public class C8119a {
    public static void deviceLogin(DeviceLoginCallback deviceLoginCallback) {
        C8138f.aEW().deviceLogin(deviceLoginCallback);
    }

    public static DeviceUserInfo getDeviceUserInfo() {
        return C8138f.aEW().aEY();
    }

    public static void init(Context context) {
        C8138f.aEW().init(context);
    }

    public static void registerObserver(DeviceLoginObserver deviceLoginObserver) {
        C8138f.aEW().registerObserver(deviceLoginObserver);
    }
}
