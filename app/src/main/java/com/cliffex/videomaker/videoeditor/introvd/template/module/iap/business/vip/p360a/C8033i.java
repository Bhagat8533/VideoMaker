package com.introvd.template.module.iap.business.vip.p360a;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.introvd.template.common.ToastUtils;
import com.introvd.template.module.iap.C8072q;
import com.introvd.template.module.iap.R;
import com.introvd.template.module.iap.business.vip.C8009a;

/* renamed from: com.introvd.template.module.iap.business.vip.a.i */
public class C8033i {
    /* access modifiers changed from: private */
    @SuppressLint({"StaticFieldLeak"})
    public static C8027h dUM;

    /* renamed from: e */
    public static void m23243e(Activity activity, int i, String str) {
        if (i != 1) {
            ToastUtils.show((Context) activity, R.string.iap_vip_restore_empty_vip_info, 0);
        } else if (C8072q.aBx().isVip()) {
            ToastUtils.show((Context) activity, R.string.xiaoying_str_vip_restore_verify_platinum, 0);
        } else if (C8009a.m23202gs(activity)) {
            ToastUtils.show((Context) activity, R.string.xiaoying_str_vip_restore_verify_gold, 0);
        } else {
            if (dUM == null) {
                dUM = new C8027h(activity, str);
                dUM.mo33042d((OnDismissListener) new OnDismissListener() {
                    public void onDismiss(DialogInterface dialogInterface) {
                        C8033i.dUM.aEh();
                        C8033i.dUM = null;
                    }
                });
            }
            if (!dUM.isShowing()) {
                dUM.show();
            }
        }
    }
}
