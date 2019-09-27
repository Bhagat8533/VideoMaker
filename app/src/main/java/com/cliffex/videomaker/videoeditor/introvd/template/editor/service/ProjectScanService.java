package com.introvd.template.editor.service;

import android.app.IntentService;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.support.p021v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import com.google.gson.JsonObject;
import com.introvd.template.app.api.C3727b;
import com.introvd.template.channel.C5206b;
import com.introvd.template.common.AppPreferencesSetting;
import com.introvd.template.common.CommonConfigure;
import com.introvd.template.common.FileUtils;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.common.MediaFileUtils;
import com.introvd.template.common.ToastUtils;
import com.introvd.template.common.UserBehaviorLog;
import com.introvd.template.common.XZip;
import com.introvd.template.common.model.AppStateModel;
import com.introvd.template.datacenter.SocialService;
import com.introvd.template.datacenter.social.PublishTaskTable;
import com.introvd.template.editor.R;
import com.introvd.template.editor.p252e.C5878a;
import com.introvd.template.explorer.extract.C7234b;
import com.introvd.template.p173a.C3582b;
import com.introvd.template.p203b.C4580b;
import com.introvd.template.p203b.C4582c;
import com.introvd.template.p374q.C8346e;
import com.introvd.template.router.BizServiceManager;
import com.introvd.template.router.StudioRouter;
import com.introvd.template.router.community.CommunityServiceProxy;
import com.introvd.template.router.community.publish.PublishProjectInfo;
import com.introvd.template.router.editor.IEditorService;
import com.introvd.template.router.user.UserServiceProxy;
import com.introvd.template.sdk.C8410e;
import com.introvd.template.sdk.model.editor.ProjectItem;
import com.introvd.template.sdk.p380a.C8380a;
import com.introvd.template.sdk.p380a.C8381b;
import com.introvd.template.sdk.p384d.C8404c;
import com.introvd.template.sdk.p390f.C8445a;
import com.introvd.template.sdk.p391g.C8450a;
import com.introvd.template.sdk.slide.C8467b;
import com.introvd.template.sdk.slide.C8468c;
import com.introvd.template.sdk.slide.p392a.C8461b.C8465c;
import com.introvd.template.sdk.utils.C8553i;
import com.introvd.template.sdk.utils.C8558m;
import com.introvd.template.sdk.utils.C8567u;
import com.introvd.template.sdk.utils.C8572y;
import com.introvd.template.sdk.utils.VeMSize;
import com.introvd.template.sdk.utils.p394b.C8501a;
import com.introvd.template.sdk.utils.p394b.C8522g;
import com.introvd.template.sdk.utils.p394b.C8540q;
import com.introvd.template.template.p409g.C8762d;
import com.quvideo.rescue.C4905b;
import com.quvideo.rescue.model.LogModel;
import com.quvideo.rescue.p220c.p221a.C4910a;
import com.vivavideo.mobile.h5core.refresh.H5PullHeader;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import xiaoying.engine.QEngine;

public class ProjectScanService extends IntentService {
    /* access modifiers changed from: private */
    public static String deQ = "";
    /* access modifiers changed from: private */
    public C8381b cPm = null;
    /* access modifiers changed from: private */
    public volatile boolean deN = false;
    /* access modifiers changed from: private */
    public volatile boolean deO = false;
    /* access modifiers changed from: private */
    public volatile boolean deP = false;
    private Handler mHandler = null;

    /* renamed from: com.introvd.template.editor.service.ProjectScanService$a */
    private static class C6716a extends Handler {
        private WeakReference<ProjectScanService> deU = null;

        public C6716a(ProjectScanService projectScanService, Looper looper) {
            super(looper);
            this.deU = new WeakReference<>(projectScanService);
        }

        public void handleMessage(Message message) {
            ProjectScanService projectScanService = (ProjectScanService) this.deU.get();
            if (projectScanService != null) {
                int i = message.what;
                if (i != 268443657) {
                    switch (i) {
                        case 268443649:
                            if (!projectScanService.deO) {
                                projectScanService.deN = false;
                                break;
                            } else {
                                C8380a aHf = projectScanService.cPm.aHf();
                                if (aHf != null) {
                                    if ((aHf.getCacheFlag() & 8) == 0) {
                                        if (!projectScanService.cPm.mo33877a((Handler) this, false)) {
                                            projectScanService.m19508gW(false);
                                            projectScanService.deN = false;
                                            break;
                                        }
                                    } else {
                                        sendEmptyMessage(268443657);
                                        break;
                                    }
                                } else {
                                    projectScanService.m19508gW(false);
                                    break;
                                }
                            }
                            break;
                        case 268443650:
                        case 268443651:
                            if (projectScanService.deO) {
                                projectScanService.m19508gW(false);
                            }
                            projectScanService.deN = false;
                            break;
                    }
                } else {
                    projectScanService.m19508gW(true);
                    projectScanService.deN = false;
                }
            }
        }
    }

