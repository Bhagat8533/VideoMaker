package com.introvd.template.app.push.api.model;

import android.support.annotation.Keep;
import com.google.gson.annotations.SerializedName;

@Keep
public class TagRequestParam {
    @SerializedName("b")
    public String gcmId;
    @SerializedName("e")
    public String getuiId;
    @SerializedName("d")
    public String jpushId;
    @SerializedName("a")
    public String land;
    @SerializedName("c")
    public String mipushId;
    @SerializedName("g")
    public String produceId;
}
