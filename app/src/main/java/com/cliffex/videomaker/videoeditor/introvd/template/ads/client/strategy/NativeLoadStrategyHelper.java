package com.introvd.template.ads.client.strategy;

import android.os.Handler;
import android.os.Message;
import android.util.SparseArray;
import com.introvd.template.ads.AdParamMgr;
import com.introvd.template.ads.entity.AdPositionInfoParam;
import com.introvd.template.ads.listener.BaseAdListener;
import com.introvd.template.ads.utils.VivaAdLog;
import com.introvd.template.router.iap.IapRTConstants;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;

public class NativeLoadStrategyHelper {
    private static final String TAG = "NativeLoadStrategyHelper";
    private final int bgQ;
    private volatile boolean bgR = false;
    private boolean bgS = false;
    private LinkedList<Integer> bgT;
    private SparseArray<AdLoadedMessageInfo> bgU;
    private BaseAdListener bgV;
    private final Handler handler;

    public static class AdLoadedMessageInfo {
        final AdPositionInfoParam bgW;
        final String message;
        final boolean success;

        public AdLoadedMessageInfo(AdPositionInfoParam adPositionInfoParam, boolean z, String str) {
            this.bgW = adPositionInfoParam;
            this.success = z;
            this.message = str;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: Gz */
        public int mo22927Gz() {
            if (this.bgW != null) {
                return this.bgW.providerOrder;
            }
            return -1;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("AdLoadedMessageInfo{param=");
            sb.append(this.bgW);
            sb.append(", success=");
            sb.append(this.success);
            sb.append(", message='");
            sb.append(this.message);
            sb.append('\'');
            sb.append('}');
            return sb.toString();
        }
    }

    /* renamed from: com.introvd.template.ads.client.strategy.NativeLoadStrategyHelper$a */
    private static class C3610a extends Handler {
        private WeakReference<NativeLoadStrategyHelper> bgX;

        C3610a(NativeLoadStrategyHelper nativeLoadStrategyHelper) {
            this.bgX = new WeakReference<>(nativeLoadStrategyHelper);
        }

        public void handleMessage(Message message) {
            NativeLoadStrategyHelper nativeLoadStrategyHelper = (NativeLoadStrategyHelper) this.bgX.get();
            if (nativeLoadStrategyHelper != null && message.what == 9527) {
                nativeLoadStrategyHelper.m8834Gw();
            }
        }
    }

    public NativeLoadStrategyHelper(int i, BaseAdListener baseAdListener) {
        this.bgQ = i;
        this.handler = new C3610a(this);
        setViewAdsListener(baseAdListener);
    }

    /* renamed from: Gv */
    private SparseArray<AdLoadedMessageInfo> m8833Gv() {
        if (this.bgU == null) {
            this.bgU = new SparseArray<>();
        } else {
            this.bgU.clear();
        }
        return this.bgU;
    }

    /* access modifiers changed from: private */
    /* renamed from: Gw */
    public void m8834Gw() {
        AdLoadedMessageInfo adLoadedMessageInfo;
        if (this.bgT.isEmpty()) {
            m8837a(m8835Gx());
            return;
        }
        Iterator it = this.bgT.iterator();
        while (true) {
            if (!it.hasNext()) {
                adLoadedMessageInfo = null;
                break;
            }
            adLoadedMessageInfo = (AdLoadedMessageInfo) this.bgU.get(((Integer) it.next()).intValue());
            if (adLoadedMessageInfo != null && adLoadedMessageInfo.success) {
                break;
            }
        }
        if (adLoadedMessageInfo == null) {
            adLoadedMessageInfo = m8835Gx();
        }
        String str = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("mock inform:");
        sb.append(adLoadedMessageInfo.toString());
        VivaAdLog.m8847e(str, sb.toString());
        m8837a(adLoadedMessageInfo);
    }

    /* renamed from: Gx */
    private AdLoadedMessageInfo m8835Gx() {
        return new AdLoadedMessageInfo(new AdPositionInfoParam(-1, this.bgQ), false, "null ad arrived");
    }

