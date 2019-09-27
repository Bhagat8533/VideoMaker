package com.introvd.template.editor;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.hardware.Camera.Size;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.aiii.android.arouter.facade.p094a.C1942a;
import com.introvd.template.common.CpuFeatures;
import com.introvd.template.common.ExAsyncTask;
import com.introvd.template.common.FileUtils;
import com.introvd.template.common.LogUtils;
import com.introvd.template.common.MSize;
import com.introvd.template.common.MagicCode;
import com.introvd.template.common.MediaFileUtils;
import com.introvd.template.common.ToastUtils;
import com.introvd.template.common.UserBehaviorLog;
import com.introvd.template.common.Utils;
import com.introvd.template.common.model.AppStateModel;
import com.introvd.template.p242d.C5530d;
import com.introvd.template.router.BizServiceManager;
import com.introvd.template.router.common.CommonParams;
import com.introvd.template.router.editor.EditorRouter;
import com.introvd.template.router.editor.IEditorService;
import com.introvd.template.router.editor.gallery.GalleryRouter;
import com.introvd.template.sdk.model.editor.DataItemProject;
import com.introvd.template.sdk.p381b.C8393c;
import com.introvd.template.sdk.utils.C8545d;
import com.introvd.template.sdk.utils.C8572y;
import com.introvd.template.sdk.utils.VeMSize;
import com.introvd.template.sdk.utils.p394b.C8501a;
import com.introvd.template.sdk.utils.p394b.C8522g;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import xiaoying.engine.base.QUtils;

@C1942a(mo10417rZ = "/XYVideoEditor/PreLoad")
public class XiaoYingPreLoadActivity extends Activity {
    private static int csc = 640;
    private static int csd = 480;
    private MSize bLU = new MSize(csc, csd);
    private long bMw;
    /* access modifiers changed from: private */
    public C8501a bOK = null;
    private boolean cse = false;
    private ArrayList<Uri> csf;
    private Uri[] csg;
    /* access modifiers changed from: private */
    public String csh = "";
    /* access modifiers changed from: private */
    public C8522g csi;
    /* access modifiers changed from: private */
    public int csj;
    /* access modifiers changed from: private */
    public C5530d csk;
    /* access modifiers changed from: private */
    public C5551c csl = new C5551c(this);
    private boolean csm = false;
    /* access modifiers changed from: private */
    public ArrayList<String> mPathList = new ArrayList<>();

    /* renamed from: com.introvd.template.editor.XiaoYingPreLoadActivity$a */
    class C5549a extends ExAsyncTask<Void, Void, Boolean> {
        C5549a() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Boolean doInBackground(Void... voidArr) {
            if (XiaoYingPreLoadActivity.this.csi == null) {
                XiaoYingPreLoadActivity.this.csi = C8522g.aJA();
                if (XiaoYingPreLoadActivity.this.csi == null) {
                    return Boolean.valueOf(false);
                }
            }
            boolean z = XiaoYingPreLoadActivity.this.csk.cnX == 2;
            IEditorService iEditorService = (IEditorService) BizServiceManager.getService(IEditorService.class);
            String[] strArr = {"", ""};
            if (iEditorService != null) {
                strArr = iEditorService.getCommonBehaviorParam();
            }
            XiaoYingPreLoadActivity.this.csi.mo34756b(XiaoYingPreLoadActivity.this.getApplicationContext(), XiaoYingPreLoadActivity.this.csl, z, strArr[0], strArr[1]);
            return Boolean.valueOf(true);
        }

        /* access modifiers changed from: protected */
        /* renamed from: r */
        public void onPostExecute(Boolean bool) {
        }
    }

