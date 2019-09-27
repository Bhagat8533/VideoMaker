package com.introvd.template.editor.preview.fragment.p274a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.p021v4.content.LocalBroadcastManager;
import android.support.p021v4.util.LongSparseArray;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.afollestad.materialdialogs.C1885b;
import com.afollestad.materialdialogs.C1890f;
import com.afollestad.materialdialogs.C1890f.C1904j;
import com.introvd.template.ads.listener.VideoRewardListener;
import com.introvd.template.common.MSize;
import com.introvd.template.common.ToastUtils;
import com.introvd.template.common.controller.BaseController;
import com.introvd.template.common.model.AppStateModel;
import com.introvd.template.datacenter.BaseSocialNotify;
import com.introvd.template.editor.R;
import com.introvd.template.editor.base.C5686a;
import com.introvd.template.editor.common.C5843c;
import com.introvd.template.editor.p261g.C6293a;
import com.introvd.template.editor.p261g.C6293a.C6296a;
import com.introvd.template.editor.p261g.C6312c;
import com.introvd.template.editor.p261g.p262a.C6307c;
import com.introvd.template.editor.p261g.p262a.C6308d;
import com.introvd.template.editor.p261g.p262a.C6308d.C6310a;
import com.introvd.template.editor.p266h.C6375c;
import com.introvd.template.editor.p266h.C6386d;
import com.introvd.template.editor.player.p267a.C6495l;
import com.introvd.template.editor.player.p269b.C6499a;
import com.introvd.template.editor.player.p269b.C6501c;
import com.introvd.template.editor.preview.p271b.C6551b;
import com.introvd.template.editor.preview.view.C6687b;
import com.introvd.template.editor.service.StoryboardOpService;
import com.introvd.template.module.p326ad.C7680l;
import com.introvd.template.module.p326ad.p328b.C7593c;
import com.introvd.template.module.p326ad.p328b.C7594d;
import com.introvd.template.p203b.C4586g;
import com.introvd.template.p203b.C4599k;
import com.introvd.template.p414ui.dialog.C8978m;
import com.introvd.template.router.editor.IEditorService;
import com.introvd.template.sdk.model.TemplateConditionModel;
import com.introvd.template.sdk.model.editor.DataItemProject;
import com.introvd.template.sdk.model.editor.EffectInfoModel;
import com.introvd.template.sdk.model.template.TemplateInfo;
import com.introvd.template.sdk.p383c.C8399c;
import com.introvd.template.sdk.p391g.C8450a;
import com.introvd.template.sdk.p391g.C8451b;
import com.introvd.template.sdk.utils.p394b.C8517b;
import com.introvd.template.sdk.utils.p394b.C8540q;
import com.introvd.template.template.data.C8670b;
import com.introvd.template.template.data.api.model.TemplateResponseInfo;
import com.introvd.template.template.download.C8702c;
import com.introvd.template.template.download.C8703d;
import com.introvd.template.template.download.C8708f;
import com.introvd.template.template.p407e.C8735f;
import com.introvd.template.template.p407e.C8739i;
import com.introvd.template.template.p409g.C8759b;
import com.introvd.template.template.p409g.C8762d;
import com.p131c.p132a.p135c.C2575a;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.greenrobot.eventbus.C10021c;
import p037b.p050b.C1850u;
import p037b.p050b.p051a.p053b.C1487a;
import p037b.p050b.p054b.C1494a;
import p037b.p050b.p054b.C1495b;
import p037b.p050b.p076j.C1820a;
import xiaoying.engine.base.QStyle;
import xiaoying.engine.base.QStyle.QTemplateIDUtils;
import xiaoying.engine.base.QUtils;

