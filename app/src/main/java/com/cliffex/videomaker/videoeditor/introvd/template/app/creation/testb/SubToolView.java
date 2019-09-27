package com.introvd.template.app.creation.testb;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.introvd.template.R;
import com.introvd.template.common.imageloader.ImageLoader;
import com.introvd.template.p203b.C4583d;
import com.p131c.p132a.p133a.C2564c;
import com.p131c.p132a.p135c.p136a.C2579b;
import com.p131c.p132a.p135c.p136a.C2579b.C2582a;

public class SubToolView extends AbstractCreationToolView {
    /* access modifiers changed from: private */
    public C3843b bpQ;
    RelativeLayout bpU;
    ImageView bpV;
    ImageView bpW;
    TextView bpX;
    /* access modifiers changed from: private */
    public C3847d bpg;

    public SubToolView(Context context) {
        this(context, null);
    }

    public SubToolView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SubToolView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* renamed from: a */
    public void mo23319a(C3843b bVar, C3847d dVar) {
        this.bpQ = bVar;
        this.bpg = dVar;
        if (bVar.mo23362KI() > 0) {
            this.bpW.setImageResource(bVar.mo23362KI());
        } else if (!TextUtils.isEmpty(bVar.mo23365KL())) {
            ImageLoader.loadImage(getContext(), bVar.mo23365KL(), this.bpW);
        }
        if (bVar.mo23368Ki() > 0) {
            this.bpV.setImageResource(bVar.mo23368Ki());
        } else if (!TextUtils.isEmpty(bVar.mo23364KK())) {
            ImageLoader.loadImage(getContext(), bVar.mo23364KK(), this.bpV);
        }
        if (!TextUtils.isEmpty(bVar.mo23363KJ())) {
            this.bpX.setText(bVar.mo23363KJ());
        }
    }

    /* renamed from: bF */
    public void mo23340bF(int i, int i2) {
        LayoutParams layoutParams = (LayoutParams) this.bpU.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i;
        this.bpU.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.bpV.getLayoutParams();
        layoutParams2.width = i - C4583d.m11671P(28.0f);
        layoutParams2.height = i - C4583d.m11671P(28.0f);
        layoutParams2.topMargin = C4583d.m11671P(7.0f);
        layoutParams2.addRule(14);
        this.bpV.setLayoutParams(layoutParams2);
        this.bpX.setTextSize(0, (float) i2);
    }

    /* access modifiers changed from: protected */
    public void init() {
        View inflate = LayoutInflater.from(this.context).inflate(R.layout.creation_sub_tool_view_layout, this, true);
        this.bpU = (RelativeLayout) inflate.findViewById(R.id.sub_tool_layout);
        this.bpW = (ImageView) inflate.findViewById(R.id.sub_tool_bg);
        this.bpV = (ImageView) inflate.findViewById(R.id.sub_tool_icon);
        this.bpX = (TextView) inflate.findViewById(R.id.sub_tool_name);
        C2579b.m7399a(new C2582a<View>() {
            public void onClick(View view) {
                C2564c.show(SubToolView.this.bpV);
                if (SubToolView.this.bpg != null) {
                    SubToolView.this.bpg.mo23358c(SubToolView.this.bpQ);
                }
            }
        }, this);
    }
}
