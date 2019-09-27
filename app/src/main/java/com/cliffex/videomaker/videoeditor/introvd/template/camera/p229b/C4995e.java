package com.introvd.template.camera.p229b;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.introvd.template.camera.CameraActivity;
import com.introvd.template.camera.model.PipInfo;
import com.introvd.template.camera.model.PipSourceItem;
import com.introvd.template.camera.model.SaveRequest;
import com.introvd.template.camera.p229b.C5006h.C5007a;
import com.introvd.template.camera.p232e.C5034e;
import com.introvd.template.common.LogUtils;
import com.introvd.template.common.model.AppStateModel;
import com.introvd.template.router.camera.CameraCodeMgr;
import com.introvd.template.router.editor.gallery.GalleryRouter;
import com.introvd.template.sdk.editor.cache.TrimedClipItemDataModel;
import com.introvd.template.sdk.model.editor.DataItemProject;
import com.introvd.template.sdk.model.editor.DataPIPIItem;
import com.introvd.template.sdk.model.editor.EffectInfoModel;
import com.introvd.template.sdk.model.editor.ProjectItem;
import com.introvd.template.sdk.utils.C8562q;
import com.introvd.template.sdk.utils.p394b.C8521f;
import com.introvd.template.sdk.utils.p394b.C8522g;
import com.introvd.template.sdk.utils.p394b.C8537n;
import com.introvd.template.template.p409g.C8759b;
import com.mediarecorder.engine.QPIPFrameParam;
import com.mediarecorder.engine.QPIPSource;
import com.mediarecorder.engine.QPIPSourceMode;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import xiaoying.engine.base.IQTemplateAdapter;
import xiaoying.engine.base.QUtils;
import xiaoying.engine.clip.QClip;
import xiaoying.engine.clip.QSceneClip;
import xiaoying.engine.storyboard.QStoryboard;
import xiaoying.utils.QRect;

/* renamed from: com.introvd.template.camera.b.e */
public class C4995e {
    private boolean bPA = false;
    private TrimedClipItemDataModel bPB;
    private int bPC = 0;
    private QPIPSource[] bPD = new QPIPSource[2];
    private long bPE = -1;
    private int bPF;
    private CameraActivity bPs;
    private int bPt = 0;
    private C8759b bPu;
    private int bPv = 0;
    private QPIPFrameParam bPw;
    private C5006h bPx;
    private IQTemplateAdapter bPy = new C8521f();
    private boolean bPz = true;
    private QPIPSourceMode mQpipSourceMode = new QPIPSourceMode();

    public C4995e(CameraActivity cameraActivity) {
        this.bPs = cameraActivity;
    }

    /* renamed from: Vl */
    private void m12791Vl() {
        if (this.mQpipSourceMode.srcIdx != -1) {
            this.bPF = this.bPs.bMO.mo25472iS((this.mQpipSourceMode.srcIdx + 1) % 2);
            int VO = C5006h.m12925VO();
            int state = C5008i.m12937VU().getState();
            if (-1 != VO && state != 2 && C5006h.m12926jf(VO) == 0) {
                this.bPF = 0;
            }
        }
    }

    /* renamed from: Vn */
    private void m12792Vn() {
        C5008i.m12937VU().mo25642cR(this.bPx.mo25598VR());
        C5008i.m12937VU().mo25640cP(this.bPx.mo25600VT());
        C5008i.m12937VU().mo25641cQ(this.bPx.mo25599VS());
        C5008i.m12937VU().mo25658jm(this.bPx.mo25596VP());
    }

    /* renamed from: Vs */
    private void m12793Vs() {
        if (this.bPx != null && this.bPs.bMO != null) {
            this.bPC = C5034e.m13259d(this.bPs.bMM);
            int VP = this.bPx.mo25596VP();
            int i = 0;
            if (-1 != VP) {
                i = this.bPs.bMO.mo25472iS(VP);
            }
            mo25500ah((long) (this.bPC + i + this.bPs.bMO.mo25472iS(this.bPv)));
            if (C5008i.m12937VU().getDurationLimit() != 0) {
                mo25490Vr();
            }
        }
    }

    /* renamed from: Vt */
    private void m12794Vt() {
        this.bPs.bMN.mo25693jj(C5008i.m12937VU().getClipCount());
    }

