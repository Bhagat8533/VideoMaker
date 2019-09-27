package com.introvd.template.editor.p251d;

import android.graphics.Bitmap;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import com.introvd.template.editor.effects.nav.C6184a;

/* renamed from: com.introvd.template.editor.d.f */
public class C5877f implements ModelLoaderFactory<C6184a, Bitmap> {
    public ModelLoader<C6184a, Bitmap> build(MultiModelLoaderFactory multiModelLoaderFactory) {
        return new C5876e();
    }

    public void teardown() {
    }
}
