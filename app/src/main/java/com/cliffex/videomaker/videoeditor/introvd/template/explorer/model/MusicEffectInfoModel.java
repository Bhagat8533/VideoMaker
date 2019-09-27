package com.introvd.template.explorer.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class MusicEffectInfoModel implements Parcelable {
    public static final Creator<MusicEffectInfoModel> CREATOR = new Creator<MusicEffectInfoModel>() {
        public MusicEffectInfoModel createFromParcel(Parcel parcel) {
            return new MusicEffectInfoModel(parcel);
        }

        public MusicEffectInfoModel[] newArray(int i) {
            MusicEffectInfoModel[] musicEffectInfoModelArr = new MusicEffectInfoModel[i];
            for (int i2 = 0; i2 < i; i2++) {
                musicEffectInfoModelArr[i2] = null;
            }
            return musicEffectInfoModelArr;
        }
    };
    public boolean bHasEditText;
    private boolean bNeedDownload;
    private boolean isDownloaded;
    private boolean isDownloading;
    private int mConfigureCount;
    public int mFavorite;
    public String mName;
    public String mPath;
    public String mTCID;
    public long mTemplateId;
    public String mThumbUrl;
    public String mType;
    private String mUrl;

    public MusicEffectInfoModel() {
        this.mType = "";
        this.mTCID = "";
        this.mFavorite = 0;
        this.isDownloaded = false;
        this.bNeedDownload = false;
        this.isDownloading = false;
        this.bHasEditText = false;
        this.mUrl = "";
        this.mConfigureCount = 1;
        this.mName = "";
        this.mPath = null;
    }

    public MusicEffectInfoModel(long j, String str) {
        this.mType = "";
        this.mTCID = "";
        this.mFavorite = 0;
        this.isDownloaded = false;
        this.bNeedDownload = false;
        this.isDownloading = false;
        this.bHasEditText = false;
        this.mUrl = "";
        this.mConfigureCount = 1;
        this.mTemplateId = j;
        this.mPath = str;
    }

    protected MusicEffectInfoModel(Parcel parcel) {
        this.mType = "";
        this.mTCID = "";
        boolean z = false;
        this.mFavorite = 0;
        this.isDownloaded = false;
        this.bNeedDownload = false;
        this.isDownloading = false;
        this.bHasEditText = false;
        this.mUrl = "";
        this.mConfigureCount = 1;
        this.mTemplateId = parcel.readLong();
        this.mName = parcel.readString();
        this.mPath = parcel.readString();
        this.mType = parcel.readString();
        this.mTCID = parcel.readString();
        this.mFavorite = parcel.readInt();
        this.isDownloaded = parcel.readByte() != 0;
        this.bNeedDownload = parcel.readByte() != 0;
        this.isDownloading = parcel.readByte() != 0;
        if (parcel.readByte() != 0) {
            z = true;
        }
        this.bHasEditText = z;
        this.mUrl = parcel.readString();
        this.mConfigureCount = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public int getmConfigureCount() {
        return this.mConfigureCount;
    }

    public String getmUrl() {
        return this.mUrl;
    }

    public boolean isDownloaded() {
        return this.isDownloaded;
    }

    public boolean isDownloading() {
        return this.isDownloading;
    }

    public boolean isbNeedDownload() {
        return this.bNeedDownload;
    }

    public void setDownloaded(boolean z) {
        this.isDownloaded = z;
    }

    public void setDownloading(boolean z) {
        this.isDownloading = z;
    }

    public void setbNeedDownload(boolean z) {
        this.bNeedDownload = z;
    }

    public void setmConfigureCount(int i) {
        this.mConfigureCount = i;
    }

    public void setmUrl(String str) {
        this.mUrl = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.mTemplateId);
        parcel.writeString(this.mName);
        parcel.writeString(this.mPath);
        parcel.writeString(this.mType);
        parcel.writeString(this.mTCID);
        parcel.writeInt(this.mFavorite);
        parcel.writeByte(this.isDownloaded ? (byte) 1 : 0);
        parcel.writeByte(this.bNeedDownload ? (byte) 1 : 0);
        parcel.writeByte(this.isDownloading ? (byte) 1 : 0);
        parcel.writeByte(this.bHasEditText ? (byte) 1 : 0);
        parcel.writeString(this.mUrl);
        parcel.writeInt(this.mConfigureCount);
    }
}
