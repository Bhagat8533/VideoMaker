package com.introvd.template.common.p236ui.custom;

import com.introvd.template.common.p236ui.custom.RatingBarView.OnStarChangedListener;

/* renamed from: com.introvd.template.common.ui.custom.a */
class C5329a implements OnStarChangedListener {
    private final RatingBarDialog cgX;

    public C5329a(RatingBarDialog ratingBarDialog) {
        this.cgX = ratingBarDialog;
    }

    public void onStarChanged(float f) {
        this.cgX.m14484Z(f);
    }
}
