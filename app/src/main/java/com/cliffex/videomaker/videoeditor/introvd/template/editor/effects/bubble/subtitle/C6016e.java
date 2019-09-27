package com.introvd.template.editor.effects.bubble.subtitle;

import android.content.Context;
import android.graphics.Rect;
import android.support.p024v7.widget.LinearLayoutManager;
import android.support.p024v7.widget.RecyclerView;
import android.support.p024v7.widget.RecyclerView.C1018h;
import android.support.p024v7.widget.RecyclerView.C1031r;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import com.introvd.template.VivaBaseApplication;
import com.introvd.template.common.FileUtils;
import com.introvd.template.editor.R;
import com.introvd.template.editor.effects.bubble.p255a.C5919a;
import com.introvd.template.editor.effects.bubble.p255a.C5930d;
import com.introvd.template.editor.effects.bubble.p255a.C5934e;
import com.introvd.template.editor.effects.bubble.p255a.C5934e.C5936a;
import com.introvd.template.editor.effects.bubble.p255a.C5938f;
import com.introvd.template.editor.effects.bubble.p255a.C5938f.C5940a;
import com.introvd.template.editor.p259f.C6281c;
import com.introvd.template.editor.p266h.C6375c;
import com.introvd.template.p203b.C4580b;
import com.introvd.template.p203b.C4583d;
import com.introvd.template.p203b.C4600l;
import com.introvd.template.sdk.model.editor.EffectInfoModel;
import com.introvd.template.sdk.model.editor.StoryBoardItemInfo;
import com.introvd.template.sdk.model.template.RollInfo;
import com.introvd.template.sdk.model.template.TemplateInfo;
import com.introvd.template.sdk.p383c.C8399c;
import com.introvd.template.sdk.p391g.C8450a;
import com.introvd.template.template.model.StoryBoardXytItemInfo;
import com.introvd.template.template.model.StyleCatItemModel;
import com.introvd.template.template.model.TemplatePackageInfo;
import com.introvd.template.template.p407e.C8735f;
import com.introvd.template.template.p407e.C8738h;
import com.introvd.template.template.p407e.C8742k;
import com.introvd.template.template.p407e.C8744m;
import com.introvd.template.template.p408f.C8746a;
import com.introvd.template.template.p409g.C8759b;
import com.introvd.template.template.p409g.C8762d;
import com.p131c.p132a.C2561a;
import com.p131c.p132a.p135c.C2575a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import p037b.p050b.C1848s;
import p037b.p050b.C1850u;
import p037b.p050b.p051a.p053b.C1487a;
import p037b.p050b.p057e.C1518f;
import p037b.p050b.p073g.C1810c;
import p037b.p050b.p076j.C1820a;

