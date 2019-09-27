package com.introvd.template.editor.p251d;

import android.graphics.Bitmap;
import com.bumptech.glide.load.C2505j;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoader.LoadData;
import com.bumptech.glide.p114f.C2212c;
import com.introvd.template.editor.effects.nav.C6184a;

/* renamed from: com.introvd.template.editor.d.e */
public class C5876e implements ModelLoader<C6184a, Bitmap> {
    /* renamed from: a */
    public LoadData<Bitmap> buildLoadData(C6184a aVar, int i, int i2, C2505j jVar) {
        return new LoadData<>(new C2212c(aVar.mo29004so()), new C5875d(aVar));
    }

    /* renamed from: a */
    public boolean handles(C6184a aVar) {
        return true;
    }
}
