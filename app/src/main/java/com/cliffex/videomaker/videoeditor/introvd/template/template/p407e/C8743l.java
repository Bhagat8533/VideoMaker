package com.introvd.template.template.p407e;

import android.content.Context;
import com.introvd.template.common.Utils;
import com.introvd.template.datacenter.SocialConstDef;
import com.introvd.template.sdk.model.ComparatorBaseObject;
import com.introvd.template.sdk.model.template.RollInfo;
import com.introvd.template.sdk.model.template.TemplateInfo;
import com.introvd.template.sdk.model.template.TemplateRollModel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.introvd.template.template.e.l */
public class C8743l {
    private static Map<String, List<TemplateInfo>> etp = new LinkedHashMap();
    private static Map<String, List<TemplateInfo>> etq = new LinkedHashMap();

    /* renamed from: ae */
    public static TemplateInfo m25550ae(Context context, String str, String str2) {
        List<TemplateInfo> cH = m25551cH(context, str);
        if (cH != null && cH.size() > 0) {
            for (TemplateInfo templateInfo : cH) {
                if (templateInfo != null && templateInfo.ttid != null && templateInfo.ttid.equals(str2)) {
                    return templateInfo;
                }
            }
        }
        return null;
    }

    /* renamed from: cH */
    public static List<TemplateInfo> m25551cH(Context context, String str) {
        List<TemplateInfo> list = (List) etp.get(str);
        if (list != null && list.size() != 0) {
            return list;
        }
        List<TemplateInfo> cK = m25554cK(context, str);
        etp.put(str, cK);
        return cK;
    }

    /* renamed from: cI */
    public static List<TemplateInfo> m25552cI(Context context, String str) {
        List<TemplateInfo> list = (List) etq.get(str);
        if (list != null && list.size() != 0) {
            return list;
        }
        List<TemplateInfo> cJ = m25553cJ(context, str);
        etq.put(str, cJ);
        return cJ;
    }

