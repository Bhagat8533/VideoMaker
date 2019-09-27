package com.introvd.template.component.videofetcher.p241ui;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.p021v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.introvd.template.component.videofetcher.R;
import com.introvd.template.component.videofetcher.p239c.C5391a;
import com.introvd.template.component.videofetcher.p240d.C5410g;
import com.introvd.template.component.videofetcher.utils.C5485c;
import com.introvd.template.component.videofetcher.utils.C5489g;
import com.introvd.template.component.videofetcher.view.C5503b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p037b.p050b.C1834l;
import p037b.p050b.p051a.p053b.C1487a;
import p037b.p050b.p057e.C1517e;
import p037b.p050b.p076j.C1820a;
import p503cz.msebera.android.httpclient.HttpStatus;

/* renamed from: com.introvd.template.component.videofetcher.ui.BaseWebFragment */
public abstract class BaseWebFragment extends Fragment implements OnClickListener {
    protected String ahx;
    protected View btV;
    protected ImageView ckB;
    protected WebView ckC;
    protected ArrayList<String> ckD;
    protected ImageView ckE;
    protected String ckF;
    protected String ckG = "";
    protected int ckH = 20;
    /* access modifiers changed from: private */
    public ArrayList<C5391a> ckI;
    /* access modifiers changed from: private */
    public C5503b ckJ;
    protected ProgressBar ckK;
    protected TextView ckL;
    /* access modifiers changed from: private */
    public boolean ckM;

