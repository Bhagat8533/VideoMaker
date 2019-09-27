package com.introvd.template.template.data.api.model;

import com.google.gson.annotations.SerializedName;

public class TemplateResponsePackageInfo {
    @SerializedName("banner")
    public String bannerUrl;
    @SerializedName("icon")
    public String coverUrl;
    @SerializedName("intro")
    public String description;
    @SerializedName("expiretime")
    public String expireTime;
    @SerializedName("size")
    public String fileSize;
    @SerializedName("groupcode")
    public String index;
    @SerializedName("lang")
    public String language;
    @SerializedName("appminver")
    public String minSupportVersion;
    @SerializedName("title")
    public String name;
    @SerializedName("newcount")
    public String newCount;
    @SerializedName("orderno")
    public String order;
    @SerializedName("publishtime")
    public String publishTime;

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TemplatePackageInfo{index='");
        sb.append(this.index);
        sb.append('\'');
        sb.append(", language='");
        sb.append(this.language);
        sb.append('\'');
        sb.append(", minSupportVersion='");
        sb.append(this.minSupportVersion);
        sb.append('\'');
        sb.append(", fileSize='");
        sb.append(this.fileSize);
        sb.append('\'');
        sb.append(", publishTime='");
        sb.append(this.publishTime);
        sb.append('\'');
        sb.append(", expireTime='");
        sb.append(this.expireTime);
        sb.append('\'');
        sb.append(", order='");
        sb.append(this.order);
        sb.append('\'');
        sb.append(", coverUrl='");
        sb.append(this.coverUrl);
        sb.append('\'');
        sb.append(", bannerUrl='");
        sb.append(this.bannerUrl);
        sb.append('\'');
        sb.append(", newCount='");
        sb.append(this.newCount);
        sb.append('\'');
        sb.append(", description='");
        sb.append(this.description);
        sb.append('\'');
        sb.append(", name='");
        sb.append(this.name);
        sb.append('\'');
        sb.append('}');
        return sb.toString();
    }
}
