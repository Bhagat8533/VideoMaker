package com.introvd.template.editor.export;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.p021v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.afollestad.materialdialogs.C1885b;
import com.afollestad.materialdialogs.C1890f;
import com.afollestad.materialdialogs.C1890f.C1904j;
import com.aiii.android.arouter.facade.C1941a;
import com.aiii.android.arouter.facade.p094a.C1942a;
import com.introvd.template.EventActivity;
import com.introvd.template.common.AppPreferencesSetting;
import com.introvd.template.common.FileUtils;
import com.introvd.template.common.LogUtils;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.common.MSize;
import com.introvd.template.common.UserBehaviorLog;
import com.introvd.template.common.model.AppStateModel;
import com.introvd.template.common.other.WeakHandler;
import com.introvd.template.editor.R;
import com.introvd.template.editor.p244a.C5555c;
import com.introvd.template.editor.p266h.C6397i;
import com.introvd.template.editor.service.StoryboardOpService;
import com.introvd.template.p414ui.dialog.C8978m;
import com.introvd.template.router.VivaRouter;
import com.introvd.template.router.community.PublishParams.XYActivityPublishActivityParam;
import com.introvd.template.router.editor.IEditorService;
import com.introvd.template.router.todoCode.TODOParamModel;
import com.introvd.template.router.todoCode.TodoConstants;
import com.introvd.template.sdk.model.editor.DataItemProject;
import com.introvd.template.sdk.model.editor.EffectInfoModel;
import com.introvd.template.sdk.model.editor.ProjectItem;
import com.introvd.template.sdk.model.editor.VideoExportParamsModel;
import com.introvd.template.sdk.p383c.C8399c;
import com.introvd.template.sdk.p384d.C8404c;
import com.introvd.template.sdk.utils.C8481a;
import com.introvd.template.sdk.utils.C8555k;
import com.introvd.template.sdk.utils.C8572y;
import com.introvd.template.sdk.utils.p394b.C8501a;
import com.introvd.template.sdk.utils.p394b.C8522g;
import com.introvd.template.sdk.utils.p394b.C8540q;
import com.introvd.template.sdk.utils.p394b.C8541r;
import com.introvd.template.sdk.utils.p394b.p395a.C8508c;
import com.introvd.template.sdk.utils.p394b.p395a.C8509d;
import com.introvd.template.sdk.utils.p394b.p395a.C8512f;
import com.introvd.template.template.p409g.C8762d;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import xiaoying.engine.base.QRange;
import xiaoying.engine.storyboard.QStoryboard;

