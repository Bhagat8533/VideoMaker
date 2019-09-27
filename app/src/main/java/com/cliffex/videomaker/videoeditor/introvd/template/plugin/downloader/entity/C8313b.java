package com.introvd.template.plugin.downloader.entity;

/* renamed from: com.introvd.template.plugin.downloader.entity.b */
public class C8313b {
    /* access modifiers changed from: private */
    public String eaq;
    /* access modifiers changed from: private */
    public String ear;
    /* access modifiers changed from: private */
    public String url;

    /* renamed from: com.introvd.template.plugin.downloader.entity.b$a */
    public static class C8314a {
        private String eaq;
        private String ear;
        private String url;

        public C8314a(String str) {
            this.url = str;
        }

        public C8313b aGh() {
            C8313b bVar = new C8313b();
            bVar.url = this.url;
            bVar.eaq = this.eaq;
            bVar.ear = this.ear;
            return bVar;
        }

        /* renamed from: nm */
        public C8314a mo33519nm(String str) {
            this.eaq = str;
            return this;
        }

        /* renamed from: nn */
        public C8314a mo33520nn(String str) {
            this.ear = str;
            return this;
        }
    }

    public String aGf() {
        return this.eaq;
    }

    public String aGg() {
        return this.ear;
    }

    public String getUrl() {
        return this.url;
    }

    /* renamed from: nk */
    public void mo33516nk(String str) {
        this.eaq = str;
    }

    /* renamed from: nl */
    public void mo33517nl(String str) {
        this.ear = str;
    }
}
