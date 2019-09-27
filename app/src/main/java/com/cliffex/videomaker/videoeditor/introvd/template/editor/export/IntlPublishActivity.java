package com.introvd.template.editor.export;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnShowListener;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.p021v4.content.ContextCompat;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.afollestad.materialdialogs.C1885b;
import com.afollestad.materialdialogs.C1890f;
import com.afollestad.materialdialogs.C1890f.C1895a;
import com.afollestad.materialdialogs.C1890f.C1904j;
import com.aiii.android.arouter.facade.p094a.C1942a;
import com.google.android.exoplayer2.extractor.p151ts.TsExtractor;
import com.introvd.template.C4681i;
import com.introvd.template.EventActivity;
import com.introvd.template.common.ActivityStateCheckListener;
import com.introvd.template.common.Constants;
import com.introvd.template.common.FileUtils;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.common.MagicCode;
import com.introvd.template.common.ToastUtils;
import com.introvd.template.common.Utils;
import com.introvd.template.common.behavior.GallerySiriBehavior;
import com.introvd.template.common.behavior.UserBehaviorUtils;
import com.introvd.template.common.behavior.UserBehaviorUtilsV5;
import com.introvd.template.common.model.AppStateModel;
import com.introvd.template.common.utils.NotchUtil;
import com.introvd.template.editor.R;
import com.introvd.template.module.iap.C8049f;
import com.introvd.template.module.iap.C8072q;
import com.introvd.template.module.p326ad.C7680l;
import com.introvd.template.module.p326ad.p327a.C7589a;
import com.introvd.template.p203b.C4580b;
import com.introvd.template.p203b.C4583d;
import com.introvd.template.p203b.C4596h;
import com.introvd.template.p242d.C5530d;
import com.introvd.template.p414ui.dialog.C8945c;
import com.introvd.template.p414ui.dialog.C8945c.C8948b;
import com.introvd.template.p414ui.dialog.C8957e;
import com.introvd.template.router.BizServiceManager;
import com.introvd.template.router.StudioRouter;
import com.introvd.template.router.common.CommonParams;
import com.introvd.template.router.editor.export.ExportActionEvent;
import com.introvd.template.router.editor.export.ExportClickEvent;
import com.introvd.template.router.editor.export.ExportPrjInfo;
import com.introvd.template.router.editor.export.IExportService;
import com.introvd.template.sdk.utils.C8567u;
import com.introvd.template.sns.OnIconClickListener;
import com.introvd.template.sns.PublishShareManager;
import com.introvd.template.sns.PublishShareManager.ShareMoreListener;
import com.introvd.template.sns.SnsResItem;
import com.introvd.template.sns.SnsShareManager;
import com.introvd.template.sns.SnsShareTypeUtil;
import com.introvd.template.sns.publish.BottomShareView;
import com.introvd.template.starvlogs.NativeAdmob;
import com.introvd.template.starvlogs.logfirebase.ActionFirebaseStarVlogs;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.quvideo.rescue.C4905b;
import com.quvideo.sns.base.C4987e;
import com.quvideo.sns.base.p228b.C4979b.C4981a;
import java.util.List;
import org.greenrobot.eventbus.C10021c;
import org.greenrobot.eventbus.C10031j;
import org.greenrobot.eventbus.ThreadMode;
import p037b.p050b.C1848s;
import p037b.p050b.C1849t;
import p037b.p050b.C1850u;
import p037b.p050b.C1851v;
import p037b.p050b.C1852w;
import p037b.p050b.p051a.p053b.C1487a;
import p037b.p050b.p054b.C1495b;
import p037b.p050b.p057e.C1518f;
import p037b.p050b.p076j.C1820a;

