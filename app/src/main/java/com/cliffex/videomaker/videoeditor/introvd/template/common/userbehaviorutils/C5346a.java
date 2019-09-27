package com.introvd.template.common.userbehaviorutils;

import android.util.Log;
import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: com.introvd.template.common.userbehaviorutils.a */
class C5346a {
    private AliONEUserbehaviorLog ciA;
    private CopyOnWriteArrayList<C5347a> ciz = new CopyOnWriteArrayList<>();

    /* renamed from: com.introvd.template.common.userbehaviorutils.a$a */
    class C5347a {
        String bFV;
        HashMap<String, String> ciB = new HashMap<>();

        C5347a() {
        }
    }

    C5346a(AliONEUserbehaviorLog aliONEUserbehaviorLog) {
        this.ciA = aliONEUserbehaviorLog;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: ZB */
    public void mo26916ZB() {
        if (this.ciA != null) {
            Iterator it = this.ciz.iterator();
            while (it.hasNext()) {
                C5347a aVar = (C5347a) it.next();
                this.ciA.onAliEvent(aVar.bFV, aVar.ciB);
                StringBuilder sb = new StringBuilder();
                sb.append("eventId=");
                sb.append(aVar.bFV);
                sb.append(",paramsMap=");
                sb.append(new Gson().toJson((Object) aVar.ciB));
                Log.d("AliUBDelayLog", sb.toString());
            }
            this.ciz.clear();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: h */
    public void mo26917h(String str, HashMap<String, String> hashMap) {
        C5347a aVar = new C5347a();
        aVar.bFV = str;
        aVar.ciB.putAll(hashMap);
        aVar.ciB.put("delay", "true");
        this.ciz.add(aVar);
    }
}
