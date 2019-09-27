package com.introvd.template.editor.widget.timeline;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.SparseArray;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.crash.C5523b;
import com.introvd.template.editor.videotrim.p288b.C6966f;
import com.introvd.template.sdk.model.editor.ThumbInfo;
import com.introvd.template.sdk.utils.C8572y;
import com.introvd.template.sdk.utils.p394b.C8540q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import p037b.p050b.C1834l;
import p037b.p050b.C1842q;
import p037b.p050b.p051a.p053b.C1487a;
import p037b.p050b.p054b.C1495b;
import p037b.p050b.p057e.C1517e;
import p037b.p050b.p076j.C1820a;
import xiaoying.engine.clip.QClip;
import xiaoying.engine.storyboard.QStoryboard;
import xiaoying.utils.QAndroidBitmapFactory;
import xiaoying.utils.QBitmap;
import xiaoying.utils.QBitmapFactory;
import xiaoying.utils.QColorSpace;

/* renamed from: com.introvd.template.editor.widget.timeline.c */
public class C7125c {
    private static volatile C7125c dvH;
    /* access modifiers changed from: private */
    public int aaE = 0;
    /* access modifiers changed from: private */
    public volatile boolean cEk = false;
    /* access modifiers changed from: private */
    public int cEl = -1;
    /* access modifiers changed from: private */
    public boolean cuY = false;
    /* access modifiers changed from: private */
    public C6966f cul;
    /* access modifiers changed from: private */
    public Config cum = Config.ARGB_8888;
    /* access modifiers changed from: private */
    public volatile SparseArray<ArrayList<ThumbInfo>> cup;
    QBitmap dvI;
    /* access modifiers changed from: private */
    public volatile boolean dvJ = true;
    /* access modifiers changed from: private */
    public C7128a dvK;
    /* access modifiers changed from: private */
    public QClip mClip;

