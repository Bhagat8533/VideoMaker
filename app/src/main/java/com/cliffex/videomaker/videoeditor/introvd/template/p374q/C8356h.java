package com.introvd.template.p374q;

import android.content.Context;
import android.content.Intent;
import com.introvd.template.datacenter.SocialServiceDef;
import com.xiaoying.p448a.C9561c;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.introvd.template.q.h */
public class C8356h {
    private static C8356h ejt;
    private final Object egV = new Object();
    private ArrayList<C8357a> eju = new ArrayList<>();

    /* renamed from: com.introvd.template.q.h$a */
    public static class C8357a {
        public int _id = -1;
        public int ejA = 0;
        public String ejB = null;
        public String ejC = null;
        public String ejD = null;
        public String ejE = null;
        public String ejF = null;
        public String ejG = null;
        public String ejH = null;
        public String ejI = null;
        public String ejJ = null;
        public String ejK = null;
        public String ejL = null;
        public String ejM = null;
        public int ejN = -1;
        public int ejO = 0;
        public ArrayList<Object> ejP = new ArrayList<>();
        public int ejv = 0;
        public int ejw = 0;
        public int ejx = 0;
        public int ejy = 0;
        public int ejz = 0;
    }

    private C8356h() {
    }

    public static synchronized C8356h aKg() {
        C8356h hVar;
        synchronized (C8356h.class) {
            if (ejt == null) {
                ejt = new C8356h();
            }
            hVar = ejt;
        }
        return hVar;
    }

    /* renamed from: gO */
    public static void m24101gO(Context context) {
        Intent intent = new Intent(SocialServiceDef.ACTION_SOCIAL_TASK);
        intent.putExtra("CtrlAll", true);
        intent.putExtra("stop", true);
        intent.setPackage(context.getPackageName());
        C9561c.m27511k(context, intent);
    }

    /* renamed from: gS */
    public static void m24102gS(Context context) {
        Intent intent = new Intent(SocialServiceDef.ACTION_SOCIAL_TASK);
        intent.putExtra("CtrlAll", true);
        intent.putExtra("restart", true);
        intent.setPackage(context.getPackageName());
        C9561c.m27511k(context, intent);
    }

    /* renamed from: gT */
    public static void m24103gT(Context context) {
        Intent intent = new Intent(SocialServiceDef.ACTION_SOCIAL_TASK);
        intent.putExtra("CtrlAll", true);
        intent.putExtra("stop", true);
        intent.putExtra(SocialServiceDef.EXTRAS_SERVICE_TASK_MANUALLY, true);
        intent.putExtra(SocialServiceDef.EXTRAS_SERVICE_TASK_RESET_ALL, true);
        intent.setPackage(context.getPackageName());
        C9561c.m27511k(context, intent);
    }

