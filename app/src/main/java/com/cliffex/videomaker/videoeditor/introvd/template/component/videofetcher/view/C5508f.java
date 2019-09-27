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

/* renamed from: com.introvd.template.component.videofetcher.view.f */
public class C5508f extends Dialog {
    /* access modifiers changed from: private */
    public C5511a cnj;

    /* renamed from: com.introvd.template.component.videofetcher.view.f$a */
    public interface C5511a {
        void aan();

        void aao();
    }

    public C5508f(Context context) {
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
    public void mo27225a(C5511a aVar) {
        this.cnj = aVar;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.fetcher_dialog_share);
        aaG();
        setCanceledOnTouchOutside(true);
        TextView textView = (TextView) findViewById(R.id.share_dialog_tv_share);
        ((TextView) findViewById(R.id.share_dialog_tv_delete)).setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (C5508f.this.cnj != null) {
                    C5508f.this.cnj.aan();
                }
            }
        });
        textView.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (C5508f.this.cnj != null) {
                    C5508f.this.cnj.aao();
                }
            }
        });
    }
}
