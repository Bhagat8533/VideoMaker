package com.introvd.template.editor.slideshow.model;

public class SlideModel {
    protected int index;
    protected boolean isFocus;
    protected int previewPos;

    public int getIndex() {
        return this.index;
    }

    public int getPreviewPos() {
        return this.previewPos;
    }

    public boolean isFocus() {
        return this.isFocus;
    }

    public void setFocus(boolean z) {
        this.isFocus = z;
    }

    public void setIndex(int i) {
        this.index = i;
    }

    public void setPreviewPos(int i) {
        this.previewPos = i;
    }
}
