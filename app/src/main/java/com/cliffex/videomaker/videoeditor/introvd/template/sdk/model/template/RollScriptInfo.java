package com.introvd.template.sdk.model.template;

public class RollScriptInfo implements Cloneable {
    public String rollCopyRightInfo = "";
    public String rollDetailIntro = "";
    public String rollSimpleIntro = "";
    public String rollTitle = "";

    /* access modifiers changed from: protected */
    public Object clone() {
        try {
            return (RollScriptInfo) super.clone();
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }
}