    /* renamed from: Gy */
    private void m8836Gy() {
        this.handler.removeMessages(IapRTConstants.REQUEST_CODE_FOR_VIP);
        this.bgR = true;
        if (this.bgT != null) {
            this.bgT.clear();
            this.bgT = null;
        }
    }

    /* renamed from: a */
    private synchronized void m8837a(AdLoadedMessageInfo adLoadedMessageInfo) {
        if (adLoadedMessageInfo == null) {
            VivaAdLog.m8847e(TAG, "final inform error: true");
            return;
        }
        String str = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("final inform:");
        sb.append(adLoadedMessageInfo.toString());
        VivaAdLog.m8847e(str, sb.toString());
        m8839b(adLoadedMessageInfo);
        m8836Gy();
    }

    /* renamed from: b */
    private void m8839b(AdLoadedMessageInfo adLoadedMessageInfo) {
        if (adLoadedMessageInfo != null && this.bgV != null) {
            this.bgV.onAdLoaded(adLoadedMessageInfo.bgW, adLoadedMessageInfo.success, adLoadedMessageInfo.message);
        }
    }

    /* renamed from: gf */
    private void m8840gf(int i) {
        this.handler.sendMessageDelayed(this.handler.obtainMessage(IapRTConstants.REQUEST_CODE_FOR_VIP), AdParamMgr.getWaitTime(i));
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:35:0x0090=Splitter:B:35:0x0090, B:13:0x0018=Splitter:B:13:0x0018} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void informLoadedRequest(com.introvd.template.ads.client.strategy.NativeLoadStrategyHelper.AdLoadedMessageInfo r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            if (r6 == 0) goto L_0x0090
            boolean r0 = r5.isFinishedRequest()     // Catch:{ all -> 0x008e }
            if (r0 == 0) goto L_0x000b
            goto L_0x0090
        L_0x000b:
            boolean r0 = r5.bgS     // Catch:{ all -> 0x008e }
            if (r0 != 0) goto L_0x0018
            boolean r0 = r6.success     // Catch:{ all -> 0x008e }
            if (r0 == 0) goto L_0x0018
            r5.m8837a(r6)     // Catch:{ all -> 0x008e }
            monitor-exit(r5)
            return
        L_0x0018:
            int r0 = r6.mo22927Gz()     // Catch:{ all -> 0x008e }
            java.util.LinkedList<java.lang.Integer> r1 = r5.bgT     // Catch:{ all -> 0x008e }
            java.lang.Object r1 = r1.peek()     // Catch:{ all -> 0x008e }
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch:{ all -> 0x008e }
            int r1 = r1.intValue()     // Catch:{ all -> 0x008e }
            java.lang.String r2 = TAG     // Catch:{ all -> 0x008e }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x008e }
            r3.<init>()     // Catch:{ all -> 0x008e }
            java.lang.String r4 = "inform:"
            r3.append(r4)     // Catch:{ all -> 0x008e }
            java.lang.String r4 = r6.toString()     // Catch:{ all -> 0x008e }
            r3.append(r4)     // Catch:{ all -> 0x008e }
            java.lang.String r4 = ",currentProvider"
            r3.append(r4)     // Catch:{ all -> 0x008e }
            r3.append(r1)     // Catch:{ all -> 0x008e }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x008e }
            com.introvd.template.ads.utils.VivaAdLog.m8847e(r2, r3)     // Catch:{ all -> 0x008e }
            if (r1 == r0) goto L_0x0053
            android.util.SparseArray<com.introvd.template.ads.client.strategy.NativeLoadStrategyHelper$AdLoadedMessageInfo> r1 = r5.bgU     // Catch:{ all -> 0x008e }
            r1.put(r0, r6)     // Catch:{ all -> 0x008e }
            monitor-exit(r5)
            return
        L_0x0053:
            java.util.LinkedList<java.lang.Integer> r0 = r5.bgT     // Catch:{ all -> 0x008e }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x008e }
            int r0 = r0.indexOf(r1)     // Catch:{ all -> 0x008e }
            java.util.LinkedList<java.lang.Integer> r1 = r5.bgT     // Catch:{ all -> 0x008e }
            r1.remove(r0)     // Catch:{ all -> 0x008e }
            boolean r0 = r6.success     // Catch:{ all -> 0x008e }
            if (r0 == 0) goto L_0x006b
            r5.m8837a(r6)     // Catch:{ all -> 0x008e }
            monitor-exit(r5)
            return
        L_0x006b:
            java.util.LinkedList<java.lang.Integer> r6 = r5.bgT     // Catch:{ all -> 0x008e }
            boolean r6 = r6.isEmpty()     // Catch:{ all -> 0x008e }
            if (r6 == 0) goto L_0x0075
            monitor-exit(r5)
            return
        L_0x0075:
            android.util.SparseArray<com.introvd.template.ads.client.strategy.NativeLoadStrategyHelper$AdLoadedMessageInfo> r6 = r5.bgU     // Catch:{ all -> 0x008e }
            java.util.LinkedList<java.lang.Integer> r0 = r5.bgT     // Catch:{ all -> 0x008e }
            java.lang.Object r0 = r0.peek()     // Catch:{ all -> 0x008e }
            java.lang.Integer r0 = (java.lang.Integer) r0     // Catch:{ all -> 0x008e }
            int r0 = r0.intValue()     // Catch:{ all -> 0x008e }
            java.lang.Object r6 = r6.get(r0)     // Catch:{ all -> 0x008e }
            com.introvd.template.ads.client.strategy.NativeLoadStrategyHelper$AdLoadedMessageInfo r6 = (com.introvd.template.ads.client.strategy.NativeLoadStrategyHelper.AdLoadedMessageInfo) r6     // Catch:{ all -> 0x008e }
            r5.informLoadedRequest(r6)     // Catch:{ all -> 0x008e }
            monitor-exit(r5)
            return
        L_0x008e:
            r6 = move-exception
            goto L_0x00c1
        L_0x0090:
            java.lang.String r0 = TAG     // Catch:{ all -> 0x008e }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x008e }
            r1.<init>()     // Catch:{ all -> 0x008e }
            java.lang.String r2 = "inform error:"
            r1.append(r2)     // Catch:{ all -> 0x008e }
            if (r6 != 0) goto L_0x00a0
            r6 = 1
            goto L_0x00a1
        L_0x00a0:
            r6 = 0
        L_0x00a1:
            java.lang.String r6 = java.lang.String.valueOf(r6)     // Catch:{ all -> 0x008e }
            r1.append(r6)     // Catch:{ all -> 0x008e }
            java.lang.String r6 = "/"
            r1.append(r6)     // Catch:{ all -> 0x008e }
            boolean r6 = r5.isFinishedRequest()     // Catch:{ all -> 0x008e }
            java.lang.String r6 = java.lang.String.valueOf(r6)     // Catch:{ all -> 0x008e }
            r1.append(r6)     // Catch:{ all -> 0x008e }
            java.lang.String r6 = r1.toString()     // Catch:{ all -> 0x008e }
            com.introvd.template.ads.utils.VivaAdLog.m8847e(r0, r6)     // Catch:{ all -> 0x008e }
            monitor-exit(r5)
            return
        L_0x00c1:
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.ads.client.strategy.NativeLoadStrategyHelper.informLoadedRequest(com.introvd.template.ads.client.strategy.NativeLoadStrategyHelper$AdLoadedMessageInfo):void");
    }

    public void initNewRequest() {
        boolean z = false;
        this.bgR = false;
        this.bgT = new LinkedList<>(AdParamMgr.getProviderList(this.bgQ));
        this.bgU = m8833Gv();
        if (this.bgT.size() > 1 && AdParamMgr.getWaitTime(this.bgQ) > 0) {
            z = true;
        }
        this.bgS = z;
        if (this.bgS) {
            m8840gf(this.bgQ);
        }
    }

    public boolean isFinishedRequest() {
        return this.bgR || this.bgT == null || this.bgT.isEmpty();
    }

    public void setViewAdsListener(BaseAdListener baseAdListener) {
        this.bgV = baseAdListener;
    }
}
