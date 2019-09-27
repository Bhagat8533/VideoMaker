package com.introvd.template.component.videofetcher.p239c;

/* renamed from: com.introvd.template.component.videofetcher.c.b */
public class C5392b {
    public String name;
    public int progress;
    public int state;

    public C5392b(String str, int i, int i2) {
        this.progress = i;
        this.name = str;
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
        C5392b bVar = (C5392b) obj;
        if (this.name != null) {
            z = this.name.equals(bVar.name);
        } else if (bVar.name != null) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        if (this.name != null) {
            return this.name.hashCode();
        }
        return 0;
    }
}
