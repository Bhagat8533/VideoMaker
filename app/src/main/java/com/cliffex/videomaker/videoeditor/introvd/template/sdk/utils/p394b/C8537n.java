package com.introvd.template.sdk.utils.p394b;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.text.TextUtils;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.introvd.template.sdk.C8410e;
import com.introvd.template.sdk.editor.cache.TrimedClipItemDataModel;
import com.introvd.template.sdk.model.VeRange;
import com.introvd.template.sdk.model.editor.DataLyricsItem;
import com.introvd.template.sdk.model.editor.PIPItemInfo;
import com.introvd.template.sdk.model.editor.TextEffectParams;
import com.introvd.template.sdk.p383c.C8398b;
import com.introvd.template.sdk.p383c.C8400d;
import com.introvd.template.sdk.p391g.C8450a;
import com.introvd.template.sdk.utils.C8548e;
import com.introvd.template.sdk.utils.C8572y;
import com.introvd.template.sdk.utils.VeMSize;
import java.nio.charset.Charset;
import java.util.ArrayList;
import xiaoying.engine.QEngine;
import xiaoying.engine.base.QBubbleTemplateInfo;
import xiaoying.engine.base.QBubbleTextSource;
import xiaoying.engine.base.QRange;
import xiaoying.engine.base.QStyle;
import xiaoying.engine.base.QStyle.QEffectPropertyData;
import xiaoying.engine.base.QStyle.QEffectPropertyInfo;
import xiaoying.engine.base.QTRCLyricsSource;
import xiaoying.engine.base.QUtils;
import xiaoying.engine.base.QVideoInfo;
import xiaoying.engine.clip.QClip;
import xiaoying.engine.clip.QEffect;
import xiaoying.engine.clip.QMediaSource;
import xiaoying.engine.clip.QSFParam;
import xiaoying.engine.clip.QSceneClip;
import xiaoying.engine.clip.QTransition;
import xiaoying.engine.clip.QUserData;
import xiaoying.engine.cover.QCover;
import xiaoying.engine.storyboard.QStoryboard;
import xiaoying.utils.QAndroidBitmapFactory;
import xiaoying.utils.QBitmap;
import xiaoying.utils.QBitmapFactory;
import xiaoying.utils.QColorSpace;
import xiaoying.utils.QRect;
import xiaoying.utils.QSize;

/* renamed from: com.introvd.template.sdk.utils.b.n */
public class C8537n {
    /* renamed from: a */
    public static float m24784a(QClip qClip, int i, float f) {
        int h = m24827h(qClip, i);
        if (h > 0) {
            for (int i2 = 0; i2 < h; i2++) {
                QEffect b = m24816b(qClip, i, i2);
                if (b != null) {
                    Float j = C8538o.m24879j(b);
                    if (j.floatValue() > f) {
                        f = j.floatValue();
                    }
                }
            }
        }
        return f;
    }

    /* renamed from: a */
    public static int m24785a(QEngine qEngine, QClip qClip, DataLyricsItem dataLyricsItem) {
        if (qEngine == null || qClip == null || TextUtils.isEmpty(dataLyricsItem.strLrcTRCFile) || dataLyricsItem.rect == null) {
            return 1;
        }
        m24822f(qClip, 100);
        QEffect qEffect = new QEffect();
        int create = qEffect.create(qEngine, 2, 2, 100, 50.0f);
        if (create != 0) {
            return create;
        }
        qClip.insertEffect(qEffect);
        QTRCLyricsSource qTRCLyricsSource = new QTRCLyricsSource();
        qTRCLyricsSource.fontFile = DataLyricsItem.FONT_FAMILY_FILE;
        qTRCLyricsSource.TRCFile = dataLyricsItem.strLrcTRCFile;
        qTRCLyricsSource.bgColor = dataLyricsItem.nLrcBgColor;
        qTRCLyricsSource.foreColor = dataLyricsItem.nLrcForeColor;
        qTRCLyricsSource.mode = 1;
        int property = qEffect.setProperty(4104, new QMediaSource(4, false, qTRCLyricsSource));
        if (property != 0) {
            return property;
        }
        int property2 = qEffect.setProperty(QEffect.PROP_VIDEO_FRAME_TRANSPARENCY, Integer.valueOf(100));
        if (property2 != 0) {
            return property2;
        }
        int i = dataLyricsItem.nLrcLength;
        if (i < 0) {
            i = Integer.MAX_VALUE;
        }
        int property3 = qEffect.setProperty(4098, new QRange(dataLyricsItem.nDstStartPos, i));
        if (property3 != 0) {
            return property3;
        }
        int property4 = qEffect.setProperty(QEffect.PROP_VIDEO_FRAME_RANGE, new QRange(dataLyricsItem.nLrcStartPos, i));
        if (property4 != 0) {
            return property4;
        }
        int property5 = qEffect.setProperty(4102, new QRect(dataLyricsItem.rect.left, dataLyricsItem.rect.top, dataLyricsItem.rect.right, dataLyricsItem.rect.bottom));
        if (property5 != 0) {
            return property5;
        }
        int property6 = qEffect.setProperty(QEffect.PROP_VIDEO_FRAME_FPS, Integer.valueOf(15));
        return property6 != 0 ? property6 : property6;
    }

    /* renamed from: a */
    public static int m24786a(QEngine qEngine, QClip qClip, String str, int i, int i2, int i3, int i4, int i5) {
        if (qClip == null) {
            return 1;
        }
        m24822f(qClip, 1);
        QEffect qEffect = new QEffect();
        if (qEffect.create(qEngine, 3, 3, 1, 4.0f) != 0) {
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
            if (qEffect.setProperty(QEffect.PROP_AUDIO_FRAME_REPEAT_MODE, Integer.valueOf(0)) != 0) {
                qEffect.destory();
                return 1;
            } else if (qEffect.setProperty(QEffect.PROP_AUDIO_FRAME_MIXPERCENT, Integer.valueOf(i5)) != 0) {
                qEffect.destory();
                return 1;
            } else if (qClip.insertEffect(qEffect) != 0) {
                qEffect.destory();
                return 1;
            } else {
                int property = qEffect.setProperty(4098, new QRange(i3, i4));
                if (property == 0) {
                    return property;
                }
                qClip.removeEffect(qEffect);
                qEffect.destory();
                return 1;
            }
        }
    }

