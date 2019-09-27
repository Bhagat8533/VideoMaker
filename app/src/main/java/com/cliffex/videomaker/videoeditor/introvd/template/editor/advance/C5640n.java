package com.introvd.template.editor.advance;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;
import android.support.p024v7.widget.LinearLayoutManager;
import android.support.p024v7.widget.RecyclerView;
import android.support.p024v7.widget.RecyclerView.C1018h;
import android.support.p024v7.widget.RecyclerView.C1031r;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import com.introvd.template.common.FileUtils;
import com.introvd.template.common.other.WeakHandler;
import com.introvd.template.editor.R;
import com.introvd.template.p203b.C4580b;
import com.introvd.template.p203b.C4583d;
import com.introvd.template.p203b.C4600l;
import com.introvd.template.p375r.p376a.C8360a.C8362a;
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
import com.introvd.template.template.p407e.C8743l;
import com.introvd.template.template.p407e.C8744m;
import com.introvd.template.template.p408f.C8746a;
import com.introvd.template.template.p409g.C8759b;
import com.introvd.template.template.p409g.C8762d;
import com.introvd.template.xyui.StoryGridView;
import com.p131c.p132a.C2561a;
import com.p131c.p132a.p135c.C2575a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import p037b.p050b.C1834l;
import p037b.p050b.C1838m;
import p037b.p050b.C1839n;
import p037b.p050b.p051a.p053b.C1487a;
import p037b.p050b.p054b.C1495b;
import p037b.p050b.p057e.C1517e;
import p037b.p050b.p076j.C1820a;

