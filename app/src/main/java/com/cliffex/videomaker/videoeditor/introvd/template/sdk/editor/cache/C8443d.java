package com.introvd.template.sdk.editor.cache;

import com.introvd.template.sdk.C8401d;
import com.introvd.template.sdk.utils.C8548e;
import com.introvd.template.sdk.utils.C8561p;
import com.introvd.template.sdk.utils.C8564s;
import com.introvd.template.sdk.utils.p394b.C8536m;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.introvd.template.sdk.editor.cache.d */
public class C8443d implements Cloneable {
    private ArrayList<C8440a> eel;
    private boolean eem = false;

    /* renamed from: b */
    public static TrimedClipItemDataModel m24427b(C8440a aVar) {
        if (aVar != null && !aVar.isCover()) {
            String aHU = aVar.aHU();
            if (C8548e.isFileExisted(aHU) || aVar.aHY()) {
                TrimedClipItemDataModel trimedClipItemDataModel = new TrimedClipItemDataModel();
                trimedClipItemDataModel.mExportPath = aHU;
                trimedClipItemDataModel.mRotate = Integer.valueOf(aVar.aHX());
                trimedClipItemDataModel.isImage = Boolean.valueOf(aVar.isImage());
                trimedClipItemDataModel.isExported = Boolean.valueOf(m24428nH(aHU));
                trimedClipItemDataModel.mVeRangeInRawVideo = C8561p.m25041d(aVar.edJ);
                trimedClipItemDataModel.mTrimVeRange = C8561p.m25041d(aVar.aHT());
                trimedClipItemDataModel.setmClipReverseFilePath(aVar.getmClipReverseFilePath());
                trimedClipItemDataModel.setIsClipReverse(aVar.isClipReverse());
                trimedClipItemDataModel.setbIsReverseMode(aVar.isbIsReverseMode());
                if (!aVar.aHY()) {
                    trimedClipItemDataModel.bCropFeatureEnable = Boolean.valueOf(aHU.contains(".media/"));
                    if (!trimedClipItemDataModel.bCropFeatureEnable.booleanValue()) {
                        trimedClipItemDataModel.mRawFilePath = aHU;
                    }
                }
                long currentTimeMillis = System.currentTimeMillis() + ((long) aVar.aHL());
                trimedClipItemDataModel.mThumbKey = Long.valueOf(currentTimeMillis);
                C8564s.aJi().mo34803a(Long.valueOf(currentTimeMillis), aVar.aHM());
                return trimedClipItemDataModel;
            }
        }
        return null;
    }

    /* renamed from: nH */
    public static boolean m24428nH(String str) {
        if (C8548e.isFileExisted(str)) {
            return str.contains(C8401d.getMediaStorageRelativePath());
        }
        return false;
    }

    /* renamed from: a */
    public void mo34292a(C8440a aVar) {
        if (getCount() <= 0) {
            this.eem = true;
        }
        if (this.eel == null) {
            this.eel = new ArrayList<>();
        }
        if (aVar.aHL() < 0 || aVar.aHL() > this.eel.size()) {
            this.eel.add(aVar);
            return;
        }
        this.eel.add(aVar.aHL(), aVar);
        if (getCount() > 0) {
            boolean z = false;
            C8440a tX = mo34307tX(0);
            if (tX != null) {
                boolean z2 = tX.isCover() && aVar.aHL() == 1;
                if (!tX.isCover() && aVar.aHL() == 0) {
                    z = true;
                }
                if (z2 || z) {
                    this.eem = true;
                }
            }
        }
    }

    /* renamed from: a */
    public void mo34293a(C8440a aVar, int i) {
        if (this.eel == null) {
            this.eel = new ArrayList<>();
        }
        this.eel.add(i, aVar);
    }

