package com.introvd.template.app.school.api.model;

import android.support.annotation.Keep;
import p464d.p466b.p467a.C9649c;

@Keep
public final class UserInfo {
    private String auiddigest = "";
    private String logo = "";
    private String nickName = "";

    public final String getAuiddigest() {
        return this.auiddigest;
    }

    public final String getLogo() {
        return this.logo;
    }

    public final String getNickName() {
        return this.nickName;
    }

    public final void setAuiddigest(String str) {
        C9649c.m27672j(str, "<set-?>");
        this.auiddigest = str;
    }

    public final void setLogo(String str) {
        C9649c.m27672j(str, "<set-?>");
        this.logo = str;
    }

    public final void setNickName(String str) {
        C9649c.m27672j(str, "<set-?>");
        this.nickName = str;
    }
}
