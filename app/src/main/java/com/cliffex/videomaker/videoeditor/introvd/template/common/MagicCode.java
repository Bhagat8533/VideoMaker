package com.introvd.template.common;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class MagicCode {
    private static Map<Long, Map<String, Object>> ccu = Collections.synchronizedMap(new LinkedHashMap());
    private static Map<Long, Long> ccv = Collections.synchronizedMap(new LinkedHashMap());

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0038, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003a, code lost:
        return;
     */
    /* renamed from: ap */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static synchronized void m14242ap(long r5) {
        /*
            java.lang.Class<com.introvd.template.common.MagicCode> r0 = com.introvd.template.common.MagicCode.class
            monitor-enter(r0)
            java.util.Map<java.lang.Long, java.lang.Long> r1 = ccv     // Catch:{ all -> 0x003b }
            java.util.Set r1 = r1.keySet()     // Catch:{ all -> 0x003b }
            if (r1 == 0) goto L_0x0039
            boolean r2 = r1.isEmpty()     // Catch:{ all -> 0x003b }
            if (r2 == 0) goto L_0x0012
            goto L_0x0039
        L_0x0012:
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x003b }
        L_0x0016:
            boolean r2 = r1.hasNext()     // Catch:{ all -> 0x003b }
            if (r2 == 0) goto L_0x0037
            java.lang.Object r2 = r1.next()     // Catch:{ all -> 0x003b }
            java.lang.Long r2 = (java.lang.Long) r2     // Catch:{ all -> 0x003b }
            java.util.Map<java.lang.Long, java.lang.Long> r3 = ccv     // Catch:{ all -> 0x003b }
            java.lang.Object r3 = r3.get(r2)     // Catch:{ all -> 0x003b }
            java.lang.Long r3 = (java.lang.Long) r3     // Catch:{ all -> 0x003b }
            long r3 = r3.longValue()     // Catch:{ all -> 0x003b }
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 != 0) goto L_0x0016
            java.util.Map<java.lang.Long, java.lang.Long> r5 = ccv     // Catch:{ all -> 0x003b }
            r5.remove(r2)     // Catch:{ all -> 0x003b }
        L_0x0037:
            monitor-exit(r0)
            return
        L_0x0039:
            monitor-exit(r0)
            return
        L_0x003b:
            r5 = move-exception
            monitor-exit(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.common.MagicCode.m14242ap(long):void");
    }

    /* renamed from: aq */
    private static synchronized long m14243aq(long j) {
        synchronized (MagicCode.class) {
            if (ccu.get(Long.valueOf(j)) != null) {
                return j;
            }
            Long l = (Long) ccv.get(Long.valueOf(j));
            if (l == null) {
                return -1;
            }
            long longValue = l.longValue();
            return longValue;
        }
    }

    public static int getCount() {
        return ccu.size();
    }

    public static Object getMagicParam(long j, String str, Object obj) {
        if (str == null) {
            return obj;
        }
        Map map = (Map) ccu.get(Long.valueOf(m14243aq(j)));
        if (map == null) {
            return obj;
        }
        Object obj2 = map.get(str);
        if (obj2 == null) {
            obj2 = obj;
        }
        return obj2;
    }

    public static long register(long j) {
        if (ccu.get(Long.valueOf(j)) == null) {
            ccu.put(Long.valueOf(j), new LinkedHashMap());
            setAlias(j, j);
        }
        return j;
    }

    public static synchronized void setAlias(long j, long j2) {
        synchronized (MagicCode.class) {
            m14242ap(j);
            ccv.put(Long.valueOf(j2), Long.valueOf(j));
        }
    }

    public static void setMagicParam(long j, String str, Object obj) {
        if (str != null && obj != null) {
            Map map = (Map) ccu.get(Long.valueOf(m14243aq(j)));
            if (map != null) {
                map.put(str, obj);
            }
        }
    }

    public static void unregister(long j) {
        ccu.remove(Long.valueOf(j));
        m14242ap(j);
    }
}
