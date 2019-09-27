package com.introvd.template.template.p407e;

import android.content.Context;
import android.text.TextUtils;
import com.introvd.template.sdk.model.template.TemplateInfo;
import com.introvd.template.sdk.p383c.C8399c;
import com.introvd.template.template.R;
import com.introvd.template.template.model.TemplateGroupInfo;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: com.introvd.template.template.e.e */
public class C8733e {
    private static C8733e esM;
    private List<TemplateGroupInfo> esK = new CopyOnWriteArrayList();
    private List<TemplateInfo> esL = new CopyOnWriteArrayList();
    private C8734a esN = C8734a.SCENE;

    /* renamed from: com.introvd.template.template.e.e$a */
    public enum C8734a {
        PACKAGE,
        SCENE
    }

    public static synchronized C8733e aMa() {
        C8733e eVar;
        synchronized (C8733e.class) {
            if (esM == null) {
                esM = new C8733e();
            }
            eVar = esM;
        }
        return eVar;
    }

    private boolean aMb() {
        return this.esN == C8734a.PACKAGE;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0136, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0138, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void aMc() {
        /*
            r9 = this;
            monitor-enter(r9)
            java.util.List<com.introvd.template.template.model.TemplateGroupInfo> r0 = r9.esK     // Catch:{ all -> 0x0139 }
            r0.clear()     // Catch:{ all -> 0x0139 }
            java.util.List<com.introvd.template.sdk.model.template.TemplateInfo> r0 = r9.esL     // Catch:{ all -> 0x0139 }
            if (r0 == 0) goto L_0x0137
            java.util.List<com.introvd.template.sdk.model.template.TemplateInfo> r0 = r9.esL     // Catch:{ all -> 0x0139 }
            int r0 = r0.size()     // Catch:{ all -> 0x0139 }
            if (r0 > 0) goto L_0x0014
            goto L_0x0137
        L_0x0014:
            java.util.List<com.introvd.template.sdk.model.template.TemplateInfo> r0 = r9.esL     // Catch:{ all -> 0x0139 }
            r1 = 0
            java.lang.Object r0 = r0.get(r1)     // Catch:{ all -> 0x0139 }
            com.introvd.template.sdk.model.template.TemplateInfo r0 = (com.introvd.template.sdk.model.template.TemplateInfo) r0     // Catch:{ all -> 0x0139 }
            java.lang.String r2 = r0.tcid     // Catch:{ all -> 0x0139 }
            boolean r2 = m25463qg(r2)     // Catch:{ all -> 0x0139 }
            if (r2 != 0) goto L_0x006c
            com.introvd.template.template.model.TemplateGroupInfo r2 = new com.introvd.template.template.model.TemplateGroupInfo     // Catch:{ all -> 0x0139 }
            r2.<init>()     // Catch:{ all -> 0x0139 }
            boolean r3 = r9.aMb()     // Catch:{ all -> 0x0139 }
            if (r3 == 0) goto L_0x0037
            java.lang.String r3 = r0.tcid     // Catch:{ all -> 0x0139 }
            boolean r3 = r9.m25466qj(r3)     // Catch:{ all -> 0x0139 }
            goto L_0x003d
        L_0x0037:
            java.lang.String r3 = r0.tcid     // Catch:{ all -> 0x0139 }
            boolean r3 = m25464qh(r3)     // Catch:{ all -> 0x0139 }
        L_0x003d:
            r2.showList = r3     // Catch:{ all -> 0x0139 }
            boolean r3 = r9.aMb()     // Catch:{ all -> 0x0139 }
            if (r3 == 0) goto L_0x004c
            java.lang.String r0 = r0.tcid     // Catch:{ all -> 0x0139 }
            boolean r0 = r9.m25465qi(r0)     // Catch:{ all -> 0x0139 }
            goto L_0x0052
        L_0x004c:
            java.lang.String r0 = r0.tcid     // Catch:{ all -> 0x0139 }
            boolean r0 = m25463qg(r0)     // Catch:{ all -> 0x0139 }
        L_0x0052:
            r2.showGroup = r0     // Catch:{ all -> 0x0139 }
            java.lang.String r0 = ""
            r2.strGroupDisplayName = r0     // Catch:{ all -> 0x0139 }
            java.util.ArrayList<com.introvd.template.sdk.model.template.TemplateInfo> r0 = r2.childList     // Catch:{ all -> 0x0139 }
            java.util.List<com.introvd.template.sdk.model.template.TemplateInfo> r3 = r9.esL     // Catch:{ all -> 0x0139 }
            r0.addAll(r3)     // Catch:{ all -> 0x0139 }
            java.lang.String r0 = java.lang.String.valueOf(r1)     // Catch:{ all -> 0x0139 }
            r2.strGroupCode = r0     // Catch:{ all -> 0x0139 }
            java.util.List<com.introvd.template.template.model.TemplateGroupInfo> r0 = r9.esK     // Catch:{ all -> 0x0139 }
            r0.add(r2)     // Catch:{ all -> 0x0139 }
            goto L_0x0135
        L_0x006c:
            java.util.LinkedHashMap r0 = new java.util.LinkedHashMap     // Catch:{ all -> 0x0139 }
            r0.<init>()     // Catch:{ all -> 0x0139 }
            java.util.List<com.introvd.template.sdk.model.template.TemplateInfo> r2 = r9.esL     // Catch:{ all -> 0x0139 }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x0139 }
            r3 = 0
        L_0x0078:
            boolean r4 = r2.hasNext()     // Catch:{ all -> 0x0139 }
            if (r4 == 0) goto L_0x0098
            java.lang.Object r4 = r2.next()     // Catch:{ all -> 0x0139 }
            com.introvd.template.sdk.model.template.TemplateInfo r4 = (com.introvd.template.sdk.model.template.TemplateInfo) r4     // Catch:{ all -> 0x0139 }
            java.lang.String r5 = r4.strSceneCode     // Catch:{ all -> 0x0139 }
            boolean r5 = r0.containsValue(r5)     // Catch:{ all -> 0x0139 }
            if (r5 != 0) goto L_0x0078
            java.lang.Integer r5 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x0139 }
            java.lang.String r4 = r4.strSceneCode     // Catch:{ all -> 0x0139 }
            r0.put(r5, r4)     // Catch:{ all -> 0x0139 }
            int r3 = r3 + 1
            goto L_0x0078
        L_0x0098:
            r2 = 0
        L_0x0099:
            int r3 = r0.size()     // Catch:{ all -> 0x0139 }
            if (r2 >= r3) goto L_0x0135
            java.lang.Integer r3 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x0139 }
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x0139 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x0139 }
            java.util.List<com.introvd.template.sdk.model.template.TemplateInfo> r4 = r9.esL     // Catch:{ all -> 0x0139 }
            java.lang.Object r4 = r4.get(r1)     // Catch:{ all -> 0x0139 }
            com.introvd.template.sdk.model.template.TemplateInfo r4 = (com.introvd.template.sdk.model.template.TemplateInfo) r4     // Catch:{ all -> 0x0139 }
            com.introvd.template.template.model.TemplateGroupInfo r5 = new com.introvd.template.template.model.TemplateGroupInfo     // Catch:{ all -> 0x0139 }
            r5.<init>()     // Catch:{ all -> 0x0139 }
            java.lang.String r6 = java.lang.String.valueOf(r2)     // Catch:{ all -> 0x0139 }
            r5.strGroupCode = r6     // Catch:{ all -> 0x0139 }
            boolean r6 = r9.aMb()     // Catch:{ all -> 0x0139 }
            if (r6 == 0) goto L_0x00c9
            java.lang.String r6 = r4.tcid     // Catch:{ all -> 0x0139 }
            boolean r6 = r9.m25466qj(r6)     // Catch:{ all -> 0x0139 }
            goto L_0x00cf
        L_0x00c9:
            java.lang.String r6 = r4.tcid     // Catch:{ all -> 0x0139 }
            boolean r6 = m25464qh(r6)     // Catch:{ all -> 0x0139 }
        L_0x00cf:
            r5.showList = r6     // Catch:{ all -> 0x0139 }
            boolean r6 = r9.aMb()     // Catch:{ all -> 0x0139 }
            if (r6 == 0) goto L_0x00de
            java.lang.String r4 = r4.tcid     // Catch:{ all -> 0x0139 }
            boolean r4 = r9.m25465qi(r4)     // Catch:{ all -> 0x0139 }
            goto L_0x00e4
        L_0x00de:
            java.lang.String r4 = r4.tcid     // Catch:{ all -> 0x0139 }
            boolean r4 = m25463qg(r4)     // Catch:{ all -> 0x0139 }
        L_0x00e4:
            r5.showGroup = r4     // Catch:{ all -> 0x0139 }
            java.util.List<com.introvd.template.sdk.model.template.TemplateInfo> r4 = r9.esL     // Catch:{ all -> 0x0139 }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ all -> 0x0139 }
        L_0x00ec:
            boolean r6 = r4.hasNext()     // Catch:{ all -> 0x0139 }
            if (r6 == 0) goto L_0x012c
            java.lang.Object r6 = r4.next()     // Catch:{ all -> 0x0139 }
            com.introvd.template.sdk.model.template.TemplateInfo r6 = (com.introvd.template.sdk.model.template.TemplateInfo) r6     // Catch:{ all -> 0x0139 }
            boolean r7 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x0139 }
            r8 = 1
            if (r7 != 0) goto L_0x0108
            java.lang.String r7 = r6.strSceneCode     // Catch:{ all -> 0x0139 }
            boolean r7 = r3.equals(r7)     // Catch:{ all -> 0x0139 }
            if (r7 == 0) goto L_0x0108
            goto L_0x0118
        L_0x0108:
            boolean r7 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x0139 }
            if (r7 == 0) goto L_0x0117
            java.lang.String r7 = r6.strSceneCode     // Catch:{ all -> 0x0139 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x0139 }
            if (r7 == 0) goto L_0x0117
            goto L_0x0118
        L_0x0117:
            r8 = 0
        L_0x0118:
            if (r8 == 0) goto L_0x00ec
            java.lang.String r7 = r5.strGroupDisplayName     // Catch:{ all -> 0x0139 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x0139 }
            if (r7 == 0) goto L_0x0126
            java.lang.String r7 = r6.strSceneName     // Catch:{ all -> 0x0139 }
            r5.strGroupDisplayName = r7     // Catch:{ all -> 0x0139 }
        L_0x0126:
            java.util.ArrayList<com.introvd.template.sdk.model.template.TemplateInfo> r7 = r5.childList     // Catch:{ all -> 0x0139 }
            r7.add(r6)     // Catch:{ all -> 0x0139 }
            goto L_0x00ec
        L_0x012c:
            java.util.List<com.introvd.template.template.model.TemplateGroupInfo> r3 = r9.esK     // Catch:{ all -> 0x0139 }
            r3.add(r5)     // Catch:{ all -> 0x0139 }
            int r2 = r2 + 1
            goto L_0x0099
        L_0x0135:
            monitor-exit(r9)
            return
        L_0x0137:
            monitor-exit(r9)
            return
        L_0x0139:
            r0 = move-exception
            monitor-exit(r9)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.template.p407e.C8733e.aMc():void");
    }

    /* renamed from: cy */
    private String m25460cy(Context context, String str) {
        String str2 = "";
        if (TextUtils.isEmpty(str) || context == null) {
            return str2;
        }
        String str3 = str.equals(C8399c.ecX) ? context.getString(R.string.xiaoying_str_ve_theme_title_common) : str.equals(C8399c.ecY) ? context.getString(R.string.xiaoying_str_ve_effect_title) : str.equals(C8399c.ecZ) ? context.getString(R.string.xiaoying_str_ve_transition_title) : str.equals(C8399c.eda) ? context.getString(R.string.xiaoying_str_ve_poster_title) : str.equals(C8399c.edb) ? context.getString(R.string.xiaoying_str_ve_subtitle_title) : str.equals(C8399c.edc) ? context.getString(R.string.xiaoying_str_ve_bgm_title) : str.equals(C8399c.edd) ? context.getString(R.string.xiaoying_str_ve_animate_frame_title) : str.equals(C8399c.ede) ? context.getString(R.string.xiaoying_str_ve_sticker) : "";
        return str3;
    }

    /* renamed from: hc */
    private synchronized void m25461hc(Context context) {
        if (aMb()) {
            m25462hd(context);
        } else if (this.esN == C8734a.SCENE) {
            aMc();
        }
        this.esL.clear();
        for (TemplateGroupInfo templateGroupInfo : this.esK) {
            this.esL.addAll(templateGroupInfo.childList);
        }
    }

    /* renamed from: hd */
    private synchronized void m25462hd(Context context) {
        this.esK.clear();
        HashMap hashMap = new HashMap();
        int i = 0;
        for (TemplateInfo templateInfo : this.esL) {
            if (!hashMap.containsValue(templateInfo.tcid)) {
                hashMap.put(Integer.valueOf(i), templateInfo.tcid);
                i++;
            }
        }
        for (int i2 = 0; i2 < hashMap.size(); i2++) {
            String str = (String) hashMap.get(Integer.valueOf(i2));
            if (!TextUtils.isEmpty(str)) {
                TemplateGroupInfo templateGroupInfo = new TemplateGroupInfo();
                templateGroupInfo.showList = aMb() ? m25466qj(str) : m25464qh(str);
                templateGroupInfo.showGroup = true;
                for (TemplateInfo templateInfo2 : this.esL) {
                    if (!TextUtils.isEmpty(str) && str.equals(templateInfo2.tcid)) {
                        templateGroupInfo.childList.add(templateInfo2);
                    }
                }
                templateGroupInfo.strGroupDisplayName = m25460cy(context, ((TemplateInfo) templateGroupInfo.childList.get(0)).tcid);
                templateGroupInfo.strGroupCode = String.valueOf(i2);
                this.esK.add(templateGroupInfo);
            }
        }
    }

    /* renamed from: qg */
    public static boolean m25463qg(String str) {
        return C8399c.edd.equals(str);
    }

    /* renamed from: qh */
    public static boolean m25464qh(String str) {
        return !str.equals(C8399c.edd) && !str.equals(C8399c.ecZ) && !str.equals(C8399c.ecX);
    }

    /* renamed from: qi */
    private boolean m25465qi(String str) {
        return str.equals(C8399c.edb) || str.equals(C8399c.edd) || str.equals(C8399c.ede);
    }

    /* renamed from: qj */
    private boolean m25466qj(String str) {
        return !str.equals(C8399c.edb) && !str.equals(C8399c.edd) && !str.equals(C8399c.ede);
    }

    /* renamed from: Y */
    public void mo35125Y(String str, int i) {
        if (!TextUtils.isEmpty(str) && this.esL != null && this.esL.size() > 0) {
            Iterator it = this.esL.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                TemplateInfo templateInfo = (TemplateInfo) it.next();
                if (templateInfo != null && str.equals(templateInfo.ttid)) {
                    templateInfo.nState = i;
                    break;
                }
            }
        }
    }

    /* renamed from: a */
    public void mo35126a(C8734a aVar) {
        this.esN = aVar;
    }

    public List<TemplateGroupInfo> aMd() {
        return this.esK;
    }

    public synchronized List<TemplateInfo> aMe() {
        return this.esL;
    }

    /* renamed from: dQ */
    public synchronized int mo35129dQ(int i, int i2) {
        int i3;
        i3 = 0;
        for (int i4 = 0; i4 < i; i4++) {
            i3 += mo35133vc(i4);
        }
        return i3 + i2;
    }

    public synchronized int getGroupCount() {
        return this.esK.size();
    }

    /* renamed from: j */
    public synchronized void mo35131j(Context context, List<TemplateInfo> list) {
        this.esL.clear();
        if (list != null) {
            this.esL.addAll(list);
        }
        m25461hc(context);
    }

    /* renamed from: pz */
    public TemplateInfo mo35132pz(String str) {
        if (!TextUtils.isEmpty(str) && this.esL != null && this.esL.size() > 0) {
            for (TemplateInfo templateInfo : this.esL) {
                if (str.equals(templateInfo.ttid)) {
                    return templateInfo;
                }
            }
        }
        return null;
    }

    /* renamed from: vc */
    public synchronized int mo35133vc(int i) {
        if (i >= 0) {
            if (i < this.esK.size()) {
                return ((TemplateGroupInfo) this.esK.get(i)).childList.size();
            }
        }
        return 0;
    }

    /* renamed from: vd */
    public synchronized TemplateGroupInfo mo35134vd(int i) {
        if (i >= 0) {
            if (i < this.esK.size()) {
                return (TemplateGroupInfo) this.esK.get(i);
            }
        }
        return null;
    }
}
