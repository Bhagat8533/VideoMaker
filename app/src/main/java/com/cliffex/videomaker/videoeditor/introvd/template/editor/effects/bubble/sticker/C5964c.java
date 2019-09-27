package com.introvd.template.editor.effects.bubble.sticker;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.support.p024v7.widget.LinearLayoutManager;
import android.support.p024v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.introvd.template.common.model.AppStateModel;
import com.introvd.template.common.other.WeakHandler;
import com.introvd.template.editor.R;
import com.introvd.template.editor.effects.bubble.p255a.C5919a;
import com.introvd.template.editor.effects.bubble.p255a.C5930d;
import com.introvd.template.editor.effects.bubble.p255a.C5934e;
import com.introvd.template.editor.effects.bubble.p255a.C5934e.C5936a;
import com.introvd.template.editor.effects.bubble.p255a.C5938f;
import com.introvd.template.editor.effects.bubble.p255a.C5938f.C5940a;
import com.introvd.template.editor.effects.bubble.subtitle.C6016e;
import com.introvd.template.editor.p259f.C6281c;
import com.introvd.template.editor.p266h.C6375c;
import com.introvd.template.p203b.C4562a;
import com.introvd.template.p203b.C4580b;
import com.introvd.template.p203b.C4600l;
import com.introvd.template.router.todoCode.TodoConstants;
import com.introvd.template.sdk.model.TemplateConditionModel;
import com.introvd.template.sdk.model.editor.EffectInfoModel;
import com.introvd.template.sdk.model.editor.StoryBoardItemInfo;
import com.introvd.template.sdk.model.template.RollInfo;
import com.introvd.template.sdk.model.template.TemplateInfo;
import com.introvd.template.sdk.p383c.C8399c;
import com.introvd.template.sdk.utils.p394b.C8539p;
import com.introvd.template.template.model.StyleCatItemModel;
import com.introvd.template.template.model.TemplatePackageInfo;
import com.introvd.template.template.p404d.C8651b;
import com.introvd.template.template.p404d.C8653d;
import com.introvd.template.template.p404d.C8655f;
import com.introvd.template.template.p407e.C8735f;
import com.introvd.template.template.p407e.C8738h;
import com.introvd.template.template.p407e.C8742k;
import com.introvd.template.template.p407e.C8744m;
import com.introvd.template.template.p408f.C8746a;
import com.introvd.template.template.p408f.C8750d;
import com.introvd.template.template.p409g.C8759b;
import com.introvd.template.template.p409g.C8762d;
import com.p131c.p132a.C2561a;
import com.p131c.p132a.p135c.C2575a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import p037b.p050b.C1848s;
import p037b.p050b.C1850u;
import p037b.p050b.p051a.p053b.C1487a;
import p037b.p050b.p057e.C1518f;
import p037b.p050b.p073g.C1810c;
import p037b.p050b.p076j.C1820a;
import xiaoying.engine.QEngine;

