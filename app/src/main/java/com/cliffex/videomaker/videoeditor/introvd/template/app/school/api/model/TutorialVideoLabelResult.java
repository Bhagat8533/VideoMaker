package com.introvd.template.app.school.api.model;

import android.support.annotation.Keep;
import java.util.List;
import p464d.p465a.C9633a;
import p464d.p466b.p467a.C9649c;

@Keep
public final class TutorialVideoLabelResult {
    private int count;
    private List<VideoLabelInfo> list = C9633a.emptyList();

    public final int getCount() {
        return this.count;
    }

    public final List<VideoLabelInfo> getList() {
        return this.list;
    }

    public final void setCount(int i) {
        this.count = i;
    }

    public final void setList(List<VideoLabelInfo> list2) {
        C9649c.m27672j(list2, "<set-?>");
        this.list = list2;
    }
}
