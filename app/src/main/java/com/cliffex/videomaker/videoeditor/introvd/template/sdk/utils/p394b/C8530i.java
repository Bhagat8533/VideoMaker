package com.introvd.template.sdk.utils.p394b;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextUtils;
import com.introvd.template.sdk.editor.cache.C8441b;
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
import com.introvd.template.sdk.utils.C8562q;
import com.introvd.template.sdk.utils.VeMSize;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import xiaoying.engine.QEngine;
import xiaoying.engine.base.QBubbleMeasureResult;
import xiaoying.engine.base.QBubbleTextSource;
import xiaoying.engine.base.QBubbleTextSource.QTextExtraEffect;
import xiaoying.engine.base.QStyle;
import xiaoying.engine.base.QStyle.QAnimatedFrameTemplateInfo;
import xiaoying.engine.base.QTextMulInfo;
import xiaoying.engine.base.QUtils;
import xiaoying.utils.QAndroidBitmapFactory;
import xiaoying.utils.QBitmap;
import xiaoying.utils.QPoint;
import xiaoying.utils.QRect;
import xiaoying.utils.QSize;

/* renamed from: com.introvd.template.sdk.utils.b.i */
public class C8530i {
    public static long eib;
    public static long eic;

    /* renamed from: L */
    public static int m24740L(int i, int i2, int i3) {
        if (i3 == 0) {
            return 0;
        }
        return Math.round((((float) i) * ((float) i2)) / ((float) i3));
    }

    /* renamed from: a */
    private static double m24741a(Point point, Point point2, Point point3) {
        return Math.abs(((double) ((((((point.x * point2.y) + (point2.x * point3.y)) + (point3.x * point.y)) - (point2.x * point.y)) - (point3.x * point2.y)) - (point.x * point3.y))) / 2.0d);
    }

    /* renamed from: a */
    public static Bitmap m24742a(QEngine qEngine, ScaleRotateViewState scaleRotateViewState, String str, VeMSize veMSize) {
        if (!(scaleRotateViewState == null || TextUtils.isEmpty(str) || veMSize == null)) {
            QSize qSize = new QSize();
            qSize.mWidth = veMSize.width;
            qSize.mHeight = veMSize.height;
            if (m24755a(scaleRotateViewState, str, veMSize)) {
                QSize qSize2 = new QSize();
                qSize2.mWidth = (int) scaleRotateViewState.mPosInfo.getmWidth();
                qSize2.mHeight = (int) scaleRotateViewState.mPosInfo.getmHeight();
                QEngine qEngine2 = qEngine;
                QBitmap a = m24751a(qEngine2, m24750a(qEngine, veMSize, qSize, str), m24756a(C8532k.m24768ig(str).longValue(), scaleRotateViewState), qSize, qSize2, qSize2);
                Bitmap createBitmapFromQBitmap = QAndroidBitmapFactory.createBitmapFromQBitmap(a, false);
                if (a == null || a.isRecycled()) {
                    return createBitmapFromQBitmap;
                }
                a.recycle();
                return createBitmapFromQBitmap;
            }
        }
        return null;
    }

    /* renamed from: a */
    private static Point m24743a(Point point, Point point2, float f) {
        double d = (double) ((float) ((((double) f) * 3.141592653589793d) / 180.0d));
        float cos = (float) Math.cos(d);
        float sin = (float) Math.sin(d);
        int i = point.x - point2.x;
        float f2 = (float) i;
        float f3 = (float) (point.y - point2.y);
        return new Point((int) (((f2 * cos) - (f3 * sin)) + ((float) point2.x)), (int) ((f2 * sin) + (f3 * cos) + ((float) point2.y)));
    }

    /* renamed from: a */
    public static RectF m24744a(StylePositionModel stylePositionModel, float f, float f2) {
        if (stylePositionModel == null) {
            return new RectF();
        }
        float f3 = f / 2.0f;
        float f4 = f2 / 2.0f;
        return new RectF(stylePositionModel.getmCenterPosX() - f3, stylePositionModel.getmCenterPosY() - f4, stylePositionModel.getmCenterPosX() + f3, stylePositionModel.getmCenterPosY() + f4);
    }

