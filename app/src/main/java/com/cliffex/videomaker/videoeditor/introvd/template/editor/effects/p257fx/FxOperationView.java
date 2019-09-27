package com.introvd.template.editor.effects.p257fx;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Point;
import android.support.p024v7.widget.LinearLayoutManager;
import android.support.p024v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.afollestad.materialdialogs.C1885b;
import com.afollestad.materialdialogs.C1890f;
import com.afollestad.materialdialogs.C1890f.C1904j;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.common.ToastUtils;
import com.introvd.template.common.model.Range;
import com.introvd.template.crash.C5523b;
import com.introvd.template.editor.R;
import com.introvd.template.editor.base.BaseOperationView;
import com.introvd.template.editor.common.C5837a;
import com.introvd.template.editor.common.C5840b;
import com.introvd.template.editor.common.terminator.Terminator;
import com.introvd.template.editor.common.terminator.Terminator.C5858a;
import com.introvd.template.editor.effects.C5910b;
import com.introvd.template.editor.effects.VideoEditorSeekLayout;
import com.introvd.template.editor.effects.music.EditorVolumeSetView;
import com.introvd.template.editor.effects.music.EditorVolumeSetView.C6176a;
import com.introvd.template.editor.effects.nav.C6185b;
import com.introvd.template.editor.effects.nav.NavEffectTitleLayout;
import com.introvd.template.editor.p246c.C5687a;
import com.introvd.template.editor.p246c.C5688b;
import com.introvd.template.editor.p259f.C6280b;
import com.introvd.template.editor.player.p267a.C6485b;
import com.introvd.template.editor.widget.timeline.C7124b;
import com.introvd.template.p203b.C4580b;
import com.introvd.template.p414ui.dialog.C8978m;
import com.introvd.template.router.PassThoughUrlGenerator;
import com.introvd.template.router.editor.EditorIntentInfo;
import com.introvd.template.router.editor.EditorRouter;
import com.introvd.template.router.template.TemplateRouter;
import com.introvd.template.sdk.editor.cache.C8441b;
import com.introvd.template.sdk.model.editor.EffectInfoModel;
import com.introvd.template.sdk.p383c.C8399c;
import com.introvd.template.sdk.p391g.C8450a;
import com.introvd.template.sdk.utils.p394b.C8538o;
import com.introvd.template.template.p409g.C8759b;
import com.p131c.p132a.p133a.C2564c;
import com.p131c.p132a.p133a.C2564c.C2569a;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.greenrobot.eventbus.C10021c;
import org.greenrobot.eventbus.C10031j;
import p037b.p050b.C1848s;
import p037b.p050b.C1850u;
import p037b.p050b.C1852w;
import p037b.p050b.p051a.p053b.C1487a;
import p037b.p050b.p054b.C1494a;
import p037b.p050b.p057e.C1518f;
import p037b.p050b.p057e.C1520h;
import p037b.p050b.p073g.C1810c;
import p037b.p050b.p076j.C1820a;
import p503cz.msebera.android.httpclient.HttpStatus;
import xiaoying.engine.clip.QClip;

