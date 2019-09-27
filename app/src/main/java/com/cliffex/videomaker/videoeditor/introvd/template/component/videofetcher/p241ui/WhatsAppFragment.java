package com.introvd.template.component.videofetcher.p241ui;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.p021v4.app.Fragment;
import android.support.p021v4.widget.SwipeRefreshLayout;
import android.support.p021v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.support.p024v7.widget.RecyclerView;
import android.support.p024v7.widget.RecyclerView.C1018h;
import android.support.p024v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.introvd.template.component.videofetcher.C5365b;
import com.introvd.template.component.videofetcher.C5390c;
import com.introvd.template.component.videofetcher.C5402d;
import com.introvd.template.component.videofetcher.R;
import com.introvd.template.component.videofetcher.p238b.C5388f;
import com.introvd.template.component.videofetcher.p239c.C5399i;
import com.introvd.template.component.videofetcher.p240d.C5403a;
import com.introvd.template.component.videofetcher.utils.C5489g;
import com.introvd.template.component.videofetcher.view.C5502a;
import com.introvd.template.component.videofetcher.view.C5513h;
import com.introvd.template.component.videofetcher.view.C5513h.C5515a;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import p037b.p050b.C1834l;
import p037b.p050b.C1838m;
import p037b.p050b.C1839n;
import p037b.p050b.C1840o;
import p037b.p050b.C1842q;
import p037b.p050b.p051a.p053b.C1487a;
import p037b.p050b.p054b.C1495b;
import p037b.p050b.p057e.C1518f;
import p037b.p050b.p076j.C1820a;

/* renamed from: com.introvd.template.component.videofetcher.ui.WhatsAppFragment */
public class WhatsAppFragment extends Fragment implements OnClickListener {
    private View btV;
    /* access modifiers changed from: private */
    public C5388f cmj;
    /* access modifiers changed from: private */
    public LinearLayout cmk;
    /* access modifiers changed from: private */
    public RecyclerView cml;
    private ImageView cmm;
    /* access modifiers changed from: private */
    public SwipeRefreshLayout cmn;
    C1495b cmo;

    /* renamed from: com.introvd.template.component.videofetcher.ui.WhatsAppFragment$a */
    public class C5478a implements C1518f<C1834l<? extends Throwable>, C1834l<?>> {
        /* access modifiers changed from: private */
        public final int bcK;
        /* access modifiers changed from: private */
        public final int bcN;
        /* access modifiers changed from: private */
        public int retryCount;

        C5478a(int i, int i2) {
            this.bcN = i;
            this.bcK = i2;
        }

        /* renamed from: a */
        static /* synthetic */ int m14878a(C5478a aVar) {
            int i = aVar.retryCount + 1;
            aVar.retryCount = i;
            return i;
        }

        /* renamed from: b */
        public C1834l<?> apply(C1834l<? extends Throwable> lVar) {
            return lVar.mo10162e((C1518f<? super T, ? extends C1840o<? extends R>>) new C1518f<Throwable, C1834l<?>>() {
                /* renamed from: o */
                public C1834l<?> apply(Throwable th) {
                    if (C5478a.m14878a(C5478a.this) > C5478a.this.bcN) {
                        return C1834l.m5263w(th);
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append("Get Error, it will try after ");
                    sb.append(C5478a.this.bcK);
                    sb.append(" millisecond, retry count ");
                    sb.append(C5478a.this.retryCount);
                    C5489g.m14903e("RetryWithDelay", sb.toString());
                    return C1834l.m5261d((long) C5478a.this.bcK, TimeUnit.MILLISECONDS);
                }
            });
        }
    }

