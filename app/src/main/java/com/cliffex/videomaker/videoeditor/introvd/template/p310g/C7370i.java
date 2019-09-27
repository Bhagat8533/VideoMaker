package com.introvd.template.p310g;

import android.databinding.C0170e;
import android.databinding.ViewDataBinding;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.quvideo.mobile.component.imageview.DynamicLoadingImageView;

/* renamed from: com.introvd.template.g.i */
public abstract class C7370i extends ViewDataBinding {
    public final ImageView cpm;
    public final DynamicLoadingImageView cpn;
    public final ImageView cpo;
    public final TextView cpp;

    protected C7370i(C0170e eVar, View view, int i, ImageView imageView, DynamicLoadingImageView dynamicLoadingImageView, ImageView imageView2, TextView textView) {
        super(eVar, view, i);
        this.cpm = imageView;
        this.cpn = dynamicLoadingImageView;
        this.cpo = imageView2;
        this.cpp = textView;
    }
}
