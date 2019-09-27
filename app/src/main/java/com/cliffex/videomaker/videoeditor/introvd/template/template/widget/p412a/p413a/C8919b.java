package com.introvd.template.template.widget.p412a.p413a;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.bignerdranch.expandablerecyclerview.C2132a;
import com.introvd.template.template.R;
import com.introvd.template.template.widget.p412a.C8917a;
import com.introvd.template.xyui.RoundCornerImageView;

/* renamed from: com.introvd.template.template.widget.a.a.b */
public class C8919b extends C2132a {
    /* access modifiers changed from: private */
    public C8917a evj;
    private boolean evk;
    private RoundCornerImageView evl;
    private TextView evm;
    private ImageView evn;
    /* access modifiers changed from: private */
    public C8924d evo;

    public C8919b(View view) {
        super(view);
        this.evl = (RoundCornerImageView) view.findViewById(R.id.item_fitler_child_cover);
        this.evm = (TextView) view.findViewById(R.id.item_fitler_child_name);
        this.evn = (ImageView) view.findViewById(R.id.bg_filter_child_selected);
        view.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (C8919b.this.evj != null) {
                    C8919b.this.evj.mo35493a(new C8925e(C8919b.this.mo11775tn(), C8919b.this.mo11776to(), C8919b.this.evo, C8919b.this));
                }
            }
        });
    }

    /* renamed from: a */
    public void mo35504a(C8924d dVar, C8917a aVar, boolean z) {
        this.evo = dVar;
        this.evj = aVar;
        this.evk = z;
        if (dVar.aMK() == null) {
            dVar.mo35518v(this.evj.mo35496bL(dVar.aMI()));
        }
        if (dVar.aMK() != null) {
            this.evl.setImageBitmap(dVar.aMK());
        }
        if ((TextUtils.isEmpty(this.evm.getText()) || !this.evm.getText().toString().equals(dVar.aMJ())) && !TextUtils.isEmpty(dVar.aMJ())) {
            this.evm.setText(dVar.aMJ());
        }
        if (!dVar.isSelected() || !z) {
            this.evn.setVisibility(8);
        } else {
            this.evn.setVisibility(0);
        }
    }

    public void aME() {
        this.evn.setVisibility(8);
    }

    public void aMF() {
        if (this.evk) {
            this.evn.setVisibility(0);
        }
    }
}