    /* renamed from: a */
    public static StylePositionModel m24745a(VeMSize veMSize, Rect rect) {
        StylePositionModel stylePositionModel = new StylePositionModel();
        if (veMSize != null && veMSize.width > 0 && veMSize.height > 0) {
            Rect b = m24758b(rect, veMSize.width, veMSize.height);
            if (b != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("rect rect ");
                sb.append(b.toShortString());
                sb.append(";width:");
                sb.append(b.width());
                sb.append(";height:");
                sb.append(b.height());
                C8554j.m25008i("SubtitleUtils", sb.toString());
                stylePositionModel.setmCenterPosX((float) b.centerX());
                stylePositionModel.setmCenterPosY((float) b.centerY());
                stylePositionModel.setmWidth((float) b.width());
                stylePositionModel.setmHeight((float) b.height());
            }
        }
        return stylePositionModel;
    }

    /* renamed from: a */
    public static ScaleRotateViewState m24746a(QEngine qEngine, String str, VeMSize veMSize) throws Exception {
        if (!C8548e.isFileExisted(str)) {
            return null;
        }
        ScaleRotateViewState b = m24759b(qEngine, str, veMSize);
        if (b == null) {
            return null;
        }
        float f = b.mFrameWidth;
        float f2 = b.mFrameHeight;
        if (f2 <= 0.0f || f <= 0.0f) {
            return null;
        }
        float f3 = ((float) (veMSize.width * veMSize.height)) / 3.0f;
        if (f3 > 0.0f) {
            float f4 = f2 / f;
            int sqrt = (int) Math.sqrt((double) (f3 / f4));
            float f5 = (float) sqrt;
            int i = (int) (f4 * f5);
            if (i * i > 0) {
                if (f5 > ((float) veMSize.width) * 0.8f) {
                    sqrt = (int) (((float) veMSize.width) * 0.8f);
                    i = (int) (((float) i) / (f5 / (((float) veMSize.width) * 0.8f)));
                } else {
                    float f6 = (float) i;
                    if (f6 > ((float) veMSize.height) * 0.8f) {
                        i = (int) (((float) veMSize.height) * 0.8f);
                        sqrt = (int) (f5 / (f6 / (((float) veMSize.height) * 0.8f)));
                    }
                }
                f = (float) sqrt;
                f2 = (float) i;
                float f7 = (((float) veMSize.width) - f) / 2.0f;
                float f8 = (float) ((int) ((((float) veMSize.height) - f2) / 2.0f));
                b.mPosInfo = m24745a(veMSize, C8562q.m25042a(new RectF(f7, f8, (float) ((int) (f7 + f)), (float) ((int) (f8 + f2))), veMSize.width, veMSize.height));
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("not support file format!! path=");
                sb.append(str);
                throw new Exception(sb.toString());
            }
        }
        b.mFrameWidth = f;
        b.mFrameHeight = (float) ((int) f2);
        if (!m24761jM(str)) {
            b.mMinDuration = 0;
        }
        return b;
    }

    /* renamed from: a */
    public static TextEffectParams m24747a(String str, ScaleRotateViewState scaleRotateViewState, VeMSize veMSize) {
        RectF rectF = null;
        if (TextUtils.isEmpty(str) || scaleRotateViewState == null || veMSize == null) {
            return null;
        }
        TextEffectParams textEffectParams = new TextEffectParams();
        String textBubbleText = scaleRotateViewState.getTextBubbleText();
        int textColor = scaleRotateViewState.getTextColor();
        RectF t = m24763t(scaleRotateViewState);
        if (t != null) {
            rectF = new RectF(t.left, t.top, t.right, t.bottom);
        }
        float f = scaleRotateViewState.mDegree;
        boolean isAnimOn = scaleRotateViewState.isAnimOn();
        textEffectParams.setmAngle(f);
        textEffectParams.setAnimOn(isAnimOn);
        textEffectParams.setmTxtColor(textColor);
        textEffectParams.setmTxtContent(textBubbleText);
        textEffectParams.setmEffectStylePath(str);
        textEffectParams.setApplyInWholeClip(false);
        textEffectParams.setmTextRect(rectF);
        textEffectParams.setmTemplateId(C8532k.m24768ig(str).longValue());
        return textEffectParams;
    }

