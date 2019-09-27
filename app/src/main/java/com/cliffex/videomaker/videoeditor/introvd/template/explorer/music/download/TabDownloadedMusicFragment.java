package com.introvd.template.explorer.music.download;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.design.widget.TabLayout.C0421b;
import android.support.design.widget.TabLayout.C0422c;
import android.support.design.widget.TabLayout.C0427f;
import android.view.View;
import com.introvd.template.common.filecache.FileCache;
import com.introvd.template.common.filecache.FileCache.Builder;
import com.introvd.template.common.p236ui.XYViewPager;
import com.introvd.template.explorer.music.MusicBaseFragment;
import com.introvd.template.explorer.music.adapter.MusicCategoryTabAdapter;
import com.introvd.template.explorer.music.item.C7301c;
import com.introvd.template.explorer.music.item.MusicCategoryTabView;
import com.introvd.template.explorer.music.p304b.C7263b;
import com.introvd.template.explorer.music.p304b.C7264c;
import com.introvd.template.explorer.music.p304b.C7270i;
import com.introvd.template.explorer.p300e.C7213f;
import com.introvd.template.p203b.C4580b;
import com.introvd.template.router.explorer.ExplorerRouter.MusicParams;
import com.introvd.template.template.data.api.model.TemplateAudioCategory;
import com.introvd.template.template.data.api.model.TemplateAudioCategoryList;
import com.introvd.template.template.data.dao.C8682a;
import com.introvd.template.template.data.p406db.C8688b;
import com.introvd.template.vivaexplorermodule.R;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.greenrobot.eventbus.C10021c;
import org.greenrobot.eventbus.C10031j;
import org.greenrobot.eventbus.ThreadMode;
import p037b.p050b.C1834l;
import p037b.p050b.C1842q;
import p037b.p050b.p051a.p053b.C1487a;
import p037b.p050b.p054b.C1495b;
import p037b.p050b.p055c.C1505b;
import p037b.p050b.p057e.C1518f;
import p037b.p050b.p076j.C1820a;

public class TabDownloadedMusicFragment extends MusicBaseFragment {
    /* access modifiers changed from: private */
    public C8682a dAS;
    /* access modifiers changed from: private */
    public TabLayout dAr;
    private String dBe = "template/audio";
    /* access modifiers changed from: private */
    public List<String> dBf = new ArrayList();
    private FileCache<TemplateAudioCategoryList> dBg;
    /* access modifiers changed from: private */
    public int musicType = 1;

    private void avb() {
        if (getArguments() != null) {
            this.musicType = getArguments().getInt(MusicParams.EXTRA_INT_TYPE);
            if (this.musicType == 2) {
                this.dBe = "template/audio_effect";
            }
        }
    }

