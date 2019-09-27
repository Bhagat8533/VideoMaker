package com.introvd.template.app.youngermode;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.introvd.template.common.ResultListener;
import com.introvd.template.p203b.C4584e;
import com.introvd.template.router.AppRouter;
import java.util.Date;

/* renamed from: com.introvd.template.app.youngermode.b */
public class C4553b {
    private static volatile C4553b bKe;
    /* access modifiers changed from: private */
    public boolean bKa;
    private boolean bKb = false;
    /* access modifiers changed from: private */
    public boolean bKc = false;
    /* access modifiers changed from: private */
    public boolean bKd = false;
    private ResultListener bKf;
    /* access modifiers changed from: private */
    public Runnable bKg = new Runnable() {
        public void run() {
            if (C4553b.this.bKa != C4553b.this.bKc) {
                C4553b.this.m11499if(1000);
                C4553b.this.bKc = C4553b.this.bKa;
            } else if (C4553b.this.bKa) {
                C4553b.this.m11499if(5000);
            } else {
                C4553b.this.mHandler.removeCallbacks(C4553b.this.bKg);
            }
        }
    };
    private Context mContext;
    /* access modifiers changed from: private */
    public Handler mHandler = new Handler(Looper.getMainLooper());

    private C4553b() {
    }

    /* renamed from: RJ */
    public static C4553b m11491RJ() {
        if (bKe == null) {
            synchronized (C4553b.class) {
                if (bKe == null) {
                    bKe = new C4553b();
                }
            }
        }
        return bKe;
    }

    /* access modifiers changed from: private */
    /* renamed from: if */
    public void m11499if(int i) {
        if (!C4584e.m11678b(new Date(C4560d.m11516RN().mo24808RQ()))) {
            C4560d.m11516RN().mo24809RR();
            C4560d.m11516RN().mo24805R(System.currentTimeMillis());
            C4560d.m11516RN().mo24813cc(false);
        }
        if (!C4545a.m11475RF() || C4560d.m11516RN().mo24810RS()) {
            long j = (long) i;
            if (!C4560d.m11516RN().mo24803P(j)) {
                AppRouter.startYoungerModeSetting(this.mContext, 3);
                this.mHandler.removeCallbacks(this.bKg);
                this.bKd = false;
                return;
            }
            this.mHandler.postDelayed(this.bKg, j);
            return;
        }
        C4560d.m11516RN().mo24803P(2400000);
        AppRouter.startYoungerModeSetting(this.mContext, 4);
        this.mHandler.removeCallbacks(this.bKg);
        this.bKd = false;
    }

    /* renamed from: RK */
    public void mo24785RK() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }

    /* renamed from: RL */
    public ResultListener mo24786RL() {
        return this.bKf;
    }

    /* renamed from: a */
    public void mo24787a(ResultListener resultListener) {
        this.bKf = resultListener;
    }

    /* renamed from: bY */
    public void mo24788bY(boolean z) {
        this.bKd = z;
    }

    /* renamed from: bZ */
    public void mo24789bZ(boolean z) {
        this.bKa = z;
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.bKg);
            this.mHandler.postDelayed(this.bKg, 1000);
        }
    }

    public void init(Context context) {
        this.mContext = context;
        if (C4560d.m11516RN().isYoungerMode() && this.bKd) {
            mo24789bZ(true);
        }
        ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            public void onActivityCreated(Activity activity, Bundle bundle) {
            }

            public void onActivityDestroyed(Activity activity) {
            }

            public void onActivityPaused(Activity activity) {
                if (C4560d.m11516RN().isYoungerMode() && C4553b.this.bKd) {
                    C4553b.this.mo24789bZ(false);
                }
            }

            public void onActivityResumed(Activity activity) {
                if (C4560d.m11516RN().isYoungerMode() && C4553b.this.bKd) {
                    C4553b.this.mo24789bZ(true);
                }
            }

            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            }

            public void onActivityStarted(Activity activity) {
            }

            public void onActivityStopped(Activity activity) {
            }
        });
    }
}