@SuppressLint({"ViewConstructor"})
/* renamed from: com.introvd.template.editor.effects.fx.FxOperationView */
public class FxOperationView extends BaseOperationView<C6148f> {
    private C7124b cGO = new C7124b() {
        /* renamed from: a */
        public boolean mo28344a(int i, Range range) {
            if (range == null || FxOperationView.this.getEditor() == null) {
                return false;
            }
            FxOperationView.this.m17437c(i, range);
            FxOperationView.this.cLU.mo28892fy(false);
            return false;
        }

        public void acd() {
            ((C6148f) FxOperationView.this.getEditor()).aeb();
        }

        /* renamed from: dY */
        public void mo28347dY(boolean z) {
            FxOperationView.this.cLU.mo28892fy(true);
        }

        /* renamed from: iD */
        public void mo28349iD(int i) {
            ((C6148f) FxOperationView.this.getEditor()).mo27874kY(i);
            if (FxOperationView.this.cLO != null) {
                int mp = FxOperationView.this.cLO.mo28430mp(i);
                if (mp >= 0) {
                    FxOperationView.this.cLU.mo28891cz(2, mp);
                } else {
                    FxOperationView.this.cLU.updateState(1);
                }
            }
        }

        /* renamed from: kN */
        public int mo28351kN(int i) {
            return 0;
        }

        /* renamed from: kz */
        public void mo28352kz(int i) {
            ((C6148f) FxOperationView.this.getEditor()).adX();
            ((C6148f) FxOperationView.this.getEditor()).aea();
            FxOperationView.this.aix();
            if (FxOperationView.this.cLO != null) {
                C6149g.m17565fv(FxOperationView.this.cLO.acx());
            }
        }
    };
    /* access modifiers changed from: private */
    public C6141c cLI;
    /* access modifiers changed from: private */
    public C6139b cLJ;
    private LinearLayoutManager cLK;
    /* access modifiers changed from: private */
    public LinearLayoutManager cLL;
    /* access modifiers changed from: private */
    public C6151i cLM;
    /* access modifiers changed from: private */
    public C6147e cLN;
    /* access modifiers changed from: private */
    public VideoEditorSeekLayout cLO;
    /* access modifiers changed from: private */
    public NavEffectTitleLayout cLP;
    private Terminator cLQ;
    /* access modifiers changed from: private */
    public EditorVolumeSetView cLR;
    /* access modifiers changed from: private */
    public TextView cLS;
    /* access modifiers changed from: private */
    public View cLT;
    /* access modifiers changed from: private */
    public C6135a cLU = new C6135a();
    /* access modifiers changed from: private */
    public Range cLV;
    private int cLW = 0;
    /* access modifiers changed from: private */
    public boolean cLX = true;
    /* access modifiers changed from: private */
    public C6146d cLm;
    private C1494a compositeDisposable = new C1494a();

    /* renamed from: com.introvd.template.editor.effects.fx.FxOperationView$a */
    class C6135a {
        /* access modifiers changed from: private */
        public boolean cGk = false;
        private int cMa = -1;
        private boolean cMb = false;
        private int currentState = -1;

        C6135a() {
        }

        private void akI() {
            FxOperationView.this.m17442fx(false);
        }

