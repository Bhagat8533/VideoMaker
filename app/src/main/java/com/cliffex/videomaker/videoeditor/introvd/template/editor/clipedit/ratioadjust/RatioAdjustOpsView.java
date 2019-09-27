package com.introvd.template.editor.clipedit.ratioadjust;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.afollestad.materialdialogs.C1885b;
import com.afollestad.materialdialogs.C1890f;
import com.afollestad.materialdialogs.C1890f.C1904j;
import com.introvd.template.common.MSize;
import com.introvd.template.common.ToastUtils;
import com.introvd.template.common.model.AppStateModel;
import com.introvd.template.editor.R;
import com.introvd.template.editor.base.BaseOperationView;
import com.introvd.template.editor.clipedit.C5694a;
import com.introvd.template.editor.clipedit.ratioadjust.C5731a.C5739a;
import com.introvd.template.editor.common.model.ClipEditPanelStateModel;
import com.introvd.template.editor.common.terminator.Terminator;
import com.introvd.template.editor.common.terminator.Terminator.C5858a;
import com.introvd.template.editor.p244a.C5554b;
import com.introvd.template.editor.p259f.C6280b;
import com.introvd.template.editor.p261g.C6312c;
import com.introvd.template.editor.p266h.C6386d;
import com.introvd.template.editor.player.p267a.C6493j;
import com.introvd.template.editor.player.p269b.C6499a;
import com.introvd.template.module.iap.C8049f;
import com.introvd.template.module.iap.C8070o;
import com.introvd.template.module.iap.C8072q;
import com.introvd.template.module.iap.business.p349a.C7825a;
import com.introvd.template.p414ui.dialog.C8978m;
import com.introvd.template.router.iap.IapRTConstants;
import com.introvd.template.router.kiwi.LDPProtect;
import com.introvd.template.sdk.editor.cache.C8443d;
import com.introvd.template.sdk.p383c.C8400d;
import com.introvd.template.sdk.utils.VeMSize;
import com.introvd.template.sdk.utils.p394b.C8537n;
import com.introvd.template.sdk.utils.p394b.C8538o;
import com.introvd.template.sdk.utils.p394b.C8540q;
import com.introvd.template.template.p409g.C8762d;
import com.p131c.p132a.p133a.C2564c;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;
import p037b.p050b.p051a.p053b.C1487a;
import p037b.p050b.p054b.C1494a;
import xiaoying.engine.base.QStyle.QEffectPropertyData;
import xiaoying.engine.clip.QClip;

@LDPProtect
@SuppressLint({"ViewConstructor"})
public class RatioAdjustOpsView extends BaseOperationView<C5694a> {
    /* access modifiers changed from: private */
    public boolean bkm = true;
    /* access modifiers changed from: private */
    public C5731a cBa;
    /* access modifiers changed from: private */
    public QClip cBb;
    private View cBc;
    private LinearLayout cBd;
    private float cBe;
    /* access modifiers changed from: private */
    public String cBf;
    /* access modifiers changed from: private */
    public boolean cBg = false;
    C1494a cBh = new C1494a();
    private ImageButton cti;
    /* access modifiers changed from: private */
    public float cvt;
    private Terminator czM;
    /* access modifiers changed from: private */
    public ImageButton czN;
    /* access modifiers changed from: private */
    public boolean isModified = false;

    public RatioAdjustOpsView(Activity activity) {
        super(activity, C5694a.class);
    }

    /* renamed from: a */
    private void m15858a(QClip qClip, String str, QEffectPropertyData[] qEffectPropertyDataArr) {
        if (qClip != null) {
            C8537n.m24804a(qClip, Boolean.TRUE);
            C8540q.m24918a(((C5694a) getEditor()).adL().aJv(), str, 0, true, qClip, -10, C8400d.edi);
            if (this.cBa.mTransformType == 6 || this.cBa.mTransformType == 7) {
                C8538o.m24846a(C8537n.m24816b(qClip, -10, 0), this.cBf);
            }
            QEffectPropertyData[] c = m15866c(qEffectPropertyDataArr);
            if (!(((Integer) qClip.getProperty(12289)).intValue() == 2)) {
                if (this.cBa.mTransformType == 9 && c.length >= 13) {
                    c[12].mValue = 0;
                } else if (c.length >= 8) {
                    c[7].mValue = 0;
                }
            }
            C8537n.m24792a(c, C8537n.m24816b(qClip, -10, 0));
        }
    }

    /* access modifiers changed from: private */
    public void acu() {
        if (this.cBb != null) {
            this.cBb.unInit();
            this.cBb = null;
        }
    }

