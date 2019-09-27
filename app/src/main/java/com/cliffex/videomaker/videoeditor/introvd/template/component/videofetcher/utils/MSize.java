package com.introvd.template.component.videofetcher.utils;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class MSize implements Parcelable {
    public static final Creator<MSize> CREATOR = new Creator<MSize>() {
        /* renamed from: G */
        public MSize createFromParcel(Parcel parcel) {
            return new MSize(parcel);
        }

        /* renamed from: kh */
        public MSize[] newArray(int i) {
            return new MSize[i];
        }
    };
    public int height;
    public int width;

    public MSize() {
    }

    public MSize(int i, int i2) {
        this.width = i;
        this.height = i2;
    }

    private MSize(Parcel parcel) {
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
        MSize mSize = (MSize) obj;
        if (this.width != mSize.width) {
            return false;
        }
        if (this.height != mSize.height) {
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
