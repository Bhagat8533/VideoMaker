package com.introvd.template.editor.base;

import android.content.Context;
import android.os.Bundle;
import com.introvd.template.common.MSize;
import com.introvd.template.editor.common.C5852d;
import com.introvd.template.editor.p245b.C5655b;
import com.introvd.template.editor.p245b.C5675f;
import com.introvd.template.editor.player.p269b.C6499a;
import com.introvd.template.editor.service.StoryboardOpService;
import com.introvd.template.sdk.editor.C8420b;
import com.introvd.template.sdk.editor.cache.C8443d;
import com.introvd.template.sdk.model.editor.DataItemProject;
import com.introvd.template.sdk.model.editor.ProjectItem;
import com.introvd.template.sdk.utils.p394b.C8501a;
import com.introvd.template.sdk.utils.p394b.C8522g;
import xiaoying.engine.QEngine;
import xiaoying.engine.storyboard.QStoryboard;

/* renamed from: com.introvd.template.editor.base.a */
public class C5686a {
    private C5655b cyf;
    /* access modifiers changed from: protected */
    public C6499a cyg;

    /* renamed from: B */
    public void mo27845B(Bundle bundle) {
    }

    /* renamed from: H */
    public void mo27846H(int i, boolean z) {
        if (this.cyg != null) {
            this.cyg.mo29675H(i, z);
        }
    }

    /* renamed from: a */
    public MSize mo27847a(MSize mSize) {
        return this.cyf.mo27698a(mSize);
    }

    /* renamed from: a */
    public void mo27848a(C5655b bVar) {
        this.cyf = bVar;
    }

    /* renamed from: a */
    public void mo27849a(C6499a aVar) {
        this.cyg = aVar;
    }

    public C8522g adK() {
        return this.cyf.adK();
    }

    public C8501a adL() {
        return this.cyf.adL();
    }

    public ProjectItem adM() {
        return this.cyf.ahP();
    }

    public MSize adN() {
        return this.cyf.adN();
    }

    public QStoryboard adO() {
        return this.cyf.aia();
    }

    public QEngine adP() {
        return this.cyf.getEngine();
    }

    public C8443d adQ() {
        return this.cyf.ahY();
    }

    public C5675f adR() {
        return this.cyf.ahZ();
    }

    public C8420b adS() {
        return this.cyf.adS();
    }

    public void adT() {
        this.cyf.adT();
    }

    public boolean adU() {
        return this.cyf.adU();
    }

    public void adV() {
        this.cyf.ahV();
    }

    public boolean adW() {
        if (adK() == null || adK().aHe() == null) {
            return false;
        }
        return adK().aHe().isMVPrj();
    }

    public void adX() {
        if (this.cyg != null) {
            this.cyg.aoi();
        }
    }

    public void adY() {
        if (this.cyg != null) {
            this.cyg.aoh();
        }
    }

    public int adZ() {
        return C5852d.agW().agY();
    }

    public void aea() {
        if (this.cyg != null) {
            this.cyg.aea();
        }
    }

    public void aeb() {
        if (this.cyg != null) {
            this.cyg.aeb();
        }
    }

    /* renamed from: b */
    public void mo27868b(int i, int i2, boolean z, int i3) {
        if (this.cyg != null) {
            this.cyg.setPlayRange(i, i2, z, i3);
        }
    }

    /* renamed from: ep */
    public int mo27869ep(Context context) {
        if (adL().isProjectModified()) {
            DataItemProject aHe = adK().aHe();
            if (aHe != null) {
                StoryboardOpService.savePrj(context, aHe.strPrjURL);
            }
        }
        return 0;
    }

    /* renamed from: ep */
    public void mo27870ep(boolean z) {
        if (this.cyg != null) {
            this.cyg.mo29650ep(z);
        }
    }

    public MSize getStreamSize() {
        return this.cyf.getStreamSize();
    }

    public MSize getSurfaceSize() {
        return this.cyf.mo27698a(getStreamSize());
    }

    /* renamed from: h */
    public void mo27873h(int i, int i2, boolean z) {
        if (this.cyg != null) {
            this.cyg.setPlayRange(i, i2, z);
        }
    }

    /* renamed from: kY */
    public void mo27874kY(int i) {
        if (this.cyg != null) {
            this.cyg.mo29696kY(i);
        }
    }
}