/* renamed from: com.introvd.template.editor.effects.bubble.subtitle.e */
public class C6016e {
    public static boolean cHL = true;
    /* access modifiers changed from: private */
    public C6000a cHM;
    /* access modifiers changed from: private */
    public C5938f cHl;
    /* access modifiers changed from: private */
    public RecyclerView cHm;
    /* access modifiers changed from: private */
    public C5934e cHn;
    private C5930d cHo;
    /* access modifiers changed from: private */
    public C5919a cHp;
    private C5940a cHr = new C5940a() {
        /* renamed from: z */
        public void mo28568z(View view, int i) {
            C6016e.this.cxb = i;
            C6016e.this.cHl.mo28566kP(C6016e.this.cxb);
            C6016e.this.ajx();
            if (C6016e.this.cxb < C6016e.this.cwV.size()) {
                StyleCatItemModel styleCatItemModel = (StyleCatItemModel) C6016e.this.cwV.get(C6016e.this.cxb);
                if (styleCatItemModel != null) {
                    if (styleCatItemModel.type == 0) {
                        C6016e.this.cHp.ack();
                    } else if (styleCatItemModel.type == 1) {
                        C6016e.this.m17041hi(C6016e.this.m17045kT(C6016e.this.cxb));
                    }
                }
            }
        }
    };
    private C5936a cHs = new C5936a() {
        /* renamed from: z */
        public void mo28560z(View view, int i) {
            if (!C4580b.m11632Sf() && C6016e.this.cwK != null && C6016e.this.cwG != null) {
                StoryBoardItemInfo storyBoardItemInfo = (StoryBoardItemInfo) C6016e.this.cwG.get(i);
                if (storyBoardItemInfo != null && storyBoardItemInfo.mEffectInfo != null) {
                    EffectInfoModel effectInfoModel = storyBoardItemInfo.mEffectInfo;
                    if (effectInfoModel.isbNeedDownload()) {
                        if (C6016e.this.cHM != null) {
                            C6016e.this.cHM.mo28680c(effectInfoModel);
                        }
                        return;
                    }
                    if (i != C6016e.this.cxa) {
                        if (!(C6016e.this.cHM == null || C6016e.this.cww == null || storyBoardItemInfo.mEffectInfo == null)) {
                            int bx = C6016e.this.cww.mo35205bx(storyBoardItemInfo.mEffectInfo.mTemplateId);
                            if (C6016e.this.cHM.mo28682mx(bx)) {
                                C6016e.this.cHM.mo28681kX(bx);
                                if (C6016e.this.cHn != null) {
                                    C6016e.this.cHn.mo28558kP(i);
                                }
                                C6016e.this.cxa = i;
                            }
                        }
                    } else if (!(C6016e.this.cHM == null || C6016e.this.cww == null || storyBoardItemInfo.mEffectInfo == null)) {
                        int bx2 = C6016e.this.cww.mo35205bx(storyBoardItemInfo.mEffectInfo.mTemplateId);
                        if (C6016e.this.cHM.mo28682mx(bx2)) {
                            C6016e.this.cHM.mo28681kX(bx2);
                        }
                    }
                }
            }
        }
    };
    private C6281c cHt = new C6281c() {
        /* renamed from: c */
        public void mo28635c(int i, Object obj) {
            if (!C4580b.m11632Sf() && C6016e.this.cwK != null) {
                TemplateInfo templateInfo = (TemplateInfo) obj;
                if (templateInfo != null) {
                    EffectInfoModel effectInfoModel = new EffectInfoModel();
                    effectInfoModel.mTemplateId = C2575a.m7391rq(templateInfo.ttid);
                    effectInfoModel.setmUrl(templateInfo.strUrl);
                    effectInfoModel.mName = templateInfo.strTitle;
                    if (i != C6016e.this.cxa) {
                        if (!(C6016e.this.cHM == null || C6016e.this.cww == null)) {
                            int bx = C6016e.this.cww.mo35205bx(effectInfoModel.mTemplateId);
                            if (C6016e.this.cHM.mo28682mx(bx)) {
                                C6016e.this.cHM.mo28681kX(bx);
                                if (C6016e.this.cHn != null) {
                                    C6016e.this.cHn.mo28558kP(i);
                                }
                                C6016e.this.cxa = i;
                            }
                        }
                    } else if (!(C6016e.this.cHM == null || C6016e.this.cww == null)) {
                        int bx2 = C6016e.this.cww.mo35205bx(effectInfoModel.mTemplateId);
                        if (C6016e.this.cHM.mo28682mx(bx2)) {
                            C6016e.this.cHM.mo28681kX(bx2);
                        }
                    }
                }
            }
        }

        /* renamed from: d */
        public void mo28636d(int i, Object obj) {
        }

        /* renamed from: e */
        public boolean mo28637e(int i, Object obj) {
            if (!C4600l.m11739k(C6016e.this.mContext, true)) {
                return false;
            }
            TemplateInfo templateInfo = (TemplateInfo) obj;
            if (templateInfo != null) {
                EffectInfoModel effectInfoModel = new EffectInfoModel();
                effectInfoModel.mTemplateId = C2575a.m7391rq(templateInfo.ttid);
                effectInfoModel.setmUrl(templateInfo.strUrl);
                effectInfoModel.mName = templateInfo.strTitle;
                if (C6016e.this.cHM != null) {
                    C6016e.this.cHM.mo28680c(effectInfoModel);
                }
                C6016e.this.m17024a(templateInfo, i);
            }
            return true;
        }
    };
    /* access modifiers changed from: private */
    public ArrayList<StoryBoardItemInfo> cwG;
    private List<TemplateInfo> cwH = new ArrayList();
    /* access modifiers changed from: private */
    public RecyclerView cwK;
    /* access modifiers changed from: private */
    public List<TemplateInfo> cwR;
    /* access modifiers changed from: private */
    public List<TemplateInfo> cwS;
    private List<TemplatePackageInfo> cwT;
    private Map<String, List<Long>> cwU;
    /* access modifiers changed from: private */
    public ArrayList<StyleCatItemModel> cwV;
    /* access modifiers changed from: private */
    public C8759b cww;
    private C8738h cxS = new C8738h();
    /* access modifiers changed from: private */
    public int cxa = -1;
    /* access modifiers changed from: private */
    public int cxb = -1;
    private OnClickListener cxj = new OnClickListener() {
        public void onClick(View view) {
            if (C4600l.m11739k(VivaBaseApplication.m8749FZ(), true)) {
                TemplateInfo a = C8762d.m25613a(C6016e.this.m17045kT(C6016e.this.cxb), (List<TemplateInfo>[]) new List[]{C6016e.this.cwS, C6016e.this.cwR});
                if (C6016e.this.cHM != null) {
                    C6016e.this.cHM.mo28679b((RollInfo) a);
                }
            }
        }
    };
    /* access modifiers changed from: private */
    public Context mContext;

