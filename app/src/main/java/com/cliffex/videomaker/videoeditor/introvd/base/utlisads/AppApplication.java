package com.introvd.base.utlisads;

import android.app.Application;
import com.facebook.ads.AudienceNetworkAds;

public class AppApplication extends Application {
    public void onCreate() {
        super.onCreate();
        AudienceNetworkAds.initialize(this);
    }
}