/* renamed from: com.introvd.template.editor.advance.n */
public class C5640n {
    private RelativeLayout bWd;
    /* access modifiers changed from: private */
    public ArrayList<StoryBoardItemInfo> cwG;
    private List<TemplateInfo> cwH = new ArrayList();
    private StoryGridView cwI;
    /* access modifiers changed from: private */
    public C5598e cwJ;
    /* access modifiers changed from: private */
    public RecyclerView cwK;
    /* access modifiers changed from: private */
    public C5597d cwL;
    private C5593c cwM;
    private LinearLayoutManager cwN;
    /* access modifiers changed from: private */
    public List<TemplateInfo> cwR;
    /* access modifiers changed from: private */
    public List<TemplateInfo> cwS;
    /* access modifiers changed from: private */
    public List<TemplatePackageInfo> cwT;
    private Map<String, List<Long>> cwU;
    /* access modifiers changed from: private */
    public C5581a cwW;
    /* access modifiers changed from: private */
    public C8759b cww;
    /* access modifiers changed from: private */
    public List<StyleCatItemModel> cxP;
    private RelativeLayout cxQ;
    /* access modifiers changed from: private */
    public C5652o cxR;
    private C8738h cxS = new C8738h();
    private C1495b cxT;
    /* access modifiers changed from: private */
    public int cxa = -1;
    /* access modifiers changed from: private */
    public int cxb = -1;
    private C5604i cxd = new C5604i() {
        /* renamed from: c */
        public void mo27540c(int i, Object obj) {
            if (!C4580b.m11632Sf() && i != C5640n.this.cxa) {
                TemplateInfo templateInfo = (TemplateInfo) obj;
                if (templateInfo != null) {
                    EffectInfoModel effectInfoModel = new EffectInfoModel();
                    effectInfoModel.mTemplateId = C2575a.m7391rq(templateInfo.ttid);
                    effectInfoModel.setmUrl(templateInfo.strUrl);
                    effectInfoModel.mName = templateInfo.strTitle;
                    if (!(C5640n.this.cxR == null || C5640n.this.cxR.adH() || C5640n.this.cww == null)) {
                        C5640n.this.cxR.mo27682kX(C5640n.this.cww.mo35205bx(effectInfoModel.mTemplateId));
                        if (C5640n.this.cwL != null) {
                            C5640n.this.cwL.mo27533kP(i);
                            C5640n.this.cwL.acE();
                        }
                        C5640n.this.cxa = i;
                    }
                }
            }
        }

        /* renamed from: d */
        public void mo27541d(int i, Object obj) {
        }

        /* renamed from: e */
        public boolean mo27542e(int i, Object obj) {
            if (!C4600l.m11739k(C5640n.this.mContext, true)) {
                return false;
            }
            TemplateInfo templateInfo = (TemplateInfo) obj;
            if (templateInfo != null) {
                EffectInfoModel effectInfoModel = new EffectInfoModel();
                effectInfoModel.mTemplateId = C2575a.m7391rq(templateInfo.ttid);
                effectInfoModel.setmUrl(templateInfo.strUrl);
                effectInfoModel.mName = templateInfo.strTitle;
                if (C5640n.this.cxR != null) {
                    C5640n.this.cxR.mo27681c(effectInfoModel);
                }
                C5640n.this.mo27686a(templateInfo, i);
            }
            return true;
        }
    };
    private C8362a cxe = new C8362a() {
        /* renamed from: z */
        public void mo27631z(View view, int i) {
            C5640n.this.cxb = i;
            C5640n.this.cwJ.mo27533kP(C5640n.this.cxb);
            C5640n.this.cwJ.notifyDataSetChanged();
            C5640n.this.m15569el(false);
            StyleCatItemModel styleCatItemModel = (StyleCatItemModel) C5640n.this.cxP.get(C5640n.this.cxb);
            if (styleCatItemModel.type == 0) {
                C5640n.this.cwW.ack();
            } else if (styleCatItemModel.type == 1) {
                String a = C5640n.this.m15578kT(C5640n.this.cxb);
                C5640n.this.cwW.mo27472a(C5640n.this.mContext, false, C8762d.m25613a(a, (List<TemplateInfo>[]) new List[]{C5640n.this.cwS, C5640n.this.cwR}), a);
            }
        }
    };
    private C8362a cxf = new C8362a() {
        /* renamed from: z */
        public void mo27631z(View view, int i) {
            if (!C4580b.m11632Sf() && C5640n.this.cwG != null && i != C5640n.this.cxa) {
                StoryBoardItemInfo storyBoardItemInfo = (StoryBoardItemInfo) C5640n.this.cwG.get(i);
                if (storyBoardItemInfo != null) {
                    EffectInfoModel effectInfoModel = storyBoardItemInfo.mEffectInfo;
                    if (effectInfoModel != null && effectInfoModel.isbNeedDownload()) {
                        if (C5640n.this.cxR != null) {
                            C5640n.this.cxR.mo27681c(effectInfoModel);
                        }
                        return;
                    }
                }
                if (!(C5640n.this.cxR == null || C5640n.this.cxR.adH() || i == C5640n.this.cxa || C5640n.this.cww == null || storyBoardItemInfo == null || storyBoardItemInfo.mEffectInfo == null)) {
                    C5640n.this.cxR.mo27682kX(C5640n.this.cww.mo35205bx(storyBoardItemInfo.mEffectInfo.mTemplateId));
                    if (C5640n.this.cwL != null) {
                        C5640n.this.cwL.mo27533kP(i);
                        C5640n.this.cwL.acE();
                    }
                    C5640n.this.cxa = i;
                }
            }
        }
    };
    private OnClickListener cxj = new OnClickListener() {
        public void onClick(View view) {
            TemplateInfo a = C8762d.m25613a(C5640n.this.m15578kT(C5640n.this.cxb), (List<TemplateInfo>[]) new List[]{C5640n.this.cwS, C5640n.this.cwR});
            if (C5640n.this.cxR != null) {
                C5640n.this.cxR.mo27680b((RollInfo) a);
            }
        }
    };
    /* access modifiers changed from: private */
    public Context mContext;
    /* access modifiers changed from: private */
    public Handler mHandler = new C5651a(this);

    /* renamed from: com.introvd.template.editor.advance.n$a */
    private static class C5651a extends WeakHandler<C5640n> {
        public C5651a(C5640n nVar) {
            super(nVar);
        }

        public void handleMessage(Message message) {
            C5640n nVar = (C5640n) getOwner();
            if (nVar != null && message.what == 10005 && nVar.cwK != null) {
                boolean z = true;
                if (message.arg1 != 1) {
                    z = false;
                }
                nVar.cwT = C8742k.aMi().mo35177cG(nVar.mContext, "cover_text");
                nVar.mo27690q(false, z);
            }
        }
    }