/* renamed from: com.introvd.template.editor.preview.fragment.a.d */
public class C6638d extends BaseController<C6637c> {
    private volatile long bNB = 0;
    private C8703d bOW = null;
    private C8759b bOt;
    /* access modifiers changed from: private */
    public C1494a compositeDisposable;
    /* access modifiers changed from: private */
    public Context context;
    private C8708f csV = new C8702c() {
        /* renamed from: c */
        public void mo24952c(long j, int i) {
            if (C6638d.this.dcI.contains(Long.valueOf(j))) {
                C6638d.this.mo30014d(j, i);
            }
        }

        /* renamed from: c */
        public void mo24953c(Long l) {
            if (C6638d.this.dcI.contains(l)) {
                C6638d.this.m19312t(l);
            }
        }

        /* renamed from: p */
        public void mo27390p(Long l) {
            if (C6638d.this.dcI.contains(l)) {
                C6638d.this.mo30003aH(l.longValue());
            }
        }
    };
    private TemplateConditionModel cwF;
    /* access modifiers changed from: private */
    public C5686a cyD;
    /* access modifiers changed from: private */
    public C6499a daT;
    private LongSparseArray<Integer> dbZ = new LongSparseArray<>();
    private EffectInfoModel dcA;
    private List<EffectInfoModel> dcB = new ArrayList();
    private List<EffectInfoModel> dcC = new ArrayList();
    private List<EffectInfoModel> dcD = new ArrayList();
    private List<EffectInfoModel> dcE = new ArrayList();
    private List<EffectInfoModel> dcF = new ArrayList();
    private C6687b dcG;
    /* access modifiers changed from: private */
    public volatile EffectInfoModel dcH = null;
    /* access modifiers changed from: private */
    public List<Long> dcI = new ArrayList();
    private C1890f dcJ;
    private BroadcastReceiver dcK;
    private C6296a dcL;
    private OnClickListener dcM = new OnClickListener() {
        public void onClick(View view) {
            C8739i.m25521b(C6638d.this.context, Long.valueOf(C6638d.this.dcH.mTemplateId));
            C6638d.this.mo30019p(C6638d.this.dcH);
        }
    };
    private OnClickListener dcN = new OnClickListener() {
        public void onClick(View view) {
            if (!BaseSocialNotify.isNetworkAvaliable(C6638d.this.context)) {
                ToastUtils.show(C6638d.this.context, R.string.xiaoying_str_com_msg_network_inactive, 0);
            } else {
                C7680l.aAe().mo32521a(((C6637c) C6638d.this.getMvpView()).getHostActivity(), 19, new VideoRewardListener() {
                });
            }
        }
    };
    private String dcz;