    /* renamed from: com.introvd.template.editor.widget.timeline.c$a */
    public class C7128a extends Thread {
        C7128a() {
        }

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:51:0x00f4 */
        /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
        /* JADX WARNING: Removed duplicated region for block: B:54:0x00fc A[Catch:{ Exception -> 0x0145 }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r11 = this;
                xiaoying.utils.QRect r0 = new xiaoying.utils.QRect
                int r1 = com.introvd.template.editor.widget.timeline.C7116a.cuf
                int r2 = com.introvd.template.editor.widget.timeline.C7116a.cuf
                r3 = 0
                r0.<init>(r3, r3, r1, r2)
                int r1 = com.introvd.template.editor.widget.timeline.C7116a.cuf
                int r2 = com.introvd.template.editor.widget.timeline.C7116a.cuf
                int r4 = xiaoying.utils.QColorSpace.QPAF_RGB32_A8R8G8B8
                xiaoying.utils.QBitmap r1 = xiaoying.utils.QBitmapFactory.createQBitmapBlank(r1, r2, r4)
                if (r1 != 0) goto L_0x0028
                com.introvd.template.editor.widget.timeline.c r0 = com.introvd.template.editor.widget.timeline.C7125c.this
                xiaoying.engine.clip.QClip r0 = r0.mClip
                if (r0 == 0) goto L_0x0027
                com.introvd.template.editor.widget.timeline.c r0 = com.introvd.template.editor.widget.timeline.C7125c.this
                xiaoying.engine.clip.QClip r0 = r0.mClip
                r0.destroyThumbnailManager()
            L_0x0027:
                return
            L_0x0028:
                r2 = 0
            L_0x0029:
                com.introvd.template.editor.widget.timeline.c r4 = com.introvd.template.editor.widget.timeline.C7125c.this
                boolean r4 = r4.dvJ
                r5 = 0
                if (r4 == 0) goto L_0x00f4
                com.introvd.template.editor.widget.timeline.c r4 = com.introvd.template.editor.widget.timeline.C7125c.this
                boolean r4 = r4.cEk
                r6 = 100
                if (r4 == 0) goto L_0x0044
                java.lang.Thread.sleep(r6)     // Catch:{ InterruptedException -> 0x0040 }
                goto L_0x0044
            L_0x0040:
                r4 = move-exception
                r4.printStackTrace()
            L_0x0044:
                com.introvd.template.editor.widget.timeline.c r4 = com.introvd.template.editor.widget.timeline.C7125c.this
                boolean r4 = r4.cuY
                if (r4 == 0) goto L_0x004e
                goto L_0x00f4
            L_0x004e:
                com.introvd.template.editor.widget.timeline.c r4 = com.introvd.template.editor.widget.timeline.C7125c.this
                int r4 = r4.aaE
                r8 = 1
                if (r2 < r4) goto L_0x005c
                com.introvd.template.editor.widget.timeline.c r4 = com.introvd.template.editor.widget.timeline.C7125c.this
                r4.cuY = r8
            L_0x005c:
                com.introvd.template.editor.widget.timeline.c r4 = com.introvd.template.editor.widget.timeline.C7125c.this
                com.introvd.template.editor.widget.timeline.c r9 = com.introvd.template.editor.widget.timeline.C7125c.this
                int r9 = r9.cEl
                int r9 = r9 - r8
                int r9 = r9 * 3000
                int r4 = r4.m21080lN(r9)
                r8 = -1
                if (r4 != r8) goto L_0x0074
                com.introvd.template.editor.widget.timeline.c r4 = com.introvd.template.editor.widget.timeline.C7125c.this
                int r4 = r4.acs()
            L_0x0074:
                java.lang.StringBuilder r9 = new java.lang.StringBuilder
                r9.<init>()
                java.lang.String r10 = "iCurDecodeIdentifier="
                r9.append(r10)
                r9.append(r4)
                java.lang.String r9 = r9.toString()
                com.introvd.template.common.LogUtilsV2.m14227d(r9)
                if (r4 == r8) goto L_0x00df
                com.introvd.template.editor.widget.timeline.c r8 = com.introvd.template.editor.widget.timeline.C7125c.this
                android.util.SparseArray r8 = r8.cup
                if (r8 == 0) goto L_0x00b9
                com.introvd.template.editor.widget.timeline.c r8 = com.introvd.template.editor.widget.timeline.C7125c.this
                android.util.SparseArray r8 = r8.cup
                java.lang.Object r8 = r8.get(r4)
                java.util.ArrayList r8 = (java.util.ArrayList) r8
                if (r8 == 0) goto L_0x00ce
                com.introvd.template.editor.widget.timeline.c r9 = com.introvd.template.editor.widget.timeline.C7125c.this
                android.graphics.Bitmap r8 = r9.m21073g(r8)
                if (r8 == 0) goto L_0x00ce
                boolean r9 = r8.isRecycled()
                if (r9 != 0) goto L_0x00ce
                com.introvd.template.editor.widget.timeline.c r9 = com.introvd.template.editor.widget.timeline.C7125c.this
                boolean r8 = r9.m21068c(r4, r8)
                if (r8 == 0) goto L_0x00ce
                int r2 = r2 + 1
                goto L_0x00ce
            L_0x00b9:
                com.introvd.template.editor.widget.timeline.c r8 = com.introvd.template.editor.widget.timeline.C7125c.this
                boolean r8 = r8.m21063a(r1, r4)
                if (r8 != 0) goto L_0x00c4
                r1.fillColor(r3, r0, r5, r3)
            L_0x00c4:
                com.introvd.template.editor.widget.timeline.c r8 = com.introvd.template.editor.widget.timeline.C7125c.this
                boolean r8 = r8.m21066b(r4, r1)
                if (r8 == 0) goto L_0x00ce
                int r2 = r2 + 1
            L_0x00ce:
                org.greenrobot.eventbus.c r8 = org.greenrobot.eventbus.C10021c.aZH()     // Catch:{ Exception | InterruptedException -> 0x00f4 }
                com.introvd.template.editor.widget.timeline.g r9 = new com.introvd.template.editor.widget.timeline.g     // Catch:{ Exception | InterruptedException -> 0x00f4 }
                r9.<init>(r4)     // Catch:{ Exception | InterruptedException -> 0x00f4 }
                r8.mo38492aA(r9)     // Catch:{ Exception | InterruptedException -> 0x00f4 }
                java.lang.Thread.sleep(r6)     // Catch:{ Exception | InterruptedException -> 0x00f4 }
                goto L_0x0029
            L_0x00df:
                r4 = 0
            L_0x00e0:
                r8 = 10
                if (r4 >= r8) goto L_0x0029
                java.lang.Thread.sleep(r6)     // Catch:{  }
                com.introvd.template.editor.widget.timeline.c r8 = com.introvd.template.editor.widget.timeline.C7125c.this     // Catch:{  }
                boolean r8 = r8.dvJ     // Catch:{  }
                if (r8 != 0) goto L_0x00f1
                goto L_0x0029
            L_0x00f1:
                int r4 = r4 + 1
                goto L_0x00e0
            L_0x00f4:
                com.introvd.template.editor.widget.timeline.c r0 = com.introvd.template.editor.widget.timeline.C7125c.this     // Catch:{ Exception -> 0x0145 }
                xiaoying.engine.clip.QClip r0 = r0.mClip     // Catch:{ Exception -> 0x0145 }
                if (r0 == 0) goto L_0x012d
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0145 }
                r0.<init>()     // Catch:{ Exception -> 0x0145 }
                java.lang.String r2 = "destroyThumbnailManager mClip="
                r0.append(r2)     // Catch:{ Exception -> 0x0145 }
                com.introvd.template.editor.widget.timeline.c r2 = com.introvd.template.editor.widget.timeline.C7125c.this     // Catch:{ Exception -> 0x0145 }
                xiaoying.engine.clip.QClip r2 = r2.mClip     // Catch:{ Exception -> 0x0145 }
                r0.append(r2)     // Catch:{ Exception -> 0x0145 }
                java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0145 }
                com.introvd.template.common.LogUtilsV2.m14227d(r0)     // Catch:{ Exception -> 0x0145 }
                com.introvd.template.editor.widget.timeline.c r0 = com.introvd.template.editor.widget.timeline.C7125c.this     // Catch:{ Exception -> 0x0145 }
                xiaoying.engine.clip.QClip r0 = r0.mClip     // Catch:{ Exception -> 0x0145 }
                r0.destroyThumbnailManager()     // Catch:{ Exception -> 0x0145 }
                com.introvd.template.editor.widget.timeline.c r0 = com.introvd.template.editor.widget.timeline.C7125c.this     // Catch:{ Exception -> 0x0145 }
                xiaoying.engine.clip.QClip r0 = r0.mClip     // Catch:{ Exception -> 0x0145 }
                r0.unInit()     // Catch:{ Exception -> 0x0145 }
                com.introvd.template.editor.widget.timeline.c r0 = com.introvd.template.editor.widget.timeline.C7125c.this     // Catch:{ Exception -> 0x0145 }
                r0.mClip = r5     // Catch:{ Exception -> 0x0145 }
            L_0x012d:
                com.introvd.template.editor.widget.timeline.c r0 = com.introvd.template.editor.widget.timeline.C7125c.this     // Catch:{ Exception -> 0x0145 }
                xiaoying.utils.QBitmap r0 = r0.dvI     // Catch:{ Exception -> 0x0145 }
                if (r0 == 0) goto L_0x0149
                com.introvd.template.editor.widget.timeline.c r0 = com.introvd.template.editor.widget.timeline.C7125c.this     // Catch:{ Exception -> 0x0145 }
                xiaoying.utils.QBitmap r0 = r0.dvI     // Catch:{ Exception -> 0x0145 }
                boolean r0 = r0.isRecycled()     // Catch:{ Exception -> 0x0145 }
                if (r0 != 0) goto L_0x0149
                com.introvd.template.editor.widget.timeline.c r0 = com.introvd.template.editor.widget.timeline.C7125c.this     // Catch:{ Exception -> 0x0145 }
                xiaoying.utils.QBitmap r0 = r0.dvI     // Catch:{ Exception -> 0x0145 }
                r0.recycle()     // Catch:{ Exception -> 0x0145 }
                goto L_0x0149
            L_0x0145:
                r0 = move-exception
                r0.printStackTrace()
            L_0x0149:
                if (r1 == 0) goto L_0x0154
                boolean r0 = r1.isRecycled()
                if (r0 != 0) goto L_0x0154
                r1.recycle()
            L_0x0154:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.editor.widget.timeline.C7125c.C7128a.run():void");
        }

        public synchronized void start() {
            super.start();
        }
    }

    private C7125c() {
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0015, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0017, code lost:
        return false;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean m21063a(xiaoying.utils.QBitmap r3, int r4) {
        /*
            r2 = this;
            monitor-enter(r2)
            com.introvd.template.editor.videotrim.b.f r0 = r2.cul     // Catch:{ all -> 0x0018 }
            r1 = 0
            if (r0 == 0) goto L_0x0016
            xiaoying.engine.clip.QClip r0 = r2.mClip     // Catch:{ all -> 0x0018 }
            if (r0 != 0) goto L_0x000b
            goto L_0x0016
        L_0x000b:
            xiaoying.engine.clip.QClip r0 = r2.mClip     // Catch:{ all -> 0x0018 }
            int r3 = com.introvd.template.sdk.utils.C8572y.m25063a(r0, r3, r4, r1)     // Catch:{ all -> 0x0018 }
            if (r3 != 0) goto L_0x0014
            r1 = 1
        L_0x0014:
            monitor-exit(r2)
            return r1
        L_0x0016:
            monitor-exit(r2)
            return r1
        L_0x0018:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.editor.widget.timeline.C7125c.m21063a(xiaoying.utils.QBitmap, int):boolean");
    }

    private Bitmap acr() {
        try {
            Bitmap createBitmap = Bitmap.createBitmap(C7116a.cuf, C7116a.cuf, this.cum);
            if (createBitmap != null) {
                new Canvas(createBitmap).drawColor(0, Mode.CLEAR);
            }
            return createBitmap;
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("error ");
            sb.append(e.getMessage());
            LogUtilsV2.m14227d(sb.toString());
            return null;
        }
    }

    /* access modifiers changed from: private */
    public int acs() {
        if (this.cul == null) {
            return -1;
        }
        return this.cul.acs();
    }

