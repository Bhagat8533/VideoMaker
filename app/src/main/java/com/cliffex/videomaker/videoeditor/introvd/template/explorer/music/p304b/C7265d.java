package com.introvd.template.explorer.music.p304b;

import com.introvd.template.router.explorer.MusicDataItem;

/* renamed from: com.introvd.template.explorer.music.b.d */
public class C7265d {
    private boolean dBq;
    private MusicDataItem musicItem;

    public C7265d(MusicDataItem musicDataItem) {
        this.musicItem = musicDataItem;
    }

    public C7265d(boolean z, MusicDataItem musicDataItem) {
        this.dBq = z;
        this.musicItem = musicDataItem;
    }

    public MusicDataItem axl() {
        return this.musicItem;
    }

    public boolean axm() {
        return this.dBq;
    }
}
