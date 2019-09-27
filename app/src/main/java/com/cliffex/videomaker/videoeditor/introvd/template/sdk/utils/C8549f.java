package com.introvd.template.sdk.utils;

import com.introvd.template.sdk.utils.p394b.C8501a;
import xiaoying.engine.QEngine;
import xiaoying.engine.base.QUtils;

/* renamed from: com.introvd.template.sdk.utils.f */
public class C8549f {
    private static Boolean egI;
    private static Boolean egJ;
    private static Boolean egK;
    private static Boolean egL;
    private static Boolean egM;
    private static Boolean egN;
    private static Boolean egO;

    public static boolean aJc() {
        if (egL != null) {
            return egL.booleanValue();
        }
        QEngine aJv = C8501a.aJs().aJv();
        boolean z = false;
        if (aJv == null) {
            return false;
        }
        if (QUtils.IsSupportHD(aJv) == 2 || isHD2KSupport() || isHD4KSupport()) {
            z = true;
        }
        egL = Boolean.valueOf(z);
        return egL.booleanValue();
    }

    public static boolean aJd() {
        if (egO != null) {
            return egO.booleanValue();
        }
        QEngine aJv = C8501a.aJs().aJv();
        boolean z = false;
        if (aJv == null) {
            return false;
        }
        if (m25002d(aJv) || m25001c(aJv)) {
            z = true;
        }
        egO = Boolean.valueOf(z);
        return egO.booleanValue();
    }

    public static Boolean aJe() {
        if (egK != null) {
            return egK;
        }
        QEngine aJv = C8501a.aJs().aJv();
        boolean z = false;
        if (aJv == null) {
            return Boolean.valueOf(false);
        }
        if (m25002d(aJv) || m25001c(aJv)) {
            z = true;
        }
        egK = Boolean.valueOf(z);
        return egK;
    }

    public static Boolean aJf() {
        if (egJ != null) {
            return egJ;
        }
        QEngine aJv = C8501a.aJs().aJv();
        if (aJv == null) {
            return Boolean.valueOf(false);
        }
        egJ = Boolean.valueOf(m25001c(aJv));
        return egJ;
    }

    public static boolean aJg() {
        if (egI != null) {
            return egI.booleanValue();
        }
        QEngine aJv = C8501a.aJs().aJv();
        if (aJv == null) {
            return false;
        }
        egI = Boolean.valueOf(m25002d(aJv));
        return egI.booleanValue();
    }

    /* renamed from: c */
    private static boolean m25001c(QEngine qEngine) {
        return (QUtils.IsSupportHD(qEngine) & 16) != 0;
    }

    /* renamed from: d */
    private static boolean m25002d(QEngine qEngine) {
        return QUtils.IsSupportHD(qEngine) != 0 && !m25001c(qEngine);
    }

    public static boolean isHD2KSupport() {
        if (egM != null) {
            return egM.booleanValue();
        }
        QEngine aJv = C8501a.aJs().aJv();
        boolean z = false;
        if (aJv == null) {
            return false;
        }
        if (QUtils.IsSupportHD(aJv) == 4) {
            z = true;
        }
        egM = Boolean.valueOf(z);
        return egM.booleanValue();
    }

    public static boolean isHD4KSupport() {
        if (egN != null) {
            return egN.booleanValue();
        }
        QEngine aJv = C8501a.aJs().aJv();
        boolean z = false;
        if (aJv == null) {
            return false;
        }
        if (QUtils.IsSupportHD(aJv) == 8) {
            z = true;
        }
        egN = Boolean.valueOf(z);
        return egN.booleanValue();
    }
}
