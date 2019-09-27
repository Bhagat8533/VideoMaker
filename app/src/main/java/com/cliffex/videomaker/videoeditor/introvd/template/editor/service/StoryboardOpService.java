package com.introvd.template.editor.service;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.p021v4.content.LocalBroadcastManager;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.common.MSize;
import com.introvd.template.common.Utils;
import com.introvd.template.common.model.AppStateModel;
import com.introvd.template.editor.R;
import com.introvd.template.editor.p266h.C6410o;
import com.introvd.template.editor.p266h.C6411p;
import com.introvd.template.p173a.C3582b;
import com.introvd.template.router.community.CommunityServiceProxy;
import com.introvd.template.router.community.publish.PublishProjectInfo;
import com.introvd.template.router.editor.IEditorService;
import com.introvd.template.router.user.UserServiceProxy;
import com.introvd.template.router.user.model.LoginUserInfo;
import com.introvd.template.sdk.editor.p388b.C8427c;
import com.introvd.template.sdk.editor.p388b.C8427c.C8430a;
import com.introvd.template.sdk.model.editor.DataItemClip;
import com.introvd.template.sdk.model.editor.DataItemProject;
import com.introvd.template.sdk.model.editor.ProjectItem;
import com.introvd.template.sdk.utils.C8572y;
import com.introvd.template.sdk.utils.VeMSize;
import com.introvd.template.sdk.utils.p394b.C8501a;
import com.introvd.template.sdk.utils.p394b.C8522g;
import com.introvd.template.sdk.utils.p394b.C8533l.C8535b;
import java.lang.ref.WeakReference;
import java.util.concurrent.CountDownLatch;
import xiaoying.engine.storyboard.QStoryboard;

public class StoryboardOpService extends IntentService {
    /* access modifiers changed from: private */
    public volatile boolean deV = false;
    private C6411p deW = new C6411p() {
        public String aqI() {
            return StoryboardOpService.this.strPrjAddress;
        }

        public DataItemClip aqJ() {
            return null;
        }

        public String getUserName() {
            LoginUserInfo userInfo = UserServiceProxy.getUserInfo();
            if (userInfo == null) {
                return null;
            }
            return userInfo.nickname;
        }
    };
    private C8430a deX = new C8430a() {
        public void aqK() {
            LogUtilsV2.m14230i("onBeforeThemeApply");
        }

        /* renamed from: gX */
        public void mo30193gX(boolean z) {
            StringBuilder sb = new StringBuilder();
            sb.append("onThemeApplySuc");
            sb.append(Thread.currentThread().getName());
            LogUtilsV2.m14230i(sb.toString());
            C8501a.aJs().mo34669jt(true);
            boolean isCommunitySupport = AppStateModel.getInstance().isCommunitySupport();
            C8522g aJA = C8522g.aJA();
            boolean jv = aJA.mo34767jv(isCommunitySupport);
            if (!jv) {
                jv = aJA.mo34723F(true, isCommunitySupport);
            }
            Intent intent = new Intent(IEditorService.RESULT_ACTION_THEME_APPLY_SUC);
            intent.putExtra("IS_RES_MISSED", false);
            intent.putExtra("IS_STREAM_RESOL_UPDATED", jv);
            LocalBroadcastManager.getInstance(StoryboardOpService.this.getApplicationContext()).sendBroadcast(intent);
            if (StoryboardOpService.this.latch != null) {
                StoryboardOpService.this.latch.countDown();
            }
            StoryboardOpService.this.deV = true;
        }

        /* renamed from: oY */
        public void mo30194oY(int i) {
            LogUtilsV2.m14230i("onThemeApplyFail");
            Intent intent = new Intent(IEditorService.RESULT_ACTION_THEME_APPLY_FAIL);
            intent.putExtra("FAIL_RESULT_CODE", i);
            LocalBroadcastManager.getInstance(StoryboardOpService.this.getApplicationContext()).sendBroadcast(intent);
            if (StoryboardOpService.this.latch != null) {
                StoryboardOpService.this.latch.countDown();
            }
            StoryboardOpService.this.deV = true;
        }
    };
    /* access modifiers changed from: private */
    public CountDownLatch latch;
    /* access modifiers changed from: private */
    public String strPrjAddress;

    /* renamed from: com.introvd.template.editor.service.StoryboardOpService$a */
    private static class C6720a extends Handler {
        WeakReference<StoryboardOpService> deZ;

        public C6720a(StoryboardOpService storyboardOpService) {
            super(Utils.getHandlerThreadFromCommon().getLooper());
            this.deZ = new WeakReference<>(storyboardOpService);
        }

        public void handleMessage(Message message) {
            LogUtilsV2.m14230i("ProjectSaveHandler handleMessage in");
            StoryboardOpService storyboardOpService = (StoryboardOpService) this.deZ.get();
            if (storyboardOpService != null) {
                C8501a aJs = C8501a.aJs();
                if (aJs != null) {
                    aJs.mo34669jt(false);
                }
                storyboardOpService.deV = true;
            }
        }
    }

    public StoryboardOpService() {
        super("StoryboardOpService");
    }

