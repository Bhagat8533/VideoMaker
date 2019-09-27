package com.introvd.template.editor.effects.bubble.subtitle;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.text.TextUtils;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.afollestad.materialdialogs.C1885b;
import com.afollestad.materialdialogs.C1890f;
import com.afollestad.materialdialogs.C1890f.C1904j;
import com.introvd.template.ads.listener.VideoRewardListener;
import com.introvd.template.app.p177b.C3742b;
import com.introvd.template.common.Constants;
import com.introvd.template.common.FileUtils;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.common.MSize;
import com.introvd.template.common.ToastUtils;
import com.introvd.template.common.model.Range;
import com.introvd.template.crash.C5523b;
import com.introvd.template.editor.R;
import com.introvd.template.editor.base.BaseVipOperationView;
import com.introvd.template.editor.common.C5837a;
import com.introvd.template.editor.common.terminator.Terminator;
import com.introvd.template.editor.common.terminator.Terminator.C5858a;
import com.introvd.template.editor.effects.C5896a;
import com.introvd.template.editor.effects.C5910b;
import com.introvd.template.editor.effects.PlayerFakeView;
import com.introvd.template.editor.effects.PlayerFakeView.C5889a;
import com.introvd.template.editor.effects.PlayerFakeView.C5892d;
import com.introvd.template.editor.effects.VideoEditorSeekLayout;
import com.introvd.template.editor.effects.bubble.subtitle.p256a.C6001a;
import com.introvd.template.editor.effects.bubble.subtitle.p256a.C6002b;
import com.introvd.template.editor.effects.nav.C6185b;
import com.introvd.template.editor.effects.nav.NavEffectTitleLayout;
import com.introvd.template.editor.effects.p253a.C5900b;
import com.introvd.template.editor.effects.p253a.C5909e;
import com.introvd.template.editor.p246c.C5687a;
import com.introvd.template.editor.p246c.C5688b;
import com.introvd.template.editor.p259f.C6280b;
import com.introvd.template.editor.p266h.C6386d;
import com.introvd.template.editor.player.p267a.C6485b;
import com.introvd.template.editor.widget.scalerotate.ScaleRotateView;
import com.introvd.template.editor.widget.scalerotate.ScaleRotateView.C7061a;
import com.introvd.template.editor.widget.scalerotate.p295a.C7066b;
import com.introvd.template.editor.widget.scalerotate.p295a.C7069d;
import com.introvd.template.editor.widget.timeline.C7124b;
import com.introvd.template.module.iap.C8049f;
import com.introvd.template.module.iap.business.C7870d;
import com.introvd.template.module.iap.business.C7870d.C7873a;
import com.introvd.template.module.iap.business.p349a.C7825a;
import com.introvd.template.module.iap.business.p356e.C7897a;
import com.introvd.template.module.p326ad.p327a.C7589a;
import com.introvd.template.module.p326ad.p328b.C7593c;
import com.introvd.template.module.p326ad.p328b.C7594d;
import com.introvd.template.p203b.C4580b;
import com.introvd.template.p203b.C4586g;
import com.introvd.template.p203b.C4600l;
import com.introvd.template.p203b.p204a.C4576e;
import com.introvd.template.p203b.p204a.C4577f;
import com.introvd.template.p414ui.dialog.C8978m;
import com.introvd.template.router.PassThoughUrlGenerator;
import com.introvd.template.router.editor.EditorIntentInfo;
import com.introvd.template.router.editor.EditorRouter;
import com.introvd.template.router.iap.IapRTConstants;
import com.introvd.template.router.template.TemplateRouter;
import com.introvd.template.sdk.editor.cache.C8441b;
import com.introvd.template.sdk.model.TemplateConditionModel;
import com.introvd.template.sdk.model.editor.EffectInfoModel;
import com.introvd.template.sdk.model.editor.ScaleRotateViewState;
import com.introvd.template.sdk.model.editor.TextBubbleInfo.TextBubble;
import com.introvd.template.sdk.model.template.RollInfo;
import com.introvd.template.sdk.model.template.TemplateInfo;
import com.introvd.template.sdk.p383c.C8399c;
import com.introvd.template.sdk.p391g.C8450a;
import com.introvd.template.template.download.C8702c;
import com.introvd.template.template.download.C8703d;
import com.introvd.template.template.download.C8708f;
import com.introvd.template.template.p407e.C8735f;
import com.introvd.template.template.p407e.C8739i;
import com.introvd.template.template.p407e.C8745n;
import com.introvd.template.template.p409g.C8759b;
import com.introvd.template.template.p409g.C8762d;
import com.p131c.p132a.C2561a;
import com.p131c.p132a.p135c.C2575a;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.greenrobot.eventbus.C10021c;
import org.greenrobot.eventbus.C10031j;
import org.greenrobot.eventbus.ThreadMode;
import p037b.p050b.C1834l;
import p037b.p050b.C1838m;
import p037b.p050b.C1839n;
import p037b.p050b.C1842q;
import p037b.p050b.p051a.p053b.C1487a;
import p037b.p050b.p054b.C1494a;
import p037b.p050b.p054b.C1495b;
import p037b.p050b.p057e.C1517e;
import p503cz.msebera.android.httpclient.HttpStatus;
import xiaoying.engine.clip.QClip;

