package com.introvd.template.editor.slideshow.funny;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.design.widget.TabLayout.C0421b;
import android.support.design.widget.TabLayout.C0422c;
import android.support.design.widget.TabLayout.C0427f;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.aiii.android.arouter.facade.p094a.C1942a;
import com.introvd.template.EventActivity;
import com.introvd.template.app.homepage.AppModelConfigInfo;
import com.introvd.template.app.homepage.C3935b;
import com.introvd.template.app.p177b.C3742b;
import com.introvd.template.common.AppPreferencesSetting;
import com.introvd.template.common.p236ui.XYViewPager;
import com.introvd.template.common.prefs.UtilsPrefs;
import com.introvd.template.editor.R;
import com.introvd.template.editor.slideshow.funny.adapter.C6819a;
import com.introvd.template.editor.slideshow.funny.adapter.C6819a.C6821a;
import com.introvd.template.editor.slideshow.funny.adapter.FunnyCategoryAdapter;
import com.introvd.template.editor.slideshow.funny.view.FunnyTabView;
import com.introvd.template.editor.slideshow.funny.view.FunnyTemplateDialogFragment;
import com.introvd.template.editor.slideshow.p278a.C6738a;
import com.introvd.template.p203b.C4583d;
import com.introvd.template.router.editor.EditorRouter;
import com.introvd.template.router.slide.FunnySlideRouter;
import com.introvd.template.template.data.api.C8659b;
import com.introvd.template.template.data.api.model.TemplatePackageInfoList;
import com.introvd.template.template.data.api.model.TemplateResponsePackageInfo;
import com.introvd.template.template.model.TemplatePackageInfo;
import com.introvd.template.template.p407e.C8742k;
import com.p131c.p132a.p135c.C2575a;
import java.util.ArrayList;
import java.util.List;
import p037b.p050b.C1848s;
import p037b.p050b.C1850u;
import p037b.p050b.p051a.p053b.C1487a;
import p037b.p050b.p054b.C1495b;
import p037b.p050b.p057e.C1518f;
import p037b.p050b.p076j.C1820a;
import p469f.C9768m;

@C1942a(mo10417rZ = "/Funny/TemplateInfo")
public class FunnyTemplateListActivity extends EventActivity implements OnClickListener {
    private ImageView bvn;
    private TabLayout dgU;
    /* access modifiers changed from: private */
    public FunnyCategoryAdapter dgV;
    private XYViewPager mViewPager;

    /* renamed from: Kl */
    private void m19805Kl() {
        this.bvn = (ImageView) findViewById(R.id.img_back);
        this.bvn.setOnClickListener(this);
        this.dgU = (TabLayout) findViewById(R.id.funny_tablayout);
        this.mViewPager = (XYViewPager) findViewById(R.id.funny_viewpager);
        this.dgV = new FunnyCategoryAdapter(getSupportFragmentManager());
        this.dgV.notifyDataSetChanged();
        this.mViewPager.setAdapter(this.dgV);
        this.dgU.setupWithViewPager(this.mViewPager);
        this.mViewPager.validateDatasetObserver();
        this.dgU.mo2003a((C0421b) new C0422c() {
            /* renamed from: i */
            public void mo2071i(C0427f fVar) {
                View customView = fVar.getCustomView();
                if (customView instanceof FunnyTabView) {
                    ((FunnyTabView) customView).setSelect(true);
                }
                C6819a pi = FunnyTemplateListActivity.this.dgV.mo30385pi(fVar.getPosition());
                if (pi != null) {
                    C6738a.m19557bJ(FunnyTemplateListActivity.this.getApplicationContext(), pi.getTitle());
                }
            }

            /* renamed from: j */
            public void mo2072j(C0427f fVar) {
                View customView = fVar.getCustomView();
                if (customView instanceof FunnyTabView) {
                    ((FunnyTabView) customView).setSelect(false);
                }
            }

            /* renamed from: k */
            public void mo2073k(C0427f fVar) {
            }
        });
        String appSettingStr = AppPreferencesSetting.getInstance().getAppSettingStr("key_pref_pkg_funny_refresh_last_time_viva_template_funny", "");
        if (TextUtils.isEmpty(appSettingStr) || Math.abs(System.currentTimeMillis() - C2575a.parseLong(appSettingStr)) > 43200000) {
            arD();
        } else {
            art();
        }
    }