    /* renamed from: a */
    public static int m24787a(QClip qClip, Float f) {
        if (qClip != null) {
            return qClip.setProperty(12293, f);
        }
        return 1;
    }

    /* renamed from: a */
    public static int m24788a(QClip qClip, String str, QEngine qEngine, int i) {
        if (qClip == null || qEngine == null || TextUtils.isEmpty(str)) {
            return 1;
        }
        QEffect qEffect = new QEffect();
        if (qEffect.create(qEngine, 1, 1, i, C8400d.edh.floatValue()) != 0 || qClip.insertEffect(qEffect) != 0) {
            return 1;
        }
        if (qEffect.setProperty(4103, str) != 0) {
            qClip.removeEffect(qEffect);
            return 1;
        }
        qEffect.setProperty(4098, new QRange(0, -1));
        return 0;
    }

    /* renamed from: a */
    public static int m24789a(QClip qClip, QEngine qEngine, TextEffectParams textEffectParams, int i, Rect rect, VeMSize veMSize) {
        int i2;
        if (qClip == null || qEngine == null || textEffectParams == null || TextUtils.isEmpty(textEffectParams.getmEffectStylePath())) {
            return 1;
        }
        QEffect qEffect = new QEffect();
        if (3 != i && 35 != i) {
            i2 = qEffect.create(qEngine, 2, 2, i, textEffectParams.mLayerID);
        } else if (C8450a.m24466bk(textEffectParams.getmTemplateId())) {
            i2 = qEffect.create(qEngine, 1, 2, i, textEffectParams.mLayerID);
        } else {
            QBubbleTemplateInfo a = C8450a.m24460a(qEngine, textEffectParams.getmEffectStylePath(), C8450a.m24471c(C8398b.mLocale), 480, 480);
            i2 = (a == null || a.mVersion < 196608) ? qEffect.create(qEngine, 2, 2, i, textEffectParams.mLayerID) : qEffect.create(qEngine, 1, 2, i, textEffectParams.mLayerID);
        }
        if (i2 != 0) {
            return 1;
        }
        int insertEffect = qClip.insertEffect(qEffect);
        if (insertEffect != 0) {
            return 1;
        }
        if (3 == i || 35 == i) {
            insertEffect = C8538o.m24862b(qEffect, textEffectParams, rect, veMSize);
        } else if (8 == i || 30 == i || 40 == i || 20 == i || 50 == i) {
            insertEffect = C8538o.m24866c(qEffect, textEffectParams, rect, veMSize);
        }
        C8538o.m24860a(qEffect, rect);
        return insertEffect != 0 ? 1 : 0;
    }

    /* renamed from: a */
    public static int m24790a(QClip qClip, QEngine qEngine, TextEffectParams textEffectParams, Rect rect, VeMSize veMSize) {
        if (Float.compare(textEffectParams.mLayerID, 5.0E-4f) < 0) {
            textEffectParams.mLayerID = m24784a(qClip, 3, 1000.0f) + 5.0E-4f;
        }
        return m24789a(qClip, qEngine, textEffectParams, 3, rect, veMSize);
    }

    /* renamed from: a */
    public static int m24791a(QSceneClip qSceneClip, int i, int i2) {
        return (qSceneClip == null || i < 0 || i2 < 0 || qSceneClip.swapElementSource(i, i2) != 0) ? 1 : 0;
    }

    /* renamed from: a */
    public static int m24792a(QEffectPropertyData[] qEffectPropertyDataArr, QEffect qEffect) {
        if (qEffectPropertyDataArr == null || qEffectPropertyDataArr.length <= 0 || qEffect == null) {
            return 0;
        }
        int i = 0;
        for (QEffectPropertyData qEffectPropertyData : qEffectPropertyDataArr) {
            if (qEffectPropertyData != null) {
                i = qEffect.setProperty(QEffect.PROP_EFFECT_PROPDATA, qEffectPropertyData);
            }
        }
        return i;
    }

    /* renamed from: a */
    public static Object m24793a(QClip qClip, int i, int i2, int i3, boolean z, boolean z2, boolean z3) {
        if (qClip == null || C8572y.m25062a(qClip, i2, i3, 65538, false, z3) != 0) {
            return null;
        }
        QBitmap createQBitmapShareWithAndroidBitmap = QBitmapFactory.createQBitmapShareWithAndroidBitmap(i2, i3, QColorSpace.QPAF_RGB32_A8R8G8B8);
        if (createQBitmapShareWithAndroidBitmap == null) {
            return null;
        }
        if (C8572y.m25076b(qClip, createQBitmapShareWithAndroidBitmap, i, z) != 0) {
            if (!createQBitmapShareWithAndroidBitmap.isRecycled()) {
                createQBitmapShareWithAndroidBitmap.recycle();
            }
            qClip.destroyThumbnailManager();
            return null;
        }
        qClip.destroyThumbnailManager();
        if (z2) {
            return createQBitmapShareWithAndroidBitmap;
        }
        Bitmap createBitmapFromQBitmap = QAndroidBitmapFactory.createBitmapFromQBitmap(createQBitmapShareWithAndroidBitmap, false);
        if (!createQBitmapShareWithAndroidBitmap.isRecycled()) {
            createQBitmapShareWithAndroidBitmap.recycle();
        }
        return createBitmapFromQBitmap;
    }

    /* renamed from: a */
    public static String m24794a(QClip qClip, String str) {
        if (qClip != null && !TextUtils.isEmpty(str)) {
            String str2 = (String) qClip.getProperty(QClip.PROP_CLIP_WATERMARK_CACHED);
            if (TextUtils.isEmpty(str2)) {
                return "";
            }
            JsonObject asJsonObject = new JsonParser().parse(str2).getAsJsonObject();
            if (asJsonObject != null) {
                JsonElement jsonElement = asJsonObject.get(str);
                if (jsonElement != null) {
                    return jsonElement.getAsString();
                }
            }
        }
        return "";
    }

