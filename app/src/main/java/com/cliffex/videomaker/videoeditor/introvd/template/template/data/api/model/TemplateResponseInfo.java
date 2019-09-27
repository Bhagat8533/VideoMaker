package com.introvd.template.template.data.api.model;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

public class TemplateResponseInfo {
    @SerializedName("u")
    public JsonObject appEventType;
    public String audioFlag;
    @SerializedName("n")
    public String authorId;
    @SerializedName(alternate = {"author"}, value = "o")
    public String authorName;
    @SerializedName("bigicon")
    public String bigThumbUrl;
    @SerializedName(alternate = {"mark", "flag"}, value = "j")
    public String bitFlag;
    @SerializedName(alternate = {"tcid"}, value = "c")
    public String categoryIndex;
    @SerializedName(alternate = {"intro"}, value = "e")
    public String description;
    @SerializedName("f1")
    public String displayImageUrl;
    @SerializedName(alternate = {"downcount"}, value = "r")
    public String downloadTimes;
    @SerializedName(alternate = {"downurl", "templateurl"}, value = "x")
    public String downloadUrl;
    @SerializedName(alternate = {"duration"}, value = "v")
    public String duration;
    @SerializedName(alternate = {"ver"}, value = "b")
    public String engineVersion;
    @SerializedName(alternate = {"event"}, value = "w")
    public String eventExtra;
    @SerializedName("expiretime")
    public String expireTime;
    @SerializedName(alternate = {"likecount"}, value = "q")
    public String favorTimes;
    @SerializedName(alternate = {"filesize", "size"}, value = "l")
    public String fileSize;
    @SerializedName(alternate = {"ttid"}, value = "a")
    public String index;
    @SerializedName(alternate = {"lang"}, value = "i")
    public String language;
    @SerializedName(alternate = {"minappversion", "appminver"}, value = "k")
    public String minSupportVersion;
    @SerializedName(alternate = {"name", "title"}, value = "d")
    public String name;
    @SerializedName(alternate = {"orderno"}, value = "s")
    public String order = "0";
    @SerializedName(alternate = {"previewtype"}, value = "h")
    public String previewType;
    @SerializedName(alternate = {"previewurl"}, value = "g")
    public String previewUrl;
    @SerializedName(alternate = {"publishtime"}, value = "p")
    public String publishTime;
    @SerializedName(alternate = {"sceneicon"}, value = "sceneIcon")
    public String sceneIcon;
    @SerializedName(alternate = {"scenecode"}, value = "m1")
    public String sceneIndex;
    @SerializedName(alternate = {"scene"}, value = "m")
    public String sceneName;
    @SerializedName(alternate = {"points"}, value = "t")
    public String scoreToDownload;
    public String subtcid;
    @SerializedName("iconcolor")
    public String thumbColor;
    @SerializedName(alternate = {"icon"}, value = "f")
    public String thumbUrl;

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TemplateInfo{index='");
        sb.append(this.index);
        sb.append('\'');
        sb.append(", engineVersion='");
        sb.append(this.engineVersion);
        sb.append('\'');
        sb.append(", categoryIndex='");
        sb.append(this.categoryIndex);
        sb.append('\'');
        sb.append(", name='");
        sb.append(this.name);
        sb.append('\'');
        sb.append(", description='");
        sb.append(this.description);
        sb.append('\'');
        sb.append(", thumbUrl='");
        sb.append(this.thumbUrl);
        sb.append('\'');
        sb.append(", displayImageUrl='");
        sb.append(this.displayImageUrl);
        sb.append('\'');
        sb.append(", previewUrl='");
        sb.append(this.previewUrl);
        sb.append('\'');
        sb.append(", previewType='");
        sb.append(this.previewType);
        sb.append('\'');
        sb.append(", language='");
        sb.append(this.language);
        sb.append('\'');
        sb.append(", bitFlag='");
        sb.append(this.bitFlag);
        sb.append('\'');
        sb.append(", minSupportVersion='");
        sb.append(this.minSupportVersion);
        sb.append('\'');
        sb.append(", fileSize='");
        sb.append(this.fileSize);
        sb.append('\'');
        sb.append(", sceneIndex='");
        sb.append(this.sceneIndex);
        sb.append('\'');
        sb.append(", sceneName='");
        sb.append(this.sceneName);
        sb.append('\'');
        sb.append(", sceneName='");
        sb.append(this.sceneIcon);
        sb.append('\'');
        sb.append(", authorId='");
        sb.append(this.authorId);
        sb.append('\'');
        sb.append(", authorName='");
        sb.append(this.authorName);
        sb.append('\'');
        sb.append(", publishTime='");
        sb.append(this.publishTime);
        sb.append('\'');
        sb.append(", expireTime='");
        sb.append(this.expireTime);
        sb.append('\'');
        sb.append(", favorTimes='");
        sb.append(this.favorTimes);
        sb.append('\'');
        sb.append(", downloadTimes='");
        sb.append(this.downloadTimes);
        sb.append('\'');
        sb.append(", order='");
        sb.append(this.order);
        sb.append('\'');
        sb.append(", thumbColor='");
        sb.append(this.thumbColor);
        sb.append('\'');
        sb.append(", bigThumbUrl='");
        sb.append(this.bigThumbUrl);
        sb.append('\'');
        sb.append(", scoreToDownload='");
        sb.append(this.scoreToDownload);
        sb.append('\'');
        sb.append(", appEventType=");
        sb.append(this.appEventType);
        sb.append(", duration='");
        sb.append(this.duration);
        sb.append('\'');
        sb.append(", eventExtra='");
        sb.append(this.eventExtra);
        sb.append('\'');
        sb.append(", downloadUrl='");
        sb.append(this.downloadUrl);
        sb.append('\'');
        sb.append('}');
        return sb.toString();
    }
}
