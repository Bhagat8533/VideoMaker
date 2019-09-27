package com.introvd.template.mid.lbs.google;

import android.content.Context;
import android.content.Intent;
import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.p021v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import com.aiii.android.arouter.facade.p094a.C1942a;
import com.introvd.template.common.AppPreferencesSetting;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.mid.lbs.AbsLbsManager;
import com.introvd.template.router.lbs.LbsRouter;
import com.introvd.template.router.lbs.LocationInfo;
import java.util.List;

@C1942a(mo10417rZ = "/lbs/google_lbs_mgr")
public class GoogleLbsManager extends AbsLbsManager {
    private static final int MIN_LBS_DISTANCE_DIFF = 500;
    private static final int MIN_LBS_TIME_DIFF = 900000;
    private Context mContext = null;
    private long mLastLBSTimestamp = 0;
    private LocationInfo mLocationInfo = null;
    private LocationListener mLocationListener = null;
    private LocationManager mLocationManager = null;
    private String mStrBestProvider = null;
    /* access modifiers changed from: private */
    public boolean mbAutoStop = false;

    /* access modifiers changed from: private */
    public void fillLocationInfo(double d, double d2) {
        try {
            List fromLocation = new Geocoder(this.mContext).getFromLocation(d, d2, 1);
            if (fromLocation != null && !fromLocation.isEmpty()) {
                Address address = (Address) fromLocation.get(0);
                this.mLocationInfo.mCountry = address.getCountryName();
                this.mLocationInfo.mProvince = address.getAdminArea();
                this.mLocationInfo.mCity = address.getLocality();
                String str = "";
                for (int i = 0; i < address.getMaxAddressLineIndex(); i++) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(str);
                    sb.append(address.getAddressLine(i));
                    str = sb.toString();
                }
                this.mLocationInfo.mAddressStr = address.getFeatureName();
                this.mLocationInfo.mAddressStrDetail = str;
                this.mLocationInfo.mLatitude = d;
                this.mLocationInfo.mLongitude = d2;
                AppPreferencesSetting instance = AppPreferencesSetting.getInstance();
                if (!TextUtils.isEmpty(this.mLocationInfo.mCountry)) {
                    instance.setAppSettingStr("key_location_cache_country", this.mLocationInfo.mCountry);
                }
                if (!TextUtils.isEmpty(this.mLocationInfo.mProvince)) {
                    instance.setAppSettingStr("key_location_cache_province", this.mLocationInfo.mProvince);
                }
                if (!TextUtils.isEmpty(this.mLocationInfo.mCity)) {
                    instance.setAppSettingStr("key_location_cache_city", this.mLocationInfo.mCity);
                }
                if (!TextUtils.isEmpty(this.mLocationInfo.mAddressStr)) {
                    instance.setAppSettingStr("key_location_cache_poi", this.mLocationInfo.mAddressStr);
                }
                notifyLocationUpdate();
            }
        } catch (Exception unused) {
        }
    }

    public LocationInfo getCurrentLocation() {
        if (this.mLocationManager == null || this.mStrBestProvider == null) {
            return null;
        }
        return this.mLocationInfo;
    }

    public void init(Context context) {
    }

    public boolean initLbs(Context context) {
        if (this.mLocationManager == null) {
            this.mLocationManager = (LocationManager) context.getSystemService("location");
            this.mContext = context.getApplicationContext();
        }
        if (this.mLocationInfo == null) {
            this.mLocationInfo = new LocationInfo();
        }
        return this.mLocationManager != null;
    }

    public boolean isAutoStop() {
        return this.mbAutoStop;
    }

    public void notifyLocationUpdate() {
        LocalBroadcastManager.getInstance(this.mContext).sendBroadcast(new Intent(LbsRouter.INTENT_ACTION_LBS_UPDATE));
    }

    public boolean recordLocation(boolean z, boolean z2) {
        if (this.mLocationManager == null) {
            return false;
        }
        if (z) {
            if (this.mLocationListener != null || this.mLastLBSTimestamp + 900000 >= System.currentTimeMillis()) {
                return false;
            }
            Criteria criteria = new Criteria();
            criteria.setAccuracy(2);
            criteria.setPowerRequirement(1);
            criteria.setAltitudeRequired(false);
            criteria.setSpeedRequired(false);
            criteria.setBearingRequired(false);
            criteria.setCostAllowed(false);
            this.mStrBestProvider = this.mLocationManager.getBestProvider(criteria, true);
            if (this.mStrBestProvider == null) {
                this.mStrBestProvider = "gps";
            }
            this.mLocationListener = new LocationListener() {
                public void onLocationChanged(Location location) {
                    LogUtilsV2.m14228e("onLocationChanged");
                    if (location != null) {
                        GoogleLbsManager.this.fillLocationInfo(location.getLatitude(), location.getLongitude());
                        StringBuilder sb = new StringBuilder();
                        sb.append("getLatitude:");
                        sb.append(location.getLatitude());
                        sb.append(" getLongitude");
                        sb.append(location.getLongitude());
                        LogUtilsV2.m14228e(sb.toString());
                        if (GoogleLbsManager.this.mbAutoStop) {
                            GoogleLbsManager.this.recordLocation(false, false);
                        }
                    }
                }

                public void onProviderDisabled(String str) {
                    LogUtilsV2.m14228e("onProviderDisabled");
                }

                public void onProviderEnabled(String str) {
                    LogUtilsV2.m14228e("onProviderEnabled");
                }

                public void onStatusChanged(String str, int i, Bundle bundle) {
                    LogUtilsV2.m14228e("onStatusChanged");
                }
            };
            try {
                this.mLocationManager.requestLocationUpdates(this.mStrBestProvider, 900000, 500.0f, this.mLocationListener);
            } catch (SecurityException e) {
                e.printStackTrace();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } else if (this.mLocationListener != null) {
            try {
                this.mLocationManager.removeUpdates(this.mLocationListener);
                this.mLocationListener = null;
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
        return true;
    }

    public void resetLocation() {
        this.mLocationInfo = new LocationInfo();
    }

    public void setAutoStop(boolean z) {
        this.mbAutoStop = z;
    }

    public void uninit() {
        recordLocation(false, false);
        this.mLocationManager = null;
    }
}