    /* renamed from: com.introvd.template.editor.XiaoYingPreLoadActivity$b */
    class C5550b extends ExAsyncTask<Void, Void, Boolean> {
        C5550b() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Boolean doInBackground(Void... voidArr) {
            boolean z = false;
            if (XiaoYingPreLoadActivity.this.mPathList != null && XiaoYingPreLoadActivity.this.mPathList.size() > 0) {
                Iterator it = XiaoYingPreLoadActivity.this.mPathList.iterator();
                int i = 0;
                while (it.hasNext()) {
                    if (mo27346k(i, (String) it.next())) {
                        i++;
                        z = true;
                    }
                }
            }
            return Boolean.valueOf(z);
        }

        /* renamed from: k */
        public boolean mo27346k(int i, String str) {
            if (!TextUtils.isEmpty(str)) {
                String e = C8545d.m24986e(str, XiaoYingPreLoadActivity.this.csi.aJH(), true);
                C8522g.m24676iP(e);
                if (!TextUtils.isEmpty(e) && XiaoYingPreLoadActivity.this.csi != null) {
                    XiaoYingPreLoadActivity.this.csi.mo34729a(e, XiaoYingPreLoadActivity.this.bOK, i, true);
                }
            }
            return true;
        }

        /* access modifiers changed from: protected */
        /* renamed from: r */
        public void onPostExecute(Boolean bool) {
            if (bool.booleanValue() && XiaoYingPreLoadActivity.this.csi != null) {
                XiaoYingPreLoadActivity.this.csi.mo34730a(true, XiaoYingPreLoadActivity.this.bOK, (Handler) null, AppStateModel.getInstance().isCommunitySupport(), XiaoYingPreLoadActivity.this.csi.mo34778uz(XiaoYingPreLoadActivity.this.csi.ebQ));
                if (XiaoYingPreLoadActivity.this.csi.aHe() != null && (XiaoYingPreLoadActivity.this.csk == null || XiaoYingPreLoadActivity.this.csk.cnV != 100)) {
                    EditorRouter.launchEditorActivity((Activity) XiaoYingPreLoadActivity.this, new Object[0]);
                }
            }
            XiaoYingPreLoadActivity.this.finish();
        }
    }

    /* renamed from: com.introvd.template.editor.XiaoYingPreLoadActivity$c */
    static class C5551c extends Handler {
        private WeakReference<XiaoYingPreLoadActivity> bwg;

        public C5551c(XiaoYingPreLoadActivity xiaoYingPreLoadActivity) {
            this.bwg = new WeakReference<>(xiaoYingPreLoadActivity);
        }

        public void handleMessage(Message message) {
            XiaoYingPreLoadActivity xiaoYingPreLoadActivity = (XiaoYingPreLoadActivity) this.bwg.get();
            if (xiaoYingPreLoadActivity != null) {
                switch (message.what) {
                    case 268443649:
                        if (xiaoYingPreLoadActivity.csj != 12 && xiaoYingPreLoadActivity.csj != 13) {
                            if (xiaoYingPreLoadActivity.csj == 14) {
                                LogUtils.m14223i("VeMultiImage", "MSG_PROJECT_LOAD_FAILED");
                                VeMSize aJq = C8572y.aJq();
                                if (xiaoYingPreLoadActivity.csi != null) {
                                    DataItemProject aHe = xiaoYingPreLoadActivity.csi.aHe();
                                    if (aHe != null) {
                                        if (aJq != null) {
                                            aHe.streamWidth = aJq.width;
                                            aHe.streamHeight = aJq.height;
                                        }
                                        aHe.setMVPrjFlag(true);
                                        xiaoYingPreLoadActivity.csi.mo34730a(true, xiaoYingPreLoadActivity.bOK, (Handler) null, AppStateModel.getInstance().isCommunitySupport(), xiaoYingPreLoadActivity.csi.mo34778uz(xiaoYingPreLoadActivity.csi.ebQ));
                                    }
                                }
                                xiaoYingPreLoadActivity.getClass();
                                new C5550b().execute((Params[]) new Void[0]);
                                break;
                            }
                        } else {
                            xiaoYingPreLoadActivity.getClass();
                            new C5552d().execute((Params[]) new Void[0]);
                            break;
                        }
                        break;
                    case 268443657:
                        StringBuilder sb = new StringBuilder();
                        sb.append("MSG_PROJEC  ");
                        sb.append(message.what);
                        LogUtils.m14223i("VeMultiImage", sb.toString());
                        break;
                }
            }
        }
    }

