package com.introvd.template.sdk.p381b.p382a;

import com.introvd.template.sdk.C8401d;
import com.introvd.template.sdk.utils.C8548e;
import com.introvd.template.sdk.utils.C8554j;
import xiaoying.engine.base.QFaceDTUtils;

/* renamed from: com.introvd.template.sdk.b.a.b */
public class C8386b {
    public static String aHs() {
        StringBuilder sb = new StringBuilder();
        sb.append(C8401d.and());
        sb.append("fdfile/track_data.dat");
        return sb.toString();
    }

    public static String aHt() {
        StringBuilder sb = new StringBuilder();
        sb.append(C8401d.and());
        sb.append("fdfile/arcsoft_spotlight.license");
        return sb.toString();
    }

    public static boolean aHu() {
        return m24161ny(aHt()) && C8548e.isFileExisted(aHs());
    }

    /* renamed from: ny */
    public static boolean m24161ny(String str) {
        int checkFaceDTLibLicenseFile = QFaceDTUtils.checkFaceDTLibLicenseFile(str);
        StringBuilder sb = new StringBuilder();
        sb.append("initFDLicence iResult=");
        sb.append(checkFaceDTLibLicenseFile);
        C8554j.m25006d("FDUtils", sb.toString());
        return checkFaceDTLibLicenseFile == 0;
    }
}
