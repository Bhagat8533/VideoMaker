package com.introvd.template.app;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.introvd.template.app.p177b.C3742b;
import com.introvd.template.common.AppPreferencesSetting;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.common.UserBehaviorLog;
import com.introvd.template.crash.C5523b;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import lib.C12177i;
import p037b.p050b.C1834l;
import p037b.p050b.p051a.p053b.C1487a;
import p037b.p050b.p057e.C1517e;
import p037b.p050b.p076j.C1820a;

/* renamed from: com.introvd.template.app.a */
public class C3671a {
    /* access modifiers changed from: private */
    public WebView bhN;

    /* renamed from: bx */
    public void mo23022bx(final View view) {
        if (view != null && (view instanceof ViewGroup)) {
            C1834l.m5257ah(Boolean.valueOf(true)).mo10164f(1, TimeUnit.SECONDS).mo10157d(C1487a.aUa()).mo10152c(C1487a.aUa()).mo10161e((C1517e<? super T>) new C1517e<Boolean>() {
                /* renamed from: d */
                public void accept(Boolean bool) throws Exception {
                    try {
                        String appSettingStr = AppPreferencesSetting.getInstance().getAppSettingStr("pref_key_pass_through_web_url", null);
                        boolean z = false;
                        if (!TextUtils.isEmpty(appSettingStr)) {
                            AppPreferencesSetting.getInstance().removeAppKey("pref_key_pass_through_web_url");
                            z = true;
                        } else {
                            appSettingStr = C3742b.m9111II().mo23165Jl();
                        }
                        if (!TextUtils.isEmpty(appSettingStr)) {
                            C3671a.this.bhN = new WebView(view.getContext());
                            ((ViewGroup) view).addView(C3671a.this.bhN);
                            C3671a.this.bhN.loadUrl(appSettingStr);
                            C3671a.this.bhN.setWebViewClient(new WebViewClient() {
                                public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                                    StringBuilder sb = new StringBuilder();
                                    sb.append("Jamin loadJS shouldOverrideUrlLoading url = ");
                                    sb.append(str);
                                    LogUtilsV2.m14227d(sb.toString());
                                    C3671a.this.bhN.loadUrl(str);
                                    return true;
                                }
                            });
                            C3671a.this.bhN.setVisibility(8);
                            WebSettings settings = C3671a.this.bhN.getSettings();
                            settings.setJavaScriptEnabled(true);
                            settings.setJavaScriptCanOpenWindowsAutomatically(true);
                            StringBuilder sb = new StringBuilder();
                            sb.append("Jamin loadJS show WebView url = ");
                            sb.append(appSettingStr);
                            LogUtilsV2.m14227d(sb.toString());
                            HashMap hashMap = new HashMap();
                            hashMap.put("push", z ? "1" : "0");
                            hashMap.put("url", appSettingStr);
                            UserBehaviorLog.onAliEvent("Dev_Event_ad_push_js", hashMap);
                        }
                    } catch (Exception e) {
                        LogUtilsV2.m14229e("Jamin loadJS error", e);
                        C5523b.logException(e);
                    }
                }
            }).mo10152c(C1820a.aVi()).mo10161e((C1517e<? super T>) new C1517e<Boolean>() {
                /* renamed from: d */
                public void accept(Boolean bool) throws Exception {
                    Thread.sleep(C12177i.f6154j);
                }
            }).mo10152c(C1487a.aUa()).mo10161e((C1517e<? super T>) new C1517e<Boolean>() {
                /* renamed from: d */
                public void accept(Boolean bool) throws Exception {
                    try {
                        if (C3671a.this.bhN != null) {
                            LogUtilsV2.m14227d("Jamin loadJS destroy WebView");
                            C3671a.this.bhN.setVisibility(8);
                            WebSettings settings = C3671a.this.bhN.getSettings();
                            settings.setJavaScriptEnabled(false);
                            settings.setJavaScriptCanOpenWindowsAutomatically(false);
                            C3671a.this.bhN.destroy();
                        }
                    } catch (Exception unused) {
                    }
                }
            }).aTR();
        }
    }
}
