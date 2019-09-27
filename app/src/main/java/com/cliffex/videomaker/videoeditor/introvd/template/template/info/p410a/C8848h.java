package com.introvd.template.template.info.p410a;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.introvd.template.common.LogUtils;
import com.introvd.template.sdk.model.editor.TemplateItemData;
import com.introvd.template.template.R;
import com.introvd.template.template.info.item.C8889c;
import com.introvd.template.template.info.item.C8894e;
import com.introvd.template.template.p407e.C8736g;
import com.introvd.template.template.p407e.C8736g.C8737a;
import com.introvd.template.template.widget.GroupHeader;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.introvd.template.template.info.a.h */
public class C8848h extends BaseAdapter {
    private int dHd = 0;
    private ArrayList<C8850a> dHf = new ArrayList<>();
    private String eqj = "";
    private Context mContext;
    private Handler mHandler;

    /* renamed from: pX */
    private LayoutInflater f3614pX;

    /* renamed from: com.introvd.template.template.info.a.h$a */
    private class C8850a {
        int childNum;
        int childStartIndex;
        int groupIndex;
        boolean isFirstInGruop;
        boolean isLastInGroup;
        boolean showList;

        private C8850a() {
            this.isFirstInGruop = false;
            this.isLastInGroup = false;
        }
    }

    /* renamed from: com.introvd.template.template.info.a.h$b */
    class C8851b {
        RelativeLayout epp;
        RelativeLayout epq;
        LinearLayout epr;
        RelativeLayout eps;
        ImageView epw;
        ImageView epx;
        GroupHeader eqg;
        C8889c eql;
        C8889c eqm;
        C8894e eqn;

        C8851b() {
        }
    }

    public C8848h(Context context) {
        this.mContext = context;
        this.f3614pX = LayoutInflater.from(context);
    }

    /* renamed from: a */
    private int m25959a(C8850a aVar) {
        return C8736g.aMg().mo35160dQ(aVar.groupIndex, aVar.childStartIndex);
    }

    /* renamed from: a */
    private void m25960a(C8851b bVar, C8850a aVar) {
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
                C8737a vg = C8736g.aMg().mo35163vg(i);
                boolean z = vg.showList;
                if (vg.showGroup) {
                    C8850a aVar = new C8850a();
                    aVar.groupIndex = i;
                    aVar.childNum = 0;
                    aVar.showList = z;
                    this.dHf.add(aVar);
                }
                ArrayList arrayList = new ArrayList();
                if (z) {
                    int i2 = 0;
                    while (childrenCount > 0) {
                        C8850a aVar2 = new C8850a();
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
                    while (childrenCount >= 2) {
                        C8850a aVar3 = new C8850a();
                        aVar3.groupIndex = i;
                        aVar3.childNum = 2;
                        aVar3.childStartIndex = i3;
                        aVar3.showList = z;
                        arrayList.add(aVar3);
                        childrenCount -= 2;
                        i3 += 2;
                    }
                    if (childrenCount < 2 && childrenCount > 0) {
                        C8850a aVar4 = new C8850a();
                        aVar4.groupIndex = i;
                        aVar4.childNum = childrenCount;
                        aVar4.childStartIndex = i3;
                        aVar4.showList = z;
                        arrayList.add(aVar4);
                    }
                }
                if (arrayList.size() > 0) {
                    ((C8850a) arrayList.get(0)).isFirstInGruop = true;
                    ((C8850a) arrayList.get(arrayList.size() - 1)).isLastInGroup = true;
                }
                this.dHf.addAll(arrayList);
            }
        }
    }

    private int getGroupCount() {
        return C8736g.aMg().getGroupCount();
    }

    public void ayX() {
        this.dHd = 0;
        int groupCount = getGroupCount();
        for (int i = 0; i < groupCount; i++) {
            C8737a vg = C8736g.aMg().mo35163vg(i);
            int childrenCount = getChildrenCount(i);
            if (vg.showList) {
                this.dHd += childrenCount;
            } else if (childrenCount % 2 == 0) {
                this.dHd += childrenCount / 2;
            } else {
                this.dHd += (childrenCount / 2) + 1;
            }
            if (vg.showGroup) {
                this.dHd++;
            }
        }
        ayY();
    }

    /* renamed from: cV */
    public void mo35369cV(List<TemplateItemData> list) {
        LogUtils.m14223i("GroupGridAdapter", "doNotifyDataSetChanged <--");
        if (list != null) {
            C8736g.aMg().mo35159ay(list);
            ayX();
            super.notifyDataSetChanged();
        }
        LogUtils.m14223i("GroupGridAdapter", "doNotifyDataSetChanged -->");
    }

    public int getChildrenCount(int i) {
        return C8736g.aMg().mo35162vc(i);
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
        C8851b bVar;
        if (view == null) {
            view = this.f3614pX.inflate(R.layout.template_mgr_item_layout, null);
            bVar = new C8851b();
            bVar.eqg = (GroupHeader) view.findViewById(R.id.clip_title);
            bVar.eqg.setHandler(this.mHandler);
            bVar.epr = (LinearLayout) view.findViewById(R.id.gridview);
            bVar.epp = (RelativeLayout) view.findViewById(R.id.clip_layout01);
            bVar.epq = (RelativeLayout) view.findViewById(R.id.clip_layout02);
            bVar.epw = (ImageView) view.findViewById(R.id.top_layout);
            bVar.epx = (ImageView) view.findViewById(R.id.bottom_layout);
            bVar.eps = (RelativeLayout) view.findViewById(R.id.listiew);
            bVar.eql = new C8889c(this.mContext, bVar.epp, true, this.eqj);
            bVar.eqm = new C8889c(this.mContext, bVar.epq, false, this.eqj);
            bVar.eqn = new C8894e(this.mContext, bVar.eps);
            bVar.eql.setHandler(this.mHandler);
            bVar.eqm.setHandler(this.mHandler);
            bVar.eqn.setHandler(this.mHandler);
            view.setTag(bVar);
        } else {
            bVar = (C8851b) view.getTag();
        }
        C8850a aVar = (C8850a) this.dHf.get(i);
        if (aVar.childNum == 0) {
            bVar.eqg.setVisibility(0);
            bVar.eqg.update(aVar.groupIndex);
            bVar.eps.setVisibility(8);
            bVar.epr.setVisibility(8);
        } else {
            bVar.eqg.setVisibility(8);
            int a = m25959a(aVar);
            if (aVar.showList) {
                bVar.epr.setVisibility(8);
                bVar.eps.setVisibility(0);
                bVar.eqn.update(a);
            } else {
                bVar.epr.setVisibility(0);
                bVar.eps.setVisibility(8);
                m25960a(bVar, aVar);
                if (1 == aVar.childNum) {
                    bVar.epp.setVisibility(0);
                    bVar.epq.setVisibility(4);
                    bVar.eql.update(a);
                } else if (2 == aVar.childNum) {
                    bVar.epp.setVisibility(0);
                    bVar.epq.setVisibility(0);
                    bVar.eql.update(a);
                    bVar.eqm.update(a + 1);
                } else if (3 == aVar.childNum) {
                    bVar.epp.setVisibility(0);
                    bVar.epq.setVisibility(0);
                    bVar.eql.update(a);
                    bVar.eqm.update(a + 1);
                }
            }
        }
        return view;
    }

    /* renamed from: pK */
    public void mo35375pK(String str) {
        this.eqj = str;
    }

    public void setHandler(Handler handler) {
        this.mHandler = handler;
    }
}
