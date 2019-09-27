package com.introvd.template.editor.effects.quickposition;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import com.introvd.template.editor.R;
import com.introvd.template.editor.effects.bubble.subtitle.C6031g;

public class QuickPositionPanel extends RelativeLayout {
    /* access modifiers changed from: private */
    public View cNA;
    /* access modifiers changed from: private */
    public View cNB;
    /* access modifiers changed from: private */
    public View cNC;
    /* access modifiers changed from: private */
    public View cND;
    /* access modifiers changed from: private */
    public View cNE;
    /* access modifiers changed from: private */
    public View cNF;
    /* access modifiers changed from: private */
    public C6193a cNG;
    /* access modifiers changed from: private */
    public View cNx;
    /* access modifiers changed from: private */
    public View cNy;
    /* access modifiers changed from: private */
    public View cNz;

    /* renamed from: po */
    private OnClickListener f3502po;

    /* renamed from: com.introvd.template.editor.effects.quickposition.QuickPositionPanel$a */
    public interface C6193a {
        /* renamed from: mk */
        void mo28385mk(int i);
    }

    public QuickPositionPanel(Context context) {
        this(context, null);
    }

    public QuickPositionPanel(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QuickPositionPanel(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3502po = new OnClickListener() {
            public void onClick(View view) {
                String str;
                int i;
                String str2 = "";
                if (view.equals(QuickPositionPanel.this.cNx)) {
                    i = 0;
                    str = "中心";
                } else if (view.equals(QuickPositionPanel.this.cNy)) {
                    i = 1;
                    str = "左";
                } else if (view.equals(QuickPositionPanel.this.cNz)) {
                    i = 2;
                    str = "右";
                } else if (view.equals(QuickPositionPanel.this.cNA)) {
                    i = 3;
                    str = "左上";
                } else if (view.equals(QuickPositionPanel.this.cNB)) {
                    i = 4;
                    str = "右上";
                } else if (view.equals(QuickPositionPanel.this.cNC)) {
                    i = 5;
                    str = "左下";
                } else if (view.equals(QuickPositionPanel.this.cND)) {
                    i = 6;
                    str = "右下";
                } else if (view.equals(QuickPositionPanel.this.cNE)) {
                    i = 7;
                    str = "上";
                } else if (view.equals(QuickPositionPanel.this.cNF)) {
                    i = 8;
                    str = "下";
                } else {
                    str = str2;
                    i = -1;
                }
                C6031g.m17111bh(view.getContext(), str);
                if (QuickPositionPanel.this.cNG != null) {
                    QuickPositionPanel.this.cNG.mo28385mk(i);
                }
            }
        };
        m17731Oj();
    }

    /* renamed from: Oj */
    private void m17731Oj() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.editor_layout_text_quick_position, this, true);
        this.cNx = inflate.findViewById(R.id.center);
        this.cNy = inflate.findViewById(R.id.center_left);
        this.cNz = inflate.findViewById(R.id.center_right);
        this.cNA = inflate.findViewById(R.id.top_left);
        this.cNB = inflate.findViewById(R.id.top_right);
        this.cNC = inflate.findViewById(R.id.bottom_left);
        this.cND = inflate.findViewById(R.id.bottom_right);
        this.cNE = inflate.findViewById(R.id.center_top);
        this.cNF = inflate.findViewById(R.id.center_bottom);
        this.cNx.setOnClickListener(this.f3502po);
        this.cNy.setOnClickListener(this.f3502po);
        this.cNz.setOnClickListener(this.f3502po);
        this.cNA.setOnClickListener(this.f3502po);
        this.cNB.setOnClickListener(this.f3502po);
        this.cNC.setOnClickListener(this.f3502po);
        this.cND.setOnClickListener(this.f3502po);
        this.cNE.setOnClickListener(this.f3502po);
        this.cNF.setOnClickListener(this.f3502po);
    }

    public void setPanelClickListener(C6193a aVar) {
        this.cNG = aVar;
    }
}
