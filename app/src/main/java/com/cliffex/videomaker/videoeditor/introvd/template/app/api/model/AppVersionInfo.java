package com.introvd.template.app.api.model;

import android.support.annotation.Keep;
import com.google.gson.annotations.SerializedName;

@Keep
public class AppVersionInfo {
    @SerializedName("b")
    public String apkSize;
    @SerializedName("c")
    public String apkUrl;
    @SerializedName("d")
    public String desc;
    @SerializedName("e")
    public String forceUpdateFlag;
    @SerializedName("f")
    public String isShowDialog;
    @SerializedName("a")
    public String version;
}
