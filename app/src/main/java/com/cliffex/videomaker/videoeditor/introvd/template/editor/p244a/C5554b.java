package com.introvd.template.editor.p244a;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.introvd.template.C4681i;
import com.introvd.template.ads.AdParamMgr;
import com.introvd.template.common.CpuFeatures;
import com.introvd.template.common.FileUtils;
import com.introvd.template.common.LogUtils;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.common.MSize;
import com.introvd.template.common.UserBehaviorLog;
import com.introvd.template.common.behavior.UserBehaviorUtils;
import com.introvd.template.common.model.AppStateModel;
import com.introvd.template.datacenter.SocialConstDef;
import com.introvd.template.datacenter.SocialServiceDef;
import com.introvd.template.explorer.p300e.C7213f;
import com.introvd.template.sdk.editor.cache.C8441b;
import com.introvd.template.sdk.model.editor.DataItemProject;
import com.introvd.template.sdk.model.editor.VideoExportParamsModel;
import com.introvd.template.sdk.p390f.C8446b;
import com.introvd.template.sdk.p391g.C8450a;
import com.introvd.template.sdk.utils.C8549f;
import com.introvd.template.sdk.utils.C8572y;
import com.introvd.template.sdk.utils.VeMSize;
import com.introvd.template.sdk.utils.p394b.C8520e;
import com.introvd.template.sdk.utils.p394b.C8538o;
import com.introvd.template.sdk.utils.p394b.C8540q;
import com.introvd.template.sdk.utils.p394b.C8541r;
import com.introvd.template.template.p409g.C8762d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import xiaoying.engine.QEngine;
import xiaoying.engine.base.QUtils;
import xiaoying.engine.base.QVideoInfo;
import xiaoying.engine.clip.QEffect;
import xiaoying.engine.storyboard.QStoryboard;

/* renamed from: com.introvd.template.editor.a.b */
public class C5554b {
    /* renamed from: V */
    public static void m15010V(Context context, int i) {
        HashMap hashMap = new HashMap();
        String str = i < 5 ? "<5" : (i < 5 || i > 10) ? ">10" : "5-10";
        hashMap.put("projecct_number", str);
        UserBehaviorLog.onKVEventBegin(context, "App_Enter", hashMap, "App_Enter");
    }