    /* renamed from: aIk */
    public C8443d clone() throws CloneNotSupportedException {
        C8443d dVar = (C8443d) super.clone();
        ArrayList<C8440a> arrayList = new ArrayList<>();
        if (this.eel != null && this.eel.size() > 0) {
            Iterator it = this.eel.iterator();
            while (it.hasNext()) {
                arrayList.add(((C8440a) it.next()).clone());
            }
        }
        dVar.eel = arrayList;
        return dVar;
    }

    public void aIl() {
        if (this.eel != null) {
            for (int size = this.eel.size() - 1; size >= 0; size--) {
                C8440a aVar = (C8440a) this.eel.get(size);
                String aHU = aVar.aHU();
                if (aHU != null) {
                    int i = 0;
                    for (int i2 = 0; i2 < size; i2++) {
                        if (this.eel.size() > i2) {
                            String aHU2 = ((C8440a) this.eel.get(i2)).aHU();
                            if (aHU2 != null && aHU.equals(aHU2)) {
                                i++;
                            }
                        }
                    }
                    int aHK = aVar.aHK();
                    if (aHK != i) {
                        aVar.mo34252tL(i);
                        if (aVar.aHM() != null) {
                            if (aHK < i) {
                                C8536m.m24780L(aHU, aHK);
                            }
                            C8536m.m24782a(aHU, i, aVar.aHM());
                        }
                    }
                }
            }
        }
    }

    public boolean aIm() {
        return this.eem;
    }

    /* renamed from: bN */
    public boolean mo34297bN(int i) {
        if (getCount() > 0) {
            C8440a tX = mo34307tX(0);
            if (tX != null) {
                boolean z = tX.isCover() && i == 1;
                boolean z2 = !tX.isCover() && i == 0;
                if (z || z2) {
                    this.eem = true;
                }
            }
        }
        if (this.eel == null || i < 0 || i >= this.eel.size()) {
            return false;
        }
        C8440a aVar = (C8440a) this.eel.get(i);
        if (aVar != null) {
            int aHK = aVar.aHK();
            String aHU = aVar.aHU();
            if (aHU != null) {
                C8536m.m24780L(aHU, aHK);
            }
            aVar.release();
            this.eel.remove(i);
        }
        return true;
    }

    /* renamed from: dA */
    public boolean mo34299dA(int i, int i2) {
        if (getCount() > 0) {
            C8440a tX = mo34307tX(0);
            if (tX != null) {
                boolean z = tX.isCover() && i == 1;
                boolean z2 = !tX.isCover() && i == 0;
                if (z || z2) {
                    this.eem = true;
                }
            }
        }
        C8440a tX2 = mo34307tX(i);
        if (tX2 == null || tX2.aHS() == i2) {
            return false;
        }
        tX2.mo34259tS(i2);
        return true;
    }

    /* renamed from: dB */
    public boolean mo34300dB(int i, int i2) {
        boolean z = false;
        if (this.eel == null || i < 0 || i >= this.eel.size() || i2 < 0 || i2 >= this.eel.size()) {
            return false;
        }
        if (getCount() > 0) {
            C8440a tX = mo34307tX(0);
            if (tX != null) {
                int i3 = i > i2 ? i2 : i;
                boolean z2 = tX.isCover() && i3 == 1;
                if (!tX.isCover() && i3 == 0) {
                    z = true;
                }
                if (z2 || z) {
                    this.eem = true;
                }
            }
        }
        C8440a aVar = (C8440a) this.eel.get(i);
        if (aVar != null) {
            this.eel.remove(i);
            this.eel.add(i2, aVar);
        }
        return true;
    }

    /* renamed from: dC */
    public void mo34301dC(int i, int i2) {
        if (i < i2) {
            i = i2;
        }
        for (int i3 = i > i2 ? i2 : i; i3 <= i; i3++) {
            C8440a tX = mo34307tX(i3);
            if (tX != null) {
                tX.mo34253tM(i3);
            }
        }
        aIl();
    }

