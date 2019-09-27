package com.introvd.template.sdk.editor.p387a;

import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextUtils;
import com.introvd.template.sdk.C8382b;
import com.introvd.template.sdk.C8410e;
import com.introvd.template.sdk.editor.cache.C8441b;
import com.introvd.template.sdk.model.VeRange;
import com.introvd.template.sdk.model.editor.ScaleRotateViewState;
import com.introvd.template.sdk.model.editor.TextBubbleInfo.TextBubble;
import com.introvd.template.sdk.model.editor.TextEffectParams;
import com.introvd.template.sdk.p391g.C8450a;
import com.introvd.template.sdk.utils.C8554j;
import com.introvd.template.sdk.utils.C8562q;
import com.introvd.template.sdk.utils.VeMSize;
import com.introvd.template.sdk.utils.p394b.C8501a;
import com.introvd.template.sdk.utils.p394b.C8530i;
import com.introvd.template.sdk.utils.p394b.C8537n;
import com.introvd.template.sdk.utils.p394b.C8538o;
import com.introvd.template.sdk.utils.p394b.C8540q;
import java.util.ArrayList;
import xiaoying.engine.QEngine;
import xiaoying.engine.base.QRange;
import xiaoying.engine.base.QUtils;
import xiaoying.engine.base.QVideoInfo;
import xiaoying.engine.clip.QClip;
import xiaoying.engine.clip.QEffect;
import xiaoying.engine.clip.QKeyFrameTransformData.Value;
import xiaoying.engine.storyboard.QStoryboard;
import xiaoying.utils.QRect;

/* renamed from: com.introvd.template.sdk.editor.a.a */
public class C8419a {
    /* renamed from: a */
    public static int m24315a(QStoryboard qStoryboard, int i, int i2) {
        if (qStoryboard == null) {
            return 1;
        }
        QEffect b = m24333ud(i) ? C8540q.m24940b(qStoryboard, i, i2) : C8540q.m24947d(qStoryboard.getDataClip(), i, i2);
        StringBuilder sb = new StringBuilder();
        sb.append("deleteEffect groupId = ");
        sb.append(i);
        sb.append(", effectIndex = ");
        sb.append(i2);
        C8554j.m25006d("XYEffectDao", sb.toString());
        return C8540q.m24924a(qStoryboard, b);
    }

    /* renamed from: a */
    public static int m24316a(QStoryboard qStoryboard, int i, int i2, int i3) {
        if (qStoryboard == null || i < 0 || i2 < 0 || i3 < 0) {
            return 1;
        }
        QClip dataClip = qStoryboard.getDataClip();
        if (dataClip == null) {
            return 1;
        }
        QEffect b = C8537n.m24816b(dataClip, i, i2);
        return (b != null && dataClip.moveEffect(b, i3) == 0) ? 0 : 1;
    }

    /* renamed from: a */
    private static int m24317a(QStoryboard qStoryboard, int i, int i2, Point point, VeMSize veMSize, int i3) {
        QEffect b = C8540q.m24940b(qStoryboard, i, i2);
        if (b == null || !C8538o.m24869c(i3, b)) {
            return -1;
        }
        ScaleRotateViewState scaleRotateViewState = null;
        if (6 == i) {
            return i2;
        }
        if (i == 3) {
            scaleRotateViewState = C8538o.m24850a(C8501a.aJs().aJv(), b, veMSize);
        } else if (i == 8 || i == 20 || i == 40) {
            scaleRotateViewState = C8538o.m24851a(b, veMSize);
        }
        if (scaleRotateViewState == null) {
            return -1;
        }
        RectF a = m24323a(i, b, i3, veMSize, scaleRotateViewState);
        if (a != null && C8530i.m24753a(point, 0.0f, new Rect((int) a.left, (int) a.top, (int) a.right, (int) a.bottom))) {
            return i2;
        }
        return -1;
    }

    /* renamed from: a */
    public static int m24318a(QStoryboard qStoryboard, int i, int i2, VeRange veRange) {
        if (qStoryboard == null || veRange == null) {
            return 1;
        }
        QEffect b = C8540q.m24940b(qStoryboard, i, i2);
        return (b == null || b.setProperty(4098, new QRange(veRange.getmPosition(), veRange.getmTimeLength())) == 0) ? 0 : 1;
    }

