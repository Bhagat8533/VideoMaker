package com.introvd.template.sdk.slide;

import com.introvd.template.sdk.model.editor.DataItemProject;
import com.introvd.template.sdk.p380a.C8380a;
import xiaoying.engine.slideshowsession.QSlideShowSession;
import xiaoying.engine.storyboard.QStoryboard;

/* renamed from: com.introvd.template.sdk.slide.b */
public class C8467b extends C8380a {
    public QSlideShowSession dfW;

    public C8467b(DataItemProject dataItemProject, QStoryboard qStoryboard) {
        super(dataItemProject, qStoryboard);
    }

    public QStoryboard getStoryboard() {
        if (this.dfW == null) {
            return null;
        }
        return this.dfW.GetStoryboard();
    }

    /* renamed from: jp */
    public void mo34596jp(boolean z) {
        this.isTemplateFileLosted = z;
    }

    /* renamed from: jq */
    public void mo34597jq(boolean z) {
        this.isClipSourceFileLosted = z;
    }

    public void release() {
        if (this.dfW != null) {
            this.dfW.unInit();
        }
        if (this.mClipModelCacheList != null) {
            this.mClipModelCacheList.releaseAll();
        }
    }

    public void setItem(DataItemProject dataItemProject, QStoryboard qStoryboard) {
        this.mProjectDataItem = dataItemProject;
    }
}