    /* renamed from: a */
    public static QBubbleTextSource m24748a(Rect rect, String str, int i, String str2, int i2, long j, boolean z, boolean z2) {
        Rect rect2 = rect;
        QRect qRect = new QRect();
        if (rect2 != null) {
            qRect.set(rect2.left, rect2.top, rect2.right, rect2.bottom);
        }
        QBubbleTextSource qBubbleTextSource = new QBubbleTextSource(0, false, false, (float) i, new QPoint(0, 0), qRect, 0, i2, str2, j, str);
        qBubbleTextSource.horizontalReversal = z;
        qBubbleTextSource.verticalReversal = z2;
        return qBubbleTextSource;
    }

    /* renamed from: a */
    public static QBubbleTextSource m24749a(ScaleRotateViewState scaleRotateViewState, int i, int i2, int i3, String str, VeMSize veMSize, long j) {
        int i4;
        int i5;
        int i6;
        float f;
        float f2;
        ScaleRotateViewState scaleRotateViewState2 = scaleRotateViewState;
        VeMSize veMSize2 = veMSize;
        if (TextUtils.isEmpty(str) || veMSize2 == null) {
            return null;
        }
        QSize qSize = new QSize();
        qSize.mWidth = veMSize2.width;
        qSize.mHeight = veMSize2.height;
        QBubbleMeasureResult measureBubbleByTemplate = QStyle.measureBubbleByTemplate(scaleRotateViewState2.mStylePath, qSize, str, null);
        if (measureBubbleByTemplate != null) {
            i6 = measureBubbleByTemplate.bubbleW;
            i4 = measureBubbleByTemplate.bubbleH;
            i5 = measureBubbleByTemplate.textLines;
        } else {
            i6 = 0;
            i5 = 1;
            i4 = 0;
        }
        float f3 = scaleRotateViewState2.mPosInfo.getmCenterPosX();
        float f4 = scaleRotateViewState2.mPosInfo.getmCenterPosY();
        if (i4 <= 0 || i6 <= 0) {
            f = scaleRotateViewState2.mPosInfo.getmWidth();
            f2 = scaleRotateViewState2.mPosInfo.getmHeight();
        } else {
            f2 = scaleRotateViewState2.mPosInfo.getmHeight() * ((float) i5);
            f = (((float) i6) * f2) / ((float) i4);
        }
        float f5 = f / 2.0f;
        float f6 = f2 / 2.0f;
        Rect a = C8562q.m25042a(new RectF(f3 - f5, f4 - f6, f3 + f5, f4 + f6), veMSize2.width, veMSize2.height);
        QBubbleTextSource qBubbleTextSource = new QBubbleTextSource(-1, false, false, (float) i3, new QPoint(0, 0), a != null ? new QRect(a.left, a.top, a.right, a.bottom) : new QRect(), 100, i, str, j, null);
        return qBubbleTextSource;
    }

    /* renamed from: a */
    public static QTextMulInfo m24750a(QEngine qEngine, VeMSize veMSize, QSize qSize, String str) {
        QStyle qStyle = new QStyle();
        if (qStyle.create(str, null, QUtils.getLayoutMode(veMSize.width, veMSize.height)) != 0) {
            return null;
        }
        return qStyle.getTextMulInfo(qEngine, qSize, C8450a.m24471c(C8398b.mLocale));
    }

    /* renamed from: a */
    public static QBitmap m24751a(QEngine qEngine, QTextMulInfo qTextMulInfo, QBubbleTextSource[] qBubbleTextSourceArr, QSize qSize, QSize qSize2, QSize qSize3) {
        if (Thread.currentThread().getId() != eib && eic != 0 && aJM() != 0) {
            return null;
        }
        m24752a(qEngine, qSize);
        return QStyle.getTextThumbnail(eic, qBubbleTextSourceArr, qSize2, qSize3, qTextMulInfo == null ? 0 : qTextMulInfo.mPreviewPos);
    }

    /* renamed from: a */
    public static void m24752a(QEngine qEngine, QSize qSize) {
        if (eic == 0) {
            eic = QStyle.creatEffectThumbnailEngine(qEngine, qSize);
            eib = Thread.currentThread().getId();
        }
    }

