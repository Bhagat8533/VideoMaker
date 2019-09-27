package com.introvd.template.template.download.web;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import com.introvd.template.common.ToastUtils;
import com.introvd.template.common.controller.BaseController;
import com.introvd.template.sdk.model.editor.EffectInfoModel;
import com.introvd.template.template.R;
import com.introvd.template.template.p407e.C8715a;
import com.introvd.template.template.p407e.C8715a.C8719d;
import com.introvd.template.template.p409g.C8762d;
import java.lang.ref.WeakReference;
import java.util.List;

/* renamed from: com.introvd.template.template.download.web.b */
public class C8710b extends BaseController<C8709a> {
    private C8715a bRO;
    /* access modifiers changed from: private */
    public boolean cTb;
    /* access modifiers changed from: private */
    public WeakReference<Activity> dYB;
    /* access modifiers changed from: private */
    public ProgressDialog elU;
    private C8719d elV = new C8719d() {
        public void onXytDownloadProgress(long j, int i) {
            if (C8710b.this.elU != null && i > C8710b.this.elU.getProgress()) {
                C8710b.this.elU.setProgress(i);
            }
        }

        public void onXytDownloadResult(Long l, boolean z) {
            Activity activity = (Activity) C8710b.this.dYB.get();
            if (activity != null && !activity.isFinishing() && !C8710b.this.cTb) {
                if (z) {
                    if (C8710b.this.elU != null) {
                        C8710b.this.elU.setProgress(0);
                        C8710b.this.elU.cancel();
                    }
                    if (C8710b.this.getMvpView() != null) {
                        ((C8709a) C8710b.this.getMvpView()).mo35086jC(true);
                    }
                } else {
                    if (C8710b.this.elU != null) {
                        C8710b.this.elU.setProgress(0);
                        C8710b.this.elU.cancel();
                    }
                    if (C8710b.this.getMvpView() != null) {
                        ((C8709a) C8710b.this.getMvpView()).mo35086jC(false);
                    }
                    ToastUtils.shortShow(activity.getApplicationContext(), R.string.xiaoying_str_com_msg_download_failed);
                }
            }
        }
    };

    /* renamed from: a */
    public void attachView(C8709a aVar) {
        super.attachView(aVar);
    }

    /* renamed from: aX */
    public void mo35088aX(Activity activity) {
        this.dYB = new WeakReference<>(activity);
        this.bRO = new C8715a(activity.getApplicationContext(), this.elV);
    }

    /* renamed from: aY */
    public void mo35089aY(Activity activity) {
        if (this.elU == null) {
            this.elU = new ProgressDialog(activity);
            this.elU.setMessage(activity.getResources().getString(R.string.xiaoying_str_activity_downloading_template_tip));
            this.elU.setProgressStyle(1);
            this.elU.setIndeterminate(false);
            this.elU.setCancelable(true);
            this.elU.setCanceledOnTouchOutside(false);
            this.elU.setOnCancelListener(new OnCancelListener() {
                public void onCancel(DialogInterface dialogInterface) {
                    C8710b.this.cTb = true;
                }
            });
            this.elU.setOnDismissListener(new OnDismissListener() {
                public void onDismiss(DialogInterface dialogInterface) {
                    C8710b.this.elU.setProgress(0);
                }
            });
        }
        if (!this.elU.isShowing()) {
            this.elU.show();
            this.cTb = false;
        }
    }

    /* renamed from: cO */
    public boolean mo35090cO(List<EffectInfoModel> list) {
        Activity activity = (Activity) this.dYB.get();
        if (activity == null) {
            return false;
        }
        C8762d.aMt().mo35219Q(activity.getApplicationContext(), true);
        if (list != null && list.size() > 0) {
            for (EffectInfoModel effectInfoModel : list) {
                if (C8762d.aMt().mo35228bE(effectInfoModel.mTemplateId)) {
                    return false;
                }
            }
        }
        return true;
    }

    /* renamed from: cP */
    public void mo35091cP(List<EffectInfoModel> list) {
        this.bRO.mo35095cZ(list);
    }

    public void detachView() {
        super.detachView();
    }
}