@SuppressLint({"ViewConstructor"})
public class SubtitleOperationView extends BaseVipOperationView<C6028f> implements VideoRewardListener, C6001a {
    public volatile long bNB = 0;
    private C7870d bNG;
    private C8703d bOW = null;
    private RelativeLayout bof;
    public int cGU = 2;
    public int cGV = 0;
    private NavEffectTitleLayout cGW;
    private TextView cGX;
    /* access modifiers changed from: private */
    public PlayerFakeView cGY;
    private C7124b cGq = new C7124b() {
        /* renamed from: a */
        public boolean mo28344a(int i, Range range) {
            StringBuilder sb = new StringBuilder();
            sb.append("onUpdateRange = index = ");
            sb.append(i);
            sb.append(", range = ");
            sb.append(range);
            LogUtilsV2.m14227d(sb.toString());
            SubtitleOperationView.this.m16871d(range);
            return false;
        }

        public void acd() {
            LogUtilsV2.m14227d("onEndSeek = ");
            ((C6028f) SubtitleOperationView.this.getEditor()).aeb();
            if ((SubtitleOperationView.this.cGU == 1 || SubtitleOperationView.this.cGU == 3) && !SubtitleOperationView.this.cyJ.aiO()) {
                SubtitleOperationView.this.ajr();
            }
        }

        /* renamed from: dY */
        public void mo28347dY(boolean z) {
            LogUtilsV2.m14227d("onStartDrag = ");
        }

        /* renamed from: iD */
        public void mo28349iD(int i) {
            StringBuilder sb = new StringBuilder();
            sb.append("progress = ");
            sb.append(i);
            LogUtilsV2.m14227d(sb.toString());
            ((C6028f) SubtitleOperationView.this.getEditor()).mo27874kY(i);
            if (SubtitleOperationView.this.cHe != null) {
                SubtitleOperationView.this.cHe.mo28494cA(i, ((C6028f) SubtitleOperationView.this.getEditor()).getCurrentEditEffectIndex());
            }
        }

        /* renamed from: kz */
        public void mo28352kz(int i) {
            ((C6028f) SubtitleOperationView.this.getEditor()).adX();
            ((C6028f) SubtitleOperationView.this.getEditor()).aea();
            if (SubtitleOperationView.this.cyJ != null) {
                C6031g.m17097A(SubtitleOperationView.this.getContext(), SubtitleOperationView.this.cyJ.acx());
            }
            StringBuilder sb = new StringBuilder();
            sb.append("onStartSeek = ");
            sb.append(i);
            LogUtilsV2.m14227d(sb.toString());
        }
    };
    private String cHc = "";
    private String cHd = "";
    /* access modifiers changed from: private */
    public C5900b cHe;
    /* access modifiers changed from: private */
    public AtomicBoolean cIc = new AtomicBoolean(false);
    private View cId;
    private ImageView cIe;
    /* access modifiers changed from: private */
    public C6035i cIf;
    private ScaleRotateViewState cIg;
    private int cIh = 0;
    private boolean cIi = false;
    /* access modifiers changed from: private */
    public C6002b cIj;
    /* access modifiers changed from: private */
    public C1838m<ScaleRotateViewState> cIk;
    /* access modifiers changed from: private */
    public C1495b cIl;
    private final C6008c cIm = new C6008c() {
        /* renamed from: O */
        public void mo28656O(int i, boolean z) {
            ScaleRotateViewState scaleViewState = SubtitleOperationView.this.cGY.getScaleRotateView().getScaleViewState();
            if (!TextUtils.isEmpty(scaleViewState.mStylePath)) {
                if (i == 0) {
                    TextBubble textBubble = scaleViewState.getTextBubble();
                    if (!(textBubble == null || textBubble.mShadowInfo == null || !(textBubble.mShadowInfo.isbEnableShadow() ^ z))) {
                        textBubble.mShadowInfo.setbEnableShadow(z);
                    }
                } else if (i == 1) {
                    scaleViewState.setAnimOn(z);
                }
                SubtitleOperationView.this.cGY.mo28360d(scaleViewState);
            }
        }

        /* renamed from: a */
        public boolean mo28657a(RollInfo rollInfo) {
            if (rollInfo != null) {
                SubtitleOperationView.this.m16870c(rollInfo);
            }
            return false;
        }

        public void ace() {
            TemplateRouter.startTemplateInfoActivity(SubtitleOperationView.this.getActivity(), C8399c.edb);
        }

        public ScaleRotateViewState ajD() {
            if (SubtitleOperationView.this.cGY == null || SubtitleOperationView.this.cGY.getScaleRotateView() == null) {
                return null;
            }
            return SubtitleOperationView.this.cGY.getScaleRotateView().getScaleViewState();
        }

        /* renamed from: b */
        public void mo28660b(EffectInfoModel effectInfoModel) {
            if (effectInfoModel != null) {
                SubtitleOperationView.this.bNB = effectInfoModel.mTemplateId;
                SubtitleOperationView.this.mo28639a(effectInfoModel, "type_roll");
            }
        }

        /* renamed from: fl */
        public void mo28661fl(boolean z) {
            if (SubtitleOperationView.this.cGY != null) {
                SubtitleOperationView.this.cGY.setQuickPositionPanelVisibility(z);
            }
        }

        /* renamed from: hf */
        public void mo28662hf(String str) {
            ScaleRotateViewState scaleViewState = SubtitleOperationView.this.cGY.getScaleRotateView().getScaleViewState();
            if (scaleViewState != null && !TextUtils.isEmpty(scaleViewState.mStylePath)) {
                scaleViewState.setFontPath(str);
                SubtitleOperationView.this.cGY.mo28360d(scaleViewState);
                C6031g.m17116eF(SubtitleOperationView.this.getContext());
            }
        }

        /* renamed from: j */
        public void mo28663j(String str, boolean z) {
            StringBuilder sb = new StringBuilder();
            sb.append("onItemClicked = style = ");
            sb.append(str);
            sb.append(", isPreview = ");
            sb.append(z);
            LogUtilsV2.m14227d(sb.toString());
            boolean z2 = SubtitleOperationView.this.cIc.get();
            String aa = C8762d.aMt().mo35224aa(str, C8450a.m24471c(Constants.getLocale()));
            if (SubtitleOperationView.this.cIf != null) {
                RollInfo ajv = SubtitleOperationView.this.cIf.ajv();
                if (z) {
                    if (!(ajv == null || ajv.rollModel == null)) {
                        C6031g.m17113d(SubtitleOperationView.this.getContext(), aa, ajv.rollModel.rollCode, z2);
                    }
                    if (z2) {
                        C6031g.m17107bd(SubtitleOperationView.this.getContext(), "manual");
                    }
                } else if (!(ajv == null || ajv.rollModel == null)) {
                    C6031g.m17119t(SubtitleOperationView.this.getContext(), aa, ajv.rollModel.rollCode);
                }
            }
            SubtitleOperationView.this.m16855TN();
            SubtitleOperationView.this.m16878hc(str);
        }

        /* renamed from: k */
        public void mo28664k(int i, int i2, boolean z) {
            ScaleRotateViewState scaleViewState = SubtitleOperationView.this.cGY.getScaleRotateView().getScaleViewState();
            if (scaleViewState != null && !TextUtils.isEmpty(scaleViewState.mStylePath)) {
                if (i == 0) {
                    scaleViewState.setTextColor(i2);
                } else if (i == 1) {
                    TextBubble textBubble = scaleViewState.getTextBubble();
                    if (!(textBubble == null || textBubble.mStrokeInfo == null)) {
                        textBubble.mStrokeInfo.strokeColor = i2;
                    }
                }
                if (SubtitleOperationView.this.cIk != null) {
                    SubtitleOperationView.this.cIk.mo9791K(scaleViewState);
                }
            }
        }

        /* renamed from: mA */
        public void mo28665mA(int i) {
            ScaleRotateViewState scaleViewState = SubtitleOperationView.this.cGY.getScaleRotateView().getScaleViewState();
            if (scaleViewState != null && !TextUtils.isEmpty(scaleViewState.mStylePath)) {
                TextBubble textBubble = scaleViewState.getTextBubble();
                if (textBubble != null) {
                    textBubble.mTextAlignment = i;
                    SubtitleOperationView.this.cGY.mo28360d(scaleViewState);
                }
            }
        }

        /* renamed from: mB */
        public void mo28666mB(int i) {
            if (SubtitleOperationView.this.cGY != null && SubtitleOperationView.this.cGY.getScaleRotateView() != null) {
                int i2 = 2;
                int i3 = 0;
                switch (i) {
                    case 0:
                        i2 = -2;
                        break;
                    case 1:
                        i2 = 0;
                        i3 = -2;
                        break;
                    case 2:
                        i2 = 0;
                        i3 = 2;
                        break;
                    case 3:
                        break;
                    default:
                        i2 = 0;
                        break;
                }
                SubtitleOperationView.this.cGY.getScaleRotateView().mo31001E(3, i3, i2);
            }
        }

        /* renamed from: my */
        public void mo28667my(int i) {
            ((C6028f) SubtitleOperationView.this.getEditor()).adX();
            C6031g.m17098B(SubtitleOperationView.this.getActivity(), SubtitleOperationView.this.cIc.get());
            boolean z = false;
            if (SubtitleOperationView.this.cIc.get()) {
                C8441b p = SubtitleOperationView.this.ajO();
                if (p != null) {
                    SubtitleOperationView.this.cGY.mo28360d(p.aIg());
                }
                SubtitleOperationView.this.cGY.getScaleRotateView().mo31012hM(false);
                SubtitleOperationView.this.cGY.getScaleRotateView().mo31006eh(false);
                SubtitleOperationView.this.cIc.set(false);
            }
            PlayerFakeView a = SubtitleOperationView.this.cGY;
            if (i == 3) {
                z = true;
            }
            a.setQuickPositionPanelVisibility(z);
        }

        /* renamed from: mz */
        public void mo28668mz(int i) {
            ScaleRotateViewState scaleViewState = SubtitleOperationView.this.cGY.getScaleRotateView().getScaleViewState();
            if (scaleViewState != null && !TextUtils.isEmpty(scaleViewState.mStylePath)) {
                TextBubble textBubble = scaleViewState.getTextBubble();
                if (!(textBubble == null || textBubble.mStrokeInfo == null)) {
                    textBubble.mStrokeInfo.strokeWPersent = ((float) i) * 0.005f;
                    SubtitleOperationView.this.cGY.mo28360d(scaleViewState);
                }
            }
        }
    };
    private C7061a cIn = new C7061a() {
        /* renamed from: A */
        public void mo28669A(MotionEvent motionEvent) {
        }

        /* renamed from: B */
        public void mo28670B(MotionEvent motionEvent) {
        }

        /* renamed from: G */
        public void mo28671G(MotionEvent motionEvent) {
            if (!(SubtitleOperationView.this.cGY == null || SubtitleOperationView.this.cGY.getScaleRotateView() == null || SubtitleOperationView.this.cGY.getScaleRotateView().getScaleViewState() == null || SubtitleOperationView.this.cIj == null)) {
                SubtitleOperationView.this.cIj.mo28683a(SubtitleOperationView.this.getContext(), SubtitleOperationView.this.cGY.getScaleRotateView().getScaleViewState(), motionEvent);
            }
        }

        public void ada() {
        }

        /* renamed from: ei */
        public void mo28673ei(boolean z) {
        }

        /* renamed from: ej */
        public void mo28674ej(boolean z) {
        }
    };
    private C1494a compositeDisposable = new C1494a();
    private C8708f csV = new C8702c() {
        /* renamed from: c */
        public void mo24952c(long j, int i) {
            SubtitleOperationView.this.mo28642d(j, i);
        }

        /* renamed from: c */
        public void mo24953c(Long l) {
            SubtitleOperationView.this.mo28646m(l);
            if (l.longValue() == SubtitleOperationView.this.bNB) {
                SubtitleOperationView.this.mo28647n(l);
                SubtitleOperationView.this.bNB = -1;
            }
        }
    };
    /* access modifiers changed from: private */
    public boolean ctR = true;
    private RollInfo ctW = null;
    private Terminator czM;
    private C4576e czk;
    private String mFontPath = "";
    private int mTODOCode = 0;

