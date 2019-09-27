package com.introvd.template.editor.p251d;

import android.graphics.Bitmap;
import com.bumptech.glide.C2215i;
import com.bumptech.glide.load.C2267a;
import com.bumptech.glide.load.p116a.C2278d;
import com.bumptech.glide.load.p116a.C2278d.C2279a;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.editor.preview.clipsort.C6562b;
import com.introvd.template.sdk.utils.p394b.C8537n;
import com.introvd.template.sdk.utils.p394b.C8540q;
import xiaoying.engine.clip.QClip;
import xiaoying.engine.storyboard.QStoryboard;

/* renamed from: com.introvd.template.editor.d.a */
public class C5872a implements C2278d<Bitmap> {
    private final C6562b cUE;

    public C5872a(C6562b bVar) {
        this.cUE = bVar;
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
        if (this.cUE != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("GlideV4 mClipThumbParams = ");
            sb.append(this.cUE);
            sb.append(",getSignature=");
            sb.append(this.cUE.mo29880so());
            LogUtilsV2.m14227d(sb.toString());
            int i = this.cUE.clipIndex;
            QStoryboard qStoryboard = (QStoryboard) this.cUE.daM.get();
            if (qStoryboard != null) {
                Bitmap bitmap = null;
                if (i >= 0) {
                    QClip i2 = C8540q.m24956i(qStoryboard, i);
                    if (i2 != null) {
                        bitmap = C8537n.m24831j(i2);
                    }
                }
                aVar.onDataReady(bitmap);
            }
        }
    }
}
