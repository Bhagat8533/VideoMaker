package com.introvd.template.editor.clipedit.paramadjust;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.afollestad.materialdialogs.C1885b;
import com.afollestad.materialdialogs.C1890f;
import com.afollestad.materialdialogs.C1890f.C1904j;
import com.introvd.template.common.ToastUtils;
import com.introvd.template.editor.R;
import com.introvd.template.editor.base.BaseOperationView;
import com.introvd.template.editor.clipedit.C5694a;
import com.introvd.template.editor.clipedit.C5695b;
import com.introvd.template.editor.clipedit.paramadjust.C5714a.C5716a;
import com.introvd.template.editor.common.terminator.Terminator;
import com.introvd.template.editor.common.terminator.Terminator.C5858a;
import com.introvd.template.editor.p244a.C5554b;
import com.introvd.template.editor.p261g.C6312c;
import com.introvd.template.editor.p266h.C6386d;
import com.introvd.template.editor.player.p267a.C6490g;
import com.introvd.template.module.iap.C8049f;
import com.introvd.template.module.iap.C8072q;
import com.introvd.template.module.iap.business.p349a.C7825a;
import com.introvd.template.p203b.p204a.C4576e;
import com.introvd.template.p203b.p204a.C4577f;
import com.introvd.template.p414ui.dialog.C8978m;
import com.introvd.template.router.iap.IapRTConstants;
import com.introvd.template.router.kiwi.LDPProtect;
import com.introvd.template.sdk.editor.cache.C8443d;
import com.introvd.template.sdk.utils.p394b.C8537n;
import com.introvd.template.template.p409g.C8762d;
import com.p131c.p132a.p133a.C2564c;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;
import p037b.p050b.C1834l;
import p037b.p050b.C1842q;
import p037b.p050b.p051a.p053b.C1487a;
import p037b.p050b.p054b.C1495b;
import p037b.p050b.p076j.C1820a;
import xiaoying.engine.base.QStyle.QEffectPropertyData;
import xiaoying.engine.clip.QClip;

@LDPProtect
@SuppressLint({"ViewConstructor"})
public class ParamAdjustOpsView extends BaseOperationView<C5694a> {
    private C4576e czL;
    private Terminator czM;
    /* access modifiers changed from: private */
    public ImageButton czN;
    /* access modifiers changed from: private */
    public C5714a czO;

    public ParamAdjustOpsView(Activity activity) {
        super(activity, C5694a.class);
    }

