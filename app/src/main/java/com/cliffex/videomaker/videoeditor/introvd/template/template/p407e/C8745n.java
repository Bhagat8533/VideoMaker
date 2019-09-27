package com.introvd.template.template.p407e;

import android.content.Context;
import android.text.TextUtils;
import com.introvd.template.crash.C5523b;
import com.introvd.template.datacenter.SocialConstDef;
import com.introvd.template.template.p409g.C8762d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: com.introvd.template.template.e.n */
public class C8745n {
    private static Map<String, List<Long>> etv = new HashMap();
    private static List<String> etw = new ArrayList();

    public static Map<String, List<Long>> aMj() {
        return etv;
    }

    /* renamed from: bv */
    public static String m25556bv(long j) {
        String str = null;
        if (etv == null || etv.isEmpty()) {
            return null;
        }
        Iterator it = etv.keySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            String str2 = (String) it.next();
            List list = (List) etv.get(str2);
            if (list != null && list.contains(Long.valueOf(j))) {
                str = str2;
                break;
            }
        }
        return str;
    }

    /* renamed from: cL */
    public static boolean m25557cL(Context context, String str) {
        context.getContentResolver().delete(SocialConstDef.getTableUri(SocialConstDef.TBL_NAME_TEMPLATE_ROLL_MAP), "rollcode = ?", new String[]{str});
        return true;
    }

    /* renamed from: cM */
    public static boolean m25558cM(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            List<Long> qw = m25562qw(str);
            if (qw != null) {
                for (Long longValue : qw) {
                    C8762d.aMt().mo35218B(C8762d.aMt().mo35225bB(longValue.longValue()), true);
                }
                C8735f.aMf().mo35153qn(str);
                etv.remove(str);
                m25557cL(context, str);
                return true;
            }
        }
        return false;
    }

    /* renamed from: dc */
    public static void m25559dc(List<String> list) {
        etw = list;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x006f, code lost:
        if (r1 != null) goto L_0x007f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x007d, code lost:
        if (r1 != null) goto L_0x007f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x007f, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0082, code lost:
        return r0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0086  */
    /* renamed from: hq */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.util.Map<java.lang.String, java.util.List<java.lang.Long>> m25560hq(android.content.Context r10) throws java.lang.IllegalStateException {
        /*
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.lang.String r1 = "rollcode"
            java.lang.String r2 = "ttid"
            java.lang.String[] r5 = new java.lang.String[]{r1, r2}
            android.content.ContentResolver r3 = r10.getContentResolver()
            java.lang.String r10 = "TemplateRollMap"
            android.net.Uri r4 = com.introvd.template.datacenter.SocialConstDef.getTableUri(r10)
            r6 = 0
            r7 = 0
            r10 = 0
            java.lang.String r8 = "rollcode ASC"
            android.database.Cursor r1 = r3.query(r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x0076, all -> 0x0072 }
            if (r1 == 0) goto L_0x006f
            boolean r10 = r1.moveToFirst()     // Catch:{ Exception -> 0x006d }
            if (r10 == 0) goto L_0x006f
        L_0x0028:
            java.lang.String r10 = "rollcode"
            int r10 = r1.getColumnIndex(r10)     // Catch:{ Exception -> 0x006d }
            java.lang.String r10 = r1.getString(r10)     // Catch:{ Exception -> 0x006d }
            java.lang.String r2 = "ttid"
            int r2 = r1.getColumnIndex(r2)     // Catch:{ Exception -> 0x006d }
            long r2 = r1.getLong(r2)     // Catch:{ Exception -> 0x006d }
            java.lang.Long r2 = java.lang.Long.valueOf(r2)     // Catch:{ Exception -> 0x006d }
            java.util.Set r3 = r0.keySet()     // Catch:{ Exception -> 0x006d }
            boolean r3 = r3.contains(r10)     // Catch:{ Exception -> 0x006d }
            if (r3 == 0) goto L_0x005b
            java.lang.Object r10 = r0.get(r10)     // Catch:{ Exception -> 0x006d }
            java.util.List r10 = (java.util.List) r10     // Catch:{ Exception -> 0x006d }
            if (r10 != 0) goto L_0x0057
            java.util.ArrayList r10 = new java.util.ArrayList     // Catch:{ Exception -> 0x006d }
            r10.<init>()     // Catch:{ Exception -> 0x006d }
        L_0x0057:
            r10.add(r2)     // Catch:{ Exception -> 0x006d }
            goto L_0x0066
        L_0x005b:
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ Exception -> 0x006d }
            r3.<init>()     // Catch:{ Exception -> 0x006d }
            r3.add(r2)     // Catch:{ Exception -> 0x006d }
            r0.put(r10, r3)     // Catch:{ Exception -> 0x006d }
        L_0x0066:
            boolean r10 = r1.moveToNext()     // Catch:{ Exception -> 0x006d }
            if (r10 != 0) goto L_0x0028
            goto L_0x006f
        L_0x006d:
            r10 = move-exception
            goto L_0x007a
        L_0x006f:
            if (r1 == 0) goto L_0x0082
            goto L_0x007f
        L_0x0072:
            r0 = move-exception
            r1 = r10
            r10 = r0
            goto L_0x0084
        L_0x0076:
            r1 = move-exception
            r9 = r1
            r1 = r10
            r10 = r9
        L_0x007a:
            com.introvd.template.crash.C5523b.logException(r10)     // Catch:{ all -> 0x0083 }
            if (r1 == 0) goto L_0x0082
        L_0x007f:
            r1.close()
        L_0x0082:
            return r0
        L_0x0083:
            r10 = move-exception
        L_0x0084:
            if (r1 == 0) goto L_0x0089
            r1.close()
        L_0x0089:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.template.p407e.C8745n.m25560hq(android.content.Context):java.util.Map");
    }

    public static boolean isAnimSubtitleRollcode(String str) {
        return etw.contains(str);
    }

    /* renamed from: qv */
    public static boolean m25561qv(String str) {
        return etv != null && etv.keySet().contains(str);
    }

    /* renamed from: qw */
    public static List<Long> m25562qw(String str) {
        if (etv != null) {
            return (List) etv.get(str);
        }
        return null;
    }

    /* renamed from: qx */
    public static Long m25563qx(String str) {
        List qw = m25562qw(str);
        return (qw == null || qw.size() <= 0) ? Long.valueOf(0) : (Long) qw.get(0);
    }

    public static void updateRollTemplateMapInfo(Context context) {
        try {
            etv = m25560hq(context);
        } catch (IllegalStateException e) {
            C5523b.logException(e);
        }
    }
}
