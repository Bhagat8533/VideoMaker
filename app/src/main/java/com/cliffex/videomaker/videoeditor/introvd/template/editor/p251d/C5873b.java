package com.introvd.template.editor.p251d;

import android.graphics.Bitmap;
import com.bumptech.glide.load.C2505j;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoader.LoadData;
import com.bumptech.glide.p114f.C2212c;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.editor.preview.clipsort.C6562b;

/* renamed from: com.introvd.template.editor.d.b */
public class C5873b implements ModelLoader<C6562b, Bitmap> {
    /* renamed from: a */
    public LoadData<Bitmap> buildLoadData(C6562b bVar, int i, int i2, C2505j jVar) {
        return new LoadData<>(new C2212c(bVar.mo29880so()), new C5872a(bVar));
    }

    /* renamed from: a */
    public boolean handles(C6562b bVar) {
        LogUtilsV2.m14227d("GlideV4 handles");
        return true;
    }
}