    /* renamed from: a */
    public static int m24319a(QStoryboard qStoryboard, int i, int i2, VeRange veRange, boolean z) {
        if (qStoryboard == null || veRange == null) {
            return 1;
        }
        QEffect d = C8540q.m24947d(qStoryboard.getDataClip(), i, i2);
        return (d == null || (d.setProperty(4098, new QRange(veRange.getmPosition(), veRange.getmTimeLength())) == 0 && d.setProperty(QEffect.PROP_AUDIO_FRAME_REPEAT_MODE, Integer.valueOf(z ? 1 : 0)) == 0)) ? 0 : 1;
    }

    /* JADX WARNING: Removed duplicated region for block: B:45:0x00c1 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00c2 A[RETURN] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int m24320a(xiaoying.engine.storyboard.QStoryboard r8, com.introvd.template.sdk.editor.cache.C8441b r9, int r10, com.introvd.template.sdk.utils.VeMSize r11, com.introvd.template.sdk.utils.VeMSize r12) {
        /*
            r0 = 1
            if (r8 == 0) goto L_0x00c3
            if (r9 == 0) goto L_0x00c3
            com.introvd.template.sdk.model.VeRange r1 = r9.aIc()
            if (r1 != 0) goto L_0x000d
            goto L_0x00c3
        L_0x000d:
            if (r11 != 0) goto L_0x0010
            return r0
        L_0x0010:
            xiaoying.engine.clip.QClip r8 = r8.getDataClip()
            if (r8 != 0) goto L_0x0017
            return r0
        L_0x0017:
            int r1 = r9.groupId
            xiaoying.engine.clip.QEffect r2 = com.introvd.template.sdk.utils.p394b.C8537n.m24816b(r8, r1, r10)
            if (r2 != 0) goto L_0x0020
            return r0
        L_0x0020:
            r8 = 6
            r10 = 0
            if (r8 != r1) goto L_0x004d
            com.introvd.template.sdk.model.editor.TextEffectParams r8 = new com.introvd.template.sdk.model.editor.TextEffectParams
            r8.<init>()
            java.lang.String r11 = r9.aIf()
            r8.setmEffectStylePath(r11)
            com.introvd.template.sdk.model.VeRange r11 = r9.aIc()
            int r11 = r11.getmPosition()
            r8.setmTextRangeStart(r11)
            com.introvd.template.sdk.model.VeRange r11 = r9.aIc()
            int r11 = r11.getmTimeLength()
            r8.setmTextRangeLen(r11)
            android.graphics.Rect r9 = r9.eeh
            com.introvd.template.sdk.utils.p394b.C8538o.m24844a(r2, r8, r9, r12)
            goto L_0x00be
        L_0x004d:
            boolean r8 = m24333ud(r1)
            if (r8 == 0) goto L_0x00be
            com.introvd.template.sdk.model.editor.ScaleRotateViewState r8 = r9.aIg()
            com.introvd.template.sdk.model.editor.TextEffectParams r3 = m24331s(r8)
            if (r3 != 0) goto L_0x005e
            return r0
        L_0x005e:
            com.introvd.template.sdk.model.VeRange r8 = r9.aIc()
            if (r8 == 0) goto L_0x0072
            int r9 = r8.getmPosition()
            r3.setmTextRangeStart(r9)
            int r8 = r8.getmTimeLength()
            r3.setmTextRangeLen(r8)
        L_0x0072:
            android.graphics.RectF r8 = r3.getmTextRect()
            int r9 = r11.width
            int r11 = r11.height
            android.graphics.Rect r4 = com.introvd.template.sdk.utils.C8562q.m25042a(r8, r9, r11)
            r8 = -1
            r9 = 8
            if (r1 == r9) goto L_0x00b9
            r9 = 20
            if (r1 != r9) goto L_0x0088
            goto L_0x00b9
        L_0x0088:
            r9 = 40
            if (r1 != r9) goto L_0x00b1
            xiaoying.engine.base.QStyle$QEffectPropertyData r8 = r2.getEffectPropData(r0)
            if (r8 == 0) goto L_0x009a
            xiaoying.engine.base.QStyle$QEffectPropertyData r8 = r2.getEffectPropData(r0)
            int r8 = r8.mValue
            r6 = r8
            goto L_0x009b
        L_0x009a:
            r6 = 0
        L_0x009b:
            r8 = 2
            xiaoying.engine.base.QStyle$QEffectPropertyData r9 = r2.getEffectPropData(r8)
            if (r9 == 0) goto L_0x00aa
            xiaoying.engine.base.QStyle$QEffectPropertyData r8 = r2.getEffectPropData(r8)
            int r8 = r8.mValue
            r7 = r8
            goto L_0x00ab
        L_0x00aa:
            r7 = 0
        L_0x00ab:
            r5 = r12
            int r8 = com.introvd.template.sdk.utils.p394b.C8538o.m24845a(r2, r3, r4, r5, r6, r7)
            goto L_0x00bf
        L_0x00b1:
            r9 = 3
            if (r1 != r9) goto L_0x00bf
            int r8 = com.introvd.template.sdk.utils.p394b.C8538o.m24862b(r2, r3, r4, r12)
            goto L_0x00bf
        L_0x00b9:
            int r8 = com.introvd.template.sdk.utils.p394b.C8538o.m24866c(r2, r3, r4, r12)
            goto L_0x00bf
        L_0x00be:
            r8 = 0
        L_0x00bf:
            if (r8 == 0) goto L_0x00c2
            return r0
        L_0x00c2:
            return r10
        L_0x00c3:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.sdk.editor.p387a.C8419a.m24320a(xiaoying.engine.storyboard.QStoryboard, com.introvd.template.sdk.editor.cache.b, int, com.introvd.template.sdk.utils.VeMSize, com.introvd.template.sdk.utils.VeMSize):int");
    }

    /* renamed from: a */
    public static int m24321a(QStoryboard qStoryboard, C8441b bVar, VeMSize veMSize, VeMSize veMSize2) {
        int i;
        C8441b bVar2 = bVar;
        VeMSize veMSize3 = veMSize;
        if (qStoryboard == null || bVar2 == null || bVar.aIc() == null) {
            return 1;
        }
        int i2 = -1;
        int i3 = bVar2.groupId;
        QEngine aJv = C8501a.aJs().aJv();
        if (6 == i3) {
            TextEffectParams textEffectParams = new TextEffectParams();
            textEffectParams.setmEffectStylePath(bVar.aIf());
            VeRange aIc = bVar.aIc();
            textEffectParams.setmTextRangeStart(aIc.getmPosition());
            textEffectParams.setmTextRangeLen(aIc.getmTimeLength());
            i2 = C8538o.m24842a(qStoryboard.getDataClip(), aJv, textEffectParams, bVar2.eeh, veMSize2, C8537n.m24784a(qStoryboard.getDataClip(), 6, 100.0f) + 5.0E-4f);
        } else if (m24333ud(i3)) {
            TextEffectParams s = m24331s(bVar.aIg());
            if (s == null) {
                return 1;
            }
            VeRange aIc2 = bVar.aIc();
            s.setmTextRangeStart(aIc2.getmPosition());
            s.setmTextRangeLen(aIc2.getmTimeLength());
            Rect a = C8562q.m25042a(s.getmTextRect(), veMSize3.width, veMSize3.height);
            if (TextUtils.isEmpty(s.getmEffectStylePath()) || a == null) {
                return 1;
            }
            QClip dataClip = qStoryboard.getDataClip();
            if (dataClip == null) {
                return 1;
            }
            s.mLayerID = C8537n.m24784a(dataClip, i3, (float) m24332uc(i3)) + 5.0E-4f;
            if (i3 == 8 || i3 == 20 || i3 == 40 || i3 == 50) {
                VeMSize veMSize4 = veMSize2;
                i = C8537n.m24789a(dataClip, aJv, s, i3, a, veMSize2);
            } else if (i3 == 3) {
                i = C8537n.m24790a(dataClip, aJv, s, a, veMSize2);
            }
            i2 = i;
        } else if (1 == i3) {
            i2 = C8540q.m24919a(aJv, qStoryboard, bVar.aIf(), bVar.aIc().getmPosition(), bVar.aIc().getmTimeLength(), bVar.aIb().getmPosition(), bVar.aIb().getmTimeLength(), bVar2.eef);
        } else if (4 == i3) {
            String aIf = bVar.aIf();
            int b = C8450a.m24465b(aIf, aJv);
            if (11 == b || 13 == b) {
                return 1;
            }
            QVideoInfo videoInfo = QUtils.getVideoInfo(aJv, aIf);
            if (videoInfo == null) {
                return 1;
            }
            int i4 = videoInfo.get(6);
            StringBuilder sb = new StringBuilder();
            sb.append("SetBackgroundMusic: file = ");
            sb.append(aIf);
            sb.append(" duration = ");
            sb.append(i4);
            C8554j.m25008i("XYEffectDao", sb.toString());
            i2 = C8540q.m24920a(qStoryboard, -1, aIf, 0, i4, bVar.aIc().getmPosition(), bVar.aIc().getmTimeLength(), bVar2.eef, true);
        }
        return i2 != 0 ? 1 : 0;
    }

