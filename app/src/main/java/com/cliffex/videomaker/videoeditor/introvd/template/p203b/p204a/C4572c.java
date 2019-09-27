package com.introvd.template.p203b.p204a;

import android.view.View;

/* renamed from: com.introvd.template.b.a.c */
class C4572c {
    private final int[] bLr;
    private final int bLs;
    private final int bLt;

    public C4572c(int i, int i2) {
        this.bLs = 0;
        this.bLt = 0;
        this.bLr = new int[]{i, i2};
    }

    public C4572c(View view, int i, int i2) {
        if (view != null) {
            this.bLr = new int[2];
            view.getLocationInWindow(this.bLr);
            this.bLs = i;
            this.bLt = i2;
            return;
        }
        throw new IllegalArgumentException("anchorView can't be null");
    }

    public int getX() {
        return this.bLr[0] + this.bLs;
    }

    public int getY() {
        return this.bLr[1] + this.bLt;
    }
}
