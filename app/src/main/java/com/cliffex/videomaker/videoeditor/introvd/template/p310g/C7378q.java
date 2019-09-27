package com.introvd.template.p310g;

import android.databinding.C0170e;
import android.databinding.C0171f;
import android.databinding.ViewDataBinding;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.introvd.template.R;
import com.introvd.template.app.school.api.model.TemplateInfo;
import com.introvd.template.app.school.testa.C4246b;
import com.introvd.template.xyui.RoundedTextView;
import com.quvideo.mobile.component.imageview.DynamicLoadingImageView;
import java.util.List;

/* renamed from: com.introvd.template.g.q */
public abstract class C7378q extends ViewDataBinding {
    public final TextView bAk;
    public final DynamicLoadingImageView cpM;
    public final DynamicLoadingImageView cpN;
    public final DynamicLoadingImageView cpO;
    public final DynamicLoadingImageView cpP;
    public final RoundedTextView cpQ;
    public final RoundedTextView cpR;
    public final RoundedTextView cpS;
    public final RoundedTextView cpT;
    public final TextView cpU;
    public final TextView cpV;
    public final TextView cpW;
    public final TextView cpX;
    public final TextView cpY;
    public final TextView cpZ;
    public final TextView cpx;
    public final View cpy;
    public final TextView cqa;
    public final TextView cqb;
    public final View cqc;
    public final View cqd;
    public final View cqe;
    public final View cqf;
    public final View cqg;
    public final View cqh;
    public final View cqi;
    public final View cqj;
    protected C4246b cqk;
    protected List<TemplateInfo> cql;
    protected String mTitle;

    protected C7378q(C0170e eVar, View view, int i, TextView textView, DynamicLoadingImageView dynamicLoadingImageView, DynamicLoadingImageView dynamicLoadingImageView2, DynamicLoadingImageView dynamicLoadingImageView3, DynamicLoadingImageView dynamicLoadingImageView4, RoundedTextView roundedTextView, RoundedTextView roundedTextView2, RoundedTextView roundedTextView3, RoundedTextView roundedTextView4, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, View view2, View view3, View view4, View view5, View view6, View view7, View view8, View view9, View view10) {
        super(eVar, view, i);
        this.cpx = textView;
        this.cpM = dynamicLoadingImageView;
        this.cpN = dynamicLoadingImageView2;
        this.cpO = dynamicLoadingImageView3;
        this.cpP = dynamicLoadingImageView4;
        this.cpQ = roundedTextView;
        this.cpR = roundedTextView2;
        this.cpS = roundedTextView3;
        this.cpT = roundedTextView4;
        this.cpU = textView2;
        this.cpV = textView3;
        this.cpW = textView4;
        this.cpX = textView5;
        this.cpY = textView6;
        this.cpZ = textView7;
        this.cqa = textView8;
        this.cqb = textView9;
        this.bAk = textView10;
        this.cqc = view2;
        this.cqd = view3;
        this.cqe = view4;
        this.cqf = view5;
        this.cpy = view6;
        this.cqg = view7;
        this.cqh = view8;
        this.cqi = view9;
        this.cqj = view10;
    }

    /* renamed from: d */
    public static C7378q m21747d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return m21748d(layoutInflater, viewGroup, z, C0171f.m360T());
    }

    /* renamed from: d */
    public static C7378q m21748d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, C0170e eVar) {
        return (C7378q) C0171f.m366a(layoutInflater, R.layout.app_view_school_template_grid_item, viewGroup, z, eVar);
    }

    /* renamed from: a */
    public abstract void mo32009a(C4246b bVar);

    /* renamed from: aF */
    public abstract void mo32010aF(List<TemplateInfo> list);

    public abstract void setTitle(String str);
}
