package com.introvd.template.explorer.music.online;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.design.widget.TabLayout.C0421b;
import android.support.design.widget.TabLayout.C0422c;
import android.support.design.widget.TabLayout.C0427f;
import android.view.View;
import com.introvd.template.common.AppPreferencesSetting;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.common.filecache.FileCache;
import com.introvd.template.common.filecache.FileCache.Builder;
import com.introvd.template.common.p236ui.XYViewPager;
import com.introvd.template.explorer.music.MusicBaseFragment;
import com.introvd.template.explorer.music.adapter.MusicCategoryTabAdapter;
import com.introvd.template.explorer.music.item.C7301c;
import com.introvd.template.explorer.music.item.MusicCategoryTabView;
import com.introvd.template.explorer.music.p303a.C7256a;
import com.introvd.template.p203b.C4600l;
import com.introvd.template.router.explorer.ExplorerRouter.MusicParams;
import com.introvd.template.template.data.api.C8659b;
import com.introvd.template.template.data.api.model.TemplateAudioCategory;
import com.introvd.template.template.data.api.model.TemplateAudioCategoryList;
import com.introvd.template.vivaexplorermodule.R;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import p037b.p050b.C1842q;
import p037b.p050b.C1850u;
import p037b.p050b.p051a.p053b.C1487a;
import p037b.p050b.p054b.C1495b;
import p037b.p050b.p057e.C1518f;
import p037b.p050b.p076j.C1820a;
import p469f.C9768m;

public class TabOnlineMusicFragment extends MusicBaseFragment {
    /* access modifiers changed from: private */
    public TabLayout dAr;
    private String dBe = "template/audio";
    /* access modifiers changed from: private */
    public FileCache<TemplateAudioCategoryList> dBg;
    private String dCv = "";
    private C7339a dCw;
    private View mEmptyView;
    private int musicType = 1;

    /* access modifiers changed from: private */
    /* renamed from: a */
    public List<C7301c> m21632a(TemplateAudioCategoryList templateAudioCategoryList) {
        ArrayList arrayList = new ArrayList();
        if (templateAudioCategoryList != null) {
            for (TemplateAudioCategory templateAudioCategory : templateAudioCategoryList.audioCategoryList) {
                arrayList.add(new C7301c(getContext(), templateAudioCategory, OnlineSubFragment.m21604b(templateAudioCategory, this.musicType), this.musicType));
            }
        }
        return arrayList;
    }

    private void avb() {
        if (getArguments() != null) {
            this.musicType = getArguments().getInt(MusicParams.EXTRA_INT_TYPE);
            if (this.musicType == 2) {
                this.dBe = "template/audio_effect";
            }
            this.dCv = getArguments().getString(MusicParams.EXTRA_CATEGORY_ID, "");
        }
    }

