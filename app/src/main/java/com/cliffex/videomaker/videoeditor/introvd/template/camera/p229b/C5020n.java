package com.introvd.template.camera.p229b;

import android.graphics.Point;
import android.graphics.Rect;
import android.text.TextUtils;
import com.introvd.template.camera.model.SaveRequest;
import com.introvd.template.common.LogUtils;
import com.introvd.template.common.MSize;
import com.introvd.template.common.MediaFileUtils;
import com.introvd.template.sdk.editor.cache.C8440a;
import com.introvd.template.sdk.model.editor.ProjectItem;
import com.introvd.template.sdk.p381b.C8383a;
import com.introvd.template.sdk.p386e.C8417b;
import com.introvd.template.sdk.utils.C8572y;
import com.introvd.template.sdk.utils.VeMSize;
import com.introvd.template.sdk.utils.p394b.C8501a;
import com.introvd.template.sdk.utils.p394b.C8517b;
import com.introvd.template.sdk.utils.p394b.C8519d;
import com.introvd.template.sdk.utils.p394b.C8537n;
import com.introvd.template.sdk.utils.p394b.C8540q;
import com.introvd.template.template.p409g.C8762d;
import com.mediarecorder.engine.QPIPFrameParam;
import com.mediarecorder.engine.QPIPSource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import xiaoying.engine.QEngine;
import xiaoying.engine.base.QRange;
import xiaoying.engine.base.QVideoInfo;
import xiaoying.engine.clip.QClip;
import xiaoying.engine.clip.QMediaSource;
import xiaoying.engine.clip.QSceneClip;
import xiaoying.engine.storyboard.QStoryboard;
import xiaoying.utils.QRect;
import xiaoying.utils.QStreamAssets;

