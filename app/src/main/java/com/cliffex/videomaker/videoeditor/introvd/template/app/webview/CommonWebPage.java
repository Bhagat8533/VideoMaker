package com.introvd.template.app.webview;

import android.annotation.SuppressLint;
import android.app.AlertDialog.Builder;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.DownloadListener;
import android.webkit.JsResult;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebChromeClient.FileChooserParams;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.aiii.android.arouter.facade.p094a.C1942a;
import com.introvd.template.EventActivity;
import com.introvd.template.R;
import com.introvd.template.app.utils.C4395c;
import com.introvd.template.common.ApiHelper;
import com.introvd.template.common.LogUtils;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.common.UserBehaviorLog;
import com.introvd.template.common.behavior.UserBehaviorUtilsV5;
import com.introvd.template.common.model.AppStateModel;
import com.introvd.template.common.utils.NotchUtil;
import com.introvd.template.crash.C5523b;
import com.introvd.template.crash.C5526d;
import com.introvd.template.datacenter.SocialService;
import com.introvd.template.datacenter.SocialServiceDef;
import com.introvd.template.p203b.C4580b;
import com.introvd.template.p203b.C4586g;
import com.introvd.template.p242d.C5527a;
import com.introvd.template.router.AppRouter.CommonWebPageParams;
import com.introvd.template.router.VivaRouter;
import com.introvd.template.router.common.CommonParams;
import com.introvd.template.router.community.VivaCommunityRouter.FeedVideoActivityParams;
import com.introvd.template.router.editor.gallery.GalleryRouter;
import com.introvd.template.router.sns.MyResolveInfo;
import com.introvd.template.router.sns.PopupVideoShareInfo;
import com.introvd.template.router.sns.PopupVideoShareInfo.OnPopupItemClickListener;
import com.introvd.template.router.todoCode.BizAppTodoActionManager;
import com.introvd.template.router.todoCode.TODOParamModel;
import com.introvd.template.router.todoCode.TodoConstants;
import com.introvd.template.sns.SnsShareInfo;
import com.introvd.template.sns.SnsShareManager;
import com.introvd.template.sns.SnsShareTypeUtil;
import com.introvd.template.sns.VideoShareInfo;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

