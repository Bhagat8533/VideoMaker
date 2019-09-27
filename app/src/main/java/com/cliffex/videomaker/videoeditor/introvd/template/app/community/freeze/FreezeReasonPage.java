package com.introvd.template.app.community.freeze;

import android.app.Activity;
import android.content.Context;
import android.databinding.C0171f;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import com.aiii.android.arouter.facade.p094a.C1942a;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.gson.JsonObject;
import com.introvd.template.EventActivity;
import com.introvd.template.R;
import com.introvd.template.app.C3740b;
import com.introvd.template.app.utils.C4395c;
import com.introvd.template.common.ToastUtils;
import com.introvd.template.common.ViewClickEffectMgr;
import com.introvd.template.common.html.HtmlTagHandler;
import com.introvd.template.common.html.SpanTagHandler;
import com.introvd.template.common.model.AppStateModel;
import com.introvd.template.origin.device.api.C8124b;
import com.introvd.template.p203b.C4580b;
import com.introvd.template.p310g.C7363e;
import com.introvd.template.router.AppRouter;
import com.introvd.template.router.BizServiceManager;
import com.introvd.template.router.VivaRouter.FreezeReasonPageParam;
import com.introvd.template.router.user.IAccountAPI;
import com.introvd.template.router.user.UserServiceProxy;
import java.lang.ref.WeakReference;
import p037b.p050b.C1850u;
import p037b.p050b.p051a.p053b.C1487a;
import p037b.p050b.p054b.C1495b;
import p037b.p050b.p076j.C1820a;

@C1942a(mo10417rZ = "/app/freezereasonpage")
public class FreezeReasonPage extends EventActivity {
    private C7363e bkh;
    private long bki;
    private boolean bkj;

    /* renamed from: com.introvd.template.app.community.freeze.FreezeReasonPage$a */
    public class C3760a {
        public C3760a() {
        }

        /* renamed from: bA */
        public void mo23230bA(View view) {
            StringBuilder sb = new StringBuilder();
            sb.append("Duid : ");
            sb.append(C4580b.m11653dz(view.getContext()));
            String sb2 = sb.toString();
            if (!TextUtils.isEmpty(UserServiceProxy.getUserId())) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(sb2);
                sb3.append(" Auid : ");
                sb3.append(UserServiceProxy.getUserId());
                sb2 = sb3.toString();
            }
            C4395c.m11090a(FreezeReasonPage.this, sb2, 16, FreezeReasonPage.this.getString(R.string.xiaoying_feedback_freeze_issue_type_content));
        }

        /* renamed from: bB */
        public void mo23231bB(View view) {
            FreezeReasonPage.this.finish();
        }

        /* renamed from: bC */
        public void mo23232bC(View view) {
            AppRouter.startWebPage(FreezeReasonPage.this, "https://hybrid.xiaoying.tv/web/vivavideo/h5template/h5/index.html?id=557", null);
        }
    }

    /* renamed from: HA */
    private void m9207HA() {
        for (WeakReference weakReference : C3740b.m9101He().mo23112Hh()) {
            if (weakReference.get() != null) {
                ((Activity) weakReference.get()).finish();
            }
        }
        Process.killProcess(Process.myPid());
    }

    /* access modifiers changed from: private */
    /* renamed from: Iq */
    public void m9208Iq() {
        this.bkh.coV.setText("");
        if (TextUtils.isEmpty(this.bkh.getAuid())) {
            C8124b.getFreezeReason(C4580b.m11653dz(this)).mo10196g(C1820a.aVi()).mo10194f(C1487a.aUa()).mo10188a((C1850u<? super T>) new C1850u<JsonObject>() {
                /* renamed from: a */
                public void mo9883a(C1495b bVar) {
                }

                /* renamed from: a */
                public void onSuccess(JsonObject jsonObject) {
                    String asString = jsonObject != null ? jsonObject.get("reason").getAsString() : null;
                    if (TextUtils.isEmpty(asString)) {
                        asString = FreezeReasonPage.this.getString(R.string.xiaoying_com_freeze_reason_default);
                    }
                    FreezeReasonPage.this.m9213do(asString);
                }

                public void onError(Throwable th) {
                    FreezeReasonPage.this.m9209Ir();
                }
            });
            return;
        }
        IAccountAPI iAccountAPI = (IAccountAPI) BizServiceManager.getService(IAccountAPI.class);
        if (iAccountAPI != null) {
            iAccountAPI.getFreezeReason(this.bkh.getAuid()).mo10196g(C1820a.aVi()).mo10194f(C1487a.aUa()).mo10188a((C1850u<? super T>) new C1850u<JsonObject>() {
                /* renamed from: a */
                public void mo9883a(C1495b bVar) {
                }

                /* renamed from: a */
                public void onSuccess(JsonObject jsonObject) {
                    String asString = jsonObject != null ? jsonObject.get("reason").getAsString() : null;
                    if (TextUtils.isEmpty(asString)) {
                        asString = FreezeReasonPage.this.getString(R.string.xiaoying_com_freeze_reason_default);
                    }
                    FreezeReasonPage.this.m9213do(asString);
                }

                public void onError(Throwable th) {
                    FreezeReasonPage.this.m9209Ir();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: Ir */
    public void m9209Ir() {
        StringBuilder sb = new StringBuilder();
        sb.append("<html><body>");
        sb.append(getString(R.string.xiaoying_com_freeze_reason_request_failed));
        sb.append("</body></html>");
        this.bkh.coV.setText(HtmlTagHandler.fromHtml(sb.toString(), null, new SpanTagHandler(), new ClickableSpan() {
            public void onClick(View view) {
                FreezeReasonPage.this.m9208Iq();
            }
        }));
    }

    /* access modifiers changed from: private */
    /* renamed from: do */
    public void m9213do(String str) {
        this.bkh.coV.setText(str);
    }

    public void onBackPressed() {
        if (TextUtils.isEmpty(this.bkh.getAuid())) {
            if (!this.bkj || System.currentTimeMillis() - this.bki >= AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS) {
                this.bkj = true;
                this.bki = System.currentTimeMillis();
                ToastUtils.show((Context) this, R.string.xiaoying_str_com_press_back_key_again_to_exit, 0);
            } else {
                m9207HA();
            }
            return;
        }
        super.onBackPressed();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bkh = (C7363e) C0171f.m361a(this, R.layout.app_activity_freeze_reason_page);
        this.bkh.setAuid(getIntent().getStringExtra(FreezeReasonPageParam.INTENT_KEY_AUID));
        this.bkh.mo31994dJ(AppStateModel.getInstance().isInChina());
        this.bkh.mo31993a(new C3760a());
        ViewClickEffectMgr.addEffectForViews(FreezeReasonPage.class.getSimpleName(), this.bkh.coR);
        this.bkh.coV.setMovementMethod(new LinkMovementMethod());
        m9208Iq();
    }
}
