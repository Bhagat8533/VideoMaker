package com.introvd.template.common.bitmapfun.util;

import android.media.ExifInterface;
import xiaoying.engine.base.QDisplayContext;

public class ExThumbnailUtil {
    public static int getOrientation(ExifInterface exifInterface) {
        if (exifInterface != null) {
            int attributeInt = exifInterface.getAttributeInt(android.supportin.media.ExifInterface.TAG_ORIENTATION, -1);
            if (attributeInt != -1) {
                if (attributeInt == 3) {
                    return QDisplayContext.DISPLAY_ROTATION_180;
                }
                if (attributeInt == 6) {
                    return 90;
                }
                if (attributeInt == 8) {
                    return QDisplayContext.DISPLAY_ROTATION_270;
                }
            }
        }
        return 0;
    }
}
