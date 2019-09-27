package com.introvd.template.plugin.downloader.p373d;

import android.text.TextUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okhttp3.internal.p481c.C9852e;
import p469f.C9768m;
import p503cz.msebera.android.httpclient.HttpHeaders;
import p503cz.msebera.android.httpclient.protocol.HTTP;

/* renamed from: com.introvd.template.plugin.downloader.d.d */
public class C8303d {
    /* renamed from: d */
    public static String m23965d(String str, C9768m<?> mVar) {
        String i = m23966i(mVar);
        if (TextUtils.isEmpty(i)) {
            i = str.substring(str.lastIndexOf(47) + 1);
        }
        if (i.startsWith("\"")) {
            i = i.substring(1);
        }
        return i.endsWith("\"") ? i.substring(0, i.length() - 1) : i;
    }

    /* renamed from: i */
    public static String m23966i(C9768m<?> mVar) {
        String str = mVar.aWY().get("Content-Disposition");
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        Matcher matcher = Pattern.compile(".*filename=(.*)").matcher(str.toLowerCase());
        return matcher.find() ? matcher.group(1) : "";
    }

    /* renamed from: j */
    public static boolean m23967j(C9768m<?> mVar) {
        return HTTP.CHUNK_CODING.equals(m23971n(mVar));
    }

    /* renamed from: k */
    public static boolean m23968k(C9768m<?> mVar) {
        return (TextUtils.isEmpty(m23972o(mVar)) && !TextUtils.equals(m23973p(mVar), "bytes")) || m23969l(mVar) == -1 || m23967j(mVar);
    }

    /* renamed from: l */
    public static long m23969l(C9768m<?> mVar) {
        return C9852e.m28105d(mVar.aWY());
    }

    /* renamed from: m */
    public static String m23970m(C9768m<?> mVar) {
        return mVar.aWY().get("Last-Modified");
    }

    /* renamed from: n */
    private static String m23971n(C9768m<?> mVar) {
        return mVar.aWY().get("Transfer-Encoding");
    }

    /* renamed from: o */
    private static String m23972o(C9768m<?> mVar) {
        return mVar.aWY().get("Content-Range");
    }

    /* renamed from: p */
    private static String m23973p(C9768m<?> mVar) {
        return mVar.aWY().get(HttpHeaders.ACCEPT_RANGES);
    }
}
