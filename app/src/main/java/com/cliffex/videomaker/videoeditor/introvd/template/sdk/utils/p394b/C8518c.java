package com.introvd.template.sdk.utils.p394b;

import com.introvd.template.sdk.editor.cache.C8440a;
import com.introvd.template.sdk.editor.cache.TrimedClipItemDataModel;
import java.util.ArrayList;
import xiaoying.engine.base.QRange;
import xiaoying.engine.clip.QClip;
import xiaoying.engine.clip.QEffect;
import xiaoying.engine.clip.QMediaSource;
import xiaoying.engine.clip.QSceneClip;
import xiaoying.engine.clip.QTransition;

/* renamed from: com.introvd.template.sdk.utils.b.c */
public class C8518c {
    /* renamed from: a */
    private static String m24649a(QSceneClip qSceneClip) {
        if (qSceneClip != null) {
            ArrayList b = C8537n.m24814b(qSceneClip);
            if (b != null && b.size() > 0) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < b.size(); i++) {
                    TrimedClipItemDataModel trimedClipItemDataModel = (TrimedClipItemDataModel) b.get(i);
                    if (trimedClipItemDataModel != null) {
                        sb.append(trimedClipItemDataModel.mRawFilePath);
                        sb.append(';');
                    }
                }
                return sb.toString();
            }
        }
        return "";
    }

    /* renamed from: a */
    public static void m24650a(QClip qClip, C8440a aVar) {
        QClip qClip2 = qClip;
        C8440a aVar2 = aVar;
        QRange qRange = (QRange) qClip2.getProperty(12292);
        QRange qRange2 = (QRange) qClip2.getProperty(QClip.PROP_CLIP_SRC_RANGE);
        QTransition qTransition = (QTransition) qClip2.getProperty(12294);
        Integer num = (Integer) qClip2.getProperty(12289);
        String str = (String) qClip2.getProperty(QClip.PROP_CLIP_REVERSE_SOURCE);
        Boolean bool = (Boolean) qClip2.getProperty(QClip.PROP_CLIP_IS_REVERSE_MODE);
        boolean booleanValue = ((Boolean) qClip2.getProperty(QClip.PROP_CLIP_IS_REVERSE_CLIP)).booleanValue();
        QEffect d = C8540q.m24947d(qClip2, 1, 0);
        int realVideoDuration = qClip.getRealVideoDuration();
        int i = C8537n.m24829i(qClip2, 2);
        int h = C8537n.m24827h(qClip2, 3);
        int j = C8540q.m24957j(qClip2, 4);
        int j2 = C8540q.m24957j(qClip2, 1);
        int intValue = ((Integer) qClip2.getProperty(12315)).intValue();
        boolean booleanValue2 = ((Boolean) qClip2.getProperty(QClip.PROP_CLIP_REVERSE_TRIM_MDOE)).booleanValue();
        QEffect qEffect = d;
        Object property = qClip2.getProperty(QClip.PROP_CLIP_FILE_MISSING);
        aVar2.mo34243jg(property != null ? ((Boolean) property).booleanValue() : false);
        aVar2.mo34257tQ(num.intValue());
        aVar2.mo34258tR(realVideoDuration);
        aVar2.mo34259tS(i);
        aVar2.mo34260tT(h);
        aVar2.mo34261tU(j);
        aVar2.mo34262tV(intValue);
        aVar2.setmClipReverseFilePath(str);
        aVar2.setbIsReverseMode(bool.booleanValue());
        aVar2.setIsClipReverse(booleanValue);
        aVar2.mo34246jj(booleanValue2);
        boolean z = qClip2 instanceof QSceneClip;
        aVar2.mo34245ji(z);
        Integer num2 = (Integer) qClip2.getProperty(12313);
        boolean z2 = true;
        if (1 == num2.intValue() || 2 == num2.intValue()) {
            aVar2.mo34256tP(3);
        } else {
            aVar2.mo34256tP(1);
            QMediaSource qMediaSource = (QMediaSource) qClip2.getProperty(12290);
            if (qMediaSource != null) {
                if (qMediaSource.getSourceType() == 0) {
                    Object source = qMediaSource.getSource();
                    if (source != null) {
                        aVar2.mo34247nF((String) source);
                    }
                } else if (z) {
                    aVar2.mo34247nF(m24649a((QSceneClip) qClip2));
                }
            }
        }
        aVar2.mo34255tO(qTransition == null ? 0 : qTransition.getDuration());
        if (!booleanValue2) {
            aVar2.mo34216a(qRange);
        } else {
            aVar2.mo34216a(qRange2);
        }
        aVar2.edJ = qRange2;
        aVar2.mo34236c((QRange) qClip2.getProperty(QClip.PROP_CLIP_REVERSE_TRIM_RANGE));
        if (qEffect != null) {
            QRange qRange3 = (QRange) qEffect.getProperty(4098);
            if (qRange3 != null) {
                aVar2.mo34235b(qRange3);
            }
        }
        if (j2 <= 0) {
            z2 = false;
        }
        aVar2.mo34244jh(z2);
    }
}
