package com.introvd.template.sdk.p391g;

import android.text.TextUtils;
import com.introvd.template.sdk.model.VeRange;
import com.introvd.template.sdk.p383c.C8397a;
import com.introvd.template.sdk.utils.C8548e;
import com.introvd.template.sdk.utils.C8554j;
import com.introvd.template.sdk.utils.VeMSize;
import java.util.Locale;
import xiaoying.engine.QEngine;
import xiaoying.engine.base.QBubbleTemplateInfo;
import xiaoying.engine.base.QI18NItemInfo;
import xiaoying.engine.base.QStyle;
import xiaoying.engine.base.QStyle.QAnimatedFrameTemplateInfo;
import xiaoying.engine.base.QStyle.QEffectPropertyInfo;
import xiaoying.engine.base.QStyle.QExternalFileInfo;
import xiaoying.engine.base.QStyle.QTemplateIDUtils;
import xiaoying.engine.base.QUtils;
import xiaoying.engine.base.QVideoInfo;
import xiaoying.engine.cover.QTitleInfo;
import xiaoying.utils.QSize;
import xiaoying.utils.QStreamAssets;

/* renamed from: com.introvd.template.sdk.g.a */
public class C8450a {
    private static final Long egA = Long.valueOf(2199023255552L);

    /* renamed from: a */
    public static VeRange m24459a(QTitleInfo qTitleInfo) {
        VeRange veRange = new VeRange();
        if (qTitleInfo != null) {
            veRange.setmPosition(qTitleInfo.textstart);
            veRange.setmTimeLength(qTitleInfo.textend - qTitleInfo.textstart);
        }
        return veRange;
    }

    /* renamed from: a */
    public static QBubbleTemplateInfo m24460a(QEngine qEngine, String str, int i, int i2, int i3) {
        if (str == null) {
            return null;
        }
        QStyle qStyle = new QStyle();
        if (qStyle.create(str, null, QUtils.getLayoutMode(i2, i3)) == 0) {
            QBubbleTemplateInfo bubbleTemplateInfo = qStyle.getBubbleTemplateInfo(qEngine, i, i2, i3);
            qStyle.destroy();
            return bubbleTemplateInfo;
        }
        qStyle.destroy();
        return null;
    }

    /* renamed from: a */
    public static QAnimatedFrameTemplateInfo m24461a(String str, VeMSize veMSize) {
        if (!TextUtils.isEmpty(str) && veMSize != null) {
            QStyle qStyle = new QStyle();
            if (qStyle.create(str, null, QUtils.getLayoutMode(veMSize.width, veMSize.height)) == 0) {
                QAnimatedFrameTemplateInfo animatedFrameTemplateInfo = qStyle.getAnimatedFrameTemplateInfo(veMSize.width, veMSize.height);
                qStyle.destroy();
                return animatedFrameTemplateInfo;
            }
        }
        return null;
    }

