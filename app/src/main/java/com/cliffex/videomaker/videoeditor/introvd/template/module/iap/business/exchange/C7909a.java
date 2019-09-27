package com.introvd.template.module.iap.business.exchange;

import android.app.Activity;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import java.lang.ref.WeakReference;

/* renamed from: com.introvd.template.module.iap.business.exchange.a */
public class C7909a {
    private WeakReference<Activity> activityRef;
    /* access modifiers changed from: private */
    public WeakReference<View> dSk;
    /* access modifiers changed from: private */
    public WeakReference<C7913b> dSl;
    private OnGlobalLayoutListener dSm;

    /* renamed from: com.introvd.template.module.iap.business.exchange.a$a */
    private class C7911a implements OnGlobalLayoutListener {
        int dSn;
        boolean dSo;
        boolean dSp;

        private C7911a() {
        }

        public void onGlobalLayout() {
            if (this.dSn == 0) {
                this.dSn = ((View) C7909a.this.dSk.get()).getHeight();
                return;
            }
            if (this.dSn > ((View) C7909a.this.dSk.get()).getHeight()) {
                if (C7909a.this.dSl.get() != null && (!this.dSo || !this.dSp)) {
                    this.dSp = true;
                    ((C7913b) C7909a.this.dSl.get()).mo32866sy(this.dSn - ((View) C7909a.this.dSk.get()).getHeight());
                }
            } else if (!this.dSo || this.dSp) {
                this.dSp = false;
                ((View) C7909a.this.dSk.get()).post(new Runnable() {
                    public void run() {
                        if (C7909a.this.dSl.get() != null) {
                            ((C7913b) C7909a.this.dSl.get()).aCU();
                        }
                    }
                });
            }
            this.dSo = true;
        }
    }

    /* renamed from: com.introvd.template.module.iap.business.exchange.a$b */
    public interface C7913b {
        void aCU();

        /* renamed from: sy */
        void mo32866sy(int i);
    }

    public C7909a(Activity activity) {
        this.activityRef = new WeakReference<>(activity);
        initialize();
    }

    private boolean aCT() {
        return (((Activity) this.activityRef.get()).getWindow().getAttributes().softInputMode & 16) != 0;
    }

    private void initialize() {
        if (aCT()) {
            this.dSm = new C7911a();
            this.dSk = new WeakReference<>(((Activity) this.activityRef.get()).findViewById(16908290));
            ((View) this.dSk.get()).getViewTreeObserver().addOnGlobalLayoutListener(this.dSm);
            return;
        }
        throw new IllegalArgumentException(String.format("Activity %s should have windowSoftInputMode=\"adjustResize\"to make KeyboardWatcher working. You can set it in AppAndroidManifest.xml", new Object[]{((Activity) this.activityRef.get()).getClass().getSimpleName()}));
    }

    /* renamed from: a */
    public void mo32871a(C7913b bVar) {
        this.dSl = new WeakReference<>(bVar);
    }

    public void destroy() {
        if (this.dSk.get() == null) {
            return;
        }
        if (VERSION.SDK_INT >= 16) {
            ((View) this.dSk.get()).getViewTreeObserver().removeOnGlobalLayoutListener(this.dSm);
        } else {
            ((View) this.dSk.get()).getViewTreeObserver().removeGlobalOnLayoutListener(this.dSm);
        }
    }
}
