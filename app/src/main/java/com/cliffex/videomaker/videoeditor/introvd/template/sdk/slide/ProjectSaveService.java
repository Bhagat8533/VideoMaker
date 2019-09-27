package com.introvd.template.sdk.slide;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.support.p021v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import com.introvd.template.sdk.editor.cache.TrimedClipItemDataModel;
import com.introvd.template.sdk.model.editor.DataItemProject;
import com.introvd.template.sdk.slide.p392a.C8466c;
import com.introvd.template.sdk.utils.C8553i;
import com.introvd.template.sdk.utils.VeMSize;
import com.introvd.template.sdk.utils.p394b.C8501a;
import com.introvd.template.sdk.utils.p394b.C8540q;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import xiaoying.engine.base.QRange;
import xiaoying.engine.slideshowsession.QSlideShowSession;
import xiaoying.engine.slideshowsession.QSlideShowSession.QImageSourceInfo;
import xiaoying.engine.slideshowsession.QSlideShowSession.QSourceInfoNode;
import xiaoying.engine.slideshowsession.QSlideShowSession.QVideoSourceInfo;

public class ProjectSaveService extends IntentService {
    /* access modifiers changed from: private */
    public C8501a bOK;
    private ArrayList<TrimedClipItemDataModel> dGh;
    /* access modifiers changed from: private */
    public C8468c dfV;
    private HandlerThread ebT = null;
    /* access modifiers changed from: private */
    public C8458a efl;
    /* access modifiers changed from: private */
    public volatile boolean efm = false;
    private int efn = 0;
    private String efo = "";
    /* access modifiers changed from: private */
    public int efp = 0;
    /* access modifiers changed from: private */
    public int efq = 0;
    /* access modifiers changed from: private */
    public boolean efr = false;
    private long efs = 0;
    /* access modifiers changed from: private */
    public boolean eft;
    private String efu;
    private String efv;
    private String efw;

    /* renamed from: com.introvd.template.sdk.slide.ProjectSaveService$a */
    private static class C8458a extends Handler {
        private WeakReference<ProjectSaveService> csX = null;

        public C8458a(ProjectSaveService projectSaveService, Looper looper) {
            super(looper);
            this.csX = new WeakReference<>(projectSaveService);
        }

        public void handleMessage(Message message) {
            ProjectSaveService projectSaveService = (ProjectSaveService) this.csX.get();
            if (projectSaveService != null) {
                int i = message.what;
                if (i != 268443653) {
                    switch (i) {
                        case 268443659:
                            if (projectSaveService.dfV != null) {
                                C8467b aIS = projectSaveService.dfV.aHf();
                                if (aIS != null) {
                                    VeMSize jx = C8540q.m24959jx(projectSaveService.eft);
                                    aIS.mProjectDataItem.streamWidth = jx.width;
                                    aIS.mProjectDataItem.streamHeight = jx.height;
                                    aIS.mProjectDataItem.setMVPrjFlag(false);
                                    projectSaveService.bOK.mo34669jt(true);
                                    if (projectSaveService.dfV.mo34599a(projectSaveService.getApplicationContext(), true, projectSaveService.bOK, projectSaveService.efl, false, projectSaveService.efr) == 0) {
                                        return;
                                    }
                                }
                            }
                            sendEmptyMessage(268443660);
                            break;
                        case 268443660:
                            projectSaveService.mo34587U(projectSaveService.getApplicationContext(), false);
                            projectSaveService.efm = true;
                            break;
                        case 268443661:
                            projectSaveService.mo34587U(projectSaveService.getApplicationContext(), false);
                            projectSaveService.efm = true;
                            break;
                        case 268443662:
                            int i2 = message.arg1;
                            if (i2 >= projectSaveService.efp) {
                                projectSaveService.efp = i2;
                                projectSaveService.mo34588h(projectSaveService.getApplicationContext(), i2, projectSaveService.efq);
                                break;
                            }
                            break;
                        default:
                            projectSaveService.efm = true;
                            break;
                    }
                } else {
                    projectSaveService.mo34587U(projectSaveService.getApplicationContext(), true);
                    projectSaveService.efm = true;
                }
            }
        }
    }

    public ProjectSaveService() {
        super("ProjectSaveService");
    }

