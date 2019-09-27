package com.introvd.template.app.school.api.model;

import android.databinding.C0177j;
import android.support.annotation.Keep;
import p464d.p466b.p467a.C9649c;

@Keep
public final class VideoLabelInfo {

    /* renamed from: id */
    private Number f3389id = Integer.valueOf(0);
    private C0177j<Boolean> isSelectedField = new C0177j<>(Boolean.valueOf(false));
    private String name = "";
    private Number orderNo = Integer.valueOf(0);

    public final Number getId() {
        return this.f3389id;
    }

    public final String getName() {
        return this.name;
    }

    public final Number getOrderNo() {
        return this.orderNo;
    }

    public final C0177j<Boolean> isSelectedField() {
        return this.isSelectedField;
    }

    public final void setId(Number number) {
        C9649c.m27672j(number, "<set-?>");
        this.f3389id = number;
    }

    public final void setName(String str) {
        C9649c.m27672j(str, "<set-?>");
        this.name = str;
    }

    public final void setOrderNo(Number number) {
        C9649c.m27672j(number, "<set-?>");
        this.orderNo = number;
    }

    public final void setSelectedField(C0177j<Boolean> jVar) {
        C9649c.m27672j(jVar, "<set-?>");
        this.isSelectedField = jVar;
    }
}
