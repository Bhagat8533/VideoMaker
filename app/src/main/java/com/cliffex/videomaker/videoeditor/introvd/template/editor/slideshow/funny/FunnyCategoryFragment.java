package com.introvd.template.editor.slideshow.funny;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.p021v4.widget.SwipeRefreshLayout;
import android.support.p021v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.support.p024v7.widget.GridLayoutManager;
import android.support.p024v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.introvd.template.common.AppPreferencesSetting;
import com.introvd.template.common.FragmentBase;
import com.introvd.template.common.ToastUtils;
import com.introvd.template.common.recycleviewutil.BaseItem;
import com.introvd.template.common.recycleviewutil.CustomRecyclerViewAdapter;
import com.introvd.template.editor.R;
import com.introvd.template.editor.slideshow.funny.view.C6834a;
import com.introvd.template.editor.slideshow.funny.view.C6836b;
import com.introvd.template.p203b.C4586g;
import com.introvd.template.p203b.C4600l;
import com.introvd.template.sdk.model.template.TemplateInfo;
import com.introvd.template.template.data.api.C8659b;
import com.introvd.template.template.data.api.model.TemplateResponseInfo;
import com.introvd.template.template.data.api.model.TemplateResponseList;
import com.introvd.template.template.p407e.C8742k;
import com.p131c.p132a.p135c.C2575a;
import com.p131c.p132a.p135c.p136a.C2579b;
import com.p131c.p132a.p135c.p136a.C2579b.C2582a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import p037b.p050b.C1848s;
import p037b.p050b.C1850u;
import p037b.p050b.p051a.p053b.C1487a;
import p037b.p050b.p054b.C1495b;
import p037b.p050b.p057e.C1518f;
import p037b.p050b.p076j.C1820a;
import p469f.C9768m;
import xiaoying.engine.QEngine;

public class FunnyCategoryFragment extends FragmentBase {
    /* access modifiers changed from: private */
    public static String dgk;

    /* renamed from: Vu */
    private RecyclerView f3514Vu;
    private CustomRecyclerViewAdapter cNJ;
    private List<BaseItem> dataList = new ArrayList();
    /* access modifiers changed from: private */
    public SwipeRefreshLayout dgl;
    private LinearLayout dgm;
    private TextView dgn;
    /* access modifiers changed from: private */
    public String dgo = "";
    /* access modifiers changed from: private */
    public List<TemplateInfo> dgp = new ArrayList();
    /* access modifiers changed from: private */
    public C6789a dgq = new C6789a(this);
    private OnRefreshListener dgr = new OnRefreshListener() {
        public void onRefresh() {
            if (!C4600l.m11739k(FunnyCategoryFragment.this.getContext(), true)) {
                ToastUtils.show(FunnyCategoryFragment.this.getContext(), R.string.xiaoying_str_com_msg_network_inactive, 1);
                if (FunnyCategoryFragment.this.dgl != null) {
                    FunnyCategoryFragment.this.dgl.setRefreshing(false);
                    return;
                }
                return;
            }
            FunnyCategoryFragment.this.mo30316pf(1);
        }
    };

    /* renamed from: com.introvd.template.editor.slideshow.funny.FunnyCategoryFragment$a */
    private static class C6789a extends Handler {
        private final WeakReference<FunnyCategoryFragment> boy;

        public C6789a(FunnyCategoryFragment funnyCategoryFragment) {
            this.boy = new WeakReference<>(funnyCategoryFragment);
        }

