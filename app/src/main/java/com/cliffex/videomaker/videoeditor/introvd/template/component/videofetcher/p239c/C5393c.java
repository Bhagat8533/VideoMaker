package com.introvd.template.component.videofetcher.p239c;

/* renamed from: com.introvd.template.component.videofetcher.c.c */
public class C5393c implements Comparable<C5393c> {
    public String cka;
    public String ckc;
    public String name;
    public int progress;
    public int state;
    public String videoUrl;

    public C5393c(String str, String str2, String str3, String str4, int i) {
        this.ckc = str3;
        this.name = str;
        this.videoUrl = str2;
        this.cka = str4;
        this.progress = i;
    }

    public C5393c(String str, String str2, String str3, String str4, int i, int i2) {
        this.ckc = str3;
        this.name = str;
        this.videoUrl = str2;
        this.cka = str4;
        this.progress = i;
        this.state = i2;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C5393c cVar = (C5393c) obj;
        if (this.name != null) {
            z = this.name.equals(cVar.name);
        } else if (cVar.name != null) {
            z = false;
        }
        return z;
    }

    /* renamed from: f */
    public int compareTo(C5393c cVar) {
        if (cVar.progress != 100 || this.progress == 100) {
            return (cVar.progress == 100 || this.progress != 100) ? 0 : -1;
        }
        return 1;
    }

    public int hashCode() {
        if (this.name != null) {
            return this.name.hashCode();
        }
        return 0;
    }
}
