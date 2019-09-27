package com.introvd.template.sdk;

import android.text.TextUtils;

/* renamed from: com.introvd.template.sdk.d */
public class C8401d {
    private static String APP_CACHE_PATH = "";
    private static String APP_DATA_PATH = "";
    private static String APP_DEFAULT_EXPORT_PATH = "";
    private static String APP_PRIVATE_ROOT_PATH = "";
    private static String APP_PROJECT_PATH = "";
    public static int MAX_EXPORT_RESOLUTION_HEIGHT = 480;
    public static int MAX_EXPORT_RESOLUTION_WIDTH = 640;
    private static String ROOT_PATH = "";
    private static String cce = "";
    private static String ccf = "";
    static C8396c ebG = null;
    private static String ebH = "";

    public static String aGQ() {
        if (TextUtils.isEmpty(ROOT_PATH) && ebG != null) {
            ROOT_PATH = ebG.ane();
        }
        TextUtils.isEmpty(ROOT_PATH);
        return ROOT_PATH;
    }

    public static String aGR() {
        StringBuilder sb = new StringBuilder();
        sb.append(and());
        sb.append("Templates/");
        return sb.toString();
    }

    public static String aGS() {
        StringBuilder sb = new StringBuilder();
        sb.append(anf());
        sb.append("tmp/");
        return sb.toString();
    }

    public static String aGT() {
        StringBuilder sb = new StringBuilder();
        sb.append(ang());
        sb.append(".templates2/");
        return sb.toString();
    }

    public static String and() {
        if (TextUtils.isEmpty(APP_DATA_PATH) && ebG != null) {
            APP_DATA_PATH = ebG.and();
        }
        TextUtils.isEmpty(APP_DATA_PATH);
        return APP_DATA_PATH;
    }

    public static String ane() {
        if (TextUtils.isEmpty(APP_PROJECT_PATH) && ebG != null) {
            APP_PROJECT_PATH = ebG.ane();
        }
        TextUtils.isEmpty(APP_PROJECT_PATH);
        return APP_PROJECT_PATH;
    }

    public static String anf() {
        if (TextUtils.isEmpty(APP_CACHE_PATH) && ebG != null) {
            APP_CACHE_PATH = ebG.anf();
        }
        TextUtils.isEmpty(APP_CACHE_PATH);
        return APP_CACHE_PATH;
    }

    public static String ang() {
        if (TextUtils.isEmpty(APP_PRIVATE_ROOT_PATH) && ebG != null) {
            APP_PRIVATE_ROOT_PATH = ebG.ang();
        }
        TextUtils.isEmpty(APP_PRIVATE_ROOT_PATH);
        return APP_PRIVATE_ROOT_PATH;
    }

    public static String anh() {
        if (TextUtils.isEmpty(APP_DEFAULT_EXPORT_PATH) && ebG != null) {
            APP_DEFAULT_EXPORT_PATH = ebG.anh();
        }
        TextUtils.isEmpty(APP_DEFAULT_EXPORT_PATH);
        return APP_DEFAULT_EXPORT_PATH;
    }

    public static String getAudioSavePath() {
        if (TextUtils.isEmpty(ccf) && ebG != null) {
            ccf = ebG.getAudioSavePath();
        }
        TextUtils.isEmpty(ccf);
        return ccf;
    }

    public static String getMediaSavePath() {
        if (TextUtils.isEmpty(cce) && ebG != null) {
            cce = ebG.getMediaSavePath();
        }
        TextUtils.isEmpty(cce);
        return cce;
    }

    public static String getMediaStorageRelativePath() {
        if (TextUtils.isEmpty(ebH) && ebG != null) {
            ebH = ebG.getMediaStorageRelativePath();
        }
        TextUtils.isEmpty(ebH);
        return ebH;
    }
}
