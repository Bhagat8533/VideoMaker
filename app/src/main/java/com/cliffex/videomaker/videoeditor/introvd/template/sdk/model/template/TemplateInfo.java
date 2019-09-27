package com.introvd.template.sdk.model.template;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;

public class TemplateInfo implements Parcelable {
    public static final Creator<TemplateInfo> CREATOR = new Creator<TemplateInfo>() {
        public TemplateInfo createFromParcel(Parcel parcel) {
            return new TemplateInfo(parcel);
        }

        public TemplateInfo[] newArray(int i) {
            TemplateInfo[] templateInfoArr = new TemplateInfo[i];
            for (int i2 = 0; i2 < i; i2++) {
                templateInfoArr[i2] = null;
            }
            return templateInfoArr;
        }
    };
    public static final int TEMPLATE_MASK_FLAG_RECOMMEND = 2;
    public int audioFlag = 0;
    public int nDowncount = -1;
    public int nFlag = 0;
    public int nLikecount = -1;
    public int nMark = -1;
    public int nOrderno = -1;
    public int nPoints = -1;
    public int nPreviewtype = -1;
    public int nSize = -1;
    public int nState = 1;
    public int nViewType = 0;
    public String strAppminver = null;
    public String strAuthorid = null;
    public String strAuthorname = null;
    public String strDuration = null;
    public String strIcon = null;
    public String strIntro = null;
    public String strLang = null;
    public String strMission = null;
    public String strPreviewurl = null;
    public String strPublishtime = null;
    public String strScene = null;
    public String strSceneCode = null;
    public String strSceneIcon = null;
    public String strSceneName = null;
    public String strSubType;
    public String strTitle = null;
    public String strUrl = null;
    public String strVer = null;
    public String subtcid = null;
    public String tcid = null;
    public String ttid = null;

    public TemplateInfo() {
    }

    protected TemplateInfo(Parcel parcel) {
        this.ttid = parcel.readString();
        this.strVer = parcel.readString();
        this.tcid = parcel.readString();
        this.strTitle = parcel.readString();
        this.strIntro = parcel.readString();
        this.strIcon = parcel.readString();
        this.strPreviewurl = parcel.readString();
        this.nPreviewtype = parcel.readInt();
        this.strLang = parcel.readString();
        this.nMark = parcel.readInt();
        this.strAppminver = parcel.readString();
        this.nSize = parcel.readInt();
        this.strScene = parcel.readString();
        this.strAuthorid = parcel.readString();
        this.strAuthorname = parcel.readString();
        this.strPublishtime = parcel.readString();
        this.nLikecount = parcel.readInt();
        this.nDowncount = parcel.readInt();
        this.nOrderno = parcel.readInt();
        this.nPoints = parcel.readInt();
        this.strUrl = parcel.readString();
        this.nState = parcel.readInt();
        this.nFlag = parcel.readInt();
        this.nViewType = parcel.readInt();
        this.strMission = parcel.readString();
        this.strDuration = parcel.readString();
        this.strSceneCode = parcel.readString();
        this.strSceneName = parcel.readString();
        this.strSceneIcon = parcel.readString();
        this.audioFlag = parcel.readInt();
        this.strSubType = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TemplateInfo) {
            return TextUtils.equals(this.ttid, ((TemplateInfo) obj).ttid);
        }
        return false;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public boolean isRecommendItem() {
        return (this.nMark & 2) == 2;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.ttid);
        parcel.writeString(this.strVer);
        parcel.writeString(this.tcid);
        parcel.writeString(this.strTitle);
        parcel.writeString(this.strIntro);
        parcel.writeString(this.strIcon);
        parcel.writeString(this.strPreviewurl);
        parcel.writeInt(this.nPreviewtype);
        parcel.writeString(this.strLang);
        parcel.writeInt(this.nMark);
        parcel.writeString(this.strAppminver);
        parcel.writeInt(this.nSize);
        parcel.writeString(this.strScene);
        parcel.writeString(this.strAuthorid);
        parcel.writeString(this.strAuthorname);
        parcel.writeString(this.strPublishtime);
        parcel.writeInt(this.nLikecount);
        parcel.writeInt(this.nDowncount);
        parcel.writeInt(this.nOrderno);
        parcel.writeInt(this.nPoints);
        parcel.writeString(this.strUrl);
        parcel.writeInt(this.nState);
        parcel.writeInt(this.nFlag);
        parcel.writeInt(this.nViewType);
        parcel.writeString(this.strMission);
        parcel.writeString(this.strDuration);
        parcel.writeString(this.strSceneCode);
        parcel.writeString(this.strSceneName);
        parcel.writeString(this.strSceneIcon);
        parcel.writeInt(this.audioFlag);
        parcel.writeString(this.strSubType);
    }
}
