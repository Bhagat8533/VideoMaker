package com.introvd.template.editor.slideshow.model;

import android.graphics.Bitmap;
import com.introvd.template.sdk.editor.cache.TrimedClipItemDataModel;
import xiaoying.engine.base.QTextAnimationInfo;

public class SlideNodeModel extends SlideModel {
    private TrimedClipItemDataModel dataModel;
    private int durationLimit;
    private boolean hasSetSource;
    private QTextAnimationInfo[] textAnimInfoArray;

    public static final class Builder {
        /* access modifiers changed from: private */
        public TrimedClipItemDataModel dataModel;
        /* access modifiers changed from: private */
        public int durationLimit;
        /* access modifiers changed from: private */
        public boolean hasSetSource;
        /* access modifiers changed from: private */
        public int index;
        /* access modifiers changed from: private */
        public boolean isFocus;
        /* access modifiers changed from: private */
        public int previewPos;
        /* access modifiers changed from: private */
        public QTextAnimationInfo[] textAnimInfoArray;

        public SlideNodeModel build() {
            return new SlideNodeModel(this);
        }

        public Builder dataModel(TrimedClipItemDataModel trimedClipItemDataModel) {
            this.dataModel = trimedClipItemDataModel;
            return this;
        }

        public Builder durationLimit(int i) {
            this.durationLimit = i;
            return this;
        }

        public Builder hasSetSource(boolean z) {
            this.hasSetSource = z;
            return this;
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

        public Builder textAnimInfoArray(QTextAnimationInfo[] qTextAnimationInfoArr) {
            this.textAnimInfoArray = qTextAnimationInfoArr;
            return this;
        }
    }

    private SlideNodeModel(Builder builder) {
        this.index = builder.index;
        this.previewPos = builder.previewPos;
        this.isFocus = builder.isFocus;
        this.durationLimit = builder.durationLimit;
        this.hasSetSource = builder.hasSetSource;
        this.dataModel = builder.dataModel;
        this.textAnimInfoArray = builder.textAnimInfoArray;
    }

    public boolean containTextAnimation() {
        return this.textAnimInfoArray != null && this.textAnimInfoArray.length > 0;
    }

    public TrimedClipItemDataModel getDataModel() {
        return this.dataModel;
    }

    public int getDurationLimit() {
        return this.durationLimit;
    }

    public QTextAnimationInfo[] getTextAnimInfoArray() {
        return this.textAnimInfoArray;
    }

    public Bitmap getThumbnail() {
        if (this.dataModel != null) {
            return this.dataModel.mThumbnail;
        }
        return null;
    }

    public boolean isHasSetSource() {
        return this.hasSetSource;
    }

    public void setDataModel(TrimedClipItemDataModel trimedClipItemDataModel) {
        this.dataModel = trimedClipItemDataModel;
        this.hasSetSource = trimedClipItemDataModel != null;
    }

    public void setDurationLimit(int i) {
        this.durationLimit = i;
    }

    public void setHasSetSource(boolean z) {
        this.hasSetSource = z;
    }

    public void setTextAnimInfoArray(QTextAnimationInfo[] qTextAnimationInfoArr) {
        this.textAnimInfoArray = qTextAnimationInfoArr;
    }

    public void updateThumbnail(Bitmap bitmap) {
        if (this.dataModel != null) {
            this.dataModel.mThumbnail = bitmap;
        }
    }
}
