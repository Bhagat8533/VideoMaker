package com.introvd.template.component.videofetcher.p241ui;

import android.net.http.SslError;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.ConsoleMessage;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.JavascriptInterface;
import android.webkit.JsResult;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings.PluginState;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;
import com.introvd.template.component.videofetcher.C5402d;
import com.introvd.template.component.videofetcher.p240d.C5406d;
import com.introvd.template.component.videofetcher.p240d.C5406d.C5407a;
import com.introvd.template.component.videofetcher.utils.C5488f;
import com.introvd.template.component.videofetcher.utils.C5489g;
import com.introvd.template.datacenter.SocialConstDef;
import com.introvd.template.plugin.downloader.C8251a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import p037b.p050b.C1834l;
import p037b.p050b.p054b.C1495b;
import p037b.p050b.p057e.C1517e;
import p037b.p050b.p076j.C1820a;

/* renamed from: com.introvd.template.component.videofetcher.ui.WebFaceBookFragment */
public class WebFaceBookFragment extends BaseWebFragment {
    protected ArrayList<String> clY;
    protected ArrayList<String> clZ;
    private C1495b cma;
    /* access modifiers changed from: private */
    public int mCount;
    private String mUrl;

    private void aay() {
        if (this.clY != null && !this.clY.isEmpty()) {
            C1834l.m5257ah(Boolean.valueOf(true)).mo10158e(3000, TimeUnit.MILLISECONDS).mo10164f(3000, TimeUnit.MILLISECONDS).mo10128a((C1517e<? super T>) new C1517e<Boolean>() {
                /* renamed from: d */
                public void accept(Boolean bool) throws Exception {
                    if (WebFaceBookFragment.this.mCount != WebFaceBookFragment.this.clY.size()) {
                        WebFaceBookFragment.this.m14821ad(SocialConstDef.SEARCH_HISTORY_COUNT, String.valueOf(WebFaceBookFragment.this.clY.size()));
                        WebFaceBookFragment.this.mCount = WebFaceBookFragment.this.clY.size();
                    }
                }
            }, (C1517e<? super Throwable>) new C1517e<Throwable>() {
                /* renamed from: m */
                public void accept(Throwable th) throws Exception {
                    C5489g.m14902d("ruomiz", th.toString());
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: ad */
    public void m14821ad(String str, String str2) {
        if (getActivity() != null) {
            HashMap hashMap = new HashMap();
            hashMap.put(str, str2);
            C5402d.m14716ZG().mo27029a(getActivity().getApplicationContext(), "Video_Downloader_FB_Dectected", hashMap);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: ae */
    public void m14822ae(String str, String str2) {
        if (str.contains(str2)) {
            String str3 = str.split(str2)[0];
            if (str3.contains("/")) {
                int lastIndexOf = str3.lastIndexOf("/");
                StringBuilder sb = new StringBuilder();
                sb.append(str3.substring(lastIndexOf + 1, str3.length()));
                sb.append(str2);
                this.ahx = sb.toString();
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append(str2);
                this.ahx = sb2.toString();
            }
            this.ckF = str;
            StringBuilder sb3 = new StringBuilder();
            sb3.append("FACKBOOK资源名称---resUrl--");
            sb3.append(this.ahx);
            Log.e("ruomiz", sb3.toString());
            if (!this.clY.contains(this.ckF) && !this.clZ.contains(this.ahx)) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append("FACKBOOK资源名称---add--");
                sb4.append(this.ahx);
                Log.e("ruomiz", sb4.toString());
                if (this.clY != null && !this.clY.isEmpty()) {
                    this.clY.clear();
                }
                if (this.clZ != null && !this.clZ.isEmpty()) {
                    this.clZ.clear();
                }
                this.clY.add(this.ckF);
                this.clZ.add(this.ahx);
                aai();
                mo27058a(this.clZ, this.clY, "Video_Downloader_FB_Download", true);
                m14823af(this.ckF, this.ahx);
                aay();
            }
        }
    }

    /* renamed from: af */
    private void m14823af(final String str, final String str2) {
        C8251a.m23820gI(getContext()).mo33408mH(str).mo10128a((C1517e<? super T>) new C1517e<Long>() {
            /* renamed from: i */
            public void accept(Long l) throws Exception {
                String as = C5488f.m14898as(l.longValue());
                StringBuilder sb = new StringBuilder();
                sb.append("FACKBOOK资源名称---getVideoSize----");
                sb.append(as);
                Log.e("ruomiz", sb.toString());
                WebFaceBookFragment.this.mo27065l(str, str2, as);
            }
        }, (C1517e<? super Throwable>) new C1517e<Throwable>() {
            /* renamed from: m */
            public void accept(Throwable th) throws Exception {
                C5489g.m14902d("ruomiz", th.toString());
            }
        });
    }

    /* renamed from: fG */
    public static WebFaceBookFragment m14825fG(String str) {
        Bundle bundle = new Bundle();
        WebFaceBookFragment webFaceBookFragment = new WebFaceBookFragment();
        bundle.putString("Facebook", str);
        webFaceBookFragment.setArguments(bundle);
        return webFaceBookFragment;
    }

    /* renamed from: fH */
    private void m14826fH(final String str) {
        this.cma = C1820a.aVi().mo10058o(new Runnable() {
            public void run() {
                if (!TextUtils.isEmpty(str)) {
                    WebFaceBookFragment.this.m14822ae(str, ".mp4");
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo27057a(WebView webView, int i) {
        if (i < this.ckH) {
            aaj();
            this.mCount = 0;
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
            this.mUrl = getArguments().getString("Facebook");
            this.ckC.getSettings().setPluginState(PluginState.ON);
            this.ckC.addJavascriptInterface(this, "FBDownloader");
            if (VERSION.SDK_INT >= 17) {
                this.ckC.getSettings().setMediaPlaybackRequiresUserGesture(true);
            }
            CookieManager instance = CookieManager.getInstance();
            if (VERSION.SDK_INT < 21) {
                CookieSyncManager.createInstance(getActivity());
            }
            instance.setAcceptCookie(true);
            webView.setWebViewClient(new WebViewClient() {
                public void onLoadResource(WebView webView, String str) {
                    webView.loadUrl("javascript:(function prepareVideo() {\n    let videos = document.querySelectorAll('video');\n    for (let i = 0; i < videos.length; i++) {\n        let jsonData = {};\n        if (videos[i].parentElement && videos[i].parentElement.dataset.sigil === 'inlineVideo') {\n            jsonData = JSON.parse(videos[i].parentElement.dataset.store);\n        } else {\n            jsonData = {\n                src: videos[i].src,\n                videoID: ''\n            }\n        }\n        videos[i].autoplay = false;\n        videos[i].addEventListener('play', function () {\n            console.log(\"videoplay\");\n            FBDownloader.processVideo(jsonData['src'], jsonData['videoID']);\n        });\n        videos[i].addEventListener('click', function () {\n            console.log(\"videoclick\");\n            FBDownloader.processVideo(jsonData['src'], jsonData['videoID']);\n        });\n    }\n})();");
                    webView.loadUrl("javascript:( window.onload=prepareVideo;)()");
                }

                public void onPageFinished(WebView webView, String str) {
                    webView.loadUrl("javascript:(function prepareVideo() {\n    let videos = document.querySelectorAll('video');\n    for (let i = 0; i < videos.length; i++) {\n        let jsonData = {};\n        if (videos[i].parentElement && videos[i].parentElement.dataset.sigil === 'inlineVideo') {\n            jsonData = JSON.parse(videos[i].parentElement.dataset.store);\n        } else {\n            jsonData = {\n                src: videos[i].src,\n                videoID: ''\n            }\n        }\n        videos[i].autoplay = false;\n        videos[i].addEventListener('play', function () {\n            console.log(\"videoplay\");\n            FBDownloader.processVideo(jsonData['src'], jsonData['videoID']);\n        });\n        videos[i].addEventListener('click', function () {\n            console.log(\"videoclick\");\n            FBDownloader.processVideo(jsonData['src'], jsonData['videoID']);\n        });\n    }\n})();");
                }

                public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                    sslErrorHandler.cancel();
                }

                public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("--facebook--shouldOverrideUrlLoading");
                    sb.append(str);
                    C5489g.m14902d("ruomiz", sb.toString());
                    webView.loadUrl(str);
                    return true;
                }
            });
            webView.setWebChromeClient(new WebChromeClient() {
                public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("liveleak--onConsoleMessage--");
                    sb.append(consoleMessage.message());
                    C5489g.m14902d("ruomiz", sb.toString());
                    return super.onConsoleMessage(consoleMessage);
                }

                public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
                    Toast.makeText(webView.getContext(), str2, 0).show();
                    return super.onJsAlert(webView, str, str2, jsResult);
                }
            });
            webView.loadUrl(this.mUrl);
            this.ckB.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("liveleak--mCurrentUrl--");
                    sb.append(WebFaceBookFragment.this.ckG);
                    C5489g.m14902d("ruomiz", sb.toString());
                    webView.loadUrl(WebFaceBookFragment.this.ckG);
                }
            });
            this.ckE.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    if (WebFaceBookFragment.this.clZ == null || WebFaceBookFragment.this.clZ.isEmpty()) {
                        Toast.makeText(WebFaceBookFragment.this.getActivity(), "暂无发现视频源", 0).show();
                    } else {
                        WebFaceBookFragment.this.mo27063b(WebFaceBookFragment.this.clZ, WebFaceBookFragment.this.clY);
                    }
                }
            });
            this.ckL.setOnTouchListener(new C5406d(new C5407a() {
                public void aad() {
                    if (WebFaceBookFragment.this.ckC != null) {
                        WebFaceBookFragment.this.ckC.scrollTo(0, 0);
                    }
                }
            }));
        }
    }

    public boolean canGoBack() {
        return this.ckC != null && this.ckC.canGoBack();
    }

    /* renamed from: dE */
    public void mo27114dE(boolean z) {
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

    @JavascriptInterface
    public void processVideo(String str, String str2) {
        String str3 = "ruomiz";
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("--facebook--processVideo--URL--");
            sb.append(str);
            C5489g.m14902d(str3, sb.toString());
            m14826fH(str);
        } catch (Exception unused) {
            C5489g.m14902d("ruomiz", "--facebook--processVideo没有发现视频源");
        }
    }
}
