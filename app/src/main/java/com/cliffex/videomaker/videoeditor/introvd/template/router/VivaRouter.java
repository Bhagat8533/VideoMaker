package com.introvd.template.router;

import com.aiii.android.arouter.facade.C1941a;
import com.aiii.android.arouter.p091c.C1919a;
import com.introvd.template.VivaBaseApplication;

public class VivaRouter {

    public class FreezeReasonPageParam {
        public static final String INTENT_KEY_AUID = "intent_key_auid";
        public static final String URL = "/app/freezereasonpage";

        public FreezeReasonPageParam() {
        }
    }

    public class RepostVideoPageParams {
        public static final String URL = "/app/repostvideo";

        public RepostVideoPageParams() {
        }
    }

    public class VideoEditorParams {
        public static final String ADVANCE_PRJ_BACKUP_FILE_EXT = ".advancebackup";
        public static final String BUNDLE_DATA_PLAYER_INIT_TIME_KEY = "key_player_init_time";
        public static final int FROM_MODE_CAMERA = 2;
        public static final int FROM_MODE_GALLERY_MV = 0;
        public static final int FROM_MODE_GALLERY_VIDEO = 1;
        public static final int FROM_MODE_PIP_EDIT = 3;
        public static final int FROM_MODE_STUDIO = 4;
        public static final int FROM_MODE_UNKNOW = -1;
        public static final String INTENT_KEY_FROM_MODE = "intent_key_from_mode";
        public static final String KEY_PREFER_ENCOURAGE_AD_SWITCH = "key_prefer_encourage_ad_switch";
        public static final String SIMPLEEDIT_PRJ_BACKUP_FILE_EXT = ".simplebackup";
        public static final String SOURCE_TO_SIMPLE_EDIT = "source_to_simple_edit";
        public static final String URL = "/VideoEditor/entry";

        public VideoEditorParams() {
        }
    }

    public static C1941a getRouterBuilder(String str) {
        C1919a.m5528a(VivaBaseApplication.m8749FZ());
        return C1919a.m5529sc().mo10355al(str);
    }

    public static void inject(Object obj) {
        C1919a.m5528a(VivaBaseApplication.m8749FZ());
        C1919a.m5529sc().inject(obj);
    }
}
