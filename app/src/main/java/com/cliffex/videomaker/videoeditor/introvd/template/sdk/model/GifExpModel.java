package com.introvd.template.sdk.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.introvd.template.sdk.utils.VeMSize;

public class GifExpModel implements Parcelable {
    public static final Creator<GifExpModel> CREATOR = new Creator<GifExpModel>() {
        public GifExpModel createFromParcel(Parcel parcel) {
            return new GifExpModel(parcel);
        }

        public GifExpModel[] newArray(int i) {
            return new GifExpModel[i];
        }
    };
    public int expFps = 0;
    public VeMSize expSize;
    public VeRange mExpVeRange;

    public GifExpModel() {
    }

    protected GifExpModel(Parcel parcel) {
        this.expSize = (VeMSize) parcel.readParcelable(VeMSize.class.getClassLoader());
        this.expFps = parcel.readInt();
        this.mExpVeRange = (VeRange) parcel.readParcelable(VeRange.class.getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.expSize, i);
        parcel.writeInt(this.expFps);
        parcel.writeParcelable(this.mExpVeRange, i);
    }
}
