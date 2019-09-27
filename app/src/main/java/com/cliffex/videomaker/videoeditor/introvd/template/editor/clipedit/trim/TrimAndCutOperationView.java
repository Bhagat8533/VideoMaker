package com.introvd.template.editor.clipedit.trim;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Point;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.RelativeLayout;
import com.afollestad.materialdialogs.C1885b;
import com.afollestad.materialdialogs.C1890f;
import com.afollestad.materialdialogs.C1890f.C1904j;
import com.google.gson.Gson;
import com.introvd.template.app.p177b.C3742b;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.editor.R;
import com.introvd.template.editor.base.BaseOperationView;
import com.introvd.template.editor.clipedit.trim.C5822a.C5829c;
import com.introvd.template.editor.clipedit.trim.C5822a.C5830d;
import com.introvd.template.editor.common.terminator.Terminator;
import com.introvd.template.editor.common.terminator.Terminator.C5858a;
import com.introvd.template.editor.p246c.C5687a;
import com.introvd.template.editor.p246c.C5688b;
import com.introvd.template.editor.p259f.C6280b;
import com.introvd.template.editor.p259f.C6282d;
import com.introvd.template.editor.p261g.C6293a;
import com.introvd.template.editor.p261g.C6312c;
import com.introvd.template.editor.preview.p271b.C6550a;
import com.introvd.template.editor.widget.timeline.VeAdvanceTrimGallery;
import com.introvd.template.p414ui.dialog.C8978m;
import com.introvd.template.router.PassThoughUrlGenerator;
import com.introvd.template.router.editor.EditorIntentInfo;
import com.introvd.template.sdk.editor.cache.C8440a;
import com.introvd.template.sdk.utils.p394b.C8540q;
import org.greenrobot.eventbus.C10021c;
import xiaoying.engine.base.QRange;
import xiaoying.engine.clip.QClip;

@SuppressLint({"ViewConstructor"})
public class TrimAndCutOperationView extends BaseOperationView<C5831b> {
    /* access modifiers changed from: private */
    public C5822a cCF;
    /* access modifiers changed from: private */
    public C8440a cCG;
    private C5829c cCI = new C5829c() {
        public void afS() {
            LogUtilsV2.m14227d("onSeekStart");
            ((C5831b) TrimAndCutOperationView.this.getEditor()).aea();
        }

        /* renamed from: lr */
        public void mo28063lr(int i) {
            StringBuilder sb = new StringBuilder();
            sb.append("onSeekPosChange progress = ");
            sb.append(i);
            LogUtilsV2.m14227d(sb.toString());
            ((C5831b) TrimAndCutOperationView.this.getEditor()).mo27874kY(i);
        }

        /* renamed from: ls */
        public void mo28064ls(int i) {
            StringBuilder sb = new StringBuilder();
            sb.append("onSeekEnd destTime = ");
            sb.append(i);
            LogUtilsV2.m14227d(sb.toString());
            ((C5831b) TrimAndCutOperationView.this.getEditor()).aeb();
            if (TrimAndCutOperationView.this.getVideoOperator() != null) {
                TrimAndCutOperationView.this.agj();
                ((C5831b) TrimAndCutOperationView.this.getEditor()).adY();
                if (TrimAndCutOperationView.this.cCF.agr()) {
                    C5835d.m16318aP(TrimAndCutOperationView.this.getContext(), TtmlNode.LEFT);
                } else {
                    C5835d.m16318aP(TrimAndCutOperationView.this.getContext(), TtmlNode.RIGHT);
                }
            }
        }
    };
    /* access modifiers changed from: private */
    public boolean cDA = false;
    private C5830d cDB = new C5830d() {
        /* renamed from: eH */
        public void mo28118eH(boolean z) {
            StringBuilder sb = new StringBuilder();
            sb.append("onTrimStart isLeft = ");
            sb.append(z);
            LogUtilsV2.m14227d(sb.toString());
            if (TrimAndCutOperationView.this.cCF != null) {
                TrimAndCutOperationView.this.cCF.setPlaying(false);
            }
            if (TrimAndCutOperationView.this.getEditor() != null) {
                ((C5831b) TrimAndCutOperationView.this.getEditor()).adX();
                ((C5831b) TrimAndCutOperationView.this.getEditor()).aea();
            }
            TrimAndCutOperationView.this.cDA = !z;
        }

        /* renamed from: ly */
        public void mo28119ly(int i) {
            TrimAndCutOperationView.this.isModified = true;
            StringBuilder sb = new StringBuilder();
            sb.append("onTrimPosChange position = ");
            sb.append(i);
            LogUtilsV2.m14227d(sb.toString());
            ((C5831b) TrimAndCutOperationView.this.getEditor()).mo27874kY(i);
        }

        /* renamed from: lz */
        public int mo28120lz(int i) {
            StringBuilder sb = new StringBuilder();
            sb.append("onTrimEnd position = ");
            sb.append(i);
            LogUtilsV2.m14227d(sb.toString());
            ((C5831b) TrimAndCutOperationView.this.getEditor()).mo27874kY(i);
            ((C5831b) TrimAndCutOperationView.this.getEditor()).aeb();
            return 0;
        }
    };
    /* access modifiers changed from: private */
    public RadioGroup cDw;
    /* access modifiers changed from: private */
    public RadioButton cDx;
    /* access modifiers changed from: private */
    public RadioButton cDy;
    /* access modifiers changed from: private */
    public boolean cDz = true;
    /* access modifiers changed from: private */
    public boolean isModified = false;
    private int startPos = 0;

