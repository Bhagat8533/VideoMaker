package com.introvd.template.editor.effects.music;

import android.content.Context;
import com.introvd.template.common.UserBehaviorLog;
import java.util.HashMap;

/* renamed from: com.introvd.template.editor.effects.music.d */
class C6183d {
    /* renamed from: G */
    public static void m17710G(Context context, boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("which", z ? TtmlNode.TAG_HEAD : TtmlNode.END);
        UserBehaviorLog.onKVEvent(context, "VE_BGM_Finetune", hashMap);
    }

    /* renamed from: H */
    public static void m17711H(Context context, boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("which", z ? TtmlNode.TAG_HEAD : TtmlNode.END);
        UserBehaviorLog.onKVEvent(context, "VE_BGM_Adjust", hashMap);
    }

    /* renamed from: eV */
    public static void m17712eV(Context context) {
        UserBehaviorLog.onKVEvent(context, "VE_BGM_SetVolume", new HashMap());
    }

    /* renamed from: eW */
    public static void m17713eW(Context context) {
        UserBehaviorLog.onKVEvent(context, "VE_BGM_Used_Delete", new HashMap());
    }
}
