package com.introvd.template.explorer.music.download;

import android.os.Bundle;
import android.support.p024v7.widget.LinearLayoutManager;
import android.support.p024v7.widget.RecyclerView;
import android.support.p024v7.widget.RecyclerView.C1022l;
import android.support.p024v7.widget.RecyclerView.C1034u;
import android.support.p024v7.widget.p031a.C1072a;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.introvd.template.VivaBaseApplication;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.common.recycleviewutil.BaseItem;
import com.introvd.template.explorer.music.MusicSubBaseFragment;
import com.introvd.template.explorer.music.download.C7292a.C7294a;
import com.introvd.template.explorer.music.item.C7296a;
import com.introvd.template.explorer.music.item.C7302d;
import com.introvd.template.explorer.music.p303a.C7256a;
import com.introvd.template.explorer.music.p304b.C7263b;
import com.introvd.template.explorer.music.p304b.C7269h;
import com.introvd.template.explorer.music.p305c.C7272a;
import com.introvd.template.explorer.p296a.C7135a;
import com.introvd.template.p203b.C4584e;
import com.introvd.template.p414ui.view.p415a.C8986a;
import com.introvd.template.p414ui.view.p415a.C8986a.C8989c;
import com.introvd.template.router.explorer.ExplorerRouter.MusicParams;
import com.introvd.template.template.data.api.model.TemplateAudioCategory;
import com.introvd.template.template.data.dao.C8682a;
import com.introvd.template.template.data.p406db.C8688b;
import com.introvd.template.template.data.p406db.model.DBTemplateAudioInfo;
import com.introvd.template.vivaexplorermodule.R;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.greenrobot.eventbus.C10031j;
import org.greenrobot.eventbus.ThreadMode;
import p037b.p050b.C1834l;
import p037b.p050b.C1838m;
import p037b.p050b.C1839n;
import p037b.p050b.C1842q;
import p037b.p050b.p051a.p053b.C1487a;
import p037b.p050b.p054b.C1494a;
import p037b.p050b.p054b.C1495b;
import p037b.p050b.p055c.C1505b;
import p037b.p050b.p057e.C1517e;
import p037b.p050b.p057e.C1518f;
import p037b.p050b.p076j.C1820a;

public class DownloadSubFragment extends MusicSubBaseFragment {
    public int chW = 0;
    private C1494a compositeDisposable;
    private final int dAM = 8;
    private C7292a dAN;
    private List<BaseItem> dAO = new ArrayList();
    List<DBTemplateAudioInfo> dAP = new ArrayList();
    /* access modifiers changed from: private */
    public String dAQ;
    private TemplateAudioCategory dAR;
    /* access modifiers changed from: private */
    public C8682a dAS;
    private RecyclerView dAT;
    boolean dAU;
    /* access modifiers changed from: private */
    public C1838m<Boolean> dAV;
    /* access modifiers changed from: private */
    public C1838m<Boolean> dAW;
    /* access modifiers changed from: private */
    public int musicType = 1;

    /* renamed from: a */
    public static DownloadSubFragment m21461a(TemplateAudioCategory templateAudioCategory, int i) {
        DownloadSubFragment downloadSubFragment = new DownloadSubFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("key_intent_music_category_info", templateAudioCategory);
        bundle.putInt(MusicParams.EXTRA_INT_TYPE, i);
        downloadSubFragment.setArguments(bundle);
        return downloadSubFragment;
    }

    private void axa() {
        if (C7135a.avU().avV()) {
            this.dAT.mo7737a((C1022l) new C1022l() {
                /* renamed from: d */
                public void mo8096d(RecyclerView recyclerView, int i) {
                    super.mo8096d(recyclerView, i);
                    if (i == 0) {
                        if (DownloadSubFragment.this.dAV != null) {
                            DownloadSubFragment.this.dAV.mo9791K(Boolean.valueOf(true));
                        }
                    } else if (DownloadSubFragment.this.dAW != null) {
                        DownloadSubFragment.this.dAW.mo9791K(Boolean.valueOf(true));
                    }
                }
            });
        } else {
            C7272a.m21455qU(4);
        }
    }

