package com.introvd.template.template.data.api.model;

import com.google.gson.annotations.SerializedName;

public class TemplateDownloadInfo {
    @SerializedName("b")
    public String downloadUrl;
    @SerializedName("e")
    public String fileFormat;
    @SerializedName("d")
    public String fileName;
    @SerializedName("c")
    public String fileSize;
    @SerializedName("a")
    public String templateId;

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TemplateDownloadInfo{index='");
        sb.append(this.templateId);
        sb.append('\'');
        sb.append(", downloadUrl='");
        sb.append(this.downloadUrl);
        sb.append('\'');
        sb.append(", fileSize='");
        sb.append(this.fileSize);
        sb.append('\'');
        sb.append(", fileName='");
        sb.append(this.fileName);
        sb.append('\'');
        sb.append(", fileFormat='");
        sb.append(this.fileFormat);
        sb.append('\'');
        sb.append('}');
        return sb.toString();
    }
}
