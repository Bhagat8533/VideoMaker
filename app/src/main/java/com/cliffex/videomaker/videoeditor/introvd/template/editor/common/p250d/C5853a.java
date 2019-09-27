package com.introvd.template.editor.common.p250d;

import java.util.HashMap;
import java.util.Map;

/* renamed from: com.introvd.template.editor.common.d.a */
public class C5853a {
    private Map<String, String> cFx;
    private boolean cFy;

    /* renamed from: com.introvd.template.editor.common.d.a$a */
    public static final class C5855a {
        /* access modifiers changed from: private */
        public boolean cFy;

        public C5853a ahJ() {
            return new C5853a(this);
        }

        /* renamed from: fa */
        public C5855a mo28254fa(boolean z) {
            this.cFy = z;
            return this;
        }
    }

    private C5853a(C5855a aVar) {
        this.cFx = new HashMap();
        this.cFy = aVar.cFy;
    }

    public boolean ahI() {
        return this.cFy;
    }
}
