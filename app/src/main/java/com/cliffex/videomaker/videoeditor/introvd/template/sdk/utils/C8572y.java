package com.introvd.template.sdk.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.introvd.template.router.todoCode.TodoConstants;
import com.introvd.template.sdk.C8401d;
import com.introvd.template.sdk.C8410e;
import com.introvd.template.sdk.editor.cache.TrimedClipItemDataModel;
import com.introvd.template.sdk.p386e.C8417b;
import com.introvd.template.sdk.p391g.C8450a;
import com.introvd.template.sdk.utils.p393a.C8482a;
import com.introvd.template.sdk.utils.p394b.C8501a;
import com.introvd.template.sdk.utils.p394b.C8537n;
import com.introvd.template.sdk.utils.p394b.C8540q;
import com.introvd.template.sdk.utils.p394b.C8541r;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import xiaoying.engine.QEngine;
import xiaoying.engine.base.QDisplayContext;
import xiaoying.engine.base.QRange;
import xiaoying.engine.base.QSourceExtInfo;
import xiaoying.engine.base.QUtils;
import xiaoying.engine.base.QVEError;
import xiaoying.engine.base.QVideoImportParam;
import xiaoying.engine.base.QVideoInfo;
import xiaoying.engine.clip.QClip;
import xiaoying.engine.clip.QMediaSource;
import xiaoying.engine.clip.QSceneClip;
import xiaoying.engine.storyboard.QStoryboard;
import xiaoying.utils.QAndroidBitmapFactory;
import xiaoying.utils.QBitmap;
import xiaoying.utils.QBitmapFactory;
import xiaoying.utils.QColorSpace;
import xiaoying.utils.QPoint;
import xiaoying.utils.QRect;
import xiaoying.utils.QStreamAssets;

/* renamed from: com.introvd.template.sdk.utils.y */
public class C8572y {
    public static final VeMSize egH = new VeMSize((int) QUtils.VIDEO_RES_VGA_WIDTH, 480);
    public static final VeMSize ehj = new VeMSize(320, 240);
    private static final VeMSize ehk = new VeMSize((int) QUtils.VIDEO_RES_VGA_WIDTH, 480);

    /* renamed from: O */
    public static boolean m25061O(float f, float f2) {
        return m25102s(f, f2, 0.001f);
    }

    /* renamed from: a */
    public static int m25062a(QClip qClip, int i, int i2, int i3, boolean z, boolean z2) {
        if (qClip == null || i <= 0 || i2 <= 0) {
            return 2;
        }
        Integer num = (Integer) qClip.getProperty(12289);
        if (num == null) {
            return 2;
        }
        boolean z3 = 2 == num.intValue();
        QVideoInfo qVideoInfo = (QVideoInfo) qClip.getProperty(12291);
        Rect rect = new Rect(0, 0, qVideoInfo.get(3), qVideoInfo.get(4));
        Rect b = m25077b(rect, new Rect(0, 0, i, i2));
        int min = z3 ? Math.min(rect.width(), b.width()) : qVideoInfo.get(3);
        int min2 = z3 ? Math.min(rect.height(), b.height()) : qVideoInfo.get(4);
        int dI = m25087dI(min, 4);
        int dI2 = m25087dI(min2, 4);
        return z ? qClip.createThumbnailManager(dI, dI2, i3, true, z2) : qClip.createThumbnailManager(dI, dI2, i3, z2);
    }

    /* renamed from: a */
    public static int m25063a(QClip qClip, QBitmap qBitmap, int i, boolean z) {
        if (qClip == null || qBitmap == null) {
            return 2;
        }
        try {
            return qClip.getThumbnail(qBitmap, i, z);
        } catch (IllegalArgumentException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("exception:");
            sb.append(e.getMessage());
            C8554j.m25007e("XYSDKUtil", sb.toString());
            return QVEError.QERR_APP_FAIL;
        }
    }

    /* renamed from: a */
    public static VeMSize m25064a(VeMSize veMSize, VeMSize veMSize2, VeMSize veMSize3) {
        int i = veMSize.width;
        int i2 = veMSize.height;
        float f = ((float) i) / ((float) i2);
        if (i >= i2) {
            i = veMSize2.width;
            i2 = (int) (((float) i) / f);
        } else if (veMSize3.height < veMSize2.width) {
            i2 = veMSize3.height;
            i = (int) (((float) i2) * f);
        }
        return new VeMSize(i, i2);
    }

    /* renamed from: a */
    public static VeMSize m25065a(VeMSize veMSize, VeMSize veMSize2, boolean z) {
        if (z) {
            m25095h(veMSize2);
        }
        VeMSize d = m25086d(new VeMSize(veMSize2.width, veMSize2.height), veMSize);
        VeMSize veMSize3 = new VeMSize(d.width, d.height);
        if (d.width * d.height > veMSize2.width * veMSize2.height) {
            veMSize3.width = m25087dI(veMSize2.width, 4);
            veMSize3.height = m25087dI(veMSize2.height, 4);
        }
        return veMSize3;
    }

