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
import com.introvd.template.ads.AdParamMgr;
import com.introvd.template.ads.entity.AdPositionInfoParam;
import com.introvd.template.ads.listener.ViewAdsListener;
import com.introvd.template.common.AppPreferencesSetting;
import com.introvd.template.common.UserBehaviorLog;
import com.introvd.template.datacenter.SocialServiceDef;
import com.introvd.template.module.p326ad.C7680l;
import com.introvd.template.module.p326ad.p328b.C7592b;
import com.introvd.template.router.p377ad.AdServiceProxy;
import com.introvd.template.sdk.model.template.RollInfo;
import com.introvd.template.sdk.model.template.TemplateInfo;
import com.introvd.template.sdk.p383c.C8399c;
import com.introvd.template.template.R;
import com.introvd.template.template.info.item.C8881a;
import com.introvd.template.template.info.item.C8885b;
import com.introvd.template.template.info.model.TemplateAdapterItemInfo;
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

/* renamed from: com.introvd.template.template.info.a.c */
public class C8827c extends BaseAdapter {

    /* renamed from: FO */
    private ListView f3605FO;
    /* access modifiers changed from: private */
    public int bgQ = -1;
    /* access modifiers changed from: private */
    public View cSw;
    private int dHd = 0;
    private ArrayList<TemplateAdapterItemInfo> dHf = new ArrayList<>();
    private List<String> dcI = new ArrayList();
    private int diS = -1;
    /* access modifiers changed from: private */
    public boolean diU = false;
    private String ekf;
    private int epj = 2;
    private HashMap<String, Integer> epk = new HashMap<>();
    private Map<String, C8830b> epl = Collections.synchronizedMap(new LinkedHashMap());
    private int epm = -1;
    /* access modifiers changed from: private */
    public Context mContext;
    private Handler mHandler;

    /* renamed from: pX */
    private LayoutInflater f3606pX;

    /* renamed from: com.introvd.template.template.info.a.c$a */
    class C8829a {
        TemplateGroupHeader epo;
        RelativeLayout epp;
        RelativeLayout epq;
        LinearLayout epr;
        RelativeLayout eps;
        C8881a ept;
        C8881a epu;
        C8885b epv;
        ImageView epw;
        ImageView epx;

        C8829a() {
        }
    }

    /* renamed from: com.introvd.template.template.info.a.c$b */
    private class C8830b {
        int epy;
        int epz;

        /* renamed from: pf */
        int f3607pf;

        private C8830b() {
        }
    }

    public C8827c(Context context, C8734a aVar, String str) {
        this.mContext = context;
        this.f3606pX = LayoutInflater.from(context);
        C8733e.aMa().mo35126a(aVar);
        this.ekf = str;
        if (!TextUtils.isEmpty(str)) {
            this.bgQ = -1;
            int i = 1;
            if (C8399c.ecX.equals(str)) {
                this.bgQ = 4;
                this.diS = AdParamMgr.getPositionInGroup(this.bgQ);
                if (this.diS >= 1) {
                    i = this.diS;
                }
                this.epm = i;
            } else if (C8399c.edd.equals(str)) {
                this.bgQ = 10;
                this.diS = AdParamMgr.getPositionInGroup(this.bgQ);
                if (this.diS >= 1) {
                    i = this.diS;
                }
                this.diS = i;
            }
            C7680l.aAe().mo32531h(this.bgQ, new ViewAdsListener() {
                public void onAdLoaded(AdPositionInfoParam adPositionInfoParam, boolean z, String str) {
                    if (z) {
                        View adView = C7680l.aAe().getAdView(C8827c.this.mContext, C8827c.this.bgQ);
                        if (!(adView == null || adView == C8827c.this.cSw)) {
                            C8827c.this.diU = false;
                        }
                        C8827c.this.cSw = adView;
                    }
                    C8827c.this.notifyDataSetChanged();
                }
            });
            C7680l.aAe().mo32526aj(this.mContext, this.bgQ);
        }
    }

