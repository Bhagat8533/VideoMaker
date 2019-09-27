package com.introvd.template.sdk.p381b;

import android.graphics.Rect;
import com.introvd.template.sdk.utils.C8554j;
import com.introvd.template.sdk.utils.C8572y;
import com.introvd.template.sdk.utils.VeMSize;
import com.introvd.template.sdk.utils.p394b.C8537n;
import com.mediarecorder.engine.QPIPFrameParam;
import com.mediarecorder.engine.QPIPSource;
import java.util.List;
import xiaoying.engine.QEngine;
import xiaoying.engine.clip.QClip;
import xiaoying.engine.clip.QSceneClip;
import xiaoying.engine.storyboard.QStoryboard;
import xiaoying.utils.QRect;
import xiaoying.utils.QSize;

/* renamed from: com.introvd.template.sdk.b.a */
public class C8383a {
    /* renamed from: a */
    public static QSceneClip m24147a(QEngine qEngine, VeMSize veMSize, long j, List<QStoryboard> list, QPIPFrameParam qPIPFrameParam) {
        QSceneClip qSceneClip = new QSceneClip();
        QSize qSize = new QSize();
        qSize.mWidth = veMSize.width;
        qSize.mHeight = veMSize.height;
        if (qSceneClip.init(qEngine, j, qSize) != 0) {
            return null;
        }
        int i = 0;
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (qSceneClip.setElementSource(i2, (QStoryboard) list.get(i2)) != 0) {
                return null;
            }
        }
        if (qPIPFrameParam == null) {
            C8572y.m25073a(qSceneClip, veMSize, true);
        } else {
            int elementCount = qSceneClip.getElementCount();
            while (i < elementCount) {
                QStoryboard qStoryboard = new QStoryboard();
                if (qSceneClip.getElementSource(i, qStoryboard) == 0) {
                    QPIPSource elementSource = qPIPFrameParam.getElementSource(i);
                    if (elementSource != null) {
                        qStoryboard.getDataClip().setProperty(12314, elementSource.getType() == 3 ? elementSource.getCropRegion() : m24148a(qSceneClip, veMSize, i));
                    }
                }
                i++;
            }
        }
        return qSceneClip;
    }

    /* renamed from: a */
    public static QRect m24148a(QSceneClip qSceneClip, VeMSize veMSize, int i) {
        QRect qRect = new QRect(0, 0, 10000, 10000);
        if (veMSize != null) {
            QStoryboard qStoryboard = new QStoryboard();
            if (qSceneClip.getElementSource(i, qStoryboard) != 0) {
                return qRect;
            }
            QClip dataClip = qStoryboard.getDataClip();
            VeMSize h = C8537n.m24828h(dataClip);
            StringBuilder sb = new StringBuilder();
            sb.append("updateSceneClipSourceRegion1 videoSize:");
            sb.append(h);
            C8554j.m25008i("CamPiPUtil", sb.toString());
            if (dataClip != null) {
                QRect qRect2 = (QRect) dataClip.getProperty(12314);
                Rect rect = new Rect(qRect2.left, qRect2.top, qRect2.right, qRect2.bottom);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("updateSceneClipSourceRegion11 oldRect:");
                sb2.append(rect);
                C8554j.m25008i("CamPiPUtil", sb2.toString());
            }
            VeMSize veMSize2 = null;
            QRect elementRegion = qSceneClip.getElementRegion(i);
            if (elementRegion != null) {
                VeMSize veMSize3 = new VeMSize(C8572y.m25087dI((veMSize.width * (elementRegion.right - elementRegion.left)) / 10000, 4), C8572y.m25087dI((veMSize.height * (elementRegion.bottom - elementRegion.top)) / 10000, 4));
                StringBuilder sb3 = new StringBuilder();
                sb3.append("updateSceneClipSourceRegion111 region.left:");
                sb3.append(elementRegion.left);
                sb3.append(";region.top=");
                sb3.append(elementRegion.top);
                C8554j.m25008i("CamPiPUtil", sb3.toString());
                veMSize2 = veMSize3;
            }
            StringBuilder sb4 = new StringBuilder();
            sb4.append("updateSceneClipSourceRegion2 streamSizeVe:");
            sb4.append(veMSize);
            C8554j.m25008i("CamPiPUtil", sb4.toString());
            StringBuilder sb5 = new StringBuilder();
            sb5.append("updateSceneClipSourceRegion3 previewSize:");
            sb5.append(veMSize2);
            C8554j.m25008i("CamPiPUtil", sb5.toString());
            VeMSize c = C8572y.m25083c(h, veMSize2);
            if (veMSize2 == null || c == null || c.width <= 0 || c.height <= 0) {
                return qRect;
            }
            StringBuilder sb6 = new StringBuilder();
            sb6.append("updateSceneClipSourceRegion4 fitOutSize:");
            sb6.append(c);
            C8554j.m25008i("CamPiPUtil", sb6.toString());
            int i2 = (veMSize2.width * 10000) / c.width;
            int i3 = (veMSize2.height * 10000) / c.height;
            int elementSourceAlignment = qSceneClip.getElementSourceAlignment(i);
            if (elementSourceAlignment == 96) {
                qRect.left = (10000 - i2) / 2;
                qRect.right = qRect.left + i2;
                qRect.top = (10000 - i3) / 2;
                qRect.bottom = qRect.top + i3;
            } else if ((elementSourceAlignment & 1) == 1) {
                qRect.left = 0;
                qRect.right = i2;
                qRect.top = (10000 - i3) / 2;
                qRect.bottom = qRect.top + i3;
            } else if ((elementSourceAlignment & 2) == 2) {
                qRect.left = 10000 - i2;
                qRect.right = 10000;
                qRect.top = (10000 - i3) / 2;
                qRect.bottom = qRect.top + i3;
            } else if ((elementSourceAlignment & 4) == 4) {
                qRect.left = 0;
                qRect.right = 10000;
                qRect.top = 0;
                qRect.bottom = i3;
            } else if ((elementSourceAlignment & 8) == 8) {
                qRect.left = 0;
                qRect.right = 10000;
                qRect.top = 10000 - i3;
                qRect.bottom = 10000;
            }
        }
        return qRect;
    }
}
