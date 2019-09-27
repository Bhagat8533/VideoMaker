package com.introvd.template.common.utils;

import android.content.Context;
import android.graphics.Typeface;
import java.util.Hashtable;

public class Typefaces {
    private static final Hashtable<String, Typeface> ciP = new Hashtable<>();

    public static Typeface get(Context context, String str) {
        Typeface typeface;
        synchronized (ciP) {
            if (!ciP.containsKey(str)) {
                try {
                    Typeface createFromFile = Typeface.createFromFile(str);
                    if (createFromFile != null) {
                        ciP.put(str, createFromFile);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            typeface = (Typeface) ciP.get(str);
        }
        return typeface;
    }
}
