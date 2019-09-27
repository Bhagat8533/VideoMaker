package com.introvd.template.router;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.ironsource.sdk.constants.Constants.RequestParameters;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class PassThoughUrlGenerator {
    public static final String EXTRA_PASS_THROUGH_URL = "EXTRA_PASS_THROUGH_URL";

    public static String generateUrl(String str, Object... objArr) {
        StringBuilder sb = new StringBuilder();
        sb.append(BaseRouter.SCHEMA);
        sb.append(str);
        return replaceParams(sb.toString(), objArr);
    }

    public static <T> T getInfoFromBundle(Bundle bundle, Class<T> cls) {
        if (bundle == null) {
            return null;
        }
        return getInfoFromIntent(bundle.getString(EXTRA_PASS_THROUGH_URL), cls);
    }

    public static <T> T getInfoFromIntent(Intent intent, Class<T> cls) {
        if (intent == null) {
            return null;
        }
        return getInfoFromIntent(intent.getStringExtra(EXTRA_PASS_THROUGH_URL), cls);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0027 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0028 A[SYNTHETIC, Splitter:B:15:0x0028] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <T> T getInfoFromIntent(java.lang.String r2, java.lang.Class<T> r3) {
        /*
            r0 = 0
            if (r2 != 0) goto L_0x0004
            return r0
        L_0x0004:
            android.net.Uri r2 = android.net.Uri.parse(r2)
            if (r2 != 0) goto L_0x000b
            return r0
        L_0x000b:
            java.lang.String r1 = r3.getSimpleName()     // Catch:{ UnsupportedEncodingException -> 0x0020 }
            java.lang.String r2 = r2.getQueryParameter(r1)     // Catch:{ UnsupportedEncodingException -> 0x0020 }
            boolean r1 = android.text.TextUtils.isEmpty(r2)     // Catch:{ UnsupportedEncodingException -> 0x0020 }
            if (r1 != 0) goto L_0x0024
            java.lang.String r1 = "UTF-8"
            java.lang.String r2 = java.net.URLDecoder.decode(r2, r1)     // Catch:{ UnsupportedEncodingException -> 0x0020 }
            goto L_0x0025
        L_0x0020:
            r2 = move-exception
            r2.printStackTrace()
        L_0x0024:
            r2 = r0
        L_0x0025:
            if (r2 != 0) goto L_0x0028
            return r0
        L_0x0028:
            com.google.gson.Gson r1 = new com.google.gson.Gson     // Catch:{ Exception -> 0x0032 }
            r1.<init>()     // Catch:{ Exception -> 0x0032 }
            java.lang.Object r2 = r1.fromJson(r2, r3)     // Catch:{ Exception -> 0x0032 }
            goto L_0x0037
        L_0x0032:
            r2 = move-exception
            r2.printStackTrace()
            r2 = r0
        L_0x0037:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.router.PassThoughUrlGenerator.getInfoFromIntent(java.lang.String, java.lang.Class):java.lang.Object");
    }

    public static String getPassThroughUrlFromIntent(Intent intent) {
        if (intent == null) {
            return null;
        }
        return intent.getStringExtra(EXTRA_PASS_THROUGH_URL);
    }

    public static String getPassThroughUrlFromIntent(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        return bundle.getString(EXTRA_PASS_THROUGH_URL);
    }

    private static String replace(String str, Object obj) {
        String str2;
        Uri parse = Uri.parse(str);
        String str3 = null;
        if (parse == null) {
            return null;
        }
        try {
            str3 = URLEncoder.encode(new Gson().toJson(obj), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String queryParameter = parse.getQueryParameter(obj.getClass().getSimpleName());
        try {
            if (!TextUtils.isEmpty(queryParameter)) {
                queryParameter = URLEncoder.encode(queryParameter, "UTF-8");
            }
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
        }
        if (queryParameter != null && str3 != null) {
            return str.replace(queryParameter, str3);
        }
        if (parse.getQueryParameterNames().size() == 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append("?");
            sb.append(obj.getClass().getSimpleName());
            sb.append(RequestParameters.EQUAL);
            sb.append(str3);
            str2 = sb.toString();
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append(RequestParameters.AMPERSAND);
            sb2.append(obj.getClass().getSimpleName());
            sb2.append(RequestParameters.EQUAL);
            sb2.append(str3);
            str2 = sb2.toString();
        }
        return str2;
    }

    public static String replaceParams(String str, Object... objArr) {
        if (str == null || objArr == null || objArr.length == 0) {
            return str;
        }
        for (Object obj : objArr) {
            if (obj != null) {
                str = replace(str, obj);
            }
        }
        return str;
    }
}
