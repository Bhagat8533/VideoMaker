package com.introvd.template.editor.preview;

import android.content.Context;
import android.os.Looper;
import com.introvd.template.VivaBaseApplication;
import com.introvd.template.common.ToastUtils;
import com.introvd.template.editor.R;

/* renamed from: com.introvd.template.editor.preview.b */
public class C6549b {
    /* renamed from: V */
    public static int m18995V(int i, boolean z) {
        switch (i) {
            case 0:
                return z ? R.drawable.editor_icon_theme_tab_slc : R.drawable.editor_icon_theme_tab_normal;
            case 1:
                return z ? R.drawable.editor_icon_clipedit_tab_slc : R.drawable.editor_icon_clipedit_tab_normal;
            case 2:
                return z ? R.drawable.editor_icon_effect_tab_slc : R.drawable.editor_icon_effect_tab_normal;
            case 3:
                return z ? R.drawable.editor_icon_bgm_tab_slc : R.drawable.editor_icon_bgm_tab_normal;
            default:
                return 0;
        }
    }

    /* renamed from: Y */
    public static String m18996Y(Context context, int i) {
        String str = "";
        switch (i) {
            case 0:
                return context.getResources().getString(R.string.xiaoying_str_ve_theme_title_common);
            case 1:
                return context.getResources().getString(R.string.xiaoying_str_ve_advance_tool_basic_clip_edit_title);
            case 2:
                return context.getResources().getString(R.string.xiaoying_str_editor_tab_effects);
            case 3:
                return context.getResources().getString(R.string.xiaoying_str_editor_tab_bgm);
            default:
                return str;
        }
    }

    /* renamed from: Z */
    public static void m18997Z(Context context, int i) {
        String str = "";
        if (i == 1007) {
            str = context.getString(R.string.xiaoying_str_ve_msg_basic_mute_img_tip);
        } else if (i == 1017) {
            str = context.getString(R.string.xiaoying_str_ve_msg_basic_animation_video_tip);
        } else if (i != 1019) {
            switch (i) {
                case 1004:
                    str = context.getString(R.string.xiaoying_str_ve_msg_basic_image_cannot_split_tip);
                    break;
                case 1005:
                    str = context.getString(R.string.xiaoying_str_ve_basic_speed_img_not_support_tip);
                    break;
                default:
                    switch (i) {
                        case 1010:
                            str = context.getString(R.string.xiaoying_str_ve_msg_basic_image_cannot_reverse_tip);
                            break;
                        case 1011:
                            str = context.getString(R.string.xiaoying_str_ve_last_clip_cannot_apply_transition_tip);
                            break;
                        case 1012:
                            str = context.getString(R.string.xiaoying_edit_single_clip_not_support_multiple);
                            break;
                    }
            }
        } else {
            str = context.getString(R.string.xiaoying_str_editor_voice_not_support_photo);
        }
        if (Looper.myLooper() != null) {
            ToastUtils.show((Context) VivaBaseApplication.m8749FZ(), str, 0);
        }
    }
}