    /* renamed from: M */
    private void m25911M(int i, int i2, int i3) {
        try {
            List aMe = C8733e.aMa().aMe();
            if (aMe != null && i3 >= 0 && i3 < aMe.size()) {
                TemplateInfo templateInfo = (TemplateInfo) aMe.get(i);
                if (templateInfo != null) {
                    C8830b bVar = new C8830b();
                    bVar.f3607pf = i;
                    bVar.epy = i2;
                    bVar.epz = i3;
                    this.epl.put(templateInfo.ttid, bVar);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    private int m25912a(TemplateAdapterItemInfo templateAdapterItemInfo) {
        return C8733e.aMa().mo35129dQ(templateAdapterItemInfo.groupIndex, templateAdapterItemInfo.childStartIndex);
    }

    /* renamed from: a */
    private void m25915a(C8829a aVar, TemplateAdapterItemInfo templateAdapterItemInfo) {
        if (templateAdapterItemInfo.isFirstInGruop) {
            aVar.epw.setVisibility(0);
        } else {
            aVar.epw.setVisibility(8);
        }
        if (templateAdapterItemInfo.isLastInGroup) {
            aVar.epx.setVisibility(0);
        } else {
            aVar.epx.setVisibility(8);
        }
    }

    /* renamed from: a */
    private void m25916a(String str, TemplateInfo templateInfo) {
        C8735f.aMf().mo35135C(templateInfo);
    }

    private boolean aLx() {
        return (this.cSw == null || this.epm == -1) ? false : true;
    }

    private void ayX() {
        this.dHd = 0;
        int groupCount = getGroupCount();
        for (int i = 0; i < groupCount; i++) {
            TemplateGroupInfo vd = C8733e.aMa().mo35134vd(i);
            int childrenCount = getChildrenCount(i);
            if (vd.showList) {
                this.dHd += childrenCount;
            } else if (childrenCount % this.epj == 0) {
                this.dHd += childrenCount / this.epj;
            } else {
                this.dHd += (childrenCount / this.epj) + 1;
            }
            if (vd.showGroup) {
                this.dHd++;
            }
        }
        ayY();
    }

    private void ayY() {
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
                    TemplateAdapterItemInfo templateAdapterItemInfo = new TemplateAdapterItemInfo();
                    templateAdapterItemInfo.groupIndex = i;
                    templateAdapterItemInfo.childNum = 0;
                    templateAdapterItemInfo.showList = z;
                    this.dHf.add(templateAdapterItemInfo);
                }
                ArrayList arrayList = new ArrayList();
                if (z) {
                    int i2 = 0;
                    while (childrenCount > 0) {
                        TemplateAdapterItemInfo templateAdapterItemInfo2 = new TemplateAdapterItemInfo();
                        templateAdapterItemInfo2.groupIndex = i;
                        templateAdapterItemInfo2.childNum = 1;
                        templateAdapterItemInfo2.showList = z;
                        templateAdapterItemInfo2.childStartIndex = i2;
                        arrayList.add(templateAdapterItemInfo2);
                        childrenCount--;
                        i2++;
                    }
                } else {
                    int i3 = 0;
                    while (childrenCount >= this.epj) {
                        TemplateAdapterItemInfo templateAdapterItemInfo3 = new TemplateAdapterItemInfo();
                        templateAdapterItemInfo3.groupIndex = i;
                        templateAdapterItemInfo3.childNum = this.epj;
                        templateAdapterItemInfo3.childStartIndex = i3;
                        templateAdapterItemInfo3.showList = z;
                        arrayList.add(templateAdapterItemInfo3);
                        childrenCount -= this.epj;
                        i3 += this.epj;
                    }
                    if (childrenCount < this.epj && childrenCount > 0) {
                        TemplateAdapterItemInfo templateAdapterItemInfo4 = new TemplateAdapterItemInfo();
                        templateAdapterItemInfo4.groupIndex = i;
                        templateAdapterItemInfo4.childNum = childrenCount;
                        templateAdapterItemInfo4.childStartIndex = i3;
                        templateAdapterItemInfo4.showList = z;
                        arrayList.add(templateAdapterItemInfo4);
                    }
                }
                if (arrayList.size() > 0) {
                    ((TemplateAdapterItemInfo) arrayList.get(0)).isFirstInGruop = true;
                    ((TemplateAdapterItemInfo) arrayList.get(arrayList.size() - 1)).isLastInGroup = true;
                }
                this.dHf.addAll(arrayList);
            }
        }
    }

    /* renamed from: cU */
    private List<TemplateInfo> m25920cU(List<TemplateInfo> list) {
        if (list == null || list.size() <= 0) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        for (TemplateInfo templateInfo : list) {
            try {
                if ((templateInfo instanceof RollInfo) && ((RollInfo) templateInfo).rollModel.isShowInMC == 0) {
                    arrayList.add(templateInfo);
                }
            } catch (Exception unused) {
            }
        }
        return arrayList;
    }

    private int getChildrenCount(int i) {
        return C8733e.aMa().mo35133vc(i);
    }

    private int getGroupCount() {
        return C8733e.aMa().getGroupCount();
    }

    /* renamed from: jB */
    private void m25921jB(boolean z) {
        String str;
        String str2;
        String str3 = "unknown";
        String str4 = null;
        if (C8399c.ecX.equals(this.ekf)) {
            str4 = "Ad_New_Theme_Show";
            str2 = "Ad_New_Theme_Click";
            str = "new_theme";
        } else if (C8399c.edd.equals(this.ekf)) {
            str4 = "Ad_FX_Show";
            str2 = "Ad_FX_Click";
            str = "new_fx";
        } else {
            str = str3;
            str2 = null;
        }
        if (!z) {
            str2 = str4;
        }
        if (!TextUtils.isEmpty(str2) && this.cSw != null) {
            HashMap hashMap = new HashMap();
            String str5 = (String) AdServiceProxy.execute(AdServiceProxy.getAdProvider, this.cSw.getTag());
            hashMap.put("platform", str5);
            if (!z) {
                hashMap.put(SocialServiceDef.EXTRAS_UPGRADE_FROM, AppPreferencesSetting.getInstance().getAppSettingStr("template_ad_from", "unknown"));
                C7592b.m22379F(this.mContext, str2, str5);
            } else {
                C7592b.m22380G(this.mContext, str, str5);
            }
            UserBehaviorLog.onKVEvent(this.mContext, str2, hashMap);
        }
    }

    /* renamed from: pH */
    private C8830b m25922pH(String str) {
        if (this.epl == null || !this.epl.containsKey(str)) {
            return null;
        }
        return (C8830b) this.epl.get(str);
    }

    /* renamed from: uT */
    private int m25923uT(int i) {
        if (this.epm < 0) {
            int groupCount = getGroupCount();
            int i2 = 0;
            for (int i3 = 0; i3 < groupCount; i3++) {
                i2 = i2 + ((int) Math.ceil((((double) getChildrenCount(i3)) * 1.0d) / ((double) this.epj))) + 1;
                if (i2 - i3 > i) {
                    return i + i3 + 1;
                }
            }
        }
        return this.epm;
    }

    /* renamed from: U */
    public void mo35324U(String str, int i) {
        this.epk.put(str, Integer.valueOf(i));
    }

    /* renamed from: V */
    public void mo35325V(String str, int i) {
        if (this.f3605FO != null) {
            int firstVisiblePosition = this.f3605FO.getFirstVisiblePosition() - this.f3605FO.getHeaderViewsCount();
            int lastVisiblePosition = this.f3605FO.getLastVisiblePosition() - this.f3605FO.getHeaderViewsCount();
            C8830b pH = m25922pH(str);
            if (pH != null) {
                int i2 = pH.epy;
                if (i2 >= firstVisiblePosition && i2 <= lastVisiblePosition) {
                    View childAt = this.f3605FO.getChildAt(((!aLx() || i2 < this.epm) ? i2 : i2 + 1) - firstVisiblePosition);
                    if (i2 >= 0 && i2 <= this.dHf.size() - 1) {
                        TemplateAdapterItemInfo templateAdapterItemInfo = (TemplateAdapterItemInfo) this.dHf.get(i2);
                        if (!(childAt == null || childAt.getTag() == null || !(childAt.getTag() instanceof C8829a))) {
                            C8829a aVar = (C8829a) childAt.getTag();
                            int a = m25912a(templateAdapterItemInfo);
                            List aMe = C8733e.aMa().aMe();
                            if (templateAdapterItemInfo.showList) {
                                if (a >= 0 && a <= aMe.size() - 1) {
                                    TemplateInfo templateInfo = (TemplateInfo) aMe.get(a);
                                    if (templateInfo != null) {
                                        templateInfo.nState = i;
                                        m25916a(str, templateInfo);
                                        aVar.epv.mo35433a(templateInfo, this.epk);
                                    }
                                }
                            } else if (1 == pH.epz) {
                                if (a >= 0 && a <= aMe.size() - 1) {
                                    TemplateInfo templateInfo2 = (TemplateInfo) aMe.get(a);
                                    if (templateInfo2 != null) {
                                        templateInfo2.nState = i;
                                        m25916a(str, templateInfo2);
                                        aVar.ept.mo35424a(templateInfo2, this.epk);
                                    }
                                }
                            } else if (2 == pH.epz) {
                                int i3 = a + 1;
                                if (i3 >= 0 && i3 <= aMe.size() - 1) {
                                    TemplateInfo templateInfo3 = (TemplateInfo) aMe.get(i3);
                                    if (templateInfo3 != null) {
                                        templateInfo3.nState = i;
                                        m25916a(str, templateInfo3);
                                        aVar.epu.mo35424a(templateInfo3, this.epk);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /* renamed from: b */
    public void mo35326b(ListView listView) {
        this.f3605FO = listView;
    }

    /* renamed from: cT */
    public void mo35327cT(List<String> list) {
        this.dcI = list;
    }

    /* renamed from: d */
    public void mo35328d(List<TemplateInfo> list, boolean z) {
        List<TemplateInfo> arrayList = new ArrayList<>();
        if (list == null) {
            list = arrayList;
        } else if (C8735f.m25479qm(this.ekf)) {
            list = m25920cU(list);
        }
        C8733e.aMa().mo35131j(this.mContext, list);
        ayX();
        if (C8399c.edd.equals(this.ekf)) {
            this.epm = m25923uT(this.diS);
        }
        if (z && C7680l.aAe().getAdView(this.mContext, this.bgQ) == null) {
            C7680l.aAe().mo32526aj(this.mContext, this.bgQ);
        }
        super.notifyDataSetChanged();
    }

    public int getCount() {
        return this.dHd;
    }

    public Object getItem(int i) {
        return null;
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        C8829a aVar;
        if (!(this.cSw == null || -1 == this.epm)) {
            if (this.epm == i) {
                if (!this.diU) {
                    this.diU = true;
                    m25921jB(false);
                }
                return this.cSw;
            } else if (i > this.epm) {
                i--;
            }
        }
        if (view == null || view.getTag() == null || (view.getTag() instanceof Integer) || view == this.cSw) {
            view = this.f3606pX.inflate(R.layout.v5_xiaoying_com_template_list_item, null);
            aVar = new C8829a();
            aVar.epo = (TemplateGroupHeader) view.findViewById(R.id.clip_title);
            aVar.epo.setHandler(this.mHandler);
            aVar.epr = (LinearLayout) view.findViewById(R.id.gridview);
            aVar.epp = (RelativeLayout) view.findViewById(R.id.clip_layout01);
            aVar.epq = (RelativeLayout) view.findViewById(R.id.clip_layout02);
            aVar.epw = (ImageView) view.findViewById(R.id.top_layout);
            aVar.epx = (ImageView) view.findViewById(R.id.bottom_layout);
            aVar.eps = (RelativeLayout) view.findViewById(R.id.listiew);
            aVar.ept = new C8881a(this.mContext, aVar.epp, true, this.ekf);
            aVar.epu = new C8881a(this.mContext, aVar.epq, false, this.ekf);
            aVar.epv = new C8885b(this.mContext, aVar.eps, this.ekf);
            aVar.ept.setHandler(this.mHandler);
            aVar.epu.setHandler(this.mHandler);
            aVar.epv.setHandler(this.mHandler);
            view.setTag(aVar);
        } else {
            aVar = (C8829a) view.getTag();
        }
        TemplateAdapterItemInfo templateAdapterItemInfo = (TemplateAdapterItemInfo) this.dHf.get(i);
        if (templateAdapterItemInfo.childNum == 0) {
            aVar.epo.setVisibility(0);
            aVar.epo.update(templateAdapterItemInfo.groupIndex);
            aVar.eps.setVisibility(8);
            aVar.epr.setVisibility(8);
        } else {
            aVar.epo.setVisibility(8);
            int a = m25912a(templateAdapterItemInfo);
            if (templateAdapterItemInfo.showList) {
                aVar.epr.setVisibility(8);
                aVar.eps.setVisibility(0);
                aVar.epv.mo35432a(a, this.epk);
                m25911M(a, i, 1);
            } else {
                aVar.epr.setVisibility(0);
                aVar.eps.setVisibility(8);
                m25915a(aVar, templateAdapterItemInfo);
                if (1 == templateAdapterItemInfo.childNum) {
                    aVar.epp.setVisibility(0);
                    aVar.epq.setVisibility(4);
                    aVar.ept.mo35423a(a, this.epk);
                    m25911M(a, i, 1);
                } else if (2 == templateAdapterItemInfo.childNum) {
                    aVar.epp.setVisibility(0);
                    aVar.epq.setVisibility(0);
                    aVar.ept.mo35423a(a, this.epk);
                    int i2 = a + 1;
                    aVar.epu.mo35423a(i2, this.epk);
                    m25911M(a, i, 1);
                    m25911M(i2, i, 2);
                }
            }
        }
        return view;
    }

    public void setHandler(Handler handler) {
        this.mHandler = handler;
    }
}
