package com.introvd.template.common.p236ui.emoji;

import java.io.Serializable;

/* renamed from: com.introvd.template.common.ui.emoji.Emojicon */
public class Emojicon implements Serializable {
    private static final long serialVersionUID = 1;
    private boolean chA;
    private String chz;
    private int icon;

    private Emojicon() {
    }

    public static Emojicon formResource(int i, boolean z) {
        Emojicon emojicon = new Emojicon();
        emojicon.icon = i;
        emojicon.chA = z;
        return emojicon;
    }

    public static Emojicon fromChar(char c) {
        Emojicon emojicon = new Emojicon();
        emojicon.chz = Character.toString(c);
        return emojicon;
    }

    public static Emojicon fromChars(String str) {
        Emojicon emojicon = new Emojicon();
        emojicon.chz = str;
        return emojicon;
    }

    public static Emojicon fromCodePoint(int i) {
        Emojicon emojicon = new Emojicon();
        emojicon.chz = newString(i);
        return emojicon;
    }

    public static final String newString(int i) {
        return Character.charCount(i) == 1 ? String.valueOf(i) : new String(Character.toChars(i));
    }

    public boolean equals(Object obj) {
        return (obj instanceof Emojicon) && this.chz.equals(((Emojicon) obj).chz);
    }

    public String getEmoji() {
        return this.chz;
    }

    public int getIcon() {
        return this.icon;
    }

    public int hashCode() {
        return this.chz.hashCode();
    }

    public boolean isDelBtn() {
        return this.chA;
    }
}
