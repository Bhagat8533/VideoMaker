package com.introvd.template.editor.effects.bubble.subtitle;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.support.p024v7.widget.GridLayoutManager;
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
import com.introvd.template.editor.effects.bubble.p255a.C5920b;
import com.introvd.template.editor.effects.bubble.p255a.C5920b.C5922a;
import com.introvd.template.editor.effects.bubble.p255a.C5938f;
import com.introvd.template.editor.effects.bubble.p255a.C5938f.C5940a;
import com.introvd.template.editor.p266h.C6375c;
import com.introvd.template.p203b.C4580b;
import com.introvd.template.p203b.C4583d;
import com.introvd.template.p203b.C4600l;
import com.introvd.template.sdk.model.editor.EffectInfoModel;
import com.introvd.template.sdk.model.editor.StoryBoardItemInfo;
import com.introvd.template.sdk.model.template.RollIconInfo;
import com.introvd.template.sdk.model.template.RollInfo;
import com.introvd.template.sdk.model.template.RollXytInfo;
import com.introvd.template.sdk.model.template.TemplateInfo;
import com.introvd.template.sdk.p383c.C8399c;
import com.introvd.template.sdk.p391g.C8450a;
import com.introvd.template.template.model.StoryBoardXytItemInfo;
import com.introvd.template.template.model.StyleCatItemModel;
import com.introvd.template.template.p407e.C8735f;
import com.introvd.template.template.p407e.C8744m;
import com.introvd.template.template.p407e.C8745n;
import com.introvd.template.template.p408f.C8746a;
import com.introvd.template.template.p409g.C8759b;
import com.introvd.template.template.p409g.C8762d;
import com.p131c.p132a.C2561a;
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

