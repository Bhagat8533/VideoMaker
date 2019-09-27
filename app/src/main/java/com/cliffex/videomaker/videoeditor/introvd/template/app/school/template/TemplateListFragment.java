package com.introvd.template.app.school.template;

import android.content.Context;
import android.os.Bundle;
import android.support.p021v4.widget.SwipeRefreshLayout;
import android.support.p021v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.support.p024v7.widget.RecyclerView;
import android.support.p024v7.widget.RecyclerView.C1022l;
import android.support.p024v7.widget.RecyclerView.C1025n;
import android.support.p024v7.widget.RecyclerView.C1031r;
import android.support.p024v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.introvd.template.R;
import com.introvd.template.app.push.api.model.CommonResponseResult;
import com.introvd.template.app.school.api.C4153h;
import com.introvd.template.app.school.api.model.TemplateListResult;
import com.introvd.template.app.school.template.detail.TemplateDetailAct;
import com.introvd.template.app.school.template.view.C4239c;
import com.introvd.template.app.school.template.view.C4239c.C4241a;
import com.introvd.template.app.utils.C4395c;
import com.introvd.template.common.FragmentBase;
import com.introvd.template.common.ToastUtils;
import com.introvd.template.p203b.C4600l;
import com.introvd.template.p414ui.view.HotFixRecyclerView;
import java.util.List;
import p037b.p050b.C1850u;
import p037b.p050b.p051a.p053b.C1487a;
import p037b.p050b.p054b.C1495b;
import p037b.p050b.p076j.C1820a;

public class TemplateListFragment extends FragmentBase implements C4241a {
    /* access modifiers changed from: private */
    public int OFFSET = 5;
    /* access modifiers changed from: private */
    public SwipeRefreshLayout bll;
    private int byN;
    private String byO;
    private HotFixRecyclerView byP;
    /* access modifiers changed from: private */
    public C4239c byQ;
    /* access modifiers changed from: private */
    public int byR = 1;
    /* access modifiers changed from: private */
    public long byS = 0;
    /* access modifiers changed from: private */
    public boolean byT;
    /* access modifiers changed from: private */
    public boolean byU;
    /* access modifiers changed from: private */
    public int byV = 0;
    private boolean byW;
    private boolean byX = true;
    private Context mContext;

