package com.introvd.template.module.p326ad.exit;

import android.app.Dialog;
import android.content.Context;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.introvd.template.module.ad.R;

/* renamed from: com.introvd.template.module.ad.exit.b */
abstract class C7635b extends Dialog {
    private C7637c dMM;

    C7635b(Context context) {
        super(context, R.style.vivavideo_iap_dialog_common_style);
        C76361 r0 = new C7637c(context) {
            /* access modifiers changed from: 0000 */
            public void aAp() {
                C7635b.this.aAp();
            }
        };
        this.dMM = r0;
        setContentView(r0);
        setCancelable(false);
    }

    /* renamed from: a */
    private void m22433a(Window window) {
        window.addFlags(1024);
    }

    /* access modifiers changed from: 0000 */
    public abstract void aAp();

    /* access modifiers changed from: 0000 */
    /* renamed from: ix */
    public void mo32514ix(boolean z) {
        this.dMM.mo32518ix(z);
    }

    public void onBackPressed() {
    }

    public void show() {
        LayoutParams attributes = getWindow().getAttributes();
        attributes.width = -1;
        attributes.height = -1;
        getWindow().setAttributes(attributes);
        super.show();
        m22433a(getWindow());
    }
}
