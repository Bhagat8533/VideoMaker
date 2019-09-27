package com.introvd.template.template.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.introvd.template.sdk.model.template.TemplateInfo;
import java.util.ArrayList;

public class TemplateGroupInfo implements Parcelable {
    public static final Creator<TemplateGroupInfo> CREATOR = new Creator<TemplateGroupInfo>() {
        public TemplateGroupInfo createFromParcel(Parcel parcel) {
            return new TemplateGroupInfo(parcel);
        }

        public TemplateGroupInfo[] newArray(int i) {
            return new TemplateGroupInfo[i];
        }
    };
    public ArrayList<TemplateInfo> childList = new ArrayList<>();
    public boolean is4Test = false;
    public boolean showGroup = true;
    public boolean showList = false;
    public String strGroupCode;
    public String strGroupDisplayName;
    public String thumbPath = "";

    public TemplateGroupInfo() {
    }

    protected TemplateGroupInfo(Parcel parcel) {
        boolean z = false;
        this.showList = parcel.readByte() != 0;
        this.showGroup = parcel.readByte() != 0;
        if (parcel.readByte() != 0) {
            z = true;
        }
        this.is4Test = z;
        this.strGroupDisplayName = parcel.readString();
        this.strGroupCode = parcel.readString();
        this.thumbPath = parcel.readString();
        this.childList = parcel.createTypedArrayList(TemplateInfo.CREATOR);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte(this.showList ? (byte) 1 : 0);
        parcel.writeByte(this.showGroup ? (byte) 1 : 0);
        parcel.writeByte(this.is4Test ? (byte) 1 : 0);
        parcel.writeString(this.strGroupDisplayName);
        parcel.writeString(this.strGroupCode);
        parcel.writeString(this.thumbPath);
        parcel.writeTypedList(this.childList);
    }
}
