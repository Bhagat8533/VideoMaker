package com.introvd.template.sdk.model.template;

public class RollXytInfo implements Cloneable {
    public String mName;
    public String mXytIconUrl;
    public String mXytPreviewUrl;

    /* access modifiers changed from: protected */
    public Object clone() {
        try {
            return (RollXytInfo) super.clone();
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }
}
