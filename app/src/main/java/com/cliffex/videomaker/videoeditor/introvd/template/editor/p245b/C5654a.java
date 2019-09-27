package com.introvd.template.editor.p245b;

import com.introvd.template.module.iap.C8049f;
import com.introvd.template.module.iap.C8072q;
import com.introvd.template.module.iap.business.p349a.C7825a;
import com.introvd.template.template.p407e.C8739i;

/* renamed from: com.introvd.template.editor.b.a */
class C5654a {
    private final long cFE;
    private final long cFF;
    private boolean cFG;
    private boolean cFH;

    C5654a(long j, long j2) {
        this.cFE = j;
        this.cFF = j2;
        init();
    }

    private void init() {
        boolean z = true;
        this.cFG = 300000 < this.cFF && !C8072q.aBx().mo33072ku(C7825a.DURATION_LIMIT.getId());
        if (this.cFG || C8049f.aBf().aBr() || this.cFE <= 0 || !C8739i.m25529u(Long.valueOf(this.cFE)) || C8072q.aBx().mo33072ku(C7825a.ALL_TEMPLATE.getId())) {
            z = false;
        }
        this.cFH = z;
    }

    /* access modifiers changed from: 0000 */
    public boolean ahN() {
        return this.cFG;
    }

    /* access modifiers changed from: 0000 */
    public boolean ahO() {
        return this.cFH;
    }
}
