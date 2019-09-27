package com.introvd.template.editor.advance;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.facebook.ads.AdError;
import com.introvd.template.EventActivity;
import com.introvd.template.VivaBaseApplication;
import com.introvd.template.common.AppPreferencesSetting;
import com.introvd.template.common.Constants;
import com.introvd.template.common.ExAsyncTask;
import com.introvd.template.common.LogUtils;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.common.MSize;
import com.introvd.template.common.MagicCode;
import com.introvd.template.common.SDCardManager;
import com.introvd.template.common.UserBehaviorLog;
import com.introvd.template.common.model.AppStateModel;
import com.introvd.template.editor.R;
import com.introvd.template.editor.common.p248b.C5842b;
import com.introvd.template.editor.p245b.C5675f;
import com.introvd.template.editor.p245b.C5676g;
import com.introvd.template.p203b.C4597i;
import com.introvd.template.p242d.C5530d;
import com.introvd.template.p374q.C8345d;
import com.introvd.template.router.common.CommonParams;
import com.introvd.template.router.editor.gallery.GalleryRouter;
import com.introvd.template.router.todoCode.TODOParamModel;
import com.introvd.template.router.todoCode.TodoConstants;
import com.introvd.template.sdk.editor.cache.C8441b;
import com.introvd.template.sdk.editor.cache.C8443d;
import com.introvd.template.sdk.editor.p388b.C8425b;
import com.introvd.template.sdk.editor.p388b.C8425b.C8426a;
import com.introvd.template.sdk.editor.p388b.C8431d;
import com.introvd.template.sdk.editor.p388b.C8431d.C8434c;
import com.introvd.template.sdk.model.editor.EffectInfoModel;
import com.introvd.template.sdk.model.editor.ProjectItem;
import com.introvd.template.sdk.model.template.RollInfo;
import com.introvd.template.sdk.model.template.TemplateInfo;
import com.introvd.template.sdk.utils.C8549f;
import com.introvd.template.sdk.utils.C8553i;
import com.introvd.template.sdk.utils.C8567u;
import com.introvd.template.sdk.utils.C8571x;
import com.introvd.template.sdk.utils.C8572y;
import com.introvd.template.sdk.utils.VeMSize;
import com.introvd.template.sdk.utils.p394b.C8501a;
import com.introvd.template.sdk.utils.p394b.C8522g;
import com.introvd.template.sdk.utils.p394b.C8538o;
import com.introvd.template.sdk.utils.p394b.C8540q;
import com.introvd.template.template.download.C8703d;
import com.introvd.template.template.download.C8708f;
import com.introvd.template.template.p407e.C8735f;
import com.p131c.p132a.p135c.C2575a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import xiaoying.engine.QEngine;
import xiaoying.engine.base.QDisplayContext;
import xiaoying.engine.base.QSessionStream;
import xiaoying.engine.clip.QEffect;
import xiaoying.engine.storyboard.QStoryboard;

public abstract class AdvanceBaseEditActivity extends EventActivity implements Callback {

    /* renamed from: Fs */
    protected volatile int f3474Fs;
    protected C8522g bMM = null;
    protected RelativeLayout bMj;
    protected long bMw = 0;
    public volatile long bNB;
    protected C8501a bOK = null;
    private C8703d bOW;
    protected volatile boolean csA = false;
    protected volatile boolean csB = false;
    protected volatile boolean csC;
    protected volatile int csD;
    protected volatile boolean csE;
    protected volatile boolean csF;
    protected volatile boolean csG;
    protected boolean csH;
    /* access modifiers changed from: private */
    public C5560c csI;
    protected TODOParamModel csJ;
    protected int csK;
    protected int csL;
    protected int csM;
    protected SurfaceView csN;
    protected volatile SurfaceHolder csO;
    protected MSize csP;
    protected RelativeLayout csQ;
    protected RelativeLayout csR;
    protected C8434c csS;
    protected C5559b csT;
    protected C8426a csU;
    private C8708f csV;
    protected int csj = 0;
    protected C8431d cso = null;
    protected C5530d csp;
    protected String csq = "";
    protected MSize csr = null;
    protected MSize css = null;
    protected C8425b cst = null;
    protected C5675f csu = null;
    protected volatile ArrayList<C8441b> csv = null;
    protected volatile boolean csw = true;
    protected volatile boolean csx = false;
    protected volatile boolean csy = false;
    protected volatile boolean csz = false;
    protected C8443d mClipModelCacheList;
    protected QStoryboard mStoryBoard;
    protected long mTemplateId;