    /* renamed from: a */
    private static String m24795a(QCover qCover, int i, QBubbleTextSource qBubbleTextSource) {
        String str = "";
        if (qBubbleTextSource == null) {
            return str;
        }
        String text = qBubbleTextSource.getText();
        if (TextUtils.isEmpty(text)) {
            text = "";
            QUserData titleUserData = qCover.getTitleUserData(i);
            if (titleUserData != null && titleUserData.getUserDataLength() > 1) {
                byte[] bArr = new byte[(titleUserData.getUserDataLength() - 1)];
                System.arraycopy(titleUserData.getUserData(), 1, bArr, 0, titleUserData.getUserDataLength() - 1);
                text = new String(bArr, Charset.forName("UTF-8"));
            }
        }
        return text;
    }

    /* renamed from: a */
    public static QClip m24796a(QClip qClip, QEngine qEngine, boolean z) {
        if (qClip == null) {
            return null;
        }
        if (qClip instanceof QSceneClip) {
            QSceneClip qSceneClip = new QSceneClip();
            if (qClip.duplicate(qSceneClip) != 0) {
                qSceneClip.unInit();
                return null;
            } else if (qSceneClip.setProperty(12292, new QRange(0, -1)) == 0) {
                return qSceneClip;
            } else {
                qSceneClip.unInit();
                return null;
            }
        } else {
            QMediaSource qMediaSource = (QMediaSource) qClip.getProperty(12290);
            QRange qRange = (QRange) qClip.getProperty(QClip.PROP_CLIP_SRC_RANGE);
            if (qMediaSource == null) {
                return null;
            }
            QClip qClip2 = new QClip();
            if (qClip2.init(qEngine, qMediaSource) != 0) {
                qClip2.unInit();
                return null;
            } else if (qClip2.setProperty(12293, qClip.getProperty(12293)) != 0) {
                qClip2.unInit();
                return null;
            } else if (qClip2.setProperty(QClip.PROP_CLIP_SRC_RANGE, new QRange(qRange)) != 0) {
                qClip2.unInit();
                return null;
            } else {
                if (z) {
                    if (((Boolean) qClip.getProperty(QClip.PROP_CLIP_REVERSE_TRIM_MDOE)).booleanValue()) {
                        if (qClip2.setProperty(QClip.PROP_CLIP_REVERSE_TRIM_MDOE, Boolean.valueOf(true)) != 0) {
                            qClip2.unInit();
                            return null;
                        } else if (qClip2.setProperty(QClip.PROP_CLIP_REVERSE_TRIM_RANGE, qClip.getProperty(QClip.PROP_CLIP_REVERSE_TRIM_RANGE)) != 0) {
                            qClip2.unInit();
                            return null;
                        }
                    } else if (qClip2.setProperty(12292, (QRange) qClip.getProperty(12292)) != 0) {
                        qClip2.unInit();
                        return null;
                    }
                }
                if (qClip2.setProperty(12315, qClip.getProperty(12315)) == 0) {
                    return qClip2;
                }
                qClip2.unInit();
                return null;
            }
        }
    }

    /* renamed from: a */
    public static QEffect m24797a(QClip qClip, int i, int i2) {
        if (qClip != null) {
            return qClip.getEffectByGroup(1, i, i2);
        }
        return null;
    }

    /* renamed from: a */
    public static QSceneClip m24798a(QEngine qEngine, VeMSize veMSize, long j, TrimedClipItemDataModel trimedClipItemDataModel, TrimedClipItemDataModel trimedClipItemDataModel2) {
        int i;
        int i2;
        if (qEngine == null || veMSize == null || j <= 0 || trimedClipItemDataModel == null || trimedClipItemDataModel2 == null || !C8548e.isFileExisted(trimedClipItemDataModel.mRawFilePath) || !C8548e.isFileExisted(trimedClipItemDataModel2.mRawFilePath)) {
            return null;
        }
        QSceneClip qSceneClip = new QSceneClip();
        QMediaSource qMediaSource = new QMediaSource(0, false, trimedClipItemDataModel.mRawFilePath);
        QMediaSource qMediaSource2 = new QMediaSource(0, false, trimedClipItemDataModel2.mRawFilePath);
        QSize qSize = new QSize();
        qSize.mWidth = veMSize.width;
        qSize.mHeight = veMSize.height;
        if (qSceneClip.init(qEngine, j, qSize) != 0) {
            return null;
        }
        QStoryboard qStoryboard = new QStoryboard();
        if (qStoryboard.init(qEngine, null) != 0) {
            return null;
        }
        QClip qClip = new QClip();
        if (qClip.init(qEngine, qMediaSource) != 0) {
            return null;
        }
        if (trimedClipItemDataModel.mVeRangeInRawVideo != null) {
            qClip.setProperty(QClip.PROP_CLIP_SRC_RANGE, new QRange(trimedClipItemDataModel.mVeRangeInRawVideo.getmPosition(), trimedClipItemDataModel.mVeRangeInRawVideo.getmTimeLength()));
        }
        try {
            i = qClip.getRealVideoDuration();
        } catch (Exception e) {
            e.printStackTrace();
            i = 0;
        }
        if (qStoryboard.insertClip(qClip, 0) != 0 || qSceneClip.setElementSource(0, qStoryboard) != 0) {
            return null;
        }
        QStoryboard qStoryboard2 = new QStoryboard();
        if (qStoryboard2.init(qEngine, null) != 0) {
            return null;
        }
        QClip qClip2 = new QClip();
        if (qClip2.init(qEngine, qMediaSource2) != 0) {
            return null;
        }
        if (trimedClipItemDataModel2.mVeRangeInRawVideo != null) {
            qClip2.setProperty(QClip.PROP_CLIP_SRC_RANGE, new QRange(trimedClipItemDataModel2.mVeRangeInRawVideo.getmPosition(), trimedClipItemDataModel2.mVeRangeInRawVideo.getmTimeLength()));
        }
        try {
            i2 = qClip2.getRealVideoDuration();
        } catch (Exception e2) {
            e2.printStackTrace();
            i2 = 0;
        }
        if (i2 >= i) {
            i2 = i;
        }
        if (qStoryboard2.insertClip(qClip2, 0) != 0 || qSceneClip.setElementSource(1, qStoryboard2) != 0) {
            return null;
        }
        QRange qRange = new QRange(0, i2);
        qStoryboard.getDataClip().setProperty(12292, qRange);
        if (qSceneClip.setElementSource(0, qStoryboard) != 0) {
            return null;
        }
        qStoryboard2.getDataClip().setProperty(12292, qRange);
        if (qSceneClip.setElementSource(1, qStoryboard2) != 0) {
            return null;
        }
        qSceneClip.setProperty(QClip.PROP_CLIP_PANZOOM_DISABLED, Boolean.TRUE);
        return qSceneClip;
    }

