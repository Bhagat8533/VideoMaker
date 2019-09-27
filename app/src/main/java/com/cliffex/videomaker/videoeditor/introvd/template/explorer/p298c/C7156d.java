package com.introvd.template.explorer.p298c;

import android.content.Context;
import android.support.p021v4.util.LongSparseArray;
import com.introvd.template.common.Constants;
import com.introvd.template.common.LogUtils;
import com.introvd.template.common.model.AppStateModel;
import com.introvd.template.explorer.model.MusicEffectInfoModel;
import com.introvd.template.sdk.p391g.C8450a;
import com.introvd.template.sdk.utils.C8553i;
import com.introvd.template.template.p409g.C8762d;
import java.util.ArrayList;

/* renamed from: com.introvd.template.explorer.c.d */
public class C7156d {
    private long dAa = 0;
    private boolean dAb = false;
    private int dAc = 4;
    private LongSparseArray<MusicEffectInfoModel> dzW = new LongSparseArray<>();
    private LongSparseArray<MusicEffectInfoModel> dzX = new LongSparseArray<>();
    private ArrayList<Long> dzY = new ArrayList<>();
    private ArrayList<Long> dzZ = new ArrayList<>();

    public C7156d(int i) {
        this.dAc = i;
        StringBuilder sb = new StringBuilder();
        sb.append("EffectMgr: ");
        sb.append(i);
        LogUtils.m14222e("MusicEffectMgr", sb.toString());
    }

