package com.introvd.template.sdk.utils.p394b;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.introvd.template.router.editor.EditorRouter;
import com.introvd.template.sdk.C8401d;
import com.introvd.template.sdk.C8410e;
import com.introvd.template.sdk.editor.cache.C8440a;
import com.introvd.template.sdk.editor.cache.C8443d;
import com.introvd.template.sdk.editor.cache.TrimedClipItemDataModel;
import com.introvd.template.sdk.editor.p389c.C8435a;
import com.introvd.template.sdk.editor.p389c.C8438d;
import com.introvd.template.sdk.model.TemplateConditionModel;
import com.introvd.template.sdk.model.VeRange;
import com.introvd.template.sdk.model.editor.DataItemClip;
import com.introvd.template.sdk.model.editor.DataItemProject;
import com.introvd.template.sdk.model.editor.DataLyricsItem;
import com.introvd.template.sdk.model.editor.DataMusicItem;
import com.introvd.template.sdk.model.editor.DataPIPIItem;
import com.introvd.template.sdk.model.editor.ErrorInfoModel;
import com.introvd.template.sdk.model.editor.ProjectItem;
import com.introvd.template.sdk.p380a.C8381b;
import com.introvd.template.sdk.p384d.C8402a;
import com.introvd.template.sdk.p384d.C8403b;
import com.introvd.template.sdk.p384d.C8404c;
import com.introvd.template.sdk.p391g.C8450a;
import com.introvd.template.sdk.p391g.C8451b;
import com.introvd.template.sdk.utils.C8545d;
import com.introvd.template.sdk.utils.C8548e;
import com.introvd.template.sdk.utils.C8553i;
import com.introvd.template.sdk.utils.C8554j;
import com.introvd.template.sdk.utils.C8556l;
import com.introvd.template.sdk.utils.C8558m;
import com.introvd.template.sdk.utils.C8565t;
import com.introvd.template.sdk.utils.C8569v;
import com.introvd.template.sdk.utils.C8572y;
import com.introvd.template.sdk.utils.VeMSize;
import com.introvd.template.sdk.utils.p393a.C8484b;
import com.ironsource.sdk.constants.Constants.ParametersKeys;
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
import java.util.Map.Entry;
import xiaoying.engine.QEngine;
import xiaoying.engine.base.QRange;
import xiaoying.engine.base.QUtils;
import xiaoying.engine.base.QVideoInfo;
import xiaoying.engine.clip.QClip;
import xiaoying.engine.storyboard.QStoryboard;
import xiaoying.utils.QRect;
import xiaoying.utils.QSize;

@SuppressLint({"UseValueOf"})
/* renamed from: com.introvd.template.sdk.utils.b.g */
public class C8522g extends C8381b<ProjectItem> {
    private static volatile C8522g ehT;
    private volatile boolean bce = false;
    private int bmE = 70;
    public float bmF = 1.0f;
    public float bmG = 1.0f;
    public float bmH = 1.0f;
    private HashMap<String, C8528b> efE = new HashMap<>();
    /* access modifiers changed from: private */
    public volatile boolean efH = false;
    private volatile boolean efJ = false;
    private C8527a ehS;
    /* access modifiers changed from: private */
    public Context mContext;
    private final Object mLock = new Object();

    /* renamed from: com.introvd.template.sdk.utils.b.g$a */
    private class C8527a extends C8484b<Void, Void, Integer> {
        private WeakReference<Handler> csZ = null;
        private WeakReference<C8443d> efT;
        private WeakReference<QStoryboard> ehY;
        private WeakReference<ProjectItem> ehZ;
        private boolean eia = true;
        private WeakReference<Context> mContextRef;

        public C8527a(Context context, ProjectItem projectItem, Handler handler, boolean z) {
            this.ehZ = new WeakReference<>(projectItem);
            this.efT = new WeakReference<>(projectItem.mClipModelCacheList);
            this.ehY = new WeakReference<>(projectItem.mStoryBoard);
            this.mContextRef = new WeakReference<>(context);
            if (handler != null) {
                this.csZ = new WeakReference<>(handler);
            }
            this.eia = z;
        }

