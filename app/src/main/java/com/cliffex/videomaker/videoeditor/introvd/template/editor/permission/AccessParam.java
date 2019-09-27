package com.introvd.template.editor.permission;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class AccessParam implements Parcelable {
    public static final Creator<AccessParam> CREATOR = new Creator<AccessParam>() {
        /* renamed from: I */
        public AccessParam createFromParcel(Parcel parcel) {
            return new AccessParam(parcel);
        }

        /* renamed from: nN */
        public AccessParam[] newArray(int i) {
            return new AccessParam[i];
        }
    };
    public String cVW = "";
    public String cVX = "";

    protected AccessParam(Parcel parcel) {
        this.cVW = parcel.readString();
        this.cVX = parcel.readString();
    }

    public AccessParam(String str) {
        this.cVW = str;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.cVW);
        parcel.writeString(this.cVX);
    }
}
