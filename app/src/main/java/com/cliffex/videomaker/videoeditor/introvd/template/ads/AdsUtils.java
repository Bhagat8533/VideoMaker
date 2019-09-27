package com.introvd.template.ads;

import com.introvd.template.ads.utils.VivaDesUtil;

public class AdsUtils {
    private static final String TAG = "AdsUtils";
    private static final byte[] bfh = {88, 89, 119, 97, 116, 101, 114, 109, 97, 114, 107};

    public static String getDecryptString(String str) {
        return VivaDesUtil.decrypt(new String(bfh), str);
    }
}