    /* renamed from: a */
    public static boolean m24462a(QEngine qEngine, long j, String str) {
        QEffectPropertyInfo[] a = m24464a(qEngine, j);
        if (a != null) {
            for (QEffectPropertyInfo qEffectPropertyInfo : a) {
                if (TextUtils.equals(qEffectPropertyInfo.name, str)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m24463a(QEngine qEngine, String str) {
        boolean z = false;
        if (TextUtils.isEmpty(str) || qEngine == null) {
            return false;
        }
        QVideoInfo videoInfo = QUtils.getVideoInfo(qEngine, str);
        if (videoInfo == null) {
            return false;
        }
        int i = videoInfo.get(2);
        if (6 == i || 4 == i) {
            z = true;
        }
        return z;
    }

    /* renamed from: a */
    private static QEffectPropertyInfo[] m24464a(QEngine qEngine, long j) {
        if (qEngine != null && j > 0) {
            return QStyle.getIEPropertyInfo(qEngine, j);
        }
        return null;
    }

    /* renamed from: b */
    public static int m24465b(String str, QEngine qEngine) {
        if (TextUtils.isEmpty(str) || qEngine == null) {
            return 7;
        }
        int isFileEditable = QUtils.isFileEditable(qEngine, str, 1);
        if (isFileEditable == 0) {
            return 1;
        }
        int i = 13;
        if (4 == isFileEditable) {
            i = 11;
        }
        return i;
    }

    /* renamed from: bk */
    public static boolean m24466bk(long j) {
        return getTemplateSubType(j) == 1;
    }

    /* renamed from: bl */
    public static boolean m24467bl(long j) {
        return (j & egA.longValue()) != 0;
    }

    /* renamed from: bm */
    public static boolean m24468bm(long j) {
        return QStyle.NONE_THEME_TEMPLATE_ID == j;
    }

    /* renamed from: bn */
    public static String m24469bn(long j) {
        try {
            String upperCase = Long.toHexString(j).toUpperCase(Locale.US);
            int length = upperCase.length();
            for (int i = 0; i < 16 - length; i++) {
                StringBuilder sb = new StringBuilder();
                sb.append("0");
                sb.append(upperCase);
                upperCase = sb.toString();
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("0x");
            sb2.append(upperCase);
            return sb2.toString();
        } catch (Exception unused) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("");
            sb3.append(j);
            return sb3.toString();
        }
    }

    /* renamed from: c */
    public static int m24470c(String str, QEngine qEngine) {
        if (TextUtils.isEmpty(str)) {
            return 7;
        }
        QVideoInfo videoInfo = QUtils.getVideoInfo(qEngine, str);
        int i = 13;
        if (videoInfo == null) {
            return 13;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("InsertFile: file = ");
        sb.append(str);
        sb.append(" orig resol = ");
        sb.append(videoInfo.get(3));
        sb.append("x");
        sb.append(videoInfo.get(4));
        C8554j.m25008i("TemplateUtils", sb.toString());
        int isFileEditable = QUtils.isFileEditable(qEngine, str, 65539);
        if (isFileEditable == 0) {
            return 1;
        }
        if (isFileEditable != 6) {
            switch (isFileEditable) {
                case 2:
                    i = 12;
                    break;
                case 3:
                    i = 10;
                    break;
                case 4:
                    i = 11;
                    break;
            }
        } else {
            i = 9;
        }
        return i;
    }

    /* renamed from: c */
    public static int m24471c(Locale locale) {
        if (locale == null) {
            return QI18NItemInfo.LANGUAGE_ID_EN_US;
        }
        String language = locale.getLanguage();
        if (TextUtils.equals(language, "zh")) {
            return 4;
        }
        if (!TextUtils.equals(language, "en") && TextUtils.equals(language, "ar")) {
            return 1025;
        }
        return QI18NItemInfo.LANGUAGE_ID_EN_US;
    }

    public static int getTemplateSubType(long j) {
        return QTemplateIDUtils.getTemplateSubType(j);
    }

    public static int getTemplateType(long j) {
        int templateType = QTemplateIDUtils.getTemplateType(j);
        if (templateType == 15) {
            return 5;
        }
        switch (templateType) {
            case 4:
                return 1;
            default:
                return 4;
        }
    }

    /* renamed from: nV */
    public static boolean m24472nV(String str) {
        boolean z = false;
        if (!TextUtils.isEmpty(str)) {
            QStyle qStyle = new QStyle();
            if (qStyle.create(str, null, 1) == 0) {
                QExternalFileInfo[] externalFileInfos = qStyle.getExternalFileInfos();
                if (externalFileInfos != null && externalFileInfos.length > 0) {
                    int length = externalFileInfos.length;
                    int i = 0;
                    while (true) {
                        if (i >= length) {
                            break;
                        } else if (externalFileInfos[i].fileID == 1000) {
                            z = true;
                            break;
                        } else {
                            i++;
                        }
                    }
                }
            }
            qStyle.destroy();
        }
        return z;
    }

    /* renamed from: nW */
    public static int m24473nW(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        QStyle qStyle = new QStyle();
        if (qStyle.create(str, null, 1) != 0) {
            qStyle.destroy();
            return 0;
        }
        int themeCoverPosition = qStyle.getThemeCoverPosition();
        qStyle.destroy();
        return themeCoverPosition;
    }

    /* renamed from: nX */
    public static QSize m24474nX(String str) {
        QStyle qStyle = new QStyle();
        if (qStyle.create(str, null, 1) != 0) {
            qStyle.destroy();
            return null;
        }
        QSize qSize = new QSize();
        if (qStyle.getThemeExportSize(qSize) != 0) {
            qStyle.destroy();
            return null;
        }
        qStyle.destroy();
        return qSize;
    }

    /* renamed from: nY */
    public static boolean m24475nY(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith(QStreamAssets.ASSETS_THEME) ? C8397a.ecS.contains(str) : C8548e.isFileExisted(str);
    }

    /* renamed from: nZ */
    public static long[] m24476nZ(String str) {
        QStyle qStyle = new QStyle();
        qStyle.create(str, null, 0);
        long[] subPasterID = qStyle.getSubPasterID();
        qStyle.destroy();
        return subPasterID;
    }
}
