package com.introvd.template.editor.effects.nav;

import java.util.Locale;

/* renamed from: com.introvd.template.editor.effects.nav.a */
public class C6184a {
    public final int cNf;
    public final int cNg;
    public final String mStylePath;

    public C6184a(String str, int i, int i2) {
        this.mStylePath = str;
        this.cNf = i;
        this.cNg = i2;
    }

    /* renamed from: so */
    public String mo29004so() {
        return String.format(Locale.ROOT, "%s-%08x-%08x", new Object[]{this.mStylePath, Integer.valueOf(this.cNf), Integer.valueOf(this.cNg)});
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("EffectThumbParams{mStylePath='");
        sb.append(this.mStylePath);
        sb.append('\'');
        sb.append(", mFrameWidth=");
        sb.append(this.cNf);
        sb.append(", mFrameHeight=");
        sb.append(this.cNg);
        sb.append('}');
        return sb.toString();
    }
}
