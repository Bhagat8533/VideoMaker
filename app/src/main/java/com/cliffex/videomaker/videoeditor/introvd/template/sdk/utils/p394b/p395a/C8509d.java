package com.introvd.template.sdk.utils.p394b.p395a;

import com.introvd.template.sdk.utils.C8548e;
import com.introvd.template.sdk.utils.C8554j;
import com.introvd.template.sdk.utils.C8571x;
import com.introvd.template.sdk.utils.C8572y;
import com.introvd.template.sdk.utils.VeMSize;
import com.introvd.template.sdk.utils.p394b.C8541r;
import java.io.File;
import xiaoying.engine.QEngine;
import xiaoying.engine.base.QDisplayContext;
import xiaoying.engine.base.QRange;
import xiaoying.engine.base.QSessionStream;
import xiaoying.engine.base.QSessionStreamOpenParam;
import xiaoying.engine.base.QUtils;
import xiaoying.engine.base.QUtils.QVideoImportFormat;
import xiaoying.engine.clip.QClip;
import xiaoying.engine.storyboard.QStoryboard;
import xiaoying.utils.QRect;

/* renamed from: com.introvd.template.sdk.utils.b.a.d */
public class C8509d extends C8502a {
    private QStoryboard cFJ = null;

    public C8509d(QEngine qEngine) {
        super(qEngine);
    }

