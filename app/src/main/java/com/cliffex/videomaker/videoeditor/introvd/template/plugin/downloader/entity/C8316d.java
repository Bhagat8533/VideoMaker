package com.introvd.template.plugin.downloader.entity;

/* renamed from: com.introvd.template.plugin.downloader.entity.d */
public class C8316d {
    public long end;
    public long size;
    public long start;

    public C8316d(long j, long j2) {
        this.start = j;
        this.end = j2;
        this.size = (j2 - j) + 1;
    }

    public boolean aGi() {
        return this.start <= this.end;
    }
}
