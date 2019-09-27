package com.introvd.template.sdk.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class VeRange implements Parcelable, Comparable<VeRange> {
    public static final Creator<VeRange> CREATOR = new Creator<VeRange>() {
        public VeRange createFromParcel(Parcel parcel) {
            return new VeRange(parcel);
        }

        public VeRange[] newArray(int i) {
            return new VeRange[i];
        }
    };
    private int mPosition;
    private int mTimeLength;

    public VeRange() {
    }

    public VeRange(int i, int i2) {
        this.mPosition = i;
        this.mTimeLength = i2;
    }

    private VeRange(Parcel parcel) {
        this.mPosition = parcel.readInt();
        this.mTimeLength = parcel.readInt();
    }

    public VeRange(VeRange veRange) {
        if (veRange != null) {
            this.mPosition = veRange.mPosition;
            this.mTimeLength = veRange.mTimeLength;
        }
    }

    public int compareTo(VeRange veRange) {
        if (veRange != null) {
            if (getmPosition() > veRange.getmPosition()) {
                return 1;
            }
            if (getmPosition() < veRange.getmPosition()) {
                return -1;
            }
        }
        return 0;
    }

    public boolean contains(int i) {
        return i >= this.mPosition && (i < getLimitValue() || this.mTimeLength < 0);
    }

    public boolean contains2(int i) {
        return i >= this.mPosition && (i <= getLimitValue() || this.mTimeLength < 0);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (!(obj instanceof VeRange)) {
            return false;
        }
        VeRange veRange = (VeRange) obj;
        if (veRange.getmPosition() == this.mPosition && veRange.getmTimeLength() == this.mTimeLength) {
            z = true;
        }
        return z;
    }

    public int getLimitValue() {
        if (this.mTimeLength == -1) {
            return Integer.MAX_VALUE;
        }
        return this.mPosition + this.mTimeLength;
    }

    public int getmPosition() {
        return this.mPosition;
    }

    public int getmTimeLength() {
        return this.mTimeLength;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public void setmPosition(int i) {
        this.mPosition = i;
    }

    public void setmTimeLength(int i) {
        this.mTimeLength = i;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        StringBuilder sb = new StringBuilder();
        sb.append("(mPosition:");
        sb.append(this.mPosition);
        sb.append(";mTimeLength:");
        sb.append(this.mTimeLength);
        sb.append(")");
        stringBuffer.append(sb.toString());
        return stringBuffer.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mPosition);
        parcel.writeInt(this.mTimeLength);
    }
}
