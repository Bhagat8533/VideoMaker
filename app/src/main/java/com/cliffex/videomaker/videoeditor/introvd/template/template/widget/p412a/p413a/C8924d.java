package com.introvd.template.template.widget.p412a.p413a;

import android.graphics.Bitmap;
import java.io.Serializable;

/* renamed from: com.introvd.template.template.widget.a.a.d */
public class C8924d implements Serializable {
    private long evF;
    private String evG;
    private Bitmap evH;
    private boolean evI;

    public long aMI() {
        return this.evF;
    }

    public String aMJ() {
        return this.evG;
    }

    public Bitmap aMK() {
        return this.evH;
    }

    public boolean isSelected() {
        return this.evI;
    }

    /* renamed from: qT */
    public void mo35514qT(String str) {
        this.evG = str;
    }

    public void setSelected(boolean z) {
        this.evI = z;
    }

    public void setTemplateId(long j) {
        this.evF = j;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FilterChild{mChildText='");
        sb.append(this.evG);
        sb.append('\'');
        sb.append(", mChildCover='");
        sb.append(this.evH);
        sb.append('\'');
        sb.append('}');
        return sb.toString();
    }

    /* renamed from: v */
    public void mo35518v(Bitmap bitmap) {
        this.evH = bitmap;
    }
}
