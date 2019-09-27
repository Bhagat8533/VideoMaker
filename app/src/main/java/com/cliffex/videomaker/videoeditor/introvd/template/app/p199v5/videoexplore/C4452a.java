package com.introvd.template.app.p199v5.videoexplore;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy;
import com.introvd.template.common.UserBehaviorLog;
import com.introvd.template.common.p236ui.custom.VideoAutoPlayHelper;
import com.introvd.template.datacenter.SocialServiceDef;
import com.introvd.template.p203b.C4599k;
import com.ironsource.environment.ConnectivityService;
import java.net.URI;
import java.util.HashMap;

/* renamed from: com.introvd.template.app.v5.videoexplore.a */
public class C4452a {
    private String bGi;
    private String bGj;
    private String bGk;
    private long bGl = 0;
    private int bGm = 0;
    private long bGn = 0;
    private long bGo = 0;
    private boolean bGp = false;

    /* renamed from: cU */
    private String f3405cU;
    private String mType;

    public C4452a(String str) {
        this.f3405cU = str;
    }

    /* renamed from: K */
    private String m11274K(long j) {
        return j > 300000 ? ">5min" : j > 240000 ? "4min-5min" : j > 180000 ? "3min-4min" : j > 120000 ? "2min-3min" : j >= DefaultLoadErrorHandlingPolicy.DEFAULT_TRACK_BLACKLIST_MS ? "1min-2min" : j > 30000 ? "31s-59s" : j > 20000 ? "21s-30s" : j >= 10000 ? "10s-20s" : "<10s";
    }

    /* renamed from: el */
    private String m11275el(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            str2 = URI.create(str).getHost();
        } catch (Exception e) {
            e.printStackTrace();
            str2 = null;
        }
        return str2;
    }

    /* renamed from: hT */
    private String m11276hT(int i) {
        return i > 5000 ? "5s以上" : i > 4000 ? "4s-5s" : i > 3000 ? "3s-4s" : i > 2000 ? "2s-3s" : i >= 1000 ? "1s-2s" : "<1s";
    }

    /* renamed from: J */
    public void mo24607J(long j) {
        this.bGl = System.currentTimeMillis() - this.bGo;
        this.bGn = j;
    }

    /* renamed from: QZ */
    public void mo24608QZ() {
        this.bGo = System.currentTimeMillis();
    }

    /* renamed from: Ra */
    public void mo24609Ra() {
        if (!this.bGp && this.bGn > 0) {
            this.bGm++;
        }
    }

    /* renamed from: Rb */
    public void mo24610Rb() {
    }

    /* renamed from: di */
    public void mo24611di(Context context) {
        this.bGi = VideoAutoPlayHelper.canAutoPlay(context) ? "auto" : "manual";
        int dM = C4599k.m11734dM(context);
        if (dM == 0) {
            this.mType = ConnectivityService.NETWORK_TYPE_WIFI;
        } else if (dM == 1) {
            this.mType = "2G";
        } else if (dM == 2) {
            this.mType = "3G";
        } else if (dM == 3) {
            this.mType = "4G";
        } else {
            this.mType = "unKnow";
        }
    }

    /* renamed from: dj */
    public void mo24612dj(Context context) {
        if (this.bGn > 0 && this.bGo != 0 && !TextUtils.isEmpty(this.bGj) && !TextUtils.isEmpty(this.bGk)) {
            HashMap hashMap = new HashMap();
            hashMap.put(SocialServiceDef.EXTRAS_UPGRADE_FROM, this.f3405cU);
            hashMap.put("duration", m11274K(this.bGn));
            hashMap.put("FirstBufferCost", m11276hT((int) this.bGl));
            StringBuilder sb = new StringBuilder();
            sb.append(this.bGm);
            sb.append("");
            hashMap.put("ReBufferCount", sb.toString());
            hashMap.put("VideoId", this.bGj);
            hashMap.put("DomainName", this.bGk);
            hashMap.put("mode", this.bGi);
            hashMap.put("type", this.mType);
            UserBehaviorLog.onKVEvent(context, "Tool_Video_Play_V5", hashMap);
        }
    }

    /* renamed from: i */
    public void mo24613i(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("_");
        sb.append(str2);
        this.bGj = sb.toString();
        this.bGk = m11275el(str3);
    }

    public void onVideoCompletion() {
        this.bGp = true;
    }
}
