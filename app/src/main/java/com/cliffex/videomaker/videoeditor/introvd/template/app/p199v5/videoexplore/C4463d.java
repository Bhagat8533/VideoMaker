package com.introvd.template.app.p199v5.videoexplore;

import android.text.TextUtils;
import com.introvd.template.VivaBaseApplication;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.common.UserBehaviorLog;
import com.introvd.template.common.p236ui.custom.VideoAutoPlayHelper;
import com.introvd.template.datacenter.SocialServiceDef;
import com.introvd.template.p242d.C5527a;
import java.net.URI;
import java.util.HashMap;

/* renamed from: com.introvd.template.app.v5.videoexplore.d */
public class C4463d {
    private String bGj;
    private String bGk;
    private long bGl = 0;
    private int bGm = 0;
    private long bGn = 0;
    private long bGo = 0;
    private boolean bGp = false;
    private long bHH = 0;
    private int bHI;
    private String bHJ;
    private int bHK = 1;

    /* renamed from: el */
    private String m11305el(String str) {
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

    /* renamed from: J */
    public void mo24636J(long j) {
        this.bGl = System.currentTimeMillis() - this.bGo;
        StringBuilder sb = new StringBuilder();
        sb.append("video mFirstBufferCost : ");
        sb.append(this.bGl);
        LogUtilsV2.m14230i(sb.toString());
        this.bGn = j;
    }

    /* renamed from: M */
    public void mo24637M(long j) {
        this.bHH = j;
    }

    /* renamed from: OA */
    public void mo24638OA() {
        StringBuilder sb;
        long j;
        if (this.bGn > 0 && !TextUtils.isEmpty(this.bGj) && !TextUtils.isEmpty(this.bGk)) {
            HashMap hashMap = new HashMap();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.bGn);
            sb2.append("");
            hashMap.put("VideoDuration", sb2.toString());
            String str = "PlayDuration";
            if (this.bGp) {
                sb = new StringBuilder();
                j = this.bGn;
            } else {
                sb = new StringBuilder();
                j = this.bHH;
            }
            sb.append(j);
            sb.append("");
            hashMap.put(str, sb.toString());
            if (this.bGl > 0) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(this.bGl);
                sb3.append("");
                hashMap.put("FirstBufferCost", sb3.toString());
            }
            StringBuilder sb4 = new StringBuilder();
            sb4.append(this.bGm);
            sb4.append("");
            hashMap.put("ReBufferCount", sb4.toString());
            if (this.bHK > 0) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append(this.bHK);
                sb5.append("");
                hashMap.put("FullFeedNumber", sb5.toString());
            }
            hashMap.put("VideoId", this.bGj);
            hashMap.put("DomainName", this.bGk);
            hashMap.put("mode", VideoAutoPlayHelper.canAutoPlay(VivaBaseApplication.m8749FZ()) ? "auto" : "manual");
            hashMap.put(SocialServiceDef.EXTRAS_UPGRADE_FROM, C5527a.m14968kj(this.bHI));
            if (!TextUtils.isEmpty(this.bHJ)) {
                StringBuilder sb6 = new StringBuilder();
                sb6.append("Hot_");
                sb6.append(this.bHJ);
                hashMap.put("Secondary_Tab", sb6.toString());
            }
            UserBehaviorLog.onAliEvent("Video_Play_Info", hashMap);
        }
    }

    /* renamed from: QZ */
    public void mo24639QZ() {
        this.bGo = System.currentTimeMillis();
    }

    /* renamed from: Ra */
    public void mo24640Ra() {
        if (!this.bGp && this.bGn > 0) {
            this.bGm++;
        }
    }

    /* renamed from: Rb */
    public void mo24641Rb() {
    }

    /* renamed from: a */
    public void mo24642a(String str, String str2, int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("_");
        sb.append(str2);
        this.bGj = sb.toString();
        this.bHI = i;
    }

    /* renamed from: em */
    public void mo24643em(String str) {
        this.bGk = m11305el(str);
    }

    public void onVideoCompletion() {
        this.bGp = true;
    }
}