        /* access modifiers changed from: protected */
        /* renamed from: c */
        public Integer doInBackground(Void... voidArr) {
            try {
                if (!(this.ehY == null || this.efT == null || this.mContextRef == null)) {
                    C8517b.m24646a((QStoryboard) this.ehY.get(), (C8443d) this.efT.get(), (Context) this.mContextRef.get());
                }
                if (this.efT == null) {
                    return Integer.valueOf(-1);
                }
                C8443d dVar = (C8443d) this.efT.get();
                return dVar != null ? Integer.valueOf(dVar.getCount()) : Integer.valueOf(-1);
            } catch (Exception unused) {
                return Integer.valueOf(-1);
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: l */
        public void onPostExecute(Integer num) {
            super.onPostExecute(num);
            ProjectItem projectItem = (ProjectItem) this.ehZ.get();
            if (projectItem != null) {
                synchronized (C8522g.this) {
                    projectItem.setCacheFlag(8, true);
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
            ProjectItem projectItem = (ProjectItem) this.ehZ.get();
            synchronized (C8522g.this) {
                if (projectItem != null) {
                    try {
                        projectItem.setCacheFlag(12, false);
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

    /* renamed from: com.introvd.template.sdk.utils.b.g$b */
    private static class C8528b extends Handler {
        final WeakReference<C8501a> cta;
        final WeakReference<C8522g> efV;
        final String efW;
        /* access modifiers changed from: private */
        public Handler mHandler = null;

        public C8528b(C8522g gVar, C8501a aVar, String str, Handler handler, Looper looper) {
            super(looper);
            this.mHandler = handler;
            this.efV = new WeakReference<>(gVar);
            this.cta = new WeakReference<>(aVar);
            this.efW = str;
        }

        /* renamed from: ul */
        private void m24735ul(int i) {
            if (this.mHandler != null) {
                this.mHandler.sendEmptyMessage(i);
            }
        }

        public void handleMessage(Message message) {
            C8522g gVar = (C8522g) this.efV.get();
            if (gVar != null) {
                switch (message.what) {
                    case 268443649:
                        synchronized (gVar) {
                            ProjectItem oC = gVar.mo34770oC(this.efW);
                            if (oC != null) {
                                C8540q.m24934a(oC.mStoryBoard, (long) QUtils.GetProjectVersion(this.efW));
                                boolean z = true;
                                oC.setCacheFlag(2, true);
                                if (message.arg1 != 1) {
                                    z = false;
                                }
                                oC.isTemplateFileLosted = z;
                                oC.isClipSourceFileLosted = message.obj == null ? false : ((Boolean) message.obj).booleanValue();
                                C8410e.aGX().aGZ().setBoolean("pref_res_lost_msg_show", false);
                            }
                        }
                        m24735ul(message.what);
                        C8554j.m25007e("ProjectMgr", ">>>>>>>>>> MSG_PROJECT_LOAD_SUCCEEDED");
                        break;
                    case 268443650:
                    case 268443651:
                        synchronized (gVar) {
                            ProjectItem oC2 = gVar.mo34770oC(this.efW);
                            if (oC2 != null) {
                                oC2.setCacheFlag(3, false);
                                oC2.release();
                                gVar.mo34768nN(this.efW);
                            }
                        }
                        C8554j.m25007e("ProjectMgr", ">>>>>>>>>>>>>> MSG_PROJECT_LOAD_CANCELED");
                        m24735ul(message.what);
                        break;
                }
            }
        }
    }

    private C8522g() {
    }

    /* renamed from: a */
    public static int m24662a(Context context, ProjectItem projectItem, QEngine qEngine, Handler handler) {
        if (projectItem == null || qEngine == null || projectItem.mProjectDataItem == null) {
            return 5;
        }
        String str = projectItem.mProjectDataItem.strPrjURL;
        if (!C8548e.isFileExisted(str)) {
            return 5;
        }
        if (projectItem.mStoryBoard != null) {
            projectItem.mStoryBoard.unInit();
        }
        projectItem.mStoryBoard = new QStoryboard();
        if (projectItem.mStoryBoard.init(qEngine, null) != 0) {
            projectItem.mStoryBoard = null;
            return 3;
        }
        C8529h hVar = new C8529h();
        if (hVar.mo34784a(context, handler, projectItem.mStoryBoard) != 0) {
            hVar.unInit();
            return 5;
        }
        projectItem.lLastUpdateTime = System.currentTimeMillis();
        return hVar.mo34785nP(str) != 0 ? 1 : 0;
    }

    /* renamed from: a */
    private int m24664a(ArrayList<Long> arrayList, String str, int i, ContentResolver contentResolver) {
        if (TextUtils.isEmpty(str) || arrayList == null) {
            return 0;
        }
        int i2 = 0;
        while (!arrayList.isEmpty()) {
            long longValue = ((Long) arrayList.remove(0)).longValue();
            if (C8403b.m24229aZ(longValue) <= 0) {
                String aX = C8402a.m24225aX(longValue);
                if (!TextUtils.isEmpty(aX) && aX.contains(".media/") && (i & 1) != 0) {
                    C8548e.deleteFile(aX);
                }
                C8402a.m24226aY(longValue);
                i2++;
            }
        }
        if ((i & 1) == 1) {
            File file = new File(str);
            if (file.exists() && file.isDirectory()) {
                C8548e.deleteDirectory(file.getAbsolutePath());
            }
        }
        return i2;
    }

    /* renamed from: a */
    public static int m24665a(QStoryboard qStoryboard, int i, int i2, String str, int i3) {
        int i4;
        Throwable th;
        int i5;
        int i6;
        try {
            QClip dataClip = qStoryboard.getDataClip();
            int nW = C8450a.m24473nW(C8532k.m24769q(Long.valueOf(C8540q.m24894C(qStoryboard).longValue())));
            i4 = nW <= 0 ? C8572y.m25104x(qStoryboard) : nW;
            try {
                VeMSize dJ = C8572y.m25088dJ(C8572y.m25087dI(i, 4), C8572y.m25087dI(i2, 4));
                int i7 = dJ.width;
                int i8 = dJ.height;
                VeMSize veMSize = new VeMSize((int) QUtils.VIDEO_RES_720P_HEIGHT, (int) QUtils.VIDEO_RES_720P_WIDTH);
                if (i8 * i7 < veMSize.width * veMSize.height) {
                    VeMSize a = C8569v.m25057a(new VeMSize(i7, i8), veMSize);
                    int i9 = a.height;
                    i6 = a.width;
                    i5 = i9;
                } else {
                    i5 = i8;
                    i6 = i7;
                }
                Bitmap bitmap = (Bitmap) C8537n.m24793a(dataClip, i4, i6, i5, true, false, false);
                if (bitmap != null) {
                    C8545d.saveBitmap(str, bitmap, i3);
                }
            } catch (Throwable th2) {
                th = th2;
                th.printStackTrace();
                return i4;
            }
        } catch (Throwable th3) {
            th = th3;
            i4 = 0;
            th.printStackTrace();
            return i4;
        }
        return i4;
    }

    /* renamed from: a */
    private void m24666a(Context context, C8451b bVar, Handler handler, boolean z, String str) {
        if (context != null) {
            DataItemProject dataItemProject = new DataItemProject();
            String a = m24132a(context, new Date(), H5PullHeader.TIME_FORMAT);
            String format = new SimpleDateFormat("'Project'_yyyyMMdd_HHmmss", Locale.US).format(new Date());
            dataItemProject.strCreateTime = a;
            dataItemProject.strModifyTime = a;
            dataItemProject.strPrjTitle = "";
            dataItemProject.strExtra = str;
            StringBuilder sb = new StringBuilder();
            sb.append(C8401d.ane());
            sb.append(format);
            sb.append(".prj");
            dataItemProject.strPrjURL = sb.toString();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(C8401d.ane());
            sb2.append(format);
            sb2.append(".jpg");
            dataItemProject.strPrjThumbnail = sb2.toString();
            if (z) {
                dataItemProject.iIsDeleted = 2;
            }
            dataItemProject.prjThemeType = bVar.code;
            this.ebQ = 0;
            ProjectItem projectItem = new ProjectItem(dataItemProject, null);
            if (this.ebR == null) {
                mo33874S(context, false);
            }
            this.ebR.add(0, projectItem);
            C8548e.createMultilevelDirectory(C8572y.m25097ou(dataItemProject.strPrjURL));
            projectItem.mStoryBoard = new QStoryboard();
            projectItem.mStoryBoard.init(C8501a.aJs().aJv(), null);
            this.ebS.put(dataItemProject.strPrjURL, projectItem);
            if (handler != null) {
                handler.sendEmptyMessage(268443649);
            }
        }
    }

    /* renamed from: a */
    private static boolean m24669a(QStoryboard qStoryboard, DataItemProject dataItemProject, boolean z, boolean z2) {
        if (C8540q.m24946d(qStoryboard, z2) != null) {
            boolean z3 = dataItemProject.streamWidth <= 0 || dataItemProject.streamHeight <= 0;
            boolean z4 = dataItemProject.streamWidth < dataItemProject.streamHeight;
            if ((!z3 && !z4) || C8540q.m24913V(qStoryboard)) {
                return false;
            }
            if (!(C8540q.m24905N(qStoryboard) && !C8540q.m24893B(qStoryboard) && !C8540q.m24906O(qStoryboard) && C8537n.m24827h(qStoryboard.getDataClip(), 6) <= 0) || z) {
                VeMSize aJp = C8572y.aJp();
                if (aJp != null && aJp.width > 0 && aJp.height > 0) {
                    dataItemProject.streamWidth = aJp.width;
                    dataItemProject.streamHeight = aJp.height;
                    return true;
                }
            }
        }
        return false;
    }

    private synchronized int aIU() {
        if (this.ehS != null && !this.ehS.isCancelled()) {
            this.ehS.cancel(true);
            this.ehS = null;
        }
        this.efE.clear();
        this.ebS.clear();
        if (this.ebR != null) {
            for (ProjectItem i : this.ebR) {
                mo34764i(i);
            }
            this.ebR.clear();
            this.ebR = null;
        }
        return 0;
    }

    public static C8522g aJA() {
        if (ehT == null) {
            synchronized (C8522g.class) {
                if (ehT == null) {
                    ehT = new C8522g();
                }
            }
        }
        return ehT;
    }

    /* JADX WARNING: type inference failed for: r11v1, types: [xiaoying.engine.storyboard.QStoryboard, xiaoying.engine.base.IQSessionStateListener] */
    /* JADX WARNING: type inference failed for: r11v2 */
    /* JADX WARNING: type inference failed for: r11v3 */
    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0177, code lost:
        return 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0186, code lost:
        return 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x0191, code lost:
        return 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x0199, code lost:
        return 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x019f, code lost:
        return 1;
     */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r11v1, types: [xiaoying.engine.storyboard.QStoryboard, xiaoying.engine.base.IQSessionStateListener]
      assigns: []
      uses: [xiaoying.engine.base.IQSessionStateListener, xiaoying.engine.storyboard.QStoryboard]
      mth insns count: 162
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:99)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:92)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
    	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
    	at jadx.core.ProcessClass.process(ProcessClass.java:30)
    	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
    	at jadx.core.ProcessClass.process(ProcessClass.java:35)
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
     */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x010c  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0124  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x012d A[SYNTHETIC, Splitter:B:51:0x012d] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized int m24670b(java.lang.String r20, com.introvd.template.sdk.utils.p394b.C8501a r21, android.os.Handler r22) {
        /*
            r19 = this;
            r7 = r19
            r0 = r22
            monitor-enter(r19)
            r8 = 1
            if (r21 == 0) goto L_0x019d
            java.util.List r1 = r7.ebR     // Catch:{ all -> 0x019a }
            if (r1 == 0) goto L_0x019d
            java.util.List r1 = r7.ebR     // Catch:{ all -> 0x019a }
            int r1 = r1.size()     // Catch:{ all -> 0x019a }
            if (r1 != 0) goto L_0x0016
            goto L_0x019d
        L_0x0016:
            android.content.Context r1 = r7.mContext     // Catch:{ all -> 0x019a }
            com.introvd.template.sdk.utils.C8553i.setContext(r1)     // Catch:{ all -> 0x019a }
            r1 = 23
            com.introvd.template.sdk.utils.C8553i.m25005ut(r1)     // Catch:{ all -> 0x019a }
            com.introvd.template.sdk.model.editor.ProjectItem r9 = r19.mo34770oC(r20)     // Catch:{ all -> 0x019a }
            r10 = 268443650(0x10002002, float:2.5268207E-29)
            if (r9 == 0) goto L_0x0192
            com.introvd.template.sdk.model.editor.DataItemProject r1 = r9.mProjectDataItem     // Catch:{ all -> 0x019a }
            if (r1 != 0) goto L_0x002f
            goto L_0x0192
        L_0x002f:
            int r1 = r9.getCacheFlag()     // Catch:{ all -> 0x019a }
            r2 = r1 & 2
            r11 = 0
            if (r2 != 0) goto L_0x0187
            r1 = r1 & r8
            if (r1 == 0) goto L_0x003d
            goto L_0x0187
        L_0x003d:
            java.util.HashMap r1 = r7.ebS     // Catch:{ all -> 0x019a }
            int r1 = r1.size()     // Catch:{ all -> 0x019a }
            r12 = 31536000000(0x757b12c00, double:1.55808542072E-313)
            r2 = -1
            r14 = 3
            r6 = 0
            if (r1 < r14) goto L_0x00bd
            java.util.HashMap r1 = r7.ebS     // Catch:{ all -> 0x019a }
            java.util.Set r1 = r1.entrySet()     // Catch:{ all -> 0x019a }
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x019a }
            r5 = 0
            long r3 = r3 + r12
            java.lang.Long r3 = java.lang.Long.valueOf(r3)     // Catch:{ all -> 0x019a }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x019a }
            r4 = r3
            r3 = r6
        L_0x0063:
            boolean r5 = r1.hasNext()     // Catch:{ all -> 0x019a }
            if (r5 == 0) goto L_0x0098
            java.lang.Object r5 = r1.next()     // Catch:{ all -> 0x019a }
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5     // Catch:{ all -> 0x019a }
            java.lang.Object r15 = r5.getValue()     // Catch:{ all -> 0x019a }
            r8 = r15
            com.introvd.template.sdk.model.editor.ProjectItem r8 = (com.introvd.template.sdk.model.editor.ProjectItem) r8     // Catch:{ all -> 0x019a }
            long r12 = r8.lLastUpdateTime     // Catch:{ all -> 0x019a }
            long r16 = r4.longValue()     // Catch:{ all -> 0x019a }
            int r12 = (r12 > r16 ? 1 : (r12 == r16 ? 0 : -1))
            if (r12 >= 0) goto L_0x0091
            long r3 = r8.lLastUpdateTime     // Catch:{ all -> 0x019a }
            java.lang.Long r3 = java.lang.Long.valueOf(r3)     // Catch:{ all -> 0x019a }
            java.lang.Object r4 = r5.getKey()     // Catch:{ all -> 0x019a }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ all -> 0x019a }
            r18 = r4
            r4 = r3
            r3 = r18
        L_0x0091:
            r8 = 1
            r12 = 31536000000(0x757b12c00, double:1.55808542072E-313)
            goto L_0x0063
        L_0x0098:
            if (r3 == 0) goto L_0x00bd
            java.util.HashMap r1 = r7.ebS     // Catch:{ all -> 0x019a }
            java.lang.Object r1 = r1.get(r3)     // Catch:{ all -> 0x019a }
            com.introvd.template.sdk.model.editor.ProjectItem r1 = (com.introvd.template.sdk.model.editor.ProjectItem) r1     // Catch:{ all -> 0x019a }
            if (r1 == 0) goto L_0x00b3
            xiaoying.engine.storyboard.QStoryboard r4 = r1.mStoryBoard     // Catch:{ all -> 0x019a }
            r4.unInit()     // Catch:{ all -> 0x019a }
            r1.mStoryBoard = r6     // Catch:{ all -> 0x019a }
            com.introvd.template.sdk.editor.cache.d r4 = r1.mClipModelCacheList     // Catch:{ all -> 0x019a }
            r4.releaseAll()     // Catch:{ all -> 0x019a }
            r1.setCacheFlag(r2, r11)     // Catch:{ all -> 0x019a }
        L_0x00b3:
            java.util.HashMap r1 = r7.ebS     // Catch:{ all -> 0x019a }
            r1.remove(r3)     // Catch:{ all -> 0x019a }
            java.util.HashMap<java.lang.String, com.introvd.template.sdk.utils.b.g$b> r1 = r7.efE     // Catch:{ all -> 0x019a }
            r1.remove(r3)     // Catch:{ all -> 0x019a }
        L_0x00bd:
            r9.setCacheFlag(r2, r11)     // Catch:{ all -> 0x019a }
            com.introvd.template.sdk.model.editor.DataItemProject r1 = r9.mProjectDataItem     // Catch:{ all -> 0x019a }
            java.lang.String r8 = r1.strPrjURL     // Catch:{ all -> 0x019a }
            java.lang.String r1 = "ProjectMgr"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x019a }
            r2.<init>()     // Catch:{ all -> 0x019a }
            java.lang.String r3 = ">>>>>>>>>>>>>>> updateProjectStoryBoard projectPath="
            r2.append(r3)     // Catch:{ all -> 0x019a }
            r2.append(r8)     // Catch:{ all -> 0x019a }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x019a }
            com.introvd.template.sdk.utils.C8554j.m25007e(r1, r2)     // Catch:{ all -> 0x019a }
            java.util.HashMap<java.lang.String, com.introvd.template.sdk.utils.b.g$b> r1 = r7.efE     // Catch:{ all -> 0x019a }
            java.lang.Object r1 = r1.get(r8)     // Catch:{ all -> 0x019a }
            com.introvd.template.sdk.utils.b.g$b r1 = (com.introvd.template.sdk.utils.p394b.C8522g.C8528b) r1     // Catch:{ all -> 0x019a }
            if (r1 == 0) goto L_0x00ee
            android.os.Handler r2 = r1.mHandler     // Catch:{ all -> 0x019a }
            if (r2 == r0) goto L_0x00eb
            goto L_0x00ee
        L_0x00eb:
            r12 = r1
            r11 = r6
            goto L_0x0108
        L_0x00ee:
            com.introvd.template.sdk.utils.b.g$b r12 = new com.introvd.template.sdk.utils.b.g$b     // Catch:{ all -> 0x019a }
            android.os.HandlerThread r1 = r7.ebT     // Catch:{ all -> 0x019a }
            android.os.Looper r13 = r1.getLooper()     // Catch:{ all -> 0x019a }
            r1 = r12
            r2 = r19
            r3 = r21
            r4 = r8
            r5 = r22
            r11 = r6
            r6 = r13
            r1.<init>(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x019a }
            java.util.HashMap<java.lang.String, com.introvd.template.sdk.utils.b.g$b> r1 = r7.efE     // Catch:{ all -> 0x019a }
            r1.put(r8, r12)     // Catch:{ all -> 0x019a }
        L_0x0108:
            xiaoying.engine.storyboard.QStoryboard r1 = r9.mStoryBoard     // Catch:{ all -> 0x019a }
            if (r1 == 0) goto L_0x0111
            xiaoying.engine.storyboard.QStoryboard r1 = r9.mStoryBoard     // Catch:{ all -> 0x019a }
            r1.unInit()     // Catch:{ all -> 0x019a }
        L_0x0111:
            xiaoying.engine.storyboard.QStoryboard r1 = new xiaoying.engine.storyboard.QStoryboard     // Catch:{ all -> 0x019a }
            r1.<init>()     // Catch:{ all -> 0x019a }
            r9.mStoryBoard = r1     // Catch:{ all -> 0x019a }
            xiaoying.engine.storyboard.QStoryboard r1 = r9.mStoryBoard     // Catch:{ all -> 0x019a }
            xiaoying.engine.QEngine r2 = r21.aJv()     // Catch:{ all -> 0x019a }
            int r1 = r1.init(r2, r11)     // Catch:{ all -> 0x019a }
            if (r1 == 0) goto L_0x012d
            if (r0 == 0) goto L_0x0129
            r0.sendEmptyMessage(r10)     // Catch:{ all -> 0x019a }
        L_0x0129:
            r9.mStoryBoard = r11     // Catch:{ all -> 0x019a }
            monitor-exit(r19)
            return r14
        L_0x012d:
            com.introvd.template.sdk.utils.b.h r1 = new com.introvd.template.sdk.utils.b.h     // Catch:{ all -> 0x019a }
            r1.<init>()     // Catch:{ all -> 0x019a }
            android.content.Context r2 = r7.mContext     // Catch:{ all -> 0x019a }
            xiaoying.engine.storyboard.QStoryboard r3 = r9.mStoryBoard     // Catch:{ all -> 0x019a }
            int r2 = r1.mo34784a(r2, r12, r3)     // Catch:{ all -> 0x019a }
            if (r2 == 0) goto L_0x0147
            if (r0 == 0) goto L_0x0141
            r0.sendEmptyMessage(r10)     // Catch:{ all -> 0x019a }
        L_0x0141:
            r1.unInit()     // Catch:{ all -> 0x019a }
            r0 = 5
            monitor-exit(r19)
            return r0
        L_0x0147:
            long r2 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x019a }
            int r4 = r19.mo33889nt(r20)     // Catch:{ all -> 0x019a }
            int r5 = r7.ebQ     // Catch:{ all -> 0x019a }
            if (r4 != r5) goto L_0x0159
            r4 = 31536000000(0x757b12c00, double:1.55808542072E-313)
            long r2 = r2 + r4
        L_0x0159:
            r9.lLastUpdateTime = r2     // Catch:{ all -> 0x019a }
            java.util.HashMap r2 = r7.ebS     // Catch:{ all -> 0x019a }
            r2.put(r8, r9)     // Catch:{ all -> 0x019a }
            boolean r2 = com.introvd.template.sdk.utils.C8548e.isFileExisted(r8)     // Catch:{ all -> 0x019a }
            if (r2 == 0) goto L_0x0178
            r2 = 1
            r9.setCacheFlag(r2, r2)     // Catch:{ all -> 0x019a }
            int r1 = r1.mo34785nP(r8)     // Catch:{ all -> 0x019a }
            if (r1 == 0) goto L_0x0175
            if (r0 == 0) goto L_0x0175
            r0.sendEmptyMessage(r10)     // Catch:{ all -> 0x019a }
        L_0x0175:
            monitor-exit(r19)
            r0 = 0
            return r0
        L_0x0178:
            java.lang.String r1 = "ProjectMgr"
            java.lang.String r2 = ">>>>>>>>>>>>>>updateStoryBoard() MSG_PROJECT_LOAD_FAILED"
            com.introvd.template.sdk.utils.C8554j.m25007e(r1, r2)     // Catch:{ all -> 0x019a }
            if (r0 == 0) goto L_0x0184
            r0.sendEmptyMessage(r10)     // Catch:{ all -> 0x019a }
        L_0x0184:
            monitor-exit(r19)
            r0 = 1
            return r0
        L_0x0187:
            if (r0 == 0) goto L_0x018f
            r1 = 268443649(0x10002001, float:2.5268204E-29)
            r0.sendEmptyMessage(r1)     // Catch:{ all -> 0x019a }
        L_0x018f:
            monitor-exit(r19)
            r0 = 0
            return r0
        L_0x0192:
            if (r0 == 0) goto L_0x0197
            r0.sendEmptyMessage(r10)     // Catch:{ all -> 0x019a }
        L_0x0197:
            monitor-exit(r19)
            r0 = 1
            return r0
        L_0x019a:
            r0 = move-exception
            monitor-exit(r19)
            throw r0
        L_0x019d:
            monitor-exit(r19)
            r0 = 1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.sdk.utils.p394b.C8522g.m24670b(java.lang.String, com.introvd.template.sdk.utils.b.a, android.os.Handler):int");
    }

    /* renamed from: br */
    private void m24671br(long j) {
        C8404c.m24235bd(j);
        int aV = mo33885aV(j);
        if (aV >= 0) {
            mo34776uk(aV);
            if (aV == this.ebQ) {
                this.ebQ = -1;
            } else if (aV < this.ebQ) {
                this.ebQ--;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0051, code lost:
        if (r2.height > 0) goto L_0x0055;
     */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.introvd.template.sdk.utils.VeMSize m24672c(xiaoying.engine.storyboard.QStoryboard r2, boolean r3) {
        /*
            if (r2 != 0) goto L_0x0004
            r2 = 0
            return r2
        L_0x0004:
            java.lang.Long r0 = com.introvd.template.sdk.utils.p394b.C8540q.m24894C(r2)
            long r0 = r0.longValue()
            boolean r0 = com.introvd.template.sdk.p391g.C8450a.m24467bl(r0)
            if (r0 == 0) goto L_0x0017
            com.introvd.template.sdk.utils.VeMSize r2 = com.introvd.template.sdk.utils.C8572y.aJq()
            goto L_0x0055
        L_0x0017:
            com.introvd.template.sdk.utils.VeMSize r3 = com.introvd.template.sdk.utils.p394b.C8540q.m24946d(r2, r3)
            if (r3 == 0) goto L_0x0054
            int r0 = r3.width
            int r1 = r3.height
            if (r0 >= r1) goto L_0x0054
            boolean r0 = com.introvd.template.sdk.utils.p394b.C8540q.m24905N(r2)
            if (r0 == 0) goto L_0x0042
            boolean r0 = com.introvd.template.sdk.utils.p394b.C8540q.m24893B(r2)
            if (r0 != 0) goto L_0x0042
            boolean r0 = com.introvd.template.sdk.utils.p394b.C8540q.m24906O(r2)
            if (r0 != 0) goto L_0x0042
            xiaoying.engine.clip.QClip r2 = r2.getDataClip()
            r0 = 6
            int r2 = com.introvd.template.sdk.utils.p394b.C8537n.m24827h(r2, r0)
            if (r2 > 0) goto L_0x0042
            r2 = 1
            goto L_0x0043
        L_0x0042:
            r2 = 0
        L_0x0043:
            if (r2 != 0) goto L_0x0054
            com.introvd.template.sdk.utils.VeMSize r2 = com.introvd.template.sdk.utils.C8572y.aJp()
            if (r2 == 0) goto L_0x0054
            int r0 = r2.width
            if (r0 <= 0) goto L_0x0054
            int r0 = r2.height
            if (r0 <= 0) goto L_0x0054
            goto L_0x0055
        L_0x0054:
            r2 = r3
        L_0x0055:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.sdk.utils.p394b.C8522g.m24672c(xiaoying.engine.storyboard.QStoryboard, boolean):com.introvd.template.sdk.utils.VeMSize");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x005a, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x005f, code lost:
        return;
     */
    /* renamed from: g */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void m24674g(com.introvd.template.sdk.model.editor.ProjectItem r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            if (r6 == 0) goto L_0x005e
            xiaoying.engine.storyboard.QStoryboard r0 = r6.mStoryBoard     // Catch:{ all -> 0x005b }
            if (r0 == 0) goto L_0x005e
            com.introvd.template.sdk.model.editor.DataItemProject r0 = r6.mProjectDataItem     // Catch:{ all -> 0x005b }
            if (r0 == 0) goto L_0x005e
            com.introvd.template.sdk.model.editor.DataItemProject r0 = r6.mProjectDataItem     // Catch:{ all -> 0x005b }
            int r0 = r0.iPrjClipCount     // Catch:{ all -> 0x005b }
            if (r0 != 0) goto L_0x0012
            goto L_0x005e
        L_0x0012:
            com.introvd.template.sdk.model.editor.DataItemProject r0 = r6.mProjectDataItem     // Catch:{ all -> 0x005b }
            int r0 = r0.streamWidth     // Catch:{ all -> 0x005b }
            com.introvd.template.sdk.model.editor.DataItemProject r1 = r6.mProjectDataItem     // Catch:{ all -> 0x005b }
            int r1 = r1.streamHeight     // Catch:{ all -> 0x005b }
            com.introvd.template.sdk.model.editor.DataItemProject r2 = r6.mProjectDataItem     // Catch:{ all -> 0x005b }
            java.lang.String r2 = r2.strPrjThumbnail     // Catch:{ all -> 0x005b }
            xiaoying.engine.storyboard.QStoryboard r3 = r6.mStoryBoard     // Catch:{ all -> 0x005b }
            int r4 = r5.bmE     // Catch:{ all -> 0x005b }
            int r0 = m24665a(r3, r0, r1, r2, r4)     // Catch:{ all -> 0x005b }
            com.introvd.template.sdk.model.editor.DataItemProject r1 = r6.mProjectDataItem     // Catch:{ all -> 0x005b }
            java.lang.String r1 = r1.strCoverURL     // Catch:{ all -> 0x005b }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x005b }
            if (r1 != 0) goto L_0x0059
            com.introvd.template.sdk.model.editor.DataItemProject r1 = r6.mProjectDataItem     // Catch:{ all -> 0x005b }
            java.lang.String r1 = r1.strCoverURL     // Catch:{ all -> 0x005b }
            boolean r1 = com.introvd.template.sdk.utils.C8548e.isFileExisted(r1)     // Catch:{ all -> 0x005b }
            if (r1 == 0) goto L_0x0059
            com.introvd.template.sdk.model.editor.DataItemProject r1 = r6.mProjectDataItem     // Catch:{ all -> 0x005b }
            java.lang.String r1 = r1.strCoverURL     // Catch:{ all -> 0x005b }
            com.introvd.template.sdk.utils.C8548e.deleteFile(r1)     // Catch:{ all -> 0x005b }
            com.introvd.template.sdk.model.editor.DataItemProject r1 = r6.mProjectDataItem     // Catch:{ all -> 0x005b }
            java.lang.String r1 = r1.strPrjThumbnail     // Catch:{ all -> 0x005b }
            com.introvd.template.sdk.model.editor.DataItemProject r2 = r6.mProjectDataItem     // Catch:{ all -> 0x005b }
            java.lang.String r2 = r2.strCoverURL     // Catch:{ all -> 0x005b }
            com.introvd.template.sdk.utils.C8548e.copyFile(r1, r2)     // Catch:{ all -> 0x005b }
            com.introvd.template.sdk.model.editor.DataItemProject r1 = r6.mProjectDataItem     // Catch:{ all -> 0x005b }
            com.introvd.template.sdk.model.editor.DataItemProject r6 = r6.mProjectDataItem     // Catch:{ all -> 0x005b }
            java.lang.String r6 = r6.strExtra     // Catch:{ all -> 0x005b }
            long r2 = (long) r0     // Catch:{ all -> 0x005b }
            java.lang.String r6 = com.introvd.template.sdk.utils.C8558m.m25023k(r6, r2)     // Catch:{ all -> 0x005b }
            r1.strExtra = r6     // Catch:{ all -> 0x005b }
        L_0x0059:
            monitor-exit(r5)
            return
        L_0x005b:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        L_0x005e:
            monitor-exit(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.sdk.utils.p394b.C8522g.m24674g(com.introvd.template.sdk.model.editor.ProjectItem):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public synchronized void m24675h(ProjectItem projectItem) {
        try {
            m24674g(projectItem);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return;
    }

    /* renamed from: iP */
    public static void m24676iP(String str) {
        DataItemClip dataItemClip = new DataItemClip();
        dataItemClip.strCreateTime = new SimpleDateFormat(H5PullHeader.TIME_FORMAT, Locale.US).format(new Date(System.currentTimeMillis()));
        dataItemClip.strClipURL = str;
        C8402a.m24227b(dataItemClip);
    }

    /* renamed from: j */
    private void m24677j(Context context, String str, int i) {
        if (11 != i) {
            if (8867879 == i) {
                ErrorInfoModel errorInfoModel = C8521f.ehR;
                if (errorInfoModel != null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("saveCurrentProject projectModule.saveProject err, strFullTempFileName=");
                    sb.append(str);
                    sb.append(";iRes=");
                    sb.append(i);
                    sb.append(";miss template path:");
                    sb.append(errorInfoModel.getmTemplatePath());
                    sb.append(";need download:");
                    sb.append(errorInfoModel.isbNeedDownload());
                    sb.toString();
                }
                C8410e.aGX().aGZ().setBoolean("template_info_miss_in_db_flag", true);
            }
            if (C8410e.aGX().aGV() > 0) {
                C8565t.show(context, C8410e.aGX().aGV(), 0);
            }
        } else if (C8410e.aGX().aGU() > 0) {
            C8565t.show(context, C8410e.aGX().aGU(), 0);
        }
    }

    /* renamed from: jw */
    private VeMSize m24678jw(boolean z) {
        QStoryboard aHd = aHd();
        if (aHd != null) {
            long longValue = C8540q.m24894C(aHd).longValue();
            if (longValue > 0 && !C8450a.m24468bm(longValue)) {
                VeMSize n = m24679n(z, C8532k.m24769q(Long.valueOf(longValue)));
                return (n != null || !C8450a.m24467bl(longValue)) ? n : C8572y.aJq();
            }
        }
        return null;
    }

    /* renamed from: n */
    public static VeMSize m24679n(boolean z, String str) {
        QSize nX = C8450a.m24474nX(str);
        if (nX == null || nX.mWidth <= 0 || nX.mHeight <= 0) {
            return null;
        }
        VeMSize js = C8572y.m25096js(z);
        VeMSize d = C8572y.m25086d(new VeMSize(nX.mWidth, nX.mHeight), js);
        StringBuilder sb = new StringBuilder();
        sb.append("getThemeStreamSize resultSize=");
        sb.append(d);
        C8554j.m25010v("ProjectMgr", sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append("getThemeStreamSize limitSize=");
        sb2.append(js);
        C8554j.m25010v("ProjectMgr", sb2.toString());
        StringBuilder sb3 = new StringBuilder();
        sb3.append("getThemeStreamSize xytSize=");
        sb3.append(nX.mWidth);
        sb3.append(EditorRouter.KEY_TOOL_LIST_ORDER_SPLIT_OP);
        sb3.append(nX.mHeight);
        C8554j.m25010v("ProjectMgr", sb3.toString());
        return d;
    }

    /* renamed from: nL */
    private static void m24680nL(String str) {
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
                C85264 r3 = new FilenameFilter() {
                    public boolean accept(File file, String str) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(fileName);
                        sb.append(".");
                        return str.startsWith(sb.toString());
                    }
                };
                if (!TextUtils.isEmpty(parent)) {
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

    /* renamed from: F */
    public boolean mo34723F(boolean z, boolean z2) {
        QStoryboard aHd = aHd();
        DataItemProject aHe = aHe();
        if (aHe == null || aHd == null) {
            return false;
        }
        boolean a = m24669a(aHd, aHe, z, z2);
        if (a) {
            C8540q.m24935a(aHd, new VeMSize(aHe.streamWidth, aHe.streamHeight));
            aHc();
        }
        return a;
    }

    /* renamed from: S */
    public synchronized void mo33874S(Context context, boolean z) {
        C8553i.setContext(context);
        C8553i.m25005ut(23);
        if (z) {
            this.efJ = true;
            return;
        }
        ArrayList<ProjectItem> arrayList = new ArrayList<>();
        long currentTimeMillis = System.currentTimeMillis();
        Iterator it = C8404c.aHH().iterator();
        while (it.hasNext()) {
            ProjectItem projectItem = new ProjectItem((DataItemProject) it.next(), null);
            if (this.ebR != null && this.ebR.contains(projectItem)) {
                projectItem = (ProjectItem) this.ebR.remove(this.ebR.indexOf(projectItem));
            }
            arrayList.add(projectItem);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("ProjectMgr loadData cost:");
        sb.append(System.currentTimeMillis() - currentTimeMillis);
        C8554j.m25008i("ProjectMgr", sb.toString());
        if (this.ebR != null) {
            for (ProjectItem i : this.ebR) {
                mo34764i(i);
            }
            this.ebR.clear();
        } else {
            this.ebR = new ArrayList();
        }
        for (ProjectItem projectItem2 : arrayList) {
            if (C8451b.m24478uo(projectItem2.mProjectDataItem.prjThemeType)) {
                this.ebR.add(projectItem2);
            }
        }
        synchronized (this.mLock) {
            this.efJ = true;
        }
    }

    /* renamed from: a */
    public int mo34724a(TrimedClipItemDataModel trimedClipItemDataModel, C8501a aVar, int i, boolean z) {
        if (trimedClipItemDataModel.bCropFeatureEnable.booleanValue()) {
            C8519d dVar = new C8519d(-1, -1);
            dVar.mTrimVeRange = trimedClipItemDataModel.mTrimVeRange;
            return mo34727a(trimedClipItemDataModel.mExportPath, aVar, i, dVar, 1.0f, null, null, null, z);
        }
        VeRange veRange = trimedClipItemDataModel.mVeRangeInRawVideo;
        C8519d dVar2 = new C8519d(veRange.getmPosition(), veRange.getLimitValue());
        dVar2.mo34712tV(trimedClipItemDataModel.mRotate.intValue());
        dVar2.mEffectPath = trimedClipItemDataModel.mEffectPath;
        dVar2.mo34707ju(trimedClipItemDataModel.bCrop.booleanValue());
        dVar2.mo34708l(trimedClipItemDataModel.cropRect);
        dVar2.mTrimVeRange = trimedClipItemDataModel.mTrimVeRange;
        dVar2.setmClipReverseFilePath(trimedClipItemDataModel.getmClipReverseFilePath());
        dVar2.setbIsReverseMode(trimedClipItemDataModel.isbIsReverseMode());
        dVar2.setIsClipReverse(trimedClipItemDataModel.isClipReverse());
        dVar2.ehM = trimedClipItemDataModel.digitalWaterMarkCode;
        return mo34727a((!trimedClipItemDataModel.isExported.booleanValue() || !C8548e.isFileExisted(trimedClipItemDataModel.mExportPath)) ? trimedClipItemDataModel.mRawFilePath : trimedClipItemDataModel.mExportPath, aVar, i, dVar2, 1.0f, null, null, null, z);
    }

    /* renamed from: a */
    public int mo34725a(String str, C8501a aVar, int i, int i2, int i3, int i4, boolean z) {
        int i5 = i2;
        int i6 = i3;
        C8519d dVar = new C8519d(i2, i3);
        dVar.mo34712tV(i4);
        return mo34727a(str, aVar, i, dVar, 1.0f, null, null, null, z);
    }

    /* renamed from: a */
    public int mo34726a(String str, C8501a aVar, int i, int i2, int i3, boolean z) {
        int i4 = i2;
        int i5 = i3;
        return mo34727a(str, aVar, i, new C8519d(i2, i3), 1.0f, null, null, null, z);
    }

    /* renamed from: a */
    public int mo34727a(String str, C8501a aVar, int i, C8519d dVar, float f, DataMusicItem dataMusicItem, DataLyricsItem dataLyricsItem, DataPIPIItem dataPIPIItem, boolean z) {
        QClip qClip;
        boolean z2;
        ProjectItem projectItem;
        String str2 = str;
        C8501a aVar2 = aVar;
        int i2 = i;
        C8519d dVar2 = dVar;
        DataMusicItem dataMusicItem2 = dataMusicItem;
        DataLyricsItem dataLyricsItem2 = dataLyricsItem;
        if (TextUtils.isEmpty(str) || aVar2 == null || dVar2 == null) {
            return 2;
        }
        if (this.ebQ == -1) {
            return 1;
        }
        QEngine aJv = aVar.aJv();
        StringBuilder sb = new StringBuilder();
        sb.append("InsertFile: file = ");
        sb.append(str2);
        C8554j.m25007e("ProjectMgr", sb.toString());
        int d = C8572y.m25084d(str2, aJv);
        if (d != 0) {
            return d;
        }
        ProjectItem uz = mo34778uz(this.ebQ);
        if (uz == null) {
            return 5;
        }
        boolean IsImageFileType = C8556l.IsImageFileType(C8556l.GetFileMediaType(str));
        if (IsImageFileType) {
            qClip = C8537n.m24824f(str2, aJv);
            C8537n.m24821e(qClip, dVar.aJy() - dVar.aJx());
        } else {
            qClip = C8537n.m24824f(str2, aJv);
        }
        if (qClip == null) {
            uz.mProjectDataItem.iPrjClipCount--;
            return 4;
        }
        QVideoInfo qVideoInfo = (QVideoInfo) qClip.getProperty(12291);
        if (qVideoInfo != null && !IsImageFileType) {
            int i3 = qVideoInfo.get(3);
            int i4 = qVideoInfo.get(4);
            boolean z3 = i3 <= i4;
            if (dVar.aHX() == 90 || dVar.aHX() == 270) {
                z3 = i3 > i4;
            }
            if (z3) {
                qClip.setProperty(QClip.PROP_CLIP_PANZOOM_DISABLED, Boolean.FALSE);
            } else {
                qClip.setProperty(QClip.PROP_CLIP_PANZOOM_DISABLED, Boolean.TRUE);
            }
            if (dVar.isClipReverse() && C8548e.isFileExisted(dVar.getmClipReverseFilePath())) {
                qClip.setProperty(QClip.PROP_CLIP_IS_REVERSE_CLIP, Boolean.TRUE);
                qClip.setProperty(QClip.PROP_CLIP_REVERSE_SOURCE, dVar.getmClipReverseFilePath());
                qClip.setProperty(QClip.PROP_CLIP_IS_REVERSE_MODE, Boolean.valueOf(dVar.isbIsReverseMode()));
            }
            if (!TextUtils.isEmpty(dVar2.ehM)) {
                C8537n.m24802a(qClip, "xy_digital_watermark_code_key", dVar2.ehM);
            }
        }
        if (dVar.aHX() > 0) {
            qClip.setProperty(12315, Integer.valueOf(dVar.aHX()));
        }
        RectF aJw = dVar.aJw();
        if (dVar.aJz() && aJw != null) {
            qClip.setProperty(12314, new QRect((int) aJw.left, (int) aJw.top, (int) aJw.right, (int) aJw.bottom));
        }
        int aJy = dVar.aJy() - dVar.aJx();
        if (!(dVar.aJx() == -1 || dVar.aJy() == -1)) {
            QRange qRange = new QRange();
            qRange.set(0, dVar.aJx());
            qRange.set(1, aJy);
            qClip.setProperty(QClip.PROP_CLIP_SRC_RANGE, qRange);
            qClip.setProperty(12293, Float.valueOf(f));
        }
        if (dVar2.mTrimVeRange != null) {
            QRange qRange2 = new QRange();
            qRange2.set(0, dVar2.mTrimVeRange.getmPosition());
            z2 = true;
            qRange2.set(1, dVar2.mTrimVeRange.getmTimeLength());
            qClip.setProperty(12292, qRange2);
        } else {
            z2 = true;
        }
        if (!C8572y.m25061O(f, 1.0f)) {
            qClip.setProperty(QClip.PROP_AUDIO_MODIFY_BY_ASP, Boolean.valueOf(z2));
            qClip.setProperty(QClip.PROP_AUDIO_PITCH_DELTA, Float.valueOf(0.0f));
        }
        C8517b.m24644a(uz.mClipModelCacheList, uz.mStoryBoard);
        int a = C8540q.m24923a(uz.mStoryBoard, qClip, i2);
        if (a != 0) {
            qClip.unInit();
            uz.mProjectDataItem.iPrjClipCount--;
            return a;
        }
        if (dataMusicItem2 == null || !dataMusicItem.isValidItem()) {
            projectItem = uz;
        } else {
            QClip i5 = C8540q.m24956i(uz.mStoryBoard, i2);
            int i6 = dataMusicItem2.currentTimeStamp - aJy;
            int i7 = i6 < 0 ? 0 : i6;
            projectItem = uz;
            C8537n.m24786a(aJv, i5, dataMusicItem2.filePath, i7, aJy, 0, aJy, 100);
        }
        if (dataLyricsItem2 != null) {
            C8537n.m24785a(aJv, qClip, dataLyricsItem2);
        }
        if (!TextUtils.isEmpty(dVar2.mEffectPath)) {
            C8540q.m24917a(projectItem.mStoryBoard.getEngine(), dVar2.mEffectPath, 0, true, qClip);
        }
        try {
            C8440a c = C8517b.m24648c(C8540q.m24956i(projectItem.mStoryBoard, i2), i2);
            if (projectItem.mClipModelCacheList == null || c == null) {
                return 1;
            }
            projectItem.mClipModelCacheList.mo34292a(c);
            C8517b.m24643a(projectItem.mClipModelCacheList);
            projectItem.mClipModelCacheList.mo34308tY(i2);
            projectItem.mClipModelCacheList.aIl();
            aVar2.mo34669jt(true);
            return 0;
        } catch (Exception unused) {
            projectItem.mProjectDataItem.iPrjClipCount--;
            return 1;
        }
    }

    /* renamed from: a */
    public int mo34728a(String str, C8501a aVar, int i, C8519d dVar, float f, String str2, int i2, DataLyricsItem dataLyricsItem) {
        QClip qClip;
        int i3;
        ProjectItem projectItem;
        String str3 = str;
        C8501a aVar2 = aVar;
        int i4 = i;
        C8519d dVar2 = dVar;
        DataLyricsItem dataLyricsItem2 = dataLyricsItem;
        if (TextUtils.isEmpty(str) || aVar2 == null || dVar2 == null) {
            return 2;
        }
        if (this.ebQ == -1) {
            return 1;
        }
        QEngine aJv = aVar.aJv();
        StringBuilder sb = new StringBuilder();
        sb.append("InsertFile: file = ");
        sb.append(str3);
        C8554j.m25007e("ProjectMgr", sb.toString());
        int d = C8572y.m25084d(str3, aJv);
        if (d != 0) {
            return d;
        }
        ProjectItem uz = mo34778uz(this.ebQ);
        if (uz == null) {
            return 5;
        }
        boolean IsImageFileType = C8556l.IsImageFileType(C8556l.GetFileMediaType(str));
        if (IsImageFileType) {
            qClip = C8537n.m24824f(str3, aJv);
            C8537n.m24821e(qClip, dVar.aJy() - dVar.aJx());
        } else {
            qClip = C8537n.m24824f(str3, aJv);
        }
        if (qClip == null) {
            uz.mProjectDataItem.iPrjClipCount--;
            return 4;
        }
        QVideoInfo qVideoInfo = (QVideoInfo) qClip.getProperty(12291);
        if (qVideoInfo != null && !IsImageFileType) {
            int i5 = qVideoInfo.get(3);
            int i6 = qVideoInfo.get(4);
            boolean z = i5 <= i6;
            if (dVar.aHX() == 90 || dVar.aHX() == 270) {
                z = i5 > i6;
            }
            if (z) {
                qClip.setProperty(QClip.PROP_CLIP_PANZOOM_DISABLED, Boolean.FALSE);
            } else {
                qClip.setProperty(QClip.PROP_CLIP_PANZOOM_DISABLED, Boolean.TRUE);
            }
            if (dVar.isClipReverse() && C8548e.isFileExisted(dVar.getmClipReverseFilePath())) {
                qClip.setProperty(QClip.PROP_CLIP_IS_REVERSE_CLIP, Boolean.TRUE);
                qClip.setProperty(QClip.PROP_CLIP_REVERSE_SOURCE, dVar.getmClipReverseFilePath());
                qClip.setProperty(QClip.PROP_CLIP_IS_REVERSE_MODE, Boolean.valueOf(dVar.isbIsReverseMode()));
            }
            if (!TextUtils.isEmpty(dVar2.ehM)) {
                C8537n.m24802a(qClip, "xy_digital_watermark_code_key", dVar2.ehM);
            }
        }
        if (dVar.aHX() > 0) {
            qClip.setProperty(12315, Integer.valueOf(dVar.aHX()));
        }
        RectF aJw = dVar.aJw();
        if (dVar.aJz() && aJw != null) {
            qClip.setProperty(12314, new QRect((int) aJw.left, (int) aJw.top, (int) aJw.right, (int) aJw.bottom));
        }
        int aJy = dVar.aJy() - dVar.aJx();
        if (!(dVar.aJx() == -1 || dVar.aJy() == -1)) {
            QRange qRange = new QRange();
            qRange.set(0, dVar.aJx());
            qRange.set(1, aJy);
            qClip.setProperty(QClip.PROP_CLIP_SRC_RANGE, qRange);
            qClip.setProperty(12293, Float.valueOf(f));
        }
        if (dVar2.mTrimVeRange != null) {
            QRange qRange2 = new QRange();
            qRange2.set(0, dVar2.mTrimVeRange.getmPosition());
            qRange2.set(1, dVar2.mTrimVeRange.getmTimeLength());
            qClip.setProperty(12292, qRange2);
        }
        if (!C8572y.m25061O(f, 1.0f)) {
            qClip.setProperty(QClip.PROP_AUDIO_MODIFY_BY_ASP, Boolean.valueOf(true));
            qClip.setProperty(QClip.PROP_AUDIO_PITCH_DELTA, Float.valueOf(0.0f));
        }
        if (dVar2.camExportEffectDataArray != null) {
            qClip.setProperty(QClip.PROP_CLIP_CAM_EXPORT_EFFECT_DATA_LIST, dVar2.camExportEffectDataArray);
        }
        C8517b.m24644a(uz.mClipModelCacheList, uz.mStoryBoard);
        int a = C8540q.m24923a(uz.mStoryBoard, qClip, i4);
        if (a != 0) {
            qClip.unInit();
            uz.mProjectDataItem.iPrjClipCount--;
            return a;
        }
        if (!TextUtils.isEmpty(str2)) {
            QClip i7 = C8540q.m24956i(uz.mStoryBoard, i4);
            int i8 = i2 - aJy;
            int i9 = i8 < 0 ? 0 : i8;
            i3 = 0;
            projectItem = uz;
            C8537n.m24786a(aJv, i7, str2, i9, aJy, 0, aJy, 100);
        } else {
            projectItem = uz;
            i3 = 0;
        }
        if (dataLyricsItem2 != null) {
            C8537n.m24785a(aJv, qClip, dataLyricsItem2);
        }
        if (!TextUtils.isEmpty(dVar2.mEffectPath)) {
            C8540q.m24917a(projectItem.mStoryBoard.getEngine(), dVar2.mEffectPath, i3, true, qClip);
        }
        try {
            C8440a c = C8517b.m24648c(C8540q.m24956i(projectItem.mStoryBoard, i4), i4);
            if (projectItem.mClipModelCacheList == null || c == null) {
                return 1;
            }
            projectItem.mClipModelCacheList.mo34292a(c);
            C8517b.m24643a(projectItem.mClipModelCacheList);
            projectItem.mClipModelCacheList.mo34308tY(i4);
            projectItem.mClipModelCacheList.aIl();
            aVar2.mo34669jt(true);
            return i3;
        } catch (Exception unused) {
            projectItem.mProjectDataItem.iPrjClipCount--;
            return 1;
        }
    }

    /* renamed from: a */
    public int mo34729a(String str, C8501a aVar, int i, boolean z) {
        return mo34726a(str, aVar, i, -1, -1, z);
    }

    /* renamed from: a */
    public int mo34730a(boolean z, C8501a aVar, Handler handler, boolean z2, ProjectItem projectItem) {
        if (this.efH) {
            return 6;
        }
        return mo34731a(z, aVar, handler, false, true, z2, projectItem);
    }

    /* JADX WARNING: Removed duplicated region for block: B:59:0x0123 A[Catch:{ all -> 0x0018, Throwable -> 0x001b }] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0130 A[SYNTHETIC, Splitter:B:63:0x0130] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int mo34731a(boolean r8, com.introvd.template.sdk.utils.p394b.C8501a r9, final android.os.Handler r10, boolean r11, boolean r12, boolean r13, com.introvd.template.sdk.model.editor.ProjectItem r14) {
        /*
            r7 = this;
            boolean r0 = r7.efH
            if (r0 == 0) goto L_0x0006
            r8 = 6
            return r8
        L_0x0006:
            int r0 = android.os.Process.myTid()
            int r0 = android.os.Process.getThreadPriority(r0)
            r1 = 0
            r2 = 1
            if (r11 == 0) goto L_0x001e
            r3 = -19
            android.os.Process.setThreadPriority(r3)     // Catch:{ Throwable -> 0x001b }
            goto L_0x001e
        L_0x0018:
            r8 = move-exception
            goto L_0x0162
        L_0x001b:
            r8 = move-exception
            goto L_0x0157
        L_0x001e:
            java.lang.String r3 = "ProjectMgr"
            java.lang.String r4 = "defaultSaveProject <---"
            com.introvd.template.sdk.utils.C8554j.m25007e(r3, r4)     // Catch:{ Throwable -> 0x001b }
            if (r9 == 0) goto L_0x0151
            int r3 = r7.ebQ     // Catch:{ Throwable -> 0x001b }
            r4 = -1
            if (r3 == r4) goto L_0x0151
            java.util.List r3 = r7.ebR     // Catch:{ Throwable -> 0x001b }
            if (r3 != 0) goto L_0x0032
            goto L_0x0151
        L_0x0032:
            if (r14 == 0) goto L_0x014b
            xiaoying.engine.storyboard.QStoryboard r3 = r14.mStoryBoard     // Catch:{ Throwable -> 0x001b }
            if (r3 != 0) goto L_0x003a
            goto L_0x014b
        L_0x003a:
            if (r8 != 0) goto L_0x0051
            xiaoying.engine.storyboard.QStoryboard r8 = r14.mStoryBoard     // Catch:{ Throwable -> 0x001b }
            int r8 = r8.getClipCount()     // Catch:{ Throwable -> 0x001b }
            if (r8 != 0) goto L_0x0051
            int r8 = r7.ebQ     // Catch:{ Throwable -> 0x001b }
            r7.mo34776uk(r8)     // Catch:{ Throwable -> 0x001b }
            r7.ebQ = r4     // Catch:{ Throwable -> 0x001b }
            if (r11 == 0) goto L_0x0050
            android.os.Process.setThreadPriority(r0)
        L_0x0050:
            return r2
        L_0x0051:
            boolean r8 = r9.isProjectModified()     // Catch:{ Throwable -> 0x001b }
            if (r8 != 0) goto L_0x006b
            com.introvd.template.sdk.model.editor.DataItemProject r8 = r14.mProjectDataItem     // Catch:{ Throwable -> 0x001b }
            java.lang.String r8 = r8.strPrjURL     // Catch:{ Throwable -> 0x001b }
            boolean r8 = com.introvd.template.sdk.utils.C8548e.isFileExisted(r8)     // Catch:{ Throwable -> 0x001b }
            if (r8 == 0) goto L_0x006b
            r7.aHc()     // Catch:{ Throwable -> 0x001b }
            r8 = 5
            if (r11 == 0) goto L_0x006a
            android.os.Process.setThreadPriority(r0)
        L_0x006a:
            return r8
        L_0x006b:
            android.content.Context r8 = r7.mContext     // Catch:{ Throwable -> 0x001b }
            java.util.Date r9 = new java.util.Date     // Catch:{ Throwable -> 0x001b }
            r9.<init>()     // Catch:{ Throwable -> 0x001b }
            java.lang.String r3 = "yyyy-MM-dd HH:mm:ss"
            java.lang.String r8 = m24132a(r8, r9, r3)     // Catch:{ Throwable -> 0x001b }
            com.introvd.template.sdk.model.editor.DataItemProject r9 = r14.mProjectDataItem     // Catch:{ Throwable -> 0x001b }
            java.lang.String r9 = r9.strPrjURL     // Catch:{ Throwable -> 0x001b }
            boolean r3 = android.text.TextUtils.isEmpty(r9)     // Catch:{ Throwable -> 0x001b }
            if (r3 == 0) goto L_0x00d5
            java.util.Date r9 = new java.util.Date     // Catch:{ Throwable -> 0x001b }
            r9.<init>()     // Catch:{ Throwable -> 0x001b }
            java.lang.String r3 = "'Project'_yyyyMMdd_HHmmss"
            java.text.SimpleDateFormat r4 = new java.text.SimpleDateFormat     // Catch:{ Throwable -> 0x001b }
            java.util.Locale r5 = java.util.Locale.US     // Catch:{ Throwable -> 0x001b }
            r4.<init>(r3, r5)     // Catch:{ Throwable -> 0x001b }
            java.lang.String r9 = r4.format(r9)     // Catch:{ Throwable -> 0x001b }
            com.introvd.template.sdk.model.editor.DataItemProject r3 = r14.mProjectDataItem     // Catch:{ Throwable -> 0x001b }
            r3.strCreateTime = r8     // Catch:{ Throwable -> 0x001b }
            com.introvd.template.sdk.model.editor.DataItemProject r3 = r14.mProjectDataItem     // Catch:{ Throwable -> 0x001b }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x001b }
            r4.<init>()     // Catch:{ Throwable -> 0x001b }
            java.lang.String r5 = com.introvd.template.sdk.C8401d.ane()     // Catch:{ Throwable -> 0x001b }
            r4.append(r5)     // Catch:{ Throwable -> 0x001b }
            r4.append(r9)     // Catch:{ Throwable -> 0x001b }
            java.lang.String r5 = ".prj"
            r4.append(r5)     // Catch:{ Throwable -> 0x001b }
            java.lang.String r4 = r4.toString()     // Catch:{ Throwable -> 0x001b }
            r3.strPrjURL = r4     // Catch:{ Throwable -> 0x001b }
            com.introvd.template.sdk.model.editor.DataItemProject r3 = r14.mProjectDataItem     // Catch:{ Throwable -> 0x001b }
            java.lang.String r3 = r3.strPrjURL     // Catch:{ Throwable -> 0x001b }
            com.introvd.template.sdk.model.editor.DataItemProject r4 = r14.mProjectDataItem     // Catch:{ Throwable -> 0x001b }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x001b }
            r5.<init>()     // Catch:{ Throwable -> 0x001b }
            java.lang.String r6 = com.introvd.template.sdk.C8401d.ane()     // Catch:{ Throwable -> 0x001b }
            r5.append(r6)     // Catch:{ Throwable -> 0x001b }
            r5.append(r9)     // Catch:{ Throwable -> 0x001b }
            java.lang.String r9 = ".jpg"
            r5.append(r9)     // Catch:{ Throwable -> 0x001b }
            java.lang.String r9 = r5.toString()     // Catch:{ Throwable -> 0x001b }
            r4.strPrjThumbnail = r9     // Catch:{ Throwable -> 0x001b }
            r9 = r3
        L_0x00d5:
            com.introvd.template.sdk.model.editor.DataItemProject r3 = r14.mProjectDataItem     // Catch:{ Throwable -> 0x001b }
            xiaoying.engine.storyboard.QStoryboard r4 = r14.mStoryBoard     // Catch:{ Throwable -> 0x001b }
            int r4 = r4.getDuration()     // Catch:{ Throwable -> 0x001b }
            r3.iPrjDuration = r4     // Catch:{ Throwable -> 0x001b }
            com.introvd.template.sdk.model.editor.DataItemProject r3 = r14.mProjectDataItem     // Catch:{ Throwable -> 0x001b }
            xiaoying.engine.storyboard.QStoryboard r4 = r14.mStoryBoard     // Catch:{ Throwable -> 0x001b }
            int r4 = r4.getClipCount()     // Catch:{ Throwable -> 0x001b }
            r3.iPrjClipCount = r4     // Catch:{ Throwable -> 0x001b }
            if (r12 == 0) goto L_0x0106
            com.introvd.template.sdk.editor.cache.d r12 = r14.mClipModelCacheList     // Catch:{ Throwable -> 0x001b }
            if (r12 == 0) goto L_0x00f5
            boolean r3 = r12.aIm()     // Catch:{ Throwable -> 0x001b }
            if (r3 != 0) goto L_0x00ff
        L_0x00f5:
            com.introvd.template.sdk.model.editor.DataItemProject r3 = r14.mProjectDataItem     // Catch:{ Throwable -> 0x001b }
            java.lang.String r3 = r3.strPrjThumbnail     // Catch:{ Throwable -> 0x001b }
            boolean r3 = com.introvd.template.sdk.utils.C8548e.isFileExisted(r3)     // Catch:{ Throwable -> 0x001b }
            if (r3 != 0) goto L_0x0106
        L_0x00ff:
            if (r12 == 0) goto L_0x0104
            r12.mo34305jl(r1)     // Catch:{ Throwable -> 0x001b }
        L_0x0104:
            r12 = 1
            goto L_0x0107
        L_0x0106:
            r12 = 0
        L_0x0107:
            com.introvd.template.sdk.model.editor.DataItemProject r3 = r14.mProjectDataItem     // Catch:{ Throwable -> 0x001b }
            r3.strModifyTime = r8     // Catch:{ Throwable -> 0x001b }
            com.introvd.template.sdk.model.editor.DataItemProject r8 = r14.mProjectDataItem     // Catch:{ Throwable -> 0x001b }
            r8.iIsModified = r2     // Catch:{ Throwable -> 0x001b }
            com.introvd.template.sdk.model.editor.DataItemProject r8 = r14.mProjectDataItem     // Catch:{ Throwable -> 0x001b }
            r7.mo33886b(r8, r13)     // Catch:{ Throwable -> 0x001b }
            com.introvd.template.sdk.utils.b.g$3 r8 = new com.introvd.template.sdk.utils.b.g$3     // Catch:{ Throwable -> 0x001b }
            r8.<init>(r10, r12)     // Catch:{ Throwable -> 0x001b }
            android.content.Context r10 = r7.mContext     // Catch:{ Throwable -> 0x001b }
            xiaoying.engine.storyboard.QStoryboard r12 = r14.mStoryBoard     // Catch:{ Throwable -> 0x001b }
            int r8 = com.introvd.template.sdk.editor.p389c.C8438d.m24388a(r10, r9, r12, r8)     // Catch:{ Throwable -> 0x001b }
            if (r8 == 0) goto L_0x0130
            r7.efH = r1     // Catch:{ Throwable -> 0x001b }
            android.content.Context r10 = r7.mContext     // Catch:{ Throwable -> 0x001b }
            r7.m24677j(r10, r9, r8)     // Catch:{ Throwable -> 0x001b }
            if (r11 == 0) goto L_0x012f
            android.os.Process.setThreadPriority(r0)
        L_0x012f:
            return r8
        L_0x0130:
            r7.efH = r2     // Catch:{ Throwable -> 0x001b }
            com.introvd.template.sdk.model.editor.DataItemProject r8 = r14.mProjectDataItem     // Catch:{ Throwable -> 0x001b }
            r7.mo33876a(r8, r13)     // Catch:{ Throwable -> 0x001b }
            com.introvd.template.sdk.model.editor.DataItemProject r8 = r14.mProjectDataItem     // Catch:{ Throwable -> 0x001b }
            long r8 = r8._id     // Catch:{ Throwable -> 0x001b }
            com.introvd.template.sdk.p384d.C8403b.m24233bc(r8)     // Catch:{ Throwable -> 0x001b }
            java.lang.String r8 = "ProjectMgr"
            java.lang.String r9 = "defaultSaveProject --->"
            com.introvd.template.sdk.utils.C8554j.m25007e(r8, r9)     // Catch:{ Throwable -> 0x001b }
            if (r11 == 0) goto L_0x014a
            android.os.Process.setThreadPriority(r0)
        L_0x014a:
            return r1
        L_0x014b:
            if (r11 == 0) goto L_0x0150
            android.os.Process.setThreadPriority(r0)
        L_0x0150:
            return r2
        L_0x0151:
            if (r11 == 0) goto L_0x0156
            android.os.Process.setThreadPriority(r0)
        L_0x0156:
            return r2
        L_0x0157:
            r8.printStackTrace()     // Catch:{ all -> 0x0018 }
            r7.efH = r1     // Catch:{ all -> 0x0018 }
            if (r11 == 0) goto L_0x0161
            android.os.Process.setThreadPriority(r0)
        L_0x0161:
            return r2
        L_0x0162:
            if (r11 == 0) goto L_0x0167
            android.os.Process.setThreadPriority(r0)
        L_0x0167:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.sdk.utils.p394b.C8522g.mo34731a(boolean, com.introvd.template.sdk.utils.b.a, android.os.Handler, boolean, boolean, boolean, com.introvd.template.sdk.model.editor.ProjectItem):int");
    }

    /* renamed from: a */
    public void mo34732a(int i, float f, float f2, float f3) {
        this.bmE = i;
        this.bmF = f;
        this.bmG = f2;
        this.bmH = f3;
    }

    /* renamed from: a */
    public void mo34733a(int i, C8501a aVar, Handler handler) {
        DataItemProject tz = mo33891tz(i);
        if (tz != null && !TextUtils.isEmpty(tz.strPrjURL)) {
            mo34739a(tz.strPrjURL, aVar, handler);
        }
    }

    /* renamed from: a */
    public void mo34734a(ContentResolver contentResolver, String str, int i, boolean z) {
        if (!TextUtils.isEmpty(str) && contentResolver != null) {
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
            mo33890o(contentResolver, str);
            String ou = C8572y.m25097ou(str);
            String ow = C8572y.m25099ow(str);
            ArrayList ba = C8403b.m24231ba(nB);
            if (z) {
                C8403b.m24230b(nB, -1, false);
            }
            m24664a(ba, ou, i, contentResolver);
            m24671br(nB);
            m24680nL(str);
            if (!TextUtils.isEmpty(ou)) {
                C8548e.deleteDirectory(ou);
            }
            if (!TextUtils.isEmpty(ow)) {
                C8548e.deleteDirectory(ow);
            }
        }
    }

    /* renamed from: a */
    public void mo34735a(Context context, Handler handler, String str) {
        m24666a(context, C8451b.THEME, handler, false, str);
    }

    /* renamed from: a */
    public void mo34736a(Context context, Handler handler, boolean z, String str, String str2) {
        Context context2 = context;
        m24666a(context2, C8451b.FAST_EDITOR, handler, z, C8558m.m25036v(C8558m.aJh(), str, str2));
    }

    /* renamed from: a */
    public void mo33875a(Context context, String str, int i, boolean z) {
        mo34734a(context.getContentResolver(), str, i, z);
    }

    /* renamed from: a */
    public void mo34737a(ProjectItem projectItem) {
        if (this.ebR != null && projectItem != null && this.ebQ >= 0) {
            this.ebR.set(this.ebQ, projectItem);
        }
    }

    /* renamed from: a */
    public void mo34738a(C8501a aVar, Handler handler) {
        this.efH = false;
        if (aHd() == null) {
            mo34733a(this.ebQ, aVar, handler);
        } else {
            handler.sendEmptyMessage(268443657);
        }
    }

    /* renamed from: a */
    public void mo34739a(String str, final C8501a aVar, final Handler handler) {
        final ProjectItem oC = mo34770oC(str);
        if (aVar != null && oC != null && oC.mProjectDataItem != null) {
            if (handler != null) {
                aIV();
            }
            if (oC.mProjectDataItem.strPrjURL == null || this.ebS.get(oC.mProjectDataItem.strPrjURL) == null) {
                new C8484b<Void, Void, Object>() {
                    /* access modifiers changed from: protected */
                    public Object doInBackground(Void... voidArr) {
                        try {
                            C8522g.this.m24670b(oC.mProjectDataItem.strPrjURL, aVar, handler);
                            return null;
                        } catch (Throwable th) {
                            return th;
                        }
                    }

                    /* access modifiers changed from: protected */
                    public void onPostExecute(Object obj) {
                        if ((obj instanceof Throwable) && C8410e.aGX().aGW() > 0) {
                            C8565t.show(C8522g.this.mContext, C8410e.aGX().aGW(), 1);
                        }
                        super.onPostExecute(obj);
                    }
                }.mo34652e(new Void[0]);
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (mo33889nt(str) == this.ebQ) {
                currentTimeMillis += 31536000000L;
            }
            oC.lLastUpdateTime = currentTimeMillis;
            if (handler != null) {
                handler.sendEmptyMessage(268443649);
            }
        }
    }

    /* renamed from: a */
    public void mo34740a(String str, boolean z, ContentResolver contentResolver) {
        if (!TextUtils.isEmpty(str)) {
            StringBuilder sb = new StringBuilder();
            sb.append("filePath:");
            sb.append(str);
            sb.append(";isInsert:");
            sb.append(z);
            C8554j.m25008i("ProjectMgr", sb.toString());
            long nA = C8402a.m24228nA(str);
            long aJG = aJG();
            if (nA <= 0 || aJG <= 0) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("clipId:");
                sb2.append(nA);
                sb2.append(";projId:");
                sb2.append(aJG);
                C8554j.m25008i("ProjectMgr", sb2.toString());
                return;
            }
            C8403b.m24230b(aJG, nA, z);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0080, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0082, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0084, code lost:
        return false;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean mo34741a(int r10, android.os.Handler r11, boolean r12) {
        /*
            r9 = this;
            monitor-enter(r9)
            boolean r0 = r9.bce     // Catch:{ all -> 0x0085 }
            r1 = 0
            if (r0 == 0) goto L_0x0083
            java.util.List r0 = r9.ebR     // Catch:{ all -> 0x0085 }
            if (r0 == 0) goto L_0x0083
            if (r10 < 0) goto L_0x0083
            java.util.List r0 = r9.ebR     // Catch:{ all -> 0x0085 }
            int r0 = r0.size()     // Catch:{ all -> 0x0085 }
            if (r10 < r0) goto L_0x0016
            goto L_0x0083
        L_0x0016:
            if (r11 == 0) goto L_0x001b
            r9.aIV()     // Catch:{ all -> 0x0085 }
        L_0x001b:
            com.introvd.template.sdk.model.editor.ProjectItem r5 = r9.mo34778uz(r10)     // Catch:{ all -> 0x0085 }
            if (r5 == 0) goto L_0x0081
            com.introvd.template.sdk.model.editor.DataItemProject r0 = r5.mProjectDataItem     // Catch:{ all -> 0x0085 }
            if (r0 != 0) goto L_0x0026
            goto L_0x0081
        L_0x0026:
            int r0 = r5.getCacheFlag()     // Catch:{ all -> 0x0085 }
            r2 = r0 & 4
            r8 = 1
            if (r2 != 0) goto L_0x0077
            r0 = r0 & 8
            if (r0 == 0) goto L_0x0034
            goto L_0x0077
        L_0x0034:
            r0 = 12
            r5.setCacheFlag(r0, r1)     // Catch:{ all -> 0x0085 }
            com.introvd.template.sdk.editor.cache.d r0 = r5.mClipModelCacheList     // Catch:{ all -> 0x0085 }
            if (r0 == 0) goto L_0x0042
            com.introvd.template.sdk.editor.cache.d r0 = r5.mClipModelCacheList     // Catch:{ all -> 0x0085 }
            r0.releaseAll()     // Catch:{ all -> 0x0085 }
        L_0x0042:
            r0 = 4
            r5.setCacheFlag(r0, r8)     // Catch:{ all -> 0x0085 }
            java.lang.String r0 = "ProjectMgr"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0085 }
            r2.<init>()     // Catch:{ all -> 0x0085 }
            java.lang.String r3 = ">>>>>>>>>>>>>>>>> run mExtractTask. index="
            r2.append(r3)     // Catch:{ all -> 0x0085 }
            r2.append(r10)     // Catch:{ all -> 0x0085 }
            java.lang.String r10 = r2.toString()     // Catch:{ all -> 0x0085 }
            com.introvd.template.sdk.utils.C8554j.m25007e(r0, r10)     // Catch:{ all -> 0x0085 }
            com.introvd.template.sdk.utils.b.g$a r10 = new com.introvd.template.sdk.utils.b.g$a     // Catch:{ all -> 0x0085 }
            android.content.Context r4 = r9.mContext     // Catch:{ all -> 0x0085 }
            r2 = r10
            r3 = r9
            r6 = r11
            r7 = r12
            r2.<init>(r4, r5, r6, r7)     // Catch:{ all -> 0x0085 }
            r9.ehS = r10     // Catch:{ all -> 0x0085 }
            com.introvd.template.sdk.utils.b.g$a r10 = r9.ehS     // Catch:{ Exception -> 0x0071 }
            java.lang.Void[] r11 = new java.lang.Void[r1]     // Catch:{ Exception -> 0x0071 }
            r10.mo34652e(r11)     // Catch:{ Exception -> 0x0071 }
            goto L_0x0075
        L_0x0071:
            r10 = move-exception
            r10.printStackTrace()     // Catch:{ all -> 0x0085 }
        L_0x0075:
            monitor-exit(r9)
            return r8
        L_0x0077:
            if (r11 == 0) goto L_0x007f
            r10 = 268443657(0x10002009, float:2.5268228E-29)
            r11.sendEmptyMessage(r10)     // Catch:{ all -> 0x0085 }
        L_0x007f:
            monitor-exit(r9)
            return r8
        L_0x0081:
            monitor-exit(r9)
            return r1
        L_0x0083:
            monitor-exit(r9)
            return r1
        L_0x0085:
            r10 = move-exception
            monitor-exit(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.sdk.utils.p394b.C8522g.mo34741a(int, android.os.Handler, boolean):boolean");
    }

    /* renamed from: a */
    public boolean mo33877a(Handler handler, boolean z) {
        return mo34741a(this.ebQ, handler, z);
    }

    public boolean aHb() {
        return this.efJ;
    }

    public QStoryboard aHd() {
        if (aHf() != null) {
            return aHf().mStoryBoard;
        }
        return null;
    }

    public DataItemProject aHe() {
        if (aHf() != null) {
            return aHf().mProjectDataItem;
        }
        return null;
    }

    public void aHg() {
        mo34769nO(".backup");
    }

    public void aIV() {
        synchronized (this.mLock) {
            if (this.ehS != null && !this.ehS.isCancelled()) {
                this.ehS.cancel(true);
                this.ehS = null;
            }
        }
    }

    public C8443d aJB() {
        if (aHf() != null) {
            return aHf().mClipModelCacheList;
        }
        return null;
    }

    public void aJC() {
        ProjectItem ahP = aHf();
        if (ahP != null) {
            C8443d dVar = ahP.mClipModelCacheList;
            if (dVar != null) {
                for (int count = dVar.getCount() - 1; count >= 0; count--) {
                    C8440a tX = dVar.mo34307tX(count);
                    if (tX != null && !tX.isCover()) {
                        C8540q.m24963n(ahP.mStoryBoard, tX.aHL());
                        mo34740a(tX.aHU(), false, this.mContext.getContentResolver());
                        dVar.mo34309tZ(tX.aHL());
                        dVar.mo34297bN(tX.aHL());
                        C8517b.m24643a(dVar);
                        dVar.aIl();
                    }
                }
            }
        }
    }

    public int aJD() {
        ProjectItem ahP = aHf();
        if (ahP == null) {
            return 0;
        }
        C8443d dVar = ahP.mClipModelCacheList;
        if (dVar == null) {
            return 0;
        }
        int i = 0;
        for (int count = dVar.getCount() - 1; count >= 0; count--) {
            C8440a tX = dVar.mo34307tX(count);
            if (tX != null && !tX.isCover()) {
                if (!tX.aHW()) {
                    break;
                }
                C8540q.m24963n(ahP.mStoryBoard, tX.aHL());
                mo34740a(tX.aHU(), false, this.mContext.getContentResolver());
                dVar.mo34309tZ(tX.aHL());
                dVar.mo34297bN(tX.aHL());
                C8517b.m24643a(dVar);
                dVar.aIl();
                i++;
            }
        }
        return i;
    }

    public void aJE() {
        ProjectItem ahP = aHf();
        if (ahP != null) {
            DataItemProject aHe = aHe();
            if (aHe != null && ahP.mStoryBoard != null) {
                aHe.iPrjDuration = ahP.mStoryBoard.getDuration();
                aHe.iPrjClipCount = ahP.mStoryBoard.getClipCount();
                C8404c.m24239c(aHe);
            }
        }
    }

    public synchronized void aJF() {
        if (!this.ebS.isEmpty()) {
            for (Entry value : this.ebS.entrySet()) {
                ProjectItem projectItem = (ProjectItem) value.getValue();
                if (projectItem != null) {
                    if (projectItem.mStoryBoard != null) {
                        projectItem.mStoryBoard.unInit();
                        projectItem.mStoryBoard = null;
                    }
                    if (projectItem.mClipModelCacheList != null) {
                        projectItem.mClipModelCacheList.releaseAll();
                    }
                    projectItem.setCacheFlag(-1, false);
                    if (projectItem.mProjectDataItem.strPrjURL != null) {
                        this.efE.remove(projectItem.mProjectDataItem.strPrjURL);
                    }
                }
            }
            this.ebS.clear();
        }
    }

    public long aJG() {
        DataItemProject aHe = aHe();
        if (aHe != null) {
            String str = aHe.strPrjURL;
            if (!TextUtils.isEmpty(str)) {
                return C8404c.m24242nB(str);
            }
        }
        return -1;
    }

    public String aJH() {
        DataItemProject aHe = aHe();
        if (aHe != null && !TextUtils.isEmpty(aHe.strPrjURL)) {
            return C8572y.m25097ou(aHe.strPrjURL);
        }
        return null;
    }

    public String aJI() {
        DataItemProject aHe = aHe();
        if (aHe == null) {
            return null;
        }
        String str = aHe.strPrjURL;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return C8548e.getFileName(str);
    }

    public boolean aJJ() {
        return mo34772oE(".backup");
    }

    public TemplateConditionModel aJK() {
        TemplateConditionModel templateConditionModel = new TemplateConditionModel();
        DataItemProject aHe = aHe();
        if (aHe != null) {
            templateConditionModel.mLayoutMode = QUtils.getLayoutMode(aHe.streamWidth, aHe.streamHeight);
        }
        return templateConditionModel;
    }

    public String aJL() {
        String str = "";
        QStoryboard aHd = aHd();
        if (aHd != null) {
            if (C8540q.m24893B(aHd)) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append("主题+");
                str = sb.toString();
            }
            if (C8537n.m24827h(aHd.getDataClip(), 3) > 0) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append("字幕+");
                str = sb2.toString();
            }
            if (C8537n.m24827h(aHd.getDataClip(), 8) > 0) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(str);
                sb3.append("贴纸+");
                str = sb3.toString();
            }
            if (C8537n.m24827h(aHd.getDataClip(), 6) > 0) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append(str);
                sb4.append("特效+");
                str = sb4.toString();
            }
            ArrayList M = C8540q.m24904M(aHd);
            if (M != null && M.size() > 0) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append(str);
                sb5.append("滤镜+");
                str = sb5.toString();
            }
            ArrayList F = C8540q.m24897F(aHd);
            if (F != null && F.size() > 0) {
                StringBuilder sb6 = new StringBuilder();
                sb6.append(str);
                sb6.append("转场+");
                str = sb6.toString();
            }
            ArrayList l = C8540q.m24961l(aHd, 4);
            if (l != null && l.size() > 0) {
                StringBuilder sb7 = new StringBuilder();
                sb7.append(str);
                sb7.append("配音");
                str = sb7.toString();
            }
        }
        return TextUtils.isEmpty(str) ? ParametersKeys.ORIENTATION_NONE : str;
    }

    /* renamed from: ahP */
    public ProjectItem aHf() {
        return mo34778uz(this.ebQ);
    }

    /* renamed from: b */
    public int mo34755b(C8501a aVar) {
        if (this.efH || (aVar != null && !aVar.isProjectModified())) {
            return 6;
        }
        ProjectItem uz = mo34778uz(this.ebQ);
        if (uz == null || uz.mStoryBoard == null) {
            return 1;
        }
        String str = uz.mProjectDataItem.strPrjURL;
        if (!C8548e.isFileExisted(str)) {
            return 1;
        }
        QStoryboard qStoryboard = new QStoryboard();
        int duplicate = uz.mStoryBoard.duplicate(qStoryboard);
        if (duplicate != 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("defaultSaveProject out case: duplicate failed iRes=");
            sb.append(duplicate);
            C8554j.m25007e("ProjectMgr", sb.toString());
            qStoryboard.unInit();
            return 3;
        }
        int a = C8438d.m24388a(this.mContext, str, qStoryboard, new C8435a() {
            /* renamed from: nJ */
            public void mo34199nJ(String str) {
                if (TextUtils.isEmpty(str)) {
                    C8522g.this.efH = false;
                } else {
                    C8522g.this.efH = false;
                }
            }

            /* renamed from: nK */
            public void mo34200nK(String str) {
                C8522g.this.efH = false;
            }
        });
        if (a != 0) {
            qStoryboard.unInit();
            return a;
        }
        this.efH = true;
        return 0;
    }

    /* renamed from: b */
    public void mo34756b(Context context, Handler handler, boolean z, String str, String str2) {
        Context context2 = context;
        m24666a(context2, C8451b.THEME, handler, z, C8558m.m25036v(C8558m.aJh(), str, str2));
    }

    /* renamed from: b */
    public void mo34757b(DataItemClip dataItemClip) {
        if (this.mContext != null) {
            C8402a.m24227b(dataItemClip);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo33886b(DataItemProject dataItemProject, boolean z) {
        if (dataItemProject == null) {
            return;
        }
        if (dataItemProject.streamWidth == 0 || dataItemProject.streamHeight == 0) {
            VeMSize d = C8540q.m24946d(aHd(), z);
            if (d != null) {
                dataItemProject.streamWidth = d.width;
                dataItemProject.streamHeight = d.height;
            }
        }
    }

    /* renamed from: ba */
    public boolean mo34758ba(String str, String str2) {
        if (!TextUtils.isEmpty(str) && C8548e.isFileExisted(str)) {
            String fileName = C8548e.getFileName(str);
            String parent = new File(str).getParent();
            StringBuilder sb = new StringBuilder();
            sb.append(parent);
            sb.append("/");
            sb.append(fileName);
            sb.append(".prj");
            sb.append(str2);
            String sb2 = sb.toString();
            StringBuilder sb3 = new StringBuilder();
            sb3.append(parent);
            sb3.append("/");
            sb3.append(fileName);
            sb3.append(".dat");
            sb3.append(str2);
            String sb4 = sb3.toString();
            StringBuilder sb5 = new StringBuilder();
            sb5.append(parent);
            sb5.append("/");
            sb5.append(fileName);
            sb5.append(".dat");
            String sb6 = sb5.toString();
            StringBuilder sb7 = new StringBuilder();
            sb7.append(parent);
            sb7.append("/");
            sb7.append(fileName);
            sb7.append(".jpg");
            sb7.append(str2);
            String sb8 = sb7.toString();
            StringBuilder sb9 = new StringBuilder();
            sb9.append(parent);
            sb9.append("/");
            sb9.append(fileName);
            sb9.append(".jpg");
            String sb10 = sb9.toString();
            if (C8548e.isFileExisted(sb2) && C8548e.isFileExisted(str)) {
                if (!C8548e.m24996aT(str, sb2)) {
                    if (C8548e.deleteFile(str)) {
                        C8548e.copyFile(sb2, str);
                    }
                    if (C8548e.isFileExisted(sb4) && C8548e.deleteFile(sb6)) {
                        C8548e.copyFile(sb4, sb6);
                    }
                    if (C8548e.isFileExisted(sb10) && C8548e.deleteFile(sb10)) {
                        C8548e.copyFile(sb8, sb10);
                    }
                }
                C8548e.deleteFile(sb2);
                C8548e.deleteFile(sb4);
                C8548e.deleteFile(sb8);
                return true;
            }
        }
        return false;
    }

    /* renamed from: bb */
    public void mo34759bb(String str, String str2) {
        if (!TextUtils.isEmpty(str) && C8548e.isFileExisted(str)) {
            String fileName = C8548e.getFileName(str);
            String parent = new File(str).getParent();
            StringBuilder sb = new StringBuilder();
            sb.append(parent);
            sb.append("/");
            sb.append(fileName);
            sb.append(".prj");
            sb.append(str2);
            String sb2 = sb.toString();
            StringBuilder sb3 = new StringBuilder();
            sb3.append(parent);
            sb3.append("/");
            sb3.append(fileName);
            sb3.append(".dat");
            sb3.append(str2);
            String sb4 = sb3.toString();
            StringBuilder sb5 = new StringBuilder();
            sb5.append(parent);
            sb5.append("/");
            sb5.append(fileName);
            sb5.append(".jpg");
            sb5.append(str2);
            String sb6 = sb5.toString();
            C8548e.deleteFile(sb2);
            C8548e.deleteFile(sb4);
            C8548e.deleteFile(sb6);
        }
    }

    /* renamed from: c */
    public void mo34760c(int i, String str, int i2) {
        if (str != null && str.length() > 0) {
            QStoryboard aHd = aHd();
            QEngine qEngine = null;
            if (aHd != null) {
                qEngine = aHd.getEngine();
            }
            if (qEngine == null) {
                qEngine = C8501a.aJs().aJv();
            }
            C8540q.m24917a(qEngine, str, i2, true, C8540q.m24956i(aHd, i));
        }
    }

    /* renamed from: d */
    public int mo34761d(QClip qClip, int i) {
        if (qClip == null) {
            return 2;
        }
        ProjectItem uz = mo34778uz(this.ebQ);
        if (uz == null) {
            return 1;
        }
        C8517b.m24644a(uz.mClipModelCacheList, uz.mStoryBoard);
        if (C8540q.m24923a(uz.mStoryBoard, qClip, i) != 0) {
            qClip.unInit();
            uz.mProjectDataItem.iPrjClipCount--;
            return 2;
        }
        try {
            C8440a c = C8517b.m24648c(C8540q.m24956i(uz.mStoryBoard, i), i);
            if (uz.mClipModelCacheList == null || c == null) {
                return 1;
            }
            uz.mClipModelCacheList.mo34292a(c);
            C8517b.m24643a(uz.mClipModelCacheList);
            uz.mClipModelCacheList.mo34308tY(i);
            uz.mClipModelCacheList.aIl();
            return 0;
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("UtilFuncs.createClipModel failed!");
            sb.append(e.getMessage());
            C8554j.m25007e("ProjectMgr", sb.toString());
            uz.mProjectDataItem.iPrjClipCount--;
            return 1;
        }
    }

    /* renamed from: d */
    public ProjectItem mo34762d(DataItemProject dataItemProject) {
        if (this.ebR == null || dataItemProject == null) {
            return null;
        }
        for (ProjectItem projectItem : this.ebR) {
            if (projectItem != null && projectItem.mProjectDataItem != null && TextUtils.equals(dataItemProject.strPrjURL, projectItem.mProjectDataItem.strPrjURL)) {
                return projectItem;
            }
        }
        return null;
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
            java.lang.Object r0 = r3.mLock
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
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.sdk.utils.p394b.C8522g.getCount():int");
    }

    /* renamed from: h */
    public void mo34763h(ContentResolver contentResolver) {
        DataItemProject aHe = aHe();
        if (aHe != null) {
            mo34734a(contentResolver, aHe.strPrjURL, 3, true);
            mo34776uk(this.ebQ);
            this.ebQ = -1;
        }
    }

    /* renamed from: i */
    public synchronized int mo34764i(ProjectItem projectItem) {
        if (projectItem == null) {
            return 0;
        }
        if (projectItem.mStoryBoard != null) {
            projectItem.mStoryBoard.unInit();
            projectItem.mStoryBoard = null;
        }
        if (projectItem.mClipModelCacheList != null) {
            projectItem.mClipModelCacheList.releaseAll();
        }
        if (projectItem.mProjectDataItem.strPrjURL != null) {
            this.ebS.remove(projectItem.mProjectDataItem.strPrjURL);
            this.efE.remove(projectItem.mProjectDataItem.strPrjURL);
        }
        projectItem.setCacheFlag(-1, false);
        return 0;
    }

    /* renamed from: i */
    public boolean mo34765i(VeMSize veMSize) {
        if (veMSize != null) {
            DataItemProject aHe = aHe();
            if (aHe != null) {
                aHe.streamWidth = veMSize.width;
                aHe.streamHeight = veMSize.height;
                C8540q.m24935a(aHd(), veMSize);
                aHc();
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002e, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void init(android.content.Context r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r0 = r1.bce     // Catch:{ all -> 0x002f }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r1)
            return
        L_0x0007:
            r0 = 1
            r1.bce = r0     // Catch:{ all -> 0x002f }
            android.content.Context r2 = r2.getApplicationContext()     // Catch:{ all -> 0x002f }
            r1.mContext = r2     // Catch:{ all -> 0x002f }
            java.util.List r2 = r1.ebR     // Catch:{ all -> 0x002f }
            if (r2 != 0) goto L_0x001b
            java.util.concurrent.CopyOnWriteArrayList r2 = new java.util.concurrent.CopyOnWriteArrayList     // Catch:{ all -> 0x002f }
            r2.<init>()     // Catch:{ all -> 0x002f }
            r1.ebR = r2     // Catch:{ all -> 0x002f }
        L_0x001b:
            android.os.HandlerThread r2 = r1.ebT     // Catch:{ all -> 0x002f }
            if (r2 != 0) goto L_0x002d
            android.os.HandlerThread r2 = new android.os.HandlerThread     // Catch:{ all -> 0x002f }
            java.lang.String r0 = "ProjectMgr"
            r2.<init>(r0)     // Catch:{ all -> 0x002f }
            r1.ebT = r2     // Catch:{ all -> 0x002f }
            android.os.HandlerThread r2 = r1.ebT     // Catch:{ all -> 0x002f }
            r2.start()     // Catch:{ all -> 0x002f }
        L_0x002d:
            monitor-exit(r1)
            return
        L_0x002f:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.sdk.utils.p394b.C8522g.init(android.content.Context):void");
    }

    /* renamed from: jv */
    public boolean mo34767jv(boolean z) {
        VeMSize jw = m24678jw(z);
        if (jw != null) {
            DataItemProject aHe = aHe();
            if (aHe != null) {
                if (!(jw.width == aHe.streamWidth && jw.height == aHe.streamHeight)) {
                    aHe.streamWidth = jw.width;
                    aHe.streamHeight = jw.height;
                    C8540q.m24935a(aHd(), new VeMSize(aHe.streamWidth, aHe.streamHeight));
                    aHc();
                }
                return true;
            }
        }
        return false;
    }

    /* renamed from: nN */
    public synchronized int mo34768nN(String str) {
        boolean z;
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        int count = getCount();
        ProjectItem projectItem = null;
        int i = 0;
        while (true) {
            if (i >= count) {
                z = false;
                break;
            }
            projectItem = mo34778uz(i);
            if (projectItem != null && projectItem.mProjectDataItem.strPrjURL.equals(str)) {
                z = true;
                break;
            }
            i++;
        }
        if (!z) {
            return 0;
        }
        mo34764i(projectItem);
        return 0;
    }

    /* renamed from: nO */
    public void mo34769nO(String str) {
        ProjectItem ahP = aHf();
        if (ahP != null) {
            DataItemProject dataItemProject = ahP.mProjectDataItem;
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
                    sb3.append(".dat");
                    String sb4 = sb3.toString();
                    if (C8548e.isFileExisted(sb4)) {
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append(parent);
                        sb5.append("/");
                        sb5.append(fileName);
                        sb5.append(".dat");
                        sb5.append(str);
                        String sb6 = sb5.toString();
                        if (C8548e.isFileExisted(sb6)) {
                            C8548e.deleteFile(sb6);
                        }
                        C8548e.copyFile(sb4, sb6);
                    }
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
            if (TextUtils.equals(str, ((ProjectItem) this.ebR.get(i)).mProjectDataItem.strPrjURL)) {
                return i;
            }
        }
        return -1;
    }

    /* renamed from: oC */
    public ProjectItem mo34770oC(String str) {
        if (this.ebR != null && this.ebR.size() > 0) {
            for (int i = 0; i < this.ebR.size(); i++) {
                ProjectItem projectItem = (ProjectItem) this.ebR.get(i);
                if (projectItem.mProjectDataItem != null && str.equals(projectItem.mProjectDataItem.strPrjURL)) {
                    return projectItem;
                }
            }
        }
        return null;
    }

    /* renamed from: oD */
    public boolean mo34771oD(String str) {
        if (TextUtils.isEmpty(str) || this.mContext == null) {
            return false;
        }
        long nA = C8402a.m24228nA(str);
        if (!C8548e.isFileExisted(str)) {
            C8403b.m24232bb(nA);
        }
        boolean z = true;
        if (nA >= 0) {
            if (C8403b.m24229aZ(nA) > 0) {
                z = false;
            } else if (str.startsWith(C8401d.and())) {
                C8548e.deleteFile(str);
                C8402a.m24226aY(nA);
                if (!str.contains(".media/")) {
                    mo33887ck(this.mContext, str);
                }
            }
        } else if (str.startsWith(C8401d.and())) {
            C8548e.deleteFile(str);
            if (!str.contains(".media/")) {
                mo33887ck(this.mContext, str);
            }
        }
        return z;
    }

    /* renamed from: oE */
    public boolean mo34772oE(String str) {
        ProjectItem ahP = aHf();
        if (ahP != null) {
            DataItemProject dataItemProject = ahP.mProjectDataItem;
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
                    return !C8548e.m24996aT(str2, sb.toString());
                }
            }
        }
        return false;
    }

    /* renamed from: oF */
    public boolean mo34773oF(String str) {
        return mo34758ba(str, ".backup");
    }

    /* renamed from: oG */
    public void mo34774oG(String str) {
        mo34759bb(str, ".backup");
    }

    /* renamed from: oH */
    public void mo34775oH(String str) {
        DataItemProject aHe = aHe();
        if (aHe != null) {
            String str2 = aHe.strPrjURL;
            if (!TextUtils.isEmpty(str2)) {
                mo34759bb(str2, str);
            }
        }
    }

    /* renamed from: tz */
    public DataItemProject mo33891tz(int i) {
        ProjectItem uz = mo34778uz(i);
        if (uz == null) {
            return null;
        }
        return uz.mProjectDataItem;
    }

    /* renamed from: uk */
    public synchronized void mo34776uk(int i) {
        if (this.ebR != null && i >= 0 && i < this.ebR.size()) {
            ProjectItem projectItem = (ProjectItem) this.ebR.remove(i);
            if (projectItem != null) {
                projectItem.release();
            }
        }
    }

    public synchronized void uninit() {
        this.bce = false;
        if (this.ebT != null) {
            this.ebT.quit();
            this.ebT = null;
        }
        aIU();
        this.efJ = false;
        this.ebQ = -1;
        this.efJ = false;
    }

    /* renamed from: uz */
    public ProjectItem mo34778uz(int i) {
        if (this.ebR != null && i < this.ebR.size() && i >= 0) {
            return (ProjectItem) this.ebR.get(i);
        }
        return null;
    }
}
