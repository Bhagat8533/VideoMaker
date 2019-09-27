package com.introvd.template.p374q;

import android.content.Context;
import android.os.Bundle;
import com.introvd.template.common.LogUtils;
import com.introvd.template.datacenter.DownloadService;
import com.introvd.template.datacenter.SocialService;
import com.introvd.template.datacenter.SocialServiceDef;
import com.introvd.template.p374q.C8350g.C8354a;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.introvd.template.q.f */
public class C8347f {
    /* access modifiers changed from: private */
    public static final String TAG = "f";
    private static C8347f eje;
    private C8342a ejf;
    private C8342a ejg;
    private C8354a ejh = new C8354a() {
        /* renamed from: a */
        public void mo23009a(Context context, String str, int i, Bundle bundle) {
            String string = bundle.getString("social_method");
            if (string != null) {
                String access$000 = C8347f.TAG;
                StringBuilder sb = new StringBuilder();
                sb.append("Method[");
                sb.append(string);
                sb.append("], result[");
                sb.append(i);
                sb.append("], bundle:");
                sb.append(bundle.toString());
                LogUtils.m14223i(access$000, sb.toString());
                ArrayList<C8349a> arrayList = new ArrayList<>();
                synchronized (C8347f.class) {
                    arrayList.addAll(C8347f.this.eji);
                }
                try {
                    for (C8349a aVar : arrayList) {
                        if (aVar.ejk.equals(string) && aVar.ejl != null) {
                            aVar.ejl.mo23009a(context, string, i, bundle);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                arrayList.clear();
            }
        }
    };
    /* access modifiers changed from: private */
    public List<C8349a> eji = new ArrayList();

    /* renamed from: com.introvd.template.q.f$a */
    private static class C8349a {
        /* access modifiers changed from: private */
        public final String ejk;
        /* access modifiers changed from: private */
        public final C8354a ejl;

        public C8349a(String str, C8354a aVar) {
            this.ejk = str;
            this.ejl = aVar;
        }
    }

    public static synchronized C8347f aKf() {
        C8347f fVar;
        synchronized (C8347f.class) {
            if (eje == null) {
                eje = new C8347f();
            }
            fVar = eje;
        }
        return fVar;
    }

    /* renamed from: a */
    public void mo33600a(int i, C8354a aVar) {
        if (i != 1) {
            if (i == 4 && this.ejf != null) {
                this.ejf.mo33595a("key_api_method", aVar);
            }
        } else if (this.ejg != null) {
            this.ejg.mo33595a("key_notification", aVar);
        }
    }

    /* renamed from: a */
    public void mo33601a(String str, C8354a aVar) {
        C8349a aVar2 = new C8349a(str, aVar);
        synchronized (C8347f.class) {
            this.eji.add(aVar2);
        }
        mo33600a(4, this.ejh);
    }

    public void init(Context context) {
        if (this.ejf == null) {
            this.ejf = new C8342a();
            this.ejf.mo33596d(context, SocialService.class);
        }
        if (this.ejg == null) {
            this.ejg = new C8342a();
            this.ejg.mo33596d(context, DownloadService.class);
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:6|7|(2:8|(2:10|(2:22|12))(0))|13|14|15) */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0034, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x002f */
    /* renamed from: oT */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo33603oT(java.lang.String r5) {
        /*
            r4 = this;
            java.lang.Class<com.introvd.template.q.f> r0 = com.introvd.template.p374q.C8347f.class
            monitor-enter(r0)
            if (r5 == 0) goto L_0x0033
            java.util.List<com.introvd.template.q.f$a> r1 = r4.eji     // Catch:{ all -> 0x0031 }
            boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x0031 }
            if (r1 == 0) goto L_0x000e
            goto L_0x0033
        L_0x000e:
            java.util.List<com.introvd.template.q.f$a> r1 = r4.eji     // Catch:{ Throwable -> 0x002f }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ Throwable -> 0x002f }
        L_0x0014:
            boolean r2 = r1.hasNext()     // Catch:{ Throwable -> 0x002f }
            if (r2 == 0) goto L_0x002f
            java.lang.Object r2 = r1.next()     // Catch:{ Throwable -> 0x002f }
            com.introvd.template.q.f$a r2 = (com.introvd.template.p374q.C8347f.C8349a) r2     // Catch:{ Throwable -> 0x002f }
            java.lang.String r3 = r2.ejk     // Catch:{ Throwable -> 0x002f }
            boolean r3 = r3.equals(r5)     // Catch:{ Throwable -> 0x002f }
            if (r3 == 0) goto L_0x0014
            java.util.List<com.introvd.template.q.f$a> r5 = r4.eji     // Catch:{ Throwable -> 0x002f }
            r5.remove(r2)     // Catch:{ Throwable -> 0x002f }
        L_0x002f:
            monitor-exit(r0)     // Catch:{ all -> 0x0031 }
            return
        L_0x0031:
            r5 = move-exception
            goto L_0x0035
        L_0x0033:
            monitor-exit(r0)     // Catch:{ all -> 0x0031 }
            return
        L_0x0035:
            monitor-exit(r0)     // Catch:{ all -> 0x0031 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.p374q.C8347f.mo33603oT(java.lang.String):void");
    }

    /* renamed from: uC */
    public void mo33604uC(int i) {
        if (i != 1) {
            if (i == 4 && this.ejf != null) {
                this.ejf.mo33597oT("key_api_method");
            }
        } else if (this.ejg != null) {
            this.ejg.mo33597oT("key_notification");
        }
    }

    public void uninit() {
        if (this.ejf != null) {
            mo33603oT(SocialServiceDef.SOCIAL_USER_METHOD_LOGIN);
            mo33604uC(4);
            this.ejf.uninit();
            this.ejf = null;
        }
        if (this.ejg != null) {
            mo33604uC(1);
            this.ejg.uninit();
            this.ejg = null;
        }
    }
}