    /* renamed from: a */
    private QRect m12795a(QPIPFrameParam qPIPFrameParam, int i) {
        boolean z = false;
        QRect qRect = new QRect(0, 0, 10000, 10000);
        if (this.bPs.bOJ == null || this.bPs.bOJ.mo25524Vx() == null) {
            return qRect;
        }
        QRect elementDisplayRegion = this.bPw.getElementDisplayRegion(i);
        boolean z2 = this.bPs.bOI;
        QRect a = C8562q.m25043a(elementDisplayRegion, 0, 10000, 10000);
        int elementSourceAlignment = this.bPw.getElementSourceAlignment(i);
        QRect qRect2 = new QRect(0, 0, 10000, 10000);
        if (a == null) {
            a = new QRect(0, 0, 10000, 10000);
        }
        if (elementSourceAlignment == 96) {
            z = true;
        }
        if (z) {
            a = m12797a(a, qRect2, true);
        }
        return a;
    }

    /* renamed from: a */
    private QRect m12796a(QSceneClip qSceneClip, int i) {
        QRect qRect = new QRect(0, 0, 10000, 10000);
        QStoryboard qStoryboard = new QStoryboard();
        if (qSceneClip.getElementSource(i, qStoryboard) != 0) {
            return qRect;
        }
        QClip dataClip = qStoryboard.getDataClip();
        return dataClip == null ? qRect : (QRect) dataClip.getProperty(12314);
    }

    /* renamed from: a */
    private QRect m12797a(QRect qRect, QRect qRect2, boolean z) {
        QRect qRect3 = new QRect();
        int i = qRect2.right - qRect2.left;
        int i2 = qRect2.bottom - qRect2.top;
        int i3 = qRect.right - qRect.left;
        int i4 = qRect.bottom - qRect.top;
        int i5 = i * i4;
        int i6 = i2 * i3;
        if (i5 < i6) {
            int i7 = i5 / i3;
            qRect3.left = 0;
            qRect3.right = i;
            if (z) {
                qRect3.top = (i2 - i7) / 2;
                qRect3.bottom = qRect3.top + i7;
            } else if (qRect.top + i7 > i2) {
                qRect3.bottom = i2;
                qRect3.top = i2 - i7;
            } else {
                qRect3.bottom = qRect.top + i7;
                qRect3.top = qRect.top;
            }
        } else if (i5 < i6) {
            int i8 = i6 / i4;
            qRect3.top = 0;
            qRect3.bottom = i2;
            if (z) {
                qRect3.left = (i - i8) / 2;
                qRect3.right = qRect3.left + i8;
            } else if (qRect.left + i8 > i) {
                qRect3.right = i;
                qRect3.left = i - i8;
            } else {
                qRect3.right = qRect.left + i8;
                qRect3.left = qRect.left;
            }
        } else {
            qRect3.left = qRect2.left;
            qRect3.right = qRect2.right;
            qRect3.bottom = qRect2.bottom;
            qRect3.top = qRect2.top;
        }
        return qRect3;
    }

    /* renamed from: a */
    private void m12798a(C8522g gVar) {
        if (gVar != null) {
            DataItemProject aHe = gVar.aHe();
            if (aHe == null || !aHe.isCameraPipMode()) {
                mo25508iV(this.bPt);
            } else {
                ProjectItem ahP = gVar.aHf();
                if (ahP == null || ahP.mProjectDataItem == null || ahP.mProjectDataItem.strExtra == null) {
                    mo25508iV(this.bPt);
                } else {
                    PipInfo pipExtraInfo = PipInfo.getPipExtraInfo(ahP.mProjectDataItem.strExtra);
                    QStoryboard aHd = gVar.aHd();
                    if (aHd == null) {
                        mo25508iV(this.bPt);
                        return;
                    }
                    QClip clip = aHd.getClip(aHd.getClipCount() - 1);
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    int i = pipExtraInfo.mCurrentIndex;
                    int size = pipExtraInfo.mSequence.size();
                    if (size > 0) {
                        int intValue = ((Integer) pipExtraInfo.mSequence.get(size - 1)).intValue();
                        QRect qRect = null;
                        int i2 = -1;
                        ArrayList arrayList3 = arrayList2;
                        ArrayList arrayList4 = arrayList;
                        for (int i3 = 0; i3 < size; i3++) {
                            int intValue2 = ((Integer) pipExtraInfo.mSequence.get(i3)).intValue();
                            if (clip instanceof QSceneClip) {
                                if (size >= 1 && i3 == 0) {
                                    qRect = m12796a((QSceneClip) clip, intValue2);
                                    i2 = intValue2;
                                }
                                if (i3 == 0) {
                                    arrayList4 = C8537n.m24815b((QSceneClip) clip, intValue2);
                                } else if (i3 == 1) {
                                    arrayList3 = C8537n.m24815b((QSceneClip) clip, intValue2);
                                }
                            }
                        }
                        this.bPs.mo24900Ts();
                        this.bPs.mClipCount = C5034e.m13251b(gVar);
                        this.bPt = this.bPu.mo35205bx(pipExtraInfo.mTemplateId);
                        for (int i4 = 0; i4 < arrayList4.size(); i4++) {
                            mo25497a((TrimedClipItemDataModel) arrayList4.get(i4), ((Integer) pipExtraInfo.mSequence.get(0)).intValue());
                        }
                        for (int i5 = 0; i5 < arrayList3.size(); i5++) {
                            mo25497a((TrimedClipItemDataModel) arrayList3.get(i5), ((Integer) pipExtraInfo.mSequence.get(1)).intValue());
                        }
                        int intValue3 = ((Integer) pipExtraInfo.mSequence.get(0)).intValue();
                        if (i == intValue3 || this.bPs.bMO == null) {
                            mo25502bW(this.bPt, intValue);
                        } else {
                            mo25507h(this.bPs.bMO.mo25470iQ(intValue3), i);
                        }
                        if (!(-1 == i2 || qRect == null)) {
                            mo25494a(i2, qRect);
                        }
                    } else {
                        mo25502bW(this.bPt, 0);
                    }
                    m12793Vs();
                }
                this.bPs.bMN.mo25670Uj();
            }
        }
    }

