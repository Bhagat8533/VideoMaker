package com.introvd.template.editor.p261g;

import android.content.Context;
import com.facebook.ads.AdError;
import com.giii.aiii.biii.auth.api.proxy.AuthApiStatusCodes;
import com.introvd.template.editor.R;
import com.introvd.template.router.editor.EditorModes;

/* renamed from: com.introvd.template.editor.g.c */
public enum C6312c {
    UNKNOWN(-1, 0),
    ORIGIN(0, 0),
    THEME_APPLY(1001, R.string.xiaoying_str_editor_theme_apply),
    THEME_TITLE(1002, R.string.xiaoying_str_editor_theme_title),
    BGM_APPLY(1003, R.string.xiaoying_str_ve_bgm_add),
    BGM_MODIFY(1004, R.string.xiaoying_str_ve_bgm_change),
    CLIP_FILTER(2001, R.string.xiaoying_str_ve_effect_title),
    CLIP_RATIO(2002, R.string.xiaoying_str_ve_edit_ratio_title),
    CLIP_TRIM(2003, R.string.xiaoying_str_ve_basic_trim_title),
    CLIP_PIC_TRIM(2004, R.string.xiaoying_str_ve_img_duration_title),
    CLIP_SPLIT(2005, R.string.xiaoying_str_ve_split_clip_title),
    CLIP_SPEED(2006, R.string.xiaoying_str_ve_basic_speed_tool_title),
    CLIP_ADJUST(EditorModes.EFFECT_MOSAIC_MODE, R.string.xiaoying_str_ve_video_param_adjust),
    CLIP_REVERSE(2008, R.string.xiaoying_str_ve_basic_more_menu_reverse_title),
    CLIP_MUTE(AdError.INTERSTITIAL_AD_TIMEOUT, R.string.xiaoying_str_ve_basic_mute_title),
    CLIP_TRANSITION(2010, R.string.xiaoying_str_ve_transition_title),
    CLIP_PIC_ANIM(2011, R.string.xiaoying_str_ve_edit_pic_anim_title),
    CLIP_MULTI_DELETE(2012, R.string.xiaoying_str_com_delete_title),
    CLIP_ADD(2013, R.string.xiaoying_str_ve_str_add_clip_title),
    CLIP_DELETE(2014, R.string.xiaoying_str_ve_clip_delete_title),
    CLIP_DUPLICATE(2015, R.string.xiaoying_str_ve_basic_duplicate_title),
    CLIP_ROTATE(2016, R.string.xiaoying_str_ve_basic_rotate_title),
    CLIP_EXCHANGE(2017, R.string.xiaoying_str_editor_clip_exchange_title),
    CLIP_ORDER(2018, R.string.xiaoying_str_clip_order_title),
    CLIP_MAGIC_SOUND(2019, R.string.xiaoying_str_clip_func_magic_sound),
    EFFECT_MUSIC(3001, R.string.xiaoying_str_ve_multi_bgm_title),
    EFFECT_SUBTITLE(3002, R.string.xiaoying_str_ve_subtitle_title),
    EFFECT_STICKER(3003, R.string.xiaoying_str_editor_sticker_title),
    EFFECT_FX(AuthApiStatusCodes.AUTH_TOKEN_ERROR, R.string.xiaoying_str_ve_animate_frame_title),
    EFFECT_DUBBING(3005, R.string.xiaoying_str_ve_dub_title),
    EFFECT_PIP(AuthApiStatusCodes.AUTH_APP_CERT_ERROR, R.string.xiaoying_str_com_home_edit_pip),
    EFFECT_MOSAIC(3007, R.string.xiaoying_str_ve_mosaic_title);
    
    private final int cVM;
    private final int key;

    private C6312c(int i, int i2) {
        this.key = i;
        this.cVM = i2;
    }

    /* renamed from: fg */
    public String mo29286fg(Context context) {
        if (getNameResId() > 0) {
            return context.getString(this.cVM);
        }
        return null;
    }

    public int getNameResId() {
        return this.cVM;
    }
}
