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
import com.introvd.template.component.videofetcher.p240d.C5406d;
import com.introvd.template.component.videofetcher.p240d.C5406d.C5407a;
import com.introvd.template.component.videofetcher.utils.C5485c;
import com.introvd.template.component.videofetcher.utils.C5488f;
import com.introvd.template.component.videofetcher.utils.C5489g;
import com.introvd.template.plugin.downloader.C8251a;
import java.util.ArrayList;
import java.util.Iterator;
import p037b.p050b.p054b.C1495b;
import p037b.p050b.p057e.C1517e;
import p037b.p050b.p076j.C1820a;

/* renamed from: com.introvd.template.component.videofetcher.ui.WebLiveLeakFragment */
public class WebLiveLeakFragment extends BaseWebFragment {
    /* access modifiers changed from: private */
    public String ckG = "";
    protected ArrayList<String> clY;
    protected ArrayList<String> clZ;
    private C1495b cma;
    private String mUrl;

    @SuppressLint({"CheckResult"})
    /* renamed from: af */
    private void m14849af(final String str, final String str2) {
        C5489g.m14902d("ruomiz", "LIVELEAK获取下载-getVideoSize--");
        C8251a.m23820gI(getContext()).mo33408mH(str).mo10128a((C1517e<? super T>) new C1517e<Long>() {
            /* renamed from: i */
            public void accept(Long l) throws Exception {
                WebLiveLeakFragment.this.mo27065l(str, str2, C5488f.m14898as(l.longValue()));
                StringBuilder sb = new StringBuilder();
                sb.append("LIVELEAK获取下载-getVideoSize--");
                sb.append(str2);
                C5489g.m14902d("ruomiz", sb.toString());
            }
        }, (C1517e<? super Throwable>) new C1517e<Throwable>() {
            /* renamed from: m */
            public void accept(Throwable th) throws Exception {
                C5489g.m14902d("ruomiz", th.toString());
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: ah */
    public void m14850ah(final String str, final String str2) {
        this.cma = C1820a.aVi().mo10058o(new Runnable() {
            public void run() {
                if (!TextUtils.isEmpty(str) && WebLiveLeakFragment.this.ckD != null && !WebLiveLeakFragment.this.ckD.isEmpty()) {
                    Iterator it = WebLiveLeakFragment.this.ckD.iterator();
                    while (it.hasNext()) {
                        if (str.contains((String) it.next())) {
                            WebLiveLeakFragment.this.m14851ai(str, str2);
                            return;
                        }
                    }
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: ai */
    public void m14851ai(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append("formatResource--liveleak--");
        sb.append(str);
        C5489g.m14902d("ruomiz", sb.toString());
        Iterator it = this.ckD.iterator();
        while (it.hasNext()) {
            String str3 = (String) it.next();
            if (str.contains(str3)) {
                m14854m(str, str3, str2);
                return;
            }
        }
    }

    /* renamed from: fK */
    public static WebLiveLeakFragment m14853fK(String str) {
        Bundle bundle = new Bundle();
        WebLiveLeakFragment webLiveLeakFragment = new WebLiveLeakFragment();
        bundle.putString("liveLeak", str);
        webLiveLeakFragment.setArguments(bundle);
        return webLiveLeakFragment;
    }

    /* renamed from: m */
    private void m14854m(String str, String str2, String str3) {
        this.ckF = str;
        this.ahx = C5485c.replaceAll(str3);
        StringBuilder sb = new StringBuilder();
        sb.append("LIVELEAK可以下载的视频名称--replaceAll-");
        sb.append(this.ahx);
        C5489g.m14902d("ruomiz", sb.toString());
        if (this.ahx.endsWith("-")) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.ahx);
            sb2.append("video");
            sb2.append(str2);
            this.ahx = String.valueOf(sb2);
        } else {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(this.ahx);
            stringBuffer.append(str2);
            this.ahx = String.valueOf(stringBuffer);
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append("LIVELEAK可以下载的视频名称---");
        sb3.append(this.ahx);
        C5489g.m14902d("ruomiz", sb3.toString());
        if (!this.clY.contains(this.ckF) && !this.clZ.contains(this.ahx)) {
            this.clY.add(this.ckF);
            this.clZ.add(this.ahx);
            aai();
            mo27058a(this.clZ, this.clY, "Video_Downloader_videoLeak_Download", false);
            m14849af(this.ckF, this.ahx);
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
            if (this.clY != null && !this.clY.isEmpty()) {
                this.clY.clear();
            }
            if (this.clZ != null && !this.clZ.isEmpty()) {
                this.clZ.clear();
            }
            if (aag()) {
                aah();
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo27064c(final WebView webView) {
        this.clY = new ArrayList<>(4);
        this.clZ = new ArrayList<>(4);
        if (getArguments() != null) {
            this.mUrl = getArguments().getString("liveLeak");
            webView.setWebViewClient(new WebViewClient() {
                public void onLoadResource(WebView webView, String str) {
                    WebLiveLeakFragment.this.m14850ah(str, webView.getTitle());
                    super.onLoadResource(webView, str);
                }

                public void onPageFinished(WebView webView, String str) {
                    super.onPageFinished(webView, str);
                    StringBuilder sb = new StringBuilder();
                    sb.append("liveleak--onPageFinished----");
                    sb.append(str);
                    Log.e("ruomiz", sb.toString());
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
                    sb.append("liveleak--mCurrentUrl--");
                    sb.append(WebLiveLeakFragment.this.ckG);
                    C5489g.m14902d("ruomiz", sb.toString());
                    webView.loadUrl(WebLiveLeakFragment.this.ckG);
                }
            });
            this.ckE.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    if (WebLiveLeakFragment.this.clZ == null || WebLiveLeakFragment.this.clY == null || WebLiveLeakFragment.this.clZ.isEmpty() || WebLiveLeakFragment.this.clY.isEmpty()) {
                        Toast.makeText(WebLiveLeakFragment.this.getActivity(), "暂无发现视频源", 0).show();
                    } else {
                        WebLiveLeakFragment.this.mo27063b(WebLiveLeakFragment.this.clZ, WebLiveLeakFragment.this.clY);
                    }
                }
            });
            this.ckL.setOnTouchListener(new C5406d(new C5407a() {
                public void aad() {
                    if (WebLiveLeakFragment.this.ckC != null) {
                        WebLiveLeakFragment.this.ckC.scrollTo(0, 0);
                    }
                }
            }));
        }
    }

    public boolean canGoBack() {
        return this.ckC != null && this.ckC.canGoBack();
    }

    /* renamed from: dE */
    public void mo27143dE(boolean z) {
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
        }
        super.onDestroy();
    }
}
