package com.introvd.template.editor.preview.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.introvd.template.editor.R;
import com.introvd.template.editor.preview.C6549b;

public class PreviewTabView extends LinearLayout {
    TextView bAk;
    ImageView bJg;
    private int tabType;

    public PreviewTabView(Context context) {
        this(context, null);
    }

    public PreviewTabView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PreviewTabView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.editor_preview_tab_item_layout, this, true);
        this.bJg = (ImageView) inflate.findViewById(R.id.tab_iv);
        this.bAk = (TextView) inflate.findViewById(R.id.tab_tv);
    }

    public View getShownIcon() {
        if (this.bJg.isShown()) {
            return this.bJg;
        }
        return null;
    }

    /* renamed from: oS */
    public void mo30091oS(int i) {
        this.tabType = i;
        this.bJg.setImageResource(C6549b.m18995V(i, false));
        this.bJg.setVisibility(0);
        this.bAk.setText(C6549b.m18996Y(getContext(), i));
    }

    public void setStatus(boolean z) {
        this.bJg.setImageResource(C6549b.m18995V(this.tabType, z));
        this.bAk.setTextColor(z ? getResources().getColor(R.color.color_ff5e13) : getResources().getColor(R.color.color_8E8E93));
    }
}
