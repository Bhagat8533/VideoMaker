package com.introvd.template.sns;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public enum SnsType implements Parcelable {
    SNS_TYPE_LOCAL(0),
    SNS_TYPE_INSTAGRAM(1),
    SNS_TYPE_FACEBOOK(2);
    
    public static final Creator<SnsType> CREATOR = null;
    private int typeCode;

    static {
        CREATOR = new Creator<SnsType>() {
            public SnsType createFromParcel(Parcel parcel) {
                return SnsType.values()[parcel.readInt()];
            }

            public SnsType[] newArray(int i) {
                SnsType[] snsTypeArr = new SnsType[i];
                for (int i2 = 0; i2 < i; i2++) {
                    snsTypeArr[i2] = SnsType.SNS_TYPE_LOCAL;
                }
                return snsTypeArr;
            }
        };
    }

    private SnsType(int i) {
        this.typeCode = i;
    }

    public static SnsType getSnsType(int i) {
        switch (i) {
            case 0:
                return SNS_TYPE_LOCAL;
            case 1:
                return SNS_TYPE_INSTAGRAM;
            case 2:
                return SNS_TYPE_FACEBOOK;
            default:
                return SNS_TYPE_LOCAL;
        }
    }

    public int describeContents() {
        return 0;
    }

    public int getTypeCode() {
        return this.typeCode;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(ordinal());
    }
}