    /* renamed from: a */
    public static void m24799a(QClip qClip, float f) {
        if (qClip != null) {
            qClip.setProperty(QClip.PROP_AUDIO_MODIFY_BY_ASP, Boolean.valueOf(Math.abs(f - 0.0f) >= 1.0E-6f));
            qClip.setProperty(QClip.PROP_AUDIO_PITCH_DELTA, Float.valueOf(f));
        }
    }

    /* renamed from: a */
    public static void m24800a(QClip qClip, float f, boolean z) {
        if (qClip != null) {
            float f2 = 0.0f;
            if (!z) {
                f2 = QUtils.getAudioDeltaPitch(f);
            }
            if (!C8572y.m25061O(f, 1.0f)) {
                z = true;
            }
            qClip.setProperty(QClip.PROP_AUDIO_MODIFY_BY_ASP, Boolean.valueOf(z));
            qClip.setProperty(QClip.PROP_AUDIO_PITCH_DELTA, Float.valueOf(f2));
        }
    }

    /* renamed from: a */
    public static void m24801a(QClip qClip, int i, boolean z) {
        int h = m24827h(qClip, i);
        for (int i2 = 0; i2 < h; i2++) {
            QEffect b = m24816b(qClip, i, i2);
            if (b != null) {
                b.setProperty(QEffect.PROP_EFFECT_VISIBILITY, Boolean.valueOf(z));
            }
        }
    }

    /* renamed from: a */
    public static void m24802a(QClip qClip, String str, String str2) {
        if (qClip != null && !TextUtils.isEmpty(str)) {
            String str3 = (String) qClip.getProperty(QClip.PROP_CLIP_WATERMARK_CACHED);
            JsonObject jsonObject = TextUtils.isEmpty(str3) ? new JsonObject() : new JsonParser().parse(str3).getAsJsonObject();
            jsonObject.addProperty(str, str2);
            qClip.setProperty(QClip.PROP_CLIP_WATERMARK_CACHED, jsonObject.toString());
        }
    }

