package com.introvd.template.component.videofetcher.p239c;

/* renamed from: com.introvd.template.component.videofetcher.c.g */
public class C5397g {
    public boolean ckh;
    public String name;

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C5397g gVar = (C5397g) obj;
        if (this.name != null) {
            z = this.name.equals(gVar.name);
        } else if (gVar.name != null) {
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