/* renamed from: com.introvd.template.camera.b.n */
public class C5020n {
    /* renamed from: a */
    public static int m13112a(C8501a aVar, ProjectItem projectItem, int i, List<SaveRequest> list, boolean z) {
        C8501a aVar2 = aVar;
        ProjectItem projectItem2 = projectItem;
        int i2 = i;
        List<SaveRequest> list2 = list;
        if (aVar2 == null) {
            return 2;
        }
        QEngine aJv = aVar.aJv();
        SaveRequest saveRequest = (SaveRequest) list2.get(0);
        SaveRequest saveRequest2 = (SaveRequest) list2.get(list.size() - 1);
        List synchronizedList = Collections.synchronizedList(new ArrayList());
        for (int i3 = 0; i3 < saveRequest.pipItem.sourceCount; i3++) {
            QStoryboard qStoryboard = new QStoryboard();
            int init = qStoryboard.init(aJv, null);
            if (init != 0) {
                return init;
            }
            synchronizedList.add(qStoryboard);
        }
        for (int i4 = 0; i4 < list.size(); i4++) {
            SaveRequest saveRequest3 = (SaveRequest) list2.get(i4);
            C8519d dVar = new C8519d(saveRequest3.startPos, saveRequest3.endPos);
            if (TextUtils.isEmpty(saveRequest3.filePath)) {
                return 2;
            }
            int d = C8572y.m25084d(saveRequest3.filePath, aJv);
            if (d != 0) {
                return d;
            }
            if (projectItem2 == null) {
                return 5;
            }
            if (MediaFileUtils.IsImageFileType(MediaFileUtils.GetFileMediaType(saveRequest3.filePath))) {
                C8537n.m24821e(C8537n.m24824f(saveRequest3.filePath, aJv), dVar.aJy() - dVar.aJx());
            } else {
                QClip a = m13114a(projectItem2, saveRequest3.filePath, aVar2, dVar, saveRequest3.fTimeScale);
                QStoryboard qStoryboard2 = (QStoryboard) synchronizedList.get(saveRequest3.pipItem.sourceIndex);
                qStoryboard2.insertClip(a, qStoryboard2.getClipCount());
            }
        }
        for (int i5 = 0; i5 < synchronizedList.size(); i5++) {
            if (((QStoryboard) synchronizedList.get(i5)).getClipCount() == 0) {
                for (int i6 = 0; i6 < list.size(); i6++) {
                    SaveRequest saveRequest4 = (SaveRequest) list2.get(i6);
                    C8519d dVar2 = new C8519d(saveRequest4.startPos, saveRequest4.endPos);
                    if (TextUtils.isEmpty(saveRequest4.filePath)) {
                        return 2;
                    }
                    int d2 = C8572y.m25084d(saveRequest4.filePath, aJv);
                    if (d2 != 0) {
                        return d2;
                    }
                    if (projectItem2 == null) {
                        return 5;
                    }
                    if (MediaFileUtils.IsImageFileType(MediaFileUtils.GetFileMediaType(saveRequest4.filePath))) {
                        C8537n.m24821e(C8537n.m24824f(saveRequest4.filePath, aJv), dVar2.aJy() - dVar2.aJx());
                    } else {
                        QClip a2 = m13114a(projectItem2, saveRequest4.filePath, aVar2, dVar2, saveRequest4.fTimeScale);
                        QStoryboard qStoryboard3 = (QStoryboard) synchronizedList.get(i5);
                        qStoryboard3.insertClip(a2, qStoryboard3.getClipCount());
                    }
                }
                continue;
            }
        }
        int i7 = 0;
        for (int i8 = 0; i8 < synchronizedList.size(); i8++) {
            QStoryboard qStoryboard4 = (QStoryboard) synchronizedList.get(i8);
            if (qStoryboard4.getClipCount() != 0) {
                int duration = qStoryboard4.getDuration();
                if (i7 == 0 || i7 > duration) {
                    i7 = duration;
                }
            }
        }
        if (z) {
            for (int i9 = 0; i9 < synchronizedList.size(); i9++) {
                QStoryboard qStoryboard5 = (QStoryboard) synchronizedList.get(i9);
                if (qStoryboard5.getClipCount() != 0) {
                    qStoryboard5.getDataClip().setProperty(12292, new QRange(0, i7));
                }
            }
        }
        QSceneClip a3 = C8383a.m24147a(aJv, m13116ak(saveRequest.pipItem.lTemplateID), saveRequest.pipItem.lTemplateID, synchronizedList, C5008i.m12937VU().mo25624Wk());
        if (a3 == null) {
            projectItem2.mProjectDataItem.iPrjClipCount--;
            return 4;
        }
        C8519d dVar3 = new C8519d(0, i7);
        if (dVar3.aHX() > 0) {
            a3.setProperty(12315, Integer.valueOf(dVar3.aHX()));
        }
        C8517b.m24644a(projectItem2.mClipModelCacheList, projectItem2.mStoryBoard);
        int a4 = C8540q.m24923a(projectItem2.mStoryBoard, (QClip) a3, i2);
        if (a4 != 0) {
            a3.unInit();
            projectItem2.mProjectDataItem.iPrjClipCount--;
            return a4;
        }
        try {
            C8440a c = C8517b.m24648c(C8540q.m24956i(projectItem2.mStoryBoard, i2), i2);
            if (projectItem2.mClipModelCacheList == null || c == null) {
                return 1;
            }
            projectItem2.mClipModelCacheList.mo34292a(c);
            C8517b.m24643a(projectItem2.mClipModelCacheList);
            projectItem2.mClipModelCacheList.mo34308tY(i2);
            projectItem2.mClipModelCacheList.aIl();
            aVar2.mo34669jt(true);
            return 0;
        } catch (Exception unused) {
            projectItem2.mProjectDataItem.iPrjClipCount--;
            return 1;
        }
    }

