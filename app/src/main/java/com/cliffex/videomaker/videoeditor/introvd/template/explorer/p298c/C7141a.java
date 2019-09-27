package com.introvd.template.explorer.p298c;

import com.introvd.template.videoeditor.model.MediaItem;
import java.util.Comparator;

/* renamed from: com.introvd.template.explorer.c.a */
public class C7141a implements Comparator<MediaItem> {
    int dzj = 0;

    public C7141a(int i) {
        this.dzj = i;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001f, code lost:
        if (r8.date > r9.date) goto L_0x0021;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0021, code lost:
        r0 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0037, code lost:
        if (r8.date < r9.date) goto L_0x0021;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x005f, code lost:
        if (r1.compare(r8.title, r9.title) > 0) goto L_0x0021;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int compare(com.introvd.template.videoeditor.model.MediaItem r8, com.introvd.template.videoeditor.model.MediaItem r9) {
        /*
            r7 = this;
            r0 = 0
            if (r8 == 0) goto L_0x0063
            if (r9 == 0) goto L_0x0063
            if (r8 != r9) goto L_0x0008
            goto L_0x0063
        L_0x0008:
            int r1 = r7.dzj
            r2 = 2
            r3 = 1
            r4 = -1
            if (r1 != r2) goto L_0x0023
            long r1 = r8.date
            long r5 = r9.date
            int r1 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r1 >= 0) goto L_0x0019
        L_0x0017:
            r0 = -1
            goto L_0x0062
        L_0x0019:
            long r1 = r8.date
            long r8 = r9.date
            int r8 = (r1 > r8 ? 1 : (r1 == r8 ? 0 : -1))
            if (r8 <= 0) goto L_0x0062
        L_0x0021:
            r0 = 1
            goto L_0x0062
        L_0x0023:
            int r1 = r7.dzj
            r2 = 3
            if (r1 != r2) goto L_0x003a
            long r1 = r8.date
            long r5 = r9.date
            int r1 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r1 <= 0) goto L_0x0031
            goto L_0x0017
        L_0x0031:
            long r1 = r8.date
            long r8 = r9.date
            int r8 = (r1 > r8 ? 1 : (r1 == r8 ? 0 : -1))
            if (r8 >= 0) goto L_0x0062
            goto L_0x0021
        L_0x003a:
            r1 = 0
            java.util.Locale r2 = java.util.Locale.CHINA     // Catch:{ Exception -> 0x0042 }
            java.text.Collator r2 = java.text.Collator.getInstance(r2)     // Catch:{ Exception -> 0x0042 }
            r1 = r2
        L_0x0042:
            if (r1 == 0) goto L_0x0062
            java.lang.String r2 = r8.title
            if (r2 == 0) goto L_0x0062
            java.lang.String r2 = r9.title
            if (r2 == 0) goto L_0x0062
            java.lang.String r2 = r8.title
            java.lang.String r5 = r9.title
            int r2 = r1.compare(r2, r5)
            if (r2 >= 0) goto L_0x0057
            goto L_0x0017
        L_0x0057:
            java.lang.String r8 = r8.title
            java.lang.String r9 = r9.title
            int r8 = r1.compare(r8, r9)
            if (r8 <= 0) goto L_0x0062
            goto L_0x0021
        L_0x0062:
            return r0
        L_0x0063:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.explorer.p298c.C7141a.compare(com.introvd.template.videoeditor.model.MediaItem, com.introvd.template.videoeditor.model.MediaItem):int");
    }
}