    /* renamed from: a */
    private synchronized int m24484a(QSlideShowSession qSlideShowSession) {
        int i;
        this.efq = this.dGh.size();
        i = 1;
        for (int i2 = 0; i2 < this.dGh.size(); i2++) {
            TrimedClipItemDataModel trimedClipItemDataModel = (TrimedClipItemDataModel) this.dGh.get(i2);
            String str = trimedClipItemDataModel.mRawFilePath;
            if (!TextUtils.isEmpty(str)) {
                QSourceInfoNode qSourceInfoNode = new QSourceInfoNode();
                qSourceInfoNode.mstrSourceFile = str;
                qSourceInfoNode.mRotation = trimedClipItemDataModel.mRotate.intValue();
                qSourceInfoNode.mSourceType = C8466c.m24517nT(qSourceInfoNode.mstrSourceFile);
                if (qSourceInfoNode.mSourceType == 1) {
                    QImageSourceInfo qImageSourceInfo = new QImageSourceInfo();
                    qSourceInfoNode.mSourceInfoObj = qImageSourceInfo;
                    qImageSourceInfo.mFaceCenterX = 5000;
                    qImageSourceInfo.mFaceCenterY = 5000;
                    qImageSourceInfo.mbFaceDetected = true;
                } else if (qSourceInfoNode.mSourceType == 2) {
                    QVideoSourceInfo qVideoSourceInfo = new QVideoSourceInfo();
                    qSourceInfoNode.mSourceInfoObj = qVideoSourceInfo;
                    qVideoSourceInfo.mSrcRange = new QRange(0, -1);
                    if (trimedClipItemDataModel.mVeRangeInRawVideo != null) {
                        qVideoSourceInfo.mSrcRange = new QRange(trimedClipItemDataModel.mVeRangeInRawVideo.getmPosition(), trimedClipItemDataModel.mVeRangeInRawVideo.getmTimeLength());
                    }
                }
                i = qSlideShowSession.InsertSource(qSourceInfoNode);
                mo34588h(getApplicationContext(), this.efp, this.efq);
            }
        }
        return i;
    }

    /* renamed from: a */
    public static void m24486a(Context context, boolean z, ArrayList<TrimedClipItemDataModel> arrayList, String str, boolean z2, long j, String str2, String str3, String str4) {
        Intent intent = new Intent(context, ProjectSaveService.class);
        intent.setAction("com.introvd.template.services.action.PRJSAVE");
        intent.putExtra("intent_prj_resolution_vertical", z);
        intent.putParcelableArrayListExtra("datalist_key", arrayList);
        intent.putExtra("intent_reedit_flag", z2);
        intent.putExtra("intent_default_back_cover_title", str2);
        intent.putExtra("intent_default_prj_title", str3);
        intent.putExtra("media_path", str);
        intent.putExtra("intent_prj_theme", j);
        intent.putExtra("intent_prj_extra_info", str4);
        context.startService(intent);
    }

    private void aIP() {
        C8553i.m25005ut(23);
        QSlideShowSession aIT = this.dfV.aIT();
        if (aIT != null) {
            this.efn = aIT.GetSourceCount();
            for (int i = this.efn; i > 0; i--) {
                aIT.RemoveSource(i - 1);
            }
            if (m24484a(aIT) == 0) {
                this.ebT = new HandlerThread("prjstask");
                this.ebT.start();
                C8476e eVar = new C8476e();
                this.efl = new C8458a(this, this.ebT.getLooper());
                DataItemProject aHe = this.dfV.aHe();
                if (aHe != null) {
                    eVar.mo34627a(this.bOK, this.efl, aIT, aHe.strPrjURL, this.efu, this.efv);
                    eVar.mo34628f(C8540q.m24959jx(this.eft));
                    return;
                }
            }
        }
        mo34587U(getApplicationContext(), false);
        this.efm = true;
    }

    /* renamed from: U */
    public void mo34587U(Context context, boolean z) {
        Intent intent = new Intent("slideshow.intent.action.prj.save.finish");
        intent.putExtra("result_key", z);
        LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
    }

    /* renamed from: h */
    public void mo34588h(Context context, int i, int i2) {
        Intent intent = new Intent("slideshow.intent.action.prj.save.progress");
        intent.putExtra("intent_task_progress_key", i);
        intent.putExtra("intent_task_total", i2);
        LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
    }

    /* access modifiers changed from: protected */
    public void onHandleIntent(Intent intent) {
        if (intent != null) {
            if ("com.introvd.template.services.action.PRJSAVE".equals(intent.getAction())) {
                boolean z = true;
                try {
                    this.dfV = C8468c.aIQ();
                    this.bOK = C8501a.aJs();
                    this.eft = intent.getBooleanExtra("intent_prj_resolution_vertical", false);
                    this.dGh = intent.getParcelableArrayListExtra("datalist_key");
                    if (this.dGh == null || this.dGh.size() <= 0) {
                        z = false;
                    }
                    this.efo = intent.getStringExtra("media_path");
                    this.efr = intent.getBooleanExtra("intent_reedit_flag", false);
                    this.efs = intent.getLongExtra("intent_prj_theme", 0);
                    this.efu = intent.getStringExtra("intent_default_back_cover_title");
                    this.efv = intent.getStringExtra("intent_default_prj_title");
                    this.efw = intent.getStringExtra("intent_prj_extra_info");
                    if (z) {
                        aIP();
                        while (!this.efm) {
                            try {
                                Thread.sleep(400);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        try {
                            if (this.ebT != null) {
                                this.ebT.quit();
                                this.ebT = null;
                            }
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    } else {
                        mo34587U(getApplicationContext(), false);
                    }
                } catch (Exception e3) {
                    e3.printStackTrace();
                    mo34587U(getApplicationContext(), false);
                }
            }
        }
    }
}