    /* renamed from: a */
    public static ArrayList<C8417b> m13113a(QPIPFrameParam qPIPFrameParam, MSize mSize, boolean z) {
        Rect rect;
        VeMSize veMSize;
        int i;
        int i2;
        QPIPFrameParam qPIPFrameParam2 = qPIPFrameParam;
        MSize mSize2 = mSize;
        ArrayList<C8417b> arrayList = new ArrayList<>();
        if (qPIPFrameParam2 != null && mSize2 != null) {
            int elementCount = qPIPFrameParam.getElementCount();
            int i3 = 0;
            while (i3 < elementCount) {
                QPIPSource elementSource = qPIPFrameParam2.getElementSource(i3);
                C8417b bVar = new C8417b();
                Object src = elementSource.getSrc();
                if (elementSource.getType() == 3 && (src instanceof QStoryboard)) {
                    QStoryboard qStoryboard = (QStoryboard) src;
                    QClip dataClip = qStoryboard.getDataClip();
                    VeMSize h = C8537n.m24828h(dataClip);
                    StringBuilder sb = new StringBuilder();
                    sb.append("========== updateSceneClipSourceRegion1 videoSize:");
                    sb.append(h);
                    LogUtils.m14223i("PipClipMgr", sb.toString());
                    Rect rect2 = null;
                    if (dataClip != null) {
                        QRect qRect = (QRect) dataClip.getProperty(12314);
                        rect = new Rect(qRect.left, qRect.top, qRect.right, qRect.bottom);
                    } else {
                        rect = null;
                    }
                    QRect elementDisplayRegion = qPIPFrameParam2.getElementDisplayRegion(i3);
                    if (elementDisplayRegion != null) {
                        rect2 = new Rect(elementDisplayRegion.left, elementDisplayRegion.top, elementDisplayRegion.right, elementDisplayRegion.bottom);
                        int i4 = elementDisplayRegion.right - elementDisplayRegion.left;
                        int i5 = elementDisplayRegion.bottom - elementDisplayRegion.top;
                        if (z) {
                            i = (mSize2.width * i4) / 10000;
                            i2 = (mSize2.height * i5) / 10000;
                        } else {
                            i = (mSize2.height * i5) / 10000;
                            i2 = (mSize2.width * i4) / 10000;
                        }
                        veMSize = new VeMSize(C8572y.m25087dI(i, 4), C8572y.m25087dI(i2, 4));
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("updateSceneClipSourceRegion111 region.left:");
                        sb2.append(elementDisplayRegion.left);
                        sb2.append(";region.top=");
                        sb2.append(elementDisplayRegion.top);
                        LogUtils.m14223i("PipClipMgr", sb2.toString());
                    } else {
                        veMSize = null;
                    }
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("updateSceneClipSourceRegion2 mStreamSizeVe:");
                    sb3.append(mSize2);
                    LogUtils.m14223i("PipClipMgr", sb3.toString());
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("updateSceneClipSourceRegion3 itemPreviewSize:");
                    sb4.append(veMSize);
                    LogUtils.m14223i("PipClipMgr", sb4.toString());
                    VeMSize c = C8572y.m25083c(h, veMSize);
                    if (veMSize == null || c == null || c.width <= 0 || c.height <= 0) {
                        break;
                    }
                    Rect rect3 = new Rect(0, 0, (veMSize.width * 10000) / c.width, (veMSize.height * 10000) / c.height);
                    int clipCount = qStoryboard.getClipCount();
                    int i6 = 0;
                    while (i6 < clipCount) {
                        QClip clip = qStoryboard.getClip(i6);
                        if (clip != null) {
                            QMediaSource qMediaSource = (QMediaSource) clip.getProperty(12290);
                            if (qMediaSource != null && qMediaSource.getSourceType() == 0) {
                                Object source = qMediaSource.getSource();
                                if (source != null) {
                                    bVar.mo34134jo(TextUtils.indexOf((String) source, QStreamAssets.ASSETS_THEME) != 0);
                                }
                            }
                        }
                        i6++;
                        QPIPFrameParam qPIPFrameParam3 = qPIPFrameParam;
                    }
                    bVar.mo34133i(new Point(0, 0));
                    bVar.mo34135p(rect2);
                    bVar.mo34131c(veMSize);
                    bVar.mo34136q(rect);
                    bVar.mo34132e(c);
                    bVar.mo34137r(rect3);
                    arrayList.add(bVar);
                } else {
                    bVar.mo34134jo(false);
                    arrayList.add(bVar);
                }
                i3++;
                qPIPFrameParam2 = qPIPFrameParam;
            }
        }
        return arrayList;
    }