    /* renamed from: com.introvd.template.editor.preview.fragment.a.d$9 */
    static /* synthetic */ class C66499 {
        static final /* synthetic */ int[] dbS = new int[C6312c.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        static {
            /*
                com.introvd.template.editor.g.c[] r0 = com.introvd.template.editor.p261g.C6312c.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                dbS = r0
                int[] r0 = dbS     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.introvd.template.editor.g.c r1 = com.introvd.template.editor.p261g.C6312c.THEME_APPLY     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = dbS     // Catch:{ NoSuchFieldError -> 0x001f }
                com.introvd.template.editor.g.c r1 = com.introvd.template.editor.p261g.C6312c.THEME_TITLE     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.editor.preview.fragment.p274a.C6638d.C66499.<clinit>():void");
        }
    }

    public C6638d(Context context2) {
        this.context = context2;
        this.compositeDisposable = new C1494a();
    }

    /* renamed from: a */
    private TemplateInfo m19294a(long j, List<TemplateInfo>... listArr) {
        if (listArr != null) {
            for (List<TemplateInfo> it : listArr) {
                for (TemplateInfo templateInfo : it) {
                    if (C2575a.m7391rq(templateInfo.ttid) == j) {
                        return templateInfo;
                    }
                }
            }
        }
        return null;
    }

    /* renamed from: a */
    private List<EffectInfoModel> m19295a(List<TemplateInfo> list, long j, Set<Long> set) {
        ArrayList arrayList = new ArrayList();
        if (list == null || list.isEmpty()) {
            return arrayList;
        }
        for (TemplateInfo templateInfo : list) {
            if (templateInfo.isRecommendItem()) {
                long rq = C2575a.m7391rq(templateInfo.ttid);
                if (C8451b.m24479up(QTemplateIDUtils.getTemplateSubType(rq))) {
                    boolean isPhotoTemplate = QTemplateIDUtils.isPhotoTemplate(rq);
                    if ((1048576 & j) == 0 || !isPhotoTemplate) {
                        EffectInfoModel bw = this.bOt.mo35204bw(rq);
                        if (bw == null) {
                            bw = new EffectInfoModel(rq, "");
                            bw.setbNeedDownload(true);
                        }
                        bw.mName = templateInfo.strTitle;
                        bw.mThumbUrl = templateInfo.strIcon;
                        bw.strSceneName = templateInfo.strScene;
                        if (set.add(Long.valueOf(rq))) {
                            arrayList.add(bw);
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private List<EffectInfoModel> m19296a(List<TemplateInfo> list, List<TemplateInfo> list2, Set<Long> set) {
        ArrayList arrayList = new ArrayList();
        int count = this.bOt.getCount();
        if (count == 0) {
            return arrayList;
        }
        for (int i = 0; i < count; i++) {
            EffectInfoModel vh = this.bOt.mo35214vh(i);
            if (vh != null && !vh.isbNeedDownload() && C8451b.m24479up(QTemplateIDUtils.getTemplateSubType(vh.mTemplateId))) {
                TemplateInfo a = m19294a(vh.mTemplateId, (List<TemplateInfo>[]) new List[]{list2, list});
                if (a != null && !a.isRecommendItem()) {
                    vh.mThumbUrl = a.strIcon;
                    vh.mName = a.strTitle;
                    vh.strSceneName = a.strScene;
                }
                if (set.add(Long.valueOf(vh.mTemplateId))) {
                    arrayList.add(vh);
                }
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public EffectInfoModel agV() {
        EffectInfoModel effectInfoModel = this.dcB.size() > 0 ? (EffectInfoModel) this.dcB.get(this.dcB.size() - 1) : null;
        return effectInfoModel == null ? apZ() : effectInfoModel;
    }

    private void alZ() {
        if (this.dcK == null) {
            this.dcK = new BroadcastReceiver() {
                public void onReceive(final Context context, final Intent intent) {
                    C6638d.this.compositeDisposable.mo9785e(C1487a.aUa().mo10058o(new Runnable() {
                        public void run() {
                            EffectInfoModel e = C6638d.this.agV();
                            if (e != null) {
                                if (IEditorService.RESULT_ACTION_THEME_APPLY_SUC.equals(intent.getAction())) {
                                    boolean booleanExtra = intent.getBooleanExtra("IS_STREAM_RESOL_UPDATED", false);
                                    C6638d.this.m19309ip(e.mPath);
                                    C8517b.m24647b(C6638d.this.cyD.adO(), C6638d.this.cyD.adQ(), context);
                                    if (C6638d.this.cyD.adS() != null) {
                                        C6638d.this.cyD.adS().mo34143b(C6638d.this.cyD.adO(), false);
                                    }
                                    C8540q.m24903L(C6638d.this.cyD.adO());
                                    C6638d.this.cyD.adQ().mo34305jl(true);
                                    C6638d.this.m19313y(booleanExtra, true);
                                } else {
                                    ((C6637c) C6638d.this.getMvpView()).apN();
                                }
                            }
                            C4586g.m11695Sl();
                        }
                    }));
                }
            };
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(IEditorService.RESULT_ACTION_THEME_APPLY_SUC);
            intentFilter.addAction(IEditorService.RESULT_ACTION_THEME_APPLY_FAIL);
            LocalBroadcastManager.getInstance(this.context).registerReceiver(this.dcK, intentFilter);
        }
    }

    private void apY() {
        C6293a anj = C6293a.anj();
        C66391 r1 = new C6296a() {
            /* renamed from: a */
            public void mo27778a(boolean z, C6307c cVar, C6307c cVar2, boolean z2) {
                if (!z) {
                    if (cVar instanceof C6308d) {
                        switch (C66499.dbS[cVar.anw().ordinal()]) {
                            case 1:
                                EffectInfoModel effectInfoModel = null;
                                if (cVar2 instanceof C6308d) {
                                    effectInfoModel = ((C6308d) cVar2).anx();
                                }
                                if (effectInfoModel == null) {
                                    effectInfoModel = C6638d.this.mo30015io(C6638d.this.cyD.adR().ail());
                                }
                                if (effectInfoModel == null) {
                                    effectInfoModel = C6638d.this.apZ();
                                }
                                if (effectInfoModel != null) {
                                    C6638d.this.m19309ip(effectInfoModel.mPath);
                                    C6638d.this.mo30016m(effectInfoModel);
                                    C6638d.this.m19313y(true, false);
                                    break;
                                }
                                break;
                            case 2:
                                if (C6638d.this.daT != null) {
                                    C6638d.this.daT.mo29687cH(0, 0);
                                    break;
                                }
                                break;
                        }
                    }
                } else if (cVar2 instanceof C6308d) {
                    switch (C66499.dbS[cVar2.anw().ordinal()]) {
                        case 1:
                            EffectInfoModel anx = ((C6308d) cVar2).anx();
                            if (anx == null) {
                                anx = C6638d.this.mo30015io(C6638d.this.cyD.adR().ail());
                            }
                            if (anx == null) {
                                anx = C6638d.this.apZ();
                            }
                            C6638d.this.m19309ip(anx.mPath);
                            C6638d.this.mo30016m(anx);
                            C6638d.this.m19313y(true, false);
                            break;
                        case 2:
                            if (C6638d.this.daT != null) {
                                C6638d.this.daT.mo29687cH(0, 0);
                                break;
                            }
                            break;
                    }
                }
            }
        };
        this.dcL = r1;
        anj.mo29234a((C6296a) r1);
    }

    /* access modifiers changed from: private */
    public EffectInfoModel apZ() {
        if (this.dcA == null) {
            this.dcA = mo30002aG(QStyle.NONE_THEME_TEMPLATE_ID);
        }
        return this.dcA;
    }

    private boolean aqb() {
        return this.dcD.size() > 0 || this.dcE.size() > 0;
    }

    private boolean aqf() {
        return C8540q.m24913V(this.cyD.adO()) && (((float) this.cyD.getSurfaceSize().width) * 1.0f) / ((float) this.cyD.getSurfaceSize().height) < 1.0f;
    }

    /* renamed from: fh */
    private void m19305fh(final Context context2) {
        if (C4599k.m11735dN(context2)) {
            C8670b.m25245a(C8399c.ecX, 100, 1, 3, 2, "").mo10196g(C1820a.aVi()).mo10194f(C1820a.aVi()).mo10188a((C1850u<? super T>) new C1850u<List<TemplateResponseInfo>>() {
                /* renamed from: a */
                public void mo9883a(C1495b bVar) {
                    C6638d.this.compositeDisposable.mo9785e(bVar);
                }

                public void onError(Throwable th) {
                    ((C6637c) C6638d.this.getMvpView()).mo29956gN(false);
                }

                public void onSuccess(List<TemplateResponseInfo> list) {
                    C8739i.m25524ho(context2);
                    C8735f.aMf().mo35147cz(context2, C8399c.ecX);
                    ((C6637c) C6638d.this.getMvpView()).mo29956gN(true);
                }
            });
        }
    }

    /* renamed from: h */
    private void m19308h(long j, int i) {
        ((C6637c) getMvpView()).mo29959h(j, i);
    }

    /* access modifiers changed from: private */
    /* renamed from: ip */
    public void m19309ip(String str) {
        this.dcz = str;
        C5843c.agO().mo28228e(mo30015io(str));
    }

    /* renamed from: n */
    private void m19310n(Long l) {
        if (l.longValue() > 0) {
            String by = C8759b.m25586by(l.longValue());
            if (!TextUtils.isEmpty(by)) {
                ((C6637c) getMvpView()).mo29960i(mo30015io(by));
            }
        }
    }

    /* renamed from: o */
    private boolean m19311o(EffectInfoModel effectInfoModel) {
        return C6386d.m18377iL(C8450a.m24469bn(effectInfoModel.mTemplateId).toLowerCase());
    }

    /* access modifiers changed from: private */
    /* renamed from: t */
    public void m19312t(Long l) {
        this.dbZ.remove(l.longValue());
        ((C6637c) getMvpView()).mo29961m(l);
        if (l.longValue() == this.bNB) {
            if (this.dcG == null || !this.dcG.isShowing()) {
                m19310n(l);
                this.bNB = -1;
            } else {
                this.bNB = -1;
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: y */
    public void m19313y(boolean z, boolean z2) {
        EffectInfoModel agV = agV();
        if (!m19311o(agV)) {
            ((C6637c) getMvpView()).apS();
        }
        C10021c.aZH().mo38492aA(new C6551b(agV.mTemplateId));
        ((C6637c) getMvpView()).apN();
        if (this.daT != null) {
            if (z) {
                this.daT.setAutoPlayWhenReady(z2);
                DataItemProject aHe = this.cyD.adK().aHe();
                if (aHe != null) {
                    MSize mSize = new MSize(aHe.streamWidth, aHe.streamHeight);
                    this.daT.mo29678a(new C6495l(13));
                    if (!this.daT.mo29688f(mSize)) {
                        this.daT.mo29687cH(0, 0);
                    }
                }
            } else {
                this.daT.mo29676a(0, new C6501c() {
                    /* renamed from: op */
                    public void mo29749op(int i) {
                        if (i == 0) {
                            C6638d.this.daT.mo29698og(0);
                        }
                    }
                }, z2);
            }
        }
    }

    /* renamed from: a */
    public void mo29998a(C5686a aVar, C6499a aVar2) {
        this.cyD = aVar;
        this.daT = aVar2;
        this.cwF = new TemplateConditionModel();
        if (!(this.cyD.adK() == null || this.cyD.adK().aHe() == null)) {
            boolean isMVPrj = this.cyD.adK().aHe().isMVPrj();
            this.cwF.mLayoutMode = QUtils.getLayoutMode(this.cyD.adK().aHe().streamWidth, this.cyD.adK().aHe().streamHeight);
            this.cwF.isPhoto = isMVPrj;
        }
        m19309ip(this.cyD.adR().ail());
        C8735f.aMf().mo35147cz(this.context.getApplicationContext(), C8399c.ecX);
        this.bOt = new C8759b(1);
        if (aqb()) {
            m19305fh(this.context.getApplicationContext());
        } else {
            C8739i.m25524ho(this.context.getApplicationContext());
        }
        this.bOW = new C8703d(this.context, this.csV);
        apY();
    }

    /* renamed from: a */
    public void attachView(C6637c cVar) {
        super.attachView(cVar);
    }

    /* renamed from: a */
    public void mo30000a(EffectInfoModel effectInfoModel, String str) {
        if (this.bOW != null) {
            this.bOW.mo35077a(effectInfoModel, str);
        }
    }

    /* renamed from: a */
    public void mo30001a(EffectInfoModel effectInfoModel, boolean z) {
        DataItemProject aHe = this.cyD.adK().aHe();
        if (aHe != null) {
            C4586g.m11703a((Context) ((C6637c) getMvpView()).getHostActivity(), R.string.xiaoying_str_com_loading, (OnCancelListener) null);
            mo30016m(effectInfoModel);
            EffectInfoModel agV = agV();
            this.daT.aoi();
            this.bNB = -1;
            C6308d any = new C6310a().mo29282e(C6312c.THEME_APPLY).mo29284f(agV.clone()).mo29285nJ(0).mo29283e(this.cyD.adK().aHf()).any();
            any.mo29276gc(z);
            C6293a.anj().mo29246b((C6307c) any);
            if (C8540q.m24900I(this.cyD.adO())) {
                C8540q.m24902K(this.cyD.adO());
            }
            alZ();
            StoryboardOpService.applyTheme(this.context, aHe.strPrjURL, effectInfoModel.mPath);
        }
    }

    /* renamed from: aG */
    public EffectInfoModel mo30002aG(long j) {
        EffectInfoModel effectInfoModel = null;
        if (this.dcC.size() == 0) {
            return null;
        }
        Iterator it = this.dcC.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            EffectInfoModel effectInfoModel2 = (EffectInfoModel) it.next();
            if (j == effectInfoModel2.mTemplateId) {
                effectInfoModel = effectInfoModel2;
                break;
            }
        }
        return effectInfoModel;
    }

    /* renamed from: aH */
    public void mo30003aH(long j) {
        this.dbZ.remove(j);
        m19308h(j, 2);
    }

    public String aqa() {
        return this.dcz;
    }

    public synchronized List<EffectInfoModel> aqc() {
        this.bOt.mo35198a(this.context, -1, this.cwF, AppStateModel.getInstance().isInChina());
        this.dcC.clear();
        this.dcD.clear();
        this.dcE.clear();
        this.dcF.clear();
        HashSet hashSet = new HashSet();
        long a = this.bOt.mo35194a(this.cwF);
        List qk = C8735f.aMf().mo35151qk(C8399c.ecX);
        List asI = C6375c.asF().asI();
        ArrayList arrayList = qk != null ? new ArrayList(qk) : new ArrayList();
        if (!arrayList.isEmpty() || !asI.isEmpty()) {
            this.dcD = m19295a((List<TemplateInfo>) arrayList, a, (Set<Long>) hashSet);
            this.dcE = m19295a(asI, a, (Set<Long>) hashSet);
        }
        this.dcF = m19296a((List<TemplateInfo>) arrayList, asI, (Set<Long>) hashSet);
        if (this.dcD != null) {
            this.dcC.addAll(this.dcD);
        }
        if (this.dcE != null) {
            this.dcC.addAll(this.dcE);
        }
        if (this.dcF != null) {
            this.dcC.addAll(this.dcF);
        }
        return this.dcC;
    }

    public List<EffectInfoModel> aqd() {
        return this.dcB;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.introvd.template.sdk.model.editor.EffectInfoModel aqe() {
        /*
            r4 = this;
            java.util.List<com.introvd.template.sdk.model.editor.EffectInfoModel> r0 = r4.dcB
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x0036
            java.util.List<com.introvd.template.sdk.model.editor.EffectInfoModel> r0 = r4.dcB
            int r0 = r0.size()
            int r0 = r0 + -1
        L_0x0010:
            if (r0 < 0) goto L_0x0036
            java.util.List<com.introvd.template.sdk.model.editor.EffectInfoModel> r1 = r4.dcB
            java.lang.Object r1 = r1.get(r0)
            com.introvd.template.sdk.model.editor.EffectInfoModel r1 = (com.introvd.template.sdk.model.editor.EffectInfoModel) r1
            if (r1 == 0) goto L_0x0033
            long r2 = r1.mTemplateId
            java.lang.String r2 = com.introvd.template.sdk.p391g.C8450a.m24469bn(r2)
            java.lang.String r2 = r2.toLowerCase()
            boolean r2 = com.introvd.template.editor.p266h.C6386d.m18377iL(r2)
            if (r2 != 0) goto L_0x0033
            boolean r2 = r1.isbNeedDownload()
            if (r2 != 0) goto L_0x0033
            goto L_0x0037
        L_0x0033:
            int r0 = r0 + -1
            goto L_0x0010
        L_0x0036:
            r1 = 0
        L_0x0037:
            if (r1 != 0) goto L_0x003d
            com.introvd.template.sdk.model.editor.EffectInfoModel r1 = r4.apZ()
        L_0x003d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.editor.preview.fragment.p274a.C6638d.aqe():com.introvd.template.sdk.model.editor.EffectInfoModel");
    }

    public boolean aqg() {
        return this.dcG != null && this.dcG.isShowing();
    }

    public void aqh() {
        if (aqg()) {
            this.dcG.onPause();
        }
    }

    public void aqi() {
        if (aqg()) {
            this.dcG.onResume();
        }
    }

    public void aqj() {
        this.bNB = 0;
    }

    public void aqk() {
        if (this.dcH != null) {
            mo30019p(this.dcH);
            C8739i.m25521b(this.context, Long.valueOf(this.dcH.mTemplateId));
            ToastUtils.show(this.context, this.context.getString(R.string.xiaoying_str_reward_video_ad_to_congrats_get), 1);
        }
    }

    /* renamed from: b */
    public void mo30013b(EffectInfoModel effectInfoModel, boolean z) {
        C7593c.m22383b("edit_theme", C7594d.dMB, new String[0]);
        if (this.dcG == null) {
            this.dcG = new C6687b(this.context);
        }
        this.dcG.mo30101c(C8739i.m25531w(Long.valueOf(effectInfoModel.mTemplateId)), Long.valueOf(effectInfoModel.mTemplateId));
        if (z) {
            this.dcG.mo30102oT(3);
            this.dcG.mo30100c(this.dcM);
        } else {
            boolean isAdAvailable = C7680l.aAe().isAdAvailable(this.context, 19);
            OnClickListener onClickListener = isAdAvailable ? this.dcN : this.dcM;
            this.dcG.mo30102oT(isAdAvailable ? 1 : 2);
            this.dcG.mo30100c(onClickListener);
        }
        this.dcG.show();
    }

    /* renamed from: d */
    public void mo30014d(long j, int i) {
        ((C6637c) getMvpView()).mo29954g(j, i);
    }

    public void detachView() {
        super.detachView();
    }

    /* renamed from: io */
    public EffectInfoModel mo30015io(String str) {
        EffectInfoModel effectInfoModel = null;
        if (TextUtils.isEmpty(str) || this.dcC.size() == 0) {
            return null;
        }
        Iterator it = this.dcC.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            EffectInfoModel effectInfoModel2 = (EffectInfoModel) it.next();
            if (str.equals(effectInfoModel2.mPath)) {
                effectInfoModel = effectInfoModel2;
                break;
            }
        }
        return effectInfoModel;
    }

    /* renamed from: m */
    public void mo30016m(EffectInfoModel effectInfoModel) {
        this.dcB.add(effectInfoModel);
    }

    /* renamed from: n */
    public boolean mo30017n(final EffectInfoModel effectInfoModel) {
        if (!aqf()) {
            return false;
        }
        if (this.dcJ != null && this.dcJ.isShowing()) {
            this.dcJ.dismiss();
            this.dcJ = null;
        }
        this.dcJ = C8978m.m26350ht(((C6637c) getMvpView()).getHostActivity()).mo10293dl(R.string.xiaoying_str_ve_edit_ratio_use_theme_dialog_title).mo10296do(R.string.xiaoying_str_ve_edit_ratio_use_theme_dialog_des).mo10288aA(true).mo10281a((C1904j) new C1904j() {
            public void onClick(C1890f fVar, C1885b bVar) {
                C6638d.this.mo30001a(effectInfoModel, false);
            }
        }).mo10313qu();
        this.dcJ.show();
        return true;
    }

    /* renamed from: oH */
    public void mo30018oH(int i) {
        if (aqg()) {
            this.dcG.mo30102oT(i);
        }
    }

    /* renamed from: p */
    public void mo30019p(EffectInfoModel effectInfoModel) {
        if (!BaseSocialNotify.isNetworkAvaliable(this.context)) {
            ToastUtils.show(this.context, R.string.xiaoying_str_com_msg_network_inactive, 0);
            return;
        }
        if (effectInfoModel != null) {
            this.bNB = effectInfoModel.mTemplateId;
            this.dcI.add(Long.valueOf(effectInfoModel.mTemplateId));
            if (C8762d.aMt().mo35228bE(effectInfoModel.mTemplateId)) {
                mo30000a(effectInfoModel, "theme");
                m19308h(effectInfoModel.mTemplateId, 1);
            } else if (C8735f.aMf().mo35154qo(C8450a.m24469bn(effectInfoModel.mTemplateId))) {
                m19308h(effectInfoModel.mTemplateId, 1);
            } else {
                m19312t(Long.valueOf(effectInfoModel.mTemplateId));
            }
        }
    }

    /* renamed from: q */
    public void mo30020q(EffectInfoModel effectInfoModel) {
        this.dcH = effectInfoModel;
    }

    public void release() {
        if (this.compositeDisposable != null) {
            this.compositeDisposable.clear();
        }
        if (this.dcK != null) {
            LocalBroadcastManager.getInstance(this.context).unregisterReceiver(this.dcK);
        }
        C6293a.anj().mo29244b(this.dcL);
        if (this.bOt != null) {
            this.bOt.unInit();
            this.bOt = null;
        }
        if (this.bOW != null) {
            this.bOW.mo35076VD();
        }
        if (aqg()) {
            this.dcG.dismiss();
            this.dcG = null;
        }
        if (this.dcJ != null && this.dcJ.isShowing()) {
            this.dcJ.dismiss();
            this.dcJ = null;
        }
    }
}
