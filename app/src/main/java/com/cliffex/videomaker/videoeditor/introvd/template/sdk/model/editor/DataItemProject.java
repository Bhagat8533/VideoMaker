package com.introvd.template.sdk.model.editor;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.introvd.template.sdk.utils.C8548e;
import com.introvd.template.sdk.utils.C8558m;

public class DataItemProject implements Parcelable, Cloneable {
    public static final Creator<DataItemProject> CREATOR = new Creator<DataItemProject>() {
        public DataItemProject createFromParcel(Parcel parcel) {
            return new DataItemProject(parcel);
        }

        public DataItemProject[] newArray(int i) {
            return new DataItemProject[i];
        }
    };
    private static final int MASK_FLAG_CAMERA_PIP = 8;
    private static final int MASK_FLAG_EDIT_BGM = 2;
    private static final int MASK_FLAG_EDIT_MV = 65536;
    public long _id = -1;
    public int editStatus = 0;
    public String entrance;
    public int iCameraCode = 0;
    public int iIsDeleted = 0;
    public int iIsModified = 0;
    public int iPrjClipCount = 0;
    public int iPrjDuration = 0;
    public int nDurationLimit = 0;
    public int prjThemeType;
    public String strActivityData = null;
    public String strCoverURL = null;
    public String strCreateTime = null;
    public String strExtra = null;
    public String strModifyTime = null;
    public String strPrjExportURL = null;
    public String strPrjThumbnail = null;
    public String strPrjTitle = null;
    public String strPrjURL = null;
    public String strPrjVersion = null;
    public String strVideoDesc = null;
    public int streamHeight = 0;
    public int streamWidth = 0;
    public int todoCode;
    public long usedEffectTempId = 0;
    public String videoTemplateInfo;

    public DataItemProject() {
    }

    protected DataItemProject(Parcel parcel) {
        this._id = parcel.readLong();
        this.strPrjTitle = parcel.readString();
        this.strPrjURL = parcel.readString();
        this.strPrjExportURL = parcel.readString();
        this.iPrjClipCount = parcel.readInt();
        this.iPrjDuration = parcel.readInt();
        this.strPrjThumbnail = parcel.readString();
        this.strPrjVersion = parcel.readString();
        this.strCreateTime = parcel.readString();
        this.strModifyTime = parcel.readString();
        this.iIsDeleted = parcel.readInt();
        this.iIsModified = parcel.readInt();
        this.streamWidth = parcel.readInt();
        this.streamHeight = parcel.readInt();
        this.usedEffectTempId = parcel.readLong();
        this.todoCode = parcel.readInt();
        this.editStatus = parcel.readInt();
        this.strVideoDesc = parcel.readString();
        this.strActivityData = parcel.readString();
        this.iCameraCode = parcel.readInt();
        this.strExtra = parcel.readString();
        this.strCoverURL = parcel.readString();
        this.entrance = parcel.readString();
        this.videoTemplateInfo = parcel.readString();
        this.nDurationLimit = parcel.readInt();
        this.prjThemeType = parcel.readInt();
    }

