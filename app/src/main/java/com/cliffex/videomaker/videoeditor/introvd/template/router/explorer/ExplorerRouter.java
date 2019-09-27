package com.introvd.template.router.explorer;

import android.app.Activity;
import aoptest.chandler.com.vivarouter.R;
import com.introvd.template.router.BaseRouter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class ExplorerRouter extends BaseRouter {
    public static final String INTENT_KEY_MUSIC_DIRECT_EXTRACT_FILE_PATH = "intent_key_music_direct_extract_file_path";
    public static final String INTENT_KEY_VIDEO_FILE_PATH = "intent_key_video_file_path";
    public static final String PROXY_APPLICATION = "/ExplorerSelf/AppLifeCycle";
    public static final int REQUEST_CODE_EXGTRACT_MUSIC = 4153;
    public static final String URL_MUSIC_DIRECT_EXTRACT = "/Explorer/MusicDirectExtract";
    public static final String URL_VIDEO_EXTRACT = "/Explorer/VideoExtract";

    public class ExtractMusicNextActionParams {
        public static final int ACTION_DEF = 0;
        public static final int ACTION_TO_NEW_MUSIC_EXTRACT_PAGE = 1;
        public static final String KEY_NEXT_ACTION = "key_next_action";

        public ExtractMusicNextActionParams() {
        }
    }

    public class FileExplorerParams {
        public static final int FILE_TYPE_MUSIC = 1;
        public static final String KEY_EXPLORER_FILE_TYPE = "key_explorer_file_type";
        public static final String URL = "/Explorer/FileExplorer";

        public FileExplorerParams() {
        }
    }

    public class MusicParams {
        public static final String EXTRA_CATEGORY_ID = "extra_category_id";
        public static final String EXTRA_INT_TYPE = "extra_int_type";
        public static final int EXTRA_INT_TYPE_MUSIC = 1;
        public static final int EXTRA_INT_TYPE_MUSIC_EFFECT = 2;
        public static final String URL = "/Explorer/Music";
        public static final String URL_EFFECT = "/Explorer/MusicEffect";

        public MusicParams() {
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface MusicType {
    }

    public static void launchMusicDirectExtractActivity(Activity activity, String str, int i) {
        getRouterBuilder(activity.getApplication(), URL_MUSIC_DIRECT_EXTRACT).mo10399f(INTENT_KEY_MUSIC_DIRECT_EXTRACT_FILE_PATH, str).mo10394aZ(R.anim.anim_activity_enter, R.anim.anim_activity_exit).mo10396b(activity, i);
    }

    public static void launchVideoExtractActivity(Activity activity, String str, int i) {
        launchVideoExtractActivity(activity, str, i, 0);
    }

    public static void launchVideoExtractActivity(Activity activity, String str, int i, int i2) {
        getRouterBuilder(activity.getApplication(), URL_VIDEO_EXTRACT).mo10399f(INTENT_KEY_VIDEO_FILE_PATH, str).mo10394aZ(R.anim.anim_activity_enter, R.anim.anim_activity_exit).mo10406h(ExtractMusicNextActionParams.KEY_NEXT_ACTION, i2).mo10396b(activity, i);
    }
}
