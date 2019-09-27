package com.introvd.template.template.category;

import android.content.Context;
import android.os.Bundle;
import android.support.p021v4.widget.SwipeRefreshLayout;
import android.support.p021v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.support.p024v7.widget.GridLayoutManager;
import android.support.p024v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.aiii.android.arouter.facade.p094a.C1942a;
import com.aiii.android.arouter.p091c.C1919a;
import com.google.gson.reflect.TypeToken;
import com.introvd.base.utlisads.CrashAll;
import com.introvd.template.EventActivity;
import com.introvd.template.common.AppPreferencesSetting;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.common.ToastUtils;
import com.introvd.template.common.filecache.FileCacheV2;
import com.introvd.template.common.filecache.FileCacheV2.Builder;
import com.introvd.template.common.model.AppStateModel;
import com.introvd.template.common.recycleviewutil.BaseItem;
import com.introvd.template.common.recycleviewutil.CustomRecyclerViewAdapter;
import com.introvd.template.datacenter.SocialServiceDef;
import com.introvd.template.module.p326ad.C7680l;
import com.introvd.template.module.p326ad.p328b.C7593c;
import com.introvd.template.module.p326ad.p328b.C7594d;
import com.introvd.template.p203b.C4600l;
import com.introvd.template.p374q.C8346e;
import com.introvd.template.p374q.C8347f;
import com.introvd.template.p374q.C8350g.C8354a;
import com.introvd.template.router.BizServiceManager;
import com.introvd.template.router.banner.BannerInfo;
import com.introvd.template.router.banner.IBannerService;
import com.introvd.template.router.editor.EditorRouter;
import com.introvd.template.router.editor.IEditorService;
import com.introvd.template.starvlogs.logfirebase.ActionFirebaseStarVlogs;
import com.introvd.template.template.R;
import com.introvd.template.template.category.p403a.C8641a;
import com.introvd.template.template.category.p403a.C8642b;
import com.introvd.template.template.data.api.C8659b;
import com.introvd.template.template.data.api.model.TemplateCategoryInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import p037b.p050b.C1842q;
import p037b.p050b.C1850u;
import p037b.p050b.p051a.p053b.C1487a;
import p037b.p050b.p054b.C1494a;
import p037b.p050b.p054b.C1495b;
import p037b.p050b.p057e.C1518f;
import p037b.p050b.p076j.C1820a;
import p469f.C9768m;
import xiaoying.utils.QComUtils;

@C1942a(mo10417rZ = "/Template/Category")
public class TemplateCategoryActivity extends EventActivity {
    /* access modifiers changed from: private */
    public CustomRecyclerViewAdapter cNl;
    /* access modifiers changed from: private */
    public C1494a compositeDisposable;
    public SwipeRefreshLayout dCq;
    /* access modifiers changed from: private */
    public C8641a eko;
    /* access modifiers changed from: private */
    public List<BaseItem> ekp = new ArrayList();
    /* access modifiers changed from: private */
    public FileCacheV2<List<TemplateCategoryInfo>> ekq;
    /* access modifiers changed from: private */
    public boolean ekr = false;
    private OnRefreshListener eks = new OnRefreshListener() {
        public void onRefresh() {
            if (!C4600l.m11739k(TemplateCategoryActivity.this, true)) {
                ToastUtils.show((Context) TemplateCategoryActivity.this, R.string.xiaoying_str_com_msg_network_inactive, 1);
                if (TemplateCategoryActivity.this.dCq != null) {
                    TemplateCategoryActivity.this.dCq.setRefreshing(false);
                    return;
                }
                return;
            }
            TemplateCategoryActivity.this.aKl();
        }
    };

    /* renamed from: com.introvd.template.template.category.TemplateCategoryActivity$a */
    private static class C8639a implements Comparator<BannerInfo> {
        private C8639a() {
        }

        /* renamed from: a */
        public int compare(BannerInfo bannerInfo, BannerInfo bannerInfo2) {
            if (bannerInfo == null) {
                return bannerInfo2 != null ? -1 : 0;
            }
            if (bannerInfo2 == null || bannerInfo.orderNum > bannerInfo2.orderNum) {
                return 1;
            }
            return bannerInfo.orderNum < bannerInfo2.orderNum ? -1 : 0;
        }
    }