    /* renamed from: a */
    public static boolean m24803a(QEngine qEngine, QSceneClip qSceneClip, int i, TrimedClipItemDataModel trimedClipItemDataModel) {
        int i2;
        int i3;
        if (trimedClipItemDataModel != null) {
            String str = TextUtils.isEmpty(trimedClipItemDataModel.mExportPath) ? trimedClipItemDataModel.mRawFilePath : trimedClipItemDataModel.mExportPath;
            if (qSceneClip != null && i >= 0 && C8548e.isFileExisted(str)) {
                QStoryboard qStoryboard = new QStoryboard();
                if (qSceneClip.getElementSource(i, qStoryboard) == 0) {
                    QMediaSource qMediaSource = new QMediaSource(0, false, str);
                    QClip qClip = new QClip();
                    if (qClip.init(qEngine, qMediaSource) == 0) {
                        qStoryboard.removeAllClip();
                        if (trimedClipItemDataModel.bCrop.booleanValue()) {
                            QVideoInfo qVideoInfo = (QVideoInfo) qClip.getProperty(12291);
                            if (qVideoInfo != null) {
                                i3 = qVideoInfo.get(3);
                                i2 = qVideoInfo.get(4);
                            } else {
                                i2 = 0;
                                i3 = 0;
                            }
                            if (i3 != i2) {
                                QRect dK = C8572y.m25089dK(i3, i2);
                                if (dK != null) {
                                    qClip.setProperty(12314, dK);
                                }
                            }
                        }
                        if (trimedClipItemDataModel.mVeRangeInRawVideo != null) {
                            qClip.setProperty(QClip.PROP_CLIP_SRC_RANGE, new QRange(trimedClipItemDataModel.mVeRangeInRawVideo.getmPosition(), trimedClipItemDataModel.mVeRangeInRawVideo.getmTimeLength()));
                        }
                        qStoryboard.insertClip(qClip, 0);
                        int realVideoDuration = qClip.getRealVideoDuration();
                        qSceneClip.setElementSource(i, qStoryboard);
                        C8540q.m24935a(qStoryboard, C8572y.m25093f(qStoryboard.getDataClip()));
                        QStoryboard qStoryboard2 = new QStoryboard();
                        int i4 = i == 0 ? 1 : 0;
                        if (qSceneClip.getElementSource(i4, qStoryboard2) == 0 && qStoryboard2.getClipCount() > 0) {
                            QClip clip = qStoryboard2.getClip(0);
                            if (clip != null) {
                                int realVideoDuration2 = clip.getRealVideoDuration();
                                if (realVideoDuration2 < realVideoDuration) {
                                    realVideoDuration = realVideoDuration2;
                                }
                                qStoryboard2.getDataClip().setProperty(12292, new QRange(0, realVideoDuration));
                                qSceneClip.setElementSource(i4, qStoryboard2);
                            }
                        }
                        QClip dataClip = qStoryboard.getDataClip();
                        if (dataClip != null) {
                            dataClip.setProperty(12292, new QRange(0, realVideoDuration));
                        }
                        qSceneClip.setElementSource(i, qStoryboard);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m24804a(QClip qClip, Boolean bool) {
        boolean z = false;
        if (qClip != null) {
            Object property = qClip.getProperty(QClip.PROP_CLIP_PANZOOM_DISABLED);
            if (!(property instanceof Boolean)) {
                if (qClip.setProperty(QClip.PROP_CLIP_PANZOOM_DISABLED, Boolean.valueOf(bool.booleanValue())) == 0) {
                    z = true;
                }
                return z;
            } else if (((Boolean) property).booleanValue() != bool.booleanValue()) {
                if (qClip.setProperty(QClip.PROP_CLIP_PANZOOM_DISABLED, Boolean.valueOf(bool.booleanValue())) == 0) {
                    z = true;
                }
                return z;
            }
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m24805a(QClip qClip, String str, int i, int i2) {
        QTransition qTransition = new QTransition();
        if (TextUtils.isEmpty(str) || i <= 0) {
            qTransition.setTemplate(null);
            qTransition.setDuration(3000);
        } else {
            qTransition.setTemplate(str);
            qTransition.setDuration(i);
        }
        if (i2 > 0) {
            qTransition.setCfgIndex(i2);
        } else {
            qTransition.setCfgIndex(0);
        }
        if (!C8410e.aGX().aGY()) {
            qTransition.setAnimatedCfg(4);
        } else {
            qTransition.setAnimatedCfg(0);
        }
        return qClip.setProperty(12294, qTransition) == 0;
    }

    /* renamed from: a */
    public static boolean m24806a(QSceneClip qSceneClip, int i, int i2, boolean z) {
        if (qSceneClip == null) {
            return false;
        }
        QStoryboard qStoryboard = new QStoryboard();
        if (qSceneClip.getElementSource(i, qStoryboard) != 0) {
            return false;
        }
        QClip dataClip = qStoryboard.getDataClip();
        if (dataClip == null) {
            return false;
        }
        if (z) {
            QSFParam qSFParam = new QSFParam();
            qSFParam.isSingleFrame = true;
            qSFParam.timeStamp = i2;
            dataClip.setProperty(QClip.PROP_CLIP_SINGLE_FRAME_PARAM, qSFParam);
        } else {
            QSFParam qSFParam2 = new QSFParam();
            qSFParam2.isSingleFrame = false;
            qSFParam2.timeStamp = 0;
            dataClip.setProperty(QClip.PROP_CLIP_SINGLE_FRAME_PARAM, qSFParam2);
        }
        return true;
    }

    /* renamed from: a */
    public static boolean m24807a(QSceneClip qSceneClip, int i, Rect rect) {
        boolean z = false;
        if (qSceneClip == null || i < 0 || rect == null) {
            return false;
        }
        QStoryboard qStoryboard = new QStoryboard();
        if (qSceneClip.getElementSource(i, qStoryboard) != 0) {
            return false;
        }
        if (qStoryboard.getDataClip().setProperty(12314, new QRect(rect.left, rect.top, rect.right, rect.bottom)) == 0) {
            z = true;
        }
        return z;
    }

    /* renamed from: a */
    public static boolean m24808a(QSceneClip qSceneClip, int i, VeRange veRange) {
        boolean z = false;
        if (!(qSceneClip == null || i < 0 || veRange == null)) {
            int elementCount = qSceneClip.getElementCount();
            for (int i2 = 0; i2 < elementCount; i2++) {
                if (i2 == i) {
                    QStoryboard qStoryboard = new QStoryboard();
                    if (qSceneClip.getElementSource(i2, qStoryboard) == 0) {
                        QClip dataClip = qStoryboard.getDataClip();
                        if (dataClip != null && dataClip.setProperty(12292, new QRange(veRange.getmPosition(), veRange.getmTimeLength())) == 0) {
                            if (qSceneClip.setElementSource(i2, qStoryboard) == 0) {
                                z = true;
                            }
                            return z;
                        }
                    } else {
                        continue;
                    }
                }
            }
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m24809a(QSceneClip qSceneClip, int i, boolean z) {
        QStoryboard qStoryboard = new QStoryboard();
        if (qSceneClip.getElementSource(i, qStoryboard) != 0) {
            return false;
        }
        QClip dataClip = qStoryboard.getDataClip();
        if (dataClip == null) {
            return false;
        }
        if (z) {
            dataClip.setProperty(12301, Boolean.TRUE);
        } else {
            dataClip.setProperty(12301, Boolean.FALSE);
        }
        return true;
    }

    /* renamed from: a */
    public static boolean m24810a(QSceneClip qSceneClip, long j, VeMSize veMSize) {
        if (!(qSceneClip == null || j <= 0 || veMSize == null)) {
            QSize qSize = new QSize();
            qSize.mWidth = veMSize.width;
            qSize.mHeight = veMSize.height;
            qSceneClip.setSceneTemplate(j, qSize);
        }
        return true;
    }

    /* renamed from: a */
    public static QEffectPropertyData[] m24811a(QEngine qEngine, QClip qClip, int i, long j) {
        QEffectPropertyData qEffectPropertyData;
        QEffectPropertyInfo[] iEPropertyInfo = QStyle.getIEPropertyInfo(qEngine, j);
        if (iEPropertyInfo == null || iEPropertyInfo.length <= 0) {
            return null;
        }
        QEffectPropertyData[] qEffectPropertyDataArr = new QEffectPropertyData[iEPropertyInfo.length];
        int h = m24827h(qClip, i);
        int i2 = 0;
        for (QEffectPropertyInfo qEffectPropertyInfo : iEPropertyInfo) {
            if (h > 0) {
                qEffectPropertyData = m24816b(qClip, i, 0).getEffectPropData(qEffectPropertyInfo.f3719id);
            } else {
                QEffectPropertyData qEffectPropertyData2 = new QEffectPropertyData();
                qEffectPropertyData2.mID = qEffectPropertyInfo.f3719id;
                qEffectPropertyData2.mValue = qEffectPropertyInfo.cur_value;
                qEffectPropertyData = qEffectPropertyData2;
            }
            if (qEffectPropertyData != null) {
                int i3 = i2 + 1;
                qEffectPropertyDataArr[i2] = qEffectPropertyData;
                i2 = i3;
            }
        }
        return qEffectPropertyDataArr;
    }

    /* renamed from: b */
    public static float m24812b(QClip qClip, int i, float f) {
        int j = C8540q.m24957j(qClip, i);
        if (j > 0) {
            for (int i2 = 0; i2 < j; i2++) {
                QEffect d = C8540q.m24947d(qClip, i, i2);
                if (d != null) {
                    Float f2 = (Float) d.getProperty(4100);
                    if (f2 != null && f2.floatValue() > f) {
                        f = f2.floatValue();
                    }
                }
            }
        }
        return f;
    }

    /* renamed from: b */
    public static String m24813b(QEngine qEngine, QClip qClip) {
        String str = "";
        QTransition qTransition = (QTransition) qClip.getProperty(12294);
        if (qTransition != null) {
            str = qTransition.getTemplate();
        }
        if (qEngine == null) {
            return str;
        }
        long GetTemplateID = qEngine.GetTemplateID(str);
        return (GetTemplateID == 4827858800541171724L || GetTemplateID == 4827858800541171726L || GetTemplateID == 4827858800541171727L) ? qEngine.GetTemplateFile(216172782113783821L) : str;
    }

    /* renamed from: b */
    public static ArrayList<TrimedClipItemDataModel> m24814b(QSceneClip qSceneClip) {
        ArrayList<TrimedClipItemDataModel> arrayList = new ArrayList<>();
        int elementCount = qSceneClip.getElementCount();
        for (int i = 0; i < elementCount; i++) {
            QStoryboard qStoryboard = new QStoryboard();
            if (qSceneClip.getElementSource(i, qStoryboard) == 0 && qStoryboard.getClipCount() > 0) {
                QClip clip = qStoryboard.getClip(0);
                if (clip != null) {
                    QMediaSource qMediaSource = (QMediaSource) clip.getProperty(12290);
                    QRange qRange = (QRange) clip.getProperty(QClip.PROP_CLIP_SRC_RANGE);
                    if (qMediaSource != null && qMediaSource.getSourceType() == 0) {
                        Object source = qMediaSource.getSource();
                        if (source != null) {
                            TrimedClipItemDataModel trimedClipItemDataModel = new TrimedClipItemDataModel();
                            trimedClipItemDataModel.mRawFilePath = (String) source;
                            if (qRange != null) {
                                trimedClipItemDataModel.mVeRangeInRawVideo = new VeRange(qRange.get(0), qRange.get(1));
                            }
                            arrayList.add(trimedClipItemDataModel);
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    /* renamed from: b */
    public static ArrayList<TrimedClipItemDataModel> m24815b(QSceneClip qSceneClip, int i) {
        ArrayList<TrimedClipItemDataModel> arrayList = null;
        if (qSceneClip.getElementCount() > i) {
            QStoryboard qStoryboard = new QStoryboard();
            if (qSceneClip.getElementSource(i, qStoryboard) != 0) {
                return null;
            }
            int clipCount = qStoryboard.getClipCount();
            if (clipCount > 0) {
                arrayList = new ArrayList<>();
                for (int i2 = 0; i2 < clipCount; i2++) {
                    QClip i3 = C8540q.m24956i(qStoryboard, i2);
                    if (i3 != null) {
                        TrimedClipItemDataModel trimedClipItemDataModel = new TrimedClipItemDataModel();
                        QRange qRange = (QRange) i3.getProperty(QClip.PROP_CLIP_SRC_RANGE);
                        QMediaSource qMediaSource = (QMediaSource) i3.getProperty(12290);
                        if (qMediaSource != null && qMediaSource.getSourceType() == 0) {
                            Object source = qMediaSource.getSource();
                            if (source != null) {
                                trimedClipItemDataModel.mRawFilePath = (String) source;
                            }
                        }
                        if (qRange != null) {
                            trimedClipItemDataModel.mVeRangeInRawVideo = new VeRange(qRange.get(0), qRange.get(1));
                        }
                        arrayList.add(trimedClipItemDataModel);
                    }
                }
            }
        }
        return arrayList;
    }

    /* renamed from: b */
    public static QEffect m24816b(QClip qClip, int i, int i2) {
        if (qClip == null || i2 < 0) {
            return null;
        }
        return qClip.getEffectByGroup(2, i, i2);
    }

    /* renamed from: b */
    public static QEffectPropertyData[] m24817b(QEngine qEngine, QClip qClip, int i, long j) {
        QEffectPropertyData qEffectPropertyData;
        QEffectPropertyInfo[] iEPropertyInfo = QStyle.getIEPropertyInfo(qEngine, j);
        if (iEPropertyInfo == null || iEPropertyInfo.length <= 0) {
            return null;
        }
        QEffectPropertyData[] qEffectPropertyDataArr = new QEffectPropertyData[iEPropertyInfo.length];
        int i2 = m24829i(qClip, i);
        int i3 = 0;
        for (QEffectPropertyInfo qEffectPropertyInfo : iEPropertyInfo) {
            if (i2 > 0) {
                QEffect a = m24797a(qClip, i, 0);
                qEffectPropertyData = a != null ? a.getEffectPropData(qEffectPropertyInfo.f3719id) : null;
            } else {
                QEffectPropertyData qEffectPropertyData2 = new QEffectPropertyData();
                qEffectPropertyData2.mID = qEffectPropertyInfo.f3719id;
                qEffectPropertyData2.mValue = qEffectPropertyInfo.cur_value;
                qEffectPropertyData = qEffectPropertyData2;
            }
            if (qEffectPropertyData != null) {
                int i4 = i3 + 1;
                qEffectPropertyDataArr[i3] = qEffectPropertyData;
                i3 = i4;
            }
        }
        return qEffectPropertyDataArr;
    }

    /* renamed from: c */
    public static int m24818c(QClip qClip, int i, int i2) {
        QEffect b = m24816b(qClip, i2, i);
        if (b == null) {
            return 0;
        }
        int removeEffect = qClip.removeEffect(b);
        if (removeEffect == 0) {
            b.destory();
        }
        return removeEffect;
    }

    /* renamed from: c */
    public static boolean m24819c(QSceneClip qSceneClip, int i) {
        QStoryboard qStoryboard = new QStoryboard();
        if (qSceneClip.getElementSource(i, qStoryboard) != 0) {
            return false;
        }
        QClip dataClip = qStoryboard.getDataClip();
        if (dataClip != null) {
            return ((Boolean) dataClip.getProperty(12301)).booleanValue();
        }
        return false;
    }

    /* renamed from: c */
    public static PIPItemInfo[] m24820c(QSceneClip qSceneClip) {
        PIPItemInfo[] pIPItemInfoArr = null;
        if (qSceneClip != null && qSceneClip.getElementCount() >= 2) {
            PIPItemInfo[] pIPItemInfoArr2 = new PIPItemInfo[2];
            int i = 0;
            while (true) {
                if (i >= 2) {
                    pIPItemInfoArr = pIPItemInfoArr2;
                    break;
                }
                QStoryboard qStoryboard = new QStoryboard();
                if (qSceneClip.getElementSource(i, qStoryboard) != 0) {
                    break;
                }
                QClip dataClip = qStoryboard.getDataClip();
                if (dataClip != null) {
                    int intValue = ((Integer) dataClip.getProperty(QStoryboard.PROP_ORIGINAL_DURATION)).intValue();
                    QRange qRange = (QRange) dataClip.getProperty(12292);
                    if (intValue > 0 && qRange != null) {
                        PIPItemInfo pIPItemInfo = new PIPItemInfo();
                        pIPItemInfo.setmSrcDuration(intValue);
                        int i2 = qRange.get(0);
                        int i3 = qRange.get(1);
                        if (i3 < 0) {
                            i3 = intValue;
                        }
                        pIPItemInfo.setmRange(new VeRange(i2, i3));
                        pIPItemInfo.setmClip(dataClip);
                        pIPItemInfo.setmItemIndex(i);
                        pIPItemInfoArr2[i] = pIPItemInfo;
                    }
                }
                i++;
            }
            if (!(pIPItemInfoArr == null || pIPItemInfoArr.length < 2 || pIPItemInfoArr[1] == null || pIPItemInfoArr[0] == null || pIPItemInfoArr[1].getmSrcDuration() >= pIPItemInfoArr[0].getmSrcDuration())) {
                PIPItemInfo pIPItemInfo2 = pIPItemInfoArr[0];
                pIPItemInfoArr[0] = pIPItemInfoArr[1];
                pIPItemInfoArr[1] = pIPItemInfo2;
            }
        }
        return pIPItemInfoArr;
    }

    /* renamed from: e */
    public static void m24821e(QClip qClip, int i) {
        if (qClip != null) {
            qClip.setProperty(12295, Integer.valueOf(65537));
            QRange qRange = new QRange();
            qRange.set(0, 0);
            if (i <= 0) {
                i = 3000;
            }
            qRange.set(1, i);
            qClip.setProperty(12292, qRange);
        }
    }

    /* renamed from: f */
    static int m24822f(QClip qClip, int i) {
        if (qClip != null) {
            int j = C8540q.m24957j(qClip, i);
            if (j > 0) {
                for (int i2 = j - 1; i2 >= 0; i2--) {
                    QEffect d = C8540q.m24947d(qClip, i, i2);
                    if (d != null && qClip.removeEffect(d) == 0) {
                        d.destory();
                    }
                }
            }
        }
        return 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x003b  */
    /* renamed from: f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.introvd.template.sdk.utils.VeMSize m24823f(xiaoying.engine.clip.QClip r6) {
        /*
            r0 = 0
            if (r6 == 0) goto L_0x0079
            r1 = 0
            boolean r2 = r6 instanceof xiaoying.engine.clip.QSceneClip
            if (r2 != 0) goto L_0x0031
            boolean r2 = r6 instanceof xiaoying.engine.cover.QCover
            if (r2 != 0) goto L_0x0031
            r2 = 12315(0x301b, float:1.7257E-41)
            java.lang.Object r2 = r6.getProperty(r2)     // Catch:{ Exception -> 0x002d }
            java.lang.Integer r2 = (java.lang.Integer) r2     // Catch:{ Exception -> 0x002d }
            int r2 = r2.intValue()     // Catch:{ Exception -> 0x002d }
            r1 = 360(0x168, float:5.04E-43)
            if (r2 >= 0) goto L_0x0026
            int r3 = r2 % 360
            int r3 = r3 + r1
            r1 = r3
            goto L_0x0031
        L_0x0021:
            r1 = move-exception
            r5 = r2
            r2 = r1
            r1 = r5
            goto L_0x002e
        L_0x0026:
            if (r2 <= r1) goto L_0x002b
            int r1 = r2 % 360
            goto L_0x0031
        L_0x002b:
            r1 = r2
            goto L_0x0031
        L_0x002d:
            r2 = move-exception
        L_0x002e:
            r2.printStackTrace()
        L_0x0031:
            r2 = 12291(0x3003, float:1.7223E-41)
            java.lang.Object r2 = r6.getProperty(r2)
            xiaoying.engine.base.QVideoInfo r2 = (xiaoying.engine.base.QVideoInfo) r2
            if (r2 == 0) goto L_0x0067
            r0 = 3
            int r0 = r2.get(r0)
            r3 = 4
            int r2 = r2.get(r3)
            r3 = 12314(0x301a, float:1.7256E-41)
            java.lang.Object r6 = r6.getProperty(r3)
            xiaoying.utils.QRect r6 = (xiaoying.utils.QRect) r6
            if (r6 == 0) goto L_0x0061
            int r3 = r6.right
            int r4 = r6.left
            int r3 = r3 - r4
            int r0 = r0 * r3
            int r0 = r0 / 10000
            int r3 = r6.bottom
            int r6 = r6.top
            int r3 = r3 - r6
            int r2 = r2 * r3
            int r2 = r2 / 10000
        L_0x0061:
            com.introvd.template.sdk.utils.VeMSize r6 = new com.introvd.template.sdk.utils.VeMSize
            r6.<init>(r0, r2)
            r0 = r6
        L_0x0067:
            if (r0 == 0) goto L_0x0079
            r6 = 90
            if (r1 == r6) goto L_0x0071
            r6 = 270(0x10e, float:3.78E-43)
            if (r1 != r6) goto L_0x0079
        L_0x0071:
            int r6 = r0.height
            int r1 = r0.width
            r0.height = r1
            r0.width = r6
        L_0x0079:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.sdk.utils.p394b.C8537n.m24823f(xiaoying.engine.clip.QClip):com.introvd.template.sdk.utils.VeMSize");
    }

    /* renamed from: f */
    public static QClip m24824f(String str, QEngine qEngine) {
        QClip qClip = new QClip();
        if (qClip.init(qEngine, new QMediaSource(0, false, str)) != 0) {
            return null;
        }
        return qClip;
    }

    /* renamed from: g */
    public static String m24825g(QClip qClip, int i) {
        String str = "";
        if (!(qClip instanceof QCover)) {
            return str;
        }
        QCover qCover = (QCover) qClip;
        return m24795a(qCover, i, qCover.getTitle(i));
    }

    /* renamed from: g */
    public static boolean m24826g(QClip qClip) {
        boolean z = false;
        if (qClip == null) {
            return false;
        }
        QVideoInfo qVideoInfo = (QVideoInfo) qClip.getProperty(12291);
        int intValue = ((Integer) qClip.getProperty(12289)).intValue();
        if (qVideoInfo.get(6) > 0 && intValue == 1) {
            z = true;
        }
        return z;
    }

    /* renamed from: h */
    public static int m24827h(QClip qClip, int i) {
        if (qClip != null) {
            return qClip.getEffectCountByGroup(2, i);
        }
        return 0;
    }

    /* renamed from: h */
    public static VeMSize m24828h(QClip qClip) {
        if (qClip == null) {
            return null;
        }
        VeMSize veMSize = new VeMSize();
        QVideoInfo qVideoInfo = (QVideoInfo) qClip.getProperty(12291);
        if (qVideoInfo != null) {
            veMSize.width = qVideoInfo.get(3);
            veMSize.height = qVideoInfo.get(4);
        }
        return veMSize;
    }

    /* renamed from: i */
    public static int m24829i(QClip qClip, int i) {
        if (qClip != null) {
            return qClip.getEffectCountByGroup(1, i);
        }
        return 0;
    }

    /* renamed from: i */
    public static QClip m24830i(QClip qClip) {
        if (qClip == null) {
            return null;
        }
        QClip qClip2 = new QClip();
        if (qClip.duplicate(qClip2) == 0) {
            return qClip2;
        }
        qClip2.unInit();
        return null;
    }

    /* renamed from: j */
    public static Bitmap m24831j(QClip qClip) {
        Bitmap bitmap = null;
        if (qClip == null) {
            return null;
        }
        Integer num = (Integer) qClip.getProperty(12313);
        Integer num2 = (Integer) qClip.getProperty(12289);
        if ((num == null || !(1 == num.intValue() || 2 == num.intValue())) && num2 != null) {
            bitmap = (Bitmap) C8572y.m25066a(qClip, 0, 120, 120, num2.intValue() != 2, false, 65538, true, false);
        }
        return bitmap;
    }

    /* renamed from: k */
    public static QEffect m24832k(QClip qClip) {
        if (m24833l(qClip)) {
            return C8540q.m24947d(qClip, 1, 0);
        }
        return null;
    }

    /* renamed from: l */
    private static boolean m24833l(QClip qClip) {
        return qClip != null && C8540q.m24957j(qClip, 1) > 0;
    }

    /* renamed from: m */
    public static float m24834m(QClip qClip) {
        if (qClip != null) {
            return ((Float) qClip.getProperty(12293)).floatValue();
        }
        return 1.0f;
    }

    /* JADX WARNING: Removed duplicated region for block: B:7:0x0018  */
    /* renamed from: n */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.Boolean m24835n(xiaoying.engine.clip.QClip r2) {
        /*
            r0 = 1
            if (r2 == 0) goto L_0x0014
            r1 = 12321(0x3021, float:1.7265E-41)
            java.lang.Object r2 = r2.getProperty(r1)
            boolean r1 = r2 instanceof java.lang.Boolean
            if (r1 == 0) goto L_0x0014
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            goto L_0x0015
        L_0x0014:
            r2 = 1
        L_0x0015:
            if (r2 != 0) goto L_0x0018
            goto L_0x0019
        L_0x0018:
            r0 = 0
        L_0x0019:
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.sdk.utils.p394b.C8537n.m24835n(xiaoying.engine.clip.QClip):java.lang.Boolean");
    }

    /* renamed from: o */
    public static Boolean m24836o(QClip qClip) {
        boolean z;
        if (qClip != null) {
            Object property = qClip.getProperty(QClip.PROP_CLIP_IS_REVERSE_CLIP);
            if ((property instanceof Boolean) && ((Boolean) property).booleanValue()) {
                Object property2 = qClip.getProperty(QClip.PROP_CLIP_IS_REVERSE_MODE);
                if (property2 instanceof Boolean) {
                    z = ((Boolean) property2).booleanValue();
                    return Boolean.valueOf(z);
                }
            }
        }
        z = false;
        return Boolean.valueOf(z);
    }

    /* renamed from: p */
    public static boolean m24837p(QClip qClip) {
        if (qClip == null) {
            return false;
        }
        Object property = qClip.getProperty(12300);
        if (property == null) {
            return false;
        }
        return ((Boolean) property).booleanValue();
    }

    /* renamed from: q */
    public static int m24838q(QClip qClip) {
        if (qClip != null) {
            QTransition qTransition = (QTransition) qClip.getProperty(12294);
            if (qTransition != null) {
                return qTransition.getDuration();
            }
        }
        return -1;
    }

    /* renamed from: r */
    public static int m24839r(QClip qClip) {
        if (qClip != null) {
            QTransition qTransition = (QTransition) qClip.getProperty(12294);
            if (qTransition != null) {
                return qTransition.getCfgIndex();
            }
        }
        return 0;
    }

    /* renamed from: s */
    public static float m24840s(QClip qClip) {
        float f;
        if (qClip == null) {
            return 0.0f;
        }
        try {
            f = Float.parseFloat(qClip.getProperty(QClip.PROP_AUDIO_PITCH_DELTA).toString());
        } catch (NumberFormatException unused) {
            f = 0.0f;
        }
        return f;
    }
}