    /* renamed from: In */
    private void m10537In() {
        this.bll.setOnRefreshListener(new OnRefreshListener() {
            public void onRefresh() {
                TemplateListFragment.this.mo24179hp(1);
                TemplateListFragment.this.bll.setRefreshing(false);
            }
        });
        this.byP.mo7737a((C1022l) new C1022l() {
            /* renamed from: a */
            public void mo8095a(RecyclerView recyclerView, int i, int i2) {
                super.mo8095a(recyclerView, i, i2);
            }

            /* renamed from: d */
            public void mo8096d(RecyclerView recyclerView, int i) {
                super.mo8096d(recyclerView, i);
                if (i == 0) {
                    StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) recyclerView.getLayoutManager();
                    if (staggeredGridLayoutManager != null) {
                        staggeredGridLayoutManager.mo8361mO();
                    }
                }
                int dataItemCount = TemplateListFragment.this.byQ == null ? 0 : TemplateListFragment.this.byQ.getDataItemCount();
                StaggeredGridLayoutManager staggeredGridLayoutManager2 = (StaggeredGridLayoutManager) recyclerView.getLayoutManager();
                int[] k = staggeredGridLayoutManager2.mo8356k(null);
                int[] l = staggeredGridLayoutManager2.mo8358l(null);
                if (!(k == null || l == null)) {
                    TemplateListFragment.this.byV = l[0];
                }
                if (!TemplateListFragment.this.byT && dataItemCount - TemplateListFragment.this.byV < TemplateListFragment.this.OFFSET && !TemplateListFragment.this.byU && i == 0) {
                    if (!C4600l.m11739k(TemplateListFragment.this.getActivity(), true)) {
                        ToastUtils.show((Context) TemplateListFragment.this.getActivity(), R.string.xiaoying_str_com_msg_network_inactive, 1);
                        TemplateListFragment.this.byQ.mo24229hv(0);
                    } else if (!TemplateListFragment.this.byU) {
                        TemplateListFragment.this.byQ.mo24229hv(2);
                        if (((long) dataItemCount) < TemplateListFragment.this.byS) {
                            TemplateListFragment.this.byU = false;
                            TemplateListFragment.this.mo24179hp(TemplateListFragment.this.byR);
                        } else {
                            TemplateListFragment.this.byQ.mo24229hv(6);
                        }
                    } else {
                        TemplateListFragment.this.byU = true;
                    }
                }
            }
        });
        this.byQ.setItemListener(new C4217a(this));
    }

    /* renamed from: Ok */
    private void m10538Ok() {
        this.byQ = new C4239c(this.mContext, this.byO, this.byW);
        this.byQ.mo24227a((C4241a) this);
        C42142 r0 = new StaggeredGridLayoutManager(2, 1) {
            public void onLayoutChildren(C1025n nVar, C1031r rVar) {
                try {
                    super.onLayoutChildren(nVar, rVar);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        r0.mo8352cw(0);
        this.byP.setLayoutManager(r0);
        this.byP.setAdapter(this.byQ);
    }

    /* access modifiers changed from: private */
    /* renamed from: hq */
    public /* synthetic */ void m10553hq(int i) {
        if (getActivity() != null) {
            TemplateDetailAct.m10565a(getActivity(), this.byQ.getDataList(), i, this.byO, this.byW ^ true ? 1 : 0);
        }
    }

    /* renamed from: Ol */
    public View mo24176Ol() {
        return this.byP;
    }

    /* renamed from: Om */
    public void mo24177Om() {
        C4395c.m11093b(getActivity(), 1, null);
    }

    /* renamed from: bL */
    public void mo24178bL(boolean z) {
        if (z) {
            mo24179hp(1);
        } else if (this.byQ == null || this.byQ.getDataItemCount() <= 0) {
            mo24179hp(1);
        }
    }

    /* renamed from: hp */
    public void mo24179hp(final int i) {
        this.byR = i;
        this.byT = true;
        C4153h.m10355a((long) this.byN, 20, i).mo10196g(C1820a.aVi()).mo10194f(C1487a.aUa()).mo10188a((C1850u<? super T>) new C1850u<CommonResponseResult<TemplateListResult>>() {
            /* renamed from: a */
            public void mo9883a(C1495b bVar) {
            }

            /* renamed from: a */
            public void onSuccess(CommonResponseResult<TemplateListResult> commonResponseResult) {
                TemplateListFragment.this.byT = false;
                if (commonResponseResult != null && commonResponseResult.data != null) {
                    ((TemplateListResult) commonResponseResult.data).getList();
                    List list = ((TemplateListResult) commonResponseResult.data).getList();
                    TemplateListFragment.this.byR = i + 1;
                    TemplateListFragment.this.byS = (long) ((TemplateListResult) commonResponseResult.data).getCount();
                    if (i == 1) {
                        if (TemplateListFragment.this.byQ != null) {
                            TemplateListFragment.this.byQ.setDataList(list);
                            TemplateListFragment.this.byQ.notifyDataSetChanged();
                        }
                    } else if (TemplateListFragment.this.byQ != null) {
                        TemplateListFragment.this.byQ.addDataList(list);
                        TemplateListFragment.this.byQ.notifyDataSetChanged();
                    }
                }
            }

            public void onError(Throwable th) {
                th.printStackTrace();
                TemplateListFragment.this.byT = false;
            }
        });
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        this.mContext = context;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.frag_template_list_layout, viewGroup, false);
        this.byP = (HotFixRecyclerView) inflate.findViewById(R.id.frag_template_recy);
        this.bll = (SwipeRefreshLayout) inflate.findViewById(R.id.frag_template_refresh);
        m10538Ok();
        m10537In();
        if (this.bll != null) {
            this.bll.setEnabled(this.byX);
        }
        return inflate;
    }

    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
    }

    public void setArguments(Bundle bundle) {
        super.setArguments(bundle);
        if (getArguments() != null && getArguments().getInt("labelkey") != 0) {
            this.byN = getArguments().getInt("labelkey");
            this.byO = getArguments().getString("labelName");
            this.byX = getArguments().getBoolean("labelEnable", true);
            this.byW = getArguments().getBoolean("isFromCreatePage", true);
        }
    }

    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
    }
}
