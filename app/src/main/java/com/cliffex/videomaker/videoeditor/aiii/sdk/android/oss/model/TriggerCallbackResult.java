package com.aiii.sdk.android.oss.model;

public class TriggerCallbackResult extends OSSResult {
    private String mServerCallbackReturnBody;

    public String getServerCallbackReturnBody() {
        return this.mServerCallbackReturnBody;
    }

    public void setServerCallbackReturnBody(String str) {
        this.mServerCallbackReturnBody = str;
    }
}
