package com.introvd.template;

import android.content.Context;
import android.content.ContextWrapper;
import com.google.android.exoplayer2.util.MimeTypes;

/* renamed from: com.introvd.template.c */
public class C4611c extends ContextWrapper {
    C4611c(Context context) {
        super(context);
    }

    /* renamed from: bn */
    public static ContextWrapper m11758bn(Context context) {
        return new C4611c(context);
    }

    public Object getSystemService(String str) {
        return MimeTypes.BASE_TYPE_AUDIO.equals(str) ? getApplicationContext().getSystemService(str) : super.getSystemService(str);
    }
}
