package com.introvd.template.app.homepage.p186a;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.introvd.template.R;
import com.introvd.template.app.p177b.C3742b;
import com.introvd.template.common.p236ui.modechooser.ModeItemInfo;
import com.introvd.template.module.p339c.C7689a;
import java.util.List;

/* renamed from: com.introvd.template.app.homepage.a.a */
public class C3929a {
    /* access modifiers changed from: private */
    public C3931a brZ;
    private View bsa;
    private View bsb;

    /* renamed from: com.introvd.template.app.homepage.a.a$a */
    public interface C3931a {
        /* renamed from: t */
        void mo23463t(View view, int i);
    }

    /* renamed from: LG */
    public boolean mo23458LG() {
        return (this.bsb == null || this.bsa == null) ? false : true;
    }

    /* renamed from: LH */
    public void mo23459LH() {
        if (this.bsa != null && this.bsb != null && (this.bsa instanceof ViewGroup)) {
            this.bsb.clearAnimation();
            ((ViewGroup) this.bsa).removeView(this.bsb);
            this.bsb = null;
            this.bsa = null;
        }
    }

    /* renamed from: a */
    public void mo23460a(C3931a aVar) {
        this.brZ = aVar;
    }

    /* renamed from: a */
    public void mo23461a(List<ModeItemInfo> list, Context context, View view, final int i, String str, Drawable drawable) {
        if ((((ModeItemInfo) list.get(0)).todoCode == i || ((ModeItemInfo) list.get(1)).todoCode == i) && (view.getParent() instanceof ViewGroup)) {
            mo23459LH();
            LayoutParams layoutParams = new LayoutParams(-2, -2);
            View inflate = LayoutInflater.from(context).inflate(R.layout.xyui_popup_imgae_tip_view, null);
            ((ImageView) inflate.findViewById(R.id.image)).setImageDrawable(drawable);
            View findViewById = inflate.findViewById(R.id.container);
            ((TextView) inflate.findViewById(R.id.text)).setText(str);
            this.bsb = inflate;
            this.bsa = (ViewGroup) view.getParent();
            int height = C3742b.m9111II().mo23142JJ() ? view.getHeight() - C7689a.m22595P(10.0f) : view.getHeight() - C7689a.m22595P(25.0f);
            if (((ModeItemInfo) list.get(0)).todoCode == i) {
                layoutParams.addRule(8, view.getId());
                layoutParams.bottomMargin = height;
                findViewById.setBackgroundResource(R.drawable.xyui_bg_help_v2_white);
            } else if (((ModeItemInfo) list.get(1)).todoCode == i) {
                layoutParams.addRule(11);
                layoutParams.addRule(8, view.getId());
                layoutParams.bottomMargin = height;
                findViewById.setBackgroundResource(R.drawable.xyui_bg_help_v2_white_rtl);
            }
            ((ViewGroup) view.getParent()).addView(inflate, layoutParams);
            inflate.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    if (C3929a.this.brZ != null) {
                        C3929a.this.mo23459LH();
                        C3929a.this.brZ.mo23463t(view, i);
                    }
                }
            });
            TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, -0.1f);
            translateAnimation.setDuration(500);
            translateAnimation.setRepeatCount(-1);
            translateAnimation.setRepeatMode(2);
            inflate.startAnimation(translateAnimation);
        }
    }
}
