package com.introvd.template.apicore;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.introvd.template.editor.p252e.C5878a;
import com.introvd.template.explorer.extract.C7234b;
import com.quvideo.xiaoying.jni.XYSignJni;
import java.util.List;
import java.util.Map;
import okhttp3.C9798ab;
import okhttp3.C9938q.C9939a;
import okhttp3.C9943t;

/* renamed from: com.introvd.template.apicore.k */
public class C3634k {
    private String bhj = null;
    private boolean bhx = true;
    private String bhy;
    private C9943t bhz;
    private String deviceId = null;
    private String userId = null;

    public C3634k(C9943t tVar, Object obj) {
        this.bhz = tVar;
        this.bhy = new Gson().toJson(obj);
    }

    public C3634k(C9943t tVar, String str) {
        this.bhz = tVar;
        this.bhy = str;
    }

    public C3634k(C9943t tVar, Map<String, Object> map) {
        this.bhz = tVar;
        this.bhy = new Gson().toJson((Object) map);
    }

    /* renamed from: b */
    private static String m8907b(String str, String str2, String str3, String str4, String str5) {
        return new XYSignJni().getReqSign(str, str2, str4, str3, str5);
    }

    /* renamed from: GW */
    public C9798ab mo22977GW() {
        C9939a aVar = new C9939a();
        if (this.bhz == null) {
            return aVar.aWa();
        }
        List aWp = this.bhz.aWp();
        aVar.mo38132bI(C5878a.TAG, (String) aWp.get(aWp.size() - 1));
        aVar.mo38132bI(C7234b.TAG, "1.0");
        aVar.mo38132bI("c", C3624b.m8865GC().mo22941EJ());
        C3630h GR = C3627e.m8892GQ().mo22966GR();
        try {
            if (!TextUtils.isEmpty(this.deviceId)) {
                aVar.mo38132bI("e", this.deviceId);
            } else if (GR != null && !TextUtils.isEmpty(GR.mo22972GV())) {
                aVar.mo38132bI("e", GR.mo22972GV());
            }
            if (!TextUtils.isEmpty(this.userId)) {
                aVar.mo38132bI("f", this.userId);
            } else if (GR != null && !TextUtils.isEmpty(GR.mo22971GU())) {
                aVar.mo38132bI("f", GR.mo22971GU());
            }
            if (!TextUtils.isEmpty(this.bhj)) {
                aVar.mo38132bI("h", this.bhj);
            } else if (GR != null && !TextUtils.isEmpty(GR.getUserToken())) {
                aVar.mo38132bI("h", GR.getUserToken());
            } else if (GR != null && !TextUtils.isEmpty(GR.getDeviceToken())) {
                aVar.mo38132bI("h", GR.getDeviceToken());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        aVar.mo38132bI("i", this.bhy);
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(System.currentTimeMillis() / 1000);
        String sb2 = sb.toString();
        if (this.bhx) {
            aVar.mo38132bI("j", m8907b(C3624b.m8865GC().mo22941EJ(), "POST", this.bhz.aWn(), this.bhy, sb2));
        }
        aVar.mo38132bI("k", "1.0");
        aVar.mo38132bI("l", sb2);
        aVar.mo38132bI("m", C3624b.m8865GC().mo22940EI());
        if (!TextUtils.isEmpty(C3624b.m8865GC().countryCode)) {
            aVar.mo38132bI("n", C3624b.m8865GC().countryCode);
        }
        return aVar.aWa();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: bq */
    public C3634k mo22978bq(boolean z) {
        this.bhx = z;
        return this;
    }

    /* renamed from: dc */
    public C3634k mo22979dc(String str) {
        this.deviceId = str;
        return this;
    }
}
