package com.introvd.template.component.feedback.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class FBExtraDataInfo implements Parcelable {
    public static final Creator<FBExtraDataInfo> CREATOR = new Creator<FBExtraDataInfo>() {
        public FBExtraDataInfo createFromParcel(Parcel parcel) {
            return new FBExtraDataInfo(parcel);
        }

        public FBExtraDataInfo[] newArray(int i) {
            return new FBExtraDataInfo[i];
        }
    };
    public String courseQQNumber;
    public String extraIssueStr;
    public long fbID = -1;
    public String feedbackOpenQQScheme;
    public String feedbackQQNumber;
    public int from = 0;
    public boolean isOpenQQ = true;
    public boolean isTemplateCourseFeedback = false;
    public String language;
    public String puiddigest;
    public String templateQQNumber;

    public FBExtraDataInfo() {
    }

    public FBExtraDataInfo(int i, String str, String str2, String str3, boolean z) {
        this.from = i;
        this.puiddigest = str;
        this.templateQQNumber = str2;
        this.courseQQNumber = str3;
        this.isTemplateCourseFeedback = z;
    }

    protected FBExtraDataInfo(Parcel parcel) {
        boolean z = true;
        this.feedbackOpenQQScheme = parcel.readString();
        this.feedbackQQNumber = parcel.readString();
        this.isOpenQQ = parcel.readByte() != 0;
        this.fbID = parcel.readLong();
        this.language = parcel.readString();
        this.from = parcel.readInt();
        this.templateQQNumber = parcel.readString();
        this.courseQQNumber = parcel.readString();
        if (parcel.readByte() == 0) {
            z = false;
        }
        this.isTemplateCourseFeedback = z;
        this.extraIssueStr = parcel.readString();
        this.puiddigest = parcel.readString();
    }

    public FBExtraDataInfo(String str, String str2, boolean z, long j, String str3) {
        this.feedbackOpenQQScheme = str;
        this.feedbackQQNumber = str2;
        this.isOpenQQ = z;
        this.fbID = j;
        this.language = str3;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.feedbackOpenQQScheme);
        parcel.writeString(this.feedbackQQNumber);
        parcel.writeByte(this.isOpenQQ ? (byte) 1 : 0);
        parcel.writeLong(this.fbID);
        parcel.writeString(this.language);
        parcel.writeInt(this.from);
        parcel.writeString(this.templateQQNumber);
        parcel.writeString(this.courseQQNumber);
        parcel.writeByte(this.isTemplateCourseFeedback ? (byte) 1 : 0);
        parcel.writeString(this.extraIssueStr);
        parcel.writeString(this.puiddigest);
    }
}
