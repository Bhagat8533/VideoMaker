package com.introvd.template.component.videofetcher.p239c;

/* renamed from: com.introvd.template.component.videofetcher.c.a */
public class C5391a {
    private String cjV;
    public String cjW;
    public int cjX;
    public int cjY;
    public Boolean cjZ = Boolean.valueOf(false);
    public String cka;
    public long ckb = -1;
    public String duration;
    public String filePath;
    private String name;
    public int state = -1;
    public String thumbnailPath;

    public C5391a() {
    }

    public C5391a(String str, String str2, int i) {
        this.name = str;
        this.filePath = str2;
        this.state = i;
    }

    public C5391a(String str, String str2, long j, int i) {
        this.cjV = str;
        this.name = str2;
        this.ckb = j;
        this.state = i;
    }

    public C5391a(String str, String str2, String str3) {
        this.cka = str;
        this.cjV = str2;
        this.name = str3;
    }

    public C5391a(String str, String str2, String str3, String str4, String str5, String str6, int i, int i2) {
        this.cjV = str;
        this.cjW = str2;
        this.name = str3;
        this.filePath = str4;
        this.duration = str5;
        this.thumbnailPath = str6;
        this.cjX = i;
        this.cjY = i2;
    }

    /* renamed from: ZN */
    public String mo26976ZN() {
        return this.cjW;
    }

    /* renamed from: ZO */
    public String mo26977ZO() {
        return this.duration;
    }

    /* renamed from: ZP */
    public String mo26978ZP() {
        return this.thumbnailPath;
    }

    /* renamed from: ZQ */
    public int mo26979ZQ() {
        return this.cjX;
    }

    /* renamed from: ZR */
    public int mo26980ZR() {
        return this.cjY;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C5391a aVar = (C5391a) obj;
        if (this.name != null) {
            z = this.name.equals(aVar.name);
        } else if (aVar.name != null) {
            z = false;
        }
        return z;
    }

    /* renamed from: fA */
    public void mo26982fA(String str) {
        this.duration = str;
    }

    /* renamed from: fB */
    public void mo26983fB(String str) {
        this.thumbnailPath = str;
    }

    /* renamed from: fz */
    public void mo26984fz(String str) {
        this.cjW = str;
    }

    public String getAddress() {
        return this.cjV;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public String getName() {
        return this.name;
    }

    public int hashCode() {
        if (this.name != null) {
            return this.name.hashCode();
        }
        return 0;
    }

    /* renamed from: jX */
    public void mo26989jX(int i) {
        this.cjX = i;
    }

    /* renamed from: jY */
    public void mo26990jY(int i) {
        this.cjY = i;
    }

    public void setAddress(String str) {
        this.cjV = str;
    }

    public void setFilePath(String str) {
        this.filePath = str;
    }

    public void setName(String str) {
        this.name = str;
    }
}
