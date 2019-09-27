package com.cliffex.videomaker.videoeditor.aiii.android.arouter.p092d;

import java.util.concurrent.CountDownLatch;

/* renamed from: com.aiii.android.arouter.d.a */
public class C1930a extends CountDownLatch {
    public C1930a(int i) {
        super(i);
    }

    public void cancel() {
        while (getCount() > 0) {
            countDown();
        }
    }
}
