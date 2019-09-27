package com.introvd.template.app.creation.testb;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.introvd.template.R;
import com.introvd.template.common.imageloader.ImageLoader;
import com.introvd.template.p203b.C4583d;
import com.p131c.p132a.p133a.C2564c;
import com.p131c.p132a.p135c.p136a.C2579b;
import com.p131c.p132a.p135c.p136a.C2579b.C2582a;

public class MainToolT2View extends AbstractCreationToolView {
    ImageView bpN;
    ImageView bpO;
    TextView bpP;
    /* access modifiers changed from: private */
    public C3843b bpQ;
    LinearLayout bpS;
    /* access modifiers changed from: private */
    public C3847d bpg;

    public MainToolT2View(Context context) {
        this(context, null);
    }

    public MainToolT2View(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MainToolT2View(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* renamed from: a */
    public void mo23319a(C3843b bVar, C3847d dVar) {
        this.bpQ = bVar;
        this.bpg = dVar;
        LayoutParams layoutParams = new LayoutParams(-1, -2);
        if (bVar.getType() == 3) {
            layoutParams.topMargin = C4583d.m11673ii(6);
        } else if (bVar.getType() == 4) {
            layoutParams.topMargin = C4583d.m11673ii(10);
        }
        this.bpS.setLayoutParams(layoutParams);
        if (bVar.mo23362KI() > 0) {
            this.bpO.setImageResource(bVar.mo23362KI());
        } else if (!TextUtils.isEmpty(bVar.mo23365KL())) {
            ImageLoader.loadImage(getContext(), bVar.mo23365KL(), this.bpO);
        }
        if (bVar.mo23368Ki() > 0) {
            this.bpN.setImageResource(bVar.mo23368Ki());
        } else if (!TextUtils.isEmpty(bVar.mo23364KK())) {
            ImageLoader.loadImage(getContext(), bVar.mo23364KK(), this.bpN);
        }
        if (!TextUtils.isEmpty(bVar.mo23363KJ())) {
            this.bpP.setText(bVar.mo23363KJ());
        }
    }

    /* access modifiers changed from: protected */
    public void init() {
        View inflate = LayoutInflater.from(this.context).inflate(R.layout.creation_main_tool_t2_layout, this, true);
        this.bpS = (LinearLayout) inflate.findViewById(R.id.content_layout);
        this.bpO = (ImageView) inflate.findViewById(R.id.main_tool_bg);
        this.bpN = (ImageView) inflate.findViewById(R.id.main_tool_icon);
        this.bpP = (TextView) inflate.findViewById(R.id.main_tool_name);
        C2579b.m7399a(new C2582a<View>() {
            public void onClick(View view) {
                C2564c.show(MainToolT2View.this.bpN);
                if (MainToolT2View.this.bpg != null) {
                    MainToolT2View.this.bpg.mo23358c(MainToolT2View.this.bpQ);
                }
            }
        }, this);
    }

    /* renamed from: p */
    public void mo23338p(float f, float f2) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getLayoutParams();
        layoutParams.width = (int) f;
        layoutParams.height = (int) f2;
        setLayoutParams(layoutParams);
    }
}
