package com.introvd.template.editor.preview.model;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ClipItemInfo implements Parcelable {
    public static final Creator<ClipItemInfo> CREATOR = new Creator<ClipItemInfo>() {
        public ClipItemInfo createFromParcel(Parcel parcel) {
            return new ClipItemInfo(parcel);
        }

        public ClipItemInfo[] newArray(int i) {
            return new ClipItemInfo[i];
        }
    };
    public boolean bAudioEnable;
    public boolean bAudioOn;
    public boolean bFocus;
    public boolean bSelected;
    public Bitmap bmpThumbnail;
    public boolean isGif;
    public boolean isImage;
    public boolean isVideo;
    public long lDuration;
    public long lTransDuration;
    public int state = -1;

    public ClipItemInfo() {
    }

    protected ClipItemInfo(Parcel parcel) {
        this.bmpThumbnail = (Bitmap) parcel.readParcelable(Bitmap.class.getClassLoader());
        boolean z = false;
        this.isVideo = parcel.readByte() != 0;
        this.isGif = parcel.readByte() != 0;
        this.isImage = parcel.readByte() != 0;
        this.lDuration = parcel.readLong();
        this.lTransDuration = parcel.readLong();
        this.bAudioEnable = parcel.readByte() != 0;
        this.bAudioOn = parcel.readByte() != 0;
        this.state = parcel.readInt();
        this.bSelected = parcel.readByte() != 0;
        if (parcel.readByte() != 0) {
            z = true;
        }
        this.bFocus = z;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.bmpThumbnail, i);
        parcel.writeByte(this.isVideo ? (byte) 1 : 0);
        parcel.writeByte(this.isGif ? (byte) 1 : 0);
        parcel.writeByte(this.isImage ? (byte) 1 : 0);
        parcel.writeLong(this.lDuration);
        parcel.writeLong(this.lTransDuration);
        parcel.writeByte(this.bAudioEnable ? (byte) 1 : 0);
        parcel.writeByte(this.bAudioOn ? (byte) 1 : 0);
        parcel.writeInt(this.state);
        parcel.writeByte(this.bSelected ? (byte) 1 : 0);
        parcel.writeByte(this.bFocus ? (byte) 1 : 0);
    }
}
