package com.introvd.template.sdk.utils;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class VeMSize implements Parcelable {
    public static final Creator<VeMSize> CREATOR = new Creator<VeMSize>() {
        /* renamed from: N */
        public VeMSize createFromParcel(Parcel parcel) {
            return new VeMSize(parcel);
        }

        /* renamed from: uv */
        public VeMSize[] newArray(int i) {
            return new VeMSize[i];
        }
    };
    public int height;
    public int width;

    public VeMSize() {
    }

    public VeMSize(int i, int i2) {
        this.width = i;
        this.height = i2;
    }

    private VeMSize(Parcel parcel) {
        this.width = parcel.readInt();
        this.height = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        VeMSize veMSize = (VeMSize) obj;
        if (this.width != veMSize.width) {
            return false;
        }
        if (this.height != veMSize.height) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return (this.width * 31) + this.height;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("(width:");
        stringBuffer.append(this.width);
        stringBuffer.append(",height:");
        stringBuffer.append(this.height);
        stringBuffer.append(")");
        return stringBuffer.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.width);
        parcel.writeInt(this.height);
    }
}