    /* renamed from: a */
    private void m12799a(QPIPSource[] qPIPSourceArr) {
        int i = 0;
        for (int i2 = 0; i2 < qPIPSourceArr.length; i2++) {
            QPIPSource qPIPSource = qPIPSourceArr[i2];
            qPIPSource.idx = i2;
            this.bPw.setElementSource(i2, qPIPSource);
        }
        C4996f fVar = this.bPs.bOJ;
        QPIPFrameParam qPIPFrameParam = this.bPw;
        if (this.bPF > 100) {
            i = this.bPF - 100;
        }
        fVar.mo25532b(qPIPFrameParam, i);
    }

    /* renamed from: iU */
    private void m12800iU(int i) {
        this.bPw = new QPIPFrameParam();
        EffectInfoModel vh = this.bPu.mo35214vh(i);
        if (vh != null) {
            if (this.bPs.bOI) {
                this.bPw.init(this.bPy, vh.mTemplateId, 480, 480, 0);
            } else {
                this.bPw.init(this.bPy, vh.mTemplateId, QUtils.VIDEO_RES_VGA_WIDTH, 360, 0);
            }
            C5008i.m12937VU().mo25631a(this.bPw);
        }
    }

    /* renamed from: Td */
    public void mo25481Td() {
        if (this.mQpipSourceMode.srcIdx == -1 || !CameraCodeMgr.isCameraParamPIP(this.bPs.bOz)) {
            this.bPs.bOJ.mo25548cy(false);
            return;
        }
        this.mQpipSourceMode.isSingleFrame = false;
        int i = (this.mQpipSourceMode.srcIdx + 1) % 2;
        this.mQpipSourceMode.timeStamp = this.bPs.bMO.mo25472iS(i);
        this.bPs.bOJ.mo25531a(false, this.mQpipSourceMode);
    }

    /* renamed from: Tg */
    public void mo25482Tg() {
        this.bPs.bOJ.mo25538cA(true);
    }

    /* renamed from: UC */
    public void mo25483UC() {
        if (this.bPs != null && this.bPs.bMO != null) {
            this.bPz = false;
            this.mQpipSourceMode.srcIdx = this.bPv;
            this.bPs.mo24894SV();
            this.bPv = (this.bPv + 1) % 2;
            mo25507h(this.bPs.bMO.mo25470iQ((this.bPv + 1) % 2), this.bPv);
            this.bPz = true;
            m12793Vs();
            this.bPs.bMN.mo25668UC();
        }
    }

    /* renamed from: UD */
    public void mo25484UD() {
        this.bPv = (this.bPv + 1) % 2;
        this.bPx.mo25602a(this.bPv, C5007a.REAL_CAMERA);
        this.bPx.mo25602a((this.bPv + 1) % 2, C5007a.UN_REAL_CAMERA);
        mo25486Vm();
        this.bPs.bMN.mo25669UD();
        m12793Vs();
    }

