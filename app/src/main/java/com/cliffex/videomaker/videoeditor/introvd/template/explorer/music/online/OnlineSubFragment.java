package com.introvd.template.explorer.music.online;

import android.os.Bundle;
import android.support.p021v4.widget.SwipeRefreshLayout;
import android.support.p024v7.widget.LinearLayoutManager;
import android.support.p024v7.widget.RecyclerView;
import android.support.p024v7.widget.RecyclerView.C1022l;
import android.text.TextUtils;
import com.introvd.template.VivaBaseApplication;
import com.introvd.template.common.AppPreferencesSetting;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.common.filecache.FileCache;
import com.introvd.template.common.filecache.FileCache.Builder;
import com.introvd.template.common.recycleviewutil.BaseItem;
import com.introvd.template.common.recycleviewutil.CustomRecyclerViewAdapter;
import com.introvd.template.common.recycleviewutil.CustomRecyclerViewAdapter.VisibleListener;
import com.introvd.template.explorer.music.MusicSubBaseFragment;
import com.introvd.template.explorer.music.item.C7296a;
import com.introvd.template.explorer.music.p304b.C7263b;
import com.introvd.template.explorer.music.p305c.C7272a;
import com.introvd.template.explorer.p296a.C7135a;
import com.introvd.template.p203b.C4600l;
import com.introvd.template.router.explorer.ExplorerRouter.MusicParams;
import com.introvd.template.template.data.api.C8659b;
import com.introvd.template.template.data.api.model.TemplateAudioCategory;
import com.introvd.template.template.data.api.model.TemplateAudioInfoList;
import com.introvd.template.vivaexplorermodule.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;
import org.greenrobot.eventbus.C10031j;
import org.greenrobot.eventbus.ThreadMode;
import p037b.p050b.C1834l;
import p037b.p050b.C1838m;
import p037b.p050b.C1839n;
import p037b.p050b.C1842q;
import p037b.p050b.C1850u;
import p037b.p050b.p051a.p053b.C1487a;
import p037b.p050b.p054b.C1494a;
import p037b.p050b.p054b.C1495b;
import p037b.p050b.p057e.C1514b;
import p037b.p050b.p057e.C1517e;
import p037b.p050b.p057e.C1518f;
import p037b.p050b.p073g.C1810c;
import p037b.p050b.p076j.C1820a;
import p469f.C9768m;

public class OnlineSubFragment extends MusicSubBaseFragment {
    public Map<String, C1495b> cLq = new HashMap();
    private CustomRecyclerViewAdapter cNl;
    private C1494a compositeDisposable;
    /* access modifiers changed from: private */
    public List<BaseItem> dAO = Collections.synchronizedList(new ArrayList());
    private String dAQ;
    /* access modifiers changed from: private */
    public TemplateAudioCategory dAR;
    /* access modifiers changed from: private */
    public C1838m<Boolean> dAV;
    /* access modifiers changed from: private */
    public C1838m<Boolean> dAW;
    private String dBe = "template/audio";
    /* access modifiers changed from: private */
    public FileCache<TemplateAudioInfoList> dBg;
    public SwipeRefreshLayout dCq;
    /* access modifiers changed from: private */
    public int dCr;
    /* access modifiers changed from: private */
    public boolean dCs;
    /* access modifiers changed from: private */
    public boolean dCt;
    /* access modifiers changed from: private */
    public int musicType = 1;

    /* access modifiers changed from: private */
    public void axL() {
        if (this.cNl != null) {
            this.cNl.setData(this.dAO);
        }
        this.dCq.setRefreshing(false);
        this.dCq.setEnabled(false);
    }