    /* access modifiers changed from: private */
    public void aeU() {
        boolean z = false;
        this.cBc = LayoutInflater.from(getContext()).inflate(R.layout.editor_clip_ratio_adjust_terminator_content_layout, this, false);
        MSize surfaceSize = ((C5694a) getEditor()).getSurfaceSize();
        float f = (((float) surfaceSize.width) * 1.0f) / ((float) surfaceSize.height);
        this.cBe = f;
        this.cvt = f;
        if (this.cBa == null) {
            C5731a aVar = new C5731a(C8540q.m24893B(((C5694a) getEditor()).adO()), ((C5694a) getEditor()).adL().aJv(), ((C5694a) getEditor()).mo27892le(((C5694a) getEditor()).getFocusIndex()), findViewById(R.id.rl_ratio_layout), this.cBc);
            this.cBa = aVar;
            this.cBa.mo27970a((C5739a) new C5739a() {
                public void afq() {
                    ((C5694a) RatioAdjustOpsView.this.getEditor()).adX();
                }

                public boolean afs() {
                    return RatioAdjustOpsView.this.getVideoOperator() == null || RatioAdjustOpsView.this.getVideoOperator().aog();
                }

                public boolean aft() {
                    return C8540q.m24913V(((C5694a) RatioAdjustOpsView.this.getEditor()).adO());
                }

                /* renamed from: al */
                public void mo27957al(float f) {
                    if (RatioAdjustOpsView.this.getVideoOperator() != null) {
                        RatioAdjustOpsView.this.isModified = true;
                        ((C5694a) RatioAdjustOpsView.this.getEditor()).adX();
                        if (RatioAdjustOpsView.this.getVideoOperator().mo29688f(RatioAdjustOpsView.this.m15860am(f))) {
                            RatioAdjustOpsView.this.cvt = f;
                            C6499a l = RatioAdjustOpsView.this.getVideoOperator();
                            C6493j jVar = new C6493j(7, ((C5694a) RatioAdjustOpsView.this.getEditor()).getFocusIndex(), 1, RatioAdjustOpsView.this.m15860am(f), true);
                            l.mo29678a(jVar);
                            RatioAdjustOpsView.this.cBa.mo27971a((QClip) null, ((C5694a) RatioAdjustOpsView.this.getEditor()).mo27847a(RatioAdjustOpsView.this.m15860am(f)));
                        }
                    }
                }

                /* renamed from: c */
                public void mo27958c(long j, boolean z) {
                    if (z) {
                        RatioAdjustOpsView.this.isModified = true;
                    }
                    String bB = C8762d.aMt().mo35225bB(j);
                    if (RatioAdjustOpsView.this.cBb != null) {
                        C8540q.m24918a(((C5694a) RatioAdjustOpsView.this.getEditor()).adP(), bB, 0, true, RatioAdjustOpsView.this.cBb, -10, C8400d.edi);
                        RatioAdjustOpsView.this.cBa.mo27972a(RatioAdjustOpsView.this.cBb, false);
                        C6499a o = RatioAdjustOpsView.this.getVideoOperator();
                        C6493j jVar = new C6493j(7, ((C5694a) RatioAdjustOpsView.this.getEditor()).getFocusIndex(), 3, j);
                        o.mo29678a(jVar);
                    }
                }

                /* renamed from: eB */
                public void mo27959eB(boolean z) {
                    if (!RatioAdjustOpsView.this.bkm) {
                        RatioAdjustOpsView.this.isModified = true;
                    }
                    RatioAdjustOpsView.this.bkm = false;
                    if (RatioAdjustOpsView.this.cBb != null && RatioAdjustOpsView.this.cBa != null) {
                        C8537n.m24792a(RatioAdjustOpsView.this.cBa.mClipParamDatas, C8537n.m24816b(RatioAdjustOpsView.this.cBb, -10, 0));
                        C6499a q = RatioAdjustOpsView.this.getVideoOperator();
                        C6493j jVar = new C6493j(7, ((C5694a) RatioAdjustOpsView.this.getEditor()).getFocusIndex(), 4, RatioAdjustOpsView.this.cBa.mClipParamDatas, z);
                        q.mo29678a(jVar);
                    }
                }

                /* renamed from: eC */
                public void mo27960eC(boolean z) {
                    RatioAdjustOpsView.this.cBg = !z;
                    RatioAdjustOpsView.this.m15871eD(z);
                }

                /* renamed from: gJ */
                public void mo27961gJ(String str) {
                    RatioAdjustOpsView.this.isModified = true;
                    RatioAdjustOpsView.this.cBf = str;
                    RatioAdjustOpsView.this.getVideoOperator().mo29678a(new C6493j(7, ((C5694a) RatioAdjustOpsView.this.getEditor()).getFocusIndex(), 2, str));
                }
            });
        }
        QClip le = ((C5694a) getEditor()).mo27892le(((C5694a) getEditor()).getFocusIndex());
        ClipEditPanelStateModel clipEditPanelStateModel = null;
        if (le != null) {
            clipEditPanelStateModel = C6386d.m18363a(((C5694a) this.cyD).adP(), le);
        }
        if (clipEditPanelStateModel != null && clipEditPanelStateModel.isImageClip()) {
            z = clipEditPanelStateModel.isbAnimEnable();
        }
        this.cBa.mo27977ew(z);
        this.cBa.mo27971a(le, surfaceSize);
        this.cBa.mo27972a(le, true);
        if (le != null) {
            this.cBb = new QClip();
            le.duplicate(this.cBb);
            C8537n.m24804a(this.cBb, Boolean.TRUE);
        }
    }

