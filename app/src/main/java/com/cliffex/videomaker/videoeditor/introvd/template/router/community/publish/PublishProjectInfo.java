package com.introvd.template.router.community.publish;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

public class PublishProjectInfo {
    public long _id = -1;
    public double dPrjLatitude = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
    public double dPrjLongitude = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
    public int iPrjGpsAccuracy = 0;
    public long prjId;
    public String strPrjAddress = "";
    public String strPrjAddressDetail = "";
}
