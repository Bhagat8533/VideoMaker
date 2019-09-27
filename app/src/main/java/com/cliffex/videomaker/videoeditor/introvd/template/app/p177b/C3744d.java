package com.introvd.template.app.p177b;

import android.app.Activity;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.p021v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.introvd.template.apicore.C3624b;
import com.introvd.template.apicore.C3628f;
import com.introvd.template.app.C3740b;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.router.BizServiceManager;
import com.introvd.template.router.app.IFreezeService;
import com.introvd.template.router.app.device.DeviceLoginCallback;
import com.introvd.template.router.app.device.DeviceUserProxy;
import com.introvd.template.router.user.IAccountAPI;
import com.introvd.template.router.user.UserServiceProxy;
import com.introvd.template.router.user.model.LoginErrorResponse;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
import p037b.p050b.C1834l;
import p037b.p050b.C1842q;
import p037b.p050b.p051a.p053b.C1487a;
import p037b.p050b.p054b.C1495b;

/* renamed from: com.introvd.template.app.b.d */
public class C3744d implements C3628f {
    private Application application;
    /* access modifiers changed from: private */
    public AtomicBoolean bnP = new AtomicBoolean(false);
    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if ("ACTION_token_invalid".equals(action)) {
                C3744d.this.m9184JW();
            } else if ("action_refresh_device_token".equals(action)) {
                String stringExtra = intent.getStringExtra("e");
                String stringExtra2 = intent.getStringExtra("device_h");
                if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                    C3624b.m8865GC().mo22947cB(stringExtra);
                    C3624b.m8865GC().mo22951cV(stringExtra2);
                }
            }
        }
    };

    public C3744d(Application application2) {
        this.application = application2;
    }

    /* access modifiers changed from: private */
    /* renamed from: JW */
    public void m9184JW() {
        if (!this.bnP.get()) {
            this.bnP.set(true);
            DeviceUserProxy.deviceLogin(new DeviceLoginCallback() {
                public void onResult() {
                    C3744d.this.mo23188bt(true);
                    C3744d.this.bnP.set(false);
                }
            });
        }
    }

    /* renamed from: JV */
    public void mo23187JV() {
        if (this.application != null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("ACTION_token_invalid");
            intentFilter.addAction("action_refresh_device_token");
            LocalBroadcastManager.getInstance(this.application).registerReceiver(this.broadcastReceiver, intentFilter);
        }
    }

    /* renamed from: a */
    public void mo22968a(Activity activity, String str) {
        final LoginErrorResponse loginErrorResponse;
        try {
            loginErrorResponse = (LoginErrorResponse) new Gson().fromJson(str, LoginErrorResponse.class);
        } catch (Exception unused) {
            loginErrorResponse = null;
        }
        if (loginErrorResponse != null) {
            int i = loginErrorResponse.errorCode;
            if (i != 50) {
                if (i != 105 && i != 203) {
                    switch (i) {
                        case 101:
                        case 102:
                            UserServiceProxy.clearUserInfo();
                            break;
                    }
                } else {
                    final WeakReference Hf = C3740b.m9101He().mo23111Hf();
                    if (!(Hf == null || Hf.get() == null)) {
                        C1834l.m5257ah(Boolean.valueOf(true)).mo10152c(C1487a.aUa()).mo10149b((C1842q<? super T>) new C1842q<Boolean>() {
                            /* renamed from: a */
                            public void mo9877a(C1495b bVar) {
                            }

                            /* renamed from: b */
                            public void mo9886K(Boolean bool) {
                                LogUtilsV2.m14230i("start device freeze page");
                                IFreezeService iFreezeService = (IFreezeService) BizServiceManager.getService(IFreezeService.class);
                                if (iFreezeService != null) {
                                    iFreezeService.showFreezeDialog((Context) Hf.get(), UserServiceProxy.getUserId(), loginErrorResponse.errorCode);
                                }
                            }

                            public void onComplete() {
                            }

                            public void onError(Throwable th) {
                            }
                        });
                    }
                }
            } else {
                C3624b.m8865GC().mo22943GE();
                C3624b.m8865GC().mo22944GF();
                m9184JW();
            }
        }
    }

    /* renamed from: bt */
    public void mo23188bt(boolean z) {
        IAccountAPI iAccountAPI = (IAccountAPI) BizServiceManager.getService(IAccountAPI.class);
        if (iAccountAPI != null) {
            iAccountAPI.refreshUserToken(z);
        }
    }
}