    /* renamed from: Ve */
    public void mo25485Ve() {
        if (this.bPx != null && this.bPs.bMO != null) {
            this.bPv = (this.bPv + 1) % 2;
            this.bPx.mo25601Ve();
            this.bPs.bMO.mo25465Ve();
            mo25486Vm();
        }
    }

    /* renamed from: Vm */
    public void mo25486Vm() {
        m12800iU(this.bPt);
        int elementCount = this.bPx.getElementCount();
        int i = -1;
        int i2 = -1;
        for (int i3 = 0; i3 < elementCount; i3++) {
            QPIPSource qPIPSource = null;
            PipSourceItem jd = this.bPx.mo25606jd(i3);
            if (jd.dataType == C5007a.REAL_CAMERA) {
                qPIPSource = new QPIPSource();
                qPIPSource.setType(2);
                qPIPSource.setRotation(0);
                qPIPSource.setCropRegion(m12795a(this.bPw, i3));
                i2 = i3;
            } else if (jd.dataType == C5007a.UN_REAL_CAMERA) {
                qPIPSource = new QPIPSource();
                qPIPSource.setType(2);
                qPIPSource.setRotation(0);
                qPIPSource.setCropRegion(m12795a(this.bPw, i3));
                qPIPSource.setShaderOpacity(70);
                i = i3;
            } else if (jd.dataType == C5007a.STORYBOARD) {
                qPIPSource = new QPIPSource();
                qPIPSource.setType(3);
                qPIPSource.setSrc(C5020n.m13115a(this.bPs.bOK, this.bPs.bMM.aHf(), this.bPs.bMO.mo25470iQ(i3)));
                qPIPSource.setCropRegion(m12795a(this.bPw, i3));
            }
            this.bPD[i3] = qPIPSource;
        }
        m12799a(this.bPD);
        this.mQpipSourceMode.srcIdx = this.bPx.mo25596VP();
        m12792Vn();
        this.bPs.bMN.mo25670Uj();
        this.bPs.bMN.mo25684a(i, this.bPw);
        this.bPs.bON.mo25778b(i2, this.bPw);
        m12794Vt();
        this.bPs.mo24899Tr();
    }

    /* renamed from: Vo */
    public void mo25487Vo() {
        if (CameraCodeMgr.isCameraParamPIP(this.bPs.bOz)) {
            this.bPz = false;
        }
        this.bPs.bOG = true;
        this.bPs.mo24894SV();
        this.bPz = true;
    }

    /* renamed from: Vp */
    public void mo25488Vp() {
        if (-1 == this.bPx.mo25596VP()) {
            mo25483UC();
        }
    }

    /* renamed from: Vq */
    public void mo25489Vq() {
        if (this.bPs.bMO != null && !this.bPs.bMO.mo25463Vc() && this.bPs.mClipCount > 0) {
            List iQ = this.bPs.bMO.mo25470iQ(0);
            iQ.addAll(this.bPs.bMO.mo25470iQ(1));
            for (int i = 0; i < iQ.size(); i++) {
                SaveRequest saveRequest = (SaveRequest) iQ.get(i);
                this.bPs.mClipCount--;
                int i2 = saveRequest.endPos - saveRequest.startPos;
                CameraActivity cameraActivity = this.bPs;
                cameraActivity.bOF = (int) (((long) cameraActivity.bOF) - C5034e.m13252b(this.bPs.bOx, (long) i2));
            }
            this.bPs.bMO.mo25464Vd();
            if (C5008i.m12937VU().getDurationLimit() != 0) {
                mo25490Vr();
                this.bPs.bMN.mo25666UA();
            }
        }
    }

    /* renamed from: Vr */
    public void mo25490Vr() {
        this.bPz = false;
        this.bPs.mo24894SV();
        this.bPz = true;
        ArrayList c = C5034e.m13257c(this.bPs.bMM);
        int Wi = C5008i.m12937VU().mo25622Wi();
        if (-1 != Wi) {
            List iQ = this.bPs.bMO.mo25470iQ(Wi);
            for (int i = 0; i < iQ.size(); i++) {
                SaveRequest saveRequest = (SaveRequest) iQ.get(i);
                c.add(Integer.valueOf(saveRequest.endPos - saveRequest.startPos));
            }
        }
        C5008i.m12937VU().mo25632a(c);
    }

    /* renamed from: Vu */
    public Long mo25491Vu() {
        return Long.valueOf(this.bPE);
    }

    /* renamed from: Vv */
    public void mo25492Vv() {
        this.bPs.bOJ.mo25532b((QPIPFrameParam) null, 0);
    }

