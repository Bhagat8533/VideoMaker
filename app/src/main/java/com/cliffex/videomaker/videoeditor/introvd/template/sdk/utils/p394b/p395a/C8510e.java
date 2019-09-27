package com.introvd.template.sdk.utils.p394b.p395a;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.introvd.template.p320j.C7547a;
import com.introvd.template.p320j.C7547a.C7548a;
import com.introvd.template.sdk.C8401d;
import com.introvd.template.sdk.editor.p387a.C8419a;
import com.introvd.template.sdk.editor.p389c.C8438d;
import com.introvd.template.sdk.model.VeRange;
import com.introvd.template.sdk.model.editor.VideoExportParamsModel;
import com.introvd.template.sdk.utils.C8548e;
import com.introvd.template.sdk.utils.C8554j;
import com.introvd.template.sdk.utils.C8571x;
import com.introvd.template.sdk.utils.C8572y;
import com.introvd.template.sdk.utils.VeMSize;
import com.introvd.template.sdk.utils.p394b.C8540q;
import java.io.File;
import java.util.List;
import xiaoying.engine.QEngine;
import xiaoying.engine.base.QDisplayContext;
import xiaoying.engine.base.QRange;
import xiaoying.engine.base.QSessionStream;
import xiaoying.engine.base.QSessionStreamOpenParam;
import xiaoying.engine.base.QUtils;
import xiaoying.engine.base.QVideoInfo;
import xiaoying.engine.base.QWatermark;
import xiaoying.engine.clip.QClip;
import xiaoying.engine.clip.QEffect;
import xiaoying.engine.clip.QMediaSource;
import xiaoying.engine.storyboard.QStoryboard;
import xiaoying.utils.QRect;
import xiaoying.utils.QSize;

/* renamed from: com.introvd.template.sdk.utils.b.a.e */
public class C8510e extends C8502a {
    private QStoryboard cFJ = null;
    private VideoExportParamsModel eiJ;
    private C8516i eiK;

    public C8510e(QEngine qEngine, C8516i iVar) {
        super(qEngine);
        this.eiK = iVar;
    }

    /* renamed from: Y */
    private static String m24619Y(QStoryboard qStoryboard) {
        if (qStoryboard == null) {
            return null;
        }
        QClip dataClip = qStoryboard.getDataClip();
        if (dataClip == null) {
            return null;
        }
        QEffect d = C8540q.m24947d(dataClip, 1, 0);
        if (d == null) {
            return null;
        }
        QMediaSource qMediaSource = (QMediaSource) d.getProperty(QEffect.PROP_AUDIO_FRAME_SOURCE);
        if (qMediaSource == null || qMediaSource.getSourceType() != 0) {
            return null;
        }
        return (String) qMediaSource.getSource();
    }

    /* renamed from: a */
    private QRange m24620a(VideoExportParamsModel videoExportParamsModel, boolean z) {
        VeRange veRange = videoExportParamsModel.mExportVeRange;
        if (z && videoExportParamsModel.gifParam != null) {
            veRange = videoExportParamsModel.gifParam.mExpVeRange;
        }
        return veRange != null && veRange.getmTimeLength() > 0 ? new QRange(veRange.getmPosition(), veRange.getmTimeLength()) : new QRange(0, this.cFJ.getDuration());
    }

    /* renamed from: a */
    private QSessionStream m24621a(QStoryboard qStoryboard, VeMSize veMSize, long j) {
        C8554j.m25007e("ProjectExportUtils", "CreateSourceStream in");
        if (qStoryboard == null || veMSize == null) {
            StringBuilder sb = new StringBuilder();
            C8507b bVar = eiw;
            sb.append(bVar.eiF);
            sb.append("createSourceStream fail,storyboard=");
            sb.append(qStoryboard);
            sb.append(",size=");
            sb.append(veMSize);
            bVar.eiF = sb.toString();
            return null;
        }
        if (this.eiJ.mCropRegion != null) {
            C8572y.m25074a(this.cFJ, this.eiJ.mCropRegion);
        }
        int i = veMSize.width;
        int i2 = veMSize.height;
        QDisplayContext c = C8571x.m25060c(i, i2, 2, null);
        if (c == null) {
            StringBuilder sb2 = new StringBuilder();
            C8507b bVar2 = eiw;
            sb2.append(bVar2.eiF);
            sb2.append("createSourceStream fail,width=");
            sb2.append(i);
            sb2.append(",height=");
            sb2.append(i2);
            bVar2.eiF = sb2.toString();
            return null;
        }
        QSessionStream qSessionStream = new QSessionStream();
        int i3 = this.eiJ.decodeType;
        StringBuilder sb3 = new StringBuilder();
        sb3.append("createClipStream decoderType=");
        sb3.append(i3);
        C8554j.m25007e("ProjectExportUtils", sb3.toString());
        QSessionStreamOpenParam qSessionStreamOpenParam = new QSessionStreamOpenParam();
        qSessionStreamOpenParam.mDecoderUsageType = i3;
        qSessionStreamOpenParam.mFrameSize.mWidth = i;
        qSessionStreamOpenParam.mFrameSize.mHeight = i2;
        m24623a(qSessionStreamOpenParam);
        QRect screenRect = c.getScreenRect();
        qSessionStreamOpenParam.mRenderTargetSize.mWidth = screenRect.right - screenRect.left;
        qSessionStreamOpenParam.mRenderTargetSize.mHeight = screenRect.bottom - screenRect.top;
        qSessionStreamOpenParam.mResampleMode = c.getResampleMode();
        qSessionStreamOpenParam.mRotation = c.getRotation();
        QWatermark a = m24622a(j, i, i2, qSessionStreamOpenParam);
        int open = qSessionStream.open(1, qStoryboard, qSessionStreamOpenParam);
        if (open != 0) {
            qSessionStream.close();
            StringBuilder sb4 = new StringBuilder();
            C8507b bVar3 = eiw;
            sb4.append(bVar3.eiF);
            sb4.append("createSourceStream fail,open stream error =");
            sb4.append(open);
            bVar3.eiF = sb4.toString();
            return null;
        }
        a.close();
        if (this.eiJ.mCropRegion != null) {
            if (this.eiJ.isBlack) {
                qSessionStream.setBGColor(-16777216);
            } else {
                qSessionStream.setBGColor(-1);
            }
        }
        C8554j.m25007e("ProjectExportUtils", "CreateSourceStream out");
        return qSessionStream;
    }