    /* renamed from: cJ */
    private static List<TemplateInfo> m25553cJ(Context context, String str) {
        ArrayList arrayList = new ArrayList();
        List<TemplateRollModel> a = C8735f.m25476a(context, SocialConstDef.getTableUri(SocialConstDef.TBL_NAME_TEMPLATE_RECOMMEND_ROLL), str, "");
        if (a == null) {
            return arrayList;
        }
        Collections.sort(a, new ComparatorBaseObject());
        String appVersion = Utils.getAppVersion(context);
        for (TemplateRollModel a2 : a) {
            RollInfo a3 = C8735f.m25475a(str, a2);
            C8735f.m25477a((TemplateInfo) a3, 0, appVersion, 0);
            if (7 != a3.nState) {
                arrayList.add(a3);
            }
        }
        return arrayList;
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:59:0x010b */
    /* renamed from: cK */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.util.List<com.introvd.template.sdk.model.template.TemplateInfo> m25554cK(android.content.Context r16, java.lang.String r17) {
        /*
            r0 = r17
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.lang.String r5 = "tcid = ?"
            java.lang.String r2 = "TemplateInfoRecommend"
            android.net.Uri r3 = com.introvd.template.datacenter.SocialConstDef.getTableUri(r2)
            android.content.ContentResolver r2 = r16.getContentResolver()
            r8 = 1
            java.lang.String[] r6 = new java.lang.String[r8]
            r9 = 0
            r6[r9] = r0
            r4 = 0
            r7 = 0
            android.database.Cursor r2 = r2.query(r3, r4, r5, r6, r7)
            if (r2 != 0) goto L_0x0022
            return r1
        L_0x0022:
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ Throwable -> 0x010b, all -> 0x0106 }
            r3.<init>()     // Catch:{ Throwable -> 0x010b, all -> 0x0106 }
        L_0x0027:
            boolean r4 = r2.moveToNext()     // Catch:{ Throwable -> 0x010b, all -> 0x0106 }
            if (r4 == 0) goto L_0x007a
            com.introvd.template.sdk.model.template.TemplateInfo r4 = new com.introvd.template.sdk.model.template.TemplateInfo     // Catch:{ Throwable -> 0x010b, all -> 0x0106 }
            r4.<init>()     // Catch:{ Throwable -> 0x010b, all -> 0x0106 }
            java.lang.String r5 = "ttid"
            int r5 = r2.getColumnIndex(r5)     // Catch:{ Throwable -> 0x010b, all -> 0x0106 }
            java.lang.String r5 = r2.getString(r5)     // Catch:{ Throwable -> 0x010b, all -> 0x0106 }
            r4.ttid = r5     // Catch:{ Throwable -> 0x010b, all -> 0x0106 }
            java.lang.String r5 = "orderno"
            int r5 = r2.getColumnIndex(r5)     // Catch:{ Throwable -> 0x010b, all -> 0x0106 }
            if (r5 < 0) goto L_0x004c
            int r5 = r2.getInt(r5)     // Catch:{ Throwable -> 0x010b, all -> 0x0106 }
            r4.nOrderno = r5     // Catch:{ Throwable -> 0x010b, all -> 0x0106 }
        L_0x004c:
            java.lang.String r5 = "ti_scene_code"
            int r5 = r2.getColumnIndex(r5)     // Catch:{ Throwable -> 0x010b, all -> 0x0106 }
            if (r5 < 0) goto L_0x005a
            java.lang.String r5 = r2.getString(r5)     // Catch:{ Throwable -> 0x010b, all -> 0x0106 }
            r4.strSceneCode = r5     // Catch:{ Throwable -> 0x010b, all -> 0x0106 }
        L_0x005a:
            java.lang.String r5 = "ti_scene_name"
            int r5 = r2.getColumnIndex(r5)     // Catch:{ Throwable -> 0x010b, all -> 0x0106 }
            if (r5 < 0) goto L_0x0068
            java.lang.String r5 = r2.getString(r5)     // Catch:{ Throwable -> 0x010b, all -> 0x0106 }
            r4.strSceneName = r5     // Catch:{ Throwable -> 0x010b, all -> 0x0106 }
        L_0x0068:
            java.lang.String r5 = "ti_scene_icon"
            int r5 = r2.getColumnIndex(r5)     // Catch:{ Throwable -> 0x010b, all -> 0x0106 }
            if (r5 < 0) goto L_0x0076
            java.lang.String r5 = r2.getString(r5)     // Catch:{ Throwable -> 0x010b, all -> 0x0106 }
            r4.strSceneIcon = r5     // Catch:{ Throwable -> 0x010b, all -> 0x0106 }
        L_0x0076:
            r3.add(r4)     // Catch:{ Throwable -> 0x010b, all -> 0x0106 }
            goto L_0x0027
        L_0x007a:
            r2.close()     // Catch:{ Throwable -> 0x010b, all -> 0x0106 }
            java.lang.String r13 = "tcid = ? "
            java.lang.String r4 = "TemplateCard"
            android.net.Uri r11 = com.introvd.template.datacenter.SocialConstDef.getTableUri(r4)     // Catch:{ Throwable -> 0x010b, all -> 0x0106 }
            android.content.ContentResolver r10 = r16.getContentResolver()     // Catch:{ Throwable -> 0x010b, all -> 0x0106 }
            r12 = 0
            java.lang.String[] r14 = new java.lang.String[r8]     // Catch:{ Throwable -> 0x010b, all -> 0x0106 }
            r14[r9] = r0     // Catch:{ Throwable -> 0x010b, all -> 0x0106 }
            r15 = 0
            android.database.Cursor r4 = r10.query(r11, r12, r13, r14, r15)     // Catch:{ Throwable -> 0x010b, all -> 0x0106 }
            if (r4 != 0) goto L_0x0099
            r4.close()     // Catch:{ Exception -> 0x0098 }
        L_0x0098:
            return r1
        L_0x0099:
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ Throwable -> 0x0104, all -> 0x0101 }
            r2.<init>()     // Catch:{ Throwable -> 0x0104, all -> 0x0101 }
        L_0x009e:
            boolean r5 = r4.moveToNext()     // Catch:{ Throwable -> 0x0104, all -> 0x0101 }
            if (r5 == 0) goto L_0x00c0
            com.introvd.template.sdk.model.template.TemplateInfo r5 = com.introvd.template.template.p407e.C8735f.m25478o(r4)     // Catch:{ Throwable -> 0x0104, all -> 0x0101 }
            java.lang.String r6 = com.introvd.template.sdk.p383c.C8399c.edf     // Catch:{ Throwable -> 0x0104, all -> 0x0101 }
            boolean r6 = r6.equals(r0)     // Catch:{ Throwable -> 0x0104, all -> 0x0101 }
            if (r6 != 0) goto L_0x00b7
            java.lang.String r6 = com.introvd.template.common.Utils.getAppVersion(r16)     // Catch:{ Throwable -> 0x0104, all -> 0x0101 }
            com.introvd.template.template.p407e.C8735f.m25477a(r5, r9, r6, r9)     // Catch:{ Throwable -> 0x0104, all -> 0x0101 }
        L_0x00b7:
            r6 = 7
            int r7 = r5.nState     // Catch:{ Throwable -> 0x0104, all -> 0x0101 }
            if (r6 == r7) goto L_0x009e
            r2.add(r5)     // Catch:{ Throwable -> 0x0104, all -> 0x0101 }
            goto L_0x009e
        L_0x00c0:
            java.util.Iterator r0 = r2.iterator()     // Catch:{ Throwable -> 0x0104, all -> 0x0101 }
        L_0x00c4:
            boolean r2 = r0.hasNext()     // Catch:{ Throwable -> 0x0104, all -> 0x0101 }
            if (r2 == 0) goto L_0x00fd
            java.lang.Object r2 = r0.next()     // Catch:{ Throwable -> 0x0104, all -> 0x0101 }
            com.introvd.template.sdk.model.template.TemplateInfo r2 = (com.introvd.template.sdk.model.template.TemplateInfo) r2     // Catch:{ Throwable -> 0x0104, all -> 0x0101 }
            if (r2 != 0) goto L_0x00d3
            goto L_0x00c4
        L_0x00d3:
            java.util.Iterator r5 = r3.iterator()     // Catch:{ Throwable -> 0x0104, all -> 0x0101 }
        L_0x00d7:
            boolean r6 = r5.hasNext()     // Catch:{ Throwable -> 0x0104, all -> 0x0101 }
            if (r6 == 0) goto L_0x00c4
            java.lang.Object r6 = r5.next()     // Catch:{ Throwable -> 0x0104, all -> 0x0101 }
            com.introvd.template.sdk.model.template.TemplateInfo r6 = (com.introvd.template.sdk.model.template.TemplateInfo) r6     // Catch:{ Throwable -> 0x0104, all -> 0x0101 }
            boolean r7 = r2.equals(r6)     // Catch:{ Throwable -> 0x0104, all -> 0x0101 }
            if (r7 == 0) goto L_0x00d7
            int r7 = r6.nOrderno     // Catch:{ Throwable -> 0x0104, all -> 0x0101 }
            r2.nOrderno = r7     // Catch:{ Throwable -> 0x0104, all -> 0x0101 }
            java.lang.String r7 = r6.strSceneCode     // Catch:{ Throwable -> 0x0104, all -> 0x0101 }
            r2.strSceneCode = r7     // Catch:{ Throwable -> 0x0104, all -> 0x0101 }
            java.lang.String r7 = r6.strSceneName     // Catch:{ Throwable -> 0x0104, all -> 0x0101 }
            r2.strSceneName = r7     // Catch:{ Throwable -> 0x0104, all -> 0x0101 }
            java.lang.String r6 = r6.strSceneIcon     // Catch:{ Throwable -> 0x0104, all -> 0x0101 }
            r2.strSceneIcon = r6     // Catch:{ Throwable -> 0x0104, all -> 0x0101 }
            r1.add(r2)     // Catch:{ Throwable -> 0x0104, all -> 0x0101 }
            goto L_0x00d7
        L_0x00fd:
            r4.close()     // Catch:{ Exception -> 0x010e }
            goto L_0x010e
        L_0x0101:
            r0 = move-exception
            r2 = r4
            goto L_0x0107
        L_0x0104:
            r2 = r4
            goto L_0x010b
        L_0x0106:
            r0 = move-exception
        L_0x0107:
            r2.close()     // Catch:{ Exception -> 0x010a }
        L_0x010a:
            throw r0
        L_0x010b:
            r2.close()     // Catch:{ Exception -> 0x010e }
        L_0x010e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.template.p407e.C8743l.m25554cK(android.content.Context, java.lang.String):java.util.List");
    }
}
