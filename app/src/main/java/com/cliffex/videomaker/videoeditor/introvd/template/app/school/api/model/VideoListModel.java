package com.introvd.template.app.school.api.model;

import java.util.List;
import p464d.p465a.C9633a;
import p464d.p466b.p467a.C9649c;

public final class VideoListModel {
    private List<VideoInfo> dataList = C9633a.emptyList();
    private int labelId;
    private int pageNum;

    public VideoListModel(int i) {
        this.labelId = i;
    }

    public final List<VideoInfo> getDataList() {
        return this.dataList;
    }

    public final int getLabelId() {
        return this.labelId;
    }

    public final int getPageNum() {
        return this.pageNum;
    }

    public final void setDataList(List<VideoInfo> list) {
        C9649c.m27672j(list, "<set-?>");
        this.dataList = list;
    }

    public final void setLabelId(int i) {
        this.labelId = i;
    }

    public final void setPageNum(int i) {
        this.pageNum = i;
    }
}
