package com.introvd.template.gallery.p313c;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.introvd.template.gallery.C7389a;
import com.introvd.template.xygallery.R;
import com.p131c.p132a.p133a.C2564c;
import com.p131c.p132a.p135c.p136a.C2579b;
import com.p131c.p132a.p135c.p136a.C2579b.C2582a;

/* renamed from: com.introvd.template.gallery.c.d */
public class C7469d extends C7445a {
    private TextView dIh;
    private TextView dIi;

    public C7469d(ViewGroup viewGroup) {
        super(viewGroup);
        this.dIh = (TextView) viewGroup.findViewById(R.id.b_video_tab);
        this.dIi = (TextView) viewGroup.findViewById(R.id.b_photo_tab);
        C2579b.m7398a(new C2582a<View>() {
            public void onClick(View view) {
                if (C7469d.this.amG() > 1) {
                    C2564c.m7327dA(view);
                    C7469d.this.setFocusTab(0);
                }
            }
        }, 500, this.dIh);
        C2579b.m7398a(new C2582a<View>() {
            public void onClick(View view) {
                if (C7469d.this.amG() > 1) {
                    C2564c.m7327dA(view);
                    C7469d.this.setFocusTab(1);
                }
            }
        }, 500, this.dIi);
        setFocusTab(0);
    }

    public int amG() {
        int i = this.dIh.getVisibility() == 0 ? 1 : 0;
        return this.dIi.getVisibility() == 0 ? i + 1 : i;
    }

    public void azd() {
        super.azd();
        if (amG() <= 1) {
            this.dIh.setTextColor(this.mContext.getResources().getColor(R.color.white));
            this.dIi.setTextColor(this.mContext.getResources().getColor(R.color.white));
        }
    }

    /* renamed from: rq */
    public void mo32110rq(int i) {
        switch (i) {
            case 0:
                this.dIh.setVisibility(0);
                this.dIi.setVisibility(0);
                this.dHF = 0;
                return;
            case 1:
                this.dIh.setVisibility(0);
                this.dIi.setVisibility(8);
                this.dHF = 0;
                return;
            case 2:
                this.dIh.setVisibility(8);
                this.dIi.setVisibility(0);
                this.dHF = 1;
                return;
            default:
                this.dIh.setVisibility(0);
                this.dIi.setVisibility(0);
                this.dHF = 0;
                return;
        }
    }

    /* renamed from: rr */
    public void mo32111rr(int i) {
        super.mo32111rr(i);
    }

    public void setFocusTab(int i) {
        if (i == 0) {
            this.dIh.setTextColor(this.mContext.getResources().getColor(R.color.color_ff5e13));
            this.dIi.setTextColor(this.mContext.getResources().getColor(R.color.color_8E8E93));
        } else if (i == 1) {
            this.dIi.setTextColor(this.mContext.getResources().getColor(R.color.color_ff5e13));
            this.dIh.setTextColor(this.mContext.getResources().getColor(R.color.color_8E8E93));
        }
        mo32111rr(i);
        this.dHF = i;
        if (this.dHG != null) {
            this.dHG.mo32046rn(this.dHF);
        }
        C7389a.m21787fZ(this.mContext);
    }
}
