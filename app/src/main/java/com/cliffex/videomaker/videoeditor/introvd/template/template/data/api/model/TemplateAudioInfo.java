package com.introvd.template.template.data.api.model;

import com.google.gson.annotations.SerializedName;

public class TemplateAudioInfo {
    public String album;
    @SerializedName("audiourl")
    public String audioUrl;
    @SerializedName("auther")
    public String author;
    @SerializedName("classid")
    public String categoryIndex;
    @SerializedName("coverurl")
    public String coverUrl;
    public int duration;
    @SerializedName("audioid")
    public String index;
    public String name;
    @SerializedName("newflag")
    public String newFlag;
    @SerializedName("orderno")
    public int order;

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TemplateAudioInfo{index='");
        sb.append(this.index);
        sb.append('\'');
        sb.append(", categoryIndex='");
        sb.append(this.categoryIndex);
        sb.append('\'');
        sb.append(", coverUrl='");
        sb.append(this.coverUrl);
        sb.append('\'');
        sb.append(", audioUrl='");
        sb.append(this.audioUrl);
        sb.append('\'');
        sb.append(", name='");
        sb.append(this.name);
        sb.append('\'');
        sb.append(", duration='");
        sb.append(this.duration);
        sb.append('\'');
        sb.append(", author='");
        sb.append(this.author);
        sb.append('\'');
        sb.append(", album='");
        sb.append(this.album);
        sb.append('\'');
        sb.append(", newFlag='");
        sb.append(this.newFlag);
        sb.append('\'');
        sb.append(", order='");
        sb.append(this.order);
        sb.append('\'');
        sb.append('}');
        return sb.toString();
    }
}