    /* renamed from: a */
    public static boolean m24753a(Point point, float f, Rect rect) {
        if (rect == null) {
            return false;
        }
        float f2 = f % 180.0f;
        if (f2 <= 1.0f || 180.0f - f2 <= 1.0f) {
            return rect.contains(point.x, point.y);
        }
        Point point2 = new Point(rect.centerX(), rect.centerY());
        Point a = m24743a(point, point2, 360.0f - f);
        if (a != null) {
            return rect.contains(a.x, a.y);
        }
        Point[] pointArr = {new Point(rect.left, rect.top), new Point(rect.left, rect.bottom), new Point(rect.right, rect.top), new Point(rect.right, rect.bottom)};
        Point[] pointArr2 = new Point[pointArr.length];
        int length = pointArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = i2 + 1;
            pointArr2[i2] = m24743a(pointArr[i], point2, f);
            i++;
            i2 = i3;
        }
        return m24754a(pointArr2[0], pointArr2[1], pointArr2[2], pointArr2[3], point);
    }

    /* renamed from: a */
    private static boolean m24754a(Point point, Point point2, Point point3, Point point4, Point point5) {
        return (((m24741a(point, point2, point5) + m24741a(point2, point3, point5)) + m24741a(point3, point4, point5)) + m24741a(point4, point, point5)) - (m24741a(point, point2, point3) + m24741a(point3, point4, point)) < 1.0d;
    }

    /* renamed from: a */
    public static boolean m24755a(ScaleRotateViewState scaleRotateViewState, String str, VeMSize veMSize) {
        QBubbleMeasureResult qBubbleMeasureResult;
        QSize qSize = new QSize();
        qSize.mWidth = veMSize.width;
        qSize.mHeight = veMSize.height;
        TextBubbleInfo textBubbleInfo = scaleRotateViewState.mTextBubbleInfo;
        if (textBubbleInfo == null || textBubbleInfo.mTextBubbleList == null || textBubbleInfo.mTextBubbleList.isEmpty()) {
            return false;
        }
        TextBubble dftTextBubble = textBubbleInfo.getDftTextBubble();
        if (dftTextBubble == null) {
            return false;
        }
        String str2 = dftTextBubble.mText;
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        try {
            QBubbleTextSource qBubbleTextSource = new QBubbleTextSource();
            qBubbleTextSource.text = str2;
            qBubbleTextSource.getClass();
            QTextExtraEffect qTextExtraEffect = new QTextExtraEffect();
            if (dftTextBubble.mShadowInfo != null) {
                qTextExtraEffect.enableEffect = dftTextBubble.mShadowInfo.isbEnableShadow();
                qTextExtraEffect.shadowBlurRadius = dftTextBubble.mShadowInfo.getmShadowBlurRadius();
                qTextExtraEffect.shadowXShift = dftTextBubble.mShadowInfo.getmShadowXShift();
                qTextExtraEffect.shadowYShift = dftTextBubble.mShadowInfo.getmShadowYShift();
                qTextExtraEffect.shadowColor = dftTextBubble.mShadowInfo.getmShadowColor();
            }
            if (dftTextBubble.mStrokeInfo != null) {
                qTextExtraEffect.strokeWPercent = dftTextBubble.mStrokeInfo.strokeWPersent;
                qTextExtraEffect.strokeColor = dftTextBubble.mStrokeInfo.strokeColor;
            }
            qBubbleTextSource.tee = qTextExtraEffect;
            qBubbleMeasureResult = QStyle.measureBubbleSourceByTemplate(str, qSize, qBubbleTextSource);
        } catch (Exception e) {
            e.printStackTrace();
            qBubbleMeasureResult = null;
        }
        if (qBubbleMeasureResult == null) {
            return false;
        }
        int i = qBubbleMeasureResult.bubbleW;
        int i2 = qBubbleMeasureResult.bubbleH;
        int i3 = qBubbleMeasureResult.textLines;
        if (scaleRotateViewState.mPosInfo.getmWidth() <= 0.0f || scaleRotateViewState.mPosInfo.getmHeight() <= 0.0f) {
            scaleRotateViewState.mPosInfo.setmWidth((float) i);
            scaleRotateViewState.mPosInfo.setmHeight((float) i2);
        } else {
            if (scaleRotateViewState.isDftTemplate && scaleRotateViewState.mLineNum > 0) {
                scaleRotateViewState.mPosInfo.setmHeight((float) ((int) ((scaleRotateViewState.mPosInfo.getmHeight() / ((float) scaleRotateViewState.mLineNum)) * ((float) i3))));
            }
            if (i2 > 0) {
                scaleRotateViewState.mPosInfo.setmWidth((((float) i) * scaleRotateViewState.mPosInfo.getmHeight()) / ((float) i2));
            } else {
                scaleRotateViewState.mPosInfo.setmWidth(10.0f);
            }
        }
        scaleRotateViewState.mLineNum = i3;
        return true;
    }

    /* renamed from: a */
    private static QBubbleTextSource[] m24756a(long j, ScaleRotateViewState scaleRotateViewState) {
        ScaleRotateViewState scaleRotateViewState2 = scaleRotateViewState;
        TextBubbleInfo textBubbleInfo = scaleRotateViewState2.mTextBubbleInfo;
        if (textBubbleInfo == null) {
            return null;
        }
        List<TextBubble> list = textBubbleInfo.mTextBubbleList;
        if (list == null || list.size() == 0) {
            return null;
        }
        QBubbleTextSource[] qBubbleTextSourceArr = new QBubbleTextSource[list.size()];
        for (int i = 0; i < list.size(); i++) {
            TextBubble textBubble = (TextBubble) list.get(i);
            if (textBubble != null) {
                QBubbleTextSource a = m24748a(null, textBubble.mFontPath, 0, textBubble.mText, textBubble.mTextColor, j, scaleRotateViewState2.isHorFlip, scaleRotateViewState2.isVerFlip);
                a.paramId = textBubble.mParamID;
                a.textAlignment = textBubble.mTextAlignment;
                a.getClass();
                QTextExtraEffect qTextExtraEffect = new QTextExtraEffect();
                if (textBubble.mShadowInfo != null) {
                    qTextExtraEffect.enableEffect = true;
                    if (textBubble.mShadowInfo.isbEnableShadow()) {
                        qTextExtraEffect.shadowBlurRadius = textBubble.mShadowInfo.getmShadowBlurRadius();
                        qTextExtraEffect.shadowColor = textBubble.mShadowInfo.getmShadowColor();
                        qTextExtraEffect.shadowXShift = textBubble.mShadowInfo.getmShadowXShift();
                        qTextExtraEffect.shadowYShift = textBubble.mShadowInfo.getmShadowYShift();
                    } else {
                        qTextExtraEffect.shadowBlurRadius = 0.0f;
                        qTextExtraEffect.shadowColor = 0;
                        qTextExtraEffect.shadowXShift = 0.0f;
                        qTextExtraEffect.shadowYShift = 0.0f;
                    }
                    a.tee = qTextExtraEffect;
                }
                if (textBubble.mStrokeInfo != null) {
                    qTextExtraEffect.enableEffect = true;
                    qTextExtraEffect.strokeColor = textBubble.mStrokeInfo.strokeColor;
                    qTextExtraEffect.strokeWPercent = textBubble.mStrokeInfo.strokeWPersent;
                }
                qBubbleTextSourceArr[i] = a;
            }
        }
        return qBubbleTextSourceArr;
    }

    public static int aJM() {
        int destroyEffectThumbnailEngine = QStyle.destroyEffectThumbnailEngine(eic);
        eic = 0;
        return destroyEffectThumbnailEngine;
    }

    /* renamed from: b */
    public static Bitmap m24757b(QEngine qEngine, ScaleRotateViewState scaleRotateViewState, String str, VeMSize veMSize) {
        try {
            return m24742a(qEngine, scaleRotateViewState, str, veMSize);
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: b */
    public static Rect m24758b(Rect rect, int i, int i2) {
        if (rect == null || i <= 0 || i2 <= 0) {
            return rect;
        }
        Rect rect2 = new Rect();
        rect2.left = m24740L(rect.left, i, 10000);
        rect2.top = m24740L(rect.top, i2, 10000);
        rect2.right = m24740L(rect.right, i, 10000);
        rect2.bottom = m24740L(rect.bottom, i2, 10000);
        return rect2;
    }

    /* renamed from: b */
    public static ScaleRotateViewState m24759b(QEngine qEngine, String str, VeMSize veMSize) {
        QAnimatedFrameTemplateInfo qAnimatedFrameTemplateInfo;
        if (qEngine == null || TextUtils.isEmpty(str) || veMSize == null || veMSize.width <= 0 || veMSize.height <= 0 || TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            qAnimatedFrameTemplateInfo = QUtils.getAnimatedFrameInfo(qEngine, str, new QSize(veMSize.width, veMSize.height));
        } catch (StackOverflowError unused) {
            qAnimatedFrameTemplateInfo = null;
        }
        if (qAnimatedFrameTemplateInfo == null) {
            return null;
        }
        ScaleRotateViewState scaleRotateViewState = new ScaleRotateViewState();
        scaleRotateViewState.mStylePath = str;
        scaleRotateViewState.mPadding = 5;
        scaleRotateViewState.mMinDuration = qAnimatedFrameTemplateInfo.duration;
        scaleRotateViewState.mExampleThumbPos = qAnimatedFrameTemplateInfo.examplePos;
        QRect qRect = qAnimatedFrameTemplateInfo.defaultRegion;
        if (qRect == null) {
            return scaleRotateViewState;
        }
        Rect rect = new Rect(qRect.left, qRect.top, qRect.right, qRect.bottom);
        StringBuilder sb = new StringBuilder();
        sb.append("rect style rtRelative ");
        sb.append(rect.toShortString());
        sb.append(";width:");
        sb.append(rect.width());
        sb.append(";height:");
        sb.append(rect.height());
        C8554j.m25008i("SubtitleUtils", sb.toString());
        scaleRotateViewState.mPosInfo = m24745a(veMSize, rect);
        scaleRotateViewState.mFrameWidth = (float) qAnimatedFrameTemplateInfo.frameWidth;
        scaleRotateViewState.mFrameHeight = (float) qAnimatedFrameTemplateInfo.frameHeight;
        return scaleRotateViewState;
    }

    /* renamed from: d */
    public static ArrayList<VeRange> m24760d(ArrayList<C8441b> arrayList, int i) {
        ArrayList<VeRange> arrayList2 = new ArrayList<>();
        if (arrayList != null && arrayList.size() > 0) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                VeRange aIc = ((C8441b) it.next()).aIc();
                if (i <= 0 || aIc.getmTimeLength() >= 0) {
                    arrayList2.add(new VeRange(aIc));
                } else {
                    arrayList2.add(new VeRange(aIc.getmPosition(), i));
                }
            }
        }
        return arrayList2;
    }

    /* renamed from: jM */
    public static boolean m24761jM(String str) {
        return str != null && str.toLowerCase().contains(".gif");
    }

    /* renamed from: oI */
    public static boolean m24762oI(String str) {
        boolean z = false;
        if (str == null) {
            return false;
        }
        if (str.toLowerCase().contains(".gif")) {
            z = new File(str).exists();
        }
        return z;
    }

    /* renamed from: t */
    public static RectF m24763t(ScaleRotateViewState scaleRotateViewState) {
        float f;
        float f2;
        if (scaleRotateViewState.mPosInfo != null) {
            f2 = scaleRotateViewState.mPosInfo.getmWidth();
            f = scaleRotateViewState.mPosInfo.getmHeight();
        } else {
            f2 = 0.0f;
            f = 0.0f;
        }
        RectF rectF = scaleRotateViewState.mViewRect;
        if ((f2 <= 0.0f || f <= 0.0f) && rectF != null) {
            f2 = (float) ((int) rectF.width());
            f = (float) ((int) rectF.height());
        }
        return m24744a(scaleRotateViewState.mPosInfo, f2, f);
    }

    /* renamed from: t */
    public static ArrayList<VeRange> m24764t(ArrayList<C8441b> arrayList) {
        return m24760d(arrayList, -1);
    }
}
