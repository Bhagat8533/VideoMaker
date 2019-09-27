package com.introvd.template.explorer.music.local;

import android.os.Bundle;
import android.support.p024v7.widget.LinearLayoutManager;
import android.support.p024v7.widget.RecyclerView;
import android.support.p024v7.widget.RecyclerView.C1022l;
import com.introvd.template.VivaBaseApplication;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.common.recycleviewutil.BaseItem;
import com.introvd.template.common.recycleviewutil.CustomRecyclerViewAdapter;
import com.introvd.template.explorer.C7134a;
import com.introvd.template.explorer.music.MusicSubBaseFragment;
import com.introvd.template.explorer.music.item.C7296a;
import com.introvd.template.explorer.music.item.C7297b;
import com.introvd.template.explorer.music.item.C7297b.C7300a;
import com.introvd.template.explorer.music.item.C7302d;
import com.introvd.template.explorer.music.p303a.C7256a;
import com.introvd.template.explorer.music.p305c.C7272a;
import com.introvd.template.explorer.music.p306d.C7273a;
import com.introvd.template.explorer.music.p306d.p307a.C7274a;
import com.introvd.template.explorer.music.p306d.p307a.C7275b;
import com.introvd.template.explorer.music.p306d.p307a.C7276c;
import com.introvd.template.explorer.p296a.C7135a;
import com.introvd.template.router.explorer.ExplorerRouter;
import com.introvd.template.template.data.api.model.TemplateAudioCategory;
import com.introvd.template.template.data.p406db.model.DBTemplateAudioInfo;
import com.introvd.template.vivaexplorermodule.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.greenrobot.eventbus.C10021c;
import org.greenrobot.eventbus.C10031j;
import org.greenrobot.eventbus.ThreadMode;
import p037b.p050b.C1834l;
import p037b.p050b.C1838m;
import p037b.p050b.C1839n;
import p037b.p050b.C1842q;
import p037b.p050b.p051a.p053b.C1487a;
import p037b.p050b.p054b.C1494a;
import p037b.p050b.p054b.C1495b;
import p037b.p050b.p057e.C1517e;
import p037b.p050b.p057e.C1518f;
import p037b.p050b.p076j.C1820a;

public class LocalSubFragment extends MusicSubBaseFragment {
    private CustomRecyclerViewAdapter cNJ;
    /* access modifiers changed from: private */
    public C1494a compositeDisposable;
    /* access modifiers changed from: private */
    public List<BaseItem> dAO = Collections.synchronizedList(new ArrayList());
    private TemplateAudioCategory dAR;
    /* access modifiers changed from: private */
    public C1838m<Boolean> dAV;
    /* access modifiers changed from: private */
    public C1838m<Boolean> dAW;
    C7300a dBv = new C7300a() {
        public void axq() {
            if (LocalSubFragment.this.dAO != null && LocalSubFragment.this.dAO.size() > 1) {
                LocalSubFragment.this.dAO.remove(0);
                LocalSubFragment.this.m21581bT(LocalSubFragment.this.dAO);
            }
            C7256a.m21417fW(VivaBaseApplication.m8749FZ());
            LocalSubFragment.this.dCn = true;
            C10021c.aZH().mo38492aA(new C7274a());
        }
    };
    private RecyclerView dCj;
    private LinearLayoutManager dCk;
    private List<BaseItem> dCl = new ArrayList();
    private BaseItem dCm;
    /* access modifiers changed from: private */
    public boolean dCn = false;

    public static LocalSubFragment axI() {
        LocalSubFragment localSubFragment = new LocalSubFragment();
        localSubFragment.setArguments(new Bundle());
        return localSubFragment;
    }

