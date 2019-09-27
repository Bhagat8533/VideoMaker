package com.introvd.template.editor.player;

import android.content.Context;
import com.introvd.template.common.MSize;
import com.introvd.template.common.controller.MvpView;
import com.introvd.template.editor.player.p269b.C6501c;
import xiaoying.engine.QEngine;
import xiaoying.engine.clip.QClip;
import xiaoying.engine.clip.QEffect;
import xiaoying.engine.storyboard.QStoryboard;

/* renamed from: com.introvd.template.editor.player.a */
public interface C6482a extends MvpView {
    /* renamed from: a */
    void mo29676a(int i, C6501c cVar, boolean z);

    /* renamed from: a */
    void mo29677a(int i, QEffect qEffect);

    void aoe();

    void aoi();

    void aos();

    /* renamed from: b */
    void mo29685b(int i, QEffect qEffect);

    QClip getClip(int i);

    Context getContext();

    QStoryboard getStoryboard();

    MSize getStreamSize();

    MSize getSurfaceSize();

    QEngine getVEEngine();

    /* renamed from: og */
    void mo29698og(int i);

    void setPlayRange(int i, int i2, boolean z, int i3);
}