    private C7339a axO() {
        if (this.dCw == null) {
            this.dCw = new C7339a();
        }
        return this.dCw;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0066  */
    /* renamed from: bU */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m21637bU(java.util.List<com.introvd.template.explorer.music.item.C7301c> r6) {
        /*
            r5 = this;
            android.view.View r0 = r5.mEmptyView
            if (r0 == 0) goto L_0x0099
            com.introvd.template.common.ui.XYViewPager r0 = r5.mViewPager
            if (r0 == 0) goto L_0x0099
            com.introvd.template.explorer.music.adapter.MusicCategoryTabAdapter r0 = r5.dAd
            if (r0 != 0) goto L_0x000e
            goto L_0x0099
        L_0x000e:
            boolean r0 = r6.isEmpty()
            r1 = 0
            if (r0 == 0) goto L_0x001b
            android.view.View r6 = r5.mEmptyView
            r6.setVisibility(r1)
            return
        L_0x001b:
            android.view.View r0 = r5.mEmptyView
            r2 = 8
            r0.setVisibility(r2)
            com.introvd.template.common.ui.XYViewPager r0 = r5.mViewPager
            int r2 = r6.size()
            r3 = 1
            if (r2 <= r3) goto L_0x002d
            r2 = 3
            goto L_0x002e
        L_0x002d:
            r2 = 1
        L_0x002e:
            r0.setOffscreenPageLimit(r2)
            com.introvd.template.explorer.music.adapter.MusicCategoryTabAdapter r0 = r5.dAd
            r0.mo31844bP(r6)
            boolean r0 = r6.isEmpty()
            if (r0 != 0) goto L_0x005d
            r0 = 0
        L_0x003d:
            int r2 = r6.size()
            if (r0 >= r2) goto L_0x005d
            java.lang.Object r2 = r6.get(r0)
            com.introvd.template.explorer.music.item.c r2 = (com.introvd.template.explorer.music.item.C7301c) r2
            java.lang.String r4 = r5.dCv
            if (r4 == 0) goto L_0x005a
            java.lang.String r4 = r5.dCv
            java.lang.String r2 = r2.getId()
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x005a
            goto L_0x005e
        L_0x005a:
            int r0 = r0 + 1
            goto L_0x003d
        L_0x005d:
            r0 = 0
        L_0x005e:
            com.introvd.template.explorer.music.adapter.MusicCategoryTabAdapter r6 = r5.dAd
            int r6 = r6.getCount()
            if (r1 >= r6) goto L_0x0081
            android.support.design.widget.TabLayout r6 = r5.dAr
            android.support.design.widget.TabLayout$f r6 = r6.mo2008aI(r1)
            if (r6 == 0) goto L_0x007e
            com.introvd.template.explorer.music.adapter.MusicCategoryTabAdapter r2 = r5.dAd
            com.introvd.template.explorer.music.item.MusicCategoryTabView r2 = r2.mo31847qK(r1)
            if (r2 == 0) goto L_0x007e
            r6.mo2088E(r2)
            if (r1 != r0) goto L_0x007e
            r2.setSelect(r3)
        L_0x007e:
            int r1 = r1 + 1
            goto L_0x005e
        L_0x0081:
            com.introvd.template.common.ui.XYViewPager r6 = r5.mViewPager
            r6.setCurrentItem(r0)
            if (r0 != 0) goto L_0x0098
            boolean r6 = com.introvd.template.p203b.C4580b.m11666qi()
            if (r6 == 0) goto L_0x0098
            android.support.design.widget.TabLayout r6 = r5.dAr
            com.introvd.template.explorer.music.online.TabOnlineMusicFragment$2 r0 = new com.introvd.template.explorer.music.online.TabOnlineMusicFragment$2
            r0.<init>()
            r6.post(r0)
        L_0x0098:
            return
        L_0x0099:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.explorer.music.online.TabOnlineMusicFragment.m21637bU(java.util.List):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: if */
    public void m21641if(final boolean z) {
        if (!C4600l.m11739k(getActivity(), true)) {
            if (this.dAd == null || this.dAd.isEmpty()) {
                mo31808hZ(false);
            }
            return;
        }
        C8659b.m25233uE(this.musicType).mo10200k(300, TimeUnit.MILLISECONDS).mo10196g(C1820a.aVi()).mo10194f(C1820a.aVi()).mo10199i(new C1518f<C9768m<TemplateAudioCategoryList>, List<C7301c>>() {
            /* renamed from: a */
            public List<C7301c> apply(C9768m<TemplateAudioCategoryList> mVar) {
                TemplateAudioCategoryList templateAudioCategoryList = (TemplateAudioCategoryList) mVar.baI();
                if (!(templateAudioCategoryList == null || TabOnlineMusicFragment.this.dBg == null)) {
                    TabOnlineMusicFragment.this.axP();
                    TabOnlineMusicFragment.this.dBg.saveCache(templateAudioCategoryList);
                }
                return TabOnlineMusicFragment.this.m21632a(templateAudioCategoryList);
            }
        }).mo10194f(C1487a.aUa()).mo10188a((C1850u<? super T>) new C1850u<List<C7301c>>() {
            /* renamed from: a */
            public void mo9883a(C1495b bVar) {
                TabOnlineMusicFragment.this.compositeDisposable.mo9785e(bVar);
            }

            public void onError(Throwable th) {
                StringBuilder sb = new StringBuilder();
                sb.append("getFromServer onError = ");
                sb.append(th.getMessage());
                LogUtilsV2.m14227d(sb.toString());
            }

            public void onSuccess(List<C7301c> list) {
                StringBuilder sb = new StringBuilder();
                sb.append("getDataFromServer onSuccess TemplateAudioCategoryList.size = ");
                sb.append(list.size());
                LogUtilsV2.m14227d(sb.toString());
                if (z) {
                    TabOnlineMusicFragment.this.m21637bU(list);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: qV */
    public void m21642qV(int i) {
        if (this.musicType == 1) {
            C7301c qJ = this.dAd.mo31846qJ(i);
            if (qJ != null) {
                axO().mo31964a(getContext(), qJ);
            }
        }
    }

    /* renamed from: r */
    public static TabOnlineMusicFragment m21643r(int i, String str) {
        TabOnlineMusicFragment tabOnlineMusicFragment = new TabOnlineMusicFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(MusicParams.EXTRA_INT_TYPE, i);
        bundle.putString(MusicParams.EXTRA_CATEGORY_ID, str);
        tabOnlineMusicFragment.setArguments(bundle);
        return tabOnlineMusicFragment;
    }

    /* access modifiers changed from: protected */
    /* renamed from: Oj */
    public void mo31805Oj() {
        avb();
        this.dAr = (TabLayout) this.btV.findViewById(R.id.music_tablayout);
        this.mEmptyView = this.btV.findViewById(R.id.music_empty_view);
        this.mViewPager = (XYViewPager) this.btV.findViewById(R.id.music_viewpager);
        this.dAd = new MusicCategoryTabAdapter(getChildFragmentManager());
        this.dAd.notifyDataSetChanged();
        this.mViewPager.setAdapter(this.dAd);
        this.dAr.setupWithViewPager(this.mViewPager);
        this.mViewPager.validateDatasetObserver();
        this.dAr.mo2003a((C0421b) new C0422c() {
            /* renamed from: i */
            public void mo2071i(C0427f fVar) {
                View customView = fVar.getCustomView();
                if (customView instanceof MusicCategoryTabView) {
                    ((MusicCategoryTabView) customView).setSelect(true);
                }
                TabOnlineMusicFragment.this.m21642qV(fVar.getPosition());
                C7301c qJ = TabOnlineMusicFragment.this.dAd.mo31846qJ(fVar.getPosition());
                if (qJ != null) {
                    C7256a.m21409bU(TabOnlineMusicFragment.this.getContext(), qJ.getTitle());
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

    public boolean axM() {
        return System.currentTimeMillis() - AppPreferencesSetting.getInstance().getAppSettingLong("tab_online_music_fragment_last_update_time", 0) > 14400000;
    }

    public void axP() {
        AppPreferencesSetting.getInstance().setAppSettingLong("tab_online_music_fragment_last_update_time", System.currentTimeMillis());
    }

    /* access modifiers changed from: protected */
    public int getLayoutId() {
        return R.layout.xiaoying_music_online_fragment;
    }

    /* renamed from: ia */
    public void mo31809ia(boolean z) {
        if (!z) {
            awI();
        } else if (this.dAd == null || this.dAd.isEmpty()) {
            mo31808hZ(false);
        }
    }

    /* access modifiers changed from: protected */
    public void initData() {
        if (this.dBg == null) {
            this.dBg = new Builder(getContext(), TemplateAudioCategoryList.class).setRelativeDir(this.dBe).setCacheKey("TemplateAudioCategoryList").build();
        }
        this.dBg.getCache().mo10164f(300, TimeUnit.MILLISECONDS).mo10157d(C1820a.aVi()).mo10152c(C1820a.aVi()).mo10167f((C1518f<? super T, ? extends R>) new C1518f<TemplateAudioCategoryList, List<C7301c>>() {
            /* renamed from: b */
            public List<C7301c> apply(TemplateAudioCategoryList templateAudioCategoryList) {
                return TabOnlineMusicFragment.this.m21632a(templateAudioCategoryList);
            }
        }).mo10152c(C1487a.aUa()).mo10149b((C1842q<? super T>) new C1842q<List<C7301c>>() {
            /* renamed from: R */
            public void mo9886K(List<C7301c> list) {
                StringBuilder sb = new StringBuilder();
                sb.append("getCache onNext musicCategoryItemList.size = ");
                sb.append(list.size());
                LogUtilsV2.m14227d(sb.toString());
                TabOnlineMusicFragment.this.m21637bU(list);
                if (TabOnlineMusicFragment.this.axM()) {
                    TabOnlineMusicFragment.this.m21641if(false);
                }
            }

            /* renamed from: a */
            public void mo9877a(C1495b bVar) {
                TabOnlineMusicFragment.this.compositeDisposable.mo9785e(bVar);
            }

            public void onComplete() {
            }

            public void onError(Throwable th) {
                TabOnlineMusicFragment.this.m21641if(true);
            }
        });
    }
}