    /* renamed from: Z */
    public void mo25493Z(Activity activity) {
        this.mQpipSourceMode.srcIdx = -1;
        this.bPu = new C8759b(12);
        this.bPx = new C5006h();
    }

    /* renamed from: a */
    public void mo25494a(int i, QRect qRect) {
        if (this.bPD != null && qRect != null) {
            QPIPSource qPIPSource = this.bPD[i];
            if (qPIPSource.getType() == 3) {
                qPIPSource.setCropRegion(qRect);
                this.bPs.bOJ.mo25526a(i, qPIPSource);
            }
        }
    }

    /* renamed from: a */
    public void mo25495a(int i, boolean z, C8522g gVar) {
        if (!CameraCodeMgr.isCameraParamPIP(i)) {
            return;
        }
        if (this.bPA) {
            C5008i.m12937VU().mo25641cQ(false);
            this.bPA = false;
            mo25497a(this.bPB, this.bPv);
            mo25483UC();
        } else if (z) {
            mo25486Vm();
            if (C5008i.m12937VU().mo25621Wh()) {
                mo25508iV(this.bPt);
            }
        } else {
            m12798a(gVar);
        }
    }

    /* renamed from: a */
    public void mo25496a(C5009j jVar) {
        if (jVar != null) {
            jVar.setPipEffectMgr(this.bPu);
        }
    }

    /* renamed from: a */
    public void mo25497a(TrimedClipItemDataModel trimedClipItemDataModel, int i) {
        if (this.bPs != null && this.bPs.bMO != null && trimedClipItemDataModel != null) {
            SaveRequest saveRequest = new SaveRequest();
            String str = trimedClipItemDataModel.mRawFilePath;
            if (!TextUtils.isEmpty(trimedClipItemDataModel.mExportPath) && new File(trimedClipItemDataModel.mExportPath).exists()) {
                str = trimedClipItemDataModel.mExportPath;
            }
            saveRequest.filePath = str;
            saveRequest.dateTaken = System.currentTimeMillis();
            saveRequest.isVideo = true;
            saveRequest.orientation = this.bPs.bOw;
            saveRequest.insertPosition = this.bPs.mClipCount;
            saveRequest.isVirtualFile = true;
            if (trimedClipItemDataModel.mVeRangeInRawVideo != null) {
                saveRequest.startPos = trimedClipItemDataModel.mVeRangeInRawVideo.getmPosition();
                saveRequest.endPos = saveRequest.startPos + trimedClipItemDataModel.mVeRangeInRawVideo.getmTimeLength();
            }
            saveRequest.fTimeScale = this.bPs.bOx;
            StringBuilder sb = new StringBuilder();
            sb.append("saveRequest startPos: ");
            sb.append(saveRequest.startPos);
            sb.append(", endPos: ");
            sb.append(saveRequest.endPos);
            LogUtils.m14223i("CameraModePip", sb.toString());
            int i2 = saveRequest.endPos - saveRequest.startPos;
            if (CameraCodeMgr.isCameraParamPIP(this.bPs.bOz)) {
                int iR = this.bPs.bMO.mo25471iR(i);
                DataPIPIItem dataPIPIItem = new DataPIPIItem();
                dataPIPIItem.filePath = saveRequest.filePath;
                dataPIPIItem.sourceIndex = i;
                EffectInfoModel vh = this.bPu.mo35214vh(this.bPt);
                if (vh != null) {
                    dataPIPIItem.lTemplateID = vh.mTemplateId;
                }
                dataPIPIItem.sourceCount = this.bPx.getElementCount();
                saveRequest.pipItem = dataPIPIItem;
                dataPIPIItem.clipIndex = iR;
                this.bPx.mo25603bY(dataPIPIItem.sourceIndex, dataPIPIItem.clipIndex + 1);
                this.bPx.mo25607je(saveRequest.pipItem.sourceIndex);
                C5008i.m12937VU().mo25642cR(this.bPx.mo25598VR());
                C5008i.m12937VU().mo25641cQ(false);
                C5008i.m12937VU().mo25640cP(this.bPx.mo25600VT());
            }
            saveRequest.effectConfigureIndex = this.bPs.bOC;
            if (!this.bPs.bMO.mo25468b(saveRequest)) {
                this.bPs.mClipCount++;
            }
            this.bPs.bMO.mo25466a(saveRequest);
            this.bPs.bMN.mo25693jj(this.bPs.mClipCount);
            this.bPs.bOD = this.bPs.bOE;
            CameraActivity cameraActivity = this.bPs;
            cameraActivity.bOF = (int) (((long) cameraActivity.bOF) + C5034e.m13252b(this.bPs.bOx, (long) i2));
            this.bPs.bOG = false;
            this.bPs.mo24902Tv();
        }
    }

