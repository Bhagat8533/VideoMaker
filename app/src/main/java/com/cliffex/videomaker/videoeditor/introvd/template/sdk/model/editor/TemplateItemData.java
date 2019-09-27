package com.introvd.template.sdk.model.editor;

import android.util.SparseArray;

public class TemplateItemData {
    public int coverPos;
    public final long lID;
    public final long lUpdateTime;
    public SparseArray<String> mTitleList;
    public int nConfigureCount;
    public int nDelFlag;
    public int nFavorite;
    public final int nFromType;
    public int nLayoutFlag;
    private int nNeedDownloadFlag;
    public int nOrder;
    public int nOriOrder;
    public int nSubOrder;
    public final int nVersion;
    public String strExtInfo;
    public String strIcon;
    public String strIntro;
    public String strMission;
    public String strMissionResult;
    public final String strPath;
    public String strScene;
    public String strSceneCode;
    public String strSceneName;
    public String strTitle;
    public String strTitleJSON;
    public int streamHeight;
    public int streamWidth;

    public static final class Builder {
        /* access modifiers changed from: private */
        public int coverPos;
        /* access modifiers changed from: private */
        public final long lID;
        /* access modifiers changed from: private */
        public final long lUpdateTime;
        /* access modifiers changed from: private */
        public SparseArray<String> mTitleList;
        /* access modifiers changed from: private */
        public int nConfigureCount;
        /* access modifiers changed from: private */
        public int nDelFlag;
        /* access modifiers changed from: private */
        public int nFavorite;
        /* access modifiers changed from: private */
        public final int nFromType;
        /* access modifiers changed from: private */
        public int nLayoutFlag;
        /* access modifiers changed from: private */
        public int nNeedDownloadFlag;
        /* access modifiers changed from: private */
        public int nOrder;
        /* access modifiers changed from: private */
        public int nOriOrder;
        /* access modifiers changed from: private */
        public int nSubOrder;
        /* access modifiers changed from: private */
        public final int nVersion;
        /* access modifiers changed from: private */
        public String strExtInfo;
        /* access modifiers changed from: private */
        public String strIcon;
        /* access modifiers changed from: private */
        public String strIntro;
        /* access modifiers changed from: private */
        public String strMission;
        /* access modifiers changed from: private */
        public String strMissionResult;
        /* access modifiers changed from: private */
        public final String strPath;
        /* access modifiers changed from: private */
        public String strScene;
        /* access modifiers changed from: private */
        public String strSceneCode;
        /* access modifiers changed from: private */
        public String strSceneName;
        /* access modifiers changed from: private */
        public String strTitle;
        /* access modifiers changed from: private */
        public String strTitleJSON;
        /* access modifiers changed from: private */
        public int streamHeight;
        /* access modifiers changed from: private */
        public int streamWidth;

        public Builder(String str, long j, int i, int i2, long j2) {
            this.strPath = str;
            this.lID = j;
            this.nVersion = i;
            this.nFromType = i2;
            this.lUpdateTime = j2;
        }

        public TemplateItemData build() {
            return new TemplateItemData(this);
        }

        public Builder coverPos(int i) {
            this.coverPos = i;
            return this;
        }

        public Builder mTitleList(SparseArray<String> sparseArray) {
            this.mTitleList = sparseArray;
            return this;
        }

        public Builder nConfigureCount(int i) {
            this.nConfigureCount = i;
            return this;
        }

        public Builder nDelFlag(int i) {
            this.nDelFlag = i;
            return this;
        }

        public Builder nFavorite(int i) {
            this.nFavorite = i;
            return this;
        }

        public Builder nLayoutFlag(int i) {
            this.nLayoutFlag = i;
            return this;
        }

        public Builder nNeedDownloadFlag(int i) {
            this.nNeedDownloadFlag = i;
            return this;
        }

        public Builder nOrder(int i) {
            this.nOrder = i;
            return this;
        }

        public Builder nOriOrder(int i) {
            this.nOriOrder = i;
            return this;
        }

        public Builder nSubOrder(int i) {
            this.nSubOrder = i;
            return this;
        }

        public Builder setStrIcon(String str) {
            this.strIcon = str;
            return this;
        }

        public Builder strExtInfo(String str) {
            this.strExtInfo = str;
            return this;
        }

        public Builder strIntro(String str) {
            this.strIntro = str;
            return this;
        }

        public Builder strMission(String str) {
            this.strMission = str;
            return this;
        }

        public Builder strMissionResult(String str) {
            this.strMissionResult = str;
            return this;
        }