    /* renamed from: Oj */
    private void m15809Oj() {
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.apply_all_layout);
        this.czN = (ImageButton) findViewById(R.id.apply_all_btn);
        linearLayout.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                C2564c.m7330dy(ParamAdjustOpsView.this.czN);
                ParamAdjustOpsView.this.czN.setSelected(!ParamAdjustOpsView.this.czN.isSelected());
            }
        });
        linearLayout.setVisibility(((C5694a) getEditor()).aeL() ? 0 : 8);
        this.czM = (Terminator) findViewById(R.id.teminator);
        this.czM.setTerminatorListener(new C5858a() {
            public void aeW() {
                ((C5694a) ParamAdjustOpsView.this.getEditor()).adX();
                if (!ParamAdjustOpsView.this.aeV()) {
                    ParamAdjustOpsView.this.afc();
                }
            }

            public void aeX() {
                C5695b.m15714aK(ParamAdjustOpsView.this.getContext(), ParamAdjustOpsView.this.czO == null ? "" : ParamAdjustOpsView.this.czO.afa());
                ((C5694a) ParamAdjustOpsView.this.getEditor()).adX();
                ParamAdjustOpsView.this.afd();
            }
        });
    }

    /* renamed from: Uc */
    private void m15810Uc() {
        if (((C5694a) getEditor()).getTodoParamModel() != null) {
            C1834l.m5257ah(Boolean.valueOf(true)).mo10164f(300, TimeUnit.MILLISECONDS).mo10157d(C1820a.aVi()).mo10152c(C1487a.aUa()).mo10149b((C1842q<? super T>) new C1842q<Boolean>() {
                /* renamed from: a */
                public void mo9877a(C1495b bVar) {
                }

                /* renamed from: b */
                public void mo9886K(Boolean bool) {
                    ParamAdjustOpsView.this.czO.mo27935s(ParamAdjustOpsView.this.m15818gH(((C5694a) ParamAdjustOpsView.this.getEditor()).getTodoParamModel().mJsonParam));
                }

                public void onComplete() {
                }

                public void onError(Throwable th) {
                }
            });
        }
    }

    private void aeU() {
        afb();
        this.czO = new C5714a(((C5694a) getEditor()).adL().aJv(), findViewById(R.id.clipparam_adjust_layout), findViewById(R.id.clip_param_value_layout));
        this.czO.mo27930a((C5716a) new C5716a() {
            /* renamed from: b */
            public void mo27928b(QEffectPropertyData[] qEffectPropertyDataArr) {
                ParamAdjustOpsView.this.getVideoOperator().mo29686b(new C6490g(2, ((C5694a) ParamAdjustOpsView.this.getEditor()).getFocusIndex(), qEffectPropertyDataArr));
            }
        });
        this.czO.mo27931a(((C5694a) getEditor()).aeM());
    }

    /* access modifiers changed from: private */
    public boolean aeV() {
        if (!aeA() || getActivity() == null) {
            return false;
        }
        String string = getActivity().getString(R.string.xiaoying_str_com_ok);
        C8978m.m26348af(getActivity(), getActivity().getString(R.string.xiaoying_str_com_cancel), string).mo10296do(R.string.xiaoying_str_com_dialog_cancel_all_ask).mo10281a((C1904j) new C1904j() {
            public void onClick(C1890f fVar, C1885b bVar) {
                ParamAdjustOpsView.this.afc();
            }
        }).mo10313qu().show();
        return true;
    }

    /* access modifiers changed from: private */
    public void afc() {
        exit();
    }

    /* access modifiers changed from: private */
    public void afd() {
        Activity activity = (Activity) this.bwg.get();
        if (activity != null) {
            if (aff()) {
                mo27925ak(activity);
            } else {
                afe();
            }
        }
    }

    private void afe() {
        if (this.czO == null) {
            exit();
        } else if (!aeA()) {
            exit();
        } else {
            ((C5694a) this.cyD).mo27883a(C6312c.CLIP_ADJUST);
            QEffectPropertyData[] aeZ = this.czO.aeZ();
            C8443d adQ = ((C5694a) getEditor()).adQ();
            if (!this.czN.isSelected() || adQ == null) {
                for (Integer intValue : ((C5694a) getEditor()).aeK()) {
                    QClip le = ((C5694a) getEditor()).mo27892le(intValue.intValue());
                    if (le != null) {
                        setParamAdjustEffect(le);
                        C8537n.m24792a(aeZ, C8537n.m24797a(le, 105, 0));
                    }
                }
            } else {
                C5554b.m15023aD(getContext(), "视频参数调节");
                int clipCount = adQ.getClipCount();
                for (int i = 0; i < clipCount; i++) {
                    QClip le2 = ((C5694a) getEditor()).mo27892le(((C5694a) getEditor()).mo27891ld(i));
                    if (le2 != null) {
                        setParamAdjustEffect(le2);
                        C8537n.m24792a(aeZ, C8537n.m24797a(le2, 105, 0));
                    }
                }
                ToastUtils.show(getContext(), R.string.xiaoying_str_ve_clipedit_apply_to_all_clips_suc, 1);
            }
            ((C5694a) getEditor()).adL().mo34669jt(true);
            exit();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: gH */
    public int[] m15818gH(String str) {
        int[] iArr = new int[10];
        try {
            JSONObject jSONObject = new JSONObject(str);
            iArr[0] = jSONObject.optInt("brightness", 50);
            iArr[1] = jSONObject.optInt("saturation", 50);
            iArr[2] = jSONObject.optInt("contrast", 50);
            iArr[3] = jSONObject.optInt("temperature", 50);
            iArr[4] = jSONObject.optInt("sharpen", 50);
            iArr[5] = jSONObject.optInt("vignette", 50);
            iArr[6] = jSONObject.optInt("tone", 50);
            iArr[7] = jSONObject.optInt("shadow", 50);
            iArr[8] = jSONObject.optInt("highlight", 50);
            iArr[9] = jSONObject.optInt("fade", 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return iArr;
    }

    public boolean aeA() {
        return this.czO.aeY() || this.czN.isSelected();
    }

    public void aex() {
        super.aex();
        if (((C5694a) getEditor()).aeK().size() == 0) {
            exit();
            return;
        }
        m15809Oj();
        aeU();
        if (!C8072q.aBx().mo33072ku(C7825a.VIDEO_PARAM_ADJUST.getId()) && !C4577f.m11630i(this.czL)) {
            this.czL = C4577f.m11623a(getContext(), (View) this, "adjustment", (int) IapRTConstants.REQUEST_CODE_FOR_VIP);
        }
        m15810Uc();
    }

    public boolean aey() {
        return true;
    }

    public void afb() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.editor_param_adjust_terminator_content, null);
        inflate.findViewById(R.id.param_adjust_lock).setVisibility(8);
        this.czM.setTitleContentLayout(inflate);
    }

    /* access modifiers changed from: protected */
    public boolean aff() {
        return C8049f.aBf().aBr() && !C8072q.aBx().mo33072ku(C7825a.VIDEO_PARAM_ADJUST.getId());
    }

    /* access modifiers changed from: protected */
    /* renamed from: ak */
    public void mo27925ak(Activity activity) {
        C8049f.aBf().mo33097b(activity, "platinum", C7825a.VIDEO_PARAM_ADJUST.getId(), "adjustment", IapRTConstants.REQUEST_CODE_FOR_VIP);
    }

    public int getLayoutId() {
        return R.layout.editor_clip_param_adjust_ops;
    }

    public int getStreamType() {
        return 2;
    }

    public void onActivityDestroy() {
        super.onActivityDestroy();
        C4577f.m11629e(this.czL);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && intent != null && i == 9527) {
            afb();
        }
    }

    public void onActivityResume() {
        super.onActivityResume();
        if (C8072q.aBx().mo33072ku(C7825a.VIDEO_PARAM_ADJUST.getId())) {
            C4577f.m11629e(this.czL);
        }
    }

    public boolean onBackPressed() {
        ((C5694a) getEditor()).adX();
        return aeV() || super.onBackPressed();
    }

    public void setParamAdjustEffect(QClip qClip) {
        if (C8537n.m24829i(qClip, 105) == 0) {
            C8537n.m24788a(qClip, C8762d.aMt().mo35225bB(C6386d.dkB.longValue()), ((C5694a) getEditor()).adP(), 105);
        }
    }
}
