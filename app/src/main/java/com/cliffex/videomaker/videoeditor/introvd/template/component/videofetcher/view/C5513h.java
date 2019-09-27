package com.introvd.template.component.videofetcher.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.TextView;
import com.introvd.template.component.videofetcher.R;

/* renamed from: com.introvd.template.component.videofetcher.view.h */
public class C5513h extends Dialog {
    /* access modifiers changed from: private */
    public C5515a cnl;

    /* renamed from: com.introvd.template.component.videofetcher.view.h$a */
    public interface C5515a {
        void aao();
    }

    public C5513h(Context context) {
        super(context, R.style.fetcher_share_dialog);
    }

    private void aaG() {
        Window window = getWindow();
        LayoutParams attributes = window.getAttributes();
        window.getDecorView().setPadding(0, 0, 0, 0);
        attributes.gravity = 17;
        attributes.width = -1;
        attributes.height = -2;
        window.setAttributes(attributes);
    }

    /* renamed from: a */
    public void mo27229a(C5515a aVar) {
        this.cnl = aVar;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.fetcher_dialog_share_v2);
        aaG();
        setCanceledOnTouchOutside(true);
        ((TextView) findViewById(R.id.share_dialog_tv_share_v2)).setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (C5513h.this.cnl != null) {
                    C5513h.this.cnl.aao();
                }
            }
        });
    }
}
