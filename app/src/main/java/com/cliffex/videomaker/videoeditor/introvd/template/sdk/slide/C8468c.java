package com.introvd.template.sdk.slide;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import com.introvd.template.sdk.C8401d;
import com.introvd.template.sdk.C8410e;
import com.introvd.template.sdk.editor.cache.C8443d;
import com.introvd.template.sdk.model.editor.DataItemProject;
import com.introvd.template.sdk.p380a.C8381b;
import com.introvd.template.sdk.p384d.C8402a;
import com.introvd.template.sdk.p384d.C8403b;
import com.introvd.template.sdk.p384d.C8404c;
import com.introvd.template.sdk.p391g.C8451b;
import com.introvd.template.sdk.slide.p392a.C8461b;
import com.introvd.template.sdk.slide.p392a.C8461b.C8465c;
import com.introvd.template.sdk.slide.p392a.C8466c;
import com.introvd.template.sdk.utils.C8548e;
import com.introvd.template.sdk.utils.C8553i;
import com.introvd.template.sdk.utils.C8554j;
import com.introvd.template.sdk.utils.C8565t;
import com.introvd.template.sdk.utils.C8572y;
import com.introvd.template.sdk.utils.VeMSize;
import com.introvd.template.sdk.utils.p393a.C8484b;
import com.introvd.template.sdk.utils.p394b.C8501a;
import com.vivavideo.mobile.h5core.refresh.H5PullHeader;
import java.io.File;
import java.io.FilenameFilter;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import xiaoying.engine.base.IQSessionStateListener;
import xiaoying.engine.base.QSessionState;
import xiaoying.engine.clip.QFade;
import xiaoying.engine.slideshowsession.QSlideShowSession;
import xiaoying.engine.storyboard.QStoryboard;

@SuppressLint({"UseValueOf"})
/* renamed from: com.introvd.template.sdk.slide.c */
public class C8468c extends C8381b<C8467b> {
    private static volatile C8468c efL;
    private HashMap<String, C8474c> efE = new HashMap<>();
    private C8473b efF;
    private boolean efG = false;
    /* access modifiers changed from: private */
    public volatile boolean efH = false;
    private C8472a efI = null;
    private boolean efJ = false;
    private IQSessionStateListener efK = new IQSessionStateListener() {
        public int onSessionStatus(QSessionState qSessionState) {
            return 0;
        }
    };

    /* renamed from: com.introvd.template.sdk.slide.c$a */
    private static class C8472a extends Handler {
        private Context context;
        WeakReference<C8501a> cta;
        WeakReference<C8468c> efP;
        private int efQ;
        private int efR;
        private boolean efS;

        public void handleMessage(Message message) {
            int i;
            if (!this.efS) {
                C8468c cVar = (C8468c) this.efP.get();
                if (cVar != null) {
                    int i2 = message.what;
                    if (i2 != 1111) {
                        switch (i2) {
                            case 268443649:
                                cVar.mo34604a(this.efQ, (Handler) this);
                                break;
                            case 268443650:
                            case 268443651:
                                break;
                            default:
                                switch (i2) {
                                    case 268443657:
                                    case 268443658:
                                        synchronized (this) {
                                            if (this.efQ < this.efR) {
                                                this.efQ++;
                                                i = this.efQ;
                                            } else {
                                                i = -1;
                                            }
                                        }
                                        if (i != -1) {
                                            C8467b uj = cVar.mo34612uj(i);
                                            if (!(uj == null || uj.mProjectDataItem == null)) {
                                                cVar.mo34602a(this.context, uj.mProjectDataItem.strPrjURL, (C8501a) this.cta.get(), (Handler) this);
                                                break;
                                            }
                                        }
                                        break;
                                }
                        }
                    } else {
                        C8467b uj2 = cVar.mo34612uj(this.efQ);
                        if (!(uj2 == null || uj2.mProjectDataItem == null)) {
                            cVar.mo34602a(this.context, uj2.mProjectDataItem.strPrjURL, (C8501a) this.cta.get(), (Handler) this);
                        }
                    }
                }
            }
        }

        /* renamed from: jr */
        public void mo34618jr(boolean z) {
            this.efS = z;
        }
    }

    /* renamed from: com.introvd.template.sdk.slide.c$b */
    private class C8473b extends C8484b<Void, Void, Integer> {
        private WeakReference<Handler> csZ = null;
        private WeakReference<C8443d> efT;
        private WeakReference<C8467b> efU;

