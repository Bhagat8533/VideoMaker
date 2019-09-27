package com.introvd.template.app.school;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.AppBarLayout.C0373b;
import android.support.p021v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.introvd.template.R;
import com.introvd.template.app.homepage.C3935b;
import com.introvd.template.app.homepage.C3935b.C3941a;
import com.introvd.template.app.school.p196b.C4162b;
import com.introvd.template.app.school.p196b.C4169i;
import com.introvd.template.app.school.view.SchoolTemplateHeaderLayout;
import com.introvd.template.app.school.view.SchoolVideoLabelListView;
import com.introvd.template.app.school.view.SchoolVideoListViewPager;
import com.introvd.template.common.ViewClickEffectMgr;
import com.introvd.template.p203b.C4583d;
import org.greenrobot.eventbus.C10021c;
import org.greenrobot.eventbus.C10031j;
import org.greenrobot.eventbus.ThreadMode;

public class SchoolCreationFragment extends BaseSchoolCreationFragment {
    private static final int bwL = C4583d.m11673ii(70);
    private SchoolVideoLabelListView bwM;
    /* access modifiers changed from: private */
    public SchoolVideoListViewPager bwN;
    private SchoolTemplateHeaderLayout bwO;
    private View bwP;
    private View bwy;

    /* renamed from: Iy */
    private void m10285Iy() {
        C3935b.m9679Lb().mo23482a((Context) getActivity(), (C3941a) new C4188g(this));
    }

    /* renamed from: Nt */
    private void m10286Nt() {
        getLifecycle().mo152a(this.bwN);
        this.bwN.addOnPageChangeListener(new OnPageChangeListener() {
            public void onPageScrollStateChanged(int i) {
            }

            public void onPageScrolled(int i, float f, int i2) {
            }

            public void onPageSelected(int i) {
                SchoolCreationFragment.this.bwv.setScrollUpChild(SchoolCreationFragment.this.bwN.getCurPageView());
                C10021c.aZH().mo38492aA(new C4169i(i));
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: bG */
    public /* synthetic */ void m10291bG(boolean z) {
        if (z) {
            this.bwO.mo24267Kp();
        }
        this.bwv.setRefreshing(false);
    }

    /* access modifiers changed from: private */
    /* renamed from: bL */
    public /* synthetic */ void m10292bL(View view) {
        this.bwO.mo24267Kp();
        this.bwM.mo24277Kp();
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public /* synthetic */ void m10293e(AppBarLayout appBarLayout, int i) {
        if (getActivity() != null) {
            boolean z = i >= 0;
            this.bwv.setEnabled(z);
            if (z) {
                this.bww.setTitle(R.string.xiaoying_str_com_creation);
            } else if (this.bwM.mo24278hx(bwL)) {
                this.bww.setTitle(R.string.xiaoying_str_creator_video_course);
            } else if (this.bwO.mo24268hx(bwL)) {
                this.bww.setTitle(R.string.xiaoying_str_creator_recommend_template);
            } else {
                this.bww.setTitle(R.string.xiaoying_str_com_creation);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: Kp */
    public void mo23814Kp() {
        m10285Iy();
        this.bwN.mo24288OL();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: cD */
    public View mo23816cD(Context context) {
        this.bwO = new SchoolTemplateHeaderLayout(context);
        return this.bwO;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: cE */
    public View mo23817cE(Context context) {
        this.bwM = new SchoolVideoLabelListView(context);
        return this.bwM;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: cF */
    public View mo23818cF(Context context) {
        this.bwN = new SchoolVideoListViewPager(context);
        this.bwN.setIsFromCreatePage(true);
        return this.bwN;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.bwy = super.onCreateView(layoutInflater, viewGroup, bundle);
        if (this.bwy == null) {
            return null;
        }
        this.bwP = this.bwy.findViewById(R.id.layoutEmpty);
        getLifecycle().mo152a(this.bwO);
        getLifecycle().mo152a(this.bwM);
        this.bwx.mo1528a((C0373b) new C4186e(this));
        m10286Nt();
        TextView textView = (TextView) this.bwy.findViewById(R.id.btnRefresh);
        ViewClickEffectMgr.addEffectForViews(SchoolCreationFragment.class.getSimpleName(), textView);
        textView.setOnClickListener(new C4187f(this));
        m10285Iy();
        return this.bwy;
    }

    @C10031j(aZK = ThreadMode.MAIN)
    public void onEventMainThread(C4162b bVar) {
        if (bVar != null) {
            if (bVar.mo23988Og()) {
                this.bwM.setVisibility(bVar.mo23989Oh() ? 8 : 0);
                this.bwN.setVisibility(bVar.mo23989Oh() ? 8 : 0);
            }
            if (!bVar.mo23988Og() || !bVar.mo23986Oe() || !bVar.mo23989Oh() || !bVar.mo23987Of()) {
                this.bwP.setVisibility(8);
                mo23815bF(false);
            } else {
                this.bwP.setVisibility(0);
                mo23815bF(true);
            }
        }
    }

    public void onPause() {
        super.onPause();
        C10021c.aZH().mo38496az(this);
    }

    public void onResume() {
        super.onResume();
        if (!C10021c.aZH().mo38495ay(this)) {
            C10021c.aZH().mo38494ax(this);
        }
    }
}
