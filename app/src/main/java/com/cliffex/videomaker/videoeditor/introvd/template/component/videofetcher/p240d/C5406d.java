package com.introvd.template.component.videofetcher.p240d;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

/* renamed from: com.introvd.template.component.videofetcher.d.d */
public class C5406d implements OnTouchListener {
    private C5407a ckA;
    private long ckx = 0;
    private long cky = 0;
    private final int ckz = 1000;
    private int count = 0;

    /* renamed from: com.introvd.template.component.videofetcher.d.d$a */
    public interface C5407a {
        void aad();
    }

    public C5406d(C5407a aVar) {
        this.ckA = aVar;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.count++;
            if (1 == this.count) {
                this.ckx = System.currentTimeMillis();
            } else if (2 == this.count) {
                this.cky = System.currentTimeMillis();
                if (this.cky - this.ckx < 1000) {
                    if (this.ckA != null) {
                        this.ckA.aad();
                    }
                    this.count = 0;
                    this.ckx = 0;
                } else {
                    this.ckx = this.cky;
                    this.count = 1;
                }
                this.cky = 0;
            }
        }
        return true;
    }
}
