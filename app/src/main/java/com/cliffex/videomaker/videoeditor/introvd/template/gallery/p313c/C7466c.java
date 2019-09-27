package com.introvd.template.gallery.p313c;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.introvd.template.p203b.C4583d;
import com.introvd.template.xygallery.R;

/* renamed from: com.introvd.template.gallery.c.c */
public class C7466c extends C7445a {
    /* access modifiers changed from: private */
    public RelativeLayout cSO;
    /* access modifiers changed from: private */
    public RelativeLayout cSP;
    /* access modifiers changed from: private */
    public PopupWindow cSQ;
    private TextView dIf;

    /* renamed from: po */
    private OnClickListener f3544po = new OnClickListener() {
        public void onClick(View view) {
            if (view.equals(C7466c.this.cSO)) {
                C7466c.this.setFocusTab(0);
                if (C7466c.this.cSQ != null && C7466c.this.cSQ.isShowing()) {
                    C7466c.this.cSQ.dismiss();
                }
            } else if (view.equals(C7466c.this.cSP)) {
                C7466c.this.setFocusTab(1);
                if (C7466c.this.cSQ != null && C7466c.this.cSQ.isShowing()) {
                    C7466c.this.cSQ.dismiss();
                }
            } else if (view.equals(C7466c.this.dHH) && ((!(C7466c.this.mContext instanceof Activity) || !((Activity) C7466c.this.mContext).isFinishing()) && C7466c.this.amG() > 1 && (C7466c.this.dHH.getParent() instanceof View))) {
                C7466c.this.m22074cW((View) C7466c.this.dHH.getParent());
            }
        }
    };

    public C7466c(ViewGroup viewGroup) {
        super(viewGroup);
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.gallery_include_ve_title_pop, null);
        this.cSQ = new PopupWindow(inflate, -2, -2, true);
        this.cSQ.setTouchable(true);
        this.cSQ.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.color.transparent));
        this.cSQ.setTouchInterceptor(new OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return false;
            }
        });
        if (inflate != null) {
            this.cSO = (RelativeLayout) inflate.findViewById(R.id.xiaoying_gallery_video_tab);
            this.cSP = (RelativeLayout) inflate.findViewById(R.id.xiaoying_gallery_photo_tab);
            this.cSO.setOnClickListener(this.f3544po);
            this.cSP.setOnClickListener(this.f3544po);
        }
        this.dHH.setOnClickListener(this.f3544po);
        this.dIf = (TextView) this.dHH.findViewById(R.id.gallery_title);
        setFocusTab(0);
    }

    /* renamed from: a */
    private void m22070a(RelativeLayout relativeLayout, boolean z) {
        if (relativeLayout != null) {
            TextView textView = (TextView) relativeLayout.getChildAt(0);
            if (z) {
                textView.setTextColor(this.mContext.getResources().getColor(R.color.color_fd6132));
            } else {
                textView.setTextColor(-1);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: cW */
    public void m22074cW(View view) {
        try {
            this.cSQ.showAtLocation(view, 48, 0, C4583d.dpFloatToPixel(this.mContext, 48.0f));
        } catch (Exception unused) {
        }
    }

    public int amG() {
        int i = this.cSO.getVisibility() == 0 ? 1 : 0;
        return this.cSP.getVisibility() == 0 ? i + 1 : i;
    }

    public void azd() {
        super.azd();
        if (amG() <= 1) {
            View findViewById = this.dHH.findViewById(R.id.gallery_more_icon);
            if (findViewById != null) {
                findViewById.setVisibility(8);
            }
            TextView textView = (TextView) this.dHH.findViewById(R.id.textview_hint);
            if (textView != null) {
                textView.setVisibility(8);
            }
            TextView textView2 = (TextView) this.dHH.findViewById(R.id.gallery_title);
            if (textView2 != null) {
                LayoutParams layoutParams = (LayoutParams) textView2.getLayoutParams();
                layoutParams.addRule(13);
                textView2.setLayoutParams(layoutParams);
            }
        }
    }

    /* renamed from: rq */
    public void mo32110rq(int i) {
        switch (i) {
            case 0:
                this.cSO.setVisibility(0);
                this.cSP.setVisibility(0);
                this.dHF = 0;
                return;
            case 1:
                this.cSP.setVisibility(8);
                this.cSO.setVisibility(8);
                this.dHF = 0;
                return;
            case 2:
                this.cSP.setVisibility(8);
                this.cSO.setVisibility(8);
                this.dHF = 1;
                return;
            default:
                this.cSO.setVisibility(0);
                this.cSP.setVisibility(0);
                this.dHF = 0;
                return;
        }
    }

    /* renamed from: rr */
    public void mo32111rr(int i) {
        this.dIf.setText(mo32113rt(i));
    }

    public void setFocusTab(int i) {
        if (i == 0) {
            m22070a(this.cSO, true);
            m22070a(this.cSP, false);
        } else if (i == 1) {
            m22070a(this.cSO, false);
            m22070a(this.cSP, true);
        }
        mo32111rr(i);
        this.dHF = i;
        if (this.dHG != null) {
            this.dHG.mo32046rn(this.dHF);
        }
    }
}
