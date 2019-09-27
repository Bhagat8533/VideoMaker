package com.introvd.template.sdk.utils.p394b;

import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextUtils;
import com.introvd.template.sdk.editor.C8418a;
import com.introvd.template.sdk.editor.cache.C8441b;
import com.introvd.template.sdk.editor.p387a.C8419a;
import com.introvd.template.sdk.model.StylePositionModel;
import com.introvd.template.sdk.model.VeRange;
import com.introvd.template.sdk.model.editor.ScaleRotateViewState;
import com.introvd.template.sdk.model.editor.TextBubbleInfo;
import com.introvd.template.sdk.model.editor.TextBubbleInfo.TextBubble;
import com.introvd.template.sdk.model.editor.TextEffectParams;
import com.introvd.template.sdk.p383c.C8398b;
import com.introvd.template.sdk.p391g.C8450a;
import com.introvd.template.sdk.utils.C8548e;
import com.introvd.template.sdk.utils.C8554j;
import com.introvd.template.sdk.utils.C8561p;
import com.introvd.template.sdk.utils.VeMSize;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import xiaoying.engine.QEngine;
import xiaoying.engine.base.QBubbleTemplateInfo;
import xiaoying.engine.base.QBubbleTextSource;
import xiaoying.engine.base.QBubbleTextSource.QTextExtraEffect;
import xiaoying.engine.base.QRange;
import xiaoying.engine.base.QStyle;
import xiaoying.engine.base.QStyle.QAnimatedFrameTemplateInfo;
import xiaoying.engine.base.QStyle.QEffectPropertyData;
import xiaoying.engine.base.QTextMulInfo;
import xiaoying.engine.base.QTextMulInfo.QMultiBTInfo;
import xiaoying.engine.base.QUtils;
import xiaoying.engine.clip.QClip;
import xiaoying.engine.clip.QEffect;
import xiaoying.engine.clip.QEffect.QEffectExternalSource;
import xiaoying.engine.clip.QFade;
import xiaoying.engine.clip.QKeyFrameTransformData;
import xiaoying.engine.clip.QKeyFrameTransformData.Value;
import xiaoying.engine.clip.QMediaSource;
import xiaoying.engine.clip.QUserData;
import xiaoying.engine.storyboard.QClipPosition;
import xiaoying.engine.storyboard.QStoryboard;
import xiaoying.utils.QPoint;
import xiaoying.utils.QRect;
import xiaoying.utils.QSize;

/* renamed from: com.introvd.template.sdk.utils.b.o */
public class C8538o {
    /* renamed from: N */
    public static int m24841N(String str, int i) {
        if (i < 2000 && m24880jM(str)) {
            int i2 = 1;
            while (true) {
                i *= i2;
                if (i > 2000) {
                    break;
                }
                i2++;
            }
        }
        return i;
    }

    /* renamed from: a */
    public static int m24842a(QClip qClip, QEngine qEngine, TextEffectParams textEffectParams, Rect rect, VeMSize veMSize, float f) {
        if (qClip == null || qEngine == null) {
            return 1;
        }
        QEffect qEffect = new QEffect();
        return (qEffect.create(qEngine, 2, 2, 6, f) == 0 && qClip.insertEffect(qEffect) == 0 && m24844a(qEffect, textEffectParams, rect, veMSize) == 0) ? 0 : 1;
    }

    /* renamed from: a */
    public static int m24843a(QEffect qEffect, VeRange veRange) {
        QRange qRange = new QRange(veRange.getmPosition(), veRange.getmTimeLength());
        if (qEffect != null) {
            int property = qEffect.setProperty(4098, qRange);
            m24856a(qEffect, qRange);
            if (property != 0) {
                return 1;
            }
        }
        return 0;
    }

    /* renamed from: a */
    public static int m24844a(QEffect qEffect, TextEffectParams textEffectParams, Rect rect, VeMSize veMSize) {
        if (qEffect == null) {
            return 1;
        }
        if (textEffectParams.getmTextRangeLen() > 0 && qEffect.setProperty(4098, new QRange(textEffectParams.getmTextRangeStart(), textEffectParams.getmTextRangeLen())) != 0) {
            return 1;
        }
        QRect s = m24889s(qEffect);
        if (s == null) {
            s = new QRect(rect.left, rect.top, rect.right, rect.bottom);
        }
        qEffect.setProperty(4102, s);
        QPoint qPoint = new QPoint();
        qPoint.f3733x = veMSize.width;
        qPoint.f3734y = veMSize.height;
        return (qEffect.setProperty(QEffect.PROP_VIDEO_FRAME_BG_RESOLUTION, qPoint) == 0 && qEffect.setProperty(4104, new QMediaSource(0, false, textEffectParams.getmEffectStylePath())) == 0) ? 0 : 1;
    }

    /* renamed from: a */
    public static int m24845a(QEffect qEffect, TextEffectParams textEffectParams, Rect rect, VeMSize veMSize, int i, int i2) {
        if (qEffect == null || textEffectParams == null || qEffect.setProperty(4104, new QMediaSource(0, false, textEffectParams.getmEffectStylePath())) != 0) {
            return 1;
        }
        QEffectPropertyData qEffectPropertyData = new QEffectPropertyData();
        qEffectPropertyData.mID = 1;
        qEffectPropertyData.mValue = i;
        if (qEffect.setProperty(QEffect.PROP_EFFECT_PROPDATA, qEffectPropertyData) != 0) {
            return 1;
        }
        qEffectPropertyData.mID = 2;
        qEffectPropertyData.mValue = i2;
        if (qEffect.setProperty(QEffect.PROP_EFFECT_PROPDATA, qEffectPropertyData) != 0) {
            return 1;
        }
        if (m24848a(qEffect, textEffectParams.isApplyInWholeClip(), textEffectParams.getmTextRangeStart(), textEffectParams.getmTextRangeLen()) != 0) {
            return 1;
        }
        if (rect != null) {
            qEffect.setProperty(4102, new QRect(rect.left, rect.top, rect.right, rect.bottom));
        }
        QPoint qPoint = new QPoint();
        qPoint.f3733x = veMSize.width;
        qPoint.f3734y = veMSize.height;
        return (qEffect.setProperty(QEffect.PROP_VIDEO_FRAME_BG_RESOLUTION, qPoint) == 0 && qEffect.setProperty(QEffect.PROP_VIDEO_FRAME_ROTATION, Float.valueOf(textEffectParams.getmAngle())) == 0 && qEffect.setProperty(QEffect.PROP_VIDEO_FRAME_X_FLIP, Boolean.valueOf(textEffectParams.isHorFlip())) == 0 && qEffect.setProperty(QEffect.PROP_VIDEO_FRAME_Y_FLIP, Boolean.valueOf(textEffectParams.isVerFlip())) == 0 && qEffect.setProperty(QEffect.PROP_EFFECT_FRAME_STATIC_PICTURE, Boolean.valueOf(textEffectParams.bShowStaticPicture)) == 0) ? 0 : 1;
    }

