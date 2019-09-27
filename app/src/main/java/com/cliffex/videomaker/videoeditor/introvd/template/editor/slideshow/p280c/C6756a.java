package com.introvd.template.editor.slideshow.p280c;

import android.app.Activity;
import android.widget.RelativeLayout;
import com.introvd.template.common.controller.MvpView;
import com.introvd.template.editor.slideshow.model.SlideNodeModel;
import com.introvd.template.router.todoCode.TODOParamModel;
import com.introvd.template.sdk.editor.cache.TrimedClipItemDataModel;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.introvd.template.editor.slideshow.c.a */
public interface C6756a extends MvpView {
    /* renamed from: a */
    void mo30196a(int i, TrimedClipItemDataModel trimedClipItemDataModel);

    void abA();

    ArrayList<TrimedClipItemDataModel> aqN();

    long aqO();

    String aqP();

    TODOParamModel aqQ();

    String aqR();

    RelativeLayout aqS();

    ArrayList<TrimedClipItemDataModel> aqT();

    /* renamed from: bx */
    void mo30205bx(List<SlideNodeModel> list);

    /* renamed from: cP */
    void mo30206cP(int i, int i2);

    /* renamed from: cQ */
    void mo30207cQ(int i, int i2);

    /* renamed from: gY */
    void mo30208gY(boolean z);

    Activity getActivity();

    int getFocusIndex();

    /* renamed from: oZ */
    void mo30211oZ(int i);

    void updateProgress(int i);
}
