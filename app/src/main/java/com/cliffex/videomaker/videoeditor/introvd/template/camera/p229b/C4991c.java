package com.introvd.template.camera.p229b;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.introvd.template.camera.model.SaveRequest;
import com.introvd.template.common.FileUtils;
import com.introvd.template.common.LogUtils;
import com.introvd.template.p203b.C4580b;
import com.introvd.template.router.explorer.MusicDataItem;
import com.introvd.template.sdk.editor.cache.C8440a;
import com.introvd.template.sdk.editor.cache.C8443d;
import com.introvd.template.sdk.model.editor.DataItemClip;
import com.introvd.template.sdk.model.editor.ProjectItem;
import com.introvd.template.sdk.p384d.C8402a;
import com.introvd.template.sdk.p384d.C8403b;
import com.introvd.template.sdk.utils.p394b.C8501a;
import com.introvd.template.sdk.utils.p394b.C8517b;
import com.introvd.template.sdk.utils.p394b.C8519d;
import com.introvd.template.sdk.utils.p394b.C8522g;
import com.introvd.template.sdk.utils.p394b.C8536m;
import com.introvd.template.sdk.utils.p394b.C8540q;
import com.vivavideo.mobile.h5core.refresh.H5PullHeader;
import java.lang.Thread.State;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.LinkedBlockingQueue;
import xiaoying.engine.base.QRange;

/* renamed from: com.introvd.template.camera.b.c */
public class C4991c {
    /* access modifiers changed from: private */
    public C8522g bMM;
    /* access modifiers changed from: private */
    public boolean bMW = true;
    /* access modifiers changed from: private */
    public C8501a bOK;
    private C4993b bPf;
    private List<SaveRequest> bPg = Collections.synchronizedList(new ArrayList());
    private List<SaveRequest> bPh = Collections.synchronizedList(new ArrayList());
    /* access modifiers changed from: private */
    public SaveRequest bPi;
    /* access modifiers changed from: private */
    public boolean bPj = false;
    /* access modifiers changed from: private */
    public Context mContext;
    /* access modifiers changed from: private */
    public int mThreadPriority = 0;

    /* renamed from: com.introvd.template.camera.b.c$a */
    static class C4992a {
        private List<SaveRequest> bPk = new ArrayList();

        C4992a() {
        }

        /* renamed from: Vf */
        public List<SaveRequest> mo25473Vf() {
            return this.bPk;
        }
    }

    /* renamed from: com.introvd.template.camera.b.c$b */
    private class C4993b extends Thread {
        private LinkedBlockingQueue<List<SaveRequest>> bPl = new LinkedBlockingQueue<>();

        public C4993b() {
            start();
        }

        /* access modifiers changed from: private */
        /* renamed from: Vg */
        public boolean m12781Vg() {
            return this.bPl.size() > 0 || C4991c.this.bPj;
        }

        /* renamed from: aw */
        private void m12783aw(List<SaveRequest> list) {
            int i;
            String str;
            C4991c.this.bPi = (SaveRequest) list.get(0);
            if (1 != C4991c.this.bPi.nSaveRequestType) {
                return;
            }
            if (C4991c.this.bPi.pipItem != null) {
                DataItemClip d = m12784d(C4991c.this.bPi);
                if (C8540q.m24976w(C4991c.this.bMM.aHd())) {
                    SaveRequest b = C4991c.this.bPi;
                    b.insertPosition++;
                }
                C5020n.m13112a(C4991c.this.bOK, C4991c.this.bMM.aHf(), C4991c.this.bPi.insertPosition, list, C4991c.this.bMW);
                if (!TextUtils.isEmpty(C4991c.this.bPi.effectFilepath)) {
                    C4991c.this.bMM.mo34760c(C4991c.this.bPi.insertPosition, C4991c.this.bPi.effectFilepath, C4991c.this.bPi.effectConfigureIndex);
                }
                C4991c.this.bMM.mo34757b(d);
                String str2 = "";
                for (int i2 = 0; i2 < list.size(); i2++) {
                    SaveRequest saveRequest = (SaveRequest) list.get(i2);
                    if (!str2.equals(saveRequest.pipItem.filePath)) {
                        str2 = saveRequest.pipItem.filePath;
                        if (FileUtils.isFileExisted(str2) && !str2.contains(".media/") && C4991c.this.mContext != null) {
                            C4580b.m11643a(C4991c.this.mContext, new String[]{str2}, null, null);
                        }
                    }
                }
                return;
            }
            DataItemClip d2 = m12784d(C4991c.this.bPi);
            if (C8540q.m24976w(C4991c.this.bMM.aHd())) {
                SaveRequest b2 = C4991c.this.bPi;
                b2.insertPosition++;
            }
            C8519d dVar = new C8519d(C4991c.this.bPi.startPos, C4991c.this.bPi.endPos);
            dVar.camExportEffectDataArray = C4991c.this.bPi.camExportEffectDataArray;
            MusicDataItem musicDataItem = C4991c.this.bPi.musicItem;
            String str3 = "";
            if (musicDataItem == null || !musicDataItem.isRangeValid() || !FileUtils.isFileExisted(musicDataItem.filePath)) {
                str = str3;
                i = 0;
            } else {
                String str4 = musicDataItem.filePath;
                i = musicDataItem.currentTimeStamp;
                str = str4;
            }
            C4991c.this.bMM.mo34728a(C4991c.this.bPi.filePath, C4991c.this.bOK, C4991c.this.bPi.insertPosition, dVar, C4991c.this.bPi.fTimeScale, str, i, C4991c.this.bPi.lyricsItem);
            if (!TextUtils.isEmpty(C4991c.this.bPi.effectFilepath)) {
                C4991c.this.bMM.mo34760c(C4991c.this.bPi.insertPosition, C4991c.this.bPi.effectFilepath, C4991c.this.bPi.effectConfigureIndex);
            }
            C4991c.this.bMM.mo34757b(d2);
            if (FileUtils.isFileExisted(C4991c.this.bPi.filePath) && !C4991c.this.bPi.filePath.contains(".media/") && C4991c.this.mContext != null) {
                C4580b.m11643a(C4991c.this.mContext, new String[]{C4991c.this.bPi.filePath}, null, null);
            }
        }