    /* renamed from: a */
    private QWatermark m24622a(long j, int i, int i2, QSessionStreamOpenParam qSessionStreamOpenParam) {
        QWatermark qWatermark = new QWatermark();
        qWatermark.open(this.engine, j, null, new QSize(i, i2));
        String c = m24624c(this.eiJ);
        int titleCount = qWatermark.getTitleCount();
        for (int i3 = 0; i3 < titleCount; i3++) {
            qWatermark.setTitle(i3, c);
        }
        qSessionStreamOpenParam.setWatermark(qWatermark);
        return qWatermark;
    }

    /* renamed from: a */
    private void m24623a(QSessionStreamOpenParam qSessionStreamOpenParam) {
        if (qSessionStreamOpenParam != null) {
            VideoExportParamsModel videoExportParamsModel = this.eiJ;
        }
    }

    private String aJX() {
        List<String> z = C8540q.m24977z(this.cFJ);
        C7548a aVar = null;
        if (z != null) {
            for (String fV : z) {
                C7548a fV2 = C7547a.m22297fV(fV);
                if (fV2 != null && !TextUtils.equals(fV2.crk, this.eiJ.auid) && !TextUtils.equals(fV2.crk, this.eiJ.duid)) {
                    aVar = fV2;
                }
            }
        }
        return C7547a.m22295a(aVar, "0", TextUtils.isEmpty(this.eiJ.auid) ? this.eiJ.duid : this.eiJ.auid);
    }

