package com.introvd.template.app.school;

import android.support.p021v4.widget.SwipeRefreshLayout.OnRefreshListener;

/* renamed from: com.introvd.template.app.school.a */
class C4143a implements OnRefreshListener {
    private final BaseSchoolCreationFragment bwB;

    public C4143a(BaseSchoolCreationFragment baseSchoolCreationFragment) {
        this.bwB = baseSchoolCreationFragment;
    }

    public void onRefresh() {
        this.bwB.m10269Nr();
    }
}
