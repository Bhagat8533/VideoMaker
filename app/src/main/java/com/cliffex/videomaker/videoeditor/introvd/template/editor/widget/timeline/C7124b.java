package com.introvd.template.editor.widget.timeline;

import com.introvd.template.common.LogUtils;
import com.introvd.template.common.model.Range;

/* renamed from: com.introvd.template.editor.widget.timeline.b */
public class C7124b {
    private static final String dvG = "b";

    /* renamed from: a */
    public boolean mo28344a(int i, Range range) {
        String str = dvG;
        StringBuilder sb = new StringBuilder();
        sb.append("onUpdateRange,index:");
        sb.append(i);
        sb.append(",range:");
        sb.append(range.toString());
        LogUtils.m14223i(str, sb.toString());
        return false;
    }

    public void acD() {
        LogUtils.m14223i(dvG, "onStartMove");
    }

    public void acd() {
        LogUtils.m14223i(dvG, "onEndSeek");
    }

    /* renamed from: dY */
    public void mo28347dY(boolean z) {
        String str = dvG;
        StringBuilder sb = new StringBuilder();
        sb.append("onStartDrag bLeft:");
        sb.append(z);
        LogUtils.m14223i(str, sb.toString());
    }

    /* renamed from: dZ */
    public void mo28348dZ(boolean z) {
        LogUtils.m14223i(dvG, "onAttainLimit");
    }

    /* renamed from: iD */
    public void mo28349iD(int i) {
        String str = dvG;
        StringBuilder sb = new StringBuilder();
        sb.append("onProgressChanged progress:");
        sb.append(i);
        LogUtils.m14223i(str, sb.toString());
    }

    /* renamed from: kM */
    public void mo28350kM(int i) {
        String str = dvG;
        StringBuilder sb = new StringBuilder();
        sb.append("onEditRangeSelected index:");
        sb.append(i);
        LogUtils.m14223i(str, sb.toString());
    }

    /* renamed from: kN */
    public int mo28351kN(int i) {
        String str = dvG;
        StringBuilder sb = new StringBuilder();
        sb.append("getEffectMaxLen index:");
        sb.append(i);
        LogUtils.m14223i(str, sb.toString());
        return 268435455;
    }

    /* renamed from: kz */
    public void mo28352kz(int i) {
        String str = dvG;
        StringBuilder sb = new StringBuilder();
        sb.append("onStartSeek progress:");
        sb.append(i);
        LogUtils.m14223i(str, sb.toString());
    }
}
