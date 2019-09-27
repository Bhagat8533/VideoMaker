package com.introvd.template.p310g;

import android.databinding.C0170e;
import android.databinding.C0171f;
import android.databinding.ViewDataBinding;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Space;
import android.widget.TextView;
import com.introvd.template.R;
import com.introvd.template.app.school.api.model.TemplateInfo;
import com.introvd.template.common.p236ui.video.XYSimpleVideoView;
import com.introvd.template.xyui.RoundedTextView;
import com.quvideo.mobile.component.imageview.DynamicLoadingImageView;
import com.quvideo.mobile.component.imageview.XYImageView;

/* renamed from: com.introvd.template.g.o */
public abstract class C7376o extends ViewDataBinding {
    public final TextView bAk;
    public final ImageView bzs;
    public final DynamicLoadingImageView cpA;
    public final ImageView cpB;
    public final ImageView cpC;
    public final XYSimpleVideoView cpD;
    public final Space cpE;
    public final RoundedTextView cpF;
    public final TextView cpG;
    public final XYImageView cpH;
    protected boolean cpI;
    protected TemplateInfo cpJ;
    protected boolean cpK;
    protected boolean cpL;
    public final TextView cpp;
    public final DynamicLoadingImageView cpr;
    public final TextView cpu;
    public final TextView cpz;

    protected C7376o(C0170e eVar, View view, int i, TextView textView, ImageView imageView, DynamicLoadingImageView dynamicLoadingImageView, DynamicLoadingImageView dynamicLoadingImageView2, ImageView imageView2, ImageView imageView3, XYSimpleVideoView xYSimpleVideoView, Space space, TextView textView2, RoundedTextView roundedTextView, TextView textView3, TextView textView4, TextView textView5, XYImageView xYImageView) {
        super(eVar, view, i);
        this.cpz = textView;
        this.bzs = imageView;
        this.cpA = dynamicLoadingImageView;
        this.cpr = dynamicLoadingImageView2;
        this.cpB = imageView2;
        this.cpC = imageView3;
        this.cpD = xYSimpleVideoView;
        this.cpE = space;
        this.cpu = textView2;
        this.cpF = roundedTextView;
        this.cpG = textView3;
        this.cpp = textView4;
        this.bAk = textView5;
        this.cpH = xYImageView;
    }

    /* renamed from: c */
    public static C7376o m21737c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return m21738c(layoutInflater, viewGroup, z, C0171f.m360T());
    }

    /* renamed from: c */
    public static C7376o m21738c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, C0170e eVar) {
        return (C7376o) C0171f.m366a(layoutInflater, R.layout.app_view_school_template_detail_item, viewGroup, z, eVar);
    }

    public boolean aaU() {
        return this.cpI;
    }

    /* renamed from: dK */
    public abstract void mo32005dK(boolean z);

    /* renamed from: dL */
    public abstract void mo32006dL(boolean z);

    /* renamed from: dM */
    public abstract void mo32007dM(boolean z);

    /* renamed from: e */
    public abstract void mo32008e(TemplateInfo templateInfo);
}