    public DataItemProject(DataItemProject dataItemProject) {
        this._id = dataItemProject._id;
        this.strPrjTitle = dataItemProject.strPrjTitle;
        this.strPrjURL = dataItemProject.strPrjURL;
        this.strPrjExportURL = dataItemProject.strPrjExportURL;
        this.iPrjClipCount = dataItemProject.iPrjClipCount;
        this.iPrjDuration = dataItemProject.iPrjDuration;
        this.strPrjThumbnail = dataItemProject.strPrjThumbnail;
        this.strPrjVersion = dataItemProject.strPrjVersion;
        this.strCreateTime = dataItemProject.strCreateTime;
        this.strModifyTime = dataItemProject.strModifyTime;
        this.iIsDeleted = dataItemProject.iIsDeleted;
        this.iIsModified = dataItemProject.iIsModified;
        this.streamWidth = dataItemProject.streamWidth;
        this.streamHeight = dataItemProject.streamHeight;
        this.usedEffectTempId = dataItemProject.usedEffectTempId;
        this.todoCode = dataItemProject.todoCode;
        this.editStatus = dataItemProject.editStatus;
        this.strVideoDesc = dataItemProject.strVideoDesc;
        this.strActivityData = dataItemProject.strActivityData;
        this.iCameraCode = dataItemProject.iCameraCode;
        this.strExtra = dataItemProject.strExtra;
        this.strCoverURL = dataItemProject.strCoverURL;
        this.entrance = dataItemProject.entrance;
        this.videoTemplateInfo = dataItemProject.videoTemplateInfo;
        this.nDurationLimit = dataItemProject.nDurationLimit;
        this.prjThemeType = dataItemProject.prjThemeType;
    }

    public DataItemProject clone() throws CloneNotSupportedException {
        return (DataItemProject) super.clone();
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
        DataItemProject dataItemProject = (DataItemProject) obj;
        if (this.strPrjURL != null) {
            z = this.strPrjURL.equals(dataItemProject.strPrjURL);
        } else if (dataItemProject.strPrjURL != null) {
            z = false;
        }
        return z;
    }

    public String getPrjTodoContent() {
        return C8558m.m25034oq(this.strExtra);
    }

    public String getProjectName() {
        if (TextUtils.isEmpty(this.strPrjURL)) {
            return null;
        }
        return C8548e.getFileName(this.strPrjURL);
    }

    public int hashCode() {
        if (this.strPrjURL != null) {
            return this.strPrjURL.hashCode();
        }
        return 0;
    }

    public boolean isAdvBGMMode() {
        return (this.editStatus & 2) != 0;
    }

    public boolean isCameraPipMode() {
        return (this.editStatus & 8) != 0;
    }

    public boolean isMVPrj() {
        return (this.editStatus & 65536) != 0;
    }

    public boolean isMiniPrj() {
        return C8558m.m25033op(this.strExtra);
    }

    public boolean isProjectModified() {
        return this.iIsModified == 1;
    }

    public void setBGMMode(boolean z) {
        if (z) {
            this.editStatus |= 2;
        } else {
            this.editStatus &= -3;
        }
    }

    public void setCameraPipMode(boolean z) {
        if (z) {
            this.editStatus |= 8;
        } else {
            this.editStatus &= -9;
        }
    }

    public void setMVPrjFlag(boolean z) {
        if (z) {
            this.editStatus |= 65536;
        } else {
            this.editStatus &= -65537;
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this._id);
        parcel.writeString(this.strPrjTitle);
        parcel.writeString(this.strPrjURL);
        parcel.writeString(this.strPrjExportURL);
        parcel.writeInt(this.iPrjClipCount);
        parcel.writeInt(this.iPrjDuration);
        parcel.writeString(this.strPrjThumbnail);
        parcel.writeString(this.strPrjVersion);
        parcel.writeString(this.strCreateTime);
        parcel.writeString(this.strModifyTime);
        parcel.writeInt(this.iIsDeleted);
        parcel.writeInt(this.iIsModified);
        parcel.writeInt(this.streamWidth);
        parcel.writeInt(this.streamHeight);
        parcel.writeLong(this.usedEffectTempId);
        parcel.writeInt(this.todoCode);
        parcel.writeInt(this.editStatus);
        parcel.writeString(this.strVideoDesc);
        parcel.writeString(this.strActivityData);
        parcel.writeInt(this.iCameraCode);
        parcel.writeString(this.strExtra);
        parcel.writeString(this.strCoverURL);
        parcel.writeString(this.entrance);
        parcel.writeString(this.videoTemplateInfo);
        parcel.writeInt(this.nDurationLimit);
        parcel.writeInt(this.prjThemeType);
    }
}
