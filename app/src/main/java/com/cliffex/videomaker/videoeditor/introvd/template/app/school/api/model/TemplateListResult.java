package com.introvd.template.app.school.api.model;

import android.support.annotation.Keep;
import java.util.List;
import p464d.p465a.C9633a;
import p464d.p466b.p467a.C9649c;

@Keep
public final class TemplateListResult {
    private String allTemUrl = "";
    private int count;
    private List<TemplateInfo> list = C9633a.emptyList();

    public final String getAllTemUrl() {
        return this.allTemUrl;
    }

    public final int getCount() {
        return this.count;
    }

    public final List<TemplateInfo> getList() {
        return this.list;
    }

    public final void setAllTemUrl(String str) {
        C9649c.m27672j(str, "<set-?>");
        this.allTemUrl = str;
    }

    public final void setCount(int i) {
        this.count = i;
    }

    public final void setList(List<TemplateInfo> list2) {
        C9649c.m27672j(list2, "<set-?>");
        this.list = list2;
    }
}