    private void aae() {
        aaf();
        this.ckI = new ArrayList<>();
        ImageView imageView = (ImageView) this.btV.findViewById(R.id.web_back);
        ImageView imageView2 = (ImageView) this.btV.findViewById(R.id.web_home);
        this.ckB = (ImageView) this.btV.findViewById(R.id.web_refresh);
        this.ckE = (ImageView) this.btV.findViewById(R.id.web_iv_download);
        this.ckK = (ProgressBar) this.btV.findViewById(R.id.web_progress_bar);
        this.ckL = (TextView) this.btV.findViewById(R.id.web_top);
        imageView.setOnClickListener(this);
        imageView2.setOnClickListener(this);
        this.ckB.setOnClickListener(this);
        this.ckC = (WebView) this.btV.findViewById(R.id.status_webview);
        this.ckC.setLayerType(2, null);
        WebSettings settings = this.ckC.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        settings.setDisplayZoomControls(false);
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        settings.setAllowContentAccess(false);
        settings.setAllowFileAccessFromFileURLs(false);
        settings.setAllowFileAccess(false);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setDomStorageEnabled(true);
        settings.setAppCacheEnabled(true);
        settings.setCacheMode(-1);
        this.ckC.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView webView, int i) {
                BaseWebFragment.this.mo27057a(webView, i);
                if (i == 100) {
                    BaseWebFragment.this.ckK.setVisibility(8);
                } else if (BaseWebFragment.this.ckK.getVisibility() == 8) {
                    BaseWebFragment.this.ckK.setVisibility(0);
                }
                super.onProgressChanged(webView, i);
            }
        });
        this.ckC.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
                return super.shouldOverrideUrlLoading(webView, webResourceRequest);
            }

            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                return super.shouldOverrideUrlLoading(webView, str);
            }
        });
        mo27064c(this.ckC);
    }

    private void aaf() {
        this.ckD = new ArrayList<>(16);
        this.ckD.add(".mp4");
        this.ckD.add(".mov");
        this.ckD.add(".rmvb");
        this.ckD.add(".rm");
        this.ckD.add(".asf");
        this.ckD.add(".wmv");
        this.ckD.add(".avi");
        this.ckD.add(".swf");
        this.ckD.add(".flv");
        this.ckD.add(".mkv");
        this.ckD.add(".3gp");
        this.ckD.add(".ts");
        this.ckD.add(".mpg");
        this.ckD.add(".mpeg");
        this.ckD.add(".ogv");
        this.ckD.add(".h264");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo27057a(WebView webView, int i);

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo27058a(List<String> list, List<String> list2, String str, boolean z) {
        this.ckM = z;
        if (this.ckI != null && !this.ckI.isEmpty() && z) {
            this.ckI.clear();
        }
        int min = Math.min(list.size(), list2.size());
        for (int i = 0; i < min; i++) {
            C5391a aVar = new C5391a(str, (String) list2.get(i), (String) list.get(i));
            if (!this.ckI.contains(aVar)) {
                this.ckI.add(aVar);
                StringBuilder sb = new StringBuilder();
                sb.append("forMatDownloadList---拦截以后添加--");
                sb.append(list.size());
                C5489g.m14902d("ruomiz", sb.toString());
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean aag() {
        return this.ckI != null && !this.ckI.isEmpty();
    }

    /* access modifiers changed from: protected */
    public void aah() {
        this.ckI.clear();
    }

    public void aai() {
        C1487a.aUa().mo10058o(new Runnable() {
            public void run() {
                if (BaseWebFragment.this.ckE != null) {
                    BaseWebFragment.this.ckE.setSelected(true);
                    BaseWebFragment.this.ckE.clearAnimation();
                    BaseWebFragment.this.ckE.setAnimation(AnimationUtils.loadAnimation(BaseWebFragment.this.getActivity(), R.anim.icon_shake));
                }
            }
        });
    }

    public void aaj() {
        if (this.ckE != null && this.ckE.getAnimation() != null) {
            this.ckE.clearAnimation();
        }
    }

    /* access modifiers changed from: protected */
    @SuppressLint({"CheckResult"})
    /* renamed from: b */
    public void mo27063b(List<String> list, List<String> list2) {
        C1834l.m5257ah(Boolean.valueOf(true)).mo10157d(C1820a.aVi()).mo10152c(C1487a.aUa()).mo10128a((C1517e<? super T>) new C1517e<Boolean>() {
            /* renamed from: d */
            public void accept(Boolean bool) throws Exception {
                if (BaseWebFragment.this.getActivity() != null) {
                    if (BaseWebFragment.this.ckI != null && !BaseWebFragment.this.ckI.isEmpty()) {
                        if (!BaseWebFragment.this.ckM) {
                            BaseWebFragment.this.ckJ = new C5503b(BaseWebFragment.this.getActivity(), BaseWebFragment.this.ckI);
                        } else if (BaseWebFragment.this.ckI.size() > 1) {
                            BaseWebFragment.this.ckJ = new C5503b(BaseWebFragment.this.getActivity(), BaseWebFragment.this.ckI.subList(0, 1));
                        } else {
                            BaseWebFragment.this.ckJ = new C5503b(BaseWebFragment.this.getActivity(), BaseWebFragment.this.ckI);
                        }
                    }
                    BaseWebFragment.this.ckJ.mo27217a(new C5410g() {
                        public void clearAnimation() {
                            BaseWebFragment.this.aaj();
                        }
                    });
                    BaseWebFragment.this.ckJ.show();
                }
            }
        }, (C1517e<? super Throwable>) new C1517e<Throwable>() {
            /* renamed from: m */
            public void accept(Throwable th) throws Exception {
                C5489g.m14902d("ruomiz", th.toString());
            }
        });
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public abstract void mo27064c(WebView webView);

    /* access modifiers changed from: protected */
    @SuppressLint({"CheckResult"})
    /* renamed from: l */
    public void mo27065l(String str, final String str2, final String str3) {
        C1834l.m5257ah(Boolean.valueOf(true)).mo10157d(C1820a.aVi()).mo10152c(C1487a.aUa()).mo10128a((C1517e<? super T>) new C1517e<Boolean>() {
            /* renamed from: d */
            public void accept(Boolean bool) throws Exception {
                if (BaseWebFragment.this.ckI != null && !BaseWebFragment.this.ckI.isEmpty()) {
                    Iterator it = BaseWebFragment.this.ckI.iterator();
                    while (it.hasNext()) {
                        C5391a aVar = (C5391a) it.next();
                        if (aVar.getName().equals(str2) && TextUtils.isEmpty(aVar.mo26976ZN())) {
                            aVar.mo26984fz(str3);
                            StringBuilder sb = new StringBuilder();
                            sb.append("获取到了");
                            sb.append(str2);
                            sb.append("文件的大小--size");
                            sb.append(str3);
                            C5489g.m14902d("ruomiz", sb.toString());
                        }
                    }
                    if (BaseWebFragment.this.ckJ != null && BaseWebFragment.this.ckJ.isShowing()) {
                        BaseWebFragment.this.ckJ.mo27218e(BaseWebFragment.this.ckI);
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("mDownloadDialog--刷新一下dialog--");
                        sb2.append(BaseWebFragment.this.ckI.size());
                        C5489g.m14902d("ruomiz", sb2.toString());
                    }
                }
            }
        }, (C1517e<? super Throwable>) new C1517e<Throwable>() {
            /* renamed from: m */
            public void accept(Throwable th) throws Exception {
                C5489g.m14902d("ruomiz", th.toString());
            }
        });
    }

    public void onClick(View view) {
        if (!C5485c.m14891bM(HttpStatus.SC_INTERNAL_SERVER_ERROR, view.hashCode())) {
            if (view.getId() == R.id.web_back && !isHidden()) {
                aaj();
                if (this.ckC.canGoBack()) {
                    this.ckC.goBack();
                } else if (getParentFragment() != null) {
                    C5489g.m14902d("ruomiz", "web_back");
                    getParentFragment().getChildFragmentManager().beginTransaction().hide(this).commit();
                }
            }
            if (view.getId() == R.id.web_home && !isHidden()) {
                aaj();
                if (getParentFragment() != null) {
                    C5489g.m14902d("ruomiz", "webhome");
                    getParentFragment().getChildFragmentManager().beginTransaction().hide(this).commit();
                }
            }
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.btV == null) {
            this.btV = layoutInflater.inflate(R.layout.fetcher_frag_webview_commom, viewGroup, false);
        }
        aae();
        return this.btV;
    }

    public void onHiddenChanged(boolean z) {
        C5489g.m14902d("ruomiz", "basewebfragment ---onHiddenChanged");
        super.onHiddenChanged(z);
        if (z) {
            aaj();
            if (this.ckC != null) {
                this.ckC.onPause();
            }
        } else if (this.ckC != null) {
            this.ckC.onResume();
        }
    }

    public void onPause() {
        super.onPause();
        if (this.ckC != null) {
            this.ckC.onPause();
        }
    }

    public void onResume() {
        super.onResume();
        if (!isHidden() && this.ckC != null) {
            this.ckC.onResume();
        }
    }
}
