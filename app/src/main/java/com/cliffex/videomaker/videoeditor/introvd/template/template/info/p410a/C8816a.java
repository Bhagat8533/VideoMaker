package com.introvd.template.template.info.p410a;

import android.content.Context;
import android.support.p024v7.widget.GridLayoutManager;
import android.support.p024v7.widget.GridLayoutManager.C0986b;
import android.support.p024v7.widget.RecyclerView;
import android.support.p024v7.widget.RecyclerView.C1008a;
import android.support.p024v7.widget.RecyclerView.C1034u;
import android.support.p024v7.widget.RecyclerView.LayoutManager;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.introvd.template.common.p236ui.LoadingMoreFooterView;
import com.introvd.template.sdk.model.template.TemplateInfo;
import com.introvd.template.template.info.item.AnimateFrameItemView;
import com.introvd.template.template.info.item.C8908i;
import com.introvd.template.template.info.item.C8909j;
import com.introvd.template.template.info.item.C8909j.C8911a;
import com.introvd.template.template.info.item.C8912k;
import com.introvd.template.template.info.item.C8912k.C8914a;
import com.introvd.template.template.info.item.GroupHeaderView;
import com.introvd.template.template.model.TemplateGroupInfo;
import com.introvd.template.template.p400a.C8623a;
import com.introvd.template.template.p400a.C8624b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.introvd.template.template.info.a.a */
public class C8816a extends C1008a<C1034u> {
    private String ekf;
    private LoadingMoreFooterView ena;
    private List<C8909j> eoO = new ArrayList();
    private C8908i eoP;
    private C8624b eoQ;
    private Context mContext;

    /* renamed from: com.introvd.template.template.info.a.a$a */
    static class C8819a extends C1034u {
        AnimateFrameItemView eoT;

        C8819a(AnimateFrameItemView animateFrameItemView) {
            super(animateFrameItemView);
            this.eoT = animateFrameItemView;
        }
    }

    /* renamed from: com.introvd.template.template.info.a.a$b */
    static class C8820b extends C1034u {
        View bFD;

        C8820b(View view) {
            super(view);
            this.bFD = view;
        }
    }

    /* renamed from: com.introvd.template.template.info.a.a$c */
    static class C8821c extends C1034u {
        LoadingMoreFooterView bzL;

        C8821c(LoadingMoreFooterView loadingMoreFooterView) {
            super(loadingMoreFooterView);
            this.bzL = loadingMoreFooterView;
        }
    }

    /* renamed from: com.introvd.template.template.info.a.a$d */
    static class C8822d extends C1034u {
        GroupHeaderView eoU;

        C8822d(GroupHeaderView groupHeaderView) {
            super(groupHeaderView);
            this.eoU = groupHeaderView;
        }
    }

    public C8816a(Context context, String str) {
        this.mContext = context;
        this.ekf = str;
        this.eoQ = new C8624b(context, str);
        this.eoQ.mo34924a((C8623a) new C8623a() {
            /* renamed from: jz */
            public void mo34923jz(boolean z) {
                if (z) {
                    C8816a.this.notifyDataSetChanged();
                }
            }
        });
    }

    /* renamed from: b */
    private void m25888b(C1034u uVar, List<C8912k> list) {
        if (!(list == null || list.size() == 0 || !(uVar instanceof C8819a))) {
            Integer num = null;
            Boolean bool = null;
            for (C8912k kVar : list) {
                if (kVar.aLS() != null) {
                    bool = kVar.aLS();
                }
                if (kVar.aLT() != null) {
                    num = kVar.aLT();
                }
            }
            if (num != null) {
                ((C8819a) uVar).eoT.mo35418uY(num.intValue());
            }
            if (bool != null) {
                ((C8819a) uVar).eoT.aLK();
            }
        }
    }

