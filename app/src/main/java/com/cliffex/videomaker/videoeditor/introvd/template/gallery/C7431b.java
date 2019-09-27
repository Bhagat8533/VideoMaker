package com.introvd.template.gallery;

import com.introvd.template.gallery.model.ImgPreviewDataItem;
import com.introvd.template.gallery.p311a.C7391b;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.introvd.template.gallery.b */
public class C7431b {
    private static C7431b dFt;
    private int cTk;
    private int dFu;
    private int dFv;
    private List<ImgPreviewDataItem> dFw;
    private int extraIntentMode = -1;

    private C7431b() {
    }

    public static C7431b aym() {
        if (dFt == null) {
            dFt = new C7431b();
        }
        return dFt;
    }

    public int amL() {
        return this.cTk;
    }

    public boolean ayn() {
        return (!C7391b.dHv || getExtraIntentMode() == 2004 || amL() == 1 || amL() == 4 || amL() == 5 || amL() == 10 || amL() == 6 || amL() == 8 || amL() == 9) ? false : true;
    }

    public boolean ayo() {
        return amL() != 6;
    }

    public List<ImgPreviewDataItem> ayp() {
        return this.dFw == null ? new ArrayList() : this.dFw;
    }

    public void ayq() {
        if (this.dFw != null) {
            this.dFw.clear();
        }
    }

    /* renamed from: bW */
    public void mo32083bW(List<ImgPreviewDataItem> list) {
        this.dFw = list;
    }

    public int getExtraIntentMode() {
        return this.extraIntentMode;
    }

    public int getSourceType() {
        return this.dFu;
    }

    /* renamed from: nB */
    public void mo32086nB(int i) {
        this.cTk = i;
    }

    /* renamed from: rc */
    public void mo32087rc(int i) {
        this.dFu = i;
    }

    /* renamed from: rd */
    public void mo32088rd(int i) {
        this.dFv = i;
    }

    public void release() {
        this.dFv = 0;
        this.dFu = 0;
        this.extraIntentMode = -1;
    }

    public void setExtraIntentMode(int i) {
        this.extraIntentMode = i;
    }
}
