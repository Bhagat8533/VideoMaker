package com.introvd.template.component.videofetcher.p241ui;

import android.annotation.SuppressLint;
import android.net.http.SslError;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;
import com.introvd.template.component.videofetcher.C5402d;
import com.introvd.template.component.videofetcher.p240d.C5406d;
import com.introvd.template.component.videofetcher.p240d.C5406d.C5407a;
import com.introvd.template.component.videofetcher.utils.C5488f;
import com.introvd.template.component.videofetcher.utils.C5489g;
import com.introvd.template.plugin.downloader.C8251a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import p037b.p050b.p054b.C1495b;
import p037b.p050b.p057e.C1517e;
import p037b.p050b.p076j.C1820a;

/* renamed from: com.introvd.template.component.videofetcher.ui.WebInstagramFragment */
public class WebInstagramFragment extends BaseWebFragment {
    private C1495b cma;
    protected List<String> cmf;
    protected List<String> cmg;
    private String mUrl;

    private void aaz() {
        if (getActivity() != null) {
            C5402d.m14716ZG().mo27029a(getActivity().getApplicationContext(), "Video_Downloader_Ins_Dectected", new HashMap());
        }
    }

    /* renamed from: ae */
    private void m14835ae(String str, String str2) {
        if (str.contains("/")) {
            this.ahx = str.substring(str.lastIndexOf("/") + 1, str.length());
        }
        if (!this.cmf.contains(str) && !this.cmg.contains(this.ahx)) {
            this.cmf.add(str);
            this.cmg.add(this.ahx);
            StringBuilder sb = new StringBuilder();
            sb.append("instagarm资源名称---chooseVideoResource--mPrefix--");
            sb.append(this.ahx);
            Log.e("ruomiz", sb.toString());
            aai();
            mo27058a(this.cmg, this.cmf, "Video_Downloader_Ins_Download", true);
            m14836af(str, this.ahx);
            aaz();
        }
    }

    @SuppressLint({"CheckResult"})
    /* renamed from: af */
    private void m14836af(final String str, final String str2) {
        C8251a.m23820gI(getContext()).mo33408mH(str).mo10128a((C1517e<? super T>) new C1517e<Long>() {
            /* renamed from: i */
            public void accept(Long l) throws Exception {
                String as = C5488f.m14898as(l.longValue());
                StringBuilder sb = new StringBuilder();
                sb.append("instagarmgetVideoSize--视频大小--");
                sb.append(as);
                Log.e("ruomiz", sb.toString());
                WebInstagramFragment.this.mo27065l(str, str2, as);
            }
        }, (C1517e<? super Throwable>) new C1517e<Throwable>() {
            /* renamed from: m */
            public void accept(Throwable th) throws Exception {
                C5489g.m14902d("ruomiz", th.toString());
            }
        });
    }

