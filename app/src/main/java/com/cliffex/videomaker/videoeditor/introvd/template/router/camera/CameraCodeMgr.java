package com.introvd.template.router.camera;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;

public class CameraCodeMgr {
    public static final int CAMERA_FEATURE_BACKWARD = 2048;
    public static final int CAMERA_FEATURE_BEAUTY = 8;
    public static final int CAMERA_FEATURE_DELAYTIME = 4096;
    public static final int CAMERA_FEATURE_FASTWARD = 512;
    public static final int CAMERA_FEATURE_FILM = 2;
    public static final int CAMERA_FEATURE_FREE = 1;
    public static final int CAMERA_FEATURE_FUNNY = 128;
    public static final int CAMERA_FEATURE_FX = 64;
    public static final int CAMERA_FEATURE_GALLERY = 65536;
    public static final int CAMERA_FEATURE_MASK = Integer.MAX_VALUE;
    public static final int CAMERA_FEATURE_MUSIC = 256;
    public static final int CAMERA_FEATURE_MV = 4;
    public static final int CAMERA_FEATURE_PERFECT = 32;
    public static final int CAMERA_FEATURE_PIP = 16;
    public static final int CAMERA_FEATURE_SLOWWARD = 1024;
    public static final int FLAG_CAMERA_GALLERY = 16;
    public static final int FLAG_CAMERA_MODE_FB = 10;
    public static final int FLAG_CAMERA_MODE_FUNNY = 8;
    public static final int FLAG_CAMERA_MODE_FX = 7;
    public static final int FLAG_CAMERA_MODE_LANDSCAPE = 512;
    public static final int FLAG_CAMERA_MODE_LANDSCAPE_LEFT = 512;
    public static final int FLAG_CAMERA_MODE_LANDSCAPE_RIGHT = 768;
    public static final int FLAG_CAMERA_MODE_MV = 6;
    public static final int FLAG_CAMERA_MODE_PARAM_DEFAULT = 1;
    public static final int FLAG_CAMERA_MODE_PARAM_UNKNOW = 0;
    public static final int FLAG_CAMERA_MODE_PERFECT = 12;
    public static final int FLAG_CAMERA_MODE_PIP = 9;
    public static final int FLAG_CAMERA_MODE_PORTRAIT = 256;
    public static final int FLAG_CAMERA_MODE_UNKNOW = 0;

    @Target({ElementType.FIELD, ElementType.PARAMETER})
    @Retention(RetentionPolicy.SOURCE)
    public @interface CameraMode {
    }

    public static ArrayList<Integer> getCamFeatureList(int i) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (!((i & 1) == 0 && (i & 2) == 0)) {
            arrayList.add(Integer.valueOf(1));
        }
        if ((i & 4) != 0) {
            arrayList.add(Integer.valueOf(6));
        }
        if ((i & 8) != 0) {
            arrayList.add(Integer.valueOf(10));
        }
        if ((i & 16) != 0) {
            arrayList.add(Integer.valueOf(9));
        }
        if ((i & 32) != 0) {
            arrayList.add(Integer.valueOf(12));
        }
        return arrayList;
    }

    public static int getCameraCode(int i, int i2) {
        return (i << 8) | i2;
    }

    public static int getCameraMode(int i) {
        return i >> 8;
    }

    public static int getCameraModeParam(int i) {
        return i & 255;
    }

    public static boolean isCameraParamDefault(int i) {
        return i == 1;
    }

    public static boolean isCameraParamFB(int i) {
        return i == 10;
    }

    public static boolean isCameraParamFX(int i) {
        return i == 7;
    }

    public static boolean isCameraParamFunny(int i) {
        return i == 8;
    }

    public static boolean isCameraParamMV(int i) {
        return i == 6;
    }

    public static boolean isCameraParamPIP(int i) {
        return i == 9;
    }

    public static boolean isCameraParamPerfect(int i) {
        return i == 12;
    }

    public static boolean isLandScapeMode(int i) {
        return i == 512 || i == 768;
    }

    public static boolean isParamBeautyEffectEnable(int i) {
        return i == 12 || i == 10;
    }

    public static boolean isParamBeautyEnable(int i) {
        return i == 12 || i == 10;
    }

    public static boolean isParamFacialEnable(int i) {
        return i == 12 || i == 10 || i == 6;
    }

    public static boolean isParamMVEnable(int i) {
        return i == 12 || i == 6;
    }

    public static boolean isParamMvNecessary(int i) {
        return i == 6;
    }

    public static boolean isParamRatioEnable(int i) {
        return i == 1 || i == 6 || i == 10;
    }

    public static boolean isParamSpeedEnable(int i) {
        return i == 1 || i == 10;
    }
}
