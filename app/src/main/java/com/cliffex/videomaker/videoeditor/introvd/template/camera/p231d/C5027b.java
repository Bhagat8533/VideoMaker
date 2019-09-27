package com.introvd.template.camera.p231d;

import java.io.Serializable;

/* renamed from: com.introvd.template.camera.d.b */
public class C5027b implements Serializable {
    private String tcid;
    private String ttid;
    private String url;

    /* renamed from: com.introvd.template.camera.d.b$a */
    static class C5028a {
        /* access modifiers changed from: private */
        public String tcid;
        /* access modifiers changed from: private */
        public String ttid;
        /* access modifiers changed from: private */
        public String url;

        C5028a() {
        }

        /* renamed from: WS */
        public C5027b mo25882WS() {
            return new C5027b(this);
        }

        /* renamed from: eY */
        public C5028a mo25883eY(String str) {
            this.ttid = str;
            return this;
        }

        /* renamed from: eZ */
        public C5028a mo25884eZ(String str) {
            this.tcid = str;
            return this;
        }

        /* renamed from: fa */
        public C5028a mo25885fa(String str) {
            this.url = str;
            return this;
        }
    }

    public C5027b(C5028a aVar) {
        this.ttid = aVar.ttid;
        this.tcid = aVar.tcid;
        this.url = aVar.url;
    }

    /* renamed from: WR */
    public String mo25879WR() {
        return this.tcid;
    }

    public String getTtid() {
        return this.ttid;
    }

    public String getUrl() {
        return this.url;
    }
}