@C1942a(mo10417rZ = "/export/tool")
public class IntlPublishActivity extends EventActivity implements OnClickListener, ActivityStateCheckListener {
    public boolean bChinaArea = false;
    private TextView bvk;
    private ImageView bvn;
    private Button cPJ;
    private RelativeLayout cPK;
    protected ImageView cPL;
    private BottomShareView cPM;
    private ImageView cPN;
    private ImageView cPO;
    private C6219a cPP;
    /* access modifiers changed from: private */
    public boolean cPQ = false;
    /* access modifiers changed from: private */
    public boolean cPR = false;
    /* access modifiers changed from: private */
    public boolean cPS = false;
    private int cPT;
    private ResolveInfo cPU;
    /* access modifiers changed from: private */
    public SnsResItem cPV;
    private int cPW = 0;
    private ExportPrjInfo cPX;
    protected IExportService cPY;
    private OnDismissListener cPZ = new OnDismissListener() {
        public void onDismiss(DialogInterface dialogInterface) {
            if (IntlPublishActivity.this.cPS) {
                IntlPublishActivity.this.cPS = false;
                if (!IntlPublishActivity.this.isExporting) {
                    IntlPublishActivity.this.alT();
                }
            }
        }
    };
    private OnShowListener cQa = new OnShowListener() {
        public void onShow(DialogInterface dialogInterface) {
            IntlPublishActivity.this.cPS = true;
        }
    };
    /* access modifiers changed from: private */
    public List<Integer> cQb;
    private ShareMoreListener cQc = new ShareMoreListener() {
        public void onAppClick(ResolveInfo resolveInfo) {
            IntlPublishActivity.this.m17821b(resolveInfo);
        }
    };
    private OnIconClickListener cQd = new OnIconClickListener() {
        public void onIconClick(SnsResItem snsResItem) {
            IntlPublishActivity.this.cPV = snsResItem;
            IntlPublishActivity.this.m17823b(snsResItem);
        }
    };
    protected int csj;
    /* access modifiers changed from: private */
    public boolean isExporting = false;
    protected long magicCode;
    protected long uniqueId = System.currentTimeMillis();
    private String videoPath = null;