@C1942a(mo10417rZ = "/Fuction/video_export")
public class PrjExportVideoActivity extends EventActivity implements OnClickListener {
    /* access modifiers changed from: private */
    public C8522g bMM = null;
    /* access modifiers changed from: private */
    public C8501a bOK = null;
    private DataItemProject cQk;
    /* access modifiers changed from: private */
    public int cQl = 0;
    private String cQm = "";
    /* access modifiers changed from: private */
    public int cQn = 0;
    /* access modifiers changed from: private */
    public TextView cQo;
    private C8509d cQp = null;
    /* access modifiers changed from: private */
    public C6225a cQq = new C6225a(this);
    /* access modifiers changed from: private */
    public List<String> cQr = new ArrayList();
    /* access modifiers changed from: private */
    public Long cQs = Long.valueOf(0);
    private C1890f cQt = null;
    C8512f cQu = new C8512f() {
        public void ama() {
            LogUtils.m14223i("PrjectExportVideoActivity", "onCancelExport");
            PrjExportVideoActivity.this.bMM.mo33876a(PrjExportVideoActivity.this.bMM.aHe(), AppStateModel.getInstance().isCommunitySupport());
            PrjExportVideoActivity.this.cQq.sendMessage(PrjExportVideoActivity.this.cQq.obtainMessage(TodoConstants.TODO_TYPE_H5_FOLLOW));
        }

        public void amb() {
            LogUtils.m14222e("PrjectExportVideoActivity", "onProducerReleased");
        }

        /* renamed from: av */
        public void mo29115av(float f) {
            int i = (int) f;
            StringBuilder sb = new StringBuilder();
            sb.append("onExportRunning nPercent=");
            sb.append(i);
            LogUtils.m14222e("PrjectExportVideoActivity", sb.toString());
            if (PrjExportVideoActivity.this.cQl == 1) {
                i = i > 0 ? (i * 3) / 10 : 0;
            } else if (PrjExportVideoActivity.this.cQl == 2) {
                i = ((i * 19) / 20) + 5;
            }
            TextView e = PrjExportVideoActivity.this.cQo;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(i);
            sb2.append("%");
            e.setText(sb2.toString());
        }

        /* renamed from: hM */
        public void mo29116hM(String str) {
            StringBuilder sb = new StringBuilder();
            sb.append("onExportSuccess video_fullPath=");
            sb.append(str);
            LogUtils.m14222e("PrjectExportVideoActivity", sb.toString());
            C8481a.m24576av(PrjExportVideoActivity.this.getApplicationContext(), str);
            if (PrjExportVideoActivity.this.bOK != null) {
                C8481a.m24575a(PrjExportVideoActivity.this.getApplicationContext(), str, C8541r.m24979e(PrjExportVideoActivity.this.bOK.aJv(), str));
            }
            PrjExportVideoActivity.this.bMM.mo33876a(PrjExportVideoActivity.this.bMM.aHe(), AppStateModel.getInstance().isCommunitySupport());
            if (PrjExportVideoActivity.this.cQq != null) {
                Message obtainMessage = PrjExportVideoActivity.this.cQq.obtainMessage(TodoConstants.TODO_TYPE_QA_TEST);
                obtainMessage.obj = str;
                PrjExportVideoActivity.this.cQq.sendMessageDelayed(obtainMessage, 300);
            }
            if (PrjExportVideoActivity.this.cQl == 1) {
                PrjExportVideoActivity.this.cQr.add(str);
            }
        }

        /* renamed from: n */
        public void mo29117n(int i, String str) {
            StringBuilder sb = new StringBuilder();
            sb.append("onExportFailed nErrCode=");
            sb.append(i);
            LogUtils.m14222e("PrjectExportVideoActivity", sb.toString());
            PrjExportVideoActivity.this.bMM.mo33876a(PrjExportVideoActivity.this.bMM.aHe(), AppStateModel.getInstance().isCommunitySupport());
            PrjExportVideoActivity.this.cQq.sendMessage(PrjExportVideoActivity.this.cQq.obtainMessage(TodoConstants.TODO_TYPE_APK_TEST));
        }
    };
    /* access modifiers changed from: private */
    public String cQv = "";
    private C8512f cQw = new C8512f() {
        public void ama() {
            if (PrjExportVideoActivity.this.cQq != null) {
                PrjExportVideoActivity.this.cQq.sendMessage(PrjExportVideoActivity.this.cQq.obtainMessage(TodoConstants.TODO_TYPE_H5_FOLLOW));
            }
        }

        public void amb() {
        }

        /* renamed from: av */
        public void mo29115av(float f) {
            int i = (int) f;
            int i2 = PrjExportVideoActivity.this.cQn == 2 ? (i / 4) + 70 : ((i * 2) / 5) + 30;
            TextView e = PrjExportVideoActivity.this.cQo;
            StringBuilder sb = new StringBuilder();
            sb.append(i2);
            sb.append("%");
            e.setText(sb.toString());
        }

        /* renamed from: hM */
        public void mo29116hM(String str) {
            if (PrjExportVideoActivity.this.cQn == 1) {
                PrjExportVideoActivity.this.cQr.add(str);
                if (PrjExportVideoActivity.this.cQq != null) {
                    Message obtainMessage = PrjExportVideoActivity.this.cQq.obtainMessage(TodoConstants.TODO_TYPE_PASS_THROUGH_URL);
                    obtainMessage.obj = str;
                    PrjExportVideoActivity.this.cQq.sendMessageDelayed(obtainMessage, 300);
                }
            } else if (PrjExportVideoActivity.this.cQq != null) {
                Message obtainMessage2 = PrjExportVideoActivity.this.cQq.obtainMessage(10005);
                obtainMessage2.obj = str;
                PrjExportVideoActivity.this.cQq.sendMessageDelayed(obtainMessage2, 300);
            }
        }

        /* renamed from: n */
        public void mo29117n(int i, String str) {
            if (PrjExportVideoActivity.this.cQq != null) {
                PrjExportVideoActivity.this.cQq.sendMessage(PrjExportVideoActivity.this.cQq.obtainMessage(TodoConstants.TODO_TYPE_APK_TEST));
            }
        }
    };
    private TODOParamModel csJ;
    private MSize css = null;
    private C6397i ctc = null;
    private boolean isExporting = false;
    /* access modifiers changed from: private */
    public QStoryboard mStoryBoard = null;
    /* access modifiers changed from: private */
    public String mThumbPath = "";

