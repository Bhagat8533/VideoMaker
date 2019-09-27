package com.introvd.template.template.data.api.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class TemplateAudioCategoryList {
    @SerializedName("classlist")
    public List<TemplateAudioCategory> audioCategoryList;

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TemplateAudioCategoryList{audioCategoryList=");
        sb.append(this.audioCategoryList);
        sb.append('}');
        return sb.toString();
    }
}