    /* renamed from: com.introvd.template.editor.service.ProjectScanService$b */
    public static class C6717b implements C8465c {
        private Handler mHandler = null;
        private int mIndex = -1;

        public C6717b(Handler handler, int i) {
            this.mHandler = handler;
            this.mIndex = i;
        }

        /* renamed from: oX */
        private void m19517oX(int i) {
            if (this.mHandler != null) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(i, this.mIndex, 0));
            }
        }

        public void aqF() {
            m19517oX(268443649);
        }

        public void aqG() {
            m19517oX(268443650);
        }

        public void aqH() {
            m19517oX(268443651);
        }
    }

    public ProjectScanService() {
        super("ProjectScanService");
    }

    /* renamed from: a */
    public static void m19493a(Context context, String str, String... strArr) {
        try {
            Intent intent = new Intent(context, ProjectScanService.class);
            intent.setAction("com.introvd.template.services.action.SendErrProjectInfo");
            intent.putExtra("com.introvd.template.services.extra.PARAM1", str);
            intent.putExtra("com.introvd.template.services.extra.PARAM2", strArr);
            C3582b.m8808k(context, intent);
        } catch (Exception unused) {
        }
    }

    /* renamed from: ao */
    private boolean m19497ao(String str, String str2) {
        if (!MediaFileUtils.IsVideoFileType(MediaFileUtils.GetFileMediaType(str))) {
            ToastUtils.show(getApplicationContext(), R.string.xiaoying_str_ve_clip_add_msg_invalid_file, 0);
            return false;
        }
        C8501a aJs = C8501a.aJs();
        if (C8572y.m25084d(str, aJs.aJv()) != 0) {
            return false;
        }
        HandlerThread handlerThread = new HandlerThread("handler_thread");
        handlerThread.start();
        this.mHandler = new C6716a(this, handlerThread.getLooper());
        C8410e.m24270gK(getApplicationContext());
        C8558m.egQ = true;
        if (!TextUtils.isEmpty(str2)) {
            C8558m.egR = str2;
        }
        IEditorService iEditorService = (IEditorService) BizServiceManager.getService(IEditorService.class);
        String[] strArr = {"", ""};
        if (iEditorService != null) {
            strArr = iEditorService.getCommonBehaviorParam();
        }
        C8522g.aJA().mo34735a(getApplicationContext(), this.mHandler, C8558m.m25018aV(C8558m.m25036v(C8558m.aJh(), strArr[0], strArr[1]), "prj_reshare_flag"));
        this.deN = true;
        while (this.deN) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        handlerThread.quit();
        if (!(C8522g.aJA().mo34729a(str, aJs, 0, false) == 0)) {
            return false;
        }
        C8522g.aJA().mo34730a(false, aJs, (Handler) null, true, C8522g.aJA().mo34778uz(C8522g.aJA().ebQ));
        return true;
    }

    private void aqD() {
        int i = 0;
        List<C8445a> ao = C8404c.m24234ao(0, true);
        List<String> aHi = C8381b.aHi();
        C8501a aJs = C8501a.aJs();
        if (aJs != null) {
            QEngine aJv = aJs.aJv();
            for (C8445a aVar : ao) {
                aHi.remove(aVar.strPrjURL);
            }
            if (aHi != null && aHi.size() > 0) {
                HandlerThread handlerThread = new HandlerThread("handler_thread");
                handlerThread.start();
                this.mHandler = new C6716a(this, handlerThread.getLooper());
                for (String str : aHi) {
                    if (!TextUtils.isEmpty(str) && !str.endsWith("_storyboard.prj")) {
                        ProjectItem projectItem = new ProjectItem(C8381b.m24131O(getApplicationContext(), str, H5PullHeader.TIME_FORMAT), null);
                        if (C8522g.m24662a(getApplicationContext(), projectItem, aJv, this.mHandler) == 0) {
                            this.deN = true;
                            while (this.deN) {
                                try {
                                    Thread.sleep(50);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                            if (!this.deN && projectItem.mStoryBoard != null && projectItem.mStoryBoard.getClipCount() > 0) {
                                boolean bl = C8450a.m24467bl(C8540q.m24894C(projectItem.mStoryBoard).longValue());
                                VeMSize c = C8522g.m24672c(projectItem.mStoryBoard, AppStateModel.getInstance().isCommunitySupport());
                                projectItem.mProjectDataItem.streamWidth = c.width;
                                projectItem.mProjectDataItem.streamHeight = c.height;
                                projectItem.mProjectDataItem.iPrjClipCount = projectItem.mStoryBoard.getClipCount();
                                projectItem.mProjectDataItem.iPrjDuration = projectItem.mStoryBoard.getDuration();
                                Date date = new Date();
                                File file = new File(str);
                                if (file.exists()) {
                                    date = new Date(file.lastModified());
                                }
                                projectItem.mProjectDataItem.strModifyTime = C8381b.m24132a(getApplicationContext(), date, H5PullHeader.TIME_FORMAT);
                                projectItem.mProjectDataItem.setMVPrjFlag(bl);
                                projectItem.mProjectDataItem._id = C8404c.m24239c(projectItem.mProjectDataItem);
                                if (CommunityServiceProxy.getPublishProjectInfoByPrjId(projectItem.mProjectDataItem._id) == null) {
                                    PublishProjectInfo publishProjectInfo = new PublishProjectInfo();
                                    publishProjectInfo.prjId = projectItem.mProjectDataItem._id;
                                    CommunityServiceProxy.updatePublishProjectInfo(publishProjectInfo);
                                }
                                i++;
                            }
                        }
                    }
                }
                handlerThread.quit();
            }
            Intent intent = new Intent(StudioRouter.LOCAL_ACTION_SCAN_PROJECT_FINISH);
            intent.putExtra(StudioRouter.LOCAL_ACTION_SCAN_PROJECT_FINISH_INTENT_RESULT, i);
            LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(intent);
        }
    }

    private void aqE() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("file_upload_suc");
        intentFilter.addAction("file_upload_fail");
        LocalBroadcastManager.getInstance(getApplicationContext()).registerReceiver(new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {
                int intExtra = intent.getIntExtra("param_type", 0);
                String stringExtra = intent.getStringExtra("param_url");
                C4905b.m12541a(new LogModel().withLogLevel(LogModel.LEVEL_DEBUG).withTag("uploadCallbackDemo").withMessage("callback is run type=%d,url=%s", Integer.valueOf(intExtra), stringExtra));
                StringBuilder sb = new StringBuilder();
                sb.append("url=");
                sb.append(stringExtra);
                LogUtilsV2.m14228e(sb.toString());
                if ("file_upload_suc".equals(intent.getAction())) {
                    ProjectScanService.this.m19503c(context, intExtra, stringExtra);
                }
                HashMap hashMap = new HashMap();
                hashMap.put(PublishTaskTable.PARAM_PUBLISH_TASK_PROJECT_URL, stringExtra);
                hashMap.put("duid", C4580b.m11653dz(context));
                UserBehaviorLog.onKVEvent(context, "Dev_Event_Project_Upload_Suc", hashMap);
                ProjectScanService.this.deP = false;
                LocalBroadcastManager.getInstance(ProjectScanService.this.getApplicationContext()).unregisterReceiver(this);
            }
        }, intentFilter);
    }

    /* renamed from: b */
    private static void m19499b(Context context, String str, String[] strArr) {
        if (context != null && !TextUtils.isEmpty(str)) {
            final String parent = new File(str).getParent();
            final String fileName = FileUtils.getFileName(str);
            final String str2 = str;
            final String[] strArr2 = strArr;
            final Context context2 = context;
            C67131 r1 = new C4910a() {
                /* renamed from: F */
                public void mo23043F(String str, String str2) {
                    String[] strArr;
                    try {
                        ProjectScanService.deQ = str2;
                        StringBuilder sb = new StringBuilder();
                        sb.append(parent);
                        sb.append(File.separator);
                        sb.append(fileName);
                        sb.append(".zip");
                        String sb2 = sb.toString();
                        if (FileUtils.isFileExisted(sb2)) {
                            FileUtils.deleteFile(sb2);
                        }
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(str2);
                        if (!TextUtils.isEmpty(str) && new File(str).exists()) {
                            arrayList.add(str);
                        }
                        for (String str3 : strArr2) {
                            long fileSize = FileUtils.fileSize(str3);
                            if (fileSize > 0 && fileSize < 10485760) {
                                arrayList.add(str3);
                            }
                        }
                        String[] strArr2 = new String[arrayList.size()];
                        arrayList.toArray(strArr2);
                        XZip.zipFiles(sb2, strArr2);
                        C8346e.m24074c(context2.getApplicationContext(), sb2, 9, CommonConfigure.APP_CACHE_PATH);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                /* renamed from: Fk */
                public void mo23044Fk() {
                }
            };
            C4905b.m12540a((C4910a) r1);
        }
    }

    /* renamed from: bH */
    public static void m19501bH(Context context, String str) {
        Intent intent = new Intent(context, ProjectScanService.class);
        intent.setAction("com.introvd.template.services.action.LoadProject");
        intent.putExtra("com.introvd.template.services.extra.PARAM2", str);
        C3582b.m8808k(context, intent);
    }

    /* renamed from: bI */
    private static void m19502bI(final Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(File.separator);
            sb.append("videouploadErrlog.zip");
            final String sb2 = sb.toString();
            if (FileUtils.isFileExisted(sb2)) {
                FileUtils.deleteFile(sb2);
            }
            C4905b.m12540a((C4910a) new C4910a() {
                /* renamed from: F */
                public void mo23043F(String str, String str2) {
                    try {
                        ProjectScanService.deQ = str2;
                        if (TextUtils.isEmpty(str) || !new File(str).exists()) {
                            XZip.zipFiles(sb2, new String[0]);
                        } else {
                            XZip.zipFiles(sb2, str);
                        }
                        C8346e.m24074c(context.getApplicationContext(), sb2, 10, CommonConfigure.APP_CACHE_PATH);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                /* renamed from: Fk */
                public void mo23044Fk() {
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m19503c(Context context, int i, String str) {
        if (i == 9) {
            C3727b.m9077A(m19505d(context, i, str));
            C4905b.m12538Fd();
        } else if (i == 10) {
            C3727b.m9077A(m19505d(context, i, str));
            String dE = C4582c.m11668dE(getApplicationContext());
            FileUtils.deleteFolderSubFiles(dE, null);
            StringBuilder sb = new StringBuilder();
            sb.append(dE);
            sb.append(File.separator);
            sb.append("logger");
            FileUtils.deleteDirectory(sb.toString());
            C4905b.m12538Fd();
        }
    }

    /* renamed from: d */
    private Map<String, String> m19505d(Context context, int i, String str) {
        String userId = UserServiceProxy.getUserId();
        String dz = C4580b.m11653dz(context);
        HashMap hashMap = new HashMap();
        hashMap.put(C5878a.TAG, str);
        String str2 = C7234b.TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(i);
        hashMap.put(str2, sb.toString());
        hashMap.put("c", m19512oW(i));
        if (!TextUtils.isEmpty(userId)) {
            hashMap.put("auid", userId);
        }
        if (!TextUtils.isEmpty(dz)) {
            hashMap.put("duid", dz);
        }
        return hashMap;
    }

    /* renamed from: fl */
    public static void m19506fl(Context context) {
        Intent intent = new Intent(context, ProjectScanService.class);
        intent.setAction("com.introvd.template.services.action.ScanProject");
        C3582b.m8808k(context, intent);
    }

    /* renamed from: fm */
    public static void m19507fm(Context context) {
        try {
            Intent intent = new Intent(context, ProjectScanService.class);
            intent.setAction("com.introvd.template.services.action.ErrlogUpload");
            C3582b.m8808k(context, intent);
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: gW */
    public void m19508gW(boolean z) {
        Intent intent = new Intent("prj_load_callback_action");
        intent.putExtra("prj_load_cb_intent_data_flag", z);
        LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(intent);
    }

    /* renamed from: j */
    public static void m19510j(Context context, String str, boolean z) {
        Intent intent = new Intent(context, ProjectScanService.class);
        intent.setAction("com.introvd.template.services.action.LoadProject");
        intent.putExtra("com.introvd.template.services.extra.PARAM1", z);
        intent.putExtra("com.introvd.template.services.extra.PARAM2", str);
        C3582b.m8808k(context, intent);
    }

    /* renamed from: o */
    private void m19511o(String str, boolean z) {
        C8501a aJs = C8501a.aJs();
        this.cPm = z ? C8468c.aIQ() : C8522g.aJA();
        if (this.cPm == null || aJs == null || TextUtils.isEmpty(str)) {
            m19508gW(false);
            return;
        }
        if (!this.cPm.aHb()) {
            this.cPm.mo33874S(getApplicationContext(), false);
        }
        int nt = this.cPm.mo33889nt(str);
        if (nt < 0) {
            m19508gW(false);
        } else if (this.cPm.mo33891tz(nt) == null) {
            m19508gW(false);
        } else {
            this.cPm.ebQ = nt;
            C8380a aHf = this.cPm.aHf();
            if (aHf == null) {
                m19508gW(false);
                return;
            }
            if (z) {
                if (aHf instanceof C8467b) {
                    C8467b bVar = (C8467b) aHf;
                    C8468c cVar = (C8468c) this.cPm;
                    if (bVar.dfW == null) {
                        cVar.aHg();
                        if ((bVar.getCacheFlag() & 2) == 0) {
                            HandlerThread handlerThread = new HandlerThread("handler_thread");
                            handlerThread.start();
                            this.mHandler = new C6716a(this, handlerThread.getLooper());
                            cVar.mo34605a(getApplicationContext(), aJs, nt, (C8465c) new C6717b(this.mHandler, nt));
                            this.deN = true;
                            while (this.deN) {
                                try {
                                    Thread.sleep(50);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                            handlerThread.quit();
                        } else {
                            m19508gW(true);
                        }
                    } else if (TextUtils.isEmpty(C8762d.aMt().mo35225bB(bVar.dfW.GetTheme()))) {
                        m19508gW(false);
                    } else {
                        m19508gW(true);
                    }
                } else {
                    m19508gW(false);
                }
            } else if ((aHf.getCacheFlag() & 2) == 0) {
                HandlerThread handlerThread2 = new HandlerThread("handler_thread");
                handlerThread2.start();
                this.mHandler = new C6716a(this, handlerThread2.getLooper());
                C8410e.m24270gK(getApplicationContext());
                ((C8522g) this.cPm).mo34738a(aJs, this.mHandler);
                this.deN = true;
                while (this.deN) {
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                }
                handlerThread2.quit();
            } else {
                m19508gW(true);
            }
        }
    }

    /* renamed from: oW */
    private String m19512oW(int i) {
        String dV = C5206b.m14212dV(getApplicationContext());
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("OS", "android");
        jsonObject.addProperty("os_version", VERSION.CODENAME);
        jsonObject.addProperty("appkey", dV);
        jsonObject.addProperty("country", AppStateModel.getInstance().getCountryCode());
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(i);
        jsonObject.addProperty("filetype", sb.toString());
        if (!TextUtils.isEmpty(deQ)) {
            jsonObject.addProperty("failtag", deQ);
        }
        return jsonObject.toString();
    }

    public void onCreate() {
        super.onCreate();
        C8567u.setContext(getApplicationContext());
        C8553i.setContext(getApplicationContext());
    }

    /* access modifiers changed from: protected */
    public void onHandleIntent(Intent intent) {
        if (intent != null) {
            String action = intent.getAction();
            if ("com.introvd.template.services.action.ScanProject".equals(action)) {
                try {
                    aqD();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if ("com.introvd.template.services.action.SendErrProjectInfo".equals(action)) {
                if (!this.deP) {
                    this.deP = true;
                    aqE();
                    m19499b(getApplicationContext(), intent.getStringExtra("com.introvd.template.services.extra.PARAM1"), intent.getStringArrayExtra("com.introvd.template.services.extra.PARAM2"));
                }
            } else if ("com.introvd.template.services.action.LoadProject".equals(action)) {
                this.deO = true;
                m19511o(intent.getStringExtra("com.introvd.template.services.extra.PARAM2"), intent.getBooleanExtra("com.introvd.template.services.extra.PARAM1", false));
                this.deO = false;
            } else if ("com.introvd.template.services.action.ErrlogUpload".equals(action)) {
                if (!this.deP) {
                    this.deP = true;
                    AppPreferencesSetting instance = AppPreferencesSetting.getInstance();
                    if (instance.getAppSettingBoolean(SocialService.PREF_VIDEO_UPLOAD_ERR_KEY, false)) {
                        instance.setAppSettingBoolean(SocialService.PREF_VIDEO_UPLOAD_ERR_KEY, false);
                        aqE();
                        m19502bI(getApplicationContext(), C4582c.m11668dE(getApplicationContext()));
                    }
                }
            } else if ("com.introvd.template.services.action.video_reshare".equals(action)) {
                boolean ao = m19497ao(intent.getStringExtra("com.introvd.template.services.extra.PARAM1"), intent.getStringExtra("com.introvd.template.services.extra.PARAM2"));
                Intent intent2 = new Intent("prj_load_callback_action");
                intent2.putExtra("result", ao);
                intent2.putExtra("callaction", action);
                LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(intent2);
            }
        }
    }
}
