package com.aiii.android.arouter.core;

import android.content.Context;
import com.aiii.android.arouter.facade.C1941a;
import com.aiii.android.arouter.facade.model.RouteMeta;
import com.aiii.android.arouter.facade.p096c.C1946b;
import com.aiii.android.arouter.p091c.C1919a;
import com.aiii.android.arouter.p093e.C1940e;
import java.util.concurrent.ThreadPoolExecutor;

/* renamed from: com.aiii.android.arouter.core.a */
public class C1927a {
    static ThreadPoolExecutor asS;
    private static boolean asT;
    private static Context mContext;

    /* JADX WARNING: Removed duplicated region for block: B:21:0x00b5 A[Catch:{ Exception -> 0x0197 }] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void m5553a(android.content.Context r9, java.util.concurrent.ThreadPoolExecutor r10) throws com.aiii.android.arouter.p090b.C1916a {
        /*
            java.lang.Class<com.aiii.android.arouter.core.a> r0 = com.aiii.android.arouter.core.C1927a.class
            monitor-enter(r0)
            mContext = r9     // Catch:{ all -> 0x01b8 }
            asS = r10     // Catch:{ all -> 0x01b8 }
            long r1 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0197 }
            m5557rR()     // Catch:{ Exception -> 0x0197 }
            boolean r10 = asT     // Catch:{ Exception -> 0x0197 }
            r3 = 0
            if (r10 == 0) goto L_0x001e
            com.aiii.android.arouter.facade.template.b r9 = com.aiii.android.arouter.p091c.C1919a.atC     // Catch:{ Exception -> 0x0197 }
            java.lang.String r10 = "ARouter::"
            java.lang.String r4 = "Load router map by arouter-auto-register plugin."
            r9.mo10378h(r10, r4)     // Catch:{ Exception -> 0x0197 }
            goto L_0x0121
        L_0x001e:
            boolean r10 = com.aiii.android.arouter.p091c.C1919a.m5531se()     // Catch:{ Exception -> 0x0197 }
            if (r10 != 0) goto L_0x004b
            boolean r10 = com.aiii.android.arouter.p093e.C1939d.m5574J(r9)     // Catch:{ Exception -> 0x0197 }
            if (r10 == 0) goto L_0x002b
            goto L_0x004b
        L_0x002b:
            com.aiii.android.arouter.facade.template.b r10 = com.aiii.android.arouter.p091c.C1919a.atC     // Catch:{ Exception -> 0x0197 }
            java.lang.String r4 = "ARouter::"
            java.lang.String r5 = "Load router map from cache."
            r10.mo10378h(r4, r5)     // Catch:{ Exception -> 0x0197 }
            java.util.HashSet r10 = new java.util.HashSet     // Catch:{ Exception -> 0x0197 }
            java.lang.String r4 = "SP_AROUTER_CACHE"
            android.content.SharedPreferences r9 = r9.getSharedPreferences(r4, r3)     // Catch:{ Exception -> 0x0197 }
            java.lang.String r4 = "ROUTER_MAP"
            java.util.HashSet r5 = new java.util.HashSet     // Catch:{ Exception -> 0x0197 }
            r5.<init>()     // Catch:{ Exception -> 0x0197 }
            java.util.Set r9 = r9.getStringSet(r4, r5)     // Catch:{ Exception -> 0x0197 }
            r10.<init>(r9)     // Catch:{ Exception -> 0x0197 }
            goto L_0x0078
        L_0x004b:
            com.aiii.android.arouter.facade.template.b r10 = com.aiii.android.arouter.p091c.C1919a.atC     // Catch:{ Exception -> 0x0197 }
            java.lang.String r4 = "ARouter::"
            java.lang.String r5 = "Run with debug mode or new install, rebuild router map."
            r10.mo10378h(r4, r5)     // Catch:{ Exception -> 0x0197 }
            android.content.Context r10 = mContext     // Catch:{ Exception -> 0x0197 }
            java.lang.String r4 = "com.aiii.android.arouter.routes"
            java.util.Set r10 = com.aiii.android.arouter.p093e.C1935a.m5562m(r10, r4)     // Catch:{ Exception -> 0x0197 }
            boolean r4 = r10.isEmpty()     // Catch:{ Exception -> 0x0197 }
            if (r4 != 0) goto L_0x0075
            java.lang.String r4 = "SP_AROUTER_CACHE"
            android.content.SharedPreferences r4 = r9.getSharedPreferences(r4, r3)     // Catch:{ Exception -> 0x0197 }
            android.content.SharedPreferences$Editor r4 = r4.edit()     // Catch:{ Exception -> 0x0197 }
            java.lang.String r5 = "ROUTER_MAP"
            android.content.SharedPreferences$Editor r4 = r4.putStringSet(r5, r10)     // Catch:{ Exception -> 0x0197 }
            r4.apply()     // Catch:{ Exception -> 0x0197 }
        L_0x0075:
            com.aiii.android.arouter.p093e.C1939d.m5575K(r9)     // Catch:{ Exception -> 0x0197 }
        L_0x0078:
            com.aiii.android.arouter.facade.template.b r9 = com.aiii.android.arouter.p091c.C1919a.atC     // Catch:{ Exception -> 0x0197 }
            java.lang.String r4 = "ARouter::"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0197 }
            r5.<init>()     // Catch:{ Exception -> 0x0197 }
            java.lang.String r6 = "Find router map finished, map size = "
            r5.append(r6)     // Catch:{ Exception -> 0x0197 }
            int r6 = r10.size()     // Catch:{ Exception -> 0x0197 }
            r5.append(r6)     // Catch:{ Exception -> 0x0197 }
            java.lang.String r6 = ", cost "
            r5.append(r6)     // Catch:{ Exception -> 0x0197 }
            long r6 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0197 }
            r8 = 0
            long r6 = r6 - r1
            r5.append(r6)     // Catch:{ Exception -> 0x0197 }
            java.lang.String r1 = " ms."
            r5.append(r1)     // Catch:{ Exception -> 0x0197 }
            java.lang.String r1 = r5.toString()     // Catch:{ Exception -> 0x0197 }
            r9.mo10378h(r4, r1)     // Catch:{ Exception -> 0x0197 }
            long r1 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0197 }
            java.util.Iterator r9 = r10.iterator()     // Catch:{ Exception -> 0x0197 }
        L_0x00af:
            boolean r10 = r9.hasNext()     // Catch:{ Exception -> 0x0197 }
            if (r10 == 0) goto L_0x0121
            java.lang.Object r10 = r9.next()     // Catch:{ Exception -> 0x0197 }
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ Exception -> 0x0197 }
            java.lang.String r4 = "com.aiii.android.arouter.routes.ARouter$$Root"
            boolean r4 = r10.startsWith(r4)     // Catch:{ Exception -> 0x0197 }
            if (r4 == 0) goto L_0x00dd
            java.lang.Class r10 = java.lang.Class.forName(r10)     // Catch:{ Exception -> 0x0197 }
            java.lang.Class[] r4 = new java.lang.Class[r3]     // Catch:{ Exception -> 0x0197 }
            java.lang.reflect.Constructor r10 = r10.getConstructor(r4)     // Catch:{ Exception -> 0x0197 }
            java.lang.Object[] r4 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x0197 }
            java.lang.Object r10 = r10.newInstance(r4)     // Catch:{ Exception -> 0x0197 }
            com.aiii.android.arouter.facade.template.f r10 = (com.aiii.android.arouter.facade.template.C1952f) r10     // Catch:{ Exception -> 0x0197 }
            com.aiii.android.arouter.facade.template.f r10 = (com.aiii.android.arouter.facade.template.C1952f) r10     // Catch:{ Exception -> 0x0197 }
            java.util.Map<java.lang.String, java.lang.Class<? extends com.aiii.android.arouter.facade.template.e>> r4 = com.aiii.android.arouter.core.C1929b.asV     // Catch:{ Exception -> 0x0197 }
            r10.loadInto(r4)     // Catch:{ Exception -> 0x0197 }
            goto L_0x00af
        L_0x00dd:
            java.lang.String r4 = "com.aiii.android.arouter.routes.ARouter$$Interceptors"
            boolean r4 = r10.startsWith(r4)     // Catch:{ Exception -> 0x0197 }
            if (r4 == 0) goto L_0x00ff
            java.lang.Class r10 = java.lang.Class.forName(r10)     // Catch:{ Exception -> 0x0197 }
            java.lang.Class[] r4 = new java.lang.Class[r3]     // Catch:{ Exception -> 0x0197 }
            java.lang.reflect.Constructor r10 = r10.getConstructor(r4)     // Catch:{ Exception -> 0x0197 }
            java.lang.Object[] r4 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x0197 }
            java.lang.Object r10 = r10.newInstance(r4)     // Catch:{ Exception -> 0x0197 }
            com.aiii.android.arouter.facade.template.a r10 = (com.aiii.android.arouter.facade.template.C1947a) r10     // Catch:{ Exception -> 0x0197 }
            com.aiii.android.arouter.facade.template.a r10 = (com.aiii.android.arouter.facade.template.C1947a) r10     // Catch:{ Exception -> 0x0197 }
            java.util.Map<java.lang.Integer, java.lang.Class<? extends com.aiii.android.arouter.facade.template.IInterceptor>> r4 = com.aiii.android.arouter.core.C1929b.asZ     // Catch:{ Exception -> 0x0197 }
            r10.loadInto(r4)     // Catch:{ Exception -> 0x0197 }
            goto L_0x00af
        L_0x00ff:
            java.lang.String r4 = "com.aiii.android.arouter.routes.ARouter$$Providers"
            boolean r4 = r10.startsWith(r4)     // Catch:{ Exception -> 0x0197 }
            if (r4 == 0) goto L_0x00af
            java.lang.Class r10 = java.lang.Class.forName(r10)     // Catch:{ Exception -> 0x0197 }
            java.lang.Class[] r4 = new java.lang.Class[r3]     // Catch:{ Exception -> 0x0197 }
            java.lang.reflect.Constructor r10 = r10.getConstructor(r4)     // Catch:{ Exception -> 0x0197 }
            java.lang.Object[] r4 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x0197 }
            java.lang.Object r10 = r10.newInstance(r4)     // Catch:{ Exception -> 0x0197 }
            com.aiii.android.arouter.facade.template.d r10 = (com.aiii.android.arouter.facade.template.C1950d) r10     // Catch:{ Exception -> 0x0197 }
            com.aiii.android.arouter.facade.template.d r10 = (com.aiii.android.arouter.facade.template.C1950d) r10     // Catch:{ Exception -> 0x0197 }
            java.util.Map<java.lang.String, com.aiii.android.arouter.facade.model.RouteMeta> r4 = com.aiii.android.arouter.core.C1929b.asY     // Catch:{ Exception -> 0x0197 }
            r10.loadInto(r4)     // Catch:{ Exception -> 0x0197 }
            goto L_0x00af
        L_0x0121:
            com.aiii.android.arouter.facade.template.b r9 = com.aiii.android.arouter.p091c.C1919a.atC     // Catch:{ Exception -> 0x0197 }
            java.lang.String r10 = "ARouter::"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0197 }
            r4.<init>()     // Catch:{ Exception -> 0x0197 }
            java.lang.String r5 = "Load root element finished, cost "
            r4.append(r5)     // Catch:{ Exception -> 0x0197 }
            long r5 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0197 }
            r7 = 0
            long r5 = r5 - r1
            r4.append(r5)     // Catch:{ Exception -> 0x0197 }
            java.lang.String r1 = " ms."
            r4.append(r1)     // Catch:{ Exception -> 0x0197 }
            java.lang.String r1 = r4.toString()     // Catch:{ Exception -> 0x0197 }
            r9.mo10378h(r10, r1)     // Catch:{ Exception -> 0x0197 }
            java.util.Map<java.lang.String, java.lang.Class<? extends com.aiii.android.arouter.facade.template.e>> r9 = com.aiii.android.arouter.core.C1929b.asV     // Catch:{ Exception -> 0x0197 }
            int r9 = r9.size()     // Catch:{ Exception -> 0x0197 }
            if (r9 != 0) goto L_0x0155
            com.aiii.android.arouter.facade.template.b r9 = com.aiii.android.arouter.p091c.C1919a.atC     // Catch:{ Exception -> 0x0197 }
            java.lang.String r10 = "ARouter::"
            java.lang.String r1 = "No mapping files were found, check your configuration please!"
            r9.mo10380k(r10, r1)     // Catch:{ Exception -> 0x0197 }
        L_0x0155:
            boolean r9 = com.aiii.android.arouter.p091c.C1919a.m5531se()     // Catch:{ Exception -> 0x0197 }
            if (r9 == 0) goto L_0x0195
            com.aiii.android.arouter.facade.template.b r9 = com.aiii.android.arouter.p091c.C1919a.atC     // Catch:{ Exception -> 0x0197 }
            java.lang.String r10 = "ARouter::"
            java.util.Locale r1 = java.util.Locale.getDefault()     // Catch:{ Exception -> 0x0197 }
            java.lang.String r2 = "LogisticsCenter has already been loaded, GroupIndex[%d], InterceptorIndex[%d], ProviderIndex[%d]"
            r4 = 3
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ Exception -> 0x0197 }
            java.util.Map<java.lang.String, java.lang.Class<? extends com.aiii.android.arouter.facade.template.e>> r5 = com.aiii.android.arouter.core.C1929b.asV     // Catch:{ Exception -> 0x0197 }
            int r5 = r5.size()     // Catch:{ Exception -> 0x0197 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ Exception -> 0x0197 }
            r4[r3] = r5     // Catch:{ Exception -> 0x0197 }
            r3 = 1
            java.util.Map<java.lang.Integer, java.lang.Class<? extends com.aiii.android.arouter.facade.template.IInterceptor>> r5 = com.aiii.android.arouter.core.C1929b.asZ     // Catch:{ Exception -> 0x0197 }
            int r5 = r5.size()     // Catch:{ Exception -> 0x0197 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ Exception -> 0x0197 }
            r4[r3] = r5     // Catch:{ Exception -> 0x0197 }
            r3 = 2
            java.util.Map<java.lang.String, com.aiii.android.arouter.facade.model.RouteMeta> r5 = com.aiii.android.arouter.core.C1929b.asY     // Catch:{ Exception -> 0x0197 }
            int r5 = r5.size()     // Catch:{ Exception -> 0x0197 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ Exception -> 0x0197 }
            r4[r3] = r5     // Catch:{ Exception -> 0x0197 }
            java.lang.String r1 = java.lang.String.format(r1, r2, r4)     // Catch:{ Exception -> 0x0197 }
            r9.mo10377g(r10, r1)     // Catch:{ Exception -> 0x0197 }
        L_0x0195:
            monitor-exit(r0)
            return
        L_0x0197:
            r9 = move-exception
            com.aiii.android.arouter.b.a r10 = new com.aiii.android.arouter.b.a     // Catch:{ all -> 0x01b8 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x01b8 }
            r1.<init>()     // Catch:{ all -> 0x01b8 }
            java.lang.String r2 = "ARouter::ARouter init logistics center exception! ["
            r1.append(r2)     // Catch:{ all -> 0x01b8 }
            java.lang.String r9 = r9.getMessage()     // Catch:{ all -> 0x01b8 }
            r1.append(r9)     // Catch:{ all -> 0x01b8 }
            java.lang.String r9 = "]"
            r1.append(r9)     // Catch:{ all -> 0x01b8 }
            java.lang.String r9 = r1.toString()     // Catch:{ all -> 0x01b8 }
            r10.<init>(r9)     // Catch:{ all -> 0x01b8 }
            throw r10     // Catch:{ all -> 0x01b8 }
        L_0x01b8:
            r9 = move-exception
            monitor-exit(r0)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.aiii.android.arouter.core.C1927a.m5553a(android.content.Context, java.util.concurrent.ThreadPoolExecutor):void");
    }

    /* renamed from: a */
    private static void m5554a(C1941a aVar, Integer num, String str, String str2) {
        if (!C1940e.isEmpty(str) && !C1940e.isEmpty(str2)) {
            if (num != null) {
                try {
                    if (num.intValue() == C1946b.BOOLEAN.ordinal()) {
                        aVar.mo10391a(str, Boolean.parseBoolean(str2));
                    } else if (num.intValue() == C1946b.BYTE.ordinal()) {
                        aVar.mo10384a(str, Byte.valueOf(str2).byteValue());
                    } else if (num.intValue() == C1946b.SHORT.ordinal()) {
                        aVar.mo10390a(str, Short.valueOf(str2).shortValue());
                    } else if (num.intValue() == C1946b.INT.ordinal()) {
                        aVar.mo10406h(str, Integer.valueOf(str2).intValue());
                    } else if (num.intValue() == C1946b.LONG.ordinal()) {
                        aVar.mo10386a(str, Long.valueOf(str2).longValue());
                    } else if (num.intValue() == C1946b.FLOAT.ordinal()) {
                        aVar.mo10395b(str, Float.valueOf(str2).floatValue());
                    } else if (num.intValue() == C1946b.DOUBLE.ordinal()) {
                        aVar.mo10385a(str, Double.valueOf(str2).doubleValue());
                    } else if (num.intValue() == C1946b.STRING.ordinal()) {
                        aVar.mo10399f(str, str2);
                    } else if (num.intValue() != C1946b.PARCELABLE.ordinal()) {
                        if (num.intValue() == C1946b.OBJECT.ordinal()) {
                            aVar.mo10399f(str, str2);
                        } else {
                            aVar.mo10399f(str, str2);
                        }
                    }
                } catch (Throwable th) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("LogisticsCenter setValue failed! ");
                    sb.append(th.getMessage());
                    C1919a.atC.mo10379j("ARouter::", sb.toString());
                }
            } else {
                aVar.mo10399f(str, str2);
            }
        }
    }

    /* renamed from: ak */
    public static C1941a m5555ak(String str) {
        RouteMeta routeMeta = (RouteMeta) C1929b.asY.get(str);
        if (routeMeta == null) {
            return null;
        }
        return new C1941a(routeMeta.getPath(), routeMeta.getGroup());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x008f, code lost:
        r11 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0090, code lost:
        r2 = new java.lang.StringBuilder();
        r2.append("ARouter::Fatal exception when loading group meta. [");
        r2.append(r11.getMessage());
        r2.append(com.ironsource.sdk.constants.Constants.RequestParameters.RIGHT_BRACKETS);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x00af, code lost:
        throw new com.aiii.android.arouter.p090b.C1916a(r2.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0194, code lost:
        r11 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
        r2 = new java.lang.StringBuilder();
        r2.append("Init provider failed! ");
        r2.append(r11.getMessage());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x01af, code lost:
        throw new com.aiii.android.arouter.p090b.C1916a(r2.toString());
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:8:0x0022, B:38:0x017a] */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void m5556b(com.aiii.android.arouter.facade.C1941a r11) {
        /*
            java.lang.Class<com.aiii.android.arouter.core.a> r0 = com.aiii.android.arouter.core.C1927a.class
            monitor-enter(r0)
            if (r11 == 0) goto L_0x01b8
            java.util.Map<java.lang.String, com.aiii.android.arouter.facade.model.RouteMeta> r1 = com.aiii.android.arouter.core.C1929b.asW     // Catch:{ all -> 0x01c0 }
            java.lang.String r2 = r11.getPath()     // Catch:{ all -> 0x01c0 }
            java.lang.Object r1 = r1.get(r2)     // Catch:{ all -> 0x01c0 }
            com.aiii.android.arouter.facade.model.RouteMeta r1 = (com.aiii.android.arouter.facade.model.RouteMeta) r1     // Catch:{ all -> 0x01c0 }
            r2 = 0
            if (r1 != 0) goto L_0x00dc
            java.util.Map<java.lang.String, java.lang.Class<? extends com.aiii.android.arouter.facade.template.e>> r1 = com.aiii.android.arouter.core.C1929b.asV     // Catch:{ all -> 0x01c0 }
            java.lang.String r3 = r11.getGroup()     // Catch:{ all -> 0x01c0 }
            java.lang.Object r1 = r1.get(r3)     // Catch:{ all -> 0x01c0 }
            java.lang.Class r1 = (java.lang.Class) r1     // Catch:{ all -> 0x01c0 }
            if (r1 == 0) goto L_0x00b0
            boolean r3 = com.aiii.android.arouter.p091c.C1919a.m5531se()     // Catch:{ Exception -> 0x008f }
            r4 = 1
            r5 = 2
            if (r3 == 0) goto L_0x0049
            com.aiii.android.arouter.facade.template.b r3 = com.aiii.android.arouter.p091c.C1919a.atC     // Catch:{ Exception -> 0x008f }
            java.lang.String r6 = "ARouter::"
            java.util.Locale r7 = java.util.Locale.getDefault()     // Catch:{ Exception -> 0x008f }
            java.lang.String r8 = "The group [%s] starts loading, trigger by [%s]"
            java.lang.Object[] r9 = new java.lang.Object[r5]     // Catch:{ Exception -> 0x008f }
            java.lang.String r10 = r11.getGroup()     // Catch:{ Exception -> 0x008f }
            r9[r2] = r10     // Catch:{ Exception -> 0x008f }
            java.lang.String r10 = r11.getPath()     // Catch:{ Exception -> 0x008f }
            r9[r4] = r10     // Catch:{ Exception -> 0x008f }
            java.lang.String r7 = java.lang.String.format(r7, r8, r9)     // Catch:{ Exception -> 0x008f }
            r3.mo10377g(r6, r7)     // Catch:{ Exception -> 0x008f }
        L_0x0049:
            java.lang.Class[] r3 = new java.lang.Class[r2]     // Catch:{ Exception -> 0x008f }
            java.lang.reflect.Constructor r1 = r1.getConstructor(r3)     // Catch:{ Exception -> 0x008f }
            java.lang.Object[] r3 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x008f }
            java.lang.Object r1 = r1.newInstance(r3)     // Catch:{ Exception -> 0x008f }
            com.aiii.android.arouter.facade.template.e r1 = (com.aiii.android.arouter.facade.template.C1951e) r1     // Catch:{ Exception -> 0x008f }
            java.util.Map<java.lang.String, com.aiii.android.arouter.facade.model.RouteMeta> r3 = com.aiii.android.arouter.core.C1929b.asW     // Catch:{ Exception -> 0x008f }
            r1.loadInto(r3)     // Catch:{ Exception -> 0x008f }
            java.util.Map<java.lang.String, java.lang.Class<? extends com.aiii.android.arouter.facade.template.e>> r1 = com.aiii.android.arouter.core.C1929b.asV     // Catch:{ Exception -> 0x008f }
            java.lang.String r3 = r11.getGroup()     // Catch:{ Exception -> 0x008f }
            r1.remove(r3)     // Catch:{ Exception -> 0x008f }
            boolean r1 = com.aiii.android.arouter.p091c.C1919a.m5531se()     // Catch:{ Exception -> 0x008f }
            if (r1 == 0) goto L_0x008a
            com.aiii.android.arouter.facade.template.b r1 = com.aiii.android.arouter.p091c.C1919a.atC     // Catch:{ Exception -> 0x008f }
            java.lang.String r3 = "ARouter::"
            java.util.Locale r6 = java.util.Locale.getDefault()     // Catch:{ Exception -> 0x008f }
            java.lang.String r7 = "The group [%s] has already been loaded, trigger by [%s]"
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ Exception -> 0x008f }
            java.lang.String r8 = r11.getGroup()     // Catch:{ Exception -> 0x008f }
            r5[r2] = r8     // Catch:{ Exception -> 0x008f }
            java.lang.String r2 = r11.getPath()     // Catch:{ Exception -> 0x008f }
            r5[r4] = r2     // Catch:{ Exception -> 0x008f }
            java.lang.String r2 = java.lang.String.format(r6, r7, r5)     // Catch:{ Exception -> 0x008f }
            r1.mo10377g(r3, r2)     // Catch:{ Exception -> 0x008f }
        L_0x008a:
            m5556b(r11)     // Catch:{ all -> 0x01c0 }
            goto L_0x01b6
        L_0x008f:
            r11 = move-exception
            com.aiii.android.arouter.b.a r1 = new com.aiii.android.arouter.b.a     // Catch:{ all -> 0x01c0 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x01c0 }
            r2.<init>()     // Catch:{ all -> 0x01c0 }
            java.lang.String r3 = "ARouter::Fatal exception when loading group meta. ["
            r2.append(r3)     // Catch:{ all -> 0x01c0 }
            java.lang.String r11 = r11.getMessage()     // Catch:{ all -> 0x01c0 }
            r2.append(r11)     // Catch:{ all -> 0x01c0 }
            java.lang.String r11 = "]"
            r2.append(r11)     // Catch:{ all -> 0x01c0 }
            java.lang.String r11 = r2.toString()     // Catch:{ all -> 0x01c0 }
            r1.<init>(r11)     // Catch:{ all -> 0x01c0 }
            throw r1     // Catch:{ all -> 0x01c0 }
        L_0x00b0:
            com.aiii.android.arouter.b.c r1 = new com.aiii.android.arouter.b.c     // Catch:{ all -> 0x01c0 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x01c0 }
            r2.<init>()     // Catch:{ all -> 0x01c0 }
            java.lang.String r3 = "ARouter::There is no route match the path ["
            r2.append(r3)     // Catch:{ all -> 0x01c0 }
            java.lang.String r3 = r11.getPath()     // Catch:{ all -> 0x01c0 }
            r2.append(r3)     // Catch:{ all -> 0x01c0 }
            java.lang.String r3 = "], in group ["
            r2.append(r3)     // Catch:{ all -> 0x01c0 }
            java.lang.String r11 = r11.getGroup()     // Catch:{ all -> 0x01c0 }
            r2.append(r11)     // Catch:{ all -> 0x01c0 }
            java.lang.String r11 = "]"
            r2.append(r11)     // Catch:{ all -> 0x01c0 }
            java.lang.String r11 = r2.toString()     // Catch:{ all -> 0x01c0 }
            r1.<init>(r11)     // Catch:{ all -> 0x01c0 }
            throw r1     // Catch:{ all -> 0x01c0 }
        L_0x00dc:
            java.lang.Class r3 = r1.getDestination()     // Catch:{ all -> 0x01c0 }
            r11.setDestination(r3)     // Catch:{ all -> 0x01c0 }
            com.aiii.android.arouter.facade.c.a r3 = r1.getType()     // Catch:{ all -> 0x01c0 }
            r11.setType(r3)     // Catch:{ all -> 0x01c0 }
            int r3 = r1.getPriority()     // Catch:{ all -> 0x01c0 }
            r11.setPriority(r3)     // Catch:{ all -> 0x01c0 }
            int r3 = r1.getExtra()     // Catch:{ all -> 0x01c0 }
            r11.setExtra(r3)     // Catch:{ all -> 0x01c0 }
            android.net.Uri r3 = r11.getUri()     // Catch:{ all -> 0x01c0 }
            if (r3 == 0) goto L_0x0158
            java.util.Map r4 = com.aiii.android.arouter.p093e.C1940e.m5578d(r3)     // Catch:{ all -> 0x01c0 }
            java.util.Map r5 = r1.getParamsType()     // Catch:{ all -> 0x01c0 }
            boolean r6 = com.aiii.android.arouter.p093e.C1938c.m5572b(r5)     // Catch:{ all -> 0x01c0 }
            if (r6 == 0) goto L_0x014f
            java.util.Set r6 = r5.entrySet()     // Catch:{ all -> 0x01c0 }
            java.util.Iterator r6 = r6.iterator()     // Catch:{ all -> 0x01c0 }
        L_0x0114:
            boolean r7 = r6.hasNext()     // Catch:{ all -> 0x01c0 }
            if (r7 == 0) goto L_0x013a
            java.lang.Object r7 = r6.next()     // Catch:{ all -> 0x01c0 }
            java.util.Map$Entry r7 = (java.util.Map.Entry) r7     // Catch:{ all -> 0x01c0 }
            java.lang.Object r8 = r7.getValue()     // Catch:{ all -> 0x01c0 }
            java.lang.Integer r8 = (java.lang.Integer) r8     // Catch:{ all -> 0x01c0 }
            java.lang.Object r9 = r7.getKey()     // Catch:{ all -> 0x01c0 }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ all -> 0x01c0 }
            java.lang.Object r7 = r7.getKey()     // Catch:{ all -> 0x01c0 }
            java.lang.Object r7 = r4.get(r7)     // Catch:{ all -> 0x01c0 }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ all -> 0x01c0 }
            m5554a(r11, r8, r9, r7)     // Catch:{ all -> 0x01c0 }
            goto L_0x0114
        L_0x013a:
            android.os.Bundle r4 = r11.getExtras()     // Catch:{ all -> 0x01c0 }
            java.lang.String r6 = "wmHzgD4lOj5o4241"
            java.util.Set r5 = r5.keySet()     // Catch:{ all -> 0x01c0 }
            java.lang.String[] r7 = new java.lang.String[r2]     // Catch:{ all -> 0x01c0 }
            java.lang.Object[] r5 = r5.toArray(r7)     // Catch:{ all -> 0x01c0 }
            java.lang.String[] r5 = (java.lang.String[]) r5     // Catch:{ all -> 0x01c0 }
            r4.putStringArray(r6, r5)     // Catch:{ all -> 0x01c0 }
        L_0x014f:
            java.lang.String r4 = "NTeRQWvye18AkPd6G"
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x01c0 }
            r11.mo10399f(r4, r3)     // Catch:{ all -> 0x01c0 }
        L_0x0158:
            int[] r3 = com.aiii.android.arouter.core.C1927a.C19281.asU     // Catch:{ all -> 0x01c0 }
            com.aiii.android.arouter.facade.c.a r4 = r1.getType()     // Catch:{ all -> 0x01c0 }
            int r4 = r4.ordinal()     // Catch:{ all -> 0x01c0 }
            r3 = r3[r4]     // Catch:{ all -> 0x01c0 }
            switch(r3) {
                case 1: goto L_0x016c;
                case 2: goto L_0x0168;
                default: goto L_0x0167;
            }     // Catch:{ all -> 0x01c0 }
        L_0x0167:
            goto L_0x01b6
        L_0x0168:
            r11.mo10413rY()     // Catch:{ all -> 0x01c0 }
            goto L_0x01b6
        L_0x016c:
            java.lang.Class r1 = r1.getDestination()     // Catch:{ all -> 0x01c0 }
            java.util.Map<java.lang.Class, com.aiii.android.arouter.facade.template.c> r3 = com.aiii.android.arouter.core.C1929b.asX     // Catch:{ all -> 0x01c0 }
            java.lang.Object r3 = r3.get(r1)     // Catch:{ all -> 0x01c0 }
            com.aiii.android.arouter.facade.template.c r3 = (com.aiii.android.arouter.facade.template.C1949c) r3     // Catch:{ all -> 0x01c0 }
            if (r3 != 0) goto L_0x01b0
            java.lang.Class[] r3 = new java.lang.Class[r2]     // Catch:{ Exception -> 0x0194 }
            java.lang.reflect.Constructor r3 = r1.getConstructor(r3)     // Catch:{ Exception -> 0x0194 }
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x0194 }
            java.lang.Object r2 = r3.newInstance(r2)     // Catch:{ Exception -> 0x0194 }
            r3 = r2
            com.aiii.android.arouter.facade.template.c r3 = (com.aiii.android.arouter.facade.template.C1949c) r3     // Catch:{ Exception -> 0x0194 }
            android.content.Context r2 = mContext     // Catch:{ Exception -> 0x0194 }
            r3.init(r2)     // Catch:{ Exception -> 0x0194 }
            java.util.Map<java.lang.Class, com.aiii.android.arouter.facade.template.c> r2 = com.aiii.android.arouter.core.C1929b.asX     // Catch:{ Exception -> 0x0194 }
            r2.put(r1, r3)     // Catch:{ Exception -> 0x0194 }
            goto L_0x01b0
        L_0x0194:
            r11 = move-exception
            com.aiii.android.arouter.b.a r1 = new com.aiii.android.arouter.b.a     // Catch:{ all -> 0x01c0 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x01c0 }
            r2.<init>()     // Catch:{ all -> 0x01c0 }
            java.lang.String r3 = "Init provider failed! "
            r2.append(r3)     // Catch:{ all -> 0x01c0 }
            java.lang.String r11 = r11.getMessage()     // Catch:{ all -> 0x01c0 }
            r2.append(r11)     // Catch:{ all -> 0x01c0 }
            java.lang.String r11 = r2.toString()     // Catch:{ all -> 0x01c0 }
            r1.<init>(r11)     // Catch:{ all -> 0x01c0 }
            throw r1     // Catch:{ all -> 0x01c0 }
        L_0x01b0:
            r11.mo10383a(r3)     // Catch:{ all -> 0x01c0 }
            r11.mo10413rY()     // Catch:{ all -> 0x01c0 }
        L_0x01b6:
            monitor-exit(r0)
            return
        L_0x01b8:
            com.aiii.android.arouter.b.c r11 = new com.aiii.android.arouter.b.c     // Catch:{ all -> 0x01c0 }
            java.lang.String r1 = "ARouter::No postcard!"
            r11.<init>(r1)     // Catch:{ all -> 0x01c0 }
            throw r11     // Catch:{ all -> 0x01c0 }
        L_0x01c0:
            r11 = move-exception
            monitor-exit(r0)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.aiii.android.arouter.core.C1927a.m5556b(com.aiii.android.arouter.facade.a):void");
    }

    /* renamed from: rR */
    private static void m5557rR() {
        asT = false;
    }
}
