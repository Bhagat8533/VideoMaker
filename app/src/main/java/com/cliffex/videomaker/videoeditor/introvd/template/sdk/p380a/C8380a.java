package com.introvd.template.sdk.p380a;

import com.introvd.template.sdk.editor.cache.C8443d;
import com.introvd.template.sdk.model.editor.DataItemProject;
import xiaoying.engine.storyboard.QStoryboard;

/* renamed from: com.introvd.template.sdk.a.a */
public class C8380a {
    public static final int FLAG_CLIPMODEL_LOADED = 8;
    public static final int FLAG_CLIPMODEL_LOADING = 4;
    public static final int FLAG_STORYBOARD_LOADED = 2;
    public static final int FLAG_STORYBOARD_LOADING = 1;
    public boolean isClipSourceFileLosted = false;
    public boolean isTemplateFileLosted = false;
    public long lLastUpdateTime = 0;
    public C8443d mClipModelCacheList = new C8443d();
    protected int mLoadedFlag = 0;
    public DataItemProject mProjectDataItem;

    public C8380a(DataItemProject dataItemProject, QStoryboard qStoryboard) {
        setItem(dataItemProject, qStoryboard);
    }

    public synchronized int getCacheFlag() {
        return this.mLoadedFlag;
    }

    public QStoryboard getStoryboard() {
        return null;
    }

    public synchronized void setCacheFlag(int i, boolean z) {
        if (z) {
            try {
                this.mLoadedFlag = i | this.mLoadedFlag;
            } catch (Throwable th) {
                throw th;
            }
        } else {
            this.mLoadedFlag = (~i) & this.mLoadedFlag;
        }
    }

    public void setItem(DataItemProject dataItemProject, QStoryboard qStoryboard) {
    }

    public void setStoryboard(QStoryboard qStoryboard) {
    }
}