    /* renamed from: a */
    private static String m15011a(QEngine qEngine, String str, int i, int i2) {
        int i3;
        if (qEngine == null) {
            return "";
        }
        if (FileUtils.isFileExisted(str)) {
            i3 = C8572y.m25082c(qEngine, str);
            QVideoInfo videoInfo = QUtils.getVideoInfo(qEngine, str);
            if (videoInfo != null) {
                i = videoInfo.get(3);
                i2 = videoInfo.get(4);
            }
        } else {
            i3 = 4;
        }
        String str2 = (C8572y.aJm() != 1024 || !QUtils.QueryHWEncCap(qEngine, i3, i, i2)) ? "sw" : "hw";
        StringBuilder sb = new StringBuilder();
        sb.append("sw");
        sb.append("+");
        sb.append(str2);
        return sb.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:129:0x031e A[Catch:{ Exception -> 0x0356 }] */
    /* JADX WARNING: Removed duplicated region for block: B:179:0x0332 A[SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static org.json.JSONObject m15012a(android.content.Context r14, xiaoying.engine.storyboard.QStoryboard r15, long r16) {
        /*
            r1 = r15
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ Exception -> 0x0356 }
            r2.<init>()     // Catch:{ Exception -> 0x0356 }
            if (r1 == 0) goto L_0x0355
            boolean r0 = com.introvd.template.sdk.utils.p394b.C8540q.m24893B(r15)     // Catch:{ Exception -> 0x0356 }
            r3 = 4
            if (r0 == 0) goto L_0x0037
            java.lang.Long r0 = com.introvd.template.sdk.utils.p394b.C8540q.m24894C(r15)     // Catch:{ Exception -> 0x0356 }
            long r4 = r0.longValue()     // Catch:{ Exception -> 0x0356 }
            com.introvd.template.template.g.d r0 = com.introvd.template.template.p409g.C8762d.aMt()     // Catch:{ Exception -> 0x0356 }
            java.lang.String r0 = r0.mo35241l(r4, r3)     // Catch:{ Exception -> 0x0356 }
            java.lang.String r4 = com.introvd.template.sdk.p391g.C8450a.m24469bn(r4)     // Catch:{ Exception -> 0x0356 }
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ Exception -> 0x0356 }
            r5.<init>()     // Catch:{ Exception -> 0x0356 }
            java.lang.String r6 = "name"
            r5.put(r6, r0)     // Catch:{ Exception -> 0x0356 }
            java.lang.String r0 = "ttid"
            r5.put(r0, r4)     // Catch:{ Exception -> 0x0356 }
            java.lang.String r0 = "theme"
            r2.put(r0, r5)     // Catch:{ Exception -> 0x0356 }
        L_0x0037:
            r0 = 3
            int r4 = com.introvd.template.sdk.utils.p394b.C8540q.m24958j(r15, r0)     // Catch:{ Exception -> 0x0356 }
            r5 = 0
            if (r4 <= 0) goto L_0x00bc
            org.json.JSONArray r4 = new org.json.JSONArray     // Catch:{ Exception -> 0x0356 }
            r4.<init>()     // Catch:{ Exception -> 0x0356 }
            org.json.JSONArray r7 = new org.json.JSONArray     // Catch:{ Exception -> 0x0356 }
            r7.<init>()     // Catch:{ Exception -> 0x0356 }
            java.util.ArrayList r0 = com.introvd.template.sdk.utils.p394b.C8538o.m24875g(r15, r0)     // Catch:{ Exception -> 0x0356 }
            java.util.Iterator r8 = r0.iterator()     // Catch:{ Exception -> 0x0356 }
            r9 = r5
        L_0x0053:
            boolean r0 = r8.hasNext()     // Catch:{ Exception -> 0x0356 }
            if (r0 == 0) goto L_0x00b2
            java.lang.Object r0 = r8.next()     // Catch:{ Exception -> 0x0356 }
            com.introvd.template.sdk.editor.cache.b r0 = (com.introvd.template.sdk.editor.cache.C8441b) r0     // Catch:{ Exception -> 0x0356 }
            java.lang.String r0 = r0.aIf()     // Catch:{ Exception -> 0x0356 }
            com.introvd.template.template.g.d r11 = com.introvd.template.template.p409g.C8762d.aMt()     // Catch:{ Exception -> 0x0356 }
            long r11 = r11.getTemplateID(r0)     // Catch:{ Exception -> 0x0356 }
            int r13 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r13 != 0) goto L_0x0070
            goto L_0x0053
        L_0x0070:
            com.introvd.template.template.g.d r9 = com.introvd.template.template.p409g.C8762d.aMt()     // Catch:{ Exception -> 0x0356 }
            java.lang.String r9 = r9.mo35224aa(r0, r3)     // Catch:{ Exception -> 0x0356 }
            java.lang.String r10 = "0"
            java.lang.String r0 = com.introvd.template.sdk.p391g.C8450a.m24469bn(r11)     // Catch:{ Exception -> 0x007f }
            goto L_0x0085
        L_0x007f:
            r0 = move-exception
            r13 = r0
            r13.printStackTrace()     // Catch:{ Exception -> 0x0356 }
            r0 = r10
        L_0x0085:
            boolean r10 = com.introvd.template.sdk.p391g.C8450a.m24466bk(r11)     // Catch:{ Exception -> 0x0356 }
            if (r10 == 0) goto L_0x009e
            org.json.JSONObject r10 = new org.json.JSONObject     // Catch:{ Exception -> 0x0356 }
            r10.<init>()     // Catch:{ Exception -> 0x0356 }
            java.lang.String r13 = "ttid"
            r10.put(r13, r0)     // Catch:{ Exception -> 0x0356 }
            java.lang.String r0 = "name"
            r10.put(r0, r9)     // Catch:{ Exception -> 0x0356 }
            r4.put(r10)     // Catch:{ Exception -> 0x0356 }
            goto L_0x00b0
        L_0x009e:
            org.json.JSONObject r10 = new org.json.JSONObject     // Catch:{ Exception -> 0x0356 }
            r10.<init>()     // Catch:{ Exception -> 0x0356 }
            java.lang.String r13 = "ttid"
            r10.put(r13, r0)     // Catch:{ Exception -> 0x0356 }
            java.lang.String r0 = "name"
            r10.put(r0, r9)     // Catch:{ Exception -> 0x0356 }
            r7.put(r10)     // Catch:{ Exception -> 0x0356 }
        L_0x00b0:
            r9 = r11
            goto L_0x0053
        L_0x00b2:
            java.lang.String r0 = "animBubble"
            r2.put(r0, r4)     // Catch:{ Exception -> 0x0356 }
            java.lang.String r0 = "title"
            r2.put(r0, r7)     // Catch:{ Exception -> 0x0356 }
        L_0x00bc:
            r0 = 8
            int r4 = com.introvd.template.sdk.utils.p394b.C8540q.m24958j(r15, r0)     // Catch:{ Exception -> 0x0356 }
            if (r4 <= 0) goto L_0x011d
            org.json.JSONArray r4 = new org.json.JSONArray     // Catch:{ Exception -> 0x0356 }
            r4.<init>()     // Catch:{ Exception -> 0x0356 }
            java.util.ArrayList r0 = com.introvd.template.sdk.utils.p394b.C8538o.m24875g(r15, r0)     // Catch:{ Exception -> 0x0356 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ Exception -> 0x0356 }
            r7 = r5
        L_0x00d2:
            boolean r9 = r0.hasNext()     // Catch:{ Exception -> 0x0356 }
            if (r9 == 0) goto L_0x0118
            java.lang.Object r9 = r0.next()     // Catch:{ Exception -> 0x0356 }
            com.introvd.template.sdk.editor.cache.b r9 = (com.introvd.template.sdk.editor.cache.C8441b) r9     // Catch:{ Exception -> 0x0356 }
            java.lang.String r9 = r9.aIf()     // Catch:{ Exception -> 0x0356 }
            java.lang.String r10 = "Giphy"
            int r10 = android.text.TextUtils.indexOf(r9, r10)     // Catch:{ Exception -> 0x0356 }
            if (r10 <= 0) goto L_0x00eb
            goto L_0x00d2
        L_0x00eb:
            com.introvd.template.template.g.d r10 = com.introvd.template.template.p409g.C8762d.aMt()     // Catch:{ Exception -> 0x0356 }
            long r10 = r10.getTemplateID(r9)     // Catch:{ Exception -> 0x0356 }
            int r12 = (r10 > r7 ? 1 : (r10 == r7 ? 0 : -1))
            if (r12 != 0) goto L_0x00f8
            goto L_0x00d2
        L_0x00f8:
            com.introvd.template.template.g.d r7 = com.introvd.template.template.p409g.C8762d.aMt()     // Catch:{ Exception -> 0x0356 }
            java.lang.String r7 = r7.mo35224aa(r9, r3)     // Catch:{ Exception -> 0x0356 }
            java.lang.String r8 = com.introvd.template.sdk.p391g.C8450a.m24469bn(r10)     // Catch:{ Exception -> 0x0356 }
            org.json.JSONObject r9 = new org.json.JSONObject     // Catch:{ Exception -> 0x0356 }
            r9.<init>()     // Catch:{ Exception -> 0x0356 }
            java.lang.String r12 = "ttid"
            r9.put(r12, r8)     // Catch:{ Exception -> 0x0356 }
            java.lang.String r8 = "name"
            r9.put(r8, r7)     // Catch:{ Exception -> 0x0356 }
            r4.put(r9)     // Catch:{ Exception -> 0x0356 }
            r7 = r10
            goto L_0x00d2
        L_0x0118:
            java.lang.String r0 = "sticker"
            r2.put(r0, r4)     // Catch:{ Exception -> 0x0356 }
        L_0x011d:
            r0 = 6
            int r4 = com.introvd.template.sdk.utils.p394b.C8540q.m24958j(r15, r0)     // Catch:{ Exception -> 0x0356 }
            if (r4 <= 0) goto L_0x0174
            org.json.JSONArray r4 = new org.json.JSONArray     // Catch:{ Exception -> 0x0356 }
            r4.<init>()     // Catch:{ Exception -> 0x0356 }
            java.util.ArrayList r0 = com.introvd.template.sdk.utils.p394b.C8538o.m24875g(r15, r0)     // Catch:{ Exception -> 0x0356 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ Exception -> 0x0356 }
            r7 = r5
        L_0x0132:
            boolean r9 = r0.hasNext()     // Catch:{ Exception -> 0x0356 }
            if (r9 == 0) goto L_0x016f
            java.lang.Object r9 = r0.next()     // Catch:{ Exception -> 0x0356 }
            com.introvd.template.sdk.editor.cache.b r9 = (com.introvd.template.sdk.editor.cache.C8441b) r9     // Catch:{ Exception -> 0x0356 }
            java.lang.String r9 = r9.aIf()     // Catch:{ Exception -> 0x0356 }
            com.introvd.template.template.g.d r10 = com.introvd.template.template.p409g.C8762d.aMt()     // Catch:{ Exception -> 0x0356 }
            long r10 = r10.getTemplateID(r9)     // Catch:{ Exception -> 0x0356 }
            int r12 = (r7 > r10 ? 1 : (r7 == r10 ? 0 : -1))
            if (r12 != 0) goto L_0x014f
            goto L_0x0132
        L_0x014f:
            java.lang.String r7 = com.introvd.template.sdk.p391g.C8450a.m24469bn(r10)     // Catch:{ Exception -> 0x0356 }
            com.introvd.template.template.g.d r8 = com.introvd.template.template.p409g.C8762d.aMt()     // Catch:{ Exception -> 0x0356 }
            java.lang.String r8 = r8.mo35224aa(r9, r3)     // Catch:{ Exception -> 0x0356 }
            org.json.JSONObject r9 = new org.json.JSONObject     // Catch:{ Exception -> 0x0356 }
            r9.<init>()     // Catch:{ Exception -> 0x0356 }
            java.lang.String r12 = "ttid"
            r9.put(r12, r7)     // Catch:{ Exception -> 0x0356 }
            java.lang.String r7 = "name"
            r9.put(r7, r8)     // Catch:{ Exception -> 0x0356 }
            r4.put(r9)     // Catch:{ Exception -> 0x0356 }
            r7 = r10
            goto L_0x0132
        L_0x016f:
            java.lang.String r0 = "fx"
            r2.put(r0, r4)     // Catch:{ Exception -> 0x0356 }
        L_0x0174:
            java.util.ArrayList r0 = com.introvd.template.sdk.utils.p394b.C8540q.m24904M(r15)     // Catch:{ Exception -> 0x0356 }
            if (r0 == 0) goto L_0x01cf
            int r4 = r0.size()     // Catch:{ Exception -> 0x0356 }
            if (r4 <= 0) goto L_0x01cf
            org.json.JSONArray r4 = new org.json.JSONArray     // Catch:{ Exception -> 0x0356 }
            r4.<init>()     // Catch:{ Exception -> 0x0356 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ Exception -> 0x0356 }
            r7 = r5
        L_0x018a:
            boolean r9 = r0.hasNext()     // Catch:{ Exception -> 0x0356 }
            if (r9 == 0) goto L_0x01ca
            java.lang.Object r9 = r0.next()     // Catch:{ Exception -> 0x0356 }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ Exception -> 0x0356 }
            boolean r10 = android.text.TextUtils.isEmpty(r9)     // Catch:{ Exception -> 0x0356 }
            if (r10 == 0) goto L_0x019d
            goto L_0x018a
        L_0x019d:
            com.introvd.template.template.g.d r10 = com.introvd.template.template.p409g.C8762d.aMt()     // Catch:{ Exception -> 0x0356 }
            long r10 = r10.getTemplateID(r9)     // Catch:{ Exception -> 0x0356 }
            int r12 = (r7 > r10 ? 1 : (r7 == r10 ? 0 : -1))
            if (r12 != 0) goto L_0x01aa
            goto L_0x018a
        L_0x01aa:
            com.introvd.template.template.g.d r7 = com.introvd.template.template.p409g.C8762d.aMt()     // Catch:{ Exception -> 0x0356 }
            java.lang.String r7 = r7.mo35224aa(r9, r3)     // Catch:{ Exception -> 0x0356 }
            java.lang.String r8 = com.introvd.template.sdk.p391g.C8450a.m24469bn(r10)     // Catch:{ Exception -> 0x0356 }
            org.json.JSONObject r9 = new org.json.JSONObject     // Catch:{ Exception -> 0x0356 }
            r9.<init>()     // Catch:{ Exception -> 0x0356 }
            java.lang.String r12 = "name"
            r9.put(r12, r7)     // Catch:{ Exception -> 0x0356 }
            java.lang.String r7 = "ttid"
            r9.put(r7, r8)     // Catch:{ Exception -> 0x0356 }
            r4.put(r9)     // Catch:{ Exception -> 0x0356 }
            r7 = r10
            goto L_0x018a
        L_0x01ca:
            java.lang.String r0 = "filter"
            r2.put(r0, r4)     // Catch:{ Exception -> 0x0356 }
        L_0x01cf:
            java.util.ArrayList r0 = com.introvd.template.sdk.utils.p394b.C8540q.m24897F(r15)     // Catch:{ Exception -> 0x0356 }
            if (r0 == 0) goto L_0x0229
            int r4 = r0.size()     // Catch:{ Exception -> 0x0356 }
            if (r4 <= 0) goto L_0x0229
            org.json.JSONArray r4 = new org.json.JSONArray     // Catch:{ Exception -> 0x0356 }
            r4.<init>()     // Catch:{ Exception -> 0x0356 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ Exception -> 0x0356 }
        L_0x01e4:
            boolean r7 = r0.hasNext()     // Catch:{ Exception -> 0x0356 }
            if (r7 == 0) goto L_0x0224
            java.lang.Object r7 = r0.next()     // Catch:{ Exception -> 0x0356 }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ Exception -> 0x0356 }
            boolean r8 = android.text.TextUtils.isEmpty(r7)     // Catch:{ Exception -> 0x0356 }
            if (r8 == 0) goto L_0x01f7
            goto L_0x01e4
        L_0x01f7:
            com.introvd.template.template.g.d r8 = com.introvd.template.template.p409g.C8762d.aMt()     // Catch:{ Exception -> 0x0356 }
            long r8 = r8.getTemplateID(r7)     // Catch:{ Exception -> 0x0356 }
            int r10 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1))
            if (r10 != 0) goto L_0x0204
            goto L_0x01e4
        L_0x0204:
            com.introvd.template.template.g.d r5 = com.introvd.template.template.p409g.C8762d.aMt()     // Catch:{ Exception -> 0x0356 }
            java.lang.String r5 = r5.mo35224aa(r7, r3)     // Catch:{ Exception -> 0x0356 }
            java.lang.String r6 = com.introvd.template.sdk.p391g.C8450a.m24469bn(r8)     // Catch:{ Exception -> 0x0356 }
            org.json.JSONObject r7 = new org.json.JSONObject     // Catch:{ Exception -> 0x0356 }
            r7.<init>()     // Catch:{ Exception -> 0x0356 }
            java.lang.String r10 = "ttid"
            r7.put(r10, r6)     // Catch:{ Exception -> 0x0356 }
            java.lang.String r6 = "name"
            r7.put(r6, r5)     // Catch:{ Exception -> 0x0356 }
            r4.put(r7)     // Catch:{ Exception -> 0x0356 }
            r5 = r8
            goto L_0x01e4
        L_0x0224:
            java.lang.String r0 = "transtion"
            r2.put(r0, r4)     // Catch:{ Exception -> 0x0356 }
        L_0x0229:
            java.util.ArrayList r0 = com.introvd.template.sdk.utils.p394b.C8540q.m24915X(r15)     // Catch:{ Exception -> 0x0356 }
            int r4 = r0.size()     // Catch:{ Exception -> 0x0356 }
            if (r4 <= 0) goto L_0x025b
            org.json.JSONArray r4 = new org.json.JSONArray     // Catch:{ Exception -> 0x0356 }
            r4.<init>()     // Catch:{ Exception -> 0x0356 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ Exception -> 0x0356 }
        L_0x023c:
            boolean r5 = r0.hasNext()     // Catch:{ Exception -> 0x0356 }
            if (r5 == 0) goto L_0x0256
            java.lang.Object r5 = r0.next()     // Catch:{ Exception -> 0x0356 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ Exception -> 0x0356 }
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch:{ Exception -> 0x0356 }
            r6.<init>()     // Catch:{ Exception -> 0x0356 }
            java.lang.String r7 = "ttid"
            r6.put(r7, r5)     // Catch:{ Exception -> 0x0356 }
            r4.put(r6)     // Catch:{ Exception -> 0x0356 }
            goto L_0x023c
        L_0x0256:
            java.lang.String r0 = "facials"
            r2.put(r0, r4)     // Catch:{ Exception -> 0x0356 }
        L_0x025b:
            java.util.ArrayList r0 = com.introvd.template.sdk.utils.p394b.C8540q.m24961l(r15, r3)     // Catch:{ Exception -> 0x0356 }
            if (r0 == 0) goto L_0x028a
            int r3 = r0.size()     // Catch:{ Exception -> 0x0356 }
            if (r3 <= 0) goto L_0x028a
            java.util.Iterator r0 = r0.iterator()     // Catch:{ Exception -> 0x0356 }
        L_0x026b:
            boolean r3 = r0.hasNext()     // Catch:{ Exception -> 0x0356 }
            if (r3 == 0) goto L_0x028a
            java.lang.Object r3 = r0.next()     // Catch:{ Exception -> 0x0356 }
            com.introvd.template.sdk.editor.cache.b r3 = (com.introvd.template.sdk.editor.cache.C8441b) r3     // Catch:{ Exception -> 0x0356 }
            if (r3 == 0) goto L_0x026b
            java.lang.String r3 = r3.aIf()     // Catch:{ Exception -> 0x0356 }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x0356 }
            if (r3 != 0) goto L_0x026b
            java.lang.String r0 = "dub"
            java.lang.String r3 = "yes"
            r2.put(r0, r3)     // Catch:{ Exception -> 0x0356 }
        L_0x028a:
            r0 = 1
            java.util.ArrayList r3 = com.introvd.template.sdk.utils.p394b.C8540q.m24961l(r15, r0)     // Catch:{ Exception -> 0x0356 }
            if (r3 == 0) goto L_0x02e4
            int r4 = r3.size()     // Catch:{ Exception -> 0x0356 }
            if (r4 <= 0) goto L_0x02e4
            org.json.JSONArray r4 = new org.json.JSONArray     // Catch:{ Exception -> 0x0356 }
            r4.<init>()     // Catch:{ Exception -> 0x0356 }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ Exception -> 0x0356 }
        L_0x02a0:
            boolean r5 = r3.hasNext()     // Catch:{ Exception -> 0x0356 }
            if (r5 == 0) goto L_0x02d9
            java.lang.Object r5 = r3.next()     // Catch:{ Exception -> 0x0356 }
            com.introvd.template.sdk.editor.cache.b r5 = (com.introvd.template.sdk.editor.cache.C8441b) r5     // Catch:{ Exception -> 0x0356 }
            if (r5 == 0) goto L_0x02a0
            java.lang.String r6 = r5.aIf()     // Catch:{ Exception -> 0x0356 }
            java.lang.String r7 = com.introvd.template.common.CommonConfigure.APP_DATA_PATH_RELATIVE     // Catch:{ Exception -> 0x0356 }
            int r7 = android.text.TextUtils.indexOf(r6, r7)     // Catch:{ Exception -> 0x0356 }
            if (r7 < 0) goto L_0x02a0
            boolean r5 = r5.eed     // Catch:{ Exception -> 0x0356 }
            if (r5 != 0) goto L_0x02a0
            java.lang.String r5 = com.introvd.template.explorer.p300e.C7213f.m21303jw(r6)     // Catch:{ Exception -> 0x0356 }
            java.lang.String r6 = com.introvd.template.explorer.p300e.C7213f.m21304jx(r6)     // Catch:{ Exception -> 0x0356 }
            org.json.JSONObject r7 = new org.json.JSONObject     // Catch:{ Exception -> 0x0356 }
            r7.<init>()     // Catch:{ Exception -> 0x0356 }
            java.lang.String r8 = "name"
            r7.put(r8, r5)     // Catch:{ Exception -> 0x0356 }
            java.lang.String r5 = "ttid"
            r7.put(r5, r6)     // Catch:{ Exception -> 0x0356 }
            r4.put(r7)     // Catch:{ Exception -> 0x0356 }
            goto L_0x02a0
        L_0x02d9:
            int r3 = r4.length()     // Catch:{ Exception -> 0x0356 }
            if (r3 <= 0) goto L_0x02e4
            java.lang.String r3 = "bgm"
            r2.put(r3, r4)     // Catch:{ Exception -> 0x0356 }
        L_0x02e4:
            int r3 = r15.getClipCount()     // Catch:{ Exception -> 0x0356 }
            org.json.JSONArray r4 = new org.json.JSONArray     // Catch:{ Exception -> 0x0356 }
            r4.<init>()     // Catch:{ Exception -> 0x0356 }
            r5 = 0
            r6 = 0
            r7 = 0
        L_0x02f0:
            if (r6 >= r3) goto L_0x0335
            xiaoying.engine.clip.QClip r8 = r15.getClip(r6)     // Catch:{ Exception -> 0x0356 }
            if (r8 == 0) goto L_0x0332
            if (r7 != 0) goto L_0x0307
            java.lang.Boolean r7 = com.introvd.template.sdk.utils.p394b.C8537n.m24836o(r8)     // Catch:{ Exception -> 0x0356 }
            boolean r7 = r7.booleanValue()     // Catch:{ Exception -> 0x0356 }
            if (r7 == 0) goto L_0x0305
            goto L_0x0307
        L_0x0305:
            r7 = 0
            goto L_0x0308
        L_0x0307:
            r7 = 1
        L_0x0308:
            float r8 = com.introvd.template.sdk.utils.p394b.C8537n.m24834m(r8)     // Catch:{ Exception -> 0x0356 }
            r9 = 1065353216(0x3f800000, float:1.0)
            float r9 = r8 - r9
            float r9 = java.lang.Math.abs(r9)     // Catch:{ Exception -> 0x0356 }
            double r9 = (double) r9     // Catch:{ Exception -> 0x0356 }
            r11 = 4547007122018943789(0x3f1a36e2eb1c432d, double:1.0E-4)
            int r9 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r9 <= 0) goto L_0x0332
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0356 }
            r9.<init>()     // Catch:{ Exception -> 0x0356 }
            java.lang.String r10 = ""
            r9.append(r10)     // Catch:{ Exception -> 0x0356 }
            r9.append(r8)     // Catch:{ Exception -> 0x0356 }
            java.lang.String r8 = r9.toString()     // Catch:{ Exception -> 0x0356 }
            r4.put(r8)     // Catch:{ Exception -> 0x0356 }
        L_0x0332:
            int r6 = r6 + 1
            goto L_0x02f0
        L_0x0335:
            if (r7 == 0) goto L_0x033e
            java.lang.String r0 = "reverse"
            java.lang.String r1 = "yes"
            r2.put(r0, r1)     // Catch:{ Exception -> 0x0356 }
        L_0x033e:
            int r0 = r4.length()     // Catch:{ Exception -> 0x0356 }
            if (r0 <= 0) goto L_0x0349
            java.lang.String r0 = "speed"
            r2.put(r0, r4)     // Catch:{ Exception -> 0x0356 }
        L_0x0349:
            java.lang.String r0 = "type"
            r1 = r14
            r3 = r16
            java.lang.String r1 = m15036f(r14, r3)     // Catch:{ Exception -> 0x0356 }
            r2.put(r0, r1)     // Catch:{ Exception -> 0x0356 }
        L_0x0355:
            return r2
        L_0x0356:
            r0 = move-exception
            r0.printStackTrace()
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.editor.p244a.C5554b.m15012a(android.content.Context, xiaoying.engine.storyboard.QStoryboard, long):org.json.JSONObject");
    }

    /* renamed from: a */
    public static void m15013a(Context context, int i, MSize mSize, String str, String str2, String str3, boolean z, int i2, long j, String str4) {
        if (mSize != null && context != null) {
            LogUtilsV2.m14228e("recordHDRelaEvent eventCode=Share_Export_Start_Modify_HD");
            String an = C5555c.m15041an((long) i);
            HashMap aeI = aeI();
            aeI.put("theme", str2);
            StringBuilder sb = new StringBuilder();
            sb.append("");
            sb.append(i / 1000);
            aeI.put("duration_detail", sb.toString());
            aeI.put("project_duration", an);
            aeI.put(SocialConstDef.PROJECT_CLIP_COUNT, str3);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("");
            sb2.append(mSize.width);
            String sb3 = sb2.toString();
            StringBuilder sb4 = new StringBuilder();
            sb4.append("");
            sb4.append(mSize.height);
            aeI.put("resolution", m15028al(sb3, sb4.toString()));
            aeI.put("Hd_resolution", str4);
            aeI.put("tool", str);
            StringBuilder sb5 = new StringBuilder();
            sb5.append("");
            sb5.append(z);
            aeI.put("SW_HW_TEST", sb5.toString());
            int ev = m15035ev(context);
            StringBuilder sb6 = new StringBuilder();
            sb6.append("");
            sb6.append(ev);
            aeI.put("app_vercode", sb6.toString());
            StringBuilder sb7 = new StringBuilder();
            sb7.append(j);
            sb7.append("");
            aeI.put("Cast_time", sb7.toString());
            StringBuilder sb8 = new StringBuilder();
            sb8.append(i2);
            sb8.append("");
            aeI.put("Edit_Amount", sb8.toString());
            UserBehaviorLog.onKVEvent(context, "Share_Export_Start_Modify_HD", aeI);
            C4681i.m12184Gp().mo25016Gr().recordEvtOnAppflyer(context, "Share_Export_Start_Modify_HD");
        }
    }

    /* renamed from: a */
    public static void m15014a(Context context, DataItemProject dataItemProject, QStoryboard qStoryboard) {
        if (dataItemProject != null && qStoryboard != null) {
            try {
                if (C8540q.m24893B(qStoryboard)) {
                    long longValue = C8540q.m24894C(qStoryboard).longValue();
                    String l = C8762d.aMt().mo35241l(longValue, 4);
                    HashMap hashMap = new HashMap();
                    hashMap.put("theme_Name", l);
                    hashMap.put("ttid", C8450a.m24469bn(longValue));
                    UserBehaviorLog.onKVEvent(context, "Share_Export_Template_Theme", hashMap);
                }
                if (C8540q.m24958j(qStoryboard, 3) > 0) {
                    HashSet<String> hashSet = new HashSet<>();
                    int i = 0;
                    Iterator it = C8538o.m24875g(qStoryboard, 3).iterator();
                    while (it.hasNext()) {
                        C8441b bVar = (C8441b) it.next();
                        String aa = C8762d.aMt().mo35224aa(bVar.aIf(), 4);
                        HashMap hashMap2 = new HashMap();
                        hashMap2.put("Subtitle_Name", aa);
                        long templateID = C8762d.aMt().getTemplateID(bVar.aIf());
                        hashMap2.put("ttid", C8450a.m24469bn(templateID));
                        if (C8450a.m24466bk(templateID)) {
                            UserBehaviorLog.onKVEvent(context, "Share_Export_Template_Animated_Text", hashMap2);
                        } else {
                            UserBehaviorLog.onKVEvent(context, "Share_Export_Template_Subtitle", hashMap2);
                        }
                        int i2 = i + 1;
                        QEffect d = C8540q.m24948d(qStoryboard, 3, i);
                        if (d != null) {
                            String o = C8538o.m24885o(d);
                            if (!TextUtils.isEmpty(o)) {
                                hashSet.add(o);
                            }
                        }
                        i = i2;
                    }
                    for (String str : hashSet) {
                        HashMap hashMap3 = new HashMap();
                        hashMap3.put("name", FileUtils.getFileName(str));
                        UserBehaviorLog.onKVEvent(context, "Share_Export_Template_Font", hashMap3);
                    }
                }
                if (C8540q.m24958j(qStoryboard, 8) > 0) {
                    Iterator it2 = C8538o.m24875g(qStoryboard, 8).iterator();
                    while (it2.hasNext()) {
                        String aIf = ((C8441b) it2.next()).aIf();
                        if (TextUtils.indexOf(aIf, "Giphy") <= 0) {
                            String aa2 = C8762d.aMt().mo35224aa(aIf, 4);
                            HashMap hashMap4 = new HashMap();
                            hashMap4.put("Sticker_Name", aa2);
                            hashMap4.put("ttid", C8450a.m24469bn(C8762d.aMt().getTemplateID(aIf)));
                            UserBehaviorLog.onKVEvent(context, "Share_Export_Template_Sticker", hashMap4);
                        }
                    }
                }
                if (C8540q.m24958j(qStoryboard, 6) > 0) {
                    Iterator it3 = C8538o.m24875g(qStoryboard, 6).iterator();
                    while (it3.hasNext()) {
                        String aIf2 = ((C8441b) it3.next()).aIf();
                        String aa3 = C8762d.aMt().mo35224aa(aIf2, 4);
                        HashMap hashMap5 = new HashMap();
                        hashMap5.put("Effect_Name", aa3);
                        hashMap5.put("ttid", C8450a.m24469bn(C8762d.aMt().getTemplateID(aIf2)));
                        UserBehaviorLog.onKVEvent(context, "Share_Export_Template_FX", hashMap5);
                    }
                }
                ArrayList M = C8540q.m24904M(qStoryboard);
                if (M != null && M.size() > 0) {
                    Iterator it4 = M.iterator();
                    while (it4.hasNext()) {
                        String str2 = (String) it4.next();
                        if (!TextUtils.isEmpty(str2)) {
                            HashMap hashMap6 = new HashMap();
                            String aa4 = C8762d.aMt().mo35224aa(str2, 4);
                            long templateID2 = C8762d.aMt().getTemplateID(str2);
                            hashMap6.put("Filter_Name", aa4);
                            hashMap6.put("ttid", C8450a.m24469bn(templateID2));
                            UserBehaviorLog.onKVEvent(context, "Share_Export_Template_Filter_New", hashMap6);
                        }
                    }
                }
                ArrayList F = C8540q.m24897F(qStoryboard);
                if (F != null && F.size() > 0) {
                    Iterator it5 = F.iterator();
                    while (it5.hasNext()) {
                        String str3 = (String) it5.next();
                        HashMap hashMap7 = new HashMap();
                        hashMap7.put("Transition_Name", C8762d.aMt().mo35224aa(str3, 4));
                        hashMap7.put("ttid", C8450a.m24469bn(C8762d.aMt().getTemplateID(str3)));
                        UserBehaviorLog.onKVEvent(context, "Share_Export_Template_Transition_New", new HashMap(hashMap7));
                    }
                }
                ArrayList l2 = C8540q.m24961l(qStoryboard, 4);
                if (l2 != null && l2.size() > 0) {
                    Iterator it6 = l2.iterator();
                    while (it6.hasNext()) {
                        C8441b bVar2 = (C8441b) it6.next();
                        if (bVar2 != null) {
                            String jx = C7213f.m21304jx(bVar2.aIf());
                            HashMap hashMap8 = new HashMap();
                            hashMap8.put("sounds_ID", jx);
                            UserBehaviorLog.onKVEvent(context, "Share_Export_Template_Sound", hashMap8);
                        }
                    }
                }
                ArrayList l3 = C8540q.m24961l(qStoryboard, 1);
                if (l3 != null && l3.size() > 0) {
                    Iterator it7 = l3.iterator();
                    while (it7.hasNext()) {
                        C8441b bVar3 = (C8441b) it7.next();
                        if (bVar3 != null) {
                            C5555c.m15040aJ(context, C7213f.m21300D(context, bVar3.aIf(), ""));
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    public static void m15015a(Context context, QEngine qEngine, DataItemProject dataItemProject, long j, String str, String str2, String str3, VideoExportParamsModel videoExportParamsModel, boolean z, String str4, boolean z2) {
        DataItemProject dataItemProject2 = dataItemProject;
        try {
            String an = C5555c.m15041an(j);
            HashMap hashMap = new HashMap();
            if (dataItemProject2 != null) {
                int i = dataItemProject2.iPrjDuration;
                String an2 = C5555c.m15041an((long) i);
                String valueOf = String.valueOf(dataItemProject2.streamWidth);
                String valueOf2 = String.valueOf(dataItemProject2.streamHeight);
                String gpuType = C8520e.getGpuType();
                String cpuProcessorInfo = CpuFeatures.getCpuProcessorInfo();
                hashMap.put("theme", str4);
                StringBuilder sb = new StringBuilder();
                sb.append("");
                sb.append(i / 1000);
                hashMap.put("duration_detail", sb.toString());
                hashMap.put("duration", an2);
                String str5 = SocialConstDef.PROJECT_CLIP_COUNT;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("");
                sb2.append(dataItemProject2.iPrjClipCount);
                hashMap.put(str5, sb2.toString());
                hashMap.put("resolution", m15028al(valueOf, valueOf2));
                QEngine qEngine2 = qEngine;
                hashMap.put("codec", m15011a(qEngine, dataItemProject2.strPrjExportURL, dataItemProject2.streamWidth, dataItemProject2.streamHeight));
                hashMap.put("model_name", Build.MODEL);
                StringBuilder sb3 = new StringBuilder();
                sb3.append("");
                sb3.append(VERSION.SDK_INT);
                hashMap.put("OS_version", sb3.toString());
                hashMap.put("GPU", gpuType);
                hashMap.put("Processor", cpuProcessorInfo);
                hashMap.put("export_used_time", an);
                StringBuilder sb4 = new StringBuilder();
                sb4.append("");
                sb4.append(j / 1000);
                hashMap.put("cost_detail", sb4.toString());
                hashMap.put("progress", str);
                hashMap.put("tool", str2);
                StringBuilder sb5 = new StringBuilder();
                sb5.append("");
                sb5.append(z2);
                hashMap.put("SW_HW_TEST", sb5.toString());
                if (videoExportParamsModel != null) {
                    hashMap.put("exp_param", videoExportParamsModel.toString());
                }
                hashMap.put("show_videoad", z ? "show" : "not_show");
                Context context2 = context;
                UserBehaviorLog.onKVEvent(context, str3, hashMap);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public static void m15016a(Context context, QEngine qEngine, DataItemProject dataItemProject, String str, String str2, String str3, boolean z, int i, VideoExportParamsModel videoExportParamsModel, String str4, boolean z2, long j, String str5, boolean z3, String str6) {
        DataItemProject dataItemProject2 = dataItemProject;
        try {
            HashMap hashMap = new HashMap();
            if (dataItemProject2 != null) {
                int i2 = dataItemProject2.iPrjDuration;
                String an = C5555c.m15041an((long) i2);
                StringBuilder sb = new StringBuilder();
                sb.append("");
                sb.append(i2 / 1000);
                hashMap.put("duration_detail", sb.toString());
                StringBuilder sb2 = new StringBuilder();
                sb2.append("");
                sb2.append(j / 1000);
                hashMap.put("cost_detail", sb2.toString());
                hashMap.put("theme", str5);
                hashMap.put("duration", an);
                hashMap.put("Hd_resolution", str6);
                String str7 = SocialConstDef.PROJECT_CLIP_COUNT;
                StringBuilder sb3 = new StringBuilder();
                sb3.append("");
                sb3.append(dataItemProject2.iPrjClipCount);
                hashMap.put(str7, sb3.toString());
                QEngine qEngine2 = qEngine;
                hashMap.put("codec", m15011a(qEngine, dataItemProject2.strPrjExportURL, dataItemProject2.streamWidth, dataItemProject2.streamHeight));
                StringBuilder sb4 = new StringBuilder();
                sb4.append("");
                sb4.append(dataItemProject2.prjThemeType);
                hashMap.put("prjtype", sb4.toString());
            }
            String gpuType = C8520e.getGpuType();
            String cpuProcessorInfo = CpuFeatures.getCpuProcessorInfo();
            hashMap.put("model_name", Build.MODEL);
            StringBuilder sb5 = new StringBuilder();
            sb5.append("");
            sb5.append(VERSION.SDK_INT);
            hashMap.put("OS_version", sb5.toString());
            String str8 = str;
            hashMap.put("errCode", str);
            StringBuilder sb6 = new StringBuilder();
            sb6.append("");
            int i3 = i;
            sb6.append(i);
            hashMap.put("errGroup", sb6.toString());
            hashMap.put("GPU", gpuType);
            hashMap.put("Processor", cpuProcessorInfo);
            String str9 = str2;
            hashMap.put("tool", str2);
            StringBuilder sb7 = new StringBuilder();
            sb7.append("");
            sb7.append(z3);
            hashMap.put("SW_HW_TEST", sb7.toString());
            hashMap.put("isBackground", z ? SocialConstDef.USER_INFO_BACKGROUND : "front");
            int ev = m15035ev(context);
            StringBuilder sb8 = new StringBuilder();
            sb8.append("");
            sb8.append(ev);
            hashMap.put("app_vercode", sb8.toString());
            if (videoExportParamsModel != null) {
                hashMap.put("exp_param", videoExportParamsModel.toString());
            }
            hashMap.put("exp_errorcode_detail", str4);
            hashMap.put("show_videoad", z2 ? "show" : "not_show");
            Context context2 = context;
            String str10 = str3;
            UserBehaviorLog.onKVEvent(context, str3, hashMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public static void m15017a(Context context, QEngine qEngine, DataItemProject dataItemProject, String str, String str2, boolean z, int i, long j) {
        try {
            HashMap hashMap = new HashMap();
            if (dataItemProject != null) {
                String an = C5555c.m15041an((long) dataItemProject.iPrjDuration);
                String valueOf = String.valueOf(dataItemProject.streamWidth);
                String valueOf2 = String.valueOf(dataItemProject.streamHeight);
                String gpuType = C8520e.getGpuType();
                String cpuProcessorInfo = CpuFeatures.getCpuProcessorInfo();
                hashMap.put("theme", str2);
                hashMap.put("duration", an);
                String str3 = SocialConstDef.PROJECT_CLIP_COUNT;
                StringBuilder sb = new StringBuilder();
                sb.append("");
                sb.append(dataItemProject.iPrjClipCount);
                hashMap.put(str3, sb.toString());
                StringBuilder sb2 = new StringBuilder();
                sb2.append("");
                sb2.append(dataItemProject.iPrjDuration / 1000);
                hashMap.put("duration_detail", sb2.toString());
                String al = m15028al(valueOf, valueOf2);
                if (C5555c.cyN.contains(al)) {
                    hashMap.put("resolution", al);
                } else {
                    hashMap.put("resolution", "other");
                }
                StringBuilder sb3 = new StringBuilder();
                sb3.append("");
                sb3.append(dataItemProject.prjThemeType);
                hashMap.put("prjtype", sb3.toString());
                hashMap.put("codec", m15011a(qEngine, dataItemProject.strPrjExportURL, dataItemProject.streamWidth, dataItemProject.streamHeight));
                hashMap.put("model_name", Build.MODEL);
                StringBuilder sb4 = new StringBuilder();
                sb4.append("");
                sb4.append(VERSION.SDK_INT);
                hashMap.put("OS_version", sb4.toString());
                hashMap.put("GPU", gpuType);
                hashMap.put("Processor", cpuProcessorInfo);
                hashMap.put("tool", str);
                hashMap.put("version", getAppVersion());
                int ev = m15035ev(context);
                StringBuilder sb5 = new StringBuilder();
                sb5.append("");
                sb5.append(ev);
                hashMap.put("app_vercode", sb5.toString());
                StringBuilder sb6 = new StringBuilder();
                sb6.append("");
                sb6.append(z);
                hashMap.put("SW_HW_TEST", sb6.toString());
                List providerList = AdParamMgr.getProviderList(43);
                hashMap.put("show_videoad", isHigherHDExport() && providerList != null && providerList.size() > 0 ? "show" : "not_show");
                StringBuilder sb7 = new StringBuilder();
                sb7.append(j);
                sb7.append("");
                hashMap.put("Cast_time", sb7.toString());
                StringBuilder sb8 = new StringBuilder();
                sb8.append(i);
                sb8.append("");
                hashMap.put("Edit_Amount", sb8.toString());
                UserBehaviorLog.onKVEvent(context, "Share_Export_Start_modify", hashMap);
                C4681i.m12184Gp().mo25016Gr().recordEvtOnAppflyer(context, "Share_Export_Start_modify");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public static void m15018a(Context context, QEngine qEngine, String str, long j, String str2, String str3, int i, boolean z, String str4, int i2, boolean z2, String str5) {
        long j2;
        int i3;
        long j3;
        Context context2 = context;
        QEngine qEngine2 = qEngine;
        String str6 = str;
        String str7 = str3;
        int i4 = i;
        if (str6 != null && qEngine2 != null) {
            try {
                HashMap hashMap = new HashMap();
                VeMSize f = C8541r.m24980f(qEngine, str);
                String an = C5555c.m15041an((long) i4);
                int c = C8572y.m25082c(qEngine, str);
                String valueOf = String.valueOf(f.width);
                String valueOf2 = String.valueOf(f.height);
                if (FileUtils.isFileExisted(str)) {
                    j2 = FileUtils.fileSize(str);
                    QVideoInfo videoInfo = QUtils.getVideoInfo(qEngine, str);
                    if (videoInfo != null) {
                        int i5 = videoInfo.get(9);
                        j3 = (long) videoInfo.get(10);
                        i3 = i5;
                    } else {
                        j3 = 0;
                        i3 = 0;
                    }
                } else {
                    j3 = 0;
                    i3 = 0;
                    j2 = 0;
                }
                int i6 = i4 / 1000;
                if (j3 <= 0 && i6 > 0 && j2 > 0) {
                    j3 = (8 * j2) / ((long) i6);
                }
                StringBuilder sb = new StringBuilder();
                sb.append("");
                sb.append(i2);
                hashMap.put("retryCount", sb.toString());
                StringBuilder sb2 = new StringBuilder();
                sb2.append("");
                sb2.append(i4 / 1000);
                hashMap.put("duration_detail", sb2.toString());
                hashMap.put("duration", an);
                hashMap.put("Hd_resolution", str5);
                String resolutionStr = UserBehaviorUtils.getResolutionStr(valueOf, valueOf2);
                if (C5555c.cyN.contains(resolutionStr)) {
                    hashMap.put("resolution", resolutionStr);
                } else {
                    hashMap.put("resolution", "other");
                }
                if (f.width == 0 || f.height == 0) {
                    hashMap.put("error", "no resolution");
                }
                String cpuProcessorInfo = CpuFeatures.getCpuProcessorInfo();
                hashMap.put("theme", str4);
                StringBuilder sb3 = new StringBuilder();
                sb3.append("");
                sb3.append(j2 / 1048576);
                hashMap.put("size_detail", sb3.toString());
                hashMap.put("filesize", C5555c.m15042av(j2));
                hashMap.put("bitrate", C5555c.m15043b(j3, c == 2));
                hashMap.put("fps", C5555c.m15045lc(i3 / 1000));
                hashMap.put("codec", m15011a(qEngine2, str6, 0, 0));
                hashMap.put("time_ratio", C5555c.m15044f(j / 1000, (long) i6));
                hashMap.put("timecost", C5555c.m15041an(j));
                StringBuilder sb4 = new StringBuilder();
                sb4.append("");
                sb4.append(j / 1000);
                hashMap.put("cost_detail", sb4.toString());
                hashMap.put("tool", str2);
                int ev = m15035ev(context);
                StringBuilder sb5 = new StringBuilder();
                sb5.append("");
                sb5.append(ev);
                hashMap.put("app_vercode", sb5.toString());
                hashMap.put("show_videoad", z ? "show" : "not_show");
                hashMap.put("fullpath", str6);
                hashMap.put("Processor", cpuProcessorInfo);
                StringBuilder sb6 = new StringBuilder();
                sb6.append("");
                sb6.append(z2);
                hashMap.put("SW_HW_TEST", sb6.toString());
                Context context3 = context;
                String str8 = str3;
                UserBehaviorLog.onKVEvent(context3, str8, hashMap);
                C4681i.m12184Gp().mo25016Gr().recordEvtOnAppflyer(context3, str8);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    public static void m15019a(Context context, boolean z, boolean z2) {
        HashMap hashMap = new HashMap();
        if (z2) {
            hashMap.put("normal_status", z ? "on" : "off");
        } else {
            hashMap.put("multiple_status", z ? "on" : "off");
        }
        UserBehaviorLog.onKVEvent(context, "VE_Apply_All", hashMap);
    }

    /* renamed from: a */
    public static void m15020a(Context context, boolean z, boolean z2, boolean z3) {
        HashMap aeI = aeI();
        aeI.put("hdItemShow", z ? "show" : "hide");
        aeI.put("gitItemShow", z2 ? "show" : "hide");
        aeI.put(SocialServiceDef.EXTRAS_UPGRADE_FROM, z3 ? "export_btn" : "upload_btn");
        UserBehaviorLog.onKVEvent(context, "HD_Export_Dialog_Show", aeI);
    }

    /* renamed from: aB */
    public static void m15021aB(Context context, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("name", str);
        UserBehaviorLog.onKVEvent(context, "VE_Undo_Click", hashMap);
    }

    /* renamed from: aC */
    public static void m15022aC(Context context, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("name", str);
        UserBehaviorLog.onKVEvent(context, "VE_Redo_Click", hashMap);
    }

    /* renamed from: aD */
    public static void m15023aD(Context context, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("which", str);
        UserBehaviorLog.onKVEvent(context, "VE_Apply_All", hashMap);
    }

    /* renamed from: aE */
    public static void m15024aE(Context context, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("order", str);
        UserBehaviorLog.onKVEvent(context, "VE_Tools_Sort", hashMap);
    }

    /* renamed from: aF */
    public static void m15025aF(Context context, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("tab", str);
        UserBehaviorLog.onKVEvent(context, "Preview_Toturial_Icon_Click", hashMap);
    }

    /* renamed from: aG */
    public static void m15026aG(Context context, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("name", str);
        UserBehaviorLog.onKVEvent(context, "Preview_Toturial_individual_Feature_Click", hashMap);
    }

    /* renamed from: aH */
    public static void m15027aH(Context context, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("recordHDRelaEvent eventCode=");
        sb.append(str);
        LogUtils.m14222e("yqg", sb.toString());
        UserBehaviorLog.onKVEvent(context, str, aeI());
    }

    private static HashMap<String, String> aeI() {
        HashMap<String, String> hashMap = new HashMap<>();
        String gpuType = C8520e.getGpuType();
        StringBuilder sb = new StringBuilder();
        sb.append(CpuFeatures.getCpuImplementer());
        sb.append(CpuFeatures.getCpuArch());
        sb.append(CpuFeatures.getCpuVariant());
        sb.append(CpuFeatures.getCpuPart());
        sb.append(CpuFeatures.getCpuRevision());
        String sb2 = sb.toString();
        String cpuProcessorInfo = CpuFeatures.getCpuProcessorInfo();
        hashMap.put("model_name", Build.MODEL);
        StringBuilder sb3 = new StringBuilder();
        sb3.append("");
        sb3.append(VERSION.SDK_INT);
        hashMap.put("Android_Version", sb3.toString());
        hashMap.put("GPU", gpuType);
        hashMap.put("CPUID", sb2);
        hashMap.put("Processor", cpuProcessorInfo);
        hashMap.put("BetaTested_v2", C8549f.aJg() ? "yes" : "no");
        return hashMap;
    }

    /* renamed from: al */
    private static String m15028al(String str, String str2) {
        String resolutionStr = UserBehaviorUtils.getResolutionStr(str, str2);
        return !C5555c.cyN.contains(resolutionStr) ? "other" : resolutionStr;
    }

    /* renamed from: e */
    public static void m15029e(Context context, String str, boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("name", str);
        hashMap.put("value", z ? "modified" : "Not");
        UserBehaviorLog.onKVEvent(context, "VE_Tools_Finish_Feature", hashMap);
    }

    /* renamed from: eq */
    public static void m15030eq(Context context) {
        UserBehaviorLog.onKVEvent(context, "Gallery_Crop_Icon_Click", new HashMap());
    }

    /* renamed from: er */
    public static void m15031er(Context context) {
        UserBehaviorLog.onKVEvent(context, "Gallery_Crop_Adjust", new HashMap());
    }

    /* renamed from: es */
    public static void m15032es(Context context) {
        UserBehaviorLog.onKVEvent(context, "Preview_Quick_Enter", new HashMap());
    }

    /* renamed from: et */
    public static void m15033et(Context context) {
        UserBehaviorLog.onKVEvent(context, "Preview_Quick_Click_Edit", new HashMap());
    }

    /* renamed from: eu */
    public static void m15034eu(Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put("result", C8549f.aJe().booleanValue() ? "yes" : "no");
        String str = "normal";
        if (C8549f.aJf().booleanValue()) {
            str = "HDTestBed";
        } else if (C8549f.aJc()) {
            str = "1080P";
        } else if (C8549f.aJe().booleanValue()) {
            str = "720P";
        }
        String str2 = "normal";
        if (C8549f.aJc()) {
            str2 = "1080P";
        } else if (C8549f.aJe().booleanValue()) {
            str2 = "720P";
        }
        if (C8549f.aJf().booleanValue()) {
            StringBuilder sb = new StringBuilder();
            sb.append(str2);
            sb.append("_HDTestBed");
            str2 = sb.toString();
        }
        hashMap.put("type", str);
        hashMap.put("typeComb", str2);
        UserBehaviorLog.onKVEvent(context, "HD_Export_Device_Info", hashMap);
    }

    /* renamed from: ev */
    private static int m15035ev(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (NameNotFoundException unused) {
            return 0;
        }
    }

    /* renamed from: f */
    private static String m15036f(Context context, long j) {
        String str = "unknow";
        if (C8446b.aIZ().mo34322bi(j)) {
            return "camera";
        }
        long bh = (long) C8446b.aIZ().mo34321bh(j);
        return bh == 3 ? "mv" : bh == 4 ? "video" : bh == 10 ? "pip" : str;
    }

    private static String getAppVersion() {
        return AppStateModel.getInstance().isInChina() ? "domestic" : AppStateModel.getInstance().isCommunitySupport() ? "overseas community" : "overseas tool";
    }

    private static boolean isHigherHDExport() {
        return C8549f.aJg() && C8549f.aJc();
    }

    public static void recordPrjSave(Context context, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(SocialServiceDef.EXTRAS_UPGRADE_FROM, str);
        UserBehaviorLog.onKVEvent(context, "VE_Draft_Save", hashMap);
    }
}
