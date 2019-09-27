package com.introvd.template.plugin.downloader.entity;

/* renamed from: com.introvd.template.plugin.downloader.entity.e */
public class C8317e {
    private long date;
    private String eaq;
    private String ear;
    private DownloadStatus eau;
    private int flag = 9990;

    /* renamed from: id */
    private int f3570id = -1;
    private String url;

    public String aGf() {
        return this.eaq;
    }

    public String aGg() {
        return this.ear;
    }

    public DownloadStatus aGj() {
        return this.eau;
    }

    /* renamed from: c */
    public void mo33535c(DownloadStatus downloadStatus) {
        this.eau = downloadStatus;
    }

    public int getFlag() {
        return this.flag;
    }

    /* renamed from: nk */
    public void mo33537nk(String str) {
        this.eaq = str;
    }

    /* renamed from: nl */
    public void mo33538nl(String str) {
        this.ear = str;
    }

    public void setDate(long j) {
        this.date = j;
    }

    public void setFlag(int i) {
        this.flag = i;
    }

    public void setId(int i) {
        this.f3570id = i;
    }

    public void setUrl(String str) {
        this.url = str;
    }
}
