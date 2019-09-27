package com.introvd.template.template.widget.p412a;

import android.content.Context;
import android.text.TextUtils;
import com.introvd.template.VivaBaseApplication;
import com.introvd.template.common.LogUtils;
import com.introvd.template.module.iap.C8049f;
import com.introvd.template.p203b.C4580b;
import com.introvd.template.sdk.model.editor.EffectInfoModel;
import com.introvd.template.sdk.model.editor.TemplateItemData;
import com.introvd.template.sdk.model.template.RollInfo;
import com.introvd.template.sdk.model.template.TemplateInfo;
import com.introvd.template.sdk.p383c.C8399c;
import com.introvd.template.template.R;
import com.introvd.template.template.p407e.C8735f;
import com.introvd.template.template.p407e.C8738h;
import com.introvd.template.template.p407e.C8739i;
import com.introvd.template.template.p407e.C8743l;
import com.introvd.template.template.p407e.C8745n;
import com.introvd.template.template.p409g.C8759b;
import com.introvd.template.template.p409g.C8762d;
import com.introvd.template.template.widget.p412a.p413a.C8924d;
import com.introvd.template.template.widget.p412a.p413a.C8927g;
import com.p131c.p132a.C2561a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: com.introvd.template.template.widget.a.c */
public class C8937c {
    public static final int euS = R.drawable.xiaoying_cam_thumbnail_filter_local_default_1;
    public static final int euT = R.drawable.xiaoying_cam_thumbnail_filter_local_beauty;
    public static final int euU = R.drawable.xiaoying_cam_thumbnail_filter_local_default_2;
    private static ArrayList<Long> euV = new ArrayList<>();
    private static ArrayList<Long> euW = new ArrayList<>();
    private static ArrayList<Long> euX = new ArrayList<>();
    private static C8937c euY;
    private C8759b bOt;
    private List<TemplateInfo> cwR;
    private List<TemplateInfo> cwS;
    private List<Long> euZ = new ArrayList();
    private ArrayList<String> eva;
    private ArrayList<C8927g> evb;
    private Map<String, ArrayList<Long>> evc;
    private String evd = "0";
    private List<Long> eve;
    private Context mContext = VivaBaseApplication.m8749FZ().getApplicationContext();

    static {
        euW.add(Long.valueOf(288230376151711975L));
        euW.add(Long.valueOf(288230376151711976L));
        euW.add(Long.valueOf(288230376151711977L));
        euW.add(Long.valueOf(288230376151711978L));
        euW.add(Long.valueOf(288230376151711979L));
        euW.add(Long.valueOf(288230376151711980L));
        euV.add(Long.valueOf(288230376151711968L));
        euV.add(Long.valueOf(288230376151711969L));
        euV.add(Long.valueOf(288230376151711970L));
        euV.add(Long.valueOf(288230376151711971L));
        euV.add(Long.valueOf(288230376151711972L));
        euV.add(Long.valueOf(288230376151711973L));
        euV.add(Long.valueOf(288230376151711974L));
        euX.add(Long.valueOf(288230376152760347L));
        euX.add(Long.valueOf(288230376152760348L));
        euX.add(Long.valueOf(288230376152760351L));
        euX.add(Long.valueOf(288230376152760352L));
        euX.add(Long.valueOf(288230376152760346L));
        euX.add(Long.valueOf(288230376152760349L));
        euX.add(Long.valueOf(288230376152760350L));
    }

    private C8937c() {
    }

    /* renamed from: a */
    private C8927g m26262a(int i, C8938d dVar, String str, boolean z) {
        C8927g gVar = new C8927g();
        gVar.mo35525a(dVar);
        gVar.setSelected(z);
        gVar.mo35542qV(str);
        gVar.mo35549vy(i);
        gVar.mo35547vA(2);
        gVar.mo35548vB(2);
        gVar.mo35535de(new ArrayList());
        return gVar;
    }

    /* renamed from: a */
    private void m26263a(ArrayList<C8927g> arrayList, C8927g gVar) {
        if (gVar.getChildList() != null && gVar.getChildList().size() > 0) {
            if (!arrayList.contains(gVar)) {
                arrayList.add(gVar);
                return;
            }
            int indexOf = arrayList.indexOf(gVar);
            if (indexOf >= 0) {
                C8927g gVar2 = (C8927g) arrayList.get(indexOf);
                gVar2.mo35548vB(2);
                gVar2.mo35540jI(false);
                gVar2.mo35547vA(2);
            }
        }
    }