/* renamed from: com.introvd.template.editor.effects.bubble.subtitle.d */
public class C6009d {
    /* access modifiers changed from: private */
    public RelativeLayout bWd;
    /* access modifiers changed from: private */
    public C5920b cHG;
    /* access modifiers changed from: private */
    public C6000a cHH;
    private C5940a cHI = new C5940a() {
        /* renamed from: z */
        public void mo28568z(View view, int i) {
            C6009d.this.cxb = i;
            C6009d.this.cHl.mo28566kP(C6009d.this.cxb);
            C6009d.this.ajx();
            if (C6009d.this.cxb < C6009d.this.cwV.size()) {
                String str = ((StyleCatItemModel) C6009d.this.cwV.get(C6009d.this.cxb)).ttid;
                boolean z = false;
                TemplateInfo a = C8762d.m25613a(str, (List<TemplateInfo>[]) new List[]{C6009d.this.cwS, C6009d.this.cwR});
                List list = (List) C6009d.this.cwU.get(str);
                C5919a m = C6009d.this.cHp;
                Context context = C6009d.this.bWd.getContext();
                if (list != null && list.size() > 0) {
                    z = true;
                }
                m.mo28526a(context, z, a, str);
            }
        }
    };
    private C5922a cHJ = new C5922a() {
        /* renamed from: z */
        public void mo28536z(View view, int i) {
            if (!C4580b.m11632Sf() && C6009d.this.cwK != null && C6009d.this.cwG != null) {
                StoryBoardItemInfo storyBoardItemInfo = (StoryBoardItemInfo) C6009d.this.cwG.get(i);
                if (storyBoardItemInfo != null) {
                    EffectInfoModel effectInfoModel = storyBoardItemInfo.mEffectInfo;
                    if (effectInfoModel != null && effectInfoModel.isbNeedDownload()) {
                        if (C6009d.this.cHH != null) {
                            C6009d.this.cHH.mo28680c(effectInfoModel);
                        }
                        return;
                    }
                }
                if (i != C6009d.this.cxa) {
                    if (!(C6009d.this.cHH == null || C6009d.this.cww == null || storyBoardItemInfo == null || storyBoardItemInfo.mEffectInfo == null)) {
                        int bx = C6009d.this.cww.mo35205bx(storyBoardItemInfo.mEffectInfo.mTemplateId);
                        if (C6009d.this.cHH.mo28682mx(bx)) {
                            C6009d.this.cHH.mo28681kX(bx);
                            if (C6009d.this.cHG != null) {
                                C6009d.this.cHG.mo28534kP(i);
                            }
                            C6009d.this.cxa = i;
                        }
                    }
                } else if (!(C6009d.this.cHH == null || C6009d.this.cww == null || storyBoardItemInfo == null || storyBoardItemInfo.mEffectInfo == null)) {
                    int bx2 = C6009d.this.cww.mo35205bx(storyBoardItemInfo.mEffectInfo.mTemplateId);
                    if (C6009d.this.cHH.mo28682mx(bx2)) {
                        C6009d.this.cHH.mo28681kX(bx2);
                    }
                }
            }
        }
    };
    /* access modifiers changed from: private */
    public C5938f cHl;
    private RecyclerView cHm;
    /* access modifiers changed from: private */
    public C5919a cHp;
    /* access modifiers changed from: private */
    public ArrayList<StoryBoardItemInfo> cwG;
    /* access modifiers changed from: private */
    public RecyclerView cwK;
    /* access modifiers changed from: private */
    public List<TemplateInfo> cwR;
    /* access modifiers changed from: private */
    public List<TemplateInfo> cwS;
    /* access modifiers changed from: private */
    public Map<String, List<Long>> cwU;
    /* access modifiers changed from: private */
    public ArrayList<StyleCatItemModel> cwV;
    /* access modifiers changed from: private */
    public C8759b cww;
    /* access modifiers changed from: private */
    public int cxa = 0;
    /* access modifiers changed from: private */
    public int cxb = -1;
    private OnClickListener cxj = new OnClickListener() {
        public void onClick(View view) {
            if (C4600l.m11739k(VivaBaseApplication.m8749FZ(), true) && C6009d.this.cxb >= 0 && C6009d.this.cwV.size() > 0 && C6009d.this.cxb < C6009d.this.cwV.size()) {
                TemplateInfo a = C8762d.m25613a(((StyleCatItemModel) C6009d.this.cwV.get(C6009d.this.cxb)).ttid, (List<TemplateInfo>[]) new List[]{C6009d.this.cwS, C6009d.this.cwR});
                if (C6009d.this.cHH != null) {
                    C6009d.this.cHH.mo28679b((RollInfo) a);
                }
            }
        }
    };