    /* renamed from: com.introvd.template.editor.advance.AdvanceBaseEditActivity$a */
    private class C5558a implements C8434c {
        public C5558a() {
        }

        /* renamed from: cj */
        public void mo27391cj(int i, int i2) {
            switch (i) {
                case 2:
                    LogUtils.m14223i("AdvanceBaseEditActivity_Log", "PlaybackModule.MSG_PLAYER_READY");
                    if (AdvanceBaseEditActivity.this.cso != null) {
                        int aIx = AdvanceBaseEditActivity.this.cso.aIx();
                        StringBuilder sb = new StringBuilder();
                        sb.append("PlaybackModule progress=");
                        sb.append(aIx);
                        LogUtils.m14223i("AdvanceBaseEditActivity_Log", sb.toString());
                        AdvanceBaseEditActivity.this.cso.mo34191jn(true);
                        AdvanceBaseEditActivity.this.cso.aIB();
                        AdvanceBaseEditActivity.this.mo27378ks(aIx);
                        return;
                    }
                    return;
                case 3:
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("PlaybackModule.MSG_PLAYER_RUNNING progress=");
                    sb2.append(i2);
                    LogUtils.m14223i("AdvanceBaseEditActivity_Log", sb2.toString());
                    C4597i.m11728a(true, AdvanceBaseEditActivity.this);
                    AdvanceBaseEditActivity.this.mo27379kt(i2);
                    return;
                case 4:
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("PlaybackModule.MSG_PLAYER_PAUSED progress=");
                    sb3.append(i2);
                    LogUtils.m14223i("AdvanceBaseEditActivity_Log", sb3.toString());
                    C4597i.m11728a(false, AdvanceBaseEditActivity.this);
                    AdvanceBaseEditActivity.this.mo27380ku(i2);
                    return;
                case 5:
                    LogUtils.m14223i("AdvanceBaseEditActivity_Log", "PlaybackModule.MSG_PLAYER_STOPPED");
                    C4597i.m11728a(false, AdvanceBaseEditActivity.this);
                    if (AdvanceBaseEditActivity.this.abF() && AdvanceBaseEditActivity.this.cso != null) {
                        AdvanceBaseEditActivity.this.cso.mo34197ug(AdvanceBaseEditActivity.this.abC());
                    }
                    AdvanceBaseEditActivity.this.mo27381kv(i2);
                    return;
                case 6:
                    if (i2 == 268455950) {
                        C5842b.ahd();
                        C5842b.ahf();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    /* renamed from: com.introvd.template.editor.advance.AdvanceBaseEditActivity$b */
    public static class C5559b extends Handler {
        private WeakReference<AdvanceBaseEditActivity> csX = null;

        public C5559b(AdvanceBaseEditActivity advanceBaseEditActivity) {
            this.csX = new WeakReference<>(advanceBaseEditActivity);
        }

        public void handleMessage(Message message) {
            AdvanceBaseEditActivity advanceBaseEditActivity = (AdvanceBaseEditActivity) this.csX.get();
            if (advanceBaseEditActivity != null) {
                QEngine qEngine = null;
                switch (message.what) {
                    case AdError.ICONVIEW_MISSING_ERROR_CODE /*6002*/:
                        if (AppPreferencesSetting.getInstance().getAppSettingBoolean("fine_tunning_tip", true) && advanceBaseEditActivity.csR != null) {
                            TextView textView = (TextView) advanceBaseEditActivity.csR.findViewById(R.id.xiaoying_txtview_help_tip);
                            if (textView != null) {
                                textView.setText(R.string.xiaoying_str_ve_import_fine_tunning_help_tip);
                            }
                            advanceBaseEditActivity.csR.setVisibility(0);
                            break;
                        }
                    case AdError.AD_ASSETS_UNSUPPORTED_TYPE_ERROR_CODE /*6003*/:
                        if (AppPreferencesSetting.getInstance().getAppSettingBoolean("tap_choose_tip", true) && advanceBaseEditActivity.csR != null) {
                            TextView textView2 = (TextView) advanceBaseEditActivity.csR.findViewById(R.id.xiaoying_txtview_help_tip);
                            if (textView2 != null) {
                                textView2.setText(advanceBaseEditActivity.getString(R.string.xiaoying_str_help_ve_tap_the_text_to_modify));
                            }
                            advanceBaseEditActivity.csR.setVisibility(0);
                            break;
                        }
                    case AdError.SHOW_CALLED_BEFORE_LOAD_ERROR_CODE /*7001*/:
                        if (advanceBaseEditActivity.csB && advanceBaseEditActivity.csI != null) {
                            removeMessages(AdError.SHOW_CALLED_BEFORE_LOAD_ERROR_CODE);
                            sendEmptyMessageDelayed(AdError.SHOW_CALLED_BEFORE_LOAD_ERROR_CODE, 20000);
                            break;
                        } else {
                            advanceBaseEditActivity.csI = new C5560c(advanceBaseEditActivity.bMM, this, advanceBaseEditActivity.bOK);
                            advanceBaseEditActivity.csI.execute((Params[]) new Void[0]);
                            advanceBaseEditActivity.csB = true;
                            LogUtilsV2.m14228e("bPrjSaveLock 10true");
                            break;
                        }
                        break;
                    case AdError.LOAD_CALLED_WHILE_SHOWING_AD /*7002*/:
                        advanceBaseEditActivity.csB = false;
                        LogUtils.m14222e(AdvanceBaseEditActivity.TAG, "bPrjSaveLock 11false");
                        advanceBaseEditActivity.csI = null;
                        removeMessages(AdError.SHOW_CALLED_BEFORE_LOAD_ERROR_CODE);
                        sendEmptyMessageDelayed(AdError.SHOW_CALLED_BEFORE_LOAD_ERROR_CODE, 20000);
                        break;
                    case TodoConstants.TODO_TYPE_QA_TEST /*10001*/:
                        if (!advanceBaseEditActivity.csF) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("surfaceChanged BASIC_EVENT_MSG_INIT_MEDIAPLAYER bPreviewSizeAdjusted=");
                            sb.append(!advanceBaseEditActivity.csx);
                            LogUtils.m14223i("AdvanceBaseEditActivity_Log", sb.toString());
                            if (advanceBaseEditActivity.csx && advanceBaseEditActivity.csP != null) {
                                if (advanceBaseEditActivity.cso != null) {
                                    if (advanceBaseEditActivity.csO.getSurface().isValid() && !advanceBaseEditActivity.csF && advanceBaseEditActivity.csP != null) {
                                        QDisplayContext c = C8571x.m25060c(advanceBaseEditActivity.csP.width, advanceBaseEditActivity.csP.height, 1, advanceBaseEditActivity.csO);
                                        int displayContext = advanceBaseEditActivity.cso.setDisplayContext(c);
                                        if (!advanceBaseEditActivity.abG()) {
                                            displayContext = advanceBaseEditActivity.cso.mo34166a(c, advanceBaseEditActivity.csK);
                                        }
                                        advanceBaseEditActivity.abE();
                                        StringBuilder sb2 = new StringBuilder();
                                        sb2.append("BASIC_EVENT_MSG_INIT_MEDIAPLAYER res=");
                                        sb2.append(displayContext);
                                        LogUtils.m14223i("AdvanceBaseEditActivity_Log", sb2.toString());
                                        advanceBaseEditActivity.cso.aIB();
                                        break;
                                    }
                                } else {
                                    advanceBaseEditActivity.cso = new C8431d();
                                    advanceBaseEditActivity.cso.mo34191jn(false);
                                    QSessionStream abB = advanceBaseEditActivity.abB();
                                    if (advanceBaseEditActivity.mStoryBoard != null) {
                                        qEngine = advanceBaseEditActivity.mStoryBoard.getEngine();
                                    }
                                    boolean a = advanceBaseEditActivity.cso.mo34169a(abB, advanceBaseEditActivity.getPlayCallback(), new VeMSize(advanceBaseEditActivity.csP.width, advanceBaseEditActivity.csP.height), advanceBaseEditActivity.getPlayerInitTime(), qEngine == null ? C8501a.aJs().aJv() : qEngine, advanceBaseEditActivity.csO);
                                    StringBuilder sb3 = new StringBuilder();
                                    sb3.append("BASIC_EVENT_MSG_INIT_MEDIAPLAYER initResult=");
                                    sb3.append(a);
                                    LogUtils.m14223i("AdvanceBaseEditActivity_Log", sb3.toString());
                                    advanceBaseEditActivity.abD();
                                    break;
                                }
                            } else {
                                if (advanceBaseEditActivity.cso != null) {
                                    advanceBaseEditActivity.cso.mo34191jn(false);
                                }
                                advanceBaseEditActivity.abu();
                                advanceBaseEditActivity.csT.removeMessages(TodoConstants.TODO_TYPE_QA_TEST);
                                advanceBaseEditActivity.csT.sendMessageDelayed(advanceBaseEditActivity.csT.obtainMessage(TodoConstants.TODO_TYPE_QA_TEST), 50);
                                return;
                            }
                        } else {
                            return;
                        }
                        break;
                }
            }
        }
    }

    /* renamed from: com.introvd.template.editor.advance.AdvanceBaseEditActivity$c */
    private static class C5560c extends ExAsyncTask<Void, Void, Boolean> {
        private WeakReference<C8522g> csY = null;
        private WeakReference<Handler> csZ = null;
        private WeakReference<C8501a> cta = null;

        public C5560c(C8522g gVar, Handler handler, C8501a aVar) {
            this.csY = new WeakReference<>(gVar);
            this.csZ = new WeakReference<>(handler);
            this.cta = new WeakReference<>(aVar);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Boolean doInBackground(Void... voidArr) {
            C8522g gVar = (C8522g) this.csY.get();
            boolean z = false;
            if (gVar == null) {
                return Boolean.valueOf(false);
            }
            if (gVar.mo34755b((C8501a) this.cta.get()) == 0) {
                z = true;
            }
            return Boolean.valueOf(z);
        }

        /* access modifiers changed from: protected */
        /* renamed from: r */
        public void onPostExecute(Boolean bool) {
            super.onPostExecute(bool);
            if (this.csZ != null) {
                Handler handler = (Handler) this.csZ.get();
                if (handler != null) {
                    handler.sendEmptyMessage(AdError.LOAD_CALLED_WHILE_SHOWING_AD);
                }
            }
        }
    }

    public AdvanceBaseEditActivity() {
        this.csC = C8549f.aJd() && AppPreferencesSetting.getInstance().getAppSettingBoolean("pref_encode", false);
        this.csD = 2;
        this.csE = false;
        this.csF = false;
        this.csG = false;
        this.csH = false;
        this.f3474Fs = 0;
        this.mTemplateId = 0;
        this.csI = null;
        this.csK = -1;
        this.csL = 1;
        this.csM = 2;
        this.csT = new C5559b(this);
        this.bOW = null;
        this.csU = new C8426a() {
            public void abL() {
                AdvanceBaseEditActivity.this.abI();
                AdvanceBaseEditActivity.this.csw = true;
            }
        };
        this.bNB = 0;
        this.csV = new C8708f() {
            /* renamed from: b */
            public void mo24951b(Long l) {
                AdvanceBaseEditActivity.this.mo27376j(l);
            }

            /* renamed from: c */
            public void mo24952c(long j, int i) {
                AdvanceBaseEditActivity.this.mo27372d(j, i);
            }

            /* renamed from: c */
            public void mo24953c(Long l) {
                AdvanceBaseEditActivity.this.mo27383m(l);
                if (l.longValue() == AdvanceBaseEditActivity.this.bNB) {
                    AdvanceBaseEditActivity.this.mo27384n(l);
                    AdvanceBaseEditActivity.this.bNB = -1;
                }
            }

            /* renamed from: o */
            public void mo27389o(Long l) {
                AdvanceBaseEditActivity.this.mo27377k(l);
            }

            /* renamed from: p */
            public void mo27390p(Long l) {
                AdvanceBaseEditActivity.this.mo27382l(l);
            }
        };
    }

    private int abx() {
        LogUtils.m14223i("AdvanceBaseEditActivity_Log", "baseInitStoryBoard in");
        if (this.bMM == null) {
            return 1;
        }
        ProjectItem ahP = this.bMM.aHf();
        if (ahP == null) {
            return 1;
        }
        this.mStoryBoard = ahP.mStoryBoard;
        if (this.mStoryBoard == null) {
            return 1;
        }
        this.csu = new C5676g(this.mStoryBoard);
        this.mClipModelCacheList = ahP.mClipModelCacheList;
        if (this.mClipModelCacheList == null) {
            return 1;
        }
        if (ahP.mProjectDataItem != null) {
            this.css = new MSize(ahP.mProjectDataItem.streamWidth, ahP.mProjectDataItem.streamHeight);
        }
        this.csu.mo27765c(this.css);
        C8540q.m24907P(this.mStoryBoard);
        LogUtils.m14223i("AdvanceBaseEditActivity_Log", "baseInitStoryBoard out");
        return 0;
    }

    /* access modifiers changed from: private */
    public C8434c getPlayCallback() {
        if (this.csS == null) {
            this.csS = new C5558a();
        }
        return this.csS;
    }

    /* renamed from: a */
    public void mo27351a(EffectInfoModel effectInfoModel, String str) {
        if (this.bOW != null) {
            this.bOW.mo35077a(effectInfoModel, str);
        }
    }

    /* renamed from: a */
    public void mo27352a(TemplateInfo templateInfo, String str) {
        if (templateInfo != null) {
            RollInfo rollInfo = (RollInfo) templateInfo;
            if (rollInfo.rollModel != null) {
                EffectInfoModel effectInfoModel = new EffectInfoModel();
                effectInfoModel.setmUrl(rollInfo.rollModel.rollDownUrl);
                effectInfoModel.mName = templateInfo.strTitle;
                effectInfoModel.mTemplateId = C2575a.parseLong(templateInfo.ttid);
                mo27351a(effectInfoModel, str);
                C8735f.aMf().mo35136D(templateInfo);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo27353a(boolean z, QEffect qEffect) {
        if (C8538o.m24870c(qEffect, z) && this.cso != null && !this.cso.isPlaying()) {
            this.cso.aIB();
        }
    }

    /* access modifiers changed from: protected */
    public abstract void abA();

    /* access modifiers changed from: protected */
    public QSessionStream abB() {
        if (this.csu == null || this.css == null || this.csO == null) {
            return null;
        }
        return this.csu.mo27761a(this.css, 1, this.csD);
    }

    /* access modifiers changed from: protected */
    public int abC() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public int abD() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public int abE() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public boolean abF() {
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean abG() {
        return false;
    }

    /* access modifiers changed from: protected */
    public MSize abH() {
        return new MSize(Constants.getScreenSize().width, Constants.getScreenSize().width);
    }

    /* access modifiers changed from: protected */
    public void abI() {
    }

    /* access modifiers changed from: protected */
    public void abJ() {
        if (this.cst != null && this.cst.isAlive()) {
            this.cst.mo34156jm(true);
        }
    }

    /* access modifiers changed from: protected */
    public void abK() {
        LogUtils.m14223i("AdvanceBaseEditActivity_Log", ">>>>>>>>>>>> stopTrickPlay.");
        if (this.cst != null) {
            this.cst.aIq();
        }
    }

    /* access modifiers changed from: protected */
    public void abs() {
        if (this.csQ != null) {
            LayoutParams layoutParams = (LayoutParams) this.csQ.getLayoutParams();
            if (this.csr != null) {
                layoutParams.width = this.csr.width;
                layoutParams.height = this.csr.height;
            }
            this.csQ.setLayoutParams(layoutParams);
            this.csQ.invalidate();
        }
    }

    /* access modifiers changed from: protected */
    public void abt() {
        this.csN = (SurfaceView) findViewById(R.id.previewview);
        if (this.csN != null) {
            this.csN.setVisibility(0);
            this.csO = this.csN.getHolder();
            if (this.csO != null) {
                this.csO.addCallback(this);
                this.csO.setType(this.csM);
                this.csO.setFormat(this.csL);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void abu() {
        MSize mSize;
        if (this.css == null || this.css.width <= 0 || this.css.height <= 0) {
            VeMSize d = C8540q.m24946d(this.mStoryBoard, AppStateModel.getInstance().isCommunitySupport());
            if (d != null) {
                mSize = new MSize(d.width, d.height);
            } else {
                return;
            }
        } else {
            mSize = this.css;
        }
        if (mSize != null && mSize.width > 0 && mSize.height > 0) {
            VeMSize e = C8572y.m25090e(new VeMSize(mSize.width, mSize.height), new VeMSize(this.csr.width, this.csr.height));
            this.csP = new MSize(e.width, e.height);
            if (!(this.csP == null || this.bMj == null || this.csQ == null)) {
                LayoutParams layoutParams = new LayoutParams(this.csP.width, this.csP.height);
                layoutParams.addRule(13, 1);
                this.bMj.setLayoutParams(layoutParams);
                this.bMj.invalidate();
            }
            this.csx = true;
        }
    }

    /* access modifiers changed from: protected */
    public void abv() {
        if (this.csy) {
            if (this.cst != null) {
                this.cst.aIr();
            }
            this.csy = false;
        }
    }

    /* access modifiers changed from: protected */
    public int abw() {
        if (abx() != 0) {
            return 1;
        }
        aby();
        return 0;
    }

    /* access modifiers changed from: protected */
    public abstract void aby();

    /* access modifiers changed from: protected */
    public abstract boolean abz();

    /* renamed from: d */
    public void mo27372d(long j, int i) {
    }

    /* access modifiers changed from: protected */
    /* renamed from: dO */
    public void mo27373dO(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append(">>>>>>>>>>>> startTrickPlay.mXYMediaPlayer=");
        sb.append(this.cso);
        LogUtils.m14223i("AdvanceBaseEditActivity_Log", sb.toString());
        if (this.cst != null) {
            if (!this.cst.isAlive() || !this.cst.aIs()) {
                try {
                    this.cst.aIr();
                    this.cst.interrupt();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                this.cst = null;
            } else {
                this.cst.mo34156jm(false);
            }
        }
        if (this.cst == null) {
            this.cst = new C8425b(this.cso, z, this.csU);
            this.cst.start();
        }
        this.csw = false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public String mo27374f(ArrayList<C8441b> arrayList) {
        String str = "";
        if (arrayList == null || arrayList.size() <= 0) {
            return str;
        }
        C8441b bVar = (C8441b) arrayList.get(arrayList.size() - 1);
        return bVar != null ? bVar.aIf() : str;
    }

    /* access modifiers changed from: protected */
    public abstract int getPlayerInitTime();

    /* renamed from: j */
    public void mo27376j(Long l) {
    }

    /* renamed from: k */
    public void mo27377k(Long l) {
    }

    /* access modifiers changed from: protected */
    /* renamed from: ks */
    public abstract int mo27378ks(int i);

    /* access modifiers changed from: protected */
    /* renamed from: kt */
    public abstract int mo27379kt(int i);

    /* access modifiers changed from: protected */
    /* renamed from: ku */
    public abstract int mo27380ku(int i);

    /* access modifiers changed from: protected */
    /* renamed from: kv */
    public abstract int mo27381kv(int i);

    /* renamed from: l */
    public void mo27382l(Long l) {
    }

    /* renamed from: m */
    public void mo27383m(Long l) {
    }

    /* renamed from: n */
    public void mo27384n(Long l) {
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C8567u.setContext(getApplicationContext());
        C8553i.setContext(getApplicationContext());
        C8553i.m25005ut(23);
        if (!SDCardManager.hasSDCard()) {
            abA();
            finish();
            return;
        }
        setVolumeControlStream(3);
        this.csD = AppPreferencesSetting.getInstance().getAppSettingBoolean("pref_encode", false) ? 4 : 2;
        this.bMw = getIntent().getLongExtra(CommonParams.INTENT_MAGIC_CODE, 0);
        StringBuilder sb = new StringBuilder();
        sb.append("MagicCode:");
        sb.append(this.bMw);
        LogUtils.m14223i("AdvanceBaseEditActivity_Log", sb.toString());
        this.bOK = C8501a.aJs();
        if (this.bOK == null) {
            abA();
            finish();
            return;
        }
        this.csK = 0;
        this.csG = getIntent().getBooleanExtra("intent_simple_edit_key", false);
        this.csJ = (TODOParamModel) getIntent().getParcelableExtra(TodoConstants.KEY_TODOCODE_PARAM_MODEL);
        this.bMM = C8522g.aJA();
        if (this.bMM == null) {
            abA();
            finish();
            return;
        }
        this.csq = this.bMM.aJI();
        this.csp = (C5530d) MagicCode.getMagicParam(this.bMw, "AppRunningMode", new C5530d());
        if (this.csp != null) {
            this.csj = this.csp.cnU;
        }
        this.csr = abH();
        if (abw() != 0) {
            abA();
            finish();
            return;
        }
        this.mTemplateId = getIntent().getLongExtra(GalleryRouter.INTENT_KEY_TEMPLATE_ID, 0);
        this.bOW = new C8703d(this, this.csV);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        if (this.csT != null) {
            this.csT.removeCallbacksAndMessages(null);
            this.csT = null;
        }
        if (this.cso != null) {
            this.cso.aIv();
            this.cso = null;
        }
        if (this.bOW != null) {
            this.bOW.mo35076VD();
        }
        this.mStoryBoard = null;
        this.mClipModelCacheList = null;
        this.csp = null;
        this.bOK = null;
        this.bMM = null;
        this.csr = null;
        this.css = null;
        this.cst = null;
        this.csu = null;
        this.csN = null;
        this.csO = null;
        this.csP = null;
        this.bMj = null;
        this.csQ = null;
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        UserBehaviorLog.onPause(this);
        if (this.csT != null) {
            this.csT.removeMessages(AdError.SHOW_CALLED_BEFORE_LOAD_ERROR_CODE);
        }
        C8345d.m24060R(VivaBaseApplication.m8749FZ(), "AppIsBusy", String.valueOf(false));
        if (isFinishing()) {
            abK();
            if (this.cst != null) {
                this.cst.aIr();
                this.cst = null;
            }
            if (this.cso != null) {
                this.cso.aIv();
                this.cso = null;
            }
        }
        this.csF = true;
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        UserBehaviorLog.onResume(this);
        C8345d.m24060R(VivaBaseApplication.m8749FZ(), "AppIsBusy", String.valueOf(true));
        this.csF = false;
        if (this.csT != null) {
            this.csT.removeMessages(AdError.SHOW_CALLED_BEFORE_LOAD_ERROR_CODE);
            this.csT.sendEmptyMessageDelayed(AdError.SHOW_CALLED_BEFORE_LOAD_ERROR_CODE, 20000);
        }
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        LogUtils.m14223i("AdvanceBaseEditActivity_Log", "surfaceChanged");
        if (!abz()) {
            this.csO = surfaceHolder;
            if (this.csT != null && !this.csF) {
                this.csT.removeMessages(TodoConstants.TODO_TYPE_QA_TEST);
                this.csT.sendMessageDelayed(this.csT.obtainMessage(TodoConstants.TODO_TYPE_QA_TEST), 50);
            }
        }
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        LogUtils.m14223i("AdvanceBaseEditActivity_Log", "surfaceCreated");
        this.csO = surfaceHolder;
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        LogUtils.m14223i("AdvanceBaseEditActivity_Log", "surfaceDestroyed");
    }
}
