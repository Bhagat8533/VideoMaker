package com.introvd.template.gallery;

/* renamed from: com.introvd.template.gallery.c */
public enum C7444c {
    GALLERY_TAB_UNKNOW(-1),
    GALLERY_TAB_SYSTEM(0),
    GALLERY_TAB_OTHERS(1),
    GALLERY_TAB_FACEBOOK(2),
    GALLERY_TAB_INSTAGRAM(3);
    
    private int typeCode;

    private C7444c(int i) {
        this.typeCode = i;
    }

    /* renamed from: re */
    public static C7444c m21989re(int i) {
        switch (i) {
            case 0:
                return GALLERY_TAB_SYSTEM;
            case 1:
                return GALLERY_TAB_OTHERS;
            case 2:
                return GALLERY_TAB_FACEBOOK;
            case 3:
                return GALLERY_TAB_INSTAGRAM;
            default:
                return GALLERY_TAB_UNKNOW;
        }
    }
}