    public C6009d(RelativeLayout relativeLayout) {
        this.bWd = relativeLayout;
        RelativeLayout relativeLayout2 = (RelativeLayout) this.bWd.findViewById(R.id.relative_layout_roll_download);
        this.cHp = new C5919a(relativeLayout2, this.cxj);
        this.cwK = (RecyclerView) this.bWd.findViewById(R.id.rv_anim_text);
        final Context context = this.cwK.getContext();
        this.cHG = new C5920b(context);
        this.cwK.setLayoutManager(new GridLayoutManager(this.bWd.getContext(), 2, 0, false));
        this.cwK.mo7733a((C1018h) new C1018h() {
            public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, C1031r rVar) {
                rect.left = C4583d.m11670O(context, 10);
                rect.right = C4583d.m11670O(context, 10);
            }
        });
        relativeLayout2.setVisibility(8);
        this.cHG.mo28530a(this.cHJ);
        this.cHm = (RecyclerView) this.bWd.findViewById(R.id.rv_bubble_tab);
        this.cHm.setLayoutManager(new LinearLayoutManager(this.bWd.getContext(), 0, false));
    }

    /* renamed from: a */
    private static StoryBoardXytItemInfo m16985a(C8759b bVar, Long l, boolean z) {
        StoryBoardXytItemInfo storyBoardXytItemInfo = new StoryBoardXytItemInfo();
        storyBoardXytItemInfo.mEffectInfo = bVar.mo35204bw(l.longValue());
        if (C8450a.m24466bk(l.longValue())) {
            storyBoardXytItemInfo.mBubbleType = 1;
            storyBoardXytItemInfo.mThumbPath = C8762d.aMt().getTemplateExternalFile(l.longValue(), 0, 3);
        } else if (z) {
            Bitmap bz = bVar.mo35206bz(l.longValue());
            if (bz != null) {
                storyBoardXytItemInfo.bmpThumbnail = bz;
            }
        } else {
            storyBoardXytItemInfo.bSyncThumb = false;
        }
        storyBoardXytItemInfo.lTemplateId = l.longValue();
        storyBoardXytItemInfo.isVideo = false;
        storyBoardXytItemInfo.lDuration = 0;
        return storyBoardXytItemInfo;
    }

    /* renamed from: aI */
    private void m16987aI(List<Long> list) {
        if (this.cww != null && list != null && list.size() > 0) {
            for (Long a : list) {
                this.cwG.add(m16985a(this.cww, a, true));
            }
        }
    }

    /* access modifiers changed from: private */
    public void adi() {
        if (this.cHl != null) {
            this.cHl.mItemInfoList = this.cwV;
        } else {
            this.cHl = new C5938f(this.bWd.getContext(), this.cwV, true);
        }
        this.cHm.setAdapter(this.cHl);
        this.cHl.mo28562a(this.cHI);
    }

    /* access modifiers changed from: private */
    public void adj() {
        if (this.cHH != null && this.cww != null && this.cHm != null && this.cwV != null) {
            EffectInfoModel vh = this.cww.mo35214vh(this.cHH.adF());
            if (vh != null) {
                this.cxb = C8746a.m25564a(vh.mTemplateId, (List<StyleCatItemModel>) this.cwV, this.cwU);
            }
            boolean z = false;
            if (this.cxb < 0) {
                this.cxb = 0;
            }
            this.cHl.mo28566kP(this.cxb);
            if (this.cxb >= 0 && this.cxb < this.cwV.size()) {
                String str = ((StyleCatItemModel) this.cwV.get(this.cxb)).ttid;
                TemplateInfo a = C8762d.m25613a(str, (List<TemplateInfo>[]) new List[]{this.cwS, this.cwR});
                List list = (List) this.cwU.get(str);
                C5919a aVar = this.cHp;
                Context context = this.bWd.getContext();
                if (list != null && list.size() > 0) {
                    z = true;
                }
                aVar.mo28526a(context, z, a, str);
            }
            this.cHm.scrollToPosition(this.cxb);
            this.cHl.notifyItemChanged(this.cxb);
        }
    }

    /* access modifiers changed from: private */
    public void ajE() {
        C8745n.updateRollTemplateMapInfo(VivaBaseApplication.m8749FZ().getApplicationContext());
        this.cwS = C6375c.asF().asM();
        this.cwR = C8735f.aMf().mo35151qk(C8399c.edb);
        ArrayList<StyleCatItemModel> arrayList = new ArrayList<>();
        if (C2561a.aOR() == 1 || C2561a.aON()) {
            String str = "20171207865423";
            arrayList.add(new StyleCatItemModel(1, str, C8744m.m25555qu(str)));
        }
        List c = C8746a.m25569c(this.cwS, true, false);
        arrayList.addAll(c);
        List c2 = C8746a.m25569c(this.cwR, true, true);
        c2.removeAll(c);
        arrayList.addAll(c2);
        this.cwV = arrayList;
        this.cwU = new HashMap();
        if (C2561a.aOR() == 1) {
            this.cwU.put("20171207865423", C8744m.ett);
        }
        Iterator it = this.cwV.iterator();
        while (it.hasNext()) {
            C8746a.m25570c(this.cwU, ((StyleCatItemModel) it.next()).ttid);
        }
        C8745n.m25559dc(new ArrayList(this.cwU.keySet()));
    }

    /* access modifiers changed from: private */
    public void ajx() {
        if (this.cwV != null && this.cxb < this.cwV.size() && this.cxb >= 0 && this.cwK != null) {
            String str = ((StyleCatItemModel) this.cwV.get(this.cxb)).ttid;
            List list = (List) this.cwU.get(str);
            this.cxa = m16990c(list, this.cww.mo35210qG(this.cHH.adF()));
            if (this.cwG == null) {
                this.cwG = new ArrayList<>();
            } else {
                this.cwG.clear();
            }
            if (list == null || list.size() <= 0) {
                ArrayList l = m17001l(C8762d.m25613a(str, (List<TemplateInfo>[]) new List[]{this.cwS, this.cwR}));
                if (l != null && l.size() > 0) {
                    this.cwG.addAll(l);
                }
            } else {
                m16987aI(list);
            }
            this.cwK.setAdapter(this.cHG);
            this.cHG.mo28533h(this.cwG);
            this.cHG.mo28534kP(this.cxa);
        }
    }

    /* renamed from: c */
    private int m16990c(List<Long> list, String str) {
        if (FileUtils.isFileExisted(str) && this.cww != null && list != null && list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                EffectInfoModel bw = this.cww.mo35204bw(((Long) list.get(i)).longValue());
                if (bw != null && TextUtils.equals(str, bw.mPath)) {
                    return i;
                }
            }
        }
        return -1;
    }

    /* renamed from: l */
    private static ArrayList<StoryBoardItemInfo> m17001l(TemplateInfo templateInfo) {
        ArrayList<StoryBoardItemInfo> arrayList = new ArrayList<>();
        if (templateInfo != null) {
            RollIconInfo rollIconInfo = ((RollInfo) templateInfo).rollModel.mRollIconInfo;
            if (!(rollIconInfo == null || rollIconInfo.mXytList == null)) {
                for (RollXytInfo rollXytInfo : rollIconInfo.mXytList) {
                    StoryBoardXytItemInfo storyBoardXytItemInfo = new StoryBoardXytItemInfo();
                    storyBoardXytItemInfo.mThumbPath = rollXytInfo.mXytIconUrl;
                    storyBoardXytItemInfo.isVideo = false;
                    storyBoardXytItemInfo.lDuration = 0;
                    arrayList.add(storyBoardXytItemInfo);
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public void mo28696a(C6000a aVar) {
        this.cHH = aVar;
    }

    /* renamed from: a */
    public void mo28697a(C8759b bVar) {
        this.cww = bVar;
    }

    public void adI() {
        this.cxa = -1;
        this.cHG.mo28534kP(this.cxa);
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x002e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.introvd.template.sdk.model.template.RollInfo ajv() {
        /*
            r5 = this;
            java.util.ArrayList<com.introvd.template.template.model.StyleCatItemModel> r0 = r5.cwV
            if (r0 == 0) goto L_0x004c
            java.util.ArrayList<com.introvd.template.template.model.StyleCatItemModel> r0 = r5.cwV
            int r0 = r0.size()
            if (r0 != 0) goto L_0x000d
            goto L_0x004c
        L_0x000d:
            com.introvd.template.editor.effects.bubble.subtitle.a r0 = r5.cHH
            int r0 = r0.adF()
            com.introvd.template.template.g.b r1 = r5.cww
            r2 = 0
            if (r1 == 0) goto L_0x002b
            com.introvd.template.template.g.b r1 = r5.cww
            com.introvd.template.sdk.model.editor.EffectInfoModel r0 = r1.mo35214vh(r0)
            if (r0 == 0) goto L_0x002b
            long r0 = r0.mTemplateId
            java.util.ArrayList<com.introvd.template.template.model.StyleCatItemModel> r3 = r5.cwV
            java.util.Map<java.lang.String, java.util.List<java.lang.Long>> r4 = r5.cwU
            int r0 = com.introvd.template.template.p408f.C8746a.m25564a(r0, r3, r4)
            goto L_0x002c
        L_0x002b:
            r0 = 0
        L_0x002c:
            if (r0 >= 0) goto L_0x002f
            r0 = 0
        L_0x002f:
            java.util.ArrayList<com.introvd.template.template.model.StyleCatItemModel> r1 = r5.cwV
            java.lang.Object r0 = r1.get(r0)
            com.introvd.template.template.model.StyleCatItemModel r0 = (com.introvd.template.template.model.StyleCatItemModel) r0
            java.lang.String r0 = r0.ttid
            r1 = 2
            java.util.List[] r1 = new java.util.List[r1]
            java.util.List<com.introvd.template.sdk.model.template.TemplateInfo> r3 = r5.cwS
            r1[r2] = r3
            r2 = 1
            java.util.List<com.introvd.template.sdk.model.template.TemplateInfo> r3 = r5.cwR
            r1[r2] = r3
            com.introvd.template.sdk.model.template.TemplateInfo r0 = com.introvd.template.template.p409g.C8762d.m25613a(r0, (java.util.List<com.introvd.template.sdk.model.template.TemplateInfo>[]) r1)
            com.introvd.template.sdk.model.template.RollInfo r0 = (com.introvd.template.sdk.model.template.RollInfo) r0
            return r0
        L_0x004c:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.editor.effects.bubble.subtitle.C6009d.ajv():com.introvd.template.sdk.model.template.RollInfo");
    }

    /* renamed from: fm */
    public void mo28700fm(final boolean z) {
        C1848s.m5326ai(Boolean.valueOf(true)).mo10194f(C1820a.aVi()).mo10199i(new C1518f<Boolean, Boolean>() {
            /* renamed from: c */
            public Boolean apply(Boolean bool) {
                C6009d.this.ajE();
                return Boolean.valueOf(true);
            }
        }).mo10194f(C1487a.aUa()).mo10188a((C1850u<? super T>) new C1810c<Boolean>() {
            /* renamed from: e */
            public void onSuccess(Boolean bool) {
                C6009d.this.adi();
                if (z) {
                    C6009d.this.adj();
                }
                C6009d.this.ajx();
            }

            public void onError(Throwable th) {
            }
        });
    }

    /* renamed from: gl */
    public void mo28701gl(String str) {
        if (this.cxb >= 0 && this.cwV.size() > 0 && this.cxb < this.cwV.size()) {
            String str2 = ((StyleCatItemModel) this.cwV.get(this.cxb)).ttid;
            C8746a.m25570c(this.cwU, str);
            if (TextUtils.equals(str, str2)) {
                if (this.cHH != null) {
                    this.cHH.ajB();
                }
                ajx();
            }
            this.cHp.mo28526a(this.bWd.getContext(), false, C8762d.m25613a(str2, (List<TemplateInfo>[]) new List[]{this.cwS, this.cwR}), str2);
            this.cHl.notifyItemChanged(this.cxb);
        }
    }

    /* renamed from: hg */
    public boolean mo28702hg(String str) {
        return !TextUtils.isEmpty(str) && this.cwV != null && this.cwV.size() > 0 && this.cwV.contains(new StyleCatItemModel(1, str, ""));
    }

    /* renamed from: v */
    public void mo28703v(String str, int i) {
        boolean z;
        if (this.cwV != null && this.cxb >= 0 && this.cxb < this.cwV.size()) {
            String str2 = ((StyleCatItemModel) this.cwV.get(this.cxb)).ttid;
            if (this.cwK != null && this.cxb >= 0 && this.cxb < this.cwU.size() && TextUtils.equals(str2, str)) {
                z = true;
                this.cHp.mo28528c(str, i, z);
            }
        }
        z = false;
        this.cHp.mo28528c(str, i, z);
    }
}
