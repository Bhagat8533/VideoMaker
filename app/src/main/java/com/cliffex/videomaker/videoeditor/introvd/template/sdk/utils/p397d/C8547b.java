package com.introvd.template.sdk.utils.p397d;

import android.text.TextUtils;
import com.introvd.template.p320j.C7547a;
import com.introvd.template.sdk.C8410e;
import com.introvd.template.sdk.editor.cache.TrimedClipItemDataModel;
import com.introvd.template.sdk.model.VeRange;
import com.introvd.template.sdk.p383c.C8400d;
import com.introvd.template.sdk.utils.C8572y;
import com.introvd.template.sdk.utils.VeMSize;
import com.introvd.template.sdk.utils.p394b.C8517b;
import com.introvd.template.sdk.utils.p394b.C8537n;
import com.introvd.template.sdk.utils.p394b.C8541r;
import xiaoying.basedef.QRange;
import xiaoying.engine.QEngine;
import xiaoying.engine.base.QUtils;
import xiaoying.engine.base.QUtils.QVideoImportFormat;
import xiaoying.engine.base.QVideoInfo;

/* renamed from: com.introvd.template.sdk.utils.d.b */
public class C8547b {
    /* renamed from: a */
    public static TrimedClipItemDataModel m24989a(QEngine qEngine, QRange qRange, String str, boolean z, boolean z2) {
        C8546a b = m24991b(qEngine, str, z, z2);
        if (b.mClip == null) {
            return null;
        }
        TrimedClipItemDataModel trimedClipItemDataModel = new TrimedClipItemDataModel();
        trimedClipItemDataModel.mVeRangeInRawVideo = new VeRange(qRange.start, qRange.length);
        trimedClipItemDataModel.mRawFilePath = str;
        trimedClipItemDataModel.mRotate = Integer.valueOf(0);
        trimedClipItemDataModel.bCrop = Boolean.valueOf(false);
        trimedClipItemDataModel.mStreamSizeVe = m24990a(b.eiV, b.eej.width, b.eej.height, false, C8410e.aGX().isCommunitySupport());
        trimedClipItemDataModel.mEncType = C8541r.m24978a(b.eiV);
        trimedClipItemDataModel.bNeedTranscode = b.bNeedTranscode;
        trimedClipItemDataModel.bCropFeatureEnable = Boolean.valueOf(false);
        if (b.eiW != null) {
            trimedClipItemDataModel.digitalWaterMarkCode = b.eiW.aaW();
        }
        return trimedClipItemDataModel;
    }

    /* renamed from: a */
    public static VeMSize m24990a(QVideoImportFormat qVideoImportFormat, int i, int i2, boolean z, boolean z2) {
        VeMSize veMSize = new VeMSize(i, i2);
        VeMSize js = C8572y.m25096js(z2);
        if (qVideoImportFormat != null) {
            js = new VeMSize(qVideoImportFormat.mWidth, qVideoImportFormat.mHeight);
        }
        return C8572y.m25065a(js, veMSize, z);
    }

    /* renamed from: b */
    public static C8546a m24991b(QEngine qEngine, String str, boolean z, boolean z2) {
        C8546a aVar = new C8546a();
        if (TextUtils.isEmpty(str) || qEngine == null || C8572y.m25084d(str, qEngine) != 0) {
            return aVar;
        }
        aVar.mClip = C8537n.m24824f(str, qEngine);
        if (aVar.mClip == null) {
            return aVar;
        }
        aVar.cCG = C8517b.m24648c(aVar.mClip, 0);
        aVar.cDS = aVar.mClip.getRealVideoDuration();
        QVideoInfo qVideoInfo = (QVideoInfo) aVar.mClip.getProperty(12291);
        if (qVideoInfo != null) {
            aVar.eej = new VeMSize(qVideoInfo.get(3), qVideoInfo.get(4));
        }
        int[] iArr = new int[1];
        aVar.bNeedTranscode = QUtils.IsNeedTranscode(qEngine, C8572y.m25068a(str, z, false, z2), iArr);
        aVar.eiV = QUtils.TransformVImportFormat(iArr[0]);
        if (C8400d.edj.booleanValue()) {
            aVar.eiW = C7547a.m22296fU(str);
        }
        return aVar;
    }

    /* renamed from: c */
    public static TrimedClipItemDataModel m24992c(QEngine qEngine, String str, boolean z, boolean z2) {
        C8546a b = m24991b(qEngine, str, z, z2);
        if (b.mClip == null) {
            return null;
        }
        TrimedClipItemDataModel trimedClipItemDataModel = new TrimedClipItemDataModel();
        trimedClipItemDataModel.mVeRangeInRawVideo = new VeRange(0, b.cDS);
        trimedClipItemDataModel.mRawFilePath = str;
        trimedClipItemDataModel.mRotate = Integer.valueOf(0);
        trimedClipItemDataModel.bCrop = Boolean.valueOf(false);
        trimedClipItemDataModel.mStreamSizeVe = m24990a(b.eiV, b.eej.width, b.eej.height, false, C8410e.aGX().isCommunitySupport());
        trimedClipItemDataModel.mEncType = C8541r.m24978a(b.eiV);
        trimedClipItemDataModel.bNeedTranscode = b.bNeedTranscode;
        trimedClipItemDataModel.bCropFeatureEnable = Boolean.valueOf(false);
        if (b.eiW != null) {
            trimedClipItemDataModel.digitalWaterMarkCode = b.eiW.aaW();
        }
        return trimedClipItemDataModel;
    }

    /* renamed from: m */
    public static boolean m24993m(int i, int i2, boolean z) {
        return !(!z && i * i2 <= 230400) && !(z && i * i2 <= 921600);
    }
}
