package com.introvd.template.common.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

public class LocationInfo implements Parcelable {
    public static final Creator<LocationInfo> CREATOR = new Creator<LocationInfo>() {
        public LocationInfo createFromParcel(Parcel parcel) {
            return new LocationInfo(parcel);
        }

        public LocationInfo[] newArray(int i) {
            return new LocationInfo[i];
        }
    };
    public static final int TYPE_COARSE_LOCATION = 1;
    public static final int TYPE_FINE_LOCATION = 0;
    public int mAccuracy;
    public String mAddressStr;
    public String mAddressStrDetail;
    public String mCity;
    public String mCountry;
    public double mLatitude = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
    public double mLongitude = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
    public String mPOI;
    public String mProvince;
    public int mType;

    public LocationInfo() {
    }

    public LocationInfo(double d, double d2, String str, String str2, int i, int i2) {
        this.mLatitude = d;
        this.mLongitude = d2;
        this.mAddressStr = str;
        this.mAddressStrDetail = str2;
        this.mType = i;
        this.mAccuracy = i2;
    }

    protected LocationInfo(Parcel parcel) {
        this.mLatitude = parcel.readDouble();
        this.mLongitude = parcel.readDouble();
        this.mPOI = parcel.readString();
        this.mAddressStr = parcel.readString();
        this.mCity = parcel.readString();
        this.mProvince = parcel.readString();
        this.mCountry = parcel.readString();
        this.mAddressStrDetail = parcel.readString();
        this.mType = parcel.readInt();
        this.mAccuracy = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeDouble(this.mLatitude);
        parcel.writeDouble(this.mLongitude);
        parcel.writeString(this.mPOI);
        parcel.writeString(this.mAddressStr);
        parcel.writeString(this.mCity);
        parcel.writeString(this.mProvince);
        parcel.writeString(this.mCountry);
        parcel.writeString(this.mAddressStrDetail);
        parcel.writeInt(this.mType);
        parcel.writeInt(this.mAccuracy);
    }
}