    /* renamed from: a */
    public static int m24846a(QEffect qEffect, String str) {
        if (qEffect == null) {
            return -1;
        }
        QEffectExternalSource qEffectExternalSource = new QEffectExternalSource();
        qEffectExternalSource.mDataRange = new QRange(0, -1);
        qEffectExternalSource.mSource = new QMediaSource(0, false, str);
        return qEffect.setExternalSource(0, qEffectExternalSource);
    }

    /* renamed from: a */
    public static int m24847a(QEffect qEffect, boolean z, int i) {
        if (qEffect == null) {
            return 2;
        }
        int property = qEffect.setProperty(QEffect.PROP_AUDIO_FRAME_FADEIN, new QFade(m24890u(z, i), 0, 100));
        if (property != 0) {
            return 1;
        }
        return property;
    }

    /* renamed from: a */
    public static int m24848a(QEffect qEffect, boolean z, int i, int i2) {
        return qEffect.setProperty(4098, z ? new QRange(0, -1) : new QRange(i, i2));
    }

    /* renamed from: a */
    public static int m24849a(boolean z, String str, QEffect qEffect) {
        if (TextUtils.isEmpty(str)) {
            return 1;
        }
        byte[] bytes = str.getBytes(Charset.forName("UTF-8"));
        QUserData qUserData = new QUserData(bytes.length + 1);
        byte[] userData = qUserData.getUserData();
        if (qUserData.getUserDataLength() > 0) {
            userData[0] = z ? (byte) 1 : 0;
            for (int i = 1; i < qUserData.getUserDataLength(); i++) {
                userData[i] = bytes[i - 1];
            }
        }
        return qEffect.setProperty(4101, qUserData);
    }

