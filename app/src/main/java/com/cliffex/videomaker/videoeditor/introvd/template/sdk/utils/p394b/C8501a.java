package com.introvd.template.sdk.utils.p394b;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import com.introvd.template.sdk.C8401d;
import com.introvd.template.sdk.utils.C8553i;
import com.introvd.template.sdk.utils.C8567u;
import lib.C12177i;
import xiaoying.engine.QEngine;
import xiaoying.engine.base.IQTemplateAdapter;
import xiaoying.engine.base.IQTextTransformer;
import xiaoying.engine.base.QUtils;
import xiaoying.utils.QPoint;

/* renamed from: com.introvd.template.sdk.utils.b.a */
public class C8501a {
    public static final Long ehF = Long.valueOf(504403158265495639L);
    private static C8501a ehG;
    private IQTemplateAdapter bPy = new C8521f();
    private volatile QEngine egh;
    private boolean ehH = false;
    private String ehI;

    private C8501a() {
    }

    public static synchronized C8501a aJs() {
        C8501a aVar;
        synchronized (C8501a.class) {
            if (ehG == null) {
                ehG = new C8501a();
            }
            aVar = ehG;
        }
        return aVar;
    }

    @SuppressLint({"UseValueOf"})
    private int aJt() {
        if (this.egh != null) {
            return 0;
        }
        if (!TextUtils.isEmpty(this.ehI)) {
            try {
                C8553i.m25005ut(23);
                this.egh = new QEngine();
                if (this.egh.create() != 0) {
                    return 3;
                }
                this.egh.setProperty(26, C8567u.egZ);
                this.egh.setProperty(27, C8567u.egY);
                this.egh.setProperty(7, Boolean.FALSE);
                this.egh.setProperty(6, Integer.valueOf(100));
                this.egh.setProperty(2, Integer.valueOf(2));
                this.egh.setProperty(3, Integer.valueOf(4));
                this.egh.setProperty(4, Integer.valueOf(2));
                this.egh.setProperty(5, Integer.valueOf(65537));
                this.egh.setProperty(1, C8401d.aGS());
                this.egh.setProperty(9, new QPoint(4096, QUtils.VIDEO_RES_4K_HEIGHT));
                this.egh.setProperty(19, Integer.valueOf(C12177i.f6157m));
                this.egh.setProperty(25, this.bPy);
                this.egh.setProperty(28, new C8520e(this.ehI));
                this.egh.setProperty(20, Integer.valueOf(0));
                this.egh.setProperty(30, ehF);
                StringBuilder sb = new StringBuilder();
                sb.append(C8401d.and());
                sb.append("ini/vivavideo_default_corrupt_image.png");
                this.egh.setProperty(35, sb.toString());
                StringBuilder sb2 = new StringBuilder();
                sb2.append(C8401d.and());
                sb2.append("ini/hw_codec_cap.xml");
                this.egh.setProperty(38, sb2.toString());
                return 0;
            } catch (Throwable unused) {
                return 1;
            }
        } else {
            throw new RuntimeException("AppContext init should run first! provide the appVerName");
        }
    }

    private void aJu() {
        try {
            if (this.egh != null) {
                this.egh.destory();
                this.egh = null;
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    public void mo34665a(IQTextTransformer iQTextTransformer) {
        if (this.egh != null) {
            this.egh.setProperty(34, iQTextTransformer);
        }
    }

    public QEngine aJv() {
        if (this.egh != null || aJt() == 0) {
            return this.egh;
        }
        aJu();
        return null;
    }

    /* renamed from: eg */
    public void mo34667eg(String str) {
        this.ehI = str;
    }

    public boolean isProjectModified() {
        return this.ehH;
    }

    /* renamed from: jt */
    public void mo34669jt(boolean z) {
        this.ehH = z;
    }

    public void unInit() {
        aJu();
    }
}