    /* renamed from: b */
    private QSessionStream m24614b(QStoryboard qStoryboard, VeMSize veMSize) {
        C8554j.m25007e("FileReverseUtils", "CreateSourceStream in");
        if (qStoryboard == null || veMSize == null) {
            return null;
        }
        int i = veMSize.width;
        int i2 = veMSize.height;
        StringBuilder sb = new StringBuilder();
        sb.append("width:");
        sb.append(i);
        sb.append(";height:");
        sb.append(i2);
        C8554j.m25008i("FileReverseUtils", sb.toString());
        QDisplayContext c = C8571x.m25060c(i, i2, 2, null);
        if (c == null) {
            return null;
        }
        QSessionStream qSessionStream = new QSessionStream();
        int aJl = C8572y.aJl();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("createClipStream decoderType=");
        sb2.append(aJl);
        C8554j.m25007e("FileReverseUtils", sb2.toString());
        QSessionStreamOpenParam qSessionStreamOpenParam = new QSessionStreamOpenParam();
        qSessionStreamOpenParam.mDecoderUsageType = aJl;
        qSessionStreamOpenParam.mFrameSize.mWidth = i;
        qSessionStreamOpenParam.mFrameSize.mHeight = i2;
        QRect screenRect = c.getScreenRect();
        qSessionStreamOpenParam.mRenderTargetSize.mWidth = screenRect.right - screenRect.left;
        qSessionStreamOpenParam.mRenderTargetSize.mHeight = screenRect.bottom - screenRect.top;
        qSessionStreamOpenParam.mResampleMode = c.getResampleMode();
        qSessionStreamOpenParam.mRotation = c.getRotation();
        if (qSessionStream.open(1, qStoryboard, qSessionStreamOpenParam) != 0) {
            qSessionStream.close();
            return null;
        }
        C8554j.m25007e("FileReverseUtils", "CreateSourceStream out");
        return qSessionStream;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(8:85|86|(1:88)|89|(1:91)|92|93|94) */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x0167, code lost:
        if (r1.eig != null) goto L_0x0169;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x0169, code lost:
        r1.eig.unInit();
        r1.eig = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x0172, code lost:
        if (r1.eeR != null) goto L_0x0174;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x0174, code lost:
        r1.eeR.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x0179, code lost:
        r1.eeR = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x017c, code lost:
        return 1;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:85:0x0165 */
    /* renamed from: oS */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized int m24615oS(java.lang.String r21) {
        /*
            r20 = this;
            r1 = r20
            monitor-enter(r20)
            java.lang.String r0 = "FileReverseUtils"
            java.lang.String r2 = "StartProducer in"
            com.introvd.template.sdk.utils.C8554j.m25007e(r0, r2)     // Catch:{ all -> 0x017d }
            xiaoying.engine.storyboard.QStoryboard r0 = r1.cFJ     // Catch:{ all -> 0x017d }
            if (r0 != 0) goto L_0x0011
            r0 = 5
            monitor-exit(r20)
            return r0
        L_0x0011:
            boolean r0 = r1.eik     // Catch:{ all -> 0x017d }
            if (r0 == 0) goto L_0x0038
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x017d }
            r0.<init>()     // Catch:{ all -> 0x017d }
            r2 = r21
            r0.append(r2)     // Catch:{ all -> 0x017d }
            java.lang.String r3 = "tmp_reverse_export_xiaoying.mp4"
            r0.append(r3)     // Catch:{ all -> 0x017d }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x017d }
            r1.eiv = r0     // Catch:{ all -> 0x017d }
            java.lang.String r0 = r1.eiv     // Catch:{ all -> 0x017d }
            boolean r0 = com.introvd.template.sdk.utils.C8548e.isFileExisted(r0)     // Catch:{ all -> 0x017d }
            if (r0 == 0) goto L_0x003a
            java.lang.String r0 = r1.eiv     // Catch:{ all -> 0x017d }
            com.introvd.template.sdk.utils.C8548e.deleteFile(r0)     // Catch:{ all -> 0x017d }
            goto L_0x003a
        L_0x0038:
            r2 = r21
        L_0x003a:
            xiaoying.engine.QEngine r0 = r1.engine     // Catch:{ all -> 0x017d }
            long r2 = com.introvd.template.sdk.utils.C8548e.getFreeSpace(r21)     // Catch:{ all -> 0x017d }
            r4 = 20971520(0x1400000, double:1.03613076E-316)
            int r4 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r4 > 0) goto L_0x004b
            r0 = 11
            monitor-exit(r20)
            return r0
        L_0x004b:
            r4 = 512000(0x7d000, double:2.529616E-318)
            long r2 = r2 - r4
            r4 = 4294967295(0xffffffff, double:2.1219957905E-314)
            int r4 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r4 <= 0) goto L_0x005d
            r2 = 4294455295(0xfff82fff, double:2.121742829E-314)
        L_0x005d:
            r10 = r2
            xiaoying.engine.base.QSessionStream r2 = r1.eeR     // Catch:{ all -> 0x017d }
            if (r2 == 0) goto L_0x0067
            xiaoying.engine.base.QSessionStream r2 = r1.eeR     // Catch:{ all -> 0x017d }
            r2.close()     // Catch:{ all -> 0x017d }
        L_0x0067:
            r15 = 0
            r1.eeR = r15     // Catch:{ all -> 0x017d }
            xiaoying.engine.producer.QProducer r2 = new xiaoying.engine.producer.QProducer     // Catch:{ all -> 0x017d }
            r2.<init>()     // Catch:{ all -> 0x017d }
            r1.eig = r2     // Catch:{ all -> 0x017d }
            xiaoying.engine.producer.QProducer r2 = r1.eig     // Catch:{ all -> 0x017d }
            r3 = 24578(0x6002, float:3.4441E-41)
            java.lang.Boolean r4 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x017d }
            int r2 = r2.setProperty(r3, r4)     // Catch:{ all -> 0x017d }
            if (r2 == 0) goto L_0x0086
            xiaoying.engine.producer.QProducer r0 = r1.eig     // Catch:{ all -> 0x017d }
            r0.unInit()     // Catch:{ all -> 0x017d }
            r1.eig = r15     // Catch:{ all -> 0x017d }
            monitor-exit(r20)
            return r2
        L_0x0086:
            xiaoying.engine.producer.QProducer r2 = r1.eig     // Catch:{ all -> 0x017d }
            int r2 = r2.init(r0, r1)     // Catch:{ all -> 0x017d }
            if (r2 == 0) goto L_0x0097
            xiaoying.engine.producer.QProducer r0 = r1.eig     // Catch:{ all -> 0x017d }
            r0.unInit()     // Catch:{ all -> 0x017d }
            r1.eig = r15     // Catch:{ all -> 0x017d }
            monitor-exit(r20)
            return r2
        L_0x0097:
            r12 = 2
            r13 = 1
            xiaoying.engine.storyboard.QStoryboard r2 = r1.cFJ     // Catch:{ all -> 0x017d }
            int r14 = com.introvd.template.sdk.utils.C8572y.m25105y(r2)     // Catch:{ all -> 0x017d }
            r7 = 1
            int r3 = r1.eix     // Catch:{ all -> 0x017d }
            int r5 = r1.eiy     // Catch:{ all -> 0x017d }
            int r6 = r1.eiz     // Catch:{ all -> 0x017d }
            r8 = 512(0x200, float:7.175E-43)
            r9 = 3
            r2 = r0
            r4 = r14
            int r0 = xiaoying.engine.base.QUtils.caculateVideoBitrate(r2, r3, r4, r5, r6, r7, r8, r9)     // Catch:{ all -> 0x017d }
            long r2 = (long) r0     // Catch:{ all -> 0x017d }
            int r8 = r14 * 1000
            boolean r0 = r1.eik     // Catch:{ all -> 0x017d }
            if (r0 == 0) goto L_0x00b9
            java.lang.String r0 = r1.eiv     // Catch:{ all -> 0x017d }
            goto L_0x00bb
        L_0x00b9:
            java.lang.String r0 = r1.eit     // Catch:{ all -> 0x017d }
        L_0x00bb:
            xiaoying.engine.producer.QProducerProperty r14 = new xiaoying.engine.producer.QProducerProperty     // Catch:{ all -> 0x017d }
            int r6 = r1.eix     // Catch:{ all -> 0x017d }
            int r9 = (int) r2     // Catch:{ all -> 0x017d }
            int r2 = com.introvd.template.sdk.utils.C8572y.aJm()     // Catch:{ all -> 0x017d }
            xiaoying.engine.base.QRange r3 = new xiaoying.engine.base.QRange     // Catch:{ all -> 0x017d }
            r4 = -1
            r7 = 0
            r3.<init>(r7, r4)     // Catch:{ all -> 0x017d }
            r16 = 3
            r17 = 40
            java.lang.String r18 = ""
            r4 = r14
            r5 = r12
            r19 = 0
            r7 = r13
            r12 = r0
            r13 = r2
            r0 = r14
            r14 = r3
            r2 = r15
            r15 = r16
            r16 = r17
            r17 = r18
            r4.<init>(r5, r6, r7, r8, r9, r10, r12, r13, r14, r15, r16, r17)     // Catch:{ all -> 0x017d }
            r3 = 60
            r0.maxExpFps = r3     // Catch:{ all -> 0x017d }
            xiaoying.engine.producer.QProducer r3 = r1.eig     // Catch:{ all -> 0x017d }
            r4 = 24577(0x6001, float:3.444E-41)
            int r0 = r3.setProperty(r4, r0)     // Catch:{ all -> 0x017d }
            if (r0 == 0) goto L_0x00fb
            xiaoying.engine.producer.QProducer r3 = r1.eig     // Catch:{ all -> 0x017d }
            r3.unInit()     // Catch:{ all -> 0x017d }
            r1.eig = r2     // Catch:{ all -> 0x017d }
            monitor-exit(r20)
            return r0
        L_0x00fb:
            xiaoying.engine.storyboard.QStoryboard r0 = r1.cFJ     // Catch:{ all -> 0x017d }
            com.introvd.template.sdk.utils.VeMSize r3 = r1.egg     // Catch:{ all -> 0x017d }
            xiaoying.engine.base.QSessionStream r0 = r1.m24614b(r0, r3)     // Catch:{ all -> 0x017d }
            r1.eeR = r0     // Catch:{ all -> 0x017d }
            xiaoying.engine.base.QSessionStream r0 = r1.eeR     // Catch:{ all -> 0x017d }
            r3 = 1
            if (r0 != 0) goto L_0x0113
            xiaoying.engine.producer.QProducer r0 = r1.eig     // Catch:{ all -> 0x017d }
            r0.unInit()     // Catch:{ all -> 0x017d }
            r1.eig = r2     // Catch:{ all -> 0x017d }
            monitor-exit(r20)
            return r3
        L_0x0113:
            xiaoying.engine.producer.QProducer r0 = r1.eig     // Catch:{ all -> 0x017d }
            xiaoying.engine.base.QSessionStream r4 = r1.eeR     // Catch:{ all -> 0x017d }
            int r0 = r0.activeStream(r4)     // Catch:{ all -> 0x017d }
            if (r0 == 0) goto L_0x0131
            xiaoying.engine.producer.QProducer r3 = r1.eig     // Catch:{ all -> 0x017d }
            r3.unInit()     // Catch:{ all -> 0x017d }
            r1.eig = r2     // Catch:{ all -> 0x017d }
            xiaoying.engine.base.QSessionStream r3 = r1.eeR     // Catch:{ all -> 0x017d }
            if (r3 == 0) goto L_0x012d
            xiaoying.engine.base.QSessionStream r3 = r1.eeR     // Catch:{ all -> 0x017d }
            r3.close()     // Catch:{ all -> 0x017d }
        L_0x012d:
            r1.eeR = r2     // Catch:{ all -> 0x017d }
            monitor-exit(r20)
            return r0
        L_0x0131:
            xiaoying.engine.producer.QProducer r0 = r1.eig     // Catch:{ Exception -> 0x0165 }
            int r0 = r0.start()     // Catch:{ Exception -> 0x0165 }
            if (r0 == 0) goto L_0x014d
            xiaoying.engine.producer.QProducer r4 = r1.eig     // Catch:{ Exception -> 0x0165 }
            r4.unInit()     // Catch:{ Exception -> 0x0165 }
            r1.eig = r2     // Catch:{ Exception -> 0x0165 }
            xiaoying.engine.base.QSessionStream r4 = r1.eeR     // Catch:{ Exception -> 0x0165 }
            if (r4 == 0) goto L_0x0149
            xiaoying.engine.base.QSessionStream r4 = r1.eeR     // Catch:{ Exception -> 0x0165 }
            r4.close()     // Catch:{ Exception -> 0x0165 }
        L_0x0149:
            r1.eeR = r2     // Catch:{ Exception -> 0x0165 }
            monitor-exit(r20)
            return r0
        L_0x014d:
            boolean r0 = r1.eik     // Catch:{ all -> 0x017d }
            if (r0 == 0) goto L_0x015c
            com.introvd.template.systemevent.c r0 = r1.eij     // Catch:{ all -> 0x017d }
            if (r0 == 0) goto L_0x015c
            com.introvd.template.systemevent.c r0 = r1.eij     // Catch:{ all -> 0x017d }
            java.lang.String r2 = r1.eiv     // Catch:{ all -> 0x017d }
            r0.mo34896oZ(r2)     // Catch:{ all -> 0x017d }
        L_0x015c:
            java.lang.String r0 = "FileReverseUtils"
            java.lang.String r2 = "StartProducer out"
            com.introvd.template.sdk.utils.C8554j.m25007e(r0, r2)     // Catch:{ all -> 0x017d }
            monitor-exit(r20)
            return r19
        L_0x0165:
            xiaoying.engine.producer.QProducer r0 = r1.eig     // Catch:{ all -> 0x017d }
            if (r0 == 0) goto L_0x0170
            xiaoying.engine.producer.QProducer r0 = r1.eig     // Catch:{ all -> 0x017d }
            r0.unInit()     // Catch:{ all -> 0x017d }
            r1.eig = r2     // Catch:{ all -> 0x017d }
        L_0x0170:
            xiaoying.engine.base.QSessionStream r0 = r1.eeR     // Catch:{ all -> 0x017d }
            if (r0 == 0) goto L_0x0179
            xiaoying.engine.base.QSessionStream r0 = r1.eeR     // Catch:{ all -> 0x017d }
            r0.close()     // Catch:{ all -> 0x017d }
        L_0x0179:
            r1.eeR = r2     // Catch:{ all -> 0x017d }
            monitor-exit(r20)
            return r3
        L_0x017d:
            r0 = move-exception
            monitor-exit(r20)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.sdk.utils.p394b.p395a.C8509d.m24615oS(java.lang.String):int");
    }

    /* renamed from: a */
    public int mo34689a(String str, String str2, QRange qRange, boolean z) {
        if (!C8548e.isFileExisted(str2)) {
            return 2;
        }
        this.cFJ = C8572y.m25070a(this.engine, str2, qRange);
        if (this.cFJ == null) {
            return 2;
        }
        int[] iArr = new int[1];
        boolean IsNeedTranscode = QUtils.IsNeedTranscode(this.engine, C8572y.m25068a(str2, false, true, z), iArr);
        StringBuilder sb = new StringBuilder();
        sb.append("videotrim infos bNeedTranscode=");
        sb.append(IsNeedTranscode);
        C8554j.m25007e("FileReverseUtils", sb.toString());
        QVideoImportFormat TransformVImportFormat = QUtils.TransformVImportFormat(iArr[0]);
        VeMSize veMSize = new VeMSize(TransformVImportFormat.mWidth, TransformVImportFormat.mHeight);
        VeMSize f = C8541r.m24980f(this.engine, str2);
        this.egg = C8572y.m25065a(veMSize, f, false);
        if (this.egg == null || this.egg.width <= 0 || this.egg.height <= 0) {
            return 2;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("onExportSuccess mSizeVe=");
        sb2.append(this.egg);
        C8554j.m25008i("FileReverseUtils", sb2.toString());
        StringBuilder sb3 = new StringBuilder();
        sb3.append("onExportSuccess maxSize=");
        sb3.append(veMSize);
        C8554j.m25008i("FileReverseUtils", sb3.toString());
        StringBuilder sb4 = new StringBuilder();
        sb4.append("onExportSuccess videoSize=");
        sb4.append(f);
        C8554j.m25008i("FileReverseUtils", sb4.toString());
        this.egg.width = C8572y.m25087dI(this.egg.width, 16);
        this.egg.height = C8572y.m25087dI(this.egg.height, 16);
        this.eix = TransformVImportFormat.mVideoFormat;
        this.eiy = this.egg.width;
        this.eiz = this.egg.height;
        String ou = C8572y.m25097ou(str);
        String fileName = C8548e.getFileName(str2);
        String str3 = ".mp4";
        int oR = m24600oR(ou);
        if (oR != 0) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("exportExternalFile presave error;mStrOutputPath=");
            sb5.append(ou);
            String sb6 = sb5.toString();
            if (this.dcs != null) {
                this.dcs.mo29117n(oR, sb6);
            }
            return oR;
        }
        aJW();
        this.eit = mo34682w(ou, fileName, str3);
        mo34680oQ(ou);
        return oR;
    }

    public boolean aJQ() {
        return false;
    }

    public int aJR() {
        if (this.cFJ != null) {
            int clipCount = this.cFJ.getClipCount();
            for (int i = 0; i < clipCount; i++) {
                QClip clip = this.cFJ.getClip(0);
                if (clip != null) {
                    this.cFJ.removeClip(clip);
                    clip.unInit();
                }
            }
            this.cFJ.unInit();
            this.cFJ = null;
        }
        return 0;
    }

    public boolean aJW() {
        return false;
    }

    /* renamed from: b */
    public int mo34677b(C8508c cVar, String str) {
        int oS = m24615oS(str);
        if (oS != 0) {
            aJQ();
            if (!this.eil) {
                cVar.mo29117n(oS, "FileReverseUtils.StartProducer fail");
                this.eil = true;
            }
        }
        return 0;
    }

    /* access modifiers changed from: protected */
    /* renamed from: w */
    public String mo34682w(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(str2);
        sb.append("_reverse_");
        sb.append(0);
        sb.append(str3);
        String sb2 = sb.toString();
        int i = 1;
        while (true) {
            File file = new File(sb2);
            if (!file.isFile() || !file.exists()) {
                return sb2;
            }
            StringBuilder sb3 = new StringBuilder();
            sb3.append(str);
            sb3.append(str2);
            sb3.append("_reverse_");
            sb3.append(i);
            sb3.append(str3);
            sb2 = sb3.toString();
            i++;
        }
        return sb2;
    }
}
