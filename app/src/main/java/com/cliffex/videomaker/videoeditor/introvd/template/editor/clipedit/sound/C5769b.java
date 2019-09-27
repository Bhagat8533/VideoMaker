package com.introvd.template.editor.clipedit.sound;

import com.introvd.template.VivaBaseApplication;
import com.introvd.template.common.UserBehaviorLog;
import java.util.HashMap;

/* renamed from: com.introvd.template.editor.clipedit.sound.b */
class C5769b {
    static void afB() {
        UserBehaviorLog.onKVEvent(VivaBaseApplication.m8749FZ(), "VE_VoiceChanger_Customise_Enter_Click", new HashMap());
    }

    static void afC() {
        UserBehaviorLog.onKVEvent(VivaBaseApplication.m8749FZ(), "VE_VoiceChanger_Customise_Adjust", new HashMap());
    }

    /* renamed from: gL */
    static void m16036gL(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("name", str);
        UserBehaviorLog.onKVEvent(VivaBaseApplication.m8749FZ(), "VE_VoiceChanger_Apply", hashMap);
    }
}
