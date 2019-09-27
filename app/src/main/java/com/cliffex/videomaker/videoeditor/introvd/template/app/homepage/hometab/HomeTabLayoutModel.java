package com.introvd.template.app.homepage.hometab;

import android.databinding.C0177j;
import android.support.annotation.Keep;
import p464d.p466b.p467a.C9649c;

@Keep
public final class HomeTabLayoutModel {
    private C0177j<String> bgUrlField = new C0177j<>("");
    private HomeTabModel creationTabModel = new HomeTabModel();
    private C0177j<Integer> lastFocusTabIdField = new C0177j<>(Integer.valueOf(-1));
    private HomeTabModel msgTabModel = new HomeTabModel();
    private HomeTabModel schoolTabModel = new HomeTabModel();
    private HomeTabModel studioTabModel = new HomeTabModel();
    private HomeTabModel videoTabModel = new HomeTabModel();

    public final C0177j<String> getBgUrlField() {
        return this.bgUrlField;
    }

    public final HomeTabModel getCreationTabModel() {
        return this.creationTabModel;
    }

    public final C0177j<Integer> getLastFocusTabIdField() {
        return this.lastFocusTabIdField;
    }

    public final HomeTabModel getMsgTabModel() {
        return this.msgTabModel;
    }

    public final HomeTabModel getSchoolTabModel() {
        return this.schoolTabModel;
    }

    public final HomeTabModel getStudioTabModel() {
        return this.studioTabModel;
    }

    public final HomeTabModel getVideoTabModel() {
        return this.videoTabModel;
    }

    public final void setBgUrlField(C0177j<String> jVar) {
        C9649c.m27672j(jVar, "<set-?>");
        this.bgUrlField = jVar;
    }

    public final void setCreationTabModel(HomeTabModel homeTabModel) {
        C9649c.m27672j(homeTabModel, "<set-?>");
        this.creationTabModel = homeTabModel;
    }

    public final void setLastFocusTabIdField(C0177j<Integer> jVar) {
        C9649c.m27672j(jVar, "<set-?>");
        this.lastFocusTabIdField = jVar;
    }

    public final void setMsgTabModel(HomeTabModel homeTabModel) {
        C9649c.m27672j(homeTabModel, "<set-?>");
        this.msgTabModel = homeTabModel;
    }

    public final void setSchoolTabModel(HomeTabModel homeTabModel) {
        C9649c.m27672j(homeTabModel, "<set-?>");
        this.schoolTabModel = homeTabModel;
    }

    public final void setStudioTabModel(HomeTabModel homeTabModel) {
        C9649c.m27672j(homeTabModel, "<set-?>");
        this.studioTabModel = homeTabModel;
    }

    public final void setVideoTabModel(HomeTabModel homeTabModel) {
        C9649c.m27672j(homeTabModel, "<set-?>");
        this.videoTabModel = homeTabModel;
    }
}
