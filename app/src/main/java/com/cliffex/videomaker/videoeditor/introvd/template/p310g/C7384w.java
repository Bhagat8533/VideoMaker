package com.introvd.template.p310g;

import android.databinding.C0170e;
import android.databinding.C0171f;
import android.databinding.ViewDataBinding;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.introvd.template.R;
import com.introvd.template.app.school.api.model.VideoInfo;
import com.introvd.template.xyui.RoundedTextView;
import com.quvideo.mobile.component.imageview.DynamicLoadingImageView;

/* renamed from: com.introvd.template.g.w */
public abstract class C7384w extends ViewDataBinding {
    public final DynamicLoadingImageView cpr;
    public final View cpy;
    public final TextView cqr;
    public final TextView cqv;
    public final TextView cqw;
    public final RoundedTextView cqx;
    public final RoundedTextView cqy;
    protected VideoInfo cqz;

    protected C7384w(C0170e eVar, View view, int i, DynamicLoadingImageView dynamicLoadingImageView, TextView textView, TextView textView2, TextView textView3, RoundedTextView roundedTextView, RoundedTextView roundedTextView2, View view2) {
        super(eVar, view, i);
        this.cpr = dynamicLoadingImageView;
        this.cqv = textView;
        this.cqr = textView2;
        this.cqw = textView3;
        this.cqx = roundedTextView;
        this.cqy = roundedTextView2;
        this.cpy = view2;
    }

    /* renamed from: c */
    public static C7384w m21763c(LayoutInflater layoutInflater) {
        return m21764c(layoutInflater, C0171f.m360T());
    }

    /* renamed from: c */
    public static C7384w m21764c(LayoutInflater layoutInflater, C0170e eVar) {
        return (C7384w) C0171f.m366a(layoutInflater, R.layout.app_view_school_video_list_item, null, false, eVar);
    }

    /* renamed from: a */
    public abstract void mo32015a(VideoInfo videoInfo);
}