        public Builder strScene(String str) {
            this.strScene = str;
            return this;
        }

        public Builder strSceneCode(String str) {
            this.strSceneCode = str;
            return this;
        }

        public Builder strSceneName(String str) {
            this.strSceneName = str;
            return this;
        }

        public Builder strTitle(String str) {
            this.strTitle = str;
            return this;
        }

        public Builder strTitleJSON(String str) {
            this.strTitleJSON = str;
            return this;
        }

        public Builder streamHeight(int i) {
            this.streamHeight = i;
            return this;
        }

        public Builder streamWidth(int i) {
            this.streamWidth = i;
            return this;
        }
    }

    private TemplateItemData(Builder builder) {
        this.strPath = builder.strPath;
        this.lID = builder.lID;
        this.nVersion = builder.nVersion;
        this.nOrder = builder.nOrder;
        this.nFromType = builder.nFromType;
        this.lUpdateTime = builder.lUpdateTime;
        this.nFavorite = builder.nFavorite;
        this.nOriOrder = builder.nOriOrder;
        this.mTitleList = builder.mTitleList;
        this.strTitleJSON = builder.strTitleJSON;
        this.nSubOrder = builder.nSubOrder;
        this.nLayoutFlag = builder.nLayoutFlag;
        this.strExtInfo = builder.strExtInfo;
        this.nConfigureCount = builder.nConfigureCount;
        this.nNeedDownloadFlag = builder.nNeedDownloadFlag;
        this.strMission = builder.strMission;
        this.strMissionResult = builder.strMissionResult;
        this.strSceneCode = builder.strSceneCode;
        this.strSceneName = builder.strSceneName;
        this.strTitle = builder.strTitle;
        this.strScene = builder.strScene;
        this.strIntro = builder.strIntro;
        this.streamWidth = builder.streamWidth;
        this.streamHeight = builder.streamHeight;
        this.coverPos = builder.coverPos;
        this.nDelFlag = builder.nDelFlag;
        this.strIcon = builder.strIcon;
    }

    public int getNeedDownloadFlag() {
        return this.nNeedDownloadFlag;
    }

    public boolean shouldOnlineDownload() {
        return this.nNeedDownloadFlag != 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TemplateItemData{strPath='");
        sb.append(this.strPath);
        sb.append('\'');
        sb.append(", lID=");
        sb.append(this.lID);
        sb.append(", nVersion=");
        sb.append(this.nVersion);
        sb.append(", nOrder=");
        sb.append(this.nOrder);
        sb.append(", nFromType=");
        sb.append(this.nFromType);
        sb.append(", lUpdateTime=");
        sb.append(this.lUpdateTime);
        sb.append(", nFavorite=");
        sb.append(this.nFavorite);
        sb.append(", nOriOrder=");
        sb.append(this.nOriOrder);
        sb.append(", mTitleList=");
        sb.append(this.mTitleList);
        sb.append(", strTitleJSON='");
        sb.append(this.strTitleJSON);
        sb.append('\'');
        sb.append(", nSubOrder=");
        sb.append(this.nSubOrder);
        sb.append(", nLayoutFlag=");
        sb.append(this.nLayoutFlag);
        sb.append(", strExtInfo='");
        sb.append(this.strExtInfo);
        sb.append('\'');
        sb.append(", nConfigureCount=");
        sb.append(this.nConfigureCount);
        sb.append(", nNeedDownloadFlag=");
        sb.append(this.nNeedDownloadFlag);
        sb.append(", strMission='");
        sb.append(this.strMission);
        sb.append('\'');
        sb.append(", strMissionResult='");
        sb.append(this.strMissionResult);
        sb.append('\'');
        sb.append(", strSceneCode='");
        sb.append(this.strSceneCode);
        sb.append('\'');
        sb.append(", strSceneName='");
        sb.append(this.strSceneName);
        sb.append('\'');
        sb.append(", strTitle='");
        sb.append(this.strTitle);
        sb.append('\'');
        sb.append(", strScene='");
        sb.append(this.strScene);
        sb.append('\'');
        sb.append(", strIntro='");
        sb.append(this.strIntro);
        sb.append('\'');
        sb.append(", streamWidth=");
        sb.append(this.streamWidth);
        sb.append(", streamHeight=");
        sb.append(this.streamHeight);
        sb.append(", coverPos=");
        sb.append(this.coverPos);
        sb.append(", nDelFlag=");
        sb.append(this.nDelFlag);
        sb.append(", strIcon='");
        sb.append(this.strIcon);
        sb.append('\'');
        sb.append('}');
        return sb.toString();
    }
}