    /* renamed from: ag */
    private void m14837ag(String str, String str2) {
        this.ckF = str;
        if (!TextUtils.isEmpty(str)) {
            String str3 = str.split(str2)[0];
            if (!TextUtils.isEmpty(str3) && this.cmf != null && this.cmg != null) {
                if (str3.contains("/")) {
                    int lastIndexOf = str3.lastIndexOf("/");
                    StringBuilder sb = new StringBuilder();
                    sb.append(str3.substring(lastIndexOf + 1, str3.length()));
                    sb.append(str2);
                    this.ahx = sb.toString();
                }
                if (!this.cmf.contains(this.ckF) && !this.cmg.contains(this.ahx)) {
                    this.cmf.add(this.ckF);
                    this.cmg.add(this.ahx);
                    aai();
                    mo27058a(this.cmg, this.cmf, "Video_Downloader_Ins_Download", true);
                    m14836af(this.ckF, this.ahx);
                    aaz();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: fH */
    public void m14839fH(final String str) {
        this.cma = C1820a.aVi().mo10058o(new Runnable() {
            public void run() {
                if (!TextUtils.isEmpty(str) && WebInstagramFragment.this.ckD != null && !WebInstagramFragment.this.ckD.isEmpty()) {
                    Iterator it = WebInstagramFragment.this.ckD.iterator();
                    while (it.hasNext()) {
                        if (str.contains((String) it.next())) {
                            WebInstagramFragment.this.m14841fJ(str);
                            return;
                        }
                    }
                }
            }
        });
    }

    /* renamed from: fI */
    public static WebInstagramFragment m14840fI(String str) {
        Bundle bundle = new Bundle();
        WebInstagramFragment webInstagramFragment = new WebInstagramFragment();
        bundle.putString("Instagram", str);
        webInstagramFragment.setArguments(bundle);
        return webInstagramFragment;
    }

    /* access modifiers changed from: private */
    /* renamed from: fJ */
    public void m14841fJ(String str) {
        if (this.cmf != null && !this.cmf.isEmpty()) {
            this.cmf.clear();
        }
        if (this.cmg != null && !this.cmg.isEmpty()) {
            this.cmg.clear();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("formatResource--");
        sb.append(str);
        C5489g.m14902d("ruomiz", sb.toString());
        Iterator it = this.ckD.iterator();
        while (it.hasNext()) {
            String str2 = (String) it.next();
            if (str.endsWith(str2)) {
                m14835ae(str, str2);
                return;
            } else if (str.contains(str2)) {
                m14837ag(str, str2);
                return;
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo27057a(WebView webView, int i) {
        if (i < this.ckH) {
            aaj();
            if (!(webView == null || webView.getUrl() == null || this.ckG.equals(webView.getUrl()))) {
                this.ckG = webView.getUrl();
            }
            if (this.ckE.isSelected()) {
                this.ckE.setSelected(false);
            }
            if (this.cmf != null && !this.cmf.isEmpty()) {
                this.cmf.clear();
            }
            if (this.cmg != null && !this.cmg.isEmpty()) {
                this.cmg.clear();
            }
            if (aag()) {
                aah();
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("instagram--onCahengedProgress--");
        sb.append(i);
        C5489g.m14902d("ruomiz", sb.toString());
    }

    /* access modifiers changed from: protected */
    @SuppressLint({"ClickableViewAccessibility"})
    /* renamed from: c */
    public void mo27064c(final WebView webView) {
        this.cmf = new ArrayList(1);
        this.cmg = new ArrayList(1);
        if (getArguments() != null) {
            this.mUrl = getArguments().getString("Instagram");
            webView.setWebViewClient(new WebViewClient() {
                public void onLoadResource(WebView webView, String str) {
                    WebInstagramFragment.this.m14839fH(str);
                    super.onLoadResource(webView, str);
                }

                public void onPageFinished(WebView webView, String str) {
                    super.onPageFinished(webView, str);
                    StringBuilder sb = new StringBuilder();
                    sb.append("instagram--onPageFinished--");
                    sb.append(str);
                    C5489g.m14902d("ruomiz", sb.toString());
                }

                public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                    sslErrorHandler.cancel();
                }

                public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                    webView.loadUrl(str);
                    return true;
                }
            });
            webView.loadUrl(this.mUrl);
            this.ckB.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("instagram--mCurrentUrl--");
                    sb.append(WebInstagramFragment.this.ckG);
                    C5489g.m14902d("ruomiz", sb.toString());
                    webView.loadUrl(WebInstagramFragment.this.ckG);
                }
            });
            this.ckE.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    if (WebInstagramFragment.this.cmg == null || WebInstagramFragment.this.cmf == null || WebInstagramFragment.this.cmg.isEmpty() || WebInstagramFragment.this.cmf.isEmpty()) {
                        Toast.makeText(WebInstagramFragment.this.getActivity(), "暂无发现视频源", 0).show();
                    } else {
                        WebInstagramFragment.this.mo27063b(WebInstagramFragment.this.cmg, WebInstagramFragment.this.cmf);
                    }
                }
            });
            this.ckL.setOnTouchListener(new C5406d(new C5407a() {
                public void aad() {
                    if (WebInstagramFragment.this.ckC != null) {
                        WebInstagramFragment.this.ckC.scrollTo(0, 0);
                    }
                }
            }));
        }
    }

    public boolean canGoBack() {
        StringBuilder sb = new StringBuilder();
        sb.append("mInstagramFragment--canGoBack");
        sb.append(this.ckC.canGoBack());
        C5489g.m14902d("ruomiz", sb.toString());
        return this.ckC != null && this.ckC.canGoBack();
    }

    /* renamed from: dE */
    public void mo27131dE(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("hideWebview");
        sb.append(z);
        C5489g.m14902d("ruomiz", sb.toString());
        if (this.ckC != null) {
            if (z) {
                this.ckC.onPause();
            } else {
                this.ckC.onResume();
            }
        }
    }

    public void goBack() {
        if (this.ckC != null) {
            aaj();
            this.ckC.goBack();
        }
    }

    public void onDestroy() {
        if (this.cma != null && !this.cma.aAy()) {
            this.cma.dispose();
        }
        if (this.ckC != null) {
            ((ViewGroup) this.ckC.getParent()).removeView(this.ckC);
            this.ckC.destroy();
            this.ckC = null;
        }
        super.onDestroy();
    }
}
