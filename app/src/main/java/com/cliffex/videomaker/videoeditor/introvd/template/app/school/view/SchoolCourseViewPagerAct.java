package com.introvd.template.app.school.view;

import android.os.Bundle;
import android.support.p021v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import com.introvd.template.EventActivity;
import com.introvd.template.R;
import com.introvd.template.app.school.p196b.C4166f;
import com.introvd.template.app.school.p196b.C4169i;
import com.introvd.template.xyui.CustomSwipeRefreshLayout;
import org.greenrobot.eventbus.C10021c;
import org.greenrobot.eventbus.C10031j;
import org.greenrobot.eventbus.ThreadMode;

public class SchoolCourseViewPagerAct extends EventActivity {
    /* access modifiers changed from: private */
    public SchoolVideoListViewPager bwN;
    /* access modifiers changed from: private */
    public CustomSwipeRefreshLayout bwv;

    /* renamed from: Nt */
    private void m10693Nt() {
        getLifecycle().mo152a(this.bwN);
        this.bwN.addOnPageChangeListener(new OnPageChangeListener() {
            public void onPageScrollStateChanged(int i) {
            }

            public void onPageScrolled(int i, float f, int i2) {
            }

            public void onPageSelected(int i) {
                SchoolCourseViewPagerAct.this.bwv.setScrollUpChild(SchoolCourseViewPagerAct.this.bwN.getCurPageView());
                C10021c.aZH().mo38492aA(new C4169i(i));
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: OJ */
    public /* synthetic */ void m10694OJ() {
        this.bwN.mo24288OL();
    }

    /* access modifiers changed from: private */
    /* renamed from: bz */
    public /* synthetic */ void m10698bz(View view) {
        finish();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!C10021c.aZH().mo38495ay(this)) {
            C10021c.aZH().mo38494ax(this);
        }
        setContentView(R.layout.app_act_school_course_view_pager);
        findViewById(R.id.template_back).setOnClickListener(new C4269a(this));
        SchoolVideoLabelListView schoolVideoLabelListView = (SchoolVideoLabelListView) findViewById(R.id.layoutLabel);
        this.bwN = (SchoolVideoListViewPager) findViewById(R.id.layoutViewPager);
        this.bwv = (CustomSwipeRefreshLayout) findViewById(R.id.swipeLayout);
        this.bwN.setIsFromCreatePage(false);
        getLifecycle().mo152a(schoolVideoLabelListView);
        m10693Nt();
        this.bwv.setOnRefreshListener(new C4270b(this));
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        C10021c.aZH().mo38496az(this);
    }

    @C10031j(aZK = ThreadMode.MAIN)
    public void onEventMainThread(C4166f fVar) {
        this.bwv.setRefreshing(false);
    }
}