        /* renamed from: d */
        private DataItemClip m12784d(SaveRequest saveRequest) {
            DataItemClip dataItemClip = new DataItemClip();
            dataItemClip.strCreateTime = new SimpleDateFormat(H5PullHeader.TIME_FORMAT, Locale.US).format(new Date(System.currentTimeMillis()));
            dataItemClip.strClipURL = saveRequest.filePath;
            dataItemClip.nInsertPosition = saveRequest.insertPosition;
            dataItemClip.nStartPos = saveRequest.startPos;
            dataItemClip.nEndPos = saveRequest.endPos;
            dataItemClip.fTimeScale = saveRequest.fTimeScale;
            return dataItemClip;
        }

        private void waitDone() {
            C4991c.this.mThreadPriority = -19;
            while (getState() != State.TERMINATED) {
                try {
                    Thread.sleep(5);
                } catch (InterruptedException unused) {
                    return;
                }
            }
        }

        /* renamed from: av */
        public void mo25474av(List<SaveRequest> list) {
            try {
                this.bPl.add(list);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        public void finish() {
            if (getState() != State.TERMINATED) {
                SaveRequest saveRequest = new SaveRequest();
                saveRequest.nSaveRequestType = -1;
                ArrayList arrayList = new ArrayList();
                arrayList.add(saveRequest);
                mo25474av(arrayList);
                waitDone();
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:10:0x001f  */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x0042 A[SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r5 = this;
            L_0x0000:
                r0 = 0
                java.util.concurrent.LinkedBlockingQueue<java.util.List<com.introvd.template.camera.model.SaveRequest>> r1 = r5.bPl     // Catch:{ Throwable -> 0x0015 }
                java.lang.Object r1 = r1.take()     // Catch:{ Throwable -> 0x0015 }
                java.util.List r1 = (java.util.List) r1     // Catch:{ Throwable -> 0x0015 }
                com.introvd.template.camera.b.c r0 = com.introvd.template.camera.p229b.C4991c.this     // Catch:{ Throwable -> 0x0013 }
                int r0 = r0.mThreadPriority     // Catch:{ Throwable -> 0x0013 }
                android.os.Process.setThreadPriority(r0)     // Catch:{ Throwable -> 0x0013 }
                goto L_0x001c
            L_0x0013:
                r0 = move-exception
                goto L_0x0019
            L_0x0015:
                r1 = move-exception
                r4 = r1
                r1 = r0
                r0 = r4
            L_0x0019:
                r0.printStackTrace()
            L_0x001c:
                if (r1 != 0) goto L_0x001f
                goto L_0x0042
            L_0x001f:
                r0 = 0
                java.lang.Object r2 = r1.get(r0)
                com.introvd.template.camera.model.SaveRequest r2 = (com.introvd.template.camera.model.SaveRequest) r2
                if (r2 == 0) goto L_0x0042
                int r2 = r2.nSaveRequestType
                r3 = -1
                if (r2 != r3) goto L_0x002e
                goto L_0x0042
            L_0x002e:
                com.introvd.template.camera.b.c r2 = com.introvd.template.camera.p229b.C4991c.this
                r3 = 1
                r2.bPj = r3
                if (r1 == 0) goto L_0x0039
                r5.m12783aw(r1)
            L_0x0039:
                com.introvd.template.camera.b.c r2 = com.introvd.template.camera.p229b.C4991c.this
                r2.bPj = r0
                r1.clear()
                goto L_0x0000
            L_0x0042:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.camera.p229b.C4991c.C4993b.run():void");
        }
    }

    public C4991c(Context context) {
        this.mContext = context;
        this.bMM = C8522g.aJA();
        this.bOK = C8501a.aJs();
    }

    /* renamed from: Vb */
    private void m12748Vb() {
        ProjectItem ahP = this.bMM.aHf();
        if (ahP != null) {
            C8443d dVar = ahP.mClipModelCacheList;
            if (dVar != null) {
                int count = dVar.getCount() - 1;
                while (count >= 0) {
                    C8440a tX = dVar.mo34307tX(count);
                    if (tX == null || tX.isCover()) {
                        count--;
                    } else {
                        C8540q.m24963n(ahP.mStoryBoard, tX.aHL());
                        m12762g(tX.aHU(), false);
                        dVar.mo34309tZ(tX.aHL());
                        dVar.mo34297bN(tX.aHL());
                        C8517b.m24643a(dVar);
                        dVar.aIl();
                        return;
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private boolean m12753a(SaveRequest saveRequest, SaveRequest saveRequest2) {
        boolean z = false;
        if (saveRequest.musicItem == null || saveRequest2.musicItem == null) {
            return false;
        }
        if (saveRequest.filePath != null && saveRequest.filePath.equals(saveRequest2.filePath) && saveRequest.effectFilepath != null && saveRequest.effectFilepath.equals(saveRequest2.effectFilepath) && saveRequest.musicItem.filePath != null && saveRequest.musicItem.filePath.equals(saveRequest2.musicItem.filePath) && saveRequest.musicItem.startTimeStamp == saveRequest2.musicItem.startTimeStamp && saveRequest.musicItem.stopTimeStamp == saveRequest2.musicItem.stopTimeStamp) {
            z = true;
        }
        return z;
    }

    /* renamed from: b */
    private SaveRequest m12755b(SaveRequest saveRequest, SaveRequest saveRequest2) {
        SaveRequest saveRequest3 = new SaveRequest();
        saveRequest3.filePath = saveRequest.filePath;
        saveRequest3.dateTaken = saveRequest.dateTaken;
        saveRequest3.isVideo = saveRequest.isVideo;
        saveRequest3.orientation = saveRequest.orientation;
        saveRequest3.insertPosition = saveRequest.insertPosition;
        saveRequest3.isVirtualFile = saveRequest.isVirtualFile;
        saveRequest3.startPos = saveRequest.startPos;
        saveRequest3.fTimeScale = saveRequest.fTimeScale;
        saveRequest3.endPos = saveRequest2.endPos;
        saveRequest3.musicItem = saveRequest2.musicItem;
        saveRequest3.lyricsItem = saveRequest2.lyricsItem;
        saveRequest3.effectFilepath = saveRequest.effectFilepath;
        return saveRequest3;
    }

    /* renamed from: c */
    private int m12756c(SaveRequest saveRequest) {
        int i = 0;
        if (this.bMM == null) {
            return 0;
        }
        ProjectItem ahP = this.bMM.aHf();
        if (ahP == null) {
            return 0;
        }
        boolean w = C8540q.m24976w(this.bMM.aHd());
        C8443d dVar = ahP.mClipModelCacheList;
        if (dVar != null) {
            C8440a aVar = new C8440a();
            int eS = m12760eS(saveRequest.filePath);
            aVar.mo34252tL(eS);
            aVar.mo34247nF(saveRequest.filePath);
            aVar.mo34257tQ(saveRequest.isVideo ? 1 : 2);
            aVar.mo34258tR(saveRequest.endPos);
            aVar.mo34259tS(0);
            aVar.mo34260tT(0);
            aVar.mo34256tP(1);
            QRange qRange = new QRange(saveRequest.startPos, saveRequest.endPos - saveRequest.startPos);
            aVar.mo34255tO(0);
            aVar.mo34216a(qRange);
            aVar.mo34235b(null);
            if (saveRequest.musicItem != null) {
                aVar.mo34244jh(true);
            }
            int count = dVar.getCount();
            if (w) {
                count--;
            }
            aVar.mo34253tM(count);
            dVar.mo34292a(aVar);
            dVar.mo34308tY(count);
            C8517b.m24643a(dVar);
            if (saveRequest.bMakeClipThumbnail) {
                Bitmap K = C8536m.m24779K(saveRequest.filePath, eS);
                if (K != null) {
                    aVar.mo34264u(K);
                }
            }
            ahP.mProjectDataItem.iPrjClipCount++;
            i = 1;
        }
        this.bPg.add(saveRequest);
        return i;
    }

    /* renamed from: eS */
    private int m12760eS(String str) {
        int i = 0;
        if (this.bPh.size() == 0 || str == null) {
            return 0;
        }
        try {
            for (SaveRequest saveRequest : this.bPh) {
                if (str.equals(saveRequest.filePath)) {
                    i++;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    /* renamed from: g */
    private void m12762g(String str, boolean z) {
        if (!TextUtils.isEmpty(str) && this.mContext != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("filePath:");
            sb.append(str);
            sb.append(";isInsert:");
            sb.append(z);
            LogUtils.m14223i("CameraClipSaver", sb.toString());
            long nA = C8402a.m24228nA(str);
            long aJG = this.bMM.aJG();
            if (nA <= 0 || aJG <= 0) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("clipId:");
                sb2.append(nA);
                sb2.append(";projId:");
                sb2.append(aJG);
                LogUtils.m14223i("CameraClipSaver", sb2.toString());
                return;
            }
            C8403b.m24230b(aJG, nA, z);
        }
    }

    /* renamed from: Ts */
    public void mo25457Ts() {
        int size = this.bPh.size();
        if (size != 0) {
            this.bPh.remove(size - 1);
        } else {
            m12748Vb();
        }
    }

    /* renamed from: UW */
    public void mo25458UW() {
        this.bPf = new C4993b();
    }

    /* renamed from: UX */
    public void mo25459UX() {
        if (this.bPf != null) {
            this.bPf.finish();
            this.bPf = null;
        }
    }

    /* renamed from: UY */
    public List<SaveRequest> mo25460UY() {
        ArrayList arrayList = new ArrayList();
        int size = this.bPh.size();
        if (size == 0) {
            return null;
        }
        for (int i = size - 1; i >= 0; i--) {
            SaveRequest saveRequest = (SaveRequest) this.bPh.get(i);
            if (saveRequest == null || saveRequest.musicItem == null) {
                break;
            }
            arrayList.add(saveRequest);
        }
        return arrayList;
    }

    /* renamed from: UZ */
    public int mo25461UZ() {
        int size = this.bPh.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        for (int i2 = size - 1; i2 >= 0; i2--) {
            SaveRequest saveRequest = (SaveRequest) this.bPh.get(i2);
            if (saveRequest == null || saveRequest.musicItem == null) {
                break;
            }
            this.bPh.remove(i2);
            i++;
        }
        return i;
    }

    /* renamed from: Va */
    public SaveRequest mo25462Va() {
        int size = this.bPh.size();
        if (size != 0) {
            return (SaveRequest) this.bPh.get(size - 1);
        }
        return null;
    }

    /* renamed from: Vc */
    public boolean mo25463Vc() {
        if (this.bPf != null) {
            return this.bPf.m12781Vg();
        }
        return false;
    }

    /* renamed from: Vd */
    public void mo25464Vd() {
        if (this.bPh != null) {
            this.bPh.clear();
        }
        if (this.bPg != null) {
            this.bPg.clear();
        }
    }

    /* renamed from: Ve */
    public void mo25465Ve() {
        for (int size = this.bPh.size() - 1; size >= 0; size--) {
            SaveRequest saveRequest = (SaveRequest) this.bPh.get(size);
            if (!(saveRequest == null || saveRequest.pipItem == null)) {
                saveRequest.pipItem.sourceIndex = (saveRequest.pipItem.sourceIndex + 1) % 2;
            }
        }
    }

    /* renamed from: a */
    public void mo25466a(SaveRequest saveRequest) {
        if (this.bPh.size() == 0) {
            this.bPh.add(saveRequest);
            return;
        }
        SaveRequest saveRequest2 = (SaveRequest) this.bPh.get(this.bPh.size() - 1);
        if (m12753a(saveRequest2, saveRequest)) {
            saveRequest = m12755b(saveRequest2, saveRequest);
            this.bPh.remove(saveRequest2);
        } else if (saveRequest != null && saveRequest.pipItem == null && !saveRequest2.hasModifyEndPos) {
            saveRequest2.endPos = saveRequest.startPos - 1;
            saveRequest2.hasModifyEndPos = true;
        }
        this.bPh.add(saveRequest);
    }

    /* renamed from: ag */
    public void mo25467ag(long j) {
        for (int size = this.bPh.size() - 1; size >= 0; size--) {
            SaveRequest saveRequest = (SaveRequest) this.bPh.get(size);
            if (!(saveRequest == null || saveRequest.pipItem == null)) {
                saveRequest.pipItem.lTemplateID = j;
            }
        }
    }

    /* renamed from: b */
    public boolean mo25468b(SaveRequest saveRequest) {
        if (this.bPh.size() == 0) {
            return false;
        }
        return m12753a((SaveRequest) this.bPh.get(this.bPh.size() - 1), saveRequest);
    }

    /* renamed from: cu */
    public void mo25469cu(boolean z) {
        this.bMW = z;
        for (SaveRequest c : this.bPh) {
            m12756c(c);
        }
        if (this.bPg != null && !this.bPg.isEmpty()) {
            ProjectItem ahP = this.bMM.aHf();
            if (!(ahP == null || this.bPf == null)) {
                if (ahP.mClipModelCacheList != null) {
                    boolean w = C8540q.m24976w(this.bMM.aHd());
                    for (int i = 0; i < this.bPg.size(); i++) {
                        int count = ahP.mClipModelCacheList.getCount();
                        if (w) {
                            count--;
                        }
                        if (count > 0) {
                            int i2 = count - 1;
                            C8440a tX = ahP.mClipModelCacheList.mo34307tX(i2);
                            if (tX != null) {
                                tX.mo34247nF(null);
                            }
                            ahP.mClipModelCacheList.mo34297bN(i2);
                            ahP.mProjectDataItem.iPrjClipCount--;
                        }
                    }
                }
                ArrayList arrayList = new ArrayList();
                while (this.bPg.size() > 0) {
                    SaveRequest saveRequest = (SaveRequest) this.bPg.get(0);
                    this.bPg.remove(saveRequest);
                    C4992a aVar = new C4992a();
                    aVar.mo25473Vf().add(saveRequest);
                    while (this.bPg.size() > 0) {
                        SaveRequest saveRequest2 = (SaveRequest) this.bPg.get(0);
                        if (saveRequest.pipItem == null) {
                            break;
                        } else if (!(saveRequest.pipItem == null || saveRequest2.pipItem == null)) {
                            aVar.mo25473Vf().add(saveRequest2);
                            this.bPg.remove(saveRequest2);
                        }
                    }
                    arrayList.add(aVar);
                }
                while (arrayList.size() > 0) {
                    this.bPf.mo25474av(((C4992a) arrayList.remove(0)).mo25473Vf());
                    if (ahP.mProjectDataItem != null) {
                        ahP.mProjectDataItem.iPrjClipCount++;
                    }
                }
            }
            this.bPg.clear();
            this.bPh.clear();
        }
    }

    /* renamed from: iQ */
    public List<SaveRequest> mo25470iQ(int i) {
        ArrayList arrayList = new ArrayList();
        for (int size = this.bPh.size() - 1; size >= 0; size--) {
            SaveRequest saveRequest = (SaveRequest) this.bPh.get(size);
            if (saveRequest == null || saveRequest.pipItem == null) {
                break;
            }
            if (saveRequest.pipItem.sourceIndex == i) {
                arrayList.add(saveRequest);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
            arrayList2.add(arrayList.get(size2));
        }
        return arrayList2;
    }

    /* renamed from: iR */
    public int mo25471iR(int i) {
        int i2 = 0;
        for (int size = this.bPh.size() - 1; size >= 0; size--) {
            SaveRequest saveRequest = (SaveRequest) this.bPh.get(size);
            if (!(saveRequest == null || saveRequest.pipItem == null || saveRequest.pipItem.sourceIndex != i)) {
                i2++;
            }
        }
        return i2;
    }

    /* renamed from: iS */
    public int mo25472iS(int i) {
        int i2 = 0;
        for (int size = this.bPh.size() - 1; size >= 0; size--) {
            SaveRequest saveRequest = (SaveRequest) this.bPh.get(size);
            if (saveRequest == null || saveRequest.pipItem == null) {
                break;
            }
            if (saveRequest.pipItem.sourceIndex == i) {
                i2 += saveRequest.endPos - saveRequest.startPos;
            }
        }
        return i2;
    }
}
