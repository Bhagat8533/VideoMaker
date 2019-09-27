package com.introvd.template.module.iap.business.p349a;

import com.introvd.template.datacenter.SocialConstDef;

/* renamed from: com.introvd.template.module.iap.business.a.a */
public enum C7825a {
    WATER_MARK("remove_watermark"),
    DURATION_LIMIT(SocialConstDef.PROJECT_DURATION_LIMIT),
    AD("remove_ad"),
    HD("unlock_hd"),
    HD_2k("unlock_hd_2k"),
    HD_4k("unlock_hd_4k"),
    VIDEO_PARAM_ADJUST("video_adjust"),
    ANIM_TITLE("animated_text"),
    MOSAIC("mosaic"),
    USER_WATER_MARK("user_watermark"),
    MAGIC_SOUND("magic_sound"),
    ALL("unlock_all"),
    PREMIUM_PACK("premium_pack"),
    ALL_TEMPLATE("all_template"),
    CUSTOMIZED_BACKGROUND("custom_bg"),
    KEY_FRAME("key_frame"),
    AUDIO_EXTRA("audio_extraction"),
    PLATINUM_PREMIUM_PACK("package_with_full_features"),
    GOLD_MONTHLY("gold_monthly"),
    GOLD_YEARLY("gold_yearly"),
    PLATINUM_WEEKLY("platinum_weekly"),
    PLATINUM_MONTHLY("platinum_monthly"),
    PLATINUM_YEARLY("platinum_yearly");
    
    private final String goodsId;

    private C7825a(String str) {
        this.goodsId = str;
    }

    public String getId() {
        return this.goodsId;
    }
}