    private void axa() {
        if (C7135a.avU().avV()) {
            this.dCj.mo7737a((C1022l) new C1022l() {
                /* renamed from: d */
                public void mo8096d(RecyclerView recyclerView, int i) {
                    super.mo8096d(recyclerView, i);
                    if (i == 0) {
                        if (LocalSubFragment.this.dAV != null) {
                            LocalSubFragment.this.dAV.mo9791K(Boolean.valueOf(true));
                        }
                    } else if (LocalSubFragment.this.dAW != null) {
                        LocalSubFragment.this.dAW.mo9791K(Boolean.valueOf(true));
                    }
                }
            });
        } else {
            C7272a.m21455qU(4);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: bT */
    public void m21581bT(List<BaseItem> list) {
        if (this.cNJ != null && list != null) {
            list.remove(this.dCm);
            list.add(this.dCm);
            this.cNJ.setData(list);
        }
    }

    /* renamed from: ji */
    private List<BaseItem> m21585ji(String str) {
        C7273a.dCz = str;
        this.dCl.clear();
        if (this.dAO == null || this.dAO.size() < 1) {
            return this.dCl;
        }
        for (BaseItem baseItem : this.dAO) {
            if (baseItem instanceof C7302d) {
                DBTemplateAudioInfo dBTemplateAudioInfo = (DBTemplateAudioInfo) ((C7302d) baseItem).getItemData();
                if (dBTemplateAudioInfo.name.toUpperCase().contains(str.toUpperCase())) {
                    this.dCl.add(baseItem);
                }
            }
        }
        return this.dCl;
    }

    /* access modifiers changed from: protected */
    /* renamed from: Oj */
    public void mo31811Oj() {
        this.dCj = (RecyclerView) this.btV.findViewById(R.id.xiaoying_music_local_list);
        this.cNJ = new CustomRecyclerViewAdapter();
        this.dCk = new LinearLayoutManager(getContext());
        this.dCj.setLayoutManager(this.dCk);
        this.dCj.setAdapter(this.cNJ);
        this.dAR = new TemplateAudioCategory();
        this.dAR.index = "-1";
        this.dAR.name = "Local";
        C7273a.dCz = "";
        axa();
    }

    /* access modifiers changed from: protected */
    public int awP() {
        return 3;
    }

    /* access modifiers changed from: protected */
    public TemplateAudioCategory awQ() {
        return this.dAR;
    }

    /* access modifiers changed from: protected */
    public List<BaseItem> awR() {
        return this.dAO;
    }

    /* access modifiers changed from: protected */
    public void axH() {
        LogUtilsV2.m14227d("initData");
        C1834l.m5257ah(Boolean.valueOf(true)).mo10164f(500, TimeUnit.MILLISECONDS).mo10157d(C1820a.aVi()).mo10152c(C1820a.aVi()).mo10167f((C1518f<? super T, ? extends R>) new C1518f<Boolean, List<BaseItem>>() {
            /* renamed from: i */
            public List<BaseItem> apply(Boolean bool) {
                return C7272a.m21452b(LocalSubFragment.this, C7319a.axF().mo31944O(LocalSubFragment.this.getContext(), true));
            }
        }).mo10152c(C1487a.aUa()).mo10149b((C1842q<? super T>) new C1842q<List<BaseItem>>() {
            /* renamed from: R */
            public void mo9886K(List<BaseItem> list) {
                StringBuilder sb = new StringBuilder();
                sb.append("onNext == ");
                sb.append(list.size());
                LogUtilsV2.m14227d(sb.toString());
                LocalSubFragment.this.dAO.clear();
                LocalSubFragment.this.dAO.addAll(list);
                if (LocalSubFragment.this.dAO.size() > 1) {
                    LocalSubFragment.this.btV.findViewById(R.id.music_empty_view).setVisibility(8);
                    if (LocalSubFragment.this.dAO.get(0) instanceof C7297b) {
                        ((C7297b) list.get(0)).mo31899a(LocalSubFragment.this.dBv);
                    }
                }
                LocalSubFragment.this.m21581bT(LocalSubFragment.this.dAO);
            }

            /* renamed from: a */
            public void mo9877a(C1495b bVar) {
                LocalSubFragment.this.compositeDisposable.mo9785e(bVar);
            }

            public void onComplete() {
            }

            public void onError(Throwable th) {
                StringBuilder sb = new StringBuilder();
                sb.append("onError == ");
                sb.append(th.getMessage());
                LogUtilsV2.m14227d(sb.toString());
            }
        });
    }

    /* access modifiers changed from: protected */
    public String getCategoryId() {
        return "-1";
    }

    /* access modifiers changed from: protected */
    public int getLayoutId() {
        return R.layout.xiaoying_music_local_list_fragment;
    }

    /* access modifiers changed from: protected */
    public void initData() {
        this.dCm = new C7296a(this, VivaBaseApplication.m8749FZ().getString(R.string.xiaoying_str_community_load_finish_nomore_tip));
        this.compositeDisposable = new C1494a();
        C1495b g = C1834l.m5254a((C1839n<T>) new C1839n<Boolean>() {
            /* renamed from: a */
            public void mo10177a(C1838m<Boolean> mVar) throws Exception {
                LocalSubFragment.this.dAV = mVar;
            }
        }).mo10157d(C1487a.aUa()).mo10151c(300, TimeUnit.MILLISECONDS, C1487a.aUa()).mo10152c(C1487a.aUa()).mo10168g((C1517e<? super T>) new C1517e<Boolean>() {
            /* renamed from: d */
            public void accept(Boolean bool) throws Exception {
                C7272a.m21455qU(1);
            }
        });
        C1495b g2 = C1834l.m5254a((C1839n<T>) new C1839n<Boolean>() {
            /* renamed from: a */
            public void mo10177a(C1838m<Boolean> mVar) throws Exception {
                LocalSubFragment.this.dAW = mVar;
            }
        }).mo10157d(C1487a.aUa()).mo10151c(100, TimeUnit.MILLISECONDS, C1487a.aUa()).mo10152c(C1487a.aUa()).mo10168g((C1517e<? super T>) new C1517e<Boolean>() {
            /* renamed from: d */
            public void accept(Boolean bool) throws Exception {
                C7272a.m21455qU(2);
            }
        });
        this.compositeDisposable.mo9785e(g);
        this.compositeDisposable.mo9785e(g2);
    }

    public void onDestroyView() {
        C7273a.dCz = "";
        C7273a.m21457av(getActivity());
        super.onDestroyView();
        if (this.compositeDisposable != null) {
            this.compositeDisposable.clear();
        }
    }

    @C10031j(aZK = ThreadMode.MAIN)
    public void onEventMainThread(C7275b bVar) {
        this.dCn = false;
        if (this.dAO != null && this.dAO.size() > 0 && !(this.dAO.get(0) instanceof C7297b)) {
            C7297b bVar2 = new C7297b(this, true);
            bVar2.mo31899a(this.dBv);
            this.dAO.add(0, bVar2);
            C7273a.dCz = "";
            m21581bT(this.dAO);
            this.dCk.scrollToPositionWithOffset(0, 0);
        }
    }

    @C10031j(aZK = ThreadMode.MAIN)
    public void onEventMainThread(C7276c cVar) {
        m21581bT(m21585ji(cVar.filter));
    }

    @C10031j(aZK = ThreadMode.MAIN)
    public void onFileChooseEvent(C7134a aVar) {
        if (getActivity() != null && aVar != null && aVar.getFilePath() != null) {
            ExplorerRouter.launchVideoExtractActivity(getActivity(), aVar.getFilePath(), -1);
        }
    }

    public void onResume() {
        super.onResume();
        if (!this.dCn) {
            axH();
        }
    }
}
