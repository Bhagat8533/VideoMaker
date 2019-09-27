package com.introvd.template.router.editor;

import com.aiii.sdk.android.oss.common.RequestParameters;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class EditorModes {
    public static final int CLIP_ADJUST_MODE = 1002;
    public static final int CLIP_DELETE_MODE = 1008;
    public static final int CLIP_DUPLICATE_MODE = 1009;
    public static final int CLIP_FILTER_MODE = 1001;
    public static final int CLIP_MAGIC_SOUND_MODE = 1019;
    public static final int CLIP_MULTISELECT_MODE = 1012;
    public static final int CLIP_MUTE_MODE = 1007;
    public static final int CLIP_ORDER_MODE = 1018;
    public static final int CLIP_PIC_ANIM_MODE = 1017;
    public static final int CLIP_PIC_TRIM_MODE = 1014;
    public static final int CLIP_PLAY_ORDER_MODE = 1015;
    public static final int CLIP_RATIO_MODE = 1006;
    public static final int CLIP_REVERSER_MODE = 1010;
    public static final int CLIP_ROTATE_MODE = 1013;
    public static final int CLIP_SPEED_MODE = 1005;
    public static final int CLIP_SPLIT_MODE = 1004;
    private static final int CLIP_START = 1000;
    public static final int CLIP_TRANSITION_MODE = 1011;
    public static final int CLIP_VIDEO_AND_PIC_TRIM_MODE = 1016;
    public static final int CLIP_VIDEO_TRIM_MODE = 1003;
    public static final int CUSTOM_ADD = 4;
    public static final int EFFECT_COLLAGE_MODE = 2001;
    public static final int EFFECT_CUSTOM_WATERMARK = 2008;
    public static final int EFFECT_DUBBING_MODE = 2006;
    public static final int EFFECT_FX_MODE = 2004;
    public static final int EFFECT_MOSAIC_MODE = 2007;
    public static final int EFFECT_MUSIC_MODE = 2005;
    private static final int EFFECT_START = 2000;
    public static final int EFFECT_STICKER_MODE = 2003;
    public static final int EFFECT_SUBTITLE_MODE = 2002;
    private static final int END = 4000;
    public static final int FAST_PREVIEW = 2;
    public static final int NORMAL_GIF_MAKER = 1;
    public static final int NORMAL_PREVIEW = 0;
    public static final int SORT_MODE = 3;
    public static final int TAB_BGM = 3;
    public static final int TAB_CLIP = 1;
    public static final int TAB_EFFECT = 2;
    public static final int TAB_THEME = 0;
    public static final int TAB_UNKNOWN = -1;
    public static final int THEME_BGM_MUSIC = 3002;
    public static final int THEME_PIC_TIME = 3003;
    private static final int THEME_START = 3000;
    public static final int THEME_TITLE_TEXT = 3001;
    public static final int UNKNOWN = -1;

    @Target({ElementType.FIELD, ElementType.PARAMETER})
    @Retention(RetentionPolicy.SOURCE)
    public @interface BaseMode {
    }

    @Target({ElementType.FIELD, ElementType.PARAMETER})
    @Retention(RetentionPolicy.SOURCE)
    public @interface EditorMode {
    }

    @Target({ElementType.FIELD, ElementType.PARAMETER})
    @Retention(RetentionPolicy.SOURCE)
    public @interface TabMode {
    }

    public static String getEditorModeName(int i) {
        String str = "";
        switch (i) {
            case -1:
            case 0:
            case 1:
                return str;
            default:
                switch (i) {
                    case 3:
                        return "sort";
                    case 4:
                        return str;
                    default:
                        switch (i) {
                            case 1001:
                                return "filter";
                            case 1002:
                                return "adjust";
                            case 1003:
                            case 1014:
                                return "trim";
                            case 1004:
                                return "split";
                            case 1005:
                                return "speed";
                            case 1006:
                                return "ratio";
                            case 1007:
                                return "mute";
                            case 1008:
                                return RequestParameters.SUBRESOURCE_DELETE;
                            case 1009:
                                return "duplicate";
                            case 1010:
                                return "reverse";
                            case 1011:
                                return "transition";
                            case 1012:
                                return "select";
                            case 1013:
                                return "rotate";
                            case 1015:
                                return str;
                            default:
                                switch (i) {
                                    case 1017:
                                        return "pic_animation";
                                    case 1018:
                                        return "clip_order";
                                    case 1019:
                                        return "magic_sound";
                                    default:
                                        switch (i) {
                                            case 2001:
                                                return EditorRouter.ENTRANCE_PIP;
                                            case 2002:
                                                return "title";
                                            case 2003:
                                                return "sticker";
                                            case 2004:
                                                return "fx";
                                            case 2005:
                                                return "music";
                                            case 2006:
                                                return "sound";
                                            case EFFECT_MOSAIC_MODE /*2007*/:
                                                return "mosaic";
                                            default:
                                                switch (i) {
                                                }
                                                return str;
                                        }
                                }
                        }
                }
        }
    }

    public static String getEditorTabName(int i) {
        String str = "";
        switch (i) {
            case 0:
                return "theme";
            case 1:
                return "clip edit";
            case 2:
                return "effect";
            default:
                return str;
        }
    }

    public static boolean isBaseEditMode(int i) {
        return i == 0 || i == 1 || i == 2;
    }

    public static boolean isClipEditMode(int i) {
        return i > 1000 && i < 2000;
    }

    public static boolean isEffectMode(int i) {
        return i > 2000 && i < 3000;
    }

    public static boolean isThemeMode(int i) {
        return i > 3000 && i < END;
    }
}
