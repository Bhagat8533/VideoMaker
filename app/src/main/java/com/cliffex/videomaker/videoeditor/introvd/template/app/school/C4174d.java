package com.introvd.template.app.school;

import android.view.View;
import android.view.View.OnClickListener;
import com.introvd.template.app.school.api.model.SchoolCourseInfo;

/* renamed from: com.introvd.template.app.school.d */
class C4174d implements OnClickListener {
    private final SchoolCourseInfo bwG;

    public C4174d(SchoolCourseInfo schoolCourseInfo) {
        this.bwG = schoolCourseInfo;
    }

    public void onClick(View view) {
        C4170c.m10379a(this.bwG, view);
    }
}
