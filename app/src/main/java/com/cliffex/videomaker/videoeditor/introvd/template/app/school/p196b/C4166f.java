package com.introvd.template.app.school.p196b;

import com.introvd.template.app.school.api.model.VideoInfo;
import java.util.List;
import p464d.p466b.p467a.C9649c;

/* renamed from: com.introvd.template.app.school.b.f */
public final class C4166f {
    private List<VideoInfo> dataList;
    private int labelId;
    private int pageNum;
    private int totalCount;

    public C4166f(int i, List<VideoInfo> list, int i2, int i3) {
        C9649c.m27672j(list, "dataList");
        this.labelId = i;
        this.dataList = list;
        this.pageNum = i2;
        this.totalCount = i3;
    }

    /* renamed from: Oi */
    public final int mo23995Oi() {
        return this.totalCount;
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
}
