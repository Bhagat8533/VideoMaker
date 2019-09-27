package com.introvd.template.sdk.editor.cache;

import android.graphics.Bitmap;
import android.graphics.RectF;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.introvd.template.sdk.model.VeRange;
import com.introvd.template.sdk.utils.VeMSize;

public class TrimedClipItemDataModel implements Parcelable {
    public static final Creator<TrimedClipItemDataModel> CREATOR = new Creator<TrimedClipItemDataModel>() {
        /* renamed from: M */
        public TrimedClipItemDataModel createFromParcel(Parcel parcel) {
            return new TrimedClipItemDataModel(parcel);
        }

        /* renamed from: ub */
        public TrimedClipItemDataModel[] newArray(int i) {
            return new TrimedClipItemDataModel[i];
        }
    };
    public Boolean bCrop = Boolean.valueOf(false);
    public Boolean bCropFeatureEnable = Boolean.valueOf(true);
    private Boolean bIsReverseMode = Boolean.valueOf(false);
    public boolean bNeedTranscode = false;
    public RectF cropRect = null;
    public String digitalWaterMarkCode = "";
    private Boolean isClipReverse = Boolean.valueOf(false);
    public Boolean isExported = Boolean.valueOf(false);
    public Boolean isImage = Boolean.valueOf(false);
    private String mClipReverseFilePath;
    public String mEffectPath = "";
    public int mEncType = 0;
    public String mExportPath = "";
    public String mRawFilePath = "";
    public Integer mRotate = Integer.valueOf(0);
    public VeMSize mStreamSizeVe = null;
    public Long mThumbKey = Long.valueOf(0);
    public Bitmap mThumbnail = null;
    public VeRange mTrimVeRange = null;
    public VeRange mVeRangeInRawVideo = null;
    public Integer repeatCount = Integer.valueOf(1);

    public TrimedClipItemDataModel() {
    }

    protected TrimedClipItemDataModel(Parcel parcel) {
        this.mRawFilePath = parcel.readString();
        this.mExportPath = parcel.readString();
        this.mVeRangeInRawVideo = (VeRange) parcel.readParcelable(VeRange.class.getClassLoader());
        this.isExported = (Boolean) parcel.readValue(Boolean.class.getClassLoader());
        this.mThumbKey = (Long) parcel.readValue(Long.class.getClassLoader());
        this.mStreamSizeVe = (VeMSize) parcel.readParcelable(VeMSize.class.getClassLoader());
        this.bCropFeatureEnable = (Boolean) parcel.readValue(Boolean.class.getClassLoader());
        this.mRotate = (Integer) parcel.readValue(Integer.class.getClassLoader());
        this.bCrop = (Boolean) parcel.readValue(Boolean.class.getClassLoader());
        this.cropRect = (RectF) parcel.readParcelable(RectF.class.getClassLoader());
        this.isImage = (Boolean) parcel.readValue(Boolean.class.getClassLoader());
        this.mClipReverseFilePath = parcel.readString();
        this.bIsReverseMode = (Boolean) parcel.readValue(Boolean.class.getClassLoader());
        this.isClipReverse = (Boolean) parcel.readValue(Boolean.class.getClassLoader());
        this.digitalWaterMarkCode = parcel.readString();
        this.repeatCount = (Integer) parcel.readValue(Integer.class.getClassLoader());
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
        TrimedClipItemDataModel trimedClipItemDataModel = (TrimedClipItemDataModel) obj;
        if (this.mRawFilePath != null) {
            z = this.mRawFilePath.equals(trimedClipItemDataModel.mRawFilePath);
        } else if (trimedClipItemDataModel.mRawFilePath != null) {
            z = false;
        }
        return z;
    }

    public String getmClipReverseFilePath() {
        return this.mClipReverseFilePath;
    }

    public int hashCode() {
        if (this.mRawFilePath != null) {
            return this.mRawFilePath.hashCode();
        }
        return 0;
    }

    public boolean isClipReverse() {
        return this.isClipReverse.booleanValue();
    }

    public boolean isbIsReverseMode() {
        return this.bIsReverseMode.booleanValue();
    }

    public void setIsClipReverse(boolean z) {
        this.isClipReverse = Boolean.valueOf(z);
    }

    public void setbIsReverseMode(boolean z) {
        this.bIsReverseMode = Boolean.valueOf(z);
    }

    public void setmClipReverseFilePath(String str) {
        this.mClipReverseFilePath = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TrimedClipItemDataModel{mRawFilePath='");
        sb.append(this.mRawFilePath);
        sb.append('\'');
        sb.append(", mExportPath='");
        sb.append(this.mExportPath);
        sb.append('\'');
        sb.append(", mVeRangeInRawVideo=");
        sb.append(this.mVeRangeInRawVideo);
        sb.append(", mTrimVeRange=");
        sb.append(this.mTrimVeRange);
        sb.append(", isExported=");
        sb.append(this.isExported);
        sb.append(", mThumbnail=");
        sb.append(this.mThumbnail);
        sb.append(", mThumbKey=");
        sb.append(this.mThumbKey);
        sb.append(", mStreamSizeVe=");
        sb.append(this.mStreamSizeVe);
        sb.append(", mRotate=");
        sb.append(this.mRotate);
        sb.append(", bCrop=");
        sb.append(this.bCrop);
        sb.append(", cropRect=");
        sb.append(this.cropRect);
        sb.append(", bCropFeatureEnable=");
        sb.append(this.bCropFeatureEnable);
        sb.append(", isImage=");
        sb.append(this.isImage);
        sb.append(", mEncType=");
        sb.append(this.mEncType);
        sb.append(", mEffectPath='");
        sb.append(this.mEffectPath);
        sb.append('\'');
        sb.append(", digitalWaterMarkCode='");
        sb.append(this.digitalWaterMarkCode);
        sb.append('\'');
        sb.append(", mClipReverseFilePath='");
        sb.append(this.mClipReverseFilePath);
        sb.append('\'');
        sb.append(", bIsReverseMode=");
        sb.append(this.bIsReverseMode);
        sb.append(", isClipReverse=");
        sb.append(this.isClipReverse);
        sb.append(", bNeedTranscode=");
        sb.append(this.bNeedTranscode);
        sb.append(", repeatCount=");
        sb.append(this.repeatCount);
        sb.append('}');
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mRawFilePath);
        parcel.writeString(this.mExportPath);
        parcel.writeParcelable(this.mVeRangeInRawVideo, i);
        parcel.writeValue(this.isExported);
        parcel.writeValue(this.mThumbKey);
        parcel.writeParcelable(this.mStreamSizeVe, i);
        parcel.writeValue(this.bCropFeatureEnable);
        parcel.writeValue(this.mRotate);
        parcel.writeValue(this.bCrop);
        parcel.writeParcelable(this.cropRect, i);
        parcel.writeValue(this.isImage);
        parcel.writeString(this.mClipReverseFilePath);
        parcel.writeValue(this.bIsReverseMode);
        parcel.writeValue(this.isClipReverse);
        parcel.writeString(this.digitalWaterMarkCode);
        parcel.writeValue(this.repeatCount);
    }
}
