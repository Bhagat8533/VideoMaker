package com.introvd.template.p321k;

import com.introvd.template.common.FileUtils;
import com.introvd.template.p321k.C7550b.C7551a;

/* renamed from: com.introvd.template.k.a */
public abstract class C7549a {
    protected long cro = 0;
    protected long crp = 0;
    protected long crq = 0;
    protected final String crr;
    protected final String crs;
    protected final long crt;
    protected boolean cru = false;
    protected Throwable crv = null;
    protected C7551a crw = null;

    public C7549a(String str, String str2, long j) {
        this.crr = str;
        this.crs = str2;
        this.crt = j;
    }

    /* renamed from: fW */
    public static void m22299fW(String str) {
        for (int i = 0; i < 1; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(".part");
            sb.append(i);
            FileUtils.deleteFile(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(".part");
        FileUtils.deleteFile(sb2.toString());
        FileUtils.deleteFile(str);
    }

    /* renamed from: a */
    public void mo32414a(C7551a aVar) {
        this.crw = aVar;
    }

    public boolean aaX() {
        return this.cru;
    }

    public long aaY() {
        return this.cro;
    }

    public long aaZ() {
        return this.crp;
    }

    public long aba() {
        return this.crq;
    }

    public String abb() {
        return this.crr;
    }

    public String abc() {
        return this.crs;
    }

    public long abd() {
        return this.crt;
    }

    public Throwable abe() {
        return this.crv;
    }

    public abstract boolean start();

    public abstract boolean stop();
}