    /* renamed from: com.introvd.template.editor.XiaoYingPreLoadActivity$d */
    class C5552d extends ExAsyncTask<Void, Void, Boolean> {
        C5552d() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Boolean doInBackground(Void... voidArr) {
            C8522g.m24676iP(XiaoYingPreLoadActivity.this.csh);
            boolean z = true;
            if (XiaoYingPreLoadActivity.this.csi.mo34729a(XiaoYingPreLoadActivity.this.csh, XiaoYingPreLoadActivity.this.bOK, 0, true) != 0) {
                z = false;
            }
            return Boolean.valueOf(z);
        }

        /* access modifiers changed from: protected */
        /* renamed from: r */
        public void onPostExecute(Boolean bool) {
            super.onPostExecute(bool);
            if (bool.booleanValue()) {
                XiaoYingPreLoadActivity.this.csi.mo34731a(true, XiaoYingPreLoadActivity.this.bOK, (Handler) null, false, false, AppStateModel.getInstance().isCommunitySupport(), XiaoYingPreLoadActivity.this.csi.mo34778uz(XiaoYingPreLoadActivity.this.csi.ebQ));
                if (!(XiaoYingPreLoadActivity.this.csi.aHe() == null || XiaoYingPreLoadActivity.this.csk == null || XiaoYingPreLoadActivity.this.csk.cnV != 100)) {
                    EditorRouter.launchEditorActivity((Activity) XiaoYingPreLoadActivity.this, new Object[0]);
                }
            }
            XiaoYingPreLoadActivity.this.finish();
        }
    }

    private void abp() {
        int i;
        Size gL = C8393c.m24214gL(getApplicationContext());
        int i2 = 0;
        if (gL != null) {
            i2 = gL.width;
            i = gL.height;
        } else {
            i = 0;
        }
        this.bLU.width = i2;
        this.bLU.height = i;
        abr();
        csc = this.bLU.width;
        csd = this.bLU.height;
    }

