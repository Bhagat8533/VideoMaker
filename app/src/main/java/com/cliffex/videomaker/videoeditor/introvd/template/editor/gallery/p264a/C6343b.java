package com.introvd.template.editor.gallery.p264a;

import android.view.View;
import com.introvd.template.common.controller.MvpView;
import com.introvd.template.router.todoCode.TODOParamModel;
import com.introvd.template.sdk.editor.cache.TrimedClipItemDataModel;
import com.introvd.template.sdk.model.editor.EngineSubtitleInfoModel;
import java.util.List;

/* renamed from: com.introvd.template.editor.gallery.a.b */
public interface C6343b extends MvpView {
    /* renamed from: a */
    void mo29288a(TrimedClipItemDataModel trimedClipItemDataModel);

    /* renamed from: aR */
    void mo29289aR(List<EngineSubtitleInfoModel> list);

    int amA();

    TODOParamModel amo();

    /* renamed from: fV */
    void mo29295fV(boolean z);

    /* renamed from: fW */
    void mo29296fW(boolean z);

    void finishActivity();

    String getEntrance();

    long getTemplateID();

    /* renamed from: hP */
    void mo29300hP(String str);

    void onAdLoaded(View view);
}