        public C8473b(C8467b bVar, Handler handler) {
            this.efU = new WeakReference<>(bVar);
            this.efT = new WeakReference<>(bVar.mClipModelCacheList);
            if (handler != null) {
                this.csZ = new WeakReference<>(handler);
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: c */
        public Integer doInBackground(Void... voidArr) {
            if (this.efT == null) {
                return Integer.valueOf(-1);
            }
            C8443d dVar = (C8443d) this.efT.get();
            return dVar != null ? Integer.valueOf(dVar.getCount()) : Integer.valueOf(-1);
        }

        /* access modifiers changed from: protected */
        /* renamed from: l */
        public void onPostExecute(Integer num) {
            super.onPostExecute(num);
            C8467b bVar = (C8467b) this.efU.get();
            synchronized (C8468c.this) {
                if (bVar != null) {
                    try {
                        bVar.setCacheFlag(8, true);
                    } catch (Throwable th) {
                        while (true) {
                            throw th;
                        }
                    }
                }
            }
            if (this.csZ != null) {
                Handler handler = (Handler) this.csZ.get();
                if (handler != null) {
                    handler.sendEmptyMessage(num.intValue() >= 0 ? 268443657 : 268443658);
                }
            }
        }

        /* access modifiers changed from: protected */
        public void onCancelled() {
            C8467b bVar = (C8467b) this.efU.get();
            synchronized (C8468c.this) {
                if (bVar != null) {
                    try {
                        bVar.setCacheFlag(12, false);
                    } catch (Throwable th) {
                        while (true) {
                            throw th;
                        }
                    }
                }
            }
            if (this.csZ != null) {
                Handler handler = (Handler) this.csZ.get();
                if (handler != null) {
                    handler.sendEmptyMessage(268443658);
                }
            }
            super.onCancelled();
        }
    }

    /* renamed from: com.introvd.template.sdk.slide.c$c */
    private static class C8474c extends Handler {
        private Context context;
        final WeakReference<C8501a> cta;
        final WeakReference<C8468c> efV;
        final String efW;
        boolean efX = false;
        /* access modifiers changed from: private */
        public Handler mHandler = null;

        public C8474c(Context context2, C8468c cVar, C8501a aVar, String str, boolean z, Handler handler, Looper looper) {
            super(looper);
            this.mHandler = handler;
            this.context = context2;
            this.efV = new WeakReference<>(cVar);
            this.cta = new WeakReference<>(aVar);
            this.efW = str;
            this.efX = z;
        }

        /* renamed from: ul */
        private void m24555ul(int i) {
            if (this.mHandler != null) {
                this.mHandler.sendEmptyMessage(i);
            }
        }

        public void handleMessage(Message message) {
            C8468c cVar = (C8468c) this.efV.get();
            if (cVar != null) {
                switch (message.what) {
                    case 268443649:
                        synchronized (cVar) {
                            C8467b nM = cVar.mo34609nM(this.efW);
                            if (nM != null) {
                                boolean z = true;
                                nM.setCacheFlag(2, true);
                                if (message.arg1 != 1) {
                                    z = false;
                                }
                                nM.mo34596jp(z);
                                nM.mo34597jq(message.obj == null ? false : ((Boolean) message.obj).booleanValue());
                                C8410e.aGX().aGZ().setBoolean("pref_res_lost_msg_show", false);
                            }
                        }
                        m24555ul(message.what);
                        C8554j.m25007e("SlideProjectMgr", ">>>>>>>>>> MSG_PROJECT_LOAD_SUCCEEDED");
                        break;
                    case 268443650:
                    case 268443651:
                        synchronized (cVar) {
                            C8467b nM2 = cVar.mo34609nM(this.efW);
                            if (nM2 != null) {
                                nM2.setCacheFlag(3, false);
                                nM2.release();
                                cVar.mo34610nN(this.efW);
                            }
                        }
                        C8554j.m25007e("SlideProjectMgr", ">>>>>>>>>>>>>> MSG_PROJECT_LOAD_CANCELED");
                        m24555ul(message.what);
                        break;
                    case 268443653:
                        C8554j.m25007e("SlideProjectMgr", ">>>>>>>>>>>>>> MSG_PROJECT_SAVE_SUCCEEDED");
                        C8467b nM3 = cVar.mo34609nM(this.efW);
                        if (!TextUtils.isEmpty(this.efW)) {
                            if (this.efX) {
                                cVar.m24530b(this.context, nM3);
                            }
                            m24555ul(message.what);
                            if (this.cta.get() != null) {
                                ((C8501a) this.cta.get()).mo34669jt(false);
                            }
                            cVar.efH = false;
                            break;
                        } else {
                            cVar.efH = false;
                            m24555ul(message.what);
                            break;
                        }
                    case 268443654:
                        C8554j.m25007e("SlideProjectMgr", ">>>>>>>>>>>>>> MSG_PROJECT_SAVE_FAILED");
                        cVar.efH = false;
                        C8565t.show(this.context, C8410e.aGX().aGV(), 0);
                        m24555ul(message.what);
                        break;
                    case 268443655:
                        C8554j.m25007e("SlideProjectMgr", ">>>>>>>>>>>>>> MSG_PROJECT_SAVE_CANCELED");
                        cVar.efH = false;
                        m24555ul(message.what);
                        break;
                }
            }
        }
    }

    private C8468c() {
    }

    /* renamed from: a */
    private int m24524a(Context context, ArrayList<Long> arrayList, String str, int i) {
        if (TextUtils.isEmpty(str) || arrayList == null) {
            return 0;
        }
        int i2 = 0;
        while (!arrayList.isEmpty()) {
            long longValue = ((Long) arrayList.remove(0)).longValue();
            if (C8403b.m24229aZ(longValue) <= 0) {
                String aX = C8402a.m24225aX(longValue);
                if (!TextUtils.isEmpty(aX)) {
                    if (aX.contains(".media/")) {
                        if ((i & 1) != 0) {
                            C8548e.deleteFile(aX);
                        }
                    } else if ((i & 2) != 0) {
                        C8548e.deleteFile(aX);
                        mo33887ck(context, aX);
                    }
                }
                C8402a.m24226aY(longValue);
                i2++;
            }
        }
        File file = new File(str);
        if (file.exists() && file.isDirectory() && (i & 1) == 1) {
            C8548e.deleteDirectory(file.getAbsolutePath());
        }
        return i2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0045, code lost:
        if (r0 != null) goto L_0x0047;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        r0.recycle();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x005c, code lost:
        if (android.text.TextUtils.isEmpty(r9.mProjectDataItem.strCoverURL) != false) goto L_0x009c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0066, code lost:
        if (com.introvd.template.sdk.utils.C8548e.isFileExisted(r9.mProjectDataItem.strCoverURL) == false) goto L_0x009c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0068, code lost:
        com.introvd.template.sdk.utils.C8548e.deleteFile(r9.mProjectDataItem.strCoverURL);
        com.introvd.template.sdk.utils.C8548e.copyFile(r9.mProjectDataItem.strPrjThumbnail, r9.mProjectDataItem.strCoverURL);
        r9.mProjectDataItem.strExtra = com.introvd.template.sdk.utils.C8558m.m25023k(r9.mProjectDataItem.strExtra, 0);
        r8 = com.introvd.template.common.bitmapfun.util.ImageWorkerFactory.CreateImageWorker(r8, 120, 120, "cover_thumb", 0);
        r8.setImageFadeIn(2);
        r8.removeBitmapFromCache(r9.mProjectDataItem.strCoverURL, true);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x009d, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00a8, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void m24526a(android.content.Context r8, com.introvd.template.sdk.slide.C8467b r9) {
        /*
            r7 = this;
            monitor-enter(r7)
            if (r9 == 0) goto L_0x00a7
            xiaoying.engine.slideshowsession.QSlideShowSession r0 = r9.dfW     // Catch:{ all -> 0x00a4 }
            if (r0 == 0) goto L_0x00a7
            com.introvd.template.sdk.model.editor.DataItemProject r0 = r9.mProjectDataItem     // Catch:{ all -> 0x00a4 }
            if (r0 == 0) goto L_0x00a7
            com.introvd.template.sdk.model.editor.DataItemProject r0 = r9.mProjectDataItem     // Catch:{ all -> 0x00a4 }
            int r0 = r0.iPrjClipCount     // Catch:{ all -> 0x00a4 }
            if (r0 != 0) goto L_0x0013
            goto L_0x00a7
        L_0x0013:
            r0 = 0
            r1 = 640(0x280, float:8.97E-43)
            r2 = 360(0x168, float:5.04E-43)
            r3 = 0
            xiaoying.engine.slideshowsession.QSlideShowSession r4 = r9.dfW     // Catch:{ Throwable -> 0x004d }
            xiaoying.engine.slideshowsession.QSlideShowSession$QVirtualSourceInfoNode[] r5 = r4.getVirtualSourceInfoNodeList()     // Catch:{ Throwable -> 0x004d }
            int r6 = r5.length     // Catch:{ Throwable -> 0x004d }
            if (r6 <= 0) goto L_0x003c
            r5 = r5[r3]     // Catch:{ Throwable -> 0x004d }
            java.lang.String r6 = r5.mstrSourceFile     // Catch:{ Throwable -> 0x004d }
            int r5 = r5.mVirtualSrcIndex     // Catch:{ Throwable -> 0x004d }
            xiaoying.engine.slideshowsession.QSlideShowSession$QSourceInfoNode r4 = r4.GetSource(r5)     // Catch:{ Throwable -> 0x004d }
            if (r4 == 0) goto L_0x0036
            int r4 = r4.mRotation     // Catch:{ Throwable -> 0x004d }
            int r5 = com.introvd.template.sdk.slide.p392a.C8466c.m24516nS(r6)     // Catch:{ Throwable -> 0x004d }
            int r4 = r4 - r5
            goto L_0x0037
        L_0x0036:
            r4 = 0
        L_0x0037:
            android.graphics.Bitmap r1 = com.introvd.template.sdk.slide.p392a.C8466c.m24513c(r6, r1, r2, r4)     // Catch:{ Throwable -> 0x004d }
            r0 = r1
        L_0x003c:
            if (r0 == 0) goto L_0x0045
            com.introvd.template.sdk.model.editor.DataItemProject r1 = r9.mProjectDataItem     // Catch:{ Throwable -> 0x004d }
            java.lang.String r1 = r1.strPrjThumbnail     // Catch:{ Throwable -> 0x004d }
            com.introvd.template.sdk.slide.p392a.C8466c.m24514e(r1, r0)     // Catch:{ Throwable -> 0x004d }
        L_0x0045:
            if (r0 == 0) goto L_0x0054
        L_0x0047:
            r0.recycle()     // Catch:{ all -> 0x00a4 }
            goto L_0x0054
        L_0x004b:
            r8 = move-exception
            goto L_0x009e
        L_0x004d:
            r1 = move-exception
            r1.printStackTrace()     // Catch:{ all -> 0x004b }
            if (r0 == 0) goto L_0x0054
            goto L_0x0047
        L_0x0054:
            com.introvd.template.sdk.model.editor.DataItemProject r0 = r9.mProjectDataItem     // Catch:{ all -> 0x00a4 }
            java.lang.String r0 = r0.strCoverURL     // Catch:{ all -> 0x00a4 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x00a4 }
            if (r0 != 0) goto L_0x009c
            com.introvd.template.sdk.model.editor.DataItemProject r0 = r9.mProjectDataItem     // Catch:{ all -> 0x00a4 }
            java.lang.String r0 = r0.strCoverURL     // Catch:{ all -> 0x00a4 }
            boolean r0 = com.introvd.template.sdk.utils.C8548e.isFileExisted(r0)     // Catch:{ all -> 0x00a4 }
            if (r0 == 0) goto L_0x009c
            com.introvd.template.sdk.model.editor.DataItemProject r0 = r9.mProjectDataItem     // Catch:{ all -> 0x00a4 }
            java.lang.String r0 = r0.strCoverURL     // Catch:{ all -> 0x00a4 }
            com.introvd.template.sdk.utils.C8548e.deleteFile(r0)     // Catch:{ all -> 0x00a4 }
            com.introvd.template.sdk.model.editor.DataItemProject r0 = r9.mProjectDataItem     // Catch:{ all -> 0x00a4 }
            java.lang.String r0 = r0.strPrjThumbnail     // Catch:{ all -> 0x00a4 }
            com.introvd.template.sdk.model.editor.DataItemProject r1 = r9.mProjectDataItem     // Catch:{ all -> 0x00a4 }
            java.lang.String r1 = r1.strCoverURL     // Catch:{ all -> 0x00a4 }
            com.introvd.template.sdk.utils.C8548e.copyFile(r0, r1)     // Catch:{ all -> 0x00a4 }
            com.introvd.template.sdk.model.editor.DataItemProject r0 = r9.mProjectDataItem     // Catch:{ all -> 0x00a4 }
            com.introvd.template.sdk.model.editor.DataItemProject r1 = r9.mProjectDataItem     // Catch:{ all -> 0x00a4 }
            java.lang.String r1 = r1.strExtra     // Catch:{ all -> 0x00a4 }
            r4 = 0
            java.lang.String r1 = com.introvd.template.sdk.utils.C8558m.m25023k(r1, r4)     // Catch:{ all -> 0x00a4 }
            r0.strExtra = r1     // Catch:{ all -> 0x00a4 }
            java.lang.String r0 = "cover_thumb"
            r1 = 120(0x78, float:1.68E-43)
            com.introvd.template.common.bitmapfun.util.ImageFetcherWithListener r8 = com.introvd.template.common.bitmapfun.util.ImageWorkerFactory.CreateImageWorker(r8, r1, r1, r0, r3)     // Catch:{ all -> 0x00a4 }
            r0 = 2
            r8.setImageFadeIn(r0)     // Catch:{ all -> 0x00a4 }
            com.introvd.template.sdk.model.editor.DataItemProject r9 = r9.mProjectDataItem     // Catch:{ all -> 0x00a4 }
            java.lang.String r9 = r9.strCoverURL     // Catch:{ all -> 0x00a4 }
            r0 = 1
            r8.removeBitmapFromCache(r9, r0)     // Catch:{ all -> 0x00a4 }
        L_0x009c:
            monitor-exit(r7)
            return
        L_0x009e:
            if (r0 == 0) goto L_0x00a3
            r0.recycle()     // Catch:{ all -> 0x00a4 }
        L_0x00a3:
            throw r8     // Catch:{ all -> 0x00a4 }
        L_0x00a4:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        L_0x00a7:
            monitor-exit(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.sdk.slide.C8468c.m24526a(android.content.Context, com.introvd.template.sdk.slide.b):void");
    }

    public static C8468c aIQ() {
        if (efL == null) {
            efL = new C8468c();
        }
        return efL;
    }

    public static String aIR() {
        return new SimpleDateFormat("'Project'_yyyyMMdd_HHmmss", Locale.US).format(new Date());
    }

    private synchronized int aIU() {
        if (this.efF != null && !this.efF.isCancelled()) {
            this.efF.cancel(true);
            this.efF = null;
        }
        this.efE.clear();
        this.ebS.clear();
        if (this.ebR != null) {
            for (C8467b a : this.ebR) {
                mo34600a(a);
            }
            this.ebR.clear();
            this.ebR = null;
        }
        return 0;
    }

    private void aIV() {
        synchronized (this.ebS) {
            if (this.efI != null) {
                this.efI.mo34618jr(true);
            }
            if (this.efF != null && !this.efF.isCancelled()) {
                this.efF.cancel(true);
                this.efF = null;
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x0194, code lost:
        return 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x016c, code lost:
        return 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x017b, code lost:
        return 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x0186, code lost:
        return 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x018e, code lost:
        return 1;
     */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0136  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0141 A[SYNTHETIC, Splitter:B:62:0x0141] */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized int m24529b(android.content.Context r21, java.lang.String r22, com.introvd.template.sdk.utils.p394b.C8501a r23, android.os.Handler r24) {
        /*
            r20 = this;
            r9 = r20
            r0 = r22
            r10 = r24
            monitor-enter(r20)
            r11 = 1
            if (r23 == 0) goto L_0x0192
            java.util.List r1 = r9.ebR     // Catch:{ all -> 0x018f }
            if (r1 == 0) goto L_0x0192
            java.util.List r1 = r9.ebR     // Catch:{ all -> 0x018f }
            int r1 = r1.size()     // Catch:{ all -> 0x018f }
            if (r1 != 0) goto L_0x0018
            goto L_0x0192
        L_0x0018:
            com.introvd.template.sdk.utils.C8553i.setContext(r21)     // Catch:{ all -> 0x018f }
            r1 = 23
            com.introvd.template.sdk.utils.C8553i.m25005ut(r1)     // Catch:{ all -> 0x018f }
            com.introvd.template.sdk.slide.b r12 = r9.mo34609nM(r0)     // Catch:{ all -> 0x018f }
            r13 = 268443650(0x10002002, float:2.5268207E-29)
            if (r12 == 0) goto L_0x0187
            com.introvd.template.sdk.model.editor.DataItemProject r1 = r12.mProjectDataItem     // Catch:{ all -> 0x018f }
            if (r1 != 0) goto L_0x002f
            goto L_0x0187
        L_0x002f:
            int r1 = r12.getCacheFlag()     // Catch:{ all -> 0x018f }
            r2 = r1 & 2
            r14 = 0
            if (r2 != 0) goto L_0x017c
            r1 = r1 & r11
            if (r1 == 0) goto L_0x003d
            goto L_0x017c
        L_0x003d:
            java.util.HashMap r1 = r9.ebS     // Catch:{ all -> 0x018f }
            int r1 = r1.size()     // Catch:{ all -> 0x018f }
            r15 = 31536000000(0x757b12c00, double:1.55808542072E-313)
            r2 = -1
            r3 = 3
            r5 = 0
            if (r1 < r3) goto L_0x00b1
            java.util.HashMap r1 = r9.ebS     // Catch:{ all -> 0x018f }
            java.util.Set r1 = r1.keySet()     // Catch:{ all -> 0x018f }
            long r6 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x018f }
            r8 = 0
            long r6 = r6 + r15
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x018f }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x018f }
            r7 = r6
            r6 = r5
        L_0x0063:
            boolean r8 = r1.hasNext()     // Catch:{ all -> 0x018f }
            if (r8 == 0) goto L_0x008c
            java.lang.Object r8 = r1.next()     // Catch:{ all -> 0x018f }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ all -> 0x018f }
            java.util.HashMap r11 = r9.ebS     // Catch:{ all -> 0x018f }
            java.lang.Object r11 = r11.get(r8)     // Catch:{ all -> 0x018f }
            com.introvd.template.sdk.slide.b r11 = (com.introvd.template.sdk.slide.C8467b) r11     // Catch:{ all -> 0x018f }
            long r3 = r11.lLastUpdateTime     // Catch:{ all -> 0x018f }
            long r18 = r7.longValue()     // Catch:{ all -> 0x018f }
            int r3 = (r3 > r18 ? 1 : (r3 == r18 ? 0 : -1))
            if (r3 >= 0) goto L_0x0089
            long r3 = r11.lLastUpdateTime     // Catch:{ all -> 0x018f }
            java.lang.Long r3 = java.lang.Long.valueOf(r3)     // Catch:{ all -> 0x018f }
            r7 = r3
            r6 = r8
        L_0x0089:
            r3 = 3
            r11 = 1
            goto L_0x0063
        L_0x008c:
            if (r6 == 0) goto L_0x00b1
            java.util.HashMap r1 = r9.ebS     // Catch:{ all -> 0x018f }
            java.lang.Object r1 = r1.get(r6)     // Catch:{ all -> 0x018f }
            com.introvd.template.sdk.slide.b r1 = (com.introvd.template.sdk.slide.C8467b) r1     // Catch:{ all -> 0x018f }
            if (r1 == 0) goto L_0x00a7
            xiaoying.engine.slideshowsession.QSlideShowSession r3 = r1.dfW     // Catch:{ all -> 0x018f }
            r3.unInit()     // Catch:{ all -> 0x018f }
            r1.dfW = r5     // Catch:{ all -> 0x018f }
            com.introvd.template.sdk.editor.cache.d r3 = r1.mClipModelCacheList     // Catch:{ all -> 0x018f }
            r3.releaseAll()     // Catch:{ all -> 0x018f }
            r1.setCacheFlag(r2, r14)     // Catch:{ all -> 0x018f }
        L_0x00a7:
            java.util.HashMap r1 = r9.ebS     // Catch:{ all -> 0x018f }
            r1.remove(r6)     // Catch:{ all -> 0x018f }
            java.util.HashMap<java.lang.String, com.introvd.template.sdk.slide.c$c> r1 = r9.efE     // Catch:{ all -> 0x018f }
            r1.remove(r6)     // Catch:{ all -> 0x018f }
        L_0x00b1:
            r12.setCacheFlag(r2, r14)     // Catch:{ all -> 0x018f }
            com.introvd.template.sdk.model.editor.DataItemProject r1 = r12.mProjectDataItem     // Catch:{ all -> 0x018f }
            java.lang.String r11 = r1.strPrjURL     // Catch:{ all -> 0x018f }
            xiaoying.engine.slideshowsession.QSlideShowSession r1 = r12.dfW     // Catch:{ all -> 0x018f }
            if (r1 == 0) goto L_0x00c1
            xiaoying.engine.slideshowsession.QSlideShowSession r1 = r12.dfW     // Catch:{ all -> 0x018f }
            r1.unInit()     // Catch:{ all -> 0x018f }
        L_0x00c1:
            xiaoying.engine.slideshowsession.QSlideShowSession r1 = new xiaoying.engine.slideshowsession.QSlideShowSession     // Catch:{ all -> 0x018f }
            r1.<init>()     // Catch:{ all -> 0x018f }
            r12.dfW = r1     // Catch:{ all -> 0x018f }
            xiaoying.engine.slideshowsession.QSlideShowSession r1 = r12.dfW     // Catch:{ all -> 0x018f }
            xiaoying.engine.QEngine r2 = r23.aJv()     // Catch:{ all -> 0x018f }
            xiaoying.engine.base.IQSessionStateListener r3 = r9.efK     // Catch:{ all -> 0x018f }
            int r1 = r1.init(r2, r3)     // Catch:{ all -> 0x018f }
            if (r1 == 0) goto L_0x00e0
            if (r10 == 0) goto L_0x00db
            r10.sendEmptyMessage(r13)     // Catch:{ all -> 0x018f }
        L_0x00db:
            r12.dfW = r5     // Catch:{ all -> 0x018f }
            monitor-exit(r20)
            r0 = 3
            return r0
        L_0x00e0:
            java.lang.String r1 = "SlideProjectMgr"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x018f }
            r2.<init>()     // Catch:{ all -> 0x018f }
            java.lang.String r3 = ">>>>>>>>>>>>>>> updateProjectStoryBoard projectPath="
            r2.append(r3)     // Catch:{ all -> 0x018f }
            r2.append(r11)     // Catch:{ all -> 0x018f }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x018f }
            com.introvd.template.sdk.utils.C8554j.m25007e(r1, r2)     // Catch:{ all -> 0x018f }
            java.util.HashMap<java.lang.String, com.introvd.template.sdk.slide.c$c> r1 = r9.efE     // Catch:{ all -> 0x018f }
            java.lang.Object r1 = r1.get(r11)     // Catch:{ all -> 0x018f }
            com.introvd.template.sdk.slide.c$c r1 = (com.introvd.template.sdk.slide.C8468c.C8474c) r1     // Catch:{ all -> 0x018f }
            if (r1 == 0) goto L_0x0109
            android.os.Handler r2 = r1.mHandler     // Catch:{ all -> 0x018f }
            if (r2 == r10) goto L_0x0107
            goto L_0x0109
        L_0x0107:
            r14 = r1
            goto L_0x0127
        L_0x0109:
            com.introvd.template.sdk.slide.c$c r8 = new com.introvd.template.sdk.slide.c$c     // Catch:{ all -> 0x018f }
            r6 = 0
            android.os.HandlerThread r1 = r9.ebT     // Catch:{ all -> 0x018f }
            android.os.Looper r17 = r1.getLooper()     // Catch:{ all -> 0x018f }
            r1 = r8
            r2 = r21
            r3 = r20
            r4 = r23
            r5 = r11
            r7 = r24
            r14 = r8
            r8 = r17
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x018f }
            java.util.HashMap<java.lang.String, com.introvd.template.sdk.slide.c$c> r1 = r9.efE     // Catch:{ all -> 0x018f }
            r1.put(r11, r14)     // Catch:{ all -> 0x018f }
        L_0x0127:
            com.introvd.template.sdk.slide.d r1 = new com.introvd.template.sdk.slide.d     // Catch:{ all -> 0x018f }
            r1.<init>()     // Catch:{ all -> 0x018f }
            xiaoying.engine.slideshowsession.QSlideShowSession r2 = r12.dfW     // Catch:{ all -> 0x018f }
            r3 = r21
            int r2 = r1.mo34623a(r3, r14, r2)     // Catch:{ all -> 0x018f }
            if (r2 == 0) goto L_0x0141
            if (r10 == 0) goto L_0x013b
            r10.sendEmptyMessage(r13)     // Catch:{ all -> 0x018f }
        L_0x013b:
            r1.unInit()     // Catch:{ all -> 0x018f }
            r0 = 5
            monitor-exit(r20)
            return r0
        L_0x0141:
            long r2 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x018f }
            int r0 = r9.mo33889nt(r0)     // Catch:{ all -> 0x018f }
            int r4 = r9.ebQ     // Catch:{ all -> 0x018f }
            if (r0 != r4) goto L_0x014e
            long r2 = r2 + r15
        L_0x014e:
            r12.lLastUpdateTime = r2     // Catch:{ all -> 0x018f }
            java.util.HashMap r0 = r9.ebS     // Catch:{ all -> 0x018f }
            r0.put(r11, r12)     // Catch:{ all -> 0x018f }
            boolean r0 = com.introvd.template.sdk.utils.C8548e.isFileExisted(r11)     // Catch:{ all -> 0x018f }
            if (r0 == 0) goto L_0x016d
            r0 = 1
            r12.setCacheFlag(r0, r0)     // Catch:{ all -> 0x018f }
            int r0 = r1.mo34624nP(r11)     // Catch:{ all -> 0x018f }
            if (r0 == 0) goto L_0x016a
            if (r10 == 0) goto L_0x016a
            r10.sendEmptyMessage(r13)     // Catch:{ all -> 0x018f }
        L_0x016a:
            monitor-exit(r20)
            r0 = 0
            return r0
        L_0x016d:
            java.lang.String r0 = "SlideProjectMgr"
            java.lang.String r1 = ">>>>>>>>>>>>>> MSG_PROJECT_LOAD_FAILED"
            com.introvd.template.sdk.utils.C8554j.m25007e(r0, r1)     // Catch:{ all -> 0x018f }
            if (r10 == 0) goto L_0x0179
            r10.sendEmptyMessage(r13)     // Catch:{ all -> 0x018f }
        L_0x0179:
            monitor-exit(r20)
            r0 = 1
            return r0
        L_0x017c:
            if (r10 == 0) goto L_0x0184
            r0 = 268443649(0x10002001, float:2.5268204E-29)
            r10.sendEmptyMessage(r0)     // Catch:{ all -> 0x018f }
        L_0x0184:
            monitor-exit(r20)
            r0 = 0
            return r0
        L_0x0187:
            if (r10 == 0) goto L_0x018c
            r10.sendEmptyMessage(r13)     // Catch:{ all -> 0x018f }
        L_0x018c:
            monitor-exit(r20)
            r0 = 1
            return r0
        L_0x018f:
            r0 = move-exception
            monitor-exit(r20)
            throw r0
        L_0x0192:
            monitor-exit(r20)
            r0 = 1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.sdk.slide.C8468c.m24529b(android.content.Context, java.lang.String, com.introvd.template.sdk.utils.b.a, android.os.Handler):int");
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public synchronized void m24530b(Context context, C8467b bVar) {
        try {
            m24526a(context, bVar);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return;
    }

    /* renamed from: i */
    private void m24531i(Context context, long j) {
        C8404c.m24235bd(j);
        int aV = mo33885aV(j);
        if (aV >= 0) {
            mo34613uk(aV);
            if (aV == this.ebQ) {
                this.ebQ = -1;
            } else if (aV < this.ebQ) {
                this.ebQ--;
            }
        }
    }

    /* renamed from: nL */
    public static void m24532nL(String str) {
        if (str != null && str.length() > 0) {
            String parent = new File(str).getParent();
            final String fileName = C8548e.getFileName(str);
            if (str.endsWith(".tmpprj")) {
                C8548e.deleteFile(str);
                StringBuilder sb = new StringBuilder();
                sb.append(parent);
                sb.append(fileName);
                sb.append(".dat");
                C8548e.deleteFile(sb.toString());
                StringBuilder sb2 = new StringBuilder();
                sb2.append(parent);
                sb2.append(fileName);
                sb2.append(".pkg");
                C8548e.deleteFile(sb2.toString());
                StringBuilder sb3 = new StringBuilder();
                sb3.append(parent);
                sb3.append(fileName);
                sb3.append(".dat1");
                C8548e.deleteFile(sb3.toString());
                StringBuilder sb4 = new StringBuilder();
                sb4.append(parent);
                sb4.append(fileName);
                sb4.append(".dat2");
                C8548e.deleteFile(sb4.toString());
            } else {
                C84702 r3 = new FilenameFilter() {
                    public boolean accept(File file, String str) {
                        return str.startsWith(fileName);
                    }
                };
                if (parent != null) {
                    File[] listFiles = new File(parent).listFiles(r3);
                    if (listFiles != null) {
                        for (File absolutePath : listFiles) {
                            C8548e.deleteFile(absolutePath.getAbsolutePath());
                        }
                    }
                }
            }
        }
    }

    /* renamed from: S */
    public synchronized void mo33874S(Context context, boolean z) {
        C8553i.setContext(context);
        C8553i.m25005ut(23);
        if (z) {
            this.efJ = true;
            return;
        }
        ArrayList<C8467b> arrayList = new ArrayList<>();
        long currentTimeMillis = System.currentTimeMillis();
        Iterator it = C8404c.aHH().iterator();
        while (it.hasNext()) {
            C8467b bVar = new C8467b((DataItemProject) it.next(), null);
            if (this.ebR != null && this.ebR.contains(bVar)) {
                bVar = (C8467b) this.ebR.remove(this.ebR.indexOf(bVar));
            }
            arrayList.add(bVar);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("SlideProjectMgr loadData cost:");
        sb.append(System.currentTimeMillis() - currentTimeMillis);
        C8554j.m25008i("SlideProjectMgr", sb.toString());
        if (this.ebR != null) {
            for (C8467b a : this.ebR) {
                mo34600a(a);
            }
            this.ebR.clear();
        } else {
            this.ebR = new ArrayList();
        }
        for (C8467b bVar2 : arrayList) {
            if (C8451b.m24477un(bVar2.mProjectDataItem.prjThemeType)) {
                this.ebR.add(bVar2);
            }
        }
        synchronized (this.ebS) {
            this.efJ = true;
        }
    }

    /* renamed from: a */
    public int mo34599a(Context context, boolean z, C8501a aVar, Handler handler, boolean z2, boolean z3) {
        int i;
        Context context2 = context;
        if (this.efH) {
            return 6;
        }
        int threadPriority = Process.getThreadPriority(Process.myTid());
        if (z2) {
            Process.setThreadPriority(-19);
        }
        C8554j.m25007e("SlideProjectMgr", "defaultSaveProject <---");
        if (!(aVar == null || this.ebQ == -1)) {
            if (this.ebR != null) {
                C8467b uj = mo34612uj(this.ebQ);
                if (uj != null) {
                    if (uj.dfW != null) {
                        if (z || uj.dfW.GetSourceCount() != 0) {
                            try {
                                if (aVar.isProjectModified() || !C8548e.isFileExisted(uj.mProjectDataItem.strPrjURL)) {
                                    Date date = new Date();
                                    String format = new SimpleDateFormat(H5PullHeader.TIME_FORMAT, Locale.US).format(date);
                                    String str = uj.mProjectDataItem.strPrjURL;
                                    if (TextUtils.isEmpty(str)) {
                                        String format2 = new SimpleDateFormat("'Project'_yyyyMMdd_HHmmss", Locale.US).format(date);
                                        uj.mProjectDataItem.strCreateTime = format;
                                        DataItemProject dataItemProject = uj.mProjectDataItem;
                                        StringBuilder sb = new StringBuilder();
                                        sb.append(C8401d.ane());
                                        sb.append(format2);
                                        sb.append(".prj");
                                        dataItemProject.strPrjURL = sb.toString();
                                        str = uj.mProjectDataItem.strPrjURL;
                                        DataItemProject dataItemProject2 = uj.mProjectDataItem;
                                        StringBuilder sb2 = new StringBuilder();
                                        sb2.append(C8401d.ane());
                                        sb2.append(format2);
                                        sb2.append(".jpg");
                                        dataItemProject2.strPrjThumbnail = sb2.toString();
                                    }
                                    String str2 = str;
                                    QStoryboard GetStoryboard = uj.dfW.GetStoryboard();
                                    if (!z3) {
                                        if (GetStoryboard != null) {
                                            uj.mProjectDataItem.iPrjDuration = GetStoryboard.getDuration();
                                            uj.mProjectDataItem.iPrjClipCount = GetStoryboard.getClipCount();
                                        }
                                        uj.mProjectDataItem.usedEffectTempId = uj.dfW.GetTheme();
                                    }
                                    uj.mProjectDataItem.strModifyTime = format;
                                    uj.mProjectDataItem.iIsModified = 1;
                                    try {
                                        i = C8548e.m24998oc(str2.substring(0, str2.lastIndexOf(47) + 1));
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                        i = 0;
                                    }
                                    if (i != 0) {
                                        if (i == 11) {
                                            C8565t.show(context2, C8410e.aGX().aGU(), 0);
                                        } else {
                                            StringBuilder sb3 = new StringBuilder();
                                            sb3.append("defaultSaveProject out case: saveProject failed1 iRes=");
                                            sb3.append(i);
                                            C8554j.m25007e("SlideProjectMgr", sb3.toString());
                                            C8565t.show(context2, C8410e.aGX().aGV(), 0);
                                        }
                                        if (z2) {
                                            Process.setThreadPriority(threadPriority);
                                        }
                                        return 3;
                                    }
                                    String str3 = str2;
                                    C8474c cVar = new C8474c(context, this, aVar, str2, true, handler, this.ebT.getLooper());
                                    C8475d dVar = new C8475d();
                                    int a = dVar.mo34623a(context2, cVar, uj.dfW);
                                    if (a != 0) {
                                        StringBuilder sb4 = new StringBuilder();
                                        sb4.append("defaultSaveProject out case: saveProject failed0 iRes=");
                                        sb4.append(a);
                                        C8554j.m25007e("SlideProjectMgr", sb4.toString());
                                        C8565t.show(context2, C8410e.aGX().aGV(), 0);
                                        if (z2) {
                                            Process.setThreadPriority(threadPriority);
                                        }
                                        return 3;
                                    }
                                    mo33886b(uj.mProjectDataItem, false);
                                    this.efH = true;
                                    int nQ = dVar.mo34625nQ(str3);
                                    if (nQ != 0) {
                                        if (nQ == 8867879) {
                                            C8410e.aGX().aGZ().setBoolean("template_info_miss_in_db_flag", true);
                                        }
                                        StringBuilder sb5 = new StringBuilder();
                                        sb5.append("defaultSaveProject out case: saveProject failed iRes=");
                                        sb5.append(nQ);
                                        C8554j.m25007e("SlideProjectMgr", sb5.toString());
                                        C8565t.show(context2, C8410e.aGX().aGV(), 0);
                                        this.efH = false;
                                        if (z2) {
                                            Process.setThreadPriority(threadPriority);
                                        }
                                        return 3;
                                    }
                                    mo33876a(aHe(), false);
                                    C8403b.m24233bc(uj.mProjectDataItem._id);
                                    C8554j.m25007e("SlideProjectMgr", "defaultSaveProject --->");
                                    if (z2) {
                                        Process.setThreadPriority(threadPriority);
                                    }
                                    return 0;
                                }
                                C8404c.m24239c(uj.mProjectDataItem);
                                if (z2) {
                                    Process.setThreadPriority(threadPriority);
                                }
                                return 5;
                            } catch (Throwable th) {
                                th.printStackTrace();
                                this.efH = false;
                                if (z2) {
                                    Process.setThreadPriority(threadPriority);
                                }
                                return 1;
                            }
                        } else {
                            mo34613uk(this.ebQ);
                            this.ebQ = -1;
                            if (z2) {
                                Process.setThreadPriority(threadPriority);
                            }
                            return 1;
                        }
                    }
                }
                if (z2) {
                    Process.setThreadPriority(threadPriority);
                }
                return 1;
            }
        }
        if (z2) {
            Process.setThreadPriority(threadPriority);
        }
        return 1;
    }

    /* renamed from: a */
    public synchronized int mo34600a(C8467b bVar) {
        if (bVar == null) {
            return 0;
        }
        if (bVar.dfW != null) {
            bVar.dfW.unInit();
            bVar.dfW = null;
        }
        if (bVar.mClipModelCacheList != null) {
            bVar.mClipModelCacheList.releaseAll();
        }
        if (bVar.mProjectDataItem.strPrjURL != null) {
            this.ebS.remove(bVar.mProjectDataItem.strPrjURL);
            this.efE.remove(bVar.mProjectDataItem.strPrjURL);
        }
        bVar.setCacheFlag(-1, false);
        return 0;
    }

    /* renamed from: a */
    public synchronized void mo34601a(int i, C8467b bVar) {
        if (this.ebR != null) {
            this.ebR.add(i, bVar);
        }
    }

    /* renamed from: a */
    public void mo33875a(Context context, String str, int i, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            long nB = C8404c.m24242nB(str);
            if (nB < 0) {
                DataItemProject aHe = aHe();
                if (aHe != null && str.equals(aHe.strPrjURL)) {
                    if (!C8548e.isFileExisted(str)) {
                        nB = 2147483647L;
                    }
                } else {
                    return;
                }
            }
            mo33890o(context.getContentResolver(), str);
            String ou = C8572y.m25097ou(str);
            String ow = C8572y.m25099ow(str);
            ArrayList ba = C8403b.m24231ba(nB);
            if (z) {
                C8403b.m24230b(nB, -1, false);
            }
            m24524a(context, ba, ou, i);
            m24531i(context, nB);
            m24532nL(str);
            if (!TextUtils.isEmpty(ou)) {
                C8548e.deleteDirectory(ou);
            }
            if (!TextUtils.isEmpty(ow)) {
                C8548e.deleteDirectory(ow);
            }
        }
    }

    /* renamed from: a */
    public void mo34602a(Context context, String str, C8501a aVar, Handler handler) {
        final C8467b nM = mo34609nM(str);
        if (aVar != null && nM != null && nM.mProjectDataItem != null) {
            if (handler != this.efI) {
                aIV();
            }
            if (nM.mProjectDataItem.strPrjURL == null || this.ebS.get(nM.mProjectDataItem.strPrjURL) == null) {
                final Context context2 = context;
                final C8501a aVar2 = aVar;
                final Handler handler2 = handler;
                C84713 r0 = new C8484b<Void, Void, Object>() {
                    /* access modifiers changed from: protected */
                    public Object doInBackground(Void... voidArr) {
                        try {
                            C8553i.setContext(context2);
                            C8553i.m25005ut(23);
                            C8468c.this.m24529b(context2, nM.mProjectDataItem.strPrjURL, aVar2, handler2);
                            return null;
                        } catch (Throwable th) {
                            return th;
                        }
                    }

                    /* access modifiers changed from: protected */
                    public void onPostExecute(Object obj) {
                        if ((obj instanceof Throwable) && C8410e.aGX().aGW() > 0) {
                            C8565t.show(context2, C8410e.aGX().aGW(), 1);
                        }
                        super.onPostExecute(obj);
                    }
                };
                r0.mo34652e(new Void[0]);
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (mo33889nt(str) == this.ebQ) {
                currentTimeMillis += 31536000000L;
            }
            nM.lLastUpdateTime = currentTimeMillis;
            if (handler != null) {
                handler.sendEmptyMessage(268443649);
            }
        }
    }

    /* renamed from: a */
    public void mo34603a(C8451b bVar, String str, String str2) {
        DataItemProject dataItemProject = new DataItemProject();
        String format = new SimpleDateFormat(H5PullHeader.TIME_FORMAT, Locale.US).format(new Date());
        dataItemProject.strCreateTime = format;
        dataItemProject.strModifyTime = format;
        dataItemProject.strPrjTitle = "";
        StringBuilder sb = new StringBuilder();
        sb.append(C8401d.ane());
        sb.append(str);
        sb.append(".prj");
        dataItemProject.strPrjURL = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(C8401d.ane());
        sb2.append(str);
        sb2.append(".jpg");
        dataItemProject.strPrjThumbnail = sb2.toString();
        dataItemProject.strExtra = str2;
        dataItemProject.prjThemeType = bVar.code;
        this.ebQ = 0;
        C8467b bVar2 = new C8467b(dataItemProject, null);
        mo34601a(0, bVar2);
        bVar2.dfW = new QSlideShowSession();
        if (bVar2.dfW.init(C8501a.aJs().aJv(), this.efK) == 0 && bVar2.dfW != null) {
            QFade qFade = new QFade();
            qFade.set(0, C8459a.efD.intValue());
            qFade.set(1, 0);
            qFade.set(2, 100);
            bVar2.dfW.setProperty(20486, qFade);
            QFade qFade2 = new QFade();
            qFade2.set(0, C8459a.efD.intValue());
            qFade2.set(1, 100);
            qFade2.set(2, 0);
            bVar2.dfW.setProperty(20487, qFade2);
        }
        C8548e.createMultilevelDirectory(C8572y.m25097ou(dataItemProject.strPrjURL));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:39:0x007b, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x007d, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x007f, code lost:
        return false;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean mo34604a(int r7, android.os.Handler r8) {
        /*
            r6 = this;
            monitor-enter(r6)
            boolean r0 = r6.efG     // Catch:{ all -> 0x0080 }
            r1 = 0
            if (r0 != 0) goto L_0x007e
            java.util.List r0 = r6.ebR     // Catch:{ all -> 0x0080 }
            if (r0 == 0) goto L_0x007e
            if (r7 < 0) goto L_0x007e
            java.util.List r0 = r6.ebR     // Catch:{ all -> 0x0080 }
            int r0 = r0.size()     // Catch:{ all -> 0x0080 }
            if (r7 < r0) goto L_0x0015
            goto L_0x007e
        L_0x0015:
            com.introvd.template.sdk.slide.c$a r0 = r6.efI     // Catch:{ all -> 0x0080 }
            if (r8 == r0) goto L_0x001c
            r6.aIV()     // Catch:{ all -> 0x0080 }
        L_0x001c:
            com.introvd.template.sdk.slide.b r0 = r6.mo34612uj(r7)     // Catch:{ all -> 0x0080 }
            if (r0 == 0) goto L_0x007c
            com.introvd.template.sdk.model.editor.DataItemProject r2 = r0.mProjectDataItem     // Catch:{ all -> 0x0080 }
            if (r2 != 0) goto L_0x0027
            goto L_0x007c
        L_0x0027:
            int r2 = r0.getCacheFlag()     // Catch:{ all -> 0x0080 }
            r3 = r2 & 4
            r4 = 1
            if (r3 != 0) goto L_0x0072
            r2 = r2 & 8
            if (r2 == 0) goto L_0x0035
            goto L_0x0072
        L_0x0035:
            r2 = 12
            r0.setCacheFlag(r2, r1)     // Catch:{ all -> 0x0080 }
            com.introvd.template.sdk.editor.cache.d r2 = r0.mClipModelCacheList     // Catch:{ all -> 0x0080 }
            if (r2 == 0) goto L_0x0043
            com.introvd.template.sdk.editor.cache.d r2 = r0.mClipModelCacheList     // Catch:{ all -> 0x0080 }
            r2.releaseAll()     // Catch:{ all -> 0x0080 }
        L_0x0043:
            r2 = 4
            r0.setCacheFlag(r2, r4)     // Catch:{ all -> 0x0080 }
            java.lang.String r2 = "SlideProjectMgr"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0080 }
            r3.<init>()     // Catch:{ all -> 0x0080 }
            java.lang.String r5 = ">>>>>>>>>>>>>>>>> run mExtractTask. index="
            r3.append(r5)     // Catch:{ all -> 0x0080 }
            r3.append(r7)     // Catch:{ all -> 0x0080 }
            java.lang.String r7 = r3.toString()     // Catch:{ all -> 0x0080 }
            com.introvd.template.sdk.utils.C8554j.m25007e(r2, r7)     // Catch:{ all -> 0x0080 }
            com.introvd.template.sdk.slide.c$b r7 = new com.introvd.template.sdk.slide.c$b     // Catch:{ all -> 0x0080 }
            r7.<init>(r0, r8)     // Catch:{ all -> 0x0080 }
            r6.efF = r7     // Catch:{ all -> 0x0080 }
            com.introvd.template.sdk.slide.c$b r7 = r6.efF     // Catch:{ Exception -> 0x006c }
            java.lang.Void[] r8 = new java.lang.Void[r1]     // Catch:{ Exception -> 0x006c }
            r7.mo34652e(r8)     // Catch:{ Exception -> 0x006c }
            goto L_0x0070
        L_0x006c:
            r7 = move-exception
            r7.printStackTrace()     // Catch:{ all -> 0x0080 }
        L_0x0070:
            monitor-exit(r6)
            return r4
        L_0x0072:
            if (r8 == 0) goto L_0x007a
            r7 = 268443657(0x10002009, float:2.5268228E-29)
            r8.sendEmptyMessage(r7)     // Catch:{ all -> 0x0080 }
        L_0x007a:
            monitor-exit(r6)
            return r4
        L_0x007c:
            monitor-exit(r6)
            return r1
        L_0x007e:
            monitor-exit(r6)
            return r1
        L_0x0080:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.sdk.slide.C8468c.mo34604a(int, android.os.Handler):boolean");
    }

    /* renamed from: a */
    public boolean mo34605a(Context context, C8501a aVar, int i, C8465c cVar) {
        C8467b uj = mo34612uj(i);
        if (uj != null && !TextUtils.isEmpty(uj.mProjectDataItem.strPrjURL)) {
            C8461b bVar = new C8461b(uj, aVar, context);
            bVar.mo34591a(cVar);
            bVar.aIW();
        }
        return true;
    }

    /* renamed from: a */
    public boolean mo33877a(Handler handler, boolean z) {
        return mo34604a(this.ebQ, handler);
    }

    public boolean aHb() {
        return this.efJ;
    }

    public QStoryboard aHd() {
        if (aHf() == null || aHf().dfW == null) {
            return null;
        }
        return aHf().dfW.GetStoryboard();
    }

    public DataItemProject aHe() {
        if (aHf() != null) {
            return aHf().mProjectDataItem;
        }
        return null;
    }

    public void aHg() {
        mo34611nO(".backup");
    }

    /* renamed from: aIS */
    public C8467b aHf() {
        return mo34612uj(this.ebQ);
    }

    public QSlideShowSession aIT() {
        if (aHf() == null || aHf().dfW == null) {
            return null;
        }
        return aHf().dfW;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo33886b(DataItemProject dataItemProject, boolean z) {
        if (dataItemProject == null) {
            return;
        }
        if (dataItemProject.streamWidth == 0 || dataItemProject.streamHeight == 0) {
            VeMSize u = C8466c.m24519u(aHd());
            if (u != null) {
                dataItemProject.streamWidth = u.width;
                dataItemProject.streamHeight = u.height;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0011, code lost:
        if (r3.efJ == false) goto L_0x001a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0019, code lost:
        return r3.ebR.size();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001a, code lost:
        return 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x000d, code lost:
        if (r3.ebR == null) goto L_0x001a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int getCount() {
        /*
            r3 = this;
            java.util.HashMap r0 = r3.ebS
            monitor-enter(r0)
            boolean r1 = r3.efJ     // Catch:{ all -> 0x001b }
            r2 = 0
            if (r1 != 0) goto L_0x000a
            monitor-exit(r0)     // Catch:{ all -> 0x001b }
            return r2
        L_0x000a:
            monitor-exit(r0)     // Catch:{ all -> 0x001b }
            java.util.List r0 = r3.ebR
            if (r0 == 0) goto L_0x001a
            boolean r0 = r3.efJ
            if (r0 == 0) goto L_0x001a
            java.util.List r0 = r3.ebR
            int r0 = r0.size()
            return r0
        L_0x001a:
            return r2
        L_0x001b:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x001b }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.sdk.slide.C8468c.getCount():int");
    }

    public synchronized void init() {
        this.efG = false;
        if (this.ebR == null) {
            this.ebR = new ArrayList();
        }
        if (this.ebT == null) {
            this.ebT = new HandlerThread("SlideProjectMgr");
            this.ebT.start();
        }
    }

    /* renamed from: nM */
    public C8467b mo34609nM(String str) {
        if (this.ebR == null) {
            return null;
        }
        int size = this.ebR.size();
        for (int i = 0; i < size; i++) {
            C8467b bVar = (C8467b) this.ebR.get(i);
            if (bVar.mProjectDataItem != null && bVar.mProjectDataItem.strPrjURL.equals(str)) {
                return bVar;
            }
        }
        return null;
    }

    /* renamed from: nN */
    public synchronized int mo34610nN(String str) {
        boolean z;
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        int count = getCount();
        C8467b bVar = null;
        int i = 0;
        while (true) {
            if (i >= count) {
                z = false;
                break;
            }
            bVar = mo34612uj(i);
            if (bVar != null && bVar.mProjectDataItem.strPrjURL.equals(str)) {
                z = true;
                break;
            }
            i++;
        }
        if (!z) {
            return 0;
        }
        mo34600a(bVar);
        return 0;
    }

    /* renamed from: nO */
    public void mo34611nO(String str) {
        C8467b aIS = aHf();
        if (aIS != null) {
            DataItemProject dataItemProject = aIS.mProjectDataItem;
            if (dataItemProject != null) {
                String str2 = dataItemProject.strPrjURL;
                if (!TextUtils.isEmpty(str2) && C8548e.isFileExisted(str2)) {
                    String fileName = C8548e.getFileName(str2);
                    String parent = new File(str2).getParent();
                    StringBuilder sb = new StringBuilder();
                    sb.append(parent);
                    sb.append("/");
                    sb.append(fileName);
                    sb.append(".prj");
                    sb.append(str);
                    String sb2 = sb.toString();
                    if (C8548e.isFileExisted(sb2)) {
                        C8548e.deleteFile(sb2);
                    }
                    C8548e.copyFile(str2, sb2);
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(parent);
                    sb3.append("/");
                    sb3.append(fileName);
                    sb3.append("_storyboard");
                    sb3.append(".prj");
                    String sb4 = sb3.toString();
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(parent);
                    sb5.append("/");
                    sb5.append(fileName);
                    sb5.append("_storyboard");
                    sb5.append(".prj");
                    sb5.append(str);
                    String sb6 = sb5.toString();
                    if (C8548e.isFileExisted(sb6)) {
                        C8548e.deleteFile(sb6);
                    }
                    C8548e.copyFile(sb4, sb6);
                    StringBuilder sb7 = new StringBuilder();
                    sb7.append(parent);
                    sb7.append("/");
                    sb7.append(fileName);
                    sb7.append(".jpg");
                    String sb8 = sb7.toString();
                    if (C8548e.isFileExisted(sb8)) {
                        StringBuilder sb9 = new StringBuilder();
                        sb9.append(parent);
                        sb9.append("/");
                        sb9.append(fileName);
                        sb9.append(".jpg");
                        sb9.append(str);
                        String sb10 = sb9.toString();
                        if (C8548e.isFileExisted(sb10)) {
                            C8548e.deleteFile(sb10);
                        }
                        C8548e.copyFile(sb8, sb10);
                    }
                }
            }
        }
    }

    /* renamed from: nt */
    public int mo33889nt(String str) {
        if (this.ebR == null || TextUtils.isEmpty(str)) {
            return -1;
        }
        for (int i = 0; i < this.ebR.size(); i++) {
            if (TextUtils.equals(str, ((C8467b) this.ebR.get(i)).mProjectDataItem.strPrjURL)) {
                return i;
            }
        }
        return -1;
    }

    /* renamed from: tz */
    public DataItemProject mo33891tz(int i) {
        C8467b uj = mo34612uj(i);
        if (uj == null) {
            return null;
        }
        return uj.mProjectDataItem;
    }

    /* renamed from: uj */
    public C8467b mo34612uj(int i) {
        if (this.ebR != null && i < this.ebR.size() && i >= 0) {
            return (C8467b) this.ebR.get(i);
        }
        return null;
    }

    /* renamed from: uk */
    public synchronized void mo34613uk(int i) {
        if (this.ebR != null && i >= 0 && i < this.ebR.size()) {
            C8467b bVar = (C8467b) this.ebR.remove(i);
            if (bVar != null) {
                bVar.release();
            }
        }
    }

    public synchronized void uninit() {
        this.efG = true;
        if (this.ebT != null) {
            this.ebT.quit();
            this.ebT = null;
        }
        aIU();
        this.efI = null;
        this.efJ = false;
        this.ebQ = -1;
        this.efJ = false;
    }
}
