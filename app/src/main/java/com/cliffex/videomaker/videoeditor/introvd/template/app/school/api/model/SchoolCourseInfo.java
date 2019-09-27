package com.introvd.template.app.school.api.model;

import android.databinding.C0177j;
import android.support.annotation.Keep;
import com.introvd.template.router.todoCode.TODOParamModel;
import com.introvd.template.xyui.p420a.C9155c;
import p464d.p466b.p467a.C9649c;

@Keep
public final class SchoolCourseInfo extends C9155c {
    private String auid = "";
    private C0177j<String> avatarUrlField = new C0177j<>("");
    private String coverUrl = "";
    private String desc = "";
    private C0177j<String> nameField = new C0177j<>("");
    private String title = "";
    private TODOParamModel todoParamModel = new TODOParamModel();

    public final String getAuid() {
        return this.auid;
    }

    public final C0177j<String> getAvatarUrlField() {
        return this.avatarUrlField;
    }

    public final String getCoverUrl() {
        return this.coverUrl;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final C0177j<String> getNameField() {
        return this.nameField;
    }

    public final String getTitle() {
        return this.title;
    }

    public final TODOParamModel getTodoParamModel() {
        return this.todoParamModel;
    }

    public final void setAuid(String str) {
        C9649c.m27672j(str, "<set-?>");
        this.auid = str;
    }

    public final void setAvatarUrlField(C0177j<String> jVar) {
        C9649c.m27672j(jVar, "<set-?>");
        this.avatarUrlField = jVar;
    }

    public final void setCoverUrl(String str) {
        C9649c.m27672j(str, "<set-?>");
        this.coverUrl = str;
    }

    public final void setDesc(String str) {
        C9649c.m27672j(str, "<set-?>");
        this.desc = str;
    }

    public final void setNameField(C0177j<String> jVar) {
        C9649c.m27672j(jVar, "<set-?>");
        this.nameField = jVar;
    }

    public final void setTitle(String str) {
        C9649c.m27672j(str, "<set-?>");
        this.title = str;
    }

    public final void setTodoParamModel(TODOParamModel tODOParamModel) {
        C9649c.m27672j(tODOParamModel, "<set-?>");
        this.todoParamModel = tODOParamModel;
    }
}