    /* renamed from: a */
    public static Object m25066a(QClip qClip, int i, int i2, int i3, boolean z, boolean z2, int i4, boolean z3, boolean z4) {
        if (qClip == null) {
            return null;
        }
        VeMSize dJ = m25088dJ(i2, i3);
        int i5 = dJ.width;
        int i6 = dJ.height;
        if (m25062a(qClip, i5, i6, i4, z3, z4) != 0) {
            return null;
        }
        QBitmap createQBitmapBlank = QBitmapFactory.createQBitmapBlank(i5, i6, QColorSpace.QPAF_RGB32_A8R8G8B8);
        if (createQBitmapBlank == null) {
            return null;
        }
        if (m25063a(qClip, createQBitmapBlank, i, z) != 0) {
            if (!createQBitmapBlank.isRecycled()) {
                createQBitmapBlank.recycle();
            }
            qClip.destroyThumbnailManager();
            return null;
        }
        qClip.destroyThumbnailManager();
        if (z2) {
            return createQBitmapBlank;
        }
        Bitmap createBitmapFromQBitmap = QAndroidBitmapFactory.createBitmapFromQBitmap(createQBitmapBlank, false);
        if (!createQBitmapBlank.isRecycled()) {
            createQBitmapBlank.recycle();
        }
        return createBitmapFromQBitmap;
    }

