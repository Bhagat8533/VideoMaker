package com.introvd.template.plugin.downloader.entity;

/* renamed from: com.introvd.template.plugin.downloader.entity.a */
public class C8312a {
    private DownloadStatus eao = new DownloadStatus();
    private Throwable eap;
    private int flag = 9990;
    private String name;
    private String path;
    private String url;

    public DownloadStatus aGe() {
        return this.eao;
    }

    /* renamed from: b */
    public void mo33503b(DownloadStatus downloadStatus) {
        this.eao = downloadStatus;
    }

    public int getFlag() {
        return this.flag;
    }

    public String getName() {
        return this.name;
    }

    public String getPath() {
        return this.path;
    }

    public String getUrl() {
        return this.url;
    }

    public void setError(Throwable th) {
        this.eap = th;
    }

    public void setFlag(int i) {
        this.flag = i;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setPath(String str) {
        this.path = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }
}
