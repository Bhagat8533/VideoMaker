package com.introvd.template.component.videofetcher.view;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.support.p024v7.app.C0839a;
import android.support.p024v7.app.C0839a.C0840a;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.introvd.template.component.videofetcher.R;

/* renamed from: com.introvd.template.component.videofetcher.view.i */
public class C5516i {
    private OnCancelListener ani;
    private TextView bkw;
    /* access modifiers changed from: private */
    public C0839a cnq;
    private View cnr;
    private TextView cns;
    private TextView cnt;
    private TextView cnu;
    private boolean cnv = false;
    private Context context = null;
    private TextView titleView;

    /* renamed from: to */
    private boolean f3466to = true;

    /* renamed from: tp */
    private boolean f3467tp = true;

    public C5516i(Context context2) {
        this.context = context2;
        m14949dp(context2);
    }

    /* renamed from: dp */
    private void m14949dp(Context context2) {
        this.cnr = LayoutInflater.from(context2).inflate(R.layout.xiaoying_alert_dialog_v7, null);
        this.titleView = (TextView) this.cnr.findViewById(R.id.xiaoying_alert_dialog_title);
        this.bkw = (TextView) this.cnr.findViewById(R.id.xiaoying_alert_dialog_content);
        this.cns = (TextView) this.cnr.findViewById(R.id.xiaoying_alert_dialog_neutral);
        this.cnt = (TextView) this.cnr.findViewById(R.id.xiaoying_alert_dialog_positive);
        this.cnu = (TextView) this.cnr.findViewById(R.id.xiaoying_alert_dialog_negative);
        this.titleView.setVisibility(8);
        this.bkw.setVisibility(8);
        this.cns.setVisibility(8);
        this.cnt.setVisibility(8);
        this.cnu.setVisibility(8);
    }

    /* renamed from: a */
    public C5516i mo27232a(int i, final OnClickListener onClickListener) {
        if (this.cnt != null) {
            this.cnt.setVisibility(0);
            this.cnt.setText(i);
            this.cnt.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    if (C5516i.this.cnq != null) {
                        C5516i.this.cnq.dismiss();
                    }
                    if (onClickListener != null) {
                        onClickListener.onClick(view);
                    }
                }
            });
        }
        return this;
    }

    /* renamed from: b */
    public C5516i mo27233b(int i, final OnClickListener onClickListener) {
        if (this.cnu != null) {
            this.cnu.setVisibility(0);
            this.cnu.setText(i);
            this.cnu.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    if (C5516i.this.cnq != null) {
                        C5516i.this.cnq.dismiss();
                    }
                    if (onClickListener != null) {
                        onClickListener.onClick(view);
                    }
                }
            });
        }
        return this;
    }

    public void dismiss() {
        if (this.cnq != null) {
            this.cnq.dismiss();
        }
    }

    /* renamed from: ki */
    public C5516i mo27235ki(int i) {
        if (this.bkw != null) {
            this.bkw.setVisibility(0);
            this.bkw.setText(i);
        }
        return this;
    }

    public void show() {
        if (this.context != null) {
            if (this.cnq == null) {
                this.cnq = new C0840a(this.context).mo6522ae(this.cnr).mo6526gk();
            }
            this.cnq.setCancelable(this.f3466to);
            if (this.cnv) {
                this.cnq.setCanceledOnTouchOutside(this.f3467tp);
            }
            if (this.ani != null) {
                this.cnq.setOnCancelListener(this.ani);
            }
            try {
                this.cnq.show();
            } catch (Exception unused) {
            }
        }
    }
}
