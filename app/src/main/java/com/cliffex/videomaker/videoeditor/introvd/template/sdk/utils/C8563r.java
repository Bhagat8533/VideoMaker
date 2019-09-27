package com.introvd.template.sdk.utils;

import xiaoying.engine.base.QRange;
import xiaoying.engine.base.QSession;
import xiaoying.engine.base.QSessionStream;
import xiaoying.engine.base.QSessionStreamOpenParam;
import xiaoying.engine.clip.QClip;
import xiaoying.utils.QRect;

/* renamed from: com.introvd.template.sdk.utils.r */
public class C8563r {
    /* renamed from: a */
    public static QSessionStream m25045a(int i, QSession qSession, int i2, int i3, QRect qRect, int i4, int i5, int i6) {
        QSessionStream qSessionStream = null;
        if (qSession == null) {
            return null;
        }
        QSessionStream qSessionStream2 = new QSessionStream();
        int dI = C8572y.m25087dI(i2, 2);
        int dI2 = C8572y.m25087dI(i3, 2);
        QSessionStreamOpenParam qSessionStreamOpenParam = new QSessionStreamOpenParam();
        qSessionStreamOpenParam.mDecoderUsageType = i6;
        qSessionStreamOpenParam.mFrameSize.mWidth = dI;
        qSessionStreamOpenParam.mFrameSize.mHeight = dI2;
        qSessionStreamOpenParam.mRenderTargetSize.mWidth = qRect.right - qRect.left;
        qSessionStreamOpenParam.mRenderTargetSize.mHeight = qRect.bottom - qRect.top;
        qSessionStreamOpenParam.mResampleMode = i4;
        qSessionStreamOpenParam.mRotation = i5;
        if (qSessionStream2.open(i, qSession, qSessionStreamOpenParam) == 0) {
            qSessionStream = qSessionStream2;
        }
        return qSessionStream;
    }

    /* renamed from: a */
    public static QSessionStream m25046a(QClip qClip, QRect qRect, int i, int i2, int i3) {
        if (qClip == null) {
            return null;
        }
        return m25045a(2, qClip, 0, 0, qRect, i, i2, i3);
    }

    /* renamed from: e */
    public static void m25047e(QClip qClip) {
        if (qClip != null) {
            QRange qRange = (QRange) qClip.getProperty(12292);
            if (qRange != null) {
                qRange.set(0, 0);
                qRange.set(1, qClip.getRealVideoDuration());
                qClip.setProperty(12292, qRange);
            }
        }
    }
}
