package com.introvd.template.editor.export;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.introvd.template.editor.R;
import com.introvd.template.p203b.C4580b;

/* renamed from: com.introvd.template.editor.export.k */
public class C6257k extends Dialog implements OnClickListener {
    private FrameLayout bHZ = null;
    private ImageView bIa = null;
    private int bIe = 0;
    WebView bhN;
    private String mUrl;
    TextView titleView;

    public C6257k(Context context, String str) {
        super(context, R.style.xiaoying_style_com_dialog);
        requestWindowFeature(1);
        this.mUrl = str;
    }

    public void onClick(View view) {
        super.dismiss();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.v4_xiaoying_com_webview_layout);
        if (getWindow() != null) {
            getWindow().setLayout(-1, -1);
        }
        this.titleView = (TextView) findViewById(R.id.text_title);
        this.bhN = new WebView(getContext().getApplicationContext());
        this.bhN.setId(R.id.webview);
        this.bHZ = (FrameLayout) findViewById(R.id.webview_container);
        this.bhN = new WebView(getContext().getApplicationContext());
        this.bHZ.addView(this.bhN, new LayoutParams(-1, -1));
        this.bhN.getSettings().setCacheMode(2);
        this.bhN.setWebChromeClient(new WebChromeClient() {
            public void onReceivedTitle(WebView webView, String str) {
                super.onReceivedTitle(webView, str);
                if (C4580b.m11661eG(str)) {
                    C6257k.this.titleView.setText(str);
                }
            }
        });
        this.bhN.loadUrl(this.mUrl);
        this.bhN.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                webView.loadUrl(str);
                return false;
            }
        });
        this.bhN.getSettings().setJavaScriptEnabled(true);
        this.bIa = (ImageView) findViewById(R.id.back_btn);
        this.bIa.setOnClickListener(this);
        ((ImageView) findViewById(R.id.btn_share)).setVisibility(8);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 0 || this.bhN == null || !this.bhN.canGoBack() || this.bIe >= 2) {
            return super.onKeyDown(i, keyEvent);
        }
        this.bIe++;
        this.bhN.goBack();
        return true;
    }

    public void release() {
        if (this.bhN != null && this.bHZ != null) {
            this.bHZ.removeAllViews();
            this.bhN.setVisibility(8);
            this.bhN.removeAllViews();
            this.bhN.destroy();
            this.bhN = null;
            this.bHZ = null;
        }
    }

    public void show() {
        this.bIe = 0;
        super.show();
    }
}
