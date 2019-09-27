package com.introvd.template.editor.effects.bubble.subtitle;

import android.content.Context;
import android.graphics.RectF;
import android.text.TextUtils;
import com.introvd.template.common.UserBehaviorLog;
import com.introvd.template.editor.effects.C5896a;
import com.introvd.template.sdk.editor.cache.C8441b;
import com.introvd.template.sdk.model.editor.ScaleRotateViewState;
import com.introvd.template.sdk.model.editor.TextBubbleInfo.TextBubble;
import com.introvd.template.sdk.p391g.C8450a;
import com.introvd.template.template.p409g.C8762d;
import com.ironsource.sdk.constants.Constants.ParametersKeys;
import java.util.HashMap;

/* renamed from: com.introvd.template.editor.effects.bubble.subtitle.g */
public class C6031g {
    /* renamed from: A */
    public static void m17097A(Context context, boolean z) {
        if (context != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("which", z ? TtmlNode.LEFT : TtmlNode.RIGHT);
            UserBehaviorLog.onKVEvent(context, "VE_Title_Adjust", hashMap);
        }
    }

    /* renamed from: B */
    public static void m17098B(Context context, boolean z) {
        if (context != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("status", z ? "in_preview" : ParametersKeys.VIDEO_STATUS_STOPPED);
            UserBehaviorLog.onKVEvent(context, "VE_Title_Tool_Change", hashMap);
        }
    }

