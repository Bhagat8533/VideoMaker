package com.introvd.template.picker;

import android.text.TextUtils;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.introvd.template.picker.b */
public class C8186b {
    private static C8186b dXN;
    private String dXO;
    private boolean dXP = true;
    private LinkedList<String> dXQ = new LinkedList<>();
    private C8187a dXR;

    /* renamed from: com.introvd.template.picker.b$a */
    public interface C8187a {
        /* renamed from: cz */
        void mo33259cz(List<String> list);

        /* renamed from: mk */
        void mo33260mk(String str);
    }

    private C8186b() {
    }

    public static C8186b aFr() {
        if (dXN == null) {
            dXN = new C8186b();
        }
        return dXN;
    }

    /* renamed from: a */
    public void mo33288a(C8187a aVar) {
        this.dXR = aVar;
    }

    public List<String> aFs() {
        return this.dXQ;
    }

    public String aFt() {
        return this.dXO;
    }

    public int aFu() {
        return this.dXQ.size();
    }

    /* renamed from: cA */
    public void mo33292cA(List<String> list) {
        for (String mm : list) {
            mo33295mm(mm);
        }
    }

    /* renamed from: iS */
    public void mo33293iS(boolean z) {
        this.dXP = z;
    }

    /* renamed from: ml */
    public int mo33294ml(String str) {
        int frequency = Collections.frequency(this.dXQ, str);
        if (frequency > 0 && this.dXP) {
            this.dXQ.add(this.dXQ.indexOf(str) + 1, str);
            if (this.dXR != null) {
                this.dXR.mo33260mk(str);
            }
        }
        return frequency + 1;
    }

    /* renamed from: mm */
    public void mo33295mm(String str) {
        if (!this.dXQ.contains(str)) {
            if (!this.dXP) {
                this.dXQ.clear();
                if (this.dXR != null) {
                    this.dXR.mo33259cz(this.dXQ);
                }
            }
            this.dXQ.add(str);
            if (this.dXR != null) {
                this.dXR.mo33260mk(str);
            }
        }
    }

    /* renamed from: mn */
    public void mo33296mn(String str) {
        if (this.dXQ.contains(str)) {
            Iterator it = this.dXQ.iterator();
            while (it.hasNext()) {
                if (((String) it.next()).equals(str)) {
                    it.remove();
                }
            }
        }
    }

    /* renamed from: mo */
    public void mo33297mo(String str) {
        this.dXO = str;
    }

    /* renamed from: mp */
    public boolean mo33298mp(String str) {
        return !TextUtils.isEmpty(str) && this.dXQ.contains(str);
    }

    /* renamed from: mq */
    public boolean mo33299mq(String str) {
        return !TextUtils.isEmpty(str) && TextUtils.equals(str, this.dXO);
    }

    /* renamed from: mr */
    public int mo33300mr(String str) {
        return Collections.frequency(this.dXQ, str);
    }

    public void reset() {
        this.dXO = null;
        this.dXR = null;
        this.dXP = true;
        this.dXQ = new LinkedList<>();
    }
}
