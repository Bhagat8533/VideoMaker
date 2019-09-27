package com.introvd.template.sdk.model.editor;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.introvd.template.sdk.p391g.C8450a;

public class EffectInfoModel implements Parcelable, Cloneable {
    public static final Creator<EffectInfoModel> CREATOR = new Creator<EffectInfoModel>() {
        public EffectInfoModel createFromParcel(Parcel parcel) {
            return new EffectInfoModel(parcel);
        }

        public EffectInfoModel[] newArray(int i) {
            EffectInfoModel[] effectInfoModelArr = new EffectInfoModel[i];
            for (int i2 = 0; i2 < i; i2++) {
                effectInfoModelArr[i2] = null;
            }
            return effectInfoModelArr;
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
    public String strSceneName;

    public EffectInfoModel() {
        this.mType = "";
        this.mTCID = "";
        this.mFavorite = 0;
        this.strSceneName = "";
        this.isDownloaded = false;
        this.bNeedDownload = false;
        this.isDownloading = false;
        this.bHasEditText = false;
        this.mUrl = "";
        this.mConfigureCount = 1;
        this.mName = "";
        this.mPath = null;
    }

    public EffectInfoModel(long j, String str) {
        this.mType = "";
        this.mTCID = "";
        this.mFavorite = 0;
        this.strSceneName = "";
        this.isDownloaded = false;
        this.bNeedDownload = false;
        this.isDownloading = false;
        this.bHasEditText = false;
        this.mUrl = "";
        this.mConfigureCount = 1;
        this.mTemplateId = j;
        this.mPath = str;
    }

    protected EffectInfoModel(Parcel parcel) {
        this.mType = "";
        this.mTCID = "";
        boolean z = false;
        this.mFavorite = 0;
        this.strSceneName = "";
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

    public EffectInfoModel clone() {
        try {
            return (EffectInfoModel) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
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

    public boolean isNoneTheme() {
        return C8450a.m24468bm(this.mTemplateId);
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
