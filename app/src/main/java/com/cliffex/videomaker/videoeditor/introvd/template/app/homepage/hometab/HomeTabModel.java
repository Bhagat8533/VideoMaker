package com.introvd.template.app.homepage.hometab;

import android.databinding.C0177j;
import android.support.annotation.Keep;
import p464d.p466b.p467a.C9649c;

@Keep
public final class HomeTabModel {
    private boolean enable;
    private int iconResIdField = -1;
    private String iconUrlField = "";
    private String iconUrlSelField = "";
    private C0177j<Boolean> isNewField = new C0177j<>(Boolean.valueOf(false));
    private C0177j<Boolean> isSelField = new C0177j<>(Boolean.valueOf(false));
    private C0177j<String> nameField = new C0177j<>("");
    private C0177j<Integer> newCountField = new C0177j<>(Integer.valueOf(0));

    public final boolean getEnable() {
        return this.enable;
    }

    public final int getIconResIdField() {
        return this.iconResIdField;
    }

    public final String getIconUrlField() {
        return this.iconUrlField;
    }

    public final String getIconUrlSelField() {
        return this.iconUrlSelField;
    }

    public final C0177j<String> getNameField() {
        return this.nameField;
    }

    public final C0177j<Integer> getNewCountField() {
        return this.newCountField;
    }

    public final C0177j<Boolean> isNewField() {
        return this.isNewField;
    }

    public final C0177j<Boolean> isSelField() {
        return this.isSelField;
    }

    public final void setEnable(boolean z) {
        this.enable = z;
    }

    public final void setIconResIdField(int i) {
        this.iconResIdField = i;
    }

    public final void setIconUrlField(String str) {
        C9649c.m27672j(str, "<set-?>");
        this.iconUrlField = str;
    }

    public final void setIconUrlSelField(String str) {
        C9649c.m27672j(str, "<set-?>");
        this.iconUrlSelField = str;
    }

    public final void setNameField(C0177j<String> jVar) {
        C9649c.m27672j(jVar, "<set-?>");
        this.nameField = jVar;
    }

    public final void setNewCountField(C0177j<Integer> jVar) {
        C9649c.m27672j(jVar, "<set-?>");
        this.newCountField = jVar;
    }

    public final void setNewField(C0177j<Boolean> jVar) {
        C9649c.m27672j(jVar, "<set-?>");
        this.isNewField = jVar;
    }

    public final void setSelField(C0177j<Boolean> jVar) {
        C9649c.m27672j(jVar, "<set-?>");
        this.isSelField = jVar;
    }
}
