package com.introvd.template.common.utils;

import com.introvd.template.common.MSize;
import xiaoying.engine.base.QUtils;

public class UtilsMSize {
    public static final MSize OUTPUT_SIZE_QVGA = new MSize(320, 240);
    public static final MSize OUTPUT_SIZE_VGA = new MSize((int) QUtils.VIDEO_RES_VGA_WIDTH, 480);

    public static MSize getFitInSize(MSize mSize, MSize mSize2) {
        if (mSize == null || mSize2 == null) {
            return mSize;
        }
        if (mSize.width == 0 || mSize.height == 0 || mSize2.width == 0 || mSize2.height == 0) {
            return new MSize(OUTPUT_SIZE_VGA.width, OUTPUT_SIZE_VGA.height);
        }
        int i = mSize.width;
        int i2 = mSize.height;
        int i3 = mSize2.width;
        int i4 = mSize2.height;
        int i5 = (i * i4) / i2;
        if (i5 > i3) {
            i4 = (i2 * i3) / i;
        } else {
            i3 = i5;
        }
        return new MSize(i3, i4);
    }
}
