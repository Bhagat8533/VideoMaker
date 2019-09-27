package com.aiii.sdk.android.oss.common.utils;

import com.ironsource.sdk.constants.Constants.RequestParameters;
import java.net.URLEncoder;
import java.util.Map;
import java.util.Map.Entry;

public class HttpUtil {
    public static String paramToQueryString(Map<String, String> map, String str) {
        if (map == null || map.isEmpty()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (Entry entry : map.entrySet()) {
            String str2 = (String) entry.getKey();
            String str3 = (String) entry.getValue();
            if (!z) {
                sb.append(RequestParameters.AMPERSAND);
            }
            sb.append(urlEncode(str2, str));
            if (str3 != null) {
                sb.append(RequestParameters.EQUAL);
                sb.append(urlEncode(str3, str));
            }
            z = false;
        }
        return sb.toString();
    }

    public static String urlEncode(String str, String str2) {
        if (str == null) {
            return "";
        }
        try {
            return URLEncoder.encode(str, str2).replace("+", "%20").replace("*", "%2A").replace("%7E", "~").replace("%2F", "/");
        } catch (Exception e) {
            throw new IllegalArgumentException("failed to encode url!", e);
        }
    }
}