    /* renamed from: com.introvd.template.editor.export.PrjExportVideoActivity$a */
    private static class C6225a extends WeakHandler<PrjExportVideoActivity> {
        public C6225a(PrjExportVideoActivity prjExportVideoActivity) {
            super(prjExportVideoActivity);
        }

        public void handleMessage(Message message) {
            PrjExportVideoActivity prjExportVideoActivity = (PrjExportVideoActivity) getOwner();
            if (prjExportVideoActivity != null) {
                switch (message.what) {
                    case TodoConstants.TODO_TYPE_QA_TEST /*10001*/:
                        prjExportVideoActivity.setResult(-1);
                        if (prjExportVideoActivity.cQl != 2) {
                            prjExportVideoActivity.m17856hK((String) message.obj);
                            break;
                        } else {
                            prjExportVideoActivity.cQo.setText("100%");
                            prjExportVideoActivity.cQv = (String) message.obj;
                            prjExportVideoActivity.mThumbPath = prjExportVideoActivity.bMM.aHe().strPrjThumbnail;
                            sendMessage(obtainMessage(10006));
                            break;
                        }
                    case TodoConstants.TODO_TYPE_APK_TEST /*10002*/:
                        prjExportVideoActivity.setResult(-1);
                        prjExportVideoActivity.finish();
                        break;
                    case TodoConstants.TODO_TYPE_H5_FOLLOW /*10003*/:
                        prjExportVideoActivity.setResult(0);
                        prjExportVideoActivity.finish();
                        break;
                    case TodoConstants.TODO_TYPE_PASS_THROUGH_URL /*10004*/:
                        prjExportVideoActivity.m17857hL((String) message.obj);
                        break;
                    case 10005:
                        prjExportVideoActivity.m17847b(prjExportVideoActivity.mStoryBoard);
                        prjExportVideoActivity.cQo.setText("100%");
                        prjExportVideoActivity.cQv = (String) message.obj;
                        sendEmptyMessageDelayed(10006, 100);
                        break;
                    case 10006:
                        long j = 0;
                        if (prjExportVideoActivity.cQs.longValue() > 0) {
                            j = System.currentTimeMillis() - prjExportVideoActivity.cQs.longValue();
                        }
                        HashMap hashMap = new HashMap();
                        hashMap.put("time", C5555c.m15041an(j));
                        StringBuilder sb = new StringBuilder();
                        sb.append("");
                        sb.append(prjExportVideoActivity.cQl);
                        hashMap.put("which_event", sb.toString());
                        UserBehaviorLog.onKVEvent(prjExportVideoActivity.getApplicationContext(), "Reverse_Compound_Done", hashMap);
                        C1941a f = VivaRouter.getRouterBuilder(XYActivityPublishActivityParam.URL).mo10399f(XYActivityPublishActivityParam.ACTIVITY_VIDEO_PATH, prjExportVideoActivity.cQv).mo10399f(XYActivityPublishActivityParam.VIDEOTHUMB, prjExportVideoActivity.mThumbPath);
                        String str = XYActivityPublishActivityParam.ACTIVITY_TYPE;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("");
                        sb2.append(prjExportVideoActivity.cQl);
                        f.mo10399f(str, sb2.toString()).mo10382H(prjExportVideoActivity);
                        try {
                            LocalBroadcastManager.getInstance(prjExportVideoActivity).sendBroadcast(new Intent("com.introvd.template.finishactivity"));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        prjExportVideoActivity.finish();
                        break;
                    case 10007:
                        if (prjExportVideoActivity.cQl == 2) {
                            if (prjExportVideoActivity.alY()) {
                                HashMap hashMap2 = new HashMap();
                                StringBuilder sb3 = new StringBuilder();
                                sb3.append(prjExportVideoActivity.cQl);
                                sb3.append("yes");
                                hashMap2.put("template", sb3.toString());
                                UserBehaviorLog.onKVEvent(prjExportVideoActivity, "Reverse_Compound", hashMap2);
                                return;
                            }
                            HashMap hashMap3 = new HashMap();
                            StringBuilder sb4 = new StringBuilder();
                            sb4.append(prjExportVideoActivity.cQl);
                            sb4.append("no");
                            hashMap3.put("template", sb4.toString());
                            UserBehaviorLog.onKVEvent(prjExportVideoActivity, "Reverse_Compound", hashMap3);
                        }
                        prjExportVideoActivity.alX();
                        break;
                    case 10008:
                        prjExportVideoActivity.cQo.setText("5%");
                        prjExportVideoActivity.bMM.mo34730a(true, prjExportVideoActivity.bOK, (Handler) this, AppStateModel.getInstance().isCommunitySupport(), prjExportVideoActivity.bMM.mo34778uz(prjExportVideoActivity.bMM.ebQ));
                        sendEmptyMessageDelayed(10009, 300);
                        break;
                    case 10009:
                        prjExportVideoActivity.alX();
                        break;
                }
            }
        }
    }

