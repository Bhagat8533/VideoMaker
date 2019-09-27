package com.introvd.template.router.editor.gallery;

import java.io.Serializable;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;

public class GalleryIntentInfo implements Serializable {
    public static final int ACTION_CAMERA = 4;
    public static final int ACTION_EDITOR = 2;
    public static final int ACTION_NORMAL = 0;
    public static final int ACTION_PIP = 1;
    public static final int ACTION_SINGEFILE = 7;
    public static final int ACTION_SINGEIMAGE = 6;
    public static final int ACTION_SINGLEVIDEO = 8;
    public static final int ACTION_SINGLEVIDEO_TO_MUSIC_EXTRACT = 9;
    public static final int ACTION_SLIDE = 5;
    public static final int ACTION_SLIDE_SPECIFIC = 10;
    public static final int ACTION_TEMPLATE = 3;
    public static final int MODE_BOTH = 0;
    public static final int MODE_IMAGE_ONLY = 2;
    public static final int MODE_VIDEO_ONLY = 1;
    private static final long serialVersionUID = -4418893418077841085L;
    private int action;
    private String activityId;
    private int extraIntentMode;
    private boolean focusPhotoTab;
    private int imageDuration;
    private ArrayList<String> inputPathList;
    private int limitRangeCount;
    private long magicCode;
    private int minRangeCount;
    private boolean newPrj;
    private int sourceMode;
    private String strTCID;
    private long templateID;

    public static class Builder implements Serializable {
        /* access modifiers changed from: private */
        public int action = 0;
        /* access modifiers changed from: private */
        public String activityId;
        /* access modifiers changed from: private */
        public int extraIntentMode;
        /* access modifiers changed from: private */
        public boolean focusPhotoTab;
        /* access modifiers changed from: private */
        public int imageDuration;
        /* access modifiers changed from: private */
        public ArrayList<String> inputPathList;
        /* access modifiers changed from: private */
        public int limitRangeCount = 1073741823;
        /* access modifiers changed from: private */
        public long magicCode;
        /* access modifiers changed from: private */
        public int minRangeCount = 0;
        /* access modifiers changed from: private */
        public boolean newPrj = true;
        /* access modifiers changed from: private */
        public int sourceMode = 0;
        /* access modifiers changed from: private */
        public String strTCID;
        /* access modifiers changed from: private */
        public long templateID;

        public GalleryIntentInfo build() {
            return new GalleryIntentInfo(this);
        }

        public Builder setAction(int i) {
            this.action = i;
            return this;
        }

        public Builder setActivityId(String str) {
            this.activityId = str;
            return this;
        }

        public Builder setExtraIntentMode(int i) {
            this.extraIntentMode = i;
            return this;
        }

        public Builder setFocusPhotoTab(boolean z) {
            this.focusPhotoTab = z;
            return this;
        }

        public Builder setImageDuration(int i) {
            this.imageDuration = i;
            return this;
        }

        public Builder setInputPathList(ArrayList<String> arrayList) {
            this.inputPathList = arrayList;
            return this;
        }

        public Builder setLimitRangeCount(int i) {
            this.limitRangeCount = i;
            return this;
        }

        public Builder setMagicCode(long j) {
            this.magicCode = j;
            return this;
        }

        public Builder setMinRangeCount(int i) {
            this.minRangeCount = i;
            return this;
        }

        public Builder setNewPrj(boolean z) {
            this.newPrj = z;
            return this;
        }

        public Builder setSourceMode(int i) {
            this.sourceMode = i;
            return this;
        }

        public Builder setStrTCID(String str) {
            this.strTCID = str;
            return this;
        }

        public Builder setTemplateID(long j) {
            this.templateID = j;
            return this;
        }
    }

    @Target({ElementType.FIELD, ElementType.PARAMETER})
    @Retention(RetentionPolicy.SOURCE)
    public @interface GalleryAction {
    }

    @Target({ElementType.FIELD, ElementType.PARAMETER})
    @Retention(RetentionPolicy.SOURCE)
    public @interface GallerySource {
    }

    private GalleryIntentInfo(Builder builder) {
        this.minRangeCount = 0;
        this.limitRangeCount = 1073741823;
        this.magicCode = builder.magicCode;
        this.action = builder.action;
        this.sourceMode = builder.sourceMode;
        this.newPrj = builder.newPrj;
        this.imageDuration = builder.imageDuration;
        this.extraIntentMode = builder.extraIntentMode;
        this.activityId = builder.activityId;
        this.inputPathList = builder.inputPathList;
        this.strTCID = builder.strTCID;
        this.templateID = builder.templateID;
        this.focusPhotoTab = builder.focusPhotoTab;
        this.minRangeCount = builder.minRangeCount;
        this.limitRangeCount = builder.limitRangeCount;
    }

    public int getAction() {
        return this.action;
    }

    public String getActivityId() {
        return this.activityId;
    }

    public int getExtraIntentMode() {
        return this.extraIntentMode;
    }

    public int getImageDuration() {
        return this.imageDuration;
    }

    public ArrayList<String> getInputPathList() {
        return this.inputPathList;
    }

    public int getLimitRangeCount() {
        return this.limitRangeCount;
    }

    public long getMagicCode() {
        return this.magicCode;
    }

    public int getMinRangeCount() {
        return this.minRangeCount;
    }

    public int getSourceMode() {
        return this.sourceMode;
    }

    public String getStrTCID() {
        return this.strTCID;
    }

    public long getTemplateID() {
        return this.templateID;
    }

    public boolean isFocusPhotoTab() {
        return this.focusPhotoTab;
    }

    public boolean isNewPrj() {
        return this.newPrj;
    }

    public void setAction(int i) {
        this.action = i;
    }

    public void setExtraIntentMode(int i) {
        this.extraIntentMode = i;
    }

    public void setImageDuration(int i) {
        this.imageDuration = i;
    }

    public void setMagicCode(long j) {
        this.magicCode = j;
    }

    public void setNewPrj(boolean z) {
        this.newPrj = z;
    }

    public void setSourceMode(int i) {
        this.sourceMode = i;
    }
}
