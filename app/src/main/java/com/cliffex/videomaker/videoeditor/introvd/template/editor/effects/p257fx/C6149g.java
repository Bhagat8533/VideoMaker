package com.introvd.template.editor.effects.p257fx;

import com.introvd.template.VivaBaseApplication;
import com.introvd.template.common.UserBehaviorLog;
import com.introvd.template.sdk.p391g.C8450a;
import java.util.HashMap;

/* renamed from: com.introvd.template.editor.effects.fx.g */
public class C6149g {
    /* renamed from: c */
    private static void m17562c(String str, String str2, long j) {
        if (j >= 0) {
            HashMap hashMap = new HashMap();
            hashMap.put("name", str2);
            hashMap.put("ttid", C8450a.m24469bn(j));
            UserBehaviorLog.onKVEvent(VivaBaseApplication.m8749FZ(), str, hashMap);
        }
    }

    /* renamed from: e */
    static void m17563e(long j, String str) {
        m17562c("VE_Action_Add", str, j);
    }

    /* renamed from: f */
    static void m17564f(long j, String str) {
        m17562c("VE_Action_Delete", str, j);
    }

    /* renamed from: fv */
    static void m17565fv(boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("which", z ? TtmlNode.LEFT : TtmlNode.RIGHT);
        UserBehaviorLog.onKVEvent(VivaBaseApplication.m8749FZ(), "VE_Action_Adjust", hashMap);
    }

    /* renamed from: fw */
    static void m17566fw(boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("which", z ? TtmlNode.LEFT : TtmlNode.RIGHT);
        UserBehaviorLog.onKVEvent(VivaBaseApplication.m8749FZ(), "VE_Action_Finetune", hashMap);
    }

    /* renamed from: g */
    static void m17567g(long j, String str) {
        m17562c("VE_Action_Show", str, j);
    }
}
