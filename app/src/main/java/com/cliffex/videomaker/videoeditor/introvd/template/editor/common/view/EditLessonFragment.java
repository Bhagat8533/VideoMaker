package com.introvd.template.editor.common.view;

import android.os.Bundle;
import android.support.p021v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import com.aiii.android.arouter.facade.p094a.C1942a;
import com.aiii.android.arouter.p091c.C1919a;
import com.introvd.template.VivaBaseApplication;
import com.introvd.template.app.p177b.C3742b;
import com.introvd.template.app.webview.C4486c;
import com.introvd.template.app.webview.C4487d;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.editor.R;
import com.introvd.template.router.app.IAppService;
import com.introvd.template.router.editor.EditorRouter;
import com.introvd.template.router.todoCode.TODOParamModel;

@C1942a(mo10417rZ = "/XYVideoEditor/EditLesson")
public class EditLessonFragment extends Fragment {
    private WebView bhN;
    /* access modifiers changed from: private */
    public C5871a cFB;
    private String cFC;
    private ImageButton cFn;

    /* renamed from: com.introvd.template.editor.common.view.EditLessonFragment$a */
    public interface C5871a {
        void ahM();

        /* renamed from: d */
        void mo27752d(TODOParamModel tODOParamModel);
    }

    private void ahK() {
        this.bhN.getSettings().setJavaScriptEnabled(true);
        this.bhN.getSettings().setDomStorageEnabled(true);
        this.bhN.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        this.bhN.getSettings().setCacheMode(1);
        this.bhN.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
                return super.shouldOverrideUrlLoading(webView, webResourceRequest);
            }
        });
        this.bhN.setWebChromeClient(new WebChromeClient());
        this.bhN.addJavascriptInterface(new C4486c(new C4487d() {
            /* renamed from: b */
            public void mo24691b(TODOParamModel tODOParamModel, boolean z) {
                EditLessonFragment.this.ahL();
                if (EditLessonFragment.this.cFB != null) {
                    EditLessonFragment.this.cFB.mo27752d(tODOParamModel);
                }
            }

            /* renamed from: eu */
            public void mo24692eu(String str) {
                StringBuilder sb = new StringBuilder();
                sb.append("onGetHTML ======== ");
                sb.append(str);
                LogUtilsV2.m14227d(sb.toString());
            }
        }), "JSCaller");
        String Js = C3742b.m9111II().mo23172Js();
        if (TextUtils.isEmpty(Js)) {
            Js = "https://hybrid.xiaoying.tv/web/vivaVideo/preview_toturial/index.html";
        }
        if (!TextUtils.isEmpty(this.cFC)) {
            Js = this.cFC;
        }
        IAppService iAppService = (IAppService) C1919a.m5529sc().mo10356i(IAppService.class);
        if (iAppService != null) {
            Js = iAppService.formatVivaUrl(Js, VivaBaseApplication.m8749FZ());
        }
        this.bhN.loadUrl(Js);
    }

    /* access modifiers changed from: private */
    public void ahL() {
        if (getFragmentManager() != null) {
            getFragmentManager().beginTransaction().setCustomAnimations(R.anim.activity_slide_in_from_top, R.anim.activity_slide_out_to_top).hide(this).commitAllowingStateLoss();
        }
    }

    /* renamed from: a */
    public void mo28304a(C5871a aVar) {
        this.cFB = aVar;
    }

    public String getUrl() {
        return this.cFC;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.edit_lesson_web_page, viewGroup, false);
        this.bhN = (WebView) inflate.findViewById(R.id.webview_container);
        this.cFn = (ImageButton) inflate.findViewById(R.id.editor_back_btn);
        this.cFn.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                EditLessonFragment.this.ahL();
                if (EditLessonFragment.this.cFB != null) {
                    EditLessonFragment.this.cFB.ahM();
                }
            }
        });
        if (getArguments() != null) {
            this.cFC = getArguments().getString(EditorRouter.KEY_EDIT_LESSON_URL);
        }
        ahK();
        return inflate;
    }

    public void onDestroy() {
        if (this.bhN != null) {
            this.bhN.removeAllViews();
            this.bhN.destroy();
            this.bhN = null;
        }
        super.onDestroy();
    }

    public void onHiddenChanged(boolean z) {
        if (z) {
            if (this.bhN != null) {
                this.bhN.onPause();
            }
        } else if (this.bhN != null) {
            this.bhN.onResume();
        }
        super.onHiddenChanged(z);
    }

    public void onPause() {
        super.onPause();
        if (this.bhN != null) {
            this.bhN.onPause();
        }
    }

    public void onResume() {
        super.onResume();
        if (this.bhN != null && !isHidden()) {
            this.bhN.onResume();
        }
    }
}