        public void handleMessage(Message message) {
            FunnyCategoryFragment funnyCategoryFragment = (FunnyCategoryFragment) this.boy.get();
            if (funnyCategoryFragment != null) {
                int i = message.what;
                if (i == 12292) {
                    funnyCategoryFragment.aru();
                } else if (i == 16385 && funnyCategoryFragment.dgl != null) {
                    funnyCategoryFragment.dgl.setRefreshing(false);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: aM */
    public void m19750aM(List<TemplateInfo> list) {
        this.dgp = list;
        if (list.size() == 0) {
            aru();
            return;
        }
        this.dataList.clear();
        this.dgl.setVisibility(0);
        this.dgm.setVisibility(8);
        if (this.cNJ != null) {
            for (TemplateInfo bVar : list) {
                this.dataList.add(new C6836b(getActivity(), this.dgo, bVar));
            }
            this.dataList.add(new C6834a(getActivity()));
            this.cNJ.setData(this.dataList);
        }
    }

    private void art() {
        C1848s.m5326ai(Boolean.valueOf(true)).mo10196g(C1820a.aVi()).mo10194f(C1820a.aVi()).mo10199i(new C1518f<Boolean, List<TemplateInfo>>() {
            /* renamed from: i */
            public List<TemplateInfo> apply(Boolean bool) throws Exception {
                C8742k.aMi().mo35178cz(FunnyCategoryFragment.this.getContext(), FunnyCategoryFragment.this.dgo);
                List<TemplateInfo> qt = C8742k.aMi().mo35183qt(FunnyCategoryFragment.this.dgo);
                return qt == null ? new ArrayList() : qt;
            }
        }).mo10194f(C1487a.aUa()).mo10188a((C1850u<? super T>) new C1850u<List<TemplateInfo>>() {
            /* renamed from: a */
            public void mo9883a(C1495b bVar) {
            }

            public void onError(Throwable th) {
            }

            public void onSuccess(List<TemplateInfo> list) {
                if (list == null || list.size() == 0) {
                    FunnyCategoryFragment.this.mo30316pf(1);
                } else if (list.size() > 50) {
                    FunnyCategoryFragment.this.m19750aM(list.subList(0, 50));
                } else {
                    FunnyCategoryFragment.this.m19750aM(list);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void aru() {
        if (this.dgp != null) {
            this.dgp.clear();
        }
        this.dgl.setVisibility(8);
        this.dgm.setVisibility(0);
    }

    /* access modifiers changed from: private */
    /* renamed from: bD */
    public List<TemplateInfo> m19753bD(List<TemplateResponseInfo> list) {
        ArrayList arrayList = new ArrayList();
        if (list.size() > 0) {
            for (TemplateResponseInfo templateResponseInfo : list) {
                TemplateInfo templateInfo = new TemplateInfo();
                templateInfo.ttid = templateResponseInfo.index;
                templateInfo.strTitle = templateResponseInfo.name;
                templateInfo.strScene = templateResponseInfo.sceneName;
                templateInfo.strIcon = templateResponseInfo.thumbUrl;
                arrayList.add(templateInfo);
            }
        }
        return arrayList;
    }

    /* renamed from: co */
    private void m19755co(View view) {
        this.dgm = (LinearLayout) view.findViewById(R.id.empty_layout);
        this.dgn = (TextView) view.findViewById(R.id.btn_retry);
        C2579b.m7399a(new C2582a<View>() {
            public void onClick(View view) {
                C4586g.m11704a((Context) FunnyCategoryFragment.this.getActivity(), R.string.xiaoying_str_com_loading, (OnCancelListener) null, false);
                FunnyCategoryFragment.this.mo30316pf(1);
            }
        }, this.dgn);
        this.f3514Vu = (RecyclerView) view.findViewById(R.id.rec_template_info);
        this.f3514Vu.setLayoutManager(new GridLayoutManager(getContext(), 2));
        this.cNJ = new CustomRecyclerViewAdapter();
        this.f3514Vu.setAdapter(this.cNJ);
        this.dgl = (SwipeRefreshLayout) view.findViewById(R.id.funny_template_refresh);
        this.dgl.setOnRefreshListener(this.dgr);
        this.dgl.setColorSchemeResources(R.color.color_ff8e00);
        StringBuilder sb = new StringBuilder();
        sb.append("key_pref_pkg_funny_detail_refresh_last_time_");
        sb.append(this.dgo);
        dgk = sb.toString();
        String appSettingStr = AppPreferencesSetting.getInstance().getAppSettingStr(dgk, "");
        if (TextUtils.isEmpty(appSettingStr) || Math.abs(System.currentTimeMillis() - C2575a.parseLong(appSettingStr)) > 43200000) {
            mo30316pf(1);
        } else {
            art();
        }
    }

    /* renamed from: iv */
    public static FunnyCategoryFragment m19758iv(String str) {
        FunnyCategoryFragment funnyCategoryFragment = new FunnyCategoryFragment();
        Bundle bundle = new Bundle();
        bundle.putString("funny_template_group_code", str);
        funnyCategoryFragment.setArguments(bundle);
        return funnyCategoryFragment;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.dgo = getArguments().getString("funny_template_group_code");
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.editor_funny_category_fragment_layout, viewGroup, false);
        m19755co(inflate);
        return inflate;
    }

    public void onDestroyView() {
        super.onDestroyView();
        if (this.dgq != null) {
            this.dgq.removeCallbacksAndMessages(null);
        }
    }

    /* renamed from: pf */
    public void mo30316pf(final int i) {
        C8659b.m25232o(this.dgo, String.valueOf(QEngine.VERSION_NUMBER), String.valueOf(i), String.valueOf(50)).mo10196g(C1820a.aVi()).mo10194f(C1820a.aVi()).mo10199i(new C1518f<C9768m<TemplateResponseList>, List<TemplateInfo>>() {
            /* renamed from: a */
            public List<TemplateInfo> apply(C9768m<TemplateResponseList> mVar) throws Exception {
                List<TemplateInfo> b = (mVar == null || mVar.baI() == null) ? null : FunnyCategoryFragment.this.m19753bD(((TemplateResponseList) mVar.baI()).templateInfoList);
                if (i == 1) {
                    C8742k.aMi().mo35181f(FunnyCategoryFragment.this.getContext(), FunnyCategoryFragment.this.dgo, b);
                }
                return b;
            }
        }).mo10194f(C1487a.aUa()).mo10188a((C1850u<? super T>) new C1850u<List<TemplateInfo>>() {
            /* renamed from: a */
            public void mo9883a(C1495b bVar) {
            }

            public void onError(Throwable th) {
                C4586g.m11696Sm();
                FunnyCategoryFragment.this.dgq.sendEmptyMessage(12292);
                FunnyCategoryFragment.this.dgq.sendMessage(FunnyCategoryFragment.this.dgq.obtainMessage(16385, Integer.valueOf(65536)));
            }

            public void onSuccess(List<TemplateInfo> list) {
                C4586g.m11696Sm();
                AppPreferencesSetting instance = AppPreferencesSetting.getInstance();
                String access$400 = FunnyCategoryFragment.dgk;
                StringBuilder sb = new StringBuilder();
                sb.append("");
                sb.append(System.currentTimeMillis());
                instance.setAppSettingStr(access$400, sb.toString());
                List<TemplateInfo> arrayList = new ArrayList<>();
                if (list != null) {
                    if (i != 1) {
                        arrayList.addAll(FunnyCategoryFragment.this.dgp);
                        arrayList.addAll(list);
                    }
                    FunnyCategoryFragment.this.m19750aM(list);
                    FunnyCategoryFragment.this.dgq.sendMessage(FunnyCategoryFragment.this.dgq.obtainMessage(16385, Integer.valueOf(131072)));
                }
                list = arrayList;
                FunnyCategoryFragment.this.m19750aM(list);
                FunnyCategoryFragment.this.dgq.sendMessage(FunnyCategoryFragment.this.dgq.obtainMessage(16385, Integer.valueOf(131072)));
            }
        });
    }
}
