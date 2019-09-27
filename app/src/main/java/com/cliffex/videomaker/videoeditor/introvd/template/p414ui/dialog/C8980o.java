package com.introvd.template.p414ui.dialog;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.support.p021v4.util.SimpleArrayMap;

/* renamed from: com.introvd.template.ui.dialog.o */
public class C8980o {
    private static final SimpleArrayMap<String, Typeface> aoJ = new SimpleArrayMap<>();

    /* renamed from: d */
    public static Typeface m26351d(AssetManager assetManager, String str) {
        synchronized (aoJ) {
            if (!aoJ.containsKey(str)) {
                try {
                    Typeface createFromAsset = Typeface.createFromAsset(assetManager, String.format("fonts/%s", new Object[]{str}));
                    aoJ.put(str, createFromAsset);
                    return createFromAsset;
                } catch (RuntimeException unused) {
                    return null;
                }
            } else {
                Typeface typeface = (Typeface) aoJ.get(str);
                return typeface;
            }
        }
    }

    /* renamed from: qX */
    public static Typeface m26352qX(String str) {
        synchronized (aoJ) {
            if (!aoJ.containsKey(str)) {
                try {
                    Typeface create = Typeface.create(str, 0);
                    aoJ.put(str, create);
                    return create;
                } catch (RuntimeException unused) {
                    return null;
                }
            } else {
                Typeface typeface = (Typeface) aoJ.get(str);
                return typeface;
            }
        }
    }
}
