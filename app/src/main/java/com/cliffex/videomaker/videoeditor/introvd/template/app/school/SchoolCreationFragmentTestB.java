package com.introvd.template.app.school;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.AppBarLayout.C0373b;
import android.support.p021v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.introvd.template.R;
import com.introvd.template.app.push.api.model.CommonResponseResult;
import com.introvd.template.app.school.api.C4153h;
import com.introvd.template.app.school.api.model.VideoLabelInfo;
import com.introvd.template.app.school.api.model.VideoLabelInfoResult;
import com.introvd.template.app.school.template.TemplateListFragment;
import com.introvd.template.app.school.template.view.C4235a;
import com.introvd.template.app.school.template.view.TemplateFragmentPageAdapter;
import com.introvd.template.app.school.template.view.TemplateLabelListView;
import com.introvd.template.common.p236ui.XYViewPager;
import com.introvd.template.p203b.C4583d;
import java.util.ArrayList;
import p037b.p050b.C1850u;
import p037b.p050b.p051a.p053b.C1487a;
import p037b.p050b.p054b.C1495b;
import p037b.p050b.p076j.C1820a;

public class SchoolCreationFragmentTestB extends BaseSchoolCreationFragment {
    private View bwU;
    /* access modifiers changed from: private */
    public TemplateLabelListView bwV;
    /* access modifiers changed from: private */
    public XYViewPager bwW;
    /* access modifiers changed from: private */
    public TemplateFragmentPageAdapter bwX;
    /* access modifiers changed from: private */
    public int bwY = 0;

    /* renamed from: Iy */
    private void m10305Iy() {
        C4191j.m10442Nv().mo24152NC();
        C4191j.m10442Nv().mo24153ND();
        C4153h.m10353NP().mo10196g(C1820a.aVi()).mo10194f(C1487a.aUa()).mo10188a((C1850u<? super T>) new C1850u<CommonResponseResult<VideoLabelInfoResult>>() {
            /* renamed from: a */
            public void mo9883a(C1495b bVar) {
            }

            /* renamed from: a */
            public void onSuccess(CommonResponseResult<VideoLabelInfoResult> commonResponseResult) {
                if (commonResponseResult != null && commonResponseResult.data != null && ((VideoLabelInfoResult) commonResponseResult.data).list != null) {
                    SchoolCreationFragmentTestB.this.bwV.getLabelAdapter().setDataList(((VideoLabelInfoResult) commonResponseResult.data).list);
                    SchoolCreationFragmentTestB.this.bwV.getLabelAdapter().notifyDataSetChanged();
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < ((VideoLabelInfoResult) commonResponseResult.data).list.size(); i++) {
                        VideoLabelInfo videoLabelInfo = (VideoLabelInfo) ((VideoLabelInfoResult) commonResponseResult.data).list.get(i);
                        TemplateListFragment templateListFragment = new TemplateListFragment();
                        Bundle bundle = new Bundle();
                        bundle.putInt("labelkey", videoLabelInfo.getId().intValue());
                        bundle.putString("labelName", videoLabelInfo.getName());
                        bundle.putBoolean("labelEnable", false);
                        bundle.putBoolean("isFromCreatePage", true);
                        templateListFragment.setArguments(bundle);
                        arrayList.add(templateListFragment);
                    }
                    SchoolCreationFragmentTestB.this.bwX = new TemplateFragmentPageAdapter(SchoolCreationFragmentTestB.this.getChildFragmentManager(), arrayList);
                    SchoolCreationFragmentTestB.this.bwW.setAdapter(SchoolCreationFragmentTestB.this.bwX);
                    SchoolCreationFragmentTestB.this.bwW.setCurrentItem(0);
                    SchoolCreationFragmentTestB.this.bwX.getItem(0).mo24178bL(true);
                    SchoolCreationFragmentTestB.this.bwv.setScrollUpChild(SchoolCreationFragmentTestB.this.bwX.getItem(0).mo24176Ol());
                }
            }

            public void onError(Throwable th) {
                th.printStackTrace();
            }
        });
    }

    /* renamed from: Nu */
    private void m10306Nu() {
        this.bwW.addOnPageChangeListener(new OnPageChangeListener() {
            public void onPageScrollStateChanged(int i) {
            }

            public void onPageScrolled(int i, float f, int i2) {
            }

            public void onPageSelected(int i) {
                SchoolCreationFragmentTestB.this.bwY = i;
                SchoolCreationFragmentTestB.this.bwV.smoothScrollToPosition(i);
                SchoolCreationFragmentTestB.this.bwV.getLabelAdapter().mo24224ht(i);
                SchoolCreationFragmentTestB.this.bwX.getItem(i).mo24178bL(false);
                SchoolCreationFragmentTestB.this.bwv.setScrollUpChild(SchoolCreationFragmentTestB.this.bwX.getItem(i).mo24176Ol());
            }
        });
        this.bwV.setTemplateLabelListener(new C4235a() {
            /* renamed from: hk */
            public void mo23825hk(int i) {
                SchoolCreationFragmentTestB.this.bwY = i;
                SchoolCreationFragmentTestB.this.bwW.setCurrentItem(i);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public /* synthetic */ void m10313e(AppBarLayout appBarLayout, int i) {
        if (getActivity() != null) {
            this.bwv.setEnabled(i >= 0);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: Kp */
    public void mo23814Kp() {
        C4191j.m10442Nv().mo24152NC();
        C4191j.m10442Nv().mo24153ND();
        if (this.bwX != null) {
            this.bwX.getItem(this.bwY).mo24178bL(true);
            this.bwX.notifyDataSetChanged();
        }
        if (this.bwv != null) {
            this.bwv.setRefreshing(false);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: cD */
    public View mo23816cD(Context context) {
        SchoolCourseItemListView schoolCourseItemListView = new SchoolCourseItemListView(context);
        schoolCourseItemListView.setData(new ArrayList());
        return schoolCourseItemListView;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: cE */
    public View mo23817cE(Context context) {
        this.bwV = new TemplateLabelListView(context);
        return this.bwV;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: cF */
    public View mo23818cF(Context context) {
        this.bwW = new XYViewPager(context);
        this.bwW.setId(R.id.viewPager);
        return this.bwW;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.bwU = super.onCreateView(layoutInflater, viewGroup, bundle);
        this.bwV.getLayoutParams().height = C4583d.m11673ii(48);
        this.bwU = super.onCreateView(layoutInflater, viewGroup, bundle);
        this.bwx.mo1528a((C0373b) new C4190i(this));
        m10306Nu();
        m10305Iy();
        return this.bwU;
    }
}