    public static C7125c avE() {
        if (dvH == null) {
            synchronized (C7125c.class) {
                if (dvH == null) {
                    dvH = new C7125c();
                }
            }
        }
        return dvH;
    }

    private void avF() {
        this.dvJ = false;
        this.dvK = null;
        if (this.cup != null) {
            this.cup.clear();
            this.cup = null;
        }
    }

    private void avG() {
        avF();
        if (this.cul != null) {
            this.cul.auz();
            this.cul.mo30638hC(true);
            this.cul = null;
        }
        dvH = null;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public synchronized boolean m21066b(int i, QBitmap qBitmap) {
        if (this.cul == null) {
            return false;
        }
        return this.cul.mo30634b(i, qBitmap);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public synchronized boolean m21068c(int i, Bitmap bitmap) {
        if (!(this.cul == null || bitmap == null)) {
            if (!bitmap.isRecycled()) {
                return this.cul.mo30635c(i, bitmap);
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: dc */
    public int m21070dc(int i, int i2) {
        return (i / 3000) + (i2 > 0 ? 1 : 0);
    }

    public static void destroy() {
        avE().avG();
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public Bitmap m21073g(ArrayList<ThumbInfo> arrayList) {
        RectF rectF = new RectF();
        Rect rect = new Rect();
        Bitmap bitmap = null;
        if (arrayList != null && arrayList.size() > 1) {
            Bitmap acr = acr();
            if (acr == null) {
                return null;
            }
            Canvas canvas = new Canvas(acr);
            Iterator it = arrayList.iterator();
            int i = 0;
            while (it.hasNext()) {
                ThumbInfo thumbInfo = (ThumbInfo) it.next();
                int duration = (thumbInfo.getDuration() * C7116a.cuf) / 3000;
                if (duration > C7116a.cuf) {
                    duration = C7116a.cuf;
                }
                Bitmap kI = m21079kI(thumbInfo.getPosition());
                if (kI != null) {
                    rectF.left = (float) i;
                    rectF.right = (float) C7116a.cuf;
                    rectF.top = 0.0f;
                    rectF.bottom = (float) C7116a.cuf;
                    rect.left = 0;
                    rect.right = C7116a.cuf - i;
                    rect.top = 0;
                    rect.bottom = C7116a.cuf;
                    if (rect.width() > 0 && rectF.width() > 0.0f) {
                        canvas.drawBitmap(kI, rect, rectF, null);
                    }
                    i += duration;
                }
            }
            canvas.save();
            bitmap = acr;
        } else if (arrayList != null && arrayList.size() > 0) {
            bitmap = m21079kI(((ThumbInfo) arrayList.get(0)).getPosition());
        }
        return bitmap;
    }

    /* renamed from: kI */
    private Bitmap m21079kI(int i) {
        Bitmap bitmap = null;
        if (this.mClip == null) {
            return null;
        }
        if (this.dvI == null || this.dvI.isRecycled()) {
            this.dvI = QBitmapFactory.createQBitmapBlank(C7116a.cuf, C7116a.cuf, QColorSpace.QPAF_RGB32_A8R8G8B8);
        }
        if (C8572y.m25063a(this.mClip, this.dvI, i, false) == 0) {
            try {
                bitmap = Bitmap.createBitmap(C7116a.cuf, C7116a.cuf, this.cum);
            } catch (Exception e) {
                C5523b.logException(e.fillInStackTrace());
            }
            QAndroidBitmapFactory.transformQBitmapIntoBitmap(this.dvI, bitmap);
        }
        return bitmap;
    }

    /* access modifiers changed from: private */
    /* renamed from: lN */
    public int m21080lN(int i) {
        if (this.cul == null) {
            return -1;
        }
        return this.cul.mo30639lN(i);
    }

    /* renamed from: r */
    public static void m21081r(QStoryboard qStoryboard) {
        avE().avG();
        avE().m21082s(qStoryboard);
    }

    /* renamed from: s */
    private void m21082s(final QStoryboard qStoryboard) {
        if (qStoryboard != null) {
            C1834l.m5257ah(Boolean.valueOf(true)).mo10157d(C1820a.aVh()).mo10152c(C1820a.aVh()).mo10161e((C1517e<? super T>) new C1517e<Boolean>() {
                /* renamed from: d */
                public void accept(Boolean bool) {
                    QClip dataClip = qStoryboard.getDataClip();
                    C7125c.this.mClip = new QClip();
                    dataClip.duplicate(C7125c.this.mClip);
                    if (C7125c.this.mClip != null) {
                        int duration = qStoryboard.getDuration();
                        C7125c.this.aaE = C7125c.this.m21070dc(duration, duration % 3000);
                        if (C7125c.this.aaE > 0) {
                            C7125c.this.cul = new C6966f(C7116a.cuf, C7116a.cuf, C7125c.this.cum);
                            while (C7125c.this.cul.getSize() < C7125c.this.aaE) {
                                C7125c.this.cul.mo30641pY(-1);
                            }
                            C7125c.this.cul.mo30640pX(3000);
                            C7125c.this.cul.mo30636db(0, C7125c.this.aaE * 3000);
                        }
                        C7125c.this.cup = C8540q.m24952f(qStoryboard, C7125c.this.aaE, 3000);
                        C7125c.this.mClip.createThumbnailManager(C8572y.m25087dI(C8572y.m25087dI(C7116a.cuf, 4), 4), C8572y.m25087dI(C8572y.m25087dI(C7116a.cuf, 4), 4), 65538, true, false);
                    }
                }
            }).mo10164f(100, TimeUnit.MILLISECONDS).mo10152c(C1487a.aUa()).mo10149b((C1842q<? super T>) new C1842q<Boolean>() {
                /* renamed from: a */
                public void mo9877a(C1495b bVar) {
                }

                /* renamed from: b */
                public void mo9886K(Boolean bool) {
                    C7125c.this.dvK = new C7128a();
                    C7125c.this.dvK.start();
                }

                public void onComplete() {
                }

                public void onError(Throwable th) {
                }
            });
        }
    }

    /* renamed from: eO */
    public void mo31583eO(boolean z) {
        this.cEk = z;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: kH */
    public Bitmap mo31584kH(int i) {
        if (this.cul == null) {
            return null;
        }
        int auA = (i * 3000) + this.cul.auA();
        Bitmap pZ = this.cul.mo30642pZ(auA);
        if (pZ == null) {
            pZ = this.cul.mo30643qa(auA);
        }
        return pZ;
    }

    /* renamed from: lR */
    public void mo31585lR(int i) {
        this.cEl = i;
    }
}
