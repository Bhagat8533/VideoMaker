package com.introvd.template.app.school.template.detail;

import android.view.View;
import android.view.View.OnClickListener;
import com.introvd.template.xyui.feedrecycler.FeedRecylayoutManager;

/* renamed from: com.introvd.template.app.school.template.detail.b */
class C4222b implements OnClickListener {
    private final TemplateDetailAct bzd;
    private final FeedRecylayoutManager bze;

    public C4222b(TemplateDetailAct templateDetailAct, FeedRecylayoutManager feedRecylayoutManager) {
        this.bzd = templateDetailAct;
        this.bze = feedRecylayoutManager;
    }

    public void onClick(View view) {
        this.bzd.m10568a(this.bze, view);
    }
}
