package com.introvd.template.common.bitmapfun;

import android.content.Context;
import android.graphics.Bitmap.Config;
import com.introvd.template.common.CommonConfigure;
import java.io.File;

public class Utils {
    private static final Config cdR = Config.RGB_565;

    public static File getExternalCacheDir(Context context) {
        return new File(CommonConfigure.getAppCacheDir());
    }
}