/* renamed from: com.introvd.template.editor.effects.bubble.sticker.c */
public class C5964c {
    OnClickListener acD = new OnClickListener() {
        public void onClick(View view) {
            if (!C4580b.m11632Sf()) {
                if (view.equals(C5964c.this.cwP)) {
                    if (C5964c.this.cHq != null) {
                        C5964c.this.cHq.ace();
                    }
                } else if (view.equals(C5964c.this.cHk) && C5964c.this.cHq != null) {
                    C5964c.this.cHq.acg();
                }
            }
        }
    };
    /* access modifiers changed from: private */
    public QEngine bPS;
    private RelativeLayout bWd;
    private RelativeLayout cHj;
    /* access modifiers changed from: private */
    public TextView cHk;
    private C5938f cHl;
    private RecyclerView cHm;
    /* access modifiers changed from: private */
    public C5934e cHn = null;
    /* access modifiers changed from: private */
    public C5930d cHo;
    private C5919a cHp;
    /* access modifiers changed from: private */
    public C5962a cHq;
    private C5940a cHr = new C5940a() {
        /* renamed from: z */
        public void mo28568z(View view, int i) {
            C5964c.this.m16793mw(i);
        }
    };
    private C5936a cHs = new C5936a() {
        /* renamed from: z */
        public void mo28560z(View view, int i) {
            if (!C4580b.m11632Sf() && C5964c.this.cwK != null && C5964c.this.cwG != null && i != C5964c.this.cxa && i < C5964c.this.cwG.size()) {
                StoryBoardItemInfo storyBoardItemInfo = (StoryBoardItemInfo) C5964c.this.cwG.get(i);
                if (storyBoardItemInfo != null && storyBoardItemInfo.mEffectInfo != null) {
                    EffectInfoModel effectInfoModel = storyBoardItemInfo.mEffectInfo;
                    if (effectInfoModel.isbNeedDownload()) {
                        if (C5964c.this.cHq != null) {
                            C5964c.this.cHq.mo28589b(effectInfoModel);
                        }
                        return;
                    }
                    if (C5964c.this.cHn != null) {
                        C5964c.this.cHn.mo28558kP(i);
                        C5964c.this.cHn.notifyItemChanged(i, "");
                    }
                    if (storyBoardItemInfo.mEffectInfo != null) {
                        C5964c.this.cxc = "";
                        if (C5964c.this.cww != null) {
                            C5964c.this.cwZ = C5964c.this.cww.mo35205bx(storyBoardItemInfo.mEffectInfo.mTemplateId);
                            if (C5964c.this.cwZ < 0) {
                                C5964c.this.cxc = storyBoardItemInfo.mEffectInfo.mPath;
                            }
                        }
                    }
                    C5964c.this.cxa = i;
                    String o = C5964c.this.adr();
                    if (o == null) {
                        o = C5964c.this.cxc;
                    }
                    if (C5964c.this.cHq != null) {
                        C5964c.this.cHq.mo28590gY(o);
                    }
                }
            }
        }
    };
    private C6281c cHt = new C6281c() {
        /* renamed from: c */
        public void mo28635c(int i, Object obj) {
            if (!C4580b.m11632Sf() && i != C5964c.this.cxa && C5964c.this.cwK != null) {
                C5964c.this.cxc = "";
                TemplateInfo templateInfo = (TemplateInfo) obj;
                if (templateInfo != null) {
                    EffectInfoModel effectInfoModel = new EffectInfoModel();
                    effectInfoModel.mTemplateId = C2575a.m7391rq(templateInfo.ttid);
                    effectInfoModel.setmUrl(templateInfo.strUrl);
                    effectInfoModel.mName = templateInfo.strTitle;
                    if (C5964c.this.cHo != null) {
                        C5964c.this.cHo.mo28550gf(templateInfo.ttid);
                        C5964c.this.cHo.notifyDataSetChanged();
                    }
                    if (C5964c.this.cww != null) {
                        C5964c.this.cwZ = C5964c.this.cww.mo35205bx(effectInfoModel.mTemplateId);
                    }
                    C5964c.this.cxa = i;
                    String o = C5964c.this.adr();
                    if (o == null) {
                        o = C5964c.this.cxc;
                    }
                    if (C5964c.this.cHq != null) {
                        C5964c.this.cHq.mo28590gY(o);
                    }
                }
            }
        }

        /* renamed from: d */
        public void mo28636d(int i, Object obj) {
        }

        /* renamed from: e */
        public boolean mo28637e(int i, Object obj) {
            if (!C4600l.m11739k(C5964c.this.mContext, true)) {
                return false;
            }
            TemplateInfo templateInfo = (TemplateInfo) obj;
            if (templateInfo != null) {
                EffectInfoModel effectInfoModel = new EffectInfoModel();
                effectInfoModel.mTemplateId = C2575a.m7391rq(templateInfo.ttid);
                effectInfoModel.setmUrl(templateInfo.strUrl);
                effectInfoModel.mName = templateInfo.strTitle;
                if (C5964c.this.cHq != null) {
                    C5964c.this.cHq.mo28589b(effectInfoModel);
                }
                C5964c.this.mo28609a(templateInfo, i);
            }
            return true;
        }
    };
    private String cwD = "";
    private TemplateConditionModel cwF;
    /* access modifiers changed from: private */
    public ArrayList<StoryBoardItemInfo> cwG;
    private List<TemplateInfo> cwH = new ArrayList();
    /* access modifiers changed from: private */
    public RecyclerView cwK;
    /* access modifiers changed from: private */
    public RelativeLayout cwP;
    /* access modifiers changed from: private */
    public List<TemplateInfo> cwR;
    /* access modifiers changed from: private */
    public List<TemplateInfo> cwS;
    private List<TemplatePackageInfo> cwT;
    private Map<String, List<Long>> cwU;
    /* access modifiers changed from: private */
    public ArrayList<StyleCatItemModel> cwV;
    private C8738h cwX = new C8738h();
    /* access modifiers changed from: private */
    public int cwZ = -1;
    /* access modifiers changed from: private */
    public C8759b cww = new C8759b(5);
    private String cwy = "";
    /* access modifiers changed from: private */
    public int cxa = -1;
    /* access modifiers changed from: private */
    public int cxb = -1;
    /* access modifiers changed from: private */
    public String cxc = null;
    private OnClickListener cxj = new OnClickListener() {
        public void onClick(View view) {
            TemplateInfo a = C8762d.m25613a(C5964c.this.m16789kT(C5964c.this.cxb), (List<TemplateInfo>[]) new List[]{C5964c.this.cwS, C5964c.this.cwR});
            if (C5964c.this.cHq != null && a != null) {
                C5964c.this.cHq.mo28586a((RollInfo) a);
            }
        }
    };
    private ExecutorService executorService = Executors.newSingleThreadExecutor();
    /* access modifiers changed from: private */
    public Context mContext;
    /* access modifiers changed from: private */
    public Handler mHandler = new C5976a(this);