    /* renamed from: c */
    private String m24624c(VideoExportParamsModel videoExportParamsModel) {
        String str = " ";
        if (videoExportParamsModel == null || !videoExportParamsModel.bShowNicknameInWaterMark || TextUtils.isEmpty(videoExportParamsModel.username)) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("ID:");
        sb.append(videoExportParamsModel.username);
        return sb.toString();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:117:0x0356, code lost:
        if (r1.eig != null) goto L_0x0358;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x0358, code lost:
        r1.eig.unInit();
        r1.eig = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x0361, code lost:
        if (r1.eeR != null) goto L_0x0363;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x0363, code lost:
        r1.eeR.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x0368, code lost:
        r1.eeR = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x036b, code lost:
        return 1;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:115:0x0354 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:92:0x02c0 */
    /* renamed from: oS */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized int m24625oS(java.lang.String r28) {
        /*
            r27 = this;
            r1 = r27
            r0 = r28
            monitor-enter(r27)
            java.lang.String r2 = "ProjectExportUtils"
            java.lang.String r3 = "startProducer in"
            com.introvd.template.sdk.utils.C8554j.m25007e(r2, r3)     // Catch:{ all -> 0x036c }
            xiaoying.engine.storyboard.QStoryboard r2 = r1.cFJ     // Catch:{ all -> 0x036c }
            if (r2 != 0) goto L_0x002a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x036c }
            r0.<init>()     // Catch:{ all -> 0x036c }
            com.introvd.template.sdk.utils.b.a.b r2 = eiw     // Catch:{ all -> 0x036c }
            java.lang.String r3 = r2.eiF     // Catch:{ all -> 0x036c }
            r0.append(r3)     // Catch:{ all -> 0x036c }
            java.lang.String r3 = "startProducer fail,storyboard=null"
            r0.append(r3)     // Catch:{ all -> 0x036c }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x036c }
            r2.eiF = r0     // Catch:{ all -> 0x036c }
            r0 = 5
            monitor-exit(r27)
            return r0
        L_0x002a:
            com.introvd.template.sdk.model.editor.VideoExportParamsModel r2 = r1.eiJ     // Catch:{ all -> 0x036c }
            r3 = 2
            if (r2 != 0) goto L_0x0048
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x036c }
            r0.<init>()     // Catch:{ all -> 0x036c }
            com.introvd.template.sdk.utils.b.a.b r2 = eiw     // Catch:{ all -> 0x036c }
            java.lang.String r4 = r2.eiF     // Catch:{ all -> 0x036c }
            r0.append(r4)     // Catch:{ all -> 0x036c }
            java.lang.String r4 = "startProducer fail,mParams=null"
            r0.append(r4)     // Catch:{ all -> 0x036c }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x036c }
            r2.eiF = r0     // Catch:{ all -> 0x036c }
            monitor-exit(r27)
            return r3
        L_0x0048:
            boolean r2 = r1.eik     // Catch:{ all -> 0x036c }
            if (r2 == 0) goto L_0x00bd
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x036c }
            r2.<init>()     // Catch:{ all -> 0x036c }
            r2.append(r0)     // Catch:{ all -> 0x036c }
            java.lang.String r4 = "tmp_export_xiaoying"
            r2.append(r4)     // Catch:{ all -> 0x036c }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x036c }
            r1.eiv = r2     // Catch:{ all -> 0x036c }
            com.introvd.template.sdk.model.editor.VideoExportParamsModel r2 = r1.eiJ     // Catch:{ all -> 0x036c }
            boolean r2 = r2.isGifExp()     // Catch:{ all -> 0x036c }
            if (r2 == 0) goto L_0x007d
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x036c }
            r2.<init>()     // Catch:{ all -> 0x036c }
            java.lang.String r4 = r1.eiv     // Catch:{ all -> 0x036c }
            r2.append(r4)     // Catch:{ all -> 0x036c }
            java.lang.String r4 = ".gif"
            r2.append(r4)     // Catch:{ all -> 0x036c }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x036c }
            r1.eiv = r2     // Catch:{ all -> 0x036c }
            goto L_0x00b0
        L_0x007d:
            com.introvd.template.sdk.model.editor.VideoExportParamsModel r2 = r1.eiJ     // Catch:{ all -> 0x036c }
            boolean r2 = r2.isAudioExp()     // Catch:{ all -> 0x036c }
            if (r2 == 0) goto L_0x009b
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x036c }
            r2.<init>()     // Catch:{ all -> 0x036c }
            java.lang.String r4 = r1.eiv     // Catch:{ all -> 0x036c }
            r2.append(r4)     // Catch:{ all -> 0x036c }
            java.lang.String r4 = ".m4a"
            r2.append(r4)     // Catch:{ all -> 0x036c }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x036c }
            r1.eiv = r2     // Catch:{ all -> 0x036c }
            goto L_0x00b0
        L_0x009b:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x036c }
            r2.<init>()     // Catch:{ all -> 0x036c }
            java.lang.String r4 = r1.eiv     // Catch:{ all -> 0x036c }
            r2.append(r4)     // Catch:{ all -> 0x036c }
            java.lang.String r4 = ".mp4"
            r2.append(r4)     // Catch:{ all -> 0x036c }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x036c }
            r1.eiv = r2     // Catch:{ all -> 0x036c }
        L_0x00b0:
            java.lang.String r2 = r1.eiv     // Catch:{ all -> 0x036c }
            boolean r2 = com.introvd.template.sdk.utils.C8548e.isFileExisted(r2)     // Catch:{ all -> 0x036c }
            if (r2 == 0) goto L_0x00bd
            java.lang.String r2 = r1.eiv     // Catch:{ all -> 0x036c }
            com.introvd.template.sdk.utils.C8548e.deleteFile(r2)     // Catch:{ all -> 0x036c }
        L_0x00bd:
            xiaoying.engine.QEngine r4 = r1.engine     // Catch:{ all -> 0x036c }
            long r10 = com.introvd.template.sdk.utils.C8548e.getFreeSpace(r28)     // Catch:{ all -> 0x036c }
            r5 = 512000(0x7d000, double:2.529616E-318)
            long r18 = r10 - r5
            xiaoying.engine.base.QSessionStream r2 = r1.eeR     // Catch:{ all -> 0x036c }
            if (r2 == 0) goto L_0x00d1
            xiaoying.engine.base.QSessionStream r2 = r1.eeR     // Catch:{ all -> 0x036c }
            r2.close()     // Catch:{ all -> 0x036c }
        L_0x00d1:
            r2 = 0
            r1.eeR = r2     // Catch:{ all -> 0x036c }
            xiaoying.engine.producer.QProducer r5 = new xiaoying.engine.producer.QProducer     // Catch:{ all -> 0x036c }
            r5.<init>()     // Catch:{ all -> 0x036c }
            r1.eig = r5     // Catch:{ all -> 0x036c }
            xiaoying.engine.storyboard.QStoryboard r5 = r1.cFJ     // Catch:{ all -> 0x036c }
            int r5 = com.introvd.template.sdk.utils.C8572y.m25105y(r5)     // Catch:{ all -> 0x036c }
            com.introvd.template.sdk.model.editor.VideoExportParamsModel r6 = r1.eiJ     // Catch:{ all -> 0x036c }
            boolean r12 = r6.isGifExp()     // Catch:{ all -> 0x036c }
            if (r12 == 0) goto L_0x012a
            com.introvd.template.sdk.model.editor.VideoExportParamsModel r6 = r1.eiJ     // Catch:{ all -> 0x036c }
            com.introvd.template.sdk.model.GifExpModel r6 = r6.gifParam     // Catch:{ all -> 0x036c }
            if (r6 == 0) goto L_0x012a
            r3 = 18
            com.introvd.template.sdk.model.editor.VideoExportParamsModel r5 = r1.eiJ     // Catch:{ all -> 0x036c }
            com.introvd.template.sdk.model.GifExpModel r5 = r5.gifParam     // Catch:{ all -> 0x036c }
            int r5 = r5.expFps     // Catch:{ all -> 0x036c }
            xiaoying.engine.producer.QProducer r6 = r1.eig     // Catch:{ all -> 0x036c }
            r7 = 24580(0x6004, float:3.4444E-41)
            java.lang.Boolean r8 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x036c }
            int r6 = r6.setProperty(r7, r8)     // Catch:{ all -> 0x036c }
            if (r6 == 0) goto L_0x0126
            xiaoying.engine.producer.QProducer r0 = r1.eig     // Catch:{ all -> 0x036c }
            r0.unInit()     // Catch:{ all -> 0x036c }
            r1.eig = r2     // Catch:{ all -> 0x036c }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x036c }
            r0.<init>()     // Catch:{ all -> 0x036c }
            com.introvd.template.sdk.utils.b.a.b r2 = eiw     // Catch:{ all -> 0x036c }
            java.lang.String r3 = r2.eiF     // Catch:{ all -> 0x036c }
            r0.append(r3)     // Catch:{ all -> 0x036c }
            java.lang.String r3 = "startProducer fail,setProperty GIF_ENCODER fail iRes="
            r0.append(r3)     // Catch:{ all -> 0x036c }
            r0.append(r6)     // Catch:{ all -> 0x036c }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x036c }
            r2.eiF = r0     // Catch:{ all -> 0x036c }
            monitor-exit(r27)
            return r6
        L_0x0126:
            r3 = r5
            r13 = 18
            goto L_0x012c
        L_0x012a:
            r3 = r5
            r13 = 2
        L_0x012c:
            xiaoying.engine.producer.QProducer r5 = r1.eig     // Catch:{ all -> 0x036c }
            int r5 = r5.init(r4, r1)     // Catch:{ all -> 0x036c }
            if (r5 == 0) goto L_0x0157
            xiaoying.engine.producer.QProducer r0 = r1.eig     // Catch:{ all -> 0x036c }
            r0.unInit()     // Catch:{ all -> 0x036c }
            r1.eig = r2     // Catch:{ all -> 0x036c }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x036c }
            r0.<init>()     // Catch:{ all -> 0x036c }
            com.introvd.template.sdk.utils.b.a.b r2 = eiw     // Catch:{ all -> 0x036c }
            java.lang.String r3 = r2.eiF     // Catch:{ all -> 0x036c }
            r0.append(r3)     // Catch:{ all -> 0x036c }
            java.lang.String r3 = "startProducer fail,mProducer.init fail iRes="
            r0.append(r3)     // Catch:{ all -> 0x036c }
            r0.append(r5)     // Catch:{ all -> 0x036c }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x036c }
            r2.eiF = r0     // Catch:{ all -> 0x036c }
            monitor-exit(r27)
            return r5
        L_0x0157:
            com.introvd.template.sdk.model.editor.VideoExportParamsModel r5 = r1.eiJ     // Catch:{ all -> 0x036c }
            java.lang.Integer r5 = r5.expType     // Catch:{ all -> 0x036c }
            int r5 = r5.intValue()     // Catch:{ all -> 0x036c }
            r6 = 6
            r15 = 0
            r26 = 1
            if (r5 != r6) goto L_0x0184
            r5 = 4
            r1.eix = r15     // Catch:{ all -> 0x036c }
            xiaoying.engine.storyboard.QStoryboard r6 = r1.cFJ     // Catch:{ all -> 0x036c }
            xiaoying.engine.clip.QClip r6 = r6.getClip(r15)     // Catch:{ all -> 0x036c }
            r7 = 12290(0x3002, float:1.7222E-41)
            java.lang.Object r6 = r6.getProperty(r7)     // Catch:{ all -> 0x036c }
            xiaoying.engine.clip.QMediaSource r6 = (xiaoying.engine.clip.QMediaSource) r6     // Catch:{ all -> 0x036c }
            xiaoying.engine.producer.QProducer r7 = r1.eig     // Catch:{ all -> 0x036c }
            r8 = 24584(0x6008, float:3.445E-41)
            java.lang.Object r6 = r6.getSource()     // Catch:{ all -> 0x036c }
            r7.setProperty(r8, r6)     // Catch:{ all -> 0x036c }
            r16 = 4
            goto L_0x0186
        L_0x0184:
            r16 = 1
        L_0x0186:
            int r23 = com.introvd.template.sdk.editor.p389c.C8438d.aIF()     // Catch:{ all -> 0x036c }
            com.introvd.template.sdk.model.editor.VideoExportParamsModel r5 = r1.eiJ     // Catch:{ all -> 0x036c }
            int r14 = r5.encodeType     // Catch:{ all -> 0x036c }
            int r7 = r1.eix     // Catch:{ all -> 0x036c }
            int r8 = r1.eiy     // Catch:{ all -> 0x036c }
            int r9 = r1.eiz     // Catch:{ all -> 0x036c }
            r5 = r3
            r6 = r14
            long r4 = com.introvd.template.sdk.editor.p389c.C8438d.m24389a(r4, r5, r6, r7, r8, r9)     // Catch:{ all -> 0x036c }
            float r4 = (float) r4     // Catch:{ all -> 0x036c }
            com.introvd.template.sdk.model.editor.VideoExportParamsModel r5 = r1.eiJ     // Catch:{ all -> 0x036c }
            float r5 = r5.videoBitrateScales     // Catch:{ all -> 0x036c }
            float r4 = r4 * r5
            long r4 = (long) r4     // Catch:{ all -> 0x036c }
            java.lang.String r6 = "ProjectExportUtils"
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x036c }
            r7.<init>()     // Catch:{ all -> 0x036c }
            java.lang.String r8 = "calcVideoBitrate lVideoBitrate="
            r7.append(r8)     // Catch:{ all -> 0x036c }
            r7.append(r4)     // Catch:{ all -> 0x036c }
            java.lang.String r8 = ";scale="
            r7.append(r8)     // Catch:{ all -> 0x036c }
            com.introvd.template.sdk.model.editor.VideoExportParamsModel r8 = r1.eiJ     // Catch:{ all -> 0x036c }
            float r8 = r8.videoBitrateScales     // Catch:{ all -> 0x036c }
            r7.append(r8)     // Catch:{ all -> 0x036c }
            java.lang.String r8 = "; encodeType="
            r7.append(r8)     // Catch:{ all -> 0x036c }
            r7.append(r14)     // Catch:{ all -> 0x036c }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x036c }
            com.introvd.template.sdk.utils.C8554j.m25007e(r6, r7)     // Catch:{ all -> 0x036c }
            boolean r6 = r1.eik     // Catch:{ all -> 0x036c }
            if (r6 == 0) goto L_0x01d3
            java.lang.String r6 = r1.eiv     // Catch:{ all -> 0x036c }
            goto L_0x01d5
        L_0x01d3:
            java.lang.String r6 = r1.eit     // Catch:{ all -> 0x036c }
        L_0x01d5:
            r20 = r6
            com.introvd.template.sdk.model.editor.VideoExportParamsModel r6 = r1.eiJ     // Catch:{ all -> 0x036c }
            xiaoying.engine.base.QRange r22 = r1.m24620a(r6, r12)     // Catch:{ all -> 0x036c }
            java.lang.Boolean r6 = com.introvd.template.sdk.p383c.C8400d.edj     // Catch:{ all -> 0x036c }
            boolean r6 = r6.booleanValue()     // Catch:{ all -> 0x036c }
            if (r6 == 0) goto L_0x01ec
            java.lang.String r6 = r27.aJX()     // Catch:{ all -> 0x036c }
            r25 = r6
            goto L_0x01ee
        L_0x01ec:
            r25 = r2
        L_0x01ee:
            xiaoying.engine.producer.QProducerProperty r6 = new xiaoying.engine.producer.QProducerProperty     // Catch:{ all -> 0x036c }
            int r7 = r1.eix     // Catch:{ all -> 0x036c }
            int r3 = r3 * 1000
            int r4 = (int) r4     // Catch:{ all -> 0x036c }
            r24 = 40
            r12 = r6
            r5 = r14
            r14 = r7
            r7 = 0
            r15 = r16
            r16 = r3
            r17 = r4
            r21 = r5
            r12.<init>(r13, r14, r15, r16, r17, r18, r20, r21, r22, r23, r24, r25)     // Catch:{ all -> 0x036c }
            r3 = 60
            r6.maxExpFps = r3     // Catch:{ all -> 0x036c }
            xiaoying.engine.producer.QProducer r3 = r1.eig     // Catch:{ all -> 0x036c }
            r4 = 24577(0x6001, float:3.444E-41)
            int r3 = r3.setProperty(r4, r6)     // Catch:{ all -> 0x036c }
            if (r3 == 0) goto L_0x0237
            xiaoying.engine.producer.QProducer r0 = r1.eig     // Catch:{ all -> 0x036c }
            r0.unInit()     // Catch:{ all -> 0x036c }
            r1.eig = r2     // Catch:{ all -> 0x036c }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x036c }
            r0.<init>()     // Catch:{ all -> 0x036c }
            com.introvd.template.sdk.utils.b.a.b r2 = eiw     // Catch:{ all -> 0x036c }
            java.lang.String r4 = r2.eiF     // Catch:{ all -> 0x036c }
            r0.append(r4)     // Catch:{ all -> 0x036c }
            java.lang.String r4 = "startProducer fail,setProperty PROP_PARAM fail iRes="
            r0.append(r4)     // Catch:{ all -> 0x036c }
            r0.append(r3)     // Catch:{ all -> 0x036c }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x036c }
            r2.eiF = r0     // Catch:{ all -> 0x036c }
            monitor-exit(r27)
            return r3
        L_0x0237:
            xiaoying.engine.storyboard.QStoryboard r3 = r1.cFJ     // Catch:{ all -> 0x036c }
            com.introvd.template.sdk.utils.VeMSize r4 = r1.egg     // Catch:{ all -> 0x036c }
            com.introvd.template.sdk.utils.b.a.i r5 = r1.eiK     // Catch:{ all -> 0x036c }
            java.lang.Long r5 = r5.eiP     // Catch:{ all -> 0x036c }
            long r5 = r5.longValue()     // Catch:{ all -> 0x036c }
            xiaoying.engine.base.QSessionStream r3 = r1.m24621a(r3, r4, r5)     // Catch:{ all -> 0x036c }
            r1.eeR = r3     // Catch:{ all -> 0x036c }
            xiaoying.engine.base.QSessionStream r3 = r1.eeR     // Catch:{ all -> 0x036c }
            if (r3 != 0) goto L_0x0256
            xiaoying.engine.producer.QProducer r0 = r1.eig     // Catch:{ all -> 0x036c }
            r0.unInit()     // Catch:{ all -> 0x036c }
            r1.eig = r2     // Catch:{ all -> 0x036c }
            monitor-exit(r27)
            return r26
        L_0x0256:
            xiaoying.engine.producer.QProducer r3 = r1.eig     // Catch:{ all -> 0x036c }
            xiaoying.engine.base.QSessionStream r4 = r1.eeR     // Catch:{ all -> 0x036c }
            int r3 = r3.activeStream(r4)     // Catch:{ all -> 0x036c }
            if (r3 == 0) goto L_0x028e
            xiaoying.engine.producer.QProducer r0 = r1.eig     // Catch:{ all -> 0x036c }
            r0.unInit()     // Catch:{ all -> 0x036c }
            r1.eig = r2     // Catch:{ all -> 0x036c }
            xiaoying.engine.base.QSessionStream r0 = r1.eeR     // Catch:{ all -> 0x036c }
            if (r0 == 0) goto L_0x0270
            xiaoying.engine.base.QSessionStream r0 = r1.eeR     // Catch:{ all -> 0x036c }
            r0.close()     // Catch:{ all -> 0x036c }
        L_0x0270:
            r1.eeR = r2     // Catch:{ all -> 0x036c }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x036c }
            r0.<init>()     // Catch:{ all -> 0x036c }
            com.introvd.template.sdk.utils.b.a.b r2 = eiw     // Catch:{ all -> 0x036c }
            java.lang.String r4 = r2.eiF     // Catch:{ all -> 0x036c }
            r0.append(r4)     // Catch:{ all -> 0x036c }
            java.lang.String r4 = "startProducer fail,mProducer.activeStream fail iRes="
            r0.append(r4)     // Catch:{ all -> 0x036c }
            r0.append(r3)     // Catch:{ all -> 0x036c }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x036c }
            r2.eiF = r0     // Catch:{ all -> 0x036c }
            monitor-exit(r27)
            return r3
        L_0x028e:
            xiaoying.engine.producer.QProducer r3 = r1.eig     // Catch:{ all -> 0x036c }
            r4 = 24579(0x6003, float:3.4443E-41)
            java.lang.Object r3 = r3.getProperty(r4)     // Catch:{ all -> 0x036c }
            java.lang.Integer r3 = (java.lang.Integer) r3     // Catch:{ all -> 0x036c }
            int r3 = r3.intValue()     // Catch:{ all -> 0x036c }
            long r3 = (long) r3     // Catch:{ all -> 0x036c }
            int r5 = (r10 > r3 ? 1 : (r10 == r3 ? 0 : -1))
            if (r5 > 0) goto L_0x0306
            xiaoying.engine.producer.QProducer r5 = r1.eig     // Catch:{ all -> 0x036c }
            r5.unInit()     // Catch:{ all -> 0x036c }
            r1.eig = r2     // Catch:{ all -> 0x036c }
            xiaoying.engine.base.QSessionStream r5 = r1.eeR     // Catch:{ all -> 0x036c }
            if (r5 == 0) goto L_0x02b1
            xiaoying.engine.base.QSessionStream r5 = r1.eeR     // Catch:{ all -> 0x036c }
            r5.close()     // Catch:{ all -> 0x036c }
        L_0x02b1:
            r1.eeR = r2     // Catch:{ all -> 0x036c }
            java.lang.String r2 = "/DCIM/"
            java.lang.String r5 = android.os.Environment.DIRECTORY_DCIM     // Catch:{ Exception -> 0x02c0 }
            java.io.File r5 = android.os.Environment.getExternalStoragePublicDirectory(r5)     // Catch:{ Exception -> 0x02c0 }
            java.lang.String r5 = r5.getAbsolutePath()     // Catch:{ Exception -> 0x02c0 }
            r2 = r5
        L_0x02c0:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x036c }
            r5.<init>()     // Catch:{ all -> 0x036c }
            com.introvd.template.sdk.utils.b.a.b r6 = eiw     // Catch:{ all -> 0x036c }
            java.lang.String r7 = r6.eiF     // Catch:{ all -> 0x036c }
            r5.append(r7)     // Catch:{ all -> 0x036c }
            java.lang.String r7 = "filepath=["
            r5.append(r7)     // Catch:{ all -> 0x036c }
            r5.append(r0)     // Catch:{ all -> 0x036c }
            java.lang.String r0 = "]  startProducer fail, freespace="
            r5.append(r0)     // Catch:{ all -> 0x036c }
            java.lang.String r0 = com.introvd.template.sdk.utils.C8548e.formatFileSize(r10)     // Catch:{ all -> 0x036c }
            r5.append(r0)     // Catch:{ all -> 0x036c }
            java.lang.String r0 = ", disk not enough for expFileLen="
            r5.append(r0)     // Catch:{ all -> 0x036c }
            java.lang.String r0 = com.introvd.template.sdk.utils.C8548e.formatFileSize(r3)     // Catch:{ all -> 0x036c }
            r5.append(r0)     // Catch:{ all -> 0x036c }
            java.lang.String r0 = ", disk freesize2="
            r5.append(r0)     // Catch:{ all -> 0x036c }
            long r2 = com.introvd.template.sdk.utils.C8548e.getFreeSpace(r2)     // Catch:{ all -> 0x036c }
            java.lang.String r0 = com.introvd.template.sdk.utils.C8548e.formatFileSize(r2)     // Catch:{ all -> 0x036c }
            r5.append(r0)     // Catch:{ all -> 0x036c }
            java.lang.String r0 = r5.toString()     // Catch:{ all -> 0x036c }
            r6.eiF = r0     // Catch:{ all -> 0x036c }
            r0 = 11
            monitor-exit(r27)
            return r0
        L_0x0306:
            xiaoying.engine.producer.QProducer r0 = r1.eig     // Catch:{ Exception -> 0x0354 }
            int r0 = r0.start()     // Catch:{ Exception -> 0x0354 }
            if (r0 == 0) goto L_0x033c
            xiaoying.engine.producer.QProducer r3 = r1.eig     // Catch:{ Exception -> 0x0354 }
            r3.unInit()     // Catch:{ Exception -> 0x0354 }
            r1.eig = r2     // Catch:{ Exception -> 0x0354 }
            xiaoying.engine.base.QSessionStream r3 = r1.eeR     // Catch:{ Exception -> 0x0354 }
            if (r3 == 0) goto L_0x031e
            xiaoying.engine.base.QSessionStream r3 = r1.eeR     // Catch:{ Exception -> 0x0354 }
            r3.close()     // Catch:{ Exception -> 0x0354 }
        L_0x031e:
            r1.eeR = r2     // Catch:{ Exception -> 0x0354 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0354 }
            r3.<init>()     // Catch:{ Exception -> 0x0354 }
            com.introvd.template.sdk.utils.b.a.b r4 = eiw     // Catch:{ Exception -> 0x0354 }
            java.lang.String r5 = r4.eiF     // Catch:{ Exception -> 0x0354 }
            r3.append(r5)     // Catch:{ Exception -> 0x0354 }
            java.lang.String r5 = "startProducer fail,mProducer.start fail iRes="
            r3.append(r5)     // Catch:{ Exception -> 0x0354 }
            r3.append(r0)     // Catch:{ Exception -> 0x0354 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x0354 }
            r4.eiF = r3     // Catch:{ Exception -> 0x0354 }
            monitor-exit(r27)
            return r0
        L_0x033c:
            boolean r0 = r1.eik     // Catch:{ all -> 0x036c }
            if (r0 == 0) goto L_0x034b
            com.introvd.template.systemevent.c r0 = r1.eij     // Catch:{ all -> 0x036c }
            if (r0 == 0) goto L_0x034b
            com.introvd.template.systemevent.c r0 = r1.eij     // Catch:{ all -> 0x036c }
            java.lang.String r2 = r1.eiv     // Catch:{ all -> 0x036c }
            r0.mo34896oZ(r2)     // Catch:{ all -> 0x036c }
        L_0x034b:
            java.lang.String r0 = "ProjectExportUtils"
            java.lang.String r2 = "startProducer out"
            com.introvd.template.sdk.utils.C8554j.m25007e(r0, r2)     // Catch:{ all -> 0x036c }
            monitor-exit(r27)
            return r7
        L_0x0354:
            xiaoying.engine.producer.QProducer r0 = r1.eig     // Catch:{ all -> 0x036c }
            if (r0 == 0) goto L_0x035f
            xiaoying.engine.producer.QProducer r0 = r1.eig     // Catch:{ all -> 0x036c }
            r0.unInit()     // Catch:{ all -> 0x036c }
            r1.eig = r2     // Catch:{ all -> 0x036c }
        L_0x035f:
            xiaoying.engine.base.QSessionStream r0 = r1.eeR     // Catch:{ all -> 0x036c }
            if (r0 == 0) goto L_0x0368
            xiaoying.engine.base.QSessionStream r0 = r1.eeR     // Catch:{ all -> 0x036c }
            r0.close()     // Catch:{ all -> 0x036c }
        L_0x0368:
            r1.eeR = r2     // Catch:{ all -> 0x036c }
            monitor-exit(r27)
            return r26
        L_0x036c:
            r0 = move-exception
            monitor-exit(r27)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.sdk.utils.p394b.p395a.C8510e.m24625oS(java.lang.String):int");
    }

    /* renamed from: a */
    public int mo34691a(final String str, final VideoExportParamsModel videoExportParamsModel) {
        this.eiJ = videoExportParamsModel;
        C8438d.m24391a(this.engine, str, (Handler) new Handler(mHandlerThread.getLooper()) {
            public void handleMessage(Message message) {
                if (message.what == 268443649) {
                    C8510e.this.eis = true;
                    C8510e.this.mo34693a(str, (QStoryboard) message.obj, videoExportParamsModel);
                }
            }
        });
        return 0;
    }

    /* renamed from: a */
    public int mo34692a(String str, String str2, QStoryboard qStoryboard, VeMSize veMSize, int i, VideoExportParamsModel videoExportParamsModel) {
        this.eiJ = videoExportParamsModel;
        if (videoExportParamsModel == null || qStoryboard == null) {
            return 1;
        }
        this.cFJ = qStoryboard;
        C8554j.m25007e("ProjectExportUtils", "ShowDialog in");
        if (TextUtils.isEmpty(str2) || veMSize == null || veMSize.width <= 0 || veMSize.height <= 0) {
            return 2;
        }
        this.egg = veMSize;
        this.eiy = veMSize.width;
        this.eiz = veMSize.height;
        if (i == 4 || i == 2) {
            this.eix = i;
        } else {
            this.eix = this.eiJ.decodeType == 4 ? 4 : 2;
            if (this.eix == 4 && !QUtils.QueryHWEncCap(this.engine, this.eix, this.eiy, this.eiz)) {
                this.eix = 2;
            }
        }
        int oR = m24600oR(str);
        if (oR != 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("exportExternalFile presave error;mediaPath=");
            sb.append(str);
            String sb2 = sb.toString();
            if (this.dcs != null) {
                this.dcs.mo29117n(oR, sb2);
            }
            return oR;
        }
        aJW();
        if (6 == videoExportParamsModel.expType.intValue()) {
            this.eit = mo34682w(str, str2, ".m4a");
        } else {
            this.eit = mo34682w(str, str2, ".mp4");
        }
        mo34680oQ(str);
        return oR;
    }

    /* renamed from: a */
    public int mo34693a(String str, QStoryboard qStoryboard, VideoExportParamsModel videoExportParamsModel) {
        String str2;
        String str3;
        String str4;
        this.eiJ = videoExportParamsModel;
        if (qStoryboard == null) {
            return 1;
        }
        this.cFJ = qStoryboard;
        if (this.cFJ.getDataClip() == null) {
            eiw.eiF = "异常：mStoryboard.getDataClip() == null";
            return 5;
        }
        if (videoExportParamsModel.isSingleHW) {
            this.cFJ.setProperty(QStoryboard.PROP_SINGLE_HW_INSTANCE, Boolean.valueOf(true));
        }
        if (videoExportParamsModel.bTransitionStatic) {
            C8540q.m24896E(this.cFJ);
        }
        C8554j.m25007e("ProjectExportUtils", "ShowDialog in");
        if (TextUtils.isEmpty(str)) {
            return 2;
        }
        this.egg = C8438d.m24393b(videoExportParamsModel);
        if (this.eiK.eiQ) {
            QStoryboard qStoryboard2 = new QStoryboard();
            this.cFJ.duplicate(qStoryboard2);
            this.cFJ = qStoryboard2;
            C8419a.m24321a(this.cFJ, this.eiK.cVR, this.eiK.eiR, this.eiK.mStreamSizeVe);
        }
        if (this.egg != null) {
            this.eiy = this.egg.width;
            this.eiz = this.egg.height;
        }
        if (this.eiy == 0 && this.eiz == 0) {
            QClip dataClip = this.cFJ.getDataClip();
            if (dataClip != null) {
                QVideoInfo qVideoInfo = (QVideoInfo) dataClip.getProperty(12291);
                if (qVideoInfo != null) {
                    this.eiy = qVideoInfo.get(3);
                    this.eiz = qVideoInfo.get(4);
                }
            }
        }
        if (this.egg == null || this.egg.width == 0 || this.egg.height == 0) {
            this.egg = new VeMSize(this.eiy, this.eiz);
        }
        if (this.eiz == 0 || this.eiy == 0) {
            eiw.eiF = "exportProject() stream size (0,0)";
        }
        C8540q.m24935a(this.cFJ, this.egg);
        this.eix = 4;
        if (videoExportParamsModel.isGifExp()) {
            this.eix = 10;
        }
        boolean z = !TextUtils.isEmpty(videoExportParamsModel.assignedPath);
        String str5 = null;
        if (z) {
            String fileParentPath = C8548e.getFileParentPath(videoExportParamsModel.assignedPath);
            String od = C8548e.m24999od(videoExportParamsModel.assignedPath);
            str2 = C8548e.getFileExtFromAbPath(videoExportParamsModel.assignedPath);
            C8548e.createMultilevelDirectory(fileParentPath);
            String str6 = od;
            str3 = fileParentPath;
            str5 = str6;
        } else {
            str3 = C8401d.anh();
            str2 = ".mp4";
            if (videoExportParamsModel.isGifExp()) {
                str2 = ".gif";
            }
        }
        int oR = m24600oR(str3);
        if (oR != 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("preSave fail path=");
            sb.append(str3);
            String sb2 = sb.toString();
            if (this.dcs != null) {
                this.dcs.mo29117n(oR, sb2);
            }
            return oR;
        }
        aJW();
        if (z) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(str3);
            sb3.append(str5);
            sb3.append(str2);
            str4 = sb3.toString();
        } else {
            StringBuilder sb4 = new StringBuilder();
            sb4.append("_");
            sb4.append(System.currentTimeMillis());
            String sb5 = sb4.toString();
            StringBuilder sb6 = new StringBuilder();
            sb6.append("StarVlogs_Video");
            sb6.append(sb5);
            String sb7 = sb6.toString();
            if (videoExportParamsModel.expType.intValue() == 1) {
                StringBuilder sb8 = new StringBuilder();
                sb8.append(sb7);
                sb8.append("_HD");
                sb7 = sb8.toString();
            } else if (videoExportParamsModel.expType.intValue() == 2) {
                StringBuilder sb9 = new StringBuilder();
                sb9.append(sb7);
                sb9.append("_1080HD");
                sb7 = sb9.toString();
            }
            str4 = C8548e.getFreeFileName(str3, sb7, str2, 0);
        }
        this.eit = str4;
        mo34680oQ(str3);
        return oR;
    }

    public boolean aJQ() {
        if (this.cFJ == null || this.eij == null) {
            return false;
        }
        if (this.cFJ.getDataClip() != null) {
            String Y = m24619Y(this.cFJ);
            if (Y != null) {
                this.eij.mo34897pa(Y);
            }
        }
        for (int i = 0; i < this.cFJ.getClipCount(); i++) {
            QClip clip = this.cFJ.getClip(i);
            if (clip != null) {
                QMediaSource qMediaSource = (QMediaSource) clip.getProperty(12290);
                if (qMediaSource != null && qMediaSource.getSourceType() == 0) {
                    String str = (String) qMediaSource.getSource();
                    if (str != null) {
                        this.eij.mo34897pa(str);
                    }
                }
            }
        }
        return true;
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
        if (this.cFJ == null || this.eij == null) {
            return false;
        }
        if (this.cFJ.getDataClip() != null) {
            String Y = m24619Y(this.cFJ);
            if (Y != null) {
                this.eij.mo34896oZ(Y);
            }
        }
        for (int i = 0; i < this.cFJ.getClipCount(); i++) {
            QClip clip = this.cFJ.getClip(i);
            if (clip != null) {
                QMediaSource qMediaSource = (QMediaSource) clip.getProperty(12290);
                if (qMediaSource != null && qMediaSource.getSourceType() == 0) {
                    String str = (String) qMediaSource.getSource();
                    if (str != null) {
                        this.eij.mo34896oZ(str);
                    }
                }
            }
        }
        return true;
    }

    /* renamed from: b */
    public synchronized int mo34677b(C8508c cVar, String str) {
        int oS = m24625oS(str);
        if (oS != 0) {
            aJQ();
            if (!this.eil) {
                cVar.mo29117n(oS, "projectExportUtils.startProducer fail");
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
        sb.append(str3);
        String sb2 = sb.toString();
        int i = 0;
        while (true) {
            File file = new File(sb2);
            if (!file.isFile() || !file.exists()) {
                return sb2;
            }
            StringBuilder sb3 = new StringBuilder();
            sb3.append(str);
            sb3.append(str2);
            sb3.append("_");
            sb3.append(i);
            sb3.append(str3);
            sb2 = sb3.toString();
            i++;
        }
        return sb2;
    }
}
