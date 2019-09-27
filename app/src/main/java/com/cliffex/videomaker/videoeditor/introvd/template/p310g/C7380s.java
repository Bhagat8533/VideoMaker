package com.introvd.template.p310g;

import android.databinding.C0170e;
import android.databinding.C0171f;
import android.databinding.ViewDataBinding;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.introvd.template.R;
import com.introvd.template.app.school.api.model.TemplateInfo;
import com.introvd.template.xyui.RoundedTextView;
import com.quvideo.mobile.component.imageview.DynamicLoadingImageView;

/* renamed from: com.introvd.template.g.s */
public abstract class C7380s extends ViewDataBinding {
    public final TextView bAk;
    public final ImageView cpC;
    protected TemplateInfo cpJ;
    public final DynamicLoadingImageView cpr;
    public final RoundedTextView cqq;
    public final TextView cqr;
    public final RoundedTextView cqs;

    protected C7380s(C0170e eVar, View view, int i, RoundedTextView roundedTextView, DynamicLoadingImageView dynamicLoadingImageView, ImageView imageView, TextView textView, RoundedTextView roundedTextView2, TextView textView2) {
        super(eVar, view, i);
        this.cqq = roundedTextView;
        this.cpr = dynamicLoadingImageView;
        this.cpC = imageView;
        this.cqr = textView;
        this.cqs = roundedTextView2;
        this.bAk = textView2;
    }

    /* renamed from: a */
    public static C7380s m21753a(LayoutInflater layoutInflater) {
        return m21754a(layoutInflater, C0171f.m360T());
    }

    /* renamed from: a */
    public static C7380s m21754a(LayoutInflater layoutInflater, C0170e eVar) {
        return (C7380s) C0171f.m366a(layoutInflater, R.layout.app_view_school_template_list_item, null, false, eVar);
    }

    /* renamed from: e */
    public abstract void mo32013e(TemplateInfo templateInfo);
}