    /* renamed from: a */
    public static int m24322a(QStoryboard qStoryboard, VeMSize veMSize, Point point, int i, int i2) {
        if (qStoryboard == null || veMSize == null) {
            return -1;
        }
        int j = C8540q.m24958j(qStoryboard, i2);
        for (int i3 = 0; i3 < j; i3++) {
            int a = m24317a(qStoryboard, i2, i3, point, veMSize, i);
            if (a >= 0) {
                return a;
            }
        }
        return -1;
    }

    /* renamed from: a */
    public static RectF m24323a(int i, QEffect qEffect, int i2, VeMSize veMSize, ScaleRotateViewState scaleRotateViewState) {
        RectF rectF;
        if (scaleRotateViewState == null) {
            return null;
        }
        if (!m24334ue(i)) {
            rectF = scaleRotateViewState.getRectArea();
        } else if (qEffect == null) {
            return scaleRotateViewState.getRectArea();
        } else {
            rectF = m24324a(qEffect, i2, veMSize);
            if (rectF == null) {
                rectF = scaleRotateViewState.getRectArea();
            }
        }
        return rectF;
    }

    /* renamed from: a */
    private static RectF m24324a(QEffect qEffect, int i, VeMSize veMSize) {
        if (qEffect == null) {
            return null;
        }
        QRange qRange = (QRange) qEffect.getProperty(4098);
        if (qRange == null) {
            return null;
        }
        Value keyframeTransformValue = qEffect.getKeyframeTransformValue(i - qRange.get(0));
        if (keyframeTransformValue == null || veMSize == null) {
            return null;
        }
        QRect qRect = (QRect) qEffect.getProperty(QEffect.PROP_EFFECT_KEYFRAME_TRANSFORM_ORIGIN_REGION);
        if (qRect == null) {
            return null;
        }
        QRect a = C8538o.m24853a(keyframeTransformValue, qRect);
        if (a == null) {
            return null;
        }
        Rect b = C8530i.m24758b(new Rect(a.left, a.top, a.right, a.bottom), veMSize.width, veMSize.height);
        if (b == null) {
            return null;
        }
        return new RectF(b);
    }