    /* renamed from: a */
    public static ArrayList<C8417b> m25067a(QSceneClip qSceneClip, VeMSize veMSize) {
        Rect rect;
        QSceneClip qSceneClip2 = qSceneClip;
        VeMSize veMSize2 = veMSize;
        ArrayList<C8417b> arrayList = new ArrayList<>();
        if (qSceneClip2 != null && veMSize2 != null) {
            int elementCount = qSceneClip.getElementCount();
            if (elementCount > 0) {
                int i = 0;
                int i2 = 0;
                while (i2 < elementCount) {
                    C8417b bVar = new C8417b();
                    QStoryboard qStoryboard = new QStoryboard();
                    if (qSceneClip2.getElementSource(i2, qStoryboard) == 0) {
                        QClip dataClip = qStoryboard.getDataClip();
                        VeMSize f = m25093f(dataClip);
                        StringBuilder sb = new StringBuilder();
                        sb.append("updateSceneClipSourceRegion1 videoSize:");
                        sb.append(f);
                        C8554j.m25010v("XYSDKUtil", sb.toString());
                        QRect qRect = (QRect) dataClip.getProperty(12314);
                        Rect rect2 = new Rect(qRect.left, qRect.top, qRect.right, qRect.bottom);
                        QRect elementRegion = qSceneClip2.getElementRegion(i2);
                        VeMSize veMSize3 = null;
                        if (elementRegion != null) {
                            Rect rect3 = new Rect(elementRegion.left, elementRegion.top, elementRegion.right, elementRegion.bottom);
                            VeMSize veMSize4 = new VeMSize(m25087dI((veMSize2.width * (elementRegion.right - elementRegion.left)) / 10000, 4), m25087dI((veMSize2.height * (elementRegion.bottom - elementRegion.top)) / 10000, 4));
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("updateSceneClipSourceRegion111 region.left:");
                            sb2.append(elementRegion.left);
                            sb2.append(";region.top=");
                            sb2.append(elementRegion.top);
                            C8554j.m25010v("XYSDKUtil", sb2.toString());
                            rect = rect3;
                            veMSize3 = veMSize4;
                        } else {
                            rect = null;
                        }
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("updateSceneClipSourceRegion2 mStreamSizeVe:");
                        sb3.append(veMSize2);
                        C8554j.m25010v("XYSDKUtil", sb3.toString());
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append("updateSceneClipSourceRegion3 itemPreviewSize:");
                        sb4.append(veMSize3);
                        C8554j.m25010v("XYSDKUtil", sb4.toString());
                        VeMSize c = m25083c(f, veMSize3);
                        if (c == null || c.width <= 0 || c.height <= 0) {
                            break;
                        }
                        Rect rect4 = new Rect(i, i, (veMSize3.width * 10000) / c.width, (veMSize3.height * 10000) / c.height);
                        int clipCount = qStoryboard.getClipCount();
                        for (int i3 = 0; i3 < clipCount; i3++) {
                            QClip clip = qStoryboard.getClip(i3);
                            if (clip != null) {
                                QMediaSource qMediaSource = (QMediaSource) clip.getProperty(12290);
                                if (qMediaSource != null && qMediaSource.getSourceType() == 0) {
                                    Object source = qMediaSource.getSource();
                                    if (source != null) {
                                        bVar.mo34134jo(TextUtils.indexOf((String) source, QStreamAssets.ASSETS_THEME) != 0);
                                    }
                                }
                            }
                        }
                        QPoint elementTipsLocation = qSceneClip2.getElementTipsLocation(i2);
                        if (elementTipsLocation != null) {
                            bVar.mo34133i(new Point(elementTipsLocation.f3733x, elementTipsLocation.f3734y));
                        }
                        bVar.mo34135p(rect);
                        bVar.mo34131c(veMSize3);
                        bVar.mo34136q(rect2);
                        bVar.mo34132e(c);
                        bVar.mo34137r(rect4);
                        arrayList.add(bVar);
                        i2++;
                        i = 0;
                    } else {
                        break;
                    }
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public static QVideoImportParam m25068a(String str, boolean z, boolean z2, boolean z3) {
        QVideoImportParam qVideoImportParam = new QVideoImportParam();
        qVideoImportParam.setFilePath(str);
        qVideoImportParam.setPIPFlag(z);
        qVideoImportParam.setHWEncFlag(z3);
        qVideoImportParam.setHWDecFlag(z3);
        qVideoImportParam.setCPUNum(C8482a.getCpuNumber());
        qVideoImportParam.setReverseFlag(z2);
        qVideoImportParam.setHDOutputFlag(C8549f.aJe().booleanValue());
        return qVideoImportParam;
    }

    /* renamed from: a */
    public static QStoryboard m25069a(QEngine qEngine, TrimedClipItemDataModel trimedClipItemDataModel) {
        return m25071a(qEngine, trimedClipItemDataModel.mRawFilePath, null, trimedClipItemDataModel.isImage.booleanValue(), trimedClipItemDataModel.bCrop.booleanValue(), trimedClipItemDataModel.cropRect, false);
    }

    /* renamed from: a */
    public static QStoryboard m25070a(QEngine qEngine, String str, QRange qRange) {
        return m25071a(qEngine, str, qRange, false, false, null, false);
    }

    /* renamed from: a */
    private static QStoryboard m25071a(QEngine qEngine, String str, QRange qRange, boolean z, boolean z2, RectF rectF, boolean z3) {
        QStoryboard qStoryboard;
        if (C8548e.isFileExisted(str)) {
            int i = C8541r.m24979e(qEngine, str).duration;
            if (i <= 0) {
                return null;
            }
            QClip f = C8537n.m24824f(str, qEngine);
            if (f == null) {
                return null;
            }
            if (z3) {
                f.setProperty(QClip.PROP_CLIP_IS_FRAME_MODE, Boolean.TRUE);
            }
            if (z) {
                C8537n.m24821e(f, -1);
            }
            if (z2 && rectF != null) {
                f.setProperty(12314, new QRect((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom));
            }
            if (qRange != null) {
                if (f.setProperty(QClip.PROP_CLIP_SRC_RANGE, qRange) != 0) {
                    f.unInit();
                    return null;
                }
                i = qRange.get(1);
            }
            if (f.setProperty(QClip.PROP_CLIP_PANZOOM_DISABLED, Boolean.TRUE) != 0) {
                f.unInit();
                return null;
            }
            qStoryboard = new QStoryboard();
            if (qStoryboard.init(qEngine, null) != 0) {
                qStoryboard.unInit();
                return null;
            }
            QRange qRange2 = new QRange();
            qRange2.set(0, 0);
            qRange2.set(1, i - 0);
            if (f.setProperty(12292, qRange2) != 0) {
                qStoryboard.unInit();
                return null;
            } else if (C8540q.m24923a(qStoryboard, f, 0) != 0) {
                qStoryboard.unInit();
                return null;
            }
        } else {
            qStoryboard = null;
        }
        return qStoryboard;
    }

    /* renamed from: a */
    public static boolean m25072a(C8501a aVar) {
        boolean z = false;
        if (aVar == null) {
            return false;
        }
        if (QUtils.IsSupportHD(aVar.aJv()) != 0) {
            z = true;
        }
        return z;
    }

    /* renamed from: a */
    public static boolean m25073a(QSceneClip qSceneClip, VeMSize veMSize, boolean z) {
        VeMSize veMSize2;
        QSceneClip qSceneClip2 = qSceneClip;
        VeMSize veMSize3 = veMSize;
        if (qSceneClip2 == null || veMSize3 == null) {
            return false;
        }
        int elementCount = qSceneClip.getElementCount();
        for (int i = 0; i < elementCount; i++) {
            QStoryboard qStoryboard = new QStoryboard();
            if (qSceneClip2.getElementSource(i, qStoryboard) == 0) {
                QClip dataClip = qStoryboard.getDataClip();
                VeMSize f = m25093f(dataClip);
                StringBuilder sb = new StringBuilder();
                sb.append("updateSceneClipSourceRegion1 videoSize:");
                sb.append(f);
                C8554j.m25010v("XYSDKUtil", sb.toString());
                QRect qRect = (QRect) dataClip.getProperty(12314);
                Rect rect = new Rect(qRect.left, qRect.top, qRect.right, qRect.bottom);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("updateSceneClipSourceRegion11 oldRect:");
                sb2.append(rect);
                C8554j.m25010v("XYSDKUtil", sb2.toString());
                QRect elementRegion = qSceneClip2.getElementRegion(i);
                if (elementRegion != null) {
                    veMSize2 = new VeMSize(m25087dI((veMSize3.width * (elementRegion.right - elementRegion.left)) / 10000, 4), m25087dI((veMSize3.height * (elementRegion.bottom - elementRegion.top)) / 10000, 4));
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("updateSceneClipSourceRegion111 region.left:");
                    sb3.append(elementRegion.left);
                    sb3.append(";region.top=");
                    sb3.append(elementRegion.top);
                    C8554j.m25010v("XYSDKUtil", sb3.toString());
                } else {
                    veMSize2 = null;
                }
                StringBuilder sb4 = new StringBuilder();
                sb4.append("updateSceneClipSourceRegion2 streamSizeVe:");
                sb4.append(veMSize3);
                C8554j.m25010v("XYSDKUtil", sb4.toString());
                StringBuilder sb5 = new StringBuilder();
                sb5.append("updateSceneClipSourceRegion3 previewSize:");
                sb5.append(veMSize2);
                C8554j.m25010v("XYSDKUtil", sb5.toString());
                VeMSize c = m25083c(f, veMSize2);
                if (c != null && c.width > 0 && c.height > 0) {
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append("updateSceneClipSourceRegion4 fitOutSize:");
                    sb6.append(c);
                    C8554j.m25010v("XYSDKUtil", sb6.toString());
                    int i2 = (veMSize2.width * 10000) / c.width;
                    int i3 = (veMSize2.height * 10000) / c.height;
                    QRect qRect2 = new QRect();
                    if (z) {
                        int elementSourceAlignment = qSceneClip2.getElementSourceAlignment(i);
                        if (elementSourceAlignment == 96) {
                            qRect2.left = (10000 - i2) / 2;
                            qRect2.right = qRect2.left + i2;
                            qRect2.top = (10000 - i3) / 2;
                            qRect2.bottom = qRect2.top + i3;
                        } else if ((elementSourceAlignment & 1) == 1) {
                            qRect2.left = 0;
                            qRect2.right = i2;
                            qRect2.top = (10000 - i3) / 2;
                            qRect2.bottom = qRect2.top + i3;
                        } else if ((elementSourceAlignment & 2) == 2) {
                            qRect2.left = 10000 - i2;
                            qRect2.right = 10000;
                            qRect2.top = (10000 - i3) / 2;
                            qRect2.bottom = qRect2.top + i3;
                        } else if ((elementSourceAlignment & 4) == 4) {
                            qRect2.left = 0;
                            qRect2.right = 10000;
                            qRect2.top = 0;
                            qRect2.bottom = i3;
                        } else if ((elementSourceAlignment & 8) == 8) {
                            qRect2.left = 0;
                            qRect2.right = 10000;
                            qRect2.top = 10000 - i3;
                            qRect2.bottom = 10000;
                        }
                    } else {
                        qRect2.left = (10000 - i2) / 2;
                        qRect2.right = qRect2.left + i2;
                        qRect2.top = (10000 - i3) / 2;
                        qRect2.bottom = qRect2.top + i3;
                    }
                    StringBuilder sb7 = new StringBuilder();
                    sb7.append("updateSceneClipSourceRegion5 destRegion.left:");
                    sb7.append(qRect2.left);
                    sb7.append(";destRegion.top=");
                    sb7.append(qRect2.top);
                    sb7.append(";destRegion.right=");
                    sb7.append(qRect2.right);
                    sb7.append(";destRegion.bottom=");
                    sb7.append(qRect2.bottom);
                    C8554j.m25010v("XYSDKUtil", sb7.toString());
                    dataClip.setProperty(12314, qRect2);
                }
            }
        }
        return true;
    }

    /* renamed from: a */
    public static boolean m25074a(QStoryboard qStoryboard, Rect rect) {
        boolean z = false;
        if (qStoryboard != null) {
            QClip dataClip = qStoryboard.getDataClip();
            if (dataClip != null) {
                QRect qRect = new QRect();
                qRect.left = rect.left;
                qRect.right = rect.right;
                qRect.top = rect.top;
                qRect.bottom = rect.bottom;
                if (dataClip.setProperty(12314, qRect) == 0) {
                    z = true;
                }
                return z;
            }
        }
        return false;
    }

    public static int aJl() {
        return (!C8410e.aGX().aGZ().getBoolean("pref_encode", false) || VERSION.SDK_INT < 16) ? 2 : 4;
    }

    public static int aJm() {
        return (!C8410e.aGX().aGZ().getBoolean("pref_encode", false) || VERSION.SDK_INT < 18) ? 512 : 1024;
    }

    public static int aJn() {
        return 512;
    }

    public static int aJo() {
        return 2;
    }

    public static VeMSize aJp() {
        VeMSize veMSize = new VeMSize();
        int i = C8401d.MAX_EXPORT_RESOLUTION_WIDTH;
        int i2 = C8401d.MAX_EXPORT_RESOLUTION_HEIGHT;
        boolean z = true;
        boolean z2 = i == ehj.width && i2 == ehj.height;
        boolean z3 = i == egH.width && i2 == egH.height;
        if (!(i == 1280 && i2 == 720)) {
            z = false;
        }
        if (z2) {
            veMSize.width = 240;
            veMSize.height = 240;
        } else if (z3) {
            veMSize.width = 480;
            veMSize.height = 480;
        } else if (z) {
            veMSize.width = QUtils.VIDEO_RES_720P_HEIGHT;
            veMSize.height = QUtils.VIDEO_RES_720P_HEIGHT;
        } else {
            veMSize.width = QUtils.VIDEO_RES_720P_HEIGHT;
            veMSize.height = QUtils.VIDEO_RES_720P_HEIGHT;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("getDeviceFitVideoResolution4Vertical previewSize =");
        sb.append(veMSize);
        C8554j.m25008i("XYSDKUtil", sb.toString());
        return veMSize;
    }

    public static VeMSize aJq() {
        VeMSize veMSize = new VeMSize();
        int i = C8401d.MAX_EXPORT_RESOLUTION_WIDTH;
        int i2 = C8401d.MAX_EXPORT_RESOLUTION_HEIGHT;
        boolean z = true;
        boolean z2 = i == ehj.width && i2 == ehj.height;
        boolean z3 = i == egH.width && i2 == egH.height;
        if (!(i == 1280 && i2 == 720)) {
            z = false;
        }
        if (z2) {
            veMSize.width = 320;
            veMSize.height = 240;
        } else if (z3) {
            veMSize.width = QUtils.VIDEO_RES_VGA_WIDTH;
            veMSize.height = 480;
        } else if (z) {
            veMSize.width = QUtils.VIDEO_RES_720P_WIDTH;
            veMSize.height = QUtils.VIDEO_RES_720P_HEIGHT;
        } else {
            veMSize.width = QUtils.VIDEO_RES_720P_WIDTH;
            veMSize.height = QUtils.VIDEO_RES_720P_HEIGHT;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("calcMVStreamSize =");
        sb.append(veMSize);
        C8554j.m25008i("XYSDKUtil", sb.toString());
        return veMSize;
    }

    /* renamed from: aY */
    public static void m25075aY(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            C8410e.aGX().aGZ().setString(m25100ox(str), str2);
        }
    }

    /* renamed from: b */
    public static int m25076b(QClip qClip, QBitmap qBitmap, int i, boolean z) {
        if (qClip == null || qBitmap == null || qBitmap.isRecycled()) {
            return 2;
        }
        return qClip.getKeyframe(qBitmap, i, z, 2);
    }

    /* renamed from: b */
    private static Rect m25077b(Rect rect, Rect rect2) {
        if (rect == null || rect.width() <= 0 || rect.height() <= 0) {
            return rect;
        }
        Rect rect3 = new Rect(0, 0, rect2.width(), rect2.height());
        if (rect.width() * rect2.height() > rect2.width() * rect.height()) {
            rect3.right = (rect.width() * rect2.height()) / rect.height();
        } else {
            rect3.bottom = (rect.height() * rect2.width()) / rect.width();
        }
        int width = rect2.width() - rect3.width();
        int height = rect2.height() - rect3.height();
        int i = width / 2;
        rect3.left += i;
        rect3.right += i;
        int i2 = height / 2;
        rect3.top += i2;
        rect3.bottom += i2;
        if (rect3.width() < 2) {
            rect3.right = 2;
        }
        if (rect3.height() < 2) {
            rect3.bottom = 2;
        }
        if (rect3.width() % 2 != 0) {
            rect3.right++;
        }
        if (rect3.height() % 2 != 0) {
            rect3.bottom++;
        }
        return rect3;
    }

    /* renamed from: b */
    public static VeMSize m25078b(VeMSize veMSize, VeMSize veMSize2) {
        VeMSize c = m25083c(veMSize, veMSize2);
        return c == null ? veMSize2 : c;
    }

    /* renamed from: b */
    private static VeMSize m25079b(VeMSize veMSize, VeMSize veMSize2, boolean z) {
        VeMSize veMSize3 = new VeMSize((int) QUtils.VIDEO_RES_VGA_WIDTH, 480);
        if (veMSize == null || veMSize.width <= 0 || veMSize.height <= 0) {
            C8554j.m25007e("XYSDKUtil", "calculateSurfaceSize: input previewSize error");
            return veMSize3;
        } else if (veMSize2 == null || veMSize2.width <= 0 || veMSize2.height <= 0) {
            C8554j.m25007e("XYSDKUtil", "calculateSurfaceSize: input screenSize error");
            return veMSize3;
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("calculateSurfaceSize: input previewSize = ");
            sb.append(veMSize);
            sb.append(" input screenSize=");
            sb.append(veMSize2);
            C8554j.m25007e("XYSDKUtil", sb.toString());
            VeMSize veMSize4 = z ? new VeMSize(veMSize.width, veMSize.height) : veMSize.width * veMSize.height > 691200 ? new VeMSize((int) QUtils.VIDEO_RES_720P_HEIGHT, 960) : new VeMSize(veMSize.height, veMSize.width);
            VeMSize a = C8569v.m25057a(veMSize4, veMSize2);
            m25094g(a);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("calculateSurfaceSize: output surface size = ");
            sb2.append(a);
            C8554j.m25007e("XYSDKUtil", sb2.toString());
            return a;
        }
    }

    /* renamed from: b */
    public static QStoryboard m25080b(QEngine qEngine, String str) {
        return m25071a(qEngine, str, null, false, false, null, false);
    }

    /* renamed from: b */
    public static boolean m25081b(QSceneClip qSceneClip, VeMSize veMSize) {
        return m25073a(qSceneClip, veMSize, false);
    }

    /* renamed from: c */
    public static int m25082c(QEngine qEngine, String str) {
        QVideoInfo qVideoInfo = new QVideoInfo();
        if (QUtils.getVideoInfoAndSrcExtInfo(qEngine, str, qVideoInfo, new QSourceExtInfo()) == 0) {
            return qVideoInfo.get(1);
        }
        return 2;
    }

    /* renamed from: c */
    public static VeMSize m25083c(VeMSize veMSize, VeMSize veMSize2) {
        int i;
        int i2;
        if (veMSize == null || veMSize2 == null || veMSize.width <= 0 || veMSize.height <= 0 || veMSize2.width <= 0 || veMSize2.height <= 0) {
            return null;
        }
        float f = ((float) veMSize.width) / ((float) veMSize2.width);
        float f2 = ((float) veMSize.height) / ((float) veMSize2.height);
        if (f > f2) {
            i = veMSize2.height;
            i2 = (int) (((float) veMSize.width) / f2);
        } else {
            int i3 = veMSize2.width;
            i = (int) (((float) veMSize.height) / f);
            i2 = i3;
        }
        return new VeMSize(m25087dI(i2, 4), m25087dI(i, 4));
    }

    /* renamed from: d */
    public static int m25084d(String str, QEngine qEngine) {
        int GetFileMediaType = C8556l.GetFileMediaType(str);
        if (C8556l.IsImageFileType(GetFileMediaType)) {
            if (QUtils.isFileEditable(qEngine, str, 0) != 0) {
                return 4;
            }
            Options options = new Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            if (options.mCancel || options.outWidth == -1 || options.outHeight == -1) {
                return 2;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("; orig resol = ");
            sb.append(options.outWidth);
            sb.append("x");
            sb.append(options.outHeight);
            C8554j.m25008i("XYSDKUtil", sb.toString());
            return (301 == GetFileMediaType || GetFileMediaType == 303) ? 0 : 4;
        } else if (!C8556l.IsVideoFileType(GetFileMediaType)) {
            return 2;
        } else {
            int c = C8450a.m24470c(str, qEngine);
            if (12 == c || 10 == c || 11 == c || 9 == c) {
                return 4;
            }
            if (13 == c) {
                return 2;
            }
        }
    }

    /* renamed from: d */
    public static int m25085d(QEngine qEngine, String str) {
        QVideoInfo videoInfo = QUtils.getVideoInfo(qEngine, str);
        if (videoInfo != null) {
            return videoInfo.get(5);
        }
        return 0;
    }

    /* renamed from: d */
    public static VeMSize m25086d(VeMSize veMSize, VeMSize veMSize2) {
        if (veMSize == null) {
            return null;
        }
        boolean z = veMSize.width > veMSize.height;
        VeMSize a = C8569v.m25057a(new VeMSize(z ? veMSize.width : veMSize.height, z ? veMSize.height : veMSize.width), veMSize2);
        m25094g(a);
        VeMSize g = m25094g(a);
        if (!z) {
            int i = g.width;
            g.width = g.height;
            g.height = i;
        }
        return g;
    }

    /* renamed from: dI */
    public static int m25087dI(int i, int i2) {
        return i2 > 0 ? ((i + (i2 / 2)) / i2) * i2 : i;
    }

    /* renamed from: dJ */
    public static VeMSize m25088dJ(int i, int i2) {
        int i3 = 1;
        while (true) {
            int i4 = i / i3;
            int i5 = i2 / i3;
            if (i4 * i5 <= 409600) {
                return new VeMSize((i4 >> 2) << 2, (i5 >> 2) << 2);
            }
            i3++;
        }
    }

    /* renamed from: dK */
    public static QRect m25089dK(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            return null;
        }
        QRect qRect = new QRect();
        if (i > i2) {
            int i3 = i * 2;
            qRect.left = ((i - i2) * 10000) / i3;
            qRect.right = ((i + i2) * 10000) / i3;
            qRect.top = 0;
            qRect.bottom = 10000;
        } else {
            qRect.left = 0;
            qRect.right = 10000;
            int i4 = i2 * 2;
            qRect.top = ((i2 - i) * 10000) / i4;
            qRect.bottom = ((i + i2) * 10000) / i4;
        }
        return qRect;
    }

    /* renamed from: e */
    public static VeMSize m25090e(VeMSize veMSize, VeMSize veMSize2) {
        VeMSize veMSize3 = new VeMSize();
        VeMSize b = m25079b(veMSize, veMSize2, true);
        return b != null ? new VeMSize(b.width, b.height) : veMSize3;
    }

    /* renamed from: e */
    public static boolean m25091e(String str, QEngine qEngine) {
        if (!C8556l.IsVideoFileType(C8556l.GetFileMediaType(str)) || m25084d(str, qEngine) != 0) {
            return false;
        }
        QClip f = C8537n.m24824f(str, qEngine);
        if (f == null) {
            return false;
        }
        f.unInit();
        return true;
    }

    /* renamed from: e */
    public static boolean m25092e(QEngine qEngine) {
        boolean z = false;
        if (qEngine == null) {
            return false;
        }
        if (QUtils.GetHWVDecoderCount(qEngine) > 0) {
            z = true;
        }
        return z;
    }

    /* renamed from: f */
    public static VeMSize m25093f(QClip qClip) {
        if (qClip != null) {
            QVideoInfo qVideoInfo = (QVideoInfo) qClip.getProperty(12291);
            if (qVideoInfo != null) {
                return new VeMSize(qVideoInfo.get(3), qVideoInfo.get(4));
            }
        }
        return null;
    }

    /* renamed from: g */
    public static VeMSize m25094g(VeMSize veMSize) {
        if (veMSize != null) {
            veMSize.width = m25087dI(veMSize.width, 16);
            veMSize.height = m25087dI(veMSize.height, 16);
        }
        return veMSize;
    }

    /* renamed from: h */
    private static void m25095h(VeMSize veMSize) {
        veMSize.width ^= veMSize.height;
        veMSize.height ^= veMSize.width;
        veMSize.width ^= veMSize.height;
    }

    /* renamed from: js */
    public static VeMSize m25096js(boolean z) {
        VeMSize veMSize = new VeMSize();
        int i = C8401d.MAX_EXPORT_RESOLUTION_WIDTH;
        int i2 = C8401d.MAX_EXPORT_RESOLUTION_HEIGHT;
        boolean z2 = true;
        boolean z3 = i == ehj.width && i2 == ehj.height;
        boolean z4 = i == egH.width && i2 == egH.height;
        if (!(i == 1280 && i2 == 720)) {
            z2 = false;
        }
        if (z3) {
            if (!z) {
                veMSize.width = TodoConstants.TODO_TYPE_EDITOR_BASIC_FILTER;
                veMSize.height = 240;
            } else {
                veMSize.width = 320;
                veMSize.height = 240;
            }
        } else if (z4) {
            if (!z) {
                veMSize.width = QUtils.VIDEO_RES_FWVGA_WIDTH;
                veMSize.height = 480;
            } else {
                veMSize.width = QUtils.VIDEO_RES_VGA_WIDTH;
                veMSize.height = 480;
            }
        } else if (z2) {
            veMSize.width = QUtils.VIDEO_RES_720P_WIDTH;
            veMSize.height = QUtils.VIDEO_RES_720P_HEIGHT;
        } else {
            veMSize.width = QUtils.VIDEO_RES_720P_WIDTH;
            veMSize.height = QUtils.VIDEO_RES_720P_HEIGHT;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("calcMVStreamSize =");
        sb.append(veMSize);
        C8554j.m25008i("XYSDKUtil", sb.toString());
        return veMSize;
    }

    /* renamed from: ou */
    public static String m25097ou(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(C8401d.getMediaSavePath());
        sb.append(C8548e.getFileName(str));
        sb.append(File.separator);
        return sb.toString();
    }

    /* renamed from: ov */
    public static String m25098ov(String str) {
        String ow = m25099ow(str);
        if (str != null && str.length() > 0) {
            C8548e.createMultilevelDirectory(str);
        }
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTime(new Date());
        String format = String.format(Locale.US, "_%04d%02d%02d_%02d%02d%02d", new Object[]{Integer.valueOf(gregorianCalendar.get(1)), Integer.valueOf(gregorianCalendar.get(2) + 1), Integer.valueOf(gregorianCalendar.get(5)), Integer.valueOf(gregorianCalendar.get(11)), Integer.valueOf(gregorianCalendar.get(12)), Integer.valueOf(gregorianCalendar.get(13))});
        StringBuilder sb = new StringBuilder();
        sb.append(ow);
        sb.append("record");
        sb.append(format);
        sb.append(".mp4");
        return sb.toString();
    }

    /* renamed from: ow */
    public static String m25099ow(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(C8401d.getAudioSavePath());
        sb.append(C8548e.getFileName(str));
        sb.append(File.separator);
        return sb.toString();
    }

    /* renamed from: ox */
    private static String m25100ox(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("key_cover_title");
        sb.append(str);
        return sb.toString();
    }

    /* renamed from: oy */
    public static String m25101oy(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return C8410e.aGX().aGZ().getString(m25100ox(str), "");
    }

    /* renamed from: s */
    public static boolean m25102s(float f, float f2, float f3) {
        return Math.abs(f - f2) < f3;
    }

    /* renamed from: uw */
    public static VeMSize m25103uw(int i) {
        VeMSize veMSize = new VeMSize();
        int i2 = C8401d.MAX_EXPORT_RESOLUTION_WIDTH;
        int i3 = C8401d.MAX_EXPORT_RESOLUTION_HEIGHT;
        boolean z = true;
        boolean z2 = i2 == ehj.width && i3 == ehj.height;
        boolean z3 = i2 == egH.width && i3 == egH.height;
        if (!(i2 == 1280 && i3 == 720)) {
            z = false;
        }
        if (z2) {
            veMSize.width = 320;
            veMSize.height = QDisplayContext.DISPLAY_ROTATION_180;
        } else if (z3) {
            veMSize.width = QUtils.VIDEO_RES_VGA_WIDTH;
            veMSize.height = 360;
        } else if (z) {
            veMSize.width = QUtils.VIDEO_RES_720P_WIDTH;
            veMSize.height = QUtils.VIDEO_RES_720P_HEIGHT;
        } else {
            veMSize.width = QUtils.VIDEO_RES_720P_WIDTH;
            veMSize.height = QUtils.VIDEO_RES_720P_HEIGHT;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("calcMVStreamSize =");
        sb.append(veMSize);
        C8554j.m25008i("XYSDKUtil", sb.toString());
        return veMSize;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0035, code lost:
        if (r1 < r5.getDuration()) goto L_0x0039;
     */
    /* renamed from: x */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int m25104x(xiaoying.engine.storyboard.QStoryboard r5) {
        /*
            r0 = 0
            if (r5 != 0) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = com.introvd.template.sdk.utils.p394b.C8540q.m24976w(r5)
            int r2 = r5.getClipCount()
            r3 = -1
            r3 = 0
            r4 = -1
        L_0x000f:
            if (r3 >= r2) goto L_0x0021
            if (r1 == 0) goto L_0x0016
            int r4 = r3 + 1
            goto L_0x0017
        L_0x0016:
            r4 = r3
        L_0x0017:
            int r4 = com.introvd.template.sdk.utils.p394b.C8540q.m24971t(r5, r4)
            if (r4 < 0) goto L_0x001e
            goto L_0x0021
        L_0x001e:
            int r3 = r3 + 1
            goto L_0x000f
        L_0x0021:
            if (r1 == 0) goto L_0x0038
            xiaoying.engine.base.QRange r1 = r5.getTransitionTimeRange(r0)
            if (r1 == 0) goto L_0x0038
            r2 = 1
            int r1 = r1.get(r2)
            if (r1 <= 0) goto L_0x0038
            int r1 = r1 + r4
            int r5 = r5.getDuration()
            if (r1 >= r5) goto L_0x0038
            goto L_0x0039
        L_0x0038:
            r1 = r4
        L_0x0039:
            if (r1 >= 0) goto L_0x003c
            goto L_0x003d
        L_0x003c:
            r0 = r1
        L_0x003d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.sdk.utils.C8572y.m25104x(xiaoying.engine.storyboard.QStoryboard):int");
    }

    /* renamed from: y */
    public static int m25105y(QStoryboard qStoryboard) {
        return QUtils.calStoryboardFps(qStoryboard, 60);
    }
}
