package com.introvd.template.template.data.api.model;

import com.google.gson.annotations.SerializedName;

public class TemplateResponseRoll {
    @SerializedName("tcid")
    public String categoryIndex;
    @SerializedName(alternate = {"downUrl"}, value = "downurl")
    public String downloadUrl;
    @SerializedName("enginever")
    public String engineVersion;
    public String event;
    public long expireTime;
    @SerializedName("filesize")
    public long fileSize;
    @SerializedName("imageinfo")
    public ImageInfo imageInfoJson;
    @SerializedName("imageInfo")
    public String imageInfoStr;
    @SerializedName("code")
    public String index;
    public int isShow;
    @SerializedName("lang")
    public String language;
    @SerializedName(alternate = {"newFlag"}, value = "newflag")
    public String newFlag = "0";
    @SerializedName("orderno")
    public String order;
    public String price;
    public long publishTime;
    @SerializedName("subtcid")
    public String subCategoryIndex;
    @SerializedName(alternate = {"wordInfo"}, value = "wordinfo")
    public String wordInfo;

    public static class ImageInfo {
        @SerializedName("bigicon")
        public String bigThumbUrl;
        @SerializedName("templateinfo")
        public String simpleInfoList;
        @SerializedName("icon")
        public String smallThumbUrl;

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("ImageInfo{smallThumbUrl='");
            sb.append(this.smallThumbUrl);
            sb.append('\'');
            sb.append(", bigThumbUrl='");
            sb.append(this.bigThumbUrl);
            sb.append('\'');
            sb.append(", simpleInfoList=");
            sb.append(this.simpleInfoList);
            sb.append('}');
            return sb.toString();
        }
    }

    public static class ImageSimpleInfoItem {
        @SerializedName("icon")
        public String icon;
        @SerializedName("imageUrl")
        public String imageUrl;
        @SerializedName("littleIntro")
        public String littleIntro;
        @SerializedName("ttid")
        public String ttid;

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("ImageSimpleInfoItem{imageUrl='");
            sb.append(this.imageUrl);
            sb.append('\'');
            sb.append(", icon='");
            sb.append(this.icon);
            sb.append('\'');
            sb.append(", ttid='");
            sb.append(this.ttid);
            sb.append('\'');
            sb.append(", littleIntro=");
            sb.append(this.littleIntro);
            sb.append('}');
            return sb.toString();
        }
    }

    public static class WordInfo {
        @SerializedName("copyright")
        public String copyRight;
        @SerializedName("details")
        public String detailDescription;
        @SerializedName("littleIntro")
        public String simpleDescription;
        public String title;

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("WordInfo{title='");
            sb.append(this.title);
            sb.append('\'');
            sb.append(", simpleDescription='");
            sb.append(this.simpleDescription);
            sb.append('\'');
            sb.append(", detailDescription='");
            sb.append(this.detailDescription);
            sb.append('\'');
            sb.append(", copyRight='");
            sb.append(this.copyRight);
            sb.append('\'');
            sb.append('}');
            return sb.toString();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TemplateRoll{index='");
        sb.append(this.index);
        sb.append('\'');
        sb.append(", engineVersion='");
        sb.append(this.engineVersion);
        sb.append('\'');
        sb.append(", downloadUrl='");
        sb.append(this.downloadUrl);
        sb.append('\'');
        sb.append(", language='");
        sb.append(this.language);
        sb.append('\'');
        sb.append(", price='");
        sb.append(this.price);
        sb.append('\'');
        sb.append(", wordInfo='");
        sb.append(this.wordInfo);
        sb.append('\'');
        sb.append(", imageInfoJson=");
        sb.append(this.imageInfoJson);
        sb.append(", imageInfoStr='");
        sb.append(this.imageInfoStr);
        sb.append('\'');
        sb.append(", order='");
        sb.append(this.order);
        sb.append('\'');
        sb.append(", publishTime=");
        sb.append(this.publishTime);
        sb.append(", expireTime=");
        sb.append(this.expireTime);
        sb.append(", newFlag='");
        sb.append(this.newFlag);
        sb.append('\'');
        sb.append(", categoryIndex='");
        sb.append(this.categoryIndex);
        sb.append('\'');
        sb.append(", subCategoryIndex='");
        sb.append(this.subCategoryIndex);
        sb.append('\'');
        sb.append(", event='");
        sb.append(this.event);
        sb.append('\'');
        sb.append(", isShow=");
        sb.append(this.isShow);
        sb.append('}');
        return sb.toString();
    }
}