    public SubtitleOperationView(Activity activity) {
        super(activity, C6028f.class);
        this.compositeDisposable.mo9785e(C1834l.m5254a((C1839n<T>) new C1839n<ScaleRotateViewState>() {
            /* renamed from: a */
            public void mo10177a(C1838m<ScaleRotateViewState> mVar) throws Exception {
                SubtitleOperationView.this.cIk = mVar;
            }
        }).mo10157d(C1487a.aUa()).mo10165f(300, TimeUnit.MILLISECONDS, C1487a.aUa()).mo10152c(C1487a.aUa()).mo10168g((C1517e<? super T>) new C1517e<ScaleRotateViewState>() {
            /* renamed from: h */
            public void accept(ScaleRotateViewState scaleRotateViewState) throws Exception {
                if (SubtitleOperationView.this.cGY != null && scaleRotateViewState != null) {
                    SubtitleOperationView.this.cGY.mo28360d(scaleRotateViewState);
                }
            }
        }));
    }

    /* renamed from: Oj */
    private void m16849Oj() {
        this.bof = (RelativeLayout) findViewById(R.id.rl_subtitle_root_layout);
        this.cGY = (PlayerFakeView) findViewById(R.id.ve_subtitle_transparent_fake_view);
        this.cGY.mo28354a(((C6028f) getEditor()).adN(), ((C6028f) getEditor()).getSurfaceSize(), true, 3);
        this.cGY.setEnableFlip(false);
        if (((C6028f) getEditor()).getSurfaceSize() != null && ((C6028f) getEditor()).getSurfaceSize().equals(C7066b.auS().getSurfaceSize())) {
            LogUtilsV2.m14227d("clearMemory------------> because of surfaceSize change,and subtitle need new surfaceSize");
            C7066b.auS().clearMemory();
            C7066b.auS().mo31046g(((C6028f) getEditor()).getSurfaceSize());
        }
        this.cGY.setScaleRotateViewDecoder(new C7069d(((C6028f) getEditor()).getSurfaceSize()));
        this.cGY.setOnDelListener(new C5889a() {
            public void aan() {
                if (SubtitleOperationView.this.cGU == 2) {
                    SubtitleOperationView.this.cGY.adl();
                    ((C6028f) SubtitleOperationView.this.getEditor()).aiS();
                    return;
                }
                SubtitleOperationView.this.ajG();
            }
        });
        this.cGY.setOnReplaceListener(new C5892d() {
            public void aiI() {
                SubtitleOperationView.this.m16887ms(5);
                SubtitleOperationView.this.ajF();
            }

            public void aiK() {
                if (!TextUtils.isEmpty(((C6028f) SubtitleOperationView.this.getEditor()).mo28479gX(SubtitleOperationView.this.cGY.getScaleRotateView().getScaleViewState().mStylePath))) {
                    C6031g.m17117eG(SubtitleOperationView.this.getContext());
                }
            }
        });
        this.cGY.setGestureListener(this.cIn);
        this.cGX = (TextView) findViewById(R.id.tv_subtitle_op_btn);
        this.cIe = (ImageView) findViewById(R.id.iv_subtitle_op_left_btn);
        this.cIe.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                SubtitleOperationView.this.ajJ();
            }
        });
        this.cGX.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (SubtitleOperationView.this.cHe != null) {
                    SubtitleOperationView.this.cHe.akS();
                }
                SubtitleOperationView.this.aji();
            }
        });
        ajb();
        aiW();
    }

    /* access modifiers changed from: private */
    /* renamed from: TN */
    public void m16855TN() {
        if (this.cIf != null && !this.cyH) {
            RollInfo ajv = this.cIf.ajv();
            if (ajv == null) {
                C4577f.m11629e(this.czk);
                return;
            }
            if (!C8049f.aBf().mo33101iL(ajv.ttid)) {
                C4577f.m11629e(this.czk);
            } else if (!C4577f.m11630i(this.czk)) {
                this.czk = C4577f.m11623a((Context) getActivity(), (View) this, this.cIf.ajQ() ? "animated_text" : "effects", -1);
                C7897a.m23022b(ajv.ttid, "Iap_Purchase_Template_Id", new String[0]);
            }
        }
    }

    private void aiT() {
        int i = getBundle().getInt("ve_extra_effect_id", -1);
        QClip dataClip = ((C6028f) getEditor()).adO().getDataClip();
        boolean z = dataClip != null && dataClip.getEffectCountByGroup(2, 3) > 0 && !C5837a.agH().agK();
        if (i >= 0) {
            m16875fn(true);
        } else if (z) {
            m16875fn(true);
            m16887ms(1);
            this.compositeDisposable.mo9785e(C1487a.aUa().mo9777a(new Runnable() {
                public void run() {
                    SubtitleOperationView.this.ajr();
                }
            }, 300, TimeUnit.MILLISECONDS));
        } else {
            aiU();
            m16875fn(false);
            m16887ms(2);
        }
    }

    private void aiU() {
        EditorIntentInfo editorIntentInfo = (EditorIntentInfo) PassThoughUrlGenerator.getInfoFromBundle(getBundle(), EditorIntentInfo.class);
        if (editorIntentInfo != null) {
            String str = (String) editorIntentInfo.paramMap.get(EditorRouter.MAP_PARAMS_EVENT_ID);
            if (!TextUtils.isEmpty(str) && TextUtils.isDigitsOnly(str)) {
                int parseInt = C2575a.parseInt(str);
                String str2 = (String) editorIntentInfo.paramMap.get(EditorRouter.MAP_PARAMS_TEMPLATE_ID);
                String str3 = (String) editorIntentInfo.paramMap.get(EditorRouter.MAP_PARAMS_TEMPLATE_PATH);
                String str4 = (String) editorIntentInfo.paramMap.get(EditorRouter.MAP_PARAMS_TEMPLATE_ROLL_ID);
                switch (parseInt) {
                    case 1:
                        if (TextUtils.isEmpty(str3)) {
                            str3 = C8762d.aMt().mo35225bB(C2575a.m7391rq(str2));
                        }
                        this.cHc = str3;
                        break;
                    case 2:
                        this.mTODOCode = parseInt;
                        if (!TextUtils.isEmpty(str3)) {
                            this.mFontPath = str3;
                            break;
                        }
                        break;
                    case 3:
                        this.mTODOCode = parseInt;
                        break;
                    case 4:
                        this.mTODOCode = parseInt;
                        if (!TextUtils.isEmpty(str4)) {
                            this.cHd = str4;
                            editorIntentInfo.paramMap.remove(EditorRouter.MAP_PARAMS_TEMPLATE_ROLL_ID);
                            break;
                        }
                        break;
                }
            }
        }
    }

    private void aiV() {
        if (C5837a.agH().agN() && !C2561a.aON()) {
            C5900b bVar = new C5900b(getActivity(), this.cyJ, this.cGY, (C5896a) getEditor(), new C5909e() {
                public int ajt() {
                    return ((C6028f) SubtitleOperationView.this.getEditor()).getCurrentEditEffectIndex();
                }

                public void aju() {
                }

                /* renamed from: fh */
                public void mo28513fh(boolean z) {
                    SubtitleOperationView.this.mo27844et(z);
                }
            });
            this.cHe = bVar;
            ImageView eS = this.cHe.mo28496eS(getContext());
            ImageView eT = this.cHe.mo28497eT(getContext());
            if (eS != null && (this.cGX.getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.cGX.getParent()).addView(eS);
                ((ViewGroup) this.cGX.getParent()).addView(eT);
            }
        }
    }

    private void aiW() {
        this.cyJ = (VideoEditorSeekLayout) findViewById(R.id.ve_subtitle_seek_layout);
        this.cyJ.setOnOperationCallback(getVideoOperator());
        this.cyJ.setmOnTimeLineSeekListener(this.cGq);
        this.cyJ.setOnVideoEditorSeekListener(new C5910b() {
            public void aav() {
                SubtitleOperationView.this.aiZ();
            }

            public void pauseVideo() {
                SubtitleOperationView.this.aiY();
            }
        });
    }

    private void aiX() {
        this.cyJ.mo28397a(getEditor(), ((C6028f) getEditor()).aiz());
        this.cyJ.setMaskDrawable(getResources().getDrawable(R.color.color_03A62B_p30));
        this.cyJ.setTrimMaskDrawable(getResources().getDrawable(R.color.color_03A62B_p50));
        this.cyJ.mo28392J(((C6028f) getEditor()).adZ(), false);
    }

    /* access modifiers changed from: private */
    public void aiY() {
        ((C6028f) getEditor()).adX();
        if (this.cGU != 4) {
            ajr();
        }
    }

    /* access modifiers changed from: private */
    public void aiZ() {
        if (getEditor() != null) {
            if (this.cGU == 3) {
                ((C6028f) getEditor()).mo28727a(getCurrentEditEffectIndex(), this.cGY.getScaleRotateView().getScaleViewState(), this.cyJ.getmEffectKeyFrameRangeList());
                ajl();
            }
            ((C6028f) getEditor()).adY();
        }
    }

    /* access modifiers changed from: private */
    public void ajF() {
        if (getEditor() != null) {
            C8441b mg = ((C6028f) getEditor()).mo28483mg(getCurrentEditEffectIndex());
            if (mg != null && this.cIf != null) {
                String aIf = mg.aIf();
                if (mg.aIg() != null) {
                    String textFontPath = mg.aIg().getTextFontPath();
                    this.cIf.mo28762go(aIf);
                    this.cIf.mo28764gu(textFontPath);
                    this.cIf.add();
                    this.cIf.mo28756ek(true);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void ajG() {
        if (getEditor() != null && getCurrentEditEffectIndex() >= 0 && this.cyJ != null && this.cGY != null && this.cGY.getScaleRotateView() != null && this.cGY.getScaleRotateView().getScaleViewState() != null) {
            String gX = ((C6028f) getEditor()).mo28479gX(this.cGY.getScaleRotateView().getScaleViewState().mStylePath);
            if (!TextUtils.isEmpty(gX)) {
                C6031g.m17105bb(getContext(), gX);
            }
            if (this.cHe != null) {
                this.cHe.mo28498mn(getCurrentEditEffectIndex());
            }
            ((C6028f) getEditor()).mo28739mr(getCurrentEditEffectIndex());
            ((C6028f) getEditor()).mo27873h(0, ((C6028f) getEditor()).adO().getDuration(), false);
            this.cyJ.mo28426ml(getCurrentEditEffectIndex());
            this.cyJ.aiL();
            this.cGY.adl();
            ((C6028f) getEditor()).mo28738mq(-1);
            ((C6028f) getEditor()).aiS();
            m16887ms(1);
        }
    }

    /* access modifiers changed from: private */
    public void ajH() {
        if (this.cIf != null) {
            this.cIf.mo28761fq(false);
        }
        if (this.cGY != null) {
            this.cGY.setQuickPositionPanelVisibility(false);
        }
    }

    private void ajI() {
        if (this.cIc.get()) {
            C8441b ajO = ajO();
            if (ajO != null) {
                this.cGY.mo28360d(ajO.aIg());
            }
            this.cIc.set(false);
        }
        this.cGY.getScaleRotateView().mo31012hM(true);
        this.cGY.getScaleRotateView().mo31006eh(true);
        m16887ms(this.cGV);
    }

    /* access modifiers changed from: private */
    public void ajJ() {
        switch (this.cGU) {
            case 4:
                ajN();
                return;
            default:
                return;
        }
    }

    private C8441b ajK() {
        C8441b bVar;
        if (this.cIc.get()) {
            bVar = ajO();
            this.cIc.set(false);
        } else {
            bVar = null;
        }
        C8441b f = ((C6028f) getEditor()).mo28735f(bVar != null ? bVar.aIg() : this.cGY.getScaleRotateView().getScaleViewState());
        if (f == null) {
            return null;
        }
        this.cyJ.mo28414cx(f.aIc().getmPosition(), f.aIc().getmPosition() + f.aIc().getmTimeLength());
        return f;
    }

    private boolean ajL() {
        if (this.cIc.get()) {
            ajO();
            this.cIc.set(false);
        }
        int i = this.cGV;
        if (i == 0 || i == 2) {
            finish();
            return true;
        }
        this.cGY.getScaleRotateView().mo31012hM(true);
        this.cGY.getScaleRotateView().mo31006eh(true);
        m16887ms(this.cGV);
        return true;
    }

    /* access modifiers changed from: private */
    public void ajM() {
        if (getVideoOperator() != null && this.cyJ != null) {
            this.cIg = ((C6028f) getEditor()).mo28483mg(((C6028f) getEditor()).aiA()).aIg();
            ((C6028f) getEditor()).adX();
            ((C6028f) getEditor()).mo27870ep(true);
            Range addingRange = this.cyJ.getAddingRange();
            Range range = new Range(addingRange.getmPosition(), addingRange.getmTimeLength());
            ((C6028f) getEditor()).mo28726a(((C6028f) getEditor()).aiA(), range, this.cyJ.getmEffectKeyFrameRangeList());
            this.cyJ.mo28413c(range);
            this.cyJ.aiL();
            m16887ms(1);
        }
    }

    private void ajN() {
        if (getEditor() != null && this.cyJ != null) {
            ((C6028f) getEditor()).adX();
            ((C6028f) getEditor()).mo27870ep(true);
            Range addingRange = this.cyJ.getAddingRange();
            ((C6028f) getEditor()).mo27868b(0, ((C6028f) getEditor()).adO().getDuration(), false, addingRange == null ? 0 : addingRange.getmPosition());
            int aiA = ((C6028f) getEditor()).aiA();
            if (this.cHe != null) {
                this.cHe.mo28498mn(getCurrentEditEffectIndex());
            }
            ((C6028f) getEditor()).mo28739mr(aiA);
            this.cyJ.aiL();
            m16887ms(1);
        }
    }

    /* access modifiers changed from: private */
    public C8441b ajO() {
        int aiA = ((C6028f) getEditor()).aiA();
        C8441b mg = ((C6028f) getEditor()).mo28483mg(((C6028f) getEditor()).aiA());
        if (this.cHe != null) {
            this.cHe.mo28498mn(aiA);
        }
        ((C6028f) getEditor()).mo28739mr(aiA);
        ((C6028f) getEditor()).mo27868b(0, ((C6028f) getEditor()).adO().getDuration(), false, ((C6028f) getEditor()).aiR());
        return mg;
    }

    private void ajb() {
        this.czM = (Terminator) findViewById(R.id.terminator);
        this.czM.setTitle(R.string.xiaoying_str_ve_subtitle_title);
        try {
            this.cId = LayoutInflater.from(getContext()).inflate(R.layout.editor_effect_subtitle_bottom_tab_layout, null);
        } catch (InflateException e) {
            C5523b.logException(e);
            try {
                this.cId = LayoutInflater.from(getContext()).inflate(R.layout.editor_effect_subtitle_bottom_tab_layout, null);
            } catch (InflateException e2) {
                C5523b.logException(e2);
            }
        }
        this.czM.setTitleContentLayout(this.cId);
        this.czM.setTerminatorListener(new C5858a() {
            public void aeW() {
                SubtitleOperationView.this.ajH();
                SubtitleOperationView.this.ajf();
            }

            public void aeX() {
                SubtitleOperationView.this.ajH();
                SubtitleOperationView.this.ajc();
            }
        });
    }

    /* access modifiers changed from: private */
    public void ajc() {
        if (!C4580b.m11664ig(HttpStatus.SC_INTERNAL_SERVER_ERROR)) {
            switch (this.cGU) {
                case 1:
                    if (!aeG()) {
                        if (!(getContext() == null || getEditor() == null)) {
                            C6031g.m17099a(getContext(), (C5896a) getEditor(), this.cIh);
                        }
                        finish();
                        break;
                    } else {
                        return;
                    }
                case 2:
                    if (!ajs()) {
                        boolean z = this.cIc.get();
                        C8441b ajK = ajK();
                        if (ajK == null) {
                            finish();
                            break;
                        } else {
                            m16887ms(4);
                            long templateID = C8762d.aMt().getTemplateID(ajK.aIf());
                            String aa = C8762d.aMt().mo35224aa(ajK.aIf(), C8450a.m24471c(Constants.getLocale()));
                            boolean bk = C8450a.m24466bk(templateID);
                            C6031g.m17100a(getContext(), aa, bk, C8450a.m24469bn(templateID));
                            if (bk) {
                                C6031g.m17112c(getContext(), z, this.cIi);
                                this.cIi = false;
                                break;
                            }
                        }
                    } else {
                        return;
                    }
                    break;
                case 3:
                    if (!aeG()) {
                        ((C6028f) getEditor()).mo28727a(getCurrentEditEffectIndex(), this.cGY.getScaleRotateView().getScaleViewState(), this.cyJ.getmEffectKeyFrameRangeList());
                        finish();
                        break;
                    } else {
                        return;
                    }
                case 4:
                    ajM();
                    break;
                case 5:
                    if (!ajs()) {
                        aje();
                        break;
                    } else {
                        return;
                    }
            }
        }
    }

    private void aje() {
        C8441b bVar;
        if (this.cIc.get()) {
            bVar = ajO();
            this.cIc.set(false);
        } else {
            bVar = null;
        }
        ((C6028f) getEditor()).mo28732b(getCurrentEditEffectIndex(), bVar != null ? bVar.aIg() : this.cGY.getScaleRotateView().getScaleViewState(), this.cyJ.getmEffectKeyFrameRangeList());
        C8441b mg = ((C6028f) getEditor()).mo28483mg(((C6028f) getEditor()).getCurrentEditEffectIndex());
        if (mg != null) {
            this.cIg = mg.aIg();
        }
        ajl();
    }

    /* access modifiers changed from: private */
    public void ajf() {
        if (!C4580b.m11664ig(HttpStatus.SC_INTERNAL_SERVER_ERROR) && getEditor() != null) {
            switch (this.cGU) {
                case 1:
                    if (((C6028f) getEditor()).aiw()) {
                        ajp();
                        break;
                    } else {
                        finish();
                        break;
                    }
                case 2:
                    ajL();
                    break;
                case 3:
                    ((C6028f) getEditor()).mo28727a(getCurrentEditEffectIndex(), this.cGY.getScaleRotateView().getScaleViewState(), this.cyJ.getmEffectKeyFrameRangeList());
                    ajl();
                    if (!((C6028f) getEditor()).aiw()) {
                        finish();
                        break;
                    } else {
                        ajp();
                        break;
                    }
                case 4:
                    ajN();
                    break;
                case 5:
                    ajI();
                    break;
            }
        }
    }

    private void ajh() {
        if (this.czM != null) {
            getEffectHListView().setData(((C6028f) getEditor()).aiz(), hashCode());
            this.czM.setTitleContentLayout(getEffectHListView());
        }
    }

    /* access modifiers changed from: private */
    public void aji() {
        switch (this.cGU) {
            case 1:
                ((C6028f) getEditor()).adX();
                if (((C6028f) getEditor()).adO().getDuration() - ((C6028f) getEditor()).adZ() > 500) {
                    m16887ms(2);
                    this.cIf.ajy();
                    break;
                } else {
                    ToastUtils.show(getContext(), R.string.xiaoying_str_ve_msg_duration_not_long_enough, 0);
                    return;
                }
            case 3:
                ((C6028f) getEditor()).adX();
                ajk();
                m16887ms(2);
                this.cIf.ajy();
                break;
            case 4:
                ajM();
                break;
        }
    }

    /* access modifiers changed from: private */
    public void ajk() {
        int currentEditEffectIndex = getCurrentEditEffectIndex();
        if (!(currentEditEffectIndex < 0 || this.cGY == null || this.cGY.getScaleRotateView() == null)) {
            ((C6028f) getEditor()).mo28727a(currentEditEffectIndex, this.cGY.getScaleRotateView().getScaleViewState(), this.cyJ.getmEffectKeyFrameRangeList());
        }
        ajl();
    }

    private void ajl() {
        ((C6028f) getEditor()).mo28738mq(-1);
        this.cyJ.aiL();
        this.cGY.mo28355aL(((C6028f) getEditor()).mo28478fe(true));
        this.cGY.adl();
        getEffectHListView().mo29002nk(-1);
        m16887ms(1);
    }

    private void ajp() {
        String string = getContext().getString(R.string.xiaoying_str_com_ok);
        C8978m.m26348af(getContext(), getContext().getString(R.string.xiaoying_str_com_cancel), string).mo10296do(R.string.xiaoying_str_com_dialog_cancel_all_ask).mo10281a((C1904j) new C1904j() {
            public void onClick(C1890f fVar, C1885b bVar) {
                SubtitleOperationView.this.ajq();
            }
        }).mo10313qu().show();
    }

    /* access modifiers changed from: private */
    public void ajr() {
        List mf = ((C6028f) getEditor()).mo28482mf(((C6028f) getEditor()).adZ());
        StringBuilder sb = new StringBuilder();
        sb.append("list = ");
        sb.append(mf.size());
        LogUtilsV2.m14227d(sb.toString());
        if (mf.size() > 0) {
            int intValue = ((Integer) mf.get(0)).intValue();
            if (this.cGU != 3 || this.cyJ.getEditRange() == null || !this.cyJ.getEditRange().contains2(((C6028f) getEditor()).adZ())) {
                ajk();
                m16888mt(((Integer) mf.get(0)).intValue());
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("edit same effect index = ");
                sb2.append(intValue);
                LogUtilsV2.m14227d(sb2.toString());
            }
        } else if (this.cGU == 1) {
            LogUtilsV2.m14227d("current mode is normal ");
        } else {
            ScaleRotateViewState scaleRotateViewState = null;
            if (!(this.cGY == null || this.cGY.getScaleRotateView() == null)) {
                scaleRotateViewState = this.cGY.getScaleRotateView().getScaleViewState();
            }
            ((C6028f) getEditor()).mo28727a(getCurrentEditEffectIndex(), scaleRotateViewState, this.cyJ.getmEffectKeyFrameRangeList());
            ajl();
        }
    }

    private boolean ajs() {
        if (this.cIf != null) {
            RollInfo ajv = this.cIf.ajv();
            if (ajv != null && C8049f.aBf().mo33101iL(ajv.ttid)) {
                if (C7589a.getAdView(getContext(), 37) != null) {
                    C6386d.m18376g(getContext(), 37, ajv.ttid);
                } else if (!C8049f.aBf().aBr()) {
                    return false;
                } else {
                    C8049f.aBf().mo33097b(getActivity(), "platinum", this.cIf.ajQ() ? C7825a.ANIM_TITLE.getId() : C7825a.ALL_TEMPLATE.getId(), this.cIf.ajQ() ? "animated_text" : "effects", IapRTConstants.REQUEST_CODE_FOR_VIP);
                }
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m16870c(final RollInfo rollInfo) {
        final String str = rollInfo.ttid;
        if (!C8745n.m25561qv(str) && !"20160224184948".equals(str) && C4600l.m11739k(getContext(), true)) {
            if (C8739i.m25527qr(str)) {
                this.ctW = rollInfo;
                C4586g.m11710d(getActivity(), TemplateRouter.RATE_UNLOCK_REQUEST_CODE, rollInfo.rollModel.mRollScriptInfo.rollTitle);
                this.ctR = false;
            } else if (C8739i.m25526qq(str)) {
                this.bNG.templateId = str;
                this.bNG.mo32790iE(C7589a.isAdAvailable(getContext(), 19));
                this.bNG.mo32789a((C7873a) new C7873a() {
                    /* renamed from: cl */
                    public void mo24962cl(boolean z) {
                        if (z) {
                            C7589a.m22358a(SubtitleOperationView.this.getActivity(), 19, SubtitleOperationView.this);
                            SubtitleOperationView.this.ctR = false;
                            return;
                        }
                        C8739i.m25523cC(SubtitleOperationView.this.getContext(), str);
                        SubtitleOperationView.this.mo28640a((TemplateInfo) rollInfo, "type_roll");
                        ToastUtils.longShow(SubtitleOperationView.this.getContext(), SubtitleOperationView.this.getContext().getResources().getString(R.string.xiaoying_str_reward_video_ad_to_congrats_get));
                    }
                });
                this.bNG.show();
                this.ctW = rollInfo;
            } else {
                mo28640a((TemplateInfo) rollInfo, "type_roll");
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m16871d(Range range) {
        int i = this.cyJ.getmEditBGMRangeIndex();
        if (!(range == null || getEditor() == null || !((C6028f) getEditor()).mo28726a(i, range, this.cyJ.getmEffectKeyFrameRangeList()))) {
            this.cyJ.mo28412c(i, range);
        }
    }

    /* renamed from: fn */
    private void m16875fn(boolean z) {
        TemplateConditionModel aJK = ((C6028f) getEditor()).adK().aJK();
        if (this.cIf == null) {
            this.cIf = new C6035i(this.bof, aJK);
        }
        this.cIf.mo28755cC(this.cId);
        this.cIf.mo28746a(this.cIm);
        this.cIf.mo28759fo(z);
        this.cIh = ((C6028f) getEditor()).aiB();
        C8441b mg = ((C6028f) getEditor()).mo28483mg(((C6028f) getEditor()).aiA());
        if (mg != null) {
            this.cIg = mg.aIg();
            if (TextUtils.isEmpty(this.cHc) && this.cIg != null) {
                this.cHc = this.cIg.mStylePath;
            }
        }
        if (!TextUtils.isEmpty(this.cHc)) {
            this.cIf.mo28762go(this.cHc);
        }
        if (!TextUtils.isEmpty(this.mFontPath)) {
            this.cIf.mo28760fp(true);
            this.cIf.mo28764gu(this.mFontPath);
        }
        if (this.mTODOCode != 0) {
            this.cIf.mo28766mG(this.mTODOCode);
        }
        this.cIf.mo28765hl(this.cHd);
    }

    private NavEffectTitleLayout getEffectHListView() {
        if (this.cGW == null) {
            this.cGW = new NavEffectTitleLayout(getContext());
        }
        return this.cGW;
    }

    /* access modifiers changed from: private */
    /* renamed from: hc */
    public void m16878hc(String str) {
        if (TextUtils.isEmpty(str) || !FileUtils.isFileExisted(str)) {
            ToastUtils.show(getContext(), "File is not exist", 0);
        } else if (this.cGY != null) {
            long templateID = C8762d.aMt().getTemplateID(str);
            if (this.cGU == 5) {
                if (!C3742b.m9111II().mo23173Jt() || !C8450a.m24466bk(templateID)) {
                    this.cGY.mo28360d(((C6028f) getEditor()).mo28733c(str, this.cGY.getScaleRotateView().getScaleViewState()));
                    this.cGY.getScaleRotateView().mo31006eh(false);
                    this.cGY.getScaleRotateView().mo31012hM(false);
                } else {
                    m16883k(str, true);
                }
                return;
            }
            if (!C3742b.m9111II().mo23173Jt() || !C8450a.m24466bk(templateID)) {
                m16879hj(str);
            } else {
                m16883k(str, false);
            }
        }
    }

    /* renamed from: hj */
    private void m16879hj(String str) {
        if (!TextUtils.isEmpty(str) && this.cGY != null && this.cGY.getScaleRotateView() != null) {
            if (this.cIc.get()) {
                ajO();
                this.cIc.set(false);
            }
            boolean isEmpty = TextUtils.isEmpty(this.cGY.getScaleRotateView().getScaleViewState().mStylePath);
            this.cGY.mo28360d(((C6028f) getEditor()).mo28731b(isEmpty, str, isEmpty ? this.cIg : this.cGY.getScaleRotateView().getScaleViewState()));
            this.cGY.getScaleRotateView().mo31006eh(false);
            this.cGY.getScaleRotateView().mo31012hM(false);
        }
    }

    /* renamed from: k */
    private void m16883k(String str, boolean z) {
        ScaleRotateViewState scaleRotateViewState;
        ScaleRotateView scaleRotateView = this.cGY.getScaleRotateView();
        if (scaleRotateView != null) {
            int aiA = ((C6028f) getEditor()).aiA();
            StringBuilder sb = new StringBuilder();
            sb.append("effectDataModelList.size = ");
            sb.append(aiA);
            LogUtilsV2.m14227d(sb.toString());
            C8441b bVar = null;
            if (this.cIc.get()) {
                bVar = ajO();
                this.cIc.set(false);
            }
            boolean isEmpty = TextUtils.isEmpty(scaleRotateView.getScaleViewState().mStylePath);
            if (bVar != null) {
                scaleRotateViewState = bVar.aIg();
                isEmpty = false;
            } else {
                scaleRotateViewState = isEmpty ? this.cIg : scaleRotateView.getScaleViewState();
            }
            ((C6028f) getEditor()).mo28725a(str, scaleRotateViewState, isEmpty, this.mFontPath);
            if (!TextUtils.isEmpty(this.mFontPath)) {
                this.mFontPath = "";
            }
            this.cGY.adl();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("effectDataModelList.size = ");
            sb2.append(((C6028f) getEditor()).aiA());
            LogUtilsV2.m14227d(sb2.toString());
            this.cIc.set(true);
            C6031g.m17118eH(getContext());
        }
    }

    /* renamed from: l */
    private void m16885l(final String str, final boolean z) {
        this.compositeDisposable.mo9785e(C1487a.aUa().mo9777a(new Runnable() {
            public void run() {
                if (SubtitleOperationView.this.cIf != null && !TextUtils.isEmpty(str)) {
                    SubtitleOperationView.this.cIf.mo28762go(str);
                    SubtitleOperationView.this.m16878hc(str);
                    if (z) {
                        SubtitleOperationView.this.cIf.mo28756ek(true);
                    } else {
                        SubtitleOperationView.this.cIf.mo28757eo(SubtitleOperationView.this.ctR);
                    }
                }
            }
        }, 50, TimeUnit.MILLISECONDS));
    }

    /* access modifiers changed from: private */
    /* renamed from: ms */
    public void m16887ms(int i) {
        if (this.cGY != null && this.czM != null && this.cIf != null && this.cGX != null) {
            boolean z = this.cGV == 0;
            this.cGV = this.cGU;
            this.cGU = i;
            switch (this.cGU) {
                case 1:
                    if (this.cyJ != null) {
                        this.cyJ.setFineTuningEnable(true);
                    }
                    ajh();
                    this.cGY.adl();
                    this.cGX.setText(R.string.xiaoying_str_editor_sticker_add_new);
                    this.czM.setBtnVisibility(true);
                    this.cIe.setVisibility(8);
                    this.cIf.ajA();
                    C4577f.m11629e(this.czk);
                    break;
                case 2:
                    if (this.cyJ != null) {
                        this.cyJ.setFineTuningEnable(false);
                    }
                    if (z) {
                        this.cIf.mo28758fj(false);
                    } else {
                        this.cIf.adk();
                    }
                    this.cGY.getScaleRotateView().mo31012hM(false);
                    this.cGY.getScaleRotateView().mo31006eh(false);
                    this.cGY.aiG();
                    this.cGX.setText(R.string.xiaoying_str_editor_sticker_add_new);
                    this.cIe.setVisibility(8);
                    this.czM.setTitleContentLayout(this.cId);
                    ((C6028f) getEditor()).aiS();
                    break;
                case 3:
                    if (this.cyJ != null) {
                        this.cyJ.setFineTuningEnable(true);
                    }
                    ajh();
                    this.cGY.getScaleRotateView().mo31012hM(true);
                    this.cGY.getScaleRotateView().mo31006eh(true);
                    this.cGY.aiG();
                    this.cIe.setVisibility(8);
                    this.cIf.ajA();
                    C4577f.m11629e(this.czk);
                    this.cGX.setText(R.string.xiaoying_str_editor_sticker_add_new);
                    break;
                case 4:
                    if (this.cyJ != null) {
                        this.cyJ.setFineTuningEnable(true);
                    }
                    this.cGY.aiG();
                    this.cGY.adl();
                    this.czM.setBtnVisibility(false);
                    this.czM.setTitle(R.string.xiaoying_str_ve_subtitle_title);
                    this.cIe.setVisibility(0);
                    this.cIf.ajA();
                    C4577f.m11629e(this.czk);
                    this.cGX.setText(R.string.xiaoying_str_ve_trim_finish_btn_title);
                    break;
                case 5:
                    if (this.cyJ != null) {
                        this.cyJ.setFineTuningEnable(false);
                    }
                    this.cIf.adk();
                    this.cGY.getScaleRotateView().mo31006eh(false);
                    this.cGY.getScaleRotateView().mo31012hM(false);
                    this.cGY.aiG();
                    this.cGX.setText(R.string.xiaoying_str_editor_sticker_add_new);
                    this.cIe.setVisibility(8);
                    this.czM.setTitleContentLayout(this.cId);
                    ((C6028f) getEditor()).aiS();
                    break;
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: mt */
    public void m16888mt(int i) {
        if (getVideoOperator() != null) {
            ((C6028f) getEditor()).mo28738mq(i);
            C8441b mg = ((C6028f) getEditor()).mo28483mg(i);
            if (mg == null || mg.aIg() == null || mg.aIc() == null) {
                ajG();
            } else if (!aeC() && this.cGY != null) {
                this.cGY.mo28360d(mg.aIg());
                if (this.cGY.getScaleRotateView() != null) {
                    this.cGY.getScaleRotateView().mo31012hM(true);
                    this.cGY.getScaleRotateView().mo31006eh(true);
                }
                this.cyJ.mo28429mo(i);
                if (this.cHe != null) {
                    this.cHe.mo28494cA(((C6028f) getEditor()).adZ(), ((C6028f) getEditor()).getCurrentEditEffectIndex());
                }
                m16887ms(3);
                getEffectHListView().mo29002nk(i);
                getVideoOperator().mo29678a(new C6485b(5, i, 3));
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: C */
    public void mo27806C(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0 && this.cGU == 2) {
            C6031g.m17107bd(getContext(), "manual");
        }
    }

    /* renamed from: a */
    public void mo28639a(EffectInfoModel effectInfoModel, String str) {
        if (this.bOW != null) {
            this.bOW.mo35077a(effectInfoModel, str);
        }
    }

    /* renamed from: a */
    public void mo28640a(TemplateInfo templateInfo, String str) {
        if (templateInfo != null) {
            RollInfo rollInfo = (RollInfo) templateInfo;
            if (rollInfo.rollModel != null) {
                EffectInfoModel effectInfoModel = new EffectInfoModel();
                effectInfoModel.setmUrl(rollInfo.rollModel.rollDownUrl);
                effectInfoModel.mName = templateInfo.strTitle;
                effectInfoModel.mTemplateId = C2575a.parseLong(templateInfo.ttid);
                mo28639a(effectInfoModel, str);
                C8735f.aMf().mo35136D(templateInfo);
            }
        }
    }

    public void aex() {
        super.aex();
        if (getEditor() == null) {
            finish();
            return;
        }
        ((C6028f) getEditor()).mo28734eE(getContext());
        C10021c.aZH().mo38494ax(this);
        this.cIj = new C6002b();
        this.cIj.attachView((C6001a) this);
        this.cIj.init(getContext());
        this.bOW = new C8703d(getContext(), this.csV);
        m16849Oj();
        C7593c.m22383b("edit_title", C7594d.dMB, new String[0]);
        this.bNG = new C7870d(getContext());
        aiV();
        aiX();
        aiT();
    }

    public boolean aey() {
        return true;
    }

    public void aez() {
        this.cGX.post(new Runnable() {
            public void run() {
                int i = SubtitleOperationView.this.getBundle().getInt("ve_extra_effect_id", -1);
                if (i >= 0) {
                    SubtitleOperationView.this.m16888mt(i);
                }
                if (SubtitleOperationView.this.cIf != null) {
                    SubtitleOperationView.this.cIf.mo28761fq(true);
                }
            }
        });
    }

    public void ajq() {
        C4586g.m11693B(getActivity());
        ((C6028f) getEditor()).aiy().mo10149b((C1842q<? super T>) new C1842q<Boolean>() {
            /* renamed from: a */
            public void mo9877a(C1495b bVar) {
            }

            /* renamed from: b */
            public void mo9886K(Boolean bool) {
                C4586g.m11695Sl();
                SubtitleOperationView.this.finish();
            }

            public void onComplete() {
            }

            public void onError(Throwable th) {
            }
        });
    }

    /* renamed from: d */
    public void mo28642d(long j, int i) {
        if (this.cIf != null) {
            C6035i iVar = this.cIf;
            StringBuilder sb = new StringBuilder();
            sb.append("");
            sb.append(j);
            iVar.mo28767v(sb.toString(), i);
        }
    }

    /* access modifiers changed from: protected */
    public void finish() {
        if (this.cyD != null) {
            ((C6028f) this.cyD).aix();
            ((C6028f) this.cyD).release();
        }
        if (this.cIf != null) {
            this.cIf.ajP();
        }
        if (this.cIj != null) {
            this.cIj.release();
        }
        if (this.cIc.get()) {
            ajO();
            this.cIc.set(false);
        }
        if (this.cGY != null) {
            this.cGY.adl();
            this.cGY.aiG();
        }
        if (this.compositeDisposable != null) {
            this.compositeDisposable.clear();
        }
        super.finish();
    }

    public int getCurrentEditEffectIndex() {
        if (getEditor() != null) {
            return ((C6028f) getEditor()).getCurrentEditEffectIndex();
        }
        return -1;
    }

    public C5688b getFineTuningListener() {
        return new C5688b() {
            /* renamed from: a */
            public void mo27798a(C5687a aVar) {
                if (SubtitleOperationView.this.cyJ != null) {
                    SubtitleOperationView.this.cyJ.mo28411b(aVar);
                }
            }

            /* renamed from: a */
            public boolean mo27799a(Point point) {
                if (SubtitleOperationView.this.getEditor() == null) {
                    return false;
                }
                int i = SubtitleOperationView.this.cGU;
                if (i != 2) {
                    switch (i) {
                        case 4:
                            ((C6028f) SubtitleOperationView.this.getEditor()).adX();
                            return false;
                        case 5:
                            break;
                        default:
                            int b = ((C6028f) SubtitleOperationView.this.getEditor()).mo28730b(point);
                            SubtitleOperationView.this.ajk();
                            if (b >= ((C6028f) SubtitleOperationView.this.getEditor()).aiz().size() || b < 0 || SubtitleOperationView.this.cGY == null) {
                                return false;
                            }
                            StringBuilder sb = new StringBuilder();
                            sb.append("Find Sticker when Single Tap index = ");
                            sb.append(b);
                            LogUtilsV2.m14227d(sb.toString());
                            SubtitleOperationView.this.m16888mt(b);
                            return true;
                    }
                }
                if (SubtitleOperationView.this.cIc.get()) {
                    C8441b p = SubtitleOperationView.this.ajO();
                    if (p != null) {
                        SubtitleOperationView.this.cGY.mo28360d(p.aIg());
                    }
                    SubtitleOperationView.this.cGY.getScaleRotateView().mo31006eh(false);
                    SubtitleOperationView.this.cGY.getScaleRotateView().mo31012hM(false);
                    SubtitleOperationView.this.cIc.set(false);
                }
                return false;
            }

            public boolean aet() {
                return SubtitleOperationView.this.cyJ != null && SubtitleOperationView.this.cyJ.ait() && SubtitleOperationView.this.cyJ.aiN();
            }

            public void aeu() {
                SubtitleOperationView.this.cyJ.aeu();
            }

            public int aev() {
                return SubtitleOperationView.this.cyJ.aev();
            }

            public void aew() {
                SubtitleOperationView.this.cyJ.aew();
                if (1 == SubtitleOperationView.this.cGU) {
                    SubtitleOperationView.this.ajr();
                } else if (3 == SubtitleOperationView.this.cGU) {
                    if (SubtitleOperationView.this.cyJ.getFocusState() == 0) {
                        SubtitleOperationView.this.ajr();
                    } else {
                        int i = SubtitleOperationView.this.cyJ.getmEditBGMRangeIndex();
                        if (i >= 0) {
                            ((C6028f) SubtitleOperationView.this.getEditor()).mo28726a(i, SubtitleOperationView.this.cyJ.getEditRange(), SubtitleOperationView.this.cyJ.getmEffectKeyFrameRangeList());
                            C6031g.m17106bc(SubtitleOperationView.this.getContext(), SubtitleOperationView.this.cyJ.aiP() ? TtmlNode.LEFT : TtmlNode.RIGHT);
                        }
                    }
                }
            }

            /* renamed from: hV */
            public int mo27804hV(int i) {
                return SubtitleOperationView.this.cyJ.mo28423hV(i);
            }

            /* renamed from: lb */
            public void mo27805lb(int i) {
                SubtitleOperationView.this.cyJ.mo28425lb(i);
                if (SubtitleOperationView.this.cHe != null) {
                    SubtitleOperationView.this.cHe.mo28494cA(i, ((C6028f) SubtitleOperationView.this.getEditor()).getCurrentEditEffectIndex());
                }
            }
        };
    }

    public int getLayoutId() {
        return R.layout.editor_effect_subtitle;
    }

    public C6280b getPlayerStatusListener() {
        return new C6280b() {
            /* renamed from: J */
            public void mo27793J(int i, boolean z) {
                StringBuilder sb = new StringBuilder();
                sb.append("onPlayerReady = ");
                sb.append(i);
                LogUtilsV2.m14227d(sb.toString());
                if (SubtitleOperationView.this.cIl != null) {
                    SubtitleOperationView.this.cIl.dispose();
                }
                if (SubtitleOperationView.this.cyJ != null) {
                    SubtitleOperationView.this.cyJ.mo28392J(i, z);
                }
            }

            /* renamed from: K */
            public void mo27794K(int i, boolean z) {
                StringBuilder sb = new StringBuilder();
                sb.append("onPlayerPlaying = ");
                sb.append(i);
                LogUtilsV2.m14227d(sb.toString());
                if (SubtitleOperationView.this.cIl != null) {
                    SubtitleOperationView.this.cIl.dispose();
                }
                if (SubtitleOperationView.this.cyJ != null) {
                    SubtitleOperationView.this.cyJ.mo28393K(i, z);
                }
                if (SubtitleOperationView.this.cGY != null) {
                    SubtitleOperationView.this.cGY.aiG();
                }
            }

            /* renamed from: L */
            public void mo27795L(int i, boolean z) {
                StringBuilder sb = new StringBuilder();
                sb.append("onPlayerPause = ");
                sb.append(i);
                LogUtilsV2.m14227d(sb.toString());
                if (SubtitleOperationView.this.cIl != null) {
                    SubtitleOperationView.this.cIl.dispose();
                }
                if (SubtitleOperationView.this.cyJ != null) {
                    SubtitleOperationView.this.cyJ.mo28394L(i, z);
                }
                if (SubtitleOperationView.this.cGY != null && SubtitleOperationView.this.cGU == 1 && !SubtitleOperationView.this.aeC()) {
                    SubtitleOperationView.this.cGY.mo28355aL(((C6028f) SubtitleOperationView.this.getEditor()).mo28478fe(true));
                }
            }

            /* renamed from: M */
            public void mo27796M(int i, boolean z) {
                StringBuilder sb = new StringBuilder();
                sb.append("onPlayerStop = ");
                sb.append(i);
                LogUtilsV2.m14227d(sb.toString());
                if (SubtitleOperationView.this.cIl != null) {
                    SubtitleOperationView.this.cIl.dispose();
                }
                if (SubtitleOperationView.this.cyJ != null) {
                    SubtitleOperationView.this.cyJ.mo28395M(i, z);
                }
                if (SubtitleOperationView.this.cIc.get()) {
                    C6031g.m17107bd(SubtitleOperationView.this.getContext(), "auto");
                    C8441b p = SubtitleOperationView.this.ajO();
                    if (p != null) {
                        SubtitleOperationView.this.cGY.mo28360d(p.aIg());
                    }
                    SubtitleOperationView.this.cGY.getScaleRotateView().mo31006eh(false);
                    SubtitleOperationView.this.cGY.getScaleRotateView().mo31012hM(false);
                    SubtitleOperationView.this.cIc.set(false);
                }
                if (SubtitleOperationView.this.cGU == 4) {
                    SubtitleOperationView.this.ajM();
                }
            }

            public void aes() {
            }
        };
    }

    public MSize getSurfaceSize() {
        if (getEditor() != null) {
            return ((C6028f) getEditor()).getSurfaceSize();
        }
        return null;
    }

    /* renamed from: hk */
    public void mo28645hk(String str) {
        ScaleRotateView scaleRotateView = this.cGY.getScaleRotateView();
        if (scaleRotateView != null) {
            ScaleRotateViewState scaleViewState = scaleRotateView.getScaleViewState();
            if (scaleViewState != null && !TextUtils.equals(str, scaleViewState.getTextBubbleText())) {
                this.cIi = true;
                scaleViewState.setTextBubbleText(str);
                ((C6028f) getEditor()).mo28736g(scaleViewState);
                this.cGY.mo28360d(scaleViewState);
            }
        }
    }

    /* renamed from: m */
    public void mo28646m(Long l) {
        C8735f aMf = C8735f.aMf();
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(l);
        aMf.mo35153qn(sb.toString());
        C8745n.updateRollTemplateMapInfo(getContext());
        if (this.cIf != null) {
            C6035i iVar = this.cIf;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("");
            sb2.append(l);
            iVar.mo28763gt(sb2.toString());
        }
        if (C8450a.m24466bk(l.longValue())) {
            C6031g.m17108be(getContext(), C8450a.m24469bn(l.longValue()));
        }
    }

    /* renamed from: n */
    public void mo28647n(Long l) {
        m16885l(C8759b.m25586by(l.longValue()), false);
    }

    public void onActivityDestroy() {
        super.onActivityDestroy();
        C4577f.m11629e(this.czk);
        C10021c.aZH().mo38496az(this);
        if (this.cGY != null) {
            this.cGY.destroy();
        }
        if (this.cIf != null) {
            this.cIf.ade();
            this.cIf = null;
        }
        if (this.bOW != null) {
            this.bOW.mo35076VD();
        }
        if (this.cHe != null) {
            this.cHe.akS();
            this.cHe.destroy();
            this.cHe = null;
        }
        if (this.cyJ != null) {
            this.cyJ.destroy();
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && intent != null) {
            String stringExtra = intent.getStringExtra("template_path");
            if (i == 24580) {
                m16885l(stringExtra, true);
            } else if (i == 4369 && this.ctW != null) {
                C8739i.m25523cC(getContext(), this.ctW.ttid);
                mo28640a((TemplateInfo) this.ctW, "type_roll");
                this.cIf.mo28763gt(this.ctW.ttid);
            }
        }
    }

    public void onActivityResume() {
        super.onActivityResume();
        postDelayed(new Runnable() {
            public void run() {
                SubtitleOperationView.this.m16855TN();
            }
        }, 600);
    }

    public boolean onBackPressed() {
        if (getEditor() == null) {
            finish();
            return true;
        }
        switch (this.cGU) {
            case 1:
                if (!((C6028f) getEditor()).aiw()) {
                    finish();
                    return true;
                }
                ajp();
                return true;
            case 2:
                return ajL();
            case 3:
                if (((C6028f) getEditor()).mo28727a(getCurrentEditEffectIndex(), this.cGY.getScaleRotateView().getScaleViewState(), this.cyJ.getmEffectKeyFrameRangeList())) {
                    ajl();
                    if (((C6028f) getEditor()).aiw()) {
                        ajp();
                    }
                } else {
                    ajG();
                }
                return true;
            case 4:
                ajN();
                return true;
            case 5:
                ajI();
                return true;
            default:
                finish();
                return true;
        }
    }

    @C10031j(aZK = ThreadMode.MAIN)
    public void onEventMainThread(C6185b bVar) {
        if (getEditor() != null) {
            int i = bVar.cNh;
            StringBuilder sb = new StringBuilder();
            sb.append("onEventMainThread event.clickPosition = ");
            sb.append(i);
            LogUtilsV2.m14227d(sb.toString());
            ajk();
            ajl();
            m16888mt(i);
            C8441b mg = ((C6028f) getEditor()).mo28483mg(i);
            if (mg != null) {
                int i2 = mg.aIc().getmPosition();
                this.cyJ.mo28394L(i2, false);
                ((C6028f) getEditor()).mo27846H(i2, false);
            }
        }
    }
}
