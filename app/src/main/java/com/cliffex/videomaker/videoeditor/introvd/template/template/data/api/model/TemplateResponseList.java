package com.introvd.template.template.data.api.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class TemplateResponseList {
    @SerializedName("templatelist")
    public List<TemplateResponseInfo> templateInfoList;

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TemplatePushTemplateList{templateInfoList=");
        sb.append(this.templateInfoList);
        sb.append('}');
        return sb.toString();
    }
}
