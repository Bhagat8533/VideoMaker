package com.introvd.template.editor.p266h;

import android.text.TextUtils;
import com.giii.aiii.biii.common.util.ArrayUtils;
import com.introvd.template.editor.common.C5840b;
import com.introvd.template.editor.effects.customwatermark.C6091d;
import com.introvd.template.module.iap.C8049f;
import com.introvd.template.module.iap.C8059i;
import com.introvd.template.module.iap.C8072q;
import com.introvd.template.module.iap.business.p349a.C7825a;
import com.introvd.template.sdk.p391g.C8450a;
import com.introvd.template.sdk.utils.C8548e;
import com.introvd.template.sdk.utils.C8556l;
import com.introvd.template.sdk.utils.p394b.C8501a;
import com.introvd.template.sdk.utils.p394b.C8537n;
import com.introvd.template.sdk.utils.p394b.C8538o;
import com.introvd.template.sdk.utils.p394b.C8540q;
import com.introvd.template.template.p407e.C8745n;
import com.introvd.template.template.p409g.C8762d;
import java.util.ArrayList;
import java.util.List;
import xiaoying.engine.QEngine;
import xiaoying.engine.base.QStyle.QEffectPropertyData;
import xiaoying.engine.clip.QEffect;
import xiaoying.engine.storyboard.QStoryboard;

/* renamed from: com.introvd.template.editor.h.l */
public class C6406l {
    private static int[] dli = {C8059i.VIP_UNKNOWN.code, C8059i.VIP_ALL.code, C8059i.VIP_THEME.code, C8059i.VIP_FILTER.code, C8059i.VIP_STICKER.code, C8059i.VIP_MAGIC_SOUND.code, C8059i.VIP_BACKGROUND.code, C8059i.VIP_ANIM_SUBTITLE.code, C8059i.VIP_NORMAL_SUBTITLE.code, C8059i.VIP_MOSAIC.code, C8059i.VIP_MUSIC_EXTRACT.code, C8059i.VIP_DURATION_LIMIT.code, C8059i.VIP_KEY_FRAME.code, C8059i.VIP_VIDEO_PARAM.code, C8059i.VIP_CUSTOMIZE_WM.code};

    /* renamed from: a */
    private static boolean m18434a(QStoryboard qStoryboard, boolean z) {
        boolean z2 = false;
        if (qStoryboard == null) {
            return false;
        }
        int j = C8540q.m24958j(qStoryboard, 3);
        int i = 0;
        while (true) {
            if (i >= j) {
                break;
            }
            String e = C8538o.m24872e(C8540q.m24940b(qStoryboard, 3, i));
            if (C8450a.m24466bk(C8762d.aMt().getTemplateID(e)) == z) {
                String iN = m18444iN(e);
                if (!TextUtils.isEmpty(iN) && C8049f.aBf().mo33101iL(iN)) {
                    z2 = true;
                    break;
                }
            }
            i++;
        }
        return z2;
    }

    /* renamed from: b */
    public static boolean m18435b(QStoryboard qStoryboard, int i) {
        switch (C8059i.m23406sg(i)) {
            case VIP_THEME:
                return m18442h(qStoryboard);
            case VIP_FILTER:
                return m18440f(qStoryboard);
            case VIP_STICKER:
                return m18441g(qStoryboard);
            case VIP_MAGIC_SOUND:
                return m18443i(qStoryboard);
            case VIP_BACKGROUND:
                return m18445j(qStoryboard);
            case VIP_ANIM_SUBTITLE:
                return m18434a(qStoryboard, true);
            case VIP_NORMAL_SUBTITLE:
                return m18434a(qStoryboard, false);
            case VIP_MOSAIC:
                return m18446k(qStoryboard);
            case VIP_MUSIC_EXTRACT:
                return m18447l(qStoryboard);
            case VIP_DURATION_LIMIT:
                return m18448m(qStoryboard);
            case VIP_KEY_FRAME:
                return m18451p(qStoryboard);
            case VIP_VIDEO_PARAM:
                return m18449n(qStoryboard);
            case VIP_CUSTOMIZE_WM:
                return m18450o(qStoryboard);
            default:
                return false;
        }
    }