    /* renamed from: gU */
    public static void m24104gU(Context context) {
        Intent intent = new Intent();
        intent.setAction(SocialServiceDef.ACTION_SOCIAL_TASK);
        intent.putExtra(SocialServiceDef.EXTRAS_SERVICE_TASK_APP_EXIT, true);
        intent.setPackage(context.getPackageName());
        C9561c.m27511k(context, intent);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x012a, code lost:
        if (r4 != null) goto L_0x012c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        r4.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x013d, code lost:
        if (r4 != null) goto L_0x012c;
     */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0138 A[SYNTHETIC, Splitter:B:21:0x0138] */
    /* renamed from: gR */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo33613gR(android.content.Context r4) {
        /*
            r3 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            android.content.ContentResolver r4 = r4.getContentResolver()     // Catch:{ Exception -> 0x013c, all -> 0x0134 }
            r2 = 0
            android.database.Cursor r4 = com.introvd.template.p309f.C7350d.m21689a(r4, r2, r2)     // Catch:{ Exception -> 0x013c, all -> 0x0134 }
            if (r4 != 0) goto L_0x0017
            if (r4 == 0) goto L_0x0016
            r4.close()     // Catch:{ Exception -> 0x0016 }
        L_0x0016:
            return
        L_0x0017:
            boolean r1 = r4.moveToNext()     // Catch:{ Exception -> 0x0132, all -> 0x0130 }
            if (r1 == 0) goto L_0x012a
            com.introvd.template.q.h$a r1 = new com.introvd.template.q.h$a     // Catch:{ Exception -> 0x0132, all -> 0x0130 }
            r1.<init>()     // Catch:{ Exception -> 0x0132, all -> 0x0130 }
            java.lang.String r2 = "TaskID"
            int r2 = r4.getColumnIndex(r2)     // Catch:{ Exception -> 0x0132, all -> 0x0130 }
            int r2 = r4.getInt(r2)     // Catch:{ Exception -> 0x0132, all -> 0x0130 }
            r1._id = r2     // Catch:{ Exception -> 0x0132, all -> 0x0130 }
            java.lang.String r2 = "main_type"
            int r2 = r4.getColumnIndex(r2)     // Catch:{ Exception -> 0x0132, all -> 0x0130 }
            int r2 = r4.getInt(r2)     // Catch:{ Exception -> 0x0132, all -> 0x0130 }
            r1.ejv = r2     // Catch:{ Exception -> 0x0132, all -> 0x0130 }
            java.lang.String r2 = "sub_type"
            int r2 = r4.getColumnIndex(r2)     // Catch:{ Exception -> 0x0132, all -> 0x0130 }
            int r2 = r4.getInt(r2)     // Catch:{ Exception -> 0x0132, all -> 0x0130 }
            r1.ejw = r2     // Catch:{ Exception -> 0x0132, all -> 0x0130 }
            java.lang.String r2 = "state"
            int r2 = r4.getColumnIndex(r2)     // Catch:{ Exception -> 0x0132, all -> 0x0130 }
            int r2 = r4.getInt(r2)     // Catch:{ Exception -> 0x0132, all -> 0x0130 }
            r1.ejx = r2     // Catch:{ Exception -> 0x0132, all -> 0x0130 }
            java.lang.String r2 = "sub_state"
            int r2 = r4.getColumnIndex(r2)     // Catch:{ Exception -> 0x0132, all -> 0x0130 }
            int r2 = r4.getInt(r2)     // Catch:{ Exception -> 0x0132, all -> 0x0130 }
            r1.ejy = r2     // Catch:{ Exception -> 0x0132, all -> 0x0130 }
            java.lang.String r2 = "progress_1"
            int r2 = r4.getColumnIndex(r2)     // Catch:{ Exception -> 0x0132, all -> 0x0130 }
            int r2 = r4.getInt(r2)     // Catch:{ Exception -> 0x0132, all -> 0x0130 }
            r1.ejz = r2     // Catch:{ Exception -> 0x0132, all -> 0x0130 }
            java.lang.String r2 = "progress_2"
            int r2 = r4.getColumnIndex(r2)     // Catch:{ Exception -> 0x0132, all -> 0x0130 }
            int r2 = r4.getInt(r2)     // Catch:{ Exception -> 0x0132, all -> 0x0130 }
            r1.ejA = r2     // Catch:{ Exception -> 0x0132, all -> 0x0130 }
            java.lang.String r2 = "user_data"
            int r2 = r4.getColumnIndex(r2)     // Catch:{ Exception -> 0x0132, all -> 0x0130 }
            java.lang.String r2 = r4.getString(r2)     // Catch:{ Exception -> 0x0132, all -> 0x0130 }
            r1.ejB = r2     // Catch:{ Exception -> 0x0132, all -> 0x0130 }
            java.lang.String r2 = "start_time"
            int r2 = r4.getColumnIndex(r2)     // Catch:{ Exception -> 0x0132, all -> 0x0130 }
            java.lang.String r2 = r4.getString(r2)     // Catch:{ Exception -> 0x0132, all -> 0x0130 }
            r1.ejC = r2     // Catch:{ Exception -> 0x0132, all -> 0x0130 }
            java.lang.String r2 = "project_title"
            int r2 = r4.getColumnIndex(r2)     // Catch:{ Exception -> 0x0132, all -> 0x0130 }
            java.lang.String r2 = r4.getString(r2)     // Catch:{ Exception -> 0x0132, all -> 0x0130 }
            r1.ejD = r2     // Catch:{ Exception -> 0x0132, all -> 0x0130 }
            java.lang.String r2 = "project_url"
            int r2 = r4.getColumnIndex(r2)     // Catch:{ Exception -> 0x0132, all -> 0x0130 }
            java.lang.String r2 = r4.getString(r2)     // Catch:{ Exception -> 0x0132, all -> 0x0130 }
            r1.ejE = r2     // Catch:{ Exception -> 0x0132, all -> 0x0130 }
            java.lang.String r2 = "video_thumbnail_local_url"
            int r2 = r4.getColumnIndex(r2)     // Catch:{ Exception -> 0x0132, all -> 0x0130 }
            java.lang.String r2 = r4.getString(r2)     // Catch:{ Exception -> 0x0132, all -> 0x0130 }
            r1.ejF = r2     // Catch:{ Exception -> 0x0132, all -> 0x0130 }
            java.lang.String r2 = "video_thumbnail_remote_url"
            int r2 = r4.getColumnIndex(r2)     // Catch:{ Exception -> 0x0132, all -> 0x0130 }
            java.lang.String r2 = r4.getString(r2)     // Catch:{ Exception -> 0x0132, all -> 0x0130 }
            r1.ejH = r2     // Catch:{ Exception -> 0x0132, all -> 0x0130 }
            java.lang.String r2 = "video_thumbnail_big"
            int r2 = r4.getColumnIndex(r2)     // Catch:{ Exception -> 0x0132, all -> 0x0130 }
            java.lang.String r2 = r4.getString(r2)     // Catch:{ Exception -> 0x0132, all -> 0x0130 }
            r1.ejG = r2     // Catch:{ Exception -> 0x0132, all -> 0x0130 }
            java.lang.String r2 = "video_poster_local_url"
            int r2 = r4.getColumnIndex(r2)     // Catch:{ Exception -> 0x0132, all -> 0x0130 }
            java.lang.String r2 = r4.getString(r2)     // Catch:{ Exception -> 0x0132, all -> 0x0130 }
            r1.ejI = r2     // Catch:{ Exception -> 0x0132, all -> 0x0130 }
            java.lang.String r2 = "video_poster_remote_url"
            int r2 = r4.getColumnIndex(r2)     // Catch:{ Exception -> 0x0132, all -> 0x0130 }
            java.lang.String r2 = r4.getString(r2)     // Catch:{ Exception -> 0x0132, all -> 0x0130 }
            r1.ejJ = r2     // Catch:{ Exception -> 0x0132, all -> 0x0130 }
            java.lang.String r2 = "video_xy_page_url"
            int r2 = r4.getColumnIndex(r2)     // Catch:{ Exception -> 0x0132, all -> 0x0130 }
            java.lang.String r2 = r4.getString(r2)     // Catch:{ Exception -> 0x0132, all -> 0x0130 }
            r1.ejK = r2     // Catch:{ Exception -> 0x0132, all -> 0x0130 }
            java.lang.String r2 = "video_desc"
            int r2 = r4.getColumnIndex(r2)     // Catch:{ Exception -> 0x0132, all -> 0x0130 }
            java.lang.String r2 = r4.getString(r2)     // Catch:{ Exception -> 0x0132, all -> 0x0130 }
            r1.ejL = r2     // Catch:{ Exception -> 0x0132, all -> 0x0130 }
            java.lang.String r2 = "video_local_url"
            int r2 = r4.getColumnIndex(r2)     // Catch:{ Exception -> 0x0132, all -> 0x0130 }
            java.lang.String r2 = r4.getString(r2)     // Catch:{ Exception -> 0x0132, all -> 0x0130 }
            r1.ejM = r2     // Catch:{ Exception -> 0x0132, all -> 0x0130 }
            java.lang.String r2 = "PublishID"
            int r2 = r4.getColumnIndex(r2)     // Catch:{ Exception -> 0x0132, all -> 0x0130 }
            int r2 = r4.getInt(r2)     // Catch:{ Exception -> 0x0132, all -> 0x0130 }
            r1.ejN = r2     // Catch:{ Exception -> 0x0132, all -> 0x0130 }
            java.lang.String r2 = "permission"
            int r2 = r4.getColumnIndex(r2)     // Catch:{ Exception -> 0x0132, all -> 0x0130 }
            int r2 = r4.getInt(r2)     // Catch:{ Exception -> 0x0132, all -> 0x0130 }
            r1.ejO = r2     // Catch:{ Exception -> 0x0132, all -> 0x0130 }
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ Exception -> 0x0132, all -> 0x0130 }
            r2.<init>()     // Catch:{ Exception -> 0x0132, all -> 0x0130 }
            r1.ejP = r2     // Catch:{ Exception -> 0x0132, all -> 0x0130 }
            r0.add(r1)     // Catch:{ Exception -> 0x0132, all -> 0x0130 }
            goto L_0x0017
        L_0x012a:
            if (r4 == 0) goto L_0x0140
        L_0x012c:
            r4.close()     // Catch:{ Exception -> 0x0140 }
            goto L_0x0140
        L_0x0130:
            r0 = move-exception
            goto L_0x0136
        L_0x0132:
            goto L_0x013d
        L_0x0134:
            r0 = move-exception
            r4 = r1
        L_0x0136:
            if (r4 == 0) goto L_0x013b
            r4.close()     // Catch:{ Exception -> 0x013b }
        L_0x013b:
            throw r0
        L_0x013c:
            r4 = r1
        L_0x013d:
            if (r4 == 0) goto L_0x0140
            goto L_0x012c
        L_0x0140:
            java.lang.Object r4 = r3.egV
            monitor-enter(r4)
            java.util.ArrayList<com.introvd.template.q.h$a> r1 = r3.eju     // Catch:{ all -> 0x014e }
            r3.eju = r0     // Catch:{ all -> 0x014e }
            if (r1 == 0) goto L_0x014c
            r1.clear()     // Catch:{ all -> 0x014e }
        L_0x014c:
            monitor-exit(r4)     // Catch:{ all -> 0x014e }
            return
        L_0x014e:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x014e }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.p374q.C8356h.mo33613gR(android.content.Context):void");
    }

    /* renamed from: oU */
    public C8357a mo33614oU(String str) {
        if (this.eju == null) {
            return null;
        }
        synchronized (this.egV) {
            Iterator it = this.eju.iterator();
            while (it.hasNext()) {
                C8357a aVar = (C8357a) it.next();
                if (aVar.ejE.equals(str)) {
                    return aVar;
                }
            }
            return null;
        }
    }

    public void uninit() {
        if (this.eju != null) {
            synchronized (this.egV) {
                this.eju.clear();
                this.eju = null;
            }
        }
    }
}