    /* renamed from: com.introvd.template.editor.export.IntlPublishActivity$a */
    private class C6219a extends Handler {
        public C6219a(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 130) {
                GallerySiriBehavior.recordShareExportExit(IntlPublishActivity.this.getApplicationContext(), "exported");
                C6255i.m17929fJ(true);
                String str = (String) message.obj;
                if (IntlPublishActivity.this.cPQ) {
                    IntlPublishActivity.this.m17832hI(str);
                    return;
                }
                C4681i.m12184Gp().mo25016Gr().launchExportResult(IntlPublishActivity.this, IntlPublishActivity.this.cPY.getPrjThumbnailPath(IntlPublishActivity.this), str, true, IronSourceConstants.INTERSTITIAL_DAILY_CAPPED);
                IntlPublishActivity.this.finish();
            } else if (i == 140) {
                IntlPublishActivity.this.cPR = true;
            }
        }
    }

    /* renamed from: Nu */
    private void m17811Nu() {
        this.cPP = new C6219a(getMainLooper());
        this.cPJ.setOnClickListener(this);
        this.bvn.setOnClickListener(this);
        this.bvk.setOnClickListener(this);
    }

    /* renamed from: a */
    private String m17813a(int i, ResolveInfo resolveInfo) {
        if (i != 28 && i != 33) {
            return null;
        }
        String str = i == 28 ? "Facebook" : "FBMessenger";
        if (!(resolveInfo == null || resolveInfo.activityInfo == null || resolveInfo.activityInfo.packageName == null || !C4987e.m12740cK(resolveInfo.activityInfo.packageName))) {
            str = i == 28 ? "Facebook_lite" : "FBMessenger_lite";
        }
        return str;
    }

    /* renamed from: aQ */
    private void m17820aQ(final List<ResolveInfo> list) {
        if (list.size() > 0) {
            if (list.size() == 1) {
                m17821b((ResolveInfo) list.get(0));
            } else {
                C8945c cVar = new C8945c(this, C8957e.m26314a(list, getPackageManager()), new C8948b() {
                    public void buttonClick(int i) {
                    }

                    public void itemClick(int i) {
                        IntlPublishActivity.this.alU();
                        IntlPublishActivity.this.m17821b((ResolveInfo) list.get(i));
                    }
                });
                cVar.setButtonText(R.string.xiaoying_str_com_cancel);
                cVar.mo31986Q(Integer.valueOf(R.string.xiaoying_str_studio_intent_chooser_email));
                cVar.show();
            }
        }
    }

    private void alN() {
        this.cPM.changeShareTitle(R.string.xiaoying_str_publish_international_tip);
        this.cPM.initData(0, this.bChinaArea, this.cQd);
        if (!FileUtils.isFileExisted(this.cPY.getPrjThumbnailPath(this))) {
            this.cPL.setImageResource(R.drawable.prj_no_clip_default);
            return;
        }
        Options options = new Options();
        options.inSampleSize = 2;
        this.cPL.setImageBitmap(BitmapFactory.decodeFile(this.cPY.getPrjThumbnailPath(this), options));
    }

    private void alO() {
        GallerySiriBehavior.recordShareExportExit(getApplicationContext(), "back");
        UserBehaviorUtilsV5.onEventCommunityPublishKeyboardTest("back");
        this.cPY.handleBackClickJump(this, this.csj, this.magicCode);
        finish();
    }

    private void alQ() {
        if (this.cPP != null) {
            Message obtainMessage = this.cPP.obtainMessage(TsExtractor.TS_STREAM_TYPE_HDMV_DTS);
            obtainMessage.obj = this.videoPath;
            this.cPP.sendMessage(obtainMessage);
        }
    }

    /* access modifiers changed from: private */
    public void alU() {
        if (this.cPP != null && !this.cPR) {
            this.cPP.sendEmptyMessageDelayed(IronSourceConstants.USING_CACHE_FOR_INIT_EVENT, 250);
        }
    }

    /* access modifiers changed from: private */
    public boolean alV() {
        if (this.cPY.isFunnyVideo(this) || this.cPY.isStoryVideo(this)) {
            return false;
        }
        return alR();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m17821b(ResolveInfo resolveInfo) {
        this.cPU = resolveInfo;
        if (this.cPU == null) {
            ToastUtils.show((Context) this, R.string.xiaoying_str_com_no_sns_client, 0);
            return;
        }
        this.cPQ = true;
        this.cPY.beginExportVideo(this, false, alV(), alP(), false);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m17823b(final SnsResItem snsResItem) {
        m17834i(new Runnable() {
            public void run() {
                IntlPublishActivity.this.m17827c(snsResItem);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m17827c(final SnsResItem snsResItem) {
        if (!this.cPY.checkDurationOverLimit(this, false)) {
            this.cPT = snsResItem.mSnsType;
            int i = snsResItem.mSnsType;
            if (i == 4) {
                List filterEmailActivity = PublishShareManager.getFilterEmailActivity(this);
                if (filterEmailActivity.size() <= 0) {
                    ToastUtils.show((Context) this, R.string.xiaoying_str_com_no_sns_client, 0);
                } else {
                    m17820aQ(filterEmailActivity);
                }
                C6253g.m17915hE(snsResItem.strDes);
                C6254h.m17925w(getApplicationContext(), snsResItem.strDes, "Video_Share_Inter");
            } else if (i != 100) {
                if (!(snsResItem.mSnsType == 28 || snsResItem.mSnsType == 33)) {
                    C6254h.m17925w(getApplicationContext(), snsResItem.strDes, "Video_Share_Inter");
                }
                C6253g.m17915hE(snsResItem.strDes);
                if (!C4596h.m11725Sy() && (snsResItem.mSnsType == 28 || snsResItem.mSnsType == 26)) {
                    new C1895a(this).mo10296do(R.string.xiaoying_str_com_share_dialog_facebook_content).mo10303dv(R.string.xiaoying_str_com_got_it).mo10302du(ContextCompat.getColor(this, R.color.color_585858)).mo10288aA(false).mo10273a(R.string.xiaoying_str_com_user_tip_not_show, false, (OnCheckedChangeListener) null).mo10305dx(R.color.color_ff5e13).mo10291b(new C1904j() {
                        public void onClick(C1890f fVar, C1885b bVar) {
                            if (fVar.mo10262qp()) {
                                C4596h.m11726Sz();
                            }
                            IntlPublishActivity.this.m17835nt(snsResItem.mSnsType);
                        }
                    }).mo10313qu().show();
                } else {
                    m17835nt(snsResItem.mSnsType);
                }
            } else {
                PublishShareManager.showShareMore(this, this.cQc);
                C6254h.m17925w(getApplicationContext(), snsResItem.strDes, "Video_Share_Inter");
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: hI */
    public void m17832hI(String str) {
        String prjExportUrl = this.cPY.getPrjExportUrl(this);
        if (!TextUtils.isEmpty(prjExportUrl)) {
            if (Utils.getURIFromRealPath(prjExportUrl, this) != null || this.cPW > 3) {
                this.cPQ = false;
                if (m17833hJ(str)) {
                    alU();
                }
            } else {
                this.cPQ = true;
                this.cPW++;
                if (this.cPP != null) {
                    this.cPP.sendEmptyMessageDelayed(TsExtractor.TS_STREAM_TYPE_HDMV_DTS, 500);
                }
            }
        }
    }

    /* renamed from: hJ */
    private boolean m17833hJ(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        C4981a cQ = new C4981a().mo25446cQ(str);
        if (this.cPU != null) {
            if (this.cPT == 4 || this.cPT == 100) {
                SnsShareManager.shareVideo(this, this.cPU, cQ.mo25441FJ());
                if (this.cPT == 100) {
                    C6253g.m17915hE("more");
                }
            } else {
                SnsShareManager.shareVideo(this, this.cPT, cQ.mo25441FJ(), null);
            }
        }
        return true;
    }

    @SuppressLint({"CheckResult"})
    /* renamed from: i */
    private void m17834i(final Runnable runnable) {
        C1848s.m5324a((C1851v<T>) new C1851v<List<Integer>>() {
            /* renamed from: a */
            public void mo10201a(C1849t<List<Integer>> tVar) throws Exception {
                if (C8072q.aBx().isVip()) {
                    tVar.onError(new Exception("user is vip"));
                    return;
                }
                if (IntlPublishActivity.this.cQb == null) {
                    IntlPublishActivity.this.cQb = IntlPublishActivity.this.cPY.getProjectVIPList(IntlPublishActivity.this);
                }
                if (IntlPublishActivity.this.cQb == null || IntlPublishActivity.this.cQb.isEmpty()) {
                    tVar.onError(new Exception("there is no good no purchased"));
                } else {
                    tVar.onSuccess(IntlPublishActivity.this.cQb);
                }
            }
        }).mo10196g(C1820a.aVi()).mo10198h(new C1518f<List<Integer>, C1852w<Boolean>>() {
            /* renamed from: aN */
            public C1852w<Boolean> apply(List<Integer> list) throws Exception {
                return C8049f.aBf().mo33078a(IntlPublishActivity.this, list);
            }
        }).mo10194f(C1487a.aUa()).mo10188a((C1850u<? super T>) new C1850u<Boolean>() {
            /* renamed from: a */
            public void mo9883a(C1495b bVar) {
            }

            /* renamed from: e */
            public void onSuccess(Boolean bool) {
                if (runnable != null && !bool.booleanValue()) {
                    runnable.run();
                }
            }

            public void onError(Throwable th) {
                th.printStackTrace();
                if (runnable != null) {
                    runnable.run();
                }
            }
        });
    }

    private void initUI() {
        this.bvn = (ImageView) findViewById(R.id.img_back);
        this.bvk = (TextView) findViewById(R.id.xiaoying_txtview_draft_btn);
        this.cPJ = (Button) findViewById(R.id.btn_export);
        this.cPK = (RelativeLayout) findViewById(R.id.project_info_layout);
        this.cPL = (ImageView) findViewById(R.id.share_img_thumb);
        this.cPM = (BottomShareView) findViewById(R.id.bottom_share_view_layout);
        this.cPN = (ImageView) findViewById(R.id.publish_share_left_bg);
        this.cPO = (ImageView) findViewById(R.id.publish_share_right_bg);
        if (Constants.getScreenSize().height < C4583d.m11670O(this, 582)) {
            LayoutParams layoutParams = (LayoutParams) this.cPK.getLayoutParams();
            layoutParams.topMargin = (int) (((float) layoutParams.topMargin) * 0.27999997f);
            this.cPK.setLayoutParams(layoutParams);
            LayoutParams layoutParams2 = (LayoutParams) this.cPJ.getLayoutParams();
            layoutParams2.topMargin = (int) (((float) layoutParams2.topMargin) * 0.27999997f);
            this.cPJ.setLayoutParams(layoutParams2);
            LayoutParams layoutParams3 = (LayoutParams) this.cPN.getLayoutParams();
            layoutParams3.width = (int) (((float) layoutParams3.width) * 0.72f);
            layoutParams3.height = (int) (((float) layoutParams3.height) * 0.72f);
            this.cPN.setLayoutParams(layoutParams3);
            LayoutParams layoutParams4 = (LayoutParams) this.cPO.getLayoutParams();
            layoutParams4.width = (int) (((float) layoutParams4.width) * 0.72f);
            layoutParams4.height = (int) (((float) layoutParams4.height) * 0.72f);
            this.cPO.setLayoutParams(layoutParams4);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: nt */
    public void m17835nt(int i) {
        ResolveInfo resolveInfoBySnsType = SnsShareManager.getResolveInfoBySnsType(getApplicationContext(), i);
        String a = m17813a(i, resolveInfoBySnsType);
        if (!TextUtils.isEmpty(a)) {
            C6254h.m17925w(getApplicationContext(), a, "Video_Share_Inter");
        }
        if (resolveInfoBySnsType != null) {
            m17821b(resolveInfoBySnsType);
        }
    }

    public String alP() {
        if (this.cPV == null) {
            return "Gallery";
        }
        if (SnsShareTypeUtil.checkGifSNS(this.cPV, false)) {
            return this.cPV.strDes;
        }
        return null;
    }

    public boolean alR() {
        return SnsShareTypeUtil.checkGifSNS(this.cPV, true);
    }

    /* access modifiers changed from: protected */
    public final boolean alS() {
        return this.cPS;
    }

    /* access modifiers changed from: protected */
    public void alT() {
        alQ();
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return keyEvent.getKeyCode() == 84 || super.dispatchKeyEvent(keyEvent);
    }

    public boolean isResponseTodoProcess() {
        return !this.isExporting;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ns */
    public void mo29095ns(int i) {
        if (12 == i && !this.bChinaArea) {
            C7589a.m22360aj(this, i);
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.cPY.handleExportVideoActivityResult(this, i, i2, intent);
    }

    public void onClick(View view) {
        if (!C4580b.m11632Sf() && view != null) {
            if (view.equals(this.bvn)) {
                alO();
            } else if (view.equals(this.bvk)) {
                GallerySiriBehavior.recordShareExportExit(getApplicationContext(), "save_draft");
                UserBehaviorUtilsV5.onEventCommunityPublishKeyboardTest("draft");
                C7680l.aAf().mo32494it(true);
                C7680l.aAf().mo32496kc("publish");
                if (!C5530d.m14977kn(this.csj)) {
                    UserBehaviorUtils.recordPrjSave(getApplicationContext(), "share");
                    StudioRouter.launchStudioActivity(this);
                }
                finish();
            } else if (view.equals(this.cPJ)) {
                m17834i(new Runnable() {
                    public void run() {
                        UserBehaviorUtilsV5.onEventCommunityPublishKeyboardTest("export");
                        C6253g.m17915hE("gallery");
                        if (!IntlPublishActivity.this.cPY.checkDurationOverLimit(IntlPublishActivity.this, false)) {
                            IntlPublishActivity.this.cPV = null;
                            IntlPublishActivity.this.cPY.handleExportClick(IntlPublishActivity.this, false, IntlPublishActivity.this.alV(), IntlPublishActivity.this.alP(), true);
                        }
                    }
                });
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        ActionFirebaseStarVlogs.actionPublishActivity(this);
        if ("M040".equals(Build.MODEL) || NotchUtil.isNotchDevice()) {
            setTheme(R.style.Theme_XiaoYingNoSplash);
        }
        super.onCreate(bundle);
        LogUtilsV2.m14230i("onCreate");
        C4681i.m12184Gp().mo25016Gr().registerXYINTSdk(this, this.cPZ, this.cQa);
        this.magicCode = getIntent().getLongExtra(CommonParams.INTENT_MAGIC_CODE, 0);
        this.csj = ((C5530d) MagicCode.getMagicParam(this.magicCode, "AppRunningMode", new C5530d())).cnU;
        StringBuilder sb = new StringBuilder();
        sb.append("MagicCode:");
        sb.append(this.magicCode);
        LogUtilsV2.m14230i(sb.toString());
        C8567u.setContext(getApplicationContext());
        this.bChinaArea = AppStateModel.getInstance().isInChina();
        if (!this.bChinaArea && C7680l.aAf().azZ()) {
            C7589a.m22360aj(this, 17);
        }
        getWindow().setSoftInputMode(3);
        setContentView(R.layout.editor_publish_intl);
        NativeAdmob.refreshAd(this);
        this.cPY = (IExportService) BizServiceManager.getService(IExportService.class);
        if (this.cPY == null) {
            finish();
            return;
        }
        this.cPY.registerExportVideoListener(this, this.magicCode, this.uniqueId, false);
        this.cPX = this.cPY.getExportPrjInfo(this);
        if (this.cPX == null || this.cPY == null) {
            finish();
            return;
        }
        C6254h.m17923f(this, getIntent().getStringExtra(CommonParams.COMMON_PARAM_LAUCHER_ACTIVITY_NAME), this.cPX.isMVPrj);
        initUI();
        m17811Nu();
        alN();
        C10021c.aZH().mo38494ax(this);
        m17834i(null);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        C10021c.aZH().mo38496az(this);
        if (this.cPM != null) {
            this.cPM.releaseAll();
        }
        if (this.cPP != null) {
            this.cPP.removeMessages(TsExtractor.TS_STREAM_TYPE_HDMV_DTS);
            this.cPP = null;
        }
        C7680l.aAe().releasePosition(17, false);
    }

    @C10031j(aZK = ThreadMode.MAIN)
    public void onExportActionEvent(ExportActionEvent exportActionEvent) {
        if (exportActionEvent.uniqueId == this.uniqueId) {
            if (exportActionEvent.state == 0) {
                if (!this.cPQ) {
                    mo29095ns(12);
                }
            } else if (exportActionEvent.state == 1) {
                this.videoPath = exportActionEvent.videoPath;
                this.isExporting = false;
                if (!alS()) {
                    alQ();
                }
            } else if (exportActionEvent.state == 4) {
                this.isExporting = exportActionEvent.isExporting;
            } else {
                this.isExporting = false;
            }
        }
    }

    @C10031j(aZK = ThreadMode.MAIN)
    public void onExportClickEvent(ExportClickEvent exportClickEvent) {
        if (exportClickEvent.uniqueId == this.uniqueId) {
            this.cPQ = false;
            this.cPV = null;
        }
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyUp(i, keyEvent);
        }
        alO();
        return true;
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        C4905b.m12547g(13, null, getClass().getSimpleName());
        if (this.cPR) {
            this.cPR = false;
            StudioRouter.launchStudioActivity(this);
            finish();
        }
    }
}
