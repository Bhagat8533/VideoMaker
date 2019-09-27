package com.introvd.template.app.school.template.detail;

import com.introvd.template.VivaBaseApplication;
import com.introvd.template.common.UserBehaviorLog;
import java.util.HashMap;

/* renamed from: com.introvd.template.app.school.template.detail.j */
class C4233j {
    private String bzb;
    private String bzz = "";
    private long duration = 0;
    private String ttid;
    private String videoUrl;

    C4233j(String str, String str2, String str3) {
        this.videoUrl = str;
        this.ttid = str2;
        this.bzb = str3;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: OA */
    public void mo24216OA() {
        HashMap hashMap = new HashMap();
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(this.duration);
        hashMap.put("PlayDuration", sb.toString());
        hashMap.put("ttid", this.ttid);
        hashMap.put("mode", this.bzz);
        hashMap.put("tab", this.bzb);
        UserBehaviorLog.onKVEvent(VivaBaseApplication.m8749FZ(), "Click_Module_play", hashMap);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: dT */
    public void mo24217dT(String str) {
        this.bzz = str;
    }

    /* access modifiers changed from: 0000 */
    public String getVideoUrl() {
        return this.videoUrl;
    }

    /* access modifiers changed from: 0000 */
    public void setDuration(long j) {
        this.duration = j;
    }
}
