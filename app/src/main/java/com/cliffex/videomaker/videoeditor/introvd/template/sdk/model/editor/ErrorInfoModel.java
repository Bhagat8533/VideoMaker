package com.introvd.template.sdk.model.editor;

public class ErrorInfoModel {
    private boolean bNeedDownload;
    private String mTemplatePath;

    public String getmTemplatePath() {
        return this.mTemplatePath;
    }

    public boolean isbNeedDownload() {
        return this.bNeedDownload;
    }

    public void setbNeedDownload(boolean z) {
        this.bNeedDownload = z;
    }

    public void setmTemplatePath(String str) {
        this.mTemplatePath = str;
    }
}
