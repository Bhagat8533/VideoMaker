package com.introvd.template.template.info.p410a;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import com.introvd.template.ads.entity.AdPositionInfoParam;
import com.introvd.template.ads.listener.ViewAdsListener;
import com.introvd.template.common.LogUtils;
import com.introvd.template.module.p326ad.C7680l;
import com.introvd.template.sdk.model.template.TemplateInfo;
import com.introvd.template.sdk.p383c.C8399c;
import com.introvd.template.template.R;
import com.introvd.template.template.info.item.C8896f;
import com.introvd.template.template.info.item.C8904h;
import com.introvd.template.template.model.TemplateGroupInfo;
import com.introvd.template.template.p407e.C8733e;
import com.introvd.template.template.p407e.C8733e.C8734a;
import com.introvd.template.template.p407e.C8735f;
import com.introvd.template.template.widget.TemplateGroupHeader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/* renamed from: com.introvd.template.template.info.a.f */
public class C8840f extends BaseAdapter {

    /* renamed from: FO */
    private ListView f3609FO;
    /* access modifiers changed from: private */
    public int bgQ = -1;
    private int dHd = 0;
    private ArrayList<C8842a> dHf = new ArrayList<>();
    private int diS = -1;
    private boolean diU = false;
    private String ekf;
    /* access modifiers changed from: private */
    public View epX;
    private boolean epY = true;
    private HashMap<String, Integer> epk = new HashMap<>();
    private Map<String, C8844c> epl = Collections.synchronizedMap(new LinkedHashMap());
    /* access modifiers changed from: private */
    public Context mContext;
    private Handler mHandler;

    /* renamed from: pX */
    private LayoutInflater f3610pX;

    /* renamed from: com.introvd.template.template.info.a.f$a */
    private class C8842a {
        int childNum;
        int childStartIndex;
        int groupIndex;
        boolean isFirstInGruop;
        boolean isLastInGroup;
        boolean showList;

        private C8842a() {
            this.isFirstInGruop = false;
            this.isLastInGroup = false;
        }
    }

    /* renamed from: com.introvd.template.template.info.a.f$b */
    class C8843b {
        RelativeLayout epS;
        TemplateGroupHeader epo;
        RelativeLayout epp;
        RelativeLayout epq;
        LinearLayout epr;
        RelativeLayout eps;
        ImageView epw;
        ImageView epx;
        C8896f eqa;
        C8896f eqb;
        C8896f eqc;
        C8904h eqd;

        C8843b() {
        }
    }

    /* renamed from: com.introvd.template.template.info.a.f$c */
    private class C8844c {
        int epy;
        int epz;

        /* renamed from: pf */
        int f3611pf;

        private C8844c() {
        }
    }

    public C8840f(Context context, C8734a aVar, String str) {
        this.mContext = context;
        this.f3610pX = LayoutInflater.from(context);
        C8733e.aMa().mo35126a(aVar);
        this.ekf = str;
        if (!TextUtils.isEmpty(str)) {
            this.bgQ = -1;
            if (str.equals(C8399c.ecX)) {
                this.epY = true;
                this.bgQ = 4;
            } else if (str.equals(C8399c.ecY)) {
                this.epY = true;
                this.bgQ = 5;
            } else if (str.equals(C8399c.ecZ)) {
                this.epY = true;
                this.bgQ = 6;
            } else if (str.equals(C8399c.edd)) {
                this.epY = false;
                this.bgQ = 10;
            } else if (str.equals(C8399c.ede)) {
                this.epY = false;
                this.bgQ = 11;
            }
            C7680l.aAe().mo32526aj(this.mContext, this.bgQ);
            C7680l.aAe().mo32531h(this.bgQ, new ViewAdsListener() {
                public void onAdLoaded(AdPositionInfoParam adPositionInfoParam, boolean z, String str) {
                    if (z) {
                        View adView = C7680l.aAe().getAdView(C8840f.this.mContext, C8840f.this.bgQ);
                        if (!(adView == null || adView == C8840f.this.epX)) {
                            C8840f.this.epX = adView;
                        }
                    }
                    C8840f.this.notifyDataSetChanged();
                }
            });
        }
    }