    /* renamed from: a */
    private void m17844a(QStoryboard qStoryboard, int i, EffectInfoModel effectInfoModel) {
        int a = C8540q.m24922a(qStoryboard, C8762d.aMt().getTemplateExternalFile(effectInfoModel.mTemplateId, 0, 1000), 0, i, 0, -1, 50);
        StringBuilder sb = new StringBuilder();
        sb.append("setStoryboardBGMusic iRes= ");
        sb.append(a);
        LogUtils.m14222e("PrjectExportVideoActivity", sb.toString());
    }

    private void alW() {
        if (this.cQt == null) {
            mo29110ar(this);
            return;
        }
        this.cQt.dismiss();
        this.cQt = null;
    }

    /* access modifiers changed from: private */
    public void alX() {
        this.cQn = 0;
        this.cQs = Long.valueOf(System.currentTimeMillis());
        VideoExportParamsModel videoExportParamsModel = new VideoExportParamsModel();
        if (this.cQl == 1) {
            videoExportParamsModel.assignedPath = FileUtils.getFreeFileName(new File(this.cQm).getParentFile().getAbsolutePath(), "xyactivity_", ".mp4", 0);
            videoExportParamsModel.bShowWaterMark = false;
        } else if (this.cQl == 2) {
            videoExportParamsModel.bShowWaterMark = true;
            videoExportParamsModel.mWaterMarkTemplateId = Long.valueOf(AppStateModel.getInstance().isInChina() ? 5404319552844595205L : 0);
        }
        videoExportParamsModel.isMvPrj = this.bMM.aHe().isMVPrj();
        videoExportParamsModel.bHDExport = false;
        videoExportParamsModel.mPrjPath = this.cQm;
        videoExportParamsModel.mStreamSizeVe = C8404c.m24244nD(this.cQm);
        videoExportParamsModel.encodeType = C8572y.aJm();
        videoExportParamsModel.decodeType = C8572y.aJl();
        this.ctc.mo29449a(this.bOK, this.bMM.aHd(), videoExportParamsModel, (C8508c) this.cQu);
    }