    @Deprecated
    /* renamed from: a */
    public static QClip m13114a(ProjectItem projectItem, String str, C8501a aVar, C8519d dVar, float f) {
        QClip qClip;
        if (TextUtils.isEmpty(str) || aVar == null || dVar == null) {
            return null;
        }
        QEngine aJv = aVar.aJv();
        if (C8572y.m25084d(str, aJv) != 0 || projectItem == null) {
            return null;
        }
        boolean IsImageFileType = MediaFileUtils.IsImageFileType(MediaFileUtils.GetFileMediaType(str));
        if (IsImageFileType) {
            qClip = C8537n.m24824f(str, aJv);
            C8537n.m24821e(qClip, dVar.aJy() - dVar.aJx());
        } else {
            QClip f2 = C8537n.m24824f(str, aJv);
            if (f2 != null) {
                QClip i = C8537n.m24830i(f2);
                f2.unInit();
                qClip = i;
            } else {
                qClip = null;
            }
        }
        if (qClip == null) {
            projectItem.mProjectDataItem.iPrjClipCount--;
            return null;
        }
        QVideoInfo qVideoInfo = (QVideoInfo) qClip.getProperty(12291);
        if (qVideoInfo != null && !IsImageFileType) {
            if (qVideoInfo.get(3) <= qVideoInfo.get(4)) {
                qClip.setProperty(QClip.PROP_CLIP_PANZOOM_DISABLED, Boolean.FALSE);
            } else {
                qClip.setProperty(QClip.PROP_CLIP_PANZOOM_DISABLED, Boolean.TRUE);
            }
        }
        if (dVar.aHX() > 0) {
            qClip.setProperty(12315, Integer.valueOf(dVar.aHX()));
        }
        int aJy = dVar.aJy() - dVar.aJx();
        if (!(dVar.aJx() == -1 || dVar.aJy() == -1)) {
            QRange qRange = new QRange();
            qRange.set(0, dVar.aJx());
            qRange.set(1, aJy);
            qClip.setProperty(QClip.PROP_CLIP_SRC_RANGE, qRange);
            qClip.setProperty(12293, Float.valueOf(f));
        }
        C8517b.m24644a(projectItem.mClipModelCacheList, projectItem.mStoryBoard);
        return qClip;
    }

    /* renamed from: a */
    public static QStoryboard m13115a(C8501a aVar, ProjectItem projectItem, List<SaveRequest> list) {
        QStoryboard qStoryboard = new QStoryboard();
        if (qStoryboard.init(aVar.aJv(), null) != 0) {
            return null;
        }
        C8519d dVar = new C8519d(0, 0);
        for (int i = 0; i < list.size(); i++) {
            SaveRequest saveRequest = (SaveRequest) list.get(i);
            dVar.mo34714ux(saveRequest.startPos);
            dVar.mo34715uy(saveRequest.endPos);
            qStoryboard.insertClip(m13114a(projectItem, saveRequest.filePath, aVar, dVar, saveRequest.fTimeScale), i);
        }
        return qStoryboard;
    }

    /* renamed from: ak */
    public static VeMSize m13116ak(long j) {
        return (C8762d.aMt().mo35229bF(j) & 8) == 8 ? C8572y.m25103uw(8) : C8572y.aJp();
    }
}