    /* renamed from: cR */
    private List<C8909j> m25889cR(List<TemplateGroupInfo> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                arrayList.add(new C8911a().mo35471vb(i).mo35469uZ(3).aLR());
                TemplateGroupInfo templateGroupInfo = (TemplateGroupInfo) list.get(i);
                if (!(templateGroupInfo == null || templateGroupInfo.childList == null || templateGroupInfo.childList.size() <= 0)) {
                    Iterator it = templateGroupInfo.childList.iterator();
                    while (it.hasNext()) {
                        TemplateInfo templateInfo = (TemplateInfo) it.next();
                        arrayList.add(new C8911a().mo35471vb(i).mo35469uZ(0).mo35466pW(templateInfo.strIcon).mo35464pU(templateInfo.strTitle).mo35465pV(templateInfo.strIntro).mo35467pX(templateInfo.strPreviewurl).mo35468pY(templateInfo.strScene).mo35462pS(templateInfo.tcid).mo35463pT(templateInfo.ttid).mo35470va(templateInfo.nState).aLR());
                    }
                    if (templateGroupInfo.childList.size() % 2 != 0) {
                        arrayList.add(new C8911a().mo35471vb(i).mo35469uZ(1).aLR());
                    }
                }
            }
        }
        return arrayList;
    }

    /* renamed from: S */
    public void mo35307S(String str, int i) {
        if (!TextUtils.isEmpty(str)) {
            int i2 = 0;
            while (true) {
                if (i2 >= this.eoO.size()) {
                    break;
                }
                C8909j jVar = (C8909j) this.eoO.get(i2);
                if (jVar.esn == 0 && str.equals(jVar.ttid)) {
                    notifyItemChanged(i2, new C8914a().mo35476o(Integer.valueOf(i)).aLU());
                    break;
                }
                i2++;
            }
        }
    }

    /* renamed from: a */
    public void mo35308a(C8908i iVar) {
        this.eoP = iVar;
    }

    public int aLu() {
        int i = 0;
        if (this.eoO.size() > 0) {
            for (C8909j jVar : this.eoO) {
                if (jVar.esn == 0) {
                    i++;
                }
            }
        }
        return i;
    }

    /* renamed from: cQ */
    public void mo35310cQ(List<TemplateGroupInfo> list) {
        this.eoO.clear();
        this.eoO.addAll(m25889cR(list));
        if (this.eoO.size() > 0) {
            this.eoO.add(new C8911a().mo35469uZ(4).aLR());
        }
        this.eoQ.aKh();
        notifyDataSetChanged();
    }

    public int getItemCount() {
        return this.eoO.size();
    }

    public int getItemViewType(int i) {
        C8909j jVar = (C8909j) this.eoO.get(i);
        if (jVar != null) {
            return jVar.esn;
        }
        return -1;
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            final GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
            gridLayoutManager.mo7544a(new C0986b() {
                /* renamed from: bU */
                public int mo7575bU(int i) {
                    if (C8816a.this.getItemViewType(i) == 3 || C8816a.this.getItemViewType(i) == 4 || C8816a.this.getItemViewType(i) == 2) {
                        return gridLayoutManager.mo7557kr();
                    }
                    return 1;
                }
            });
        }
    }

    public void onBindViewHolder(C1034u uVar, int i) {
        int itemViewType = getItemViewType(i);
        C8909j jVar = (C8909j) this.eoO.get(i);
        if (jVar != null) {
            switch (itemViewType) {
                case 0:
                case 1:
                    if (uVar instanceof C8819a) {
                        ((C8819a) uVar).eoT.mo35415a(jVar, this.eoP);
                        break;
                    }
                    break;
                case 2:
                    if (uVar instanceof C8820b) {
                        C8820b bVar = (C8820b) uVar;
                        if (!this.eoQ.aKi()) {
                            this.eoQ.mo34928jA(true);
                            this.eoQ.mo34929jB(false);
                            break;
                        }
                    }
                    break;
                case 3:
                    if (uVar instanceof C8822d) {
                        ((C8822d) uVar).eoU.mo35421a(jVar.groupIndex, this.eoP);
                        break;
                    }
                    break;
                case 4:
                    if (uVar instanceof C8821c) {
                        C8821c cVar = (C8821c) uVar;
                        break;
                    }
                    break;
            }
        }
    }

    public void onBindViewHolder(C1034u uVar, int i, List<Object> list) {
        if (list.isEmpty()) {
            onBindViewHolder(uVar, i);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Object next : list) {
            if (next instanceof C8912k) {
                arrayList.add((C8912k) next);
            }
        }
        m25888b(uVar, arrayList);
    }

    public C1034u onCreateViewHolder(ViewGroup viewGroup, int i) {
        switch (i) {
            case 2:
                return new C8820b(this.eoQ.getAdView());
            case 3:
                return new C8822d(new GroupHeaderView(this.mContext));
            case 4:
                this.ena = new LoadingMoreFooterView(this.mContext);
                return new C8821c(this.ena);
            default:
                return new C8819a(new AnimateFrameItemView(this.mContext));
        }
    }

    /* renamed from: pG */
    public void mo35311pG(String str) {
        if (!TextUtils.isEmpty(str)) {
            int i = 0;
            while (true) {
                if (i >= this.eoO.size()) {
                    break;
                }
                C8909j jVar = (C8909j) this.eoO.get(i);
                if (jVar.esn == 0 && str.equals(jVar.ttid)) {
                    notifyItemChanged(i, new C8914a().mo35474F(Boolean.valueOf(true)).aLU());
                    break;
                }
                i++;
            }
        }
    }

    /* renamed from: uI */
    public void mo35312uI(int i) {
        if (this.ena != null) {
            this.ena.setStatus(i);
        }
    }
}
