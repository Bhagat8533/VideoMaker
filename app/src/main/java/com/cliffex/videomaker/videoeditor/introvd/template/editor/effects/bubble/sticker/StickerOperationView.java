package com.introvd.template.editor.effects.bubble.sticker;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
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
import com.introvd.template.common.Constants;
import com.introvd.template.common.FileUtils;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.common.ToastUtils;
import com.introvd.template.common.model.Range;
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
import com.introvd.template.editor.effects.music.EditorVolumeSetView;
import com.introvd.template.editor.effects.music.EditorVolumeSetView.C6176a;
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
import com.introvd.template.editor.widget.scalerotate.ScaleRotateView.C7063c;
import com.introvd.template.editor.widget.scalerotate.p295a.C7065a;
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
import com.introvd.template.sdk.model.template.RollInfo;
import com.introvd.template.sdk.model.template.TemplateInfo;
import com.introvd.template.sdk.p383c.C8399c;
import com.introvd.template.sdk.p391g.C8450a;
import com.introvd.template.template.download.C8703d;
import com.introvd.template.template.download.C8708f;
import com.introvd.template.template.p407e.C8735f;
import com.introvd.template.template.p407e.C8739i;
import com.introvd.template.template.p407e.C8745n;
import com.introvd.template.template.p408f.C8750d;
import com.introvd.template.template.p409g.C8759b;
import com.introvd.template.template.p409g.C8762d;
import com.p131c.p132a.C2561a;
import com.p131c.p132a.p135c.C2575a;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.greenrobot.eventbus.C10021c;
import org.greenrobot.eventbus.C10031j;
import org.greenrobot.eventbus.ThreadMode;
import p037b.p050b.C1842q;
import p037b.p050b.p051a.p053b.C1487a;
import p037b.p050b.p054b.C1494a;
import p037b.p050b.p054b.C1495b;
import p503cz.msebera.android.httpclient.HttpStatus;
import xiaoying.engine.clip.QClip;

