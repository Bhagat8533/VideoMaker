package com.aiii.android.arouter.p093e;

import android.net.Uri;
import android.text.TextUtils;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/* renamed from: com.aiii.android.arouter.e.e */
public class C1940e {
    /* renamed from: a */
    public static String m5577a(StackTraceElement[] stackTraceElementArr) {
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            sb.append("    at ");
            sb.append(stackTraceElement.toString());
            sb.append("\n");
        }
        return sb.toString();
    }

    /* renamed from: d */
    public static Map<String, String> m5578d(Uri uri) {
        String encodedQuery = uri.getEncodedQuery();
        if (encodedQuery == null) {
            return Collections.emptyMap();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int i = 0;
        do {
            int indexOf = encodedQuery.indexOf(38, i);
            if (indexOf == -1) {
                indexOf = encodedQuery.length();
            }
            int indexOf2 = encodedQuery.indexOf(61, i);
            if (indexOf2 > indexOf || indexOf2 == -1) {
                indexOf2 = indexOf;
            }
            String substring = encodedQuery.substring(i, indexOf2);
            if (!TextUtils.isEmpty(substring)) {
                linkedHashMap.put(Uri.decode(substring), Uri.decode(indexOf2 == indexOf ? "" : encodedQuery.substring(indexOf2 + 1, indexOf)));
            }
            i = indexOf + 1;
        } while (i < encodedQuery.length());
        return Collections.unmodifiableMap(linkedHashMap);
    }

    public static boolean isEmpty(CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }
}
