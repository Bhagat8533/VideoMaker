package com.introvd.template.editor.effects.bubble.subtitle;

import android.support.p024v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.introvd.template.common.model.AppStateModel;
import com.introvd.template.editor.R;

/* renamed from: com.introvd.template.editor.effects.bubble.subtitle.h */
public class C6032h {
    private View btV;
    /* access modifiers changed from: private */
    public RelativeLayout cHS;
    /* access modifiers changed from: private */
    public RelativeLayout cHT;
    /* access modifiers changed from: private */
    public RelativeLayout cHU;
    /* access modifiers changed from: private */
    public RelativeLayout cHV;
    private RecyclerView cHW;
    private LinearLayout cHX;
    private LinearLayout cHY;
    private LinearLayout cHZ;
    private C6034a cIa;
    private int cwZ = 0;

    /* renamed from: po */
    private OnClickListener f3496po = new OnClickListener() {
        public void onClick(View view) {
            if (view == C6032h.this.cHS) {
                C6032h.this.m17128kU(0);
            } else if (view == C6032h.this.cHT) {
                C6032h.this.m17128kU(1);
            } else if (view == C6032h.this.cHU) {
                C6032h.this.m17128kU(2);
            } else if (view == C6032h.this.cHV) {
                C6032h.this.m17128kU(3);
            }
        }
    };

    /* renamed from: com.introvd.template.editor.effects.bubble.subtitle.h$a */
    public interface C6034a {
        /* renamed from: my */
        void mo28745my(int i);
    }

    public C6032h(View view) {
        this.btV = view;
        m17124bS(view);
        m17126cB(view);
    }

    /* renamed from: bS */
    private void m17124bS(View view) {
        this.cHS = (RelativeLayout) view.findViewById(R.id.tab_font_style);
        this.cHT = (RelativeLayout) view.findViewById(R.id.tab_font_color);
        this.cHU = (RelativeLayout) view.findViewById(R.id.tab_font_stroke);
        this.cHV = (RelativeLayout) view.findViewById(R.id.tab_font_shadow);
        this.cHS.setOnClickListener(this.f3496po);
        this.cHT.setOnClickListener(this.f3496po);
        this.cHU.setOnClickListener(this.f3496po);
        this.cHV.setOnClickListener(this.f3496po);
        this.cHX = (LinearLayout) view.findViewById(R.id.layout_font_tab_color);
        this.cHW = (RecyclerView) view.findViewById(R.id.recycler_view_font_text);
        this.cHY = (LinearLayout) view.findViewById(R.id.rl_stroke_layout);
        this.cHZ = (LinearLayout) view.findViewById(R.id.ll_adjust_more);
    }

    /* renamed from: cB */
    private void m17126cB(View view) {
        View findViewById = view.findViewById(R.id.tab_font_style_image);
        View findViewById2 = view.findViewById(R.id.tab_font_style_tv);
        View findViewById3 = view.findViewById(R.id.tab_font_color_image);
        View findViewById4 = view.findViewById(R.id.tab_font_color_tv);
        View findViewById5 = view.findViewById(R.id.tab_font_stroke_image);
        View findViewById6 = view.findViewById(R.id.tab_font_stroke_tv);
        View findViewById7 = view.findViewById(R.id.tab_font_shadow_image);
        View findViewById8 = view.findViewById(R.id.tab_font_shadow_tv);
        boolean isInChina = AppStateModel.getInstance().isInChina();
        int i = 0;
        findViewById.setVisibility(isInChina ? 8 : 0);
        findViewById3.setVisibility(isInChina ? 8 : 0);
        findViewById5.setVisibility(isInChina ? 8 : 0);
        findViewById7.setVisibility(isInChina ? 8 : 0);
        findViewById2.setVisibility(isInChina ? 0 : 8);
        findViewById4.setVisibility(isInChina ? 0 : 8);
        findViewById6.setVisibility(isInChina ? 0 : 8);
        if (!isInChina) {
            i = 8;
        }
        findViewById8.setVisibility(i);
    }

    /* access modifiers changed from: private */
    /* renamed from: kU */
    public void m17128kU(int i) {
        if (i != this.cwZ) {
            String str = "";
            switch (i) {
                case 0:
                    mo28743b(true, this.cHS);
                    mo28743b(false, this.cHT);
                    mo28743b(false, this.cHU);
                    mo28743b(false, this.cHV);
                    this.cHW.setVisibility(0);
                    this.cHX.setVisibility(8);
                    this.cHY.setVisibility(8);
                    this.cHZ.setVisibility(8);
                    str = "字体";
                    break;
                case 1:
                    mo28743b(false, this.cHS);
                    mo28743b(true, this.cHT);
                    mo28743b(false, this.cHU);
                    mo28743b(false, this.cHV);
                    this.cHW.setVisibility(8);
                    this.cHX.setVisibility(0);
                    this.cHY.setVisibility(8);
                    this.cHZ.setVisibility(8);
                    str = "颜色";
                    break;
                case 2:
                    mo28743b(false, this.cHS);
                    mo28743b(false, this.cHT);
                    mo28743b(true, this.cHU);
                    mo28743b(false, this.cHV);
                    this.cHW.setVisibility(8);
                    this.cHX.setVisibility(8);
                    this.cHY.setVisibility(0);
                    this.cHZ.setVisibility(8);
                    str = "描边";
                    break;
                case 3:
                    mo28743b(false, this.cHS);
                    mo28743b(false, this.cHT);
                    mo28743b(false, this.cHU);
                    mo28743b(true, this.cHV);
                    this.cHW.setVisibility(8);
                    this.cHX.setVisibility(8);
                    this.cHY.setVisibility(8);
                    this.cHZ.setVisibility(0);
                    str = "阴影";
                    break;
            }
            C6031g.m17109bf(this.btV.getContext(), str);
            this.cwZ = i;
            if (this.cIa != null) {
                this.cIa.mo28745my(i);
            }
        }
    }

    /* renamed from: a */
    public void mo28742a(C6034a aVar) {
        this.cIa = aVar;
    }

    /* renamed from: b */
    public void mo28743b(boolean z, RelativeLayout relativeLayout) {
        if (relativeLayout != null) {
            relativeLayout.setBackgroundColor(z ? this.btV.getContext().getResources().getColor(R.color.color_1affffff) : this.btV.getContext().getResources().getColor(R.color.transparent));
        }
    }
}
