package com.introvd.template.editor.videotrim.p288b;

import android.annotation.SuppressLint;
import android.content.Context;
import com.introvd.template.VivaBaseApplication;
import com.introvd.template.common.ToastUtils;
import com.introvd.template.editor.R;
import com.introvd.template.editor.common.p247a.C5839a;
import com.introvd.template.sdk.editor.cache.TrimedClipItemDataModel;
import com.introvd.template.sdk.model.VeRange;
import com.introvd.template.sdk.model.editor.VideoExportParamsModel;
import com.introvd.template.sdk.utils.C8481a;
import com.introvd.template.sdk.utils.C8572y;
import com.introvd.template.sdk.utils.VeMSize;
import com.introvd.template.sdk.utils.p394b.C8540q;
import com.introvd.template.sdk.utils.p394b.C8541r;
import com.introvd.template.sdk.utils.p394b.p395a.C8508c;
import com.introvd.template.sdk.utils.p394b.p395a.C8510e;
import com.introvd.template.sdk.utils.p394b.p395a.C8512f;
import com.introvd.template.sdk.utils.p394b.p395a.C8516i;
import java.util.List;
import xiaoying.engine.QEngine;
import xiaoying.engine.base.QRange;
import xiaoying.engine.clip.QClip;
import xiaoying.engine.storyboard.QStoryboard;

@SuppressLint({"UseValueOf"})
/* renamed from: com.introvd.template.editor.videotrim.b.d */
public class C6963d {
    /* access modifiers changed from: private */
    public final QEngine bPS;
    private QStoryboard cFJ;
    private C8512f dcs = new C8512f() {
        public void ama() {
            if (C6963d.this.dpA != null) {
                C6963d.this.dpA.mo29356aV(C6963d.this.dpx);
            }
        }

        public void amb() {
            if (C6963d.this.dpA != null) {
                C6963d.this.dpA.amb();
            }
        }

        /* renamed from: av */
        public void mo29115av(float f) {
            int i = (int) f;
            if (C6963d.this.dpE) {
                i = C6963d.this.m20347pW(i);
            }
            if (C6963d.this.dpA != null) {
                C6963d.this.dpA.onProgress(i);
            }
        }

        /* renamed from: hM */
        public void mo29116hM(String str) {
            C8481a.m24576av(C6963d.this.mContext, str);
            if (C6963d.this.bPS != null) {
                C8481a.m24575a(C6963d.this.mContext, str, C8541r.m24979e(C6963d.this.bPS, str));
            }
            if (C6963d.this.dpz >= 0 && C6963d.this.dpz < C6963d.this.dpx.size()) {
                TrimedClipItemDataModel trimedClipItemDataModel = (TrimedClipItemDataModel) C6963d.this.dpx.get(C6963d.this.dpz);
                if (trimedClipItemDataModel != null) {
                    trimedClipItemDataModel.mExportPath = str;
                    trimedClipItemDataModel.isExported = Boolean.valueOf(true);
                }
                if (C6963d.this.dpA != null) {
                    C6963d.this.dpA.mo29360d(trimedClipItemDataModel);
                }
            }
            C6963d.this.dpz = C6963d.this.dpz + 1;
            if (C6963d.this.dkU != null) {
                C6963d.this.dkU.stop();
            }
            C6963d.this.auw();
            C6963d.this.dkU = new C8510e(C6963d.this.bPS, new C8516i(Long.valueOf(0)));
            if (!C6963d.this.auv() && C6963d.this.dpA != null) {
                C6963d.this.dpA.mo29355aU(C6963d.this.dpx);
            }
        }

        /* renamed from: n */
        public void mo29117n(int i, String str) {
            if (i == 11 && C6963d.this.mContext != null) {
                ToastUtils.show(C6963d.this.mContext, R.string.xiaoying_str_com_msg_low_diskspace_warning, 0);
            }
            if (C6963d.this.dpz >= 0 && C6963d.this.dpz < C6963d.this.dpx.size()) {
                TrimedClipItemDataModel trimedClipItemDataModel = (TrimedClipItemDataModel) C6963d.this.dpx.get(C6963d.this.dpz);
                if (C6963d.this.dpA != null) {
                    C6963d.this.dpA.mo29359c(trimedClipItemDataModel);
                }
            }
            if (!C6963d.this.dpD) {
                if (!C6963d.this.auv() && C6963d.this.dpA != null) {
                    C6963d.this.dpA.mo29355aU(C6963d.this.dpx);
                }
            } else if (C6963d.this.dpA != null) {
                C6962c e = C6963d.this.dpA;
                List d = C6963d.this.dpx;
                StringBuilder sb = new StringBuilder();
                sb.append("nErrCode:");
                sb.append(i);
                sb.append(";errMsg");
                sb.append(str);
                e.mo29361d(d, sb.toString());
            }
        }
    };
    /* access modifiers changed from: private */
    public volatile C8510e dkU;
    /* access modifiers changed from: private */
    public C6962c dpA;
    private int dpB = 0;
    private final String dpC;
    public boolean dpD = true;
    public boolean dpE = true;
    /* access modifiers changed from: private */
    public List<TrimedClipItemDataModel> dpx;
    /* access modifiers changed from: private */
    public int dpz = -1;
    /* access modifiers changed from: private */
    public Context mContext;

    public C6963d(Context context, List<TrimedClipItemDataModel> list, QEngine qEngine, String str) {
        this.mContext = context;
        this.dpx = list;
        this.bPS = qEngine;
        this.dpC = str;
    }

