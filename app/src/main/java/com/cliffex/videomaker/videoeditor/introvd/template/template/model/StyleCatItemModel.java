package com.introvd.template.template.model;

public class StyleCatItemModel {
    public static final int TYPE_GIF = 2;
    public static final int TYPE_PACKAGE = 0;
    public static final int TYPE_ROLL = 1;
    public String name;
    public String strPath;
    public String ttid;
    public int type;

    public StyleCatItemModel(int i, String str) {
        this.type = i;
        this.ttid = str;
    }

    public StyleCatItemModel(int i, String str, String str2) {
        this.type = i;
        this.ttid = str;
        this.name = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.ttid.equals(((StyleCatItemModel) obj).ttid);
    }

    public int hashCode() {
        return this.ttid.hashCode();
    }
}
