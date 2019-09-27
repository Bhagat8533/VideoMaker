package com.introvd.template.editor.clipedit.transition;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.support.p021v4.content.ContextCompat;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.afollestad.materialdialogs.C1885b;
import com.afollestad.materialdialogs.C1890f;
import com.afollestad.materialdialogs.C1890f.C1904j;
import com.introvd.template.common.FileUtils;
import com.introvd.template.common.ToastUtils;
import com.introvd.template.editor.R;
import com.introvd.template.editor.base.BaseOperationView;
import com.introvd.template.editor.clipedit.transition.recycler.C5804a;
import com.introvd.template.editor.clipedit.transition.recycler.TransitionRecyclerView;
import com.introvd.template.editor.common.model.EffectInfo;
import com.introvd.template.editor.common.terminator.Terminator;
import com.introvd.template.editor.common.terminator.Terminator.C5858a;
import com.introvd.template.editor.p244a.C5554b;
import com.introvd.template.editor.p261g.C6312c;
import com.introvd.template.editor.player.p267a.C6497n;
import com.introvd.template.p414ui.dialog.C8978m;
import com.introvd.template.router.PassThoughUrlGenerator;
import com.introvd.template.router.editor.EditorIntentInfo;
import com.introvd.template.router.editor.EditorRouter;
import com.introvd.template.router.template.TemplateRouter;
import com.introvd.template.sdk.model.TemplateConditionModel;
import com.introvd.template.sdk.model.editor.DataItemProject;
import com.introvd.template.sdk.model.editor.EffectInfoModel;
import com.introvd.template.sdk.p383c.C8399c;
import com.introvd.template.sdk.utils.p394b.C8537n;
import com.introvd.template.sdk.utils.p394b.C8540q;
import com.introvd.template.template.download.C8703d;
import com.introvd.template.template.download.C8708f;
import com.introvd.template.template.p409g.C8759b;
import com.introvd.template.template.p409g.C8762d;
import com.p131c.p132a.p133a.C2564c;
import com.p131c.p132a.p135c.p136a.C2579b;
import com.p131c.p132a.p135c.p136a.C2579b.C2582a;
import xiaoying.engine.base.QUtils;
import xiaoying.engine.storyboard.QStoryboard;

@SuppressLint({"ViewConstructor"})
public class TransitionOpsView extends BaseOperationView<C5801a> implements OnClickListener {
    public volatile long bNB = 0;
    private C8703d bOW = null;
    private View cCP;
    /* access modifiers changed from: private */
    public ImageButton cCQ;
    private TransitionRecyclerView cCR;
    private C5804a cCS;
    private EffectInfo cCT;
    /* access modifiers changed from: private */
    public EffectInfo cCU = null;
    private C5802b cCV = new C5802b() {
        public void aeP() {
            TemplateRouter.startTemplateInfoActivity(TransitionOpsView.this.getActivity(), C8399c.ecZ);
        }

        public boolean afT() {
            if (((C5801a) TransitionOpsView.this.getEditor()).aeK().size() >= 1 && (((C5801a) TransitionOpsView.this.getEditor()).aeK().size() != 1 || !((C5801a) TransitionOpsView.this.getEditor()).mo28089lt(((Integer) ((C5801a) TransitionOpsView.this.getEditor()).aeK().get(0)).intValue()))) {
                return false;
            }
            ToastUtils.show(TransitionOpsView.this.getContext(), R.string.xiaoying_str_ve_transition_only_one_tip, 0);
            return true;
        }

        /* renamed from: b */
        public void mo28085b(EffectInfoModel effectInfoModel) {
            if (effectInfoModel != null) {
                TransitionOpsView.this.mo28074a(effectInfoModel, "transition");
                if (afT()) {
                    TransitionOpsView.this.bNB = -1;
                } else {
                    TransitionOpsView.this.bNB = effectInfoModel.mTemplateId;
                }
            }
        }

        /* renamed from: gN */
        public void mo28086gN(String str) {
            TransitionOpsView.this.bNB = -1;
            if (FileUtils.isFileExisted(str)) {
                TransitionOpsView.this.cCU = C5801a.m16149gM(str);
                TransitionOpsView.this.getVideoOperator().mo29686b(new C6497n(4).mo29744ik(str).mo29745on(TransitionOpsView.this.cCU.mChildIndex).mo29746oo(((C5801a) TransitionOpsView.this.getEditor()).getFocusIndex()));
            }
        }
    };
    private C8708f csV = new C8708f() {
        /* renamed from: b */
        public void mo24951b(Long l) {
            TransitionOpsView.this.mo28076j(l);
        }

        /* renamed from: c */
        public void mo24952c(long j, int i) {
            TransitionOpsView.this.mo28075d(j, i);
        }

        /* renamed from: c */
        public void mo24953c(Long l) {
            TransitionOpsView.this.mo28079m(l);
            if (l.longValue() == TransitionOpsView.this.bNB) {
                TransitionOpsView.this.mo28080n(l);
                TransitionOpsView.this.bNB = -1;
            }
        }

        /* renamed from: o */
        public void mo27389o(Long l) {
            TransitionOpsView.this.mo28077k(l);
        }

        /* renamed from: p */
        public void mo27390p(Long l) {
            TransitionOpsView.this.mo28078l(l);
        }
    };
    private Terminator czM;

