package com.introvd.template.sdk.p391g;

/* renamed from: com.introvd.template.sdk.g.b */
public enum C8451b {
    THEME(0),
    FUNNY_THEME(1),
    STORY_THEME(2),
    FAST_EDITOR(3);
    
    public int code;

    private C8451b(int i) {
        this.code = i;
    }

    /* renamed from: un */
    public static boolean m24477un(int i) {
        return i == FUNNY_THEME.code || i == STORY_THEME.code;
    }

    /* renamed from: uo */
    public static boolean m24478uo(int i) {
        return i == THEME.code || i == FAST_EDITOR.code;
    }

    /* renamed from: up */
    public static boolean m24479up(int i) {
        return i == THEME.code;
    }

    /* renamed from: uq */
    public static boolean m24480uq(int i) {
        return i == FUNNY_THEME.code;
    }

    /* renamed from: ur */
    public static boolean m24481ur(int i) {
        return i == STORY_THEME.code;
    }

    /* renamed from: us */
    public static boolean m24482us(int i) {
        return i == FAST_EDITOR.code;
    }
}