    /* JADX WARNING: Removed duplicated region for block: B:49:0x012f  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x013c  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0150 A[Catch:{ Exception -> 0x0155 }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x015d  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.introvd.template.sdk.model.editor.ScaleRotateViewState m24850a(xiaoying.engine.QEngine r17, xiaoying.engine.clip.QEffect r18, com.introvd.template.sdk.utils.VeMSize r19) {
        /*
            r0 = r17
            r1 = r18
            r2 = r19
            if (r0 == 0) goto L_0x0183
            if (r1 != 0) goto L_0x000c
            goto L_0x0183
        L_0x000c:
            if (r2 == 0) goto L_0x0181
            int r4 = r2.width
            if (r4 <= 0) goto L_0x0181
            int r4 = r2.height
            if (r4 > 0) goto L_0x0018
            goto L_0x0181
        L_0x0018:
            int r4 = r2.width
            int r5 = r2.height
            int r4 = xiaoying.engine.base.QUtils.getLayoutMode(r4, r5)
            java.util.Locale r5 = com.introvd.template.sdk.p383c.C8398b.mLocale
            int r5 = com.introvd.template.sdk.p391g.C8450a.m24471c(r5)
            r6 = 4185(0x1059, float:5.864E-42)
            java.lang.Object r6 = r1.getProperty(r6)
            xiaoying.engine.clip.QMediaMulSource r6 = (xiaoying.engine.clip.QMediaMulSource) r6
            if (r6 == 0) goto L_0x017f
            int r7 = r6.getSourceCount()
            if (r7 == 0) goto L_0x017f
            java.lang.Object[] r7 = r6.getSource()
            if (r7 != 0) goto L_0x003e
            goto L_0x017f
        L_0x003e:
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            r9 = 0
            r10 = 0
        L_0x0045:
            int r11 = r6.getSourceCount()
            if (r9 >= r11) goto L_0x00dd
            java.lang.Object[] r11 = r6.getSource()
            int r11 = r11.length
            if (r9 >= r11) goto L_0x00d8
            java.lang.Object[] r11 = r6.getSource()
            r11 = r11[r9]
            boolean r13 = r11 instanceof xiaoying.engine.base.QBubbleTextSource
            if (r13 == 0) goto L_0x00d8
            xiaoying.engine.base.QBubbleTextSource r11 = (xiaoying.engine.base.QBubbleTextSource) r11
            if (r9 != 0) goto L_0x0061
            r10 = r11
        L_0x0061:
            com.introvd.template.sdk.model.editor.TextBubbleInfo$TextBubble r13 = new com.introvd.template.sdk.model.editor.TextBubbleInfo$TextBubble
            r13.<init>()
            int r14 = r11.paramId
            r13.mParamID = r14
            xiaoying.utils.QRect r14 = r11.regionRatio
            if (r14 == 0) goto L_0x0081
            android.graphics.RectF r15 = new android.graphics.RectF
            int r3 = r14.left
            float r3 = (float) r3
            int r8 = r14.top
            float r8 = (float) r8
            int r12 = r14.right
            float r12 = (float) r12
            int r14 = r14.bottom
            float r14 = (float) r14
            r15.<init>(r3, r8, r12, r14)
            r13.mTextRegion = r15
        L_0x0081:
            int r3 = r11.textColor
            r13.mTextColor = r3
            java.lang.String r3 = r11.text
            r13.mText = r3
            xiaoying.engine.base.QBubbleTextSource$QTextExtraEffect r3 = r11.tee
            if (r3 == 0) goto L_0x00b8
            float r8 = r3.shadowBlurRadius
            r12 = 0
            int r8 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
            if (r8 <= 0) goto L_0x00b8
            com.introvd.template.sdk.model.editor.ShadowInfo r8 = r13.mShadowInfo
            r12 = 1
            r8.setbEnableShadow(r12)
            com.introvd.template.sdk.model.editor.ShadowInfo r8 = r13.mShadowInfo
            float r12 = r3.shadowBlurRadius
            r8.setmShadowBlurRadius(r12)
            com.introvd.template.sdk.model.editor.ShadowInfo r8 = r13.mShadowInfo
            int r12 = r3.shadowColor
            r8.setmShadowColor(r12)
            com.introvd.template.sdk.model.editor.ShadowInfo r8 = r13.mShadowInfo
            float r12 = r3.shadowXShift
            r8.setmShadowXShift(r12)
            com.introvd.template.sdk.model.editor.ShadowInfo r8 = r13.mShadowInfo
            float r12 = r3.shadowYShift
            r8.setmShadowYShift(r12)
            r12 = 0
            goto L_0x00be
        L_0x00b8:
            com.introvd.template.sdk.model.editor.ShadowInfo r8 = r13.mShadowInfo
            r12 = 0
            r8.setbEnableShadow(r12)
        L_0x00be:
            if (r3 == 0) goto L_0x00cc
            com.introvd.template.sdk.model.editor.StrokeInfo r8 = r13.mStrokeInfo
            int r14 = r3.strokeColor
            r8.strokeColor = r14
            com.introvd.template.sdk.model.editor.StrokeInfo r8 = r13.mStrokeInfo
            float r3 = r3.strokeWPercent
            r8.strokeWPersent = r3
        L_0x00cc:
            java.lang.String r3 = r11.auxiliaryFont
            r13.mFontPath = r3
            int r3 = r11.textAlignment
            r13.mTextAlignment = r3
            r7.add(r13)
            goto L_0x00d9
        L_0x00d8:
            r12 = 0
        L_0x00d9:
            int r9 = r9 + 1
            goto L_0x0045
        L_0x00dd:
            if (r10 == 0) goto L_0x017c
            com.introvd.template.sdk.model.editor.ScaleRotateViewState r3 = new com.introvd.template.sdk.model.editor.ScaleRotateViewState
            r3.<init>()
            r6 = 10
            r3.mPadding = r6
            com.introvd.template.sdk.model.editor.TextBubbleInfo r6 = new com.introvd.template.sdk.model.editor.TextBubbleInfo
            r6.<init>()
            r6.mTextBubbleList = r7
            long r8 = r10.bubbleTemplateID
            int r8 = com.introvd.template.sdk.p391g.C8450a.getTemplateSubType(r8)
            r6.mBubbleSubtype = r8
            r8 = 4126(0x101e, float:5.782E-42)
            java.lang.Object r8 = r1.getProperty(r8)
            boolean r9 = r8 instanceof java.lang.Boolean
            if (r9 == 0) goto L_0x010b
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            r9 = 1
            r8 = r8 ^ r9
            r6.isAnimOn = r8
        L_0x010b:
            r3.mTextBubbleInfo = r6
            long r8 = r10.bubbleTemplateID
            java.lang.Long r6 = java.lang.Long.valueOf(r8)
            java.lang.String r6 = com.introvd.template.sdk.utils.p394b.C8532k.m24769q(r6)
            boolean r8 = android.text.TextUtils.isEmpty(r6)
            if (r8 != 0) goto L_0x012c
            xiaoying.engine.base.QStyle r8 = new xiaoying.engine.base.QStyle
            r8.<init>()
            r9 = 0
            int r4 = r8.create(r6, r9, r4)
            if (r4 == 0) goto L_0x012d
            r8.destroy()
        L_0x012c:
            r8 = 0
        L_0x012d:
            if (r8 == 0) goto L_0x013c
            int r4 = r2.width
            int r9 = r2.height
            xiaoying.engine.base.QBubbleTemplateInfo r0 = r8.getBubbleTemplateInfo(r0, r5, r4, r9)
            r8.destroy()
            r4 = r0
            goto L_0x013d
        L_0x013c:
            r4 = 0
        L_0x013d:
            xiaoying.utils.QSize r0 = new xiaoying.utils.QSize
            r0.<init>()
            int r5 = r2.width
            r0.mWidth = r5
            int r5 = r2.height
            r0.mHeight = r5
            xiaoying.engine.base.QBubbleMeasureResult r0 = xiaoying.engine.base.QStyle.measureBubbleSourceByTemplate(r6, r0, r10)     // Catch:{ Exception -> 0x0155 }
            if (r0 == 0) goto L_0x0159
            int r0 = r0.textLines     // Catch:{ Exception -> 0x0155 }
            r3.mLineNum = r0     // Catch:{ Exception -> 0x0155 }
            goto L_0x0159
        L_0x0155:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0159:
            r3.mStylePath = r6
            if (r4 == 0) goto L_0x0179
            java.util.Iterator r0 = r7.iterator()
        L_0x0161:
            boolean r5 = r0.hasNext()
            if (r5 == 0) goto L_0x0176
            java.lang.Object r5 = r0.next()
            com.introvd.template.sdk.model.editor.TextBubbleInfo$TextBubble r5 = (com.introvd.template.sdk.model.editor.TextBubbleInfo.TextBubble) r5
            java.lang.String r6 = r4.mTextDefaultString
            r5.mDftText = r6
            int r6 = r4.mTextColor
            r5.mDftTextColor = r6
            goto L_0x0161
        L_0x0176:
            m24855a(r3, r1, r10, r4, r2)
        L_0x0179:
            r16 = r3
            goto L_0x017e
        L_0x017c:
            r16 = 0
        L_0x017e:
            return r16
        L_0x017f:
            r0 = 0
            return r0
        L_0x0181:
            r0 = 0
            return r0
        L_0x0183:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.sdk.utils.p394b.C8538o.m24850a(xiaoying.engine.QEngine, xiaoying.engine.clip.QEffect, com.introvd.template.sdk.utils.VeMSize):com.introvd.template.sdk.model.editor.ScaleRotateViewState");
    }

    /* renamed from: a */
    public static ScaleRotateViewState m24851a(QEffect qEffect, VeMSize veMSize) {
        ScaleRotateViewState scaleRotateViewState;
        if (qEffect != null) {
            scaleRotateViewState = new ScaleRotateViewState();
            scaleRotateViewState.mPadding = 5;
            scaleRotateViewState.mDegree = ((Float) qEffect.getProperty(QEffect.PROP_VIDEO_FRAME_ROTATION)).floatValue();
            scaleRotateViewState.isHorFlip = ((Boolean) qEffect.getProperty(QEffect.PROP_VIDEO_FRAME_X_FLIP)).booleanValue();
            scaleRotateViewState.isVerFlip = ((Boolean) qEffect.getProperty(QEffect.PROP_VIDEO_FRAME_Y_FLIP)).booleanValue();
            QRect qRect = (QRect) qEffect.getProperty(4102);
            scaleRotateViewState.mPosInfo = C8530i.m24745a(veMSize, new Rect(qRect.left, qRect.top, qRect.right, qRect.bottom));
            if (scaleRotateViewState.mPosInfo != null) {
                scaleRotateViewState.mFrameWidth = scaleRotateViewState.mPosInfo.getmWidth();
                scaleRotateViewState.mFrameHeight = scaleRotateViewState.mPosInfo.getmHeight();
            }
            scaleRotateViewState.mStylePath = m24872e(qEffect);
        } else {
            scaleRotateViewState = null;
        }
        if (scaleRotateViewState != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("testState: ");
            sb.append(scaleRotateViewState);
            C8554j.m25008i("XYEffectUtil", sb.toString());
        }
        return scaleRotateViewState;
    }

