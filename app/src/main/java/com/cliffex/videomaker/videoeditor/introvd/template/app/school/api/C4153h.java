package com.introvd.template.app.school.api;

import android.text.TextUtils;
import com.introvd.template.apicore.C3625c;
import com.introvd.template.apicore.C3633j;
import com.introvd.template.apicore.C3636m;
import com.introvd.template.app.push.api.model.CommonResponseResult;
import com.introvd.template.app.school.api.model.TemplateInfo;
import com.introvd.template.app.school.api.model.TemplateListResult;
import com.introvd.template.app.school.api.model.VideoLabelInfoResult;
import java.util.HashMap;
import java.util.Map;
import okhttp3.C9943t;
import p037b.p050b.C1848s;
import p037b.p050b.C1852w;
import p469f.C9769n;

/* renamed from: com.introvd.template.app.school.api.h */
public class C4153h {
    /* renamed from: HN */
    private static C1848s<C4152g> m10352HN() {
        String cZ = C3625c.m8880GI().mo22964cZ("sc");
        return TextUtils.isEmpty(cZ) ? C1848s.m5331x(new Throwable(C3636m.bhq)) : C3636m.m8914dd(cZ).mo10199i(C4154i.bxD);
    }

    /* renamed from: NP */
    public static C1848s<CommonResponseResult<VideoLabelInfoResult>> m10353NP() {
        return m10352HN().mo10198h(C4155j.bxE);
    }

    /* renamed from: NQ */
    public static C1848s<CommonResponseResult<TemplateListResult>> m10354NQ() {
        return m10352HN().mo10198h(C4157l.bxG);
    }

    /* renamed from: a */
    public static C1848s<CommonResponseResult<TemplateListResult>> m10355a(long j, int i, int i2) {
        return m10352HN().mo10198h(new C4156k(j, i, i2));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ C1852w m10356a(long j, int i, int i2, C4152g gVar) throws Exception {
        HashMap hashMap = new HashMap();
        hashMap.put("labelId", Long.valueOf(j));
        hashMap.put("pageSize", Integer.valueOf(i));
        hashMap.put("pageNo", Integer.valueOf(i2));
        StringBuilder sb = new StringBuilder();
        sb.append(C3625c.m8880GI().mo22964cZ("sc"));
        sb.append("getTemplateList");
        return gVar.mo23838g(C3633j.m8905a(C9943t.m28421ti(sb.toString()), (Map<String, Object>) hashMap));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ C1852w m10357a(C4152g gVar) throws Exception {
        HashMap hashMap = new HashMap();
        hashMap.put("pageNo", Integer.valueOf(1));
        hashMap.put("pageSize", Integer.valueOf(100));
        StringBuilder sb = new StringBuilder();
        sb.append(C3625c.m8880GI().mo22964cZ("sc"));
        sb.append("getRecommendTemplate");
        return gVar.mo23839h(C3633j.m8905a(C9943t.m28421ti(sb.toString()), (Map<String, Object>) hashMap));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ C1852w m10358a(String str, C4152g gVar) throws Exception {
        HashMap hashMap = new HashMap();
        hashMap.put("ttid", str);
        StringBuilder sb = new StringBuilder();
        sb.append(C3625c.m8880GI().mo22964cZ("sc"));
        sb.append("getTemplateInfo");
        return gVar.mo23841j(C3633j.m8905a(C9943t.m28421ti(sb.toString()), (Map<String, Object>) hashMap));
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static /* synthetic */ C1852w m10360b(C4152g gVar) throws Exception {
        HashMap hashMap = new HashMap();
        StringBuilder sb = new StringBuilder();
        sb.append(C3625c.m8880GI().mo22964cZ("sc"));
        sb.append("getLabelList");
        return gVar.mo23837f(C3633j.m8905a(C9943t.m28421ti(sb.toString()), (Map<String, Object>) hashMap));
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static /* synthetic */ C1852w m10361b(String str, C4152g gVar) throws Exception {
        HashMap hashMap = new HashMap();
        hashMap.put("ttid", str);
        StringBuilder sb = new StringBuilder();
        sb.append(C3625c.m8880GI().mo22964cZ("sc"));
        sb.append("useTemplate");
        return gVar.mo23840i(C3633j.m8905a(C9943t.m28421ti(sb.toString()), (Map<String, Object>) hashMap));
    }

    /* renamed from: dQ */
    public static C1848s<CommonResponseResult<Void>> m10366dQ(String str) {
        return m10352HN().mo10198h(new C4158m(str));
    }

    /* renamed from: dR */
    public static C1848s<CommonResponseResult<TemplateInfo>> m10367dR(String str) {
        return m10352HN().mo10198h(new C4159n(str));
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public static /* synthetic */ C4152g m10368f(C9769n nVar) throws Exception {
        return (C4152g) nVar.mo37510S(C4152g.class);
    }
}