    /* access modifiers changed from: private */
    public boolean auv() {
        if (this.dpz < 0 || this.dpz >= this.dpx.size()) {
            return false;
        }
        TrimedClipItemDataModel trimedClipItemDataModel = (TrimedClipItemDataModel) this.dpx.get(this.dpz);
        if (trimedClipItemDataModel == null) {
            this.dpz++;
            return auv();
        }
        VeMSize veMSize = trimedClipItemDataModel.mStreamSizeVe;
        if (veMSize == null || veMSize.width <= 0 || veMSize.height <= 0) {
            this.dpz++;
            return auv();
        }
        this.cFJ = C8572y.m25069a(this.bPS, trimedClipItemDataModel);
        if (this.cFJ == null) {
            this.dpz++;
            return auv();
        } else if (this.cFJ.getClipCount() == 0) {
            this.dpz++;
            return auv();
        } else {
            QClip clip = this.cFJ.getClip(0);
            if (clip == null) {
                this.dpz++;
                return auv();
            }
            if (trimedClipItemDataModel.mRotate.intValue() > 0) {
                clip.setProperty(12315, Integer.valueOf(trimedClipItemDataModel.mRotate.intValue()));
                if (trimedClipItemDataModel.mRotate.intValue() % 360 == 90 || trimedClipItemDataModel.mRotate.intValue() % 360 == 270) {
                    int i = veMSize.width;
                    veMSize.width = veMSize.height;
                    veMSize.height = i;
                }
            }
            C8540q.m24935a(this.cFJ, new VeMSize(veMSize.width, veMSize.height));
            VeRange veRange = trimedClipItemDataModel.mVeRangeInRawVideo;
            int i2 = veRange.getmPosition();
            int i3 = veRange.getmTimeLength();
            QRange qRange = new QRange();
            if (i2 < 0) {
                C5839a.m16330eA(VivaBaseApplication.m8749FZ());
                i2 = 0;
            }
            qRange.set(0, i2);
            qRange.set(1, i3);
            if (clip.setProperty(12292, qRange) != 0) {
                this.dpz++;
                return auv();
            }
            this.dkU.mo34671a((C8508c) this.dcs);
            VideoExportParamsModel videoExportParamsModel = new VideoExportParamsModel();
            videoExportParamsModel.mPrjPath = trimedClipItemDataModel.mRawFilePath;
            videoExportParamsModel.encodeType = C8572y.aJm();
            videoExportParamsModel.decodeType = C8572y.aJl();
            StringBuilder sb = new StringBuilder();
            sb.append("xiaoying_importvideo_");
            sb.append(System.currentTimeMillis());
            if (this.dkU.mo34692a(C8572y.m25097ou(this.dpC), sb.toString(), this.cFJ, veMSize, trimedClipItemDataModel.mEncType, videoExportParamsModel) != 0) {
                this.dpz++;
                return auv();
            }
            if (this.dpA != null) {
                this.dpA.mo29358b(trimedClipItemDataModel);
            }
            return true;
        }
    }

    /* access modifiers changed from: private */
    public void auw() {
        if (this.cFJ != null) {
            this.cFJ.unInit();
            this.cFJ = null;
        }
    }

    private int aux() {
        int i = 0;
        for (int i2 = 0; i2 < this.dpx.size(); i2++) {
            TrimedClipItemDataModel trimedClipItemDataModel = (TrimedClipItemDataModel) this.dpx.get(i2);
            if (trimedClipItemDataModel != null) {
                VeRange veRange = trimedClipItemDataModel.mVeRangeInRawVideo;
                if (veRange != null) {
                    i += veRange.getmTimeLength();
                }
            }
        }
        return i;
    }

    /* access modifiers changed from: private */
    /* renamed from: pW */
    public int m20347pW(int i) {
        if (this.dpx == null) {
            return 0;
        }
        if (this.dpB <= 0) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.dpx.size(); i3++) {
            if (this.dpz > i3) {
                TrimedClipItemDataModel trimedClipItemDataModel = (TrimedClipItemDataModel) this.dpx.get(i3);
                if (trimedClipItemDataModel != null) {
                    VeRange veRange = trimedClipItemDataModel.mVeRangeInRawVideo;
                    if (veRange != null) {
                        i2 = (int) (((float) i2) + ((((float) veRange.getmTimeLength()) * 100.0f) / ((float) this.dpB)));
                    }
                }
            }
        }
        return (int) (((float) i2) + (((float) (((int) ((((float) ((TrimedClipItemDataModel) this.dpx.get(this.dpz)).mVeRangeInRawVideo.getmTimeLength()) * 100.0f) / ((float) this.dpB))) * i)) / 100.0f));
    }

    /* renamed from: a */
    public void mo30626a(C6962c cVar) {
        this.dpA = cVar;
    }

    public void alW() {
        if (this.dkU != null) {
            this.dkU.cancel();
        }
    }

    public boolean auu() {
        if (this.mContext == null || this.dpx == null || this.dpx.size() <= 0) {
            return false;
        }
        C8516i iVar = new C8516i(Long.valueOf(0));
        this.dpB = aux();
        this.dkU = new C8510e(this.bPS, iVar);
        this.dpz = 0;
        boolean auv = auv();
        if (!auv) {
            ToastUtils.show(this.mContext, R.string.xiaoying_str_ve_msg_external_file_import_fail, 0);
        }
        return auv;
    }

    public void release() {
        if (this.dkU != null) {
            this.dkU.destroy();
            this.dkU = null;
        }
        auw();
    }
}