    /* renamed from: a */
    private synchronized void m21166a(Context context, int i, int i2, long j, long j2) {
        this.dzX.clear();
        this.dzY.clear();
        this.dzZ.clear();
        LongSparseArray<MusicEffectInfoModel> longSparseArray = new LongSparseArray<>();
        try {
            C8762d aMt = C8762d.aMt();
            aMt.mo35219Q(context, AppStateModel.getInstance().isInChina());
            ArrayList c = aMt.mo35235c(i2, j, j2);
            if (c != null) {
                if (c.size() != 0) {
                    int size = c.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        long longValue = ((Long) c.get(i3)).longValue();
                        MusicEffectInfoModel musicEffectInfoModel = (MusicEffectInfoModel) this.dzW.get(longValue);
                        String bB = aMt.mo35225bB(longValue);
                        if (musicEffectInfoModel == null) {
                            musicEffectInfoModel = new MusicEffectInfoModel(longValue, bB);
                            if (longValue > 0) {
                                musicEffectInfoModel.mName = aMt.mo35241l(longValue, i);
                                musicEffectInfoModel.mFavorite = aMt.mo35226bC(longValue);
                            }
                        } else {
                            this.dzW.remove(longValue);
                            musicEffectInfoModel.mPath = bB;
                            musicEffectInfoModel.mFavorite = aMt.mo35226bC(longValue);
                            musicEffectInfoModel.mName = aMt.mo35241l(longValue, i);
                        }
                        this.dzY.add(Long.valueOf(longValue));
                        longSparseArray.put(longValue, musicEffectInfoModel);
                        if (aMt.mo35232bI(longValue) || aMt.mo35231bH(longValue)) {
                            this.dzX.put(longValue, musicEffectInfoModel);
                            this.dzZ.add(Long.valueOf(longValue));
                        }
                    }
                    c.clear();
                    this.dzW.clear();
                    this.dzW = longSparseArray;
                }
            }
        } finally {
            this.dzW.clear();
            this.dzW = longSparseArray;
        }
    }

    private ArrayList<Long> awG() {
        return this.dAb ? this.dzZ : this.dzY;
    }

    private LongSparseArray<MusicEffectInfoModel> awH() {
        return this.dAb ? this.dzX : this.dzW;
    }

    /* renamed from: jf */
    public static long m21167jf(String str) {
        return C8762d.aMt().getTemplateID(str);
    }

    /* renamed from: a */
    public synchronized void mo31625a(Context context, long j, long j2) {
        mo31626a(context, j, j2, 0);
    }

    /* renamed from: a */
    public synchronized void mo31626a(Context context, long j, long j2, long j3) {
        long j4 = j2;
        synchronized (this) {
            long currentTimeMillis = System.currentTimeMillis();
            if (context != null) {
                C8553i.setContext(context.getApplicationContext());
                C8553i.m25005ut(23);
                int c = C8450a.m24471c(Constants.getLocale());
                this.dAa = j4;
                m21166a(context, c, this.dAc, this.dAa, j3);
                this.dAb = (131072 & j4) != 0;
                StringBuilder sb = new StringBuilder();
                sb.append("EffectMgr.init(");
                sb.append(this.dAc);
                sb.append(") cost:");
                sb.append(System.currentTimeMillis() - currentTimeMillis);
                LogUtils.m14222e("MusicEffectMgr", sb.toString());
            }
        }
    }

    public int getCount() {
        LongSparseArray awH = awH();
        if (awH == null) {
            return 0;
        }
        return awH.size();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0049, code lost:
        return r0;
     */
    /* renamed from: qF */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized com.introvd.template.explorer.model.MusicEffectInfoModel mo31628qF(int r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            if (r5 < 0) goto L_0x004d
            int r0 = r4.getCount()     // Catch:{ all -> 0x004a }
            if (r5 < r0) goto L_0x000a
            goto L_0x004d
        L_0x000a:
            java.util.ArrayList r0 = r4.awG()     // Catch:{ all -> 0x004a }
            java.lang.Object r5 = r0.get(r5)     // Catch:{ all -> 0x004a }
            java.lang.Long r5 = (java.lang.Long) r5     // Catch:{ all -> 0x004a }
            android.support.v4.util.LongSparseArray r0 = r4.awH()     // Catch:{ all -> 0x004a }
            long r1 = r5.longValue()     // Catch:{ all -> 0x004a }
            java.lang.Object r0 = r0.get(r1)     // Catch:{ all -> 0x004a }
            com.introvd.template.explorer.model.MusicEffectInfoModel r0 = (com.introvd.template.explorer.model.MusicEffectInfoModel) r0     // Catch:{ all -> 0x004a }
            com.introvd.template.template.g.d r1 = com.introvd.template.template.p409g.C8762d.aMt()     // Catch:{ all -> 0x004a }
            long r2 = r5.longValue()     // Catch:{ all -> 0x004a }
            com.introvd.template.sdk.model.editor.TemplateItemData r5 = r1.mo35227bD(r2)     // Catch:{ all -> 0x004a }
            if (r5 == 0) goto L_0x0048
            if (r0 == 0) goto L_0x0048
            int r1 = r5.nFromType     // Catch:{ all -> 0x004a }
            if (r1 == 0) goto L_0x0038
            r1 = 1
            goto L_0x0039
        L_0x0038:
            r1 = 0
        L_0x0039:
            r0.setDownloaded(r1)     // Catch:{ all -> 0x004a }
            boolean r1 = r5.shouldOnlineDownload()     // Catch:{ all -> 0x004a }
            r0.setbNeedDownload(r1)     // Catch:{ all -> 0x004a }
            int r5 = r5.nConfigureCount     // Catch:{ all -> 0x004a }
            r0.setmConfigureCount(r5)     // Catch:{ all -> 0x004a }
        L_0x0048:
            monitor-exit(r4)
            return r0
        L_0x004a:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        L_0x004d:
            r5 = 0
            monitor-exit(r4)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.explorer.p298c.C7156d.mo31628qF(int):com.introvd.template.explorer.model.MusicEffectInfoModel");
    }

    /* renamed from: qG */
    public String mo31629qG(int i) {
        MusicEffectInfoModel qF = mo31628qF(i);
        if (qF == null) {
            return null;
        }
        return qF.mPath;
    }

    /* renamed from: qH */
    public String mo31630qH(int i) {
        MusicEffectInfoModel qF = mo31628qF(i);
        if (qF == null) {
            return null;
        }
        return qF.mName;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0033, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void unInit(boolean r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            android.support.v4.util.LongSparseArray<com.introvd.template.explorer.model.MusicEffectInfoModel> r3 = r2.dzW     // Catch:{ all -> 0x0034 }
            if (r3 == 0) goto L_0x0032
            android.support.v4.util.LongSparseArray<com.introvd.template.explorer.model.MusicEffectInfoModel> r3 = r2.dzW     // Catch:{ all -> 0x0034 }
            int r3 = r3.size()     // Catch:{ all -> 0x0034 }
            if (r3 != 0) goto L_0x000e
            goto L_0x0032
        L_0x000e:
            android.support.v4.util.LongSparseArray<com.introvd.template.explorer.model.MusicEffectInfoModel> r3 = r2.dzW     // Catch:{ all -> 0x0034 }
            r3.clear()     // Catch:{ all -> 0x0034 }
            android.support.v4.util.LongSparseArray<com.introvd.template.explorer.model.MusicEffectInfoModel> r3 = r2.dzX     // Catch:{ all -> 0x0034 }
            r3.clear()     // Catch:{ all -> 0x0034 }
            java.lang.String r3 = "MusicEffectMgr"
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0034 }
            r0.<init>()     // Catch:{ all -> 0x0034 }
            java.lang.String r1 = "unInit:"
            r0.append(r1)     // Catch:{ all -> 0x0034 }
            int r1 = r2.dAc     // Catch:{ all -> 0x0034 }
            r0.append(r1)     // Catch:{ all -> 0x0034 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0034 }
            com.introvd.template.common.LogUtils.m14222e(r3, r0)     // Catch:{ all -> 0x0034 }
            monitor-exit(r2)
            return
        L_0x0032:
            monitor-exit(r2)
            return
        L_0x0034:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.explorer.p298c.C7156d.unInit(boolean):void");
    }
}
