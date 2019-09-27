package com.introvd.template.p414ui.dialog;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import xiaoying.quvideo.com.vivabase.C10122R;

/* renamed from: com.introvd.template.ui.dialog.a */
public class C8943a extends C8959f implements OnClickListener {

    /* renamed from: PM */
    protected View f3621PM;
    protected MDRootLayout crf = ((MDRootLayout) this.view.findViewById(C10122R.C10124id.md_root_layout));
    private RelativeLayout erw = ((RelativeLayout) this.view.findViewById(C10122R.C10124id.content_layout));
    private View view;

    public C8943a(Context context) {
        super(context, C10122R.style.xiaoying_style_com_dialog);
        this.view = LayoutInflater.from(context).inflate(C10122R.C10126layout.xiaoying_com_dialog_custom, null);
        setContentView(this.view);
    }

    public C8943a(Context context, int i) {
        super(context, i);
        this.view = LayoutInflater.from(context).inflate(C10122R.C10126layout.xiaoying_com_dialog_custom, null);
        if (i == C10122R.style.xiaoying_style_edit_dialog) {
            LayoutParams layoutParams = new LayoutParams(-1, -2);
            layoutParams.setMargins(0, 0, 0, 0);
            this.erw.setLayoutParams(layoutParams);
        }
        setContentView(this.view);
    }

    /* renamed from: Q */
    public void mo31986Q(Object obj) {
        if (obj instanceof Integer) {
            this.ewN.title = this.ewN.context.getText(((Integer) obj).intValue());
        } else if (obj instanceof String) {
            this.ewN.title = (CharSequence) obj;
        }
    }

    /* renamed from: dR */
    public void mo35594dR(int i, int i2) {
        this.ewN.amB = this.ewN.context.getText(i);
        this.ewN.amz = this.ewN.context.getText(i2);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        mo35609a(this.crf);
    }

    public void setButtonText(int i) {
        this.ewN.amz = this.ewN.context.getText(i);
        if (this.ewO != null && !TextUtils.isEmpty(this.ewN.amz)) {
            this.ewO.setText(this.ewN.amz);
        }
    }
}
