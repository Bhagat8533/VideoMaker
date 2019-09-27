package com.introvd.template.editor.clipedit.transition;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class TransitionInfo implements Parcelable {
    public static final Creator<TransitionInfo> CREATOR = new Creator<TransitionInfo>() {
        /* renamed from: H */
        public TransitionInfo createFromParcel(Parcel parcel) {
            return new TransitionInfo(parcel);
        }

        /* renamed from: lu */
        public TransitionInfo[] newArray(int i) {
            return new TransitionInfo[i];
        }
    };
    public long cCN;
    public int cCO = 1;
    public String name = "";
    public String path = "";
    public int progress = 0;
    public int state = 0;
    public String thumbUrl;
    public String url = "";

    public TransitionInfo() {
    }

    protected TransitionInfo(Parcel parcel) {
        this.cCN = parcel.readLong();
        this.name = parcel.readString();
        this.path = parcel.readString();
        this.thumbUrl = parcel.readString();
        this.cCO = parcel.readInt();
        this.state = parcel.readInt();
        this.url = parcel.readString();
        this.progress = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.cCN);
        parcel.writeString(this.name);
        parcel.writeString(this.path);
        parcel.writeString(this.thumbUrl);
        parcel.writeInt(this.cCO);
        parcel.writeInt(this.state);
        parcel.writeString(this.url);
        parcel.writeInt(this.progress);
    }
}
