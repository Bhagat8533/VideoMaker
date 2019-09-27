package com.introvd.template.template.data.api.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class TemplateSceneTemplateList {
    @SerializedName("tcid")
    public String categoryIndex;
    @SerializedName("scenecode")
    public String sceneIndex;
    @SerializedName("templatelist")
    public List<TemplateResponseInfo> templateInfoList;

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TemplateSceneTemplateList{categoryIndex='");
        sb.append(this.categoryIndex);
        sb.append('\'');
        sb.append(", sceneIndex='");
        sb.append(this.sceneIndex);
        sb.append('\'');
        sb.append(", templateInfoList=");
        sb.append(this.templateInfoList);
        sb.append('}');
        return sb.toString();
    }
}