    public TransitionOpsView(Activity activity) {
        super(activity, C5801a.class);
    }

    /* renamed from: Nu */
    private void m16121Nu() {
        this.cCP.setOnClickListener(this);
        this.czM.setTerminatorListener(new C5858a() {
            public void aeW() {
                if (!TransitionOpsView.this.afX()) {
                    TransitionOpsView.this.exit();
                }
            }

            public void aeX() {
                ((C5801a) TransitionOpsView.this.getEditor()).adX();
                boolean isSelected = TransitionOpsView.this.cCQ.isSelected();
                if (TransitionOpsView.this.aeA()) {
                    ((C5801a) TransitionOpsView.this.getEditor()).mo27884a(C6312c.CLIP_TRANSITION, isSelected, false);
                    ((C5801a) TransitionOpsView.this.getEditor()).mo28087a(TransitionOpsView.this.cCU);
                }
                if (isSelected) {
                    C5554b.m15023aD(TransitionOpsView.this.getContext(), "转场");
                }
                long jf = C8759b.m25587jf(TransitionOpsView.this.cCU.mEffectPath);
                if (jf > 0) {
                    C5803c.m16155a(TransitionOpsView.this.getContext(), jf, null);
                }
                TransitionOpsView.this.exit();
            }
        });
    }

    /* renamed from: a */
    private int m16122a(QStoryboard qStoryboard, int i) {
        if (C8540q.m24976w(qStoryboard)) {
            i++;
        }
        if (qStoryboard.getClipCount() > 1) {
            return C8540q.m24968q(qStoryboard, i);
        }
        return 0;
    }

    private void afU() {
        this.cCP = findViewById(R.id.apply_all_layout);
        this.cCQ = (ImageButton) findViewById(R.id.apply_all_btn);
        this.cCR = (TransitionRecyclerView) findViewById(R.id.transition_recyclerview);
        this.czM = (Terminator) findViewById(R.id.terminator);
        if (!((C5801a) getEditor()).aeL()) {
            this.cCP.setVisibility(4);
        } else {
            this.cCP.setVisibility(0);
        }
        afV();
        m16121Nu();
    }

