package com.introvd.template.editor.common;

import com.introvd.template.common.LogUtils;

/* renamed from: com.introvd.template.editor.common.d */
public class C5852d {
    private static C5852d cER;
    private static int cES;
    private static int cET;
    private static int cEU;

    private C5852d() {
    }

    public static C5852d agW() {
        if (cER == null) {
            cER = new C5852d();
        }
        return cER;
    }

    public synchronized int agX() {
        return cET;
    }

    public synchronized int agY() {
        return cES;
    }

    public synchronized int agZ() {
        return cEU;
    }

    /* renamed from: lV */
    public synchronized void mo28248lV(int i) {
        cET = i;
    }

    /* renamed from: lW */
    public synchronized void mo28249lW(int i) {
        String str = "WOOOLLW";
        StringBuilder sb = new StringBuilder();
        sb.append("----------------PlayerStatus updatePlayerCurrTime:");
        sb.append(i);
        LogUtils.m14222e(str, sb.toString());
        cES = i;
    }

    /* renamed from: lX */
    public synchronized void mo28250lX(int i) {
        cEU = i;
    }

    public void reset() {
        cES = 0;
        cET = 0;
        cEU = 0;
    }
}
