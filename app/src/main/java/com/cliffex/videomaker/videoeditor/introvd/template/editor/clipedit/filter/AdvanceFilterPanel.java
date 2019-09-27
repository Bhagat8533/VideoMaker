package com.introvd.template.editor.clipedit.filter;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.p024v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import com.introvd.template.ads.entity.AdPositionInfoParam;
import com.introvd.template.ads.listener.VideoAdsListener;
import com.introvd.template.ads.listener.VideoRewardListener;
import com.introvd.template.common.UserBehaviorLog;
import com.introvd.template.common.model.AppStateModel;
import com.introvd.template.editor.R;
import com.introvd.template.editor.common.model.EffectInfo;
import com.introvd.template.module.iap.C8049f;
import com.introvd.template.module.iap.C8058h;
import com.introvd.template.module.iap.business.C7870d;
import com.introvd.template.module.iap.business.C7870d.C7873a;
import com.introvd.template.module.iap.business.p349a.C7825a;
import com.introvd.template.module.p326ad.p327a.C7589a;
import com.introvd.template.module.p326ad.p328b.C7593c;
import com.introvd.template.module.p326ad.p328b.C7594d;
import com.introvd.template.p203b.C4586g;
import com.introvd.template.p203b.C4600l;
import com.introvd.template.router.iap.IapRTConstants;
import com.introvd.template.router.template.TemplateRouter;
import com.introvd.template.sdk.model.TemplateConditionModel;
import com.introvd.template.sdk.model.editor.EffectInfoModel;
import com.introvd.template.sdk.model.editor.TemplateItemData;
import com.introvd.template.sdk.model.template.RollInfo;
import com.introvd.template.sdk.model.template.TemplateInfo;
import com.introvd.template.sdk.p383c.C8399c;
import com.introvd.template.template.p407e.C8739i;
import com.introvd.template.template.p409g.C8759b;
import com.introvd.template.template.p409g.C8762d;
import com.introvd.template.template.widget.p412a.C8928b;
import com.introvd.template.template.widget.p412a.C8928b.C8935a;
import com.introvd.template.template.widget.p412a.C8937c;
import com.introvd.template.template.widget.p412a.C8938d;
import com.introvd.template.template.widget.p412a.p413a.C8924d;
import com.introvd.template.template.widget.p412a.p413a.C8925e;
import com.introvd.template.template.widget.p412a.p413a.C8926f;
import com.introvd.template.template.widget.p412a.p413a.C8927g;
import com.p131c.p132a.p135c.C2575a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AdvanceFilterPanel extends RelativeLayout implements VideoAdsListener, VideoRewardListener {
    /* access modifiers changed from: private */
    public TemplateInfo bNP;
    /* access modifiers changed from: private */
    public C8759b bOt;
    /* access modifiers changed from: private */
    public C8928b bSS;
    /* access modifiers changed from: private */
    public C8937c bST;
    private ArrayList<C8927g> bSU;
    /* access modifiers changed from: private */
    public WeakReference<Activity> bwg;
    private RecyclerView cyR;
    /* access modifiers changed from: private */
    public String cyS;
    private long cyT = 0;
    /* access modifiers changed from: private */
    public C5697a cyU;
    /* access modifiers changed from: private */
    public C7870d cyV;
    /* access modifiers changed from: private */
    public boolean cyW = false;
    /* access modifiers changed from: private */
    public C5698b cyX = new C5698b(this);
    /* access modifiers changed from: private */
    public Context mContext;
    private int mLayoutMode = 0;

    /* renamed from: com.introvd.template.editor.clipedit.filter.AdvanceFilterPanel$a */
    public interface C5697a {
        void aeP();

        /* renamed from: b */
        void mo27911b(String str, boolean z, String str2);

        /* renamed from: i */
        void mo27912i(TemplateInfo templateInfo);
    }

    /* renamed from: com.introvd.template.editor.clipedit.filter.AdvanceFilterPanel$b */
    static class C5698b extends Handler {
        private WeakReference<AdvanceFilterPanel> cyZ;

        public C5698b(AdvanceFilterPanel advanceFilterPanel) {
            this.cyZ = new WeakReference<>(advanceFilterPanel);
        }

        public void handleMessage(Message message) {
            final AdvanceFilterPanel advanceFilterPanel = (AdvanceFilterPanel) this.cyZ.get();
            if (advanceFilterPanel != null) {
                switch (message.what) {
                    case 4097:
                        if (advanceFilterPanel.bOt != null) {
                            String str = (String) message.obj;
                            if (advanceFilterPanel.bSS != null) {
                                if (advanceFilterPanel.bOt.mo35208qC(str) == 0) {
                                    advanceFilterPanel.bSS.mo35564vs(0);
                                } else {
                                    advanceFilterPanel.bSS.mo35558bM(C8759b.m25587jf(str));
                                }
                            }
                            sendMessage(obtainMessage(4098, advanceFilterPanel.bOt.mo35208qC(str), 0));
                            break;
                        }
                        break;
                    case 4098:
                        int i = message.arg1;
                        if (advanceFilterPanel.bSS != null && i >= 0) {
                            advanceFilterPanel.bSS.mo35562vq(i);
                            break;
                        }
                    case 4099:
                        final Activity activity = (Activity) advanceFilterPanel.bwg.get();
                        if (activity != null) {
                            int i2 = message.arg1;
                            TemplateInfo templateInfo = (TemplateInfo) message.obj;
                            if (templateInfo != null && C4600l.m11739k(advanceFilterPanel.mContext, true)) {
                                if (i2 != 4) {
                                    if (C8739i.m25527qr(templateInfo.ttid)) {
                                        advanceFilterPanel.bNP = templateInfo;
                                        C4586g.m11710d(activity, TemplateRouter.RATE_UNLOCK_REQUEST_CODE, templateInfo.strTitle);
                                        break;
                                    }
                                } else if (!C8739i.m25526qq(templateInfo.ttid)) {
                                    if (!C8739i.m25527qr(templateInfo.ttid)) {
                                        C8058h aBf = C8049f.aBf();
                                        if (aBf != null) {
                                            advanceFilterPanel.bNP = templateInfo;
                                            if (!aBf.mo33101iL(templateInfo.ttid)) {
                                                if (advanceFilterPanel.bNP != null) {
                                                    advanceFilterPanel.m15721TS();
                                                    advanceFilterPanel.m15736eR(advanceFilterPanel.bNP.ttid);
                                                    break;
                                                }
                                            } else {
                                                if (C7589a.getAdView(advanceFilterPanel.mContext, 37) != null) {
                                                    aBf.mo33100g(advanceFilterPanel.mContext, 37, templateInfo.ttid);
                                                } else {
                                                    aBf.mo33097b(activity, "platinum", C7825a.ALL_TEMPLATE.getId(), "effects", IapRTConstants.REQUEST_CODE_FOR_VIP);
                                                }
                                                return;
                                            }
                                        } else {
                                            return;
                                        }
                                    } else {
                                        advanceFilterPanel.bNP = templateInfo;
                                        C4586g.m11710d(activity, TemplateRouter.RATE_UNLOCK_REQUEST_CODE, templateInfo.strTitle);
                                        return;
                                    }
                                } else {
                                    advanceFilterPanel.bNP = templateInfo;
                                    advanceFilterPanel.cyV.templateId = templateInfo.ttid;
                                    advanceFilterPanel.cyV.mo32790iE(C7589a.isAdAvailable(advanceFilterPanel.mContext, 19));
                                    advanceFilterPanel.cyV.mo32789a((C7873a) new C7873a() {
                                        /* renamed from: cl */
                                        public void mo24962cl(boolean z) {
                                            if (z) {
                                                C7589a.m22358a(activity, 19, advanceFilterPanel);
                                                return;
                                            }
                                            advanceFilterPanel.m15721TS();
                                            C8739i.m25523cC(advanceFilterPanel.mContext, advanceFilterPanel.bNP.ttid);
                                        }
                                    });
                                    advanceFilterPanel.cyV.show();
                                    return;
                                }
                            } else {
                                return;
                            }
                        } else {
                            return;
                        }
                        break;
                }
            }
        }
    }

    public AdvanceFilterPanel(Context context) {
        super(context);
        mo27897dp(context);
    }

    public AdvanceFilterPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        mo27897dp(context);
    }

    public AdvanceFilterPanel(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        mo27897dp(context);
    }

    /* access modifiers changed from: private */
    /* renamed from: TS */
    public void m15721TS() {
        if (this.bNP != null && TextUtils.equals(this.bNP.tcid, C8399c.ecY)) {
            if (TextUtils.isEmpty(this.bNP.strUrl) && (this.bNP instanceof RollInfo)) {
                this.bNP.strUrl = ((RollInfo) this.bNP).rollModel.rollDownUrl;
            }
            if (this.cyU != null) {
                this.cyU.mo27912i(this.bNP);
            }
        }
    }

    private void aeN() {
        if (this.bST != null) {
            this.bST.aMB();
            this.bST.mo35573qM("3");
            this.bSU = this.bST.aMC();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: am */
    public void m15728am(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("name", str);
        hashMap.put("ttid", str2);
        UserBehaviorLog.onKVEvent(this.mContext, "VE_Filter_Show", hashMap);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public String m15731b(C8925e eVar) {
        String str = null;
        if (eVar == null) {
            return null;
        }
        int aML = eVar.aML();
        if (this.bSU == null || aML < 0 || aML >= this.bSU.size()) {
            return null;
        }
        C8927g gVar = (C8927g) this.bSU.get(aML);
        if (gVar != null) {
            str = gVar.aMR();
        }
        return str;
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public String m15734d(C8926f fVar) {
        String str = null;
        if (fVar == null) {
            return null;
        }
        C8927g aMP = fVar.aMP();
        if (aMP != null) {
            str = aMP.aMR();
        }
        return str;
    }

    /* access modifiers changed from: private */
    /* renamed from: eR */
    public void m15736eR(String str) {
        if (this.bSS == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            this.bSS.aMw();
        } else {
            this.bSS.mo35560qJ(str);
        }
    }

    /* renamed from: eu */
    private void m15737eu(boolean z) {
        this.bST = C8937c.aMA();
        this.bSS = new C8928b(this.mContext);
        this.bSU = new ArrayList<>();
        setEffectMgr(this.bOt);
        aeN();
        if (!z || m15740gx(this.cyS)) {
            ((C8927g) this.bSU.get(1)).setSelected(false);
        }
        this.bSS.mo35552a(this.cyR, this.bSU, this.bOt);
        this.bSS.mo35553a((C8935a) new C8935a() {
            /* renamed from: Xs */
            public void mo25960Xs() {
                if (AdvanceFilterPanel.this.cyU != null) {
                    AdvanceFilterPanel.this.cyU.aeP();
                }
            }

            /* renamed from: a */
            public void mo25961a(C8925e eVar) {
                String a = AdvanceFilterPanel.this.m15731b(eVar);
                if (eVar != null && eVar.aMN() != null) {
                    String by = C8759b.m25586by(eVar.aMN().aMI());
                    if (AdvanceFilterPanel.this.cyS == null || !AdvanceFilterPanel.this.cyS.equals(by)) {
                        AdvanceFilterPanel.this.cyS = by;
                        if (AdvanceFilterPanel.this.cyU != null) {
                            AdvanceFilterPanel.this.cyU.mo27911b(by, false, a);
                        }
                    } else if (AdvanceFilterPanel.this.cyU != null) {
                        AdvanceFilterPanel.this.cyU.mo27911b(by, true, a);
                    }
                    AdvanceFilterPanel.this.m15728am(eVar.aMN().aMJ(), a);
                }
            }

            /* renamed from: a */
            public void mo25962a(C8926f fVar) {
                String a = AdvanceFilterPanel.this.m15734d(fVar);
                if (fVar.getPosition() == 1) {
                    AdvanceFilterPanel.this.cyS = AdvanceFilterPanel.this.bOt.mo35210qG(0);
                    if (AdvanceFilterPanel.this.cyU != null) {
                        AdvanceFilterPanel.this.cyU.mo27911b(AdvanceFilterPanel.this.bOt.mo35210qG(0), false, a);
                    }
                }
            }

            /* renamed from: b */
            public void mo25963b(C8926f fVar) {
                if (fVar != null && fVar.aMP() != null) {
                    String aMR = fVar.aMP().aMR();
                    Message obtainMessage = AdvanceFilterPanel.this.cyX.obtainMessage(4099, Integer.valueOf(C2575a.parseInt(C8399c.ecY)).intValue(), 0);
                    obtainMessage.obj = AdvanceFilterPanel.this.bST.mo35575qP(aMR);
                    AdvanceFilterPanel.this.cyX.sendMessage(obtainMessage);
                }
            }

            /* renamed from: c */
            public void mo25964c(C8926f fVar) {
                if (!(fVar == null || fVar.aMP() == null || AdvanceFilterPanel.this.cyU == null)) {
                    TemplateInfo qP = AdvanceFilterPanel.this.bST.mo35575qP(fVar.aMP().aMR());
                    if (qP instanceof RollInfo) {
                        qP.strUrl = ((RollInfo) qP).rollModel.rollDownUrl;
                    }
                    AdvanceFilterPanel.this.cyU.mo27912i(qP);
                }
            }

            /* renamed from: jy */
            public void mo25965jy(int i) {
                if (AdvanceFilterPanel.this.bSS != null && !AdvanceFilterPanel.this.cyW) {
                    AdvanceFilterPanel.this.bSS.mo35563vr(i);
                }
            }
        });
    }

    private TemplateConditionModel getFilterCond() {
        TemplateConditionModel templateConditionModel = new TemplateConditionModel();
        templateConditionModel.mLayoutMode = this.mLayoutMode;
        templateConditionModel.isPhoto = false;
        return templateConditionModel;
    }

    /* renamed from: gx */
    private boolean m15740gx(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        long jf = C8759b.m25587jf(str);
        if (this.bSU != null) {
            for (int i = 0; i < this.bSU.size(); i++) {
                C8927g gVar = (C8927g) this.bSU.get(i);
                if (!(gVar == null || gVar.getChildList() == null)) {
                    List childList = gVar.getChildList();
                    for (int i2 = 0; i2 < childList.size(); i2++) {
                        if (jf == ((C8924d) childList.get(i2)).aMI()) {
                            return true;
                        }
                    }
                    continue;
                }
            }
        }
        return false;
    }

    /* renamed from: gz */
    private ArrayList<EffectInfo> m15741gz(String str) {
        ArrayList<EffectInfo> arrayList = new ArrayList<>();
        TemplateItemData bD = C8762d.aMt().mo35227bD(C8762d.aMt().getTemplateID(str));
        if (bD == null || bD.nConfigureCount <= 1) {
            EffectInfo effectInfo = new EffectInfo(str);
            effectInfo.mChildIndex = 0;
            arrayList.add(effectInfo);
            return arrayList;
        }
        int i = bD.nConfigureCount;
        for (int i2 = 0; i2 < i; i2++) {
            EffectInfo effectInfo2 = new EffectInfo(str);
            effectInfo2.mChildIndex = i2;
            arrayList.add(effectInfo2);
        }
        return arrayList;
    }

    /* renamed from: a */
    public void mo27894a(Activity activity, long j, int i, String str, boolean z) {
        this.bwg = new WeakReference<>(activity);
        this.cyT = j;
        this.mLayoutMode = i;
        this.cyS = str;
        C7593c.m22383b("edit_filter", C7594d.dMB, new String[0]);
        this.cyV = new C7870d(this.mContext);
        this.bOt = new C8759b(4);
        this.bOt.mo35198a(this.mContext, this.cyT, getFilterCond(), AppStateModel.getInstance().isInChina());
        m15737eu(z);
    }

    public boolean aeO() {
        return this.cyW;
    }

    /* renamed from: de */
    public void mo27896de(boolean z) {
        if (this.bSU != null && this.bSU.size() > 0) {
            if (this.bSU.size() > 2 && ((C8927g) this.bSU.get(2)).aMU() == C8938d.SINGLE) {
                this.bSU.remove(2);
            }
            this.bSS.mo35557b(this.bOt);
            this.bSS.mo35559e(this.bSU, z);
        }
    }

    /* renamed from: dp */
    public void mo27897dp(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(R.layout.editor_filter_panel_layout, this, true);
        this.cyR = (RecyclerView) findViewById(R.id.rc_editor_filter);
    }

    /* renamed from: e */
    public void mo27898e(long j, int i) {
        if (this.bSS != null) {
            this.bSS.mo35551S(String.valueOf(j), i);
        }
    }

    /* renamed from: ev */
    public void mo27899ev(boolean z) {
        if (this.bOt != null) {
            this.bOt.mo35198a(this.mContext, this.cyT, getFilterCond(), AppStateModel.getInstance().isInChina());
            setEffectMgr(this.bOt);
            aeN();
            mo27896de(z);
        }
    }

    /* renamed from: gA */
    public void mo27900gA(String str) {
        this.cyS = str;
        if (this.cyX != null) {
            this.cyX.removeMessages(4097);
            this.cyX.sendMessageDelayed(this.cyX.obtainMessage(4097, str), 50);
        }
    }

    public String getCurrEffectPath() {
        return this.cyS;
    }

    public ArrayList<EffectInfo> getEffectPathList() {
        ArrayList<EffectInfo> arrayList = new ArrayList<>();
        int count = this.bOt.getCount();
        for (int i = 1; i < count; i++) {
            String qG = this.bOt.mo35210qG(i);
            if (!TextUtils.isEmpty(qG)) {
                EffectInfoModel vh = this.bOt.mo35214vh(i);
                if (vh != null && !vh.isbNeedDownload()) {
                    ArrayList gz = m15741gz(qG);
                    if (gz != null) {
                        arrayList.addAll(gz);
                    }
                }
            }
        }
        return arrayList;
    }

    public C8759b getOwnEffectMgr() {
        return this.bOt;
    }

    /* renamed from: gy */
    public void mo27904gy(String str) {
        if (C8937c.m26266cO(this.mContext, str) != 2) {
            Message obtainMessage = this.cyX.obtainMessage(4099, Integer.valueOf(C2575a.parseInt(C8399c.ecY)).intValue(), 0);
            obtainMessage.obj = this.bST.mo35575qP(str);
            this.cyX.sendMessage(obtainMessage);
        } else if (C8937c.m26270qR(str) != 2) {
            if (this.cyU != null) {
                TemplateInfo qP = this.bST.mo35575qP(str);
                if (qP instanceof RollInfo) {
                    qP.strUrl = ((RollInfo) qP).rollModel.rollDownUrl;
                }
                this.cyU.mo27912i(qP);
            }
        } else {
            if (this.bSS != null) {
                this.bSS.mo35561qL(str);
            }
        }
    }

    /* renamed from: i */
    public void mo27905i(String str, boolean z) {
        if (this.cyX == null) {
            return;
        }
        if (z) {
            this.cyX.sendMessage(this.cyX.obtainMessage(4097, str));
        } else {
            this.cyX.sendMessage(this.cyX.obtainMessage(4098, this.bOt.mo35208qC(str), 0));
        }
    }

    public void onAdLoaded(AdPositionInfoParam adPositionInfoParam, boolean z, String str) {
    }

    public void onShowVideoAd(AdPositionInfoParam adPositionInfoParam, boolean z) {
    }

    public void setCurrEffectPath(String str) {
        this.cyS = str;
    }

    public void setEffectMgr(C8759b bVar) {
        this.bOt = bVar;
        if (this.bST != null) {
            this.bST.setEffectMgr(bVar);
        }
        if (this.bSS != null) {
            this.bSS.mo35557b(bVar);
        }
    }

    public void setFilterPanelListener(C5697a aVar) {
        this.cyU = aVar;
    }

    public void setInStore(boolean z) {
        this.cyW = z;
    }
}
