package com.introvd.template.template.data.api.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class TemplateAudioInfoList {
    @SerializedName("audiolist")
    public List<TemplateAudioInfo> audioInfoList;
    @SerializedName("allcount")
    public int count;

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TemplateAudioInfoList{count='");
        sb.append(this.count);
        sb.append('\'');
        sb.append(", audioInfoList=");
        sb.append(this.audioInfoList);
        sb.append('}');
        return sb.toString();
    }
}
