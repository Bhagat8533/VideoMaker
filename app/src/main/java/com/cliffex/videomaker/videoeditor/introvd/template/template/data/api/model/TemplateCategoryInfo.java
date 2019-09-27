package com.introvd.template.template.data.api.model;

import com.google.gson.annotations.SerializedName;

public class TemplateCategoryInfo {
    @SerializedName("f")
    public String bitFlag;
    @SerializedName("c")
    public String description;
    @SerializedName("d")
    public String imageUrl;
    @SerializedName("e")
    public String language;
    @SerializedName("g")
    public String minSupportVersion;
    @SerializedName("b")
    public String name;
    @SerializedName("i")
    public int newCount;
    @SerializedName("j")
    public String order;
    @SerializedName("k")
    public String publishTime;
    @SerializedName("a")
    public String tcid;
    @SerializedName("h")
    public int totalCount;

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TemplateCategoryInfo{tcid='");
        sb.append(this.tcid);
        sb.append('\'');
        sb.append(", name='");
        sb.append(this.name);
        sb.append('\'');
        sb.append(", description='");
        sb.append(this.description);
        sb.append('\'');
        sb.append(", imageUrl='");
        sb.append(this.imageUrl);
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
        sb.append(", totalCount='");
        sb.append(this.totalCount);
        sb.append('\'');
        sb.append(", newCount='");
        sb.append(this.newCount);
        sb.append('\'');
        sb.append(", order='");
        sb.append(this.order);
        sb.append('\'');
        sb.append(", publishTime='");
        sb.append(this.publishTime);
        sb.append('\'');
        sb.append('}');
        return sb.toString();
    }
}
