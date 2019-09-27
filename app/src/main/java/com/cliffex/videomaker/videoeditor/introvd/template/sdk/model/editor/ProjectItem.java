package com.introvd.template.sdk.model.editor;

import com.introvd.template.sdk.p380a.C8380a;
import xiaoying.engine.storyboard.QStoryboard;

public class ProjectItem extends C8380a implements Cloneable {
    public QStoryboard mStoryBoard;

    public ProjectItem(DataItemProject dataItemProject, QStoryboard qStoryboard) {
        super(dataItemProject, qStoryboard);
    }

    public ProjectItem clone() throws CloneNotSupportedException {
        ProjectItem projectItem = (ProjectItem) super.clone();
        if (this.mProjectDataItem != null) {
            projectItem.mProjectDataItem = this.mProjectDataItem.clone();
        }
        if (this.mClipModelCacheList != null) {
            projectItem.mClipModelCacheList = this.mClipModelCacheList.clone();
        }
        if (this.mStoryBoard != null) {
            QStoryboard qStoryboard = new QStoryboard();
            this.mStoryBoard.duplicate(qStoryboard);
            projectItem.mStoryBoard = qStoryboard;
        }
        return projectItem;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ProjectItem projectItem = (ProjectItem) obj;
        if (this.mProjectDataItem != null) {
            z = this.mProjectDataItem.equals(projectItem.mProjectDataItem);
        } else if (projectItem.mProjectDataItem != null) {
            z = false;
        }
        return z;
    }

    public QStoryboard getStoryboard() {
        return this.mStoryBoard;
    }

    public int hashCode() {
        if (this.mProjectDataItem != null) {
            return this.mProjectDataItem.hashCode();
        }
        return 0;
    }

    public void release() {
        if (this.mStoryBoard != null) {
            this.mStoryBoard.unInit();
            this.mStoryBoard = null;
        }
        if (this.mClipModelCacheList != null) {
            this.mClipModelCacheList.releaseAll();
        }
    }

    public final void setItem(DataItemProject dataItemProject, QStoryboard qStoryboard) {
        this.mProjectDataItem = dataItemProject;
        this.mStoryBoard = qStoryboard;
    }

    public void setStoryboard(QStoryboard qStoryboard) {
        this.mStoryBoard = qStoryboard;
    }
}