    /* access modifiers changed from: private */
    public boolean alY() {
        if (C8540q.m24894C(this.bMM.aHd()).longValue() > 0 || this.csJ == null) {
            return false;
        }
        Long k = C8555k.m25011k(this.csJ.getJsonObj());
        if (k.longValue() > 0) {
            String bB = C8762d.aMt().mo35225bB(k.longValue());
            if (!TextUtils.isEmpty(bB)) {
                alZ();
                StoryboardOpService.applyTheme(this, this.cQk.strPrjURL, bB);
                return true;
            }
        }
        return false;
    }

    private void alZ() {
        C62245 r0 = new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {
                String action = intent.getAction();
                StringBuilder sb = new StringBuilder();
                sb.append("action=");
                sb.append(action);
                LogUtilsV2.m14228e(sb.toString());
                if (PrjExportVideoActivity.this.cQq != null) {
                    PrjExportVideoActivity.this.cQq.sendEmptyMessage(10008);
                }
                LocalBroadcastManager.getInstance(context).unregisterReceiver(this);
            }
        };
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(IEditorService.RESULT_ACTION_THEME_APPLY_SUC);
        intentFilter.addAction(IEditorService.RESULT_ACTION_THEME_APPLY_FAIL);
        LocalBroadcastManager.getInstance(getApplicationContext()).registerReceiver(r0, intentFilter);
    }