    /* renamed from: a */
    private static boolean m19519a(Context context, MSize mSize, QStoryboard qStoryboard, String str, String str2, C6411p pVar, C8430a aVar) {
        C8427c cVar = new C8427c(qStoryboard, new VeMSize(mSize.width, mSize.height));
        C6410o oVar = new C6410o(context.getString(R.string.xiaoying_str_ve_default_back_cover_text), context.getString(R.string.xiaoying_str_ve_prj_info_location_unknow), context.getString(R.string.xiaoying_str_ve_default_nick_name));
        oVar.mo29459a(pVar);
        cVar.mo34161a((C8535b) oVar);
        cVar.mo34162aS(C8572y.m25101oy(str2), context.getString(R.string.xiaoying_str_ve_default_prj_title_text));
        cVar.mo34160a(aVar);
        return cVar.mo34163nI(str);
    }

    /* renamed from: ap */
    private boolean m19521ap(String str, String str2) {
        C8522g aJA = C8522g.aJA();
        ProjectItem oC = aJA.mo34770oC(str);
        QStoryboard aHd = aJA.aHd();
        if (oC == null || oC.mProjectDataItem == null) {
            return false;
        }
        DataItemProject dataItemProject = oC.mProjectDataItem;
        PublishProjectInfo publishProjectInfoByPrjId = CommunityServiceProxy.getPublishProjectInfoByPrjId(dataItemProject._id);
        if (publishProjectInfoByPrjId != null) {
            this.strPrjAddress = publishProjectInfoByPrjId.strPrjAddress;
        }
        MSize mSize = new MSize(dataItemProject.streamWidth, dataItemProject.streamHeight);
        if (mSize.width < mSize.height) {
            VeMSize aJp = C8572y.aJp();
            mSize.width = aJp.width;
            mSize.height = aJp.height;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("applyTheme ");
        sb.append(Thread.currentThread().getName());
        LogUtilsV2.m14228e(sb.toString());
        return m19519a(getApplicationContext(), mSize, aHd, str2, str, this.deW, this.deX);
    }

    public static void applyTheme(Context context, String str, String str2) {
        Intent intent = new Intent("com.introvd.template.services.action.APPLYTHEME");
        intent.setPackage(context.getPackageName());
        intent.putExtra("com.introvd.template.services.extra.PRJPATH", str);
        intent.putExtra("com.introvd.template.services.extra.XYTPATH", str2);
        C3582b.m8808k(context, intent);
    }

    public static void savePrj(Context context, String str) {
        Intent intent = new Intent("com.introvd.template.services.action.SAVEPRJ");
        intent.setPackage(context.getPackageName());
        intent.putExtra("com.introvd.template.services.extra.PRJPATH", str);
        C3582b.m8808k(context, intent);
    }

    public void onCreate() {
        super.onCreate();
        StringBuilder sb = new StringBuilder();
        sb.append("onCreate in");
        sb.append(Thread.currentThread().getName());
        LogUtilsV2.m14230i(sb.toString());
    }

    /* access modifiers changed from: protected */
    public void onHandleIntent(Intent intent) {
        if (intent != null) {
            String action = intent.getAction();
            String stringExtra = intent.getStringExtra("com.introvd.template.services.extra.PRJPATH");
            if ("com.introvd.template.services.action.APPLYTHEME".equals(action)) {
                this.latch = new CountDownLatch(1);
                this.deV = !m19521ap(stringExtra, intent.getStringExtra("com.introvd.template.services.extra.XYTPATH"));
                if (this.deV) {
                    LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(new Intent(IEditorService.RESULT_ACTION_THEME_APPLY_FAIL));
                    return;
                }
                try {
                    this.latch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                this.latch = null;
                LogUtilsV2.m14230i("ACTION_APPLY_THEME done");
            } else if ("com.introvd.template.services.action.SAVEPRJ".equals(action)) {
                C8501a aJs = C8501a.aJs();
                if (aJs != null && aJs.isProjectModified()) {
                    LogUtilsV2.m14230i("defaultSaveProject in");
                    this.deV = false;
                    boolean isCommunitySupport = AppStateModel.getInstance().isCommunitySupport();
                    C8522g aJA = C8522g.aJA();
                    int a = aJA.mo34730a(true, aJs, (Handler) new C6720a(this), isCommunitySupport, aJA.mo34770oC(stringExtra));
                    StringBuilder sb = new StringBuilder();
                    sb.append("defaultSaveProject out");
                    sb.append(a);
                    LogUtilsV2.m14230i(sb.toString());
                    if (a != 0) {
                        this.deV = true;
                        return;
                    }
                    while (!this.deV) {
                        try {
                            Thread.sleep(30);
                        } catch (InterruptedException e2) {
                            e2.printStackTrace();
                        }
                    }
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("defaultSaveProject exit ");
                    sb2.append(a);
                    LogUtilsV2.m14230i(sb2.toString());
                }
            }
        }
    }

    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
        StringBuilder sb = new StringBuilder();
        sb.append("onStart in");
        sb.append(Thread.currentThread().getName());
        LogUtilsV2.m14230i(sb.toString());
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        StringBuilder sb = new StringBuilder();
        sb.append("onStartCommand in ");
        sb.append(Thread.currentThread().getName());
        LogUtilsV2.m14230i(sb.toString());
        return super.onStartCommand(intent, i, i2);
    }
}