    /* access modifiers changed from: private */
    public void arD() {
        C8659b.m25229bd("", "viva_template_funny").mo10196g(C1820a.aVi()).mo10194f(C1820a.aVi()).mo10199i(new C1518f<C9768m<TemplatePackageInfoList>, List<TemplatePackageInfo>>() {
            /* renamed from: a */
            public List<TemplatePackageInfo> apply(C9768m<TemplatePackageInfoList> mVar) throws Exception {
                List arrayList = new ArrayList();
                if (mVar != null) {
                    TemplatePackageInfoList templatePackageInfoList = (TemplatePackageInfoList) mVar.baI();
                    if (templatePackageInfoList != null) {
                        arrayList = templatePackageInfoList.templatePackageList;
                    }
                }
                List<TemplatePackageInfo> b = FunnyTemplateListActivity.this.m19810bD(arrayList);
                C8742k.aMi().mo35180e(FunnyTemplateListActivity.this.getApplicationContext(), "viva_template_funny", b);
                return b;
            }
        }).mo10194f(C1487a.aUa()).mo10188a((C1850u<? super T>) new C1850u<List<TemplatePackageInfo>>() {
            /* renamed from: a */
            public void mo9883a(C1495b bVar) {
            }

            public void onError(Throwable th) {
            }

            public void onSuccess(List<TemplatePackageInfo> list) {
                StringBuilder sb = new StringBuilder();
                sb.append("");
                sb.append(System.currentTimeMillis());
                AppPreferencesSetting.getInstance().setAppSettingStr("key_pref_pkg_funny_refresh_last_time_viva_template_funny", sb.toString());
                if (list != null && list.size() > 0) {
                    FunnyTemplateListActivity.this.m19811bF(list);
                }
            }
        });
    }

    private String arE() {
        String str = "";
        int intExtra = getIntent().getIntExtra(FunnySlideRouter.INTENT_KEY_TODOCODE, -1);
        List<AppModelConfigInfo> Ld = C3935b.m9679Lb().mo23474Ld();
        if (Ld == null || Ld.size() <= 0) {
            return str;
        }
        for (AppModelConfigInfo appModelConfigInfo : Ld) {
            if (appModelConfigInfo.eventType == intExtra) {
                return appModelConfigInfo.title;
            }
        }
        return str;
    }

