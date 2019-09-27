package com.introvd.template.app.p181e;

import android.content.Context;
import android.widget.Toast;

/* renamed from: com.introvd.template.app.e.b */
public class C3873b {
    private static Toast bql;

    public static void show(Context context, String str, int i) {
        show(context, str, i, 17);
    }

    public static void show(Context context, String str, int i, int i2) {
        if (bql != null) {
            bql.cancel();
        }
        bql = Toast.makeText(context, str, i);
        bql.setGravity(i2, 0, 0);
        bql.show();
    }
}