    /* renamed from: dz */
    public boolean mo34302dz(int i, int i2) {
        C8440a tX = mo34307tX(i);
        if (tX == null || tX.aHO() == i2) {
            return false;
        }
        tX.mo34255tO(i2);
        return true;
    }

    public int getClipCount() {
        int i = 0;
        if (this.eel == null || this.eel.size() <= 0) {
            return 0;
        }
        Iterator it = this.eel.iterator();
        while (it.hasNext()) {
            C8440a aVar = (C8440a) it.next();
            if (aVar != null && !aVar.isCover()) {
                i++;
            }
        }
        return i;
    }

    public int getCount() {
        if (this.eel == null) {
            return 0;
        }
        return this.eel.size();
    }

    /* renamed from: jl */
    public void mo34305jl(boolean z) {
        this.eem = z;
    }

    public void releaseAll() {
        if (this.eel != null) {
            for (int i = 0; i < this.eel.size(); i++) {
                C8440a aVar = (C8440a) this.eel.get(i);
                if (aVar != null) {
                    aVar.release();
                }
            }
            this.eel.clear();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0022, code lost:
        return null;
     */
    /* renamed from: tX */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized com.introvd.template.sdk.editor.cache.C8440a mo34307tX(int r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            java.util.ArrayList<com.introvd.template.sdk.editor.cache.a> r0 = r2.eel     // Catch:{ all -> 0x0023 }
            r1 = 0
            if (r0 == 0) goto L_0x0021
            if (r3 < 0) goto L_0x0021
            java.util.ArrayList<com.introvd.template.sdk.editor.cache.a> r0 = r2.eel     // Catch:{ all -> 0x0023 }
            int r0 = r0.size()     // Catch:{ all -> 0x0023 }
            if (r3 < r0) goto L_0x0011
            goto L_0x0021
        L_0x0011:
            java.util.ArrayList<com.introvd.template.sdk.editor.cache.a> r0 = r2.eel     // Catch:{ Exception -> 0x001b }
            java.lang.Object r3 = r0.get(r3)     // Catch:{ Exception -> 0x001b }
            com.introvd.template.sdk.editor.cache.a r3 = (com.introvd.template.sdk.editor.cache.C8440a) r3     // Catch:{ Exception -> 0x001b }
            monitor-exit(r2)
            return r3
        L_0x001b:
            r3 = move-exception
            r3.printStackTrace()     // Catch:{ all -> 0x0023 }
            monitor-exit(r2)
            return r1
        L_0x0021:
            monitor-exit(r2)
            return r1
        L_0x0023:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.sdk.editor.cache.C8443d.mo34307tX(int):com.introvd.template.sdk.editor.cache.a");
    }

    /* renamed from: tY */
    public void mo34308tY(int i) {
        if (i >= 0) {
            while (true) {
                i++;
                if (i < getCount()) {
                    C8440a tX = mo34307tX(i);
                    if (tX != null) {
                        tX.mo34253tM(i);
                    }
                } else {
                    return;
                }
            }
        }
    }

    /* renamed from: tZ */
    public void mo34309tZ(int i) {
        if (mo34307tX(i) != null) {
            while (true) {
                i++;
                if (i < getCount()) {
                    C8440a tX = mo34307tX(i);
                    if (tX != null) {
                        tX.mo34253tM(i - 1);
                    }
                } else {
                    return;
                }
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.eel != null) {
            Iterator it = this.eel.iterator();
            while (it.hasNext()) {
                sb.append((C8440a) it.next());
            }
        }
        return sb.length() > 0 ? sb.toString() : super.toString();
    }

    /* renamed from: ua */
    public void mo34311ua(int i) {
        if (getCount() > 0) {
            boolean z = false;
            C8440a tX = mo34307tX(0);
            if (tX != null) {
                boolean z2 = tX.isCover() && i == 1;
                if (!tX.isCover() && i == 0) {
                    z = true;
                }
                if (z2 || z) {
                    this.eem = true;
                }
            }
        }
    }
}