    /* renamed from: c */
    private static boolean m18436c(QStoryboard qStoryboard, int i) {
        int j = C8540q.m24958j(qStoryboard, i);
        for (int i2 = 0; i2 < j; i2++) {
            if (m18437d(C8540q.m24940b(qStoryboard, i, i2))) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: d */
    private static boolean m18437d(QEffect qEffect) {
        if (qEffect == null) {
            return false;
        }
        Object property = qEffect.getProperty(QEffect.PROP_EFFECT_KEYFRAME_TRANSFORM_SET);
        if ((property instanceof Boolean) && ((Boolean) property).booleanValue()) {
            return true;
        }
        Object property2 = qEffect.getProperty(QEffect.PROP_EFFECT_KEYFRAME_AUDIO_SET);
        if ((property2 instanceof Boolean) && ((Boolean) property2).booleanValue()) {
            return true;
        }
        Object property3 = qEffect.getProperty(QEffect.PROP_EFFECT_KEYFRAME_LEVEL_SET);
        if ((property3 instanceof Boolean) && ((Boolean) property3).booleanValue()) {
            return true;
        }
        Object property4 = qEffect.getProperty(QEffect.PROP_EFFECT_KEYFRAME_OPACITY_SET);
        return (property4 instanceof Boolean) && ((Boolean) property4).booleanValue();
    }

    /* renamed from: d */
    private static boolean m18438d(QEffectPropertyData[] qEffectPropertyDataArr) {
        return (qEffectPropertyDataArr[0].mValue == 50 && qEffectPropertyDataArr[1].mValue == 50 && qEffectPropertyDataArr[2].mValue == 50 && qEffectPropertyDataArr[3].mValue == 50 && qEffectPropertyDataArr[4].mValue == 50 && qEffectPropertyDataArr[5].mValue == 50 && qEffectPropertyDataArr[6].mValue == 50 && qEffectPropertyDataArr[7].mValue == 50 && qEffectPropertyDataArr[8].mValue == 50 && qEffectPropertyDataArr[9].mValue == 0) ? false : true;
    }

    /* renamed from: e */
    public static List<Integer> m18439e(QStoryboard qStoryboard) {
        int[] iArr;
        ArrayList arrayList = new ArrayList();
        for (int i : dli) {
            if (m18435b(qStoryboard, i)) {
                arrayList.add(Integer.valueOf(i));
            }
        }
        return arrayList;
    }

    /* renamed from: f */
    private static boolean m18440f(QStoryboard qStoryboard) {
        boolean z = false;
        if (qStoryboard == null) {
            return false;
        }
        int clipCount = qStoryboard.getClipCount();
        int i = 0;
        while (true) {
            if (i >= clipCount) {
                break;
            }
            String iN = m18444iN(C8540q.m24972t(qStoryboard.getClip(i)));
            if (!TextUtils.isEmpty(iN) && C8049f.aBf().mo33101iL(iN)) {
                z = true;
                break;
            }
            i++;
        }
        return z;
    }

    /* renamed from: g */
    private static boolean m18441g(QStoryboard qStoryboard) {
        boolean z = false;
        if (qStoryboard == null) {
            return false;
        }
        int j = C8540q.m24958j(qStoryboard, 8);
        int i = 0;
        while (true) {
            if (i >= j) {
                break;
            }
            String iN = m18444iN(C8538o.m24872e(C8540q.m24940b(qStoryboard, 8, i)));
            if (!TextUtils.isEmpty(iN) && C8049f.aBf().mo33101iL(iN)) {
                z = true;
                break;
            }
            i++;
        }
        return z;
    }

    /* renamed from: h */
    private static boolean m18442h(QStoryboard qStoryboard) {
        if (qStoryboard == null) {
            return false;
        }
        return C6386d.m18377iL(C8450a.m24469bn(C8762d.aMt().getTemplateID((String) qStoryboard.getProperty(16391))).toLowerCase());
    }

    /* renamed from: i */
    private static boolean m18443i(QStoryboard qStoryboard) {
        boolean z;
        boolean z2 = false;
        if (qStoryboard == null) {
            return false;
        }
        int clipCount = qStoryboard.getClipCount();
        int i = 0;
        while (true) {
            if (i >= clipCount) {
                z = false;
                break;
            }
            if (!ArrayUtils.contains((T[]) C5840b.cEC, Float.valueOf(C8537n.m24840s(qStoryboard.getClip(i))))) {
                z = true;
                break;
            }
            i++;
        }
        if (z && !C8072q.aBx().mo33072ku(C7825a.MAGIC_SOUND.getId())) {
            z2 = true;
        }
        return z2;
    }

    /* renamed from: iN */
    private static String m18444iN(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return C8745n.m25556bv(C8762d.aMt().getTemplateID(str));
    }

    /* renamed from: j */
    private static boolean m18445j(QStoryboard qStoryboard) {
        boolean z;
        boolean z2 = false;
        if (qStoryboard == null) {
            return false;
        }
        int clipCount = qStoryboard.getClipCount();
        int i = 0;
        while (true) {
            if (i >= clipCount) {
                z = false;
                break;
            } else if (C8548e.isFileExisted(C8538o.m24886p(C8537n.m24816b(qStoryboard.getClip(i), -10, 0)))) {
                z = true;
                break;
            } else {
                i++;
            }
        }
        if (z && !C8072q.aBx().mo33072ku(C7825a.CUSTOMIZED_BACKGROUND.getId())) {
            z2 = true;
        }
        return z2;
    }

    /* renamed from: k */
    private static boolean m18446k(QStoryboard qStoryboard) {
        boolean z = false;
        if (qStoryboard == null) {
            return false;
        }
        if (C8540q.m24958j(qStoryboard, 40) > 0 && !C8072q.aBx().mo33072ku(C7825a.MOSAIC.getId())) {
            z = true;
        }
        return z;
    }

    /* renamed from: l */
    private static boolean m18447l(QStoryboard qStoryboard) {
        boolean z = false;
        if (qStoryboard == null) {
            return false;
        }
        String G = C8540q.m24898G(qStoryboard);
        if (C8548e.isFileExisted(G)) {
            z = C8556l.IsVideoFileType(C8556l.GetFileMediaType(G));
        }
        return z;
    }

    /* renamed from: m */
    private static boolean m18448m(QStoryboard qStoryboard) {
        boolean z = false;
        if (qStoryboard == null) {
            return false;
        }
        if (qStoryboard.getDuration() >= 300000 && !C8072q.aBx().mo33072ku(C7825a.DURATION_LIMIT.getId())) {
            z = true;
        }
        return z;
    }

    /* renamed from: n */
    private static boolean m18449n(QStoryboard qStoryboard) {
        boolean z = false;
        if (qStoryboard == null) {
            return false;
        }
        int clipCount = qStoryboard.getClipCount();
        QEngine aJv = C8501a.aJs().aJv();
        if (aJv == null) {
            return false;
        }
        int i = 0;
        while (true) {
            if (i >= clipCount) {
                break;
            }
            QEffectPropertyData[] b = C8537n.m24817b(aJv, qStoryboard.getClip(i), 105, C6386d.dkB.longValue());
            if (b != null && b.length == 10 && m18438d(b)) {
                z = true;
                break;
            }
            i++;
        }
        return z;
    }

    /* renamed from: o */
    private static boolean m18450o(QStoryboard qStoryboard) {
        boolean ajY = C6091d.ajW().ajY();
        if (!ajY) {
            ajY = C8540q.m24958j(qStoryboard, 50) > 0;
        }
        return ajY && !C8072q.aBx().mo33072ku(C7825a.USER_WATER_MARK.getId());
    }

    /* renamed from: p */
    private static boolean m18451p(QStoryboard qStoryboard) {
        if (qStoryboard == null) {
            return false;
        }
        return m18436c(qStoryboard, 3) || m18436c(qStoryboard, 8) || m18436c(qStoryboard, 20) || m18436c(qStoryboard, 40);
    }
}
