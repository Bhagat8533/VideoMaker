package com.introvd.template.template.p409g;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.p021v4.util.LongSparseArray;
import com.introvd.template.sdk.model.TemplateConditionModel;
import com.introvd.template.sdk.model.editor.EffectInfoModel;
import com.introvd.template.sdk.model.editor.TemplateItemData;
import com.introvd.template.sdk.p391g.C8450a;
import com.introvd.template.sdk.utils.C8553i;
import com.introvd.template.sdk.utils.C8554j;
import com.introvd.template.sdk.utils.p394b.C8501a;
import com.introvd.template.sdk.utils.p394b.C8530i;
import com.introvd.template.sdk.utils.p394b.C8536m;
import com.introvd.template.sdk.utils.p394b.C8537n;
import com.introvd.template.sdk.utils.p394b.C8538o;
import com.introvd.template.sdk.utils.p394b.C8540q;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import xiaoying.engine.base.QStyle;
import xiaoying.engine.clip.QClip;
import xiaoying.engine.storyboard.QStoryboard;

/* renamed from: com.introvd.template.template.g.b */
public class C8759b {
    private final Map<String, SoftReference<Bitmap>> bVw = Collections.synchronizedMap(new LinkedHashMap<String, SoftReference<Bitmap>>(30, 0.75f, true) {
        /* access modifiers changed from: protected */
        public boolean removeEldestEntry(Entry<String, SoftReference<Bitmap>> entry) {
            return size() > 30;
        }
    });
    private long cyT = 0;
    private long dAa = 0;
    private boolean dAb = false;
    private int dAc = 4;
    private LongSparseArray<EffectInfoModel> dzW = new LongSparseArray<>();
    private LongSparseArray<EffectInfoModel> dzX = new LongSparseArray<>();
    private ArrayList<Long> dzY = new ArrayList<>();
    private ArrayList<Long> dzZ = new ArrayList<>();
    private boolean mbInited = false;

    public C8759b(int i) {
        this.dAc = i;
        StringBuilder sb = new StringBuilder();
        sb.append("EffectMgr: ");
        sb.append(i);
        C8554j.m25007e("EffectMgr", sb.toString());
    }

