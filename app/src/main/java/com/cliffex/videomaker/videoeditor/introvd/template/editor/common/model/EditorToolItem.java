package com.introvd.template.editor.common.model;

import java.io.Serializable;

public class EditorToolItem implements Serializable {
    public boolean bHightL;
    public int coverResID;
    public boolean enable = true;
    public int mode;
    public String titleResID;

    public EditorToolItem(int i, int i2, String str) {
        this.mode = i;
        this.coverResID = i2;
        this.titleResID = str;
    }

    public EditorToolItem(int i, int i2, String str, boolean z) {
        this.mode = i;
        this.coverResID = i2;
        this.titleResID = str;
        this.bHightL = z;
    }
}
