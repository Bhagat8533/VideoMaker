package com.introvd.template.module.iap;

/* renamed from: com.introvd.template.module.iap.i */
public enum C8059i {
    VIP_UNKNOWN(-1),
    VIP_ALL(0),
    VIP_THEME(1),
    VIP_FILTER(2),
    VIP_STICKER(3),
    VIP_MAGIC_SOUND(4),
    VIP_BACKGROUND(5),
    VIP_ANIM_SUBTITLE(6),
    VIP_NORMAL_SUBTITLE(7),
    VIP_MOSAIC(8),
    VIP_MUSIC_EXTRACT(9),
    VIP_DURATION_LIMIT(10),
    VIP_KEY_FRAME(11),
    VIP_VIDEO_PARAM(12),
    VIP_CUSTOMIZE_WM(13);
    
    public int code;

    private C8059i(int i) {
        this.code = i;
    }

    /* renamed from: sg */
    public static C8059i m23406sg(int i) {
        switch (i) {
            case 0:
                return VIP_ALL;
            case 1:
                return VIP_THEME;
            case 2:
                return VIP_FILTER;
            case 3:
                return VIP_STICKER;
            case 4:
                return VIP_MAGIC_SOUND;
            case 5:
                return VIP_BACKGROUND;
            case 6:
                return VIP_ANIM_SUBTITLE;
            case 7:
                return VIP_NORMAL_SUBTITLE;
            case 8:
                return VIP_MOSAIC;
            case 9:
                return VIP_MUSIC_EXTRACT;
            case 10:
                return VIP_DURATION_LIMIT;
            case 11:
                return VIP_KEY_FRAME;
            case 12:
                return VIP_VIDEO_PARAM;
            case 13:
                return VIP_CUSTOMIZE_WM;
            default:
                return VIP_UNKNOWN;
        }
    }
}
