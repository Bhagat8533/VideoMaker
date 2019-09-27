package com.introvd.template.app.school.api.model;

import android.support.annotation.Keep;
import java.util.List;
import p464d.p465a.C9633a;
import p464d.p466b.p467a.C9649c;

@Keep
public final class VideoListResult {
    private Number count = Integer.valueOf(0);
    private List<VideoInfo> list = C9633a.emptyList();

    public final Number getCount() {
        return this.count;
    }

    public final List<VideoInfo> getList() {
        return this.list;
    }

    public final void setCount(Number number) {
        C9649c.m27672j(number, "<set-?>");
        this.count = number;
    }

    public final void setList(List<VideoInfo> list2) {
        C9649c.m27672j(list2, "<set-?>");
        this.list = list2;
    }
}
