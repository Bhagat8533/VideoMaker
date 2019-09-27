package com.introvd.template.router.camera;

import com.introvd.template.router.explorer.MusicDataItem;
import java.io.Serializable;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class CameraIntentInfo implements Serializable {
    public static final int ADJUST_CAMERA_BACK = 0;
    public static final int ADJUST_CAMERA_BOTH = 2;
    public static final int ADJUST_CAMERA_FRONT = 1;
    public static final int ADJUST_CAMERA_NONE = -1;
    public static final int INTENT_MODE_ACTIVITY = 4099;
    public static final int INTENT_MODE_AD_EDITER = 4098;
    public static final int INTENT_MODE_CAMERA = 4100;
    public static final int INTENT_MODE_CAM_ADJUST = 4102;
    public static final int INTENT_MODE_EDIT_PIP = 4103;
    public static final int INTENT_MODE_NORMAL = 4097;
    public static final int INTENT_MODE_SIMPLE_EDIT = 4101;
    public static final int NORMAL_CAPTURE = 0;
    public static final int PERFECT_CAPTURE = 1;
    public String activityID;
    public boolean bNewCam;
    public int cameraAdjustMode;
    public int cameraIntent;
    public int cameraMode;
    public int cameraModeParam;
    public int captureMode;
    public int intentClipInsertPosition;
    public long magicCode;
    public MusicDataItem musicDataItem;
    public int newPrj;
    public String stickerPath;

    public static class Builder implements Serializable {
        /* access modifiers changed from: private */
        public String activityID;
        /* access modifiers changed from: private */
        public boolean bNewCam;
        /* access modifiers changed from: private */
        public int cameraAdjustMode = 0;
        /* access modifiers changed from: private */
        public int cameraIntent = 4097;
        /* access modifiers changed from: private */
        public int cameraMode;
        /* access modifiers changed from: private */
        public int cameraModeParam = 0;
        /* access modifiers changed from: private */
        public int captureMode = 0;
        /* access modifiers changed from: private */
        public int intentClipInsertPosition = -1;
        /* access modifiers changed from: private */
        public long magicCode = 0;
        /* access modifiers changed from: private */
        public MusicDataItem musicDataItem;
        /* access modifiers changed from: private */
        public int newPrj = 1;
        /* access modifiers changed from: private */
        public String stickerPath;

        public CameraIntentInfo build() {
            return new CameraIntentInfo(this);
        }

        public Builder setActivityID(String str) {
            this.activityID = str;
            return this;
        }

        public Builder setCameraAdjustMode(int i) {
            this.cameraAdjustMode = i;
            return this;
        }

        public Builder setCameraIntent(int i) {
            this.cameraIntent = i;
            return this;
        }

        public Builder setCameraMode(int i) {
            this.cameraMode = i;
            return this;
        }

        public Builder setCameraModeParam(int i) {
            this.cameraModeParam = i;
            return this;
        }

        public Builder setCaptureMode(int i) {
            this.captureMode = i;
            return this;
        }

        public Builder setIntentClipInsertPosition(int i) {
            this.intentClipInsertPosition = i;
            return this;
        }

        public Builder setMagicCode(long j) {
            this.magicCode = j;
            return this;
        }

        public Builder setMusicDataItem(MusicDataItem musicDataItem2) {
            this.musicDataItem = musicDataItem2;
            return this;
        }

        public Builder setNewPrj(int i) {
            this.newPrj = i;
            return this;
        }

        public Builder setStickerPath(String str) {
            this.stickerPath = str;
            return this;
        }

        public Builder setbNewCam(boolean z) {
            this.bNewCam = z;
            return this;
        }
    }

    @Target({ElementType.FIELD, ElementType.PARAMETER})
    @Retention(RetentionPolicy.SOURCE)
    public @interface CameraAdjustMode {
    }

    @Target({ElementType.FIELD, ElementType.PARAMETER})
    @Retention(RetentionPolicy.SOURCE)
    public @interface CameraIntent {
    }

    @Target({ElementType.FIELD, ElementType.PARAMETER})
    @Retention(RetentionPolicy.SOURCE)
    public @interface CaptureMode {
    }

    public CameraIntentInfo(Builder builder) {
        this.cameraIntent = builder.cameraIntent;
        this.cameraModeParam = builder.cameraModeParam;
        this.cameraAdjustMode = builder.cameraAdjustMode;
        this.newPrj = builder.newPrj;
        this.activityID = builder.activityID;
        this.magicCode = builder.magicCode;
        this.captureMode = builder.captureMode;
        this.intentClipInsertPosition = builder.intentClipInsertPosition;
        this.bNewCam = builder.bNewCam;
        this.cameraMode = builder.cameraMode;
        this.musicDataItem = builder.musicDataItem;
        this.stickerPath = builder.stickerPath;
    }
}
