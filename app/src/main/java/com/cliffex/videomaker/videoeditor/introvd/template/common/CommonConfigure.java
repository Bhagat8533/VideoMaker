package com.introvd.template.common;

import android.os.Environment;
import android.text.TextUtils;
import java.io.File;
import xiaoying.engine.base.QUtils;

public class CommonConfigure {
    public static String APP_ANALYSIS_PATH = null;
    public static String APP_ANIMATEFRAME_PATH = null;
    public static String APP_AUTOCUT_PATH = null;
    public static String APP_BUBBLE_FRAME_PATH = null;
    public static String APP_BUBBLE_FRAME_PATH_DEFAULT = null;
    public static String APP_CACHE_PATH = null;
    public static String APP_COVER_PATH = null;
    public static String APP_COVER_TEMP_PATH = null;
    public static String APP_CRASH_PATH = null;
    public static String APP_DATA_PATH = null;
    public static String APP_DATA_PATH_INNER = null;
    public static String APP_DATA_PATH_RELATIVE = null;
    public static String APP_DB_PATH_INTERNAL = null;
    public static String APP_DEFAULTMUSIC_PATH = null;
    public static int APP_DEFAULT_AUDIO_SAMPLERATE = 16000;
    public static String APP_DEFAULT_EXPORT_PATH = null;
    public static String APP_DEFAULT_EXPORT_SUB_PATH = null;
    public static String APP_DEFAULT_SOCIALCACHE_PATH = null;
    public static String APP_DEFAULT_WATER_MARK_PATH = null;
    public static String APP_DIVA_PATH = null;
    public static String APP_DOWNLOAD_PATH = null;
    public static String APP_DOWNLOAD_TEMPLATES_PATH = null;
    public static String APP_EFFECT_PATH = null;
    public static String APP_EFFECT_PATH_DEFAULT = null;
    public static String APP_HELP_PATH = null;
    public static String APP_HW_LIBRARY_PATH = null;
    public static String APP_LIBRARY_PATH = null;
    public static String APP_LOG_PATH = null;
    public static String APP_PACKAGE_FULLNAME = "com.quvideo.xiaoying";
    public static String APP_PACKAGE_NAME = "XiaoYing";
    public static String APP_PATH_INTERNAL_FAKESDCARD = null;
    public static String APP_PATH_INTERNAL_ROOT = null;
    public static String APP_PATH_INTERNAL_TEMPLATES = null;
    public static String APP_POSTER_PATH = null;
    public static String APP_POSTER_PATH_DEFAULT = null;
    public static String APP_PRIVATE_FONT_PATH = null;
    public static String APP_PRIVATE_ROOT_PATH = null;
    public static String APP_PROJECT_PATH = null;
    public static String APP_PUBLIC_ROOT_PATH = null;
    public static String APP_SOCIAL_SERVER_URL_CFG_FULLNAME = null;
    public static String APP_TEXT_FRAME_PATH = null;
    public static String APP_TEXT_FRAME_PATH_DEFAULT = null;
    public static String APP_TEXT_PATH = null;
    public static String APP_THEME_PATH = null;
    public static String APP_THEME_PATH_DEFAULT = null;
    public static String APP_TRANSITION_PATH = null;
    public static String APP_TRANSITION_PATH_DEFAULT = null;
    public static String APP_WATER_MARK_PATH = null;
    public static String CAMERA_VIDEO_RELATIVE_PATH = "DCIM/StarVideo/";
    public static boolean EN_APP_KILL_PROCESS = false;
    public static boolean IS_CRASH_LOG_UPLOAD = false;
    public static int MAX_EXPORT_RESOLUTION_HEIGHT = 480;
    public static int MAX_EXPORT_RESOLUTION_WIDTH = QUtils.VIDEO_RES_VGA_WIDTH;
    public static int MAX_UPLOAD_DURATION = 300000;
    public static String PATH_SDCARD;
    public static String ROOT_PATH;
    private static String cce;
    private static String ccf;
    private static String ccg = null;
    private static String cch = "";

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(APP_PACKAGE_NAME);
        sb.append("/");
        APP_DATA_PATH_RELATIVE = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("/");
        sb2.append(Environment.DIRECTORY_DCIM);
        sb2.append("/");
        sb2.append(APP_PACKAGE_NAME);
        sb2.append("/");
        APP_DEFAULT_EXPORT_SUB_PATH = sb2.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append("/data/data/");
        sb3.append(APP_PACKAGE_FULLNAME);
        APP_PATH_INTERNAL_ROOT = sb3.toString();
        StringBuilder sb4 = new StringBuilder();
        sb4.append(APP_PATH_INTERNAL_ROOT);
        sb4.append("/FakeSD");
        APP_PATH_INTERNAL_FAKESDCARD = sb4.toString();
        StringBuilder sb5 = new StringBuilder();
        sb5.append(APP_PATH_INTERNAL_ROOT);
        sb5.append("/database/");
        APP_DB_PATH_INTERNAL = sb5.toString();
        StringBuilder sb6 = new StringBuilder();
        sb6.append(APP_PATH_INTERNAL_ROOT);
        sb6.append("/lib/");
        APP_LIBRARY_PATH = sb6.toString();
        StringBuilder sb7 = new StringBuilder();
        sb7.append(APP_PATH_INTERNAL_ROOT);
        sb7.append("/so/");
        APP_HW_LIBRARY_PATH = sb7.toString();
        StringBuilder sb8 = new StringBuilder();
        sb8.append(APP_PATH_INTERNAL_ROOT);
        sb8.append("/");
        sb8.append("serverurl.ini");
        APP_SOCIAL_SERVER_URL_CFG_FULLNAME = sb8.toString();
        StringBuilder sb9 = new StringBuilder();
        sb9.append(Environment.getExternalStorageDirectory().getPath());
        sb9.append("/");
        sb9.append(APP_PACKAGE_NAME);
        sb9.append("/.private/");
        APP_PRIVATE_ROOT_PATH = sb9.toString();
        StringBuilder sb10 = new StringBuilder();
        sb10.append(Environment.getExternalStorageDirectory().getPath());
        sb10.append("/");
        sb10.append(APP_PACKAGE_NAME);
        sb10.append("/.public/");
        APP_PUBLIC_ROOT_PATH = sb10.toString();
        StringBuilder sb11 = new StringBuilder();
        sb11.append(APP_PRIVATE_ROOT_PATH);
        sb11.append("tmp/");
        APP_DATA_PATH_INNER = sb11.toString();
        StringBuilder sb12 = new StringBuilder();
        sb12.append(Environment.getExternalStorageDirectory().getPath());
        sb12.append("/Android/data/");
        sb12.append(APP_PACKAGE_FULLNAME);
        sb12.append("/cache/");
        APP_CACHE_PATH = sb12.toString();
        StringBuilder sb13 = new StringBuilder();
        sb13.append(APP_PRIVATE_ROOT_PATH);
        sb13.append("crash/");
        APP_CRASH_PATH = sb13.toString();
        StringBuilder sb14 = new StringBuilder();
        sb14.append(APP_PRIVATE_ROOT_PATH);
        sb14.append("analysis/");
        APP_ANALYSIS_PATH = sb14.toString();
        StringBuilder sb15 = new StringBuilder();
        sb15.append(APP_PRIVATE_ROOT_PATH);
        sb15.append("download/");
        APP_DOWNLOAD_PATH = sb15.toString();
        StringBuilder sb16 = new StringBuilder();
        sb16.append(APP_PRIVATE_ROOT_PATH);
        sb16.append("log/");
        APP_LOG_PATH = sb16.toString();
        StringBuilder sb17 = new StringBuilder();
        sb17.append(APP_PRIVATE_ROOT_PATH);
        sb17.append("help/");
        APP_HELP_PATH = sb17.toString();
        StringBuilder sb18 = new StringBuilder();
        sb18.append(APP_PRIVATE_ROOT_PATH);
        sb18.append(".templates2/");
        APP_PATH_INTERNAL_TEMPLATES = sb18.toString();
        StringBuilder sb19 = new StringBuilder();
        sb19.append(APP_PATH_INTERNAL_TEMPLATES);
        sb19.append("watermark/water_mark.jpg");
        APP_WATER_MARK_PATH = sb19.toString();
        StringBuilder sb20 = new StringBuilder();
        sb20.append(APP_PATH_INTERNAL_TEMPLATES);
        sb20.append("watermark/water_mark.jpg");
        APP_DEFAULT_WATER_MARK_PATH = sb20.toString();
        StringBuilder sb21 = new StringBuilder();
        sb21.append(APP_PATH_INTERNAL_TEMPLATES);
        sb21.append("transition/");
        APP_TRANSITION_PATH = sb21.toString();
        StringBuilder sb22 = new StringBuilder();
        sb22.append(APP_PATH_INTERNAL_TEMPLATES);
        sb22.append("transition/");
        APP_TRANSITION_PATH_DEFAULT = sb22.toString();
        StringBuilder sb23 = new StringBuilder();
        sb23.append(APP_PATH_INTERNAL_TEMPLATES);
        sb23.append("imageeffect/");
        APP_EFFECT_PATH = sb23.toString();
        StringBuilder sb24 = new StringBuilder();
        sb24.append(APP_PATH_INTERNAL_TEMPLATES);
        sb24.append("imageeffect/");
        APP_EFFECT_PATH_DEFAULT = sb24.toString();
        StringBuilder sb25 = new StringBuilder();
        sb25.append(APP_PATH_INTERNAL_TEMPLATES);
        sb25.append("text/");
        APP_TEXT_PATH = sb25.toString();
        StringBuilder sb26 = new StringBuilder();
        sb26.append(APP_PATH_INTERNAL_TEMPLATES);
        sb26.append("theme/");
        APP_THEME_PATH = sb26.toString();
        StringBuilder sb27 = new StringBuilder();
        sb27.append(APP_PATH_INTERNAL_TEMPLATES);
        sb27.append("theme/pkg/0/");
        APP_THEME_PATH_DEFAULT = sb27.toString();
        StringBuilder sb28 = new StringBuilder();
        sb28.append(APP_PATH_INTERNAL_TEMPLATES);
        sb28.append("textframe/");
        APP_TEXT_FRAME_PATH = sb28.toString();
        StringBuilder sb29 = new StringBuilder();
        sb29.append(APP_PATH_INTERNAL_TEMPLATES);
        sb29.append("textframe/");
        APP_TEXT_FRAME_PATH_DEFAULT = sb29.toString();
        StringBuilder sb30 = new StringBuilder();
        sb30.append(APP_PATH_INTERNAL_TEMPLATES);
        sb30.append("bubbleframe/");
        APP_BUBBLE_FRAME_PATH = sb30.toString();
        StringBuilder sb31 = new StringBuilder();
        sb31.append(APP_PATH_INTERNAL_TEMPLATES);
        sb31.append("bubbleframe/");
        APP_BUBBLE_FRAME_PATH_DEFAULT = sb31.toString();
        StringBuilder sb32 = new StringBuilder();
        sb32.append(APP_PATH_INTERNAL_TEMPLATES);
        sb32.append("poster/");
        APP_POSTER_PATH = sb32.toString();
        StringBuilder sb33 = new StringBuilder();
        sb33.append(APP_PATH_INTERNAL_TEMPLATES);
        sb33.append("poster/");
        APP_POSTER_PATH_DEFAULT = sb33.toString();
        StringBuilder sb34 = new StringBuilder();
        sb34.append(APP_PATH_INTERNAL_TEMPLATES);
        sb34.append("autocut/");
        APP_AUTOCUT_PATH = sb34.toString();
        StringBuilder sb35 = new StringBuilder();
        sb35.append(APP_PATH_INTERNAL_TEMPLATES);
        sb35.append("covertempfiles/");
        APP_COVER_TEMP_PATH = sb35.toString();
        StringBuilder sb36 = new StringBuilder();
        sb36.append(APP_PATH_INTERNAL_TEMPLATES);
        sb36.append("defaultmusic/");
        APP_DEFAULTMUSIC_PATH = sb36.toString();
        StringBuilder sb37 = new StringBuilder();
        sb37.append(APP_PATH_INTERNAL_TEMPLATES);
        sb37.append("cover/");
        APP_COVER_PATH = sb37.toString();
        StringBuilder sb38 = new StringBuilder();
        sb38.append(APP_PATH_INTERNAL_TEMPLATES);
        sb38.append("animateframe/");
        APP_ANIMATEFRAME_PATH = sb38.toString();
        StringBuilder sb39 = new StringBuilder();
        sb39.append(APP_PATH_INTERNAL_TEMPLATES);
        sb39.append("diva/");
        APP_DIVA_PATH = sb39.toString();
    }

    public static String getAppCacheDir() {
        return APP_CACHE_PATH;
    }

    public static String getAudioSavePath() {
        return ccf;
    }

    public static String getCameraVideoPath() {
        StringBuilder sb = new StringBuilder();
        sb.append(getMediaStoragePath());
        sb.append(File.separator);
        sb.append(CAMERA_VIDEO_RELATIVE_PATH);
        return sb.toString();
    }

    public static String getMediaSavePath() {
        return cce;
    }

    public static String getMediaStoragePath() {
        return ccg != null ? ccg : StorageInfo.getMainStorage();
    }

    public static String getMediaStoragePath(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(getMediaStorageRelativePath());
        return sb.toString();
    }

    public static String getMediaStorageRelativePath() {
        StringBuilder sb = new StringBuilder();
        sb.append(APP_DEFAULT_EXPORT_SUB_PATH);
        sb.append(".media/");
        return sb.toString();
    }

    public static String getProjectSavePath() {
        return APP_PROJECT_PATH;
    }

    public static String getStoragePath() {
        return PATH_SDCARD;
    }

    public static void init(String str, String str2) {
        APP_PACKAGE_FULLNAME = str;
        APP_PACKAGE_NAME = str2;
        if (TextUtils.isEmpty(APP_PACKAGE_NAME)) {
            APP_PACKAGE_NAME = APP_PACKAGE_FULLNAME;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str2);
        sb.append("/");
        APP_DATA_PATH_RELATIVE = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("/");
        sb2.append(Environment.DIRECTORY_DCIM);
        sb2.append("/");
        sb2.append(str2);
        sb2.append("/");
        APP_DEFAULT_EXPORT_SUB_PATH = sb2.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append("/data/data/");
        sb3.append(APP_PACKAGE_FULLNAME);
        APP_PATH_INTERNAL_ROOT = sb3.toString();
        StringBuilder sb4 = new StringBuilder();
        sb4.append(APP_PATH_INTERNAL_ROOT);
        sb4.append("/FakeSD");
        APP_PATH_INTERNAL_FAKESDCARD = sb4.toString();
        StringBuilder sb5 = new StringBuilder();
        sb5.append(APP_PATH_INTERNAL_ROOT);
        sb5.append("/database/");
        APP_DB_PATH_INTERNAL = sb5.toString();
        StringBuilder sb6 = new StringBuilder();
        sb6.append(APP_PATH_INTERNAL_ROOT);
        sb6.append("/lib/");
        APP_LIBRARY_PATH = sb6.toString();
        StringBuilder sb7 = new StringBuilder();
        sb7.append(APP_PATH_INTERNAL_ROOT);
        sb7.append("/so/");
        APP_HW_LIBRARY_PATH = sb7.toString();
        StringBuilder sb8 = new StringBuilder();
        sb8.append(APP_PATH_INTERNAL_ROOT);
        sb8.append("/");
        sb8.append("serverurl.ini");
        APP_SOCIAL_SERVER_URL_CFG_FULLNAME = sb8.toString();
    }

    public static void setAppCacheDir(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (!str.endsWith(File.separator)) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(File.separator);
                APP_CACHE_PATH = sb.toString();
            } else {
                APP_CACHE_PATH = str;
            }
        }
    }

    public static boolean setExportStoragePath(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(new File(str).getAbsolutePath());
        sb.append(APP_DEFAULT_EXPORT_SUB_PATH);
        APP_DEFAULT_EXPORT_PATH = sb.toString();
        return true;
    }

    public static void setExportSubPath(String str) {
        APP_DEFAULT_EXPORT_SUB_PATH = str;
    }

    public static boolean setMainStoragePath(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            File file = new File(str);
            if (!file.isDirectory() || !file.canWrite()) {
                return false;
            }
            PATH_SDCARD = file.getAbsolutePath();
            StringBuilder sb = new StringBuilder();
            sb.append(PATH_SDCARD);
            sb.append("/");
            ROOT_PATH = sb.toString();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(ROOT_PATH);
            sb2.append(APP_PACKAGE_NAME);
            sb2.append("/");
            APP_DATA_PATH = sb2.toString();
            StringBuilder sb3 = new StringBuilder();
            sb3.append(APP_DATA_PATH);
            sb3.append(".private/");
            APP_PRIVATE_ROOT_PATH = sb3.toString();
            StringBuilder sb4 = new StringBuilder();
            sb4.append(APP_DATA_PATH);
            sb4.append("fonts/");
            APP_PRIVATE_FONT_PATH = sb4.toString();
            StringBuilder sb5 = new StringBuilder();
            sb5.append(APP_DATA_PATH);
            sb5.append(".public/");
            APP_PUBLIC_ROOT_PATH = sb5.toString();
            StringBuilder sb6 = new StringBuilder();
            sb6.append(APP_PUBLIC_ROOT_PATH);
            sb6.append(".projects/");
            APP_PROJECT_PATH = sb6.toString();
            if (APP_DEFAULT_EXPORT_PATH == null) {
                setExportStoragePath(str);
            }
            if (ccg == null) {
                setMediaStoragePath(str);
            }
            StringBuilder sb7 = new StringBuilder();
            sb7.append(APP_CACHE_PATH);
            sb7.append(".analysis/");
            APP_ANALYSIS_PATH = sb7.toString();
            StringBuilder sb8 = new StringBuilder();
            sb8.append(APP_CACHE_PATH);
            sb8.append(".download/");
            APP_DOWNLOAD_PATH = sb8.toString();
            StringBuilder sb9 = new StringBuilder();
            sb9.append(APP_CACHE_PATH);
            sb9.append(".SocialCache/");
            APP_DEFAULT_SOCIALCACHE_PATH = sb9.toString();
            StringBuilder sb10 = new StringBuilder();
            sb10.append(APP_CACHE_PATH);
            sb10.append("tmp/");
            APP_DATA_PATH_INNER = sb10.toString();
            StringBuilder sb11 = new StringBuilder();
            sb11.append(APP_CACHE_PATH);
            sb11.append("log/");
            APP_LOG_PATH = sb11.toString();
            StringBuilder sb12 = new StringBuilder();
            sb12.append(APP_CACHE_PATH);
            sb12.append("help/");
            APP_HELP_PATH = sb12.toString();
            StringBuilder sb13 = new StringBuilder();
            sb13.append(APP_PRIVATE_ROOT_PATH);
            sb13.append(".templates2/");
            APP_PATH_INTERNAL_TEMPLATES = sb13.toString();
            StringBuilder sb14 = new StringBuilder();
            sb14.append(APP_PATH_INTERNAL_TEMPLATES);
            sb14.append("watermark/water_mark.jpg");
            APP_WATER_MARK_PATH = sb14.toString();
            StringBuilder sb15 = new StringBuilder();
            sb15.append(APP_PATH_INTERNAL_TEMPLATES);
            sb15.append("watermark/water_mark.jpg");
            APP_DEFAULT_WATER_MARK_PATH = sb15.toString();
            StringBuilder sb16 = new StringBuilder();
            sb16.append(APP_PATH_INTERNAL_TEMPLATES);
            sb16.append("transition/");
            APP_TRANSITION_PATH = sb16.toString();
            StringBuilder sb17 = new StringBuilder();
            sb17.append(APP_PATH_INTERNAL_TEMPLATES);
            sb17.append("transition/");
            APP_TRANSITION_PATH_DEFAULT = sb17.toString();
            StringBuilder sb18 = new StringBuilder();
            sb18.append(APP_PATH_INTERNAL_TEMPLATES);
            sb18.append("imageeffect/");
            APP_EFFECT_PATH = sb18.toString();
            StringBuilder sb19 = new StringBuilder();
            sb19.append(APP_PATH_INTERNAL_TEMPLATES);
            sb19.append("imageeffect/");
            APP_EFFECT_PATH_DEFAULT = sb19.toString();
            StringBuilder sb20 = new StringBuilder();
            sb20.append(APP_PATH_INTERNAL_TEMPLATES);
            sb20.append("text/");
            APP_TEXT_PATH = sb20.toString();
            StringBuilder sb21 = new StringBuilder();
            sb21.append(APP_PATH_INTERNAL_TEMPLATES);
            sb21.append("theme/");
            APP_THEME_PATH = sb21.toString();
            StringBuilder sb22 = new StringBuilder();
            sb22.append(APP_PATH_INTERNAL_TEMPLATES);
            sb22.append("theme/pkg/0/");
            APP_THEME_PATH_DEFAULT = sb22.toString();
            StringBuilder sb23 = new StringBuilder();
            sb23.append(APP_PATH_INTERNAL_TEMPLATES);
            sb23.append("textframe/");
            APP_TEXT_FRAME_PATH = sb23.toString();
            StringBuilder sb24 = new StringBuilder();
            sb24.append(APP_PATH_INTERNAL_TEMPLATES);
            sb24.append("textframe/");
            APP_TEXT_FRAME_PATH_DEFAULT = sb24.toString();
            StringBuilder sb25 = new StringBuilder();
            sb25.append(APP_PATH_INTERNAL_TEMPLATES);
            sb25.append("bubbleframe/");
            APP_BUBBLE_FRAME_PATH = sb25.toString();
            StringBuilder sb26 = new StringBuilder();
            sb26.append(APP_PATH_INTERNAL_TEMPLATES);
            sb26.append("bubbleframe/");
            APP_BUBBLE_FRAME_PATH_DEFAULT = sb26.toString();
            StringBuilder sb27 = new StringBuilder();
            sb27.append(APP_PATH_INTERNAL_TEMPLATES);
            sb27.append("poster/");
            APP_POSTER_PATH = sb27.toString();
            StringBuilder sb28 = new StringBuilder();
            sb28.append(APP_PATH_INTERNAL_TEMPLATES);
            sb28.append("poster/");
            APP_POSTER_PATH_DEFAULT = sb28.toString();
            StringBuilder sb29 = new StringBuilder();
            sb29.append(APP_PATH_INTERNAL_TEMPLATES);
            sb29.append("autocut/");
            APP_AUTOCUT_PATH = sb29.toString();
            StringBuilder sb30 = new StringBuilder();
            sb30.append(APP_PATH_INTERNAL_TEMPLATES);
            sb30.append("covertempfiles/");
            APP_COVER_TEMP_PATH = sb30.toString();
            StringBuilder sb31 = new StringBuilder();
            sb31.append(APP_PATH_INTERNAL_TEMPLATES);
            sb31.append("defaultmusic/");
            APP_DEFAULTMUSIC_PATH = sb31.toString();
            StringBuilder sb32 = new StringBuilder();
            sb32.append(APP_PATH_INTERNAL_TEMPLATES);
            sb32.append("cover/");
            APP_COVER_PATH = sb32.toString();
            StringBuilder sb33 = new StringBuilder();
            sb33.append(APP_PATH_INTERNAL_TEMPLATES);
            sb33.append("animateframe/");
            APP_ANIMATEFRAME_PATH = sb33.toString();
            StringBuilder sb34 = new StringBuilder();
            sb34.append(APP_PATH_INTERNAL_TEMPLATES);
            sb34.append("diva/");
            APP_DIVA_PATH = sb34.toString();
            StringBuilder sb35 = new StringBuilder();
            sb35.append(APP_CACHE_PATH);
            sb35.append("download/");
            sb35.append(".templates2/");
            APP_DOWNLOAD_TEMPLATES_PATH = sb35.toString();
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean setMediaStoragePath(String str) {
        setMediaStoragePath(str, false);
        return true;
    }

    public static boolean setMediaStoragePath(String str, boolean z) {
        ccg = str;
        String absolutePath = new File(str).getAbsolutePath();
        StringBuilder sb = new StringBuilder();
        sb.append(absolutePath);
        sb.append(APP_DEFAULT_EXPORT_SUB_PATH);
        sb.append(".media/");
        cce = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(absolutePath);
        sb2.append(APP_DEFAULT_EXPORT_SUB_PATH);
        sb2.append(".sound/");
        ccf = sb2.toString();
        return true;
    }
}
