package com.introvd.template.sdk.utils;

import xiaoying.engine.base.QUtils;

/* renamed from: com.introvd.template.sdk.utils.v */
public class C8569v {
    public static final VeMSize egH = new VeMSize((int) QUtils.VIDEO_RES_VGA_WIDTH, 480);
    public static final VeMSize ehj = new VeMSize(320, 240);

    /* renamed from: a */
    public static VeMSize m25057a(VeMSize veMSize, VeMSize veMSize2) {
        if (veMSize == null || veMSize2 == null) {
            return veMSize;
        }
        if (veMSize.width == 0 || veMSize.height == 0 || veMSize2.width == 0 || veMSize2.height == 0) {
            return new VeMSize(egH.width, egH.height);
        }
        int i = veMSize.width;
        int i2 = veMSize.height;
        int i3 = veMSize2.width;
        int i4 = veMSize2.height;
        int i5 = (i * i4) / i2;
        if (i5 > i3) {
            i4 = (i2 * i3) / i;
        } else {
            i3 = i5;
        }
        return new VeMSize(i3, i4);
    }
}
