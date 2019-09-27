package com.introvd.template.editor.effects.music;

import android.content.Context;
import android.widget.Toast;

/* renamed from: com.introvd.template.editor.effects.music.c */
public class C6182c {
    private static Toast bql;

    /* renamed from: a */
    public static void m17709a(Context context, int i, int i2, int i3) {
        if (bql != null) {
            bql.cancel();
        }
        bql = Toast.makeText(context, i, i2);
        bql.setGravity(i3, 0, 0);
        bql.show();
    }

    public static void show(Context context, int i, int i2) {
        m17709a(context, i, i2, 17);
    }
}
