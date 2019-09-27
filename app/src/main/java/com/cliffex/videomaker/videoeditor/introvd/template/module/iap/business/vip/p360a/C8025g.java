package com.introvd.template.module.iap.business.vip.p360a;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.introvd.template.module.iap.R;

/* renamed from: com.introvd.template.module.iap.business.vip.a.g */
public class C8025g extends Dialog {
    private Context context;
    private TextView dxT;

    public C8025g(Context context2) {
        super(context2, R.style.vivavideo_iap_dialog_com_style);
        this.context = context2;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setCancelable(false);
        View inflate = LayoutInflater.from(this.context).inflate(R.layout.iap_vip_dialog_open_succ_layout, null);
        setContentView(inflate);
        this.dxT = (TextView) inflate.findViewById(R.id.btn_confirm);
        this.dxT.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                C8025g.this.dismiss();
            }
        });
    }
}
