package com.introvd.template.editor.preview.clipsort;

import java.lang.ref.WeakReference;
import java.util.Locale;
import xiaoying.engine.storyboard.QStoryboard;

/* renamed from: com.introvd.template.editor.preview.clipsort.b */
public class C6562b {
    public int clipIndex;
    public int daL;
    public WeakReference<QStoryboard> daM;
    public int daN;
    public int daO;
    public boolean daP;
    public String path;
    public int rotate;
    public int startPos;

    public C6562b(int i, String str, int i2, int i3, int i4, int i5, int i6, QStoryboard qStoryboard, boolean z) {
        this.clipIndex = i;
        this.path = str;
        this.startPos = i2;
        this.daL = i3;
        this.rotate = i4;
        this.daN = i5;
        this.daO = i6;
        this.daM = new WeakReference<>(qStoryboard);
        this.daP = z;
    }

    /* renamed from: so */
    public String mo29880so() {
        return String.format(Locale.ROOT, "%s-%d-%d-%d-%d-%d-%b", new Object[]{this.path, Integer.valueOf(this.startPos), Integer.valueOf(this.daL), Integer.valueOf(this.rotate), Integer.valueOf(this.daN), Integer.valueOf(this.daO), Boolean.valueOf(this.daP)});
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ClipThumbParams{path='");
        sb.append(this.path);
        sb.append('\'');
        sb.append(", startPos=");
        sb.append(this.startPos);
        sb.append(", rowStartPos=");
        sb.append(this.daL);
        sb.append(", rotate=");
        sb.append(this.rotate);
        sb.append(", clipIndex=");
        sb.append(this.clipIndex);
        sb.append(", mStoryboardRef=");
        sb.append(this.daM);
        sb.append(", trimReverseStartPos=");
        sb.append(this.daN);
        sb.append(", trimReverseEndPos=");
        sb.append(this.daO);
        sb.append(", clipReverse= ");
        sb.append(this.daP);
        sb.append('}');
        return sb.toString();
    }
}
