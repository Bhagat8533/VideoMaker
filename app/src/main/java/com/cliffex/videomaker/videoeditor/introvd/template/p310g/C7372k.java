package com.introvd.template.p310g;

import android.databinding.C0170e;
import android.databinding.C0171f;
import android.databinding.ViewDataBinding;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.introvd.template.R;
import com.introvd.template.app.school.api.model.SchoolCourseInfo;
import com.introvd.template.xyui.RoundedRelativeLayout;
import com.quvideo.mobile.component.imageview.DynamicLoadingImageView;

/* renamed from: com.introvd.template.g.k */
public abstract class C7372k extends ViewDataBinding {
    public final TextView bAk;
    public final TextView cpp;
    public final DynamicLoadingImageView cpr;
    public final ImageView cps;
    public final DynamicLoadingImageView cpt;
    public final TextView cpu;
    public final RoundedRelativeLayout cpv;
    protected SchoolCourseInfo cpw;

    protected C7372k(C0170e eVar, View view, int i, DynamicLoadingImageView dynamicLoadingImageView, ImageView imageView, DynamicLoadingImageView dynamicLoadingImageView2, TextView textView, TextView textView2, TextView textView3, RoundedRelativeLayout roundedRelativeLayout) {
        super(eVar, view, i);
        this.cpr = dynamicLoadingImageView;
        this.cps = imageView;
        this.cpt = dynamicLoadingImageView2;
        this.cpu = textView;
        this.cpp = textView2;
        this.bAk = textView3;
        this.cpv = roundedRelativeLayout;
    }

    /* renamed from: a */
    public static C7372k m21729a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return m21730a(layoutInflater, viewGroup, z, C0171f.m360T());
    }

    /* renamed from: a */
    public static C7372k m21730a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, C0170e eVar) {
        return (C7372k) C0171f.m366a(layoutInflater, R.layout.app_view_school_course_detail_item, viewGroup, z, eVar);
    }

    /* renamed from: c */
    public abstract void mo32003c(SchoolCourseInfo schoolCourseInfo);
}