    public C5640n(RelativeLayout relativeLayout, C8759b bVar) {
        this.bWd = relativeLayout;
        this.cww = bVar;
        this.mContext = this.bWd.getContext();
        RelativeLayout relativeLayout2 = (RelativeLayout) this.bWd.findViewById(R.id.relative_layout_roll_download);
        this.cwW = new C5581a(relativeLayout2, this.cxj);
        this.cxQ = (RelativeLayout) this.bWd.findViewById(R.id.layout_downloaded);
        this.cwK = (RecyclerView) this.bWd.findViewById(R.id.layout_storyboard_view);
        this.cwN = new LinearLayoutManager(this.mContext, 0, false);
        this.cwK.setLayoutManager(this.cwN);
        this.cwK.mo7733a((C1018h) new C1018h() {
            public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, C1031r rVar) {
                rect.left = C4583d.m11670O(C5640n.this.mContext, 7);
                rect.right = C4583d.m11670O(C5640n.this.mContext, 7);
            }
        });
        this.cwL = new C5597d(this.mContext);
        this.cwM = new C5593c(this.mContext);
        this.cxQ.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (C5640n.this.cxR != null) {
                    C5640n.this.cxR.adG();
                }
            }
        });
        relativeLayout2.setVisibility(8);
        this.cwL.mo33617a(this.cxf);
        this.cwM.mo27524a(this.cxd);
        this.cwI = (StoryGridView) this.bWd.findViewById(R.id.view_content);
        m15573gq("");
    }

    /* renamed from: G */
    private void m15554G(int i, boolean z) {
        this.cwH.clear();
        this.cwM.mo27525ay(this.cwH);
        this.cwT = C8742k.aMi().mo35177cG(this.mContext, "cover_text");
        if (i >= 0 && i < this.cwT.size()) {
            TemplatePackageInfo templatePackageInfo = (TemplatePackageInfo) this.cwT.get(i);
            if (templatePackageInfo != null) {
                C8742k.aMi().mo35178cz(this.mContext, templatePackageInfo.strGroupCode);
                this.cwH = C8742k.aMi().mo35183qt(templatePackageInfo.strGroupCode);
                int i2 = 0;
                if (this.cwH != null && this.cwH.size() > 0 && this.cwM != null) {
                    this.cwM.mo27525ay(this.cwH);
                    int adF = this.cxR.adF();
                    for (TemplateInfo templateInfo : this.cwH) {
                        if (templateInfo != null) {
                            EffectInfoModel bw = this.cww.mo35204bw(C2575a.m7391rq(templateInfo.ttid));
                            if (bw != null && TextUtils.equals(this.cww.mo35210qG(adF), bw.mPath) && adF >= 0) {
                                this.cxa = i2;
                                if (this.cwM != null) {
                                    this.cwM.mo27526gf(templateInfo.ttid);
                                    this.cwM.notifyDataSetChanged();
                                    this.cwK.smoothScrollToPosition(this.cxa);
                                }
                            }
                            i2++;
                        }
                    }
                } else if (!z && C4600l.m11739k(this.mContext, false)) {
                    m15573gq(templatePackageInfo.strGroupCode);
                }
            }
        }
    }

    /* renamed from: a */
    private StoryBoardXytItemInfo m15556a(C8759b bVar, Long l, boolean z) {
        StoryBoardXytItemInfo storyBoardXytItemInfo = new StoryBoardXytItemInfo();
        storyBoardXytItemInfo.mEffectInfo = bVar.mo35204bw(l.longValue());
        if (C8450a.m24466bk(l.longValue())) {
            storyBoardXytItemInfo.mBubbleType = 1;
            storyBoardXytItemInfo.mThumbPath = C8762d.aMt().getTemplateExternalFile(l.longValue(), 0, 3);
        } else {
            if (z) {
                Bitmap bz = bVar.mo35206bz(l.longValue());
                if (bz != null) {
                    storyBoardXytItemInfo.bmpThumbnail = bz;
                }
            } else {
                storyBoardXytItemInfo.bSyncThumb = false;
            }
            if (storyBoardXytItemInfo.bmpThumbnail == null) {
                storyBoardXytItemInfo.mThumbPath = C8762d.aMt().getTemplateExternalFile(l.longValue(), 0, 3);
            }
        }
        storyBoardXytItemInfo.lTemplateId = l.longValue();
        storyBoardXytItemInfo.isVideo = false;
        storyBoardXytItemInfo.lDuration = 0;
        return storyBoardXytItemInfo;
    }

    /* renamed from: aI */
    private void m15560aI(List<Long> list) {
        if (this.cww != null && list != null && list.size() > 0) {
            for (Long a : list) {
                this.cwG.add(m15556a(this.cww, a, true));
            }
        }
    }

    /* access modifiers changed from: private */
    public synchronized void adJ() {
        this.cxP = new ArrayList();
        this.cwT = C8742k.aMi().mo35177cG(this.mContext, "cover_text");
        for (TemplatePackageInfo templatePackageInfo : this.cwT) {
            this.cxP.add(new StyleCatItemModel(0, templatePackageInfo.strGroupCode));
        }
        this.cwR = C8735f.aMf().mo35151qk(C8399c.edb);
        this.cwS = C8743l.m25552cI(this.mContext, C8399c.edb);
        this.cxP.add(new StyleCatItemModel(1, "20160224184948"));
        List a = C8746a.m25566a(this.cwS, false, false, false, true);
        this.cxP.addAll(a);
        List a2 = C8746a.m25566a(this.cwR, false, false, true, true);
        a2.removeAll(a);
        this.cxP.addAll(a2);
        this.cwU = new HashMap();
        if (C2561a.aOR() == 1) {
            this.cwU.put("20160224184948", C8744m.ets);
        }
        for (StyleCatItemModel styleCatItemModel : this.cxP) {
            if (styleCatItemModel.type == 0) {
                m15563b(this.cwU, styleCatItemModel.ttid);
            } else if (styleCatItemModel.type == 1) {
                C8746a.m25570c(this.cwU, styleCatItemModel.ttid);
            }
        }
        if (this.cxS.mo35166hg(this.mContext) > 0) {
            List hl = this.cxS.mo35171hl(this.cxQ.getContext());
            if (hl != null && !hl.isEmpty()) {
                Iterator it = hl.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (!C8450a.m24466bk(((Long) it.next()).longValue())) {
                            this.cwU.put("title_test/", hl);
                            this.cxP.add(0, new StyleCatItemModel(1, "title_test/"));
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        }
        for (StyleCatItemModel styleCatItemModel2 : this.cxP) {
            if (styleCatItemModel2.type == 0) {
                styleCatItemModel2.strPath = C8746a.m25565a(this.cwT, styleCatItemModel2.ttid, styleCatItemModel2.strPath);
            }
        }
    }

    /* access modifiers changed from: private */
    public void adi() {
        if (this.cwJ != null) {
            this.cwJ.mItemInfoList = this.cxP;
        } else {
            this.cwJ = new C5598e(this.mContext, this.cxP);
            this.cwJ.mo33617a(this.cxe);
        }
        this.cwI.setAdapter(this.cwJ);
        this.cwK.setAdapter(this.cwM);
    }

    /* access modifiers changed from: private */
    public void adj() {
        if (this.cxR != null && this.cww != null && this.cxP != null) {
            EffectInfoModel vh = this.cww.mo35214vh(this.cxR.adF());
            if (vh == null) {
                this.cxb = 0;
            } else {
                this.cxb = C8746a.m25564a(vh.mTemplateId, this.cxP, this.cwU);
            }
            this.cwJ.mo27533kP(this.cxb);
            String kT = m15578kT(this.cxb);
            if (m15572gp(kT)) {
                this.cwW.ack();
            } else {
                this.cwW.mo27472a(this.mContext, false, C8762d.m25613a(kT, (List<TemplateInfo>[]) new List[]{this.cwS, this.cwR}), kT);
            }
            this.cwI.scrollToPosition(this.cxb);
        }
    }

    /* renamed from: b */
    private void m15563b(Map<String, List<Long>> map, String str) {
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
    private int m15565c(List<Long> list, String str) {
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
    /* renamed from: el */
    public void m15569el(boolean z) {
        this.cxa = -1;
        if (this.cwM != null) {
            this.cwM.mo27526gf("");
            this.cwM.notifyDataSetChanged();
        }
        if (this.cxP != null && this.cxb < this.cxP.size() && this.cxb >= 0) {
            StyleCatItemModel styleCatItemModel = (StyleCatItemModel) this.cxP.get(this.cxb);
            if (styleCatItemModel != null) {
                String kT = m15578kT(this.cxb);
                if (styleCatItemModel.type == 0) {
                    this.cwK.setAdapter(this.cwM);
                    m15554G(this.cxb, z);
                } else if (styleCatItemModel.type == 1) {
                    List list = (List) this.cwU.get(kT);
                    this.cxa = m15565c(list, this.cww.mo35210qG(this.cxR.adF()));
                    if (this.cwG == null) {
                        this.cwG = new ArrayList<>();
                    } else {
                        this.cwG.clear();
                    }
                    if (list == null || list.size() <= 0) {
                        C8746a.m25567a(this.cwG, this.cwR, this.cwS, kT);
                    } else {
                        m15560aI(list);
                    }
                    this.cwK.setAdapter(this.cwL);
                    this.cwL.mo27533kP(this.cxa);
                    this.cwL.mo27532h(this.cwG);
                    if (this.cxa >= 0) {
                        this.cwK.scrollToPosition(this.cxa);
                    }
                }
            }
        }
    }

    /* renamed from: gp */
    private boolean m15572gp(String str) {
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

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0015, code lost:
        if (r0.size() > 0) goto L_0x002a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0063  */
    /* renamed from: gq */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void m15573gq(java.lang.String r7) {
        /*
            r6 = this;
            monitor-enter(r6)
            boolean r0 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x009e }
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x0019
            java.util.List<com.introvd.template.template.model.TemplatePackageInfo> r0 = r6.cwT     // Catch:{ all -> 0x009e }
            java.util.List r0 = com.introvd.template.template.p407e.C8742k.m25537db(r0)     // Catch:{ all -> 0x009e }
            if (r0 == 0) goto L_0x0017
            int r0 = r0.size()     // Catch:{ all -> 0x009e }
            if (r0 > 0) goto L_0x002a
        L_0x0017:
            r1 = 1
            goto L_0x002a
        L_0x0019:
            com.introvd.template.template.e.k r0 = com.introvd.template.template.p407e.C8742k.aMi()     // Catch:{ all -> 0x009e }
            java.util.List r0 = r0.mo35183qt(r7)     // Catch:{ all -> 0x009e }
            if (r0 == 0) goto L_0x0017
            int r0 = r0.size()     // Catch:{ all -> 0x009e }
            if (r0 > 0) goto L_0x002a
            goto L_0x0017
        L_0x002a:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x009e }
            r0.<init>()     // Catch:{ all -> 0x009e }
            java.lang.String r2 = "key_pref_cover_sticker_refresh_last_time"
            r0.append(r2)     // Catch:{ all -> 0x009e }
            r0.append(r7)     // Catch:{ all -> 0x009e }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x009e }
            com.introvd.template.common.AppPreferencesSetting r2 = com.introvd.template.common.AppPreferencesSetting.getInstance()     // Catch:{ all -> 0x009e }
            java.lang.String r3 = ""
            java.lang.String r2 = r2.getAppSettingStr(r0, r3)     // Catch:{ all -> 0x009e }
            if (r1 != 0) goto L_0x006b
            boolean r1 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x009e }
            if (r1 != 0) goto L_0x006b
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x009e }
            long r1 = com.p131c.p132a.p135c.C2575a.parseLong(r2)     // Catch:{ all -> 0x009e }
            r5 = 0
            long r3 = r3 - r1
            long r1 = java.lang.Math.abs(r3)     // Catch:{ all -> 0x009e }
            r3 = 3600000(0x36ee80, double:1.7786363E-317)
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 <= 0) goto L_0x0063
            goto L_0x006b
        L_0x0063:
            android.os.Handler r7 = r6.mHandler     // Catch:{ all -> 0x009e }
            r0 = 10005(0x2715, float:1.402E-41)
            r7.sendEmptyMessage(r0)     // Catch:{ all -> 0x009e }
            goto L_0x009c
        L_0x006b:
            boolean r1 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x009e }
            if (r1 == 0) goto L_0x0089
            com.introvd.template.q.f r7 = com.introvd.template.p374q.C8347f.aKf()     // Catch:{ all -> 0x009e }
            java.lang.String r1 = "template.packages.info"
            com.introvd.template.editor.advance.n$10 r2 = new com.introvd.template.editor.advance.n$10     // Catch:{ all -> 0x009e }
            r2.<init>(r0)     // Catch:{ all -> 0x009e }
            r7.mo33601a(r1, r2)     // Catch:{ all -> 0x009e }
            android.content.Context r7 = r6.mContext     // Catch:{ all -> 0x009e }
            java.lang.String r0 = ""
            java.lang.String r1 = "cover_text"
            com.introvd.template.p374q.C8346e.m24071T(r7, r0, r1)     // Catch:{ all -> 0x009e }
            goto L_0x009c
        L_0x0089:
            com.introvd.template.q.f r1 = com.introvd.template.p374q.C8347f.aKf()     // Catch:{ all -> 0x009e }
            java.lang.String r2 = "template.packages.detail"
            com.introvd.template.editor.advance.n$2 r3 = new com.introvd.template.editor.advance.n$2     // Catch:{ all -> 0x009e }
            r3.<init>(r0)     // Catch:{ all -> 0x009e }
            r1.mo33601a(r2, r3)     // Catch:{ all -> 0x009e }
            android.content.Context r0 = r6.mContext     // Catch:{ all -> 0x009e }
            com.introvd.template.p374q.C8346e.m24075cq(r0, r7)     // Catch:{ all -> 0x009e }
        L_0x009c:
            monitor-exit(r6)
            return
        L_0x009e:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.editor.advance.C5640n.m15573gq(java.lang.String):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: kT */
    public String m15578kT(int i) {
        if (this.cxP == null || this.cxP.isEmpty() || i < 0) {
            return "";
        }
        StyleCatItemModel styleCatItemModel = (StyleCatItemModel) this.cxP.get(i);
        return styleCatItemModel != null ? styleCatItemModel.ttid : "";
    }

    /* renamed from: a */
    public void mo27685a(C5652o oVar) {
        this.cxR = oVar;
    }

    /* renamed from: a */
    public void mo27686a(TemplateInfo templateInfo, int i) {
        if (templateInfo != null) {
            int indexOf = this.cwH.indexOf(templateInfo);
            if (indexOf >= 0) {
                TemplateInfo templateInfo2 = (TemplateInfo) this.cwH.get(indexOf);
                if (templateInfo2 != null && templateInfo2.nState == 1) {
                    templateInfo2.nState = 8;
                    this.cwM.mo27525ay(this.cwH);
                }
            }
        }
    }

    public void adI() {
        this.cxa = -1;
        if (this.cwL != null) {
            this.cwL.mo27533kP(this.cxa);
            this.cwL.acE();
        }
        if (this.cwM != null) {
            this.cwM.mo27526gf("");
            this.cwM.notifyDataSetChanged();
        }
    }

    public void ade() {
        if (this.cxT != null) {
            this.cxT.dispose();
        }
    }

    /* renamed from: gl */
    public void mo27689gl(String str) {
        String kT = m15578kT(this.cxb);
        if (m15572gp(kT)) {
            if (this.cwM != null) {
                this.cwM.mo27526gf(C8450a.m24469bn(C2575a.m7391rq(str)));
                this.cwM.notifyDataSetChanged();
            }
            this.cwW.ack();
            m15563b(this.cwU, str);
        } else {
            C8746a.m25570c(this.cwU, str);
            this.cwW.mo27472a(this.mContext, false, C8762d.m25613a(kT, (List<TemplateInfo>[]) new List[]{this.cwS, this.cwR}), kT);
        }
        if (TextUtils.equals(str, kT)) {
            m15569el(false);
        }
    }

    /* renamed from: q */
    public void mo27690q(final boolean z, final boolean z2) {
        this.cxT = C1834l.m5254a((C1839n<T>) new C1839n<Boolean>() {
            /* renamed from: a */
            public void mo10177a(C1838m<Boolean> mVar) throws Exception {
                C5640n.this.adJ();
                mVar.mo9791K(Boolean.valueOf(true));
            }
        }).mo10157d(C1820a.aVi()).mo10152c(C1487a.aUa()).mo10168g((C1517e<? super T>) new C1517e<Boolean>() {
            /* renamed from: d */
            public void accept(Boolean bool) throws Exception {
                C5640n.this.adi();
                if (z) {
                    C5640n.this.adj();
                }
                C5640n.this.m15569el(z2);
            }
        });
    }

    /* renamed from: v */
    public void mo27691v(String str, int i) {
        boolean z;
        if (this.cxP != null) {
            String kT = m15578kT(this.cxb);
            if (this.cwK != null && this.cxb >= 0 && this.cxb < this.cwU.size() && TextUtils.equals(kT, str)) {
                z = true;
                this.cwW.mo27474c(str, i, z);
            }
        }
        z = false;
        this.cwW.mo27474c(str, i, z);
    }
}