    /* renamed from: a */
    public static ArrayList<C8441b> m24325a(QStoryboard qStoryboard, int i, VeMSize veMSize) {
        return m24333ud(i) ? C8538o.m24864b(qStoryboard, i, veMSize) : C8540q.m24961l(qStoryboard, i);
    }

    /* renamed from: a */
    public static boolean m24326a(QStoryboard qStoryboard, C8441b bVar, Point point, int i, VeMSize veMSize) {
        if (!bVar.aIc().contains2(i)) {
            return false;
        }
        if (bVar.groupId == 6) {
            return true;
        }
        ScaleRotateViewState aIg = bVar.aIg();
        if (aIg == null) {
            return false;
        }
        RectF a = m24323a(bVar.groupId, C8540q.m24940b(qStoryboard, bVar.groupId, bVar.aId()), i, veMSize, aIg);
        if (a == null) {
            return false;
        }
        return C8530i.m24753a(point, 0.0f, new Rect((int) a.left, (int) a.top, (int) a.right, (int) a.bottom));
    }

    /* renamed from: b */
    public static float m24327b(int i, QEffect qEffect, int i2, VeMSize veMSize, ScaleRotateViewState scaleRotateViewState) {
        float f;
        if (scaleRotateViewState == null) {
            return 0.0f;
        }
        if (m24334ue(i)) {
            Float b = m24328b(qEffect, i2, veMSize);
            f = b != null ? b.floatValue() : scaleRotateViewState.mDegree;
        } else {
            f = scaleRotateViewState.mDegree;
        }
        return f;
    }

