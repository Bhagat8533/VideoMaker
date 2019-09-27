package com.introvd.template.datacenter.project;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

public class OldProjectItem {
    public int _id = -1;
    public double dPrjLatitude = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
    public double dPrjLongitude = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
    public int editStatus = 0;
    public String entrance;
    public int iCameraCode = 0;
    public int iIsDeleted = 0;
    public int iIsModified = 0;
    public int iPrjClipCount = 0;
    public int iPrjDuration = 0;
    public int iPrjGpsAccuracy = 0;
    public int nDurationLimit = 0;
    public int prjThemeType;
    public String strActivityData = null;
    public String strCoverURL = null;
    public String strCreateTime = null;
    public String strExtra = null;
    public String strModifyTime = null;
    public String strPrjAddress = null;
    public String strPrjAddressDetail = null;
    public String strPrjExportURL = null;
    public String strPrjThumbnail = null;
    public String strPrjTitle = null;
    public String strPrjURL = null;
    public String strPrjVersion = null;
    public String strVideoDesc = null;
    public int streamHeight = 0;
    public int streamWidth = 0;
    public int todoCode;
    public long usedEffectTempId = 0;
    public String videoTemplateInfo;
}