    /* access modifiers changed from: private */
    public void alr() {
        finish();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m17847b(QStoryboard qStoryboard) {
        if (this.css == null) {
            this.css = new MSize(480, 480);
        }
        this.mThumbPath = FileUtils.getFreeFileName(new File(this.cQm).getParentFile().getAbsolutePath(), "xyactivity_", ".jpg", 0);
        C8522g.m24665a(qStoryboard, this.css.width, this.css.height, this.mThumbPath, 70);
    }

    /* access modifiers changed from: private */
    /* renamed from: hK */
    public void m17856hK(String str) {
        this.cQn = 1;
        this.cQp = new C8509d(this.bOK.aJv());
        this.cQp.mo34671a((C8508c) this.cQw);
        if (this.cQp.mo34689a(this.cQm, str, new QRange(0, -1), AppPreferencesSetting.getInstance().getAppSettingBoolean("pref_encode", false)) != 0) {
            this.cQq.sendMessage(this.cQq.obtainMessage(TodoConstants.TODO_TYPE_APK_TEST));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: hL */
    public void m17857hL(String str) {
        boolean z;
        StringBuilder sb;
        String str2;
        this.cQn = 2;
        this.mStoryBoard = C8572y.m25080b(this.bOK.aJv(), str);
        if (this.csJ == null || this.cQl != 1) {
            if (this.cQq != null) {
                Message obtainMessage = this.cQq.obtainMessage(10005);
                obtainMessage.obj = str;
                this.cQq.sendMessage(obtainMessage);
            }
            return;
        }
        int s = C8555k.m25013s(this.csJ.getJsonObj());
        if (s > 0) {
            List r = C8555k.m25012r(this.csJ.getJsonObj());
            int duration = this.mStoryBoard.getDuration();
            z = false;
            for (int i = 0; i < s; i++) {
                EffectInfoModel effectInfoModel = (EffectInfoModel) r.get(i);
                if (C8399c.edc.equals(effectInfoModel.mTCID)) {
                    m17844a(this.mStoryBoard, duration, effectInfoModel);
                    z = true;
                }
            }
        } else {
            z = false;
        }
        HashMap hashMap = new HashMap();
        String str3 = "template";
        if (z) {
            sb = new StringBuilder();
            sb.append(this.cQl);
            str2 = "yes";
        } else {
            sb = new StringBuilder();
            sb.append(this.cQl);
            str2 = "no";
        }
        sb.append(str2);
        hashMap.put(str3, sb.toString());
        UserBehaviorLog.onKVEvent(this, "Reverse_Compound", hashMap);
        VideoExportParamsModel videoExportParamsModel = new VideoExportParamsModel();
        videoExportParamsModel.isMvPrj = this.bMM.aHe().isMVPrj();
        videoExportParamsModel.bHDExport = false;
        videoExportParamsModel.expType = Integer.valueOf(0);
        videoExportParamsModel.bShowWaterMark = true;
        videoExportParamsModel.mWaterMarkTemplateId = Long.valueOf(AppStateModel.getInstance().isInChina() ? 5404319552844595205L : 0);
        videoExportParamsModel.mPrjPath = this.cQm;
        videoExportParamsModel.mStreamSizeVe = C8541r.m24980f(this.bOK.aJv(), str);
        videoExportParamsModel.encodeType = C8572y.aJm();
        videoExportParamsModel.decodeType = C8572y.aJl();
        this.ctc.mo29449a(this.bOK, this.mStoryBoard, videoExportParamsModel, (C8508c) this.cQw);
        if (videoExportParamsModel.mStreamSizeVe != null) {
            this.css = new MSize(videoExportParamsModel.mStreamSizeVe.width, videoExportParamsModel.mStreamSizeVe.height);
        }
    }

    /* renamed from: ar */
    public void mo29110ar(Activity activity) {
        if (this.cQt == null) {
            this.cQt = C8978m.m26349hs(activity).mo10296do(R.string.xiaoying_str_cancel_import_title_str).mo10303dv(R.string.xiaoying_str_com_no).mo10299dr(R.string.xiaoying_str_com_yes).mo10291b(new C1904j() {
                public void onClick(C1890f fVar, C1885b bVar) {
                    fVar.dismiss();
                }
            }).mo10281a((C1904j) new C1904j() {
                public void onClick(C1890f fVar, C1885b bVar) {
                    PrjExportVideoActivity.this.alr();
                }
            }).mo10313qu();
        }
        if (activity != null && !activity.isFinishing()) {
            this.cQt.show();
        }
    }

    public void onClick(View view) {
        if (view.getId() == R.id.imgview_btn_cancel) {
            alW();
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        this.bMM = C8522g.aJA();
        if (this.bMM == null || this.bMM.aHe() == null || this.bMM.aHd() == null || this.bMM.aHd().getClipCount() <= 0) {
            finish();
            return;
        }
        this.cQk = this.bMM.aHe();
        this.cQm = this.bMM.aHe().strPrjURL;
        this.bOK = C8501a.aJs();
        Bundle extras = getIntent().getExtras();
        this.csJ = null;
        if (extras != null) {
            this.csJ = (TODOParamModel) extras.getParcelable(TodoConstants.KEY_TODOCODE_PARAM_MODEL);
        }
        if (this.csJ != null) {
            this.cQl = this.csJ.getActivityFlag();
        }
        setContentView(R.layout.xiaoying_ve_video_export_activity_layout);
        ((ImageView) findViewById(R.id.imgview_btn_cancel)).setOnClickListener(this);
        this.cQo = (TextView) findViewById(R.id.txtview_export_progress);
        this.ctc = new C6397i(getApplicationContext(), C8404c.m24237bf(this.bMM.aHe()._id));
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyUp(i, keyEvent);
        }
        alW();
        return true;
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        if (isFinishing()) {
            if (this.cQp != null) {
                this.cQp.cancel();
            }
            if (this.ctc != null) {
                this.ctc.asX();
                this.ctc = null;
            }
            if (this.cQq != null) {
                this.cQq.removeCallbacksAndMessages(null);
                this.cQq = null;
            }
            if (this.cQr != null && this.cQr.size() > 0) {
                for (String deleteFile : this.cQr) {
                    FileUtils.deleteFile(deleteFile);
                }
                this.cQr.clear();
            }
        }
        super.onPause();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if (!this.isExporting) {
            if (this.cQk != null) {
                ProjectItem ahP = this.bMM.aHf();
                if (ahP == null) {
                    finish();
                    return;
                } else if (ahP.mStoryBoard == null) {
                    finish();
                    return;
                }
            }
            this.isExporting = true;
            this.cQq.sendMessageDelayed(this.cQq.obtainMessage(10007), 50);
        }
    }
}