    private void axi() {
        C1834l.m5257ah(Boolean.valueOf(true)).mo10164f(500, TimeUnit.MILLISECONDS).mo10157d(C1820a.aVi()).mo10152c(C1820a.aVi()).mo10167f((C1518f<? super T, ? extends R>) new C1518f<Boolean, List<TemplateAudioCategory>>() {
            /* renamed from: i */
            public List<TemplateAudioCategory> apply(Boolean bool) {
                if (TabDownloadedMusicFragment.this.dAS == null) {
                    TabDownloadedMusicFragment.this.dAS = C8688b.aKs().aKt();
                }
                if (TabDownloadedMusicFragment.this.dAS != null) {
                    int i = 0;
                    if (TabDownloadedMusicFragment.this.musicType == 2) {
                        i = 1;
                    }
                    List<TemplateAudioCategory> uG = TabDownloadedMusicFragment.this.dAS.mo35012uG(i);
                    if (uG != null && uG.size() != 0) {
                        return uG;
                    }
                    TabDownloadedMusicFragment.this.dBf = new ArrayList();
                    throw C1505b.m4703z(new C7270i(1));
                }
                TabDownloadedMusicFragment.this.dBf = new ArrayList();
                throw C1505b.m4703z(new C7270i(1));
            }
        }).mo10167f((C1518f<? super T, ? extends R>) new C1518f<List<TemplateAudioCategory>, List<TemplateAudioCategory>>() {
            public List<TemplateAudioCategory> apply(List<TemplateAudioCategory> list) {
                return TabDownloadedMusicFragment.this.m21493bR(list);
            }
        }).mo10167f((C1518f<? super T, ? extends R>) new C1518f<List<TemplateAudioCategory>, List<C7301c>>() {
            public List<C7301c> apply(List<TemplateAudioCategory> list) {
                ArrayList arrayList = new ArrayList();
                for (TemplateAudioCategory templateAudioCategory : list) {
                    arrayList.add(templateAudioCategory.index);
                }
                ArrayList arrayList2 = new ArrayList(C7213f.m21301a(arrayList, TabDownloadedMusicFragment.this.dBf));
                TabDownloadedMusicFragment.this.dBf = arrayList;
                if (arrayList2.size() > 0) {
                    ArrayList arrayList3 = new ArrayList();
                    for (TemplateAudioCategory templateAudioCategory2 : list) {
                        arrayList3.add(new C7301c(TabDownloadedMusicFragment.this.getContext(), templateAudioCategory2, DownloadSubFragment.m21461a(templateAudioCategory2, TabDownloadedMusicFragment.this.musicType), TabDownloadedMusicFragment.this.musicType));
                    }
                    return arrayList3;
                }
                throw C1505b.m4703z(new C7270i(2));
            }
        }).mo10152c(C1487a.aUa()).mo10149b((C1842q<? super T>) new C1842q<List<C7301c>>() {
            /* renamed from: R */
            public void mo9886K(List<C7301c> list) {
                if (TabDownloadedMusicFragment.this.btV != null && TabDownloadedMusicFragment.this.dAr != null && TabDownloadedMusicFragment.this.mViewPager != null && TabDownloadedMusicFragment.this.dAd != null) {
                    TabDownloadedMusicFragment.this.btV.findViewById(R.id.music_empty_view).setVisibility(8);
                    TabDownloadedMusicFragment.this.dAr.setVisibility(0);
                    TabDownloadedMusicFragment.this.mViewPager.setVisibility(0);
                    TabDownloadedMusicFragment.this.dAd.mo31844bP(list);
                    for (int i = 0; i < TabDownloadedMusicFragment.this.dAd.getCount(); i++) {
                        C0427f aI = TabDownloadedMusicFragment.this.dAr.mo2008aI(i);
                        if (aI != null) {
                            MusicCategoryTabView qK = TabDownloadedMusicFragment.this.dAd.mo31847qK(i);
                            aI.mo2088E(qK);
                            if (qK != null && i == 0) {
                                qK.setSelect(true);
                            }
                        }
                    }
                    if (C4580b.m11666qi()) {
                        TabDownloadedMusicFragment.this.dAr.post(new Runnable() {
                            public void run() {
                                int measuredWidth = TabDownloadedMusicFragment.this.dAr.getChildAt(0).getMeasuredWidth();
                                if (measuredWidth != 0) {
                                    TabDownloadedMusicFragment.this.dAr.scrollTo(measuredWidth, 0);
                                }
                            }
                        });
                    }
                    C10021c.aZH().mo38492aA(new C7264c(1));
                }
            }

            /* renamed from: a */
            public void mo9877a(C1495b bVar) {
                TabDownloadedMusicFragment.this.compositeDisposable.mo9785e(bVar);
            }

            public void onComplete() {
            }

            public void onError(Throwable th) {
                Throwable cause = th.getCause();
                if (!(!(cause instanceof C7270i) || TabDownloadedMusicFragment.this.btV == null || TabDownloadedMusicFragment.this.dAr == null || TabDownloadedMusicFragment.this.mViewPager == null || TabDownloadedMusicFragment.this.dAd == null || ((C7270i) cause).dBt != 1)) {
                    View findViewById = TabDownloadedMusicFragment.this.btV.findViewById(R.id.music_empty_view);
                    TabDownloadedMusicFragment.this.mViewPager.setVisibility(8);
                    TabDownloadedMusicFragment.this.dAr.setVisibility(8);
                    TabDownloadedMusicFragment.this.dAd.mo31844bP(new ArrayList());
                    findViewById.setVisibility(0);
                    C10021c.aZH().mo38492aA(new C7264c(0));
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: bR */
    public List<TemplateAudioCategory> m21493bR(List<TemplateAudioCategory> list) {
        if (this.dBg == null) {
            this.dBg = new Builder(getContext(), TemplateAudioCategoryList.class).setRelativeDir(this.dBe).setCacheKey("TemplateAudioCategoryList").build();
        }
        TemplateAudioCategoryList templateAudioCategoryList = (TemplateAudioCategoryList) this.dBg.getCacheSync();
        ArrayList arrayList = new ArrayList();
        if (templateAudioCategoryList == null) {
            return arrayList;
        }
        TemplateAudioCategory templateAudioCategory = null;
        for (TemplateAudioCategory templateAudioCategory2 : list) {
            int indexOf = templateAudioCategoryList.audioCategoryList.indexOf(templateAudioCategory2);
            if (indexOf >= 0 && indexOf < templateAudioCategoryList.audioCategoryList.size()) {
                templateAudioCategory2 = (TemplateAudioCategory) templateAudioCategoryList.audioCategoryList.get(indexOf);
            } else if ("0".equals(templateAudioCategory2.index)) {
                templateAudioCategory2.name = getString(R.string.xiaoying_str_ve_scenename_unknow);
                templateAudioCategory = templateAudioCategory2;
            }
            arrayList.add(templateAudioCategory2);
        }
        if (templateAudioCategory != null) {
            arrayList.add(templateAudioCategory);
        }
        return arrayList;
    }

    /* renamed from: qN */
    public static TabDownloadedMusicFragment m21509qN(int i) {
        TabDownloadedMusicFragment tabDownloadedMusicFragment = new TabDownloadedMusicFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(MusicParams.EXTRA_INT_TYPE, i);
        tabDownloadedMusicFragment.setArguments(bundle);
        return tabDownloadedMusicFragment;
    }

    /* access modifiers changed from: protected */
    /* renamed from: Oj */
    public void mo31805Oj() {
        avb();
        this.dAr = (TabLayout) this.btV.findViewById(R.id.music_tablayout);
        this.mViewPager = (XYViewPager) this.btV.findViewById(R.id.music_viewpager);
        this.dAd = new MusicCategoryTabAdapter(getChildFragmentManager());
        this.mViewPager.setAdapter(this.dAd);
        this.dAr.setupWithViewPager(this.mViewPager);
        this.mViewPager.validateDatasetObserver();
        this.btV.findViewById(R.id.music_empty_view).setVisibility(8);
        this.dAr.mo2003a((C0421b) new C0422c() {
            /* renamed from: i */
            public void mo2071i(C0427f fVar) {
                View customView = fVar.getCustomView();
                if (customView instanceof MusicCategoryTabView) {
                    ((MusicCategoryTabView) customView).setSelect(true);
                }
            }

            /* renamed from: j */
            public void mo2072j(C0427f fVar) {
                View customView = fVar.getCustomView();
                if (customView instanceof MusicCategoryTabView) {
                    ((MusicCategoryTabView) customView).setSelect(false);
                }
            }

            /* renamed from: k */
            public void mo2073k(C0427f fVar) {
            }
        });
    }

    /* access modifiers changed from: protected */
    public int getLayoutId() {
        return R.layout.xiaoying_music_downloaded_fragment;
    }

    /* access modifiers changed from: protected */
    public void initData() {
        if (!C10021c.aZH().mo38495ay(this)) {
            C10021c.aZH().mo38494ax(this);
        }
        axi();
    }

    public void onDetach() {
        super.onDetach();
        if (C10021c.aZH().mo38495ay(this)) {
            C10021c.aZH().mo38496az(this);
        }
    }

    @C10031j(aZK = ThreadMode.MAIN)
    public void onEventMainThread(C7263b bVar) {
        if (bVar.axk() != null) {
            axi();
        }
    }
}
