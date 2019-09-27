package com.introvd.template.sdk.p381b.p382a;

import android.os.Handler;
import android.text.TextUtils;
import java.util.HashMap;

/* renamed from: com.introvd.template.sdk.b.a.a */
public abstract class C8384a {
    protected int ecf = 0;
    protected long ecg = 0;
    protected String ech = null;
    protected C8385a eci = new C8385a();
    protected Object ecj = null;
    protected Object eck = null;
    protected int ecl = 0;
    protected int ecm = 90;
    protected int ecn = 90;
    protected int eco = 0;
    protected int ecp = 0;
    protected Handler mEventHandler = null;

    /* renamed from: com.introvd.template.sdk.b.a.a$a */
    public static class C8385a {

        /* renamed from: bf */
        private HashMap<String, String> f3594bf = new HashMap<>(64);

        public String get(String str) {
            return (String) this.f3594bf.get(str);
        }

        public int getInt(String str) {
            int i;
            String str2 = get(str);
            if (TextUtils.isEmpty(str2)) {
                return 0;
            }
            try {
                i = Integer.parseInt(str2);
            } catch (Exception unused) {
                i = 0;
            }
            return i;
        }

        public void set(String str, String str2) {
            this.f3594bf.put(str, str2);
        }
    }

    /* renamed from: VE */
    public int mo33892VE() {
        return this.ecp;
    }

    /* renamed from: VF */
    public int mo33893VF() {
        return this.eco;
    }

    /* renamed from: VH */
    public int mo33894VH() {
        return this.ecl;
    }

    /* renamed from: a */
    public void mo33895a(C8385a aVar) {
        this.eci = aVar;
    }

    public long aHp() {
        return this.ecg;
    }

    public C8385a aHq() {
        return this.eci;
    }

    public int aHr() {
        return 0;
    }

    /* renamed from: aW */
    public void mo33899aW(long j) {
        this.ecg = j;
    }

    /* renamed from: b */
    public void mo33900b(Handler handler) {
        this.mEventHandler = handler;
    }

    /* renamed from: iY */
    public void mo33901iY(int i) {
        this.ecp = i;
    }

    /* renamed from: iZ */
    public void mo33902iZ(int i) {
        this.eco = i;
    }

    /* renamed from: nx */
    public int mo33903nx(String str) {
        this.ech = str;
        return 0;
    }

    /* renamed from: tA */
    public int mo33904tA(int i) {
        int i2 = i % 360;
        if (i2 == 0 || i2 == 90 || i2 == 180 || i2 == 270) {
            this.ecl = i2;
        }
        return 0;
    }

    /* renamed from: tB */
    public int mo33905tB(int i) {
        this.ecm = i;
        return i;
    }

    /* renamed from: tC */
    public void mo33906tC(int i) {
        this.ecn = i % 360;
    }
}
