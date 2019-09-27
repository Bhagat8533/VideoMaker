package com.introvd.template.p173a.p174a;

import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* renamed from: com.introvd.template.a.a.b */
public class C3572b implements FrameCallback {
    private long bKu = 0;
    private C3573c bKv;
    private final long bKw = 736;
    private List<Long> bKx;
    private int step = 0;

    public C3572b(C3573c cVar) {
        this.bKv = cVar;
        this.bKx = new ArrayList();
    }

    /* renamed from: RX */
    private long m8786RX() {
        return TimeUnit.NANOSECONDS.convert(736, TimeUnit.MILLISECONDS);
    }

    /* renamed from: S */
    private boolean m8787S(long j) {
        return j - this.bKu > m8786RX();
    }

    /* renamed from: T */
    private void m8788T(long j) {
        this.bKx.clear();
        this.bKu = j;
    }

    public void doFrame(long j) {
        if (this.bKu == 0) {
            this.bKu = j;
        } else if (this.bKv != null) {
            this.bKv.mo22853e(((Long) this.bKx.get(this.bKx.size() - 1)).longValue(), j);
        }
        if (m8787S(j)) {
            m8788T(j);
        }
        this.bKx.add(Long.valueOf(j));
        if (this.step == 0) {
            Choreographer.getInstance().postFrameCallback(this);
            this.step = 1;
        }
    }
}