    /* renamed from: a */
    private boolean m26264a(String str, RollInfo rollInfo) {
        boolean z = false;
        if (rollInfo == null || rollInfo.rollModel == null) {
            return false;
        }
        boolean z2 = "3".equals(this.evd) ? "0".equals(rollInfo.rollModel.strSubType) || "2".equals(rollInfo.rollModel.strSubType) : str.equals(rollInfo.rollModel.strSubType);
        if (z2 && (rollInfo.isRecommendItem() || C8745n.m25561qv(rollInfo.rollModel.rollCode))) {
            z = true;
        }
        return z;
    }

    public static synchronized C8937c aMA() {
        C8937c cVar;
        synchronized (C8937c.class) {
            if (euY == null) {
                euY = new C8937c();
            }
            cVar = euY;
        }
        return cVar;
    }

    private C8927g aMD() {
        C8927g gVar = new C8927g();
        C8738h hVar = new C8738h();
        if (hVar.mo35164he(this.mContext) > 0) {
            gVar.mo35541qU("20180205753951");
            gVar.mo35525a(C8938d.GROUP);
            gVar.mo35542qV("测试组");
            gVar.mo35549vy(R.drawable.xiaoying_com_clip_dft_thumb);
            gVar.mo35540jI(false);
            gVar.mo35547vA(2);
            gVar.mo35548vB(2);
            List<TemplateItemData> hk = hVar.mo35170hk(this.mContext);
            ArrayList arrayList = new ArrayList();
            for (TemplateItemData templateItemData : hk) {
                C8924d dVar = new C8924d();
                dVar.setTemplateId(templateItemData.lID);
                if (!TextUtils.isEmpty(templateItemData.strTitle)) {
                    dVar.mo35514qT(templateItemData.strTitle);
                } else {
                    dVar.mo35514qT("TEST");
                }
                arrayList.add(dVar);
                this.euZ.add(Long.valueOf(templateItemData.lID));
            }
            gVar.mo35535de(arrayList);
        }
        return gVar;
    }

    /* renamed from: c */
    private void m26265c(Map<String, ArrayList<Long>> map, String str) {
        if (C8745n.m25561qv(str)) {
            List qw = C8745n.m25562qw(str);
            if (qw != null && qw.size() > 0) {
                map.put(str, (ArrayList) qw);
                this.eve.addAll(qw);
                return;
            }
            return;
        }
        map.put(str, new ArrayList());
    }

    /* renamed from: cO */
    public static int m26266cO(Context context, String str) {
        int i = 0;
        if (!C8739i.m25526qq(str) && !C8739i.m25527qr(str)) {
            i = 2;
        }
        if (C8049f.aBf().isNeedToPurchase(str)) {
            return 3;
        }
        return i;
    }

    /* renamed from: dd */
    private List<C8924d> m26267dd(List<Long> list) {
        ArrayList arrayList = new ArrayList();
        for (Long l : list) {
            EffectInfoModel bw = this.bOt.mo35204bw(l.longValue());
            if (bw != null) {
                C8924d dVar = new C8924d();
                dVar.setTemplateId(l.longValue());
                dVar.mo35514qT(bw.mName);
                arrayList.add(dVar);
            }
        }
        return arrayList;
    }

    /* renamed from: f */
    private List<String> m26268f(List<TemplateInfo> list, String str) {
        ArrayList arrayList = new ArrayList();
        for (TemplateInfo templateInfo : list) {
            if (templateInfo instanceof RollInfo) {
                RollInfo rollInfo = (RollInfo) templateInfo;
                if (m26264a(str, rollInfo)) {
                    arrayList.add(rollInfo.rollModel.rollCode);
                }
            }
        }
        return arrayList;
    }

    /* renamed from: qN */
    private boolean m26269qN(String str) {
        return "20170518964283".equals(str) || "20170518964351".equals(str) || "20170518964246".equals(str);
    }

    /* renamed from: qR */
    public static int m26270qR(String str) {
        return C8745n.m25561qv(str) ? 2 : 0;
    }

