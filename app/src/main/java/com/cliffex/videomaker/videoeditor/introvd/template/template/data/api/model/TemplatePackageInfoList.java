package com.introvd.template.template.data.api.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class TemplatePackageInfoList {
    @SerializedName("templategrouplist")
    public List<TemplateResponsePackageInfo> templatePackageList;

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TemplatePackageInfoList{templatePackageList=");
        sb.append(this.templatePackageList);
        sb.append('}');
        return sb.toString();
    }
}