    /* renamed from: a */
    public void mo25498a(DataItemProject dataItemProject) {
        if (!this.bPs.bOH && CameraCodeMgr.isCameraParamPIP(this.bPs.bOz)) {
            if (this.bPs.bLX || this.bPs.bMc) {
                dataItemProject.setCameraPipMode(false);
                PipInfo.removePipExtraInfo(dataItemProject.strExtra);
                return;
            }
            dataItemProject.setCameraPipMode(true);
            PipInfo pipInfo = new PipInfo();
            pipInfo.mCurrentIndex = this.bPv;
            pipInfo.mSequence = this.bPx.mo25597VQ();
            EffectInfoModel vh = this.bPu.mo35214vh(this.bPt);
            if (vh != null) {
                pipInfo.mTemplateId = vh.mTemplateId;
            }
            dataItemProject.strExtra = PipInfo.addPipExtraInfo(dataItemProject.strExtra, pipInfo);
        }
    }

    /* renamed from: ae */
    public void mo25499ae(long j) {
        if (CameraCodeMgr.isCameraParamPIP(this.bPs.bOz)) {
            this.bPu.mo35197a(this.bPs.getApplicationContext(), j, this.bPs.bOI ? 524304 : 524296, AppStateModel.getInstance().isInChina(), AppStateModel.getInstance().isInIndia());
            if (this.bPs.bOt != null) {
                this.bPs.bOt.unInit(true);
            }
        }
        this.bPs.bMN.setPipEffectMgr(this.bPu);
    }

    /* renamed from: ah */
    public void mo25500ah(long j) {
        if (this.bPx != null && this.bPs.bMO != null) {
            int VP = this.bPx.mo25596VP();
            if (-1 != VP) {
                int iS = this.bPs.bMO.mo25472iS(VP);
                int i = (int) ((j - ((long) iS)) - ((long) this.bPC));
                int VO = C5006h.m12925VO();
                int state = C5008i.m12937VU().getState();
                if (!(-1 == VO || state == 2 || C5006h.m12926jf(VO) != 0)) {
                    i = 0;
                }
                if (i > iS) {
                    i = iS;
                }
                if (iS > 0) {
                    this.bPF = i;
                    this.bPs.bMN.mo25688bU(i, iS);
                }
            } else {
                this.bPs.bMN.setCurrentTimeValue(j);
            }
        }
    }

    /* renamed from: ai */
    public void mo25501ai(long j) {
        this.bPE = j;
    }

    /* renamed from: bW */
    public void mo25502bW(int i, int i2) {
        this.bPE = -1;
        if (this.bPx != null) {
            this.bPv = i2;
            if (C5008i.m12937VU().mo25621Wh()) {
                this.bPx.mo25602a(0, C5007a.REAL_CAMERA);
                this.bPx.mo25602a(1, C5007a.UN_REAL_CAMERA);
            } else {
                int elementCount = this.bPx.getElementCount();
                for (int i3 = 0; i3 < elementCount; i3++) {
                    this.bPx.mo25602a(i3, this.bPx.mo25606jd(i3).dataType);
                }
                EffectInfoModel vh = this.bPu.mo35214vh(i);
                if (vh != null && this.bPs.bMO != null) {
                    this.bPs.bMO.mo25467ag(vh.mTemplateId);
                } else {
                    return;
                }
            }
            this.bPt = i;
            mo25486Vm();
            this.bPs.bMN.setPipEffect(i, true);
        }
    }

    /* renamed from: d */
    public void mo25503d(Long l) {
        int bx = this.bPu.mo35205bx(l.longValue());
        if (-1 != bx) {
            mo25508iV(bx);
        }
    }