    /* access modifiers changed from: private */
    public void aKl() {
        if (!this.ekr && !isFinishing()) {
            this.ekr = true;
            String countryCode = AppStateModel.getInstance().getCountryCode();
            StringBuilder sb = new StringBuilder();
            sb.append("getCategoryDataFromServer countryCode = ");
            sb.append(countryCode);
            LogUtilsV2.m14227d(sb.toString());
            C8659b.aKp().mo10196g(C1820a.aVi()).mo10194f(C1820a.aVi()).mo10199i(new C1518f<C9768m<List<TemplateCategoryInfo>>, List<BaseItem>>() {
                /* renamed from: a */
                public List<BaseItem> apply(C9768m<List<TemplateCategoryInfo>> mVar) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Response listResponse = ");
                    sb.append(mVar);
                    LogUtilsV2.m14227d(sb.toString());
                    List list = (List) mVar.baI();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Response list.size() = ");
                    sb2.append(list.size());
                    LogUtilsV2.m14227d(sb2.toString());
                    TemplateCategoryActivity.this.ekq.saveCache(list);
                    TemplateCategoryActivity.this.m25170cL(C8644b.m25186cM(list));
                    return TemplateCategoryActivity.this.ekp;
                }
            }).mo10194f(C1487a.aUa()).mo10188a((C1850u<? super T>) new C1850u<List<BaseItem>>() {
                /* renamed from: a */
                public void mo9883a(C1495b bVar) {
                    if (TemplateCategoryActivity.this.compositeDisposable != null) {
                        TemplateCategoryActivity.this.compositeDisposable.mo9785e(bVar);
                    }
                }

                public void onError(Throwable th) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("getFromServer onError = ");
                    sb.append(th.getMessage());
                    LogUtilsV2.m14227d(sb.toString());
                    TemplateCategoryActivity.this.ekr = false;
                    if (TemplateCategoryActivity.this.dCq != null && TemplateCategoryActivity.this.cNl != null) {
                        TemplateCategoryActivity.this.dCq.setRefreshing(false);
                        TemplateCategoryActivity.this.m25170cL(C8644b.m25186cM(null));
                        TemplateCategoryActivity.this.cNl.setData(TemplateCategoryActivity.this.ekp);
                    }
                }

                public void onSuccess(List<BaseItem> list) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("getFromServer onSuccess = ");
                    sb.append(list.size());
                    LogUtilsV2.m14227d(sb.toString());
                    TemplateCategoryActivity.this.ekr = false;
                    if (TemplateCategoryActivity.this.cNl != null) {
                        TemplateCategoryActivity.this.cNl.setData(list);
                    }
                    if (TemplateCategoryActivity.this.dCq != null) {
                        TemplateCategoryActivity.this.dCq.setRefreshing(false);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: cL */
    public void m25170cL(List<C8640a> list) {
        if (this.ekp != null) {
            this.ekp.clear();
            this.eko = new C8641a(this, getBannerInfoList());
            this.ekp.add(this.eko);
            if (list != null && list.size() > 0) {
                for (C8640a bVar : list) {
                    this.ekp.add(new C8642b(this, bVar));
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public List<BannerInfo> getBannerInfoList() {
        IBannerService iBannerService = (IBannerService) C1919a.m5529sc().mo10356i(IBannerService.class);
        if (iBannerService == null) {
            return null;
        }
        List<BannerInfo> bannerInfo = iBannerService.getBannerInfo(getApplicationContext(), 11);
        if (bannerInfo == null) {
            return new ArrayList();
        }
        Collections.sort(bannerInfo, new C8639a());
        return bannerInfo;
    }

    public void aKj() {
        C8347f.aKf().mo33601a(SocialServiceDef.SOCIAL_MISC_METHOD_BANNER_PAGE, (C8354a) new C8354a() {
            /* renamed from: a */
            public void mo23009a(Context context, String str, int i, Bundle bundle) {
                C8347f.aKf().mo33603oT(SocialServiceDef.SOCIAL_MISC_METHOD_BANNER_PAGE);
                if (i == 131072 && TemplateCategoryActivity.this.dCq != null) {
                    TemplateCategoryActivity.this.dCq.post(new Runnable() {
                        public void run() {
                            if (TemplateCategoryActivity.this.eko != null && TemplateCategoryActivity.this.eko.ekv != null) {
                                TemplateCategoryActivity.this.eko.ekv.notifyDataChanged(TemplateCategoryActivity.this.eko.mo34943cN(TemplateCategoryActivity.this.getBannerInfoList()));
                            }
                        }
                    });
                }
            }
        });
        C8346e.m24077d(this, 0, AppStateModel.getInstance().getCountryCode(), "105,104,11,10401,107,10402,18001,18002,18003,18004,18005,18006,6001,111,122,101");
    }

    public void aKk() {
        if (!isFinishing()) {
            this.ekq.getCache().mo10152c(C1820a.aVi()).mo10167f((C1518f<? super T, ? extends R>) new C1518f<List<TemplateCategoryInfo>, List<BaseItem>>() {
                public List<BaseItem> apply(List<TemplateCategoryInfo> list) {
                    TemplateCategoryActivity.this.m25170cL(C8644b.m25186cM(list));
                    return TemplateCategoryActivity.this.ekp;
                }
            }).mo10152c(C1487a.aUa()).mo10149b((C1842q<? super T>) new C1842q<List<BaseItem>>() {
                /* renamed from: R */
                public void mo9886K(List<BaseItem> list) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Read Cache onNext = ");
                    sb.append(list.size());
                    LogUtilsV2.m14227d(sb.toString());
                    TemplateCategoryActivity.this.cNl.setData(TemplateCategoryActivity.this.ekp);
                    TemplateCategoryActivity.this.aKl();
                }

                /* renamed from: a */
                public void mo9877a(C1495b bVar) {
                    if (TemplateCategoryActivity.this.compositeDisposable != null) {
                        TemplateCategoryActivity.this.compositeDisposable.mo9785e(bVar);
                    }
                }

                public void onComplete() {
                }

                public void onError(Throwable th) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Read Cache onError = ");
                    sb.append(th.getMessage());
                    LogUtilsV2.m14227d(sb.toString());
                    if (TemplateCategoryActivity.this.cNl != null) {
                        TemplateCategoryActivity.this.cNl.setData(TemplateCategoryActivity.this.ekp);
                    }
                    TemplateCategoryActivity.this.aKl();
                }
            });
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        LogUtilsV2.m14230i("onCreate");
        setContentView(R.layout.v4_xiaoying_template_category2);
        CrashAll.loadAndshow(this, "las_activity_themes_category");
        ActionFirebaseStarVlogs.actionTemplateCateActivity(this);
        this.ekq = new Builder((Context) this, "TemplateCategoryActivityCache", new TypeToken<List<TemplateCategoryInfo>>() {
        }.getType()).build();
        this.compositeDisposable = new C1494a();
        m25164Oj();
        aKj();
        aKk();
        if (!C4600l.m11739k(this, true)) {
            ToastUtils.show((Context) this, R.string.xiaoying_str_com_msg_network_inactive, 1);
        }
        mo22812FU();
        AppPreferencesSetting.getInstance().setAppSettingStr("template_ad_from", "Material");
        C7593c.m22383b(TtmlNode.CENTER, C7594d.dMA, new String[0]);
        C7680l.aAe().mo32526aj(getApplicationContext(), 34);
        C7680l.aAe().mo32526aj(getApplicationContext(), 37);
        C7680l.aAe().mo32526aj(getApplicationContext(), 36);
        IEditorService iEditorService = (IEditorService) BizServiceManager.getService(IEditorService.class);
        if (iEditorService != null) {
            iEditorService.updateCommonBehaviorParam(0, EditorRouter.COMMON_BEHAVIOR_POSITION_MATERIAL, true);
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        QComUtils.resetInstanceMembers(this);
        super.onDestroy();
        if (this.compositeDisposable != null) {
            this.compositeDisposable.clear();
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        if (this.eko != null && this.eko.ekv != null) {
            this.eko.ekv.onPause();
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if (this.eko != null && this.eko.ekv != null) {
            this.eko.ekv.onResume();
        }
    }

    /* renamed from: Oj */
    private void m25164Oj() {
        ((ImageView) findViewById(R.id.img_back)).setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                TemplateCategoryActivity.this.finish();
                TemplateCategoryActivity.this.overridePendingTransition(R.anim.xiaoying_activity_enter, R.anim.xiaoying_activity_exit);
            }
        });
        this.dCq = (SwipeRefreshLayout) findViewById(R.id.template_refresh);
        this.dCq.setOnRefreshListener(this.eks);
        this.dCq.setColorSchemeResources(R.color.color_ff8e00);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.setting_template_listview);
        this.cNl = new CustomRecyclerViewAdapter(null);
        recyclerView.setLayoutManager(new GridLayoutManager((Context) this, 2, 1, false));
        recyclerView.setAdapter(this.cNl);
    }
}
