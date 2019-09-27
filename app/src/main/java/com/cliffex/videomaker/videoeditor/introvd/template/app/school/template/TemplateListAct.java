package com.introvd.template.app.school.template;

import android.os.Bundle;
import android.support.p021v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.aiii.android.arouter.facade.p094a.C1942a;
import com.introvd.template.EventActivity;
import com.introvd.template.R;
import com.introvd.template.app.push.api.model.CommonResponseResult;
import com.introvd.template.app.school.api.C4153h;
import com.introvd.template.app.school.api.model.VideoLabelInfo;
import com.introvd.template.app.school.api.model.VideoLabelInfoResult;
import com.introvd.template.app.school.p197c.C4173a;
import com.introvd.template.app.school.template.view.C4235a;
import com.introvd.template.app.school.template.view.TemplateFragmentPageAdapter;
import com.introvd.template.app.school.template.view.TemplateLabelListView;
import com.introvd.template.common.p236ui.XYViewPager;
import com.introvd.template.p203b.C4583d;
import com.introvd.template.router.AppRouter.TemplateParams;
import java.util.ArrayList;
import p037b.p050b.C1850u;
import p037b.p050b.p051a.p053b.C1487a;
import p037b.p050b.p054b.C1495b;
import p037b.p050b.p076j.C1820a;

@C1942a(mo10417rZ = "/app/TemplateListAct")
public class TemplateListAct extends EventActivity implements OnClickListener {
    private static final int byJ = C4583d.m11673ii(15);
    /* access modifiers changed from: private */
    public XYViewPager bwW;
    /* access modifiers changed from: private */
    public TemplateFragmentPageAdapter bwX;
    /* access modifiers changed from: private */
    public int bwY = 0;
    private ImageView byK;
    /* access modifiers changed from: private */
    public TemplateLabelListView byL;

    /* renamed from: HQ */
    private void m10525HQ() {
        if (getIntent() != null) {
            this.bwY = getIntent().getIntExtra(TemplateParams.INTENT_EXTRA_KEY_PAGE_ITEM, 0);
        }
    }

    /* renamed from: In */
    private void m10526In() {
        this.byK.setOnClickListener(this);
        this.bwW.addOnPageChangeListener(new OnPageChangeListener() {
            public void onPageScrollStateChanged(int i) {
            }

            public void onPageScrolled(int i, float f, int i2) {
            }

            public void onPageSelected(int i) {
                TemplateListAct.this.byL.smoothScrollToPosition(i);
                TemplateListAct.this.byL.getLabelAdapter().mo24224ht(i);
                TemplateListAct.this.bwX.getItem(i).mo24178bL(false);
                C4173a.m10393S(TemplateListAct.this, ((VideoLabelInfo) TemplateListAct.this.byL.getLabelAdapter().getListItem(i)).getName());
                C4173a.m10394T(TemplateListAct.this, ((VideoLabelInfo) TemplateListAct.this.byL.getLabelAdapter().getListItem(i)).getName());
            }
        });
        this.byL.setTemplateLabelListener(new C4235a() {
            /* renamed from: hk */
            public void mo23825hk(int i) {
                TemplateListAct.this.bwW.setCurrentItem(i);
                C4173a.m10393S(TemplateListAct.this, ((VideoLabelInfo) TemplateListAct.this.byL.getLabelAdapter().getListItem(i)).getName());
                C4173a.m10394T(TemplateListAct.this, ((VideoLabelInfo) TemplateListAct.this.byL.getLabelAdapter().getListItem(i)).getName());
            }
        });
    }

    /* renamed from: Iy */
    private void m10527Iy() {
        C4153h.m10353NP().mo10196g(C1820a.aVi()).mo10194f(C1487a.aUa()).mo10188a((C1850u<? super T>) new C1850u<CommonResponseResult<VideoLabelInfoResult>>() {
            /* renamed from: a */
            public void mo9883a(C1495b bVar) {
            }

            /* renamed from: a */
            public void onSuccess(CommonResponseResult<VideoLabelInfoResult> commonResponseResult) {
                if (commonResponseResult != null && commonResponseResult.data != null && ((VideoLabelInfoResult) commonResponseResult.data).list != null) {
                    TemplateListAct.this.byL.setData(((VideoLabelInfoResult) commonResponseResult.data).list);
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < ((VideoLabelInfoResult) commonResponseResult.data).list.size(); i++) {
                        VideoLabelInfo videoLabelInfo = (VideoLabelInfo) ((VideoLabelInfoResult) commonResponseResult.data).list.get(i);
                        TemplateListFragment templateListFragment = new TemplateListFragment();
                        Bundle bundle = new Bundle();
                        bundle.putInt("labelkey", videoLabelInfo.getId().intValue());
                        bundle.putString("labelName", videoLabelInfo.getName());
                        bundle.putBoolean("isFromCreatePage", false);
                        templateListFragment.setArguments(bundle);
                        arrayList.add(templateListFragment);
                    }
                    TemplateListAct.this.bwX = new TemplateFragmentPageAdapter(TemplateListAct.this.getSupportFragmentManager(), arrayList);
                    TemplateListAct.this.bwW.setAdapter(TemplateListAct.this.bwX);
                    TemplateListAct.this.bwX.getItem(TemplateListAct.this.bwY).mo24178bL(true);
                    TemplateListAct.this.bwW.setCurrentItem(TemplateListAct.this.bwY);
                    C4173a.m10393S(TemplateListAct.this, ((VideoLabelInfo) TemplateListAct.this.byL.getLabelAdapter().getListItem(TemplateListAct.this.bwY)).getName());
                    C4173a.m10394T(TemplateListAct.this, ((VideoLabelInfo) TemplateListAct.this.byL.getLabelAdapter().getListItem(TemplateListAct.this.bwY)).getName());
                }
            }

            public void onError(Throwable th) {
                th.printStackTrace();
            }
        });
    }

    /* renamed from: Oj */
    private void m10528Oj() {
        this.byK = (ImageView) findViewById(R.id.template_back);
        this.byL = (TemplateLabelListView) findViewById(R.id.template_label);
        this.bwW = (XYViewPager) findViewById(R.id.template_act_viewpager);
        this.bwW.setOffscreenPageLimit(3);
    }

    public void onClick(View view) {
        if (view.equals(this.byK)) {
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_template_list);
        m10525HQ();
        m10528Oj();
        m10526In();
        m10527Iy();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
    }
}