    /* renamed from: a */
    static void m17099a(Context context, C5896a aVar, int i) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        Context context2 = context;
        C5896a aVar2 = aVar;
        if (aVar.aiB() >= 2 && aVar.aiB() > i) {
            C8441b mg = aVar2.mo28483mg(aVar.aiA() - 1);
            C8441b mg2 = aVar2.mo28483mg(aVar.aiA());
            if (mg != null && mg2 != null) {
                ScaleRotateViewState aIg = mg.aIg();
                ScaleRotateViewState aIg2 = mg2.aIg();
                if (aIg != null && aIg2 != null) {
                    long templateID = C8762d.aMt().getTemplateID(aIg.mStylePath);
                    long templateID2 = C8762d.aMt().getTemplateID(aIg2.mStylePath);
                    boolean bk = C8450a.m24466bk(templateID);
                    boolean bk2 = C8450a.m24466bk(templateID2);
                    if (bk && bk2) {
                        boolean a = m17102a(aIg.mViewRect, aIg2.mViewRect);
                        boolean b = m17104b(aIg.mViewRect, aIg2.mViewRect);
                        boolean z7 = aIg.mDegree != aIg2.mDegree;
                        TextBubble textBubble = aIg.getTextBubble();
                        TextBubble textBubble2 = aIg2.getTextBubble();
                        if (textBubble == null || textBubble2 == null) {
                            z6 = false;
                            z5 = false;
                            z4 = false;
                            z3 = false;
                            z2 = false;
                            z = false;
                        } else {
                            z4 = textBubble.mTextColor != textBubble2.mTextColor;
                            z3 = (textBubble.mFontPath == null || textBubble2.mFontPath == null || textBubble.mFontPath.equals(textBubble2.mFontPath)) ? false : true;
                            z2 = (textBubble.mStrokeInfo == null || textBubble2.mStrokeInfo == null || textBubble.mStrokeInfo.strokeColor == textBubble2.mStrokeInfo.strokeColor) ? false : true;
                            z = (textBubble.mStrokeInfo == null || textBubble2.mStrokeInfo == null || textBubble.mStrokeInfo.strokeWPersent == textBubble2.mStrokeInfo.strokeWPersent) ? false : true;
                            z5 = (textBubble.mShadowInfo == null || textBubble2.mShadowInfo == null || textBubble.mShadowInfo.isbEnableShadow() == textBubble2.mShadowInfo.isbEnableShadow()) ? false : true;
                            z6 = textBubble.mTextAlignment != textBubble2.mTextAlignment;
                        }
                        m17103b(context2, a, b, z7, z4, z3, z2, z, z5, z6);
                    } else if (!bk && !bk2) {
                        boolean z8 = templateID != templateID2;
                        boolean a2 = m17102a(aIg.mViewRect, aIg2.mViewRect);
                        boolean b2 = m17104b(aIg.mViewRect, aIg2.mViewRect);
                        String textFontPath = aIg.getTextFontPath();
                        String textFontPath2 = aIg2.getTextFontPath();
                        m17101a(context2, z8, a2, b2, (textFontPath == null || textFontPath2 == null || textFontPath.equals(textFontPath2)) ? false : true, aIg.mDegree != aIg2.mDegree);
                    }
                    m17114d(context2, bk, bk2);
                }
            }
        }
    }

    /* renamed from: a */
    static void m17100a(Context context, String str, boolean z, String str2) {
        if (context != null && !TextUtils.isEmpty(str)) {
            HashMap hashMap = new HashMap();
            hashMap.put("name", str);
            hashMap.put("type", z ? "animated text" : "normal text");
            hashMap.put("ttid", str2);
            UserBehaviorLog.onKVEvent(context, "VE_Title_Add", hashMap);
        }
    }

    /* renamed from: a */
    static void m17101a(Context context, boolean... zArr) {
        if (context != null && zArr.length >= 5) {
            HashMap hashMap = new HashMap();
            hashMap.put("change_bubble", zArr[0] ? "yes" : "no");
            hashMap.put("position", zArr[1] ? "changed" : "not_changed");
            hashMap.put("scale", zArr[2] ? "changed" : "not_changed");
            hashMap.put("font", zArr[3] ? "changed" : "not_changed");
            hashMap.put("rotate", zArr[4] ? "changed" : "not_changed");
            UserBehaviorLog.onKVEvent(context, "VE_Title_Remember_Normal", hashMap);
        }
    }

    /* renamed from: a */
    private static boolean m17102a(RectF rectF, RectF rectF2) {
        boolean z = false;
        if (rectF == null || rectF2 == null) {
            return false;
        }
        if (Math.abs(rectF.left - rectF2.left) >= 5.0f || Math.abs(rectF.top - rectF2.top) >= 5.0f) {
            z = true;
        }
        return z;
    }

    /* renamed from: b */
    static void m17103b(Context context, boolean... zArr) {
        if (context != null && zArr.length >= 9) {
            HashMap hashMap = new HashMap();
            hashMap.put("position", zArr[0] ? "changed" : "not_changed");
            hashMap.put("scale", zArr[1] ? "changed" : "not_changed");
            hashMap.put("rotate", zArr[2] ? "changed" : "not_changed");
            hashMap.put("color", zArr[3] ? "changed" : "not_changed");
            hashMap.put("font", zArr[4] ? "changed" : "not_changed");
            hashMap.put("border", zArr[5] ? "changed" : "not_changed");
            hashMap.put("border_width", zArr[6] ? "changed" : "not_changed");
            hashMap.put("shadow", zArr[7] ? "changed" : "not_changed");
            hashMap.put("alignment", zArr[8] ? "changed" : "not_changed");
            UserBehaviorLog.onKVEvent(context, "VE_Title_Remember_animated", hashMap);
        }
    }

    /* renamed from: b */
    private static boolean m17104b(RectF rectF, RectF rectF2) {
        boolean z = false;
        if (rectF == null || rectF2 == null) {
            return false;
        }
        if (Math.abs(rectF.width() - rectF2.width()) >= 5.0f) {
            z = true;
        }
        return z;
    }

    /* renamed from: bb */
    static void m17105bb(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            HashMap hashMap = new HashMap();
            hashMap.put("name", str);
            UserBehaviorLog.onKVEvent(context, "VE_Title_Delete", hashMap);
        }
    }

    /* renamed from: bc */
    static void m17106bc(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            HashMap hashMap = new HashMap();
            hashMap.put("which", str);
            UserBehaviorLog.onKVEvent(context, "VE_Title_Finetune", hashMap);
        }
    }

    /* renamed from: bd */
    public static void m17107bd(Context context, String str) {
        if (context != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("way", str);
            UserBehaviorLog.onKVEvent(context, "VE_Title_Animate_Preview_Stop", hashMap);
        }
    }

    /* renamed from: be */
    static void m17108be(Context context, String str) {
        if (context != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("roll_id", str);
            UserBehaviorLog.onKVEvent(context, "VE_Title_Animate_Download_Success", hashMap);
        }
    }

    /* renamed from: bf */
    public static void m17109bf(Context context, String str) {
        if (context != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("click_Tab", str);
            UserBehaviorLog.onKVEvent(context, "VE_Title_Info_Tab_Change", hashMap);
        }
    }

    /* renamed from: bg */
    public static void m17110bg(Context context, String str) {
        if (context != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("tab", str);
            UserBehaviorLog.onKVEvent(context, "VE_Title_Tab_Change", hashMap);
        }
    }

    /* renamed from: bh */
    public static void m17111bh(Context context, String str) {
        if (context != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("direction", str);
            UserBehaviorLog.onKVEvent(context, "VE_Title_Positioning_Click", hashMap);
        }
    }

    /* renamed from: c */
    static void m17112c(Context context, boolean z, boolean z2) {
        if (context != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("status", z ? "in_preview" : ParametersKeys.VIDEO_STATUS_STOPPED);
            StringBuilder sb = new StringBuilder();
            sb.append("");
            sb.append(z2);
            hashMap.put("text_modify", sb.toString());
            UserBehaviorLog.onKVEvent(context, "VE_Title_Animate_Apply", hashMap);
        }
    }

    /* renamed from: d */
    static void m17113d(Context context, String str, String str2, boolean z) {
        if (context != null && !TextUtils.isEmpty(str)) {
            HashMap hashMap = new HashMap();
            hashMap.put("name", str);
            hashMap.put("ttid", str2);
            hashMap.put("status", z ? "in_preview" : ParametersKeys.VIDEO_STATUS_STOPPED);
            UserBehaviorLog.onKVEvent(context, "VE_Title_Animate_Show", hashMap);
        }
    }

    /* renamed from: d */
    static void m17114d(Context context, boolean z, boolean z2) {
        if (context != null) {
            HashMap hashMap = new HashMap();
            StringBuilder sb = new StringBuilder();
            sb.append(z ? "animation" : "normal");
            sb.append("_to_");
            sb.append(z2 ? "animation" : "normal");
            hashMap.put("how", sb.toString());
            UserBehaviorLog.onKVEvent(context, "VE_Title_Remember_change", hashMap);
        }
    }

    /* renamed from: e */
    public static void m17115e(Context context, String str, String str2, boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("name", str);
        hashMap.put("ttid", str2);
        UserBehaviorLog.onKVEvent(context, z ? "VE_Title_Animate_Show" : "VE_Title_Show", hashMap);
    }

    /* renamed from: eF */
    static void m17116eF(Context context) {
        if (context != null) {
            UserBehaviorLog.onKVEvent(context, "VE_Title_ChangeFont", new HashMap());
        }
    }

    /* renamed from: eG */
    static void m17117eG(Context context) {
        if (context != null) {
            UserBehaviorLog.onKVEvent(context, "VE_Title_Flip", new HashMap());
        }
    }

    /* renamed from: eH */
    public static void m17118eH(Context context) {
        if (context != null) {
            UserBehaviorLog.onKVEvent(context, "VE_Title_Anim_Preview", new HashMap());
        }
    }

    /* renamed from: t */
    static void m17119t(Context context, String str, String str2) {
        if (context != null && !TextUtils.isEmpty(str)) {
            HashMap hashMap = new HashMap();
            hashMap.put("name", str);
            hashMap.put("ttid", str2);
            UserBehaviorLog.onKVEvent(context, "VE_Title_Show", hashMap);
        }
    }

    /* renamed from: u */
    public static void m17120u(Context context, String str, String str2) {
        if (context != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("direction", str);
            hashMap.put("how", str2);
            UserBehaviorLog.onKVEvent(context, "VE_Title_Positioning_Refine", hashMap);
        }
    }
}
