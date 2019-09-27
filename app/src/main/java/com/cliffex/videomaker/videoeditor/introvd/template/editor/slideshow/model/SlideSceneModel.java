package com.introvd.template.editor.slideshow.model;

import android.graphics.Bitmap;

public class SlideSceneModel extends SlideModel {
    private Bitmap thumbnail;

    public static final class Builder {
        /* access modifiers changed from: private */
        public int index;
        /* access modifiers changed from: private */
        public boolean isFocus;
        /* access modifiers changed from: private */
        public int previewPos;
        /* access modifiers changed from: private */
        public Bitmap thumbnail;

        public SlideSceneModel build() {
            return new SlideSceneModel(this);
        }

        public Builder index(int i) {
            this.index = i;
            return this;
        }

        public Builder isFocus(boolean z) {
            this.isFocus = z;
            return this;
        }

        public Builder previewPos(int i) {
            this.previewPos = i;
            return this;
        }

        public Builder thumbnail(Bitmap bitmap) {
            this.thumbnail = bitmap;
            return this;
        }
    }

    private SlideSceneModel(Builder builder) {
        setIndex(builder.index);
        setPreviewPos(builder.previewPos);
        setFocus(builder.isFocus);
        this.thumbnail = builder.thumbnail;
    }

    public Bitmap getThumbnail() {
        return this.thumbnail;
    }

    public void setThumbnail(Bitmap bitmap) {
        this.thumbnail = bitmap;
    }
}
