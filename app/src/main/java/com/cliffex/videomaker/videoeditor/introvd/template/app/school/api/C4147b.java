package com.introvd.template.app.school.api;

import android.text.TextUtils;
import com.introvd.template.apicore.C3625c;
import com.introvd.template.apicore.C3633j;
import com.introvd.template.apicore.C3636m;
import com.introvd.template.app.push.api.model.CommonResponseResult;
import com.introvd.template.app.school.api.model.TutorialVideoLabelResult;
import com.introvd.template.app.school.api.model.VideoListResult;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import okhttp3.C9943t;
import p037b.p050b.C1848s;
import p037b.p050b.C1852w;
import p469f.C9769n;

/* renamed from: com.introvd.template.app.school.api.b */
public class C4147b {
    /* renamed from: HN */
    private static C1848s<C4146a> m10335HN() {
        String cZ = C3625c.m8880GI().mo22964cZ("sc");
        return TextUtils.isEmpty(cZ) ? C1848s.m5331x(new Throwable(C3636m.bhq)) : C3636m.m8914dd(cZ).mo10199i(C4148c.bxA);
    }

    /* renamed from: NO */
    public static C1848s<CommonResponseResult<TutorialVideoLabelResult>> m10336NO() {
        return m10335HN().mo10198h(C4151f.bxC);
    }

    /* renamed from: a */
    public static C1848s<CommonResponseResult<String>> m10337a(Number number) {
        return m10335HN().mo10198h(new C4150e(number));
    }

    /* renamed from: a */
    public static C1848s<CommonResponseResult<VideoListResult>> m10338a(Number number, int i, int i2) {
        return m10335HN().mo10198h(new C4149d(number, i, i2));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ C1852w m10339a(C4146a aVar) throws Exception {
        HashMap hashMap = new HashMap();
        StringBuilder sb = new StringBuilder();
        sb.append(C3625c.m8880GI().mo22964cZ("sc"));
        sb.append("getTutorialVideoLabelList");
        return aVar.mo23834c(C3633j.m8905a(C9943t.m28421ti(sb.toString()), (Map<String, Object>) hashMap));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ C1852w m10340a(Number number, int i, int i2, C4146a aVar) throws Exception {
        HashMap hashMap = new HashMap();
        hashMap.put("labelId", number);
        hashMap.put("pageNo", Integer.valueOf(i));
        hashMap.put("pageSize", Integer.valueOf(i2));
        StringBuilder sb = new StringBuilder();
        sb.append(C3625c.m8880GI().mo22964cZ("sc"));
        sb.append("getTutorialVideoLabelList");
        return aVar.mo23835d(C3633j.m8905a(C9943t.m28421ti(sb.toString()), (Map<String, Object>) hashMap));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ C1852w m10341a(Number number, C4146a aVar) throws Exception {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("puid", Long.valueOf(number.longValue()));
        StringBuilder sb = new StringBuilder();
        sb.append(C3625c.m8880GI().mo22964cZ("sc"));
        sb.append("getTutorialVideoLabelList");
        return aVar.mo23836e(C3633j.m8905a(C9943t.m28421ti(sb.toString()), (Map<String, Object>) linkedHashMap));
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public static /* synthetic */ C4146a m10345d(C9769n nVar) throws Exception {
        return (C4146a) nVar.mo37510S(C4146a.class);
    }
}
