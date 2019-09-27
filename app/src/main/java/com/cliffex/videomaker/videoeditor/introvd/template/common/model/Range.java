package com.introvd.template.common.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class Range implements Parcelable, Comparable<Range> {
    public static final Creator<Range> CREATOR = new Creator<Range>() {
        public Range createFromParcel(Parcel parcel) {
            return new Range(parcel);
        }

        public Range[] newArray(int i) {
            return new Range[i];
        }
    };
    private int mPosition;
    private int mTimeLength;

    public Range() {
    }

    public Range(int i, int i2) {
        this.mPosition = i;
        this.mTimeLength = i2;
    }

    private Range(Parcel parcel) {
        this.mPosition = parcel.readInt();
        this.mTimeLength = parcel.readInt();
    }

    public Range(Range range) {
        if (range != null) {
            this.mPosition = range.mPosition;
            this.mTimeLength = range.mTimeLength;
        }
    }

    public int compareTo(Range range) {
        if (range != null) {
            if (getmPosition() > range.getmPosition()) {
                return 1;
            }
            if (getmPosition() < range.getmPosition()) {
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
        if (!(obj instanceof Range)) {
            return false;
        }
        Range range = (Range) obj;
        if (range.getmPosition() == this.mPosition && range.getmTimeLength() == this.mTimeLength) {
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