    private void afV() {
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.random_apply_layout);
        C2579b.m7399a(new C2582a<View>() {
            public void onClick(View view) {
                C2564c.show((ImageView) TransitionOpsView.this.findViewById(R.id.iv_random));
                TransitionOpsView.this.afW();
            }
        }, linearLayout);
    }

    /* access modifiers changed from: private */
    public void afW() {
        Activity activity = getActivity();
        if (activity != null && !activity.isFinishing()) {
            C8978m.m26349hs(activity).mo10293dl(R.string.xiaoying_str_editor_transition_random_title).mo10296do(R.string.xiaoying_str_editor_transition_random_msg).mo10303dv(R.string.xiaoying_str_com_cancel).mo10299dr(R.string.xiaoying_str_community_confirm_btn).mo10300ds(ContextCompat.getColor(getContext(), R.color.color_ff5e13)).mo10302du(ContextCompat.getColor(getContext(), R.color.color_ff5e13)).mo10281a((C1904j) new C1904j() {
                public void onClick(C1890f fVar, C1885b bVar) {
                    ((TextView) TransitionOpsView.this.findViewById(R.id.tv_random)).setTextColor(-1);
                }
            }).mo10313qu().show();
        }
    }

    /* access modifiers changed from: private */
    public boolean afX() {
        ((C5801a) getEditor()).adX();
        if (!aeA() || getActivity() == null) {
            return false;
        }
        String string = getActivity().getString(R.string.xiaoying_str_com_ok);
        C8978m.m26348af(getActivity(), getActivity().getString(R.string.xiaoying_str_com_cancel), string).mo10296do(R.string.xiaoying_str_com_dialog_cancel_all_ask).mo10281a((C1904j) new C1904j() {
            public void onClick(C1890f fVar, C1885b bVar) {
                TransitionOpsView.this.exit();
            }
        }).mo10313qu().show();
        return true;
    }

    /* renamed from: gC */
    private void m16131gC(String str) {
        if (this.cCR != null) {
            this.cCR.mo28093gQ(str);
        }
    }

    private void initData() {
        int i;
        long templateID = C8762d.aMt().getTemplateID((String) ((C5801a) getEditor()).adO().getProperty(16391));
        String str = "";
        if (((C5801a) getEditor()).aeL()) {
            str = C8540q.m24960k(((C5801a) getEditor()).adO(), ((C5801a) getEditor()).getFocusIndex());
            i = C8537n.m24839r(C8540q.m24956i(((C5801a) getEditor()).adO(), ((C5801a) getEditor()).getFocusIndex()));
            if (TextUtils.isEmpty(str)) {
                str = "assets_android://xiaoying/transition/0300000000000000.xyt";
            }
        } else {
            i = 0;
        }
        String str2 = str;
        this.cCT = new EffectInfo();
        this.cCT.mEffectPath = str2;
        this.cCT.mChildIndex = i;
        this.cCU = this.cCT;
        TemplateConditionModel templateConditionModel = new TemplateConditionModel();
        DataItemProject aHe = ((C5801a) getEditor()).adK().aHe();
        if (aHe != null) {
            templateConditionModel.mLayoutMode = QUtils.getLayoutMode(aHe.streamWidth, aHe.streamHeight);
            templateConditionModel.isPhoto = aHe.isMVPrj();
        }
        C5804a aVar = new C5804a(getContext(), templateID, templateConditionModel, str2);
        this.cCS = aVar;
        this.cCR.mo28090a(this.cCS, this.cCV);
    }

    /* renamed from: a */
    public void mo28074a(EffectInfoModel effectInfoModel, String str) {
        if (this.bOW != null) {
            this.bOW.mo35077a(effectInfoModel, str);
        }
    }

    public boolean aeA() {
        boolean z = this.cCT != null ? !this.cCT.equals(this.cCU) : false;
        return !z ? this.cCQ.isSelected() : z;
    }

    public void aex() {
        super.aex();
        if (((C5801a) getEditor()).aeK().size() == 0) {
            exit();
            return;
        }
        this.bOW = new C8703d(getContext(), this.csV);
        afU();
        initData();
        ((C5801a) getEditor()).mo27846H(m16122a(((C5801a) getEditor()).adO(), ((C5801a) getEditor()).getFocusIndex()), false);
        getVideoOperator().mo29678a(new C6497n(4).mo29744ik(this.cCS.agc()).mo29745on(C5801a.m16149gM(this.cCS.agc()).mChildIndex).mo29746oo(((C5801a) getEditor()).getFocusIndex()).mo29743gp(false));
        EditorIntentInfo editorIntentInfo = (EditorIntentInfo) PassThoughUrlGenerator.getInfoFromBundle(getBundle(), EditorIntentInfo.class);
        if (editorIntentInfo != null) {
            String str = (String) editorIntentInfo.paramMap.get(EditorRouter.MAP_PARAMS_TEMPLATE_ID);
            String str2 = (String) editorIntentInfo.paramMap.get(EditorRouter.MAP_PARAMS_TEMPLATE_PATH);
            if (TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
                try {
                    str2 = C8759b.m25586by(Long.decode(str).longValue());
                } catch (Exception unused) {
                }
            }
            if (!TextUtils.isEmpty(str2) && this.cCR != null) {
                this.cCR.mo28093gQ(str2);
            }
        }
    }

    /* renamed from: d */
    public void mo28075d(long j, int i) {
        if (this.cCR != null) {
            this.cCR.mo28092e(j, i);
        }
    }

    public int getLayoutId() {
        return R.layout.editor_operation_transition_view;
    }

    /* renamed from: j */
    public void mo28076j(Long l) {
    }

    /* renamed from: k */
    public void mo28077k(Long l) {
    }

    /* renamed from: l */
    public void mo28078l(Long l) {
        if (this.cCR != null) {
            this.cCR.mo28092e(l.longValue(), -2);
        }
    }

    /* renamed from: m */
    public void mo28079m(Long l) {
        if (this.cCR != null) {
            this.cCR.mo28091d(l.longValue(), C8759b.m25586by(l.longValue()));
        }
    }

    /* renamed from: n */
    public void mo28080n(Long l) {
        if (l.longValue() > 0) {
            String by = C8759b.m25586by(l.longValue());
            if (!TextUtils.isEmpty(by) && this.cCR != null) {
                this.cCR.mo28093gQ(by);
            }
        }
    }

    public void onActivityDestroy() {
        super.onActivityDestroy();
        if (this.bOW != null) {
            this.bOW.mo35076VD();
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && intent != null && i == 24580) {
            String stringExtra = intent.getStringExtra("template_path");
            if (this.cCV != null && !this.cCV.afT()) {
                m16131gC(stringExtra);
            }
        }
    }

    public boolean onBackPressed() {
        return afX() || super.onBackPressed();
    }

    public void onClick(View view) {
        if (this.cCP.equals(view)) {
            C2564c.show(this.cCQ);
            this.cCQ.setSelected(!this.cCQ.isSelected());
            ((C5801a) getEditor()).mo28088eF(this.cCQ.isSelected());
        }
    }
}
