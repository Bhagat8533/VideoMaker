package com.introvd.template.module.iap.business.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.introvd.template.module.iap.R;
import java.util.List;

/* renamed from: com.introvd.template.module.iap.business.dialog.b */
public class C7889b {
    private static final String TAG = "b";
    private View bwy;
    private Context context;
    private C7892b dRa;
    private ViewGroup dRb;
    private C7893c dRc;
    private Dialog dialog;

    /* renamed from: com.introvd.template.module.iap.business.dialog.b$a */
    public static class C7891a {
        private Context context;
        private C7892b dRa = new C7892b();

        public C7891a(Context context2) {
            this.context = context2;
        }

        /* renamed from: a */
        public C7891a mo32827a(C7893c cVar) {
            this.dRa.dRc = cVar;
            return this;
        }

        public C7889b aCs() {
            return new C7889b(this.context, this.dRa);
        }
    }

    /* renamed from: com.introvd.template.module.iap.business.dialog.b$b */
    public static class C7892b {
        /* access modifiers changed from: private */
        public C7893c dRc;
        /* access modifiers changed from: private */
        public int dRd = R.style.PayDialogStyle;
        /* access modifiers changed from: private */
        public int dRe = R.color.white;
        /* access modifiers changed from: private */
        public int dRf = 0;
        /* access modifiers changed from: private */
        public int dRg = 0;
        /* access modifiers changed from: private */
        public int gravity = 80;
        /* access modifiers changed from: private */
        public int height = -2;
        /* access modifiers changed from: private */
        public int width = -1;
    }

    private C7889b(Context context2, C7892b bVar) {
        if (bVar != null) {
            this.context = context2;
            this.dRa = bVar;
            this.dRc = bVar.dRc;
            if (this.dRc != null) {
                this.dRc.mo32829a(this);
            }
            this.dialog = new Dialog(context2, bVar.dRd);
            this.dialog.setContentView(getRootView());
            Window window = this.dialog.getWindow();
            if (window != null) {
                window.setGravity(bVar.gravity);
                LayoutParams attributes = window.getAttributes();
                if (attributes != null) {
                    attributes.x = bVar.dRf;
                    attributes.y = bVar.dRg;
                    attributes.width = bVar.width;
                    attributes.height = bVar.height;
                    window.setAttributes(attributes);
                }
            }
            m22979Oj();
            return;
        }
        throw new IllegalArgumentException("DialogParam can't be null.");
    }

    /* renamed from: Oj */
    private void m22979Oj() {
        aCp();
        aCr();
        aCq();
    }

    private void aCp() {
        View b = this.dRc.mo32634b(this.context, getContainer());
        if (b == null) {
            Log.e(TAG, "head view is null.");
            return;
        }
        if (getContainer().getChildCount() > 0) {
            getContainer().addView(b, 0);
        } else {
            getContainer().addView(b);
        }
    }

    private void aCq() {
        View e = this.dRc.mo32831e(this.context, getContainer());
        if (e == null) {
            Log.e(TAG, "foot view is null.");
        } else {
            getContainer().addView(e);
        }
    }

    private void aCr() {
        List<View> c = this.dRc.mo32635c(this.context, getContainer());
        if (c != null && !c.isEmpty()) {
            for (View view : c) {
                if (view == null || view.getParent() != null) {
                    Log.e(TAG, "item view is null or item has parent.");
                } else {
                    getContainer().addView(view);
                }
            }
        }
    }

    private ViewGroup getContainer() {
        if (this.dRb == null) {
            this.dRb = (ViewGroup) getRootView().findViewById(R.id.ll_container);
            ViewGroup.LayoutParams layoutParams = this.dRb.getLayoutParams();
            layoutParams.height = this.dRa.height;
            this.dRb.setLayoutParams(layoutParams);
            if (this.dRa.dRe > 0) {
                this.dRb.setBackgroundResource(this.dRa.dRe);
            }
        }
        return this.dRb;
    }

    private View getRootView() {
        if (this.bwy == null) {
            this.bwy = LayoutInflater.from(this.context).inflate(R.layout.iap_vip_view_dialog_pay_channel_group, null);
        }
        return this.bwy;
    }

    public void dismiss() {
        this.dialog.dismiss();
    }

    public boolean isShowing() {
        return this.dialog.isShowing();
    }

    public void setOnDismissListener(OnDismissListener onDismissListener) {
        this.dialog.setOnDismissListener(onDismissListener);
    }

    public void show() {
        this.dialog.show();
    }
}