@SuppressLint({"ViewConstructor"})
public class StickerOperationView extends BaseVipOperationView<C5963b> implements VideoRewardListener {
    public volatile long bNB = 0;
    private C7870d bNG;
    private C8703d bOW = null;
    private RelativeLayout bof;
    public int cGU = 2;
    public int cGV = 0;
    private NavEffectTitleLayout cGW;
    /* access modifiers changed from: private */
    public TextView cGX;
    /* access modifiers changed from: private */
    public PlayerFakeView cGY;
    private EditorVolumeSetView cGZ;
    private C7124b cGq = new C7124b() {
        /* renamed from: a */
        public boolean mo28344a(int i, Range range) {
            StringBuilder sb = new StringBuilder();
            sb.append("onUpdateRange = index = ");
            sb.append(i);
            sb.append(", range = ");
            sb.append(range);
            LogUtilsV2.m14227d(sb.toString());
            StickerOperationView.this.m16686d(range);
            return false;
        }

        public void acd() {
            LogUtilsV2.m14227d("onEndSeek = ");
            ((C5963b) StickerOperationView.this.getEditor()).aeb();
            if ((StickerOperationView.this.cGU == 1 || StickerOperationView.this.cGU == 3) && !StickerOperationView.this.cyJ.aiO()) {
                StickerOperationView.this.ajr();
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
            ((C5963b) StickerOperationView.this.getEditor()).mo27874kY(i);
            if (StickerOperationView.this.cHe != null) {
                StickerOperationView.this.cHe.mo28494cA(i, ((C5963b) StickerOperationView.this.getEditor()).getCurrentEditEffectIndex());
            }
        }

        /* renamed from: kz */
        public void mo28352kz(int i) {
            ((C5963b) StickerOperationView.this.getEditor()).adX();
            ((C5963b) StickerOperationView.this.getEditor()).aea();
            if (StickerOperationView.this.cGU == 4) {
                StickerOperationView.this.m16700ms(1);
                StickerOperationView.this.ajm();
                ((C5963b) StickerOperationView.this.getEditor()).mo27870ep(true);
                ((C5963b) StickerOperationView.this.getEditor()).mo27868b(0, ((C5963b) StickerOperationView.this.getEditor()).adO().getDuration(), false, i);
            }
            if (StickerOperationView.this.cyJ != null) {
                C5977d.m16826aX(StickerOperationView.this.getContext(), StickerOperationView.this.cyJ.acx() ? TtmlNode.LEFT : TtmlNode.RIGHT);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("onStartSeek = ");
            sb.append(i);
            LogUtilsV2.m14227d(sb.toString());
        }
    };
    /* access modifiers changed from: private */
    public C5964c cHa;
    private C5961a cHb;
    private String cHc = "";
    private String cHd = "";
    /* access modifiers changed from: private */
    public C5900b cHe;
    private final C5962a cHf = new C5962a() {
        /* renamed from: a */
        public boolean mo28586a(RollInfo rollInfo) {
            StickerOperationView.this.m16684c(rollInfo);
            return false;
        }

        public void ace() {
            StickerOperationView.this.m16691gd(C8399c.ede);
        }

        public void acg() {
            StickerOperationView.this.m16691gd("Giphy");
        }

        /* renamed from: b */
        public void mo28589b(EffectInfoModel effectInfoModel) {
            if (effectInfoModel != null) {
                StickerOperationView.this.bNB = effectInfoModel.mTemplateId;
                StickerOperationView.this.mo28569a(effectInfoModel, "type_roll");
            }
        }

        /* renamed from: gY */
        public void mo28590gY(String str) {
            C5977d.m16829ba(StickerOperationView.this.getContext(), StickerOperationView.this.cHa.ajw());
            StickerOperationView.this.ajn();
            StickerOperationView.this.m16694hc(str);
        }
    };
    private C1494a compositeDisposable = new C1494a();
    private C8708f csV = new C8708f() {
        /* renamed from: b */
        public void mo24951b(Long l) {
            StickerOperationView.this.mo28574j(l);
        }

        /* renamed from: c */
        public void mo24952c(long j, int i) {
            StickerOperationView.this.mo28573d(j, i);
        }

        /* renamed from: c */
        public void mo24953c(Long l) {
            StickerOperationView.this.mo28577m(l);
            if (l.longValue() == StickerOperationView.this.bNB) {
                StickerOperationView.this.mo28578n(l);
                StickerOperationView.this.bNB = -1;
            }
        }

        /* renamed from: o */
        public void mo27389o(Long l) {
            StickerOperationView.this.mo28575k(l);
        }

        /* renamed from: p */
        public void mo27390p(Long l) {
            StickerOperationView.this.mo28576l(l);
        }
    };
    /* access modifiers changed from: private */
    public boolean ctQ = false;
    private RollInfo ctW = null;
    private Terminator czM;
    private C4576e czk;

    /* renamed from: com.introvd.template.editor.effects.bubble.sticker.StickerOperationView$a */
    private static class C5961a extends Handler {
        private WeakReference<StickerOperationView> csX;

        public C5961a(StickerOperationView stickerOperationView) {
            this.csX = new WeakReference<>(stickerOperationView);
        }

        public void handleMessage(Message message) {
            StickerOperationView stickerOperationView = (StickerOperationView) this.csX.get();
            if (stickerOperationView != null && message.what == 10111) {
                String str = (String) message.obj;
                boolean z = message.arg1 != 1;
                if (stickerOperationView.cHa != null) {
                    stickerOperationView.cHa.mo28623gn(str);
                    stickerOperationView.cHa.mo28624go(str);
                    stickerOperationView.m16694hc(str);
                    if (z) {
                        stickerOperationView.cHa.mo28618ek(z);
                    } else {
                        stickerOperationView.cHa.mo28619eo(!stickerOperationView.ctQ);
                    }
                }
            }
        }
    }

    public StickerOperationView(Activity activity) {
        super(activity, C5963b.class);
    }

    /* renamed from: Oj */
    private void m16671Oj() {
        this.bof = (RelativeLayout) findViewById(R.id.rl_sticker_root_layout);
        this.cGY = (PlayerFakeView) findViewById(R.id.ve_sticker_transparent_fake_view);
        this.cGY.mo28354a(((C5963b) getEditor()).adN(), ((C5963b) getEditor()).getSurfaceSize(), true, 8);
        this.cGY.setEnableFlip(true);
        this.cGY.setScaleRotateViewDecoder(new C7065a());
        this.cGY.setOnDelListener(new C5889a() {
            public void aan() {
                if (StickerOperationView.this.cGU == 2) {
                    StickerOperationView.this.cGY.adl();
                    ((C5963b) StickerOperationView.this.getEditor()).aiS();
                    return;
                }
                StickerOperationView.this.aja();
            }
        });
        this.cGY.setOnReplaceListener(new C5892d() {
            public void aiI() {
                StickerOperationView.this.m16700ms(5);
                C8441b mg = ((C5963b) StickerOperationView.this.getEditor()).mo28483mg(StickerOperationView.this.getCurrentEditEffectIndex());
                if (mg != null) {
                    String aIf = mg.aIf();
                    C5977d.m16830eB(StickerOperationView.this.getContext());
                    StickerOperationView.this.m16693hb(aIf);
                }
            }

            public void aiK() {
                C5977d.m16831eC(StickerOperationView.this.getContext());
            }
        });
        this.cGY.setTouchUpEvent(new C7063c() {
            float cHi = 0.0f;

            /* renamed from: E */
            public void mo28582E(MotionEvent motionEvent) {
                if (StickerOperationView.this.cGY != null && StickerOperationView.this.cGY.getScaleRotateView() != null && StickerOperationView.this.cGY.getScaleRotateView().getScaleViewState() != null) {
                    float f = StickerOperationView.this.cGY.getScaleRotateView().getScaleViewState().mDegree;
                    if (this.cHi != f && !TextUtils.isEmpty(StickerOperationView.this.cGY.getScaleRotateView().getScaleViewState().mStylePath)) {
                        C5977d.m16832eD(StickerOperationView.this.getContext());
                        StringBuilder sb = new StringBuilder();
                        sb.append("VE_Sticker_Scale actionDownDegree = ");
                        sb.append(this.cHi);
                        sb.append(", actionUpDegree = ");
                        sb.append(f);
                        LogUtilsV2.m14227d(sb.toString());
                    }
                }
            }

            /* renamed from: F */
            public void mo28583F(MotionEvent motionEvent) {
                this.cHi = StickerOperationView.this.cGY.getScaleRotateView().getScaleViewState().mDegree;
            }
        });
        this.cGZ = (EditorVolumeSetView) findViewById(R.id.view_effect_volume_set);
        this.cGZ.bringToFront();
        this.cGZ.setVolumeSetListener(new C6176a() {
            /* renamed from: mu */
            public void mo28584mu(int i) {
                if (StickerOperationView.this.getEditor() != null) {
                    ((C5963b) StickerOperationView.this.getEditor()).mo28602cy(StickerOperationView.this.getCurrentEditEffectIndex(), i);
                }
            }
        });
        ajb();
        aiW();
        this.cGX = (TextView) findViewById(R.id.tv_sticker_op_btn);
        this.cGX.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (StickerOperationView.this.cHe != null) {
                    StickerOperationView.this.cHe.akS();
                }
                StickerOperationView.this.aji();
            }
        });
        aiV();
    }

    private void aiT() {
        int i = getBundle().getInt("ve_extra_effect_id", -1);
        QClip dataClip = ((C5963b) getEditor()).adO().getDataClip();
        boolean z = dataClip != null && dataClip.getEffectCountByGroup(2, 8) > 0 && !C5837a.agH().agK();
        if (i >= 0) {
            ajj();
        } else if (z) {
            ajj();
            m16700ms(1);
            this.compositeDisposable.mo9785e(C1487a.aUa().mo9777a(new Runnable() {
                public void run() {
                    StickerOperationView.this.ajr();
                }
            }, 300, TimeUnit.MILLISECONDS));
        } else {
            aiU();
            ajj();
            m16700ms(2);
        }
    }

    private void aiU() {
        EditorIntentInfo editorIntentInfo = (EditorIntentInfo) PassThoughUrlGenerator.getInfoFromBundle(getBundle(), EditorIntentInfo.class);
        if (editorIntentInfo != null) {
            this.cHd = (String) editorIntentInfo.paramMap.get(EditorRouter.MAP_PARAMS_TEMPLATE_ROLL_ID);
            editorIntentInfo.paramMap.remove(EditorRouter.MAP_PARAMS_TEMPLATE_ROLL_ID);
            String str = (String) editorIntentInfo.paramMap.get(EditorRouter.MAP_PARAMS_EVENT_ID);
            if (!TextUtils.isEmpty(str) && TextUtils.isDigitsOnly(str)) {
                String str2 = (String) editorIntentInfo.paramMap.get(EditorRouter.MAP_PARAMS_TEMPLATE_ID);
                String str3 = (String) editorIntentInfo.paramMap.get(EditorRouter.MAP_PARAMS_TEMPLATE_PATH);
                if (TextUtils.isEmpty(str3)) {
                    str3 = C8762d.aMt().mo35225bB(C2575a.m7391rq(str2));
                }
                this.cHc = str3;
            }
        }
    }

    private void aiV() {
        if (C5837a.agH().agN() && !C2561a.aON()) {
            C5900b bVar = new C5900b(getActivity(), this.cyJ, this.cGY, (C5896a) getEditor(), new C5909e() {
                public int ajt() {
                    return ((C5963b) StickerOperationView.this.getEditor()).getCurrentEditEffectIndex();
                }

                public void aju() {
                }

                /* renamed from: fh */
                public void mo28513fh(boolean z) {
                    StickerOperationView.this.mo27844et(z);
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
        this.cyJ = (VideoEditorSeekLayout) findViewById(R.id.ve_sticker_seek_layout);
        this.cyJ.setOnOperationCallback(getVideoOperator());
        this.cyJ.setmOnTimeLineSeekListener(this.cGq);
        this.cyJ.setOnVideoEditorSeekListener(new C5910b() {
            public void aav() {
                StickerOperationView.this.aiZ();
            }

            public void pauseVideo() {
                StickerOperationView.this.aiY();
            }
        });
    }

    private void aiX() {
        this.cyJ.mo28397a(getEditor(), ((C5963b) getEditor()).aiz());
        this.cyJ.mo28392J(((C5963b) getEditor()).adZ(), false);
        this.cyJ.setMaskDrawable(getResources().getDrawable(R.color.color_FF4400_p30));
        this.cyJ.setTrimMaskDrawable(getResources().getDrawable(R.color.color_FF4400_p50));
    }

    /* access modifiers changed from: private */
    public void aiY() {
        ((C5963b) getEditor()).adX();
        if (this.cGU != 4) {
            ajr();
        }
    }

    /* access modifiers changed from: private */
    public void aiZ() {
        if (getEditor() != null) {
            if (this.cGU == 3) {
                ((C5963b) getEditor()).mo28596a(getCurrentEditEffectIndex(), this.cGY.getScaleRotateView().getScaleViewState(), getVideoOperator(), this.cyJ.getmEffectKeyFrameRangeList());
                ajl();
            }
            ((C5963b) getEditor()).adY();
        }
    }

    /* access modifiers changed from: private */
    public void aja() {
        if (getEditor() != null && getCurrentEditEffectIndex() >= 0 && this.cyJ != null && this.cGY != null && this.cGY.getScaleRotateView() != null && this.cGY.getScaleRotateView().getScaleViewState() != null) {
            int currentEditEffectIndex = getCurrentEditEffectIndex();
            C5977d.m16827aY(getContext(), ((C5963b) getEditor()).mo28479gX(this.cGY.getScaleRotateView().getScaleViewState().mStylePath));
            m16689fg(false);
            if (this.cHe != null) {
                this.cHe.mo28498mn(currentEditEffectIndex);
            }
            ((C5963b) getEditor()).mo28607mr(currentEditEffectIndex);
            ((C5963b) getEditor()).mo27870ep(true);
            ((C5963b) getEditor()).mo27873h(0, ((C5963b) getEditor()).adO().getDuration(), false);
            this.cyJ.mo28426ml(currentEditEffectIndex);
            this.cyJ.aiL();
            this.cGY.adl();
            ((C5963b) getEditor()).mo28606mq(-1);
            ((C5963b) getEditor()).aiS();
            m16700ms(1);
        }
    }

    private void ajb() {
        this.czM = (Terminator) findViewById(R.id.terminator);
        this.czM.setTitle(R.string.xiaoying_str_editor_sticker_title);
        this.czM.setTerminatorListener(new C5858a() {
            public void aeW() {
                StickerOperationView.this.ajf();
            }

            public void aeX() {
                StickerOperationView.this.ajc();
            }
        });
    }

    /* access modifiers changed from: private */
    public void ajc() {
        if (!C4580b.m11664ig(HttpStatus.SC_INTERNAL_SERVER_ERROR)) {
            int i = this.cGU;
            if (i != 5) {
                switch (i) {
                    case 1:
                        if (!aeG()) {
                            finish();
                            break;
                        } else {
                            return;
                        }
                    case 2:
                        if (!ajs()) {
                            if (!ajd()) {
                                ajg();
                                break;
                            } else {
                                C8441b mg = ((C5963b) getEditor()).mo28483mg(((C5963b) getEditor()).aiA());
                                long templateID = C8762d.aMt().getTemplateID(mg.aIf());
                                C5977d.m16833s(getContext(), C8762d.aMt().mo35224aa(mg.aIf(), C8450a.m24471c(Constants.getLocale())), C8450a.m24469bn(templateID));
                                m16700ms(4);
                                break;
                            }
                        } else {
                            return;
                        }
                    case 3:
                        if (!aeG()) {
                            ((C5963b) getEditor()).mo28596a(getCurrentEditEffectIndex(), this.cGY.getScaleRotateView().getScaleViewState(), getVideoOperator(), this.cyJ.getmEffectKeyFrameRangeList());
                            finish();
                            break;
                        } else {
                            return;
                        }
                }
            } else if (!ajs()) {
                aje();
            }
        }
    }

    private boolean ajd() {
        C8441b f = ((C5963b) getEditor()).mo28603f(this.cGY.getScaleRotateView().getScaleViewState());
        if (f == null) {
            return false;
        }
        if (getVideoOperator() != null) {
            getVideoOperator().mo29678a(new C6485b(1, ((C5963b) getEditor()).aiA(), 8));
            ((C5963b) getEditor()).mo27870ep(false);
            ((C5963b) getEditor()).mo27868b(f.aIc().getmPosition(), f.aIc().getmTimeLength(), true, f.aIc().getmPosition());
        }
        this.cyJ.mo28413c(new Range(f.aIc().getmPosition(), f.aIc().getmTimeLength()));
        return true;
    }

    private void aje() {
        ((C5963b) getEditor()).mo28596a(getCurrentEditEffectIndex(), this.cGY.getScaleRotateView().getScaleViewState(), getVideoOperator(), this.cyJ.getmEffectKeyFrameRangeList());
        ajl();
    }

    /* access modifiers changed from: private */
    public void ajf() {
        if (!C4580b.m11664ig(HttpStatus.SC_INTERNAL_SERVER_ERROR) && getEditor() != null) {
            int i = this.cGU;
            if (i != 5) {
                switch (i) {
                    case 1:
                        if (((C5963b) getEditor()).aiw()) {
                            ajp();
                            break;
                        } else {
                            finish();
                            break;
                        }
                    case 2:
                        ajg();
                        break;
                    case 3:
                        ((C5963b) getEditor()).mo28596a(getCurrentEditEffectIndex(), this.cGY.getScaleRotateView().getScaleViewState(), getVideoOperator(), this.cyJ.getmEffectKeyFrameRangeList());
                        ajl();
                        if (!((C5963b) getEditor()).aiw()) {
                            finish();
                            break;
                        } else {
                            ajp();
                            break;
                        }
                }
            } else {
                ajg();
            }
        }
    }

    private boolean ajg() {
        int i = this.cGV;
        if (i == 0 || i == 2) {
            finish();
            return true;
        }
        this.cGY.getScaleRotateView().mo31012hM(true);
        this.cGY.getScaleRotateView().mo31006eh(true);
        m16700ms(this.cGV);
        return true;
    }

    private void ajh() {
        if (this.czM != null) {
            if (this.cGW == null) {
                this.cGW = new NavEffectTitleLayout(getContext());
            }
            this.cGW.setData(((C5963b) getEditor()).aiz(), hashCode());
            this.czM.setTitleContentLayout(this.cGW);
        }
    }

    /* access modifiers changed from: private */
    public void aji() {
        switch (this.cGU) {
            case 1:
                ((C5963b) getEditor()).adX();
                if (((C5963b) getEditor()).adO().getDuration() - ((C5963b) getEditor()).adZ() > 500) {
                    m16700ms(2);
                    break;
                } else {
                    ToastUtils.show(getContext(), R.string.xiaoying_str_ve_msg_duration_not_long_enough, 0);
                    return;
                }
            case 3:
                ((C5963b) getEditor()).adX();
                ajk();
                m16700ms(2);
                break;
            case 4:
                ((C5963b) getEditor()).adX();
                m16700ms(2);
                break;
        }
    }

    private void ajj() {
        TemplateConditionModel aJK = ((C5963b) getEditor()).adK().aJK();
        if (this.cHa == null) {
            this.cHa = new C5964c(this.bof, aJK, ((C5963b) getEditor()).adP());
        }
        this.cHa.mo28608a(this.cHf);
        if (!TextUtils.isEmpty(this.cHc)) {
            this.cHa.mo28624go(this.cHc);
            this.cHa.mo28623gn(this.cHc);
        }
        this.cHa.mo28625h(!TextUtils.isEmpty(this.cHc), this.cHd);
    }

    private void ajl() {
        ((C5963b) getEditor()).mo28606mq(-1);
        this.cyJ.aiL();
        ajm();
        this.cGY.adl();
        getEffectHListView().mo29002nk(-1);
        m16700ms(1);
    }

    /* access modifiers changed from: private */
    public void ajm() {
        if (this.cGY != null && this.cGY.getScaleRotateView() != null && getEditor() != null) {
            this.cGY.mo28355aL(((C5963b) getEditor()).mo28478fe(true));
            m16689fg(true);
            ScaleRotateViewState scaleViewState = this.cGY.getScaleRotateView().getScaleViewState();
            if (scaleViewState != null) {
                this.cHa.mo28623gn(scaleViewState.mStylePath);
            }
        }
    }

    /* access modifiers changed from: private */
    public void ajn() {
        if (this.cHa != null && !this.cyH) {
            RollInfo ajv = this.cHa.ajv();
            if (ajv == null) {
                C4577f.m11629e(this.czk);
                return;
            }
            if (!C8049f.aBf().mo33101iL(ajv.ttid)) {
                C4577f.m11629e(this.czk);
            } else if (!C4577f.m11630i(this.czk)) {
                this.czk = C4577f.m11623a((Context) getActivity(), (View) this, "effects", -1);
                C7897a.m23022b(ajv.ttid, "Iap_Purchase_Template_Id", new String[0]);
            }
        }
    }

    private boolean ajo() {
        boolean z = false;
        if (this.cHa == null) {
            return false;
        }
        String ajz = this.cHa.ajz();
        if (TextUtils.isEmpty(ajz)) {
            return false;
        }
        if (!C8750d.m25573jM(ajz) && C8450a.m24472nV(ajz)) {
            z = true;
        }
        return z;
    }

    private void ajp() {
        String string = getContext().getString(R.string.xiaoying_str_com_ok);
        C8978m.m26348af(getContext(), getContext().getString(R.string.xiaoying_str_com_cancel), string).mo10296do(R.string.xiaoying_str_com_dialog_cancel_all_ask).mo10281a((C1904j) new C1904j() {
            public void onClick(C1890f fVar, C1885b bVar) {
                StickerOperationView.this.ajq();
            }
        }).mo10313qu().show();
    }

    /* access modifiers changed from: private */
    public void ajr() {
        List mf = ((C5963b) getEditor()).mo28482mf(((C5963b) getEditor()).adZ());
        StringBuilder sb = new StringBuilder();
        sb.append("list = ");
        sb.append(mf.size());
        LogUtilsV2.m14227d(sb.toString());
        if (mf.size() > 0) {
            int intValue = ((Integer) mf.get(0)).intValue();
            if (this.cGU != 3 || this.cyJ.getEditRange() == null || !this.cyJ.getEditRange().contains2(((C5963b) getEditor()).adZ())) {
                ajk();
                m16701mt(((Integer) mf.get(0)).intValue());
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
            ((C5963b) getEditor()).mo28596a(getCurrentEditEffectIndex(), scaleRotateViewState, getVideoOperator(), this.cyJ.getmEffectKeyFrameRangeList());
            ajl();
        }
    }

    private boolean ajs() {
        if (this.cHa != null) {
            RollInfo ajv = this.cHa.ajv();
            if (ajv != null && C6386d.m18377iL(ajv.ttid)) {
                if (C7589a.getAdView(getContext(), 37) != null) {
                    C6386d.m18376g(getContext(), 37, ajv.ttid);
                } else if (!C8049f.aBf().aBr()) {
                    return false;
                } else {
                    C8049f.aBf().mo33097b(getActivity(), "platinum", C7825a.ALL_TEMPLATE.getId(), "effects", IapRTConstants.REQUEST_CODE_FOR_VIP);
                }
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m16684c(final RollInfo rollInfo) {
        if (rollInfo != null) {
            final String str = rollInfo.ttid;
            if (!C8745n.m25561qv(str) && !"20160224184733".equals(str) && C4600l.m11739k(getContext(), true)) {
                if (C8739i.m25527qr(str)) {
                    this.ctW = rollInfo;
                    C4586g.m11710d(getActivity(), TemplateRouter.RATE_UNLOCK_REQUEST_CODE, rollInfo.rollModel.mRollScriptInfo.rollTitle);
                    this.ctQ = true;
                } else if (C8739i.m25526qq(str)) {
                    this.bNG.templateId = str;
                    this.bNG.mo32790iE(C7589a.isAdAvailable(getContext(), 19));
                    this.bNG.mo32789a((C7873a) new C7873a() {
                        /* renamed from: cl */
                        public void mo24962cl(boolean z) {
                            if (z) {
                                C7589a.m22358a(StickerOperationView.this.getActivity(), 19, StickerOperationView.this);
                                return;
                            }
                            C8739i.m25523cC(StickerOperationView.this.getContext(), str);
                            StickerOperationView.this.mo28570a((TemplateInfo) rollInfo, "type_roll");
                            ToastUtils.longShow(StickerOperationView.this.getContext(), StickerOperationView.this.getContext().getResources().getString(R.string.xiaoying_str_reward_video_ad_to_congrats_get));
                        }
                    });
                    this.bNG.show();
                    this.ctW = rollInfo;
                    this.ctQ = true;
                } else {
                    mo28570a((TemplateInfo) rollInfo, "type_roll");
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m16686d(Range range) {
        int i = this.cyJ.getmEditBGMRangeIndex();
        if (!(range == null || getEditor() == null || !((C5963b) getEditor()).mo28595a(i, range, this.cyJ.getmEffectKeyFrameRangeList()))) {
            this.cyJ.mo28412c(i, range);
        }
    }

    /* renamed from: fg */
    private void m16689fg(boolean z) {
        if (getEditor() != null) {
            if (z && this.cGZ != null && ajo()) {
                C8441b mg = ((C5963b) getEditor()).mo28483mg(getCurrentEditEffectIndex());
                this.cGZ.mo28980nh(mg == null ? 0 : mg.eef);
                this.cGZ.setVisibility(0);
            } else if (this.cGZ != null) {
                this.cGZ.setVisibility(8);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: gd */
    public void m16691gd(String str) {
        TemplateRouter.startTemplateInfoActivity(getActivity(), str);
    }

    /* access modifiers changed from: private */
    public int getCurrentEditEffectIndex() {
        if (getEditor() != null) {
            return ((C5963b) getEditor()).getCurrentEditEffectIndex();
        }
        return -1;
    }

    private NavEffectTitleLayout getEffectHListView() {
        if (this.cGW == null) {
            this.cGW = new NavEffectTitleLayout(getContext());
        }
        return this.cGW;
    }

    /* access modifiers changed from: private */
    /* renamed from: hb */
    public void m16693hb(String str) {
        this.cHa.mo28624go(str);
        this.cHa.mo28623gn(str);
        this.cHa.add();
        this.cHa.mo28619eo(true);
    }

    /* access modifiers changed from: private */
    /* renamed from: hc */
    public void m16694hc(String str) {
        if (TextUtils.isEmpty(str) || !FileUtils.isFileExisted(str)) {
            ToastUtils.show(getContext(), "File is not exist", 0);
        } else if (this.cGY != null && this.cGY.getScaleRotateView() != null) {
            this.cHa.mo28624go(str);
            this.cHa.add();
            ((C5963b) getEditor()).mo28462a(getCurrentEditEffectIndex(), ((C5963b) getEditor()).mo28604gZ(str));
            if (this.cGU == 5) {
                this.cGY.mo28360d(((C5963b) getEditor()).mo28601c(str, this.cGY.getScaleRotateView().getScaleViewState()));
                this.cGY.getScaleRotateView().mo31006eh(false);
                this.cGY.getScaleRotateView().mo31012hM(false);
                return;
            }
            this.cGY.mo28360d(((C5963b) getEditor()).mo28594a(str, this.cGY.getScaleRotateView().getScaleViewState()));
            this.cGY.getScaleRotateView().mo31006eh(false);
            this.cGY.getScaleRotateView().mo31012hM(false);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: ms */
    public void m16700ms(int i) {
        if (this.cGY != null) {
            boolean z = this.cGV == 0;
            this.cGV = this.cGU;
            this.cGU = i;
            switch (this.cGU) {
                case 1:
                    this.cyJ.setFineTuningEnable(true);
                    ajh();
                    this.cGY.adl();
                    this.cGX.setText(R.string.xiaoying_str_editor_sticker_add_new);
                    if (this.cHa != null) {
                        this.cHa.ajA();
                    }
                    C4577f.m11629e(this.czk);
                    break;
                case 2:
                    if (z) {
                        this.cHa.mo28620fj(false);
                    } else {
                        this.cHa.adk();
                    }
                    this.cyJ.setFineTuningEnable(false);
                    this.czM.setTitle(R.string.xiaoying_str_editor_sticker_title);
                    this.cGY.aiG();
                    this.cGY.getScaleRotateView().mo31012hM(false);
                    this.cGY.getScaleRotateView().mo31006eh(false);
                    this.cGX.setText(R.string.xiaoying_str_editor_sticker_add_new);
                    ((C5963b) getEditor()).aiS();
                    break;
                case 3:
                    if (this.cGZ != null) {
                        if (ajo()) {
                            this.cGZ.mo28980nh(((C5963b) getEditor()).mo28483mg(getCurrentEditEffectIndex()).eef);
                            this.cGZ.setVisibility(0);
                        } else {
                            this.cGZ.setVisibility(8);
                        }
                    }
                    if (this.cHa != null) {
                        this.cHa.ajA();
                    }
                    C4577f.m11629e(this.czk);
                    this.cGY.getScaleRotateView().mo31012hM(true);
                    this.cGY.getScaleRotateView().mo31006eh(true);
                    this.cyJ.setFineTuningEnable(true);
                    ajh();
                    this.cGY.aiG();
                    this.cGX.setText(R.string.xiaoying_str_editor_sticker_add_new);
                    break;
                case 4:
                    this.cyJ.setFineTuningEnable(false);
                    ajh();
                    this.cGY.adl();
                    this.cGX.setText(R.string.xiaoying_str_editor_sticker_add_new);
                    this.cHa.ajA();
                    C4577f.m11629e(this.czk);
                    break;
                case 5:
                    this.cHa.adk();
                    this.cyJ.setFineTuningEnable(false);
                    this.czM.setTitle(R.string.xiaoying_str_editor_sticker_title);
                    this.cGY.aiG();
                    this.cGY.getScaleRotateView().mo31012hM(false);
                    this.cGY.getScaleRotateView().mo31006eh(false);
                    this.cGX.setText(R.string.xiaoying_str_editor_sticker_add_new);
                    ((C5963b) getEditor()).aiS();
                    break;
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: mt */
    public void m16701mt(int i) {
        ((C5963b) getEditor()).mo28606mq(i);
        C8441b mg = ((C5963b) getEditor()).mo28483mg(i);
        if (mg != null && this.cHa != null && this.cGY != null) {
            this.cHa.mo28623gn(mg.aIf());
            this.cGY.mo28360d(mg.aIg());
            if (this.cGY.getScaleRotateView() != null) {
                this.cGY.getScaleRotateView().mo31012hM(true);
                this.cGY.getScaleRotateView().mo31006eh(true);
            }
            this.cyJ.mo28429mo(i);
            if (this.cHe != null) {
                this.cHe.mo28494cA(((C5963b) getEditor()).adZ(), ((C5963b) getEditor()).getCurrentEditEffectIndex());
            }
            m16700ms(3);
            getEffectHListView().mo29002nk(i);
            getVideoOperator().mo29678a(new C6485b(5, i, 8));
        }
    }

    /* renamed from: a */
    public void mo28569a(EffectInfoModel effectInfoModel, String str) {
        if (this.bOW != null) {
            this.bOW.mo35077a(effectInfoModel, str);
        }
    }

    /* renamed from: a */
    public void mo28570a(TemplateInfo templateInfo, String str) {
        if (templateInfo != null) {
            RollInfo rollInfo = (RollInfo) templateInfo;
            if (rollInfo.rollModel != null) {
                EffectInfoModel effectInfoModel = new EffectInfoModel();
                effectInfoModel.setmUrl(rollInfo.rollModel.rollDownUrl);
                effectInfoModel.mName = templateInfo.strTitle;
                effectInfoModel.mTemplateId = C2575a.parseLong(templateInfo.ttid);
                mo28569a(effectInfoModel, str);
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
        C10021c.aZH().mo38494ax(this);
        this.cHb = new C5961a(this);
        this.bOW = new C8703d(getContext(), this.csV);
        m16671Oj();
        C7593c.m22383b("edit_sticker", C7594d.dMB, new String[0]);
        this.bNG = new C7870d(getContext());
        aiX();
        aiT();
    }

    public boolean aey() {
        return true;
    }

    public void aez() {
        this.cGX.setVisibility(0);
        this.cGX.post(new Runnable() {
            public void run() {
                int i = StickerOperationView.this.getBundle().getInt("ve_extra_effect_id", -1);
                if (i >= 0) {
                    StickerOperationView.this.m16701mt(i);
                }
            }
        });
    }

    public void ajk() {
        int currentEditEffectIndex = getCurrentEditEffectIndex();
        if (currentEditEffectIndex >= 0) {
            ScaleRotateView scaleRotateView = this.cGY.getScaleRotateView();
            if (scaleRotateView != null) {
                ((C5963b) getEditor()).mo28596a(currentEditEffectIndex, scaleRotateView.getScaleViewState(), getVideoOperator(), this.cyJ.getmEffectKeyFrameRangeList());
            }
        }
        ajl();
    }

    public void ajq() {
        C4586g.m11693B(getActivity());
        ((C5963b) getEditor()).aiy().mo10149b((C1842q<? super T>) new C1842q<Boolean>() {
            /* renamed from: a */
            public void mo9877a(C1495b bVar) {
            }

            /* renamed from: b */
            public void mo9886K(Boolean bool) {
                C4586g.m11695Sl();
                StickerOperationView.this.finish();
            }

            public void onComplete() {
            }

            public void onError(Throwable th) {
            }
        });
    }

    /* renamed from: d */
    public void mo28573d(long j, int i) {
        if (this.cHa != null) {
            C5964c cVar = this.cHa;
            StringBuilder sb = new StringBuilder();
            sb.append("");
            sb.append(j);
            cVar.mo28627v(sb.toString(), i);
        }
    }

    /* access modifiers changed from: protected */
    public void finish() {
        super.finish();
        if (this.cyD != null) {
            ((C5963b) this.cyD).aix();
        }
        if (this.cGY != null) {
            this.cGY.adl();
            this.cGY.aiG();
        }
        if (this.compositeDisposable != null) {
            this.compositeDisposable.clear();
        }
    }

    public C5688b getFineTuningListener() {
        return new C5688b() {
            /* renamed from: a */
            public void mo27798a(C5687a aVar) {
                if (StickerOperationView.this.cyJ != null) {
                    StickerOperationView.this.cyJ.mo28411b(aVar);
                }
            }

            /* renamed from: a */
            public boolean mo27799a(Point point) {
                if (StickerOperationView.this.getEditor() == null) {
                    return false;
                }
                int i = StickerOperationView.this.cGU;
                if (i == 2 || i == 5) {
                    return false;
                }
                int b = ((C5963b) StickerOperationView.this.getEditor()).mo28599b(point);
                StickerOperationView.this.ajk();
                if (b >= ((C5963b) StickerOperationView.this.getEditor()).aiz().size() || b < 0 || StickerOperationView.this.cGY == null) {
                    return false;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("Find Sticker when Single Tap index = ");
                sb.append(b);
                LogUtilsV2.m14227d(sb.toString());
                StickerOperationView.this.m16701mt(b);
                return true;
            }

            public boolean aet() {
                return StickerOperationView.this.cyJ != null && StickerOperationView.this.cyJ.ait();
            }

            public void aeu() {
                StickerOperationView.this.cyJ.aeu();
            }

            public int aev() {
                return StickerOperationView.this.cyJ.aev();
            }

            public void aew() {
                StickerOperationView.this.cyJ.aew();
                if (1 == StickerOperationView.this.cGU) {
                    StickerOperationView.this.ajr();
                } else if (3 == StickerOperationView.this.cGU) {
                    if (StickerOperationView.this.cyJ.getFocusState() == 0) {
                        StickerOperationView.this.ajr();
                    } else {
                        int i = StickerOperationView.this.cyJ.getmEditBGMRangeIndex();
                        if (i >= 0) {
                            ((C5963b) StickerOperationView.this.getEditor()).mo28595a(i, StickerOperationView.this.cyJ.getEditRange(), StickerOperationView.this.cyJ.getmEffectKeyFrameRangeList());
                            C5977d.m16828aZ(StickerOperationView.this.getContext(), StickerOperationView.this.cyJ.aiP() ? TtmlNode.LEFT : TtmlNode.RIGHT);
                        }
                    }
                }
            }

            /* renamed from: hV */
            public int mo27804hV(int i) {
                return StickerOperationView.this.cyJ.mo28423hV(i);
            }

            /* renamed from: lb */
            public void mo27805lb(int i) {
                StickerOperationView.this.cyJ.mo28425lb(i);
                if (StickerOperationView.this.cHe != null) {
                    StickerOperationView.this.cHe.mo28494cA(i, ((C5963b) StickerOperationView.this.getEditor()).getCurrentEditEffectIndex());
                }
            }
        };
    }

    public int getLayoutId() {
        return R.layout.editor_effect_sticker;
    }

    public C6280b getPlayerStatusListener() {
        return new C6280b() {
            /* renamed from: J */
            public void mo27793J(int i, boolean z) {
                if (StickerOperationView.this.cyJ != null) {
                    StickerOperationView.this.cyJ.mo28392J(i, z);
                }
                StickerOperationView.this.cGX.setVisibility(0);
            }

            /* renamed from: K */
            public void mo27794K(int i, boolean z) {
                StringBuilder sb = new StringBuilder();
                sb.append("onPlayerPlaying = ");
                sb.append(i);
                LogUtilsV2.m14227d(sb.toString());
                if (StickerOperationView.this.cyJ != null) {
                    StickerOperationView.this.cyJ.mo28393K(i, z);
                }
                StickerOperationView.this.cGX.setVisibility(8);
                if (StickerOperationView.this.cGY != null) {
                    StickerOperationView.this.cGY.aiG();
                }
            }

            /* renamed from: L */
            public void mo27795L(int i, boolean z) {
                StringBuilder sb = new StringBuilder();
                sb.append("onPlayerPause = ");
                sb.append(i);
                LogUtilsV2.m14227d(sb.toString());
                if (StickerOperationView.this.cyJ != null) {
                    StickerOperationView.this.cyJ.mo28394L(i, z);
                }
                StickerOperationView.this.cGX.setVisibility(0);
                if (StickerOperationView.this.cGY != null && StickerOperationView.this.cGU == 1 && !StickerOperationView.this.aeC()) {
                    StickerOperationView.this.ajm();
                }
            }

            /* renamed from: M */
            public void mo27796M(int i, boolean z) {
                StringBuilder sb = new StringBuilder();
                sb.append("onPlayerStop = ");
                sb.append(i);
                LogUtilsV2.m14227d(sb.toString());
                if (StickerOperationView.this.cyJ != null) {
                    StickerOperationView.this.cyJ.mo28395M(i, z);
                }
                StickerOperationView.this.cGX.setVisibility(0);
                if (StickerOperationView.this.cGY != null && StickerOperationView.this.cGU == 1 && !StickerOperationView.this.aeC()) {
                    StickerOperationView.this.ajm();
                }
                if (StickerOperationView.this.cGU == 4) {
                    ((C5963b) StickerOperationView.this.getEditor()).mo27870ep(true);
                    ((C5963b) StickerOperationView.this.getEditor()).mo27868b(0, ((C5963b) StickerOperationView.this.getEditor()).adO().getDuration(), false, i);
                    StickerOperationView.this.m16700ms(1);
                }
            }

            public void aes() {
            }
        };
    }

    /* renamed from: j */
    public void mo28574j(Long l) {
    }

    /* renamed from: k */
    public void mo28575k(Long l) {
    }

    /* renamed from: l */
    public void mo28576l(Long l) {
    }

    /* renamed from: m */
    public void mo28577m(Long l) {
        C8735f aMf = C8735f.aMf();
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(l);
        aMf.mo35153qn(sb.toString());
        C8745n.updateRollTemplateMapInfo(getContext());
        if (this.cHa != null) {
            C5964c cVar = this.cHa;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("");
            sb2.append(l);
            cVar.mo28621gk(sb2.toString());
        }
    }

    /* renamed from: n */
    public void mo28578n(Long l) {
        String by = C8759b.m25586by(l.longValue());
        if (this.cHb != null) {
            Message obtainMessage = this.cHb.obtainMessage(10111);
            obtainMessage.obj = by;
            obtainMessage.arg1 = 1;
            this.cHb.sendMessageDelayed(obtainMessage, 50);
        }
    }

    public void onActivityDestroy() {
        super.onActivityDestroy();
        C4577f.m11629e(this.czk);
        C10021c.aZH().mo38496az(this);
        if (this.cGY != null) {
            this.cGY.destroy();
        }
        if (this.cHa != null) {
            this.cHa.ade();
            this.cHa = null;
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

    public void onActivityPause() {
        super.onActivityPause();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 24580) {
            if (i2 == -1 && intent != null) {
                String stringExtra = intent.getStringExtra("template_path");
                Message obtainMessage = this.cHb.obtainMessage(10111);
                obtainMessage.obj = stringExtra;
                this.cHb.sendMessage(obtainMessage);
            }
        } else if (i == 4369 && this.ctW != null) {
            C8739i.m25523cC(getContext(), this.ctW.ttid);
            mo28570a((TemplateInfo) this.ctW, "type_roll");
            this.cHa.mo28622gl(this.ctW.ttid);
        }
    }

    public void onActivityResume() {
        super.onActivityResume();
        postDelayed(new Runnable() {
            public void run() {
                StickerOperationView.this.ajn();
            }
        }, 600);
    }

    public boolean onBackPressed() {
        int i = this.cGU;
        if (i == 5) {
            return ajg();
        }
        switch (i) {
            case 1:
                if (!((C5963b) getEditor()).aiw()) {
                    finish();
                    return true;
                }
                ajp();
                return true;
            case 2:
                return ajg();
            case 3:
                ((C5963b) getEditor()).mo28596a(getCurrentEditEffectIndex(), this.cGY.getScaleRotateView().getScaleViewState(), getVideoOperator(), this.cyJ.getmEffectKeyFrameRangeList());
                ajl();
                if (((C5963b) getEditor()).aiw()) {
                    ajp();
                }
                return true;
            default:
                return true;
        }
    }

    @C10031j(aZK = ThreadMode.MAIN)
    public void onEventMainThread(C6185b bVar) {
        int i = bVar.cNh;
        StringBuilder sb = new StringBuilder();
        sb.append("onEventMainThread event.clickPosition = ");
        sb.append(i);
        LogUtilsV2.m14227d(sb.toString());
        ajk();
        m16701mt(i);
        int i2 = ((C5963b) getEditor()).mo28483mg(i).aIc().getmPosition();
        this.cyJ.mo28394L(i2, false);
        ((C5963b) getEditor()).mo27870ep(true);
        ((C5963b) getEditor()).mo27868b(0, ((C5963b) getEditor()).adO().getDuration(), false, i2);
    }
}