    private boolean aeV() {
        if (!this.isModified || getActivity() == null) {
            return false;
        }
        String string = getActivity().getString(R.string.xiaoying_str_com_ok);
        C8978m.m26348af(getActivity(), getActivity().getString(R.string.xiaoying_str_com_cancel), string).mo10296do(R.string.xiaoying_str_com_dialog_cancel_all_ask).mo10281a((C1904j) new C1904j() {
            public void onClick(C1890f fVar, C1885b bVar) {
                RatioAdjustOpsView.this.afx();
                RatioAdjustOpsView.this.acu();
            }
        }).mo10313qu().show();
        return true;
    }

    private void afe() {
        boolean isSelected = this.czN.isSelected();
        if (!this.isModified && !isSelected) {
            exit(false);
        } else if (this.cBa == null) {
            exit(false);
        } else {
            ((C5694a) this.cyD).mo27883a(C6312c.CLIP_RATIO);
            C8540q.m24955g(((C5694a) getEditor()).adO(), this.cBa.afh());
            MSize am = m15860am(this.cvt);
            VeMSize veMSize = null;
            if (am != null) {
                veMSize = new VeMSize(am.width, am.height);
            }
            ((C5694a) getEditor()).adK().mo34765i(veMSize);
            String bB = C8762d.aMt().mo35225bB(this.cBa.getEffectID());
            QEffectPropertyData[] qEffectPropertyDataArr = this.cBa.mClipParamDatas;
            m15858a(((C5694a) getEditor()).aeM(), bB, qEffectPropertyDataArr);
            C8443d adQ = ((C5694a) getEditor()).adQ();
            if (isSelected && adQ != null) {
                C5554b.m15023aD(getContext(), "比例调节");
                int clipCount = adQ.getClipCount();
                for (int i = 0; i < clipCount; i++) {
                    if (i != ((C5694a) getEditor()).getFocusIndex()) {
                        QClip le = ((C5694a) getEditor()).mo27892le(i);
                        if (le != null) {
                            m15858a(le, bB, qEffectPropertyDataArr);
                        }
                    }
                }
                ToastUtils.show(getContext(), R.string.xiaoying_str_ve_clipedit_apply_to_all_clips_suc, 1);
            }
            ((C5694a) getEditor()).adL().mo34669jt(true);
            exit(false);
        }
    }

