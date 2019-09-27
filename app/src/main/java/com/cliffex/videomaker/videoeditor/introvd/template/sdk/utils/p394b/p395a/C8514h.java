package com.introvd.template.sdk.utils.p394b.p395a;

import android.content.Context;
import com.introvd.template.sdk.editor.cache.TrimedClipItemDataModel;
import com.introvd.template.sdk.model.VeRange;
import com.introvd.template.sdk.model.editor.VideoExportParamsModel;
import com.introvd.template.sdk.utils.C8548e;
import com.introvd.template.sdk.utils.C8572y;
import com.introvd.template.sdk.utils.VeMSize;
import xiaoying.engine.QEngine;
import xiaoying.engine.base.QRange;
import xiaoying.engine.storyboard.QStoryboard;

/* renamed from: com.introvd.template.sdk.utils.b.a.h */
public class C8514h {
    private static final String TAG = "h";
    private final QEngine bPS;
    private QStoryboard cFJ;
    private C8512f dcs = new C8512f() {
        public void ama() {
            super.ama();
            if (C8514h.this.eiN != null) {
                C8514h.this.eiN.avZ();
            }
        }

        public void amb() {
            super.amb();
            if (C8514h.this.eiN != null) {
                C8514h.this.eiN.amb();
            }
        }

        public void apX() {
            super.apX();
        }

        /* renamed from: av */
        public void mo29115av(float f) {
            super.mo29115av(f);
            if (C8514h.this.eiN != null) {
                C8514h.this.eiN.onProgress((int) f);
            }
        }

        /* renamed from: hM */
        public void mo29116hM(String str) {
            super.mo29116hM(str);
            if (C8514h.this.eiN != null) {
                C8514h.this.eiN.mo31701iY(str);
            }
        }

        /* renamed from: n */
        public void mo29117n(int i, String str) {
            super.mo29117n(i, str);
            if (C8514h.this.eiN != null) {
                C8514h.this.eiN.mo31704qx(i);
            }
        }
    };
    private volatile C8510e dkU;
    private String dpC;
    private TrimedClipItemDataModel eiM;
    /* access modifiers changed from: private */
    public C8513g eiN;
    private Context mContext;

    public C8514h(Context context, QEngine qEngine, String str) {
        this.mContext = context;
        this.bPS = qEngine;
        this.dpC = str;
    }

    private void aJY() {
        if (this.dkU == null) {
            this.dkU = new C8510e(this.bPS, new C8516i(Long.valueOf(0)));
        }
        this.dkU.mo34671a((C8508c) this.dcs);
    }

    /* renamed from: uA */
    private void m24637uA(int i) {
        if (this.eiN != null) {
            this.eiN.mo31704qx(i);
        }
    }

    /* renamed from: a */
    public void mo34696a(C8513g gVar) {
        this.eiN = gVar;
    }

    public void init() {
        aJY();
    }

    /* renamed from: q */
    public void mo34698q(TrimedClipItemDataModel trimedClipItemDataModel) {
        if (this.mContext != null && trimedClipItemDataModel != null) {
            this.eiM = trimedClipItemDataModel;
            VeMSize veMSize = this.eiM.mStreamSizeVe;
            if (veMSize.width > 0 && veMSize.height > 0) {
                this.cFJ = C8572y.m25069a(this.bPS, this.eiM);
                if (this.cFJ == null || this.cFJ.getClipCount() == 0 || this.cFJ.getClip(0) == null) {
                    m24637uA(0);
                    return;
                }
                VeRange veRange = trimedClipItemDataModel.mVeRangeInRawVideo;
                int i = veRange.getmPosition();
                int i2 = veRange.getmTimeLength();
                QRange qRange = new QRange();
                if (i < 0) {
                    i = 0;
                }
                qRange.set(0, i);
                qRange.set(1, i2);
                int property = this.cFJ.getClip(0).setProperty(12292, qRange);
                if (property != 0) {
                    m24637uA(property);
                    return;
                }
                VideoExportParamsModel videoExportParamsModel = new VideoExportParamsModel();
                videoExportParamsModel.mPrjPath = this.eiM.mRawFilePath;
                videoExportParamsModel.encodeType = C8572y.aJm();
                videoExportParamsModel.decodeType = C8572y.aJl();
                videoExportParamsModel.expType = Integer.valueOf(6);
                int a = this.dkU.mo34692a(C8572y.m25097ou(this.dpC), C8548e.getFileName(trimedClipItemDataModel.mRawFilePath), this.cFJ, veMSize, this.eiM.mEncType, videoExportParamsModel);
                if (a != 0) {
                    m24637uA(a);
                    return;
                }
                if (this.eiN != null) {
                    this.eiN.avY();
                }
            }
        }
    }
}
