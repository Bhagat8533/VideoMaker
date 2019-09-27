package com.introvd.template.p203b;

import com.introvd.template.common.LogUtils;
import java.util.concurrent.TimeUnit;
import p037b.p050b.C1834l;
import p037b.p050b.C1840o;
import p037b.p050b.p057e.C1518f;

/* renamed from: com.introvd.template.b.m */
public class C4602m implements C1518f<C1834l<? extends Throwable>, C1834l<?>> {
    /* access modifiers changed from: private */
    public final int bcK;
    /* access modifiers changed from: private */
    public final int bcN;
    /* access modifiers changed from: private */
    public int retryCount;

    public C4602m(int i, int i2) {
        this.bcN = i;
        this.bcK = i2;
    }

    /* renamed from: a */
    static /* synthetic */ int m11741a(C4602m mVar) {
        int i = mVar.retryCount + 1;
        mVar.retryCount = i;
        return i;
    }

    /* renamed from: b */
    public C1834l<?> apply(C1834l<? extends Throwable> lVar) {
        return lVar.mo10162e((C1518f<? super T, ? extends C1840o<? extends R>>) new C1518f<Throwable, C1834l<?>>() {
            /* renamed from: o */
            public C1834l<?> apply(Throwable th) {
                if (C4602m.m11741a(C4602m.this) > C4602m.this.bcN) {
                    return C1834l.m5263w(th);
                }
                StringBuilder sb = new StringBuilder();
                sb.append("Get Error, it will try after ");
                sb.append(C4602m.this.bcK);
                sb.append(" millisecond, retry count ");
                sb.append(C4602m.this.retryCount);
                LogUtils.m14222e("RetryWithDelay", sb.toString());
                return C1834l.m5261d((long) C4602m.this.bcK, TimeUnit.MILLISECONDS);
            }
        });
    }
}
