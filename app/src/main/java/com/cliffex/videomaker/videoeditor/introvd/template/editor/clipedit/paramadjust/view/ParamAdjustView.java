package com.introvd.template.editor.clipedit.paramadjust.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import com.introvd.template.editor.R;
import com.introvd.template.editor.clipedit.paramadjust.view.ParamAdjustBar.C5717a;

public class ParamAdjustView extends RelativeLayout {
    private int cAa;
    /* access modifiers changed from: private */
    public ParamAdjustBar cAc;
    private ImageButton cAd;
    /* access modifiers changed from: private */
    public C5720a cAe;
    /* access modifiers changed from: private */
    public int cAf;
    private C5717a cAg;
    private Context mContext;

    /* renamed from: com.introvd.template.editor.clipedit.paramadjust.view.ParamAdjustView$a */
    public interface C5720a {
        /* renamed from: a */
        void mo27936a(ParamAdjustView paramAdjustView, int i, boolean z);
    }

    public ParamAdjustView(Context context) {
        this(context, null);
    }

    public ParamAdjustView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ParamAdjustView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cAg = new C5717a() {
            /* renamed from: iD */
            public void mo27944iD(int i) {
                ParamAdjustView.this.m15849lk(i);
                if (ParamAdjustView.this.cAe != null) {
                    ParamAdjustView.this.cAe.mo27936a(ParamAdjustView.this, i, true);
                }
            }

            /* renamed from: lh */
            public void mo27945lh(int i) {
                ParamAdjustView.this.m15849lk(i);
                if (ParamAdjustView.this.cAe != null) {
                    ParamAdjustView.this.cAe.mo27936a(ParamAdjustView.this, i, false);
                }
            }
        };
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ParamAdjustView);
            this.cAa = obtainStyledAttributes.getInteger(R.styleable.ParamAdjustView_referenceFValue, 50);
            this.cAf = this.cAa;
            obtainStyledAttributes.recycle();
        }
        this.mContext = context;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(this.mContext).inflate(R.layout.editor_param_adjust_item_layout, this, true);
        this.cAc = (ParamAdjustBar) findViewById(R.id.param_adjustbar);
        this.cAc.setAdjustBarListener(this.cAg);
        this.cAc.setReferenceF(this.cAa);
        this.cAd = (ImageButton) findViewById(R.id.imgview_icon);
        this.cAd.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (ParamAdjustView.this.cAe != null && ParamAdjustView.this.cAc.getProgress() != ParamAdjustView.this.cAf) {
                    ParamAdjustView.this.mo27948lj(ParamAdjustView.this.cAf);
                    ParamAdjustView.this.cAe.mo27936a(ParamAdjustView.this, ParamAdjustView.this.cAf, false);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: lk */
    public void m15849lk(int i) {
        if (i != this.cAf) {
            this.cAd.setSelected(true);
        } else {
            this.cAd.setSelected(false);
        }
    }

    public int getViewReferenceF() {
        return this.cAa;
    }

    /* renamed from: li */
    public void mo27947li(int i) {
        this.cAd.setImageResource(i);
    }

    /* renamed from: lj */
    public void mo27948lj(int i) {
        m15849lk(i);
        this.cAc.setProgress(i);
        this.cAc.invalidate();
    }

    public void setClipParamAdjustListener(C5720a aVar) {
        this.cAe = aVar;
    }
}
