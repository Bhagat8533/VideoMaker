package com.introvd.template.p310g;

import android.databinding.C0170e;
import android.databinding.ViewDataBinding;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.introvd.template.app.community.freeze.FreezeReasonPage.C3760a;
import com.introvd.template.xyui.RoundedTextView;

/* renamed from: com.introvd.template.g.e */
public abstract class C7363e extends ViewDataBinding {
    protected String bDa;
    public final ImageView btnBack;
    public final RoundedTextView coR;
    public final ImageView coS;
    public final RelativeLayout coT;
    public final TextView coU;
    public final TextView coV;
    public final TextView coW;
    protected C3760a coX;
    protected boolean coY;

    protected C7363e(C0170e eVar, View view, int i, ImageView imageView, RoundedTextView roundedTextView, ImageView imageView2, RelativeLayout relativeLayout, TextView textView, TextView textView2, TextView textView3) {
        super(eVar, view, i);
        this.btnBack = imageView;
        this.coR = roundedTextView;
        this.coS = imageView2;
        this.coT = relativeLayout;
        this.coU = textView;
        this.coV = textView2;
        this.coW = textView3;
    }

    /* renamed from: a */
    public abstract void mo31993a(C3760a aVar);

    /* renamed from: dJ */
    public abstract void mo31994dJ(boolean z);

    public String getAuid() {
        return this.bDa;
    }

    public abstract void setAuid(String str);
}
