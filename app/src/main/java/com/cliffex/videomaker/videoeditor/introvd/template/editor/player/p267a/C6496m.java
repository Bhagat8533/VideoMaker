package com.introvd.template.editor.player.p267a;

import com.introvd.template.editor.player.p267a.p268a.C6484a;
import com.introvd.template.sdk.model.editor.ScaleRotateViewState;
import xiaoying.engine.cover.QCover;

/* renamed from: com.introvd.template.editor.player.a.m */
public class C6496m extends C6484a {
    public ScaleRotateViewState cZj;
    public boolean cZk = false;
    public QCover cZl;
    public String cZm;
    public int groupId = 0;
    public int index = 0;

    public C6496m(int i) {
        super(i);
    }

    /* renamed from: a */
    public C6496m mo29737a(QCover qCover) {
        this.cZl = qCover;
        return this;
    }

    /* renamed from: go */
    public C6496m mo29738go(boolean z) {
        this.cZk = z;
        return this;
    }

    /* renamed from: ij */
    public C6496m mo29739ij(String str) {
        this.cZm = str;
        return this;
    }

    /* renamed from: o */
    public C6496m mo29740o(ScaleRotateViewState scaleRotateViewState) {
        this.cZj = scaleRotateViewState;
        return this;
    }

    /* renamed from: ol */
    public C6496m mo29741ol(int i) {
        this.index = i;
        return this;
    }

    /* renamed from: om */
    public C6496m mo29742om(int i) {
        this.groupId = i;
        return this;
    }
}
