package com.introvd.template.editor.clipedit.speed;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.afollestad.materialdialogs.C1885b;
import com.afollestad.materialdialogs.C1890f;
import com.afollestad.materialdialogs.C1890f.C1904j;
import com.introvd.template.common.ToastUtils;
import com.introvd.template.editor.R;
import com.introvd.template.editor.base.BaseOperationView;
import com.introvd.template.editor.clipedit.C5694a;
import com.introvd.template.editor.clipedit.C5695b;
import com.introvd.template.editor.clipedit.speed.C5782a.C5784a;
import com.introvd.template.editor.common.terminator.Terminator;
import com.introvd.template.editor.common.terminator.Terminator.C5858a;
import com.introvd.template.editor.p244a.C5554b;
import com.introvd.template.editor.p261g.C6312c;
import com.introvd.template.editor.p266h.C6386d;
import com.introvd.template.editor.player.p267a.C6494k;
import com.introvd.template.editor.preview.p271b.C6550a;
import com.introvd.template.p414ui.dialog.C8978m;
import com.introvd.template.p414ui.view.TextSeekBar;
import com.introvd.template.sdk.editor.C8420b;
import com.introvd.template.sdk.editor.cache.C8440a;
import com.introvd.template.sdk.editor.cache.C8443d;
import com.introvd.template.sdk.utils.C8572y;
import com.introvd.template.sdk.utils.p394b.C8518c;
import com.introvd.template.sdk.utils.p394b.C8522g;
import com.introvd.template.sdk.utils.p394b.C8537n;
import com.introvd.template.sdk.utils.p394b.C8540q;
import com.p131c.p132a.p133a.C2564c;
import java.math.BigDecimal;
import java.util.List;
import org.greenrobot.eventbus.C10021c;
import xiaoying.engine.clip.QClip;
import xiaoying.engine.storyboard.QStoryboard;

@SuppressLint({"ViewConstructor"})
public class SpeedOpsView extends BaseOperationView<C5694a> {
    private boolean cCA;
    private int cCB;
    private boolean cCC;
    /* access modifiers changed from: private */
    public ImageButton cCw;
    /* access modifiers changed from: private */
    public C5782a cCx;
    /* access modifiers changed from: private */
    public TextView cCy;
    private float cCz;
    private Terminator czM;
    /* access modifiers changed from: private */
    public ImageButton czN;

    public SpeedOpsView(Activity activity) {
        super(activity, C5694a.class);
    }

