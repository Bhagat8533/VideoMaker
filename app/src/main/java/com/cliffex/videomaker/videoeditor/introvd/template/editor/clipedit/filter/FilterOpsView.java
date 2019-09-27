package com.introvd.template.editor.clipedit.filter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import com.afollestad.materialdialogs.C1885b;
import com.afollestad.materialdialogs.C1890f;
import com.afollestad.materialdialogs.C1890f.C1904j;
import com.introvd.template.common.LogUtils;
import com.introvd.template.editor.R;
import com.introvd.template.editor.base.BaseOperationView;
import com.introvd.template.editor.clipedit.C5694a;
import com.introvd.template.editor.clipedit.filter.AdvanceFilterPanel.C5697a;
import com.introvd.template.editor.common.terminator.Terminator;
import com.introvd.template.editor.common.terminator.Terminator.C5858a;
import com.introvd.template.editor.p244a.C5554b;
import com.introvd.template.editor.p261g.C6312c;
import com.introvd.template.editor.player.p267a.C6486c;
import com.introvd.template.editor.widget.seekbar.C7079c;
import com.introvd.template.editor.widget.seekbar.C7080d;
import com.introvd.template.editor.widget.seekbar.IndicatorSeekBar;
import com.introvd.template.module.iap.C8048e;
import com.introvd.template.module.iap.C8049f;
import com.introvd.template.module.iap.C8070o;
import com.introvd.template.module.iap.business.p349a.C7825a;
import com.introvd.template.module.iap.business.p356e.C7897a;
import com.introvd.template.p203b.C4580b;
import com.introvd.template.p203b.p204a.C4576e;
import com.introvd.template.p203b.p204a.C4577f;
import com.introvd.template.p414ui.dialog.C8978m;
import com.introvd.template.router.PassThoughUrlGenerator;
import com.introvd.template.router.editor.EditorIntentInfo;
import com.introvd.template.router.editor.EditorRouter;
import com.introvd.template.router.kiwi.LDPProtect;
import com.introvd.template.router.template.TemplateRouter;
import com.introvd.template.router.todoCode.TODOParamModel;
import com.introvd.template.sdk.model.editor.DataItemProject;
import com.introvd.template.sdk.model.editor.EffectInfoModel;
import com.introvd.template.sdk.model.editor.ProjectItem;
import com.introvd.template.sdk.model.template.RollInfo;
import com.introvd.template.sdk.model.template.TemplateInfo;
import com.introvd.template.sdk.utils.p394b.C8501a;
import com.introvd.template.sdk.utils.p394b.C8537n;
import com.introvd.template.sdk.utils.p394b.C8540q;
import com.introvd.template.template.download.C8702c;
import com.introvd.template.template.download.C8703d;
import com.introvd.template.template.p407e.C8735f;
import com.introvd.template.template.p407e.C8745n;
import com.introvd.template.template.p409g.C8759b;
import com.introvd.template.template.p409g.C8762d;
import com.p131c.p132a.p133a.C2564c;
import com.p131c.p132a.p135c.C2575a;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;
import p037b.p050b.C1834l;
import p037b.p050b.C1842q;
import p037b.p050b.C1848s;
import p037b.p050b.C1850u;
import p037b.p050b.p051a.p053b.C1487a;
import p037b.p050b.p054b.C1494a;
import p037b.p050b.p054b.C1495b;
import p037b.p050b.p073g.C1810c;
import p037b.p050b.p076j.C1820a;
import xiaoying.engine.base.QStyle;
import xiaoying.engine.base.QStyle.QEffectPropertyData;
import xiaoying.engine.base.QStyle.QEffectPropertyInfo;
import xiaoying.engine.base.QUtils;
import xiaoying.engine.clip.QClip;
import xiaoying.engine.clip.QEffect;

@LDPProtect
@SuppressLint({"ViewConstructor"})
public class FilterOpsView extends BaseOperationView<C5694a> {
    /* access modifiers changed from: private */
    public C1494a compositeDisposable;
    private List<Integer> cyP;
    /* access modifiers changed from: private */
    public AdvanceFilterPanel czc;
    private C8703d czd = null;
    /* access modifiers changed from: private */
    public View cze;
    /* access modifiers changed from: private */
    public ImageButton czf;
    private RelativeLayout czg;
    private IndicatorSeekBar czh;
    /* access modifiers changed from: private */
    public String czi = null;
    private String czj = null;
    /* access modifiers changed from: private */
    public C4576e czk;
    /* access modifiers changed from: private */
    public String czl = null;
    /* access modifiers changed from: private */
    public Map<String, Integer> czm = new LinkedHashMap();
    /* access modifiers changed from: private */
    public boolean czn;
    /* access modifiers changed from: private */
    public int czo;
    /* access modifiers changed from: private */
    public int paramId = -1;

