package com.introvd.template.editor.fast.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.introvd.template.editor.R;
import com.p131c.p132a.p133a.C2564c;
import com.p131c.p132a.p135c.p136a.C2579b;
import com.p131c.p132a.p135c.p136a.C2579b.C2582a;

public class FastToolItemView extends RelativeLayout {
    TextView bAk;
    ImageView cRH;
    RelativeLayout cRI;
    RelativeLayout cRJ;
    /* access modifiers changed from: private */
    public C6292a cRK;
    /* access modifiers changed from: private */
    public int mode;

    public FastToolItemView(Context context) {
        this(context, null);
    }

    public FastToolItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FastToolItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.editor_fast_edit_tool_item_layout, this, true);
        this.cRI = (RelativeLayout) findViewById(R.id.cover_layout);
        this.cRJ = (RelativeLayout) findViewById(R.id.content_layout);
        this.cRH = (ImageView) findViewById(R.id.tool_icon);
        this.bAk = (TextView) findViewById(R.id.tool_title);
        C2579b.m7399a(new C2582a<View>() {
            public void onClick(View view) {
                C2564c.show(FastToolItemView.this.cRH);
                if (FastToolItemView.this.cRK != null) {
                    FastToolItemView.this.cRK.mo29221nu(FastToolItemView.this.mode);
                }
            }
        }, this);
    }

    public void setItemData(int i, boolean z, int i2, String str) {
        this.mode = i;
        this.cRH.setImageResource(i2);
        LayoutParams layoutParams = (LayoutParams) this.bAk.getLayoutParams();
        LayoutParams layoutParams2 = (LayoutParams) this.cRJ.getLayoutParams();
        LayoutParams layoutParams3 = (LayoutParams) this.cRH.getLayoutParams();
        if (z) {
            layoutParams2.width = -2;
            layoutParams2.height = -2;
            layoutParams3.width = -2;
            layoutParams3.height = -2;
            layoutParams3.addRule(12, 0);
            layoutParams3.addRule(14, 0);
            layoutParams3.addRule(13);
            layoutParams.width = -2;
            layoutParams.height = -2;
            if (i == -1) {
                this.cRI.setBackgroundResource(0);
            } else {
                this.cRI.setBackgroundResource(R.drawable.editor_shape_fast_more_item_bg);
            }
        } else {
            layoutParams2.width = -1;
            layoutParams2.height = -2;
            layoutParams3.width = -2;
            layoutParams3.height = -2;
            layoutParams3.addRule(13, 0);
            layoutParams3.addRule(12);
            layoutParams3.addRule(14);
            layoutParams.width = -1;
            layoutParams.height = -2;
            this.cRI.setBackgroundResource(0);
        }
        this.cRJ.setLayoutParams(layoutParams2);
        this.cRH.setLayoutParams(layoutParams3);
        if (TextUtils.isEmpty(str)) {
            this.bAk.setVisibility(8);
            return;
        }
        this.bAk.setText(str);
        layoutParams.addRule(14);
        this.bAk.setLayoutParams(layoutParams);
    }

    public void setListener(C6292a aVar) {
        this.cRK = aVar;
    }
}