@C1942a(mo10417rZ = "/appcore/CommonWebView")
public class CommonWebPage extends EventActivity implements OnClickListener {
    /* access modifiers changed from: private */
    public TextView bCG;
    /* access modifiers changed from: private */
    public TextView bCg;
    private FrameLayout bHZ = null;
    /* access modifiers changed from: private */
    public ImageView bHq;
    /* access modifiers changed from: private */
    public ImageView bIa = null;
    /* access modifiers changed from: private */
    public boolean bIb = false;
    /* access modifiers changed from: private */
    public String bIc = "";
    private String bId = "";
    private int bIe = 0;
    /* access modifiers changed from: private */
    public RelativeLayout bIf;
    /* access modifiers changed from: private */
    public ValueCallback<Uri[]> bIg;
    private String bIh;
    private String bIi = "<input type=\\\"hidden.+>";
    private String bIj = "id=\"[^\\\"]*\"";
    private String bIk = "value=\"[^\\\"]*\"";
    private WebView bhN = null;
    private String btf;
    private String btg;
    private String bth;
    private String bti;

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x006b A[Catch:{ Exception -> 0x010d }] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x008b A[Catch:{ Exception -> 0x010d }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x009b A[Catch:{ Exception -> 0x010d }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00ac A[Catch:{ Exception -> 0x010d }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00f8 A[Catch:{ Exception -> 0x010d }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00f9 A[Catch:{ Exception -> 0x010d }] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0100 A[Catch:{ Exception -> 0x010d }] */
    /* JADX WARNING: Removed duplicated region for block: B:53:? A[RETURN, SYNTHETIC] */
    /* renamed from: H */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m11341H(java.util.Map<java.lang.String, java.lang.String> r3) throws java.lang.Exception {
        /*
            r2 = this;
            java.lang.String r0 = "shareTitle"
            boolean r0 = r3.containsKey(r0)     // Catch:{ Exception -> 0x010d }
            if (r0 != 0) goto L_0x000b
            java.lang.String r0 = r2.bIc     // Catch:{ Exception -> 0x010d }
            goto L_0x0013
        L_0x000b:
            java.lang.String r0 = "shareTitle"
            java.lang.Object r0 = r3.get(r0)     // Catch:{ Exception -> 0x010d }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ Exception -> 0x010d }
        L_0x0013:
            r2.btf = r0     // Catch:{ Exception -> 0x010d }
            java.lang.String r0 = "shareImgSrc"
            boolean r0 = r3.containsKey(r0)     // Catch:{ Exception -> 0x010d }
            if (r0 != 0) goto L_0x0020
            java.lang.String r0 = "https://hybrid.xiaoying.tv/web/vivavideo_logo.jpg"
            goto L_0x0028
        L_0x0020:
            java.lang.String r0 = "shareImgSrc"
            java.lang.Object r0 = r3.get(r0)     // Catch:{ Exception -> 0x010d }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ Exception -> 0x010d }
        L_0x0028:
            r2.btg = r0     // Catch:{ Exception -> 0x010d }
            java.lang.String r0 = "shareDesc"
            boolean r0 = r3.containsKey(r0)     // Catch:{ Exception -> 0x010d }
            if (r0 != 0) goto L_0x0035
            java.lang.String r0 = r2.bIc     // Catch:{ Exception -> 0x010d }
            goto L_0x003d
        L_0x0035:
            java.lang.String r0 = "shareDesc"
            java.lang.Object r0 = r3.get(r0)     // Catch:{ Exception -> 0x010d }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ Exception -> 0x010d }
        L_0x003d:
            r2.bth = r0     // Catch:{ Exception -> 0x010d }
            java.lang.String r0 = "shareLink"
            boolean r0 = r3.containsKey(r0)     // Catch:{ Exception -> 0x010d }
            if (r0 == 0) goto L_0x005f
            java.lang.String r0 = "shareLink"
            java.lang.Object r0 = r3.get(r0)     // Catch:{ Exception -> 0x010d }
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0     // Catch:{ Exception -> 0x010d }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x010d }
            if (r0 == 0) goto L_0x0056
            goto L_0x005f
        L_0x0056:
            java.lang.String r0 = "shareLink"
            java.lang.Object r0 = r3.get(r0)     // Catch:{ Exception -> 0x010d }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ Exception -> 0x010d }
            goto L_0x0061
        L_0x005f:
            java.lang.String r0 = r2.bId     // Catch:{ Exception -> 0x010d }
        L_0x0061:
            r2.bti = r0     // Catch:{ Exception -> 0x010d }
            java.lang.String r0 = "sharedisable"
            boolean r0 = r3.containsKey(r0)     // Catch:{ Exception -> 0x010d }
            if (r0 == 0) goto L_0x008b
            java.lang.String r0 = "sharedisable"
            java.lang.Object r0 = r3.get(r0)     // Catch:{ Exception -> 0x010d }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ Exception -> 0x010d }
            boolean r0 = java.lang.Boolean.parseBoolean(r0)     // Catch:{ Exception -> 0x010d }
            if (r0 == 0) goto L_0x0082
            com.introvd.template.app.webview.CommonWebPage$8 r0 = new com.introvd.template.app.webview.CommonWebPage$8     // Catch:{ Exception -> 0x010d }
            r0.<init>()     // Catch:{ Exception -> 0x010d }
            r2.runOnUiThread(r0)     // Catch:{ Exception -> 0x010d }
            goto L_0x0093
        L_0x0082:
            com.introvd.template.app.webview.CommonWebPage$9 r0 = new com.introvd.template.app.webview.CommonWebPage$9     // Catch:{ Exception -> 0x010d }
            r0.<init>()     // Catch:{ Exception -> 0x010d }
            r2.runOnUiThread(r0)     // Catch:{ Exception -> 0x010d }
            goto L_0x0093
        L_0x008b:
            com.introvd.template.app.webview.CommonWebPage$10 r0 = new com.introvd.template.app.webview.CommonWebPage$10     // Catch:{ Exception -> 0x010d }
            r0.<init>()     // Catch:{ Exception -> 0x010d }
            r2.runOnUiThread(r0)     // Catch:{ Exception -> 0x010d }
        L_0x0093:
            java.lang.String r0 = "showfeedback"
            boolean r0 = r3.containsKey(r0)     // Catch:{ Exception -> 0x010d }
            if (r0 == 0) goto L_0x00ac
            java.lang.String r0 = "showfeedback"
            java.lang.Object r0 = r3.get(r0)     // Catch:{ Exception -> 0x010d }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ Exception -> 0x010d }
            com.introvd.template.app.webview.CommonWebPage$11 r1 = new com.introvd.template.app.webview.CommonWebPage$11     // Catch:{ Exception -> 0x010d }
            r1.<init>(r0)     // Catch:{ Exception -> 0x010d }
            r2.runOnUiThread(r1)     // Catch:{ Exception -> 0x010d }
            goto L_0x00b4
        L_0x00ac:
            com.introvd.template.app.webview.CommonWebPage$12 r0 = new com.introvd.template.app.webview.CommonWebPage$12     // Catch:{ Exception -> 0x010d }
            r0.<init>()     // Catch:{ Exception -> 0x010d }
            r2.runOnUiThread(r0)     // Catch:{ Exception -> 0x010d }
        L_0x00b4:
            java.lang.String r0 = "hideLine"
            boolean r0 = r3.containsKey(r0)     // Catch:{ Exception -> 0x010d }
            if (r0 == 0) goto L_0x00d2
            java.lang.String r0 = "hideLine"
            java.lang.Object r0 = r3.get(r0)     // Catch:{ Exception -> 0x010d }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ Exception -> 0x010d }
            boolean r0 = java.lang.Boolean.parseBoolean(r0)     // Catch:{ Exception -> 0x010d }
            if (r0 == 0) goto L_0x00d2
            com.introvd.template.app.webview.CommonWebPage$2 r0 = new com.introvd.template.app.webview.CommonWebPage$2     // Catch:{ Exception -> 0x010d }
            r0.<init>()     // Catch:{ Exception -> 0x010d }
            r2.runOnUiThread(r0)     // Catch:{ Exception -> 0x010d }
        L_0x00d2:
            java.lang.String r0 = "topBarBgColor"
            boolean r0 = r3.containsKey(r0)     // Catch:{ Exception -> 0x010d }
            if (r0 != 0) goto L_0x00e2
            java.lang.String r0 = "navigationBarBgColor"
            boolean r0 = r3.containsKey(r0)     // Catch:{ Exception -> 0x010d }
            if (r0 == 0) goto L_0x010c
        L_0x00e2:
            java.lang.String r0 = "topBarBgColor"
            java.lang.Object r0 = r3.get(r0)     // Catch:{ Exception -> 0x010d }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ Exception -> 0x010d }
            java.lang.String r1 = "navigationBarBgColor"
            java.lang.Object r3 = r3.get(r1)     // Catch:{ Exception -> 0x010d }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ Exception -> 0x010d }
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x010d }
            if (r1 == 0) goto L_0x00f9
            goto L_0x00fa
        L_0x00f9:
            r3 = r0
        L_0x00fa:
            boolean r0 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x010d }
            if (r0 != 0) goto L_0x010c
            int r3 = android.graphics.Color.parseColor(r3)     // Catch:{ Exception -> 0x010d }
            com.introvd.template.app.webview.CommonWebPage$3 r0 = new com.introvd.template.app.webview.CommonWebPage$3     // Catch:{ Exception -> 0x010d }
            r0.<init>(r3)     // Catch:{ Exception -> 0x010d }
            r2.runOnUiThread(r0)     // Catch:{ Exception -> 0x010d }
        L_0x010c:
            return
        L_0x010d:
            java.lang.Exception r3 = new java.lang.Exception
            java.lang.String r0 = "Parse Html Error"
            r3.<init>(r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.app.webview.CommonWebPage.m11341H(java.util.Map):void");
    }

    @SuppressLint({"JavascriptInterface", "AddJavascriptInterface", "SetJavaScriptEnabled"})
    /* renamed from: Rq */
    private void m11342Rq() {
        this.bhN.setWebChromeClient(new WebChromeClient() {
            public boolean onJsAlert(WebView webView, String str, String str2, final JsResult jsResult) {
                new Builder(CommonWebPage.this).setMessage(str2).setPositiveButton(17039370, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        jsResult.confirm();
                    }
                }).setNegativeButton(17039360, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        jsResult.cancel();
                    }
                }).create().show();
                return true;
            }

            public void onReceivedTitle(WebView webView, String str) {
                super.onReceivedTitle(webView, str);
                if (C4580b.m11661eG(str)) {
                    CommonWebPage.this.bIc = str;
                    if (CommonWebPage.this.bCG != null) {
                        CommonWebPage.this.bCG.setText(CommonWebPage.this.bIc);
                    }
                }
            }

            public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, FileChooserParams fileChooserParams) {
                if (CommonWebPage.this.bIg != null) {
                    CommonWebPage.this.bIg.onReceiveValue(null);
                }
                CommonWebPage.this.bIg = valueCallback;
                CommonWebPage.this.m11343Rr();
                return true;
            }
        });
        this.bhN.setWebViewClient(new WebViewClient() {
            public void onPageFinished(WebView webView, String str) {
                webView.loadUrl("javascript:window.JSCaller.execute('GetHTML','<html>'+document.getElementsByTagName('html')[0].innerHTML+'</html>');");
            }

            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                if (CommonWebPage.this.bIb) {
                    if ("market".equals(Uri.parse(str).getScheme())) {
                        CommonWebPage.this.m11358eo(str);
                        return true;
                    } else if (!str.startsWith("https://play.google.com/store/apps/")) {
                        return false;
                    } else {
                        CommonWebPage.this.m11358eo(str.replace("https://play.google.com/store/apps/", "market://"));
                        return true;
                    }
                } else if (str.startsWith("market://")) {
                    CommonWebPage.this.m11358eo(str);
                    return true;
                } else if (str.startsWith(SocialService.CONST_URL_HTTP_PREFIX) || str.startsWith("https://")) {
                    return false;
                } else {
                    CommonWebPage.this.m11359ep(str);
                    return true;
                }
            }
        });
        this.bhN.getSettings().setJavaScriptEnabled(true);
        this.bhN.getSettings().setDomStorageEnabled(true);
        this.bhN.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        if (VERSION.SDK_INT >= 21) {
            this.bhN.getSettings().setMixedContentMode(2);
        }
        this.bhN.setDownloadListener(new DownloadListener() {
            public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.addCategory("android.intent.category.BROWSABLE");
                intent.setData(Uri.parse(str));
                CommonWebPage.this.startActivity(intent);
            }
        });
        this.bhN.addJavascriptInterface(new C4486c(new C4487d() {
            /* renamed from: b */
            public void mo24691b(TODOParamModel tODOParamModel, boolean z) {
                CommonWebPage.this.m11350a(tODOParamModel, z);
            }

            /* renamed from: eu */
            public void mo24692eu(String str) {
                try {
                    CommonWebPage.this.m11341H(CommonWebPage.this.mo24675er(str));
                } catch (Exception e) {
                    C5523b.logException(e);
                    if (CommonWebPage.this.bHq != null) {
                        CommonWebPage.this.bHq.setVisibility(4);
                    }
                    if (CommonWebPage.this.bCg != null) {
                        CommonWebPage.this.bCg.setVisibility(8);
                    }
                }
            }
        }), "JSCaller");
    }

    /* access modifiers changed from: private */
    /* renamed from: Rr */
    public void m11343Rr() {
        Intent[] intentArr;
        File file;
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        if (intent.resolveActivity(getPackageManager()) != null) {
            try {
                file = m11344Rs();
                try {
                    intent.putExtra("PhotoPath", this.bIh);
                } catch (Exception unused) {
                }
            } catch (Exception unused2) {
                file = null;
            }
            if (file != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("file:");
                sb.append(file.getAbsolutePath());
                this.bIh = sb.toString();
                intent.putExtra(GalleryRouter.INTENT_OUTPUT_PATH, Uri.fromFile(file));
                System.out.println(this.bIh);
            } else {
                intent = null;
            }
        }
        Intent intent2 = new Intent("android.intent.action.GET_CONTENT");
        intent2.addCategory("android.intent.category.OPENABLE");
        intent2.setType("image/*");
        if (intent != null) {
            intentArr = new Intent[]{intent};
            System.out.println(intent);
        } else {
            intentArr = new Intent[0];
        }
        Intent intent3 = new Intent("android.intent.action.CHOOSER");
        intent3.putExtra("android.intent.extra.INTENT", intent2);
        intent3.putExtra("android.intent.extra.TITLE", "Image Chooser");
        intent3.putExtra("android.intent.extra.INITIAL_INTENTS", intentArr);
        startActivityForResult(intent3, 4097);
    }

    @SuppressLint({"SdCardPath"})
    /* renamed from: Rs */
    private File m11344Rs() {
        StringBuilder sb = new StringBuilder();
        sb.append(Environment.getExternalStorageDirectory());
        sb.append("/");
        File file = new File(sb.toString(), "xiaoying_web_tmp.png");
        this.bIh = file.getAbsolutePath();
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return file;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m11350a(TODOParamModel tODOParamModel, boolean z) {
        try {
            JSONObject jSONObject = new JSONObject(tODOParamModel.mJsonParam);
            jSONObject.put(TodoConstants.KEY_TODOCODE_PARAM_AUTOCLOSE, z);
            tODOParamModel.mJsonParam = jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        getIntent().putExtra(TodoConstants.KEY_TODOCODE_PARAM_MODEL, tODOParamModel);
        JSONObject jsonObj = tODOParamModel.getJsonObj();
        int activityFlag = tODOParamModel.getActivityFlag();
        if (jsonObj == null) {
            BizAppTodoActionManager.getInstance().executeTodo(this, tODOParamModel, null);
            return;
        }
        if (activityFlag == 1) {
            HashMap hashMap = new HashMap();
            String str = SocialServiceDef.EXTRAS_UPGRADE_FROM;
            StringBuilder sb = new StringBuilder();
            sb.append("flag_");
            sb.append(tODOParamModel.mTODOCode);
            hashMap.put(str, sb.toString());
            UserBehaviorLog.onKVEvent(getApplicationContext(), "Reverse_Enter", hashMap);
        }
        try {
            if (tODOParamModel.mTODOCode == 932) {
                if (!isFinishing()) {
                    m11366j(jsonObj.optString("shareTitle", ""), jsonObj.optString("shareImgSrc", ""), jsonObj.optString("shareDesc", ""), jsonObj.optString("shareLink", ""));
                }
            } else if (tODOParamModel.mTODOCode == 933) {
                VivaRouter.getRouterBuilder(FeedVideoActivityParams.URL).mo10399f(FeedVideoActivityParams.EXTRA_VIDEO_TYPE_SLIDE_JSON, "slide").mo10399f(FeedVideoActivityParams.EXTRA_VIDEO_SCROLL_ID, jsonObj.optString("puid")).mo10406h(FeedVideoActivityParams.EXTRA_VIDEO_PAGE_FROM, 29).mo10394aZ(R.anim.activity_right_enter_translate, R.anim.activity_left_exit_translate).mo10382H(this);
            } else {
                Bundle bundle = new Bundle();
                bundle.putInt(CommonParams.ACTIVITY_TODOCODE, tODOParamModel.mTODOCode);
                bundle.putBoolean(CommonParams.KEY_CHECK_TEMPLATE_DOWNLOAD, true);
                BizAppTodoActionManager.getInstance().executeTodo(this, tODOParamModel, bundle);
                return;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            C5523b.logException(new C5526d("H5 todoCode Error", e2));
        }
        m11355c(tODOParamModel);
        if (z && !TodoConstants.isCameraTodoCode(tODOParamModel.mTODOCode)) {
            finish();
        }
    }

    /* renamed from: c */
    private void m11355c(TODOParamModel tODOParamModel) {
        try {
            JSONObject jSONObject = new JSONObject(tODOParamModel.mJsonParam);
            String optString = jSONObject.optString("event");
            if (!TextUtils.isEmpty(optString)) {
                String optString2 = jSONObject.optString("value");
                Iterator keys = new JSONObject(optString2).keys();
                HashMap hashMap = new HashMap();
                while (keys.hasNext()) {
                    String str = (String) keys.next();
                    hashMap.put(str, jSONObject.optString(str));
                }
                String str2 = TAG;
                StringBuilder sb = new StringBuilder();
                sb.append(optString);
                sb.append(" : ");
                sb.append(optString2);
                LogUtils.m14223i(str2, sb.toString());
                UserBehaviorLog.onAliEvent(optString, hashMap);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: eo */
    public void m11358eo(String str) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(str));
            startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            Uri parse = Uri.parse(str);
            WebView webView = this.bhN;
            StringBuilder sb = new StringBuilder();
            sb.append("http://play.google.com/store/apps/");
            sb.append(parse.getHost());
            sb.append("?");
            sb.append(parse.getQuery());
            webView.loadUrl(sb.toString());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: ep */
    public void m11359ep(String str) {
        try {
            startActivity(Intent.parseUri(str, 0));
        } catch (ActivityNotFoundException unused) {
            m11360eq(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: eq */
    private void m11360eq(String str) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(str));
            startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: es */
    private String m11361es(String str) {
        if (str == null) {
            return "";
        }
        int indexOf = str.indexOf(34);
        int lastIndexOf = str.lastIndexOf(34);
        return indexOf >= lastIndexOf ? "" : str.substring(indexOf + 1, lastIndexOf);
    }

    /* renamed from: j */
    private void m11366j(final String str, String str2, String str3, String str4) {
        final VideoShareInfo videoShareInfo = new VideoShareInfo();
        videoShareInfo.strTitle = str;
        videoShareInfo.strThumbUrl = str2;
        videoShareInfo.strThumbPath = str2;
        videoShareInfo.strDesc = str3;
        videoShareInfo.strPageUrl = str4;
        videoShareInfo.needReport = false;
        SnsShareManager.showVideoShareDialog(this, new PopupVideoShareInfo.Builder().myResolveInfoList(SnsShareTypeUtil.getSnsInfoAppList(this, true, false, false, false)).onPopupItemClickListener(new OnPopupItemClickListener() {
            public void onItemClick(MyResolveInfo myResolveInfo) {
                SnsShareInfo.Builder strLinkUrl = new SnsShareInfo.Builder().strTitle(videoShareInfo.strTitle).strDesc(videoShareInfo.strDesc).strImgUrl(videoShareInfo.strThumbUrl).strLinkUrl(videoShareInfo.strPageUrl);
                if (myResolveInfo != null && myResolveInfo.label != null) {
                    UserBehaviorUtilsV5.onEventVideoShare(CommonWebPage.this, C5527a.m14968kj(29), myResolveInfo.label.toString(), str);
                    SnsShareManager.shareLink(CommonWebPage.this, myResolveInfo.snsType, strLinkUrl.build(), C5527a.m14968kj(29));
                }
            }
        }).build());
    }

    /* access modifiers changed from: protected */
    /* renamed from: FV */
    public String[] mo22813FV() {
        return new String[]{CommonWebPageParams.ACTION_FINISH_WEB_ACTIVITY};
    }

    /* renamed from: er */
    public Map<String, String> mo24675er(String str) throws Exception {
        HashMap hashMap = new HashMap();
        try {
            if (!TextUtils.isEmpty(str)) {
                Pattern compile = Pattern.compile(this.bIi);
                Pattern compile2 = Pattern.compile(this.bIj);
                Pattern compile3 = Pattern.compile(this.bIk);
                Matcher matcher = compile.matcher(str);
                for (boolean find = matcher.find(); find; find = matcher.find()) {
                    String group = matcher.group();
                    Matcher matcher2 = compile2.matcher(group);
                    if (matcher2.find()) {
                        String group2 = matcher2.group();
                        Matcher matcher3 = compile3.matcher(group);
                        String es = m11361es(group2);
                        if (es.length() > 0 && matcher3.find()) {
                            hashMap.put(es, m11361es(matcher3.group()));
                        }
                    }
                }
            }
            return hashMap;
        } catch (Exception unused) {
            throw new Exception("Parse Html Error");
        }
    }

    /* renamed from: et */
    public void mo24676et(String str) {
        if (!isFinishing()) {
            StringBuilder sb = new StringBuilder();
            sb.append("reloadUrl : ");
            sb.append(str);
            LogUtilsV2.m14230i(sb.toString());
            this.bhN.loadUrl(str);
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        Uri[] uriArr;
        if (i != 4097 || this.bIg == null) {
            super.onActivityResult(i, i2, intent);
            return;
        }
        if (i2 == -1) {
            if (intent != null) {
                String dataString = intent.getDataString();
                if (dataString != null) {
                    uriArr = new Uri[]{Uri.parse(dataString)};
                    this.bIg.onReceiveValue(uriArr);
                    this.bIg = null;
                }
            } else if (this.bIh != null) {
                uriArr = new Uri[]{Uri.parse(this.bIh)};
                this.bIg.onReceiveValue(uriArr);
                this.bIg = null;
            }
        }
        uriArr = null;
        this.bIg.onReceiveValue(uriArr);
        this.bIg = null;
    }

    public void onBackPressed() {
        if (this.bhN == null || !this.bhN.canGoBack() || this.bIe >= 5) {
            super.onBackPressed();
            return;
        }
        this.bIe++;
        this.bhN.goBack();
    }

    public void onClick(View view) {
        if (view.equals(this.bIa)) {
            if (AppStateModel.getInstance().isInChina() || this.bhN == null || !this.bhN.canGoBack() || this.bIe >= 5) {
                finish();
            } else {
                this.bIe++;
                this.bhN.goBack();
            }
        } else if (view.equals(this.bHq)) {
            if (!isFinishing()) {
                m11366j(this.btf, this.btg, this.bth, this.bti);
            }
        } else if (view.equals(this.bCg) && AppStateModel.getInstance().isInChina()) {
            C4395c.m11088a(this, -1);
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        if (NotchUtil.isNotchDevice()) {
            setTheme(R.style.Theme_XiaoYingNoSplash);
        }
        super.onCreate(bundle);
        setContentView(R.layout.v4_xiaoying_com_webview_layout);
        View findViewById = findViewById(R.id.view_bottom_shadow);
        if (VERSION.SDK_INT >= 21) {
            findViewById.setVisibility(8);
        } else {
            findViewById.setVisibility(0);
        }
        int i = VERSION.SDK_INT;
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.bId = extras.getString(CommonWebPageParams.KEY_WEBVIEW_URL);
            this.bIc = extras.getString(CommonWebPageParams.KEY_WEBVIEW_TITLE);
        }
        try {
            this.bhN = new WebView(getApplicationContext());
            this.bhN.setId(R.id.webview);
            this.bIf = (RelativeLayout) findViewById(R.id.layout_title_bar);
            this.bHZ = (FrameLayout) findViewById(R.id.webview_container);
            this.bHZ.addView(this.bhN, new LayoutParams(-1, -1));
            this.bhN.getSettings().setCacheMode(2);
            if (!TextUtils.isEmpty(this.bId) && this.bId.startsWith("http://admaster.union.ucweb.com/appwall")) {
                this.bIb = true;
            }
            m11342Rq();
            StringBuilder sb = new StringBuilder();
            sb.append("loadUrl : ");
            sb.append(this.bId);
            LogUtilsV2.m14230i(sb.toString());
            this.bhN.loadUrl(this.bId);
            this.bIa = (ImageView) findViewById(R.id.back_btn);
            this.bIa.setOnClickListener(this);
            this.bCG = (TextView) findViewById(R.id.text_title);
            this.bCG.setText(this.bIc);
            this.bHq = (ImageView) findViewById(R.id.btn_share);
            this.bHq.setOnClickListener(this);
            this.bCg = (TextView) findViewById(R.id.feedback_tv);
            this.bCg.setOnClickListener(this);
            if (AppStateModel.getInstance().isInChina()) {
                this.bCg.setText(getResources().getString(R.string.xiaoying_str_vip_customer_service));
            }
            if (AppStateModel.getInstance().isInChina()) {
                this.bIa.setImageResource(R.drawable.vivavideo_com_nav_cancel);
            } else {
                this.bIa.setImageResource(R.drawable.vivavideo_com_nav_back);
            }
        } catch (Exception e) {
            C5523b.logException(e);
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        if (!isFinishing()) {
            C4586g.m11696Sm();
        }
        if (!(this.bhN == null || this.bHZ == null)) {
            this.bHZ.removeAllViews();
            this.bhN.setVisibility(8);
            this.bhN.removeAllViews();
            this.bhN.destroy();
            this.bhN = null;
            this.bHZ = null;
        }
        super.onDestroy();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        LogUtils.m14223i(TAG, "onPause");
        if (ApiHelper.HONEYCOMB_AND_HIGHER && this.bhN != null) {
            this.bhN.onPause();
        }
        super.onPause();
        UserBehaviorLog.onPause(this);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        LogUtils.m14223i(TAG, "onResume");
        super.onResume();
        UserBehaviorLog.onResume(this);
        if (ApiHelper.HONEYCOMB_AND_HIGHER && this.bhN != null) {
            this.bhN.onResume();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: q */
    public void mo22820q(Intent intent) {
        if (CommonWebPageParams.ACTION_FINISH_WEB_ACTIVITY.equals(intent.getAction())) {
            finish();
        }
    }
}