    /* renamed from: Oj */
    private void m16054Oj() {
        this.cCy = (TextView) findViewById(R.id.tv_speed_value);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.apply_all_layout);
        this.czN = (ImageButton) findViewById(R.id.apply_all_btn);
        linearLayout.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                C2564c.m7330dy(SpeedOpsView.this.czN);
                SpeedOpsView.this.czN.setSelected(!SpeedOpsView.this.czN.isSelected());
            }
        });
        linearLayout.setVisibility(((C5694a) getEditor()).aeL() ? 0 : 8);
        LinearLayout linearLayout2 = (LinearLayout) findViewById(R.id.keep_tone_layout);
        this.cCw = (ImageButton) findViewById(R.id.keep_tone_btn);
        linearLayout2.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                C2564c.m7330dy(SpeedOpsView.this.cCw);
                SpeedOpsView.this.cCw.setSelected(!SpeedOpsView.this.cCw.isSelected());
                SpeedOpsView.this.getVideoOperator().mo29678a(new C6494k(3, ((C5694a) SpeedOpsView.this.getEditor()).getFocusIndex(), 3, SpeedOpsView.this.cCw.isSelected()));
            }
        });
        this.czM = (Terminator) findViewById(R.id.teminator);
        this.czM.setTerminatorListener(new C5858a() {
            public void aeW() {
                ((C5694a) SpeedOpsView.this.getEditor()).adX();
                if (!SpeedOpsView.this.aeV()) {
                    SpeedOpsView.this.exit();
                }
            }

            public void aeX() {
                ((C5694a) SpeedOpsView.this.getEditor()).adX();
                SpeedOpsView.this.afP();
                if (SpeedOpsView.this.czN.isSelected()) {
                    C10021c.aZH().mo38492aA(new C6550a(2));
                } else {
                    C10021c.aZH().mo38492aA(new C6550a(1, ((C5694a) SpeedOpsView.this.getEditor()).aeK()));
                }
                C5695b.m15720o(SpeedOpsView.this.getContext(), String.valueOf(1.0f / SpeedOpsView.this.cCx.afJ()), SpeedOpsView.this.cCw.isSelected() ? "no" : "yes");
                SpeedOpsView.this.exit();
            }
        });
    }

    /* renamed from: a */
    private void m16056a(int i, float f, float f2) {
        C8522g adK = ((C5694a) getEditor()).adK();
        QStoryboard adO = ((C5694a) getEditor()).adO();
        C8420b adS = ((C5694a) getEditor()).adS();
        if (adS != null) {
            if (adK == null || adK.aHe() == null || adK.aHe().isAdvBGMMode()) {
                adS.mo34140a(adO, i, f, f2, false);
                adS.mo34143b(adO, false);
            } else {
                C8540q.m24903L(adO);
                adS.mo34140a(adO, i, f, f2, true);
                adS.mo34143b(adO, true);
            }
        }
    }

    private void aeU() {
        afN();
        afO();
    }

    /* access modifiers changed from: private */
    public boolean aeV() {
        if (!aeA() || getActivity() == null || getActivity().isFinishing()) {
            return false;
        }
        String string = getActivity().getString(R.string.xiaoying_str_com_ok);
        C8978m.m26348af(getActivity(), getActivity().getString(R.string.xiaoying_str_com_cancel), string).mo10296do(R.string.xiaoying_str_com_dialog_cancel_all_ask).mo10281a((C1904j) new C1904j() {
            public void onClick(C1890f fVar, C1885b bVar) {
                SpeedOpsView.this.exit();
            }
        }).mo10313qu().show();
        return true;
    }

    private void afN() {
        if (this.cCx == null) {
            this.cCx = new C5782a((TextSeekBar) findViewById(R.id.txtseekbar_clip_speed));
            this.cCx.mo28054a((C5784a) new C5784a() {
                public void afL() {
                    SpeedOpsView.this.m16062c(SpeedOpsView.this.cCy, 0.5f, 1.0f);
                    SpeedOpsView.this.getVideoOperator().mo29686b(new C6494k(3, ((C5694a) SpeedOpsView.this.getEditor()).getFocusIndex(), 1, 0.0f));
                }

                public void afM() {
                    ((C5694a) SpeedOpsView.this.getEditor()).adY();
                    SpeedOpsView.this.m16062c(SpeedOpsView.this.cCy, 1.0f, 0.5f);
                }

                /* JADX WARNING: Removed duplicated region for block: B:7:0x0038  */
                /* JADX WARNING: Removed duplicated region for block: B:8:0x003e  */
                /* renamed from: at */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public boolean mo28051at(float r9) {
                    /*
                        r8 = this;
                        com.introvd.template.editor.clipedit.speed.SpeedOpsView r0 = com.introvd.template.editor.clipedit.speed.SpeedOpsView.this
                        com.introvd.template.editor.player.b.a r0 = r0.getVideoOperator()
                        if (r0 == 0) goto L_0x0035
                        com.introvd.template.editor.clipedit.speed.SpeedOpsView r0 = com.introvd.template.editor.clipedit.speed.SpeedOpsView.this
                        com.introvd.template.editor.player.b.a r0 = r0.getVideoOperator()
                        com.introvd.template.editor.player.a.k r7 = new com.introvd.template.editor.player.a.k
                        r2 = 3
                        com.introvd.template.editor.clipedit.speed.SpeedOpsView r1 = com.introvd.template.editor.clipedit.speed.SpeedOpsView.this
                        com.introvd.template.editor.base.a r1 = r1.getEditor()
                        com.introvd.template.editor.clipedit.a r1 = (com.introvd.template.editor.clipedit.C5694a) r1
                        int r3 = r1.getFocusIndex()
                        r4 = 2
                        com.introvd.template.editor.clipedit.speed.SpeedOpsView r1 = com.introvd.template.editor.clipedit.speed.SpeedOpsView.this
                        android.widget.ImageButton r1 = r1.cCw
                        boolean r6 = r1.isSelected()
                        r1 = r7
                        r5 = r9
                        r1.<init>(r2, r3, r4, r5, r6)
                        boolean r0 = r0.mo29678a(r7)
                        if (r0 == 0) goto L_0x0035
                        r0 = 1
                        goto L_0x0036
                    L_0x0035:
                        r0 = 0
                    L_0x0036:
                        if (r0 == 0) goto L_0x003e
                        com.introvd.template.editor.clipedit.speed.SpeedOpsView r1 = com.introvd.template.editor.clipedit.speed.SpeedOpsView.this
                        r1.m16059au(r9)
                        goto L_0x004d
                    L_0x003e:
                        com.introvd.template.editor.clipedit.speed.SpeedOpsView r9 = com.introvd.template.editor.clipedit.speed.SpeedOpsView.this
                        com.introvd.template.editor.clipedit.speed.SpeedOpsView r1 = com.introvd.template.editor.clipedit.speed.SpeedOpsView.this
                        com.introvd.template.editor.clipedit.speed.a r1 = r1.cCx
                        float r1 = r1.afI()
                        r9.m16059au(r1)
                    L_0x004d:
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.editor.clipedit.speed.SpeedOpsView.C57805.mo28051at(float):boolean");
                }

                public void onSpeedTrackingChange(float f) {
                    SpeedOpsView.this.m16059au(f);
                }
            });
        }
        float f = 1.0f;
        List aeK = ((C5694a) getEditor()).aeK();
        if (aeK != null && aeK.size() == 1) {
            QClip i = C8540q.m24956i(((C5694a) getEditor()).adO(), ((C5694a) getEditor()).getFocusIndex());
            if (i != null) {
                f = C8537n.m24834m(i);
            }
        }
        this.cCx.mo28053T(f);
        this.cCx.mo28058as(f);
        m16059au(f);
    }

    private void afO() {
        if (this.cCB != 0) {
            if (this.cCB == 1) {
                this.cCw.setSelected(false);
            } else if (this.cCB == 2) {
                this.cCw.setSelected(true);
            }
            this.cCB = 0;
        } else {
            QClip aeM = ((C5694a) getEditor()).aeM();
            float m = C8537n.m24834m(aeM);
            if (aeM != null) {
                this.cCz = ((Float) aeM.getProperty(QClip.PROP_AUDIO_PITCH_DELTA)).floatValue();
                this.cCA = ((Boolean) aeM.getProperty(QClip.PROP_AUDIO_MODIFY_BY_ASP)).booleanValue();
            }
            if (C8572y.m25061O(m, 1.0f)) {
                this.cCw.setSelected(!this.cCA);
            } else if (C8572y.m25061O(this.cCz, 0.0f)) {
                this.cCw.setSelected(this.cCA);
            } else {
                this.cCw.setSelected(false);
            }
        }
        this.cCC = this.cCw.isSelected();
    }

    /* access modifiers changed from: private */
    public void afP() {
        if (this.cCx != null && aeA()) {
            boolean isSelected = this.czN.isSelected();
            ((C5694a) this.cyD).mo27884a(C6312c.CLIP_SPEED, isSelected, false);
            float afJ = this.cCx.afJ();
            C8443d adQ = ((C5694a) getEditor()).adQ();
            if (isSelected) {
                C5554b.m15023aD(getContext(), "速度调节");
                int clipCount = adQ.getClipCount();
                int i = 0;
                for (int i2 = 0; i2 < clipCount; i2++) {
                    int ld = ((C5694a) getEditor()).mo27891ld(i2);
                    C8440a tX = adQ.mo34307tX(ld);
                    if (tX != null && !tX.isImage()) {
                        QClip i3 = C8540q.m24956i(((C5694a) getEditor()).adO(), ld);
                        if (i3 != null) {
                            float m = C8537n.m24834m(i3);
                            if (C6386d.m18369a(m, afJ, i3)) {
                                C8537n.m24800a(i3, afJ, this.cCw.isSelected());
                                if (C8537n.m24787a(i3, Float.valueOf(afJ)) == 0) {
                                    C8518c.m24650a(i3, tX);
                                    m16056a(ld, m, afJ);
                                }
                            } else {
                                i++;
                            }
                        }
                    }
                }
                if (i > 0) {
                    ToastUtils.show(getContext(), getResources().getString(R.string.xiaoying_str_ve_clipedit_apply_to_all_video_clips_fail, new Object[]{Integer.valueOf(i)}), 1);
                } else {
                    ToastUtils.show(getContext(), R.string.xiaoying_str_ve_clipedit_apply_to_all_video_clips_suc, 1);
                }
            } else {
                for (Integer intValue : ((C5694a) this.cyD).aeK()) {
                    int intValue2 = intValue.intValue();
                    C8440a tX2 = adQ.mo34307tX(intValue2);
                    if (tX2 != null && !tX2.isImage()) {
                        QClip i4 = C8540q.m24956i(((C5694a) getEditor()).adO(), intValue2);
                        if (i4 != null) {
                            float m2 = C8537n.m24834m(i4);
                            if (C6386d.m18369a(m2, afJ, i4)) {
                                C8537n.m24800a(i4, afJ, this.cCw.isSelected());
                                if (C8537n.m24787a(i4, Float.valueOf(afJ)) == 0) {
                                    C8518c.m24650a(i4, tX2);
                                    m16056a(intValue2, m2, afJ);
                                }
                            }
                        }
                    }
                }
                ((C5694a) getEditor()).adL().mo34669jt(true);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void afu() {
        /*
            r6 = this;
            r0 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            com.introvd.template.editor.base.a r2 = r6.getEditor()     // Catch:{ Exception -> 0x0025 }
            com.introvd.template.editor.clipedit.a r2 = (com.introvd.template.editor.clipedit.C5694a) r2     // Catch:{ Exception -> 0x0025 }
            com.introvd.template.router.todoCode.TODOParamModel r2 = r2.getTodoParamModel()     // Catch:{ Exception -> 0x0025 }
            java.lang.String r2 = r2.mJsonParam     // Catch:{ Exception -> 0x0025 }
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ Exception -> 0x0025 }
            r3.<init>(r2)     // Catch:{ Exception -> 0x0025 }
            java.lang.String r2 = "speedRatio"
            double r4 = r3.optDouble(r2, r0)     // Catch:{ Exception -> 0x0025 }
            java.lang.String r0 = "keepTone"
            int r0 = r3.optInt(r0)     // Catch:{ Exception -> 0x0022 }
            r6.cCB = r0     // Catch:{ Exception -> 0x0022 }
            goto L_0x002a
        L_0x0022:
            r0 = move-exception
            r2 = r0
            goto L_0x0027
        L_0x0025:
            r2 = move-exception
            r4 = r0
        L_0x0027:
            r2.printStackTrace()
        L_0x002a:
            com.introvd.template.editor.base.a r0 = r6.getEditor()
            com.introvd.template.editor.clipedit.a r0 = (com.introvd.template.editor.clipedit.C5694a) r0
            com.introvd.template.router.todoCode.TODOParamModel r0 = r0.getTodoParamModel()
            if (r0 == 0) goto L_0x005f
            r0 = 1
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            b.b.l r0 = p037b.p050b.C1834l.m5257ah(r0)
            r1 = 1200(0x4b0, double:5.93E-321)
            java.util.concurrent.TimeUnit r3 = java.util.concurrent.TimeUnit.MILLISECONDS
            b.b.l r0 = r0.mo10164f(r1, r3)
            b.b.r r1 = p037b.p050b.p076j.C1820a.aVi()
            b.b.l r0 = r0.mo10157d(r1)
            b.b.r r1 = p037b.p050b.p051a.p053b.C1487a.aUa()
            b.b.l r0 = r0.mo10152c(r1)
            com.introvd.template.editor.clipedit.speed.SpeedOpsView$1 r1 = new com.introvd.template.editor.clipedit.speed.SpeedOpsView$1
            r1.<init>(r4)
            r0.mo10149b(r1)
        L_0x005f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.editor.clipedit.speed.SpeedOpsView.afu():void");
    }

    /* access modifiers changed from: private */
    /* renamed from: au */
    public void m16059au(float f) {
        double doubleValue = new BigDecimal((double) (1.0f / f)).setScale(2, 4).doubleValue();
        TextView textView = this.cCy;
        StringBuilder sb = new StringBuilder();
        sb.append("x ");
        sb.append(String.valueOf(doubleValue));
        textView.setText(sb.toString());
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m16062c(View view, float f, float f2) {
        view.clearAnimation();
        AlphaAnimation alphaAnimation = new AlphaAnimation(f, f2);
        alphaAnimation.setDuration(300);
        alphaAnimation.setFillAfter(true);
        alphaAnimation.setFillBefore(false);
        alphaAnimation.setStartOffset(100);
        view.startAnimation(alphaAnimation);
    }

    public boolean aeA() {
        return this.cCx.afK() || (this.cCC != this.cCw.isSelected()) || this.czN.isSelected();
    }

    public void aex() {
        super.aex();
        if (((C5694a) getEditor()).aeK().size() == 0) {
            exit();
            return;
        }
        m16054Oj();
        afu();
        aeU();
    }

    public int getLayoutId() {
        return R.layout.editor_clip_speed_adjust_ops;
    }

    public int getStreamType() {
        return 1;
    }

    public boolean onBackPressed() {
        ((C5694a) getEditor()).adX();
        return aeV() || super.onBackPressed();
    }
}
