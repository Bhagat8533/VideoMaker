package com.introvd.template.p173a.p174a;

import android.app.ActivityManager;
import android.app.Application;
import android.os.Debug.MemoryInfo;
import android.os.Process;
import android.text.TextUtils;
import android.view.Choreographer;
import com.google.android.exoplayer2.C3119C;
import com.google.gson.Gson;
import com.introvd.template.VivaBaseApplication;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.common.UserBehaviorLog;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import p037b.p050b.C1834l;
import p037b.p050b.C1842q;
import p037b.p050b.p051a.p053b.C1487a;
import p037b.p050b.p054b.C1495b;
import p037b.p050b.p057e.C1517e;
import p037b.p050b.p076j.C1820a;

/* renamed from: com.introvd.template.a.a.d */
public class C3574d {
    public static boolean bKy = false;
    private static final Pattern biV = Pattern.compile("[^0-9]");

    /* renamed from: com.introvd.template.a.a.d$a */
    private static class C3581a {
        int bKC;
        int dalvikPrivateDirty;

        private C3581a() {
        }
    }

    /* renamed from: RY */
    public static void m8790RY() {
        C1820a.aVh().mo9777a(new Runnable() {
            public void run() {
                try {
                    C3581a o = C3574d.m8801n(VivaBaseApplication.m8749FZ());
                    if (o != null) {
                        HashMap hashMap = new HashMap(2);
                        hashMap.put("dalvikPrivateDirty", String.valueOf(o.dalvikPrivateDirty));
                        hashMap.put("totalPrivateDirty", String.valueOf(o.bKC));
                        UserBehaviorLog.onAliEvent("dev_xiaoyingactivity_start", hashMap);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, 5, TimeUnit.SECONDS);
    }

    /* renamed from: RZ */
    public static void m8791RZ() {
        C1820a.aVh().mo10058o(new Runnable() {
            public void run() {
                try {
                    C3581a o = C3574d.m8801n(VivaBaseApplication.m8749FZ());
                    if (o != null) {
                        HashMap hashMap = new HashMap(2);
                        hashMap.put("dalvikPrivateDirty", String.valueOf(o.dalvikPrivateDirty));
                        hashMap.put("totalPrivateDirty", String.valueOf(o.bKC));
                        UserBehaviorLog.onAliEvent("dev_XiaoYingActivity_quit", hashMap);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /* renamed from: Sa */
    public static void m8792Sa() {
        try {
            C1820a.aVh().mo10058o(new Runnable() {
                public void run() {
                    try {
                        C3581a o = C3574d.m8801n(VivaBaseApplication.m8749FZ());
                        if (o != null) {
                            HashMap hashMap = new HashMap(3);
                            hashMap.put("dalvikPrivateDirty", String.valueOf(o.dalvikPrivateDirty));
                            hashMap.put("totalPrivateDirty", String.valueOf(o.bKC));
                            hashMap.put("percent", String.valueOf(o.dalvikPrivateDirty / o.bKC));
                            UserBehaviorLog.onAliEvent("dev_low_memory", hashMap);
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0077, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0078, code lost:
        r0.printStackTrace();
     */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x009e A[SYNTHETIC, Splitter:B:42:0x009e] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00a8 A[SYNTHETIC, Splitter:B:47:0x00a8] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00af A[SYNTHETIC, Splitter:B:52:0x00af] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00b9 A[SYNTHETIC, Splitter:B:57:0x00b9] */
    /* renamed from: Sb */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int m8793Sb() {
        /*
            r0 = 0
            r1 = 0
            java.lang.Runtime r2 = java.lang.Runtime.getRuntime()     // Catch:{ IOException -> 0x0095, all -> 0x0090 }
            java.lang.String r3 = "top -m 5 -n 1"
            java.lang.Process r2 = r2.exec(r3)     // Catch:{ IOException -> 0x0095, all -> 0x0090 }
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x008b, all -> 0x0088 }
            java.io.InputStream r4 = r2.getInputStream()     // Catch:{ IOException -> 0x008b, all -> 0x0088 }
            r3.<init>(r4)     // Catch:{ IOException -> 0x008b, all -> 0x0088 }
            java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch:{ IOException -> 0x0086 }
            r0.<init>(r3)     // Catch:{ IOException -> 0x0086 }
        L_0x001a:
            java.lang.String r4 = r0.readLine()     // Catch:{ IOException -> 0x0086 }
            if (r4 == 0) goto L_0x0073
            java.lang.String r5 = r4.trim()     // Catch:{ IOException -> 0x0086 }
            int r5 = r5.length()     // Catch:{ IOException -> 0x0086 }
            r6 = 1
            if (r5 < r6) goto L_0x001a
            java.lang.String r5 = "com.quvideo.xiaoying"
            boolean r5 = r4.contains(r5)     // Catch:{ IOException -> 0x0086 }
            if (r5 == 0) goto L_0x001a
            java.lang.String r5 = "com.quvideo.xiaoying:"
            boolean r5 = r4.contains(r5)     // Catch:{ IOException -> 0x0086 }
            if (r5 == 0) goto L_0x003c
            goto L_0x001a
        L_0x003c:
            java.lang.String r0 = "%"
            java.lang.String[] r0 = r4.split(r0)     // Catch:{ IOException -> 0x0086 }
            r4 = r0[r1]     // Catch:{ IOException -> 0x0086 }
            int r5 = r4.length()     // Catch:{ IOException -> 0x0086 }
            r6 = 3
            if (r5 <= r6) goto L_0x0073
            java.util.regex.Pattern r5 = biV     // Catch:{ IOException -> 0x0086 }
            r0 = r0[r1]     // Catch:{ IOException -> 0x0086 }
            int r7 = r4.length()     // Catch:{ IOException -> 0x0086 }
            int r7 = r7 - r6
            int r4 = r4.length()     // Catch:{ IOException -> 0x0086 }
            java.lang.String r0 = r0.substring(r7, r4)     // Catch:{ IOException -> 0x0086 }
            java.util.regex.Matcher r0 = r5.matcher(r0)     // Catch:{ IOException -> 0x0086 }
            java.lang.String r4 = ""
            java.lang.String r0 = r0.replaceAll(r4)     // Catch:{ IOException -> 0x0086 }
            java.lang.String r0 = r0.trim()     // Catch:{ IOException -> 0x0086 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ IOException -> 0x0086 }
            int r0 = r0.intValue()     // Catch:{ IOException -> 0x0086 }
            r1 = r0
        L_0x0073:
            r3.close()     // Catch:{ Exception -> 0x0077 }
            goto L_0x007b
        L_0x0077:
            r0 = move-exception
            r0.printStackTrace()
        L_0x007b:
            if (r2 == 0) goto L_0x00ab
            r2.destroy()     // Catch:{ Exception -> 0x0081 }
            goto L_0x00ab
        L_0x0081:
            r0 = move-exception
            r0.printStackTrace()
            goto L_0x00ab
        L_0x0086:
            r0 = move-exception
            goto L_0x0099
        L_0x0088:
            r1 = move-exception
            r3 = r0
            goto L_0x0093
        L_0x008b:
            r3 = move-exception
            r8 = r3
            r3 = r0
            r0 = r8
            goto L_0x0099
        L_0x0090:
            r1 = move-exception
            r2 = r0
            r3 = r2
        L_0x0093:
            r0 = r1
            goto L_0x00ad
        L_0x0095:
            r2 = move-exception
            r3 = r0
            r0 = r2
            r2 = r3
        L_0x0099:
            r0.printStackTrace()     // Catch:{ all -> 0x00ac }
            if (r3 == 0) goto L_0x00a6
            r3.close()     // Catch:{ Exception -> 0x00a2 }
            goto L_0x00a6
        L_0x00a2:
            r0 = move-exception
            r0.printStackTrace()
        L_0x00a6:
            if (r2 == 0) goto L_0x00ab
            r2.destroy()     // Catch:{ Exception -> 0x0081 }
        L_0x00ab:
            return r1
        L_0x00ac:
            r0 = move-exception
        L_0x00ad:
            if (r3 == 0) goto L_0x00b7
            r3.close()     // Catch:{ Exception -> 0x00b3 }
            goto L_0x00b7
        L_0x00b3:
            r1 = move-exception
            r1.printStackTrace()
        L_0x00b7:
            if (r2 == 0) goto L_0x00c1
            r2.destroy()     // Catch:{ Exception -> 0x00bd }
            goto L_0x00c1
        L_0x00bd:
            r1 = move-exception
            r1.printStackTrace()
        L_0x00c1:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.p173a.p174a.C3574d.m8793Sb():int");
    }

    /* renamed from: U */
    public static void m8795U(long j) {
        if (j > 0) {
            HashMap hashMap = new HashMap(1);
            hashMap.put("launchTime", String.valueOf(j));
            UserBehaviorLog.onAliEvent("Per_Launch_Time", hashMap);
        }
    }

    /* renamed from: a */
    public static void m8796a(long j, HashMap<String, String> hashMap) {
        if (j > 4000) {
            HashMap hashMap2 = new HashMap(1);
            hashMap2.put("launchTime", String.valueOf(j));
            hashMap2.putAll(hashMap);
            UserBehaviorLog.onAliEvent("Dev_Launch_Time_detail", hashMap2);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static void m8797a(String str, long j, long j2) {
        C1834l c = C1834l.m5257ah(Boolean.valueOf(true)).mo10157d(C1820a.aVi()).mo10152c(C1820a.aVi());
        final long j3 = j2;
        final long j4 = j;
        final String str2 = str;
        C35806 r1 = new C1517e<Boolean>() {
            /* renamed from: d */
            public void accept(Boolean bool) throws Exception {
                C3581a aVar;
                try {
                    aVar = C3574d.m8801n(VivaBaseApplication.m8749FZ());
                } catch (Exception unused) {
                    aVar = null;
                }
                if (aVar != null && aVar.dalvikPrivateDirty > 0 && aVar.bKC > 0) {
                    long j = C3119C.NANOS_PER_SECOND / (j3 - j4);
                    int Sc = C3574d.m8793Sb();
                    HashMap hashMap = new HashMap(4);
                    hashMap.put("pageName", str2);
                    hashMap.put("FPS", j < 0 ? "60" : String.valueOf(j));
                    hashMap.put("Memory", String.valueOf(aVar.dalvikPrivateDirty));
                    hashMap.put("TotalMemory", String.valueOf(aVar.bKC));
                    hashMap.put("CPU", String.valueOf(Sc));
                    if (j > 60 || Sc > 100) {
                        UserBehaviorLog.onAliEvent("Dev_Error_Page_Performance", hashMap);
                        return;
                    }
                    UserBehaviorLog.onAliEvent("Per_Page_Performance", hashMap);
                    String json = new Gson().toJson((Object) hashMap);
                    StringBuilder sb = new StringBuilder();
                    sb.append("Per_Page_Load_Time->");
                    sb.append(json);
                    LogUtilsV2.m14227d(sb.toString());
                }
            }
        };
        c.mo10161e((C1517e<? super T>) r1).mo10152c(C1487a.aUa()).mo10149b((C1842q<? super T>) new C1842q<Boolean>() {
            /* renamed from: a */
            public void mo9877a(C1495b bVar) {
            }

            /* renamed from: b */
            public void mo9886K(Boolean bool) {
            }

            public void onComplete() {
            }

            public void onError(Throwable th) {
            }
        });
    }

    /* renamed from: e */
    public static void m8799e(String str, long j) {
        if (j > 0) {
            HashMap hashMap = new HashMap(2);
            hashMap.put("pageName", str);
            long currentTimeMillis = System.currentTimeMillis() - j;
            hashMap.put("initTime", String.valueOf(currentTimeMillis));
            if (currentTimeMillis >= 20000) {
                UserBehaviorLog.onAliEvent("Dev_Error_Loading_Time", hashMap);
                return;
            }
            UserBehaviorLog.onAliEvent("Per_Page_Load_Time", hashMap);
            StringBuilder sb = new StringBuilder();
            sb.append("pageName = ");
            sb.append(str);
            sb.append(", initTime = ");
            sb.append(currentTimeMillis);
            LogUtilsV2.m14227d(sb.toString());
        }
    }

    /* renamed from: ey */
    public static void m8800ey(final String str) {
        if (!TextUtils.isEmpty(str)) {
            Choreographer.getInstance().postFrameCallback(new C3572b(new C3573c() {
                /* renamed from: e */
                public void mo22853e(long j, long j2) {
                    C3574d.m8797a(str, j, j2);
                }
            }));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: n */
    public static C3581a m8801n(Application application) throws Exception {
        if (application == null) {
            return null;
        }
        MemoryInfo memoryInfo = ((ActivityManager) application.getApplicationContext().getSystemService("activity")).getProcessMemoryInfo(new int[]{Process.myPid()})[0];
        C3581a aVar = new C3581a();
        aVar.bKC = memoryInfo.getTotalPrivateDirty();
        aVar.dalvikPrivateDirty = memoryInfo.dalvikPrivateDirty;
        return aVar;
    }
}