    private void art() {
        C1848s.m5326ai(Boolean.valueOf(true)).mo10196g(C1820a.aVi()).mo10194f(C1820a.aVi()).mo10199i(new C1518f<Boolean, List<TemplatePackageInfo>>() {
            /* renamed from: i */
            public List<TemplatePackageInfo> apply(Boolean bool) throws Exception {
                List<TemplatePackageInfo> cG = C8742k.aMi().mo35177cG(FunnyTemplateListActivity.this.getApplicationContext(), "viva_template_funny");
                return cG == null ? new ArrayList() : cG;
            }
        }).mo10194f(C1487a.aUa()).mo10188a((C1850u<? super T>) new C1850u<List<TemplatePackageInfo>>() {
            /* renamed from: a */
            public void mo9883a(C1495b bVar) {
            }

            public void onError(Throwable th) {
            }

            public void onSuccess(List<TemplatePackageInfo> list) {
                if (list == null || list.size() == 0) {
                    FunnyTemplateListActivity.this.arD();
                } else {
                    FunnyTemplateListActivity.this.m19811bF(list);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: bD */
    public List<TemplatePackageInfo> m19810bD(List<TemplateResponsePackageInfo> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() > 0) {
            for (TemplateResponsePackageInfo templateResponsePackageInfo : list) {
                TemplatePackageInfo templatePackageInfo = new TemplatePackageInfo();
                templatePackageInfo.strModelCode = "viva_template_funny";
                templatePackageInfo.strGroupCode = templateResponsePackageInfo.index;
                templatePackageInfo.strLang = templateResponsePackageInfo.language;
                templatePackageInfo.nNewCount = Integer.valueOf(templateResponsePackageInfo.newCount).intValue();
                templatePackageInfo.nOrderno = Integer.valueOf(templateResponsePackageInfo.order).intValue();
                templatePackageInfo.strAppminver = templateResponsePackageInfo.minSupportVersion;
                templatePackageInfo.strBannerUrl = templateResponsePackageInfo.bannerUrl;
                templatePackageInfo.strExpiretime = templateResponsePackageInfo.expireTime;
                templatePackageInfo.strFileSize = templateResponsePackageInfo.fileSize;
                templatePackageInfo.strIcon = templateResponsePackageInfo.coverUrl;
                templatePackageInfo.strIntro = templateResponsePackageInfo.description;
                templatePackageInfo.strPublishtime = templateResponsePackageInfo.publishTime;
                templatePackageInfo.strTitle = templateResponsePackageInfo.name;
                arrayList.add(templatePackageInfo);
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    /* renamed from: bF */
    public void m19811bF(List<TemplatePackageInfo> list) {
        ArrayList arrayList = new ArrayList();
        for (TemplatePackageInfo templatePackageInfo : list) {
            if (templatePackageInfo != null) {
                arrayList.add(new C6821a().mo30394fu(this).mo30391a(templatePackageInfo).mo30393e(FunnyCategoryFragment.m19758iv(templatePackageInfo.strGroupCode)).arG());
            }
        }
        this.dgV.mo30384bG(arrayList);
        int count = this.dgV.getCount();
        if (count > 1) {
            LayoutParams layoutParams = (LayoutParams) this.dgU.getLayoutParams();
            layoutParams.height = C4583d.m11673ii(36);
            layoutParams.topMargin = C4583d.m11673ii(10);
            layoutParams.addRule(14);
            this.dgU.setLayoutParams(layoutParams);
            for (int i = 0; i < count; i++) {
                C0427f aI = this.dgU.mo2008aI(i);
                if (aI != null) {
                    FunnyTabView pj = this.dgV.mo30386pj(i);
                    aI.mo2088E(pj);
                    if (i == 0) {
                        pj.setSelect(true);
                    }
                }
            }
            return;
        }
        LayoutParams layoutParams2 = (LayoutParams) this.dgU.getLayoutParams();
        layoutParams2.height = 0;
        layoutParams2.topMargin = 0;
        this.dgU.setLayoutParams(layoutParams2);
    }

    /* access modifiers changed from: protected */
    /* renamed from: FV */
    public String[] mo22813FV() {
        return new String[]{FunnySlideRouter.ACTION_FINISH_FUNNY_INFO_ACTIVITY};
    }

    public void onClick(View view) {
        if (view.equals(this.bvn)) {
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.editor_act_funny_template_info);
        UtilsPrefs with = UtilsPrefs.with(this, EditorRouter.VIVA_EDITOR_PREF_FILENAME, true);
        if (!with.readBoolean(EditorRouter.KEY_HAS_SHOWED_FUNNY_TEMPLATE_DIALOG, false) && C2575a.m7391rq(C3742b.m9111II().mo23134JB()) != 0) {
            FunnyTemplateDialogFragment funnyTemplateDialogFragment = new FunnyTemplateDialogFragment();
            funnyTemplateDialogFragment.setTitle(arE());
            funnyTemplateDialogFragment.show(getSupportFragmentManager(), "funnyDialog");
            C6738a.m19559bL(getApplicationContext(), C3742b.m9111II().mo23134JB());
            with.writeBoolean(EditorRouter.KEY_HAS_SHOWED_FUNNY_TEMPLATE_DIALOG, true);
        }
        m19805Kl();
        mo22812FU();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
    }

    /* access modifiers changed from: protected */
    /* renamed from: q */
    public void mo22820q(Intent intent) {
        if (FunnySlideRouter.ACTION_FINISH_FUNNY_INFO_ACTIVITY.equals(intent.getAction())) {
            finish();
        }
    }
}
