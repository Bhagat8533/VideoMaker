package com.introvd.template.component.videofetcher.p239c;

import com.ironsource.mediationsdk.logger.IronSourceError;
import java.io.Serializable;

/* renamed from: com.introvd.template.component.videofetcher.c.i */
public class C5399i implements Serializable {
    private long duration;
    private String fileName;
    private int hasSave;
    private int height;

    /* renamed from: id */
    private int f3459id;
    private String path;
    private String thumbnailPath;
    private int type;
    private int width;

    /* renamed from: com.introvd.template.component.videofetcher.c.i$a */
    public static class C5401a {
        /* access modifiers changed from: private */
        public long duration;
        /* access modifiers changed from: private */
        public String fileName;
        /* access modifiers changed from: private */
        public int hasSave;
        /* access modifiers changed from: private */
        public int height;
        /* access modifiers changed from: private */

        /* renamed from: id */
        public int f3460id;
        /* access modifiers changed from: private */
        public String path;
        /* access modifiers changed from: private */
        public String thumbnailPath;
        /* access modifiers changed from: private */
        public int type;
        /* access modifiers changed from: private */
        public int width;

        /* renamed from: ZX */
        public C5399i mo27017ZX() {
            return new C5399i(this);
        }

        /* renamed from: ar */
        public C5401a mo27018ar(long j) {
            this.duration = j;
            return this;
        }

        /* renamed from: fC */
        public C5401a mo27019fC(String str) {
            this.path = str;
            return this;
        }

        /* renamed from: fD */
        public C5401a mo27020fD(String str) {
            this.thumbnailPath = str;
            return this;
        }

        /* renamed from: fE */
        public C5401a mo27021fE(String str) {
            this.fileName = str;
            return this;
        }

        /* renamed from: jZ */
        public C5401a mo27022jZ(int i) {
            this.f3460id = i;
            return this;
        }

        /* renamed from: ka */
        public C5401a mo27023ka(int i) {
            this.width = i;
            return this;
        }

        /* renamed from: kb */
        public C5401a mo27024kb(int i) {
            this.height = i;
            return this;
        }

        /* renamed from: kc */
        public C5401a mo27025kc(int i) {
            this.hasSave = i;
            return this;
        }
    }

    public C5399i() {
    }

    private C5399i(C5401a aVar) {
        this.f3459id = aVar.f3460id;
        this.type = aVar.type;
        this.path = aVar.path;
        this.thumbnailPath = aVar.thumbnailPath;
        this.fileName = aVar.fileName;
        this.duration = aVar.duration;
        this.width = aVar.width;
        this.height = aVar.height;
        this.hasSave = aVar.hasSave;
    }

    /* renamed from: ZP */
    public String mo27010ZP() {
        return this.thumbnailPath;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001a, code lost:
        if (r5.path == null) goto L_0x003a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002f, code lost:
        if (r5.fileName == null) goto L_0x003a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r5) {
        /*
            r4 = this;
            r0 = 1
            if (r4 != r5) goto L_0x0004
            return r0
        L_0x0004:
            r1 = 0
            if (r5 == 0) goto L_0x003b
            java.lang.Class r2 = r4.getClass()
            java.lang.Class r3 = r5.getClass()
            if (r2 == r3) goto L_0x0012
            goto L_0x003b
        L_0x0012:
            com.introvd.template.component.videofetcher.c.i r5 = (com.introvd.template.component.videofetcher.p239c.C5399i) r5
            java.lang.String r2 = r4.path
            if (r2 != 0) goto L_0x001f
            java.lang.String r5 = r5.path
            if (r5 != 0) goto L_0x001d
            goto L_0x003a
        L_0x001d:
            r0 = 0
            goto L_0x003a
        L_0x001f:
            java.lang.String r2 = r4.path
            java.lang.String r3 = r5.path
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x0032
            java.lang.String r2 = r4.fileName
            if (r2 != 0) goto L_0x0032
            java.lang.String r5 = r5.fileName
            if (r5 != 0) goto L_0x001d
            goto L_0x003a
        L_0x0032:
            java.lang.String r0 = r4.fileName
            java.lang.String r5 = r5.fileName
            boolean r0 = r0.equals(r5)
        L_0x003a:
            return r0
        L_0x003b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.component.videofetcher.p239c.C5399i.equals(java.lang.Object):boolean");
    }

    public long getDuration() {
        return this.duration;
    }

    public int getHeight() {
        return this.height;
    }

    public String getPath() {
        return this.path;
    }

    public int getWidth() {
        return this.width;
    }

    public int hashCode() {
        return ((IronSourceError.ERROR_NON_EXISTENT_INSTANCE + this.path.hashCode()) * 31) + this.fileName.hashCode();
    }
}