    public TrimAndCutOperationView(Activity activity) {
        super(activity, C5831b.class);
    }

    /* access modifiers changed from: private */
    public boolean aeV() {
        if (!aeA() || getActivity() == null) {
            return false;
        }
        String string = getActivity().getString(R.string.xiaoying_str_com_ok);
        C8978m.m26348af(getActivity(), getActivity().getString(R.string.xiaoying_str_com_cancel), string).mo10296do(R.string.xiaoying_str_com_dialog_cancel_all_ask).mo10281a((C1904j) new C1904j() {
            public void onClick(C1890f fVar, C1885b bVar) {
                TrimAndCutOperationView.this.exit();
            }
        }).mo10313qu().show();
        return true;
    }

    private void agi() {
        this.cCF = new C5822a((RelativeLayout) findViewById(R.id.layout_trim_relate), C8540q.m24956i(((C5831b) getEditor()).adO(), ((C5831b) getEditor()).getFocusIndex()), this.cCG, ((C5831b) getEditor()).getFocusIndex());
        this.cCF.mo28125a(this.cDB);
        this.cCF.mo28124a(this.cCI);
        this.cCF.mo28136eI(false);
    }

    /* access modifiers changed from: private */
    public void agj() {
        int i;
        if (this.cCF != null) {
            C5832c agp = this.cCF.agp();
            if (agp != null) {
                int agB = agp.agB();
                int agC = agp.agC();
                if (this.cDA) {
                    this.cDA = false;
                    i = agC - 1000;
                } else {
                    i = agB;
                }
                if (i <= 0) {
                    i = 0;
                }
                if (!this.cCF.isPlaying()) {
                    ((C5831b) getEditor()).mo27868b(agB, agC - agB, false, i);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0051 A[RETURN] */
    /* renamed from: eG */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean m16204eG(boolean r4) {
        /*
            r3 = this;
            com.introvd.template.editor.clipedit.trim.a r0 = r3.cCF
            r1 = 1
            if (r0 == 0) goto L_0x0052
            com.introvd.template.sdk.editor.cache.a r0 = r3.cCG
            if (r0 == 0) goto L_0x0052
            com.introvd.template.sdk.editor.cache.a r0 = r3.cCG
            xiaoying.engine.base.QRange r0 = r0.edJ
            if (r0 != 0) goto L_0x0010
            goto L_0x0052
        L_0x0010:
            com.introvd.template.sdk.editor.cache.a r0 = r3.cCG
            int r0 = r0.aHR()
            r2 = 0
            if (r4 == 0) goto L_0x0033
            com.introvd.template.editor.clipedit.trim.a r4 = r3.cCF
            com.introvd.template.editor.clipedit.trim.c r4 = r4.agp()
            int r4 = r4.agB()
            if (r4 != 0) goto L_0x0051
            com.introvd.template.editor.clipedit.trim.a r4 = r3.cCF
            com.introvd.template.editor.clipedit.trim.c r4 = r4.agp()
            int r4 = r4.agC()
            int r0 = r0 - r1
            if (r4 != r0) goto L_0x0051
            return r2
        L_0x0033:
            com.introvd.template.editor.clipedit.trim.a r4 = r3.cCF
            com.introvd.template.editor.clipedit.trim.c r4 = r4.agp()
            int r4 = r4.agB()
            int r0 = r0 / 4
            if (r4 != r0) goto L_0x0051
            com.introvd.template.editor.clipedit.trim.a r4 = r3.cCF
            com.introvd.template.editor.clipedit.trim.c r4 = r4.agp()
            int r4 = r4.agC()
            int r0 = r0 * 3
            int r0 = r0 - r1
            if (r4 != r0) goto L_0x0051
            return r2
        L_0x0051:
            return r1
        L_0x0052:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.editor.clipedit.trim.TrimAndCutOperationView.m16204eG(boolean):boolean");
    }

    /* access modifiers changed from: private */
    public void save() {
        boolean z;
        if (getEditor() != null && this.cCG != null) {
            QRange aHT = this.cCG.aHT();
            if (aHT != null) {
                ((C5831b) this.cyD).mo27884a(C6312c.CLIP_TRIM, false, true);
                int i = aHT.get(0);
                int i2 = (aHT.get(0) + aHT.get(1)) - 1;
                boolean aIa = this.cCG.aIa();
                int agB = this.cCF.agp().agB();
                int agC = this.cCF.agp().agC();
                if (this.cDz) {
                    z = ((C5831b) getEditor()).mo28176b(i, i2, aIa, agB, agC, ((C5831b) getEditor()).getFocusIndex());
                } else {
                    QRange aHZ = this.cCG.aHZ();
                    if (aHZ != null) {
                        i = aHZ.get(0);
                        i2 = aHZ.get(1);
                    }
                    z = ((C5831b) getEditor()).mo28175a(i, i2, aIa, agB, agC, ((C5831b) getEditor()).getFocusIndex());
                }
                if (z) {
                    C6293a.anj().ann();
                    ((C5831b) getEditor()).adL().mo34669jt(true);
                    C10021c.aZH().mo38492aA(new C6550a(1, ((C5831b) this.cyD).aeK()));
                } else {
                    C6293a.anj().anm();
                }
            }
        }
    }

    public boolean aeA() {
        return this.isModified;
    }

    public void aex() {
        super.aex();
        if (((C5831b) getEditor()).aeK().size() == 0) {
            exit();
            return;
        }
        EditorIntentInfo editorIntentInfo = (EditorIntentInfo) PassThoughUrlGenerator.getInfoFromBundle(getBundle(), EditorIntentInfo.class);
        if (editorIntentInfo != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("editorIntentInfo = ");
            sb.append(new Gson().toJson((Object) editorIntentInfo));
            LogUtilsV2.m14227d(sb.toString());
        }
        this.cCG = ((C5831b) getEditor()).mo27893lf(((C5831b) getEditor()).getFocusIndex());
        if (this.cCG == null || this.cCG.aHR() <= 0) {
            exit();
            return;
        }
        this.cDw = (RadioGroup) findViewById(R.id.radio_group);
        if (C3742b.m9111II().mo23166Jm()) {
            this.cDw.setVisibility(8);
        }
        this.cDx = (RadioButton) findViewById(R.id.trim_button);
        this.cDy = (RadioButton) findViewById(R.id.cut_button);
        this.cDw.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (TrimAndCutOperationView.this.cCF != null && TrimAndCutOperationView.this.cCF.isPlaying()) {
                    TrimAndCutOperationView.this.cCF.setPlaying(false);
                }
                ((C5831b) TrimAndCutOperationView.this.getEditor()).adX();
                if (i == R.id.trim_button) {
                    TrimAndCutOperationView.this.cDx.setChecked(true);
                    TrimAndCutOperationView.this.cDy.setChecked(false);
                    if (TrimAndCutOperationView.this.cCF != null) {
                        if (TrimAndCutOperationView.this.m16204eG(false)) {
                            TrimAndCutOperationView.this.cCF.mo28133b(TrimAndCutOperationView.this.getContext(), true, true);
                        } else {
                            TrimAndCutOperationView.this.cCF.mo28133b(TrimAndCutOperationView.this.getContext(), true, false);
                        }
                        TrimAndCutOperationView.this.cDw.post(new Runnable() {
                            public void run() {
                                if (TrimAndCutOperationView.this.cCF != null) {
                                    TrimAndCutOperationView.this.cCF.mo28137eJ(true);
                                }
                            }
                        });
                    }
                    TrimAndCutOperationView.this.cDz = true;
                    return;
                }
                TrimAndCutOperationView.this.cDx.setChecked(false);
                TrimAndCutOperationView.this.cDy.setChecked(true);
                if (TrimAndCutOperationView.this.cCF != null) {
                    if (TrimAndCutOperationView.this.m16204eG(true)) {
                        TrimAndCutOperationView.this.cCF.mo28133b(TrimAndCutOperationView.this.getContext(), false, true);
                    } else {
                        TrimAndCutOperationView.this.cCF.mo28133b(TrimAndCutOperationView.this.getContext(), false, false);
                    }
                    TrimAndCutOperationView.this.cDw.post(new Runnable() {
                        public void run() {
                            if (TrimAndCutOperationView.this.cCF != null) {
                                TrimAndCutOperationView.this.cCF.mo28137eJ(false);
                            }
                        }
                    });
                }
                TrimAndCutOperationView.this.cDz = false;
            }
        });
        Terminator terminator = (Terminator) findViewById(R.id.terminator);
        terminator.setTitle(R.string.xiaoying_str_ve_basic_trim_title);
        terminator.setTerminatorListener(new C5858a() {
            public void aeW() {
                if (!TrimAndCutOperationView.this.aeV()) {
                    TrimAndCutOperationView.this.exit();
                }
            }

            public void aeX() {
                if (!TrimAndCutOperationView.this.cDz && TrimAndCutOperationView.this.cCF != null) {
                    C5835d.m16320aR(TrimAndCutOperationView.this.getContext(), TrimAndCutOperationView.this.cCF.agr() ? TtmlNode.LEFT : TtmlNode.RIGHT);
                }
                TrimAndCutOperationView.this.save();
                TrimAndCutOperationView.this.exit();
            }
        });
        agi();
        this.startPos = this.cCG.aHT().get(0);
        if (this.cDw.getVisibility() == 0) {
            QClip lM = ((C5831b) getEditor()).mo28178lM(((C5831b) getEditor()).getFocusIndex());
            if (lM != null) {
                this.cDw.check(((Boolean) lM.getProperty(QClip.PROP_CLIP_REVERSE_TRIM_MDOE)).booleanValue() ? R.id.cut_button : R.id.trim_button);
            }
        }
    }

    public C5688b getFineTuningListener() {
        return new C5688b() {
            private boolean cDE = false;

            /* renamed from: a */
            public void mo27798a(C5687a aVar) {
            }

            /* renamed from: a */
            public boolean mo27799a(Point point) {
                return false;
            }

            public boolean aet() {
                LogUtilsV2.m14227d("isFineTuningAble");
                return true;
            }

            public void aeu() {
                LogUtilsV2.m14227d("onFineTuningDown");
                if (TrimAndCutOperationView.this.cCF != null && TrimAndCutOperationView.this.cCF.agp() != null && TrimAndCutOperationView.this.cCF.isPlaying()) {
                    TrimAndCutOperationView.this.cCF.setPlaying(false);
                    ((C5831b) TrimAndCutOperationView.this.getEditor()).mo27868b(0, TrimAndCutOperationView.this.cCG.aHR(), false, TrimAndCutOperationView.this.cCF.agp().agB());
                    ((C5831b) TrimAndCutOperationView.this.getEditor()).mo27846H(TrimAndCutOperationView.this.cCF.agp().agB(), false);
                }
            }

            public int aev() {
                this.cDE = true;
                if (TrimAndCutOperationView.this.cCF == null) {
                    return 0;
                }
                int agB = TrimAndCutOperationView.this.cCF.agr() ? TrimAndCutOperationView.this.cCF.agp().agB() : TrimAndCutOperationView.this.cCF.agp().agC();
                StringBuilder sb = new StringBuilder();
                sb.append("onFineTuningStart startPos = ");
                sb.append(agB);
                LogUtilsV2.m14227d(sb.toString());
                return agB;
            }

            public void aew() {
                this.cDE = false;
                LogUtilsV2.m14227d("onFineTuningUp");
                if (TrimAndCutOperationView.this.cCF != null) {
                    if (TrimAndCutOperationView.this.cCF.agr()) {
                        C5835d.m16319aQ(TrimAndCutOperationView.this.getContext(), TtmlNode.LEFT);
                    } else {
                        C5835d.m16319aQ(TrimAndCutOperationView.this.getContext(), TtmlNode.RIGHT);
                    }
                }
            }

            /* renamed from: hV */
            public int mo27804hV(int i) {
                if (TrimAndCutOperationView.this.cCF == null || i < 0) {
                    return 0;
                }
                int aHR = TrimAndCutOperationView.this.cCG.aHR();
                int i2 = aHR - 1;
                if (i > i2) {
                    i = i2;
                }
                if (TrimAndCutOperationView.this.cCF.agp() != null) {
                    if (TrimAndCutOperationView.this.cDz) {
                        if (TrimAndCutOperationView.this.cCF.agr()) {
                            if (i > aHR - VeAdvanceTrimGallery.dxa) {
                                i = aHR - VeAdvanceTrimGallery.dxa;
                            }
                        } else if (i < VeAdvanceTrimGallery.dxa + 0) {
                            i = VeAdvanceTrimGallery.dxa + 0;
                        }
                    } else if (TrimAndCutOperationView.this.cCF.agr()) {
                        if (i >= TrimAndCutOperationView.this.cCF.agp().agC()) {
                            i = TrimAndCutOperationView.this.cCF.agp().agC() - 1;
                        }
                    } else if (i <= TrimAndCutOperationView.this.cCF.agp().agB()) {
                        i = TrimAndCutOperationView.this.cCF.agp().agB() + 1;
                    }
                }
                StringBuilder sb = new StringBuilder();
                sb.append("onValidateTime curTime = ");
                sb.append(i);
                LogUtilsV2.m14227d(sb.toString());
                return i;
            }

            /* renamed from: lb */
            public void mo27805lb(int i) {
                TrimAndCutOperationView.this.isModified = true;
                StringBuilder sb = new StringBuilder();
                sb.append("onFineTuningChange position = ");
                sb.append(i);
                LogUtilsV2.m14227d(sb.toString());
                if (TrimAndCutOperationView.this.cCF != null && this.cDE) {
                    TrimAndCutOperationView.this.cCF.mo28144lE(i);
                }
            }
        };
    }

    public int getLayoutId() {
        return R.layout.editor_clip_trim_and_cut_ops;
    }

    public int getPlayerInitTime() {
        return this.startPos;
    }

    public C6280b getPlayerStatusListener() {
        return new C6280b() {
            /* renamed from: J */
            public void mo27793J(int i, boolean z) {
                StringBuilder sb = new StringBuilder();
                sb.append("onPlayerReady progress = ");
                sb.append(i);
                LogUtilsV2.m14227d(sb.toString());
                if (TrimAndCutOperationView.this.cCF != null) {
                    TrimAndCutOperationView.this.cCF.mo28146lG(i);
                }
            }

            /* renamed from: K */
            public void mo27794K(int i, boolean z) {
                StringBuilder sb = new StringBuilder();
                sb.append("onPlayerPlaying progress = ");
                sb.append(i);
                sb.append(", isUserSeeking = ");
                sb.append(z);
                LogUtilsV2.m14227d(sb.toString());
                if (TrimAndCutOperationView.this.cDz || !TrimAndCutOperationView.this.cCF.isPlaying() || i <= TrimAndCutOperationView.this.cCF.agp().agB() - 50 || i >= TrimAndCutOperationView.this.cCF.agp().agC()) {
                    if (TrimAndCutOperationView.this.cCF != null && !z) {
                        TrimAndCutOperationView.this.cCF.setPlaying(true);
                        TrimAndCutOperationView.this.cCF.mo28146lG(i);
                    }
                    return;
                }
                ((C5831b) TrimAndCutOperationView.this.getEditor()).mo27846H(TrimAndCutOperationView.this.cCF.agp().agC(), true);
            }

            /* renamed from: L */
            public void mo27795L(int i, boolean z) {
                StringBuilder sb = new StringBuilder();
                sb.append("onPlayerPause progress = ");
                sb.append(i);
                sb.append(", isUserSeeking = ");
                sb.append(z);
                LogUtilsV2.m14227d(sb.toString());
                if ((TrimAndCutOperationView.this.cDz || i <= TrimAndCutOperationView.this.cCF.agp().agB() - 50 || i >= TrimAndCutOperationView.this.cCF.agp().agC()) && TrimAndCutOperationView.this.cCF != null && !z) {
                    TrimAndCutOperationView.this.cCF.mo28146lG(i);
                    TrimAndCutOperationView.this.cCF.setPlaying(false);
                }
            }

            /* renamed from: M */
            public void mo27796M(int i, boolean z) {
                StringBuilder sb = new StringBuilder();
                sb.append("onPlayerStop progress = ");
                sb.append(i);
                sb.append(", isUserSeeking = ");
                sb.append(z);
                LogUtilsV2.m14227d(sb.toString());
                if (TrimAndCutOperationView.this.cCF != null && !z) {
                    TrimAndCutOperationView.this.cCF.mo28146lG(i);
                    TrimAndCutOperationView.this.cCF.setPlaying(false);
                }
            }

            public void aes() {
            }
        };
    }

    public int getStreamType() {
        return 2;
    }

    public C6282d getVideoControlListener() {
        return new C6282d() {
            public void agk() {
                if (TrimAndCutOperationView.this.getVideoOperator() != null) {
                    if (TrimAndCutOperationView.this.cDz) {
                        TrimAndCutOperationView.this.agj();
                    } else {
                        ((C5831b) TrimAndCutOperationView.this.getEditor()).mo27868b(0, TrimAndCutOperationView.this.cCG.aHR(), false, 0);
                    }
                    ((C5831b) TrimAndCutOperationView.this.getEditor()).adY();
                }
            }

            public void agl() {
                if (TrimAndCutOperationView.this.cCF.isPlaying()) {
                    TrimAndCutOperationView.this.cCF.setPlaying(false);
                    ((C5831b) TrimAndCutOperationView.this.getEditor()).mo27868b(0, TrimAndCutOperationView.this.cCG.aHR(), false, TrimAndCutOperationView.this.cCF.agp().agB());
                    ((C5831b) TrimAndCutOperationView.this.getEditor()).mo27846H(TrimAndCutOperationView.this.cCF.agp().agB(), false);
                }
                ((C5831b) TrimAndCutOperationView.this.getEditor()).adX();
            }
        };
    }

    public void onActivityDestroy() {
        super.onActivityDestroy();
        if (this.cCF != null) {
            this.cCF.destroy();
            this.cCF = null;
        }
    }

    public boolean onBackPressed() {
        ((C5831b) getEditor()).adX();
        return aeV() || super.onBackPressed();
    }
}
