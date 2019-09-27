package com.introvd.template.p310g;

import android.databinding.C0170e;
import android.databinding.C0171f;
import android.databinding.ViewDataBinding;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.introvd.template.R;
import com.introvd.template.app.school.api.model.VideoLabelInfo;

/* renamed from: com.introvd.template.g.u */
public abstract class C7382u extends ViewDataBinding {
    public final TextView cpp;
    public final ImageView cqt;
    protected VideoLabelInfo cqu;

    protected C7382u(C0170e eVar, View view, int i, ImageView imageView, TextView textView) {
        super(eVar, view, i);
        this.cqt = imageView;
        this.cpp = textView;
    }

    /* renamed from: b */
    public static C7382u m21757b(LayoutInflater layoutInflater) {
        return m21758b(layoutInflater, C0171f.m360T());
    }

    /* renamed from: b */
    public static C7382u m21758b(LayoutInflater layoutInflater, C0170e eVar) {
        return (C7382u) C0171f.m366a(layoutInflater, R.layout.app_view_school_video_label_list_item, null, false, eVar);
    }

    /* renamed from: a */
    public abstract void mo32014a(VideoLabelInfo videoLabelInfo);
}