    /* renamed from: vt */
    private C8927g m26271vt(int i) {
        C8927g gVar = new C8927g();
        String vv = m26273vv(i);
        gVar.mo35541qU(vv);
        gVar.mo35525a(C8938d.GROUP);
        gVar.mo35542qV(m26274vw(i));
        gVar.mo35549vy(m26272vu(i));
        gVar.mo35540jI(false);
        gVar.mo35547vA(2);
        gVar.mo35548vB(2);
        List list = (List) this.evc.get(vv);
        if (list != null && list.size() > 0) {
            gVar.mo35535de(m26267dd(list));
        }
        return gVar;
    }

    /* renamed from: vu */
    private int m26272vu(int i) {
        return i == 2 ? euU : i == 1 ? euS : euT;
    }

    /* renamed from: vv */
    private String m26273vv(int i) {
        return i == 2 ? "20170518964351" : i == 1 ? "20170518964283" : "20170518964246";
    }

    /* renamed from: vw */
    private String m26274vw(int i) {
        return C4580b.m11633Sg() ? i == 2 ? "生活" : i == 1 ? "风景" : "生色" : C4580b.m11660eF("ar") ? i == 2 ? "نمط الحياة" : i == 1 ? "الطبيعة" : "مشرق" : i == 2 ? "Lifestyle" : i == 1 ? "Landscape" : "Adom";
    }

    /* renamed from: vx */
    private boolean m26275vx(int i) {
        return (i & 1) == 1;
    }

    public void aMB() {
        C8745n.updateRollTemplateMapInfo(this.mContext);
    }