    private void axb() {
        this.compositeDisposable = new C1494a();
        C1495b g = C1834l.m5254a((C1839n<T>) new C1839n<Boolean>() {
            /* renamed from: a */
            public void mo10177a(C1838m<Boolean> mVar) throws Exception {
                DownloadSubFragment.this.dAV = mVar;
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
                DownloadSubFragment.this.dAW = mVar;
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

    private void axc() {
        if (this.dAQ != null && this.dAS != null) {
            C1834l.m5257ah(this.dAQ).mo10157d(C1820a.aVi()).mo10152c(C1820a.aVi()).mo10167f((C1518f<? super T, ? extends R>) new C1518f<String, List<BaseItem>>() {
                /* renamed from: jh */
                public List<BaseItem> apply(String str) {
                    DownloadSubFragment.this.axh();
                    DownloadSubFragment.this.dAP = DownloadSubFragment.this.dAS.mo35004O(DownloadSubFragment.this.dAQ, DownloadSubFragment.this.musicType == 2 ? 1 : 0);
                    if (DownloadSubFragment.this.dAP == null || DownloadSubFragment.this.dAP.size() == 0) {
                        throw C1505b.m4703z(new Throwable("NO Cache"));
                    }
                    C7302d g = DownloadSubFragment.this.axd();
                    StringBuilder sb = new StringBuilder();
                    sb.append("Jamin queryAudioByCategory list.size = ");
                    sb.append(DownloadSubFragment.this.dAP.size());
                    LogUtilsV2.m14227d(sb.toString());
                    ArrayList arrayList = new ArrayList();
                    for (DBTemplateAudioInfo dBTemplateAudioInfo : DownloadSubFragment.this.dAP) {
                        dBTemplateAudioInfo.isDownloaded = true;
                        dBTemplateAudioInfo.timeStr = C4584e.m11685ij(dBTemplateAudioInfo.duration / 1000);
                        C7302d dVar = null;
                        if (!(g == null || g.getItemData() == null || ((DBTemplateAudioInfo) g.getItemData()).index == null || !((DBTemplateAudioInfo) g.getItemData()).index.equals(dBTemplateAudioInfo.index))) {
                            LogUtilsV2.m14227d("Jamin queryDataFromDB find same item and add!");
                            dVar = g;
                        }
                        if (dVar == null) {
                            dVar = new C7302d(DownloadSubFragment.this, dBTemplateAudioInfo);
                        }
                        arrayList.add(dVar);
                    }
                    return arrayList;
                }
            }).mo10152c(C1487a.aUa()).mo10149b((C1842q<? super T>) new C1842q<List<BaseItem>>() {
                /* renamed from: R */
                public void mo9886K(List<BaseItem> list) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Read Cache onNext = ");
                    sb.append(list.size());
                    LogUtilsV2.m14227d(sb.toString());
                    DownloadSubFragment.this.m21466bQ(list);
                }

                /* renamed from: a */
                public void mo9877a(C1495b bVar) {
                }

                public void onComplete() {
                }

                public void onError(Throwable th) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("onError = ");
                    sb.append(th.getMessage());
                    LogUtilsV2.m14227d(sb.toString());
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public C7302d axd() {
        if (this.dAO == null || this.dAO.size() == 0) {
            return null;
        }
        for (BaseItem baseItem : awR()) {
            C7302d dVar = (C7302d) baseItem;
            if (dVar.axy() != 1) {
                StringBuilder sb = new StringBuilder();
                sb.append("Jamin getPlayingFromOldList = ");
                sb.append(((DBTemplateAudioInfo) dVar.getItemData()).index);
                LogUtilsV2.m14227d(sb.toString());
                return dVar;
            }
        }
        return null;
    }

    private void axe() {
        for (BaseItem baseItem : awR()) {
            ((C7302d) baseItem).mo31914ie(false);
        }
    }

    private void axf() {
        for (BaseItem baseItem : awR()) {
            ((C7302d) baseItem).mo31914ie(true);
        }
    }

    /* access modifiers changed from: private */
    public void axh() {
        StringBuilder sb = new StringBuilder();
        sb.append("saveMovingListToDB hasReOrder = ");
        sb.append(this.dAU);
        LogUtilsV2.m14227d(sb.toString());
        if (this.dAP != null && this.dAS != null && this.dAU) {
            this.dAS.insertOrReplaceInTx(this.dAP);
            this.dAU = false;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: bQ */
    public void m21466bQ(List<BaseItem> list) {
        if (this.dAN != null && list != null) {
            this.dAO.clear();
            this.dAO.addAll(list);
            if (list.size() >= 8) {
                this.dAO.add(new C7296a(this, VivaBaseApplication.m8749FZ().getString(R.string.xiaoying_str_community_load_finish_nomore_tip)));
            }
            this.dAN.notifyDataSetChanged();
        }
    }

    /* renamed from: d */
    private void m21469d(HashMap<String, String> hashMap) {
        this.dAS.deleteByKeyInTx(hashMap.keySet());
        try {
            for (String str : hashMap.values()) {
                File file = new File(str);
                StringBuilder sb = new StringBuilder();
                sb.append("jamin deleteDBAndRefreshUI filePath = ");
                sb.append(str);
                LogUtilsV2.m14227d(sb.toString());
                if (file.exists()) {
                    file.delete();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        C7272a.m21453b(getCategoryId(), null, 2);
        axc();
    }

    /* access modifiers changed from: private */
    /* renamed from: dg */
    public void m21470dg(int i, int i2) {
        if (i != i2) {
            this.dAU = true;
            long j = m21474qL(i2).order;
            if (i > i2) {
                while (i2 < i) {
                    DBTemplateAudioInfo qL = m21474qL(i2);
                    i2++;
                    qL.order = m21474qL(i2).order;
                }
            } else {
                while (i2 > i) {
                    m21474qL(i2).order = m21474qL(i2 - 1).order;
                    i2--;
                }
            }
            m21474qL(i).order = j;
        }
    }

    /* renamed from: qL */
    private DBTemplateAudioInfo m21474qL(int i) {
        return (DBTemplateAudioInfo) ((BaseItem) this.dAO.get(i)).getItemData();
    }

    /* access modifiers changed from: protected */
    /* renamed from: Oj */
    public void mo31811Oj() {
        this.dAT = (RecyclerView) this.btV.findViewById(R.id.music_recycle_view);
        this.dAN = new C7292a(this.dAO);
        this.dAT.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.dAT.setHasFixedSize(true);
        this.dAT.setAdapter(this.dAN);
        C8986a aVar = new C8986a(this.dAN);
        aVar.mo35758a(new C8989c() {
            /* renamed from: cM */
            public void mo29871cM(int i, int i2) {
                DownloadSubFragment.this.m21470dg(i, i2);
            }
        });
        final C1072a aVar2 = new C1072a(aVar);
        aVar2.mo8593a(this.dAT);
        this.dAN.mo31894a((C7294a) new C7294a() {
            /* renamed from: X */
            public void mo31882X(C1034u uVar) {
                aVar2.mo8591T(uVar);
            }
        });
        axa();
    }

    /* access modifiers changed from: protected */
    public int awP() {
        return 2;
    }

    /* access modifiers changed from: protected */
    public TemplateAudioCategory awQ() {
        return this.dAR;
    }

    /* access modifiers changed from: protected */
    public List<BaseItem> awR() {
        return this.dAO;
    }

    public HashMap<String, String> axg() {
        HashMap<String, String> hashMap = new HashMap<>();
        for (BaseItem baseItem : awR()) {
            C7302d dVar = (C7302d) baseItem;
            if (!(dVar == null || dVar.getItemData() == null || !dVar.axz())) {
                hashMap.put(((DBTemplateAudioInfo) dVar.getItemData()).index, ((DBTemplateAudioInfo) dVar.getItemData()).musicFilePath);
            }
        }
        return hashMap;
    }

    /* access modifiers changed from: protected */
    public String getCategoryId() {
        return this.dAQ;
    }

    /* access modifiers changed from: protected */
    public int getLayoutId() {
        return R.layout.xiaoying_music_download_list_fragment;
    }

    /* access modifiers changed from: protected */
    public void initData() {
        if (getArguments() != null) {
            this.dAR = (TemplateAudioCategory) getArguments().getSerializable("key_intent_music_category_info");
        }
        if (getArguments() != null) {
            this.musicType = getArguments().getInt(MusicParams.EXTRA_INT_TYPE);
        }
        this.dAS = C8688b.aKs().aKt();
        if (this.dAR != null && !TextUtils.isEmpty(this.dAR.index) && this.dAS != null) {
            this.dAQ = this.dAR.index;
            axc();
            axb();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        axh();
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
            String str2 = bVar.axk().dBk;
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && str.equals(getCategoryId()) && bVar.axj() == 1) {
                LogUtilsV2.m14227d("Jamin MusicDBOperationEvent OPERATION_TYPE_REPLACE");
                axc();
            }
        }
    }

    @C10031j(aZK = ThreadMode.MAIN)
    public void onEventMainThread(C7269h hVar) {
        int mode = hVar.getMode();
        if (!getUserVisibleHint()) {
            for (BaseItem baseItem : awR()) {
                ((C7302d) baseItem).axw();
            }
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Jamin MusicRubbishEvent  <><><> getCategoryId = ");
        sb.append(getCategoryId());
        sb.append(" , this = ");
        sb.append(this);
        sb.append("<>");
        sb.append(new Gson().toJson((Object) hVar));
        LogUtilsV2.m14227d(sb.toString());
        switch (mode) {
            case 0:
                this.chW = 0;
                break;
            case 1:
                this.chW = 1;
                C7272a.m21450a(2, null, 3);
                break;
            case 2:
                this.chW = 0;
                axh();
                HashMap axg = axg();
                if (axg != null && axg.size() > 0) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Jamin MusicRubbishEvent selectedMap = ");
                    sb2.append(axg.values().size());
                    LogUtilsV2.m14227d(sb2.toString());
                    m21469d(axg);
                    C7256a.m21415fU(getContext());
                    break;
                }
        }
        mo31881qM(this.chW);
    }

    /* renamed from: qM */
    public void mo31881qM(int i) {
        if (i == 1) {
            axf();
        } else if (i == 0) {
            axe();
        }
    }

    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        if (!z && this.chW == 1) {
            StringBuilder sb = new StringBuilder();
            sb.append("Jamin fragment go back close manager mode - getCategoryId = ");
            sb.append(getCategoryId());
            LogUtilsV2.m14227d(sb.toString());
            this.chW = 0;
            mo31881qM(this.chW);
        }
        axh();
    }
}