    private void axb() {
        this.compositeDisposable = new C1494a();
        C1495b g = C1834l.m5254a((C1839n<T>) new C1839n<Boolean>() {
            /* renamed from: a */
            public void mo10177a(C1838m<Boolean> mVar) throws Exception {
                OnlineSubFragment.this.dAV = mVar;
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
                OnlineSubFragment.this.dAW = mVar;
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

    /* renamed from: b */
    public static OnlineSubFragment m21604b(TemplateAudioCategory templateAudioCategory, int i) {
        OnlineSubFragment onlineSubFragment = new OnlineSubFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("key_intent_music_category_info", templateAudioCategory);
        bundle.putInt(MusicParams.EXTRA_INT_TYPE, i);
        onlineSubFragment.setArguments(bundle);
        return onlineSubFragment;
    }

    /* renamed from: m */
    private void m21616m(RecyclerView recyclerView) {
        if (C7135a.avU().avV()) {
            recyclerView.mo7737a((C1022l) new C1022l() {
                /* renamed from: d */
                public void mo8096d(RecyclerView recyclerView, int i) {
                    super.mo8096d(recyclerView, i);
                    if (i == 0) {
                        if (OnlineSubFragment.this.dAV != null) {
                            OnlineSubFragment.this.dAV.mo9791K(Boolean.valueOf(true));
                        }
                    } else if (OnlineSubFragment.this.dAW != null) {
                        OnlineSubFragment.this.dAW.mo9791K(Boolean.valueOf(true));
                    }
                }
            });
        } else {
            C7272a.m21455qU(4);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: Oj */
    public void mo31811Oj() {
        this.dCq = (SwipeRefreshLayout) this.btV.findViewById(R.id.music_swipe_refresh_layout);
        this.dCq.setRefreshing(true);
        this.dCq.setColorSchemeColors(getResources().getColor(R.color.color_ff5e13));
        RecyclerView recyclerView = (RecyclerView) this.btV.findViewById(R.id.music_recycle_view);
        this.cNl = new CustomRecyclerViewAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(this.cNl);
        this.cNl.setOnVisibleListener(new VisibleListener() {
            public void onItemVisible(int i, BaseItem baseItem) {
                if (!OnlineSubFragment.this.dCs && i > OnlineSubFragment.this.dAO.size() - 20 && !OnlineSubFragment.this.dCt) {
                    OnlineSubFragment.this.dCt = true;
                    OnlineSubFragment.this.mo31949pf(OnlineSubFragment.this.dCr);
                }
            }
        });
        m21616m(recyclerView);
    }

    /* access modifiers changed from: protected */
    public int awP() {
        return 1;
    }

    /* access modifiers changed from: protected */
    public TemplateAudioCategory awQ() {
        return this.dAR;
    }

    /* access modifiers changed from: protected */
    public List<BaseItem> awR() {
        return this.dAO;
    }

    public void axK() {
        if (this.dBg == null) {
            this.dBg = new Builder(getContext(), TemplateAudioInfoList.class).setRelativeDir(this.dBe).setCacheKey(this.dAQ).build();
        }
        this.dBg.getCache().mo10164f(100, TimeUnit.MILLISECONDS).mo10152c(C1820a.aVi()).mo10167f((C1518f<? super T, ? extends R>) new C1518f<TemplateAudioInfoList, List<BaseItem>>() {
            /* renamed from: a */
            public List<BaseItem> apply(TemplateAudioInfoList templateAudioInfoList) {
                if (templateAudioInfoList.audioInfoList.size() < 50) {
                    OnlineSubFragment.this.dCs = true;
                }
                return C7272a.m21449a(OnlineSubFragment.this, templateAudioInfoList, OnlineSubFragment.this.dAR, 50, OnlineSubFragment.this.musicType);
            }
        }).mo10152c(C1487a.aUa()).mo10149b((C1842q<? super T>) new C1842q<List<BaseItem>>() {
            /* renamed from: R */
            public void mo9886K(List<BaseItem> list) {
                OnlineSubFragment.this.dAO.clear();
                OnlineSubFragment.this.dAO.addAll(list);
                if (!OnlineSubFragment.this.dCs) {
                    OnlineSubFragment.this.dAO.add(new C7296a(OnlineSubFragment.this));
                } else {
                    OnlineSubFragment.this.dAO.add(new C7296a(OnlineSubFragment.this, VivaBaseApplication.m8749FZ().getString(R.string.xiaoying_str_community_load_finish_nomore_tip)));
                }
                StringBuilder sb = new StringBuilder();
                sb.append("Read Cache onNext = ");
                sb.append(list.size());
                LogUtilsV2.m14227d(sb.toString());
                OnlineSubFragment.this.axL();
                OnlineSubFragment.this.dCr = OnlineSubFragment.this.dCr + 1;
                if (OnlineSubFragment.this.axM() && !OnlineSubFragment.this.dCt) {
                    OnlineSubFragment.this.dCt = true;
                    OnlineSubFragment.this.dCr = 1;
                    OnlineSubFragment.this.mo31949pf(1);
                }
            }

            /* renamed from: a */
            public void mo9877a(C1495b bVar) {
            }

            public void onComplete() {
            }

            public void onError(Throwable th) {
                StringBuilder sb = new StringBuilder();
                sb.append("Read Cache onError = ");
                sb.append(th.getMessage());
                LogUtilsV2.m14227d(sb.toString());
                OnlineSubFragment.this.axL();
                OnlineSubFragment.this.dCr = OnlineSubFragment.this.dCr + 1;
                if (!OnlineSubFragment.this.dCt) {
                    OnlineSubFragment.this.dCt = true;
                    OnlineSubFragment.this.dCr = 1;
                    OnlineSubFragment.this.mo31949pf(1);
                }
            }
        });
    }

    public boolean axM() {
        long currentTimeMillis = System.currentTimeMillis();
        AppPreferencesSetting instance = AppPreferencesSetting.getInstance();
        StringBuilder sb = new StringBuilder();
        sb.append("OnlineSubFragment_last_update_time");
        sb.append(getCategoryId());
        return currentTimeMillis - instance.getAppSettingLong(sb.toString(), 0) > 14400000;
    }

    public void axN() {
        AppPreferencesSetting instance = AppPreferencesSetting.getInstance();
        StringBuilder sb = new StringBuilder();
        sb.append("OnlineSubFragment_last_update_time");
        sb.append(getCategoryId());
        instance.setAppSettingLong(sb.toString(), System.currentTimeMillis());
    }

    /* access modifiers changed from: protected */
    public String getCategoryId() {
        return this.dAQ;
    }

    /* access modifiers changed from: protected */
    public int getLayoutId() {
        return R.layout.xiaoying_music_online_list_fragment;
    }

    /* access modifiers changed from: protected */
    public void initData() {
        if (getArguments() != null) {
            this.dAR = (TemplateAudioCategory) getArguments().getSerializable("key_intent_music_category_info");
        }
        if (getArguments() != null) {
            this.musicType = getArguments().getInt(MusicParams.EXTRA_INT_TYPE);
        }
        if (this.musicType == 2) {
            this.dBe = "template/audio_effect";
        }
        if (this.dAR != null && !TextUtils.isEmpty(this.dAR.index)) {
            this.dAQ = this.dAR.index;
            axK();
            axb();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.cLq != null) {
            for (Entry value : this.cLq.entrySet()) {
                C1495b bVar = (C1495b) value.getValue();
                if (!bVar.aAy()) {
                    bVar.dispose();
                    LogUtilsV2.m14227d("disposable.dispose");
                }
            }
            this.cLq.clear();
            this.cLq = null;
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        if (this.compositeDisposable != null) {
            this.compositeDisposable.clear();
        }
    }

    @C10031j(aZK = ThreadMode.MAIN)
    public void onEventMainThread(C7263b bVar) {
        if (bVar != null && bVar.axk() != null) {
            String str = bVar.axk().dBj;
            if (!TextUtils.isEmpty(str) && str.equals(getCategoryId()) && bVar.axj() == 2) {
                LogUtilsV2.m14227d("Jamin MusicDBOperationEvent OPERATION_TYPE_DELETE");
                axK();
            }
        }
    }

    /* renamed from: pf */
    public void mo31949pf(int i) {
        if (!C4600l.m11739k(getActivity(), true)) {
            if (this.dAO == null || this.dAO.isEmpty()) {
                mo31817hZ(false);
            }
            this.dCt = false;
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("getDataFromServer pageIndex = ");
        sb.append(i);
        LogUtilsV2.m14227d(sb.toString());
        C8659b.m25230e(this.dAQ, 50, i, this.musicType).mo10196g(C1820a.aVi()).mo10194f(C1820a.aVi()).mo10199i(new C1518f<C9768m<TemplateAudioInfoList>, List<BaseItem>>() {
            /* renamed from: a */
            public List<BaseItem> apply(C9768m<TemplateAudioInfoList> mVar) {
                TemplateAudioInfoList templateAudioInfoList = (TemplateAudioInfoList) mVar.baI();
                if (OnlineSubFragment.this.dCr == 1) {
                    OnlineSubFragment.this.dBg.saveCache(templateAudioInfoList);
                }
                if (templateAudioInfoList.audioInfoList.size() < 50) {
                    OnlineSubFragment.this.dCs = true;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("templateAudioInfoList.audioInfoList = ");
                sb.append(templateAudioInfoList.audioInfoList.size());
                LogUtilsV2.m14227d(sb.toString());
                return C7272a.m21449a(OnlineSubFragment.this, templateAudioInfoList, OnlineSubFragment.this.dAR, 50, OnlineSubFragment.this.musicType);
            }
        }).mo10194f(C1487a.aUa()).mo10186a((C1514b<? super T, ? super Throwable>) new C1514b<List<BaseItem>, Throwable>() {
            /* renamed from: a */
            public void accept(List<BaseItem> list, Throwable th) {
                if (OnlineSubFragment.this.dCr == 1) {
                    OnlineSubFragment.this.axN();
                    C7272a.m21450a(1, null, 3);
                    OnlineSubFragment.this.dAO.clear();
                } else {
                    OnlineSubFragment.this.dAO.remove(OnlineSubFragment.this.dAO.size() - 1);
                }
                OnlineSubFragment.this.dAO.addAll(list);
                if (!OnlineSubFragment.this.dCs) {
                    OnlineSubFragment.this.dAO.add(new C7296a(OnlineSubFragment.this));
                } else {
                    OnlineSubFragment.this.dAO.add(new C7296a(OnlineSubFragment.this, OnlineSubFragment.this.getString(R.string.xiaoying_str_community_load_finish_nomore_tip)));
                }
            }
        }).mo10188a((C1850u<? super T>) new C1810c<List<BaseItem>>() {
            public void onError(Throwable th) {
                OnlineSubFragment.this.dCt = false;
            }

            public void onSuccess(List<BaseItem> list) {
                StringBuilder sb = new StringBuilder();
                sb.append("getFromServer onSuccess currentpage = ");
                sb.append(OnlineSubFragment.this.dCr);
                sb.append(",pagesize = ");
                sb.append(list.size());
                LogUtilsV2.m14227d(sb.toString());
                StringBuilder sb2 = new StringBuilder();
                sb2.append("getFromServer mItemDataList = ");
                sb2.append(OnlineSubFragment.this.dAO.size());
                LogUtilsV2.m14227d(sb2.toString());
                OnlineSubFragment.this.axL();
                OnlineSubFragment.this.dCr = OnlineSubFragment.this.dCr + 1;
                OnlineSubFragment.this.dCt = false;
            }
        });
    }
}
