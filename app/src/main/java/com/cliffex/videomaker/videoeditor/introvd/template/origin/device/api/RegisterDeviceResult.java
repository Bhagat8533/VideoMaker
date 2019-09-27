package com.introvd.template.origin.device.api;

import android.support.annotation.Keep;
import com.google.gson.annotations.SerializedName;

@Keep
public class RegisterDeviceResult {
    @SerializedName("a")
    public String duid;

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("duid : ");
        sb.append(this.duid);
        return sb.toString();
    }
}