    public ArrayList<C8927g> aMC() {
        this.evb = new ArrayList<>();
        String string = this.mContext.getResources().getString(R.string.xiaoying_str_cam_filter_origin_title);
        if (this.evd.equals("0") || this.evd.equals("3")) {
            String string2 = this.mContext.getResources().getString(R.string.xiaoying_str_template_get_more);
            int i = R.drawable.xiaoying_cam_thumb_filter_none;
            this.evb.add(m26262a(i, C8938d.STORE, string2, false));
            this.evb.add(m26262a(i, C8938d.SINGLE, string, true));
        } else if (this.evd.equals("2")) {
            this.evb.add(m26262a(R.drawable.xiaoying_cam_thumb_filter_beauty_none, C8938d.SINGLE, string, true));
        }
        Iterator it = this.eva.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            RollInfo rollInfo = (RollInfo) mo35575qP(str);
            if (rollInfo != null) {
                C8927g gVar = new C8927g();
                gVar.mo35541qU(str);
                gVar.mo35525a(C8938d.GROUP);
                gVar.mo35542qV(rollInfo.strTitle);
                String str2 = rollInfo.rollModel.mRollIconInfo.mBigIconUrl;
                if (TextUtils.isEmpty(str2)) {
                    str2 = rollInfo.rollModel.mRollIconInfo.mIconUrl;
                }
                gVar.mo35543qW(str2);
                gVar.mo35540jI(m26275vx(rollInfo.nMark));
                gVar.mo35547vA(m26266cO(this.mContext, str));
                gVar.mo35548vB(m26270qR(str));
                List list = (List) this.evc.get(str);
                if (list != null) {
                    gVar.mo35535de(m26267dd(list));
                    this.evb.add(gVar);
                }
            }
        }
        C8927g vt = m26271vt(2);
        C8927g vt2 = m26271vt(1);
        C8927g vt3 = m26271vt(0);
        C8927g aMD = aMD();
        if ("0".equals(this.evd)) {
            m26263a(this.evb, vt);
            m26263a(this.evb, vt2);
            if (aMD.getChildList() != null && aMD.getChildList().size() > 0) {
                this.evb.add(aMD);
            }
        } else if ("2".equals(this.evd)) {
            m26263a(this.evb, vt3);
        } else if ("3".equals(this.evd)) {
            m26263a(this.evb, vt);
            m26263a(this.evb, vt2);
            m26263a(this.evb, vt3);
        }
        return this.evb;
    }

    /* renamed from: e */
    public Long mo35572e(long j, boolean z) {
        int i = 0;
        while (true) {
            if (i >= this.eve.size()) {
                i = 0;
                break;
            } else if (j == ((Long) this.eve.get(i)).longValue()) {
                break;
            } else {
                i++;
            }
        }
        if (z) {
            int i2 = i + 1;
            for (int i3 = i2; i3 <= this.eve.size() - 1; i3++) {
                EffectInfoModel vh = this.bOt.mo35214vh(this.bOt.mo35205bx(((Long) this.eve.get(i3)).longValue()));
                if (vh != null && !vh.isbNeedDownload()) {
                    return Long.valueOf(((Long) this.eve.get(i3)).longValue());
                }
            }
            for (int i4 = 0; i4 <= i2; i4++) {
                EffectInfoModel vh2 = this.bOt.mo35214vh(this.bOt.mo35205bx(((Long) this.eve.get(i4)).longValue()));
                if (vh2 != null && !vh2.isbNeedDownload()) {
                    return Long.valueOf(((Long) this.eve.get(i4)).longValue());
                }
            }
        } else {
            int i5 = i - 1;
            for (int i6 = i5; i6 >= 0; i6--) {
                EffectInfoModel vh3 = this.bOt.mo35214vh(this.bOt.mo35205bx(((Long) this.eve.get(i6)).longValue()));
                if (vh3 != null && !vh3.isbNeedDownload()) {
                    return Long.valueOf(((Long) this.eve.get(i6)).longValue());
                }
            }
            for (int size = this.eve.size() - 1; size >= i5; size--) {
                EffectInfoModel vh4 = this.bOt.mo35214vh(this.bOt.mo35205bx(((Long) this.eve.get(size)).longValue()));
                if (vh4 != null && !vh4.isbNeedDownload()) {
                    return Long.valueOf(((Long) this.eve.get(size)).longValue());
                }
            }
        }
        return Long.valueOf(0);
    }

    /* renamed from: qM */
    public void mo35573qM(String str) {
        this.evd = str;
        this.eve = new ArrayList();
        this.cwR = C8735f.aMf().mo35151qk(C8399c.ecY);
        this.cwS = C8743l.m25552cI(this.mContext, C8399c.ecY);
        ArrayList<String> arrayList = new ArrayList<>();
        this.evc = new HashMap();
        if (C2561a.aOR() == 1 || C2561a.aON()) {
            if ("0".equals(this.evd)) {
                this.evc.put("20170518964351", euV);
                this.evc.put("20170518964283", euW);
            } else if ("2".equals(this.evd)) {
                this.evc.put("20170518964246", euX);
            } else if ("3".equals(this.evd)) {
                this.evc.put("20170518964351", euV);
                this.evc.put("20170518964283", euW);
                this.evc.put("20170518964246", euX);
            }
        }
        arrayList.addAll(m26268f(this.cwS, this.evd));
        for (String str2 : m26268f(this.cwR, this.evd)) {
            if (!arrayList.contains(str2)) {
                arrayList.add(str2);
            }
        }
        this.eve.add(Long.valueOf(this.bOt.mo35215vi(0)));
        if (C2561a.aOR() == 1 || C2561a.aON()) {
            if ("0".equals(this.evd)) {
                this.eve.addAll(euV);
                this.eve.addAll(euW);
            } else if ("2".equals(this.evd)) {
                this.eve.addAll(euX);
            } else if ("3".equals(this.evd)) {
                this.eve.addAll(euX);
                this.eve.addAll(euW);
                this.eve.addAll(euV);
            }
        }
        this.eva = arrayList;
        Iterator it = this.eva.iterator();
        while (it.hasNext()) {
            String str3 = (String) it.next();
            if (!m26269qN(str3)) {
                m26265c(this.evc, str3);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("mFilterCodeList:size==");
        sb.append(this.eve.size());
        LogUtils.m14222e("FilterTemplateUIManager", sb.toString());
    }

    /* renamed from: qO */
    public boolean mo35574qO(String str) {
        return this.euZ.contains(Long.valueOf(C8759b.m25587jf(str)));
    }

    /* renamed from: qP */
    public TemplateInfo mo35575qP(String str) {
        return C8762d.m25613a(str, (List<TemplateInfo>[]) new List[]{this.cwR, this.cwS});
    }

    /* renamed from: qQ */
    public List<Long> mo35576qQ(String str) {
        return (List) this.evc.get(str);
    }

    public void setEffectMgr(C8759b bVar) {
        if (bVar != null) {
            this.bOt = bVar;
        }
    }
}
