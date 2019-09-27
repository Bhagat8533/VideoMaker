package com.introvd.template.editor.p251d;

import android.graphics.Bitmap;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.editor.preview.clipsort.C6562b;

/* renamed from: com.introvd.template.editor.d.c */
public class C5874c implements ModelLoaderFactory<C6562b, Bitmap> {
    public ModelLoader<C6562b, Bitmap> build(MultiModelLoaderFactory multiModelLoaderFactory) {
        return new C5873b();
    }

    public void teardown() {
        LogUtilsV2.m14227d("GlideV4 teardown");
    }
}
