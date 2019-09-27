package com.introvd.template.app.school.view;

import android.support.p021v4.widget.SwipeRefreshLayout.OnRefreshListener;

/* renamed from: com.introvd.template.app.school.view.b */
class C4270b implements OnRefreshListener {
    private final SchoolCourseViewPagerAct bAg;

    public C4270b(SchoolCourseViewPagerAct schoolCourseViewPagerAct) {
        this.bAg = schoolCourseViewPagerAct;
    }

    public void onRefresh() {
        this.bAg.m10694OJ();
    }
}
