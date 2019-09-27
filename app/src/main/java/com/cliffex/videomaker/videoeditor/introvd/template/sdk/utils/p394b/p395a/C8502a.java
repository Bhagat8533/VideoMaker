package com.introvd.template.sdk.utils.p394b.p395a;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import com.introvd.template.sdk.utils.C8548e;
import com.introvd.template.sdk.utils.C8550g;
import com.introvd.template.sdk.utils.C8554j;
import com.introvd.template.sdk.utils.VeMSize;
import com.introvd.template.sdk.utils.p393a.C8484b;
import com.introvd.template.systemevent.C8608c;
import java.io.File;
import java.lang.ref.WeakReference;
import xiaoying.engine.QEngine;
import xiaoying.engine.base.IQSessionStateListener;
import xiaoying.engine.base.QSessionState;
import xiaoying.engine.base.QSessionStream;
import xiaoying.engine.base.QVEError;
import xiaoying.engine.producer.QProducer;
import xiaoying.engine.producer.QProducer.QProducerErrInfo;

/* renamed from: com.introvd.template.sdk.utils.b.a.a */
public abstract class C8502a implements IQSessionStateListener {
    public static C8507b eiw = new C8507b();
    protected static HandlerThread mHandlerThread;
    protected C8512f dcs = new C8512f() {
        public void ama() {
            C8502a.this.eiA.sendEmptyMessage(3);
        }

        public void amb() {
            C8502a.this.eiA.sendEmptyMessage(4);
        }

        public void apX() {
            C8502a.this.eiA.sendEmptyMessage(5);
        }

        /* renamed from: av */
        public void mo29115av(float f) {
            C8502a.this.eiA.sendMessage(C8502a.this.eiA.obtainMessage(1, 0, 0, Float.valueOf(f)));
        }

        /* renamed from: hM */
        public void mo29116hM(String str) {
            C8502a.this.eiA.sendMessage(C8502a.this.eiA.obtainMessage(0, 0, 0, str));
        }

        /* renamed from: n */
        public void mo29117n(int i, String str) {
            C8554j.m25007e("AbstractExportUtil", "AbstractExportUtil onExportFailed 2");
            C8502a.this.eiA.sendMessage(C8502a.this.eiA.obtainMessage(2, i, 0, str));
        }
    };
    protected QSessionStream eeR = null;
    protected VeMSize egg;
    protected C8504a eiA = new C8504a(this);
    protected QProducer eig = null;
    protected C8508c eih = null;
    protected C8506c eii = null;
    protected C8608c eij = null;
    protected boolean eik = true;
    protected boolean eil = false;
    private int eim = 0;
    public int ein = 0;
    /* access modifiers changed from: private */
    public volatile int eio = 0;
    private final int eip = 0;
    private float eiq = 0.0f;
    private boolean eir = false;
    protected boolean eis = false;
    protected String eit = null;
    private boolean eiu = true;
    protected String eiv = null;
    protected int eix;
    protected int eiy;
    protected int eiz;
    protected QEngine engine;
    private int mThreadPriority = 0;

    /* renamed from: com.introvd.template.sdk.utils.b.a.a$a */
    private static class C8504a extends Handler {
        private WeakReference<C8502a> eiC = null;

        C8504a(C8502a aVar) {
            super(Looper.getMainLooper());
            this.eiC = new WeakReference<>(aVar);
        }