    /* renamed from: a */
    private synchronized void m25584a(Context context, int i, int i2, long j, long j2, boolean z, boolean z2) {
        int i3 = i;
        synchronized (this) {
            this.dzX.clear();
            this.dzY.clear();
            this.dzZ.clear();
            LongSparseArray<EffectInfoModel> longSparseArray = new LongSparseArray<>();
            try {
                C8762d aMt = C8762d.aMt();
                Context context2 = context;
                aMt.mo35219Q(context, z);
                ArrayList c = aMt.mo35235c(i2, j, j2);
                if (c != null) {
                    if (c.size() != 0) {
                        int size = c.size();
                        for (int i4 = 0; i4 < size; i4++) {
                            long longValue = ((Long) c.get(i4)).longValue();
                            if (!z2 || !C8762d.aMt().mo35234bK(longValue)) {
                                EffectInfoModel effectInfoModel = (EffectInfoModel) this.dzW.get(longValue);
                                String bB = aMt.mo35225bB(longValue);
                                if (effectInfoModel == null) {
                                    effectInfoModel = new EffectInfoModel(longValue, bB);
                                    if (longValue > 0) {
                                        effectInfoModel.mName = aMt.mo35241l(longValue, i);
                                        effectInfoModel.mFavorite = aMt.mo35226bC(longValue);
                                    }
                                } else {
                                    this.dzW.remove(longValue);
                                    effectInfoModel.mPath = bB;
                                    effectInfoModel.mFavorite = aMt.mo35226bC(longValue);
                                    effectInfoModel.mName = aMt.mo35241l(longValue, i);
                                }
                                this.dzY.add(Long.valueOf(longValue));
                                longSparseArray.put(longValue, effectInfoModel);
                                if (aMt.mo35232bI(longValue) || aMt.mo35231bH(longValue)) {
                                    this.dzX.put(longValue, effectInfoModel);
                                    this.dzZ.add(Long.valueOf(longValue));
                                }
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
    }

    private ArrayList<Long> awG() {
        return this.dAb ? this.dzZ : this.dzY;
    }

    private LongSparseArray<EffectInfoModel> awH() {
        return this.dAb ? this.dzX : this.dzW;
    }

    /* renamed from: b */
    public static int m25585b(int i, QStoryboard qStoryboard) {
        int i2 = 0;
        if (qStoryboard != null) {
            if (i != 9) {
                switch (i) {
                    case 3:
                        int D = C8540q.m24895D(qStoryboard);
                        int i3 = 0;
                        for (int i4 = 0; i4 < D; i4++) {
                            if (C8540q.m24916a(i4, qStoryboard) > 0 && m25587jf(C8540q.m24960k(qStoryboard, i4)) <= 0 && C8540q.m24933a(qStoryboard, i4, C8762d.aMt().mo35245vl(3), 0, 0)) {
                                i3++;
                            }
                        }
                        return i3;
                    case 4:
                        int D2 = C8540q.m24895D(qStoryboard);
                        int i5 = 0;
                        for (int i6 = 0; i6 < D2; i6++) {
                            QClip i7 = C8540q.m24956i(qStoryboard, i6);
                            if (C8537n.m24829i(i7, 2) > 0 && m25587jf(C8540q.m24972t(i7)) <= 0 && C8540q.m24921a(qStoryboard, i6, C8762d.aMt().mo35245vl(4), false) == 0) {
                                i5++;
                            }
                        }
                        return i5;
                    case 5:
                        int h = C8537n.m24827h(qStoryboard.getDataClip(), 8);
                        if (h > 0) {
                            for (int i8 = h - 1; i8 >= 0; i8--) {
                                String e = C8538o.m24872e(C8540q.m24940b(qStoryboard, 8, i8));
                                if (C8530i.m24761jM(e)) {
                                    if (!C8530i.m24762oI(e) && C8540q.m24943c(qStoryboard, 8, i8) == 0) {
                                        i2++;
                                    }
                                } else if (m25587jf(e) <= 0 && C8540q.m24943c(qStoryboard, 8, i8) == 0) {
                                    i2++;
                                }
                            }
                        }
                        return i2;
                    case 6:
                        int h2 = C8537n.m24827h(qStoryboard.getDataClip(), 6);
                        if (h2 > 0) {
                            for (int i9 = h2 - 1; i9 >= 0; i9--) {
                                if (m25587jf(C8538o.m24874g(C8540q.m24940b(qStoryboard, 6, i9))) <= 0 && C8537n.m24818c(qStoryboard.getDataClip(), i9, 6) == 0) {
                                    i2++;
                                }
                            }
                        }
                        return i2;
                }
            } else {
                int h3 = C8537n.m24827h(qStoryboard.getDataClip(), 3);
                if (h3 > 0) {
                    for (int i10 = h3 - 1; i10 >= 0; i10--) {
                        if (m25587jf(C8538o.m24872e(C8540q.m24940b(qStoryboard, 3, i10))) <= 0 && C8540q.m24943c(qStoryboard, 3, i10) == 0) {
                            i2++;
                        }
                    }
                }
                return i2;
            }
        }
        return 0;
    }

    /* renamed from: by */
    public static String m25586by(long j) {
        return C8762d.aMt().mo35225bB(j);
    }

    /* renamed from: jf */
    public static long m25587jf(String str) {
        return C8762d.aMt().getTemplateID(str);
    }

    /* renamed from: N */
    public Bitmap mo35193N(int i, int i2, int i3) {
        EffectInfoModel vh = mo35214vh(i);
        if (vh == null) {
            return null;
        }
        SoftReference softReference = (SoftReference) this.bVw.get(vh.mPath);
        if (softReference != null) {
            Bitmap bitmap = (Bitmap) softReference.get();
            if (bitmap != null && !bitmap.isRecycled()) {
                return bitmap;
            }
        }
        Bitmap a = C8762d.aMt().mo35220a(vh.mTemplateId, i2, i3, C8501a.aJs().aJv());
        if (a != null) {
            this.bVw.put(vh.mPath, new SoftReference(a));
        }
        return a;
    }

    /* renamed from: a */
    public long mo35194a(TemplateConditionModel templateConditionModel) {
        long j = 0;
        if (templateConditionModel == null) {
            return 0;
        }
        if (!templateConditionModel.isPhoto) {
            j = 1048576;
        }
        if (!templateConditionModel.isShowDefault) {
            j |= 65536;
        }
        long j2 = j | 268435456;
        int i = templateConditionModel.mLayoutMode;
        if (i == 4) {
            return j2 | 4;
        }
        if (i == 8) {
            return j2 | 8;
        }
        if (i == 16) {
            return j2 | 16;
        }
        switch (i) {
            case 1:
                return j2 | 1;
            case 2:
                return j2 | 2;
            default:
                return j2;
        }
    }

    /* renamed from: a */
    public synchronized void mo35195a(Context context, long j, long j2, long j3, boolean z, boolean z2) {
        long j4 = j2;
        synchronized (this) {
            long currentTimeMillis = System.currentTimeMillis();
            if (context != null) {
                C8553i.setContext(context.getApplicationContext());
                C8553i.m25005ut(23);
                int c = C8450a.m24471c(context.getResources().getConfiguration().locale);
                this.dAa = j4;
                m25584a(context, c, this.dAc, this.dAa, j3, z, z2);
                this.cyT = j;
                boolean z3 = true;
                this.mbInited = true;
                if ((131072 & j4) == 0) {
                    z3 = false;
                }
                this.dAb = z3;
                StringBuilder sb = new StringBuilder();
                sb.append("init(");
                sb.append(this.dAc);
                sb.append(") cost:");
                sb.append(System.currentTimeMillis() - currentTimeMillis);
                C8554j.m25007e("EffectMgr", sb.toString());
            }
        }
    }

    /* renamed from: a */
    public synchronized void mo35196a(Context context, long j, long j2, boolean z) {
        try {
            mo35195a(context, j, j2, 0, z, false);
        } catch (Throwable th) {
            throw th;
        }
    }

    /* renamed from: a */
    public synchronized void mo35197a(Context context, long j, long j2, boolean z, boolean z2) {
        try {
            mo35195a(context, j, j2, 0, z, z2);
        } catch (Throwable th) {
            throw th;
        }
    }

    /* renamed from: a */
    public synchronized void mo35198a(Context context, long j, TemplateConditionModel templateConditionModel, boolean z) {
        mo35196a(context, j, mo35194a(templateConditionModel), z);
    }

    /* renamed from: a */
    public synchronized void mo35199a(Context context, long j, TemplateConditionModel templateConditionModel, boolean z, boolean z2) {
        mo35197a(context, j, mo35194a(templateConditionModel), z, z2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x002e, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void mo35200a(android.content.Context r8, long r9, boolean r11, boolean r12) {
        /*
            r7 = this;
            monitor-enter(r7)
            if (r8 == 0) goto L_0x002d
            boolean r11 = r7.mbInited     // Catch:{ all -> 0x002a }
            if (r11 != 0) goto L_0x0008
            goto L_0x002d
        L_0x0008:
            android.content.Context r11 = r8.getApplicationContext()     // Catch:{ all -> 0x002a }
            com.introvd.template.sdk.utils.C8553i.setContext(r11)     // Catch:{ all -> 0x002a }
            r11 = 23
            com.introvd.template.sdk.utils.C8553i.m25005ut(r11)     // Catch:{ all -> 0x002a }
            int r9 = xiaoying.engine.base.QStyle.QTemplateIDUtils.getTemplateType(r9)     // Catch:{ all -> 0x002a }
            int r10 = r7.dAc     // Catch:{ all -> 0x002a }
            if (r9 == r10) goto L_0x001e
            monitor-exit(r7)
            return
        L_0x001e:
            long r2 = r7.cyT     // Catch:{ all -> 0x002a }
            long r4 = r7.dAa     // Catch:{ all -> 0x002a }
            r0 = r7
            r1 = r8
            r6 = r12
            r0.mo35196a(r1, r2, r4, r6)     // Catch:{ all -> 0x002a }
            monitor-exit(r7)
            return
        L_0x002a:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        L_0x002d:
            monitor-exit(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.template.p409g.C8759b.mo35200a(android.content.Context, long, boolean, boolean):void");
    }

    public EffectInfoModel aMq() {
        Long valueOf = Long.valueOf(QStyle.NONE_ANIMATED_FRAME_TEMPLATE_ID);
        EffectInfoModel effectInfoModel = (EffectInfoModel) awH().get(valueOf.longValue());
        TemplateItemData bD = C8762d.aMt().mo35227bD(valueOf.longValue());
        if (!(bD == null || effectInfoModel == null)) {
            effectInfoModel.setbNeedDownload(bD.shouldOnlineDownload());
        }
        return effectInfoModel;
    }

    public EffectInfoModel aMr() {
        Long valueOf = Long.valueOf(QStyle.NONE_FILTER_TEMPLATE_ID);
        EffectInfoModel effectInfoModel = (EffectInfoModel) awH().get(valueOf.longValue());
        TemplateItemData bD = C8762d.aMt().mo35227bD(valueOf.longValue());
        if (!(bD == null || effectInfoModel == null)) {
            effectInfoModel.setbNeedDownload(bD.shouldOnlineDownload());
        }
        return effectInfoModel;
    }

    public int aMs() {
        int count = getCount();
        int i = 0;
        while (true) {
            if (i >= count) {
                i = 0;
                break;
            }
            EffectInfoModel vh = mo35214vh(i);
            if (vh != null && !vh.isbNeedDownload()) {
                break;
            }
            i++;
        }
        if (i < 0) {
            return 0;
        }
        return i;
    }

    /* renamed from: bw */
    public synchronized EffectInfoModel mo35204bw(long j) {
        return mo35214vh(mo35205bx(j));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002a, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x002c, code lost:
        return -1;
     */
    /* renamed from: bx */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized int mo35205bx(long r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            java.util.ArrayList r0 = r5.awG()     // Catch:{ all -> 0x002d }
            r1 = -1
            if (r0 == 0) goto L_0x002b
            boolean r2 = r0.isEmpty()     // Catch:{ all -> 0x002d }
            if (r2 == 0) goto L_0x000f
            goto L_0x002b
        L_0x000f:
            r2 = 0
        L_0x0010:
            int r3 = r0.size()     // Catch:{ all -> 0x002d }
            if (r2 >= r3) goto L_0x0029
            java.lang.Object r3 = r0.get(r2)     // Catch:{ all -> 0x002d }
            java.lang.Long r3 = (java.lang.Long) r3     // Catch:{ all -> 0x002d }
            long r3 = r3.longValue()     // Catch:{ all -> 0x002d }
            int r3 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r3 != 0) goto L_0x0026
            r1 = r2
            goto L_0x0029
        L_0x0026:
            int r2 = r2 + 1
            goto L_0x0010
        L_0x0029:
            monitor-exit(r5)
            return r1
        L_0x002b:
            monitor-exit(r5)
            return r1
        L_0x002d:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.template.p409g.C8759b.mo35205bx(long):int");
    }

    /* renamed from: bz */
    public Bitmap mo35206bz(long j) {
        return mo35216vj(mo35205bx(j));
    }

    public int getCount() {
        LongSparseArray awH = awH();
        if (awH == null) {
            return 0;
        }
        return awH.size();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0040, code lost:
        return -1;
     */
    /* renamed from: qC */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized int mo35208qC(java.lang.String r7) {
        /*
            r6 = this;
            monitor-enter(r6)
            java.util.ArrayList r0 = r6.awG()     // Catch:{ all -> 0x0041 }
            r1 = -1
            if (r0 == 0) goto L_0x003f
            boolean r2 = r0.isEmpty()     // Catch:{ all -> 0x0041 }
            if (r2 != 0) goto L_0x003f
            boolean r2 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x0041 }
            if (r2 == 0) goto L_0x0015
            goto L_0x003f
        L_0x0015:
            android.support.v4.util.LongSparseArray r2 = r6.awH()     // Catch:{ Exception -> 0x003d }
            r3 = 0
        L_0x001a:
            int r4 = r0.size()     // Catch:{ Exception -> 0x003d }
            if (r3 >= r4) goto L_0x003d
            java.lang.Object r4 = r0.get(r3)     // Catch:{ Exception -> 0x003d }
            java.lang.Long r4 = (java.lang.Long) r4     // Catch:{ Exception -> 0x003d }
            long r4 = r4.longValue()     // Catch:{ Exception -> 0x003d }
            java.lang.Object r4 = r2.get(r4)     // Catch:{ Exception -> 0x003d }
            com.introvd.template.sdk.model.editor.EffectInfoModel r4 = (com.introvd.template.sdk.model.editor.EffectInfoModel) r4     // Catch:{ Exception -> 0x003d }
            java.lang.String r4 = r4.mPath     // Catch:{ Exception -> 0x003d }
            boolean r4 = r7.equals(r4)     // Catch:{ Exception -> 0x003d }
            if (r4 == 0) goto L_0x003a
            monitor-exit(r6)
            return r3
        L_0x003a:
            int r3 = r3 + 1
            goto L_0x001a
        L_0x003d:
            monitor-exit(r6)
            return r1
        L_0x003f:
            monitor-exit(r6)
            return r1
        L_0x0041:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.template.p409g.C8759b.mo35208qC(java.lang.String):int");
    }

    /* renamed from: qD */
    public String mo35209qD(String str) {
        return mo35211qH(mo35208qC(str));
    }

    /* renamed from: qG */
    public String mo35210qG(int i) {
        EffectInfoModel vh = mo35214vh(i);
        if (vh == null) {
            return null;
        }
        return vh.mPath;
    }

    /* renamed from: qH */
    public String mo35211qH(int i) {
        EffectInfoModel vh = mo35214vh(i);
        if (vh == null) {
            return null;
        }
        return vh.mName;
    }

    public synchronized void unInit() {
        unInit(false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0043, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void unInit(boolean r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            r3 = 0
            r2.mbInited = r3     // Catch:{ all -> 0x0044 }
            android.support.v4.util.LongSparseArray<com.introvd.template.sdk.model.editor.EffectInfoModel> r3 = r2.dzW     // Catch:{ all -> 0x0044 }
            if (r3 == 0) goto L_0x0042
            android.support.v4.util.LongSparseArray<com.introvd.template.sdk.model.editor.EffectInfoModel> r3 = r2.dzW     // Catch:{ all -> 0x0044 }
            int r3 = r3.size()     // Catch:{ all -> 0x0044 }
            if (r3 != 0) goto L_0x0011
            goto L_0x0042
        L_0x0011:
            android.support.v4.util.LongSparseArray<com.introvd.template.sdk.model.editor.EffectInfoModel> r3 = r2.dzW     // Catch:{ all -> 0x0044 }
            r3.clear()     // Catch:{ all -> 0x0044 }
            android.support.v4.util.LongSparseArray<com.introvd.template.sdk.model.editor.EffectInfoModel> r3 = r2.dzX     // Catch:{ all -> 0x0044 }
            r3.clear()     // Catch:{ all -> 0x0044 }
            java.util.Map<java.lang.String, java.lang.ref.SoftReference<android.graphics.Bitmap>> r3 = r2.bVw     // Catch:{ all -> 0x0044 }
            boolean r3 = r3.isEmpty()     // Catch:{ all -> 0x0044 }
            if (r3 != 0) goto L_0x0028
            java.util.Map<java.lang.String, java.lang.ref.SoftReference<android.graphics.Bitmap>> r3 = r2.bVw     // Catch:{ all -> 0x0044 }
            r3.clear()     // Catch:{ all -> 0x0044 }
        L_0x0028:
            java.lang.String r3 = "EffectMgr"
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0044 }
            r0.<init>()     // Catch:{ all -> 0x0044 }
            java.lang.String r1 = "unInit:"
            r0.append(r1)     // Catch:{ all -> 0x0044 }
            int r1 = r2.dAc     // Catch:{ all -> 0x0044 }
            r0.append(r1)     // Catch:{ all -> 0x0044 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0044 }
            com.introvd.template.sdk.utils.C8554j.m25007e(r3, r0)     // Catch:{ all -> 0x0044 }
            monitor-exit(r2)
            return
        L_0x0042:
            monitor-exit(r2)
            return
        L_0x0044:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.template.p409g.C8759b.unInit(boolean):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0049, code lost:
        return r0;
     */
    /* renamed from: vh */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized com.introvd.template.sdk.model.editor.EffectInfoModel mo35214vh(int r5) {
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
            com.introvd.template.sdk.model.editor.EffectInfoModel r0 = (com.introvd.template.sdk.model.editor.EffectInfoModel) r0     // Catch:{ all -> 0x004a }
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
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.template.p409g.C8759b.mo35214vh(int):com.introvd.template.sdk.model.editor.EffectInfoModel");
    }

    /* renamed from: vi */
    public synchronized long mo35215vi(int i) {
        EffectInfoModel vh = mo35214vh(i);
        if (vh == null) {
            return -1;
        }
        return vh.mTemplateId;
    }

    /* renamed from: vj */
    public Bitmap mo35216vj(int i) {
        return mo35193N(i, C8536m.cnS, C8536m.cnT);
    }
}