    /* renamed from: e */
    public void mo25504e(SaveRequest saveRequest) {
        if (CameraCodeMgr.isCameraParamPIP(this.bPs.bOz)) {
            SaveRequest Va = this.bPs.bMO.mo25462Va();
            int i = (Va == null || Va.pipItem == null || Va.pipItem.sourceIndex != this.bPv) ? 0 : Va.pipItem.clipIndex + 1;
            DataPIPIItem dataPIPIItem = new DataPIPIItem();
            dataPIPIItem.filePath = saveRequest.filePath;
            dataPIPIItem.sourceIndex = this.bPv;
            EffectInfoModel vh = this.bPu.mo35214vh(this.bPt);
            if (vh != null) {
                dataPIPIItem.lTemplateID = vh.mTemplateId;
            }
            dataPIPIItem.sourceCount = this.bPx.getElementCount();
            saveRequest.pipItem = dataPIPIItem;
            dataPIPIItem.clipIndex = i;
            this.bPx.mo25603bY(dataPIPIItem.sourceIndex, dataPIPIItem.clipIndex + 1);
            this.bPx.mo25607je(saveRequest.pipItem.sourceIndex);
            C5008i.m12937VU().mo25642cR(this.bPx.mo25598VR());
            C5008i.m12937VU().mo25641cQ(false);
            C5008i.m12937VU().mo25640cP(this.bPx.mo25600VT());
        }
        this.bPz = true;
    }

    /* renamed from: f */
    public void mo25505f(SaveRequest saveRequest) {
        if (CameraCodeMgr.isCameraParamPIP(this.bPs.bOz)) {
            if (saveRequest.pipItem != null) {
                int jf = C5006h.m12926jf(saveRequest.pipItem.sourceIndex);
                if (jf > 0) {
                    this.bPx.mo25603bY(saveRequest.pipItem.sourceIndex, jf - 1);
                } else {
                    this.bPx.mo25603bY(saveRequest.pipItem.sourceIndex, 0);
                }
                if (saveRequest.pipItem.sourceIndex != this.bPv) {
                    this.bPs.mo24894SV();
                    this.bPv = (this.bPv + 1) % 2;
                    mo25507h(this.bPs.bMO.mo25470iQ((this.bPv + 1) % 2), this.bPv);
                } else {
                    m12791Vl();
                    mo25486Vm();
                    m12792Vn();
                    this.bPs.bMN.mo25670Uj();
                }
            }
            if (C5008i.m12937VU().getDurationLimit() != 0) {
                mo25490Vr();
            }
        }
    }

    /* renamed from: g */
    public void mo25506g(int i, int i2, boolean z) {
        if (CameraCodeMgr.isCameraParamPIP(i2)) {
            C5008i.m12937VU().mo25640cP(false);
            C5008i.m12937VU().mo25641cQ(true);
            C5008i.m12937VU().mo25658jm(-1);
            this.bPx.init();
        }
        if (z) {
            this.bPt = 0;
            mo25508iV(this.bPt);
        }
    }

    /* renamed from: h */
    public void mo25507h(List<SaveRequest> list, int i) {
        this.bPv = i;
        this.bPx.mo25602a(i, C5007a.REAL_CAMERA);
        if (list.size() <= 0) {
            this.bPx.mo25602a((i + 1) % 2, C5007a.UN_REAL_CAMERA);
        } else {
            this.bPx.mo25602a((i + 1) % 2, C5007a.STORYBOARD);
        }
        mo25486Vm();
    }

    /* renamed from: iV */
    public void mo25508iV(int i) {
        mo25502bW(i, this.bPv);
    }

    /* renamed from: iW */
    public EffectInfoModel mo25509iW(int i) {
        if (this.bPu != null) {
            return this.bPu.mo35214vh(i);
        }
        return null;
    }

    /* renamed from: m */
    public void mo25510m(boolean z, boolean z2) {
        if (this.bPs.bMO != null && !this.bPs.bOH && this.bPz) {
            this.bPs.bMO.mo25469cu(z2);
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 8193 && i2 == -1 && intent.getExtras() != null) {
            TrimedClipItemDataModel trimedClipItemDataModel = (TrimedClipItemDataModel) intent.getExtras().get(GalleryRouter.INTENT_DATA_BACK_KEY);
            this.bPA = true;
            this.bPB = trimedClipItemDataModel;
        }
    }

