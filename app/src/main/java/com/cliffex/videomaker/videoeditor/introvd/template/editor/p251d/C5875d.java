package com.introvd.template.editor.p251d;

import android.graphics.Bitmap;
import com.bumptech.glide.C2215i;
import com.bumptech.glide.load.C2267a;
import com.bumptech.glide.load.p116a.C2278d;
import com.bumptech.glide.load.p116a.C2278d.C2279a;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.editor.effects.nav.C6184a;
import com.introvd.template.sdk.utils.p394b.C8501a;
import com.introvd.template.template.p409g.C8762d;

/* renamed from: com.introvd.template.editor.d.d */
public class C5875d implements C2278d<Bitmap> {
    private final C6184a cUF;

    public C5875d(C6184a aVar) {
        this.cUF = aVar;
    }

    public void cancel() {
    }

    public void cleanup() {
    }

    public Class<Bitmap> getDataClass() {
        return Bitmap.class;
    }

    public C2267a getDataSource() {
        return C2267a.LOCAL;
    }

    public void loadData(C2215i iVar, C2279a<? super Bitmap> aVar) {
        StringBuilder sb = new StringBuilder();
        sb.append("mEffectThumbParams = ");
        sb.append(this.cUF);
        sb.append(",getSignature=");
        sb.append(this.cUF.mo29004so());
        LogUtilsV2.m14227d(sb.toString());
        aVar.onDataReady(C8762d.aMt().mo35220a(C8762d.aMt().getTemplateID(this.cUF.mStylePath), this.cUF.cNf, this.cUF.cNg, C8501a.aJs().aJv()));
    }
}
