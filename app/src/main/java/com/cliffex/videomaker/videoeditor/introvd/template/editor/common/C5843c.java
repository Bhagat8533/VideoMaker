package com.introvd.template.editor.common;

import com.introvd.template.sdk.model.editor.EffectInfoModel;
import com.introvd.template.sdk.model.template.TemplateInfo;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.introvd.template.editor.common.c */
public class C5843c {
    private static int baseMode = -1;
    private static C5843c cEK = null;
    private static int cEL = 0;
    private static boolean cEM = false;
    private static EffectInfoModel cEN = null;
    private static boolean cEO = false;
    private static boolean cEP = false;
    private static Map<String, List<TemplateInfo>> cEQ = new LinkedHashMap();
    private static int secondaryMode = -1;
    private static int tabMode = -1;

    private C5843c() {
    }

    public static C5843c agO() {
        if (cEK == null) {
            cEK = new C5843c();
        }
        return cEK;
    }

    public boolean agP() {
        return cEP;
    }

    public synchronized int agQ() {
        return cEL;
    }

    public int agR() {
        return baseMode;
    }

    public int agS() {
        return secondaryMode;
    }

    public boolean agT() {
        return cEM;
    }

    public boolean agU() {
        return false;
    }

    public EffectInfoModel agV() {
        return cEN;
    }

    /* renamed from: b */
    public void mo28227b(String str, List<TemplateInfo> list) {
        cEQ.put(str, list);
    }

    /* renamed from: e */
    public void mo28228e(EffectInfoModel effectInfoModel) {
        cEN = effectInfoModel;
    }

    /* renamed from: eP */
    public void mo28229eP(boolean z) {
        cEP = z;
    }

    /* renamed from: eQ */
    public void mo28230eQ(boolean z) {
        cEM = z;
    }

    /* renamed from: eR */
    public void mo28231eR(boolean z) {
        cEO = z;
    }

    /* renamed from: gR */
    public List<TemplateInfo> mo28232gR(String str) {
        return (List) cEQ.get(str);
    }

    public int getTabMode() {
        return tabMode;
    }

    /* renamed from: lS */
    public synchronized void mo28234lS(int i) {
        cEL = i;
    }

    /* renamed from: lT */
    public void mo28235lT(int i) {
        baseMode = i;
    }

    /* renamed from: lU */
    public void mo28236lU(int i) {
        secondaryMode = i;
    }

    public void reset() {
        cEL = 0;
        cEO = false;
        cEM = false;
        baseMode = -1;
        secondaryMode = -1;
        tabMode = -1;
        cEN = null;
    }

    public void setTabMode(int i) {
        tabMode = i;
    }
}
