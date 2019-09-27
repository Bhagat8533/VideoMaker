package com.introvd.template.module.iap.business.vip.p360a;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.introvd.template.module.iap.R;

/* renamed from: com.introvd.template.module.iap.business.vip.a.a */
public class C8011a extends Dialog {
    private View cOt;

    public C8011a(Context context) {
        super(context);
        initUI();
        setCancelable(false);
    }

    /* access modifiers changed from: private */
    public void aDV() {
        if (isShowing()) {
            dismiss();
        }
    }

    private void initUI() {
        this.cOt = LayoutInflater.from(getContext()).inflate(R.layout.iap_vip_dialog_gp_version_override, null);
        mo33009e(null);
        mo33010f(null);
        mo33011g(null);
        setContentView(this.cOt);
    }

    /* renamed from: e */
    public void mo33009e(final OnClickListener onClickListener) {
        this.cOt.findViewById(R.id.tv_get_it).setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (onClickListener != null) {
                    onClickListener.onClick(view);
                }
                C8011a.this.aDV();
            }
        });
    }

    /* renamed from: f */
    public void mo33010f(final OnClickListener onClickListener) {
        this.cOt.findViewById(R.id.tv_cancel).setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (onClickListener != null) {
                    onClickListener.onClick(view);
                }
                C8011a.this.aDV();
            }
        });
    }

    /* renamed from: g */
    public void mo33011g(final OnClickListener onClickListener) {
        this.cOt.findViewById(R.id.tv_not_tip_again).setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (onClickListener != null) {
                    onClickListener.onClick(view);
                }
                C8011a.this.aDV();
            }
        });
    }

    public void setContent(String str) {
        ((TextView) findViewById(R.id.tv_content)).setText(str);
    }
}
