package com.introvd.template.explorer.file;

import android.graphics.drawable.Drawable;

/* renamed from: com.introvd.template.explorer.file.a */
public class C7241a implements Comparable<C7241a> {

    /* renamed from: Gj */
    private Drawable f3540Gj = null;
    private boolean dyV = false;
    private C7242a dyW = C7242a.LAST_DIR;
    private String mText = "";

    /* renamed from: com.introvd.template.explorer.file.a$a */
    public enum C7242a {
        LAST_DIR,
        DIREC_OR_FILE
    }

    public C7241a(String str, Drawable drawable, C7242a aVar) {
        this.f3540Gj = drawable;
        this.mText = str;
        this.dyW = aVar;
    }

    /* renamed from: a */
    public int compareTo(C7241a aVar) {
        if (this.mText != null) {
            return this.mText.compareTo(aVar.getFileName());
        }
        throw new IllegalArgumentException();
    }

    public C7242a awt() {
        return this.dyW;
    }

    public String getFileName() {
        String str = this.mText;
        return str.startsWith("/") ? str.substring(1) : str;
    }

    public String getFilePath() {
        return this.mText;
    }

    public Drawable getIcon() {
        return this.f3540Gj;
    }

    public boolean isSelectable() {
        return this.dyV;
    }

    public void setSelectable(boolean z) {
        this.dyV = z;
    }
}
