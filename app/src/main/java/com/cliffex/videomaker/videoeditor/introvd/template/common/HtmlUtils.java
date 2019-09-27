package com.introvd.template.common;

import android.text.TextUtils;
import com.ironsource.sdk.constants.Constants.RequestParameters;

public class HtmlUtils {
    public static String decode(String str) {
        return TextUtils.isEmpty(str) ? str : str.replace("&lt;", "<").replace("&gt;", ">").replace("&quot;", "\"").replace("&apos;", "'").replace("&amp;", RequestParameters.AMPERSAND).replace("&#39;", "'");
    }
}