    /* renamed from: Oj */
    private void m14860Oj() {
        ((TextView) this.btV.findViewById(R.id.fetcher_title)).setText(getResources().getString(R.string.video_fetcher_str_toolbar_status_title));
        this.cml = (RecyclerView) this.btV.findViewById(R.id.whatsapp_recycle);
        this.cmk = (LinearLayout) this.btV.findViewById(R.id.whatsapp_empty);
        this.cmm = (ImageView) this.btV.findViewById(R.id.fetcher_back);
        this.cmn = (SwipeRefreshLayout) this.btV.findViewById(R.id.whatsapp_swiperefresh);
        this.cml.setLayoutManager(new StaggeredGridLayoutManager(2, 1));
        if (getActivity() != null) {
            this.cmj = new C5388f(getActivity().getApplicationContext());
            this.cml.mo7733a((C1018h) new C5502a());
            this.cml.setAdapter(this.cmj);
        }
        this.cmj.mo26972a((C5403a<C5399i>) new C5403a<C5399i>() {
            /* renamed from: b */
            public void mo27031c(int i, C5399i iVar) {
                if (WhatsAppFragment.this.getActivity() != null) {
                    C5402d.m14716ZG().mo27029a(WhatsAppFragment.this.getActivity().getApplicationContext(), "Video_Downloader_WhatsApp_Video_Click", new HashMap());
                }
                WhatsAppFragment.this.m14861a(i, iVar);
            }
        });
        this.cmm.setOnClickListener(this);
        this.cmn.setOnRefreshListener(new OnRefreshListener() {
            public void onRefresh() {
                WhatsAppFragment.this.aaA();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m14861a(int i, final C5399i iVar) {
        if (getActivity() != null) {
            final C5513h hVar = new C5513h(getActivity());
            hVar.mo27229a((C5515a) new C5515a() {
                public void aao() {
                    if (WhatsAppFragment.this.getActivity() != null) {
                        ShareActivity.m14793b(WhatsAppFragment.this.getActivity(), iVar.getPath(), 19, iVar.mo27010ZP());
                    }
                    hVar.dismiss();
                }
            });
            if (!getActivity().isFinishing()) {
                hVar.show();
            }
        }
    }

    /* access modifiers changed from: private */
    @SuppressLint({"CheckResult"})
    public void aaA() {
        if (this.cmn != null) {
            this.cmn.setRefreshing(true);
        }
        if (getActivity() == null) {
            if (this.cmn != null && this.cmn.isRefreshing()) {
                this.cmn.setRefreshing(false);
            }
            this.cml.setVisibility(8);
            this.cmk.setVisibility(0);
            m14865ad("video_amount", String.valueOf(0));
            return;
        }
        final C5390c ZH = C5402d.m14716ZG().mo27026ZH();
        if (ZH == null) {
            if (this.cmn != null && this.cmn.isRefreshing()) {
                this.cmn.setRefreshing(false);
            }
            this.cml.setVisibility(8);
            this.cmk.setVisibility(0);
            m14865ad("video_amount", String.valueOf(0));
            return;
        }
        C1834l.m5254a((C1839n<T>) new C1839n<List<C5399i>>() {
            /* renamed from: a */
            public void mo10177a(final C1838m<List<C5399i>> mVar) throws Exception {
                ZH.mo24463a(new C5365b() {
                    /* renamed from: aB */
                    public void mo26935aB(List<C5399i> list) {
                        if (WhatsAppFragment.this.cmn != null && WhatsAppFragment.this.cmn.isRefreshing()) {
                            WhatsAppFragment.this.cmn.setRefreshing(false);
                        }
                        if (list == null || list.size() <= 0) {
                            mVar.mo9791K(list);
                            return;
                        }
                        WhatsAppFragment.this.m14865ad("video_amount", String.valueOf(list.size()));
                        if (WhatsAppFragment.this.cmj != null) {
                            WhatsAppFragment.this.cml.setVisibility(0);
                            WhatsAppFragment.this.cmk.setVisibility(8);
                            WhatsAppFragment.this.cmj.setData(list);
                            StringBuilder sb = new StringBuilder();
                            sb.append("updateFotWhatsapp--");
                            sb.append(list.size());
                            C5489g.m14902d("ruomiz", sb.toString());
                        }
                    }
                });
            }
        }).mo10157d(C1820a.aVi()).mo10152c(C1820a.aVi()).mo10162e((C1518f<? super T, ? extends C1840o<? extends R>>) new C1518f<List<C5399i>, C1840o<List<C5399i>>>() {
            /* renamed from: aE */
            public C1840o<List<C5399i>> apply(List<C5399i> list) throws Exception {
                if (list != null && list.size() != 0) {
                    return C1834l.m5257ah(list);
                }
                throw new RuntimeException("data empty,please retry!");
            }
        }).mo10170g((C1518f<? super C1834l<Throwable>, ? extends C1840o<?>>) new C5478a<Object,Object>(10, 200)).mo10152c(C1487a.aUa()).mo10149b((C1842q<? super T>) new C1842q<List<C5399i>>() {
            /* renamed from: R */
            public void mo9886K(List<C5399i> list) {
                if (WhatsAppFragment.this.cmn != null && WhatsAppFragment.this.cmn.isRefreshing()) {
                    WhatsAppFragment.this.cmn.setRefreshing(false);
                }
                if (list == null || list.size() <= 0) {
                    C5489g.m14902d("ruomiz", "whatsapp--埋点为0");
                    WhatsAppFragment.this.m14865ad("video_amount", String.valueOf(0));
                    WhatsAppFragment.this.cml.setVisibility(8);
                    WhatsAppFragment.this.cmk.setVisibility(0);
                    return;
                }
                WhatsAppFragment.this.m14865ad("video_amount", String.valueOf(list.size()));
                StringBuilder sb = new StringBuilder();
                sb.append("whatsapp--埋点为-");
                sb.append(list.size());
                C5489g.m14902d("ruomiz", sb.toString());
                if (WhatsAppFragment.this.cmj != null) {
                    WhatsAppFragment.this.cml.setVisibility(0);
                    WhatsAppFragment.this.cmk.setVisibility(8);
                    WhatsAppFragment.this.cmj.setData(list);
                }
            }

            /* renamed from: a */
            public void mo9877a(C1495b bVar) {
                WhatsAppFragment.this.cmo = bVar;
            }

            public void onComplete() {
            }

            public void onError(Throwable th) {
                C5489g.m14902d("ruomiz", "onError--whatsapp--埋点为0");
                WhatsAppFragment.this.m14865ad("video_amount", String.valueOf(0));
                if (WhatsAppFragment.this.cmn != null && WhatsAppFragment.this.cmn.isRefreshing()) {
                    WhatsAppFragment.this.cmn.setRefreshing(false);
                }
                WhatsAppFragment.this.cml.setVisibility(8);
                WhatsAppFragment.this.cmk.setVisibility(0);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: ad */
    public void m14865ad(String str, String str2) {
        if (getActivity() != null) {
            HashMap hashMap = new HashMap();
            hashMap.put(str, str2);
            C5402d.m14716ZG().mo27029a(getActivity().getApplicationContext(), "Video_Downloader_Whatsapp_Video_Amount", hashMap);
        }
    }

    public void onClick(View view) {
        if (getParentFragment() != null) {
            getParentFragment().getChildFragmentManager().beginTransaction().hide(this).commit();
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.btV = layoutInflater.inflate(R.layout.fetcher_frag_whatsapp, viewGroup, false);
        m14860Oj();
        aaA();
        return this.btV;
    }

    public void onDestroyView() {
        super.onDestroyView();
        if (this.cmo != null) {
            this.cmo.dispose();
        }
    }

    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (!z) {
            aaA();
        } else if (this.cmn != null && this.cmn.isRefreshing()) {
            this.cmn.setRefreshing(false);
        }
    }
}