    /* renamed from: com.introvd.template.editor.effects.bubble.sticker.c$a */
    private static class C5976a extends WeakHandler<C5964c> {
        public C5976a(C5964c cVar) {
            super(cVar);
        }

        public void handleMessage(Message message) {
            C5964c cVar = (C5964c) getOwner();
            if (cVar != null) {
                int i = message.what;
                if (i == 10002) {
                    cVar.ajy();
                } else if (i == 10005 && cVar.cHn != null) {
                    cVar.cHn.notifyItemChanged(message.arg1);
                }
            }
        }
    }

    public C5964c(RelativeLayout relativeLayout, TemplateConditionModel templateConditionModel, QEngine qEngine) {
        this.bWd = relativeLayout;
        this.mContext = this.bWd.getContext();
        this.cwF = templateConditionModel;
        this.bPS = qEngine;
        this.cww.mo35198a(this.mContext, -1, templateConditionModel, AppStateModel.getInstance().isInChina());
        initUI();
    }

    /* renamed from: a */
    private void m16770a(final List<StoryBoardItemInfo> list, final C8651b bVar) {
        if (this.executorService != null && !this.executorService.isShutdown()) {
            this.executorService.execute(new Runnable() {
                public void run() {
                    for (int i = 0; i < list.size(); i++) {
                        StoryBoardItemInfo storyBoardItemInfo = (StoryBoardItemInfo) list.get(i);
                        if (storyBoardItemInfo.bmpThumbnail == null) {
                            float f = (float) 80;
                            Bitmap a = C8539p.m24891a(storyBoardItemInfo.mEffectInfo.mPath, 0, f, f, C5964c.this.bPS);
                            if (a != null && C5964c.this.cxb >= 0 && C5964c.this.cxb < C5964c.this.cwV.size()) {
                                if ("Giphy".equals(C5964c.this.m16789kT(C5964c.this.cxb))) {
                                    storyBoardItemInfo.bmpThumbnail = a;
                                    if (bVar != null) {
                                        bVar.mo27628cm(i, 10);
                                    }
                                } else {
                                    return;
                                }
                            }
                        }
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void adJ() {
        this.cwV = new ArrayList<>();
        if (C8655f.aKE().aKF()) {
            this.cwV.add(0, new StyleCatItemModel(2, "Giphy", "Giphy"));
        }
        if (!C6016e.cHL) {
            this.cwT = C8742k.aMi().mo35177cG(this.mContext, "cover_sticker");
            for (TemplatePackageInfo templatePackageInfo : this.cwT) {
                this.cwV.add(new StyleCatItemModel(0, templatePackageInfo.strGroupCode, templatePackageInfo.strTitle));
            }
        }
        if (this.cwX.mo35167hh(this.mContext) > 0) {
            this.cwV.add(new StyleCatItemModel(1, "sticker_test/", "sticker_test/"));
        }
        this.cwR = C8735f.aMf().mo35151qk(C8399c.ede);
        this.cwS = C6375c.asF().asO();
        List b = C8746a.m25568b(this.cwS, false, false);
        if (C2561a.aOR() == 1 || C2561a.aON()) {
            StyleCatItemModel styleCatItemModel = new StyleCatItemModel(1, "20160224184733", C8744m.m25555qu("20160224184733"));
            if (!b.contains(styleCatItemModel)) {
                this.cwV.add(styleCatItemModel);
            }
        }
        this.cwV.addAll(b);
        List b2 = C8746a.m25568b(this.cwR, true, false);
        b2.removeAll(b);
        this.cwV.addAll(b2);
        this.cwU = new HashMap();
        if (C2561a.aOR() == 1 || C2561a.aON()) {
            this.cwU.put("20160224184733", C8744m.etu);
        }
        Iterator it = this.cwV.iterator();
        while (it.hasNext()) {
            StyleCatItemModel styleCatItemModel2 = (StyleCatItemModel) it.next();
            if (styleCatItemModel2.type == 0) {
                m16773b(this.cwU, styleCatItemModel2.ttid);
            } else if (styleCatItemModel2.type == 1) {
                if ("sticker_test/".equals(styleCatItemModel2.ttid)) {
                    this.cwU.put("sticker_test/", this.cwX.mo35172hm(this.mContext));
                } else {
                    C8746a.m25570c(this.cwU, styleCatItemModel2.ttid);
                }
            }
        }
    }

    private void adh() {
        if (this.cww != null) {
            this.cwZ = this.cww.mo35208qC(this.cwD);
            if (this.cwZ < 0) {
                this.cxc = this.cwD;
            }
        }
    }

    /* access modifiers changed from: private */
    public void adi() {
        if (this.cwV != null) {
            if (!C6016e.cHL && this.cwV.size() > 0) {
                Iterator it = this.cwV.iterator();
                while (it.hasNext()) {
                    StyleCatItemModel styleCatItemModel = (StyleCatItemModel) it.next();
                    if (styleCatItemModel.type == 0) {
                        styleCatItemModel.strPath = C8746a.m25565a(this.cwT, styleCatItemModel.ttid, styleCatItemModel.strPath);
                    }
                }
            }
            if (this.cHl != null) {
                this.cHl.mItemInfoList = this.cwV;
            } else {
                this.cHl = new C5938f(this.mContext, this.cwV, false);
            }
            this.cHm.setAdapter(this.cHl);
            this.cHl.mo28562a(this.cHr);
            this.cHo.mo28548a(this.cHt);
        }
    }

    /* access modifiers changed from: private */
    public String adr() {
        int i = this.cwZ;
        return i < 0 ? this.cxc : this.cww.mo35210qG(i);
    }

    private void adt() {
        int i = 0;
        if (C8746a.etx == null || C8746a.etx.size() < 1) {
            if (C8746a.etx == null) {
                C8746a.etx = new ArrayList<>();
            }
            String[] aKG = C8655f.aKE().aKG();
            if (aKG != null) {
                int length = aKG.length;
                int i2 = 0;
                while (i < length) {
                    StoryBoardItemInfo qy = C8750d.m25574qy(aKG[i]);
                    if (qy.mEffectInfo != null && TextUtils.equals(this.cxc, qy.mEffectInfo.mPath)) {
                        this.cxa = i2;
                    }
                    C8746a.etx.add(qy);
                    i2++;
                    i++;
                }
            }
        } else {
            Iterator it = C8746a.etx.iterator();
            while (it.hasNext()) {
                StoryBoardItemInfo storyBoardItemInfo = (StoryBoardItemInfo) it.next();
                if (storyBoardItemInfo.mEffectInfo != null && TextUtils.equals(this.cxc, storyBoardItemInfo.mEffectInfo.mPath)) {
                    this.cxa = i;
                }
                i++;
            }
        }
        m16770a((List<StoryBoardItemInfo>) C8746a.etx, (C8651b) new C8651b() {
            /* renamed from: a */
            public void mo27626a(C8653d dVar) {
            }

            /* renamed from: aG */
            public void mo27627aG(List<C8653d> list) {
            }

            /* renamed from: cm */
            public void mo27628cm(int i, int i2) {
                if (C5964c.this.mHandler != null) {
                    Message obtainMessage = C5964c.this.mHandler.obtainMessage(10005);
                    obtainMessage.arg1 = i;
                    obtainMessage.arg2 = i2;
                    C5964c.this.mHandler.sendMessage(obtainMessage);
                }
            }
        });
        this.cwG.clear();
        this.cwG.addAll(C8746a.etx);
    }

    /* access modifiers changed from: private */
    public void ajx() {
        if (this.cwK != null) {
            if (this.cwG == null) {
                this.cwG = new ArrayList<>();
            } else {
                this.cwG.clear();
            }
            this.cxa = -1;
            if (this.cHo != null) {
                this.cHo.mo28550gf("");
                this.cHo.notifyDataSetChanged();
            }
            if (this.cwV == null || this.cxb < 0 || this.cxb >= this.cwV.size()) {
                m16793mw(1);
            } else {
                StyleCatItemModel styleCatItemModel = (StyleCatItemModel) this.cwV.get(this.cxb);
                if (styleCatItemModel != null) {
                    String kT = m16789kT(this.cxb);
                    if (styleCatItemModel.type == 2) {
                        adt();
                        this.cwK.setAdapter(this.cHn);
                        this.cHn.mo28557h(this.cwG);
                        this.cHn.mo28558kP(this.cxa);
                        this.cHn.mo28554a(this.cHs);
                        if (this.cxa >= 0) {
                            this.cwK.smoothScrollToPosition(this.cxa);
                        }
                    } else if (styleCatItemModel.type == 0) {
                        this.cwK.setAdapter(this.cHo);
                        m16792mv(this.cxb);
                    } else if (styleCatItemModel.type == 1) {
                        List<Long> list = (List) this.cwU.get(kT);
                        if (this.cww == null || list == null || list.size() <= 0) {
                            C8746a.m25567a(this.cwG, this.cwR, this.cwS, kT);
                        } else {
                            int i = 0;
                            for (Long l : list) {
                                StoryBoardItemInfo storyBoardItemInfo = new StoryBoardItemInfo();
                                storyBoardItemInfo.mEffectInfo = this.cww.mo35204bw(l.longValue());
                                storyBoardItemInfo.isVideo = false;
                                storyBoardItemInfo.lDuration = 0;
                                this.cwG.add(storyBoardItemInfo);
                                if (storyBoardItemInfo.mEffectInfo != null && TextUtils.equals(this.cww.mo35210qG(this.cwZ), storyBoardItemInfo.mEffectInfo.mPath) && this.cwZ >= 0) {
                                    this.cxa = i;
                                }
                                i++;
                            }
                        }
                        this.cwK.setAdapter(this.cHn);
                        this.cHn.mo28557h(this.cwG);
                        this.cHn.mo28558kP(this.cxa);
                        this.cHn.mo28554a(this.cHs);
                        if (this.cxa >= 0) {
                            this.cwK.scrollToPosition(this.cxa);
                        }
                    }
                }
            }
        }
    }

    /* renamed from: b */
    private void m16773b(Map<String, List<Long>> map, String str) {
        C8742k.aMi().mo35178cz(this.mContext, str);
        List<TemplateInfo> qt = C8742k.aMi().mo35183qt(str);
        if (qt != null && !qt.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (TemplateInfo templateInfo : qt) {
                arrayList.add(Long.valueOf(C2575a.m7391rq(templateInfo.ttid)));
            }
            map.put(str, arrayList);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: fi */
    public void m16780fi(boolean z) {
        if (this.cww != null && this.cwV != null) {
            if (z || this.cxb == -1) {
                EffectInfoModel vh = this.cww.mo35214vh(this.cwZ);
                if (vh == null && !TextUtils.isEmpty(this.cxc)) {
                    this.cxb = 0;
                } else if (vh != null) {
                    this.cxb = C8746a.m25564a(vh.mTemplateId, (List<StyleCatItemModel>) this.cwV, this.cwU);
                } else {
                    this.cxb = 0;
                }
            }
            String kT = m16789kT(this.cxb);
            if (m16782gp(kT)) {
                this.cHp.ack();
            } else {
                m16784hd(kT);
            }
            this.cHm.scrollToPosition(this.cxb);
            this.cHl.mo28566kP(this.cxb);
        }
    }

    /* renamed from: gp */
    private boolean m16782gp(String str) {
        if (this.cwT == null || this.cwT.isEmpty()) {
            return false;
        }
        for (TemplatePackageInfo templatePackageInfo : this.cwT) {
            if (templatePackageInfo.strGroupCode.equals(str)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: hd */
    private void m16784hd(String str) {
        this.cHp.mo28526a(this.mContext, false, C8762d.m25613a(str, (List<TemplateInfo>[]) new List[]{this.cwS, this.cwR}), str);
    }

    /* renamed from: he */
    private int m16785he(String str) {
        if (this.cwV == null || this.cwV.isEmpty() || TextUtils.isEmpty(str)) {
            return 0;
        }
        for (int i = 0; i < this.cwV.size(); i++) {
            StyleCatItemModel styleCatItemModel = (StyleCatItemModel) this.cwV.get(i);
            if (styleCatItemModel != null && str.equals(styleCatItemModel.ttid)) {
                return i;
            }
        }
        return 0;
    }

    private void initUI() {
        this.cHj = (RelativeLayout) this.bWd.findViewById(R.id.rl_sticker_list);
        this.cwP = (RelativeLayout) this.bWd.findViewById(R.id.rl_layout_downloaded);
        this.cHk = (TextView) this.bWd.findViewById(R.id.ib_giphy_download);
        this.cwP.setOnClickListener(this.acD);
        this.cHk.setOnClickListener(this.acD);
        this.cHm = (RecyclerView) this.bWd.findViewById(R.id.rv_bubble_tab);
        this.cwK = (RecyclerView) this.bWd.findViewById(R.id.recycler_view_package);
        this.cwK.setLayoutManager(new LinearLayoutManager(this.mContext, 0, false));
        this.cHo = new C5930d(this.mContext);
        this.cHn = new C5934e(this.mContext);
        if (this.cHm != null) {
            this.cHm.setLayoutManager(new LinearLayoutManager(this.mContext, 0, false));
            LayoutParams layoutParams = (LayoutParams) this.cHm.getLayoutParams();
            layoutParams.addRule(0, R.id.layout_giphy);
            this.cHm.setLayoutParams(layoutParams);
        }
        this.cHp = new C5919a((RelativeLayout) this.bWd.findViewById(R.id.relative_layout_roll_download), this.cxj);
    }

    /* access modifiers changed from: private */
    /* renamed from: kT */
    public String m16789kT(int i) {
        if (this.cwV == null || this.cwV.isEmpty() || i < 0 || i >= this.cwV.size()) {
            return "";
        }
        StyleCatItemModel styleCatItemModel = (StyleCatItemModel) this.cwV.get(i);
        return styleCatItemModel != null ? styleCatItemModel.ttid : "";
    }

    /* renamed from: mv */
    private void m16792mv(int i) {
        if (this.cHo != null) {
            this.cwH.clear();
            this.cHo.mo28549ay(this.cwH);
            this.cHo.notifyDataSetChanged();
        }
        this.cwT = C8742k.aMi().mo35177cG(this.mContext, "cover_sticker");
        if (C8655f.aKE().aKF()) {
            i--;
        }
        if (i >= 0 && i < this.cwT.size()) {
            TemplatePackageInfo templatePackageInfo = (TemplatePackageInfo) this.cwT.get(i);
            if (templatePackageInfo != null) {
                C8742k.aMi().mo35178cz(this.mContext, templatePackageInfo.strGroupCode);
                this.cwH = C8742k.aMi().mo35183qt(templatePackageInfo.strGroupCode);
                if (!(this.cwH == null || this.cwH.size() <= 0 || this.cHo == null)) {
                    this.cHo.mo28549ay(this.cwH);
                    this.cHo.notifyDataSetChanged();
                    int i2 = 0;
                    for (TemplateInfo templateInfo : this.cwH) {
                        if (templateInfo != null) {
                            EffectInfoModel bw = this.cww.mo35204bw(C2575a.m7391rq(templateInfo.ttid));
                            if (bw != null && TextUtils.equals(this.cww.mo35210qG(this.cwZ), bw.mPath) && this.cwZ >= 0) {
                                this.cxa = i2;
                                if (this.cHo != null) {
                                    this.cHo.mo28550gf(templateInfo.ttid);
                                    this.cHo.notifyDataSetChanged();
                                    this.cwK.smoothScrollToPosition(this.cxa);
                                }
                            }
                            i2++;
                        }
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: mw */
    public void m16793mw(int i) {
        if (this.cHl != null && this.cHl.mItemInfoList != null && i <= this.cHl.mItemInfoList.size() - 1) {
            this.cxb = i;
            if (this.cHl != null) {
                this.cHl.mo28566kP(this.cxb);
            }
            ajx();
            if (this.cxb < this.cwV.size()) {
                StyleCatItemModel styleCatItemModel = (StyleCatItemModel) this.cwV.get(this.cxb);
                if (styleCatItemModel != null) {
                    if (styleCatItemModel.type == 0 || styleCatItemModel.type == 2) {
                        this.cHp.ack();
                    } else if (styleCatItemModel.type == 1) {
                        m16784hd(m16789kT(this.cxb));
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public void mo28608a(C5962a aVar) {
        this.cHq = aVar;
    }

    /* renamed from: a */
    public void mo28609a(TemplateInfo templateInfo, int i) {
        if (templateInfo != null) {
            int indexOf = this.cwH.indexOf(templateInfo);
            if (indexOf >= 0) {
                TemplateInfo templateInfo2 = (TemplateInfo) this.cwH.get(indexOf);
                if (templateInfo2 != null && templateInfo2.nState == 1) {
                    templateInfo2.nState = 8;
                    this.cHo.mo28549ay(this.cwH);
                    this.cHo.notifyDataSetChanged();
                }
            }
        }
    }

    public void add() {
        if (!TextUtils.isEmpty(this.cwy)) {
            if (!C8750d.m25573jM(this.cwy) || !C8655f.aKE().aKF()) {
                this.cwZ = this.cww.mo35208qC(this.cwy);
                if (this.cwZ < 0) {
                    this.cwZ = this.cww.aMs();
                    return;
                }
                return;
            }
            this.cxc = this.cwy;
            this.cwZ = -1;
        } else if (!C8655f.aKE().aKF()) {
            this.cwZ = this.cww.mo35205bx(((Long) C8744m.etu.get(0)).longValue());
        } else if (this.cwZ >= 0) {
            String[] aKG = C8655f.aKE().aKG();
            if (aKG != null) {
                this.cxc = aKG[0];
            }
        }
    }

    public void ade() {
        if (this.cwK != null) {
            this.cwK.setAdapter(null);
            this.cwK = null;
        }
        this.cHj.setVisibility(4);
        if (this.cww != null) {
            this.cww.unInit(true);
        }
        if (this.executorService != null) {
            this.executorService.shutdown();
        }
    }

    public void adk() {
        C4562a.m11534b(this.cHj, true, true, 0);
    }

    public void ajA() {
        reset();
        C4562a.m11534b(this.cHj, false, true, 0);
    }

    public RollInfo ajv() {
        String ajw = ajw();
        if (TextUtils.isEmpty(ajw)) {
            return null;
        }
        return (RollInfo) C8762d.m25613a(ajw, (List<TemplateInfo>[]) new List[]{this.cwS, this.cwR});
    }

    public String ajw() {
        if (this.cww == null || this.cwV == null) {
            return null;
        }
        EffectInfoModel vh = this.cww.mo35214vh(this.cwZ);
        return m16789kT((vh == null || !TextUtils.isEmpty(this.cxc)) ? 0 : C8746a.m25564a(vh.mTemplateId, (List<StyleCatItemModel>) this.cwV, this.cwU));
    }

    public void ajy() {
        if (TextUtils.isEmpty(this.cwD)) {
            this.cwD = this.cww.mo35210qG(this.cwZ);
        }
        if (this.cHq != null) {
            this.cHq.mo28590gY(this.cwD);
        }
    }

    public String ajz() {
        return this.cwy;
    }

    /* renamed from: ek */
    public void mo28618ek(boolean z) {
        if (this.cww != null) {
            int count = this.cww.getCount();
            this.cww.mo35198a(this.mContext, -1, this.cwF, AppStateModel.getInstance().isInChina());
            if (count != this.cww.getCount() || z) {
                this.cwZ = this.cww.mo35208qC(this.cwD);
                if (this.cwZ < 0) {
                    this.cxc = this.cwD;
                }
                C1848s.m5326ai(Boolean.valueOf(true)).mo10194f(C1820a.aVi()).mo10199i(new C1518f<Boolean, Boolean>() {
                    /* renamed from: c */
                    public Boolean apply(Boolean bool) {
                        C5964c.this.adJ();
                        return Boolean.valueOf(true);
                    }
                }).mo10194f(C1487a.aUa()).mo10188a((C1850u<? super T>) new C1810c<Boolean>() {
                    /* renamed from: e */
                    public void onSuccess(Boolean bool) {
                        C5964c.this.adi();
                        C5964c.this.m16780fi(true);
                        C5964c.this.ajx();
                    }

                    public void onError(Throwable th) {
                    }
                });
                return;
            }
            adh();
        }
    }

    /* renamed from: eo */
    public void mo28619eo(final boolean z) {
        this.cww.mo35198a(this.mContext, -1, this.cwF, AppStateModel.getInstance().isInChina());
        this.cwZ = this.cww.mo35208qC(this.cwD);
        if (this.cwZ < 0) {
            this.cxc = this.cwD;
        }
        C1848s.m5326ai(Boolean.valueOf(true)).mo10194f(C1820a.aVi()).mo10199i(new C1518f<Boolean, Boolean>() {
            /* renamed from: c */
            public Boolean apply(Boolean bool) {
                C5964c.this.adJ();
                return Boolean.valueOf(true);
            }
        }).mo10194f(C1487a.aUa()).mo10188a((C1850u<? super T>) new C1810c<Boolean>() {
            /* renamed from: e */
            public void onSuccess(Boolean bool) {
                C5964c.this.adi();
                if (z) {
                    C5964c.this.m16780fi(true);
                }
                C5964c.this.ajx();
            }

            public void onError(Throwable th) {
            }
        });
    }

    /* renamed from: fj */
    public void mo28620fj(boolean z) {
        C4562a.m11534b(this.cHj, true, z, 0);
    }

    /* renamed from: gk */
    public void mo28621gk(String str) {
        if (this.cww != null) {
            this.cww.mo35198a(this.mContext, -1, this.cwF, AppStateModel.getInstance().isInChina());
            adh();
        }
        String kT = m16789kT(this.cxb);
        if (m16782gp(kT)) {
            this.cHp.ack();
            m16773b(this.cwU, str);
        } else {
            C8746a.m25570c(this.cwU, str);
            m16784hd(kT);
        }
        if (TextUtils.equals(str, kT)) {
            ajx();
        }
        this.cHl.notifyItemChanged(this.cxb);
    }

    /* renamed from: gl */
    public void mo28622gl(String str) {
        boolean isInChina = AppStateModel.getInstance().isInChina();
        if (this.cww != null) {
            this.cww.mo35198a(this.mContext, -1, this.cwF, isInChina);
        }
        String kT = m16789kT(this.cxb);
        if (TextUtils.equals(str, kT)) {
            ajx();
        }
        if (m16782gp(kT)) {
            this.cHp.ack();
            m16773b(this.cwU, str);
        } else {
            C8746a.m25570c(this.cwU, str);
            m16784hd(kT);
        }
        this.cHl.notifyItemChanged(this.cxb);
    }

    /* renamed from: gn */
    public void mo28623gn(String str) {
        this.cwy = str;
    }

    /* renamed from: go */
    public void mo28624go(String str) {
        this.cwD = str;
    }

    /* renamed from: h */
    public void mo28625h(boolean z, String str) {
        add();
        adJ();
        adi();
        if (!TextUtils.isEmpty(str)) {
            this.cxb = m16785he(str);
        }
        m16780fi(false);
        ajx();
        TemplateInfo a = C8762d.m25613a(str, (List<TemplateInfo>[]) new List[]{this.cwS, this.cwR});
        if (!(this.cHq == null || a == null)) {
            this.cHq.mo28586a((RollInfo) a);
        }
        if (z) {
            this.mHandler.sendEmptyMessageDelayed(TodoConstants.TODO_TYPE_APK_TEST, 900);
        }
    }

    public void reset() {
        this.cwy = "";
        this.cwZ = -1;
        this.cxa = -1;
        if (this.cHn != null) {
            this.cHn.mo28558kP(this.cxa);
        }
        if (this.cHo != null) {
            this.cHo.mo28550gf("");
            this.cHo.notifyDataSetChanged();
        }
    }

    /* renamed from: v */
    public void mo28627v(String str, int i) {
        boolean z;
        if (this.cwV != null) {
            String kT = m16789kT(this.cxb);
            if (this.cwK != null && this.cxb >= 0 && this.cxb < this.cwU.size() && TextUtils.equals(kT, str)) {
                z = true;
                this.cHp.mo28528c(str, i, z);
            }
        }
        z = false;
        this.cHp.mo28528c(str, i, z);
    }
}