        public void handleMessage(Message message) {
            C8502a aVar = (C8502a) this.eiC.get();
            if (aVar != null) {
                try {
                    if (aVar.eih != null) {
                        switch (message.what) {
                            case 0:
                                aVar.eih.mo29116hM((String) message.obj);
                                break;
                            case 1:
                                aVar.eih.mo29115av(((Float) message.obj).floatValue());
                                break;
                            case 2:
                                C8554j.m25007e("AbstractExportUtil", "AbstractExportUtil onExportFailed 1");
                                aVar.eih.mo29117n(message.arg1, (String) message.obj);
                                break;
                            case 3:
                                aVar.eih.ama();
                                break;
                            case 4:
                                aVar.eih.amb();
                                break;
                            case 5:
                                aVar.eih.apX();
                                break;
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* renamed from: com.introvd.template.sdk.utils.b.a.a$b */
    class C8505b extends C8484b<Void, Void, Boolean> {
        long eiD = 0;

        C8505b() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Boolean doInBackground(Void... voidArr) {
            C8554j.m25007e("AbstractExportUtil", "doInBackground");
            this.eiD = System.currentTimeMillis();
            C8502a.this.destroy();
            this.eiD = System.currentTimeMillis() - this.eiD;
            StringBuilder sb = new StringBuilder();
            sb.append(">>>>>>BackgroundTask  cost-time: ");
            sb.append(this.eiD);
            C8554j.m25007e("AbstractExportUtil", sb.toString());
            return Boolean.valueOf(true);
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            if (C8502a.this.eii != null) {
                C8502a.this.eii.removeCallbacksAndMessages(null);
            }
            super.onPreExecute();
        }

        /* access modifiers changed from: protected */
        /* renamed from: r */
        public void onPostExecute(Boolean bool) {
            StringBuilder sb = new StringBuilder();
            sb.append("onPostExecute int result:");
            sb.append(bool);
            C8554j.m25007e("AbstractExportUtil", sb.toString());
            super.onPostExecute(bool);
            C8554j.m25007e("AbstractExportUtil", "onPostExecute out");
            if (C8502a.this.dcs != null) {
                C8502a.this.dcs.amb();
            }
        }
    }

    /* renamed from: com.introvd.template.sdk.utils.b.a.a$c */
    protected static class C8506c extends Handler {
        private WeakReference<C8502a> eiE;

        public C8506c(Looper looper, C8502a aVar) {
            super(looper);
            this.eiE = new WeakReference<>(aVar);
        }

        public void handleMessage(Message message) {
            C8502a aVar = (C8502a) this.eiE.get();
            if (aVar != null) {
                C8512f fVar = aVar.dcs;
                if (fVar != null) {
                    int i = message.what;
                    if (i != 101) {
                        switch (i) {
                            case 1:
                                C8554j.m25007e("AbstractExportUtil", "handleMessage MSG_PRODUCER_CREATE in");
                                String str = (String) message.obj;
                                StringBuilder sb = new StringBuilder();
                                sb.append("MSG_PRODUCER_CREATE:");
                                sb.append(str);
                                C8554j.m25007e("AbstractExportUtil", sb.toString());
                                aVar.mo34677b(fVar, str);
                                break;
                            case 2:
                                fVar.apX();
                                break;
                            case 3:
                                boolean z = aVar.eil;
                                if (aVar.eik && aVar.eij != null) {
                                    aVar.eij.mo34897pa(aVar.eiv);
                                }
                                int i2 = message.arg2;
                                aVar.aJQ();
                                if (aVar.eio == 9428996 || i2 != 0) {
                                    if (!aVar.eil) {
                                        if ((i2 == 0 || aVar.eio == 9428996) ? false : true) {
                                            C8554j.m25007e("AbstractExportUtil", "AbstractExportUtil onExportFailed 3");
                                            fVar.mo29117n(i2, "");
                                        } else {
                                            fVar.ama();
                                        }
                                        aVar.eil = true;
                                    }
                                } else if (!aVar.eil) {
                                    String str2 = aVar.eit;
                                    if (aVar.eik) {
                                        if (C8548e.isFileExisted(str2)) {
                                            C8548e.deleteFile(str2);
                                        }
                                        if (C8548e.renameFile(aVar.eiv, str2)) {
                                            aVar.m24598a(fVar, str2);
                                        } else if (C8548e.copyFile(aVar.eiv, str2)) {
                                            C8548e.deleteFile(aVar.eiv);
                                            aVar.m24598a(fVar, str2);
                                        } else {
                                            long fileSize = C8548e.fileSize(aVar.eiv);
                                            StringBuilder sb2 = new StringBuilder();
                                            sb2.append("filesize=");
                                            sb2.append(fileSize);
                                            sb2.append(";projectExportUtils.m_strFullTempFileName=");
                                            sb2.append(aVar.eiv);
                                            sb2.append(";strDstFile=");
                                            sb2.append(str2);
                                            String sb3 = sb2.toString();
                                            C8554j.m25007e("AbstractExportUtil", "AbstractExportUtil onExportFailed 4");
                                            fVar.mo29117n(4, sb3);
                                            aVar.eil = true;
                                        }
                                    } else {
                                        aVar.m24598a(fVar, str2);
                                    }
                                } else {
                                    return;
                                }
                                if (!z) {
                                    aVar.getClass();
                                    new C8505b().mo34652e(new Void[0]);
                                    break;
                                }
                                break;
                            case 4:
                                fVar.mo29115av(((Float) message.obj).floatValue());
                                break;
                            default:
                                switch (i) {
                                    case 7:
                                    case 8:
                                        if (message.arg1 != 0) {
                                            C8554j.m25007e("AbstractExportUtil", "AbstractExportUtil onExportFailed 5");
                                            fVar.mo29117n(message.arg1, String.valueOf(message.obj));
                                            break;
                                        } else {
                                            fVar.mo29116hM(String.valueOf(message.obj));
                                            break;
                                        }
                                }
                        }
                    } else {
                        aVar.aJV();
                    }
                }
            }
        }
    }

    public C8502a(QEngine qEngine) {
        this.engine = qEngine;
        mHandlerThread = C8550g.getHandlerThreadFromCommon();
        this.eii = new C8506c(mHandlerThread.getLooper(), this);
    }

    /* renamed from: a */
    private int m24596a(QSessionState qSessionState) {
        return qSessionState.vPrcErr | qSessionState.aPrcErr | qSessionState.vDecErr;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m24598a(C8508c cVar, String str) {
        if (!this.eil) {
            cVar.mo29115av(100.0f);
            cVar.mo29116hM(str);
            this.eil = true;
        }
        if (this.eij != null) {
            this.eij.mo34896oZ(str);
        }
    }

    /* access modifiers changed from: private */
    public void aJV() {
        C8554j.m25007e("AbstractExportUtil", "cancel #1");
        this.eio = QVEError.QERR_COMMON_CANCEL;
        this.eir = false;
    }

    /* renamed from: oR */
    public static int m24600oR(String str) {
        C8554j.m25007e("AbstractExportUtil", "PreSave in");
        if (!C8548e.createMultilevelDirectory(str)) {
            return 2;
        }
        if (!new File(str).canWrite()) {
            return 4;
        }
        C8554j.m25007e("AbstractExportUtil", "PreSave out");
        return 0;
    }

    /* renamed from: a */
    public synchronized void mo34671a(C8508c cVar) {
        this.eih = cVar;
    }

    /* access modifiers changed from: protected */
    public abstract boolean aJQ();

    /* access modifiers changed from: protected */
    public abstract int aJR();

    public int aJS() {
        if (this.eig != null) {
            this.eig.setCPUOverloadLevel(1);
        }
        return 0;
    }

    public int aJT() {
        if (this.eig == null) {
            return 0;
        }
        this.eig.setCPUOverloadLevel(3);
        return this.eig.resume();
    }

    public int aJU() {
        this.eii.sendEmptyMessageDelayed(101, 500);
        return 0;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract int mo34677b(C8508c cVar, String str);

    public synchronized int cancel() {
        int i;
        C8554j.m25007e("AbstractExportUtil", "cancel #1");
        this.eio = QVEError.QERR_COMMON_CANCEL;
        i = 0;
        this.eir = false;
        if (this.eig != null) {
            C8554j.m25007e("AbstractExportUtil", "m_Producer.cancel enter");
            i = this.eig.cancel();
            C8554j.m25007e("AbstractExportUtil", "m_Producer.cancel exit");
            C8554j.m25007e("AbstractExportUtil", "cancel, deactiveStream enter");
            this.eig.deactiveStream();
            C8554j.m25007e("AbstractExportUtil", "cancel, deactiveStream exit");
        }
        return i;
    }

    public synchronized void destroy() {
        if (this.eig != null) {
            C8554j.m25007e("AbstractExportUtil", "destroy deactiveStream");
            this.eig.deactiveStream();
            C8554j.m25007e("AbstractExportUtil", "destroy stop");
            this.eig.stop();
            C8554j.m25007e("AbstractExportUtil", "destroy unInit enter");
            this.eig.unInit();
            C8554j.m25007e("AbstractExportUtil", "destroy unInit exit");
            this.eig = null;
        }
        if (this.eeR != null) {
            this.eeR.close();
            this.eeR = null;
        }
        if (this.eis) {
            aJR();
        }
        if (this.eik && C8548e.isFileExisted(this.eiv)) {
            C8548e.deleteFile(this.eiv);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: oQ */
    public void mo34680oQ(String str) {
        if (this.eii != null) {
            Message obtainMessage = this.eii.obtainMessage(1, 0, 0);
            obtainMessage.obj = str;
            this.eii.sendMessage(obtainMessage);
        }
    }

    public int onSessionStatus(QSessionState qSessionState) {
        int errorCode = qSessionState.getErrorCode();
        float currentTime = (((float) qSessionState.getCurrentTime()) / ((float) qSessionState.getDuration())) * 100.0f;
        StringBuilder sb = new StringBuilder();
        sb.append("export video onSessionStatus: state=");
        sb.append(qSessionState.getStatus());
        sb.append(",errorCode");
        sb.append(errorCode);
        sb.append(";currPercent=");
        sb.append(currentTime);
        C8554j.m25007e("AbstractExportUtil", sb.toString());
        boolean z = true;
        if (qSessionState.getStatus() == 1) {
            this.ein = 1;
            this.eii.sendMessage(this.eii.obtainMessage(2, qSessionState.getDuration(), 0));
        } else if (qSessionState.getStatus() == 4) {
            this.ein = 4;
            this.eiq = currentTime;
            if (this.eim != 0) {
                errorCode = this.eim;
            }
            if (errorCode == 0) {
                errorCode = m24596a(qSessionState);
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("AbstractExportUtil STATUS_STOPPED ,ErrorCode:");
            sb2.append(errorCode);
            C8554j.m25007e("AbstractExportUtil", sb2.toString());
            if (errorCode == 0 && this.eio == 9428996) {
                this.eii.sendMessage(this.eii.obtainMessage(3, 0, 0, Float.valueOf(currentTime)));
            } else {
                Message obtainMessage = this.eii.obtainMessage(3, 0, errorCode, Float.valueOf(currentTime));
                if (!(this.eig == null || eiw == null)) {
                    eiw.mo34687a((QProducerErrInfo) this.eig.getProperty(24582));
                    eiw.eiG = qSessionState.aPrcErr;
                    eiw.eiF = qSessionState.strUserData;
                    eiw.eiH = qSessionState.vDecErr;
                    eiw.eiI = qSessionState.vPrcErr;
                    obtainMessage.obj = eiw;
                }
                this.eii.sendMessage(obtainMessage);
            }
        } else if (qSessionState.getStatus() == 2) {
            if (this.eir) {
                return QVEError.QERR_COMMON_PAUSE;
            }
            if (this.eiu) {
                this.eiu = false;
                try {
                    Process.setThreadPriority(this.mThreadPriority);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (errorCode == 0) {
                z = false;
            }
            if (z) {
                this.eim = errorCode;
                return QVEError.QERR_COMMON_CANCEL;
            } else if (qSessionState.getStatus() != 0 || currentTime > this.eiq) {
                this.eiq = currentTime;
                this.eii.sendMessage(this.eii.obtainMessage(4, 0, 0, Float.valueOf(currentTime)));
            }
        } else if (qSessionState.getStatus() == 3) {
            this.ein = 3;
        }
        return this.eio;
    }

    public int stop() {
        return cancel();
    }

    /* access modifiers changed from: protected */
    /* renamed from: w */
    public abstract String mo34682w(String str, String str2, String str3);
}