    private void abq() {
        Uri[] uriArr;
        if (this.csf != null && this.csf.size() > 0) {
            Iterator it = this.csf.iterator();
            while (it.hasNext()) {
                Uri uri = (Uri) it.next();
                String parseInputUri = Utils.parseInputUri(uri, this, true);
                if (!TextUtils.isEmpty(parseInputUri)) {
                    this.mPathList.add(parseInputUri);
                } else if (!this.csm && !Utils.isSupportedContentUri(uri)) {
                    this.csm = true;
                }
            }
        }
        if (this.csg != null && this.csg.length > 0) {
            for (Uri uri2 : this.csg) {
                String parseInputUri2 = Utils.parseInputUri(uri2, this, true);
                if (!TextUtils.isEmpty(parseInputUri2)) {
                    this.mPathList.add(parseInputUri2);
                } else if (!this.csm && !Utils.isSupportedContentUri(uri2)) {
                    this.csm = true;
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.mPathList.size(); i++) {
            String str = (String) this.mPathList.get(i);
            if (FileUtils.isFileExisted(str)) {
                int GetFileMediaType = MediaFileUtils.GetFileMediaType(str);
                if (!(GetFileMediaType == 301 || GetFileMediaType == 304 || GetFileMediaType == 303)) {
                    arrayList.add(str);
                    this.cse = true;
                }
            }
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            this.mPathList.remove((String) it2.next());
        }
    }

    private void abr() {
        if (this.bLU.width == 0 || this.bLU.height == 0) {
            if (CpuFeatures.isSingleCpu()) {
                this.bLU.width = 320;
                this.bLU.height = 240;
                return;
            }
            this.bLU.width = QUtils.VIDEO_RES_VGA_WIDTH;
            this.bLU.height = 480;
        } else if (this.bLU.width * this.bLU.height >= 691200) {
            this.bLU.width = 960;
            this.bLU.height = QUtils.VIDEO_RES_720P_HEIGHT;
        } else if (this.bLU.width * this.bLU.height >= 307200 && CpuFeatures.isSingleCpu()) {
            this.bLU.width = 320;
            this.bLU.height = 240;
        }
    }

    /* renamed from: s */
    private void m15001s(Intent intent) {
        this.csf = intent.getParcelableArrayListExtra("android.intent.extra.STREAM");
        if (this.csf == null) {
            this.csg = (Uri[]) intent.getParcelableArrayExtra("android.intent.extra.STREAM");
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        this.bMw = getIntent().getLongExtra(CommonParams.INTENT_MAGIC_CODE, 0);
        this.csk = (C5530d) MagicCode.getMagicParam(this.bMw, "AppRunningMode", new C5530d());
        if (this.csk != null && this.csk.cof) {
            setTheme(R.style.Theme_XiaoYingNoSplash);
        }
        if (this.csk != null) {
            this.csj = this.csk.cnU;
        }
        this.bOK = C8501a.aJs();
        this.csi = C8522g.aJA();
        if (this.csi == null) {
            finish();
            return;
        }
        if (this.csj == 14) {
            m15001s(intent);
            if ((this.csg == null || this.csg.length <= 0) && (this.csf == null || this.csf.size() <= 0)) {
                LogUtils.m14223i("VeMultiImage", "VeMultiImage, there is no data input, exit.");
                ToastUtils.show((Context) this, R.string.xiaoying_str_ve_msg_no_jpg_choosed, 1);
                finish();
                return;
            }
            abp();
            setContentView(R.layout.editor_act_preload_layout);
            abq();
            if (this.mPathList.size() <= 0) {
                ToastUtils.show((Context) this, R.string.xiaoying_str_ve_msg_no_jpg_choosed, 1);
                finish();
                return;
            }
            if (this.csm) {
                ToastUtils.show((Context) this, R.string.xiaoying_str_ve_msg_only_support_local_file, 1);
            } else if (this.cse) {
                ToastUtils.show((Context) this, R.string.xiaoying_str_ve_msg_not_all_choosed_jpg, 1);
            }
            if (!C5530d.m14977kn(this.csj)) {
                StringBuilder sb = new StringBuilder();
                sb.append("MagicCode:");
                sb.append(this.bMw);
                LogUtils.m14223i("VeMultiImage", sb.toString());
                new C5549a().execute((Params[]) new Void[0]);
            }
            HashMap hashMap = new HashMap();
            hashMap.put("which", "pics");
            UserBehaviorLog.onKVEvent(getApplicationContext(), "Intent_Launch", hashMap);
        } else if (this.csj == 12 || this.csj == 13) {
            this.csh = intent.getStringExtra(GalleryRouter.INTENT_PATH_KEY);
            if (!FileUtils.isFileExisted(this.csh)) {
                ToastUtils.show((Context) this, R.string.xiaoying_str_ve_clip_add_msg_invalid_file, 1);
                finish();
                return;
            }
            setContentView(R.layout.editor_act_preload_layout);
            new C5549a().execute((Params[]) new Void[0]);
            HashMap hashMap2 = new HashMap();
            hashMap2.put("which", "video");
            UserBehaviorLog.onKVEvent(getApplicationContext(), "Intent_Launch", hashMap2);
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        if (this.csl != null) {
            this.csl.removeCallbacksAndMessages(null);
        }
        this.csl = null;
        this.bOK = null;
        this.csf = null;
        this.csi = null;
        super.onDestroy();
    }
}