    /* renamed from: M */
    private void m25943M(int i, int i2, int i3) {
        try {
            List aMe = C8733e.aMa().aMe();
            if (aMe != null && i3 >= 0 && i3 < aMe.size()) {
                TemplateInfo templateInfo = (TemplateInfo) aMe.get(i);
                if (templateInfo != null) {
                    C8844c cVar = new C8844c();
                    cVar.f3611pf = i;
                    cVar.epy = i2;
                    cVar.epz = i3;
                    this.epl.put(templateInfo.ttid, cVar);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    private int m25944a(C8842a aVar) {
        return C8733e.aMa().mo35129dQ(aVar.groupIndex, aVar.childStartIndex);
    }

    /* renamed from: a */
    private void m25947a(C8843b bVar, C8842a aVar) {
        if (aVar.isFirstInGruop) {
            bVar.epw.setVisibility(0);
        } else {
            bVar.epw.setVisibility(8);
        }
        if (aVar.isLastInGroup) {
            bVar.epx.setVisibility(0);
        } else {
            bVar.epx.setVisibility(8);
        }
    }

    private boolean aLx() {
        return (this.epX == null || this.diS == -1) ? false : true;
    }

    private void aLy() {
        if (this.dHf != null) {
            this.dHf.clear();
        }
        int groupCount = getGroupCount();
        for (int i = 0; i < groupCount; i++) {
            int childrenCount = getChildrenCount(i);
            if (childrenCount <= 0) {
                this.dHd--;
            } else {
                TemplateGroupInfo vd = C8733e.aMa().mo35134vd(i);
                boolean z = vd.showList;
                if (vd.showGroup) {
                    C8842a aVar = new C8842a();
                    aVar.groupIndex = i;
                    aVar.childNum = 0;
                    aVar.showList = z;
                    this.dHf.add(aVar);
                }
                ArrayList arrayList = new ArrayList();
                if (z) {
                    int i2 = 0;
                    while (childrenCount > 0) {
                        C8842a aVar2 = new C8842a();
                        aVar2.groupIndex = i;
                        aVar2.childNum = 1;
                        aVar2.showList = z;
                        aVar2.childStartIndex = i2;
                        arrayList.add(aVar2);
                        childrenCount--;
                        i2++;
                    }
                } else {
                    int i3 = 0;
                    while (childrenCount >= 3) {
                        C8842a aVar3 = new C8842a();
                        aVar3.groupIndex = i;
                        aVar3.childNum = 3;
                        aVar3.childStartIndex = i3;
                        aVar3.showList = z;
                        arrayList.add(aVar3);
                        childrenCount -= 3;
                        i3 += 3;
                    }
                    if (childrenCount < 3 && childrenCount > 0) {
                        C8842a aVar4 = new C8842a();
                        aVar4.groupIndex = i;
                        aVar4.childNum = childrenCount;
                        aVar4.childStartIndex = i3;
                        aVar4.showList = z;
                        arrayList.add(aVar4);
                    }
                }
                if (arrayList.size() > 0) {
                    ((C8842a) arrayList.get(0)).isFirstInGruop = true;
                    ((C8842a) arrayList.get(arrayList.size() - 1)).isLastInGroup = true;
                }
                this.dHf.addAll(arrayList);
            }
        }
    }

    private void ayX() {
        this.dHd = 0;
        int groupCount = getGroupCount();
        for (int i = 0; i < groupCount; i++) {
            TemplateGroupInfo vd = C8733e.aMa().mo35134vd(i);
            int childrenCount = getChildrenCount(i);
            if (vd.showList) {
                this.dHd += childrenCount;
            } else if (childrenCount % 3 == 0) {
                this.dHd += childrenCount / 3;
            } else {
                this.dHd += (childrenCount / 3) + 1;
            }
            if (vd.showGroup) {
                this.dHd++;
            }
        }
        aLy();
    }

    private int getChildrenCount(int i) {
        return C8733e.aMa().mo35133vc(i);
    }

    private int getGroupCount() {
        return C8733e.aMa().getGroupCount();
    }

    /* renamed from: pv */
    private synchronized void m25950pv(int i) {
        if (this.epX != null && -1 == this.diS) {
            Random random = new Random();
            if (this.epY) {
                if (i >= 7) {
                    this.diS = random.nextInt(6) + 1;
                } else if (i > 0 && i < 7) {
                    this.diS = random.nextInt(i) + 1;
                }
            } else if (i >= 6) {
                this.diS = random.nextInt(5) + 2;
            } else if (i > 0 && i < 6) {
                this.diS = random.nextInt(i) + 2;
            }
        }
    }

    /* renamed from: U */
    public void mo35351U(String str, int i) {
        this.epk.put(str, Integer.valueOf(i));
    }

    /* renamed from: b */
    public void mo35352b(ListView listView) {
        this.f3609FO = listView;
    }

    /* renamed from: cV */
    public void mo35353cV(List<TemplateInfo> list) {
        mo35354d(list, false);
    }

    /* renamed from: d */
    public void mo35354d(List<TemplateInfo> list, boolean z) {
        LogUtils.m14223i("GroupGridAdapter", "doNotifyDataSetChanged <--");
        C8733e.aMa().mo35131j(this.mContext, list);
        ayX();
        if (z) {
            this.epX = C7680l.aAe().getAdView(this.mContext, this.bgQ);
            C7680l.aAe().mo32526aj(this.mContext, this.bgQ);
        }
        super.notifyDataSetChanged();
        LogUtils.m14223i("GroupGridAdapter", "doNotifyDataSetChanged -->");
    }

    public int getCount() {
        m25950pv(this.dHd);
        return this.dHd;
    }

    public Object getItem(int i) {
        return null;
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        C8843b bVar;
        if (!(this.epX == null || -1 == this.diS)) {
            if (this.diS == i) {
                if (!this.diU) {
                    this.diU = true;
                }
                return this.epX;
            } else if (i > this.diS) {
                i--;
            }
        }
        if (view == null || view.getTag() == null || (view.getTag() instanceof Integer)) {
            view = this.f3610pX.inflate(R.layout.v4_xiaoying_com_template_list_item, null);
            bVar = new C8843b();
            bVar.epo = (TemplateGroupHeader) view.findViewById(R.id.clip_title);
            bVar.epo.setHandler(this.mHandler);
            bVar.epr = (LinearLayout) view.findViewById(R.id.gridview);
            bVar.epp = (RelativeLayout) view.findViewById(R.id.clip_layout01);
            bVar.epq = (RelativeLayout) view.findViewById(R.id.clip_layout02);
            bVar.epS = (RelativeLayout) view.findViewById(R.id.clip_layout03);
            bVar.epw = (ImageView) view.findViewById(R.id.top_layout);
            bVar.epx = (ImageView) view.findViewById(R.id.bottom_layout);
            bVar.eps = (RelativeLayout) view.findViewById(R.id.listiew);
            bVar.eqa = new C8896f(this.mContext, bVar.epp);
            bVar.eqb = new C8896f(this.mContext, bVar.epq);
            bVar.eqc = new C8896f(this.mContext, bVar.epS);
            bVar.eqd = new C8904h(this.mContext, bVar.eps);
            bVar.eqa.setHandler(this.mHandler);
            bVar.eqb.setHandler(this.mHandler);
            bVar.eqc.setHandler(this.mHandler);
            bVar.eqd.setHandler(this.mHandler);
            view.setTag(bVar);
        } else {
            bVar = (C8843b) view.getTag();
        }
        C8842a aVar = (C8842a) this.dHf.get(i);
        if (aVar.childNum == 0) {
            bVar.epo.setVisibility(0);
            bVar.epo.update(aVar.groupIndex);
            bVar.eps.setVisibility(8);
            bVar.epr.setVisibility(8);
        } else {
            bVar.epo.setVisibility(8);
            int a = m25944a(aVar);
            if (aVar.showList) {
                bVar.epr.setVisibility(8);
                bVar.eps.setVisibility(0);
                bVar.eqd.mo35457a(a, this.epk);
                m25943M(a, i, 1);
            } else {
                bVar.epr.setVisibility(0);
                bVar.eps.setVisibility(8);
                m25947a(bVar, aVar);
                if (1 == aVar.childNum) {
                    bVar.epp.setVisibility(0);
                    bVar.epq.setVisibility(4);
                    bVar.epS.setVisibility(4);
                    bVar.eqa.mo35445a(a, this.epk);
                    m25943M(a, i, 1);
                } else if (2 == aVar.childNum) {
                    bVar.epp.setVisibility(0);
                    bVar.epq.setVisibility(0);
                    bVar.epS.setVisibility(4);
                    bVar.eqa.mo35445a(a, this.epk);
                    int i2 = a + 1;
                    bVar.eqb.mo35445a(i2, this.epk);
                    m25943M(a, i, 1);
                    m25943M(i2, i, 2);
                } else if (3 == aVar.childNum) {
                    bVar.epp.setVisibility(0);
                    bVar.epq.setVisibility(0);
                    bVar.epS.setVisibility(0);
                    bVar.eqa.mo35445a(a, this.epk);
                    int i3 = a + 1;
                    bVar.eqb.mo35445a(i3, this.epk);
                    int i4 = a + 2;
                    bVar.eqc.mo35445a(i4, this.epk);
                    m25943M(a, i, 1);
                    m25943M(i3, i, 2);
                    m25943M(i4, i, 3);
                }
            }
        }
        return view;
    }

    /* renamed from: pJ */
    public void mo35359pJ(String str) {
        if (this.f3609FO != null) {
            int firstVisiblePosition = this.f3609FO.getFirstVisiblePosition() - this.f3609FO.getHeaderViewsCount();
            int lastVisiblePosition = this.f3609FO.getLastVisiblePosition() - this.f3609FO.getHeaderViewsCount();
            if (this.epl != null && this.epl != null && this.epl.containsKey(str)) {
                C8844c cVar = (C8844c) this.epl.get(str);
                if (cVar != null) {
                    int i = cVar.epy;
                    if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                        View childAt = this.f3609FO.getChildAt(((!aLx() || i < this.diS) ? i : i + 1) - firstVisiblePosition);
                        if (i >= 0 && i <= this.dHf.size() - 1) {
                            C8842a aVar = (C8842a) this.dHf.get(i);
                            if (!(childAt == null || childAt.getTag() == null || !(childAt.getTag() instanceof C8843b))) {
                                C8843b bVar = (C8843b) childAt.getTag();
                                int a = m25944a(aVar);
                                List aMe = C8733e.aMa().aMe();
                                if (aVar.showList) {
                                    if (a >= 0 && a <= aMe.size() - 1) {
                                        TemplateInfo templateInfo = (TemplateInfo) C8733e.aMa().aMe().get(a);
                                        C8735f.aMf().mo35135C(templateInfo);
                                        bVar.eqd.mo35458a(templateInfo, this.epk);
                                    }
                                } else if (1 == cVar.epz) {
                                    if (a >= 0 && a <= aMe.size() - 1) {
                                        TemplateInfo templateInfo2 = (TemplateInfo) C8733e.aMa().aMe().get(a);
                                        C8735f.aMf().mo35135C(templateInfo2);
                                        bVar.eqa.mo35446a(templateInfo2, this.epk);
                                    }
                                } else if (2 == cVar.epz) {
                                    int i2 = a + 1;
                                    if (i2 >= 0 && i2 <= aMe.size() - 1) {
                                        TemplateInfo templateInfo3 = (TemplateInfo) C8733e.aMa().aMe().get(i2);
                                        C8735f.aMf().mo35135C(templateInfo3);
                                        bVar.eqb.mo35446a(templateInfo3, this.epk);
                                    }
                                } else if (3 == cVar.epz) {
                                    int i3 = a + 2;
                                    if (i3 >= 0 && i3 <= aMe.size() - 1) {
                                        TemplateInfo templateInfo4 = (TemplateInfo) C8733e.aMa().aMe().get(i3);
                                        C8735f.aMf().mo35135C(templateInfo4);
                                        bVar.eqc.mo35446a(templateInfo4, this.epk);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public void setHandler(Handler handler) {
        this.mHandler = handler;
    }
}