    public void onDestroy() {
        if (this.bPu != null) {
            this.bPu.unInit(true);
            this.bPu = null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x006c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onFling(android.view.MotionEvent r6, android.view.MotionEvent r7, float r8, float r9) {
        /*
            r5 = this;
            int r6 = r5.bPt
            com.introvd.template.camera.b.i r7 = com.introvd.template.camera.p229b.C5008i.m12937VU()
            boolean r7 = r7.mo25621Wh()
            r0 = 1
            if (r7 != 0) goto L_0x000e
            return r0
        L_0x000e:
            com.introvd.template.camera.CameraActivity r7 = r5.bPs
            int r7 = r7.bOw
            r1 = 0
            r2 = -1001914368(0xffffffffc4480000, float:-800.0)
            r3 = 1145569280(0x44480000, float:800.0)
            if (r7 == 0) goto L_0x0050
            r4 = 90
            if (r7 == r4) goto L_0x0042
            r4 = 180(0xb4, float:2.52E-43)
            if (r7 == r4) goto L_0x0034
            r8 = 270(0x10e, float:3.78E-43)
            if (r7 == r8) goto L_0x0026
            goto L_0x0060
        L_0x0026:
            int r7 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r7 <= 0) goto L_0x002d
            int r6 = r6 + -1
            goto L_0x0056
        L_0x002d:
            int r7 = (r9 > r2 ? 1 : (r9 == r2 ? 0 : -1))
            if (r7 >= 0) goto L_0x0060
            int r6 = r6 + 1
            goto L_0x0056
        L_0x0034:
            int r7 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r7 <= 0) goto L_0x003b
            int r6 = r6 + 1
            goto L_0x0056
        L_0x003b:
            int r7 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r7 >= 0) goto L_0x0060
            int r6 = r6 + -1
            goto L_0x0056
        L_0x0042:
            int r7 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r7 <= 0) goto L_0x0049
            int r6 = r6 + 1
            goto L_0x0056
        L_0x0049:
            int r7 = (r9 > r2 ? 1 : (r9 == r2 ? 0 : -1))
            if (r7 >= 0) goto L_0x0060
            int r6 = r6 + -1
            goto L_0x0056
        L_0x0050:
            int r7 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r7 <= 0) goto L_0x0059
            int r6 = r6 + -1
        L_0x0056:
            r7 = r6
            r6 = 1
            goto L_0x0062
        L_0x0059:
            int r7 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r7 >= 0) goto L_0x0060
            int r6 = r6 + 1
            goto L_0x0056
        L_0x0060:
            r7 = r6
            r6 = 0
        L_0x0062:
            int r8 = r5.bPt
            com.introvd.template.template.g.b r9 = r5.bPu
            int r9 = r9.getCount()
            if (r6 == 0) goto L_0x00ce
            if (r7 >= r8) goto L_0x009d
        L_0x006e:
            if (r7 < 0) goto L_0x0085
            com.introvd.template.template.g.b r6 = r5.bPu
            com.introvd.template.sdk.model.editor.EffectInfoModel r6 = r6.mo35214vh(r7)
            if (r6 == 0) goto L_0x0082
            boolean r6 = r6.isbNeedDownload()
            if (r6 != 0) goto L_0x0082
            r5.mo25508iV(r7)
            return r0
        L_0x0082:
            int r7 = r7 + -1
            goto L_0x006e
        L_0x0085:
            int r9 = r9 - r0
        L_0x0086:
            if (r9 < r8) goto L_0x00ce
            com.introvd.template.template.g.b r6 = r5.bPu
            com.introvd.template.sdk.model.editor.EffectInfoModel r6 = r6.mo35214vh(r9)
            if (r6 == 0) goto L_0x009a
            boolean r6 = r6.isbNeedDownload()
            if (r6 != 0) goto L_0x009a
            r5.mo25508iV(r9)
            return r0
        L_0x009a:
            int r9 = r9 + -1
            goto L_0x0086
        L_0x009d:
            int r6 = r9 + -1
            if (r7 > r6) goto L_0x00b6
            com.introvd.template.template.g.b r6 = r5.bPu
            com.introvd.template.sdk.model.editor.EffectInfoModel r6 = r6.mo35214vh(r7)
            if (r6 == 0) goto L_0x00b3
            boolean r6 = r6.isbNeedDownload()
            if (r6 != 0) goto L_0x00b3
            r5.mo25508iV(r7)
            return r0
        L_0x00b3:
            int r7 = r7 + 1
            goto L_0x009d
        L_0x00b6:
            r6 = 0
        L_0x00b7:
            if (r6 > r8) goto L_0x00ce
            com.introvd.template.template.g.b r7 = r5.bPu
            com.introvd.template.sdk.model.editor.EffectInfoModel r7 = r7.mo35214vh(r6)
            if (r7 == 0) goto L_0x00cb
            boolean r7 = r7.isbNeedDownload()
            if (r7 != 0) goto L_0x00cb
            r5.mo25508iV(r6)
            return r0
        L_0x00cb:
            int r6 = r6 + 1
            goto L_0x00b7
        L_0x00ce:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.camera.p229b.C4995e.onFling(android.view.MotionEvent, android.view.MotionEvent, float, float):boolean");
    }
}