    /* renamed from: a */
    public static List<ScaleRotateViewState> m24852a(QEngine qEngine, QStoryboard qStoryboard, VeMSize veMSize, int i, int i2, boolean z) {
        int h = C8537n.m24827h(qStoryboard.getDataClip(), i);
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < h; i3++) {
            QEffect b = C8540q.m24940b(qStoryboard, i, i3);
            if (b != null && m24857a(i2, b, z)) {
                ScaleRotateViewState a = (3 == i || 35 == i) ? m24850a(qEngine, b, veMSize) : m24851a(b, veMSize);
                if (a != null) {
                    RectF a2 = C8419a.m24323a(i, b, i2, veMSize, a);
                    float b2 = C8419a.m24327b(i, b, i2, veMSize, a);
                    if (a2 != null) {
                        a.mPosInfo = new StylePositionModel(a2.centerX(), a2.centerY(), a2.width(), a2.height());
                    }
                    a.mDegree = b2;
                    arrayList.add(a);
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public static QRect m24853a(Value value, QRect qRect) {
        if (qRect == null || qRect.right - qRect.left == 0 || qRect.bottom - qRect.top == 0) {
            return null;
        }
        return new QRect((int) (((float) value.f3722x) - ((((float) (qRect.right - qRect.left)) * value.widthRatio) / 2.0f)), (int) (((float) value.f3723y) - ((((float) (qRect.bottom - qRect.top)) * value.heightRatio) / 2.0f)), (int) (((float) value.f3722x) + ((((float) (qRect.right - qRect.left)) * value.widthRatio) / 2.0f)), (int) (((float) value.f3723y) + ((((float) (qRect.bottom - qRect.top)) * value.heightRatio) / 2.0f)));
    }

    /* renamed from: a */
    private static void m24854a(ScaleRotateViewState scaleRotateViewState, QBubbleTemplateInfo qBubbleTemplateInfo, VeMSize veMSize) {
        QRect qRect = qBubbleTemplateInfo.mBubbleRegion;
        QRect qRect2 = qBubbleTemplateInfo.mTextRegion;
        if (qRect != null && qRect2 != null) {
            Rect rect = new Rect(qRect.left, qRect.top, qRect.right, qRect.bottom);
            Rect b = C8530i.m24758b(rect, veMSize.width, veMSize.height);
            scaleRotateViewState.mActRelativeRect = rect;
            scaleRotateViewState.bNeedTranslate = C8531j.m24766oJ(qBubbleTemplateInfo.mTextDefaultString);
            scaleRotateViewState.mMinDuration = qBubbleTemplateInfo.mBubbleMinDuration;
            scaleRotateViewState.mDegree = qBubbleTemplateInfo.mBubbleRotation;
            scaleRotateViewState.mVersion = qBubbleTemplateInfo.mVersion;
            scaleRotateViewState.mPosInfo.setmCenterPosX((float) b.centerX());
            scaleRotateViewState.mPosInfo.setmCenterPosY((float) b.centerY());
            scaleRotateViewState.mPosInfo.setmWidth((float) b.width());
            scaleRotateViewState.mPosInfo.setmHeight((float) b.height());
            scaleRotateViewState.mViewRect = C8530i.m24744a(scaleRotateViewState.mPosInfo, (float) b.width(), (float) b.height());
            scaleRotateViewState.maxCharCount = qBubbleTemplateInfo.mTextMaxLength;
            scaleRotateViewState.isDftTemplate = qBubbleTemplateInfo.mBubbleBGFormat == 0;
        }
    }

    /* renamed from: a */
    private static void m24855a(ScaleRotateViewState scaleRotateViewState, QEffect qEffect, QBubbleTextSource qBubbleTextSource, QBubbleTemplateInfo qBubbleTemplateInfo, VeMSize veMSize) {
        scaleRotateViewState.isHorFlip = qBubbleTextSource.getHorizontalReversal();
        scaleRotateViewState.isVerFlip = qBubbleTextSource.getVerticalReversal();
        QRect qRect = (QRect) qEffect.getProperty(4102);
        Rect rect = new Rect(qRect.left, qRect.top, qRect.right, qRect.bottom);
        Rect b = C8530i.m24758b(rect, veMSize.width, veMSize.height);
        scaleRotateViewState.mActRelativeRect = rect;
        scaleRotateViewState.mDegree = qBubbleTextSource.rotateAngle;
        scaleRotateViewState.mPosInfo.setmCenterPosX((float) b.centerX());
        scaleRotateViewState.mPosInfo.setmCenterPosY((float) b.centerY());
        scaleRotateViewState.mPosInfo.setmWidth((float) b.width());
        scaleRotateViewState.mPosInfo.setmHeight((float) b.height());
        scaleRotateViewState.mViewRect = C8530i.m24744a(scaleRotateViewState.mPosInfo, (float) b.width(), (float) b.height());
        scaleRotateViewState.mMinDuration = qBubbleTemplateInfo.mBubbleMinDuration;
        scaleRotateViewState.bNeedTranslate = C8531j.m24766oJ(qBubbleTemplateInfo.mTextDefaultString);
        scaleRotateViewState.mVersion = qBubbleTemplateInfo.mVersion;
        scaleRotateViewState.maxCharCount = qBubbleTemplateInfo.mTextMaxLength;
        scaleRotateViewState.isDftTemplate = qBubbleTemplateInfo.mBubbleBGFormat == 0;
    }

    /* renamed from: a */
    private static void m24856a(QEffect qEffect, QRange qRange) {
        if (qEffect != null && qRange != null) {
            QRange qRange2 = (QRange) qEffect.getProperty(4098);
            if (qRange2 != null && qEffect.getProperty(QEffect.PROP_EFFECT_KEYFRAME_TRANSFORM) != null) {
                QKeyFrameTransformData qKeyFrameTransformData = (QKeyFrameTransformData) qEffect.getProperty(QEffect.PROP_EFFECT_KEYFRAME_TRANSFORM);
                Value[] valueArr = qKeyFrameTransformData.values;
                if (valueArr != null && valueArr.length > 0) {
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < valueArr.length; i++) {
                        int i2 = qRange2.get(0);
                        int i3 = qRange.get(0);
                        int i4 = i2 + valueArr[i].f3721ts;
                        if (i4 >= i3 && i4 <= qRange.get(1) + i3) {
                            valueArr[i].f3721ts = i4 - i3;
                            arrayList.add(valueArr[i]);
                        }
                    }
                    Value[] valueArr2 = new Value[arrayList.size()];
                    for (int i5 = 0; i5 < arrayList.size(); i5++) {
                        valueArr2[i5] = (Value) arrayList.get(i5);
                    }
                    qKeyFrameTransformData.values = valueArr2;
                    qEffect.setProperty(QEffect.PROP_EFFECT_KEYFRAME_TRANSFORM, qKeyFrameTransformData);
                }
            }
        }
    }

    /* renamed from: a */
    public static boolean m24857a(int i, QEffect qEffect, boolean z) {
        if (qEffect != null) {
            QRange qRange = (QRange) qEffect.getProperty(4098);
            if (qRange != null && new VeRange(qRange.get(0), qRange.get(1) - (z ? 1 : 0)).contains2(i)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m24858a(ArrayList<C8441b> arrayList, QStoryboard qStoryboard, int i, float f, float f2) {
        if (qStoryboard != null && arrayList != null && arrayList.size() > 0 && i >= 0) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                QClipPosition aIe = ((C8441b) it.next()).aIe();
                int GetIndexByClipPosition = qStoryboard.GetIndexByClipPosition(aIe);
                if (GetIndexByClipPosition >= 0 && i == GetIndexByClipPosition) {
                    aIe.position = QUtils.convertPosition(QUtils.convertPosition(aIe.position, f, true), f2, false);
                }
            }
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m24859a(ArrayList<C8441b> arrayList, QStoryboard qStoryboard, int i, int i2) {
        if (qStoryboard != null && arrayList != null && arrayList.size() > 0 && i >= 0) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                C8441b bVar = (C8441b) it.next();
                int GetIndexByClipPosition = qStoryboard.GetIndexByClipPosition(bVar.aIe());
                if (GetIndexByClipPosition >= 0 && i == GetIndexByClipPosition) {
                    QClipPosition aIe = bVar.aIe();
                    aIe.position -= i2;
                    if (aIe.position < 0) {
                        aIe.position = 0;
                    }
                }
            }
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m24860a(QEffect qEffect, Rect rect) {
        boolean z = false;
        if (qEffect == null) {
            return false;
        }
        if (qEffect.setProperty(QEffect.PROP_EFFECT_KEYFRAME_TRANSFORM_ORIGIN_REGION, new QRect(rect.left, rect.top, rect.right, rect.bottom)) == 0) {
            z = true;
        }
        return z;
    }

    /* renamed from: a */
    public static boolean m24861a(QEffect qEffect, boolean z) {
        if (qEffect == null) {
            return false;
        }
        Object property = z ? qEffect.getProperty(QEffect.PROP_AUDIO_FRAME_FADEIN) : qEffect.getProperty(QEffect.PROP_AUDIO_FRAME_FADEOUT);
        return property != null && ((QFade) property).get(0) > 0;
    }

    /* renamed from: b */
    public static int m24862b(QEffect qEffect, TextEffectParams textEffectParams, Rect rect, VeMSize veMSize) {
        QEffect qEffect2 = qEffect;
        Rect rect2 = rect;
        VeMSize veMSize2 = veMSize;
        if (qEffect2 == null) {
            return 1;
        }
        int i = textEffectParams.getmTextRangeStart();
        int i2 = textEffectParams.getmTextRangeLen();
        StringBuilder sb = new StringBuilder();
        sb.append("updateClipTextEffect textRangeStart=");
        sb.append(i);
        sb.append(";textRangeLen=");
        sb.append(i2);
        C8554j.m25008i("XYEffectUtil", sb.toString());
        if (m24848a(qEffect2, textEffectParams.isApplyInWholeClip(), i, i2) != 0) {
            return 1;
        }
        QRect s = m24889s(qEffect);
        if (s == null) {
            s = new QRect(rect2.left, rect2.top, rect2.right, rect2.bottom);
        }
        QRect qRect = s;
        qEffect2.setProperty(4102, qRect);
        QPoint qPoint = new QPoint();
        qPoint.f3733x = veMSize2.width;
        qPoint.f3734y = veMSize2.height;
        if (qEffect2.setProperty(QEffect.PROP_VIDEO_FRAME_BG_RESOLUTION, qPoint) != 0) {
            return 1;
        }
        QPoint qPoint2 = new QPoint((qRect.left + qRect.right) / 2, (qRect.top + qRect.bottom) / 2);
        int i3 = textEffectParams.getmTxtColor();
        float f = textEffectParams.getmAngle();
        String str = textEffectParams.getmFontPath();
        long j = textEffectParams.getmTemplateId();
        String str2 = textEffectParams.getmTxtContent();
        QBubbleTextSource qBubbleTextSource = new QBubbleTextSource(i3, false, false, f, qPoint2, qRect, 100, i3, str2, j, str);
        qBubbleTextSource.horizontalReversal = textEffectParams.isHorFlip();
        qBubbleTextSource.verticalReversal = textEffectParams.isVerFlip();
        qBubbleTextSource.textAlignment = textEffectParams.getmTextAlignment();
        qBubbleTextSource.getClass();
        QTextExtraEffect qTextExtraEffect = new QTextExtraEffect();
        if (textEffectParams.getmShadowInfo() != null) {
            qTextExtraEffect.enableEffect = true;
            if (textEffectParams.getmShadowInfo().isbEnableShadow()) {
                qTextExtraEffect.shadowBlurRadius = textEffectParams.getmShadowInfo().getmShadowBlurRadius();
                qTextExtraEffect.shadowColor = textEffectParams.getmShadowInfo().getmShadowColor();
                qTextExtraEffect.shadowXShift = textEffectParams.getmShadowInfo().getmShadowXShift();
                qTextExtraEffect.shadowYShift = textEffectParams.getmShadowInfo().getmShadowYShift();
            } else {
                qTextExtraEffect.shadowBlurRadius = 0.0f;
                qTextExtraEffect.shadowColor = 0;
                qTextExtraEffect.shadowXShift = 0.0f;
                qTextExtraEffect.shadowYShift = 0.0f;
            }
        }
        if (textEffectParams.getmStrokeInfo() != null) {
            qTextExtraEffect.strokeWPercent = textEffectParams.getmStrokeInfo().strokeWPersent;
            qTextExtraEffect.strokeColor = textEffectParams.getmStrokeInfo().strokeColor;
        }
        qBubbleTextSource.tee = qTextExtraEffect;
        return (qEffect2.setProperty(4104, new QMediaSource(2, true, qBubbleTextSource)) == 0 && qEffect2.setProperty(QEffect.PROP_VIDEO_FRAME_STATIC, Boolean.valueOf(textEffectParams.isAnimOn() ^ true)) == 0 && m24849a(textEffectParams.isApplyInWholeClip(), str2, qEffect2) == 0) ? 0 : 1;
    }

    /* renamed from: b */
    public static int m24863b(QEffect qEffect, boolean z, int i) {
        if (qEffect == null) {
            return 1;
        }
        int property = qEffect.setProperty(QEffect.PROP_AUDIO_FRAME_FADEOUT, new QFade(m24890u(z, i), 100, 0));
        if (property != 0) {
            return 1;
        }
        return property;
    }

    /* renamed from: b */
    public static ArrayList<C8441b> m24864b(QStoryboard qStoryboard, int i, VeMSize veMSize) {
        int i2;
        QClip qClip;
        QStoryboard qStoryboard2 = qStoryboard;
        int i3 = i;
        VeMSize veMSize2 = veMSize;
        ArrayList<C8441b> arrayList = new ArrayList<>();
        if (qStoryboard2 == null) {
            return arrayList;
        }
        QClip dataClip = qStoryboard.getDataClip();
        if (dataClip == null) {
            return arrayList;
        }
        int i4 = 2;
        int effectCountByGroup = dataClip.getEffectCountByGroup(2, i3);
        if (effectCountByGroup <= 0) {
            return arrayList;
        }
        int i5 = 0;
        while (i5 < effectCountByGroup) {
            QEffect effectByGroup = dataClip.getEffectByGroup(i4, i3, i5);
            if (effectByGroup == null) {
                qClip = dataClip;
                i2 = effectCountByGroup;
            } else {
                C8441b bVar = new C8441b();
                QKeyFrameTransformData k = m24881k(effectByGroup);
                if (k == null || k.values == null) {
                    qClip = dataClip;
                    i2 = effectCountByGroup;
                } else {
                    ArrayList<C8418a> arrayList2 = new ArrayList<>();
                    int i6 = 0;
                    while (i6 < k.values.length) {
                        Value value = k.values[i6];
                        QClip qClip2 = dataClip;
                        int i7 = effectCountByGroup;
                        QKeyFrameTransformData qKeyFrameTransformData = k;
                        C8418a aVar = r15;
                        C8418a aVar2 = new C8418a(value.f3722x, value.f3723y, value.widthRatio, value.heightRatio, (int) value.rotation, value.f3721ts);
                        arrayList2.add(aVar);
                        i6++;
                        dataClip = qClip2;
                        effectCountByGroup = i7;
                        k = qKeyFrameTransformData;
                    }
                    qClip = dataClip;
                    i2 = effectCountByGroup;
                    bVar.eei = arrayList2;
                }
                bVar.groupId = i3;
                bVar.eee = m24879j(effectByGroup).floatValue();
                bVar.eef = m24887q(effectByGroup);
                VeRange d = C8561p.m25041d((QRange) effectByGroup.getProperty(4098));
                bVar.mo34273b(d);
                bVar.mo34281tW(i5);
                String str = "";
                if (i3 == 6) {
                    bVar.mo34275c(new VeRange(d));
                    str = m24874g(effectByGroup);
                    QAnimatedFrameTemplateInfo a = C8450a.m24461a(str, new VeMSize(480, 480));
                    if (a != null) {
                        bVar.mo34265a(new VeRange(0, a.duration));
                        bVar.eeg = a.duration;
                        bVar.eeh = new Rect(a.defaultRegion.left, a.defaultRegion.top, a.defaultRegion.right, a.defaultRegion.bottom);
                    }
                } else if (i3 == 3 || i3 == 8 || i3 == 20 || i3 == 40) {
                    str = m24872e(effectByGroup);
                }
                bVar.mo34279nG(str);
                bVar.mo34266a(qStoryboard2.GetClipPositionByTime(d.getmPosition()));
                ScaleRotateViewState scaleRotateViewState = null;
                if (i3 == 20 || i3 == 8 || i3 == 40) {
                    scaleRotateViewState = m24851a(effectByGroup, veMSize2);
                } else if (i3 == 3) {
                    scaleRotateViewState = m24850a(qStoryboard.getEngine(), effectByGroup, veMSize2);
                }
                bVar.mo34280r(scaleRotateViewState);
                arrayList.add(bVar);
            }
            i5++;
            dataClip = qClip;
            effectCountByGroup = i2;
            i4 = 2;
        }
        return arrayList;
    }

    /* renamed from: b */
    public static boolean m24865b(QEffect qEffect, boolean z) {
        boolean z2 = false;
        if (qEffect == null) {
            return false;
        }
        if (qEffect.setProperty(QEffect.PROP_EFFECT_AUDIO_FRAME_MUTE, Boolean.valueOf(z)) == 0) {
            z2 = true;
        }
        return z2;
    }

    /* renamed from: c */
    public static int m24866c(QEffect qEffect, TextEffectParams textEffectParams, Rect rect, VeMSize veMSize) {
        if (qEffect == null || textEffectParams == null || qEffect.setProperty(4104, new QMediaSource(0, false, textEffectParams.getmEffectStylePath())) != 0) {
            return 1;
        }
        if (m24848a(qEffect, textEffectParams.isApplyInWholeClip(), textEffectParams.getmTextRangeStart(), textEffectParams.getmTextRangeLen()) != 0) {
            return 1;
        }
        QRect s = m24889s(qEffect);
        if (s == null) {
            s = new QRect(rect.left, rect.top, rect.right, rect.bottom);
        }
        qEffect.setProperty(4102, s);
        QPoint qPoint = new QPoint();
        qPoint.f3733x = veMSize.width;
        qPoint.f3734y = veMSize.height;
        return (qEffect.setProperty(QEffect.PROP_VIDEO_FRAME_BG_RESOLUTION, qPoint) == 0 && qEffect.setProperty(QEffect.PROP_VIDEO_FRAME_ROTATION, Float.valueOf(textEffectParams.getmAngle())) == 0 && qEffect.setProperty(QEffect.PROP_EFFECT_BLEND_ALPHA, Float.valueOf(textEffectParams.getmAlpha())) == 0 && qEffect.setProperty(QEffect.PROP_VIDEO_FRAME_X_FLIP, Boolean.valueOf(textEffectParams.isHorFlip())) == 0 && qEffect.setProperty(QEffect.PROP_VIDEO_FRAME_Y_FLIP, Boolean.valueOf(textEffectParams.isVerFlip())) == 0 && qEffect.setProperty(QEffect.PROP_EFFECT_FRAME_STATIC_PICTURE, Boolean.valueOf(textEffectParams.bShowStaticPicture)) == 0) ? 0 : 1;
    }

    /* renamed from: c */
    static int m24867c(QEffect qEffect, boolean z, int i) {
        return (m24847a(qEffect, z, i) == 0 && m24863b(qEffect, z, i) == 0) ? 0 : 1;
    }

    /* renamed from: c */
    public static ScaleRotateViewState m24868c(QEngine qEngine, String str, VeMSize veMSize) {
        ScaleRotateViewState scaleRotateViewState = null;
        if (str == null || TextUtils.isEmpty(str) || veMSize == null || veMSize.width <= 0 || veMSize.height <= 0) {
            return null;
        }
        int layoutMode = QUtils.getLayoutMode(veMSize.width, veMSize.height);
        int c = C8450a.m24471c(C8398b.mLocale);
        QStyle qStyle = new QStyle();
        if (qStyle.create(str, null, layoutMode) != 0) {
            qStyle.destroy();
            return null;
        }
        QTextMulInfo textMulInfo = qStyle.getTextMulInfo(qEngine, new QSize(veMSize.width, veMSize.height), c);
        if (textMulInfo == null || textMulInfo.mTextCount == 0 || textMulInfo.mMultiBTInfo == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        QBubbleTemplateInfo qBubbleTemplateInfo = null;
        for (int i = 0; i < textMulInfo.mTextCount; i++) {
            if (i < textMulInfo.mMultiBTInfo.length) {
                TextBubble textBubble = new TextBubble();
                QMultiBTInfo qMultiBTInfo = textMulInfo.mMultiBTInfo[i];
                QBubbleTemplateInfo qBubbleTemplateInfo2 = qMultiBTInfo.mBTInfo;
                if (i == 0) {
                    qBubbleTemplateInfo = qBubbleTemplateInfo2;
                }
                textBubble.mParamID = qMultiBTInfo.mParamID;
                QRect qRect = qMultiBTInfo.mTextRegion;
                if (qRect != null) {
                    textBubble.mTextRegion = new RectF((float) qRect.left, (float) qRect.top, (float) qRect.right, (float) qRect.bottom);
                }
                if (qBubbleTemplateInfo2 != null) {
                    textBubble.mTextColor = qBubbleTemplateInfo2.mTextColor;
                    textBubble.mDftTextColor = qBubbleTemplateInfo2.mTextColor;
                    textBubble.mText = qBubbleTemplateInfo2.mTextDefaultString;
                    textBubble.mDftText = qBubbleTemplateInfo2.mTextDefaultString;
                    textBubble.mShadowInfo.setbEnableShadow(false);
                    if (qBubbleTemplateInfo2.mShadowBlurRadius > 0.0f && (qBubbleTemplateInfo2.mShadowXShift > 0.0f || qBubbleTemplateInfo2.mShadowYShift > 0.0f)) {
                        textBubble.mShadowInfo.setbEnableShadow(true);
                        textBubble.mShadowInfo.setmShadowBlurRadius(qBubbleTemplateInfo2.mShadowBlurRadius);
                        textBubble.mShadowInfo.setmShadowColor(qBubbleTemplateInfo2.mShadowColor);
                        textBubble.mShadowInfo.setmShadowXShift(qBubbleTemplateInfo2.mShadowXShift);
                        textBubble.mShadowInfo.setmShadowYShift(qBubbleTemplateInfo2.mShadowYShift);
                    }
                    textBubble.mStrokeInfo.strokeWPersent = qBubbleTemplateInfo2.mStrokeWPercent;
                    textBubble.mStrokeInfo.strokeColor = qBubbleTemplateInfo2.mStrokeColor;
                    if (qBubbleTemplateInfo2.mTextAlignment > 0) {
                        textBubble.mTextAlignment = qBubbleTemplateInfo2.mTextAlignment;
                    } else {
                        textBubble.mTextAlignment = 96;
                    }
                }
                arrayList.add(textBubble);
            }
        }
        if (qBubbleTemplateInfo != null) {
            scaleRotateViewState = new ScaleRotateViewState();
            scaleRotateViewState.mPadding = 10;
            scaleRotateViewState.mStylePath = str;
            TextBubbleInfo textBubbleInfo = new TextBubbleInfo();
            textBubbleInfo.mTextBubbleList = arrayList;
            textBubbleInfo.bSupportAnim = qBubbleTemplateInfo.mBubbleIsAnimated;
            textBubbleInfo.isAnimOn = qBubbleTemplateInfo.mBubbleIsAnimated;
            textBubbleInfo.mTextEditableState = qBubbleTemplateInfo.mTextEditableProp;
            textBubbleInfo.mBubbleSubtype = C8450a.getTemplateSubType(textMulInfo.mTemplateID);
            scaleRotateViewState.mTextBubbleInfo = textBubbleInfo;
            m24854a(scaleRotateViewState, qBubbleTemplateInfo, veMSize);
        }
        return scaleRotateViewState;
    }

    /* renamed from: c */
    public static boolean m24869c(int i, QEffect qEffect) {
        if (qEffect != null) {
            QRange qRange = (QRange) qEffect.getProperty(4098);
            if (qRange != null && new VeRange(qRange.get(0), qRange.get(1)).contains2(i)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: c */
    public static boolean m24870c(QEffect qEffect, boolean z) {
        boolean z2 = false;
        if (qEffect != null) {
            Object property = qEffect.getProperty(QEffect.PROP_EFFECT_VISIBILITY);
            if ((property instanceof Boolean) && (((Boolean) property).booleanValue() ^ z)) {
                if (qEffect.setProperty(QEffect.PROP_EFFECT_VISIBILITY, Boolean.valueOf(z)) == 0) {
                    z2 = true;
                }
                return z2;
            }
        }
        return false;
    }

    /* renamed from: d */
    public static int m24871d(QEffect qEffect, TextEffectParams textEffectParams, Rect rect, VeMSize veMSize) {
        QEffect qEffect2 = qEffect;
        Rect rect2 = rect;
        VeMSize veMSize2 = veMSize;
        if (qEffect2 == null || rect2 == null || textEffectParams == null || veMSize2 == null) {
            return 1;
        }
        QRect s = m24889s(qEffect);
        if (s == null) {
            s = new QRect(rect2.left, rect2.top, rect2.right, rect2.bottom);
        }
        QRect qRect = s;
        qEffect2.setProperty(4102, qRect);
        QPoint qPoint = new QPoint();
        qPoint.f3733x = veMSize2.width;
        qPoint.f3734y = veMSize2.height;
        if (qEffect2.setProperty(QEffect.PROP_VIDEO_FRAME_BG_RESOLUTION, qPoint) != 0) {
            return 1;
        }
        QBubbleTextSource qBubbleTextSource = new QBubbleTextSource(textEffectParams.getmTxtColor(), false, false, textEffectParams.getmAngle(), new QPoint((qRect.left + qRect.right) / 2, (qRect.top + qRect.bottom) / 2), qRect, 100, textEffectParams.getmTxtColor(), textEffectParams.getmTxtContent(), textEffectParams.getmTemplateId(), null);
        qEffect2.getProperty(2);
        return qEffect2.setProperty(4104, new QMediaSource(2, true, qBubbleTextSource)) != 0 ? 1 : 0;
    }

    /* renamed from: e */
    public static String m24872e(QEffect qEffect) {
        String str = "";
        if (qEffect == null) {
            return str;
        }
        QMediaSource qMediaSource = (QMediaSource) qEffect.getProperty(4104);
        if (qMediaSource == null) {
            return str;
        }
        Object source = qMediaSource.getSource();
        if (!(source instanceof QBubbleTextSource)) {
            return source instanceof String ? (String) source : str;
        }
        String q = C8532k.m24769q(Long.valueOf(((QBubbleTextSource) source).getBubbleTemplateID()));
        if (TextUtils.isEmpty(q) || !C8548e.isFileExisted(q)) {
            q = "";
        }
        return q;
    }

    /* renamed from: f */
    public static String m24873f(QEffect qEffect) {
        String str = "";
        if (qEffect == null) {
            return str;
        }
        Object property = qEffect.getProperty(4103);
        if (!(property instanceof String)) {
            return str;
        }
        String str2 = (String) property;
        return (TextUtils.isEmpty(str2) || !C8548e.isFileExisted(str2)) ? "" : str2;
    }

    /* renamed from: g */
    public static String m24874g(QEffect qEffect) {
        String str = "";
        if (qEffect == null) {
            return str;
        }
        QMediaSource qMediaSource = (QMediaSource) qEffect.getProperty(4104);
        if (qMediaSource == null) {
            return str;
        }
        Object source = qMediaSource.getSource();
        if (!(source instanceof String)) {
            return str;
        }
        String str2 = (String) source;
        return (TextUtils.isEmpty(str2) || !C8548e.isFileExisted(str2)) ? "" : str2;
    }

    /* renamed from: g */
    public static ArrayList<C8441b> m24875g(QStoryboard qStoryboard, int i) {
        return m24864b(qStoryboard, i, (VeMSize) null);
    }

    /* renamed from: h */
    static boolean m24876h(QEffect qEffect) {
        if (qEffect != null) {
            QMediaSource qMediaSource = (QMediaSource) qEffect.getProperty(QEffect.PROP_AUDIO_FRAME_SOURCE);
            if (qMediaSource != null) {
                String str = (String) qMediaSource.getSource();
                if (!TextUtils.isEmpty(str)) {
                    return str.endsWith("/ini/dummy.mp3");
                }
            }
        }
        return true;
    }

    /* renamed from: h */
    public static boolean m24877h(QStoryboard qStoryboard, int i) {
        if (qStoryboard == null || i < 0) {
            return false;
        }
        ArrayList a = C8419a.m24325a(qStoryboard, 6, (VeMSize) null);
        if (a == null || a.isEmpty()) {
            return false;
        }
        Iterator it = a.iterator();
        boolean z = false;
        while (it.hasNext()) {
            C8441b bVar = (C8441b) it.next();
            if (bVar != null) {
                VeRange aIc = bVar.aIc();
                z = aIc != null && aIc.contains2(i);
                if (z) {
                    break;
                }
            }
        }
        return z;
    }

    /* renamed from: i */
    static String m24878i(QEffect qEffect) {
        if (qEffect != null) {
            QMediaSource qMediaSource = (QMediaSource) qEffect.getProperty(QEffect.PROP_AUDIO_FRAME_SOURCE);
            if (qMediaSource != null) {
                return (String) qMediaSource.getSource();
            }
        }
        return "";
    }

    /* renamed from: j */
    public static Float m24879j(QEffect qEffect) {
        return qEffect != null ? (Float) qEffect.getProperty(4100) : Float.valueOf(0.0f);
    }

    /* renamed from: jM */
    private static boolean m24880jM(String str) {
        return str != null && str.toLowerCase().contains(".gif");
    }

    /* renamed from: k */
    public static QKeyFrameTransformData m24881k(QEffect qEffect) {
        if (qEffect != null) {
            return (QKeyFrameTransformData) qEffect.getProperty(QEffect.PROP_EFFECT_KEYFRAME_TRANSFORM);
        }
        return null;
    }

    /* renamed from: l */
    public static int m24882l(QEffect qEffect) {
        if (qEffect != null) {
            QMediaSource qMediaSource = (QMediaSource) qEffect.getProperty(4104);
            if (qMediaSource != null && (qMediaSource.getSource() instanceof QBubbleTextSource)) {
                QBubbleTextSource qBubbleTextSource = (QBubbleTextSource) qMediaSource.getSource();
                if (qBubbleTextSource != null) {
                    return qBubbleTextSource.textAlignment;
                }
            }
        }
        return 0;
    }

    /* renamed from: m */
    public static String m24883m(QEffect qEffect) {
        if (qEffect != null) {
            QMediaSource qMediaSource = (QMediaSource) qEffect.getProperty(4104);
            if (qMediaSource != null && (qMediaSource.getSource() instanceof QBubbleTextSource)) {
                QBubbleTextSource qBubbleTextSource = (QBubbleTextSource) qMediaSource.getSource();
                if (qBubbleTextSource != null) {
                    return qBubbleTextSource.text;
                }
            }
        }
        return "";
    }

    /* renamed from: n */
    public static boolean m24884n(QEffect qEffect) {
        if (qEffect != null) {
            return ((Boolean) qEffect.getProperty(QEffect.PROP_EFFECT_AUDIO_FRAME_MUTE)).booleanValue();
        }
        return false;
    }

    /* renamed from: o */
    public static String m24885o(QEffect qEffect) {
        if (qEffect != null) {
            QMediaSource qMediaSource = (QMediaSource) qEffect.getProperty(4104);
            if (qMediaSource != null && (qMediaSource.getSource() instanceof QBubbleTextSource)) {
                QBubbleTextSource qBubbleTextSource = (QBubbleTextSource) qMediaSource.getSource();
                if (qBubbleTextSource != null) {
                    return qBubbleTextSource.auxiliaryFont;
                }
            }
        }
        return "";
    }

    /* renamed from: p */
    public static String m24886p(QEffect qEffect) {
        if (qEffect == null) {
            return "";
        }
        QEffectExternalSource qEffectExternalSource = new QEffectExternalSource();
        qEffectExternalSource.mDataRange = new QRange(0, -1);
        qEffectExternalSource.mSource = new QMediaSource(0, false, "");
        qEffect.getExternalSource(0, qEffectExternalSource);
        return (qEffectExternalSource.mSource == null || qEffectExternalSource.mSource.getSource() == null) ? "" : (String) qEffectExternalSource.mSource.getSource();
    }

    /* renamed from: q */
    public static int m24887q(QEffect qEffect) {
        if (qEffect != null) {
            Object property = qEffect.getProperty(QEffect.PROP_AUDIO_FRAME_MIXPERCENT);
            if (property != null) {
                return ((Integer) property).intValue();
            }
        }
        return 0;
    }

    /* renamed from: r */
    private static Value m24888r(QEffect qEffect) {
        if (qEffect == null || qEffect.getProperty(QEffect.PROP_EFFECT_KEYFRAME_TRANSFORM) == null) {
            return null;
        }
        Value[] valueArr = ((QKeyFrameTransformData) qEffect.getProperty(QEffect.PROP_EFFECT_KEYFRAME_TRANSFORM)).values;
        if (valueArr == null || valueArr.length <= 0) {
            return null;
        }
        Value value = valueArr[0];
        for (Value value2 : valueArr) {
            if (value2.widthRatio > value.widthRatio) {
                value = value2;
            }
        }
        return value;
    }

    /* renamed from: s */
    private static QRect m24889s(QEffect qEffect) {
        Value r = m24888r(qEffect);
        if (r == null) {
            return null;
        }
        return m24853a(r, (QRect) qEffect.getProperty(QEffect.PROP_EFFECT_KEYFRAME_TRANSFORM_ORIGIN_REGION));
    }

    /* renamed from: u */
    private static int m24890u(boolean z, int i) {
        if (z) {
            return 0;
        }
        if (i < 4000) {
            return i / 2;
        }
        return 2000;
    }
}