    public FilterOpsView(Activity activity) {
        super(activity, C5694a.class);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m15769a(TemplateInfo templateInfo, String str) {
        if (templateInfo != null) {
            RollInfo rollInfo = (RollInfo) templateInfo;
            if (rollInfo.rollModel != null) {
                EffectInfoModel effectInfoModel = new EffectInfoModel();
                effectInfoModel.setmUrl(rollInfo.rollModel.rollDownUrl);
                effectInfoModel.mName = templateInfo.strTitle;
                effectInfoModel.mTemplateId = C2575a.parseLong(templateInfo.ttid);
                this.czd.mo35077a(effectInfoModel, str);
                C8735f.aMf().mo35136D(templateInfo);
            }
        }
    }

    /* renamed from: a */
    private void m15770a(QClip qClip, int i) {
        QEffect a = C8537n.m24797a(qClip, 2, 0);
        if (this.paramId > -1) {
            QEffectPropertyData qEffectPropertyData = new QEffectPropertyData();
            qEffectPropertyData.mID = this.paramId;
            qEffectPropertyData.mValue = i;
            a.setProperty(QEffect.PROP_EFFECT_PROPDATA, qEffectPropertyData);
            return;
        }
        a.setProperty(QEffect.PROP_EFFECT_BLEND_ALPHA, Float.valueOf(((float) i) / 100.0f));
    }

    private void aeQ() {
        this.czc = (AdvanceFilterPanel) findViewById(R.id.advance_filter_panel);
        this.czc.setFilterPanelListener(new C5697a() {
            public void aeP() {
                TemplateRouter.launchFilterForResult(FilterOpsView.this.getActivity(), "", 24580);
                FilterOpsView.this.czc.setInStore(true);
            }

            /* renamed from: b */
            public void mo27911b(String str, boolean z, String str2) {
                FilterOpsView.this.m15784gD(str);
                FilterOpsView.this.czc.mo27905i(str, false);
                C5708a.m15808a(FilterOpsView.this.czc.getOwnEffectMgr(), str);
                FilterOpsView.this.czl = str2;
                FilterOpsView.this.m15782gB(str2);
            }

            /* renamed from: i */
            public void mo27912i(TemplateInfo templateInfo) {
                FilterOpsView.this.m15769a(templateInfo, "type_roll");
            }
        });
    }

    private void aeR() {
        ((Terminator) findViewById(R.id.terminator)).setTerminatorListener(new C5858a() {
            public void aeW() {
                ((C5694a) FilterOpsView.this.getEditor()).adX();
                if (!FilterOpsView.this.aeV()) {
                    FilterOpsView.this.exit();
                }
            }

            public void aeX() {
                ((C5694a) FilterOpsView.this.getEditor()).adX();
                C5708a.m15807a(FilterOpsView.this.getContext(), C8762d.aMt().getTemplateID(FilterOpsView.this.czi), FilterOpsView.this.czm.containsKey(FilterOpsView.this.czi) ? ((Integer) FilterOpsView.this.czm.get(FilterOpsView.this.czi)).intValue() : 100);
                if (C8049f.aBf().aBr() && C8049f.aBf().mo33101iL(FilterOpsView.this.czl)) {
                    C8049f.aBf().mo33097b(FilterOpsView.this.getContext(), C8070o.aBw(), C7825a.ALL_TEMPLATE.getId(), "effects", -1);
                    C7897a.m23022b(FilterOpsView.this.czl, "Iap_Purchase_Template_Id", new String[0]);
                    return;
                }
                if (FilterOpsView.this.aeA()) {
                    ((C5694a) FilterOpsView.this.cyD).mo27883a(C6312c.CLIP_FILTER);
                    FilterOpsView.this.m15787gG(FilterOpsView.this.czi);
                    ((C5694a) FilterOpsView.this.cyD).adL().mo34669jt(true);
                }
                FilterOpsView.this.exit();
            }
        });
    }

    private void aeS() {
        C1834l.m5257ah(Boolean.valueOf(true)).mo10164f(300, TimeUnit.MILLISECONDS).mo10157d(C1820a.aVi()).mo10152c(C1487a.aUa()).mo10149b((C1842q<? super T>) new C1842q<Boolean>() {
            /* renamed from: a */
            public void mo9877a(C1495b bVar) {
                FilterOpsView.this.compositeDisposable.mo9785e(bVar);
            }

            /* renamed from: b */
            public void mo9886K(Boolean bool) {
                String str = "";
                TODOParamModel todoParamModel = ((C5694a) FilterOpsView.this.getEditor()).getTodoParamModel();
                if (todoParamModel != null) {
                    JSONObject jsonObj = todoParamModel.getJsonObj();
                    if (jsonObj != null) {
                        str = jsonObj.optString("roll");
                    }
                }
                if (TextUtils.isEmpty(str)) {
                    EditorIntentInfo editorIntentInfo = (EditorIntentInfo) PassThoughUrlGenerator.getInfoFromBundle(FilterOpsView.this.getBundle(), EditorIntentInfo.class);
                    if (editorIntentInfo != null) {
                        String str2 = (String) editorIntentInfo.paramMap.get(EditorRouter.MAP_PARAMS_TEMPLATE_PATH);
                        if (TextUtils.isEmpty(str2)) {
                            String str3 = (String) editorIntentInfo.paramMap.get(EditorRouter.MAP_PARAMS_TEMPLATE_ID);
                            str2 = str3 == null ? "" : C8759b.m25586by(C2575a.m7391rq(str3));
                        }
                        if (!TextUtils.isEmpty(str2)) {
                            FilterOpsView.this.m15783gC(str2);
                        }
                    }
                } else if (FilterOpsView.this.czc != null) {
                    FilterOpsView.this.czc.mo27904gy(str);
                }
            }

            public void onComplete() {
            }

            public void onError(Throwable th) {
            }
        });
    }

    private void aeT() {
        this.cze = findViewById(R.id.apply_all_layout);
        this.czf = (ImageButton) findViewById(R.id.apply_all_btn);
        if (((C5694a) getEditor()).aeL()) {
            this.cze.setVisibility(0);
            this.cze.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    if (!C4580b.m11632Sf() && view == FilterOpsView.this.cze) {
                        C2564c.m7330dy(FilterOpsView.this.czf);
                        FilterOpsView.this.czf.setSelected(!FilterOpsView.this.czf.isSelected());
                    }
                }
            });
            return;
        }
        this.czf.setSelected(false);
        this.cze.setVisibility(8);
    }

    private void aeU() {
        Activity activity = (Activity) this.bwg.get();
        if (activity != null) {
            ProjectItem ahP = ((C5694a) getEditor()).adK().aHf();
            DataItemProject aHe = ((C5694a) getEditor()).adK().aHe();
            if (!(((C5694a) getEditor()).adO() == null || aHe == null || ahP == null || ahP.mClipModelCacheList == null)) {
                long templateID = C8762d.aMt().getTemplateID((String) ((C5694a) getEditor()).adO().getProperty(16391));
                int layoutMode = QUtils.getLayoutMode(aHe.streamWidth, aHe.streamHeight);
                QClip i = C8540q.m24956i(((C5694a) getEditor()).adO(), ((C5694a) getEditor()).getFocusIndex());
                this.czj = C8540q.m24972t(i);
                this.czi = this.czj;
                QEffect a = C8537n.m24797a(i, 2, 0);
                if (a != null) {
                    int gF = m15786gF(this.czi);
                    int i2 = 100;
                    if (gF > -1) {
                        QEffectPropertyData effectPropData = a.getEffectPropData(gF);
                        if (effectPropData != null) {
                            i2 = effectPropData.mValue;
                        }
                    } else {
                        i2 = (int) (((Float) a.getProperty(QEffect.PROP_EFFECT_BLEND_ALPHA)).floatValue() * 100.0f);
                    }
                    this.czm.put(this.czi, Integer.valueOf(i2));
                }
                m15785gE(this.czi);
                int clipCount = ((C5694a) getEditor()).adO().getClipCount();
                AdvanceFilterPanel advanceFilterPanel = this.czc;
                String str = this.czi;
                boolean z = true;
                if (!((C5694a) getEditor()).aeL() && clipCount != 1) {
                    z = false;
                }
                advanceFilterPanel.mo27894a(activity, templateID, layoutMode, str, z);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: gB */
    public void m15782gB(final String str) {
        if (TextUtils.isEmpty(str) || !C8745n.m25561qv(this.czl)) {
            C4577f.m11629e(this.czk);
        } else {
            C1848s.m5326ai(str).mo10194f(C1487a.aUa()).mo10188a((C1850u<? super T>) new C1810c<String>() {
                /* renamed from: dV */
                public void onSuccess(String str) {
                    if (TextUtils.isEmpty(str)) {
                        C4577f.m11629e(FilterOpsView.this.czk);
                        return;
                    }
                    if (C8049f.aBf().mo33101iL(str)) {
                        C7897a.m23022b(str, "Iap_Purchase_Template_Id", new String[0]);
                        if (!C4577f.m11630i(FilterOpsView.this.czk)) {
                            FilterOpsView.this.czk = C4577f.m11623a((Context) FilterOpsView.this.getActivity(), (View) FilterOpsView.this, "effects", -1);
                        }
                    } else {
                        C4577f.m11629e(FilterOpsView.this.czk);
                    }
                }

                public void onError(Throwable th) {
                    C8048e.aBe().logException(th);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: gC */
    public void m15783gC(String str) {
        if (!aeC() && this.czc != null) {
            this.czc.setCurrEffectPath(str);
            this.czc.mo27899ev(true);
            m15784gD(str);
            this.czc.mo27905i(str, true);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: gD */
    public void m15784gD(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.czi = str;
            getVideoOperator().mo29686b(new C6486c(0, str, this.paramId, m15785gE(str)));
        }
    }

    /* renamed from: gE */
    private int m15785gE(String str) {
        this.paramId = m15786gF(str);
        long jf = C8759b.m25587jf(str);
        int intValue = this.czm.containsKey(str) ? ((Integer) this.czm.get(str)).intValue() : 100;
        if (jf == QStyle.NONE_FILTER_TEMPLATE_ID || TextUtils.isEmpty(str)) {
            this.czg.setVisibility(8);
        } else {
            this.czh.setProgress((float) intValue);
            this.czg.setVisibility(0);
            this.czo = intValue;
        }
        return intValue;
    }

    /* renamed from: gF */
    private int m15786gF(String str) {
        int i = -1;
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        QEffectPropertyInfo[] iEPropertyInfo = QStyle.getIEPropertyInfo(C8501a.aJs().aJv(), C8759b.m25587jf(str));
        if (iEPropertyInfo != null && iEPropertyInfo.length > 0) {
            int length = iEPropertyInfo.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                QEffectPropertyInfo qEffectPropertyInfo = iEPropertyInfo[i2];
                if ("percentage".equals(qEffectPropertyInfo.name)) {
                    i = qEffectPropertyInfo.f3719id;
                    break;
                }
                i2++;
            }
        }
        return i;
    }

    /* access modifiers changed from: private */
    /* renamed from: gG */
    public void m15787gG(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (this.czf.isSelected()) {
                C5554b.m15023aD(getContext(), "滤镜");
                for (int i = 0; i < ((C5694a) getEditor()).adQ().getClipCount(); i++) {
                    m15793l(i, str);
                }
            } else if (this.cyP != null) {
                for (Integer intValue : this.cyP) {
                    m15793l(intValue.intValue(), str);
                }
            }
        }
    }

    private void initUI() {
        aeR();
        aeT();
        aeQ();
        this.czg = (RelativeLayout) findViewById(R.id.indicator_layout);
        this.czh = (IndicatorSeekBar) findViewById(R.id.indicatorSeekBar);
        this.czh.setIndicatorTextFormat("${PROGRESS}%");
        this.czh.setOnSeekChangeListener(new C7079c() {
            /* renamed from: a */
            public void mo27915a(IndicatorSeekBar indicatorSeekBar) {
                FilterOpsView.this.czn = true;
            }

            /* renamed from: a */
            public void mo27916a(C7080d dVar) {
                if (FilterOpsView.this.czn && dVar != null) {
                    int i = dVar.progress;
                    StringBuilder sb = new StringBuilder();
                    sb.append("onSeeking value:");
                    sb.append(i);
                    LogUtils.m14222e("IndicatorSeek", sb.toString());
                    FilterOpsView.this.czm.put(FilterOpsView.this.czi, Integer.valueOf(i));
                    FilterOpsView.this.czo = i;
                    FilterOpsView.this.getVideoOperator().mo29686b(new C6486c(1, FilterOpsView.this.paramId, i));
                }
            }

            /* renamed from: b */
            public void mo27917b(IndicatorSeekBar indicatorSeekBar) {
                FilterOpsView.this.czn = false;
            }
        });
    }

    /* renamed from: l */
    private void m15793l(int i, String str) {
        if (C8540q.m24921a(((C5694a) getEditor()).adO(), i, str, true) == 0) {
            QClip i2 = C8540q.m24956i(((C5694a) getEditor()).adO(), i);
            m15770a(i2, this.czo);
            ((C5694a) getEditor()).adQ().mo34299dA(i, C8537n.m24829i(i2, 2));
        }
    }

    public boolean aeA() {
        boolean z = false;
        if (TextUtils.isEmpty(this.czj) && TextUtils.isEmpty(this.czi)) {
            return false;
        }
        if (this.czf.isSelected()) {
            return true;
        }
        if (!TextUtils.equals(this.czj, this.czi) || (this.czm.containsKey(this.czi) && ((Integer) this.czm.get(this.czi)).intValue() != 100)) {
            z = true;
        }
        return z;
    }

    public boolean aeV() {
        if (!aeA() || getActivity() == null || getActivity().isFinishing()) {
            return false;
        }
        C8978m.m26348af(getActivity(), getActivity().getString(R.string.xiaoying_str_com_cancel), getActivity().getString(R.string.xiaoying_str_com_ok)).mo10296do(R.string.xiaoying_str_com_dialog_cancel_all_ask).mo10281a((C1904j) new C1904j() {
            public void onClick(C1890f fVar, C1885b bVar) {
                FilterOpsView.this.exit();
            }
        }).mo10313qu().show();
        return true;
    }

    public void aex() {
        super.aex();
        this.cyP = ((C5694a) getEditor()).aeK();
        if (this.cyP == null || this.cyP.size() == 0) {
            exit();
            return;
        }
        this.compositeDisposable = new C1494a();
        initUI();
        aeU();
        aeS();
        this.czd = new C8703d(getContext(), new C8702c() {
            /* renamed from: c */
            public void mo24952c(long j, int i) {
                if (FilterOpsView.this.czc != null) {
                    FilterOpsView.this.czc.mo27898e(j, i);
                }
            }

            /* renamed from: c */
            public void mo24953c(Long l) {
                if (FilterOpsView.this.czc != null) {
                    FilterOpsView.this.czc.mo27899ev(false);
                }
            }

            /* renamed from: p */
            public void mo27390p(Long l) {
            }
        });
    }

    public boolean aey() {
        return true;
    }

    /* access modifiers changed from: protected */
    public void exit() {
        if (this.compositeDisposable != null) {
            this.compositeDisposable.clear();
        }
        this.czh.setVisibility(8);
        super.exit();
    }

    public int getLayoutId() {
        return R.layout.editor_clip_filter_ops;
    }

    public int getStreamType() {
        return 2;
    }

    public void onActivityDestroy() {
        super.onActivityDestroy();
        if (this.czd != null) {
            this.czd.mo35076VD();
        }
        C4577f.m11629e(this.czk);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && intent != null && i == 24580) {
            String stringExtra = intent.getStringExtra("template_path");
            if (!TextUtils.isEmpty(stringExtra)) {
                this.czl = C8745n.m25556bv(C8759b.m25587jf(stringExtra));
                m15783gC(stringExtra);
            }
        }
    }

    public void onActivityResume() {
        super.onActivityResume();
        m15782gB(this.czl);
        if (this.czc != null) {
            if (this.czc.aeO()) {
                this.czc.mo27899ev(true);
            }
            this.czc.setInStore(false);
            this.czc.mo27900gA(this.czc.getCurrEffectPath());
        }
    }

    public boolean onBackPressed() {
        ((C5694a) getEditor()).adX();
        return aeV() || super.onBackPressed();
    }
}