    public C6016e(RelativeLayout relativeLayout) {
        this.mContext = relativeLayout.getContext();
        RelativeLayout relativeLayout2 = (RelativeLayout) relativeLayout.findViewById(R.id.relative_layout_roll_download);
        this.cHp = new C5919a(relativeLayout2, this.cxj);
        RelativeLayout relativeLayout3 = (RelativeLayout) relativeLayout.findViewById(R.id.rl_layout_downloaded);
        this.cwK = (RecyclerView) relativeLayout.findViewById(R.id.recycler_view_subtitle);
        this.cwK.setLayoutManager(new LinearLayoutManager(this.mContext, 0, false));
        this.cwK.mo7733a((C1018h) new C1018h() {
            public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, C1031r rVar) {
                rect.left = C4583d.m11670O(C6016e.this.mContext, 7);
                rect.right = C4583d.m11670O(C6016e.this.mContext, 7);
            }
        });
        this.cHn = new C5934e(this.mContext);
        this.cHo = new C5930d(this.mContext);
        relativeLayout3.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (C6016e.this.cHM != null) {
                    C6016e.this.cHM.adG();
                }
            }
        });
        relativeLayout2.setVisibility(8);
        this.cHn.mo28554a(this.cHs);
        this.cHm = (RecyclerView) relativeLayout.findViewById(R.id.rv_bubble_tab_normal);
        this.cHm.setLayoutManager(new LinearLayoutManager(relativeLayout.getContext(), 0, false));
    }

    /* renamed from: a */
    private StoryBoardXytItemInfo m17021a(C8759b bVar, Long l) {
        StoryBoardXytItemInfo storyBoardXytItemInfo = new StoryBoardXytItemInfo();
        storyBoardXytItemInfo.mEffectInfo = bVar.mo35204bw(l.longValue());
        if (C8450a.m24466bk(l.longValue())) {
            storyBoardXytItemInfo.mBubbleType = 1;
            storyBoardXytItemInfo.mThumbPath = C8762d.aMt().getTemplateExternalFile(l.longValue(), 0, 3);
        }
        storyBoardXytItemInfo.lTemplateId = l.longValue();
        storyBoardXytItemInfo.isVideo = false;
        storyBoardXytItemInfo.lDuration = 0;
        return storyBoardXytItemInfo;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m17024a(TemplateInfo templateInfo, int i) {
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

    /* renamed from: aI */
    private void m17025aI(List<Long> list) {
        if (this.cww != null && list != null && list.size() > 0) {
            for (Long a : list) {
                this.cwG.add(m17021a(this.cww, a));
            }
        }
    }

    /* access modifiers changed from: private */
    public void adJ() {
        this.cwV = new ArrayList<>();
        if (!cHL) {
            this.cwT = C8742k.aMi().mo35177cG(this.mContext, "cover_text");
            for (TemplatePackageInfo templatePackageInfo : this.cwT) {
                this.cwV.add(new StyleCatItemModel(0, templatePackageInfo.strGroupCode));
            }
        }
        this.cwR = C8735f.aMf().mo35151qk(C8399c.edb);
        this.cwS = C6375c.asF().asM();
        if (C2561a.aOR() == 1 || C2561a.aON()) {
            this.cwV.add(new StyleCatItemModel(1, "20160224184948"));
        }
        List b = C8746a.m25568b(this.cwS, false, false);
        this.cwV.addAll(b);
        List b2 = C8746a.m25568b(this.cwR, true, false);
        b2.removeAll(b);
        this.cwV.addAll(b2);
        this.cwU = new HashMap();
        if (C2561a.aOR() == 1 || C2561a.aON()) {
            this.cwU.put("20160224184948", C8744m.ets);
        }
        Iterator it = this.cwV.iterator();
        while (it.hasNext()) {
            StyleCatItemModel styleCatItemModel = (StyleCatItemModel) it.next();
            if (styleCatItemModel.type == 0) {
                m17029b(this.cwU, styleCatItemModel.ttid);
            } else if (styleCatItemModel.type == 1) {
                C8746a.m25570c(this.cwU, styleCatItemModel.ttid);
            }
        }
        if (this.cxS.mo35166hg(this.mContext) > 0) {
            List hl = this.cxS.mo35171hl(this.mContext);
            if (hl != null && !hl.isEmpty()) {
                Iterator it2 = hl.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        if (!C8450a.m24466bk(((Long) it2.next()).longValue())) {
                            this.cwU.put("title_test/", hl);
                            this.cwV.add(0, new StyleCatItemModel(1, "title_test/"));
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        }
        if (!cHL) {
            Iterator it3 = this.cwV.iterator();
            while (it3.hasNext()) {
                StyleCatItemModel styleCatItemModel2 = (StyleCatItemModel) it3.next();
                if (styleCatItemModel2.type == 0) {
                    styleCatItemModel2.strPath = C8746a.m25565a(this.cwT, styleCatItemModel2.ttid, styleCatItemModel2.strPath);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void adi() {
        if (this.cHm != null && this.cwK != null) {
            if (this.cHl != null) {
                this.cHl.mItemInfoList = this.cwV;
            } else {
                this.cHl = new C5938f(this.mContext, this.cwV, false);
            }
            this.cHm.setAdapter(this.cHl);
            this.cHl.mo28562a(this.cHr);
            this.cwK.setAdapter(this.cHo);
            this.cHo.mo28548a(this.cHt);
        }
    }

    /* access modifiers changed from: private */
    public void ajx() {
        if (this.cwK != null) {
            this.cxa = -1;
            if (this.cHo != null) {
                this.cHo.mo28550gf("");
                this.cHo.notifyDataSetChanged();
            }
            if (this.cwV != null && this.cxb < this.cwV.size() && this.cxb >= 0) {
                StyleCatItemModel styleCatItemModel = (StyleCatItemModel) this.cwV.get(this.cxb);
                if (styleCatItemModel != null) {
                    String kT = m17045kT(this.cxb);
                    if (styleCatItemModel.type == 0) {
                        this.cwK.setAdapter(this.cHo);
                        m17048mv(this.cxb);
                    } else if (styleCatItemModel.type == 1) {
                        List list = (List) this.cwU.get(kT);
                        this.cxa = m17031c(list, this.cww.mo35210qG(this.cHM.adF()));
                        if (this.cwG == null) {
                            this.cwG = new ArrayList<>();
                        } else {
                            this.cwG.clear();
                        }
                        if (list == null || list.size() <= 0) {
                            C8746a.m25567a(this.cwG, this.cwR, this.cwS, kT);
                        } else {
                            m17025aI(list);
                        }
                        this.cwK.setAdapter(this.cHn);
                        this.cHn.mo28557h(this.cwG);
                        this.cHn.mo28558kP(this.cxa);
                        if (this.cxa >= 0) {
                            this.cwK.scrollToPosition(this.cxa);
                        }
                    }
                }
            }
        }
    }

    /* renamed from: b */
    private void m17029b(Map<String, List<Long>> map, String str) {
        if (map != null) {
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
    }

    /* renamed from: c */
    private int m17031c(List<Long> list, String str) {
        int i = -1;
        if (FileUtils.isFileExisted(str) && this.cww != null && list != null && list.size() > 0) {
            int i2 = 0;
            for (Long longValue : list) {
                EffectInfoModel bw = this.cww.mo35204bw(longValue.longValue());
                if (bw != null && TextUtils.equals(str, bw.mPath)) {
                    i = i2;
                }
                i2++;
            }
        }
        return i;
    }

    /* access modifiers changed from: private */
    /* renamed from: fi */
    public void m17036fi(boolean z) {
        if (this.cHM != null && this.cww != null && this.cHm != null && this.cwV != null) {
            if (z || this.cxb == -1) {
                EffectInfoModel vh = this.cww.mo35214vh(this.cHM.adF());
                if (vh == null) {
                    this.cxb = 0;
                } else {
                    this.cxb = C8746a.m25564a(vh.mTemplateId, (List<StyleCatItemModel>) this.cwV, this.cwU);
                    if (this.cxb < 0) {
                        this.cxb = 0;
                    }
                }
            }
            this.cHl.mo28566kP(this.cxb);
            String kT = m17045kT(this.cxb);
            if (m17038gp(kT)) {
                this.cHp.ack();
            } else {
                m17041hi(kT);
            }
            this.cHm.post(new Runnable() {
                public void run() {
                    if (C6016e.this.cHm != null) {
                        C6016e.this.cHm.scrollToPosition(C6016e.this.cxb);
                    }
                }
            });
            this.cHl.notifyItemChanged(this.cxb);
        }
    }

    /* renamed from: gp */
    private boolean m17038gp(String str) {
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

    /* access modifiers changed from: private */
    /* renamed from: he */
    public int m17040he(String str) {
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

    /* access modifiers changed from: private */
    /* renamed from: hi */
    public void m17041hi(String str) {
        if (this.cwU != null && this.cHp != null) {
            boolean z = false;
            TemplateInfo a = C8762d.m25613a(str, (List<TemplateInfo>[]) new List[]{this.cwS, this.cwR});
            List list = (List) this.cwU.get(str);
            C5919a aVar = this.cHp;
            Context context = this.mContext;
            if (list != null && list.size() > 0) {
                z = true;
            }
            aVar.mo28526a(context, z, a, str);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: kT */
    public String m17045kT(int i) {
        if (this.cwV == null || this.cwV.isEmpty() || i < 0 || i >= this.cwV.size()) {
            return "";
        }
        StyleCatItemModel styleCatItemModel = (StyleCatItemModel) this.cwV.get(i);
        return styleCatItemModel != null ? styleCatItemModel.ttid : "";
    }

    /* renamed from: mv */
    private void m17048mv(int i) {
        this.cwH.clear();
        if (this.cHo != null) {
            this.cHo.mo28549ay(this.cwH);
            this.cHo.notifyDataSetChanged();
        }
        this.cwT = C8742k.aMi().mo35177cG(this.mContext, "cover_text");
        if (i >= 0 && i < this.cwT.size()) {
            TemplatePackageInfo templatePackageInfo = (TemplatePackageInfo) this.cwT.get(i);
            if (templatePackageInfo != null) {
                C8742k.aMi().mo35178cz(this.mContext, templatePackageInfo.strGroupCode);
                this.cwH = C8742k.aMi().mo35183qt(templatePackageInfo.strGroupCode);
                if (!(this.cwH == null || this.cwH.size() <= 0 || this.cHo == null)) {
                    this.cHo.mo28549ay(this.cwH);
                    this.cHo.notifyDataSetChanged();
                    int adF = this.cHM.adF();
                    int i2 = 0;
                    for (TemplateInfo templateInfo : this.cwH) {
                        if (templateInfo != null) {
                            EffectInfoModel bw = this.cww.mo35204bw(C2575a.m7391rq(templateInfo.ttid));
                            if (bw != null && TextUtils.equals(this.cww.mo35210qG(adF), bw.mPath) && adF >= 0) {
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

    /* renamed from: a */
    public void mo28707a(C6000a aVar) {
        this.cHM = aVar;
    }

    /* renamed from: a */
    public void mo28708a(C8759b bVar) {
        this.cww = bVar;
    }

    public void adI() {
        this.cxa = -1;
        if (this.cHn != null) {
            this.cHn.mo28558kP(this.cxa);
        }
        if (this.cHo != null) {
            this.cHo.mo28550gf("");
            this.cHo.notifyDataSetChanged();
        }
    }

    public void ade() {
        if (this.cwK != null) {
            this.cwK.setAdapter(null);
            this.cwK = null;
        }
        if (this.cHm != null) {
            this.cHm.setAdapter(null);
            this.cHm = null;
        }
    }

    public RollInfo ajv() {
        if (this.cww == null || this.cwV == null) {
            return null;
        }
        EffectInfoModel vh = this.cww.mo35214vh(this.cHM.adF());
        return (RollInfo) C8762d.m25613a(m17045kT(vh == null ? 0 : C8746a.m25564a(vh.mTemplateId, (List<StyleCatItemModel>) this.cwV, this.cwU)), (List<TemplateInfo>[]) new List[]{this.cwS, this.cwR});
    }

    /* renamed from: fm */
    public void mo28712fm(final boolean z) {
        C1848s.m5326ai(Boolean.valueOf(true)).mo10194f(C1820a.aVi()).mo10199i(new C1518f<Boolean, Boolean>() {
            /* renamed from: c */
            public Boolean apply(Boolean bool) {
                C6016e.this.adJ();
                return Boolean.valueOf(true);
            }
        }).mo10194f(C1487a.aUa()).mo10188a((C1850u<? super T>) new C1810c<Boolean>() {
            /* renamed from: e */
            public void onSuccess(Boolean bool) {
                C6016e.this.adi();
                if (z) {
                    C6016e.this.m17036fi(true);
                }
                C6016e.this.ajx();
            }

            public void onError(Throwable th) {
            }
        });
    }

    /* renamed from: gl */
    public void mo28713gl(String str) {
        String kT = m17045kT(this.cxb);
        if (m17038gp(kT)) {
            this.cHp.ack();
            m17029b(this.cwU, str);
        } else {
            C8746a.m25570c(this.cwU, str);
            this.cHp.mo28526a(this.mContext, false, C8762d.m25613a(kT, (List<TemplateInfo>[]) new List[]{this.cwS, this.cwR}), kT);
        }
        if (TextUtils.equals(str, kT)) {
            ajx();
        }
        if (this.cHl != null) {
            this.cHl.notifyItemChanged(this.cxb);
        }
    }

    /* renamed from: hg */
    public boolean mo28714hg(String str) {
        return !TextUtils.isEmpty(str) && this.cwV != null && this.cwV.size() > 0 && this.cwV.contains(new StyleCatItemModel(1, str, ""));
    }

    /* renamed from: hh */
    public void mo28715hh(final String str) {
        C1848s.m5326ai(Boolean.valueOf(true)).mo10194f(C1820a.aVi()).mo10199i(new C1518f<Boolean, Boolean>() {
            /* renamed from: c */
            public Boolean apply(Boolean bool) {
                C6016e.this.adJ();
                return Boolean.valueOf(true);
            }
        }).mo10194f(C1487a.aUa()).mo10188a((C1850u<? super T>) new C1810c<Boolean>() {
            /* renamed from: e */
            public void onSuccess(Boolean bool) {
                C6016e.this.adi();
                if (!TextUtils.isEmpty(str)) {
                    C6016e.this.cxb = C6016e.this.m17040he(str);
                    TemplateInfo a = C8762d.m25613a(str, (List<TemplateInfo>[]) new List[]{C6016e.this.cwS, C6016e.this.cwR});
                    if (!(C6016e.this.cHM == null || a == null)) {
                        C6016e.this.cHM.mo28679b((RollInfo) a);
                    }
                }
                C6016e.this.m17036fi(false);
                C6016e.this.ajx();
            }

            public void onError(Throwable th) {
            }
        });
    }

    /* renamed from: v */
    public void mo28716v(String str, int i) {
        boolean z;
        if (this.cwV != null) {
            String kT = m17045kT(this.cxb);
            if (this.cwK != null && this.cxb >= 0 && this.cxb < this.cwU.size() && TextUtils.equals(kT, str)) {
                z = true;
                this.cHp.mo28528c(str, i, z);
            }
        }
        z = false;
        this.cHp.mo28528c(str, i, z);
    }
}