    private void afu() {
        String str = "";
        try {
            if (((C5694a) getEditor()).getTodoParamModel() != null) {
                str = new JSONObject(((C5694a) getEditor()).getTodoParamModel().mJsonParam).optString("ratio");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (((C5694a) getEditor()).getTodoParamModel() != null && !TextUtils.isEmpty(str)) {
            final float gK = m15875gK(str);
            this.cBh.mo9785e(C1487a.aUa().mo9777a(new Runnable() {
                public void run() {
                    if (RatioAdjustOpsView.this.cBa != null) {
                        RatioAdjustOpsView.this.cBa.mo27976aj(gK);
                    }
                }
            }, 1200, TimeUnit.MILLISECONDS));
        }
    }

    /* access modifiers changed from: private */
    public boolean afv() {
        if (this.cyB != null && !this.cyB.aog()) {
            return true;
        }
        ((C5694a) getEditor()).adX();
        if (!aeV()) {
            afx();
            acu();
        }
        return true;
    }

    /* access modifiers changed from: private */
    public boolean afw() {
        if (this.cBa == null) {
            return true;
        }
        if ((this.cBa.mTransformType == 6 || this.cBa.mTransformType == 7) && C8049f.aBf().aBr() && !C8072q.aBx().mo33072ku(C7825a.CUSTOMIZED_BACKGROUND.getId()) && !TextUtils.isEmpty(this.cBf)) {
            C8049f.aBf().mo33097b((Context) this.bwg.get(), C8070o.aBw(), C7825a.CUSTOMIZED_BACKGROUND.getId(), "custom_bg", IapRTConstants.REQUEST_CODE_FOR_VIP);
            return false;
        }
        C5740b.m15960y(getContext(), this.cBg);
        this.cBa.mo27978ey(true);
        afe();
        return true;
    }

    /* access modifiers changed from: private */
    public void afx() {
        if (this.cBa != null) {
            this.cBa.mo27978ey(true);
        }
        exit(false);
    }

    /* access modifiers changed from: private */
    /* renamed from: am */
    public MSize m15860am(float f) {
        if (f >= 0.0f) {
            return f >= 1.0f ? new MSize((int) (f * 480.0f), 480) : new MSize(480, (int) (480.0f / f));
        }
        VeMSize d = C8540q.m24946d(((C5694a) getEditor()).adO(), AppStateModel.getInstance().isCommunitySupport());
        return d != null ? new MSize(d.width, d.height) : null;
    }

    /* renamed from: c */
    private QEffectPropertyData[] m15866c(QEffectPropertyData[] qEffectPropertyDataArr) {
        if (qEffectPropertyDataArr == null) {
            return new QEffectPropertyData[0];
        }
        QEffectPropertyData[] qEffectPropertyDataArr2 = new QEffectPropertyData[qEffectPropertyDataArr.length];
        int i = 0;
        for (QEffectPropertyData qEffectPropertyData : qEffectPropertyDataArr) {
            if (qEffectPropertyData != null) {
                int i2 = i + 1;
                qEffectPropertyDataArr2[i] = qEffectPropertyData;
                i = i2;
            }
        }
        return qEffectPropertyDataArr2;
    }

    /* access modifiers changed from: private */
    /* renamed from: eD */
    public void m15871eD(boolean z) {
        if (z) {
            this.czM.setTitle(R.string.xiaoying_str_ve_edit_ratio_title);
        } else if (this.cBc != null) {
            this.czM.setTitleContentLayout(this.cBc);
        }
        if (!((C5694a) getEditor()).aeL() || z) {
            this.cBd.setVisibility(8);
        } else {
            this.cBd.setVisibility(0);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: eE */
    public void m15872eE(boolean z) {
        if (this.cti != null) {
            this.cti.setSelected(z);
        }
    }

    /* renamed from: gK */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private float m15875gK(java.lang.String r2) {
        /*
            r1 = this;
            int r0 = r2.hashCode()
            switch(r0) {
                case 50858: goto L_0x0044;
                case 52783: goto L_0x003a;
                case 53743: goto L_0x0030;
                case 53745: goto L_0x0026;
                case 1515430: goto L_0x001c;
                case 1814980: goto L_0x0012;
                case 1379043793: goto L_0x0008;
                default: goto L_0x0007;
            }
        L_0x0007:
            goto L_0x004e
        L_0x0008:
            java.lang.String r0 = "original"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x004e
            r2 = 0
            goto L_0x004f
        L_0x0012:
            java.lang.String r0 = "9x16"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x004e
            r2 = 2
            goto L_0x004f
        L_0x001c:
            java.lang.String r0 = "16x9"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x004e
            r2 = 5
            goto L_0x004f
        L_0x0026:
            java.lang.String r0 = "4x5"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x004e
            r2 = 3
            goto L_0x004f
        L_0x0030:
            java.lang.String r0 = "4x3"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x004e
            r2 = 6
            goto L_0x004f
        L_0x003a:
            java.lang.String r0 = "3x4"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x004e
            r2 = 4
            goto L_0x004f
        L_0x0044:
            java.lang.String r0 = "1x1"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x004e
            r2 = 1
            goto L_0x004f
        L_0x004e:
            r2 = -1
        L_0x004f:
            r0 = -1082130432(0xffffffffbf800000, float:-1.0)
            switch(r2) {
                case 0: goto L_0x006a;
                case 1: goto L_0x0067;
                case 2: goto L_0x0064;
                case 3: goto L_0x0060;
                case 4: goto L_0x005d;
                case 5: goto L_0x0059;
                case 6: goto L_0x0055;
                default: goto L_0x0054;
            }
        L_0x0054:
            return r0
        L_0x0055:
            r2 = 1068149419(0x3faaaaab, float:1.3333334)
            return r2
        L_0x0059:
            r2 = 1071877689(0x3fe38e39, float:1.7777778)
            return r2
        L_0x005d:
            r2 = 1061158912(0x3f400000, float:0.75)
            return r2
        L_0x0060:
            r2 = 1061997773(0x3f4ccccd, float:0.8)
            return r2
        L_0x0064:
            r2 = 1058013184(0x3f100000, float:0.5625)
            return r2
        L_0x0067:
            r2 = 1065353216(0x3f800000, float:1.0)
            return r2
        L_0x006a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.editor.clipedit.ratioadjust.RatioAdjustOpsView.m15875gK(java.lang.String):float");
    }

    private void initUI() {
        this.cti = (ImageButton) findViewById(R.id.ib_play);
        this.cti.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (view.isSelected()) {
                    ((C5694a) RatioAdjustOpsView.this.getEditor()).adX();
                } else {
                    ((C5694a) RatioAdjustOpsView.this.getEditor()).adY();
                }
            }
        });
        this.cBd = (LinearLayout) findViewById(R.id.apply_all_layout);
        this.czN = (ImageButton) findViewById(R.id.apply_all_btn);
        this.cBd.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                C2564c.m7330dy(RatioAdjustOpsView.this.czN);
                RatioAdjustOpsView.this.czN.setSelected(!RatioAdjustOpsView.this.czN.isSelected());
            }
        });
        this.czM = (Terminator) findViewById(R.id.teminator);
        this.czM.setTerminatorListener(new C5858a() {
            public void aeW() {
                RatioAdjustOpsView.this.afv();
            }

            public void aeX() {
                ((C5694a) RatioAdjustOpsView.this.getEditor()).adX();
                if (RatioAdjustOpsView.this.afw()) {
                    RatioAdjustOpsView.this.acu();
                    int i = RatioAdjustOpsView.this.cBa.mTransformType;
                    String str = i == 8 ? "blur BG" : i == 9 ? "color BG" : "pic BG";
                    boolean isSelected = RatioAdjustOpsView.this.czN.isSelected();
                    Context context = RatioAdjustOpsView.this.getContext();
                    StringBuilder sb = new StringBuilder();
                    sb.append(RatioAdjustOpsView.this.cvt);
                    sb.append("");
                    C5740b.m15959c(context, sb.toString(), str, isSelected);
                }
            }
        });
    }

    public boolean aeA() {
        return this.isModified;
    }

    public void aex() {
        super.aex();
        if (((C5694a) getEditor()).aeK().size() == 0) {
            exit(false);
            return;
        }
        initUI();
        m15871eD(true);
        afu();
        this.cBh.mo9785e(C1487a.aUa().mo9777a(new Runnable() {
            public void run() {
                RatioAdjustOpsView.this.aeU();
            }
        }, 300, TimeUnit.MILLISECONDS));
    }

    public boolean aey() {
        return true;
    }

    public int getLayoutId() {
        return R.layout.editor_clip_ratio_adjust_ops_layout;
    }

    public C6280b getPlayerStatusListener() {
        return new C6280b() {
            /* renamed from: J */
            public void mo27793J(int i, boolean z) {
                RatioAdjustOpsView.this.m15872eE(false);
            }

            /* renamed from: K */
            public void mo27794K(int i, boolean z) {
                RatioAdjustOpsView.this.m15872eE(true);
            }

            /* renamed from: L */
            public void mo27795L(int i, boolean z) {
                RatioAdjustOpsView.this.m15872eE(false);
            }

            /* renamed from: M */
            public void mo27796M(int i, boolean z) {
                RatioAdjustOpsView.this.m15872eE(false);
            }

            public void aes() {
                RatioAdjustOpsView.this.m15872eE(false);
                if (RatioAdjustOpsView.this.bkm && RatioAdjustOpsView.this.cBa != null) {
                    RatioAdjustOpsView.this.cBa.mo27969N(RatioAdjustOpsView.this.cBa.mTransformType, false);
                    RatioAdjustOpsView.this.cBa.afm();
                }
            }
        };
    }

    public int getStreamType() {
        return 2;
    }

    public void onActivityDestroy() {
        super.onActivityDestroy();
        this.cBh.clear();
        if (this.cBa != null) {
            this.cBa.onDestroy();
        }
    }

    public void onActivityPause() {
        m15872eE(false);
        super.onActivityPause();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && intent != null && i == 9527 && this.cBa != null) {
            this.cBa.afl();
        }
    }

    public void onActivityResume() {
        super.onActivityResume();
        if (this.cBa != null) {
            this.cBa.onResume();
        }
    }

    public boolean onBackPressed() {
        return afv();
    }
}