        private void akJ() {
            if (FxOperationView.this.cLP != null) {
                FxOperationView.this.cLP.mo29002nk(-1);
            }
            FxOperationView.this.cLR.setVisibility(8);
            FxOperationView.this.cLO.aiL();
            FxOperationView.this.cLS.setVisibility(0);
            FxOperationView.this.cLS.setText(R.string.xiaoying_str_editor_sticker_add_new);
            FxOperationView.this.cLS.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    FxOperationView.this.m17442fx(true);
                }
            });
            this.cMa = -1;
        }

        private void akK() {
            if (!this.cGk) {
                this.cGk = true;
                akJ();
                FxOperationView.this.cLS.setVisibility(8);
            }
        }

        private void akL() {
            if (this.cGk) {
                this.cGk = false;
                int akD = FxOperationView.this.getEditor() != null ? ((C6148f) FxOperationView.this.getEditor()).akD() : -1;
                if (akD < 0) {
                    akJ();
                } else {
                    m17497mT(akD);
                }
            }
        }

        /* renamed from: mT */
        private void m17497mT(int i) {
            if (i >= 0) {
                FxOperationView.this.cLR.setVisibility(8);
                C8441b mg = ((C6148f) FxOperationView.this.getEditor()).mo28483mg(i);
                if (mg != null && C8450a.m24472nV(mg.aIf()) && !FxOperationView.this.afE()) {
                    FxOperationView.this.cLR.mo28980nh(mg.eef);
                    FxOperationView.this.cLR.setVisibility(0);
                }
                FxOperationView.this.cLO.mo28429mo(i);
                if (FxOperationView.this.cLP != null) {
                    FxOperationView.this.cLP.mo29002nk(i);
                }
                FxOperationView.this.cLS.setVisibility(0);
                FxOperationView.this.cLS.setText(R.string.xiaoying_str_com_delete_title);
                FxOperationView.this.cLS.setOnClickListener(new OnClickListener() {
                    public void onClick(View view) {
                        FxOperationView.this.akC();
                    }
                });
                this.cMa = i;
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: cz */
        public void mo28891cz(int i, int i2) {
            if (!this.cMb && this.currentState != i) {
                if (this.currentState != 0 || !FxOperationView.this.afE()) {
                    this.currentState = i;
                }
                if (i == 0) {
                    akI();
                } else if (i == 1) {
                    akJ();
                    this.cMa = -1;
                } else if (i == 2) {
                    if (this.cMa != i2) {
                        m17497mT(i2);
                    }
                } else if (i == 3) {
                    akK();
                } else if (i == 4 && this.cGk) {
                    akL();
                }
            }
        }

        /* renamed from: fy */
        public void mo28892fy(boolean z) {
            this.cMb = z;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: mS */
        public boolean mo28893mS(int i) {
            return this.currentState == i;
        }

        /* access modifiers changed from: 0000 */
        public void updateState(int i) {
            mo28891cz(i, 0);
        }
    }

    public FxOperationView(Activity activity) {
        super(activity, C6148f.class);
    }

    /* renamed from: Q */
    private void m17423Q(int i, boolean z) {
        if (z) {
            ajh();
        }
        if (this.cLU != null && getEditor() != null) {
            C8441b mg = ((C6148f) getEditor()).mo28483mg(i);
            if (mg == null || mg.aIc() == null) {
                this.cLU.updateState(0);
                return;
            }
            this.cLU.updateState(1);
            int i2 = mg.aIc().getmPosition();
            this.cLO.mo28394L(i2, false);
            ((C6148f) getEditor()).mo27870ep(true);
            ((C6148f) getEditor()).mo27868b(0, ((C6148f) getEditor()).akB(), false, i2);
            this.cLU.mo28891cz(2, i);
            if (this.cLU.cGk) {
                this.cLX = false;
            }
        }
    }

    /* renamed from: a */
    private String m17427a(EditorIntentInfo editorIntentInfo) {
        if (editorIntentInfo == null) {
            return null;
        }
        String str = (String) editorIntentInfo.paramMap.get(EditorRouter.MAP_PARAMS_TEMPLATE_PATH);
        if (TextUtils.isEmpty(str)) {
            try {
                String str2 = (String) editorIntentInfo.paramMap.get(EditorRouter.MAP_PARAMS_TEMPLATE_ID);
                str = str2 == null ? "" : C8759b.m25586by(Long.decode(str2).longValue());
            } catch (NumberFormatException e) {
                C5523b.logException(e);
            }
        }
        return str;
    }

    /* access modifiers changed from: private */
    /* renamed from: aM */
    public void m17432aM(List<C6146d> list) {
        if (this.cLJ != null) {
            this.cLJ.setDataList(list);
        }
        if (this.cLI != null) {
            C6146d dVar = this.cLm;
            if (dVar == null) {
                dVar = (C6146d) list.get(0);
            }
            if (dVar != null) {
                this.cLI.mo28914c(dVar.akw(), dVar.akA());
            }
        }
    }

    /* access modifiers changed from: private */
    public boolean afE() {
        return this.cLT != null && this.cLT.getVisibility() == 0;
    }

    private void aiT() {
        int i = getBundle().getInt("ve_extra_effect_id", -1);
        QClip dataClip = ((C6148f) getEditor()).adO().getDataClip();
        boolean z = dataClip != null && dataClip.getEffectCountByGroup(2, 6) > 0 && !C5837a.agH().agK();
        if (i >= 0) {
            m17423Q(i, true);
        } else if (z) {
            this.cLU.updateState(1);
            this.compositeDisposable.mo9785e(C1487a.aUa().mo9777a(new Runnable() {
                public void run() {
                    int mp = FxOperationView.this.cLO.mo28430mp(((C6148f) FxOperationView.this.getEditor()).adZ());
                    if (mp >= 0) {
                        FxOperationView.this.cLU.mo28891cz(2, mp);
                    }
                }
            }, 300, TimeUnit.MILLISECONDS));
        } else {
            this.cLU.updateState(0);
            this.compositeDisposable.mo9785e(C1487a.aUa().mo9777a(new Runnable() {
                public void run() {
                    EditorIntentInfo editorIntentInfo = (EditorIntentInfo) PassThoughUrlGenerator.getInfoFromBundle(FxOperationView.this.getBundle(), EditorIntentInfo.class);
                    if (editorIntentInfo != null) {
                        String str = (String) editorIntentInfo.paramMap.get(EditorRouter.MAP_PARAMS_TEMPLATE_PACKAGE_ID);
                        if (FxOperationView.this.cLJ != null) {
                            FxOperationView.this.cLJ.mo28905hs(str);
                        }
                        editorIntentInfo.paramMap.remove(EditorRouter.MAP_PARAMS_TEMPLATE_PACKAGE_ID);
                    }
                }
            }, 600, TimeUnit.MILLISECONDS));
        }
    }

    /* access modifiers changed from: private */
    public void aid() {
        if (this.cLQ != null) {
            this.cLQ.setTitle(R.string.xiaoying_str_ve_animate_frame_title);
        }
    }

    /* access modifiers changed from: private */
    public void aix() {
        if (getEditor() != null) {
            ((C6148f) getEditor()).mo27870ep(true);
            ((C6148f) getEditor()).mo27873h(0, ((C6148f) getEditor()).adO().getDuration(), false);
        }
    }

    /* access modifiers changed from: private */
    public void ajh() {
        if (this.cLQ != null) {
            if (this.cLP == null) {
                this.cLP = new NavEffectTitleLayout(getContext());
            }
            this.cLP.setData(((C6148f) getEditor()).aiz(), hashCode());
            this.cLQ.setTitleContentLayout(this.cLP);
        }
    }

    /* access modifiers changed from: private */
    public void ajp() {
        C8978m.m26348af(getContext(), getContext().getString(R.string.xiaoying_str_com_cancel), getContext().getString(R.string.xiaoying_str_com_ok)).mo10296do(R.string.xiaoying_str_com_dialog_cancel_all_ask).mo10281a((C1904j) new C1904j() {
            public void onClick(C1890f fVar, C1885b bVar) {
                ((C6148f) FxOperationView.this.getEditor()).restore();
                FxOperationView.this.finish();
            }
        }).mo10313qu().show();
    }

    /* access modifiers changed from: private */
    public void akC() {
        ((C6148f) getEditor()).adX();
        if (getEditor() != null) {
            int akD = ((C6148f) getEditor()).akD();
            if (akD >= 0 && getEditor() != null) {
                this.cLO.mo28426ml(akD);
                if (getVideoOperator() != null) {
                    getVideoOperator().mo29678a(new C6485b(3, akD, 6));
                }
                ((C6148f) getEditor()).akC();
                this.cLU.updateState(1);
                ajh();
                C8441b mg = ((C6148f) getEditor()).mo28483mg(akD);
                if (mg != null) {
                    String aIf = mg.aIf();
                    C6149g.m17564f(this.cLN.mo28932hy(aIf), this.cLN.mo28931hx(aIf));
                }
            }
        }
    }

    private void akE() {
        this.cLO = (VideoEditorSeekLayout) findViewById(R.id.ve_music_seek_layout);
        this.cLO.mo28397a(getEditor(), ((C6148f) getEditor()).aiz());
        this.cLO.mo28392J(((C6148f) getEditor()).adZ(), false);
        this.cLO.setmState(1);
        this.cLO.setFineTuningEnable(true);
        this.cLO.setOnOperationCallback(getVideoOperator());
        this.cLO.setmOnTimeLineSeekListener(this.cGO);
        this.cLO.setMaskDrawable(getResources().getDrawable(R.color.color_ffbd18_p30));
        this.cLO.setTrimMaskDrawable(getResources().getDrawable(R.color.color_ffbd18_p50));
        this.cLO.setOnVideoEditorSeekListener(new C5910b() {
            public void aav() {
                if (FxOperationView.this.cLO != null && FxOperationView.this.getVideoOperator() != null) {
                    ((C6148f) FxOperationView.this.getEditor()).adY();
                }
            }

            public void pauseVideo() {
                ((C6148f) FxOperationView.this.getEditor()).adX();
            }
        });
    }

    private void akF() {
        this.cLR = (EditorVolumeSetView) findViewById(R.id.view_effect_volume_set);
        this.cLR.setVolumeSetListener(new C6176a() {
            /* renamed from: mu */
            public void mo28584mu(int i) {
                if (FxOperationView.this.getEditor() != null) {
                    ((C6148f) FxOperationView.this.getEditor()).mo28939mO(i);
                }
            }
        });
    }

    private void akG() {
        this.cLQ = (Terminator) findViewById(R.id.terminator);
        this.cLQ.setTitle(R.string.xiaoying_str_ve_animate_frame_title);
        this.cLQ.setTerminatorListener(new C5858a() {
            public void aeW() {
                boolean z = false;
                if (FxOperationView.this.cLU.mo28893mS(0)) {
                    FxOperationView.this.akC();
                } else {
                    if (FxOperationView.this.afE()) {
                        FxOperationView.this.akC();
                        FxOperationView.this.akH();
                    } else if (((C6148f) FxOperationView.this.getEditor()).aiw()) {
                        FxOperationView.this.ajp();
                    }
                    z = true;
                }
                if (!z) {
                    FxOperationView.this.finish();
                }
            }

            public void aeX() {
                if (!FxOperationView.this.afE() || FxOperationView.this.cLM == null) {
                    FxOperationView.this.finish();
                } else {
                    FxOperationView.this.akH();
                    if (FxOperationView.this.cLV != null) {
                        ((C6148f) FxOperationView.this.getEditor()).mo27846H(FxOperationView.this.cLV.getmPosition(), true);
                        EffectInfoModel akN = FxOperationView.this.cLM.akN();
                        if (akN != null) {
                            C6149g.m17563e(akN.mTemplateId, akN.mName);
                        }
                    }
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void akH() {
        this.cLO.setFineTuningEnable(true);
        C2564c.m7324b(this.cLT, 0.0f, (float) C5840b.cEx, new C2569a() {
            public void onFinish() {
                FxOperationView.this.ajh();
                FxOperationView.this.cLT.setVisibility(8);
                FxOperationView.this.aku();
            }
        });
    }

    /* access modifiers changed from: private */
    public void aku() {
        if (this.cLJ != null) {
            this.cLJ.aku();
            if (this.cLI != null) {
                C6146d akv = this.cLJ.akv();
                if (akv != null) {
                    this.cLI.mo28913a((C6151i) null, false);
                    this.cLI.mo28914c(akv.akw(), akv.akA());
                    this.cLm = akv;
                    this.cLM = null;
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m17437c(int i, Range range) {
        if (range != null && getEditor() != null && range.getmTimeLength() > 0) {
            ((C6148f) getEditor()).mo28937c(i, range);
            if (getVideoOperator() != null) {
                getVideoOperator().mo29678a(new C6485b(2, ((C6148f) getEditor()).akD(), 6));
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m17441f(C6151i iVar) {
        int i;
        Range range;
        if (getEditor() != null && getVideoOperator() != null) {
            ((C6148f) getEditor()).adX();
            int akD = ((C6148f) getEditor()).akD();
            boolean z = akD < 0;
            if (z) {
                this.cLW = ((C6148f) getEditor()).adZ();
                ((C6148f) getEditor()).mo28940mQ(this.cLW);
                range = ((C6148f) getEditor()).mo28936c(iVar);
                i = 1;
            } else {
                ((C6148f) getEditor()).mo28940mQ(this.cLW);
                range = ((C6148f) getEditor()).mo28938d(iVar);
                i = 2;
                ((C6148f) getEditor()).mo27846H(this.cLW, false);
            }
            this.cLV = range;
            if (range != null && this.cLO != null) {
                if (z) {
                    this.cLO.mo28413c(new Range(range));
                } else {
                    this.cLO.mo28426ml(akD);
                    this.cLO.mo28413c(new Range(range));
                }
                getVideoOperator().mo29686b(new C6485b(i, ((C6148f) getEditor()).akD(), 6));
                ((C6148f) getEditor()).mo27870ep(false);
                ((C6148f) getEditor()).mo27868b(range.getmPosition(), range.getmTimeLength(), true, range.getmPosition());
                ((C6148f) getEditor()).adY();
                EffectInfoModel akN = iVar.akN();
                if (akN != null) {
                    C6149g.m17567g(akN.mTemplateId, akN.mName);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: fx */
    public void m17442fx(boolean z) {
        if (getEditor() != null) {
            if (!m17452mR(((C6148f) getEditor()).adZ())) {
                if (!z && this.cLS != null) {
                    this.cLS.setOnClickListener(new OnClickListener() {
                        public void onClick(View view) {
                            FxOperationView.this.m17442fx(true);
                        }
                    });
                }
                ToastUtils.shortShow(getContext(), R.string.xiaoying_str_ve_msg_duration_not_long_enough);
                return;
            }
            this.cLO.setFineTuningEnable(false);
            this.cLT.setVisibility(0);
            if (z) {
                C2564c.m7322a(this.cLT, (float) C5840b.cEx, 0.0f, new C2569a() {
                    public void onFinish() {
                        FxOperationView.this.aid();
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: hA */
    public void m17445hA(String str) {
        this.cLM = this.cLN.mo28929hv(str);
        if (this.cLM != null) {
            this.cLm = this.cLN.mo28930hw(this.cLM.akw());
            this.cLJ.mo28899a(this.cLm);
            this.cLI.mo28913a(this.cLM, false);
            this.cLI.mo28914c(this.cLm.akw(), this.cLm.akA());
            int b = this.cLJ.mo28904b(this.cLm);
            if (b >= 0) {
                this.cLK.scrollToPosition(b);
            }
            int a = this.cLI.mo28909a(this.cLM);
            if (a >= 0) {
                this.cLL.scrollToPosition(a);
            }
            m17441f(this.cLM);
        }
    }

    /* renamed from: hz */
    private void m17446hz(final String str) {
        this.cLT = findViewById(R.id.include_fx_chosen_panel);
        this.cLK = new LinearLayoutManager(getContext(), 0, false);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_category_group);
        recyclerView.setLayoutManager(this.cLK);
        this.cLJ = new C6139b(getContext());
        this.cLJ.mo28898a((C6138a<C6146d>) new C6138a<C6146d>() {
            /* renamed from: d */
            public void mo28880S(C6146d dVar) {
                if (FxOperationView.this.cLI != null && dVar != null) {
                    FxOperationView.this.cLm = dVar;
                    FxOperationView.this.cLI.mo28914c(dVar.akw(), dVar.akA());
                }
            }
        });
        recyclerView.setAdapter(this.cLJ);
        this.cLJ.notifyDataSetChanged();
        this.cLL = new LinearLayoutManager(getContext(), 0, false);
        RecyclerView recyclerView2 = (RecyclerView) findViewById(R.id.recycler_category_group_detail);
        recyclerView2.setLayoutManager(this.cLL);
        this.cLI = new C6141c(getContext(), new C6145b() {
            /* renamed from: mN */
            public View mo28885mN(int i) {
                int findFirstVisibleItemPosition = i - FxOperationView.this.cLL.findFirstVisibleItemPosition();
                if (findFirstVisibleItemPosition < 0 || FxOperationView.this.cLL.getChildCount() <= findFirstVisibleItemPosition) {
                    return null;
                }
                return FxOperationView.this.cLL.findViewByPosition(findFirstVisibleItemPosition);
            }
        }, new C6144a() {
            /* access modifiers changed from: 0000 */
            /* renamed from: ay */
            public C6151i mo28886ay(long j) {
                if (FxOperationView.this.cLN == null) {
                    return null;
                }
                return FxOperationView.this.cLN.mo28928az(j);
            }
        });
        this.cLI.mo28910a((C6138a<C6151i>) new C6138a<C6151i>() {
            /* renamed from: g */
            public void mo28880S(C6151i iVar) {
                if (!C4580b.m11632Sf()) {
                    FxOperationView.this.cLM = iVar;
                    FxOperationView.this.m17441f(iVar);
                }
            }
        });
        recyclerView2.setAdapter(this.cLI);
        this.cLI.notifyDataSetChanged();
        this.cLN = new C6147e();
        C1848s.m5326ai(Boolean.valueOf(true)).mo10194f(C1820a.aVi()).mo10199i(new C1518f<Boolean, List<C6146d>>() {
            /* renamed from: i */
            public List<C6146d> apply(Boolean bool) {
                return FxOperationView.this.cLN.mo28927a(FxOperationView.this.getEditor());
            }
        }).mo10193c(new C1520h<List<C6146d>>() {
            /* renamed from: aO */
            public boolean test(List<C6146d> list) {
                return list != null && !list.isEmpty();
            }
        }).mo10104c(new C1518f<List<C6146d>, C1852w<List<C6146d>>>() {
            /* renamed from: aN */
            public C1852w<List<C6146d>> apply(List<C6146d> list) {
                return C1848s.m5326ai(list);
            }
        }).mo10194f(C1487a.aUa()).mo10188a((C1850u<? super T>) new C1810c<List<C6146d>>() {
            public void onError(Throwable th) {
                StringBuilder sb = new StringBuilder();
                sb.append("error message: ");
                sb.append(th.toString());
                LogUtilsV2.m14228e(sb.toString());
            }

            public void onSuccess(List<C6146d> list) {
                FxOperationView.this.cLm = (C6146d) list.get(0);
                FxOperationView.this.cLJ.setDataList(list);
                if (FxOperationView.this.cLm != null) {
                    FxOperationView.this.cLI.mo28914c(FxOperationView.this.cLm.akw(), FxOperationView.this.cLm.akA());
                    if (!TextUtils.isEmpty(str)) {
                        FxOperationView.this.m17445hA(str);
                    }
                }
            }
        });
    }

    /* renamed from: mR */
    private boolean m17452mR(int i) {
        if (getEditor() == null || ((C6148f) getEditor()).akB() - i < 500) {
            return false;
        }
        return !C8538o.m24877h(((C6148f) getEditor()).adO(), i + HttpStatus.SC_INTERNAL_SERVER_ERROR);
    }

    public void aex() {
        super.aex();
        C10021c.aZH().mo38494ax(this);
        akG();
        akE();
        akF();
        this.cLS = (TextView) findViewById(R.id.ve_music_op_btn);
        findViewById(R.id.iv_download_more).setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                TemplateRouter.launchAnimateFrameForResult(FxOperationView.this.getActivity(), C8399c.edd, 24580);
            }
        });
        m17446hz(m17427a((EditorIntentInfo) PassThoughUrlGenerator.getInfoFromBundle(getBundle(), EditorIntentInfo.class)));
        aiT();
    }

    public boolean aey() {
        return true;
    }

    public C5688b getFineTuningListener() {
        return new C5688b() {
            /* renamed from: a */
            public void mo27798a(C5687a aVar) {
                FxOperationView.this.cLO.mo28411b(aVar);
            }

            /* renamed from: a */
            public boolean mo27799a(Point point) {
                return false;
            }

            public boolean aet() {
                return FxOperationView.this.cLO.ait();
            }

            public void aeu() {
                FxOperationView.this.cLO.aeu();
                FxOperationView.this.cLO.aiM();
                if (FxOperationView.this.cLO.getFocusState() != 0) {
                    FxOperationView.this.cLU.mo28892fy(true);
                }
            }

            public int aev() {
                return FxOperationView.this.cLO.aev();
            }

            public void aew() {
                FxOperationView.this.cLO.aew();
                FxOperationView.this.cLU.mo28892fy(false);
            }

            /* renamed from: hV */
            public int mo27804hV(int i) {
                return FxOperationView.this.cLO.mo28423hV(i);
            }

            /* renamed from: lb */
            public void mo27805lb(int i) {
                if (FxOperationView.this.cLO != null) {
                    FxOperationView.this.cLO.mo28425lb(i);
                    int mp = FxOperationView.this.cLO.mo28430mp(i);
                    if (mp >= 0) {
                        FxOperationView.this.cLU.mo28891cz(2, mp);
                        C6149g.m17566fw(FxOperationView.this.cLO.aiP());
                    } else {
                        FxOperationView.this.cLU.updateState(1);
                    }
                }
            }
        };
    }

    public int getLayoutId() {
        return R.layout.editor_effect_fx_layout;
    }

    public C6280b getPlayerStatusListener() {
        return new C6280b() {
            /* renamed from: J */
            public void mo27793J(int i, boolean z) {
                if (FxOperationView.this.cLO != null) {
                    FxOperationView.this.cLO.mo28392J(i, z);
                }
            }

            /* renamed from: K */
            public void mo27794K(int i, boolean z) {
                StringBuilder sb = new StringBuilder();
                sb.append("onPlayerPlaying = ");
                sb.append(i);
                LogUtilsV2.m14227d(sb.toString());
                if (FxOperationView.this.cLO != null) {
                    FxOperationView.this.cLO.mo28393K(i, z);
                }
                FxOperationView.this.cLU.updateState(3);
            }

            /* renamed from: L */
            public void mo27795L(int i, boolean z) {
                if (!FxOperationView.this.cLX) {
                    FxOperationView.this.cLX = true;
                    return;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("onPlayerPause = ");
                sb.append(i);
                LogUtilsV2.m14227d(sb.toString());
                if (FxOperationView.this.cLO != null) {
                    FxOperationView.this.cLO.mo28394L(i, z);
                }
                FxOperationView.this.cLU.updateState(4);
            }

            /* renamed from: M */
            public void mo27796M(int i, boolean z) {
                StringBuilder sb = new StringBuilder();
                sb.append("onPlayerStop = ");
                sb.append(i);
                LogUtilsV2.m14227d(sb.toString());
                if (FxOperationView.this.cLO != null) {
                    FxOperationView.this.cLO.mo28395M(i, z);
                }
                FxOperationView.this.cLU.updateState(4);
                if (!FxOperationView.this.afE()) {
                    FxOperationView.this.aix();
                } else if (FxOperationView.this.cLV != null) {
                    ((C6148f) FxOperationView.this.getEditor()).mo27846H(FxOperationView.this.cLV.getmPosition(), false);
                }
            }

            public void aes() {
            }
        };
    }

    public int getStreamType() {
        return 0;
    }

    public void onActivityDestroy() {
        ((C6148f) getEditor()).adX();
        if (getEditor() != null) {
            ((C6148f) getEditor()).mo27873h(0, ((C6148f) getEditor()).adO().getDuration(), false);
        }
        if (this.cLI != null) {
            this.cLI.destroy();
        }
        if (this.cLO != null) {
            this.cLO.destroy();
        }
        if (this.compositeDisposable != null) {
            this.compositeDisposable.clear();
        }
        C10021c.aZH().mo38496az(this);
        super.onActivityDestroy();
    }

    public void onActivityPause() {
        super.onActivityPause();
        this.cLI.mo28910a(null);
    }

    public void onActivityResult(int i, final int i2, final Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 24580) {
            C1848s.m5326ai(Integer.valueOf(i)).mo10194f(C1820a.aVi()).mo10199i(new C1518f<Integer, List<C6146d>>() {
                /* renamed from: i */
                public List<C6146d> apply(Integer num) {
                    return FxOperationView.this.cLN.mo28927a(FxOperationView.this.getEditor());
                }
            }).mo10194f(C1487a.aUa()).mo10199i(new C1518f<List<C6146d>, Object>() {
                /* renamed from: aP */
                public Object apply(List<C6146d> list) {
                    FxOperationView.this.m17432aM(list);
                    return Boolean.valueOf(true);
                }
            }).mo10193c(new C1520h<Object>() {
                public boolean test(Object obj) {
                    return i2 == -1 && intent != null;
                }
            }).mo10104c(new C1518f<Object, C1852w<String>>() {
                /* renamed from: T */
                public C1852w<String> apply(Object obj) {
                    return C1848s.m5326ai(intent.getStringExtra("template_path"));
                }
            }).mo10194f(C1820a.aVi()).mo10200k(100, TimeUnit.MILLISECONDS).mo10199i(new C1518f<String, String>() {
                /* renamed from: hB */
                public String apply(String str) {
                    if (FxOperationView.this.getVideoOperator() != null && FxOperationView.this.getVideoOperator().aog()) {
                        return str;
                    }
                    throw new IllegalStateException("player is not ready!");
                }
            }).mo10192bU(5).mo10194f(C1487a.aUa()).mo10188a((C1850u<? super T>) new C1810c<String>() {
                /* renamed from: dV */
                public void onSuccess(String str) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("handle: ");
                    sb.append(str);
                    LogUtilsV2.m14230i(sb.toString());
                    FxOperationView.this.m17445hA(str);
                }

                public void onError(Throwable th) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("error message: ");
                    sb.append(th.toString());
                    LogUtilsV2.m14228e(sb.toString());
                }
            });
        }
    }

    public void onActivityResume() {
        super.onActivityResume();
        this.cLI.mo28910a((C6138a<C6151i>) new C6138a<C6151i>() {
            /* renamed from: g */
            public void mo28880S(C6151i iVar) {
                if (!C4580b.m11632Sf()) {
                    FxOperationView.this.cLM = iVar;
                    FxOperationView.this.m17441f(iVar);
                }
            }
        });
    }

    public boolean onBackPressed() {
        boolean onBackPressed = super.onBackPressed();
        if (this.cLU.mo28893mS(0)) {
            akC();
            return false;
        } else if (afE()) {
            akC();
            akH();
            return true;
        } else if (!((C6148f) getEditor()).aiw()) {
            return onBackPressed;
        } else {
            ajp();
            return true;
        }
    }

    @C10031j
    public void onEventMainThread(C6185b bVar) {
        m17423Q(bVar.cNh, false);
    }
}