    /* renamed from: b */
    private static Float m24328b(QEffect qEffect, int i, VeMSize veMSize) {
        if (qEffect == null) {
            return null;
        }
        QRange qRange = (QRange) qEffect.getProperty(4098);
        if (qRange == null) {
            return null;
        }
        Value keyframeTransformValue = qEffect.getKeyframeTransformValue(i - qRange.get(0));
        if (keyframeTransformValue == null || veMSize == null) {
            return null;
        }
        return Float.valueOf(keyframeTransformValue.rotation);
    }

    /* renamed from: b */
    public static boolean m24329b(QStoryboard qStoryboard, int i, int i2, int i3) {
        return m24333ud(i) ? C8540q.m24945c(qStoryboard, i, i2, i3) : C8540q.m24949d(qStoryboard, i, i2, i3);
    }

    /* renamed from: e */
    public static int m24330e(QStoryboard qStoryboard, int i) {
        if (qStoryboard == null) {
            return 1;
        }
        ArrayList a = m24325a(qStoryboard, i, (VeMSize) null);
        if (a == null || a.size() == 0) {
            return 0;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("deleteAllEffect groupId = ");
        sb.append(i);
        sb.append(", size = ");
        sb.append(a.size());
        C8554j.m25006d("XYEffectDao", sb.toString());
        for (int size = a.size() - 1; size >= 0; size--) {
            m24315a(qStoryboard, i, size);
        }
        return 0;
    }

    /* renamed from: s */
    private static TextEffectParams m24331s(ScaleRotateViewState scaleRotateViewState) {
        RectF rectF = null;
        if (scaleRotateViewState == null || scaleRotateViewState.mStylePath == null) {
            return null;
        }
        RectF t = C8530i.m24763t(scaleRotateViewState);
        if (t != null) {
            rectF = new RectF(t.left, t.top, t.right, t.bottom);
        }
        TextEffectParams textEffectParams = new TextEffectParams();
        TextBubble textBubble = scaleRotateViewState.getTextBubble();
        if (textBubble != null) {
            textEffectParams.setmTxtColor(textBubble.mTextColor);
            textEffectParams.setmTxtContent(textBubble.mText);
            textEffectParams.setmFontPath(textBubble.mFontPath);
            textEffectParams.setmStrokeInfo(textBubble.mStrokeInfo);
            textEffectParams.setmShadowInfo(textBubble.mShadowInfo);
            textEffectParams.setmTextAlignment(textBubble.mTextAlignment);
        }
        textEffectParams.setVersion(scaleRotateViewState.mVersion);
        textEffectParams.setmAngle(scaleRotateViewState.mDegree);
        textEffectParams.setmStyleDuration(scaleRotateViewState.mMinDuration);
        textEffectParams.setHorFlip(scaleRotateViewState.isHorFlip);
        textEffectParams.setVerFlip(scaleRotateViewState.isVerFlip);
        textEffectParams.setmEffectStylePath(scaleRotateViewState.mStylePath);
        textEffectParams.setApplyInWholeClip(false);
        textEffectParams.setmTextRect(rectF);
        textEffectParams.setAnimOn(scaleRotateViewState.isAnimOn());
        textEffectParams.setmAlpha(scaleRotateViewState.mAlpha);
        Long valueOf = Long.valueOf(0);
        C8382b aHa = C8410e.aGX().aHa();
        if (aHa != null) {
            valueOf = aHa.mo29495ig(scaleRotateViewState.mStylePath);
        }
        textEffectParams.setmTemplateId(valueOf.longValue());
        return textEffectParams;
    }

    /* renamed from: uc */
    private static int m24332uc(int i) {
        if (i == 3) {
            return 1000;
        }
        if (i == 6) {
            return 100;
        }
        if (i == 8) {
            return 200;
        }
        if (i == 20) {
            return 50;
        }
        if (i != 40) {
            return i != 50 ? 0 : 1500;
        }
        return 40;
    }

    /* renamed from: ud */
    private static boolean m24333ud(int i) {
        return 8 == i || 20 == i || 6 == i || 3 == i || 40 == i || 50 == i;
    }

    /* renamed from: ue */
    public static boolean m24334ue(int i) {
        return 8 == i || 20 == i || 6 == i || 3 == i || 40 == i;
    }
}
