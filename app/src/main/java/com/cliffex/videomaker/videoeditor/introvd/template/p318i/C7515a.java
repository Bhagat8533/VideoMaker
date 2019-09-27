package com.introvd.template.p318i;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.google.android.exoplayer2.C3119C;
import com.introvd.template.p414ui.dialog.C8959f;
import com.introvd.template.p414ui.dialog.C8966i.C8968a;
import com.introvd.template.p414ui.dialog.MDRootLayout;
import xiaoying.quvideo.com.vivabase.C10122R;

/* renamed from: com.introvd.template.i.a */
public class C7515a extends C8959f {
    protected Typeface anc;
    private boolean ano = false;
    private boolean anp = false;
    private int anq = 100;
    private OnClickListener bDF;
    private ProgressBar bqi;
    private Object cqZ = Integer.valueOf(-1);
    private Object cra = Integer.valueOf(-1);
    private Object crb = Integer.valueOf(-1);
    private Object crd = Integer.valueOf(-1);
    private boolean cre = true;
    private MDRootLayout crf;
    protected TextView crg;
    protected TextView crh;
    private View view;

    public C7515a(Context context, OnClickListener onClickListener) {
        super(context, C10122R.style.xiaoying_style_com_dialog);
        requestWindowFeature(1);
        this.bDF = onClickListener;
        setMax(100);
        this.view = LayoutInflater.from(context).inflate(C10122R.C10126layout.xiaoying_com_dialog_progress, null);
        this.crf = (MDRootLayout) this.view.findViewById(C10122R.C10124id.md_root_layout);
        setContentView(this.view);
    }

    private void aaV() {
        this.bqi = (ProgressBar) this.view.findViewById(16908301);
        if (this.bqi != null) {
            this.bqi.setMax(100);
            if (!this.ano) {
                this.bqi.setProgress(0);
                this.bqi.setMax(this.anq);
                this.crg = (TextView) this.view.findViewById(C10122R.C10124id.label);
                this.crg.setTextColor(this.ewN.amx);
                mo35610b(this.crg, this.anc);
                this.crh = (TextView) this.view.findViewById(C10122R.C10124id.minMax);
                this.crh.setTextColor(this.ewN.amx);
                mo35610b(this.crh, this.ewN.anb);
                if (this.anp) {
                    this.crh.setVisibility(0);
                    TextView textView = this.crh;
                    StringBuilder sb = new StringBuilder();
                    sb.append("0/");
                    sb.append(this.anq);
                    textView.setText(sb.toString());
                    MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.bqi.getLayoutParams();
                    if (VERSION.SDK_INT >= 17) {
                        marginLayoutParams.setMarginStart(0);
                        marginLayoutParams.setMarginEnd(0);
                    } else {
                        marginLayoutParams.leftMargin = 0;
                        marginLayoutParams.rightMargin = 0;
                    }
                } else {
                    this.crh.setVisibility(8);
                }
                this.crg.setText("0%");
            }
        }
    }

    /* renamed from: Q */
    public void mo32301Q(Object obj) {
        if (obj instanceof Integer) {
            this.ewN.title = this.ewN.context.getText(((Integer) obj).intValue());
        } else if (obj instanceof String) {
            this.ewN.title = (String) obj;
        }
    }

    public void onBackPressed() {
        if (this.bDF != null && this.ewO.isEnabled()) {
            this.bDF.onClick(this.ewO);
            dismiss();
        }
    }

    public void onClick(View view2) {
        switch ((C8968a) view2.getTag()) {
            case POSITIVE:
                if (this.bDF != null) {
                    this.bDF.onClick(view2);
                    break;
                }
                break;
            case NEGATIVE:
                if (this.bDF != null) {
                    this.bDF.onClick(view2);
                    break;
                }
                break;
        }
        dismiss();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        mo35609a(this.crf);
        aaV();
        if (this.anc == null) {
            try {
                this.anc = Typeface.create("sans-serif-medium", 0);
            } catch (Throwable unused) {
            }
        }
        if (this.ewN.anb == null) {
            try {
                this.ewN.anb = Typeface.create(C3119C.SANS_SERIF_NAME, 0);
            } catch (Throwable unused2) {
            }
        }
        if (this.anc == null) {
            this.anc = this.ewN.anb;
        }
    }

    public void setButtonText(int i) {
        this.ewN.amz = this.ewN.context.getText(i);
    }

    public final void setMax(int i) {
        this.anq = i;
    }
}
