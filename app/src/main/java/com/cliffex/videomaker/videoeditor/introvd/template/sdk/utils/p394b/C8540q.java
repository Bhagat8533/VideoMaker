package com.introvd.template.sdk.utils.p394b;

import android.text.TextUtils;
import android.util.SparseArray;
import com.introvd.template.sdk.editor.cache.C8441b;
import com.introvd.template.sdk.model.VeRange;
import com.introvd.template.sdk.model.editor.EngineSubtitleInfoModel;
import com.introvd.template.sdk.model.editor.ThumbInfo;
import com.introvd.template.sdk.p383c.C8398b;
import com.introvd.template.sdk.p391g.C8450a;
import com.introvd.template.sdk.slide.C8459a;
import com.introvd.template.sdk.slide.p392a.C8466c;
import com.introvd.template.sdk.utils.C8548e;
import com.introvd.template.sdk.utils.C8549f;
import com.introvd.template.sdk.utils.C8554j;
import com.introvd.template.sdk.utils.C8560o;
import com.introvd.template.sdk.utils.C8561p;
import com.introvd.template.sdk.utils.C8569v;
import com.introvd.template.sdk.utils.C8572y;
import com.introvd.template.sdk.utils.VeMSize;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import xiaoying.engine.QEngine;
import xiaoying.engine.base.QRange;
import xiaoying.engine.base.QStyle;
import xiaoying.engine.base.QUtils;
import xiaoying.engine.clip.QClip;
import xiaoying.engine.clip.QClip.QCamExportedEffectData;
import xiaoying.engine.clip.QEffect;
import xiaoying.engine.clip.QMediaSource;
import xiaoying.engine.clip.QSceneClip;
import xiaoying.engine.clip.QTransition;
import xiaoying.engine.clip.QUserData;
import xiaoying.engine.cover.QCover;
import xiaoying.engine.cover.QTitleInfo;
import xiaoying.engine.slideshowsession.QSlideShowSession;
import xiaoying.engine.storyboard.QClipPosition;
import xiaoying.engine.storyboard.QStoryboard;
import xiaoying.utils.QPoint;
import xiaoying.utils.QSize;

/* renamed from: com.introvd.template.sdk.utils.b.q */
public class C8540q {
    /* renamed from: A */
    public static boolean m24892A(QStoryboard qStoryboard) {
        boolean z = false;
        if (qStoryboard == null) {
            return false;
        }
        if (qStoryboard.getProperty(16393) != null) {
            z = true;
        }
        return z;
    }

    /* renamed from: B */
    public static boolean m24893B(QStoryboard qStoryboard) {
        Long C = m24894C(qStoryboard);
        return C != null && QStyle.NONE_THEME_TEMPLATE_ID < C.longValue();
    }

    /* renamed from: C */
    public static Long m24894C(QStoryboard qStoryboard) {
        return qStoryboard == null ? Long.valueOf(0) : (Long) qStoryboard.getProperty(QStoryboard.PROP_THEME_ID);
    }

    /* renamed from: D */
    public static int m24895D(QStoryboard qStoryboard) {
        int i = 0;
        if (qStoryboard == null) {
            return 0;
        }
        if (m24893B(qStoryboard)) {
            if (m24976w(qStoryboard)) {
                i = 1;
            }
            if (m24892A(qStoryboard)) {
                i++;
            }
        }
        return i + qStoryboard.getClipCount();
    }

    /* renamed from: E */
    public static boolean m24896E(QStoryboard qStoryboard) {
        if (qStoryboard == null) {
            return false;
        }
        int clipCount = qStoryboard.getClipCount();
        for (int i = 0; i < clipCount; i++) {
            QClip clip = qStoryboard.getClip(i);
            if (clip != null) {
                Object property = clip.getProperty(12294);
                if (property != null) {
                    QTransition qTransition = (QTransition) property;
                    qTransition.setAnimatedCfg(0);
                    clip.setProperty(12294, qTransition);
                }
            }
        }
        return true;
    }

    /* renamed from: F */
    public static ArrayList<String> m24897F(QStoryboard qStoryboard) {
        if (qStoryboard == null) {
            return null;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        int clipCount = qStoryboard.getClipCount();
        for (int i = 0; i < clipCount; i++) {
            QClip clip = qStoryboard.getClip(i);
            if (clip != null) {
                arrayList.add(C8537n.m24813b(qStoryboard.getEngine(), clip));
            }
        }
        return arrayList;
    }

    /* renamed from: G */
    public static String m24898G(QStoryboard qStoryboard) {
        return C8538o.m24878i(m24899H(qStoryboard));
    }

    /* renamed from: H */
    public static QEffect m24899H(QStoryboard qStoryboard) {
        if (qStoryboard == null) {
            return null;
        }
        QClip dataClip = qStoryboard.getDataClip();
        if (dataClip != null && Integer.valueOf(m24957j(dataClip, 1)).intValue() > 0) {
            QEffect d = m24947d(dataClip, 1, 0);
            if (d != null) {
                return d;
            }
        }
        return null;
    }

    /* renamed from: I */
    public static boolean m24900I(QStoryboard qStoryboard) {
        if (m24901J(qStoryboard)) {
            return C8538o.m24876h(m24899H(qStoryboard));
        }
        return false;
    }

    /* renamed from: J */
    public static boolean m24901J(QStoryboard qStoryboard) {
        boolean z = false;
        if (qStoryboard == null) {
            return false;
        }
        QClip dataClip = qStoryboard.getDataClip();
        if (dataClip == null) {
            return false;
        }
        if (m24957j(dataClip, 1) > 0) {
            z = true;
        }
        return z;
    }

    /* renamed from: K */
    public static boolean m24902K(QStoryboard qStoryboard) {
        if (qStoryboard != null) {
            QClip dataClip = qStoryboard.getDataClip();
            if (dataClip != null) {
                int j = m24957j(dataClip, 1);
                if (j > 0) {
                    while (j > 0) {
                        m24962m(qStoryboard, j - 1);
                        j--;
                    }
                }
            }
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x004c  */
    /* renamed from: L */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean m24903L(xiaoying.engine.storyboard.QStoryboard r6) {
        /*
            r0 = 0
            if (r6 != 0) goto L_0x0004
            return r0
        L_0x0004:
            xiaoying.engine.clip.QClip r1 = r6.getDataClip()
            if (r1 != 0) goto L_0x000b
            return r0
        L_0x000b:
            r2 = 1
            int r1 = m24957j(r1, r2)
            if (r1 == r2) goto L_0x0013
            return r0
        L_0x0013:
            int r1 = r6.getDuration()
            boolean r3 = m24893B(r6)
            if (r3 == 0) goto L_0x007e
            boolean r3 = m24976w(r6)
            if (r3 == 0) goto L_0x0045
            r3 = 16392(0x4008, float:2.297E-41)
            java.lang.Object r3 = r6.getProperty(r3)
            xiaoying.engine.cover.QCover r3 = (xiaoying.engine.cover.QCover) r3
            if (r3 == 0) goto L_0x0045
            boolean r3 = com.introvd.template.sdk.utils.p394b.C8537n.m24826g(r3)
            if (r3 == 0) goto L_0x0045
            java.lang.String r3 = "XYStoryBoardUtil"
            java.lang.String r4 = "isCoverHasAudio cover hasaudio"
            com.introvd.template.sdk.utils.C8554j.m25008i(r3, r4)
            xiaoying.engine.base.QRange r3 = r6.getClipTimeRange(r2)
            if (r3 == 0) goto L_0x0045
            int r3 = r3.get(r0)
            goto L_0x0046
        L_0x0045:
            r3 = 0
        L_0x0046:
            boolean r4 = m24892A(r6)
            if (r4 == 0) goto L_0x007f
            r4 = 16393(0x4009, float:2.2971E-41)
            java.lang.Object r4 = r6.getProperty(r4)
            xiaoying.engine.cover.QCover r4 = (xiaoying.engine.cover.QCover) r4
            if (r4 == 0) goto L_0x007f
            boolean r4 = com.introvd.template.sdk.utils.p394b.C8537n.m24826g(r4)
            if (r4 == 0) goto L_0x007f
            int r4 = m24895D(r6)
            if (r4 <= r2) goto L_0x0076
            int r4 = r4 + -2
            xiaoying.engine.base.QRange r4 = r6.getClipTimeRange(r4)
            if (r4 == 0) goto L_0x0076
            int r5 = r4.get(r0)
            int r4 = r4.get(r2)
            if (r4 <= 0) goto L_0x0076
            int r5 = r5 + r4
            r1 = r5
        L_0x0076:
            java.lang.String r4 = "XYStoryBoardUtil"
            java.lang.String r5 = "isCoverHasAudio back cover hasaudio"
            com.introvd.template.sdk.utils.C8554j.m25008i(r4, r5)
            goto L_0x007f
        L_0x007e:
            r3 = 0
        L_0x007f:
            if (r1 < 0) goto L_0x00bd
            if (r3 < 0) goto L_0x00bd
            if (r1 <= r3) goto L_0x00bd
            xiaoying.engine.clip.QClip r4 = r6.getDataClip()
            xiaoying.engine.clip.QEffect r4 = m24947d(r4, r2, r0)
            if (r4 == 0) goto L_0x00bd
            r5 = 4128(0x1020, float:5.785E-42)
            java.lang.Object r5 = r4.getProperty(r5)
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r5 = r5.booleanValue()
            if (r5 == 0) goto L_0x009e
            return r0
        L_0x009e:
            r5 = 4098(0x1002, float:5.743E-42)
            java.lang.Object r4 = r4.getProperty(r5)
            xiaoying.engine.base.QRange r4 = (xiaoying.engine.base.QRange) r4
            if (r4 == 0) goto L_0x00bd
            int r5 = r4.get(r0)
            int r4 = r4.get(r2)
            if (r3 != r5) goto L_0x00b4
            if (r4 == r1) goto L_0x00bd
        L_0x00b4:
            com.introvd.template.sdk.model.VeRange r4 = new com.introvd.template.sdk.model.VeRange
            int r1 = r1 - r3
            r4.<init>(r3, r1)
            m24931a(r6, r0, r4, r2)
        L_0x00bd:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.sdk.utils.p394b.C8540q.m24903L(xiaoying.engine.storyboard.QStoryboard):boolean");
    }

    /* renamed from: M */
    public static ArrayList<String> m24904M(QStoryboard qStoryboard) {
        if (qStoryboard == null) {
            return null;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        int clipCount = qStoryboard.getClipCount();
        for (int i = 0; i < clipCount; i++) {
            QClip clip = qStoryboard.getClip(i);
            if (clip != null) {
                arrayList.add(m24972t(clip));
            }
        }
        return arrayList;
    }

    /* renamed from: N */
    public static boolean m24905N(QStoryboard qStoryboard) {
        boolean z = false;
        if (qStoryboard == null) {
            return false;
        }
        int clipCount = qStoryboard.getClipCount();
        if (clipCount > 1) {
            VeMSize veMSize = null;
            QClip clip = qStoryboard.getClip(0);
            if (clip != null) {
                veMSize = C8537n.m24823f(clip);
            }
            for (int i = 1; i < clipCount; i++) {
                QClip clip2 = qStoryboard.getClip(i);
                if (clip2 != null) {
                    return C8537n.m24823f(clip2).equals(veMSize);
                }
            }
            return true;
        }
        if (clipCount == 1) {
            z = true;
        }
        return z;
    }

    /* renamed from: O */
    public static boolean m24906O(QStoryboard qStoryboard) {
        if (qStoryboard != null) {
            int clipCount = qStoryboard.getClipCount();
            if (clipCount > 0) {
                for (int i = 0; i < clipCount; i++) {
                    if (C8537n.m24829i(qStoryboard.getClip(i), 2) > 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* renamed from: P */
    public static boolean m24907P(QStoryboard qStoryboard) {
        if (qStoryboard != null) {
            QClip dataClip = qStoryboard.getDataClip();
            if (dataClip == null) {
                return false;
            }
            if (m24957j(dataClip, 1) == 1) {
                QEffect d = m24947d(dataClip, 1, 0);
                if (d != null) {
                    if (!(((Integer) d.getProperty(QEffect.PROP_AUDIO_FRAME_REPEAT_MODE)).intValue() == 1)) {
                        QRange qRange = (QRange) d.getProperty(4098);
                        VeRange d2 = C8561p.m25041d((QRange) d.getProperty(QEffect.PROP_AUDIO_FRAME_RANGE));
                        VeRange d3 = C8561p.m25041d(qRange);
                        if (!(d3 == null || d2 == null || (d3.getmTimeLength() <= d2.getmTimeLength() && d3.getmTimeLength() != -1))) {
                            int duration = qStoryboard.getDuration();
                            if (duration > d2.getmTimeLength()) {
                                duration = d2.getmTimeLength();
                            }
                            if (d.setProperty(4098, new QRange(d3.getmPosition(), duration)) == 0) {
                                return false;
                            }
                        }
                    }
                }
            }
            int D = m24895D(qStoryboard);
            for (int i = 0; i < D; i++) {
                QClip i2 = m24956i(qStoryboard, i);
                if (i2 != null) {
                    i2.setProperty(QClip.PROP_CLIP_AUDIO_MIX_PERCENT, Integer.valueOf(-1));
                }
            }
        }
        return true;
    }

    /* renamed from: Q */
    public static String m24908Q(QStoryboard qStoryboard) {
        StringBuilder sb = new StringBuilder();
        int h = C8537n.m24827h(qStoryboard.getDataClip(), 3);
        if (h > 0) {
            for (int i = 0; i < h; i++) {
                String m = C8538o.m24883m(m24940b(qStoryboard, 3, i));
                if (!TextUtils.isEmpty(m)) {
                    sb.append(m);
                    sb.append(',');
                }
            }
        }
        return sb.toString();
    }

    /* renamed from: R */
    public static QSceneClip m24909R(QStoryboard qStoryboard) {
        if (qStoryboard != null) {
            int clipCount = qStoryboard.getClipCount();
            if (clipCount > 0) {
                for (int i = 0; i < clipCount; i++) {
                    QClip clip = qStoryboard.getClip(i);
                    if (clip instanceof QSceneClip) {
                        return (QSceneClip) clip;
                    }
                }
            }
        }
        return null;
    }

    /* renamed from: S */
    public static VeRange m24910S(QStoryboard qStoryboard) {
        VeRange veRange;
        if (qStoryboard == null) {
            return null;
        }
        int i = 0;
        if (!m24893B(qStoryboard) || qStoryboard.getClipCount() <= 0) {
            veRange = new VeRange(0, qStoryboard.getDuration());
        } else {
            QRange clipTimeRange = qStoryboard.getClipTimeRange(m24976w(qStoryboard) ? 1 : 0);
            int i2 = clipTimeRange != null ? clipTimeRange.get(0) : 0;
            if (m24892A(qStoryboard)) {
                QRange clipTimeRange2 = qStoryboard.getClipTimeRange(m24895D(qStoryboard) - 2);
                if (clipTimeRange2 != null) {
                    i = clipTimeRange2.get(0) + clipTimeRange2.get(1);
                }
            } else {
                i = qStoryboard.getDuration();
            }
            veRange = (i <= i2 || i > qStoryboard.getDuration()) ? new VeRange(i2, 1) : new VeRange(i2, i - i2);
        }
        return veRange;
    }

    /* renamed from: T */
    public static boolean m24911T(QStoryboard qStoryboard) {
        boolean z = false;
        if (qStoryboard != null) {
            int clipCount = qStoryboard.getClipCount();
            int i = 0;
            while (true) {
                if (i >= clipCount) {
                    z = true;
                    break;
                }
                QClip clip = qStoryboard.getClip(i);
                if (clip == null) {
                    return false;
                }
                Object property = clip.getProperty(12289);
                if (property == null || !(property instanceof Integer)) {
                    return false;
                }
                if (((Integer) property).intValue() != 2) {
                    break;
                }
                i++;
            }
            return false;
        }
        return z;
    }

    /* renamed from: U */
    public static boolean m24912U(QStoryboard qStoryboard) {
        if (qStoryboard == null) {
            return false;
        }
        QClip dataClip = qStoryboard.getDataClip();
        if (dataClip == null) {
            return false;
        }
        return ((Boolean) dataClip.getProperty(12301)).booleanValue();
    }

    /* renamed from: V */
    public static boolean m24913V(QStoryboard qStoryboard) {
        if (qStoryboard != null) {
            Object property = qStoryboard.getProperty(QStoryboard.PROP_RATIO_SETTED);
            if (property != null) {
                return ((Boolean) property).booleanValue();
            }
        }
        return false;
    }

    /* renamed from: W */
    public static boolean m24914W(QStoryboard qStoryboard) {
        boolean z = false;
        if (qStoryboard == null) {
            return false;
        }
        if (qStoryboard.setProperty(QStoryboard.PROP_RESET_THEME_ELEM, Integer.valueOf(1)) == 0) {
            z = true;
        }
        return z;
    }

    /* renamed from: X */
    public static ArrayList<String> m24915X(QStoryboard qStoryboard) {
        ArrayList<String> arrayList = new ArrayList<>();
        if (qStoryboard == null) {
            return arrayList;
        }
        int clipCount = qStoryboard.getClipCount();
        for (int i = 0; i < clipCount; i++) {
            QCamExportedEffectData[] qCamExportedEffectDataArr = (QCamExportedEffectData[]) qStoryboard.getClip(i).getProperty(QClip.PROP_CLIP_CAM_EXPORT_EFFECT_DATA_LIST);
            if (qCamExportedEffectDataArr != null && qCamExportedEffectDataArr.length > 0) {
                long j = qCamExportedEffectDataArr[0].mlTemplateID;
                if (!TextUtils.isEmpty(C8532k.m24769q(Long.valueOf(j)))) {
                    arrayList.add(C8450a.m24469bn(j));
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public static int m24916a(int i, QStoryboard qStoryboard) {
        if (qStoryboard != null) {
            return C8537n.m24838q(m24956i(qStoryboard, i));
        }
        return -1;
    }

    /* renamed from: a */
    public static int m24917a(QEngine qEngine, String str, int i, boolean z, QClip qClip) {
        boolean z2;
        if (qEngine == null || qClip == null) {
            return 1;
        }
        if (qClip instanceof QCover) {
            return 2;
        }
        if (!TextUtils.isEmpty(str)) {
            QEffect a = C8537n.m24797a(qClip, 2, 0);
            if (a == null) {
                a = new QEffect();
                if (a.create(qEngine, 1, 1, 2, 1.0f) != 0 || qClip.insertEffect(a) != 0) {
                    return 1;
                }
                z2 = true;
            } else {
                z2 = false;
            }
            if (a.setProperty(QEffect.PROP_EFFECT_ADDBYTHEME, Boolean.valueOf(false)) != 0) {
                return 1;
            }
            if (a.setProperty(4103, str) == 0) {
                return (m24939b(z, a) == 0 && m24925a(z, 0, 0, a) == 0 && a.setProperty(QEffect.PROP_VIDEO_IE_CONFIGURE, Integer.valueOf(i)) == 0) ? 0 : 1;
            }
            if (z2) {
                qClip.removeEffect(a);
            }
            return 1;
        }
        QEffect a2 = C8537n.m24797a(qClip, 2, 0);
        if (a2 != null) {
            qClip.removeEffect(a2);
            a2.destory();
        }
    }

    /* renamed from: a */
    public static int m24918a(QEngine qEngine, String str, int i, boolean z, QClip qClip, int i2, Float f) {
        boolean z2;
        if (qEngine == null) {
            return 1;
        }
        if (!TextUtils.isEmpty(str)) {
            QEffect b = C8537n.m24816b(qClip, i2, 0);
            if (b == null) {
                b = new QEffect();
                if (b.create(qEngine, 1, 2, i2, f.floatValue()) != 0 || qClip.insertEffect(b) != 0) {
                    return 1;
                }
                z2 = true;
            } else {
                z2 = false;
            }
            if (b.setProperty(QEffect.PROP_EFFECT_ADDBYTHEME, Boolean.valueOf(false)) != 0) {
                return 1;
            }
            if (b.setProperty(4103, str) == 0) {
                return (m24939b(z, b) == 0 && m24925a(z, 0, 0, b) == 0 && b.setProperty(QEffect.PROP_VIDEO_IE_CONFIGURE, Integer.valueOf(i)) == 0) ? 0 : 1;
            }
            if (z2) {
                qClip.removeEffect(b);
            }
            return 1;
        }
        QEffect b2 = C8537n.m24816b(qClip, i2, 0);
        if (b2 != null) {
            qClip.removeEffect(b2);
            b2.destory();
        }
    }

    /* renamed from: a */
    public static int m24919a(QEngine qEngine, QStoryboard qStoryboard, String str, int i, int i2, int i3, int i4, int i5) {
        if (qStoryboard == null || TextUtils.isEmpty(str)) {
            return 1;
        }
        C8450a.m24465b(str, qEngine);
        if (!C8450a.m24463a(qEngine, str) || QUtils.getVideoInfo(qEngine, str) == null) {
            return 1;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("left:");
        sb.append(i3);
        sb.append(";musicLen:");
        sb.append(i4);
        C8554j.m25008i("XYStoryBoardUtil", sb.toString());
        return m24922a(qStoryboard, str, i3, i4, i, i2, i5) != 0 ? 1 : 0;
    }

    /* renamed from: a */
    public static int m24920a(QStoryboard qStoryboard, int i, String str, int i2, int i3, int i4, int i5, int i6, boolean z) {
        int i7 = i2;
        int i8 = i4;
        int i9 = i5;
        int i10 = i6;
        if (qStoryboard == null || TextUtils.isEmpty(str) || i7 < 0 || i3 <= 0 || i8 < 0 || i9 <= 0) {
            return 2;
        }
        QClip dataClip = z ? qStoryboard.getDataClip() : m24956i(qStoryboard, i);
        if (dataClip == null) {
            return 1;
        }
        float b = C8537n.m24812b(dataClip, 4, 2.0f) + 5.0E-4f;
        QEffect qEffect = new QEffect();
        if (qEffect.create(qStoryboard.getEngine(), 3, 3, 4, b) != 0) {
            return 1;
        }
        if (qEffect.setProperty(QEffect.PROP_AUDIO_FRAME_SOURCE, new QMediaSource(0, false, str)) != 0) {
            qEffect.destory();
            return 1;
        } else if (qEffect.setProperty(QEffect.PROP_AUDIO_FRAME_RANGE, new QRange(i7, -1)) != 0) {
            qEffect.destory();
            return 1;
        } else if (qEffect.setProperty(QEffect.PROP_AUDIO_FRAME_REPEAT_MODE, Integer.valueOf(2)) != 0) {
            qEffect.destory();
            return 1;
        } else {
            Integer valueOf = Integer.valueOf(100);
            if (i10 >= 0 && i10 <= 100) {
                valueOf = Integer.valueOf(i6);
            }
            if (qEffect.setProperty(QEffect.PROP_AUDIO_FRAME_MIXPERCENT, valueOf) != 0) {
                qEffect.destory();
                return 1;
            } else if (dataClip.insertEffect(qEffect) != 0) {
                qEffect.destory();
                return 1;
            } else if (qEffect.setProperty(4098, new QRange(i8, i9)) == 0) {
                return 0;
            } else {
                dataClip.removeEffect(qEffect);
                qEffect.destory();
                return 1;
            }
        }
    }

    /* renamed from: a */
    public static int m24921a(QStoryboard qStoryboard, int i, String str, boolean z) {
        if (qStoryboard == null) {
            return 2;
        }
        return m24917a(qStoryboard.getEngine(), str, m24965oO(str), z, m24956i(qStoryboard, i));
    }

    /* renamed from: a */
    public static int m24922a(QStoryboard qStoryboard, String str, int i, int i2, int i3, int i4, int i5) {
        if (qStoryboard == null || !C8548e.isFileExisted(str) || i < 0 || i3 < 0) {
            return 2;
        }
        QClip dataClip = qStoryboard.getDataClip();
        if (dataClip == null) {
            return 1;
        }
        QEffect qEffect = new QEffect();
        if (qEffect.create(qStoryboard.getEngine(), 3, 3, 1, 4.0f) != 0) {
            return 1;
        }
        if (qEffect.setProperty(QEffect.PROP_AUDIO_FRAME_SOURCE, new QMediaSource(0, false, str)) != 0) {
            qEffect.destory();
            return 1;
        } else if (qEffect.setProperty(QEffect.PROP_AUDIO_FRAME_RANGE, new QRange(i, i2)) != 0) {
            qEffect.destory();
            return 1;
        } else {
            if (i4 < 0) {
                i4 = Integer.MAX_VALUE;
            }
            Integer valueOf = Integer.valueOf(0);
            if (i4 > i2) {
                valueOf = Integer.valueOf(1);
            }
            if (qEffect.setProperty(QEffect.PROP_AUDIO_FRAME_REPEAT_MODE, valueOf) != 0) {
                qEffect.destory();
                return 1;
            } else if (qEffect.setProperty(QEffect.PROP_AUDIO_FRAME_MIXPERCENT, Integer.valueOf(i5)) != 0) {
                qEffect.destory();
                return 1;
            } else if (dataClip.insertEffect(qEffect) != 0) {
                qEffect.destory();
                return 1;
            } else if (qEffect.setProperty(4098, new QRange(i3, i4)) != 0) {
                dataClip.removeEffect(qEffect);
                qEffect.destory();
                return 1;
            } else if (qEffect.setProperty(QEffect.PROP_EFFECT_POSITION_ALIGNMENT, Integer.valueOf(0)) != 0) {
                dataClip.removeEffect(qEffect);
                qEffect.destory();
                return 1;
            } else {
                int duration = qStoryboard.getDuration();
                if ((i4 <= 1000 && (i4 >= 0 || duration <= 1000)) || C8538o.m24867c(qEffect, false, duration) == 0) {
                    return 0;
                }
                dataClip.removeEffect(qEffect);
                qEffect.destory();
                return 1;
            }
        }
    }

    /* renamed from: a */
    public static int m24923a(QStoryboard qStoryboard, QClip qClip, int i) {
        if (qStoryboard == null) {
            return 2;
        }
        if (m24976w(qStoryboard)) {
            i--;
        }
        return qStoryboard.insertClip(qClip, i);
    }

    /* renamed from: a */
    public static int m24924a(QStoryboard qStoryboard, QEffect qEffect) {
        if (!(qStoryboard == null || qEffect == null)) {
            QClip dataClip = qStoryboard.getDataClip();
            if (dataClip != null) {
                int removeEffect = dataClip.removeEffect(qEffect);
                if (removeEffect == 0) {
                    qEffect.destory();
                }
                return removeEffect;
            }
        }
        return 0;
    }

    /* renamed from: a */
    private static int m24925a(boolean z, int i, int i2, QEffect qEffect) {
        QRange qRange = (QRange) qEffect.getProperty(4098);
        if (qRange == null) {
            return 0;
        }
        QRange qRange2 = z ? new QRange(0, -1) : new QRange(i, i2);
        int i3 = qRange.get(0);
        int i4 = qRange2.get(0);
        int i5 = qRange.get(1);
        int i6 = qRange2.get(1);
        if (i3 == i4 && i5 == i6) {
            return 0;
        }
        return qEffect.setProperty(4098, qRange2);
    }

    /* renamed from: a */
    public static List<EngineSubtitleInfoModel> m24926a(QEngine qEngine, QStoryboard qStoryboard, VeMSize veMSize) {
        ArrayList arrayList = new ArrayList();
        if (qStoryboard != null && m24893B(qStoryboard)) {
            if (m24976w(qStoryboard)) {
                m24928a(qEngine, arrayList, qStoryboard, (QCover) m24956i(qStoryboard, 0), 0, veMSize);
            }
            if (m24892A(qStoryboard)) {
                m24928a(qEngine, arrayList, qStoryboard, (QCover) m24956i(qStoryboard, m24895D(qStoryboard)), 1, veMSize);
            }
            List a = m24927a(qEngine, qStoryboard, veMSize, 5);
            if (a != null) {
                arrayList.addAll(a);
            }
            List a2 = m24927a(qEngine, qStoryboard, veMSize, -8);
            if (a2 != null) {
                arrayList.addAll(a2);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    static List<EngineSubtitleInfoModel> m24927a(QEngine qEngine, QStoryboard qStoryboard, VeMSize veMSize, int i) {
        ArrayList arrayList = new ArrayList();
        int h = C8537n.m24827h(qStoryboard.getDataClip(), i);
        if (h > 0) {
            for (int i2 = 0; i2 < h; i2++) {
                QEffect b = m24940b(qStoryboard, i, i2);
                if (b != null) {
                    EngineSubtitleInfoModel engineSubtitleInfoModel = new EngineSubtitleInfoModel();
                    QRange qRange = (QRange) b.getProperty(4098);
                    int i3 = qRange.get(0);
                    int i4 = qRange.get(1);
                    engineSubtitleInfoModel.mIndex = i2;
                    engineSubtitleInfoModel.mTimeVeRange = new VeRange(i3, i4);
                    engineSubtitleInfoModel.textState = C8538o.m24850a(qEngine, b, veMSize);
                    if (engineSubtitleInfoModel.textState != null) {
                        engineSubtitleInfoModel.mText = engineSubtitleInfoModel.textState.getTextBubbleText();
                    }
                    engineSubtitleInfoModel.mGroupType = 2;
                    engineSubtitleInfoModel.groupId = i;
                    engineSubtitleInfoModel.mClipIndex = m24970s(qStoryboard, i3);
                    engineSubtitleInfoModel.mTemplatePath = C8538o.m24872e(b);
                    arrayList.add(engineSubtitleInfoModel);
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private static void m24928a(QEngine qEngine, List<EngineSubtitleInfoModel> list, QStoryboard qStoryboard, QCover qCover, int i, VeMSize veMSize) {
        if (qCover != null && veMSize != null) {
            int titleCount = qCover.getTitleCount();
            for (int i2 = 0; i2 < titleCount; i2++) {
                QTitleInfo titleDefaultInfo = qCover.getTitleDefaultInfo(i2, C8450a.m24471c(C8398b.mLocale));
                if (!(titleDefaultInfo == null || titleDefaultInfo.bubbleInfo == null)) {
                    EngineSubtitleInfoModel engineSubtitleInfoModel = new EngineSubtitleInfoModel();
                    engineSubtitleInfoModel.mTimeVeRange = C8450a.m24459a(titleDefaultInfo);
                    engineSubtitleInfoModel.mText = C8537n.m24825g(qCover, i2);
                    engineSubtitleInfoModel.mGroupType = i;
                    engineSubtitleInfoModel.mClipIndex = i == 0 ? 0 : m24895D(qStoryboard) - 1;
                    engineSubtitleInfoModel.mIndex = i2;
                    QRange clipTimeRange = qStoryboard.getClipTimeRange(engineSubtitleInfoModel.mClipIndex);
                    if (clipTimeRange != null) {
                        engineSubtitleInfoModel.mClipStartPos = clipTimeRange.get(0);
                    }
                    engineSubtitleInfoModel.mTemplatePath = C8532k.m24769q(Long.valueOf(qCover.getTitle(i2).bubbleTemplateID));
                    engineSubtitleInfoModel.textState = C8538o.m24868c(qEngine, engineSubtitleInfoModel.mTemplatePath, veMSize);
                    if (engineSubtitleInfoModel.textState != null) {
                        C8530i.m24755a(engineSubtitleInfoModel.textState, engineSubtitleInfoModel.mTemplatePath, veMSize);
                    }
                    list.add(engineSubtitleInfoModel);
                }
            }
        }
    }

    /* renamed from: a */
    public static boolean m24929a(ArrayList<C8441b> arrayList, QStoryboard qStoryboard, int i) {
        if (qStoryboard == null || arrayList == null || arrayList.size() <= 0) {
            return false;
        }
        int clipCount = qStoryboard.getClipCount();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList(arrayList);
        if (clipCount > 0) {
            int duration = qStoryboard.getDuration();
            Collections.sort(arrayList3);
            Collections.reverse(arrayList3);
            Iterator it = arrayList3.iterator();
            int i2 = 0;
            int i3 = duration;
            while (it.hasNext()) {
                C8441b bVar = (C8441b) it.next();
                int GetTimeByClipPosition = qStoryboard.GetTimeByClipPosition(bVar.aIe());
                int GetIndexByClipPosition = qStoryboard.GetIndexByClipPosition(bVar.aIe());
                VeRange aIc = bVar.aIc();
                int i4 = aIc.getmPosition();
                int i5 = aIc.getmTimeLength();
                if (GetTimeByClipPosition <= -1) {
                    if (aIc.getmPosition() >= i3) {
                        arrayList2.add(Integer.valueOf(bVar.aId()));
                    } else {
                        if (aIc.getLimitValue() > i3) {
                            aIc.setmTimeLength(i3 - i4);
                        }
                        m24937b(qStoryboard, bVar.aId(), aIc, false);
                        i3 = aIc.getmPosition();
                        if (GetIndexByClipPosition <= i && i2 < aIc.getLimitValue()) {
                            i2 = aIc.getLimitValue();
                        }
                    }
                } else if (GetTimeByClipPosition < i3) {
                    if (GetTimeByClipPosition + i5 > i3) {
                        i5 = i3 - GetTimeByClipPosition;
                    }
                    aIc.setmPosition(GetTimeByClipPosition);
                    aIc.setmTimeLength(i5);
                    m24937b(qStoryboard, bVar.aId(), aIc, false);
                    i3 = aIc.getmPosition();
                    if (GetIndexByClipPosition <= i && i2 < aIc.getLimitValue()) {
                        i2 = aIc.getLimitValue();
                    }
                } else if (GetTimeByClipPosition + i5 < i2 || i2 >= duration) {
                    arrayList2.add(Integer.valueOf(bVar.aId()));
                } else {
                    if (GetTimeByClipPosition < i2) {
                        GetTimeByClipPosition = i2;
                    }
                    int i6 = duration - GetTimeByClipPosition;
                    if (i6 >= i5) {
                        i6 = i5;
                    }
                    aIc.setmPosition(GetTimeByClipPosition);
                    aIc.setmTimeLength(i6);
                    m24937b(qStoryboard, bVar.aId(), aIc, false);
                    if (GetIndexByClipPosition <= i && i2 < aIc.getLimitValue()) {
                        i2 = aIc.getLimitValue();
                    }
                }
            }
        } else {
            Iterator it2 = arrayList3.iterator();
            while (it2.hasNext()) {
                arrayList2.add(Integer.valueOf(((C8441b) it2.next()).aId()));
            }
        }
        Collections.sort(arrayList2);
        Collections.reverse(arrayList2);
        Iterator it3 = arrayList2.iterator();
        while (it3.hasNext()) {
            m24936b(qStoryboard, 0, ((Integer) it3.next()).intValue(), true);
        }
        return true;
    }

    /* renamed from: a */
    public static boolean m24930a(QSlideShowSession qSlideShowSession, VeMSize veMSize) {
        if (veMSize == null || qSlideShowSession == null) {
            return false;
        }
        qSlideShowSession.setProperty(20484, new QPoint(veMSize.width, veMSize.height));
        qSlideShowSession.setProperty(20485, new QSize(veMSize.width, veMSize.height));
        return true;
    }

    /* renamed from: a */
    public static boolean m24931a(QStoryboard qStoryboard, int i, VeRange veRange, boolean z) {
        if (!(qStoryboard == null || veRange == null)) {
            QClip dataClip = qStoryboard.getDataClip();
            if (dataClip != null) {
                int j = m24957j(dataClip, 1);
                if (j > 0 && i >= 0 && i < j) {
                    QEffect d = m24947d(dataClip, 1, i);
                    if (d != null) {
                        int i2 = veRange.getmTimeLength();
                        if (d.setProperty(4098, new QRange(veRange.getmPosition(), i2)) != 0 || d.setProperty(QEffect.PROP_AUDIO_FRAME_REPEAT_MODE, Integer.valueOf(z ? 1 : 0)) != 0) {
                            return false;
                        }
                        if (i2 > 1000) {
                            if (C8538o.m24867c(d, false, i2) != 0) {
                                dataClip.removeEffect(d);
                                d.destory();
                                return false;
                            }
                        } else if (C8538o.m24867c(d, true, i2) != 0) {
                            dataClip.removeEffect(d);
                            d.destory();
                            return false;
                        }
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m24932a(QStoryboard qStoryboard, int i, Boolean bool) {
        boolean z = false;
        if (qStoryboard != null && i >= 0 && i < qStoryboard.getClipCount()) {
            QClip clip = qStoryboard.getClip(i);
            if (clip != null) {
                if (clip.setProperty(12300, Boolean.valueOf(!bool.booleanValue())) == 0) {
                    z = true;
                }
                return z;
            }
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m24933a(QStoryboard qStoryboard, int i, String str, int i2, int i3) {
        if (i >= m24895D(qStoryboard)) {
            return false;
        }
        QClip i4 = m24956i(qStoryboard, i);
        if (i4 == null) {
            return false;
        }
        return C8537n.m24805a(i4, str, i2, i3);
    }

    /* renamed from: a */
    public static boolean m24934a(QStoryboard qStoryboard, long j) {
        if (j < 131080) {
            try {
                int h = C8537n.m24827h(qStoryboard.getDataClip(), 3);
                for (int i = 0; i < h; i++) {
                    QEffect b = m24940b(qStoryboard, 3, i);
                    if (b != null) {
                        b.setProperty(4100, Float.valueOf(C8537n.m24784a(qStoryboard.getDataClip(), 3, 1000.0f) + 5.0E-4f));
                    }
                }
                int h2 = C8537n.m24827h(qStoryboard.getDataClip(), 8);
                for (int i2 = 0; i2 < h2; i2++) {
                    QEffect b2 = m24940b(qStoryboard, 8, i2);
                    if (b2 != null) {
                        b2.setProperty(4100, Float.valueOf(C8537n.m24784a(qStoryboard.getDataClip(), 8, 200.0f) + 5.0E-4f));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    /* renamed from: a */
    public static boolean m24935a(QStoryboard qStoryboard, VeMSize veMSize) {
        if (veMSize == null || qStoryboard == null) {
            return false;
        }
        qStoryboard.setProperty(QStoryboard.PROP_OUTPUT_RESOLUTION, new QPoint(veMSize.width, veMSize.height));
        return true;
    }

    /* renamed from: b */
    public static int m24936b(QStoryboard qStoryboard, int i, int i2, boolean z) {
        QClip dataClip = z ? qStoryboard.getDataClip() : m24956i(qStoryboard, i);
        if (dataClip != null && i2 < m24957j(dataClip, 4) && i2 >= 0) {
            QEffect d = m24947d(dataClip, 4, i2);
            if (d != null) {
                dataClip.removeEffect(d);
                d.destory();
                return 0;
            }
        }
        return 1;
    }

    /* renamed from: b */
    public static int m24937b(QStoryboard qStoryboard, int i, VeRange veRange, boolean z) {
        if (!(qStoryboard == null || veRange == null || i < 0)) {
            QClip dataClip = qStoryboard.getDataClip();
            if (dataClip != null) {
                QEffect d = m24947d(dataClip, 4, i);
                return (d != null && d.setProperty(4098, new QRange(veRange.getmPosition(), veRange.getmTimeLength())) == 0 && d.setProperty(QEffect.PROP_AUDIO_FRAME_REPEAT_MODE, Integer.valueOf(z ? 1 : 0)) == 0) ? 0 : 1;
            }
        }
        return 1;
    }

    /* renamed from: b */
    public static int m24938b(QStoryboard qStoryboard, QClip qClip, int i) {
        if (m24976w(qStoryboard)) {
            i--;
        }
        return qStoryboard.moveClip(qClip, i);
    }

    /* renamed from: b */
    private static int m24939b(boolean z, QEffect qEffect) {
        QUserData qUserData = new QUserData(1);
        byte[] userData = qUserData.getUserData();
        if (qUserData.getUserDataLength() <= 0) {
            return 0;
        }
        userData[0] = z ? (byte) 1 : 0;
        return qEffect.setProperty(4101, qUserData);
    }

    /* renamed from: b */
    public static QEffect m24940b(QStoryboard qStoryboard, int i, int i2) {
        return C8537n.m24816b(qStoryboard.getDataClip(), i, i2);
    }

    /* renamed from: b */
    public static boolean m24941b(ArrayList<C8441b> arrayList, QStoryboard qStoryboard, int i) {
        if (qStoryboard == null || arrayList == null || arrayList.size() <= 0) {
            return false;
        }
        int clipCount = qStoryboard.getClipCount();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList(arrayList);
        if (clipCount > 0) {
            int duration = qStoryboard.getDuration();
            Collections.sort(arrayList3);
            Collections.reverse(arrayList3);
            Iterator it = arrayList3.iterator();
            int i2 = duration;
            int i3 = 0;
            while (it.hasNext()) {
                C8441b bVar = (C8441b) it.next();
                if (bVar.eed) {
                    QEffect d = m24947d(qStoryboard.getDataClip(), 1, bVar.aId());
                    if (d != null && !TextUtils.equals(C8538o.m24878i(d), bVar.aIf())) {
                    }
                }
                int GetTimeByClipPosition = qStoryboard.GetTimeByClipPosition(bVar.aIe());
                int GetIndexByClipPosition = qStoryboard.GetIndexByClipPosition(bVar.aIe());
                VeRange aIc = bVar.aIc();
                int i4 = aIc.getmPosition();
                int i5 = aIc.getmTimeLength();
                if (GetTimeByClipPosition <= -1) {
                    if (aIc.getmPosition() >= i2) {
                        arrayList2.add(Integer.valueOf(bVar.aId()));
                    } else {
                        if (aIc.getLimitValue() > i2) {
                            i5 = i2 - i4;
                            aIc.setmTimeLength(i5);
                        }
                        m24931a(qStoryboard, bVar.aId(), aIc, i5 > bVar.aIb().getmTimeLength());
                        i2 = aIc.getmPosition();
                        if (GetIndexByClipPosition <= i && i3 < aIc.getLimitValue()) {
                            i3 = aIc.getLimitValue();
                        }
                    }
                } else if (GetTimeByClipPosition < i2) {
                    if (GetTimeByClipPosition + i5 > i2) {
                        i5 = i2 - GetTimeByClipPosition;
                    }
                    aIc.setmPosition(GetTimeByClipPosition);
                    aIc.setmTimeLength(i5);
                    m24931a(qStoryboard, bVar.aId(), aIc, i5 == -1 || i5 > bVar.aIb().getmTimeLength());
                    i2 = aIc.getmPosition();
                    if (GetIndexByClipPosition <= i && i3 < aIc.getLimitValue()) {
                        i3 = aIc.getLimitValue();
                    }
                } else if (GetTimeByClipPosition + i5 < i3 || i3 >= duration) {
                    arrayList2.add(Integer.valueOf(bVar.aId()));
                } else {
                    if (GetTimeByClipPosition < i3) {
                        GetTimeByClipPosition = i3;
                    }
                    int i6 = duration - GetTimeByClipPosition;
                    if (i6 >= i5) {
                        i6 = i5;
                    }
                    aIc.setmPosition(GetTimeByClipPosition);
                    aIc.setmTimeLength(i6);
                    m24931a(qStoryboard, bVar.aId(), aIc, i6 > bVar.aIb().getmTimeLength());
                    if (GetIndexByClipPosition <= i && i3 < aIc.getLimitValue()) {
                        i3 = aIc.getLimitValue();
                    }
                }
            }
        } else {
            Iterator it2 = arrayList3.iterator();
            while (it2.hasNext()) {
                arrayList2.add(Integer.valueOf(((C8441b) it2.next()).aId()));
            }
        }
        Collections.sort(arrayList2);
        Collections.reverse(arrayList2);
        Iterator it3 = arrayList2.iterator();
        while (it3.hasNext()) {
            m24962m(qStoryboard, ((Integer) it3.next()).intValue());
        }
        return true;
    }

    /* renamed from: b */
    public static boolean m24942b(ArrayList<C8441b> arrayList, QStoryboard qStoryboard, int i, int i2) {
        if (qStoryboard == null || arrayList == null || arrayList.size() <= 0) {
            return false;
        }
        int clipCount = qStoryboard.getClipCount();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList(arrayList);
        if (clipCount > 0) {
            int duration = qStoryboard.getDuration();
            Collections.sort(arrayList3);
            Collections.reverse(arrayList3);
            Iterator it = arrayList3.iterator();
            int i3 = 0;
            int i4 = duration;
            while (it.hasNext()) {
                C8441b bVar = (C8441b) it.next();
                int GetTimeByClipPosition = qStoryboard.GetTimeByClipPosition(bVar.aIe());
                int GetIndexByClipPosition = qStoryboard.GetIndexByClipPosition(bVar.aIe());
                VeRange aIc = bVar.aIc();
                int i5 = aIc.getmPosition();
                int i6 = aIc.getmTimeLength();
                if (GetTimeByClipPosition <= -1) {
                    if (aIc.getmPosition() >= i4) {
                        arrayList2.add(Integer.valueOf(bVar.aId()));
                    } else {
                        if (aIc.getLimitValue() > i4) {
                            aIc.setmTimeLength(i4 - i5);
                        }
                        C8538o.m24843a(m24940b(qStoryboard, i, bVar.aId()), aIc);
                        i4 = aIc.getmPosition();
                        if (GetIndexByClipPosition <= i2 && i3 < aIc.getLimitValue()) {
                            i3 = aIc.getLimitValue();
                        }
                    }
                } else if (GetTimeByClipPosition < i4) {
                    if (GetTimeByClipPosition + i6 > i4) {
                        i6 = i4 - GetTimeByClipPosition;
                    }
                    aIc.setmPosition(GetTimeByClipPosition);
                    aIc.setmTimeLength(i6);
                    C8538o.m24843a(m24940b(qStoryboard, i, bVar.aId()), aIc);
                    i4 = aIc.getmPosition();
                    if (GetIndexByClipPosition <= i2 && i3 < aIc.getLimitValue()) {
                        i3 = aIc.getLimitValue();
                    }
                } else if (GetTimeByClipPosition + i6 < i3 || i3 >= duration) {
                    arrayList2.add(Integer.valueOf(bVar.aId()));
                } else {
                    if (GetTimeByClipPosition < i3) {
                        GetTimeByClipPosition = i3;
                    }
                    int i7 = duration - GetTimeByClipPosition;
                    if (i7 >= i6) {
                        i7 = i6;
                    }
                    aIc.setmPosition(GetTimeByClipPosition);
                    aIc.setmTimeLength(i7);
                    C8538o.m24843a(m24940b(qStoryboard, i, bVar.aId()), aIc);
                    if (GetIndexByClipPosition <= i2 && i3 < aIc.getLimitValue()) {
                        i3 = aIc.getLimitValue();
                    }
                }
            }
        } else {
            Iterator it2 = arrayList3.iterator();
            while (it2.hasNext()) {
                arrayList2.add(Integer.valueOf(((C8441b) it2.next()).aId()));
            }
        }
        Collections.sort(arrayList2);
        Collections.reverse(arrayList2);
        Iterator it3 = arrayList2.iterator();
        while (it3.hasNext()) {
            m24943c(qStoryboard, i, ((Integer) it3.next()).intValue());
        }
        return true;
    }

    /* renamed from: c */
    public static int m24943c(QStoryboard qStoryboard, int i, int i2) {
        QEffect b = m24940b(qStoryboard, i, i2);
        if (b != null) {
            return m24924a(qStoryboard, b);
        }
        return 0;
    }

    /* renamed from: c */
    public static boolean m24944c(ArrayList<C8441b> arrayList, QStoryboard qStoryboard, int i, int i2) {
        if (qStoryboard == null || arrayList == null || arrayList.size() <= 0) {
            return false;
        }
        int clipCount = qStoryboard.getClipCount();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList(arrayList);
        if (clipCount > 0) {
            int duration = qStoryboard.getDuration();
            Collections.sort(arrayList3);
            Collections.reverse(arrayList3);
            Iterator it = arrayList3.iterator();
            while (it.hasNext()) {
                C8441b bVar = (C8441b) it.next();
                int GetTimeByClipPosition = qStoryboard.GetTimeByClipPosition(bVar.aIe());
                VeRange aIc = bVar.aIc();
                int i3 = aIc.getmPosition();
                int i4 = aIc.getmTimeLength();
                if (GetTimeByClipPosition <= -1) {
                    if (aIc.getmPosition() >= duration) {
                        arrayList2.add(Integer.valueOf(bVar.aId()));
                    } else {
                        if (aIc.getLimitValue() > duration) {
                            aIc.setmTimeLength(duration - i3);
                        }
                        C8538o.m24843a(m24940b(qStoryboard, i, bVar.aId()), aIc);
                    }
                } else if (GetTimeByClipPosition >= duration) {
                    arrayList2.add(Integer.valueOf(bVar.aId()));
                } else {
                    if (GetTimeByClipPosition + i4 > duration) {
                        i4 = duration - GetTimeByClipPosition;
                    }
                    aIc.setmPosition(GetTimeByClipPosition);
                    aIc.setmTimeLength(i4);
                    C8538o.m24843a(m24940b(qStoryboard, i, bVar.aId()), aIc);
                }
            }
        } else {
            Iterator it2 = arrayList3.iterator();
            while (it2.hasNext()) {
                arrayList2.add(Integer.valueOf(((C8441b) it2.next()).aId()));
            }
        }
        Collections.sort(arrayList2);
        Collections.reverse(arrayList2);
        Iterator it3 = arrayList2.iterator();
        while (it3.hasNext()) {
            m24943c(qStoryboard, i, ((Integer) it3.next()).intValue());
        }
        return true;
    }

    /* renamed from: c */
    public static boolean m24945c(QStoryboard qStoryboard, int i, int i2, int i3) {
        boolean z = true;
        if (qStoryboard != null) {
            QClip dataClip = qStoryboard.getDataClip();
            if (dataClip != null) {
                int h = C8537n.m24827h(dataClip, i);
                if (h > 0 && i2 >= 0 && i2 < h) {
                    QEffect b = m24940b(qStoryboard, i, i2);
                    if (b != null) {
                        if (b.setProperty(QEffect.PROP_AUDIO_FRAME_MIXPERCENT, Integer.valueOf(i3)) != 0) {
                            z = false;
                        }
                        return z;
                    }
                }
            }
        }
        return true;
    }

    /* renamed from: d */
    public static VeMSize m24946d(QStoryboard qStoryboard, boolean z) {
        VeMSize veMSize;
        if (qStoryboard == null) {
            return null;
        }
        boolean B = m24893B(qStoryboard);
        if (B) {
            long longValue = m24894C(qStoryboard).longValue();
            if (longValue > 0 && !C8450a.m24468bm(longValue)) {
                VeMSize n = C8522g.m24679n(z, C8532k.m24769q(Long.valueOf(longValue)));
                if (n != null) {
                    return n;
                }
                if (C8450a.m24467bl(longValue)) {
                    return C8572y.aJq();
                }
            }
        }
        VeMSize v = m24975v(qStoryboard);
        if (v != null) {
            int i = v.width;
            int i2 = v.height;
            boolean z2 = true;
            boolean z3 = i > i2;
            VeMSize js = C8572y.m25096js(z);
            if (i * i2 > js.width * js.height || (!z3 ? i2 > js.width || i > js.height : i > js.width || i2 > js.height)) {
                if (!z3) {
                    v = new VeMSize(i2, i);
                }
                v = C8569v.m25057a(v, js);
                if (!z3) {
                    v = new VeMSize(v.height, v.width);
                }
            }
            if (B) {
                VeMSize veMSize2 = z3 ? new VeMSize(js.width, js.height) : new VeMSize(js.height, js.width);
                int i3 = v.width;
                int i4 = v.height;
                int i5 = veMSize2.width;
                int i6 = veMSize2.height;
                int i7 = (i4 * i5) / i6;
                if (i7 < i3) {
                    i4 = (i6 * i3) / i5;
                } else {
                    i3 = i7;
                }
                veMSize = new VeMSize(i3, i4);
            } else {
                veMSize = v;
            }
            v = C8572y.m25094g(veMSize);
            if (v.width < v.height) {
                QClip clip = qStoryboard.getClip(0);
                if (clip != null) {
                    if (((Integer) clip.getProperty(12289)).intValue() == 2) {
                        z2 = false;
                    }
                    if (!z2) {
                        VeMSize aJp = C8572y.aJp();
                        if (aJp != null && aJp.width > 0 && aJp.height > 0) {
                            v.width = aJp.width;
                            v.height = aJp.height;
                        }
                    }
                }
            }
        }
        return v;
    }

    /* renamed from: d */
    public static QEffect m24947d(QClip qClip, int i, int i2) {
        if (qClip == null || i2 < 0) {
            return null;
        }
        return qClip.getEffectByGroup(3, i, i2);
    }

    /* renamed from: d */
    public static QEffect m24948d(QStoryboard qStoryboard, int i, int i2) {
        if (qStoryboard != null) {
            QClip dataClip = qStoryboard.getDataClip();
            if (dataClip != null) {
                return dataClip.getEffectByGroup(2, i, i2);
            }
        }
        return null;
    }

    /* renamed from: d */
    public static boolean m24949d(QStoryboard qStoryboard, int i, int i2, int i3) {
        boolean z = true;
        if (qStoryboard != null) {
            QClip dataClip = qStoryboard.getDataClip();
            if (dataClip != null) {
                int j = m24957j(dataClip, i);
                if (j > 0 && i2 >= 0 && i2 < j) {
                    QEffect d = m24947d(dataClip, i, i2);
                    if (d != null) {
                        if (d.setProperty(QEffect.PROP_AUDIO_FRAME_MIXPERCENT, Integer.valueOf(i3)) != 0) {
                            z = false;
                        }
                        return z;
                    }
                }
            }
        }
        return true;
    }

    /* renamed from: e */
    public static int m24950e(QStoryboard qStoryboard, int i, int i2) {
        if (qStoryboard != null) {
            QClip dataClip = qStoryboard.getDataClip();
            if (dataClip != null) {
                int j = m24957j(dataClip, i);
                if (j > 0 && i2 >= 0 && i2 < j) {
                    return C8538o.m24887q(m24947d(dataClip, i, i2));
                }
            }
        }
        return 0;
    }

    /* renamed from: e */
    public static boolean m24951e(QStoryboard qStoryboard, boolean z) {
        QClip dataClip = qStoryboard.getDataClip();
        int j = m24957j(dataClip, 1);
        if (j > 0) {
            for (int i = 0; i < j; i++) {
                QEffect d = m24947d(dataClip, 1, i);
                if (d != null) {
                    C8538o.m24865b(d, z);
                }
            }
        }
        return true;
    }

    /* renamed from: f */
    public static SparseArray<ArrayList<ThumbInfo>> m24952f(QStoryboard qStoryboard, int i, int i2) {
        int i3;
        int i4;
        QStoryboard qStoryboard2 = qStoryboard;
        int i5 = i2;
        SparseArray<ArrayList<ThumbInfo>> sparseArray = new SparseArray<>();
        int D = m24895D(qStoryboard);
        int duration = qStoryboard.getDuration();
        int i6 = i;
        int i7 = 0;
        while (i7 < i6) {
            int i8 = i7 * i5;
            i7++;
            int i9 = i7 * i5;
            if (duration < i9) {
                i9 = duration;
            }
            QClipPosition GetClipPositionByTime = qStoryboard2.GetClipPositionByTime(i8);
            QClipPosition GetClipPositionByTime2 = qStoryboard2.GetClipPositionByTime(i9);
            ArrayList arrayList = new ArrayList();
            if (GetClipPositionByTime != null) {
                int GetIndexByClipPosition = qStoryboard2.GetIndexByClipPosition(GetClipPositionByTime);
                int i10 = D - 1;
                if (GetClipPositionByTime2 != null) {
                    i10 = qStoryboard2.GetIndexByClipPosition(GetClipPositionByTime2);
                }
                if (GetIndexByClipPosition == i10) {
                    ThumbInfo thumbInfo = new ThumbInfo();
                    thumbInfo.setPosition(i8);
                    thumbInfo.setDuration(i5);
                    arrayList.add(thumbInfo);
                } else {
                    int i11 = i10 - GetIndexByClipPosition;
                    if (i11 > 0) {
                        int i12 = i8;
                        int i13 = 0;
                        while (true) {
                            if (i13 > i11) {
                                break;
                            }
                            int i14 = GetIndexByClipPosition + i13;
                            QRange clipTimeRange = qStoryboard2.getClipTimeRange(i14);
                            if (clipTimeRange != null) {
                                VeRange veRange = new VeRange();
                                i4 = D;
                                i3 = duration;
                                veRange.setmPosition(clipTimeRange.get(0));
                                veRange.setmTimeLength(clipTimeRange.get(1));
                                QRange transitionTimeRange = qStoryboard2.getTransitionTimeRange(i14);
                                if (transitionTimeRange != null) {
                                    int i15 = transitionTimeRange.get(0);
                                    int i16 = transitionTimeRange.get(1);
                                    if (veRange.getmPosition() < i15) {
                                        int i17 = i15 + i16;
                                        if (veRange.getLimitValue() < i17) {
                                            veRange.setmTimeLength(i17 - veRange.getmPosition());
                                        }
                                    }
                                }
                                if (veRange.getmPosition() > i12 || veRange.getLimitValue() <= i12) {
                                    StringBuilder sb = new StringBuilder();
                                    sb.append("initIdentifyThumbInfo veRange.getmPosition() > sTime  veRange position=");
                                    sb.append(veRange.getmPosition());
                                    sb.append(";sTime=");
                                    sb.append(i12);
                                    C8554j.m25007e("XYStoryBoardUtil", sb.toString());
                                } else if (veRange.getLimitValue() < i9) {
                                    ThumbInfo thumbInfo2 = new ThumbInfo();
                                    thumbInfo2.setPosition(i12);
                                    thumbInfo2.setDuration(veRange.getLimitValue() - i12);
                                    arrayList.add(thumbInfo2);
                                    i12 = veRange.getLimitValue();
                                } else if (veRange.getLimitValue() >= i9) {
                                    ThumbInfo thumbInfo3 = new ThumbInfo();
                                    thumbInfo3.setPosition(i12);
                                    thumbInfo3.setDuration(i9 - i12);
                                    arrayList.add(thumbInfo3);
                                    break;
                                }
                            } else {
                                i4 = D;
                                i3 = duration;
                            }
                            i13++;
                            D = i4;
                            duration = i3;
                            int i18 = i2;
                        }
                    }
                }
                i4 = D;
                i3 = duration;
                sparseArray.put(i8, arrayList);
            } else {
                i4 = D;
                i3 = duration;
            }
            D = i4;
            duration = i3;
            i5 = i2;
        }
        return sparseArray;
    }

    /* renamed from: f */
    public static QClip m24953f(QStoryboard qStoryboard, int i) {
        if (qStoryboard != null && i >= 0 && i < qStoryboard.getClipCount()) {
            return qStoryboard.getClip(i);
        }
        return null;
    }

    /* renamed from: f */
    public static boolean m24954f(QStoryboard qStoryboard, boolean z) {
        boolean z2 = false;
        if (qStoryboard == null) {
            return false;
        }
        QClip dataClip = qStoryboard.getDataClip();
        if (dataClip == null) {
            return false;
        }
        if (dataClip.setProperty(12301, Boolean.valueOf(z)) == 0) {
            z2 = true;
        }
        return z2;
    }

    /* renamed from: g */
    public static void m24955g(QStoryboard qStoryboard, boolean z) {
        if (qStoryboard != null) {
            qStoryboard.setProperty(QStoryboard.PROP_RATIO_SETTED, Boolean.valueOf(z));
        }
    }

    /* renamed from: i */
    public static QClip m24956i(QStoryboard qStoryboard, int i) {
        if (qStoryboard != null) {
            int clipCount = qStoryboard.getClipCount();
            if (m24893B(qStoryboard)) {
                if (m24976w(qStoryboard) && i == 0) {
                    return (QCover) qStoryboard.getProperty(16392);
                }
                if (m24892A(qStoryboard) && i > clipCount) {
                    return (QCover) qStoryboard.getProperty(16393);
                }
                if (m24976w(qStoryboard)) {
                    i--;
                }
                return qStoryboard.getClip(i);
            } else if (i >= 0 && i < clipCount) {
                return qStoryboard.getClip(i);
            }
        }
        return null;
    }

    /* renamed from: j */
    public static int m24957j(QClip qClip, int i) {
        if (qClip != null) {
            return qClip.getEffectCountByGroup(3, i);
        }
        return 0;
    }

    /* renamed from: j */
    public static int m24958j(QStoryboard qStoryboard, int i) {
        return C8537n.m24827h(qStoryboard.getDataClip(), i);
    }

    /* renamed from: jx */
    public static VeMSize m24959jx(boolean z) {
        return C8549f.aJe().booleanValue() ? z ? C8459a.efC : C8459a.efz : C8466c.aIY() ? z ? C8459a.efA : C8459a.efx : z ? C8459a.efB : C8459a.efy;
    }

    /* renamed from: k */
    public static String m24960k(QStoryboard qStoryboard, int i) {
        String str = "";
        QClip i2 = m24956i(qStoryboard, i);
        return i2 == null ? str : C8537n.m24813b(qStoryboard.getEngine(), i2);
    }

    /* renamed from: l */
    public static ArrayList<C8441b> m24961l(QStoryboard qStoryboard, int i) {
        ArrayList<C8441b> arrayList = new ArrayList<>();
        if (qStoryboard != null) {
            QClip dataClip = qStoryboard.getDataClip();
            if (dataClip != null) {
                int j = m24957j(dataClip, i);
                if (j > 0) {
                    for (int i2 = 0; i2 < j; i2++) {
                        QEffect d = m24947d(dataClip, i, i2);
                        if (d != null && !C8538o.m24876h(d)) {
                            C8441b bVar = new C8441b();
                            bVar.groupId = i;
                            bVar.eef = C8538o.m24887q(d);
                            QRange qRange = (QRange) d.getProperty(4098);
                            bVar.mo34265a(C8561p.m25041d((QRange) d.getProperty(QEffect.PROP_AUDIO_FRAME_RANGE)));
                            VeRange d2 = C8561p.m25041d(qRange);
                            bVar.mo34273b(d2);
                            bVar.mo34281tW(i2);
                            bVar.mo34266a(qStoryboard.GetClipPositionByTime(d2.getmPosition()));
                            bVar.mo34279nG(C8538o.m24878i(d));
                            boolean z = true;
                            if (1 != i || !((Boolean) d.getProperty(QEffect.PROP_EFFECT_ADDBYTHEME)).booleanValue()) {
                                z = false;
                            }
                            bVar.eed = z;
                            arrayList.add(bVar);
                        }
                    }
                    return arrayList;
                }
            }
        }
        return arrayList;
    }

    /* renamed from: m */
    public static boolean m24962m(QStoryboard qStoryboard, int i) {
        if (qStoryboard != null) {
            QClip dataClip = qStoryboard.getDataClip();
            if (dataClip != null) {
                int j = m24957j(dataClip, 1);
                if (j > 0 && i >= 0 && i < j) {
                    QEffect d = m24947d(dataClip, 1, i);
                    if (d != null && dataClip.removeEffect(d) == 0) {
                        d.destory();
                    }
                }
            }
        }
        return true;
    }

    /* renamed from: n */
    public static int m24963n(QStoryboard qStoryboard, int i) {
        if (qStoryboard == null) {
            return 2;
        }
        QClip i2 = m24956i(qStoryboard, i);
        if (i2 != null) {
            qStoryboard.removeClip(i2);
            i2.unInit();
        }
        return 0;
    }

    /* renamed from: o */
    public static boolean m24964o(QStoryboard qStoryboard, int i) {
        if (qStoryboard == null) {
            return false;
        }
        int j = m24957j(qStoryboard.getDataClip(), 1);
        if (j > 0) {
            for (int i2 = 0; i2 < j; i2++) {
                m24949d(qStoryboard, 1, i2, i);
            }
        }
        return true;
    }

    /* renamed from: oO */
    private static int m24965oO(String str) {
        int oP = m24966oP(str);
        if (oP > 1) {
            return C8560o.m25040dH(0, oP - 1);
        }
        return 0;
    }

    /* renamed from: oP */
    public static int m24966oP(String str) {
        QStyle qStyle = new QStyle();
        if (qStyle.create(str, null, 1) != 0) {
            qStyle.destroy();
            return 0;
        }
        int configureCount = qStyle.getConfigureCount();
        qStyle.destroy();
        return configureCount;
    }

    /* renamed from: p */
    public static boolean m24967p(QStoryboard qStoryboard, int i) {
        QClip f = m24953f(qStoryboard, i);
        boolean z = false;
        if (f == null) {
            return false;
        }
        QClip qClip = new QClip();
        if (f.duplicate(qClip) != 0) {
            return false;
        }
        if (qStoryboard.insertClip(qClip, i) == 0) {
            z = true;
        }
        return z;
    }

    /* renamed from: q */
    public static int m24968q(QStoryboard qStoryboard, int i) {
        if (qStoryboard == null) {
            return 0;
        }
        QRange clipTimeRange = qStoryboard.getClipTimeRange(i);
        QRange transitionTimeRange = qStoryboard.getTransitionTimeRange(i);
        if (clipTimeRange == null) {
            return 0;
        }
        int i2 = clipTimeRange.get(0);
        int i3 = (clipTimeRange.get(1) + i2) - 1;
        if (transitionTimeRange != null) {
            int i4 = transitionTimeRange.get(0);
            int i5 = transitionTimeRange.get(1);
            if (i4 > i2 && i5 > 0) {
                return i4;
            }
        }
        return i3;
    }

    /* renamed from: r */
    public static List<Integer> m24969r(QStoryboard qStoryboard, int i) {
        ArrayList arrayList = new ArrayList();
        if (qStoryboard != null) {
            QClipPosition[] GetClipPositionArrayByTime = qStoryboard.GetClipPositionArrayByTime(i);
            if (GetClipPositionArrayByTime != null && GetClipPositionArrayByTime.length > 0) {
                for (QClipPosition GetIndexByClipPosition : GetClipPositionArrayByTime) {
                    arrayList.add(Integer.valueOf(qStoryboard.GetIndexByClipPosition(GetIndexByClipPosition)));
                }
            }
        }
        return arrayList;
    }

    /* renamed from: s */
    public static int m24970s(QStoryboard qStoryboard, int i) {
        if (qStoryboard != null) {
            QClipPosition GetClipPositionByTime = qStoryboard.GetClipPositionByTime(i);
            if (GetClipPositionByTime != null) {
                return qStoryboard.GetIndexByClipPosition(GetClipPositionByTime);
            }
        }
        return 0;
    }

    /* renamed from: t */
    public static int m24971t(QStoryboard qStoryboard, int i) {
        if (qStoryboard == null) {
            return 0;
        }
        QClipPosition GetClipPositionByIndex = qStoryboard.GetClipPositionByIndex(i);
        if (GetClipPositionByIndex == null) {
            return 0;
        }
        return qStoryboard.GetTimeByClipPosition(GetClipPositionByIndex);
    }

    /* renamed from: t */
    public static String m24972t(QClip qClip) {
        if (C8537n.m24829i(qClip, 2) > 0) {
            QEffect a = C8537n.m24797a(qClip, 2, 0);
            if (a != null) {
                return (String) a.getProperty(4103);
            }
        }
        return "";
    }

    /* renamed from: u */
    private static int m24973u(QStoryboard qStoryboard, int i) {
        if (qStoryboard == null) {
            return 0;
        }
        QRange clipTimeRange = qStoryboard.getClipTimeRange(i);
        if (clipTimeRange != null) {
            return clipTimeRange.get(0);
        }
        return 0;
    }

    /* renamed from: v */
    public static int m24974v(QStoryboard qStoryboard, int i) {
        int u = m24973u(qStoryboard, i);
        if (qStoryboard == null || i <= 0) {
            return u;
        }
        QRange clipTimeRange = qStoryboard.getClipTimeRange(i);
        QRange transitionTimeRange = qStoryboard.getTransitionTimeRange(i - 1);
        if (transitionTimeRange == null || transitionTimeRange.get(1) <= 0) {
            return u;
        }
        int i2 = transitionTimeRange.get(0) + transitionTimeRange.get(1);
        return i2 >= clipTimeRange.get(0) + clipTimeRange.get(1) ? (clipTimeRange.get(0) + clipTimeRange.get(1)) - 1 : i2;
    }

    /* renamed from: v */
    public static VeMSize m24975v(QStoryboard qStoryboard) {
        return C8537n.m24823f(m24976w(qStoryboard) ? m24956i(qStoryboard, 1) : m24956i(qStoryboard, 0));
    }

    /* renamed from: w */
    public static boolean m24976w(QStoryboard qStoryboard) {
        boolean z = false;
        if (qStoryboard == null) {
            return false;
        }
        if (qStoryboard.getProperty(16392) != null) {
            z = true;
        }
        return z;
    }

    /* renamed from: z */
    public static List<String> m24977z(QStoryboard qStoryboard) {
        if (qStoryboard != null) {
            int clipCount = qStoryboard.getClipCount();
            if (clipCount > 0) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < clipCount; i++) {
                    String a = C8537n.m24794a(qStoryboard.getClip(i), "xy_digital_watermark_code_key");
                    if (!TextUtils.isEmpty(a)) {
                        arrayList.add(a);
                        return arrayList;
                    }
                }
            }
        }
        return null;
    }
}
